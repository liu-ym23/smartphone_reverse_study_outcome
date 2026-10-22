package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.HTTPMUSocket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDP;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends HTTPMUSocket implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f456411d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CastControlPoint f456412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f456413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PthreadThreadV2 f456414c;

    static {
        f456411d = d.class.getSimpleName();
    }

    public final void a() {
        String r100 = f456411d;
        Thread r101 = ThreadMethodProxy.currentThread();
    L4:
        if (this.f456414c != r101) goto L37;
        Thread.yield();
        CastSSDPPacket r102 = receiveBDLink();     // Catch: IOException -> L20
        if (r102 == null) goto L4;
        InetAddress r103 = getMulticastInetAddress();
        InetAddress r104 = r102.getHostInetAddress();
        if (r103.equals(r104) == true) goto L17;
        if (this.f456413b == false) goto L16;
        if (SSDP.BROADCAST_ADDRESS.equals(r104.getHostAddress()) == true) goto L17;
    L16:
        Logger.d(r100, " Invalidate Multicast Received from IP " + r103 + " on " + r104);
    L17:
        CastControlPoint r105 = this.f456412a;
        if (r105 == null) goto L4;
        r105.notifyReceived(r102);
    L20:
        e = move-exception;
        Logger.d(r100, " receive notify exception " + e.getMessage());
        return;
    }

    @Override // com.byted.cast.linkcommon.cybergarage.upnp.ssdp.HTTPMUSocket
    public final boolean close() {
        return super.close();
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

    public final boolean open(String r100) {
        setMulticastInetAddress(SSDP.BDLINK_ADDRESS, 1900);
        return super.open(SSDP.BDLINK_ADDRESS, 1900, r100);
    }

    public d(ContextManager.CastContext r100, boolean r101) {
        super(r100);
        this.f456412a = null;
        this.f456414c = null;
        this.f456413b = r101;
    }
}
