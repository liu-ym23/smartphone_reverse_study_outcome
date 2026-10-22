package com.obric.assistant.feedback.upload;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.k;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H§@¢\u0006\u0002\u0010\u0011J4\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003H§@¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/feedback/upload/IReportUploadNetworkService;", "", "getLocation", "Lcom/google/gson/JsonObject;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadReport", "nsKey", "", "conType", "xttToken", "useQueryAid", "", "reportData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFile", ContainerPosition.BODY, "Lokhttp3/MultipartBody;", "(Ljava/lang/String;Lokhttp3/MultipartBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendText", "contentData", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IReportUploadNetworkService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f389274a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f389275a = null;

        static {
            f389275a = new a();
        }

        public a() {
        }
    }

    static {
        f389274a = a.f389275a;
    }

    @POST("api/v1/fb/appends")
    Object appendText(@Header("Authorization") String r100, @Header("Content-type") String r101, @Body JsonObject r102, Continuation<? super JsonObject> r103);

    @GET("api/0/util/location/my")
    Object getLocation(Continuation<? super JsonObject> r100);

    @POST("api/v1/fb/files")
    Object uploadFile(@Header("Authorization") String r100, @Body k r101, Continuation<? super JsonObject> r102);

    @POST("api/v1/fb/reports")
    Object uploadReport(@Header("Authorization") String r100, @Header("Content-type") String r101, @Header("X-Tt-token") String r102, @Query("use_query_aid") int r103, @Body JsonObject r104, Continuation<? super JsonObject> r105);
}
