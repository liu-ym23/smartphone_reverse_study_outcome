package fk1;

import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.app.BundleCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.q2;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.audiencerecord.BacktrackServiceImp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.d3;
import com.bytedance.android.livesdk.chatroom.paidlive.PaidRoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.replay_api.service.out.ICameraSwitchTimeExternalService;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomMetrics;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.ui.LivePaidPlayerContainerWidget;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VSMultiCameraDelegate$initMultiCameraService$7;
import com.bytedance.android.livesdk.chatroom.utils.a5;
import com.bytedance.android.livesdk.chatroom.utils.u4;
import com.bytedance.android.livesdk.chatroom.utils.v4;
import com.bytedance.android.livesdk.chatroom.utils.w4;
import com.bytedance.android.livesdk.chatroom.utils.x4;
import com.bytedance.android.livesdk.chatroom.utils.y4;
import com.bytedance.android.livesdk.chatroom.utils.z4;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.c6;
import com.bytedance.android.livesdk.config.kf0;
import com.bytedance.android.livesdk.config.ko0;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.nt;
import com.bytedance.android.livesdk.config.q21;
import com.bytedance.android.livesdk.config.x10;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowManager;
import com.bytedance.android.livesdk.log.ContentDurationLogger;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.RoomDataType;
import com.bytedance.android.livesdk.utils.t3;
import com.bytedance.android.livesdk.vscore_api.multicamera.IMultiCameraView;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.widget.ResolutionServiceWidget;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.ChangeCameraStreamEvent;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.eventbus.VSCameraChangeEvent;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class v extends com.bytedance.android.livesdk.room.c<ls2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yj1.a f477590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ik1.c f477591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public wh1.a f477592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ResolutionServiceWidget f477593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.room.b f477594f;

    public static class a implements com.bytedance.android.live.matchroom.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<yj1.a> f477595a;

        public a(yj1.a r100) {
            this.f477595a = new WeakReference(r100);
        }

        @Override // com.bytedance.android.live.matchroom.e
        public final void a(boolean r100) {
            yj1.a r101 = this.f477595a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            AbsLivePlayerView r102 = r101.f568061h;
            if (r102.getClient() != null) goto L8;
            return;
        L8:
            if (r102.getClient().extraRenderController() == null) goto L12;
            r102.getClient().extraRenderController().invisibleExtraRender(!r100);
            return;
        }
    }

    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public final RoomContext z() {
        return jk1.a.d(this.f477594f);
    }

    public v() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r110) {
        ((lu2.f) jc1.k.f(lu2.f.class)).getMatchTitleImageLoader().release(r110.f510496c.longValue());
        com.bytedance.android.livesdk.vscore_api.paidlive.c r100 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r110.f157610s);
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r110.f157610s).isPaidLive() == false) goto L5;
    L6:
        HashMap r101 = new HashMap();
        r101.put("flag_secure_status", "false");
        com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e.trace("paidlive_audience_flag_secure_status_check", r101, new HashMap(), PaidSceneViewEntry.IN_ROOM.name(), PaidSceneEnum.ALL.name());
        this.f477591c.f490211d.setSharePullStreamData(null);
    L7:
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.p(r110.f510496c.longValue());
        if (ko0.f120618a.getValue().getLeakOpt() != true) goto L14;
        DataCenter r103 = r110.f157610s;
        if (r103 == null) goto L14;
        se1.c r104 = (se1.c) r103.get("data_audience_backtrace_service", null);
        if (r104 == null) goto L14;
        r104.release();
    L14:
        pm1.h r105 = pm1.h.f529822d;
        if (((nm1.n) r105.c(nm1.n.class)) != null) goto L17;
    L19:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L17:
        if (r110.f157611t == null) goto L19;
        ((nm1.n) r105.c(nm1.n.class)).c(r110.f157611t.getRoomId());
        goto L19
    L5:
        if (r100.Y0(PaidSceneEnum.ALL) == false) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void l(final com.bytedance.android.livesdk.room.b r100) {
        yj1.a r101 = (yj1.a) r100.b("RoomDataConst_live_room_player_context");
        if (pm1.f.a() == null) goto L8;
        if (dq1.b.a(r100.f157611t) == false) goto L8;
        pm1.f.a().o4();
    L8:
        if (r101.f568068o.booleanValue() == true) goto L10;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L10:
        if (dq1.b.a(r100.f157611t) == true) goto L12;
        jk1.a.d(r100).getLoggerHelper().c(new i(r100));
        goto L12
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void m(com.bytedance.android.livesdk.room.b r100) {
        ((lu2.f) jc1.k.f(lu2.f.class)).getMatchTitleImageLoader().release(r100.f510496c.longValue());
        com.bytedance.android.livesdk.vscore_api.paidlive.c r101 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r100.f157610s);
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r100.f157610s).isPaidLive() == false) goto L5;
    L6:
        this.f477591c.f490211d.setSharePullStreamData(null);
    L7:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L5:
        if (r101.Y0(PaidSceneEnum.ALL) == false) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void o(com.bytedance.android.livesdk.room.b r100) {
        this.f477594f = r100;
        this.f477590b = jk1.a.f(r100);
        this.f477591c = jk1.a.c(r100);
        this.f477592d = jk1.a.e(r100);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public void onEvent(VSJumpCameraEvent r210) {
        if (this.f477590b.f568056c != null) goto L5;
        return;
    L5:
        if (this.f477592d.f559643d != null) goto L8;
        return;
    L8:
        if (z().getCameraId().getValue().longValue() != r210.getCameraId()) goto L10;
        return;
    L10:
        DataCenter r100 = this.f477594f.f157610s;
        if (r100 != null) goto L13;
    L16:
        RoomSession r101 = this.f477591c.f490211d;
        if (r101 == null) goto L25;
        r101.B();
        LiveRoomMetrics r102 = this.f477591c.f490211d.B();
        ICameraSwitchTimeExternalService r103 = r102.f110575m;
        if (r103 == null) goto L21;
        r103.startTrace();
    L21:
        lu2.a r104 = r102.f110588z;
        if (r104 == null) goto L25;
        r104.a();
    L25:
        if (pm1.f.r() == null) goto L28;
        pm1.f.r().g();
        vp1.e.f556577a.c(r210, this.f477594f.f157610s);
    L28:
        if (r210.getStreamUrl() != null) goto L30;
        return;
    L30:
        com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.room.b r105 = jk1.a.b(this.f477594f);
        com.bytedance.android.livesdk.log.j r106 = r105.f107273d;
        if (r106 == null) goto L33;
        r106.f();
    L33:
        ContentDurationLogger r107 = r105.f107274e;
        if (r107 == null) goto L36;
        r107.a();
    L36:
        boolean r108 = z().isVSVerticalStream();
        if (r210.getStyle() != 2) goto L39;
        boolean r109 = true;
    L40:
        if (r108 == r109) goto L42;
        boolean r110 = true;
    L43:
        com.bytedance.android.livesdk.log.filter.o r111 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r111 == null) goto L84;
        Room r112 = this.f477594f.f157611t;
        if (r112 == null) goto L84;
        if (r112.getEpisodeComponentData() == null) goto L84;
        HashMap r113 = new HashMap();
        r113.put("vs_machine_id", String.valueOf(r210.getCameraId()));
        if (pm1.f.l() == null) goto L58;
        r113.put(PaidReplayConstants.KEY_VS_MACHINE_TYPE, pm1.f.l().j(r210.getCameraId(), this.f477594f.f157611t));
        if (pm1.f.l().K(this.f477594f.f157610s) != null) goto L54;
    L56:
        String r114 = "0";
    L57:
        r113.put("is_paid_machine", r114);
        goto L58
    L54:
        if (pm1.f.l().K(this.f477594f.f157610s).isPaidCamera() == false) goto L56;
        r114 = "1";
    L58:
        r111.putAll(r113);
        Bundle r115 = r210.getExtra();
        if (r115 == null) goto L61;
        Bundle r116 = r115.getBundle(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_EXTRA_V1);
    L62:
        com.bytedance.android.livesdk.log.filter.o r117 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if (r117 == null) goto L84;
        HashMap r118 = new HashMap();
        if (r116 != null) goto L67;
    L69:
        r117.remove("is_game_data");
    L71:
        if (r116 != null) goto L73;
    L75:
        r117.remove("is_tag");
    L77:
        if (r116 != null) goto L79;
    L81:
        r117.remove(ILiveRoomPlayFragmentConstant.EXTRA_CAMERA_ENTER_FROM);
    L82:
        r117.putAll(r118);
        goto L84
    L79:
        if (r116.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_CAMERA_ENTER_FROM) == false) goto L81;
        r118.put(ILiveRoomPlayFragmentConstant.EXTRA_CAMERA_ENTER_FROM, r116.getString(ILiveRoomPlayFragmentConstant.EXTRA_CAMERA_ENTER_FROM));
        goto L82
    L73:
        if (r116.containsKey("is_tag") == false) goto L75;
        r118.put("is_tag", r116.getString("is_tag"));
        goto L77
    L67:
        if (r116.containsKey("is_game_data") == false) goto L69;
        r118.put("is_game_data", r116.getString("is_game_data"));
        goto L71
    L61:
        r116 = null;
    L84:
        if ((r210.getStreamUrl() instanceof StreamUrl) == false) goto L86;
        StreamUrl r119 = (StreamUrl) r210.getStreamUrl();
        int r120 = AudienceVideoResolutionManager.f110411a;
        AudienceVideoResolutionManager.v(r119);
    L86:
        z().getVsVerticalStream().setValue(Boolean.valueOf(r109));
        long r121 = this.f477594f.f157611t.getEpisodeComponentData().getDefaultCameraId();
        long r122 = z().getCameraId().getValue().longValue();
        if (pm1.f.l() == null) goto L89;
        VSCameraInfo r123 = pm1.f.l().d(this.f477594f.f157611t, r122);
    L90:
        long r124 = z().getCameraId().getValue().longValue();
        long r125 = z().getCurrentMatchId().getValue().longValue();
        if (q2.b(this.f477594f.f157611t) == false) goto L95;
        z().getCameraId().setValue(Long.valueOf(r210.getCameraId()));
        if (pm1.f.l() == null) goto L96;
        z().getCurrentMatchId().setValue(Long.valueOf(pm1.f.l().f(this.f477594f.f157610s)));
    L96:
        this.f477590b.f568068o = Boolean.TRUE;
        z().getChangingCamera().setValue(this.f477590b.f568068o);
        long r126 = z().getCameraId().getValue().longValue();
        if (r126 > 0) goto L99;
    L101:
        boolean r127 = false;
    L103:
        if (pm1.f.l() == null) goto L105;
        VSCameraInfo r128 = pm1.f.l().d(this.f477594f.f157611t, r126);
    L106:
        long r129 = z().getContentId().getValue().longValue();
        if (r128 == null) goto L111;
        CameraMatchInfo r130 = r128.cameraMatchInfo;
        if (r130 == null) goto L111;
        long r131 = r130.getContentId();
    L113:
        if (r131 == r129) goto L118;
        if (r111 == null) goto L118;
        Map<String, String> r132 = r111.getMap();
        if (r132 == null) goto L118;
        r132.put("vs_content_id", r131 + "");
    L118:
        if (r123 == null) goto L125;
        if (r128 == null) goto L125;
        long r133 = r123.groupId;
        if (r133 != r128.groupId) goto L125;
        if (r133 <= 0) goto L125;
        boolean r134 = true;
    L127:
        if (r123 == null) goto L130;
    L130:
        if (r128 == null) goto L134;
    L134:
        if (this.f477592d.f559643d.g1() == false) goto L141;
        this.f477590b.f568056c.a4(r128, r108, r109, r127);
        com.bytedance.android.live.room.h r135 = this.f477592d.f559643d;
        if ((r135 instanceof IMultiCameraView) == false) goto L138;
        ((IMultiCameraView) r135).Ma(r110, r134, IMultiCameraView.Source.CameraChange);
    L138:
        ((IVSPlayerService) jc1.k.f(IVSPlayerService.class)).provideVSPlayerViewControlService(this.f477594f.f157610s).setVisibilityStatus(false);
        if ((this.f477592d.f559643d instanceof IMultiCameraView) == false) goto L154;
        ((IVSPlayerService) jc1.k.f(IVSPlayerService.class)).provideVSPlayerViewControlService(this.f477594f.f157610s).provideContext().setInitVisible(false);
        ((IMultiCameraView) this.f477592d.f559643d).X5(r110, r134, IMultiCameraView.Source.CameraChange);
    L154:
        VSJumpCameraEvent r136 = new VSJumpCameraEvent();
        r136.setMatchId(r125);
        r136.setCameraId(r124);
        xs2.b.a().post(new VSCameraChangeEvent(r136, r210));
        this.f477591c.f490223p.zq();
        return;
    L141:
        if (r109 == false) goto L143;
        this.f477590b.f568056c.x6(r128, r127);
    L144:
        if (r109 == true) goto L148;
        com.bytedance.android.live.room.h r137 = this.f477592d.f559643d;
        if ((r137 instanceof IMultiCameraView) == false) goto L148;
        ((IMultiCameraView) r137).Ma(r110, r134, IMultiCameraView.Source.CameraChange);
    L148:
        if (r109 == false) goto L150;
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) this.f477594f.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).Dq(new com.bytedance.android.livesdk.room.g(new HorizontalPlayEvent(1)));
    L150:
        if (r109 == true) goto L154;
        com.bytedance.android.live.room.h r138 = this.f477592d.f559643d;
        if ((r138 instanceof IMultiCameraView) == false) goto L154;
        ((IMultiCameraView) r138).X5(r110, r134, IMultiCameraView.Source.CameraChange);
        goto L154
    L143:
        this.f477590b.f568056c.a4(r128, false, false, r127);
    L125:
        r134 = false;
    L111:
        r131 = r129;
        goto L113
    L105:
        r128 = null;
        goto L106
    L99:
        if (r126 == r121) goto L101;
        r127 = true;
        goto L103
    L95:
        z().getCameraId().setValue(0L);
        goto L96
    L89:
        r123 = null;
        goto L90
    L42:
        r110 = false;
        goto L43
    L39:
        r109 = false;
        goto L40
    L13:
        if (((Boolean) r100.get("data_broadcast_pause_state_new", Boolean.FALSE)).booleanValue() == false) goto L16;
        f2.c("主播暂时离开，暂时无法切换", 0);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void q(com.bytedance.android.livesdk.room.b r110) {
        if (r110.getContext() == null) goto L20;
        RoomContext r100 = ((xh1.a) r110.a(xh1.a.class)).Ua();
        RoomSession r101 = this.f477591c.f490211d;
        if (r101 == null) goto L20;
        if (r101.getRoomId() == 0) goto L20;
        ALogger.i("PaidScopeUtil", String.format("VsRoomBusiness[%d] start room: %d", new Object[]{Integer.valueOf(r110.f510501h.hashCode()), Long.valueOf(this.f477591c.f490211d.getRoomId())}));
        LinkedHashMap<String, com.bytedance.android.livesdk.vscore_api.paidlive.scope.b> r102 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f159507a;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.c(this.f477591c.f490211d.getRoomId(), r110.f510501h.hashCode()) == false) goto L11;
        ALogger.i("PaidScopeUtil", String.format("VsRoomBusiness[%d] start room: %d, has check, skip", new Object[]{Integer.valueOf(r110.f510501h.hashCode()), Long.valueOf(this.f477591c.f490211d.getRoomId())}));
        LivePaidPlayerContainerWidget r103 = this.f477591c.f490223p;
        if (r103 == null) goto L20;
        r103.onStart();
        goto L20
    L11:
        if (kf0.f120598a.getValue().c() == true) goto L13;
    L14:
        ALogger.i("PaidScopeUtil", String.format("VsRoomBusiness[%d][%d] create paid scope in start room", new Object[]{Integer.valueOf(r110.f510501h.hashCode()), Long.valueOf(this.f477591c.f490211d.getRoomId())}));
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f(this.f477591c.f490211d.getRoomId(), r110.f510501h.hashCode(), (FragmentActivity) r110.getActivity(), r110.f510501h, r110.f157610s, new PaidRoomContext(r100), new fk1.a(this), new k(this));
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.c(this.f477591c.f490211d.getRoomId(), r110.f510501h.hashCode());
        LivePaidPlayerContainerWidget r104 = this.f477591c.f490223p;
        if (r104 == null) goto L20;
        r104.onStart();
        goto L20
    L13:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.b(this.f477591c.f490211d.f110610w) == true) goto L14;
    L20:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [fk1.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [fk1.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [fk1.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [fk1.c, java.lang.Object] */
    @Override // com.bytedance.android.livesdk.room.c
    public final void u(final com.bytedance.android.livesdk.room.b r110) {
        if (this.f477591c.f490211d == null) goto L8;
        nm1.s r100 = pm1.f.p();
        if (r100 == null) goto L8;
        r100.a(r110.f157610s, r110.f510497d);
    L8:
        if (pm1.f.a() == null) goto L35;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.room.b r101 = jk1.a.b(this.f477594f);
        DataCenter r102 = r110.f157610s;
        RoomContext r103 = z();
        ?? r104 = new r(this);
        ?? r105 = new s(this);
        ?? r106 = new b(this);
        com.bytedance.android.livesdk.log.j r107 = r101.f107273d;
        ContentDurationLogger r108 = r101.f107274e;
        ?? r109 = new c(this);
        int r111 = a5.f114406a;
        Intrinsics.checkNotNullParameter(r103, "roomContext");
        Intrinsics.checkNotNullParameter(r104, "getInteractionFragment");
        Intrinsics.checkNotNullParameter(r105, "getPlayerWidget");
        Intrinsics.checkNotNullParameter(r106, "getPaidPlayerWidget");
        Intrinsics.checkNotNullParameter(r109, "injectSwitchToPortrait");
        if (r102 == null) goto L33;
        dq1.a r112 = pm1.f.a();
        if (r112 == null) goto L15;
        r112.e4(r102, new u4(r104, r105, r109), r103.getCameraId().getValue().longValue());
    L15:
        dq1.a r113 = pm1.f.a();
        if (r113 == null) goto L18;
        r113.F4(new v4(r102));
    L18:
        dq1.a r114 = pm1.f.a();
        if (r114 == null) goto L21;
        r114.D4(new w4(r102, r103));
    L21:
        dq1.a r115 = pm1.f.a();
        if (r115 == null) goto L24;
        r115.D4(new x4());
    L24:
        dq1.a r116 = pm1.f.a();
        if (r116 == null) goto L27;
        r116.D4(new y4(r107, r108));
    L27:
        dq1.a r117 = pm1.f.a();
        if (r117 == null) goto L30;
        r117.D4(new z4(r102, r103, r106));
    L30:
        dq1.a r118 = pm1.f.a();
        if (r118 == null) goto L33;
        r118.D4(new VSMultiCameraDelegate$initMultiCameraService$7(r102, r103, r107, r108));
    L33:
        pm1.f.a().D4(new t(this));
    L35:
        if (this.f477591c.f490218k == true) goto L37;
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r110.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).L7(VSJumpCameraEvent.class, new d(this));
        ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r110.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).L7(ChangeCameraStreamEvent.class, new e(this));
    L37:
        r110.f("cmd_save_back_record_preview_info", new f(this, r110));
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void x(com.bytedance.android.livesdk.room.b r100) {
        if (pm1.f.r() == null) goto L6;
        pm1.f.r().g();
        vp1.e r101 = vp1.e.f556577a;
        DataCenter r102 = r100.f157610s;
    L6:
        if (pm1.f.a() == null) goto L8;
        pm1.f.a().x4(r100.f157610s);
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public void onEvent(ChangeCameraStreamEvent r100) {
        if (this.f477590b.f568056c != null) goto L5;
        return;
    L5:
        long r101 = this.f477591c.f490211d.getRoomId();
        if (r100.getRoomId() == r101) goto L8;
        return;
    L8:
        this.f477590b.f568056c.ZW(r100);
        if (TextUtils.isEmpty(r100.getCameraLoadingText()) == true) goto L13;
        int r102 = mj1.h.f514164a;
        mj1.a r103 = mj1.h.a(this.f477594f);
        if (r103 == null) goto L17;
        r103.gh(r100.getCameraLoadingText(), 0);
        return;
    L17:
        return;
    L13:
        String r104 = this.f477594f.f510501h.getResources().getString(R.string.ttlive_live_loading);
        int r105 = mj1.h.f514164a;
        mj1.a r106 = mj1.h.a(this.f477594f);
        if (r106 == null) goto L19;
        r106.gh(r104, 8);
        return;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void n(com.bytedance.android.livesdk.room.b r110, ts2.i r111) {
        if (r111.f547349b == RoomDataType.ALL_ROOM) goto L5;
    L61:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L5:
        if (q21.b() == false) goto L16;
        if (pm1.f.r() == null) goto L19;
        Room r112 = r110.f157611t;
        if (r112 == null) goto L19;
        if (r112.isMergeVSRoom() == false) goto L13;
    L14:
        pm1.f.r().g();
        vp1.e.f556577a.d(this.f477591c.f490211d, r110.f157611t, r110.f157610s);
        goto L19
    L13:
        if (r110.f157611t.isMediaRoom() == true) goto L14;
    L19:
        if (r110.f157611t == null) goto L37;
        AbsLivePlayerView r113 = this.f477590b.f568061h;
        if (r113 == null) goto L37;
        if (r113.getRenderView() == null) goto L37;
        if (r110.f157611t.isMergeVSRoom() == true) goto L29;
        if (m50.f120732a.getValue().k() == false) goto L29;
    L32:
        boolean r114 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.v(this.f477590b.f568061h.getRenderView().getSelfView());
        long r100 = this.f477591c.f490211d.getRoomId();
        ALogger.i("MatchRoomAnimUtil", "setRoomId : " + r100);
        MatchRoomLandScapeAnimUtil.f82851t = r100;
        MatchRoomLandScapeAnimUtil.s((FragmentActivity) r110.getActivity());
        if (m50.f120732a.getValue().i() == false) goto L35;
        MatchRoomLandScapeAnimUtil.w(new a(this.f477590b));
        goto L37
    L35:
        MatchRoomLandScapeAnimUtil.w(new u(this));
    L29:
        if (r110.f157611t.isMergeVSRoom() == false) goto L37;
        if (nt.f120858a.getValue().booleanValue() == true) goto L32;
    L37:
        if (kf0.f120598a.getValue().c() == false) goto L47;
        ALogger.i("PaidScopeUtil", String.format("VsRoomBusiness[%d] onRoomEnterV2: %d", new Object[]{Integer.valueOf(r110.f510501h.hashCode()), Long.valueOf(r110.f157611t.getRoomId())}));
        LinkedHashMap<String, com.bytedance.android.livesdk.vscore_api.paidlive.scope.b> r101 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f159507a;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.b(r110.f157611t) == false) goto L47;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.c(r110.f157611t.getRoomId(), r110.f510501h.hashCode()) == false) goto L43;
        ALogger.i("PaidScopeUtil", String.format("VsRoomBusiness[%d] onRoomEnterV2: %d has check, skip", new Object[]{Integer.valueOf(r110.f510501h.hashCode()), Long.valueOf(r110.f157611t.getRoomId())}));
    L44:
        LivePaidPlayerContainerWidget r115 = this.f477591c.f490223p;
        if (r115 == null) goto L47;
        r115.yq("onRoomEnterV2");
        r115.Aq();
        goto L47
    L43:
        ALogger.i("PaidScopeUtil", String.format("VsRoomBusiness[%d][%d] create paid scope in onRoomEnterV2", new Object[]{Integer.valueOf(r110.f510501h.hashCode()), Long.valueOf(r110.f157611t.getRoomId())}));
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f(r110.f157611t.getRoomId(), r110.f510501h.hashCode(), (FragmentActivity) r110.getActivity(), this.f477594f.f510501h, r110.f157610s, new PaidRoomContext(jk1.a.d(r110)), new g(this), new h(this));
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.c(r110.f157611t.getRoomId(), r110.f510501h.hashCode());
    L47:
        com.bytedance.android.livesdk.vscore_api.paidlive.c r116 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r110.f157610s);
        if (r116.J0().j(r110.f157611t, null) == false) goto L50;
    L51:
        com.bytedance.android.livesdk.vscore_api.paidlive.g r102 = com.bytedance.android.livesdk.vscore_api.paidlive.g.f159443e;
        if (com.bytedance.android.livesdk.vscore_api.paidlive.g.f159440b != null) goto L54;
        r102.initTrace(new com.bytedance.android.livesdk.chatroom.paidlive.a(r110.f157610s));
    L54:
        HashMap r103 = new HashMap();
        r103.put("flag_secure_status", "true");
        r102.trace("paidlive_audience_flag_secure_status_check", r103, new HashMap(), PaidSceneViewEntry.IN_ROOM.name(), PaidSceneEnum.ALL.name());
    L55:
        DataCenter r104 = r110.f157610s;
        if (r104 == null) goto L59;
        r104.put("data_audience_backtrace_service", new BacktrackServiceImp(r104, r110.f157611t));
    L59:
        if (r110.f157611t == null) goto L61;
        boolean r117 = r116.J0().j(r110.f157611t, null);
        boolean r105 = t3.f159166a;
        Intrinsics.checkNotNullParameter("onRoomEnter", "scene");
        t3.f159169d = r117;
        t3.a("setPaidLive_onRoomEnter");
        goto L61
    L50:
        if (r116.Y0(PaidSceneEnum.ALL) == false) goto L55;
    L16:
        if (pm1.f.r() == null) goto L19;
        pm1.f.r().g();
        vp1.e.f556577a.d(this.f477591c.f490211d, r110.f157611t, r110.f157610s);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(com.bytedance.android.livesdk.room.b r110, ts2.f r111) {
        long r100 = r110.f510497d.getLong(VSConstants.EXTRA_VS_CAMERA_ID, 0);
        jk1.a.d(r110).getCameraId().setValue(Long.valueOf(r100));
        r110.f157610s.put("cmd_vs_room_enter_in_cameraid", Long.valueOf(r100));
        if (com.bytedance.android.livesdk.summer.e.f158450a == true) goto L5;
    L7:
        boolean r112 = false;
    L8:
        if (r112 == false) goto L10;
        Pair r113 = (Pair) com.bytedance.android.livesdk.summer.a.f158439b.lookup(com.bytedance.android.livesdk.summer.e.f158457h, Pair.class, new l());
    L11:
        com.bytedance.live.datacontext.d.c((PlayerProgressServiceContext) r113.getFirst(), Integer.valueOf(r110.f157610s.hashCode() + 483071972));
        ((PlayerProgressServiceContext) r113.getFirst()).getInitSeekTime().d(Long.valueOf(r110.f510497d.getLong(VSConstants.EXTRA_MATCH_SEEK_TIME, -1)));
        if (r110.f510497d.getLong("multitab_select_tabid", 0) == 0) goto L49;
    L18:
        r110.f157610s.put("collection_id", r110.f510497d.getString("collection_id", ""));
        if (TextUtils.isEmpty(r110.f510497d.getString("collection_id", "")) == false) goto L22;
        r110.f157610s.put("collection_id", String.valueOf(r110.f510497d.getLong("collection_id", 0)));
    L22:
        if (kf0.f120598a.getValue().c() == true) goto L30;
        RoomContext r101 = ((xh1.a) r110.a(xh1.a.class)).Ua();
        ILivePlayerClient r102 = this.f477590b.f568057d;
        if (r102 == null) goto L30;
        if (r102.businessManager() == null) goto L30;
        RoomSession r103 = this.f477591c.f490211d;
        if (r103 == null) goto L30;
        LinkedHashMap<String, com.bytedance.android.livesdk.vscore_api.paidlive.scope.b> r104 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f159507a;
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f(r103.getRoomId(), r110.f510501h.hashCode(), (FragmentActivity) r110.getActivity(), r110.f510501h, r110.f157610s, new PaidRoomContext(r101), new n(this), new o(this));
    L30:
        RoomContext r105 = jk1.b.c(r110);
        r105.getSharePlatform().setValue(r110.f510497d.getString(VSConstants.EXTRA_VS_SHARE_PLATFORM, ""));
        String r106 = r110.f510497d.getString(ILiveRoomPlayFragmentConstant.EXTRA_IM_CHANNEL_INVITE_ID);
        if (r106 != null) goto L33;
    L37:
        jc1.g r107 = (jc1.g) BundleCompat.getBinder(r110.f510497d, "live.intent.extra.ENTER_LIVE_EXTRA");
        if ((r107 instanceof jc1.g) == false) goto L42;
        Object r108 = r107.f498078a;
        if ((r108 instanceof Bundle) == false) goto L42;
        String r109 = ((Bundle) r108).getString("comment_id");
        r110.f157610s.put("comment_id", r109);
    L42:
        r110.f157610s.put(ILiveRoomPlayFragmentConstant.INTERACT_FEED_VIEW_SEI, r110.f510497d.getString(ILiveRoomPlayFragmentConstant.INTERACT_FEED_VIEW_SEI, ""));
        r110.f510497d.putString(ILiveRoomPlayFragmentConstant.INTERACT_FEED_VIEW_SEI, "");
        RoomSession r114 = this.f477591c.f490211d;
        if (r114 == null) goto L45;
        r110.f157610s.put("data_is_mic_room_pseudo_living", Boolean.valueOf(r114.isPseudo()));
    L45:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L33:
        if (r106.length() <= 0) goto L37;
        long r115 = CastLongProtector.parseLong(r106.trim());     // Catch: NumberFormatException -> L36
        String r116 = r110.f510497d.getString("enter_from_merge");     // Catch: NumberFormatException -> L36
        r105.getImChannelInviteId().setValue(new d3(r115, r116));     // Catch: NumberFormatException -> L36
    L36:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.h(r106);
        goto L37
    L49:
        Long r117 = Long.valueOf(CastLongProtector.parseLong(r110.f510497d.getString("multitab_select_tabid", "")));     // Catch: NumberFormatException -> L16
        r110.f157610s.put("multitab_select_tabid", r117);     // Catch: NumberFormatException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L10:
        r113 = com.bytedance.live.datacontext.d.a(new m());
        goto L11
    L5:
        if (com.bytedance.android.livesdk.summer.e.f158453d == false) goto L7;
        r112 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(com.bytedance.android.livesdk.room.b r100, ContainerLifecycle r101, ts2.a r102) {
        hk1.a r103 = (hk1.a) r100.b("RoomDataConst_live_room_widget_context");
        if (r101 != ContainerLifecycle.ON_VIEW_CREATE) goto L28;
        LiveMode r104 = this.f477591c.f490211d.getStreamType();
        c6 r105 = com.bytedance.android.livesdk.config.setting.d.f121208a;
        Intrinsics.checkNotNullParameter(r104, "mode");
        Intrinsics.checkNotNullParameter("LivePaidPlayerContainer", "widget");
        boolean r106 = false;
        if (r104 != LiveMode.SCREEN_RECORD) goto L19;
        c6 r107 = com.bytedance.android.livesdk.config.setting.d.f121208a;
        if (r107.b() == false) goto L19;
        List<String> r108 = r107.d();
        if (r108 != null) goto L12;
    L14:
        boolean r109 = false;
    L15:
        if (r109 == true) goto L17;
    L20:
        boolean r110 = !r109;
        if (this.f477591c.f490211d.G == true) goto L23;
    L25:
        if (r110 == false) goto L28;
        this.f477591c.f490223p = new LivePaidPlayerContainerWidget(this.f477591c.f490211d);
        LivePaidPlayerContainerWidget r111 = this.f477591c.f490223p;
        ViewGroup r112 = this.f477590b.f568062i;
        r111.f112265c = r112;
        r111.yq("setPlayerContainer view=" + r112);
        LivePaidPlayerContainerWidget r113 = this.f477591c.f490223p;
        r113.f112264b = this.f477590b.f568061h;
        r113.f112266d = new p(this);
        r103.f485523c.load(r113, !r106);
        goto L28
    L23:
        if (wt2.h.f() == false) goto L25;
        r106 = true;
        goto L25
    L17:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
        goto L20
    L12:
        if (r108.contains("LivePaidPlayerContainer") != true) goto L14;
        r109 = true;
    L19:
        r109 = false;
    L28:
        if (r101 != ContainerLifecycle.ON_STOP) goto L42;
        if (VSMediaUIConfigHelper.b(r100.f157610s) == false) goto L42;
        ILivePlayerClient r114 = this.f477590b.f568057d;
        if (r114 == null) goto L42;
        if (r114.getHasAudioFocus() == false) goto L42;
        if (((IRoomService) jc1.k.f(IRoomService.class)).isStopPlayingOnBg() == false) goto L38;
    L40:
        xs2.b.a().post(new h1(47));
        goto L42
    L38:
        if (VideoFloatWindowManager.f125075f.f125265a == false) goto L40;
        ALogger.i("VsRoomBusiness", "节目直播间退后台不暂停播放音频");
    L42:
        if (r101 != ContainerLifecycle.ON_DESTROY) goto L56;
        DataCenter r115 = r100.f157610s;
        if (r115 == null) goto L47;
        r115.put("cmd_vs_room_enter_in_cameraid", 0L);
    L47:
        if (x10.f121571a.getValue().booleanValue() == true) goto L50;
        com.bytedance.android.livesdk.chatroom.ssposter.util.c.f111580n.getClass();
        com.bytedance.android.livesdk.chatroom.ssposter.util.c.f111579m = null;
    L50:
        if (jc1.k.f(IVSPlayerService.class) == null) goto L52;
        ((IVSPlayerService) jc1.k.f(IVSPlayerService.class)).releaseService(r100.f157610s);
    L52:
        LinkedHashMap<String, com.bytedance.android.livesdk.vscore_api.paidlive.scope.b> r116 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f159507a;
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.i(this.f477591c.f490211d.getRoomId(), r100.f510501h.hashCode(), PaidSceneViewEntry.IN_ROOM);
        if (pm1.f.a() == null) goto L56;
        pm1.f.a().x4(r100.f157610s);
    L56:
        if (r101 != ContainerLifecycle.ROOM_DISPOSE_CONTEXT) goto L62;
        LinkedHashMap<String, com.bytedance.android.livesdk.vscore_api.paidlive.scope.b> r117 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.f159507a;     // Catch: Exception -> L59
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.f.i(r100.f510496c.longValue(), r100.f510501h.hashCode(), PaidSceneViewEntry.IN_ROOM);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        SafetyGuard.a(null, e, "leave paid scope error");
    L62:
        if (r101 != ContainerLifecycle.ON_STOP_ROOM_WITHOUT_RELEASE_PLAYER) goto L67;
        if (pm1.f.r() == null) goto L67;
        pm1.f.r().g();
        vp1.e r118 = vp1.e.f556577a;
    L67:
        if (r101 == ContainerLifecycle.ON_INTERACTION_UPDATE_ROOM) goto L69;
    L75:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L69:
        if (this.f477593e != null) goto L75;
        Room r119 = r100.f157611t;
        if (r119 == null) goto L75;
        if (r119.isMergeVSRoom() == false) goto L75;
        ResolutionServiceWidget r120 = new ResolutionServiceWidget(this.f477591c.f490211d);
        this.f477593e = r120;
        r120.f161250f = new q(this);
        r103.f485523c.load(r120);
        goto L75
    }
}
