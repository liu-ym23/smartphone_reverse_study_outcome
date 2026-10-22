package com.larus.minor.impl.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.auth.MinorInfoData;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H§@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/larus/minor/impl/api/MinorApi;", "", "requestEnterMinor", "Lcom/larus/network/bean/BizResponse;", "", "request", "Lcom/larus/minor/impl/api/EnterMinotRequest;", "(Lcom/larus/minor/impl/api/EnterMinotRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestQuitMinor", "Lcom/larus/minor/impl/api/QuitMinotRequest;", "(Lcom/larus/minor/impl/api/QuitMinotRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMinorInfo", "Lcom/larus/bmhome/auth/MinorInfoData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MinorApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f359163a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f359164a = null;

        static {
            f359164a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, MinorApi.class, r110, true, null, null, null, r111, 240);
        }
    }

    static {
        f359163a = a.f359164a;
    }

    @POST("/alice/minor/enter_minor")
    Object requestEnterMinor(@Body EnterMinotRequest r100, Continuation<? super BizResponse<Unit>> r101);

    @POST("/alice/minor/get_minor_info")
    Object requestMinorInfo(Continuation<? super BizResponse<MinorInfoData>> r100);

    @POST("/alice/minor/quit_minor")
    Object requestQuitMinor(@Body QuitMinotRequest r100, Continuation<? super BizResponse<Unit>> r101);
}
