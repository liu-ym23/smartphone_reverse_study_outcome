package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes42.dex */
public class X7875_NewUnix implements Cloneable, Serializable {
    private static final ZipShort HEADER_ID = null;
    private static final BigInteger ONE_THOUSAND = null;
    private static final ZipShort ZERO = null;
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version;

    public byte[] getCentralDirectoryData() {
        return new byte[0];
    }

    public void parseFromCentralDirectoryData(byte[] r100, int r101, int r102) throws ZipException {
    }

    static {
        HEADER_ID = new ZipShort(30837);
        ZERO = new ZipShort(0);
        ONE_THOUSAND = BigInteger.valueOf(1000);
    }

    private void reset() {
        BigInteger r100 = ONE_THOUSAND;
        this.uid = r100;
        this.gid = r100;
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    public byte[] getLocalFileDataData() {
        byte[] r100 = this.uid.toByteArray();
        byte[] r101 = this.gid.toByteArray();
        byte[] r102 = trimLeadingZeroesForceMinLength(r100);
        if (r102 == null) goto L5;
        int r103 = r102.length;
    L6:
        byte[] r104 = trimLeadingZeroesForceMinLength(r101);
        if (r104 == null) goto L9;
        int r105 = r104.length;
    L10:
        byte[] r106 = new byte[(r103 + 3) + r105];
        if (r102 == null) goto L13;
        ZipUtil.reverse(r102);
    L13:
        if (r104 == null) goto L15;
        ZipUtil.reverse(r104);
    L15:
        r106[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        r106[1] = ZipUtil.unsignedIntToSignedByte(r103);
        if (r102 == null) goto L18;
        System.arraycopy(r102, 0, r106, 2, r103);
    L18:
        int r107 = 2 + r103;
        int r108 = r107 + 1;
        r106[r107] = ZipUtil.unsignedIntToSignedByte(r105);
        if (r104 == null) goto L21;
        System.arraycopy(r104, 0, r106, r108, r105);
    L21:
        return r106;
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public ZipShort getLocalFileDataLength() {
        byte[] r100 = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        byte[] r103 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        if (r103 == null) goto L11;
        r101 = r103.length;
    L11:
        return new ZipShort((r102 + 3) + r101);
    L5:
        r102 = r100.length;
        goto L6
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }

    public X7875_NewUnix() {
        this.version = 1;
        reset();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int hashCode() {
        int r100 = this.version * (-1234567);
        return (Integer.rotateLeft(this.uid.hashCode(), 16) ^ r100) ^ this.gid.hashCode();
    }

    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public static byte[] trimLeadingZeroesForceMinLength(byte[] r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r102 >= r101) goto L9;
        if (r100[r102] != 0) goto L9;
        r103 = r103 + 1;
        r102 = r102 + 1;
    L9:
        int r104 = Math.max(1, r100.length - r103);
        byte[] r105 = new byte[r104];
        int r106 = r104 - (r100.length - r103);
        System.arraycopy(r100, r103, r105, r106, r104 - r106);
        return r105;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof X7875_NewUnix) == false) goto L12;
        X7875_NewUnix r101 = (X7875_NewUnix) r100;
        if (this.version == r101.version) goto L7;
        return false;
    L7:
        if (this.uid.equals(r101.uid) == true) goto L9;
        return false;
    L9:
        if (this.gid.equals(r101.gid) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public void setGID(long r100) {
        this.gid = ZipUtil.longToBig(r100);
    }

    public void setUID(long r100) {
        this.uid = ZipUtil.longToBig(r100);
    }

    public void parseFromLocalFileData(byte[] r100, int r101, int r102) throws ZipException {
        reset();
        int r103 = r101 + 1;
        this.version = ZipUtil.signedByteToUnsignedInt(r100[r101]);
        int r104 = r103 + 1;
        int r105 = ZipUtil.signedByteToUnsignedInt(r100[r103]);
        byte[] r106 = new byte[r105];
        System.arraycopy(r100, r104, r106, 0, r105);
        int r107 = r104 + r105;
        this.uid = new BigInteger(1, ZipUtil.reverse(r106));
        int r108 = r107 + 1;
        int r109 = ZipUtil.signedByteToUnsignedInt(r100[r107]);
        byte[] r110 = new byte[r109];
        System.arraycopy(r100, r108, r110, 0, r109);
        this.gid = new BigInteger(1, ZipUtil.reverse(r110));
    }
}
