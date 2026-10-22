package lh;

import com.bytedance.android.ec.core.monitor.process.ProcessDomain;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509219a = 0;

    public b() {
    }

    static {
    }

    public static void a(ProcessDomain r100) {
        if (a.f509218a[r100.ordinal()] != 1) goto L6;
        return;
    L6:
        throw new NoWhenBranchMatchedException();
    }

    public static void b(ProcessDomain r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "processDomain");
        Intrinsics.checkNotNullParameter("开播页", "pageName");
        Intrinsics.checkNotNullParameter(r101, "actionName");
        int r103 = ECSdk.f48106a;
        pi.b r104 = (pi.b) ECSdk.a(pi.b.class);
        if (r104 == null) goto L6;
        a(r100);
        JSONObject r105 = new JSONObject();
        r105.put("event_type", "rate");
        r105.put("page_name", "开播页");
        r105.put("action_name", r101);
        r105.put("action_code", null);
        r105.put("message", r102);
        r105.put("rate_type", "failed");
        Unit r106 = Unit.INSTANCE;
        r104.monitorEvent("ec_full_live_process_monitor", r105, null, null);
        return;
    }

    public static void c(ProcessDomain r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "processDomain");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "actionName");
        int r103 = ECSdk.f48106a;
        pi.b r104 = (pi.b) ECSdk.a(pi.b.class);
        if (r104 == null) goto L6;
        a(r100);
        JSONObject r105 = new JSONObject();
        r105.put("event_type", "rate");
        r105.put("page_name", r101);
        r105.put("action_name", r102);
        r105.put("rate_type", "start");
        Unit r106 = Unit.INSTANCE;
        r104.monitorEvent("ec_full_live_process_monitor", r105, null, null);
        return;
    }

    public static void d(ProcessDomain r100, String r101, long r102, JSONObject r103, int r104) {
        if ((r104 & 32) == 0) goto L5;
        r103 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "processDomain");
        Intrinsics.checkNotNullParameter("开播页", "pageName");
        Intrinsics.checkNotNullParameter(r101, "actionName");
        int r105 = ECSdk.f48106a;
        pi.b r106 = (pi.b) ECSdk.a(pi.b.class);
        if (r106 == null) goto L9;
        a(r100);
        JSONObject r107 = new JSONObject();
        r107.put("event_type", "rate");
        r107.put("page_name", "开播页");
        r107.put("action_name", r101);
        r107.put("rate_type", "success");
        Unit r108 = Unit.INSTANCE;
        JSONObject r109 = new JSONObject();
        r109.put("duration", r102);
        r106.monitorEvent("ec_full_live_process_monitor", r107, r109, r103);
        return;
    }
}
