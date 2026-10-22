package o21;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor.PlayerStatus;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import k31.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rc0.d;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f521764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f521765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f521766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f521767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C7004b f521768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o21.a f521769f;

    public static final class a {
    }

    /* JADX INFO: renamed from: o21.b$b, reason: collision with other inner class name */
    public static final class C7004b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f521770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f521771b;

        public C7004b(long r100) {
            this.f521771b = r100;
            this.f521770a = true;
        }
    }

    static {
    }

    @Override // rc0.d
    public final void a() {
        this.f521765b = true;
        this.f521767d = null;
        this.f521769f = null;
        this.f521768e = new C7004b(System.currentTimeMillis());
    }

    @Override // rc0.d
    public final void c() {
        this.f521765b = false;
        this.f521767d = null;
        this.f521769f = null;
        this.f521768e = null;
    }

    public b() {
        this.f521764a = new c();
    }

    @Override // rc0.d
    public final void b(hs0.b r210) {
        b r100 = this;
        Intrinsics.checkNotNullParameter(r210, "param");
        String r101 = r210.f486941c;
        MultiPlayerScene r102 = r210.f486939a;
        View r103 = r210.f486940b;
        j.f501662e.getClass();
        Intrinsics.checkNotNullParameter(r101, "sei");
        n0 r104 = com.bytedance.android.live.revenue.common.player.utils.a.a(r101, false);
        JSONArray r105 = com.bytedance.android.live.revenue.common.player.utils.a.b(r101);
        if (r105 == null) goto L13;
        if (r104 != null) goto L7;
        j r106 = new j(com.bytedance.android.live.revenue.common.player.utils.a.g(r105), com.bytedance.android.live.revenue.common.player.utils.a.h(r105), com.bytedance.android.live.revenue.common.player.utils.a.e(r105), com.bytedance.android.live.revenue.common.player.utils.a.f(r105));
    L14:
        if (r106 != null) goto L16;
        return;
    L16:
        k31.d r107 = new k31.d(r102, r103, r106);
        if (r100.f521765b == false) goto L172;
        j r108 = r100.f521767d;
        if (r108 != null) goto L22;
    L163:
        C7004b r109 = r100.f521768e;
        if (r109 == null) goto L166;
        r109.f521771b = System.currentTimeMillis();
    L166:
        r100.f521767d = r107.f501644c;
        return;
    L22:
        if (r108.equals(r107.f501644c) != true) goto L163;
        long r110 = System.currentTimeMillis();
        if (r110 >= r100.f521766c) goto L27;
        r100.f521766c = 0;
        boolean r111 = false;
    L28:
        if (r111 == false) goto L168;
        C7004b r112 = r100.f521768e;
        if (r112 != null) goto L33;
        return;
    L33:
        if (System.currentTimeMillis() >= r112.f521771b) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == false) goto L39;
        r112.f521771b = System.currentTimeMillis();
        return;
    L39:
        if (System.currentTimeMillis() < (r112.f521771b + 1000)) goto L41;
        boolean r114 = true;
    L42:
        if (r114 == false) goto L170;
        r100.f521764a.getClass();
        Intrinsics.checkNotNullParameter(r107, "param");
        MultiPlayerScene r115 = r107.f501642a;
        View r116 = r107.f501643b;
        if ((r116 instanceof AbsLivePlayerView) == true) goto L46;
        View r117 = null;
    L47:
        AbsLivePlayerView r118 = (AbsLivePlayerView) r117;
        if (r118 == null) goto L125;
        IRenderView r119 = r118.getRenderView();
        if (r119 == null) goto L125;
        View r120 = r119.getSelfView();
        if (r120 == null) goto L125;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if (r121 == null) goto L125;
        ViewGroup.LayoutParams r122 = ((AbsLivePlayerView) r116).getLayoutParams();
        if (r122 == null) goto L125;
        View r123 = r116.findViewById(R.id.ttlive_multi_anchor_top_bg);
        View r124 = r116.findViewById(R.id.ttlive_multi_anchor_bottom_bg);
        if (r123 == null) goto L63;
        ViewGroup.LayoutParams r125 = r123.getLayoutParams();
    L64:
        if (r124 == null) goto L66;
        ViewGroup.LayoutParams r126 = r124.getLayoutParams();
    L68:
        if ((r121 instanceof FrameLayout.LayoutParams) == false) goto L124;
        if (r125 != null) goto L71;
    L72:
        if (r126 != null) goto L74;
    L76:
        ViewGroup r127 = (ViewGroup) r116;
        j r128 = r107.f501644c;
        FrameLayout.LayoutParams r129 = (FrameLayout.LayoutParams) r121;
        if ((r125 instanceof FrameLayout.LayoutParams) == true) goto L79;
        r125 = null;
    L79:
        FrameLayout.LayoutParams r130 = (FrameLayout.LayoutParams) r125;
        if ((r126 instanceof FrameLayout.LayoutParams) == true) goto L82;
        r126 = null;
    L82:
        FrameLayout.LayoutParams r131 = (FrameLayout.LayoutParams) r126;
        Intrinsics.checkNotNullParameter(r115, "playerScene");
        Intrinsics.checkNotNullParameter(r127, "playerView");
        Intrinsics.checkNotNullParameter(r128, "seiLayouts");
        Intrinsics.checkNotNullParameter(r120, "renderView");
        Intrinsics.checkNotNullParameter(r129, "renderLayouts");
        Intrinsics.checkNotNullParameter(r122, "playerLayouts");
        if (r123 != null) goto L85;
    L90:
        if (r124 != null) goto L92;
    L97:
        o21.a r132 = null;
    L98:
        if (r132 != null) goto L114;
        int r133 = r129.width;
        int r134 = r129.height;
        int r135 = r129.topMargin;
        if (r130 == null) goto L103;
        int r136 = RangesKt.coerceAtLeast((r130.topMargin + r130.height) - r135, 0);
    L104:
        int r137 = RangesKt.coerceAtLeast(r136, r135 * (-1));
        int r138 = r129.height;
        int r139 = r129.topMargin;
        int r140 = r122.height;
        if (r131 == null) goto L107;
        r138 = RangesKt.coerceAtMost(r131.topMargin - r139, r138);
    L107:
        if (r140 <= 0) goto L109;
        r138 = RangesKt.coerceAtMost(r138, r140 - r139);
    L109:
        int r141 = RangesKt.coerceAtLeast(r129.leftMargin * (-1), 0);
        int r142 = r129.width;
        int r143 = r129.leftMargin;
        int r144 = r122.width;
        if (r144 <= 0) goto L112;
        r142 = RangesKt.coerceAtMost(r144 - r143, r142);
    L112:
        if (r138 > r137) goto L115;
        r132 = new o21.a(r115, PlayerStatus.ERROR_CODE_LAYOUT_PARAM_INVISIBLE);
        goto L114
    L115:
        double r145 = r133;
        double r146 = r134;
        boolean r147 = ((c.a(r128.f501663a, ((double) r141) / r145) & c.a(r128.f501664b, ((double) r137) / r146)) & c.a(r128.f501665c, ((double) r142) / r145)) & c.a(r128.f501666d, ((double) r138) / r146);
        if (r147 == false) goto L118;
        PlayerStatus r148 = PlayerStatus.ERROR_CODE_NO_ERROR;
    L119:
        float r149 = r133;
        Float r150 = Float.valueOf(r141 / r149);
        float r151 = r134;
        Float r152 = Float.valueOf(r137 / r151);
        Float r153 = Float.valueOf(r142 / r149);
        Float r154 = Float.valueOf(r138 / r151);
        if (r147 == true) goto L122;
        String r155 = r128.toString();
    L123:
        r132 = new o21.a(r115, r148, r150, r152, r153, r154, r155);
    L126:
        r100 = this;
    L127:
        o21.a r156 = r100.f521769f;
        if (r156 != null) goto L130;
    L132:
        c r157 = r100.f521764a;
        C7004b r158 = r100.f521768e;
        if (r158 == null) goto L135;
        Boolean r159 = Boolean.valueOf(r158.f521770a);
    L136:
        r157.getClass();
        u41.d r160 = u41.d.f548676n;
        r160.getClass();
        if (((Boolean) u41.d.f548670h.getValue(r160, u41.d.f548663a[6])).booleanValue() == false) goto L159;
        if (r132 == null) goto L159;
        HashMap r161 = new HashMap();
        r161.put("android_event_key", r132.f521758b.toString());
        JSONObject r162 = new JSONObject();
        r162.put("player_scene", r132.f521757a);
        r162.put("is_first_frame", Intrinsics.areEqual(r159, Boolean.TRUE));
        Float r163 = r132.f521759c;
        if (r163 == null) goto L144;
        r162.put("canvas_ratio_left", Float.valueOf(r163.floatValue()));
    L144:
        Float r164 = r132.f521760d;
        if (r164 == null) goto L147;
        r162.put("canvas_ratio_top", Float.valueOf(r164.floatValue()));
    L147:
        Float r165 = r132.f521761e;
        if (r165 == null) goto L150;
        r162.put("canvas_ratio_right", Float.valueOf(r165.floatValue()));
    L150:
        Float r166 = r132.f521762f;
        if (r166 == null) goto L153;
        r162.put("canvas_ratio_bottom", Float.valueOf(r166.floatValue()));
    L153:
        String r167 = r132.f521763g;
        if (r167 == null) goto L156;
        r162.put("detail_message", r167);
    L156:
        LocalTestManager.a(new Class[]{wy.a.class});
        f r168 = com.bytedance.android.live.revlink.impl.global.b.g0();
        if (r168 == null) goto L159;
        r168.c0("ttlive_multi_player_layout_monitor", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r132.f521758b.getCode(), null, r161, r162);
    L159:
        r100.f521769f = r132;
        C7004b r169 = r100.f521768e;
        if (r169 == null) goto L162;
        r169.f521770a = false;
    L162:
        r112.f521771b = System.currentTimeMillis();
        return;
    L135:
        r159 = null;
        goto L136
    L130:
        if (r156.equals(r132) != true) goto L132;
    L122:
        r155 = null;
        goto L123
    L118:
        r148 = PlayerStatus.ERROR_CODE_RENDER_SEI_DIFF;
        goto L119
    L103:
        r136 = 0;
    L114:
        r112 = r112;
        goto L127
    L92:
        if ((!Intrinsics.areEqual(r124.getParent(), r127)) == false) goto L95;
        r132 = new o21.a(r115, PlayerStatus.ERROR_CODE_BOTTOM_BG_ROOT_DIFF);
        goto L98
    L95:
        if (r127.indexOfChild(r124) >= r127.indexOfChild(r120)) goto L97;
        r132 = new o21.a(r115, PlayerStatus.ERROR_CODE_BOTTOM_BG_BELOW_RENDER);
        goto L98
    L85:
        if ((!Intrinsics.areEqual(r123.getParent(), r127)) == false) goto L88;
        r132 = new o21.a(r115, PlayerStatus.ERROR_CODE_TOP_BG_ROOT_DIFF);
        goto L98
    L88:
        if (r127.indexOfChild(r123) >= r127.indexOfChild(r120)) goto L90;
        r132 = new o21.a(r115, PlayerStatus.ERROR_CODE_TOP_BG_BELOW_RENDER);
        goto L98
    L74:
        if ((r126 instanceof FrameLayout.LayoutParams) == true) goto L76;
    L71:
        if ((r125 instanceof FrameLayout.LayoutParams) == true) goto L72;
    L124:
        r132 = new o21.a(r115, PlayerStatus.ERROR_CODE_LAYOUT_PARAM_MISMATCH);
        goto L126
    L66:
        r126 = null;
        goto L68
    L63:
        r125 = null;
    L125:
        r132 = null;
        goto L126
    L46:
        r117 = r116;
        goto L47
    L170:
        return;
    L41:
        r114 = false;
        goto L42
    L35:
        r113 = false;
        goto L36
    L168:
        return;
    L27:
        r100.f521766c = r110;
        r111 = true;
        goto L28
    L172:
        return;
    L7:
        double r170 = com.bytedance.android.live.revenue.common.player.utils.a.i(r105);
        double r171 = com.bytedance.android.live.revenue.common.player.utils.a.d(r105);
        if (r170 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r171 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        double r172 = ((double) r104.b()) / ((double) r104.f());
        double r173 = ((double) r104.a()) / ((double) r104.e());
        double r174 = ((double) r104.c()) / ((double) r104.f());
        double r175 = ((double) r104.d()) / ((double) r104.e());
        r106 = new j(r174 + (com.bytedance.android.live.revenue.common.player.utils.a.g(r105) * r172), (com.bytedance.android.live.revenue.common.player.utils.a.h(r105) * r173) + r175, r174 + (r172 * com.bytedance.android.live.revenue.common.player.utils.a.e(r105)), r175 + (r173 * com.bytedance.android.live.revenue.common.player.utils.a.f(r105)));
    L13:
        r106 = null;
        goto L14
    }
}
