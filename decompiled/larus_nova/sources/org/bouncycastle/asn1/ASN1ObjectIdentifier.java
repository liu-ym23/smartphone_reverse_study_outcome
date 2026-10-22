package org.bouncycastle.asn1;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1ObjectIdentifier extends ASN1Primitive {
    private static final long LONG_LIMIT = 72057594037927808L;
    private static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = null;
    private byte[] body;
    private final String identifier;

    public static class OidHandle {

        /* JADX INFO: renamed from: enc, reason: collision with root package name */
        private final byte[] f525021enc;
        private final int key;

        public OidHandle(byte[] r100) {
            this.key = Arrays.hashCode(r100);
            this.f525021enc = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof OidHandle) == true) goto L5;
            return false;
        L5:
            return Arrays.areEqual(this.f525021enc, ((OidHandle) r100).f525021enc);
        }

        public int hashCode() {
            return this.key;
        }
    }

    static {
        pool = new ConcurrentHashMap();
    }

    public ASN1ObjectIdentifier(String r100) {
        if (r100 == null) goto L11;
        if (isValidIdentifier(r100) == false) goto L9;
        this.identifier = r100;
        return;
    L9:
        throw new IllegalArgumentException("string " + r100 + " not an OID");
    L11:
        throw new NullPointerException("'identifier' cannot be null");
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier r100, String r101) {
        if (isValidBranchID(r101, 0) == false) goto L7;
        this.identifier = r100.getId() + "." + r101;
        return;
    L7:
        throw new IllegalArgumentException("string " + r101 + " not a valid OID branch");
    }

    public ASN1ObjectIdentifier(byte[] r210) {
        StringBuffer r100 = new StringBuffer();
        boolean r101 = true;
        BigInteger r110 = null;
        int r102 = 0;
        long r103 = 0;
    L4:
        if (r102 == r210.length) goto L30;
        int r111 = r210[r102] & UByte.MAX_VALUE;
        if (r103 > LONG_LIMIT) goto L21;
        long r104 = r103 + ((long) (r111 & 127));
        if ((r111 & 128) != 0) goto L20;
        if (r101 == true) goto L11;
    L18:
        r100.append('.');
        r100.append(r104);
    L19:
        r103 = 0;
    L29:
        r102 = r102 + 1;
        goto L4
    L11:
        if (r104 >= 40) goto L14;
        r100.append('0');
    L17:
        r101 = false;
        goto L18
    L14:
        if (r104 >= 80) goto L16;
        r100.append('1');
        r104 = r104 - 40;
        goto L17
    L16:
        r100.append('2');
        r104 = r104 - 80;
        goto L17
    L20:
        r103 = r104 << 7;
        goto L29
    L21:
        if (r110 != null) goto L23;
        r110 = BigInteger.valueOf(r103);
    L23:
        BigInteger r112 = r110.or(BigInteger.valueOf(r111 & 127));
        if ((r111 & 128) != 0) goto L28;
        if (r101 == false) goto L27;
        r100.append('2');
        r112 = r112.subtract(BigInteger.valueOf(80));
        r101 = false;
    L27:
        r100.append('.');
        r100.append(r112);
        r110 = null;
        goto L19
    L28:
        r110 = r112.shiftLeft(7);
        goto L29
    L30:
        this.identifier = r100.toString();
        this.body = Arrays.clone(r210);
    }

    private void doOutput(ByteArrayOutputStream r100) {
        OIDTokenizer r101 = new OIDTokenizer(this.identifier);
        int r102 = CastIntegerProtector.parseInt(r101.nextToken()) * 40;
        String r103 = r101.nextToken();
        if (r103.length() > 18) goto L5;
        writeField(r100, ((long) r102) + CastLongProtector.parseLong(r103));
    L7:
        if (r101.hasMoreTokens() == false) goto L12;
        String r104 = r101.nextToken();
        if (r104.length() <= 18) goto L10;
        writeField(r100, new BigInteger(r104));
        goto L7
    L10:
        writeField(r100, CastLongProtector.parseLong(r104));
        goto L7
    L12:
        return;
    L5:
        writeField(r100, new BigInteger(r103).add(BigInteger.valueOf(r102)));
        goto L7
    }

    public static ASN1ObjectIdentifier fromOctetString(byte[] r100) {
        OidHandle r101 = new OidHandle(r100);
        ASN1ObjectIdentifier r102 = pool.get(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return new ASN1ObjectIdentifier(r100);
    }

    private synchronized byte[] getBody() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.body != null) goto L6;
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        doOutput(r100);     // Catch: Throwable -> L9
        this.body = r100.toByteArray();     // Catch: Throwable -> L9
    L6:
        byte[] r101 = this.body;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r101;
    }

    public static ASN1ObjectIdentifier getInstance(Object r100) {
        if (r100 == null) goto L23;
        if ((r100 instanceof ASN1ObjectIdentifier) == true) goto L23;
        if ((r100 instanceof ASN1Encodable) == false) goto L13;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1ObjectIdentifier) == false) goto L13;
        return (ASN1ObjectIdentifier) r101;
    L13:
        if ((r100 instanceof byte[]) == false) goto L21;
        return (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray((byte[]) r100);
    L17:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
    L21:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L23:
        return (ASN1ObjectIdentifier) r100;
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof ASN1ObjectIdentifier) == true) goto L10;
        return fromOctetString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    private static boolean isValidBranchID(String r100, int r101) {
        int r102 = r100.length();
    L3:
        int r103 = 0;
    L4:
        r102 = r102 - 1;
        if (r102 < r101) goto L18;
        char r104 = r100.charAt(r102);
        if (r104 == '.') goto L8;
        if ('0' > r104) goto L17;
        if (r104 > '9') goto L17;
        r103 = r103 + 1;
    L17:
        return false;
    L8:
        if (r103 == 0) goto L12;
        if (r103 <= 1) goto L3;
        if (r100.charAt(r102 + 1) != '0') goto L3;
    L12:
        return false;
    L18:
        if (r103 == 0) goto L24;
        if (r103 > 1) goto L21;
    L23:
        return true;
    L21:
        if (r100.charAt(r102 + 1) != '0') goto L23;
    L24:
        return false;
    }

    private static boolean isValidIdentifier(String r100) {
        if (r100.length() >= 3) goto L5;
    L14:
        return false;
    L5:
        if (r100.charAt(1) != '.') goto L14;
        char r101 = r100.charAt(0);
        if (r101 < '0') goto L14;
        if (r101 > '2') goto L14;
        return isValidBranchID(r100, 2);
    }

    private void writeField(ByteArrayOutputStream r100, long r101) {
        byte[] r102 = new byte[9];
        int r103 = 8;
        r102[8] = (byte) (((int) r101) & 127);
    L4:
        if (r101 < 128) goto L6;
        r101 = r101 >> 7;
        r103 = r103 - 1;
        r102[r103] = (byte) ((((int) r101) & 127) | 128);
        goto L4
    L6:
        r100.write(r102, r103, 9 - r103);
    }

    private void writeField(ByteArrayOutputStream r100, BigInteger r101) {
        int r102 = (r101.bitLength() + 6) / 7;
        if (r102 != 0) goto L5;
        r100.write(0);
        return;
    L5:
        byte[] r103 = new byte[r102];
        int r104 = r102 - 1;
        int r105 = r104;
    L6:
        if (r105 < 0) goto L8;
        r103[r105] = (byte) ((r101.intValue() & 127) | 128);
        r101 = r101.shiftRight(7);
        r105 = r105 - 1;
        goto L6
    L8:
        r103[r104] = (byte) (r103[r104] & ByteCompanionObject.MAX_VALUE);
        r100.write(r103, 0, r102);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ASN1ObjectIdentifier) == true) goto L10;
        return false;
    L10:
        return this.identifier.equals(((ASN1ObjectIdentifier) r100).identifier);
    }

    public ASN1ObjectIdentifier branch(String r100) {
        return new ASN1ObjectIdentifier(this, r100);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 6, getBody());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int r100 = getBody().length;
        return (StreamUtil.calculateBodyLength(r100) + 1) + r100;
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        OidHandle r100 = new OidHandle(getBody());
        ConcurrentMap<OidHandle, ASN1ObjectIdentifier> r101 = pool;
        ASN1ObjectIdentifier r102 = r101.get(r100);
        if (r102 != null) goto L8;
        ASN1ObjectIdentifier r103 = r101.putIfAbsent(r100, this);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return this;
    L8:
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public boolean on(ASN1ObjectIdentifier r100) {
        String r101 = getId();
        String r102 = r100.getId();
        if (r101.length() > r102.length()) goto L5;
    L9:
        return false;
    L5:
        if (r101.charAt(r102.length()) != '.') goto L9;
        if (r101.startsWith(r102) == false) goto L9;
        return true;
    }

    public String toString() {
        return getId();
    }
}
