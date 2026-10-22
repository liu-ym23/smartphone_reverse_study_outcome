package com.bytedance.ee.bear.onboarding.export;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum Direction extends Enum<Direction> {
    public static final Direction DOWN = null;
    public static final Direction NONE = null;
    public static final Direction UP = null;
    public static final /* synthetic */ Direction[] a = null;

    static {
        Direction r0 = new Direction("UP", 0);
        UP = r0;
        Direction r1 = new Direction("DOWN", 1);
        DOWN = r1;
        Direction r3 = new Direction("NONE", 2);
        NONE = r3;
        a = new Direction[]{r0, r1, r3};
    }

    public static Direction[] values() {
        return (Direction[]) a.clone();
    }

    public static Direction valueOf(String r1) {
        return (Direction) a.a(Direction.class, r1);
    }

    public Direction(String r1, int r2) {
        super(r1, r2);
    }
}
