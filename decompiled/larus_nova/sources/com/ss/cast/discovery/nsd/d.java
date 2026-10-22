package com.ss.cast.discovery.nsd;

import android.content.Context;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.PreferenceUtils;
import com.byted.cast.common.source.ServiceInfo;
import com.byted.cast.common.utils.GsonUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceInfo f456373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f456374b;

    public final void a() {
        c r100 = this.f456374b;
        ServiceInfo r101 = this.f456373a;
        r100.getClass();
        r100.f456371m.put(r101.f33719ip + "_" + r101.port + "_" + r101.name, r101);
        String r102 = GsonUtils.toJsonIgnoreException(r100.f456371m);
        r100.f456361c.i("BDLinkServiceDiskCacheHelper", "writeCacheInner size: " + r100.f456371m.size() + ", serviceMap: " + r102);
        Context r103 = r100.f456359a;
        if (r103 == null) goto L10;
        ContextManager.CastContext r104 = r100.f456360b;
        if (r104 != null) goto L7;
        String r105 = "";
    L8:
        PreferenceUtils.setBDLinkServiceInfo(r103, r105, r102);
        return;
    L7:
        r105 = r104.getProjectId();
        goto L8
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

    public d(c r100, ServiceInfo r101) {
        this.f456374b = r100;
        this.f456373a = r101;
    }
}
