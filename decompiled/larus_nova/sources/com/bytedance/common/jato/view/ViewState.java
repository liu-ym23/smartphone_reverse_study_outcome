package com.bytedance.common.jato.view;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ViewState extends Enum<ViewState> {
    private static final /* synthetic */ ViewState[] $VALUES = null;
    public static final ViewState Attached = null;
    public static final ViewState Created = null;
    public static final ViewState Destroyed = null;
    public static final ViewState Detached = null;
    public static final ViewState Unknown = null;
    private final int value;

    static {
        ViewState r100 = new ViewState("Created", 0, 0);
        Created = r100;
        ViewState r101 = new ViewState("Attached", 1, 1);
        Attached = r101;
        ViewState r102 = new ViewState("Detached", 2, 2);
        Detached = r102;
        ViewState r103 = new ViewState("Destroyed", 3, 3);
        Destroyed = r103;
        ViewState r104 = new ViewState("Unknown", 4, 4);
        Unknown = r104;
        $VALUES = new ViewState[]{r100, r101, r102, r103, r104};
    }

    public static ViewState[] values() {
        return (ViewState[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ViewState valueOf(String r100) {
        return (ViewState) a.a(ViewState.class, r100);
    }

    public boolean lessThan(ViewState r100) {
        if (this.value >= r100.value) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean notGreaterThan(ViewState r100) {
        if (this.value > r100.value) goto L5;
        return true;
    L5:
        return false;
    }

    private ViewState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
