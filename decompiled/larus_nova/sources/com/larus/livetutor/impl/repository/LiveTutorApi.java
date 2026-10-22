package com.larus.livetutor.impl.repository;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.livetutor.api.idl.GetCommonFeedbackConfRequest;
import com.larus.livetutor.api.idl.GetCommonFeedbackConfResponse;
import com.larus.livetutor.api.idl.GetLiveTutorFixedQueryRequest;
import com.larus.livetutor.api.idl.GetLiveTutorFixedQueryResponse;
import com.larus.livetutor.api.idl.GetLiveTutorHistoryRequest;
import com.larus.livetutor.api.idl.GetLiveTutorHistoryResponse;
import com.larus.livetutor.api.idl.StartCallRequest;
import com.larus.livetutor.api.idl.StartCallResponse;
import com.larus.livetutor.api.idl.SubmitConversationFeedbackReq;
import com.larus.livetutor.api.idl.SubmitConversationFeedbackResp;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0004\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0004\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/livetutor/impl/repository/LiveTutorApi;", "", "getCommonFeedbackConfSync", "Lcom/larus/livetutor/api/idl/GetCommonFeedbackConfResponse;", "request", "Lcom/larus/livetutor/api/idl/GetCommonFeedbackConfRequest;", "(Lcom/larus/livetutor/api/idl/GetCommonFeedbackConfRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveTutorFixedQuerySync", "Lcom/larus/livetutor/api/idl/GetLiveTutorFixedQueryResponse;", "Lcom/larus/livetutor/api/idl/GetLiveTutorFixedQueryRequest;", "(Lcom/larus/livetutor/api/idl/GetLiveTutorFixedQueryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRealtimeCallSync", "Lcom/larus/livetutor/api/idl/StartCallResponse;", "Lcom/larus/livetutor/api/idl/StartCallRequest;", "(Lcom/larus/livetutor/api/idl/StartCallRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitConversationFeedbackSync", "Lcom/larus/livetutor/api/idl/SubmitConversationFeedbackResp;", "Lcom/larus/livetutor/api/idl/SubmitConversationFeedbackReq;", "(Lcom/larus/livetutor/api/idl/SubmitConversationFeedbackReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLiveTutorHistorySync", "Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryResponse;", "Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryRequest;", "(Lcom/larus/livetutor/api/idl/GetLiveTutorHistoryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LiveTutorApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f356187a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f356188a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<LiveTutorApi> f356189b = null;

        public Companion() {
        }

        static {
            f356188a = new Companion();
            f356189b = LazyKt.lazy(new a());
        }

        public final <T> Object a(Function2<? super LiveTutorApi, ? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101) {
            if ((r101 instanceof LiveTutorApi$Companion$safeCall$1) == false) goto L7;
            LiveTutorApi$Companion$safeCall$1 r102 = (LiveTutorApi$Companion$safeCall$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L15;
            if (r106 != 1) goto L14;
            ResultKt.throwOnFailure(r104);     // Catch: Exception -> L20
        L22:
            return r104;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
            LiveTutorApi r107 = f356189b.getValue();     // Catch: Exception -> L20
            r102.label = 1;     // Catch: Exception -> L20
            r104 = r100.invoke(r107, r102);     // Catch: Exception -> L20
            if (r104 != r105) goto L22;
            return r105;
        L20:
            e = move-exception;
            throw e;
        L7:
            r102 = new LiveTutorApi$Companion$safeCall$1(this, r101);
            goto L8
        }
    }

    static {
        f356187a = Companion.f356188a;
    }

    @POST("hippo/doubao/v1/conf/get_common_feedback")
    Object getCommonFeedbackConfSync(@Body GetCommonFeedbackConfRequest r100, Continuation<? super GetCommonFeedbackConfResponse> r101);

    @POST("hippo/doubao/v1/realtime_call/live_tutor/get_fixed_query")
    Object getLiveTutorFixedQuerySync(@Body GetLiveTutorFixedQueryRequest r100, Continuation<? super GetLiveTutorFixedQueryResponse> r101);

    @POST("hippo/doubao/v1/realtime_call/live_tutor/history")
    Object getLiveTutorHistorySync(@Body GetLiveTutorHistoryRequest r100, Continuation<? super GetLiveTutorHistoryResponse> r101);

    @POST("hippo/doubao/v1/realtime_call/start")
    Object startRealtimeCallSync(@Body StartCallRequest r100, Continuation<? super StartCallResponse> r101);

    @POST("hippo/doubao/v1/conversation/feedback")
    Object submitConversationFeedbackSync(@Body SubmitConversationFeedbackReq r100, Continuation<? super SubmitConversationFeedbackResp> r101);
}
