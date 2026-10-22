package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements ICronetDepend {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f525637b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICronetDepend f525638a;

    public static d a() {
        if (f525637b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f525637b != null) goto L9;
        f525637b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f525637b;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final String getSsCookieKey() {
        ICronetDepend r100 = this.f525638a;
        if (r100 != null) goto L5;
        return CronetHttpURLConnection.SS_COOKIE;
    L5:
        return r100.getSsCookieKey();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final boolean loggerDebug() {
        ICronetDepend r100 = this.f525638a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.loggerDebug();
    }

    public d() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final void setAdapter(ICronetDepend r100) {
        this.f525638a = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public final void loggerD(String r100, String r101) {
        ICronetDepend r102 = this.f525638a;
        if (r102 == null) goto L6;
        r102.loggerD(r100, r101);
        return;
    }
}
