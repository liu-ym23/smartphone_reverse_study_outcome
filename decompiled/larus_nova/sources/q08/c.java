package q08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larksuite.component.universe_design.datepicker.impl.data.MonthShowMode;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p08.e;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CalendarDate f531205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CalendarDate.DayOfWeek f531206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CalendarDate f531207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CalendarDate f531208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MonthShowMode f531209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n08.b[] f531210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f531211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f531212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f531213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f531214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f531215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p08.a f531216l;

    public static final class a {
    }

    static {
    }

    private final float getCellHeight() {
        return this.f531216l.b();
    }

    public final void a() {
        c r100 = this;
        int r101 = b.f531204a;
        n08.b[] r102 = r100.f531210f;
        CalendarDate r103 = r100.f531205a;
        CalendarDate r104 = r100.f531207c;
        CalendarDate r105 = r100.f531208d;
        CalendarDate.DayOfWeek r106 = r100.f531206b;
        MonthShowMode r107 = r100.f531209e;
        Intrinsics.checkNotNullParameter(r102, "weeks");
        Intrinsics.checkNotNullParameter(r103, "seedDate");
        Intrinsics.checkNotNullParameter(r104, "currentDate");
        Intrinsics.checkNotNullParameter(r105, "selectDate");
        Intrinsics.checkNotNullParameter(r106, "firstWeekDay");
        Intrinsics.checkNotNullParameter(r107, "monthShowMode");
        int r108 = com.larksuite.component.universe_design.util.a.a(r103.getYear(), r103.getMonth() - 1);
        int r109 = com.larksuite.component.universe_design.util.a.a(r103.getYear(), r103.getMonth());
        int r110 = r103.getYear();
        int r111 = r103.getMonth();
        Intrinsics.checkNotNullParameter(r106, "dayOfWeek");
        CalendarDate r112 = new CalendarDate();
        r112.setYear(r110);
        r112.setMonth(r111);
        r112.setMonthDay(1);
        int r113 = r112.getWeeklyDayIndex(r106);
        int r114 = 6;
        if (r107 == MonthShowMode.FIXED_SIX_ROW) goto L6;
        r114 = RangesKt.coerceAtMost(6, (int) Math.ceil(((double) (r113 + r109)) / 7.0d));
    L6:
        int r115 = 0;
        int r116 = 0;
    L7:
        if (r115 >= r114) goto L90;
        int r117 = 0;
    L10:
        if (r117 >= 7) goto L89;
        int r118 = (r115 * 7) + r117;
        n08.a r119 = null;
        if (r118 >= r113) goto L14;
    L39:
        int r120 = r114;
        if (r118 >= r113) goto L64;
        CalendarDate r121 = new CalendarDate(r103.getYear(), r103.getMonth() - 1, r108 - ((r113 - r118) - 1), 0, 0, 0);
        if (r102[r115] != null) goto L44;
        r102[r115] = new n08.b(r115);
    L44:
        n08.b r122 = r102[r115];
        if (r122 == null) goto L49;
        n08.a[] r123 = r122.f516611b;
        if (r123 == null) goto L49;
        r119 = r123[r117];
    L49:
        if (r119 != null) goto L55;
        int r124 = r108;
        n08.a r125 = new n08.a(r115, r117, r121, new CalendarAttr(CalendarAttr.SelectState.UN_SELECT, CalendarAttr.DateState.PAST_DATE, CalendarAttr.MonthState.LAST_MONTH));
        n08.b r126 = r102[r115];
        if (r126 == null) goto L56;
        n08.a[] r127 = r126.f516611b;
        if (r127 == null) goto L56;
        r127[r117] = r125;
    L56:
        n08.b r128 = r102[r115];
        if (r128 == null) goto L88;
        n08.a[] r129 = r128.f516611b;
        if (r129 == null) goto L88;
        n08.a r130 = r129[r117];
        if (r130 == null) goto L88;
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r130.f516608c = r121;
        b.b(r130, r121, r105);
        b.a(r130, r121, r104);
        CalendarAttr.MonthState r131 = CalendarAttr.MonthState.LAST_MONTH;
        CalendarAttr r132 = r130.f516609d;
        r132.getClass();
        Intrinsics.checkNotNullParameter(r131, "<set-?>");
        r132.f284798c = r131;
    L88:
        r117 = r117 + 1;
        r108 = r124;
        r114 = r120;
        goto L10
    L55:
        r124 = r108;
        goto L56
    L64:
        r124 = r108;
        if (r118 < (r113 + r109)) goto L88;
        CalendarDate r133 = new CalendarDate(r103.getYear(), r103.getMonth() + 1, ((r118 - r113) - r109) + 1, 0, 0, 0);
        if (r102[r115] != null) goto L69;
        r102[r115] = new n08.b(r115);
    L69:
        n08.b r134 = r102[r115];
        if (r134 == null) goto L74;
        n08.a[] r135 = r134.f516611b;
        if (r135 == null) goto L74;
        r119 = r135[r117];
    L74:
        if (r119 != null) goto L80;
        n08.a r136 = new n08.a(r115, r117, r133, new CalendarAttr(CalendarAttr.SelectState.UN_SELECT, CalendarAttr.DateState.FUTURE_DATE, CalendarAttr.MonthState.NEXT_MONTH));
        n08.b r137 = r102[r115];
        if (r137 == null) goto L80;
        n08.a[] r138 = r137.f516611b;
        if (r138 == null) goto L80;
        r138[r117] = r136;
    L80:
        n08.b r139 = r102[r115];
        if (r139 == null) goto L88;
        n08.a[] r140 = r139.f516611b;
        if (r140 == null) goto L88;
        n08.a r141 = r140[r117];
        if (r141 == null) goto L88;
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        r141.f516608c = r133;
        b.b(r141, r133, r105);
        b.a(r141, r133, r104);
        CalendarAttr.MonthState r142 = CalendarAttr.MonthState.NEXT_MONTH;
        CalendarAttr r143 = r141.f516609d;
        r143.getClass();
        Intrinsics.checkNotNullParameter(r142, "<set-?>");
        r143.f284798c = r142;
        goto L88
    L14:
        if (r118 >= (r113 + r109)) goto L39;
        int r144 = r116 + 1;
        CalendarDate r145 = r103.modifyDay(r144);
        if (r102[r115] != null) goto L18;
        r102[r115] = new n08.b(r115);
    L18:
        n08.b r146 = r102[r115];
        if (r146 == null) goto L23;
        n08.a[] r147 = r146.f516611b;
        if (r147 == null) goto L23;
        r119 = r147[r117];
    L23:
        if (r119 != null) goto L29;
        Intrinsics.checkNotNull(r145);
        int r148 = r144;
        r120 = r114;
        n08.a r149 = new n08.a(r115, r117, r145, new CalendarAttr(CalendarAttr.SelectState.UN_SELECT, CalendarAttr.DateState.CURRENT_DATE, CalendarAttr.MonthState.CURRENT_MONTH));
        n08.b r150 = r102[r115];
        if (r150 == null) goto L30;
        n08.a[] r151 = r150.f516611b;
        if (r151 == null) goto L30;
        r151[r117] = r149;
    L30:
        n08.b r152 = r102[r115];
        if (r152 == null) goto L38;
        n08.a[] r153 = r152.f516611b;
        if (r153 == null) goto L38;
        n08.a r154 = r153[r117];
        if (r154 == null) goto L38;
        Intrinsics.checkNotNull(r145);
        Intrinsics.checkNotNullParameter(r145, "<set-?>");
        r154.f516608c = r145;
        b.b(r154, r145, r105);
        b.a(r154, r145, r104);
        CalendarAttr.MonthState r155 = CalendarAttr.MonthState.CURRENT_MONTH;
        CalendarAttr r156 = r154.f516609d;
        r156.getClass();
        Intrinsics.checkNotNullParameter(r155, "<set-?>");
        r156.f284798c = r155;
    L38:
        r116 = r148;
        r124 = r108;
        goto L88
    L29:
        r120 = r114;
        r148 = r144;
        goto L30
    L89:
        r115 = r115 + 1;
        r100 = this;
        goto L7
    L90:
        r100.f531211g = r114;
        invalidate();
    }

    public final int getCurrentHeight() {
        if (this.f531209e != MonthShowMode.FIXED_SIX_ROW) goto L6;
        return this.f531216l.b() * 6;
    L6:
        return this.f531211g * this.f531216l.b();
    }

    private final float getCellWidth() {
        return getMeasuredWidth() / 7;
    }

    public final CalendarDate getMCurrentDate() {
        return this.f531207c;
    }

    public final p08.a getMDayRender() {
        return this.f531216l;
    }

    public final CalendarDate.DayOfWeek getMFirstWeekDay() {
        return this.f531206b;
    }

    public final MonthShowMode getMMonthShowMode() {
        return this.f531209e;
    }

    public final CalendarDate getMSeedDate() {
        return this.f531205a;
    }

    public final CalendarDate getMSelectDate() {
        return this.f531208d;
    }

    public final int getRowNum() {
        return this.f531211g;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f531205a = new CalendarDate();
        this.f531206b = CalendarDate.DayOfWeek.SUNDAY;
        this.f531207c = new CalendarDate();
        this.f531208d = new CalendarDate();
        this.f531209e = MonthShowMode.AUTO_HEIGHT;
        this.f531210f = new n08.b[6];
        this.f531215k = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f531216l = new q08.a(r100, (int) d.a(r100, 42.0f));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = 0;
    L4:
        if (r101 >= this.f531211g) goto L15;
        n08.b r102 = this.f531210f[r101];
        if (r102 == null) goto L14;
        int r103 = 0;
    L9:
        if (r103 >= 7) goto L14;
        n08.a r104 = r102.f516611b[r103];
        if (r104 == null) goto L13;
        this.f531216l.a(r100, r104);
    L13:
        r103 = r103 + 1;
    L14:
        r101 = r101 + 1;
        goto L4
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L38;
        if (r101 != 1) goto L39;
        float r102 = r100.getX() - this.f531212h;
        float r103 = r100.getY() - this.f531213i;
        if (Math.abs(r102) >= this.f531215k) goto L39;
        if (Math.abs(r103) >= this.f531215k) goto L39;
        int r104 = (int) (this.f531212h / getCellWidth());
        int r105 = (int) (this.f531213i / getCellHeight());
        if (r104 >= 7) goto L39;
        if (r105 >= this.f531211g) goto L39;
        n08.b r106 = this.f531210f[r105];
        if (r106 == null) goto L39;
        n08.a[] r107 = r106.f516611b;
        if (r107 == null) goto L39;
        n08.a r108 = r107[r104];
        if (r108 == null) goto L39;
        CalendarDate r109 = r108.f516608c;
        this.f531208d = r109;
        e r110 = this.f531214j;
        if (r110 == null) goto L25;
        r110.c(r109);
    L25:
        CalendarAttr.MonthState r111 = r108.f516609d.f284798c;
        if (r111 != CalendarAttr.MonthState.LAST_MONTH) goto L31;
        e r112 = this.f531214j;
        if (r112 == null) goto L39;
        r112.a(-1);
        goto L39
    L31:
        if (r111 != CalendarAttr.MonthState.NEXT_MONTH) goto L35;
        e r113 = this.f531214j;
        if (r113 == null) goto L39;
        r113.a(1);
        goto L39
    L35:
        e r114 = this.f531214j;
        if (r114 == null) goto L39;
        r114.b();
    L39:
        return true;
    L38:
        this.f531212h = r100.getX();
        this.f531213i = r100.getY();
        goto L39
    }

    public final void setCurrentDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        this.f531207c = r100;
    }

    public final void setFirstWeekDay(CalendarDate.DayOfWeek r100) {
        Intrinsics.checkNotNullParameter(r100, "firstWeekDay");
        this.f531206b = r100;
    }

    public final void setMCurrentDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f531207c = r100;
    }

    public final void setMDayRender(p08.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f531216l = r100;
    }

    public final void setMFirstWeekDay(CalendarDate.DayOfWeek r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f531206b = r100;
    }

    public final void setMMonthShowMode(MonthShowMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f531209e = r100;
    }

    public final void setMSeedDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f531205a = r100;
    }

    public final void setMSelectDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f531208d = r100;
    }

    public final void setMonthShowMode(MonthShowMode r100) {
        Intrinsics.checkNotNullParameter(r100, "monthShowMode");
        this.f531209e = r100;
    }

    public final void setMonthTextSize(float r100) {
        this.f531216l.c(r100);
        invalidate();
    }

    public final void setOnMonthDayViewSelectListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "monthDayViewSelectListener");
        this.f531214j = r100;
    }

    public final void setSeedDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        this.f531205a = r100;
    }

    public final void setSelectDate(CalendarDate r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        this.f531208d = r100;
    }

    public final void setTypeFace(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "typeFace");
        this.f531216l.setTypeFace(r100);
        invalidate();
    }
}
