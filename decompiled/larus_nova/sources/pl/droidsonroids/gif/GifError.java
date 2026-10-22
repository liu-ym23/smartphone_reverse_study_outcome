package pl.droidsonroids.gif;

import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public final enum GifError extends Enum<GifError> {
    public static final GifError CLOSE_FAILED = null;
    public static final GifError DATA_TOO_BIG = null;
    public static final GifError EOF_TOO_SOON = null;
    public static final GifError IMAGE_DEFECT = null;
    public static final GifError IMG_NOT_CONFINED = null;
    public static final GifError INVALID_BYTE_BUFFER = null;
    public static final GifError INVALID_IMG_DIMS = null;
    public static final GifError INVALID_SCR_DIMS = null;
    public static final GifError NOT_ENOUGH_MEM = null;
    public static final GifError NOT_GIF_FILE = null;
    public static final GifError NOT_READABLE = null;
    public static final GifError NO_COLOR_MAP = null;
    public static final GifError NO_ERROR = null;
    public static final GifError NO_FRAMES = null;
    public static final GifError NO_IMAG_DSCR = null;
    public static final GifError NO_SCRN_DSCR = null;
    public static final GifError OPEN_FAILED = null;
    public static final GifError READ_FAILED = null;
    public static final GifError REWIND_FAILED = null;
    public static final GifError UNKNOWN = null;
    public static final GifError WRONG_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GifError[] f529685a = null;
    public final String description;
    int errorCode;

    static {
        GifError r100 = new GifError("NO_ERROR", 0, 0, "No error");
        NO_ERROR = r100;
        GifError r101 = new GifError("OPEN_FAILED", 1, 101, "Failed to open given input");
        OPEN_FAILED = r101;
        GifError r102 = new GifError("READ_FAILED", 2, 102, "Failed to read from given input");
        READ_FAILED = r102;
        GifError r103 = new GifError("NOT_GIF_FILE", 3, 103, "Data is not in GIF format");
        NOT_GIF_FILE = r103;
        GifError r104 = new GifError("NO_SCRN_DSCR", 4, 104, "No screen descriptor detected");
        NO_SCRN_DSCR = r104;
        GifError r105 = new GifError("NO_IMAG_DSCR", 5, 105, "No image descriptor detected");
        NO_IMAG_DSCR = r105;
        GifError r106 = new GifError("NO_COLOR_MAP", 6, 106, "Neither global nor local color map found");
        NO_COLOR_MAP = r106;
        GifError r110 = new GifError("WRONG_RECORD", 7, 107, "Wrong record type detected");
        WRONG_RECORD = r110;
        GifError r111 = new GifError("DATA_TOO_BIG", 8, 108, "Number of pixels bigger than width * height");
        DATA_TOO_BIG = r111;
        GifError r112 = new GifError("NOT_ENOUGH_MEM", 9, 109, "Failed to allocate required memory");
        NOT_ENOUGH_MEM = r112;
        GifError r113 = new GifError("CLOSE_FAILED", 10, 110, "Failed to close given input");
        CLOSE_FAILED = r113;
        GifError r107 = new GifError("NOT_READABLE", 11, 111, "Given file was not opened for read");
        NOT_READABLE = r107;
        GifError r108 = new GifError("IMAGE_DEFECT", 12, 112, "Image is defective, decoding aborted");
        IMAGE_DEFECT = r108;
        GifError r109 = new GifError("EOF_TOO_SOON", 13, 113, "Image EOF detected before image complete");
        EOF_TOO_SOON = r109;
        GifError r114 = new GifError("NO_FRAMES", 14, 1000, "No frames found, at least one frame required");
        NO_FRAMES = r114;
        GifError r115 = new GifError("INVALID_SCR_DIMS", 15, 1001, "Invalid screen size, dimensions must be positive");
        INVALID_SCR_DIMS = r115;
        GifError r116 = new GifError("INVALID_IMG_DIMS", 16, 1002, "Invalid image size, dimensions must be positive");
        INVALID_IMG_DIMS = r116;
        GifError r117 = new GifError("IMG_NOT_CONFINED", 17, 1003, "Image size exceeds screen size");
        IMG_NOT_CONFINED = r117;
        GifError r118 = new GifError("REWIND_FAILED", 18, 1004, "Input source rewind failed, animation stopped");
        REWIND_FAILED = r118;
        GifError r119 = new GifError("INVALID_BYTE_BUFFER", 19, 1005, "Invalid and/or indirect byte buffer specified");
        INVALID_BYTE_BUFFER = r119;
        GifError r120 = new GifError("UNKNOWN", 20, -1, "Unknown error");
        UNKNOWN = r120;
        f529685a = new GifError[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120};
    }

    public static GifError[] values() {
        return (GifError[]) f529685a.clone();
    }

    public String getFormattedDescription() {
        return String.format(Locale.ENGLISH, "GifError %d: %s", new Object[]{Integer.valueOf(this.errorCode), this.description});
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static GifError fromCode(int r100) {
        GifError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        GifError r104 = r101[r103];
        if (r104.errorCode == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        GifError r105 = UNKNOWN;
        r105.errorCode = r100;
        return r105;
    }

    public static GifError valueOf(String r100) {
        return (GifError) r27.a.a(GifError.class, r100);
    }

    public GifError(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.errorCode = r102;
        this.description = r103;
    }
}
