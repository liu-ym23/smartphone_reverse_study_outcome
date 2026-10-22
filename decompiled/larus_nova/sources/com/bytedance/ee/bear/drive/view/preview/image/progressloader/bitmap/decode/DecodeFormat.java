package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

/* JADX INFO: loaded from: classes16.dex */
public final enum DecodeFormat extends Enum<DecodeFormat> {
    public static final DecodeFormat ALWAYS_ARGB_8888 = null;
    public static final DecodeFormat DEFAULT = null;
    public static final DecodeFormat PREFER_ARGB_8888 = null;
    public static final DecodeFormat PREFER_RGB_565 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeFormat[] f224962a = null;

    static {
        DecodeFormat r100 = new DecodeFormat("ALWAYS_ARGB_8888", 0);
        ALWAYS_ARGB_8888 = r100;
        DecodeFormat r101 = new DecodeFormat("PREFER_ARGB_8888", 1);
        PREFER_ARGB_8888 = r101;
        DecodeFormat r102 = new DecodeFormat("PREFER_RGB_565", 2);
        PREFER_RGB_565 = r102;
        f224962a = new DecodeFormat[]{r100, r101, r102};
        DEFAULT = r102;
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) f224962a.clone();
    }

    public static DecodeFormat valueOf(String r100) {
        return (DecodeFormat) r27.a.a(DecodeFormat.class, r100);
    }

    public DecodeFormat(String r100, int r101) {
        super(r100, r101);
    }
}
