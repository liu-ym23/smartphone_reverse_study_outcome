package com.ss.android.lark.image.entity;

/* JADX INFO: loaded from: classes36.dex */
public final enum ImageFormat extends Enum<ImageFormat> {
    public static final ImageFormat HEIC = null;
    public static final ImageFormat JPEG = null;
    public static final ImageFormat PNG = null;
    public static final ImageFormat WEBP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageFormat[] f426285a = null;
    private int value;

    static {
        ImageFormat r100 = new ImageFormat("WEBP", 0, 1);
        WEBP = r100;
        ImageFormat r101 = new ImageFormat("JPEG", 1, 2);
        JPEG = r101;
        ImageFormat r102 = new ImageFormat("PNG", 2, 3);
        PNG = r102;
        ImageFormat r103 = new ImageFormat("HEIC", 3, 4);
        HEIC = r103;
        f426285a = new ImageFormat[]{r100, r101, r102, r103};
    }

    public static ImageFormat[] values() {
        return (ImageFormat[]) f426285a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ImageFormat forNumber(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return PNG;
    L13:
        return HEIC;
    L15:
        return PNG;
    L17:
        return JPEG;
    L19:
        return WEBP;
    }

    public static ImageFormat valueOf(String r100) {
        return (ImageFormat) r27.a.a(ImageFormat.class, r100);
    }

    public static ImageFormat valueOf(int r100) {
        return forNumber(r100);
    }

    public ImageFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
