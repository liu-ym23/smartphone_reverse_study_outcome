package com.bytedance.awemeopen.appserviceimpl.event;

import android.os.Build;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.awemeopen.apps.framework.utils.e;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.event.d;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.event.AoEventService;
import com.bytedance.awemeopen.servicesapi.player.AoPlayerService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
public final class EventReportService implements t24.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<d> f198097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r14.c f198098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f198099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f198100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f198101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f198102g;

    @Override // k24.a
    public final void x0() {
    }

    @Override // t24.a
    public final void G() {
        Intrinsics.checkNotNullParameter("homepage_follow", "enterFrom");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter("homepage_follow", "enterFrom");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("skylight_close");
        r101.d("enter_from", "homepage_follow");
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void H0() {
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        int r101 = j64.b.f497514a;
        ((AoPlayerService) j64.b.a(AoPlayerService.class)).o2();
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("content_show");
        r102.d("enter_from", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT);
        r102.d(ILoadStallMonitor.EXTRA_PLAYER_TYPE, "exo");
        r102.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void b1() {
        Intrinsics.checkNotNullParameter("homepage_follow", "enterFrom");
        Intrinsics.checkNotNullParameter("manual_click", "enterMethod");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter("homepage_follow", "enterFrom");
        Intrinsics.checkNotNullParameter("manual_click", "enterMethod");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("skylight_open");
        r101.d("enter_from", "homepage_follow");
        r101.d("enter_method", "manual_click");
        r101.d("cell_num", 0);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final boolean g3() {
        String r100 = this.f198099d;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.contentEquals(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT);
    }

    @Override // t24.a
    public final String getEventValue() {
        Intrinsics.checkNotNullParameter("action_type", "key");
        d r100 = x3().f548582a;
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getParams();
        if (r101 == null) goto L7;
        return r101.optString("action_type");
    L7:
        return null;
    }

    public final u34.a x3() {
        return (u34.a) this.f198096a.getValue();
    }

    public EventReportService() {
        this.f198096a = LazyKt.lazy(EventReportService$eventReportDomain$2.INSTANCE);
        this.f198097b = new ArrayList();
        u34.a r100 = x3();
        r100.f548582a = new c(this);
        this.f198100e = true;
        this.f198102g = "";
    }

    @Override // t24.a
    public final void B0() {
        u34.a r100 = x3();
        r100.getClass();
        com.bytedance.awemeopen.infra.base.event.b.a("sdk_initialized").c(null, r100.f548582a).b();
    }

    @Override // n24.a
    public final void f() {
        x3().getClass();
    }

    @Override // t24.a
    public final void v0() {
        u34.a r100 = x3();
        r100.getClass();
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a(EventConstants.Label.SDK_SESSION_LAUNCH);
        r101.d(EventConstants.ExtraJson.KEY_SDK_AID, 313526);
        Lazy r102 = AoEnv.f198594a;
        r101.d("sdk_version", "3.7.3");
        r101.d("app_version", AoEnv.f());
        r101.d("update_version_code", Integer.valueOf(AoEnv.e()));
        r101.d("os_version", Build.VERSION.RELEASE);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final boolean k() {
        return this.f198100e;
    }

    public static String y3(r14.c r100) {
        if (r100 == null) goto L4;
        a0 r101 = r100.f535622d;
    L5:
        if (r101 != null) goto L9;
        return "";
    L9:
        return GsonProtectorUtils.toJson(GsonHolder.a(), r100.f535622d);
    L4:
        r101 = null;
        goto L5
    }

    @Override // t24.a
    public final void C0(boolean r100) {
        this.f198101f = r100;
    }

    @Override // t24.a
    public final void H1(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f198097b.add(r100);
    }

    @Override // t24.a
    public final void L(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        this.f198102g = r100;
    }

    @Override // t24.a
    public final void Z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        u34.a r101 = x3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("sdk_common_error");
        r102.d("error_code", 20001);
        r102.d("error_message", r100);
        r102.c(null, r101.f548582a).b();
    }

    @Override // t24.a
    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reson");
        u34.a r101 = x3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reson");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("plan_b_follow_page_show");
        r102.d("reason", r100);
        r102.c(null, r101.f548582a).b();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.awemeopen.appserviceimpl.event.b] */
    @Override // t24.a
    public final void p2(final JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L8;
        ?? r101 = new b(r100);
        x3().getClass();
        ((AoEventService) j64.a.a(AoEventService.class)).D1(new com.bytedance.awemeopen.infra.base.event.a(r101));
        return;
    }

    @Override // t24.a
    public final void reportVideoCardClick(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        x3().getClass();
        Intrinsics.checkNotNullParameter(r100, "param");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("video_card_click");
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        if (Intrinsics.areEqual(r103.getKey(), "host_extra_params") == true) goto L4;
        r101.d(r103.getKey(), r103.getValue());
        goto L4
    L9:
        if (r100.containsKey("host_extra_params") == false) goto L16;
        String r104 = r100.get("host_extra_params");
        if (r104 == null) goto L16;
        r101.f198612d = new JSONObject(r104);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        AoLogger.c("EventReportDomain", new Object[]{th});
        Unit r105 = Unit.INSTANCE;
    L16:
        r101.d(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "from_host");
        r101.a().b();
    }

    @Override // t24.a
    public final void reportVideoCardShow(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        x3().getClass();
        Intrinsics.checkNotNullParameter(r100, "param");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("video_card_show");
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, String> r103 = r102.next();
        if (Intrinsics.areEqual(r103.getKey(), "host_extra_params") == true) goto L4;
        r101.d(r103.getKey(), r103.getValue());
        goto L4
    L8:
        r101.d(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "from_host");
        if (r100.containsKey("host_extra_params") == false) goto L16;
        String r104 = r100.get("host_extra_params");
        if (r104 == null) goto L16;
        r101.f198612d = new JSONObject(r104);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        AoLogger.c("EventReportDomain", new Object[]{th});
        Unit r105 = Unit.INSTANCE;
    L16:
        r101.a().b();
    }

    @Override // t24.a
    public final void t1(String r100) {
        u34.a r101 = x3();
        r101.getClass();
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("exit_toast_show");
        r102.d("enter_from", r100);
        r102.c(null, r101.f548582a).b();
    }

    @Override // t24.a
    public final void v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        this.f198099d = r100;
    }

    @Override // t24.a
    public final void z0(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f198097b.remove(r100);
    }

    @Override // t24.a
    public final void C1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("change_speed_guide_use");
        r103.d("author_openid", r101);
        r103.d("enter_from", r100);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void V0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "currentTab");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "currentTab");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("homepage_tab_click");
        r103.d("current_tab", r100);
        r103.d("is_show_red_dot", Integer.valueOf(r101));
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void b2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "reson");
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "reson");
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("plan_b_follow_page_click");
        r103.d("reason", r100);
        r103.d(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r101);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void e1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("change_speed_guide_show");
        r103.d("author_openid", r101);
        r103.d("enter_from", r100);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void o(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "param");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "param");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a(r100);
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, String> r105 = r104.next();
        r103.d(r105.getKey(), r105.getValue());
        goto L4
    L6:
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void p1(String r110, boolean r111) {
        String r100 = "0";
        Intrinsics.checkNotNullParameter("0", "isSkipConfirm");
        Intrinsics.checkNotNullParameter("mix", "isOneClickLogin");
        r14.c r101 = this.f198098c;
        String r102 = this.f198099d;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        u34.a r104 = x3();
        if (r101 == null) goto L11;
        User r112 = r101.f();
        if (r112 == null) goto L11;
        String r113 = r112.u();
        if (r113 == null) goto L11;
    L12:
        if (r101 == null) goto L15;
        String r114 = r101.c();
        if (r114 == null) goto L15;
    L16:
        if (r101 == null) goto L19;
        String r115 = r101.r().f535651c;
        if (r115 == null) goto L19;
    L20:
        if (r101 == null) goto L25;
        a0 r116 = r101.f535622d;
        if (r116 == null) goto L25;
        String r117 = r116.a();
        if (r117 == null) goto L25;
    L26:
        String r118 = y3(r101);
        if (r101 == null) goto L31;
        a0 r105 = r101.f535622d;
        if (r105 == null) goto L31;
        String r106 = r105.a();
    L32:
        if (r106 == null) goto L35;
        r103 = r106;
    L35:
        int r107 = u34.a.f548581b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r113, "authorOpenId");
        Intrinsics.checkNotNullParameter(r114, "groupId");
        Intrinsics.checkNotNullParameter(r115, "hostGroupId");
        Intrinsics.checkNotNullParameter(r117, "requestId");
        Intrinsics.checkNotNullParameter(r118, "logPb");
        Intrinsics.checkNotNullParameter(r103, "imprId");
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter("0", "isSkipConfirm");
        Intrinsics.checkNotNullParameter("mix", "isOneClickLogin");
        String r108 = u34.a.b(r102);
        com.bytedance.awemeopen.infra.base.event.b.C2872b r109 = com.bytedance.awemeopen.infra.base.event.b.a("livesdk_aweme_authorization_integrate_pop_show");
        r109.d("enter_from", r102);
        r109.d("enter_from_merge", r108);
        r109.d("author_openid", r113);
        r109.d("group_id", r114);
        r109.d("host_group_id", r115);
        r109.d("video_id", r114);
        r109.d("request_id", r117);
        r109.d("log_pb", r118);
        r109.d("impr_id", r103);
        r109.d(HianalyticsBaseData.SDK_TYPE, "video");
        r109.d("source", r110);
        r109.d("is_skip_confirm", "0");
        r109.d("is_oneclick_login", "mix");
        r109.d("is_h5", "no_h5");
        if (r111 == false) goto L38;
        r100 = "1";
    L38:
        r109.d("is_card_sdk", r100);
        r109.b(null, r104.f548582a).b();
        return;
    L31:
        r106 = null;
    L25:
        r117 = "";
    L19:
        r115 = "";
    L15:
        r114 = "";
    L11:
        r113 = "";
        goto L12
    }

    @Override // t24.a
    public final void s2(boolean r100, long r101) {
        Intrinsics.checkNotNullParameter("specified", "apiType");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter("specified", "apiType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("ao_photo_data_load_result");
        r103.d("error_code", Integer.valueOf(!r100 ? 1 : 0));
        r103.d("apiType", "specified");
        r103.d("duration", Long.valueOf(r101));
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void M2(String r100, r14.c r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        this.f198099d = r100;
        this.f198098c = r101;
        this.f198100e = r102;
    }

    @Override // t24.a
    public final void N0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        u34.a r103 = x3();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r104 = com.bytedance.awemeopen.infra.base.event.b.a("chat_bar_show");
        r104.d("enter_from_merge", r100);
        r104.d("enter_method", r101);
        r104.d("anchor_id", r102);
        r104.c(null, r103.f548582a).b();
    }

    @Override // t24.a
    public final void a0(String r100, boolean r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        u34.a r103 = x3();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r104 = com.bytedance.awemeopen.infra.base.event.b.a("ao_feed_load_more_rate");
        r104.d("scene", r100);
        r104.d("show_loading", Integer.valueOf(r101 ? 1 : 0));
        r104.b(r102, r103.f548582a).b();
    }

    @Override // t24.a
    public final void D(String r100, Map r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (this.f198101f == false) goto L5;
        String r104 = "1";
    L6:
        r101.put("is_landscape_mode", r104);
        u34.a r105 = x3();
        int r106 = u34.a.f548581b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r107 = com.bytedance.awemeopen.infra.base.event.b.a(r100);
        Iterator r108 = ((LinkedHashMap) r101).entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.d((String) r109.getKey(), r109.getValue());
        goto L8
    L10:
        r107.f198611c = r102;
        r107.f198612d = r103;
        r107.b(null, r105.f548582a).b();
        return;
    L5:
        r104 = "0";
        goto L6
    }

    @Override // t24.a
    public final void O1(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter("compilation_play", "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "groupId");
        Intrinsics.checkNotNullParameter(r110, "hostGroupId");
        Intrinsics.checkNotNullParameter(r111, "compilationId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter("compilation_play", "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "groupId");
        Intrinsics.checkNotNullParameter(r110, "hostGroupId");
        Intrinsics.checkNotNullParameter(r111, "compilationId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("cancel_favourite_compilation");
        r103.d("enter_from", "compilation_play");
        r103.d("author_openid", r100);
        r103.d("group_id", r101);
        r103.d("host_group_id", r110);
        r103.d("compilation_id", r111);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void P(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter("compilation_play", "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "groupId");
        Intrinsics.checkNotNullParameter(r110, "hostGroupId");
        Intrinsics.checkNotNullParameter(r111, "compilationId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter("compilation_play", "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "groupId");
        Intrinsics.checkNotNullParameter(r110, "hostGroupId");
        Intrinsics.checkNotNullParameter(r111, "compilationId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("favourite_compilation");
        r103.d("enter_from", "compilation_play");
        r103.d("author_openid", r100);
        r103.d("group_id", r101);
        r103.d("host_group_id", r110);
        r103.d("compilation_id", r111);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void X0(String r110, String r210, String r211, boolean r212) {
        String r100 = "0";
        Intrinsics.checkNotNullParameter("0", "isSkipConfirm");
        Intrinsics.checkNotNullParameter(r210, "isOneClickLogin");
        r14.c r101 = this.f198098c;
        String r102 = this.f198099d;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        u34.a r111 = x3();
        if (r101 == null) goto L11;
        User r112 = r101.f();
        if (r112 == null) goto L11;
        String r113 = r112.u();
        if (r113 == null) goto L11;
    L12:
        if (r101 == null) goto L15;
        String r114 = r101.c();
        if (r114 == null) goto L15;
    L16:
        if (r101 == null) goto L19;
        String r115 = r101.r().f535651c;
        if (r115 == null) goto L19;
    L20:
        if (r101 == null) goto L25;
        a0 r116 = r101.f535622d;
        if (r116 == null) goto L25;
        String r117 = r116.a();
        if (r117 == null) goto L25;
    L26:
        String r118 = y3(r101);
        if (r101 == null) goto L31;
        a0 r104 = r101.f535622d;
        if (r104 == null) goto L31;
        String r105 = r104.a();
    L32:
        if (r105 == null) goto L35;
        r103 = r105;
    L35:
        int r106 = a.f198103a;
        String r107 = a.a(y54.a.a());
        int r119 = u34.a.f548581b;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r113, "authorOpenId");
        Intrinsics.checkNotNullParameter(r114, "groupId");
        Intrinsics.checkNotNullParameter(r115, "hostGroupId");
        Intrinsics.checkNotNullParameter(r117, "requestId");
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r118, "logPb");
        Intrinsics.checkNotNullParameter(r103, "imprId");
        Intrinsics.checkNotNullParameter("0", "isSkipConfirm");
        Intrinsics.checkNotNullParameter(r210, "isOneClickLogin");
        Intrinsics.checkNotNullParameter(r107, "authHostApp");
        Intrinsics.checkNotNullParameter(r211, "buttonType");
        String r108 = u34.a.b(r102);
        com.bytedance.awemeopen.infra.base.event.b.C2872b r109 = com.bytedance.awemeopen.infra.base.event.b.a("livesdk_aweme_authorization_integrate_pop_click");
        r109.d("enter_from", r102);
        r109.d("enter_from_merge", r108);
        r109.d("author_openid", r113);
        r109.d("group_id", r114);
        r109.d("host_group_id", r115);
        r109.d("video_id", r114);
        r109.d("request_id", r117);
        r109.d("log_pb", r118);
        r109.d("impr_id", r103);
        r109.d(HianalyticsBaseData.SDK_TYPE, "video");
        r109.d("source", r110);
        r109.d("is_skip_confirm", "0");
        r109.d("is_oneclick_login", r210);
        r109.d("is_h5", "no_h5");
        if (r212 == false) goto L38;
        r100 = "1";
    L38:
        r109.d("is_card_sdk", r100);
        r109.d("auth_host_app", r107);
        r109.d(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r211);
        r109.b(null, r111.f548582a).b();
        return;
    L31:
        r105 = null;
    L25:
        r117 = "";
    L19:
        r115 = "";
    L15:
        r114 = "";
    L11:
        r113 = "";
        goto L12
    }

    @Override // t24.a
    public final void t0(String r100, int r101, boolean r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        u34.a r104 = x3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r105 = com.bytedance.awemeopen.infra.base.event.b.a("start_fetch_feed_interface");
        r105.d("enter_from", r100);
        r105.d("count", Integer.valueOf(r101));
        r105.d("support_live", Integer.valueOf(r102 ? 1 : 0));
        r105.b(r103, r104.f548582a).b();
    }

    @Override // t24.a
    public final void E0(String r100, boolean r101, long r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "enterAid");
        x3().getClass();
        Intrinsics.checkNotNullParameter(r100, "enterAid");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r105 = com.bytedance.awemeopen.infra.base.event.b.a("ao_preload_data_consume");
        r105.d("enterAid", r100);
        r105.d("hitCache", Integer.valueOf(r101 ? 1 : 0));
        r105.d("enterAidFetchDuration", Long.valueOf(r102));
        r105.d("missReasonType", Integer.valueOf(r103));
        r105.d("aweme_type", Integer.valueOf(r104));
        r105.a().b();
    }

    @Override // t24.a
    public final void O(String r100, String r110, String r111, String r112, d r113) {
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter("", "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "toUserId");
        x3().e("play_history_anchor_show", r100, r110, r111, "", r112, r113);
    }

    @Override // t24.a
    public final void d(String r100, String r101, String r102, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r102, "imprId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        u34.a r103 = x3();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r102, "imprId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r104 = com.bytedance.awemeopen.infra.base.event.b.a("first_favorite_popup_show");
        r104.d("enter_from", r100);
        r104.d("author_openid", r101);
        r104.d("impr_id", r102);
        r104.d("group_id", r110);
        r104.d("host_group_id", r111);
        r104.c(null, r103.f548582a).b();
    }

    @Override // t24.a
    public final void d1(String r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter("favourite_video", "launch_from");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        u34.a r101 = x3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter("favourite_video", "launchFrom");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("favorite_notice_click");
        r102.d("enter_from", r100);
        r102.d("author_openid", r110);
        r102.d("launch_from", "favourite_video");
        r102.d("group_id", r111);
        r102.d("impr_id", r112);
        r102.d("host_group_id", r113);
        r102.c(null, r101.f548582a).b();
    }

    @Override // t24.a
    public final void f3(String r100, String r110, String r111, String r112, d r113) {
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter("", "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "toUserId");
        x3().e("play_history_mask_show", r100, r110, r111, "", r112, r113);
    }

    @Override // t24.a
    public final void g1(String r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter("favourite_video", "launch_from");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "imprId");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        u34.a r101 = x3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter("favourite_video", "launchFrom");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "imprId");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("favorite_notice_show");
        r102.d("enter_from", r100);
        r102.d("launch_from", "favourite_video");
        r102.d("group_id", r110);
        r102.d("impr_id", r111);
        r102.d("author_openid", r112);
        r102.d("host_group_id", r113);
        r102.c(null, r101.f548582a).b();
    }

    @Override // t24.a
    public final void h2(String r100, String r101, String r102, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "launch_from");
        Intrinsics.checkNotNullParameter(r102, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        u34.a r103 = x3();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "launchFrom");
        Intrinsics.checkNotNullParameter(r102, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r104 = com.bytedance.awemeopen.infra.base.event.b.a("aosdk_callback");
        r104.d("enter_from", r100);
        r104.d("launch_from", r101);
        r104.d("author_openid", r102);
        r104.d("group_id", r110);
        r104.d("host_group_id", r111);
        r104.c(null, r103.f548582a).b();
    }

    @Override // t24.a
    public final void n0(String r100, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter("compilation_play", "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "compilationId");
        Intrinsics.checkNotNullParameter(r113, "compilationType");
        u34.a r101 = x3();
        r101.getClass();
        Intrinsics.checkNotNullParameter("compilation_play", "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "compilationId");
        Intrinsics.checkNotNullParameter(r113, "compilationType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("compilation_select_video_click");
        r102.d("enter_from", "compilation_play");
        r102.d("author_openid", r100);
        r102.d("group_id", r110);
        r102.d("host_group_id", r111);
        r102.d("compilation_id", r112);
        r102.d("compilation_type", r113);
        r102.c(null, r101.f548582a).b();
    }

    @Override // t24.a
    public final void x2(String r100, String r110, String r111, String r112, d r113) {
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter("", "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "toUserId");
        x3().e("play_history_anchor_click", r100, r110, r111, "", r112, r113);
    }

    @Override // t24.a
    public final void A0(String r110, String r210, String r211, String r212, long r213, d r214) {
        Intrinsics.checkNotNullParameter("draw_video_WITHIN_tt_video_immerse", "enterFromMerge");
        Intrinsics.checkNotNullParameter("live_cell", "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter("", "anchorId");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "anchorAid");
        Intrinsics.checkNotNullParameter(r212, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter("draw_video_WITHIN_tt_video_immerse", "enterFromMerge");
        Intrinsics.checkNotNullParameter("live_cell", "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter("", "anchorId");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "anchorAid");
        Intrinsics.checkNotNullParameter(r212, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("livesdk_live_window_duration");
        r101.d("enter_from_merge", "draw_video_WITHIN_tt_video_immerse");
        r101.d("enter_method", "live_cell");
        r101.d("action_type", "click");
        r101.d("anchor_id", "");
        r101.d("room_id", r110);
        r101.d("request_id", r210);
        boolean r102 = true;
        if (r211.length() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L12;
        if (Intrinsics.areEqual(r211, "0") == true) goto L12;
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, r211);
    L12:
        if (r212.length() == 0) goto L15;
        r102 = false;
    L15:
        if (r102 == false) goto L17;
    L19:
        r101.d("video_source", "sdk_video");
        r101.d("duration", Long.valueOf(r213));
        r101.b(r214, r100.f548582a).b();
        return;
    L17:
        if (Intrinsics.areEqual(r212, "0") == true) goto L19;
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, r212);
        goto L19
    L5:
        r103 = false;
        goto L7
    }

    @Override // t24.a
    public final void J2(long r100, int r101, String r102, String r110, String r111, d r112) {
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r110, "loadingType");
        u34.a r103 = x3();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r110, "loadingType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r104 = com.bytedance.awemeopen.infra.base.event.b.a("ao_feed_manual_loading_result");
        r104.d("duration", Long.valueOf(r100));
        r104.d("errorCode", Integer.valueOf(r101));
        r104.d("scene", r102);
        r104.d("loadingType", r110);
        r104.d("apiType", r111);
        r104.b(r112, r103.f548582a).b();
    }

    @Override // t24.a
    public final void K2(String r100, String r101, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("teen_like_cancel");
        r103.d("enter_from", r100);
        r103.d("author_openid", r101);
        r103.d("group_id", r110);
        r103.d("host_group_id", r111);
        r103.d("impr_id", r112);
        r103.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r113);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void N(String r110, String r111, String r112, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r210, "authorOpenid");
        Intrinsics.checkNotNullParameter(r211, "fromGroupId");
        Intrinsics.checkNotNullParameter("1", "isRecommendTag");
        Intrinsics.checkNotNullParameter("1", "isRecommendTagClick");
        Intrinsics.checkNotNullParameter(r212, "hostEnterFrom");
        u34.a r113 = x3();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r210, "authorOpenid");
        Intrinsics.checkNotNullParameter(r211, "fromGroupId");
        Intrinsics.checkNotNullParameter(r212, "hostEnterFrom");
        Intrinsics.checkNotNullParameter("1", "isRecommendTag");
        Intrinsics.checkNotNullParameter("1", "isRecommendTagClick");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("video_play_rcmd_tag_click");
        r100.d("enter_from", r110);
        r100.d("group_id", r111);
        r100.d("impr_id", r112);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r211);
        r100.d("author_openid", r210);
        r100.d("is_recommend_tag", "1");
        r100.d("is_recommend_tag_click", "1");
        r100.d("host_enter_from", r212);
        r100.c(null, r113.f548582a).b();
    }

    @Override // t24.a
    public final void N1(String r100, String r101, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("teen_like");
        r103.d("enter_from", r100);
        r103.d("author_openid", r101);
        r103.d("group_id", r110);
        r103.d("host_group_id", r111);
        r103.d("impr_id", r112);
        r103.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r113);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void P0(String r100, String r101, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "compilationId");
        Intrinsics.checkNotNullParameter(r113, "compilationType");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "compilationId");
        Intrinsics.checkNotNullParameter(r113, "compilationType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("compilation_bar_click");
        r103.d("enter_from", r100);
        r103.d("author_openid", r101);
        r103.d("group_id", r110);
        r103.d("host_group_id", r111);
        r103.d("compilation_id", r112);
        r103.d("compilation_type", r113);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void R0(String r100, String r101, String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "imprId");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "hostGroupId");
        Intrinsics.checkNotNullParameter(r113, "clickArea");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "imprId");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "hostGroupId");
        Intrinsics.checkNotNullParameter(r113, "clickArea");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("first_favorite_popup_click");
        r103.d("enter_from", r100);
        r103.d("author_openid", r101);
        r103.d("impr_id", r110);
        r103.d("group_id", r111);
        r103.d("host_group_id", r112);
        r103.d(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r113);
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void T0(String r110, String r111, String r112, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r110, "storeType");
        Intrinsics.checkNotNullParameter("others_homepage", "entranceLocation");
        Intrinsics.checkNotNullParameter(r111, "storeSourcePage");
        Intrinsics.checkNotNullParameter(r112, "storeGroupType");
        Intrinsics.checkNotNullParameter(r210, "storeSourceMethod");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "shopId");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r110, "storeType");
        Intrinsics.checkNotNullParameter("others_homepage", "entranceLocation");
        Intrinsics.checkNotNullParameter(r111, "storeSourcePage");
        Intrinsics.checkNotNullParameter(r112, "storeGroupType");
        Intrinsics.checkNotNullParameter(r210, "storeSourceMethod");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "shopId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("show_store_entrance");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r110);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "others_homepage");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r111);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r112);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r210);
        r101.d("author_openid", r211);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r212);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void k3(String r110, String r111, String r112, String r113, String r114, d r115) {
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "toUserId");
        x3().e("play_history_mask_click", r110, r111, r112, r113, r114, r115);
    }

    @Override // t24.a
    public final void n1(String r110, String r111, String r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "authorOpenid");
        Intrinsics.checkNotNullParameter(r114, "fromGroupId");
        Intrinsics.checkNotNullParameter("1", "isRecommendTag");
        Intrinsics.checkNotNullParameter(r115, "hostEnterFrom");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "groupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "authorOpenid");
        Intrinsics.checkNotNullParameter(r114, "fromGroupId");
        Intrinsics.checkNotNullParameter("1", "isRecommendTag");
        Intrinsics.checkNotNullParameter(r115, "hostEnterFrom");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("video_play_rcmd_tag_show");
        r101.d("enter_from", r110);
        r101.d("group_id", r111);
        r101.d("impr_id", r112);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r114);
        r101.d("author_openid", r113);
        r101.d("is_recommend_tag", "1");
        r101.d("host_enter_from", r115);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void o0(String r110, String r111, String r112, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r110, "storeType");
        Intrinsics.checkNotNullParameter("others_homepage", "entranceLocation");
        Intrinsics.checkNotNullParameter(r111, "storeSourcePage");
        Intrinsics.checkNotNullParameter(r112, "storeGroupType");
        Intrinsics.checkNotNullParameter(r210, "storeSourceMethod");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "shopId");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r110, "storeType");
        Intrinsics.checkNotNullParameter("others_homepage", "entranceLocation");
        Intrinsics.checkNotNullParameter(r111, "storeSourcePage");
        Intrinsics.checkNotNullParameter(r112, "storeGroupType");
        Intrinsics.checkNotNullParameter(r210, "storeSourceMethod");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "shopId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("click_store_entrance");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r110);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "others_homepage");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r111);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r112);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r210);
        r101.d("author_openid", r211);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r212);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void u2(String r110, String r111, String r112, String r210, boolean r211, int r212) {
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r210, "logPb");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, "switchPosition");
        u34.a r113 = x3();
        boolean r114 = this.f198100e;
        String r115 = this.f198099d;
        if (r115 != null) goto L5;
        r115 = "";
    L5:
        int r116 = u34.a.f548581b;
        r113.getClass();
        Intrinsics.checkNotNullParameter("auto_play_switch", "eventName");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r210, "logPb");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, "switchPosition");
        Intrinsics.checkNotNullParameter(r115, "enterFrom");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("auto_play_switch");
        r100.d("group_id", r110);
        r100.d("host_group_id", r111);
        r100.d("impr_id", r112);
        r100.d("log_pb", r210);
        r100.d("switch_position", com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
        if (r211 == false) goto L8;
        String r101 = "on";
    L9:
        r100.d("switch_type", r101);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r114 ? 1 : 0));
        r100.d("enter_from", r115);
        r100.d("group_source", Integer.valueOf(r212));
        r100.b(null, r113.f548582a).b();
        return;
    L8:
        r101 = "off";
        goto L9
    }

    @Override // t24.a
    public final void F0(String r210, String r211, String r212, boolean r213, Integer r214, String r215, String r216) {
        String r100 = "0";
        Intrinsics.checkNotNullParameter("0", "isSkipConfirm");
        Intrinsics.checkNotNullParameter(r211, "isOneClickLogin");
        Intrinsics.checkNotNullParameter(r212, "result");
        r14.c r101 = this.f198098c;
        String r102 = this.f198099d;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        u34.a r110 = x3();
        if (r101 == null) goto L11;
        User r111 = r101.f();
        if (r111 == null) goto L11;
        String r112 = r111.u();
        if (r112 == null) goto L11;
    L12:
        if (r101 == null) goto L15;
        String r113 = r101.c();
        if (r113 == null) goto L15;
    L16:
        if (r101 == null) goto L19;
        String r114 = r101.r().f535651c;
        if (r114 == null) goto L19;
    L20:
        if (r101 == null) goto L25;
        a0 r115 = r101.f535622d;
        if (r115 == null) goto L25;
        String r116 = r115.a();
        if (r116 == null) goto L25;
    L26:
        String r103 = y3(r101);
        if (r101 == null) goto L31;
        a0 r104 = r101.f535622d;
        if (r104 == null) goto L31;
        String r105 = r104.a();
    L32:
        if (r105 != null) goto L34;
        r105 = "";
    L34:
        int r117 = a.f198103a;
        String r118 = a.a(y54.a.a());
        if (r214 == null) goto L37;
        int r119 = r214.intValue();
    L38:
        Integer r120 = Integer.valueOf(r119);
        if (r215 != null) goto L41;
        String r121 = "";
    L42:
        if (r216 != null) goto L44;
        String r217 = "";
    L45:
        int r122 = u34.a.f548581b;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r116, "requestId");
        Intrinsics.checkNotNullParameter(r103, "logPb");
        Intrinsics.checkNotNullParameter(r105, "imprId");
        Intrinsics.checkNotNullParameter(r210, "source");
        Intrinsics.checkNotNullParameter(r212, "result");
        Intrinsics.checkNotNullParameter("0", "isSkipConfirm");
        Intrinsics.checkNotNullParameter(r211, "isOneClickLogin");
        Intrinsics.checkNotNullParameter(r118, "authHostApp");
        String r106 = u34.a.b(r102);
        com.bytedance.awemeopen.infra.base.event.b.C2872b r123 = com.bytedance.awemeopen.infra.base.event.b.a("livesdk_aweme_authorization_result");
        r123.d("enter_from", r102);
        r123.d("enter_from_merge", r106);
        r123.d("author_openid", r112);
        r123.d("group_id", r113);
        r123.d("host_group_id", r114);
        r123.d("video_id", r113);
        r123.d("request_id", r116);
        r123.d("log_pb", r103);
        r123.d("impr_id", r105);
        r123.d(HianalyticsBaseData.SDK_TYPE, "video");
        r123.d("source", r210);
        r123.d("result", r212);
        r123.d("is_skip_confirm", "0");
        r123.d("is_oneclick_login", r211);
        r123.d("is_h5", "no_h5");
        if (r213 == false) goto L48;
        r100 = "1";
    L48:
        r123.d("is_card_sdk", r100);
        r123.d("auth_host_app", r118);
        r123.d("interact_authorized_type", r120);
        r123.d("aweme_authorization_error_code", r121);
        r123.d("aweme_authorization_fail_info", r217);
        r123.b(null, r110.f548582a).b();
        return;
    L44:
        r217 = r216;
        goto L45
    L41:
        r121 = r215;
        goto L42
    L37:
        r119 = 1;
    L31:
        r105 = null;
    L25:
        r116 = "";
    L19:
        r114 = "";
    L15:
        r113 = "";
    L11:
        r112 = "";
        goto L12
    }

    @Override // t24.a
    public final void Z0(boolean r100, int r101, String r102, String r103, long r110, int r111, d r112) {
        Intrinsics.checkNotNullParameter(r102, "enterAid");
        Intrinsics.checkNotNullParameter(r103, "enterLiveRoomId");
        u34.a r104 = x3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "enterAid");
        Intrinsics.checkNotNullParameter(r103, "enterLiveRoomId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r105 = com.bytedance.awemeopen.infra.base.event.b.a("ao_recommend_feed_first_brush_result");
        r105.d("useCache", Integer.valueOf(r100 ? 1 : 0));
        r105.d("pullType", Integer.valueOf(r101));
        r105.d("enterAid", r102);
        r105.d("enterLiveRoomId", r103);
        r105.d("duration", Long.valueOf(r110));
        r105.d("count", Integer.valueOf(r111));
        r105.b(r112, r104.f548582a).b();
    }

    @Override // t24.a
    public final void d0(String r100, String r101, String r110, String r111, String r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("teen_video_play_finish");
        r103.d("enter_from", r100);
        r103.d("author_openid", r101);
        r103.d("group_id", r110);
        r103.d("host_group_id", r111);
        r103.d("impr_id", r112);
        r103.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r113);
        r103.d("is_auto_draw", Integer.valueOf(r114 ? 1 : 0));
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void n3(String r100, String r101, String r110, String r111, String r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        u34.a r102 = x3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r110, "groupId");
        Intrinsics.checkNotNullParameter(r111, "hostGroupId");
        Intrinsics.checkNotNullParameter(r112, "imprId");
        Intrinsics.checkNotNullParameter(r113, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("teen_video_play");
        r103.d("enter_from", r100);
        r103.d("author_openid", r101);
        r103.d("group_id", r110);
        r103.d("host_group_id", r111);
        r103.d("impr_id", r112);
        r103.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r113);
        r103.d("is_auto_draw", Integer.valueOf(r114 ? 1 : 0));
        r103.c(null, r102.f548582a).b();
    }

    @Override // t24.a
    public final void r1(String r100, String r101, String r102, String r110, String r111, JSONObject r112, e r113) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r102, "groupId");
        Intrinsics.checkNotNullParameter(r110, "imprId");
        Intrinsics.checkNotNullParameter(r111, "fromGroupId");
        u34.a r103 = x3();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        Intrinsics.checkNotNullParameter(r102, "groupId");
        Intrinsics.checkNotNullParameter(r110, "imprId");
        Intrinsics.checkNotNullParameter(r111, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r104 = com.bytedance.awemeopen.infra.base.event.b.a("screenshoot_click");
        r104.d("enter_from", r100);
        r104.d("author_openid", r101);
        r104.d("group_id", r102);
        r104.d("impr_id", r110);
        r104.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r111);
        r104.f198612d = r112;
        r104.b(r113, r103.f548582a).b();
    }

    @Override // t24.a
    public final void K1(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        Intrinsics.checkNotNullParameter(r212, "group_source");
        Intrinsics.checkNotNullParameter(r213, "previous_page");
        Intrinsics.checkNotNullParameter(r214, "function_name");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        Intrinsics.checkNotNullParameter(r212, "group_source");
        Intrinsics.checkNotNullParameter(r213, "previous_page");
        Intrinsics.checkNotNullParameter(r214, "function_name");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("function_component_show");
        r101.d("enter_from", r110);
        r101.d("author_openid", r111);
        r101.d("group_id", r112);
        r101.d("impr_id", r210);
        r101.d("log_pb", r211);
        r101.d("group_source", r212);
        r101.d("previous_page", r213);
        r101.d("function_name", r214);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void S(String r100, String r101, String r102, String r103, String r110, float r111, float r112, e r113) {
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "groupId");
        Intrinsics.checkNotNullParameter(r103, "imprId");
        u34.a r104 = x3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r102, "groupId");
        Intrinsics.checkNotNullParameter(r103, "imprId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r105 = com.bytedance.awemeopen.infra.base.event.b.a("click_trans_layer_action");
        r105.d("author_openid", r100);
        r105.d("enter_from", r101);
        r105.d("group_id", r102);
        r105.d("impr_id", r103);
        r105.d("previous_page", r110);
        r105.d("long_press_x", Float.valueOf(r111));
        r105.d("long_press_y", Float.valueOf(r112));
        r105.b(r113, r104.f548582a).b();
    }

    @Override // t24.a
    public final void e0(String r110, String r111, String r112, String r113, String r210, String r211, boolean r212, d r213) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        u34.a r114 = x3();
        boolean r115 = this.f198100e;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("click_avatar");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d("host_group_id", r113);
        r100.d("impr_id", r210);
        r100.d("log_pb", r211);
        r100.d("is_following", Integer.valueOf(r212 ? 1 : 0));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r115 ? 1 : 0));
        r100.b(r213, r114.f548582a).b();
    }

    @Override // t24.a
    public final void g0(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        Intrinsics.checkNotNullParameter(r212, "group_source");
        Intrinsics.checkNotNullParameter(r213, "previous_page");
        Intrinsics.checkNotNullParameter(r214, "function_name");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        Intrinsics.checkNotNullParameter(r212, "group_source");
        Intrinsics.checkNotNullParameter(r213, "previous_page");
        Intrinsics.checkNotNullParameter(r214, "function_name");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("function_component_click");
        r101.d("enter_from", r110);
        r101.d("author_openid", r111);
        r101.d("group_id", r112);
        r101.d("impr_id", r210);
        r101.d("log_pb", r211);
        r101.d("group_source", r212);
        r101.d("previous_page", r213);
        r101.d("function_name", r214);
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void l3(String r110, String r111, String r112, String r113, String r114, long r115, String r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r210, "fromGroupId");
        u34.a r116 = x3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r210, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("teen_play_time");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d("host_group_id", r113);
        r100.d("duration", Long.valueOf(r115));
        r100.d("impr_id", r114);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r210);
        r100.d("is_auto_draw", Integer.valueOf(r211 ? 1 : 0));
        r100.c(null, r116.f548582a).b();
    }

    @Override // t24.a
    public final void F1(String r210, String r211, String r212, String r213, String r214, String r215, String r216, d r217, JSONObject r218) {
        Intrinsics.checkNotNullParameter(r210, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r211, "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r212, "anchorId");
        Intrinsics.checkNotNullParameter(r213, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r214, "requestId");
        Intrinsics.checkNotNullParameter(r215, "anchorAid");
        Intrinsics.checkNotNullParameter(r216, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r211, "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r212, "anchorId");
        Intrinsics.checkNotNullParameter(r213, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r214, "requestId");
        Intrinsics.checkNotNullParameter(r215, "anchorAid");
        Intrinsics.checkNotNullParameter(r216, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("livesdk_rec_live_play");
        r110.d("enter_from_merge", r210);
        r110.d("enter_method", r211);
        r110.d("action_type", "click");
        r110.d("anchor_id", r212);
        r110.d("room_id", r213);
        r110.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID, "");
        r110.d("request_id", r214);
        boolean r101 = true;
        if (r215.length() <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L12;
        if (Intrinsics.areEqual(r215, "0") == true) goto L12;
        r110.d(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, r215);
    L12:
        if (r216.length() > 0) goto L15;
        r101 = false;
    L15:
        if (r101 == true) goto L17;
    L19:
        r110.d("video_source", "sdk_video");
        r110.f198612d = r218;
        r110.b(r217, r100.f548582a).b();
        return;
    L17:
        if (Intrinsics.areEqual(r216, "0") == true) goto L19;
        r110.d(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, r216);
        goto L19
    L5:
        r102 = false;
        goto L7
    }

    @Override // t24.a
    public final void S1(String r110, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, e r217) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "enterMethod");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter("slide", "position");
        u34.a r111 = x3();
        boolean r100 = this.f198100e;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "enterMethod");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter("slide", "position");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a("enter_personal_favorite");
        r112.d("enter_from", r110);
        r112.d("enter_method", r210);
        r112.d("author_openid", r211);
        r112.d("group_id", r212);
        r112.d("host_group_id", r213);
        r112.d("impr_id", r214);
        r112.d("log_pb", r215);
        r112.d("is_following", Integer.valueOf(r216 ? 1 : 0));
        r112.d("position", "slide");
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r100 ? 1 : 0));
        r112.b(r217, r111.f548582a).b();
    }

    @Override // t24.a
    public final JSONObject Y2(String r110, String r111, String r112, String r113, String r114, String r115, boolean r210, boolean r211, d r212) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "logPb");
        u34.a r116 = x3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "logPb");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("event_dry_get_final_event");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d("host_group_id", r113);
        r100.d("impr_id", r114);
        r100.d("log_pb", r115);
        r100.d("is_following", Integer.valueOf(r210 ? 1 : 0));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r211 ? 1 : 0));
        com.bytedance.awemeopen.infra.base.event.b r101 = r100.b(r212, r116.f548582a);
        return ((AoEventService) j64.a.a(AoEventService.class)).z2(r101.c());
    }

    @Override // t24.a
    public final void q0(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215) {
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "fromGroupId");
        Intrinsics.checkNotNullParameter(r212, "unfoldMethod");
        Intrinsics.checkNotNullParameter(r213, "groupSource");
        Intrinsics.checkNotNullParameter(r214, "previousPage");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "fromGroupId");
        Intrinsics.checkNotNullParameter(r212, "unfoldMethod");
        Intrinsics.checkNotNullParameter(r213, "groupSource");
        Intrinsics.checkNotNullParameter(r214, "previousPage");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("video_copywriting_unfold");
        r101.d("author_openid", r110);
        r101.d("enter_from", r111);
        r101.d("group_id", r112);
        r101.d("impr_id", r210);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r211);
        r101.d("unfold_method", r212);
        r101.d("group_source", r213);
        r101.d("previous_page", r214);
        r101.f198611c = r215;
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void H2(String r110, String r111, String r210, String r211, String r212, String r213, boolean r214, String r215, String r216, d r217) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r215, "enterMethod");
        Intrinsics.checkNotNullParameter(r216, "showType");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r215, "enterMethod");
        Intrinsics.checkNotNullParameter(r216, "showType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a("auto_play_show");
        r112.d("enter_from", r110);
        r112.d("author_openid", r111);
        r112.d("group_id", r210);
        r112.d("host_group_id", r211);
        r112.d("impr_id", r212);
        r112.d("log_pb", r213);
        r112.d("is_following", Integer.valueOf(r214 ? 1 : 0));
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r112.d("enter_method", r215);
        r112.d("show_type", r216);
        r112.b(r217, r100.f548582a).b();
    }

    @Override // t24.a
    public final void U(String r110, String r111, String r112, String r113, String r210, String r211, String r212, boolean r213, boolean r214, JSONObject r215) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r210, "hostGroupId");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        u34.a r114 = x3();
        boolean r115 = this.f198101f;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r210, "hostGroupId");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a(r110);
        r100.d("enter_from", r111);
        r100.d("group_id", r113);
        r100.d("host_group_id", r210);
        r100.d("author_openid", r211);
        r100.d("impr_id", r212);
        String r101 = "1";
        if (r213 == false) goto L5;
        Object r102 = "1";
    L6:
        r100.d("is_card_sdk", r102);
        if (r115 == false) goto L9;
        Object r103 = "1";
    L10:
        r100.d("is_landscape_mode", r103);
        if (r214 == true) goto L14;
        r101 = "0";
    L14:
        r100.d("is_livehead", r101);
        if (r112 != null) goto L17;
    L22:
        r100.f198612d = r215;
        r100.c(null, r114.f548582a).b();
        return;
    L17:
        if ((!StringsKt.isBlank(r112)) == false) goto L19;
        String r104 = r112;
    L20:
        if (r104 == null) goto L22;
        r100.d("host_enter_from", r104);
        goto L22
    L19:
        r104 = null;
        goto L20
    L9:
        r103 = "0";
        goto L10
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void d3(String r110, String r111, String r112, String r113, String r114, String r115, boolean r210, boolean r211, JSONObject r212, String r213) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r115, "imprId");
        u34.a r116 = x3();
        boolean r117 = this.f198101f;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r115, "imprId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("cancel_favourite_video");
        r100.d("enter_from", r110);
        r100.d("author_openid", r112);
        r100.d("group_id", r113);
        r100.d("host_group_id", r114);
        r100.d("impr_id", r115);
        String r101 = "1";
        if (r210 == false) goto L5;
        Object r102 = "1";
    L6:
        r100.d("is_card_sdk", r102);
        if (r117 == false) goto L9;
        Object r103 = "1";
    L10:
        r100.d("is_landscape_mode", r103);
        if (r211 == true) goto L14;
        r101 = "0";
    L14:
        r100.d("is_livehead", r101);
        if (r111 != null) goto L17;
    L22:
        if (r213 != null) goto L24;
    L29:
        r100.f198612d = r212;
        r100.c(null, r116.f548582a).b();
        return;
    L24:
        if ((!StringsKt.isBlank(r213)) == false) goto L26;
        String r104 = r213;
    L27:
        if (r104 == null) goto L29;
        r100.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r104);
        goto L29
    L26:
        r104 = null;
        goto L27
    L17:
        if ((!StringsKt.isBlank(r111)) == false) goto L19;
        String r105 = r111;
    L20:
        if (r105 == null) goto L22;
        r100.d("host_enter_from", r105);
        goto L22
    L19:
        r105 = null;
        goto L20
    L9:
        r103 = "0";
        goto L10
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void h1(String r110, String r111, String r112, String r113, String r114, String r115, boolean r210, boolean r211, JSONObject r212, e r213) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "authorOpenId");
        Intrinsics.checkNotNullParameter(r115, "imprId");
        u34.a r116 = x3();
        boolean r117 = this.f198101f;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "authorOpenId");
        Intrinsics.checkNotNullParameter(r115, "imprId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("favourite_video");
        r100.d("enter_from", r110);
        r100.d("group_id", r112);
        r100.d("host_group_id", r113);
        r100.d("author_openid", r114);
        r100.d("impr_id", r115);
        String r101 = "1";
        if (r210 == false) goto L5;
        Object r102 = "1";
    L6:
        r100.d("is_card_sdk", r102);
        if (r117 == false) goto L9;
        Object r103 = "1";
    L10:
        r100.d("is_landscape_mode", r103);
        if (r211 == true) goto L14;
        r101 = "0";
    L14:
        r100.d("is_livehead", r101);
        if (r111 != null) goto L17;
    L22:
        r100.f198612d = r212;
        r100.b(r213, r116.f548582a).b();
        return;
    L17:
        if ((!StringsKt.isBlank(r111)) == false) goto L19;
        String r104 = r111;
    L20:
        if (r104 == null) goto L22;
        r100.d("host_enter_from", r104);
        goto L22
    L19:
        r104 = null;
        goto L20
    L9:
        r103 = "0";
        goto L10
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void k1(String r110, String r111, String r210, String r211, String r212, String r213, boolean r214, String r215, String r216, d r217) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r215, "enterMethod");
        Intrinsics.checkNotNullParameter(r216, "showType");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r215, "enterMethod");
        Intrinsics.checkNotNullParameter(r216, "showType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a("auto_play_click");
        r112.d("enter_from", r110);
        r112.d("author_openid", r111);
        r112.d("group_id", r210);
        r112.d("host_group_id", r211);
        r112.d("impr_id", r212);
        r112.d("log_pb", r213);
        r112.d("is_following", Integer.valueOf(r214 ? 1 : 0));
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r112.d("enter_method", r215);
        r112.d("show_type", r216);
        r112.b(r217, r100.f548582a).b();
    }

    @Override // t24.a
    public final void m0(String r110, String r111, String r112, String r210, d r211, String r212, String r213, String r214, double r215, JSONObject r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "fromGroupId");
        Intrinsics.checkNotNullParameter(r112, "toGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r212, "previousPage");
        Intrinsics.checkNotNullParameter(r213, "groupSource");
        Intrinsics.checkNotNullParameter(r214, "authorOpenId");
        u34.a r113 = x3();
        boolean r100 = this.f198100e;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "fromGroupId");
        Intrinsics.checkNotNullParameter(r112, "toGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r212, "previousPage");
        Intrinsics.checkNotNullParameter(r213, "groupSource");
        Intrinsics.checkNotNullParameter(r214, "authorOpenId");
        if (Intrinsics.areEqual(r110, "homepage_follow") == false) goto L5;
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("homepage_follow_slide_up");
    L6:
        r101.d("enter_from", r110);
        r101.d("author_openid", r214);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r111);
        r101.d("to_group_id", r112);
        r101.d("impr_id", r210);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r100 ? 1 : 0));
        r101.d("author_openid", r214);
        r101.d("previous_page", r212);
        r101.d("group_source", r213);
        r101.d("performance_fps", Double.valueOf(r215));
        r101.f198612d = r216;
        r101.b(r211, r113.f548582a).b();
        return;
    L5:
        r101 = com.bytedance.awemeopen.infra.base.event.b.a("homepage_hot_slide_up");
        goto L6
    }

    @Override // t24.a
    public final void p(String r110, String r111, String r112, String r210, int r211, String r212, String r213, String r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r212, "reasonText");
        Intrinsics.checkNotNullParameter(r213, "reasonType");
        Intrinsics.checkNotNullParameter(r214, "reason");
        Intrinsics.checkNotNullParameter(r215, "objectId");
        Intrinsics.checkNotNullParameter(r216, "objectType");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r212, "reasonText");
        Intrinsics.checkNotNullParameter(r213, "reasonType");
        Intrinsics.checkNotNullParameter(r214, "reason");
        Intrinsics.checkNotNullParameter(r215, "objectId");
        Intrinsics.checkNotNullParameter(r216, "objectType");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("click_report_submit");
        r101.d("enter_from", r110);
        r101.d("author_openid", r112);
        r101.d("group_id", r210);
        r101.d("aweme_type", Integer.valueOf(r211));
        r101.d("reason_text", r212);
        r101.d("reason_type", r213);
        r101.d("report_reason", r214);
        r101.d("object_id", r215);
        r101.d("object_type", r216);
        if (r111 != null) goto L5;
    L10:
        r101.f198611c = null;
        r101.f198612d = null;
        r101.b(null, r100.f548582a).b();
        return;
    L5:
        if ((!StringsKt.isBlank(r111)) == false) goto L7;
        String r102 = r111;
    L8:
        if (r102 == null) goto L10;
        r101.d("host_enter_from", r102);
        goto L10
    L7:
        r102 = null;
        goto L8
    }

    @Override // t24.a
    public final void w1(String r110, String r111, String r112, String r210, d r211, String r212, String r213, String r214, double r215, JSONObject r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "fromGroupId");
        Intrinsics.checkNotNullParameter(r112, "toGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r212, "previousPage");
        Intrinsics.checkNotNullParameter(r213, "groupSource");
        Intrinsics.checkNotNullParameter(r214, "authorOpenId");
        u34.a r113 = x3();
        boolean r100 = this.f198100e;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "fromGroupId");
        Intrinsics.checkNotNullParameter(r112, "toGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r212, "previousPage");
        Intrinsics.checkNotNullParameter(r213, "groupSource");
        Intrinsics.checkNotNullParameter(r214, "authorOpenId");
        if (Intrinsics.areEqual(r110, "homepage_follow") == false) goto L5;
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("homepage_follow_slide_down");
    L6:
        r101.d("enter_from", r110);
        r101.d("author_openid", r214);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r111);
        r101.d("to_group_id", r112);
        r101.d("impr_id", r210);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r100 ? 1 : 0));
        r101.d("author_openid", r214);
        r101.d("previous_page", r212);
        r101.d("group_source", r213);
        r101.d("performance_fps", Double.valueOf(r215));
        r101.f198612d = r216;
        r101.b(r211, r113.f548582a).b();
        return;
    L5:
        r101 = com.bytedance.awemeopen.infra.base.event.b.a("homepage_hot_slide_down");
        goto L6
    }

    @Override // t24.a
    public final void f1(String r210, String r211, String r212, String r213, int r214, String r215, String r310, int r311, String r312, boolean r313, JSONObject r314) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r215, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r310, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter(r312, "sourcePage");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter("", "pageName");
        Intrinsics.checkNotNullParameter("", "newSourceType");
        Intrinsics.checkNotNullParameter("", "recommendInfo");
        u34.a.g(x3(), com.bytedance.android.ec.core.event.a.KEY_SHOW_PRODUCT, r210, r211, r212, r213, r214, r215, "", r310, r311, null, null, "", "", r312, null, this.f198100e, "", r313, null, r314, 1048576);
    }

    @Override // t24.a
    public final void q1(String r110, String r111, String r112, String r113, String r114, String r115, boolean r210, String r211, String r212, boolean r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "groupSource");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "fromGroupId");
        u34.a r116 = x3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "groupSource");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("landscape_mode_entrance_show");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r115);
        r100.d("impr_id", r114);
        r100.d("is_auto_draw", Integer.valueOf(r210 ? 1 : 0));
        r100.d("host_enter_from", r211);
        r100.d("anchor_name", r212);
        r100.d("is_card_sdk", Integer.valueOf(r213 ? 1 : 0));
        r100.d("product_id", r214);
        r100.d("group_source", r113);
        r100.c(null, r116.f548582a).b();
    }

    @Override // t24.a
    public final void u1(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, int r218, JSONObject r219) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "followStatus");
        Intrinsics.checkNotNullParameter(r214, "productId");
        Intrinsics.checkNotNullParameter("product_card", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r216, "requestId");
        Intrinsics.checkNotNullParameter(r217, "recommendInfo");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "followStatus");
        Intrinsics.checkNotNullParameter(r214, "productId");
        Intrinsics.checkNotNullParameter("product_card", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r216, "requestId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("product_entrance_click");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.d("enter_from", r110);
        r101.d("author_id", r210);
        r101.d("author_openid", r210);
        r101.d("aweme_type", Integer.valueOf(r218));
        r101.d("group_id", r211);
        r101.d("host_group_id", r212);
        r101.d("follow_status", r213);
        r101.d("product_id", r214);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "product_card");
        if (r215 != null) goto L5;
    L10:
        r101.d("request_id", r216);
        r101.f198612d = r219;
        r101.c(null, r100.f548582a).b();
        return;
    L5:
        if ((!StringsKt.isBlank(r215)) == false) goto L7;
        String r102 = r215;
    L8:
        if (r102 == null) goto L10;
        r101.d("host_enter_from", r102);
        goto L10
    L7:
        r102 = null;
        goto L8
    }

    @Override // t24.a
    public final void y0(String r110, String r111, String r112, String r113, String r210, String r211, boolean r212, int r213, boolean r214, String r215, d r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        Intrinsics.checkNotNullParameter(r215, "slideMode");
        u34.a r114 = x3();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        Intrinsics.checkNotNullParameter(r215, "slideMode");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("autoslide_status");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d("host_group_id", r113);
        r100.d("impr_id", r210);
        r100.d("log_pb", r211);
        r100.d("is_auto_slide_on", Integer.valueOf(r212 ? 1 : 0));
        r100.d("is_auto_slide", Integer.valueOf(r214 ? 1 : 0));
        r100.d("no_action_cnt", Integer.valueOf(r213));
        r100.d("slide_mode", r215);
        r100.b(r216, r114.f548582a).b();
    }

    @Override // t24.a
    public final void I2(String r110, String r111, String r112, String r210, String r211, String r212, boolean r213, long r214, int r215, String r216, int r217, d r218) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "hostGroupId");
        Intrinsics.checkNotNullParameter(r211, "imprId");
        Intrinsics.checkNotNullParameter(r212, "logPb");
        Intrinsics.checkNotNullParameter(r216, "groupIdFIrst");
        u34.a r113 = x3();
        boolean r100 = this.f198100e;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r210, "hostGroupId");
        Intrinsics.checkNotNullParameter(r211, "imprId");
        Intrinsics.checkNotNullParameter(r212, "logPb");
        Intrinsics.checkNotNullParameter(r216, "groupIdFIrst");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("stay_page_link");
        r101.d("enter_from", r110);
        r101.d("author_openid", r111);
        r101.d("group_id", r112);
        r101.d("host_group_id", r210);
        r101.d("impr_id", r211);
        r101.d("log_pb", r212);
        r101.d("is_following", Integer.valueOf(r213 ? 1 : 0));
        r101.d("stay_time_all", Long.valueOf(r214));
        r101.d("link_cnt", Integer.valueOf(r215));
        r101.d("group_id_first", r216);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r100 ? 1 : 0));
        r101.d("auto_link_cnt", Integer.valueOf(r217));
        r101.b(r218, r113.f548582a).b();
    }

    @Override // t24.a
    public final void L2(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, String r312, JSONObject r313) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r217, "bar_name");
        Intrinsics.checkNotNullParameter("topic", ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE);
        Intrinsics.checkNotNullParameter(r310, "topic_id");
        Intrinsics.checkNotNullParameter(r311, "topic_name");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r217, "bar_name");
        Intrinsics.checkNotNullParameter("topic", ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE);
        Intrinsics.checkNotNullParameter(r310, "topic_id");
        Intrinsics.checkNotNullParameter(r311, "topic_name");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("bottom_bar_click");
        r101.d("enter_from", r210);
        r101.d("author_openid", r211);
        r101.d("group_id", r212);
        r101.d("impr_id", r213);
        r101.d("log_pb", r214);
        r101.d("group_source", r215);
        r101.d("previous_page", r216);
        r101.d("bar_name", r217);
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE, "topic");
        r101.d("topic_id", r310);
        r101.d("topic_name", r311);
        r101.f198611c = r312;
        r101.f198612d = r313;
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void R(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, String r312, JSONObject r313) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r217, "bar_name");
        Intrinsics.checkNotNullParameter("topic", ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE);
        Intrinsics.checkNotNullParameter(r310, "topic_id");
        Intrinsics.checkNotNullParameter(r311, "topic_name");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r217, "bar_name");
        Intrinsics.checkNotNullParameter("topic", ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE);
        Intrinsics.checkNotNullParameter(r310, "topic_id");
        Intrinsics.checkNotNullParameter(r311, "topic_name");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("bottom_bar_show");
        r101.d("enter_from", r210);
        r101.d("author_openid", r211);
        r101.d("group_id", r212);
        r101.d("impr_id", r213);
        r101.d("log_pb", r214);
        r101.d("group_source", r215);
        r101.d("previous_page", r216);
        r101.d("bar_name", r217);
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE, "topic");
        r101.d("topic_id", r310);
        r101.d("topic_name", r311);
        r101.f198611c = r312;
        r101.f198612d = r313;
        r101.c(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void U1(String r210, String r211, String r212, String r213, int r214, String r310, String r311, int r312, String r313, boolean r314, d r315, JSONObject r316) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r311, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter(r313, "enterFrom");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        int r215 = u34.a.f548581b;
        r100.getClass();
        Intrinsics.checkNotNullParameter("commondity_change_show", "productName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r311, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("commondity_change_show");
        r101.d("enter_from", r313);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.d("author_openid", r211);
        r101.d("request_id", r210);
        r101.d("follow_status", Integer.valueOf(r214));
        r101.d("product_id", r310);
        r101.d("log_extra", "");
        r101.d("cid", "");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r311);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, Integer.valueOf(r312));
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "video");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "video_cart_tag");
        r101.d("page_name", null);
        r101.d("source_page", null);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, null);
        r101.d("group_id", r212);
        r101.d("host_group_id", r213);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r314 ? 1 : 0));
        r101.d("impr_id", r210);
        r101.f198612d = r316;
        r101.b(r315, r100.f548582a).b();
    }

    @Override // t24.a
    public final void c0(String r110, String r111, String r112, String r113, String r114, String r210, String r211, boolean r212, boolean r213, String r214, Integer r215, d r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        u34.a r115 = x3();
        if (r215 == null) goto L5;
        int r116 = r215.intValue();
    L6:
        r115.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r210, "imprId");
        Intrinsics.checkNotNullParameter(r211, "logPb");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("go_detail");
        r100.d("enter_from", r110);
        r100.d("author_openid", r112);
        r100.d("group_id", r113);
        r100.d("host_group_id", r114);
        r100.d("impr_id", r210);
        r100.d("log_pb", r211);
        r100.d("is_following", Integer.valueOf(r212 ? 1 : 0));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r213 ? 1 : 0));
        if (r111 != null) goto L9;
    L14:
        r100.d("anchor_name", r214);
        r100.d("aweme_type", Integer.valueOf(r116));
        r100.b(r216, r115.f548582a).b();
        return;
    L9:
        if ((!StringsKt.isBlank(r111)) == false) goto L11;
        String r101 = r111;
    L12:
        if (r101 == null) goto L14;
        r100.d("host_enter_from", r101);
        goto L14
    L11:
        r101 = null;
        goto L12
    L5:
        r116 = -1;
        goto L6
    }

    @Override // t24.a
    public final void l1(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, int r310, boolean r311, JSONObject r312) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "followStatus");
        Intrinsics.checkNotNullParameter(r215, "productId");
        Intrinsics.checkNotNullParameter("product_card", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r217, "requestId");
        Intrinsics.checkNotNullParameter(r218, "recommendInfo");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "followStatus");
        Intrinsics.checkNotNullParameter(r215, "productId");
        Intrinsics.checkNotNullParameter("product_card", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r217, "requestId");
        Intrinsics.checkNotNullParameter(r218, "recommendInfo");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("product_entrance_show");
        r110.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r110.d("enter_from", r210);
        r110.d("author_id", r211);
        r110.d("author_openid", r211);
        r110.d("aweme_type", Integer.valueOf(r310));
        r110.d("group_id", r212);
        r110.d("host_group_id", r213);
        r110.d("follow_status", r214);
        r110.d("product_id", r215);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "product_card");
        r110.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "product_card");
        if (r216 != null) goto L5;
    L10:
        r110.d("request_id", r217);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r218);
        if (r311 == false) goto L13;
        String r101 = "1";
    L14:
        r110.d("is_card_sdk", r101);
        r110.f198612d = r312;
        r110.c(null, r100.f548582a).b();
        return;
    L13:
        r101 = "0";
        goto L14
    L5:
        if ((!StringsKt.isBlank(r216)) == false) goto L7;
        String r102 = r216;
    L8:
        if (r102 == null) goto L10;
        r110.d("host_enter_from", r102);
        goto L10
    L7:
        r102 = null;
        goto L8
    }

    @Override // t24.a
    public final void A1(String r210, String r211, String r212, String r213, int r310, String r311, String r312, int r313, String r314, boolean r315, boolean r316, d r317, JSONObject r318) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r311, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r312, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter(r314, "sourcePage");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter("", "pageName");
        Intrinsics.checkNotNullParameter("", "newSourceType");
        Intrinsics.checkNotNullParameter("button", "clickArea");
        Intrinsics.checkNotNullParameter("", "recommendInfo");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        int r110 = u34.a.f548581b;
        r100.f(com.bytedance.android.ec.core.event.a.KEY_CLICK_PRODUCT, r210, r211, r212, r213, r310, r311, "", r312, r313, null, null, r314, "button", "", "", null, r101, "", r315, r316, r317, r318);
    }

    @Override // t24.a
    public final void B2(String r110, String r111, String r112, String r113, String r114, String r115, boolean r210, String r211, String r212, boolean r213, String r214, float r215, float r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "groupSource");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "fromGroupId");
        u34.a r116 = x3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "groupSource");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "fromGroupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("click_landscape_mode_entrance");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r115);
        r100.d("impr_id", r114);
        r100.d("is_auto_draw", Integer.valueOf(r210 ? 1 : 0));
        r100.d("host_enter_from", r211);
        r100.d("anchor_name", r212);
        r100.d("is_card_sdk", Integer.valueOf(r213 ? 1 : 0));
        r100.d("product_id", r214);
        r100.d("group_source", r113);
        r100.d("click_time", Float.valueOf(r215));
        r100.d("group_source", Float.valueOf(r216));
        r100.c(null, r116.f548582a).b();
    }

    @Override // t24.a
    public final void T1(String r210, String r211, String r212, String r213, int r214, String r310, String r311, int r312, String r313, boolean r314, boolean r315, boolean r316, JSONObject r317) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r311, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter(r313, "enterFrom");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter("commondity_change_action", "productName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r311, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("commondity_change_action");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.d("author_openid", r211);
        r101.d("request_id", r210);
        r101.d("follow_status", Integer.valueOf(r214));
        r101.d("product_id", r310);
        r101.d("log_extra", "");
        r101.d("cid", "");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r311);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, Integer.valueOf(r312));
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "video");
        r101.d("enter_from", r313);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "video_cart_tag");
        r101.d("source_page", null);
        r101.d("page_name", null);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, null);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, null);
        r101.d("group_id", r212);
        r101.d("host_group_id", r213);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r314 ? 1 : 0));
        r101.d(FeedApi.IS_DRAW_KEY, Integer.valueOf(r315 ? 1 : 0));
        r101.d("is_click", Integer.valueOf(r316 ? 1 : 0));
        r101.d("impr_id", r210);
        r101.f198612d = r317;
        r101.b(null, r100.f548582a).b();
    }

    @Override // t24.a
    public final void X1(String r110, String r111, String r112, String r113, String r114, String r115, String r210, boolean r211, long r212, long r213, boolean r214, Integer r215, d r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r115, "imprId");
        Intrinsics.checkNotNullParameter(r210, "logPb");
        u34.a r116 = x3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r114, "hostGroupId");
        Intrinsics.checkNotNullParameter(r115, "imprId");
        Intrinsics.checkNotNullParameter(r210, "logPb");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("stay_page");
        r100.d("enter_from", r110);
        r100.d("author_openid", r112);
        r100.d("group_id", r113);
        r100.d("host_group_id", r114);
        r100.d("impr_id", r115);
        r100.d("log_pb", r210);
        r100.d("is_following", Integer.valueOf(r211 ? 1 : 0));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r214 ? 1 : 0));
        r100.d("stay_time", Long.valueOf(r212));
        r100.d("stay_comment_time", Long.valueOf(r213));
        r100.d("group_source", r215);
        if (r111 != null) goto L5;
    L10:
        r100.b(r216, r116.f548582a).b();
        return;
    L5:
        if ((!StringsKt.isBlank(r111)) == false) goto L7;
        String r101 = r111;
    L8:
        if (r101 == null) goto L10;
        r100.d("host_enter_from", r101);
        goto L10
    L7:
        r101 = null;
        goto L8
    }

    @Override // t24.a
    public final void a3(String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, String r217, d r218, String r219, String r310, String r311, Integer r312) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r217, "followType");
        Intrinsics.checkNotNullParameter(r219, "previousPage");
        Intrinsics.checkNotNullParameter(r310, "groupSource");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        if (r312 == null) goto L5;
        int r110 = r312.intValue();
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r217, "followType");
        Intrinsics.checkNotNullParameter(r219, "previousPage");
        Intrinsics.checkNotNullParameter(r310, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r111 = com.bytedance.awemeopen.infra.base.event.b.a("show_follow");
        r111.d("enter_from", r210);
        r111.d("group_id", r212);
        r111.d("host_group_id", r213);
        r111.d("impr_id", r214);
        r111.d("log_pb", r215);
        r111.d("is_following", Integer.valueOf(r216 ? 1 : 0));
        r111.d("follow_type", r217);
        r111.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r111.d("author_openid", r211);
        r111.d("group_source", r310);
        r111.d("previous_page", r219);
        r111.d("aweme_type", Integer.valueOf(r110));
        r111.f198611c = r311;
        r111.b(r218, r100.f548582a).b();
        return;
    L5:
        r110 = -1;
        goto L6
    }

    @Override // t24.a
    public final void k0(String r110, String r111, String r112, String r113, String r114, String r115, boolean r210, boolean r211, boolean r212, String r213, String r214, d r215, JSONObject r216) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "logPb");
        u34.a r116 = x3();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "hostGroupId");
        Intrinsics.checkNotNullParameter(r114, "imprId");
        Intrinsics.checkNotNullParameter(r115, "logPb");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("click_share");
        r100.d("enter_from", r110);
        r100.d("author_openid", r111);
        r100.d("group_id", r112);
        r100.d("host_group_id", r113);
        r100.d("impr_id", r114);
        r100.d("log_pb", r115);
        r100.d("is_following", Integer.valueOf(r210 ? 1 : 0));
        r100.d("is_card_sdk", Integer.valueOf(r211 ? 1 : 0));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r212 ? 1 : 0));
        r100.d("previous_page", r213);
        r100.d("pic_cnt", r214);
        r100.f198612d = r216;
        r100.b(r215, r116.f548582a).b();
    }

    @Override // t24.a
    public final void t(String r100, boolean r101, boolean r102, boolean r103, int r110, long r111, long r112, long r113, long r114, long r115, long r210, boolean r211, int r212) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        u34.a r104 = x3();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "groupId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r105 = com.bytedance.awemeopen.infra.base.event.b.a("multi_photo_load");
        r105.d("is_first_photo", Integer.valueOf(r101 ? 1 : 0));
        r105.d("group_id", r100);
        if (r101 == false) goto L6;
        if (r211 == true) goto L6;
        r105.d("first_photo_cost", Long.valueOf(r210 - r112));
        r105.d("open_photo_cost", Long.valueOf(r112 - r111));
        r105.d("network_api_cost", Long.valueOf(r114 - r113));
        r105.d("user_interface_cost", Long.valueOf(r113 - r112));
        r105.d("item_ui_cost", Long.valueOf(r115 - r114));
        r105.d("click_photo_timestamp", Long.valueOf(r111));
        r105.d("open_photo_timestamp", Long.valueOf(r112));
        r105.d("start_network_timestamp", Long.valueOf(r113));
        r105.d("network_finish_timestamp", Long.valueOf(r114));
    L6:
        r105.d("photo_load_cost", Long.valueOf(r210 - r115));
        r105.d("start_load_photo_timestamp", Long.valueOf(r115));
        r105.d("load_photo_finish_timestamp", Long.valueOf(r210));
        r105.d("error_code", Integer.valueOf(r110));
        r105.d("hitAwemeCache", Integer.valueOf(r102 ? 1 : 0));
        r105.d("hitPhotoCache", Integer.valueOf(r103 ? 1 : 0));
        r105.d("image_origin", Integer.valueOf(r212));
        r105.c(null, r104.f548582a).b();
    }

    @Override // t24.a
    public final void x(String r110, String r210, String r211, String r212, String r213, String r214, boolean r215, String r216, String r217, String r218, float r219, long r310, d r311) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r216, "enterMethod");
        Intrinsics.checkNotNullParameter(r217, "speedMethod");
        Intrinsics.checkNotNullParameter(r218, "speedPosition");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r216, "enterMethod");
        Intrinsics.checkNotNullParameter(r217, "speedMethod");
        Intrinsics.checkNotNullParameter(r218, "speedPosition");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r111 = com.bytedance.awemeopen.infra.base.event.b.a("speed_mode_play_time");
        r111.d("enter_from", r110);
        r111.d("author_openid", r210);
        r111.d("group_id", r211);
        r111.d("host_group_id", r212);
        r111.d("impr_id", r213);
        r111.d("log_pb", r214);
        r111.d("is_following", Integer.valueOf(r215 ? 1 : 0));
        r111.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r111.d("enter_method", r216);
        r111.d("speed_method", r217);
        r111.d("speed_position", r218);
        r111.d("to_status", Float.valueOf(r219));
        r111.d("duration", Long.valueOf(r310));
        r111.b(r311, r100.f548582a).b();
    }

    @Override // t24.a
    public final void x1(String r110, String r210, String r211, String r212, String r213, String r214, boolean r215, String r216, String r217, String r218, float r219, boolean r310, e r311) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r216, "enterMethod");
        Intrinsics.checkNotNullParameter(r217, "speedMethod");
        Intrinsics.checkNotNullParameter(r218, "speedPosition");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r216, "enterMethod");
        Intrinsics.checkNotNullParameter(r217, "speedMethod");
        Intrinsics.checkNotNullParameter(r218, "speedPosition");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r111 = com.bytedance.awemeopen.infra.base.event.b.a("change_speed_mode");
        r111.d("enter_from", r110);
        r111.d("author_openid", r210);
        r111.d("group_id", r211);
        r111.d("host_group_id", r212);
        r111.d("impr_id", r213);
        r111.d("log_pb", r214);
        r111.d("is_following", Integer.valueOf(r215 ? 1 : 0));
        r111.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r111.d("enter_method", r216);
        r111.d("speed_method", r217);
        r111.d("speed_position", r218);
        r111.d("to_status", Float.valueOf(r219));
        r111.d("pinch_zoom", Boolean.valueOf(r310));
        r111.b(r311, r100.f548582a).b();
    }

    @Override // t24.a
    public final void D2(String r210, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, d r319, JSONObject r410, String r411, String r412) {
        Intrinsics.checkNotNullParameter(r210, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r310, "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r311, "aoEnterFromMerge");
        Intrinsics.checkNotNullParameter(r312, "aoEnterMethod");
        Intrinsics.checkNotNullParameter(r313, "aoActionType");
        Intrinsics.checkNotNullParameter(r314, "anchorId");
        Intrinsics.checkNotNullParameter(r315, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r316, "requestId");
        Intrinsics.checkNotNullParameter(r317, "anchorAid");
        Intrinsics.checkNotNullParameter(r318, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        Intrinsics.checkNotNullParameter(r411, "itemId");
        Intrinsics.checkNotNullParameter(r412, "enterRequestId");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r310, "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r311, "aoEnterFromMerge");
        Intrinsics.checkNotNullParameter(r312, "aoEnterMethod");
        Intrinsics.checkNotNullParameter(r313, "aoActionType");
        Intrinsics.checkNotNullParameter(r314, "anchorId");
        Intrinsics.checkNotNullParameter(r315, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r316, "requestId");
        Intrinsics.checkNotNullParameter(r317, "anchorAid");
        Intrinsics.checkNotNullParameter(r318, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        Intrinsics.checkNotNullParameter(r411, "itemId");
        Intrinsics.checkNotNullParameter(r412, "enterRequestId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("tobsdk_livesdk_live_show");
        r101.d("enter_from_merge", r210);
        r101.d("enter_method", r310);
        r101.d("action_type", "click");
        r101.d("ao_enter_from_merge", r311);
        r101.d("ao_enter_method", r312);
        r101.d("ao_action_type", r313);
        r101.d("anchor_id", r314);
        r101.d("room_id", r315);
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID, "");
        r101.d("request_id", r316);
        r101.d("content_list_req_id", r412);
        r101.d("video_sdk_item_id", r411);
        boolean r102 = true;
        if (r317.length() <= 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L12;
        if (Intrinsics.areEqual(r317, "0") == true) goto L12;
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, r317);
    L12:
        if (r318.length() > 0) goto L15;
        r102 = false;
    L15:
        if (r102 == true) goto L17;
    L19:
        r101.d("video_source", "sdk_video");
        r101.f198612d = r410;
        r101.b(r319, r100.f548582a).b();
        return;
    L17:
        if (Intrinsics.areEqual(r318, "0") == true) goto L19;
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, r318);
        goto L19
    L5:
        r103 = false;
        goto L7
    }

    @Override // t24.a
    public final void r(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, int r311, int r312, String r313, JSONObject r314) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r217, com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);
        Intrinsics.checkNotNullParameter(r218, "component_type");
        Intrinsics.checkNotNullParameter(r310, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r217, com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);
        Intrinsics.checkNotNullParameter(r218, "component_type");
        Intrinsics.checkNotNullParameter(r310, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("guide_component_show");
        r101.d("enter_from", r210);
        r101.d("author_openid", r211);
        r101.d("group_id", r212);
        r101.d("impr_id", r213);
        r101.d("log_pb", r214);
        r101.d("group_source", r215);
        r101.d("previous_page", r216);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r217);
        r101.d("component_type", r218);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r310);
        if (r311 != 0) goto L5;
        String r102 = "low";
    L12:
        r101.d("component_show_type", r102);
        r101.d("rank", Integer.valueOf(r312));
        r101.f198611c = r313;
        r101.f198612d = r314;
        r101.c(null, r100.f548582a).b();
        return;
    L5:
        if (r311 != 1) goto L7;
        r102 = "high1";
        goto L12
    L7:
        if (r311 == 2) goto L9;
        r102 = "";
        goto L12
    L9:
        r102 = "high2";
        goto L12
    }

    @Override // t24.a
    public final void M0(String r210, String r211, String r212, long r213, String r214, String r215, String r310, boolean r311, boolean r312, String r313, String r314, String r315, String r316, String r317, String r318) {
        String r100 = r318;
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "fromGroupId");
        Intrinsics.checkNotNullParameter(r310, "logPb");
        Intrinsics.checkNotNullParameter("", "position");
        Intrinsics.checkNotNullParameter("", "poiId");
        Intrinsics.checkNotNullParameter(r313, "authorOpenId");
        Intrinsics.checkNotNullParameter(r314, "previousPage");
        Intrinsics.checkNotNullParameter(r315, "groupSource");
        Intrinsics.checkNotNullParameter(r100, "groupDuration");
        u34.a r101 = x3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "fromGroupId");
        Intrinsics.checkNotNullParameter(r310, "logPb");
        Intrinsics.checkNotNullParameter("", "position");
        Intrinsics.checkNotNullParameter("", "poiId");
        Intrinsics.checkNotNullParameter(r313, "authorOpenId");
        Intrinsics.checkNotNullParameter(r314, "previousPage");
        Intrinsics.checkNotNullParameter(r315, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("post_play_time");
        r110.d("enter_from", r210);
        r110.d("group_id", r211);
        r110.d("host_group_id", r212);
        r110.d("duration", Long.valueOf(r213));
        r110.d("impr_id", r214);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r215);
        r110.d("log_pb", r310);
        r110.d("is_following", Integer.valueOf(r311 ? 1 : 0));
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, 0);
        r110.d("is_auto_draw", Integer.valueOf(r312 ? 1 : 0));
        r110.d("poi_id", "");
        r110.d("has_anchor", 0);
        r110.d("author_openid", r313);
        r110.d("previous_page", r314);
        r110.d("group_source", r315);
        if (r316 != null) goto L5;
        String r102 = "";
    L6:
        r110.d("over_type", r102);
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        r110.d("group_duration", r100);
        r110.f198611c = r317;
        r110.b(null, r101.f548582a).b();
        return;
    L5:
        r102 = r316;
        goto L6
    }

    @Override // t24.a
    public final void Q2(String r110, String r210, String r211, String r212, String r213, String r214, boolean r215, boolean r216, e r217, String r218, String r219, String r310, boolean r311, String r312, JSONObject r313) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r219, "groupSource");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        boolean r102 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "authorOpenId");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r219, "groupSource");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r111 = com.bytedance.awemeopen.infra.base.event.b.a("click_comment_button");
        r111.d("enter_from", r110);
        r111.d("author_openid", r210);
        r111.d("group_id", r211);
        r111.d("host_group_id", r212);
        r111.d("impr_id", r213);
        r111.d("log_pb", r214);
        r111.d("is_following", Integer.valueOf(r215 ? 1 : 0));
        r111.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r111.d("is_card_sdk", Integer.valueOf(r216 ? 1 : 0));
        String r103 = "1";
        if (r102 == false) goto L5;
        Object r104 = "1";
    L6:
        r111.d("is_landscape_mode", r104);
        r111.d("group_source", r219);
        r111.d("previous_page", r310);
        if (r311 == true) goto L10;
        r103 = "0";
    L10:
        r111.d("is_livehead", r103);
        Object r105 = null;
        if (r312 == null) goto L19;
        if ((!StringsKt.isBlank(r312)) == false) goto L15;
        String r106 = r312;
    L16:
        if (r106 == null) goto L19;
        r111.d("host_enter_from", r106);
        goto L19
    L15:
        r106 = null;
    L19:
        if ((!StringsKt.isBlank("")) == false) goto L21;
        r105 = "";
    L21:
        if (r105 == null) goto L23;
        r111.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r105);
    L23:
        r111.f198611c = r218;
        r111.f198612d = r313;
        r111.b(r217, r100.f548582a).b();
        return;
    L5:
        r104 = "0";
        goto L6
    }

    @Override // t24.a
    public final void y2(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r310, String r311, String r312, int r313, int r314, String r315, String r316, JSONObject r317) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r310, com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);
        Intrinsics.checkNotNullParameter(r311, "component_type");
        Intrinsics.checkNotNullParameter(r312, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
        Intrinsics.checkNotNullParameter(r315, com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA);
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter(r215, "group_source");
        Intrinsics.checkNotNullParameter(r216, "previous_page");
        Intrinsics.checkNotNullParameter(r310, com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);
        Intrinsics.checkNotNullParameter(r311, "component_type");
        Intrinsics.checkNotNullParameter(r312, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
        Intrinsics.checkNotNullParameter(r315, com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA);
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("guide_component_click");
        r101.d("enter_from", r210);
        r101.d("author_openid", r211);
        r101.d("group_id", r212);
        r101.d("impr_id", r213);
        r101.d("log_pb", r214);
        r101.d("group_source", r215);
        r101.d("previous_page", r216);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r310);
        r101.d("component_type", r311);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r312);
        if (r313 != 0) goto L5;
        String r102 = "low";
    L12:
        r101.d("component_show_type", r102);
        r101.d("rank", Integer.valueOf(r314));
        r101.d(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r315);
        r101.f198611c = r316;
        r101.f198612d = r317;
        r101.c(null, r100.f548582a).b();
        return;
    L5:
        if (r313 != 1) goto L7;
        r102 = "high1";
        goto L12
    L7:
        if (r313 == 2) goto L9;
        r102 = "";
        goto L12
    L9:
        r102 = "high2";
        goto L12
    }

    @Override // t24.a
    public final void R1(String r210, String r211, String r212, String r213, int r214, String r310, String r311, String r312, int r313, String r314, String r315, int r316, String r317, boolean r318, boolean r319, JSONObject r410) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter(r311, "imprId");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r312, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter(r314, "enterFrom");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r317, "recommendInfo");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.f("product_entrance_click", r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, null, null, null, null, Integer.valueOf(r316), r101, r317, r318, r319, null, r410);
    }

    @Override // t24.a
    public final void W1(String r210, String r211, String r212, String r213, int r214, String r215, String r310, String r311, int r312, String r313, String r314, int r315, String r316, boolean r317, d r318, JSONObject r319) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r215, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter(r310, "imprId");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r311, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter(r313, "enterFrom");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r316, "recommendInfo");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        u34.a.g(r100, "product_entrance_show", r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, null, null, null, Integer.valueOf(r315), r101, r316, r317, r318, r319, 524288);
    }

    @Override // t24.a
    public final void Z1(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r310, boolean r311, boolean r312, String r313, String r314, String r315, double r316, int r317, e r318) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "enterMethod");
        Intrinsics.checkNotNullParameter(r215, "slideDirection");
        Intrinsics.checkNotNullParameter(r216, "imprId");
        Intrinsics.checkNotNullParameter(r310, "logPb");
        Intrinsics.checkNotNullParameter(r313, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r314, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r315, "previousPage");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "enterMethod");
        Intrinsics.checkNotNullParameter(r215, "slideDirection");
        Intrinsics.checkNotNullParameter(r216, "imprId");
        Intrinsics.checkNotNullParameter(r310, "logPb");
        Intrinsics.checkNotNullParameter(r313, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r314, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r315, "previousPage");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("multi_photo_slide");
        r110.d("enter_from", r210);
        r110.d("author_openid", r211);
        r110.d("group_id", r212);
        r110.d("host_group_id", r213);
        r110.d("enter_method", r214);
        r110.d("slide_direction", r215);
        r110.d("impr_id", r216);
        r110.d("log_pb", r310);
        r110.d("is_following", Integer.valueOf(r311 ? 1 : 0));
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r312 ? 1 : 0));
        r110.d("photo_serial_num", r313);
        r110.d("all_photo_num", r314);
        r110.d("previous_page", r315);
        r110.d("pinch_zoom", Integer.valueOf(r317));
        r110.d("performance_fps", Double.valueOf(r316));
        r110.b(r318, r100.f548582a).b();
    }

    @Override // t24.a
    public final void e2(String r110, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216, d r217, String r218, String r219, String r310, String r311, JSONObject r312, boolean r313, String r314) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r219, "authorOpenId");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        Intrinsics.checkNotNullParameter(r311, "groupSource");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        boolean r102 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r219, "authorOpenId");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        Intrinsics.checkNotNullParameter(r311, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r111 = com.bytedance.awemeopen.infra.base.event.b.a("like_cancel");
        r111.d("enter_from", r110);
        r111.d("previous_page", r310);
        r111.d("group_source", r311);
        r111.d("author_openid", r219);
        r111.d("group_id", r210);
        r111.d("host_group_id", r211);
        r111.d("impr_id", r212);
        r111.d("log_pb", r213);
        r111.d("is_auto_draw", Integer.valueOf(r215 ? 1 : 0));
        r111.d("is_following", Integer.valueOf(r214 ? 1 : 0));
        r111.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r111.d("is_card_sdk", Integer.valueOf(r216 ? 1 : 0));
        String r103 = "1";
        if (r102 == false) goto L5;
        Object r104 = "1";
    L6:
        r111.d("is_landscape_mode", r104);
        if (r313 == true) goto L10;
        r103 = "0";
    L10:
        r111.d("is_livehead", r103);
        r111.f198611c = r218;
        r111.f198612d = r312;
        if (r314 != null) goto L13;
    L18:
        r111.b(r217, r100.f548582a).b();
        return;
    L13:
        if ((!StringsKt.isBlank(r314)) == false) goto L15;
        String r105 = r314;
    L16:
        if (r105 == null) goto L18;
        r111.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r105);
        goto L18
    L15:
        r105 = null;
        goto L16
    L5:
        r104 = "0";
        goto L6
    }

    @Override // t24.a
    public final void Y1(String r110, String r210, String r211, String r212, String r213, boolean r214, String r215, boolean r216, boolean r217, d r218, String r219, String r310, String r311, String r312, String r313, JSONObject r314, boolean r315) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r215, "followType");
        Intrinsics.checkNotNullParameter(r219, "authorOpenId");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        Intrinsics.checkNotNullParameter(r311, "groupSource");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r215, "followType");
        Intrinsics.checkNotNullParameter(r219, "authorOpenId");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        Intrinsics.checkNotNullParameter(r311, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r102 = com.bytedance.awemeopen.infra.base.event.b.a("follow_cancel");
        r102.d("enter_from", r110);
        r102.d("group_id", r210);
        r102.d("host_group_id", r211);
        r102.d("impr_id", r212);
        r102.d("log_pb", r213);
        r102.d("is_following", Integer.valueOf(r214 ? 1 : 0));
        r102.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r102.d("author_openid", r219);
        r102.d("group_source", r311);
        r102.d("is_auto_draw", Integer.valueOf(r216 ? 1 : 0));
        r102.d("is_card_sdk", Integer.valueOf(r217 ? 1 : 0));
        r102.d("previous_page", r310);
        if (r315 == false) goto L5;
        String r103 = "1";
    L6:
        r102.d("is_livehead", r103);
        if (r313 != null) goto L9;
    L14:
        r102.f198611c = r312;
        r102.f198612d = r314;
        r102.b(r218, r100.f548582a).b();
        return;
    L9:
        if ((!StringsKt.isBlank(r313)) == false) goto L11;
        String r104 = r313;
    L12:
        if (r104 == null) goto L14;
        r102.d("host_enter_from", r104);
        goto L14
    L11:
        r104 = null;
        goto L12
    L5:
        r103 = "0";
        goto L6
    }

    @Override // t24.a
    public final void w3(String r110, String r111, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216, d r217, float r218, float r219, String r310, String r311, String r312, String r313, JSONObject r314) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r310, "groupSource");
        Intrinsics.checkNotNullParameter(r311, "previousPage");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r310, "groupSource");
        Intrinsics.checkNotNullParameter(r311, "previousPage");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a("click_trans_layer");
        r112.d("enter_from", r110);
        r112.d("author_openid", r111);
        r112.d("group_id", r210);
        r112.d("host_group_id", r211);
        r112.d("impr_id", r212);
        r112.d("log_pb", r213);
        r112.d("is_following", Integer.valueOf(r214 ? 1 : 0));
        r112.d("is_card_sdk", Integer.valueOf(r215 ? 1 : 0));
        if (r216 == false) goto L5;
        String r102 = "1";
    L6:
        r112.d("is_livehead", r102);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r112.d("previous_page", r311);
        r112.d("long_press_x", Float.valueOf(r218));
        r112.d("long_press_y", Float.valueOf(r219));
        r112.d("group_source", r310);
        r112.d("previous_page", r311);
        if (r313 != null) goto L9;
    L14:
        r112.f198611c = r312;
        r112.f198612d = r314;
        r112.b(r217, r100.f548582a).b();
        return;
    L9:
        if ((!StringsKt.isBlank(r313)) == false) goto L11;
        String r103 = r313;
    L12:
        if (r103 == null) goto L14;
        r112.d("host_enter_from", r103);
        goto L14
    L11:
        r103 = null;
        goto L12
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void C(String r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r310, boolean r311, boolean r312, d r313, String r314, String r315, String r316, String r317, boolean r318, String r319, JSONObject r410) {
        Intrinsics.checkNotNullParameter(r210, "event");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r216, "position");
        Intrinsics.checkNotNullParameter(r315, "authorOpenId");
        Intrinsics.checkNotNullParameter(r316, "previousPage");
        Intrinsics.checkNotNullParameter(r317, "groupSource");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        boolean r111 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "event");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r216, "position");
        Intrinsics.checkNotNullParameter(r315, "authorOpenId");
        Intrinsics.checkNotNullParameter(r316, "previousPage");
        Intrinsics.checkNotNullParameter(r317, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a(r210);
        r101.d("enter_from", r211);
        r101.d("author_openid", r315);
        r101.d("previous_page", r316);
        r101.d("group_source", r317);
        r101.d("group_id", r212);
        r101.d("host_group_id", r213);
        r101.d("impr_id", r214);
        r101.d("log_pb", r215);
        r101.d("is_following", Integer.valueOf(r310 ? 1 : 0));
        r101.d("position", r216);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r101.f198611c = r314;
        r101.d("is_auto_draw", Integer.valueOf(r311 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r312 ? 1 : 0));
        String r102 = "1";
        if (r111 == false) goto L5;
        Object r103 = "1";
    L6:
        r101.d("is_landscape_mode", r103);
        if (r318 == true) goto L10;
        r102 = "0";
    L10:
        r101.d("is_livehead", r102);
        if (r319 != null) goto L13;
    L18:
        r101.f198612d = r410;
        r101.b(r313, r100.f548582a).b();
        return;
    L13:
        if ((!StringsKt.isBlank(r319)) == false) goto L15;
        String r104 = r319;
    L16:
        if (r104 == null) goto L18;
        r101.d("host_enter_from", r104);
        goto L18
    L15:
        r104 = null;
        goto L16
    L5:
        r103 = "0";
        goto L6
    }

    @Override // t24.a
    public final void K0(String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, String r310, boolean r311, boolean r312, String r313, boolean r314, d r315, String r316, String r317, String r318, String r319, String r410) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "fromGroupId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r310, "position");
        Intrinsics.checkNotNullParameter(r313, "poiId");
        Intrinsics.checkNotNullParameter(r316, "authorOpenId");
        Intrinsics.checkNotNullParameter(r317, "previousPage");
        Intrinsics.checkNotNullParameter(r318, "groupSource");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter(r214, "fromGroupId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r310, "position");
        Intrinsics.checkNotNullParameter(r313, "poiId");
        Intrinsics.checkNotNullParameter(r316, "authorOpenId");
        Intrinsics.checkNotNullParameter(r317, "previousPage");
        Intrinsics.checkNotNullParameter(r318, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("post_video_play");
        r110.d("enter_from", r210);
        r110.d("group_id", r211);
        r110.d("host_group_id", r212);
        r110.d("impr_id", r213);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r214);
        r110.d("log_pb", r215);
        r110.d("is_following", Integer.valueOf(r216 ? 1 : 0));
        r110.d("position", r310);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r311 ? 1 : 0));
        r110.d("is_auto_draw", Integer.valueOf(r312 ? 1 : 0));
        r110.d("poi_id", r313);
        r110.d("has_anchor", Integer.valueOf(r314 ? 1 : 0));
        r110.d("author_openid", r316);
        r110.d("previous_page", r317);
        r110.d("group_source", r318);
        if (r319 != null) goto L5;
        String r101 = "";
    L6:
        r110.d("start_type", r101);
        r110.f198611c = r410;
        r110.b(r315, r100.f548582a).b();
        return;
    L5:
        r101 = r319;
        goto L6
    }

    @Override // t24.a
    public final void b0(String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, String r217, boolean r218, boolean r310, d r311, String r312, String r313, String r314, String r315, JSONObject r316, boolean r317, String r318) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r217, "followType");
        Intrinsics.checkNotNullParameter(r312, "previousPage");
        Intrinsics.checkNotNullParameter(r313, "groupSource");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        boolean r102 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r217, "followType");
        Intrinsics.checkNotNullParameter(r312, "previousPage");
        Intrinsics.checkNotNullParameter(r313, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("follow");
        r110.d("enter_from", r210);
        r110.d("group_id", r212);
        r110.d("host_group_id", r213);
        r110.d("impr_id", r214);
        r110.d("log_pb", r215);
        r110.d("is_following", Integer.valueOf(r216 ? 1 : 0));
        r110.d("follow_type", r217);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r110.d("author_openid", r211);
        r110.d("group_source", r313);
        r110.d("is_auto_draw", Integer.valueOf(r218 ? 1 : 0));
        r110.d("is_card_sdk", Integer.valueOf(r310 ? 1 : 0));
        String r103 = "1";
        if (r102 == false) goto L5;
        Object r104 = "1";
    L6:
        r110.d("is_landscape_mode", r104);
        r110.d("previous_page", r312);
        if (r317 == true) goto L10;
        r103 = "0";
    L10:
        r110.d("is_livehead", r103);
        String r105 = null;
        if (r315 != null) goto L13;
    L18:
        if (r318 != null) goto L20;
    L24:
        r110.f198611c = r314;
        r110.f198612d = r316;
        r110.b(r311, r100.f548582a).b();
        return;
    L20:
        if ((!StringsKt.isBlank(r318)) == false) goto L22;
        r105 = r318;
    L22:
        if (r105 == null) goto L24;
        r110.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r105);
        goto L24
    L13:
        if ((!StringsKt.isBlank(r315)) == false) goto L15;
        String r106 = r315;
    L16:
        if (r106 == null) goto L18;
        r110.d("host_enter_from", r106);
        goto L18
    L15:
        r106 = null;
        goto L16
    L5:
        r104 = "0";
        goto L6
    }

    @Override // t24.a
    public final void V1(String r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r310, boolean r311, String r312, d r313, String r314, String r315, String r316, String r317, String r318, String r319, boolean r410, JSONObject r411) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "enterMethod");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "toUserId");
        Intrinsics.checkNotNullParameter(r215, "imprId");
        Intrinsics.checkNotNullParameter(r216, "logPb");
        Intrinsics.checkNotNullParameter(r312, "position");
        Intrinsics.checkNotNullParameter(r315, "authorOpenId");
        Intrinsics.checkNotNullParameter(r316, "previousPage");
        Intrinsics.checkNotNullParameter(r317, "groupSource");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "enterMethod");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "toUserId");
        Intrinsics.checkNotNullParameter(r215, "imprId");
        Intrinsics.checkNotNullParameter(r216, "logPb");
        Intrinsics.checkNotNullParameter(r312, "position");
        Intrinsics.checkNotNullParameter(r315, "authorOpenId");
        Intrinsics.checkNotNullParameter(r316, "previousPage");
        Intrinsics.checkNotNullParameter(r317, "groupSource");
        Intrinsics.checkNotNullParameter(r319, ReportConstant.COMMON_ACTION_TYPE);
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("enter_personal_detail");
        r110.d("action_type", r319);
        r110.d("enter_from", r210);
        r110.d("enter_method", r211);
        r110.d("author_openid", r315);
        r110.d("group_id", r212);
        r110.d("host_group_id", r213);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r214);
        r110.d("impr_id", r215);
        r110.d(ILiveRoomPlayFragmentConstant.EXTRA_FROM_REQUEST_ID, r215);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r212);
        r110.d("log_pb", r216);
        r110.d("is_following", Integer.valueOf(r310 ? 1 : 0));
        r110.d("position", r312);
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r110.d("is_card_sdk", Integer.valueOf(r311 ? 1 : 0));
        r110.d("author_openid", r315);
        r110.d("group_source", r317);
        r110.d("previous_page", r316);
        if (r410 == false) goto L5;
        String r102 = "1";
    L6:
        r110.d("is_livehead", r102);
        if (r318 != null) goto L9;
    L14:
        r110.f198611c = r314;
        r110.f198612d = r411;
        r110.b(r313, r100.f548582a).b();
        return;
    L9:
        if ((!StringsKt.isBlank(r318)) == false) goto L11;
        String r103 = r318;
    L12:
        if (r103 == null) goto L14;
        r110.d("host_enter_from", r103);
        goto L14
    L11:
        r103 = null;
        goto L12
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void W0(String r210, String r211, String r212, String r213, String r214, String r215, String r216, int r310, boolean r311, String r312, boolean r313, boolean r314, d r315, String r316, String r317, String r318, String r319, JSONObject r410, boolean r411) {
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "authorOpenId");
        Intrinsics.checkNotNullParameter(r213, "groupId");
        Intrinsics.checkNotNullParameter(r214, "hostGroupId");
        Intrinsics.checkNotNullParameter(r215, "imprId");
        Intrinsics.checkNotNullParameter(r216, "logPb");
        Intrinsics.checkNotNullParameter(r312, "followType");
        Intrinsics.checkNotNullParameter(r316, "previousPage");
        Intrinsics.checkNotNullParameter(r317, "groupSource");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        boolean r111 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "authorOpenId");
        Intrinsics.checkNotNullParameter(r213, "groupId");
        Intrinsics.checkNotNullParameter(r214, "hostGroupId");
        Intrinsics.checkNotNullParameter(r215, "imprId");
        Intrinsics.checkNotNullParameter(r216, "logPb");
        Intrinsics.checkNotNullParameter(r312, "followType");
        Intrinsics.checkNotNullParameter(r316, "previousPage");
        Intrinsics.checkNotNullParameter(r317, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a(r210);
        r101.d("enter_from", r211);
        r101.d("group_id", r213);
        r101.d("host_group_id", r214);
        r101.d("impr_id", r215);
        r101.d("log_pb", r216);
        r101.d("is_following", Integer.valueOf(r311 ? 1 : 0));
        r101.d("follow_type", r312);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r101.d("author_openid", r212);
        r101.d("group_source", r317);
        r101.d("is_auto_draw", Integer.valueOf(r313 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r314 ? 1 : 0));
        String r102 = "1";
        if (r111 == false) goto L5;
        Object r103 = "1";
    L6:
        r101.d("is_landscape_mode", r103);
        r101.d("previous_page", r316);
        if (r411 == true) goto L10;
        r102 = "0";
    L10:
        r101.d("is_livehead", r102);
        r101.d("aweme_type", Integer.valueOf(r310));
        if (r319 != null) goto L13;
    L18:
        r101.f198611c = r318;
        r101.f198612d = r410;
        r101.b(r315, r100.f548582a).b();
        return;
    L13:
        if ((!StringsKt.isBlank(r319)) == false) goto L15;
        String r104 = r319;
    L16:
        if (r104 == null) goto L18;
        r101.d("host_enter_from", r104);
        goto L18
    L15:
        r104 = null;
        goto L16
    L5:
        r103 = "0";
        goto L6
    }

    @Override // t24.a
    public final void X(boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r217, boolean r218, boolean r310, d r311, String r312, String r313, String r314, String r315, boolean r316, String r317, JSONObject r318, String r319) {
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r216, "position");
        Intrinsics.checkNotNullParameter(r313, "authorOpenId");
        Intrinsics.checkNotNullParameter(r314, "previousPage");
        Intrinsics.checkNotNullParameter(r315, "groupSource");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        boolean r102 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r216, "position");
        Intrinsics.checkNotNullParameter(r313, "authorOpenId");
        Intrinsics.checkNotNullParameter(r314, "previousPage");
        Intrinsics.checkNotNullParameter(r315, "groupSource");
        if (r210 == false) goto L5;
        String r110 = "like_success";
    L6:
        com.bytedance.awemeopen.infra.base.event.b.C2872b r111 = com.bytedance.awemeopen.infra.base.event.b.a(r110);
        r111.d("enter_from", r211);
        r111.d("author_openid", r313);
        r111.d("previous_page", r314);
        r111.d("group_source", r315);
        r111.d("group_id", r212);
        r111.d("host_group_id", r213);
        r111.d("impr_id", r214);
        r111.d("log_pb", r215);
        r111.d("is_following", Integer.valueOf(r217 ? 1 : 0));
        r111.d("position", r216);
        r111.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r111.f198611c = r312;
        r111.d("is_auto_draw", Integer.valueOf(r218 ? 1 : 0));
        r111.d("is_card_sdk", Integer.valueOf(r310 ? 1 : 0));
        String r103 = "1";
        if (r102 == false) goto L9;
        Object r104 = "1";
    L10:
        r111.d("is_landscape_mode", r104);
        if (r316 == true) goto L14;
        r103 = "0";
    L14:
        r111.d("is_livehead", r103);
        String r105 = null;
        if (r317 != null) goto L17;
    L22:
        if (r319 != null) goto L24;
    L28:
        r111.f198612d = r318;
        r111.b(r311, r100.f548582a).b();
        return;
    L24:
        if ((!StringsKt.isBlank(r319)) == false) goto L26;
        r105 = r319;
    L26:
        if (r105 == null) goto L28;
        r111.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r105);
        goto L28
    L17:
        if ((!StringsKt.isBlank(r317)) == false) goto L19;
        String r106 = r317;
    L20:
        if (r106 == null) goto L22;
        r111.d("host_enter_from", r106);
        goto L22
    L19:
        r106 = null;
        goto L20
    L9:
        r104 = "0";
        goto L10
    L5:
        r110 = IStrategyStateSupplier.KEY_INFO_LIKE;
        goto L6
    }

    @Override // t24.a
    public final void n2(String r110, String r111, String r210, String r211, String r212, String r213, boolean r214, boolean r215, String r216, d r217, String r218, String r219, String r310, String r311, Integer r312, boolean r313, String r314, JSONObject r315, Map<String, String> r316) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r216, "enterMethod");
        Intrinsics.checkNotNullParameter(r219, "groupSource");
        Intrinsics.checkNotNullParameter(r310, "previousPage");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "logPb");
        Intrinsics.checkNotNullParameter(r216, "enterMethod");
        Intrinsics.checkNotNullParameter(r219, "groupSource");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a("report");
        r112.d("enter_from", r110);
        r112.d("author_openid", r111);
        r112.d("group_id", r210);
        r112.d("host_group_id", r211);
        r112.d("impr_id", r212);
        r112.d("log_pb", r213);
        r112.d("is_following", Integer.valueOf(r214 ? 1 : 0));
        r112.d("is_card_sdk", Integer.valueOf(r215 ? 1 : 0));
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r112.d("enter_method", r216);
        r112.d("group_source", r219);
        r112.d("previous_page", r310);
        r112.d("anchor_name", r311);
        r112.d("anchor_type", r311);
        r112.d("poi_type", r312);
        if (r313 == false) goto L5;
        String r102 = "1";
    L6:
        r112.d("is_livehead", r102);
        Map<String, String> r103 = null;
        if (r314 != null) goto L9;
    L14:
        if (r316 != null) goto L16;
    L23:
        r112.f198611c = r218;
        r112.f198612d = r315;
        r112.b(r217, r100.f548582a).b();
        return;
    L16:
        if ((!r316.isEmpty()) == false) goto L18;
        r103 = r316;
    L18:
        if (r103 == null) goto L23;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L21:
        if (r104.hasNext() == false) goto L23;
        Map.Entry<String, String> r105 = r104.next();
        r112.d(r105.getKey(), r105.getValue());
        goto L21
    L9:
        if ((!StringsKt.isBlank(r314)) == false) goto L11;
        String r106 = r314;
    L12:
        if (r106 == null) goto L14;
        r112.d("host_enter_from", r106);
        goto L14
    L11:
        r106 = null;
        goto L12
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void E2(String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, boolean r217, String r218, String r310, d r311, String r312, String r313, String r314, String r315, Integer r316, String r317, boolean r318, JSONObject r319, Map<String, String> r410) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r218, "groupSource");
        Intrinsics.checkNotNullParameter(r310, "enterMethod");
        Intrinsics.checkNotNullParameter(r313, "previousPage");
        Intrinsics.checkNotNullParameter(r314, "productId");
        u34.a r100 = x3();
        boolean r101 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "authorOpenId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r218, "groupSource");
        Intrinsics.checkNotNullParameter(r310, "enterMethod");
        Intrinsics.checkNotNullParameter(r313, "previousPage");
        Intrinsics.checkNotNullParameter(r314, "productId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a(AppConstants.BUNDLE_DISLIKE);
        r110.d("enter_from", r210);
        r110.d("author_openid", r211);
        r110.d("group_id", r212);
        r110.d("host_group_id", r213);
        r110.d("impr_id", r214);
        r110.d("log_pb", r215);
        r110.d("is_following", Integer.valueOf(r216 ? 1 : 0));
        r110.d("is_card_sdk", Integer.valueOf(r217 ? 1 : 0));
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r101 ? 1 : 0));
        r110.d("group_source", r218);
        r110.d("previous_page", r313);
        r110.d("product_id", r314);
        r110.d("anchor_name", r315);
        r110.d("anchor_type", r315);
        r110.d("poi_type", r316);
        if (r318 == false) goto L5;
        String r102 = "1";
    L6:
        r110.d("is_livehead", r102);
        r110.d("enter_method", r310);
        Map<String, String> r103 = null;
        if (r317 != null) goto L9;
    L14:
        if (r410 != null) goto L16;
    L23:
        r110.f198611c = r312;
        r110.f198612d = r319;
        r110.b(r311, r100.f548582a).b();
        return;
    L16:
        if ((!r410.isEmpty()) == false) goto L18;
        r103 = r410;
    L18:
        if (r103 == null) goto L23;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L21:
        if (r104.hasNext() == false) goto L23;
        Map.Entry<String, String> r105 = r104.next();
        r110.d(r105.getKey(), r105.getValue());
        goto L21
    L9:
        if ((!StringsKt.isBlank(r317)) == false) goto L11;
        String r106 = r317;
    L12:
        if (r106 == null) goto L14;
        r110.d("host_enter_from", r106);
        goto L14
    L11:
        r106 = null;
        goto L12
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void j2(String r210, String r211, String r212, String r310, String r311, boolean r312, boolean r313, boolean r314, String r315, String r316, d r317, String r318, String r319, String r410, String r411, String r412, String r413, boolean r414, JSONObject r415, String r416) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "imprId");
        Intrinsics.checkNotNullParameter(r311, "fromGroupId");
        Intrinsics.checkNotNullParameter(r315, "enterMethod");
        Intrinsics.checkNotNullParameter(r316, "playType");
        Intrinsics.checkNotNullParameter(r318, "authorOpenId");
        Intrinsics.checkNotNullParameter(r319, "previousPage");
        Intrinsics.checkNotNullParameter(r410, "groupSource");
        Intrinsics.checkNotNullParameter(r412, "requestId");
        Intrinsics.checkNotNullParameter(r413, "recommendInfo");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        boolean r111 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r211, "groupId");
        Intrinsics.checkNotNullParameter(r212, "hostGroupId");
        Intrinsics.checkNotNullParameter(r310, "imprId");
        Intrinsics.checkNotNullParameter(r311, "fromGroupId");
        Intrinsics.checkNotNullParameter(r315, "enterMethod");
        Intrinsics.checkNotNullParameter(r316, "playType");
        Intrinsics.checkNotNullParameter(r318, "authorOpenId");
        Intrinsics.checkNotNullParameter(r319, "previousPage");
        Intrinsics.checkNotNullParameter(r410, "groupSource");
        Intrinsics.checkNotNullParameter(r412, "requestId");
        Intrinsics.checkNotNullParameter(r413, "recommendInfo");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("video_play_finish");
        r101.d("enter_from", r210);
        r101.d("group_id", r211);
        r101.d("host_group_id", r212);
        r101.d("impr_id", r310);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r101.d("is_auto_draw", Integer.valueOf(r313 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r314 ? 1 : 0));
        String r102 = "1";
        if (r111 == false) goto L5;
        Object r103 = "1";
    L6:
        r101.d("is_landscape_mode", r103);
        r101.d("enter_method", r315);
        r101.d("play_type", r316);
        r101.d("is_exit_keep", Integer.valueOf(r312 ? 1 : 0));
        r101.d("author_openid", r318);
        r101.d("previous_page", r319);
        r101.d("group_source", r410);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r311);
        r101.d("previous_page", r319);
        String r104 = null;
        if (r411 != null) goto L9;
    L14:
        r101.d("request_id", r412);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r413);
        if (r414 == true) goto L18;
        r102 = "0";
    L18:
        r101.d("is_livehead", r102);
        if (r416 != null) goto L21;
    L25:
        r101.f198612d = r415;
        r101.b(r317, r100.f548582a).b();
        return;
    L21:
        if ((!StringsKt.isBlank(r416)) == false) goto L23;
        r104 = r416;
    L23:
        if (r104 == null) goto L25;
        r101.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r104);
        goto L25
    L9:
        if ((!StringsKt.isBlank(r411)) == false) goto L11;
        String r105 = r411;
    L12:
        if (r105 == null) goto L14;
        r101.d("host_enter_from", r105);
        goto L14
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = "0";
        goto L6
    }

    @Override // t24.a
    public final void J(String r210, String r211, String r212, String r213, int r310, String r311, String r312, String r313, String r314, String r315, String r316, d r317, String r318, int r319, boolean r410, Map r411, JSONObject r412, String r413, String r414, String r415, String r416, boolean r417) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r213, "hostGroupId");
        Intrinsics.checkNotNullParameter(r311, "anchorId");
        Intrinsics.checkNotNullParameter(r312, "logExtra");
        Intrinsics.checkNotNullParameter(r313, "feedType");
        Intrinsics.checkNotNullParameter(r314, "enterFrom");
        Intrinsics.checkNotNullParameter(r316, "pageName");
        Intrinsics.checkNotNullParameter(r318, "anchorType");
        Intrinsics.checkNotNullParameter(r413, "anchorIdReal");
        Intrinsics.checkNotNullParameter(r414, "anchorTypeReal");
        Intrinsics.checkNotNullParameter(r415, "enterFromReal");
        Intrinsics.checkNotNullParameter(r416, "enterMethodReal");
        u34.a.d(x3(), "anchor_entrance_show", r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, this.f198100e, r410, r318, r319, r411, r412, r413, r414, r415, r416, r417);
    }

    @Override // t24.a
    public final void L1(String r210, String r211, String r212, String r310, int r311, String r312, String r313, String r314, String r315, String r316, String r317, d r318, String r319, int r410, boolean r411, Map r412, JSONObject r413, String r414, String r415, String r416, String r417, boolean r418) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r310, "hostGroupId");
        Intrinsics.checkNotNullParameter(r312, "anchorId");
        Intrinsics.checkNotNullParameter(r313, "logExtra");
        Intrinsics.checkNotNullParameter(r314, "feedType");
        Intrinsics.checkNotNullParameter(r315, "enterFrom");
        Intrinsics.checkNotNullParameter(r317, "pageName");
        Intrinsics.checkNotNullParameter(r319, "anchorType");
        Intrinsics.checkNotNullParameter(r414, "anchorIdReal");
        Intrinsics.checkNotNullParameter(r415, "anchorTypeReal");
        Intrinsics.checkNotNullParameter(r416, "enterFromReal");
        Intrinsics.checkNotNullParameter(r417, "enterMethodReal");
        u34.a.d(x3(), "life_anchor_entrance_click", r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, this.f198100e, r411, r319, r410, r412, r413, r414, r415, r416, r417, r418);
    }

    @Override // t24.a
    public final void N2(String r210, String r211, String r212, String r310, int r311, String r312, String r313, String r314, String r315, String r316, String r317, d r318, String r319, int r410, boolean r411, Map r412, JSONObject r413, String r414, String r415, String r416, String r417, boolean r418) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r310, "hostGroupId");
        Intrinsics.checkNotNullParameter(r312, "anchorId");
        Intrinsics.checkNotNullParameter(r313, "logExtra");
        Intrinsics.checkNotNullParameter(r314, "feedType");
        Intrinsics.checkNotNullParameter(r315, "enterFrom");
        Intrinsics.checkNotNullParameter(r317, "pageName");
        Intrinsics.checkNotNullParameter(r319, "anchorType");
        Intrinsics.checkNotNullParameter(r414, "anchorIdReal");
        Intrinsics.checkNotNullParameter(r415, "anchorTypeReal");
        Intrinsics.checkNotNullParameter(r416, "enterFromReal");
        Intrinsics.checkNotNullParameter(r417, "enterMethodReal");
        u34.a.d(x3(), "anchor_entrance_click", r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, this.f198100e, r411, r319, r410, r412, r413, r414, r415, r416, r417, r418);
    }

    @Override // t24.a
    public final void a2(String r210, String r211, String r212, String r310, int r311, String r312, String r313, String r314, String r315, String r316, String r317, d r318, String r319, int r410, boolean r411, Map r412, JSONObject r413, String r414, String r415, String r416, String r417, boolean r418) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r211, "authorId");
        Intrinsics.checkNotNullParameter(r212, "groupId");
        Intrinsics.checkNotNullParameter(r310, "hostGroupId");
        Intrinsics.checkNotNullParameter(r312, "anchorId");
        Intrinsics.checkNotNullParameter(r313, "logExtra");
        Intrinsics.checkNotNullParameter(r314, "feedType");
        Intrinsics.checkNotNullParameter(r315, "enterFrom");
        Intrinsics.checkNotNullParameter(r317, "pageName");
        Intrinsics.checkNotNullParameter(r319, "anchorType");
        Intrinsics.checkNotNullParameter(r414, "anchorIdReal");
        Intrinsics.checkNotNullParameter(r415, "anchorTypeReal");
        Intrinsics.checkNotNullParameter(r416, "enterFromReal");
        Intrinsics.checkNotNullParameter(r417, "enterMethodReal");
        u34.a.d(x3(), "life_anchor_entrance_show", r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, this.f198100e, r411, r319, r410, r412, r413, r414, r415, r416, r417, r418);
    }

    @Override // t24.a
    public final void e3(String r210, int r211, long r212, boolean r213, int r214, int r215, long r310, long r311, long r312, String r313, String r314, String r315, String r316, String r410, String r411, String r412, boolean r413, boolean r414, String r415, String r416, d r417, String r418) {
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r313, "authorOpenId");
        Intrinsics.checkNotNullParameter(r314, "groupId");
        Intrinsics.checkNotNullParameter(r315, "hostGroupId");
        Intrinsics.checkNotNullParameter(r316, "enterMethod");
        Intrinsics.checkNotNullParameter(r410, "slideDirection");
        Intrinsics.checkNotNullParameter(r411, "imprId");
        Intrinsics.checkNotNullParameter(r412, "logPb");
        Intrinsics.checkNotNullParameter(r415, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r416, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r418, "previousPage");
        u34.a r100 = x3();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "enterFrom");
        Intrinsics.checkNotNullParameter(r313, "authorOpenId");
        Intrinsics.checkNotNullParameter(r314, "groupId");
        Intrinsics.checkNotNullParameter(r315, "hostGroupId");
        Intrinsics.checkNotNullParameter(r316, "enterMethod");
        Intrinsics.checkNotNullParameter(r410, "slideDirection");
        Intrinsics.checkNotNullParameter(r411, "imprId");
        Intrinsics.checkNotNullParameter(r412, "logPb");
        Intrinsics.checkNotNullParameter(r415, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r416, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r418, "previousPage");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r110 = com.bytedance.awemeopen.infra.base.event.b.a("multi_photo_show_end");
        r110.d("enter_from", r210);
        r110.d("index", Integer.valueOf(r211));
        r110.d("vision_load_cost", Long.valueOf(r212));
        r110.d("is_first_load", Boolean.valueOf(r213));
        r110.d("status", Integer.valueOf(r214));
        r110.d("image_origin", Integer.valueOf(r215));
        r110.d("show_duration", Long.valueOf(r310));
        r110.d("load_duration", Long.valueOf(r311));
        r110.d("image_load_duration", Long.valueOf(r312));
        r110.d("author_openid", r313);
        r110.d("group_id", r314);
        r110.d("host_group_id", r315);
        r110.d("enter_method", r316);
        r110.d("slide_direction", r410);
        r110.d("impr_id", r411);
        r110.d("log_pb", r412);
        r110.d("is_following", Integer.valueOf(r413 ? 1 : 0));
        r110.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r414 ? 1 : 0));
        r110.d("photo_serial_num", r415);
        r110.d("all_photo_num", r416);
        r110.d("previous_page", r418);
        r110.b(r417, r100.f548582a).b();
    }

    @Override // t24.a
    public final void i2(String r110, String r111, String r210, String r211, String r212, String r213, String r214, boolean r215, int r216, boolean r217, double r218, float r310, long r311, Float r312, int r313, boolean r314, boolean r315, Integer r316, Integer r317, Integer r318, JSONObject r410, HostCommonParamProvider r411) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "fromGroupId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter("detail", "position");
        u34.a r112 = x3();
        boolean r113 = this.f198101f;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "imprId");
        Intrinsics.checkNotNullParameter(r213, "fromGroupId");
        Intrinsics.checkNotNullParameter(r214, "logPb");
        Intrinsics.checkNotNullParameter("detail", "position");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("video_over");
        r100.d("enter_from", r110);
        r100.d("group_id", r210);
        r100.d("host_group_id", r211);
        r100.d("impr_id", r212);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r213);
        r100.d("log_pb", r214);
        r100.d("is_following", Integer.valueOf(r215 ? 1 : 0));
        r100.d("is_card_sdk", Integer.valueOf(r217 ? 1 : 0));
        if (r113 == false) goto L5;
        String r101 = "1";
    L6:
        r100.d("is_landscape_mode", r101);
        r100.d("aweme_type", Integer.valueOf(r216));
        r100.d("position", "detail");
        r100.d("percent", Double.valueOf(r218));
        r100.d("max_percnt", Float.valueOf(r310));
        r100.d("max_percent", Float.valueOf(r310));
        r100.d("duration", Long.valueOf(r311));
        r100.d("play_count", r312);
        r100.d("play_cnt", Integer.valueOf(r313));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r314 ? 1 : 0));
        r100.d("is_auto_draw", Integer.valueOf(r315 ? 1 : 0));
        r100.d("play_pic_cnt", r316);
        r100.d("pic_cnt", r317);
        r100.d("group_source", r318);
        r100.f198612d = r410;
        if (r111 != null) goto L9;
    L14:
        r100.b(r411, r112.f548582a).b();
        return;
    L9:
        if ((!StringsKt.isBlank(r111)) == false) goto L11;
        String r102 = r111;
    L12:
        if (r102 == null) goto L14;
        r100.d("host_enter_from", r102);
        goto L14
    L11:
        r102 = null;
        goto L12
    L5:
        r101 = "0";
        goto L6
    }

    @Override // t24.a
    public final void V(String r210, String r310, String r311, String r312, int r313, String r314, String r315, String r316, String r317, String r318, String r319, d r410, String r411, int r412, boolean r413, Map r414, JSONObject r415, String r416, String r417, String r418, String r419, boolean r510, long r511) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r210, "requestId");
        Intrinsics.checkNotNullParameter(r310, "authorId");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r314, "anchorId");
        Intrinsics.checkNotNullParameter(r315, "logExtra");
        Intrinsics.checkNotNullParameter(r316, "feedType");
        Intrinsics.checkNotNullParameter(r317, "enterFrom");
        Intrinsics.checkNotNullParameter(r319, "pageName");
        Intrinsics.checkNotNullParameter(r411, "anchorType");
        Intrinsics.checkNotNullParameter(r416, "anchorIdReal");
        Intrinsics.checkNotNullParameter(r417, "anchorTypeReal");
        Intrinsics.checkNotNullParameter(r418, "enterFromReal");
        Intrinsics.checkNotNullParameter(r419, "enterMethodReal");
        x3().c("anchor_staytime", r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, this.f198100e, r413, r411, r412, r414, r415, r416, r417, r418, r419, r510, r511);
    }

    @Override // t24.a
    public final void q3(String r310, String r311, String r312, long r313, String r314, String r315, String r316, boolean r317, boolean r318, String r410, boolean r411, boolean r412, long r413, String r414, String r415, d r416, String r417, String r418, String r510, String r511, String r512, String r513, String r514, JSONObject r515) {
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r314, "imprId");
        Intrinsics.checkNotNullParameter(r315, "fromGroupId");
        Intrinsics.checkNotNullParameter(r316, "logPb");
        Intrinsics.checkNotNullParameter(r410, "poiId");
        Intrinsics.checkNotNullParameter(r414, "enterMethod");
        Intrinsics.checkNotNullParameter(r415, "playType");
        Intrinsics.checkNotNullParameter(r417, "previousPage");
        Intrinsics.checkNotNullParameter(r418, "groupSource");
        Intrinsics.checkNotNullParameter(r510, "authorOpenId");
        Intrinsics.checkNotNullParameter(r512, "requestId");
        Intrinsics.checkNotNullParameter(r513, "recommendInfo");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r314, "imprId");
        Intrinsics.checkNotNullParameter(r315, "fromGroupId");
        Intrinsics.checkNotNullParameter(r316, "logPb");
        Intrinsics.checkNotNullParameter(r410, "poiId");
        Intrinsics.checkNotNullParameter(r414, "enterMethod");
        Intrinsics.checkNotNullParameter(r415, "playType");
        Intrinsics.checkNotNullParameter(r417, "previousPage");
        Intrinsics.checkNotNullParameter(r418, "groupSource");
        Intrinsics.checkNotNullParameter(r510, "authorOpenId");
        Intrinsics.checkNotNullParameter(r512, "requestId");
        Intrinsics.checkNotNullParameter(r513, "recommendInfo");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r101 = com.bytedance.awemeopen.infra.base.event.b.a("landscape_mode_stay_time");
        r101.d("enter_from", r310);
        r101.d("author_openid", r510);
        r101.d("group_id", r311);
        r101.d("host_group_id", r312);
        r101.d("duration", Long.valueOf(r313));
        r101.d("impr_id", r314);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r315);
        r101.d("log_pb", r316);
        r101.d("is_following", Integer.valueOf(r317 ? 1 : 0));
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r101.d("is_auto_draw", Integer.valueOf(r318 ? 1 : 0));
        r101.d("poi_id", r410);
        r101.d("has_anchor", Integer.valueOf(r411 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r412 ? 1 : 0));
        r101.d("background_duration", Long.valueOf(r413));
        r101.d("enter_method", r414);
        r101.d("play_type", r415);
        r101.d("previous_page", r417);
        r101.d("group_source", r418);
        r101.d("author_openid", r510);
        String r102 = null;
        if (r511 != null) goto L5;
    L10:
        if (r514 != null) goto L12;
    L16:
        r101.d("request_id", r512);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r513);
        r101.f198612d = r515;
        r101.b(r416, r100.f548582a).b();
        return;
    L12:
        if ((!StringsKt.isBlank(r514)) == false) goto L14;
        r102 = r514;
    L14:
        if (r102 == null) goto L16;
        r101.d("action_type", r102);
        goto L16
    L5:
        if ((!StringsKt.isBlank(r511)) == false) goto L7;
        String r103 = r511;
    L8:
        if (r103 == null) goto L10;
        r101.d("host_enter_from", r103);
        goto L10
    L7:
        r103 = null;
        goto L8
    }

    @Override // t24.a
    public final void b3(String r310, String r311, String r312, long r313, float r314, String r315, String r316, String r410, boolean r411, boolean r412, String r413, boolean r414, boolean r415, long r416, String r417, String r418, d r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, boolean r518, JSONObject r519, String r610) {
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r315, "imprId");
        Intrinsics.checkNotNullParameter(r316, "fromGroupId");
        Intrinsics.checkNotNullParameter(r410, "logPb");
        Intrinsics.checkNotNullParameter(r413, "poiId");
        Intrinsics.checkNotNullParameter(r417, "enterMethod");
        Intrinsics.checkNotNullParameter(r418, "playType");
        Intrinsics.checkNotNullParameter(r511, "previousPage");
        Intrinsics.checkNotNullParameter(r512, "groupSource");
        Intrinsics.checkNotNullParameter(r513, "authorOpenId");
        Intrinsics.checkNotNullParameter(r515, "requestId");
        Intrinsics.checkNotNullParameter(r516, "recommendInfo");
        u34.a r100 = x3();
        boolean r110 = this.f198100e;
        boolean r111 = this.f198101f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r315, "imprId");
        Intrinsics.checkNotNullParameter(r316, "fromGroupId");
        Intrinsics.checkNotNullParameter(r410, "logPb");
        Intrinsics.checkNotNullParameter(r413, "poiId");
        Intrinsics.checkNotNullParameter(r417, "enterMethod");
        Intrinsics.checkNotNullParameter(r418, "playType");
        Intrinsics.checkNotNullParameter(r511, "previousPage");
        Intrinsics.checkNotNullParameter(r512, "groupSource");
        Intrinsics.checkNotNullParameter(r513, "authorOpenId");
        Intrinsics.checkNotNullParameter(r515, "requestId");
        Intrinsics.checkNotNullParameter(r516, "recommendInfo");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a(HistoryTableOperate.HISTORY_PLAY_TIME);
        r112.d("enter_from", r310);
        r112.d("author_openid", r513);
        r112.d("group_id", r311);
        r112.d("host_group_id", r312);
        r112.d("duration", Long.valueOf(r313));
        r112.d("group_duration", Float.valueOf(r314));
        r112.d("impr_id", r315);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r316);
        r112.d("log_pb", r410);
        r112.d("is_following", Integer.valueOf(r411 ? 1 : 0));
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r110 ? 1 : 0));
        r112.d("is_auto_draw", Integer.valueOf(r412 ? 1 : 0));
        String r101 = "1";
        if (r111 == false) goto L5;
        Object r102 = "1";
    L6:
        r112.d("is_landscape_mode", r102);
        r112.d("poi_id", r413);
        r112.d("has_anchor", Integer.valueOf(r414 ? 1 : 0));
        r112.d("is_card_sdk", Integer.valueOf(r415 ? 1 : 0));
        r112.d("background_duration", Long.valueOf(r416));
        r112.d("enter_method", r417);
        r112.d("play_type", r418);
        r112.d("previous_page", r511);
        r112.d("group_source", r512);
        r112.d("author_openid", r513);
        if (r518 == true) goto L10;
        r101 = "0";
    L10:
        r112.d("is_livehead", r101);
        String r103 = null;
        if (r514 != null) goto L13;
    L18:
        if (r517 != null) goto L20;
    L25:
        r112.d("request_id", r515);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r516);
        if (r610 != null) goto L28;
    L32:
        r112.f198612d = r519;
        r112.b(r510, r100.f548582a).b();
        return;
    L28:
        if ((!StringsKt.isBlank(r610)) == false) goto L30;
        r103 = r610;
    L30:
        if (r103 == null) goto L32;
        r112.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r103);
        goto L32
    L20:
        if ((!StringsKt.isBlank(r517)) == false) goto L22;
        String r104 = r517;
    L23:
        if (r104 == null) goto L25;
        r112.d("action_type", r104);
        goto L25
    L22:
        r104 = null;
        goto L23
    L13:
        if ((!StringsKt.isBlank(r514)) == false) goto L15;
        String r105 = r514;
    L16:
        if (r105 == null) goto L18;
        r112.d("host_enter_from", r105);
        goto L18
    L15:
        r105 = null;
        goto L16
    L5:
        r102 = "0";
        goto L6
    }

    @Override // t24.a
    public final void u3(String r310, String r311, String r312, String r313, String r314, String r315, boolean r316, String r317, boolean r318, boolean r410, boolean r411, String r412, boolean r413, boolean r414, boolean r415, String r416, String r417, d r418, String r419, String r510, String r511, String r512, String r513, Map<String, String> r514, String r515, String r516, String r517, int r518, String r519, JSONObject r610) {
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r313, "imprId");
        Intrinsics.checkNotNullParameter(r314, "fromGroupId");
        Intrinsics.checkNotNullParameter(r315, "logPb");
        Intrinsics.checkNotNullParameter(r317, "position");
        Intrinsics.checkNotNullParameter(r412, "poiId");
        Intrinsics.checkNotNullParameter(r416, "enterMethod");
        Intrinsics.checkNotNullParameter(r417, "playType");
        Intrinsics.checkNotNullParameter(r419, "previousPage");
        Intrinsics.checkNotNullParameter(r510, "groupSource");
        Intrinsics.checkNotNullParameter(r511, "authorOpenId");
        Intrinsics.checkNotNullParameter(r515, "requestId");
        Intrinsics.checkNotNullParameter(r516, "recommendInfo");
        Intrinsics.checkNotNullParameter(r517, "productId");
        u34.a r110 = x3();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r313, "imprId");
        Intrinsics.checkNotNullParameter(r314, "fromGroupId");
        Intrinsics.checkNotNullParameter(r315, "logPb");
        Intrinsics.checkNotNullParameter(r317, "position");
        Intrinsics.checkNotNullParameter(r412, "poiId");
        Intrinsics.checkNotNullParameter(r416, "enterMethod");
        Intrinsics.checkNotNullParameter(r417, "playType");
        Intrinsics.checkNotNullParameter(r419, "previousPage");
        Intrinsics.checkNotNullParameter(r510, "groupSource");
        Intrinsics.checkNotNullParameter(r511, "authorOpenId");
        Intrinsics.checkNotNullParameter(r515, "requestId");
        Intrinsics.checkNotNullParameter(r516, "recommendInfo");
        Intrinsics.checkNotNullParameter(r517, "productId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r100 = com.bytedance.awemeopen.infra.base.event.b.a("video_play_failed");
        r100.d("enter_from", r310);
        r100.d("group_id", r311);
        r100.d("host_group_id", r312);
        r100.d("impr_id", r313);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r314);
        r100.d("log_pb", r315);
        r100.d("is_following", Integer.valueOf(r316 ? 1 : 0));
        r100.d("position", r317);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r318 ? 1 : 0));
        r100.d("is_exit_keep", Integer.valueOf(r410 ? 1 : 0));
        r100.d("is_auto_draw", Integer.valueOf(r411 ? 1 : 0));
        r100.d("poi_id", r412);
        r100.d("has_anchor", Integer.valueOf(r413 ? 1 : 0));
        r100.d("is_card_sdk", Integer.valueOf(r414 ? 1 : 0));
        r100.d(LocationMonitorConst.IS_BACKGROUND, Integer.valueOf(r415 ? 1 : 0));
        r100.d("enter_method", r416);
        r100.d("play_type", r417);
        r100.d("previous_page", r419);
        r100.d("group_source", r510);
        r100.d("author_openid", r511);
        String r101 = null;
        if (r514 != null) goto L5;
    L13:
        if (r512 != null) goto L15;
    L19:
        r100.d("request_id", r515);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r516);
        r100.d("anchor_name", r513);
        r100.d("product_id", r517);
        r100.d("error_code", Integer.valueOf(r518));
        r100.d("error_message", r519);
        r100.f198612d = r610;
        r100.b(r418, r110.f548582a).b();
        return;
    L15:
        if ((!StringsKt.isBlank(r512)) == false) goto L17;
        r101 = r512;
    L17:
        if (r101 == null) goto L19;
        r100.d("host_enter_from", r101);
        goto L19
    L5:
        if ((!r514.isEmpty()) == false) goto L7;
        Map<String, String> r102 = r514;
    L8:
        if (r102 == null) goto L13;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r103.next();
        r100.d(r104.getKey(), r104.getValue());
        goto L11
    L7:
        r102 = null;
        goto L8
    }

    @Override // t24.a
    public final void U0(String r310, String r311, String r312, String r313, String r314, float r315, String r316, boolean r317, String r318, boolean r410, boolean r411, boolean r412, String r413, boolean r414, boolean r415, boolean r416, String r417, String r418, d r419, String r510, String r511, String r512, String r513, String r514, Integer r515, Map<String, String> r516, String r517, String r518, String r519, boolean r610, boolean r611, JSONObject r612, String r613) {
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r313, "imprId");
        Intrinsics.checkNotNullParameter(r314, "fromGroupId");
        Intrinsics.checkNotNullParameter(r316, "logPb");
        Intrinsics.checkNotNullParameter(r318, "position");
        Intrinsics.checkNotNullParameter(r413, "poiId");
        Intrinsics.checkNotNullParameter(r417, "enterMethod");
        Intrinsics.checkNotNullParameter(r418, "playType");
        Intrinsics.checkNotNullParameter(r510, "previousPage");
        Intrinsics.checkNotNullParameter(r511, "groupSource");
        Intrinsics.checkNotNullParameter(r512, "authorOpenId");
        Intrinsics.checkNotNullParameter(r517, "requestId");
        Intrinsics.checkNotNullParameter(r518, "recommendInfo");
        Intrinsics.checkNotNullParameter(r519, "productId");
        u34.a r110 = x3();
        boolean r111 = this.f198101f;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r310, "enterFrom");
        Intrinsics.checkNotNullParameter(r311, "groupId");
        Intrinsics.checkNotNullParameter(r312, "hostGroupId");
        Intrinsics.checkNotNullParameter(r313, "imprId");
        Intrinsics.checkNotNullParameter(r314, "fromGroupId");
        Intrinsics.checkNotNullParameter(r316, "logPb");
        Intrinsics.checkNotNullParameter(r318, "position");
        Intrinsics.checkNotNullParameter(r413, "poiId");
        Intrinsics.checkNotNullParameter(r417, "enterMethod");
        Intrinsics.checkNotNullParameter(r418, "playType");
        Intrinsics.checkNotNullParameter(r510, "previousPage");
        Intrinsics.checkNotNullParameter(r511, "groupSource");
        Intrinsics.checkNotNullParameter(r512, "authorOpenId");
        Intrinsics.checkNotNullParameter(r517, "requestId");
        Intrinsics.checkNotNullParameter(r518, "recommendInfo");
        Intrinsics.checkNotNullParameter(r519, "productId");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r112 = com.bytedance.awemeopen.infra.base.event.b.a("video_play");
        r112.d("enter_from", r310);
        r112.d("group_id", r311);
        r112.d("host_group_id", r312);
        r112.d("impr_id", r313);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r314);
        r112.d("group_duration", Float.valueOf(r315));
        r112.d("log_pb", r316);
        r112.d("is_following", Integer.valueOf(r317 ? 1 : 0));
        r112.d("position", r318);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r410 ? 1 : 0));
        r112.d("is_exit_keep", Integer.valueOf(r411 ? 1 : 0));
        r112.d("is_auto_draw", Integer.valueOf(r412 ? 1 : 0));
        r112.d("poi_id", r413);
        r112.d("has_anchor", Integer.valueOf(r414 ? 1 : 0));
        r112.d("is_card_sdk", Integer.valueOf(r415 ? 1 : 0));
        String r100 = "1";
        if (r111 == false) goto L5;
        Object r101 = "1";
    L6:
        r112.d("is_landscape_mode", r101);
        r112.d(LocationMonitorConst.IS_BACKGROUND, Integer.valueOf(r416 ? 1 : 0));
        r112.d("enter_method", r417);
        r112.d("play_type", r418);
        r112.d("previous_page", r510);
        r112.d("group_source", r511);
        r112.d("author_openid", r512);
        String r102 = null;
        if (r516 != null) goto L9;
    L17:
        if (r513 != null) goto L19;
    L24:
        r112.d("request_id", r517);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r518);
        r112.d("anchor_name", r514);
        r112.d("anchor_type", r514);
        r112.d("poi_type", r515);
        r112.d("product_id", r519);
        r112.d("hitCache", Integer.valueOf(r610 ? 1 : 0));
        if (r611 == true) goto L28;
        r100 = "0";
    L28:
        r112.d("is_livehead", r100);
        if (r613 != null) goto L31;
    L35:
        r112.f198612d = r612;
        r112.b(r419, r110.f548582a).b();
        return;
    L31:
        if ((!StringsKt.isBlank(r613)) == false) goto L33;
        r102 = r613;
    L33:
        if (r102 == null) goto L35;
        r112.d(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r102);
        goto L35
    L19:
        if ((!StringsKt.isBlank(r513)) == false) goto L21;
        String r103 = r513;
    L22:
        if (r103 == null) goto L24;
        r112.d("host_enter_from", r103);
        goto L24
    L21:
        r103 = null;
        goto L22
    L9:
        if ((!r516.isEmpty()) == false) goto L11;
        Map<String, String> r104 = r516;
    L12:
        if (r104 == null) goto L17;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<String, String> r106 = r105.next();
        r112.d(r106.getKey(), r106.getValue());
        goto L15
    L11:
        r104 = null;
        goto L12
    L5:
        r101 = "0";
        goto L6
    }
}
