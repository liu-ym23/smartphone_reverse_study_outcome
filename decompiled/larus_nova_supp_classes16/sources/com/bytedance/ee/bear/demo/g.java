package com.bytedance.ee.bear.demo;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public g(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.a.j;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coverView");     // Catch: Throwable -> L7
        r0 = null;
    L5:
        r0.setImageBitmap(null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
