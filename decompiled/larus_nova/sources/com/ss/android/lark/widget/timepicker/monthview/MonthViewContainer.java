package com.ss.android.lark.widget.timepicker.monthview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectTimeType;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&J\b\u00104\u001a\u000202H\u0002J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u0002022\u0006\u00103\u001a\u00020&H\u0002J\u0006\u00108\u001a\u000202J\u0006\u00109\u001a\u000202J\b\u0010:\u001a\u000202H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020(H\u0002J\u000e\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020(J\u0006\u0010?\u001a\u00020&J\u0006\u0010@\u001a\u00020(J\u0006\u0010A\u001a\u00020(J\u000e\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020!J6\u0010D\u001a\u0002022\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u00020&2\u0006\u0010<\u001a\u00020(2\u0006\u0010I\u001a\u00020JR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewContainer;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lookMonthLayoutFromXml", "Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewLayout;", "getLookMonthLayoutFromXml", "()Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewLayout;", "setLookMonthLayoutFromXml", "(Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewLayout;)V", "lookWeekIndicatorFromXml", "Lcom/ss/android/lark/widget/timepicker/monthview/ListCalendarWeekIndicator;", "getLookWeekIndicatorFromXml", "()Lcom/ss/android/lark/widget/timepicker/monthview/ListCalendarWeekIndicator;", "setLookWeekIndicatorFromXml", "(Lcom/ss/android/lark/widget/timepicker/monthview/ListCalendarWeekIndicator;)V", "lookMonthViewPagerFromXml", "Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewPager;", "getLookMonthViewPagerFromXml", "()Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewPager;", "setLookMonthViewPagerFromXml", "(Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewPager;)V", "mChangeListener", "Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewContainer$MonthViewChangeListener;", "mMonthViewPagerHeight", "mWeekHeight", "mMonthLayoutHeight", "mIsMonthShow", "", "mCurrentDate", "Lcom/ss/android/lark/widget/timepicker/monthview/data/CalendarDate;", "mMonthSizeChangeDuration", "", "mSelectedDate", "mShownDate", "mMonthViewAdapter", "Lcom/ss/android/lark/widget/timepicker/monthview/MonthCalendarViewAdapter;", "mMonthValueAnimator", "Landroid/animation/ValueAnimator;", "initMonthView", "", "noLimit", "initRequiredHeight", "updateMonthLayoutHeight", "offset", "initViewPager", "scrollToLeft", "scrollToRight", "initAnimation", "setSelectDate", "selectDate", "setShownDate", "shownDate", "isShow", "getCurrSelectedDate", "getCurrShownDate", "setChangeListener", "listener", "updateMonthOptionalView", DyPayConstant.KEY_START_TIME, "startTimeNoLimit", "endTime", "endTimeNoLimit", "selectTimeType", "Lcom/ss/android/lark/widget/timepicker/monthview/constants/MonthViewAttr$SelectTimeType;", "Companion", "MonthViewChangeListener", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MonthViewContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MonthViewLayout f449024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListCalendarWeekIndicator f449025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MonthViewPager f449026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MonthViewChangeListener f449027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f449028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f449029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f449030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CalendarDate f449031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDate f449032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDate f449033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MonthCalendarViewAdapter f449034k;

    public interface MonthViewChangeListener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/widget/timepicker/monthview/MonthViewContainer$MonthViewChangeListener$MonthChangeAction;", "", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface MonthChangeAction {
            public static final a Companion = null;
            public static final int SCROLL_PAGE = 0;
            public static final int SELECT_DATE = 1;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f449035a = null;

                static {
                    f449035a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f449035a;
            }
        }

        void a(CalendarDate r100, int r101);
    }

    public static final class a {
    }

    static {
    }

    public final void b() {
        CalendarDate r100 = this.f449033j.addMonth(-1);
        r100.setMonthDay(1);
        Intrinsics.checkNotNull(r100);
        setSelectDate(r100);
    }

    public final void c() {
        CalendarDate r100 = this.f449033j.addMonth(1);
        r100.setMonthDay(1);
        Intrinsics.checkNotNull(r100);
        setSelectDate(r100);
    }

    public final MonthViewLayout getLookMonthLayoutFromXml() {
        KeyEvent.Callback r100 = this.f449024a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.lookMonthLayout);
        this.f449024a = (MonthViewLayout) r100;
    L6:
        return (MonthViewLayout) r100;
    }

    public final MonthViewPager getLookMonthViewPagerFromXml() {
        KeyEvent.Callback r100 = this.f449026c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.lookMonthViewPager);
        this.f449026c = (MonthViewPager) r100;
    L6:
        return (MonthViewPager) r100;
    }

    public final ListCalendarWeekIndicator getLookWeekIndicatorFromXml() {
        KeyEvent.Callback r100 = this.f449025b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.lookWeekIndicator);
        this.f449025b = (ListCalendarWeekIndicator) r100;
    L6:
        return (ListCalendarWeekIndicator) r100;
    }

    public final CalendarDate getCurrSelectedDate() {
        return this.f449032i;
    }

    public final CalendarDate getCurrShownDate() {
        return this.f449033j;
    }

    public MonthViewContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setSelectDate(CalendarDate r100) {
        this.f449032i = r100;
        this.f449033j = r100;
        getLookWeekIndicatorFromXml().a(this.f449031h.getWeeklyDayIndex(), yec.a.d(this.f449031h, r100));
        getLookMonthViewPagerFromXml().k(r100);
    }

    public final void setChangeListener(MonthViewChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f449027d = r100;
    }

    public final void setLookMonthLayoutFromXml(MonthViewLayout r100) {
        this.f449024a = r100;
    }

    public final void setLookMonthViewPagerFromXml(MonthViewPager r100) {
        this.f449026c = r100;
    }

    public final void setLookWeekIndicatorFromXml(ListCalendarWeekIndicator r100) {
        this.f449025b = r100;
    }

    public final void setShownDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "shownDate");
        this.f449033j = r100;
        getLookWeekIndicatorFromXml().a(this.f449031h.getWeeklyDayIndex(), yec.a.d(this.f449031h, r100));
        getLookMonthViewPagerFromXml().k(r100);
    }

    public MonthViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public static final void a(MonthViewContainer r100, int r101) {
        r100.f449030g = r100.getLookMonthLayoutFromXml().getHeight();
        ViewGroup.LayoutParams r102 = r100.getLookMonthLayoutFromXml().getLayoutParams();
        r102.height = r100.f449030g + r101;
        r100.getLookMonthLayoutFromXml().setLayoutParams(r102);
    }

    public MonthViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f449031h = new CalendarDate();
        this.f449032i = new CalendarDate();
        this.f449033j = new CalendarDate();
        LayoutInflater.from(r100).inflate(R.layout.lark_arrange_top_month_view_container, this, true);
    }

    public final void d(CalendarDate r110, boolean r111, CalendarDate r112, boolean r113, CalendarDate r114, MonthViewAttr$SelectTimeType r115) {
        Intrinsics.checkNotNullParameter(r110, DyPayConstant.KEY_START_TIME);
        Intrinsics.checkNotNullParameter(r112, "endTime");
        Intrinsics.checkNotNullParameter(r114, "selectDate");
        Intrinsics.checkNotNullParameter(r115, "selectTimeType");
        MonthViewPager r100 = getLookMonthViewPagerFromXml();
        r100.getRightView().setSelectDate(r114);
        r100.getLeftView().setSelectDate(r114);
        r100.getCenterView().setSelectDate(r114);
        MonthViewPager.j(r100.getRightView(), r110, r111, r112, r113, r115);
        MonthViewPager.j(r100.getLeftView(), r110, r111, r112, r113, r115);
        MonthViewPager.j(r100.getCenterView(), r110, r111, r112, r113, r115);
    }
}
