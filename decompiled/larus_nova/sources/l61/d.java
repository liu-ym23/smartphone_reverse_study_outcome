package l61;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePerfBizType f507594b;

    public static class a extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LivePerfBizLevel f507595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f507596d;

        /* JADX INFO: renamed from: l61.d$a$a, reason: collision with other inner class name */
        public static final class C6652a extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C6652a f507597e = null;

            static {
                f507597e = new C6652a();
            }

            public C6652a() {
                super("comment_carnival", "评论狂欢", 0);
            }
        }

        public static final class a0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final a0 f507598e = null;

            static {
                f507598e = new a0();
            }

            public a0() {
                super("disable_hour_rank", "屏蔽小时榜", 1);
            }
        }

        public static final class a1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final a1 f507599e = null;

            static {
                f507599e = new a1();
            }

            public a1() {
                super("disable_landscape_lottery_message", "横屏福袋弹幕", 0);
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final b f507600e = null;

            static {
                f507600e = new b();
            }

            public b() {
                super("disable_animation_layer", "屏蔽动画层", 0);
            }
        }

        public static final class b0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final b0 f507601e = null;

            static {
                f507601e = new b0();
            }

            public b0() {
                super("disable_ktv_control", "屏蔽KTV能力", 0);
            }
        }

        public static final class b1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final b1 f507602e = null;

            static {
                f507602e = new b1();
            }

            public b1() {
                super("like_flow", "飘赞", 0);
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final c f507603e = null;

            static {
                f507603e = new c();
            }

            public c() {
                super("disable_audience_sticker", "屏蔽观众侧贴纸", 0);
            }
        }

        public static final class c0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final c0 f507604e = null;

            static {
                f507604e = new c0();
            }

            public c0() {
                super("disable_live_public_screen_feedback", "屏蔽公屏区问卷", 0);
            }
        }

        public static final class c1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final c1 f507605e = null;

            static {
                f507605e = new c1();
            }

            public c1() {
                super("live_drawer_anim", "更多直播动画", 0);
            }
        }

        /* JADX INFO: renamed from: l61.d$a$d, reason: collision with other inner class name */
        public static final class C6653d extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C6653d f507606e = null;

            static {
                f507606e = new C6653d();
            }

            public C6653d() {
                super("disable_backtrace_widget", "屏蔽回溯场景", 0);
            }
        }

        public static final class d0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final d0 f507607e = null;

            static {
                f507607e = new d0();
            }

            public d0() {
                super("disable_live_room_feedback", "屏蔽直播问卷", 0);
            }
        }

        public static final class d1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final d1 f507608e = null;

            static {
                f507608e = new d1();
            }

            public d1() {
                super("disable_normal_message_degrade", "普通消息降级", 0);
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final e f507609e = null;

            static {
                f507609e = new e();
            }

            public e() {
                super("disable_carnival_danmaku_widget", "屏蔽竖屏弹幕狂欢组件", 0);
            }
        }

        public static final class e0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final e0 f507610e = null;

            static {
                f507610e = new e0();
            }

            public e0() {
                super("disable_long_touch", "屏蔽长触", 1);
            }
        }

        public static final class e1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final e1 f507611e = null;

            static {
                f507611e = new e1();
            }

            public e1() {
                super("portrait_danmaku", "竖屏场景下弹幕", 0);
            }
        }

        public static final class f extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final f f507612e = null;

            static {
                f507612e = new f();
            }

            public f() {
                super("disable_toolbar_cast_screen", "屏蔽投屏功能", 0);
            }
        }

        public static final class f0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final f0 f507613e = null;

            static {
                f507613e = new f0();
            }

            public f0() {
                super("disable_lynx_alpha_player_widget", "屏蔽进场动画装扮组件", 0);
            }
        }

        public static final class f1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final f1 f507614e = null;

            static {
                f507614e = new f1();
            }

            public f1() {
                super("public_screen_anim", "公屏动画", 1);
            }
        }

        public static final class g extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final g f507615e = null;

            static {
                f507615e = new g();
            }

            public g() {
                super("disable_ceremony_border_widget", "屏蔽庆典边框", 0);
            }
        }

        public static final class g0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final g0 f507616e = null;

            static {
                f507616e = new g0();
            }

            public g0() {
                super("disable_portrait_row2nd_discovery_tetris", "竖屏第二行左侧发现区", 0);
            }
        }

        public static final class g1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final int f507617e;

            public g1(int r100) {
                super("short_touch_anim", "短触动画", 1);
                this.f507617e = r100;
            }
        }

        public static final class h extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final h f507618e = null;

            static {
                f507618e = new h();
            }

            public h() {
                super("disable_ceremony_prize_notice", "屏蔽盛典到达", 0);
            }
        }

        public static final class h0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final h0 f507619e = null;

            static {
                f507619e = new h0();
            }

            public h0() {
                super("disable_portrait_row4th_tetris", "竖屏第四行拖拽区", 0);
            }
        }

        public static final class h1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final h1 f507620e = null;

            static {
                f507620e = new h1();
            }

            public h1() {
                super("toolbar_anim", "Toolbar动画", 1);
            }
        }

        public static final class i extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final i f507621e = null;

            static {
                f507621e = new i();
            }

            public i() {
                super("disable_chat_channel_atmosphere_widget", "屏蔽聊天频道氛围彩蛋", 0);
            }
        }

        public static final class i0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final i0 f507622e = null;

            static {
                f507622e = new i0();
            }

            public i0() {
                super("disable_portrait_zdanmaku_widget", "屏蔽竖屏弹幕组件", 0);
            }
        }

        public static final class i1 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final i1 f507623e = null;

            static {
                f507623e = new i1();
            }

            public i1() {
                super("disable_ultimate_message_degrade", "极致消息降级", 1);
            }
        }

        public static final class j extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final j f507624e = null;

            static {
                f507624e = new j();
            }

            public j() {
                super("disable_chat_channel_ime_emoji_anim_widget", "屏蔽IM互动表情动画", 0);
            }
        }

        public static final class j0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final j0 f507625e = null;

            static {
                f507625e = new j0();
            }

            public j0() {
                super("disable_quick_comment", "屏蔽快捷评论", 0);
            }
        }

        public static final class k extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final k f507626e = null;

            static {
                f507626e = new k();
            }

            public k() {
                super("disable_common_guide_widget", "屏蔽通用引导", 0);
            }
        }

        public static final class k0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final k0 f507627e = null;

            static {
                f507627e = new k0();
            }

            public k0() {
                super("disable_record_widget", "屏蔽录屏场景", 0);
            }
        }

        public static final class l extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final l f507628e = null;

            static {
                f507628e = new l();
            }

            public l() {
                super("disable_common_lottie_animation_widget", "屏蔽Lottie动画组件", 0);
            }
        }

        public static final class l0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final l0 f507629e = null;

            static {
                f507629e = new l0();
            }

            public l0() {
                super("disable_room_notify_widget", "屏蔽房间广播组件", 0);
            }
        }

        public static final class m extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final m f507630e = null;

            static {
                f507630e = new m();
            }

            public m() {
                super("disable_dig_accessibility_widget", "屏蔽无障碍场景", 0);
            }
        }

        public static final class m0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final m0 f507631e = null;

            static {
                f507631e = new m0();
            }

            public m0() {
                super("disable_top_atmosphere_widget", "屏蔽飘屏特效", 0);
            }
        }

        public static final class n extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final n f507632e = null;

            static {
                f507632e = new n();
            }

            public n() {
                super("disable_drawer_entrance_common", "屏蔽直播抽屉", 0);
            }
        }

        public static final class n0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final n0 f507633e = null;

            static {
                f507633e = new n0();
            }

            public n0() {
                super("disable_top_left_window_card", "屏蔽左上卡片", 0);
            }
        }

        public static final class o extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final o f507634e = null;

            static {
                f507634e = new o();
            }

            public o() {
                super("disable_ds_guide", "屏蔽DS专项引导动画", 0);
            }
        }

        public static final class o0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final o0 f507635e = null;

            static {
                f507635e = new o0();
            }

            public o0() {
                super("disable_top_right_banner", "屏蔽活动banner", 1);
            }
        }

        public static final class p extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final p f507636e = null;

            static {
                f507636e = new p();
            }

            public p() {
                super("disable_enter_anim_widget", "屏蔽进场动画组件", 0);
            }
        }

        public static final class p0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final p0 f507637e = null;

            static {
                f507637e = new p0();
            }

            public p0() {
                super("disable_top_right_window_card", "屏蔽右上卡片", 0);
            }
        }

        public static final class q extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final q f507638e = null;

            static {
                f507638e = new q();
            }

            public q() {
                super("disable_fans_rank_animation", "屏蔽粉丝团动画", 0);
            }
        }

        public static final class q0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final q0 f507639e = null;

            static {
                f507639e = new q0();
            }

            public q0() {
                super("disable_wgame_invite_control", "屏蔽WGAME游戏邀请", 0);
            }
        }

        public static final class r extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final r f507640e = null;

            static {
                f507640e = new r();
            }

            public r() {
                super("disable_game_honor_widget", "屏蔽场景荣誉成就展示", 0);
            }
        }

        public static final class r0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final r0 f507641e = null;

            static {
                f507641e = new r0();
            }

            public r0() {
                super("game_live_player_drop_frame", "游戏直播播放器丢帧", 1);
            }
        }

        public static final class s extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final s f507642e = null;

            static {
                f507642e = new s();
            }

            public s() {
                super("disable_game_sticker", "屏蔽游戏贴纸能力", 0);
            }
        }

        public static final class s0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final s0 f507643e = null;

            static {
                f507643e = new s0();
            }

            public s0() {
                super("disable_game_promote_card_anim", "游戏推广卡片动画", 0);
            }
        }

        public static final class t extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final t f507644e = null;

            static {
                f507644e = new t();
            }

            public t() {
                super("disable_gift_effect", "屏蔽大礼物效果", 1);
            }
        }

        public static final class t0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final t0 f507645e = null;

            static {
                f507645e = new t0();
            }

            public t0() {
                super("gift_tray_anim", "礼物托盘动画", 0);
            }
        }

        public static final class u extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final u f507646e = null;

            static {
                f507646e = new u();
            }

            public u() {
                super("disable_gift_touch", "屏蔽礼物触摸", 0);
            }
        }

        public static final class u0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final u0 f507647e = null;

            static {
                f507647e = new u0();
            }

            public u0() {
                super("high_level_ecom_anim", "高级购买消息", 0);
            }
        }

        public static final class v extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final v f507648e = null;

            static {
                f507648e = new v();
            }

            public v() {
                super("disable_gift_tray", "屏蔽礼物托盘", 1);
            }
        }

        public static final class v0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final v0 f507649e = null;

            static {
                f507649e = new v0();
            }

            public v0() {
                super("disable_high_level_ecom", "高级购买消息", 0);
            }
        }

        public static final class w extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final w f507650e = null;

            static {
                f507650e = new w();
            }

            public w() {
                super("disable_global_notify", "屏蔽全服广播", 1);
            }
        }

        public static final class w0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final w0 f507651e = null;

            static {
                f507651e = new w0();
            }

            public w0() {
                super("high_level_enter_anim", "高级进房消息", 2);
            }
        }

        public static final class x extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final x f507652e = null;

            static {
                f507652e = new x();
            }

            public x() {
                super("disable_guide_widget", "屏蔽引导", 0);
            }
        }

        public static final class x0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final x0 f507653e = null;

            static {
                f507653e = new x0();
            }

            public x0() {
                super("hot_comment_tray", "热评托盘", 0);
            }
        }

        public static final class y extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final y f507654e = null;

            static {
                f507654e = new y();
            }

            public y() {
                super("disable_high_level_enter", "屏蔽高级进场", 1);
            }
        }

        public static final class y0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final y0 f507655e = null;

            static {
                f507655e = new y0();
            }

            public y0() {
                super("hour_rank", "屏蔽小时榜", 1);
            }
        }

        public static final class z extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final z f507656e = null;

            static {
                f507656e = new z();
            }

            public z() {
                super("disable_highlight_tetris_widget", "屏蔽高光容器", 0);
            }
        }

        public static final class z0 extends a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final z0 f507657e = null;

            static {
                f507657e = new z0();
            }

            public z0() {
                super("interactive_comp_delay_for_strategy", "交互层延迟组件(策略中心)", 0);
            }
        }

        @Override // l61.b
        public final String getDesc() {
            return this.f507596d;
        }

        @Override // l61.b
        public final LivePerfBizLevel getLevel() {
            return this.f507595c;
        }

        public a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "defaultDesc");
            super(r100, LivePerfBizType.Degrade);
            Lazy r103 = PlatformExpUtils.f98909a;
            Intrinsics.checkNotNullParameter(r100, "key");
            LivePerfBizLevel.a r104 = LivePerfBizLevel.Companion;
            Map<String, Integer> r105 = PlatformExpUtils.c().b();
            LivePerfBizLevel r106 = null;
            if (r105 == null) goto L5;
            Integer r107 = r105.get(r100);
        L6:
            r104.getClass();
            if (r107 == null) goto L10;
            int r108 = r107.intValue();
            r104.getClass();
            LivePerfBizLevel r109 = LivePerfBizLevel.a.a(r108);
            if (r109 == null) goto L10;
        L11:
            LivePerfBizLevel r110 = LivePerfBizLevel.Unknown;
            if (r109 == r110) goto L14;
            boolean r111 = true;
        L15:
            if (r111 == false) goto L17;
            r106 = r109;
        L17:
            if (r106 != null) goto L25;
            Integer r112 = Integer.valueOf(r102);
            if (r112 == null) goto L24;
            int r113 = r112.intValue();
            r104.getClass();
            LivePerfBizLevel r114 = LivePerfBizLevel.a.a(r113);
            if (r114 == null) goto L24;
            r110 = r114;
        L24:
            r106 = r110;
        L25:
            this.f507595c = r106;
            Intrinsics.checkNotNullParameter(r100, "key");
            String r115 = PlatformExpUtils.c().c().get(r100);
            if (r115 == null) goto L29;
            r101 = r115;
        L29:
            this.f507596d = r101;
            return;
        L14:
            r111 = false;
        L10:
            r109 = LivePerfBizLevel.Unknown;
            goto L11
        L5:
            r107 = null;
            goto L6
        }
    }

    @Override // l61.b
    public final String getKey() {
        return this.f507593a;
    }

    @Override // l61.b
    public LivePerfBizType getType() {
        return this.f507594b;
    }

    public d(String r100, LivePerfBizType r101) {
        this.f507593a = r100;
        this.f507594b = r101;
    }
}
