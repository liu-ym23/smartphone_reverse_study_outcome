package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.CommonOrderSongViewModel;
import com.bytedance.android.live.ktv.common.midi.KSongToneLinesView;
import com.bytedance.android.live.ktv.common.midi.KtvComponentProgressView;
import com.bytedance.android.live.ktv.common.midi.KtvMidiView;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.search.viewmodel.CommonSearchViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.WidgetViewModelProviders;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongHandler;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.KtvComponentFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.viewmodel.KtvComponentOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvListenerLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvRoomLyricHolder;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.LyricComponentListenerPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.KtvDressViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.widget.HolderRoomScopeWidget;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ksong.base.view.AbsKSongScoreFinishFragment;
import com.bytedance.android.livesdk.ktvimpl.ksong.base.view.KSongAudienceScoreFinishFragment;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentRoomStrategy;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.KtvComponentControlTopBarWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol.TopChallengeFunctionItem;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.anchor.AnchorKtvComponentStrategy;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.audience.AudienceKtvComponentStrategy;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.KtvRoomViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvComponentChallengeProgressView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentEmptyView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import zg1.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/KtvComponentUIWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/widget/HolderRoomScopeWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/behavior/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentUIWidget extends HolderRoomScopeWidget implements com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.a, com.bytedance.android.livesdk.ktvimpl.base.sei.c, Observer<KVData> {
    public static final TokenCert y1 = null;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h A;
    public long B;
    public long C;
    public final int D;
    public final int E;
    public final int F;
    public final boolean G;
    public AbsKSongScoreFinishFragment H;
    public final e H0;
    public int I;
    public boolean J;
    public final boolean K;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.e L;
    public final LiveNetworkBroadcastReceiver L0;
    public final boolean M;
    public KtvComponentMidiViewModel N;
    public final f O;
    public final g P;
    public final h P0;
    public boolean Q;
    public final KtvContext R;
    public LyricComponentImplManager S;
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b T;
    public final KtvComponentMusicReportInfoManager U;
    public int V;
    public final KtvComponentUIWidget$mKtvCoreListener$1 V0;
    public int W;
    public final le2.a X;
    public final Lazy Y;
    public final r Z;
    public boolean b1;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    public KtvRoomLyricHolder g1;
    public boolean h;
    public boolean h1;
    public Pair<? extends OrderedSongDataContext, ? extends Disposable> i;
    public Pair<? extends DataContext, ? extends Disposable> j;
    public Pair<? extends DataContext, ? extends Disposable> k;
    public final d k0;
    public int k1;
    public KSongOrderSongDialog l;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c m;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d n;
    public KtvComponentControlTopBarWidget o;
    public LyricComponentListenerPresenter p;
    public final n p0;
    public final Lazy p1;
    public final Lazy q;
    public final boolean r;
    public KtvComponentUIContext s;
    public com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a t;
    public com.bytedance.android.livesdk.ktvimpl.base.lyrics.d u;
    public KtvListenerLyricPresenter v;
    public final Function0<Unit> v1;
    public final CompositeDisposable w;
    public Pair<KtvRoomContext, ? extends Disposable> x;
    public final Function1<Long, Unit> x1;
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a y;
    public final KtvComponentRoomStrategy z;

    public static final class a {
    }

    public static final class b implements fd0.b {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        public final void onStop() {
            Function0 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvComponentUIWidget a;

        public c(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            cg6.a r4 = this.a.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r4 == null) goto L11;
            vb6.g r5 = r4.O5();
            if (r5 == null) goto L12;
            r5.X0(this.a.k0, false);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class d extends vb6.a {
        public final /* synthetic */ KtvComponentUIWidget a;

        public d(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        public final void u4(long r1, ec6.a r3) {
            Intrinsics.checkNotNullParameter(r3, "client");
            if (KSongTuningPanelHelperKt.d() != null) goto L15;
            com.bytedance.android.live.pushstream.d r2 = this.a.y.h(com.bytedance.android.live.ktv.common.util.j.i());
            if (r2 != null) goto L13;
            v0 r4 = gc6.b.b(r3);
            if ((r4 instanceof m00.h) == true) goto L9;
            r4 = null;
        L9:
            m00.h r5 = (m00.h) r4;
            if (r5 == null) goto L12;
            r2 = r5.getLiveStream();
            goto L13
        L12:
            r2 = null;
        L13:
            this.a.Yq(r2);
            return;
        }
    }

    public static final class e extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {
        public final /* synthetic */ KtvComponentUIWidget a;

        public e(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r3) {
            IInteractService r4 = jc1.k.f(IInteractService.class);
            if (r4 == null) goto L9;
            com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r5 = r4.getLinkUserInfoCenter();
            if (r5 == null) goto L10;
            KtvComponentUIWidget r0 = this.a;
            TokenCert r1 = KtvComponentUIWidget.y1;
            r0.er(r5);
            return;
        L10:
            return;
        }
    }

    public static final class f implements KtvSingAndListenerLyricViewV2.a {
        public final /* synthetic */ KtvComponentUIWidget a;

        public f(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvSingAndListenerLyricViewV2.a
        public final void a(long r5) {
            KtvComponentUIWidget r0 = this.a;
            TokenCert r1 = KtvComponentUIWidget.y1;
            r0.getClass();
            com.bytedance.android.live.ktv.common.midi.k r2 = null;
            if (KtvComponentUIWidget.Iq() == false) goto L15;
            KtvComponentUIContext r3 = this.a.s;
            if (r3 == null) goto L9;
            MutableLiveData<Boolean> r4 = r3.getScoreOpen();
            if (r4 == null) goto L9;
            Boolean r6 = (Boolean) r4.getValue();
        L11:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L15;
            KtvComponentMidiView r7 = this.a.T.l;
            if (r7 == null) goto L38;
            r7.R2(r5);
            return;
        L38:
            return;
        L9:
            r6 = null;
        L15:
            this.a.getClass();
            if (KtvComponentUIWidget.Iq() == true) goto L40;
            KtvComponentUIContext r8 = this.a.s;
            if (r8 == null) goto L22;
            MutableLiveData<Boolean> r9 = r8.getSingerScoreOpen();
            if (r9 == null) goto L22;
            Boolean r10 = (Boolean) r9.getValue();
        L24:
            if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L41;
            KtvComponentMidiViewModel r11 = this.a.N;
            if (r11 == null) goto L32;
            MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r12 = r11.m333getScoreInfo();
            if (r12 == null) goto L32;
            Pair r13 = (Pair) r12.getValue();
            if (r13 == null) goto L32;
            r2 = (com.bytedance.android.live.ktv.common.midi.k) r13.getSecond();
        L32:
            if (r2 == null) goto L34;
            KtvComponentUIWidget.yq(this.a, new Pair(Long.valueOf(r5), r2));
        L34:
            KtvComponentMidiView r14 = this.a.T.l;
            if (r14 == null) goto L42;
            r14.R2(r5);
            return;
        L42:
            return;
        L41:
            return;
        L22:
            r10 = null;
            goto L24
        }
    }

    public static final class g implements com.bytedance.android.live.ktv.common.midi.f {
        public g() {
        }

        public final boolean a() {
            MidiContext.a r0 = MidiContext.Companion;
            if (r0.b() != 1) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L12;
            return false;
        L12:
            return true;
        L5:
            if (r0.b() == 3) goto L8;
            r1 = false;
            goto L9
        }

        public final boolean b() {
            MidiContext.a r0 = MidiContext.Companion;
            if (r0.b() != 1) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L12;
            return false;
        L12:
            return true;
        L5:
            if (r0.b() == 2) goto L8;
            r1 = false;
            goto L9
        }

        public final boolean c() {
            MidiContext.a r0 = MidiContext.Companion;
            if (r0.b() != 1) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L12;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L12;
            return false;
        L12:
            return true;
        L5:
            if (r0.b() == 3) goto L8;
            r1 = false;
            goto L9
        }

        public final boolean d() {
            if (MidiContext.Companion.b() != 1) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L9;
            return false;
        L9:
            return true;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class h implements LiveNetworkBroadcastReceiver.a {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void a(NetworkUtils.NetworkType r4) {
            KtvContext.Companion.getClass();
            KtvContext r0 = KtvContext.a.g();
            if (r4 != NetworkUtils.NetworkType.WIFI) goto L14;
            KtvComponentOrderSongDataContext.Companion.getClass();
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = KtvComponentOrderSongDataContext.Companion.b();
            if (r5 == null) goto L7;
            com.bytedance.android.live.ktv.common.karaokestation.model.y r6 = r5.getSecondLevelTabDataByParams(FirstLevelTab.OrderSongTab.getValue(), "room_hot");
        L8:
            if (r6 != null) goto L10;
        L17:
            r0.getKtvRoomLabelChangeEvent().post(new Object());
            return;
        L10:
            if ((!r6.h.isEmpty()) == false) goto L17;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = KtvComponentOrderSongDataContext.Companion.a();
            if (r1 == null) goto L17;
            r1.beginWifiDownload(r6);
            goto L17
        L7:
            r6 = null;
            goto L8
        L14:
            KtvComponentOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r7 = KtvComponentOrderSongDataContext.Companion.a();
            if (r7 == null) goto L17;
            r7.stopWifiDownload();
            goto L17
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ KtvComponentUIWidget a;

        public i(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvComponentUIWidget r0 = this.a;     // Catch: Throwable -> L4
            TokenCert r1 = KtvComponentUIWidget.y1;     // Catch: Throwable -> L4
            r0.dr();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KtvComponentUIWidget a;

        public j(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            KtvComponentUIWidget r4 = this.a;
            TokenCert r0 = KtvComponentUIWidget.y1;
            r4.sr();
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ KtvComponentUIWidget a;
        public final /* synthetic */ com.bytedance.android.live.pushstream.d b;

        public k(KtvComponentUIWidget r1, com.bytedance.android.live.pushstream.d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.pushstream.d r0 = this.b;     // Catch: Throwable -> L11
            if (r0 == null) goto L14;
            long r2 = this.a.d;     // Catch: Throwable -> L11
            List<ILinkPlayerInfoBridge> r4 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.a;     // Catch: Throwable -> L11
            JSONObject r5 = new JSONObject();     // Catch: Throwable -> L11
            r5.put("cmd", 2).put("anchor_id", r2);     // Catch: Throwable -> L7 Exception -> L16
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L9:
            r0.c1("ktv_sei", r5, 1, true, false);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ KtvComponentUIWidget a;

        public l(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IInteractService r0 = jc1.k.f(IInteractService.class);     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r1 = r0.getLinkUserInfoCenter();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            KtvComponentUIWidget r2 = this.a;     // Catch: Throwable -> L8
            TokenCert r3 = KtvComponentUIWidget.y1;     // Catch: Throwable -> L8
            r2.er(r1);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ KtvComponentUIWidget a;

        public m(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IInteractService r0 = jc1.k.f(IInteractService.class);     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r1 = r0.getLinkUserInfoCenter();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            KtvComponentUIWidget r2 = this.a;     // Catch: Throwable -> L8
            TokenCert r3 = KtvComponentUIWidget.y1;     // Catch: Throwable -> L8
            r2.er(r1);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class n implements View.OnTouchListener {
        public float a;
        public float b;
        public final /* synthetic */ KtvComponentUIWidget c;

        public n(KtvComponentUIWidget r1) {
            this.c = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r8, MotionEvent r9) {
            Intrinsics.checkNotNullParameter(r8, "v");
            Intrinsics.checkNotNullParameter(r9, "event");
            int r0 = r9.getAction();
            if (r0 != 0) goto L5;
            r8.getParent().requestDisallowInterceptTouchEvent(true);
            KtvComponentUIWidget r1 = this.c;
            TokenCert r2 = KtvComponentUIWidget.y1;
            r1.getClass();
            ViewParent r10 = r8.getParent();
        L27:
            boolean r3 = r10 instanceof cs1.a;
            if (r3 == true) goto L34;
            if (r10 == null) goto L31;
            ViewParent r4 = r10.getParent();
        L32:
            if (r4 == null) goto L34;
            r10 = r10.getParent();
            goto L27
        L31:
            r4 = null;
        L34:
            if (r3 == false) goto L36;
            ((cs1.a) r10).setDisallowInterceptOnce(true);
        L36:
            this.a = r9.getY();
            this.b = r9.getRawY();
        L37:
            return true;
        L5:
            if (r0 == 1) goto L19;
            if (r0 == 2) goto L9;
            if (r0 == 3) goto L19;
        L9:
            float r11 = (((Widget) this.c).containerView.getY() + r9.getY()) - this.a;
            KtvComponentUIWidget r12 = this.c;
            if (r11 < r12.V) goto L37;
            if (r11 > r12.W) goto L37;
            ((Widget) r12).containerView.setY(r11);
            this.c.k1 = (int) r11;
            KtvComponentContext r13 = KtvComponentContext.Companion.getContext();
            if (r13 == null) goto L37;
            com.bytedance.live.datacontext.n<Float> r14 = r13.getBallRelativeY();
            if (r14 == null) goto L37;
            r14.setValue(Float.valueOf(this.c.Mq()));
        L19:
            if (Math.abs(r9.getRawY() - this.b) > 3.0f) goto L21;
            r8.performClick();
        L25:
            r8.getParent().requestDisallowInterceptTouchEvent(false);
            goto L37
        L21:
            DataCenter r15 = ((Widget) this.c).dataCenter;
            if (r15 == null) goto L24;
            r15.put("data_is_ktv_move", Boolean.TRUE);
        L24:
            Long r16 = KtvLoggerHelper.a;
            String r17 = com.bytedance.android.live.ktv.common.util.j.e(((Widget) this.c).dataCenter);
            String r5 = com.bytedance.android.live.ktv.common.util.j.a(((Widget) this.c).dataCenter);
            String r6 = com.bytedance.android.live.ktv.common.util.j.g();
            Intrinsics.checkNotNullParameter(r17, "liveType");
            Intrinsics.checkNotNullParameter(r5, "roomType");
            Intrinsics.checkNotNullParameter(r6, "userType");
            HashMap r7 = new HashMap(3);
            r7.put("live_type", r17);
            r7.put("room_type", r5);
            r7.put("user_type", r6);
            j0.l().sendLog("anchor_ksong_icon_move", r7, new Object[]{IRoom.class, am2.x.class});
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/datacontext/KtvRoomContext;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<KtvRoomContext> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, KtvRoomContext.class, "<init>", "<init>()V", 0);
        }

        public final KtvRoomContext invoke() {
            return new KtvRoomContext();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m328invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget$onCreate$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.viewmodel.i, Unit> {
        public AnonymousClass5(KtvComponentUIWidget r8) {
            super(1, r8, KtvComponentUIWidget.class, "onVoiceSceneChanged", "onVoiceSceneChanged(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.chatroom.viewmodel.i r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            KtvComponentUIWidget r0 = (KtvComponentUIWidget) ((CallableReference) this).receiver;
            TokenCert r1 = KtvComponentUIWidget.y1;
            r0.getClass();
            if (r3.a == 0) goto L6;
            r0.Sq();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.chatroom.viewmodel.i) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.KtvComponentUIWidget$onCreate$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/viewmodel/j;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.viewmodel.j, Unit> {
        public AnonymousClass6(KtvComponentUIWidget r8) {
            super(1, r8, KtvComponentUIWidget.class, "onVideoSceneChanged", "onVideoSceneChanged(Lcom/bytedance/android/livesdk/chatroom/viewmodel/SwitchSceneWithPlayModeEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.chatroom.viewmodel.j r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            KtvComponentUIWidget r0 = (KtvComponentUIWidget) ((CallableReference) this).receiver;
            TokenCert r1 = KtvComponentUIWidget.y1;
            r0.getClass();
            if (r3.a == 0) goto L6;
            r0.Sq();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.chatroom.viewmodel.j) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ KtvComponentUIWidget a;

        public p(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            KtvComponentUIWidget r4 = this.a;
            TokenCert r0 = KtvComponentUIWidget.y1;
            r4.tr();
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ ub0.d a;
        public final /* synthetic */ KtvComponentUIWidget b;
        public final /* synthetic */ MusicPanel c;

        public q(ub0.d r1, KtvComponentUIWidget r2, MusicPanel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            int r0 = mb0.f.a;
            mb0.f.q(Long.valueOf(this.c.c()), this.c.e());
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1 = this.b.m;
            if (r1 == null) goto L6;
            r1.sendEvent(new KtvRoomLyricsStateMachineConfig.a.f(this.a.c), "KtvComponentUIWidget");
            return;
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

    public static final class r<T> implements Observer {
        public final /* synthetic */ KtvComponentUIWidget a;

        public r(KtvComponentUIWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L5;
            Object r5 = r4.getData();
        L7:
            if ((r5 instanceof l3) == false) goto L15;
            IInteractService r6 = jc1.k.f(IInteractService.class);
            if (r6 == null) goto L13;
            com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r7 = r6.getLinkUserInfoCenter();
            if (r7 == null) goto L13;
            KtvComponentUIWidget r0 = this.a;
            TokenCert r1 = KtvComponentUIWidget.y1;
            r0.er(r7);
        L13:
            KtvComponentUIWidget r8 = this.a;
            TokenCert r2 = KtvComponentUIWidget.y1;
            r8.cr();
            return;
        L15:
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    public KtvComponentUIWidget() {
        this(null, null, null);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.a
    public final void r8(ub0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "lyricsChangeEvent");
    }

    static {
        y1 = TokenCert.Companion.with("bpea-ktvroomcardwidget_get_network_type");
    }

    public static boolean Iq() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L10;
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == true) goto L7;
    L9:
        return false;
    L7:
        if (r0.d() == false) goto L9;
    L10:
        return true;
    }

    public static boolean kr() {
        KtvContext.Companion.getClass();
        List<MusicPanel> r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        if (r0 != null) goto L5;
    L16:
        ChorusContext.a r1 = ChorusContext.Companion;
        if (r1.a() != 2) goto L19;
    L20:
        ChorusContext r3 = r1.getContext();
        if (r3 == null) goto L23;
        List<MusicPanel> r4 = r3.getChorusNotSelfSeeingMusicList();
    L24:
        List<MusicPanel> r5 = r4;
        if (r5 != null) goto L27;
    L30:
        boolean r6 = true;
    L31:
        if (r6 == false) goto L33;
        return false;
    L33:
        if (r1.c() == false) goto L44;
    L34:
        KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
        if (r2 == null) goto L45;
        com.bytedance.live.datacontext.m<Integer> r7 = r2.getPanelState();
        if (r7 != null) goto L39;
        return false;
    L39:
        if (((Number) r7.getValue()).intValue() != 0) goto L47;
        return true;
    L47:
        return false;
    L45:
        return false;
    L44:
        return false;
    L27:
        if (r5.isEmpty() == true) goto L30;
        r6 = false;
        goto L31
    L23:
        r4 = null;
        goto L24
    L19:
        if (r1.a() == 1) goto L20;
        return false;
    L5:
        if ((!r0.isEmpty()) != true) goto L16;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L15;
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.a() == true) goto L13;
        if (KtvUtilsKt.j() == true) goto L15;
    L13:
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L16;
    L15:
        if (ChorusContext.Companion.c() == false) goto L34;
        goto L16
    }

    public final float Mq() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L5;
        float r1 = r0.getY();
    L6:
        int r2 = this.V;
        return (r1 - r2) / (this.W - r2);
    L5:
        r1 = this.V;
        goto L6
    }

    public final void Nq() {
        KtvComponentMidiViewModel r0 = this.N;
        List r1 = null;
        if (r0 == null) goto L8;
        MutableLiveData<List<cb0.c>> r2 = r0.getMidiData();
        if (r2 == null) goto L8;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L8;
    L9:
        KtvComponentContext.a r4 = KtvComponentContext.Companion;
        KtvComponentContext r5 = r4.getContext();
        int r6 = 0;
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r7 = r5.getKtvComponentUIContext();
        if (r7 == null) goto L20;
        KtvComponentUIContext r8 = (KtvComponentUIContext) r7.getValue();
        if (r8 == null) goto L20;
        MutableLiveData<Boolean> r9 = r8.getScoreOpen();
        if (r9 == null) goto L20;
        Boolean r10 = (Boolean) r9.getValue();
        if (r10 == null) goto L20;
        boolean r11 = r10.booleanValue();
    L21:
        if (r11 == true) goto L37;
        KtvComponentContext r12 = r4.getContext();
        if (r12 == null) goto L33;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r13 = r12.getKtvComponentUIContext();
        if (r13 == null) goto L33;
        KtvComponentUIContext r14 = (KtvComponentUIContext) r13.getValue();
        if (r14 == null) goto L33;
        MutableLiveData<Boolean> r15 = r14.getSingerScoreOpen();
        if (r15 == null) goto L33;
        Boolean r16 = (Boolean) r15.getValue();
        if (r16 == null) goto L33;
        boolean r17 = r16.booleanValue();
    L34:
        if (r17 == true) goto L37;
        boolean r18 = false;
    L38:
        if (r18 == false) goto L64;
        if (r3 == null) goto L69;
        KtvComponentMidiViewModel r19 = this.N;
        if (r19 == null) goto L46;
        MutableLiveData<List<cb0.c>> r20 = r19.getMidiData();
        if (r20 == null) goto L46;
        r1 = (List) r20.getValue();
    L46:
        int r21 = 100;
        if (r1 == null) goto L52;
        Iterator r22 = r1.iterator();
    L50:
        if (r22.hasNext() == false) goto L52;
        cb0.c r23 = (cb0.c) r22.next();
        r21 = Math.min(r21, r23.b);
        r6 = Math.max(r6, r23.b);
    L52:
        Pair<Integer, Integer> r24 = TuplesKt.to(Integer.valueOf(r21), Integer.valueOf(r6));
        if (MidiContext.Companion.d() == false) goto L59;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r25 = this.T;
        if (r25 == null) goto L65;
        KtvComponentMidiView r26 = r25.l;
        if (r26 == null) goto L66;
        r26.xc(r24);
        return;
    L66:
        return;
    L65:
        return;
    L59:
        KtvMidiView r27 = this.T.k;
        if (r27 == null) goto L68;
        int r28 = ((Number) r24.getFirst()).intValue();
        int r29 = ((Number) r24.getSecond()).intValue();
        r27.f = r28;
        r27.g = r29;
        KSongToneLinesView r30 = r27.a(2131389045);
        r30.g = r28;
        r30.h = r29;
        r30.m = r30.n / (r29 - r28);
        return;
    L68:
        return;
    L69:
        return;
    L64:
        return;
    L33:
        r17 = false;
    L37:
        r18 = true;
    L20:
        r11 = false;
    L8:
        r3 = null;
        goto L9
    }

    public final void Qq() {
        ViewPainter r0 = this.T.c;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        KtvSingAndListenerLyricViewV2 r1 = this.T.b;
        if (r1 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r1);
        return;
    }

    public final void Rq() {
        TextView r0 = this.T.i;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (ne2.a.a() == true) goto L10;
        ImageView r1 = this.T.h;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r2 = this.t;
        if (r2 == null) goto L14;
        r2.c();
        return;
    }

    public final void Sq() {
        vb6.g r2 = null;
        if (((Boolean) vm2.h.X0.getValue(null, vm2.h.a[100])).booleanValue() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L24;
        Lazy r0 = KtvSettingHelper.a;
        cg6.a r1 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L9;
        r2 = r1.O5();
    L9:
        if (r2 != null) goto L17;
        cg6.a r3 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r3 == null) goto L25;
        BehaviorSubject r4 = r3.dj();
        if (r4 == null) goto L26;
        Disposable r5 = r4.subscribe(new c(this));
        if (r5 == null) goto L27;
        RxUtilKt.c(r5, this.w);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L17:
        cg6.a r6 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r6 == null) goto L29;
        vb6.g r7 = r6.O5();
        if (r7 == null) goto L30;
        r7.X0(this.k0, false);
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void Tq() {
        KtvComponentOrderSongDataContext.Companion.getClass();
        if (KtvComponentOrderSongDataContext.Companion.d() != null) goto L34;
        Pair<? extends DataContext, ? extends Disposable> r0 = com.bytedance.live.datacontext.d.a(KtvComponentUIWidget$initKSongOrderSongDataContextIfNeed$1.INSTANCE);
        this.k = r0;
        DataContext r1 = null;
        if (r0 == null) goto L7;
        DataContext r2 = (DataContext) r0.getFirst();
    L9:
        if ((r2 instanceof KtvComponentOrderSongDataContext) == false) goto L12;
        r1 = r2;
    L12:
        KtvComponentOrderSongDataContext r3 = (KtvComponentOrderSongDataContext) r1;
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.b.a(r3, KtvComponentUIWidget$initKSongOrderSongDataContextIfNeed$2.INSTANCE);
    L15:
        KSongOrderSongHandler r4 = new KSongOrderSongHandler();
        if (r3 == null) goto L20;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b> r5 = r3.m59getCommonOrderSongViewModel();
        if (r5 == null) goto L20;
        CommonOrderSongViewModel.Companion.getClass();
        r5.d(CommonOrderSongViewModel.a.a(this, r4));
    L20:
        if (r3 == null) goto L24;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r6 = r3.m60getCommonSearchViewModel();
        if (r6 == null) goto L24;
        CommonSearchViewModel.Companion.getClass();
        r6.d(CommonSearchViewModel.a.a(this, r4));
    L24:
        if (r3 == null) goto L28;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r7 = r3.m58getBusinessOrderSongViewModel();
        if (r7 == null) goto L28;
        KtvComponentOrderSongViewModel.a r8 = KtvComponentOrderSongViewModel.Companion;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r9 = KtvComponentOrderSongDataContext.Companion.b();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r10 = KtvComponentOrderSongDataContext.Companion.c();
        KtvComponentOrderedSongDataContext r11 = KtvComponentOrderedSongDataContext.Companion.getContext();
        r8.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = KtvComponentOrderSongViewModel.a.a(this, r9, r10, r11);
        r12.initData();
        Unit r13 = Unit.INSTANCE;
        r7.d(r12);
    L28:
        r4.a = KtvComponentOrderSongDataContext.Companion.a();
        r4.b = KtvComponentOrderSongDataContext.Companion.b();
        if (r3 == null) goto L35;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r14 = r3.m61getKtvDressViewModel();
        if (r14 == null) goto L36;
        KtvDressViewModel.Companion.getClass();
        r14.d(KtvDressViewModel.a.a(this));
        return;
    L36:
        return;
    L35:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void Wq() {
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r0 = this.i;
        if (r0 == null) goto L5;
        OrderedSongDataContext r1 = (OrderedSongDataContext) r0.getFirst();
    L6:
        if (r1 != null) goto L13;
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r2 = com.bytedance.live.datacontext.d.a(KtvComponentUIWidget$initKtvComponentOrderedSongDataContextIfNeed$1.INSTANCE);
        this.i = r2;
        if (r2 == null) goto L14;
        OrderedSongDataContext r3 = (OrderedSongDataContext) r2.getFirst();
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.b.a(r3, KtvComponentOrderedSongDataContext.class);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void Zq() {
        bb0.a r0 = bb0.b.a;
        com.bytedance.android.livesdk.ktvimpl.base.n r1 = com.bytedance.android.livesdk.ktvimpl.base.n.a;
        Intrinsics.checkNotNullParameter(r1, "ktvCommonInject");
        bb0.b.a = r1;
        pb0.a r2 = pb0.b.a;
        KtvLoggerHelper r3 = KtvLoggerHelper.d;
        Intrinsics.checkNotNullParameter(r3, "ktvLogger");
        pb0.b.a = r3;
        mb0.c r4 = mb0.d.a;
        pd2.d r5 = pd2.d.n;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r5, "monitor");
        mb0.d.a = r5;
    }

    public final boolean br() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.m;
        Boolean r1 = null;
        if (r0 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r2 = r0.getCurState();
        if (r2 == null) goto L9;
        MusicPanel r3 = r2.b();
        if (r3 == null) goto L9;
        KtvMusic r4 = r3.a;
    L10:
        StringBuilder r5 = new StringBuilder("needHideLyricsViewAndMidi music:");
        if (r4 == null) goto L13;
        String r6 = r4.getTitle();
    L14:
        r5.append(r6);
        r5.append('_');
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        r5.append(com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r4));
        r5.append(", showLyricsViewAndMidi:");
        KtvComponentUIContext r7 = this.s;
        if (r7 == null) goto L19;
        NextLiveData<Boolean> r8 = r7.getShowLyricsViewAndMidi();
        if (r8 == null) goto L19;
        Boolean r9 = (Boolean) r8.getValue();
    L20:
        r5.append(r9);
        ALogger.i("KtvComponentUIWidget", r5.toString());
        KtvComponentUIContext r10 = this.s;
        if (r10 == null) goto L26;
        NextLiveData<Boolean> r11 = r10.getShowLyricsViewAndMidi();
        if (r11 == null) goto L26;
        r1 = (Boolean) r11.getValue();
    L26:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L28;
    L31:
        return true;
    L28:
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r4) == false) goto L31;
        return false;
    L19:
        r9 = null;
        goto L20
    L13:
        r6 = null;
    L9:
        r4 = null;
        goto L10
    }

    public final void dr() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L6;
        com.bytedance.android.live.core.utils.i0.c().postDelayed(new i(this), 1000);
        return;
    L6:
        r0.observe("cmd_video_talkroom_state_change", this.Z);
    }

    public final int getLayoutId() {
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r0 = this.t;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLayoutId();
    }

    public final void mr() {
        if (this.f == true) goto L5;
    L22:
        ALogger.i("KtvComponentUIWidget", "setLyricViewVisibleCheck ;; isShowingPrepareSongInfo == " + (this.U.g.getValue() instanceof je2.f.C0147f) + " ;; hasFirstPrepareSongInfoShown == " + this.f);
        return;
    L5:
        if ((this.U.g.getValue() instanceof je2.f.C0147f) == true) goto L22;
        if (br() == false) goto L15;
        StringBuilder r0 = new StringBuilder("showLyricsView=");
        KtvComponentUIContext r2 = this.s;
        if (r2 == null) goto L12;
        NextLiveData<Boolean> r3 = r2.getShowLyricsViewAndMidi();
    L13:
        r0.append(r3);
        ALogger.i("KtvComponentUIWidget", r0.toString());
        Qq();
        return;
    L12:
        r3 = null;
        goto L13
    L15:
        KtvSingAndListenerLyricViewV2 r1 = this.T.b;
        if (r1 == null) goto L18;
        r1.setVisibility(0);
    L18:
        ViewPainter r4 = this.T.c;
        if (r4 == null) goto L24;
        r4.setVisibility(0);
        return;
    }

    public final void qr() {
        ViewGroup r0 = this.T.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L5;
        l3 r2 = (l3) r1.get("cmd_video_talkroom_state_change");
    L5:
        ViewGroup.LayoutParams r3 = null;
        if (r0 == null) goto L8;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
    L9:
        ViewGroup.MarginLayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        int r6 = 2131376911;
        if (r0 == null) goto L27;
        if (r5 == null) goto L25;
        ((ConstraintLayout.LayoutParams) r5).bottomToBottom = 2131376945;
        ((ConstraintLayout.LayoutParams) r5).endToStart = 2131376945;
        ((ConstraintLayout.LayoutParams) r5).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r5).startToStart = 0;
        if (MidiContext.Companion.d() == true) goto L15;
        ((ConstraintLayout.LayoutParams) r5).topToTop = 0;
        if (ne2.a.d() == false) goto L22;
        int r7 = 2131376900;
    L23:
        ((ConstraintLayout.LayoutParams) r5).topToBottom = r7;
    L24:
        ((ConstraintLayout.LayoutParams) r5).rightToRight = -1;
        r5.rightMargin = (int) UtilityKotlinExtentionsKt.h(5.0f);
        Unit r8 = Unit.INSTANCE;
    L26:
        r0.setLayoutParams(r5);
        goto L27
    L22:
        r7 = -1;
        goto L23
    L15:
        if (ne2.a.d() == false) goto L17;
        int r9 = 2131376900;
    L18:
        ((ConstraintLayout.LayoutParams) r5).topToBottom = r9;
        ((ConstraintLayout.LayoutParams) r5).topToTop = -1;
        goto L24
    L17:
        r9 = 2131376911;
        goto L18
    L25:
        r5 = null;
    L27:
        View r10 = this.T.e;
        if (r10 == null) goto L30;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L31:
        ViewGroup.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r10 == null) goto L43;
        if (r12 != null) goto L35;
    L42:
        r10.setLayoutParams(r3);
        goto L43
    L35:
        if (MidiContext.Companion.d() == true) goto L37;
        ((ConstraintLayout.LayoutParams) r12).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r12).topToBottom = -1;
    L41:
        Unit r13 = Unit.INSTANCE;
        r3 = r12;
        goto L42
    L37:
        if (ne2.a.d() == false) goto L39;
        r6 = 2131376900;
    L39:
        ((ConstraintLayout.LayoutParams) r12).topToBottom = r6;
        ((ConstraintLayout.LayoutParams) r12).topToTop = -1;
    L43:
        View r14 = this.T.d;
        if (r14 == null) goto L46;
        UtilityKotlinExtentionsKt.t(r14);
    L46:
        this.b1 = false;
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 == null) goto L52;
        com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r16 = r15.getLinkUserInfoCenter();
        if (r16 == null) goto L53;
        er(r16);
        return;
    L53:
        return;
    L52:
        return;
    L30:
        r11 = null;
        goto L31
    L8:
        r4 = null;
        goto L9
    }

    public final void rr() {
        ViewGroup.LayoutParams r2 = null;
        if (this.o != null) goto L13;
        Widget.WidgetCallback r0 = ((Widget) this).widgetCallback;
        if (r0 == null) goto L11;
        WidgetManager r1 = r0.getWidgetManager();
        if (r1 == null) goto L11;
        if (r1.isAdded() == true) goto L13;
    L11:
        if (((Boolean) vm2.h.U0.getValue(null, vm2.h.a[97])).booleanValue() == false) goto L13;
        return;
    L13:
        ViewGroup r3 = this.T.a;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L16;
        l3 r5 = (l3) r4.get("cmd_video_talkroom_state_change");
    L16:
        if (r3 == null) goto L18;
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
    L19:
        ViewGroup.MarginLayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        if (r3 == null) goto L37;
        if (r7 == null) goto L35;
        ((ConstraintLayout.LayoutParams) r7).rightToRight = 0;
        ((ConstraintLayout.LayoutParams) r7).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r7).leftToLeft = 0;
        ((ConstraintLayout.LayoutParams) r7).startToStart = 0;
        int r8 = 2131376900;
        if (MidiContext.Companion.d() == true) goto L25;
        ((ConstraintLayout.LayoutParams) r7).topToTop = 0;
        if (ne2.a.d() == true) goto L33;
        r8 = -1;
    L33:
        ((ConstraintLayout.LayoutParams) r7).topToBottom = r8;
    L34:
        ((ConstraintLayout.LayoutParams) r7).bottomToBottom = -1;
        ((ConstraintLayout.LayoutParams) r7).endToStart = -1;
        r7.rightMargin = (int) UtilityKotlinExtentionsKt.h(20.0f);
        Unit r9 = Unit.INSTANCE;
    L36:
        r3.setLayoutParams(r7);
        goto L37
    L25:
        if (ne2.a.d() == true) goto L28;
        r8 = 2131376911;
    L28:
        ((ConstraintLayout.LayoutParams) r7).topToBottom = r8;
        ((ConstraintLayout.LayoutParams) r7).topToTop = -1;
        goto L34
    L35:
        r7 = null;
    L37:
        View r10 = this.T.e;
        if (r10 == null) goto L40;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L41:
        ViewGroup.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (r10 == null) goto L47;
        if (r12 == null) goto L45;
        ((ConstraintLayout.LayoutParams) r12).topToBottom = 2131377037;
        ((ConstraintLayout.LayoutParams) r12).topToTop = -1;
        Unit r13 = Unit.INSTANCE;
        r2 = r12;
    L45:
        r10.setLayoutParams(r2);
    L47:
        if (this.o != null) goto L51;
        enableSubWidgetManager();
        KtvComponentControlTopBarWidget r14 = new KtvComponentControlTopBarWidget(this.m);
        this.o = r14;
        WidgetManager r15 = ((Widget) this).subWidgetManager;
        if (r15 == null) goto L51;
        r15.load(2131376914, r14);
    L51:
        View r16 = this.T.d;
        if (r16 != null) goto L54;
    L55:
        KtvComponentControlTopBarWidget r17 = this.o;
        if (r17 == null) goto L64;
        TopChallengeFunctionItem r18 = r17.j;
        if (r18.d == false) goto L64;
        ImageView r19 = r18.a;
        if (r19 == null) goto L64;
        if (r19.getVisibility() != 0) goto L64;
        Long r20 = KtvLoggerHelper.a;
        KtvLoggerHelper.b0("shortcut");
    L64:
        View r21 = this.T.d;
        if (r21 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r21);
    L67:
        this.b1 = true;
        IInteractService r22 = jc1.k.f(IInteractService.class);
        if (r22 == null) goto L73;
        com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r23 = r22.getLinkUserInfoCenter();
        if (r23 == null) goto L74;
        er(r23);
        return;
    L74:
        return;
    L73:
        return;
    L54:
        if (r16.getVisibility() == 0) goto L64;
    L40:
        r11 = null;
        goto L41
    L18:
        r6 = null;
        goto L19
    }

    public final void cr() {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.android.live.liveinteract.plantform.base.i r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r2 = r0.getVideoTalkRoomSubScene();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
    L10:
        com.bytedance.android.livesdk.chatroom.u r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.j r6 = r5.s();
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r8 = r7.t();
    L18:
        IRoom r9 = com.bytedance.android.live.liveinteract.linkpanel.util.o.b();
        boolean r10 = true;
        if (r9 != null) goto L21;
    L24:
        if (r4 == null) goto L26;
        Integer r11 = Integer.valueOf(r4.a);
    L27:
        IRoom r12 = com.bytedance.android.live.liveinteract.linkpanel.util.o.b();
        if (r12 != null) goto L30;
    L33:
        if (r4 == null) goto L35;
        Integer r13 = Integer.valueOf(r4.c);
    L37:
        if (r11 != null) goto L40;
    L57:
        boolean r14 = false;
    L58:
        if (r11 != null) goto L61;
    L67:
        r10 = false;
    L68:
        if (r14 == true) goto L72;
        if (r10 == true) goto L72;
        ALogger.e("KtvComponentUIWidget", "observeFullMicSeat just observe in VideoTalkRoom.", new Throwable());
        return;
    L72:
        IInteractService r15 = jc1.k.f(IInteractService.class);
        if (r15 == null) goto L75;
        r1 = r15.getLinkUserInfoCenter();
    L75:
        if (r1 == null) goto L77;
        r1.T4(this.H0);
    L77:
        if (r1 == null) goto L80;
        r1.Q4(this.H0);
        return;
    L80:
        return;
    L61:
        if (5 != r11.intValue()) goto L67;
        if (r13 == null) goto L67;
        if (r13.intValue() != 29) goto L67;
    L40:
        if (8 != r11.intValue()) goto L57;
        if (r13 != null) goto L44;
    L45:
        if (r13 != null) goto L48;
    L49:
        IntRange r16 = new IntRange(z0.TYPE_APPLY, 112);
        if (r13 != null) goto L52;
    L54:
        boolean r17 = false;
    L55:
        if (r17 == false) goto L57;
    L56:
        r14 = true;
        goto L58
    L52:
        if (r16.contains(r13.intValue()) == false) goto L54;
        r17 = true;
        goto L55
    L48:
        if (r13.intValue() == 7) goto L56;
    L44:
        if (r13.intValue() == 1) goto L56;
    L35:
        r13 = null;
        goto L37
    L30:
        if (r12.isLiveTypeAudio() != true) goto L33;
        if (r8 == null) goto L35;
        r13 = Integer.valueOf(r8.b);
    L26:
        r11 = null;
        goto L27
    L21:
        if (r9.isLiveTypeAudio() != true) goto L24;
        if (r8 == null) goto L26;
        r11 = Integer.valueOf(r8.a);
    L17:
        r8 = null;
    L9:
        r4 = null;
        goto L10
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        com.bytedance.android.live.ktv.common.music.download.m r0 = KtvMusicManager.a;
        KtvMusicManager.j();
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r1 == null) goto L9;
        RoomContext r3 = r1.L1();
        if (r3 != null) goto L7;
    L12:
        Zq();
        Wq();
        WidgetViewModelProviders.a.getClass();
        this.s = WidgetViewModelProviders.a(this, null).get(KtvComponentUIContext.class);
        KtvComponentContext.a r4 = KtvComponentContext.Companion;
        KtvComponentContext r5 = r4.getContext();
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r6 = r5.getKtvComponentUIContext();
        if (r6 == null) goto L17;
        r6.setValue(this.s);
    L17:
        this.x = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        KtvContext.Companion.getClass();
        KtvContext r7 = KtvContext.a.g();
        if (r7 == null) goto L22;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.isKtvRoomContextInit();
        if (r8 == null) goto L22;
        r8.setValue(Boolean.TRUE);
    L22:
        Tq();
        Yq(this.y.h(com.bytedance.android.live.ktv.common.util.j.i()));
        hd0.c.f().c((com.bytedance.android.livesdk.app.dataholder.Observer) this.Y.getValue());
        Sq();
        IPerformanceManager r9 = jc1.k.f(IPerformanceManager.class);
        if (r9 == null) goto L25;
        r9.onModuleStart("ktv", null);
    L25:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L28;
        IKtvComponentFeedView r11 = (IKtvComponentFeedView) r10.get("live_ktv_comp_feed_view", null);
    L30:
        if ((r11 instanceof View) == true) goto L32;
        r11 = null;
    L32:
        View r12 = (View) r11;
        if (r12 == null) goto L35;
        r12.setAlpha(0.0f);
    L35:
        View r13 = ((Widget) this).contentView;
        if ((r13 instanceof ViewGroup) == true) goto L38;
        r13 = null;
    L38:
        ViewGroup r14 = (ViewGroup) r13;
        if (ke2.a.e() == false) goto L42;
        if (r14 == null) goto L42;
        UtilityKotlinExtentionsKt.t(r14);
    L42:
        this.T.a = (ViewGroup) findViewById(2131376975);
        this.T.b = (KtvSingAndListenerLyricViewV2) findViewById(2131377033);
        this.T.c = findViewById(2131392574);
        KtvSingAndListenerLyricViewV2 r15 = this.T.b;
        if (r15 == null) goto L47;
        f r16 = this.O;
        Intrinsics.checkNotNullParameter(r16, "listener");
        if (((ArrayList) r15.L).contains(r16) == true) goto L47;
        ((ArrayList) r15.L).add(r16);
    L47:
        this.T.o = (KtvComponentCountDownView) findViewById(2131377031);
        this.T.p = (KtvComponentCountDownView) findViewById(2131377032);
        if (this.r == false) goto L78;
        this.A = KtvContext.a.g().getLyricResourceManager();
        KtvComponentOrderedSongDataContext r17 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r17 == null) goto L54;
        Disposable r18 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b.a.a(r17, true, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.k(this), 1);
        if (r18 == null) goto L54;
        RxUtilKt.c(r18, this.w);
    L54:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r19 = this.A;
        if (r19 == null) goto L57;
        r19.q = KtvComponentUIWidget$initView$2.INSTANCE;
    L57:
        ViewPainter r20 = this.T.c;
        if (r20 == null) goto L60;
        qe2.d.b(r20);
    L60:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r21 = this.T;
        r21.c = null;
        KtvComponentCountDownView r22 = r21.p;
        if (r22 == null) goto L63;
        qe2.d.b(r22);
    L63:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r23 = this.T;
        r23.p = null;
        KtvSingAndListenerLyricViewV2 r24 = r23.b;
        if (r24 == null) goto L88;
        r24.E = false;
        KtvRoomLyricHolder r25 = new KtvRoomLyricHolder(r24, KtvComponentUIWidget$initView$3$1.INSTANCE);
        this.g1 = r25;
        r25.c();
        KtvRoomLyricHolder r26 = this.g1;
        if (r26 == null) goto L68;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r27 = r26.a;
    L69:
        this.u = r27;
        if (r26 == null) goto L72;
        KtvListenerLyricPresenter r28 = r26.b;
    L73:
        this.v = r28;
        if (r28 == null) goto L76;
        r28.i = false;
    L76:
        if (r27 == null) goto L88;
        r27.e = this.T.o;
        goto L88
    L72:
        r28 = null;
        goto L73
    L68:
        r27 = null;
    L88:
        je2.e r29 = this.U.f;
        r29.a = (KtvComponentEmptyView) findViewById(2131377038);
        r29.b = (KtvComponentEmptyView) findViewById(2131377074);
        r29.c = (TextView) findViewById(2131376913);
        r29.d = (TextView) findViewById(2131372925);
        i0 r30 = new i0();
        r30.b((ConstraintLayout) findViewById(2131380104));
        Unit r31 = Unit.INSTANCE;
        r29.e = r30;
        r29.f = (TextView) findViewById(2131379325);
        this.T.d = findViewById(2131376914);
        ub0.b r32 = new ub0.b();
        r32.a = 20.0f;
        r32.b = 14.0f;
        r32.e = s1.G(s1.y() - ((int) UtilityKotlinExtentionsKt.h(100.0f)));
        Paint.Align r33 = Paint.Align.RIGHT;
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r32.f = r33;
        r32.g = 2;
        r32.h = true;
        r32.i = true;
        r32.j = true;
        r32.k = Integer.valueOf(s1.h(2131107706));
        r32.l = Integer.valueOf(s1.h(2131107068));
        r32.m = Integer.valueOf(s1.h(2131107700));
        r32.n = false;
        r32.o = 4;
        this.T.e = findViewById(2131376945);
        this.T.f = (ViewGroup) findViewById(2131377073);
        this.T.g = findViewById(2131377040);
        this.T.h = (ImageView) findViewById(2131376970);
        this.T.j = findViewById(2131376969);
        this.T.k = findViewById(2131380109);
        this.T.l = (KtvComponentMidiView) findViewById(2131376911);
        KtvComponentMidiView r34 = this.T.l;
        if (r34 == null) goto L91;
        r34.qc(this.P);
    L91:
        this.T.m = (ImageView) findViewById(2131370482);
        this.T.i = (TextView) findViewById(2131377061);
        View r35 = this.T.e;
        if (r35 == null) goto L94;
        r35.setOnTouchListener(this.p0);
    L94:
        View r36 = this.T.e;
        if (r36 == null) goto L97;
        r36.setOnClickListener(new w0(new KtvComponentUIWidget$initView$6(this), 500));
    L97:
        r3.c(this.T.e, s1.B(2131918625), true);
        this.T.n = findViewById(2131374430);
        KtvComponentProgressView r37 = this.T.g;
        if (r37 == null) goto L100;
        r37.setProgress(100.0f);
    L100:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.e r38 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.e();
        this.L = r38;
        View r39 = ((Widget) this).contentView;
        KtvComponentMusicReportInfoManager r40 = this.U;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r41 = this.T;
        ImageView r110 = r41.h;
        KtvComponentMidiView r42 = r41.l;
        KtvComponentUIWidget$initView$7 r111 = new KtvComponentUIWidget$initView$7(this);
        Intrinsics.checkNotNullParameter(r40, "ktvComponentMusicReportInfoManager");
        Intrinsics.checkNotNullParameter(r111, "challengeStartAction");
        if (r39 == null) goto L103;
        KtvComponentChallengeProgressView r112 = (KtvComponentChallengeProgressView) r39.findViewById(2131376900);
    L104:
        r38.a = r112;
        if (r39 == null) goto L107;
        View r43 = r39.findViewById(2131376945);
    L108:
        r38.b = r43;
        if (r39 == null) goto L111;
        TextView r44 = (TextView) r39.findViewById(2131376898);
    L112:
        r38.c = r44;
        KtvChallengeDataContext.a r45 = KtvChallengeDataContext.Companion;
        if (r45 == null) goto L117;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r46 = r45.a();
        if (r46 == null) goto L117;
        r46.addKtvChallengeStatusChangedListener(r38);
    L117:
        r38.d = r110;
        r38.g = r40;
        r38.f = r42;
        r38.e = r111;
        KtvComponentContext r47 = r4.getContext();
        if (r47 == null) goto L122;
        com.bytedance.live.datacontext.n<Float> r48 = r47.getBallRelativeY();
        if (r48 == null) goto L122;
        r48.setValue(Float.valueOf(Mq()));
    L122:
        LiveNetworkBroadcastReceiver r49 = this.L0;
        Context r50 = ((Widget) this).context;
        TokenCert r51 = y1;
        r49.b(r50, r51);
        this.L0.a(this.P0, r51);
        com.bytedance.live.datacontext.b.a((MidiContext) com.bytedance.live.datacontext.d.a(KtvComponentUIWidget$initViewModel$pair$1.INSTANCE).getFirst(), MidiContext.class);
        MidiContext.Companion.c(null);
        KtvComponentMidiViewModel r52 = (KtvComponentMidiViewModel) WidgetViewModelProviders.a(this, null).get(KtvComponentMidiViewModel.class);
        this.N = r52;
        if (r52 == null) goto L127;
        KtvComponentMidiView r53 = this.T.l;
        if (r53 == null) goto L127;
        r53.Gk(r52, null);
    L127:
        KtvComponentMidiViewModel r54 = this.N;
        if (r54 == null) goto L132;
        KtvMidiView r55 = this.T.k;
        if (r55 == null) goto L132;
        Intrinsics.checkNotNullParameter(r54, "midiDataHolder");
        r55.c = r54;
    L132:
        KtvComponentMidiViewModel r56 = this.N;
        if (r56 == null) goto L137;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r57 = r56.m333getScoreInfo();
        if (r57 == null) goto L137;
        r57.observe(this, new w(this));
    L137:
        KtvComponentMidiViewModel r58 = this.N;
        if (r58 == null) goto L142;
        MutableLiveData<Boolean> r59 = r58.getHideFeedback();
        if (r59 == null) goto L142;
        r59.observe(this, new x(this));
    L142:
        KtvContext.a.g().getKtvRoomProvider().setValue(this.y);
        KtvComponentRoomStrategy r60 = this.z;
        if (r60 == null) goto L146;
        KtvContext.a.g().getKtvRoomStrategy().setValue(r60);
    L146:
        if (com.bytedance.android.live.core.utils.a0.d(((Widget) this).dataCenter, false) == false) goto L159;
        com.bytedance.android.livesdk.chatroom.o r61 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter);
        if (r61 == null) goto L152;
        com.bytedance.live.datacontext.j r62 = r61.getLiveStream();
        if (r62 == null) goto L152;
        com.bytedance.android.live.pushstream.d r63 = (com.bytedance.android.live.pushstream.d) r62.getValue();
    L153:
        this.y.c = r63;
        KtvContext r64 = KtvContext.a.g();
        if (r64 == null) goto L159;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.liveinteract.plantform.utils.d0> r65 = r64.getStreamInfoSender();
        if (r65 == null) goto L159;
        r65.setValue(((Widget) this).dataCenter.get("live_stream_info_sender_manager", null));
    L152:
        r63 = null;
    L159:
        if (com.bytedance.android.live.liveinteract.api.utils.m.j(this) == null) goto L197;
        KtvContext r66 = KtvContext.a.g();
        if (r66 == null) goto L163;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a r67 = this.y;
        oe2.c r68 = new oe2.c(KtvContext.a.g(), com.bytedance.android.live.liveinteract.api.utils.m.j(this), ((Widget) this).dataCenter);
        r68.b = ((Widget) this).context;
        r66.initKtvCoreAndSingerViewModel(r67, r68, false);
    L163:
        KtvContext r69 = KtvContext.a.g();
        if (r69 == null) goto L168;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r70 = r69.getKtvCoreViewModel();
        if (r70 == null) goto L168;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r71 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r70.getValue();
    L169:
        this.m = r71;
        KtvContext r72 = KtvContext.a.g();
        if (r72 == null) goto L174;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r73 = r72.getKtvSingerViewModel();
        if (r73 == null) goto L174;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r74 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r73.getValue();
    L175:
        this.n = r74;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r75 = KtvComponentOrderSongDataContext.Companion.a();
        if (r75 == null) goto L179;
        r75.getOrderedSongList(true);
    L179:
        if (KtvSettingHelper.f() == true) goto L183;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r76 = this.m;
        if (r76 == null) goto L183;
        r76.sendEvent(KtvRoomLyricsStateMachineConfig.a.g.c, "");
    L183:
        jc1.k.n(IKtvService.class).setKtvCoreViewModel(this.m);
        new KtvRoomViewWrapper(this, this.m, this);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r77 = this.m;
        if (r77 == null) goto L187;
        r77.observerOnProgress(this, new KtvComponentUIWidget$initViewModel$6$2(this));
    L187:
        if ((this.m instanceof BaseCoreViewModel) == false) goto L193;
        boolean r78 = KtvSettingHelper.f();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r79 = this.m;
        if (r79 == null) goto L192;
        ((BaseCoreViewModel) r79).registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_PROGRESS, BaseCoreViewModel.CORE_TAG_DATA_MODEL}), this.V0, r78);
        goto L193
    L192:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel");
    L193:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r80 = this.n;
        if (r80 == null) goto L196;
        r80.onPageCreate();
    L196:
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) this.R.getSeiProcessor().getValue(), this);
    L174:
        r74 = null;
    L168:
        r71 = null;
    L197:
        KtvComponentUIContext r81 = this.s;
        if (r81 == null) goto L206;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.a> r82 = r81.getShowOrHideAdjustDialogEvent();
        if (r82 == null) goto L206;
        Observable r83 = r82.a();
        if (r83 == null) goto L206;
        Disposable r85 = r83.subscribe(new y(this));
        if (r85 == null) goto L206;
        RxUtilKt.c(r85, this.w);
    L206:
        RxUtilKt.c(KtvContext.a.g().getOpenKtvRoomDialogEvent().onEvent().subscribe(new z(this)), this.w);
        Function1<Pair<? extends Integer, ? extends String>, Unit> r86 = new KtvComponentUIWidget$initSchemaOpenEvent$handleTask$1(this);
        com.bytedance.android.livesdk.chatroom.u r87 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r87 == null) goto L217;
        com.bytedance.live.datacontext.n r88 = r87.C();
        if (r88 == null) goto L217;
        Observable r89 = r88.a();
        if (r89 == null) goto L217;
        ObservableSubscribeProxy r90 = (ObservableSubscribeProxy) r89.as(autoDispose());
        if (r90 == null) goto L217;
        Disposable r91 = r90.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.h(r86));
        if (r91 == null) goto L217;
        RxUtilKt.c(r91, this.w);
    L217:
        com.bytedance.android.livesdk.chatroom.u r92 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r92 == null) goto L224;
        com.bytedance.live.datacontext.n r93 = r92.C();
        if (r93 == null) goto L224;
        Pair r94 = (Pair) r93.getValue();
        if (r94 == null) goto L224;
        r86.invoke(r94);
    L224:
        KtvComponentUIContext r95 = this.s;
        if (r95 == null) goto L229;
        NextLiveData<Boolean> r96 = r95.getShowLyricsViewAndMidi();
        if (r96 == null) goto L229;
        r96.observe(this, new a0(this));
    L229:
        KtvComponentUIContext r97 = this.s;
        if (r97 == null) goto L234;
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> r98 = r97.getLyricsSeiModel();
        if (r98 == null) goto L234;
        r98.observe(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.m(this));
    L234:
        KtvComponentContext r99 = r4.getContext();
        if (r99 == null) goto L243;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r100 = r99.getKtvComponentUIContext();
        if (r100 == null) goto L243;
        KtvComponentUIContext r101 = (KtvComponentUIContext) r100.getValue();
        if (r101 == null) goto L243;
        MutableLiveData<Boolean> r102 = r101.getScoreOpen();
        if (r102 == null) goto L243;
        r102.observe(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.n(this));
    L243:
        KtvComponentContext r103 = r4.getContext();
        if (r103 == null) goto L252;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r104 = r103.getKtvComponentUIContext();
        if (r104 == null) goto L252;
        KtvComponentUIContext r105 = (KtvComponentUIContext) r104.getValue();
        if (r105 == null) goto L252;
        MutableLiveData<Boolean> r106 = r105.getSingerScoreOpen();
        if (r106 == null) goto L252;
        r106.observe(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.o(this));
    L252:
        KtvComponentMidiViewModel r107 = this.N;
        if (r107 == null) goto L257;
        MutableLiveData<List<cb0.c>> r108 = r107.getMidiData();
        if (r108 == null) goto L257;
        r108.observe(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.p(this));
    L257:
        KtvContext r109 = KtvContext.a.g();
        if (r109 == null) goto L266;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r113 = r109.getKtvCoreController();
        if (r113 == null) goto L266;
        Observable r114 = r113.a();
        if (r114 == null) goto L266;
        Disposable r115 = r114.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.r(this));
        if (r115 == null) goto L266;
        RxUtilKt.c(r115, this.w);
    L266:
        KtvContext r116 = KtvContext.a.g();
        if (r116 == null) goto L275;
        com.bytedance.live.datacontext.k<com.bytedance.android.livesdk.ktvimpl.base.util.i> r117 = r116.getKtvContainerPositionUpdateEvent();
        if (r117 == null) goto L275;
        PublishSubject r118 = r117.onEvent();
        if (r118 == null) goto L275;
        Disposable r119 = r118.subscribe(new s(this));
        if (r119 == null) goto L275;
        RxUtilKt.c(r119, this.w);
    L275:
        ChorusContext.a r120 = ChorusContext.Companion;
        ChorusContext r121 = r120.getContext();
        if (r121 == null) goto L284;
        com.bytedance.live.datacontext.n<Boolean> r122 = r121.getChorusOpenStatus();
        if (r122 == null) goto L284;
        Observable r123 = r122.a();
        if (r123 == null) goto L284;
        Disposable r124 = r123.subscribe(t.a);
        if (r124 == null) goto L284;
        RxUtilKt.c(r124, this.w);
    L284:
        KtvComponentUIContext r125 = this.s;
        if (r125 == null) goto L287;
        r125.handleFeedEnterData(((Widget) this).dataCenter);
    L287:
        RxUtilKt.c(KtvContext.a.g().observeSingEndedFeedbackSei(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.l(this)), this.w);
        com.bytedance.android.live.pushstream.d r126 = this.y.h(com.bytedance.android.live.ktv.common.util.j.i());
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L291;
        if (r126 == null) goto L291;
        KtvContext.a.g().getKtvCoreController().setValue(new com.bytedance.android.livesdk.ktvimpl.base.i(r126, (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue()));
    L291:
        KtvComponentContext r127 = r4.getContext();
        if (r127 == null) goto L300;
        com.bytedance.live.datacontext.m<Integer> r128 = r127.getPanelState();
        if (r128 == null) goto L300;
        Observable r129 = r128.a();
        if (r129 == null) goto L300;
        Disposable r130 = r129.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.g(this));
        if (r130 == null) goto L300;
        RxUtilKt.c(r130, this.w);
    L300:
        KtvComponentMusicReportInfoManager r131 = this.U;
        r131.g.observeForever(r131.h);
        com.bytedance.android.livesdk.chatroom.o r132 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r132 == null) goto L319;
        com.bytedance.live.datacontext.m r133 = r132.getRoom();
        if (r133 == null) goto L319;
        IRoom r134 = (IRoom) r133.getValue();
        if (r134 == null) goto L319;
        if (r134.isLiveTypeAudio() != true) goto L319;
        com.bytedance.android.livesdk.chatroom.u r135 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r135 == null) goto L330;
        com.bytedance.live.datacontext.j r136 = r135.s();
        if (r136 == null) goto L330;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r137 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r136.getValue();
        if (r137 == null) goto L330;
        BehaviorSubject r138 = r137.a();
        if (r138 == null) goto L330;
        Disposable r139 = r138.subscribe(new u(this));
        if (r139 == null) goto L330;
        RxUtilKt.c(r139, this.w);
    L330:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r140 = KtvComponentOrderSongDataContext.Companion.a();
        if (r140 == null) goto L344;
        MutableLiveData<vb0.a> r141 = r140.getOrderSongUiState();
        if (r141 == null) goto L344;
        vb0.a r142 = (vb0.a) r141.getValue();
        if (r142 == null) goto L344;
        if (r142.j == true) goto L344;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r143 = KtvComponentOrderSongDataContext.Companion.a();
        if ((r143 instanceof KtvComponentOrderSongViewModel) == true) goto L341;
        r143 = null;
    L341:
        KtvComponentOrderSongViewModel r144 = (KtvComponentOrderSongViewModel) r143;
        if (r144 == null) goto L344;
        r144.updateCurrentKSongElementMethod(false);
    L344:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r145 = this.t;
        if (r145 == null) goto L347;
        r145.k(this, this.s, this.T, new AnonymousClass2(this));
    L347:
        Function0<Unit> r146 = this.v1;
        if (r146 == null) goto L350;
        Unit r147 = (Unit) r146.invoke();
    L350:
        cr();
        dr();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r148 = this.m;
        if ((r148 instanceof BaseCoreViewModel) == true) goto L353;
        r148 = null;
    L353:
        BaseCoreViewModel r149 = (BaseCoreViewModel) r148;
        if (r149 == null) goto L356;
        r149.setStateMachineFinishCB(new AnonymousClass3(this));
    L356:
        sr();
        ChorusContext r150 = r120.getContext();
        if (r150 == null) goto L365;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r151 = r150.getChorusSelectedSongList();
        if (r151 == null) goto L365;
        Observable r152 = r151.a();
        if (r152 == null) goto L365;
        Disposable r153 = r152.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.i(this));
        if (r153 == null) goto L365;
        RxUtilKt.c(r153, this.w);
    L365:
        KtvComponentOrderedSongDataContext r154 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r154 == null) goto L370;
        Disposable r2 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r154, null, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.j(this), 3);
        if (r2 == null) goto L370;
        RxUtilKt.c(r2, this.w);
    L370:
        IMiddlewareUserService r155 = jc1.k.f(IMiddlewareUserService.class);
        if (r155 == null) goto L379;
        com.bytedance.android.livesdk.user.e r156 = r155.user();
        if (r156 == null) goto L379;
        Observable r157 = r156.u();
        if (r157 == null) goto L379;
        Disposable r158 = r157.subscribe(new c0(this));
        if (r158 == null) goto L379;
        RxUtilKt.c(r158, this.w);
    L379:
        ChorusContext r159 = r120.getContext();
        if (r159 == null) goto L388;
        com.bytedance.live.datacontext.n<Boolean> r160 = r159.getChorusOpenStatus();
        if (r160 == null) goto L388;
        Observable r161 = r160.a();
        if (r161 == null) goto L388;
        Disposable r162 = r161.subscribe(new j(this));
        if (r162 == null) goto L388;
        RxUtilKt.c(r162, this.w);
    L388:
        ((Widget) this).dataCenter.observe("data_promotion_right_card_container_show", this, true);
        ((Widget) this).dataCenter.observe("data_multi_link_dynamic_layout_info_change", this, true);
        ((Widget) this).dataCenter.observe("data_ksong_unread_count", this);
        com.bytedance.live.datacontext.m r163 = r1.getRoom();
        if (r163 == null) goto L403;
        IRoom r164 = (IRoom) r163.getValue();
        if (r164 == null) goto L403;
        if (r164.isLiveTypeAudio() != true) goto L403;
        com.bytedance.live.datacontext.j r165 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r165 == null) goto L413;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r166 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r165.getValue();
        if (r166 == null) goto L414;
        BehaviorSubject r167 = r166.a();
        if (r167 == null) goto L415;
        final AnonymousClass5 r168 = new AnonymousClass5(this);
        Disposable r169 = r167.subscribe(new o(r168));
        if (r169 == null) goto L416;
        RxUtilKt.c(r169, this.w);
        return;
    L416:
        return;
    L415:
        return;
    L414:
        return;
    L413:
        return;
    L403:
        com.bytedance.live.datacontext.j r170 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r170 == null) goto L418;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r171 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r170.getValue();
        if (r171 == null) goto L419;
        BehaviorSubject r172 = r171.a();
        if (r172 == null) goto L420;
        final AnonymousClass6 r173 = new AnonymousClass6(this);
        Disposable r174 = r172.subscribe(new o(r173));
        if (r174 == null) goto L421;
        RxUtilKt.c(r174, this.w);
        return;
    L421:
        return;
    L420:
        return;
    L419:
        return;
    L418:
        return;
    L319:
        com.bytedance.android.livesdk.chatroom.u r175 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r175 == null) goto L330;
        com.bytedance.live.datacontext.j r176 = r175.getVideoTalkRoomSubScene();
        if (r176 == null) goto L330;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r177 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r176.getValue();
        if (r177 == null) goto L330;
        BehaviorSubject r178 = r177.d();
        if (r178 == null) goto L330;
        Disposable r179 = r178.subscribe(new v(this));
        if (r179 == null) goto L330;
        RxUtilKt.c(r179, this.w);
        goto L330
    L111:
        r44 = null;
        goto L112
    L107:
        r43 = null;
        goto L108
    L103:
        r112 = null;
        goto L104
    L78:
        ViewPainter r180 = this.T.c;
        if (r180 == null) goto L81;
        r180.setVisibility(0);
        LyricsDisplayConfig r181 = new LyricsDisplayConfig();
        r181.a();
        Intrinsics.checkNotNullParameter(r181, "config");
        Intrinsics.checkNotNullParameter(r180, "painter");
        Context r182 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r182, "context");
        LyricComponentImplManager r183 = new LyricComponentImplManager(r182, r181, new com.bytedance.component.lyric.a(r182, r180));
        this.S = r183;
        KtvComponentUIWidget$initView$$inlined$let$lambda$1 r184 = new KtvComponentUIWidget$initView$$inlined$let$lambda$1(this);
        Intrinsics.checkNotNullParameter(r184, "factory");
        r183.d = r184;
        this.p = new LyricComponentListenerPresenter(r183, this.O);
    L81:
        KtvComponentCountDownView r185 = this.T.o;
        if (r185 == null) goto L84;
        qe2.d.b(r185);
    L84:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r186 = this.T;
        r186.o = r186.p;
        KtvSingAndListenerLyricViewV2 r187 = r186.b;
        if (r187 == null) goto L87;
        qe2.d.b(r187);
    L87:
        this.T.b = null;
        goto L88
    L28:
        r11 = null;
        goto L30
    L7:
        if (r3.isCleared() != true) goto L12;
    L9:
        if (((Boolean) vm2.h.W0.getValue(null, vm2.h.a[99])).booleanValue() == false) goto L12;
        ALogger.w("KtvComponentUIWidget", "roomcontext is null");
    }

    public final void onDestroy() {
        ALogger.i(bb0.b.b(), "KtvComponentUIWidget onDestroy, invoke class :KtvComponentUIWidget");
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        vb6.g r1 = r0.O5();
        if (r1 == null) goto L7;
        r1.a1(this.k0);
    L7:
        this.f = false;
        KSongOrderSongUtilKt.b(((Widget) this).context, CloseOrderSongDialogSource.BUSINESS_WIDGET_DESTROY);
        Pair<? extends DataContext, ? extends Disposable> r2 = this.j;
        if (r2 == null) goto L14;
        Disposable r3 = (Disposable) r2.getSecond();
        if (r3 == null) goto L14;
        if (r3.isDisposed() == true) goto L14;
        r3.dispose();
        this.j = null;
    L14:
        Pair<? extends DataContext, ? extends Disposable> r4 = this.k;
        if (r4 == null) goto L21;
        Disposable r5 = (Disposable) r4.getSecond();
        if (r5 == null) goto L21;
        if (r5.isDisposed() == true) goto L21;
        r5.dispose();
        this.k = null;
    L21:
        this.l = null;
        KtvComponentContext.a r6 = KtvComponentContext.Companion;
        KtvComponentContext r7 = r6.getContext();
        if (r7 == null) goto L26;
        com.bytedance.live.datacontext.n<Float> r8 = r7.getBallRelativeY();
        if (r8 == null) goto L26;
        r8.setValue(null);
    L26:
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r9 = this.i;
        if (r9 == null) goto L33;
        Disposable r10 = (Disposable) r9.getSecond();
        if (r10 == null) goto L33;
        if (r10.isDisposed() == true) goto L33;
        r10.dispose();
        this.i = null;
    L33:
        hd0.c.f().e((com.bytedance.android.livesdk.app.dataholder.Observer) this.Y.getValue());
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L36;
        IKtvComponentFeedView r12 = (IKtvComponentFeedView) r11.get("live_ktv_comp_feed_view", null);
    L38:
        if ((r12 instanceof View) == true) goto L40;
        r12 = null;
    L40:
        View r13 = (View) r12;
        if (r13 == null) goto L43;
        r13.setAlpha(1.0f);
    L43:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L46;
        r14.put("live_ktv_comp_feed_view", null);
    L46:
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r15 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.R.getSeiProcessor().getValue();
        if (r15 == null) goto L49;
        r15.g(this.X);
    L49:
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r16 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.R.getSeiProcessor().getValue();
        if (r16 == null) goto L52;
        r16.g(this);
    L52:
        this.V = s1.j(2131168828);
        LyricComponentListenerPresenter r17 = this.p;
        if (r17 == null) goto L55;
        r17.b();
    L55:
        LyricComponentImplManager r18 = this.S;
        if (r18 == null) goto L58;
        r18.m();
    L58:
        ViewGroup r19 = ((Widget) this).containerView;
        if (r19 == null) goto L77;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L77;
        if ((r20 instanceof FrameLayout.LayoutParams) == true) goto L65;
        ViewGroup.LayoutParams r21 = null;
    L66:
        ViewGroup.MarginLayoutParams r22 = (FrameLayout.LayoutParams) r21;
        if (r22 == null) goto L70;
    L73:
        if (r22 == null) goto L77;
        r22.topMargin = 0;
        ViewGroup r23 = ((Widget) this).containerView;
        if (r23 == null) goto L77;
        r23.setLayoutParams(r22);
        goto L77
    L70:
        if ((r20 instanceof RelativeLayout.LayoutParams) == true) goto L72;
        r20 = null;
    L72:
        r22 = (RelativeLayout.LayoutParams) r20;
        goto L73
    L65:
        r21 = r20;
    L77:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r24 = this.A;
        if (r24 == null) goto L80;
        r24.q = null;
    L80:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r25 = this.t;
        if (r25 == null) goto L83;
        r25.onDestroy();
    L83:
        KtvSingAndListenerLyricViewV2 r26 = this.T.b;
        if (r26 == null) goto L88;
        f r27 = this.O;
        Intrinsics.checkNotNullParameter(r27, "listener");
        if (((ArrayList) r26.L).contains(r27) == false) goto L88;
        ((ArrayList) r26.L).remove(r27);
    L88:
        this.U.a();
        KtvRoomLyricHolder r28 = this.g1;
        if (r28 == null) goto L91;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getLyricsChangeLiveData().removeObserver(r28);
        KtvListenerLyricPresenter r29 = r28.b;
        r29.d();
        r29.m = null;
        r29.h.e.removeObserver(r29);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r30 = r28.a;
        r30.b = 0;
        r30.a.release();
        r28.d.dispose();
    L91:
        this.L0.c(this.P0);
        this.L0.d();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r31 = this.m;
        if (r31 == null) goto L94;
        r31.sendEvent(KtvRoomLyricsStateMachineConfig.a.C0031a.c, "KtvComponentUIWidget");
    L94:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r32 = this.n;
        if (r32 == null) goto L97;
        r32.clearData();
    L97:
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r33 = KtvContext.a.g().getKtvSingerViewModel();
        if (r33 == null) goto L100;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r34 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r33.getValue();
    L102:
        if (Intrinsics.areEqual(r34, this.n) == false) goto L106;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r35 = KtvContext.a.g().getKtvSingerViewModel();
        if (r35 == null) goto L106;
        r35.setValue(null);
    L106:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r36 = this.m;
        if (r36 == null) goto L109;
        r36.clearData();
    L109:
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r37 = KtvContext.a.g().getKtvCoreViewModel();
        if (r37 == null) goto L112;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r38 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r37.getValue();
    L114:
        if (Intrinsics.areEqual(r38, this.m) == false) goto L119;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r39 = KtvContext.a.g().getKtvCoreViewModel();
        if (r39 == null) goto L119;
        r39.setValue(null);
    L119:
        if ((KtvContext.a.g().getKtvRoomProvider().getValue() instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a) == false) goto L122;
        KtvContext.a.g().getKtvRoomProvider().setValue(null);
    L122:
        if ((KtvContext.a.g().getKtvRoomStrategy().getValue() instanceof KtvComponentRoomStrategy) == false) goto L124;
        KtvContext.a.g().getKtvRoomStrategy().setValue(new com.bytedance.android.livesdk.ktvimpl.base.util.b());
    L124:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r40 = this.m;
        if ((r40 instanceof BaseCoreViewModel) == false) goto L130;
        if (r40 == null) goto L129;
        ((BaseCoreViewModel) r40).unregisterKtvCoreListener(this.V0);
        goto L130
    L129:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel");
    L130:
        KtvContext.a.n(1);
        com.bytedance.android.live.ktv.common.music.download.m r41 = KtvMusicManager.a;
        KtvMusicManager.d();
        Lazy r42 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().e();
        KtvComponentContext r43 = r6.getContext();
        if (r43 == null) goto L135;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r44 = r43.getKtvComponentUIContext();
        if (r44 == null) goto L135;
        r44.setValue(null);
    L135:
        this.w.dispose();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r45 = KtvRoomContext.a.a();
        Pair<KtvRoomContext, ? extends Disposable> r46 = this.x;
        if (r46 == null) goto L138;
        KtvRoomContext r47 = (KtvRoomContext) r46.getFirst();
    L140:
        if (Intrinsics.areEqual(r45, r47) == false) goto L150;
        if (r45 == null) goto L145;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r48 = r45.getPreviewViewModel();
        if (r48 == null) goto L145;
        r48.setValue(null);
    L145:
        Pair<KtvRoomContext, ? extends Disposable> r49 = this.x;
        if (r49 == null) goto L150;
        Disposable r50 = (Disposable) r49.getSecond();
        if (r50 == null) goto L150;
        r50.dispose();
    L150:
        AbsKSongScoreFinishFragment r51 = this.H;
        if (r51 == null) goto L164;
        if (r51.isShowing() != true) goto L164;
        AbsKSongScoreFinishFragment r52 = this.H;
        if (r52 != null) goto L212;
    L162:
        this.H = null;
        goto L164
    L212:
        r52.dismissAllowingStateLoss();     // Catch: Exception -> L158
    L158:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r53 = DialogFragmentLancet.sLastShowStack;
        if (r53 == null) goto L162;
        com.bytedance.crash.d.d(r53, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L164:
        if (vm2.d.q0().isFeedInfoTransport() == false) goto L171;
        DataCenter r54 = ((Widget) this).dataCenter;
        if (r54 == null) goto L168;
        r54.put("video_ktv_sei_model", null);
    L168:
        DataCenter r55 = ((Widget) this).dataCenter;
        if (r55 == null) goto L171;
        r55.put("video_ktv_current_sing_user_id", "");
    L171:
        DataCenter r56 = ((Widget) this).dataCenter;
        if (r56 == null) goto L175;
        r56.removeObserver(this.Z);
    L175:
        if (KtvSettingHelper.r().booleanValue() == false) goto L180;
        DataCenter r57 = ((Widget) this).dataCenter;
        if (r57 == null) goto L180;
        r57.removeObserver(this);
    L180:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixDataCenter() == false) goto L184;
        DataCenter r58 = ((Widget) this).dataCenter;
        if (r58 == null) goto L184;
        r58.removeObserver(this);
    L184:
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r59 = KtvComponentOrderSongDataContext.Companion.a();
        if ((r59 instanceof KtvComponentOrderSongViewModel) == true) goto L187;
        r59 = null;
    L187:
        KtvComponentOrderSongViewModel r60 = (KtvComponentOrderSongViewModel) r59;
        if (r60 == null) goto L190;
        r60.updateCurrentKSongElementMethod(false);
    L190:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.e r61 = this.L;
        if (r61 == null) goto L197;
        r61.e = null;
        KtvChallengeDataContext.a r62 = KtvChallengeDataContext.Companion;
        if (r62 == null) goto L197;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r63 = r62.a();
        if (r63 == null) goto L197;
        r63.removeKtvChallengeStatusChangedListener(r61);
    L197:
        KtvChallengeDataContext.a r64 = KtvChallengeDataContext.Companion;
        if (r64 == null) goto L203;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r65 = r64.a();
        if (r65 == null) goto L203;
        r65.onComponentClose();
    L203:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L208;
        com.bytedance.android.live.pushstream.d r66 = this.y.h(com.bytedance.android.live.ktv.common.util.j.i());
        if (r66 == null) goto L207;
        r66.c1("ktv_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.t.c(0, null, com.bytedance.android.live.ktv.common.util.a.c().getOwnerUserIdString()).put("anchor_id", this.d), 1, true, false);
    L207:
        com.bytedance.android.live.core.utils.i0.c().postDelayed(new k(this, r66), 100);
    L208:
        super.onDestroy();
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L214;
        ((Widget) this).widgetCallback = null;
        return;
    L214:
        return;
    L138:
        r47 = null;
        goto L140
    L112:
        r38 = null;
        goto L114
    L100:
        r34 = null;
        goto L102
    L36:
        r12 = null;
        goto L38
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        if (vm2.h.N() == false) goto L6;
        this.T.getClass();
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r0 = this.n;
        if (r0 == null) goto L5;
        r0.onPageResume();
    L5:
        Zq();
        if (vm2.h.N() == false) goto L9;
        this.T.getClass();
        return;
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r0 = this.n;
        if (r0 == null) goto L6;
        r0.onPageStop();
        return;
    }

    public final void sr() {
        if (kr() == false) goto L5;
        rr();
    L6:
        KtvContext.Companion.getClass();
        Disposable r0 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new p(this), 3, null);
        if (r0 == null) goto L10;
        RxUtilKt.c(r0, this.w);
        return;
    L10:
        return;
    L5:
        qr();
        goto L6
    }

    public final void tr() {
        if (kr() == false) goto L8;
        if (this.b1 == true) goto L11;
        this.b1 = true;
        Lq(new KtvComponentUIWidget$switchUiWithAnimation$1(this));
        return;
    L11:
        return;
    L8:
        if (this.b1 == false) goto L13;
        this.b1 = false;
        Lq(new KtvComponentUIWidget$switchUiWithAnimation$2(this));
        return;
    }

    public static final void Eq(KtvComponentUIWidget r7) {
        r7.getClass();
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = KtvComponentOrderSongDataContext.Companion.b();
        if (r0 == null) goto L9;
        List r1 = r0.getSecondLevelTabDataList(FirstLevelTab.MySongTab.getValue());
        if (r1 == null) goto L9;
        boolean r2 = true;
        if ((!r1.isEmpty()) != true) goto L9;
    L10:
        if (r2 == false) goto L17;
        KSongOrderSongUtilKt.b(((Widget) r7).context, CloseOrderSongDialogSource.SWITCH_SCENE);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = KtvComponentOrderSongDataContext.Companion.a();
        if (r8 == null) goto L14;
        ModeType r9 = r8.getModeType();
    L15:
        KSongOrderSongUtilKt.o(r9, KtvComponentOrderSongDataContext.Companion.b(), FirstLevelTab.MySongTab, null, true, null, 32);
        return;
    L14:
        r9 = null;
        goto L15
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public static int Fq(Context r2) {
        int r0 = (s1.w() - s1.j(2131169164)) - s1.j(2131168852);
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r2, true, true) == true) goto L7;
        r0 = r0 - s1.A();
    L7:
        if (MidiContext.Companion.d() == true) goto L9;
        return r0;
    L9:
        return r0 - (s1.j(2131168818) + s1.j(2131168826));
    }

    public static void Kq(KtvComponentUIWidget r3) {
        fd0.f r4 = LiveAnimator.a(new View[]{((Widget) r3).containerView});
        r4.a();
        r4.a.b = 200;
        r4.e().i = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.d(null);
    }

    public final void Gq(MusicPanel r6) {
        boolean r1 = true;
        if (KtvSettingHelper.g().b() == 1) goto L6;
        return;
    L6:
        if (br() == false) goto L9;
        ALogger.i("KtvComponentUIWidget", "checkScoreSwitchState dismiss lyrics and midi");
        return;
    L9:
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L19;
        String r8 = r7.getMidiUrl();
        if (r8 == null) goto L19;
        if (r8.length() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 != true) goto L19;
        boolean r10 = true;
    L20:
        KtvComponentUIContext r2 = this.s;
        if (r2 == null) goto L26;
        MutableLiveData<Boolean> r3 = r2.getScoreOpen();
        if (r3 == null) goto L26;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L26;
    L27:
        boolean r5 = r4.booleanValue();
        KtvComponentUIContext r11 = this.s;
        if (r11 == null) goto L33;
        MutableLiveData<Boolean> r12 = r11.getSingerScoreOpen();
        if (r12 == null) goto L33;
        Boolean r13 = (Boolean) r12.getValue();
        if (r13 == null) goto L33;
    L34:
        boolean r14 = r13.booleanValue();
        if (r5 == true) goto L37;
    L38:
        if (r14 == false) goto L48;
    L39:
        if (r10 == false) goto L48;
        if (MidiContext.Companion.d() == false) goto L45;
        com.bytedance.android.live.ktv.common.util.c r15 = this.T.l;
        if (r15 == null) goto L55;
        r15.setVisibility(0);
    L55:
        if (Iq() == false) goto L62;
        if (r5 == false) goto L59;
        if (r10 == false) goto L59;
    L60:
        gr(r1);
        return;
    L59:
        r1 = false;
        goto L60
    L62:
        return;
    L45:
        KtvMidiView r16 = this.T.k;
        if (r16 == null) goto L55;
        r16.setVisibility(0);
    L48:
        KtvMidiView r17 = this.T.k;
        if (r17 == null) goto L51;
        r17.setVisibility(8);
    L51:
        com.bytedance.android.live.ktv.common.util.c r18 = this.T.l;
        if (r18 == null) goto L55;
        r18.setVisibility(8);
        goto L55
    L37:
        if (Iq() == true) goto L39;
    L33:
        r13 = Boolean.FALSE;
    L26:
        r4 = Boolean.FALSE;
        goto L27
    L16:
        r9 = false;
    L19:
        r10 = false;
        goto L20
    }

    public final void Jq(MusicPanel r6) {
        List r0 = r6.a.getMLyricUrlList();
        final String r1 = null;
        if (r0 == null) goto L11;
        final String r2 = (String) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r3 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvMusic r4 = r6.a;
        r3.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r4) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L11;
    L12:
        long r5 = r6.a.getMId();
        String r7 = r6.l;
        if (r7 != null) goto L15;
    L18:
        com.bytedance.android.live.ktv.common.music.download.h r8 = com.bytedance.android.live.ktv.common.music.download.h.a;
        r1 = com.bytedance.android.live.ktv.common.music.download.h.d(r2, r5);
    L19:
        ALogger.i("LyricComponentImplManager", "doLoadLyric: " + r5 + ",url:" + r2);
        UtilityKotlinExtentionsKt.b(this, new KtvComponentUIWidget$doLoadLyric$1(this, r2, r1));
        return;
    L15:
        if ((!TextUtils.isEmpty(r7)) == false) goto L17;
        r1 = r7;
    L17:
        if (r1 != null) goto L19;
    L11:
        r2 = "";
        goto L12
    }

    public final void Lq(Function0<Unit> r5) {
        fd0.f r0 = LiveAnimator.a(new View[]{((Widget) this).containerView});
        r0.b();
        r0.a.b = 200;
        r0.e().i = new b(r5);
    }

    public final void Pq(MusicPanel r10) {
        Rq();
        tr();
        LyricComponentImplManager r0 = this.S;
        int r3 = 0;
        if (r0 == null) goto L11;
        jg4.j r1 = r0.a;
        if (r1 == null) goto L11;
        jg4.a r4 = r1.f;
        if (r4 != null) goto L9;
    L20:
        boolean r2 = false;
    L21:
        Boolean r5 = Boolean.valueOf(r2);
    L23:
        String r6 = "handleSongEnd isAnchor: " + com.bytedance.android.live.ktv.common.util.j.i() + "  isDrawLast: " + r5 + "  lastMidiIndex: " + this.I;
        ALogger.i(bb0.b.b(), r6 + ", invoke class :KtvComponentUIWidget");
        this.I = -1;
        KtvComponentMidiViewModel r7 = this.N;
        if (r7 == null) goto L28;
        Intrinsics.checkNotNull(r7);
        if (r7.getTotalScore() == 0) goto L28;
        KtvComponentMidiViewModel r8 = this.N;
        Intrinsics.checkNotNull(r8);
        float r9 = r8.getCurTotalScore();
        KtvComponentMidiViewModel r11 = this.N;
        Intrinsics.checkNotNull(r11);
        float r12 = r9 / r11.getTotalScore();
    L29:
        MidiContext.a r13 = MidiContext.Companion;
        if (r13.d() == false) goto L56;
        ConstraintLayout r14 = this.T.l;
        if (r14 != null) goto L34;
    L81:
        KtvComponentUIContext r15 = this.s;
        if (r15 == null) goto L87;
        MutableLiveData<Boolean> r16 = r15.getScoreOpen();
        if (r16 == null) goto L87;
        Boolean r17 = (Boolean) r16.getValue();
        if (r17 == null) goto L87;
    L88:
        boolean r18 = r17.booleanValue();
        IBaseUser r19 = jc1.k.n(IMiddlewareUserService.class).user().b();
        if (r18 == false) goto L122;
        if (r10 == null) goto L98;
        KtvMusic r110 = r10.a;
        if (r110 == null) goto L98;
        OrderInfo r111 = r110.getOrderInfo();
        if (r111 == null) goto L98;
        InteractiveSongUserInfo r112 = r111.getTopUser();
        if (r112 == null) goto L98;
        String r113 = r112.getIdString();
    L100:
        if (Intrinsics.areEqual(r113, r19.getIdString()) == false) goto L122;
        fr(com.bytedance.android.livesdk.ktvimpl.base.sei.t.d(1003, r12, null, Boolean.valueOf(r18)));
        if (isViewValid() == false) goto L122;
        if (r13.d() == true) goto L122;
        boolean r114 = ((Widget) this).context instanceof FragmentActivity;
        AbsKSongScoreFinishFragment r115 = this.H;
        if (r115 != null) goto L108;
    L110:
        int r116 = KtvComponentSingerScoreFinishFragment.k;
        KtvComponentMidiViewModel r117 = this.N;
        if (r117 == null) goto L113;
        int r118 = r117.getCurTotalScore();
    L114:
        KtvComponentMidiViewModel r20 = this.N;
        if (r20 == null) goto L117;
        r3 = r20.getCurTotalScore();
    L117:
        DataCenter r21 = ((Widget) this).dataCenter;
        KtvComponentSingerScoreFinishFragment r22 = new KtvComponentSingerScoreFinishFragment();
        r22.j = r21;
        Bundle r23 = new Bundle();
        r23.putInt("ARG_CUR_TOTAL_SCORE", r118);
        r23.putInt("ARG_TOTAL_SCORE", r3);
        r22.setArguments(r23);
        this.H = r22;
        FragmentActivity r119 = ((Widget) this).context;
        if (r119 == null) goto L121;
        wq(r22, r119.getSupportFragmentManager(), "KtvAnchorScoreFinishFragment");
        goto L122
    L121:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L113:
        r118 = 0;
        goto L114
    L108:
        if (r115.isShowing() != true) goto L110;
    L98:
        r113 = null;
    L122:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r120 = this.T;
        if (r120 == null) goto L127;
        KtvComponentMidiView r121 = r120.l;
        if (r121 == null) goto L127;
        r121.reset();
    L127:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r122 = this.T;
        if (r122 == null) goto L132;
        KtvMidiView r123 = r122.k;
        if (r123 == null) goto L132;
        r123.setVisibility(8);
    L132:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r124 = this.T;
        if (r124 == null) goto L137;
        com.bytedance.android.live.ktv.common.util.c r125 = r124.l;
        if (r125 == null) goto L137;
        r125.setVisibility(8);
    L137:
        tr();
        return;
    L87:
        r17 = Boolean.FALSE;
        goto L88
    L34:
        if (r14.getVisibility() != 0) goto L50;
        KtvComponentMidiViewModel r24 = this.N;
        if (r24 == null) goto L40;
        MutableLiveData<List<cb0.c>> r25 = r24.getMidiData();
        if (r25 == null) goto L40;
        List r26 = (List) r25.getValue();
    L41:
        List r27 = r26;
        if (r27 != null) goto L44;
    L47:
        boolean r28 = true;
    L48:
        if (r28 == true) goto L50;
        boolean r29 = true;
    L51:
        if (r29 == true) goto L54;
        r14 = null;
    L54:
        if (r14 == null) goto L81;
        r14.R2(0);
        goto L81
    L44:
        if (r27.isEmpty() == true) goto L47;
        r28 = false;
    L40:
        r26 = null;
    L50:
        r29 = false;
        goto L51
    L56:
        KtvMidiView r30 = this.T.k;
        if (r30 == null) goto L81;
        if (r30.getVisibility() != 0) goto L75;
        KtvComponentMidiViewModel r31 = this.N;
        if (r31 == null) goto L65;
        MutableLiveData<List<cb0.c>> r32 = r31.getMidiData();
        if (r32 == null) goto L65;
        List r33 = (List) r32.getValue();
    L66:
        List r34 = r33;
        if (r34 != null) goto L69;
    L72:
        boolean r35 = true;
    L73:
        if (r35 == true) goto L75;
        boolean r36 = true;
    L76:
        if (r36 == true) goto L79;
        r30 = null;
    L79:
        if (r30 == null) goto L81;
        r30.b(0);
        goto L81
    L69:
        if (r34.isEmpty() == true) goto L72;
        r35 = false;
    L65:
        r33 = null;
    L75:
        r36 = false;
    L28:
        r12 = 0.0f;
        goto L29
    L9:
        if (r4.c != (r1.e.size() - 1)) goto L20;
    L19:
        r2 = true;
    L11:
        KtvSingAndListenerLyricViewV2 r37 = this.T.b;
        if (r37 == null) goto L22;
        int r38 = r37.m;
        if (r38 <= 0) goto L20;
        if (r38 != (r37.h.size() - 1)) goto L20;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(r37.h, r37.m)).c > r37.d) goto L20;
    L22:
        r5 = null;
        goto L23
    }

    public final void Yq(com.bytedance.android.live.pushstream.d r3) {
        Pair<? extends DataContext, ? extends Disposable> r0 = this.j;
        if (r0 == null) goto L9;
        Disposable r1 = (Disposable) r0.getSecond();
        if (r1 == null) goto L9;
        if (r1.isDisposed() == true) goto L9;
        r1.dispose();
        this.j = null;
    L9:
        this.j = KSongTuningPanelHelperKt.b(false, r3, new WeakReference(((Widget) this).context));
    }

    public final void ar(MusicPanel r9) {
        List r0 = r9.a.getMLyricUrlList();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        MusicPanel r3 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.R);
        if (r3 != null) goto L11;
    L13:
        if (r2 == true) goto L15;
        if (r1 == true) goto L15;
        return;
    L15:
        Jq(r9);
        return;
    L11:
        if (r3.c() != r9.c()) goto L13;
        r1 = true;
        goto L13
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.a
    public final void c8(long r2) {
        if (this.R.isCurrentUserIsSinger() == false) goto L8;
        LyricComponentListenerPresenter r3 = this.p;
        if (r3 == null) goto L30;
        r3.b();
        return;
    L30:
        return;
    L8:
        KtvListenerLyricPresenter r0 = this.v;
        if (r0 == null) goto L11;
        r0.f(r2);
    L11:
        LyricComponentListenerPresenter r1 = this.p;
        if (r1 == null) goto L14;
        r1.d.a(r2);
    L14:
        KtvRoomLyricHolder r4 = this.g1;
        if (r4 == null) goto L19;
        wd2.a r5 = r4.b.g;
        if (r5 == null) goto L19;
        r5.e = true;
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r6 = this.m;
        if (r6 == null) goto L22;
        KtvRoomLyricsStateMachineConfig.d r7 = r6.getCurState();
    L24:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L26;
    L28:
        this.T.getClass();
        return;
    L26:
        if (this.Q == false) goto L28;
        this.Q = false;
        this.T.getClass();
        return;
    L22:
        r7 = null;
        goto L24
    }

    public final void er(com.bytedance.android.live.liveinteract.plantform.base.i<LinkPlayerInfo> r13) {
        List r14 = r13.getOnlineUserList();
        int r0 = 0;
        if (r14 == null) goto L5;
        int r15 = r14.size();
    L6:
        com.bytedance.android.livesdk.chatroom.u r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        l3 r2 = null;
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.j r3 = r1.getVideoTalkRoomSubScene();
        if (r3 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
    L14:
        com.bytedance.android.livesdk.chatroom.u r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r6 == null) goto L21;
        com.bytedance.live.datacontext.j r7 = r6.s();
        if (r7 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r7.getValue();
        if (r8 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r9 = r8.t();
    L22:
        IRoom r10 = com.bytedance.android.live.liveinteract.linkpanel.util.o.b();
        if (r10 != null) goto L25;
    L28:
        if (r5 == null) goto L30;
        Integer r11 = Integer.valueOf(r5.a);
    L31:
        IRoom r12 = com.bytedance.android.live.liveinteract.linkpanel.util.o.b();
        if (r12 != null) goto L34;
    L37:
        if (r5 == null) goto L39;
        Integer r16 = Integer.valueOf(r5.c);
    L40:
        int r17 = 7;
        if (r11 != null) goto L44;
    L53:
        if (r16 != null) goto L56;
    L93:
        if (r11 != null) goto L96;
        return;
    L96:
        if (12 == r11.intValue()) goto L98;
        return;
    L98:
        if (r16 != null) goto L101;
    L102:
        if (r16 != null) goto L105;
    L106:
        IntRange r18 = new IntRange(z0.TYPE_APPLY, 112);
        if (r16 != null) goto L109;
    L111:
        boolean r19 = false;
    L112:
        if (r19 == false) goto L153;
    L113:
        if (r15 != 0) goto L116;
        com.bytedance.android.live.core.utils.i0.c().postDelayed(new m(this), 1000);
        return;
    L116:
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L119;
        r2 = (l3) r20.get("cmd_video_talkroom_state_change");
    L119:
        if (r16 != null) goto L122;
    L123:
        if (r16 != null) goto L126;
    L128:
        if (r16 != null) goto L131;
    L132:
        if (r16 != null) goto L135;
    L137:
        if (r15 < r17) goto L143;
        ViewGroup r110 = ((Widget) this).containerView;
        if (r110 == null) goto L154;
        if (r2 == null) goto L142;
        r0 = UtilityKotlinExtentionsKt.i(r2.d);
    L142:
        a1.n(r110, r0);
        return;
    L154:
        return;
    L143:
        ViewGroup r111 = ((Widget) this).containerView;
        if (r111 == null) goto L156;
        a1.n(r111, 0);
        return;
    L156:
        return;
    L135:
        if (r16.intValue() != 111) goto L137;
    L136:
        r17 = 9;
        goto L137
    L131:
        if (r16.intValue() == 109) goto L136;
    L126:
        if (r16.intValue() != 112) goto L128;
    L146:
        ViewGroup r112 = ((Widget) this).containerView;
        if (r112 == null) goto L158;
        if (r2 == null) goto L150;
        r0 = UtilityKotlinExtentionsKt.i(r2.d);
    L150:
        a1.n(r112, r0);
        return;
    L158:
        return;
    L122:
        if (r16.intValue() == 1) goto L146;
    L153:
        return;
    L109:
        if (r18.contains(r16.intValue()) == false) goto L111;
        r19 = true;
        goto L112
    L105:
        if (r16.intValue() == 1) goto L113;
    L101:
        if (r16.intValue() == 7) goto L113;
    L56:
        if (r16.intValue() != 29) goto L93;
    L57:
        if (r15 != 0) goto L60;
        com.bytedance.android.live.core.utils.i0.c().postDelayed(new l(this), 1000);
        return;
    L60:
        DataCenter r113 = ((Widget) this).dataCenter;
        if (r113 == null) goto L63;
        l3 r114 = (l3) r113.get("cmd_video_talkroom_state_change");
    L64:
        if (r16 != null) goto L67;
    L68:
        if (r16 != null) goto L71;
    L73:
        if (r16 == null) goto L93;
        if (1 != r16.intValue()) goto L93;
        ViewGroup r21 = ((Widget) this).containerView;
        if (r21 == null) goto L93;
        if (r114 == null) goto L81;
        int r115 = UtilityKotlinExtentionsKt.i(r114.d);
    L82:
        a1.n(r21, r115);
        goto L93
    L81:
        r115 = 0;
        goto L82
    L71:
        if (r16.intValue() != 29) goto L73;
    L83:
        if (r15 < 7) goto L90;
        ViewGroup r22 = ((Widget) this).containerView;
        if (r22 == null) goto L93;
        if (r114 == null) goto L88;
        int r116 = UtilityKotlinExtentionsKt.i(r114.d);
    L89:
        a1.n(r22, r116);
        goto L93
    L88:
        r116 = 0;
        goto L89
    L90:
        ViewGroup r23 = ((Widget) this).containerView;
        if (r23 == null) goto L93;
        a1.n(r23, 0);
        goto L93
    L67:
        if (7 == r16.intValue()) goto L83;
    L63:
        r114 = null;
        goto L64
    L44:
        if (8 != r11.intValue()) goto L53;
        if (r16 != null) goto L48;
    L49:
        if (r16 == null) goto L53;
        if (1 == r16.intValue()) goto L57;
    L48:
        if (7 == r16.intValue()) goto L57;
    L39:
        r16 = null;
        goto L40
    L34:
        if (r12.isLiveTypeAudio() != true) goto L37;
        if (r9 == null) goto L39;
        r16 = Integer.valueOf(r9.b);
    L30:
        r11 = null;
        goto L31
    L25:
        if (r10.isLiveTypeAudio() != true) goto L28;
        if (r9 == null) goto L30;
        r11 = Integer.valueOf(r9.a);
    L21:
        r9 = null;
    L13:
        r5 = null;
        goto L14
    L5:
        r15 = 0;
        goto L6
    }

    public final void fr(JSONObject r4) {
        r4.put("anchor_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(com.bytedance.android.live.ktv.common.util.a.c().getOwnerUserIdString()));
        hr("ktv_score_sei", r4);
    }

    public final void gr(boolean r4) {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.m;
        KtvRoomLyricsStateMachineConfig.d r1 = null;
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r2 = r0.getCurState();
    L7:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L10;
        r1 = r2;
    L10:
        KtvRoomLyricsStateMachineConfig.d.f r3 = (KtvRoomLyricsStateMachineConfig.d.f) r1;
        if (r3 == null) goto L17;
        MusicPanel r5 = r3.b;
        if (r5 == null) goto L17;
        KtvMusic r6 = r5.a;
        if (r6 == null) goto L17;
        long r7 = r6.getMId();
    L18:
        if (r4 == false) goto L20;
        int r8 = 1000;
    L21:
        fr(com.bytedance.android.livesdk.ktvimpl.base.sei.t.e(r8, r7));
        return;
    L20:
        r8 = 1001;
    L17:
        r7 = 0;
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    public final void jr(float r4) {
        if (r4 >= 0) goto L6;
        r4 = 0.0f;
    L8:
        int r0 = this.V;
        ((Widget) this).containerView.setY(r0 + (r4 * (this.W - r0)));
        return;
    L6:
        if (r4 <= 1) goto L8;
        r4 = 1.0f;
        goto L8
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (this.G == false) goto L87;
        Integer r0 = null;
        if (r6 == null) goto L8;
        String r1 = r6.getKey();
    L9:
        if (r1 == null) goto L88;
        int r2 = r1.hashCode();
        if (r2 == (-1381247050)) goto L48;
        if (r2 == 302906966) goto L27;
        if (r2 == 1723882771) goto L19;
        return;
    L19:
        if (r1.equals("data_ksong_unread_count") == false) goto L72;
        Integer r7 = (Integer) r6.getData();
        if (r7 != null) goto L23;
        return;
    L23:
        if (r7.intValue() == 0) goto L25;
        r3.c(this.T.e, s1.B(2131918625) + ' ' + r7 + ' ', true);
        return;
    L25:
        r3.c(this.T.e, s1.B(2131918625), true);
        return;
    L72:
        return;
    L27:
        if (r1.equals("data_multi_link_dynamic_layout_info_change") == false) goto L76;
        nh0.f r8 = (nh0.f) r6.getData();
        if (r8 == null) goto L90;
        sf0.b r9 = r8.e;
        if (r9 == null) goto L36;
        sf0.c r10 = r9.c;
        if (r10 == null) goto L36;
        int r11 = r10.c;
    L37:
        if (r11 <= 0) goto L77;
        this.V = r11;
        ViewGroup r12 = ((Widget) this).containerView;
        if (r12 == null) goto L41;
        float r13 = r12.getY();
    L42:
        float r3 = this.V;
        if (r13 <= r3) goto L78;
        ViewGroup r14 = ((Widget) this).containerView;
        if (r14 == null) goto L79;
        r14.setY(r3);
        return;
    L79:
        return;
    L78:
        return;
    L41:
        r13 = 0.0f;
        goto L42
    L77:
        return;
    L36:
        r11 = 0;
        goto L37
    L90:
        return;
    L76:
        return;
    L48:
        if (r1.equals("data_promotion_right_card_container_show") == true) goto L50;
        return;
    L50:
        if (((Boolean) r6.getData()) == null) goto L82;
        com.bytedance.android.livesdk.chatroom.o r15 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r15 == null) goto L56;
        com.bytedance.live.datacontext.i r16 = r15.getLiveMode();
        if (r16 == null) goto L56;
        LiveMode r17 = (LiveMode) r16.getValue();
    L57:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L61;
        r0 = Integer.valueOf(r4.getCurrentScene());
    L61:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L63;
        return;
    L63:
        if (r17 != LiveMode.VIDEO) goto L84;
        if (r0 != null) goto L67;
        return;
    L67:
        if (r0.intValue() != 0) goto L85;
        Handler r18 = com.bytedance.android.live.core.utils.i0.c();
        if (r18 == null) goto L86;
        r18.postDelayed(new d0(this), KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION);
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L56:
        r17 = null;
        goto L57
    L82:
        return;
    L88:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void onConfigurationChanged(Configuration r3) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        int r4 = Fq(getContext());
        this.W = r4;
        int r0 = this.V;
        float r1 = r0 + ((r4 - r0) / 2.0f);
        ViewGroup r5 = ((Widget) this).containerView;
        if (r5 == null) goto L6;
        r5.setY(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r8 = r7.b;
        if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L46;
        com.bytedance.android.livesdk.ktvimpl.base.sei.g r9 = (com.bytedance.android.livesdk.ktvimpl.base.sei.g) r8;
        if (r9 == null) goto L113;
        String r0 = "handleMidiSei cmd: " + r9.c();
        ALogger.e(bb0.b.b(), "KtvComponentUIWidget :" + r0 + ", invoke class :" + com.bytedance.android.livesdk.ktvimpl.base.sei.g.class.getSimpleName());
        if ((!Intrinsics.areEqual(r9.b(), com.bytedance.android.live.ktv.common.util.a.c().getOwnerUserIdString())) == true) goto L126;
        com.bytedance.android.live.ktv.common.util.c r1 = this.T.l;
        if (r1 == null) goto L15;
        if (r1.getVisibility() != 0) goto L15;
        return;
    L15:
        switch(r9.c()) {
            case 1001: goto L33;
            case 1002: goto L32;
            case 1003: goto L18;
            default: goto L128;
        };
    L32:
        pr(r9.d());
        return;
    L33:
        Rq();
        AbsKSongScoreFinishFragment r10 = this.H;
        if (r10 != null) goto L36;
        return;
    L36:
        if (r10.isShowing() != true) goto L117;
        AbsKSongScoreFinishFragment r11 = this.H;
        if (r11 == null) goto L118;
        r11.dismissAllowingStateLoss();     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L119;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L128:
        return;
    L18:
        if (isViewValid() == true) goto L20;
    L31:
        Rq();
        return;
    L20:
        if (MidiContext.Companion.d() == true) goto L31;
        boolean r2 = ((Widget) this).context instanceof FragmentActivity;
        AbsKSongScoreFinishFragment r3 = this.H;
        if (r3 != null) goto L24;
    L26:
        int r4 = KSongAudienceScoreFinishFragment.h;
        float r13 = r9.d();
        KSongAudienceScoreFinishFragment r5 = new KSongAudienceScoreFinishFragment();
        r5.g = r13;
        this.H = r5;
        FragmentActivity r14 = ((Widget) this).context;
        if (r14 == null) goto L30;
        wq(r5, r14.getSupportFragmentManager(), "KtvAudienceScoreFinishFragment");
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L24:
        if (r3.isShowing() != true) goto L26;
    L126:
        return;
    L113:
        return;
    L46:
        if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L121;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r15 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r8;
        if (MidiContext.Companion.d() == false) goto L99;
        Boolean r6 = null;
        if (r15 == null) goto L52;
        Integer r16 = r15.q();
    L53:
        if (r16 == null) goto L99;
        if (r16.intValue() != 1) goto L99;
        if (r15 == null) goto L59;
        Integer r17 = r15.s();
    L60:
        if (r17 != null) goto L63;
    L65:
        boolean r18 = false;
    L66:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r19 = this.m;
        if (r19 == null) goto L69;
        KtvRoomLyricsStateMachineConfig.d r20 = r19.getCurState();
    L71:
        if ((r20 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L80;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r21 = this.m;
        if (r21 == null) goto L75;
        KtvRoomLyricsStateMachineConfig.d r22 = r21.getCurState();
    L77:
        if ((r22 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L80;
        if (r18 == false) goto L80;
        return;
    L75:
        r22 = null;
    L80:
        MultiChorusContext.a r23 = MultiChorusContext.Companion;
        if (r23.c() == true) goto L83;
    L85:
        KtvComponentUIContext r24 = this.s;
        if (r24 == null) goto L91;
        MutableLiveData<Boolean> r25 = r24.getSingerScoreOpen();
        if (r25 == null) goto L91;
        r6 = (Boolean) r25.getValue();
    L91:
        if ((!Intrinsics.areEqual(r6, Boolean.valueOf(r18))) == false) goto L99;
        if (ne2.a.a() == true) goto L99;
        KtvComponentUIContext r26 = this.s;
        if (r26 == null) goto L99;
        MutableLiveData<Boolean> r27 = r26.getSingerScoreOpen();
        if (r27 == null) goto L99;
        r27.setValue(Boolean.valueOf(r18));
        goto L99
    L83:
        if (r23.a() != 2) goto L85;
        return;
    L69:
        r20 = null;
        goto L71
    L63:
        if (r17.intValue() != 1) goto L65;
        r18 = true;
        goto L66
    L59:
        r17 = null;
        goto L60
    L52:
        r16 = null;
    L99:
        if (r15 != null) goto L101;
        return;
    L101:
        if (r15.d() == 1) goto L104;
        return;
    L104:
        if (this.h1 == true) goto L123;
        double r28 = r15.c();
        if (r28 >= 0.0d) goto L108;
        return;
    L108:
        if (r28 > 1.0d) goto L125;
        jr(r15.c());
        this.h1 = true;
        return;
    L125:
        return;
    L123:
        return;
    }

    public final void pr(float r6) {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.m;
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
    L7:
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.c) == true) goto L9;
        return;
    L9:
        ALogger.e(bb0.b.b(), "KtvComponentUIWidget :showScore, invoke class :KtvComponentUIWidget");
        TextView r2 = this.T.i;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        if (r6 != 100.0f) goto L17;
        TextView r3 = this.T.i;
        if (r3 == null) goto L20;
        r3.setText(BDLocationException.ERROR_BEACON_ADVERTISING);
    L20:
        ImageView r4 = this.T.h;
        if (r4 == null) goto L23;
        r4.setVisibility(8);
    L23:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r5 = this.t;
        if (r5 == null) goto L27;
        r5.e((int) r6);
        return;
    L27:
        return;
    L17:
        TextView r7 = this.T.i;
        if (r7 == null) goto L20;
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        r7.setText(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r6)}, 1)));
        goto L20
    L5:
        r1 = null;
        goto L7
    }

    public final void ur(MusicPanel r6) {
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a.getClass();
        ub0.d r0 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.b(r6);
        ALogger.w("KtvComponentUIWidget", "sendSingerBeginSing, LyricsReaderHelper.parse");
        pd2.d.n.N(r6);
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.d r1 = this.u;
        if (r1 != null) goto L5;
    L9:
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L13;
        r2.postDelayed(new q(r0, this, r6), 100);
        return;
    L13:
        return;
    L5:
        if ((!r1.a.getCurrentLyrics().isEmpty()) == false) goto L9;
        KtvComponentCountDownView r3 = r1.e;
        if (r3 == null) goto L9;
        r3.setVisibility(0);
        goto L9
    }

    public static final void Aq(KtvComponentUIWidget r3, MusicPanel r4) {
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r0 = r3.t;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        r3.Pq(r4);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r5 = KSongTuningPanelHelperKt.d();
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r1 = null;
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L8;
        r5 = null;
    L8:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r6 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r5;
        if (r6 == null) goto L11;
        long r7 = r6.z();
    L12:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r2 = KSongTuningPanelHelperKt.d();
        if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == false) goto L16;
        r1 = r2;
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r8 = r1;
        if (r8 == null) goto L20;
        String r9 = r8.T();
        if (r9 == null) goto L20;
    L21:
        KtvContext.Companion.getClass();
        KtvContext r10 = KtvContext.a.g();
        if (r10 == null) goto L29;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r11 = r10.getKtvCoreController();
        if (r11 != null) goto L26;
        return;
    L26:
        if (((com.bytedance.android.livesdk.ktvimpl.base.i) r11.getValue()) == null) goto L31;
        Long r12 = KtvLoggerHelper.a;
        KtvLoggerHelper.i0(System.currentTimeMillis() - r7, r9, "ksong");
        return;
    L31:
        return;
    L29:
        return;
    L20:
        r9 = "";
        goto L21
    L11:
        r7 = 0;
        goto L12
    }

    public static final void Bq(KtvComponentUIWidget r8, MusicPanel r9) {
        r8.getClass();
        ALogger.w("KtvComponentUIWidget", "sendSingerBeginSing, music=" + r9.a.getMTitle());
        KtvRoomLyricHolder r0 = r8.g1;
        if (r0 == null) goto L6;
        r0.e = KtvUtilsKt.x(r9.a);
    L6:
        if (Iq() == true) goto L8;
        return;
    L8:
        if (((Boolean) KtvSettingHelper.U0.getValue()).booleanValue() == true) goto L10;
        r8.ur(r9);
        return;
    L10:
        if (KtvUtilsKt.m(r9) == false) goto L12;
        r8.ur(r9);
        return;
    L12:
        KtvMusicManager.e(KtvMusicManager.m, r9, new f0(r8, r9), false, null, false, 28);
    }

    public static final void Cq(KtvComponentUIWidget r1, boolean r2) {
        if (r1.e == true) goto L6;
        r1.e = true;
        r1.U.b(r2);
        return;
    }

    public static void xq(KSongOrderSongDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "KSongOrderSongDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.showNow(r3, "KSongOrderSongDialog");
    }

    public static final void yq(KtvComponentUIWidget r2, Pair r3) {
        com.bytedance.android.live.ktv.common.util.c r0 = r2.T.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L23;
        com.bytedance.android.live.ktv.common.midi.k r1 = null;
        if (r3 == null) goto L9;
        Long r4 = (Long) r3.getFirst();
    L10:
        if (r3 == null) goto L12;
        r1 = (com.bytedance.android.live.ktv.common.midi.k) r3.getSecond();
    L12:
        if (r1 == null) goto L24;
        KtvComponentMidiView r5 = r2.T.l;
        if (r5 == null) goto L17;
        r5.F9(r1, r4, ne2.a.a());
    L17:
        if (ne2.a.a() == false) goto L25;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r6 = KtvChallengeDataContext.Companion.a();
        if (r6 == null) goto L26;
        r6.onMidiScoreChanged(r1);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public static final void zq(KtvComponentUIWidget r3, boolean r4) {
        if (r3.br() == false) goto L5;
        ALogger.i("KtvComponentUIWidget", "handleScoreOpenForNewStyle dismiss lyrics and midi");
        return;
    L5:
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentUIWidget", "handleScoreOpenForNewStyle " + r4);
        if (r4 == false) goto L13;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r5 = r3.T;
        if (r5 == null) goto L12;
        com.bytedance.android.live.ktv.common.util.c r6 = r5.l;
        if (r6 == null) goto L12;
        r6.setVisibility(0);
    L12:
        r3.Nq();
        return;
    L13:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r7 = r3.T;
        if (r7 == null) goto L21;
        com.bytedance.android.live.ktv.common.util.c r8 = r7.l;
        if (r8 == null) goto L22;
        r8.setVisibility(8);
        return;
    L22:
        return;
    }

    public final void hr(String r4, JSONObject r5) {
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r1 = null;
        if (com.bytedance.android.live.core.utils.a0.d(((Widget) this).dataCenter, false) == false) goto L10;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r2 = r0.getLiveStream();
        if (r2 == null) goto L9;
        com.bytedance.android.live.pushstream.d r3 = (com.bytedance.android.live.pushstream.d) r2.getValue();
    L15:
        if (r3 == null) goto L17;
        r1 = new com.bytedance.android.livesdk.ktvimpl.base.sei.f(r3, null);
    L17:
        if (r1 == null) goto L20;
        r1.a(r4, r5);
        return;
    L20:
        return;
    L9:
        r3 = null;
        goto L15
    L10:
        this.y.getClass();
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 == null) goto L9;
        rj0.d r7 = r6.getCommonService();
        if (r7 == null) goto L9;
        r3 = r7.getLiveStream();
        goto L15
    }

    public final void lr(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        KtvComponentMusicReportInfoManager r1 = this.U;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "text");
        Disposable r0 = r1.c;
        if (r0 != null) goto L5;
    L7:
        r1.f(new je2.f.c(r4));
        r1.c = Observable.timer(r5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new je2.b(r1));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void or(final MusicPanel r8, final Function0<Unit> r9) {
        Long r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.e();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L32;
        ChorusContext.a r4 = ChorusContext.Companion;
        if (r4.c() == false) goto L30;
        ChorusContext r5 = r4.getContext();
        if (r5 == null) goto L21;
        List<MusicPanel> r6 = r5.getChorusNotSelfSeeingMusicList();
        if (r6 == null) goto L21;
        MusicPanel r7 = (MusicPanel) CollectionsKt.firstOrNull(r6);
    L22:
        if (r7 == null) goto L24;
        Long r10 = Long.valueOf(r7.c());
    L25:
        if (r8 == null) goto L28;
        r0 = Long.valueOf(r8.c());
    L28:
        if (Intrinsics.areEqual(r10, r0) == false) goto L32;
        r8 = r7;
        goto L32
    L24:
        r10 = null;
    L21:
        r7 = null;
        goto L22
    L30:
        r8 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.R);
    L32:
        if (this.g == true) goto L42;
        if (r8 == null) goto L43;
        String r11 = r8.e();
        if (r11 != null) goto L37;
        return;
    L37:
        if (r11.length() <= 0) goto L39;
        r2 = true;
    L39:
        if (r2 != true) goto L45;
        this.g = true;
        Qq();
        this.U.d(r8.a, 5000, new KtvComponentUIWidget$showPrepareSongInfoIfNeedForAudience$1(this, r9, r8));
        return;
    L45:
        return;
    L43:
        return;
    L42:
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvComponentUIWidget(String r4, Function0<Unit> r5, Function1<? super Long, Unit> r6) {
        this.v1 = r5;
        this.x1 = r6;
        this.q = LazyKt.lazy(KtvComponentUIWidget$ktvMemoryLeakOpt$2.INSTANCE);
        ReadOnlyProperty r7 = vm2.h.Q0;
        KProperty[] r0 = vm2.h.a;
        boolean r8 = ((Boolean) r7.getValue(null, r0[93])).booleanValue();
        this.r = r8;
        this.w = new CompositeDisposable();
        this.y = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a(r4, this);
        this.D = ((Number) vm2.h.R0.getValue(null, r0[94])).intValue();
        this.E = vm2.h.F();
        this.F = vm2.h.I();
        this.G = ((Boolean) vm2.h.j0.getValue(null, r0[60])).booleanValue();
        this.I = -1;
        this.K = vm2.d.Z();
        this.M = !r8;
        this.O = new f(this);
        this.P = new g();
        KtvContext.Companion.getClass();
        KtvContext r9 = KtvContext.a.g();
        this.R = r9;
        this.T = new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b();
        this.U = new KtvComponentMusicReportInfoManager();
        this.V = s1.j(2131168828);
        le2.a r10 = new le2.a(r9);
        this.X = r10;
        this.Y = LazyKt.lazy(new KtvComponentUIWidget$linkPlayerStateObserver$2(this));
        this.Z = new r(this);
        this.k0 = new d(this);
        this.W = Fq(getContext());
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L5;
        this.t = new AnchorKtvComponentStrategy();
    L6:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r1 = this.t;
        if (r1 == null) goto L9;
        r1.b(r6);
    L9:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r11 = this.t;
        if (r11 == null) goto L12;
        this.z = new KtvComponentRoomStrategy(r11);
    L12:
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r12 = r9.getSeiProcessor();
        if (r12 == null) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r13 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) r12.getValue();
        if (r13 == null) goto L17;
        r13.c(r10, 5.0f);
    L17:
        this.p0 = new n(this);
        this.H0 = new e(this);
        this.L0 = new LiveNetworkBroadcastReceiver();
        this.P0 = h.a;
        this.V0 = new KtvComponentUIWidget$mKtvCoreListener$1(this);
        this.p1 = InfraKotlinExtsKt.mainThreadLazy(new KtvComponentUIWidget$scoreHitAnimationSet$2(this));
        return;
    L5:
        this.t = new AudienceKtvComponentStrategy();
        goto L6
    }

    public static void wq(AbsKSongScoreFinishFragment r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    public final void nr(String r17, Integer r18, String r19) {
        Intrinsics.checkNotNullParameter(r17, "enterFrom");
        if (((Widget) this).context != null) goto L5;
        return;
    L5:
        this.y.a = r17;
        if (KtvSettingHelper.n().booleanValue() == true) goto L8;
        f2.b(2131918463, 0);
        return;
    L8:
        Tq();
        com.bytedance.android.livesdk.ktvimpl.base.util.q.e();
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = KtvComponentOrderSongDataContext.Companion.a();
        if (r2 == null) goto L12;
        r2.updateOrderSongExtraInfo(new td2.b(r17, new WeakReference(((Widget) this).context)));
    L12:
        if (Intrinsics.areEqual(r17, "sing_song") == false) goto L14;
        String r1 = "component_btn_click";
    L15:
        FragmentActivity r3 = ((Widget) this).context;
        if (r3 == null) goto L38;
        FragmentManager r4 = r3.getSupportFragmentManager();
        Fragment r5 = r4.findFragmentByTag("KSongOrderSongDialog");
        if ((r5 instanceof KSongOrderSongDialog) == true) goto L20;
        r5 = null;
    L20:
        KSongOrderSongDialog r6 = (KSongOrderSongDialog) r5;
        if (r6 != null) goto L23;
    L31:
        KSongOrderSongUtilKt.b(((Widget) this).context, CloseOrderSongDialogSource.AUTO);
        int r7 = KSongOrderSongDialog.p;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r8 = KtvComponentOrderSongDataContext.Companion.a();
        int r9 = KtvComponentFirstLevelTabManager.q;
        KtvComponentFirstLevelTabManager r10 = new KtvComponentFirstLevelTabManager(r18, r19, ((Widget) this).context, KtvComponentOrderSongDataContext.Companion.b(), KtvComponentOrderSongDataContext.Companion.c(), KtvComponentOrderSongDataContext.Companion.a(), KtvComponentOrderSongDataContext.Companion.e());
        r10.s();
        KSongOrderSongDialog r11 = KSongOrderSongDialog.a.a(r8, r10, null, 12);
        r11.setOnDismissListener(new e0(r11, this));
        FragmentActivity r12 = ((Widget) this).context;
        if (r12 == null) goto L36;
        xq(r11, r12.getSupportFragmentManager());
        pd2.d.n.getClass();
        pd2.d.G(r1, true);
        Unit r13 = Unit.INSTANCE;
        this.l = r11;
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L23:
        if (this.l == null) goto L31;
        if (r6.isAdded() == true) goto L27;
        xq(r6, r4);
        pd2.d.n.getClass();
        pd2.d.G(r1, true);
        return;
    L27:
        r6.m.c(r18, r19);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e.a.a(r6.m);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r14 = KtvComponentOrderSongDataContext.Companion.a();
        if (r14 == null) goto L30;
        r14.updateCurrentTabData();
    L30:
        KSongOrderSongDialog.aa0(r6, false, r1, 1);
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L14:
        r1 = "other";
        goto L15
    }
}
