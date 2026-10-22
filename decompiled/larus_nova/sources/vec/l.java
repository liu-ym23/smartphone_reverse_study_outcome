package vec;

import com.ss.android.lark.widget.timepicker.monthview.MonthCalendarViewAdapter;
import com.ss.android.lark.widget.timepicker.monthview.MonthViewPager;
import com.ss.android.lark.widget.timepicker.monthview.data.CalendarDate;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonthViewPager f554559a;

    @Override // vec.n
    public final void a() {
    }

    @Override // vec.n
    public final void c() {
    }

    @Override // vec.n
    public final void d() {
    }

    @Override // vec.n
    public final void e() {
    }

    public l(MonthViewPager r100) {
        this.f554559a = r100;
    }

    @Override // vec.n
    public final void b(int r100) {
        MonthCalendarViewAdapter r101 = (MonthCalendarViewAdapter) this.f554559a.getAdapter();
        g r102 = (g) r101.g(0);
        g r103 = (g) r101.g(2);
        if (r100 != 0) goto L5;
        CalendarDate r104 = r101.h();
        xec.b r105 = this.f554559a.f449041h;
        if (r105 == null) goto L17;
        r105.c(r104);
        this.f554559a.f449041h.a();
    L17:
        CalendarDate r106 = r101.h();
        if (r103 == null) goto L20;
        r103.setSeedDate(r106);
        r103.setStartDate(yec.a.b(r106));
        r103.setEndDate(yec.a.a(r106));
    L20:
        r101.l(false);
        return;
    L5:
        if (r100 != 1) goto L23;
        CalendarDate r107 = r101.i();
        xec.b r108 = this.f554559a.f449041h;
        if (r108 == null) goto L10;
        r108.c(r107);
        this.f554559a.f449041h.b();
    L10:
        CalendarDate r109 = r101.i();
        if (r102 == null) goto L13;
        r102.setSeedDate(r109);
        r102.setStartDate(yec.a.b(r109));
        r102.setEndDate(yec.a.a(r109));
    L13:
        r101.l(false);
        return;
    }
}
