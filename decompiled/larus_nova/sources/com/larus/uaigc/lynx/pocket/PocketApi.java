package com.larus.uaigc.lynx.pocket;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ,\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/PocketApi;", "", "getPocketPageData", "Lcom/larus/network/bean/BizResponse;", "", "", "request", "Lcom/larus/uaigc/lynx/pocket/GetPocketPageDataRequest;", "(Lcom/larus/uaigc/lynx/pocket/GetPocketPageDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PocketApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f373512a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f373513a = null;

        static {
            f373513a = new a();
        }

        public a() {
        }
    }

    static {
        f373512a = a.f373513a;
    }

    @POST("/creation/spring_2026/get_pocket_page_data")
    Object getPocketPageData(@Body GetPocketPageDataRequest r100, Continuation<? super BizResponse<Map<String, Object>>> r101);
}
