package com.larus.bmhome.upload.instant;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/upload/instant/ImageInstantUploadApi;", "", "preQuery", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryResponse;", "path", "", "request", "Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryRequest;", "(Ljava/lang/String;Lcom/larus/bmhome/upload/instant/ImageInstantUploadPreQueryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageInstantUploadApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f314762a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f314763a = null;

        static {
            f314763a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, Continuation r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_TEC, ImageInstantUploadApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f314762a = a.f314763a;
    }

    @POST
    Object preQuery(@Url String r100, @Body ImageInstantUploadPreQueryRequest r101, Continuation<? super BizResponse<ImageInstantUploadPreQueryResponse>> r102);
}
