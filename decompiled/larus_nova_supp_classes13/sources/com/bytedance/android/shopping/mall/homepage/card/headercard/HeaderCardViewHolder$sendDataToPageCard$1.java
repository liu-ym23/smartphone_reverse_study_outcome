package com.bytedance.android.shopping.mall.homepage.card.headercard;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder$sendDataToPageCard$1", f = "HeaderCardViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HeaderCardViewHolder$sendDataToPageCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $cardType;
    final /* synthetic */ String $rawData;
    final /* synthetic */ String $skin;
    int label;
    final /* synthetic */ HeaderCardViewHolder this$0;

    public HeaderCardViewHolder$sendDataToPageCard$1(HeaderCardViewHolder r1, String r2, int r3, String r4, Continuation r5) {
        this.this$0 = r1;
        this.$rawData = r2;
        this.$cardType = r3;
        this.$skin = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "completion");
        return new HeaderCardViewHolder$sendDataToPageCard$1(this.this$0, this.$rawData, this.$cardType, this.$skin, r8);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        this.this$0.s.h.A1.Q30("updateHeaderCard", MapsKt.mapOf(new Pair[]{TuplesKt.to("data", this.$rawData), TuplesKt.to("cardType", Boxing.boxInt(this.$cardType)), TuplesKt.to("skin", this.$skin)}));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
