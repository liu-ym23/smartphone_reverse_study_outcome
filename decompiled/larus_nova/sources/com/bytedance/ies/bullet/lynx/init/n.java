package com.bytedance.ies.bullet.lynx.init;

import android.content.Context;
import android.os.Handler;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.lynx.tasm.LynxEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SDKMonitor f247366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f247367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f247368c = null;

    static {
        o r100 = new o();
        JSONObject r101 = new JSONObject();
        r101.put("host_aid", "7059");
        r101.put("app_version", LynxEnv.inst().getLynxVersion());
        r101.put("update_version_code", LynxEnv.inst().getLynxVersion());
        r100.f247369a = r101;
        r100.f247370b = false;
        r100.f247371c = CollectionsKt.listOf("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        r100.f247372d = CollectionsKt.listOf("https://mon.snssdk.com/monitor/collect");
        f247368c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.bytedance.ies.bullet.lynx.init.o] */
    @JvmStatic
    public static final void a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = f247368c;
        r102.element = r103;
        o r104 = (o) r103;
        JSONObject r105 = r103.f247369a;
        if (r105 == null) goto L9;
        String r106 = com.bytedance.ies.bullet.kit.resourceloader.i.b("default_bid", 2).f().f552685f;
        if (r101 == false) goto L7;
        String r107 = "lynx_debug_channel";
    L8:
        r105.put("channel", r107);
        r105.put("device_id", r106);
        goto L9
    L7:
        r107 = "lynx_channel";
    L9:
        List<String> r108 = ((o) r102.element).f247371c;
        if (r108 == null) goto L12;
        SDKMonitorUtils.setConfigUrl("7059", r108);
    L12:
        List<String> r109 = ((o) r102.element).f247372d;
        if (r109 == null) goto L15;
        SDKMonitorUtils.setDefaultReportUrl("7059", r109);
    L15:
        JSONObject r110 = ((o) r102.element).f247369a;
        if (r110 != null) goto L18;
        r110 = new JSONObject();
    L18:
        r110.put("sdk_version", "10.4.0");
        SDKMonitorUtils.initMonitor(r100, "7059", r110, new k(r110, r102));
        f247366a = SDKMonitorUtils.getInstance("7059");
        PthreadHandlerThreadV2 r111 = new PthreadHandlerThreadV2("lynx_sdk_monitor");
        ThreadMethodProxy.start(r111);
        f247367b = new Handler(r111.getLooper());
    }
}
