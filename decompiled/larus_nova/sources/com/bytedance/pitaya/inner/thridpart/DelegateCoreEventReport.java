package com.bytedance.pitaya.inner.thridpart;

import androidx.core.app.NotificationCompat;
import com.bytedance.pitaya.api.PitayaProxy;
import com.bytedance.pitaya.api.bean.PTYErrorCode;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.tencent.connect.common.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/pitaya/inner/thridpart/DelegateCoreEventReport;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "appVer", "", "mMonitor", "Lcom/bytedance/pitaya/inner/thridpart/IEventReport;", "getMMonitor", "()Lcom/bytedance/pitaya/inner/thridpart/IEventReport;", "setMMonitor", "(Lcom/bytedance/pitaya/inner/thridpart/IEventReport;)V", "notReadyCallMap", "", "", "notReadyCall", "", "aid", "businessName", "notReadyCall$pitayacore_release", "onReady", "reportFeatureCache", "reportFirstInvokeTimeInterval", "reportRunTaskBeforeReady", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DelegateCoreEventReport implements ReflectionCall {
    public static final DelegateCoreEventReport INSTANCE = null;
    private static String appVer;
    private static IEventReport mMonitor;
    private static final Map<String, Map<String, Long>> notReadyCallMap = null;

    private DelegateCoreEventReport() {
    }

    static {
        INSTANCE = new DelegateCoreEventReport();
        appVer = "No Version";
        notReadyCallMap = new LinkedHashMap();
    }

    private final void reportFirstInvokeTimeInterval() {
        Map<String, Map<String, Long>> r100 = notReadyCallMap;
        monitor-enter(r100);
        Iterator<Map.Entry<String, Map<String, Long>>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, Map<String, Long>> r102 = r101.next();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, Long>> r103 = r102.getValue().entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, Long> r104 = r103.next();     // Catch: Throwable -> L16
        int r105 = (int) (System.currentTimeMillis() - r104.getValue().longValue());     // Catch: Throwable -> L16
        IEventReport r106 = mMonitor;     // Catch: Throwable -> L16
        if (r106 == null) goto L9;
        r106.reportEvent("pitaya2_plugin_time", new JSONObject().put(Constants.PARAM_APP_VER, appVer).put("aid", r102.getKey()).put("sdk_ver", "2.13.0").put("sdk_build_ver", "2.13.46").put("nm", r104.getKey()), new JSONObject().put("dur", ((double) r105) / 1000.0d), null);     // Catch: Throwable -> L16
        goto L9
    L13:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private final void reportRunTaskBeforeReady() {
        Map<String, Map<String, Long>> r100 = notReadyCallMap;
        monitor-enter(r100);
        Iterator<Map.Entry<String, Map<String, Long>>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, Map<String, Long>> r102 = r101.next();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, Long>> r103 = r102.getValue().entrySet().iterator();     // Catch: Throwable -> L16
    L9:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, Long> r104 = r103.next();     // Catch: Throwable -> L16
        IEventReport r105 = mMonitor;     // Catch: Throwable -> L16
        if (r105 == null) goto L9;
        r105.reportEvent("pitaya2_task", new JSONObject().put(Constants.PARAM_APP_VER, appVer).put("sdk_ver", "2.13.0").put("sdk_build_ver", "2.13.46").put("nm", r104.getKey()).put(NotificationCompat.CATEGORY_CALL, "api").put("aid", r102.getKey()).put("rst", PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode()), null, new JSONObject().put("ts", r104.getValue().longValue()));     // Catch: Throwable -> L16
        goto L9
    L13:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private final void reportFeatureCache() {
        int r100 = PitayaProxy.applogCacheSize();
        IEventReport r101 = mMonitor;
        if (r101 == null) goto L6;
        r101.reportEvent("pitaya2_fe_cold_start", new JSONObject().put(Constants.PARAM_APP_VER, appVer).put("aid", 3691).put("sdk_ver", "2.13.0").put("sdk_build_ver", "2.13.46"), new JSONObject().put("applog_num", r100).put("fe_store_num", 0), null);
        return;
    }

    public final void onReady() {
        reportRunTaskBeforeReady();
        reportFirstInvokeTimeInterval();
        reportFeatureCache();
    }

    public final IEventReport getMMonitor() {
        return mMonitor;
    }

    public final void setMMonitor(IEventReport r100) {
        mMonitor = r100;
    }

    public final void notReadyCall$pitayacore_release(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        Intrinsics.checkNotNullParameter(r101, "businessName");
        Map<String, Map<String, Long>> r102 = notReadyCallMap;
        monitor-enter(r102);
        Map<String, Long> r103 = r102.get(r100);     // Catch: Throwable -> L13
        if (r103 != null) goto L8;
        r103 = new LinkedHashMap();     // Catch: Throwable -> L13
        r102.put(r100, r103);     // Catch: Throwable -> L13
    L8:
        if (r103.containsKey(r101) == true) goto L10;
        r103.put(r101, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L13
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
