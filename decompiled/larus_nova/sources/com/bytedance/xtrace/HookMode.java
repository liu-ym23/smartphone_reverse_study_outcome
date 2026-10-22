package com.bytedance.xtrace;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum HookMode extends Enum {
    private static final /* synthetic */ HookMode[] $VALUES = null;
    public static final HookMode MODE_ALL = null;
    public static final HookMode MODE_REPLACE = null;
    public static final HookMode MODE_TRACE = null;

    static {
        HookMode r100 = new HookMode("MODE_TRACE", 0);
        MODE_TRACE = r100;
        HookMode r101 = new HookMode("MODE_REPLACE", 1);
        MODE_REPLACE = r101;
        HookMode r102 = new HookMode("MODE_ALL", 2);
        MODE_ALL = r102;
        $VALUES = new HookMode[]{r100, r101, r102};
    }

    private HookMode(String r100, int r101) {
        super(r100, r101);
    }

    public static HookMode valueOf(String r100) {
        return (HookMode) a.a(HookMode.class, r100);
    }

    public static HookMode[] values() {
        return (HookMode[]) $VALUES.clone();
    }
}
