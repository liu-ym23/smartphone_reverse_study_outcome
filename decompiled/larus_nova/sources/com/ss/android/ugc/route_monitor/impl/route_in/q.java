package com.ss.android.ugc.route_monitor.impl.route_in;

import com.ss.android.ugc.route_monitor.api.RouteResult;
import com.ss.android.ugc.route_monitor.utils.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class q extends com.ss.android.ugc.route_monitor.utils.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f454556c = null;

    static {
        f454556c = new q();
    }

    public q() {
    }

    @Override // com.ss.android.ugc.route_monitor.utils.i
    public final boolean a(JSONObject r100) {
        int r101 = r100.optInt("route_result_code", -1);
        RouteResult.Companion.getClass();
        if (10001 <= r101) goto L6;
    L8:
        boolean r102 = false;
    L9:
        String r103 = r100.optString("route_monitor_mode");
        ihc.r r104 = ihc.r.f489957b;
        if (Intrinsics.areEqual(r103, "PendingMonitorMode") == false) goto L13;
        if (r102 == false) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        return false;
    L16:
        return true;
    L13:
        r105 = false;
        goto L14
    L6:
        if (10009 < r101) goto L8;
        r102 = true;
        goto L9
    }

    @Override // com.ss.android.ugc.route_monitor.utils.i
    public final void e(Throwable r100) {
        Logger.f454747c.b();
        super.e(r100);
    }
}
