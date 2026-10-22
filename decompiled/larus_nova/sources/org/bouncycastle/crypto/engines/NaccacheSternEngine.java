package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class NaccacheSternEngine implements AsymmetricBlockCipher {
    private static BigInteger ONE;
    private static BigInteger ZERO;
    private boolean debug;
    private boolean forEncryption;
    private NaccacheSternKeyParameters key;
    private Vector[] lookup;

    static {
        ZERO = BigInteger.valueOf(0);
        ONE = BigInteger.valueOf(1);
    }

    public NaccacheSternEngine() {
        this.lookup = null;
        this.debug = false;
    }

    private static BigInteger chineseRemainder(Vector r100, Vector r101) {
        BigInteger r102 = ZERO;
        BigInteger r103 = ONE;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r101.size()) goto L7;
        r103 = r103.multiply((BigInteger) r101.elementAt(r105));
        r105 = r105 + 1;
    L7:
        if (r104 >= r101.size()) goto L10;
        BigInteger r106 = (BigInteger) r101.elementAt(r104);
        BigInteger r107 = r103.divide(r106);
        r102 = r102.add(r107.multiply(r107.modInverse(r106)).multiply((BigInteger) r100.elementAt(r104)));
        r104 = r104 + 1;
        goto L7
    L10:
        return r102.mod(r103);
    }

    public byte[] addCryptedBlocks(byte[] r100, byte[] r101) throws InvalidCipherTextException {
        if (this.forEncryption == false) goto L12;
        if (r100.length > getOutputBlockSize()) goto L10;
        if (r101.length > getOutputBlockSize()) goto L10;
    L15:
        BigInteger r102 = new BigInteger(1, r100);
        BigInteger r103 = new BigInteger(1, r101);
        BigInteger r104 = r102.multiply(r103).mod(this.key.getModulus());
        if (this.debug == false) goto L18;
        System.out.println("c(m1) as BigInteger:....... " + r102);
        System.out.println("c(m2) as BigInteger:....... " + r103);
        System.out.println("c(m1)*c(m2)%n = c(m1+m2)%n: " + r104);
    L18:
        byte[] r105 = this.key.getModulus().toByteArray();
        Arrays.fill(r105, (byte) 0);
        System.arraycopy(r104.toByteArray(), 0, r105, r105.length - r104.toByteArray().length, r104.toByteArray().length);
        return r105;
    L10:
        throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
    L12:
        if (r100.length > getInputBlockSize()) goto L21;
        if (r101.length <= getInputBlockSize()) goto L15;
    L21:
        throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
    }

    public byte[] encrypt(BigInteger r100) {
        byte[] r101 = this.key.getModulus().toByteArray();
        Arrays.fill(r101, (byte) 0);
        byte[] r102 = this.key.getG().modPow(r100, this.key.getModulus()).toByteArray();
        System.arraycopy(r102, 0, r101, r101.length - r102.length, r102.length);
        if (this.debug == false) goto L5;
        System.out.println("Encrypted value is:  " + new BigInteger(r101));
    L5:
        return r101;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        if (this.forEncryption == false) goto L7;
        return ((this.key.getLowerSigmaBound() + 7) / 8) - 1;
    L7:
        return this.key.getModulus().toByteArray().length;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        if (this.forEncryption == false) goto L7;
        return this.key.getModulus().toByteArray().length;
    L7:
        return ((this.key.getLowerSigmaBound() + 7) / 8) - 1;
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r110, CipherParameters r111) {
        this.forEncryption = r110;
        if ((r111 instanceof ParametersWithRandom) == false) goto L5;
        r111 = ((ParametersWithRandom) r111).getParameters();
    L5:
        this.key = (NaccacheSternKeyParameters) r111;
        if (this.forEncryption == false) goto L8;
        return;
    L8:
        if (this.debug == false) goto L10;
        System.out.println("Constructing lookup Array");
    L10:
        NaccacheSternPrivateKeyParameters r112 = (NaccacheSternPrivateKeyParameters) this.key;
        Vector r113 = r112.getSmallPrimes();
        this.lookup = new Vector[r113.size()];
        int r100 = 0;
    L12:
        if (r100 >= r113.size()) goto L23;
        BigInteger r101 = (BigInteger) r113.elementAt(r100);
        int r102 = r101.intValue();
        this.lookup[r100] = new Vector();
        this.lookup[r100].addElement(ONE);
        if (this.debug == false) goto L16;
        System.out.println("Constructing lookup ArrayList for " + r102);
    L16:
        BigInteger r103 = ZERO;
        int r104 = 1;
    L17:
        if (r104 >= r102) goto L19;
        r103 = r103.add(r112.getPhi_n());
        this.lookup[r100].addElement(r112.getG().modPow(r103.divide(r101), r112.getModulus()));
        r104 = r104 + 1;
        goto L17
    L19:
        r100 = r100 + 1;
        goto L12
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r110) throws InvalidCipherTextException {
        if (this.key == null) goto L50;
        if (r110 > (getInputBlockSize() + 1)) goto L48;
        if (this.forEncryption == false) goto L9;
    L13:
        int r102 = 0;
        if (r101 == 0) goto L16;
    L17:
        byte[] r103 = new byte[r110];
        System.arraycopy(r100, r101, r103, 0, r110);
        r100 = r103;
    L18:
        BigInteger r104 = new BigInteger(1, r100);
        if (this.debug == false) goto L22;
        System.out.println("input as BigInteger: " + r104);
    L22:
        if (this.forEncryption == true) goto L55;
        Vector r105 = new Vector();
        NaccacheSternPrivateKeyParameters r111 = (NaccacheSternPrivateKeyParameters) this.key;
        Vector r106 = r111.getSmallPrimes();
        int r107 = 0;
    L26:
        if (r107 >= r106.size()) goto L46;
        BigInteger r108 = r104.modPow(r111.getPhi_n().divide((BigInteger) r106.elementAt(r107)), r111.getModulus());
        Vector r109 = this.lookup[r107];
        if (r109.size() != ((BigInteger) r106.elementAt(r107)).intValue()) goto L30;
        int r112 = r109.indexOf(r108);
        if (r112 == (-1)) goto L37;
        r105.addElement(BigInteger.valueOf(r112));
        r107 = r107 + 1;
        goto L26
    L37:
        if (this.debug == false) goto L43;
        System.out.println("Actual prime is " + r106.elementAt(r107));
        System.out.println("Decrypted value is " + r108);
        System.out.println("LookupList for " + r106.elementAt(r107) + " with size " + this.lookup[r107].size() + " is: ");
    L40:
        if (r102 >= this.lookup[r107].size()) goto L43;
        System.out.println(this.lookup[r107].elementAt(r102));
        r102 = r102 + 1;
    L43:
        throw new InvalidCipherTextException("Lookup failed");
    L30:
        if (this.debug == false) goto L33;
        System.out.println("Prime is " + r106.elementAt(r107) + ", lookup table has size " + r109.size());
    L33:
        throw new InvalidCipherTextException("Error in lookup Array for " + ((BigInteger) r106.elementAt(r107)).intValue() + ": Size mismatch. Expected ArrayList with length " + ((BigInteger) r106.elementAt(r107)).intValue() + " but found ArrayList of length " + this.lookup[r107].size());
    L46:
        return chineseRemainder(r105, r106).toByteArray();
    L55:
        return encrypt(r104);
    L16:
        if (r110 == r100.length) goto L18;
    L9:
        if (r110 >= getInputBlockSize()) goto L13;
        throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
    L48:
        throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
    L50:
        throw new IllegalStateException("NaccacheStern engine not initialised");
    }

    public byte[] processData(byte[] r110) throws InvalidCipherTextException {
        if (this.debug == false) goto L6;
        System.out.println();
    L6:
        if (r110.length <= getInputBlockSize()) goto L32;
        int r100 = getInputBlockSize();
        int r101 = getOutputBlockSize();
        if (this.debug == false) goto L10;
        System.out.println("Input blocksize is:  " + r100 + " bytes");
        System.out.println("Output blocksize is: " + r101 + " bytes");
        System.out.println("Data has length:.... " + r110.length + " bytes");
    L10:
        byte[] r102 = new byte[((r110.length / r100) + 1) * r101];
        int r103 = 0;
        int r104 = 0;
    L12:
        if (r103 >= r110.length) goto L27;
        int r105 = r103 + r100;
        if (r105 >= r110.length) goto L16;
        byte[] r106 = processBlock(r110, r103, r100);
        r103 = r105;
    L18:
        if (this.debug == false) goto L20;
        System.out.println("new datapos is " + r103);
    L20:
        if (r106 == null) goto L23;
        System.arraycopy(r106, 0, r102, r104, r106.length);
        r104 = r104 + r106.length;
        goto L12
    L23:
        if (this.debug == false) goto L26;
        System.out.println("cipher returned null");
    L26:
        throw new InvalidCipherTextException("cipher returned null");
    L16:
        r106 = processBlock(r110, r103, r110.length - r103);
        r103 = r103 + (r110.length - r103);
        goto L18
    L27:
        byte[] r111 = new byte[r104];
        System.arraycopy(r102, 0, r111, 0, r104);
        if (this.debug == false) goto L30;
        System.out.println("returning " + r104 + " bytes");
    L30:
        return r111;
    L32:
        if (this.debug == false) goto L35;
        System.out.println("data size is less then input block size, processing directly");
    L35:
        return processBlock(r110, 0, r110.length);
    }

    public void setDebug(boolean r100) {
        this.debug = r100;
    }
}
