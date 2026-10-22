package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TimeUnit extends Enum<TimeUnit> implements WireEnum {
    private static final /* synthetic */ TimeUnit[] $VALUES = null;
    public static final ProtoAdapter<TimeUnit> ADAPTER = null;
    public static final TimeUnit DAY = null;
    public static final TimeUnit HOUR = null;
    public static final TimeUnit MINUTE = null;
    public static final TimeUnit MONTH = null;
    public static final TimeUnit SECOND = null;
    public static final TimeUnit YEAR = null;
    private final int value;

    static {
        TimeUnit r100 = new TimeUnit("SECOND", 0, 0);
        SECOND = r100;
        TimeUnit r101 = new TimeUnit("MINUTE", 1, 1);
        MINUTE = r101;
        TimeUnit r102 = new TimeUnit("HOUR", 2, 2);
        HOUR = r102;
        TimeUnit r103 = new TimeUnit("DAY", 3, 3);
        DAY = r103;
        TimeUnit r104 = new TimeUnit("MONTH", 4, 4);
        MONTH = r104;
        TimeUnit r105 = new TimeUnit("YEAR", 5, 5);
        YEAR = r105;
        $VALUES = new TimeUnit[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(TimeUnit.class);
    }

    public static TimeUnit[] values() {
        return (TimeUnit[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TimeUnit fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return YEAR;
    L18:
        return MONTH;
    L20:
        return DAY;
    L22:
        return HOUR;
    L24:
        return MINUTE;
    L26:
        return SECOND;
    }

    public static TimeUnit valueOf(String r100) {
        return (TimeUnit) a.a(TimeUnit.class, r100);
    }

    private TimeUnit(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
