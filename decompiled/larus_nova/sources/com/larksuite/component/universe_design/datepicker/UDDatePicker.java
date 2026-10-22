package com.larksuite.component.universe_design.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.datepicker.databinding.UdDatepickerDefaultRootBinding;
import com.larksuite.component.universe_design.datepicker.impl.MonthCalendarViewAdapter;
import com.larksuite.component.universe_design.datepicker.impl.MonthViewPager;
import com.larksuite.component.universe_design.datepicker.impl.data.MonthShowMode;
import com.larksuite.component.universe_design.datepicker.impl.header.MonthPickerDefaultHead;
import com.larksuite.component.universe_design.datepicker.impl.week.WeekIndicator;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import java.util.Calendar;
import java.util.TimeZone;
import k08.b;
import k08.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q08.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\"\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0012H\u0016J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u001e2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/UDDatePicker;", "Landroid/widget/RelativeLayout;", "Lcom/larksuite/component/universe_design/datepicker/api/IDatePickerDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "monthCalendarViewAdapter", "Lcom/larksuite/component/universe_design/datepicker/impl/MonthCalendarViewAdapter;", "datePickerListener", "Lcom/larksuite/component/universe_design/datepicker/api/IDatePickerDelegate$DatePickerListener;", "selectedDate", "Lcom/larksuite/component/universe_design/util/CalendarDate;", "selectedTimeZone", "Ljava/util/TimeZone;", "monthShowMode", "Lcom/larksuite/component/universe_design/datepicker/impl/data/MonthShowMode;", "firstDayOfWeek", "Lcom/larksuite/component/universe_design/util/CalendarDate$DayOfWeek;", "viewBinding", "Lcom/larksuite/component/universe_design/datepicker/databinding/UdDatepickerDefaultRootBinding;", "initFromAttributes", "", "initData", "initView", "initMonthViewPager", "initViewData", "initWeekIndicator", "updateWeekColorAndText", "initHeader", "setSelectedDate", "date", "updateMonthText", "triggerSelectedDatChanged", "updateViewPagerHeight", "updateHeadViews", "getSelectedCalendar", "Ljava/util/Calendar;", "setMonthPickerListener", "listener", "setSelectedCalendar", "setMonthShowMode", "setFirstDayOfWeek", "getFirstDayOfWeek", "setMonthDateTypeFace", "typeFace", "Landroid/graphics/Typeface;", "setMonthHeadTypeFace", "setMonthHeadTextSize", "textSize", "", "setMonthDateTextSize", "setMonthPageScrollEnable", "scrollEnable", "", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDDatePicker extends RelativeLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f284769h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MonthCalendarViewAdapter f284770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l08.a f284771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CalendarDate f284772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TimeZone f284773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MonthShowMode f284774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CalendarDate.DayOfWeek f284775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UdDatepickerDefaultRootBinding f284776g;

    public static final class a {
    }

    static {
    }

    public final void b() {
        l08.a r100 = this.f284771b;
        if (r100 == null) goto L6;
        r100.a(this.f284772c.getYear(), this.f284772c.getMonth() - 1, this.f284772c.getMonthDay());
        return;
    }

    public final void d() {
        MonthPickerDefaultHead r100 = this.f284776g.f284782b;
        int[] r101 = com.larksuite.component.universe_design.util.a.f285486a;
        CalendarDate r102 = this.f284772c;
        Intrinsics.checkNotNullParameter(r102, "date");
        StringBuilder r103 = new StringBuilder();
        r103.append(r102.getYear());
        r103.append('.');
        r103.append(r102.getMonth());
        r100.setMonthText(r103.toString());
    }

    public final void e() {
        ViewGroup.LayoutParams r100 = this.f284776g.f284784d.getLayoutParams();
        r100.height = this.f284776g.f284784d.getCenterViewHeight();
        this.f284776g.f284784d.setLayoutParams(r100);
    }

    public final void f() {
        CalendarDate r100 = new CalendarDate();
        int r101 = r100.getWeeklyDayIndex(this.f284775f);
        CalendarDate r102 = this.f284772c;
        int[] r103 = com.larksuite.component.universe_design.util.a.f285486a;
        Intrinsics.checkNotNullParameter(r100, "lhs");
        Intrinsics.checkNotNullParameter(r102, "rhs");
        int r104 = 0;
        if (r100.getYear() == r102.getYear()) goto L5;
    L7:
        boolean r105 = false;
    L8:
        WeekIndicator r106 = this.f284776g.f284783c;
        CalendarDate.DayOfWeek r107 = this.f284775f;
        r106.f284826e = r101;
        r106.f284827f = r105;
        if (r107 != null) goto L11;
        int r108 = -1;
    L13:
        if (r108 != 1) goto L15;
    L20:
        if (r104 >= 7) goto L22;
        int r109 = r104 + 1;
        r106.f284823b[r104] = r106.f284822a[r109 % 7];
        r104 = r109;
    L22:
        r106.invalidate();
        return;
    L15:
        if (r108 == 2) goto L18;
    L16:
        if (r104 >= 7) goto L22;
        r106.f284823b[r104] = r106.f284822a[r104];
        r104 = r104 + 1;
    L18:
        if (r104 >= 7) goto L22;
        r106.f284823b[r104] = r106.f284822a[(r104 + 6) % 7];
        r104 = r104 + 1;
        goto L18
    L11:
        r108 = WeekIndicator.a.f284830a[r107.ordinal()];
        goto L13
    L5:
        if (r100.getMonth() != r102.getMonth()) goto L7;
        r105 = true;
        goto L8
    }

    public int getFirstDayOfWeek() {
        return this.f284775f.getValue() + 1;
    }

    public Calendar getSelectedCalendar() {
        int[] r100 = com.larksuite.component.universe_design.util.a.f285486a;
        Calendar r101 = this.f284772c.getCalendar();
        TimeZone r102 = this.f284773d;
        Intrinsics.checkNotNullParameter(r101, "calendar");
        Intrinsics.checkNotNullParameter(r102, TimeZoneItemV2.TIME_ZONE);
        return new CalendarDate(new CalendarDate(r101), r102).getCalendar();
    }

    public final void c() {
        d();
        f();
    }

    public UDDatePicker(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setSelectedDate(CalendarDate r100) {
        this.f284772c = r100;
        c();
        MonthCalendarViewAdapter r101 = this.f284770a;
        if (r101 == null) goto L5;
        r101.i();
    L5:
        invalidate();
        b();
    }

    public void setFirstDayOfWeek(int r100) {
        if (r100 >= 1) goto L5;
        return;
    L5:
        if (r100 > 7) goto L13;
        this.f284775f = CalendarDate.DayOfWeek.valueOf(r100 - 1);
        f();
        MonthCalendarViewAdapter r101 = this.f284770a;
        if (r101 == null) goto L10;
        r101.i();
    L10:
        e();
        return;
    }

    public void setMonthDateTextSize(float r100) {
        MonthCalendarViewAdapter r101 = this.f284770a;
        if (r101 == null) goto L12;
        int r102 = 0;
    L6:
        if (r102 >= 3) goto L16;
        c r103 = (c) r101.g(r102);
        if (r103 == null) goto L11;
        r103.setMonthTextSize(r100);
    L11:
        r102 = r102 + 1;
        goto L6
    L16:
        return;
    }

    public void setMonthDateTypeFace(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "typeFace");
        MonthCalendarViewAdapter r101 = this.f284770a;
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "typeFace");
        int r102 = 0;
    L6:
        if (r102 >= 3) goto L16;
        c r103 = (c) r101.g(r102);
        if (r103 == null) goto L11;
        r103.setTypeFace(r100);
    L11:
        r102 = r102 + 1;
        goto L6
    L16:
        return;
    }

    public void setMonthHeadTextSize(float r100) {
        this.f284776g.f284782b.setMonthTextSize(r100);
    }

    public void setMonthHeadTypeFace(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "typeFace");
        this.f284776g.f284782b.setTypeFace(r100);
    }

    public void setMonthPageScrollEnable(boolean r100) {
        this.f284776g.f284784d.setPageEnabled(r100);
    }

    public void setMonthPickerListener(l08.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f284771b = r100;
    }

    public void setMonthShowMode(MonthShowMode r100) {
        Intrinsics.checkNotNullParameter(r100, "monthShowMode");
        this.f284774e = r100;
        f();
        MonthCalendarViewAdapter r101 = this.f284770a;
        if (r101 == null) goto L5;
        r101.i();
    L5:
        e();
    }

    public void setSelectedCalendar(Calendar r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        this.f284773d = r100.getTimeZone();
        this.f284772c = new CalendarDate(new CalendarDate(r100));
        c();
        MonthCalendarViewAdapter r101 = this.f284770a;
        if (r101 == null) goto L5;
        r101.i();
    L5:
        this.f284776g.f284784d.setCurrentItem(1, false);
        e();
    }

    public UDDatePicker(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static final /* synthetic */ void a(UDDatePicker r100, CalendarDate r101) {
        r100.setSelectedDate(r101);
    }

    public UDDatePicker(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112, 0);
        this.f284772c = new CalendarDate();
        this.f284773d = TimeZone.getDefault();
        MonthShowMode r113 = MonthShowMode.AUTO_HEIGHT;
        this.f284774e = r113;
        this.f284775f = CalendarDate.DayOfWeek.SUNDAY;
        LayoutInflater.from(getContext()).inflate(R.layout.ud_datepicker_default_root, this);
        int r100 = R.id.month_picker_head;
        MonthPickerDefaultHead r101 = (MonthPickerDefaultHead) ViewBindings.findChildViewById(this, R.id.month_picker_head);
        if (r101 == null) goto L29;
        r100 = R.id.month_picker_week;
        WeekIndicator r102 = (WeekIndicator) ViewBindings.findChildViewById(this, R.id.month_picker_week);
        if (r102 == null) goto L29;
        r100 = R.id.month_viewpager;
        MonthViewPager r103 = (MonthViewPager) ViewBindings.findChildViewById(this, R.id.month_viewpager);
        if (r103 == null) goto L29;
        this.f284776g = new UdDatepickerDefaultRootBinding(this, r101, r102, r103);
        r101.setMonthPickerActionListener(new k08.a(this));
        d();
        f();
        MonthCalendarViewAdapter r104 = new MonthCalendarViewAdapter(getContext(), new b(this));
        this.f284770a = r104;
        k08.c r105 = new k08.c(this);
        Intrinsics.checkNotNullParameter(r105, "monthViewStateChangeListener");
        r104.f284792e = r105;
        r103.setAdapter(this.f284770a);
        r103.setViewPageListener(new d(this));
        e();
        setBackgroundColor(UDColorUtils.getColor(getContext(), R.color.bg_body));
        int r106 = e.f483540a;
        setMonthDateTypeFace(e.a(getContext()));
        TypedArray r114 = getContext().obtainStyledAttributes(r111, new int[]{R.attr.ud_datePicker_bodyMonthDateTextSize, R.attr.ud_datePicker_defaultHeadHeight, R.attr.ud_datePicker_firstDayOfWeek, R.attr.ud_datePicker_headMonthTextSize, R.attr.ud_datePicker_monthShowMode, R.attr.ud_datePicker_weekIndicatorBottomMargin, R.attr.ud_datePicker_weekIndicatorTopMargin}, r112, 0);
        int r107 = r114.getDimensionPixelSize(1, -1);
        int r108 = r114.getDimensionPixelSize(6, -1);
        int r109 = r114.getDimensionPixelSize(5, -1);
        int r115 = r114.getDimensionPixelSize(0, (int) h18.d.a(getContext(), 16.0f));
        int r116 = r114.getDimensionPixelSize(3, (int) h18.d.a(getContext(), 26.0f));
        int r117 = r114.getInt(4, 0);
        int r118 = r114.getInteger(2, 1);
        r114.recycle();
        if (r107 <= 0) goto L11;
        r101.getLayoutParams().height = r107;
    L11:
        ViewGroup.LayoutParams r119 = r102.getLayoutParams();
        if ((r119 instanceof RelativeLayout.LayoutParams) == false) goto L14;
        RelativeLayout.LayoutParams r120 = (RelativeLayout.LayoutParams) r119;
    L15:
        if (r108 <= 0) goto L18;
        if (r120 == null) goto L18;
        r120.topMargin = r108;
    L18:
        if (r109 <= 0) goto L21;
        if (r120 == null) goto L21;
        r120.bottomMargin = r109;
    L21:
        if (r120 == null) goto L23;
        r102.setLayoutParams(r120);
    L23:
        setMonthDateTextSize(r115);
        setMonthHeadTextSize(r116);
        setFirstDayOfWeek(r118);
        MonthShowMode.Companion.getClass();
        if (r117 != 0) goto L26;
        r113 = MonthShowMode.FIXED_SIX_ROW;
    L26:
        setMonthShowMode(r113);
        return;
    L14:
        r120 = null;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r100)));
    }
}
