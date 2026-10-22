package com.obric.oui.calendar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0003rstJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010 J\u001b\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b%\u0010&J\u0010\u0010%\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020\u0002J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u0006\u0010,\u001a\u00020+J\u0010\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-J\b\u00100\u001a\u0004\u0018\u00010-J\u0010\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010-J\b\u00103\u001a\u0004\u0018\u00010-J\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0002J\u000e\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020(J\u000e\u00109\u001a\u00020\u00042\u0006\u00107\u001a\u00020(J\u000e\u0010:\u001a\u00020\u00042\u0006\u00107\u001a\u00020(J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0002J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0002J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0002J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0002J\u0006\u0010C\u001a\u00020\u0002J\u000e\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002J\u000e\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010H\u001a\u00020\u0002J\u000e\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0002J\u0006\u0010K\u001a\u00020\u0002J\u000e\u0010L\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0002J\u000e\u0010N\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0002J\u000e\u0010O\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010P\u001a\u00020\u0002J\u0006\u0010Q\u001a\u00020-J\u0010\u0010S\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u00010-J\b\u0010T\u001a\u0004\u0018\u00010-J\f\u0010V\u001a\b\u0012\u0004\u0012\u00020-0UJ\u0010\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020WH\u0007R?\u0010d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR?\u0010h\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR?\u0010l\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010_\u001a\u0004\bj\u0010a\"\u0004\bk\u0010cRE\u0010q\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0U¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020\u0004\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010_\u001a\u0004\bo\u0010a\"\u0004\bp\u0010c¨\u0006u"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "second", "", "setSecond", "getSecond", "millisecond", "setMillisecond", "getMillisecond", "Lcom/obric/oui/calendar/MaterialCalendarView;", "getCalendarView", "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", RemoteMessageConst.Notification.VISIBILITY, "setOutOfMonthVisibility", "", "getSelectTimestamp", "selectedTime", "setCurrentTimeMillis", "mode", "setSelectionMode", "getSelectionMode", "color", "setSelectionColor", "getSelectionColor", "resourceId", "setDateTextAppearance", "setWeekDayTextAppearance", "Lmla/e;", "formatter", "setDayFormatter", "setDayFormatterContentDescription", "Lmla/h;", "setWeekDayFormatter", "", "", "weekDayLabels", "setWeekDayLabels", "([Ljava/lang/CharSequence;)V", "arrayRes", "", "showWeekDays", "setShowWeekDays", "Lcom/obric/oui/calendar/CalendarMode;", "getCalendarMode", "Lcom/obric/oui/calendar/CalendarDay;", "minDate", "setMinimumDate", "getMinimumDate", "maxDate", "setMaximumDate", "getMaximumDate", "showOtherDates", "setShowOtherDates", "getShowOtherDates", "enabled", "setAllowClickDaysOutsideCurrentMonth", "setPagingEnabled", "setDynamicHeightEnabled", "sizePx", "setTileSize", "sizeDp", "setTileSizeDp", "widthPx", "setTileWidth", "widthDp", "setTileWidthDp", "getTileWidth", "heightPx", "setTileHeight", "heightDp", "setTileHeightDp", "getTileHeight", "spacingPx", "setTileHSpacing", "getTileHSpacing", "setTileVSpacing", "getTileVSpacing", "setWeekDaysHeight", "setWeekDaysHeightDp", "getWeekDaysHeight", "getCurrentDate", "date", "setSelectedDate", "getSelectedDate", "", "getSelectedDates", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "setFirstDayOfWeek", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "time", "y", "Lkotlin/jvm/functions/Function1;", "getOnMonthChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnMonthChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onMonthChangedListener", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getOnDateChangedListener", "setOnDateChangedListener", "onDateChangedListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getOnDateLongClickListener", "setOnDateLongClickListener", "onDateLongClickListener", "times", "B", "getOnRangeSelectedListener", "setOnRangeSelectedListener", "onRangeSelectedListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DatePickerMode", "OutOfMonthVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ODatePickerView extends ConstraintLayout {
    public static final /* synthetic */ int C = 0;
    public Function1<? super Long, Unit> A;
    public Function1<? super List<Long>, Unit> B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DatePickerMode f399220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f399221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f399223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f399224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f399226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MaterialCalendarView f399227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f399228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f399229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f399230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FrameLayout f399231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OReelPickerMulti f399232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public fja.d f399233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f399234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public fja.d f399235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public fja.d f399236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ObjectAnimator f399237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ObjectAnimator f399238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f399239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f399240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OutOfMonthVisibility f399241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public s f399242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f399243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function1<? super Long, Unit> f399244y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super Long, Unit> f399245z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        public static final DatePickerMode BOARD_SHEET = null;

        @Deprecated(message = "this mode is deprecated, please use BOARD_SHEET")
        public static final DatePickerMode NARROW_SHEET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DatePickerMode[] f399246a = null;

        public static DatePickerMode valueOf(String r100) {
            return (DatePickerMode) r27.a.a(DatePickerMode.class, r100);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) f399246a.clone();
        }

        static {
            DatePickerMode r100 = new DatePickerMode("BOARD_SHEET", 0);
            BOARD_SHEET = r100;
            DatePickerMode r101 = new DatePickerMode("NARROW_SHEET", 1);
            NARROW_SHEET = r101;
            f399246a = new DatePickerMode[]{r100, r101};
        }

        public DatePickerMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "", "GREY", "HIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum OutOfMonthVisibility extends Enum<OutOfMonthVisibility> {
        public static final OutOfMonthVisibility GREY = null;
        public static final OutOfMonthVisibility HIDE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OutOfMonthVisibility[] f399247a = null;

        public static OutOfMonthVisibility valueOf(String r100) {
            return (OutOfMonthVisibility) r27.a.a(OutOfMonthVisibility.class, r100);
        }

        public static OutOfMonthVisibility[] values() {
            return (OutOfMonthVisibility[]) f399247a.clone();
        }

        static {
            OutOfMonthVisibility r100 = new OutOfMonthVisibility("GREY", 0);
            GREY = r100;
            OutOfMonthVisibility r101 = new OutOfMonthVisibility("HIDE", 1);
            HIDE = r101;
            f399247a = new OutOfMonthVisibility[]{r100, r101};
        }

        public OutOfMonthVisibility(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399248a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f399249b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f399250c = null;

        static {
            int[] r100 = new int[OutOfMonthVisibility.values().length];
            r100[OutOfMonthVisibility.HIDE.ordinal()] = 1;
            r100[OutOfMonthVisibility.GREY.ordinal()] = 2;
            f399248a = r100;
            int[] r101 = new int[DayOfWeek.values().length];
            r101[DayOfWeek.SUNDAY.ordinal()] = 1;
            r101[DayOfWeek.MONDAY.ordinal()] = 2;
            r101[DayOfWeek.TUESDAY.ordinal()] = 3;
            r101[DayOfWeek.WEDNESDAY.ordinal()] = 4;
            r101[DayOfWeek.THURSDAY.ordinal()] = 5;
            r101[DayOfWeek.FRIDAY.ordinal()] = 6;
            r101[DayOfWeek.SATURDAY.ordinal()] = 7;
            f399249b = r101;
            int[] r102 = new int[DatePickerMode.values().length];
            r102[DatePickerMode.BOARD_SHEET.ordinal()] = 1;
            r102[DatePickerMode.NARROW_SHEET.ordinal()] = 2;
            f399250c = r102;
        }
    }

    static {
    }

    public ODatePickerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, null, 30);
    }

    public ODatePickerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, null, 28);
    }

    public ODatePickerView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, null, 24);
    }

    public final void R5() {
        OutOfMonthVisibility r100 = this.f399241v;
        int r101 = b.f399248a[r100.ordinal()];
        boolean r102 = false;
        if (r101 != 1) goto L5;
        int r103 = 0;
    L10:
        this.f399227h.setShowOtherDates(r103);
        MaterialCalendarView r104 = this.f399227h;
        if (this.f399241v != OutOfMonthVisibility.GREY) goto L13;
        r102 = true;
    L13:
        r104.setAllowClickDaysOutsideCurrentMonth(r102);
        return;
    L5:
        if (r101 != 2) goto L8;
        r103 = 7;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final CalendarMode getCalendarMode() {
        return this.f399227h.getCalendarMode();
    }

    public final CalendarDay getCurrentDate() {
        return this.f399227h.getCurrentDate();
    }

    public final CalendarDay getMaximumDate() {
        return this.f399227h.getMaximumDate();
    }

    public final CalendarDay getMinimumDate() {
        return this.f399227h.getMinimumDate();
    }

    public final CalendarDay getSelectedDate() {
        return this.f399227h.getSelectedDate();
    }

    public final List<CalendarDay> getSelectedDates() {
        return this.f399227h.getSelectedDates();
    }

    public final int getSelectionColor() {
        return this.f399227h.getSelectionColor();
    }

    public final int getSelectionMode() {
        return this.f399227h.getSelectionMode();
    }

    public final int getShowOtherDates() {
        return this.f399227h.getShowOtherDates();
    }

    public final int getTileHSpacing() {
        return this.f399227h.getTileHSpacing();
    }

    public final int getTileHeight() {
        return this.f399227h.getTileHeight();
    }

    public final int getTileVSpacing() {
        return this.f399227h.getTileVSpacing();
    }

    public final int getTileWidth() {
        return this.f399227h.getTileWidth();
    }

    public final int getWeekDaysHeight() {
        return this.f399227h.getWeekDaysHeight();
    }

    public final long getSelectTimestamp() {
        Calendar r100 = Calendar.getInstance();
        CalendarDay r101 = (CalendarDay) ListProtector.get(this.f399227h.getSelectedDates(), 0);
        int r102 = r101.d();
        int r103 = r101.c() - 1;
        int r104 = r101.b();
        r100.set(13, getSecond());
        r100.set(14, getMillisecond());
        r100.set(r102, r103, r104, 0, 0);
        return r100.getTimeInMillis();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = vma.c.f556351a;
        ViewParent r101 = getParent();
        if (r101 != null) goto L6;
    L4:
        r101 = null;
    L7:
        ViewGroup r102 = (ViewGroup) r101;
        if ((r102 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r103 = (OSheetContentFrameLayout) r102;
        if (r103.getId() != R.id.content_container) goto L36;
        int r104 = r103.getPaddingLeft();
        int r105 = r103.getPaddingTop();
        int r106 = r103.getPaddingRight();
        int r107 = r103.getPaddingBottom();
        int r108 = b.f399250c[this.f399220a.ordinal()];
        if (r108 == 1) goto L26;
        if (r108 == 2) goto L17;
        return;
    L17:
        if (r104 == pla.d.n(this, 0)) goto L19;
    L24:
        wma.b.a("DatePickerView", "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r104 + ", " + r105 + ", " + r106 + ", " + r107 + ']');
        r103.setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r105 != pla.d.n(this, 0)) goto L24;
        if (r106 != pla.d.n(this, 0)) goto L24;
        if (r107 != pla.d.n(this, 0)) goto L24;
        return;
    L26:
        if (r104 == pla.d.n(this, 16)) goto L28;
    L33:
        wma.b.a("DatePickerView", "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r104 + ", " + r105 + ", " + r106 + ", " + r107 + ']');
        r103.setPadding(pla.d.n(this, 16), pla.d.n(this, 6), pla.d.n(this, 16), pla.d.n(this, 16));
        return;
    L28:
        if (r105 != pla.d.n(this, 6)) goto L33;
        if (r106 != pla.d.n(this, 16)) goto L33;
        if (r107 != pla.d.n(this, 16)) goto L33;
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r101 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s r100 = this.f399242w;
        if (r100 == null) goto L6;
        removeCallbacks(r100);
    L6:
        this.f399242w = null;
    }

    private final int getMillisecond() {
        return this.f399225f;
    }

    private final int getSecond() {
        return this.f399224e;
    }

    public final MaterialCalendarView getCalendarView() {
        return this.f399227h;
    }

    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.f399245z;
    }

    public final Function1<Long, Unit> getOnDateLongClickListener() {
        return this.A;
    }

    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.f399244y;
    }

    public final Function1<List<Long>, Unit> getOnRangeSelectedListener() {
        return this.B;
    }

    public static long T5(CalendarDay r100) {
        Calendar r101 = Calendar.getInstance();
        r101.set(r100.d(), r100.c() - 1, r100.b(), 0, 0, 0);
        r101.set(14, 0);
        return r101.getTimeInMillis();
    }

    private final void setMillisecond(int r100) {
        this.f399225f = r100;
    }

    private final void setSecond(int r100) {
        this.f399224e = r100;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f399243x = getResources().getString(R.string.oui_date_picker_date_format);
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r100) {
        this.f399227h.setAllowClickDaysOutsideCurrentMonth(r100);
    }

    public final void setCurrentTimeMillis(long r100) {
        this.f399226g = r100;
        Calendar r101 = Calendar.getInstance();
        int r110 = pla.b.f529795a;
        pla.b.b("DatePickerView", "默认选中的时间:" + this.f399226g + " , mSelectTime:" + this.f399226g);
        r101.setTimeInMillis(this.f399226g);
        int r102 = r101.get(1);
        int r103 = r101.get(2) + 1;
        int r111 = r101.get(5);
        int r104 = r101.get(11);
        int r105 = r101.get(12);
        int r106 = r101.get(13);
        int r107 = r101.get(14);
        pla.b.b("DatePickerView", "转化时间year:" + r102 + ",month:" + r103 + ",day:" + r111 + ",hour:" + r104 + ",minute:" + r105 + ", selectDate:" + new CalendarDay(r102, r103, r111));
        String r108 = S5(this.f399226g, this.f399243x);
        this.f399227h.setCurrentDate(new CalendarDay(r102, r103, r111));
        this.f399227h.setSelectedDate(new CalendarDay(r102, r103, r111));
        this.f399228i.setText(r108);
        setSecond(r106);
        setMillisecond(r107);
    }

    public final void setDateTextAppearance(int r100) {
        this.f399227h.setDateTextAppearance(r100);
    }

    public final void setDayFormatter(mla.e r100) {
        this.f399227h.setDayFormatter(r100);
    }

    public final void setDayFormatterContentDescription(mla.e r100) {
        this.f399227h.setDayFormatterContentDescription(r100);
    }

    public final void setDynamicHeightEnabled(boolean r100) {
        this.f399227h.setDynamicHeightEnabled(r100);
    }

    public final void setFirstDayOfWeek(DayOfWeek r100) {
        Intrinsics.checkNotNullParameter(r100, "firstDayOfWeek");
        switch(b.f399249b[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        org.threeten.bp.DayOfWeek r101 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        MaterialCalendarView.f r102 = this.f399227h.B;
        r102.getClass();
        MaterialCalendarView.g r103 = new MaterialCalendarView.g(r102.f399212g, r102);
        r103.f399214b = r101;
        r103.a();
        return;
    L7:
        r101 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r101 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r101 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r101 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r101 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r101 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void setMaximumDate(CalendarDay r100) {
        MaterialCalendarView.f r101 = this.f399227h.B;
        r101.getClass();
        MaterialCalendarView.g r102 = new MaterialCalendarView.g(r101.f399212g, r101);
        r102.f399217e = r100;
        r102.a();
    }

    public final void setMinimumDate(CalendarDay r100) {
        MaterialCalendarView.f r101 = this.f399227h.B;
        r101.getClass();
        MaterialCalendarView.g r102 = new MaterialCalendarView.g(r101.f399212g, r101);
        r102.f399216d = r100;
        r102.a();
    }

    public final void setOnDateChangedListener(Function1<? super Long, Unit> r100) {
        this.f399245z = r100;
    }

    public final void setOnDateLongClickListener(Function1<? super Long, Unit> r100) {
        this.A = r100;
    }

    public final void setOnMonthChangedListener(Function1<? super Long, Unit> r100) {
        this.f399244y = r100;
    }

    public final void setOnRangeSelectedListener(Function1<? super List<Long>, Unit> r100) {
        this.B = r100;
    }

    public final void setOutOfMonthVisibility(OutOfMonthVisibility r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.VISIBILITY);
        this.f399241v = r100;
        R5();
    }

    public final void setPagingEnabled(boolean r100) {
        this.f399227h.setPagingEnabled(r100);
    }

    public final void setSelectedDate(CalendarDay r100) {
        this.f399227h.setSelectedDate(r100);
    }

    public final void setSelectionColor(int r100) {
        this.f399227h.setSelectionColor(r100);
    }

    public final void setSelectionMode(int r100) {
        this.f399227h.setSelectionMode(r100);
    }

    public final void setShowOtherDates(int r100) {
        this.f399227h.setShowOtherDates(r100);
    }

    public final void setShowWeekDays(boolean r100) {
        MaterialCalendarView.f r101 = this.f399227h.B;
        r101.getClass();
        MaterialCalendarView.g r102 = new MaterialCalendarView.g(r101.f399212g, r101);
        r102.f399218f = r100;
        r102.a();
    }

    public final void setTileHSpacing(int r100) {
        this.f399227h.setTileHSpacing(r100);
    }

    public final void setTileHeight(int r100) {
        this.f399227h.setTileHeight(r100);
    }

    public final void setTileHeightDp(int r100) {
        this.f399227h.setTileHeightDp(r100);
    }

    public final void setTileSize(int r100) {
        this.f399227h.setTileSize(r100);
    }

    public final void setTileSizeDp(int r100) {
        this.f399227h.setTileSizeDp(r100);
    }

    public final void setTileVSpacing(int r100) {
        this.f399227h.setTileVSpacing(r100);
    }

    public final void setTileWidth(int r100) {
        this.f399227h.setTileWidth(r100);
    }

    public final void setTileWidthDp(int r100) {
        this.f399227h.setTileWidthDp(r100);
    }

    public final void setWeekDayFormatter(mla.h r100) {
        this.f399227h.setWeekDayFormatter(r100);
    }

    public final void setWeekDayLabels(CharSequence[] r100) {
        Intrinsics.checkNotNullParameter(r100, "weekDayLabels");
        this.f399227h.setWeekDayLabels(r100);
    }

    public final void setWeekDayTextAppearance(int r100) {
        this.f399227h.setWeekDayTextAppearance(r100);
    }

    public final void setWeekDaysHeight(int r100) {
        this.f399227h.setWeekDaysHeight(r100);
    }

    public final void setWeekDaysHeightDp(int r100) {
        this.f399227h.setWeekDaysHeightDp(r100);
    }

    public final void setWeekDayLabels(int r100) {
        this.f399227h.setWeekDayLabels(r100);
    }

    public static String S5(long r100, String r101) {
        Date r102 = new Date(r100);
        SimpleDateFormat r103 = new SimpleDateFormat(r101, Locale.getDefault());
        r103.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        return r103.format(r102);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public ODatePickerView(Context r110, AttributeSet r111, int r112, DatePickerMode r113, int r114) {
        OReelPickerMulti r100 = null;
        if ((r114 & 2) == 0) goto L5;
        r111 = null;
    L5:
        int r101 = 0;
        if ((r114 & 4) == 0) goto L9;
        r112 = 0;
    L9:
        if ((r114 & 8) == 0) goto L11;
        r113 = DatePickerMode.BOARD_SHEET;
    L11:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "datePickerMode");
        super(r110, r111, r112);
        this.f399220a = r113;
        this.f399221b = false;
        CalendarDay.e().b();
        this.f399222c = CalendarDay.e().d();
        this.f399223d = CalendarDay.e().c();
        this.f399241v = OutOfMonthVisibility.GREY;
        ViewGroup.inflate(r110, R.layout.o_date_picker_view_default, this);
        this.f399243x = getResources().getString(R.string.oui_date_picker_date_format);
        MaterialCalendarView r115 = (MaterialCalendarView) findViewById(R.id.calendarView);
        this.f399227h = r115;
        ImageView r116 = (ImageView) findViewById(R.id.previousBtn);
        ImageView r117 = (ImageView) findViewById(R.id.nextBtn);
        this.f399228i = (TextView) findViewById(R.id.currentDateTextView);
        View r118 = findViewById(R.id.ll_open_year_month);
        this.f399229j = r118;
        this.f399230k = (ImageView) findViewById(R.id.iv_open_year_month);
        FrameLayout r119 = (FrameLayout) findViewById(R.id.fl_calendar_container);
        this.f399231l = r119;
        Calendar r102 = Calendar.getInstance();
        r115.setTopbarVisible(false);
        r116.setOnClickListener(new m(this));
        r117.setOnClickListener(new n(this));
        r115.setOnMonthChangedListener(new o(r102, this));
        r115.setOnDateChangedListener(new p(r102, this));
        r115.setOnDateLongClickListener(new q(this));
        r115.setOnRangeSelectedListener(new r(this));
        R5();
        hma.c.a r120 = new hma.c.a();
        r120.i(getContext(), 1001, 1900, 2100, Integer.valueOf(this.f399222c), Integer.valueOf(pla.d.n(this, 164)));
        r120.f(getContext(), 1002, Integer.valueOf(this.f399223d), Integer.valueOf(pla.d.n(this, 164)));
        Context r121 = getContext();
        Intrinsics.checkNotNullParameter(r121, "$this$getScreenWidth");
        Resources r122 = r121.getResources();
        DisplayMetrics r123 = WindowDisplayMetricsOverride.apply(r122, r122.getDisplayMetrics());
        if (r123 == null) goto L14;
        r101 = r123.widthPixels;
    L14:
        r120.f486020b = Integer.valueOf(r101);
        r120.f486021c = Integer.valueOf(pla.d.n(this, 258));
        Consumer<hma.c.b> r124 = new k(this);
        Intrinsics.checkNotNullParameter(r124, "listener");
        r120.f486019a = r124;
        OReelPickerMulti r125 = ((hma.c) hma.d.a.a(r120, getContext())).a();
        if (r125 == null) goto L18;
        FrameLayout.LayoutParams r126 = new FrameLayout.LayoutParams(-1, r125.getLayoutParams().height);
        r126.gravity = 17;
        r125.setLayoutParams(r126);
        r125.setAlpha(0.0f);
        r125.setVisibility(4);
        r119.addView(r125);
        r100 = r125;
    L18:
        this.f399232m = r100;
        r118.setOnClickListener(new l(this));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
