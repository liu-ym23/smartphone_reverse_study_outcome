package com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest;

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
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.linkpanel.model.AudienceInviteSource;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.p0;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.g0;
import com.bytedance.android.live.liveinteract.utils.k0;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionWidget;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.model.ChorusGuestStatus;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.KtvRoomInteractEmojiPanel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusGlobalDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.j1;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
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
import fd2.s;
import gd0.v;
import hh1.v0;
import hh1.w0;
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
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.StringCompanionObject;
import sh0.i0;
import sh0.j0;
import uf2.d0;
import zg1.a1;
import zg1.h1;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b:\u0001\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/guest/RealTimeChorusGuestWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseGuestLinkWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/guest/RealTimeChorusGuestPresenter$IView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/live/liveinteract/voicechat/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/guest/c;", "Lkk0/f;", "Lcom/bytedance/android/live/ktv/common/util/l;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/guest/a;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusGuestWidget extends MultiLinkVoiceBaseGuestLinkWidget implements RealTimeChorusGuestPresenter.IView, WeakHandler.IHandler, com.bytedance.android.live.liveinteract.voicechat.a, Observer<KVData>, com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c, kk0.f, com.bytedance.android.live.ktv.common.util.l, com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a {
    public static final /* synthetic */ int G2 = 0;
    public final r E2;
    public final w0 F2;
    public MuteStateChecker G1;
    public com.bytedance.android.live.liveinteract.widget.widget.q H0;
    public InteractAnimationController H1;
    public WeakHandler L0;
    public g0 L1;
    public int M1;
    public boolean P0;
    public String P1;
    public com.bytedance.android.live.liveinteract.voicechat.dialog.p Q1;
    public ih0.d S1;
    public q0 T1;
    public boolean V;
    public long V0;
    public boolean V1;
    public RealTimeChorusGuestPresenter W;
    public com.bytedance.android.live.liveinteract.api.utils.j X;
    public RealTimeChorusMainViewWidget Y;
    public boolean Z;
    public long b1;
    public int b2;
    public long g1;
    public final f g2;
    public long h1;
    public QuickInteractWidget h2;
    public final Lazy k0;
    public long k1;
    public com.bytedance.android.live.liveinteract.plantform.core.h p0;
    public long p1;
    public ThemedCompetitionWidget p2;
    public int v1;
    public LinkmicSubtitleBusinessWidget v2;
    public int x1;
    public RealTimeChorusBusinessWidget x2;
    public InteractLiveCorePermissionGuarantor y1;
    public final k0 y2;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ RealTimeChorusGuestWidget a;
        public final /* synthetic */ int b;

        public b(RealTimeChorusGuestWidget r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            if (((Widget) this.a).dataCenter == null) goto L5;
            a1 r5 = new a1(5);
            r5.b = Integer.valueOf(this.b);
            ((Widget) this.a).dataCenter.put("cmd_interact_state_change", r5);
        L5:
            r3.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ RealTimeChorusGuestWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ rj0.c d;

        public d(RealTimeChorusGuestWidget r1, boolean r2, int r3, KtvService.b r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "dialog");
            r8.dismiss();
            zf6.b r10 = this.a.aA();
            if (r10 == null) goto L6;
            boolean r4 = this.b;
            r10.k(new wf6.b("leave_normally", this.c, true, r4, this.d, 32));
            return;
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class f extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public f(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            if (((Boolean) vm2.h.l0.getValue(null, vm2.h.a[62])).booleanValue() == false) goto L12;
            ArrayList r0 = new ArrayList(r4);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            bn0.b r1 = this.a.getMultiLinkRoomScope();
            if (r1 == null) goto L12;
            jn0.b r2 = jn0.c.a(r1);
            if (r2 == null) goto L12;
            BehaviorSubject r3 = r2.Xh();
            if (r3 == null) goto L12;
            r3.onNext(r0);
        L12:
            if (this.a.v1 == 16) goto L15;
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r4.size());
        L15:
            if (r4.size() <= tc0.c.h().d) goto L18;
            tc0.c r5 = tc0.c.h();
            r5.d = r4.size();
            return;
        }

        public final void n(List<ILinkPlayerInfoBridge> r2, long r3, n0 r5) {
            if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L18;
            String r4 = "";
            if (Lists.isEmpty(r2) == false) goto L7;
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", "");
            return;
        L7:
            RealTimeChorusGuestWidget r6 = this.a;
            int r7 = RealTimeChorusGuestWidget.G2;
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

    public static final class g<T> implements Observer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public g(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            IVoiceLiveTheme r3 = (IVoiceLiveTheme) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (this.a.Y == null) goto L9;
            Intrinsics.checkNotNullParameter(r3, "theme");
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public h(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            RealTimeChorusGuestWidget r0 = this.a;
            boolean r9 = ((Boolean) r8).booleanValue();
            int r1 = RealTimeChorusGuestWidget.G2;
            r0.getClass();
            StringBuilder r2 = new StringBuilder("onIsSingerChanged ");
            r2.append(r9);
            r2.append(" mute=");
            VoiceChatMuteManager r3 = r0.Pq();
            if (r3 == null) goto L5;
            Boolean r4 = Boolean.valueOf(r3.isMute());
        L6:
            r2.append(r4.booleanValue());
            r2.append(" shouldRestore=");
            r2.append(((MultiLinkVoiceBaseGuestLinkWidget) r0).K);
            r2.append(" isResumed=");
            r2.append(((MultiLinkVoiceBaseGuestLinkWidget) r0).R);
            r2.append(" rtcOn=");
            r2.append(r0.isEngineOn());
            r2.append(", isGuestMute=");
            if (r0.Lq() != 0) goto L9;
        L11:
            boolean r5 = false;
        L12:
            r2.append(r5);
            jy0.b.d("voice_chat", r2.toString());
            if (r0.isEngineOn() == true) goto L16;
            return;
        L16:
            if (r9 == false) goto L41;
            if (KtvUtilsKt.e() == false) goto L21;
            ((MultiLinkVoiceBaseGuestLinkWidget) r0).K = false;
        L25:
            jg6.a r10 = r0.Eq();
            if (r10 == null) goto L31;
            lh6.b r11 = r10.a();
            if (r11 == null) goto L31;
            ng6.c.a.a(r11, false);
        L31:
            if (((MultiLinkVoiceBaseGuestLinkWidget) r0).s == null) goto L66;
            jy0.b.d("ttlive_link_rtc", "ktv singer startVideoCapture singMode:AUDIO");
            jg6.a r12 = r0.Eq();
            if (r12 == null) goto L37;
            lh6.b r13 = r12.a();
            if (r13 == null) goto L37;
            r13.i("realtimechorus guestwidget ktv singer startVideoCapture");
        L37:
            hg6.g r14 = r0.P2();
            if (r14 == null) goto L67;
            r14.e0("guestBecomeSinger AUDIO");
            return;
        L67:
            return;
        L66:
            return;
        L21:
            if (r0.Pq().isMute() == false) goto L25;
            if (((MultiLinkVoiceBaseGuestLinkWidget) r0).R == false) goto L25;
            com.bytedance.android.live.liveinteract.voicechat.b.a.a(r0.Pq(), "force UnSilence", true, null, 8);
            goto L25
        L41:
            if (((MultiLinkVoiceBaseGuestLinkWidget) r0).K == false) goto L51;
            Integer r15 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r15 != null) goto L46;
        L50:
            ((MultiLinkVoiceBaseGuestLinkWidget) r0).K = false;
            goto L51
        L46:
            if (r15.intValue() != 2) goto L50;
            r0.Pq().s();
            if (((MultiLinkVoiceBaseGuestLinkWidget) r0).R == true) goto L50;
            ((Widget) r0).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
        L51:
            jg6.a r16 = r0.Eq();
            if (r16 == null) goto L57;
            lh6.b r17 = r16.a();
            if (r17 == null) goto L57;
            ng6.c.a.a(r17, true);
        L57:
            if (((MultiLinkVoiceBaseGuestLinkWidget) r0).s == null) goto L69;
            jy0.b.d("ttlive_link_rtc", "ktv not singer stopVideoCapture");
            cg6.a r18 = r0.Bq();
            if (r18 == null) goto L70;
            jg6.a r19 = r18.e5();
            if (r19 == null) goto L71;
            lh6.b r20 = r19.a();
            if (r20 == null) goto L72;
            r20.j("realtimechorus guestwidget ktv not singer stopVideoCapture");
            return;
        L72:
            return;
        L71:
            return;
        L70:
            return;
        L69:
            return;
        L9:
            if (r0.Lq() == (-1)) goto L11;
            r5 = true;
            goto L12
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public i(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            RealTimeChorusGuestWidget r0 = this.a;
            int r1 = RealTimeChorusGuestWidget.G2;
            r0.nr((com.bytedance.android.livesdk.chatroom.viewmodel.i) r3);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public j(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            hg6.g r0 = this.a.P2();
            if (r0 == null) goto L6;
            r0.w(r3);
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public k(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            jy0.b.a("SpatialAudio_RealTimeChorusGuestWidget", "CurrentStrategyId onValueChanged " + r4);
            hg6.g r0 = this.a.P2();
            if (r0 == null) goto L6;
            r0.i(com.bytedance.android.live.liveinteract.spatial.a.e(r4.intValue()));
            return;
        }
    }

    public static final class l<T> implements Observer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final void onChanged(Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
            if (r0 == null) goto L6;
            r0.Lp(!r3);
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public m(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((jd0.f) r2, "event");
            RealTimeChorusGuestWidget r3 = this.a;
            int r0 = RealTimeChorusGuestWidget.G2;
            r3.getClass();
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public n(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((h1) r2, "event");
            RealTimeChorusGuestWidget r3 = this.a;
            int r0 = RealTimeChorusGuestWidget.G2;
            r3.getClass();
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public o(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            i1 r3 = (i1) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            if (this.a.Y == null) goto L6;
            boolean r4 = r3.b;
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestWidget$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02651 extends MutablePropertyReference0Impl {
        public C02651(RealTimeChorusGuestWidget r7) {
            super(r7, RealTimeChorusGuestWidget.class, "mPresenter", "getMPresenter()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/guest/RealTimeChorusGuestPresenter;", 0);
        }

        public Object get() {
            RealTimeChorusGuestPresenter r0 = ((RealTimeChorusGuestWidget) ((CallableReference) this).receiver).W;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        L5:
            return r0;
        }

        public void set(Object r2) {
            RealTimeChorusGuestPresenter r3 = (RealTimeChorusGuestPresenter) r2;
            ((RealTimeChorusGuestWidget) ((CallableReference) this).receiver).W = r3;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public p(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            u22.b r6 = (u22.b) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            RealTimeChorusGuestWidget r0 = this.a;
            int r1 = RealTimeChorusGuestWidget.G2;
            r0.getClass();
            Iterator r2 = r6.a.iterator();
        L4:
            if (r2.hasNext() == false) goto L15;
            String r3 = (String) r2.next();
            int r4 = u22.b.c;
            if (Intrinsics.areEqual("30000001", r3) == false) goto L4;
            if (((MultiLinkVoiceBaseGuestLinkWidget) r0).I == null) goto L14;
            com.bytedance.android.live.liveinteract.voicechat.util.k.F(r0.getMRoom().getOwnerUserIdString(), r6.b);
            return;
        L14:
            return;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public q(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            o42.g r4 = (o42.g) r3;
            RealTimeChorusGuestWidget r0 = this.a;
            int r1 = RealTimeChorusGuestWidget.G2;
            r0.getClass();
            if (r4 == null) goto L5;
            IBaseUser r2 = r4.a;
        L6:
            if (r2 == null) goto L10;
            r0.P1 = r4.b;
            ((Widget) r0).dataCenter.put("cmd_audio_talk_invite", r4.a);
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class r implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ RealTimeChorusGuestWidget a;

        public final void b(boolean r1) {
        }

        public r(RealTimeChorusGuestWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L8;
            this.a.G4(true, "on particular page show");
            if (this.a.Lq() != 0) goto L19;
            this.a.pr(3);
            this.a.Pq().k("onPause");
            return;
        L19:
            return;
        L8:
            if (this.a.isEngineOn() == false) goto L21;
            RealTimeChorusGuestWidget r5 = this.a;
            if (((MultiLinkVoiceBaseGuestLinkWidget) r5).s != null) goto L12;
            return;
        L12:
            if (r5.Lq() == 3) goto L14;
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

    public final void J(String[] r1, boolean[] r2, int[] r3) {
    }

    public final tf0.o Qq() {
        return null;
    }

    public final void U0(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestPresenter.IView
    public final void V1() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestPresenter.IView
    public final void Y(com.bytedance.android.livesdk.link.model.bridge.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
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
        return 2131567823;
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
        r1.f("RealTimeChorusGuestWidget onEngineEndSuccess");
    L5:
        mr();
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L11;
        ((Widget) this).dataCenter.put("cmd_linker_live_core_release", Boolean.TRUE);
        com.bytedance.android.live.pushstream.d r2 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        if (r2 == null) goto L10;
        r2.release();
    L10:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).s = null;
    L11:
        RealTimeChorusGuestPresenter r3 = this.W;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L14:
        RealTimeChorusGuestPresenter.IView r4 = ((q46.b) r3).a;
        if (r4 == null) goto L18;
        r4.V1();
    L18:
        hg6.g r5 = P2();
        if (r5 == null) goto L21;
        r5.Z(this);
    L21:
        m00.h r6 = ((MultiLinkVoiceBaseGuestLinkWidget) this).t;
        if (r6 == null) goto L24;
        r6.release();
    L24:
        ne0.c r7 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r7 == null) goto L27;
        r7.d0(sh0.e.b, Boolean.FALSE);
    L27:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).t = null;
        MuteStateChecker r0 = this.G1;
        if (r0 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteStateChecker");
    L30:
        if (r0 == null) goto L32;
        r0.c = 0;
        r0.d = 0;
    L32:
        this.y2.b();
        QuickInteractWidget r8 = this.h2;
        if (r8 == null) goto L35;
        r8.xq();
    L35:
        this.V1 = false;
        com.bytedance.android.live.liveinteract.plantform.base.g r9 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r9 == null) goto L39;
        r9.o6(dr(this.v1), false);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void A7() {
        Intrinsics.checkNotNullParameter("leaveRealTimeChorus", "reason");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        MultiLinkGuestManager r1 = r0.W4();
        if (r1 == null) goto L9;
        r1.f("leave_normally", false);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void Ji() {
        RealTimeChorusMainViewWidget r0 = this.Y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.k0.isAnchor() == true) goto L18;
        com.bytedance.android.live.pushstream.d r1 = r0.V.h(false);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r2 = KSongTuningPanelHelperKt.d();
        com.bytedance.android.live.pushstream.d r4 = null;
        if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b) == true) goto L9;
        r2 = null;
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b r3 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.b) r2;
        if (r3 == null) goto L13;
        r4 = r3.s;
    L13:
        if ((!Intrinsics.areEqual(r1, r4)) == false) goto L15;
        r0.Aq();
    L15:
        r0.Pq();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void K() {
        Intrinsics.checkNotNullParameter("JoinChorus", "reason");
        pr(0);
        jg6.a r0 = Eq();
        if (r0 == null) goto L8;
        kg6.e r1 = r0.b();
        if (r1 == null) goto L9;
        r1.f("JoinChorus");
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void Re() {
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L9;
        ((Widget) this).dataCenter.put("cmd_linker_live_core_release", Boolean.TRUE);
        com.bytedance.android.live.pushstream.d r0 = ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
        if (r0 == null) goto L7;
        r0.release();
    L7:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).s = null;
        return;
    }

    public final void Y4() {
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget*/.Y4();
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(3));
        this.V1 = true;
        com.bytedance.android.live.liveinteract.voicechat.util.k r2 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r2 == null) goto L13;
        String r3 = ((MultiLinkVoiceBaseGuestLinkWidget) this).w;
        boolean r4 = Nq();
        String r5 = ((MultiLinkVoiceBaseGuestLinkWidget) this).E;
        int r6 = je0.d.j(Aq());
        List r7 = je0.d.Z();
        String r8 = ((MultiLinkVoiceBaseGuestLinkWidget) this).D;
        boolean r9 = ((MultiLinkVoiceBaseGuestLinkWidget) this).z;
        boolean r10 = ((MultiLinkVoiceBaseGuestLinkWidget) this).A;
        ICircleInfo r11 = getMRoom().getCircleInfo();
        Long r12 = Long.valueOf((this.k1 - ((MultiLinkVoiceBaseGuestLinkWidget) this).y) / ((long) 1000));
        Long r13 = Long.valueOf(br());
        Long r14 = hr();
        LinkApplyType r1 = ((MultiLinkVoiceBaseGuestLinkWidget) this).x;
        IMessageBoardInfo r15 = ((MultiLinkVoiceBaseGuestLinkWidget) this).G;
        yf6.b r18 = Yq();
        if (r18 == null) goto L10;
        vf6.a r0 = r18.a9();
        if (r0 == null) goto L10;
        String r16 = r0.b;
        if (r16 == null) goto L10;
    L11:
        r2.A(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, null, null, r1, r15, r16, fr());
        return;
    L10:
        r16 = "";
        goto L11
    }

    public final long br() {
        if (this.p1 >= 0) goto L6;
        this.p1 = (((MultiLinkVoiceBaseGuestLinkWidget) this).y - this.V0) / ((long) 1000);
    L6:
        return this.p1;
    }

    public final InteractLiveCorePermissionGuarantor cr() {
        if (this.y1 != null) goto L7;
        this.y1 = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.y1;
        if (r0 == null) goto L7;
        r0.j(this.E2);
    L7:
        InteractLiveCorePermissionGuarantor r1 = this.y1;
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
        int r5 = p0.a;
        return p0.a.a(r4);
    L12:
        return null;
    L7:
        r4 = -1;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final List<s0> getHeadPointList() {
        if (this.Y != null) goto L7;
        return null;
    L7:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final Object getRealTimeChorusMicManager() {
        RealTimeChorusMainViewWidget r0 = this.Y;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Q;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final Pair<String, Map<String, Map<String, List<Object>>>> getRoomWrdsListenerData() {
        RealTimeChorusMainViewWidget r0 = this.Y;
        Integer r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r2 = r0.Q;
        if (r2 == null) goto L12;
        HybridCard r3 = r2.a;
        if (r3 == null) goto L10;
        r1 = Integer.valueOf(r3.hashCode());
    L10:
        return new Pair(String.valueOf(r1), r2.e);
    L12:
        return null;
    L11:
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

    public final void mr() {
        String r24 = fr();
        u r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        String r2 = "anchor";
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.j r3 = r1.s();
        if (r3 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L13;
        if (r5.a != 5) goto L13;
    L12:
        String r7 = r2;
    L39:
        com.bytedance.android.live.liveinteract.voicechat.util.k r6 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r6 == null) goto L42;
        long r10 = 1000;
        r6.C(9, ((MultiLinkVoiceBaseGuestLinkWidget) this).w, Mq(), Nq(), ((MultiLinkVoiceBaseGuestLinkWidget) this).E, r7, (System.currentTimeMillis() - Math.max(this.k1, this.h1)) / r10, Long.valueOf((this.k1 - ((MultiLinkVoiceBaseGuestLinkWidget) this).y) / r10), Long.valueOf(br()), je0.d.Z(), false, this.y2.b, getMRoom().getCircleInfo(), hr(), KtvLoggerHelper.D(9, 61), null, ((MultiLinkVoiceBaseGuestLinkWidget) this).x, ((MultiLinkVoiceBaseGuestLinkWidget) this).G, null, null, r24, ((MultiLinkBaseGuestLinkWidget) this).j);
    L42:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).H = null;
        tc0.c.h().F = "";
        return;
    L13:
        cg6.a r8 = Bq();
        if (r8 == null) goto L20;
        MultiLinkGuestManager r9 = r8.W4();
        if (r9 == null) goto L20;
        if (r9.g != true) goto L20;
        String r11 = "anchor";
    L22:
        if (com.bytedance.android.live.liveinteract.api.utils.m.e(this) == null) goto L28;
        u r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        Intrinsics.checkNotNull(r12);
        com.bytedance.live.datacontext.m r13 = r12.y();
        if (r13 == null) goto L28;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L28;
    L29:
        cg6.a r14 = Bq();
        if (r14 == null) goto L36;
        MultiLinkGuestManager r15 = r14.W4();
        if (r15 == null) goto L36;
        if (r15.h != true) goto L36;
        r2 = "game";
    L36:
        ai0.c r16 = jc1.k.n(IInteractService.class).getAdventureService();
        Intrinsics.checkNotNull(r16);
        r16.getClass();
        if (com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f == false) goto L12;
        r7 = "meetgame_call";
    L28:
        r2 = r11;
    L20:
        r11 = "audience";
        goto L22
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
        d0 r9 = r8.getLiveCore();
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
        r2.o6(dr(this.v1), false);
    L28:
        this.k1 = System.currentTimeMillis();
        String r24 = fr();
        ArrayList r11 = new ArrayList();
        if (this.V == false) goto L37;
        this.V = false;
        KtvModeOrderedSongDataContext r10 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r10 == null) goto L39;
        MusicPanel r12 = r10.getKtvPublicFirstOrderedSong();
        if (r12 == null) goto L39;
        KtvMusic r13 = r12.a;
        if (r13 == null) goto L39;
        r11.add(r13);
    L39:
        if (this.V1 == true) goto L52;
        com.bytedance.android.live.liveinteract.voicechat.util.k r14 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r14 == null) goto L52;
        String r15 = ((MultiLinkVoiceBaseGuestLinkWidget) this).w;
        boolean r16 = Nq();
        String r17 = ((MultiLinkVoiceBaseGuestLinkWidget) this).E;
        int r18 = je0.d.j(Aq());
        String r19 = ((MultiLinkVoiceBaseGuestLinkWidget) this).D;
        boolean r110 = ((MultiLinkVoiceBaseGuestLinkWidget) this).z;
        boolean r111 = ((MultiLinkVoiceBaseGuestLinkWidget) this).A;
        ICircleInfo r112 = getMRoom().getCircleInfo();
        Long r20 = Long.valueOf((this.k1 - ((MultiLinkVoiceBaseGuestLinkWidget) this).y) / ((long) 1000));
        Long r113 = Long.valueOf(br());
        Long r114 = hr();
        LinkApplyType r21 = ((MultiLinkVoiceBaseGuestLinkWidget) this).x;
        IMessageBoardInfo r22 = ((MultiLinkVoiceBaseGuestLinkWidget) this).G;
        yf6.b r23 = Yq();
        if (r23 == null) goto L50;
        vf6.a r25 = r23.a9();
        if (r25 == null) goto L50;
        String r26 = r25.b;
        if (r26 == null) goto L50;
        String r27 = r26;
    L51:
        r14.A(r15, r16, r17, r18, r11, r19, r110, r111, r112, r20, r113, r114, null, null, r21, r22, r27, r24);
    L50:
        r27 = "";
    L52:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).A = false;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).C = null;
        yf6.b r28 = Yq();
        if (r28 == null) goto L58;
        vf6.a r29 = r28.a9();
        if (r29 == null) goto L58;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r29.b = "";
    L58:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == true) goto L63;
        int r30 = Lq();
        jy0.b.d("voice_chat", "start link when background, try mute self silenceState=" + r30);
        if (r30 > 0) goto L62;
        pr(3);
        Pq().k("start on background");
        G4(true, "start on background");
    L62:
        Aq().v();
    L63:
        MuteStateChecker r31 = this.G1;
        if (r31 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteStateChecker");
    L66:
        if (r31 == null) goto L68;
        r31.b();
    L68:
        ne0.c r32 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r32 == null) goto L71;
        r32.d0(sh0.f.b, Boolean.FALSE);
    L71:
        String r33 = tc0.c.h().f;
        if (TextUtils.isEmpty(r33) == true) goto L74;
        this.y2.c(r33, true);
    L76:
        if ((!Intrinsics.areEqual(je0.d.g(), je0.d.b0())) == true) goto L78;
    L80:
        String r34 = null;
    L81:
        yf6.b r35 = Yq();
        if (r35 == null) goto L85;
        sf6.d.a.a(r35, new RealTimeChorusGuestWidget$onStartSuccess$2(this));
    L85:
        if (((Boolean) KtvSettingHelper.c1.getValue()).booleanValue() == false) goto L102;
        hg6.g r36 = P2();
        if (r36 == null) goto L93;
        ei6.a r37 = r36.V0();
        if (r37 == null) goto L93;
        si6.b r38 = r37.b();
        if (r38 == null) goto L93;
        String r39 = r38.m();
    L94:
        String r40 = String.valueOf(r39);
        w.a("RealTimeChorusGuestWidget", "onStartSuccess need auto push stream by permit");
        hg6.g r41 = P2();
        if (r41 == null) goto L103;
        ei6.a r42 = r41.V0();
        if (r42 == null) goto L104;
        ri6.b r43 = r42.r();
        if (r43 == null) goto L105;
        r43.s(r40, false);
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L93:
        r39 = r34;
        goto L94
    L102:
        return;
    L78:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L80;
        r34 = null;
        jy0.b.f("ttlive_link", "stopVideoCapture since not singer! false", null, 4);
        x.x(false, je0.d.g());
        goto L81
    L74:
        this.y2.b();
        goto L76
    L37:
        r11.addAll(je0.d.Z());
        goto L39
    L23:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L25;
        Pq().v();
        tc0.c.h().C = false;
        goto L25
    }

    public final void onCreate() {
        super.onCreate();
        if (KtvSettingHelper.w() == false) goto L11;
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L11;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L11;
        Disposable r2 = com.bytedance.android.live.liveinteract.videotalk.ui.b.b(r0, r1);
        if (r2 == null) goto L11;
        RxUtilKt.c(r2, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L11:
        int r3 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r4 = ((Widget) this).dataCenter;
        IRoom r5 = getMRoom();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r9 = null;
        if (r5 == null) goto L14;
        Long r6 = Long.valueOf(r5.getId());
    L15:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r4, Long.valueOf(r6.longValue()));
        if (r7 == null) goto L18;
        r7.startObserveKtvElementLoadEnd("chorus");
    L18:
        ALogger.i("RealTimeChorusGuestWidget", "onCreate");
        u r8 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r8 == null) goto L23;
        com.bytedance.live.datacontext.m r10 = r8.y();
        if (r10 == null) goto L23;
        r10.setValue(Boolean.FALSE);
    L23:
        i0 r11 = j0.a;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).v = j0.c(((Widget) this).dataCenter, this);
        u r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r12 == null) goto L30;
        com.bytedance.live.datacontext.j r13 = r12.s();
        if (r13 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.getValue();
        if (r14 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r15 = r14.t();
    L31:
        if (r15 == null) goto L37;
        hg6.g r16 = P2();
        if (r16 == null) goto L37;
        fg6.b r17 = r16.F();
        if (r17 == null) goto L37;
        r17.b(pg6.a.b(r15));
    L37:
        tc0.c.h().B = 5;
        this.H1 = new InteractAnimationController(((Widget) this).dataCenter);
        InteractAnimationContext r18 = (InteractAnimationContext) com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE).component1();
        r18.getController().d(this.H1);
        com.bytedance.live.datacontext.b.a(r18, InteractAnimationContext.class);
        Pair r19 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        RealTimeChorusGuestDataContext r20 = (RealTimeChorusGuestDataContext) r19.component1();
        Disposable r21 = (Disposable) r19.component2();
        r20.getService().d(this);
        com.bytedance.live.datacontext.b.a(r20, "real_time_chorus_guest_context");
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r21);
        Pair r22 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        RealTimeChorusGlobalDataContext r110 = (RealTimeChorusGlobalDataContext) r22.component1();
        Disposable r23 = (Disposable) r22.component2();
        r110.getRealTimeChorusAdminService().d(this);
        com.bytedance.live.datacontext.b.a(r110, "real_time_chorus_admin_context");
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r23);
        long r24 = System.currentTimeMillis();
        this.V0 = r24;
        this.h1 = r24;
        long r25 = TalkRoomLogUtils.y;
        long r26 = r24 - r25;
        if (r26 >= 0) goto L40;
    L42:
        r25 = r24;
    L43:
        this.b1 = r25;
        TalkRoomLogUtils.y = 0;
        long r27 = TalkRoomLogUtils.A;
        long r28 = r24 - r27;
        if (r28 >= 0) goto L46;
    L48:
        this.g1 = r24;
        TalkRoomLogUtils.A = 0;
        r110.getUserInfoCenter().d(Aq());
        enableSubWidgetManager();
        if (this.p2 != null) goto L52;
        enableSubWidgetManager();
        ThemedCompetitionWidget r29 = new ThemedCompetitionWidget();
        this.p2 = r29;
        ((Widget) this).subWidgetManager.load(r29);
    L52:
        if (this.x2 != null) goto L54;
        enableSubWidgetManager();
        RealTimeChorusBusinessWidget r30 = new RealTimeChorusBusinessWidget();
        this.x2 = r30;
        ((Widget) this).subWidgetManager.load(r30);
    L54:
        Object r31 = ((Widget) this).dataCenter.get("ktv_chorus_scene_widget", null);
        if ((r31 instanceof RealTimeChorusMainViewWidget) == true) goto L57;
        r31 = null;
    L57:
        RealTimeChorusMainViewWidget r32 = (RealTimeChorusMainViewWidget) r31;
        if (r32 != null) goto L60;
        boolean r33 = true;
    L61:
        this.P0 = r33;
        if (r32 == null) goto L64;
        StringBuilder r34 = new StringBuilder("RealTimeChorusGuestWidget, ktvContext:");
        KtvContext.Companion.getClass();
        r34.append(KtvContext.a.g());
        ALogger.i("RealTimeChorusGuestWidget", r34.toString());
        r32.O2 = this.F2;
        Aq();
        r32.N2 = md();
        r32.P2 = this;
    L65:
        this.Y = r32;
        kr();
        InteractAnimationController r35 = this.H1;
        if (r35 == null) goto L68;
        RealTimeChorusMainViewWidget r36 = this.Y;
        Intrinsics.checkNotNull(r36);
        r35.g(r36);
    L68:
        j1 r37 = new j1(md());
        this.X = new com.bytedance.android.live.liveinteract.api.utils.j(r37, r37);
        vh7.c r38 = getMRoom();
        if (r38 == null) goto L71;
        IRoom r39 = (IRoom) jm2.a.e(r38);
    L72:
        this.W = new RealTimeChorusGuestPresenter(r39, ((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.e(this));
        VoiceChatMuteManager r40 = new VoiceChatMuteManager(getMRoom(), false, Aq(), ((Widget) this).dataCenter, this, this, this);
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        ((MultiLinkVoiceBaseGuestLinkWidget) this).O = r40;
        Pq().j();
        Pq().c(this, l.a);
        this.G1 = new MuteStateChecker(((Widget) this).dataCenter, Aq(), Pq());
        this.L0 = new WeakHandler(this);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).I = new com.bytedance.android.live.liveinteract.voicechat.util.k(((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.j(this));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r41 = MultiRevenueDataContext.a.d();
        if (r41 == null) goto L85;
        if (vm2.h.U().a() == true) goto L81;
        if (vm2.h.U().f() == true) goto L81;
        if (hg6.i.c() == false) goto L85;
    L81:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L83;
        r41.o(((Widget) this).dataCenter, this, SceneType.SCENE_KTV, ((Widget) this).containerView);
    L83:
        r41.d(((Widget) this).dataCenter);
    L85:
        if (this.h2 != null) goto L88;
        enableSubWidgetManager();
        QuickInteractWidget r42 = new QuickInteractWidget();
        this.h2 = r42;
        ((Widget) this).subWidgetManager.load(r42);
    L88:
        if (this.v2 != null) goto L98;
        enableSubWidgetManager();
        this.v2 = new LinkmicSubtitleBusinessWidget();
        vb6.g r43 = yq();
        if (r43 == null) goto L96;
        yb6.e r44 = r43.j();
        if (r44 == null) goto L96;
        LinkmicSubtitleBusinessWidget r45 = this.v2;
        if (r45 == null) goto L96;
        Intrinsics.checkNotNullParameter(r44, "mediaManager");
        r45.c = r44;
    L96:
        ((Widget) this).subWidgetManager.load(this.v2);
    L98:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == true) goto L100;
        Aq().i();
    L100:
        r110.getSubWidgetManager().d(((Widget) this).subWidgetManager);
        RealTimeChorusGuestPresenter r46 = this.W;
        if (r46 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L103:
        r46.g0(this);
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_audio_talk_invite", this);
        ((Widget) this).dataCenter.observe("cmd_show_guest_apply_dialog", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        ((Widget) this).dataCenter.put("cmd_interact_real_time_chorus", new jd0.k(true));
        Aq().Q4(this.g2);
        or(jd0.f.class, new m(this));
        or(h1.class, new n(this));
        or(i1.class, new o(this));
        or(u22.b.class, new p(this));
        or(o42.g.class, new q(this));
        IInteractService r47 = jc1.k.f(IInteractService.class);
        if (r47 == null) goto L106;
        x00.a r48 = r47.getThemeManager(false, ((Widget) this).dataCenter);
    L107:
        if (r48 == null) goto L111;
        r48.j(this, new g(this), 100);
        IVoiceLiveTheme r49 = r48.q(100);
        if (r49 == null) goto L111;
        r48.c(r49, r49.getBgType());
    L111:
        hd0.c.f().h.observe(this, new AnonymousClass12());
        this.L1 = new g0(getMRoom(), Aq());
        if (vm2.e.a() == true) goto L114;
    L120:
        if (r12 == null) goto L133;
        Disposable r50 = jc1.k.n(IKtvService.class).observerCurrentIsSinger(null, false, new h(this));
        if (r50 == null) goto L124;
        RxUtilKt.c(r50, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L124:
        com.bytedance.live.datacontext.j r51 = r12.s();
        if (r51 == null) goto L133;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r52 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r51.getValue();
        if (r52 == null) goto L133;
        BehaviorSubject r53 = r52.a();
        if (r53 == null) goto L133;
        Disposable r54 = r53.subscribe(new i(this));
        if (r54 == null) goto L133;
        RxUtilKt.c(r54, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L133:
        EnterRoomInfoResult r55 = (EnterRoomInfoResult) ((Widget) this).dataCenter.get("data_room_enter_info");
        if (getMRoom() == null) goto L147;
        if (r55 == null) goto L147;
        if (r55.getRoomId() != getMRoom().getRoomId()) goto L147;
        u r56 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r56 == null) goto L147;
        com.bytedance.live.datacontext.j r57 = r56.s();
        if (r57 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r58 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r57.getValue();
        if (r58 == null) goto L147;
        r58.d(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r55.getScene(), r55.getUiLayout(), r55.getPlayModes(), false, false, null, 32));
    L147:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L149;
        com.bytedance.android.live.liveinteract.voicechat.util.k.r();
    L149:
        String r59 = LinkmicOnlineFloatWindowManager.Y;
        if (LinkmicOnlineFloatWindowManager.c.a().x == null) goto L212;
        ar(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.k(), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
        Iterator r60 = ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().o).iterator();
    L153:
        if (r60.hasNext() == false) goto L161;
        ILinkPlayerInfoBridge r61 = (ILinkPlayerInfoBridge) r60.next();
        IBaseUser r62 = r61.getUser();
        if (r62 == null) goto L157;
        String r63 = r62.getIdString();
    L159:
        if (Intrinsics.areEqual(r63, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L153;
        ILinkPlayerInfoBridge r64 = com.bytedance.android.live.liveinteract.plantform.model.n.a(r61);
    L162:
        if (r64 == null) goto L212;
        VoiceChatMuteManager r65 = Pq();
        if (r64.getSilenceStatus() == 0) goto L167;
        boolean r66 = true;
    L168:
        r65.t(r66);
        hg6.g r67 = P2();
        if (r67 == null) goto L171;
        r67.p(this);
    L171:
        String r68 = LinkmicOnlineFloatWindowManager.Y;
        tc0.c r69 = LinkmicOnlineFloatWindowManager.c.a().n;
        if (r69 == null) goto L174;
        String r70 = r69.k;
    L175:
        hg6.g r71 = P2();
        if (r71 == null) goto L178;
        r71.c0(r70);
    L178:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).s = LinkmicOnlineFloatWindowManager.c.a().z;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).t = LinkmicOnlineFloatWindowManager.c.a().y;
        hg6.g r72 = LinkmicOnlineFloatWindowManager.c.a().x;
        jg6.a r73 = LinkmicOnlineFloatWindowManager.c.a().w;
        if (yq() == null) goto L202;
        if (r72 == null) goto L202;
        if (r72.V0() == null) goto L202;
        vb6.g r74 = yq();
        if (r74 == null) goto L192;
        yb6.e r75 = r74.j();
        if (r75 == null) goto L192;
        v0 r76 = ((MultiLinkVoiceBaseGuestLinkWidget) this).t;
        if (r76 == null) goto L191;
        r75.s0(gc6.b.c(r76, null), "RealTimeChorusGuestWidget setLiveClient");
        goto L192
    L191:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    L192:
        vb6.g r77 = yq();
        if (r77 == null) goto L197;
        yb6.e r78 = r77.j();
        if (r78 == null) goto L197;
        ei6.a r79 = r72.V0();
        Intrinsics.checkNotNull(r79);
        r78.Q(r79, "RealTimeChorusGuestWidget setRtcClient");
    L197:
        vb6.g r80 = yq();
        if (r80 == null) goto L202;
        yb6.e r81 = r80.j();
        if (r81 == null) goto L202;
        r81.o0(LinkmicOnlineFloatWindowManager.c.a().A);
    L202:
        hd0.c.f().k(2);
        LinkmicOnlineFloatWindowManager.c.a().i();
        u r82 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r82 == null) goto L207;
        com.bytedance.live.datacontext.m r83 = r82.m();
        if (r83 == null) goto L207;
        r83.setValue(Boolean.TRUE);
    L207:
        if (r73 == null) goto L211;
        kg6.e r85 = r73.b();
        if (r85 == null) goto L211;
        ((Widget) this).dataCenter.put("data_self_is_silenced", Boolean.valueOf(r85.q()));
    L211:
        ((Widget) this).dataCenter.put("data_recover_from_online_float_window_start_subtitle", Boolean.TRUE);
        goto L212
    L174:
        r70 = null;
        goto L175
    L167:
        r66 = false;
        goto L168
    L157:
        r63 = null;
        goto L159
    L161:
        r64 = null;
    L212:
        int r86 = xe0.j.a;
        getMRoom();
        if (xe0.j.a() == false) goto L311;
        LinkmicApplyFloatWindowManager.d r87 = LinkmicApplyFloatWindowManager.y;
        we0.b r88 = LinkmicApplyFloatWindowManager.e.a().i(getMRoom().getRoomId());
        if (r88 == null) goto L311;
        ar(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.j(), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
        tc0.c r89 = tc0.c.h();
        Intrinsics.checkNotNullParameter(r88, "params");
        tc0.c r90 = tc0.c.h();
        String r91 = r88.a;
        if (r91 == null) goto L220;
        r90.M = r91;
    L220:
        LinkApplyType r92 = r88.d;
        if (r92 == null) goto L223;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).x = r92;
    L223:
        Integer r93 = r88.e;
        if (r93 == null) goto L226;
        Intrinsics.checkNotNull(r93);
        r90.K = r93.intValue();
    L226:
        String r94 = r88.g;
        if (r94 == null) goto L229;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).w = r94;
    L229:
        Boolean r95 = r88.h;
        if (r95 == null) goto L236;
        Intrinsics.checkNotNull(r95);
        boolean r96 = r95.booleanValue();
        yf6.b r97 = Yq();
        if (r97 == null) goto L236;
        vf6.a r98 = r97.a9();
        if (r98 == null) goto L236;
        r98.a = r96;
    L236:
        Boolean r99 = r88.i;
        if (r99 == null) goto L239;
        Intrinsics.checkNotNull(r99);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).z = r99.booleanValue();
    L239:
        Boolean r100 = r88.j;
        if (r100 == null) goto L242;
        Intrinsics.checkNotNull(r100);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).A = r100.booleanValue();
    L242:
        com.bytedance.android.live.liveinteract.plantform.model.g0 r101 = r88.k;
        if (r101 == null) goto L247;
        DataCenter r102 = ((Widget) this).dataCenter;
        if (r102 == null) goto L247;
        r102.put("data_link_mic_pos_tag_info", r101);
    L247:
        Boolean r103 = r88.l;
        if (r103 == null) goto L252;
        DataCenter r104 = ((Widget) this).dataCenter;
        if (r104 == null) goto L252;
        r104.put("data_link_mic_is_quick_invite", r103);
    L252:
        Long r105 = r88.m;
        if (r105 == null) goto L255;
        Intrinsics.checkNotNull(r105);
        this.V0 = r105.longValue();
    L255:
        Long r106 = r88.n;
        if (r106 == null) goto L258;
        Intrinsics.checkNotNull(r106);
        this.b1 = r106.longValue();
    L258:
        Long r107 = r88.o;
        if (r107 == null) goto L261;
        Intrinsics.checkNotNull(r107);
        this.g1 = r107.longValue();
    L261:
        Long r108 = r88.p;
        if (r108 == null) goto L264;
        Intrinsics.checkNotNull(r108);
        this.h1 = r108.longValue();
    L264:
        Long r109 = r88.q;
        if (r109 == null) goto L267;
        Intrinsics.checkNotNull(r109);
        ((MultiLinkVoiceBaseGuestLinkWidget) this).y = r109.longValue();
    L267:
        Long r111 = r88.r;
        if (r111 == null) goto L270;
        Intrinsics.checkNotNull(r111);
        this.k1 = r111.longValue();
    L270:
        Long r112 = r88.s;
        if (r112 == null) goto L273;
        Intrinsics.checkNotNull(r112);
        this.p1 = r112.longValue();
    L273:
        String r113 = r88.t;
        if (r113 == null) goto L276;
        r90.f = r113;
    L276:
        Integer r114 = r88.u;
        if (r114 == null) goto L280;
        Intrinsics.checkNotNull(r114);
        r90.j = r114.intValue();
    L280:
        if (r88.v == null) goto L282;
        hd0.c r115 = hd0.c.f();
        Integer r116 = r88.v;
        Intrinsics.checkNotNull(r116);
        r115.g = r116.intValue();
    L282:
        Boolean r117 = r88.w;
        if (r117 == null) goto L285;
        Intrinsics.checkNotNull(r117);
        r90.C = r117.booleanValue();
    L285:
        String r118 = r88.z;
        if (r118 == null) goto L288;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).E = r118;
    L288:
        String r119 = r88.A;
        if (r119 == null) goto L291;
        r90.F = r119;
    L291:
        hd0.c.f().k(1);
        z0 r120 = r88.B;
        if (r120 == null) goto L310;
        r89.k = r120.getRtcExtInfo();
        r89.n = r120.getMultiRtcInfo();
        r89.s = r120.getMcuContent();
        if (TextUtils.isEmpty(r120.getAnchorLinkMicIdStr()) == false) goto L296;
        r89.e = r120.getAnchorLinkMicIdStr();
    L297:
        cg6.a r121 = Bq();
        if (r121 == null) goto L302;
        MultiLinkGuestManager r122 = r121.W4();
        if (r122 == null) goto L302;
        r122.g();
    L302:
        Long r123 = r88.C;
        if (r123 == null) goto L305;
        Intrinsics.checkNotNull(r123);
        long r124 = r123.longValue();
    L306:
        TalkRoomBusinessFullLinkMonitor r125 = TalkRoomBusinessFullLinkMonitor.a;
        String r126 = r89.f;
        if (r126 != null) goto L309;
        r126 = "";
    L309:
        r125.getClass();
        TalkRoomBusinessFullLinkMonitor.f(r126, r124);
        goto L310
    L305:
        r124 = 0;
        goto L306
    L296:
        r89.e = r120.getAnchorLinkMicIdStr();
    L310:
        LinkmicApplyFloatWindowManager.e.a().s = null;
    L311:
        com.bytedance.live.datacontext.m r127 = jc1.k.n(IKtvService.class).getHasBgm();
        if (r127 == null) goto L315;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r127.a().subscribe(new j(this)));
    L315:
        if (vm2.d.U0() == false) goto L321;
        u r128 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r128 == null) goto L321;
        com.bytedance.live.datacontext.k r129 = r128.L();
        if (r129 == null) goto L321;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(RxUtilKt.p(r129.onEvent(), "RealTimeChorusGuestWidget", new RealTimeChorusGuestWidget$onCreate$$inlined$let$lambda$1(this)));
    L321:
        SpatialAudioContext r130 = SpatialAudioContext.Companion.getContext();
        if (r130 == null) goto L330;
        com.bytedance.live.datacontext.m r131 = r130.getCurrentStrategyId();
        if (r131 == null) goto L330;
        Observable r132 = r131.a();
        if (r132 == null) goto L330;
        Disposable r133 = r132.subscribe(new k(this));
        if (r133 == null) goto L330;
        RxUtilKt.c(r133, ((MultiLinkVoiceBaseGuestLinkWidget) this).S);
    L330:
        com.bytedance.android.live.liveinteract.linksecurity.c.g.k(((Widget) this).dataCenter);
        TalkRoomLogUtils.x = null;
        com.bytedance.android.live.liveinteract.plantform.core.h r134 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, Aq());
        this.p0 = r134;
        r134.a();
        hg6.g r135 = P2();
        if (r135 == null) goto L333;
        ei6.a r136 = r135.V0();
    L334:
        hg6.g r137 = P2();
        if (r137 == null) goto L341;
        ec6.b r138 = r137.R();
        if (r138 == null) goto L341;
        com.bytedance.android.live.pushstream.d r139 = gc6.b.a(r138);
        if (r139 == null) goto L341;
        d0 r140 = r139.getLiveCore();
    L342:
        if (r136 == null) goto L348;
        if (r140 == null) goto L348;
        com.bytedance.android.live.liveinteract.plantform.core.h r141 = this.p0;
        if (r141 == null) goto L348;
        r141.d(new WeakReference(r136), new WeakReference(r140));
    L348:
        if (vm2.d.y() == true) goto L350;
    L363:
        mz0.f r142 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (r142 != null) goto L366;
        return;
    L366:
        if ((r142 instanceof mz0.f) == true) goto L368;
        return;
    L368:
        if (TextUtils.equals(r142.g(), "1") == false) goto L376;
        f2.c(s1.B(2131917753), 0);
        return;
    L376:
        return;
    L350:
        if (vm2.d.x() == false) goto L363;
        com.bytedance.android.livesdk.chatroom.o r143 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r143 == null) goto L356;
        com.bytedance.live.datacontext.j r144 = r143.getCompactTbLoader();
        if (r144 == null) goto L356;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r145 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r144.getValue();
    L358:
        if ((r145 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L361;
        r9 = r145;
    L361:
        if (r9 == null) goto L363;
        r9.refreshExistComponent(26);
        jy0.b.d("RealTimeChorusGuestWidget", "[LinkmicIconDoubleCheck] voiceChatRoomGuestWidget load refresh icon");
    L356:
        r145 = null;
    L341:
        r140 = null;
        goto L342
    L333:
        r136 = null;
        goto L334
    L114:
        if ((getContext() instanceof FragmentActivity) == false) goto L120;
        InteractLiveCorePermissionGuarantor r146 = cr();
        FragmentActivity r147 = getContext();
        if (r147 == null) goto L119;
        r146.i(r147);
        goto L120
    L119:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L106:
        r48 = null;
        goto L107
    L71:
        r39 = null;
        goto L72
    L64:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r148 = md();
        w0 r149 = this.F2;
        KtvContext.Companion.getClass();
        KtvContext r150 = KtvContext.a.g();
        Aq();
        r32 = new RealTimeChorusMainViewWidget(0, r148, r149, r150, this);
        goto L65
    L60:
        r33 = false;
        goto L61
    L46:
        if (r28 > 15000) goto L48;
        r24 = r27;
        goto L48
    L40:
        if (r26 > 15000) goto L42;
    L30:
        r15 = null;
        goto L31
    L14:
        r6 = null;
        goto L15
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
    L39:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).R = false;
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget*/.onPause();
        return;
    L17:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L39;
        if (vm2.e.a() == false) goto L21;
        cr().f();
    L21:
        boolean r5 = jc1.k.n(IInteractService.class).enableCaptureAudioOnBackground(true);
        w.a("RealTimeChorusGuestWidget", "onPause enableCapture：" + r5);
        if (r5 == true) goto L28;
        G4(true, "onPause");
        int r6 = Lq();
        if (r6 != 0) goto L26;
        pr(3);
        Pq().k("onPause");
    L29:
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 == null) goto L36;
        com.bytedance.android.live.liveinteract.service.g r8 = r7.getInteractFloatWindowService();
        if (r8 == null) goto L36;
        if (r8.b() != true) goto L36;
    L37:
        if (r1 == true) goto L39;
        Aq().v();
    L36:
        r1 = false;
        goto L37
    L26:
        if (r6 != 3) goto L29;
        x.R(r6);
        goto L29
    L28:
        x.J();
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

    public final int Lq() {
        y r0 = Aq();
        Integer r1 = null;
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r0.a5(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
    L6:
        StringBuilder r3 = new StringBuilder("currentSilenceStatus online:");
        if (r2 == null) goto L9;
        r1 = Integer.valueOf(r2.getSilenceStatus());
    L9:
        r3.append(r1);
        r3.append(", mLocalSilence:");
        r3.append(this.b2);
        w.a("RealTimeChorusGuestWidget", r3.toString());
        if (r2 == null) goto L13;
        return r2.getSilenceStatus();
    L13:
        return this.b2;
    L5:
        r2 = null;
        goto L6
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
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    public final yf6.b Yq() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestPresenter.IView
    public final zf6.b aA() {
        rf6.a r0 = xq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final boolean canSilenceSelf() {
        return isEngineOn();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return Aq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return Aq().c;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final int getSelfSilenceType() {
        if (isEngineOn() == true) goto L7;
        return -1;
    L7:
        return Lq();
    }

    public final String getSource() {
        String r0 = super/*com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget*/.getSource();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final long gr() {
        return (System.currentTimeMillis() - Math.max(this.h1, this.V0)) / ((long) 1000);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final boolean isEngineOn() {
        hg6.g r0 = P2();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isEngineOn();
    }

    public final void kr() {
        if (KtvSettingHelper.w() == true) goto L5;
    L7:
        this.Z = true;
        enableSubWidgetManager();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.x r0 = (com.bytedance.android.livesdk.ktvimpl.realtimechorus.x) this.k0.getValue();
        if (r0 == null) goto L12;
        RealTimeChorusMainViewWidget r1 = this.Y;
        if (r1 == null) goto L12;
        r1.jr(r0);
    L12:
        View r2 = null;
        if (vm2.h.E() == false) goto L27;
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L18;
        com.bytedance.android.live.ktv.common.util.k r4 = r3.getStatisticHelper();
    L19:
        if (r4 == null) goto L21;
        r4.a = this;
    L21:
        if (r4 == null) goto L23;
        r4.a();
    L23:
        RealTimeChorusMainViewWidget r5 = this.Y;
        if (r5 == null) goto L27;
        if (r4 == null) goto L27;
        r4.b(r5);
        goto L27
    L18:
        r4 = null;
    L27:
        WidgetManager r6 = ((Widget) this).subWidgetManager;
        if (r6 == null) goto L31;
        r6.load(2131389500, this.Y, false);
    L31:
        if (KtvSettingHelper.w() == false) goto L35;
        RealTimeChorusMainViewWidget r7 = this.Y;
        if (r7 == null) goto L35;
        r7.onBizShow();
    L35:
        RealTimeChorusMainViewWidget r8 = this.Y;
        if (r8 == null) goto L38;
        View r9 = ((Widget) r8).contentView;
    L40:
        if ((r9 instanceof com.bytedance.android.live.ktv.common.util.c) == false) goto L43;
        r2 = r9;
    L43:
        com.bytedance.android.live.ktv.common.util.c r10 = (com.bytedance.android.live.ktv.common.util.c) r2;
        if (r10 == null) goto L51;
        KtvContext.Companion.getClass();
        KtvContext r11 = KtvContext.a.g();
        if (r11 == null) goto L52;
        com.bytedance.android.live.ktv.common.util.k r12 = r11.getStatisticHelper();
        if (r12 == null) goto L53;
        r12.b(r10);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L38:
        r9 = null;
        goto L40
    L5:
        if (this.Z == false) goto L7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final com.bytedance.android.live.liveinteract.voicechat.b muteManager() {
        return Pq();
    }

    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        jy0.b.d("RealTimeChorusGuestWidget", "onDestroy");
        if (((Boolean) KtvSettingHelper.e.getValue()).booleanValue() == false) goto L5;
        int r0 = com.bytedance.android.live.liveinteract.videotalk.ui.b.a;
        com.bytedance.android.live.liveinteract.videotalk.ui.b.a(((Widget) this).dataCenter);
    L5:
        ih0.d r1 = this.S1;
        if (r1 != null) goto L8;
    L12:
        q0 r2 = this.T1;
        if (r2 != null) goto L15;
    L19:
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r3 = this.Q1;
        if (r3 != null) goto L22;
    L42:
        com.bytedance.android.live.liveinteract.plantform.core.h r4 = this.p0;
        if (r4 == null) goto L45;
        r4.b();
    L45:
        yf6.b r5 = Yq();
        if (r5 == null) goto L49;
        r5.f("RealTimeChorusGuestWidget onDestroy");
    L49:
        if (vm2.e.a() == false) goto L51;
        cr().e();
    L51:
        com.bytedance.android.live.liveinteract.linksecurity.c.n(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        InteractAnimationController r6 = this.H1;
        if (r6 == null) goto L55;
        r6.l();
    L55:
        if (isEngineOn() == false) goto L58;
        mr();
        x.j0();
    L58:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L60;
        com.bytedance.android.live.liveinteract.voicechat.util.k.s(gr());
    L60:
        com.bytedance.android.live.liveinteract.voicechat.util.k r7 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r7 == null) goto L63;
        com.bytedance.android.live.liveinteract.voicechat.util.k.w(r7, null, null, null, 15);
    L63:
        HashMap r8 = new HashMap();
        if (vm2.h.R() == false) goto L66;
        r8.put("room_id", String.valueOf(getMRoom().getId()));
        r8.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r9 = getMRoom().getStreamType();
        int r10 = com.bytedance.android.live.core.utils.h1.a;
        r8.put("live_type", com.bytedance.android.live.core.utils.i1.a(r9));
    L66:
        com.bytedance.android.live.liveinteract.voicechat.util.k r11 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r11 == null) goto L69;
        r11.q(r8, gr(), 9, 61, KtvLoggerHelper.D(9, 61), getMRoom().getCircleInfo(), false, null);
    L69:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r12 = TalkRoomLogUtils.a;
        long r13 = 1000;
        TalkRoomLogUtils.p0(r8, Long.valueOf((System.currentTimeMillis() - Math.max(this.h1, this.b1)) / r13));
        TalkRoomLogUtils.q0(r8, Long.valueOf((System.currentTimeMillis() - Math.max(this.h1, this.g1)) / r13));
        DataCenter r14 = ((Widget) this).dataCenter;
        Boolean r15 = Boolean.FALSE;
        r14.put("data_enter_room_is_quick_invite", r15);
        ((Widget) this).dataCenter.put("data_self_is_silenced", r15);
        ((Widget) this).dataCenter.put("cmd_interact_real_time_chorus", new jd0.k(false));
        ((Widget) this).dataCenter.removeObserver(this);
        tc0.c.h().j(r15);
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).O == null) goto L72;
        boolean r16 = true;
    L73:
        if (r16 == false) goto L77;
        VoiceChatMuteManager r17 = Pq();
        if (r17 == null) goto L77;
        r17.n();
    L77:
        cg6.a r18 = Bq();
        if (r18 == null) goto L82;
        hg6.g r19 = r18.getRtcManager();
        if (r19 == null) goto L82;
        r19.Z(this);
    L82:
        RealTimeChorusGuestPresenter r20 = this.W;
        if (r20 == null) goto L85;
        r20.detachView();
    L85:
        this.y2.b();
        g0 r21 = this.L1;
        if (r21 == null) goto L89;
        r21.c(this.v1);
    L89:
        if (((MultiLinkBaseGuestLinkWidget) this).b == null) goto L91;
        boolean r22 = true;
    L92:
        if (r22 == false) goto L97;
        Aq().T4(this.g2);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L96;
        Aq().m();
        goto L97
    L96:
        Aq().l();
    L97:
        ILinkPanelService r23 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r23 == null) goto L100;
        r23.close();
    L100:
        com.bytedance.android.live.liveinteract.widget.widget.q r24 = this.H0;
        if (r24 != null) goto L103;
    L107:
        GuestTalkBeInvitedDialog r25 = ((MultiLinkVoiceBaseGuestLinkWidget) this).L;
        if (r25 == null) goto L120;
        if (r25.isShowing() != true) goto L120;
        GuestTalkBeInvitedDialog r26 = ((MultiLinkVoiceBaseGuestLinkWidget) this).L;
        if (r26 == null) goto L120;
        r26.dismiss();     // Catch: Exception -> L115
    L115:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r27 = DialogFragmentLancet.sLastShowStack;
        if (r27 == null) goto L120;
        com.bytedance.crash.d.d(r27, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L120:
        if (vm2.d.U() == false) goto L122;
    L124:
        u r28 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r28 == null) goto L129;
        com.bytedance.live.datacontext.m r29 = r28.I1();
        if (r29 == null) goto L129;
        r29.setValue(Boolean.FALSE);
    L129:
        com.bytedance.android.live.liveinteract.plantform.base.g r30 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r30 == null) goto L132;
        r30.Sc();
    L132:
        tc0.c.h().F = "";
        if (vm2.d.l0() == false) goto L141;
        Widget.WidgetCallback r31 = ((Widget) this).widgetCallback;
        if (r31 == null) goto L141;
        if (r31.getWidgetManager() == null) goto L141;
        if (((Widget) this).widgetCallback.getWidgetManager().getContext() != null) goto L141;
        ((Widget) this).subWidgetManager = null;
    L141:
        DataCenter r32 = ((Widget) this).dataCenter;
        if (r32 == null) goto L145;
        Integer r33 = (Integer) r32.get("data_link_state", 0);
        if (r33 == null) goto L145;
    L149:
        if (r33 == null) goto L151;
        r33.intValue();
        boolean r34 = !v.a(r33.intValue(), 8);
    L152:
        if (r34 == false) goto L154;
    L164:
        nr(new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, null, false, false, null, 60));
    L166:
        if (vm2.h.E() == true) goto L173;
        KtvContext.Companion.getClass();
        KtvContext r35 = KtvContext.a.g();
        if (r35 == null) goto L173;
        com.bytedance.android.live.ktv.common.util.k r36 = r35.getStatisticHelper();
        if (r36 == null) goto L173;
        r36.b.clear();
        r36.a = null;
    L173:
        super.onDestroy();
        com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        u r37 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r37 == null) goto L180;
        com.bytedance.live.datacontext.j r38 = r37.J();
        if (r38 == null) goto L180;
        LivePlayModeLogContext r39 = (LivePlayModeLogContext) r38.getValue();
        if (r39 == null) goto L180;
        r39.clearPlayModesOnlySupportMultiPeople();
    L180:
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        com.bytedance.android.live.liveinteract.linksecurity.c.g.l();
        if (vm2.d.j0() == false) goto L192;
        WidgetManager r40 = ((Widget) this).subWidgetManager;
        if (r40 == null) goto L192;
        List r41 = r40.widgets;
        if (r41 == null) goto L192;
        if (r41.size() <= 0) goto L192;
        Iterator r42 = ((Widget) this).subWidgetManager.widgets.iterator();
    L190:
        if (r42.hasNext() == false) goto L192;
        ((Widget) this).subWidgetManager.unload((Widget) r42.next());
    L192:
        sh0.d0 r43 = sh0.d0.b;
        ne0.c r44 = ((MultiLinkVoiceBaseGuestLinkWidget) this).v;
        if (r44 == null) goto L195;
        r44.d0(r43, null);
    L195:
        i0 r45 = j0.a;
        j0.b(((Widget) this).dataCenter);
        hg6.g r46 = P2();
        if (r46 == null) goto L198;
        r46.i(false);
    L198:
        this.h2 = null;
        this.p2 = null;
        this.v2 = null;
        this.x2 = null;
        if (vm2.d.U() == false) goto L208;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.clear();
        return;
    L208:
        return;
    L154:
        if (this.P0 == true) goto L164;
        u r47 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r47 == null) goto L161;
        com.bytedance.live.datacontext.n r48 = r47.b();
        if (r48 == null) goto L161;
        r48.setValue(null);
    L161:
        RealTimeChorusMainViewWidget r49 = this.Y;
        if (r49 == null) goto L166;
        r49.onBizLeaveRoom();
        goto L166
    L151:
        r34 = false;
    L145:
        IInteractService r50 = jc1.k.f(IInteractService.class);
        if (r50 == null) goto L148;
        r33 = Integer.valueOf(r50.getLinkMode());
        goto L149
    L148:
        r33 = null;
        goto L149
    L122:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).S.isDisposed() == true) goto L124;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.dispose();
        goto L124
    L103:
        if (r24.isShowing() != true) goto L107;
        com.bytedance.android.live.liveinteract.widget.widget.q r51 = this.H0;
        if (r51 == null) goto L107;
        Zq(r51);
        goto L107
    L91:
        r22 = false;
        goto L92
    L72:
        r16 = false;
        goto L73
    L22:
        if (r3.isShowing() != true) goto L42;
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r52 = this.Q1;
        if (r52 == null) goto L42;
        Handler r53 = DialogLancet.resolveDialogHandler(r52);
        if (r53 != null) goto L28;
    L30:
        DialogLancet.beforeDialogDismiss(r52);
        r52.dismiss();     // Catch: Throwable -> L33 Exception -> L35
    L39:
        DialogLancet.afterDialogDismiss(r52);
        goto L42
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
        Throwable r54 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
        if (r54 == null) goto L39;
        com.bytedance.crash.d.d(r54, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r52);
        throw th;
    L28:
        if (Looper.myLooper() == r53.getLooper()) goto L30;
        r53.post(DialogLancet.createDismissRunnable(r52));
        goto L42
    L15:
        if (r2.p() != true) goto L19;
        q0 r55 = this.T1;
        if (r55 == null) goto L19;
        r55.dismissDialog();
        goto L19
    L8:
        if (r1.p() != true) goto L12;
        ih0.d r56 = this.S1;
        if (r56 == null) goto L12;
        r56.dismissDialog();
        goto L12
    }

    public final void onResume() {
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget*/.onResume();
        WeakHandler r0 = this.L0;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        ((MultiLinkVoiceBaseGuestLinkWidget) this).R = true;
        hg6.g r1 = P2();
        if (r1 == null) goto L9;
        r1.onResume();
    L9:
        if (isEngineOn() == true) goto L11;
    L34:
        hg6.g r2 = P2();
        if (r2 == null) goto L38;
        r2.i(com.bytedance.android.live.liveinteract.spatial.a.e(C0()));
        return;
    L38:
        return;
    L11:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L34;
        if (vm2.e.a() == false) goto L15;
        cr().g();
    L15:
        Aq().r0();
        if (vm2.e.a() == true) goto L18;
    L19:
        w.a("RealTimeChorusGuestWidget", "onResume silenceStatus: " + Lq());
        if (Lq() != 3) goto L23;
        Pq().l("onResume");
    L23:
        if (((Boolean) KtvSettingHelper.c1.getValue()).booleanValue() == false) goto L33;
        hg6.g r3 = P2();
        if (r3 == null) goto L33;
        if (r3.A() != true) goto L33;
        jg6.a r4 = Eq();
        if (r4 == null) goto L33;
        kg6.e r5 = r4.b();
        if (r5 == null) goto L33;
        r5.y(false, "onResume");
    L33:
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(3));
        goto L34
    L18:
        if (cr().p == true) goto L23;
        goto L19
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L6;
        cr().h();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final hg6.g rtcManger() {
        return P2();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void B() {
        super.B();
    }

    public final BizLinkServiceType Kq() {
        return BizLinkServiceType.ChorusGuest;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final tf0.h getInteractAnimationService() {
        return this.H1;
    }

    public final int getScene() {
        return this.v1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final com.bytedance.android.live.pushstream.d guestLiveStream() {
        return ((MultiLinkVoiceBaseGuestLinkWidget) this).s;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final RealTimeChorusMainViewWidget u2() {
        return this.Y;
    }

    public RealTimeChorusGuestWidget(w0 r3) {
        super(tc0.c.h());
        this.F2 = r3;
        this.k0 = LazyKt.lazy(new RealTimeChorusGuestWidget$roomDataEntity$2(this));
        this.P0 = true;
        this.p1 = -1;
        new HashMap(9);
        new HashMap();
        this.b2 = -1;
        this.g2 = new f(this);
        this.y2 = new k0();
        this.E2 = new r(this);
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

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void C3(RealTimeChorusBusinessWidget.h r2) {
        if (r2 == null) goto L7;
        hg6.g r0 = P2();
        if (r0 == null) goto L8;
        r0.Z(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void E0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        vb6.g r1 = r0.O5();
        if (r1 == null) goto L9;
        r1.E0(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void E4(RealTimeChorusBusinessWidget.h r2) {
        if (r2 == null) goto L7;
        hg6.g r0 = P2();
        if (r0 == null) goto L8;
        r0.p(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void H0(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super.H0(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void M0(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        showFollowGuideDialog(false, new com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.j(this, r2));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void O(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        super.O(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void P(com.bytedance.android.livesdk.link.model.bridge.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super.P(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final v0 Q0(String r1) {
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
        int r6 = this.M1 + 1;
        this.M1 = r6;
        Set r8 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r6, null, Boolean.valueOf(r5), r7.getSilenceStatus(), r7.getLinkType());
        if (this.M1 < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r0)) goto L41;
        jg6.a r9 = Eq();
        if (r9 == null) goto L35;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L35;
        r10.t(new kg6.b(false, false, "link security", 8));
    L35:
        this.M1 = 0;
        return;
    L41:
        return;
    L36:
        this.M1 = 0;
        return;
    L37:
        this.M1 = 0;
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

    public final void bd(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        super.bd(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void bm(String r3) {
        Intrinsics.checkNotNullParameter(r3, "streamData");
        w.a("RealTimeChorusGuestWidget", "switchStream ".concat(r3));
        ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
        if (r0 == null) goto L6;
        r0.switchStreamData(r3);
        return;
    }

    public final void handleMsg(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        isViewValid();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void i(IApplyResult r1) {
        super.i(r1);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.a = 61;
        r7.e = Integer.valueOf(AudienceInviteSource.REALTIME_CHORUS.getValue());
        ILinkPlayerInfoBridge r0 = Aq().p(r7.b(), null);
        StringBuilder r1 = new StringBuilder("invite, chorusGuestStatus: ");
        if (r0 == null) goto L5;
        Long r3 = Long.valueOf(r0.getChorusGuestStatus());
    L6:
        r1.append(r3);
        jy0.b.d("RealTimeChorusGuestWidget", r1.toString());
        if (r0 != null) goto L9;
    L13:
        zf6.b r2 = aA();
        if (r2 == null) goto L19;
        r2.a(r7, ((MultiLinkVoiceBaseGuestLinkWidget) this).Q);
        return;
    L19:
        return;
    L9:
        if (r0.getChorusGuestStatus() != ChorusGuestStatus.STATUS_UNKNOWN.getValue()) goto L13;
        s r4 = RealTimeChorusBusinessContext.Companion.c();
        if (r4 == null) goto L17;
        r4.Ch(r7.b(), ChorusGuestStatus.STATUS_NORMAL.getValue(), null);
        return;
    L17:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean jr(ILinkPlayerInfoBridge r2) {
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L5;
        String r4 = r3.getIdString();
    L7:
        return Intrinsics.areEqual(r4, com.bytedance.android.live.liveinteract.linkpanel.util.o.J());
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
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

    public final void lr(ILinkPlayerInfoBridge r5) {
        if (r5.getUser() == null) goto L24;
        IBaseUser r0 = r5.getUser();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getIdString();
    L8:
        IRoom r3 = getMRoom();
        if (r3 == null) goto L11;
        r1 = r3.getOwnerUserIdString();
    L11:
        boolean r4 = Intrinsics.areEqual(r2, r1);
        if (jr(r5) == false) goto L14;
        String r6 = "oneself";
    L17:
        IBaseUser r7 = r5.getUser();
        if (r7 == null) goto L21;
        String r8 = r7.getIdString();
        if (r8 == null) goto L21;
    L22:
        TalkRoomLogUtils.d(r8, r6, com.bytedance.android.live.liveinteract.plantform.model.n.b(r5));
        return;
    L21:
        r8 = "";
        goto L22
    L14:
        if (r4 == false) goto L16;
        r6 = "anchor";
        goto L17
    L16:
        r6 = "audience";
        goto L17
    L7:
        r2 = null;
        goto L8
    }

    public final void nr(com.bytedance.android.livesdk.chatroom.viewmodel.i r33) {
        int r2 = this.v1;
        int r3 = this.x1;
        int r4 = r33.a;
        this.v1 = r4;
        int r5 = r33.b;
        this.x1 = r5;
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
        boolean r6 = jc0.a.b(r4, r5);
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r7 = null;
        if (r6 == true) goto L15;
        Integer r10 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r10 != null) goto L21;
    L25:
        int r11 = this.v1;
        if (r11 != 5) goto L31;
        if (r2 != 9) goto L39;
        ChatMatchWidget r12 = ((MultiLinkVoiceBaseGuestLinkWidget) this).N;
        if (r12 == null) goto L39;
        r12.yq();
    L39:
        if (this.v1 == 9) goto L41;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).D = null;
        ((MultiLinkVoiceBaseGuestLinkWidget) this).C = null;
        com.bytedance.android.live.liveinteract.widget.widget.q r13 = this.H0;
        if (r13 != null) goto L46;
    L50:
        if (r2 == 9) goto L52;
    L54:
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("reason", "switch_scene_event");
        com.bytedance.android.live.liveinteract.plantform.utils.i.c(r33.a, r33.b, r14);
    L55:
        RealTimeChorusMainViewWidget r15 = this.Y;
        if (r15 == null) goto L59;
        r15.Wq(r33, false);
    L59:
        if (jc0.a.b(r33.a, r33.b) == false) goto L61;
        RealTimeChorusMainViewWidget r16 = this.Y;
        if (r16 == null) goto L68;
        r16.onBizEnterRoom();
    L68:
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", new nh0.f("linkmic", new nh0.e(9, 61, u0.d(), 0, 0, null, null, null, 248), null, null, null, null, false, 224));
    L70:
        if (this.v1 == 0) goto L72;
    L73:
        this.h1 = System.currentTimeMillis();
    L75:
        if (jc0.a.b(r33.a, r33.b) == false) goto L137;
        int r17 = this.v1;
        int r18 = this.x1;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r19 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r17), Integer.valueOf(r18), null, null) == true) goto L104;
        String r110 = TalkRoomLogUtils.p(Integer.valueOf(r2), Integer.valueOf(r3), null);
        String r111 = TalkRoomLogUtils.p(Integer.valueOf(r17), Integer.valueOf(r18), null);
        String r112 = u0.j(Integer.valueOf(r3));
        String r113 = u0.j(Integer.valueOf(r18));
        ((MultiLinkVoiceBaseGuestLinkWidget) this).H = null;
        if (r17 == 0) goto L99;
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r110, r111) == false) goto L85;
        if (r2 != 0) goto L99;
    L85:
        if (hd0.c.f().h() == false) goto L95;
        com.bytedance.android.live.liveinteract.voicechat.util.k r114 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r114 == null) goto L89;
        int r20 = 12;
        String r115 = r113;
        r114.A(((MultiLinkVoiceBaseGuestLinkWidget) this).w, Nq(), ((MultiLinkVoiceBaseGuestLinkWidget) this).E, je0.d.j(Aq()), je0.d.Z(), ((MultiLinkVoiceBaseGuestLinkWidget) this).D, ((MultiLinkVoiceBaseGuestLinkWidget) this).z, ((MultiLinkVoiceBaseGuestLinkWidget) this).A, getMRoom().getCircleInfo(), null, Long.valueOf(br()), hr(), r111, r115, null, null, null, null);
    L90:
        yf6.b r116 = Yq();
        if (r116 == null) goto L96;
        vf6.a r117 = r116.a9();
        if (r117 == null) goto L96;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r117.b = "";
    L96:
        com.bytedance.android.live.liveinteract.voicechat.util.k r118 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r118 == null) goto L104;
        com.bytedance.android.live.liveinteract.voicechat.util.k.y(r118, r111, r115, null, r20);
        goto L104
    L89:
        r115 = r113;
        r20 = 12;
        goto L90
    L95:
        r115 = r113;
        r20 = 12;
    L99:
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r112, r113) == true) goto L104;
        com.bytedance.android.live.liveinteract.voicechat.util.k r119 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r119 == null) goto L104;
        com.bytedance.android.live.liveinteract.voicechat.util.k.y(r119, null, r113, null, 12);
    L104:
        if (r17 == 0) goto L136;
        int r21 = this.v1;
        if (r2 != 0) goto L109;
    L107:
        boolean r22 = true;
    L112:
        if (r22 == false) goto L136;
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L136;
        HashMap r23 = new HashMap();
        if (vm2.h.R() == false) goto L118;
        r23.put("room_id", String.valueOf(getMRoom().getId()));
        r23.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r120 = getMRoom().getStreamType();
        int r121 = com.bytedance.android.live.core.utils.h1.a;
        r23.put("live_type", com.bytedance.android.live.core.utils.i1.a(r120));
    L118:
        com.bytedance.android.live.liveinteract.voicechat.util.k r122 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r122 == null) goto L121;
        r122.o(r23, r17, r18, getMRoom().getCircleInfo());
    L121:
        com.bytedance.android.live.liveinteract.voicechat.util.k r123 = ((MultiLinkVoiceBaseGuestLinkWidget) this).I;
        if (r123 == null) goto L125;
        r123.p(r23, r17, r18, getMRoom().getCircleInfo());
    L125:
        if (Intrinsics.areEqual("syncRoom", getSource()) == false) goto L131;
        if (r2 != 0) goto L131;
        long r124 = this.b1;
        long r125 = this.V0;
        if (r124 >= r125) goto L130;
        TalkRoomLogUtils.U(Long.valueOf(r125 - r124));
    L133:
        if (Intrinsics.areEqual("syncRoom", getSource()) == false) goto L135;
        if (r2 == 0) goto L136;
    L135:
        TalkRoomLogUtils.o0(r23);
        goto L136
    L130:
        TalkRoomLogUtils.m0(getMRoom(), System.currentTimeMillis(), TalkRoomLogUtils.z);
    L131:
        TalkRoomLogUtils.n0(r23);
        goto L133
    L109:
        if (r2 == 16) goto L111;
        if (r21 != 16) goto L107;
    L111:
        r22 = false;
    L136:
        jy0.b.a("InteractAnimationController", "afterSceneChange fromScene:" + r2 + ",fromUiLayout:" + r3 + ",toScene:" + r17 + ",toUiLayout:" + r18);
    L137:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r24 = mz0.d.b(LogCommon.LINKMIC_SCENE_DATA);
        if ((r24 instanceof mz0.e) == false) goto L141;
        r7 = r24;
    L141:
        if (r7 == null) goto L143;
        r7.c(new com.bytedance.android.livesdk.log.filter.y(this.v1));
    L143:
        int r25 = this.v1;
        if (r2 == r25) goto L150;
        g0 r26 = this.L1;
        if (r26 == null) goto L150;
        if (r25 == 0) goto L149;
        r26.a(r2, Integer.valueOf(r3), this.v1, Integer.valueOf(this.x1));
        goto L150
    L149:
        r26.c(r2);
    L150:
        int r27 = this.v1;
        if (r27 != 5) goto L157;
        int r28 = this.x1;
        if (r28 == r3) goto L157;
        g0 r29 = this.L1;
        if (r29 == null) goto L157;
        r29.b(r27, r3, r28);
    L157:
        hg6.g r30 = P2();
        if (r30 == null) goto L160;
        r30.D(r33.a, "RealTimeChorusGuestWidget afterSwitchScene");
    L160:
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L163;
        r1.o6(dr(this.v1), false);
    L163:
        SpatialAudioContext.a r31 = SpatialAudioContext.Companion;
        if (r31.getContext() != null) goto L166;
        SpatialAudioStrategyManager.c.a();
    L166:
        SpatialAudioContext r32 = r31.getContext();
        if (r32 == null) goto L172;
        com.bytedance.live.datacontext.m r34 = r32.getCurrentStrategyId();
        if (r34 == null) goto L173;
        r34.setValue(Integer.valueOf(C0()));
        return;
    L173:
        return;
    L172:
        return;
    L72:
        if (this.x1 == 0) goto L75;
    L61:
        if (jc0.a.b(r2, r3) == false) goto L70;
        RealTimeChorusMainViewWidget r35 = this.Y;
        if (r35 == null) goto L70;
        r35.onBizDestory();
        goto L70
    L52:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L54;
        com.bytedance.android.live.liveinteract.voicechat.util.k.s(gr());
        goto L54
    L46:
        if (r13.isShowing() != true) goto L50;
        com.bytedance.android.live.liveinteract.widget.widget.q r36 = this.H0;
        if (r36 == null) goto L50;
        Zq(r36);
        goto L50
    L41:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).I == null) goto L50;
        com.bytedance.android.live.liveinteract.voicechat.util.k.r();
        goto L50
    L31:
        if (r11 != 9) goto L39;
        if (vm2.d.e().a() == false) goto L39;
        if (r2 != 5) goto L39;
        ChatMatchWidget r37 = ((MultiLinkVoiceBaseGuestLinkWidget) this).N;
        if (r37 == null) goto L39;
        r37.yq();
        goto L39
    L21:
        if (r10.intValue() != 1) goto L25;
        if (tc0.c.h().K != LinkApplyType.PREPARE_APPLY.getValue()) goto L25;
        int r38 = this.v1;
        goto L25
    L15:
        if (jc0.a.b(r33.a, r33.b) == false) goto L55;
        kr();
        goto L55
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
        if (this.P1 == null) goto L37;
        r4.e = 3;
    L37:
        this.P1 = null;
        invite(r4);
        Intrinsics.checkNotNull(r12);
        TalkRoomLogUtils.C("administrator", r12.getIdString(), "card", -1);
        return;
    L39:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L41;
        f2.b(2131914522, 0);
    L42:
        x.C0(TalkRoomOperate.INVITE);
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
        int r15 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.g.a;
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

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void onSwitchSceneMessage(z0 r12) {
        if (r12 == null) goto L38;
        tc0.c r0 = tc0.c.h();
        if (vm2.d.v0() == false) goto L6;
        String r1 = TalkRoomLogUtils.g();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        TalkRoomLogUtils.j = r1;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r12);
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
        u r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
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
        if (jc0.a.b(r12.getValidScene(), r12.getUiLayout()) == true) goto L39;
        RealTimeChorusMainViewWidget r13 = this.Y;
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
        if ((r8 instanceof y) == true) goto L16;
        r8 = null;
    L16:
        y r9 = (y) r8;
        if (r9 == null) goto L19;
        r9.Y4(r12.getLinkedListUsers(), r12.getClientUIInfo(), r12.getVersion(), "switchSceneMsg", r12.getLinkerContentMap());
        goto L19
    L41:
        return;
    }

    public final void pr(int r4) {
        w.a("RealTimeChorusGuestWidget", "mLocalSilenceStatus Change " + this.b2 + " -> " + r4);
        this.b2 = r4;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestPresenter.IView
    public final void q(int r4) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (isEngineOn() == true) goto L8;
        return;
    L8:
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).s == null) goto L30;
        pr(r4);
        boolean r0 = false;
        if (r4 == 0) goto L23;
        if (r4 != 1) goto L14;
    L20:
        f2.b(2131919412, 0);
        com.bytedance.android.live.liveinteract.linksecurity.c.m(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        if (((MultiLinkVoiceBaseGuestLinkWidget) this).R == true) goto L24;
        x.M();
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    L24:
        boolean r5 = !r0;
        Pq().t(r5);
        G4(r5, "silence message");
        com.bytedance.android.live.liveinteract.plantform.base.g r6 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r6 == null) goto L29;
        r6.Lp(r0);
        return;
    L29:
        return;
    L14:
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L24;
        if (r4 == 4) goto L20;
    L23:
        f2.b(2131919449, 0);
        r0 = true;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void setInviteCallback(uf0.c r1) {
        ((MultiLinkVoiceBaseGuestLinkWidget) this).Q = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void setPermitCallback(uf0.d r1) {
        ((MultiLinkVoiceBaseGuestLinkWidget) this).P = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void u(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Sq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void w(g1 r1) {
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

    public final void R(long r1, Exception r3) {
        ((MultiLinkVoiceBaseGuestLinkWidget) this).C = null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void W0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "source");
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        vb6.g r1 = r0.O5();
        if (r1 == null) goto L9;
        r1.W0(r2, r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void accept(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "idString");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        zf6.b r4 = aA();
        if (r4 == null) goto L6;
        r4.b(r0, ((MultiLinkVoiceBaseGuestLinkWidget) this).P);
        return;
    }

    public final void ar(ye0.a r7, int r8) {
        long r0 = System.currentTimeMillis();
        Disposable r9 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).applyStash(getMRoom().getRoomId(), 1, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.h(r7, r0), new com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.i(r7, r0));
        ((MultiLinkVoiceBaseGuestLinkWidget) this).S.add(r9);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.RealTimeChorusGuestPresenter.IView
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

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
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

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void openEmojiDialog(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "toUserId");
        Intrinsics.checkNotNullParameter("dynamic", "requestPage");
        String r1 = null;
        if (isEngineOn() == true) goto L14;
        com.bytedance.android.livesdk.chatroom.o r13 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r13 == null) goto L14;
        com.bytedance.live.datacontext.m r14 = r13.getCleanMode();
        if (r14 == null) goto L14;
        if (((Number) r14.getValue()).intValue() != 2) goto L14;
        if (vm2.e.h() == false) goto L14;
        jy0.b.f("RealTimeChorusGuestWidget", "rejected guest stub click for pure clean mode", null, 4);
        return;
    L14:
        BehaviorSubject r15 = md().f();
        if (r15 == null) goto L107;
        List r16 = (List) r15.getValue();
        if (r16 == null) goto L108;
        Iterator r17 = r16.iterator();
    L20:
        if (r17.hasNext() == false) goto L29;
        Object r2 = r17.next();
        IBaseUser r3 = ((ch0.e) r2).a.getUser();
        if (r3 == null) goto L25;
        String r4 = r3.getIdString();
        if (r4 == null) goto L25;
    L27:
        if (Intrinsics.areEqual(r4, r11) == false) goto L20;
    L30:
        ch0.e r5 = (ch0.e) r2;
        if (r5 == null) goto L109;
        LinkPlayerInfo r18 = r5.a;
        if (r18 != null) goto L36;
        return;
    L36:
        if (Intrinsics.areEqual(r11, getMRoom().getOwnerUserIdString()) == false) goto L42;
        DataCenter r19 = ((Widget) this).dataCenter;
        if (r19 == null) goto L40;
        r19.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
    L40:
        lr(r18);
        return;
    L42:
        lr(r18);
        if (jr(r18) == false) goto L62;
        IInteractService r110 = jc1.k.f(IInteractService.class);
        Intrinsics.checkNotNull(r110);
        if (r110.isEnableTalkRoomEmoji() == false) goto L62;
        DataCenter r111 = ((Widget) this).dataCenter;
        if (r111 == null) goto L54;
        if (r18.getSilenceStatus() == 0) goto L51;
        boolean r8 = true;
    L52:
        r111.put("data_self_is_silenced", Boolean.valueOf(r8));
        goto L54
    L51:
        r8 = false;
    L54:
        if (hd0.c.f().h() == false) goto L58;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r112 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r112.b(((Widget) this).context);
        r112.c(((Widget) this).dataCenter);
        r112.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r112.d = "seat";
        q0 r113 = r112.a();
        this.T1 = r113;
        r113.a();
        return;
    L58:
        if (hd0.c.f().g() == false) goto L62;
        xs2.b.a().post(new UserProfileEvent(r18.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L62:
        if (je0.d.c0() == true) goto L64;
    L82:
        boolean r114 = hd0.c.f().h();
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L88;
        if (r114 == false) goto L86;
    L89:
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r115 = new com.bytedance.android.live.liveinteract.voicechat.dialog.p(((Widget) this).context, ((Widget) this).dataCenter, r18, false);
        r115.G = "seat";
        this.Q1 = r115;
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L102;
        DialogLancet.handleBlockedDialogShow(r115);
        return;
    L102:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L101
    L93:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
        return;
    L86:
        if (r18.isLinkRoomUser() == false) goto L89;
    L88:
        if (jr(r18) == true) goto L89;
        IBaseUser r116 = r18.getUser();
        if (r116 == null) goto L98;
        r1 = r116.getIdString();
    L98:
        if ((!Intrinsics.areEqual(r1, com.bytedance.android.live.liveinteract.linkpanel.util.o.J())) == false) goto L112;
        xs2.b.a().post(new UserProfileEvent(r18.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L112:
        return;
    L64:
        if (jr(r18) == true) goto L82;
        if (hd0.c.f().h() == false) goto L82;
        ih0.d r117 = this.S1;
        if ((r117 instanceof KtvRoomInteractEmojiPanel) == false) goto L73;
        if (r117 == null) goto L73;
        if (r117.p() != true) goto L73;
        return;
    L73:
        Context r118 = ((Widget) this).context;
        DataCenter r6 = ((Widget) this).dataCenter;
        LinkPlayerInfo r119 = r18;
        Intrinsics.checkNotNullParameter(r118, "context");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r119, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L76;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r120 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r119, "seat", false);
    L80:
        this.S1 = r120;
        r120.a();
        return;
    L76:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r7 = new KtvRoomInteractEmojiPanel(r118, r6, r119);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        ((InteractEmojiPanel) r7).k = "seat";
        ((InteractEmojiPanel) r7).r = false;
        tb6.c r121 = ((InteractEmojiPanel) r7).x;
        if (r121 == null) goto L79;
        r121.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r121.d = "seat";
    L79:
        r120 = r7;
        goto L80
    L109:
        return;
    L25:
        r4 = "";
        goto L27
    L29:
        r2 = null;
        goto L30
    L108:
        return;
    }

    public final <T> void or(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void t(sf0.a r2, IApplyResult r3) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r3, "applyResult");
        super.t(r2, r3);
    }

    public final void u4(long r2, ec6.a r4) {
        Intrinsics.checkNotNullParameter(r4, "client");
        super.u4(r2, r4);
        if (((Boolean) KtvSettingHelper.w1.getValue()).booleanValue() == false) goto L14;
        RealTimeChorusMainViewWidget r3 = this.Y;
        if (r3 == null) goto L15;
        KtvContext r5 = r3.X;
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r6 = r5.getKtvSingerViewModel();
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r7 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r6.getValue();
        if (r7 == null) goto L18;
        r7.initLiveStreamWrapper("RealTimeGuestWidget onLiveClientInitSuccess");
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void K2(boolean r10, boolean r11, tf0.q r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
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
        com.bytedance.android.live.liveinteract.widget.widget.q r3 = new com.bytedance.android.live.liveinteract.widget.widget.q(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.j(this), this, r11, r10, r12);
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

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void M(boolean r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
    }

    public final void Ng(sf0.a r2, long r3, ExtraResponse<? extends IApplyResult, Extra> r5) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Intrinsics.checkNotNullParameter(r5, "response");
        super.Ng(r2, r3, r5);
        IApplyResult r4 = (IApplyResult) r5.data;
        if (r4 == null) goto L5;
        String r6 = r4.getSubRtcToken();
    L6:
        if (r6 == null) goto L11;
        RealTimeChorusBusinessContext.a r7 = RealTimeChorusBusinessContext.Companion;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "token");
        s r8 = r7.c();
        if (r8 == null) goto L12;
        r8.W8(r6);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void O0(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        this.V = true;
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        vb6.g r1 = r0.O5();
        if (r1 == null) goto L9;
        r1.O0(r2, r3, r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void cancelApply(h80.a<Boolean> r2, boolean r3, String r4) {
        zf6.b r5 = aA();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r5.e(new wf6.a(r4, 1));
    }

    public final void ue(String r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        int r0 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r1 = ((Widget) this).dataCenter;
        IRoom r2 = getMRoom();
        if (r2 == null) goto L5;
        Long r3 = Long.valueOf(r2.getId());
    L6:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r1, Long.valueOf(r3.longValue()));
        if (r7 != null) goto L9;
        return;
    L9:
        switch(r4.hashCode()) {
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
        if (r4.equals("lyric") == false) goto L37;
        r7.recordSubElementShow("lyric_load", er(r5, r6));
        return;
    L37:
        return;
    L15:
        if (r4.equals("midi") == false) goto L39;
        r7.recordSubElementShow("midi_load", er(r5, r6));
        return;
    L39:
        return;
    L18:
        if (r4.equals("mv") == false) goto L41;
        r7.recordSubElementShow("mv_load", er(r5, r6));
        return;
    L41:
        return;
    L21:
        if (r4.equals("container") == false) goto L43;
    L25:
        r7.recordSubElementShow("widget_load", er(r5, r6));
        r7.recordSubElementShow("container_load", er(r5, r6));
        return;
    L43:
        return;
    L24:
        if (r4.equals("main_widget") == true) goto L25;
        return;
    L27:
        if (r4.equals("empty_seat") == false) goto L46;
        r7.recordSubElementShow("empty_seat_load", er(r5, r6));
        return;
    L46:
        return;
    L30:
        if (r4.equals(TraceCons.METRIC_BACKGROUND) == false) goto L48;
        r7.recordSubElementShow("background_Load", er(r5, r6));
        return;
    L48:
        return;
    L33:
        if (r4.equals("guest_seat") == false) goto L50;
        r7.recordSubElementShow("guest_seat_load", er(r5, r6));
        return;
    L50:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.a
    public final void v(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "from");
        super.v(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void checkAndApply(int r20, String r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "applySource");
        Intrinsics.checkNotNullParameter(r23, "fromSource");
        sf0.a r14 = new sf0.a(-1, d5.b(r21), r22, 0, null, null, r23, 0, 0, 0, false, false, 0, null, null, 0, 524152);
        Intrinsics.checkNotNullParameter(r14, "applyParams");
        Wq(r14);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
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

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void disconnect(int r8, boolean r9, boolean r10, boolean r11, rj0.c r12) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        jy0.b.d("RealTimeChorusGuestWidget", String.format("disconnect, disconnectSource: %s, needSureAgain: %s, needToastWhenSuccess: %s, needShowLinkResult: %s", Arrays.copyOf(new Object[]{Integer.valueOf(r8), Boolean.valueOf(r9), Boolean.valueOf(r10), Boolean.valueOf(r11)}, 4)));
        ((MultiLinkVoiceBaseGuestLinkWidget) this).J = r11;
        if (r11 == false) goto L9;
        if (((Widget) this).dataCenter == null) goto L25;
        a1 r13 = new a1(5);
        r13.b = Integer.valueOf(r8);
        ((Widget) this).dataCenter.put("cmd_interact_state_change", r13);
        return;
    L25:
        return;
    L9:
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.c(false) == true) goto L18;
        Context r14 = getContext();
        x0.d r15 = new x0.d();
        r15.b = r14;
        r15.a = 0;
        r15.a = 5;
        r15.k = false;
        r15.c = s1.B(2131919817);
        r15.d = s1.B(2131919492);
        String r16 = s1.B(2131919267);
        b r17 = new b(this, r8);
        x0.c[] r18 = r15.g;
        x0.c r19 = r18[0];
        if (r19 != null) goto L13;
        r19 = new x0.c();
        r18[0] = r19;
    L13:
        r19.a = r16;
        r19.b = r17;
        String r20 = s1.B(2131915442);
        c r21 = c.a;
        x0.c[] r110 = r15.g;
        x0.c r111 = r110[1];
        if (r111 != null) goto L16;
        r111 = new x0.c();
        r110[1] = r111;
    L16:
        r111.a = r20;
        r111.b = r21;
        x0.b.g(new x0(r15.b, r15));
        return;
    L18:
        if (r9 == false) goto L20;
        com.bytedance.android.livesdk.widget.j0.a r22 = new com.bytedance.android.livesdk.widget.j0.a(getContext());
        r22.a = s1.B(2131919817);
        r22.a(s1.B(2131919267), new d(this, r11, r8, (KtvService.b) r12));
        r22.b(s1.B(2131915442), e.a);
        r22.c();
        return;
    L20:
        if (((Widget) this).dataCenter == null) goto L26;
        a1 r23 = new a1(5);
        r23.b = Integer.valueOf(r8);
        ((Widget) this).dataCenter.put("cmd_interact_state_change", r23);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c
    public final void ktvApply(KtvMusic r7, String r8, LinkApplyType r9, int r10, tf0.b r11) {
        Intrinsics.checkNotNullParameter(r9, "applyType");
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        Rq(r7, r8, r9, 102, r11);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void switchAudioByClient(boolean r8, List<com.bytedance.android.livesdk.link.model.bridge.k> r9, ClientUIInfo r10, long r11, Map<Long, ? extends RoomLinkerContent> r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r14, "reason");
        G4(r8, r14);
        Pq().t(r8);
        y r0 = Aq();
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
