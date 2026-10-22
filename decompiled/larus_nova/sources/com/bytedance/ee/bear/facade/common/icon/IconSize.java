package com.bytedance.ee.bear.facade.common.icon;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum IconSize extends Enum<IconSize> {
    public static final IconSize SIZE_24 = null;
    public static final IconSize SIZE_48 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconSize[] f226428a = null;

    static {
        IconSize r100 = new IconSize("SIZE_24", 0);
        SIZE_24 = r100;
        IconSize r101 = new IconSize("SIZE_48", 1);
        SIZE_48 = r101;
        f226428a = new IconSize[]{r100, r101};
    }

    public static IconSize[] values() {
        return (IconSize[]) f226428a.clone();
    }

    public static IconSize valueOf(String r100) {
        return (IconSize) a.a(IconSize.class, r100);
    }

    public IconSize(String r100, int r101) {
        super(r100, r101);
    }
}
