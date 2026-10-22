package com.bytedance.caijing.sdk.infra.base.event;

import com.android.ttcjpaysdk.kmp.common.monitor.CJResponseMonitorInterceptor;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CJContext f202348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f202349b;

    public c(CJContext r100, Map<String, ? extends Object> r101) {
        this.f202348a = r100;
        this.f202349b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        CJReporter r100 = CJReporter.f202294a;     // Catch: Throwable -> L20
        HashMap r101 = CJReporter.e(this.f202348a);     // Catch: Throwable -> L20
        r101.putAll(this.f202349b);     // Catch: Throwable -> L20
        JSONObject r102 = com.bytedance.caijing.sdk.infra.utils.d.a(r101);     // Catch: Throwable -> L20
        CJLogger.d("CJReporter", "event wallet_rd_biz_server_api_monitor: " + r102);     // Catch: Throwable -> L20
        CJReporter.c(CJResponseMonitorInterceptor.EVENT_NAME_DEFAULT, r102);     // Catch: Throwable -> L20
        CJReporter.a(CJResponseMonitorInterceptor.EVENT_NAME_DEFAULT, this.f202349b);     // Catch: Throwable -> L20
        Object r103 = this.f202349b.get("path");     // Catch: Throwable -> L20
        String r104 = "";
        if (r103 == null) goto L8;
        String r105 = r103.toString();     // Catch: Throwable -> L20
        if (r105 == null) goto L8;
    L9:
        Object r106 = this.f202349b.get("status");     // Catch: Throwable -> L20
        if (r106 != null) goto L12;
        r106 = -100;     // Catch: Throwable -> L20
    L12:
        Object r107 = this.f202349b.get("code");     // Catch: Throwable -> L20
        if (r107 == null) goto L18;
        String r108 = r107.toString();     // Catch: Throwable -> L20
        if (r108 == null) goto L18;
        r104 = r108;
    L18:
        String r109 = r105 + "__aid-" + CJEnv.e();     // Catch: Throwable -> L20
        JSONObject r110 = com.bytedance.caijing.sdk.infra.utils.d.a(CJReporter.d(this.f202348a));     // Catch: Throwable -> L20
        r110.put("path", r105);     // Catch: Throwable -> L20
        r110.put("code", r104);     // Catch: Throwable -> L20
        r110.put("status", r106);     // Catch: Throwable -> L20
        r110.put("monitor_cate_key", r109);     // Catch: Throwable -> L20
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CJReporter.b(CJResponseMonitorInterceptor.EVENT_NAME_DEFAULT, r110, r102);     // Catch: Throwable -> L20
        return;
    L8:
        r105 = "";
    L20:
        th = move-exception;
        CJLogger.b("CJReporter", th.toString());
        if (CJEnv.n() == true) goto L25;
        return;
    L25:
        throw new RuntimeException(th);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
