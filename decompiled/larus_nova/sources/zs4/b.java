package zs4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.calendar.CalendarViewContainer;
import com.lynx.tasm.q1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CalendarViewContainer f573482a;

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        tt5.a.h("CalendarViewContainer", "onLoadSuccess");
        CalendarViewContainer r100 = this.f573482a;
        r100.f213252b = Boolean.TRUE;
        r100.a();
    }

    public b(CalendarViewContainer r100) {
        this.f573482a = r100;
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadFailed(String r100) {
        super.onLoadFailed(r100);
        tt5.a.h("CalendarViewContainer", "onLoadFailed: lynxViewClient cb, " + r100);
        CalendarViewContainer r101 = this.f573482a;
        r101.f213252b = Boolean.FALSE;
        Function1<? super String, Unit> r102 = r101.f213257g;
        if (r102 == null) goto L6;
        r102.invoke(r100);
        return;
    }
}
