package com.bytedance.ee.bear.contract.imageviewer.bean;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ImageType extends Enum<ImageType> {
    public static final ImageType DIAGRAM = null;
    public static final ImageType IMAGE = null;
    public static final /* synthetic */ ImageType[] a = null;
    public String uuidPrefix;

    static {
        ImageType r0 = new ImageType("IMAGE", 0, "image_");
        IMAGE = r0;
        ImageType r1 = new ImageType("DIAGRAM", 1, "diagram_");
        DIAGRAM = r1;
        a = new ImageType[]{r0, r1};
    }

    public static ImageType[] values() {
        return (ImageType[]) a.clone();
    }

    public static ImageType getType(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L11;
        ImageType r0 = IMAGE;
        if (r2.startsWith(r0.uuidPrefix) == false) goto L7;
        return r0;
    L7:
        ImageType r1 = DIAGRAM;
        if (r2.startsWith(r1.uuidPrefix) == false) goto L11;
        return r1;
    L11:
        return IMAGE;
    }

    public static ImageType valueOf(String r1) {
        return (ImageType) r27.a.a(ImageType.class, r1);
    }

    public ImageType(String r1, int r2, String r3) {
        super(r1, r2);
        this.uuidPrefix = r3;
    }
}
