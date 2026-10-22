package com.ss.android.lark.contact.base.contact_focus;

import a2b.h;
import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "", "Lcom/ss/android/lark/chat/entity/chatter/UserPrivateDescription;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.base.contact_focus.SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1", f = "SpecialFocusModel.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Map<String, ? extends UserPrivateDescription>>>, Object> {
    final /* synthetic */ List<String> $batchIds;
    final /* synthetic */ h $service;
    int label;

    public SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1(h r100, List<String> r101, Continuation<? super SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1> r102) {
        this.$service = r100;
        this.$batchIds = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1(this.$service, this.$batchIds, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends Map<String, ? extends UserPrivateDescription>>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r101) {
        return ((SpecialFocusModel$loadPrivateDescriptionsInBatches$2$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L12:
        return Result.m9448boximpl(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        h r104 = this.$service;
        List<String> r105 = this.$batchIds;
        PrivateDescriptionSource r106 = PrivateDescriptionSource.CONTACT_IN_ORGANIZATION;
        Strategy r107 = Strategy.TRY_LOCAL;
        this.label = 1;
        r103 = r104.S0(r105, r106, r107, this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
