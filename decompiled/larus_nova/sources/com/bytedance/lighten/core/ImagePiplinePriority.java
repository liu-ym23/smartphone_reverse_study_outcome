package com.bytedance.lighten.core;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ImagePiplinePriority extends Enum<ImagePiplinePriority> {
    public static final ImagePiplinePriority HIGH = null;
    public static final ImagePiplinePriority IMMEDIATE = null;
    public static final ImagePiplinePriority LOW = null;
    public static final ImagePiplinePriority MEDIUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImagePiplinePriority[] f254612a = null;

    static {
        ImagePiplinePriority r100 = new ImagePiplinePriority("LOW", 0);
        LOW = r100;
        ImagePiplinePriority r101 = new ImagePiplinePriority("MEDIUM", 1);
        MEDIUM = r101;
        ImagePiplinePriority r102 = new ImagePiplinePriority("HIGH", 2);
        HIGH = r102;
        ImagePiplinePriority r103 = new ImagePiplinePriority("IMMEDIATE", 3);
        IMMEDIATE = r103;
        f254612a = new ImagePiplinePriority[]{r100, r101, r102, r103};
    }

    public static ImagePiplinePriority[] values() {
        return (ImagePiplinePriority[]) f254612a.clone();
    }

    public static ImagePiplinePriority convertToPriority(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 == 4) goto L17;
        return MEDIUM;
    L17:
        return IMMEDIATE;
    L18:
        return HIGH;
    L19:
        return MEDIUM;
    L15:
        return LOW;
    }

    public static ImagePiplinePriority valueOf(String r100) {
        return (ImagePiplinePriority) a.a(ImagePiplinePriority.class, r100);
    }

    public ImagePiplinePriority(String r100, int r101) {
        super(r100, r101);
    }

    public static ImagePiplinePriority getHigherPriority(ImagePiplinePriority r100, ImagePiplinePriority r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L7;
        return r100;
    L7:
        if (r100.ordinal() <= r101.ordinal()) goto L9;
        return r100;
    L9:
        return r101;
    }
}
