package klc;

import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ void c(a r100, String r101, EffectConfig r102, Map r103) {
        b(r100, true, r101, r102, r103, "");
    }

    public static final void e(a r100, boolean r101, EffectConfig r102, Map<String, ? extends Object> r103) {
        Pair[] r104 = new Pair[3];
        String r105 = r102.f457167m;
        if (r105 != null) goto L6;
        r105 = "";
    L6:
        r104[0] = TuplesKt.to("app_id", r105);
        String r106 = r102.f457152a;
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        r104[1] = TuplesKt.to("access_key", r106);
        r104[2] = TuplesKt.to(MonitorConstants.CONNECT_TYPE, "");
        Map<String, ? extends Object> r107 = MapsKt.mutableMapOf(r104);
        r107.putAll(r103);
        r100.monitorStatusRate("effect_download_info", !r101 ? 1 : 0, r107);
    }

    public static void l(a r100, String r101, String r102, long r103) {
        r100.monitorStatusRate("resource_provider_load", 0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("local_busi_key_list", r101), TuplesKt.to("resource_key", r102), TuplesKt.to(ImageNetworkRequestsMonitor.KEY_IMAGE_LOAD, 0L), TuplesKt.to("size", Long.valueOf(r103)), TuplesKt.to(ChameleonOpenTracker.ParamKey.LOAD_TYPE, "preload"), TuplesKt.to("synthesize_time", 0L)}));
    }

    public static final void a(a r100, boolean r101, EffectConfig r102, Map<String, ? extends Object> r110, String r111) {
        if (r102.U == false) goto L5;
        b(r100, r101, "category", r102, r110, r111);
    L5:
        Pair[] r103 = new Pair[2];
        String r104 = r102.f457167m;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103[0] = TuplesKt.to("app_id", r104);
        String r105 = r102.f457152a;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r103[1] = TuplesKt.to("access_key", r105);
        Map<String, ? extends Object> r106 = MapsKt.mutableMapOf(r103);
        r106.putAll(r110);
        if (r101 == true) goto L19;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r106.put("error_msg", r111);
    L19:
        r100.monitorStatusRate(MobConstants.CATEGORY_LIST_SUCCESS_RATE, !r101 ? 1 : 0, r106);
    }

    public static final void f(a r100, boolean r101, EffectConfig r102, Map<String, ? extends Object> r110, String r111) {
        if (r102.U == false) goto L5;
        b(r100, r101, "all_effect", r102, r110, r111);
    L5:
        Pair[] r103 = new Pair[2];
        String r104 = r102.f457167m;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103[0] = TuplesKt.to("app_id", r104);
        String r105 = r102.f457152a;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r103[1] = TuplesKt.to("access_key", r105);
        Map<String, ? extends Object> r106 = MapsKt.mutableMapOf(r103);
        r106.putAll(r110);
        if (r101 == true) goto L19;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r106.put("error_msg", r111);
    L19:
        r100.monitorStatusRate(MobConstants.EFFECT_LIST_SUCCESS_RATE, !r101 ? 1 : 0, r106);
    }

    public static final void g(a r100, boolean r101, EffectConfig r102, Effect r103, String r104) {
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to(MobConstants.EFFECT_ID, r103.getEffect_id());
        r105[1] = TuplesKt.to(MobConstants.EFFECT_NAME, r103.getName());
        String r106 = r102.f457167m;
        if (r106 != null) goto L6;
        r106 = "";
    L6:
        r105[2] = TuplesKt.to("app_id", r106);
        String r107 = r102.f457152a;
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        r105[3] = TuplesKt.to("access_key", r107);
        Map<String, ? extends Object> r108 = MapsKt.mutableMapOf(r105);
        if (r101 == true) goto L16;
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        r108.put("error_msg", r104);
    L16:
        r100.monitorStatusRate(MobConstants.UNZIP_EFFECT_RESOURCE_SUCCESS_RATE, !r101 ? 1 : 0, r108);
    }

    public static final void h(a r100, boolean r101, EffectConfig r102, Map<String, ? extends Object> r110, String r111) {
        if (r102.U == false) goto L5;
        b(r100, r101, "hot", r102, r110, r111);
    L5:
        Pair[] r103 = new Pair[2];
        String r104 = r102.f457167m;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103[0] = TuplesKt.to("app_id", r104);
        String r105 = r102.f457152a;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r103[1] = TuplesKt.to("access_key", r105);
        Map<String, ? extends Object> r106 = MapsKt.mutableMapOf(r103);
        r106.putAll(r110);
        if (r101 == true) goto L19;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r106.put("error_msg", r111);
    L19:
        r100.monitorStatusRate(MobConstants.DOWNLOAD_HOT_LIST_SUCCESS_RATE, !r101 ? 1 : 0, r106);
    }

    public static final void j(a r100, boolean r101, EffectConfig r102, String r103, String r104) {
        Pair[] r105 = new Pair[3];
        String r106 = r102.f457167m;
        if (r106 != null) goto L6;
        r106 = "";
    L6:
        r105[0] = TuplesKt.to("app_id", r106);
        String r107 = r102.f457152a;
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        r105[1] = TuplesKt.to("access_key", r107);
        r105[2] = TuplesKt.to("model_name", r103);
        Map<String, ? extends Object> r108 = MapsKt.mutableMapOf(r105);
        if (r101 == true) goto L16;
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        r108.put("error_msg", r104);
    L16:
        r100.monitorStatusRate("find_model_success_rate", !r101 ? 1 : 0, r108);
    }

    public static final void k(a r100, boolean r101, EffectConfig r102, Map<String, ? extends Object> r110, String r111) {
        if (r102.U == false) goto L5;
        b(r100, r101, "panel", r102, r110, r111);
    L5:
        Pair[] r103 = new Pair[2];
        String r104 = r102.f457167m;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103[0] = TuplesKt.to("app_id", r104);
        String r105 = r102.f457152a;
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r103[1] = TuplesKt.to("access_key", r105);
        Map<String, ? extends Object> r106 = MapsKt.mutableMapOf(r103);
        r106.putAll(r110);
        if (r101 == true) goto L19;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r106.put("error_msg", r111);
    L19:
        r100.monitorStatusRate(MobConstants.PANEL_INFO_SUCCESS_RATE, !r101 ? 1 : 0, r106);
    }

    public static final void b(a r100, boolean r101, String r102, EffectConfig r103, Map<String, ? extends Object> r104, String r105) {
        Pair[] r106 = new Pair[3];
        String r107 = r103.f457167m;
        if (r107 != null) goto L6;
        r107 = "";
    L6:
        r106[0] = TuplesKt.to("app_id", r107);
        String r108 = r103.f457152a;
        if (r108 != null) goto L10;
        r108 = "";
    L10:
        r106[1] = TuplesKt.to("access_key", r108);
        r106[2] = TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r102);
        Map<String, ? extends Object> r109 = MapsKt.mutableMapOf(r106);
        r109.putAll(r104);
        if (r101 == true) goto L16;
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r109.put("error_msg", r105);
    L16:
        r100.monitorStatusRate("ep_common_event", !r101 ? 1 : 0, r109);
    }

    public static final void d(a r100, boolean r101, EffectConfig r102, Effect r103, Map<String, ? extends Object> r104, String r110) {
        Pair[] r105 = new Pair[7];
        String r106 = r102.f457167m;
        if (r106 != null) goto L6;
        r106 = "";
    L6:
        int r107 = 0;
        r105[0] = TuplesKt.to("app_id", r106);
        String r108 = r102.f457152a;
        if (r108 != null) goto L10;
        r108 = "";
    L10:
        r105[1] = TuplesKt.to("access_key", r108);
        r105[2] = TuplesKt.to(MobConstants.EFFECT_ID, r103.getEffect_id());
        Integer r109 = r103.getFile_url().getUrl_type();
        if (r109 == null) goto L13;
        r107 = r109.intValue();
    L13:
        r105[3] = TuplesKt.to("effect_type", Integer.valueOf(r107));
        r105[4] = TuplesKt.to("source", Integer.valueOf(r103.getSource()));
        r105[5] = TuplesKt.to("panel", r103.getPanel());
        String r111 = com.ss.ugc.effectplatform.model.b.a(r103);
        if (r111 != null) goto L17;
        r111 = "";
    L17:
        r105[6] = TuplesKt.to("md5", r111);
        Map<String, ? extends Object> r112 = MapsKt.mutableMapOf(r105);
        r112.putAll(r104);
        if (r101 == true) goto L23;
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r112.put("error_msg", r110);
    L23:
        r100.monitorStatusRate(MobConstants.DOWNLOAD_EFFECT_SUCCESS_RATE, !r101 ? 1 : 0, r112);
    }

    public static void m(a r100, int r101, String r102, String r103, Float r104, Float r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 16) == 0) goto L14;
        r105 = null;
    L14:
        int r107 = 1;
        Map<String, ? extends Object> r108 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(r101))});
        if (r102 == null) goto L17;
        r108.put(LocationMonitorConst.ERR_MSG, r102);
    L17:
        if (r103 == null) goto L19;
        r108.put("log_id", r103);
    L19:
        if (r104 == null) goto L21;
        r108.put("clear_size", Float.valueOf(r104.floatValue()));
    L21:
        if (r105 == null) goto L23;
        r108.put("clear_proportion", Float.valueOf(r105.floatValue()));
    L23:
        if (r101 != 0) goto L25;
        r107 = 0;
    L25:
        r100.monitorStatusRate("ep_strategy_clean_result", r107, r108);
    }

    public static final void i(a r100, boolean r101, EffectConfig r102, Effect r103, String r104, String r105, String r110, Map<String, ? extends Object> r111, String r112) {
        Pair[] r106 = new Pair[7];
        String r107 = r102.f457167m;
        if (r107 != null) goto L6;
        r107 = "";
    L6:
        r106[0] = TuplesKt.to("app_id", r107);
        String r108 = r102.f457152a;
        if (r108 != null) goto L10;
        r108 = "";
    L10:
        r106[1] = TuplesKt.to("access_key", r108);
        r106[2] = TuplesKt.to(MobConstants.EFFECT_ID, r103.getEffect_id());
        r106[3] = TuplesKt.to("panel", r103.getPanel());
        r106[4] = TuplesKt.to("model_name", r104);
        r106[5] = TuplesKt.to("resource_type", r110);
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r106[6] = TuplesKt.to("model_version", r105);
        Map<String, ? extends Object> r109 = MapsKt.mutableMapOf(r106);
        r109.putAll(r111);
        if (r101 == true) goto L20;
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        r109.put("error_msg", r112);
    L20:
        r100.monitorStatusRate("model_download_success_rate", !r101 ? 1 : 0, r109);
    }
}
