package com.larus.network.ttnet;

import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import hm9.s;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f360237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f360238b;

    static {
        f360237a = new h();
    }

    public h() {
    }

    public static boolean a() {
        if (f360238b == false) goto L6;
        return true;
    L6:
        if (hm9.j.f485964f == true) goto L13;
        return false;
    L13:
        s r100 = hm9.j.f485966h;     // Catch: Exception -> L10
        String r101 = new JSONArray(r100.f485985o).toString();     // Catch: Exception -> L10
        String r102 = new JSONArray(r100.f485986p).toString();     // Catch: Exception -> L10
        TTNetProtocolUtil.sendTTNetProtocolRequest("background-clear-pool", "/set", null, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("x-ttnet-bgcp-hosts", r101), TuplesKt.to("x-ttnet-bgcp-paths", r102)}));     // Catch: Exception -> L10
        f360238b = true;     // Catch: Exception -> L10
        FLogger.f375446a.i("TTNetConnectionPool", "configure allowlist, hosts=" + r101 + ", paths=" + r102);     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        FLogger.f375446a.e("TTNetConnectionPool", "configure allowlist failed", e);
        return false;
    }

    public final synchronized void b(boolean r100) {
        monitor-enter(this);
        boolean r101 = a();     // Catch: Throwable -> L12 Exception -> L14
        if (r100 == false) goto L10;
        if (r101 == true) goto L10;
        FLogger.f375446a.i("TTNetConnectionPool", "skip connection pool control, allowlist not configured");     // Catch: Throwable -> L12 Exception -> L14
        monitor-exit(this);
        return;
    L10:
        TTNetInit.runInBackGround(AppHost.f326268a.getApplication(), r100);     // Catch: Throwable -> L12 Exception -> L14
        FLogger.f375446a.i("TTNetConnectionPool", "update connection pool: controlled=" + r100);     // Catch: Throwable -> L12 Exception -> L14
    L16:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        FLogger.f375446a.e("TTNetConnectionPool", "update connection pool failed: controlled=" + r100, e);     // Catch: Throwable -> L12
        goto L16
    }
}
