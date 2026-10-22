package com.lynx.animax.player;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.lynx.animax.util.AnimaXLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f380352c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f380353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile MediaCodecInfo[] f380354b;

    public b() {
        this.f380353a = new ConcurrentHashMap();
    }

    public final boolean a(String r110, boolean r111) {
        boolean r100 = false;
        if (r110.isEmpty() == true) goto L52;
        StringBuilder r101 = new StringBuilder();
        r101.append(r110.toLowerCase());
        if (r111 == false) goto L8;
        String r102 = "_HW";
    L9:
        r101.append(r102);
        String r103 = r101.toString();
        if (((ConcurrentHashMap) this.f380353a).containsKey(r103) == false) goto L14;
        return ((Boolean) ((ConcurrentHashMap) this.f380353a).get(r103)).booleanValue();
    L14:
        if (r110.isEmpty() == false) goto L53;
    L51:
        ((ConcurrentHashMap) this.f380353a).put(r103, Boolean.valueOf(r100));
        goto L52
    L53:
    L49:
        e = move-exception;
        AnimaXLog.a("CodecDecodeCapability", "checkCodecSupport failed, mimeType: " + r110 + ", message: " + e.getMessage());
        goto L51
    L17:
        if (this.f380354b == null) goto L19;
        MediaCodecInfo[] r104 = this.f380354b;     // Catch: Exception -> L49
    L28:
        int r105 = r104.length;     // Catch: Exception -> L49
        int r106 = 0;
    L29:
        if (r106 >= r105) goto L51;
        MediaCodecInfo r107 = r104[r106];     // Catch: Exception -> L49
        if (r107.isEncoder() == true) goto L45;
        if (r111 == true) goto L35;
    L39:
        String[] r108 = r107.getSupportedTypes();     // Catch: Exception -> L49
        int r109 = r108.length;     // Catch: Exception -> L49
        int r112 = 0;
    L40:
        if (r112 >= r109) goto L45;
        if (r108[r112].equalsIgnoreCase(r110) == true) goto L43;
        r112 = r112 + 1;
        goto L40
    L43:
        r100 = true;
        goto L51
    L35:
        if (Build.VERSION.SDK_INT < 29) goto L39;
        if (r107.isHardwareAccelerated() == true) goto L39;
    L45:
        r106 = r106 + 1;
        goto L29
    L19:
        monitor-enter(this);     // Catch: Exception -> L49
    L46:
        th = move-exception;
        throw th;     // Catch: Exception -> L49
    L21:
        if (this.f380354b != null) goto L26;
        int r113 = MediaCodecList.getCodecCount();     // Catch: Throwable -> L46
        MediaCodecInfo[] r114 = new MediaCodecInfo[r113];     // Catch: Throwable -> L46
        int r115 = 0;
    L23:
        if (r115 >= r113) goto L25;
        r114[r115] = MediaCodecList.getCodecInfoAt(r115);     // Catch: Throwable -> L46
        r115 = r115 + 1;     // Catch: Throwable -> L46
        goto L23
    L25:
        this.f380354b = r114;     // Catch: Throwable -> L46
    L26:
        r104 = this.f380354b;     // Catch: Throwable -> L46
        monitor-exit(this);     // Catch: Throwable -> L46
    L8:
        r102 = "_SW";
    L52:
        return r100;
    }
}
