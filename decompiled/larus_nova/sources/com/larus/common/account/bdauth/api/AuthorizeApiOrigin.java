package com.larus.common.account.bdauth.api;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\u00032\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH§@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/common/account/bdauth/api/AuthorizeApiOrigin;", "", "getAuthInfo", "", "clientKey", "scope", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthCode", ContainerPosition.BODY, "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerNewUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AuthorizeApiOrigin {
    @FormUrlEncoded
    @POST("/passport/open/auth/")
    Object getAuthCode(@FieldMap Map<String, String> r100, Continuation<? super String> r101);

    @GET("/passport/open/auth_info/v2/")
    Object getAuthInfo(@Query("client_key") String r100, @Query("scope") String r101, Continuation<? super String> r102);

    @FormUrlEncoded
    @POST("/passport/doubao/register_lark/")
    Object registerNewUser(Continuation<? super String> r100);
}
