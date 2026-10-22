package com.ss.android.lark.keyboard.slot;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/slot/SlotPosition;", "", "<init>", "(Ljava/lang/String;I)V", "INNER_LEFT", "INNER_TOP", "INNER_RIGHT", "INNER_BOTTOM", "TOP", "TOP_EXTEND", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SlotPosition extends Enum<SlotPosition> {
    public static final SlotPosition INNER_BOTTOM = null;
    public static final SlotPosition INNER_LEFT = null;
    public static final SlotPosition INNER_RIGHT = null;
    public static final SlotPosition INNER_TOP = null;
    public static final SlotPosition TOP = null;
    public static final SlotPosition TOP_EXTEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlotPosition[] f430944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f430945b = null;

    public static EnumEntries<SlotPosition> getEntries() {
        return f430945b;
    }

    static {
        SlotPosition r100 = new SlotPosition("INNER_LEFT", 0);
        INNER_LEFT = r100;
        SlotPosition r101 = new SlotPosition("INNER_TOP", 1);
        INNER_TOP = r101;
        SlotPosition r102 = new SlotPosition("INNER_RIGHT", 2);
        INNER_RIGHT = r102;
        SlotPosition r103 = new SlotPosition("INNER_BOTTOM", 3);
        INNER_BOTTOM = r103;
        SlotPosition r104 = new SlotPosition("TOP", 4);
        TOP = r104;
        SlotPosition r105 = new SlotPosition("TOP_EXTEND", 5);
        TOP_EXTEND = r105;
        SlotPosition[] r110 = {r100, r101, r102, r103, r104, r105};
        f430944a = r110;
        f430945b = EnumEntriesKt.enumEntries(r110);
    }

    public static SlotPosition[] values() {
        return (SlotPosition[]) f430944a.clone();
    }

    public static SlotPosition valueOf(String r100) {
        return (SlotPosition) a.a(SlotPosition.class, r100);
    }

    public SlotPosition(String r100, int r101) {
        super(r100, r101);
    }
}
