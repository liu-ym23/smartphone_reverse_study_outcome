package com.bytedance.locallife.live.lynx.syncjsb;

import android.os.Handler;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f260608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveLocalLifeLynxView f260609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f260610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f260611e;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f260611e == true) goto L9;
        this.f260609c.c(this.f260607a, null);     // Catch: Throwable -> L6
        this.f260610d.removeCallbacks(this);     // Catch: Throwable -> L6
        this.f260610d.postDelayed(this, this.f260608b);     // Catch: Throwable -> L6
        return;
    }

    public o(String r100, long r101, LiveLocalLifeLynxView r102, Handler r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, "handler");
        this.f260607a = r100;
        this.f260608b = r101;
        this.f260609c = r102;
        this.f260610d = r103;
    }
}
