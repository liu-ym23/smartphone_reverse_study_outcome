package com.ss.android.lark.framework.assembly.officesdk.statistic;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(com.ss.android.lark.statistics.a.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/framework/assembly/officesdk/statistic/StatisticsAppLogImpl;", "Lcom/ss/android/lark/statistics/IStatisticsAppLog;", "<init>", "()V", "onEventV3", "", "event", "", "params", "Lorg/json/JSONObject;", "onMiscEvent", "logType", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "getOfficeSDKAppLog", "Lcom/ss/android/lark/officesdk/applog/api/IOfficeSDKAppLog;", "Companion", "statistics-assembly-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatisticsAppLogImpl implements com.ss.android.lark.statistics.a {
    public static final a Companion = null;
    private static final String TAG = "StatisticsAppLogImpl";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public StatisticsAppLogImpl() {
    }

    private final gtb.a getOfficeSDKAppLog() {
        return (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
    L4:
        e = move-exception;
        Log.w(TAG, "getOfficeSDKAppLog failed: " + e.getMessage());
        return null;
    }

    @Override // com.ss.android.lark.statistics.a
    public void onEventV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        gtb.a r102 = getOfficeSDKAppLog();
        if (r102 == null) goto L5;
        r102.onEventV3(r100, r101);
        return;
    L5:
        Log.w(TAG, "onEventV3 failed: IOfficeSDKAppLog not injected, event=" + r100);
    }

    @Override // com.ss.android.lark.statistics.a
    public void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        gtb.a r102 = getOfficeSDKAppLog();
        if (r102 == null) goto L5;
        r102.onMiscEvent(r100, r101);
        return;
    L5:
        Log.w(TAG, "onMiscEvent failed: IOfficeSDKAppLog not injected, logType=" + r100);
    }
}
