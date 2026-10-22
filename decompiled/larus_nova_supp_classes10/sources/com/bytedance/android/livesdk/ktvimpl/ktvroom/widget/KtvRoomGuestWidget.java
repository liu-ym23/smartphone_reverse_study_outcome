package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVoiceWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionWidget;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.KtvRoomInteractEmojiPanel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomGuestPresenter;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.service.KtvGuestDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.service.KtvRoomGlobalDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.logger.PanelType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkmicMediaParam;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b:\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvRoomGuestWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseGuestLinkWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/presenter/KtvRoomGuestPresenter$IView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/live/liveinteract/voicechat/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/service/d;", "Lkk0/f;", "Lcom/bytedance/android/live/ktv/common/util/l;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/service/e;", "a", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomGuestWidget extends MultiLinkVoiceBaseGuestLinkWidget implements KtvRoomGuestPresenter.IView, WeakHandler.IHandler, com.bytedance.android.live.liveinteract.voicechat.a, Observer<KVData>, com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d, kk0.f, com.bytedance.android.live.ktv.common.util.l, com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e {
    public static final /* synthetic */ int G2 = 0;
    public final j E2;
    public final hh1.w0 F2;
    public int G1;
    public com.bytedance.android.live.liveinteract.widget.widget.q H0;
    public boolean H1;
    public WeakHandler L0;
    public InteractLiveCorePermissionGuarantor L1;
    public final Map<String, Integer> M1;
    public Runnable P0;
    public final Map<String, Integer> P1;
    public MuteStateChecker Q1;
    public InteractAnimationController S1;
    public com.bytedance.android.live.liveinteract.utils.g0 T1;
    public boolean V;
    public boolean V0;
    public int V1;
    public KtvRoomGuestPresenter W;
    public com.bytedance.android.live.liveinteract.api.utils.j X;
    public KtvRoomContainerWidget Y;
    public boolean Z;
    public boolean b1;
    public String b2;
    public long g1;
    public final i g2;
    public long h1;
    public QuickInteractWidget h2;
    public final Lazy k0;
    public long k1;
    public com.bytedance.android.live.liveinteract.plantform.core.h p0;
    public long p1;
    public RTSVoiceWidget p2;
    public long v1;
    public ThemedCompetitionWidget v2;
    public long x1;
    public LinkmicSubtitleBusinessWidget x2;
    public int y1;
    public final com.bytedance.android.live.liveinteract.utils.k0 y2;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.livesdk.ktvimpl.base.sei.j {
        public final com.bytedance.android.live.liveinteract.plantform.datamerge.d a;
        public final Function1<SeiAppData, Unit> b;

        public final void onSeiUpdated(SeiAppData r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (((Boolean) vm2.h.i1.getValue(null, vm2.h.a[111(0x6f, float:1.56E-43)])).booleanValue() == false) goto L11;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = this.a;
            if (r0 == null) goto L9;
            r0.t0(r4);
        L9:
            this.b.invoke(r4);
            return;
        }

        public b(com.bytedance.android.live.liveinteract.plantform.datamerge.d r2, Function1 r3) {
            Intrinsics.checkNotNullParameter(r3, "onSeiCallback");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ KtvRoomGuestWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ rj0.c d;

        public c(KtvRoomGuestWidget r1, boolean r2, int r3, KtvService.b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "dialog");
            ag6.b r11 = this.a.L5();
            if (r11 == null) goto L5;
            boolean r4 = this.b;
            r11.k(new wf6.b("leave_normally", this.c, true, r4, this.d, 32));
        L5:
            r9.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ KtvRoomGuestWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ rj0.c d;

        public e(KtvRoomGuestWidget r1, boolean r2, int r3, KtvService.b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "dialog");
            r8.dismiss();
            ag6.b r10 = this.a.L5();
            if (r10 == null) goto L6;
            boolean r4 = this.b;
            r10.k(new wf6.b("leave_normally", this.c, true, r4, this.d, 32));
            return;
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ KtvRoomGuestWidget a;
        public final /* synthetic */ Runnable b;

        public g(KtvRoomGuestWidget r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "dialog");
            jy0.b.d("voice_chat", "interceptCloseRoom");
            r8.dismiss();
            KtvRoomGuestWidget r10 = this.a;
            r10.P0 = this.b;
            ag6.b r11 = r10.L5();
            if (r11 == null) goto L5;
            r11.k(new wf6.b("leave_normally", 0, false, false, null, 62));
        L5:
            hd0.c.f().h.removeObservers(this.a);
        }
    }

    public static final class h implements DialogInterface.OnClickListener {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class i extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ KtvRoomGuestWidget a;

        public i(KtvRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            ArrayList r0 = new ArrayList(r4);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            bn0.b r1 = this.a.getMultiLinkRoomScope();
            if (r1 == null) goto L10;
            jn0.b r2 = jn0.c.a(r1);
            if (r2 == null) goto L10;
            BehaviorSubject r3 = r2.Xh();
            if (r3 == null) goto L10;
            r3.onNext(r0);
        L10:
            if (this.a.y1 == 16) goto L13;
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r4.size());
        L13:
            if (r4.size() <= tc0.c.h().d) goto L16;
            tc0.c r5 = tc0.c.h();
            r5.d = r4.size();
            return;
        }

        public final void n(List<ILinkPlayerInfoBridge> r2, long r3, com.bytedance.android.live.liveinteract.plantform.model.n0 r5) {
            if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L18;
            String r4 = "";
            if (Lists.isEmpty(r2) == false) goto L7;
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", "");
            return;
        L7:
            KtvRoomGuestWidget r6 = this.a;
            int r7 = KtvRoomGuestWidget.G2;
            int r8 = ((ArrayList) r6.Aq().V4()).size();
            if (r8 > 99) goto L10;
            r8 = r8 + fj0.e.a();
        L10:
            String r0 = String.valueOf(r8);
            if (r8 <= 99) goto L13;
            r0 = "99+";
        L13:
            if (r8 <= 0) goto L16;
            r4 = r0;
        L16:
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", r4);
            return;
        }
    }

    public static final class j implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ KtvRoomGuestWidget a;

        public final void b(boolean r1) {
        }

        public j(KtvRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L8;
            this.a.G4(true, "on particular page show");
            if (this.a.Pq().o() != 0) goto L19;
            this.a.Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
            this.a.Pq().k("onPause");
            return;
        L19:
            return;
        L8:
            if (this.a.isEngineOn() == false) goto L21;
            KtvRoomGuestWidget r5 = this.a;
            if (((MultiLinkVoiceBaseGuestLinkWidget) r5).s != null) goto L12;
            return;
        L12:
            if (r5.Pq().o() == 3) goto L14;
            return;
        L14:
            if (vm2.d.g() == false) goto L17;
            WeakReference r6 = com.bytedance.android.live.core.utils.a.a;
            if (com.bytedance.android.live.core.utils.a.e(((Widget) this.a).context) == true) goto L17;
            return;
        L17:
            this.a.Pq().l("on particular page close");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final kk0.f Bb() {
        return this;
    }

    public final tf0.o Qq() {
        return null;
    }

    public final void U0(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
    }

    public final String dr(int r2) {
        if (r2 != 9) goto L7;
        return "multi_ktv";
    L7:
        if (r2 != 10) goto L9;
        return "share_video";
    L9:
        return "fm";
    }

    public final void f1(long r1, long r3) {
    }

    public final int getLayoutId() {
        return 2131567728;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final void h0(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
    }

    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
    }

    public final void yi() {
        ((MultiLinkBaseGuestLinkWidget) this).c = null;
        yf6.b r1 = Yq();
        if (r1 == null) goto L5;
        r1.f("KtvRoomGuestWidget onEngineEndSuccess");
    L5:
        kr();
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L11;
        ((Widget) this).dataCenter.put("cmd_linker_live_core_release", Boolean.TRUE);
        com.bytedance.android.live.pushstream.d r2 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        if (r2 == null) goto L10;
        r2.release();
    L10:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).s = null;
    L11:
        KtvRoomGuestPresenter r3 = this.W;
        if (r3 == null) goto L17;
        KtvRoomGuestPresenter.IView r4 = ((q46.b) r3).a;
        if (r4 == null) goto L17;
        r4.V1();
    L17:
        hg6.g r5 = P2();
        if (r5 == null) goto L20;
        r5.Z(this);
    L20:
        m00.h r6 = ((MultiLinkVoiceBaseGuestLinkWidget) this).t;
        if (r6 == null) goto L23;
        r6.release();
    L23:
        ne0.c r7 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r7 == null) goto L26;
        r7.d0(sh0.e.b, Boolean.FALSE);
    L26:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).t = null;
        MuteStateChecker r0 = this.Q1;
        if (r0 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteStateChecker");
    L29:
        if (r0 == null) goto L31;
        r0.c = 0;
        r0.d = 0;
    L31:
        this.y2.b();
        QuickInteractWidget r8 = this.h2;
        if (r8 == null) goto L34;
        r8.xq();
    L34:
        com.bytedance.android.live.liveinteract.plantform.base.g r9 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r9 == null) goto L38;
        r9.o6(dr(this.y1), false);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomGuestPresenter.IView
    public final void V1() {
        Runnable r0 = this.P0;
        if (r0 == null) goto L8;
        if (r0 == null) goto L6;
        r0.run();
    L6:
        this.P0 = null;
        return;
    }

    public final long br() {
        if (this.x1 >= 0) goto L6;
        this.x1 = (((MultiLinkVoiceBaseGuestLinkWidget) this).y - this.g1) / ((long) 1000);
    L6:
        return this.x1;
    }

    public final InteractLiveCorePermissionGuarantor cr() {
        if (this.L1 != null) goto L7;
        this.L1 = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.L1;
        if (r0 == null) goto L7;
        r0.j(this.E2);
    L7:
        InteractLiveCorePermissionGuarantor r1 = this.L1;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final String fr() {
        com.bytedance.android.live.liveinteract.plantform.model.f r0 = ((MultiLinkVoiceBaseGuestLinkWidget) this).H;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        Integer r1 = r0.getInviteSource();
        Intrinsics.checkNotNull(r1);
        if (r1.intValue() <= 0) goto L7;
        com.bytedance.android.live.liveinteract.plantform.model.f r2 = ((MultiLinkVoiceBaseGuestLinkWidget) this).H;
        Intrinsics.checkNotNull(r2);
        Integer r3 = r2.getInviteSource();
        Intrinsics.checkNotNull(r3);
        int r4 = r3.intValue();
    L9:
        if (Intrinsics.areEqual("invite", ((MultiLinkVoiceBaseGuestLinkWidget) this).E) == false) goto L12;
        if (r4 <= 0) goto L12;
        int r5 = com.bytedance.android.live.liveinteract.plantform.model.p0.a;
        return com.bytedance.android.live.liveinteract.plantform.model.p0.a.a(r4);
    L12:
        return null;
    L7:
        r4 = -1;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final List<com.bytedance.android.live.liveinteract.plantform.model.s0> getHeadPointList() {
        KtvRoomContainerWidget r0 = this.Y;
        if (r0 == null) goto L8;
        qe2.a r1 = r0.e;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getHeadPointList();
    L8:
        return null;
    }

    public final Long hr() {
        Long r2 = null;
        MicPosTagInfo r0 = (MicPosTagInfo) ((Widget) this).dataCenter.get("data_link_mic_pos_tag_info", null);
        if (r0 == null) goto L5;
        r2 = Long.valueOf(r0.getTagType());
    L5:
        if (r2 != null) goto L7;
    L8:
        com.bytedance.android.live.liveinteract.plantform.model.g0 r1 = ((MultiLinkVoiceBaseGuestLinkWidget) this).F;
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r1);
        return Long.valueOf(r1.getTagType());
    L13:
        return r2;
    L7:
        if (r2.longValue() == 0) goto L8;
        return r2;
    }

    public final void kr() {
        String r24 = fr();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        String r2 = "anchor";
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = r3.t();
        if (r4 == null) goto L11;
        if (r4.a != 5) goto L11;
    L10:
        String r7 = r2;
    L39:
        com.bytedance.android.live.liveinteract.voicechat.util.k r5 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r5 == null) goto L42;
        long r10 = 1000;
        r5.C(9, ((MultiLinkVoiceBaseGuestLinkWidget) this).w, Mq(), Nq(), ((MultiLinkVoiceBaseGuestLinkWidget) this).E, r7, (System.currentTimeMillis() - Math.max(this.v1, this.p1)) / r10, Long.valueOf((this.v1 - ((MultiLinkVoiceBaseGuestLinkWidget) this).y) / r10), Long.valueOf(br()), je0.d.Z(), false, this.y2.b, getMRoom().getCircleInfo(), hr(), KtvLoggerHelper.D(9, null), null, ((MultiLinkVoiceBaseGuestLinkWidget) this).x, ((MultiLinkVoiceBaseGuestLinkWidget) this).G, null, null, r24, ((MultiLinkBaseGuestLinkWidget) this).j);
    L42:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).H = null;
        tc0.c.h().F = "";
        return;
    L11:
        cg6.a r6 = Bq();
        if (r6 == null) goto L18;
        MultiLinkGuestManager r8 = r6.W4();
        if (r8 == null) goto L18;
        if (r8.g != true) goto L18;
        String r9 = "anchor";
    L19:
        com.bytedance.android.livesdk.chatroom.u r11 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r11 == null) goto L26;
        com.bytedance.live.datacontext.m r12 = r11.y();
        if (r12 == null) goto L26;
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L26;
    L27:
        cg6.a r13 = Bq();
        if (r13 == null) goto L35;
        MultiLinkGuestManager r14 = r13.W4();
        if (r14 == null) goto L35;
        if (r14.h != true) goto L35;
        r2 = "game";
    L35:
        if (jc1.k.n(IInteractService.class).getAdventureService() == null) goto L10;
        if (com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f != true) goto L10;
        r7 = "meetgame_call";
    L26:
        r2 = r9;
    L18:
        r9 = "audience";
        goto L19
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final MuteStateChecker muteChecker() {
        MuteStateChecker r0 = this.Q1;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteStateChecker");
    L5:
        return r0;
    }

    public final void o() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.h r1 = this.p0;
        if (r1 == null) goto L21;
        hg6.g r4 = P2();
        if (r4 == null) goto L10;
        ei6.a r5 = r4.V0();
    L11:
        WeakReference r3 = new WeakReference(r5);
        hg6.g r6 = P2();
        if (r6 == null) goto L18;
        ec6.b r7 = r6.R();
        if (r7 == null) goto L18;
        com.bytedance.android.live.pushstream.d r8 = gc6.b.a(r7);
        if (r8 == null) goto L18;
        uf2.d0 r9 = r8.getLiveCore();
    L19:
        r1.d(r3, new WeakReference(r9));
    L18:
        r9 = null;
        goto L19
    L10:
        r5 = null;
    L21:
        if (tc0.c.h().C == true) goto L23;
    L25:
        com.bytedance.android.live.liveinteract.plantform.base.g r2 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r2 == null) goto L28;
        r2.o6(dr(this.y1), false);
    L28:
        this.v1 = System.currentTimeMillis();
        String r24 = fr();
        com.bytedance.android.live.liveinteract.voicechat.util.k r10 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r10 == null) goto L40;
        String r11 = ((MultiLinkVoiceBaseGuestLinkWidget) this).w;
        boolean r12 = Nq();
        String r13 = ((MultiLinkVoiceBaseGuestLinkWidget) this).E;
        int r14 = je0.d.j(Aq());
        List r15 = je0.d.Z();
        String r16 = ((MultiLinkVoiceBaseGuestLinkWidget) this).D;
        boolean r17 = ((MultiLinkVoiceBaseGuestLinkWidget) this).z;
        boolean r18 = ((MultiLinkVoiceBaseGuestLinkWidget) this).A;
        ICircleInfo r19 = getMRoom().getCircleInfo();
        Long r110 = Long.valueOf((this.v1 - ((MultiLinkVoiceBaseGuestLinkWidget) this).y) / ((long) 1000));
        Long r111 = Long.valueOf(br());
        Long r112 = hr();
        LinkApplyType r20 = ((MultiLinkVoiceBaseGuestLinkWidget) this).x;
        IMessageBoardInfo r21 = ((MultiLinkVoiceBaseGuestLinkWidget) this).G;
        yf6.b r22 = Yq();
        if (r22 == null) goto L38;
        vf6.a r23 = r22.a9();
        if (r23 == null) goto L38;
        String r25 = r23.b;
        if (r25 == null) goto L38;
        String r26 = r25;
    L39:
        r10.A(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, null, null, r20, r21, r26, r24);
    L38:
        r26 = "";
    L40:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).A = false;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).C = null;
        yf6.b r27 = Yq();
        if (r27 == null) goto L46;
        vf6.a r28 = r27.a9();
        if (r28 == null) goto L46;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r28.b = "";
    L46:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == true) goto L51;
        int r29 = Pq().o();
        jy0.b.d("voice_chat", "start link when background, try mute self silenceState=" + r29);
        if (r29 > 0) goto L50;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        Pq().k("start on background");
        G4(true, "start on background");
    L50:
        Aq().v();
    L51:
        MuteStateChecker r30 = this.Q1;
        if (r30 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteStateChecker");
    L54:
        if (r30 == null) goto L56;
        r30.b();
    L56:
        ne0.c r31 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r31 == null) goto L59;
        r31.d0(sh0.f.b, Boolean.FALSE);
    L59:
        String r32 = tc0.c.h().f;
        if (TextUtils.isEmpty(r32) == true) goto L62;
        this.y2.c(r32, true);
    L64:
        if ((!Intrinsics.areEqual(je0.d.g(), je0.d.b0())) == true) goto L66;
    L75:
        yf6.b r33 = Yq();
        if (r33 == null) goto L79;
        sf6.d.a.a(r33, new KtvRoomGuestWidget$onStartSuccess$1(this));
        return;
    L79:
        return;
    L66:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L75;
        jy0.b.f("ttlive_link", "stopVideoCapture since not singer!", null, 4);
        cg6.a r34 = Bq();
        if (r34 == null) goto L74;
        jg6.a r35 = r34.e5();
        if (r35 == null) goto L74;
        lh6.b r36 = r35.a();
        if (r36 == null) goto L74;
        r36.j("ktvroom guestwidget stopVideoCapture since not singer!");
    L74:
        com.bytedance.android.live.liveinteract.plantform.utils.x.x(true, je0.d.g());
        goto L75
    L62:
        this.y2.b();
        goto L64
    L23:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L25;
        Pq().v();
        tc0.c.h().C = false;
        goto L25
    }

    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    public final void onCreate() {
        super.onCreate();
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r1 = ((Widget) this).dataCenter;
        IRoom r2 = getMRoom();
        mz0.f r10 = null;
        if (r2 == null) goto L5;
        Long r3 = Long.valueOf(r2.getId());
    L6:
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r3.longValue()));
        if (r4 == null) goto L9;
        r4.startObserveKtvElementLoadEnd("ktv");
    L9:
        jy0.b.d("KtvRoomGuestWidget", "realOnCreate");
        com.bytedance.android.livesdk.chatroom.u r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r5 == null) goto L14;
        com.bytedance.live.datacontext.m r6 = r5.y();
        if (r6 == null) goto L14;
        r6.setValue(Boolean.FALSE);
    L14:
        sh0.i0 r7 = sh0.j0.a;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).v = sh0.j0.c(((Widget) this).dataCenter, this);
        com.bytedance.android.livesdk.chatroom.u r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r12 == null) goto L21;
        com.bytedance.live.datacontext.j r8 = r12.s();
        if (r8 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r8.getValue();
        if (r9 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r11 = r9.t();
    L22:
        if (r11 == null) goto L28;
        hg6.g r13 = P2();
        if (r13 == null) goto L28;
        fg6.b r14 = r13.F();
        if (r14 == null) goto L28;
        r14.b(pg6.a.b(r11));
    L28:
        tc0.c.h().B = 5;
        this.S1 = new InteractAnimationController(((Widget) this).dataCenter);
        InteractAnimationContext r15 = (InteractAnimationContext) com.bytedance.live.datacontext.d.a(KtvRoomGuestWidget$realOnCreate$1.INSTANCE).component1();
        r15.getController().d(this.S1);
        com.bytedance.live.datacontext.b.a(r15, InteractAnimationContext.class);
        Pair r16 = com.bytedance.live.datacontext.d.a(KtvRoomGuestWidget$realOnCreate$2.INSTANCE);
        KtvGuestDataContext r17 = (KtvGuestDataContext) r16.component1();
        Disposable r18 = (Disposable) r16.component2();
        r17.getService().d(this);
        com.bytedance.live.datacontext.b.a(r17, "voice_chat_guest_context");
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r18);
        Pair r19 = com.bytedance.live.datacontext.d.a(KtvRoomGuestWidget$realOnCreate$3.INSTANCE);
        KtvRoomGlobalDataContext r110 = (KtvRoomGlobalDataContext) r19.component1();
        Disposable r20 = (Disposable) r19.component2();
        r110.getKtvAdminService().d(this);
        com.bytedance.live.datacontext.b.a(r110, "voice_chat_admin_context");
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r20);
        long r21 = System.currentTimeMillis();
        this.g1 = r21;
        long r22 = TalkRoomLogUtils.y;
        long r23 = r21 - r22;
        if (r23 >= 0) goto L31;
    L33:
        r22 = r21;
    L34:
        this.h1 = r22;
        TalkRoomLogUtils.y = 0;
        long r24 = TalkRoomLogUtils.A;
        long r25 = r21 - r24;
        if (r25 >= 0) goto L37;
    L39:
        this.k1 = r21;
        TalkRoomLogUtils.A = 0;
        r110.getUserInfoCenter().d(Aq());
        enableSubWidgetManager();
        if (this.v2 != null) goto L42;
        enableSubWidgetManager();
        ThemedCompetitionWidget r26 = new ThemedCompetitionWidget();
        this.v2 = r26;
        ((Widget) this).subWidgetManager.load(r26);
    L42:
        Object r27 = ((Widget) this).dataCenter.get("ktv_scene_widget", null);
        if ((r27 instanceof KtvRoomContainerWidget) == true) goto L45;
        r27 = null;
    L45:
        KtvRoomContainerWidget r28 = (KtvRoomContainerWidget) r27;
        if (r28 != null) goto L48;
        boolean r29 = true;
    L49:
        this.b1 = r29;
        if (r28 == null) goto L52;
        StringBuilder r30 = new StringBuilder("KtvRoomGuestWidget, ktvContext:");
        KtvContext.Companion.getClass();
        r30.append(KtvContext.a.g());
        ALogger.i("KtvRoomGuestWidget", r30.toString());
        r28.B = ((Widget) this).subWidgetManager;
        r28.D = this.F2;
        r28.E = Aq();
        r28.F = this.S1;
        r28.C = md();
        ?? r111 = 0;
        ?? r112 = 1;
    L53:
        this.Y = r28;
        oe2.h r31 = (oe2.h) this.k0.getValue();
        if (r31 == null) goto L56;
        r28.Rq(r31);
    L56:
        b r32 = new b(md(), new KtvRoomGuestWidget$realOnCreate$seiCallback$1(this));
        this.X = new com.bytedance.android.live.liveinteract.api.utils.j(r32, r32);
        this.W = new KtvRoomGuestPresenter(getMRoom(), ((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.e(this));
        VoiceChatMuteManager r33 = new VoiceChatMuteManager(getMRoom(), false, Aq(), ((Widget) this).dataCenter, this, this, this);
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        ((MultiLinkVoiceBaseGuestLinkWidget) this).O = r33;
        Pq().j();
        Pq().c(this, q1.a);
        this.Q1 = new MuteStateChecker(((Widget) this).dataCenter, Aq(), Pq());
        this.L0 = new WeakHandler(this);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).I = new com.bytedance.android.live.liveinteract.voicechat.util.k(((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.j(this));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r34 = MultiRevenueDataContext.a.d();
        if (r34 == null) goto L69;
        if (vm2.h.U().a() == true) goto L65;
        if (vm2.h.U().f() == true) goto L65;
        if (hg6.i.c() == false) goto L69;
    L65:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L67;
        r34.o(((Widget) this).dataCenter, this, SceneType.SCENE_KTV, ((Widget) this).containerView);
    L67:
        r34.d(((Widget) this).dataCenter);
    L69:
        if (this.h2 != null) goto L72;
        enableSubWidgetManager();
        QuickInteractWidget r35 = new QuickInteractWidget();
        this.h2 = r35;
        ((Widget) this).subWidgetManager.load(r35);
    L72:
        if (this.x2 != null) goto L82;
        enableSubWidgetManager();
        this.x2 = new LinkmicSubtitleBusinessWidget();
        vb6.g r36 = yq();
        if (r36 == null) goto L80;
        yb6.e r37 = r36.j();
        if (r37 == null) goto L80;
        LinkmicSubtitleBusinessWidget r38 = this.x2;
        if (r38 == null) goto L80;
        Intrinsics.checkNotNullParameter(r37, "mediaManager");
        r38.c = r37;
    L80:
        ((Widget) this).subWidgetManager.load(this.x2);
    L82:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L84;
        Aq().I = r111;
        Aq().i();
    L84:
        r110.getSubWidgetManager().d(((Widget) this).subWidgetManager);
        KtvRoomGuestPresenter r39 = this.W;
        if (r39 == null) goto L87;
        r39.g0(this);
    L87:
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_audio_talk_invite", this);
        ((Widget) this).dataCenter.observe("cmd_show_guest_apply_dialog", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        Aq().Q4(this.g2);
        nr(jd0.f.class, new r1(this));
        nr(zg1.h1.class, new s1(this));
        nr(zg1.i1.class, new t1(this));
        nr(u22.b.class, new u1(this));
        nr(o42.g.class, new v1(this));
        IInteractService r40 = jc1.k.f(IInteractService.class);
        if (r40 == null) goto L90;
        x00.a r41 = r40.getThemeManager(r111, ((Widget) this).dataCenter);
    L91:
        if (r41 == null) goto L95;
        r41.j(this, new k1(this), r112);
        IVoiceLiveTheme r42 = getMRoom().getVoiceLiveTheme();
        if (r42 == null) goto L95;
        r41.c(r42, r112);
    L95:
        hd0.c.f().h.observe(this, new KtvRoomGuestWidget$realOnCreate$12());
        this.T1 = new com.bytedance.android.live.liveinteract.utils.g0(getMRoom(), Aq());
        if (vm2.e.a() == true) goto L98;
    L104:
        if (r12 == null) goto L121;
        Disposable r43 = jc1.k.n(IKtvService.class).observerCurrentIsSinger(null, r111, new l1(this));
        if (r43 == null) goto L108;
        RxUtilKt.c(r43, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L108:
        com.bytedance.live.datacontext.j r44 = r12.s();
        if (r44 == null) goto L117;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r45 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r44.getValue();
        if (r45 == null) goto L117;
        BehaviorSubject r46 = r45.a();
        if (r46 == null) goto L117;
        Disposable r47 = r46.subscribe(new m1(this));
        if (r47 == null) goto L117;
        RxUtilKt.c(r47, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L117:
        com.bytedance.live.datacontext.k r48 = jc1.k.n(IKtvService.class).ktvComponentSingerChangedEvent();
        if (r48 == null) goto L121;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r48.onEvent().subscribe(new n1(this)));
    L121:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L124;
        com.bytedance.android.live.liveinteract.voicechat.util.k.r();
    L124:
        if (vm2.d.e().a() == true) goto L126;
    L134:
        String r49 = LinkmicOnlineFloatWindowManager.Y;
        if (LinkmicOnlineFloatWindowManager.c.a().x == null) goto L200;
        ar(new w1(), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
        Iterator r50 = ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().o).iterator();
    L138:
        if (r50.hasNext() == false) goto L146;
        ILinkPlayerInfoBridge r51 = (ILinkPlayerInfoBridge) r50.next();
        IBaseUser r52 = r51.getUser();
        if (r52 == null) goto L142;
        String r53 = r52.getIdString();
    L144:
        if (Intrinsics.areEqual(r53, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L138;
        ILinkPlayerInfoBridge r54 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r51);
    L147:
        if (r54 == null) goto L200;
        VoiceChatMuteManager r55 = Pq();
        if (r54.getSilenceStatus() == 0) goto L152;
        boolean r56 = true;
    L153:
        r55.t(r56);
        hg6.g r57 = P2();
        if (r57 == null) goto L156;
        r57.p(this);
    L156:
        String r58 = LinkmicOnlineFloatWindowManager.Y;
        tc0.c r59 = LinkmicOnlineFloatWindowManager.c.a().n;
        if (r59 == null) goto L159;
        String r60 = r59.k;
    L160:
        hg6.g r61 = P2();
        if (r61 == null) goto L163;
        r61.c0(r60);
    L163:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).s = LinkmicOnlineFloatWindowManager.c.a().z;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).t = LinkmicOnlineFloatWindowManager.c.a().y;
        hg6.g r62 = LinkmicOnlineFloatWindowManager.c.a().x;
        if (yq() == null) goto L188;
        if (r62 == null) goto L188;
        if (r62.V0() == null) goto L188;
        m00.h r63 = ((MultiLinkVoiceBaseGuestLinkWidget) this).t;
        if ((r63 instanceof hh1.v0) == true) goto L171;
        r63 = null;
    L171:
        hh1.v0 r64 = (hh1.v0) r63;
        if (r64 == null) goto L178;
        vb6.g r65 = yq();
        if (r65 == null) goto L178;
        yb6.e r66 = r65.j();
        if (r66 == null) goto L178;
        r66.s0(gc6.b.c(r64, null), "KtvRoomGuestWidget restoreLinkmicState");
    L178:
        vb6.g r67 = yq();
        if (r67 == null) goto L183;
        yb6.e r68 = r67.j();
        if (r68 == null) goto L183;
        ei6.a r69 = r62.V0();
        Intrinsics.checkNotNull(r69);
        r68.Q(r69, "KtvRoomGuestWidget restoreLinkmicState");
    L183:
        vb6.g r70 = yq();
        if (r70 == null) goto L188;
        yb6.e r71 = r70.j();
        if (r71 == null) goto L188;
        r71.o0(LinkmicOnlineFloatWindowManager.c.a().A);
    L188:
        hd0.c.f().k(2);
        LinkmicOnlineFloatWindowManager.c.a().i();
        com.bytedance.android.livesdk.chatroom.u r72 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r72 == null) goto L193;
        com.bytedance.live.datacontext.m r73 = r72.m();
        if (r73 == null) goto L193;
        r73.setValue(Boolean.TRUE);
    L193:
        jg6.a r74 = LinkmicOnlineFloatWindowManager.c.a().w;
        if (r74 == null) goto L198;
        kg6.e r75 = r74.b();
        if (r75 == null) goto L198;
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.valueOf(r75.q()));
    L198:
        ((Widget) this).dataCenter.put("data_recover_from_online_float_window_start_subtitle", Boolean.TRUE);
        goto L200
    L159:
        r60 = null;
        goto L160
    L152:
        r56 = false;
        goto L153
    L142:
        r53 = null;
        goto L144
    L146:
        r54 = null;
    L200:
        if (this.p2 != null) goto L213;
        Widget.WidgetCallback r76 = ((Widget) this).widgetCallback;
        if (r76 == null) goto L213;
        if (r76.getWidgetManager() == null) goto L213;
        enableSubWidgetManager();
        hg6.g r77 = P2();
        com.bytedance.android.live.liveinteract.plantform.core.y r78 = Aq();
        cg6.a r79 = Bq();
        if (r79 == null) goto L208;
        MultiLinkGuestManager r80 = r79.W4();
    L210:
        if ((r80 instanceof com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b) == true) goto L212;
        r80 = null;
    L212:
        RTSVoiceWidget r81 = new RTSVoiceWidget(r77, r78, (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b) r80, 8);
        this.p2 = r81;
        ((Widget) this).subWidgetManager.load(r81);
        goto L213
    L208:
        r80 = null;
    L213:
        int r82 = xe0.j.a;
        getMRoom();
        if (xe0.j.a() == false) goto L308;
        LinkmicApplyFloatWindowManager.d r83 = LinkmicApplyFloatWindowManager.y;
        we0.b r85 = LinkmicApplyFloatWindowManager.e.a().i(getMRoom().getRoomId());
        if (r85 == null) goto L308;
        ar(new i1(), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
        tc0.c r86 = tc0.c.h();
        Intrinsics.checkNotNullParameter(r85, "params");
        tc0.c r87 = tc0.c.h();
        String r88 = r85.a;
        if (r88 == null) goto L221;
        r87.M = r88;
    L221:
        LinkApplyType r89 = r85.d;
        if (r89 == null) goto L224;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).x = r89;
    L224:
        Integer r90 = r85.e;
        if (r90 == null) goto L227;
        Intrinsics.checkNotNull(r90);
        r87.K = r90.intValue();
    L227:
        String r91 = r85.g;
        if (r91 == null) goto L230;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).w = r91;
    L230:
        Boolean r92 = r85.h;
        if (r92 == null) goto L237;
        Intrinsics.checkNotNull(r92);
        boolean r93 = r92.booleanValue();
        yf6.b r94 = Yq();
        if (r94 == null) goto L237;
        vf6.a r95 = r94.a9();
        if (r95 == null) goto L237;
        r95.a = r93;
    L237:
        Boolean r96 = r85.i;
        if (r96 == null) goto L240;
        Intrinsics.checkNotNull(r96);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).z = r96.booleanValue();
    L240:
        Boolean r97 = r85.j;
        if (r97 == null) goto L243;
        Intrinsics.checkNotNull(r97);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).A = r97.booleanValue();
    L243:
        com.bytedance.android.live.liveinteract.plantform.model.g0 r98 = r85.k;
        if (r98 == null) goto L248;
        DataCenter r99 = ((Widget) this).dataCenter;
        if (r99 == null) goto L248;
        r99.put("data_link_mic_pos_tag_info", r98);
    L248:
        Boolean r100 = r85.l;
        if (r100 == null) goto L253;
        DataCenter r101 = ((Widget) this).dataCenter;
        if (r101 == null) goto L253;
        r101.put("data_link_mic_is_quick_invite", r100);
    L253:
        Long r102 = r85.m;
        if (r102 == null) goto L256;
        Intrinsics.checkNotNull(r102);
        this.g1 = r102.longValue();
    L256:
        Long r103 = r85.n;
        if (r103 == null) goto L259;
        Intrinsics.checkNotNull(r103);
        this.h1 = r103.longValue();
    L259:
        Long r104 = r85.o;
        if (r104 == null) goto L262;
        Intrinsics.checkNotNull(r104);
        this.k1 = r104.longValue();
    L262:
        Long r105 = r85.p;
        if (r105 == null) goto L265;
        Intrinsics.checkNotNull(r105);
        this.p1 = r105.longValue();
    L265:
        Long r106 = r85.q;
        if (r106 == null) goto L268;
        Intrinsics.checkNotNull(r106);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).y = r106.longValue();
    L268:
        Long r107 = r85.r;
        if (r107 == null) goto L271;
        Intrinsics.checkNotNull(r107);
        this.v1 = r107.longValue();
    L271:
        Long r108 = r85.s;
        if (r108 == null) goto L274;
        Intrinsics.checkNotNull(r108);
        this.x1 = r108.longValue();
    L274:
        String r109 = r85.t;
        if (r109 == null) goto L277;
        r87.f = r109;
    L277:
        Integer r113 = r85.u;
        if (r113 == null) goto L281;
        Intrinsics.checkNotNull(r113);
        r87.j = r113.intValue();
    L281:
        if (r85.v == null) goto L283;
        hd0.c r114 = hd0.c.f();
        Integer r115 = r85.v;
        Intrinsics.checkNotNull(r115);
        r114.g = r115.intValue();
    L283:
        Boolean r116 = r85.w;
        if (r116 == null) goto L286;
        Intrinsics.checkNotNull(r116);
        r87.C = r116.booleanValue();
    L286:
        String r117 = r85.z;
        if (r117 == null) goto L289;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).E = r117;
    L289:
        String r118 = r85.A;
        if (r118 == null) goto L292;
        r87.F = r118;
    L292:
        hd0.c.f().k(Integer.valueOf(r112));
        com.bytedance.android.livesdk.link.model.bridge.z0 r119 = r85.B;
        if (r119 == null) goto L307;
        r86.k = r119.getRtcExtInfo();
        r86.n = r119.getMultiRtcInfo();
        r86.s = r119.getMcuContent();
        r86.e = r119.getAnchorLinkMicIdStr();
        cg6.a r120 = Bq();
        if (r120 == null) goto L299;
        MultiLinkGuestManager r121 = r120.W4();
        if (r121 == null) goto L299;
        r121.g();
    L299:
        Long r122 = r85.C;
        if (r122 == null) goto L302;
        Intrinsics.checkNotNull(r122);
        long r123 = r122.longValue();
    L303:
        TalkRoomBusinessFullLinkMonitor r124 = TalkRoomBusinessFullLinkMonitor.a;
        String r125 = r86.f;
        if (r125 != null) goto L306;
        r125 = "";
    L306:
        r124.getClass();
        TalkRoomBusinessFullLinkMonitor.f(r125, r123);
        goto L307
    L302:
        r123 = 0;
    L307:
        LinkmicApplyFloatWindowManager.e.a().s = null;
    L308:
        com.bytedance.live.datacontext.m r126 = jc1.k.n(IKtvService.class).getHasBgm();
        if (r126 == null) goto L312;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r126.a().subscribe(new o1(this)));
    L312:
        if (vm2.d.U0() == false) goto L318;
        com.bytedance.android.livesdk.chatroom.u r127 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r127 == null) goto L318;
        com.bytedance.live.datacontext.k r128 = r127.L();
        if (r128 == null) goto L318;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(RxUtilKt.p(r128.onEvent(), "KtvRoomGuestWidget", new KtvRoomGuestWidget$realOnCreate$$inlined$let$lambda$1(this)));
    L318:
        SpatialAudioContext r129 = SpatialAudioContext.Companion.getContext();
        if (r129 == null) goto L327;
        com.bytedance.live.datacontext.m r130 = r129.getCurrentStrategyId();
        if (r130 == null) goto L327;
        Observable r131 = r130.a();
        if (r131 == null) goto L327;
        Disposable r132 = r131.subscribe(new p1(this));
        if (r132 == null) goto L327;
        RxUtilKt.c(r132, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L327:
        com.bytedance.android.live.liveinteract.linksecurity.c.g.k(((Widget) this).dataCenter);
        TalkRoomLogUtils.x = null;
        com.bytedance.android.live.liveinteract.plantform.core.h r133 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, Aq());
        this.p0 = r133;
        r133.a();
        hg6.g r134 = P2();
        if (r134 == null) goto L330;
        ei6.a r135 = r134.V0();
    L331:
        hg6.g r136 = P2();
        if (r136 == null) goto L338;
        ec6.b r137 = r136.R();
        if (r137 == null) goto L338;
        com.bytedance.android.live.pushstream.d r138 = gc6.b.a(r137);
        if (r138 == null) goto L338;
        uf2.d0 r139 = r138.getLiveCore();
    L339:
        if (r135 == null) goto L345;
        if (r139 == null) goto L345;
        com.bytedance.android.live.liveinteract.plantform.core.h r140 = this.p0;
        if (r140 == null) goto L345;
        r140.d(new WeakReference(r135), new WeakReference(r139));
    L345:
        if (vm2.d.y() == true) goto L347;
    L359:
        mz0.f r141 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r141 instanceof mz0.f) == false) goto L363;
        r10 = r141;
    L363:
        mz0.f r142 = r10;
        if (r142 == null) goto L369;
        if (TextUtils.equals(r142.g(), "1") == false) goto L369;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131917753), r111);
    L369:
        if (KtvSettingHelper.w() == false) goto L381;
        ViewGroup r143 = ((Widget) this).containerView;
        if (r143 == null) goto L382;
        DataCenter r144 = ((Widget) this).dataCenter;
        if (r144 == null) goto L383;
        Disposable r145 = com.bytedance.android.live.liveinteract.videotalk.ui.b.b(r143, r144);
        if (r145 == null) goto L384;
        RxUtilKt.c(r145, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
        return;
    L384:
        return;
    L383:
        return;
    L382:
        return;
    L381:
        return;
    L347:
        if (vm2.d.x() == false) goto L359;
        com.bytedance.android.livesdk.chatroom.o r146 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r146 == null) goto L353;
        com.bytedance.live.datacontext.j r147 = r146.getCompactTbLoader();
        if (r147 == null) goto L353;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r148 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r147.getValue();
    L355:
        if ((r148 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L357;
        r148 = null;
    L357:
        if (r148 == null) goto L359;
        r148.refreshExistComponent(26);
        jy0.b.d("KtvRoomGuestWidget", "[LinkmicIconDoubleCheck] voiceChatRoomGuestWidget load refresh icon");
    L353:
        r148 = null;
    L338:
        r139 = null;
        goto L339
    L330:
        r135 = null;
        goto L331
    L126:
        if (this.y1 != 9) goto L128;
        boolean r149 = vm2.d.e().a();
    L129:
        if (r149 == false) goto L134;
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).N != null) goto L134;
        jy0.b.a("voice_chat", "loadMatchWidget");
        enableSubWidgetManager();
        ChatMatchWidget r150 = new ChatMatchWidget(r112, this);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).N = r150;
        ((Widget) this).subWidgetManager.load(r150);
        goto L134
    L128:
        r149 = false;
        goto L129
    L98:
        if ((getContext() instanceof FragmentActivity) == false) goto L104;
        InteractLiveCorePermissionGuarantor r151 = cr();
        FragmentActivity r152 = getContext();
        if (r152 == null) goto L103;
        r151.i(r152);
        goto L104
    L103:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L90:
        r41 = null;
        goto L91
    L52:
        com.bytedance.android.live.pushstream.d r153 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        WidgetManager r154 = ((Widget) this).subWidgetManager;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r155 = md();
        KtvContext.Companion.getClass();
        r111 = 0;
        r112 = 1;
        r28 = new KtvRoomContainerWidget(r153, r154, r155, KtvContext.a.g(), this.F2, Aq(), this.S1, this);
        goto L53
    L48:
        r29 = false;
        goto L49
    L37:
        if (r25 > 15000) goto L39;
        r21 = r24;
        goto L39
    L31:
        if (r23 > 15000) goto L33;
    L21:
        r11 = null;
        goto L22
    L5:
        r3 = null;
        goto L6
    }

    public final void onPause() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        boolean r1 = true;
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.service.g r2 = r0.getInteractFloatWindowService();
        if (r2 == null) goto L9;
        if (r2.b() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L15;
        hg6.g r4 = P2();
        if (r4 == null) goto L15;
        r4.onPause();
    L15:
        if (isEngineOn() == true) goto L17;
    L43:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).R = false;
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget*/.onPause();
        return;
    L17:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L43;
        if (vm2.e.a() == false) goto L22;
        cr().f();
    L22:
        if (jc1.k.n(IInteractService.class).enableCaptureAudioOnBackground(true) == true) goto L32;
        G4(true, "onPause");
        VoiceChatMuteManager r5 = Pq();
        if (r5 == null) goto L26;
        Integer r6 = Integer.valueOf(r5.o());
    L27:
        int r7 = r6.intValue();
        if (r7 != 0) goto L30;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        Pq().k("onPause");
    L33:
        IInteractService r8 = jc1.k.f(IInteractService.class);
        if (r8 == null) goto L40;
        com.bytedance.android.live.liveinteract.service.g r9 = r8.getInteractFloatWindowService();
        if (r9 == null) goto L40;
        if (r9.b() != true) goto L40;
    L41:
        if (r1 == true) goto L43;
        Aq().v();
    L40:
        r1 = false;
        goto L41
    L30:
        if (r7 != 3) goto L33;
        com.bytedance.android.live.liveinteract.plantform.utils.x.R(r7);
        goto L33
    L26:
        r6 = null;
        goto L27
    L32:
        com.bytedance.android.live.liveinteract.plantform.utils.x.J();
    L9:
        r3 = false;
        goto L10
    }

    public final Boolean t0() {
        com.bytedance.android.live.pushstream.d r0 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        return null;
    L6:
        return Boolean.valueOf(r0.t0());
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void tryAutoFastMatch() {
        String r0 = ChatMatchWidget.o;
        Intrinsics.checkNotNullParameter(PanelType.APPLY_PANEL, "requestPage");
        ChatMatchWidget.o = PanelType.APPLY_PANEL;
        ChatMatchWidget r1 = ((MultiLinkVoiceBaseGuestLinkWidget) this).N;
        if (r1 == null) goto L6;
        r1.zq(null, true, PanelType.APPLY_PANEL, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomGuestPresenter.IView
    public final ag6.b L5() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.L5();
    }

    public final int Mq() {
        yf6.b r0 = Yq();
        if (r0 == null) goto L7;
        vf6.a r1 = r0.a9();
        if (r1 == null) goto L7;
        return r1.c;
    L7:
        return 200;
    }

    public final boolean O5() {
        hg6.g r0 = P2();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.A() != true) goto L7;
        return true;
    }

    public final yf6.b Yq() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.L5();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final boolean canSilenceSelf() {
        return isEngineOn();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final jg6.a getAdminStatusCenter() {
        return Eq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return Aq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final we0.b getLinkmicReturnRoomParams() {
        tc0.c r0 = tc0.c.h();
        DataCenter r1 = ((Widget) this).dataCenter;
        MicPosTagInfo r2 = null;
        if (r1 == null) goto L5;
        r2 = (MicPosTagInfo) r1.get("data_link_mic_pos_tag_info", null);
        boolean r3 = ((Boolean) ((Widget) this).dataCenter.get("data_link_mic_is_quick_invite", Boolean.FALSE)).booleanValue();
    L6:
        we0.b.a r4 = new we0.b.a();
        r4.a = r0.M;
        r4.d = ((MultiLinkVoiceBaseGuestLinkWidget) this).x;
        r4.e = Integer.valueOf(r0.K);
        r4.g = ((MultiLinkVoiceBaseGuestLinkWidget) this).w;
        r4.h = Boolean.valueOf(Nq());
        r4.i = Boolean.valueOf(((MultiLinkVoiceBaseGuestLinkWidget) this).z);
        r4.j = Boolean.valueOf(((MultiLinkVoiceBaseGuestLinkWidget) this).A);
        r4.k = r2;
        r4.l = Boolean.valueOf(r3);
        r4.m = Long.valueOf(this.g1);
        r4.n = Long.valueOf(this.h1);
        r4.o = Long.valueOf(this.k1);
        r4.p = Long.valueOf(this.p1);
        r4.q = Long.valueOf(((MultiLinkVoiceBaseGuestLinkWidget) this).y);
        r4.r = Long.valueOf(this.v1);
        r4.s = Long.valueOf(this.x1);
        r4.t = r0.f;
        r4.u = Integer.valueOf(r0.j);
        r4.v = Integer.valueOf(hd0.c.f().g);
        r4.w = Boolean.valueOf(r0.C);
        r4.z = ((MultiLinkVoiceBaseGuestLinkWidget) this).E;
        r4.A = r0.F;
        return r4.a();
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return Aq().c;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final int getSelfSilenceType() {
        if (isEngineOn() == false) goto L5;
        VoiceChatMuteManager r0 = Pq();
        Intrinsics.checkNotNull(r0);
        return r0.o();
    L5:
        return -1;
    }

    public final String getSource() {
        String r0 = super/*com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget*/.getSource();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final long gr() {
        return (System.currentTimeMillis() - Math.max(this.p1, this.g1)) / ((long) 1000);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final boolean isEngineOn() {
        hg6.g r0 = P2();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.A();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final com.bytedance.android.live.liveinteract.voicechat.b muteManager() {
        return Pq();
    }

    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        jy0.b.d("KtvRoomGuestWidget", "onDestroy");
        com.bytedance.android.live.liveinteract.plantform.core.h r0 = this.p0;
        if (r0 == null) goto L6;
        r0.b();
    L6:
        if (((Boolean) KtvSettingHelper.e.getValue()).booleanValue() == false) goto L8;
        int r1 = com.bytedance.android.live.liveinteract.videotalk.ui.b.a;
        com.bytedance.android.live.liveinteract.videotalk.ui.b.a(((Widget) this).dataCenter);
    L8:
        yf6.b r2 = Yq();
        if (r2 == null) goto L12;
        r2.f("KtvRoomGuestWidget onDestroy");
    L12:
        if (vm2.e.a() == false) goto L14;
        cr().e();
    L14:
        com.bytedance.android.live.liveinteract.linksecurity.c.n(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        InteractAnimationController r3 = this.S1;
        if (r3 == null) goto L18;
        r3.l();
    L18:
        if (isEngineOn() == false) goto L21;
        kr();
        com.bytedance.android.live.liveinteract.plantform.utils.x.j0();
    L21:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.util.k.s(gr());
    L23:
        com.bytedance.android.live.liveinteract.voicechat.util.k r4 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r4 == null) goto L26;
        com.bytedance.android.live.liveinteract.voicechat.util.k.w(r4, null, null, null, 15);
    L26:
        HashMap r5 = new HashMap();
        if (vm2.h.R() == false) goto L29;
        r5.put("room_id", String.valueOf(getMRoom().getId()));
        r5.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r6 = getMRoom().getStreamType();
        int r7 = com.bytedance.android.live.core.utils.h1.a;
        r5.put("live_type", com.bytedance.android.live.core.utils.i1.a(r6));
    L29:
        com.bytedance.android.live.liveinteract.voicechat.util.k r8 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r8 == null) goto L32;
        r8.q(r5, gr(), 9, null, KtvLoggerHelper.D(9, null), getMRoom().getCircleInfo(), false, null);
    L32:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r9 = TalkRoomLogUtils.a;
        long r10 = 1000;
        TalkRoomLogUtils.p0(r5, Long.valueOf((System.currentTimeMillis() - Math.max(this.p1, this.h1)) / r10));
        TalkRoomLogUtils.q0(r5, Long.valueOf((System.currentTimeMillis() - Math.max(this.p1, this.k1)) / r10));
        DataCenter r11 = ((Widget) this).dataCenter;
        Boolean r12 = Boolean.FALSE;
        r11.put("data_enter_room_is_quick_invite", r12);
        ((Widget) this).dataCenter.put("data_self_is_silenced", r12);
        ((Widget) this).dataCenter.removeObserver(this);
        tc0.c.h().j(r12);
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).O == null) goto L35;
        boolean r13 = true;
    L36:
        if (r13 == false) goto L40;
        VoiceChatMuteManager r14 = Pq();
        if (r14 == null) goto L40;
        r14.n();
    L40:
        cg6.a r15 = Bq();
        if (r15 == null) goto L45;
        hg6.g r16 = r15.getRtcManager();
        if (r16 == null) goto L45;
        r16.Z(this);
    L45:
        KtvRoomGuestPresenter r17 = this.W;
        if (r17 == null) goto L48;
        r17.detachView();
    L48:
        this.y2.b();
        com.bytedance.android.live.liveinteract.utils.g0 r18 = this.T1;
        if (r18 == null) goto L52;
        r18.c(this.y1);
    L52:
        if (((MultiLinkBaseGuestLinkWidget) this).b == null) goto L54;
        boolean r19 = true;
    L55:
        if (r19 == false) goto L60;
        Aq().T4(this.g2);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L59;
        Aq().m();
        goto L60
    L59:
        Aq().l();
    L60:
        ILinkPanelService r20 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r20 == null) goto L63;
        r20.close();
    L63:
        com.bytedance.android.live.liveinteract.widget.widget.q r21 = this.H0;
        if (r21 != null) goto L66;
    L70:
        GuestTalkBeInvitedDialog r22 = ((MultiLinkVoiceBaseGuestLinkWidget) this).L;
        if (r22 == null) goto L83;
        if (r22.isShowing() != true) goto L83;
        GuestTalkBeInvitedDialog r23 = ((MultiLinkVoiceBaseGuestLinkWidget) this).L;
        if (r23 == null) goto L83;
        r23.dismiss();     // Catch: Exception -> L78
    L78:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r24 = DialogFragmentLancet.sLastShowStack;
        if (r24 == null) goto L83;
        com.bytedance.crash.d.d(r24, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L83:
        if (vm2.d.U() == false) goto L85;
    L87:
        com.bytedance.android.livesdk.chatroom.u r25 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r25 == null) goto L92;
        com.bytedance.live.datacontext.m r26 = r25.I1();
        if (r26 == null) goto L92;
        r26.setValue(Boolean.FALSE);
    L92:
        com.bytedance.android.live.liveinteract.plantform.base.g r27 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r27 == null) goto L95;
        r27.Sc();
    L95:
        tc0.c.h().F = "";
        if (vm2.d.l0() == false) goto L104;
        Widget.WidgetCallback r28 = ((Widget) this).widgetCallback;
        if (r28 == null) goto L104;
        if (r28.getWidgetManager() == null) goto L104;
        if (((Widget) this).widgetCallback.getWidgetManager().getContext() != null) goto L104;
        ((Widget) this).subWidgetManager = null;
    L104:
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L108;
        Integer r30 = (Integer) r29.get("data_link_state", 0);
        if (r30 == null) goto L108;
    L112:
        if (r30 == null) goto L114;
        r30.intValue();
        boolean r31 = !gd0.v.a(r30.intValue(), 8);
    L115:
        if (r31 == false) goto L117;
    L127:
        mr(new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, null, false, false, null, 60));
    L129:
        if (vm2.h.E() == true) goto L136;
        KtvContext.Companion.getClass();
        KtvContext r32 = KtvContext.a.g();
        if (r32 == null) goto L136;
        com.bytedance.android.live.ktv.common.util.k r33 = r32.getStatisticHelper();
        if (r33 == null) goto L136;
        r33.b.clear();
        r33.a = null;
    L136:
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.u r34 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r34 == null) goto L143;
        com.bytedance.live.datacontext.j r35 = r34.J();
        if (r35 == null) goto L143;
        LivePlayModeLogContext r36 = (LivePlayModeLogContext) r35.getValue();
        if (r36 == null) goto L143;
        r36.clearPlayModesOnlySupportMultiPeople();
    L143:
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        com.bytedance.android.live.liveinteract.linksecurity.c.g.l();
        if (vm2.d.j0() == false) goto L155;
        WidgetManager r37 = ((Widget) this).subWidgetManager;
        if (r37 == null) goto L155;
        List r38 = r37.widgets;
        if (r38 == null) goto L155;
        if (r38.size() <= 0) goto L155;
        Iterator r39 = ((Widget) this).subWidgetManager.widgets.iterator();
    L153:
        if (r39.hasNext() == false) goto L155;
        ((Widget) this).subWidgetManager.unload((Widget) r39.next());
    L155:
        sh0.d0 r40 = sh0.d0.b;
        ne0.c r41 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r41 == null) goto L158;
        r41.d0(r40, null);
    L158:
        sh0.i0 r42 = sh0.j0.a;
        sh0.j0.b(((Widget) this).dataCenter);
        hg6.g r43 = P2();
        if (r43 == null) goto L162;
        r43.i(false);
    L162:
        if (vm2.d.U() == false) goto L168;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.clear();
        return;
    L168:
        return;
    L117:
        if (this.b1 == true) goto L127;
        com.bytedance.android.livesdk.chatroom.u r44 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r44 == null) goto L124;
        com.bytedance.live.datacontext.n r45 = r44.b();
        if (r45 == null) goto L124;
        r45.setValue(null);
    L124:
        KtvRoomContainerWidget r46 = this.Y;
        if (r46 == null) goto L129;
        r46.onBizLeaveRoom();
        goto L129
    L114:
        r31 = false;
    L108:
        IInteractService r47 = jc1.k.f(IInteractService.class);
        if (r47 == null) goto L111;
        r30 = Integer.valueOf(r47.getLinkMode());
        goto L112
    L111:
        r30 = null;
        goto L112
    L85:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).S.isDisposed() == true) goto L87;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.dispose();
        goto L87
    L66:
        if (r21.isShowing() != true) goto L70;
        com.bytedance.android.live.liveinteract.widget.widget.q r48 = this.H0;
        if (r48 == null) goto L70;
        Zq(r48);
        goto L70
    L54:
        r19 = false;
        goto L55
    L35:
        r13 = false;
        goto L36
    }

    public final void onResume() {
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget*/.onResume();
        WeakHandler r0 = this.L0;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        boolean r1 = true;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).R = true;
        hg6.g r2 = P2();
        if (r2 == null) goto L9;
        r2.onResume();
    L9:
        if (this.y1 == 9) goto L11;
    L13:
        Lazy r3 = KtvSettingHelper.a;
        if (((Boolean) KtvSettingHelper.f1.getValue()).booleanValue() == false) goto L21;
        hg6.g r4 = P2();
        if (r4 != null) goto L18;
    L25:
        r1 = false;
    L26:
        if (r1 == true) goto L28;
    L43:
        hg6.g r5 = P2();
        if (r5 == null) goto L47;
        r5.i(com.bytedance.android.live.liveinteract.spatial.a.e(C0()));
        return;
    L47:
        return;
    L28:
        if (vm2.e.a() == false) goto L30;
        cr().g();
    L30:
        Aq().r0();
        if (vm2.e.a() == false) goto L35;
        if (cr().p == false) goto L35;
    L37:
        jg6.a r6 = Eq();
        if (r6 == null) goto L42;
        kg6.e r7 = r6.b();
        if (r7 == null) goto L42;
        r7.y(false, "onResume");
    L42:
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new zg1.a1(3));
    L35:
        if (Pq().o() != 3) goto L37;
        Pq().l("onResume");
        goto L37
    L18:
        if (r4.A() != true) goto L25;
    L21:
        if (isEngineOn() == false) goto L25;
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L25;
    L11:
        if (this.V0 == false) goto L13;
        lr(jc1.k.n(IKtvService.class).isCurrentUserIsSinger());
        this.V0 = false;
        goto L13
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L6;
        cr().h();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final hg6.g rtcManger() {
        hg6.g r0 = P2();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void B() {
        super.B();
    }

    public final BizLinkServiceType Kq() {
        return BizLinkServiceType.KtvGuest;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final tf0.h getInteractAnimationService() {
        return this.S1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final kk0.g getLinkMicSeatCallback() {
        return this.Y;
    }

    public final int getScene() {
        return this.y1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final com.bytedance.android.live.pushstream.d guestLiveStream() {
        return ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final boolean ktvWillAutoSilenceSelf() {
        return ((MultiLinkVoiceBaseGuestLinkWidget) this).K;
    }

    public KtvRoomGuestWidget(hh1.w0 r3) {
        super(tc0.c.h());
        this.F2 = r3;
        this.k0 = LazyKt.lazy(new KtvRoomGuestWidget$roomDataEntity$2(this));
        this.b1 = true;
        this.x1 = -1;
        this.M1 = new HashMap(9);
        this.P1 = new HashMap();
        this.g2 = new i(this);
        this.y2 = new com.bytedance.android.live.liveinteract.utils.k0();
        this.E2 = new j(this);
    }

    public static void Zq(com.bytedance.android.live.liveinteract.widget.widget.q r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void H0(com.bytedance.android.livesdk.link.model.bridge.z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super.H0(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void M0(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        showFollowGuideDialog(false, new com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.j(this, r2));
    }

    public final void M4(cc6.b r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        Intrinsics.checkNotNullParameter(r10, "error");
        gg6.a.a(r10);
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L13;
        String r1 = ((MultiLinkVoiceBaseGuestLinkWidget) this).E;
        String r2 = ((MultiLinkVoiceBaseGuestLinkWidget) this).w;
        LinkApplyType r3 = ((MultiLinkVoiceBaseGuestLinkWidget) this).x;
        yf6.b r0 = Yq();
        if (r0 == null) goto L10;
        vf6.a r4 = r0.a9();
        if (r4 == null) goto L10;
        String r5 = r4.b;
        if (r5 == null) goto L10;
    L11:
        com.bytedance.android.live.liveinteract.voicechat.util.k.B(r1, r2, r3, r5, fr(), r10.a, r10.b);
        return;
    L10:
        r5 = "";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void O(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        super.O(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void P(com.bytedance.android.livesdk.link.model.bridge.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super.P(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final hh1.v0 Q0(String r1) {
        return super.Q0(r1);
    }

    public final void Vj(ILinkPlayerInfoBridge r7) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.INFO);
        ILiveLinkCameraBackUpConfig r0 = vm2.g.c();
        if (ILiveLinkCameraBackUpConfigKt.supportMsgUpdateForAudience(r0) == true) goto L6;
        return;
    L6:
        if (r7.getUser() == null) goto L39;
        IBaseUser r1 = r7.getUser();
        if (r1 == null) goto L10;
        String r2 = r1.getIdString();
    L12:
        if ((!Intrinsics.areEqual(r2, je0.d.b0())) == false) goto L15;
        return;
    L15:
        if (r7.isBackground() == false) goto L17;
        return;
    L17:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == false) goto L46;
        com.bytedance.android.live.pushstream.d r3 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        if (r3 == null) goto L24;
        Intrinsics.checkNotNull(r3);
        if (r3.getLiveCore() == null) goto L24;
        com.bytedance.android.live.pushstream.d r4 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        Intrinsics.checkNotNull(r4);
        boolean r5 = r4.getLiveCore().t0();
    L26:
        if (r7.getSilenceStatus() == 0) goto L37;
        if (r5 == true) goto L36;
        int r6 = this.V1 + 1;
        this.V1 = r6;
        Set r8 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r6, null, Boolean.valueOf(r5), r7.getSilenceStatus(), r7.getLinkType());
        if (this.V1 < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r0)) goto L41;
        jg6.a r9 = Eq();
        if (r9 == null) goto L35;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L35;
        r10.t(new kg6.b(false, false, "link security", 8));
    L35:
        this.V1 = 0;
        return;
    L41:
        return;
    L36:
        this.V1 = 0;
        return;
    L37:
        this.V1 = 0;
        return;
    L24:
        r5 = false;
        goto L26
    L46:
        return;
    L10:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void accept(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        ag6.b r0 = L5();
        if (r0 == null) goto L6;
        r0.b(r3, ((MultiLinkVoiceBaseGuestLinkWidget) this).P);
        return;
    }

    public final void bd(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        super.bd(r2);
        KtvRoomContainerWidget r3 = this.Y;
        if (r3 == null) goto L6;
        r3.wq();
        return;
    }

    public final void handleMsg(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        isViewValid();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void i(IApplyResult r1) {
        super.i(r1);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (this.y1 != 9) goto L5;
        int r0 = 64;
    L6:
        r3.a = r0;
        ag6.b r1 = L5();
        if (r1 == null) goto L10;
        r1.a(r3, ((MultiLinkVoiceBaseGuestLinkWidget) this).Q);
        return;
    L10:
        return;
    L5:
        r0 = 8;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void kickOut(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        com.bytedance.live.bizlink.impl.platform.manager.a r1 = r0.A0();
        if (r1 == null) goto L9;
        r1.h(r3, "admin_stop_normal");
        return;
    L9:
        return;
    }

    public final void l1(com.bytedance.android.livesdk.chatroom.model.g1 r1) {
        super.l1(r1);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).C = null;
    }

    public final void lr(boolean r9) {
        StringBuilder r0 = new StringBuilder("onIsSingerChanged ");
        r0.append(r9);
        r0.append(" mute=");
        VoiceChatMuteManager r1 = Pq();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isMute());
    L6:
        r0.append(r2.booleanValue());
        r0.append(" shouldRestore=");
        r0.append(((MultiLinkVoiceBaseGuestLinkWidget) this).K);
        r0.append(" isResumed=");
        r0.append(((MultiLinkVoiceBaseGuestLinkWidget) this).R);
        r0.append(" rtcOn=");
        r0.append(isEngineOn());
        r0.append(", isGuestMute=");
        if (Lq() != 0) goto L9;
    L11:
        boolean r3 = false;
    L12:
        r0.append(r3);
        jy0.b.d("voice_chat", r0.toString());
        if (isEngineOn() == true) goto L16;
        return;
    L16:
        if (r9 == false) goto L60;
        if (KtvUtilsKt.g() == false) goto L40;
        if (Pq().isMute() == true) goto L29;
        if (Lq() != 0) goto L24;
    L26:
        boolean r4 = false;
    L27:
        if (r4 == true) goto L29;
    L32:
        if (this.V == true) goto L35;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).K = false;
    L35:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == false) goto L37;
    L44:
        jg6.a r5 = Eq();
        if (r5 == null) goto L50;
        lh6.b r6 = r5.a();
        if (r6 == null) goto L50;
        ng6.c.a.a(r6, false);
    L50:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L84;
        jy0.b.d("ttlive_link_rtc", "ktv singer startVideoCapture singMode:AUDIO");
        jg6.a r7 = Eq();
        if (r7 == null) goto L56;
        lh6.b r8 = r7.a();
        if (r8 == null) goto L56;
        r8.i("ktvroom guestwidget ktv singer startVideoCapture");
    L56:
        hg6.g r10 = P2();
        if (r10 == null) goto L84;
        r10.e0("guestBecomeSinger AUDIO");
    L84:
        this.V = r9;
        if (com.bytedance.android.live.liveinteract.spatial.a.e(C0()) == false) goto L92;
        jy0.b.a("SpatialAudio_KtvRoomGuestWidget", "onKtvSingerStateChanged updateSpatialAudioPosition------");
        KtvRoomContainerWidget r11 = this.Y;
        if (r11 == null) goto L92;
        qe2.a r12 = r11.e;
        if (r12 == null) goto L92;
        r12.b();
    L92:
        if (vm2.d.k0() == false) goto L100;
        if (r9 == false) goto L95;
        int r13 = 4;
    L96:
        hg6.g r14 = P2();
        if (r14 == null) goto L101;
        r14.X(r13, "currentUserSingerChanged");
        return;
    L101:
        return;
    L95:
        r13 = 3;
        goto L96
    L100:
        return;
    L37:
        if (Pq().isMute() == false) goto L44;
        this.V0 = true;
        goto L44
    L24:
        if (Lq() == (-1)) goto L26;
        r4 = true;
    L29:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == false) goto L32;
        com.bytedance.android.live.liveinteract.voicechat.b.a.a(Pq(), "force UnSilence", true, null, 8);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).K = true;
        goto L35
    L40:
        if (Pq().isMute() == false) goto L44;
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == false) goto L44;
        com.bytedance.android.live.liveinteract.voicechat.b.a.a(Pq(), "force UnSilence", true, null, 8);
        goto L44
    L60:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).K == false) goto L70;
        Integer r15 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r15 != null) goto L65;
    L69:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).K = false;
        goto L70
    L65:
        if (r15.intValue() != 2) goto L69;
        Pq().s();
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == true) goto L69;
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    L70:
        jg6.a r16 = Eq();
        if (r16 == null) goto L76;
        lh6.b r17 = r16.a();
        if (r17 == null) goto L76;
        ng6.c.a.a(r17, true);
    L76:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L84;
        jy0.b.d("ttlive_link_rtc", "ktv not singer stopVideoCapture");
        cg6.a r18 = Bq();
        if (r18 == null) goto L84;
        jg6.a r19 = r18.e5();
        if (r19 == null) goto L84;
        lh6.b r20 = r19.a();
        if (r20 == null) goto L84;
        r20.j("ktvroom guestwidget ktv not singer stopVideoCapture");
        goto L84
    L9:
        if (Lq() == (-1)) goto L11;
        r3 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void mr(com.bytedance.android.livesdk.chatroom.viewmodel.i r32) {
        int r2 = this.y1;
        int r3 = this.G1;
        int r4 = r32.a;
        this.y1 = r4;
        int r5 = r32.b;
        this.G1 = r5;
        if (r2 != r4) goto L5;
        boolean r8 = true;
    L6:
        if (r3 != r5) goto L8;
        boolean r9 = true;
    L9:
        if (r8 == false) goto L12;
        if (r9 == false) goto L12;
        return;
    L12:
        boolean r6 = com.bytedance.android.live.ktv.common.util.KtvUtilsKt.I(r4, r5);
        mz0.f r7 = null;
        if (r6 == false) goto L15;
        pr(r32.a, r32.b);
    L53:
        KtvRoomContainerWidget r10 = this.Y;
        if (r10 == null) goto L57;
        int r11 = KtvRoomContainerWidget.R;
        r10.Lq(r32, false);
    L57:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.I(r32.a, r32.b) == false) goto L59;
        KtvRoomContainerWidget r12 = this.Y;
        if (r12 == null) goto L66;
        r12.onBizEnterRoom();
    L66:
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", new nh0.f("linkmic", new nh0.e(9, 0, com.bytedance.android.live.liveinteract.plantform.utils.u0.d(), 0, 0, null, null, null, 248), null, null, null, null, false, 224));
    L68:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.I(r32.a, r32.b) == true) goto L70;
    L135:
        mz0.f r1 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r1 instanceof mz0.f) == false) goto L139;
        r7 = r1;
    L139:
        mz0.f r13 = r7;
        if (r13 == null) goto L142;
        r13.c(new com.bytedance.android.livesdk.log.filter.y(this.y1));
    L142:
        int r14 = this.y1;
        if (r2 == r14) goto L149;
        com.bytedance.android.live.liveinteract.utils.g0 r15 = this.T1;
        if (r15 == null) goto L149;
        if (r14 == 0) goto L148;
        r15.a(r2, Integer.valueOf(r3), this.y1, Integer.valueOf(this.G1));
        goto L149
    L148:
        r15.c(r2);
    L149:
        int r16 = this.y1;
        if (r16 != 5) goto L156;
        int r17 = this.G1;
        if (r17 == r3) goto L156;
        com.bytedance.android.live.liveinteract.utils.g0 r18 = this.T1;
        if (r18 == null) goto L156;
        r18.b(r16, r3, r17);
    L156:
        com.bytedance.android.live.liveinteract.plantform.base.g r19 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r19 == null) goto L159;
        r19.o6(dr(this.y1), false);
    L159:
        SpatialAudioContext.a r20 = SpatialAudioContext.Companion;
        if (r20.getContext() != null) goto L162;
        SpatialAudioStrategyManager.c.a();
    L162:
        SpatialAudioContext r21 = r20.getContext();
        if (r21 == null) goto L168;
        com.bytedance.live.datacontext.m r22 = r21.getCurrentStrategyId();
        if (r22 == null) goto L169;
        r22.setValue(Integer.valueOf(C0()));
        return;
    L169:
        return;
    L168:
        return;
    L70:
        if (this.y1 == 0) goto L72;
    L73:
        this.p1 = System.currentTimeMillis();
    L74:
        int r23 = this.y1;
        int r24 = this.G1;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r25 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r23), Integer.valueOf(r24), null, null) == true) goto L102;
        String r26 = TalkRoomLogUtils.p(Integer.valueOf(r2), Integer.valueOf(r3), null);
        String r110 = TalkRoomLogUtils.p(Integer.valueOf(r23), Integer.valueOf(r24), null);
        String r111 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r3));
        String r112 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r24));
        ((MultiLinkVoiceBaseGuestLinkWidget) this).H = null;
        if (r23 == 0) goto L97;
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r26, r110) == false) goto L83;
        if (r2 != 0) goto L97;
    L83:
        if (hd0.c.f().h() == false) goto L93;
        com.bytedance.android.live.liveinteract.voicechat.util.k r27 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r27 == null) goto L87;
        int r28 = 12;
        String r113 = r112;
        r27.A(((MultiLinkVoiceBaseGuestLinkWidget) this).w, Nq(), ((MultiLinkVoiceBaseGuestLinkWidget) this).E, je0.d.j(Aq()), je0.d.Z(), ((MultiLinkVoiceBaseGuestLinkWidget) this).D, ((MultiLinkVoiceBaseGuestLinkWidget) this).z, ((MultiLinkVoiceBaseGuestLinkWidget) this).A, getMRoom().getCircleInfo(), null, Long.valueOf(br()), hr(), r110, r113, null, null, null, null);
    L88:
        yf6.b r29 = Yq();
        if (r29 == null) goto L94;
        vf6.a r30 = r29.a9();
        if (r30 == null) goto L94;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r30.b = "";
    L94:
        com.bytedance.android.live.liveinteract.voicechat.util.k r31 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r31 == null) goto L102;
        com.bytedance.android.live.liveinteract.voicechat.util.k.y(r31, r110, r113, null, r28);
        goto L102
    L87:
        r113 = r112;
        r28 = 12;
        goto L88
    L93:
        r113 = r112;
        r28 = 12;
    L97:
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r111, r112) == true) goto L102;
        com.bytedance.android.live.liveinteract.voicechat.util.k r114 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r114 == null) goto L102;
        com.bytedance.android.live.liveinteract.voicechat.util.k.y(r114, null, r112, null, 12);
    L102:
        if (r23 == 0) goto L134;
        int r33 = this.y1;
        if (r2 != 0) goto L107;
    L105:
        boolean r34 = true;
    L110:
        if (r34 == false) goto L134;
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L134;
        HashMap r35 = new HashMap();
        if (vm2.h.R() == false) goto L116;
        r35.put("room_id", String.valueOf(getMRoom().getId()));
        r35.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r36 = getMRoom().getStreamType();
        int r115 = com.bytedance.android.live.core.utils.h1.a;
        r35.put("live_type", com.bytedance.android.live.core.utils.i1.a(r36));
    L116:
        com.bytedance.android.live.liveinteract.voicechat.util.k r37 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r37 == null) goto L119;
        r37.o(r35, r23, r24, getMRoom().getCircleInfo());
    L119:
        com.bytedance.android.live.liveinteract.voicechat.util.k r38 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r38 == null) goto L123;
        r38.p(r35, r23, r24, getMRoom().getCircleInfo());
    L123:
        if (Intrinsics.areEqual("syncRoom", getSource()) == false) goto L129;
        if (r2 != 0) goto L129;
        long r116 = this.h1;
        long r117 = this.g1;
        if (r116 >= r117) goto L128;
        TalkRoomLogUtils.U(Long.valueOf(r117 - r116));
    L131:
        if (Intrinsics.areEqual("syncRoom", getSource()) == false) goto L133;
        if (r2 == 0) goto L134;
    L133:
        TalkRoomLogUtils.o0(r35);
        goto L134
    L128:
        TalkRoomLogUtils.m0(getMRoom(), System.currentTimeMillis(), TalkRoomLogUtils.z);
    L129:
        TalkRoomLogUtils.n0(r35);
        goto L131
    L107:
        if (r2 == 16) goto L109;
        if (r33 != 16) goto L105;
    L109:
        r34 = false;
    L134:
        jy0.b.a("InteractAnimationController", "afterSceneChange fromScene:" + r2 + ",fromUiLayout:" + r3 + ",toScene:" + r23 + ",toUiLayout:" + r24);
        goto L135
    L72:
        if (this.G1 == 0) goto L74;
    L59:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.I(r2, r3) == false) goto L68;
        KtvRoomContainerWidget r39 = this.Y;
        if (r39 == null) goto L68;
        r39.onBizDestory();
        goto L68
    L15:
        pr(r32.a, r32.b);
        Integer r40 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r40 != null) goto L19;
    L23:
        int r41 = this.y1;
        if (r41 != 5) goto L29;
        if (r2 != 9) goto L37;
        ChatMatchWidget r42 = ((MultiLinkVoiceBaseGuestLinkWidget) this).N;
        if (r42 == null) goto L37;
        r42.yq();
    L37:
        if (this.y1 == 9) goto L39;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).D = null;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).C = null;
        com.bytedance.android.live.liveinteract.widget.widget.q r43 = this.H0;
        if (r43 != null) goto L44;
    L48:
        if (r2 == 9) goto L50;
    L52:
        LinkedHashMap r44 = new LinkedHashMap();
        r44.put("reason", "switch_scene_event");
        com.bytedance.android.live.liveinteract.plantform.utils.i.c(r32.a, r32.b, r44);
        goto L53
    L50:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L52;
        com.bytedance.android.live.liveinteract.voicechat.util.k.s(gr());
        goto L52
    L44:
        if (r43.isShowing() != true) goto L48;
        com.bytedance.android.live.liveinteract.widget.widget.q r45 = this.H0;
        if (r45 == null) goto L48;
        Zq(r45);
        goto L48
    L39:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L48;
        com.bytedance.android.live.liveinteract.voicechat.util.k.r();
        goto L48
    L29:
        if (r41 != 9) goto L37;
        if (vm2.d.e().a() == false) goto L37;
        if (r2 != 5) goto L37;
        ChatMatchWidget r46 = ((MultiLinkVoiceBaseGuestLinkWidget) this).N;
        if (r46 == null) goto L37;
        r46.yq();
        goto L37
    L19:
        if (r40.intValue() != 1) goto L23;
        if (tc0.c.h().K != LinkApplyType.PREPARE_APPLY.getValue()) goto L23;
        int r47 = this.y1;
        goto L23
    L8:
        r9 = false;
        goto L9
    L5:
        r8 = false;
        goto L6
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (isViewValid() == false) goto L67;
        if (r8 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r8.getKey()) == false) goto L8;
        return;
    L8:
        if (r8.getData() == null) goto L82;
        String r0 = r8.getKey();
        if (Intrinsics.areEqual(r0, "cmd_open_interact_manage_dialog_by_anchor") == false) goto L28;
        if (je0.d.c0() == true) goto L15;
    L26:
        xs2.b.a().post(new UserProfileEvent(getMRoom().getOwner()).setReportType("data_card_linked_anchor"));
        return;
    L15:
        if (hd0.c.f().h() == false) goto L26;
        LinkPlayerInfo r9 = Aq().o(getMRoom().getOwnerUserIdString(), "");
        if (r9 == null) goto L70;
        Context r1 = ((Widget) this).context;
        DataCenter r2 = ((Widget) this).dataCenter;
        LinkPlayerInfo r10 = r9;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r10, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L21;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r3 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r10, "seat", false);
    L25:
        r3.a();
        return;
    L21:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r5 = new KtvRoomInteractEmojiPanel(r1, r2, r10);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        ((InteractEmojiPanel) r5).k = "seat";
        ((InteractEmojiPanel) r5).r = false;
        tb6.c r11 = ((InteractEmojiPanel) r5).x;
        if (r11 == null) goto L24;
        r11.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r11.d = "seat";
    L24:
        r3 = r5;
        goto L25
    L70:
        return;
    L28:
        if (Intrinsics.areEqual(r0, "cmd_audio_talk_invite") == false) goto L44;
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L39;
        IBaseUser r12 = (IBaseUser) r8.getData();
        if (r12 != null) goto L34;
        r12 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L34:
        com.bytedance.android.live.liveinteract.videolink.a r4 = new com.bytedance.android.live.liveinteract.videolink.a(getMRoom(), r12, -1);
        if (this.b2 == null) goto L37;
        r4.e = 3;
    L37:
        this.b2 = null;
        invite(r4);
        Intrinsics.checkNotNull(r12);
        TalkRoomLogUtils.C("administrator", r12.getIdString(), "card", -1);
        return;
    L39:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L41;
        f2.b(2131914522, 0);
    L42:
        com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.INVITE);
        return;
    L41:
        f2.b(2131917298, 0);
        goto L42
    L44:
        if (Intrinsics.areEqual(r0, "cmd_show_guest_apply_dialog") == false) goto L53;
        if (Intrinsics.areEqual((Boolean) r8.getData(), Boolean.TRUE) == false) goto L75;
        IRoom r13 = getMRoom();
        if (r13 == null) goto L76;
        ILinkPanelService r6 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r6 == null) goto L77;
        ILinkPanelService.a.a(r6, ((Widget) this).context, r13, null, null);
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L53:
        if (Intrinsics.areEqual(r0, "cmd_operate_interact_media") == false) goto L62;
        MediaOperation r14 = (MediaOperation) r8.getData();
        if (r14 != null) goto L57;
        return;
    L57:
        if (r14.getType() != MediaOperation.Type.MIC) goto L83;
        int r15 = f1.a;
        throw null;
    L83:
        return;
    L62:
        if (Intrinsics.areEqual(r0, "cmd_video_talk_guest_battle_open_panel") == false) goto L80;
        sh0.g r16 = sh0.g.b;
        ne0.c r17 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r17 == null) goto L81;
        r17.d0(r16, null);
        return;
    L81:
        return;
    L80:
        return;
    L82:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void onClickToolbar(int r22) {
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L5;
        showInviteAndPermitDialog(false, "bottom", -1);
        return;
    L5:
        if (r22 == 0) goto L51;
        boolean r6 = true;
        if (r22 == 1) goto L29;
        if (r22 != 2) goto L75;
        ILinkPlayerInfoBridge r1 = Aq().p(je0.d.b0(), tc0.c.h().f);
        if (r1 == null) goto L19;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r1.getSilenceStatus() != 0) goto L17;
        r6 = false;
    L17:
        r4.put("data_self_is_silenced", Boolean.valueOf(r6));
    L19:
        if (jc1.k.n(IInteractService.class).isEnableTalkRoomEmoji() == false) goto L21;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r2 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r2.b(((Widget) this).context);
        r2.c(((Widget) this).dataCenter);
        r2.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        r2.d = "bottom";
        r2.a().a();
        return;
    L21:
        if (r1 == null) goto L27;
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r3 = new com.bytedance.android.live.liveinteract.voicechat.dialog.p(((Widget) this).context, ((Widget) this).dataCenter, r1, false);
        r3.G = "bottom";
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L60;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L60:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L26:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L27:
        jy0.b.c("ttlive_link", "try show dialog when user info is null", null, 4);
        return;
    L75:
        return;
    L29:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.a(getMRoom()) == false) goto L36;
        ChatRoomGuestAppliedDialog r5 = new ChatRoomGuestAppliedDialog(((Widget) this).context, ((Widget) this).dataCenter, new j1(this));
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L56;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L56:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
    L34:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    L36:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.a(getMRoom()) == false) goto L44;
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L40;
        showInviteAndPermitDialog(false, "bottom", -1);
        return;
    L40:
        ILinkPanelService r7 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r7 == null) goto L70;
        ILinkPanelService.a.a(r7, ((Widget) this).context, getMRoom(), null, "bottom");
        return;
    L70:
        return;
    L44:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.b() == false) goto L46;
        or(false, getMRoom());
        return;
    L46:
        com.bytedance.android.live.liveinteract.voicechat.dialog.g r8 = new com.bytedance.android.live.liveinteract.voicechat.dialog.g(((Widget) this).context, ((Widget) this).dataCenter, getMRoom());
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L58;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L58:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L50:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        return;
    L51:
        int r9 = bh0.a.a;
        sf0.a r10 = new sf0.a(-1, 102, LinkApplyType.NORMAL.getValue(), 0, LinkMatchType.NONE, "", "guest_tool_bar_click", 0, 0, 0, false, false, 0, null, null, 0, 524032);
        Intrinsics.checkNotNullParameter(r10, "applyParams");
        Wq(r10);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void onSwitchSceneMessage(com.bytedance.android.livesdk.link.model.bridge.z0 r12) {
        if (r12 == null) goto L38;
        tc0.c r0 = tc0.c.h();
        if (vm2.d.v0() == false) goto L6;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r12);
        String r1 = TalkRoomLogUtils.g();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        TalkRoomLogUtils.j = r1;
    L6:
        r0.r = r12.getMultiLiveCoreInfo();
        r0.m = r12.getLiveCoreExtInfo();
        r0.n = r12.getMultiRtcInfo();
        r0.k = r12.getRtcExtInfo();
        r0.s = r12.getMcuContent();
        if (com.bytedance.android.live.liveinteract.api.utils.m.e(this) == null) goto L41;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r2 != null) goto L12;
    L19:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L22;
        r3.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(r12.getUiLayout()));
    L22:
        com.bytedance.android.livesdk.chatroom.u r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r4 == null) goto L33;
        com.bytedance.live.datacontext.j r5 = r4.s();
        if (r5 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.getValue();
        if (r6 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r10 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(r12.getValidScene(), r12.getUiLayout(), r12.getPlayModes(), false, false, null, 32);
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L31;
        r7.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(r12.getUiLayout()));
    L31:
        r6.c(r6.t());
        r6.d(r10);
    L33:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.I(r12.getValidScene(), r12.getUiLayout()) == true) goto L39;
        KtvRoomContainerWidget r13 = this.Y;
        if (r13 == null) goto L40;
        r13.onBizDestory();
        return;
    L40:
        return;
    L39:
        return;
    L12:
        if (r12.getLinkedListUsers() == null) goto L19;
        jy0.b.d("ttlive_link_audio", "realSwitchScene ListUser=" + je0.d.g0(r12.getLinkedListUsers()));
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r8 = r2.getLinkUserInfoCenter();
        if ((r8 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L16;
        r8 = null;
    L16:
        com.bytedance.android.live.liveinteract.plantform.core.y r9 = (com.bytedance.android.live.liveinteract.plantform.core.y) r8;
        if (r9 == null) goto L19;
        r9.Y4(r12.getLinkedListUsers(), r12.getClientUIInfo(), r12.getVersion(), "switchSceneMsg", r12.getLinkerContentMap());
        goto L19
    L41:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomGuestPresenter.IView
    public final void q(int r5) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (isEngineOn() == true) goto L8;
        return;
    L8:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L31;
        boolean r0 = false;
        if (r5 == 0) goto L24;
        if (r5 != 1) goto L14;
    L21:
        f2.b(2131919412, 0);
        com.bytedance.android.live.liveinteract.linksecurity.c.m(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == true) goto L25;
        com.bytedance.android.live.liveinteract.plantform.utils.x.M();
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    L25:
        boolean r6 = !r0;
        Pq().t(r6);
        G4(r6, "silence message");
        com.bytedance.android.live.liveinteract.plantform.base.g r7 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r7 == null) goto L30;
        r7.Lp(r0);
        return;
    L30:
        return;
    L14:
        if (r5 == 2) goto L21;
        if (r5 != 3) goto L18;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        goto L25
    L18:
        if (r5 == 4) goto L21;
    L24:
        f2.b(2131919449, 0);
        r0 = true;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void setInviteCallback(uf0.c r1) {
        ((MultiLinkVoiceBaseGuestLinkWidget) this).Q = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void setPermitCallback(uf0.d r1) {
        ((MultiLinkVoiceBaseGuestLinkWidget) this).P = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void tryFastMatch(String r5) {
        ChatMatchWidget r6 = ((MultiLinkVoiceBaseGuestLinkWidget) this).N;
        if (r6 == null) goto L6;
        r6.zq(null, true, "song_guide", Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void u(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Sq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void w(com.bytedance.android.livesdk.chatroom.model.g1 r1) {
        super.w(r1);
    }

    public final void G4(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s != null) goto L5;
        return;
    L5:
        if (r6 == false) goto L20;
        cg6.a r8 = Bq();
        if (r8 == null) goto L19;
        jg6.a r9 = r8.e5();
        if (r9 == null) goto L19;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L19;
        if (je0.d.G() == false) goto L15;
    L17:
        boolean r4 = false;
    L18:
        r10.t(new kg6.b(true, r4, r7, 8));
        goto L19
    L15:
        if (je0.d.p() == true) goto L17;
        r4 = true;
    L19:
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.TRUE);
    L28:
        VoiceChatMuteManager r11 = Pq();
        r11.i = System.currentTimeMillis();
        return;
    L20:
        cg6.a r12 = Bq();
        if (r12 == null) goto L27;
        jg6.a r13 = r12.e5();
        if (r13 == null) goto L27;
        kg6.e r14 = r13.b();
        if (r14 == null) goto L27;
        r14.z(new kg6.d(true, true, r7, 8));
    L27:
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.FALSE);
        goto L28
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void accept(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "idString");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        ag6.b r4 = L5();
        if (r4 == null) goto L6;
        r4.b(r0, ((MultiLinkVoiceBaseGuestLinkWidget) this).P);
        return;
    }

    public final void ar(ye0.a r7, int r8) {
        long r0 = System.currentTimeMillis();
        Disposable r9 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).applyStash(getMRoom().getRoomId(), 1, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new g1(r7, r0), new h1(r7, r0));
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r9);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomGuestPresenter.IView
    public final void e0(int r2, LinkMicGuideMessage.AnchorGuideInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "guideInfo");
        if (Aq().b() < r2) goto L6;
        jy0.b.a("ttlive_link", "intercept guide since online count hits limit");
        return;
    L6:
        GuestTalkBeInvitedDialog r4 = ((MultiLinkVoiceBaseGuestLinkWidget) this).L;
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isShowing() != true) goto L13;
        jy0.b.a("ttlive_link", "intercept guide since guest is being invited");
        return;
    }

    public final void e1(String r1, long r2) {
        Aq().getClass();
    }

    public final long er(boolean r3, long r4) {
        if (r3 == false) goto L5;
        return -1;
    L5:
        if (r4 == 0) goto L9;
        if (r4 > System.currentTimeMillis()) goto L9;
        return r4;
    L9:
        return System.currentTimeMillis();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final boolean interceptCloseRoom(Runnable r6, boolean r7) {
        String r8 = ChatMatchWidget.o;
        ChatMatchViewModel r9 = com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        int r0 = com.bytedance.android.live.liveinteract.plantform.widgt.v.a;
        if (com.bytedance.android.live.liveinteract.plantform.widgt.v.a(((Widget) this).context) == false) goto L6;
        return true;
    L6:
        if (r9 == null) goto L10;
        MutableLiveData r10 = r9.getMatchData();
        if (r10 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.model.b1 r11 = (com.bytedance.android.livesdk.chatroom.model.b1) r10.getValue();
    L12:
        if (r11 == null) goto L14;
        return false;
    L14:
        mz0.e r12 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r12 instanceof mz0.f) == true) goto L17;
        r12 = null;
    L17:
        mz0.f r13 = (mz0.f) r12;
        if ((r13 instanceof mz0.f) == false) goto L29;
        String r3 = r13.d();
        if (r3 != null) goto L22;
    L24:
        String r14 = r13.l();
        if (r14 == null) goto L29;
        if (TextUtils.equals(r14, "true") == false) goto L29;
        return false;
    L22:
        if (TextUtils.equals(r3, "true") == false) goto L24;
        return false;
    L29:
        jy0.b.c("KtvRoomGuestWidget", "intercept close room: online state = " + ((Integer) ((ge1.a) hd0.c.f()).b), null, 4);
        Integer r15 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r15 != null) goto L33;
    L34:
        Integer r16 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r16 != null) goto L38;
    L40:
        return false;
    L38:
        if (2 != r16.intValue()) goto L40;
        com.bytedance.android.livesdk.widget.x0.b r17 = new com.bytedance.android.livesdk.widget.x0.b(getContext(), 4);
        r17.l(2131919394);
        r17.i(0, 2131920806, new g(this, r6));
        r17.i(1, 2131915442, h.a);
        r17.n();
        return true;
    L33:
        if (r15.intValue() == 0) goto L40;
    L10:
        r11 = null;
        goto L12
    }

    public final <T> void nr(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void onChangeMediaInfo(ILinkerChangeMediaInfoContent r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.INFO);
        ILinkmicMediaParam r4 = r2.getLinkmicMediaParam();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.getLinkmicMediaType() == LinkmicMediaParam.TYPE_LINKMIC_STREAM_INFO) goto L8;
        return;
    L8:
        if (r4.getLinkmicStreamInfo() == null) goto L26;
        com.bytedance.android.live.liveinteract.plantform.model.r r5 = r4.getLinkmicStreamInfo();
        String r0 = null;
        if (r5 == null) goto L12;
        String r6 = r5.getLiveCoreExtInfo();
    L13:
        com.bytedance.android.live.liveinteract.plantform.model.r r7 = r4.getLinkmicStreamInfo();
        if (r7 == null) goto L16;
        r0 = r7.getRtcExtInfo();
    L16:
        if (r6 == null) goto L20;
        hg6.g r8 = P2();
        if (r8 == null) goto L20;
        r8.J(r6);
    L20:
        if (r0 == null) goto L27;
        hg6.g r9 = P2();
        if (r9 == null) goto L28;
        r9.c(r0);
        return;
    L28:
        return;
    L27:
        return;
    L12:
        r6 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void onSei(String r2, ye1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.INFO);
        if (((Widget) this).isViewValid == true) goto L6;
        return;
    L6:
        if (isEngineOn() == true) goto L11;
        com.bytedance.android.live.liveinteract.api.utils.j r0 = this.X;
        if (r0 == null) goto L12;
        r0.e(r2, r3);
        return;
    L12:
        return;
    }

    public final void or(boolean r3, IRoom r4) {
        String r0 = ChatMatchWidget.o;
        ChatMatchViewModel r1 = com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r1 == null) goto L5;
        r1.showMatchDialog(r3);
        return;
    L5:
        com.bytedance.android.live.liveinteract.voicechat.dialog.g r5 = new com.bytedance.android.live.liveinteract.voicechat.dialog.g(((Widget) this).context, ((Widget) this).dataCenter, r4);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    public final void pr(int r4, int r5) {
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.I(r4, r5) == true) goto L6;
        return;
    L6:
        if (KtvSettingHelper.w() == true) goto L8;
    L10:
        this.Z = true;
        oe2.h r6 = (oe2.h) this.k0.getValue();
        if (r6 == null) goto L15;
        KtvRoomContainerWidget r7 = this.Y;
        if (r7 == null) goto L15;
        r7.Rq(r6);
    L15:
        View r8 = null;
        if (vm2.h.E() == false) goto L30;
        KtvContext.Companion.getClass();
        KtvContext r9 = KtvContext.a.g();
        if (r9 == null) goto L21;
        com.bytedance.android.live.ktv.common.util.k r10 = r9.getStatisticHelper();
    L22:
        if (r10 == null) goto L24;
        r10.a = this;
    L24:
        if (r10 == null) goto L26;
        r10.a();
    L26:
        KtvRoomContainerWidget r0 = this.Y;
        if (r0 == null) goto L30;
        if (r10 == null) goto L30;
        r10.b(r0);
        goto L30
    L21:
        r10 = null;
    L30:
        ((Widget) this).subWidgetManager.load(2131389619, this.Y, false);
        if (KtvSettingHelper.w() == false) goto L35;
        KtvRoomContainerWidget r11 = this.Y;
        if (r11 == null) goto L35;
        r11.onBizShow();
    L35:
        KtvRoomContainerWidget r12 = this.Y;
        if (r12 == null) goto L38;
        View r13 = ((Widget) r12).contentView;
    L40:
        if ((r13 instanceof com.bytedance.android.live.ktv.common.util.c) == false) goto L43;
        r8 = r13;
    L43:
        com.bytedance.android.live.ktv.common.util.c r14 = (com.bytedance.android.live.ktv.common.util.c) r8;
        if (r14 == null) goto L51;
        KtvContext.Companion.getClass();
        KtvContext r15 = KtvContext.a.g();
        if (r15 == null) goto L52;
        com.bytedance.android.live.ktv.common.util.k r16 = r15.getStatisticHelper();
        if (r16 == null) goto L53;
        r16.b(r14);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L38:
        r13 = null;
        goto L40
    L8:
        if (this.Z == false) goto L10;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void showFollowGuideDialog(boolean r9, tf0.q r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.m r1 = r0.y1();
        if (r1 == null) goto L8;
        r1.setValue(Boolean.TRUE);
    L8:
        com.bytedance.android.live.liveinteract.widget.widget.q r2 = this.H0;
        if (r2 != null) goto L11;
    L13:
        com.bytedance.android.live.liveinteract.widget.widget.q r3 = new com.bytedance.android.live.liveinteract.widget.widget.q(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.j(this), this, r9, r10);
        this.H0 = r3;
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L17:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L11:
        if (r2.isShowing() != true) goto L13;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void t(sf0.a r2, IApplyResult r3) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r3, "applyResult");
        super.t(r2, r3);
    }

    public final void J(String[] r10, boolean[] r11, int[] r12) {
        HashMap r0 = new HashMap();
        Intrinsics.checkNotNull(r10);
        int r1 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        Intrinsics.checkNotNull(r12);
        boolean r5 = true;
        int r4 = j22.c.c(r12[r3], true);
        Map<String, Integer> r6 = this.M1;
        HashMap r7 = (HashMap) r6;
        r7.put(r10[r3], Integer.valueOf(r4));
        String r8 = r10[r3];
        if (r4 > 0) goto L8;
        r5 = false;
    L8:
        r0.put(r8, Boolean.valueOf(r5));
        r3 = r3 + 1;
        goto L3
    L9:
        jr(r10, r12, r11);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void M(boolean r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        if (this.Y == null) goto L8;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r5 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r5 == null) goto L9;
        r5.showInviteAndPermitDialog(false, "bottom", -1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void cancelApply(h80.a<Boolean> r2, boolean r3, String r4) {
        ag6.b r5 = L5();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r5.e(new wf6.a(r4, 1));
    }

    public final void jr(String[] r6, int[] r7, boolean[] r8) {
        IBaseUser r9 = getMRoom().getOwner();
        int r1 = 0;
        if (r9 == null) goto L21;
        String r10 = Aq().N4(r9.getIdStrKt());
        if (((HashMap) this.M1).containsKey(r10) == false) goto L21;
        Integer r2 = (Integer) ((HashMap) this.M1).get(r10);
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        KtvRoomContainerWidget r4 = this.Y;
        if (r4 == null) goto L15;
        qe2.a r5 = r4.e;
        if (r5 == null) goto L15;
        r5.a(r3);
    L15:
        hh1.w0 r11 = this.F2;
        if (r11 == null) goto L21;
        if (r3 <= 0) goto L19;
        boolean r12 = true;
    L20:
        r11.Wk(r10, r12);
        goto L21
    L19:
        r12 = false;
        goto L20
    L9:
        r3 = 0;
    L21:
        KtvRoomContainerWidget r13 = this.Y;
        if (r13 == null) goto L26;
        Map<String, Integer> r14 = this.M1;
        Intrinsics.checkNotNullParameter(r14, "talkStateMap");
        qe2.a r15 = r13.e;
        if (r15 == null) goto L26;
        r15.updateTalkState(r14);
    L26:
        Intrinsics.checkNotNull(r6);
        int r16 = r6.length;
    L27:
        if (r1 >= r16) goto L29;
        Map<String, Integer> r17 = this.P1;
        String r18 = r6[r1];
        Intrinsics.checkNotNull(r7);
        HashMap r19 = (HashMap) r17;
        r19.put(r18, Integer.valueOf(j22.c.c(r7[r1], true)));
        r1 = r1 + 1;
        goto L27
    L29:
        this.y2.a(r6, r7);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void showInviteAndPermitDialog(boolean r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "requestPage");
        Intrinsics.checkNotNullParameter(r13, "requestPage");
        Intrinsics.checkNotNullParameter("", "taskName");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L8;
    L16:
        if (r12 == true) goto L18;
        return;
    L18:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L22;
        com.bytedance.android.live.liveinteract.voicechat.util.k.d("administrator");
        return;
    L22:
        return;
    L8:
        if (this.H1 == true) goto L16;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", "");
        ILinkPanelService r3 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r3 == null) goto L12;
        r3.C70(((Widget) this).context, ((Widget) this).dataCenter, 0, r13, r14, getMRoom(), this);
    L12:
        ILinkPanelService r15 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r15 == null) goto L15;
        r15.setOnDismissListener(new x1(this));
    L15:
        this.H1 = true;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void showInviteDialog(boolean r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "requestPage");
        Intrinsics.checkNotNullParameter(r10, "requestPage");
        Intrinsics.checkNotNullParameter("", "taskName");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.H1 == true) goto L15;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", "");
        ILinkPanelService r2 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r2 == null) goto L10;
        r2.ad(((Widget) this).context, ((Widget) this).dataCenter, r10, r11, this);
    L10:
        ILinkPanelService r12 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r12 == null) goto L13;
        r12.setOnDismissListener(new y1(this));
    L13:
        this.H1 = true;
        return;
    }

    public final void ue(String r6, boolean r7, long r8) {
        Intrinsics.checkNotNullParameter(r6, "name");
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r1 = ((Widget) this).dataCenter;
        IRoom r2 = getMRoom();
        if (r2 == null) goto L5;
        Long r3 = Long.valueOf(r2.getId());
    L6:
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r3.longValue()));
        if (r4 != null) goto L9;
        return;
    L9:
        switch(r6.hashCode()) {
            case -1753661428: goto L33;
            case -1332194002: goto L30;
            case -1059173961: goto L27;
            case -629268598: goto L24;
            case -410956671: goto L21;
            case 3497: goto L18;
            case 3351329: goto L15;
            case 103457887: goto L12;
            default: goto L51;
        };
    L51:
        return;
    L12:
        if (r6.equals("lyric") == false) goto L37;
        r4.recordSubElementShow("lyric_load", er(r7, r8));
        return;
    L37:
        return;
    L15:
        if (r6.equals("midi") == false) goto L39;
        r4.recordSubElementShow("midi_load", er(r7, r8));
        return;
    L39:
        return;
    L18:
        if (r6.equals("mv") == false) goto L41;
        r4.recordSubElementShow("mv_load", er(r7, r8));
        r4.recordSubElementShow("background_Load", er(r7, r8));
        return;
    L41:
        return;
    L21:
        if (r6.equals("container") == false) goto L43;
    L25:
        r4.recordSubElementShow("widget_load", er(r7, r8));
        r4.recordSubElementShow("container_load", er(r7, r8));
        return;
    L43:
        return;
    L24:
        if (r6.equals("main_widget") == true) goto L25;
        return;
    L27:
        if (r6.equals("empty_seat") == false) goto L46;
        r4.recordSubElementShow("empty_seat_load", er(r7, r8));
        return;
    L46:
        return;
    L30:
        if (r6.equals(TraceCons.METRIC_BACKGROUND) == false) goto L48;
        r4.recordSubElementShow("background_Load", er(r7, r8));
        return;
    L48:
        return;
    L33:
        if (r6.equals("guest_seat") == false) goto L50;
        r4.recordSubElementShow("guest_seat_load", er(r7, r8));
        return;
    L50:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.e
    public final void v(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "from");
        super.v(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void checkAndApply(int r20, String r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "applySource");
        Intrinsics.checkNotNullParameter(r23, "fromSource");
        sf0.a r14 = new sf0.a(-1, d5.b(r21), r22, 0, null, null, r23, 0, 0, 0, false, false, 0, null, null, 0, 524152);
        Intrinsics.checkNotNullParameter(r14, "applyParams");
        Wq(r14);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void checkAndReply(long r12, String r14, String r15, int r16) {
        Intrinsics.checkNotNullParameter(r14, "secToUserId");
        Intrinsics.checkNotNullParameter(r15, "toUserIdString");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        MultiLinkGuestManager r1 = r0.W4();
        if (r1 == null) goto L9;
        r1.j(new sf0.e(r12, r14, r15, r16, 0, 48, 0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void disconnect(int r9, boolean r10, boolean r11, boolean r12, rj0.c r13) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        jy0.b.d("KtvRoomGuestWidget", String.format("disconnect, disconnectSource: %s, needSureAgain: %s, needToastWhenSuccess: %s, needShowLinkResult: %s", Arrays.copyOf(new Object[]{Integer.valueOf(r9), Boolean.valueOf(r10), Boolean.valueOf(r11), Boolean.valueOf(r12)}, 4)));
        ((MultiLinkVoiceBaseGuestLinkWidget) this).J = r12;
        if (r12 == false) goto L9;
        ag6.b r14 = L5();
        if (r14 == null) goto L25;
        r14.k(new wf6.b("leave_normally", r9, r11, r12, r13, true));
        return;
    L25:
        return;
    L9:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.c(false) == true) goto L18;
        Context r15 = getContext();
        com.bytedance.android.livesdk.widget.x0.d r16 = new com.bytedance.android.livesdk.widget.x0.d();
        r16.b = r15;
        r16.a = 0;
        r16.a = 5;
        r16.k = false;
        r16.c = com.bytedance.android.live.core.utils.s1.B(2131919817);
        r16.d = com.bytedance.android.live.core.utils.s1.B(2131919492);
        String r17 = com.bytedance.android.live.core.utils.s1.B(2131919267);
        c r1 = new c(this, r12, r9, (KtvService.b) r13);
        com.bytedance.android.livesdk.widget.x0.c[] r18 = r16.g;
        com.bytedance.android.livesdk.widget.x0.c r19 = r18[0];
        if (r19 != null) goto L13;
        r19 = new com.bytedance.android.livesdk.widget.x0.c();
        r18[0] = r19;
    L13:
        r19.a = r17;
        r19.b = r1;
        String r20 = com.bytedance.android.live.core.utils.s1.B(2131915442);
        d r110 = d.a;
        com.bytedance.android.livesdk.widget.x0.c[] r111 = r16.g;
        com.bytedance.android.livesdk.widget.x0.c r112 = r111[1];
        if (r112 != null) goto L16;
        r112 = new com.bytedance.android.livesdk.widget.x0.c();
        r111[1] = r112;
    L16:
        r112.a = r20;
        r112.b = r110;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r16.b, r16));
        return;
    L18:
        if (r10 == true) goto L23;
        ag6.b r113 = L5();
        if (r113 == null) goto L26;
        r113.k(new wf6.b("leave_normally", r9, r11, r12, r13, true));
        return;
    L26:
        return;
    L23:
        com.bytedance.android.livesdk.widget.j0.a r114 = new com.bytedance.android.livesdk.widget.j0.a(getContext());
        r114.a = com.bytedance.android.live.core.utils.s1.B(2131919817);
        r114.a(com.bytedance.android.live.core.utils.s1.B(2131919267), new e(this, r12, r9, (KtvService.b) r13));
        r114.b(com.bytedance.android.live.core.utils.s1.B(2131915442), f.a);
        r114.c();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void ktvApply(KtvMusic r7, String r8, LinkApplyType r9, int r10, tf0.b r11) {
        Intrinsics.checkNotNullParameter(r9, "applyType");
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        Rq(r7, r8, r9, 102, r11);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d
    public final void checkAndApply(int r20, String r21, int r22, LinkMatchType r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r21, "applySource");
        Intrinsics.checkNotNullParameter(r23, "matchType");
        Intrinsics.checkNotNullParameter(r24, "fromSource");
        Intrinsics.checkNotNullParameter(r25, "taskName");
        sf0.a r15 = new sf0.a(r20, d5.b(r21), r22, 0, r23, r25, r24, 0, 0, 0, false, false, 0, null, null, 0, 524072);
        Intrinsics.checkNotNullParameter(r15, "applyParams");
        Wq(r15);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void switchAudioByClient(boolean r8, List<com.bytedance.android.livesdk.link.model.bridge.k> r9, ClientUIInfo r10, long r11, Map<Long, ? extends RoomLinkerContent> r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r14, "reason");
        G4(r8, r14);
        Pq().t(r8);
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        if (r8 == false) goto L5;
        String r12 = "silence";
    L6:
        r0.Y4(r9, r10, r11, r12, r13);
        return;
    L5:
        r12 = "unsilence";
        goto L6
    }
}
