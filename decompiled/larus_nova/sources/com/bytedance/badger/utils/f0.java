package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f199244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f199245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f199246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f199247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f199248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Long f199249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f199250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function3 f199251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f199252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f199253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ r f199254k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f199255l;

    public f0(AtomicReference r100, t r101, b r102, AtomicInteger r103, AtomicReference r104, Long r105, long r106, Function3 r107, AtomicBoolean r110, CountDownLatch r111, r r112, AtomicReference r113) {
        this.f199244a = r100;
        this.f199245b = r101;
        this.f199246c = r102;
        this.f199247d = r103;
        this.f199248e = r104;
        this.f199249f = r105;
        this.f199250g = r106;
        this.f199251h = r107;
        this.f199252i = r110;
        this.f199253j = r111;
        this.f199254k = r112;
        this.f199255l = r113;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        com.bytedance.badger.e.f("vivo#", "isolatedConnection# onServiceConnected " + ThreadMethodProxy.currentThread().getName());
        IBinder r102 = (IBinder) this.f199244a.get();
        if (r102 != null) goto L6;
        this.f199245b.a(this.f199246c, this, new IllegalStateException("account binder is null"));
        return;
    L6:
        f.a(f.f199243d).post(new c0(this, r101, r102, new e0(this, this), this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        this.f199245b.a(this.f199246c, this, new IllegalStateException("isolated service disconnected"));
    }
}
