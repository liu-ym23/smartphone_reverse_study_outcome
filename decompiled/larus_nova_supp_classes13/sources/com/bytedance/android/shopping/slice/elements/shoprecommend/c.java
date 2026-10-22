package com.bytedance.android.shopping.slice.elements.shoprecommend;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import fi3.c0;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this.a);     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        SlcTemplateContext r1 = r0.a;     // Catch: Throwable -> L8
        if (r1 == null) goto L15;
        int r2 = c0.e;     // Catch: Throwable -> L8
        SlcTemplateContext.e(r1, c0.a.a("shop_recommend_tabs", MapsKt.mapOf(TuplesKt.to("current_tab", Integer.valueOf(this.a.h))), null, 10), this.a, null, null, 24);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
