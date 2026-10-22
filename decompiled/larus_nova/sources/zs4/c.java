package zs4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.calendar.CalendarViewContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements zm4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CalendarViewContainer f573483a;

    public c(CalendarViewContainer r100) {
        this.f573483a = r100;
    }

    @Override // zm4.a
    public final void a(String r100) {
        tt5.a.h("CalendarViewContainer", "onLoadFailed: lifecycle cb, " + r100);
        CalendarViewContainer r101 = this.f573483a;
        r101.f213252b = Boolean.FALSE;
        Function1<? super String, Unit> r102 = r101.f213257g;
        if (r102 == null) goto L6;
        r102.invoke(r100);
        return;
    }
}
