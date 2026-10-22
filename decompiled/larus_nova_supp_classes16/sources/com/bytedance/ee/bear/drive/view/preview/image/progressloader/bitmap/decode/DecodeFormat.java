package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum DecodeFormat extends Enum<DecodeFormat> {
    public static final DecodeFormat ALWAYS_ARGB_8888 = null;
    public static final DecodeFormat DEFAULT = null;
    public static final DecodeFormat PREFER_ARGB_8888 = null;
    public static final DecodeFormat PREFER_RGB_565 = null;
    public static final /* synthetic */ DecodeFormat[] a = null;

    static {
        DecodeFormat r0 = new DecodeFormat("ALWAYS_ARGB_8888", 0);
        ALWAYS_ARGB_8888 = r0;
        DecodeFormat r1 = new DecodeFormat("PREFER_ARGB_8888", 1);
        PREFER_ARGB_8888 = r1;
        DecodeFormat r3 = new DecodeFormat("PREFER_RGB_565", 2);
        PREFER_RGB_565 = r3;
        a = new DecodeFormat[]{r0, r1, r3};
        DEFAULT = r3;
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) a.clone();
    }

    public static DecodeFormat valueOf(String r1) {
        return (DecodeFormat) r27.a.a(DecodeFormat.class, r1);
    }

    public DecodeFormat(String r1, int r2) {
        super(r1, r2);
    }
}
