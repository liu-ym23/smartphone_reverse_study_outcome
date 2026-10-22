package f36;

import androidx.camera.video.AudioStats;
import com.bytedance.apm.util.i;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f475410a;

    public f(e r100) {
        this.f475410a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        c1 r100 = new c1("bdx_monitor_fluency", null, null, null, null, 254);
        e r101 = this.f475410a;
        r100.f247801k = r101.f475405d;
        JSONObject r102 = new JSONObject();
        k36.a.b(r102, r101.f475409h);
        Scenes r103 = r101.f475406e;
        if (r103 == null) goto L5;
        String r104 = r103.getTag();
    L6:
        r102.put(BytedCertConstant.IntentKey.VIEW_TYPE, r104);
        r100.f247794d = r102;
        int r105 = a.f475392a;
        double r106 = r101.f475403b;
        JSONObject r107 = r101.f475404c;
        long r108 = r101.f475402a;
        int r109 = i.f190670b;
        a.f475392a = r109;
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        int r111 = 0;
        String.format("calcute the info of dropframe:%s, duration:%s, fps:%s", Arrays.copyOf(new Object[]{r107, Long.valueOf(r108), Double.valueOf(r106)}, 3));
        if (r107 == null) goto L77;
        Iterator<String> r112 = r107.keys();
        if (r112 == null) goto L77;
        int r113 = a.f475392a;
        if (r113 == 60) goto L19;
        if (r113 == 90) goto L18;
        if (r113 != 120) goto L19;
        int r114 = 7;
    L20:
        JSONObject r115 = r107;
        int r116 = 0;
        int r117 = 0;
        int r118 = 0;
        int r210 = 0;
        int r211 = 0;
        int r212 = 0;
    L22:
        if (r112.hasNext() == false) goto L75;
        String r119 = r112.next();
        JSONObject r213 = r107;
        int r120 = CastIntegerProtector.parseInt(r119);
        int r121 = r115.optInt(r119);
        if (r121 > 0) goto L26;
        int r214 = r211;
        r112 = r112;
    L74:
        r112 = r112;
        r107 = r213;
        r211 = r214;
        goto L22
    L26:
        if (r120 < r114) goto L28;
        r116 = r116 + r121;
    L28:
        r210 = r210 + r121;
        if (r120 == 0) goto L72;
        int r122 = a.f475392a;
        if (r122 == 60) goto L40;
        if (r122 != 90) goto L35;
        int r123 = 5;
    L41:
        if (r120 >= r123) goto L44;
        r214 = r211 + r121;
    L71:
        r118 = r118 + (r120 * r121);
    L73:
        r115 = r213;
        r116 = r116;
        goto L74
    L44:
        r214 = r211;
        if (r122 != 60) goto L47;
    L53:
        int r124 = 7;
    L54:
        if (r120 >= r124) goto L56;
        r212 = r212 + r121;
        goto L71
    L56:
        int r125 = r212;
        if (r122 == 60) goto L66;
        if (r122 != 90) goto L61;
        int r126 = 23;
    L67:
        if (r120 >= r126) goto L69;
        r117 = r117 + r121;
    L70:
        r212 = r125;
        goto L71
    L69:
        r111 = r111 + r121;
        goto L70
    L61:
        if (r122 != 120) goto L66;
        r126 = 31;
    L66:
        r126 = 14;
        goto L67
    L47:
        if (r122 != 90) goto L49;
        r124 = 11;
        goto L54
    L49:
        if (r122 != 120) goto L53;
        r124 = 15;
        goto L54
    L35:
        if (r122 != 120) goto L40;
        r123 = 7;
    L40:
        r123 = 3;
        goto L41
    L72:
        r214 = r211;
        r112 = r112;
        goto L73
    L75:
        int r127 = r211;
        int r128 = r212;
        if (r210 <= 0) goto L77;
        int r129 = ((r127 + r128) + r117) + r111;
        double r130 = r118;
        int r131 = r116;
        c1 r215 = r100;
        double r132 = (((r108 * r106) * 1.0d) / (((double) 1000) * 1.0d)) + r130;
        JSONObject r133 = new JSONObject();
        StringCompanionObject r134 = StringCompanionObject.INSTANCE;
        String.format("drop_rate: dropFrameNumber:%s, sumTheoreticalFrames:%s", Arrays.copyOf(new Object[]{Integer.valueOf(r118), Double.valueOf(r132)}, 2));
        if (r118 <= 0) goto L81;
        double r135 = r130 / r132;
    L82:
        r133.put("drop_rate", r135);
        if (r129 > 0) goto L85;
    L87:
        r133.put("slight_dropframe_ratio", 0);
        r133.put("light_dropframe_ratio", 0);
        r133.put("middle_dropframe_ratio", 0);
        r133.put("high_dropframe_ratio", 0);
    L88:
        r133.put("block_per_second", (int) (((long) (r131 * 1000)) / r108));
    L89:
        JSONObject r136 = new JSONObject();
        k36.a.b(r136, r133);
        r136.put("fps", r106);
        r136.put("refresh_rate", r109);
        c1 r137 = r215;
        r137.f247795e = r136;
        String.format(new String(), Arrays.copyOf(new Object[]{"mergeAndReport,data:%s", r137.toString()}, 2));
        s26.d r138 = s26.d.f540305c;
        s26.d r139 = s26.d.f540305c;
        String r140 = this.f475410a.f475407f;
        if (r140 != null) goto L92;
        r140 = "default_bid";
    L92:
        r r141 = (r) r139.d(r140, r.class);
        if (r141 != null) goto L95;
        Lazy<MonitorReportService> r142 = MonitorReportService.f247964d;
        r141 = MonitorReportService.a.a();
    L95:
        r141.S(r137);
        e r143 = this.f475410a;
        r143.f475402a = -1;
        r143.f475403b = -1.0d;
        r143.f475404c = null;
        r143.f475408g = null;
        r143.f475409h = null;
        return;
    L85:
        if (r132 <= 0) goto L87;
        double r144 = ((double) r129) * 1.0d;
        r133.put("slight_dropframe_ratio", ((double) r127) / r144);
        r133.put("light_dropframe_ratio", ((double) r128) / r144);
        r133.put("middle_dropframe_ratio", ((double) r117) / r144);
        r133.put("high_dropframe_ratio", ((double) r111) / r144);
        goto L88
    L81:
        r135 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L82
    L18:
        r114 = 5;
    L19:
        r114 = 3;
    L77:
        r215 = r100;
        r133 = null;
        goto L89
    L5:
        r104 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
