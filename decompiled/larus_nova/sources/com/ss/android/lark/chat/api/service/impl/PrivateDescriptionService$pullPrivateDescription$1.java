package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.PrivateDescriptionService", f = "PrivateDescriptionService.kt", i = {0}, l = {59}, m = "pullPrivateDescription-BWLJW6A", n = {"userId"}, s = {"L$0"})
final class PrivateDescriptionService$pullPrivateDescription$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrivateDescriptionService this$0;

    public PrivateDescriptionService$pullPrivateDescription$1(PrivateDescriptionService r100, Continuation<? super PrivateDescriptionService$pullPrivateDescription$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PrivateDescriptionService r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        PrivateDescriptionService$pullPrivateDescription$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        String r107 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);
        Object r108 = ((Result) r104).m9458unboximpl();
    L17:
        if (Result.m9456isSuccessimpl(r108) == false) goto L19;
        Object r109 = Result.m9449constructorimpl((UserPrivateDescription) ((Map) r108).get(r107));
    L20:
        r105 = r109;
    L22:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r105;
    L25:
        return Result.m9448boximpl(r105);
    L19:
        r109 = Result.m9449constructorimpl(r108);
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        List<String> r110 = CollectionsKt.listOf(null);
        r103.L$0 = null;
        r103.label = 1;
        r108 = r101.S0(r110, null, null, r103);
        if (r108 == r105) goto L22;
        r107 = null;
        goto L17
    L5:
        r103 = new PrivateDescriptionService$pullPrivateDescription$1(r101, this);
        goto L6
    }
}
