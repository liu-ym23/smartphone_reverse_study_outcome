package v72;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.o20;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.api.settings.config.h;
import com.bytedance.android.livesdk.interactivity.enteranim.EnterAnimWidget;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.OpenAssetVideoPlayer;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.o;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EnterAnimAppLogger;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.j;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EnterAnimationView;
import com.bytedance.android.livesdk.log.k0;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import ec2.x;
import ec2.y;
import gd0.v;
import j40.q1;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r52.l0;
import r72.l;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements u72.a, View.OnClickListener {
    public final HandlerC7967c A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f553418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InteractivityPlatformContext f553419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f553420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnterAnimationView f553421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f553422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f553423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k32.a f553424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f553425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f553426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h32.a f553427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f32.b f553428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f32.c f553429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f553430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f553431n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f553432o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f553433p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public x72.a f553434q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public x72.c f553435r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c f553436s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RevenueUtils f553437t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.d f553438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v72.a f553439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v72.b f553440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f553441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f553442y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f553443z;

    public class a implements com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f553444a;

        public final void a() {
            c r100 = this.f553444a;
            if (r100.f553430m > 0) goto L5;
        L37:
            this.f553444a.f553443z = System.currentTimeMillis();
            RevenueUtils.f136592i.getClass();
            IPerformanceManager r101 = (IPerformanceManager) k.f(IPerformanceManager.class);
            if (r101 == null) goto L40;
            r101.onModuleStop(IPerformanceManager.MODULE_USER_ENTER);
        L40:
            c r102 = this.f553444a;
            r102.f553431n--;
            DataCenter r103 = r102.f553418a;
            if (r103 == null) goto L43;
            r103.put("data_enter_anim_showing", Boolean.FALSE);
        L43:
            c r104 = this.f553444a;
            if (r104.f553431n >= 0) goto L46;
            r104.f553431n = 0;
        L46:
            r104.d();
            return;
        L5:
            if (r100.f553424g == null) goto L37;
            int r105 = g.f553468a;
            long r106 = SystemClock.uptimeMillis();
            c r107 = this.f553444a;
            long r108 = r106 - r107.f553430m;
            k32.a r109 = r107.f553424g;
            String r110 = r109.f501684a;
            Intrinsics.checkNotNullParameter(r110, "userId");
            Intrinsics.checkNotNullParameter(r109, "curMsg");
        L35:
            e = move-exception;
            SafetyGuard.a(null, e, null);
            goto L37
        L8:
            if (LocalTestManager.c(new Class[]{wy.a.class}) == false) goto L11;
            ALogger.i("enter monitor", "time cost: " + r108);     // Catch: Exception -> L35
        L11:
            if ((r109 instanceof k32.c) == true) goto L13;
        L15:
            va.a r111 = r109.f501694k;     // Catch: Exception -> L35
            if (r111 == null) goto L23;
            if (EnterAnimAppLogger.d(r111, r109) == false) goto L23;
            if (r108 < 30000) goto L37;
        L23:
            if (r108 <= 10000) goto L26;
            int r112 = 1;
        L29:
            if (r112 == 0) goto L37;
            JSONObject r113 = new JSONObject();     // Catch: Exception -> L35
            r113.put("anim_exception", r112);     // Catch: Exception -> L35
            if (r108 <= 30000) goto L33;
            r113.put("anim_blocked", 1);     // Catch: Exception -> L35
        L33:
            JSONObject r114 = new JSONObject();     // Catch: Exception -> L35
            r114.put("anim_time_consume", r108);     // Catch: Exception -> L35
            JSONObject r115 = new JSONObject();     // Catch: Exception -> L35
            r115.put(RemoteMessageConst.MSGID, r110);     // Catch: Exception -> L35
            LiveTracingMonitor.f("ttlive_high_level_msg_monitor", LiveTracingMonitor.EventModule.INTERACTIVITY, r113, r114, r115);     // Catch: Exception -> L35
            goto L37
        L26:
            if (r108 >= 1000) goto L28;
            r112 = 2;
            goto L29
        L28:
            r112 = 0;
            goto L29
        L13:
            if (r108 >= 30000) goto L15;
            goto L15
        }

        public final void b() {
            DataCenter r100 = this.f553444a.f553418a;
            if (r100 == null) goto L6;
            r100.put("data_enter_anim_showing", Boolean.TRUE);
            return;
        }

        public a(c r100) {
            this.f553444a = r100;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f553445a;

        public b(c r100) {
            this.f553445a = r100;
        }
    }

    /* JADX INFO: renamed from: v72.c$c, reason: collision with other inner class name */
    public class HandlerC7967c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f553446a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100.what != 12345) goto L6;
            this.f553446a.e();
            return;
        }

        public HandlerC7967c(c r100, Looper r101) {
            this.f553446a = r100;
            super(r101);
        }
    }

    public final void d() {
        int r100 = h.f133762a;
        if (l0.f536212a.getValue().a() == true) goto L9;
        if (o20.f120877a.getValue().b() == true) goto L9;
        e();
        return;
    L9:
        if (this.f553431n < 1) goto L11;
        return;
    L11:
        long r101 = this.f553429l.f475364a;
        long r102 = System.currentTimeMillis() - this.f553443z;
        if (r102 < 0) goto L19;
        if (r102 >= r101) goto L19;
        if (this.A.hasMessages(12345) == true) goto L23;
        this.A.sendEmptyMessageDelayed(12345, r101 - r102);
        return;
    L23:
        return;
    L19:
        if (this.A.hasMessages(12345) == true) goto L25;
        this.A.sendEmptyMessage(12345);
        return;
    }

    public final void e() {
        if (j40.b.f497169a.getValue().booleanValue() == false) goto L17;
        DataCenter r100 = this.f553418a;
        if (r100 == null) goto L7;
        int r101 = ((Integer) r100.get("data_link_state", 0)).intValue();
    L9:
        if (this.f553432o == false) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L17;
        ALogger.i("DefaultEntryController", "intercept play animation in pk mode");
    L21:
        boolean r103 = false;
    L23:
        if (r103 == true) goto L25;
        return;
    L25:
        f r104 = this.f553422e;
        if (r104 != null) goto L29;
        return;
    L29:
        if (r104.f553459c.f136795a.isEmpty() == false) goto L31;
        return;
    L31:
        int r105 = this.f553431n;
        if (r105 < 1) goto L34;
        return;
    L34:
        this.f553431n = r105 + 1;
        f r106 = this.f553422e;
        b r107 = this.f553442y;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "pollInterceptor");
        long r108 = 0;
        if (r106.f553459c.f136795a.isEmpty() == false) goto L37;
    L143:
        k32.a r110 = null;
    L144:
        this.f553424g = r110;
        if (r110 == null) goto L429;
        int r109 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.f136558a;
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof k32.b) == false) goto L149;
    L160:
        boolean r111 = true;
    L161:
        if (r111 == true) goto L163;
    L165:
        boolean r112 = false;
    L166:
        Intrinsics.checkNotNullParameter(r110, "message");
        boolean r113 = r110 instanceof y72.a;
        boolean r114 = r110 instanceof k32.d;
        String r115 = "";
        if (r114 == false) goto L178;
        g4.f58859e0.getClass();
        List<String> r116 = g4.a.f58861b;
        h3 r117 = ((k32.d) r110).f501712t;
        if (r117 == null) goto L174;
        pg.c r118 = r117.M();
        if (r118 == null) goto L174;
        String r119 = r118.getScene();
        if (r119 == null) goto L174;
    L176:
        if (r116.contains(r119) == false) goto L178;
        boolean r120 = true;
    L179:
        if (r114 == false) goto L189;
        h3 r121 = ((k32.d) r110).f501712t;
        if (r121 == null) goto L185;
        pg.c r122 = r121.M();
        if (r122 == null) goto L185;
        String r123 = r122.getScene();
    L187:
        if (Intrinsics.areEqual(r123, "game_download") == false) goto L189;
        boolean r124 = true;
    L190:
        if (r113 == true) goto L195;
        if (r120 == true) goto L195;
        if (r124 == true) goto L195;
        boolean r125 = false;
    L196:
        if (r125 == true) goto L198;
    L200:
        boolean r126 = false;
    L201:
        Intrinsics.checkNotNullParameter(r110, "message");
        if (r110.f501694k == null) goto L204;
        boolean r127 = true;
    L205:
        if (r127 == true) goto L207;
    L209:
        boolean r128 = false;
    L210:
        Intrinsics.checkNotNullParameter(r110, "message");
        if (r114 == false) goto L229;
        g4.f58859e0.getClass();
        List<String> r129 = g4.a.f58861b;
        k32.d r130 = (k32.d) r110;
        h3 r131 = r130.f501712t;
        if (r131 == null) goto L217;
        pg.c r132 = r131.M();
        if (r132 == null) goto L217;
        String r133 = r132.getScene();
    L219:
        if (CollectionsKt.contains(r129, r133) == true) goto L228;
        List<String> r134 = g4.a.f58862c;
        h3 r135 = r130.f501712t;
        if (r135 == null) goto L225;
        pg.c r136 = r135.M();
        if (r136 == null) goto L225;
        String r137 = r136.getScene();
    L227:
        if (CollectionsKt.contains(r134, r137) == false) goto L229;
    L225:
        r137 = null;
    L228:
        boolean r138 = true;
    L230:
        if (r138 == true) goto L232;
    L234:
        boolean r139 = false;
    L235:
        if (r112 == true) goto L241;
        if (r128 == true) goto L241;
        if (r139 == true) goto L241;
        if (r126 == true) goto L241;
        boolean r140 = false;
    L242:
        if (r140 == true) goto L244;
    L250:
        if (r140 == false) goto L252;
        ALogger.i("DefaultEntryController", "drop due to degrade, ecom: " + r112 + ", game:" + r126 + ", highLevel: " + r128);
    L252:
        if (r140 == true) goto L429;
        long r141 = SystemClock.uptimeMillis();
        EnterAnimationView r142 = this.f553421d;
        if (r142 != null) goto L257;
    L425:
        int r143 = this.f553431n;
        if (r143 != 1) goto L453;
        this.f553431n = r143 - 1;
        return;
    L453:
        return;
    L257:
        if (r142.getContext() == null) goto L425;
        if (this.f553420c == null) goto L425;
        com.bytedance.android.livesdk.interactivity.d r144 = this.f553438u;
        if (r144 == null) goto L266;
        EnterAnimWidget r145 = ((EnterAnimWidget.a) r144).f136587a;
        if (r145.f136584l == false) goto L266;
        r145.f136584l = false;
        r145.f136580h.a(r145.containerView, 8, false);
    L266:
        this.f553430m = SystemClock.uptimeMillis();
        boolean r146 = this.f553424g instanceof k32.d;
        if (r146 == true) goto L269;
        c r147 = this;
    L270:
        if (r146 == false) goto L272;
        z32.b.a(HighlevelNoMessageMonitorEnum.NotifyShowCount);
    L273:
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c r148 = this.f553436s;
        final k32.a r149 = this.f553424g;
        final Context r150 = this.f553420c;
        final AnimPlayer.a r151 = new AnimPlayer.a(this.f553425h, r141, r147);
        final EnterAnimationView r152 = this.f553421d;
        final a r153 = this.f553441x;
        r148.getClass();
        AnimPlayer.PlayerType r154 = com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c.a(r149);
        if (r154 != AnimPlayer.PlayerType.DouyinDefault) goto L277;
        r153.a();
    L298:
        if (k.f(IMiddlewareUserService.class) != null) goto L300;
    L308:
        k32.a r155 = this.f553424g;
        if (r155 != null) goto L311;
        int r156 = EnterAnimAppLogger.f136766a;
    L348:
        k32.a r157 = this.f553424g;
        if (r157 == null) goto L449;
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c r158 = this.f553436s;
        r158.getClass();
        if ((r158.f136642a.get(com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c.a(r157)) instanceof OpenAssetVideoPlayer) == true) goto L450;
        EnterAnimAppLogger.g(1, this.f553424g, this.f553433p);
        k32.a r159 = this.f553424g;
        if (r159 != null) goto L356;
        return;
    L356:
        if ((!Intrinsics.areEqual(r159.f501684a, ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n())) == true) goto L452;
        LinkedHashMap r160 = new LinkedHashMap();
        va.a r161 = r159.f501694k;
        if (r161 == null) goto L367;
        String r162 = r161.getDressId();
        if (r162 == null) goto L367;
        com.bytedance.android.live.profit.dress.l r163 = (com.bytedance.android.live.profit.dress.l) yt0.c.a().getDressData(r162, 2, "reportEnterEffectProfitCheck");
        r160.put("enter_dress_id", r162);
        if (r163 == null) goto L367;
        String r164 = r163.f87152o;
        if (r164 == null) goto L367;
        r160.put("avatar_border_dress_id", r164);
    L367:
        va.a r165 = r159.f501694k;
        if (r165 == null) goto L376;
        a5 r166 = r165.getText();
        if (r166 == null) goto L376;
        String r167 = r166.getDefaultPattern();
        if (r167 == null) goto L375;
        r115 = r167;
    L375:
        r160.put("script", sb2.a.h(r166, r115, false).toString());
    L376:
        va.a r168 = r159.f501694k;
        if (r168 == null) goto L387;
        Long r169 = Long.valueOf(r168.getAnimAssetId());
        if (r169.longValue() == 0) goto L381;
        boolean r170 = true;
    L382:
        if (r170 == true) goto L385;
        r169 = null;
    L385:
        if (r169 == null) goto L387;
        r160.put("enter_asset_id", Long.valueOf(r169.longValue()));
        goto L387
    L381:
        r170 = false;
    L387:
        va.a r171 = r159.f501694k;
        if (r171 == null) goto L398;
        Long r172 = Long.valueOf(r171.getCenterAnimAssetId());
        if (r172.longValue() == 0) goto L392;
        boolean r173 = true;
    L393:
        if (r173 == true) goto L396;
        r172 = null;
    L396:
        if (r172 == null) goto L398;
        r160.put("enter_asset_id", Long.valueOf(r172.longValue()));
        goto L398
    L392:
        r173 = false;
    L398:
        va.a r174 = r159.f501694k;
        if (r174 == null) goto L409;
        Long r175 = Long.valueOf(r174.a());
        if (r175.longValue() == 0) goto L403;
        boolean r176 = true;
    L404:
        if (r176 == true) goto L407;
        r175 = null;
    L407:
        if (r175 == null) goto L409;
        r160.put("enter_asset_id", Long.valueOf(r175.longValue()));
        goto L409
    L403:
        r176 = false;
    L409:
        py.k r177 = r159.f501687d;
        if (r177 == null) goto L416;
        List<String> r178 = r177.getUrls();
        if (r178 == null) goto L416;
        String r179 = (String) CollectionsKt.getOrNull(r178, 0);
        if (r179 == null) goto L416;
        r160.put("user_avatar_url", r179);
    L416:
        va.a r180 = r159.f501694k;
        if (r180 == null) goto L423;
        py.k r181 = r180.getAnimatedBadge();
        if (r181 == null) goto L423;
        String r182 = r181.getUri();
        if (r182 == null) goto L423;
        r160.put("badge_uri", r182);
    L423:
        boolean r183 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.ENTER_ROOM_EFFECT, r160, null);
        return;
    L452:
        return;
    L450:
        return;
    L449:
        return;
    L311:
        HashMap<String, String> r184 = EnterAnimAppLogger.c(r155);
        r184.put("show_time", String.valueOf(p6.b()));
        if ((r155 instanceof k32.d) == false) goto L347;
        k32.d r185 = (k32.d) r155;
        h3 r186 = r185.f501712t;
        if (r186 == null) goto L318;
        Map<String, String> r187 = r186.getBuriedPoint();
        if (r187 == null) goto L318;
        r184.putAll(r187);
    L318:
        h3 r188 = r185.f501712t;
        int r189 = com.bytedance.android.livesdk.interactivity.enteranim.utils.f.f136787a;
        if (r188 == null) goto L344;
        com.bytedance.android.live.base.model.message.d r190 = r188.I0();
        if (r190 == null) goto L344;
        List<com.bytedance.android.live.base.model.message.f> r191 = r190.b();
        if (r191 == null) goto L344;
        Iterator<T> r192 = r191.iterator();
    L326:
        if (r192.hasNext() == false) goto L330;
        Object r193 = r192.next();
        if (((com.bytedance.android.live.base.model.message.f) r193).a() == false) goto L326;
    L331:
        com.bytedance.android.live.base.model.message.f r194 = (com.bytedance.android.live.base.model.message.f) r193;
        if (r194 == null) goto L344;
        o6 r195 = r194.g();
        if (r195 == null) goto L344;
        a5 r196 = r195.a();
        if (r196 == null) goto L344;
        List<c5> r197 = r196.getPieces();
        if (r197 == null) goto L344;
        c5 r198 = (c5) CollectionsKt.firstOrNull(r197);
        if (r198 == null) goto L344;
        String r199 = r198.getStringValue();
        if (r199 == null) goto L344;
        Long r200 = StringsKt.toLongOrNull(r199);
    L345:
        if (r200 == null) goto L347;
        String r201 = r184.put("show_num_cnt", String.valueOf(r200.longValue()));
        goto L347
    L330:
        r193 = null;
    L344:
        r200 = null;
    L347:
        EnterAnimAppLogger.i("livesdk_high_level_common_message_show", r184, null);
        goto L348
    L300:
        if (((IMiddlewareUserService) k.f(IMiddlewareUserService.class)).user() == null) goto L308;
        k32.a r202 = this.f553424g;
        if (r202 == null) goto L308;
        if (TextUtils.isEmpty(r202.f501684a) == true) goto L308;
        if (TextUtils.equals(this.f553424g.f501684a, ((IMiddlewareUserService) k.f(IMiddlewareUserService.class)).user().n()) == true) goto L308;
        this.f553433p++;
        goto L308
    L277:
        if (r154 != AnimPlayer.PlayerType.UnKnownEffect) goto L279;
        r153.f553444a.f553431n--;
        goto L298
    L279:
        final AnimPlayer<?> r203 = r148.f136642a.get(r154);
        if (r203 != null) goto L433;
        int r204 = g.f553468a;
        String r205 = "cant find proper player for type  " + r154 + " " + r149;
        Intrinsics.checkNotNullParameter(r205, "msg");
        ALogger.e("TTLIVE_ENTER_ANIM", r205);
        r153.a();
        goto L298
    L433:
        Runnable r206 = new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.b(r203, r149, r150, r151, r152, r153);     // Catch: Exception -> L292
        Boolean r207 = com.bytedance.android.livesdk.interactivity.enteranim.utils.g.f136788a;     // Catch: Exception -> L292
        Intrinsics.checkNotNullParameter(r206, "action");     // Catch: Exception -> L292
        if (com.bytedance.android.livesdk.interactivity.enteranim.utils.g.f136788a.booleanValue() == true) goto L287;
        r206.run();     // Catch: Exception -> L292
    L288:
        va.a r208 = r149.f501694k;     // Catch: Exception -> L292
        if (r208 == null) goto L298;
        RevenueUtils.a(String.valueOf(r208.getType()), r152, r149, r141);     // Catch: Exception -> L292
        RevenueUtils.e(r152, r149);     // Catch: Exception -> L292
        goto L298
    L287:
        long r209 = System.nanoTime();     // Catch: Exception -> L292
        r206.run();     // Catch: Exception -> L292
        com.bytedance.android.livesdk.interactivity.enteranim.utils.g.f136791d += System.nanoTime() - r209;     // Catch: Exception -> L292
        com.bytedance.android.livesdk.interactivity.enteranim.utils.g.f136792e++;     // Catch: Exception -> L292
    L292:
        e = e;
    L296:
        int r210 = g.f553468a;
        Intrinsics.checkNotNullParameter("play Anim Error", "msg");
        ALogger.e("TTLIVE_ENTER_ANIM", "play Anim Error", e);
        SafetyGuard.a(null, e, null);
    L294:
        e = e;
        goto L296
    L272:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberShowCount);
        goto L273
    L269:
        r147 = null;
        goto L270
    L244:
        if (this.f553428k.f475362d == false) goto L250;
        com.bytedance.android.livesdk.user.e r211 = ((IMiddlewareUserService) k.f(IMiddlewareUserService.class)).user();
        if (r211 == null) goto L248;
        String r212 = r211.n();
    L249:
        r140 = !TextUtils.equals(r212, r110.f501684a);
        goto L250
    L248:
        r212 = "";
    L241:
        r140 = true;
        goto L242
    L232:
        if (this.f553428k.f475361c == false) goto L234;
        r139 = true;
    L217:
        r133 = null;
    L229:
        r138 = false;
        goto L230
    L207:
        if (this.f553428k.f475360b == false) goto L209;
        r128 = true;
        goto L210
    L204:
        r127 = false;
        goto L205
    L198:
        if (this.f553428k.f475363e == false) goto L200;
        r126 = true;
    L195:
        r125 = true;
    L185:
        r123 = null;
    L189:
        r124 = false;
    L174:
        r119 = "";
    L178:
        r120 = false;
        goto L179
    L163:
        if (this.f553428k.f475359a == false) goto L165;
        r112 = true;
        goto L166
    L149:
        if ((r110 instanceof k32.d) == false) goto L159;
        h3 r213 = ((k32.d) r110).f501712t;
        if (r213 == null) goto L155;
        pg.c r214 = r213.M();
        if (r214 == null) goto L155;
        String r215 = r214.getScene();
    L157:
        if (Intrinsics.areEqual(r215, "ecom_barrage_buy") == false) goto L159;
    L155:
        r215 = null;
    L159:
        r111 = false;
    L429:
        int r216 = this.f553431n;
        if (r216 != 1) goto L454;
        this.f553431n = r216 - 1;
        return;
    L454:
        return;
    L37:
        if (r106.f553461e == true) goto L143;
        Iterator<Map.Entry<Long, Deque<k32.a>>> r217 = r106.f553459c.f136795a.entrySet().iterator();
    L41:
        if (r217.hasNext() == false) goto L143;
        Deque<k32.a> r1100 = r217.next().getValue();
        Iterator<k32.a> r1101 = r1100.iterator();
    L44:
        if (r1101.hasNext() == false) goto L140;
        r110 = r1101.next();
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c r1102 = r107.f553445a.f553436s;
        if (r1102.f136643b == false) goto L54;
        if (r110 != null) goto L49;
        AnimPlayer<?> r1103 = null;
    L50:
        if (r1103 == null) goto L54;
        if ((r110 instanceof k32.d) == false) goto L54;
        boolean r1104 = r1103.a((k32.d) r110);
    L55:
        if (r1104 == false) goto L44;
        r1101.remove();
        String r1105 = f.a(r110);
        if (r1105 == null) goto L63;
        k32.a r1106 = r106.f553458b.get(r1105);
        if (r1106 == null) goto L63;
        r106.f553458b.remove(r1105);
        r110 = r1106;
    L70:
        if (r110.f501698o != r108) goto L73;
    L74:
        boolean r1107 = true;
    L77:
        if ((r110 instanceof k32.d) == false) goto L131;
        e r218 = r106.f553460d;
        k32.d r219 = (k32.d) r110;
        if (r218.f553454f == null) goto L130;
        h3 r220 = r219.f501712t;
        if (r220 == null) goto L130;
        pg.c r221 = r220.M();
        if (r221 == null) goto L130;
        String r222 = r221.getScene();
        if (r222 == null) goto L130;
        pg.c r223 = r220.M();
        if (r223 == null) goto L130;
        String r224 = r223.e();
        if (r224 == null) goto L130;
        Long r225 = r218.f553454f.f558490b.get(r224);
        long r1108 = r220.getMessageId();
        if (r225 == null) goto L104;
        if (r1108 <= 0) goto L104;
        Long r1109 = (Long) ((HashMap) r218.f553449a).get(Long.valueOf(r220.getMessageId()));
        if (r1109 == null) goto L104;
        r1109.longValue();
        ((HashMap) r218.f553449a).remove(Long.valueOf(r220.getMessageId()));
        if (r225.longValue() >= (System.currentTimeMillis() - r1109.longValue())) goto L104;
    L128:
        r1107 = false;
    L104:
        if (e.b(r224, r218.f553452d, r218.f553454f.f558493e) == false) goto L128;
        o r226 = r218.f553454f.f558494f.get(r224);
        if (r226 == null) goto L117;
        if (r226.b() == null) goto L117;
        if (r226.a() == null) goto L117;
        d r227 = e.a(r226, (d) ((HashMap) r218.f553453e).get(r224));
        if (r227 == null) goto L128;
        ((HashMap) r218.f553453e).put(r224, r227);
    L117:
        if (e.b(r222, r218.f553450b, r218.f553454f.f558491c) == false) goto L128;
        if (r226 != null) goto L130;
        o r228 = r218.f553454f.f558492d.get(r222);
        if (r228 == null) goto L130;
        if (r228.b() == null) goto L130;
        if (r228.a() == null) goto L130;
        d r229 = e.a(r228, (d) ((HashMap) r218.f553451c).get(r222));
        if (r229 == null) goto L128;
        ((HashMap) r218.f553451c).put(r222, r229);
    L130:
        r1107 = true;
    L131:
        if (r1107 == true) goto L133;
        r108 = 0;
        goto L44
    L133:
        if (r1100.isEmpty() == false) goto L135;
        r217.remove();
    L135:
        f.b r230 = r106.f553462f;
        if (r230 == null) goto L144;
        r230.b(r230.f553464b);
        goto L144
    L73:
        if ((SystemClock.elapsedRealtime() - r110.f501697n) <= (r110.f501698o * ((long) 1000))) goto L74;
        r1107 = false;
    L63:
        if ((r110 instanceof k32.d) == false) goto L70;
        int r1110 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.f136558a;
        Long r1111 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a((k32.d) r110);
        if (r1111 == null) goto L70;
        LinkedList<k32.d> r1112 = r106.f553457a.get(Long.valueOf(r1111.longValue()));
        if (r1112 == null) goto L70;
        k32.d r1113 = r1112.removeFirst();
        goto L70
    L49:
        r1103 = r1102.f136642a.get(com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c.a(r110));
    L54:
        r1104 = true;
        goto L55
    L140:
        if (r1100.isEmpty() == false) goto L142;
        r217.remove();
    L142:
        r108 = 0;
        goto L41
    L11:
        if (v.a(r101, 4) == false) goto L14;
        r102 = false;
        goto L15
    L7:
        r101 = 0;
    L17:
        DataCenter r231 = this.f553418a;
        if (r231 != null) goto L20;
    L22:
        r103 = true;
        goto L23
    L20:
        if (((Boolean) r231.get("cmd_vr_in_immersed_mode", Boolean.FALSE)).booleanValue() == false) goto L22;
        goto L21
    }

    public final void a(@Nullable k32.a r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        f r100 = this.f553422e;
        if (r100 == null) goto L165;
        Intrinsics.checkNotNullParameter(r110, "userInfo");
        if (r100.f553461e == true) goto L165;
        j<k32.a> r101 = r100.f553459c;
        long r102 = r110.f501699p;
        Deque<k32.a> r103 = r101.f136795a.get(Long.valueOf(r102));
        if (r103 != null) goto L12;
        r103 = new LinkedList();
        r101.f136795a.put(Long.valueOf(r102), r103);
    L12:
        r110.f501697n = SystemClock.elapsedRealtime();
        String r104 = f.a(r110);
        boolean r105 = true;
        int r106 = 0;
        if (r104 == null) goto L121;
        k32.a r107 = r100.f553458b.get(r104);
        if (r107 != null) goto L18;
        r100.f553458b.put(r104, r110);
    L128:
        r105 = false;
    L129:
        if (r105 == false) goto L131;
    L162:
        f.b r111 = r100.f553462f;
        if (r111 == null) goto L165;
        r111.b(r111.f553463a);
        goto L165
    L131:
        if ((r110 instanceof k32.d) == false) goto L138;
        e r108 = r100.f553460d;
        k32.d r109 = (k32.d) r110;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "windScreenCommonMessage");
        h3 r112 = r109.f501712t;
        if (r112 == null) goto L138;
        long r113 = r112.getMessageId();
        if (r113 == 0) goto L138;
        ((HashMap) r108.f553449a).put(Long.valueOf(r113), Long.valueOf(System.currentTimeMillis()));
    L138:
        r103.offerLast(r110);
        int r114 = r100.b();
        if ((r110 instanceof k32.c) == false) goto L141;
        Iterable r115 = r100.f553459c.a(f.f553456h);
        String r116 = "OpenAssetEnter";
    L145:
        Iterator r117 = r115.iterator();
    L147:
        if (r117.hasNext() == false) goto L162;
        k32.a r118 = (k32.a) r117.next();
        String r119 = f.a(r118);
        if (r119 == null) goto L154;
        if (r100.f553458b.get(r119) == null) goto L154;
        r100.f553458b.remove(r119);
    L158:
        f.b r120 = r100.f553462f;
        if (r120 == null) goto L161;
        f.b.a(r120, r118, r116);
    L161:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
    L154:
        if ((r118 instanceof k32.d) == false) goto L158;
        int r121 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.f136558a;
        Long r122 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a((k32.d) r118);
        if (r122 == null) goto L158;
        LinkedList<k32.d> r123 = r100.f553457a.remove(Long.valueOf(r122.longValue()));
        goto L158
    L141:
        int r124 = f.f553455g;
        if (r114 < r124) goto L144;
        r115 = r100.f553459c.a(r114 - r124);
        r116 = "Full";
        goto L145
    L144:
        r115 = new LinkedList();
        r116 = "";
        goto L145
    L18:
        if ((r107 instanceof k32.b) == false) goto L21;
        k32.b r125 = (k32.b) r110;
        k32.b r126 = (k32.b) r107;
        r126.f501685b = r125.f501685b;
        r126.f501703t += r125.f501703t;
        goto L129
    L21:
        if ((r107 instanceof y72.a) == false) goto L24;
        y72.a r127 = (y72.a) r110;
        y72.a r128 = (y72.a) r107;
        r128.f566581t = r127.f566581t;
        r128.f566584w = r127.f566584w;
        r128.f566582u += r127.f566582u;
        r128.f566585x = r127.f566585x;
        r128.f566583v = r127.f566583v;
        goto L129
    L24:
        if ((r107 instanceof k32.d) == false) goto L121;
        k32.d r129 = (k32.d) r110;
        k32.d r130 = (k32.d) r107;
        Long r131 = null;
        if (r129.a() == true) goto L28;
        h3 r132 = r130.f501712t;
        if (r132 == null) goto L118;
        pg.c r133 = r132.M();
        if (r133 == null) goto L118;
        Long r134 = r133.a();
        if (r134 == null) goto L118;
        long r135 = r134.longValue();
        h3 r136 = r129.f501712t;
        if (r136 == null) goto L118;
        pg.c r137 = r136.M();
        if (r137 == null) goto L118;
        h3 r138 = r129.f501712t;
        if (r138 == null) goto L117;
        pg.c r139 = r138.M();
        if (r139 == null) goto L117;
        Long r140 = r139.a();
        if (r140 == null) goto L117;
        r131 = Long.valueOf(r140.longValue() + r135);
    L117:
        r137.g(r131);
    L118:
        r129.f501713u = true;
    L119:
        r100.f553458b.put(r104, r110);
        goto L129
    L28:
        if (x.f472068a.getValue().booleanValue() == false) goto L119;
        h3 r141 = r129.f501712t;
        if (r141 == null) goto L119;
        com.bytedance.android.live.base.model.message.d r142 = r141.I0();
        if (r142 == null) goto L119;
        List<com.bytedance.android.live.base.model.message.f> r143 = r142.b();
        if (r143 == null) goto L119;
        Iterator<com.bytedance.android.live.base.model.message.f> r144 = r143.iterator();
    L37:
        if (r144.hasNext() == false) goto L42;
        if (r144.next().a() == true) goto L43;
        r106 = r106 + 1;
    L43:
        if (r106 == (-1)) goto L119;
        h3 r145 = r130.f501712t;
        if (r145 == null) goto L51;
        com.bytedance.android.live.base.model.message.d r146 = r145.I0();
        if (r146 == null) goto L51;
        List<com.bytedance.android.live.base.model.message.f> r147 = r146.b();
        if (r147 == null) goto L51;
        com.bytedance.android.live.base.model.message.f r148 = (com.bytedance.android.live.base.model.message.f) CollectionsKt.getOrNull(r147, r106);
    L52:
        h3 r149 = r129.f501712t;
        if (r149 == null) goto L59;
        com.bytedance.android.live.base.model.message.d r150 = r149.I0();
        if (r150 == null) goto L59;
        List<com.bytedance.android.live.base.model.message.f> r151 = r150.b();
        if (r151 == null) goto L59;
        com.bytedance.android.live.base.model.message.f r152 = (com.bytedance.android.live.base.model.message.f) CollectionsKt.getOrNull(r151, r106);
    L60:
        if (r148 == null) goto L119;
        if (r152 == null) goto L119;
        if (r148.k() == false) goto L119;
        if (r152.k() == false) goto L119;
        o6 r153 = r148.g();
        if (r153 == null) goto L77;
        a5 r154 = r153.a();
        if (r154 == null) goto L77;
        List<c5> r155 = r154.getPieces();
        if (r155 == null) goto L77;
        c5 r156 = (c5) CollectionsKt.firstOrNull(r155);
        if (r156 == null) goto L77;
        String r157 = r156.getStringValue();
        if (r157 == null) goto L77;
        Long r158 = StringsKt.toLongOrNull(r157);
    L78:
        o6 r159 = r152.g();
        if (r159 == null) goto L89;
        a5 r160 = r159.a();
        if (r160 == null) goto L89;
        List<c5> r161 = r160.getPieces();
        if (r161 == null) goto L89;
        c5 r162 = (c5) CollectionsKt.firstOrNull(r161);
        if (r162 == null) goto L89;
        String r163 = r162.getStringValue();
        if (r163 == null) goto L89;
        r131 = StringsKt.toLongOrNull(r163);
    L89:
        if (r158 == null) goto L119;
        if (r131 == null) goto L119;
        o6 r164 = r152.g();
        if (r164 == null) goto L119;
        a5 r165 = r164.a();
        if (r165 == null) goto L119;
        List<c5> r166 = r165.getPieces();
        if (r166 == null) goto L119;
        c5 r167 = (c5) CollectionsKt.firstOrNull(r166);
        if (r167 == null) goto L119;
        r167.setStringValue(String.valueOf(r158.longValue() + r131.longValue()));
    L77:
        r158 = null;
    L59:
        r152 = null;
    L51:
        r148 = null;
        goto L52
    L42:
        r106 = -1;
    L121:
        if ((r110 instanceof k32.d) == false) goto L128;
        int r168 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.f136558a;
        k32.d r169 = (k32.d) r110;
        Long r170 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a(r169);
        if (r170 == null) goto L128;
        long r171 = r170.longValue();
        LinkedList<k32.d> r172 = r100.f553457a.get(Long.valueOf(r171));
        if (r172 == null) goto L127;
        r172.add(r169);
        goto L129
    L127:
        LinkedList<k32.d> r173 = new LinkedList();
        r173.add(r169);
        r100.f553457a.put(Long.valueOf(r171), r173);
    L165:
        d();
    }

    public final void b(k32.a r100) {
        if (r100 == null) goto L24;
        va.a r101 = r100.f501694k;
        if (r101 == null) goto L19;
        int r102 = r101.getType();
        if (r102 == 5) goto L16;
        if (r102 == 7) goto L16;
        if (r102 == 8) goto L16;
        if (r102 != 9) goto L19;
    L16:
        if (this.f553437t.d(r100, new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.g(this)) == true) goto L24;
    L19:
        if ((r100 instanceof k32.c) == true) goto L21;
    L25:
        if (r100 != null) goto L27;
        return;
    L27:
        c(r100);
        return;
    L21:
        if (q1.f497286a.getValue().booleanValue() == false) goto L25;
        if (this.f553437t.d(r100, new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.g(this)) == false) goto L25;
    L24:
        r100 = null;
        goto L25
    }

    public final void c(k32.a r100) {
        if (this.f553434q.a(r100) == false) goto L9;
        ALogger.d("DefaultEntryController", "start intercept enter message.");
        if ((r100 instanceof k32.d) == false) goto L7;
        z32.b.a(HighlevelNoMessageMonitorEnum.NotifyFilterCount);
        return;
    L7:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberFilterCount);
        return;
    L9:
        a(r100);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k32.a r101 = this.f553424g;
        if (r101 == null) goto L21;
        l r102 = this.f553423f;
        if (r102 == null) goto L22;
        EnterAnimWidget r103 = (EnterAnimWidget) r102;
        r103.getClass();
        String r104 = r101.f501684a;
        if (TextUtils.isEmpty(r104) == false) goto L9;
    L16:
        k32.a r105 = this.f553424g;
        r105.getClass();
        if ((r105 instanceof k32.c) == true) goto L19;
        EnterAnimAppLogger.g(2, this.f553424g, this.f553433p);
    L19:
        EnterAnimAppLogger.j(this.f553424g);
        return;
    L9:
        if (TextUtils.equals("0", r104) == true) goto L16;
        if ((r101 instanceof k32.c) == true) goto L16;
        UserProfileEvent r106 = new UserProfileEvent(r104);
        r106.setClickUserPosition(UserProfileEvent.POSITION_ENTER_EFFECT);
        DataCenter r107 = r103.dataCenter;
        if (r107 == null) goto L16;
        r107.put("cmd_show_user_profile", r106);
        goto L16
    L22:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [v72.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [v72.b] */
    public c(Context r100, EnterAnimationView r101) {
        this.f553428k = new f32.b();
        this.f553429l = new f32.c();
        this.f553430m = 0;
        this.f553431n = 0;
        this.f553432o = false;
        this.f553433p = 0;
        this.f553436s = new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c();
        this.f553437t = new RevenueUtils();
        this.f553439v = new v72.a(this);
        this.f553440w = new v72.b(this);
        this.f553441x = new a(this);
        this.f553442y = new b(this);
        this.f553443z = 0;
        this.A = new HandlerC7967c(this, Looper.getMainLooper());
        this.f553420c = r100;
        this.f553421d = r101;
        if (LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue().b() == false) goto L6;
        r101.setHasFixSize(true);
        k0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "enteranim measure opt enabled");
    L6:
        if (w72.a.f558486a == true) goto L41;
        String r102 = y.f472070a.getValue();
        if (r102 != null) goto L43;
    L40:
        w72.a.f558486a = true;
        goto L41
    L43:
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.d r103 = (com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.d) GsonHelper.get().fromJson(r102, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.d.class);     // Catch: Exception -> L38
        if (r103 == null) goto L40;
        if (r103.a() == null) goto L40;
        Iterator<com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.c> r104 = r103.a().iterator();     // Catch: Exception -> L38
    L16:
        if (r104.hasNext() == false) goto L40;
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.c r105 = r104.next();     // Catch: Exception -> L38
        if (r105.b() == null) goto L16;
        Integer r106 = r105.a();     // Catch: Exception -> L38
        boolean r107 = w72.a.f558486a;
        if (r106 == null) goto L27;
        if (r106.intValue() != 3) goto L27;
        w72.a.a(r105.b(), w72.a.f558487b);     // Catch: Exception -> L38
        w72.a.a(r105.b(), w72.a.f558488c);     // Catch: Exception -> L38
    L27:
        if (r106 == null) goto L32;
        if (r106.intValue() != 1) goto L32;
        w72.a.a(r105.b(), w72.a.f558487b);     // Catch: Exception -> L38
    L32:
        if (r106 == null) goto L16;
        if (r106.intValue() != 2) goto L16;
        w72.a.a(r105.b(), w72.a.f558488c);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        SafetyGuard.a(null, e, "EnterOptExpHolder init configs");
    L41:
        ArrayList r108 = new ArrayList();
        r108.add(new x72.h());
        x72.c r109 = new x72.c(this);
        this.f553435r = r109;
        r108.add(r109);
        this.f553434q = new x72.a(0, r108, this);
    }
}
