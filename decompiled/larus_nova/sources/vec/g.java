package vec;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.android.lark.widget.timepicker.monthview.MonthCalendarViewAdapter;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$DateState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$MonthState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$OptionalState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectTimeType;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class g extends zec.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final wec.b[] f554550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f554551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public xec.c f554552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CalendarDate f554553p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CalendarDate f554554q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MonthViewAttr$SelectTimeType f554555r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CalendarDate f554556s;

    public final void c() {
        int r100 = com.larksuite.framework.utils.e.d(this.f571582g.getYear(), this.f571582g.getMonth() - 1);
        int r101 = com.larksuite.framework.utils.e.d(this.f571582g.getYear(), this.f571582g.getMonth());
        int r102 = yec.a.c(this.f571582g.getYear(), this.f571582g.getMonth());
        int r103 = r102 + r101;
        this.f554551n = Math.ceil(r103 / 7.0f);
        int r104 = 0;
        int r110 = 0;
    L4:
        if (r110 >= this.f554551n) goto L39;
        int r111 = r104;
        int r112 = 0;
    L7:
        if (r112 >= 7) goto L38;
        int r105 = (r110 * 7) + r112;
        if (r105 < r102) goto L19;
        if (r105 >= r103) goto L19;
        r111 = r111 + 1;
        CalendarDate r113 = this.f571582g.modifyDay(r111);
        wec.b[] r114 = this.f554550m;
        if (r114[r110] != null) goto L14;
        r114[r110] = new wec.b();
    L14:
        wec.a[] r115 = r114[r110].f559455a;
        if (r115[r112] != null) goto L18;
        r115[r112] = new wec.a(MonthViewAttr$SelectState.UN_SELECT, MonthViewAttr$DateState.CURRENT_DATE, MonthViewAttr$MonthState.CURRENT_MONTH, r113, r110, r112);
    L18:
        e(r114[r110].f559455a[r112], r113);
        wec.a r106 = this.f554550m[r110].f559455a[r112];
        r106.f559452e = r113;
        b(r106, r113);
        a(this.f554550m[r110].f559455a[r112], r113);
        this.f554550m[r110].f559455a[r112].f559450c = MonthViewAttr$MonthState.CURRENT_MONTH;
        r113.sameDay(this.f571584i);
    L37:
        r112 = r112 + 1;
    L19:
        if (r105 >= r102) goto L28;
        CalendarDate r107 = new CalendarDate(this.f571582g.getYear(), this.f571582g.getMonth() - 1, r100 - ((r102 - r105) - 1), 0, 0, 0);
        wec.b[] r116 = this.f554550m;
        if (r116[r110] != null) goto L23;
        r116[r110] = new wec.b();
    L23:
        wec.a[] r117 = r116[r110].f559455a;
        if (r117[r112] != null) goto L27;
        r117[r112] = new wec.a(MonthViewAttr$SelectState.UN_SELECT, MonthViewAttr$DateState.PAST_DATE, MonthViewAttr$MonthState.LAST_MONTH, r107, r110, r112);
    L27:
        e(r116[r110].f559455a[r112], r107);
        wec.a r108 = this.f554550m[r110].f559455a[r112];
        r108.f559452e = r107;
        b(r108, r107);
        a(this.f554550m[r110].f559455a[r112], r107);
        this.f554550m[r110].f559455a[r112].f559450c = MonthViewAttr$MonthState.LAST_MONTH;
        goto L37
    L28:
        if (r105 < r103) goto L37;
        CalendarDate r109 = new CalendarDate(this.f571582g.getYear(), this.f571582g.getMonth() + 1, ((r105 - r102) - r101) + 1, 0, 0, 0);
        wec.b[] r118 = this.f554550m;
        if (r118[r110] != null) goto L32;
        r118[r110] = new wec.b();
    L32:
        wec.a[] r119 = r118[r110].f559455a;
        if (r119[r112] != null) goto L36;
        r119[r112] = new wec.a(MonthViewAttr$SelectState.UN_SELECT, MonthViewAttr$DateState.FUTURE_DATE, MonthViewAttr$MonthState.NEXT_MONTH, r109, r110, r112);
    L36:
        e(r118[r110].f559455a[r112], r109);
        wec.a r120 = this.f554550m[r110].f559455a[r112];
        r120.f559452e = r109;
        b(r120, r109);
        a(this.f554550m[r110].f559455a[r112], r109);
        this.f554550m[r110].f559455a[r112].f559450c = MonthViewAttr$MonthState.NEXT_MONTH;
        goto L37
    L38:
        r110 = r110 + 1;
        r104 = r111;
        goto L4
    }

    public int getRowNum() {
        return (int) this.f554551n;
    }

    public final void d() {
        c();
        invalidate();
    }

    public CalendarDate getSelectDate() {
        return this.f571584i;
    }

    public CalendarDate getShownDate() {
        return this.f571585j;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        int r100 = 0;
    L4:
        if (r100 >= this.f554551n) goto L15;
        if (this.f554550m[r100] == null) goto L14;
        int r101 = 0;
    L9:
        if (r101 >= 7) goto L14;
        wec.a r102 = this.f554550m[r100].f559455a[r101];
        if (r102 == null) goto L13;
        zec.b r103 = (zec.b) this.f571576a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r102, BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY);
        r103.f571588a = r102;
        r103.a();
        int r104 = r110.save();
        int r105 = r110.getWidth() / 7;
        r110.translate((r102.f559454g * r105) + ((r105 - r103.getMeasuredWidth()) / 2), r102.f559453f * r103.getMeasuredHeight());
        r103.draw(r110);
        r110.restoreToCount(r104);
    L13:
        r101 = r101 + 1;
    L14:
        r100 = r100 + 1;
        goto L4
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();
        if (r100 == 0) goto L58;
        if (r100 != 1) goto L59;
        float r101 = r110.getX() - this.f571580e;
        float r111 = r110.getY() - this.f571581f;
        if (Math.abs(r101) >= this.f571577b) goto L59;
        if (Math.abs(r111) >= this.f571577b) goto L59;
        if (this.f571579d != 0) goto L13;
    L14:
        this.f571578c = this.f571576a.getCellViewHeight();
        this.f571579d = getWidth() / 7;
    L15:
        int r112 = (int) (this.f571580e / this.f571579d);
        int r102 = (int) (this.f571581f / this.f571578c);
        if (r112 < 7) goto L18;
    L26:
        boolean r103 = false;
    L27:
        if (r103 == false) goto L59;
        MonthCalendarViewAdapter r104 = ((f) this.f554552o).f554549a;
        int r105 = 0;
    L31:
        if (r105 >= r104.getCount()) goto L45;
        g r106 = (g) r104.g(r105);
        int r107 = 0;
    L34:
        if (r107 >= r106.f554551n) goto L44;
        if (r106.f554550m[r107] == null) goto L43;
        int r108 = 0;
    L38:
        if (r108 >= 7) goto L43;
        wec.a r109 = r106.f554550m[r107].f559455a[r108];
        if (r109.f559448a == MonthViewAttr$SelectState.SELECT) goto L41;
        r108 = r108 + 1;
        goto L38
    L41:
        r109.f559448a = MonthViewAttr$SelectState.UN_SELECT;
    L43:
        r107 = r107 + 1;
        goto L34
    L44:
        r105 = r105 + 1;
        goto L31
    L45:
        if (r112 < 7) goto L47;
    L57:
        ((f) this.f554552o).f554549a.l(true);
        goto L59
    L47:
        if (r102 >= this.f554551n) goto L57;
        wec.b r113 = this.f554550m[r102];
        if (r113 == null) goto L57;
        wec.a r114 = r113.f559455a[r112];
        CalendarDate r115 = r114.f559452e;
        this.f571584i = r115;
        this.f571585j = r115;
        ((f) this.f554552o).f554549a.f449022h.b(r115);
        MonthViewAttr$MonthState r116 = r114.f559450c;
        if (r116 != MonthViewAttr$MonthState.LAST_MONTH) goto L55;
        ((f) this.f554552o).f554549a.f449022h.a(-1);
        goto L57
    L55:
        if (r116 != MonthViewAttr$MonthState.NEXT_MONTH) goto L57;
        ((f) this.f554552o).f554549a.f449022h.a(1);
        goto L57
    L18:
        if (r102 >= this.f554551n) goto L26;
        wec.b r117 = this.f554550m[r102];
        if (r117 == null) goto L26;
        if (r117.f559455a[r112].f559451d == MonthViewAttr$OptionalState.NOT_OPTIONAL) goto L26;
        r103 = true;
        goto L27
    L13:
        if (this.f571578c != 0) goto L15;
    L59:
        return true;
    L58:
        this.f571580e = r110.getX();
        this.f571581f = r110.getY();
        goto L59
    }

    public void setOnMonthDayViewSelectListener(xec.c r100) {
        this.f554552o = r100;
    }

    public g(Context r100, a r101) {
        super(r100, r101);
        this.f554550m = new wec.b[6];
        this.f554553p = new CalendarDate(new Date(0));
        this.f554554q = new CalendarDate();
        this.f554555r = MonthViewAttr$SelectTimeType.START_TIME;
        this.f554556s = new CalendarDate();
    }

    public void e(wec.a r100, CalendarDate r101) {
        MonthViewAttr$SelectTimeType r102 = this.f554555r;
        if (r102 != MonthViewAttr$SelectTimeType.START_TIME) goto L9;
        if (r101.getJulianDay() <= this.f554554q.getJulianDay()) goto L7;
        r100.f559451d = MonthViewAttr$OptionalState.NOT_OPTIONAL;
        return;
    L7:
        r100.f559451d = MonthViewAttr$OptionalState.OPTIONAL;
        return;
    L9:
        if (r102 == MonthViewAttr$SelectTimeType.END_TIME) goto L11;
        return;
    L11:
        if (r101.getJulianDay() <= this.f554556s.getJulianDay()) goto L13;
    L16:
        r100.f559451d = MonthViewAttr$OptionalState.NOT_OPTIONAL;
        return;
    L13:
        if (r101.getJulianDay() < this.f554553p.getJulianDay()) goto L16;
        r100.f559451d = MonthViewAttr$OptionalState.OPTIONAL;
    }
}
