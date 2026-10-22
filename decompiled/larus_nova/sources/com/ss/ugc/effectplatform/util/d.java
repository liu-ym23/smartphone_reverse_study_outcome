package com.ss.ugc.effectplatform.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f458025a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f458026a;

        public a() {
        }
    }

    static {
        f458025a = new ConcurrentHashMap();
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static int b(byte[] r100, int r101) {
    L3:
        if (r101 >= r100.length) goto L17;
        byte r102 = r100[r101];
        if (r102 == 10) goto L24;
        if (Character.isDigit(r102) == true) goto L8;
        r101 = r101 + 1;
        goto L3
    L8:
        int r103 = r101 + 1;
    L10:
        if (r103 >= r100.length) goto L15;
        if (Character.isDigit(r100[r103]) == false) goto L15;
        r103 = r103 + 1;
    L15:
        return CastIntegerProtector.parseInt(new String(r100, 0, r101, r103 - r101));
    L24:
        return -1;
    L17:
        return -1;
    }

    public static int c(String r100, PolarisFileInputStreamWrapper r101) {
        byte[] r102 = new byte[1024];
        int r103 = r101.read(r102);     // Catch: Throwable -> L22
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L21;
        byte r105 = r102[r104];     // Catch: Throwable -> L22
        if (r105 == 10) goto L8;
        if (r104 == 0) goto L8;
    L20:
        r104 = r104 + 1;
    L8:
        if (r105 != 10) goto L10;
        r104 = r104 + 1;     // Catch: Throwable -> L22
    L10:
        int r106 = r104;
    L11:
        if (r106 >= r103) goto L20;
        int r107 = r106 - r104;     // Catch: Throwable -> L22
        if (r102[r106] != r100.charAt(r107)) goto L20;
        if (r107 == (r100.length() - 1)) goto L17;
        r106 = r106 + 1;
        goto L11
    L17:
        return b(r102, r106);
    L21:
        return -1;
    }
}
