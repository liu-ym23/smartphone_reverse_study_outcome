package org.bouncycastle.jcajce.provider.keystore.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.io.DigestInputStream;
import org.bouncycastle.crypto.io.DigestOutputStream;
import org.bouncycastle.crypto.io.MacInputStream;
import org.bouncycastle.crypto.io.MacOutputStream;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.io.CipherInputStream;
import org.bouncycastle.jcajce.io.CipherOutputStream;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;
import org.bouncycastle.util.io.TeeOutputStream;

/* JADX INFO: loaded from: classes42.dex */
public class BcKeyStoreSpi extends KeyStoreSpi implements BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    private static final String KEY_CIPHER = "PBEWithSHAAnd3-KeyTripleDES-CBC";
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    private static final int KEY_SALT_SIZE = 20;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    static final int NULL = 0;
    static final int SEALED = 4;
    static final int SECRET = 3;
    private static final String STORE_CIPHER = "PBEWithSHAAndTwofish-CBC";
    private static final int STORE_SALT_SIZE = 20;
    private static final int STORE_VERSION = 2;
    private final JcaJceHelper helper;
    protected SecureRandom random;
    protected Hashtable table;
    protected int version;

    public static class BCKeyStoreException extends KeyStoreException {
        private final Exception cause;

        public BCKeyStoreException(String r100, Exception r101) {
            super(r100);
            this.cause = r101;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public static class BouncyCastleStore extends BcKeyStoreSpi {
        public BouncyCastleStore() {
            super(1);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi, java.security.KeyStoreSpi
        public void engineLoad(InputStream r100, char[] r110) throws IOException {
            this.table.clear();
            if (r100 != null) goto L5;
            return;
        L5:
            DataInputStream r101 = new DataInputStream(r100);
            int r102 = r101.readInt();
            if (r102 == 2) goto L13;
            if (r102 == 0) goto L13;
            if (r102 == 1) goto L13;
            throw new IOException("Wrong version of key store.");
        L13:
            int r103 = r101.readInt();
            byte[] r104 = new byte[r103];
            if (r103 != 20) goto L30;
            r101.readFully(r104);
            int r105 = r101.readInt();
            if (r105 < 0) goto L28;
            if (r105 > 65536) goto L28;
            if (r102 != 0) goto L21;
            String r106 = "OldPBEWithSHAAndTwofish-CBC";
        L22:
            CipherInputStream r111 = new CipherInputStream(r101, makePBECipher(r106, 2, r110, r104, r105));
            SHA1Digest r107 = new SHA1Digest();
            loadStore(new DigestInputStream(r111, r107));
            byte[] r108 = new byte[r107.getDigestSize()];
            r107.doFinal(r108, 0);
            byte[] r109 = new byte[r107.getDigestSize()];
            Streams.readFully(r111, r109);
            if (Arrays.constantTimeAreEqual(r108, r109) == false) goto L25;
            return;
        L25:
            this.table.clear();
            throw new IOException("KeyStore integrity check failed.");
        L21:
            r106 = BcKeyStoreSpi.STORE_CIPHER;
        L28:
            throw new IOException("Key store corrupted.");
        L30:
            throw new IOException("Key store corrupted.");
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi, java.security.KeyStoreSpi
        public void engineStore(OutputStream r100, char[] r101) throws IOException {
            DataOutputStream r102 = new DataOutputStream(r100);
            byte[] r103 = new byte[20];
            int r104 = (this.random.nextInt() & 1023) + 1024;
            this.random.nextBytes(r103);
            r102.writeInt(this.version);
            r102.writeInt(20);
            r102.write(r103);
            r102.writeInt(r104);
            CipherOutputStream r105 = new CipherOutputStream(r102, makePBECipher(BcKeyStoreSpi.STORE_CIPHER, 1, r101, r103, r104));
            DigestOutputStream r106 = new DigestOutputStream(new SHA1Digest());
            saveStore(new TeeOutputStream(r105, r106));
            r105.write(r106.getDigest());
            r105.close();
        }
    }

    public static class Std extends BcKeyStoreSpi {
        public Std() {
            super(2);
        }
    }

    public class StoreEntry {
        String alias;
        Certificate[] certChain;
        Date date;
        Object obj;
        final /* synthetic */ BcKeyStoreSpi this$0;
        int type;

        public StoreEntry(BcKeyStoreSpi r100, String r101, Key r110, char[] r111, Certificate[] r112) throws Exception {
            this.this$0 = r100;
            this.date = new Date();
            this.type = 4;
            this.alias = r101;
            this.certChain = r112;
            byte[] r102 = new byte[20];
            r100.random.nextBytes(r102);
            int r103 = (r100.random.nextInt() & 1023) + 1024;
            ByteArrayOutputStream r113 = new ByteArrayOutputStream();
            DataOutputStream r104 = new DataOutputStream(r113);
            r104.writeInt(20);
            r104.write(r102);
            r104.writeInt(r103);
            DataOutputStream r105 = new DataOutputStream(new CipherOutputStream(r104, r100.makePBECipher(BcKeyStoreSpi.KEY_CIPHER, 1, r111, r102, r103)));
            BcKeyStoreSpi.access$000(r100, r110, r105);
            r105.close();
            this.obj = r113.toByteArray();
        }

        public StoreEntry(BcKeyStoreSpi r100, String r101, Certificate r102) {
            this.this$0 = r100;
            this.date = new Date();
            this.type = 1;
            this.alias = r101;
            this.obj = r102;
            this.certChain = null;
        }

        public StoreEntry(BcKeyStoreSpi r100, String r101, Date r102, int r103, Object r104) {
            this.this$0 = r100;
            new Date();
            this.alias = r101;
            this.date = r102;
            this.type = r103;
            this.obj = r104;
        }

        public StoreEntry(BcKeyStoreSpi r100, String r101, Date r102, int r103, Object r104, Certificate[] r105) {
            this.this$0 = r100;
            new Date();
            this.alias = r101;
            this.date = r102;
            this.type = r103;
            this.obj = r104;
            this.certChain = r105;
        }

        public StoreEntry(BcKeyStoreSpi r100, String r101, byte[] r102, Certificate[] r103) {
            this.this$0 = r100;
            this.date = new Date();
            this.type = 3;
            this.alias = r101;
            this.obj = r102;
            this.certChain = r103;
        }

        public String getAlias() {
            return this.alias;
        }

        public Certificate[] getCertificateChain() {
            return this.certChain;
        }

        public Date getDate() {
            return this.date;
        }

        public Object getObject() {
            return this.obj;
        }

        public Object getObject(char[] r110) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            if (r110 != null) goto L5;
        L6:
            Object r100 = this.obj;
            if ((r100 instanceof Key) == false) goto L10;
            return r100;
        L10:
            if (this.type != 4) goto L27;
            DataInputStream r101 = new DataInputStream(new ByteArrayInputStream((byte[]) this.obj));
            byte[] r102 = new byte[r101.readInt()];     // Catch: Exception -> L24
            r101.readFully(r102);     // Catch: Exception -> L24
            int r103 = r101.readInt();     // Catch: Exception -> L24
            CipherInputStream r104 = new CipherInputStream(r101, this.this$0.makePBECipher(BcKeyStoreSpi.KEY_CIPHER, 2, r110, r102, r103));     // Catch: Exception -> L24
            return BcKeyStoreSpi.access$100(this.this$0, new DataInputStream(r104));
        L15:
            DataInputStream r105 = new DataInputStream(new ByteArrayInputStream((byte[]) this.obj));     // Catch: Exception -> L24
            byte[] r106 = new byte[r105.readInt()];     // Catch: Exception -> L24
            r105.readFully(r106);     // Catch: Exception -> L24
            int r107 = r105.readInt();     // Catch: Exception -> L24
            CipherInputStream r108 = new CipherInputStream(r105, this.this$0.makePBECipher("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, r110, r106, r107));     // Catch: Exception -> L24
            Key r109 = BcKeyStoreSpi.access$100(this.this$0, new DataInputStream(r108));     // Catch: Exception -> L18
        L17:
            byte[] r111 = r106;
            int r112 = r107;
            if (r109 == null) goto L23;
            ByteArrayOutputStream r113 = new ByteArrayOutputStream();     // Catch: Exception -> L24
            DataOutputStream r114 = new DataOutputStream(r113);     // Catch: Exception -> L24
            r114.writeInt(r111.length);     // Catch: Exception -> L24
            r114.write(r111);     // Catch: Exception -> L24
            r114.writeInt(r112);     // Catch: Exception -> L24
            DataOutputStream r115 = new DataOutputStream(new CipherOutputStream(r114, this.this$0.makePBECipher(BcKeyStoreSpi.KEY_CIPHER, 1, r110, r111, r112)));     // Catch: Exception -> L24
            BcKeyStoreSpi.access$000(this.this$0, r109, r115);     // Catch: Exception -> L24
            r115.close();     // Catch: Exception -> L24
            this.obj = r113.toByteArray();     // Catch: Exception -> L24
            return r109;
        L23:
            throw new UnrecoverableKeyException("no match");     // Catch: Exception -> L24
        L18:
            DataInputStream r116 = new DataInputStream(new ByteArrayInputStream((byte[]) this.obj));     // Catch: Exception -> L24
            r106 = new byte[r116.readInt()];     // Catch: Exception -> L24
            r116.readFully(r106);     // Catch: Exception -> L24
            r107 = r116.readInt();     // Catch: Exception -> L24
            CipherInputStream r117 = new CipherInputStream(r116, this.this$0.makePBECipher("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, r110, r106, r107));     // Catch: Exception -> L24
            r109 = BcKeyStoreSpi.access$100(this.this$0, new DataInputStream(r117));     // Catch: Exception -> L24
        L25:
            throw new UnrecoverableKeyException("no match");
        L27:
            throw new RuntimeException("forget something!");
        L5:
            if (r110.length != 0) goto L10;
            goto L6
        }

        public int getType() {
            return this.type;
        }
    }

    public static class Version1 extends BcKeyStoreSpi {
        public Version1() {
            super(1);
        }
    }

    public BcKeyStoreSpi(int r100) {
        this.table = new Hashtable();
        this.random = CryptoServicesRegistrar.getSecureRandom();
        this.helper = new BCJcaJceHelper();
        this.version = r100;
    }

    public static /* synthetic */ void access$000(BcKeyStoreSpi r100, Key r101, DataOutputStream r102) throws IOException {
        r100.encodeKey(r101, r102);
    }

    public static /* synthetic */ Key access$100(BcKeyStoreSpi r100, DataInputStream r101) throws IOException {
        return r100.decodeKey(r101);
    }

    private Certificate decodeCertificate(DataInputStream r100) throws IOException {
        String r101 = r100.readUTF();
        byte[] r102 = new byte[r100.readInt()];
        r100.readFully(r102);
        return this.helper.createCertificateFactory(r101).generateCertificate(new ByteArrayInputStream(r102));
    L8:
        e = move-exception;
        throw new IOException(e.toString());
    L5:
        e = move-exception;
        throw new IOException(e.toString());
    }

    private Key decodeKey(DataInputStream r100) throws IOException {
        int r101 = r100.read();
        String r102 = r100.readUTF();
        String r103 = r100.readUTF();
        byte[] r104 = new byte[r100.readInt()];
        r100.readFully(r104);
        if (r102.equals("PKCS#8") == false) goto L5;
    L19:
        KeySpec r105 = new PKCS8EncodedKeySpec(r104);
    L36:
        if (r101 == 0) goto L32;
        if (r101 == 1) goto L30;
        if (r101 != 2) goto L28;
        return this.helper.createSecretKeyFactory(r103).generateSecret(r105);
    L28:
        throw new IOException("Key type " + r101 + " not recognised!");     // Catch: Exception -> L33
    L30:
        return BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(r104));
    L32:
        return BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(r104));
    L33:
        e = move-exception;
        throw new IOException("Exception creating key: " + e.toString());
    L5:
        if (r102.equals("PKCS8") == true) goto L19;
        if (r102.equals("X.509") == false) goto L10;
    L18:
        r105 = new X509EncodedKeySpec(r104);
        goto L36
    L10:
        if (r102.equals("X509") == true) goto L18;
        if (r102.equals("RAW") == false) goto L17;
        return new SecretKeySpec(r104, r103);
    L17:
        throw new IOException("Key format " + r102 + " not recognised!");
    }

    private void encodeCertificate(Certificate r100, DataOutputStream r101) throws IOException {
        byte[] r102 = r100.getEncoded();     // Catch: CertificateEncodingException -> L4
        r101.writeUTF(r100.getType());     // Catch: CertificateEncodingException -> L4
        r101.writeInt(r102.length);     // Catch: CertificateEncodingException -> L4
        r101.write(r102);     // Catch: CertificateEncodingException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    private void encodeKey(Key r100, DataOutputStream r101) throws IOException {
        byte[] r102 = r100.getEncoded();
        if ((r100 instanceof PrivateKey) == false) goto L7;
        int r103 = 0;
    L5:
        r101.write(r103);
        r101.writeUTF(r100.getFormat());
        r101.writeUTF(r100.getAlgorithm());
        r101.writeInt(r102.length);
        r101.write(r102);
        return;
    L7:
        if ((r100 instanceof PublicKey) == false) goto L9;
        r103 = 1;
        goto L5
    L9:
        r103 = 2;
        goto L5
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        return this.table.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String r100) {
        if (this.table.get(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String r100) throws KeyStoreException {
        if (this.table.get(r100) != null) goto L5;
        return;
    L5:
        this.table.remove(r100);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String r100) {
        StoreEntry r101 = (StoreEntry) this.table.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getType() == 1) goto L7;
        Certificate[] r102 = r101.getCertificateChain();
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102[0];
    L7:
        return (Certificate) r101.getObject();
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate r100) {
        Enumeration r101 = this.table.elements();
    L4:
        if (r101.hasMoreElements() == false) goto L17;
        StoreEntry r102 = (StoreEntry) r101.nextElement();
        if ((r102.getObject() instanceof Certificate) == true) goto L8;
        Certificate[] r103 = r102.getCertificateChain();
        if (r103 == null) goto L4;
        if (r103[0].equals(r100) == false) goto L4;
        return r102.getAlias();
    L8:
        if (((Certificate) r102.getObject()).equals(r100) == false) goto L4;
        return r102.getAlias();
    L17:
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String r100) {
        StoreEntry r101 = (StoreEntry) this.table.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getCertificateChain();
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String r100) {
        StoreEntry r101 = (StoreEntry) this.table.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getDate();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String r100, char[] r101) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        StoreEntry r102 = (StoreEntry) this.table.get(r100);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.getType() != 1) goto L8;
        return null;
    L8:
        return (Key) r102.getObject(r101);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String r100) {
        StoreEntry r101 = (StoreEntry) this.table.get(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getType() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String r100) {
        StoreEntry r101 = (StoreEntry) this.table.get(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getType() == 1) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream r100, char[] r101) throws IOException {
        this.table.clear();
        if (r100 != null) goto L5;
        return;
    L5:
        DataInputStream r102 = new DataInputStream(r100);
        int r103 = r102.readInt();
        if (r103 == 2) goto L13;
        if (r103 == 0) goto L13;
        if (r103 == 1) goto L13;
        throw new IOException("Wrong version of key store.");
    L13:
        int r104 = r102.readInt();
        if (r104 <= 0) goto L31;
        byte[] r105 = new byte[r104];
        r102.readFully(r105);
        int r106 = r102.readInt();
        HMac r107 = new HMac(new SHA1Digest());
        if (r101 != null) goto L18;
    L28:
        loadStore(r102);
        r102.readFully(new byte[r107.getMacSize()]);
        return;
    L18:
        if (r101.length == 0) goto L28;
        byte[] r108 = PBEParametersGenerator.PKCS12PasswordToBytes(r101);
        PKCS12ParametersGenerator r109 = new PKCS12ParametersGenerator(new SHA1Digest());
        r109.init(r108, r105, r106);
        if (r103 == 2) goto L22;
        int r110 = r107.getMacSize();
    L23:
        CipherParameters r111 = r109.generateDerivedMacParameters(r110);
        Arrays.fill(r108, (byte) 0);
        r107.init(r111);
        loadStore(new MacInputStream(r102, r107));
        byte[] r112 = new byte[r107.getMacSize()];
        r107.doFinal(r112, 0);
        byte[] r113 = new byte[r107.getMacSize()];
        r102.readFully(r113);
        if (Arrays.constantTimeAreEqual(r112, r113) == true) goto L32;
        this.table.clear();
        throw new IOException("KeyStore integrity check failed.");
    L32:
        return;
    L22:
        r110 = r107.getMacSize() * 8;
        goto L23
    L31:
        throw new IOException("Invalid salt detected");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String r100, Certificate r101) throws KeyStoreException {
        StoreEntry r102 = (StoreEntry) this.table.get(r100);
        if (r102 != null) goto L5;
    L9:
        this.table.put(r100, new StoreEntry(this, r100, r101));
        return;
    L5:
        if (r102.getType() == 1) goto L9;
        throw new KeyStoreException("key store already has a key entry with alias " + r100);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String r100, Key r110, char[] r111, Certificate[] r112) throws KeyStoreException {
        if ((r110 instanceof PrivateKey) == false) goto L13;
        if (r112 != null) goto L13;
        throw new KeyStoreException("no certificate chain for private key");
    L13:
        this.table.put(r100, new StoreEntry(this, r100, r110, r111, r112));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        throw new BCKeyStoreException(e.toString(), e);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String r100, byte[] r101, Certificate[] r102) throws KeyStoreException {
        this.table.put(r100, new StoreEntry(this, r100, r101, r102));
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.table.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream r100, char[] r101) throws IOException {
        DataOutputStream r102 = new DataOutputStream(r100);
        byte[] r103 = new byte[20];
        int r104 = (this.random.nextInt() & 1023) + 1024;
        this.random.nextBytes(r103);
        r102.writeInt(this.version);
        r102.writeInt(20);
        r102.write(r103);
        r102.writeInt(r104);
        HMac r105 = new HMac(new SHA1Digest());
        MacOutputStream r106 = new MacOutputStream(r105);
        PKCS12ParametersGenerator r107 = new PKCS12ParametersGenerator(new SHA1Digest());
        byte[] r108 = PBEParametersGenerator.PKCS12PasswordToBytes(r101);
        r107.init(r108, r103, r104);
        if (this.version >= 2) goto L5;
        int r109 = r105.getMacSize();
    L6:
        r105.init(r107.generateDerivedMacParameters(r109));
        int r110 = 0;
    L8:
        if (r110 == r108.length) goto L10;
        r108[r110] = 0;
        r110 = r110 + 1;
        goto L8
    L10:
        saveStore(new TeeOutputStream(r102, r106));
        byte[] r111 = new byte[r105.getMacSize()];
        r105.doFinal(r111, 0);
        r102.write(r111);
        r102.close();
        return;
    L5:
        r109 = r105.getMacSize() * 8;
        goto L6
    }

    public void loadStore(InputStream r110) throws IOException {
        DataInputStream r100 = new DataInputStream(r110);
        int r101 = r100.read();
    L3:
        if (r101 <= 0) goto L27;
        String r111 = r100.readUTF();
        Date r102 = new Date(r100.readLong());
        int r103 = r100.readInt();
        if (r103 == 0) goto L10;
        Certificate[] r104 = new Certificate[r103];
        int r105 = 0;
    L7:
        if (r105 == r103) goto L9;
        r104[r105] = decodeCertificate(r100);
        r105 = r105 + 1;
        goto L7
    L9:
        Certificate[] r112 = r104;
    L12:
        if (r101 != 1) goto L14;
        Certificate r113 = decodeCertificate(r100);
        Hashtable r106 = this.table;
        StoreEntry r107 = new StoreEntry(this, r111, r102, 1, r113);
    L25:
        r106.put(r111, r107);
    L26:
        r101 = r100.read();
        goto L3
    L14:
        if (r101 != 2) goto L16;
        Key r114 = decodeKey(r100);
        r106 = this.table;
        r107 = new StoreEntry(this, r111, r102, 2, r114, r112);
        goto L25
    L16:
        if (r101 != 3) goto L18;
    L22:
        byte[] r108 = new byte[r100.readInt()];
        r100.readFully(r108);
        this.table.put(r111, new StoreEntry(this, r111, r102, r101, r108, r112));
        goto L26
    L18:
        if (r101 == 4) goto L22;
        throw new IOException("Unknown object type in store.");
    L10:
        r112 = null;
        goto L12
    }

    public Cipher makePBECipher(String r100, int r101, char[] r102, byte[] r103, int r104) throws IOException {
        PBEKeySpec r105 = new PBEKeySpec(r102);     // Catch: Exception -> L4
        SecretKeyFactory r106 = this.helper.createSecretKeyFactory(r100);     // Catch: Exception -> L4
        PBEParameterSpec r107 = new PBEParameterSpec(r103, r104);     // Catch: Exception -> L4
        Cipher r108 = this.helper.createCipher(r100);     // Catch: Exception -> L4
        r108.init(r101, r106.generateSecret(r105), r107);     // Catch: Exception -> L4
        return r108;
    L4:
        e = move-exception;
        throw new IOException("Error initialising store of key store: " + e);
    }

    public void saveStore(OutputStream r100) throws IOException {
        Enumeration r101 = this.table.elements();
        DataOutputStream r102 = new DataOutputStream(r100);
    L3:
        int r103 = 0;
        if (r101.hasMoreElements() == false) goto L26;
        StoreEntry r104 = (StoreEntry) r101.nextElement();
        r102.write(r104.getType());
        r102.writeUTF(r104.getAlias());
        r102.writeLong(r104.getDate().getTime());
        Certificate[] r105 = r104.getCertificateChain();
        if (r105 != null) goto L8;
        r102.writeInt(0);
    L12:
        int r106 = r104.getType();
        if (r106 != 1) goto L15;
        encodeCertificate((Certificate) r104.getObject(), r102);
        goto L3
    L15:
        if (r106 != 2) goto L17;
        encodeKey((Key) r104.getObject(), r102);
        goto L3
    L17:
        if (r106 != 3) goto L19;
    L23:
        byte[] r107 = (byte[]) r104.getObject();
        r102.writeInt(r107.length);
        r102.write(r107);
        goto L3
    L19:
        if (r106 == 4) goto L23;
        throw new IOException("Unknown object type in store.");
    L8:
        r102.writeInt(r105.length);
    L10:
        if (r103 == r105.length) goto L12;
        encodeCertificate(r105[r103], r102);
        r103 = r103 + 1;
        goto L10
    L26:
        r102.write(0);
    }

    @Override // org.bouncycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom r100) {
        this.random = r100;
    }
}
