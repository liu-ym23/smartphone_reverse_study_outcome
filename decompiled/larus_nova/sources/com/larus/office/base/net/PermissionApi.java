package com.larus.office.base.net;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ8\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH§@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/office/base/net/PermissionApi;", "", "registerPermApply", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/base/net/RegisterPermApplyResponse;", "request", "Lcom/larus/office/base/net/RegisterPermApplyRequest;", "headers", "", "", "(Lcom/larus/office/base/net/RegisterPermApplyRequest;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PermissionApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f360585a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f360586a = null;

        static {
            f360586a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, PermissionApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f360585a = a.f360586a;
    }

    @POST("alice/writing/docs/register_perm_apply")
    Object registerPermApply(@Body RegisterPermApplyRequest r100, @HeaderMap Map<String, String> r101, Continuation<? super BizResponse<RegisterPermApplyResponse>> r102);
}
