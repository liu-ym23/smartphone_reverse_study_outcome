package q09;

import android.os.Build;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.flow.performance.thermal.SystemBatteryRecoder;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements f09.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f531217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f531218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f531219c;

    /* JADX INFO: renamed from: q09.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7260a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f531220a = null;

        static {
            int[] r100 = new int[LocateScene.values().length];
            r100[LocateScene.VUI_CMD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L59:
            r100[LocateScene.OFFICE_SDK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L71:
            r100[LocateScene.MSG_NEED_LOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L45:
            r100[LocateScene.AGENT_TOOL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[LocateScene.REALTIME_CALL_VIDEO_CMD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L55:
            r100[LocateScene.SERVER_CMD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L65:
            r100[LocateScene.POLL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L51:
            r100[LocateScene.APPLET.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L61:
            r100[LocateScene.COLD_LAUNCH.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L63:
            r100[LocateScene.HOT_LAUNCH.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L41:
            r100[LocateScene.VUI_AWAKE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L57:
            r100[LocateScene.ECOMMERCE_ADD_ADDRESS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L69:
            r100[LocateScene.DORA_G_ASR.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L39:
            r100[LocateScene.DORA_G_CONNECT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L49:
            r100[LocateScene.DORA_G_QUIT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L67:
            r100[LocateScene.DORA_G_WEAR.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L43:
            r100[LocateScene.UNKNOWN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L20:
            f531220a = r100;
        }
    }

    public a() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
    }

    static {
        a r100 = new a();
        f531218b = 1;
        AppHost.f326268a.a().j(r100);
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        f531217a = Long.valueOf(SystemClock.elapsedRealtime());
        f531218b++;
    }

    public static String b(LocateScene r100) {
        switch(C7260a.f531220a[r100.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L21;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L6;
            default: goto L5;
        };
    L6:
        return "unknown";
    L7:
        return "dora_g_wear";
    L8:
        return "dora_g_quit";
    L9:
        return "dora_g_connect";
    L10:
        return "dora_g_asr";
    L11:
        return "ecommerce_add_address";
    L12:
        return "awaken";
    L13:
        return "hot";
    L14:
        return "cold";
    L15:
        return PrefetchTiming.JSB;
    L16:
        return SystemBatteryRecoder.BatteryRecordReason.POLLING;
    L17:
        return "realtime_call_video";
    L18:
        return "agent_tool";
    L19:
        return EventConstant.Value.RETRY;
    L20:
        return "office_sdk";
    L21:
        return "cmd";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void a(String r100, JSONObject r101) {
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a(r100);
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static JSONObject c(LocateScene r100, boolean r101, JSONObject r102) {
        JSONObject r103 = new JSONObject();
        r103.put("scene", b(r100));
        r103.put("app_state", r101 ? 1 : 0);
        AppHost.Companion r104 = AppHost.f326268a;
        boolean r105 = true;
        if (ContextCompat.checkSelfPermission(r104.getApplication(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L9;
        String r107 = "denied";
    L17:
        r103.put("location_permission_status", r107);
        if (r102 == null) goto L26;
        Iterator<String> r108 = r102.keys();
        if (r108 == null) goto L26;
    L22:
        if (r108.hasNext() == false) goto L26;
        String r109 = r108.next();
        if (r103.has(r109) == true) goto L22;
        r103.put(r109, r102.opt(r109));
    L26:
        return r103;
    L9:
        if (Build.VERSION.SDK_INT >= 29) goto L11;
    L14:
        if (r105 == false) goto L16;
        r107 = "authorized";
        goto L17
    L16:
        r107 = "fine_location_authorized";
        goto L17
    L11:
        if (ContextCompat.checkSelfPermission(r104.getApplication(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) goto L14;
        r105 = false;
        goto L14
    L5:
        r106 = false;
        goto L6
    }

    public static JSONObject d(LocateScene r100, long r110, boolean r111, JSONObject r112) {
        JSONObject r101 = new JSONObject();
        r101.put("type", b(r100));
        if (f531218b != 1) goto L5;
        String r102 = "cold";
    L6:
        r101.put("active_type", r102);
        r101.put("active_index", f531218b);
        Long r103 = f531217a;
        if (r103 != null) goto L9;
        long r104 = (SystemClock.elapsedRealtime() - AppHost.f326268a.getAppStartTime().getFirst().longValue()) / 1000;
    L10:
        r101.put("trigger_interval", r104);
        r101.put(LocationMonitorConst.IS_BACKGROUND, r111 ? 1 : 0);
        if (Build.VERSION.SDK_INT >= 29) goto L13;
    L16:
        int r113 = 1;
    L17:
        r101.put("has_background_location_permission", r113);
        r101.put("duration", r110);
        switch(C7260a.f531220a[r100.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L20;
            default: goto L19;
        };
    L19:
        Integer r105 = null;
    L21:
        if (r105 == null) goto L23;
        r101.put("proactive_trigger_index", r105.intValue());
    L23:
        if (r112 == null) goto L31;
        Iterator<String> r106 = r112.keys();
        if (r106 == null) goto L31;
    L27:
        if (r106.hasNext() == false) goto L31;
        String r114 = r106.next();
        if (r101.has(r114) == true) goto L27;
        r101.put(r114, r112.opt(r114));
    L31:
        return r101;
    L20:
        int r107 = f531219c + 1;
        f531219c = r107;
        r105 = Integer.valueOf(r107);
        goto L21
    L13:
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) goto L16;
        r113 = 0;
        goto L17
    L9:
        r104 = (SystemClock.elapsedRealtime() - r103.longValue()) / 1000;
        goto L10
    L5:
        r102 = "hot";
        goto L6
    }

    public static void e(LocateScene r100, LocationResult r101, boolean r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "result");
        JSONObject r104 = c(r100, r102, r103);
        r104.put("accuracy_level", 1);
        r104.put("reason", r101.getMessage());
        Unit r105 = Unit.INSTANCE;
        a("location_intercept", r104);
    }

    public static void f(LocateScene r100, long r101, boolean r102, Integer r103, Integer r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        JSONObject r106 = d(r100, r101, r102, r105);
        r106.put("error_code", r103);
        r106.put("time_out_status", r104);
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("location_update_error");
        r108.f21463a.merge(r107);
        r108.b();
    }
}
