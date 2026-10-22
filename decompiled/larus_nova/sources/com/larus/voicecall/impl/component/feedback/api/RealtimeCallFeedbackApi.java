package com.larus.voicecall.impl.component.feedback.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import i3a.b;
import i3a.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackApi;", "", "feedbackSubmit", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackSubmitResponse;", "request", "Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackSubmitRequest;", "(Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackSubmitRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RealtimeCallFeedbackApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f377440a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f377441a = null;

        static {
            f377441a = new a();
        }

        public a() {
        }
    }

    static {
        f377440a = a.f377441a;
    }

    @POST("/alice/call/feedback/submit")
    Object feedbackSubmit(@Body b r100, Continuation<? super BizResponse<c>> r101);
}
