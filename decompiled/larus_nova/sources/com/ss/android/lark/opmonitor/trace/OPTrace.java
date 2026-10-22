package com.ss.android.lark.opmonitor.trace;

import android.os.Trace;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.optrace.api.ITracing;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import com.ss.android.lark.optrace.impl.TracingSpanImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import fyb.e;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0001J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010)\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010-\u001a\u00020 H\u0016J;\u0010.\u001a\u00020 \"\n\b\u0000\u0010/*\u0004\u0018\u0001002\b\u0010.\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002H/2\u000e\u00103\u001a\n\u0012\u0004\u0012\u0002H/\u0018\u000104H\u0016¢\u0006\u0002\u00105J)\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J)\u0010;\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J)\u0010<\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J)\u0010=\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J\b\u0010>\u001a\u00020\u0001H\u0017J\b\u0010?\u001a\u00020\u0000H\u0016J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0006J\u0010\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020 2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010E\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010CR\u0012\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006H"}, d2 = {"Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "Lcom/ss/android/lark/optrace/api/TracingCoreSpan;", "Lcom/ss/android/lark/opmonitor/service/AbsMonitorService;", "<init>", "()V", "traceId", "", "(Ljava/lang/String;)V", "tracingCoreSpan", "(Lcom/ss/android/lark/optrace/api/TracingCoreSpan;)V", "mBase", "monitors", "", "getMonitors", "()Ljava/util/List;", "setMonitors", "(Ljava/util/List;)V", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "", "getFinished", "()Z", "setFinished", "(Z)V", "batchEnabled", "getBatchEnabled", "setBatchEnabled", "serialize", "getTracingSpanImpl", "getTracingID", "createTime", "", "addExtension", "", "extensionEnum", "Lcom/ss/android/lark/optrace/extension/TracingExtensionEnum;", "extension", "Lcom/ss/android/lark/optrace/extension/TracingExtension;", "clientDurationTagStart", "tagKey", "clientDurationTagEnd", "startKey", "clientDuration", "getRequestId", "setRequestId", "requestid", "clientDurationEndAll", "linkTracing", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/ss/android/lark/optrace/api/ITracing;", PerfLog.PARAM_KEY_CONTEXT_ID, "callback", "Lcom/ss/android/lark/optrace/api/ITracingLink$TracingLinkCallback;", "(Lcom/ss/android/lark/optrace/api/ITracing;Ljava/lang/Object;Lcom/ss/android/lark/optrace/api/ITracingLink$TracingLinkCallback;)V", RXScreenCaptureService.KEY_INDEX, "tag", "msg", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "w", "e", "d", "generateSpan", "subTrace", "bizName", "flush", "monitor", "Lcom/ss/android/lark/opmonitor/service/OPMonitor;", "log", VideoEventOneOutSync.END_TYPE_FINISH, "reportMonitor", "Companion", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OPTrace extends fyb.a implements TracingCoreSpan {
    public static final int BATCH_CODE = 10000;
    public static final String BATCH_DATA_KEY = "batch";
    public static final String BATCH_DOMAIN = "monitor.base.batch";
    public static final String BATCH_EVENT_NAME = "monitor_batch_report";
    public static final int BATCH_MAX_NUM = 50;
    public static final String BATCH_MSG = "batch_monitor";
    public static final a Companion = null;
    public static final String TAG = "OPTrace";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OPMonitorCode f437602a = null;

    @SerializedName("batchEnabled")
    @Expose
    private boolean batchEnabled;
    private boolean finished;

    @SerializedName("trace")
    @Expose
    private TracingCoreSpan mBase;

    @SerializedName("monitorCache")
    @Expose
    private List<String> monitors;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(String r100) {
            if (r100 != null) goto L4;
        L20:
            boolean r101 = false;
        L22:
            return !r101;
        L4:
            if (cyb.b.f465989b != null) goto L14;
            int r102 = iyb.a.f496623a;
            Intrinsics.checkNotNullParameter("op_api_report_config", "configKey");
            Log.i("MinaConfig", "getBatchConfigList config: ");
            if (TextUtils.isEmpty("") == true) goto L12;
            cyb.b.f465989b = (List) OPTraceGSONParser.f437603a.fromJson("", new cyb.a().getType());     // Catch: Exception -> L9
        L9:
            e = move-exception;
            Log.e("MinaConfig", e);
        L12:
            if (cyb.b.f465989b != null) goto L14;
            cyb.b.f465989b = new ArrayList();
        L14:
            List<String> r103 = cyb.b.f465989b;
            if (r103 == null) goto L17;
            Boolean r104 = Boolean.valueOf(r103.contains(r100));
        L18:
            if (r104 == null) goto L20;
            r101 = r104.booleanValue();
            goto L22
        L17:
            r104 = null;
            goto L18
        }
    }

    @JvmStatic
    public static final boolean checkApiReportEnabled(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        Companion = new a();
        f437602a = new OPMonitorCode(BATCH_DOMAIN, 10000, OPMonitorLevel.NORMAL, BATCH_MSG);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationEndAll() {
        this.mBase.clientDurationEndAll();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long createTime() {
        return this.mBase.createTime();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    @Deprecated(message = "use subTrace")
    public TracingCoreSpan generateSpan() {
        return new OPTrace(this.mBase.generateSpan());
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getRequestId() {
        return this.mBase.getRequestId();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getTracingID() {
        return this.mBase.getTracingID();
    }

    public final String serialize() {
        Gson r100 = OPTraceGSONParser.f437603a;
        return GsonProtectorUtils.toJson(OPTraceGSONParser.f437603a, this);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public OPTrace subTrace() {
        OPTrace r100 = new OPTrace(this.mBase.subTrace());
        r100.batchEnabled = this.batchEnabled;
        return r100;
    }

    public OPTrace() {
        this.monitors = new ArrayList();
        this.mBase = new TracingSpanImpl(null);
    }

    public static final /* synthetic */ OPMonitorCode access$getBATCH_MONITOR_CODE$cp() {
        return f437602a;
    }

    public final boolean getBatchEnabled() {
        return this.batchEnabled;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final List<String> getMonitors() {
        return this.monitors;
    }

    public final TracingCoreSpan getTracingSpanImpl() {
        return this.mBase;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public /* bridge */ /* synthetic */ TracingCoreSpan subTrace() {
        return subTrace();
    }

    public OPTrace(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        this.monitors = new ArrayList();
        this.mBase = new TracingSpanImpl(r100);
    }

    @JvmStatic
    public static final boolean checkBizBatchEnabled(String r100) {
        Companion.getClass();
        return !cyb.b.a().d(r100);
    }

    @JvmStatic
    public static final OPTrace deserialize(String r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        Type r101 = new com.ss.android.lark.opmonitor.trace.a().getType();
        return (OPTrace) GsonProtectorUtils.fromJson(OPTraceGSONParser.f437603a, r100, r101);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDuration(String r100) {
        return this.mBase.clientDuration(r100);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDurationTagEnd(String r100) {
        return this.mBase.clientDurationTagEnd(r100);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationTagStart(String r100) {
        this.mBase.clientDurationTagStart(r100);
    }

    public final synchronized void finish(OPMonitor r100) {
        monitor-enter(this);
        Trace.beginSection("computeOPTraceFinish");     // Catch: Throwable -> L24
        if (cyb.b.a().c() == true) goto L10;
        Trace.endSection();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L10:
        if (this.finished == false) goto L12;
    L21:
        Log.e(TAG, "is already finished or monitors is empty!,finished:" + this.finished + ",size:" + this.monitors.size());     // Catch: Throwable -> L24
        Trace.endSection();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L12:
        if (this.monitors.isEmpty() == true) goto L21;
        Trace.beginSection("computeOPTraceFlush");     // Catch: Throwable -> L24
        if (r100 == null) goto L17;
        Gson r101 = OPTraceGSONParser.f437603a;     // Catch: Throwable -> L24
        r100.addCategoryValue(BATCH_DATA_KEY, GsonProtectorUtils.toJson(OPTraceGSONParser.f437603a, this.monitors)).tracing(getTracingID()).flush();     // Catch: Throwable -> L24
    L18:
        Trace.endSection();     // Catch: Throwable -> L24
        this.finished = true;     // Catch: Throwable -> L24
        this.monitors.clear();     // Catch: Throwable -> L24
        Trace.endSection();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L17:
        OPMonitor r102 = new OPMonitor(BATCH_EVENT_NAME, f437602a);     // Catch: Throwable -> L24
        Gson r103 = OPTraceGSONParser.f437603a;     // Catch: Throwable -> L24
        r102.addCategoryValue(BATCH_DATA_KEY, GsonProtectorUtils.toJson(OPTraceGSONParser.f437603a, this.monitors)).tracing(getTracingID()).flush();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // byb.e
    public synchronized void flush(OPMonitor r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "monitor");     // Catch: Throwable -> L14
        if (cyb.b.a().a(r100) == false) goto L12;
        Trace.beginSection("computeSerializeOPMonitor");     // Catch: Throwable -> L14
        if (this.monitors.size() <= 50) goto L11;
        Log.w(TAG, "batch monitor execeed max nums:" + getTracingID());     // Catch: Throwable -> L14
        this.monitors.clear();     // Catch: Throwable -> L14
        this.batchEnabled = false;     // Catch: Throwable -> L14
        Trace.endSection();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L14
        r101.put("name", r100.getName());     // Catch: Throwable -> L14
        r101.put("metrics", new JSONObject(r100.getMetrics()));     // Catch: Throwable -> L14
        r101.put(ReportCardMonitorPlugin.CATEGORIES, new JSONObject(r100.getCategories()));     // Catch: Throwable -> L14
        this.monitors.add(r101.toString());     // Catch: Throwable -> L14
        Trace.endSection();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // byb.e
    public void log(OPMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        boolean r101 = cyb.b.a().c();
        if (cyb.b.a().b() == false) goto L9;
        if (r101 == true) goto L6;
    L7:
        log(r100, e.f479342b.f479343a);
        return;
    L6:
        if (cyb.b.a().a(r100) == false) goto L7;
        return;
    }

    public final void setBatchEnabled(boolean r100) {
        this.batchEnabled = r100;
    }

    public final void setFinished(boolean r100) {
        this.finished = r100;
    }

    public final void setMonitors(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.monitors = r100;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void setRequestId(String r100) {
        this.mBase.setRequestId(r100);
    }

    public final OPTrace subTrace(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizName");
        OPTrace r101 = subTrace();
        Companion.getClass();
        boolean r102 = !cyb.b.a().d(r100);
        r101.batchEnabled = r102;
        if (r102 == false) goto L5;
        r101.batchEnabled = a.a(r100);
        Log.i(TAG, "batch monitor subTrace apiName: " + r100 + ", batchEnabled: " + r101.batchEnabled);
    L5:
        return r101;
    }

    public OPTrace(TracingCoreSpan r100) {
        Intrinsics.checkNotNullParameter(r100, "tracingCoreSpan");
        this.monitors = new ArrayList();
        this.mBase = r100;
    }

    @JvmStatic
    public static final OPTrace deserialize(String r100, String r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        OPTrace r102 = new OPTrace(r100);
        r102.setBatchEnabled(!cyb.b.a().d(r101));
        if (r102.getBatchEnabled() == false) goto L5;
        r102.setBatchEnabled(a.a(r101));
        Log.i(TAG, "batch monitor deserialize apiName: " + r101 + ", batchEnabled: " + r102.getBatchEnabled());
    L5:
        return r102;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void addExtension(TracingExtensionEnum r100, TracingExtension r101) {
        this.mBase.addExtension(r100, r101);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void d(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.mBase.d(r100, Arrays.copyOf(r101, r101.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void e(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.mBase.e(r100, Arrays.copyOf(r101, r101.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void i(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.mBase.i(r100, Arrays.copyOf(r101, r101.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void w(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.mBase.w(r100, Arrays.copyOf(r101, r101.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public <T> void linkTracing(ITracing r100, T r101, hyb.b<T> r102) {
        if ((r100 instanceof OPTrace) == false) goto L5;
        this.mBase.linkTracing(((OPTrace) r100).mBase, r101, r102);
        return;
    L5:
        this.mBase.linkTracing(r100, r101, r102);
    }
}
