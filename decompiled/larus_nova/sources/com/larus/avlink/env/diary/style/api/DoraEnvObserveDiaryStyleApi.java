package com.larus.avlink.env.diary.style.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import m98.c;
import m98.d;
import m98.e;
import m98.f;
import m98.g;
import m98.h;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/larus/avlink/env/diary/style/api/DoraEnvObserveDiaryStyleApi;", "", "getDiaryStyleList", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/diary/style/api/DiaryStyleListData;", "request", "Lcom/larus/avlink/env/diary/style/api/GetDiaryStyleListRequest;", "(Lcom/larus/avlink/env/diary/style/api/GetDiaryStyleListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDiaryStyle", "Lcom/larus/avlink/env/diary/style/api/SetDiaryStyleData;", "Lcom/larus/avlink/env/diary/style/api/SetDiaryStyleRequest;", "(Lcom/larus/avlink/env/diary/style/api/SetDiaryStyleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDiaryStyle", "Lcom/larus/avlink/env/diary/style/api/UpdateDiaryStyleData;", "Lcom/larus/avlink/env/diary/style/api/UpdateDiaryStyleRequest;", "(Lcom/larus/avlink/env/diary/style/api/UpdateDiaryStyleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDiaryStyle", "Lcom/larus/avlink/env/diary/style/api/DeleteDiaryStyleRequest;", "(Lcom/larus/avlink/env/diary/style/api/DeleteDiaryStyleRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraEnvObserveDiaryStyleApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f292126a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f292127a = null;

        static {
            f292127a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.DORA, DoraEnvObserveDiaryStyleApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f292126a = a.f292127a;
    }

    @POST("/alice/wearable/diary/delete_style")
    Object deleteDiaryStyle(@Body m98.a r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/alice/wearable/diary/get_style")
    Object getDiaryStyleList(@Body d r100, Continuation<? super BizResponse<c>> r101);

    @POST("/alice/wearable/diary/set_style")
    Object setDiaryStyle(@Body f r100, Continuation<? super BizResponse<e>> r101);

    @POST("/alice/wearable/diary/update_style")
    Object updateDiaryStyle(@Body h r100, Continuation<? super BizResponse<g>> r101);
}
