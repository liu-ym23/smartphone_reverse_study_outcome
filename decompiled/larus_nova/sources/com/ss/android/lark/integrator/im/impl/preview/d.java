package com.ss.android.lark.integrator.im.impl.preview;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeUrlPreviewSessionImpl f428013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f428014b;

    public d(OfficeUrlPreviewSessionImpl r100, List<String> r101) {
        this.f428013a = r100;
        this.f428014b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f428013a.f427990h.get() == true) goto L11;
        sza.d r100 = this.f428013a.f427986d;     // Catch: Throwable -> L8
        if (r100 == null) goto L15;
        r100.a(this.f428014b);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }
}
