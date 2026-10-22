package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.gi;
import com.xiaomi.push.ho;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f464294a = null;

    static {
        f464294a = new Object();
    }

    public static byte[] a(Context r100) {
        String r101 = com.xiaomi.push.n.a(r100).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = com.xiaomi.push.ba.a(20);
        com.xiaomi.push.n.a(r100).m9303a("mipush", "td_key", r101);
    L6:
        return a(r101);
    }

    private static byte[] a(String r100) {
        byte[] r101 = Arrays.copyOf(com.xiaomi.push.ax.m8829a(r100), 16);
        r101[0] = 68;
        r101[15] = 84;
        return r101;
    }

    public static void a(final Context r100, final gi r101) {
        if (az.a(r101.e()) == true) goto L5;
        return;
    L5:
        com.xiaomi.push.ad.a(r100).a(new AnonymousClass1(r100, r101));
    }

    public static /* synthetic */ void b(Context r100, gi r101) {
        c(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    private static void c(Context r110, gi r111) {
        ?? r100 = "TinyData write to cache file failed case too much data content item:";
        byte[] r101 = com.xiaomi.push.h.b(a(r110), ho.a(r111));     // Catch: Throwable -> L25 Exception -> L27 IOException -> L30
        if (r101 != null) goto L7;
    L23:
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData write to cache file failed case encryption fail item:" + r111.d() + "  ts:" + System.currentTimeMillis());     // Catch: Throwable -> L25 Exception -> L27 IOException -> L30
    L12:
        com.xiaomi.push.v.a(null);
        com.xiaomi.push.v.a(null);
        return;
    L7:
        if (r101.length < 1) goto L23;
        if (r101.length <= 30720) goto L14;
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData write to cache file failed case too much data content item:" + r111.d() + "  ts:" + System.currentTimeMillis());     // Catch: Throwable -> L25 Exception -> L27 IOException -> L30
        goto L12
    L14:
        BufferedOutputStream r112 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r110.getFilesDir(), "tiny_data.data"), true));     // Catch: Throwable -> L25 Exception -> L27 IOException -> L30
        r112.write(com.xiaomi.push.x.a(r101.length));     // Catch: Throwable -> L17 Exception -> L19 IOException -> L21
        r112.write(r101);     // Catch: Throwable -> L17 Exception -> L19 IOException -> L21
        r112.flush();     // Catch: Throwable -> L17 Exception -> L19 IOException -> L21
        com.xiaomi.push.v.a(null);
        com.xiaomi.push.v.a(r112);
        return;
    L21:
        e = move-exception;
        BufferedOutputStream r102 = r112;
        e = e;
    L32:
        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file failed cause io exception item:" + r111.d(), e);     // Catch: Throwable -> L35
        r100 = r102;
    L33:
        com.xiaomi.push.v.a(null);
        com.xiaomi.push.v.a(r100);
        return;
    L19:
        e = move-exception;
        BufferedOutputStream r103 = r112;
        e = e;
    L29:
        com.xiaomi.channel.commonutils.logger.b.a("TinyData write to cache file  failed item:" + r111.d(), e);     // Catch: Throwable -> L35
        r100 = r103;
    L17:
        th = move-exception;
        r100 = r112;
        th = th;
    L36:
        com.xiaomi.push.v.a(null);
        com.xiaomi.push.v.a(r100);
        throw th;
    L35:
        th = th;
    L30:
        e = e;
        r102 = null;
    L27:
        e = e;
        r103 = null;
    L25:
        th = th;
        r100 = 0;
        goto L36
    }
}
