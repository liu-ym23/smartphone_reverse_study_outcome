package m08;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.component.universe_design.datepicker.impl.MonthCalendarViewAdapter;
import com.larksuite.component.universe_design.datepicker.impl.MonthViewPager;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;
import o08.c;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonthViewPager f511494a;

    @Override // o08.c
    public final void a() {
    }

    @Override // o08.c
    public final void c() {
    }

    public b(MonthViewPager r100) {
        this.f511494a = r100;
    }

    @Override // o08.c
    public final void b(int r100) {
        PagerAdapter r101 = this.f511494a.getAdapter();
        if ((r101 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r102 = (MonthCalendarViewAdapter) r101;
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r100 == 0) goto L18;
        if (r100 != 1) goto L28;
        p08.c r103 = this.f511494a.f284793h;
        if (r103 == null) goto L15;
        CalendarDate r104 = r102.f284791d.getSelectedDate().modifyMonth(-1);
        r104.setMonthDay(1);
        r103.c(r104.moveToDayStart());
    L15:
        p08.c r105 = this.f511494a.f284793h;
        if (r105 == null) goto L25;
        r105.b();
        return;
    L25:
        return;
    L28:
        return;
    L18:
        p08.c r106 = this.f511494a.f284793h;
        if (r106 == null) goto L21;
        CalendarDate r107 = r102.f284791d.getSelectedDate().modifyMonth(1);
        r107.setMonthDay(1);
        r106.c(r107.moveToDayStart());
    L21:
        p08.c r108 = this.f511494a.f284793h;
        if (r108 == null) goto L27;
        r108.a();
        return;
    L27:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // o08.c
    public final void d(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
    }

    @Override // o08.c
    public final void e(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
    }
}
