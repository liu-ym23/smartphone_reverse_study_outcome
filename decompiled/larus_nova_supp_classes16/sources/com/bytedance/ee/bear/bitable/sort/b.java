package com.bytedance.ee.bear.bitable.sort;

import androidx.core.widget.NestedScrollView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ BitableSortPanelFragment a;

    public b(BitableSortPanelFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NestedScrollView r0 = this.a.e;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");     // Catch: Throwable -> L7
        r0 = null;
    L5:
        r0.fullScroll(130);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
