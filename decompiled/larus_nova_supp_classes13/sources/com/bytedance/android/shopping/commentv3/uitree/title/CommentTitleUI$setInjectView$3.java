package com.bytedance.android.shopping.commentv3.uitree.title;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CommentTitleUI$setInjectView$3 extends FunctionReferenceImpl implements Function1<Number, Integer> {
    public CommentTitleUI$setInjectView$3(CommentTitleUI r8) {
        super(1, r8, CommentTitleUI.class, "slcDp", "slcDp(Ljava/lang/Number;)I", 0);
    }

    public final int invoke(Number r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        CommentTitleUI r0 = (CommentTitleUI) ((CallableReference) this).receiver;
        int r1 = CommentTitleUI.v;
        return r0.l(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Integer.valueOf(invoke((Number) r1));
    }
}
