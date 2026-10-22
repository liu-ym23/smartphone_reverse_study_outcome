package com.larus.login.api;

import android.app.Activity;
import com.bytedance.retrofit2.http.Body;
import com.larus.account.bdauth.api.UserInfoRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/login/api/IBdauthApi;", "", "needSaveActivityWhenFinishAll", "", "activity", "Landroid/app/Activity;", "requestUserInfo", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/account/bdauth/api/ProfileOverviewResponse;", "request", "Lcom/larus/account/bdauth/api/UserInfoRequest;", "(Lcom/larus/account/bdauth/api/UserInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestOpenAuthCode", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeResult;", "Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeRequest;", "(Lcom/larus/account/bdauth/api/DoubaoOpenAuthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBdauthApi {
    boolean a(Activity r100);

    Object b(t38.a r100, Continuation<? super t38.b> r101);

    Object requestUserInfo(@Body UserInfoRequest r100, Continuation<? super dm9.a<t38.c>> r101);
}
