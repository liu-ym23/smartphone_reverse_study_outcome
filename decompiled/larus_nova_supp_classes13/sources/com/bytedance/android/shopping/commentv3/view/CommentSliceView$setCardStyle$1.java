package com.bytedance.android.shopping.commentv3.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "p1", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommentSliceView$setCardStyle$1 extends FunctionReferenceImpl implements Function1<Integer, Integer> {
    public CommentSliceView$setCardStyle$1(CommentSliceView r8) {
        super(1, r8, CommentSliceView.class, "slcDp2Px", "slcDp2Px(I)I", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Integer.valueOf(invoke(((Number) r1).intValue()));
    }

    public final int invoke(int r2) {
        return ((CommentSliceView) ((CallableReference) this).receiver).c(r2);
    }
}
