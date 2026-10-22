package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import android.widget.HorizontalScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HorizontalScrollView f264163a;

    public n(HorizontalScrollView r100) {
        this.f264163a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HorizontalScrollView r100 = this.f264163a;     // Catch: Throwable -> L4
        r100.scrollTo(r100.getRight(), 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
