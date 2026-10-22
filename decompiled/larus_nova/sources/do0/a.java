package do0;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.fm0;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469399a = 0;

    public a() {
    }

    static {
    }

    public static /* synthetic */ void b(RechargeVerifyTraceStep r100, int r101, String r102, String r103, String r110) {
        a(r100, r101, r102, r103, r110, MapsKt.emptyMap());
    }

    public static void a(RechargeVerifyTraceStep r100, int r101, String r102, String r103, String r110, Map r111) {
        Intrinsics.checkNotNullParameter(r100, "step");
        JSONObject r104 = new JSONObject();
        d60.b.a(r104, "error_code", Integer.valueOf(r101));
        d60.b.a(r104, "scene", String.valueOf(r102));
        d60.b.a(r104, BytedCertConstant.CertKey.FLOW, String.valueOf(r103));
        d60.b.a(r104, "url", String.valueOf(r110));
        d60.b.a(r104, "is_v3", String.valueOf(fm0.f120216a.getValue().booleanValue()));
        if (r111 == null) goto L8;
        Iterator r105 = r111.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry r106 = (Map.Entry) r105.next();
        d60.b.a(r104, (String) r106.getKey(), r106.getValue());
    L8:
        String r107 = r100.getValue();
        int r108 = sp2.a.f542827a;
        if (LiveInfraSettingKeys.LIVE_RECHARGE_VERIFY_TRACE_ENABLE.getValue().booleanValue() == true) goto L11;
        ALogger.e("RechargeVerifyTraceMonitor", "disable report trace. due to setting disabled");
        return;
    L11:
        LiveTracingMonitor.EventModule r109 = LiveTracingMonitor.EventModule.RECHARGE;
        ILiveRoomService r112 = (ILiveRoomService) k.f(ILiveRoomService.class);
        String r113 = null;
        if (r112 == null) goto L14;
        Room r114 = r112.getCurrentRoom();
    L15:
        IUserService r115 = (IUserService) k.f(IUserService.class);
        if (r115 == null) goto L20;
        f r116 = r115.user();
        if (r116 == null) goto L20;
        IUser r117 = r116.b();
    L21:
        int r118 = e.f64997m;
        e.a r119 = e.b.a("recharge_verify", r109.getName());
        IUserService r120 = (IUserService) k.f(IUserService.class);
        if (r120 == null) goto L28;
        f r121 = r120.user();
        if (r121 == null) goto L28;
        IUser r122 = r121.b();
        if (r122 == null) goto L28;
        String r123 = r122.getUserId();
    L29:
        r119.f65010a = r123 + System.currentTimeMillis() + new SecureRandom().nextInt(1000);
        r119.f65012c = "webcast_client_recharge_verify";
        r119.f65017h = Integer.valueOf(r101);
        if (r117 == null) goto L32;
        String r124 = r117.getUserId();
    L33:
        r119.f65016g = r124;
        r119.f65017h = Integer.valueOf(r101);
        r119.f65018i = "";
        r119.f65013d = r107;
        if (r114 == null) goto L38;
        User r125 = r114.mo8271getOwner();
        if (r125 == null) goto L38;
        String r126 = r125.getIdString();
    L39:
        r119.f65015f = String.valueOf(r126);
        if (r114 == null) goto L42;
        r113 = r114.getIdStr();
    L42:
        r119.f65014e = r113;
        r119.f65011b = "";
        c.b(r119.a(), r104);
        return;
    L38:
        r126 = null;
        goto L39
    L32:
        r124 = null;
    L28:
        r123 = null;
    L20:
        r117 = null;
        goto L21
    L14:
        r114 = null;
        goto L15
    }
}
