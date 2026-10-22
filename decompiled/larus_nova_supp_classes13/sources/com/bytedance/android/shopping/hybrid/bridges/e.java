package com.bytedance.android.shopping.hybrid.bridges;

import cg3.i;
import cg3.k;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T1, T2, R> implements BiFunction {
    public final /* synthetic */ ECOpenVideoPreviewPanelMethod a;
    public final /* synthetic */ cg3.g b;

    public e(ECOpenVideoPreviewPanelMethod r1, cg3.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r9, Object r10) {
        i r11 = (i) r9;
        final cg3.c r12 = (cg3.c) r10;
        Intrinsics.checkNotNullParameter(r11, "videoResponse");
        Intrinsics.checkNotNullParameter(r12, "commentPublishModel");
        cg3.e r2 = r12.a;
        List<cg3.f> r1 = this.b.d;
        if (r1 == null) goto L5;
        cg3.f r3 = (cg3.f) CollectionsKt.firstOrNull(r1);
    L7:
        return new k(r2, r3, null, null, r11.a, new ECOpenVideoPreviewPanelMethod$publishVideoBySilent$disposable$1$1(this, r12));
    L5:
        r3 = null;
        goto L7
    }
}
