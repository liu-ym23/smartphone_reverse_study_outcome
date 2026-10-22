package com.bytedance.ee.docsdk.impl.export;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.drive.model.transfer.IDriveTransferTask;
import com.bytedance.ee.drive.model.transfer.download.DriveDownloadRequest;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.idependency.INetCallback;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.NetService;
import com.ss.android.lark.chameleon.util.ExternalStorageUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014J\\\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "", "exportId", "", "taskId", "status", "downloadUrl", "expiredAt", "", "ticket", "jobTimeout", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getDownloadUrl", "()Ljava/lang/String;", "getExpiredAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExportId", "getJobTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getTaskId", "getTicket", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

        public static /* synthetic */ ExportData copy$default(ExportData r5, String r6, String r7, String r8, String r9, Long r10, String r11, Integer r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.exportId;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.taskId;
        L8:
            String r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.status;
        L11:
            String r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.downloadUrl;
        L14:
            String r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.expiredAt;
        L17:
            Long r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.ticket;
        L20:
            String r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.jobTimeout;
        L23:
            String r16 = r6;
            return r5.copy(r16, r15, r0, r1, r2, r3, r12);
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

        public final ExportData copy(String r10, String r11, String r12, String r13, Long r14, String r15, Integer r16) {
            Intrinsics.checkNotNullParameter(r10, "exportId");
            Intrinsics.checkNotNullParameter(r11, "taskId");
            Intrinsics.checkNotNullParameter(r12, "status");
            return new ExportData(r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExportData) == true) goto L8;
            return false;
        L8:
            ExportData r6 = (ExportData) r5;
            if (Intrinsics.areEqual(this.exportId, r6.exportId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.status, r6.status) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.downloadUrl, r6.downloadUrl) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.expiredAt, r6.expiredAt) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.ticket, r6.ticket) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.jobTimeout, r6.jobTimeout) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.exportId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.status.hashCode()) * 31;
            String r1 = this.downloadUrl;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Long r5 = this.expiredAt;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.ticket;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.jobTimeout;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
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

        public ExportData(String r2, String r3, String r4, String r5, Long r6, String r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r2, "exportId");
            Intrinsics.checkNotNullParameter(r3, "taskId");
            Intrinsics.checkNotNullParameter(r4, "status");
            this.exportId = r2;
            this.taskId = r3;
            this.status = r4;
            this.downloadUrl = r5;
            this.expiredAt = r6;
            this.ticket = r7;
            this.jobTimeout = r8;
        }

        public /* synthetic */ ExportData(String r11, String r12, String r13, String r14, Long r15, String r16, Integer r17, int r18, DefaultConstructorMarker r19) {
            if ((r18 & 8) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r18 & 16) == 0) goto L9;
            Long r7 = null;
        L11:
            if ((r18 & 32) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r18 & 64) == 0) goto L17;
            Integer r9 = null;
        L18:
            this(r11, r12, r13, r6, r7, r8, r9);
            return;
        L17:
            r9 = r17;
            goto L18
        L13:
            r8 = r16;
            goto L15
        L9:
            r7 = r15;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportRequest;", "", "token", "", "type", "format", "eventSource", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEventSource", "()I", "getFormat", "()Ljava/lang/String;", "getToken", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExportRequest {
        private final int eventSource;
        private final String format;
        private final String token;
        private final String type;

        public static /* synthetic */ ExportRequest copy$default(ExportRequest r0, String r1, String r2, String r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.token;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.type;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.format;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.eventSource;
        L15:
            return r0.copy(r1, r2, r3, r4);
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

        public final ExportRequest copy(String r2, String r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "format");
            return new ExportRequest(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExportRequest) == true) goto L8;
            return false;
        L8:
            ExportRequest r6 = (ExportRequest) r5;
            if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.format, r6.format) == true) goto L18;
            return false;
        L18:
            if (this.eventSource == r6.eventSource) goto L20;
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

        public ExportRequest(String r2, String r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "format");
            this.token = r2;
            this.type = r3;
            this.format = r4;
            this.eventSource = r5;
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

        public static /* synthetic */ ExportRequestBody copy$default(ExportRequestBody r0, String r1, String r2, String r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.token;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.type;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.fileExtension;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.eventSource;
        L15:
            return r0.copy(r1, r2, r3, r4);
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

        public final ExportRequestBody copy(String r2, String r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "fileExtension");
            return new ExportRequestBody(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExportRequestBody) == true) goto L8;
            return false;
        L8:
            ExportRequestBody r6 = (ExportRequestBody) r5;
            if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileExtension, r6.fileExtension) == true) goto L18;
            return false;
        L18:
            if (this.eventSource == r6.eventSource) goto L20;
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

        public ExportRequestBody(String r2, String r3, String r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "fileExtension");
            this.token = r2;
            this.type = r3;
            this.fileExtension = r4;
            this.eventSource = r5;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportResult;", "", "code", "", "message", "", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "(ILjava/lang/String;Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;)V", "getCode", "()I", "getData", "()Lcom/bytedance/ee/docsdk/impl/export/ExportManager$ExportData;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ExportResult {
        private final int code;
        private final ExportData data;
        private final String message;

        public static /* synthetic */ ExportResult copy$default(ExportResult r0, int r1, String r2, ExportData r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.code;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.message;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.data;
        L12:
            return r0.copy(r1, r2, r3);
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

        public final ExportResult copy(int r2, String r3, ExportData r4) {
            return new ExportResult(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ExportResult) == true) goto L8;
            return false;
        L8:
            ExportResult r6 = (ExportResult) r5;
            if (this.code == r6.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.code * 31;
            String r1 = this.message;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ExportData r5 = this.data;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
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

        public ExportResult(int r1, String r2, ExportData r3) {
            this.code = r1;
            this.message = r2;
            this.data = r3;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;", "", "result", "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;", "(Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;)V", "getResult", "()Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PollingData {
        private final PollingResult result;

        public static /* synthetic */ PollingData copy$default(PollingData r0, PollingResult r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.result;
        L6:
            return r0.copy(r1);
        }

        public final PollingResult component1() {
            return this.result;
        }

        public final PollingData copy(PollingResult r2) {
            return new PollingData(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof PollingData) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.result, ((PollingData) r4).result) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            PollingResult r0 = this.result;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "PollingData(result=" + this.result + ')';
        }

        public final PollingResult getResult() {
            return this.result;
        }

        public PollingData(PollingResult r1) {
            this.result = r1;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingResponse;", "", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;", "(Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;)V", "getData", "()Lcom/bytedance/ee/docsdk/impl/export/ExportManager$PollingData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PollingResponse {
        private final PollingData data;

        public static /* synthetic */ PollingResponse copy$default(PollingResponse r0, PollingData r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final PollingData component1() {
            return this.data;
        }

        public final PollingResponse copy(PollingData r2) {
            return new PollingResponse(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof PollingResponse) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((PollingResponse) r4).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            PollingData r0 = this.data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "PollingResponse(data=" + this.data + ')';
        }

        public final PollingData getData() {
            return this.data;
        }

        public PollingResponse(PollingData r1) {
            this.data = r1;
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

        public static /* synthetic */ PollingResult copy$default(PollingResult r3, String r4, String r5, String r6, double r7, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.fileToken;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.fileName;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.fileExtension;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.jobStatus;
        L14:
            String r8 = r4;
            return r3.copy(r8, r11, r0, r7);
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

        public final PollingResult copy(String r8, String r9, String r10, double r11) {
            Intrinsics.checkNotNullParameter(r8, "fileToken");
            Intrinsics.checkNotNullParameter(r9, "fileName");
            Intrinsics.checkNotNullParameter(r10, "fileExtension");
            return new PollingResult(r8, r9, r10, r11);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof PollingResult) == true) goto L8;
            return false;
        L8:
            PollingResult r9 = (PollingResult) r8;
            if (Intrinsics.areEqual(this.fileToken, r9.fileToken) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileExtension, r9.fileExtension) == true) goto L18;
            return false;
        L18:
            if (Double.compare(this.jobStatus, r9.jobStatus) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.fileToken.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.fileExtension.hashCode()) * 31;
            long r1 = Double.doubleToLongBits(this.jobStatus);
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
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

        public PollingResult(String r2, String r3, String r4, double r5) {
            Intrinsics.checkNotNullParameter(r2, "fileToken");
            Intrinsics.checkNotNullParameter(r3, "fileName");
            Intrinsics.checkNotNullParameter(r4, "fileExtension");
            this.fileToken = r2;
            this.fileName = r3;
            this.fileExtension = r4;
            this.jobStatus = r5;
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

        public /* synthetic */ PollingStatus(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[IDriveTransferTask.EStatus.values().length];
            r0[IDriveTransferTask.EStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IDriveTransferTask.EStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IDriveTransferTask.EStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
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

        public AnonymousClass2(String r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.$ticket = r1;
            this.$token = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$ticket, this.$token, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r6);
        L13:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            String r7 = this.$ticket;
            String r4 = this.$token;
            this.L$0 = r7;
            this.L$1 = r4;
            this.label = 1;
            final j r5 = new j(IntrinsicsKt.intercepted(this), 1);
            r5.C();
            ExportManager.access$sendGetRequestForExportResult(ExportManager.INSTANCE, r7, r4, new ExportManager$fetchPollingResult$2$1$1(r5));
            r6 = r5.B();
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    private ExportManager() {
    }

    public static /* synthetic */ void a(IDownloadResult r0, String r1, gr5.a r2, Ref.ObjectRef r3, String r4, IDriveTransferTask.EStatus r5) {
        downloadFileWithDriveSdk$lambda$7$lambda$6$lambda$5(r0, r1, r2, r3, r4, r5);
    }

    static {
        INSTANCE = new ExportManager();
        exportJobs = new ConcurrentHashMap();
        pollingJobs = new ConcurrentHashMap();
        downloadTasks = new ConcurrentHashMap();
    }

    private final Map<String, String> buildRequestHeaders() {
        return MapsKt.mapOf(TuplesKt.to(HEADER_CONTENT_TYPE, "application/json"));
    }

    @Override // com.bytedance.ee.docsdk.impl.export.IFileExportService
    public void cancelAllExports() {
        StringBuilder r0 = new StringBuilder("cancelAllExports: count exportJobs：");
        ConcurrentHashMap<String, Job> r1 = exportJobs;
        r0.append(r1.size());
        r0.append(" pollingJobs：");
        r0.append(pollingJobs.size());
        r0.append(" downloadTasks：");
        r0.append(downloadTasks.size());
        Log.i(TAG, r0.toString());
        Iterator<Job> r2 = r1.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default(r2.next(), null, 1, null);
        goto L4
    L6:
        Iterator<Job> r3 = pollingJobs.values().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Job.DefaultImpls.cancel$default(r3.next(), null, 1, null);
        goto L8
    L10:
        ConcurrentHashMap<String, gr5.a> r4 = downloadTasks;
        Iterator<gr5.a> r5 = r4.values().iterator();
        if (r5.hasNext() == true) goto L14;
        exportJobs.clear();
        pollingJobs.clear();
        r4.clear();
        return;
    L14:
        gr5.a r6 = r5.next();
        int r7 = fr5.a.a;
        Intrinsics.throwUninitializedPropertyAccessException("transferManager");
        r6.getTaskId();
        throw null;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getExportJobs$p() {
        return exportJobs;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPollingJobs$p() {
        return pollingJobs;
    }

    public static final /* synthetic */ Map access$buildRequestHeaders(ExportManager r0) {
        return r0.buildRequestHeaders();
    }

    private final String buildRequestBody(ExportRequest r5) {
        ExportRequestBody r0 = new ExportRequestBody(r5.getToken(), r5.getType(), r5.getFormat(), r5.getEventSource());     // Catch: Exception -> L4
        return new Gson().toJson(r0);
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to build request body", e);
        return null;
    }

    @Override // com.bytedance.ee.docsdk.impl.export.IFileExportService
    public boolean cancelExport(String r7) {
        Intrinsics.checkNotNullParameter(r7, "token");
        Job r0 = exportJobs.get(r7);
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        Unit r1 = Unit.INSTANCE;
    L7:
        if (r1 != null) goto L9;
        Log.i(TAG, "cancel exportJobs  - token:" + r7 + " not found");
    L9:
        Job r2 = pollingJobs.get(r7);
        if (r2 == null) goto L12;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        Unit r3 = Unit.INSTANCE;
    L13:
        if (r3 != null) goto L15;
        Log.i(TAG, "cancel pollingJobs  - token:" + r7 + " not found");
    L15:
        gr5.a r4 = downloadTasks.get(r7);
        if (r4 != null) goto L19;
        Log.i(TAG, "cancel downloadTasks  - token:" + r7 + " not found");
        return true;
    L19:
        int r8 = fr5.a.a;
        Intrinsics.throwUninitializedPropertyAccessException("transferManager");
        r4.getTaskId();
        throw null;
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public static final /* synthetic */ String access$buildRequestBody(ExportManager r0, ExportRequest r1) {
        return r0.buildRequestBody(r1);
    }

    private final void handleHttpError(int r3, IDownloadResult r4) {
        Log.e(TAG, "Export request returned non-success code: " + r3);
        if (r4 == null) goto L6;
        r4.onFail(r3, ERROR_HTTP_ERROR_CODE_PREFIX + r3);
        return;
    }

    private final void handlePollingTimeout(int r3, IDownloadResult r4) {
        String r5 = ERROR_EXPORT_TIMEOUT_PREFIX + r3 + " seconds";
        Log.e(TAG, r5);
        if (r4 == null) goto L6;
        r4.onFail(-1, r5);
        return;
    }

    private final boolean validateExportRequest(ExportRequest r2, IDownloadResult r3) {
        if (StringsKt.isBlank(r2.getToken()) == false) goto L9;
        Log.e(TAG, "Export failed: token is empty");
        if (r3 == null) goto L11;
        r3.onFail(-1, "Token cannot be empty");
        return false;
    L11:
        return false;
    L9:
        return true;
    }

    public static final /* synthetic */ void access$handleHttpError(ExportManager r0, int r1, IDownloadResult r2) {
        r0.handleHttpError(r1, r2);
    }

    public static final /* synthetic */ void access$handlePollingTimeout(ExportManager r0, int r1, IDownloadResult r2) {
        r0.handlePollingTimeout(r1, r2);
    }

    public static final /* synthetic */ boolean access$validateExportRequest(ExportManager r0, ExportRequest r1, IDownloadResult r2) {
        return r0.validateExportRequest(r1, r2);
    }

    private final INetCallback createExportCallback(final String r2, final ExportRequest r3, final IDownloadResult r4) {
        return new AnonymousClass1(r2, r3, r4);
    }

    private final void exportDocument(String r8, final ExportRequest r9, IDownloadResult r10) {
        cancelExport(r9.getToken());
        Job r11 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ExportManager$exportDocument$job$1(r9, r10, r8, null), 2, null);
        exportJobs.put(r9.getToken(), r11);
        r11.invokeOnCompletion(new C03571(r9));
    }

    private final Object fetchPollingResult(String r4, String r5, Continuation<? super String> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, r5, null), r6);
    }

    private final void handleNetworkError(int r3, String r4, IDownloadResult r5) {
        Log.e(TAG, "Export request failed: errorCode=" + r3);
        if (r5 == null) goto L6;
        r5.onFail(r3, ERROR_NETWORK_PREFIX + r3 + ", " + r4);
        return;
    }

    private final void sendGetRequestForExportResult(String r5, String r6, INetCallback r7) {
        String r8 = EXPORT_RESULT_URL + r5 + "?token=" + r6 + "&type=slides";     // Catch: Exception -> L5
        Map<String, String> r9 = buildRequestHeaders();     // Catch: Exception -> L5
        Log.d(TAG, "Sending GET request to: " + r8);     // Catch: Exception -> L5
        NetService.INSTANCE.httpGet(r8, r9, r7);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Error preparing GET request", e);
        r7.onFailure(-1, "Failed to prepare GET request: " + e.getMessage());
    }

    public static final /* synthetic */ INetCallback access$createExportCallback(ExportManager r0, String r1, ExportRequest r2, IDownloadResult r3) {
        return r0.createExportCallback(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$fetchPollingResult(ExportManager r0, String r1, String r2, Continuation r3) {
        return r0.fetchPollingResult(r1, r2, r3);
    }

    public static final /* synthetic */ void access$handleNetworkError(ExportManager r0, int r1, String r2, IDownloadResult r3) {
        r0.handleNetworkError(r1, r2, r3);
    }

    public static final /* synthetic */ void access$sendGetRequestForExportResult(ExportManager r0, String r1, String r2, INetCallback r3) {
        r0.sendGetRequestForExportResult(r1, r2, r3);
    }

    private final void downloadFileWithDriveSdk(String r4, String r5, IDownloadResult r6, String r7) {
        if (r4.length() != 0) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == false) goto L19;
        Log.e(TAG, "DOWNLOAD_FAILED - empty file token");
        if (r6 == null) goto L21;
        r6.onFail(-1, "Empty file token");
        return;
    L21:
        return;
    L19:
        int r9 = fr5.a.a;     // Catch: Exception -> L14
        Intrinsics.throwUninitializedPropertyAccessException("transferManager");     // Catch: Exception -> L14
        int r10 = DriveDownloadRequest.e;     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r4, "fileToken");     // Catch: Exception -> L14
        DriveDownloadRequest r11 = new DriveDownloadRequest();     // Catch: Exception -> L14
        r11.a = null;     // Catch: Exception -> L14
        r11.b = r4;     // Catch: Exception -> L14
        r11.d = r5;     // Catch: Exception -> L14
        throw null;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "DriveSDK download failed: " + e.getMessage());
        if (r6 == null) goto L22;
        r6.onFail(-1, e.getMessage());
        return;
    L22:
        return;
    L5:
        r8 = false;
        goto L7
    }

    private static final void downloadFileWithDriveSdk$lambda$7$lambda$6(final gr5.a r8, final IDownloadResult r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r8, "$task");
        Intrinsics.checkNotNullParameter(r10, "$saveFilePath");
        Intrinsics.checkNotNullParameter(r11, "$token");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new a(r9, r10, r8, r0, r11);
        LiveData r12 = r8.getStatusLiveData();
        Object r13 = r0.element;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        Observer r14 = null;
    L6:
        r12.observeForever(r14);
        return;
    L5:
        r14 = (Observer) r13;
        goto L6
    }

    private final void handleExportSuccess(PollingResponse r5, String r6, IDownloadResult r7, String r8) {
        PollingData r9 = r5.getData();
        if (r9 == null) goto L5;
        PollingResult r10 = r9.getResult();
    L6:
        if (r10 == null) goto L9;
        String r0 = r10.getFileToken();
        if (r0 == null) goto L9;
    L10:
        if (r10 == null) goto L13;
        String r1 = r10.getFileName();
        if (r1 == null) goto L13;
    L14:
        if (r10 == null) goto L17;
        String r11 = r10.getFileExtension();
        if (r11 == null) goto L17;
    L18:
        Log.d(TAG, "Retrieved file_token: ".concat(r0));
        String r12 = ExternalStorageUtils.getUniqueFileNameWithNumber(r6, r1 + '.' + r11);
        StringBuilder r2 = new StringBuilder();
        r2.append(r6);
        r2.append(r12);
        downloadFileWithDriveSdk(r0, r2.toString(), r7, r8);
        return;
    L17:
        r11 = ExportFileExtension.PDF;
    L13:
        r1 = "document";
    L9:
        r0 = "";
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    private final void handleExportSuccessResponse(String r7, String r8, ExportRequest r9, IDownloadResult r10) {
        if (r7 != null) goto L27;
        Log.e(TAG, "Null response received");
        if (r10 == null) goto L28;
        r10.onFail(-1, "Null response");
        return;
    L28:
        return;
    L27:
        ExportResult r11 = (ExportResult) new Gson().fromJson(r7, ExportResult.class);     // Catch: Exception -> L22
        if (r11.getCode() != 0) goto L15;
        StringBuilder r0 = new StringBuilder("Export task created successfully, taskId=");     // Catch: Exception -> L22
        ExportData r1 = r11.getData();     // Catch: Exception -> L22
        if (r1 == null) goto L13;
        String r2 = r1.getTaskId();     // Catch: Exception -> L22
    L14:
        r0.append(r2);     // Catch: Exception -> L22
        Log.d(TAG, r0.toString());     // Catch: Exception -> L22
        startPollingIfValid(r11, r8, r9, r10);     // Catch: Exception -> L22
        return;
    L13:
        r2 = null;
        goto L14
    L15:
        String r12 = r11.getMessage();     // Catch: Exception -> L22
        if (r12 != null) goto L18;
        r12 = "";
    L18:
        Log.e(TAG, "Export task creation failed with code: " + r11.getCode() + ", message: " + r12);     // Catch: Exception -> L22
        if (r10 == null) goto L30;
        r10.onFail(r11.getCode(), r12);     // Catch: Exception -> L22
        return;
    L30:
        return;
    L22:
        e = move-exception;
        Log.e(TAG, "Failed to parse export response", e);
        if (r10 == null) goto L31;
        r10.onFail(-1, "Failed to parse export response");
        return;
    }

    private final PollingStatus processPollingResponse(String r9, String r10, IDownloadResult r11, String r12) {
        PollingResponse r13 = (PollingResponse) new Gson().fromJson(r9, PollingResponse.class);     // Catch: Exception -> L22
        PollingData r5 = r13.getData();     // Catch: Exception -> L22
        if (r5 == null) goto L8;
        PollingResult r6 = r5.getResult();     // Catch: Exception -> L22
        if (r6 == null) goto L8;
        double r7 = r6.getJobStatus();     // Catch: Exception -> L22
    L10:
        if (((int) r7) != 0) goto L14;
        Log.i(TAG, "POLLING_COMPLETE_SUCCESS - export completed");     // Catch: Exception -> L22
        handleExportSuccess(r13, r10, r11, r12);     // Catch: Exception -> L22
        return PollingStatus.Completed.INSTANCE;
    L14:
        if (r7 <= 2.0d) goto L20;
        String r14 = ERROR_EXPORT_FAILED_PREFIX + r7;     // Catch: Exception -> L22
        Log.e(TAG, "POLLING_COMPLETE_FAILED - " + r14);     // Catch: Exception -> L22
        if (r11 == null) goto L19;
        r11.onFail(-1, r14);     // Catch: Exception -> L22
    L19:
        return PollingStatus.Failed.INSTANCE;
    L20:
        Log.i(TAG, "POLLING_CONTINUE - job_status: " + r7);     // Catch: Exception -> L22
        return PollingStatus.Continue.INSTANCE;
    L8:
        r7 = 3.0d;
    L22:
        e = move-exception;
        Log.e(TAG, "Failed to parse poll response", e);
        if (r11 == null) goto L27;
        r11.onFail(-1, e.getMessage());
    L27:
        return PollingStatus.Failed.INSTANCE;
    }

    private final void startPollingIfValid(ExportResult r8, String r9, ExportRequest r10, IDownloadResult r11) {
        ExportData r0 = r8.getData();
        if (r0 == null) goto L6;
        String r1 = r0.getTicket();
        if (r1 == null) goto L6;
    L7:
        String r3 = r1;
        ExportData r12 = r8.getData();
        if (r12 == null) goto L12;
        Integer r13 = r12.getJobTimeout();
        if (r13 == null) goto L12;
        int r5 = r13.intValue();
    L14:
        if ((!StringsKt.isBlank(r3)) == true) goto L16;
    L18:
        Log.w(TAG, "No ticket found in response");
        if (r11 == null) goto L23;
        r11.onFail(-1, "No ticket found in response");
        return;
    L23:
        return;
    L16:
        if ((!StringsKt.isBlank(r10.getToken())) == false) goto L18;
        Log.d(TAG, "Starting polling with ticket: ".concat(r3));
        pollExportResult(r9, r3, r10.getToken(), r5, r11);
        return;
    L12:
        r5 = DEFAULT_JOB_TIMEOUT;
    L6:
        r1 = "";
        goto L7
    }

    public static final /* synthetic */ void access$handleExportSuccessResponse(ExportManager r0, String r1, String r2, ExportRequest r3, IDownloadResult r4) {
        r0.handleExportSuccessResponse(r1, r2, r3, r4);
    }

    public static final /* synthetic */ PollingStatus access$processPollingResponse(ExportManager r0, String r1, String r2, IDownloadResult r3, String r4) {
        return r0.processPollingResponse(r1, r2, r3, r4);
    }

    private final void pollExportResult(String r13, String r14, final String r15, int r16, IDownloadResult r17) {
        Job r0 = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ExportManager$pollExportResult$job$1(r16, r17, r14, r15, r13, null), 2, null);
        pollingJobs.put(r15, r0);
        r0.invokeOnCompletion(new C03581(r15));
    }

    private static final void downloadFileWithDriveSdk$lambda$7$lambda$6$lambda$5(IDownloadResult r5, String r6, gr5.a r7, Ref.ObjectRef r8, String r9, IDriveTransferTask.EStatus r10) {
        Intrinsics.checkNotNullParameter(r6, "$saveFilePath");
        Intrinsics.checkNotNullParameter(r7, "$task");
        Intrinsics.checkNotNullParameter(r8, "$observer");
        Intrinsics.checkNotNullParameter(r9, "$token");
        if (r10 != null) goto L5;
        int r1 = -1;
    L6:
        Observer r3 = null;
        if (r1 != 1) goto L9;
        if (r5 == null) goto L22;
        r5.onSuccess(r6);
    L22:
        LiveData r11 = r7.getStatusLiveData();
        Object r12 = r8.element;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
    L26:
        r11.removeObserver(r3);
        downloadTasks.remove(r9);
        return;
    L25:
        r3 = (Observer) r12;
        goto L26
    L9:
        if (r1 != 2) goto L11;
    L13:
        if (r5 == null) goto L15;
        r5.onFail(-1, "Download failed or stopped ,status:" + r10);
    L15:
        LiveData r13 = r7.getStatusLiveData();
        Object r14 = r8.element;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("observer");
    L19:
        r13.removeObserver(r3);
        downloadTasks.remove(r9);
        return;
    L18:
        r3 = (Observer) r14;
        goto L19
    L11:
        if (r1 == 3) goto L13;
        return;
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        goto L6
    }

    @Override // com.bytedance.ee.docsdk.impl.export.IFileExportService
    public void exportFile(String r3, String r4, String r5, String r6, int r7, IDownloadResult r8) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "fileExtension");
        Log.i(TAG, "exportFile");
        exportDocument(r4, new ExportRequest(r3, r5, r6, r7), r8);
    }
}
