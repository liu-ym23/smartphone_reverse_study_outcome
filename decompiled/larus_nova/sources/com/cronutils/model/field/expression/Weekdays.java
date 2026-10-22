package com.cronutils.model.field.expression;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.DayOfWeekFieldDefinition;
import qr7.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum Weekdays extends Enum<Weekdays> {
    public static final Weekdays FRIDAY = null;
    public static final Weekdays MONDAY = null;
    public static final Weekdays SATURDAY = null;
    public static final Weekdays SUNDAY = null;
    public static final Weekdays THURSDAY = null;
    public static final Weekdays TUESDAY = null;
    public static final Weekdays WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Weekdays[] f273561a = null;
    private int weekday;

    static {
        Weekdays r100 = new Weekdays("MONDAY", 0, 1);
        MONDAY = r100;
        Weekdays r101 = new Weekdays("TUESDAY", 1, 2);
        TUESDAY = r101;
        Weekdays r102 = new Weekdays("WEDNESDAY", 2, 3);
        WEDNESDAY = r102;
        Weekdays r103 = new Weekdays("THURSDAY", 3, 4);
        THURSDAY = r103;
        Weekdays r104 = new Weekdays("FRIDAY", 4, 5);
        FRIDAY = r104;
        Weekdays r110 = new Weekdays("SATURDAY", 5, 6);
        SATURDAY = r110;
        Weekdays r111 = new Weekdays("SUNDAY", 6, 7);
        SUNDAY = r111;
        f273561a = new Weekdays[]{r100, r101, r102, r103, r104, r110, r111};
    }

    public static Weekdays[] values() {
        return (Weekdays[]) f273561a.clone();
    }

    public int getWeekday() {
        return getWeekday(a.f534621b);
    }

    public static Weekdays valueOf(String r100) {
        return (Weekdays) r27.a.a(Weekdays.class, r100);
    }

    public int getWeekday(CronDefinition r100) {
        return getWeekday(((DayOfWeekFieldDefinition) r100.getFieldDefinition(CronFieldName.DAY_OF_WEEK)).getMondayDoWValue());
    }

    public int getWeekday(WeekDay r100) {
        return a.f534621b.mapTo(this.weekday, r100);
    }

    public Weekdays(String r100, int r101, int r102) {
        super(r100, r101);
        this.weekday = r102;
    }
}
