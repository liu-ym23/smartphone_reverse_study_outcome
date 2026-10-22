package com.larus.network.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static int a(Throwable r110, String[] r111) {
        int r100 = 1;
        if (r110 != null) goto L6;
        return 1;
    L6:
        if ((r110 instanceof HttpResponseException) == false) goto L9;
        r100 = ((HttpResponseException) r110).getStatusCode();
    L143:
        if (r100 != 2) goto L70;
        String r112 = r110.getMessage();     // Catch: Exception -> L142
        if (Logger.debug() == false) goto L59;
        Logger.d("ConvertIOException", "SC_CONNECT_TIMEOUT " + r112);     // Catch: Exception -> L142
    L59:
        Matcher r113 = PatternProtector.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r112);     // Catch: Exception -> L142
        if (r113.matches() == false) goto L68;
        if (r113.group(3) == null) goto L65;
        r111[0] = r113.group(3);     // Catch: Exception -> L142
        goto L68
    L65:
        if (r113.group(4) == null) goto L68;
        r111[0] = r113.group(4);     // Catch: Exception -> L142
    L68:
        if (Logger.debug() == false) goto L144;
        Logger.d("ConvertIOException", "SC_CONNECT_TIMEOUT ip " + r111[0]);     // Catch: Exception -> L142
        return r100;
    L144:
        return r100;
    L70:
        if (r100 != 8) goto L110;
        Throwable r114 = r110.getCause();     // Catch: Exception -> L142
        if (r114 != null) goto L74;
        return r100;
    L74:
        if ((r114 instanceof ConnectException) == false) goto L147;
        String r115 = r114.getMessage();     // Catch: Exception -> L142
        if (Logger.debug() == false) goto L78;
        Logger.d("ConvertIOException", "SC_CONNECT_EXCEPTION " + r115);     // Catch: Exception -> L142
    L78:
        Matcher r116 = PatternProtector.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r115);     // Catch: Exception -> L142
        if (r116.matches() == true) goto L81;
        String r117 = null;
    L108:
        if (Logger.debug() == false) goto L148;
        Logger.d("ConvertIOException", "SC_CONNECT_EXCEPTION ip " + r111[0] + " " + r117);     // Catch: Exception -> L142
        return r100;
    L148:
        return r100;
    L81:
        if (r116.group(3) == null) goto L84;
        r111[0] = r116.group(3);     // Catch: Exception -> L142
    L86:
        r117 = r116.group(7);     // Catch: Exception -> L142
        if (r117 == null) goto L108;
        if ("ECONNRESET".equals(r117) == false) goto L92;
        r100 = 12;
        goto L108
    L92:
        if ("ECONNREFUSED".equals(r117) == false) goto L95;
        r100 = 13;
        goto L108
    L95:
        if ("EHOSTUNREACH".equals(r117) == false) goto L98;
        r100 = 14;
        goto L108
    L98:
        if ("ENETUNREACH".equals(r117) == false) goto L101;
        r100 = 15;
        goto L108
    L101:
        if ("EADDRNOTAVAIL".equals(r117) == false) goto L104;
        r100 = 16;
        goto L108
    L104:
        if ("EADDRINUSE".equals(r117) == false) goto L108;
        r100 = 17;
        goto L108
    L84:
        if (r116.group(4) == null) goto L86;
        r111[0] = r116.group(4);     // Catch: Exception -> L142
        goto L86
    L147:
        return r100;
    L110:
        if (r100 != 4) goto L150;
        String r118 = r110.getMessage();     // Catch: Exception -> L142
        if (r118.indexOf(" EIO (I/O error)") <= 0) goto L115;
        return 37;
    L115:
        if ((r110 instanceof FileNotFoundException) == false) goto L118;
    L140:
        return 33;
    L118:
        if (r118.indexOf(" ENOENT ") > 0) goto L140;
        if (r118.indexOf("No such file or directory") > 0) goto L140;
        if (r118.indexOf(" ENOSPC ") <= 0) goto L125;
    L139:
        return 32;
    L125:
        if (r118.indexOf("No space left on device") > 0) goto L139;
        if (r118.indexOf(" EDQUOT ") <= 0) goto L131;
        return 34;
    L131:
        if (r118.indexOf(" EROFS ") <= 0) goto L134;
        return 35;
    L134:
        if (r118.indexOf(" EACCES ") <= 0) goto L137;
        return 36;
    L137:
        if (r118.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L155;
        return 38;
    L155:
        return r100;
    L150:
        return r100;
    L158:
        return r100;
    L9:
        if ((r110 instanceof DownloadFileTooLargeException) == false) goto L12;
        r100 = 20;
        goto L143
    L12:
        if ((r110 instanceof ConnectTimeoutException) == false) goto L15;
    L20:
        r100 = 2;
        goto L143
    L15:
        if ((r110 instanceof SocketTimeoutException) == false) goto L23;
        if (StringUtils.isEmpty(r110.getMessage()) == false) goto L19;
    L21:
        r100 = 3;
        goto L143
    L19:
        if (r110.getMessage().contains("connect timed out") == false) goto L21;
    L23:
        if ((r110 instanceof BindException) == false) goto L26;
        r100 = 7;
        goto L143
    L26:
        if ((r110 instanceof ConnectException) == false) goto L29;
        r100 = 8;
        goto L143
    L29:
        if ((r110 instanceof NoRouteToHostException) == false) goto L32;
        r100 = 9;
        goto L143
    L32:
        if ((r110 instanceof PortUnreachableException) == false) goto L35;
        r100 = 10;
        goto L143
    L35:
        if ((r110 instanceof SocketException) == false) goto L43;
        String r101 = r110.getMessage();
        if (r101 != null) goto L39;
    L41:
        r100 = 5;
        goto L143
    L39:
        if (r101.indexOf("reset by peer") < 0) goto L41;
        r100 = 6;
        goto L143
    L43:
        if ((r110 instanceof UnknownHostException) == false) goto L46;
        r100 = 11;
        goto L143
    L46:
        if ((r110 instanceof NoHttpResponseException) == false) goto L49;
        r100 = 18;
        goto L143
    L49:
        if ((r110 instanceof ClientProtocolException) == false) goto L52;
        r100 = 19;
        goto L143
    L52:
        if ((r110 instanceof IOException) == false) goto L143;
        r100 = 4;
        goto L143
    }
}
