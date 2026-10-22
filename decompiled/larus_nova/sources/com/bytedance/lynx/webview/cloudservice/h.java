package com.bytedance.lynx.webview.cloudservice;

import android.webkit.ValueCallback;
import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.q0;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements o17.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueCallback f265098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f265099b;

    @Override // o17.f.a
    public final void a(o17.f r100) {
        this.f265098a.onReceiveValue("request_fail");
        long r101 = System.currentTimeMillis();
        i.a(EventType.SCC_CLOUD_SERVICE_ADBLOCK, r100, r101 - this.f265099b, r101 - TTWebContext.h().f265224j);
    }

    @Override // o17.f.a
    public final void b(o17.f r100) {
        this.f265098a.onReceiveValue(new String(r100.f521720b));
        long r101 = System.currentTimeMillis();
        i.a(EventType.SCC_CLOUD_SERVICE_ADBLOCK, r100, r101 - this.f265099b, r101 - TTWebContext.h().f265224j);
    }

    public h(q0 r100, long r101) {
        this.f265098a = r100;
        this.f265099b = r101;
    }
}
