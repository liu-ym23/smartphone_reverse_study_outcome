package com.bytedance.android.window.shop.widget;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements Runnable {
    public final /* synthetic */ LifecycleOwner a;
    public final /* synthetic */ r b;

    public q(LifecycleOwner r1, r r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = WindowPopupWindowManager.a;     // Catch: Throwable -> L7
        ConstraintLayout r1 = this.b.a.g;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlArea");     // Catch: Throwable -> L7
    L5:
        WindowPopupWindowManager.a(r1, ToolBarView.R5(this.b.a), this.a, WindowPopupWindowManager.PopupPosition.ABOVE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
