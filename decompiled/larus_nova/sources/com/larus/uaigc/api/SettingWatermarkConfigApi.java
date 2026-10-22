package com.larus.uaigc.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/api/SettingWatermarkConfigApi;", "", "getConfig", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/GetSettingWatermarkConfigData;", "request", "Lcom/larus/uaigc/api/GetSettingWatermarkConfigRequest;", "(Lcom/larus/uaigc/api/GetSettingWatermarkConfigRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setConfig", "Lcom/larus/uaigc/api/SetSettingWatermarkConfigData;", "Lcom/larus/uaigc/api/SetSettingWatermarkConfigRequest;", "(Lcom/larus/uaigc/api/SetSettingWatermarkConfigRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SettingWatermarkConfigApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f370266a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f370267a = null;

        static {
            f370267a = new Companion();
        }

        public Companion() {
        }

        public static Object a(Function2 r100, Continuation r101) {
            return BuildersKt.withContext(Dispatchers.getIO(), new SettingWatermarkConfigApi$Companion$safeCall$2(r100, null), r101);
        }
    }

    static {
        f370266a = Companion.f370267a;
    }

    @POST("/privacy/watermark_config/get")
    Object getConfig(@Body l r100, Continuation<? super BizResponse<k>> r101);

    @POST("/privacy/watermark_config/set")
    Object setConfig(@Body u r100, Continuation<? super BizResponse<t>> r101);
}
