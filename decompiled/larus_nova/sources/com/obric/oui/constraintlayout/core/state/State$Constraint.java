package com.obric.oui.constraintlayout.core.state;

/* JADX INFO: loaded from: classes34.dex */
public final enum State$Constraint extends Enum<State$Constraint> {
    public static final State$Constraint BASELINE_TO_BASELINE = null;
    public static final State$Constraint BASELINE_TO_BOTTOM = null;
    public static final State$Constraint BASELINE_TO_TOP = null;
    public static final State$Constraint BOTTOM_TO_BASELINE = null;
    public static final State$Constraint BOTTOM_TO_BOTTOM = null;
    public static final State$Constraint BOTTOM_TO_TOP = null;
    public static final State$Constraint CENTER_HORIZONTALLY = null;
    public static final State$Constraint CENTER_VERTICALLY = null;
    public static final State$Constraint CIRCULAR_CONSTRAINT = null;
    public static final State$Constraint END_TO_END = null;
    public static final State$Constraint END_TO_START = null;
    public static final State$Constraint LEFT_TO_LEFT = null;
    public static final State$Constraint LEFT_TO_RIGHT = null;
    public static final State$Constraint RIGHT_TO_LEFT = null;
    public static final State$Constraint RIGHT_TO_RIGHT = null;
    public static final State$Constraint START_TO_END = null;
    public static final State$Constraint START_TO_START = null;
    public static final State$Constraint TOP_TO_BASELINE = null;
    public static final State$Constraint TOP_TO_BOTTOM = null;
    public static final State$Constraint TOP_TO_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Constraint[] f399683a = null;

    static {
        State$Constraint r100 = new State$Constraint("LEFT_TO_LEFT", 0);
        LEFT_TO_LEFT = r100;
        State$Constraint r101 = new State$Constraint("LEFT_TO_RIGHT", 1);
        LEFT_TO_RIGHT = r101;
        State$Constraint r102 = new State$Constraint("RIGHT_TO_LEFT", 2);
        RIGHT_TO_LEFT = r102;
        State$Constraint r103 = new State$Constraint("RIGHT_TO_RIGHT", 3);
        RIGHT_TO_RIGHT = r103;
        State$Constraint r104 = new State$Constraint("START_TO_START", 4);
        START_TO_START = r104;
        State$Constraint r105 = new State$Constraint("START_TO_END", 5);
        START_TO_END = r105;
        State$Constraint r110 = new State$Constraint("END_TO_START", 6);
        END_TO_START = r110;
        State$Constraint r111 = new State$Constraint("END_TO_END", 7);
        END_TO_END = r111;
        State$Constraint r112 = new State$Constraint("TOP_TO_TOP", 8);
        TOP_TO_TOP = r112;
        State$Constraint r113 = new State$Constraint("TOP_TO_BOTTOM", 9);
        TOP_TO_BOTTOM = r113;
        State$Constraint r114 = new State$Constraint("TOP_TO_BASELINE", 10);
        TOP_TO_BASELINE = r114;
        State$Constraint r115 = new State$Constraint("BOTTOM_TO_TOP", 11);
        BOTTOM_TO_TOP = r115;
        State$Constraint r106 = new State$Constraint("BOTTOM_TO_BOTTOM", 12);
        BOTTOM_TO_BOTTOM = r106;
        State$Constraint r107 = new State$Constraint("BOTTOM_TO_BASELINE", 13);
        BOTTOM_TO_BASELINE = r107;
        State$Constraint r108 = new State$Constraint("BASELINE_TO_BASELINE", 14);
        BASELINE_TO_BASELINE = r108;
        State$Constraint r109 = new State$Constraint("BASELINE_TO_TOP", 15);
        BASELINE_TO_TOP = r109;
        State$Constraint r116 = new State$Constraint("BASELINE_TO_BOTTOM", 16);
        BASELINE_TO_BOTTOM = r116;
        State$Constraint r117 = new State$Constraint("CENTER_HORIZONTALLY", 17);
        CENTER_HORIZONTALLY = r117;
        State$Constraint r118 = new State$Constraint("CENTER_VERTICALLY", 18);
        CENTER_VERTICALLY = r118;
        State$Constraint r119 = new State$Constraint("CIRCULAR_CONSTRAINT", 19);
        CIRCULAR_CONSTRAINT = r119;
        f399683a = new State$Constraint[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
    }

    public static State$Constraint[] values() {
        return (State$Constraint[]) f399683a.clone();
    }

    public static State$Constraint valueOf(String r100) {
        return (State$Constraint) r27.a.a(State$Constraint.class, r100);
    }

    public State$Constraint(String r100, int r101) {
        super(r100, r101);
    }
}
