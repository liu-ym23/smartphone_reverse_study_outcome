package com.ss.android.ugc.route_monitor.impl.route_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f454532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f454533b;

    public k(i r100, Activity r101) {
        this.f454532a = r100;
        this.f454533b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r100 = this.f454532a;     // Catch: Throwable -> L11
        Activity r101 = this.f454533b;     // Catch: Throwable -> L11
        r100.getClass();     // Catch: Throwable -> L11
        Objects.toString(r101);     // Catch: Throwable -> L11
        if (r101 == null) goto L14;
        r100.f454523e.remove(Integer.valueOf(r101.hashCode()));     // Catch: Throwable -> L11
        Handler r102 = com.ss.android.ugc.route_monitor.utils.r.f454781a;     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L18;
        Intent r103 = r101.getIntent();     // Catch: Throwable -> L11
        if (r103 == null) goto L19;
        r103.removeExtra("___route_in_monitor_session___");     // Catch: Throwable -> L11
        return;
    L19:
        return;
    L18:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
