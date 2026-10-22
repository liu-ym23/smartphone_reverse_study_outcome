package zec;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$DateState;
import com.ss.android.lark.widget.timepicker.monthview.constants.MonthViewAttr$SelectState;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;

/* JADX INFO: loaded from: classes38.dex */
public class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vec.a f571576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f571577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f571578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f571579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f571580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f571581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CalendarDate f571582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CalendarDate f571583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDate f571584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CalendarDate f571585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CalendarDate f571586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CalendarDate f571587l;

    public CalendarDate getEndDate() {
        return this.f571587l;
    }

    public CalendarDate getStartDate() {
        return this.f571586k;
    }

    public void setCurrentDate(CalendarDate r100) {
        this.f571583h = r100;
    }

    public void setEndDate(CalendarDate r100) {
        this.f571587l = r100;
    }

    public void setSeedDate(CalendarDate r100) {
        this.f571582g = r100;
    }

    public void setSelectDate(CalendarDate r100) {
        this.f571584i = r100;
        this.f571585j = r100;
    }

    public void setShownData(CalendarDate r100) {
        this.f571585j = r100;
    }

    public void setStartDate(CalendarDate r100) {
        this.f571586k = r100;
    }

    public a(Context r100, vec.a r101) {
        super(r100);
        this.f571580e = 0.0f;
        this.f571581f = 0.0f;
        this.f571576a = r101;
        this.f571577b = UIUtils.getScaledTouchSlop(r100);
        int r102 = DesktopUtil.f420394a;
        this.f571578c = r101.getCellViewHeight();
        this.f571579d = getMeasuredWidth() / 7;
    }

    public final void a(wec.a r100, CalendarDate r101) {
        if (r101.sameDay(this.f571583h) == false) goto L6;
        r100.f559449b = MonthViewAttr$DateState.CURRENT_DATE;
        return;
    L6:
        if (r101.beforeDay(this.f571583h) == false) goto L8;
        r100.f559449b = MonthViewAttr$DateState.PAST_DATE;
        return;
    L8:
        r100.f559449b = MonthViewAttr$DateState.FUTURE_DATE;
    }

    public final void b(wec.a r100, CalendarDate r101) {
        if (r101.sameDay(this.f571584i) == false) goto L5;
        r100.f559448a = MonthViewAttr$SelectState.SELECT;
        return;
    L5:
        r100.f559448a = MonthViewAttr$SelectState.UN_SELECT;
    }
}
