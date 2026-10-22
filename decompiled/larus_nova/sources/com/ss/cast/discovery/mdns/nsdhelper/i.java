package com.ss.cast.discovery.mdns.nsdhelper;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.ss.cast.discovery.mdns.NsdListener;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public final class i implements NsdManager.ResolveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NsdHelper f456310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CastLogger f456311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f456312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NsdListener f456313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f456314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f456315f;

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onServiceResolved(NsdServiceInfo r100) {
        this.f456311b.i("NsdHelper.NsdListenerResolve", String.format(Locale.getDefault(), "onServiceResolved -> name: %s, port %d, type: %s", new Object[]{r100.getServiceName(), Integer.valueOf(r100.getPort()), r100.getServiceType()}));
        this.f456310a.onNsdServiceResolved(r100, this.f456312c, this.f456314e, this.f456315f);
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onResolveFailed(NsdServiceInfo r100, int r101) {
        int r102 = r101 + 262144;
        this.f456311b.i("NsdHelper.NsdListenerResolve", "onResolveFailed, serviceType:" + r100.getServiceType() + ", errorCode:" + r102);
        this.f456310a.onNsdResolveFailed(r100, this.f456312c, this.f456314e, r102, this.f456315f);
    }

    public i(ContextManager.CastContext r100, NsdHelper r101, NsdListener r102, String r103, boolean r104) {
        this.f456310a = r101;
        this.f456311b = ContextManager.getLogger(r100);
        this.f456313d = r102;
        this.f456312c = "NsdListenerResolve_" + System.identityHashCode(this);
        this.f456314e = r103;
        this.f456315f = r104;
    }
}
