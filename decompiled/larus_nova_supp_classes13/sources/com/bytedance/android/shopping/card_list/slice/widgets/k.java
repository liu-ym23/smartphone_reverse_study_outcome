package com.bytedance.android.shopping.card_list.slice.widgets;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements Runnable {
    public final /* synthetic */ j a;

    public k(j r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this.a);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        SlcCommonAction r2 = new SlcCommonAction("cartProgressAnimationHide", MapsKt.emptyMap());     // Catch: Throwable -> L6
        j r3 = this.a;     // Catch: Throwable -> L6
        r0.getTemplateContext().d(r2, r3, r0.l(), null, null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
