package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.HTTPMUSocket;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import com.byted.cast.linkcommon.cybergarage.util.TimerUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public final class i extends HTTPMUSocket implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f456415c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListenerList f456416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PthreadThreadV2 f456417b;

    static {
        f456415c = i.class.getSimpleName();
    }

    public final void start() {
        StringBuffer r100 = new StringBuffer("BDLinkSSDPSearchSocket/");
        String r101 = getLocalAddress();
        if (r101 != null) goto L5;
    L7:
        Logger.d(f456415c, "will start thread:" + r100.toString());
        PthreadThreadV2 r102 = new PthreadThreadV2(this, r100.toString());
        this.f456417b = r102;
        ThreadMethodProxy.start(r102);
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        r100.append(getLocalAddress());
        r100.append(':');
        r100.append(getLocalPort());
        r100.append(" -> ");
        r100.append(getMulticastAddress());
        r100.append(':');
        r100.append(getMulticastPort());
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        Thread r100 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L16
    L4:
        if (this.f456417b != r100) goto L34;
        Thread.yield();     // Catch: Throwable -> L16
        CastSSDPPacket r101 = receiveBDLink();     // Catch: Throwable -> L16 IOException -> L21
        if (r101 == null) goto L4;
        TimerUtil.waitTime(5);     // Catch: Throwable -> L16
        if (r101.isDiscover() == false) goto L4;
        int r102 = this.f456416a.size();     // Catch: Throwable -> L16
        int r103 = 0;
    L13:
        if (r103 >= r102) goto L4;
        ((SearchListener) this.f456416a.get(r103)).bdlinkDeviceSearchReceived(r101);     // Catch: Throwable -> L16
        r103 = r103 + 1;
    L33:
        return;
    L34:
        return;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L20;
        return;
    L20:
        throw th;
    }

    public i(ContextManager.CastContext r100, String r101, String r102) {
        super(r100);
        this.f456416a = new ListenerList();
        this.f456417b = null;
        if (HostInterface.isIPv6Address(r101) == false) goto L8;
        if (HostInterface.isIPv6Address(r102) == false) goto L8;
    L11:
        open(r102, 1900, r101);
        return;
    L8:
        if (HostInterface.isIPv4Address(r101) == false) goto L14;
        if (HostInterface.isIPv4Address(r102) == true) goto L11;
    L14:
        throw new IllegalArgumentException("Cannot open a UDP Socket for IPv6 address on IPv4 interface or viceversa");
    }
}
