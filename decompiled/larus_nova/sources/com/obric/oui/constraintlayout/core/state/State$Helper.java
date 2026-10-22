package com.obric.oui.constraintlayout.core.state;

import com.bytedance.ee.bear.sheet.fab.FabItem;

/* JADX INFO: loaded from: classes34.dex */
public final enum State$Helper extends Enum<State$Helper> {
    public static final State$Helper ALIGN_HORIZONTALLY = null;
    public static final State$Helper ALIGN_VERTICALLY = null;
    public static final State$Helper BARRIER = null;
    public static final State$Helper COLUMN = null;
    public static final State$Helper FLOW = null;
    public static final State$Helper GRID = null;
    public static final State$Helper HORIZONTAL_CHAIN = null;
    public static final State$Helper HORIZONTAL_FLOW = null;
    public static final State$Helper LAYER = null;
    public static final State$Helper ROW = null;
    public static final State$Helper VERTICAL_CHAIN = null;
    public static final State$Helper VERTICAL_FLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Helper[] f399685a = null;

    static {
        State$Helper r100 = new State$Helper("HORIZONTAL_CHAIN", 0);
        HORIZONTAL_CHAIN = r100;
        State$Helper r101 = new State$Helper("VERTICAL_CHAIN", 1);
        VERTICAL_CHAIN = r101;
        State$Helper r102 = new State$Helper("ALIGN_HORIZONTALLY", 2);
        ALIGN_HORIZONTALLY = r102;
        State$Helper r103 = new State$Helper("ALIGN_VERTICALLY", 3);
        ALIGN_VERTICALLY = r103;
        State$Helper r104 = new State$Helper("BARRIER", 4);
        BARRIER = r104;
        State$Helper r105 = new State$Helper("LAYER", 5);
        LAYER = r105;
        State$Helper r110 = new State$Helper("HORIZONTAL_FLOW", 6);
        HORIZONTAL_FLOW = r110;
        State$Helper r111 = new State$Helper("VERTICAL_FLOW", 7);
        VERTICAL_FLOW = r111;
        State$Helper r112 = new State$Helper("GRID", 8);
        GRID = r112;
        State$Helper r113 = new State$Helper(FabItem.FabSheetItem.CellType.ROW, 9);
        ROW = r113;
        State$Helper r114 = new State$Helper("COLUMN", 10);
        COLUMN = r114;
        State$Helper r115 = new State$Helper("FLOW", 11);
        FLOW = r115;
        f399685a = new State$Helper[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static State$Helper[] values() {
        return (State$Helper[]) f399685a.clone();
    }

    public static State$Helper valueOf(String r100) {
        return (State$Helper) r27.a.a(State$Helper.class, r100);
    }

    public State$Helper(String r100, int r101) {
        super(r100, r101);
    }
}
