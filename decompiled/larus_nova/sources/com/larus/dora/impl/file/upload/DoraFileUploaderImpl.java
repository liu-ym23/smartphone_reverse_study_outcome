package com.larus.dora.impl.file.upload;

import android.os.SystemClock;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.file.DoraFileFetchTask;
import com.larus.dora.impl.file.DoraFileTaskStatus;
import com.larus.dora.impl.file.DoraFileType;
import com.larus.dora.impl.file.f;
import com.larus.dora.impl.file.i;
import com.larus.dora.impl.file.j;
import com.larus.dora.impl.file.record.DoraFileRecorder;
import com.optimize.statistics.FrescoMonitorConst;
import com.ttnetuploader.uploader.api.IUploadCallback;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ResultInfo;
import com.ttnetuploader.uploader.api.Uploader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraFileUploaderImpl implements com.larus.dora.impl.file.upload.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f335757e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f335758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Boolean f335759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f335760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f335761d;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f335762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f335763b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f335762a == r101.f335762a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f335763b, r101.f335763b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f335762a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f335763b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "UploadResult(isSuccess=" + this.f335762a + ", reason=" + this.f335763b + ')';
        }

        public b(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f335762a = r100;
            this.f335763b = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335764a = null;

        static {
            int[] r100 = new int[DoraFileType.values().length];
            r100[DoraFileType.CRASH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[DoraFileType.PERFORMANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[DoraFileType.LOG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[DoraFileType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f335764a = r100;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d implements IUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraFileUploaderTrigger f335765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<b> f335766b;

        @Override // com.ttnetuploader.uploader.api.IUploadCallback
        public final void onProgress(long r100, long r101, long r102, long r103) {
        }

        @Override // com.ttnetuploader.uploader.api.IUploadCallback
        public final void onFailed(ResultInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "uploadInfo");
            g49.d.b("DoraFileUploaderImpl", "uploadFileInternal: upload failed, code=" + r100.code + ", errorLog=" + r100.getUploadLog() + ", trigger=" + this.f335765a);
            CompletableDeferred<b> r101 = this.f335766b;
            StringBuilder r102 = new StringBuilder("uploadFailed(");
            r102.append(r100.code);
            r102.append(')');
            r101.complete(new b(false, r102.toString()));
        }

        @Override // com.ttnetuploader.uploader.api.IUploadCallback
        public final void onSuccess(ResultInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "uploadInfo");
            g49.d.d("DoraFileUploaderImpl", "uploadFileInternal: upload success, response=" + r100.getStringBody() + ", trigger=" + this.f335765a);     // Catch: Exception -> L5
            this.f335766b.complete(new b(true, "success"));     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            g49.d.c("DoraFileUploaderImpl", "uploadFileInternal: parse success response error, trigger=" + this.f335765a, e);
            this.f335766b.complete(new b(false, "uploadFailed(-1)"));
        }

        public d(DoraFileUploaderTrigger r100, CompletableDeferred<b> r101) {
            this.f335765a = r100;
            this.f335766b = r101;
        }
    }

    static {
    }

    public final boolean d() {
        Boolean r100 = this.f335759b;
        if (r100 != null) goto L7;
        boolean r101 = !AppHost.f326268a.a().isAppBackground();
        this.f335759b = Boolean.valueOf(r101);
        return r101;
    L7:
        return r100.booleanValue();
    }

    public DoraFileUploaderImpl(j r100) {
        Intrinsics.checkNotNullParameter(r100, "taskStore");
        this.f335758a = r100;
        this.f335761d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public final void c(DoraFileFetchTask r100, DoraFileUploaderTrigger r101) {
        g49.d.d("DoraFileUploaderImpl", "deleteTaskAndFile: task=" + r100.getId() + ", trigger=" + r101);     // Catch: Throwable -> L11
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getLocalPath());     // Catch: Throwable -> L11
        if (r102.exists() == false) goto L6;
        r102.delete();     // Catch: Throwable -> L11
    L6:
        i r103 = this.f335758a;     // Catch: Throwable -> L11
        String r104 = r100.getId();     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103.delete(r104);     // Catch: Throwable -> L11
        DoraFileRecorder.b(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        g49.d.c("DoraFileUploaderImpl", "deleteTaskAndFile: EXCEPTION file=" + r100.getFileName() + ", trigger=" + r101, th);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00d9 -> B:36:0x00dd). Please report as a decompilation issue!!! */
    public static final Object b(DoraFileUploaderImpl r100, DoraFileUploaderTrigger r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof DoraFileUploaderImpl$uploadAllReadyFiles$1) == false) goto L7;
        DoraFileUploaderImpl$uploadAllReadyFiles$1 r101 = (DoraFileUploaderImpl$uploadAllReadyFiles$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        DoraFileFetchTask r113 = (DoraFileFetchTask) r101.L$2;
        Iterator r105 = (Iterator) r101.L$1;
        DoraFileUploaderTrigger r106 = (DoraFileUploaderTrigger) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L37:
        if (((Boolean) r112).booleanValue() == false) goto L39;
        r100.c(r113, r106);
    L39:
        r110 = r106;
    L25:
        if (r105.hasNext() == false) goto L40;
        DoraFileFetchTask r114 = (DoraFileFetchTask) r105.next();
        if (r100.d() == true) goto L32;
        if (r100.f335760c == true) goto L32;
        g49.d.e("DoraFileUploaderImpl", "uploadAllReadyFiles: interrupt, appForeground=" + r100.f335759b + ", doraWakeup=" + r100.f335760c + ", from " + r110);
    L32:
        r101.L$0 = r110;
        r101.L$1 = r105;
        r101.L$2 = r114;
        r101.label = 1;
        Object r107 = r100.e(r114, r110, r101);
        if (r107 == r103) goto L51;
        r106 = r110;
        r113 = r114;
        r112 = r107;
        goto L37
    L51:
        return r103;
    L40:
        g49.d.d("DoraFileUploaderImpl", "uploadAllReadyFiles: end from " + r110);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        g49.d.d("DoraFileUploaderImpl", "uploadAllReadyFiles: start from " + r110);
        List<DoraFileFetchTask> r115 = r100.f335758a.c();
        ArrayList r108 = new ArrayList();
        Iterator<T> r116 = r115.iterator();
    L16:
        if (r116.hasNext() == false) goto L23;
        Object r109 = r116.next();
        if (((DoraFileFetchTask) r109).getStatus() != DoraFileTaskStatus.UPLOADING) goto L20;
        boolean r117 = true;
    L21:
        if (r117 == false) goto L16;
        r108.add(r109);
        goto L16
    L20:
        r117 = false;
        goto L21
    L23:
        r105 = r108.iterator();
    L7:
        r101 = new DoraFileUploaderImpl$uploadAllReadyFiles$1(r100, r111);
        goto L8
    }

    @Override // com.larus.dora.impl.file.upload.a
    public final Object a(DoraFileFetchTask r100, DoraFileUploaderTrigger r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof DoraFileUploaderImpl$upload$1) == false) goto L7;
        DoraFileUploaderImpl$upload$1 r103 = (DoraFileUploaderImpl$upload$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (DoraFileUploaderTrigger) r103.L$1;
        r100 = (DoraFileFetchTask) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        if (((Boolean) r105).booleanValue() == false) goto L27;
        c(r100, r101);
    L27:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (d() == false) goto L17;
    L20:
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = e(r100, r101, r103);
        if (r105 != r106) goto L24;
        return r106;
    L17:
        if (this.f335760c == true) goto L20;
        g49.d.e("DoraFileUploaderImpl", "upload: ignore from " + r101 + ", appForeground=" + this.f335759b + ", doraWakeup=" + this.f335760c);
    L7:
        r103 = new DoraFileUploaderImpl$upload$1(this, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x01cd -> B:82:0x01d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01f1 -> B:91:0x01f8). Please report as a decompilation issue!!! */
    public final Object e(DoraFileFetchTask r210, DoraFileUploaderTrigger r211, Continuation<? super Boolean> r212) {
        if ((r212 instanceof DoraFileUploaderImpl$uploadFile$1) == false) goto L7;
        DoraFileUploaderImpl$uploadFile$1 r100 = (DoraFileUploaderImpl$uploadFile$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r110 = "";
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        long r111 = r100.J$0;
        int r105 = r100.I$0;
        b r112 = (b) r100.L$5;
        String r106 = (String) r100.L$4;
        String r107 = (String) r100.L$3;
        File r108 = (File) r100.L$2;
        DoraFileUploaderTrigger r109 = (DoraFileUploaderTrigger) r100.L$1;
        DoraFileFetchTask r113 = (DoraFileFetchTask) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
    L82:
        b r114 = (b) r102;     // Catch: Throwable -> L14
        if (r114.f335762a == false) goto L86;
        b r115 = r114;
        DoraFileFetchTask r116 = r113;
        DoraFileUploaderTrigger r117 = r109;
        long r118 = r111;
    L93:
        g49.d.d("DoraFileUploaderImpl", "uploadFile: task=" + r116 + ", uploadResult=" + r115 + ", trigger=" + r117 + ", cost=" + (SystemClock.elapsedRealtime() - r118));
        com.larus.dora.impl.file.a r119 = f.f335741a;
        String r120 = r116.getTransportType();
        if (r120 != null) goto L96;
        r120 = "";
    L96:
        String r121 = r116.getFetchFrom();
        if (r121 != null) goto L99;
        r121 = "";
    L99:
        DoraFileType r122 = r116.getFileType();
        if (r122 != null) goto L102;
        r122 = DoraFileType.UNKNOWN;
    L102:
        String r123 = r116.getFileName();
        if (r123 != null) goto L105;
        r123 = "";
    L105:
        Long r124 = r116.getFileTotalSize();
        if (r124 == null) goto L108;
        long r125 = r124.longValue();
    L109:
        long r126 = SystemClock.elapsedRealtime() - r118;
        if (r115 == null) goto L114;
        int r127 = 1;
        if (r115.f335762a != true) goto L115;
        boolean r128 = true;
    L116:
        if (r128 == true) goto L119;
        r127 = 2;
    L119:
        if (r115 == null) goto L124;
        String r129 = r115.f335763b;
        if (r129 == null) goto L124;
        r110 = r129;
    L124:
        Intrinsics.checkNotNullParameter(r120, "transportType");
        Intrinsics.checkNotNullParameter(r121, "fetchFrom");
        Intrinsics.checkNotNullParameter(r122, "fileType");
        Intrinsics.checkNotNullParameter(r123, "fileName");
        Intrinsics.checkNotNullParameter(r110, "reason");
        Intrinsics.checkNotNullParameter(r117, "uploadTrigger");
        LinkedHashMap r130 = new LinkedHashMap();
        r130.put("transport_type", r120);
        r130.put("fetch_from", r121);
        r130.put("file_type", Integer.valueOf(r122.getCode()));
        r130.put("file_name", r123);
        r130.put("file_size", Long.valueOf(r125 / ((long) 1024)));
        r130.put("duration", Long.valueOf(r126));
        r130.put("result", Integer.valueOf(r127));
        r130.put("reason", r110);
        r130.put("upload_trigger", r117.getTraceName());
        f.b("d_file_upload", r130);
        if (r115 == null) goto L127;
        boolean r131 = r115.f335762a;
    L129:
        return Boxing.boxBoolean(r131);
    L127:
        r131 = false;
    L115:
        r128 = false;
        goto L116
    L114:
        r127 = 1;
        goto L115
    L108:
        r125 = 0;
        goto L109
    L86:
        r118 = r111;
        int r132 = 1;
        String r133 = r106;
        r115 = r114;
        r116 = r113;
        String r134 = r107;
        r117 = r109;
        File r135 = r108;
        String r136 = r133;
    L92:
        r105 = r105 + r132;
    L77:
        if (r105 > 0) goto L93;
        r100.L$0 = r116;     // Catch: Throwable -> L89
        r100.L$1 = r117;     // Catch: Throwable -> L89
        r100.L$2 = r135;     // Catch: Throwable -> L89
        r100.L$3 = r134;     // Catch: Throwable -> L89
        r100.L$4 = r136;     // Catch: Throwable -> L89
        r100.L$5 = r115;     // Catch: Throwable -> L89
        r100.I$0 = r105;     // Catch: Throwable -> L89
        r100.J$0 = r118;     // Catch: Throwable -> L89
        r100.label = 1;     // Catch: Throwable -> L89
        r102 = f(r135, r134, r136, r117, r100);     // Catch: Throwable -> L89
        if (r102 != r103) goto L81;
        return r103;
    L81:
        r111 = r118;
        r112 = r115;
        r106 = r136;
        r108 = r135;
        r109 = r117;
        r107 = r134;
        r113 = r116;
    L89:
        th = th;
        r111 = r118;
        r112 = r115;
        r106 = r136;
        r108 = r135;
        r109 = r117;
        r107 = r134;
        r113 = r116;
    L91:
        g49.d.c("DoraFileUploaderImpl", "uploadFile: failed on attempt=" + r105 + " for fileName=" + r113.getFileName() + ", trigger=" + r109, th);
        r100 = r100;
        r116 = r113;
        r134 = r107;
        r117 = r109;
        r135 = r108;
        r136 = r106;
        r115 = r112;
        r118 = r111;
        r132 = 1;
    L87:
        th = th;
        r112 = r114;
    L14:
        th = th;
        goto L91
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        PolarisFileWrapper r137 = new PolarisFileWrapper(r210.getLocalPath());
        boolean r138 = r137.exists();
        StringBuilder r139 = new StringBuilder("uploadFile: path=");
        r139.append(r137.getAbsolutePath());
        r139.append(", exists=");
        r139.append(r138);
        r139.append(", trigger=");
        r117 = r211;
        r139.append(r117);
        g49.d.d("DoraFileUploaderImpl", r139.toString());
        if (r138 == true) goto L26;
        g49.d.b("DoraFileUploaderImpl", "uploadFile: file not exists, path=" + r137.getAbsolutePath());
        i r140 = this.f335758a;
        String r141 = r210.getId();
        if (r141 == null) goto L24;
        r110 = r141;
    L24:
        r140.delete(r110);
        DoraFileRecorder.b(r210);
        return Boxing.boxBoolean(false);
    L26:
        DoraFileType r142 = r210.getFileType();
        if (r142 != null) goto L29;
        r142 = DoraFileType.UNKNOWN;
    L29:
        int r143 = c.f335764a[r142.ordinal()];
        if (r143 != 1) goto L32;
        String r144 = "https://os-mon.zijieapi.com/monitor/os_collect/crash_detail_batch";
    L40:
        r134 = r144;
    L42:
        if (r134.length() != 0) goto L44;
        boolean r145 = true;
    L45:
        if (r145 == false) goto L48;
        g49.d.b("DoraFileUploaderImpl", "uploadFile: unknown file type " + r210.getFileType());
        return Boxing.boxBoolean(false);
    L48:
        String r146 = r210.getSn();
        if (r146 != null) goto L51;
        r146 = "";
    L51:
        String r147 = r210.getFirmwareVersion();
        if (r147 != null) goto L54;
        r147 = "";
    L54:
        Long r148 = r210.getFileCreateTimeMs();
        if (r148 == null) goto L57;
        long r149 = r148.longValue();
    L58:
        DoraFileType r150 = r210.getFileType();
        if (r150 != null) goto L134;
        r150 = DoraFileType.UNKNOWN;
    L134:
        Pair[] r151 = new Pair[7];     // Catch: Exception -> L72
        r151[0] = TuplesKt.to("product_id", 10098);     // Catch: Exception -> L70
        r151[1] = TuplesKt.to(FrescoMonitorConst.LOG_TYPE, r150.getUploadType());     // Catch: Exception -> L70
        r151[2] = TuplesKt.to("create_ts", Long.valueOf(r149));     // Catch: Exception -> L68
        r151[3] = TuplesKt.to("firmware_version", r147);     // Catch: Exception -> L68
        r151[4] = TuplesKt.to("rom_version", "");     // Catch: Exception -> L68
        r151[5] = TuplesKt.to("sn", r146);     // Catch: Exception -> L68
        r151[6] = TuplesKt.to("device_id", r146);     // Catch: Exception -> L68
        String r152 = new JSONObject(MapsKt.mapOf(r151)).toString();     // Catch: Exception -> L68
        Intrinsics.checkNotNull(r152);     // Catch: Exception -> L68
    L76:
        r118 = SystemClock.elapsedRealtime();
        r136 = r152;
        r115 = null;
        r135 = r137;
        r105 = 0;
        r116 = r210;
    L68:
        e = e;
    L75:
        g49.d.c("DoraFileUploaderImpl", "getUploadTextSem: json string error", e);
        r152 = SliceInitService.DEFAULT_SWITCH;
    L70:
        e = e;
    L72:
        e = e;
        goto L75
    L57:
        r149 = 0;
        goto L58
    L44:
        r145 = false;
        goto L45
    L32:
        if (r143 == 2) goto L38;
        if (r143 == 3) goto L38;
        if (r143 != 4) goto L37;
        r134 = "";
        goto L42
    L37:
        throw new NoWhenBranchMatchedException();
    L38:
        r144 = "https://os-mon.zijieapi.com/monitor/os_collect/file_collect_batch";
    L7:
        r100 = new DoraFileUploaderImpl$uploadFile$1(this, r212);
        goto L8
    }

    public static Object f(File r100, String r101, String r110, DoraFileUploaderTrigger r111, Continuation r112) {
        CompletableDeferred r102 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Parameters r103 = new Parameters(0, r101, "", new LinkedHashMap(), new d(r111, r102));
        r103.addMultipartTextSem("json", "application/json", r110);
        r103.addMultipartFileSem("file", "application/octet-stream", r100.getAbsolutePath(), r100.getName());
        g49.d.d("DoraFileUploaderImpl", "uploadFileInternal: uploadId=" + r103.getUploadId() + ", trigger=" + r111);
        Uploader.getInstance(AppHost.f326268a.getApplication()).start(r103);
        return r102.await(r112);
    }
}
