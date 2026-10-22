package com.bytedance.badger.utils;

import android.os.IBinder;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f199231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f199232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IBinder f199233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e0 f199234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f0 f199235e;

    public c0(f0 r100, IBinder r101, IBinder r102, e0 r103, f0 r104) {
        this.f199231a = r100;
        this.f199232b = r101;
        this.f199233c = r102;
        this.f199234d = r103;
        this.f199235e = r104;
    }

    public final void a() {
        com.bm.vivoid.c r100 = com.bm.vivoid.b.a(this.f199232b);
    L7:
        th = move-exception;
        f0 r101 = this.f199231a;
        r101.f199245b.a(r101.f199246c, this.f199235e, th);
        return;
    L4:
        if (r100.a(this.f199233c, this.f199234d) == true) goto L12;
        f0 r102 = this.f199231a;     // Catch: Throwable -> L7
        r102.f199245b.a(r102.f199246c, this.f199235e, new IllegalStateException("transfer returned false"));     // Catch: Throwable -> L7
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
