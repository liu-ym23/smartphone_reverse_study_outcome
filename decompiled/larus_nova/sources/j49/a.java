package j49;

import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497373a = 0;

    static {
    }

    public a() {
    }

    public static void a() {
        DoraBuryPointManager.f331862a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "hw_volume_sync_switch_popup"), TuplesKt.to("window_content_action", new String[]{"open_hw_volume_sync", "close_hw_volume_sync"})}));
    }

    public static void b() {
        DoraBuryPointManager.f331862a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "keep_active_float_window"), TuplesKt.to("window_content_action", "open_more_settings")}));
    }

    public static void c() {
        DoraBuryPointManager.f331862a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "keep_active_float_window"), TuplesKt.to("window_content_action", "close_keep_active_window")}));
    }

    public static void d() {
        DoraBuryPointManager.f331862a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "keep_active_float_window"), TuplesKt.to("window_content_action", new String[]{"open_more_settings", "close_keep_active_window"})}));
    }

    public static void e() {
        DoraBuryPointManager.f331862a.L(CheckPointType.ENTER_PAGE, MapsKt.mapOf(new Pair[]{TuplesKt.to("current_page", "proactive_broadcast_add_app"), TuplesKt.to("previous_page", "proactive_broadcast")}));
    }

    public static void h() {
        DoraBuryPointManager.f331862a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "unbind_popup"), TuplesKt.to("window_content_action", "unbinding")}));
    }

    public static void i() {
        DoraBuryPointManager.f331862a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "unbind_popup"), TuplesKt.to("window_content_action", "unbinding")}));
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        DoraBuryPointManager.f331862a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", r100), TuplesKt.to("window_content_action", "skip_onboarding")}));
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        DoraBuryPointManager.f331862a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", r100), TuplesKt.to("window_content_action", "skip_onboarding")}));
    }

    public static void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("window_content_type", "device_discovery_popup");
        r103[1] = TuplesKt.to("window_content_action", r101);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r103[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r100);
        r102.L("dora_floating_window_click", MapsKt.mapOf(r103));
    }

    public static void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("window_content_type", "device_discovery_popup");
        r103[1] = TuplesKt.to("window_content_action", r101);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r103[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, r100);
        r102.L("dora_floating_window_show", MapsKt.mapOf(r103));
    }
}
