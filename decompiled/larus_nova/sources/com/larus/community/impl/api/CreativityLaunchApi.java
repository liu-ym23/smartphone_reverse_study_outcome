package com.larus.community.impl.api;

import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/community/impl/api/CreativityLaunchApi;", "", "requestCreativityLaunch", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/platform/model/creation/CreativityLaunchConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CreativityLaunchApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f328809a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f328810a = null;

        static {
            f328810a = new a();
        }

        public a() {
        }
    }

    static {
        f328809a = a.f328810a;
    }

    @POST("/creativity/launch")
    Object requestCreativityLaunch(Continuation<? super BizResponse<sq9.o>> r100);
}
