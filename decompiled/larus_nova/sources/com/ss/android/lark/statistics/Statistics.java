package com.ss.android.lark.statistics;

import android.app.Application;
import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007JN\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\u001a\u001a\u00020\rH\u0007J\b\u0010\u001b\u001a\u00020\rH\u0007J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0005H\u0007J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0007J\u001c\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010,\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010-\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010.\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006/"}, d2 = {"Lcom/ss/android/lark/statistics/Statistics;", "", "<init>", "()V", "TAG", "", "conversionReporter", "Lcom/ss/android/lark/statistics/api/spi/IConversionReporter;", "getConversionReporter", "()Lcom/ss/android/lark/statistics/api/spi/IConversionReporter;", "conversionReporter$delegate", "Lkotlin/Lazy;", "lazyInit", "", "depend", "Lcom/ss/android/lark/statistics/StatisticsLazy$ILazyStatisticsDepend;", "appLog", "Lcom/ss/android/lark/statistics/StatisticsLazy$IAppLog;", "resetTeaAgentCustomHeader", "userId", "deviceId", "tenantId", "tenantBrand", "userGeo", "romBaseVersion", "romIncrementalVersion", "setEmptyTeaAgentCustomHeader", "updateTeaAgentCustomHeaderAsync", "sendEvent", "eventName", "params", "Lorg/json/JSONObject;", "sendConversionEvent", "event", "Lcom/ss/android/lark/statistics/api/ConversionEvent;", "initConversion", "application", "Landroid/app/Application;", "onPrivacyAccepted", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "recordMiscLog", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, WidgetCostModule.TYPE_ON_CREATE, "onPause", "onResume", "statistics_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Statistics {
    public static final Statistics INSTANCE = null;
    private static final String TAG = "Statistics";
    private static final Lazy conversionReporter$delegate = null;

    private Statistics() {
    }

    static {
        INSTANCE = new Statistics();
        conversionReporter$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, Statistics$conversionReporter$2.INSTANCE);
    }

    private final p5c.a getConversionReporter() {
        return (p5c.a) conversionReporter$delegate.getValue();
    }

    @JvmStatic
    public static final void setEmptyTeaAgentCustomHeader() {
        v5c.a.f553340b = "";
        v5c.a.f553342d = "";
        v5c.a.f553356r = "";
        v5c.a.f553355q = "";
        v5c.a.f553349k = Boolean.FALSE;
        v5c.a.f553350l = "";
        Log.i(TAG, "setEmptyTeaAgentCustomHeader，" + v5c.a.a());
        b.f440626c.getClass();
        b.f440626c.getClass();
    }

    @JvmStatic
    public static final void updateTeaAgentCustomHeaderAsync() {
        b.e r100 = b.f440624a;
        if (r100 == null) goto L19;
        boolean r101 = true;
        if (r100.f440629b.get() != 0) goto L7;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        Log.i("StatisticsLazy", "updateTeaAgentCustomHeaderAsync init has not started, do nothing!");
        return;
    L12:
        if (r100.f440629b.get() == 2) goto L15;
        r101 = false;
    L15:
        if (r101 == true) goto L17;
        Log.e("StatisticsLazy", "updateTeaAgentCustomHeaderAsync, custom header has not been inited!");
        return;
    L17:
        Log.i("StatisticsLazy", "updateTeaAgentCustomHeaderAsync, try to update custom header!");
        throw null;
    L7:
        r102 = false;
        goto L9
    }

    @JvmStatic
    public static final void initConversion(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        INSTANCE.getConversionReporter().init(r100);
    }

    @JvmStatic
    public static final void onCreate(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b.f440626c.getClass();
    }

    @JvmStatic
    public static final void onPause(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b.f440626c.getClass();
    }

    @JvmStatic
    public static final void onPrivacyAccepted(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        INSTANCE.getConversionReporter().a(r100);
    }

    @JvmStatic
    public static final void onResume(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b.f440626c.getClass();
    }

    @JvmStatic
    public static final void sendConversionEvent(o5c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        INSTANCE.getConversionReporter().report();
    }

    @JvmStatic
    public static final void sendEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b.b(r100, null);
    }

    @JvmStatic
    public static final void lazyInit(b.d r100, b.c r101) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        Intrinsics.checkNotNullParameter(r101, "appLog");
        b.e r102 = b.f440624a;
        b.f440624a = new b.e();
        b.f440626c = r101;
    }

    @JvmStatic
    public static final void recordMiscLog(String r100, JSONObject r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L15;
        b.e r102 = b.f440624a;
        if (r102 != null) goto L7;
        a r103 = b.a();
        if (r103 == null) goto L12;
        r103.onMiscEvent(r100, r101);
        return;
    L12:
        Log.w("StatisticsLazy", "recordMiscLog failed: sStatisticsImpl is null and IStatisticsAppLog not found, logType: ".concat(r100));
        return;
    L7:
        if (r102.f440629b.get() != 2) goto L16;
        b.f440626c.getClass();
        return;
    L16:
        return;
    L15:
        return;
    }

    @JvmStatic
    public static final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        b.b(r100, r101);
    }

    @JvmStatic
    public static final void resetTeaAgentCustomHeader(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        v5c.a.f553341c = r101;
        v5c.a.f553340b = r100;
        v5c.a.f553342d = r102;
        v5c.a.f553356r = r103;
        v5c.a.f553355q = r104;
        v5c.a.f553344f = r105;
        v5c.a.f553345g = r106;
        v5c.a.f553350l = r100;
        if (r100 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        v5c.a.f553349k = Boolean.valueOf(!r107);
        Log.i(TAG, "resetTeaAgentCustomHeader，" + v5c.a.a());
        b.f440626c.getClass();
        b.f440626c.getClass();
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r107 = false;
        goto L9
    }
}
