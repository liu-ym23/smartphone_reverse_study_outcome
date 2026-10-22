package com.bytedance.android.shopping.new_cart.components;

import com.bytedance.android.shopping.card_list.components.r;
import com.bytedance.android.shopping.new_cart.widgets.CardListCartErrorView;
import com.bytedance.android.shopping.new_cart.widgets.ErrorViewAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/card_list/components/r;", "Lcom/bytedance/android/shopping/new_cart/widgets/CardListCartErrorView;", "Lcom/bytedance/android/shopping/new_cart/widgets/i;", "Lcom/bytedance/android/shopping/new_cart/widgets/ErrorViewAction;", "", "invoke", "(Lcom/bytedance/android/shopping/card_list/components/r;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class CardListCartErrorComponent$scene$1 extends Lambda implements Function1<r<CardListCartErrorView, com.bytedance.android.shopping.new_cart.widgets.i, ErrorViewAction>, Unit> {
    final /* synthetic */ CardListCartErrorComponent this$0;

    public CardListCartErrorComponent$scene$1(CardListCartErrorComponent r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(r<CardListCartErrorView, com.bytedance.android.shopping.new_cart.widgets.i, ErrorViewAction> r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.c(new AnonymousClass1(this));
        r2.a(new AnonymousClass2(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((r) r1);
        return Unit.INSTANCE;
    }
}
