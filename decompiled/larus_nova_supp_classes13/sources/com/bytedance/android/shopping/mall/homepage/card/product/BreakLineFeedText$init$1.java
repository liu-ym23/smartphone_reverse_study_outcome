package com.bytedance.android.shopping.mall.homepage.card.product;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BreakLineFeedText$init$1 extends MutablePropertyReference0Impl {
    public BreakLineFeedText$init$1(BreakLineFeedText r7) {
        super(r7, BreakLineFeedText.class, "fullText", "getFullText()Ljava/lang/CharSequence;", 0);
    }

    public Object get() {
        CharSequence r0 = ((BreakLineFeedText) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fullText");
    L5:
        return r0;
    }

    public void set(Object r2) {
        CharSequence r3 = (CharSequence) r2;
        ((BreakLineFeedText) ((CallableReference) this).receiver).a = r3;
    }
}
