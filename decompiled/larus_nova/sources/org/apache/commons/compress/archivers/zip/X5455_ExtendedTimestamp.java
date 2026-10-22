package org.apache.commons.compress.archivers.zip;

import androidx.collection.SieveCacheKt;
import com.ttnet.org.chromium.net.NetError;
import java.io.Serializable;
import java.util.Date;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes42.dex */
public class X5455_ExtendedTimestamp implements Cloneable, Serializable {
    public static final byte ACCESS_TIME_BIT = 2;
    public static final byte CREATE_TIME_BIT = 4;
    private static final ZipShort HEADER_ID = null;
    public static final byte MODIFY_TIME_BIT = 1;
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    public X5455_ExtendedTimestamp() {
    }

    private void reset() {
        setFlags((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
    }

    static {
        HEADER_ID = new ZipShort(21589);
    }

    public Date getAccessJavaTime() {
        return zipLongToDate(this.accessTime);
    }

    public ZipShort getCentralDirectoryLength() {
        if (this.bit0_modifyTimePresent == false) goto L5;
        int r100 = 4;
    L7:
        return new ZipShort(r100 + 1);
    L5:
        r100 = 0;
        goto L7
    }

    public Date getCreateJavaTime() {
        return zipLongToDate(this.createTime);
    }

    public ZipShort getLocalFileDataLength() {
        int r100 = 4;
        if (this.bit0_modifyTimePresent == false) goto L5;
        int r101 = 4;
    L6:
        int r102 = r101 + 1;
        if (this.bit1_accessTimePresent == true) goto L9;
    L11:
        int r103 = 0;
    L12:
        int r104 = r102 + r103;
        if (this.bit2_createTimePresent == true) goto L15;
    L17:
        r100 = 0;
    L19:
        return new ZipShort(r104 + r100);
    L15:
        if (this.createTime == null) goto L17;
    L9:
        if (this.accessTime == null) goto L11;
        r103 = 4;
        goto L12
    L5:
        r101 = 0;
        goto L6
    }

    public Date getModifyJavaTime() {
        return zipLongToDate(this.modifyTime);
    }

    public int hashCode() {
        int r100 = (this.flags & 7) * NetError.ERR_SSL_NO_RENEGOTIATION;
        ZipLong r101 = this.modifyTime;
        if (r101 == null) goto L5;
        r100 = r100 ^ r101.hashCode();
    L5:
        ZipLong r102 = this.accessTime;
        if (r102 == null) goto L8;
        r100 = r100 ^ Integer.rotateLeft(r102.hashCode(), 11);
    L8:
        ZipLong r103 = this.createTime;
        if (r103 != null) goto L11;
        return r100;
    L11:
        return r100 ^ Integer.rotateLeft(r103.hashCode(), 22);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("0x5455 Zip Extra Field: Flags=");
        r100.append(Integer.toBinaryString(ZipUtil.unsignedIntToSignedByte(this.flags)));
        r100.append(" ");
        if (this.bit0_modifyTimePresent == false) goto L8;
        if (this.modifyTime == null) goto L8;
        Date r101 = getModifyJavaTime();
        r100.append(" Modify:[");
        r100.append(r101);
        r100.append("] ");
    L8:
        if (this.bit1_accessTimePresent == false) goto L13;
        if (this.accessTime == null) goto L13;
        Date r102 = getAccessJavaTime();
        r100.append(" Access:[");
        r100.append(r102);
        r100.append("] ");
    L13:
        if (this.bit2_createTimePresent == false) goto L18;
        if (this.createTime == null) goto L18;
        Date r103 = getCreateJavaTime();
        r100.append(" Create:[");
        r100.append(r103);
        r100.append("] ");
    L18:
        return r100.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public byte[] getCentralDirectoryData() {
        int r100 = getCentralDirectoryLength().getValue();
        byte[] r101 = new byte[r100];
        System.arraycopy(getLocalFileDataData(), 0, r101, 0, r100);
        return r101;
    }

    public byte[] getLocalFileDataData() {
        byte[] r100 = new byte[getLocalFileDataLength().getValue()];
        r100[0] = 0;
        int r101 = 1;
        if (this.bit0_modifyTimePresent == false) goto L6;
        r100[0] = (byte) (0 | 1);
        System.arraycopy(this.modifyTime.getBytes(), 0, r100, 1, 4);
        r101 = 5;
    L6:
        if (this.bit1_accessTimePresent == false) goto L11;
        ZipLong r102 = this.accessTime;
        if (r102 == null) goto L11;
        r100[0] = (byte) (r100[0] | 2);
        System.arraycopy(r102.getBytes(), 0, r100, r101, 4);
        r101 = r101 + 4;
    L11:
        if (this.bit2_createTimePresent == false) goto L15;
        ZipLong r103 = this.createTime;
        if (r103 == null) goto L15;
        r100[0] = (byte) (r100[0] | 4);
        System.arraycopy(r103.getBytes(), 0, r100, r101, 4);
    L15:
        return r100;
    }

    public ZipLong getAccessTime() {
        return this.accessTime;
    }

    public ZipLong getCreateTime() {
        return this.createTime;
    }

    public byte getFlags() {
        return this.flags;
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public ZipLong getModifyTime() {
        return this.modifyTime;
    }

    public boolean isBit0_modifyTimePresent() {
        return this.bit0_modifyTimePresent;
    }

    public boolean isBit1_accessTimePresent() {
        return this.bit1_accessTimePresent;
    }

    public boolean isBit2_createTimePresent() {
        return this.bit2_createTimePresent;
    }

    private static ZipLong dateToZipLong(Date r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return unixTimeToZipLong(r100.getTime() / 1000);
    }

    private static ZipLong unixTimeToZipLong(long r100) {
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        if (r100 > SieveCacheKt.NodeLinkMask) goto L9;
        return new ZipLong(r100);
    L9:
        throw new IllegalArgumentException("X5455 timestamps must fit in a signed 32 bit integer: " + r100);
    }

    private static Date zipLongToDate(ZipLong r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new Date(((long) r100.getIntValue()) * 1000);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof X5455_ExtendedTimestamp) == false) goto L23;
        X5455_ExtendedTimestamp r101 = (X5455_ExtendedTimestamp) r100;
        if ((this.flags & 7) != (r101.flags & 7)) goto L24;
        ZipLong r102 = this.modifyTime;
        ZipLong r103 = r101.modifyTime;
        if (r102 == r103) goto L11;
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.equals(r103) == true) goto L11;
        return false;
    L11:
        ZipLong r104 = this.accessTime;
        ZipLong r105 = r101.accessTime;
        if (r104 == r105) goto L16;
        if (r104 != null) goto L15;
        return false;
    L15:
        if (r104.equals(r105) == true) goto L16;
        return false;
    L16:
        ZipLong r106 = this.createTime;
        ZipLong r107 = r101.createTime;
        if (r106 == r107) goto L21;
        if (r106 != null) goto L20;
        return false;
    L20:
        if (r106.equals(r107) == true) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L23:
        return false;
    }

    public void setAccessJavaTime(Date r100) {
        setAccessTime(dateToZipLong(r100));
    }

    public void setAccessTime(ZipLong r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        this.bit1_accessTimePresent = r101;
        byte r102 = this.flags;
        if (r100 == null) goto L8;
        int r103 = r102 | 2;
    L9:
        this.flags = (byte) r103;
        this.accessTime = r100;
        return;
    L8:
        r103 = r102 & (-3);
        goto L9
    L4:
        r101 = false;
        goto L5
    }

    public void setCreateJavaTime(Date r100) {
        setCreateTime(dateToZipLong(r100));
    }

    public void setCreateTime(ZipLong r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        this.bit2_createTimePresent = r101;
        byte r102 = this.flags;
        if (r100 == null) goto L8;
        int r103 = r102 | 4;
    L9:
        this.flags = (byte) r103;
        this.createTime = r100;
        return;
    L8:
        r103 = r102 & (-5);
        goto L9
    L4:
        r101 = false;
        goto L5
    }

    public void setFlags(byte r100) {
        this.flags = r100;
        boolean r101 = false;
        if ((r100 & 1) != 1) goto L5;
        boolean r102 = true;
    L6:
        this.bit0_modifyTimePresent = r102;
        if ((r100 & 2) != 2) goto L9;
        boolean r103 = true;
    L10:
        this.bit1_accessTimePresent = r103;
        if ((r100 & 4) != 4) goto L13;
        r101 = true;
    L13:
        this.bit2_createTimePresent = r101;
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public void setModifyJavaTime(Date r100) {
        setModifyTime(dateToZipLong(r100));
    }

    public void setModifyTime(ZipLong r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.bit0_modifyTimePresent = r101;
        if (r100 == null) goto L9;
        int r102 = 1 | this.flags;
    L10:
        this.flags = (byte) r102;
        this.modifyTime = r100;
        return;
    L9:
        r102 = this.flags & (-2);
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public void parseFromCentralDirectoryData(byte[] r100, int r101, int r102) throws ZipException {
        reset();
        parseFromLocalFileData(r100, r101, r102);
    }

    public void parseFromLocalFileData(byte[] r100, int r101, int r102) throws ZipException {
        reset();
        int r103 = r102 + r101;
        int r104 = r101 + 1;
        setFlags(r100[r101]);
        if (this.bit0_modifyTimePresent == false) goto L6;
        this.modifyTime = new ZipLong(r100, r104);
        r104 = r104 + 4;
    L6:
        if (this.bit1_accessTimePresent == false) goto L11;
        int r105 = r104 + 4;
        if (r105 > r103) goto L11;
        this.accessTime = new ZipLong(r100, r104);
        r104 = r105;
    L11:
        if (this.bit2_createTimePresent == true) goto L13;
        return;
    L13:
        if ((r104 + 4) > r103) goto L17;
        this.createTime = new ZipLong(r100, r104);
        return;
    }
}
