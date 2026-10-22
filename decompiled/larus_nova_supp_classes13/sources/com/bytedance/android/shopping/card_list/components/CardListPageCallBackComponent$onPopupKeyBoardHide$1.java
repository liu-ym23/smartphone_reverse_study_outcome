package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class CardListPageCallBackComponent$onPopupKeyBoardHide$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CardListPageCallBackComponent this$0;

    public CardListPageCallBackComponent$onPopupKeyBoardHide$1(CardListPageCallBackComponent r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m357invoke() {
        CardListRunCatchExtKt.a(this.this$0.j, "onPopUpKeyboardHide", new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m357invoke();
        return Unit.INSTANCE;
    }
}
