package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f199216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f199217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f199218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f199219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f199220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f199221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f199222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f199223h;

    public b(AtomicBoolean r100, AtomicReference r101, Object r102, Ref.BooleanRef r103, Context r104, Ref.ObjectRef r105, t r106, Ref.BooleanRef r107) {
        this.f199216a = r100;
        this.f199217b = r101;
        this.f199218c = r102;
        this.f199219d = r103;
        this.f199220e = r104;
        this.f199221f = r105;
        this.f199222g = r106;
        this.f199223h = r107;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        com.bytedance.badger.e.f("vivo#", "accountConnection# onServiceConnected " + ThreadMethodProxy.currentThread().getName());
        f.a(f.f199243d).post(new g0(this, r101, this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        t r101 = this.f199222g;
        T r102 = this.f199221f.element;
        if (r102 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("isolatedConnection");
    L5:
        r101.a(this, (ServiceConnection) r102, new IllegalStateException("account service disconnected"));
    }
}
