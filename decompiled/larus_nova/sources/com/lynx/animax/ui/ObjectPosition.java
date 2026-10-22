package com.lynx.animax.ui;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum ObjectPosition extends Enum<ObjectPosition> {
    public static final ObjectPosition BOTTOM = null;
    public static final ObjectPosition BOTTOM_LEFT = null;
    public static final ObjectPosition BOTTOM_RIGHT = null;
    public static final ObjectPosition CENTER = null;
    public static final ObjectPosition LEFT = null;
    public static final ObjectPosition RIGHT = null;
    public static final ObjectPosition TOP = null;
    public static final ObjectPosition TOP_LEFT = null;
    public static final ObjectPosition TOP_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObjectPosition[] f380462a = null;

    static {
        ObjectPosition r100 = new ObjectPosition("CENTER", 0);
        CENTER = r100;
        ObjectPosition r101 = new ObjectPosition("LEFT", 1);
        LEFT = r101;
        ObjectPosition r102 = new ObjectPosition("RIGHT", 2);
        RIGHT = r102;
        ObjectPosition r103 = new ObjectPosition("TOP", 3);
        TOP = r103;
        ObjectPosition r104 = new ObjectPosition("BOTTOM", 4);
        BOTTOM = r104;
        ObjectPosition r105 = new ObjectPosition("TOP_LEFT", 5);
        TOP_LEFT = r105;
        ObjectPosition r110 = new ObjectPosition("TOP_RIGHT", 6);
        TOP_RIGHT = r110;
        ObjectPosition r111 = new ObjectPosition("BOTTOM_LEFT", 7);
        BOTTOM_LEFT = r111;
        ObjectPosition r112 = new ObjectPosition("BOTTOM_RIGHT", 8);
        BOTTOM_RIGHT = r112;
        f380462a = new ObjectPosition[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ObjectPosition[] values() {
        return (ObjectPosition[]) f380462a.clone();
    }

    public static ObjectPosition valueOf(String r100) {
        return (ObjectPosition) a.a(ObjectPosition.class, r100);
    }

    public ObjectPosition(String r100, int r101) {
        super(r100, r101);
    }
}
