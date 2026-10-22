package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum StartTimeGroupCategory extends Enum<StartTimeGroupCategory> implements WireEnum {
    private static final /* synthetic */ StartTimeGroupCategory[] $VALUES = null;
    public static final ProtoAdapter<StartTimeGroupCategory> ADAPTER = null;
    public static final StartTimeGroupCategory ALREADY_STARTED = null;
    public static final StartTimeGroupCategory START_LATER = null;
    public static final StartTimeGroupCategory START_NEXT_SEVEN_DAYS = null;
    public static final StartTimeGroupCategory START_TODAY = null;
    public static final StartTimeGroupCategory START_TOMORROW = null;
    public static final StartTimeGroupCategory START_UNSCHEDULED = null;
    public static final StartTimeGroupCategory UNKNOWN_START_TIME = null;
    private final int value;

    static {
        StartTimeGroupCategory r100 = new StartTimeGroupCategory("UNKNOWN_START_TIME", 0, 0);
        UNKNOWN_START_TIME = r100;
        StartTimeGroupCategory r101 = new StartTimeGroupCategory("ALREADY_STARTED", 1, 1);
        ALREADY_STARTED = r101;
        StartTimeGroupCategory r102 = new StartTimeGroupCategory("START_TODAY", 2, 2);
        START_TODAY = r102;
        StartTimeGroupCategory r103 = new StartTimeGroupCategory("START_TOMORROW", 3, 3);
        START_TOMORROW = r103;
        StartTimeGroupCategory r104 = new StartTimeGroupCategory("START_NEXT_SEVEN_DAYS", 4, 4);
        START_NEXT_SEVEN_DAYS = r104;
        StartTimeGroupCategory r105 = new StartTimeGroupCategory("START_LATER", 5, 5);
        START_LATER = r105;
        StartTimeGroupCategory r110 = new StartTimeGroupCategory("START_UNSCHEDULED", 6, 6);
        START_UNSCHEDULED = r110;
        $VALUES = new StartTimeGroupCategory[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(StartTimeGroupCategory.class);
    }

    public static StartTimeGroupCategory[] values() {
        return (StartTimeGroupCategory[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static StartTimeGroupCategory fromValue(int r100) {
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
        return START_UNSCHEDULED;
    L8:
        return START_LATER;
    L10:
        return START_NEXT_SEVEN_DAYS;
    L12:
        return START_TOMORROW;
    L14:
        return START_TODAY;
    L16:
        return ALREADY_STARTED;
    L18:
        return UNKNOWN_START_TIME;
    }

    public static StartTimeGroupCategory valueOf(String r100) {
        return (StartTimeGroupCategory) a.a(StartTimeGroupCategory.class, r100);
    }

    private StartTimeGroupCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
