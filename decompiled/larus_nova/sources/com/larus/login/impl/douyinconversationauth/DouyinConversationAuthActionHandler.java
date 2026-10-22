package com.larus.login.impl.douyinconversationauth;

import com.larus.login.api.BdauthService;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes30.dex */
public final class DouyinConversationAuthActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouyinConversationAuthActionHandler f357639a = null;

    static {
        f357639a = new DouyinConversationAuthActionHandler();
    }

    public DouyinConversationAuthActionHandler() {
    }

    public final Object a(Continuation<? super Boolean> r100) {
        if ((r100 instanceof DouyinConversationAuthActionHandler$allow$1) == false) goto L7;
        DouyinConversationAuthActionHandler$allow$1 r101 = (DouyinConversationAuthActionHandler$allow$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L26:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L19:
        String r106 = ((t38.b) r103).f544451a;
        if (r106 == null) goto L22;
        DouyinConversationAuthRepository r107 = DouyinConversationAuthRepository.f357644a;
        r101.label = 2;
        r103 = r107.a(r106, r101);
        if (r103 != r104) goto L26;
        return r104;
    L22:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r103);
        BdauthService r108 = BdauthService.f356936a;
        t38.a r109 = new t38.a(CollectionsKt.listOf("interest_information"));
        r101.label = 1;
        r103 = r108.b(r109, r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new DouyinConversationAuthActionHandler$allow$1(this, r100);
        goto L8
    }
}
