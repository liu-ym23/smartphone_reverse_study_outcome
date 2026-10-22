package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final Lazy a;
    public final com.bytedance.android.ecom.arch.slice.g b;
    public final SlcTemplateViewHelper c;
    public final l d;
    public final View e;

    public final void a() {
        l r0 = this.d;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        ((Map) this.a.getValue()).clear();
    }

    public g(String r3, com.bytedance.android.ecom.arch.slice.g r4, SlcTemplateViewHelper r5, l r6, View r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r6 = null;
    L9:
        if ((r8 & 16) == 0) goto L11;
        r7 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "sliceType");
        Intrinsics.checkNotNullParameter(r4, "slice");
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.a = LazyKt.lazy(OptCacheItem$subViewCache$2.INSTANCE);
    }
}
