package com.ss.android.lark.auditsdk.v2.utils;

import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/auditsdk/IAuditModuleDependency$ChatType;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.auditsdk.v2.utils.AuditParamsUtil$fillDlpParams$chatType$1", f = "AuditParamsUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AuditParamsUtil$fillDlpParams$chatType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IAuditModuleDependency.ChatType>, Object> {
    final /* synthetic */ String $chatId;
    int label;

    public AuditParamsUtil$fillDlpParams$chatType$1(String r100, Continuation<? super AuditParamsUtil$fillDlpParams$chatType$1> r101) {
        this.$chatId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AuditParamsUtil$fillDlpParams$chatType$1(this.$chatId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super IAuditModuleDependency.ChatType> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super IAuditModuleDependency.ChatType> r101) {
        return ((AuditParamsUtil$fillDlpParams$chatType$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        AuditParamsUtil r101 = AuditParamsUtil.f409685a;
        return owa.a.d().getChatTypeByChatId(this.$chatId);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
