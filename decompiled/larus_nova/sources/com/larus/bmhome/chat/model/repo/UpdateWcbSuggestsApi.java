package com.larus.bmhome.chat.model.repo;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.bmhome.chat.bean.UpdateWcbSuggestsRequest;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/UpdateWcbSuggestsApi;", "", "updateWcbSuggests", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/larus/bmhome/chat/bean/UpdateWcbSuggestsRequest;", "(Lcom/larus/bmhome/chat/bean/UpdateWcbSuggestsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UpdateWcbSuggestsApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f307759a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f307760a = null;

        static {
            f307760a = new a();
        }

        public a() {
        }
    }

    static {
        f307759a = a.f307760a;
    }

    @POST("/biz/onboarding/update_wcb_suggests")
    Object updateWcbSuggests(@Body UpdateWcbSuggestsRequest r100, Continuation<? super BizResponse<Object>> r101);
}
