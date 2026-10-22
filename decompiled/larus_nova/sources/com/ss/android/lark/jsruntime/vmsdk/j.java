package com.ss.android.lark.jsruntime.vmsdk;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.JSModuleWrapper;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.jsruntime.vmsdk.module.VMConsoleLogModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VMPlatformModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VmSDKRequestDelegate;
import com.ss.android.lark.jsruntime.vmsdk.module.VmSdkEventEmitterModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VmSdkJsToNativeBridgeModule;
import com.ss.android.lark.jsruntime.vmsdk.module.VmsdkWebSocketModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements tnb.a, tnb.f, tb5.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f428174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f428175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JsWorker f428176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f428177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<tnb.e> f428178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f428179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<tnb.c> f428180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<tnb.d> f428181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<tnb.f> f428182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f428183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f428184k;

    public static final class a {
    }

    static {
    }

    public final JSModuleManager h() {
        return (JSModuleManager) this.f428177d.getValue();
    }

    public final VmSdkEventEmitterModule g() {
        JSModuleWrapper r100 = h().a(VmSdkEventEmitterModule.NAME);
        if (r100 == null) goto L5;
        JSModule r101 = r100.getModule();
    L7:
        if ((r101 instanceof VmSdkEventEmitterModule) == true) goto L11;
        rnb.c.b("VMSDK_VMSDKEngine", "getNativeToJsModule: module is not VmSdkEventEmitterModule");
        return null;
    L11:
        return (VmSdkEventEmitterModule) r101;
    L5:
        r101 = null;
        goto L7
    }

    public final void i() {
        h().b(VMConsoleLogModule.NAME, VMConsoleLogModule.class, null);
        h().b(VMPlatformModule.NAME, VMPlatformModule.class, null);
        h().b(VmSdkEventEmitterModule.NAME, VmSdkEventEmitterModule.class, this);
        h().b(VmSdkJsToNativeBridgeModule.NAME, VmSdkJsToNativeBridgeModule.class, this);
        h().b(VmsdkWebSocketModule.NAME, VmsdkWebSocketModule.class, g());
    }

    public final Context getContext() {
        return this.f428174a;
    }

    @Override // tb5.f.b
    public final void b(String r100) {
        JsWorker r101 = this.f428176c;
        if (r101 == null) goto L6;
        r101.evaluateJavaScript(r100);
        return;
    }

    @Override // tnb.f
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        Iterator<T> r101 = this.f428182i.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((tnb.f) r101.next()).c(r100);
        goto L4
    }

    @Override // tnb.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dataString");
        Iterator<T> r101 = this.f428182i.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((tnb.f) r101.next()).d(r100);
        goto L4
    }

    public final void e(nnb.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        rnb.c.c("VMSDK_VMSDKEngine", "addExceptionHandler() called with: handler = " + r100);
        ((ArrayList) this.f428180g).add(r100);
    }

    public final void f(pnb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        rnb.c.c("VMSDK_VMSDKEngine", "addJSRuntimeToNativeBridgeDelegate() called with: delegate = " + r100);
        ((ArrayList) this.f428182i).add(r100);
    }

    @Override // tnb.a
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "data");
        VmSdkEventEmitterModule r102 = g();
        if (r102 == null) goto L5;
        r102.sendEvent(r100, r101);
        return;
    L5:
        rnb.c.b("VMSDK_VMSDKEngine", "sendDataToJSEngine:error: getJSRuntimeDataSender() is null");
    }

    public j(Context r100, JsWorker.EngineType r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "engineType");
        Intrinsics.checkNotNullParameter(r102, "jsFilePath");
        Intrinsics.checkNotNullParameter("CCM_VMSDK", "bizName");
        this.f428174a = r100;
        this.f428175b = r102;
        this.f428177d = LazyKt.lazy(new VMSDKEngine$moduleManager$2(this));
        this.f428178e = new ArrayList();
        this.f428180g = new ArrayList();
        this.f428181h = new ArrayList();
        ArrayList r104 = new ArrayList();
        this.f428182i = r104;
        Intrinsics.checkNotNullParameter(r102, "jsFilePath");
    L17:
        e = move-exception;
        rnb.c.b("VMSDK_VMSDKEngine", "Error:VMSDK init error! " + e);
        return;
    L4:
        if (this.f428183j == false) goto L6;
        rnb.c.b("VMSDK_VMSDKEngine", "Error:VMSDK hasinit!");     // Catch: Exception -> L17
    L6:
        this.f428183j = true;     // Catch: Exception -> L17
        rnb.c.c("VMSDK_VMSDKEngine", "init() called VMSDKEngine start with: jsFilePath = " + r102 + tb2.c.DEFAULT_TEXT);     // Catch: Exception -> L17
        com.bytedance.vmsdk.worker.a.C3813a r105 = new com.bytedance.vmsdk.worker.a.C3813a();     // Catch: Exception -> L17
        r105.f272528b = "CCM_VMSDK";     // Catch: Exception -> L17
        r105.f272532f = h();     // Catch: Exception -> L17
        r105.f272527a = r101;     // Catch: Exception -> L17
        r105.f272531e = true;     // Catch: Exception -> L17
        r105.f272530d = r103;     // Catch: Exception -> L17
        this.f428176c = new JsWorker(new com.bytedance.vmsdk.worker.a(r105));     // Catch: Exception -> L17
        i();     // Catch: Exception -> L17
        JsWorker r106 = this.f428176c;     // Catch: Exception -> L17
        if (r106 == null) goto L9;
        r106.setWorkerDelegate(new VmSDKRequestDelegate());     // Catch: Exception -> L17
    L9:
        JsWorker r107 = this.f428176c;     // Catch: Exception -> L17
        if (r107 == null) goto L12;
        r107.setOnErrorCallback(new VMSDKEngine$init$1(this));     // Catch: Exception -> L17
    L12:
        JsWorker r108 = this.f428176c;     // Catch: Exception -> L17
        if (r108 == null) goto L15;
        r108.setOnMessageCallback(new VMSDKEngine$init$2(this));     // Catch: Exception -> L17
    L15:
        this.f428184k = new e(this);     // Catch: Exception -> L17
        r104.add(new l(this));     // Catch: Exception -> L17
    }
}
