package zj1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.m6;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomMetrics;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.room.j;
import com.bytedance.android.livesdk.chatroom.room.m;
import com.bytedance.android.livesdk.chatroom.room.n;
import com.bytedance.android.livesdk.chatroom.room.o;
import com.bytedance.android.livesdk.chatroom.room.p;
import com.bytedance.android.livesdk.chatroom.room.q;
import com.bytedance.android.livesdk.chatroom.utils.k5;
import com.bytedance.android.livesdk.chatroom.utils.s;
import com.bytedance.android.livesdk.chatroom.viewmodel.SmoothLeavePreLiveContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.UserRoomActionContext;
import com.bytedance.android.livesdk.chatroom.widget.d2;
import com.bytedance.android.livesdk.config.k90;
import com.bytedance.android.livesdk.config.lp0;
import com.bytedance.android.livesdk.config.ws0;
import com.bytedance.android.livesdk.config.xs0;
import com.bytedance.android.livesdk.config.ys0;
import com.bytedance.android.livesdk.floatview.NewVideoInnerFloatManager;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.player.event.PlayerNextLiveData;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.IRoomEventListener;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.XTabRoomCacheService;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ik1.c f572427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yj1.a f572428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.room.b f572429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SmoothLeavePreLiveContext f572430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f572431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f572432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public sg1.a f572433g;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f572434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f572435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f572436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f572437d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f572437d.e();
            if (this.f572437d.f572429c.getActivity() == null) goto L14;
            RoomSession r101 = this.f572437d.f572427a.f490211d;
            if (r101 != null) goto L7;
        L13:
            Activity r102 = this.f572437d.f572429c.getActivity();
            boolean r103 = this.f572434a;
            final int r104 = this.f572435b;
            final String r105 = this.f572436c;
            k5.a(r102, r103, new e(this, r104, r105));
            return;
        L7:
            if (r101.isSmoothLeaveDoubleRender() == false) goto L13;
            gs0.a r106 = this.f572437d.f572428b.f568059f;
            if (r106 == null) goto L13;
            if (r106.f482432a == true) goto L13;
            r106.b(true);
            f r107 = this.f572437d;
            r107.getClass();
            TTLiveSDK.hostService().hostBusiness().resumePreviewPlay(r107.f572427a.f490211d.getRoomId());
            goto L13
        L14:
            f.b(this.f572437d, this.f572435b, this.f572436c);
        }

        public a(f r100, boolean r101, int r102, String r103) {
            this.f572437d = r100;
            this.f572434a = r101;
            this.f572435b = r102;
            this.f572436c = r103;
        }
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // zj1.b
    public final h N6() {
        return new h(this);
    }

    public final void e() {
        if (xs0.f121629a.getValue().mEnableCover == true) goto L6;
        return;
    L6:
        if (this.f572430d != null) goto L8;
        this.f572430d = (SmoothLeavePreLiveContext) com.bytedance.live.datacontext.d.d("data_smooth_leave_live_context");
    L8:
        SmoothLeavePreLiveContext r100 = this.f572430d;
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.getSmoothLeavePre() != null) goto L13;
        return;
    L13:
        if (this.f572429c.f157611t == null) goto L18;
        k<SmoothLeavePreLiveContext.a> r101 = this.f572430d.getSmoothLeavePre();
        this.f572429c.f157611t.getRoomId();
        r101.post(new SmoothLeavePreLiveContext.a());
        return;
    }

    @Override // zj1.b
    public final boolean l4() {
        return this.f572431e.booleanValue();
    }

    @Override // zj1.b
    public final void resetSmoothDoubleRenderSurface() {
        ILivePlayerClient r100 = this.f572428b.f568057d;
        if (r100 == null) goto L5;
        r100.resetSmoothDoubleRenderSurface();
        ALogger.d("RoomPlayerService", this.f572429c.f510501h.hashCode() + "resetSmoothDoubleRender player");
    L5:
        gs0.a r101 = this.f572428b.f568059f;
        if (r101 == null) goto L9;
        r101.a(false);
        this.f572428b.f568059f.b(false);
        ALogger.d("RoomPlayerService", this.f572429c.f510501h.hashCode() + "resetSmoothDoubleRender object");
        return;
    }

    @Override // zj1.b
    public final as0.a roomPlayerContext() {
        is2.d r100 = this.f572427a.f490210c;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100.roomPlayerContext() instanceof as0.a) == true) goto L8;
        return null;
    L8:
        return (as0.a) this.f572427a.f490210c.roomPlayerContext();
    }

    @Override // zj1.b
    public final void stopPlayerForNextRoomPrePullStream() {
        ((c) this.f572429c.a(c.class)).Sk();
        RoomSession r100 = this.f572427a.f490211d;
        if (r100 == null) goto L8;
        r100.setStopPlayerForNextRoomPrePullStream(true);
        LivePlatformPlayerManager.c(this.f572427a.f490211d.getRoomId(), this.f572427a.f490211d.isPseudo()).f(false, null);
        if (lp0.f120699a.getValue().booleanValue() == false) goto L9;
        this.f572431e = Boolean.FALSE;
        return;
    L9:
        return;
    }

    @Override // zj1.b
    public final boolean In(String r100) {
        if (this.f572428b.f568057d != null) goto L6;
        return false;
    L6:
        if (((c) this.f572429c.a(c.class)).Pk() == false) goto L8;
        return false;
    L8:
        as0.a r101 = roomPlayerContext();
        if (r101 != null) goto L11;
        return false;
    L11:
        return r101.u(r100, this.f572427a.f490211d);
    }

    @Override // zj1.b
    public final boolean Oh(Runnable r100) {
        RoomSession r101 = this.f572427a.f490211d;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.getMicRoomPrePullId() == 0) goto L8;
        long r102 = this.f572427a.f490211d.getMicRoomPrePullId();
    L9:
        ILivePlayerClient r103 = LivePlatformPlayerManager.a(r102, this.f572427a.f490211d.isPseudo());
        if (r103 == null) goto L81;
        yj1.a r104 = this.f572428b;
        if (r103 == r104.f568057d) goto L81;
        r104.f568057d = r103;
        if (com.bytedance.android.live.platformplayer.utils.c.a(this.f572427a.f490211d) == false) goto L16;
        this.f572428b.f568057d.clearObservers();
    L16:
        LiveRoomMetrics r105 = this.f572427a.f490211d.B();
        LifecycleOwner r106 = r105.D.X;
        if (r106 == null) goto L76;
        IRoomEventHub r107 = r105.c();
        MutableLiveData<Boolean> r108 = null;
        if (r107 == null) goto L22;
        MutableLiveData<Boolean> r109 = r107.getPlaying();
    L24:
        if ((r109 instanceof PlayerNextLiveData) == true) goto L26;
        r109 = null;
    L26:
        PlayerNextLiveData r110 = (PlayerNextLiveData) r109;
        if (r110 == null) goto L29;
        r110.observe(r106, new com.bytedance.android.livesdk.chatroom.room.h(r105), true);
    L29:
        IRoomEventHub r111 = r105.c();
        if (r111 == null) goto L32;
        MutableLiveData<Boolean> r112 = r111.getFirstFrame();
    L34:
        if ((r112 instanceof PlayerNextLiveData) == false) goto L37;
        r108 = r112;
    L37:
        PlayerNextLiveData r113 = (PlayerNextLiveData) r108;
        if (r113 == null) goto L40;
        r113.observe(r106, new com.bytedance.android.livesdk.chatroom.room.i(r105), true);
    L40:
        IRoomEventHub r114 = r105.c();
        if (r114 == null) goto L45;
        MutableLiveData<JSONObject> r115 = r114.getPlayMonitorLog();
        if (r115 == null) goto L45;
        r115.observe(r106, new j(r105));
    L45:
        r105.E.getStartPull().observe(r106, new com.bytedance.android.livesdk.chatroom.room.k(r105));
        IRoomEventHub r116 = r105.c();
        if (r116 == null) goto L50;
        MutableLiveData<String> r117 = r116.getPlayerMediaError();
        if (r117 == null) goto L50;
        r117.observe(r106, new m(r105));
    L50:
        IRoomEventHub r118 = r105.c();
        if (r118 == null) goto L55;
        MutableLiveData<Boolean> r119 = r118.getStallStart();
        if (r119 == null) goto L55;
        r119.observe(r106, new n(r105));
    L55:
        IRoomEventHub r120 = r105.c();
        if (r120 == null) goto L60;
        MutableLiveData<Boolean> r121 = r120.getStallEnd();
        if (r121 == null) goto L60;
        r121.observe(r106, new o(r105));
    L60:
        IRoomEventHub r122 = r105.c();
        if (r122 == null) goto L65;
        MutableLiveData<IRenderView> r123 = r122.getBindRenderView();
        if (r123 == null) goto L65;
        r123.observe(r106, new p(r105));
    L65:
        IRoomEventHub r124 = r105.c();
        if (r124 == null) goto L70;
        MutableLiveData<Boolean> r125 = r124.getSurfaceReady();
        if (r125 == null) goto L70;
        r125.observe(r106, new q(r105));
    L70:
        IRoomEventHub r126 = r105.c();
        if (r126 == null) goto L76;
        MutableLiveData<Boolean> r127 = r126.getSurfaceControlChange();
        if (r127 == null) goto L76;
        r127.observe(r106, new com.bytedance.android.livesdk.chatroom.room.g(r105));
        goto L76
    L32:
        r112 = null;
        goto L34
    L22:
        r109 = null;
    L76:
        if (com.bytedance.android.live.platformplayer.utils.c.a(this.f572427a.f490211d) == false) goto L78;
        this.f572428b.f568057d.clearObservers();
    L78:
        if (r100 == null) goto L80;
        r100.run();
    L80:
        return true;
    L81:
        return false;
    L8:
        r102 = this.f572427a.f490211d.getRoomId();
        goto L9
    }

    public final void d(String r100) {
        ALogger.e("RoomPlayerService", "multi_linker_sei clear first sei from ".concat(r100));
        yj1.a r101 = this.f572428b;
        r101.f568064k = false;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r101.f568066m = "";
    }

    @Override // zj1.b
    public final void ensureMute(boolean r100) {
        is2.d r101 = this.f572427a.f490210c;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101.roomPlayerContext() instanceof as0.a) == false) goto L17;
        ILivePlayerClient r102 = ((as0.a) this.f572427a.f490210c.roomPlayerContext()).player();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r100 != r102.isMute()) goto L12;
        return;
    L12:
        if (r100 == false) goto L14;
        r102.mute("RoomPlayerService.ensureMute");
        ALogger.e("RoomPlayerService", "switchFarawayPlayer ensureMute mute");
        return;
    L14:
        r102.unmute("RoomPlayerService.ensureMute");
        ALogger.e("RoomPlayerService", "switchFarawayPlayer ensureMute unmute");
        return;
    }

    public final void h(AnimatorListenerAdapter r100) {
        this.f572429c.f510505l.findViewById(R.id.fragment_container).animate().alpha(0.0f).setDuration(300).setListener(r100).start();
    }

    @Override // zj1.b
    public final void mutePlayerClient(boolean r100) {
        is2.d r101 = this.f572427a.f490210c;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101.roomPlayerContext() instanceof as0.a) == false) goto L14;
        ILivePlayerClient r102 = ((as0.a) this.f572427a.f490210c.roomPlayerContext()).player();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r100 == false) goto L11;
        r102.mute("RoomPlayerService.mutePlayerClient");
        return;
    L11:
        r102.unmute("RoomPlayerService.mutePlayerClient");
        return;
    }

    public final void f(int r100, String r101) {
        ik1.c r102 = this.f572427a;
        ii1.a r103 = r102.f490214g;
        if (r103 != null) goto L5;
    L9:
        DataCenter r104 = this.f572429c.f157610s;
        boolean r105 = false;
        if (r104 != null) goto L12;
    L14:
        boolean r106 = false;
    L15:
        com.bytedance.android.livesdk.floatview.q r107 = NewVideoInnerFloatManager.f125055p;
        NewVideoInnerFloatManager.b.a().d();
        NewVideoInnerFloatManager r108 = NewVideoInnerFloatManager.b.a();
        r108.f125072o = false;
        r108.f125071n.unInitAbility();
        r108.f125070m.clear();
        Bundle r109 = this.f572429c.f510497d;
        com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session.a r110 = null;
        if (s.f114612a.booleanValue() == false) goto L31;
        if (r109 == null) goto L19;
        Bundle r111 = m0.a(r109);
    L20:
        if (r111 == null) goto L23;
        String r112 = r111.getString(ILiveRoomPlayFragmentConstant.EXTRA_MULTI_TAB_SUB_UNIQUE_LABEL, "");
        if (r112 == null) goto L23;
    L24:
        if (r111 == null) goto L27;
        r105 = r111.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_FROM_XTAB, false);
    L27:
        if (XTabRoomCacheService.validTabLabel(r112) == false) goto L30;
        if (r105 == false) goto L30;
        XTabRoomCacheService.INSTANCE.getCurrentMultiTabRoomCache(r112).positionChange();
    L32:
        System.currentTimeMillis();
        jk1.a.d(this.f572429c).getEnterRoomTime().getValue().longValue();
        if (r106 == false) goto L42;
        if (r100 != 8) goto L37;
    L38:
        k90 r113 = k90.f120583a;
        if (r113.getValue().enableMinimize == false) goto L42;
        int r114 = r113.getValue().watchDuration;
        goto L42
    L37:
        if (r100 == 78) goto L38;
    L42:
        if (jc1.k.f(IKtvService.class) == null) goto L44;
        ((IKtvService) jc1.k.f(IKtvService.class)).saveEnterRoomType(this.f572429c.f510497d.getString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, ""));
    L44:
        is2.d r115 = this.f572427a.f490210c;
        if (r115 == null) goto L47;
        r115.endRoomV2(EndReason.USER_CLOSE.INSTANCE, "key_user_close_source", r101);
    L47:
        com.bytedance.android.livesdk.room.b r116 = this.f572429c;
        if (r116 == null) goto L51;
        r110 = ((dk1.a) r116.a(dk1.a.class)).N8();
    L51:
        r110.Cw(this.f572428b.f568057d);
        return;
    L30:
        XTabRoomCacheService.INSTANCE.positionChange();
    L23:
        r112 = "";
        goto L24
    L19:
        r111 = null;
        goto L20
    L31:
        XTabRoomCacheService.INSTANCE.positionChange();
        goto L32
    L12:
        if (((Boolean) r104.get("cmd_end_live", Boolean.FALSE)).booleanValue() == true) goto L14;
        r106 = true;
        goto L15
    L5:
        if (r102.f490211d.f110607t != LiveRoomState.LIVE_STARTED) goto L9;
        r103.m(EndReason.USER_CLOSE.INSTANCE);
        if (jk1.a.d(this.f572429c).isVSFirstShow() == true) goto L9;
        this.f572427a.f490214g.j();
        goto L9
    }

    @Override // zj1.b
    public final void prePullStream(boolean r100, String r101) {
        if (this.f572427a.f490210c != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f572429c.f157610s).J0().p(this.f572429c.f510497d) == false) goto L9;
        return;
    L9:
        if (((com.bytedance.android.live.livepullstream.service.c) ((IPullStreamService) jc1.k.f(IPullStreamService.class)).getLivePlayerOptimizer()).a() == false) goto L13;
        RoomSession r102 = this.f572427a.f490211d;
        if (r102 == null) goto L13;
        r102.setStopPlayerForNextRoomPrePullStream(false);
    L13:
        Bundle r103 = this.f572429c.f510497d;
        if (r103 != null) goto L33;
    L21:
        this.f572432f = !r100;
        this.f572427a.f490210c.prePullStreamV2(r101, r100);
        if (lp0.f120699a.getValue().booleanValue() == false) goto L25;
        this.f572431e = Boolean.TRUE;
    L25:
        if (m6.f65361a.getValue().booleanValue() == false) goto L31;
        d("clearFirstSeiWhenStartPull");
        gs0.c r104 = this.f572428b.f568056c;
        if (r104 == null) goto L30;
        r104.qQ();
    L30:
        this.f572428b.f568065l = false;
    L31:
        ((sj1.a) this.f572429c.a(sj1.a.class)).fq(this.f572429c, this.f572428b);
        return;
    L33:
        String r105 = r103.getString(ILiveRoomPlayFragmentConstant.EXTRA_PICO_ROOM_BG_INFO, "");     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r105) == true) goto L21;
        this.f572427a.f490211d.setPicoInfo(new JSONObject(r105));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        ALogger.d("RoomPlayerService", "Set picoInfo for mLiveRoomCommonContext.getRoomSession() encountered error:  " + e.getMessage());
        this.f572427a.f490211d.setPicoInfo(null);
        goto L21
    }

    public static void b(f r100, int r101, String r102) {
        as0.a r103 = LivePlatformPlayerManager.e(r100.f572427a.f490211d.getRoomId(), r100.f572427a.f490211d.isPseudo());
        Activity r104 = r100.f572429c.getActivity();
        if (r103 != null) goto L5;
    L8:
        IRoomEventListener r105 = jk1.a.h(r100.f572429c).getRealAction().roomEventListener();
        if (r105 == null) goto L11;
        r105.onSmoothLeaveRoom();
    L11:
        r100.f(r101, r102);
        return;
    L5:
        if (r103.p(EndReason.USER_CLOSE.INSTANCE) == false) goto L8;
        if (r104 == null) goto L8;
        r104.getIntent().putExtra(ILiveRoomPlayFragmentConstant.EXTRA_SMOOTH_LEAVE, true);
        goto L8
    }

    public final void g(final int r100, boolean r110, final String r111) {
        UserRoomActionContext.Companion.getClass();
        UserRoomActionContext r101 = UserRoomActionContext.a.a();
        if (r101 == null) goto L8;
        if (r101.getOnLeave() == null) goto L8;
        r101.getOnLeave().post(Boolean.TRUE);
    L8:
        if (this.f572429c.getActivity() == null) goto L71;
        jk1.a.d(this.f572429c).getUserClose().post(Boolean.TRUE);
        ((ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class)).notifyUserClose();
        RoomSession r102 = this.f572427a.f490211d;
        if (r102 == null) goto L34;
        boolean r103 = false;
        if (r102.isSmoothEnterDoubleRender() == false) goto L33;
        ILivePlayerClient r104 = this.f572428b.f568057d;
        List<String> r105 = wt2.g.f561188a;
        boolean r106 = ws0.f121550a.getValue().enableSmoothLeave;
        ALogger.i("SmoothDoubleRender_Helper", "canSmoothLeave() >>> abConfig=" + r106);
        if (r106 == true) goto L16;
    L30:
        boolean r107 = false;
    L31:
        if (r107 == false) goto L33;
        r103 = true;
        goto L33
    L16:
        if (wt2.g.b(r104) == false) goto L30;
        if (r104 == null) goto L21;
        IRenderView r108 = r104.getRenderView();
        if (r108 == null) goto L21;
        ViewParent r109 = r108.getParent();
    L23:
        if ((r109 instanceof LivePlayerView) == true) goto L25;
        r109 = null;
    L25:
        LivePlayerView r112 = (LivePlayerView) r109;
        if (r112 == null) goto L30;
        if (r112.isEnableDelayStopOrRelease() != true) goto L30;
        r107 = true;
    L21:
        r109 = null;
    L33:
        r102.setSmoothLeaveDoubleRender(r103);
    L34:
        AbsLivePlayerView r113 = this.f572428b.f568061h;
        if (r113 != null) goto L37;
    L39:
        sg1.a r114 = this.f572433g;
        if (r114 == null) goto L42;
        r114.a(true);
        this.f572433g = null;
    L42:
        RoomSession r115 = this.f572427a.f490211d;
        if (r115 == null) goto L54;
        if (r115.isSmoothLeaveDoubleRender() == true) goto L54;
        IRenderView r116 = this.f572428b.f568057d.getRenderView();
        if ((r116 instanceof SurfaceRenderView) == false) goto L54;
        SurfaceRenderView r117 = (SurfaceRenderView) r116;
        if (r117.hasSurfaceControlAttached() == false) goto L54;
        if (ws0.f121550a.getValue().getSurfaceControlBitmapSmoothLeave() == false) goto L54;
        r117.drawFrameWhenSurfaceControlReplace = true;
    L54:
        if (ys0.f121713a.getValue().booleanValue() == false) goto L56;
        h(new a(this, r110, r100, r111));
    L66:
        d2 r118 = ((bk1.a) this.f572429c.b("RoomDataConst_live_room_rev_container_context")).f19293d;
        if (r118 == null) goto L72;
        r118.a("leave");
        return;
    L72:
        return;
    L56:
        e();
        RoomSession r119 = this.f572427a.f490211d;
        if (r119 != null) goto L59;
    L65:
        k5.a(this.f572429c.getActivity(), r110, new d(this, r100, r111));
        goto L66
    L59:
        if (r119.isSmoothLeaveDoubleRender() == false) goto L65;
        gs0.a r120 = this.f572428b.f568059f;
        if (r120 == null) goto L65;
        if (r120.f482432a == true) goto L65;
        r120.b(true);
        TTLiveSDK.hostService().hostBusiness().resumePreviewPlay(this.f572427a.f490211d.getRoomId());
        goto L65
    L37:
        if ((r113.getRenderView() instanceof SurfaceView) == false) goto L39;
        ((com.bytedance.android.live.platformplayer.service.a) jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class)).F4(this.f572428b.f568057d);
        goto L39
    }

    public f(ik1.c r100, yj1.a r101, com.bytedance.android.livesdk.room.b r102, sg1.a r103) {
        this.f572431e = Boolean.FALSE;
        this.f572432f = false;
        ((IHostBusiness) jc1.k.f(IHostBusiness.class)).getLiveMinimizeService();
        this.f572427a = r100;
        this.f572428b = r101;
        this.f572429c = r102;
        this.f572433g = r103;
    }
}
