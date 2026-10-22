package com.lynx.tasm.ui.image;

/* JADX INFO: loaded from: classes32.dex */
public final enum ImageResizeMethod extends Enum<ImageResizeMethod> {
    public static final ImageResizeMethod AUTO = null;
    public static final ImageResizeMethod RESIZE = null;
    public static final ImageResizeMethod SCALE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageResizeMethod[] f383839a = null;

    static {
        ImageResizeMethod r100 = new ImageResizeMethod("AUTO", 0);
        AUTO = r100;
        ImageResizeMethod r101 = new ImageResizeMethod("RESIZE", 1);
        RESIZE = r101;
        ImageResizeMethod r102 = new ImageResizeMethod("SCALE", 2);
        SCALE = r102;
        f383839a = new ImageResizeMethod[]{r100, r101, r102};
    }

    public static ImageResizeMethod[] values() {
        return (ImageResizeMethod[]) f383839a.clone();
    }

    public static ImageResizeMethod valueOf(String r100) {
        return (ImageResizeMethod) r27.a.a(ImageResizeMethod.class, r100);
    }

    public ImageResizeMethod(String r100, int r101) {
        super(r100, r101);
    }
}
