package com.larus.office.base.watermark.api.remote;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.network.bean.BizResponse;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/office/base/watermark/api/remote/WatermarkRetrofitApi;", "", "watermarkDownload", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/base/watermark/api/remote/WatermarkData;", HiAnalyticsConstant.Direction.REQUEST, "Lcom/larus/office/base/watermark/api/remote/WatermarkDownloadRequest;", "(Lcom/larus/office/base/watermark/api/remote/WatermarkDownloadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "watermarkTask", DBDefinition.TASK_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface WatermarkRetrofitApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f361232a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f361233a = null;

        static {
            f361233a = new a();
        }

        public a() {
        }
    }

    static {
        f361232a = a.f361233a;
    }

    @POST("/alice/resource/watermark_download")
    Object watermarkDownload(@Body WatermarkDownloadRequest r100, Continuation<? super BizResponse<WatermarkData>> r101);

    @GET("/alice/resource/watermark_task")
    Object watermarkTask(@Query("task_id") String r100, Continuation<? super BizResponse<WatermarkData>> r101);
}
