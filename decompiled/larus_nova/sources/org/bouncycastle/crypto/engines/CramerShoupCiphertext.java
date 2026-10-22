package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupCiphertext {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    BigInteger f525174e;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    BigInteger f525175u1;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    BigInteger f525176u2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    BigInteger f525177v;

    public CramerShoupCiphertext() {
    }

    public CramerShoupCiphertext(BigInteger r100, BigInteger r101, BigInteger r102, BigInteger r103) {
        this.f525175u1 = r100;
        this.f525176u2 = r101;
        this.f525174e = r102;
        this.f525177v = r103;
    }

    public CramerShoupCiphertext(byte[] r100) {
        int r101 = Pack.bigEndianToInt(r100, 0) + 4;
        this.f525175u1 = new BigInteger(Arrays.copyOfRange(r100, 4, r101));
        int r102 = Pack.bigEndianToInt(r100, r101);
        int r103 = r101 + 4;
        int r104 = r102 + r103;
        this.f525176u2 = new BigInteger(Arrays.copyOfRange(r100, r103, r104));
        int r105 = Pack.bigEndianToInt(r100, r104);
        int r106 = r104 + 4;
        int r107 = r105 + r106;
        this.f525174e = new BigInteger(Arrays.copyOfRange(r100, r106, r107));
        int r108 = Pack.bigEndianToInt(r100, r107);
        int r109 = r107 + 4;
        this.f525177v = new BigInteger(Arrays.copyOfRange(r100, r109, r108 + r109));
    }

    public BigInteger getE() {
        return this.f525174e;
    }

    public BigInteger getU1() {
        return this.f525175u1;
    }

    public BigInteger getU2() {
        return this.f525176u2;
    }

    public BigInteger getV() {
        return this.f525177v;
    }

    public void setE(BigInteger r100) {
        this.f525174e = r100;
    }

    public void setU1(BigInteger r100) {
        this.f525175u1 = r100;
    }

    public void setU2(BigInteger r100) {
        this.f525176u2 = r100;
    }

    public void setV(BigInteger r100) {
        this.f525177v = r100;
    }

    public byte[] toByteArray() {
        byte[] r100 = this.f525175u1.toByteArray();
        int r101 = r100.length;
        byte[] r102 = this.f525176u2.toByteArray();
        int r103 = r102.length;
        byte[] r104 = this.f525174e.toByteArray();
        int r105 = r104.length;
        byte[] r106 = this.f525177v.toByteArray();
        int r107 = r106.length;
        byte[] r108 = new byte[(((r101 + r103) + r105) + r107) + 16];
        Pack.intToBigEndian(r101, r108, 0);
        System.arraycopy(r100, 0, r108, 4, r101);
        int r109 = r101 + 4;
        Pack.intToBigEndian(r103, r108, r109);
        int r110 = r109 + 4;
        System.arraycopy(r102, 0, r108, r110, r103);
        int r111 = r110 + r103;
        Pack.intToBigEndian(r105, r108, r111);
        int r112 = r111 + 4;
        System.arraycopy(r104, 0, r108, r112, r105);
        int r113 = r112 + r105;
        Pack.intToBigEndian(r107, r108, r113);
        System.arraycopy(r106, 0, r108, r113 + 4, r107);
        return r108;
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append("u1: " + this.f525175u1.toString());
        r100.append("\nu2: " + this.f525176u2.toString());
        r100.append("\ne: " + this.f525174e.toString());
        r100.append("\nv: " + this.f525177v.toString());
        return r100.toString();
    }
}
