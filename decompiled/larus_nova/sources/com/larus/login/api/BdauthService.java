package com.larus.login.api;

import android.app.Activity;
import com.android.ttcjpaysdk.bdpay.counter.outer.fallback.event.OuterPayFallbackReport;
import com.bytedance.retrofit2.http.Body;
import com.larus.account.bdauth.api.UserInfoRequest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/larus/login/api/BdauthService;", "Lcom/larus/login/api/IBdauthApi;", "<init>", "()V", OuterPayFallbackReport.RETAIN_ACTION_IMP, "getImp", "()Lcom/larus/login/api/IBdauthApi;", "imp$delegate", "Lkotlin/Lazy;", "needSaveActivityWhenFinishAll", "", "activity", "Landroid/app/Activity;", "requestUserInfo", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/account/bdauth/api/ProfileOverviewResponse;", "request", "Lcom/larus/account/bdauth/api/UserInfoRequest;", "(Lcom/larus/account/bdauth/api/UserInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOpenAuthCode", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeResult;", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeRequest;", "(Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BdauthService implements IBdauthApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BdauthService f356936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f356937b = null;

    private BdauthService() {
    }

    static {
        f356936a = new BdauthService();
        f356937b = LazyKt.lazy(new c());
    }

    @Override // com.larus.login.api.IBdauthApi
    public final boolean a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IBdauthApi r101 = (IBdauthApi) f356937b.getValue();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.login.api.IBdauthApi
    public final Object b(t38.a r100, Continuation<? super t38.b> r101) {
        if ((r101 instanceof BdauthService$requestOpenAuthCode$1) == false) goto L7;
        BdauthService$requestOpenAuthCode$1 r102 = (BdauthService$requestOpenAuthCode$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L19:
        t38.b r107 = (t38.b) r104;
        if (r107 == null) goto L22;
        return r107;
    L22:
        return new t38.b(null, 0, "BDAuth service unavailable", 3);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        IBdauthApi r108 = (IBdauthApi) f356937b.getValue();
        if (r108 == null) goto L22;
        r102.label = 1;
        r104 = r108.b(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new BdauthService$requestOpenAuthCode$1(this, r101);
        goto L8
    }

    @Override // com.larus.login.api.IBdauthApi
    public Object requestUserInfo(@Body UserInfoRequest r100, Continuation<? super dm9.a<t38.c>> r101) {
        IBdauthApi r102 = (IBdauthApi) f356937b.getValue();
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.requestUserInfo(r100, r101);
    }
}
