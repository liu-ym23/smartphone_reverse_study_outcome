package com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.setting.b6;
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
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkpanel.model.AudienceInviteSource;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.s;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionWidget;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.interact.SwitchSceneResponse;
import com.bytedance.android.livesdk.chatroom.model.w;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.rb1;
import com.bytedance.android.livesdk.config.sb0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.model.ChorusGuestStatus;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.ToolbarInteractKtvRoomBehavior;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.KtvRoomInteractEmojiPanel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusGlobalDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.linker.AnchorLinkmicInfo;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.TaskMixerConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.z;
import gd0.v;
import hh1.u0;
import hh1.v0;
import hh1.w0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import sh0.i0;
import sh0.j0;
import uf2.d0;
import zg1.h1;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/anchor/RealTimeChorusAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseAnchorLinkWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/anchor/RealTimeChorusAnchorPresenter$IView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/anchor/c;", "Lcom/bytedance/android/live/liveinteract/voicechat/a;", "Lkk0/f;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/anchor/b;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusAnchorWidget extends MultiLinkVoiceBaseAnchorLinkWidget implements RealTimeChorusAnchorPresenter.IView, WeakHandler.IHandler, Observer<KVData>, com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c, com.bytedance.android.live.liveinteract.voicechat.a, kk0.f, com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.b {
    public static final /* synthetic */ int v1 = 0;
    public String A;
    public long B;
    public i0 C;
    public RealTimeChorusAnchorPresenter D;
    public VoiceChatMuteManager E;
    public hg6.g F;
    public RealTimeChorusMainViewWidget G;
    public final Lazy H;
    public com.bytedance.android.live.liveinteract.voicechat.dialog.p H0;
    public WeakHandler I;
    public final w0 J;
    public long K;
    public int L;
    public ih0.d L0;
    public int M;
    public boolean N;
    public InteractAnimationController O;
    public final ToolbarInteractKtvRoomBehavior P;
    public q0 P0;
    public com.bytedance.android.live.liveinteract.voicechat.util.k Q;
    public int R;
    public Disposable S;
    public InteractLiveCorePermissionGuarantor T;
    public ChatMatchWidget U;
    public ThemedCompetitionWidget V;
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.a V0;
    public QuickInteractWidget W;
    public LinkmicSubtitleBusinessWidget X;
    public final boolean Y;
    public final s Z;
    public final b b1;
    public final r g1;
    public String h1;
    public final ArrayList<ILinkPlayerInfoBridge> k0;
    public final com.bytedance.android.live.pushstream.d k1;
    public RealTimeChorusBusinessWidget p0;
    public final boolean p1;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public b(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            this.a.k0.clear();
            List<? extends ILinkPlayerInfoBridge> r1 = r4;
            this.a.k0.addAll(r1);
            if (((Boolean) KtvSettingHelper.p.getValue()).booleanValue() == false) goto L11;
            ArrayList r0 = new ArrayList(r1);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            bn0.b r2 = this.a.getMultiLinkRoomScope();
            if (r2 == null) goto L11;
            jn0.b r3 = jn0.c.a(r2);
            if (r3 == null) goto L11;
            BehaviorSubject r5 = r3.Xh();
            if (r5 == null) goto L11;
            r5.onNext(r0);
        L11:
            g0.e(r4.size());
            if (r4.size() <= tc0.c.h().d) goto L15;
            tc0.c r6 = tc0.c.h();
            r6.d = r4.size();
            return;
        }

        public final void n(List<ILinkPlayerInfoBridge> r2, long r3, n0 r5) {
            String r4 = "";
            if (Lists.isEmpty(r2) == false) goto L5;
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", "");
            return;
        L5:
            RealTimeChorusAnchorWidget r6 = this.a;
            int r7 = RealTimeChorusAnchorWidget.v1;
            int r8 = ((ArrayList) r6.yq().V4()).size();
            if (r8 > 99) goto L8;
            r8 = r8 + fj0.e.a();
        L8:
            String r0 = String.valueOf(r8);
            if (r8 <= 99) goto L11;
            r0 = "99+";
        L11:
            if (r8 <= 0) goto L14;
            r4 = r0;
        L14:
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", r4);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public c(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            RealTimeChorusAnchorWidget r4 = this.a;
            if (((Widget) r4).isViewValid == false) goto L10;
            Disposable r5 = r4.S;
            Intrinsics.checkNotNull(r5);
            if (r5.isDisposed() == true) goto L11;
            RealTimeChorusAnchorWidget r6 = this.a;
            if (r6.Q == null) goto L12;
            com.bytedance.android.live.liveinteract.voicechat.util.k.z(r6.yq().b());
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public d(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            IVoiceLiveTheme r3 = (IVoiceLiveTheme) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (this.a.G == null) goto L9;
            Intrinsics.checkNotNullParameter(r3, "theme");
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public e(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            RealTimeChorusAnchorWidget r0 = this.a;
            boolean r8 = ((Boolean) r7).booleanValue();
            int r1 = RealTimeChorusAnchorWidget.v1;
            r0.getClass();
            StringBuilder r2 = new StringBuilder("onIsSingerChanged ");
            r2.append(r8);
            r2.append(" mute=");
            VoiceChatMuteManager r3 = r0.E;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L5:
            r2.append(r3.isMute());
            r2.append(" shouldRestore=");
            r2.append(((MultiLinkVoiceBaseAnchorLinkWidget) r0).x);
            r2.append(" isResumed=");
            r2.append(r0.N);
            r2.append("， isAnchorMute= ");
            if (r0.Sq() != 0) goto L8;
        L10:
            boolean r4 = false;
        L11:
            r2.append(r4);
            jy0.b.d("RealTimeChorusAnchorWidget", r2.toString());
            if (r8 == false) goto L35;
            if (KtvUtilsKt.e() == false) goto L16;
            ((MultiLinkVoiceBaseAnchorLinkWidget) r0).x = false;
        L46:
            hg6.g r9 = r0.F;
            if (r9 == null) goto L50;
            r9.f();
            return;
        L50:
            return;
        L16:
            boolean r10 = jc1.k.n(IKtvService.class).isAudienceSingEnableSwitchOn();
            VoiceChatMuteManager r5 = r0.E;
            if (r5 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L20:
            if (r5.isMute() == false) goto L26;
            if (r0.N == false) goto L26;
            if (r10 == false) goto L26;
            f2.b(2131918609, 0);
        L26:
            if (r0.Y == true) goto L46;
            if (r0.F == null) goto L46;
            jg6.a r11 = r0.Bq();
            if (r11 == null) goto L46;
            kg6.e r12 = r11.b();
            if (r12 == null) goto L46;
            r12.u(false, "");
            goto L46
        L35:
            if (((MultiLinkVoiceBaseAnchorLinkWidget) r0).x == false) goto L43;
            VoiceChatMuteManager r13 = r0.E;
            if (r13 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L39:
            r13.s();
            if (r0.N == true) goto L42;
            ((Widget) r0).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
        L42:
            ((MultiLinkVoiceBaseAnchorLinkWidget) r0).x = false;
        L43:
            hg6.g r14 = r0.F;
            if (r14 == null) goto L46;
            r14.e0("songEnd");
            goto L46
        L8:
            if (r0.Sq() == (-1)) goto L10;
            r4 = true;
            goto L11
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public f(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((z) r2, "event");
            hg6.g r3 = this.a.F;
            if (r3 == null) goto L6;
            r3.f();
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public g(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            RealTimeChorusAnchorWidget r0 = this.a;
            int r1 = RealTimeChorusAnchorWidget.v1;
            r0.ar(r4);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public h(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            hg6.g r0 = this.a.F;
            Intrinsics.checkNotNull(r0);
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r3);
            r0.w(r3.booleanValue());
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public i(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = ((d1) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r3)).data).getEntranceList();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.isEmpty() == true) goto L11;
            RealTimeChorusAnchorWidget r0 = this.a;
            int r1 = RealTimeChorusAnchorWidget.v1;
            if (r0.yq().D == null) goto L12;
            ((ArrayList) this.a.yq().D).clear();
            ArrayList r2 = (ArrayList) this.a.yq().D;
            r2.addAll(r4);
            return;
        L12:
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public k(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Integer r4 = (Integer) r3;
            jy0.b.a("SpatialAudio_RealTimeChorusAnchorWidget", "CurrentStrategyId onValueChanged " + r4);
            hg6.g r0 = this.a.R1();
            if (r0 == null) goto L6;
            r0.i(com.bytedance.android.live.liveinteract.spatial.a.e(r4.intValue()));
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;
        public final /* synthetic */ Ref.LongRef b;

        public l(RealTimeChorusAnchorWidget r1, Ref.LongRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            boolean r1 = false;
            if (((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).e() == false) goto L6;
            f2.c(s1.B(2131922301), 0);
        L6:
            if (((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).f() == false) goto L8;
            f2.c(s1.B(2131922305), 0);
        L8:
            StringBuilder r0 = new StringBuilder("getChorusSetting success ");
            r0.append(((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).d());
            r0.append(' ');
            r0.append(((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).b());
            r0.append(" taskId ");
            w r2 = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).a();
            String r3 = null;
            if (r2 == null) goto L11;
            String r4 = r2.b();
        L12:
            r0.append(r4);
            r0.append("  service : ");
            RealTimeChorusBusinessContext.a r5 = RealTimeChorusBusinessContext.Companion;
            r0.append(r5.c());
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusAnchorWidget", r0.toString());
            int r6 = xe2.g.a;
            w r7 = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).a();
            boolean r8 = true;
            if (r5.c() != null) goto L15;
            boolean r9 = true;
        L16:
            JSONObject r11 = new JSONObject();
            if (r7 == null) goto L19;
            String r10 = r7.a();
        L20:
            r11.put("stream", r10);
            if (r7 == null) goto L23;
            String r12 = r7.b();
        L24:
            r11.put("taskId", r12);
            if (r7 == null) goto L27;
            Boolean r13 = Boolean.valueOf(r7.c());
        L28:
            r11.put("isStarPush", r13);
            r11.put("serverNotNull", r9);
            int r16 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "GetChorusSettingSuccess", 0, null, r11, 88);
            RealTimeChorusAnchorWidget r17 = this.a;
            r17.A = RealTimeChorusAnchorWidget.Pq(r17);
            xe2.h.d = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).b();
            xe2.h.c = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).d();
            w r18 = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).a();
            if (r18 == null) goto L31;
            r3 = r18.b();
        L31:
            if (r3 == null) goto L37;
            if (r3.length() == 0) goto L37;
            r8 = false;
        L37:
            if (r8 == true) goto L39;
        L43:
            fd2.s r19 = r5.c();
            if (r19 == null) goto L54;
            w r20 = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).a();
            if (r20 == null) goto L49;
            String r21 = r20.b();
            if (r21 == null) goto L49;
        L50:
            w r22 = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).a();
            if (r22 == null) goto L53;
            r1 = r22.c();
        L53:
            r19.yj(r21, r1);
        L49:
            r21 = "mass_chorus-" + this.b.element;
        L54:
            xe2.h.i(((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).d(), ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).b(), ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).c(), this.a.A);
            return;
        L39:
            if (((Boolean) KtvSettingHelper.k0.getValue()).booleanValue() == false) goto L43;
            w r23 = ((com.bytedance.android.live.ktv.common.model.api.i) ((ExtraResponse) r15).data).a();
            if (r23 == null) goto L43;
            r23.d("mass_chorus-" + this.b.element);
            goto L43
        L27:
            r13 = null;
            goto L28
        L23:
            r12 = null;
            goto L24
        L19:
            r10 = null;
            goto L20
        L15:
            r9 = false;
            goto L16
        L11:
            r4 = null;
            goto L12
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public m(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusAnchorWidget", "getChorusSetting failed " + r9.getMessage());
            RealTimeChorusAnchorWidget r0 = this.a;
            r0.A = RealTimeChorusAnchorWidget.Pq(r0);
            int r1 = xe2.g.a;
            String r10 = r9.getMessage();
            JSONObject r5 = new JSONObject();
            r5.put("errMsg", r10);
            int r11 = rd0.a.a;
            rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.ChorusCDNStream, "GetChorusSettingFailed", 0, null, r5, 88);
            xe2.h.i(0, 0, 0, this.a.A);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public n(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((h1) r2, "event");
            RealTimeChorusAnchorWidget r3 = this.a;
            int r0 = RealTimeChorusAnchorWidget.v1;
            r3.getClass();
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public o(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            i1 r3 = (i1) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            if (this.a.G == null) goto L6;
            boolean r4 = r3.b;
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.RealTimeChorusAnchorWidget$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02631 extends MutablePropertyReference0Impl {
        public C02631(RealTimeChorusAnchorWidget r7) {
            super(r7, RealTimeChorusAnchorWidget.class, "mPresenter", "getMPresenter()Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/anchor/RealTimeChorusAnchorPresenter;", 0);
        }

        public Object get() {
            RealTimeChorusAnchorPresenter r0 = ((RealTimeChorusAnchorWidget) ((CallableReference) this).receiver).D;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        L5:
            return r0;
        }

        public void set(Object r2) {
            RealTimeChorusAnchorPresenter r3 = (RealTimeChorusAnchorPresenter) r2;
            ((RealTimeChorusAnchorWidget) ((CallableReference) this).receiver).D = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.RealTimeChorusAnchorWidget$onDestroy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02642 extends MutablePropertyReference0Impl {
        public C02642(RealTimeChorusAnchorWidget r7) {
            super(r7, RealTimeChorusAnchorWidget.class, "mMuteManager", "getMMuteManager()Lcom/bytedance/android/live/liveinteract/voicechat/VoiceChatMuteManager;", 0);
        }

        public Object get() {
            return RealTimeChorusAnchorWidget.Qq((RealTimeChorusAnchorWidget) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            VoiceChatMuteManager r3 = (VoiceChatMuteManager) r2;
            ((RealTimeChorusAnchorWidget) ((CallableReference) this).receiver).E = r3;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public p(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            o42.g r4 = (o42.g) r3;
            RealTimeChorusAnchorWidget r0 = this.a;
            int r1 = RealTimeChorusAnchorWidget.v1;
            r0.getClass();
            if (r4 == null) goto L5;
            IBaseUser r2 = r4.a;
        L6:
            if (r2 == null) goto L10;
            r0.h1 = r4.b;
            ((Widget) r0).dataCenter.put("cmd_audio_talk_invite", r4.a);
            return;
        L10:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public q(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((o42.l) r2, "event");
            RealTimeChorusAnchorWidget r3 = this.a;
            int r0 = RealTimeChorusAnchorWidget.v1;
            r3.getClass();
        }
    }

    public static final class r implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ RealTimeChorusAnchorWidget a;

        public final void b(boolean r1) {
        }

        public r(RealTimeChorusAnchorWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L7;
            this.a.G4(true, "on particular page show");
            if (RealTimeChorusAnchorWidget.Qq(this.a).o() != 0) goto L11;
            this.a.yq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
            RealTimeChorusAnchorWidget.Qq(this.a).k("onPause");
            return;
        L11:
            return;
        L7:
            RealTimeChorusAnchorWidget r5 = this.a;
            int r1 = RealTimeChorusAnchorWidget.v1;
            if (r5.Sq() != 3) goto L13;
            RealTimeChorusAnchorWidget.Qq(this.a).l("on particular page close");
            return;
        }
    }

    static {
    }

    public final int C0() {
        return -1;
    }

    public final tf0.o Mq() {
        return null;
    }

    public final void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final boolean canSilenceSelf() {
        return true;
    }

    public final void f1(long r1, long r3) {
    }

    public final int getLayoutId() {
        return 2131567823;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final int he() {
        return -1;
    }

    public final int me() {
        return 1;
    }

    public final void onPause() {
        this.N = false;
        hg6.g r0 = this.F;
        if (r0 == null) goto L6;
        r0.onPause();
    L6:
        if (vm2.e.a() == false) goto L8;
        Tq().f();
    L8:
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).broadcastFloatWindowManager();
        if (isEngineOn() == true) goto L11;
    L29:
        yq().v();
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        return;
    L11:
        if (((MultiLinkVoiceBaseAnchorLinkWidget) this).z == null) goto L29;
        if (jc1.k.n(IInteractService.class).enableCaptureAudioOnBackground(true) == true) goto L28;
        G4(true, "onPause");
        VoiceChatMuteManager r1 = this.E;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L18:
        if (r1.o() != 0) goto L24;
        yq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        VoiceChatMuteManager r2 = this.E;
        if (r2 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L22:
        r2.k("onPause");
    L24:
        if (Jq() == null) goto L29;
        u0 r3 = Jq();
        if (r3 == null) goto L29;
        r3.pause();
        goto L29
    L28:
        x.J();
        goto L29
    }

    public final boolean O5() {
        hg6.g r0 = this.F;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    public final InteractLiveCorePermissionGuarantor Tq() {
        if (this.T != null) goto L7;
        this.T = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.T;
        if (r0 == null) goto L7;
        r0.j(this.g1);
    L7:
        InteractLiveCorePermissionGuarantor r1 = this.T;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final void Yq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_talk_room_admin_allowed_flag", r1)).booleanValue() == false) goto L6;
        TalkRoomLogUtils.q1("live_chat", ((Boolean) b6.i.getValue()).booleanValue());
        ((Widget) this).dataCenter.put("data_talk_room_admin_allowed_flag", r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final void finishAudioTalk() {
        if (this.Q == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.util.k.n(this.L, "link_icon");
    L5:
        ((Widget) this).dataCenter.put("data_audio_talk_dot_with_number_show", "");
        zf6.a r0 = Rq();
        if (r0 == null) goto L8;
        r0.i(new wf6.c("stop_normally"));
    L8:
        Yq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final List<s0> getHeadPointList() {
        if (this.G != null) goto L7;
        return null;
    L7:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final boolean isEngineOn() {
        hg6.g r0 = this.F;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final com.bytedance.android.live.liveinteract.voicechat.b muteManager() {
        VoiceChatMuteManager r0 = this.E;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final hg6.g rtcManger() {
        hg6.g r0 = this.F;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final Boolean t0() {
        com.bytedance.android.live.pushstream.d r0 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.t0());
    }

    public final yf6.a Nq() {
        rf6.a r0 = wq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public final List<Integer> R4() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = r1.t();
        if (r2 == null) goto L11;
        ClientUIInfo r3 = r2.a();
        if (r3 == null) goto L11;
        return r3.getUiFeatureList();
    L11:
        return null;
    }

    public final zf6.a Rq() {
        rf6.a r0 = wq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public final int Sq() {
        y r0 = yq();
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) r0.a5(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
    L6:
        if (r1 != null) goto L10;
        return -1;
    L10:
        return r1.getSilenceStatus();
    L5:
        r1 = null;
        goto L6
    }

    public final void Wq() {
        enableSubWidgetManager();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.x r0 = (com.bytedance.android.livesdk.ktvimpl.realtimechorus.x) this.H.getValue();
        if (r0 == null) goto L7;
        RealTimeChorusMainViewWidget r1 = this.G;
        if (r1 == null) goto L7;
        r1.jr(r0);
    L7:
        WidgetManager r2 = ((Widget) this).subWidgetManager;
        if (r2 == null) goto L11;
        r2.load(2131389500, this.G, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return yq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return yq().c;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final int getSelfSilenceType() {
        if (isEngineOn() == true) goto L7;
        return 0;
    L7:
        return Sq();
    }

    public final int getUILayout() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final void onCreate() {
        super.onCreate();
        if (((Boolean) KtvSettingHelper.x.getValue()).booleanValue() == false) goto L7;
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L7;
        r0.removeKtvComponent();
    L7:
        this.F = zq().getRtcManager();
        this.Z.c();
        i0 r1 = j0.a;
        this.C = j0.c(((Widget) this).dataCenter, this);
        tc0.c.h().B = 9;
        this.O = new InteractAnimationController(((Widget) this).dataCenter);
        InteractAnimationContext r2 = (InteractAnimationContext) com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE).component1();
        r2.getController().d(this.O);
        com.bytedance.live.datacontext.b.a(r2, InteractAnimationContext.class);
        Pair r3 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        RealTimeChorusAnchorDataContext r4 = (RealTimeChorusAnchorDataContext) r3.component1();
        Disposable r5 = (Disposable) r3.component2();
        r4.getService().d(this);
        com.bytedance.live.datacontext.b.a(r4, "real_time_chorus_anchor_context");
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r5);
        Pair r6 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        RealTimeChorusGlobalDataContext r7 = (RealTimeChorusGlobalDataContext) r6.component1();
        Disposable r8 = (Disposable) r6.component2();
        r7.getRealTimeChorusAdminService().d(this);
        com.bytedance.live.datacontext.b.a(r7, "real_time_chorus_admin_context");
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r8);
        long r9 = SystemClock.elapsedRealtime();
        this.K = r9;
        ((Widget) this).dataCenter.put("data_room_audio_chat_anchor_uilayout_start_time", Long.valueOf(r9));
        yq().i();
        enableSubWidgetManager();
        if (this.V != null) goto L10;
        enableSubWidgetManager();
        ThemedCompetitionWidget r10 = new ThemedCompetitionWidget();
        this.V = r10;
        ((Widget) this).subWidgetManager.load(r10);
    L10:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r11 = md();
        w0 r12 = this.J;
        KtvContext.Companion.getClass();
        KtvContext r13 = KtvContext.a.g();
        yq();
        RealTimeChorusMainViewWidget r14 = new RealTimeChorusMainViewWidget(0, r11, r12, r13, this);
        this.G = r14;
        InteractAnimationController r15 = this.O;
        if (r15 == null) goto L13;
        Intrinsics.checkNotNull(r14);
        r15.g(r14);
    L13:
        Wq();
        if (jm2.a.d(getMRoom()) == null) goto L190;
        this.D = new RealTimeChorusAnchorPresenter(com.bytedance.android.live.liveinteract.api.utils.m.e(this), zq());
        this.I = new WeakHandler(this);
        this.Q = new com.bytedance.android.live.liveinteract.voicechat.util.k(((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.j(this));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r16 = MultiRevenueDataContext.a.d();
        if (r16 == null) goto L28;
        sb0 r17 = sb0.a;
        if (((rb1) r17.getValue()).a() == true) goto L24;
        if (((rb1) r17.getValue()).f() == true) goto L24;
        if (hg6.i.c() == false) goto L28;
    L24:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L26;
        r16.o(((Widget) this).dataCenter, this, SceneType.SCENE_KTV, ((Widget) this).containerView);
    L26:
        r16.d(((Widget) this).dataCenter);
    L28:
        if (this.W != null) goto L31;
        enableSubWidgetManager();
        QuickInteractWidget r18 = new QuickInteractWidget();
        this.W = r18;
        ((Widget) this).subWidgetManager.load(r18);
    L31:
        if (this.X != null) goto L44;
        enableSubWidgetManager();
        this.X = new LinkmicSubtitleBusinessWidget();
        vb6.g r19 = Iq();
        if (r19 == null) goto L39;
        yb6.e r20 = r19.j();
        if (r20 == null) goto L39;
        LinkmicSubtitleBusinessWidget r21 = this.X;
        if (r21 == null) goto L39;
        Intrinsics.checkNotNullParameter(r20, "mediaManager");
        r21.c = r20;
    L39:
        LinkmicSubtitleBusinessWidget r22 = this.X;
        if (r22 == null) goto L42;
        com.bytedance.android.live.pushstream.d r23 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).z;
        Intrinsics.checkNotNullParameter(r23, "liveStream");
        r22.d = r23;
    L42:
        ((Widget) this).subWidgetManager.load(this.X);
    L44:
        if (this.p0 != null) goto L46;
        enableSubWidgetManager();
        RealTimeChorusBusinessWidget r24 = new RealTimeChorusBusinessWidget();
        this.p0 = r24;
        ((Widget) this).subWidgetManager.load(r24);
    L46:
        VoiceChatMuteManager r25 = new VoiceChatMuteManager(getMRoom(), true, yq(), ((Widget) this).dataCenter, this, this, this);
        this.E = r25;
        r25.j();
        DataCenter r26 = ((Widget) this).dataCenter;
        y r27 = yq();
        VoiceChatMuteManager r28 = this.E;
        if (r28 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L49:
        new MuteStateChecker(r26, r27, r28);
        RealTimeChorusAnchorPresenter r29 = this.D;
        if (r29 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L52:
        r29.g0(this);
        m00.e r30 = ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).createLinkInRoomView(((MultiLinkVoiceBaseAnchorLinkWidget) this).z, ((Widget) this).context, 0);
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).r = r30;
        u0 r31 = Jq();
        d0 r32 = null;
        if ((r31 instanceof v0) == true) goto L55;
        r31 = null;
    L55:
        v0 r33 = (v0) r31;
        if (r33 == null) goto L62;
        vb6.g r34 = Iq();
        if (r34 == null) goto L62;
        yb6.e r35 = r34.j();
        if (r35 == null) goto L62;
        r35.s0(gc6.b.c(r33, null), "RealTimeChorusAnchorWidget setLiveClient");
    L62:
        y3.m(((Widget) this).dataCenter).d(ToolbarButton.INTERACTION_ROOM, this.P);
        this.P.b(8);
        if (vm2.e.a() == true) goto L65;
    L71:
        u r36 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r36 == null) goto L84;
        com.bytedance.live.datacontext.j r37 = r36.s();
        if (r37 == null) goto L84;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r38 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r37.getValue();
        if (r38 == null) goto L84;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r39 = r38.t();
        if (r39 == null) goto L84;
        hg6.g r40 = R1();
        if (r40 == null) goto L84;
        fg6.b r41 = r40.F();
        if (r41 == null) goto L84;
        r41.b(pg6.a.b(r39));
    L84:
        u r42 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r42 == null) goto L100;
        com.bytedance.live.datacontext.j r43 = r42.s();
        if (r43 == null) goto L89;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r44 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r43.getValue();
    L90:
        if (r44 == null) goto L100;
        com.bytedance.live.datacontext.j r45 = r42.s();
        if (r45 == null) goto L94;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r46 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r45.getValue();
    L95:
        Intrinsics.checkNotNull(r46);
        int r47 = r46.t().a;
        com.bytedance.live.datacontext.j r48 = r42.s();
        if (r48 == null) goto L98;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r49 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r48.getValue();
    L99:
        Intrinsics.checkNotNull(r49);
        int r50 = r49.t().b;
        goto L100
    L98:
        r49 = null;
        goto L99
    L94:
        r46 = null;
        goto L95
    L89:
        r44 = null;
    L100:
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_audio_talk_invite", this);
        ((Widget) this).dataCenter.observeForever("data_interact_anchor_param_change", this);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_anchor_uilayout_switch_time", this);
        ((Widget) this).dataCenter.observe("cmd_auto_join_channel", this);
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        ((Widget) this).dataCenter.put("cmd_interact_real_time_chorus", new jd0.k(true));
        yq().Q4(this.b1);
        br(h1.class, new n(this));
        br(i1.class, new o(this));
        br(o42.g.class, new p(this));
        br(o42.l.class, new q(this));
        com.bytedance.android.live.core.utils.rxutils.j.a r51 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.S = com.bytedance.android.live.core.utils.rxutils.j.a(1, 1, TimeUnit.MINUTES).subscribe(new c(this));
        IInteractService r52 = jc1.k.f(IInteractService.class);
        if (r52 == null) goto L103;
        x00.a r53 = r52.getThemeManager(true, ((Widget) this).dataCenter);
    L104:
        if (r53 == null) goto L108;
        r53.j(this, new d(this), 100);
        IVoiceLiveTheme r54 = getMRoom().getVoiceLiveTheme();
        if (r54 == null) goto L108;
        r53.c(r54, 100);
    L108:
        if (r42 == null) goto L115;
        Disposable r55 = jc1.k.n(IKtvService.class).observerCurrentIsSinger(null, false, new e(this));
        if (r55 == null) goto L112;
        RxUtilKt.c(r55, ((MultiLinkBaseAnchorLinkWidget) this).m);
    L112:
        com.bytedance.live.datacontext.k r56 = jc1.k.n(IKtvService.class).ktvComponentSingerChangedEvent();
        if (r56 == null) goto L115;
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r56.onEvent().subscribe(new f(this)));
    L115:
        if (r42 == null) goto L126;
        com.bytedance.live.datacontext.j r57 = r42.s();
        if (r57 == null) goto L126;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r58 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r57.getValue();
        if (r58 == null) goto L126;
        BehaviorSubject r59 = r58.a();
        if (r59 == null) goto L126;
        Disposable r60 = r59.subscribe(new g(this));
        if (r60 == null) goto L126;
        RxUtilKt.c(r60, ((MultiLinkBaseAnchorLinkWidget) this).m);
    L126:
        if (vm2.d.w() == true) goto L129;
    L131:
        com.bytedance.live.datacontext.m r61 = jc1.k.n(IKtvService.class).getHasBgm();
        if (r61 == null) goto L134;
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r61.a().subscribe(new h(this)));
    L134:
        ((ObservableSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).fetchInteractEntrances(getMRoom().getRoomId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new i(this), j.a);
        if (vm2.d.U0() == false) goto L141;
        u r62 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r62 == null) goto L141;
        com.bytedance.live.datacontext.k r63 = r62.L();
        if (r63 == null) goto L141;
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(RxUtilKt.p(r63.onEvent(), "RealTimeChorusAnchorWidget", new RealTimeChorusAnchorWidget$onCreate$$inlined$let$lambda$1(this)));
    L141:
        SpatialAudioContext r64 = SpatialAudioContext.Companion.getContext();
        if (r64 == null) goto L150;
        com.bytedance.live.datacontext.m r65 = r64.getCurrentStrategyId();
        if (r65 == null) goto L150;
        Observable r66 = r65.a();
        if (r66 == null) goto L150;
        Disposable r67 = r66.subscribe(new k(this));
        if (r67 == null) goto L150;
        RxUtilKt.c(r67, ((MultiLinkBaseAnchorLinkWidget) this).m);
    L150:
        DataCenter r68 = ((Widget) this).dataCenter;
        if (r68 == null) goto L157;
        jd0.c r69 = (jd0.c) r68.get("data_gift_message_board_linkmic_event", new jd0.c(0));
        if (r69 == null) goto L157;
        if (r2.a(r69.a) == false) goto L157;
        xs2.b.a().post(r69);
        ((Widget) this).dataCenter.put("data_gift_message_board_linkmic_event", null);
    L157:
        com.bytedance.android.live.liveinteract.linksecurity.c r70 = com.bytedance.android.live.liveinteract.linksecurity.c.g;
        r70.j();
        r70.k(((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.api.utils.p r71 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).u;
        if (r71 == null) goto L160;
        r71.a(getMRoom().getRoomId());
    L160:
        DataCenter r72 = ((Widget) this).dataCenter;
        Boolean r73 = Boolean.FALSE;
        if (((Boolean) r72.get("data_audio_chat_continue_linkmic_update_send_gift_status", r73)).booleanValue() == false) goto L163;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Nf();
        ((Widget) this).dataCenter.put("data_audio_chat_continue_linkmic_update_send_gift_status", r73);
    L163:
        com.bytedance.android.live.liveinteract.plantform.core.h r74 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, yq());
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).t = r74;
        r74.a();
        hg6.g r75 = this.F;
        if (r75 == null) goto L166;
        ei6.a r76 = r75.V0();
    L167:
        hg6.g r77 = this.F;
        if (r77 == null) goto L174;
        ec6.b r78 = r77.R();
        if (r78 == null) goto L174;
        com.bytedance.android.live.pushstream.d r79 = gc6.b.a(r78);
        if (r79 == null) goto L174;
        r32 = r79.getLiveCore();
    L174:
        if (r76 == null) goto L179;
        if (r32 == null) goto L179;
        com.bytedance.android.live.liveinteract.plantform.core.h r80 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).t;
        if (r80 == null) goto L179;
        r80.d(new WeakReference(r76), new WeakReference(r32));
    L179:
        xs2.b.a().post(new pe0.a());
        Ref.LongRef r81 = new Ref.LongRef();
        com.bytedance.android.livesdk.chatroom.o r82 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r82 == null) goto L186;
        com.bytedance.live.datacontext.m r83 = r82.getRoom();
        if (r83 == null) goto L186;
        IRoom r85 = (IRoom) r83.getValue();
        if (r85 == null) goto L186;
        long r86 = r85.getRoomId();
    L187:
        r81.element = r86;
        RxUtilKt.c(((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).getChorusSetting(r81.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r81), new m(this)), ((MultiLinkBaseAnchorLinkWidget) this).m);
        this.B = System.currentTimeMillis();
        return;
    L186:
        r86 = 0;
        goto L187
    L166:
        r76 = null;
        goto L167
    L129:
        if (this.U != null) goto L131;
        enableSubWidgetManager();
        ChatMatchWidget r87 = new ChatMatchWidget(true, this);
        this.U = r87;
        ((Widget) this).subWidgetManager.load(r87);
        goto L131
    L103:
        r53 = null;
        goto L104
    L65:
        if ((getContext() instanceof FragmentActivity) == false) goto L71;
        InteractLiveCorePermissionGuarantor r88 = Tq();
        FragmentActivity r89 = getContext();
        if (r89 == null) goto L70;
        r88.i(r89);
        goto L71
    L70:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L190:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    }

    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        RealTimeChorusMainViewWidget r0 = this.G;
        if (r0 == null) goto L5;
        r0.onBizDestory();
    L5:
        ih0.d r1 = this.L0;
        if (r1 != null) goto L8;
    L12:
        q0 r2 = this.P0;
        if (r2 != null) goto L15;
    L19:
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r3 = this.H0;
        if (r3 != null) goto L22;
    L42:
        this.Z.b();
        yf6.a r4 = Nq();
        if (r4 == null) goto L45;
        r4.f();
    L45:
        com.bytedance.android.live.liveinteract.plantform.core.h r5 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).t;
        if (r5 == null) goto L48;
        r5.b();
    L48:
        InteractAnimationController r6 = this.O;
        if (r6 == null) goto L51;
        r6.l();
    L51:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r7 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("talkroom destroy");
        if (vm2.e.a() == false) goto L54;
        Tq().e();
    L54:
        DataCenter r8 = ((Widget) this).dataCenter;
        Boolean r9 = Boolean.FALSE;
        r8.put("data_self_is_silenced", r9);
        ((Widget) this).dataCenter.put("cmd_interact_real_time_chorus", new jd0.k(false));
        ((Widget) this).dataCenter.removeObserver(this);
        if (getMRoom().getLinkInitResult() == null) goto L57;
        boolean r10 = true;
    L58:
        com.bytedance.android.live.liveinteract.voicechat.util.k r11 = this.Q;
        if (r11 == null) goto L61;
        r11.e(this.K, r10);
    L61:
        com.bytedance.android.live.liveinteract.voicechat.util.k r12 = this.Q;
        if (r12 == null) goto L64;
        com.bytedance.android.live.liveinteract.voicechat.util.k.i(r12, com.bytedance.android.live.liveinteract.linkpanel.util.m.b(9, 61), null, null, 56);
    L64:
        com.bytedance.android.live.liveinteract.voicechat.util.k r13 = this.Q;
        if (r13 == null) goto L67;
        com.bytedance.android.live.liveinteract.voicechat.util.k.k(r13, this.K, this.L, Integer.valueOf(this.M), r10, getMRoom().getCircleInfo(), com.bytedance.android.live.liveinteract.linkpanel.util.m.b(9, 61));
    L67:
        mz0.f r14 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r14 instanceof mz0.f) == true) goto L70;
    L72:
        tc0.c.h().j(r9);
        RealTimeChorusAnchorPresenter r15 = this.D;
        if (r15 == null) goto L75;
        r15.detachView();
    L75:
        VoiceChatMuteManager r16 = this.E;
        if (r16 == null) goto L79;
        r16.n();
    L79:
        if (((MultiLinkBaseAnchorLinkWidget) this).b == null) goto L81;
        boolean r17 = true;
    L82:
        if (r17 == false) goto L87;
        yq().T4(this.b1);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L86;
        yq().m();
        goto L87
    L86:
        yq().l();
    L87:
        this.P.b(8);
        y3.m(((Widget) this).dataCenter).d(ToolbarButton.INTERACTION_ROOM, this.P);
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L90;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().uo();
    L90:
        CompositeDisposable r18 = ((MultiLinkBaseAnchorLinkWidget) this).m;
        if (r18 != null) goto L93;
    L95:
        com.bytedance.android.live.liveinteract.api.utils.p r19 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).u;
        if (r19 == null) goto L98;
        r19.b();
    L98:
        Disposable r20 = this.S;
        if (r20 == null) goto L105;
        Intrinsics.checkNotNull(r20);
        if (r20.isDisposed() == true) goto L105;
        Disposable r21 = this.S;
        if (r21 == null) goto L105;
        r21.dispose();
    L105:
        Yq();
        u r22 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r22 == null) goto L110;
        com.bytedance.live.datacontext.m r23 = r22.I1();
        if (r23 == null) goto L110;
        r23.setValue(r9);
    L110:
        com.bytedance.android.live.liveinteract.plantform.base.g r24 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r24 == null) goto L113;
        r24.Sc();
    L113:
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L117;
        Integer r26 = (Integer) r25.get("data_link_state", 0);
        if (r26 == null) goto L117;
    L121:
        if (r26 == null) goto L123;
        r26.intValue();
        boolean r27 = !v.a(r26.intValue(), 8);
    L124:
        if (r27 == false) goto L126;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r28 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, null, false, false, null, 60);
    L135:
        ar(r28);
        if (vm2.d.j0() == false) goto L147;
        WidgetManager r29 = ((Widget) this).subWidgetManager;
        if (r29 == null) goto L147;
        List r30 = r29.widgets;
        if (r30 == null) goto L147;
        if (r30.size() <= 0) goto L147;
        Iterator r31 = ((Widget) this).subWidgetManager.widgets.iterator();
    L145:
        if (r31.hasNext() == false) goto L147;
        ((Widget) this).subWidgetManager.unload((Widget) r31.next());
    L147:
        super.onDestroy();
        u r32 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r32 == null) goto L154;
        com.bytedance.live.datacontext.j r33 = r32.J();
        if (r33 == null) goto L154;
        LivePlayModeLogContext r34 = (LivePlayModeLogContext) r33.getValue();
        if (r34 == null) goto L154;
        r34.clearPlayModesOnlySupportMultiPeople();
    L154:
        com.bytedance.android.live.liveinteract.linksecurity.c.g.l();
        sh0.d0 r35 = sh0.d0.b;
        i0 r36 = this.C;
        if (r36 == null) goto L157;
        r36.d0(r35, null);
    L157:
        i0 r37 = j0.a;
        j0.b(((Widget) this).dataCenter);
        hg6.g r38 = this.F;
        if (r38 == null) goto L160;
        r38.i(false);
    L160:
        String r39 = String.valueOf((System.currentTimeMillis() - this.B) / ((long) 1000));
        String r40 = this.A;
        Intrinsics.checkNotNullParameter(r39, "duration");
        HashMap r41 = new HashMap();
        r41.put("duration", r39);
        if (r2.a(r40) == false) goto L165;
        if (r40 != null) goto L164;
        r40 = "";
    L164:
        r41.put("source", r40);
    L165:
        r41.put("order_limit", xe2.h.f(xe2.h.c));
        r41.put("join_limit", xe2.h.f(xe2.h.d));
        r41.put("stage_level", xe2.h.g());
        r41.put("function_type2", "chorus");
        r41.put("function_type", "chorus");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_chorus_over", r41, new Object[]{IRoom.class, am2.x.class});
        this.B = 0;
        this.p0 = null;
        this.G = null;
        return;
    L126:
        u r42 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r42 == null) goto L134;
        com.bytedance.live.datacontext.j r43 = r42.s();
        if (r43 == null) goto L134;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r44 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r43.getValue();
        if (r44 == null) goto L134;
        r28 = r44.t();
        if (r28 != null) goto L135;
    L134:
        r28 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, null, false, false, null, 60);
        goto L135
    L123:
        r27 = false;
    L117:
        IInteractService r45 = jc1.k.f(IInteractService.class);
        if (r45 == null) goto L120;
        r26 = Integer.valueOf(r45.getLinkMode());
        goto L121
    L120:
        r26 = null;
        goto L121
    L93:
        if (r18.isDisposed() == true) goto L95;
        ((MultiLinkBaseAnchorLinkWidget) this).m.dispose();
        goto L95
    L81:
        r17 = false;
        goto L82
    L70:
        if (r14.o() == false) goto L72;
        jc1.k.n(IMiddlewareHostAction.class).dismissInvitePanel();
        goto L72
    L57:
        r10 = false;
        goto L58
    L22:
        if (r3.isShowing() != true) goto L42;
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r46 = this.H0;
        if (r46 == null) goto L42;
        Handler r47 = DialogLancet.resolveDialogHandler(r46);
        if (r47 != null) goto L28;
    L30:
        DialogLancet.beforeDialogDismiss(r46);
        r46.dismiss();     // Catch: Throwable -> L33 Exception -> L35
    L39:
        DialogLancet.afterDialogDismiss(r46);
        goto L42
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
        Throwable r48 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
        if (r48 == null) goto L39;
        com.bytedance.crash.d.d(r48, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r46);
        throw th;
    L28:
        if (Looper.myLooper() == r47.getLooper()) goto L30;
        r47.post(DialogLancet.createDismissRunnable(r46));
        goto L42
    L15:
        if (r2.p() != true) goto L19;
        q0 r49 = this.P0;
        if (r49 == null) goto L19;
        r49.dismissDialog();
        goto L19
    L8:
        if (r1.p() != true) goto L12;
        ih0.d r50 = this.L0;
        if (r50 == null) goto L12;
        r50.dismissDialog();
        goto L12
    }

    public final void onResume() {
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget*/.onResume();
        this.N = true;
        hg6.g r0 = this.F;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        WeakHandler r1 = this.I;
        if (r1 == null) goto L9;
        r1.removeCallbacksAndMessages(null);
    L9:
        if (vm2.e.a() == false) goto L12;
        Tq().g();
    L12:
        if (isEngineOn() == true) goto L14;
    L35:
        hg6.g r2 = this.F;
        if (r2 == null) goto L38;
        r2.i(com.bytedance.android.live.liveinteract.spatial.a.e(-1));
    L38:
        yq().r0();
        return;
    L14:
        if (((MultiLinkVoiceBaseAnchorLinkWidget) this).z == null) goto L35;
        if (Jq() == null) goto L21;
        u0 r3 = Jq();
        if (r3 == null) goto L21;
        r3.resume();
    L21:
        if (vm2.e.a() == false) goto L25;
        if (Tq().p == false) goto L25;
    L30:
        jg6.a r4 = Bq();
        if (r4 == null) goto L35;
        kg6.e r5 = r4.b();
        if (r5 == null) goto L35;
        r5.y(false, "onResume");
    L25:
        if (Sq() != 3) goto L30;
        VoiceChatMuteManager r6 = this.E;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L29:
        r6.l("onResume");
        goto L30
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L6;
        Tq().h();
        return;
    }

    public final BizLinkServiceType Gq() {
        return BizLinkServiceType.ChorusAnchor;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final tf0.h getInteractAnimationService() {
        return this.O;
    }

    public final int getScene() {
        return this.L;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final RealTimeChorusMainViewWidget u2() {
        return this.G;
    }

    public static final String Pq(RealTimeChorusAnchorWidget r3) {
        DataCenter r4 = ((Widget) r3).dataCenter;
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = (String) r4.get("data_voice_chat_room_shoot_way", "null");
    L7:
        if (Intrinsics.areEqual(r5, "direct_shoot") == false) goto L21;
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r6 == null) goto L14;
        Map<String, String> r7 = r6.getMap();
        if (r7 == null) goto L14;
        r0 = r7.get("enter_from_merge");
    L14:
        if (Intrinsics.areEqual(r0, "chorus_page") == false) goto L21;
        com.bytedance.android.livesdk.log.filter.o r8 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r8 == null) goto L21;
        Map<String, String> r9 = r8.getMap();
        if (r9 == null) goto L21;
        String r10 = r9.get("enter_from_merge");
        if (r10 == null) goto L21;
        return r10;
    L21:
        return "";
    L5:
        r5 = null;
        goto L7
    }

    public static final /* synthetic */ VoiceChatMuteManager Qq(RealTimeChorusAnchorWidget r1) {
        VoiceChatMuteManager r2 = r1.E;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        return r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final void C3(RealTimeChorusBusinessWidget.h r2) {
        if (r2 == null) goto L7;
        hg6.g r0 = this.F;
        if (r0 == null) goto L8;
        r0.Z(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final void E4(RealTimeChorusBusinessWidget.h r2) {
        if (r2 == null) goto L7;
        hg6.g r0 = this.F;
        if (r0 == null) goto L8;
        r0.p(r2);
        return;
    L8:
        return;
    }

    public final String N4(String r2) {
        y r0 = yq();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.N4(r2);
    }

    public final void Vj(ILinkPlayerInfoBridge r7) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.INFO);
        ILiveLinkCameraBackUpConfig r0 = vm2.g.c();
        if (ILiveLinkCameraBackUpConfigKt.supportMsgUpdateForAnchor(r0) == true) goto L6;
        return;
    L6:
        if (r7.getUser() == null) goto L36;
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
        if (this.N == true) goto L20;
        return;
    L20:
        if (((MultiLinkVoiceBaseAnchorLinkWidget) this).z.getLiveCore() == null) goto L22;
        boolean r3 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).z.getLiveCore().t0();
    L24:
        if (r7.getSilenceStatus() == 0) goto L34;
        if (r3 == true) goto L33;
        int r4 = this.R + 1;
        this.R = r4;
        Set r5 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r4, null, Boolean.valueOf(r3), r7.getSilenceStatus(), r7.getLinkType());
        if (this.R < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r0)) goto L38;
        jg6.a r8 = Bq();
        if (r8 == null) goto L39;
        kg6.e r9 = r8.b();
        if (r9 == null) goto L40;
        r9.t(new kg6.b(false, false, "link security", 8));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L33:
        this.R = 0;
        return;
    L34:
        this.R = 0;
        return;
    L22:
        r3 = false;
        goto L24
    L10:
        r2 = null;
        goto L12
    }

    public final void Zq(ILinkPlayerInfoBridge r5) {
        if (r5.getUser() == null) goto L28;
        IBaseUser r0 = r5.getUser();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getIdString();
    L8:
        IRoom r3 = getMRoom();
        if (r3 == null) goto L11;
        String r4 = r3.getOwnerUserIdString();
    L12:
        boolean r6 = Intrinsics.areEqual(r2, r4);
        IBaseUser r7 = r5.getUser();
        if (r7 == null) goto L16;
        r1 = r7.getIdString();
    L16:
        if (Intrinsics.areEqual(r1, com.bytedance.android.live.liveinteract.linkpanel.util.o.J()) == false) goto L18;
        String r8 = "oneself";
    L21:
        IBaseUser r9 = r5.getUser();
        if (r9 == null) goto L25;
        String r10 = r9.getIdString();
        if (r10 == null) goto L25;
    L26:
        TalkRoomLogUtils.d(r10, r8, com.bytedance.android.live.liveinteract.plantform.model.n.b(r5));
        return;
    L25:
        r10 = "";
        goto L26
    L18:
        if (r6 == false) goto L20;
        r8 = "anchor";
        goto L21
    L20:
        r8 = "audience";
        goto L21
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.b
    public final void ap(fi6.a r3) {
        if (r3 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.a r0 = this.V0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "config");
        r0.a = r3;
        return;
    }

    public final void ar(com.bytedance.android.livesdk.chatroom.viewmodel.i r22) {
        int r2 = this.L;
        int r3 = this.M;
        int r4 = r22.a;
        this.L = r4;
        int r5 = r22.b;
        this.M = r5;
        boolean r7 = false;
        if (r2 != r4) goto L5;
        boolean r8 = true;
    L6:
        if (r3 != r5) goto L8;
        boolean r9 = true;
    L9:
        if (r8 == false) goto L13;
        if (r9 == false) goto L13;
        return;
    L13:
        if (jc0.a.b(r4, r5) == false) goto L18;
        if (jc0.a.b(r22.a, r22.b) == false) goto L26;
        Wq();
    L26:
        RealTimeChorusMainViewWidget r6 = this.G;
        if (r6 == null) goto L29;
        r6.Wq(r22, false);
    L29:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r10 = null;
        if (jc0.a.b(r22.a, r22.b) == true) goto L36;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getStatisticHelper().a = null;
        if (jc0.a.b(r2, r3) == false) goto L40;
        RealTimeChorusMainViewWidget r11 = this.G;
        if (r11 == null) goto L40;
        r11.onBizDestory();
    L40:
        long r12 = SystemClock.elapsedRealtime();
        this.K = r12;
        ((Widget) this).dataCenter.put("data_room_audio_chat_anchor_uilayout_start_time", Long.valueOf(r12));
        if (jc0.a.b(r22.a, r22.b) == false) goto L139;
        int r13 = this.L;
        int r14 = this.M;
        boolean r15 = r22.d;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r16 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r13), Integer.valueOf(r14), null, null) == true) goto L65;
        String r17 = TalkRoomLogUtils.p(Integer.valueOf(r2), Integer.valueOf(r3), null);
        String r18 = TalkRoomLogUtils.p(Integer.valueOf(r13), Integer.valueOf(r14), null);
        String r19 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r3));
        String r110 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r14));
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r17, r18) == false) goto L54;
        if (r2 == 0) goto L54;
        if (ILiveWrappedLivePusher.a.a(r19, r110) == true) goto L65;
        com.bytedance.android.live.liveinteract.voicechat.util.k r111 = this.Q;
        if (r111 == null) goto L65;
        com.bytedance.android.live.liveinteract.voicechat.util.k.g(r111, null, r110, null, null, 12);
    L54:
        if (r2 != 0) goto L56;
        r7 = true;
    L56:
        com.bytedance.android.live.liveinteract.voicechat.util.k r112 = this.Q;
        if (r112 == null) goto L65;
        if (r7 == true) goto L63;
        if (r19 == null) goto L63;
        if (Intrinsics.areEqual(r19, r110) == false) goto L63;
        String r113 = "function_switch";
    L64:
        com.bytedance.android.live.liveinteract.voicechat.util.k.g(r112, r18, r110, r113, null, 8);
    L63:
        r113 = null;
    L65:
        if (r15 == true) goto L139;
        if (this.p1 == true) goto L139;
        HashMap r20 = new HashMap();
        if (r13 == 5) goto L84;
        if (r13 == 9) goto L75;
    L88:
        ICircleInfo r21 = getMRoom().getCircleInfo();
        if (r21 == null) goto L91;
        String r23 = r21.getCircleName();
    L93:
        if (TextUtils.isEmpty(r23) == true) goto L99;
        ICircleInfo r24 = getMRoom().getCircleInfo();
        if (r24 == null) goto L97;
        String r25 = r24.getCircleName();
    L98:
        r20.put("circle_name", String.valueOf(r25));
        goto L99
    L97:
        r25 = null;
    L99:
        String r26 = TalkRoomLogUtils.d;
        if (r26 == null) goto L103;
        r20.put("source", r26);
    L103:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L105;
        r20.put("is_invite_only", "1");
    L106:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r27 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (r27 == null) goto L116;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r28 = r27;
        if (r28.getMap().containsKey("enter_from") == false) goto L116;
        if (TextUtils.equals((CharSequence) r28.getMap().get("enter_from"), "chat_match") == false) goto L114;
        r20.put("source", "chat_match");
        goto L116
    L114:
        if (TextUtils.equals((CharSequence) r28.getMap().get("solo_ktv"), "solo_ktv") == false) goto L116;
        r20.put("source", "solo_ktv");
    L116:
        r20.put("shoot_way", "switch_layout");
        u r29 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r29 == null) goto L125;
        com.bytedance.live.datacontext.j r30 = r29.s();
        if (r30 == null) goto L125;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r31 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r30.getValue();
        if (r31 == null) goto L125;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r32 = r31.g();
        if (r32 == null) goto L125;
        Integer r33 = Integer.valueOf(r32.a);
    L126:
        u r34 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r34 == null) goto L135;
        com.bytedance.live.datacontext.j r35 = r34.s();
        if (r35 == null) goto L135;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r36 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r35.getValue();
        if (r36 == null) goto L135;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r37 = r36.g();
        if (r37 == null) goto L135;
        Integer r38 = Integer.valueOf(r37.b);
    L136:
        r20.put("before_function", com.bytedance.android.live.liveinteract.plantform.utils.u0.a(r33, r38));
        if (this.Q == null) goto L139;
        com.bytedance.android.live.liveinteract.voicechat.util.k.c(r13, r14, r20);
    L135:
        r38 = null;
    L125:
        r33 = null;
        goto L126
    L105:
        r20.put("is_invite_only", BDLocationException.ERROR_TIMEOUT);
        goto L106
    L91:
        r23 = null;
        goto L93
    L75:
        if (r14 != 61) goto L77;
        r20.put("function_type", "chorus");
        r20.put("function_type2", "chorus");
    L79:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L81;
        String r39 = "on";
    L82:
        r20.put("is_camera_allow", r39);
        goto L88
    L81:
        r39 = "off";
        goto L82
    L77:
        r20.put("function_type", "ktv");
        r20.put("function_type2", "ktv");
        goto L79
    L84:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(getMRoom()) == false) goto L86;
        String r40 = "party";
    L87:
        r20.put("function_type", r40);
        goto L88
    L86:
        r40 = "radio";
    L139:
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r41 = mz0.d.b(LogCommon.LINKMIC_SCENE_DATA);
        if ((r41 instanceof mz0.e) == false) goto L143;
        r10 = r41;
    L143:
        hg6.g r42 = R1();
        if (r42 == null) goto L146;
        r42.D(r22.a, "RealTimeChorusAnchorWidget afterSwitchScene");
    L146:
        if (r10 == null) goto L148;
        r10.c(new com.bytedance.android.livesdk.log.filter.y(this.L));
    L148:
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L152;
        r1.o6(Kq(this.L), true);
        return;
    L152:
        return;
    L36:
        RealTimeChorusMainViewWidget r43 = this.G;
        if (r43 == null) goto L39;
        r43.onBizEnterRoom();
    L39:
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", new nh0.f("linkmic", new nh0.e(9, 61, com.bytedance.android.live.liveinteract.plantform.utils.u0.d(), 0, 0, null, null, null, 248), null, null, null, null, false, 224));
        goto L40
    L18:
        if (jc0.a.b(r22.a, r22.b) == false) goto L20;
        Wq();
    L20:
        if (r2 != 0) goto L22;
    L25:
        LinkedHashMap r44 = new LinkedHashMap();
        r44.put("reason", "switch_scene_api");
        com.bytedance.android.live.liveinteract.plantform.utils.i.c(r22.a, r22.b, r44);
        goto L26
    L22:
        if (vm2.d.D() == false) goto L24;
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "interact_panel");
        goto L25
    L24:
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "null");
        goto L25
    L8:
        r9 = false;
        goto L9
    L5:
        r8 = false;
        goto L6
    }

    public final void handleMsg(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        isViewValid();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        r7.a = 61;
        r7.e = Integer.valueOf(AudienceInviteSource.REALTIME_CHORUS.getValue());
        ILinkPlayerInfoBridge r0 = yq().p(r7.b(), null);
        StringBuilder r1 = new StringBuilder("invite, chorusGuestStatus: ");
        if (r0 == null) goto L5;
        Long r3 = Long.valueOf(r0.getChorusGuestStatus());
    L6:
        r1.append(r3);
        jy0.b.d("RealTimeChorusAnchorWidget", r1.toString());
        if (r0 != null) goto L9;
    L13:
        zf6.a r2 = Rq();
        if (r2 == null) goto L19;
        r2.a(r7, ((MultiLinkVoiceBaseAnchorLinkWidget) this).w);
        return;
    L19:
        return;
    L9:
        if (r0.getChorusGuestStatus() != ChorusGuestStatus.STATUS_UNKNOWN.getValue()) goto L13;
        fd2.s r4 = RealTimeChorusBusinessContext.Companion.c();
        if (r4 == null) goto L17;
        r4.Ch(r7.b(), ChorusGuestStatus.STATUS_NORMAL.getValue(), null);
        return;
    L17:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void kickOut(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUser");
        zf6.a r0 = Rq();
        if (r0 == null) goto L6;
        r0.d(r3, "anchor_stop_normal");
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (isViewValid() == false) goto L81;
        if (r7 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7.getKey()) == false) goto L8;
        return;
    L8:
        if (r7.getData() == null) goto L102;
        String r0 = r7.getKey();
        boolean r2 = false;
        if (Intrinsics.areEqual(r0, "cmd_open_interact_manage_dialog_by_anchor") == false) goto L30;
        if (jc1.k.n(IInteractService.class).isEnableTalkRoomEmoji() == false) goto L21;
        ILinkPlayerInfoBridge r8 = yq().p(je0.d.b0(), tc0.c.h().f);
        if (r8 == null) goto L20;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r8.getSilenceStatus() == 0) goto L19;
        r2 = true;
    L19:
        r1.put("data_self_is_silenced", Boolean.valueOf(r2));
    L20:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r9 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r9.b(((Widget) this).context);
        r9.c(((Widget) this).dataCenter);
        r9.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r9.d = "seat";
        r9.a().a();
        return;
    L21:
        Context r3 = ((Widget) this).context;
        VoiceChatMuteManager r4 = this.E;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L24:
        com.bytedance.android.live.liveinteract.voicechat.dialog.q r10 = new com.bytedance.android.live.liveinteract.voicechat.dialog.q(r3, r4);
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L83;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L83:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L82
    L28:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L30:
        if (Intrinsics.areEqual(r0, "cmd_audio_talk_invite") == false) goto L44;
        IBaseUser r11 = (IBaseUser) r7.getData();
        if (r11 != null) goto L34;
        r11 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L34:
        com.bytedance.android.live.liveinteract.videolink.a r5 = new com.bytedance.android.live.liveinteract.videolink.a(getMRoom(), r11, -1);
        if (this.h1 == null) goto L37;
        r5.e = 3;
    L37:
        this.h1 = null;
        invite(r5);
        if (r11 == null) goto L41;
        Object r12 = r11.getIdString();
        if (r12 == null) goto L41;
    L42:
        TalkRoomLogUtils.C("anchor", r12.toString(), "card", -1);
        return;
    L41:
        r12 = 0;
        goto L42
    L44:
        if (Intrinsics.areEqual(r0, "data_interact_anchor_param_change") == false) goto L53;
        hg6.g r13 = this.F;
        if (r13 == null) goto L91;
        String r14 = "";
        String r15 = (String) r7.getData("");
        if (r15 == null) goto L51;
        r14 = r15;
    L51:
        r13.Q(r14);
        return;
    L91:
        return;
    L53:
        if (Intrinsics.areEqual(r0, "data_room_audio_chat_anchor_uilayout_switch_time") == false) goto L61;
        Long r16 = (Long) r7.getData(0L);
        if (r16 != null) goto L57;
        r16 = 0L;
    L57:
        long r17 = r16.longValue();
        if (r17 <= this.K) goto L93;
        jy0.b.a("RealTimeChorusAnchorWidget", "update starttime : " + this.K + "->" + r17);
        this.K = r17;
        return;
    L93:
        return;
    L61:
        if (Intrinsics.areEqual(r0, "cmd_auto_join_channel") == false) goto L68;
        if (vm2.d.C() == false) goto L95;
        com.bytedance.live.bizlink.impl.platform.manager.a r18 = zq().A0();
        if (r18 == null) goto L96;
        r18.g();
        return;
    L96:
        return;
    L95:
        return;
    L68:
        if (Intrinsics.areEqual(r0, "cmd_video_talk_guest_battle_open_panel") == false) goto L73;
        sh0.g r19 = sh0.g.b;
        i0 r20 = this.C;
        if (r20 == null) goto L98;
        r20.d0(r19, null);
        return;
    L98:
        return;
    L73:
        if (Intrinsics.areEqual(r0, "cmd_operate_interact_media") == false) goto L100;
        MediaOperation r21 = (MediaOperation) r7.getData();
        if (r21 != null) goto L77;
        return;
    L77:
        if (r21.getType() != MediaOperation.Type.MIC) goto L103;
        int r22 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.e.a;
        throw null;
    L103:
        return;
    L100:
        return;
    L102:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void onSwitchSceneMessage(z0 r19) {
        if (r19 != null) goto L5;
        return;
    L5:
        jy0.b.d("RealTimeChorusAnchorWidget", "onSwitchSceneMessage: msgScene = " + r19.getScene() + ", msgUILayout = " + r19.getUiLayout() + ", msgId = " + r19.getMessageId2());
        SwitchSceneResponse r1 = new SwitchSceneResponse();
        r1.scene = r19.getValidScene();
        r1.playModes = r19.getPlayModes();
        r1.uiLayout = r19.getUiLayout();
        r1.linkedUsers = r19.getLinkedListUsers();
        r1.version = r19.getVersion();
        r1.multiLiveCoreInfo = r19.getMultiLiveCoreInfo();
        r1.multiRtcInfo = r19.getMultiRtcInfo();
        r1.liveCoreExtInfo = r19.getLiveCoreExtInfo();
        r1.rtcExtInfo = r19.getRtcExtInfo();
        r1.linkerContentMap = r19.getLinkerContentMap();
        com.bytedance.android.livesdk.chatroom.model.v r3 = r19.getChorusCDNInfo();
        if (r3 == null) goto L11;
        fd2.s r4 = RealTimeChorusBusinessContext.Companion.c();
        if (r4 == null) goto L11;
        r4.setChorusCDNInfo(r3);
    L11:
        if (vm2.d.v0() == false) goto L14;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r19);
    L14:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L16;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().yg((int) r19.getScene(), r19.getUiLayout(), r19.getPlayModes());
    L16:
        int r14 = r1.getScene();
        int r15 = r1.getUiLayout();
        u r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r5 == null) goto L25;
        com.bytedance.live.datacontext.j r6 = r5.s();
        if (r6 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L25;
        if (r7.f(r14, r15) != true) goto L25;
        jy0.b.d("RealTimeChorusAnchorWidget", "onSwitchSceneMessage already same layout, current scene = " + r14 + " layout = " + r15);
        return;
    L25:
        InteractAnimationController r2 = this.O;
        if (r2 == null) goto L28;
        r2.m();
    L28:
        y r8 = yq();
        List r9 = r1.getLinkedUsers();
        if (r8 == null) goto L32;
        if (r9 == null) goto L32;
        r8.Y4(r9, r1.getClientUiInfo(), r1.getVersion(), "switchSceneMsg", r1.getLinkerContentMap());
    L32:
        u1 r10 = r1.getMultiLiveCoreInfo();
        v1 r11 = r1.getMultiRtcInfo();
        String r12 = r1.getLiveCoreExtInfo();
        String r13 = r1.getRtcExtInfo();
        tc0.c r16 = tc0.c.h();
        r16.r = r10;
        r16.n = r11;
        r16.k = r13;
        r16.m = r12;
        if (jc0.a.b(r14, r15) == true) goto L37;
        RealTimeChorusMainViewWidget r17 = this.G;
        if (r17 == null) goto L37;
        r17.onBizDestory();
    L37:
        u r18 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r18 == null) goto L76;
        com.bytedance.live.datacontext.j r20 = r18.s();
        if (r20 == null) goto L76;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r21 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r20.getValue();
        if (r21 == null) goto L76;
        int r22 = r1.getUiLayout();
        List r23 = r1.getPlayModes();
        String r24 = r1.getRtcExtInfo();
        if (r24 != null) goto L46;
        String r25 = "";
    L47:
        String r26 = r1.getLiveCoreExtInfo();
        if (r26 != null) goto L50;
        String r110 = "";
    L51:
        com.bytedance.android.livesdk.chatroom.viewmodel.h r111 = new com.bytedance.android.livesdk.chatroom.viewmodel.h(r14, r22, r23, false, r25, r110, r1.getMultiLiveCoreInfo(), r1.getClientUiInfo());
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L55;
        r27.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodel.i) r111).b));
    L55:
        if (getRoomContext() == null) goto L74;
        ArrayList r28 = new ArrayList();
        com.bytedance.live.datacontext.j r29 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r29 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r30 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r29.getValue();
        if (r30 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r31 = r30.t();
    L63:
        if (r31 == null) goto L68;
        int r32 = r31.a;
        int r33 = r31.b;
        List r34 = r31.c;
        if (r34 == null) goto L67;
        r28.addAll(r34);
    L67:
        int r35 = r33;
        int r36 = r32;
    L69:
        com.bytedance.live.datacontext.j r37 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r37 == null) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r38 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r37.getValue();
        if (r38 == null) goto L74;
        r38.c(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r36, r35, r28, false, false, null, 32));
        goto L74
    L68:
        r36 = 0;
        r35 = 0;
    L62:
        r31 = null;
    L74:
        r21.d(r111);
        goto L76
    L50:
        r110 = r26;
        goto L51
    L46:
        r25 = r24;
    L76:
        u r39 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r39 == null) goto L90;
        com.bytedance.live.datacontext.m r40 = r39.I1();
        if (r40 != null) goto L81;
    L87:
        com.bytedance.live.datacontext.m r41 = r39.q();
        if (r41 == null) goto L90;
        r41.setValue(new nd.a(0, r1.getMaxMcNum()));
        goto L90
    L81:
        if (r14 == 9) goto L83;
    L85:
        boolean r42 = false;
    L86:
        r40.setValue(Boolean.valueOf(r42));
        goto L87
    L83:
        if (r15 == 61) goto L85;
        r42 = true;
    L90:
        com.bytedance.android.livesdk.chatroom.o r43 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r43 == null) goto L97;
        com.bytedance.live.datacontext.m r44 = r43.w2();
        if (r44 == null) goto L98;
        r44.setValue(Boolean.TRUE);
        return;
    L98:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void setInviteCallback(uf0.c r1) {
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).w = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void setPermitCallback(uf0.d r1) {
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).v = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.b
    public final ti6.j x(fi6.a r1) {
        return super.x(r1);
    }

    public final void G4(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (((MultiLinkVoiceBaseAnchorLinkWidget) this).z != null) goto L5;
    L26:
        String r8 = je0.d.b0();
        w0 r0 = this.J;
        if (r0 == null) goto L30;
        r0.f9(r8, r6);
        return;
    L30:
        return;
    L5:
        if (r6 == false) goto L17;
        jg6.a r2 = zq().e5();
        if (r2 == null) goto L22;
        kg6.e r3 = r2.b();
        if (r3 == null) goto L22;
        if (je0.d.G() == false) goto L13;
    L15:
        boolean r4 = false;
    L16:
        r3.t(new kg6.b(true, r4, r7, 8));
        goto L22
    L13:
        if (je0.d.p() == true) goto L15;
        r4 = true;
    L22:
        VoiceChatMuteManager r9 = this.E;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L25:
        r9.i = System.currentTimeMillis();
        goto L26
    L17:
        jg6.a r5 = zq().e5();
        if (r5 == null) goto L22;
        kg6.e r10 = r5.b();
        if (r10 == null) goto L22;
        r10.z(new kg6.d(true, true, r7, 8));
        goto L22
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void accept(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "idString");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        zf6.a r4 = Rq();
        if (r4 == null) goto L6;
        r4.b(r0, ((MultiLinkVoiceBaseAnchorLinkWidget) this).v);
        return;
    }

    public final <T> void br(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.RealTimeChorusAnchorPresenter.IView
    public final void e0(int r2, LinkMicGuideMessage.AnchorGuideInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "guideInfo");
        if (yq().b() < r2) goto L6;
        jy0.b.a("RealTimeChorusAnchorWidget", "intercept guide since online count hits limit");
        return;
    }

    public final void e1(String r1, long r2) {
        yq().getClass();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final void j2(int r12, LinkmicInfoWithRtcInfoData r13) {
        if (r13 == null) goto L13;
        hg6.g r0 = this.F;
        if (r0 == null) goto L13;
        fg6.b r1 = r0.F();
        if (r1 == null) goto L13;
        int r3 = Integer.valueOf(r13.uiLayout).intValue();
        List r4 = r13.playModes;
        AnchorLinkmicInfo r2 = r13.mainAnchorLinkmicInfo;
        if (r2 == null) goto L11;
        String r5 = r2.rtcExtInfo;
        if (r5 == null) goto L11;
    L12:
        r1.b(pg6.a.b(new com.bytedance.android.livesdk.chatroom.viewmodel.h(r12, r3, r4, true, r5, r13.liveCoreExtInfo, null, r13.clientUIInfo)));
    L11:
        r5 = "";
    L13:
        com.bytedance.live.bizlink.impl.platform.manager.a r14 = zq().A0();
        if (r14 == null) goto L17;
        r14.g();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void openEmojiDialog(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "toUserId");
        Intrinsics.checkNotNullParameter("dynamic", "requestPage");
        String r1 = null;
        if (isEngineOn() == true) goto L14;
        com.bytedance.android.livesdk.chatroom.o r9 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r9 == null) goto L14;
        com.bytedance.live.datacontext.m r10 = r9.getCleanMode();
        if (r10 == null) goto L14;
        if (((Number) r10.getValue()).intValue() != 2) goto L14;
        if (vm2.e.h() == false) goto L14;
        jy0.b.f("RealTimeChorusAnchorWidget", "rejected guest stub click for pure clean mode", null, 4);
        return;
    L14:
        BehaviorSubject r11 = md().f();
        if (r11 == null) goto L92;
        List r12 = (List) r11.getValue();
        if (r12 == null) goto L93;
        Iterator r13 = r12.iterator();
    L20:
        if (r13.hasNext() == false) goto L28;
        Object r2 = r13.next();
        IBaseUser r3 = ((ch0.e) r2).a.getUser();
        if (r3 == null) goto L24;
        String r4 = r3.getIdString();
    L26:
        if (Intrinsics.areEqual(r4, r7) == false) goto L20;
    L29:
        ch0.e r5 = (ch0.e) r2;
        if (r5 == null) goto L94;
        LinkPlayerInfo r14 = r5.a;
        if (r14 != null) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(r7, getMRoom().getOwnerUserIdString()) == false) goto L41;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L39;
        r15.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
    L39:
        Zq(r14);
        return;
    L41:
        Zq(r14);
        IBaseUser r16 = r14.getUser();
        if (r16 == null) goto L45;
        r1 = r16.getIdString();
    L45:
        if (Intrinsics.areEqual(r1, com.bytedance.android.live.liveinteract.linkpanel.util.o.J()) == false) goto L64;
        IInteractService r17 = jc1.k.f(IInteractService.class);
        Intrinsics.checkNotNull(r17);
        if (r17.isEnableTalkRoomEmoji() == false) goto L64;
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L56;
        if (r14.getSilenceStatus() == 0) goto L53;
        boolean r6 = true;
    L54:
        r18.put("data_self_is_silenced", Boolean.valueOf(r6));
        goto L56
    L53:
        r6 = false;
    L56:
        if (hd0.c.f().h() == false) goto L60;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r19 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r19.b(((Widget) this).context);
        r19.c(((Widget) this).dataCenter);
        r19.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r19.d = "seat";
        q0 r20 = r19.a();
        this.P0 = r20;
        r20.a();
        return;
    L60:
        if (hd0.c.f().g() == false) goto L64;
        xs2.b.a().post(new UserProfileEvent(r14.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
        return;
    L64:
        if (je0.d.c0() == false) goto L80;
        ih0.d r21 = this.L0;
        if ((r21 instanceof KtvRoomInteractEmojiPanel) == false) goto L71;
        if (r21 == null) goto L71;
        if (r21.p() != true) goto L71;
        return;
    L71:
        Context r22 = ((Widget) this).context;
        DataCenter r23 = ((Widget) this).dataCenter;
        LinkPlayerInfo r24 = r14;
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "dataCenter");
        Intrinsics.checkNotNullParameter(r24, "userInfo");
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        if (hg6.i.a() == false) goto L74;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r25 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r24, "seat", false);
    L78:
        this.L0 = r25;
        r25.a();
        return;
    L74:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r26 = new KtvRoomInteractEmojiPanel(r22, r23, r24);
        Intrinsics.checkNotNullParameter("seat", "<set-?>");
        ((InteractEmojiPanel) r26).k = "seat";
        ((InteractEmojiPanel) r26).r = false;
        tb6.c r27 = ((InteractEmojiPanel) r26).x;
        if (r27 == null) goto L77;
        r27.a();
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r27.d = "seat";
    L77:
        r25 = r26;
        goto L78
    L80:
        hd0.c.f().h();
        jc1.k.n(IMiddlewareUserService.class).user().c();
        com.bytedance.android.live.liveinteract.voicechat.dialog.p r28 = new com.bytedance.android.live.liveinteract.voicechat.dialog.p(((Widget) this).context, ((Widget) this).dataCenter, r14, true);
        r28.G = "seat";
        this.H0 = r28;
        if (DialogLancet.shouldBlockDialogShow(r28) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r28);
        return;
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
    L84:
        DialogLancet.beforeDialogShow(r28);
        r28.show();
        DialogLancet.afterDialogShow(r28);
        return;
    L94:
        return;
    L24:
        r4 = null;
        goto L26
    L28:
        r2 = null;
        goto L29
    L93:
        return;
    }

    public final int q0(List<ti6.f> r11, Map<String, Integer> r12) {
        List<ti6.f> r13 = r11;
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        return 0;
    L11:
        String r15 = tc0.c.h().f;
        String r2 = je0.d.g();
        String r3 = N4(r2);
        Iterator<ti6.f> r16 = r11.iterator();
    L13:
        if (r16.hasNext() == false) goto L28;
        ti6.f r4 = r16.next();
        r4.t = false;
        if (TextUtils.isEmpty(r3) == true) goto L13;
        if (TextUtils.equals(r3, r4.b) == true) goto L18;
        r4.a = 2;
        r4.f = 0.1d;
        r4.g = 0.1d;
        String r5 = r4.b;
        y r8 = yq();
        if ((r8 instanceof y) == true) goto L22;
        r8 = null;
    L22:
        if (r8 == null) goto L24;
        String r6 = r8.r(r5);
    L25:
        r4.c(r6);
        r4.d = 1.0d;
        r4.e = 1.0d;
        if (TextUtils.equals(r15, r4.b) == false) goto L13;
        r4.a = 1;
        goto L13
    L24:
        r6 = "";
        goto L25
    L18:
        r4.a = 1;
        r4.f = 1.0d;
        r4.g = 1.0d;
        r4.c(r2);
        r4.d = 0.0d;
        r4.e = 0.0d;
        r4.i = 0;
        goto L13
    L28:
        return 0;
    L5:
        if (r13.isEmpty() == true) goto L8;
        r14 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c
    public final void zg(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "streamUrl");
        hg6.g r0 = R1();
        if (r0 == null) goto L9;
        ei6.a r1 = r0.V0();
        if (r1 == null) goto L9;
        fi6.a r2 = r1.g();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.w.a("RealTimeChorusAnchorWidget", "startPushChorusCDNStream updateConfig " + r2);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.a r3 = this.V0;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        r3.a = r2;
    L9:
        TaskMixerConfig r6 = new TaskMixerConfig();
        r6.a(MixStreamType.SERVER_MIX);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r6.c = r4;
        r6.g = r5;
        fd2.s r7 = RealTimeChorusBusinessContext.Companion.c();
        if (r7 == null) goto L13;
        String r8 = r7.Mm();
        if (r8 == null) goto L13;
    L14:
        r6.i = r8;
        hg6.g r9 = this.F;
        String r10 = null;
        if (r9 == null) goto L21;
        ei6.a r11 = r9.V0();
        if (r11 == null) goto L21;
        fi6.a r12 = r11.g();
        if (r12 == null) goto L21;
        ti6.h r13 = r12.T;
    L22:
        r6.f = r13;
        r6.j = new RealTimeChorusAnchorWidget$startPushChorusCDNStream$2(this);
        r6.b(TaskMixerConfig.TaskType.EXTRA);
        hg6.g r14 = this.F;
        if (r14 == null) goto L29;
        ei6.a r15 = r14.V0();
        if (r15 == null) goto L29;
        si6.b r16 = r15.b();
        if (r16 == null) goto L29;
        r10 = r16.m();
    L29:
        String r17 = String.valueOf(r10);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r6.d = r17;
        hg6.g r18 = this.F;
        if (r18 == null) goto L36;
        ei6.a r19 = r18.V0();
        if (r19 == null) goto L36;
        ti6.d r20 = r19.p();
        if (r20 == null) goto L36;
        r20.l(r6);
    L36:
        hg6.g r21 = this.F;
        if (r21 == null) goto L44;
        ei6.a r22 = r21.V0();
        if (r22 == null) goto L45;
        ti6.d r23 = r22.p();
        if (r23 == null) goto L46;
        r23.d(r4, "RealTimeChorusAnchorWidget startPushChorusCDNStream");
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L21:
        r13 = null;
    L13:
        r8 = "";
        goto L14
    }

    public RealTimeChorusAnchorWidget(com.bytedance.android.live.pushstream.d r2, w0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        super(r2, tc0.c.h());
        this.k1 = r2;
        this.p1 = r4;
        this.A = "";
        this.H = LazyKt.lazy(new RealTimeChorusAnchorWidget$roomDataEntity$2(this));
        this.P = new ToolbarInteractKtvRoomBehavior();
        new HashMap(9);
        new HashMap();
        this.Y = true;
        this.Z = new s();
        this.k0 = new ArrayList();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.a r5 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.a();
        Intrinsics.checkNotNullParameter(this, "querier");
        r5.b = this;
        Unit r6 = Unit.INSTANCE;
        this.V0 = r5;
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).u = new com.bytedance.android.live.liveinteract.api.utils.p(((MultiLinkVoiceBaseAnchorLinkWidget) this).z);
        this.J = r3;
        this.b1 = new b(this);
        this.g1 = new r(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b
    public final void switchAudioByClient(boolean r9, List<com.bytedance.android.livesdk.link.model.bridge.k> r10, ClientUIInfo r11, long r12, Map<Long, ? extends RoomLinkerContent> r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r15, "reason");
        G4(r9, r15);
        VoiceChatMuteManager r16 = this.E;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        r16.t(r9);
        y r1 = yq();
        if (r9 == false) goto L8;
        String r13 = "silence";
    L9:
        r1.Y4(r10, r11, r12, r13, r14);
        return;
    L8:
        r13 = "unsilence";
        goto L9
    }
}
