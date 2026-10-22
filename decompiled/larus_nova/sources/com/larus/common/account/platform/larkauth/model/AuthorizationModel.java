package com.larus.common.account.platform.larkauth.model;

import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.common.account.platform.larkauth.api.LarkAuthorizeApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class AuthorizationModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthorizationModel f326136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LarkAuthorizeApi f326137b = null;

    public AuthorizationModel() {
    }

    static {
        f326136a = new AuthorizationModel();
        FlowHttpConnection r100 = FlowHttpConnection.f359975a;
        f326137b = (LarkAuthorizeApi) RetrofitUtils.createSsRetrofit(FlowHttpConnection.a(), CollectionsKt.emptyList(), rx5.a.a()).create(LarkAuthorizeApi.class);
    }

    public final Object b(Continuation<? super String> r100) {
        if ((r100 instanceof AuthorizationModel$getDomainsAll$1) == false) goto L7;
        AuthorizationModel$getDomainsAll$1 r101 = (AuthorizationModel$getDomainsAll$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13
    L24:
        return r103;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        LarkAuthorizeApi r106 = f326137b;     // Catch: Throwable -> L13
        r101.label = 1;     // Catch: Throwable -> L13
        r103 = r106.getAuthList(r101);     // Catch: Throwable -> L13
        if (r103 != r104) goto L24;
        return r104;
    L13:
        th = move-exception;
        FLogger.f375446a.e("AuthorizationModel", "getDomainsAll e=" + th.getMessage());
        return null;
    L7:
        r101 = new AuthorizationModel$getDomainsAll$1(this, r100);
        goto L8
    }

    public final Object a(Map<String, String> r100, Continuation<? super String> r101) {
        if ((r101 instanceof AuthorizationModel$getAuthToken$1) == false) goto L7;
        AuthorizationModel$getAuthToken$1 r102 = (AuthorizationModel$getAuthToken$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L13
    L24:
        return r104;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        LarkAuthorizeApi r107 = f326137b;     // Catch: Throwable -> L13
        r102.label = 1;     // Catch: Throwable -> L13
        r104 = r107.getAuthToken(r100, r102);     // Catch: Throwable -> L13
        if (r104 != r105) goto L24;
        return r105;
    L13:
        th = move-exception;
        FLogger.f375446a.e("AuthorizationModel", "getAuthToken e=" + th.getMessage());
        return null;
    L7:
        r102 = new AuthorizationModel$getAuthToken$1(this, r101);
        goto L8
    }
}
