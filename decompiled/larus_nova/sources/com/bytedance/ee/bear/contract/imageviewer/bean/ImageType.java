package com.bytedance.ee.bear.contract.imageviewer.bean;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final enum ImageType extends Enum<ImageType> {
    public static final ImageType DIAGRAM = null;
    public static final ImageType IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageType[] f217076a = null;
    public String uuidPrefix;

    static {
        ImageType r100 = new ImageType("IMAGE", 0, "image_");
        IMAGE = r100;
        ImageType r101 = new ImageType("DIAGRAM", 1, "diagram_");
        DIAGRAM = r101;
        f217076a = new ImageType[]{r100, r101};
    }

    public static ImageType[] values() {
        return (ImageType[]) f217076a.clone();
    }

    public static ImageType getType(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        ImageType r101 = IMAGE;
        if (r100.startsWith(r101.uuidPrefix) == false) goto L7;
        return r101;
    L7:
        ImageType r102 = DIAGRAM;
        if (r100.startsWith(r102.uuidPrefix) == false) goto L11;
        return r102;
    L11:
        return IMAGE;
    }

    public static ImageType valueOf(String r100) {
        return (ImageType) r27.a.a(ImageType.class, r100);
    }

    public ImageType(String r100, int r101, String r102) {
        super(r100, r101);
        this.uuidPrefix = r102;
    }
}
