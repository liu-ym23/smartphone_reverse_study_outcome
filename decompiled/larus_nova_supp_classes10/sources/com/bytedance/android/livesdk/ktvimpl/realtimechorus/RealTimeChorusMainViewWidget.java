package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.business.container.AnnieXLiveCard;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.CommonOrderSongViewModel;
import com.bytedance.android.live.ktv.common.search.viewmodel.CommonSearchViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.universalwidget.MultiLinkUniversalAnimWidget;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.soloktv.model.EnterRtChorusRoomSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongHandler;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.viewmodel.KtvModeOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvMvLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.KtvDressViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.manager.KtvModeTuningDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.FragmentManagerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.dialog.RTChorusFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.RealTimeChorusMicHybridCardManager$registerMethods$2;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.RealTimeChorusMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.RealTimeChorusMidiWidget;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.LinkMicBigEventMessage;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.RealTimeChorusStage;
import com.bytedance.android.livesdk.message.model.aj;
import com.bytedance.android.livesdk.message.model.jd;
import com.bytedance.android.livesdk.message.model.kd;
import com.bytedance.android.livesdk.message.model.q2;
import com.bytedance.android.livesdk.message.model.t2;
import com.bytedance.android.livesdk.message.model.u2;
import com.bytedance.android.livesdk.message.model.w2;
import com.bytedance.android.livesdk.message.model.x2;
import com.bytedance.android.livesdk.message.model.z2;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.KtvDressDataKt;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.android.livesdkapi.depend.message.UserChorusInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\b2\u00020\t2\u00020\n:\u0001\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusMainViewWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvRoomSceneBaseWidget;", "Lvlc/l;", "Ltb0/a;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/liveinteract/animation/InteractAnimationController$d;", "Lcom/bytedance/android/live/ktv/common/util/c;", "Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/l1;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusMainViewWidget extends KtvRoomSceneBaseWidget implements vlc.l, tb0.a, ViewModelStoreOwnerCompat, com.bytedance.android.livesdk.ktvimpl.base.sei.c, Observer<KVData>, InteractAnimationController.d, com.bytedance.android.live.ktv.common.util.c, l1 {
    public static final /* synthetic */ int Q2 = 0;
    public KtvPreviewSongsWidget A;
    public KtvPreviewSongsViewModel B;
    public FrameLayout C;
    public Pair<KtvPreviewSongsViewModel, ? extends Disposable> D;
    public MvLyricWidget E;
    public com.bytedance.android.livesdk.ktvimpl.base.sei.w E2;
    public FrameLayout F;
    public n1 F2;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b G;
    public RealTimeChorusBusinessLifecycleOwner G1;
    public long G2;
    public FrameLayout H;
    public final CompositeDisposable H0;
    public long H1;
    public final j0 H2;
    public FrameLayout I;
    public final k0 I2;
    public RealTimeChorusMidiWidget J;
    public final ViewModelStore J2;
    public boolean K;
    public Function2<? super Boolean, ? super Long, Unit> K2;
    public boolean L;
    public final CompositeDisposable L0;
    public boolean L1;
    public final String L2;
    public KtvCoreViewModel M;
    public MusicPanel M1;
    public final int M2;
    public RealTimeChorusFeedBackView N;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d N2;
    public boolean O;
    public hh1.w0 O2;
    public ConstraintLayout P;
    public Pair<? extends DataContext, ? extends Disposable> P0;
    public double P1;
    public com.bytedance.android.livesdk.chatroom.widget.j1 P2;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c Q;
    public double Q1;
    public MessageHub R;
    public FrameLayout S;
    public boolean S1;
    public FrameLayout T;
    public final Set<Long> T1;
    public final List<UserChorusInfo> U;
    public final d1 V;
    public Pair<? extends DataContext, ? extends Disposable> V0;
    public List<ch0.e> V1;
    public int W;
    public final KtvContext X;
    public Disposable Y;
    public Disposable Z;
    public Pair<? extends OrderedSongDataContext, ? extends Disposable> b1;
    public Map<String, Boolean> b2;
    public int c;
    public int d;
    public final y e;
    public Boolean f;
    public aj g;
    public Disposable g1;
    public List<tf0.e> g2;
    public Long h;
    public Pair<KtvRoomContext, ? extends Disposable> h1;
    public int h2;
    public String i;
    public boolean j;
    public Integer k;
    public final sb0.b k0;
    public KSongOrderSongDialog k1;
    public boolean l;
    public final k m;
    public long n;
    public String o;
    public boolean p;
    public final sb0.a p0;
    public KtvSingerViewModel p1;
    public boolean p2;
    public boolean q;
    public RealTimeChorusSingerInfoView r;
    public RTChorusMusicInfoView s;
    public RealTimeChorusOperateView t;
    public Guideline u;
    public FrameLayout v;
    public RecyclableWidgetManager v1;
    public boolean v2;
    public Guideline w;
    public RTChorusLogView x;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c x1;
    public MiddlewareRoomWidget x2;
    public HSImageView y;
    public final com.bytedance.android.live.ktv.common.util.e y1;
    public boolean y2;
    public Drawable z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ RealTimeChorusMainViewWidget a;

        public b(RealTimeChorusMainViewWidget r1) {
            this.a = r1;
        }

        public final void a() {
            RealTimeChorusMainViewWidget r0 = this.a;
            int r1 = RealTimeChorusMainViewWidget.Q2;
            View r2 = r0.Iq();
            if (r2 == null) goto L5;
            int r3 = r2.getWidth();
        L6:
            r0.c = r3;
            RealTimeChorusMainViewWidget r4 = this.a;
            View r5 = r4.Iq();
            if (r5 == null) goto L9;
            int r6 = r5.getHeight();
        L10:
            r4.d = r6;
            boolean r7 = StatusBarUtil.isStatusBarTransparent();
            int r8 = x1.e(((Widget) this.a).context);
            int r9 = x1.k();
            ALogger.i("RealTimeChorusMainViewWidget", "adapterFold screenHeight = " + r8 + " , parentHeightPx = " + this.a.d + " , statusBarTransparent = " + r7 + ", statusBarHeight = " + r9);
            int r10 = r8 - this.a.d;
            int r11 = r10 + 10;
            boolean r12 = false;
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L20;
            int r13 = x1.k();
            boolean r14 = StatusBarUtil.isStatusBarTransparent();
            if (r13 <= r10) goto L16;
            boolean r15 = true;
        L17:
            if (r14 == false) goto L20;
            if (r15 == false) goto L20;
            r12 = true;
            goto L20
        L16:
            r15 = false;
        L20:
            if (r12 == false) goto L22;
            int r16 = r9 + r11;
        L23:
            int r17 = s1.f(118.0f) + r16;
            int r18 = s1.f(96.0f) + r16;
            int r19 = s1.f(438.0f) + r16;
            Guideline r20 = this.a.u;
            if (r20 == null) goto L26;
            r20.setGuidelineBegin(r17);
        L26:
            UIUtils.updateLayoutMargin(this.a.v, -3, r18, -3, -3);
            Guideline r21 = this.a.w;
            if (r21 == null) goto L29;
            r21.setGuidelineBegin(r19);
        L29:
            RealTimeChorusMainViewWidget r22 = this.a;
            boolean r23 = r22.v2;
            ViewGroup r24 = ((Widget) r22).containerView;
            if (r24 == null) goto L32;
            r24.post(new q0(r22, r23));
        L32:
            RealTimeChorusMainViewWidget r25 = this.a;
            ViewGroup r26 = ((Widget) r25).containerView;
            int r27 = -1;
            if (r26 == null) goto L36;
            ViewGroup.LayoutParams r28 = r26.getLayoutParams();
            if (r28 == null) goto L36;
        L38:
            if (s1.y() <= s1.w()) goto L40;
        L43:
            int r29 = (int) ((s1.w() * 9.0f) / 16.0f);
            int r30 = r25.c;
            if (r30 <= 0) goto L47;
            if (r30 > r29) goto L47;
        L46:
            int r31 = -1;
            float r32 = 0.0f;
        L48:
            r28.width = r27;
            r28.height = r31;
            ViewGroup r33 = ((Widget) r25).containerView;
            if (r33 == null) goto L51;
            r33.setTranslationX(r32);
        L51:
            ViewGroup r34 = ((Widget) r25).containerView;
            if (r34 == null) goto L54;
            r34.setLayoutParams(r28);
        L54:
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r35 = r25.Q;
            if (r35 == null) goto L60;
            int r36 = r25.zq();
            JSONObject r37 = new JSONObject();
            r37.put("eventName", "event_party_ktv_stage_size_update");
            JSONObject r38 = new JSONObject();
            r38.put("screen_width", String.valueOf(r36));
            r38.put("screen_height", String.valueOf(260));
            Unit r39 = Unit.INSTANCE;
            r37.put("data", r38);
            HybridCard r40 = r35.a;
            if (r40 == null) goto L61;
            r40.sendJsEvent("event_party_ktv_stage_size_update", r37);
            return;
        L61:
            return;
        L60:
            return;
        L47:
            int r41 = s1.w();
            r32 = (s1.y() - r29) / 2.0f;
            r31 = r41;
            r27 = r29;
            goto L48
        L40:
            if (FoldScreenUtils.e() == true) goto L43;
            if (PadConfigUtils.c() == false) goto L46;
        L36:
            r28 = new FrameLayout.LayoutParams(-1, -1);
            goto L38
        L22:
            r16 = 10;
            goto L23
        L9:
            r6 = s1.w();
            goto L10
        L5:
            r3 = s1.y();
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ RealTimeChorusMainViewWidget a;

        public c(RealTimeChorusMainViewWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RealTimeChorusMainViewWidget r0 = this.a;     // Catch: Throwable -> L6
            RealTimeChorusOperateView r1 = r0.t;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.U5(r0.Cq());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ RealTimeChorusMainViewWidget a;

        public d(RealTimeChorusMainViewWidget r1) {
            this.a = r1;
        }

        public final void a() {
            String r5 = "sslocal://webcast_lynxview?hybrid_type=lynx&url=";
            if (vm2.d.V() == false) goto L24;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r0 = this.a.Q;
            if (r0 == null) goto L24;
            if (r0.b != null) goto L24;
            String r7 = (String) vm2.d.Z4.getValue(null, vm2.d.a[309(0x135, float:4.33E-43)]);
            u6 r8 = new u6("sslocal://webcast_lynxview?hybrid_type=lynx&url=");
            r8.b("url", r7);
            Uri r9 = r8.c();
            ALogger.i("RealTimeChorusMicHybridCardManager", "guest lynx uri: " + r9);
            IBaseBrowserService r10 = jc1.k.f(IBaseBrowserService.class);
            if (r10 == null) goto L12;
            HybridCard r11 = r10.getHybridCard(r0.j, r9, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.m(r0));
        L13:
            r0.b = r11;
            if (r11 == null) goto L16;
            a7.a.a(r11, null, null, 3);
        L16:
            HybridCard r12 = r0.b;
            if (r12 == null) goto L24;
            Map<String, Map<String, List<Object>>> r13 = r0.e;
            Intrinsics.checkNotNull(r12);
            r13.put(String.valueOf(r12.hashCode()), new LinkedHashMap());
            FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -1);
            HybridCard r15 = r0.b;
            if (r15 == null) goto L21;
            r15.setLayoutParams(r14);
        L21:
            ViewGroup r16 = r0.i;
            if (r16 == null) goto L24;
            r16.addView(r0.b);
            goto L24
        L12:
            r11 = null;
        L24:
            RealTimeChorusMainViewWidget r1 = this.a;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r17 = r1.Q;
            if (r17 == null) goto L43;
            int r2 = r1.zq();
            if (r17.a != null) goto L43;
            ReadOnlyProperty r18 = vm2.h.m2;
            KProperty[] r19 = vm2.h.a;
            String r20 = (String) r18.getValue(null, r19[167(0xa7, float:2.34E-43)]);
            if (((Boolean) vm2.h.l2.getValue(null, r19[166(0xa6, float:2.33E-43)])).booleanValue() == false) goto L32;
            r5 = "sslocal://webcast_lynxview?hybrid_type=lynx&mix_container_type=annie&url=";
        L32:
            u6 r21 = new u6(r5);
            r21.b("url", r20);
            u6 r4 = r21.d("url");
            r4.b("screen_width", String.valueOf(r2));
            r4.b("screen_height", String.valueOf(260));
            r4.b("seat_top", "20");
            r4.b("seat_bottom", BDLocationException.ERROR_MULTI_THREAD_LOCATE);
            Uri r3 = r21.c();
            ALogger.i("RealTimeChorusMicHybridCardManager", "main lynx uri: " + r3);
            r17.a = jc1.k.n(IBaseBrowserService.class).getHybridCard(r17.j, r3, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.l(r17));
            w.a("RealTimeChorusMicHybridCardManager", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
            HybridCard r6 = r17.a;
            if (r6 == null) goto L35;
            a7.a.a(r6, null, null, 3);
        L35:
            HybridCard r22 = r17.a;
            if (r22 == null) goto L43;
            Map<String, Map<String, List<Object>>> r23 = r17.e;
            Intrinsics.checkNotNull(r22);
            r23.put(String.valueOf(r22.hashCode()), new LinkedHashMap());
            FrameLayout.LayoutParams r24 = new FrameLayout.LayoutParams(-1, -1);
            HybridCard r25 = r17.a;
            if (r25 == null) goto L40;
            r25.setLayoutParams(r24);
        L40:
            ViewGroup r26 = r17.h;
            if (r26 == null) goto L43;
            r26.addView(r17.a);
        L43:
            this.a.Yq("loadChorusMicSeat");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<T> implements h80.a {
        public final /* synthetic */ RealTimeChorusMainViewWidget a;

        public e(RealTimeChorusMainViewWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v10, types: [com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void accept(Object r7) {
            IRoom r8 = (IRoom) r7;
            if (KtvSettingHelper.w() == false) goto L5;
            this.a.y1.d(new tb0.b.a());
        L5:
            ALogger.i("logKtvMainPath", "onBizEnterKtvRoom, invoke class :RealTimeChorusMainViewWidget");
            MessageHub r9 = this.a.R;
            if (r9 == null) goto L8;
            r9.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this.a);
        L8:
            RealTimeChorusMainViewWidget r10 = this.a;
            r10.getClass();
            if (((Boolean) KtvSettingHelper.c.getValue()).booleanValue() == false) goto L14;
            ConstraintLayout r11 = r10.t;
            if (r11 == null) goto L14;
            r11.setVisibility(0);
        L14:
            this.a.hr(false);
            RealTimeChorusMainViewWidget r12 = this.a;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = r12.N2;
            if (r0 == null) goto L23;
            BehaviorSubject r1 = r0.P0();
            if (r1 == null) goto L23;
            Observable r2 = RxUtilKt.h(r1);
            if (r2 == null) goto L23;
            Disposable r3 = r2.subscribe(c0.a);
            if (r3 == null) goto L23;
            RxUtilKt.c(r3, r12.H0);
        L23:
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r4 = r12.N2;
            if (r4 == null) goto L30;
            BehaviorSubject r5 = r4.f();
            if (r5 == null) goto L30;
            Disposable r6 = r5.subscribe(new d0(r12));
            if (r6 == null) goto L30;
            RxUtilKt.c(r6, r12.H0);
        L30:
            int r13 = com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a;
            if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(r12.M2) == false) goto L40;
            com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = r12.N2;
            if (r14 == null) goto L40;
            BehaviorSubject r15 = r14.j1();
            if (r15 == null) goto L40;
            Disposable r16 = r15.subscribe(new e0(r12));
            if (r16 == null) goto L40;
            RxUtilKt.c(r16, r12.H0);
        L40:
            if (vm2.d.V() == false) goto L50;
            LinkMicRoomDataSyncModel r17 = LinkWRDSHelper.b();
            if (r17 == null) goto L50;
            dc2.c r18 = r17.getTalkRoomListUserInfoPb();
            if (r18 == null) goto L50;
            Observable r19 = r18.e;
            if (r19 == null) goto L50;
            Disposable r20 = r19.subscribe(new f0(r12));
            if (r20 == null) goto L50;
            RxUtilKt.c(r20, r12.H0);
        L50:
            this.a.Mq(false);
            RxUtilKt.c(xs2.b.a().b(jd0.r.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new l0(this)), this.a.H0);
            RxUtilKt.c(xs2.b.a().b(jd0.q.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new m0(this)), this.a.H0);
            RxUtilKt.c(xs2.b.a().b(jd0.p.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new n0(this)), this.a.H0);
            RealTimeChorusMainViewWidget r21 = this.a;
            r21.h2 = 0;
            r21.p2 = false;
            com.bytedance.android.livesdk.chatroom.o r22 = o3.f();
            IVoiceLiveTheme r23 = null;
            if (r22 == null) goto L55;
            com.bytedance.live.datacontext.j r24 = r22.getMessageManager();
            if (r24 == null) goto L55;
            vlc.d r25 = (vlc.d) r24.getValue();
        L57:
            if ((r25 instanceof xlc.a) == true) goto L59;
            r25 = null;
        L59:
            xlc.a r26 = (xlc.a) r25;
            if (r26 == null) goto L62;
            MessageType r27 = MessageType.REAL_TIME_CHORUS_MESSAGE;
            r26.y(r27.getIntType(), r21);
            r21.onMessage(r26.u(r27.getIntType()));
        L62:
            com.bytedance.android.livesdk.chatroom.o r28 = o3.f();
            if (r28 == null) goto L69;
            com.bytedance.live.datacontext.j r29 = r28.getMessageManager();
            if (r29 == null) goto L69;
            vlc.d r30 = (vlc.d) r29.getValue();
            if (r30 == null) goto L69;
            r30.addMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getWsMethod(), r21);
        L69:
            com.bytedance.android.livesdk.chatroom.o r31 = o3.f();
            if (r31 == null) goto L76;
            com.bytedance.live.datacontext.j r32 = r31.getMessageManager();
            if (r32 == null) goto L76;
            vlc.d r33 = (vlc.d) r32.getValue();
            if (r33 == null) goto L76;
            r33.addMessageListener(MessageType.LINK_MIC_BIG_EVENT.getWsMethod(), r21);
        L76:
            final RealTimeChorusMainViewWidget r34 = this.a;
            LifecycleOwner r35 = r34.getLifecycleOwner();
            if (r35 == null) goto L82;
            RealTimeChorusBusinessContext.a r36 = RealTimeChorusBusinessContext.Companion;
            r36.o(r35, new RealTimeChorusMainViewWidget$initChorusRoleObserver$$inlined$let$lambda$1(r34));
            if (KtvSettingHelper.b().booleanValue() == true) goto L82;
            r36.n(r35, new RealTimeChorusMainViewWidget$initChorusRoleObserver$$inlined$let$lambda$2(r34));
        L82:
            if (((Boolean) KtvSettingHelper.k1.getValue()).booleanValue() == false) goto L84;
            RxUtilKt.c(r34.X.getHasBgm().a().subscribe(new a0(r34)), r34.H0);
        L84:
            final RealTimeChorusMainViewWidget r37 = this.a;
            RealTimeChorusBusinessLifecycleOwner r38 = r37.getLifecycleOwner();
            if (r38 == null) goto L89;
            fd2.s r39 = RealTimeChorusBusinessContext.Companion.c();
            if (r39 == null) goto L89;
            r39.y9(r38, new RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1(r37));
        L89:
            RealTimeChorusMainViewWidget r40 = this.a;
            LifecycleOwner r41 = r40.getLifecycleOwner();
            if (r41 == null) goto L100;
            RealTimeChorusOperateView r42 = r40.t;
            if (r42 == null) goto L100;
            Intrinsics.checkNotNullParameter(r41, "lifecycleOwner");
            if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L100;
            r42.b6();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r43 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
            if (r43 == null) goto L100;
            com.bytedance.android.live.liveinteract.voicechat.b r44 = r43.muteManager();
            if (r44 == null) goto L100;
            r44.c(r41, new z0(r42));
        L100:
            RealTimeChorusOperateView r45 = this.a.t;
            if (r45 != null) goto L103;
        L107:
            RealTimeChorusMainViewWidget r46 = this.a;
            r46.Jq();
            KtvModeOrderedSongDataContext r47 = r46.Eq();
            if (r47 == null) goto L112;
            Disposable r48 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r47, null, new h0(r46), 3);
            if (r48 == null) goto L112;
            RxUtilKt.c(r48, r46.H0);
        L112:
            sb0.b r49 = r46.k0;
            if (r49 == null) goto L115;
            sb0.e r50 = r49.b();
        L116:
            if (r50 != null) goto L118;
        L128:
            RealTimeChorusMainViewWidget r51 = this.a;
            DataCenter r52 = ((Widget) r51).dataCenter;
            if (r52 == null) goto L131;
            r52.observe("data_dynamic_show_emoji_panel", r51);
        L131:
            RealTimeChorusMainViewWidget r53 = this.a;
            Disposable r54 = r53.X.getOpenKtvRoomDialogEvent().onEvent().subscribe(new r0(r53));
            if (r54 == null) goto L134;
            RxUtilKt.c(r54, r53.H0);
        L134:
            com.bytedance.live.datacontext.n r55 = o3.e(r53).C();
            if (r55 == null) goto L141;
            Observable r56 = r55.a();
            if (r56 == null) goto L141;
            ObservableSubscribeProxy r57 = (ObservableSubscribeProxy) r56.as(r53.autoDispose());
            if (r57 == null) goto L141;
            r57.subscribe(new s0(r53));
        L141:
            com.bytedance.live.datacontext.n r58 = o3.e(r53).C();
            if (r58 == null) goto L151;
            Pair r59 = (Pair) r58.getValue();
            if (r59 == null) goto L151;
            if (TextUtils.isEmpty((CharSequence) r59.getSecond()) == true) goto L151;
            String r60 = o3.e(r53).w();
            if (r60 != null) goto L150;
            r60 = "ktv_convenient";
        L150:
            r53.br(r60, false, (String) r59.getSecond(), (Integer) r59.getFirst());
        L151:
            com.bytedance.live.datacontext.m r61 = o3.e(r53).K();
            if (r61 == null) goto L158;
            String r62 = (String) r61.getValue();
            if (r62 == null) goto L158;
            if (TextUtils.isEmpty(r62) == true) goto L158;
            r53.br("ktv_convenient", false, null, null);
        L158:
            this.a.X.getKtvRoomStrategy().setValue(new i1());
            RealTimeChorusMainViewWidget r63 = this.a;
            r63.S1 = false;
            r63.Sq();
            FrameLayout r64 = this.a.S;
            if (r64 == null) goto L161;
            r64.post(new o0(this));
        L161:
            this.a.Rq();
            RealTimeChorusMainViewWidget r65 = this.a;
            KtvCoreViewModel r66 = r65.M;
            KtvSingerViewModel r67 = r65.p1;
            KtvContext r68 = r65.X;
            if (r66 == null) goto L173;
            if (r67 == null) goto L173;
            if (r68 == null) goto L173;
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r69 = KtvModeOrderSongDataContext.Companion.a();
            if (r69 == null) goto L168;
            r69.getOrderedSongList(true);
        L168:
            LifecycleOwner r70 = r65.getLifecycleOwner();
            if (r70 == null) goto L173;
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r71 = KtvModeOrderSongDataContext.Companion.b();
            if (r71 == null) goto L173;
            r71.observeSongListDataChange(r70, new b0(r65));
        L173:
            RealTimeChorusMainViewWidget r72 = this.a;
            r72.getClass();
            IInteractService r73 = jc1.k.f(IInteractService.class);
            if (r73 == null) goto L176;
            x00.a r74 = r73.getThemeManager(je0.d.r(), ((Widget) r72).dataCenter);
        L177:
            if (r74 == null) goto L179;
            r23 = r74.q(100);
        L179:
            com.bytedance.android.live.liveinteract.plantform.base.g r75 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
            if (r75 == null) goto L185;
            com.bytedance.android.live.ui.c r76 = r75.y4();
            if (r76 == null) goto L185;
            r76.b(r23);
        L185:
            if (KtvSettingHelper.w() == true) goto L187;
            this.a.y1.d(new tb0.b.a());
        L187:
            this.a.cr();
            RealTimeChorusOperateView r77 = this.a.t;
            if (r77 != null) goto L190;
        L196:
            RealTimeChorusMainViewWidget r78 = this.a;
            if (r78.x1 != null) goto L203;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c r79 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c(r78.e);
            r78.x1 = r79;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r80 = r78.Q;
            Intrinsics.checkNotNullParameter(r78, "singInfoProvider");
            r79.c = r80;
            cg6.a r81 = r79.e.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r81 == null) goto L203;
            hg6.g r82 = r81.getRtcManager();
            if (r82 == null) goto L203;
            r82.p(r79.d);
        L203:
            RealTimeChorusMainViewWidget r83 = this.a;
            ConstraintLayout r85 = r83.t;
            if (r85 == null) goto L206;
            r85.postDelayed(new x0(r83), ((Number) KtvSettingHelper.k.getValue()).longValue());
        L206:
            RealTimeChorusMainViewWidget r86 = this.a;
            aj r87 = r86.g;
            if (r87 == null) goto L209;
            r86.nr(r87, true);
        L209:
            KtvCoreViewModel r88 = this.a.M;
            if (r88 == null) goto L214;
            StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r89 = r88.getCurrentTransition();
            if (r89 == null) goto L214;
            this.a.Kq(r89);
        L214:
            this.a.yq();
            return;
        L190:
            if (KtvSettingHelper.C() == false) goto L196;
            if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.W.getValue()).booleanValue() == true) goto L196;
            ConstraintLayout r90 = r77.f;
            if (r90 == null) goto L196;
            r90.postDelayed(new b1(r77), 5000);
            goto L196
        L176:
            r74 = null;
            goto L177
        L118:
            if (r46.k0.isAnchor() == false) goto L128;
            KtvModeOrderedSongDataContext r91 = r46.Eq();
            if (r91 == null) goto L124;
            List<SongUniqueInfo> r92 = r91.getKtvPublicSongUniqueInfoList();
            if (r92 == null) goto L124;
            int r93 = r92.size();
        L125:
            RealTimeChorusOperateView r94 = r46.t;
            if (r94 == null) goto L128;
            r94.c6(r93);
        L124:
            r93 = 0;
            goto L125
        L115:
            r50 = null;
            goto L116
        L103:
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L107;
            Disposable r95 = xs2.b.a().b(ye2.a.class).subscribe(new a1(r45));
            if (r95 == null) goto L107;
            RxUtilKt.c(r95, r45.a);
        L55:
            r25 = null;
            goto L57
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.network.response.e r2 = (com.bytedance.android.live.network.response.e) r1;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ ub0.d a;
        public final /* synthetic */ RealTimeChorusMainViewWidget b;

        public h(ub0.d r1, RealTimeChorusMainViewWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvCoreViewModel r0 = this.b.M;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.sendEvent(new KtvRoomLyricsStateMachineConfig.a.f(this.a.c), "RealTimeChorusMainViewWidget");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class i implements fd0.b {
        public final /* synthetic */ RealTimeChorusMainViewWidget a;

        public i(RealTimeChorusMainViewWidget r1) {
            this.a = r1;
        }

        public final void onStop() {
            RealTimeChorusMainViewWidget r0 = this.a;
            if (r0.L == false) goto L15;
            FrameLayout r1 = r0.I;
            if (r1 == null) goto L7;
            r1.setVisibility(8);
        L7:
            RecyclableWidgetManager r2 = this.a.Bq();
            if (r2 == null) goto L10;
            r2.unload(this.a.J);
        L10:
            RealTimeChorusMainViewWidget r3 = this.a;
            r3.J = null;
            RealTimeChorusSingerInfoView r4 = r3.r;
            if (r4 == null) goto L13;
            r4.setGetCurUserChorusDataCB(null);
        L13:
            this.a.L = false;
            return;
        }
    }

    static {
    }

    public final void Bn(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    public final boolean Ed(int r1) {
        return true;
    }

    public final EmojiSoundManager I8(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fromUid");
        Intrinsics.checkNotNullParameter(r3, "toUid");
        return null;
    }

    public final ArrayList Ka(int r1, float r2) {
        return null;
    }

    public final boolean Pf(int r1) {
        return true;
    }

    public final ArrayList dm(int r1) {
        return null;
    }

    public final int getLayoutId() {
        return 2131567255;
    }

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public final q50.b jq() {
        return null;
    }

    public final boolean lo(int r1) {
        return true;
    }

    public final int ma(int r1, int r2) {
        return -1;
    }

    public final int qq(int r1) {
        return -1;
    }

    public final boolean si() {
        return false;
    }

    public final boolean wc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return false;
    }

    public final int zl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return -1;
    }

    public final void Aq() {
        Disposable r0 = (Disposable) this.P0.getSecond();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        this.P0 = new Pair(null, null);
        return;
    }

    public final RecyclableWidgetManager Bq() {
        RecyclableWidgetManager r0 = this.v1;
        if (r0 != null) goto L62;
        Fragment r1 = null;
        if (KtvSettingHelper.i() == false) goto L45;
        Context r2 = ((Widget) this).context;
        if ((r2 instanceof FragmentActivity) == true) goto L9;
        r2 = null;
    L9:
        Activity r3 = (FragmentActivity) r2;
        if (r3 != null) goto L14;
        r3 = com.bytedance.android.live.core.utils.a.d();
    L14:
        if ((r3 instanceof FragmentActivity) == true) goto L16;
        r3 = null;
    L16:
        FragmentActivity r4 = (FragmentActivity) r3;
        Fragment r5 = com.bytedance.android.livesdk.ktvimpl.base.util.d.a(r4);
        if (r5 != null) goto L19;
    L21:
        if (r4 != null) goto L23;
    L25:
        if (r5 == null) goto L38;
        FragmentManager r6 = r5.getChildFragmentManager();
        if (r6 == null) goto L38;
        List r7 = r6.getFragments();
        if (r7 == null) goto L38;
        Iterator r8 = r7.iterator();
    L32:
        if (r8.hasNext() == false) goto L36;
        Object r9 = r8.next();
        if ((((Fragment) r9) instanceof RecyclableWidgetManager) == false) goto L32;
    L37:
        Fragment r10 = (Fragment) r9;
    L40:
        if ((r10 instanceof RecyclableWidgetManager) == false) goto L43;
        r1 = r10;
    L43:
        RecyclableWidgetManager r11 = (RecyclableWidgetManager) r1;
    L44:
        this.v1 = r11;
    L58:
        return this.v1;
    L36:
        r9 = null;
    L38:
        r10 = null;
        goto L40
    L23:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r4.getSupportFragmentManager()) == true) goto L25;
        r11 = RecyclableWidgetManager.ha0(r4, ((Widget) this).contentView);
        goto L44
    L19:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r5.getChildFragmentManager()) == true) goto L21;
        r11 = RecyclableWidgetManager.ga0(r5, ((Widget) this).contentView);
        goto L44
    L45:
        Fragment r12 = ((Widget) this).context;
        if ((r12 instanceof FragmentActivity) == true) goto L48;
        r12 = null;
    L48:
        Fragment r13 = (FragmentActivity) r12;
        if (r13 != null) goto L53;
        r13 = com.bytedance.android.live.core.utils.a.d();
    L53:
        if ((r13 instanceof FragmentActivity) == false) goto L56;
        r1 = r13;
    L56:
        this.v1 = RecyclableWidgetManager.ha0((FragmentActivity) r1, ((Widget) this).contentView);
        goto L58
    L62:
        return r0;
    }

    public final String Cq() {
        com.bytedance.android.live.profit.dress.t r0 = (com.bytedance.android.live.profit.dress.t) this.X.getLinkmicRealTimeChorusDress().getValue();
        int r1 = 0;
        if (r0 == null) goto L16;
        List r2 = r0.c;
        if (r2 == null) goto L16;
        Integer r3 = this.k;
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        com.bytedance.android.live.profit.dress.config.n r5 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r2, r4);
        if (r5 == null) goto L16;
        py.k r6 = r5.getEnterBtnImage();
        if (r6 == null) goto L16;
        String r7 = KtvUtilsKt.g(r6);
        if (r7 == null) goto L16;
        return r7;
    L9:
        r4 = 0;
    L16:
        Integer r8 = this.k;
        if (r8 == null) goto L19;
        r1 = r8.intValue();
    L19:
        if (r1 != 0) goto L22;
        return com.bytedance.android.live.ktv.common.midi.h.a;
    L22:
        if (r1 != 1) goto L25;
        return com.bytedance.android.live.ktv.common.midi.h.b;
    L25:
        if (r1 != 2) goto L28;
        return com.bytedance.android.live.ktv.common.midi.h.c;
    L28:
        return com.bytedance.android.live.ktv.common.midi.h.a;
    }

    public final KtvModeOrderedSongDataContext Eq() {
        return KtvModeOrderedSongDataContext.Companion.getContext();
    }

    public final String Fq() {
        com.bytedance.android.live.profit.dress.t r0 = (com.bytedance.android.live.profit.dress.t) this.X.getLinkmicRealTimeChorusDress().getValue();
        if (r0 == null) goto L14;
        List r1 = r0.c;
        if (r1 == null) goto L14;
        Integer r2 = this.k;
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        com.bytedance.android.live.profit.dress.config.n r4 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r1, r3);
        if (r4 == null) goto L14;
        String r5 = r4.getThemeColor();
        if (r5 == null) goto L14;
        return r5;
    L9:
        r3 = 0;
    L14:
        return "#00FFE0";
    }

    public final double Gq() {
        RealTimeChorusMidiWidget r0 = this.J;
        if (r0 == null) goto L9;
        RealTimeChorusMidiViewModel r1 = r0.b;
        if (r1 != null) goto L10;
        return 0.0d;
    L10:
        return r1.getTotalScore();
    L9:
        return this.Q1;
    }

    public final View Iq() {
        ViewGroup r0 = ((Widget) this).containerView;
        Object r1 = null;
        if (r0 == null) goto L7;
        ViewParent r2 = r0.getParent();
        if (r2 == null) goto L7;
        ViewParent r3 = r2.getParent();
    L9:
        if ((r3 instanceof View) == false) goto L13;
        r1 = r3;
    L13:
        return (View) r1;
    L7:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void Jq() {
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = KtvModeOrderSongDataContext.Companion.a();
        Long r2 = null;
        if ((r0 instanceof BaseOrderSongViewModel) == true) goto L5;
        r0 = null;
    L5:
        BaseOrderSongViewModel r1 = (BaseOrderSongViewModel) r0;
        if (r1 == null) goto L8;
        Boolean r3 = Boolean.valueOf(r1.hasReceiveSongListChangeMessage());
    L9:
        boolean r4 = true;
        if ((!Intrinsics.areEqual(r3, Boolean.TRUE)) == false) goto L13;
        ALogger.i("RealTimeChorusMainViewWidget", "handleSongListChange: hasReceiveSongListChangeMessage == false");
        return;
    L13:
        KtvModeOrderedSongDataContext r5 = Eq();
        if (r5 == null) goto L18;
        List<MusicPanel> r6 = r5.m200getKtvSingSongList();
        if (r6 == null) goto L18;
        MusicPanel r7 = (MusicPanel) KtvUtilsKt.K(r6, 0);
    L19:
        if (r7 == null) goto L21;
        Long r8 = Long.valueOf(r7.c());
    L22:
        MusicPanel r9 = this.M1;
        if (r9 == null) goto L26;
        r2 = Long.valueOf(r9.c());
    L26:
        if ((!Intrinsics.areEqual(r8, r2)) == true) goto L28;
    L30:
        KtvModeOrderedSongDataContext r10 = Eq();
        if (r10 == null) goto L35;
        List<SongUniqueInfo> r11 = r10.getKtvPublicSongUniqueInfoList();
        if (r11 == null) goto L35;
        int r12 = r11.size();
    L36:
        RealTimeChorusOperateView r13 = this.t;
        if (r13 == null) goto L39;
        r13.c6(r12);
    L39:
        if (r12 != 0) goto L43;
        RealTimeChorusOperateView r14 = this.t;
        if (r14 == null) goto L43;
        r14.setJoiningChorus(false);
    L43:
        if (r12 != 0) goto L45;
        Lq();
        ar("song list change");
    L45:
        KtvModeOrderedSongDataContext r15 = Eq();
        if (r15 == null) goto L74;
        MusicPanel r16 = r15.getKtvPublicFirstOrderedSong();
        if (r16 == null) goto L75;
        String r17 = s1.C(2131922308, new Object[]{r16.a.getMTitle()});
        String r18 = r16.g();
        if (r18 != null) goto L53;
        r18 = "";
    L53:
        long r19 = r16.c();
        if (r19 == this.n) goto L56;
    L58:
        r4 = false;
    L59:
        if (r4 == true) goto L72;
        this.P1 = 0.0d;
        this.Q1 = 0.0d;
        RealTimeChorusOperateView r20 = this.t;
        if (r20 == null) goto L63;
        r20.setJoiningChorus(false);
    L63:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        xe2.h.f = r17;
        this.n = r19;
        String r21 = String.valueOf(r19);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        xe2.h.g = r21;
        this.o = r18;
        RTChorusMusicInfoView r22 = this.s;
        if (r22 == null) goto L66;
        r22.T5(r17);
    L66:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r23 = this.Q;
        if (r23 == null) goto L69;
        r23.g(r17, String.valueOf(r19));
    L69:
        ConstraintLayout r24 = this.t;
        if (r24 == null) goto L72;
        r24.postDelayed(new c(this), ((Number) KtvSettingHelper.k.getValue()).longValue() + 5000);
    L72:
        cr();
        return;
    L56:
        if (Intrinsics.areEqual(this.o, r18) == false) goto L58;
    L75:
        return;
    L74:
        return;
    L35:
        r12 = 0;
        goto L36
    L28:
        if (this.L1 == false) goto L30;
        this.M1 = r7;
        goto L30
    L21:
        r8 = null;
    L18:
        r7 = null;
        goto L19
    L8:
        r3 = null;
        goto L9
    }

    public final void Lq() {
        ConstraintLayout r0 = this.r;
        if (r0 != null) goto L5;
    L7:
        RealTimeChorusSingerInfoView r1 = this.r;
        if (r1 == null) goto L11;
        r1.setSelfVisibility(4);
        return;
    L11:
        return;
    L5:
        if (r0.getVisibility() != 4) goto L7;
    }

    public final void Nq() {
        if (this.V0.getFirst() == null) goto L5;
        return;
    L5:
        if (((Boolean) KtvSettingHelper.q1.getValue()).booleanValue() == false) goto L7;
        ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this).clear();
    L7:
        Pair<? extends DataContext, ? extends Disposable> r0 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$1.INSTANCE);
        this.V0 = r0;
        Object r1 = r0.getFirst();
        if ((r1 instanceof KtvModeOrderSongDataContext) == true) goto L10;
        r1 = null;
    L10:
        KtvModeOrderSongDataContext r2 = (KtvModeOrderSongDataContext) r1;
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.b.a(r2, RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$2.INSTANCE);
    L13:
        KSongOrderSongHandler r3 = new KSongOrderSongHandler();
        if (r2 == null) goto L18;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b> r4 = r2.m103getCommonOrderSongViewModel();
        if (r4 == null) goto L18;
        CommonOrderSongViewModel.Companion.getClass();
        r4.d(CommonOrderSongViewModel.a.a(this, r3));
    L18:
        if (r2 == null) goto L22;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r5 = r2.m104getCommonSearchViewModel();
        if (r5 == null) goto L22;
        CommonSearchViewModel.Companion.getClass();
        r5.d(CommonSearchViewModel.a.a(this, r3));
    L22:
        if (r2 == null) goto L26;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r6 = r2.m102getBusinessOrderSongViewModel();
        if (r6 == null) goto L26;
        KtvModeOrderSongViewModel.a r7 = KtvModeOrderSongViewModel.Companion;
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r8 = KtvModeOrderSongDataContext.Companion.b();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r9 = KtvModeOrderSongDataContext.Companion.c();
        KtvModeOrderedSongDataContext r10 = KtvModeOrderedSongDataContext.Companion.getContext();
        r7.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r11 = KtvModeOrderSongViewModel.a.a(this, r8, r9, r10);
        r11.initData();
        Unit r12 = Unit.INSTANCE;
        r6.d(r11);
    L26:
        KtvModeOrderSongDataContext.Companion.getClass();
        r3.a = KtvModeOrderSongDataContext.Companion.a();
        r3.b = KtvModeOrderSongDataContext.Companion.b();
        if (r2 == null) goto L33;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r13 = r2.m105getKtvDressViewModel();
        if (r13 == null) goto L34;
        KtvDressViewModel.Companion.getClass();
        r13.d(KtvDressViewModel.a.a(this));
        return;
    L34:
        return;
    }

    public final void Pq() {
        if (this.P0.getFirst() != null) goto L6;
        w.a("RealTimeChorusMainViewWidget", "initKSongTuningDataContext");
        this.P0 = KSongTuningPanelHelperKt.b(true, this.V.h(this.k0.isAnchor()), new WeakReference(((Widget) this).context));
        return;
    L6:
        if (KSongTuningPanelHelperKt.d() != null) goto L12;
        DataContext r0 = (DataContext) this.P0.getFirst();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.b.a(r0, KtvModeTuningDataContext.class);
        return;
    L13:
        return;
    }

    public final boolean Qq() {
        com.bytedance.android.livesdk.ktvimpl.base.sei.w r0 = this.E2;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r2 = r0.b;
    L7:
        if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L10;
        r1 = r2;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r3 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r1;
        if (r3 != null) goto L24;
        w.a("RealTimeChorusMainViewWidget", "lastSeiResult == null");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r4 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r4 == null) goto L17;
        if (r4.isEngineOn() != true) goto L17;
    L19:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.X) != null) goto L22;
        w.a("RealTimeChorusMainViewWidget", "singer show preview song");
        return true;
    L22:
        return false;
    L17:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L22;
    L24:
        if (r3.d() != 1) goto L29;
        if (r3.C() != 0) goto L29;
        return true;
    L29:
        if (r3.d() != 2) goto L31;
    L56:
        return true;
    L31:
        if (r3.d() == 6) goto L56;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r5 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r5 == null) goto L38;
        if (r5.isEngineOn() != true) goto L38;
    L40:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.X) != null) goto L44;
        w.a("RealTimeChorusMainViewWidget", "singer show preview song, ignore sei");
        return true;
    L44:
        if (((Boolean) KtvSettingHelper.o1.getValue()).booleanValue() == false) goto L55;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r6 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r6 == null) goto L50;
        if (r6.isEngineOn() != true) goto L50;
    L52:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.X) != null) goto L55;
        w.a("RealTimeChorusMainViewWidget", "singer show preview song, ignore sei");
        return true;
    L50:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L52;
    L55:
        return false;
    L38:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L44;
    L5:
        r2 = null;
        goto L7
    }

    public final void Rq() {
        if (this.x2 != null) goto L10;
        xh0.d r0 = jc1.k.n(IInteractService.class).getPlayModeService();
        if (r0 == null) goto L7;
        MultiLinkUniversalAnimWidget r1 = r0.e(this, SceneType.SCENE_KTV, ((Widget) this).containerView);
    L8:
        this.x2 = r1;
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void Sq() {
        if (((Boolean) KtvSettingHelper.i.getValue()).booleanValue() == false) goto L13;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r0 = this.Q;
        if (r0 != null) goto L7;
    L11:
        this.p = false;
        w.a("RealTimeChorusMainViewWidget", "has not main stage");
        goto L13
    L7:
        if (r0.a == null) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
    L9:
        r1 = false;
    L13:
        if (this.p == true) goto L18;
        this.p = true;
        FrameLayout r2 = this.S;
        if (r2 == null) goto L19;
        r2.post(new d(this));
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1
    public final double Uc() {
        RealTimeChorusMidiWidget r0 = this.J;
        if (r0 == null) goto L6;
        return r0.wq();
    L6:
        return this.P1;
    }

    public final void Zq() {
        ALogger.i("RealTimeChorusMainViewWidget", "releaseLiveRoomResource");
        this.S1 = true;
        if (KtvSettingHelper.b().booleanValue() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r1 = this.Q;     // Catch: Exception -> L104
        if (r1 == null) goto L8;
        r1.h(false, false);     // Catch: Exception -> L104
    L8:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.c r2 = this.x1;     // Catch: Exception -> L104
        if (r2 == null) goto L21;
        cg6.a r4 = r2.e.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);     // Catch: Exception -> L104
        if (r4 == null) goto L15;
        hg6.g r5 = r4.getRtcManager();     // Catch: Exception -> L104
        if (r5 == null) goto L15;
        r5.Z(r2.d);     // Catch: Exception -> L104
    L15:
        ((ArrayList) r2.b).clear();     // Catch: Exception -> L104
        r2.c = null;     // Catch: Exception -> L104
        Disposable r6 = r2.a;     // Catch: Exception -> L104
        if (r6 == null) goto L21;
        if (r6.isDisposed() == true) goto L20;
        r6.dispose();     // Catch: Exception -> L104
    L20:
        r2.a = null;     // Catch: Exception -> L104
    L21:
        this.x1 = null;     // Catch: Exception -> L104
        this.k1 = null;     // Catch: Exception -> L104
        this.N2 = null;     // Catch: Exception -> L104
        RealTimeChorusOperateView r3 = this.t;     // Catch: Exception -> L104
        if (r3 == null) goto L24;
        r3.a.clear();     // Catch: Exception -> L104
    L24:
        ConstraintLayout r7 = this.t;     // Catch: Exception -> L104
        if (r7 == null) goto L27;
        r7.setVisibility(4);     // Catch: Exception -> L104
    L27:
        hr(true);     // Catch: Exception -> L104
        RealTimeChorusOperateView r0 = this.t;     // Catch: Exception -> L104
        if (r0 == null) goto L30;
        r0.setJoiningChorus(false);     // Catch: Exception -> L104
    L30:
        sb0.b r8 = this.k0;     // Catch: Exception -> L104
        if (r8 == null) goto L33;
        sb0.e r9 = r8.b();     // Catch: Exception -> L104
    L34:
        if (r9 != null) goto L36;
    L40:
        DataCenter r10 = ((Widget) this).dataCenter;     // Catch: Exception -> L104
        if (r10 == null) goto L44;
        r10.removeObserver(this);     // Catch: Exception -> L104
    L44:
        if (((Boolean) KtvSettingHelper.f.getValue()).booleanValue() == false) goto L50;
        KtvSingerViewModel r11 = this.p1;     // Catch: Exception -> L104
        if ((r11 instanceof KtvSingerViewModel) == true) goto L48;
        r11 = null;
    L48:
        if (r11 == null) goto L50;
        r11.clearData();     // Catch: Exception -> L104
    L50:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r12 = this.X.getKtvSingerViewModel();     // Catch: Exception -> L104
        if (r12 == null) goto L53;
        r12.setValue(null);     // Catch: Exception -> L104
    L53:
        this.p1 = null;     // Catch: Exception -> L104
        KtvCoreViewModel r13 = this.M;     // Catch: Exception -> L104
        if (r13 == null) goto L58;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.k r14 = r13.getAnchorController();     // Catch: Exception -> L104
        if (r14 == null) goto L58;
        r14.i();     // Catch: Exception -> L104
    L58:
        KtvCoreViewModel r15 = this.M;     // Catch: Exception -> L104
        if (r15 == null) goto L61;
        r15.setAnchorController(null);     // Catch: Exception -> L104
    L61:
        Tq(false);     // Catch: Exception -> L104
        Widget.WidgetCallback r16 = ((Widget) this).widgetCallback;     // Catch: Exception -> L104
        if (r16 == null) goto L66;
        WidgetManager r17 = r16.getWidgetManager();     // Catch: Exception -> L104
        if (r17 == null) goto L66;
        r17.dataCenter = null;     // Catch: Exception -> L104
    L66:
        RecyclableWidgetManager r18 = this.v1;     // Catch: Exception -> L104
        if (r18 == null) goto L69;
        ((WidgetManager) r18).dataCenter = null;     // Catch: Exception -> L104
    L69:
        Disposable r19 = this.Y;     // Catch: Exception -> L104
        if (r19 != null) goto L72;
    L74:
        RTChorusLogView r20 = this.x;     // Catch: Exception -> L104
        if (r20 == null) goto L77;
        r20.e.dispose();     // Catch: Exception -> L104
    L77:
        this.O = false;     // Catch: Exception -> L104
        if (((Boolean) KtvSettingHelper.v.getValue()).booleanValue() == false) goto L84;
        KtvCoreViewModel r21 = this.M;     // Catch: Exception -> L104
        if (r21 == null) goto L84;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r22 = r21.getCurrentTransition();     // Catch: Exception -> L104
        if (r22 == null) goto L84;
        Kq(r22);     // Catch: Exception -> L104
    L84:
        gr();     // Catch: Exception -> L104
        WidgetManager r23 = ((Widget) this).subWidgetManager;     // Catch: Exception -> L104
        if (r23 == null) goto L87;
        r23.unload(this.x2);     // Catch: Exception -> L104
    L87:
        this.x2 = null;     // Catch: Exception -> L104
        Aq();     // Catch: Exception -> L104
        Disposable r24 = (Disposable) this.V0.getSecond();     // Catch: Exception -> L104
        if (r24 != null) goto L90;
    L92:
        Disposable r25 = (Disposable) this.b1.getSecond();     // Catch: Exception -> L104
        if (r25 != null) goto L95;
    L97:
        Disposable r26 = this.g1;     // Catch: Exception -> L104
        if (r26 != null) goto L100;
    L102:
        this.H0.clear();     // Catch: Exception -> L104
        return;
    L100:
        if (r26.isDisposed() == true) goto L102;
        r26.dispose();     // Catch: Exception -> L104
        this.g1 = null;     // Catch: Exception -> L104
        goto L102
    L95:
        if (r25.isDisposed() == true) goto L97;
        r25.dispose();     // Catch: Exception -> L104
        this.b1 = new Pair(null, null);     // Catch: Exception -> L104
        goto L97
    L90:
        if (r24.isDisposed() == true) goto L92;
        r24.dispose();     // Catch: Exception -> L104
        this.V0 = new Pair(null, null);     // Catch: Exception -> L104
        goto L92
    L72:
        if (r19.isDisposed() == true) goto L74;
        r19.dispose();     // Catch: Exception -> L104
        goto L74
    L36:
        if (this.k0.isAnchor() == true) goto L40;
        if (this.X.isCurrentUserIsSinger() == false) goto L40;
        this.X.updateCurrentUserIsSinger(false);     // Catch: Exception -> L104
        goto L40
    L33:
        r9 = null;
    }

    public final void cr() {
        KtvModeOrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
        com.bytedance.android.livesdk.log.filter.o r1 = null;
        if (r0 == null) goto L5;
        MusicPanel r2 = r0.getKtvPublicFirstOrderedSong();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r3 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L11;
        r3 = null;
    L11:
        com.bytedance.android.livesdk.log.filter.t r4 = (com.bytedance.android.livesdk.log.filter.t) r3;
        if (r4 == null) goto L14;
        Map<String, String> r5 = r4.getMap();
    L16:
        if (r5 == null) goto L19;
        String r6 = r5.get("enter_from_merge");
        if (r6 == null) goto L19;
    L20:
        if (r5 == null) goto L23;
        String r7 = r5.get("enter_method");
        if (r7 == null) goto L23;
    L24:
        EnterRtChorusRoomSource r8 = EnterRtChorusRoomSource.CHORUS_PAGE;
        boolean r9 = true;
        if (Intrinsics.areEqual(r6, (String) r8.getPair().getFirst()) == true) goto L27;
    L29:
        boolean r10 = false;
    L30:
        EnterRtChorusRoomSource r11 = EnterRtChorusRoomSource.SOLO_KTV_PAGE;
        if (Intrinsics.areEqual(r6, (String) r11.getPair().getFirst()) == true) goto L33;
    L35:
        boolean r12 = false;
    L36:
        EnterRtChorusRoomSource r13 = EnterRtChorusRoomSource.ANCHOR_KSONG;
        if (Intrinsics.areEqual(r6, (String) r13.getPair().getFirst()) == true) goto L39;
    L41:
        r9 = false;
    L42:
        com.bytedance.android.livesdk.log.filter.o r14 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r14 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L45;
        r14 = null;
    L45:
        com.bytedance.android.livesdk.log.filter.t r15 = (com.bytedance.android.livesdk.log.filter.t) r14;
        if (r15 == null) goto L49;
        String r16 = r15.l();
        if (r16 == null) goto L49;
    L50:
        com.bytedance.android.livesdk.log.filter.o r17 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r17 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L53;
        r17 = null;
    L53:
        com.bytedance.android.livesdk.log.filter.t r18 = (com.bytedance.android.livesdk.log.filter.t) r17;
        if (r18 == null) goto L57;
        String r19 = r18.e();
        if (r19 == null) goto L57;
    L58:
        if (r10 == true) goto L62;
        if (r12 == true) goto L62;
        if (r9 == true) goto L62;
        return;
    L62:
        if (Intrinsics.areEqual(r16, "true") == true) goto L64;
        return;
    L64:
        if (Intrinsics.areEqual(r19, "join_chorus") == false) goto L78;
        RealTimeChorusOperateView r20 = this.t;
        if (r20 == null) goto L68;
        r20.V5("enter room auto join");
    L68:
        com.bytedance.android.livesdk.log.filter.o r21 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r21 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L72;
        r1 = r21;
    L72:
        com.bytedance.android.livesdk.log.filter.t r22 = (com.bytedance.android.livesdk.log.filter.t) r1;
        if (r22 == null) goto L79;
        r22.F("");
        r22.t("");
        return;
    L79:
        return;
    L78:
        return;
    L57:
        r19 = "";
    L49:
        r16 = "";
        goto L50
    L39:
        if (Intrinsics.areEqual(r7, (String) r13.getPair().getSecond()) == false) goto L41;
    L33:
        if (Intrinsics.areEqual(r7, (String) r11.getPair().getSecond()) == false) goto L35;
        r12 = true;
        goto L36
    L27:
        if (Intrinsics.areEqual(r7, (String) r8.getPair().getSecond()) == false) goto L29;
        r10 = true;
    L23:
        r7 = "";
    L19:
        r6 = "";
        goto L20
    L14:
        r5 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1
    public final py.k dp() {
        KtvContext r0 = this.X;
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.profit.dress.t> r1 = r0.getLinkmicRealTimeChorusDress();
        if (r1 == null) goto L18;
        com.bytedance.android.live.profit.dress.t r2 = (com.bytedance.android.live.profit.dress.t) r1.getValue();
        if (r2 == null) goto L18;
        List r3 = r2.c;
        if (r3 == null) goto L18;
        Integer r4 = this.k;
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        com.bytedance.android.live.profit.dress.config.n r6 = (com.bytedance.android.live.profit.dress.config.n) CollectionsKt.getOrNull(r3, r5);
        if (r6 == null) goto L18;
        py.k r7 = r6.getJoinChorusBtnImage();
        if (r7 == null) goto L18;
        return r7;
    L13:
        r5 = 0;
    L18:
        int r8 = qy.a.a;
        return qy.a.a(com.bytedance.android.live.ktv.common.midi.i.a);
    }

    public final void fr() {
        if (this.A != null) goto L5;
    L10:
        Disposable r0 = (Disposable) this.D.getSecond();
        if (r0 != null) goto L13;
        return;
    L13:
        if (r0.isDisposed() == true) goto L17;
        r0.dispose();
        this.D = new Pair(null, null);
        return;
    L17:
        return;
    L5:
        if (Bq() == null) goto L10;
        RecyclableWidgetManager r1 = Bq();
        if (r1 == null) goto L9;
        r1.unload(this.A);
    L9:
        this.A = null;
        this.B = null;
        goto L10
    }

    public final LifecycleOwner getLifecycleOwner() {
        RealTimeChorusBusinessLifecycleOwner r0 = this.G1;
        if ((r0 instanceof LifecycleOwner) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public final void lr() {
        KtvCoreViewModel r0 = this.M;
        KtvMusic r1 = null;
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r2 = r0.getCurState();
    L6:
        int r3 = RealTimeChorusBusinessContext.Companion.b();
        if (r2 == null) goto L11;
        MusicPanel r4 = r2.b();
        if (r4 == null) goto L11;
        boolean r5 = KtvUtilsKt.C(r4);
    L13:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L15;
    L24:
        if (r5 == false) goto L43;
        if (r3 == 1) goto L29;
        if (r3 != 2) goto L43;
    L29:
        if (this.L == false) goto L34;
        this.L = false;
        FrameLayout r6 = this.I;
        if (r6 == null) goto L49;
        fd0.f r7 = LiveAnimator.a(new View[]{r6});
        r7.a();
        LiveAnimator r8 = r7.a;
        r8.b = 200;
        r8.h = new i0(this);
        r7.e();
        return;
    L49:
        return;
    L34:
        if (this.J == null) goto L36;
        return;
    L36:
        if (this.K == true) goto L52;
        this.K = true;
        RealTimeChorusMidiWidget r9 = new RealTimeChorusMidiWidget(this.X, this.x1, this);
        r9.f = new RealTimeChorusMainViewWidget$loadMidiWidget$$inlined$apply$lambda$1(this);
        Unit r10 = Unit.INSTANCE;
        this.J = r9;
        RecyclableWidgetManager r11 = Bq();
        if (r11 == null) goto L40;
        r11.load(2131365693, this.J, true);
    L40:
        RealTimeChorusSingerInfoView r12 = this.r;
        if (r12 == null) goto L53;
        r12.setGetCurUserChorusDataCB(new RealTimeChorusMainViewWidget$loadMidiWidget$3(this));
        return;
    L53:
        return;
    L52:
        return;
    L43:
        MusicPanel r13 = r2.b();
        if (r13 == null) goto L46;
        r1 = r13.a;
    L46:
        er(r1);
        return;
    L15:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L24;
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L24;
        if (r2 == null) goto L23;
        MusicPanel r14 = r2.b();
        if (r14 == null) goto L23;
        r1 = r14.a;
    L23:
        er(r1);
        return;
    L11:
        r5 = true;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void onBizDestory() {
        if (((Boolean) KtvSettingHelper.a.getValue()).booleanValue() == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.put("ktv_chorus_scene_widget", null);
    L8:
        if (this.q == true) goto L73;
        boolean r1 = true;
        this.q = true;
        ALogger.i("RealTimeChorusMainViewWidget", "onBizDestory");
        this.y1.d(new tb0.b.e());
        StringBuilder r4 = new StringBuilder("releaseAllResource ");     // Catch: Exception -> L70
        if (((Widget) this).dataCenter == null) goto L14;
        r1 = false;
    L14:
        r4.append(r1);     // Catch: Exception -> L70
        ALogger.i("RealTimeChorusMainViewWidget", r4.toString());     // Catch: Exception -> L70
        RealTimeChorusBusinessLifecycleOwner r2 = this.G1;     // Catch: Exception -> L70
        if (r2 == null) goto L18;
        r2.a.setCurrentState(Lifecycle.State.DESTROYED);     // Catch: Exception -> L70
    L18:
        if (((Boolean) KtvSettingHelper.i.getValue()).booleanValue() == false) goto L20;
        this.G1 = null;     // Catch: Exception -> L70
        this.p = false;     // Catch: Exception -> L70
    L20:
        Zq();     // Catch: Exception -> L70
        Disposable r3 = this.Z;     // Catch: Exception -> L70
        if (r3 != null) goto L23;
    L25:
        Tq(false);     // Catch: Exception -> L70
        fr();     // Catch: Exception -> L70
        IKtvService r5 = jc1.k.f(IKtvService.class);     // Catch: Exception -> L70
        if (r5 == null) goto L28;
        r5.setKtvContext(null);     // Catch: Exception -> L70
    L28:
        this.X.clearKtvCoreAndSingerViewModel();     // Catch: Exception -> L70
        KtvCoreViewModel r6 = this.M;     // Catch: Exception -> L70
        if (r6 == null) goto L31;
        r6.clearData();     // Catch: Exception -> L70
    L31:
        KtvCoreViewModel r7 = this.M;     // Catch: Exception -> L70
        if (r7 == null) goto L34;
        r7.unregisterKtvCoreListener(this.I2);     // Catch: Exception -> L70
    L34:
        this.M = null;     // Catch: Exception -> L70
        com.bytedance.android.live.ktv.common.util.k r8 = this.X.getStatisticHelper();     // Catch: Exception -> L70
        r8.b.clear();     // Catch: Exception -> L70
        r8.a = null;     // Catch: Exception -> L70
        this.H0.clear();     // Catch: Exception -> L70
        this.L0.clear();     // Catch: Exception -> L70
        this.J2.clear();     // Catch: Exception -> L70
        RTChorusMusicInfoView r9 = this.s;     // Catch: Exception -> L70
        if (r9 == null) goto L37;
        r9.R5();     // Catch: Exception -> L70
        r9.o = null;     // Catch: Exception -> L70
        r9.n.clear();     // Catch: Exception -> L70
    L37:
        FrameLayout r10 = this.F;     // Catch: Exception -> L70
        if (r10 == null) goto L40;
        r10.removeAllViews();     // Catch: Exception -> L70
    L40:
        MvLyricWidget r11 = this.E;     // Catch: Exception -> L70
        if (r11 == null) goto L43;
        r11.i();     // Catch: Exception -> L70
    L43:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r12 = this.Q;     // Catch: Exception -> L70
        if (r12 == null) goto L55;
        View r13 = r12.a;     // Catch: Exception -> L70
        if (r13 == null) goto L50;
        r13.release();     // Catch: Exception -> L70
        ViewGroup r14 = r12.h;     // Catch: Exception -> L70
        if (r14 == null) goto L50;
        r14.removeView(r13);     // Catch: Exception -> L70
    L50:
        View r15 = r12.b;     // Catch: Exception -> L70
        if (r15 == null) goto L55;
        r15.release();     // Catch: Exception -> L70
        ViewGroup r16 = r12.i;     // Catch: Exception -> L70
        if (r16 == null) goto L55;
        r16.removeView(r15);     // Catch: Exception -> L70
    L55:
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.X.getSeiProcessor().getValue()).g(this);     // Catch: Exception -> L70
        MessageHub r17 = this.R;     // Catch: Exception -> L70
        if (r17 == null) goto L58;
        r17.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);     // Catch: Exception -> L70
    L58:
        this.R = null;     // Catch: Exception -> L70
        k r18 = this.m;     // Catch: Exception -> L70
        Disposable r19 = r18.a;     // Catch: Exception -> L70
        if (r19 != null) goto L61;
    L63:
        r18.a = null;     // Catch: Exception -> L70
        if (KtvSettingHelper.r().booleanValue() == false) goto L74;
        RecyclableWidgetManager r20 = this.v1;     // Catch: Exception -> L70
        if (r20 == null) goto L68;
        ((WidgetManager) r20).contentView = null;     // Catch: Exception -> L70
    L68:
        this.v1 = null;     // Catch: Exception -> L70
        ((Widget) this).contentView = null;     // Catch: Exception -> L70
        return;
    L74:
        return;
    L61:
        if (r19.isDisposed() == false) goto L63;
        r19.dispose();     // Catch: Exception -> L70
        goto L63
    L23:
        if (r3.isDisposed() == true) goto L25;
        r3.dispose();     // Catch: Exception -> L70
    L75:
        return;
    }

    public final void onBizEnterRoom() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizEnterRoom");
        if (jc0.a.b(this.a, this.b) == true) goto L6;
        ALogger.i("RealTimeChorusMainViewWidget", "onBizEnterKtvRoom but scene is not ktv or curUILayout is not 61");
        return;
    L6:
        this.X.getStatisticHelper().a();
        runWithRoomEntered(new e(this));
    }

    public final void onBizHide() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizHide");
        this.y1.d(new tb0.b.c());
    }

    public final void onBizLeaveRoom() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizLeaveRoom");
        Yq("onBizLeaveRoom");
        this.y1.d(new tb0.b.b());
        Zq();
    }

    public final void onBizShow() {
        ALogger.i("RealTimeChorusMainViewWidget", "onBizShow");
        this.y1.d(new tb0.b.d());
    }

    public final void onDestroy() {
        ALogger.i("RealTimeChorusMainViewWidget", "onDestroy");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
    }

    public final FrameLayout vj() {
        FrameLayout r0 = this.H;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final void gr() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L9;
        r2.removeMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);
    L9:
        com.bytedance.android.livesdk.chatroom.o r3 = o3.f();
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.j r4 = r3.getMessageManager();
        if (r4 == null) goto L16;
        vlc.d r5 = (vlc.d) r4.getValue();
        if (r5 == null) goto L16;
        r5.removeMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getWsMethod(), this);
    L16:
        com.bytedance.android.livesdk.chatroom.o r6 = o3.f();
        if (r6 == null) goto L24;
        com.bytedance.live.datacontext.j r7 = r6.getMessageManager();
        if (r7 == null) goto L25;
        vlc.d r8 = (vlc.d) r7.getValue();
        if (r8 == null) goto L26;
        r8.removeMessageListener(MessageType.LINK_MIC_BIG_EVENT.getWsMethod(), this);
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        MvLyricWidget r0 = this.E;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final void yq() {
        View r0 = Iq();
        if (r0 == null) goto L6;
        r0.post(new b(this));
        return;
    }

    public final int zq() {
        if (PadConfigUtils.c() == false) goto L5;
    L10:
        int r0 = (int) ((s1.w() * 9.0f) / 16.0f);
        int r1 = this.c;
        if (r1 <= 0) goto L13;
        float r2 = s1.G(Math.min(r0, r1));
    L15:
        return (int) r2;
    L13:
        r2 = s1.G(r0);
        goto L15
    L5:
        if (FoldScreenUtils.e() == true) goto L10;
        if (s1.y() > s1.w()) goto L10;
        r2 = s1.G(s1.y());
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1
    public final List<UserChorusInfo> Ol() {
        return this.U;
    }

    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.K2;
    }

    public final String getTypeName() {
        return this.L2;
    }

    public final ViewModelStore tf() {
        return this.J2;
    }

    public final void Kq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r10) {
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r10.c;
        RealTimeChorusBusinessContext.a r1 = RealTimeChorusBusinessContext.Companion;
        mr(r0, r1.b());
        KtvRoomLyricsStateMachineConfig.d r2 = (KtvRoomLyricsStateMachineConfig.d) r10.c;
        boolean r3 = false;
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L18;
        if (this.y2 == true) goto L10;
        if ((this.y1.a instanceof tb0.c.b) == true) goto L10;
        w.a("RealTimeChorusMainViewWidget", "in feed onKtvStateIdle but not receivered sei");
        return;
    L10:
        if (KtvSettingHelper.w() == false) goto L15;
        if (Qq() == true) goto L15;
        w.a("RealTimeChorusMainViewWidget", "isMusicStopped false");
        return;
    L15:
        if (this.O == true) goto L97;
        pr(0, "onKtvStateIdle");
        mr((KtvRoomLyricsStateMachineConfig.d) r10.c, r1.b());
        return;
    L97:
        return;
    L18:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L55;
        pr(1, "onKtvStatePreparing");
        RealTimeChorusSingerInfoView r4 = this.r;
        if (r4 == null) goto L25;
        String r5 = this.i;
        if (r5 != null) goto L24;
        r5 = "1";
    L24:
        r4.R5(r5, "#00FFE0");
    L25:
        MusicPanel r6 = ((KtvRoomLyricsStateMachineConfig.d) r10.c).b();
        if (r6 == null) goto L48;
        RTChorusMusicInfoView r7 = this.s;
        if (r7 == null) goto L48;
        Object[] r8 = new Object[1];
        KtvMusic r9 = r6.a;
        if (r9 == null) goto L33;
        String r11 = r9.getMTitle();
        if (r11 == null) goto L33;
    L34:
        r8[0] = r11;
        r7.T5(s1.C(2131922308, r8));
        KtvMusic.a r12 = KtvMusic.Companion;
        KtvMusic r13 = r6.a;
        r12.getClass();
        r7.U5(KtvMusic.a.a(r13) * ((long) 1000.0f));
        com.bytedance.android.livesdk.ktvimpl.base.util.j r14 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvMusic r15 = r6.a;
        r14.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r15) == true) goto L38;
        int r16 = 3;
    L47:
        r7.S5(r16);
        goto L48
    L38:
        if (r1.b() != 1) goto L40;
    L42:
        if (r3 == false) goto L44;
    L46:
        r16 = 1;
        goto L47
    L44:
        if (KtvUtilsKt.C(r6) != true) goto L46;
        r16 = 2;
        goto L47
    L40:
        if (r1.b() == 2) goto L42;
        r3 = true;
    L33:
        r11 = "";
    L48:
        this.M1 = ((KtvRoomLyricsStateMachineConfig.d) r10.c).b();
        this.L1 = true;
        Disposable r17 = this.Z;
        if (r17 != null) goto L51;
    L53:
        this.Z = Observable.timer(this.H1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p0(this));
        return;
    L51:
        if (r17.isDisposed() == true) goto L53;
        r17.dispose();
        goto L53
    L55:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L71;
        RTChorusMusicInfoView r18 = this.s;
        if (r18 == null) goto L61;
        if (r18.getCurShowMode() != 0) goto L61;
    L65:
        pr(1, "onKtvStatePaused");
        Object r19 = r10.c;
        if (r19 == null) goto L69;
        lr();
        or(((KtvRoomLyricsStateMachineConfig.d.C0041d) r19).b);
        return;
    L69:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Paused");
    L61:
        if ((r10.a instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L65;
        if ((r10.c instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L65;
        return;
    L71:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L87;
        pr(1, "onKtvStateSinging");
        RTChorusMusicInfoView r20 = this.s;
        if (r20 == null) goto L77;
        if (r20.getCurShowMode() != 0) goto L77;
    L81:
        Object r110 = r10.c;
        if (r110 == null) goto L85;
        lr();
        or(((KtvRoomLyricsStateMachineConfig.d.f) r110).b);
        return;
    L85:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L77:
        if ((r10.a instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L81;
        if ((r10.c instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L81;
        return;
    L87:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L89;
        return;
    L89:
        if (KtvSettingHelper.w() == true) goto L91;
    L93:
        pr(0, "onKtvStateClosed");
        return;
    L91:
        if (Qq() == true) goto L93;
    }

    public final EPointF Mj(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return new EPointF(-1.0f, -1.0f);
    }

    public final void Mq(boolean r7) {
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L6;
        r0.setKtvContext(this.X);
    L6:
        if (r7 == true) goto L31;
        DataCenter r1 = this.k0.getDataCenter();
        com.bytedance.android.live.pushstream.d r2 = null;
        if (r1 == null) goto L23;
        Widget.WidgetCallback r3 = ((Widget) this).widgetCallback;
        if (r3 != null) goto L13;
    L15:
        RecyclableWidgetManager r4 = Bq();
        if (r4 == null) goto L18;
        DataCenter r5 = ((WidgetManager) r4).dataCenter;
    L19:
        if (r5 != null) goto L23;
        RecyclableWidgetManager r6 = Bq();
        if (r6 == null) goto L23;
        ((WidgetManager) r6).dataCenter = r1;
        goto L23
    L18:
        r5 = null;
        goto L19
    L13:
        if (r3.getWidgetManager().dataCenter != null) goto L15;
        ((Widget) this).widgetCallback.getWidgetManager().dataCenter = r1;
    L23:
        Tq(true);
        if (this.k0.isAnchor() == false) goto L31;
        com.bytedance.android.livesdk.chatroom.o r8 = o3.f();
        if (r8 == null) goto L30;
        com.bytedance.live.datacontext.j r9 = r8.getLiveStream();
        if (r9 == null) goto L30;
        r2 = (com.bytedance.android.live.pushstream.d) r9.getValue();
    L30:
        this.V.d = r2;
    L31:
        this.X.getKtvRoomProvider().setValue(this.V);
        if (r7 == true) goto L49;
        if (this.b1.getFirst() != null) goto L41;
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r10 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$initKtvRoomOrderedSongDataContextIfNeed$1.INSTANCE);
        this.b1 = r10;
        OrderedSongDataContext r11 = (OrderedSongDataContext) r10.getFirst();
        if (r11 == null) goto L39;
        com.bytedance.live.datacontext.b.a(r11, KtvModeOrderedSongDataContext.class);
    L39:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L41;
        this.g1 = du2.a.b(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g0(this));
    L41:
        Nq();
        Pq();
        RealTimeChorusBusinessContext r12 = RealTimeChorusBusinessContext.Companion.getContext();
        if (r12 == null) goto L49;
        com.bytedance.live.datacontext.j<fd2.s> r13 = r12.m454getService();
        if (r13 == null) goto L49;
        fd2.s r14 = (fd2.s) r13.getValue();
        if (r14 == null) goto L49;
        r14.Pa();
    L49:
        if (this.M != null) goto L51;
        ALogger.i("RealTimeChorusMainViewWidget", "initKtvCoreViewModel");
        KtvCoreViewModel r15 = new KtvCoreViewModel(this.V, this.k0, this.X);
        r15.getKtvContext().getKtvCoreViewModel().setValue(r15);
        Unit r16 = Unit.INSTANCE;
        this.M = r15;
        r15.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE}), this.I2, true);
    L51:
        if (r7 == true) goto L59;
        if (this.p1 != null) goto L59;
        ALogger.i("RealTimeChorusMainViewWidget", "initKtvSingerViewModel");
        KtvCoreViewModel r17 = this.M;
        if (r17 == null) goto L57;
        this.p1 = new KtvSingerViewModel(this.V, this.k0, r17);
    L57:
        this.X.getKtvSingerViewModel().setValue(this.p1);
    L59:
        if (this.j == true) goto L62;
        this.j = true;
        RxUtilKt.c(this.X.getLinkmicRealTimeChorusDress().a().subscribe(new z(this)), this.L0);
        return;
    }

    public final void Tq(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        if (this.h1 == null) goto L23;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r3 = KtvRoomContext.a.a();
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r4 = r3.getPreviewViewModel();
        if (r4 == null) goto L14;
        r4.setValue(null);
    L14:
        Pair<KtvRoomContext, ? extends Disposable> r5 = this.h1;
        if (r5 == null) goto L19;
        Disposable r6 = (Disposable) r5.getSecond();
        if (r6 == null) goto L19;
        r6.dispose();
    L19:
        this.h1 = null;
        this.X.isKtvRoomContextInit().setValue(Boolean.FALSE);
        return;
    L23:
        return;
    L4:
        if (this.h1 != null) goto L6;
        this.h1 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$loadKtvRoomContext$1.INSTANCE);
        this.X.isKtvRoomContextInit().setValue(Boolean.TRUE);
    }

    public final void Yq(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        MessageHub r1 = this.R;
        if (r1 == null) goto L55;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r2 = this.Q;
        if (r2 == null) goto L55;
        Function2<String, Object, Unit> r3 = new RealTimeChorusMainViewWidget$registerMethods$$inlined$let$lambda$1(this, r10);
        Intrinsics.checkNotNullParameter(r1, "hub");
        Intrinsics.checkNotNullParameter(r10, "source");
        ALogger.i("RealTimeChorusMicHybridCardManager", "registerMethods ;; source == " + r10 + ", " + r2.b);
        r2.d(r1);
        r2.e();
        r2.d.dispose();
        r2.c.dispose();
        r2.c = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c.b(r2.a);
        r2.d = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c.b(r2.b);
        Map<String, Map<String, List<Object>>> r11 = r2.e;
        HybridCard r0 = r2.a;
        if (r0 == null) goto L9;
        Integer r4 = Integer.valueOf(r0.hashCode());
    L10:
        Map r12 = (Map) ((LinkedHashMap) r11).get(String.valueOf(r4));
        if (r12 == null) goto L15;
        Set r13 = r12.keySet();
        if (r13 == null) goto L15;
        r13.clear();
    L15:
        Map<String, Map<String, List<Object>>> r14 = r2.e;
        HybridCard r5 = r2.b;
        if (r5 == null) goto L18;
        Integer r6 = Integer.valueOf(r5.hashCode());
    L19:
        Map r15 = (Map) ((LinkedHashMap) r14).get(String.valueOf(r6));
        if (r15 == null) goto L24;
        Set r16 = r15.keySet();
        if (r16 == null) goto L24;
        r16.clear();
    L24:
        JSONObject r17 = new JSONObject();
        r17.put("eventName", "event_party_ktv_register_wrds");
        HybridCard r7 = r2.a;
        if (r7 == null) goto L27;
        r7.sendJsEvent("event_party_ktv_register_wrds", r17);
    L27:
        HybridCard r8 = r2.b;
        if (r8 == null) goto L30;
        r8.sendJsEvent("event_party_ktv_register_wrds", r17);
    L30:
        r2.c();
        HybridCard r18 = r2.a;
        if (r18 == null) goto L33;
        r18.registerMethod("registerWrds", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.h(r1, r3, String.valueOf(Integer.valueOf(r18.hashCode())), r2.e));
    L33:
        HybridCard r19 = r2.a;
        if (r19 == null) goto L36;
        r19.registerMethod("updateLinkmicStatus", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.j(r2, true));
    L36:
        HybridCard r110 = r2.a;
        if (r110 == null) goto L39;
        r110.registerMethod("reportAggregateALog", com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.i.a);
    L39:
        HybridCard r111 = r2.a;
        if (r111 != null) goto L42;
    L44:
        if (r111 == null) goto L46;
        r111.registerMethod("registerMessage", new RealTimeChorusMicHybridCardManager$registerMethods$2(r2, r1));
    L46:
        HybridCard r112 = r2.a;
        if (r112 == null) goto L49;
        r112.registerMethod("registerMessageLatch", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.e(new DataCenter()));
    L49:
        HybridCard r113 = r2.b;
        if (r113 == null) goto L52;
        r113.registerMethod("registerWrds", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.h(r1, null, String.valueOf(Integer.valueOf(r113.hashCode())), r2.e));
    L52:
        HybridCard r114 = r2.b;
        if (r114 == null) goto L55;
        r114.registerMethod("updateLinkmicStatus", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.j(r2, true));
        goto L55
    L42:
        if ((r111 instanceof AnnieXLiveCard) == false) goto L44;
        r111.registerMethod("registerMessage", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.n(r2, r1));
        goto L46
    L18:
        r6 = null;
        goto L19
    L9:
        r4 = null;
    L55:
        MessageHub r115 = this.R;
        if (r115 == null) goto L59;
        r115.addMessageListener(MessageType.REAL_TIME_CHORUS_MESSAGE.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    public final void ar(String r2) {
        ALogger.i("RealTimeChorusMainViewWidget", "resetChorusDress source: ".concat(r2));
        this.X.getMidiSkinContext().setValue(null);
        this.X.getLinkmicRealTimeChorusDress().setValue(null);
    }

    public final void dr(MusicPanel r5) {
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a.getClass();
        ub0.d r0 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.b(r5);
        w.a("RealTimeChorusMainViewWidget", "sendSingerBeginSing, LyricsReaderHelper.parse");
        pd2.d.n.N(r5);
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L6;
        r6.postDelayed(new h(r0, this), 100);
        return;
    }

    public final void er(KtvMusic r9) {
        RealTimeChorusMidiWidget r0 = this.J;
        if (r0 == null) goto L48;
        String r1 = null;
        r0.f = null;
        int r2 = 0;
        this.K = false;
        this.L = true;
        KtvModeOrderedSongDataContext r3 = Eq();
        if (r3 == null) goto L13;
        List<MusicPanel> r4 = r3.m200getKtvSingSongList();
        if (r4 == null) goto L13;
        MusicPanel r5 = (MusicPanel) KtvUtilsKt.K(r4, 0);
        if (r5 == null) goto L13;
        RealTimeChorusInfo r6 = r5.C;
        if (r6 == null) goto L13;
        Long r7 = Long.valueOf(r6.getChorusID());
    L14:
        RealTimeChorusMidiWidget r8 = this.J;
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a r10 = r8.j;
        if (r10 == null) goto L19;
        r1 = r10.b;
    L19:
        long r11 = d5.c(r1);
        if (r7 != null) goto L23;
    L34:
        FrameLayout r12 = this.I;
        if (r12 == null) goto L37;
        fd0.f r13 = LiveAnimator.a(new View[]{r12});
        r13.b();
        LiveAnimator r14 = r13.a;
        r14.b = 200;
        r14.i = new i(this);
        r13.e();
    L37:
        RTChorusMusicInfoView r15 = this.s;
        if (r15 == null) goto L49;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r9) == true) goto L43;
        r2 = 3;
    L46:
        r15.S5(r2);
        return;
    L43:
        if (this.W == 0) goto L46;
        r2 = 1;
        goto L46
    L49:
        return;
    L23:
        if (r11 != r7.longValue()) goto L34;
        RealTimeChorusMidiWidget r16 = this.J;
        double r17 = 0.0d;
        if (r16 == null) goto L27;
        double r18 = r16.wq();
    L28:
        this.P1 = r18;
        RealTimeChorusMidiWidget r19 = this.J;
        if (r19 == null) goto L33;
        RealTimeChorusMidiViewModel r20 = r19.b;
        if (r20 == null) goto L33;
        r17 = r20.getTotalScore();
    L33:
        this.Q1 = r17;
        goto L34
    L27:
        r18 = 0.0d;
    L13:
        r7 = null;
        goto L14
    }

    public final void hr(boolean r5) {
        RealTimeChorusSingerInfoView r0 = this.r;
        int r1 = 0;
        if (r0 == null) goto L23;
        if (r5 == false) goto L14;
        ImageView r2 = r0.i;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        View r3 = r0.g;
        if (r3 == null) goto L11;
        r3.setVisibility(8);
    L11:
        TextView r4 = r0.h;
        if (r4 == null) goto L23;
        r4.setVisibility(8);
        goto L23
    L14:
        ImageView r6 = r0.i;
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        View r7 = r0.g;
        if (r7 == null) goto L20;
        r7.setVisibility(0);
    L20:
        TextView r8 = r0.h;
        if (r8 == null) goto L23;
        r8.setVisibility(0);
    L23:
        RTChorusMusicInfoView r9 = this.s;
        if (r9 == null) goto L31;
        TextView r10 = r9.h;
        if (r10 == null) goto L32;
        if (r5 == false) goto L29;
        r1 = 4;
    L29:
        r10.setVisibility(r1);
        return;
    L32:
        return;
    }

    public final void jr(sb0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        ALogger.i("logKtvMainPath", ("updateDataEntity:" + r4) + ", invoke class :RealTimeChorusMainViewWidget");
        sb0.a r0 = this.p0;
        r0.getClass();
        ALogger.i("DataEntityInvocationHandler", "dataEntity change:" + r4);
        r0.a = r4;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == 135538046) goto L12;
        return;
    L12:
        if (r0.equals("data_dynamic_show_emoji_panel") == false) goto L20;
        String r6 = (String) r5.getData();
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r1 == null) goto L21;
        r1.openEmojiDialog(r6, "dynamic");
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        if (FoldScreenUtils.f() == true) goto L5;
    L9:
        yq();
        return;
    L5:
        if (FoldScreenUtils.c(r3) == 0) goto L9;
        View r4 = Iq();
        if (r4 == null) goto L9;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        r0.height = -1;
        r0.width = -1;
        r4.setTranslationX(0.0f);
        r4.setLayoutParams(r0);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget
    public final void onLoad(Object[] r5) {
        super.onLoad(r5);
        ALogger.i("RealTimeChorusMainViewWidget", "onLoad");
        Function2<? super Boolean, ? super Long, Unit> r6 = this.K2;
        if (r6 == null) goto L5;
        Unit r7 = (Unit) r6.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L5:
        RecyclableWidgetManager r8 = this.v1;
        if (r8 != null) goto L8;
    L9:
        Fragment r0 = null;
        if (KtvSettingHelper.i() == false) goto L50;
        Context r9 = ((Widget) this).context;
        if ((r9 instanceof FragmentActivity) == true) goto L14;
        r9 = null;
    L14:
        Activity r10 = (FragmentActivity) r9;
        if (r10 != null) goto L19;
        r10 = com.bytedance.android.live.core.utils.a.d();
    L19:
        if ((r10 instanceof FragmentActivity) == true) goto L21;
        r10 = null;
    L21:
        FragmentActivity r11 = (FragmentActivity) r10;
        Fragment r1 = com.bytedance.android.livesdk.ktvimpl.base.util.d.a(r11);
        if (r1 != null) goto L24;
    L26:
        if (r11 != null) goto L28;
    L30:
        if (r1 == null) goto L43;
        FragmentManager r12 = r1.getChildFragmentManager();
        if (r12 == null) goto L43;
        List r13 = r12.getFragments();
        if (r13 == null) goto L43;
        Iterator r14 = r13.iterator();
    L37:
        if (r14.hasNext() == false) goto L41;
        Object r2 = r14.next();
        if ((((Fragment) r2) instanceof RecyclableWidgetManager) == false) goto L37;
    L42:
        Fragment r3 = (Fragment) r2;
    L45:
        if ((r3 instanceof RecyclableWidgetManager) == false) goto L48;
        r0 = r3;
    L48:
        RecyclableWidgetManager r15 = (RecyclableWidgetManager) r0;
    L49:
        this.v1 = r15;
    L62:
        Rq();
        Pair r16 = com.bytedance.live.datacontext.d.a(RealTimeChorusMainViewWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r4 = (AdminInviteAndApplyViewModel) r16.component1();
        Disposable r17 = (Disposable) r16.component2();
        com.bytedance.live.datacontext.b.a(r4, "AdminInviteAndApplyViewModel");
        this.H0.add(r17);
        return;
    L41:
        r2 = null;
    L43:
        r3 = null;
        goto L45
    L28:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r11.getSupportFragmentManager()) == true) goto L30;
        r15 = RecyclableWidgetManager.ha0(r11, ((Widget) this).contentView);
        goto L49
    L24:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r1.getChildFragmentManager()) == true) goto L26;
        r15 = RecyclableWidgetManager.ga0(r1, ((Widget) this).contentView);
        goto L49
    L50:
        Fragment r18 = ((Widget) this).context;
        if ((r18 instanceof FragmentActivity) == true) goto L53;
        r18 = null;
    L53:
        Fragment r19 = (FragmentActivity) r18;
        if (r19 != null) goto L58;
        r19 = com.bytedance.android.live.core.utils.a.d();
    L58:
        if ((r19 instanceof FragmentActivity) == false) goto L61;
        r0 = r19;
    L61:
        this.v1 = RecyclableWidgetManager.ha0((FragmentActivity) r0, ((Widget) this).contentView);
        goto L62
    L8:
        if (r8.isDetached() != true) goto L62;
        goto L9
    }

    public final void onMessage(tlc.d r35) {
        boolean r2 = r35 instanceof jd;
        String r4 = BDLocationException.ERROR_TIMEOUT;
        boolean r10 = false;
        if (r2 == false) goto L71;
        jd r1 = (jd) r35;
        Integer r3 = r1.getMsgType();
        if (r3 != null) goto L8;
    L49:
        if (r3 != null) goto L52;
        return;
    L52:
        if (r3.intValue() != 6) goto L491;
        StringBuilder r5 = new StringBuilder("KtvChorusActionMessage ;; onMessage messageType = ");
        r5.append(r1.getMsgType());
        r5.append(" ;; messageId = ");
        r5.append(r1.getMessageId());
        r5.append(" ;; stage = ");
        q2 r6 = r1.getInitContent();
        if (r6 == null) goto L58;
        aj r7 = r6.a();
        if (r7 == null) goto L58;
        Integer r8 = r7.c();
    L59:
        r5.append(r8);
        ALogger.i("RealTimeChorusMainViewWidget", r5.toString());
        q2 r9 = r1.getInitContent();
        if (r9 == null) goto L492;
        aj r11 = r9.a();
        if (r11 == null) goto L493;
        this.i = "1";
        RealTimeChorusSingerInfoView r12 = this.r;
        if (r12 == null) goto L66;
        r12.R5("1", "#00FFE0");
    L66:
        RealTimeChorusSingerInfoView r13 = this.r;
        if (r13 == null) goto L69;
        r13.S5(BDLocationException.ERROR_TIMEOUT);
    L69:
        nr(r11, false);
        return;
    L493:
        return;
    L492:
        return;
    L58:
        r8 = null;
        goto L59
    L491:
        return;
    L8:
        if (r3.intValue() != 3) goto L49;
        StringBuilder r14 = new StringBuilder("KtvChorusActionMessage ;; onMessage messageType = ");
        r14.append(r1.getMsgType());
        r14.append(" ;; messageId = ");
        r14.append(r1.getMessageId());
        r14.append(" ;; stage = ");
        x2 r15 = r1.getStageUpdateContent();
        if (r15 == null) goto L14;
        aj r16 = r15.a();
        if (r16 == null) goto L14;
        Integer r17 = r16.c();
    L15:
        r14.append(r17);
        ALogger.i("RealTimeChorusMainViewWidget", r14.toString());
        x2 r18 = r1.getStageUpdateContent();
        if (r18 == null) goto L486;
        aj r19 = r18.a();
        if (r19 == null) goto L487;
        nr(r19, false);
        x2 r20 = r1.getStageUpdateContent();
        if (r20 == null) goto L22;
        List r21 = r20.b();
    L23:
        JSONObject r22 = new JSONObject();
        r22.put("stage", r19.c());
        Long r23 = r19.a();
        if (r23 == null) goto L26;
        r22.put("chorus_id", String.valueOf(r23.longValue()));
    L26:
        List r24 = r21;
        if (r24 != null) goto L29;
    L30:
        r10 = true;
    L31:
        if (r10 == true) goto L44;
        JSONArray r25 = new JSONArray();
        Iterator r26 = r21.iterator();
    L34:
        if (r26.hasNext() == false) goto L43;
        User r27 = (User) r26.next();
        JSONObject r28 = new JSONObject();
        r28.put("uid", r27.getIdStr());
        if (r27.getAvatarThumb() == null) goto L42;
        ImageModel r29 = r27.getAvatarThumb();
        if (r29 == null) goto L40;
        String r30 = KtvUtilsKt.g(r29);
    L41:
        r28.put("avatar_url", r30);
        goto L42
    L40:
        r30 = null;
    L42:
        r25.put(r28);
        goto L34
    L43:
        r22.put("user_list", r25);
    L44:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r31 = this.Q;
        if (r31 == null) goto L488;
        Intrinsics.checkNotNullParameter(r22, "jsonObject");
        HybridCard r32 = r31.a;
        if (r32 == null) goto L489;
        r32.sendJsEvent("event_ktv_chorus_effect_change", r22);
        return;
    L489:
        return;
    L488:
        return;
    L29:
        if (r24.isEmpty() == false) goto L31;
    L22:
        r21 = null;
        goto L23
    L487:
        return;
    L486:
        return;
    L14:
        r17 = null;
        goto L15
    L71:
        if ((r35 instanceof kd) == false) goto L409;
        if (this.h2 != 0) goto L84;
        sb0.b r33 = this.k0;
        if (r33 == null) goto L77;
        sb0.e r34 = r33.b();
    L78:
        if (r34 == null) goto L84;
        if (this.k0.isAnchor() == true) goto L84;
        this.h2++;
        if (((kd) r35).getMsgType() != 1) goto L84;
        return;
    L77:
        r34 = null;
    L84:
        kd r36 = (kd) r35;
        if (r36.getMsgType() == 1) goto L91;
        aj r37 = r36.E();
        if (r37 == null) goto L89;
        Long r38 = r37.a();
    L90:
        this.h = r38;
        goto L91
    L89:
        r38 = null;
    L91:
        long r110 = r36.getMsgType();
        if (r110 != 1) goto L362;
        u2 r39 = r36.H();
        if (r39 == null) goto L96;
        List r40 = r39.c();
    L98:
        if (((Boolean) KtvSettingHelper.v.getValue()).booleanValue() == false) goto L109;
        aj r111 = r36.E();
        if (r111 == null) goto L102;
        Long r41 = r111.a();
    L104:
        if (Intrinsics.areEqual(r41, this.h) == false) goto L113;
        if (r40 == null) goto L113;
        if ((!r40.isEmpty()) != true) goto L113;
    L112:
        boolean r42 = true;
    L114:
        if (r42 == false) goto L348;
        u2 r43 = r36.H();
        KtvCoreViewModel r44 = this.M;
        if (r44 == null) goto L121;
        KtvRoomLyricsStateMachineConfig.d r45 = r44.getCurState();
        if (r45 == null) goto L121;
        MusicPanel r46 = r45.b();
        if (r46 == null) goto L121;
    L127:
        if (r46 == null) goto L129;
    L131:
        if (r43 == null) goto L133;
        long r112 = r43.b();
    L134:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r47 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        if (r43 == null) goto L139;
        Long r113 = r43.d();
        if (r113 == null) goto L139;
        long r114 = r113.longValue();
    L140:
        Long r115 = Long.valueOf(r114);
        r47.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.e(r115) == false) goto L348;
        RealTimeChorusFeedBackView r48 = this.N;
        if (r48 == null) goto L341;
        double r116 = Gq();
        if (r43 == null) goto L341;
        List r49 = r43.c();
        if (r49 == null) goto L341;
        if (r49.isEmpty() == true) goto L341;
        com.bytedance.android.livesdk.user.e r117 = jc1.k.n(IMiddlewareUserService.class).user();
        Iterator r118 = r49.iterator();
    L155:
        if (r118.hasNext() == false) goto L164;
        Object r119 = r118.next();
        w2 r210 = ((t2) r119).c();
        if (r210 == null) goto L159;
        String r50 = r210.b();
    L161:
        if (Intrinsics.areEqual(r50, r117.n()) == false) goto L155;
    L165:
        t2 r120 = (t2) r119;
        long r310 = r112;
        if (r116 <= 0) goto L172;
        if (r120 != null) goto L172;
        final t2 r121 = new t2();
        w2 r122 = new w2();
        r122.d(r117.n());
        r122.c(r117.b().getAvatarThumbKt());
        Unit r123 = Unit.INSTANCE;
        r121.f(r122);
        r121.d(String.valueOf(r116));
        int r124 = CollectionsKt.binarySearch$default(r49, 0, 0, new RealTimeChorusFeedBackView$insertAndGetRank$index$1(r121), 3, null);
        if (r124 >= 0) goto L171;
        r124 = (-r124) - 1;
    L171:
        ListProtector.add(r49, r124, r121);
        int r51 = 1;
        r121.e(r124 + 1);
        r120 = r121;
    L173:
        TextView r125 = r48.o;
        if (r125 == null) goto L176;
        Object[] r126 = new Object[r51];
        r126[0] = r43.e();
        r125.setText(s1.C(2131922300, r126));
    L176:
        TextView r127 = r48.p;
        if (r127 == null) goto L190;
        if (r120 == null) goto L184;
        Object[] r128 = new Object[2];
        r128[0] = Long.valueOf(r120.b());
        Long r129 = r43.f();
        if (r129 == null) goto L182;
        long r130 = r129.longValue();
    L183:
        r128[1] = Long.valueOf(r130);
        String r131 = s1.C(2131921862, r128);
    L189:
        r127.setText(r131);
        goto L190
    L182:
        r130 = 0;
        goto L183
    L184:
        Object[] r132 = new Object[1];
        Long r133 = r43.f();
        if (r133 == null) goto L187;
        long r134 = r133.longValue();
    L188:
        r132[0] = Long.valueOf(r134);
        r131 = s1.C(2131921861, r132);
        goto L189
    L187:
        r134 = 0;
    L190:
        TextView r135 = r48.n;
        if (r135 == null) goto L196;
        String r52 = r43.a();
        if (r52 == null) goto L195;
        r4 = r52;
    L195:
        r135.setText(r4);
    L196:
        TextView r53 = r48.n;
        if (r53 == null) goto L199;
        CharSequence r54 = r53.getText();
    L200:
        String r55 = String.valueOf(r54);
        Intrinsics.checkNotNullParameter(r55, "score");
        HashMap r136 = new HashMap();
        xe2.h.a(r136);
        xe2.h.c(r136);
        r136.put("score", r55);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chorus_end_info_show", r136, new Object[]{IRoom.class, am2.x.class});
        HSImageView r56 = r48.a;
        if (r56 == null) goto L203;
        r56.setVisibility(8);
    L203:
        HSImageView r57 = r48.b;
        if (r57 == null) goto L206;
        r57.setVisibility(8);
    L206:
        HSImageView r58 = r48.c;
        if (r58 == null) goto L209;
        r58.setVisibility(8);
    L209:
        HSImageView r59 = r48.d;
        if (r59 == null) goto L212;
        r59.setVisibility(8);
    L212:
        HSImageView r60 = r48.e;
        if (r60 == null) goto L215;
        r60.setVisibility(8);
    L215:
        HSImageView r61 = r48.f;
        if (r61 == null) goto L218;
        r61.setVisibility(8);
    L218:
        HSImageView r62 = r48.g;
        if (r62 == null) goto L221;
        r62.setVisibility(8);
    L221:
        ImageView r63 = r48.h;
        if (r63 == null) goto L224;
        r63.setVisibility(8);
    L224:
        ImageView r64 = r48.i;
        if (r64 == null) goto L227;
        r64.setVisibility(8);
    L227:
        ImageView r65 = r48.j;
        if (r65 == null) goto L230;
        r65.setVisibility(8);
    L230:
        TextView r66 = r48.k;
        if (r66 == null) goto L233;
        r66.setVisibility(8);
    L233:
        TextView r67 = r48.l;
        if (r67 == null) goto L236;
        r67.setVisibility(8);
    L236:
        TextView r68 = r48.m;
        if (r68 == null) goto L239;
        r68.setVisibility(8);
    L239:
        t2 r69 = (t2) KtvUtilsKt.K(r49, 0);
        if (r69 == null) goto L251;
        w2 r70 = r69.c();
        if (r70 == null) goto L251;
        py.k r71 = r70.a();
        if (r71 == null) goto L251;
        ImageUtil.loadRoundImage(r48.a, r71);
        HSImageView r72 = r48.a;
        if (r72 == null) goto L248;
        r72.setVisibility(0);
    L248:
        ImageView r73 = r48.h;
        if (r73 == null) goto L251;
        r73.setVisibility(0);
    L251:
        t2 r74 = (t2) KtvUtilsKt.K(r49, 1);
        if (r74 == null) goto L263;
        w2 r75 = r74.c();
        if (r75 == null) goto L263;
        py.k r76 = r75.a();
        if (r76 == null) goto L263;
        ImageUtil.loadRoundImage(r48.b, r76);
        HSImageView r77 = r48.b;
        if (r77 == null) goto L260;
        r77.setVisibility(0);
    L260:
        ImageView r78 = r48.i;
        if (r78 == null) goto L263;
        r78.setVisibility(0);
    L263:
        t2 r79 = (t2) KtvUtilsKt.K(r49, 2);
        if (r79 == null) goto L275;
        w2 r80 = r79.c();
        if (r80 == null) goto L275;
        py.k r81 = r80.a();
        if (r81 == null) goto L275;
        ImageUtil.loadRoundImage(r48.c, r81);
        HSImageView r82 = r48.c;
        if (r82 == null) goto L272;
        r82.setVisibility(0);
    L272:
        ImageView r83 = r48.j;
        if (r83 == null) goto L275;
        r83.setVisibility(0);
    L275:
        t2 r85 = (t2) KtvUtilsKt.K(r49, 3);
        if (r85 == null) goto L284;
        w2 r86 = r85.c();
        if (r86 == null) goto L284;
        py.k r87 = r86.a();
        if (r87 == null) goto L284;
        ImageUtil.loadRoundImage(r48.d, r87);
        HSImageView r88 = r48.d;
        if (r88 == null) goto L284;
        r88.setVisibility(0);
    L284:
        t2 r89 = (t2) KtvUtilsKt.K(r49, 4);
        if (r89 == null) goto L293;
        w2 r90 = r89.c();
        if (r90 == null) goto L293;
        py.k r91 = r90.a();
        if (r91 == null) goto L293;
        ImageUtil.loadRoundImage(r48.e, r91);
        HSImageView r92 = r48.e;
        if (r92 == null) goto L293;
        r92.setVisibility(0);
    L293:
        t2 r93 = (t2) KtvUtilsKt.K(r49, 5);
        if (r93 == null) goto L302;
        w2 r94 = r93.c();
        if (r94 == null) goto L302;
        py.k r95 = r94.a();
        if (r95 == null) goto L302;
        ImageUtil.loadRoundImage(r48.f, r95);
        HSImageView r96 = r48.f;
        if (r96 == null) goto L302;
        r96.setVisibility(0);
    L302:
        t2 r97 = (t2) KtvUtilsKt.K(r49, 6);
        if (r97 == null) goto L311;
        w2 r98 = r97.c();
        if (r98 == null) goto L311;
        py.k r99 = r98.a();
        if (r99 == null) goto L311;
        ImageUtil.loadRoundImage(r48.g, r99);
        HSImageView r100 = r48.g;
        if (r100 == null) goto L311;
        r100.setVisibility(0);
    L311:
        t2 r101 = (t2) KtvUtilsKt.K(r49, 0);
        if (r101 == null) goto L321;
        String r102 = r101.a();
        if (r102 == null) goto L321;
        TextView r137 = r48.k;
        if (r137 == null) goto L318;
        r137.setText(s1.C(2131921860, new Object[]{r102}));
    L318:
        TextView r103 = r48.k;
        if (r103 == null) goto L321;
        r103.setVisibility(0);
    L321:
        t2 r104 = (t2) KtvUtilsKt.K(r49, 1);
        if (r104 == null) goto L331;
        String r138 = r104.a();
        if (r138 == null) goto L331;
        TextView r139 = r48.l;
        if (r139 == null) goto L328;
        r139.setText(s1.C(2131921860, new Object[]{r138}));
    L328:
        TextView r105 = r48.l;
        if (r105 == null) goto L331;
        r105.setVisibility(0);
    L331:
        t2 r106 = (t2) KtvUtilsKt.K(r49, 2);
        if (r106 == null) goto L342;
        String r107 = r106.a();
        if (r107 == null) goto L342;
        TextView r108 = r48.m;
        if (r108 == null) goto L338;
        r108.setText(s1.C(2131921860, new Object[]{r107}));
    L338:
        TextView r109 = r48.m;
        if (r109 == null) goto L342;
        r109.setVisibility(0);
    L342:
        StringBuilder r140 = new StringBuilder("showFeedBackView duration ");
        long r141 = r310;
        r140.append(r141);
        pr(2, r140.toString());
        Disposable r142 = this.Y;
        if (r142 != null) goto L345;
    L347:
        w.a("RealTimeChorusMainViewWidget", "showFeedBackView start timer");
        this.Y = Observable.timer(r141, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new u0(this), new v0(this), w0.a);
        goto L348
    L345:
        if (r142.isDisposed() == true) goto L347;
        r142.dispose();
        goto L347
    L199:
        r54 = null;
    L172:
        r51 = 1;
        goto L173
    L159:
        r50 = null;
        goto L161
    L164:
        r119 = null;
    L341:
        r310 = r112;
    L139:
        r114 = 0;
        goto L140
    L133:
        r112 = 5;
        goto L134
    L129:
        if (this.n != 0) goto L131;
        w.a("RealTimeChorusMainViewWidget", "showFeedBackView music is null so return");
    L121:
        KtvModeOrderedSongDataContext r143 = Eq();
        if (r143 == null) goto L126;
        List<MusicPanel> r144 = r143.m200getKtvSingSongList();
        if (r144 == null) goto L126;
        r46 = (MusicPanel) KtvUtilsKt.K(r144, 0);
    L126:
        r46 = null;
    L348:
        StringBuilder r145 = new StringBuilder("show feedback view : rank count = ");
        u2 r146 = r36.H();
        if (r146 == null) goto L353;
        List r147 = r146.c();
        if (r147 == null) goto L353;
        Integer r148 = Integer.valueOf(r147.size());
    L354:
        r145.append(r148);
        r145.append(" ;; lastChorusId = ");
        r145.append(this.h);
        r145.append(" ;; chorusId = ");
        aj r149 = r36.E();
        if (r149 == null) goto L357;
        Long r150 = r149.a();
    L358:
        r145.append(r150);
        w.a("RealTimeChorusMainViewWidget", r145.toString());
        u2 r151 = r36.H();
        if (r151 == null) goto L387;
        this.H1 = r151.b() * ((long) 1000);
    L387:
        Intrinsics.checkNotNullParameter(r36, "message");
        if (this.T1.contains(Long.valueOf(r36.getMsgType())) == true) goto L390;
    L394:
        boolean r152 = false;
    L395:
        if (r152 == false) goto L495;
        this.p2 = true;
        if (r36.getMsgType() != 2) goto L401;
        aj r153 = r36.E();
        if (r153 == null) goto L401;
        r153.d(Integer.valueOf(RealTimeChorusStage.RealTimeChorusStage_Normal.getValue()));
    L401:
        StringBuilder r154 = new StringBuilder("KtvChorusMessage ;; onMessage messageType = ");
        r154.append(r36.getMsgType());
        r154.append(" ;; messageId = ");
        r154.append(r36.getMessageId());
        r154.append(" ;; stage = ");
        aj r155 = r36.E();
        if (r155 == null) goto L404;
        Integer r156 = r155.c();
    L405:
        r154.append(r156);
        ALogger.i("RealTimeChorusMainViewWidget", r154.toString());
        aj r157 = r36.E();
        if (r157 == null) goto L496;
        nr(r157, false);
        return;
    L496:
        return;
    L404:
        r156 = null;
        goto L405
    L495:
        return;
    L390:
        if (((Widget) this).dataCenter != null) goto L392;
    L393:
        r152 = true;
        goto L395
    L392:
        if (this.p2 == true) goto L394;
    L357:
        r150 = null;
    L353:
        r148 = null;
    L113:
        r42 = false;
        goto L114
    L102:
        r41 = null;
        goto L104
    L109:
        if (r40 == null) goto L113;
        if ((!r40.isEmpty()) != true) goto L113;
    L96:
        r40 = null;
        goto L98
    L362:
        if (r110 != 3) goto L387;
        z2 r158 = r36.G();
        if (r158 == null) goto L380;
        String r159 = r158.d();
        if (r159 == null) goto L380;
        if (this.W == 0) goto L377;
        ConstraintLayout r160 = this.r;
        if (r160 != null) goto L372;
    L374:
        RealTimeChorusSingerInfoView r161 = this.r;
        if (r161 == null) goto L377;
        r161.setSelfVisibility(0);
        goto L377
    L372:
        if (r160.getVisibility() != 0) goto L374;
    L377:
        this.i = r159;
        RealTimeChorusSingerInfoView r162 = this.r;
        if (r162 == null) goto L380;
        r162.R5(r159, Fq());
    L380:
        z2 r163 = r36.G();
        if (r163 == null) goto L387;
        String r164 = r163.b();
        if (r164 == null) goto L387;
        RealTimeChorusSingerInfoView r165 = this.r;
        if (r165 == null) goto L387;
        r165.S5(r164);
        goto L387
    L409:
        if ((r35 instanceof LinkMicBigEventMessage) == false) goto L498;
        LinkMicBigEventMessage r166 = (LinkMicBigEventMessage) r35;
        int r167 = 100;
        switch(r166.msgType) {
            case 7: goto L473;
            case 8: goto L470;
            case 9: goto L445;
            case 10: goto L435;
            case 11: goto L512;
            case 12: goto L413;
            default: goto L512;
        };
    L413:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r168 = KSongTuningPanelHelperKt.d();
        if (r168 == null) goto L499;
        com.bytedance.live.datacontext.m r169 = o3.f().getRoom();
        if (r169 == null) goto L420;
        IRoom r170 = (IRoom) r169.getValue();
        if (r170 == null) goto L420;
        long r211 = r170.getRoomId();
    L421:
        float r171 = 100;
        float r172 = (r168.X() / r168.M()) * r171;
        float r173 = (r168.V() / r168.D()) * r171;
        float r174 = (r168.e() / r168.w()) * r171;
        if (r168.R() == false) goto L424;
        long r311 = 1;
    L426:
        if ((r168 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L428;
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r175 = null;
    L429:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r176 = r175;
        if (r176 == null) goto L433;
        String r177 = r176.T();
        if (r177 == null) goto L433;
    L434:
        RxUtilKt.c(((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).reportTunningInfo(r211, (long) r174, (long) r172, (long) r173, 2, r311, r177).compose(RxUtil.rxSchedulerHelper()).subscribe(f.a, g.a), this.H0);
        return;
    L433:
        r177 = "none";
        goto L434
    L428:
        r175 = r168;
        goto L429
    L424:
        r311 = 2;
    L420:
        r211 = 0;
        goto L421
    L499:
        return;
    L435:
        RealTimeChorusOperateView r178 = this.t;
        if (r178 != null) goto L438;
        return;
    L438:
        if (r178.getJoinBtnStatus() != 1) goto L502;
        RealTimeChorusOperateView r179 = this.t;
        if (r179 == null) goto L503;
        RealtimeChorusProgressImageView r180 = r179.getChorusContainer();
        if (r180 == null) goto L504;
        r180.performClick();
        return;
    L504:
        return;
    L503:
        return;
    L502:
        return;
    L470:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r181 = KSongTuningPanelHelperKt.d();
        if (r181 == null) goto L508;
        r181.setTuningEffect(r166.getSwitch_tuning_effect_content().to_effect_name);
        return;
    L508:
        return;
    L473:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r182 = KSongTuningPanelHelperKt.d();
        if (r182 != null) goto L476;
        return;
    L476:
        if (r166.getSwitch_full_song_status_content().to_status != 1) goto L478;
        boolean r183 = true;
    L479:
        r182.q(r183, false);
        return;
    L478:
        r183 = false;
        goto L479
    L512:
        return;
    L445:
        if (this.F2 == null) goto L447;
    L450:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r184 = KSongTuningPanelHelperKt.d();
        if (r184 == null) goto L453;
        int r185 = r184.M();
    L454:
        float r186 = 100;
        float r187 = (r185 * r166.switch_song_volume_content.accompaniment_volume()) / r186;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r188 = KSongTuningPanelHelperKt.d();
        if (r188 == null) goto L457;
        r188.e0(r187);
    L457:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r189 = KSongTuningPanelHelperKt.d();
        if (r189 == null) goto L460;
        int r190 = r189.w();
    L461:
        float r191 = (r190 * r166.switch_song_volume_content.singer_volume()) / r186;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r192 = KSongTuningPanelHelperKt.d();
        if (r192 == null) goto L464;
        r192.m(r191, false, true);
    L464:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r193 = KSongTuningPanelHelperKt.d();
        if (r193 == null) goto L467;
        r167 = r193.D();
    L467:
        float r194 = (r167 * r166.switch_song_volume_content.chorus_singers_volume()) / r186;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r195 = KSongTuningPanelHelperKt.d();
        if (r195 == null) goto L506;
        r195.j(r194);
        return;
    L506:
        return;
    L460:
        r190 = 100;
        goto L461
    L453:
        r185 = 100;
        goto L454
    L447:
        if (KSongTuningPanelHelperKt.d() == null) goto L450;
        n1 r196 = new n1();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r197 = KSongTuningPanelHelperKt.d();
        Intrinsics.checkNotNull(r197);
        r196.a = r197.e();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r198 = KSongTuningPanelHelperKt.d();
        Intrinsics.checkNotNull(r198);
        r196.b = r198.X();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r199 = KSongTuningPanelHelperKt.d();
        Intrinsics.checkNotNull(r199);
        r196.c = r199.V();
        Unit r200 = Unit.INSTANCE;
        this.F2 = r196;
        goto L450
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r12) {
        Intrinsics.checkNotNullParameter(r12, "result");
        this.E2 = r12;
        KtvRoomLyricsStateMachineConfig.d r1 = null;
        if ((r12.b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.r) == true) goto L81;
    L27:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r12.b;
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L65;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r2 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r0).w();
        String r3 = "";
        if (r2 == null) goto L33;
        String r4 = r2.g();
        if (r4 == null) goto L33;
    L34:
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r5 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r12.b).w();
        if (r5 == null) goto L38;
        String r6 = r5.h();
        if (r6 == null) goto L38;
    L39:
        long r7 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r12.b).j();
        if (StringUtils.isEmpty(r4) == true) goto L55;
        Object[] r8 = new Object[1];
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r9 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r12.b).w();
        if (r9 == null) goto L47;
        String r10 = r9.g();
        if (r10 == null) goto L47;
        r3 = r10;
    L47:
        r8[0] = r3;
        String r11 = s1.C(2131922308, r8);
        RTChorusMusicInfoView r13 = this.s;
        if (r13 == null) goto L51;
        r13.T5(r11);
    L51:
        if (r7 == 0) goto L53;
        String r14 = String.valueOf(r7);
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        xe2.h.g = r14;
    L53:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        xe2.h.f = r4;
    L55:
        if (this.n == r7) goto L57;
    L59:
        boolean r15 = false;
    L60:
        if (r15 == true) goto L65;
        this.n = r7;
        this.o = r6;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r16 = this.Q;
        if (r16 == null) goto L65;
        r16.g(r4, String.valueOf(r7));
        goto L65
    L57:
        if (Intrinsics.areEqual(this.o, r6) == false) goto L59;
        r15 = true;
    L38:
        r6 = "";
    L33:
        r4 = "";
    L65:
        if (this.y2 == true) goto L67;
        this.y2 = true;
    L67:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r17 = this.G;
        if (r17 == null) goto L71;
        r17.onSeiResult(r12);
    L71:
        if (KtvSettingHelper.w() == true) goto L73;
        return;
    L73:
        if (Qq() == false) goto L87;
        KtvCoreViewModel r18 = this.M;
        if (r18 == null) goto L78;
        r1 = r18.getCurState();
    L78:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L88;
        pr(0, "onKtvStateIdle");
        return;
    L88:
        return;
    L87:
        return;
    L81:
        sb0.b r19 = this.k0;     // Catch: Exception -> L26
        if (r19 == null) goto L7;
        String r20 = r19.f();     // Catch: Exception -> L26
    L9:
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.r) r12.b).b() == null) goto L27;
        Iterator r21 = ((ArrayList) this.U).iterator();     // Catch: Exception -> L26
    L12:
        if (r21.hasNext() == false) goto L16;
        Object r22 = r21.next();     // Catch: Exception -> L26
        if (Intrinsics.areEqual(String.valueOf(((UserChorusInfo) r22).getUserId()), r20) == false) goto L12;
    L17:
        if (r22 != null) goto L27;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r23 = this.Q;     // Catch: Exception -> L26
        if (r23 == null) goto L27;
        ArrayList r24 = new ArrayList();     // Catch: Exception -> L26
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L26
        r25.put("midiUsers", new JSONArray(String.valueOf(((com.bytedance.android.livesdk.ktvimpl.base.sei.r) r12.b).b())));     // Catch: Exception -> L26
        Unit r26 = Unit.INSTANCE;     // Catch: Exception -> L26
        RealTimeChorusMidiWidget r27 = this.J;     // Catch: Exception -> L26
        if (r27 == null) goto L23;
        Float r28 = Float.valueOf((float) r27.wq());     // Catch: Exception -> L26
    L24:
        r23.a(r24, r25, r28);     // Catch: Exception -> L26
        goto L27
    L23:
        r28 = null;
        goto L24
    L16:
        r22 = null;
        goto L17
    L7:
        r20 = null;
        goto L9
    }

    public final void or(MusicPanel r11) {
        KtvModeOrderedSongDataContext r0 = Eq();
        int r2 = 1;
        KtvMusic r3 = null;
        if (r0 == null) goto L17;
        List<MusicPanel> r1 = r0.m200getKtvSingSongList();
        if (r1 == null) goto L17;
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        if (((MusicPanel) r5).c() != r11.c()) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L8;
    L16:
        MusicPanel r7 = (MusicPanel) r5;
    L18:
        String r8 = "";
        if (StringUtils.isEmpty(r11.e()) == false) goto L27;
        Object[] r9 = new Object[1];
        if (r7 == null) goto L26;
        String r10 = r7.e();
        if (r10 == null) goto L26;
        r8 = r10;
    L26:
        r9[0] = r8;
        String r12 = s1.C(2131922308, r9);
    L33:
        if (r11.a.getMDuration() != 0) goto L38;
        KtvMusic.a r13 = KtvMusic.Companion;
        if (r7 == null) goto L37;
        r3 = r7.a;
    L37:
        r13.getClass();
        long r14 = KtvMusic.a.a(r3);
    L39:
        Pair r15 = new Pair(r12, Long.valueOf(r14));
        String r16 = (String) r15.component1();
        long r17 = ((Number) r15.component2()).longValue();
        RTChorusMusicInfoView r18 = this.s;
        if (r18 == null) goto L42;
        Intrinsics.checkNotNullParameter(r16, "musicTitle");
        w.a("RTChorusMusicInfoView", "showSongInfo " + r16);
        r18.T5(r16);
        r18.U5(r17 * ((long) 1000.0f));
    L42:
        RTChorusMusicInfoView r19 = this.s;
        if (r19 == null) goto L60;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r20 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvMusic r110 = r11.a;
        r20.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r110) == true) goto L48;
        r2 = 3;
    L53:
        r19.S5(r2);
        return;
    L48:
        if (this.J == null) goto L53;
        if (this.S1 == true) goto L53;
        r2 = 2;
        goto L53
    L60:
        return;
    L38:
        KtvMusic.a r21 = KtvMusic.Companion;
        KtvMusic r22 = r11.a;
        r21.getClass();
        r14 = KtvMusic.a.a(r22);
        goto L39
    L27:
        Object[] r23 = new Object[1];
        String r24 = r11.e();
        if (r24 == null) goto L31;
        r8 = r24;
    L31:
        r23[0] = r8;
        r12 = s1.C(2131922308, r23);
        goto L33
    L12:
        r6 = false;
        goto L13
    L15:
        r5 = null;
    L17:
        r7 = null;
        goto L18
    }

    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.K2 = r1;
    }

    public static void wq(KSongOrderSongDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "KSongOrderSongDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.showNow(r3, "KSongOrderSongDialog");
    }

    public static final int xq(RealTimeChorusMainViewWidget r2, boolean r3) {
        r2.getClass();
        if (vm2.d.V() == false) goto L10;
        ALogger.i("RealTimeChorusMainViewWidget", "guestMicSeatPublicScreenHeight, hasFixedGuest: " + r3);
        if (r3 == true) goto L8;
        return 0;
    L8:
        return UtilityKotlinExtentionsKt.i(((Number) vm2.d.a5.getValue(null, vm2.d.a[310(0x136, float:4.34E-43)])).intValue());
    L10:
        return 0;
    }

    public final EPointF C7(int r1, int r2) {
        return new EPointF(-1.0f, -1.0f);
    }

    public final boolean K5(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        return true;
    }

    public final EPointF Kl(int r1, int r2) {
        return new EPointF(-1.0f, -1.0f);
    }

    public final boolean W7(EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        return true;
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.ktvimpl.realtimechorus.RTChorusMusicInfoView] */
    public final void Wq(com.bytedance.android.livesdk.chatroom.viewmodel.i r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "switchSceneEvent");
        ALogger.i("RealTimeChorusMainViewWidget", "onSceneChange");
        int r4 = r19.a;
        int r1 = r19.b;
        boolean r7 = false;
        if (r4 == this.a) goto L5;
        boolean r5 = true;
    L6:
        List r8 = CollectionsKt.listOf(new Integer[]{61, 0});
        if (r1 != this.b) goto L9;
    L13:
        boolean r9 = false;
    L14:
        ALogger.i("RealTimeChorusMainViewWidget", "onSceneChange:---" + r5 + "---" + this.a + "--" + r4 + " ;; uiLayoutChange == " + r9 + " ;; " + this.b + " -- " + r1 + ' ');
        this.a = r4;
        this.b = r1;
        this.X.updateKtvAllStateValue(KtvUtilsKt.I(r4, r1));
        if (jc0.a.b(this.a, this.b) == true) goto L17;
        clearAfterDestroyed();
        return;
    L17:
        if (r5 == true) goto L19;
        if (r9 == true) goto L19;
        return;
    L19:
        this.S1 = r20;
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) this.X.getSeiProcessor().getValue(), this);
        if (this.G1 != null) goto L23;
        RealTimeChorusBusinessLifecycleOwner r2 = new RealTimeChorusBusinessLifecycleOwner();
        this.G1 = r2;
        r2.a.setCurrentState(Lifecycle.State.STARTED);
    L36:
        if (this.A != null) goto L54;
        if (Bq() == null) goto L54;
        if (this.D.getFirst() != null) goto L46;
        this.D = com.bytedance.live.datacontext.d.a(new RealTimeChorusMainViewWidget$initPreviewSongDataContext$1(this));
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r3 = KtvRoomContext.a.a();
        if (r3 == null) goto L46;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r6 = r3.getPreviewViewModel();
        if (r6 == null) goto L46;
        r6.setValue(this.D.getFirst());
    L46:
        KtvPreviewSongsViewModel r10 = (KtvPreviewSongsViewModel) this.D.getFirst();
        this.B = r10;
        if (r10 == null) goto L49;
        KtvPreviewSongsWidget r11 = new KtvPreviewSongsWidget(r10, this.X, true, false);
    L50:
        this.A = r11;
        RecyclableWidgetManager r12 = Bq();
        if (r12 == null) goto L54;
        r12.load(2131382959, this.A, false);
        goto L54
    L49:
        r11 = null;
    L54:
        if (((Widget) this).contentView == null) goto L109;
        this.u = findViewById(2131389154);
        this.v = (FrameLayout) findViewById(2131365694);
        this.w = findViewById(2131364468);
        this.t = (RealTimeChorusOperateView) findViewById(2131365698);
        this.y = findViewById(2131365684);
        RealTimeChorusOperateView r13 = this.t;
        if (r13 == null) goto L60;
        r13.setSingInfoProvider(this);
    L60:
        if (r20 == false) goto L65;
        ConstraintLayout r14 = this.t;
        if (r14 == null) goto L70;
        r14.setVisibility(4);
    L70:
        ?? r15 = (RTChorusMusicInfoView) findViewById(2131384881);
        this.s = r15;
        if (r15 != 0) goto L73;
    L75:
        this.r = (RealTimeChorusSingerInfoView) findViewById(2131365688);
        Lq();
        hr(r20);
        RTChorusMusicInfoView r16 = this.s;
        if (r16 == null) goto L81;
        TextView r17 = r16.j;
        if (r17 == null) goto L80;
        r17.setText(s1.B(2131922302));
    L80:
        r16.S5(0);
    L81:
        this.N = (RealTimeChorusFeedBackView) findViewById(2131365685);
        this.F = (FrameLayout) findViewById(2131379318);
        this.H = (FrameLayout) findViewById(2131365689);
        this.P = findViewById(2131386976);
        this.S = (FrameLayout) findViewById(2131380054);
        this.T = (FrameLayout) findViewById(2131365687);
        this.I = (FrameLayout) findViewById(2131365693);
        this.C = (FrameLayout) findViewById(2131382959);
        this.x = (RTChorusLogView) findViewById(2131365710);
        if (((Boolean) vm2.h.W.getValue(null, vm2.h.a[47])).booleanValue() == false) goto L108;
        ConstraintLayout r18 = this.x;
        if (r18 == null) goto L86;
        r18.setVisibility(0);
    L86:
        RTChorusLogView r21 = this.x;
        if (r21 == null) goto L108;
        y r22 = this.e;
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r22, "outerScopeProvider");
        RealTimeChorusBusinessContext.a r23 = RealTimeChorusBusinessContext.Companion;
        r23.o(this, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.f(r21));
        r23.m(this, new com.bytedance.android.livesdk.ktvimpl.realtimechorus.g(r21));
        com.bytedance.android.livesdk.chatroom.o r24 = o3.f();
        com.bytedance.live.datacontext.j r25 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        if (r25 == null) goto L91;
        LinkMicRoomDataSyncModel r26 = (LinkMicRoomDataSyncModel) r25.getValue();
    L92:
        if (r26 != null) goto L102;
        com.bytedance.live.datacontext.j r27 = r24.w1();
        if (r27 == null) goto L98;
        ylc.e r28 = (ylc.e) r27.getValue();
        if (r28 == null) goto L98;
        r26 = (LinkMicRoomDataSyncModel) dc2.b.a(r28, RTChorusLogView$attach$3$1.INSTANCE);
    L99:
        com.bytedance.live.datacontext.j r110 = com.bytedance.android.live.liveinteract.api.utils.m.d().D();
        if (r110 == null) goto L102;
        r110.d(r26);
    L98:
        r26 = null;
    L102:
        if (r26 == null) goto L108;
        dc2.c r29 = r26.getTalkRoomListUserInfoPb();
        if (r29 == null) goto L108;
        Observable r30 = r29.e;
        if (r30 == null) goto L108;
        r30.subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.e(r21, r24, r22));
        goto L108
    L91:
        r26 = null;
    L108:
        this.Q = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c(this.S, this.T, ((Widget) this).context, this.X, ((Widget) this).dataCenter, new RealTimeChorusMainViewWidget$initView$1(this));
        Sq();
        yq();
        goto L109
    L73:
        if (r15.getVisibility() == 4) goto L75;
        UtilityKotlinExtentionsKt.u(r15);
        goto L75
    L65:
        if (((Boolean) KtvSettingHelper.c.getValue()).booleanValue() == false) goto L70;
        ConstraintLayout r31 = this.t;
        if (r31 == null) goto L70;
        r31.setVisibility(0);
    L109:
        Mq(r20);
        bb0.a r32 = bb0.b.a;
        com.bytedance.android.livesdk.ktvimpl.base.n r33 = com.bytedance.android.livesdk.ktvimpl.base.n.a;
        Intrinsics.checkNotNullParameter(r33, "ktvCommonInject");
        bb0.b.a = r33;
        pb0.a r34 = pb0.b.a;
        KtvLoggerHelper r35 = KtvLoggerHelper.d;
        Intrinsics.checkNotNullParameter(r35, "ktvLogger");
        pb0.b.a = r35;
        mb0.c r36 = mb0.d.a;
        pd2.d r37 = pd2.d.n;
        r37.getClass();
        Intrinsics.checkNotNullParameter(r37, "monitor");
        mb0.d.a = r37;
        if (((Boolean) KtvSettingHelper.f.getValue()).booleanValue() == false) goto L118;
        FrameLayout r38 = this.F;
        if (r38 == null) goto L114;
        r38.removeAllViews();
    L114:
        MvLyricWidget r39 = this.E;
        if (r39 == null) goto L117;
        r39.i();
    L117:
        this.E = null;
    L118:
        RealTimeChorusBusinessLifecycleOwner r40 = getLifecycleOwner();
        FrameLayout r41 = this.F;
        if (r40 == null) goto L166;
        if (r41 == null) goto L166;
        if (KtvSettingHelper.w() == true) goto L124;
    L126:
        final RealTimeChorusBusinessLifecycleOwner r111 = r40;
        MvLyricWidget r42 = new MvLyricWidget(r40, r41, new RealTimeChorusMainViewWidget$initLyricView$$inlined$lets$lambda$1(r111, this), null);
        this.E = r42;
        r42.r = new RealTimeChorusMainViewWidget$initLyricView$$inlined$lets$lambda$2(this);
        MvLyricWidget r43 = this.E;
        if (r43 == null) goto L129;
        r43.i.setLyricOneLineMaxWidth(s1.y() - s1.f(25.0f));
    L129:
        MvLyricWidget r44 = this.E;
        if (r44 == null) goto L152;
        k r45 = this.m;
        KtvContext r46 = this.X;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r46, "ktvContext");
        MidiSkinDressInfo r47 = (MidiSkinDressInfo) r46.getMidiSkinContext().getValue();
        if (r47 != null) goto L134;
    L146:
        String r48 = null;
    L147:
        if (r48 != null) goto L149;
        r48 = "#2AF2C9";
    L149:
        KtvMvLyricPresenter r49 = r44.k;
        if (r49 == null) goto L152;
        r49.h(r48);
        goto L152
    L134:
        if (KtvDressDataKt.isAvailableMidiSkin(r47) != true) goto L146;
        MidiSkinMaterial r50 = r47.getMaterial();
        if (r50 == null) goto L146;
        String r51 = r50.getLyricColorValue();
        if (r51 == null) goto L146;
        if (r51.length() <= 0) goto L142;
        r7 = true;
    L142:
        if (r7 != true) goto L146;
        MidiSkinMaterial r52 = r47.getMaterial();
        if (r52 == null) goto L146;
        r48 = r52.getLyricColorValue();
    L152:
        MvLyricWidget r53 = this.E;
        if (r53 == null) goto L163;
        float r54 = s1.f(17.0f);
        KtvMvLyricPresenter r55 = r53.k;
        if (r55 == null) goto L163;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r56 = r55.a;
        if ((r56 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyrics.a) == true) goto L159;
        r56 = null;
    L159:
        if (r56 == null) goto L163;
        LyricsDisplayConfig r57 = r56.getDisplayConfig();
        if (r57 == null) goto L163;
        r57.i(r54, r54);
    L163:
        MvLyricWidget r58 = this.E;
        if (r58 == null) goto L166;
        r58.g(null);
        goto L166
    L124:
        if (this.E == null) goto L126;
    L166:
        if (r20 == true) goto L168;
        yq();
    L168:
        LifecycleOwner r59 = getLifecycleOwner();
        if (r59 == null) goto L178;
        RTChorusMusicInfoView r60 = this.s;
        if (r60 == null) goto L179;
        KtvContext r61 = this.X;
        Intrinsics.checkNotNullParameter(r59, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r61, "ktvContext");
        r60.o = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r61.getKtvCoreViewModel().getValue();
        RxUtilKt.c(((ObservableSubscribeProxy) r61.getCountDownEvent().onEvent().as(AutoDispose.bind(r59))).subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.h(r60)), r60.n);
        Disposable r62 = r61.getMidiSkinContext().a().subscribe(new com.bytedance.android.livesdk.ktvimpl.realtimechorus.i(r60));
        if (r62 == null) goto L180;
        RxUtilKt.c(r62, r60.n);
        return;
    L180:
        return;
    L179:
        return;
    L178:
        return;
    L23:
        if (((Boolean) KtvSettingHelper.i.getValue()).booleanValue() == false) goto L36;
        RealTimeChorusBusinessLifecycleOwner r63 = this.G1;
        if (r63 == null) goto L29;
        Lifecycle r64 = LifecycleOwnerCompat.-CC.$default$getLifecycle(r63);
        if (r64 == null) goto L29;
        Lifecycle.State r65 = r64.getCurrentState();
    L31:
        if (r65 != Lifecycle.State.DESTROYED) goto L36;
        RealTimeChorusBusinessLifecycleOwner r66 = this.G1;
        if (r66 == null) goto L36;
        r66.a.setCurrentState(Lifecycle.State.STARTED);
    L29:
        r65 = null;
        goto L31
    L9:
        if (r8.contains(Integer.valueOf(r1)) == false) goto L13;
        if (r8.contains(Integer.valueOf(this.b)) == false) goto L13;
        r9 = true;
        goto L14
    L5:
        r5 = false;
        goto L6
    }

    public final void kr(MessageHub r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ALogger.i("RealTimeChorusMainViewWidget", "updateMessageHub ;; source == ".concat(r3));
        this.R = r2;
    }

    public final void mr(KtvRoomLyricsStateMachineConfig.d r5, int r6) {
        w.a("RealTimeChorusMainViewWidget", "updateOperateStatus chorusRole : " + r6 + " curState: " + r5);
        if (this.O == false) goto L12;
        w.a("RealTimeChorusMainViewWidget", "updateOperateStatus feedbackShowing so disable");
        RealTimeChorusOperateView r7 = this.t;
        if (r7 == null) goto L7;
        r7.Y5(2);
    L7:
        RealTimeChorusOperateView r8 = this.t;
        if (r8 == null) goto L44;
        r8.i6(false);
        return;
    L44:
        return;
    L12:
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L14;
    L37:
        RealTimeChorusOperateView r9 = this.t;
        if (r9 == null) goto L40;
        r9.Y5(2);
    L40:
        RealTimeChorusOperateView r10 = this.t;
        if (r10 == null) goto L51;
        r10.i6(false);
        return;
    L51:
        return;
    L14:
        if (Intrinsics.areEqual(r5, KtvRoomLyricsStateMachineConfig.d.a.b) == true) goto L37;
        if (r6 != 1) goto L24;
        RealTimeChorusOperateView r11 = this.t;
        if (r11 == null) goto L21;
        r11.Y5(5);
    L21:
        RealTimeChorusOperateView r12 = this.t;
        if (r12 == null) goto L45;
        r12.i6(true);
        return;
    L45:
        return;
    L24:
        if (r6 != 2) goto L31;
        RealTimeChorusOperateView r13 = this.t;
        if (r13 == null) goto L28;
        r13.Y5(4);
    L28:
        RealTimeChorusOperateView r14 = this.t;
        if (r14 == null) goto L47;
        r14.i6(true);
        return;
    L47:
        return;
    L31:
        RealTimeChorusOperateView r15 = this.t;
        if (r15 == null) goto L34;
        r15.Y5(1);
    L34:
        RealTimeChorusOperateView r16 = this.t;
        if (r16 == null) goto L49;
        r16.i6(false);
        return;
    }

    public final void nr(aj r8, boolean r9) {
        if (((Boolean) KtvSettingHelper.m.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r9 == false) goto L8;
    L11:
        this.l = true;
        Integer r10 = r8.c();
        xe2.h.e = r10;
        this.k = r10;
        this.g = r8;
        k r11 = this.m;
        Long r12 = r8.b();
        if (r12 == null) goto L15;
        String r13 = String.valueOf(r12.longValue());
        if (r13 == null) goto L15;
    L16:
        sb0.b r0 = this.k0;
        if (r0 == null) goto L21;
        sb0.e r1 = r0.b();
        if (r1 == null) goto L21;
        Long r2 = Long.valueOf(r1.getRoomId());
    L22:
        long r3 = r2.longValue();
        Function1<com.bytedance.android.live.profit.dress.t, Unit> r4 = new RealTimeChorusMainViewWidget$updateRTChorusDressInfo$1(this);
        Function1<Throwable, Unit> r5 = new RealTimeChorusMainViewWidget$updateRTChorusDressInfo$2(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter("rt_chorus", "function");
        Intrinsics.checkNotNullParameter(r4, "successFb");
        Intrinsics.checkNotNullParameter(r5, "failFb");
        Disposable r6 = r11.a;
        if (r6 != null) goto L25;
    L27:
        r11.a = null;
        r11.a = Observable.create(new l(r11, r13, r3)).retryWhen(RxUtil.rxRetryHelper(3, 500)).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r4), new n(r5), o.a);
        return;
    L25:
        if (r6.isDisposed() == false) goto L27;
        r6.dispose();
    L21:
        r2 = null;
    L15:
        r13 = "";
        goto L16
    L8:
        if ((!Intrinsics.areEqual(this.k, r8.c())) == true) goto L11;
        if (this.l == false) goto L11;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void pr(int r5, String r6) {
        if (r5 != this.W) goto L6;
        return;
    L6:
        if (this.O == false) goto L8;
        return;
    L8:
        w.a("RealTimeChorusMainViewWidget", "updateStageMode " + r5 + ' ' + r6);
        this.W = r5;
        ConstraintLayout r7 = this.s;
        float r0 = 1.0f;
        if (r7 == null) goto L14;
        if (r5 != 2) goto L12;
        float r3 = 0.0f;
    L13:
        r7.setAlpha(r3);
        goto L14
    L12:
        r3 = 1.0f;
    L14:
        ConstraintLayout r8 = this.r;
        if (r8 == null) goto L20;
        if (r5 != 2) goto L18;
        r0 = 0.0f;
    L18:
        r8.setAlpha(r0);
    L20:
        if (r5 == 0) goto L69;
        if (r5 == 1) goto L46;
        if (r5 == 2) goto L25;
        return;
    L25:
        if (KtvSettingHelper.b().booleanValue() == false) goto L29;
        FrameLayout r9 = this.I;
        if (r9 == null) goto L29;
        r9.setVisibility(8);
    L29:
        KtvPreviewSongsViewModel r10 = this.B;
        if (r10 == null) goto L34;
        com.bytedance.live.datacontext.m<Boolean> r11 = r10.getNeedDelayToShow();
        if (r11 == null) goto L34;
        r11.setValue(Boolean.TRUE);
    L34:
        ConstraintLayout r12 = this.P;
        if (r12 == null) goto L37;
        r12.setVisibility(8);
    L37:
        ConstraintLayout r13 = this.N;
        if (r13 == null) goto L40;
        r13.setVisibility(0);
    L40:
        this.O = true;
        RealTimeChorusOperateView r14 = this.t;
        if (r14 == null) goto L43;
        r14.Y5(2);
    L43:
        RealTimeChorusOperateView r15 = this.t;
        if (r15 == null) goto L115;
        r15.i6(false);
        return;
    L115:
        return;
    L46:
        ConstraintLayout r16 = this.P;
        if (r16 == null) goto L49;
        r16.setVisibility(0);
    L49:
        ConstraintLayout r17 = this.N;
        if (r17 == null) goto L52;
        r17.setVisibility(8);
    L52:
        FrameLayout r18 = this.C;
        if (r18 == null) goto L55;
        r18.setVisibility(8);
    L55:
        lr();
        KtvPreviewSongsViewModel r19 = this.B;
        if (r19 == null) goto L59;
        r19.setShowPreviewCard(false, "start sing");
    L59:
        if (this.W == 0) goto L117;
        ConstraintLayout r20 = this.r;
        if (r20 != null) goto L63;
    L65:
        RealTimeChorusSingerInfoView r21 = this.r;
        if (r21 == null) goto L118;
        r21.setSelfVisibility(0);
        return;
    L118:
        return;
    L63:
        if (r20.getVisibility() != 0) goto L65;
        return;
    L117:
        return;
    L69:
        if (KtvSettingHelper.b().booleanValue() == false) goto L73;
        FrameLayout r22 = this.I;
        if (r22 == null) goto L73;
        r22.setVisibility(8);
    L73:
        ConstraintLayout r23 = this.P;
        if (r23 == null) goto L76;
        r23.setVisibility(8);
    L76:
        FrameLayout r24 = this.C;
        if (r24 == null) goto L79;
        r24.setVisibility(0);
    L79:
        ConstraintLayout r25 = this.N;
        if (r25 == null) goto L82;
        r25.setVisibility(8);
    L82:
        KtvPreviewSongsViewModel r26 = this.B;
        if (r26 == null) goto L93;
        com.bytedance.live.datacontext.m<Boolean> r27 = r26.getNeedDelayToShow();
        if (r27 == null) goto L93;
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L93;
        KtvPreviewSongsViewModel r28 = this.B;
        if (r28 == null) goto L93;
        com.bytedance.live.datacontext.m<Boolean> r29 = r28.getNeedDelayToShow();
        if (r29 == null) goto L93;
        r29.setValue(Boolean.FALSE);
    L93:
        KtvPreviewSongsViewModel r30 = this.B;
        if (r30 == null) goto L96;
        r30.setShowPreviewCard(true, "show preview");
    L96:
        RTChorusMusicInfoView r31 = this.s;
        if (r31 == null) goto L102;
        TextView r1 = r31.j;
        if (r1 == null) goto L101;
        r1.setText(s1.B(2131922302));
    L101:
        r31.S5(0);
    L102:
        ConstraintLayout r32 = this.s;
        if (r32 != null) goto L105;
    L107:
        ar("show preview");
        RealTimeChorusSingerInfoView r33 = this.r;
        if (r33 == null) goto L110;
        r33.R5(BDLocationException.ERROR_TIMEOUT, "#00FFE0");
    L110:
        RealTimeChorusSingerInfoView r34 = this.r;
        if (r34 == null) goto L113;
        r34.S5(BDLocationException.ERROR_TIMEOUT);
    L113:
        Lq();
        return;
    L105:
        if (r32.getVisibility() == 0) goto L107;
        UtilityKotlinExtentionsKt.w(r32);
        goto L107
    }

    public final void Mb(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
    }

    public final boolean Mk(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        InteractAnimationController.d.a.a(r2, r3, r4);
        return true;
    }

    public final boolean ha(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        InteractAnimationController.d.a.b(r2, r3, r4);
        return false;
    }

    public final EPointF Se(int r1, int r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        return new EPointF(-1.0f, -1.0f);
    }

    public final void br(String r12, boolean r13, String r14, Integer r15) {
        if (KtvSettingHelper.n().booleanValue() == true) goto L6;
        f2.b(2131918463, 0);
        return;
    L6:
        KtvContext r0 = this.X;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<oe2.b> r1 = r0.getKtvRoomProvider();
        if (r1 == null) goto L11;
        oe2.b r2 = (oe2.b) r1.getValue();
    L13:
        if ((r2 instanceof d1) == true) goto L15;
        r2 = null;
    L15:
        d1 r3 = (d1) r2;
        if (r3 == null) goto L18;
        r3.a = r12;
    L18:
        String r4 = bb0.b.b();
        ALogger.i(r4, ("showKtvRoomOrAdjustDialog, isAdjust:" + r13) + ", invoke class :RealTimeChorusMainViewWidget");
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L22;
        jc1.k.n(IMiddlewareUserService.class).user().login(((Widget) this).context, new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L22:
        if (r13 == false) goto L30;
        if (this.X.getKtvCoreController().getValue() != null) goto L28;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r16 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) this.X.getKtvSingerViewModel().getValue();
        if (r16 == null) goto L28;
        r16.lazyInitKtvCoreController();
    L28:
        KSongTuningPanelHelperKt.a(((Widget) this).context, "chorus");
        pb0.a.a.b(KtvLoggerHelper.d, "tone_tuning", null, "tone_tuning", null, null, 26);
        return;
    L30:
        if (((Widget) this).isDestroyed == true) goto L55;
        KtvCoreViewModel r17 = this.M;
        KtvSingerViewModel r5 = this.p1;
        FragmentActivity r6 = ((Widget) this).context;
        if (r17 == null) goto L56;
        if (r5 == null) goto L57;
        if (r6 == null) goto L58;
        Nq();
        com.bytedance.android.livesdk.ktvimpl.base.util.q.e();
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r18 = KtvModeOrderSongDataContext.Companion.a();
        if (r18 == null) goto L38;
        r18.updateOrderSongExtraInfo(new td2.b(r12, new WeakReference(r6)));
    L38:
        FragmentManager r19 = r6.getSupportFragmentManager();
        Fragment r110 = r19.findFragmentByTag("KSongOrderSongDialog");
        if ((r110 instanceof KSongOrderSongDialog) == true) goto L41;
        r110 = null;
    L41:
        KSongOrderSongDialog r111 = (KSongOrderSongDialog) r110;
        if (r111 != null) goto L44;
    L52:
        KSongOrderSongUtilKt.b(r6, CloseOrderSongDialogSource.AUTO);
        int r112 = KSongOrderSongDialog.p;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r113 = KtvModeOrderSongDataContext.Companion.a();
        int r7 = RTChorusFirstLevelTabManager.r;
        RTChorusFirstLevelTabManager r8 = new RTChorusFirstLevelTabManager(r15, r14, ((Widget) this).context, KtvModeOrderSongDataContext.Companion.b(), KtvModeOrderSongDataContext.Companion.c(), KtvModeOrderSongDataContext.Companion.a(), KtvModeOrderSongDataContext.Companion.e());
        r8.s();
        KSongOrderSongDialog r114 = KSongOrderSongDialog.a.a(r113, r8, null, 12);
        wq(r114, r19);
        Unit r115 = Unit.INSTANCE;
        this.k1 = r114;
        return;
    L44:
        if (this.k1 == null) goto L52;
        if (r111.isAdded() == true) goto L48;
        wq(r111, r19);
        return;
    L48:
        r111.m.c(r15, r14);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e.a.a(r111.m);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r116 = KtvModeOrderSongDataContext.Companion.a();
        if (r116 == null) goto L51;
        r116.updateCurrentTabData();
    L51:
        KSongOrderSongDialog.aa0(r111, false, null, 3);
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L11:
        r2 = null;
        goto L13
    }

    public RealTimeChorusMainViewWidget(int r1, com.bytedance.android.live.liveinteract.plantform.datamerge.d r2, hh1.w0 r3, KtvContext r4, com.bytedance.android.livesdk.chatroom.widget.j1 r5) {
        this.M2 = r1;
        this.N2 = r2;
        this.O2 = r3;
        this.P2 = r5;
        this.c = -1;
        this.d = -1;
        this.e = new y(this);
        this.m = new k();
        this.o = "";
        this.D = new Pair(null, null);
        this.U = new ArrayList();
        this.V = new d1(this.P2);
        this.W = -1;
        if (r4 != null) goto L5;
        r4 = new KtvContext();
    L5:
        this.X = r4;
        sb0.b.a.getClass();
        Pair r6 = sb0.b.a.a();
        sb0.b r7 = (sb0.b) r6.getFirst();
        r4.getDataEntity().d(r7);
        Unit r8 = Unit.INSTANCE;
        this.k0 = r7;
        this.p0 = (sb0.a) r6.getSecond();
        this.H0 = new CompositeDisposable();
        this.L0 = new CompositeDisposable();
        this.P0 = new Pair(null, null);
        this.V0 = new Pair(null, null);
        this.b1 = new Pair(null, null);
        this.y1 = r4.getBizLcMager();
        this.H1 = KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION;
        this.T1 = SetsKt.setOf(new Long[]{3L, 2L});
        this.V1 = new ArrayList();
        this.b2 = new LinkedHashMap();
        this.H2 = new j0(this);
        this.I2 = new k0(this);
        this.J2 = new ViewModelStore();
        this.L2 = "main_widget";
    }
}
