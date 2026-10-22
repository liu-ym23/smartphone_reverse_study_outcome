package com.larus.login.impl.utils;

import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H§@¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/larus/login/impl/utils/LogoutApi;", "", "requestLogoutAll", "Lcom/larus/network/bean/BizResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LogoutApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f358302a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f358303a = null;

        static {
            f358303a = new a();
        }

        public a() {
        }
    }

    static {
        f358302a = a.f358303a;
    }

    @POST("/alice/user/logout_all_device")
    Object requestLogoutAll(Continuation<? super BizResponse<Object>> r100);
}
