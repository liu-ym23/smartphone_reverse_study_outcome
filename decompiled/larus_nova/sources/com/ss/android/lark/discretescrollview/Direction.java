package com.ss.android.lark.discretescrollview;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes35.dex */
abstract enum Direction extends Enum<Direction> {
    public static final Direction END = null;
    public static final Direction START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f420412a = null;

    public Direction() {
        throw null;
    }

    public abstract int applyTo(int r100);

    public abstract Direction reverse();

    public abstract boolean sameAs(int r100);

    static {
        final String r100 = GXAnimation.STATE_START;
        final int r101 = 0;
        Direction r102 = new AnonymousClass1(r100, r101);
        START = r102;
        final String r103 = GXAnimation.STATE_END;
        final int r104 = 1;
        Direction r105 = new AnonymousClass2(r103, r104);
        END = r105;
        f420412a = new Direction[]{r102, r105};
    }

    public static Direction[] values() {
        return (Direction[]) f420412a.clone();
    }

    public static Direction fromDelta(int r100) {
        if (r100 <= 0) goto L5;
        return END;
    L5:
        return START;
    }

    public static Direction valueOf(String r100) {
        return (Direction) r27.a.a(Direction.class, r100);
    }

    public Direction(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }
}
