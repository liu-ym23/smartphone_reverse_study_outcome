package com.larksuite.component.universe_design.timepicker.impl.helper;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.larksuite.component.universe_design.util.CalendarDate;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/universe_design/timepicker/impl/helper/UtcDates;", "", "<init>", "()V", "UTC", "", "getTimeZone", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "getCalendar", "Ljava/util/Calendar;", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "monthDay", "hour", "minute", "second", "getUTCCalendarOf", "calendar", "getTodayCalendar", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UtcDates {
    public static final UtcDates INSTANCE = null;
    private static final String UTC = "UTC";

    static {
        INSTANCE = new UtcDates();
    }

    private UtcDates() {
    }

    public final TimeZone getTimeZone() {
        return TimeZone.getTimeZone("UTC");
    }

    public final Calendar getTodayCalendar() {
        return getUTCCalendarOf(Calendar.getInstance());
    }

    public final Calendar getUTCCalendarOf(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "calendar");
        return new CalendarDate(new CalendarDate(r100), TimeZone.getTimeZone("UTC")).getCalendar();
    }

    public final Calendar getCalendar(int r100, int r101) {
        Calendar r102 = Calendar.getInstance(getTimeZone());
        r102.set(11, r100);
        r102.set(12, r101);
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public final Calendar getCalendar(int r100, int r101, int r102) {
        Calendar r103 = Calendar.getInstance(getTimeZone());
        r103.set(1, r100);
        r103.set(2, r101 - 1);
        r103.set(5, r102);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    public final Calendar getCalendar(int r100, int r101, int r102, int r103, int r104, int r105) {
        Calendar r106 = Calendar.getInstance(getTimeZone());
        r106.set(1, r100);
        r106.set(2, r101 - 1);
        r106.set(5, r102);
        r106.set(11, r103);
        r106.set(12, r104);
        r106.set(13, r105);
        Intrinsics.checkNotNull(r106);
        return r106;
    }
}
