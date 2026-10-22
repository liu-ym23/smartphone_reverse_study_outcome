package com.larus.avlink.autoGreet;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J \u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/avlink/autoGreet/AutoGreetApi;", "", "uploadDoraEvent", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/larus/avlink/autoGreet/UploadDoraEventRequest;", "(Lcom/larus/avlink/autoGreet/UploadDoraEventRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AutoGreetApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f291649a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291650a = null;

        static {
            f291650a = new a();
        }

        public a() {
        }
    }

    static {
        f291649a = a.f291650a;
    }

    @POST("/alice/wearable/upload_dora_event")
    Object uploadDoraEvent(@Body g r100, Continuation<? super BizResponse<Object>> r101);
}
