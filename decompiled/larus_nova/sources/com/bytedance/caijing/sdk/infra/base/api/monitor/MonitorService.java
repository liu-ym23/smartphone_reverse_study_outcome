package com.bytedance.caijing.sdk.infra.base.api.monitor;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;
import zd4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\n\u001a\u00020\tH&J6\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&J4\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&J*\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&J\"\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&J6\u0010 \u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J0\u0010\"\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\tH&J\b\u0010$\u001a\u00020#H&¨\u0006%"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/monitor/MonitorService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "aid", "", "configUrl", "reportUrl", "Lorg/json/JSONObject;", "header", "", "initSDKMonitor", "serviceName", "category", "metric", "logExt", "monitorEvent", "", "status", "duration", "monitorStatusAndDuration", "monitorStatusRate", "logType", "monitorCommonLog", "alogFilesDir", "", DyPayConstant.KEY_START_TIME, "endTime", "scene", "Lzd4/a;", "aLogCrashObserver", "activeUploadAlog", "extraLog", "onApmMonitorEvent", "", "checkInstallAPM", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface MonitorService extends ICJService {
    void activeUploadAlog(String r100, long r101, long r102, String r103, a r104);

    boolean checkInstallAPM();

    void initSDKMonitor(Context r100, String r101, List<String> r102, List<String> r103, JSONObject r104);

    void monitorCommonLog(String r100, String r101, JSONObject r102);

    void monitorEvent(String r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104);

    void monitorStatusAndDuration(String r100, String r101, int r102, JSONObject r103, JSONObject r104);

    void monitorStatusRate(String r100, String r101, int r102, JSONObject r103);

    void onApmMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
