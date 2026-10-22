package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes38.dex */
public class ResolveTask {
    public static final int HTTP_DNS = 1;
    private static Pattern IP_PATTERN = null;
    private static final String IP_REGEX = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
    public static final int LOCAL_DNS = 0;
    public static final String PULL_DOMAIN = "pull";
    public static final String PUSH_DOMAIN = "push";
    private static final String TAG = "ResolveTask";
    protected final String host;
    public int mIpMode;

    public List<String> doLocalResolveTask() {
        InetAddress[] r100 = InetAddress.getAllByName(this.host);     // Catch: UnknownHostException -> L27
        ArrayList r101 = new ArrayList();     // Catch: UnknownHostException -> L27
        if (r100 != null) goto L6;
    L26:
        return r101;
    L6:
        if (r100.length <= 0) goto L26;
        int r102 = r100.length;     // Catch: UnknownHostException -> L27
        int r103 = 0;
        boolean r104 = false;
        boolean r105 = false;
    L9:
        if (r103 >= r102) goto L20;
        InetAddress r106 = r100[r103];     // Catch: UnknownHostException -> L27
        r101.add(r106.getHostAddress());     // Catch: UnknownHostException -> L27
        if (r104 == false) goto L13;
    L15:
        if (r105 == true) goto L19;
        if ((r106 instanceof Inet4Address) == false) goto L19;
        r105 = true;
    L19:
        r103 = r103 + 1;     // Catch: UnknownHostException -> L27
        goto L9
    L13:
        if ((r106 instanceof Inet6Address) == false) goto L15;
        r104 = true;
        goto L15
    L20:
        if (r104 == false) goto L23;
        if (r105 == true) goto L23;
        this.mIpMode = 1;     // Catch: UnknownHostException -> L27
    L23:
        if (r104 == true) goto L26;
        if (r105 == false) goto L26;
        this.mIpMode = 0;     // Catch: UnknownHostException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public ResolveTask(String r100) {
        this.mIpMode = 2;
        this.host = r100;
    }

    public static boolean isNumericAddress(String r100) {
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (IP_PATTERN != null) goto L7;
        IP_PATTERN = PatternProtector.compile(IP_REGEX);     // Catch: Exception -> L16
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return false;
    L9:
        if (r100.length() >= 7) goto L11;
        return false;
    L11:
        if (r100.length() > 15) goto L23;
        if (IP_PATTERN.matcher(r100).matches() == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    }
}
