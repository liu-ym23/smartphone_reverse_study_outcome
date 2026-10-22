package com.bytedance.ee.bear.drive.core.fragment;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f224255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f224256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f224257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f224258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f224259e;

    public p(View r100, k r101, Object r102, long r103, Runnable r104) {
        this.f224255a = r100;
        this.f224256b = r101;
        this.f224257c = r102;
        this.f224258d = r103;
        this.f224259e = r104;
    }

    public final void a() {
        k r100 = this.f224256b;
        if (r100.f224232n == false) goto L5;
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout skipped: released before action");
        return;
    L5:
        Long r101 = r100.f224237s.get(this.f224257c);
        long r102 = this.f224258d;
        if (r101 != null) goto L9;
    L10:
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout skipped: stale action");
        return;
    L9:
        if (r101.longValue() != r102) goto L10;
        this.f224256b.f224237s.remove(this.f224257c);
        this.f224259e.run();
        tt5.a.h("DriveSdk", "suppressAiBottomContainerUntilNextLayout success: deferred");
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
