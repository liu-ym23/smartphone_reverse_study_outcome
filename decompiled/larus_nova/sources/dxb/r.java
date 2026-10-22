package dxb;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f470508b;

    public r(cxb.a r100, String r101) {
        this.f470507a = r100;
        this.f470508b = r101;
    }

    public final void a() {
        g r100 = new g("wb_browse_url_start", c.f470461f, this.f470507a);
        int r101 = t.f470510a;
        t.a(this.f470507a, r100, this.f470508b);
        cxb.a r102 = this.f470507a;
        if (r102 == null) goto L13;
        Map<String, Object> r103 = r102.getCommonParams();
        if (r103 == null) goto L13;
        int r104 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        Intrinsics.checkNotNullParameter(r102.getBaseTraceId(), "baseTraceId");
        ntb.o r105 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r105 == null) goto L10;
        String r106 = r105.T();
        if (r106 == null) goto L10;
    L12:
        if (r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, r106) == null) goto L13;
    L14:
        r100.b();
        return;
    L10:
        r106 = "";
    L13:
        com.ss.android.lark.officesdk.utils.di.j.b("WebMonitorManager", "expand TracingSpan error");
        Unit r107 = Unit.INSTANCE;
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
