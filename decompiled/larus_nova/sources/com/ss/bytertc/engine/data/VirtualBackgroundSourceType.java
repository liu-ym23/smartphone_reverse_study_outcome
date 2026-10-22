package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VirtualBackgroundSourceType extends Enum<VirtualBackgroundSourceType> {
    private static final /* synthetic */ VirtualBackgroundSourceType[] $VALUES = null;
    public static final VirtualBackgroundSourceType COLOR = null;
    public static final VirtualBackgroundSourceType IMAGE = null;

    static {
        VirtualBackgroundSourceType r100 = new VirtualBackgroundSourceType("COLOR", 0);
        COLOR = r100;
        VirtualBackgroundSourceType r101 = new VirtualBackgroundSourceType("IMAGE", 1);
        IMAGE = r101;
        $VALUES = new VirtualBackgroundSourceType[]{r100, r101};
    }

    public static VirtualBackgroundSourceType[] values() {
        return (VirtualBackgroundSourceType[]) $VALUES.clone();
    }

    public static VirtualBackgroundSourceType valueOf(String r100) {
        return (VirtualBackgroundSourceType) a.a(VirtualBackgroundSourceType.class, r100);
    }

    private VirtualBackgroundSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
