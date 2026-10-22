package com.bytedance.webx.monitor.falconx;

import android.webkit.WebView;
import bz2.c;
import bz2.e;
import com.bytedance.android.monitor.webview.b;
import com.bytedance.android.monitor.webview.h;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f272598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterceptorModel f272599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f272600c;

    /* JADX INFO: Removed unreachable split cross block B:30:0x009b */
    public final void a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L24
        if (this.f272598a == false) goto L5;
        int r101 = 0;
    L6:
        e.f(r100, "is_custom_interceptor", r101);     // Catch: Exception -> L24
        e.i(r100, "resource_url", this.f272599b.url);     // Catch: Exception -> L24
        e.i(r100, "offline_rule", this.f272599b.offlineRule);     // Catch: Exception -> L24
        e.h(r100, "offline_status", this.f272599b.offlineStatus);     // Catch: Exception -> L24
        e.h(r100, "offline_duration", this.f272599b.offlineDuration);     // Catch: Exception -> L24
        e.i(r100, "channel", this.f272599b.channel);     // Catch: Exception -> L24
        e.i(r100, "mime_type", this.f272599b.mimeType);     // Catch: Exception -> L24
        e.i(r100, "error_code", this.f272599b.errCode);     // Catch: Exception -> L24
        e.h(r100, "package_version", this.f272599b.pkgVersion);     // Catch: Exception -> L24
        e.i(r100, TTVideoEngineInterface.PLAY_API_KEY_AC, this.f272599b.f243226ac);     // Catch: Exception -> L24
        h r102 = h.f162933g;     // Catch: Exception -> L24
        WebView r103 = this.f272600c;     // Catch: Exception -> L24
        String r104 = this.f272599b.pageUrl;     // Catch: Exception -> L24
        r102.getClass();     // Catch: Exception -> L24
    L22:
        c.a();     // Catch: Exception -> L24
    L27:
        return;
    L8:
        if (r102.p() == false) goto L27;
        if (r102.q(r103) == false) goto L27;
        b r105 = r102.k(r103);     // Catch: Exception -> L22
        if (r105 == null) goto L27;
        com.bytedance.android.monitor.webview.c r106 = r105.f162894b;     // Catch: Exception -> L22
        if (r106 == null) goto L27;
        if (r104 == null) goto L20;
        r106.c(r103, r104, "falconPerf", r100);     // Catch: Exception -> L22
        goto L27
    L20:
        r106.f(r103, r100);     // Catch: Exception -> L22
        goto L27
    L5:
        r101 = 1;
    L24:
        e = move-exception;
        e.printStackTrace();
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

    public a(boolean r100, InterceptorModel r101, WebView r102) {
        this.f272598a = r100;
        this.f272599b = r101;
        this.f272600c = r102;
    }
}
