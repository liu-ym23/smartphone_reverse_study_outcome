package gt5;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f482574b;

    public r(ft5.a r100, String r101) {
        this.f482573a = r100;
        this.f482574b = r101;
    }

    public final void a() {
        g r100 = new g("wb_browse_url_start", e.f482526j, this.f482573a);
        int r101 = p.f482566a;
        p.a(this.f482573a, r100, this.f482574b);
        ft5.a r102 = this.f482573a;
        if (r102 == null) goto L15;
        Map<String, Object> r103 = r102.getCommonParams();
        if (r103 == null) goto L15;
        TracingCoreSpan r104 = r102.getBaseTraceSpan();
        if (r104 == null) goto L12;
        TracingCoreSpan r105 = r104.generateSpan();
        if (r105 == null) goto L12;
        String r106 = r105.getTracingID();
        if (r106 == null) goto L12;
    L14:
        if (r103.put(BindCardPayConfirmConstants.Key.TRACE_ID, r106) == null) goto L15;
    L16:
        r100.flush();
        return;
    L12:
        r106 = "";
    L15:
        Log.e("WebMonitorManager", "expand TracingSpan error");
        Unit r107 = Unit.INSTANCE;
        goto L16
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
