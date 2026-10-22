package com.bytedance.android.shopping.card_list.widgets.nest;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CardListLinkedScrollView$initView$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public CardListLinkedScrollView$initView$1$1$1(CardListLinkedScrollView r8) {
        super(0, r8, CardListLinkedScrollView.class, "gulViewSticky", "gulViewSticky()V", 0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.FrameLayout, com.bytedance.android.shopping.card_list.widgets.nest.CardListLinkedScrollView] */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m594invoke() {
        ?? r0 = (CardListLinkedScrollView) ((CallableReference) this).receiver;
        int r1 = r0.n.getTop();
        if (r1 <= 0) goto L6;
        r0.scrollBy(0, r1);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m594invoke();
        return Unit.INSTANCE;
    }
}
