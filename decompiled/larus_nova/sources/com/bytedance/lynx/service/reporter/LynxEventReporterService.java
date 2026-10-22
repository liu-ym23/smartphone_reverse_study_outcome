package com.bytedance.lynx.service.reporter;

import android.content.Context;
import b8a.l;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageProcessor;
import com.bytedance.lynx.service.reporter.performance.b;
import com.bytedance.lynx.service.reporter.performance.f;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.IServiceProvider;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import i8a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016JB\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/lynx/service/reporter/LynxEventReporterService;", "Li8a/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "onInitialize", "", "eventName", "", "instanceId", "", "", SlcElement.KEY_PROPS, ControlRule.KEY_EXTRA_DATA, "onReportEvent", "Lorg/json/JSONObject;", "jsonObject", "convertBooleanToInt", "Lb8a/l;", "entry", "onPerformanceEvent", "TAG", "Ljava/lang/String;", "PERF_ENTRY_EVENT_NAME_PREFIX", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "lynxServiceConfig", "Lcom/bytedance/lynx/service/model/LynxServiceConfig;", "", "Lcom/bytedance/lynx/service/reporter/performance/a;", "processorList", "Ljava/util/List;", "Lcom/bytedance/lynx/service/reporter/performance/b;", "defaultProcessor", "Lcom/bytedance/lynx/service/reporter/performance/b;", "<init>", "()V", "LynxService_noasanRelease"}, k = 1, mv = {1, 6, 0})
public final class LynxEventReporterService implements a {
    public static final LynxEventReporterService INSTANCE = null;
    public static final String PERF_ENTRY_EVENT_NAME_PREFIX = "lynxsdk_performance_entry_";
    public static final String TAG = "LynxEventReporterService";
    private static b defaultProcessor;
    private static LynxServiceConfig lynxServiceConfig;
    private static List<com.bytedance.lynx.service.reporter.performance.a> processorList;

    private LynxEventReporterService() {
    }

    static {
        INSTANCE = new LynxEventReporterService();
        ArrayList r100 = new ArrayList();
        processorList = r100;
        defaultProcessor = new b();
        r100.add(new f());
        processorList.add(new LynxMemoryUsageProcessor());
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public Class getServiceClass() {
        return a.class;
    }

    public final JSONObject convertBooleanToInt(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof Boolean) == true) goto L7;
        r101.put(r103, r104);
        goto L4
    L7:
        r101.put(r103, ((Boolean) r104).booleanValue() ? 1 : 0);
        goto L4
    L9:
        return r101;
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
        Iterator<com.bytedance.lynx.service.reporter.performance.a> r101 = processorList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onInitialize(r100);
        goto L4
    }

    @Override // y7a.a
    public void onPerformanceEvent(l r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        String r101 = PERF_ENTRY_EVENT_NAME_PREFIX + r100.f18215b;
        Iterator<com.bytedance.lynx.service.reporter.performance.a> r102 = processorList.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L12;
        com.bytedance.lynx.service.reporter.performance.a r104 = r102.next();
        if (r104.b(r100) == false) goto L4;
        Map<String, Object> r105 = r104.a(r100);
        if (r105 == null) goto L11;
        AppLogNewUtils.onEventV3(r101, INSTANCE.convertBooleanToInt(new JSONObject(r105)));
    L11:
        r103 = true;
        goto L4
    L12:
        if (r103 == false) goto L15;
        return;
    L15:
        if (defaultProcessor.b(r100) == true) goto L17;
        return;
    L17:
        AppLogNewUtils.onEventV3(r101, INSTANCE.convertBooleanToInt(new JSONObject(defaultProcessor.a(r100))));
    }

    @Override // com.lynx.tasm.eventreport.ILynxEventReportObserver
    public void onReportEvent(String r100, int r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_PROPS);
        TraceEvent.beginSection("LynxEventReporterServiceProxy.onReportEvent");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r103 == null) goto L5;
        r104.putAll(r103);
    L5:
        r104.putAll(r102);
        AppLogNewUtils.onEventV3(r100, convertBooleanToInt(new JSONObject(r104)));
        TraceEvent.endSection("LynxEventReporterServiceProxy.onReportEvent");
    }
}
