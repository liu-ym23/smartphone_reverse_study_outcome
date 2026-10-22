package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f247478a = 0;

    static {
    }

    public static void a(Uri r100, String r110, int r111, int r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r110, "status");
        Intrinsics.checkNotNullParameter(r114, "bid");
        c1 r101 = new c1("bdx_monitor_xpool_create_view", null, null, null, null, 254);
        r101.f247801k = new a36.a(r100);
        JSONObject r102 = new JSONObject();
        r102.put("status", r110);
        if (r113 == null) goto L5;
        r102.put("failed_message", r113);
    L5:
        r102.put(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, r111);
        r102.put("remaining_count", r111 - r112);
        r101.f247794d = r102;
        s26.d r103 = s26.d.f540305c;
        r r104 = (r) s26.d.f540305c.d(r114, r.class);
        if (r104 == null) goto L9;
        r104.S(r101);
        return;
    }

    public static void b(Uri r100, String r110, int r111, int r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r110, "status");
        Intrinsics.checkNotNullParameter(r114, "bid");
        c1 r101 = new c1("bdx_monitor_xpool_fetch_view", null, null, null, null, 254);
        r101.f247801k = new a36.a(r100);
        JSONObject r102 = new JSONObject();
        r102.put("status", r110);
        r102.put(LocationMonitorConst.IDENTIFIER, r113);
        r102.put(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, r111);
        r102.put("remaining_count", r111 - r112);
        r101.f247794d = r102;
        s26.d r103 = s26.d.f540305c;
        r r104 = (r) s26.d.f540305c.d(r114, r.class);
        if (r104 == null) goto L6;
        r104.S(r101);
        return;
    }
}
