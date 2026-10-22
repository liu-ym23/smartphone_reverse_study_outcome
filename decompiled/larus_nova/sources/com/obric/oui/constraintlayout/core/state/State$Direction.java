package com.obric.oui.constraintlayout.core.state;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes34.dex */
public final enum State$Direction extends Enum<State$Direction> {
    public static final State$Direction BOTTOM = null;
    public static final State$Direction END = null;
    public static final State$Direction LEFT = null;
    public static final State$Direction RIGHT = null;
    public static final State$Direction START = null;
    public static final State$Direction TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State$Direction[] f399684a = null;

    static {
        State$Direction r100 = new State$Direction("LEFT", 0);
        LEFT = r100;
        State$Direction r101 = new State$Direction("RIGHT", 1);
        RIGHT = r101;
        State$Direction r102 = new State$Direction(GXAnimation.STATE_START, 2);
        START = r102;
        State$Direction r103 = new State$Direction(GXAnimation.STATE_END, 3);
        END = r103;
        State$Direction r104 = new State$Direction("TOP", 4);
        TOP = r104;
        State$Direction r105 = new State$Direction("BOTTOM", 5);
        BOTTOM = r105;
        f399684a = new State$Direction[]{r100, r101, r102, r103, r104, r105};
    }

    public static State$Direction[] values() {
        return (State$Direction[]) f399684a.clone();
    }

    public static State$Direction valueOf(String r100) {
        return (State$Direction) r27.a.a(State$Direction.class, r100);
    }

    public State$Direction(String r100, int r101) {
        super(r100, r101);
    }
}
