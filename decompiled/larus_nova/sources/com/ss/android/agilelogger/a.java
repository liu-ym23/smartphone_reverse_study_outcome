package com.ss.android.agilelogger;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f406448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f406449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f406450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f406451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ALog.p f406452e;

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = ALog.access$400(3);     // Catch: Throwable -> L5
        this.f406452e.f406424a.o(r100, this.f406448a, this.f406449b, this.f406450c, this.f406451d);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }

    public a(ALog.p r100, String r101, String r102, long r103, long r104) {
        this.f406452e = r100;
        this.f406448a = r101;
        this.f406449b = r102;
        this.f406450c = r103;
        this.f406451d = r104;
    }
}
