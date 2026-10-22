package nn3;

import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.ti1;
import com.bytedance.android.livesdk.gift.configmodel.GiftAfterSendConfig;
import com.bytedance.android.livesdk.gift.configmodel.GiftPanelOptConfig;
import com.bytedance.android.livesdk.gift.configmodel.GiftVolumeAdjustConfig;
import com.bytedance.android.livesdk.gift.configmodel.RevGiftConsumerRemindConfig;
import com.bytedance.android.livesdk.gift.configmodel.a0;
import com.bytedance.android.livesdk.gift.configmodel.a1;
import com.bytedance.android.livesdk.gift.configmodel.a2;
import com.bytedance.android.livesdk.gift.configmodel.b0;
import com.bytedance.android.livesdk.gift.configmodel.b1;
import com.bytedance.android.livesdk.gift.configmodel.b2;
import com.bytedance.android.livesdk.gift.configmodel.c0;
import com.bytedance.android.livesdk.gift.configmodel.c1;
import com.bytedance.android.livesdk.gift.configmodel.c2;
import com.bytedance.android.livesdk.gift.configmodel.d0;
import com.bytedance.android.livesdk.gift.configmodel.d1;
import com.bytedance.android.livesdk.gift.configmodel.d2;
import com.bytedance.android.livesdk.gift.configmodel.e0;
import com.bytedance.android.livesdk.gift.configmodel.e1;
import com.bytedance.android.livesdk.gift.configmodel.e2;
import com.bytedance.android.livesdk.gift.configmodel.f0;
import com.bytedance.android.livesdk.gift.configmodel.f2;
import com.bytedance.android.livesdk.gift.configmodel.g0;
import com.bytedance.android.livesdk.gift.configmodel.g1;
import com.bytedance.android.livesdk.gift.configmodel.h0;
import com.bytedance.android.livesdk.gift.configmodel.h2;
import com.bytedance.android.livesdk.gift.configmodel.i1;
import com.bytedance.android.livesdk.gift.configmodel.i2;
import com.bytedance.android.livesdk.gift.configmodel.j0;
import com.bytedance.android.livesdk.gift.configmodel.j2;
import com.bytedance.android.livesdk.gift.configmodel.k1;
import com.bytedance.android.livesdk.gift.configmodel.k2;
import com.bytedance.android.livesdk.gift.configmodel.l0;
import com.bytedance.android.livesdk.gift.configmodel.l1;
import com.bytedance.android.livesdk.gift.configmodel.l2;
import com.bytedance.android.livesdk.gift.configmodel.m0;
import com.bytedance.android.livesdk.gift.configmodel.m1;
import com.bytedance.android.livesdk.gift.configmodel.m2;
import com.bytedance.android.livesdk.gift.configmodel.n0;
import com.bytedance.android.livesdk.gift.configmodel.n1;
import com.bytedance.android.livesdk.gift.configmodel.n2;
import com.bytedance.android.livesdk.gift.configmodel.o1;
import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.android.livesdk.gift.configmodel.p;
import com.bytedance.android.livesdk.gift.configmodel.p0;
import com.bytedance.android.livesdk.gift.configmodel.p1;
import com.bytedance.android.livesdk.gift.configmodel.p2;
import com.bytedance.android.livesdk.gift.configmodel.q0;
import com.bytedance.android.livesdk.gift.configmodel.q1;
import com.bytedance.android.livesdk.gift.configmodel.q2;
import com.bytedance.android.livesdk.gift.configmodel.r;
import com.bytedance.android.livesdk.gift.configmodel.r0;
import com.bytedance.android.livesdk.gift.configmodel.r1;
import com.bytedance.android.livesdk.gift.configmodel.r2;
import com.bytedance.android.livesdk.gift.configmodel.s;
import com.bytedance.android.livesdk.gift.configmodel.s1;
import com.bytedance.android.livesdk.gift.configmodel.t;
import com.bytedance.android.livesdk.gift.configmodel.t0;
import com.bytedance.android.livesdk.gift.configmodel.u;
import com.bytedance.android.livesdk.gift.configmodel.u0;
import com.bytedance.android.livesdk.gift.configmodel.u1;
import com.bytedance.android.livesdk.gift.configmodel.v;
import com.bytedance.android.livesdk.gift.configmodel.v2;
import com.bytedance.android.livesdk.gift.configmodel.w;
import com.bytedance.android.livesdk.gift.configmodel.w0;
import com.bytedance.android.livesdk.gift.configmodel.w1;
import com.bytedance.android.livesdk.gift.configmodel.x;
import com.bytedance.android.livesdk.gift.configmodel.x0;
import com.bytedance.android.livesdk.gift.configmodel.x1;
import com.bytedance.android.livesdk.gift.configmodel.x2;
import com.bytedance.android.livesdk.gift.configmodel.y;
import com.bytedance.android.livesdk.gift.configmodel.y0;
import com.bytedance.android.livesdk.gift.configmodel.y1;
import com.bytedance.android.livesdk.gift.configmodel.y2;
import com.bytedance.android.livesdk.gift.configmodel.z0;
import com.bytedance.android.livesdk.gift.configmodel.z1;
import com.bytedance.android.livesdk.gift.platform.business.giftwall.GiftWallPreRequestManager;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.q;
import com.bytedance.android.livesdkapi.depend.model.LiveStartRoomOptConfig;
import com.bytedance.android.livesdkapi.depend.model.NewSendGiftConfig;
import com.bytedance.android.livesdkapi.model.GiftPlayerAutoReleaseSwitch;
import com.bytedance.android.livesdkapi.model.LynxAlphaPlayerAutoReleaseSwitch;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type a = null;
    public static final Type b = null;
    public static final Type c = null;
    public static final Type d = null;
    public static final Type e = null;
    public static final Type f = null;
    public static final Type g = null;
    public static final Type h = null;
    public static final Type i = null;
    public static final Type j = null;
    public static final Type k = null;
    public static final Type l = null;
    public static final Type m = null;
    public static final Type n = null;

    /* JADX INFO: renamed from: nn3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"nn3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/gift/configmodel/g1;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0148a extends TypeToken<Map<String, ? extends g1>> {
        public C0148a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends Integer>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c extends TypeToken<List<String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$d", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<List<? extends Integer>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$e", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/gift/configmodel/r2;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e extends TypeToken<List<? extends r2>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$f", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f extends TypeToken<List<? extends Integer>> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$g", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class g extends TypeToken<List<? extends Integer>> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$h", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h extends TypeToken<List<? extends Integer>> {
        public h() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"nn3/a$i", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class i extends TypeToken<HashMap<Long, Integer>> {
        public i() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$j", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class j extends TypeToken<List<? extends String>> {
        public j() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$k", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class k extends TypeToken<List<? extends Long>> {
        public k() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"nn3/a$l", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class l extends TypeToken<Map<String, ? extends Double>> {
        public l() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"nn3/a$m", "Lcom/google/gson/reflect/TypeToken;", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class m extends TypeToken<Map<String, String>> {
        public m() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"nn3/a$n", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class n extends TypeToken<Map<String, Map<String, ? extends String>>> {
        public n() {
        }
    }

    static {
        Type r0 = new h().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
        Type r1 = new b().getType();
        Intrinsics.checkNotNull(r1);
        b = r1;
        Type r2 = new j().getType();
        Intrinsics.checkNotNull(r2);
        c = r2;
        Type r3 = new g().getType();
        Intrinsics.checkNotNull(r3);
        d = r3;
        Type r4 = new n().getType();
        Intrinsics.checkNotNull(r4);
        e = r4;
        Type r5 = new i().getType();
        Intrinsics.checkNotNull(r5);
        f = r5;
        Type r6 = new f().getType();
        Intrinsics.checkNotNull(r6);
        g = r6;
        Type r7 = new d().getType();
        Intrinsics.checkNotNull(r7);
        h = r7;
        Type r8 = new C0148a().getType();
        Intrinsics.checkNotNull(r8);
        i = r8;
        Type r9 = new l().getType();
        Intrinsics.checkNotNull(r9);
        j = r9;
        Type r10 = new e().getType();
        Intrinsics.checkNotNull(r10);
        k = r10;
        Type r11 = new k().getType();
        Intrinsics.checkNotNull(r11);
        l = r11;
        Type r12 = new m().getType();
        Intrinsics.checkNotNull(r12);
        m = r12;
        Type r13 = new c().getType();
        Intrinsics.checkNotNull(r13);
        n = r13;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap r0 = UltraSettingsManager.a;
        Class r1 = Boolean.TYPE;
        UltraSettingsManager.b("enable_open_gift_panel_fps_monitor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_open_gift_panel_fps_monitor", Reflection.getOrCreateKotlinClass(r1), "打开礼物面板fps监控开关", "null"));
        UltraSettingsManager.b("live_gift_tray_slide_rate_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_slide_rate_config", Reflection.getOrCreateKotlinClass(v2.class), "礼物托盘速率配置", "yaozu"));
        UltraSettingsManager.b("comment_gift_guide_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("comment_gift_guide_config", Reflection.getOrCreateKotlinClass(zy1.b.class), "评论送礼引导配置", "wangting"));
        Class r2 = Integer.TYPE;
        UltraSettingsManager.b("live_gift_panel_image_refresh", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_image_refresh", Reflection.getOrCreateKotlinClass(r2), "礼物面板礼物icon闪跳问题优化", "zhaozhuo"));
        UltraSettingsManager.b("send_gift_open_recharge_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_open_recharge_opt", Reflection.getOrCreateKotlinClass(r1), "大礼物充值耗时优化", "zengjie"));
        UltraSettingsManager.b("live_topic_paging_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_topic_paging_fix", Reflection.getOrCreateKotlinClass(r1), "saas发现tab二级标签分页修复", "chenjiaxin"));
        UltraSettingsManager.b("anchor_sticker_effect_closed_notice_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_sticker_effect_closed_notice_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启人脸礼物关闭提示", "taojiayi"));
        UltraSettingsManager.b("live_gift_carnival_gift_tab_text_color", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_carnival_gift_tab_text_color", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.configmodel.l.class), "嘉年华礼物 tab 上方 text 纯色兜底，如果需要修改就改动此 setting，之所以会有这个问题是因为渐变色绘制太暗淡", "taojiayi"));
        UltraSettingsManager.b("live_gift_enable_saas_new_combo_ui", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_saas_new_combo_ui", Reflection.getOrCreateKotlinClass(r1), "saas连送按钮新样式", "yaozu"));
        UltraSettingsManager.b("live_gift_fly_dialog_delay_start", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_fly_dialog_delay_start", Reflection.getOrCreateKotlinClass(r1), "飞麦dialog延迟加载开关", "chenjiaxin"));
        UltraSettingsManager.b("live_download_gift_asset_jsb_opt_new", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_download_gift_asset_jsb_opt_new", Reflection.getOrCreateKotlinClass(r1), "downloadGiftAsset JSB重复请求优化", "zhaozhuo"));
        UltraSettingsManager.b("live_send_group_log_fixed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_group_log_fixed", Reflection.getOrCreateKotlinClass(r1), "大礼物成组送、展馆一键点亮等埋点问题修复", "wangting.levi"));
        UltraSettingsManager.b("live_gift_tray_pre_effect_filter", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_pre_effect_filter", a, "前置动过滤开关", "yaozu"));
        UltraSettingsManager.b("live_gift_sound_volume_dynamic_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sound_volume_dynamic_adjust", Reflection.getOrCreateKotlinClass(r1), "礼物声音大小动态调整", "zengjun"));
        UltraSettingsManager.b("live_small_gift_special_effect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_small_gift_special_effect", Reflection.getOrCreateKotlinClass(r1), "小礼物触发大特效资源校验开关", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_lynx_ui_canvas_monitor_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_ui_canvas_monitor_config", Reflection.getOrCreateKotlinClass(p1.class), "Lynx UICanvas监控设置", "huangweijie"));
        UltraSettingsManager.b("live_gift_cross_room_tray_queue_length", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_cross_room_tray_queue_length", Reflection.getOrCreateKotlinClass(r2), "微托盘队列长度", "yaozu"));
        UltraSettingsManager.b("live_gift_report_hot_room_event", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_report_hot_room_event", Reflection.getOrCreateKotlinClass(y1.class), "礼物模块上报当前直播间高热状态", "lifengji"));
        UltraSettingsManager.b("live_gift_carnival_top_bar_lynx_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_carnival_top_bar_lynx_info", Reflection.getOrCreateKotlinClass(v.class), "嘉年华礼物顶部运营位 Lynx 信息", "taojiayi"));
        UltraSettingsManager.b("live_gift_low_priority_operation_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_low_priority_operation_list", b, "低优先级运营位", "yaozu"));
        UltraSettingsManager.b("live_gift_tab_dynamization", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tab_dynamization", Reflection.getOrCreateKotlinClass(r1), "礼物tab动态化", "yaozu"));
        UltraSettingsManager.b("group_live_stream_message_rts", new com.bytedance.tools.kcp.ultrasettings.runtime.c("group_live_stream_message_rts", Reflection.getOrCreateKotlinClass(r1), "使用跟流消息", "qili"));
        UltraSettingsManager.b("live_opt_pad_gift_dialog", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_opt_pad_gift_dialog", Reflection.getOrCreateKotlinClass(x.class), "Pad/折叠屏下，礼物面板扩大曝光范围开关", "wangting.levi"));
        UltraSettingsManager.b("big_gift_frequency_config_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("big_gift_frequency_config_setting", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.configmodel.j.class), "大礼物连送频控", "lifengji"));
        UltraSettingsManager.b("live_recharge_recommend_dialog_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_recharge_recommend_dialog_url", Reflection.getOrCreateKotlinClass(String.class), "充值推荐面板url", "weiyupei"));
        UltraSettingsManager.b("yyh_interact_downgrade_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("yyh_interact_downgrade_config", Reflection.getOrCreateKotlinClass(ys1.a.class), "其他互动组件展示时礼物特效降级", "guozeyi"));
        UltraSettingsManager.b("live_gift_large_price_optimized", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_large_price_optimized", Reflection.getOrCreateKotlinClass(l0.class), "高价值礼物合规优化", "wangting.levi"));
        Class r3 = Long.TYPE;
        UltraSettingsManager.b("live_revenue_effect_revenue_service_delay_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_effect_revenue_service_delay_time", Reflection.getOrCreateKotlinClass(r3), "特效中枢延迟加载", "yaozu"));
        UltraSettingsManager.b("use_texturerender_catch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("use_texturerender_catch", Reflection.getOrCreateKotlinClass(r1), "使用离屏渲染截帧", "zhouenjie"));
        UltraSettingsManager.b("live_gift_tab_frequency_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tab_frequency_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物tab高频调用", "yaozu"));
        UltraSettingsManager.b("live_vs_vertical_open_effect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vs_vertical_open_effect", Reflection.getOrCreateKotlinClass(r1), "vs竖屏流直播间播放礼物特效", "chenjiaxin"));
        UltraSettingsManager.b("live_group_container_jsb_support_devices", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_container_jsb_support_devices", c, "团播容器隐藏 JSB 开关", "null"));
        UltraSettingsManager.b("live_fly_dialog_xiaomi_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fly_dialog_xiaomi_setting", Reflection.getOrCreateKotlinClass(r1), "修复小米Android13直播间因dialog引起的暗沉问题", "chenjiaxin"));
        UltraSettingsManager.b("live_support_gift_group_tips", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_support_gift_group_tips", Reflection.getOrCreateKotlinClass(String.class), "不支持成组送礼的礼物tips", "lifengji"));
        UltraSettingsManager.b("live_recharge_check_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_recharge_check_opt", Reflection.getOrCreateKotlinClass(r1), "前端充值链路优化-送礼jsb计算礼物价值需要带上buff卡礼物", "huangguoxiao"));
        UltraSettingsManager.b("live_gift_user_behavior", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_user_behavior", Reflection.getOrCreateKotlinClass(r1), "礼物面板用户行为采集", "wujinglei"));
        UltraSettingsManager.b("live_gift_open_dialog_locate_tab", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_open_dialog_locate_tab", Reflection.getOrCreateKotlinClass(r1), "礼物定位tab能力开关", "zhouenjie"));
        UltraSettingsManager.b("live_bag_gift_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_bag_gift_time", Reflection.getOrCreateKotlinClass(r1), "背包礼物过期时间显示截止时间", "zhangchi"));
        UltraSettingsManager.b("live_big_gift_combo_anim_leak_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_gift_combo_anim_leak_fix", Reflection.getOrCreateKotlinClass(r1), "大礼物连送动画泄漏修复", "null"));
        UltraSettingsManager.b("gift_message_new_struct", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_message_new_struct", Reflection.getOrCreateKotlinClass(r1), "礼物消息自带礼物结构", "lifengji"));
        UltraSettingsManager.b("live_big_gift_tray_combo_count_show_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_gift_tray_combo_count_show_limit", Reflection.getOrCreateKotlinClass(r2), "大礼物托盘连送数量展示上限", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_fresco_cache_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_fresco_cache_config", Reflection.getOrCreateKotlinClass(GiftPanelOptConfig.class), "礼物独立缓存配置", "chenweizhuo"));
        UltraSettingsManager.b("live_gift_display_free", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_display_free", Reflection.getOrCreateKotlinClass(r2), "-1为默认状态，0为对照组，大于0为可以礼物立见数量", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_sar_native_page_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sar_native_page_switch", Reflection.getOrCreateKotlinClass(l2.class), "SarNative页面切换开关", "zhouenjie"));
        UltraSettingsManager.b("live_gift_gl_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_gl_optimize", Reflection.getOrCreateKotlinClass(r1), "GL优化飞麦礼物性能及覆盖率", "changjianfei"));
        UltraSettingsManager.b("live_ban_send_gift_self_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ban_send_gift_self_switch", Reflection.getOrCreateKotlinClass(r1), "禁止自己给自己送礼功能开关", "zhaozhuo"));
        UltraSettingsManager.b("live_interact_gift_emoji_settings", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_gift_emoji_settings", Reflection.getOrCreateKotlinClass(b2.class), "飞麦礼物间隔时长以及场景支持", "zhanghao"));
        UltraSettingsManager.b("live_gift_sync_max_count_status", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sync_max_count_status", Reflection.getOrCreateKotlinClass(r2), "收到GiftMessage后礼物列表查找不到对应礼物时尝试拉取礼物列表次数", "zhaozhuo"));
        UltraSettingsManager.b("enable_gift_panel_monitor_window_fps", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_gift_panel_monitor_window_fps", Reflection.getOrCreateKotlinClass(r1), "打开礼物面板是否给FPSTracer设置Window", "null"));
        UltraSettingsManager.b("live_gift_buff_and_diy_card_diamond_group_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_buff_and_diy_card_diamond_group_opt", Reflection.getOrCreateKotlinClass(r1), "buff卡/选项卡优化", "lifengji"));
        UltraSettingsManager.b("effect_download_frequency_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("effect_download_frequency_limit", Reflection.getOrCreateKotlinClass(r2), "单个资源下载频控", "lifengji"));
        UltraSettingsManager.b("live_prop_send_timeout_report_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_prop_send_timeout_report_enable", Reflection.getOrCreateKotlinClass(r1), "送道具超时补单开关", "yaozu"));
        UltraSettingsManager.b("live_big_gift_combo_debounce_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_gift_combo_debounce_optimize", Reflection.getOrCreateKotlinClass(r1), "大礼物连送请求聚合开关", "lifengji"));
        UltraSettingsManager.b("live_gift_ai_asset_feature_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_ai_asset_feature_enable", Reflection.getOrCreateKotlinClass(r1), "AI资源加载优化", "chenfuqiang.xkj"));
        UltraSettingsManager.b("live_gift_anchor_support_cloud_room_gift", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_anchor_support_cloud_room_gift", Reflection.getOrCreateKotlinClass(r1), "云导播场景嘉宾主播侧直播间，是否展示用户侧在云导播直播间发送给当前主播的礼物消息，开关兜底用", "yuanbin.sakuragi"));
        UltraSettingsManager.b("live_gift_page_gift_count_min", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_page_gift_count_min", Reflection.getOrCreateKotlinClass(m0.class), "礼物列表最少数量", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_minors_notice_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_minors_notice_config", Reflection.getOrCreateKotlinClass(s1.class), "礼物面板未成年人消费提示", "chenweizhuo"));
        UltraSettingsManager.b("live_gift_tray_optimize_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_optimize_v2", Reflection.getOrCreateKotlinClass(r1), "礼物托盘优化改造2期", "yaozu"));
        UltraSettingsManager.b("live_ds_allow_enter_gift_animation", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ds_allow_enter_gift_animation", Reflection.getOrCreateKotlinClass(r1), "进房倡议动画开关", "lifengji"));
        UltraSettingsManager.b("pk_single_view_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_single_view_enable", Reflection.getOrCreateKotlinClass(r1), "PK单View开关", "lvpeng"));
        UltraSettingsManager.b("live_gift_merge_interact_gift_request_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_merge_interact_gift_request_switch", Reflection.getOrCreateKotlinClass(r1), "互动礼物聚合请求开关", "yaozu"));
        UltraSettingsManager.b("live_gift_send_group_optimize_enabled", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_send_group_optimize_enabled", Reflection.getOrCreateKotlinClass(r1), "礼物成组送解耦开关", "chenjiaxin"));
        UltraSettingsManager.b("gift_tray_use_small_ui_in_multi_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_tray_use_small_ui_in_multi_scene", Reflection.getOrCreateKotlinClass(r1), "多人场景下使用缩小的礼物托盘", "lifengji"));
        UltraSettingsManager.b("live_tray_effect_message_queue", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_tray_effect_message_queue", Reflection.getOrCreateKotlinClass(r1), "小礼物是否走特效下载逻辑", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_big_gift_enable_long_click", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_big_gift_enable_long_click", Reflection.getOrCreateKotlinClass(r1), "大礼物长按开关", "yaozu"));
        UltraSettingsManager.b("live_monitor_send_gift_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_monitor_send_gift_time", Reflection.getOrCreateKotlinClass(r1), "统计金主送礼后到看见礼物特效时间功能开关", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_guest_refresh_local_data", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_guest_refresh_local_data", Reflection.getOrCreateKotlinClass(r1), "连麦场景是否开启嘉宾刷新礼物本地数据", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_delay_fetch_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_delay_fetch_time", Reflection.getOrCreateKotlinClass(p.class), "延迟获取礼物资源列表时间", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_show_and_send_event_aggregation_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_show_and_send_event_aggregation_config", Reflection.getOrCreateKotlinClass(t0.class), "用户维度礼物面板曝光上报", "wanghaodong.321"));
        UltraSettingsManager.b("live_revenue_gift_icon_degrade_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_gift_icon_degrade_config", Reflection.getOrCreateKotlinClass(r1), "营收礼物icon动画性能降级", "ouzhiqian"));
        UltraSettingsManager.b("live_gift_resource_delete_size_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_resource_delete_size_threshold", Reflection.getOrCreateKotlinClass(r3), "设备存储空间低于阈值时触发礼物资源过期删除,-1为未命中实验", "zhaozhuo"));
        UltraSettingsManager.b("live_speed_slot_toolbar_item_server_ctrl", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_speed_slot_toolbar_item_server_ctrl", Reflection.getOrCreateKotlinClass(r1), "快捷礼物接入toolbar改造", "yaozu"));
        UltraSettingsManager.b("live_small_gift_tray_combo_count_upper_bound", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_small_gift_tray_combo_count_upper_bound", Reflection.getOrCreateKotlinClass(o2.class), "小礼物连送数值上限", "taojiayi"));
        UltraSettingsManager.b("live_gift_api_request_use_uplink", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_api_request_use_uplink", Reflection.getOrCreateKotlinClass(r1), "礼物api请求是否使用消息上行能力", "wanghaodong.321"));
        UltraSettingsManager.b("live_activity_float_asset_download_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_activity_float_asset_download_config", Reflection.getOrCreateKotlinClass(x1.class), "飘屏特效预下载", "chenjiaxin"));
        UltraSettingsManager.b("live_incentives_experiment_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_incentives_experiment_enable", Reflection.getOrCreateKotlinClass(r1), "直播激励屏蔽实验开关", "fengguangyuan"));
        UltraSettingsManager.b("send_gift_relation_expire_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_relation_expire_time", Reflection.getOrCreateKotlinClass(r2), "本地记录送礼关系有效期(天)", "null"));
        UltraSettingsManager.b("live_gift_panel_topic_item_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_topic_item_config", Reflection.getOrCreateKotlinClass(z0.class), "发现tab二级标签配置", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_tray_post_effect_filter", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_post_effect_filter", d, "后置动效过滤开关", "yaozu"));
        UltraSettingsManager.b("live_group_component_close_simple_mode_by_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_component_close_simple_mode_by_type", Reflection.getOrCreateKotlinClass(r1), "团播容器对礼物菜单和互动组件关闭精简模式", "null"));
        UltraSettingsManager.b("live_gift_marketing_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_marketing_config", Reflection.getOrCreateKotlinClass(q0.class), "礼物面板导购区配置", "wangting.levi"));
        UltraSettingsManager.b("live_revenue_rich_content_image_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_rich_content_image_opt", Reflection.getOrCreateKotlinClass(q.class), "营收公屏图片webp优化", "null"));
        UltraSettingsManager.b("doodle_pre_download", new com.bytedance.tools.kcp.ultrasettings.runtime.c("doodle_pre_download", Reflection.getOrCreateKotlinClass(r1), "是否开启涂鸦资源预下载", "wangting"));
        UltraSettingsManager.b("live_gift_asr_manager_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_asr_manager_config", Reflection.getOrCreateKotlinClass(oe1.a.class), "礼物 ASR 配置", "taojiayi"));
        UltraSettingsManager.b("live_json_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_json_opt_enable", Reflection.getOrCreateKotlinClass(n1.class), "直播间json优化", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_multiple_send_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_multiple_send_optimize", Reflection.getOrCreateKotlinClass(r2), "多人互动场景送礼优化开关", "yaozu"));
        UltraSettingsManager.b("live_gift_tray_queue_length", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_queue_length", Reflection.getOrCreateKotlinClass(r2), "托盘队列长度", "zhouenjie"));
        UltraSettingsManager.b("live_gift_effect_show_touch_listener", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_show_touch_listener", Reflection.getOrCreateKotlinClass(r1), "礼物特效展现增加监听", "zhaozhuo.119"));
        UltraSettingsManager.b("live_anya_frequent_alog_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anya_frequent_alog_opt", Reflection.getOrCreateKotlinClass(r1), "Anya框架ALog耗时优化", "null"));
        UltraSettingsManager.b("live_gift_msg_consume_max_report_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_msg_consume_max_report_count", Reflection.getOrCreateKotlinClass(r2), "礼物消息跟踪日志最大上报数量", "chenfuqiang"));
        UltraSettingsManager.b("notification_gift_view_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("notification_gift_view_duration", e, "一起送播报托盘时长", "wangting.levi"));
        UltraSettingsManager.b("live_gifts_not_use_required_assets", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gifts_not_use_required_assets", Reflection.getOrCreateKotlinClass(long[].class), "礼物资源是否使用required_assets字段下载", "wangting.levi"));
        UltraSettingsManager.b("group_live_container_rts", new com.bytedance.tools.kcp.ultrasettings.runtime.c("group_live_container_rts", Reflection.getOrCreateKotlinClass(r1), "RTS团播容器", "qili"));
        UltraSettingsManager.b("live_sticker_match_gift_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sticker_match_gift_config", Reflection.getOrCreateKotlinClass(p2.class), "贴纸内容识别礼物配置", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_gift_ttplayer_use_hardcore", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_ttplayer_use_hardcore", Reflection.getOrCreateKotlinClass(r2), "视频礼物TTPlayer是否开启硬解,0:不开启,1:开启", "lifengji"));
        UltraSettingsManager.b("gift_resource_unzip_method", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_resource_unzip_method", Reflection.getOrCreateKotlinClass(r2), "使用 ZipFile 解压资源包", "null"));
        UltraSettingsManager.b("live_gift_panel_open_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_open_opt", Reflection.getOrCreateKotlinClass(u0.class), "down事件时预拉取礼物列表", "zhaozhuo"));
        UltraSettingsManager.b("gift_new_preloader_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_new_preloader_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.d.class), "礼物面板新预加载框架配置", "null"));
        UltraSettingsManager.b("live_group_component_use_wrds", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_component_use_wrds", Reflection.getOrCreateKotlinClass(r1), "是否切换为WRDS方案", "shenxiaoyu.416"));
        UltraSettingsManager.b("live_gift_update_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_update_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物面板实时刷新优化", "lifengji"));
        UltraSettingsManager.b("live_gift_message_interceptor_order", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_message_interceptor_order", Reflection.getOrCreateKotlinClass(r1), "普通直播间GiftMessage拦截器执行顺序", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_dynamic_card_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_dynamic_card_config", Reflection.getOrCreateKotlinClass(x0.class), "礼物面板系列礼物运营位配置", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_sp_cache_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sp_cache_fix", Reflection.getOrCreateKotlinClass(r1), "本地sp存储读取修复", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_lynx_gift_load_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_gift_load_opt_config", Reflection.getOrCreateKotlinClass(q1.class), "Lynx 礼物加载优化", "dongbin.01"));
        UltraSettingsManager.b("live_anchor_gift_downgrade_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_gift_downgrade_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.configmodel.b.class), "主播送礼降级配置", "pengxiangshuai"));
        UltraSettingsManager.b("live_send_gift_check_buff_card", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_gift_check_buff_card", Reflection.getOrCreateKotlinClass(r1), "送礼时校验buff卡是否匹配", "wangting.levi"));
        UltraSettingsManager.b("live_clear_screen_gift_half_screen", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_clear_screen_gift_half_screen", Reflection.getOrCreateKotlinClass(r1), "礼物面板半清屏优化", "ouzhiqian"));
        UltraSettingsManager.b("live_gift_fast_task_destroy_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_fast_task_destroy_opt", Reflection.getOrCreateKotlinClass(r1), "任务快捷送礼销毁时机优化", "huangguoxiao"));
        UltraSettingsManager.b("live_gift_tray_message_unique_key_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_message_unique_key_opt", Reflection.getOrCreateKotlinClass(r1), "托盘礼物uniqueKey优化", "zhengjinyang"));
        UltraSettingsManager.b("live_gift_show_skin_animation_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_show_skin_animation_interval", Reflection.getOrCreateKotlinClass(r3), "礼物皮肤动画展示间隔", "xingweike.science"));
        UltraSettingsManager.b("live_gift_hotroom_optimize_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_hotroom_optimize_switch", Reflection.getOrCreateKotlinClass(r2), "高热直播间客户端逻辑开关, 0b01 mp4礼物过期, 0b10 人脸礼物过期", "lifengji"));
        UltraSettingsManager.b("LIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN", new com.bytedance.tools.kcp.ultrasettings.runtime.c("LIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN", Reflection.getOrCreateKotlinClass(r1), "节目直播间礼物托盘位置上移开关", "huangshaohua"));
        UltraSettingsManager.b("live_fans_club_renew_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fans_club_renew_config", Reflection.getOrCreateKotlinClass(r.class), "粉丝团送礼点亮规则", "huangguxiao"));
        UltraSettingsManager.b("live_public_screen_platform_transparent", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_public_screen_platform_transparent", Reflection.getOrCreateKotlinClass(r1), "小游戏投屏启用公屏调整优化", "jiangxiangzhou"));
        UltraSettingsManager.b("live_gift_sr_config_alg_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sr_config_alg_type", Reflection.getOrCreateKotlinClass(r2), "礼物超分算法配置 0:2倍, 4:1.5倍，默认1.5倍", "chenfuqiang"));
        UltraSettingsManager.b("live_gift_dynamic_operation_lynx_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_dynamic_operation_lynx_config", Reflection.getOrCreateKotlinClass(a1.class), "礼物面板动态化运营位配置", "huangguoxiao"));
        UltraSettingsManager.b("live_gift_first_frame_optimize_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_first_frame_optimize_switch", Reflection.getOrCreateKotlinClass(r1), "礼物面板首帧优化开关", "lifengji"));
        UltraSettingsManager.b("sticker_close_gift_information_popup_dialog_configuration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("sticker_close_gift_information_popup_dialog_configuration", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.core.ui.configuration.q.class), "人脸礼物关闭弹窗文案", "taojiayi"));
        UltraSettingsManager.b("live_gift_diy_send_text_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_diy_send_text_enable", Reflection.getOrCreateKotlinClass(r1), "礼物diy卡支持未解锁替换选中态文案", "wangting"));
        UltraSettingsManager.b("live_gift_lynx_effect_container_use_anniex", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_lynx_effect_container_use_anniex", Reflection.getOrCreateKotlinClass(r1), "Lynx特效容器使用极简卡", "yaozu"));
        UltraSettingsManager.b("live_gift_combo_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_combo_opt", Reflection.getOrCreateKotlinClass(r1), "连送效果优化", "yaozu"));
        UltraSettingsManager.b("send_effect_to_lynx_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_effect_to_lynx_fix", Reflection.getOrCreateKotlinClass(r1), "lynx event 修复", "yaozu"));
        UltraSettingsManager.b("live_gift_assets_pre_download", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_assets_pre_download", Reflection.getOrCreateKotlinClass(s.class), "礼物特效资源进effect队列前下载", "chenjiaxin"));
        UltraSettingsManager.b("sticker_gift_information_popup_dialog_configuration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("sticker_gift_information_popup_dialog_configuration", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.core.ui.configuration.q.class), "人脸礼物说明配置", "taojiayi"));
        UltraSettingsManager.b("live_lynx_group_live_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_group_live_list", Reflection.getOrCreateKotlinClass(l1.class), "团播送礼主播页配置", "chenweizhuo"));
        UltraSettingsManager.b("live_gift_panel_enable_gift_dynamic_icon_from_card", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_enable_gift_dynamic_icon_from_card", Reflection.getOrCreateKotlinClass(r1), "礼物面板支持展示选项卡外显的动态icon", "wanghaodong.321"));
        UltraSettingsManager.b("live_revenue_is_group_live_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_is_group_live_opt", Reflection.getOrCreateKotlinClass(r1), "营收团播判断优化", "tiyiran"));
        UltraSettingsManager.b("tray_queue_optimize_and_new_animation_new", new com.bytedance.tools.kcp.ultrasettings.runtime.c("tray_queue_optimize_and_new_animation_new", Reflection.getOrCreateKotlinClass(r2), "000 对照组，001 开启队列优化+托盘固定时间，010 开启队列优化+托盘非固定时间", "zhouenjie"));
        UltraSettingsManager.b("live_gift_choose_receiver_dialog", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_choose_receiver_dialog", Reflection.getOrCreateKotlinClass(String.class), "多人互动场景更换收礼人面板scheme", "liqun.fighting"));
        UltraSettingsManager.b("live_anya_computing_layout_crash_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anya_computing_layout_crash_fix", Reflection.getOrCreateKotlinClass(r1), "Anya框架computingLayout crash修复兜底开关", "huangweijie"));
        UltraSettingsManager.b("live_gift_list_filter_config_opt_new", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_filter_config_opt_new", Reflection.getOrCreateKotlinClass(r1), "礼物列表过滤时机优化", "zhaozhuo"));
        UltraSettingsManager.b("live_disable_gift_item_completely_visible_action", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_gift_item_completely_visible_action", Reflection.getOrCreateKotlinClass(r1), "屏蔽OnGiftListItemCompletelyVisibleChanged", "huangweijie"));
        UltraSettingsManager.b("live_gift_panel_icon_refresh_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_icon_refresh_opt", Reflection.getOrCreateKotlinClass(r1), "礼物面板礼物icon刷新去重", "wanghaodong.321"));
        UltraSettingsManager.b("live_anchor_gift_animation_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_gift_animation_switch", Reflection.getOrCreateKotlinClass(z1.class), "主播侧展示礼物特效", "pengxiangshuai"));
        UltraSettingsManager.b("group_live_fe_fold_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("group_live_fe_fold_opt", Reflection.getOrCreateKotlinClass(r1), "限时竞争大屏优化", "caojiaming.99"));
        UltraSettingsManager.b("live_gift_resource_delay_download_threshold_value", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_resource_delay_download_threshold_value", Reflection.getOrCreateKotlinClass(r1), "超低存储资源下载优化", "zhaozhuo"));
        UltraSettingsManager.b("live_landscape_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_landscape_opt_config", Reflection.getOrCreateKotlinClass(d51.class), "横屏体验框架优化配置", "null"));
        UltraSettingsManager.b("live_gift_top_effect_load_amazing", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_top_effect_load_amazing", Reflection.getOrCreateKotlinClass(r1), "顶部特效加载so", "yaozu"));
        UltraSettingsManager.b("live_gift_msg_consume_timeout_ms", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_msg_consume_timeout_ms", Reflection.getOrCreateKotlinClass(r2), "礼物消息消费超时时间,单位s", "chenfuqiang"));
        UltraSettingsManager.b("send_gift_failed_not_fans_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_failed_not_fans_url", Reflection.getOrCreateKotlinClass(String.class), "非粉丝团成员送礼失败弹框url", "lijianxin"));
        UltraSettingsManager.b("live_gift_reorder_optimize_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_reorder_optimize_enable", Reflection.getOrCreateKotlinClass(r1), "&控制请求数量逻辑开关", "lifengji"));
        UltraSettingsManager.b("live_giftpanel_property_expire_remind_II", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_giftpanel_property_expire_remind_II", Reflection.getOrCreateKotlinClass(r2), "礼物道具过期提醒开关", "fengguangyuan"));
        UltraSettingsManager.b("live_gift_send_timeout_report_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_send_timeout_report_enable", Reflection.getOrCreateKotlinClass(r1), "送礼超时补单开关", "chenhao.z"));
        UltraSettingsManager.b("gift_preview_debug_widget_load_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_preview_debug_widget_load_switch", Reflection.getOrCreateKotlinClass(r1), "礼物播放预览widget开关", "taojiayi"));
        UltraSettingsManager.b("live_gift_recommend_receiver_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_recommend_receiver_switch", Reflection.getOrCreateKotlinClass(r1), "推荐选人策略开关", "yaozu"));
        UltraSettingsManager.b("live_enable_functional_user_enter_asset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_functional_user_enter_asset", Reflection.getOrCreateKotlinClass(r1), "启用开通特效走入场队列的功能", "dangyingkai"));
        UltraSettingsManager.b("live_gift_activity_animation_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_activity_animation_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.configmodel.a.class), "顶部特效配置项", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_gift_coin_notice_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_coin_notice_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.configmodel.n.class), "礼物面板抖币改名提示", "gaoshiqi"));
        UltraSettingsManager.b("live_group_container_support_landscape", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_container_support_landscape", Reflection.getOrCreateKotlinClass(r1), "团播容器支持横屏开关", "null"));
        UltraSettingsManager.b("live_gift_enable_tray_new_named_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_tray_new_named_style", Reflection.getOrCreateKotlinClass(r1), "是否开启礼物托盘改造新样式", "yaozu"));
        UltraSettingsManager.b("live_gift_enable_schema", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_schema", Reflection.getOrCreateKotlinClass(r1), "vs礼物面板", "yaozu"));
        UltraSettingsManager.b("live_gift_lynx_effect_single_event", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_lynx_effect_single_event", Reflection.getOrCreateKotlinClass(r1), "lynx特效单页面通知开关", "zhouenjie"));
        UltraSettingsManager.b("live_gift_tray_optimize_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_optimize_duration", Reflection.getOrCreateKotlinClass(r1), "礼物托盘时长优化实验", "yaozu"));
        UltraSettingsManager.b("live_gift_revenue_interact_tray_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_revenue_interact_tray_enable", Reflection.getOrCreateKotlinClass(r1), "pk场景微托盘", "yaozu"));
        UltraSettingsManager.b("live_anya_mutate_dead_lock_anr_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anya_mutate_dead_lock_anr_fix", Reflection.getOrCreateKotlinClass(r1), "Anya框架mutate死锁问题修复", "null"));
        UltraSettingsManager.b("live_gift_tray_duration_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_duration_opt", Reflection.getOrCreateKotlinClass(r1), "礼物托盘耗时优化", "lilei.an"));
        UltraSettingsManager.b("live_vision_degrade_v2_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vision_degrade_v2_config", Reflection.getOrCreateKotlinClass(w.class), "直播间视频降级二期-礼物托盘部分", "wangting.levi"));
        UltraSettingsManager.b("effect_sync_limit_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("effect_sync_limit_interval", Reflection.getOrCreateKotlinClass(r2), "资源下载时间间隔频控", "lifengji"));
        UltraSettingsManager.b("douyin_user_clean_appasset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("douyin_user_clean_appasset", Reflection.getOrCreateKotlinClass(r1), "极致清理开关", "zhaozhuo"));
        UltraSettingsManager.b("livesdk_gift_ai_prediction_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("livesdk_gift_ai_prediction_config", Reflection.getOrCreateKotlinClass(zz1.b.class), "礼物 AI 助手聊天框配置", "taojiayi"));
        UltraSettingsManager.b("live_gift_anchor_post_effect_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_anchor_post_effect_config", Reflection.getOrCreateKotlinClass(lz1.a.class), "主播礼物展馆后置动效相关配置", "taojiayi"));
        UltraSettingsManager.b("live_gift_msg_consume_stage_trace_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_msg_consume_stage_trace_enable", Reflection.getOrCreateKotlinClass(r1), "礼物消息消费跟踪开关", "chenfuqiang"));
        UltraSettingsManager.b("live_gift_panel_new_architecture", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_new_architecture", Reflection.getOrCreateKotlinClass(u1.class), "礼物面板新框架", "yaozu"));
        UltraSettingsManager.b("live_gift_list_request_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_request_config", Reflection.getOrCreateKotlinClass(y0.class), "礼物场景化排序配置", "zhaozhuo"));
        UltraSettingsManager.b("live_asset_clean_strategy_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_asset_clean_strategy_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.configmodel.i.class), "礼物清理策略", "chenjiaxin"));
        UltraSettingsManager.b("live_enable_gift_panel_height_increase", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_gift_panel_height_increase", Reflection.getOrCreateKotlinClass(r1), "直播礼物面板增高", "liushengheng"));
        UltraSettingsManager.b("live_gold_rocket_first_hint_time_max", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gold_rocket_first_hint_time_max", f, "金火箭未报名用户每次首次送出最大展示hint次数", "zhouenjie"));
        UltraSettingsManager.b("live_group_refresh_layout_when_orientation_change", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_refresh_layout_when_orientation_change", Reflection.getOrCreateKotlinClass(r1), "横竖屏切换时是否刷新布局", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_gift_sound_and_vibration_switch_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sound_and_vibration_switch_config", Reflection.getOrCreateKotlinClass(c0.class), "礼物特效开关新配置", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_send_gift_jsb_exchange_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_gift_jsb_exchange_opt", Reflection.getOrCreateKotlinClass(m2.class), "送礼JSB兼容兑换并送礼逻辑", "gaoshiqi"));
        UltraSettingsManager.b("live_gift_effect_play_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_play_interval", Reflection.getOrCreateKotlinClass(r2), "礼物特效播放间隔", "chenhao.z"));
        UltraSettingsManager.b("live_gift_tray_enable_high_layer", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_enable_high_layer", Reflection.getOrCreateKotlinClass(r1), "礼物托盘高层级开关", "yaozu"));
        UltraSettingsManager.b("live_default_select_optimize_for_android", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_default_select_optimize_for_android", Reflection.getOrCreateKotlinClass(r2), "默认选中策略：0：失败不记/不找背包 1：失败不记/找背包 2：失败记/不找背包  3：失败记/找背包", "gaoshiqi"));
        UltraSettingsManager.b("live_gift_load_local_wto_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_load_local_wto_enable", Reflection.getOrCreateKotlinClass(r1), "礼物loadlocal接入调度框架", "ouzhiqian"));
        UltraSettingsManager.b("live_gift_panel_open_monitor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_open_monitor_enable", Reflection.getOrCreateKotlinClass(r1), "打开送礼面板性能监控", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_hotsoon_prop_asset_not_in_list_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_hotsoon_prop_asset_not_in_list_optimize", Reflection.getOrCreateKotlinClass(r1), "火山大礼物道具加载中优化", "taojiayi"));
        UltraSettingsManager.b("gift_widget_sp_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_widget_sp_opt", Reflection.getOrCreateKotlinClass(r1), "进房SP优化", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_tray_dialog_level_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_dialog_level_fix", Reflection.getOrCreateKotlinClass(r1), "低版本礼物托盘高层级fix", "yaozu"));
        UltraSettingsManager.b("live_ai_gift_async_sort_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ai_gift_async_sort_config", Reflection.getOrCreateKotlinClass(c2.class), "直播端智能礼物异步排序配置", "chenhao.z"));
        UltraSettingsManager.b("live_gift_tray_jank_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_jank_opt_config", Reflection.getOrCreateKotlinClass(fy1.a.class), "礼物托盘卡顿调用优化配置", "huangweijie"));
        UltraSettingsManager.b("gift_download_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_download_optimize", Reflection.getOrCreateKotlinClass(r2), "礼物下载带宽优化策略,最低位是下载资源限速,第二位是顺序调整", "chenfuqiang"));
        UltraSettingsManager.b("live_gift_queue_switch_consume_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_queue_switch_consume_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物特效队列消费开关位置优化", "chenfuqiang"));
        UltraSettingsManager.b("async_load_gift_resource_when_app_launch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("async_load_gift_resource_when_app_launch", Reflection.getOrCreateKotlinClass(r1), "是否开启宿主启动时异步加载礼物资源优化", "wangting"));
        UltraSettingsManager.b("live_gift_consume_remind_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_consume_remind_config", Reflection.getOrCreateKotlinClass(RevGiftConsumerRemindConfig.class), "是否显示礼物消费提醒入口", "lifengji"));
        UltraSettingsManager.b("live_gift_panel_list_ohr_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_list_ohr_config", Reflection.getOrCreateKotlinClass(i1.class), "礼物面板左右手适配", "lvruohui"));
        UltraSettingsManager.b("live_animator_duration_scale_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_animator_duration_scale_fix", Reflection.getOrCreateKotlinClass(r1), "属性动画缩放修复", "chenfuqiang"));
        UltraSettingsManager.b("live_gift_mp4_mask_fix_special_text_symbol_height", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_mp4_mask_fix_special_text_symbol_height", Reflection.getOrCreateKotlinClass(r1), "alphaPlayer融合元素是否启用对文本类型特殊符号的高度计算优化", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_lynx_effect_play_metrics_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_lynx_effect_play_metrics_enable", Reflection.getOrCreateKotlinClass(r1), "Lynx礼物特效播放指标开关", "huangweijie"));
        UltraSettingsManager.b("live_gift_panel_first_resume_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_first_resume_fix", Reflection.getOrCreateKotlinClass(r1), "礼物面板第一次resume才触发动作", "huangweijie"));
        UltraSettingsManager.b("live_gift_effect_play_metrics_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_play_metrics_enable", Reflection.getOrCreateKotlinClass(r1), "礼物特效播放指标开关", "huangweijie"));
        UltraSettingsManager.b("live_gift_card_containerization_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_card_containerization_config", Reflection.getOrCreateKotlinClass(u.class), "buff卡容器化", "yaozu"));
        UltraSettingsManager.b("live_disable_old_container_gesture_gift", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_old_container_gesture_gift", Reflection.getOrCreateKotlinClass(r1), "手势礼物是否下线直播老容器", "songzongze"));
        UltraSettingsManager.b("gift_icon_load_monitor_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_icon_load_monitor_threshold", Reflection.getOrCreateKotlinClass(r2), "礼物面板icon加载耗时监控阈值", "null"));
        UltraSettingsManager.b("live_gift_banner_rev_container_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_banner_rev_container_switch", Reflection.getOrCreateKotlinClass(r2), "礼物banner使用容器标准化开关", "lifengji"));
        UltraSettingsManager.b("live_start_room_opt_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_start_room_opt_switch", Reflection.getOrCreateKotlinClass(LiveStartRoomOptConfig.class), "直播秒开开关", "yangxiaolong.1024"));
        UltraSettingsManager.b("live_new_pk_effect_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_pk_effect_enable", Reflection.getOrCreateKotlinClass(r1), "pk跟流走新接口", "zhouenjie"));
        UltraSettingsManager.b("enable_find_inner_scope_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_find_inner_scope_optimize", Reflection.getOrCreateKotlinClass(r1), "findInnerScope耗时优化", "lifengji"));
        UltraSettingsManager.b("live_send_gift_group_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_gift_group_opt", Reflection.getOrCreateKotlinClass(r1), "成组送group问题修复", "zhaozhuo"));
        UltraSettingsManager.b("download_assets_force_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("download_assets_force_anchor", Reflection.getOrCreateKotlinClass(r1), "JSB下载强制切换为主播", "zhengjingyang.5620"));
        UltraSettingsManager.b("live_gift_effect_memory_metrics_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_memory_metrics_enable", Reflection.getOrCreateKotlinClass(r1), "礼物特效播放内存指标开关", "huangweijie"));
        UltraSettingsManager.b("live_scene_gift_sync_config_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_scene_gift_sync_config_setting", Reflection.getOrCreateKotlinClass(ys1.b.class), "金主礼物排序端上特征值传递配置", "wangbing"));
        UltraSettingsManager.b("gift_extra_frequency_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_extra_frequency_check", Reflection.getOrCreateKotlinClass(r1), "是否开启 gift/extra 频率校验功能", "taojiayi"));
        UltraSettingsManager.b("live_gift_interact_gift_request_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_interact_gift_request_count", Reflection.getOrCreateKotlinClass(r2), "礼物单页请求个数", "yaozu"));
        UltraSettingsManager.b("live_gift_extra_request_advance_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_extra_request_advance_opt", Reflection.getOrCreateKotlinClass(r1), "礼物extra提前到创建面板时请求", "null"));
        UltraSettingsManager.b("live_open_panel_preload_icon_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_open_panel_preload_icon_count", Reflection.getOrCreateKotlinClass(r2), "打开送礼面板预加载礼物icon数量", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_effect_player_dasp_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_player_dasp_enable", Reflection.getOrCreateKotlinClass(r1), "礼物特效TTVideoEngine配置DASP开关", "huangweijie"));
        UltraSettingsManager.b("live_recharge_path_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_recharge_path_opt", Reflection.getOrCreateKotlinClass(r2), "充值通用路径优化一期 0: 对照组 1、2、3实验组", "weiyupei"));
        UltraSettingsManager.b("live_gift_tray_effect_high_layer_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_effect_high_layer_switch", Reflection.getOrCreateKotlinClass(r1), "托盘特效高层级开关", "yaozu"));
        UltraSettingsManager.b("live_gift_white_snake_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_white_snake_config", Reflection.getOrCreateKotlinClass(y2.class), "白蛇传说配置", "yaozu"));
        UltraSettingsManager.b("live_gift_icon_bitmap_draw_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_icon_bitmap_draw_enable", Reflection.getOrCreateKotlinClass(r1), "礼物面板icon图片渲染优化", "wangting"));
        UltraSettingsManager.b("live_gift_guest_hint_animation_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_guest_hint_animation_config", Reflection.getOrCreateKotlinClass(e0.class), "选人提示动画配置", "yaozu"));
        UltraSettingsManager.b("live_gift_tray_enable_high_layer_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_enable_high_layer_anchor", Reflection.getOrCreateKotlinClass(r1), "主播礼物托盘高层级开关", "yaozu"));
        UltraSettingsManager.b("live_prop_card_hide_dialog", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_prop_card_hide_dialog", Reflection.getOrCreateKotlinClass(r1), "送出道具卡是否收起面板", "zhouenjie"));
        UltraSettingsManager.b("live_ai_gift_list_preload_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ai_gift_list_preload_config", Reflection.getOrCreateKotlinClass(d2.class), "直播端智能拉取礼物列表", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_sound_volume_adjust_configs", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_sound_volume_adjust_configs", Reflection.getOrCreateKotlinClass(GiftVolumeAdjustConfig.class), "礼物声音大小动态调整config", "zengjun"));
        UltraSettingsManager.b("vs_live_interactive_container_show_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("vs_live_interactive_container_show_type", Reflection.getOrCreateKotlinClass(r2), "节目直播/首播互动组件容器展示形式", "lifengji"));
        UltraSettingsManager.b("live_gift_icon_breath_light_anim_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_icon_breath_light_anim_config", Reflection.getOrCreateKotlinClass(f0.class), "礼物icon支持呼吸灯动画配置", "dongbin.01"));
        UltraSettingsManager.b("live_send_gift_room_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_gift_room_opt", Reflection.getOrCreateKotlinClass(r1), "送礼room获取异常优化", "zhaozhuo"));
        UltraSettingsManager.b("live_asset_portrait_clean_strategy_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_asset_portrait_clean_strategy_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启算法清理策略", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_panel_container_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_container_config", Reflection.getOrCreateKotlinClass(r0.class), "礼物面板容器通用流畅性优化", "wujinglei"));
        UltraSettingsManager.b("live_big_gift_combo_view_show_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_gift_combo_view_show_time", Reflection.getOrCreateKotlinClass(r2), "大礼物连击动画展示时间,0:对照组线上，安卓为10s,3:向ios对齐展示时间约三秒,10:向安卓对齐展示时间约为10s,5:折中展示5s, 7:折中展示7s", "liushengheng"));
        UltraSettingsManager.b("live_gift_panel_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_style", Reflection.getOrCreateKotlinClass(r2), "礼物面板样式", "lifengji"));
        UltraSettingsManager.b("live_locate_default_gift_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_locate_default_gift_opt", Reflection.getOrCreateKotlinClass(r1), "礼物列表接口返回的数据中不存在默认选中的礼物时，默认定位到推荐tab下第一个", "wangting.levi"));
        UltraSettingsManager.b("live_message_queue_max_length", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_message_queue_max_length", Reflection.getOrCreateKotlinClass(r2), "直播间礼物消息队列最大长度", "lujunming"));
        UltraSettingsManager.b("live_gift_icon_prefetch_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_icon_prefetch_opt", Reflection.getOrCreateKotlinClass(g0.class), "礼物icon预拉取优化配置", "huangweijie"));
        UltraSettingsManager.b("live_gift_wall_pre_request_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_wall_pre_request_enable", Reflection.getOrCreateKotlinClass(r1), "礼物展馆接口预请求开关", "null"));
        UltraSettingsManager.b("live_gift_use_texture_render", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_use_texture_render", Reflection.getOrCreateKotlinClass(r1), "礼物TTEngine播放器是否采用离屏渲染,修复华为绿屏问题", "chenfuqiang"));
        UltraSettingsManager.b("live_opt_find_gift", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_opt_find_gift", Reflection.getOrCreateKotlinClass(r1), "优化获取礼物方式", "chenweizhuo"));
        UltraSettingsManager.b("live_on_measure_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_on_measure_opt_config", Reflection.getOrCreateKotlinClass(f2.class), "onMeasure频繁调用优化配置", "shihongjie"));
        UltraSettingsManager.b("fansclub_vip_split_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("fansclub_vip_split_enable", Reflection.getOrCreateKotlinClass(r1), "粉丝团-订阅会员创作者Tab拆分", "MaXiaodong.Xiaodong"));
        UltraSettingsManager.b("live_enable_scroll_sub_tab_content", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_scroll_sub_tab_content", Reflection.getOrCreateKotlinClass(r1), "聚类tab支持左右滑", "yaozu"));
        UltraSettingsManager.b("live_gift_msg_consume_exit_gap_tm", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_msg_consume_exit_gap_tm", Reflection.getOrCreateKotlinClass(r2), "礼物消息退出直播间时已消费的时间,单位s", "chenfuqiang"));
        UltraSettingsManager.b("live_gift_tray_image_size_uniform", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_image_size_uniform", Reflection.getOrCreateKotlinClass(r1), "礼物托盘图片加载大小对齐礼物面板", "null"));
        Class r4 = Float.TYPE;
        UltraSettingsManager.b("live_gift_effect_skip_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_skip_score", Reflection.getOrCreateKotlinClass(r4), "低端机进房前X秒屏蔽大特效机型打分", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_send_request_with_cloud_room_params", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_send_request_with_cloud_room_params", Reflection.getOrCreateKotlinClass(r1), "云导播场景用户侧直播间，发送礼物时是否携带云导播信息，开关兜底用", "yuanbin.sakuragi"));
        UltraSettingsManager.b("live_multi_send_git_to_c_position_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_send_git_to_c_position_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景C位放大礼物面板拉起优先送礼", "fumingwen"));
        UltraSettingsManager.b("live_gift_panel_interact_page_guide_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_interact_page_guide_config", Reflection.getOrCreateKotlinClass(j0.class), "发现tab认知传递配置", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_extra_callback_io_thread", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_extra_callback_io_thread", Reflection.getOrCreateKotlinClass(r1), "礼物extra回包不回调主线程", "null"));
        UltraSettingsManager.b("live_gift_panel_sort_strategy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_sort_strategy", Reflection.getOrCreateKotlinClass(r2), "礼物面板支持价格排序,0:不支持, 1:首先从小到大, 2:首先从大到小", "lifengji"));
        UltraSettingsManager.b("live_base_popup_manager_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_base_popup_manager_enable", Reflection.getOrCreateKotlinClass(r1), "直播间气泡统一管理开关", "huangguoxiao"));
        UltraSettingsManager.b("live_gift_banner_lynx_scheme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_banner_lynx_scheme", Reflection.getOrCreateKotlinClass(String.class), "banner scheme", "yaozu"));
        UltraSettingsManager.b("live_sort_msg_request_gift_list_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sort_msg_request_gift_list_delay", Reflection.getOrCreateKotlinClass(r3), "礼物面板打开时排序消息请求list的延迟时长", "null"));
        UltraSettingsManager.b("live_enable_send_fans_gift_to_guest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_send_fans_gift_to_guest", Reflection.getOrCreateKotlinClass(r1), "多人直播间允许给团员送粉丝团礼物", "huangguoxiao"));
        UltraSettingsManager.b("is_load_gift_resource_after_first_frame", new com.bytedance.tools.kcp.ultrasettings.runtime.c("is_load_gift_resource_after_first_frame", Reflection.getOrCreateKotlinClass(r1), "是否在首帧后再加载礼物资源", "lifengji"));
        UltraSettingsManager.b("live_revenue_effect_game_service_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_effect_game_service_fallback", Reflection.getOrCreateKotlinClass(r1), "特效中枢加载兜底加载方案", "yaozu"));
        UltraSettingsManager.b("live_gift_720p_super_resolution_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_720p_super_resolution_config", Reflection.getOrCreateKotlinClass(q2.class), "礼物720超分开启配置", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_entrance_disable_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_entrance_disable_style", Reflection.getOrCreateKotlinClass(r2), "礼物入口是否隐藏", "zhouenjie"));
        UltraSettingsManager.b("live_gift_effect_lynx_info_widget_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_lynx_info_widget_optimize", Reflection.getOrCreateKotlinClass(r1), "lynx特效widget优化开关", "yaozu"));
        UltraSettingsManager.b("honor_level", new com.bytedance.tools.kcp.ultrasettings.runtime.c("honor_level", Reflection.getOrCreateKotlinClass(m1.class), "荣誉等级settings", "weifucheng"));
        UltraSettingsManager.b("anchor_gift_tab_config_schema_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_gift_tab_config_schema_url", Reflection.getOrCreateKotlinClass(String.class), "主播礼物面板 schema", "taojiayi"));
        UltraSettingsManager.b("live_gift_extra_callback_scheduler_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_extra_callback_scheduler_opt", Reflection.getOrCreateKotlinClass(r1), "礼物extra回调主线程调度优化", "null"));
        UltraSettingsManager.b("live_revenue_effect_game_service_enable_layout_change_event", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_effect_game_service_enable_layout_change_event", Reflection.getOrCreateKotlinClass(r1), "布局切换event开关", "yaozu"));
        UltraSettingsManager.b("live_room_charge_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_charge_type", Reflection.getOrCreateKotlinClass(r2), "充值弹窗 or 跳转页面", "lifengji"));
        UltraSettingsManager.b("vs_support_gift_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("vs_support_gift_config", Reflection.getOrCreateKotlinClass(x2.class), "vs礼物开关配置", "wangting"));
        UltraSettingsManager.b("enable_broadcast_guest_list_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_broadcast_guest_list_update", Reflection.getOrCreateKotlinClass(r1), "可送礼对象列表更新广播消息开关", "taojiayi"));
        UltraSettingsManager.b("live_gift_panel_diff_optimize_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_diff_optimize_switch", Reflection.getOrCreateKotlinClass(r1), "礼物面板diff优化开关", "lifengji"));
        UltraSettingsManager.b("live_download_gift_asset_jsb_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_download_gift_asset_jsb_opt", Reflection.getOrCreateKotlinClass(r1), "downloadGiftAsset JSB下载逻辑优化", "wangting.levi"));
        UltraSettingsManager.b("send_gift_relation_cache_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_relation_cache_count", Reflection.getOrCreateKotlinClass(r2), "本地记录送礼关系对个数", "null"));
        UltraSettingsManager.b("live_enable_subscribe_open_effect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_subscribe_open_effect", Reflection.getOrCreateKotlinClass(r1), "是否开启会员的开通特效", "lijianxin"));
        UltraSettingsManager.b("live_gift_icon_score_degrade_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_icon_score_degrade_config", Reflection.getOrCreateKotlinClass(h0.class), "礼物icon低端机降级配置", "ouzhiqian"));
        UltraSettingsManager.b("live_revenue_effect_game_service_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_effect_game_service_enable", Reflection.getOrCreateKotlinClass(r1), "特效中枢加载开关", "yaozu"));
        UltraSettingsManager.b("live_gift_tray_pool_length_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_pool_length_limit", Reflection.getOrCreateKotlinClass(r1), "托盘队列缓存长度限制", "zhouenjie"));
        UltraSettingsManager.b("live_new_send_gift_bg_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_send_gift_bg_style", Reflection.getOrCreateKotlinClass(NewSendGiftConfig.class), "快捷送礼弹窗以及送礼引导新背景样式", "lifengji"));
        UltraSettingsManager.b("live_gift_big_gift_combo_limit_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_big_gift_combo_limit_switch", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.biggift.a.class), "大礼物连送限制开关", "lifengji"));
        UltraSettingsManager.b("live_vs_clear_screen_gift_half_screen", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vs_clear_screen_gift_half_screen", Reflection.getOrCreateKotlinClass(r1), "礼物面板半清屏优化", "songzeceng"));
        UltraSettingsManager.b("enable_fansclub_giftpanel_incentive_guide", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_fansclub_giftpanel_incentive_guide", Reflection.getOrCreateKotlinClass(r1), "粉丝团tab是否展示新的文案", "xietian.1993"));
        UltraSettingsManager.b("live_gift_download_with_select", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_download_with_select", Reflection.getOrCreateKotlinClass(r1), "礼物面板上礼物是否在选中时就触发下载资源", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_msg_consume_trace_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_msg_consume_trace_log", Reflection.getOrCreateKotlinClass(r1), "礼物消息跟踪日志", "chenfuqiang"));
        UltraSettingsManager.b("gift_series_icon_loop", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_series_icon_loop", Reflection.getOrCreateKotlinClass(r1), "系列礼物托盘轮播开关", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_gift_tray_high_layer_multi_live_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_high_layer_multi_live_scene", g, "礼物托盘高层级场景", "yaozu"));
        UltraSettingsManager.b("live_pc_anchor_interact_video_margin_top", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pc_anchor_interact_video_margin_top", Reflection.getOrCreateKotlinClass(r4), "PC伴侣主播连麦横屏流VideoView顶部占画幅比例", "lvpeng"));
        UltraSettingsManager.b("live_gift_list_request_advance_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_request_advance_opt", Reflection.getOrCreateKotlinClass(r1), "礼物面板gift/list请求时机提前到创建面板", "null"));
        UltraSettingsManager.b("live_gift_audience_degrade_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_audience_degrade_config", Reflection.getOrCreateKotlinClass(r1), "看播端礼物特效弹窗性能降级", "ouzhiqian"));
        UltraSettingsManager.b("gift_tray_has_uniform_background_color", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_tray_has_uniform_background_color", Reflection.getOrCreateKotlinClass(r1), "礼物托盘底色回收实验", "zengjun"));
        UltraSettingsManager.b("live_gift_tray_adjust_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_adjust_scene", h, "礼物托盘多人场景", "yaozu"));
        UltraSettingsManager.b("live_gift_after_send_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_after_send_config", Reflection.getOrCreateKotlinClass(GiftAfterSendConfig.class), "送礼去向体验配置信息", "wangting.levi"));
        UltraSettingsManager.b("live_revenue_preview_effect_service_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_preview_effect_service_url", Reflection.getOrCreateKotlinClass(String.class), "特效中枢schema", "yaozu"));
        UltraSettingsManager.b("live_send_gift_check_diy_card", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_gift_check_diy_card", Reflection.getOrCreateKotlinClass(r1), "送礼时校验diy卡是否匹配", "wangting.levi"));
        UltraSettingsManager.b("live_gift_privilege_red_dot_expire", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_privilege_red_dot_expire", Reflection.getOrCreateKotlinClass(r2), "礼物特权tab红点过期时间，单位小时", "chenhao.z"));
        UltraSettingsManager.b("live_gift_purchase_entrance_balance_hidden", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_purchase_entrance_balance_hidden", Reflection.getOrCreateKotlinClass(r1), "是否隐藏充值入口的余额", "zhangrongxin"));
        UltraSettingsManager.b("live_anya_memory_leak_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anya_memory_leak_switch", Reflection.getOrCreateKotlinClass(r1), "Anya disposable内存泄漏优化开关", "lifengji"));
        UltraSettingsManager.b("live_gift_panel_select_icon_fade_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_select_icon_fade_duration", Reflection.getOrCreateKotlinClass(r2), "礼物面板选中礼物icon fadeDuration", "null"));
        UltraSettingsManager.b("live_host_open_gift_bag", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_host_open_gift_bag", Reflection.getOrCreateKotlinClass(r1), "火山是否迁移礼包功能", "lifengji"));
        UltraSettingsManager.b("live_gift_toolbar_item_server_ctrl", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_toolbar_item_server_ctrl", Reflection.getOrCreateKotlinClass(r1), "礼物接入toolbar改造", "yaozu"));
        UltraSettingsManager.b("live_gift_queue_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_queue_config", Reflection.getOrCreateKotlinClass(k1.class), "抖音托盘优化配置", "yaozu"));
        UltraSettingsManager.b("live_gift_enable_leave_room_memory_cache_release", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_leave_room_memory_cache_release", Reflection.getOrCreateKotlinClass(r1), "AI预测用户退出直播间后不再返回，进行资源回收", "dongbin.01"));
        UltraSettingsManager.b("live_enable_send_gift_alert_in_guest_battle", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_send_gift_alert_in_guest_battle", Reflection.getOrCreateKotlinClass(r1), "嘉宾大作战送礼拦截弹窗", "huangweijie"));
        UltraSettingsManager.b("live_gift_player_user_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_player_user_type", Reflection.getOrCreateKotlinClass(r2), "视频礼物播放器降级策略,0:强制使用TTPlayer|1:优先使用MediaPlayer,异常自动回退使用TTPlayer|2:优先使用ExoPlayer,异常自动回退使用TTPlayer|3:强制优先使用ExoPlayer|4:强制使用TTEngine", "lifengji"));
        UltraSettingsManager.b("group_live_stream_message", new com.bytedance.tools.kcp.ultrasettings.runtime.c("group_live_stream_message", Reflection.getOrCreateKotlinClass(r1), "团播容器使用跟流消息", "qili"));
        UltraSettingsManager.b("match_room_toolbar_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("match_room_toolbar_config", Reflection.getOrCreateKotlinClass(i2.class), "赛事直播间toolbar setting控制", "zengjun"));
        UltraSettingsManager.b("live_gift_download_pcdn_cfg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_download_pcdn_cfg", Reflection.getOrCreateKotlinClass(w1.class), "pcdn的初始化配置", "chenhao.z"));
        UltraSettingsManager.b("live_gift_lynx_v8_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_lynx_v8_enable", Reflection.getOrCreateKotlinClass(r1), "礼物相关Lynx页面的V8开关，仅当Lynx页面schema包含enable_dynamic_v8开关1时有效，两个开关都为true时才开启V8", "chenfuqiang"));
        UltraSettingsManager.b("live_gift_load_local_more_tab_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_load_local_more_tab_enable", Reflection.getOrCreateKotlinClass(p0.class), "礼物loadlocal优化-缓存多个Tab", "zhaozhuo"));
        UltraSettingsManager.b("live_disable_image_monitor_helper", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_image_monitor_helper", Reflection.getOrCreateKotlinClass(r1), "禁用ImageNetworkRequestsMonitor", "null"));
        UltraSettingsManager.b("live_fast_gift_dialog_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fast_gift_dialog_config", Reflection.getOrCreateKotlinClass(ky1.a.class), "快捷送礼误触弹窗配置", "chenhao.z"));
        UltraSettingsManager.b("live_animator_degrade_fps_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_animator_degrade_fps_opt", Reflection.getOrCreateKotlinClass(r2), "属性动画帧率降低优化", "diwenchao"));
        UltraSettingsManager.b("gift_tab_select_state_cache_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_tab_select_state_cache_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物 tab 切换清理上次选中状态优化，改变了此处清理选中状态的时机", "taojiayi"));
        UltraSettingsManager.b("live_prop_list_update_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_prop_list_update_panel", Reflection.getOrCreateKotlinClass(r1), "道具列表拉取后是否刷新礼物列表", "zhaozhuo"));
        UltraSettingsManager.b("live_fast_gift_cancel_filter_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fast_gift_cancel_filter_enable", Reflection.getOrCreateKotlinClass(r1), "快捷礼物取消资源特效检查", "zhaozhuo"));
        UltraSettingsManager.b("live_disable_sort_request_prop_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_sort_request_prop_list", Reflection.getOrCreateKotlinClass(r1), "礼物列表排序消息不触发propList请求", "null"));
        UltraSettingsManager.b("live_gift_width_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_width_fix", Reflection.getOrCreateKotlinClass(r1), "礼物tab宽度fix", "yaozu"));
        UltraSettingsManager.b("live_local_host_gift_need_filter_test_asset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_local_host_gift_need_filter_test_asset", Reflection.getOrCreateKotlinClass(r1), "内测包线上环境不播放内测资源", "lifengji"));
        UltraSettingsManager.b("live_gift_panel_vm_delay_dispose", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_vm_delay_dispose", Reflection.getOrCreateKotlinClass(r1), "礼物面板ViewModel延迟dispose", "huangweijie"));
        UltraSettingsManager.b("live_xml_and_drawable_cache_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_xml_and_drawable_cache_config", Reflection.getOrCreateKotlinClass(h2.class), "XML及Drawable缓存优化", "shihongjie"));
        UltraSettingsManager.b("live_gift_old_dialog_topic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_old_dialog_topic_enable", Reflection.getOrCreateKotlinClass(r1), "发现tab二级标签老面板开关", "chenjiaxin"));
        UltraSettingsManager.b("send_gift_intercept_anchor_offline", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_intercept_anchor_offline", Reflection.getOrCreateKotlinClass(r1), "去掉503错误码拦截，疑似拦截错误", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_panel_fans_club_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_fans_club_lynx", Reflection.getOrCreateKotlinClass(r1), "礼物面板粉丝团迁移lynx开关", "huangguoxiao"));
        UltraSettingsManager.b("live_gift_panel_follow_pan_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_follow_pan_enable", Reflection.getOrCreateKotlinClass(r1), "礼物面板支持下拉关闭", "lifengji"));
        UltraSettingsManager.b("live_anya_use_io_scheduler", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anya_use_io_scheduler", Reflection.getOrCreateKotlinClass(r1), "Anya框架异步scheduler切换开关", "wanghaodong.321"));
        UltraSettingsManager.b("live_group_view_top_margin_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_view_top_margin_optimize", Reflection.getOrCreateKotlinClass(r1), "第三行显示导致团播容器超出展示区域修复", "jiangxiangzhou.joe"));
        UltraSettingsManager.b("live_pk_propcard_first_use_show_uri", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_propcard_first_use_show_uri", Reflection.getOrCreateKotlinClass(String.class), "pk道具卡首次展示schema", "zhouenjie"));
        UltraSettingsManager.b("live_match_atmosphere_degrade_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_match_atmosphere_degrade_config", Reflection.getOrCreateKotlinClass(r1.class), "赛事直播间中低端机平台氛围降级配置", "zengjun"));
        UltraSettingsManager.b("live_small_gift_view_single_channel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_small_gift_view_single_channel", Reflection.getOrCreateKotlinClass(o1.class), "礼物托盘单通道", "yaozu"));
        UltraSettingsManager.b("live_gift_download_by_pcdn", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_download_by_pcdn", Reflection.getOrCreateKotlinClass(r1), "是否使用pcdn下载礼物资源", "chenhao.z"));
        UltraSettingsManager.b("live_lynx_mapping_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_mapping_switch", Reflection.getOrCreateKotlinClass(r1), "lynx mapping 开关", "yangxiaodong"));
        UltraSettingsManager.b("live_gift_effect_intro_schema", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_intro_schema", Reflection.getOrCreateKotlinClass(String.class), "礼物特效说明页", "yuanbin.sakuragi"));
        UltraSettingsManager.b("live_gift_list_callback_scheduler_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_callback_scheduler_opt", Reflection.getOrCreateKotlinClass(r1), "礼物list回调主线程调度优化", "null"));
        UltraSettingsManager.b("gift_panel_ui_load_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_panel_ui_load_opt_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0.class), "礼物面板UI加载优化配置", "null"));
        UltraSettingsManager.b("live_group_live_component_use_anniex", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_group_live_component_use_anniex", Reflection.getOrCreateKotlinClass(r1), "团播容器使用AnnieX", "jiangxiangzhou.joe"));
        UltraSettingsManager.b("live_gift_carnival_combo_tray_lynx_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_carnival_combo_tray_lynx_info", Reflection.getOrCreateKotlinClass(dy1.a.class), "嘉年华礼物连送托盘 Lynx 信息", "taojiayi"));
        UltraSettingsManager.b("live_gift_panel_ui_params_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_ui_params_opt", Reflection.getOrCreateKotlinClass(r1), "礼物面板UI参数优化", "wangting.levi"));
        UltraSettingsManager.b("live_gift_price_recommend_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_price_recommend_config", Reflection.getOrCreateKotlinClass(w0.class), "礼物价位推荐实验配置", "wangting.levi"));
        UltraSettingsManager.b("live_gift_lynx_v8_force_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_lynx_v8_force_enable", Reflection.getOrCreateKotlinClass(r1), "礼物相关Lynx页面的V8开关，强制为schema添加enable_dynamic_v8=1，优先级高于live_gift_lynx_v8_enable", "chenfuqiang"));
        UltraSettingsManager.b("live_anya_view_model_memory_leak_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anya_view_model_memory_leak_switch", Reflection.getOrCreateKotlinClass(r1), "Anya框架ViewModel内存泄漏修复开关", "huangweijie"));
        UltraSettingsManager.b("live_gift_download_duration_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_download_duration_config", Reflection.getOrCreateKotlinClass(a2.class), "礼物资源下载耗时优化", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_curated_use_default_card", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_curated_use_default_card", Reflection.getOrCreateKotlinClass(e1.class), "礼物面板专区送出卡后是否还定位到推荐卡", "chenjiaxin.lucky"));
        UltraSettingsManager.b("gift_player_auto_release_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_player_auto_release_switch", Reflection.getOrCreateKotlinClass(GiftPlayerAutoReleaseSwitch.class), "礼物播放器自动release开关", "diwenchao"));
        UltraSettingsManager.b("live_gift_panel_icon_fade_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_icon_fade_duration", Reflection.getOrCreateKotlinClass(r2), "礼物面板礼物icon fadeDuration", "null"));
        UltraSettingsManager.b("open_gift_panel_fps_monitor_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("open_gift_panel_fps_monitor_duration", Reflection.getOrCreateKotlinClass(r3), "打开礼物面板fps监控时长", "null"));
        UltraSettingsManager.b("live_audience_receive_gift_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audience_receive_gift_enable", Reflection.getOrCreateKotlinClass(r1), "给观众送礼开关", "yaozu"));
        UltraSettingsManager.b("live_gift_battle_toolbar_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_battle_toolbar_config", Reflection.getOrCreateKotlinClass(t.class), "夺宝大乱斗入口 Toolbar 配置", "taojiayi"));
        UltraSettingsManager.b("live_toolbar_animation_repeat_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_animation_repeat_fix", Reflection.getOrCreateKotlinClass(r1), "toolbar动画循环播放逻辑修复", "wujinglei"));
        UltraSettingsManager.b("live_gift_list_is_loaded_check_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_is_loaded_check_opt", Reflection.getOrCreateKotlinClass(r1), "礼物列表是否加载判断优化", "wanghaodong.321"));
        UltraSettingsManager.b("effect_download_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("effect_download_opt", Reflection.getOrCreateKotlinClass(r1), "资源生命周期管理开关", "lifengji"));
        UltraSettingsManager.b("live_vboost_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vboost_opt", Reflection.getOrCreateKotlinClass(ti1.class), "vboost性能加速优化", "diwenchao"));
        UltraSettingsManager.b("live_gift_receiver_hint_max_freq_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_receiver_hint_max_freq_control", Reflection.getOrCreateKotlinClass(r2), "是否开启宿主启动时异步加载礼物资源优化", "yaozu"));
        UltraSettingsManager.b("live_gift_enable_group_live_room_send_prop_to_group_member", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_group_live_room_send_prop_to_group_member", Reflection.getOrCreateKotlinClass(r1), "给团员送未置灰的道具时，客户端本地取消toast拦截", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_gift_ugc_gift_top_notice", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_ugc_gift_top_notice", Reflection.getOrCreateKotlinClass(String.class), "置顶提示文案", "yaozu"));
        UltraSettingsManager.b("live_send_gift_check_diamond", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_send_gift_check_diamond", Reflection.getOrCreateKotlinClass(r1), "强制打开送礼本地余额校验", "wangting"));
        UltraSettingsManager.b("live_message_board_gift_dialog_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_message_board_gift_dialog_url", Reflection.getOrCreateKotlinClass(String.class), "留言礼物留言面板scheme setting", "zhaozhuo"));
        UltraSettingsManager.b("live_landscape_tray_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_landscape_tray_fix", Reflection.getOrCreateKotlinClass(r1), "横屏分屏托盘修复", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_enter_room_preload_icon_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enter_room_preload_icon_count", Reflection.getOrCreateKotlinClass(r2), "进房预加载礼物icon数量", "zhaozhuo"));
        UltraSettingsManager.b("live_ai_open_gift_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ai_open_gift_panel", Reflection.getOrCreateKotlinClass(r1), "进房端智能判断是否会打开礼物面板", "ouzhiqian"));
        UltraSettingsManager.b("live_gift_refresh_cache_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_refresh_cache_switch", Reflection.getOrCreateKotlinClass(r1), "不区分场景缓存刷新", "yaozu"));
        UltraSettingsManager.b("live_gift_dialog_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_dialog_enable", Reflection.getOrCreateKotlinClass(r1), "飞麦dialog是否启动，true启动，false不启动", "chenjiaxin"));
        UltraSettingsManager.b("vs_send_gift_failed_not_fans_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("vs_send_gift_failed_not_fans_url", Reflection.getOrCreateKotlinClass(String.class), "vs直播间非粉丝团成员送礼失败弹框url", "gaoshiqi"));
        UltraSettingsManager.b("live_toolbar_coordinary_animation_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_coordinary_animation_style", Reflection.getOrCreateKotlinClass(r2), "送礼/关注引导弹窗改为 toolbar 动画实验", "wangbing"));
        UltraSettingsManager.b("live_gift_tray_duration_opt_debug", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_duration_opt_debug", Reflection.getOrCreateKotlinClass(r1), "礼物托盘耗时优化调试开关", "lilei.an"));
        UltraSettingsManager.b("live_gift_player_enable_element_click", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_player_enable_element_click", Reflection.getOrCreateKotlinClass(r1), "播放器是否启用点击", "dangyingkai"));
        UltraSettingsManager.b("live_public_screen_optimize_clear_pos", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_public_screen_optimize_clear_pos", Reflection.getOrCreateKotlinClass(r1), "公屏优化位置清理兜底开关", "xuzengrong"));
        UltraSettingsManager.b("live_gift_resource_manager_use_new_queue", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_resource_manager_use_new_queue", Reflection.getOrCreateKotlinClass(r1), "资源下载库使用新队列", "chenjiaxin"));
        UltraSettingsManager.b("live_enable_select_sub_tab", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_select_sub_tab", Reflection.getOrCreateKotlinClass(r1), "礼物跳转支持定位到聚类子tab", "yaozu"));
        UltraSettingsManager.b("live_gift_section_show_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_section_show_config", Reflection.getOrCreateKotlinClass(d1.class), "礼物面板专区配置", "chenjiaxin.lucky"));
        UltraSettingsManager.b("live_gift_asset_download_ai", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_asset_download_ai", Reflection.getOrCreateKotlinClass(n2.class), "直播端智能预测用户资源下载", "zhaozhuo"));
        UltraSettingsManager.b("live_together_new_message_data", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_together_new_message_data", Reflection.getOrCreateKotlinClass(r1), "一起送切换到新通信格式", "zhouenjie"));
        UltraSettingsManager.b("send_gift_notfans_dialog_isopen", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_notfans_dialog_isopen", Reflection.getOrCreateKotlinClass(r1), "送粉丝团礼物时非粉丝团成员是否弹起引导加团弹窗", "gaoshiqi"));
        UltraSettingsManager.b("live_gift_effect_cancel_show_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_cancel_show_time", Reflection.getOrCreateKotlinClass(r2), "进房时x秒内不展示特效，降低进房卡顿，优化进房体验", "zhaozhuo"));
        UltraSettingsManager.b("live_prop_red_gray_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_prop_red_gray_fix", Reflection.getOrCreateKotlinClass(r1), "背包红色灰色切换修复", "zhouenjie"));
        UltraSettingsManager.b("live_gift_unlock_gift_intercept", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_unlock_gift_intercept", Reflection.getOrCreateKotlinClass(r1), "客户端是否拦截未解锁礼物", "yaozu"));
        UltraSettingsManager.b("live_gift_room_receiver_hint_max_freq_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_room_receiver_hint_max_freq_control", Reflection.getOrCreateKotlinClass(r2), "是否开启宿主启动时异步加载礼物资源优化", "yaozu"));
        UltraSettingsManager.b("gift_panel_ui_preload_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_panel_ui_preload_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.a.class), "礼物面板UI预加载能力开关", "null"));
        UltraSettingsManager.b("live_gift_merge_interact_gift_request_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_merge_interact_gift_request_interval", Reflection.getOrCreateKotlinClass(r3), "互动礼物请求聚合间隔", "yaozu"));
        UltraSettingsManager.b("live_gift_panel_select_dynamic_effect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_select_dynamic_effect", Reflection.getOrCreateKotlinClass(String.class), "礼物选中稀缺动效资源", "yaozu"));
        UltraSettingsManager.b("live_gift_list_request_enter_room_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_request_enter_room_opt", Reflection.getOrCreateKotlinClass(d0.class), "礼物列表拉取时机优化三期", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_tray_enable_delete_message_by_reverse_order", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_enable_delete_message_by_reverse_order", Reflection.getOrCreateKotlinClass(r1), "托盘队列超长删除尾部消息时，倒序查找删除", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_scroll_angle", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_scroll_angle", Reflection.getOrCreateKotlinClass(Double.TYPE), "直播礼物列表滑动角度调整开关", "zhangrui.alex"));
        UltraSettingsManager.b("live_gift_assets_lru_clean_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_assets_lru_clean_config", i, "礼物资源LRU策略配置", "wangting.levi"));
        UltraSettingsManager.b("live_payment_panel_dark_mode", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_payment_panel_dark_mode", Reflection.getOrCreateKotlinClass(r2), "充值面板黑色模式0 对照组白色 1实验组黑色", "weiyupei"));
        UltraSettingsManager.b("live_multi_anchor_single_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_single_view", Reflection.getOrCreateKotlinClass(r1), "多主播连线是否开启单View模式", "ouzhiqian"));
        UltraSettingsManager.b("live_gift_top_effect_use_anniex", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_top_effect_use_anniex", Reflection.getOrCreateKotlinClass(r1), "顶部特效使用极简卡", "yaozu"));
        UltraSettingsManager.b("live_toolbar_fast_gift_log_show_timing", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_fast_gift_log_show_timing", Reflection.getOrCreateKotlinClass(r1), "快捷礼物曝光埋点上报时机修正", "wanghaodong"));
        UltraSettingsManager.b("new_sticker_mp4_asset_ids", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_sticker_mp4_asset_ids", j, "新人脸礼物降级资源map，giftId -> assetId", "zhouenjie"));
        UltraSettingsManager.b("live_gift_filter_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_filter_opt_enable", Reflection.getOrCreateKotlinClass(r1), "礼物过滤规则优化", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_toolbar_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_toolbar_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物toolbar接入改造", "yaozu"));
        UltraSettingsManager.b("live_gift_minitor_dir_size_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_minitor_dir_size_enable", Reflection.getOrCreateKotlinClass(r1), "上传app_assets和设备存储空间大小监控功能开关", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_load_image_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_load_image_optimize", Reflection.getOrCreateKotlinClass(r1), "切换图片加载方式", "wangting.levi"));
        UltraSettingsManager.b("live_interact_gift_message_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_gift_message_config", Reflection.getOrCreateKotlinClass(b1.class), "互动礼物高级消息提醒", "yaozu"));
        UltraSettingsManager.b("live_recharge_no_balanace_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_recharge_no_balanace_opt", Reflection.getOrCreateKotlinClass(r2), "充值余额不足链路优化，0-对照，1-接入差额能力，2-打开充值不关闭页面，3-1和2", "gaoshiqi"));
        UltraSettingsManager.b("tray_queue_optimize_and_new_animation", new com.bytedance.tools.kcp.ultrasettings.runtime.c("tray_queue_optimize_and_new_animation", Reflection.getOrCreateKotlinClass(r2), "001 开启队列优化+特效解耦，011 开启队列优化+特效解耦+托盘阶梯时间，010 什么都不开（托盘阶梯时间依赖队列优化），100 开启人脸特效新队列", "zhouenjie"));
        UltraSettingsManager.b("live_gift_scene_marketing_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_scene_marketing_config", Reflection.getOrCreateKotlinClass(j2.class), "端智能推荐营销场景配置", "yaozu"));
        UltraSettingsManager.b("live_gift_panel_anya_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_anya_opt", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.w.class), "礼物面板Anya框架相关优化", "huangweijie"));
        UltraSettingsManager.b("live_gift_default_select_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_default_select_switch", Reflection.getOrCreateKotlinClass(r1), "礼物支持默认选中", "lifengji"));
        UltraSettingsManager.b("live_gift_tray_base_img_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_base_img_config", k, "礼物托盘背景图配置", "yaozu"));
        UltraSettingsManager.b("live_format_send_gift_pre_check_balance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_format_send_gift_pre_check_balance", Reflection.getOrCreateKotlinClass(r1), "Format送礼是否支持前置余额拦截", "wangting.levi"));
        UltraSettingsManager.b("enable_default_select_recharge_preview_gift", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_default_select_recharge_preview_gift", Reflection.getOrCreateKotlinClass(r1), "点击充值入口时选中的礼物置为默认选中", "huangweijie"));
        UltraSettingsManager.b("live_gift_issue_report_gift_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_issue_report_gift_info", Reflection.getOrCreateKotlinClass(r1), "最近播放的特效id上报crash的多维分析", "wangting.levi"));
        UltraSettingsManager.b("live_gift_page_extra_frequency_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_page_extra_frequency_control", Reflection.getOrCreateKotlinClass(r1), "page extra刷新频率控制", "yaozu"));
        UltraSettingsManager.b("live_gift_enable_view_pager_intercept", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_view_pager_intercept", Reflection.getOrCreateKotlinClass(r1), "touch事件拦截开关", "yaozu"));
        UltraSettingsManager.b("live_landscape_log_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_landscape_log_enable", Reflection.getOrCreateKotlinClass(r1), "横屏日志监控开关", "null"));
        UltraSettingsManager.b("live_match_atmosphere_effect_ids", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_match_atmosphere_effect_ids", l, "双肩包氛围特效列表", "zengjun"));
        UltraSettingsManager.b("live_gift_panel_insert_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_insert_opt", Reflection.getOrCreateKotlinClass(r1), "礼物场景化推荐强插策略优化", "zhaozhuo"));
        UltraSettingsManager.b("gift_backpack_details", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_backpack_details", Reflection.getOrCreateKotlinClass(String.class), "查看背包礼物使用、过期记录", "liqun.fighting"));
        UltraSettingsManager.b("live_toolbar_cover_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_cover_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物动画避免遮挡toolbar优化", "chenweizhuo"));
        UltraSettingsManager.b("gift_repeat_timeout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_repeat_timeout", Reflection.getOrCreateKotlinClass(r2), "快捷送礼连送超时", "lifengji"));
        UltraSettingsManager.b("live_gift_interact_gift_library_hint_text", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_interact_gift_library_hint_text", Reflection.getOrCreateKotlinClass(String.class), "配置礼物库副标题", "taojiayi"));
        UltraSettingsManager.b("live_animated_gift_button_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_animated_gift_button_config", Reflection.getOrCreateKotlinClass(r2), "工具栏礼物按钮动效AB:0:对照组,1:静态, 2:动态", "zhouxinli"));
        UltraSettingsManager.b("live_gift_list_sort_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_sort_config", Reflection.getOrCreateKotlinClass(e2.class), "直播端智能礼物排序", "zhaozhuo"));
        UltraSettingsManager.b("anchor_gift_tab_config_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_gift_tab_config_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启使用新主播礼物面板", "taojiayi"));
        UltraSettingsManager.b("live_gift_enable_group_live_room_send_fans_gift_to_group_member", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_enable_group_live_room_send_fans_gift_to_group_member", Reflection.getOrCreateKotlinClass(r1), "团播直播间允许给团员送粉丝团礼物", "huangguoxiao"));
        UltraSettingsManager.b("live_gift_privilege_red_dot_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_privilege_red_dot_enable", Reflection.getOrCreateKotlinClass(r1), "礼物特权tab红点开关", "chenhao.z"));
        UltraSettingsManager.b("notification_gift_view_base_user_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("notification_gift_view_base_user_count", m, "一起送多人播报门槛", "wangting.levi"));
        UltraSettingsManager.b("live_degrade_strategy_sdk_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_degrade_strategy_sdk_enable", Reflection.getOrCreateKotlinClass(r1), "降级是否开启策略sdk方案", "lifengji"));
        UltraSettingsManager.b("enable_gift_asset_message_for_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_gift_asset_message_for_lynx", Reflection.getOrCreateKotlinClass(r1), "AssetMessage 是否支持播放 lynx 资源，和许愿礼物一起开启", "taojiayi"));
        UltraSettingsManager.b("live_gift_show_now_urgent_download", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_show_now_urgent_download", Reflection.getOrCreateKotlinClass(r1), "立见礼物送出时是否提前启动加急下载", "zhaozhuo"));
        UltraSettingsManager.b("live_remove_context_judgement", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_remove_context_judgement", Reflection.getOrCreateKotlinClass(r1), "移除无效Context判断", "ouzhiqian"));
        UltraSettingsManager.b("live_hide_remind_when_fast_gift_price_not_changed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hide_remind_when_fast_gift_price_not_changed", Reflection.getOrCreateKotlinClass(r1), "快捷礼物支付确认弹窗是否根据礼物价格,false:根据礼物id,true:根据礼物价格", "lifengji"));
        UltraSettingsManager.b("live_gift_dialog_search_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_dialog_search_config", Reflection.getOrCreateKotlinClass(y.class), "礼物面板搜索功能", "wangting.levi"));
        UltraSettingsManager.b("live_gift_minitor_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_minitor_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物埋点监控优化", "zhaozhuo"));
        UltraSettingsManager.b("live_big_gift_combo_click_area_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_gift_combo_click_area_opt", Reflection.getOrCreateKotlinClass(r2), "大礼物连送按钮点击体验优化，1:修复点击区域 2:修复并扩大可点击区域", "null"));
        UltraSettingsManager.b("live_gift_list_filter_config_opt_fixbug", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_filter_config_opt_fixbug", Reflection.getOrCreateKotlinClass(r1), "礼物列表过滤时机优化问题修复", "zhaozhuo"));
        UltraSettingsManager.b("live_gift_list_multi_level_data_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_list_multi_level_data_config", Reflection.getOrCreateKotlinClass(n0.class), "礼物列表数据分级请求配置", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_fresco_cache_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_fresco_cache_opt_enable", Reflection.getOrCreateKotlinClass(r1), "礼物独立缓存功能开关", "chenweizhuo"));
        UltraSettingsManager.b("live_gift_local_test_tray_crash_settings", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_local_test_tray_crash_settings", Reflection.getOrCreateKotlinClass(r1), "是否在local_test下崩溃有冲突的托盘位置场景", "lifengji"));
        UltraSettingsManager.b("live_gift_match_room_asset_load_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_match_room_asset_load_enable", Reflection.getOrCreateKotlinClass(r1), "世界杯资源预加载开关", "chenjiaxin"));
        UltraSettingsManager.b("live_gift_tray_animation_degrade", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_tray_animation_degrade", Reflection.getOrCreateKotlinClass(r2), "直播间礼物托盘动画降级：1.淡入淡出", "chenhao.z"));
        UltraSettingsManager.b("live_prop_offline_optimize_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_prop_offline_optimize_enable", Reflection.getOrCreateKotlinClass(r1), "道具未上线送出优化", "lifengji"));
        UltraSettingsManager.b("live_toolbar_coordinary_animation_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_coordinary_animation_config", Reflection.getOrCreateKotlinClass(k2.class), "toolbar引导动效优化", "huangguoxiao"));
        UltraSettingsManager.b("live_toolbar_fast_gift_enable_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_fast_gift_enable_delay", Reflection.getOrCreateKotlinClass(r1), "抖lite快捷礼物接入toolbar改造，保持线上延迟展示逻辑", "wanghaodong"));
        UltraSettingsManager.b("live_gift_message_need_retry", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_message_need_retry", Reflection.getOrCreateKotlinClass(r1), "礼物消息是否需要重试", "wangting"));
        UltraSettingsManager.b("live_offline_enter_room_time_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_offline_enter_room_time_optimize", Reflection.getOrCreateKotlinClass(r1), "下线无用进房时间SP存储", "ouzhiqian"));
        UltraSettingsManager.b("live_enable_gift_info_sei", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_gift_info_sei", Reflection.getOrCreateKotlinClass(r1), "直播端智能SEI礼物排序", "chenjiaxin.lucky"));
        UltraSettingsManager.b("lynx_alpha_player_auto_release_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("lynx_alpha_player_auto_release_switch", Reflection.getOrCreateKotlinClass(LynxAlphaPlayerAutoReleaseSwitch.class), "lynx调用端上播放器自动release开关", "chenjiaxin"));
        UltraSettingsManager.b("live_disable_locked_gift_group_send", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_locked_gift_group_send", Reflection.getOrCreateKotlinClass(r1), "未解锁的礼物不支持成组送", "wanghaodong.321"));
        UltraSettingsManager.b("live_gift_mp4_message_expired_time_seconds", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_mp4_message_expired_time_seconds", Reflection.getOrCreateKotlinClass(r3), "礼物消息过期策略", "lifengji"));
        UltraSettingsManager.b("live_gift_recommend_insert_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_recommend_insert_scene", n, "允许客户端强插礼物的场景", "chenjiaxin.lucky"));
        UltraSettingsManager.b("gift_panel_select_gift_strong_strategy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_panel_select_gift_strong_strategy", Reflection.getOrCreateKotlinClass(r2), "打开礼物面板是否需要定位到任务礼物", "huangguoxiao"));
        UltraSettingsManager.b("live_asset_lru_clean_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_asset_lru_clean_config", Reflection.getOrCreateKotlinClass(c1.class), "礼物资源LRU清理策略", "chenjiaxin"));
        UltraSettingsManager.b("live_clear_screen_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_clear_screen_optimize", Reflection.getOrCreateKotlinClass(r1), "清屏体验优化", "liuhuan"));
        UltraSettingsManager.b("live_gift_effect_performance_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_effect_performance_opt_config", Reflection.getOrCreateKotlinClass(b0.class), "礼物特效性能优化配置", "huangweijie"));
        UltraSettingsManager.b("live_gift_panel_dynamization", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_dynamization", Reflection.getOrCreateKotlinClass(a0.class), "礼物面板动态化", "yaozu"));
        UltraSettingsManager.b("live_gift_panel_receiver_service_dependence_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_panel_receiver_service_dependence_opt", Reflection.getOrCreateKotlinClass(r1), "选人服务依赖优化", "yaozu"));
        UltraSettingsManager.b("live_gift_wall_image_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_wall_image_opt_config", Reflection.getOrCreateKotlinClass(GiftWallPreRequestManager.a.a.class), "礼物展馆图片优化配置", "null"));
        UltraSettingsManager.b("live_fast_gift_image_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fast_gift_image_opt", Reflection.getOrCreateKotlinClass(r1), "礼物图片格式", "zhaozhuo.119"));
        UltraSettingsManager.b("gift_panel_income_to_coin_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gift_panel_income_to_coin_optimize", Reflection.getOrCreateKotlinClass(r1), "礼物面板收益兑换体验优化入口开关", "sunshichang"));
        UltraSettingsManager.b("live_gift_lynx_effect_container_load_amazing", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_lynx_effect_container_load_amazing", Reflection.getOrCreateKotlinClass(r1), "Lynx特效容器加载so", "yaozu"));
    }
}
