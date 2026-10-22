package com.optimize.statistics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.sampling.IFrescoMonitorSamplingDecider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class FrescoMonitor {
    private static final String TAG = "FrescoMonitor";
    static boolean isReportDebug;
    private static Context sContext;
    private static String sCurrentActivity;
    private static String sCurrentScene;
    private static boolean sEnableAllSourceUriReport;
    private static boolean sEnableMonitorLog;
    private static List<ImageExceedLimitTraceListener> sExceedTheLimitTraceListeners;
    private static volatile IMonitorHook sMonitorHook;
    static final List<IMonitorHookV2> sMonitorHookV2s = null;
    static final CopyOnWriteArrayList<IMonitorHookV2> sNewMonitorHookV2s = null;
    private static boolean sReportHitCacheEnabled;
    private static boolean sReportImageMonitorDataEnabled;
    private static volatile IFrescoMonitorSamplingDecider sSamplingDecider;
    private static List<ImageSensibleTraceListener> sSensibleTraceListeners;
    private static List<ImageTraceListener> sTraceListeners;
    private static List<ImageWasteShowListener> sWasteShowListeners;

    public FrescoMonitor() {
    }

    static {
        sTraceListeners = new ArrayList();
        sExceedTheLimitTraceListeners = new ArrayList();
        sSensibleTraceListeners = new ArrayList();
        sWasteShowListeners = new ArrayList();
        sMonitorHookV2s = new ArrayList();
        sNewMonitorHookV2s = new CopyOnWriteArrayList();
        sReportHitCacheEnabled = false;
        sReportImageMonitorDataEnabled = false;
        sEnableMonitorLog = true;
        sEnableAllSourceUriReport = false;
        sCurrentScene = null;
        sCurrentActivity = null;
    }

    public static boolean isReportImageWaste() {
        Iterator<ImageWasteShowListener> r100 = sWasteShowListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        ImageWasteShowListener r101 = r100.next();
        if (r101 == null) goto L4;
        if (r101.isReportImageWaste() == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getCurrentActivity() {
        return sCurrentActivity;
    }

    public static String getCurrentScene() {
        return sCurrentScene;
    }

    public static IMonitorHook getMonitorHook() {
        return sMonitorHook;
    }

    public static IFrescoMonitorSamplingDecider getSamplingDecider() {
        return sSamplingDecider;
    }

    public static boolean isEnableMonitorLog() {
        return sEnableMonitorLog;
    }

    public static boolean isNeedReportAllSourceUriType() {
        return sEnableAllSourceUriReport;
    }

    public static boolean isReportHitCacheEnabled() {
        return sReportHitCacheEnabled;
    }

    public static boolean isReportImageMonitorDataEnabled() {
        return sReportImageMonitorDataEnabled;
    }

    public static void addImageExceedTheLimitTraceListener(ImageExceedLimitTraceListener r100) {
        sExceedTheLimitTraceListeners.add(r100);
    }

    public static void addImageSensibleTraceListener(ImageSensibleTraceListener r100) {
        sSensibleTraceListeners.add(r100);
    }

    public static void addImageTraceListener(ImageTraceListener r100) {
        sTraceListeners.add(r100);
    }

    public static void addImageWasteShowListener(ImageWasteShowListener r100) {
        sWasteShowListeners.add(r100);
    }

    public static void addMonitorHookV2(IMonitorHookV2 r100) {
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L5;
        sNewMonitorHookV2s.add(r100);
        return;
    L5:
        List<IMonitorHookV2> r101 = sMonitorHookV2s;
        monitor-enter(r101);
        r101.add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean getLogTypeSwitch(String r100) {
        if (FrescoCacheMonitorUtil.isOptMonitorSampleDebug() == false) goto L7;
        boolean r101 = !isReportDebug;
        isReportDebug = r101;
        return r101;
    L7:
        return MonitorUtils.getLogTypeSwitch(r100);
    }

    public static boolean isNetworkAvailable(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L11
        if (r101 == null) goto L14;
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r102 == null) goto L15;
        if (r102.isAvailable() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    L17:
        return false;
    }

    public static void onExceedLimitCallback(JSONObject r100) {
        Iterator<ImageExceedLimitTraceListener> r101 = sExceedTheLimitTraceListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        ImageExceedLimitTraceListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onExceedLimitCallback(r100);
        goto L4
    }

    public static void onSensibleCallback(JSONObject r100) {
        Iterator<ImageSensibleTraceListener> r101 = sSensibleTraceListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        ImageSensibleTraceListener r102 = r101.next();
        if (r102 == null) goto L4;
        r102.onSensibleCallback(r100);
        goto L4
    }

    public static void removeMonitorHookV2(IMonitorHookV2 r100) {
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L5;
        sNewMonitorHookV2s.remove(r100);
        return;
    L5:
        List<IMonitorHookV2> r101 = sMonitorHookV2s;
        monitor-enter(r101);
        r101.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void setContext(Context r100) {
        sContext = r100;
    }

    public static void setCurrentActivity(String r100) {
        sCurrentActivity = r100;
    }

    public static void setCurrentScene(String r100) {
        sCurrentScene = r100;
    }

    public static void setCustomExceedLimit(ExceedTheLimitBitmapMonitor.CustomExceedLimit r100) {
        ExceedTheLimitBitmapMonitor.setCustomExceedLimit(r100);
    }

    public static void setEnableAllSourceUriReport(boolean r100) {
        sEnableAllSourceUriReport = r100;
    }

    public static void setEnableMonitorLog(boolean r100) {
        sEnableMonitorLog = r100;
    }

    public static void setExceedTheLimitBitmapMonitorEnabled(boolean r100) {
        ExceedTheLimitBitmapMonitor.setExceedTheLimitBitmapMonitorEnabled(r100);
    }

    public static void setImageTraceListener(ImageTraceListener r100) {
        addImageTraceListener(r100);
    }

    public static void setMonitorHook(IMonitorHook r100) {
        sMonitorHook = r100;
    }

    public static void setReportHitCacheEnabled(boolean r100) {
        sReportHitCacheEnabled = r100;
    }

    public static void setReportImageMonitorDataEnabled(boolean r100) {
        sReportImageMonitorDataEnabled = r100;
    }

    public static void setSamplingDecider(IFrescoMonitorSamplingDecider r100) {
        sSamplingDecider = r100;
        if (r100 != null) goto L5;
        String r101 = "null";
    L6:
        FLog.d(TAG, "setSamplingDecider, decider is ".concat(r101));
        return;
    L5:
        r101 = "non-null";
        goto L6
    }

    public static void onImageShowCallback(boolean r100, JSONObject r101) {
        Iterator<ImageWasteShowListener> r102 = sWasteShowListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        ImageWasteShowListener r103 = r102.next();
        if (r103 == null) goto L4;
        r103.onImageShowCallback(r100, r101);
        goto L4
    }

    public static void setExceedTheLimitBitmapMonitorLimit(long r100, int r101, long r102) {
        ExceedTheLimitBitmapMonitor.setBitmapMonitorLimit(r100, r101, r102);
    }

    public static void onImageLoaded(boolean r100, String r101, JSONObject r102, boolean[] r103) {
        if (r100 == true) goto L12;
        Context r104 = sContext;
        if (r104 == null) goto L9;
        if (isNetworkAvailable(r104) == true) goto L9;
        return;
    L9:
        if (getLogTypeSwitch(FrescoMonitorConst.MONITOR_IMAGE_ERROR_V2) == false) goto L12;
        MonitorUtils.monitorCommonLog(FrescoMonitorConst.MONITOR_IMAGE_ERROR_V2, r102);
    L12:
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L26;
        if (r103 != null) goto L15;
        return;
    L15:
        int r105 = 0;
    L17:
        if (r105 >= sTraceListeners.size()) goto L32;
        if (r105 >= r103.length) goto L43;
        ImageTraceListener r106 = (ImageTraceListener) ListProtector.get(sTraceListeners, r105);
        if (r106 == null) goto L25;
        if (r103[r105] == false) goto L25;
        r106.onImageLoaded(r100, r101, r102);
    L25:
        r105 = r105 + 1;
        goto L17
    L43:
        return;
    L32:
        return;
    L26:
        Iterator<ImageTraceListener> r107 = sTraceListeners.iterator();
    L28:
        if (r107.hasNext() == false) goto L44;
        ImageTraceListener r108 = r107.next();
        if (r108 == null) goto L28;
        r108.onImageLoaded(r100, r101, r102);
        goto L28
    }

    public static boolean[] sampleImageTraceListeners(ImageRequest r100, Object r110, String r111, boolean r112) {
        int r101 = sTraceListeners.size();
        if (r101 != 0) goto L5;
        return null;
    L5:
        boolean[] r102 = new boolean[r101];
        int r103 = 0;
        boolean r104 = false;
    L6:
        if (r103 >= r101) goto L25;
        ImageTraceListener r105 = (ImageTraceListener) ListProtector.get(sTraceListeners, r103);
        if (r105 != null) goto L11;
        r102[r103] = false;
    L18:
        if (r104 == false) goto L20;
    L23:
        r104 = true;
    L24:
        r103 = r103 + 1;
        goto L6
    L20:
        if (r102[r103] == true) goto L23;
        r104 = false;
        goto L24
    L11:
        if ((r105 instanceof ImageTraceSampler) == false) goto L17;
        Boolean r106 = ((ImageTraceSampler) r105).shouldSampleImageLoaded(r100, r110, r111);
        if (r106 != null) goto L15;
        boolean r107 = r112;
    L16:
        r102[r103] = r107;
        goto L18
    L15:
        r107 = r106.booleanValue();
        goto L16
    L17:
        r102[r103] = true;
        goto L18
    L25:
        if (r104 == true) goto L27;
        return null;
    L27:
        return r102;
    }

    public static void imageNetCallBack(long r110, long r111, String r112, HttpRequestInfo r113, Throwable r114, JSONObject r115) {
        Iterator<ImageTraceListener> r100 = sTraceListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        ImageTraceListener r101 = r100.next();
        if (r101 == null) goto L4;
        r101.imageNetCallBack(r110, r111, r112, r113, r114, r115);
        goto L4
    }
}
