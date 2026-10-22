package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVoiceWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionWidget;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.dialog.InteractSceneViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessWidget;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarRoomBattleBehavior;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.interact.KTVLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.SwitchSceneResponse;
import com.bytedance.android.livesdk.chatroom.model.j2;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.ToolbarInteractKtvRoomBehavior;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomAnchorPresenter;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.service.KtvAnchorDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.service.KtvRoomGlobalDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.message.linker.AnchorLinkmicInfo;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkmicMediaParam;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.model.LinkAudioInviteGuideConfig;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvRoomAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceBaseAnchorLinkWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/presenter/KtvRoomAnchorPresenter$IView;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/service/b;", "Lcom/bytedance/android/live/liveinteract/voicechat/a;", "Lkk0/f;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/service/c;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomAnchorWidget extends MultiLinkVoiceBaseAnchorLinkWidget implements KtvRoomAnchorPresenter.IView, WeakHandler.IHandler, Observer<KVData>, com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b, com.bytedance.android.live.liveinteract.voicechat.a, kk0.f, com.bytedance.android.livesdk.ktvimpl.ktvroom.service.c {
    public static final /* synthetic */ int x1 = 0;
    public sh0.i0 A;
    public KtvRoomAnchorPresenter B;
    public VoiceChatMuteManager C;
    public hg6.g D;
    public KtvRoomContainerWidget E;
    public int F;
    public final Lazy G;
    public WeakHandler H;
    public RTSVoiceWidget H0;
    public final hh1.w0 I;
    public long J;
    public int K;
    public int L;
    public final com.bytedance.android.live.liveinteract.plantform.utils.s L0;
    public boolean M;
    public boolean N;
    public InteractAnimationController O;
    public final ToolbarInteractKtvRoomBehavior P;
    public final ArrayList<ILinkPlayerInfoBridge> P0;
    public com.bytedance.android.live.liveinteract.voicechat.util.k Q;
    public MuteStateChecker R;
    public int S;
    public Disposable T;
    public final Map<String, Integer> U;
    public final Map<String, Integer> V;
    public final InteractSceneViewModel V0;
    public InteractLiveCorePermissionGuarantor W;
    public ChatMatchWidget X;
    public ThemedCompetitionWidget Y;
    public QuickInteractWidget Z;
    public final b b1;
    public final p g1;
    public String h1;
    public LinkmicSubtitleBusinessWidget k0;
    public boolean k1;
    public final boolean p0;
    public final com.bytedance.android.live.pushstream.d p1;
    public final boolean v1;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public b(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            this.a.P0.clear();
            List<? extends ILinkPlayerInfoBridge> r1 = r4;
            this.a.P0.addAll(r1);
            ArrayList r0 = new ArrayList(r1);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            bn0.b r2 = this.a.getMultiLinkRoomScope();
            if (r2 == null) goto L9;
            jn0.b r3 = jn0.c.a(r2);
            if (r3 == null) goto L9;
            BehaviorSubject r5 = r3.Xh();
            if (r5 == null) goto L9;
            r5.onNext(r0);
        L9:
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r4.size());
            if (r4.size() <= tc0.c.h().d) goto L13;
            tc0.c r6 = tc0.c.h();
            r6.d = r4.size();
            return;
        }

        public final void n(List<ILinkPlayerInfoBridge> r2, long r3, com.bytedance.android.live.liveinteract.plantform.model.n0 r5) {
            String r4 = "";
            if (Lists.isEmpty(r2) == false) goto L5;
            ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", "");
            return;
        L5:
            KtvRoomAnchorWidget r6 = this.a;
            int r7 = KtvRoomAnchorWidget.x1;
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
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public c(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            KtvRoomAnchorWidget r0 = this.a;
            boolean r10 = ((Boolean) r9).booleanValue();
            int r1 = KtvRoomAnchorWidget.x1;
            r0.getClass();
            StringBuilder r2 = new StringBuilder("onIsSingerChanged ");
            r2.append(r10);
            r2.append(" mute=");
            VoiceChatMuteManager r3 = r0.C;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L5:
            r2.append(r3.isMute());
            r2.append(" shouldRestore=");
            r2.append(((MultiLinkVoiceBaseAnchorLinkWidget) r0).x);
            r2.append(" isResumed=");
            r2.append(r0.N);
            r2.append("， isAnchorMute= ");
            boolean r5 = true;
            if (r0.Qq() != 0) goto L8;
        L10:
            boolean r4 = false;
        L11:
            r2.append(r4);
            ALogger.i("KtvRoomAnchorWidget", r2.toString());
            if (r10 == false) goto L55;
            IKtvService r6 = jc1.k.f(IKtvService.class);
            if (r6 == null) goto L16;
            boolean r7 = r6.isInKtvState(8);
            boolean r8 = r6.isAudienceSingEnableSwitchOn();
        L17:
            if (r7 == false) goto L38;
            VoiceChatMuteManager r11 = r0.C;
            if (r11 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L22:
            if (r11.isMute() == true) goto L31;
            if (r0.Qq() != 0) goto L26;
        L28:
            boolean r12 = false;
        L29:
            if (r12 == true) goto L31;
        L36:
            r5 = false;
        L37:
            ((MultiLinkVoiceBaseAnchorLinkWidget) r0).x = r5;
        L67:
            if (com.bytedance.android.live.liveinteract.spatial.a.e(9) == false) goto L73;
            ALogger.d("SpatialAudio_KtvRoomAnchorWidget", "onKtvSingerStateChanged updateSpatialAudioPosition------");
            KtvRoomContainerWidget r13 = r0.E;
            if (r13 == null) goto L73;
            qe2.a r14 = r13.e;
            if (r14 == null) goto L73;
            r14.b();
        L73:
            hg6.g r15 = r0.D;
            if (r15 == null) goto L77;
            r15.f();
        L77:
            if (vm2.d.k0() == false) goto L85;
            if (r10 == false) goto L80;
            int r16 = 4;
        L81:
            hg6.g r17 = r0.D;
            if (r17 == null) goto L86;
            r17.X(r16, "currentUserSingerChanged");
            return;
        L86:
            return;
        L80:
            r16 = 3;
            goto L81
        L85:
            return;
        L26:
            if (r0.Qq() == (-1)) goto L28;
            r12 = true;
        L31:
            if (r0.N == false) goto L36;
            VoiceChatMuteManager r18 = r0.C;
            if (r18 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L35:
            com.bytedance.android.live.liveinteract.voicechat.b.a.a(r18, "force UnSilence", true, null, 8);
            goto L37
        L38:
            VoiceChatMuteManager r19 = r0.C;
            if (r19 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L42:
            if (r19.isMute() == false) goto L48;
            if (r0.N == false) goto L48;
            if (r8 == false) goto L48;
            f2.b(2131918609, 0);
        L48:
            if (r0.p0 == true) goto L67;
            jg6.a r20 = r0.Bq();
            if (r20 == null) goto L67;
            kg6.e r21 = r20.b();
            if (r21 == null) goto L67;
            r21.u(false, "");
            goto L67
        L16:
            r8 = false;
            r7 = false;
            goto L17
        L55:
            if (((MultiLinkVoiceBaseAnchorLinkWidget) r0).x == false) goto L63;
            VoiceChatMuteManager r22 = r0.C;
            if (r22 != null) goto L59;
            Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
        L59:
            r22.s();
            if (r0.N == true) goto L62;
            ((Widget) r0).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
        L62:
            ((MultiLinkVoiceBaseAnchorLinkWidget) r0).x = false;
        L63:
            hg6.g r23 = r0.D;
            if (r23 == null) goto L67;
            r23.e0("songEnd");
            goto L67
        L8:
            if (r0.Qq() == (-1)) goto L10;
            r4 = true;
            goto L11
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public d(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Intrinsics.checkNotNullParameter((fd2.z) r3, "event");
            KtvRoomAnchorWidget r4 = this.a;
            int r0 = KtvRoomAnchorWidget.x1;
            r4.getClass();
            if (com.bytedance.android.live.liveinteract.spatial.a.e(9) == false) goto L9;
            ALogger.d("SpatialAudio_KtvRoomAnchorWidget", "singerChanged updateSpatialAudioPosition------");
            KtvRoomContainerWidget r1 = r4.E;
            if (r1 == null) goto L9;
            qe2.a r2 = r1.e;
            if (r2 == null) goto L9;
            r2.b();
        L9:
            hg6.g r5 = r4.D;
            if (r5 == null) goto L13;
            r5.f();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public e(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            KtvRoomAnchorWidget r0 = this.a;
            int r1 = KtvRoomAnchorWidget.x1;
            r0.Zq(r4);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public f(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            hg6.g r0 = this.a.D;
            Intrinsics.checkNotNull(r0);
            Intrinsics.checkNotNull(r3);
            r0.w(r3.booleanValue());
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r7) {
            List r8 = ((com.bytedance.android.livesdk.chatroom.model.h1) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r7)).data).getSettings();
            if (r8 == null) goto L29;
            int r0 = r8.size();
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L39;
            if (ListProtector.get(r8, r2) == null) goto L28;
            Object r3 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r3);
            if (((ILinkmicAudienceSetting) r3).getKey() == null) goto L28;
            Object r4 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r4);
            Integer r5 = ((ILinkmicAudienceSetting) r4).getKey();
            int r6 = LinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_MIC_DRESS_BUTTON.getValue();
            if (r5 == null) goto L28;
            if (r5.intValue() != r6) goto L28;
            Object r9 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r9);
            if (((ILinkmicAudienceSetting) r9).getValue() == null) goto L28;
            Gson r10 = GsonHelper.get();
            Object r11 = ListProtector.get(r8, r2);
            Intrinsics.checkNotNull(r11);
            com.bytedance.android.livesdk.chatroom.model.i1 r12 = ((ILinkmicAudienceSetting) r11).getValue();
            Intrinsics.checkNotNull(r12);
            j2 r13 = (j2) GsonProtectorUtils.fromJson(r10, r12.getExtra(), j2.class);
            if (r13 == null) goto L28;
            List r14 = r13.b;
            if (r14 != null) goto L22;
        L24:
            if (r14 != null) goto L26;
        L27:
            com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.c.N0;
            r15.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r15, 0);
            goto L28
        L26:
            if (r14.isEmpty() == false) goto L28;
        L22:
            if (r14.isEmpty() == true) goto L24;
            com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.c.N0;
            Integer r17 = r13.a;
            r16.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r16, r17);
            com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.c.P0;
            r18.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r18, r14);
        L28:
            r2 = r2 + 1;
            goto L5
        L39:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public i(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = ((com.bytedance.android.livesdk.chatroom.model.d1) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r3)).data).getEntranceList();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.isEmpty() == true) goto L11;
            KtvRoomAnchorWidget r0 = this.a;
            int r1 = KtvRoomAnchorWidget.x1;
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
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public k(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((zg1.h1) r2, "event");
            KtvRoomAnchorWidget r3 = this.a;
            int r0 = KtvRoomAnchorWidget.x1;
            r3.getClass();
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public l(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            zg1.i1 r3 = (zg1.i1) r2;
            Intrinsics.checkNotNullParameter(r3, "event");
            KtvRoomContainerWidget r0 = this.a.E;
            if (r0 == null) goto L8;
            boolean r4 = r3.b;
            qe2.a r1 = r0.e;
            if (r1 == null) goto L9;
            r1.d(r4);
            return;
        L9:
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public m(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            o42.g r4 = (o42.g) r3;
            KtvRoomAnchorWidget r0 = this.a;
            int r1 = KtvRoomAnchorWidget.x1;
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

    public static final class n<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public n(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((o42.l) r2, "event");
            KtvRoomAnchorWidget r3 = this.a;
            int r0 = KtvRoomAnchorWidget.x1;
            r3.getClass();
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public o(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            KtvRoomAnchorWidget r4 = this.a;
            if (((Widget) r4).isViewValid == false) goto L10;
            Disposable r5 = r4.T;
            Intrinsics.checkNotNull(r5);
            if (r5.isDisposed() == true) goto L11;
            KtvRoomAnchorWidget r6 = this.a;
            if (r6.Q == null) goto L12;
            com.bytedance.android.live.liveinteract.voicechat.util.k.z(r6.yq().b());
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomAnchorWidget$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02551 extends MutablePropertyReference0Impl {
        public C02551(KtvRoomAnchorWidget r7) {
            super(r7, KtvRoomAnchorWidget.class, "mPresenter", "getMPresenter()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/presenter/KtvRoomAnchorPresenter;", 0);
        }

        public Object get() {
            KtvRoomAnchorPresenter r0 = ((KtvRoomAnchorWidget) ((CallableReference) this).receiver).B;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        L5:
            return r0;
        }

        public void set(Object r2) {
            KtvRoomAnchorPresenter r3 = (KtvRoomAnchorPresenter) r2;
            ((KtvRoomAnchorWidget) ((CallableReference) this).receiver).B = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomAnchorWidget$onDestroy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02562 extends MutablePropertyReference0Impl {
        public C02562(KtvRoomAnchorWidget r7) {
            super(r7, KtvRoomAnchorWidget.class, "mMuteManager", "getMMuteManager()Lcom/bytedance/android/live/liveinteract/voicechat/VoiceChatMuteManager;", 0);
        }

        public Object get() {
            return KtvRoomAnchorWidget.Pq((KtvRoomAnchorWidget) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            VoiceChatMuteManager r3 = (VoiceChatMuteManager) r2;
            ((KtvRoomAnchorWidget) ((CallableReference) this).receiver).C = r3;
        }
    }

    public static final class p implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ KtvRoomAnchorWidget a;

        public final void b(boolean r1) {
        }

        public p(KtvRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L7;
            this.a.G4(true, "on particular page show");
            if (KtvRoomAnchorWidget.Pq(this.a).o() != 0) goto L11;
            this.a.yq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
            KtvRoomAnchorWidget.Pq(this.a).k("onPause");
            return;
        L11:
            return;
        L7:
            KtvRoomAnchorWidget r5 = this.a;
            int r1 = KtvRoomAnchorWidget.x1;
            if (r5.Qq() != 3) goto L13;
            KtvRoomAnchorWidget.Pq(this.a).l("on particular page close");
            return;
        }
    }

    public static final class q<T, R> implements Function {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.g(r0, r4));
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;

        public r(KtvRoomAnchorWidget r1, int r2, int r3, String r4, long r5, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
        }

        public final void accept(Object r13) {
            com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
            this.a.k1 = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r1 = this.b;
            int r2 = this.c;
            long r4 = this.d;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.z0(r1, r2, 0, r4, r14);
            HashMap r3 = new HashMap();
            com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).s();
            if (r5 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.getValue();
            if (r6 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r7 = r6.t();
            if (r7 == null) goto L9;
            int r8 = r7.b;
        L10:
            int r9 = this.b;
            if (r9 == 5) goto L17;
            if (r9 != 9) goto L18;
            if (r8 != 61) goto L16;
            r3.put("before_function", "chorus");
            goto L18
        L16:
            r3.put("before_function", "sing_room");
        L18:
            int r10 = this.c;
            if (r10 == 5) goto L28;
            if (r10 != 9) goto L32;
            if (this.e != 61) goto L25;
            f2.b(2131919219, 0);
            r3.put("interact_function", "chorus");
        L26:
            com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_ktv_open_success", MapsKt.emptyMap(), new Object[]{IRoom.class, am2.x.class});
            goto L32
        L25:
            f2.b(2131919220, 0);
            r3.put("interact_function", "sing_room");
        L32:
            if (r2.a(TalkRoomLogUtils.e) == false) goto L34;
            String r11 = TalkRoomLogUtils.e;
            Intrinsics.checkNotNull(r11);
            r3.put("request_page", r11);
        L35:
            com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_switch_room_type", r3, new Object[]{IRoom.class, am2.x.class});
            TalkRoomLogUtils.e = null;
            if (vm2.d.v0() == false) goto L38;
            String r12 = TalkRoomLogUtils.g();
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            TalkRoomLogUtils.j = r12;
            com.bytedance.android.live.liveinteract.plantform.utils.i.e((com.bytedance.android.livesdk.chatroom.model.interact.v1) ((ExtraResponse) r14).data, ((ExtraResponse) r14).logId);
        L38:
            this.a.Yi((com.bytedance.android.livesdk.chatroom.model.interact.v1) ((ExtraResponse) r14).data, "switchSceneApi", "switch_scene response");
            TalkRoomLogUtils.V(((com.bytedance.android.livesdk.chatroom.model.interact.v1) ((ExtraResponse) r14).data).getTotalApply(), ((com.bytedance.android.livesdk.chatroom.model.interact.v1) ((ExtraResponse) r14).data).getTotalLinked(), this.b);
            return;
        L34:
            r3.put("request_page", "link_icon");
            goto L35
        L28:
            if (this.b == r10) goto L30;
            f2.b(2131919218, 0);
        L30:
            r3.put("interact_function", "chat_room");
            goto L32
        L17:
            r3.put("before_function", "chat_room");
        L9:
            r8 = 0;
            goto L10
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ KtvRoomAnchorWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public s(KtvRoomAnchorWidget r1, int r2, int r3, String r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            this.a.k1 = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r1 = this.b;
            int r2 = this.c;
            String r4 = this.d;
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            long r5 = this.e;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.y0(r1, r2, 0, r4, r5, r9);
            ExceptionUtils.handleException(((Widget) this.a).context, r9);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final kk0.f Bb() {
        return this;
    }

    public final int C0() {
        return 9;
    }

    public final tf0.o Mq() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final boolean canSilenceSelf() {
        return true;
    }

    public final void f1(long r1, long r3) {
    }

    public final int getLayoutId() {
        return 0;
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
        hg6.g r0 = this.D;
        if (r0 == null) goto L6;
        r0.onPause();
    L6:
        if (vm2.e.a() == false) goto L8;
        Rq().f();
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
        VoiceChatMuteManager r1 = this.C;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L18:
        if (r1.o() != 0) goto L24;
        yq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        VoiceChatMuteManager r2 = this.C;
        if (r2 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L22:
        r2.k("onPause");
    L24:
        if (Jq() == null) goto L29;
        hh1.u0 r3 = Jq();
        if (r3 == null) goto L29;
        r3.pause();
        goto L29
    L28:
        com.bytedance.android.live.liveinteract.plantform.utils.x.J();
        goto L29
    }

    public final boolean O5() {
        hg6.g r0 = this.D;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.A() != true) goto L7;
        return true;
    }

    public final InteractLiveCorePermissionGuarantor Rq() {
        if (this.W != null) goto L7;
        this.W = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.W;
        if (r0 == null) goto L7;
        r0.j(this.g1);
    L7:
        InteractLiveCorePermissionGuarantor r1 = this.W;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    public final void Yq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_talk_room_admin_allowed_flag", r1)).booleanValue() == false) goto L6;
        TalkRoomLogUtils.q1("live_chat", ((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        ((Widget) this).dataCenter.put("data_talk_room_admin_allowed_flag", r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b
    public final void finishAudioTalk() {
        if (this.Q == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.util.k.n(this.K, "link_icon");
    L5:
        ((Widget) this).dataCenter.put("data_audio_talk_dot_with_number_show", "");
        ag6.a r0 = Wq();
        if (r0 == null) goto L8;
        r0.i(new wf6.c("stop_normally"));
    L8:
        Yq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final List<com.bytedance.android.live.liveinteract.plantform.model.s0> getHeadPointList() {
        KtvRoomContainerWidget r0 = this.E;
        if (r0 == null) goto L8;
        qe2.a r1 = r0.e;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getHeadPointList();
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final boolean isEngineOn() {
        hg6.g r0 = this.D;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.A() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final MuteStateChecker muteChecker() {
        MuteStateChecker r0 = this.R;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final com.bytedance.android.live.liveinteract.voicechat.b muteManager() {
        VoiceChatMuteManager r0 = this.C;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final hg6.g rtcManger() {
        hg6.g r0 = this.D;
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
        return r0.h();
    }

    public final int Qq() {
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = yq();
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

    public final boolean Tq() {
        if (getMRoom().getLinkInitResult() != null) goto L5;
    L11:
        return false;
    L5:
        if (getMRoom().getLinkMicScene() == 5) goto L10;
        IRoom r0 = getMRoom();
        if (r0 == null) goto L11;
        if (r0.getLinkMicScene() != 9) goto L11;
    L10:
        return true;
    }

    public final ag6.a Wq() {
        rf6.a r0 = wq();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final jg6.a getAdminStatusCenter() {
        return Bq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return yq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final List<ILinkPlayerInfoBridge> getOnlineUserList() {
        return yq().c;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b
    public final int getSelfSilenceType() {
        if (isEngineOn() == true) goto L7;
        return 0;
    L7:
        return Qq();
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
        this.D = zq().getRtcManager();
        this.L0.c();
        sh0.i0 r1 = sh0.j0.a;
        this.A = sh0.j0.c(((Widget) this).dataCenter, this);
        tc0.c.h().B = 9;
        this.O = new InteractAnimationController(((Widget) this).dataCenter);
        InteractAnimationContext r2 = (InteractAnimationContext) com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE).component1();
        r2.getController().d(this.O);
        com.bytedance.live.datacontext.b.a(r2, InteractAnimationContext.class);
        Pair r3 = com.bytedance.live.datacontext.d.a(AnonymousClass2.INSTANCE);
        KtvAnchorDataContext r4 = (KtvAnchorDataContext) r3.component1();
        Disposable r5 = (Disposable) r3.component2();
        r4.getService().d(this);
        com.bytedance.live.datacontext.b.a(r4, "ktv_room_anchor_context");
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r5);
        Pair r6 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        KtvRoomGlobalDataContext r7 = (KtvRoomGlobalDataContext) r6.component1();
        Disposable r8 = (Disposable) r6.component2();
        r7.getKtvAdminService().d(this);
        com.bytedance.live.datacontext.b.a(r7, "voice_chat_admin_context");
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r8);
        long r9 = SystemClock.elapsedRealtime();
        this.J = r9;
        ((Widget) this).dataCenter.put("data_room_audio_chat_anchor_uilayout_start_time", Long.valueOf(r9));
        yq().i();
        r7.getUserInfoCenter().d(yq());
        enableSubWidgetManager();
        r7.getSubWidgetManager().d(((Widget) this).subWidgetManager);
        if (this.Y != null) goto L10;
        enableSubWidgetManager();
        ThemedCompetitionWidget r10 = new ThemedCompetitionWidget();
        this.Y = r10;
        ((Widget) this).subWidgetManager.load(r10);
    L10:
        com.bytedance.android.live.pushstream.d r11 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).z;
        WidgetManager r12 = ((Widget) this).subWidgetManager;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r13 = md();
        KtvContext.Companion.getClass();
        KtvRoomContainerWidget r14 = new KtvRoomContainerWidget(r11, r12, r13, KtvContext.a.g(), this.I, yq(), this.O, this);
        this.E = r14;
        oe2.h r15 = (oe2.h) this.G.getValue();
        if (r15 == null) goto L14;
        r14.Rq(r15);
    L14:
        if (jm2.a.d(getMRoom()) == null) goto L194;
        this.B = new KtvRoomAnchorPresenter(com.bytedance.android.live.liveinteract.api.utils.m.e(this), zq());
        this.H = new WeakHandler(this);
        this.Q = new com.bytedance.android.live.liveinteract.voicechat.util.k(((Widget) this).dataCenter, com.bytedance.android.live.liveinteract.api.utils.m.j(this));
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r16 = MultiRevenueDataContext.a.d();
        if (r16 == null) goto L28;
        if (vm2.h.U().a() == true) goto L24;
        if (vm2.h.U().f() == true) goto L24;
        if (hg6.i.c() == false) goto L28;
    L24:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == true) goto L26;
        r16.o(((Widget) this).dataCenter, this, SceneType.SCENE_KTV, ((Widget) this).containerView);
    L26:
        r16.d(((Widget) this).dataCenter);
    L28:
        if (this.Z != null) goto L30;
        enableSubWidgetManager();
        QuickInteractWidget r17 = new QuickInteractWidget();
        this.Z = r17;
        ((Widget) this).subWidgetManager.load(r17);
    L30:
        uf2.d0 r18 = null;
        if (this.H0 != null) goto L34;
        enableSubWidgetManager();
        RTSVoiceWidget r19 = new RTSVoiceWidget(this.D, yq(), null, 12);
        this.H0 = r19;
        ((Widget) this).subWidgetManager.load(r19);
    L34:
        if (this.k0 != null) goto L46;
        enableSubWidgetManager();
        this.k0 = new LinkmicSubtitleBusinessWidget();
        vb6.g r20 = Iq();
        if (r20 == null) goto L42;
        yb6.e r21 = r20.j();
        if (r21 == null) goto L42;
        LinkmicSubtitleBusinessWidget r22 = this.k0;
        if (r22 == null) goto L42;
        Intrinsics.checkNotNullParameter(r21, "mediaManager");
        r22.c = r21;
    L42:
        LinkmicSubtitleBusinessWidget r23 = this.k0;
        if (r23 == null) goto L45;
        com.bytedance.android.live.pushstream.d r24 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).z;
        Intrinsics.checkNotNullParameter(r24, "liveStream");
        r23.d = r24;
    L45:
        ((Widget) this).subWidgetManager.load(this.k0);
    L46:
        VoiceChatMuteManager r25 = new VoiceChatMuteManager(getMRoom(), true, yq(), ((Widget) this).dataCenter, this, this, this);
        this.C = r25;
        r25.j();
        DataCenter r26 = ((Widget) this).dataCenter;
        com.bytedance.android.live.liveinteract.plantform.core.y r27 = yq();
        VoiceChatMuteManager r28 = this.C;
        if (r28 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L49:
        this.R = new MuteStateChecker(r26, r27, r28);
        KtvRoomAnchorPresenter r29 = this.B;
        if (r29 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L52:
        r29.g0(this);
        y3.m(((Widget) this).dataCenter).k(ToolbarButton.INTERACTION_ROOM, this.P);
        this.P.b(0);
        if (vm2.e.a() == true) goto L55;
    L61:
        com.bytedance.android.livesdk.chatroom.u r30 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.j r31 = r30.s();
        if (r31 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r31.getValue();
        if (r32 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r33 = r32.t();
        if (r33 == null) goto L72;
        hg6.g r34 = R1();
        if (r34 == null) goto L72;
        fg6.b r35 = r34.F();
        if (r35 == null) goto L72;
        r35.b(pg6.a.b(r33));
    L72:
        com.bytedance.live.datacontext.j r36 = r30.s();
        if (r36 == null) goto L75;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r37 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r36.getValue();
    L76:
        if (r37 == null) goto L91;
        com.bytedance.live.datacontext.j r38 = r30.s();
        if (r38 == null) goto L80;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r39 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r38.getValue();
    L81:
        Intrinsics.checkNotNull(r39);
        if (r39.t().a == 9) goto L88;
        if (Tq() == true) goto L86;
        f2.b(2131919222, 0);
        goto L91
    L86:
        br("radio");
        goto L91
    L88:
        if (Tq() == true) goto L90;
        f2.b(2131919328, 0);
        goto L91
    L90:
        br("ktv");
        f2.b(2131919328, 0);
        goto L91
    L80:
        r39 = null;
    L91:
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_audio_talk_invite", this);
        ((Widget) this).dataCenter.observe("data_member_count", this);
        ((Widget) this).dataCenter.observeForever("data_interact_anchor_param_change", this);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_anchor_uilayout_switch_time", this);
        ((Widget) this).dataCenter.observe("cmd_auto_join_channel", this);
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        yq().Q4(this.b1);
        ar(zg1.h1.class, new k(this));
        ar(zg1.i1.class, new l(this));
        ar(o42.g.class, new m(this));
        ar(o42.l.class, new n(this));
        com.bytedance.android.live.core.utils.rxutils.j.a r40 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.T = com.bytedance.android.live.core.utils.rxutils.j.a(1, 1, TimeUnit.MINUTES).subscribe(new o(this));
        boolean r41 = true;
        if (vm2.d.X().isAnchorEnable() == false) goto L121;
        IInteractService r42 = jc1.k.f(IInteractService.class);
        if (r42 == null) goto L98;
        x00.a r43 = r42.getThemeManager(true, ((Widget) this).dataCenter);
        if (r43 == null) goto L98;
        r43.j(this, new b1(this), 1);
    L98:
        IInteractService r44 = jc1.k.f(IInteractService.class);
        if (r44 == null) goto L103;
        x00.a r45 = r44.getThemeManager(true, ((Widget) this).dataCenter);
        if (r45 == null) goto L103;
        IVoiceLiveTheme r46 = r45.q(1);
    L104:
        IRoom r47 = jm2.a.d(getMRoom());
        if (r47 == null) goto L120;
        if (TextUtils.equals(r47.getLivePlatformSource(), "activity_auto_create") == false) goto L113;
        IInteractService r48 = jc1.k.f(IInteractService.class);
        if (r48 == null) goto L121;
        x00.a r49 = r48.getThemeManager(true, ((Widget) this).dataCenter);
        if (r49 == null) goto L121;
        r49.h(1);
        goto L121
    L113:
        if (r46 != null) goto L121;
        IInteractService r50 = jc1.k.f(IInteractService.class);
        if (r50 == null) goto L121;
        x00.a r51 = r50.getThemeManager(true, ((Widget) this).dataCenter);
        if (r51 == null) goto L121;
        r51.g(1, null);
        goto L121
    L120:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    L103:
        r46 = null;
    L121:
        Disposable r52 = jc1.k.n(IKtvService.class).observerCurrentIsSinger(null, false, new c(this));
        if (r52 == null) goto L124;
        RxUtilKt.c(r52, ((MultiLinkBaseAnchorLinkWidget) this).m);
    L124:
        com.bytedance.live.datacontext.k r53 = jc1.k.n(IKtvService.class).ktvComponentSingerChangedEvent();
        if (r53 == null) goto L127;
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r53.onEvent().subscribe(new d(this)));
    L127:
        com.bytedance.live.datacontext.j r54 = r30.s();
        if (r54 == null) goto L137;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r55 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r54.getValue();
        if (r55 == null) goto L137;
        BehaviorSubject r56 = r55.a();
        if (r56 == null) goto L137;
        Disposable r57 = r56.subscribe(new e(this));
        if (r57 == null) goto L137;
        RxUtilKt.c(r57, ((MultiLinkBaseAnchorLinkWidget) this).m);
    L137:
        if (vm2.d.w() == false) goto L143;
        if (this.X != null) goto L143;
        enableSubWidgetManager();
        ChatMatchWidget r58 = new ChatMatchWidget(true, this);
        this.X = r58;
        ((Widget) this).subWidgetManager.load(r58);
    L143:
        if (vm2.d.z() == true) goto L146;
    L148:
        r41 = false;
    L149:
        if (r41 == false) goto L152;
        ((ObservableSubscribeProxy) Observable.timer(vm2.d.T(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new e1(this));
    L152:
        com.bytedance.live.datacontext.m r59 = jc1.k.n(IKtvService.class).getHasBgm();
        if (r59 == null) goto L155;
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r59.a().subscribe(new f(this)));
    L155:
        JSONArray r60 = new JSONArray();
        r60.put(7);
        ((SingleSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getAudienceSettings(r60.toString(), getMRoom().getId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(g.a, h.a);
        ((ObservableSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).fetchInteractEntrances(getMRoom().getRoomId()).compose(RxUtil.rxSchedulerHelper()).as(autoDispose())).subscribe(new i(this), j.a);
        if (vm2.d.U0() == false) goto L162;
        com.bytedance.android.livesdk.chatroom.u r61 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r61 == null) goto L162;
        com.bytedance.live.datacontext.k r62 = r61.L();
        if (r62 == null) goto L162;
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(RxUtilKt.p(r62.onEvent(), "KtvRoomAnchorWidget", new KtvRoomAnchorWidget$onCreate$$inlined$let$lambda$1(this)));
    L162:
        DataCenter r63 = ((Widget) this).dataCenter;
        if (r63 == null) goto L169;
        jd0.c r64 = (jd0.c) r63.get("data_gift_message_board_linkmic_event", new jd0.c(0));
        if (r64 == null) goto L169;
        if (r2.a(r64.a) == false) goto L169;
        xs2.b.a().post(r64);
        ((Widget) this).dataCenter.put("data_gift_message_board_linkmic_event", null);
    L169:
        com.bytedance.android.live.liveinteract.linksecurity.c r65 = com.bytedance.android.live.liveinteract.linksecurity.c.g;
        r65.j();
        r65.k(((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.api.utils.p r66 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).u;
        if (r66 == null) goto L172;
        r66.a(getMRoom().getRoomId());
    L172:
        DataCenter r67 = ((Widget) this).dataCenter;
        Boolean r68 = Boolean.FALSE;
        if (((Boolean) r67.get("data_audio_chat_continue_linkmic_update_send_gift_status", r68)).booleanValue() == false) goto L175;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().Nf();
        ((Widget) this).dataCenter.put("data_audio_chat_continue_linkmic_update_send_gift_status", r68);
    L175:
        com.bytedance.android.live.liveinteract.plantform.core.h r69 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, yq());
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).t = r69;
        r69.a();
        hg6.g r70 = this.D;
        if (r70 == null) goto L178;
        ei6.a r71 = r70.V0();
    L179:
        hg6.g r72 = this.D;
        if (r72 == null) goto L186;
        ec6.b r73 = r72.R();
        if (r73 == null) goto L186;
        com.bytedance.android.live.pushstream.d r74 = gc6.b.a(r73);
        if (r74 == null) goto L186;
        r18 = r74.getLiveCore();
    L186:
        if (r71 == null) goto L191;
        if (r18 == null) goto L191;
        com.bytedance.android.live.liveinteract.plantform.core.h r75 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).t;
        if (r75 == null) goto L191;
        r75.d(new WeakReference(r71), new WeakReference(r18));
    L191:
        xs2.b.a().post(new pe0.a());
        RxUtilKt.c(xs2.b.a().b(zg1.g.class).subscribe(new c1(this)), ((MultiLinkBaseAnchorLinkWidget) this).m);
        return;
    L178:
        r71 = null;
        goto L179
    L146:
        if (((LinkAudioInviteGuideConfig) vm2.d.j0.getValue(null, vm2.d.a[59])).enabled != 1) goto L148;
    L75:
        r37 = null;
        goto L76
    L55:
        if ((getContext() instanceof FragmentActivity) == false) goto L61;
        InteractLiveCorePermissionGuarantor r76 = Rq();
        FragmentActivity r77 = getContext();
        if (r77 == null) goto L60;
        r76.i(r77);
        goto L61
    L60:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L194:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    }

    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        KtvRoomContainerWidget r0 = this.E;
        if (r0 == null) goto L5;
        r0.onBizDestory();
    L5:
        this.L0.b();
        yf6.a r1 = Nq();
        if (r1 == null) goto L8;
        r1.f();
    L8:
        com.bytedance.android.live.liveinteract.plantform.core.h r2 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).t;
        if (r2 == null) goto L11;
        r2.b();
    L11:
        InteractAnimationController r3 = this.O;
        if (r3 == null) goto L14;
        r3.l();
    L14:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r4 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("talkroom destroy");
        if (vm2.e.a() == false) goto L17;
        Rq().e();
    L17:
        DataCenter r5 = ((Widget) this).dataCenter;
        Boolean r6 = Boolean.FALSE;
        r5.put("data_self_is_silenced", r6);
        ((Widget) this).dataCenter.removeObserver(this);
        if (getMRoom().getLinkInitResult() == null) goto L20;
        boolean r9 = true;
    L21:
        com.bytedance.android.live.liveinteract.voicechat.util.k r7 = this.Q;
        if (r7 == null) goto L24;
        r7.e(this.J, r9);
    L24:
        com.bytedance.android.live.liveinteract.voicechat.util.k r8 = this.Q;
        if (r8 == null) goto L27;
        com.bytedance.android.live.liveinteract.voicechat.util.k.i(r8, com.bytedance.android.live.liveinteract.linkpanel.util.m.b(9, null), null, null, 56);
    L27:
        com.bytedance.android.live.liveinteract.voicechat.util.k r10 = this.Q;
        if (r10 == null) goto L30;
        com.bytedance.android.live.liveinteract.voicechat.util.k.k(r10, this.J, this.K, Integer.valueOf(this.L), r9, getMRoom().getCircleInfo(), com.bytedance.android.live.liveinteract.linkpanel.util.m.b(9, null));
    L30:
        com.bytedance.android.livesdk.log.filter.o r11 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r11 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L33;
        ((com.bytedance.android.livesdk.log.filter.t) r11).o();
    L33:
        tc0.c.h().j(r6);
        KtvRoomAnchorPresenter r12 = this.B;
        if (r12 == null) goto L36;
        r12.detachView();
    L36:
        VoiceChatMuteManager r13 = this.C;
        if (r13 == null) goto L40;
        r13.n();
    L40:
        if (((MultiLinkBaseAnchorLinkWidget) this).b == null) goto L42;
        boolean r14 = true;
    L43:
        if (r14 == false) goto L48;
        yq().T4(this.b1);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L47;
        yq().m();
        goto L48
    L47:
        yq().l();
    L48:
        this.P.b(8);
        y3.m(((Widget) this).dataCenter).d(ToolbarButton.INTERACTION_ROOM, this.P);
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L51;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().uo();
    L51:
        CompositeDisposable r15 = ((MultiLinkBaseAnchorLinkWidget) this).m;
        if (r15 != null) goto L54;
    L56:
        com.bytedance.android.live.liveinteract.api.utils.p r16 = ((MultiLinkVoiceBaseAnchorLinkWidget) this).u;
        if (r16 == null) goto L59;
        r16.b();
    L59:
        Disposable r17 = this.T;
        if (r17 == null) goto L66;
        Intrinsics.checkNotNull(r17);
        if (r17.isDisposed() == true) goto L66;
        Disposable r18 = this.T;
        if (r18 == null) goto L66;
        r18.dispose();
    L66:
        Yq();
        com.bytedance.android.livesdk.chatroom.u r19 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r19 == null) goto L71;
        com.bytedance.live.datacontext.m r20 = r19.I1();
        if (r20 == null) goto L71;
        r20.setValue(r6);
    L71:
        com.bytedance.android.live.liveinteract.plantform.base.g r21 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r21 == null) goto L74;
        r21.Sc();
    L74:
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L78;
        Integer r23 = (Integer) r22.get("data_link_state", 0);
        if (r23 == null) goto L78;
    L82:
        if (r23 == null) goto L84;
        r23.intValue();
        boolean r24 = !gd0.v.a(r23.intValue(), 8);
    L85:
        if (r24 == false) goto L87;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r25 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, null, false, false, null, 60);
    L96:
        Zq(r25);
        if (vm2.d.j0() == false) goto L108;
        WidgetManager r26 = ((Widget) this).subWidgetManager;
        if (r26 == null) goto L108;
        List r27 = r26.widgets;
        if (r27 == null) goto L108;
        if (r27.size() <= 0) goto L108;
        Iterator r28 = ((Widget) this).subWidgetManager.widgets.iterator();
    L106:
        if (r28.hasNext() == false) goto L108;
        ((Widget) this).subWidgetManager.unload((Widget) r28.next());
    L108:
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.u r29 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r29 == null) goto L115;
        com.bytedance.live.datacontext.j r30 = r29.J();
        if (r30 == null) goto L115;
        LivePlayModeLogContext r31 = (LivePlayModeLogContext) r30.getValue();
        if (r31 == null) goto L115;
        r31.clearPlayModesOnlySupportMultiPeople();
    L115:
        com.bytedance.android.live.liveinteract.linksecurity.c.g.l();
        sh0.d0 r32 = sh0.d0.b;
        sh0.i0 r33 = this.A;
        if (r33 == null) goto L118;
        r33.d0(r32, null);
    L118:
        sh0.i0 r34 = sh0.j0.a;
        sh0.j0.b(((Widget) this).dataCenter);
        hg6.g r35 = this.D;
        if (r35 == null) goto L121;
        r35.i(false);
    L121:
        this.E = null;
        return;
    L87:
        com.bytedance.android.livesdk.chatroom.u r36 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r36 == null) goto L95;
        com.bytedance.live.datacontext.j r37 = r36.s();
        if (r37 == null) goto L95;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r38 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r37.getValue();
        if (r38 == null) goto L95;
        r25 = r38.t();
        if (r25 != null) goto L96;
    L95:
        r25 = new com.bytedance.android.livesdk.chatroom.viewmodel.i(0, 0, null, false, false, null, 60);
        goto L96
    L84:
        r24 = false;
    L78:
        IInteractService r39 = jc1.k.f(IInteractService.class);
        if (r39 == null) goto L81;
        r23 = Integer.valueOf(r39.getLinkMode());
        goto L82
    L81:
        r23 = null;
        goto L82
    L54:
        if (r15.isDisposed() == true) goto L56;
        ((MultiLinkBaseAnchorLinkWidget) this).m.dispose();
        goto L56
    L42:
        r14 = false;
        goto L43
    L20:
        r9 = false;
        goto L21
    }

    public final void onResume() {
        super/*com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget*/.onResume();
        this.N = true;
        hg6.g r0 = this.D;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        WeakHandler r1 = this.H;
        if (r1 == null) goto L9;
        r1.removeCallbacksAndMessages(null);
    L9:
        if (vm2.e.a() == false) goto L12;
        Rq().g();
    L12:
        if (isEngineOn() == true) goto L14;
    L35:
        hg6.g r2 = this.D;
        if (r2 == null) goto L38;
        r2.i(com.bytedance.android.live.liveinteract.spatial.a.e(9));
    L38:
        yq().r0();
        return;
    L14:
        if (((MultiLinkVoiceBaseAnchorLinkWidget) this).z == null) goto L35;
        if (Jq() == null) goto L21;
        hh1.u0 r3 = Jq();
        if (r3 == null) goto L21;
        r3.resume();
    L21:
        if (vm2.e.a() == false) goto L25;
        if (Rq().p == false) goto L25;
    L30:
        jg6.a r4 = Bq();
        if (r4 == null) goto L35;
        kg6.e r5 = r4.b();
        if (r5 == null) goto L35;
        r5.y(false, "onResume");
    L25:
        if (Qq() != 3) goto L30;
        VoiceChatMuteManager r6 = this.C;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L29:
        r6.l("onResume");
        goto L30
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L6;
        Rq().h();
        return;
    }

    public final BizLinkServiceType Gq() {
        return BizLinkServiceType.KtvAnchor;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final tf0.h getInteractAnimationService() {
        return this.O;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final kk0.g getLinkMicSeatCallback() {
        return this.E;
    }

    public final int getScene() {
        return this.K;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final boolean ktvWillAutoSilenceSelf() {
        return ((MultiLinkVoiceBaseAnchorLinkWidget) this).x;
    }

    public static final /* synthetic */ VoiceChatMuteManager Pq(KtvRoomAnchorWidget r1) {
        VoiceChatMuteManager r2 = r1.C;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        return r2;
    }

    public final String N4(String r2) {
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = yq();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.N4(r2);
    }

    public final void Sq(boolean r3) {
        if (vm2.h.a0() == false) goto L16;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        r0.put("cmd_ktv_luanch", Boolean.valueOf(r3));
    L7:
        Context r4 = ((Widget) this).context;
        if ((r4 instanceof Activity) == true) goto L10;
        r4 = null;
    L10:
        Activity r5 = (Activity) r4;
        if (r5 == null) goto L17;
        View r6 = r5.findViewById(2131387771);
        if (r6 == null) goto L18;
        r6.setVisibility(8);
        return;
    L18:
        return;
    L17:
        return;
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
        int r4 = this.S + 1;
        this.S = r4;
        Set r5 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.y(r4, null, Boolean.valueOf(r3), r7.getSilenceStatus(), r7.getLinkType());
        if (this.S < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r0)) goto L38;
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
        this.S = 0;
        return;
    L34:
        this.S = 0;
        return;
    L22:
        r3 = false;
        goto L24
    L10:
        r2 = null;
        goto L12
    }

    public final void Zq(com.bytedance.android.livesdk.chatroom.viewmodel.i r21) {
        int r2 = this.K;
        int r3 = this.L;
        int r4 = r21.a;
        this.K = r4;
        int r5 = r21.b;
        this.L = r5;
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
        if (KtvUtilsKt.I(r4, r5) == true) goto L15;
        if (r2 != 0) goto L30;
    L33:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("reason", "switch_scene_api");
        com.bytedance.android.live.liveinteract.plantform.utils.i.c(r21.a, r21.b, r6);
        Sq(false);
    L34:
        KtvRoomContainerWidget r7 = this.E;
        if (r7 == null) goto L37;
        int r10 = KtvRoomContainerWidget.R;
        r7.Lq(r21, false);
    L37:
        Integer r11 = null;
        if (KtvUtilsKt.I(r21.a, r21.b) == true) goto L44;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getStatisticHelper().a = null;
        if (KtvUtilsKt.I(r2, r3) == false) goto L48;
        KtvRoomContainerWidget r12 = this.E;
        if (r12 == null) goto L48;
        r12.onBizDestory();
    L48:
        long r13 = SystemClock.elapsedRealtime();
        this.J = r13;
        ((Widget) this).dataCenter.put("data_room_audio_chat_anchor_uilayout_start_time", Long.valueOf(r13));
        if (KtvUtilsKt.I(r21.a, r21.b) == false) goto L150;
        int r14 = this.K;
        int r15 = this.L;
        boolean r1 = r21.d;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r16 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r14), Integer.valueOf(r15), null, null) == true) goto L74;
        String r17 = TalkRoomLogUtils.p(Integer.valueOf(r2), Integer.valueOf(r3), null);
        String r18 = TalkRoomLogUtils.p(Integer.valueOf(r14), Integer.valueOf(r15), null);
        String r19 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r3));
        String r110 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r15));
        ILiveWrappedLivePusher.Companion.getClass();
        if (ILiveWrappedLivePusher.a.a(r17, r18) == false) goto L62;
        if (r2 == 0) goto L62;
        if (ILiveWrappedLivePusher.a.a(r19, r110) == true) goto L74;
        com.bytedance.android.live.liveinteract.voicechat.util.k r111 = this.Q;
        if (r111 == null) goto L74;
        com.bytedance.android.live.liveinteract.voicechat.util.k.g(r111, null, r110, null, null, 12);
    L62:
        if (r2 != 0) goto L64;
        boolean r20 = true;
    L65:
        com.bytedance.android.live.liveinteract.voicechat.util.k r112 = this.Q;
        if (r112 == null) goto L74;
        if (r20 == true) goto L72;
        if (r19 == null) goto L72;
        if (Intrinsics.areEqual(r19, r110) == false) goto L72;
        String r113 = "function_switch";
    L73:
        com.bytedance.android.live.liveinteract.voicechat.util.k.g(r112, r18, r110, r113, null, 8);
    L72:
        r113 = null;
        goto L73
    L64:
        r20 = false;
    L74:
        if (r1 == true) goto L150;
        if (this.v1 == true) goto L150;
        HashMap r22 = new HashMap();
        if (r14 == 5) goto L93;
        if (r14 == 9) goto L84;
    L97:
        ICircleInfo r23 = getMRoom().getCircleInfo();
        if (r23 == null) goto L100;
        String r24 = r23.getCircleName();
    L102:
        if (TextUtils.isEmpty(r24) == true) goto L108;
        ICircleInfo r25 = getMRoom().getCircleInfo();
        if (r25 == null) goto L106;
        String r26 = r25.getCircleName();
    L107:
        r22.put("circle_name", String.valueOf(r26));
        goto L108
    L106:
        r26 = null;
    L108:
        String r27 = TalkRoomLogUtils.d;
        if (r27 == null) goto L112;
        r22.put("source", r27);
    L112:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L114;
        r22.put("is_invite_only", "1");
    L115:
        mz0.e r28 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r28 instanceof mz0.f) == true) goto L118;
        r28 = null;
    L118:
        mz0.f r29 = (mz0.f) r28;
        if (r29 != null) goto L121;
    L128:
        r22.put("shoot_way", "switch_layout");
        com.bytedance.android.livesdk.chatroom.u r30 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r30 == null) goto L137;
        com.bytedance.live.datacontext.j r31 = r30.s();
        if (r31 == null) goto L137;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r31.getValue();
        if (r32 == null) goto L137;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r33 = r32.g();
        if (r33 == null) goto L137;
        Integer r34 = Integer.valueOf(r33.a);
    L138:
        com.bytedance.android.livesdk.chatroom.u r35 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r35 == null) goto L147;
        com.bytedance.live.datacontext.j r36 = r35.s();
        if (r36 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r37 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r36.getValue();
        if (r37 == null) goto L147;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r38 = r37.g();
        if (r38 == null) goto L147;
        r11 = Integer.valueOf(r38.b);
    L147:
        r22.put("before_function", com.bytedance.android.live.liveinteract.plantform.utils.u0.a(r34, r11));
        if (this.Q == null) goto L150;
        com.bytedance.android.live.liveinteract.voicechat.util.k.c(r14, r15, r22);
    L137:
        r34 = null;
        goto L138
    L121:
        if (r29.getMap().containsKey("enter_from") == false) goto L128;
        if (TextUtils.equals((CharSequence) r29.getMap().get("enter_from"), "chat_match") == false) goto L126;
        r22.put("source", "chat_match");
        goto L128
    L126:
        if (TextUtils.equals((CharSequence) r29.getMap().get("solo_ktv"), "solo_ktv") == false) goto L128;
        r22.put("source", "solo_ktv");
        goto L128
    L114:
        r22.put("is_invite_only", BDLocationException.ERROR_TIMEOUT);
        goto L115
    L100:
        r24 = null;
        goto L102
    L84:
        if (r15 != 61) goto L86;
        r22.put("function_type", "chorus");
        r22.put("function_type2", "chorus");
    L87:
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_ktv_open_success", MapsKt.emptyMap(), new Object[]{IRoom.class, am2.x.class});
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L90;
        String r39 = "on";
    L91:
        r22.put("is_camera_allow", r39);
        goto L97
    L90:
        r39 = "off";
        goto L91
    L86:
        r22.put("function_type", "ktv");
        r22.put("function_type2", "ktv");
        goto L87
    L93:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(getMRoom()) == false) goto L95;
        String r40 = "party";
    L96:
        r22.put("function_type", r40);
        goto L97
    L95:
        r40 = "radio";
    L150:
        com.bytedance.android.livesdk.log.filter.o r41 = com.bytedance.android.livesdk.log.j0.l().c(com.bytedance.android.livesdk.log.filter.y.class);
        if (r41 == null) goto L153;
        r41.setData(new com.bytedance.android.livesdk.log.filter.y(this.K));
    L153:
        com.bytedance.android.live.liveinteract.plantform.base.g r42 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r42 == null) goto L157;
        r42.o6(Kq(this.K), true);
        return;
    L157:
        return;
    L44:
        KtvRoomContainerWidget r43 = this.E;
        if (r43 == null) goto L47;
        r43.onBizEnterRoom();
    L47:
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", new nh0.f("linkmic", new nh0.e(9, 0, com.bytedance.android.live.liveinteract.plantform.utils.u0.d(), 0, 0, null, null, null, 248), null, null, null, null, false, 224));
        goto L48
    L30:
        if (vm2.d.D() == false) goto L32;
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "interact_panel");
        goto L33
    L32:
        ((Widget) this).dataCenter.put("data_voice_chat_room_shoot_way", "null");
        goto L33
    L15:
        if (KtvUtilsKt.I(r21.a, r21.b) == false) goto L25;
        oe2.h r44 = (oe2.h) this.G.getValue();
        if (r44 == null) goto L22;
        KtvRoomContainerWidget r45 = this.E;
        if (r45 == null) goto L22;
        r45.Rq(r44);
    L22:
        WidgetManager r46 = ((Widget) this).subWidgetManager;
        ViewGroup r47 = ((Widget) this).containerView;
        if (r47 == null) goto L27;
        r46.load(r47, this.E, false);
        goto L25
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L25:
        Sq(true);
        goto L34
    L8:
        r9 = false;
        goto L9
    L5:
        r8 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void accept(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        ag6.a r0 = Wq();
        if (r0 == null) goto L6;
        r0.b(r3, ((MultiLinkVoiceBaseAnchorLinkWidget) this).v);
        return;
    }

    public final boolean br(String r2) {
        if (TextUtils.equals(r2, "ktv") == false) goto L5;
        int r3 = 2131918157;
    L6:
        com.bytedance.android.live.core.utils.s1.B(r3);
        com.bytedance.android.livesdk.log.filter.o r4 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r4 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L11;
        ((com.bytedance.android.livesdk.log.filter.t) r4).o();
        return false;
    L11:
        return false;
    L5:
        r3 = 2131918158;
        goto L6
    }

    public final void handleMsg(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        isViewValid();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (this.K != 9) goto L5;
        int r0 = 64;
    L6:
        r3.a = r0;
        ag6.a r1 = Wq();
        if (r1 == null) goto L10;
        r1.a(r3, ((MultiLinkVoiceBaseAnchorLinkWidget) this).w);
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
        ag6.a r0 = Wq();
        if (r0 == null) goto L6;
        r0.d(r3, "anchor_stop_normal");
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (isViewValid() == false) goto L85;
        if (r7 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7.getKey()) == false) goto L8;
        return;
    L8:
        if (r7.getData() == null) goto L107;
        String r0 = r7.getKey();
        if (Intrinsics.areEqual(r0, "cmd_open_interact_manage_dialog_by_anchor") == true) goto L13;
        String r3 = "";
        if (Intrinsics.areEqual(r0, "cmd_audio_talk_invite") == false) goto L46;
        IBaseUser r8 = (IBaseUser) r7.getData();
        if (r8 != null) goto L35;
        r8 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L35:
        com.bytedance.android.live.liveinteract.videolink.a r1 = new com.bytedance.android.live.liveinteract.videolink.a(getMRoom(), r8, -1);
        if (this.h1 == null) goto L38;
        r1.e = 3;
    L38:
        this.h1 = null;
        invite(r1);
        if (r8 == null) goto L44;
        String r9 = r8.getIdString();
        if (r9 == null) goto L44;
        r3 = r9;
    L44:
        TalkRoomLogUtils.C("anchor", r3, "card", -1);
        return;
    L46:
        if (Intrinsics.areEqual(r0, "data_member_count") == false) goto L48;
        return;
    L48:
        if (Intrinsics.areEqual(r0, "data_interact_anchor_param_change") == false) goto L57;
        hg6.g r2 = this.D;
        if (r2 == null) goto L96;
        String r10 = (String) r7.getData("");
        if (r10 == null) goto L55;
        r3 = r10;
    L55:
        r2.Q(r3);
        return;
    L96:
        return;
    L57:
        if (Intrinsics.areEqual(r0, "data_room_audio_chat_anchor_uilayout_switch_time") == false) goto L65;
        Long r11 = (Long) r7.getData(0L);
        if (r11 != null) goto L61;
        r11 = 0L;
    L61:
        long r4 = r11.longValue();
        if (r4 <= this.J) goto L98;
        ALogger.d("KtvRoomAnchorWidget", "update starttime : " + this.J + "->" + r4);
        this.J = r4;
        return;
    L98:
        return;
    L65:
        if (Intrinsics.areEqual(r0, "cmd_auto_join_channel") == false) goto L72;
        if (vm2.d.C() == false) goto L100;
        com.bytedance.live.bizlink.impl.platform.manager.a r12 = zq().A0();
        if (r12 == null) goto L101;
        r12.g();
        return;
    L101:
        return;
    L100:
        return;
    L72:
        if (Intrinsics.areEqual(r0, "cmd_video_talk_guest_battle_open_panel") == false) goto L77;
        sh0.g r13 = sh0.g.b;
        sh0.i0 r5 = this.A;
        if (r5 == null) goto L103;
        r5.d0(r13, null);
        return;
    L103:
        return;
    L77:
        if (Intrinsics.areEqual(r0, "cmd_operate_interact_media") == false) goto L105;
        MediaOperation r14 = (MediaOperation) r7.getData();
        if (r14 != null) goto L81;
        return;
    L81:
        if (r14.getType() != MediaOperation.Type.MIC) goto L108;
        int r15 = a1.a;
        throw null;
    L108:
        return;
    L105:
        return;
    L13:
        if (jc1.k.n(IInteractService.class).isEnableTalkRoomEmoji() == false) goto L22;
        ILinkPlayerInfoBridge r16 = yq().p(je0.d.b0(), tc0.c.h().f);
        if (r16 == null) goto L21;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r16.getSilenceStatus() == 0) goto L19;
        boolean r18 = true;
    L20:
        r17.put("data_self_is_silenced", Boolean.valueOf(r18));
        goto L21
    L19:
        r18 = false;
    L21:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a r19 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji.a();
        r19.b(((Widget) this).context);
        r19.c(((Widget) this).dataCenter);
        r19.c = Boolean.TRUE;
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r19.d = "seat";
        r19.a().a();
        return;
    L22:
        Context r20 = ((Widget) this).context;
        VoiceChatMuteManager r21 = this.C;
        if (r21 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L25:
        com.bytedance.android.live.liveinteract.voicechat.dialog.q r22 = new com.bytedance.android.live.liveinteract.voicechat.dialog.q(r20, r21);
        if (DialogLancet.shouldBlockDialogShow(r22) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r22);
        return;
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
    L29:
        DialogLancet.beforeDialogShow(r22);
        r22.show();
        DialogLancet.afterDialogShow(r22);
        return;
    L107:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void onSwitchSceneMessage(com.bytedance.android.livesdk.link.model.bridge.z0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ALogger.i("KtvRoomAnchorWidget", "onSwitchSceneMessage: msgScene = " + r6.getScene() + ", msgUILayout = " + r6.getUiLayout() + ", msgId = " + r6.getMessageId2());
        SwitchSceneResponse r0 = new SwitchSceneResponse();
        r0.scene = r6.getValidScene();
        r0.playModes = r6.getPlayModes();
        r0.uiLayout = r6.getUiLayout();
        r0.linkedUsers = jm2.a.a(r6.getLinkedListUsers());
        r0.version = r6.getVersion();
        r0.multiLiveCoreInfo = r6.getMultiLiveCoreInfo();
        r0.multiRtcInfo = r6.getMultiRtcInfo();
        r0.liveCoreExtInfo = r6.getLiveCoreExtInfo();
        r0.rtcExtInfo = r6.getRtcExtInfo();
        r0.linkerContentMap = KotlinTypeUtilsKt.castElementType(r6.getLinkerContentMap());
        if (vm2.d.v0() == false) goto L8;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r6);
    L8:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().yg((int) r6.getScene(), r6.getUiLayout(), r6.getPlayModes());
    L10:
        Yi(r0, "switchSceneMsg", "receive switch_scene msg");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void setInviteCallback(uf0.c r1) {
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).w = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void setPermitCallback(uf0.d r1) {
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).v = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.c
    public final ti6.j x(fi6.a r1) {
        return super.x(r1);
    }

    public final void G4(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (((MultiLinkVoiceBaseAnchorLinkWidget) this).z != null) goto L5;
    L26:
        String r8 = je0.d.b0();
        hh1.w0 r0 = this.I;
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
        VoiceChatMuteManager r9 = this.C;
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

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void accept(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "idString");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        ag6.a r4 = Wq();
        if (r4 == null) goto L6;
        r4.b(r0, ((MultiLinkVoiceBaseAnchorLinkWidget) this).v);
        return;
    }

    public final <T> void ar(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter.KtvRoomAnchorPresenter.IView
    public final void e0(int r2, LinkMicGuideMessage.AnchorGuideInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "guideInfo");
        if (yq().b() < r2) goto L6;
        ALogger.d("KtvRoomAnchorWidget", "intercept guide since online count hits limit");
        return;
    }

    public final void e1(String r1, long r2) {
        yq().getClass();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b
    public final void j2(int r12, LinkmicInfoWithRtcInfoData r13) {
        if (r13 == null) goto L13;
        hg6.g r0 = this.D;
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
        hg6.g r8 = this.D;
        if (r8 == null) goto L20;
        r8.J(r6);
    L20:
        if (r0 == null) goto L27;
        hg6.g r9 = this.D;
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

    public final int q0(List<ti6.f> r19, Map<String, Integer> r20) {
        List<ti6.f> r1 = r19;
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return 0;
    L11:
        Lazy r4 = KtvCommonSettingHelper.a;
        boolean r5 = KtvCommonSettingHelper.a(null);
        String r6 = tc0.c.h().f;
        String r7 = je0.d.g();
        String r8 = N4(r7);
        com.bytedance.live.datacontext.m r9 = jc1.k.n(IKtvService.class).isPushingExternalVideo();
        if (r9 != null) goto L14;
    L16:
        boolean r10 = false;
    L17:
        int r11 = this.F;
        if (r11 <= 0) goto L20;
        this.F = r11 - 1;
        boolean r12 = true;
    L21:
        Iterator<ti6.f> r13 = r19.iterator();
    L23:
        if (r13.hasNext() == false) goto L84;
        ti6.f r14 = r13.next();
        if (com.bytedance.android.live.liveinteract.spatial.a.e(9) == false) goto L66;
        String r15 = r14.b;
        if (r15 == null) goto L33;
        KtvRoomContainerWidget r16 = this.E;
        if (r16 == null) goto L33;
        Intrinsics.checkNotNullParameter(r15, "InteractId");
        qe2.a r17 = r16.e;
        if (r17 == null) goto L33;
        int r18 = r17.S0(r15);
    L34:
        HashMap r110 = new HashMap();
        String r111 = jc1.k.n(IKtvService.class).getKtvRoomCurrentSingerIdString();
        InteractiveSongContext r112 = InteractiveSongContext.Companion.getContext();
        if (r112 == null) goto L40;
        com.bytedance.live.datacontext.m r113 = r112.getSingingGuestId();
        if (r113 == null) goto L40;
        String r114 = (String) r113.getValue();
        if (r114 == null) goto L40;
    L41:
        String r115 = r114;
        if (r18 < 0) goto L68;
        SpatialAudioStrategyManager.c.getClass();
        SpatialAudioStrategyManager r21 = SpatialAudioStrategyManager.b;
        if (r21 == null) goto L47;
        com.bytedance.android.livesdk.model.y0 r22 = r21.b(9, r18, r2, r110);
        if (r22 == null) goto L47;
    L48:
        if (r12 == false) goto L51;
        ALogger.d("SpatialAudio_RadioStreamMixer", "isFirst == true");
    L63:
        boolean r23 = true;
    L65:
        ALogger.d("SpatialAudio_RadioStreamMixer", "mixStream spatialAudioStrategyId 9 enable :" + r23 + " position: " + r18 + " spatialRegion :" + r22);
        int r24 = r22.a();
        int r116 = r22.b();
        int r25 = r22.c();
        r14.p = r24;
        r14.q = r116;
        r14.r = r25;
        r14.t = r23;
        goto L68
    L51:
        if ((!Intrinsics.areEqual(r111, yq().r(r14.b))) == true) goto L53;
    L64:
        r23 = false;
        goto L65
    L53:
        if ((!Intrinsics.areEqual(r115, yq().r(r14.b))) == false) goto L64;
        if (r111 != null) goto L56;
    L59:
        boolean r26 = true;
    L60:
        if (r26 == false) goto L63;
        if (Intrinsics.areEqual(yq().r(r14.b), je0.d.a()) == true) goto L64;
    L56:
        if (r111.length() == 0) goto L59;
        r26 = false;
    L47:
        r22 = new com.bytedance.android.livesdk.model.y0(r2, r2, r2);
    L68:
        if (TextUtils.isEmpty(r8) == true) goto L83;
        if (r5 == false) goto L78;
        if (r10 == false) goto L78;
        if (TextUtils.equals(r6, r14.b) == false) goto L76;
        r14.a = 1;
        r14.f = 1.0d;
        r14.g = 1.0d;
        r14.c(je0.d.b0());
        r14.d = 0.0d;
        r14.e = 0.0d;
        r14.o = 1;
        r14.i = 0;
        goto L83
    L76:
        r14.a = 1;
        r14.f = 0.1d;
        r14.g = 0.1d;
        r14.c(yq().r(r14.b));
        r14.d = 1.0d;
        r14.e = 1.0d;
    L78:
        if (TextUtils.equals(r8, r14.b) == false) goto L80;
        r14.a = 1;
        r14.f = 1.0d;
        r14.g = 1.0d;
        r14.c(r7);
        r14.d = 0.0d;
        r14.e = 0.0d;
        r14.i = 0;
        goto L83
    L80:
        r14.a = 2;
        r14.f = 0.1d;
        r14.g = 0.1d;
        r14.c(yq().r(r14.b));
        r14.d = 1.0d;
        r14.e = 1.0d;
        if (TextUtils.equals(r6, r14.b) == false) goto L83;
        r14.a = 1;
    L83:
        r2 = 0;
    L40:
        r114 = "";
    L33:
        r18 = -1;
        goto L34
    L66:
        ALogger.d("SpatialAudio_RadioStreamMixer", "isSpatialAudioEnable == false");
        r14.t = false;
        goto L68
    L84:
        return 0;
    L20:
        r12 = false;
        goto L21
    L14:
        if (((Boolean) r9.getValue()).booleanValue() != true) goto L16;
        r10 = true;
        goto L17
    L5:
        if (r1.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b
    public final void switchVoiceSceneWithCheck(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "toScene");
        this.V0.switchVoiceSceneWithCheck(r2, r3);
    }

    public KtvRoomAnchorWidget(com.bytedance.android.live.pushstream.d r2, hh1.w0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        super(r2, tc0.c.h());
        this.p1 = r2;
        this.v1 = r4;
        this.F = 5;
        this.G = LazyKt.lazy(new KtvRoomAnchorWidget$roomDataEntity$2(this));
        this.P = new ToolbarInteractKtvRoomBehavior();
        new ToolbarRoomBattleBehavior();
        this.U = new HashMap(9);
        this.V = new HashMap();
        this.p0 = true;
        this.L0 = new com.bytedance.android.live.liveinteract.plantform.utils.s();
        this.P0 = new ArrayList();
        new ArrayList();
        this.V0 = new InteractSceneViewModel();
        ((MultiLinkVoiceBaseAnchorLinkWidget) this).u = new com.bytedance.android.live.liveinteract.api.utils.p(((MultiLinkVoiceBaseAnchorLinkWidget) this).z);
        this.I = r3;
        this.b1 = new b(this);
        this.g1 = new p(this);
    }

    public final void J(String[] r9, boolean[] r10, int[] r11) {
        HashMap r12 = new HashMap();
        Intrinsics.checkNotNull(r9);
        int r0 = r9.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L10;
        Intrinsics.checkNotNull(r11);
        int r4 = j22.c.c(r11[r2], true);
        Map<String, Integer> r5 = this.U;
        HashMap r6 = (HashMap) r5;
        r6.put(r9[r2], Integer.valueOf(r4));
        String r7 = r9[r2];
        if (r4 > 0) goto L9;
        r3 = false;
    L9:
        r12.put(r7, Boolean.valueOf(r3));
        r2 = r2 + 1;
        goto L3
    L10:
        IBaseUser r13 = getMRoom().getOwner();
        if (r13 == null) goto L29;
        String r14 = yq().N4(r13.getIdStrKt());
        if (((HashMap) this.U).containsKey(r14) == false) goto L29;
        Integer r8 = (Integer) ((HashMap) this.U).get(r14);
        if (r8 == null) goto L17;
        int r15 = r8.intValue();
    L18:
        KtvRoomContainerWidget r16 = this.E;
        if (r16 == null) goto L23;
        qe2.a r17 = r16.e;
        if (r17 == null) goto L23;
        r17.a(r15);
    L23:
        hh1.w0 r18 = this.I;
        if (r18 == null) goto L29;
        if (r15 <= 0) goto L27;
        boolean r19 = true;
    L28:
        r18.Wk(r14, r19);
        goto L29
    L27:
        r19 = false;
        goto L28
    L17:
        r15 = 0;
    L29:
        KtvRoomContainerWidget r110 = this.E;
        if (r110 == null) goto L34;
        Map<String, Integer> r20 = this.U;
        Intrinsics.checkNotNullParameter(r20, "talkStateMap");
        qe2.a r111 = r110.e;
        if (r111 == null) goto L34;
        r111.updateTalkState(r20);
    L34:
        int r112 = r9.length;
    L35:
        if (r1 >= r112) goto L37;
        Map<String, Integer> r21 = this.V;
        String r22 = r9[r1];
        Intrinsics.checkNotNull(r11);
        HashMap r23 = (HashMap) r21;
        r23.put(r22, Integer.valueOf(j22.c.c(r11[r1], true)));
        r1 = r1 + 1;
        goto L35
    }

    public final void S(String r7, int r8, int r9) {
        if (r8 <= 64) goto L65;
        if (r9 > 64) goto L7;
        return;
    L7:
        if (this.K == 9) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r7) == true) goto L69;
        hg6.g r0 = this.D;
        int r1 = 0;
        if (r0 == null) goto L14;
        int r2 = r0.y();
    L15:
        hg6.g r3 = this.D;
        if (r3 == null) goto L19;
        r1 = r3.L();
    L19:
        if (r2 < 720) goto L21;
    L63:
        ALogger.w("KtvRoomAnchorWidget", "ktv stream already adapted, w=" + r2 + " h=" + r1 + " from=remoteVideoSizeChanged");
        return;
    L21:
        if (r1 >= 540) goto L63;
        String r4 = je0.d.g();
        String r5 = yq().N4(r4);
        com.bytedance.android.livesdk.chatroom.u r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        String r10 = null;
        if (r6 == null) goto L30;
        com.bytedance.live.datacontext.j r11 = r6.s();
        if (r11 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r11.getValue();
        if (r12 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r13 = r12.t();
    L32:
        if ((r13 instanceof com.bytedance.android.livesdk.chatroom.viewmodel.h) == false) goto L43;
        com.bytedance.android.livesdk.link.model.bridge.u1 r14 = ((com.bytedance.android.livesdk.chatroom.viewmodel.h) r13).i;
        if (r14 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.model.interact.i0 r15 = r14.getKtvLiveCoreInfo();
        if (r15 == null) goto L38;
        vh7.c r16 = jm2.a.d(r15);
    L40:
        if ((r16 instanceof KTVLiveCoreInfo) == true) goto L42;
        r16 = null;
    L42:
        KTVLiveCoreInfo r17 = (KTVLiveCoreInfo) r16;
    L44:
        if (r17 == null) goto L46;
        Map r18 = r17.mLiveCoreExtInfoMap;
    L47:
        if (r18 == null) goto L50;
        if (r17 == null) goto L50;
        r10 = r17.getLiveCoreInfo(PromotionCategory.CATEGORY_TYPE_SECOND);
    L50:
        int r19 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r4, "singerId");
        Intrinsics.checkNotNullParameter(r7, "linkId");
        Intrinsics.checkNotNullParameter("remoteVideoSizeChanged", "from");
        HashMap r20 = new HashMap();
        r20.put("singer_id", r4);
        r20.put("link_id", r7);
        r20.put("video_width", Integer.valueOf(r8));
        r20.put("video_height", Integer.valueOf(r9));
        r20.put("reason", "remoteVideoSizeChanged");
        if (r10 != null) goto L53;
        String r21 = "null";
    L54:
        r20.put("live_core_info", r21);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("update_video_size_with_singer", r20);
        if (TextUtils.isEmpty(r10) == true) goto L59;
        hg6.g r22 = this.D;
        if (r22 == null) goto L62;
        r22.J(r10);
    L62:
        ALogger.w("ttlive_link_video", "ktvAdaptStreamSize from:remoteVideoSizeChanged singer:" + r4 + ' ' + r5);
        return;
    L59:
        hg6.g r23 = this.D;
        if (r23 == null) goto L62;
        r23.T();
        goto L62
    L53:
        r21 = r10;
        goto L54
    L46:
        r18 = null;
    L38:
        r16 = null;
        goto L40
    L43:
        r17 = null;
    L30:
        r13 = null;
        goto L32
    L14:
        r2 = 0;
        goto L15
    L69:
        return;
    }

    public final void Yi(com.bytedance.android.livesdk.chatroom.model.interact.v1 r18, String r19, String r20) {
        int r10 = r18.getScene();
        int r11 = r18.getUiLayout();
        com.bytedance.android.livesdk.chatroom.u r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r1.s();
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L12;
        if (r3.f(r10, r11) != true) goto L12;
        ALogger.i("KtvRoomAnchorWidget", "onSwitchSceneMessage already same layout, current scene = " + r10 + " layout = " + r11);
        return;
    L12:
        com.bytedance.android.live.liveinteract.plantform.core.y r4 = yq();
        List r5 = r18.getLinkedUsers();
        ClientUIInfo r6 = r18.getClientUiInfo();
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        if (r6 == null) goto L17;
        r4.Y4(r5, r6, r18.getVersion(), r19, r18.getLinkerContentMap());
    L17:
        com.bytedance.android.livesdk.link.model.bridge.u1 r7 = r18.getMultiLiveCoreInfo();
        com.bytedance.android.livesdk.link.model.bridge.v1 r8 = r18.getMultiRtcInfo();
        String r9 = r18.getLiveCoreExtInfo();
        String r12 = r18.getRtcExtInfo();
        tc0.c r13 = tc0.c.h();
        r13.r = r7;
        r13.n = r8;
        r13.k = r12;
        r13.m = r9;
        if (KtvUtilsKt.I(r10, r11) == true) goto L22;
        KtvRoomContainerWidget r14 = this.E;
        if (r14 == null) goto L22;
        r14.onBizDestory();
    L22:
        com.bytedance.android.livesdk.chatroom.u r15 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r15 == null) goto L59;
        com.bytedance.live.datacontext.j r16 = r15.s();
        if (r16 == null) goto L59;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r16.getValue();
        if (r17 == null) goto L59;
        int r21 = r18.getUiLayout();
        List r22 = r18.getPlayModes();
        String r23 = r18.getRtcExtInfo();
        if (r23 != null) goto L31;
        String r24 = "";
    L32:
        String r25 = r18.getLiveCoreExtInfo();
        if (r25 != null) goto L35;
        String r26 = "";
    L36:
        com.bytedance.android.livesdk.chatroom.viewmodel.h r110 = new com.bytedance.android.livesdk.chatroom.viewmodel.h(r10, r21, r22, false, r24, r26, r18.getMultiLiveCoreInfo(), r18.getClientUiInfo());
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L39;
        r27.put("data_room_audio_chat_ui_layout_before", Integer.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodel.i) r110).b));
    L39:
        com.bytedance.android.livesdk.chatroom.u r28 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r28 == null) goto L58;
        ArrayList r29 = new ArrayList();
        com.bytedance.live.datacontext.j r30 = r28.s();
        if (r30 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r31 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r30.getValue();
        if (r31 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r32 = r31.t();
    L48:
        if (r32 == null) goto L52;
        int r33 = r32.a;
        int r34 = r32.b;
        List r35 = r32.c;
        if (r35 == null) goto L53;
        r29.addAll(r35);
    L53:
        com.bytedance.live.datacontext.j r36 = r28.s();
        if (r36 == null) goto L58;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r37 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r36.getValue();
        if (r37 == null) goto L58;
        r37.c(new com.bytedance.android.livesdk.chatroom.viewmodel.i(r33, r34, r29, false, false, null, 32));
        goto L58
    L52:
        r33 = 0;
        r34 = 0;
    L47:
        r32 = null;
    L58:
        r17.d(r110);
        goto L59
    L35:
        r26 = r25;
        goto L36
    L31:
        r24 = r23;
    L59:
        com.bytedance.android.livesdk.chatroom.u r38 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r38 == null) goto L73;
        com.bytedance.live.datacontext.m r39 = r38.I1();
        if (r39 != null) goto L64;
    L70:
        com.bytedance.live.datacontext.m r40 = r38.q();
        if (r40 == null) goto L73;
        r40.setValue(new nd.a(0, r18.getMaxMcNum()));
        goto L73
    L64:
        if (r10 == 9) goto L66;
    L68:
        boolean r111 = false;
    L69:
        r39.setValue(Boolean.valueOf(r111));
        goto L70
    L66:
        if (r11 == 61) goto L68;
        r111 = true;
    L73:
        com.bytedance.android.livesdk.chatroom.o r41 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r41 == null) goto L79;
        com.bytedance.live.datacontext.m r42 = r41.w2();
        if (r42 == null) goto L80;
        r42.setValue(Boolean.TRUE);
        return;
    L80:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void showInviteAndPermitDialog(boolean r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter("", "taskName");
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.M == true) goto L8;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", "");
        com.bytedance.android.live.liveinteract.plantform.base.f.a().oa(r5, r6, 0, new d1(this));
        this.M = true;
    L8:
        if (r4 == true) goto L10;
        return;
    L10:
        if (this.Q == null) goto L14;
        com.bytedance.android.live.liveinteract.voicechat.util.k.d("anchor");
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b
    public final void switchScene(int r21, int r22, int r23, String r24) {
        if (this.k1 == false) goto L5;
        return;
    L5:
        this.k1 = true;
        if (com.bytedance.android.live.liveinteract.api.utils.m.j(this) != null) goto L8;
        return;
    L8:
        if (getMRoom() == null) goto L13;
        long r9 = System.currentTimeMillis();
        Disposable r0 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).switchScene(getMRoom().getId(), getMRoom().getId(), r21, r22, r23, r24).subscribeOn(Schedulers.io()).flatMap(q.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this, r21, r22, r24, r9, r23), new s(this, r21, r22, r24, r9));
        ((MultiLinkBaseAnchorLinkWidget) this).m.add(r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a
    public final void switchAudioByClient(boolean r9, List<com.bytedance.android.livesdk.link.model.bridge.k> r10, ClientUIInfo r11, long r12, Map<Long, ? extends RoomLinkerContent> r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r15, "reason");
        G4(r9, r15);
        VoiceChatMuteManager r16 = this.C;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMuteManager");
    L5:
        r16.t(r9);
        com.bytedance.android.live.liveinteract.plantform.core.y r1 = yq();
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
