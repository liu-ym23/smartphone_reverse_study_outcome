package com.bytedance.ee.bear.middleground.comment.card;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CommentPagerAdapter$notifyItemPageDataChanged$oldList$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public CommentPagerAdapter$notifyItemPageDataChanged$oldList$2(Object r8) {
        super(0, r8, RecyclerView.class, "invalidateItemDecorations", "invalidateItemDecorations()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m114invoke() {
        ((RecyclerView) ((CallableReference) this).receiver).invalidateItemDecorations();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m114invoke();
        return Unit.INSTANCE;
    }
}
