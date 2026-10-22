package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.HTTPUSocket;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.net.DatagramSocket;
import java.net.InetAddress;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class CastSSDPSearchResponseSocket extends HTTPUSocket implements Runnable {
    private static final String TAG = null;
    private Thread deviceSearchResponseThread;
    private CastControlPoint mControlPoint;

    @Override // java.lang.Runnable
    public void run() {
        com_ss_cast_discovery_ssdp_CastSSDPSearchResponseSocket_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        TAG = "CastSSDPSearchResponseSocket";
    }

    public void start() {
        StringBuffer r100 = new StringBuffer("CastSSDPSearchResponseSocket/");
        DatagramSocket r101 = getDatagramSocket();
        if (r101 == null) goto L8;
        InetAddress r102 = r101.getLocalAddress();
        if (r102 == null) goto L8;
        r100.append(r102);
        r100.append(':');
        r100.append(r101.getLocalPort());
    L8:
        if (this.deviceSearchResponseThread == null) goto L10;
        return;
    L10:
        Logger.d(TAG, " start:" + r100);
        PthreadThreadV2 r103 = new PthreadThreadV2(this, r100.toString());
        this.deviceSearchResponseThread = r103;
        ThreadMethodProxy.start(r103);
    }

    public void stop() {
        Logger.d(TAG, " stop");
        this.deviceSearchResponseThread = null;
    }

    public void com_ss_cast_discovery_ssdp_CastSSDPSearchResponseSocket__run$___twin___() {
        Thread r100 = ThreadMethodProxy.currentThread();
        CastControlPoint r101 = getControlPoint();
    L4:
        if (this.deviceSearchResponseThread != r100) goto L11;
        Thread.yield();
        CastSSDPPacket r102 = receiveBDlink();
        if (r102 == null) goto L18;
        Logger.d(TAG, " receive search package " + r102);
        if (r101 == null) goto L4;
        r101.searchResponseReceived(r102);
        goto L4
    L18:
        return;
    }

    public CastControlPoint getControlPoint() {
        return this.mControlPoint;
    }

    public CastSSDPSearchResponseSocket(ContextManager.CastContext r100) {
        super(r100);
        this.mControlPoint = null;
        this.deviceSearchResponseThread = null;
        setControlPoint(null);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_cast_discovery_ssdp_CastSSDPSearchResponseSocket_com_larus_apm_impl_protector_RunnableLancet_run(CastSSDPSearchResponseSocket r100) {
        r100.com_ss_cast_discovery_ssdp_CastSSDPSearchResponseSocket__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setControlPoint(CastControlPoint r100) {
        this.mControlPoint = r100;
    }

    public boolean post(String r100, int r110, g r111) {
        Logger.d(TAG, " post search request addr:" + r100 + ", port:" + r110 + ", req:" + r111.toString());
        return post(r100, r110, r111.toString(), "", false);
    }

    public boolean post(String r100, int r101, h r102) {
        return post(r100, r101, r102.getHeader(), "", false);
    }
}
