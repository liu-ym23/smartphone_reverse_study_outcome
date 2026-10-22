package com.lynx.tasm.ui.image;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f384068a;

    @Override // java.lang.Runnable
    public final void run() {
        y r100 = this.f384068a;     // Catch: Throwable -> L16
        q r101 = r100.f384072d;     // Catch: Throwable -> L16
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L19;
        r101.f384035c = false;     // Catch: Throwable -> L16
        a r103 = r101.f384033a;     // Catch: Throwable -> L16
        if (r103.f383859a.add(r101) == true) goto L13;
        return;
    L13:
        if (r103.f383859a.size() != 1) goto L24;
        UIThreadUtils.runOnUiThread(r103.f383860b);     // Catch: Throwable -> L16
        return;
    L24:
        return;
    L19:
        return;
    L5:
        if (r101.f384044l != r100.f384071c) goto L7;
        r102 = true;
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L25;
        throw th;
    }

    public x(y r100) {
        this.f384068a = r100;
    }
}
