package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes40.dex */
public class CastSSDPNotifySocketList extends Vector {
    private InetAddress[] binds;
    private ContextManager.CastContext mCastContext;

    public void close() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPNotifySocket(r101).close();
        r101 = r101 + 1;
        goto L3
    L5:
        clear();
    }

    public void start() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L10;
        d r102 = getSSDPNotifySocket(r101);
        r102.getClass();
        StringBuffer r103 = new StringBuffer("BDLinkSSDPNotifySocket/");
        String r104 = r102.getLocalAddress();
        String r105 = d.f456411d;
        if (r104 == null) goto L9;
        if (r104.length() <= 0) goto L9;
        r103.append(r102.getLocalAddress());
        r103.append(':');
        r103.append(r102.getLocalPort());
        r103.append(" -> ");
        r103.append(r102.getMulticastAddress());
        r103.append(':');
        r103.append(r102.getMulticastPort());
        r103.append(r105);
    L9:
        Logger.d(r105, " start:" + r103);
        PthreadThreadV2 r106 = new PthreadThreadV2(r102, r103.toString());
        r102.f456414c = r106;
        ThreadMethodProxy.start(r106);
        r101 = r101 + 1;
        goto L3
    }

    public void stop() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        d r102 = getSSDPNotifySocket(r101);
        r102.getClass();
        Logger.d(d.f456411d, " stop");
        r102.f456414c = null;
        r101 = r101 + 1;
        goto L3
    }

    public d getSSDPNotifySocket(int r100) {
        return (d) get(r100);
    }

    public boolean open(boolean r100) {
        InetAddress[] r101 = this.binds;
        int r102 = 0;
        if (r101 == null) goto L8;
        String[] r103 = new String[r101.length];
        int r104 = 0;
    L6:
        if (r104 >= r101.length) goto L13;
        r103[r104] = r101[r104].getHostAddress();
        r104 = r104 + 1;
    L13:
        if (r103.length != 0) goto L16;
        return false;
    L16:
        if (r102 >= r103.length) goto L21;
        if (r103[r102] == null) goto L20;
        d r105 = new d(this.mCastContext, r100);
        r105.open(r103[r102]);
        add(r105);
    L20:
        r102 = r102 + 1;
        goto L16
    L21:
        return true;
    L8:
        ArrayList<String> r106 = HostInterface.getHostAddresses();
        r103 = new String[r106.size()];
        int r107 = 0;
    L10:
        if (r107 >= r106.size()) goto L13;
        r103[r107] = (String) ListProtector.get(r106, r107);
        r107 = r107 + 1;
        goto L10
    }

    public void setControlPoint(CastControlPoint r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getSSDPNotifySocket(r102).f456412a = r100;
        r102 = r102 + 1;
        goto L3
    }

    public CastSSDPNotifySocketList(ContextManager.CastContext r100, InetAddress[] r101) {
        this.mCastContext = r100;
        this.binds = r101;
    }
}
