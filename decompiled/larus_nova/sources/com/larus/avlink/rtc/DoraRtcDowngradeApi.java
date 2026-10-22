package com.larus.avlink.rtc;

import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/rtc/DoraRtcDowngradeApi;", "", "createDoraRtcDowngradeRequest", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/rtc/DoraRtcDowngradeResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DoraRtcDowngradeApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f294445a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f294446a = null;

        static {
            f294446a = new a();
        }

        public a() {
        }
    }

    static {
        f294445a = a.f294446a;
    }

    @POST("/alice/audio/dora_update_config")
    Object createDoraRtcDowngradeRequest(Continuation<? super BizResponse<c>> r100);
}
