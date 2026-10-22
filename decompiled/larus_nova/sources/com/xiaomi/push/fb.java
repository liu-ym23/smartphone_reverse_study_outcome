package com.xiaomi.push;

import com.ss.ttm.player.MediaPlayer;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes41.dex */
public class fb {
    public static int a(Throwable r100) {
        boolean r101 = r100 instanceof fh;
        if (r101 == false) goto L7;
        fh r102 = (fh) r100;
        if (r102.a() == null) goto L7;
        r100 = r102.a();
    L7:
        String r103 = r100.getMessage();
        if (r100.getCause() == null) goto L11;
        r103 = r100.getCause().getMessage();
    L11:
        if ((r100 instanceof SocketTimeoutException) == false) goto L14;
        return 105;
    L14:
        if ((r100 instanceof SocketException) == false) goto L49;
        if (r103.indexOf("Network is unreachable") == (-1)) goto L20;
        return 102;
    L20:
        if (r103.indexOf("Connection refused") == (-1)) goto L24;
        return 103;
    L24:
        if (r103.indexOf("Connection timed out") == (-1)) goto L27;
        return 105;
    L27:
        if (r103.endsWith("EACCES (Permission denied)") == false) goto L31;
        return 101;
    L31:
        if (r103.indexOf("Connection reset by peer") == (-1)) goto L35;
        return 109;
    L35:
        if (r103.indexOf("Broken pipe") == (-1)) goto L39;
        return 110;
    L39:
        if (r103.indexOf("No route to host") == (-1)) goto L43;
        return 104;
    L43:
        if (r103.endsWith("EINVAL (Invalid argument)") == false) goto L46;
        return 106;
    L46:
        return 199;
    L49:
        if ((r100 instanceof UnknownHostException) == false) goto L52;
        return 107;
    L52:
        if (r101 == false) goto L55;
        return MediaPlayer.MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN;
    L55:
        return 0;
    }
}
