package com.bytedance.android.shopping.deepfeed.slice;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.ecom.arch.slice.render.context.a {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void a(SlcTemplateContext r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        com.bytedance.android.ecom.arch.slice.render.context.a r0 = (com.bytedance.android.ecom.arch.slice.render.context.a) ((LinkedHashMap) this.a.c).get(r3);
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }
}
