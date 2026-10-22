package com.larus.disk.impl;

import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.settings.value.e10;
import com.larus.settings.value.x0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f330625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f330626b = null;

    public d() {
    }

    static {
        f330625a = LazyKt.lazy(new b());
        f330626b = new Object();
    }

    public static lu9.a a() {
        e10 r100 = e10.f368561a;
        return e10.u();
    }

    public static lu9.f b() {
        e10 r100 = e10.f368561a;
        return (lu9.f) com.larus.utils.l0.a(new lu9.f(0), new x0());
    }

    public static String c() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L15;
        q38.a r101 = r100.getAccountInfo();
        if (r101 == null) goto L16;
        String r102 = r101.f531530c;
        if (r102 != null) goto L9;
        return null;
    L9:
        if ((!StringsKt.isBlank(r102)) == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L18;
        byte[] r103 = MessageDigest.getInstance("SHA-256").digest(r102.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r103);
        return CollectionsKt.joinToString$default(ArraysKt.take(r103, 8), "", null, null, 0, null, new c(), 30, null);
    L18:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    public static Keva d() {
        return (Keva) f330625a.getValue();
    }

    public static long e(String r100) {
        String r101 = c();
        if (r101 != null) goto L6;
        return Long.MAX_VALUE;
    L6:
        String r102 = r100 + '_' + r101;
        if (d().contains(r102) == true) goto L14;
        String r103 = r100.concat("_scoped_migrated");
        if (d().getBoolean(r103, false) == false) goto L11;
        long r104 = 0;
    L12:
        d().storeLong(r102, r104);
        goto L14
    L11:
        r104 = d().getLong(r100, 0);
        d().storeBoolean(r103, true);
    L14:
        return d().getLong(r102, 0);
    }

    public static long f(boolean r100) {
        long r101 = System.currentTimeMillis();
        if (r100 == false) goto L5;
        int r102 = a().z();
    L7:
        return r101 - (((long) RangesKt.coerceIn(r102, 1, 3650)) * 86400000);
    L5:
        r102 = a().D();
        goto L7
    }

    public static boolean g(float r100) {
        float r101 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        if (r101 > 0.0f) goto L6;
        return false;
    L6:
        if (r101 < 1.0f) goto L8;
        return true;
    L8:
        int r102 = (int) (r101 * 10000);
        int r103 = d().getInt("disk_scan_sample_bucket", -1);
        if (r103 < 0) goto L12;
        if (r103 >= 10000) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L28;
        Object r105 = f330626b;
        monitor-enter(r105);
        int r106 = d().getInt("disk_scan_sample_bucket", -1);     // Catch: Throwable -> L31
        if (r106 < 0) goto L21;
        if (r106 >= 10000) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L25;
        monitor-exit(r105);
        r103 = r106;
        goto L28
    L25:
        int r108 = Random.Default.nextInt(10000);     // Catch: Throwable -> L31
        d().storeInt("disk_scan_sample_bucket", r108);     // Catch: Throwable -> L31
        monitor-exit(r105);
        r103 = r108;
    L21:
        r107 = false;
    L31:
        th = move-exception;
        throw th;
    L28:
        if (r103 >= r102) goto L36;
        return true;
    L36:
        return false;
    L12:
        r104 = false;
        goto L13
    }
}
