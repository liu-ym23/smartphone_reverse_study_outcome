package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.ssdp.SSDP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes40.dex */
public class CastSSDPSearchResponseSocketList extends Vector {
    private static final String TAG = null;
    private InetAddress[] binds;
    private ContextManager.CastContext mCastContext;

    static {
        TAG = "CastSSDPSearchResponseSocketList";
    }

    public boolean open() {
        return open(1900);
    }

    public void close() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPSearchResponseSocket(r101).close();
        r101 = r101 + 1;
        goto L3
    L5:
        clear();
    }

    public void start() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPSearchResponseSocket(r101).start();
        r101 = r101 + 1;
        goto L3
    }

    public void stop() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        getSSDPSearchResponseSocket(r101).stop();
        r101 = r101 + 1;
        goto L3
    }

    public CastSSDPSearchResponseSocket getSSDPSearchResponseSocket(int r100) {
        return (CastSSDPSearchResponseSocket) get(r100);
    }

    public boolean open(int r100) {
        InetAddress[] r101 = this.binds;
        if (r101 == null) goto L8;
        String[] r102 = new String[r101.length];
        int r103 = 0;
    L6:
        if (r103 >= r101.length) goto L13;
        r102[r103] = r101[r103].getHostAddress();
        r103 = r103 + 1;
    L13:
        if (r102.length != 0) goto L15;
        return false;
    L15:
        int r104 = 0;
    L24:
    L22:
        stop();
        close();
        clear();
        return false;
    L17:
        if (r104 >= r102.length) goto L20;
        CastSSDPSearchResponseSocket r105 = new CastSSDPSearchResponseSocket(this.mCastContext);     // Catch: Exception -> L22
        r105.open(r102[r104], r100);     // Catch: Exception -> L22
        add(r105);     // Catch: Exception -> L22
        r104 = r104 + 1;
        goto L24
    L20:
        return true;
    L8:
        ArrayList<String> r106 = HostInterface.getHostAddresses();
        int r107 = r106.size();
        String[] r108 = new String[r107];
        int r109 = 0;
    L9:
        if (r109 >= r107) goto L11;
        r108[r109] = (String) ListProtector.get(r106, r109);
        r109 = r109 + 1;
        goto L9
    L11:
        r102 = r108;
        goto L13
    }

    public void setControlPoint(CastControlPoint r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getSSDPSearchResponseSocket(r102).setControlPoint(r100);
        r102 = r102 + 1;
        goto L3
    }

    public CastSSDPSearchResponseSocketList(ContextManager.CastContext r100, InetAddress[] r101) {
        this.mCastContext = r100;
        this.binds = r101;
    }

    public boolean post(g r110, boolean r111) {
        int r100 = size();
        boolean r101 = true;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L22;
        if (r102 >= size()) goto L21;
        CastSSDPSearchResponseSocket r103 = getSSDPSearchResponseSocket(r102);
        String r104 = r103.getLocalAddress();
        r110.getClass();
        if (HostInterface.isIPv6Address(r104) == false) goto L10;
        String r105 = SSDP.getIPv6Address();
    L11:
        r110.setHost(r105, 1900);
        if (HostInterface.isIPv6Address(r104) == true) goto L21;
        if (r103.post(SSDP.BDLINK_ADDRESS, 1900, r110) == true) goto L17;
        r101 = false;
    L17:
        if (r111 == false) goto L21;
        if (r103.post(SSDP.BROADCAST_ADDRESS, 1900, r110) == true) goto L21;
        r101 = false;
        goto L21
    L10:
        r105 = SSDP.BDLINK_ADDRESS;
    L21:
        r102 = r102 + 1;
        goto L3
    L22:
        return r101;
    }
}
