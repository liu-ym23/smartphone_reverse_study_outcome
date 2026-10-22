package com.larus.canvas.feature.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import gy8.b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ny8.f;
import ny8.i;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/canvas/feature/api/CanvasApi;", "", "fetchInstructionTab", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/canvas/feature/api/InstructionTabFetchResponse;", "request", "Lcom/larus/canvas/feature/api/InstructionTabFetchRequest;", "(Lcom/larus/canvas/feature/api/InstructionTabFetchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCanvasBlockInfo", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoResp;", "Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;", "(Lcom/larus/canvas/service/bean/GetCanvasBlockInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CanvasApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f323032a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f323033a = null;

        static {
            f323033a = new a();
        }

        public a() {
        }
    }

    static {
        f323032a = a.f323033a;
    }

    @POST("/creativity/canvas/fetch_instruction_tab")
    Object fetchInstructionTab(@Body gy8.a r100, Continuation<? super BizResponse<b>> r101);

    @POST("/creativity/canvas/get_canvas_block_info")
    Object getCanvasBlockInfo(@Body f r100, Continuation<? super BizResponse<i>> r101);
}
