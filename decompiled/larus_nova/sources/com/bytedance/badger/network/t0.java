package com.bytedance.badger.network;

import com.bytedance.badger.e;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class t0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f199145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f199146b;

    public t0(String r100, Function0 r101) {
        this.f199145a = r100;
        this.f199146b = r101;
    }

    @Override // com.bytedance.badger.network.i0
    public final void a() {
        u0 r100 = u0.f199154h;     // Catch: Exception -> L8
        u0.f199152f.remove(this.f199145a);     // Catch: Exception -> L8
        r100.getClass();     // Catch: Exception -> L8
        Lazy r101 = u0.f199151e;     // Catch: Exception -> L8
        KProperty r102 = u0.f199147a[1];     // Catch: Exception -> L8
        ((j0) r101.getValue()).c(this);     // Catch: Exception -> L8
    L11:
        u0.f199154h.getClass();     // Catch: Exception -> L5
        Lazy r103 = u0.f199148b;     // Catch: Exception -> L5
        KProperty r104 = u0.f199147a[0];     // Catch: Exception -> L5
        ((ScheduledExecutorService) r103.getValue()).execute(new s0(this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.c("BadgerNetworkRetryHandler", "Failed to execute network-ready task: " + this.f199145a, e);
    }
}
