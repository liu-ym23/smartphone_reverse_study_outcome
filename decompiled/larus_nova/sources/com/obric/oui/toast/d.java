package com.obric.oui.toast;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f403693a;

    public /* synthetic */ d(f r100) {
        this.f403693a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f403693a;
        Intrinsics.checkNotNullParameter(r100, "$toast");
        if (f.f403697p != r100) goto L5;
        f.f403697p = null;
        Handler r101 = f.f403695n;
        f.a.b();
        return;
    L5:
        f.f403696o.remove(r100);
    }
}
