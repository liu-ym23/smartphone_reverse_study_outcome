package com.lynx.animax.base;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum VisibilityState extends Enum<VisibilityState> {
    public static final VisibilityState AGGREGATED = null;
    public static final VisibilityState ATTACH = null;
    public static final VisibilityState BACKGROUND = null;
    public static final VisibilityState OPACITY = null;
    public static final VisibilityState SIZE = null;
    public static final VisibilityState VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VisibilityState[] f380256a = null;
    private final int value;

    static {
        VisibilityState r100 = new VisibilityState("BACKGROUND", 0, 1);
        BACKGROUND = r100;
        VisibilityState r101 = new VisibilityState("VISIBLE", 1, 2);
        VISIBLE = r101;
        VisibilityState r102 = new VisibilityState("OPACITY", 2, 4);
        OPACITY = r102;
        VisibilityState r103 = new VisibilityState("SIZE", 3, 8);
        SIZE = r103;
        VisibilityState r104 = new VisibilityState("ATTACH", 4, 16);
        ATTACH = r104;
        VisibilityState r105 = new VisibilityState("AGGREGATED", 5, 32);
        AGGREGATED = r105;
        f380256a = new VisibilityState[]{r100, r101, r102, r103, r104, r105};
    }

    public static VisibilityState[] values() {
        return (VisibilityState[]) f380256a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static VisibilityState valueOf(String r100) {
        return (VisibilityState) a.a(VisibilityState.class, r100);
    }

    public VisibilityState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
