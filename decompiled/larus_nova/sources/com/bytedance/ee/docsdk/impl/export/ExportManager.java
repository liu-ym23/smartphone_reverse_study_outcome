package com.bytedance.ee.docsdk.impl.export;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.drive.model.transfer.IDriveTransferTask;
import com.bytedance.ee.drive.model.transfer.download.DriveDownloadRequest;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.idependency.INetCallback;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.NetService;
import com.ss.android.lark.chameleon.util.ExternalStorageUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001:\bNOPQRSTUB\t\b\u0002¢\u0006\u0004\bL\u0010MJ:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0014H\u0002J2\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J%\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020%H\u0002J\"\u0010'\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J,\u0010(\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J*\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J$\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000206018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010<\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00109R\u0014\u0010=\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00109R\u0014\u0010>\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00109R\u0014\u0010?\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00109R\u0014\u0010@\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u00109R\u0014\u0010A\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u00109R\u0014\u0010B\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u00109R\u0014\u0010C\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010DR\u0014\u0010F\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010G\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010DR\u0014\u0010H\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u00109R\u0014\u0010I\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u00109R\u0014\u0010J\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u00109R\u0014\u0010K\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u00109\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006V"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager;", "Lcom/bytedance/ee/docsdk/impl/export/IFileExportService;", "", "token", "filePath", "type", "fileExtension", "", "eventSource", "Lcom/bytedance/ee/docsdk/impl/export/IDownloadResult;", "callback", "", "exportFile", "", "cancelExport", "cancelAllExports", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportRequest;", "request", "exportDocument", "ticket", "Lcom/ss/android/lark/chameleon/idependency/INetCallback;", "sendGetRequestForExportResult", "jobTimeout", "pollExportResult", "handlePollingTimeout", "fetchPollingResult", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "response", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus;", "processPollingResponse", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResponse;", "handleExportSuccess", "fileToken", "saveFilePath", "downloadFileWithDriveSdk", "validateExportRequest", "buildRequestBody", "", "buildRequestHeaders", "createExportCallback", "handleExportSuccessResponse", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportResult;", "result", "startPollingIfValid", "code", "handleHttpError", "errorCode", "errorMsg", "handleNetworkError", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", "exportJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "pollingJobs", "Lgr5/a;", "downloadTasks", "TAG", "Ljava/lang/String;", "BASE_URL", "EXPORT_CREATE_URL", "EXPORT_RESULT_URL", "PARAM_TOKEN", "PARAM_TYPE", "PARAM_SLIDES", "HEADER_CONTENT_TYPE", "HEADER_ACCEPT", "HEADER_JSON_VALUE", "POLLING_INTERVAL_MS", "I", "INITIAL_DELAY_MS", "DEFAULT_JOB_TIMEOUT", "POLLING_INTERVAL_SECONDS", "ERROR_EXPORT_TIMEOUT_PREFIX", "ERROR_EXPORT_FAILED_PREFIX", "ERROR_HTTP_ERROR_CODE_PREFIX", "ERROR_NETWORK_PREFIX", "<init>", "()V", "ExportData", "ExportRequest", "ExportRequestBody", "ExportResult", "PollingData", "PollingResponse", "PollingResult", "PollingStatus", "docs-sdk_release"}, k = 1, mv = {1, 7, 1})
public final class ExportManager implements IFileExportService {
    private static final String BASE_URL = "https://internal-api-space.feishu.cn/space/api";
    private static final int DEFAULT_JOB_TIMEOUT = 600;
    private static final String ERROR_EXPORT_FAILED_PREFIX = "Export failed with job_status: ";
    private static final String ERROR_EXPORT_TIMEOUT_PREFIX = "Export timed out after ";
    private static final String ERROR_HTTP_ERROR_CODE_PREFIX = "HTTP error code: ";
    private static final String ERROR_NETWORK_PREFIX = "Network error: ";
    private static final String EXPORT_CREATE_URL = "https://internal-api-space.feishu.cn/space/api/export/create/";
    private static final String EXPORT_RESULT_URL = "https://internal-api-space.feishu.cn/space/api/export/result/";
    private static final String HEADER_ACCEPT = "Accept";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_JSON_VALUE = "application/json";
    private static final int INITIAL_DELAY_MS = 1000;
    public static final ExportManager INSTANCE = null;
    private static final String PARAM_SLIDES = "slides";
    private static final String PARAM_TOKEN = "token";
    private static final String PARAM_TYPE = "type";
    private static final int POLLING_INTERVAL_MS = 3000;
    private static final int POLLING_INTERVAL_SECONDS = 3;
    private static final String TAG = "ExportManager";
    private static final ConcurrentHashMap<String, gr5.a> downloadTasks = null;
    private static final ConcurrentHashMap<String, Job> exportJobs = null;
    private static final ConcurrentHashMap<String, Job> pollingJobs = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014J\\\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "", "exportId", "", DBDefinition.TASK_ID, "status", "downloadUrl", "expiredAt", "", "ticket", "jobTimeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getDownloadUrl", "()Ljava/lang/String;", "getExpiredAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExportId", "getJobTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getTaskId", "getTicket", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExportData {

        @SerializedName("download_url")
        private final String downloadUrl;

        @SerializedName("expired_at")
        private final Long expiredAt;

        @SerializedName("export_id")
        private final String exportId;

        @SerializedName("job_timeout")
        private final Integer jobTimeout;
        private final String status;

        @SerializedName("task_id")
        private final String taskId;
        private final String ticket;

        public static /* synthetic */ ExportData copy$default(ExportData r100, String r101, String r102, String r103, String r104, Long r110, String r111, Integer r112, int r113, Object r114) {
            if ((r113 & 1) == 0) goto L6;
            r101 = r100.exportId;
        L6:
            if ((r113 & 2) == 0) goto L8;
            r102 = r100.taskId;
        L8:
            String r115 = r102;
            if ((r113 & 4) == 0) goto L11;
            r103 = r100.status;
        L11:
            String r105 = r103;
            if ((r113 & 8) == 0) goto L14;
            r104 = r100.downloadUrl;
        L14:
            String r106 = r104;
            if ((r113 & 16) == 0) goto L17;
            r110 = r100.expiredAt;
        L17:
            Long r107 = r110;
            if ((r113 & 32) == 0) goto L20;
            r111 = r100.ticket;
        L20:
            String r108 = r111;
            if ((r113 & 64) == 0) goto L23;
            r112 = r100.jobTimeout;
        L23:
            String r109 = r101;
            return r100.copy(r109, r115, r105, r106, r107, r108, r112);
        }

        public final String component1() {
            return this.exportId;
        }

        public final String component2() {
            return this.taskId;
        }

        public final String component3() {
            return this.status;
        }

        public final String component4() {
            return this.downloadUrl;
        }

        public final Long component5() {
            return this.expiredAt;
        }

        public final String component6() {
            return this.ticket;
        }

        public final Integer component7() {
            return this.jobTimeout;
        }

        public final ExportData copy(String r110, String r111, String r112, String r113, Long r114, String r115, Integer r116) {
            Intrinsics.checkNotNullParameter(r110, "exportId");
            Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r112, "status");
            return new ExportData(r110, r111, r112, r113, r114, r115, r116);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExportData) == true) goto L8;
            return false;
        L8:
            ExportData r101 = (ExportData) r100;
            if (Intrinsics.areEqual(this.exportId, r101.exportId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.status, r101.status) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.expiredAt, r101.expiredAt) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.ticket, r101.ticket) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.jobTimeout, r101.jobTimeout) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r100 = ((((this.exportId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.status.hashCode()) * 31;
            String r101 = this.downloadUrl;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Long r105 = this.expiredAt;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.ticket;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Integer r111 = this.jobTimeout;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "ExportData(exportId=" + this.exportId + ", taskId=" + this.taskId + ", status=" + this.status + ", downloadUrl=" + this.downloadUrl + ", expiredAt=" + this.expiredAt + ", ticket=" + this.ticket + ", jobTimeout=" + this.jobTimeout + ')';
        }

        public final String getDownloadUrl() {
            return this.downloadUrl;
        }

        public final Long getExpiredAt() {
            return this.expiredAt;
        }

        public final String getExportId() {
            return this.exportId;
        }

        public final Integer getJobTimeout() {
            return this.jobTimeout;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getTicket() {
            return this.ticket;
        }

        public ExportData(String r100, String r101, String r102, String r103, Long r104, String r105, Integer r106) {
            Intrinsics.checkNotNullParameter(r100, "exportId");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r102, "status");
            this.exportId = r100;
            this.taskId = r101;
            this.status = r102;
            this.downloadUrl = r103;
            this.expiredAt = r104;
            this.ticket = r105;
            this.jobTimeout = r106;
        }

        public /* synthetic */ ExportData(String r110, String r111, String r112, String r113, Long r114, String r115, Integer r116, int r117, DefaultConstructorMarker r118) {
            if ((r117 & 8) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r117 & 16) == 0) goto L9;
            Long r101 = null;
        L11:
            if ((r117 & 32) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r117 & 64) == 0) goto L17;
            Integer r103 = null;
        L18:
            this(r110, r111, r112, r100, r101, r102, r103);
            return;
        L17:
            r103 = r116;
            goto L18
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportRequest;", "", "token", "", "type", SubInfo.KEY_FORMAT, "eventSource", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEventSource", "()I", "getFormat", "()Ljava/lang/String;", "getToken", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExportRequest {
        private final int eventSource;
        private final String format;
        private final String token;
        private final String type;

        public static /* synthetic */ ExportRequest copy$default(ExportRequest r100, String r101, String r102, String r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.token;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.type;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.format;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.eventSource;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.token;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.format;
        }

        public final int component4() {
            return this.eventSource;
        }

        public final ExportRequest copy(String r100, String r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
            return new ExportRequest(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExportRequest) == true) goto L8;
            return false;
        L8:
            ExportRequest r101 = (ExportRequest) r100;
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.format, r101.format) == true) goto L18;
            return false;
        L18:
            if (this.eventSource == r101.eventSource) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.token.hashCode() * 31) + this.type.hashCode()) * 31) + this.format.hashCode()) * 31) + this.eventSource;
        }

        public String toString() {
            return "ExportRequest(token=" + this.token + ", type=" + this.type + ", format=" + this.format + ", eventSource=" + this.eventSource + ')';
        }

        public final int getEventSource() {
            return this.eventSource;
        }

        public final String getFormat() {
            return this.format;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getType() {
            return this.type;
        }

        public ExportRequest(String r100, String r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
            this.token = r100;
            this.type = r101;
            this.format = r102;
            this.eventSource = r103;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportRequestBody;", "", "token", "", "type", "fileExtension", "eventSource", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEventSource", "()I", "getFileExtension", "()Ljava/lang/String;", "getToken", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExportRequestBody {

        @SerializedName("event_source")
        private final int eventSource;

        @SerializedName("file_extension")
        private final String fileExtension;
        private final String token;
        private final String type;

        public static /* synthetic */ ExportRequestBody copy$default(ExportRequestBody r100, String r101, String r102, String r103, int r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.token;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.type;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.fileExtension;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.eventSource;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.token;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.fileExtension;
        }

        public final int component4() {
            return this.eventSource;
        }

        public final ExportRequestBody copy(String r100, String r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r102, "fileExtension");
            return new ExportRequestBody(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExportRequestBody) == true) goto L8;
            return false;
        L8:
            ExportRequestBody r101 = (ExportRequestBody) r100;
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileExtension, r101.fileExtension) == true) goto L18;
            return false;
        L18:
            if (this.eventSource == r101.eventSource) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.token.hashCode() * 31) + this.type.hashCode()) * 31) + this.fileExtension.hashCode()) * 31) + this.eventSource;
        }

        public String toString() {
            return "ExportRequestBody(token=" + this.token + ", type=" + this.type + ", fileExtension=" + this.fileExtension + ", eventSource=" + this.eventSource + ')';
        }

        public final int getEventSource() {
            return this.eventSource;
        }

        public final String getFileExtension() {
            return this.fileExtension;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getType() {
            return this.type;
        }

        public ExportRequestBody(String r100, String r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r102, "fileExtension");
            this.token = r100;
            this.type = r101;
            this.fileExtension = r102;
            this.eventSource = r103;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportResult;", "", "code", "", "message", "", "data", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "(ILjava/lang/String;Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;)V", "getCode", "()I", "getData", "()Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExportResult {
        private final int code;
        private final ExportData data;
        private final String message;

        public static /* synthetic */ ExportResult copy$default(ExportResult r100, int r101, String r102, ExportData r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.code;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.message;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.data;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.message;
        }

        public final ExportData component3() {
            return this.data;
        }

        public final ExportResult copy(int r100, String r101, ExportData r102) {
            return new ExportResult(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ExportResult) == true) goto L8;
            return false;
        L8:
            ExportResult r101 = (ExportResult) r100;
            if (this.code == r101.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.code * 31;
            String r101 = this.message;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            ExportData r105 = this.data;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "ExportResult(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
        }

        public final int getCode() {
            return this.code;
        }

        public final ExportData getData() {
            return this.data;
        }

        public final String getMessage() {
            return this.message;
        }

        public ExportResult(int r100, String r101, ExportData r102) {
            this.code = r100;
            this.message = r101;
            this.data = r102;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;", "", "result", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;", "(Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;)V", "getResult", "()Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PollingData {
        private final PollingResult result;

        public static /* synthetic */ PollingData copy$default(PollingData r100, PollingResult r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.result;
        L6:
            return r100.copy(r101);
        }

        public final PollingResult component1() {
            return this.result;
        }

        public final PollingData copy(PollingResult r100) {
            return new PollingData(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PollingData) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.result, ((PollingData) r100).result) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            PollingResult r100 = this.result;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "PollingData(result=" + this.result + ')';
        }

        public final PollingResult getResult() {
            return this.result;
        }

        public PollingData(PollingResult r100) {
            this.result = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResponse;", "", "data", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;", "(Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;)V", "getData", "()Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PollingResponse {
        private final PollingData data;

        public static /* synthetic */ PollingResponse copy$default(PollingResponse r100, PollingData r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final PollingData component1() {
            return this.data;
        }

        public final PollingResponse copy(PollingData r100) {
            return new PollingResponse(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PollingResponse) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((PollingResponse) r100).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            PollingData r100 = this.data;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "PollingResponse(data=" + this.data + ')';
        }

        public final PollingData getData() {
            return this.data;
        }

        public PollingResponse(PollingData r100) {
            this.data = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;", "", "fileToken", "", "fileName", "fileExtension", "jobStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)V", "getFileExtension", "()Ljava/lang/String;", "getFileName", "getFileToken", "getJobStatus", "()D", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PollingResult {

        @SerializedName("file_extension")
        private final String fileExtension;

        @SerializedName("file_name")
        private final String fileName;

        @SerializedName("file_token")
        private final String fileToken;

        @SerializedName("job_status")
        private final double jobStatus;

        public static /* synthetic */ PollingResult copy$default(PollingResult r100, String r101, String r102, String r103, double r104, int r105, Object r110) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.fileToken;
        L6:
            if ((r105 & 2) == 0) goto L8;
            r102 = r100.fileName;
        L8:
            String r111 = r102;
            if ((r105 & 4) == 0) goto L11;
            r103 = r100.fileExtension;
        L11:
            String r106 = r103;
            if ((r105 & 8) == 0) goto L14;
            r104 = r100.jobStatus;
        L14:
            String r107 = r101;
            return r100.copy(r107, r111, r106, r104);
        }

        public final String component1() {
            return this.fileToken;
        }

        public final String component2() {
            return this.fileName;
        }

        public final String component3() {
            return this.fileExtension;
        }

        public final double component4() {
            return this.jobStatus;
        }

        public final PollingResult copy(String r100, String r101, String r110, double r111) {
            Intrinsics.checkNotNullParameter(r100, "fileToken");
            Intrinsics.checkNotNullParameter(r101, "fileName");
            Intrinsics.checkNotNullParameter(r110, "fileExtension");
            return new PollingResult(r100, r101, r110, r111);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PollingResult) == true) goto L8;
            return false;
        L8:
            PollingResult r101 = (PollingResult) r100;
            if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileExtension, r101.fileExtension) == true) goto L18;
            return false;
        L18:
            if (Double.compare(this.jobStatus, r101.jobStatus) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = ((((this.fileToken.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.fileExtension.hashCode()) * 31;
            long r101 = Double.doubleToLongBits(this.jobStatus);
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public String toString() {
            return "PollingResult(fileToken=" + this.fileToken + ", fileName=" + this.fileName + ", fileExtension=" + this.fileExtension + ", jobStatus=" + this.jobStatus + ')';
        }

        public final String getFileExtension() {
            return this.fileExtension;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getFileToken() {
            return this.fileToken;
        }

        public final double getJobStatus() {
            return this.jobStatus;
        }

        public PollingResult(String r100, String r101, String r102, double r103) {
            Intrinsics.checkNotNullParameter(r100, "fileToken");
            Intrinsics.checkNotNullParameter(r101, "fileName");
            Intrinsics.checkNotNullParameter(r102, "fileExtension");
            this.fileToken = r100;
            this.fileName = r101;
            this.fileExtension = r102;
            this.jobStatus = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus;", "", "()V", "Completed", "Continue", "Failed", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus$Completed;", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus$Continue;", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus$Failed;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class PollingStatus {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus$Completed;", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus;", "()V", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Completed extends PollingStatus {
            public static final Completed INSTANCE = null;

            static {
                INSTANCE = new Completed();
            }

            private Completed() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus$Continue;", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus;", "()V", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Continue extends PollingStatus {
            public static final Continue INSTANCE = null;

            static {
                INSTANCE = new Continue();
            }

            private Continue() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus$Failed;", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingStatus;", "()V", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Failed extends PollingStatus {
            public static final Failed INSTANCE = null;

            static {
                INSTANCE = new Failed();
            }

            private Failed() {
                super(null);
            }
        }

        private PollingStatus() {
        }

        public /* synthetic */ PollingStatus(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[IDriveTransferTask.EStatus.values().length];
            r100[IDriveTransferTask.EStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IDriveTransferTask.EStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IDriveTransferTask.EStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.docsdk.impl.export.ExportManager$fetchPollingResult$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.bytedance.ee.docsdk.impl.export.ExportManager$fetchPollingResult$2", f = "ExportManager.kt", i = {}, l = {577}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $ticket;
        final /* synthetic */ String $token;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(String r100, String r101, Continuation<? super AnonymousClass2> r102) {
            this.$ticket = r100;
            this.$token = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$ticket, this.$token, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            String r103 = (String) this.L$1;
            String r104 = (String) this.L$0;
            ResultKt.throwOnFailure(r100);
        L13:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            String r105 = this.$ticket;
            String r106 = this.$token;
            this.L$0 = r105;
            this.L$1 = r106;
            this.label = 1;
            final j r107 = new j(IntrinsicsKt.intercepted(this), 1);
            r107.C();
            ExportManager.access$sendGetRequestForExportResult(ExportManager.INSTANCE, r105, r106, new ExportManager$fetchPollingResult$2$1$1(r107));
            r100 = r107.B();
            if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r100 != r101) goto L13;
            return r101;
        }
    }

    private ExportManager() {
    }

    public static /* synthetic */ void a(IDownloadResult r100, String r101, gr5.a r102, Ref.ObjectRef r103, String r104, IDriveTransferTask.EStatus r105) {
        downloadFileWithDriveSdk$lambda$7$lambda$6$lambda$5(r100, r101, r102, r103, r104, r105);
    }

    static {
        INSTANCE = new ExportManager();
        exportJobs = new ConcurrentHashMap();
        pollingJobs = new ConcurrentHashMap();
        downloadTasks = new ConcurrentHashMap();
    }

    private final Map<String, String> buildRequestHeaders() {
        return MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json"));
    }

    @Override // com.bytedance.ee.docsdk.impl.export.IFileExportService
    public void cancelAllExports() {
        StringBuilder r100 = new StringBuilder("cancelAllExports: count exportJobs：");
        ConcurrentHashMap<String, Job> r101 = exportJobs;
        r100.append(r101.size());
        r100.append(" pollingJobs：");
        r100.append(pollingJobs.size());
        r100.append(" downloadTasks：");
        r100.append(downloadTasks.size());
        Log.i(TAG, r100.toString());
        Iterator<Job> r102 = r101.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default(r102.next(), null, 1, null);
        goto L4
    L6:
        Iterator<Job> r103 = pollingJobs.values().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Job.DefaultImpls.cancel$default(r103.next(), null, 1, null);
        goto L8
    L10:
        ConcurrentHashMap<String, gr5.a> r104 = downloadTasks;
        Iterator<gr5.a> r105 = r104.values().iterator();
        if (r105.hasNext() == true) goto L14;
        exportJobs.clear();
        pollingJobs.clear();
        r104.clear();
        return;
    L14:
        gr5.a r106 = r105.next();
        int r107 = fr5.a.f478611a;
        Intrinsics.throwUninitializedPropertyAccessException("transferManager");
        r106.getTaskId();
        throw null;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getExportJobs$p() {
        return exportJobs;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPollingJobs$p() {
        return pollingJobs;
    }

    public static final /* synthetic */ Map access$buildRequestHeaders(ExportManager r100) {
        return r100.buildRequestHeaders();
    }

    private final String buildRequestBody(ExportRequest r100) {
        ExportRequestBody r101 = new ExportRequestBody(r100.getToken(), r100.getType(), r100.getFormat(), r100.getEventSource());     // Catch: Exception -> L4
        return new Gson().toJson(r101);
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to build request body", e);
        return null;
    }

    @Override // com.bytedance.ee.docsdk.impl.export.IFileExportService
    public boolean cancelExport(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Job r101 = exportJobs.get(r100);
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        Unit r102 = Unit.INSTANCE;
    L7:
        if (r102 != null) goto L9;
        Log.i(TAG, "cancel exportJobs  - token:" + r100 + " not found");
    L9:
        Job r103 = pollingJobs.get(r100);
        if (r103 == null) goto L12;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        Unit r104 = Unit.INSTANCE;
    L13:
        if (r104 != null) goto L15;
        Log.i(TAG, "cancel pollingJobs  - token:" + r100 + " not found");
    L15:
        gr5.a r105 = downloadTasks.get(r100);
        if (r105 != null) goto L19;
        Log.i(TAG, "cancel downloadTasks  - token:" + r100 + " not found");
        return true;
    L19:
        int r106 = fr5.a.f478611a;
        Intrinsics.throwUninitializedPropertyAccessException("transferManager");
        r105.getTaskId();
        throw null;
    L12:
        r104 = null;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public static final /* synthetic */ String access$buildRequestBody(ExportManager r100, ExportRequest r101) {
        return r100.buildRequestBody(r101);
    }

    private final void handleHttpError(int r100, IDownloadResult r101) {
        Log.e(TAG, "Export request returned non-success code: " + r100);
        if (r101 == null) goto L6;
        r101.onFail(r100, ERROR_HTTP_ERROR_CODE_PREFIX + r100);
        return;
    }

    private final void handlePollingTimeout(int r100, IDownloadResult r101) {
        String r102 = ERROR_EXPORT_TIMEOUT_PREFIX + r100 + " seconds";
        Log.e(TAG, r102);
        if (r101 == null) goto L6;
        r101.onFail(-1, r102);
        return;
    }

    private final boolean validateExportRequest(ExportRequest r100, IDownloadResult r101) {
        if (StringsKt.isBlank(r100.getToken()) == false) goto L9;
        Log.e(TAG, "Export failed: token is empty");
        if (r101 == null) goto L11;
        r101.onFail(-1, "Token cannot be empty");
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static final /* synthetic */ void access$handleHttpError(ExportManager r100, int r101, IDownloadResult r102) {
        r100.handleHttpError(r101, r102);
    }

    public static final /* synthetic */ void access$handlePollingTimeout(ExportManager r100, int r101, IDownloadResult r102) {
        r100.handlePollingTimeout(r101, r102);
    }

    public static final /* synthetic */ boolean access$validateExportRequest(ExportManager r100, ExportRequest r101, IDownloadResult r102) {
        return r100.validateExportRequest(r101, r102);
    }

    private final INetCallback createExportCallback(final String r100, final ExportRequest r101, final IDownloadResult r102) {
        return new AnonymousClass1(r100, r101, r102);
    }

    private final void exportDocument(String r100, final ExportRequest r101, IDownloadResult r110) {
        cancelExport(r101.getToken());
        Job r102 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ExportManager$exportDocument$job$1(r101, r110, r100, null), 2, null);
        exportJobs.put(r101.getToken(), r102);
        r102.invokeOnCompletion(new C105411(r101));
    }

    private final Object fetchPollingResult(String r100, String r101, Continuation<? super String> r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r100, r101, null), r102);
    }

    private final void handleNetworkError(int r100, String r101, IDownloadResult r102) {
        Log.e(TAG, "Export request failed: errorCode=" + r100);
        if (r102 == null) goto L6;
        r102.onFail(r100, ERROR_NETWORK_PREFIX + r100 + ", " + r101);
        return;
    }

    private final void sendGetRequestForExportResult(String r100, String r101, INetCallback r102) {
        String r103 = EXPORT_RESULT_URL + r100 + "?token=" + r101 + "&type=slides";     // Catch: Exception -> L5
        Map<String, String> r104 = buildRequestHeaders();     // Catch: Exception -> L5
        Log.d(TAG, "Sending GET request to: " + r103);     // Catch: Exception -> L5
        NetService.INSTANCE.httpGet(r103, r104, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Error preparing GET request", e);
        r102.onFailure(-1, "Failed to prepare GET request: " + e.getMessage());
    }

    public static final /* synthetic */ INetCallback access$createExportCallback(ExportManager r100, String r101, ExportRequest r102, IDownloadResult r103) {
        return r100.createExportCallback(r101, r102, r103);
    }

    public static final /* synthetic */ Object access$fetchPollingResult(ExportManager r100, String r101, String r102, Continuation r103) {
        return r100.fetchPollingResult(r101, r102, r103);
    }

    public static final /* synthetic */ void access$handleNetworkError(ExportManager r100, int r101, String r102, IDownloadResult r103) {
        r100.handleNetworkError(r101, r102, r103);
    }

    public static final /* synthetic */ void access$sendGetRequestForExportResult(ExportManager r100, String r101, String r102, INetCallback r103) {
        r100.sendGetRequestForExportResult(r101, r102, r103);
    }

    private final void downloadFileWithDriveSdk(String r100, String r101, IDownloadResult r102, String r103) {
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L19;
        Log.e(TAG, "DOWNLOAD_FAILED - empty file token");
        if (r102 == null) goto L21;
        r102.onFail(-1, "Empty file token");
        return;
    L21:
        return;
    L19:
        int r105 = fr5.a.f478611a;     // Catch: Exception -> L14
        Intrinsics.throwUninitializedPropertyAccessException("transferManager");     // Catch: Exception -> L14
        int r106 = DriveDownloadRequest.f242664e;     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r100, "fileToken");     // Catch: Exception -> L14
        DriveDownloadRequest r107 = new DriveDownloadRequest();     // Catch: Exception -> L14
        r107.f242665a = null;     // Catch: Exception -> L14
        r107.f242666b = r100;     // Catch: Exception -> L14
        r107.f242668d = r101;     // Catch: Exception -> L14
        throw null;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "DriveSDK download failed: " + e.getMessage());
        if (r102 == null) goto L22;
        r102.onFail(-1, e.getMessage());
        return;
    L22:
        return;
    L5:
        r104 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [T, com.bytedance.ee.docsdk.impl.export.a] */
    private static final void downloadFileWithDriveSdk$lambda$7$lambda$6(final gr5.a r100, final IDownloadResult r101, final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "$task");
        Intrinsics.checkNotNullParameter(r110, "$saveFilePath");
        Intrinsics.checkNotNullParameter(r111, "$token");
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = new a(r101, r110, r100, r102, r111);
        LiveData<IDriveTransferTask.EStatus> r103 = r100.getStatusLiveData();
        T r104 = r102.element;
        if (r104 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        Observer<? super IDriveTransferTask.EStatus> r105 = null;
    L6:
        r103.observeForever(r105);
        return;
    L5:
        r105 = (Observer) r104;
        goto L6
    }

    private final void handleExportSuccess(PollingResponse r100, String r101, IDownloadResult r102, String r103) {
        PollingData r104 = r100.getData();
        if (r104 == null) goto L5;
        PollingResult r105 = r104.getResult();
    L6:
        if (r105 == null) goto L9;
        String r106 = r105.getFileToken();
        if (r106 == null) goto L9;
    L10:
        if (r105 == null) goto L13;
        String r107 = r105.getFileName();
        if (r107 == null) goto L13;
    L14:
        if (r105 == null) goto L17;
        String r108 = r105.getFileExtension();
        if (r108 == null) goto L17;
    L18:
        Log.d(TAG, "Retrieved file_token: ".concat(r106));
        String r109 = ExternalStorageUtils.getUniqueFileNameWithNumber(r101, r107 + '.' + r108);
        StringBuilder r110 = new StringBuilder();
        r110.append(r101);
        r110.append(r109);
        downloadFileWithDriveSdk(r106, r110.toString(), r102, r103);
        return;
    L17:
        r108 = ExportFileExtension.PDF;
    L13:
        r107 = "document";
    L9:
        r106 = "";
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    private final void handleExportSuccessResponse(String r100, String r101, ExportRequest r102, IDownloadResult r110) {
        if (r100 != null) goto L27;
        Log.e(TAG, "Null response received");
        if (r110 == null) goto L28;
        r110.onFail(-1, "Null response");
        return;
    L28:
        return;
    L27:
        ExportResult r103 = (ExportResult) new Gson().fromJson(r100, ExportResult.class);     // Catch: Exception -> L22
        if (r103.getCode() != 0) goto L15;
        StringBuilder r104 = new StringBuilder("Export task created successfully, taskId=");     // Catch: Exception -> L22
        ExportData r105 = r103.getData();     // Catch: Exception -> L22
        if (r105 == null) goto L13;
        String r106 = r105.getTaskId();     // Catch: Exception -> L22
    L14:
        r104.append(r106);     // Catch: Exception -> L22
        Log.d(TAG, r104.toString());     // Catch: Exception -> L22
        startPollingIfValid(r103, r101, r102, r110);     // Catch: Exception -> L22
        return;
    L13:
        r106 = null;
        goto L14
    L15:
        String r107 = r103.getMessage();     // Catch: Exception -> L22
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        Log.e(TAG, "Export task creation failed with code: " + r103.getCode() + ", message: " + r107);     // Catch: Exception -> L22
        if (r110 == null) goto L30;
        r110.onFail(r103.getCode(), r107);     // Catch: Exception -> L22
        return;
    L30:
        return;
    L22:
        e = move-exception;
        Log.e(TAG, "Failed to parse export response", e);
        if (r110 == null) goto L31;
        r110.onFail(-1, "Failed to parse export response");
        return;
    }

    private final PollingStatus processPollingResponse(String r100, String r110, IDownloadResult r111, String r112) {
        PollingResponse r101 = (PollingResponse) new Gson().fromJson(r100, PollingResponse.class);     // Catch: Exception -> L22
        PollingData r102 = r101.getData();     // Catch: Exception -> L22
        if (r102 == null) goto L8;
        PollingResult r103 = r102.getResult();     // Catch: Exception -> L22
        if (r103 == null) goto L8;
        double r104 = r103.getJobStatus();     // Catch: Exception -> L22
    L10:
        if (((int) r104) != 0) goto L14;
        Log.i(TAG, "POLLING_COMPLETE_SUCCESS - export completed");     // Catch: Exception -> L22
        handleExportSuccess(r101, r110, r111, r112);     // Catch: Exception -> L22
        return PollingStatus.Completed.INSTANCE;
    L14:
        if (r104 <= 2.0d) goto L20;
        String r105 = ERROR_EXPORT_FAILED_PREFIX + r104;     // Catch: Exception -> L22
        Log.e(TAG, "POLLING_COMPLETE_FAILED - " + r105);     // Catch: Exception -> L22
        if (r111 == null) goto L19;
        r111.onFail(-1, r105);     // Catch: Exception -> L22
    L19:
        return PollingStatus.Failed.INSTANCE;
    L20:
        Log.i(TAG, "POLLING_CONTINUE - job_status: " + r104);     // Catch: Exception -> L22
        return PollingStatus.Continue.INSTANCE;
    L8:
        r104 = 3.0d;
    L22:
        e = move-exception;
        Log.e(TAG, "Failed to parse poll response", e);
        if (r111 == null) goto L27;
        r111.onFail(-1, e.getMessage());
    L27:
        return PollingStatus.Failed.INSTANCE;
    }

    private final void startPollingIfValid(ExportResult r100, String r101, ExportRequest r110, IDownloadResult r111) {
        ExportData r102 = r100.getData();
        if (r102 == null) goto L6;
        String r103 = r102.getTicket();
        if (r103 == null) goto L6;
    L7:
        String r104 = r103;
        ExportData r105 = r100.getData();
        if (r105 == null) goto L12;
        Integer r106 = r105.getJobTimeout();
        if (r106 == null) goto L12;
        int r107 = r106.intValue();
    L14:
        if ((!StringsKt.isBlank(r104)) == true) goto L16;
    L18:
        Log.w(TAG, "No ticket found in response");
        if (r111 == null) goto L23;
        r111.onFail(-1, "No ticket found in response");
        return;
    L23:
        return;
    L16:
        if ((!StringsKt.isBlank(r110.getToken())) == false) goto L18;
        Log.d(TAG, "Starting polling with ticket: ".concat(r104));
        pollExportResult(r101, r104, r110.getToken(), r107, r111);
        return;
    L12:
        r107 = 600;
    L6:
        r103 = "";
        goto L7
    }

    public static final /* synthetic */ void access$handleExportSuccessResponse(ExportManager r100, String r101, String r102, ExportRequest r103, IDownloadResult r104) {
        r100.handleExportSuccessResponse(r101, r102, r103, r104);
    }

    public static final /* synthetic */ PollingStatus access$processPollingResponse(ExportManager r100, String r101, String r102, IDownloadResult r103, String r104) {
        return r100.processPollingResponse(r101, r102, r103, r104);
    }

    private final void pollExportResult(String r110, String r111, final String r112, int r113, IDownloadResult r114) {
        Job r100 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ExportManager$pollExportResult$job$1(r113, r114, r111, r112, r110, null), 2, null);
        pollingJobs.put(r112, r100);
        r100.invokeOnCompletion(new C105421(r112));
    }

    private static final void downloadFileWithDriveSdk$lambda$7$lambda$6$lambda$5(IDownloadResult r100, String r101, gr5.a r102, Ref.ObjectRef r103, String r104, IDriveTransferTask.EStatus r110) {
        Intrinsics.checkNotNullParameter(r101, "$saveFilePath");
        Intrinsics.checkNotNullParameter(r102, "$task");
        Intrinsics.checkNotNullParameter(r103, "$observer");
        Intrinsics.checkNotNullParameter(r104, "$token");
        if (r110 != null) goto L5;
        int r105 = -1;
    L6:
        Observer<? super IDriveTransferTask.EStatus> r106 = null;
        if (r105 != 1) goto L9;
        if (r100 == null) goto L22;
        r100.onSuccess(r101);
    L22:
        LiveData<IDriveTransferTask.EStatus> r107 = r102.getStatusLiveData();
        T r108 = r103.element;
        if (r108 != 0) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
    L26:
        r107.removeObserver(r106);
        downloadTasks.remove(r104);
        return;
    L25:
        r106 = (Observer) r108;
        goto L26
    L9:
        if (r105 != 2) goto L11;
    L13:
        if (r100 == null) goto L15;
        r100.onFail(-1, "Download failed or stopped ,status:" + r110);
    L15:
        LiveData<IDriveTransferTask.EStatus> r109 = r102.getStatusLiveData();
        T r111 = r103.element;
        if (r111 != 0) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
    L19:
        r109.removeObserver(r106);
        downloadTasks.remove(r104);
        return;
    L18:
        r106 = (Observer) r111;
        goto L19
    L11:
        if (r105 == 3) goto L13;
        return;
    L5:
        r105 = WhenMappings.$EnumSwitchMapping$0[r110.ordinal()];
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.export.IFileExportService
    public void exportFile(String r100, String r101, String r102, String r103, int r104, IDownloadResult r105) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "fileExtension");
        Log.i(TAG, "exportFile");
        exportDocument(r101, new ExportRequest(r100, r102, r103, r104), r105);
    }
}
