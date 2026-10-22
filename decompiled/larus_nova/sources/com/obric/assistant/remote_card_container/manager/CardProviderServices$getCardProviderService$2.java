package com.obric.assistant.remote_card_container.manager;

import android.content.Context;
import android.net.Uri;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant_card/provider_core/ICardProviderService;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.CardProviderServices$getCardProviderService$2", f = "CardProviderServices.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
public final class CardProviderServices$getCardProviderService$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ICardProviderService>, Object> {
    final /* synthetic */ Uri $cardUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $providerPkgName;
    int label;

    public CardProviderServices$getCardProviderService$2(String r100, Context r101, Uri r102, Continuation<? super CardProviderServices$getCardProviderService$2> r103) {
        this.$providerPkgName = r100;
        this.$context = r101;
        this.$cardUri = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CardProviderServices$getCardProviderService$2(this.$providerPkgName, this.$context, this.$cardUri, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ICardProviderService> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ICardProviderService> r101) {
        return ((CardProviderServices$getCardProviderService$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L22:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CardProviderServices r103 = CardProviderServices.f391269a;
        String r104 = this.$providerPkgName;
        Map<String, Job> r105 = CardProviderServices.f391271c;
        if (r105 == null) goto L13;
        Job r106 = r105.remove(r104);
        if (r106 == null) goto L13;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L13:
        Map<String, Pair<ICardProviderService, CardProviderServices.a>> r107 = CardProviderServices.f391270b;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        Pair r109 = (Pair) r108.get(this.$providerPkgName);
        if (r109 != null) goto L16;
    L19:
        Context r110 = this.$context;
        Uri r111 = this.$cardUri;
        this.label = 1;
        r100 = CardProviderServices.b(r103, r110, r111, this);
        if (r100 != r101) goto L22;
        return r101;
    L16:
        if (((CardProviderServices.a) r109.getSecond()).f391274a.get() == false) goto L19;
        return r109.getFirst();
    }
}
