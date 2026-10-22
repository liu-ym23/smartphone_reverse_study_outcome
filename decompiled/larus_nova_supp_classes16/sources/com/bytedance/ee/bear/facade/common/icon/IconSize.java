package com.bytedance.ee.bear.facade.common.icon;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum IconSize extends Enum<IconSize> {
    public static final IconSize SIZE_24 = null;
    public static final IconSize SIZE_48 = null;
    public static final /* synthetic */ IconSize[] a = null;

    static {
        IconSize r0 = new IconSize("SIZE_24", 0);
        SIZE_24 = r0;
        IconSize r1 = new IconSize("SIZE_48", 1);
        SIZE_48 = r1;
        a = new IconSize[]{r0, r1};
    }

    public static IconSize[] values() {
        return (IconSize[]) a.clone();
    }

    public static IconSize valueOf(String r1) {
        return (IconSize) a.a(IconSize.class, r1);
    }

    public IconSize(String r1, int r2) {
        super(r1, r2);
    }
}
