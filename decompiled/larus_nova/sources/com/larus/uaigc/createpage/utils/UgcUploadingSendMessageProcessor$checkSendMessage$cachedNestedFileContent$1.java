package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.NestedFileContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/NestedFileContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NestedFileContent>, Object> {
    final /* synthetic */ String $localNestedFileMessageId;
    int label;

    public UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1(String r100, Continuation<? super UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1> r101) {
        this.$localNestedFileMessageId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1(this.$localNestedFileMessageId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super NestedFileContent> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super NestedFileContent> r101) {
        return ((UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return NestedFileCacheManagerService.f313409b.b6(this.$localNestedFileMessageId);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
