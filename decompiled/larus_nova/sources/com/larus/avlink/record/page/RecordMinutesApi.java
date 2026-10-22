package com.larus.avlink.record.page;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ&\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesApi;", "", "listRecording", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/record/page/RecordMinutesResult;", "request", "Lcom/larus/avlink/record/page/ListRecordingRequest;", "(Lcom/larus/avlink/record/page/ListRecordingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecording", "Lcom/larus/avlink/record/page/DeleteRecordingRequest;", "(Lcom/larus/avlink/record/page/DeleteRecordingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RecordMinutesApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f294165a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f294166a = null;

        static {
            f294166a = new a();
        }

        public a() {
        }
    }

    static {
        f294165a = a.f294166a;
    }

    @POST("/alice/wearable/record/delete_recording")
    Object deleteRecording(@Body b r100, Continuation<? super BizResponse<Object>> r101);

    @POST("/alice/wearable/record/list_recording")
    Object listRecording(@Body d r100, Continuation<? super BizResponse<List<l0>>> r101);
}
