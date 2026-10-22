package org.apache.commons.imaging.formats.tiff.constants;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TiffDirectoryType extends Enum<TiffDirectoryType> {
    private static final /* synthetic */ TiffDirectoryType[] $VALUES = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_EXIF_IFD = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_GPS = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_IFD0 = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_IFD1 = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_IFD2 = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_IFD3 = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_INTEROP_IFD = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_MAKER_NOTES = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_SUB_IFD = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_SUB_IFD1 = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_SUB_IFD2 = null;
    public static final TiffDirectoryType EXIF_DIRECTORY_UNKNOWN = null;
    public static final TiffDirectoryType TIFF_DIRECTORY_IFD0 = null;
    public static final TiffDirectoryType TIFF_DIRECTORY_IFD1 = null;
    public static final TiffDirectoryType TIFF_DIRECTORY_IFD2 = null;
    public static final TiffDirectoryType TIFF_DIRECTORY_IFD3 = null;
    public static final TiffDirectoryType TIFF_DIRECTORY_ROOT = null;
    public final int directoryType;
    private final boolean isImageDirectory;
    public final String name;

    static {
        TiffDirectoryType r100 = new TiffDirectoryType("TIFF_DIRECTORY_IFD0", 0, true, 0, "IFD0");
        TIFF_DIRECTORY_IFD0 = r100;
        TiffDirectoryType r101 = new TiffDirectoryType("TIFF_DIRECTORY_IFD1", 1, true, 1, "IFD1");
        TIFF_DIRECTORY_IFD1 = r101;
        TiffDirectoryType r102 = new TiffDirectoryType("TIFF_DIRECTORY_IFD2", 2, true, 2, "IFD2");
        TIFF_DIRECTORY_IFD2 = r102;
        TiffDirectoryType r103 = new TiffDirectoryType("TIFF_DIRECTORY_IFD3", 3, true, 3, "IFD3");
        TIFF_DIRECTORY_IFD3 = r103;
        TiffDirectoryType r104 = new TiffDirectoryType("EXIF_DIRECTORY_INTEROP_IFD", 4, false, -4, "Interop IFD");
        EXIF_DIRECTORY_INTEROP_IFD = r104;
        TiffDirectoryType r105 = new TiffDirectoryType("EXIF_DIRECTORY_MAKER_NOTES", 5, false, -5, "Maker Notes");
        EXIF_DIRECTORY_MAKER_NOTES = r105;
        TiffDirectoryType r106 = new TiffDirectoryType("EXIF_DIRECTORY_EXIF_IFD", 6, false, -2, "Exif IFD");
        EXIF_DIRECTORY_EXIF_IFD = r106;
        TiffDirectoryType r110 = new TiffDirectoryType("EXIF_DIRECTORY_GPS", 7, false, -3, "GPS IFD");
        EXIF_DIRECTORY_GPS = r110;
        $VALUES = new TiffDirectoryType[]{r100, r101, r102, r103, r104, r105, r106, r110};
        EXIF_DIRECTORY_IFD0 = r100;
        TIFF_DIRECTORY_ROOT = r100;
        EXIF_DIRECTORY_IFD1 = r101;
        EXIF_DIRECTORY_IFD2 = r102;
        EXIF_DIRECTORY_IFD3 = r103;
        EXIF_DIRECTORY_SUB_IFD = r101;
        EXIF_DIRECTORY_SUB_IFD1 = r102;
        EXIF_DIRECTORY_SUB_IFD2 = r103;
        EXIF_DIRECTORY_UNKNOWN = null;
    }

    public static TiffDirectoryType[] values() {
        return (TiffDirectoryType[]) $VALUES.clone();
    }

    public boolean isImageDirectory() {
        return this.isImageDirectory;
    }

    public static TiffDirectoryType getExifDirectoryType(int r100) {
        TiffDirectoryType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        TiffDirectoryType r104 = r101[r103];
        if (r104.directoryType == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return EXIF_DIRECTORY_UNKNOWN;
    }

    public static TiffDirectoryType valueOf(String r100) {
        return (TiffDirectoryType) a.a(TiffDirectoryType.class, r100);
    }

    private TiffDirectoryType(String r100, int r101, boolean r102, int r103, String r104) {
        super(r100, r101);
        this.isImageDirectory = r102;
        this.directoryType = r103;
        this.name = r104;
    }
}
