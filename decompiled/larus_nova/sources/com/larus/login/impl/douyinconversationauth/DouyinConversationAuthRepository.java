package com.larus.login.impl.douyinconversationauth;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class DouyinConversationAuthRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouyinConversationAuthRepository f357644a = null;

    static {
        f357644a = new DouyinConversationAuthRepository();
    }

    public DouyinConversationAuthRepository() {
    }

    public final Object b(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DouyinConversationAuthRepository$reject$1) == false) goto L7;
        DouyinConversationAuthRepository$reject$1 r100 = (DouyinConversationAuthRepository$reject$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DouyinConversationAuthRepository$reject$1 r111 = r100;
        Object r112 = r111.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r111.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L18:
        return Boxing.boxBoolean(r112 instanceof y);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        JSONObject r104 = new JSONObject();
        r104.put("app", 2);
        Unit r105 = Unit.INSTANCE;
        r111.label = 1;
        r112 = HttpExtKt.k(ServiceType.BASIC_SERVICE, Object.class, "/alice/user/reject_doubao_auth", r104, null, null, false, null, null, null, r111, 1008);
        if (r112 != r102) goto L18;
        return r102;
    L7:
        r100 = new DouyinConversationAuthRepository$reject$1(this, r110);
        goto L8
    }

    public final Object a(String r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof DouyinConversationAuthRepository$exchangeAuthCode$1) == false) goto L7;
        DouyinConversationAuthRepository$exchangeAuthCode$1 r100 = (DouyinConversationAuthRepository$exchangeAuthCode$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DouyinConversationAuthRepository$exchangeAuthCode$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L22:
        return Boxing.boxBoolean(r113 instanceof y);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (StringsKt.isBlank(r110) == true) goto L17;
        JSONObject r104 = new JSONObject();
        r104.put("auth_code", r110);
        Unit r114 = Unit.INSTANCE;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.BASIC_SERVICE, Object.class, "/alice/user/exchange_doubao_access_token", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L22;
        return r102;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new DouyinConversationAuthRepository$exchangeAuthCode$1(this, r111);
        goto L8
    }
}
