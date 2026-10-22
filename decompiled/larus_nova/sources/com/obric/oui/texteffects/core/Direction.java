package com.obric.oui.texteffects.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/core/Direction;", "", "LeftToRight", "RightToLeft", "TopToBottom", "BottomToTop", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum Direction extends Enum<Direction> {
    public static final Direction BottomToTop = null;
    public static final Direction LeftToRight = null;
    public static final Direction RightToLeft = null;
    public static final Direction TopToBottom = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f403302a = null;

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    public static Direction[] values() {
        return (Direction[]) f403302a.clone();
    }

    static {
        Direction r100 = new Direction("LeftToRight", 0);
        LeftToRight = r100;
        Direction r101 = new Direction("RightToLeft", 1);
        RightToLeft = r101;
        Direction r102 = new Direction("TopToBottom", 2);
        TopToBottom = r102;
        Direction r103 = new Direction("BottomToTop", 3);
        BottomToTop = r103;
        f403302a = new Direction[]{r100, r101, r102, r103};
    }

    public Direction(String r100, int r101) {
        super(r100, r101);
    }
}
