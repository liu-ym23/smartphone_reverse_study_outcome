package com.larus.bmhome.chat.api;

import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.larus.network.bean.BizResponse;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006H§@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/api/SearchSuggestApi;", "", "getFlowSuggest", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/SuggestPromptData;", EventConstant.Key.RETAIN_PROMPT, "", "response", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SearchSuggestApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f297176a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f297177a = null;

        static {
            f297177a = new a();
        }

        public a() {
        }
    }

    static {
        f297176a = a.f297177a;
    }

    @POST("/alice/suggestwords/get_flow_suggest")
    Object getFlowSuggest(@Query("prompt_content") String r100, @Query("response_content") String r101, Continuation<? super BizResponse<SuggestPromptData>> r102);
}
