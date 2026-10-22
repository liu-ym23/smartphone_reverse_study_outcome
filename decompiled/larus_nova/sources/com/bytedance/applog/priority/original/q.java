package com.bytedance.applog.priority.original;

import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f192785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f192786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f192788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f192789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f192790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f192791g;

    public q(JSONObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "defaultReportHost");
        Intrinsics.checkNotNullParameter(r102, "defaultReportPath");
        this.f192785a = r100.optInt("global_priority", 0);
        this.f192786b = RangesKt.coerceAtLeast(r100.optInt(VideoThumbInfo.KEY_INTERVAL, 0), 0);
        this.f192787c = r100.optString("report_host", r101);
        this.f192788d = r100.optString("report_path", r102);
        this.f192789e = new ArrayList();
        this.f192790f = r100.optString("event_priority", DiagnoseResult.DIAGNOSE_LEVEL_P2);
        JSONObject r103 = r100.optJSONObject("filter");
        if (r103 == null) goto L5;
        r r104 = new r(r103);
    L6:
        this.f192791g = r104;
        JSONArray r105 = r100.optJSONArray("support_event_types");
        if (r105 == null) goto L20;
        int r106 = r105.length();
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L24;
        String r108 = r105.optString(r107);
        if (r108 != null) goto L13;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == true) goto L19;
        List<String> r110 = this.f192789e;
        ArrayList r111 = (ArrayList) r110;
        r111.add(r108.toLowerCase(Locale.ROOT));
    L19:
        r107 = r107 + 1;
        goto L9
    L13:
        if (r108.length() == 0) goto L16;
        r109 = false;
        goto L17
    L24:
        return;
    L20:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
