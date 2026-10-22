package com.larus.uaigc.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/api/CreationNoWatermarkApi;", "", "getResourceWithoutWatermark", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/GetResourceWithoutWatermarkData;", "request", "Lcom/larus/uaigc/api/GetResourceWithoutWatermarkRequest;", "(Lcom/larus/uaigc/api/GetResourceWithoutWatermarkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserConfig", "Lcom/larus/uaigc/api/GetCreationUserConfigData;", "Lcom/larus/uaigc/api/GetCreationUserConfigRequest;", "(Lcom/larus/uaigc/api/GetCreationUserConfigRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CreationNoWatermarkApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f370261a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f370262a = null;

        static {
            f370262a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r100, ContinuationImpl r101) {
            return BuildersKt.withContext(Dispatchers.getIO(), new CreationNoWatermarkApi$Companion$safeCall$2(r100, null), r101);
        }
    }

    static {
        f370261a = a.f370262a;
    }

    @POST("/creativity/resource/get_without_watermark")
    Object getResourceWithoutWatermark(@Body j r100, Continuation<? super BizResponse<i>> r101);

    @POST("/creativity/user_config/get")
    Object getUserConfig(@Body h r100, Continuation<? super BizResponse<g>> r101);
}
