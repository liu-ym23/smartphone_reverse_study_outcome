package com.ss.android.lark.chameleon.container.webcontainer.report;

import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.StatisticService;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.android.lark.chameleon.util.NetworkCheck;
import com.ss.android.lark.chameleon.util.NetworkType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/report/ChameleonReport;", "", "()V", "Chameleon_DEV_DOWNLOAD_DURATION", "", "TAG", "reportChameleonDownload", "", "appName", "channel", "duration", "", "success", "", "msg", "trackEventExt", "eventName", "param", "Lorg/json/JSONObject;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonReport {
    private static final String Chameleon_DEV_DOWNLOAD_DURATION = "Chameleon_gecko_download_duration_dev";
    public static final ChameleonReport INSTANCE = null;
    public static final String TAG = "CML_TAG_ChameleonReport";

    static {
        INSTANCE = new ChameleonReport();
    }

    private ChameleonReport() {
    }

    public final void trackEventExt(String r100, JSONObject r101) {
        if (AppInfoUtils.isApkInDebug(Env.getApplication()) == false) goto L5;
        Log.d(TAG, "trackEventExt, eventName = " + r100 + " param is " + r101);
        return;
    L5:
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        StatisticService.sendEvent(r100, r101);
        return;
    L11:
        return;
    }

    public final void reportChameleonDownload(String r100, String r101, long r102, boolean r110, String r111) {
        JSONObject r103 = new JSONObject();
        NetworkType r104 = NetworkCheck.getNetworkState(Env.getApplication());
        r103.put("duration_ms", r102);     // Catch: JSONException -> L15
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        r103.put("app_name", r100);     // Catch: JSONException -> L15
        r103.put("is_success", r110);     // Catch: JSONException -> L15
        if (r111 != null) goto L10;
        r111 = "";
    L10:
        r103.put("errorMsg", r111);     // Catch: JSONException -> L15
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        r103.put("channel", r101);     // Catch: JSONException -> L15
        r103.put(DBDefinition.DOWNLOAD_TABLE_NAME, "gecko");     // Catch: JSONException -> L15
        r103.put("network_status", r104);     // Catch: JSONException -> L15
        Log.d(TAG, "reportChameleonDownload, params = " + r103);     // Catch: JSONException -> L15
    L17:
        trackEventExt(Chameleon_DEV_DOWNLOAD_DURATION, r103);
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "reportChameleonDownload failed", e);
        goto L17
    }
}
