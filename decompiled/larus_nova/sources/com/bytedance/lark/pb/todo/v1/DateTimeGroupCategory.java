package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DateTimeGroupCategory extends Enum<DateTimeGroupCategory> implements WireEnum {
    private static final /* synthetic */ DateTimeGroupCategory[] $VALUES = null;
    public static final ProtoAdapter<DateTimeGroupCategory> ADAPTER = null;
    public static final DateTimeGroupCategory DATE_TIME_FUTURE = null;
    public static final DateTimeGroupCategory DATE_TIME_OVER = null;
    public static final DateTimeGroupCategory DATE_TIME_TODAY = null;
    public static final DateTimeGroupCategory DATE_TIME_TOMORROW = null;
    public static final DateTimeGroupCategory DATE_TIME_UNSCHEDULED = null;
    public static final DateTimeGroupCategory UNKNOWN_DATE_TIME = null;
    private final int value;

    static {
        DateTimeGroupCategory r100 = new DateTimeGroupCategory("UNKNOWN_DATE_TIME", 0, 0);
        UNKNOWN_DATE_TIME = r100;
        DateTimeGroupCategory r101 = new DateTimeGroupCategory("DATE_TIME_OVER", 1, 1);
        DATE_TIME_OVER = r101;
        DateTimeGroupCategory r102 = new DateTimeGroupCategory("DATE_TIME_TODAY", 2, 2);
        DATE_TIME_TODAY = r102;
        DateTimeGroupCategory r103 = new DateTimeGroupCategory("DATE_TIME_TOMORROW", 3, 3);
        DATE_TIME_TOMORROW = r103;
        DateTimeGroupCategory r104 = new DateTimeGroupCategory("DATE_TIME_FUTURE", 4, 4);
        DATE_TIME_FUTURE = r104;
        DateTimeGroupCategory r105 = new DateTimeGroupCategory("DATE_TIME_UNSCHEDULED", 5, 5);
        DATE_TIME_UNSCHEDULED = r105;
        $VALUES = new DateTimeGroupCategory[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(DateTimeGroupCategory.class);
    }

    public static DateTimeGroupCategory[] values() {
        return (DateTimeGroupCategory[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DateTimeGroupCategory fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return DATE_TIME_UNSCHEDULED;
    L18:
        return DATE_TIME_FUTURE;
    L20:
        return DATE_TIME_TOMORROW;
    L22:
        return DATE_TIME_TODAY;
    L24:
        return DATE_TIME_OVER;
    L26:
        return UNKNOWN_DATE_TIME;
    }

    public static DateTimeGroupCategory valueOf(String r100) {
        return (DateTimeGroupCategory) a.a(DateTimeGroupCategory.class, r100);
    }

    private DateTimeGroupCategory(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
