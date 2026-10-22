package kw6;

import com.bytedance.locallife.biz.common.utils.c;
import com.bytedance.locallife.biz.monitor.param.KeyPageName;
import com.bytedance.locallife.biz.monitor.param.LifePageParamTraceManager;
import com.bytedance.locallife.biz.monitor.param.PageParamType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f506400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f506401b;

    public b(Map<String, ? extends Object> r100, String r101) {
        this.f506400a = r100;
        this.f506401b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = com.bytedance.locallife.biz.common.utils.b.f256637a.toJson(this.f506400a);     // Catch: Throwable -> L4 Exception -> L6
        boolean r101 = LifePageParamTraceManager.f256714a;     // Catch: Throwable -> L4 Exception -> L6
        LifePageParamTraceManager.e(KeyPageName.PDP_PAGE, this.f506401b, PageParamType.API_TRACK_PARAMS, r100);     // Catch: Throwable -> L4 Exception -> L6
    L13:
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    L17:
        return;
    L6:
        e = move-exception;
        c.c("LifePdpTrace", "addApiTrackParams error", e);     // Catch: Throwable -> L4
        goto L13
    }
}
