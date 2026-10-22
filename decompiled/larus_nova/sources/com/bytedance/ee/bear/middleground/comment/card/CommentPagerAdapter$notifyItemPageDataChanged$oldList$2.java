package com.bytedance.ee.bear.middleground.comment.card;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CommentPagerAdapter$notifyItemPageDataChanged$oldList$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public CommentPagerAdapter$notifyItemPageDataChanged$oldList$2(Object r100) {
        super(0, r100, RecyclerView.class, "invalidateItemDecorations", "invalidateItemDecorations()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((RecyclerView) this.receiver).invalidateItemDecorations();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
