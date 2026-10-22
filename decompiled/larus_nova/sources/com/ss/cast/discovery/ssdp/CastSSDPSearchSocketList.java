package com.ss.cast.discovery.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Vector;

/* JADX INFO: loaded from: classes40.dex */
public class CastSSDPSearchSocketList extends Vector {
    private InetAddress[] binds;
    private ContextManager.CastContext mCastContext;
    private String multicastIPv4;
    private String multicastIPv6;
    private int port;

    public synchronized void close() {
        monitor-enter(this);
        int r100 = size();     // Catch: Throwable -> L9
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L6;
        getSSDPSearchSocket(r101).close();     // Catch: Throwable -> L9
        r101 = r101 + 1;     // Catch: Throwable -> L9
        goto L4
    L6:
        clear();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean open() {
        monitor-enter(this);
        InetAddress[] r100 = this.binds;     // Catch: Throwable -> L29
        int r101 = 0;
        if (r100 == null) goto L9;
        String[] r102 = new String[r100.length];     // Catch: Throwable -> L29
        int r103 = 0;
    L7:
        if (r103 >= r100.length) goto L14;
        r102[r103] = r100[r103].getHostAddress();     // Catch: Throwable -> L29
        r103 = r103 + 1;     // Catch: Throwable -> L29
    L14:
        if (r102.length != 0) goto L17;
        monitor-exit(this);
        return false;
    L17:
        if (r101 >= r102.length) goto L26;
        String r104 = r102[r101];     // Catch: Throwable -> L29
        if (r104 == null) goto L25;
        if (HostInterface.isIPv6Address(r104) == true) goto L25;
        add(new i(this.mCastContext, r102[r101], this.multicastIPv4));     // Catch: Throwable -> L29
    L25:
        r101 = r101 + 1;
        goto L17
    L26:
        monitor-exit(this);
        return true;
    L9:
        ArrayList<String> r105 = HostInterface.getHostAddresses();     // Catch: Throwable -> L29
        int r106 = r105.size();     // Catch: Throwable -> L29
        String[] r107 = new String[r106];     // Catch: Throwable -> L29
        int r108 = 0;
    L10:
        if (r108 >= r106) goto L12;
        r107[r108] = (String) ListProtector.get(r105, r108);     // Catch: Throwable -> L29
        r108 = r108 + 1;     // Catch: Throwable -> L29
        goto L10
    L12:
        r102 = r107;
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized void start() {
        monitor-enter(this);
        int r100 = size();     // Catch: Throwable -> L9
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L7;
        getSSDPSearchSocket(r101).start();     // Catch: Throwable -> L9
        r101 = r101 + 1;
        goto L4
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
        int r100 = size();     // Catch: Throwable -> L9
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L7;
        i r102 = getSSDPSearchSocket(r101);     // Catch: Throwable -> L9
        r102.getClass();     // Catch: Throwable -> L9
        Logger.d(i.f456415c, "stop");     // Catch: Throwable -> L9
        r102.close();     // Catch: Throwable -> L9
        r102.f456417b = null;     // Catch: Throwable -> L9
        r101 = r101 + 1;
        goto L4
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void addSearchListener(SearchListener r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getSSDPSearchSocket(r102).f456416a.add(r100);
        r102 = r102 + 1;
        goto L3
    }

    public i getSSDPSearchSocket(int r100) {
        return (i) get(r100);
    }

    public CastSSDPSearchSocketList(ContextManager.CastContext r100, InetAddress[] r101, int r102, String r103, String r104) {
        this.mCastContext = r100;
        this.binds = r101;
        this.port = r102;
        this.multicastIPv4 = r103;
        this.multicastIPv6 = r104;
    }
}
