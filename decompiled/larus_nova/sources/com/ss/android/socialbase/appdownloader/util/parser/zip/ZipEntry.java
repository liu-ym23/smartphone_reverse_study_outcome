package com.ss.android.socialbase.appdownloader.util.parser.zip;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes38.dex */
public class ZipEntry extends java.util.zip.ZipEntry implements Cloneable {
    public static final int CRC_UNKNOWN = -1;
    private static final byte[] EMPTY = null;
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_SHIFT = 16;
    private static final ZipExtraField[] noExtraFields = null;
    private long externalAttributes;
    private ZipExtraField[] extraFields;

    /* JADX INFO: renamed from: gpb, reason: collision with root package name */
    private GeneralPurposeBit f449574gpb;
    private int internalAttributes;
    private int method;
    private String name;
    private int platform;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;

    static {
        EMPTY = new byte[0];
        noExtraFields = new ZipExtraField[0];
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getExtraFields(true));
    }

    public void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getExtraFields(true)));
    }

    public ZipEntry() {
        this("");
    }

    private ZipExtraField[] getAllExtraFieldsNoCopy() {
        ZipExtraField[] r100 = this.extraFields;
        if (r100 != null) goto L7;
        return getUnparseableOnly();
    L7:
        if (this.unparseableExtra != null) goto L9;
        return r100;
    L9:
        return getMergedFields();
    }

    private ZipExtraField[] getMergedFields() {
        ZipExtraField[] r100 = this.extraFields;
        ZipExtraField[] r101 = copyOf(r100, r100.length + 1);
        r101[this.extraFields.length] = this.unparseableExtra;
        return r101;
    }

    private ZipExtraField[] getParseableExtraFieldsNoCopy() {
        ZipExtraField[] r100 = this.extraFields;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return noExtraFields;
    }

    private ZipExtraField[] getUnparseableOnly() {
        UnparseableExtraFieldData r100 = this.unparseableExtra;
        if (r100 != null) goto L6;
        return noExtraFields;
    L6:
        return new ZipExtraField[]{r100};
    }

    public Date getLastModifiedDate() {
        return new Date(getTime());
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String r100 = this.name;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return super.getName();
    }

    public byte[] getRawName() {
        byte[] r100 = this.rawName;
        if (r100 == null) goto L6;
        byte[] r101 = new byte[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    L6:
        return null;
    }

    public int getUnixMode() {
        if (this.platform == 3) goto L6;
        return 0;
    L6:
        return (int) ((getExternalAttributes() >> 16) & 65535);
    }

    public void removeUnparseableExtraFieldData() {
        if (this.unparseableExtra == null) goto L7;
        this.unparseableExtra = null;
        setExtra();
        return;
    L7:
        throw new NoSuchElementException();
    }

    private ZipExtraField[] getAllExtraFields() {
        ZipExtraField[] r100 = getAllExtraFieldsNoCopy();
        if (r100 == this.extraFields) goto L5;
        return r100;
    L5:
        return copyOf(r100);
    }

    private ZipExtraField[] getParseableExtraFields() {
        ZipExtraField[] r100 = getParseableExtraFieldsNoCopy();
        if (r100 == this.extraFields) goto L5;
        return r100;
    L5:
        return copyOf(r100);
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipEntry r100 = (ZipEntry) super.clone();
        r100.setInternalAttributes(getInternalAttributes());
        r100.setExternalAttributes(getExternalAttributes());
        r100.setExtraFields(getAllExtraFieldsNoCopy());
        return r100;
    }

    public ZipExtraField[] getExtraFields() {
        return getParseableExtraFields();
    }

    public byte[] getLocalFileDataExtra() {
        byte[] r100 = getExtra();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return EMPTY;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        return getName().hashCode();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        return getName().endsWith(HTTP.URL_DEFAULT);
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.f449574gpb;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.method;
    }

    public int getPlatform() {
        return this.platform;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.size;
    }

    public UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.unparseableExtra;
    }

    public ZipEntry(java.util.zip.ZipEntry r100) throws ZipException {
        super(r100);
        this.method = -1;
        this.size = -1;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.f449574gpb = new GeneralPurposeBit();
        setName(r100.getName());
        byte[] r101 = r100.getExtra();
        if (r101 == null) goto L5;
        setExtraFields(ExtraFieldUtils.parse(r101, true, ExtraFieldUtils.UnparseableExtraField.READ));
    L6:
        setMethod(r100.getMethod());
        this.size = r100.getSize();
        return;
    L5:
        setExtra();
        goto L6
    }

    private ZipExtraField[] copyOf(ZipExtraField[] r100) {
        return copyOf(r100, r100.length);
    }

    public void addAsFirstExtraField(ZipExtraField r100) {
        if ((r100 instanceof UnparseableExtraFieldData) == false) goto L6;
        this.unparseableExtra = (UnparseableExtraFieldData) r100;
    L15:
        setExtra();
        return;
    L6:
        if (getExtraField(r100.getHeaderId()) == null) goto L8;
        removeExtraField(r100.getHeaderId());
    L8:
        ZipExtraField[] r101 = this.extraFields;
        if (r101 == null) goto L11;
        int r102 = r101.length + 1;
    L12:
        ZipExtraField[] r103 = new ZipExtraField[r102];
        this.extraFields = r103;
        r103[0] = r100;
        if (r101 == null) goto L15;
        System.arraycopy(r101, 0, r103, 1, r103.length - 1);
        goto L15
    L11:
        r102 = 1;
        goto L12
    }

    public void addExtraField(ZipExtraField r100) {
        if ((r100 instanceof UnparseableExtraFieldData) == false) goto L6;
        this.unparseableExtra = (UnparseableExtraFieldData) r100;
    L12:
        setExtra();
        return;
    L6:
        if (this.extraFields != null) goto L9;
        this.extraFields = new ZipExtraField[]{r100};
        goto L12
    L9:
        if (getExtraField(r100.getHeaderId()) == null) goto L11;
        removeExtraField(r100.getHeaderId());
    L11:
        ZipExtraField[] r101 = this.extraFields;
        ZipExtraField[] r102 = copyOf(r101, r101.length + 1);
        r102[this.extraFields.length] = r100;
        this.extraFields = r102;
        goto L12
    }

    public boolean equals(Object r110) {
        if (this != r110) goto L6;
        return true;
    L6:
        if (r110 != null) goto L8;
    L49:
        return false;
    L8:
        if (getClass() != r110.getClass()) goto L49;
        ZipEntry r111 = (ZipEntry) r110;
        String r100 = getName();
        String r101 = r111.getName();
        if (r100 != null) goto L15;
        if (r101 == null) goto L17;
        return false;
    L17:
        String r102 = getComment();
        String r103 = r111.getComment();
        if (r102 != null) goto L20;
        r102 = "";
    L20:
        if (r103 != null) goto L23;
        r103 = "";
    L23:
        if (getTime() == r111.getTime()) goto L25;
    L47:
        return false;
    L25:
        if (r102.equals(r103) == false) goto L47;
        if (getInternalAttributes() != r111.getInternalAttributes()) goto L47;
        if (getPlatform() != r111.getPlatform()) goto L47;
        if (getExternalAttributes() != r111.getExternalAttributes()) goto L47;
        if (getMethod() != r111.getMethod()) goto L47;
        if (getSize() != r111.getSize()) goto L47;
        if (getCrc() != r111.getCrc()) goto L47;
        if (getCompressedSize() != r111.getCompressedSize()) goto L47;
        if (Arrays.equals(getCentralDirectoryExtra(), r111.getCentralDirectoryExtra()) == false) goto L47;
        if (Arrays.equals(getLocalFileDataExtra(), r111.getLocalFileDataExtra()) == false) goto L47;
        if (this.f449574gpb.equals(r111.f449574gpb) == false) goto L47;
        return true;
    L15:
        if (r100.equals(r101) == true) goto L17;
        return false;
    }

    public ZipExtraField getExtraField(ZipShort r100) {
        ZipExtraField[] r101 = this.extraFields;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        ZipExtraField r104 = r101[r103];
        if (r100.equals(r104.getHeaderId()) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return r104;
    L14:
        return null;
    L10:
        return null;
    }

    public ZipExtraField[] getExtraFields(boolean r100) {
        if (r100 == false) goto L5;
        return getAllExtraFields();
    L5:
        return getParseableExtraFields();
    }

    public void removeExtraField(ZipShort r100) {
        if (this.extraFields == null) goto L17;
        ArrayList r101 = new ArrayList();
        ZipExtraField[] r102 = this.extraFields;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        ZipExtraField r105 = r102[r104];
        if (r100.equals(r105.getHeaderId()) == true) goto L9;
        r101.add(r105);
    L9:
        r104 = r104 + 1;
        goto L5
    L11:
        if (this.extraFields.length == r101.size()) goto L15;
        this.extraFields = (ZipExtraField[]) r101.toArray(new ZipExtraField[0]);
        setExtra();
        return;
    L15:
        throw new NoSuchElementException();
    L17:
        throw new NoSuchElementException();
    }

    public void setCentralDirectoryExtra(byte[] r100) {
        mergeExtraFields(ExtraFieldUtils.parse(r100, false, ExtraFieldUtils.UnparseableExtraField.READ), false);     // Catch: ZipException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public void setComprSize(long r100) {
        setCompressedSize(r100);
    }

    public void setExternalAttributes(long r100) {
        this.externalAttributes = r100;
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] r100) throws RuntimeException {
        mergeExtraFields(ExtraFieldUtils.parse(r100, true, ExtraFieldUtils.UnparseableExtraField.READ), true);     // Catch: ZipException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
    }

    public void setExtraFields(ZipExtraField[] r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ZipExtraField r104 = r100[r103];
        if ((r104 instanceof UnparseableExtraFieldData) == false) goto L7;
        this.unparseableExtra = (UnparseableExtraFieldData) r104;
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        r101.add(r104);
        goto L8
    L9:
        this.extraFields = (ZipExtraField[]) r101.toArray(new ZipExtraField[0]);
        setExtra();
    }

    public void setGeneralPurposeBit(GeneralPurposeBit r100) {
        this.f449574gpb = r100;
    }

    public void setInternalAttributes(int r100) {
        this.internalAttributes = r100;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int r100) {
        if (r100 < 0) goto L6;
        this.method = r100;
        return;
    L6:
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + r100);
    }

    public void setName(String r100) {
        if (r100 != null) goto L4;
    L8:
        this.name = r100;
        return;
    L4:
        if (getPlatform() != 0) goto L8;
        if (r100.contains(HTTP.URL_DEFAULT) == true) goto L8;
        r100 = r100.replace('\\', '/');
        goto L8
    }

    public void setPlatform(int r100) {
        this.platform = r100;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long r100) {
        if (r100 < 0) goto L7;
        this.size = r100;
        return;
    L7:
        throw new IllegalArgumentException("invalid entry size");
    }

    public void setUnixMode(int r100) {
        int r101 = r100 << 16;
        int r102 = 0;
        if ((r100 & 128) != 0) goto L5;
        int r103 = 1;
    L6:
        int r104 = r103 | r101;
        if (isDirectory() == false) goto L9;
        r102 = 16;
    L9:
        setExternalAttributes(r104 | r102);
        this.platform = 3;
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public ZipEntry(ZipEntry r100) throws ZipException {
        this(r100);
        setInternalAttributes(r100.getInternalAttributes());
        setExternalAttributes(r100.getExternalAttributes());
        setExtraFields(getAllExtraFieldsNoCopy());
        setPlatform(r100.getPlatform());
        GeneralPurposeBit r101 = r100.getGeneralPurposeBit();
        if (r101 != null) goto L5;
        GeneralPurposeBit r102 = null;
    L6:
        setGeneralPurposeBit(r102);
        return;
    L5:
        r102 = (GeneralPurposeBit) r101.clone();
        goto L6
    }

    public ZipEntry(String r100) {
        super(r100);
        this.method = -1;
        this.size = -1;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.f449574gpb = new GeneralPurposeBit();
        setName(r100);
    }

    public ZipEntry(File r100, String r101) {
        if (r100.isDirectory() == true) goto L5;
    L7:
        this(r101);
        if (r100.isFile() == false) goto L10;
        setSize(r100.length());
    L10:
        setTime(r100.lastModified());
        return;
    L5:
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L7;
        r101 = r101.concat(HTTP.URL_DEFAULT);
        goto L7
    }

    private ZipExtraField[] copyOf(ZipExtraField[] r100, int r101) {
        ZipExtraField[] r102 = new ZipExtraField[r101];
        System.arraycopy(r100, 0, r102, 0, Math.min(r100.length, r101));
        return r102;
    }

    private void mergeExtraFields(ZipExtraField[] r100, boolean r101) throws ZipException {
        if (this.extraFields != null) goto L5;
        setExtraFields(r100);
        return;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L20;
        ZipExtraField r104 = r100[r103];
        if ((r104 instanceof UnparseableExtraFieldData) == false) goto L10;
        ZipExtraField r105 = this.unparseableExtra;
    L11:
        if (r105 != null) goto L13;
        addExtraField(r104);
    L19:
        r103 = r103 + 1;
        goto L6
    L13:
        if (r101 == false) goto L15;
    L18:
        byte[] r106 = r104.getLocalFileDataData();
        r105.parseFromLocalFileData(r106, 0, r106.length);
        goto L19
    L15:
        if ((r105 instanceof CentralDirectoryParsingZipExtraField) == false) goto L18;
        byte[] r107 = r104.getCentralDirectoryData();
        ((CentralDirectoryParsingZipExtraField) r105).parseFromCentralDirectoryData(r107, 0, r107.length);
        goto L19
    L10:
        r105 = getExtraField(r104.getHeaderId());
        goto L11
    L20:
        setExtra();
    }

    public void setName(String r100, byte[] r101) {
        setName(r100);
        this.rawName = r101;
    }
}
