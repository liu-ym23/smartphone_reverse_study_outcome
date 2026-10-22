package com.bytedance.ee.bear.banner;

import android.view.ViewGroup;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f206454a;

    public b(a r100) {
        this.f206454a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CCMLynxCardView r100 = this.f206454a.f206449g;     // Catch: Throwable -> L11
        if (r100 == null) goto L5;
        r100.destroy();     // Catch: Throwable -> L11
    L5:
        a r101 = this.f206454a;     // Catch: Throwable -> L11
        ViewGroup r102 = null;
        r101.f206449g = null;     // Catch: Throwable -> L11
        WeakReference<ViewGroup> r103 = r101.f206444b;     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        r102 = r103.get();     // Catch: Throwable -> L11
    L8:
        if (r102 == null) goto L14;
        r102.removeAllViews();     // Catch: Throwable -> L11
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
