package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import com.larus.office.OfficeInputParam;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1", f = "OfficeChatConversationMetadataSynchronizer.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
final class OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g.a $request;
    int label;
    final /* synthetic */ g this$0;

    public OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1(g r100, g.a r101, Continuation<? super OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1> r102) {
        this.this$0 = r100;
        this.$request = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1(this.this$0, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfficeChatConversationMetadataSynchronizer$requestCachedMetadata$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        g.c r103 = (g.c) r100;
        if (r103 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (this.$request.f362851e != this.this$0.f362839d.invoke().longValue()) goto L33;
        OfficeInputParam r104 = this.this$0.f362837b.invoke();
        String r105 = null;
        if (r104 == null) goto L20;
        String r106 = r104.getResourceId();
    L22:
        if (Intrinsics.areEqual(r106, this.$request.f362848b) == false) goto L33;
        OfficeInputParam r107 = this.this$0.f362837b.invoke();
        if (r107 == null) goto L27;
        r105 = r107.getConversationId();
    L27:
        if (Intrinsics.areEqual(r105, this.$request.f362847a) == false) goto L33;
        if (Intrinsics.areEqual(r103.f362852a, this.$request.f362847a) == false) goto L33;
        g.a(this.this$0, g.c.a(r103, this.$request.f362851e));
        return Unit.INSTANCE;
    L20:
        r106 = null;
    L33:
        FLogger.f375446a.i("OfficeChatConversation", "丢弃迟到的缓存 metadata");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        g r108 = this.this$0;
        g.a r109 = this.$request;
        String r110 = r109.f362848b;
        int r111 = r109.f362849c;
        String r112 = r109.f362850d;
        this.label = 1;
        r100 = g.b(r108, r110, r111, r112, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
