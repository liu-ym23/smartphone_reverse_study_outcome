package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DueTimeGroupCategory extends Enum<DueTimeGroupCategory> implements WireEnum {
    private static final /* synthetic */ DueTimeGroupCategory[] $VALUES = null;
    public static final ProtoAdapter<DueTimeGroupCategory> ADAPTER = null;
    public static final DueTimeGroupCategory LATER = null;
    public static final DueTimeGroupCategory NEXT_SEVEN_DAYS = null;
    public static final DueTimeGroupCategory OVERDUE = null;
    public static final DueTimeGroupCategory TODAY = null;
    public static final DueTimeGroupCategory TOMORROW = null;
    public static final DueTimeGroupCategory UNKNOWN_DUE_TIME = null;
    public static final DueTimeGroupCategory UNSCHEDULED = null;
    private final int value;

    static {
        DueTimeGroupCategory r100 = new DueTimeGroupCategory("UNKNOWN_DUE_TIME", 0, 0);
        UNKNOWN_DUE_TIME = r100;
        DueTimeGroupCategory r101 = new DueTimeGroupCategory("OVERDUE", 1, 1);
        OVERDUE = r101;
        DueTimeGroupCategory r102 = new DueTimeGroupCategory("TODAY", 2, 2);
        TODAY = r102;
        DueTimeGroupCategory r103 = new DueTimeGroupCategory("TOMORROW", 3, 3);
        TOMORROW = r103;
        DueTimeGroupCategory r104 = new DueTimeGroupCategory("NEXT_SEVEN_DAYS", 4, 4);
        NEXT_SEVEN_DAYS = r104;
        DueTimeGroupCategory r105 = new DueTimeGroupCategory("LATER", 5, 5);
        LATER = r105;
        DueTimeGroupCategory r110 = new DueTimeGroupCategory("UNSCHEDULED", 6, 6);
        UNSCHEDULED = r110;
        $VALUES = new DueTimeGroupCategory[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(DueTimeGroupCategory.class);
    }

    public static DueTimeGroupCategory[] values() {
        return (DueTimeGroupCategory[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DueTimeGroupCategory fromValue(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return UNSCHEDULED;
    L8:
        return LATER;
    L10:
        return NEXT_SEVEN_DAYS;
    L12:
        return TOMORROW;
    L14:
        return TODAY;
    L16:
        return OVERDUE;
    L18:
        return UNKNOWN_DUE_TIME;
    }

    public static DueTimeGroupCategory valueOf(String r100) {
        return (DueTimeGroupCategory) a.a(DueTimeGroupCategory.class, r100);
    }

    private DueTimeGroupCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
