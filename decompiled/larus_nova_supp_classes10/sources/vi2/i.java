package vi2;

import android.os.SystemClock;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntro;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements h.f<LiveIntroResponse> {
    public final /* synthetic */ sh2.d a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ uj2.c d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;

    @Override // vi2.h.f
    public final wi2.a<LiveIntroResponse> execute() throws Exception {
        FilterNullArrayList r2 = new FilterNullArrayList();
        sh2.d r3 = this.a;
        int r0 = sh2.d.k;
        Intrinsics.checkNotNullParameter(r3, "$this$injectToParamList");
        Intrinsics.checkNotNullParameter(r2, "paramList");
        int r1 = sh2.c.a[r3.j.ordinal()];
        if (r1 != 1) goto L5;
        int r4 = 61;
    L9:
        int r5 = si2.k.c;
        r2.add(si2.k.a.a("request_scene", String.valueOf(r4)));
        r2.add(si2.k.a.a("room_id", r3.b.toString()));
        r2.add(si2.k.a.a("room_unique_key", r3.c));
        r2.add(si2.k.a.a("group_id", r3.d));
        if (hh2.f.g() == false) goto L12;
        r2.add(si2.k.a.a("author_open_id", r3.e));
    L13:
        r2.add(si2.k.a.a("sec_author_id", r3.f));
        r2.add(si2.k.a.a("entrance_info", r3.g));
        String r6 = "1";
        r2.add(si2.k.a.a("opt_entrance_info", "1"));
        r2.add(si2.k.a.a("is_retry", String.valueOf(r3.h)));
        if (r3.j == IntroCardScene.ENTER_ROOM) goto L17;
        r6 = BDLocationException.ERROR_TIMEOUT;
    L17:
        r2.add(si2.k.a.a("first_enter", r6));
        sh2.b r7 = r3.i;
        if (r7 == null) goto L25;
        String r8 = new Gson().toJson(r7);     // Catch: Exception -> L21
    L23:
        r2.add(si2.k.a.a("pop_product_info", r8));
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r8 = null;
    L25:
        if (r3.j != IntroCardScene.ENTER_ROOM) goto L37;
        boolean r9 = EntryController.M1;
        String r10 = EntryController.a.b(r3.b, r3.c).M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD);
        if (r10 == null) goto L37;
        if (r10.length() <= 0) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == true) goto L35;
        r10 = null;
    L35:
        if (r10 == null) goto L37;
        int r12 = si2.k.c;
        r2.add(si2.k.a.a("related_info", r10));
        goto L37
    L31:
        r11 = false;
    L37:
        Map r13 = this.b;
        if (r13 == null) goto L43;
        Iterator r14 = r13.entrySet().iterator();
    L41:
        if (r14.hasNext() == false) goto L43;
        Map.Entry r15 = (Map.Entry) r14.next();
        r2.add(si2.k.a.a((String) r15.getKey(), (String) r15.getValue()));
    L43:
        Map<String, String> r16 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r2);
        if (this.c == false) goto L50;
        sh2.d r17 = this.a;
        String r18 = r17.b;
        String r19 = r17.c;
        ECLivePerformanceMonitor.b r20 = ECLivePerformanceMonitor.x;
        ECLivePerformanceMonitor r21 = ECLivePerformanceMonitor.c.a(r18, r19);
        if (r21 == null) goto L50;
        r21.u("ec_perf_duration_intro_card", "pop_api_pure_start", Long.valueOf(SystemClock.elapsedRealtime()));
        String r22 = r21.p;
        if (r22 == null) goto L50;
        Map r23 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r22, MetricNames.POP_API_PURE_DURATION, null);
    L50:
        ECLiveABUtils r24 = ECLiveABUtils.INSTANCE;
        if (r24.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L53;
    L55:
        SsResponse r25 = h.i(this.e, r2);
        OptCardUtil.b(null, "getPopPromotion request end");
        if (r24.getEC_LIVE_ENABLE_API_ERROR_REPORT() == false) goto L61;
        uj2.c r26 = this.d;
        if (r26 == null) goto L61;
        r26.b(Integer.valueOf(r25.code()));
    L61:
        if (this.c == false) goto L67;
        sh2.d r27 = this.a;
        String r28 = r27.b;
        String r29 = r27.c;
        ECLivePerformanceMonitor.b r30 = ECLivePerformanceMonitor.x;
        ECLivePerformanceMonitor r31 = ECLivePerformanceMonitor.c.a(r28, r29);
        if (r31 == null) goto L67;
        r31.u("ec_perf_duration_intro_card", "pop_api_pure_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r32 = r31.p;
        if (r32 == null) goto L67;
        Map r33 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r32, MetricNames.POP_API_PURE_DURATION);
    L67:
        LiveIntroResponse r34 = (LiveIntroResponse) h.j(r25, LiveIntroResponse.class);
        if (r34 != null) goto L70;
    L82:
        com.bytedance.android.livesdk.livecommerce.network.hook.c r35 = com.bytedance.android.livesdk.livecommerce.network.hook.c.a;
        String r36 = this.a.b;
        monitor-enter(r35);
        if (r34 != null) goto L87;
        monitor-exit(r35);
    L88:
        sh2.d r37 = this.a;
        String r38 = r37.b;
        String r39 = r37.c;
        boolean r40 = this.f;
        boolean r110 = IntroCardLoadOpt.f;
        Intrinsics.checkNotNullParameter(r38, "roomId");
        Intrinsics.checkNotNullParameter(r39, "roomUniqueKey");
        if (r40 == false) goto L119;
        if (r34 == null) goto L119;
        boolean r41 = EntryController.M1;
        IntroCardLoadOpt r42 = EntryController.a.b(r38, r39).A;
        if (r42 == null) goto L119;
        Intrinsics.checkNotNullParameter(r34, "liveIntroResp");
        if (IntroCardLoadOpt.h == false) goto L119;
        if (r42.c == false) goto L119;
        ECContext r43 = r42.e;
        if (r43 != null) goto L100;
    L102:
        ECContext r44 = r42.e;
        if (r44 == null) goto L109;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r45 = r44.getEcLivePerformanceMonitor();
        if (r45 == null) goto L109;
        ECLivePerformanceMonitor r46 = (ECLivePerformanceMonitor) r45.getValue();
        if (r46 == null) goto L109;
        r46.l();
    L109:
        r42.c = false;
        if (IntroCardLoadOpt.l == false) goto L112;
        OptCardUtil.b(null, "handleResponse preload image");
        com.bytedance.android.livesdk.livecommerce.intro.utils.f.o.getClass();
        com.bytedance.android.livesdk.livecommerce.intro.utils.f.a.a(r34);
    L112:
        Unit r47 = Unit.INSTANCE;
        r42.a = r34;
        r42.b = true;
        if (r42.d == null) goto L118;
        OptCardUtil.b(null, "handleResponse post callback");
        int r48 = IntroCardLoadOpt.g;
        if (r48 <= 1) goto L117;
        UtilityKotlinExtentionsKt.b.postAtTime(new com.bytedance.android.livesdk.livecommerce.intro.utils.b(r42), r48);
        goto L119
    L117:
        UtilityKotlinExtentionsKt.b.postAtFrontOfQueue(new com.bytedance.android.livesdk.livecommerce.intro.utils.c(r42));
        goto L119
    L118:
        OptCardUtil.b(null, "handleResponse callback is null");
        goto L119
    L100:
        if (r43.isCleared() != true) goto L102;
    L119:
        if (r34 == null) goto L154;
        List<LiveIntro> r49 = r34.getIntros();     // Catch: Exception -> L151
        if (r49 == null) goto L154;
        if (r49.isEmpty() == true) goto L154;
        String r50 = r34.getLogId();     // Catch: Exception -> L151
        Iterator<LiveIntro> r51 = r49.iterator();     // Catch: Exception -> L151
    L125:
        if (r51.hasNext() == false) goto L154;
        LiveIntro r52 = r51.next();     // Catch: Exception -> L151
        if (r52 == null) goto L125;
        int r53 = ECSdk.a;     // Catch: Exception -> L151
        IECAPTService r54 = (IECAPTService) ECSdk.a(IECAPTService.class);     // Catch: Exception -> L151
        if (r54 == null) goto L125;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.t0 r55 = r52.d();     // Catch: Exception -> L151
        if (r55 == null) goto L134;
        IntroProduct r56 = r55.l();     // Catch: Exception -> L151
    L135:
        if (r55 == null) goto L125;
        if (r56 == null) goto L125;
        String r111 = this.e;     // Catch: Exception -> L151
        if (r56.i() == null) goto L140;
        String r112 = r56.i();     // Catch: Exception -> L151
    L141:
        String r113 = r112;
        if (r50 == null) goto L144;
        String r114 = r50;
    L145:
        String r115 = r56.d();     // Catch: Exception -> L151
        if (r55.h() == null) goto L148;
        int r116 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;     // Catch: Exception -> L151
        String r57 = com.bytedance.android.livesdk.livecommerce.utils.m0.a.a.toJson(r55.h());     // Catch: Exception -> L151
    L149:
        r54.record(new si2.l(r111, r113, r114, r115, null, "", r57));     // Catch: Exception -> L151
        goto L125
    L148:
        r57 = "";
        goto L149
    L144:
        r114 = "";
        goto L145
    L140:
        r112 = "";
        goto L141
    L134:
        r56 = null;
    L151:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L154:
        return h.f(r34, r16, r25);
    L87:
        monitor-exit(r35);
        goto L88
    L70:
        if (((com.bytedance.android.ec.model.g) r34).statusCode != 0) goto L82;
        if (r34.getIntros() != null) goto L74;
    L80:
        boolean r58 = false;
    L81:
        int r59 = com.bytedance.android.livesdk.livecommerce.intro.event.n.a;
        String r60 = this.e.replaceFirst(si2.g.a, "");
        sh2.d r61 = this.a;
        String r117 = r61.b;
        String r62 = r61.c;
        Intrinsics.checkNotNullParameter(r60, "apiPath");
        Intrinsics.checkNotNullParameter(r117, "roomId");
        int r118 = RoomContextController.h;
        com.bytedance.android.ec.opt.asynctask.t.b(new com.bytedance.android.livesdk.livecommerce.intro.event.k(new com.bytedance.android.livesdk.livecommerce.intro.event.l(r60, r117, RoomContextController.a.b(r117, r62), r58), "ECApiRequestSuccessEvent"));
        goto L82
    L74:
        if (r34.getIntros().size() <= 0) goto L80;
        Map<String, String> r63 = r34.getClientParams();
        if (this.a.j != IntroCardScene.ENTER_ROOM) goto L78;
        String r64 = "enter_room";
    L79:
        r63.put("popup_scene", r64);
        r58 = true;
        goto L81
    L78:
        r64 = "message";
        goto L79
    L53:
        if (this.d == null) goto L55;
        int r65 = com.bytedance.android.livesdk.livecommerce.network.hook.a.a;
        this.d.a(com.bytedance.android.livesdk.livecommerce.network.hook.a.a(this.e, r2));
        goto L55
    L12:
        r2.add(si2.k.a.a("author_id", r3.e));
        goto L13
    L5:
        if (r1 == 2) goto L7;
        r4 = 62;
        goto L9
    L7:
        r4 = 79;
        goto L9
    }

    public i(sh2.d r1, Map r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = true;
        this.d = null;
        this.e = r3;
        this.f = r4;
    }
}
