package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes19.dex */
public class Ipv6ConnectionManager {
    private static final String TAG = null;
    private static String mIPv6ProbeAddress;
    private static AtomicBoolean mIsIpv6GloballyReachable;

    public Ipv6ConnectionManager() {
    }

    private static boolean isGloballyIpv6Reachable() {
        boolean r100 = false;
        DatagramSocket r101 = null;
        DatagramSocket r102 = new DatagramSocket();     // Catch: Throwable -> L14 IOException -> L18
        r102.connect(new InetSocketAddress(mIPv6ProbeAddress, 53));     // Catch: Throwable -> L11 IOException -> L13
        InetAddress r103 = r102.getLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if ((r103 instanceof Inet6Address) == false) goto L10;
        boolean r104 = !r103.isLinkLocalAddress();     // Catch: Throwable -> L11 IOException -> L13
        if (r103.getHostAddress().startsWith("2001:0000") == true) goto L10;
        r100 = r104;
        goto L10
    L10:
        r102.close();
    L21:
        return r100;
    L13:
        r101 = r102;
    L11:
        th = th;
        r101 = r102;
    L15:
        if (r101 == null) goto L17;
        r101.close();
    L17:
        throw th;
    L14:
        th = th;
    L19:
        if (r101 == null) goto L21;
        r101.close();
        goto L21
    }

    static {
        TAG = "Ipv6ConnectionManager";
        mIPv6ProbeAddress = "2001:4860:4860::8888";
        mIsIpv6GloballyReachable = new AtomicBoolean(false);
    }

    public static void detectIpv6Reachable() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "detectIpv6Reachable");
    L5:
        mIsIpv6GloballyReachable.set(isGloballyIpv6Reachable());
    }

    public static AtomicBoolean getIpv6GloballyReachable() {
        return mIsIpv6GloballyReachable;
    }
}
