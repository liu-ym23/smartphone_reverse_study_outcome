package com.larus.common.account.platform.larkauth.api;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/common/account/platform/larkauth/api/LarkAuthorizeApi;", "", "getAuthToken", "", ContainerPosition.BODY, "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LarkAuthorizeApi {
    @GET("https://www.feishu.cn/space/api/infra/domains/all")
    Object getAuthList(Continuation<? super String> r100);

    @FormUrlEncoded
    @POST("/passport/user/biz_auth/")
    Object getAuthToken(@FieldMap Map<String, String> r100, Continuation<? super String> r101);
}
