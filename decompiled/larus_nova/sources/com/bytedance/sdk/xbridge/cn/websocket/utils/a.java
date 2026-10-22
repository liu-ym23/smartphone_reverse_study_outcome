package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f270270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f270271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f270272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f270273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f270274e;

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.c
    public final void a() {
        monitor-enter(this);
        int r100 = this.f270273d;     // Catch: Throwable -> L9
        monitor-exit(this);
        if (r100 == (-1)) goto L14;
        i();
        e(-1);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public abstract void h();

    public abstract void i();

    public final void g() {
        Context r100 = this.f270270a;
        int r101 = j.f270290a;
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L12
        if (r102 == null) goto L18;
        NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r103 == null) goto L18;
        if (r103.isConnected() == false) goto L18;
        if (r103.getState() != NetworkInfo.State.CONNECTED) goto L18;
        boolean r104 = true;
    L19:
        if (r104 == true) goto L24;
        id7.c.a("net error, url = " + this.f270274e);
        Intrinsics.checkNotNullParameter("net error", "reason");
        k r105 = this.f270272c;
        if (r105 == null) goto L28;
        r105.onFailed("net error");
        return;
    L28:
        return;
    L24:
        h();
        return;
    L18:
        r104 = false;
    L12:
        e = move-exception;
        String r106 = e.getMessage();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        id7.c.a(r106);
        goto L18
    }

    public final Context getContext() {
        return this.f270270a;
    }

    public final void d(boolean r100) {
        k r101 = this.f270272c;
        if (r101 == null) goto L6;
        r101.onClosed(r100);
        return;
    }

    public final synchronized void e(int r100) {
        monitor-enter(this);
        this.f270273d = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void f(SocketManager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f270272c = r100;
    }

    public a(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestTask");
        this.f270270a = r100;
        this.f270271b = r101;
        this.f270273d = -1;
        this.f270274e = r101.f270282a;
    }
}
