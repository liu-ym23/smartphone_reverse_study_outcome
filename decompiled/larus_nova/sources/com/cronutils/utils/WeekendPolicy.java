package com.cronutils.utils;

import java.time.ZonedDateTime;

/* JADX INFO: loaded from: classes22.dex */
public final enum WeekendPolicy extends Enum<WeekendPolicy> {
    public static final WeekendPolicy FRIDAY_SATURDAY = null;
    public static final WeekendPolicy SATURDAY_SUNDAY = null;
    public static final WeekendPolicy THURSDAY_FRIDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WeekendPolicy[] f273563a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f273564a = null;

        static {
            int[] r100 = new int[WeekendPolicy.values().length];
            f273564a = r100;
            r100[WeekendPolicy.THURSDAY_FRIDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f273564a[WeekendPolicy.FRIDAY_SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f273564a[WeekendPolicy.SATURDAY_SUNDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        WeekendPolicy r100 = new WeekendPolicy("THURSDAY_FRIDAY", 0);
        THURSDAY_FRIDAY = r100;
        WeekendPolicy r101 = new WeekendPolicy("FRIDAY_SATURDAY", 1);
        FRIDAY_SATURDAY = r101;
        WeekendPolicy r102 = new WeekendPolicy("SATURDAY_SUNDAY", 2);
        SATURDAY_SUNDAY = r102;
        f273563a = new WeekendPolicy[]{r100, r101, r102};
    }

    public static WeekendPolicy[] values() {
        return (WeekendPolicy[]) f273563a.clone();
    }

    public static WeekendPolicy valueOf(String r100) {
        return (WeekendPolicy) r27.a.a(WeekendPolicy.class, r100);
    }

    public WeekendPolicy(String r100, int r101) {
        super(r100, r101);
    }

    public static int daysFromWeekend(WeekendPolicy r100, ZonedDateTime r101) {
        int r102 = r101.getDayOfWeek().getValue();
        int r103 = a.f273564a[r100.ordinal()];
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L7;
        if (r102 >= 5) goto L13;
        return r102;
    L13:
        if (r102 > 6) goto L15;
        return 0;
    L15:
        return r102 - 6;
    L7:
        if (r103 != 3) goto L26;
        if (r102 >= 6) goto L22;
        return r102;
    L22:
        return 0;
    L26:
        return 0;
    L17:
        if (r102 >= 4) goto L19;
        return r102;
    L19:
        if (r102 > 5) goto L21;
        return 0;
    L21:
        return r102 - 5;
    }

    public static int daysToWeekend(WeekendPolicy r100, ZonedDateTime r101) {
        int r102 = r101.getDayOfWeek().getValue();
        int r103 = a.f273564a[r100.ordinal()];
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L7;
        if (r102 < 5) goto L14;
        if (r102 > 6) goto L17;
    L25:
        return 0;
    L17:
        return (7 - r102) + 5;
    L14:
        return 6 - r102;
    L7:
        if (r103 != 3) goto L25;
        if (r102 >= 6) goto L25;
        return Math.max(0, 6 - r102);
    L19:
        if (r102 < 4) goto L21;
        if (r102 <= 5) goto L25;
        return (7 - r102) + 4;
    L21:
        return 4 - r102;
    }
}
