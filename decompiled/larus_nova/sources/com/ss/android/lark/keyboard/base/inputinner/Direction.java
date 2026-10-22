package com.ss.android.lark.keyboard.base.inputinner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/keyboard/base/inputinner/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "InnerStart", "InnerTop", "InnerEnd", "InnerBottom", "Top", "TopExpand", "InnerEndVertical", "TopMiddle", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Direction extends Enum<Direction> {
    public static final Direction InnerBottom = null;
    public static final Direction InnerEnd = null;
    public static final Direction InnerEndVertical = null;
    public static final Direction InnerStart = null;
    public static final Direction InnerTop = null;
    public static final Direction Top = null;
    public static final Direction TopExpand = null;
    public static final Direction TopMiddle = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f428232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f428233b = null;

    public static EnumEntries<Direction> getEntries() {
        return f428233b;
    }

    static {
        Direction r100 = new Direction("InnerStart", 0);
        InnerStart = r100;
        Direction r101 = new Direction("InnerTop", 1);
        InnerTop = r101;
        Direction r102 = new Direction("InnerEnd", 2);
        InnerEnd = r102;
        Direction r103 = new Direction("InnerBottom", 3);
        InnerBottom = r103;
        Direction r104 = new Direction("Top", 4);
        Top = r104;
        Direction r105 = new Direction("TopExpand", 5);
        TopExpand = r105;
        Direction r110 = new Direction("InnerEndVertical", 6);
        InnerEndVertical = r110;
        Direction r111 = new Direction("TopMiddle", 7);
        TopMiddle = r111;
        Direction[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f428232a = r112;
        f428233b = EnumEntriesKt.enumEntries(r112);
    }

    public static Direction[] values() {
        return (Direction[]) f428232a.clone();
    }

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    public Direction(String r100, int r101) {
        super(r100, r101);
    }
}
