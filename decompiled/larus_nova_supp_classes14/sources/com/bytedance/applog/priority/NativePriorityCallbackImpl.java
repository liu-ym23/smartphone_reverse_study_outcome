package com.bytedance.applog.priority;

import android.webkit.ValueCallback;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.applog.log.a;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010,\u001a\u00020\u0001\u0012\u0006\u00101\u001a\u000200\u0012\u0018\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t05¢\u0006\u0004\b?\u0010@J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J4\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016J8\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016JH\u0010\"\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u001c\u0010&\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010(\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010+\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010,\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R)\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010;\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/bytedance/applog/priority/NativePriorityCallbackImpl;", "Lcom/bytedance/applog/priority/PriorityCallback;", "", "getHeaderJson", "", "getOpaquePayloadJson", "url", "", "buffer", "Lkotlin/Pair;", "keyIv", "Lcom/bytedance/applog/priority/PriorityHttpResponse;", "doHttpPost", "", "reqId", "key", "iv", "", "isNetworkAvailable", "", "level", "message", "", "printLog", UploadTypeInf.COUNT, "monitorIncreaseStats", "isMonitorEnabled", "stage", "priorityName", "groupId", "eventType", "event", "monitorId", "localTimeMs", "monitorStage", "isStageEnabled", "s", "stackInfo", "monitorError", "delaySeconds", "monitorLatency", "isolateKey", "value", "allowIsolateReport", "priorityCallback", "Lcom/bytedance/applog/priority/PriorityCallback;", "getPriorityCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "Lcom/bytedance/applog/log/a;", "logger", "Lcom/bytedance/applog/log/a;", "getLogger", "()Lcom/bytedance/applog/log/a;", "Landroid/webkit/ValueCallback;", "onHttpCallback", "Landroid/webkit/ValueCallback;", "getOnHttpCallback", "()Landroid/webkit/ValueCallback;", "Ljava/util/concurrent/ExecutorService;", "httpThreadPool", "Ljava/util/concurrent/ExecutorService;", "getHttpThreadPool", "()Ljava/util/concurrent/ExecutorService;", "<init>", "(Lcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/log/a;Landroid/webkit/ValueCallback;)V", "priority_release"}, k = 1, mv = {1, 6, 0})
public final class NativePriorityCallbackImpl implements PriorityCallback {
    private final ExecutorService httpThreadPool;
    private final a logger;
    private final ValueCallback<Pair<Long, PriorityHttpResponse>> onHttpCallback;
    private final PriorityCallback priorityCallback;

    public static /* synthetic */ void a(NativePriorityCallbackImpl r0, String r1, String r2, String r3, byte[] r4, long r5) {
        m994doHttpPost$lambda0(r0, r1, r2, r3, r4, r5);
    }

    public void printLog(int r1, String r2) {
    }

    public String getHeaderJson() {
        return this.priorityCallback.getHeaderJson();
    }

    public Object getOpaquePayloadJson() {
        return this.priorityCallback.getOpaquePayloadJson();
    }

    public boolean isMonitorEnabled() {
        return this.priorityCallback.isMonitorEnabled();
    }

    public boolean isNetworkAvailable() {
        return this.priorityCallback.isNetworkAvailable();
    }

    public boolean isStageEnabled() {
        return this.priorityCallback.isStageEnabled();
    }

    public String isolateKey() {
        return this.priorityCallback.isolateKey();
    }

    public final ExecutorService getHttpThreadPool() {
        return this.httpThreadPool;
    }

    public final a getLogger() {
        return this.logger;
    }

    public final ValueCallback<Pair<Long, PriorityHttpResponse>> getOnHttpCallback() {
        return this.onHttpCallback;
    }

    public final PriorityCallback getPriorityCallback() {
        return this.priorityCallback;
    }

    public boolean allowIsolateReport(String r2, String r3) {
        return this.priorityCallback.allowIsolateReport(r2, r3);
    }

    public void monitorError(String r2, String r3) {
        this.priorityCallback.monitorError(r2, r3);
    }

    public void monitorIncreaseStats(String r2, int r3) {
        this.priorityCallback.monitorIncreaseStats(r2, r3);
    }

    public NativePriorityCallbackImpl(PriorityCallback r2, a r3, ValueCallback<Pair<Long, PriorityHttpResponse>> r4) {
        Intrinsics.checkNotNullParameter(r2, "priorityCallback");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r4, "onHttpCallback");
        this.priorityCallback = r2;
        this.logger = r3;
        this.onHttpCallback = r4;
        this.httpThreadPool = PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("NativePriorityCallbackImpl"));
    }

    public PriorityHttpResponse doHttpPost(final String r1, byte[] r2, Pair<String, String> r3) {
        this.logger.a("NativePriorityCallbackImpl", new AnonymousClass1(r1));
        return null;
    }

    public void monitorLatency(int r2, int r3, int r4) {
        this.priorityCallback.monitorLatency(r2, r3, r4);
    }

    public final PriorityHttpResponse doHttpPost(final String r12, final long r13, final byte[] r15, final String r16, final String r17) {
        this.httpThreadPool.submit(new d(this, r16, r17, r12, r15, r13));
        return new PriorityHttpResponse(200, "", "");
    }

    /* JADX INFO: renamed from: doHttpPost$lambda-0, reason: not valid java name */
    private static final void m994doHttpPost$lambda0(NativePriorityCallbackImpl r3, String r4, String r5, String r6, byte[] r7, final long r8) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        r3.logger.a("NativePriorityCallbackImpl:doHttpPost", new NativePriorityCallbackImpl$doHttpPost$2$1(r8));
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L17;
        if (r5 != null) goto L12;
    L13:
        r0 = true;
    L14:
        if (r0 == true) goto L17;
        Pair r9 = TuplesKt.to(r4, r5);
    L18:
        PriorityHttpResponse r10 = r3.priorityCallback.doHttpPost(r6, r7, r9);
        r3.onHttpCallback.onReceiveValue(new Pair(Long.valueOf(r8), r10));
        return;
    L12:
        if (r5.length() != 0) goto L14;
    L17:
        r9 = null;
        goto L18
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public void monitorStage(String r11, String r12, int r13, int r14, String r15, String r16, long r17) {
        this.priorityCallback.monitorStage(r11, r12, r13, r14, r15, r16, r17);
    }
}
