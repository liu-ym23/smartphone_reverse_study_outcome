package com.ss.android.lark.widget.photopicker.gallery;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447537a = 0;

    static {
    }

    public static void a(int r100, String r101, long r102) {
        JSONObject r103 = new JSONObject();
        r103.put("result", r100);
        if (r101 == null) goto L5;
        r103.put("errorMsg", r101);
    L5:
        r103.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r102);
        Log.i("OriginalMediaMonitor", "reportClickEvent: " + r103);
        Statistics.sendEvent("original_video_click_event_dev", r103);
    }
}
