package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.viewmodel.CommonOrderSongViewModel;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.search.viewmodel.CommonSearchViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import com.bytedance.android.live.liveinteract.plantform.utils.q;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongHandler;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.manager.KtvModeFirstLevelTabManager;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.viewmodel.KtvModeOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.KtvDressViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oe2.l;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/card/KtvRoomCardWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomCardWidget extends HolderRoomWidget {
    public static final TokenCert s = null;
    public Pair<? extends DataContext, ? extends Disposable> d;
    public Pair<? extends DataContext, ? extends Disposable> e;
    public KSongOrderSongDialog f;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c g;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d h;
    public final l i;
    public final Lazy j;
    public final LiveNetworkBroadcastReceiver k;
    public final c l;
    public final com.bytedance.android.livesdk.a m;
    public final com.bytedance.android.livesdk.a n;
    public final CompositeDisposable o;
    public final b p;
    public final sb0.b q;
    public final j1 r;

    public static final class a {
    }

    public static final class b {
        public final /* synthetic */ KtvRoomCardWidget a;

        public b(KtvRoomCardWidget r1) {
            this.a = r1;
        }
    }

    public static final class c implements LiveNetworkBroadcastReceiver.a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void a(NetworkUtils.NetworkType r4) {
            KtvContext.Companion.getClass();
            KtvContext r0 = KtvContext.a.g();
            if (r4 != NetworkUtils.NetworkType.WIFI) goto L14;
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = KtvModeOrderSongDataContext.Companion.b();
            if (r5 == null) goto L7;
            y r6 = r5.getSecondLevelTabDataByParams(FirstLevelTab.OrderSongTab.getValue(), "room_hot");
        L8:
            if (r6 != null) goto L10;
        L17:
            r0.getKtvRoomLabelChangeEvent().post(new Object());
            return;
        L10:
            if ((!r6.h.isEmpty()) == false) goto L17;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = KtvModeOrderSongDataContext.Companion.a();
            if (r1 == null) goto L17;
            r1.beginWifiDownload(r6);
            goto L17
        L7:
            r6 = null;
            goto L8
        L14:
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r7 = KtvModeOrderSongDataContext.Companion.a();
            if (r7 == null) goto L17;
            r7.stopWifiDownload();
            goto L17
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvRoomCardWidget a;

        public d(KtvRoomCardWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            od2.b r6 = (od2.b) r5;
            u r0 = m.e(this.a);
            if (r0 == null) goto L5;
            r0.B();
        L5:
            this.a.Aq(r6.a, r6.b, r6.c, null);
        }
    }

    static {
        s = TokenCert.Companion.with("bpea-ktvroomcardwidget_get_network_type");
    }

    public final void onDestroy() {
        KSongOrderSongUtilKt.b(((Widget) this).context, CloseOrderSongDialogSource.BUSINESS_WIDGET_DESTROY);
        this.f = null;
        hd0.c.f().e((Observer) this.j.getValue());
        Lazy r1 = KtvCommonSettingHelper.a;
        KtvContext.Companion.getClass();
        KtvContext r2 = KtvContext.a.g();
        if (r2 == null) goto L12;
        n<d0> r3 = r2.getStreamInfoSender();
        if (r3 == null) goto L12;
        d0 r4 = (d0) r3.getValue();
        if (r4 == null) goto L12;
        Iterator r5 = r4.a.values().iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((q) r5.next()).onClose();
    L12:
        Pair<? extends DataContext, ? extends Disposable> r6 = this.d;
        if (r6 == null) goto L19;
        Disposable r7 = (Disposable) r6.getSecond();
        if (r7 == null) goto L19;
        if (r7.isDisposed() == true) goto L19;
        r7.dispose();
        this.d = null;
    L19:
        Pair<? extends DataContext, ? extends Disposable> r8 = this.e;
        if (r8 == null) goto L26;
        Disposable r9 = (Disposable) r8.getSecond();
        if (r9 == null) goto L26;
        if (r9.isDisposed() == true) goto L26;
        r9.dispose();
        this.e = null;
    L26:
        this.o.clear();
        com.bytedance.android.livesdk.a.h.getClass();
        com.bytedance.android.livesdk.a.g = 0;
        k.n(IInteractService.class).resetBusinessDegradeStrategy(9, null);
        com.bytedance.android.live.ktv.common.music.download.m r0 = KtvMusicManager.a;
        KtvMusicManager.d();
        Lazy r10 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().e();
        Lazy r11 = KtvCommonSettingHelper.a;
        KtvContext.Companion.getClass();
        KtvContext r12 = KtvContext.a.g();
        if (r12 == null) goto L31;
        n<Integer> r13 = r12.getKtvCardViewSizeChanged();
        if (r13 == null) goto L31;
        r13.setValue(0);
    L31:
        ViewGroup r14 = ((Widget) this).containerView;
        if (r14 == null) goto L34;
        r14.setVisibility(8);
    L34:
        this.k.c(this.l);
        this.k.d();
        if (a0.d(((Widget) this).dataCenter, false) == true) goto L37;
    L40:
        super.onDestroy();
        return;
    L37:
        if (a0.n(((Widget) this).dataCenter).isLiveTypeAudio() != true) goto L39;
        ALogger.i("ttlive_link", "intercept show pk toolbar when unload ktv");
        goto L40
    L39:
        y3.m(((Widget) this).dataCenter).c(ToolbarButton.PK.extended());
        goto L40
    }

    public final void xq() {
        KtvModeOrderSongDataContext.Companion.getClass();
        if (KtvModeOrderSongDataContext.Companion.d() != null) goto L34;
        Pair<? extends DataContext, ? extends Disposable> r0 = com.bytedance.live.datacontext.d.a(KtvRoomCardWidget$initKSongOrderSongDataContextIfNeed$1.INSTANCE);
        this.e = r0;
        DataContext r1 = null;
        if (r0 == null) goto L7;
        DataContext r2 = (DataContext) r0.getFirst();
    L9:
        if ((r2 instanceof KtvModeOrderSongDataContext) == false) goto L12;
        r1 = r2;
    L12:
        KtvModeOrderSongDataContext r3 = (KtvModeOrderSongDataContext) r1;
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.b.a(r3, KtvRoomCardWidget$initKSongOrderSongDataContextIfNeed$2.INSTANCE);
    L15:
        KSongOrderSongHandler r4 = new KSongOrderSongHandler();
        if (r3 == null) goto L20;
        j<com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b> r5 = r3.m103getCommonOrderSongViewModel();
        if (r5 == null) goto L20;
        CommonOrderSongViewModel.Companion.getClass();
        r5.d(CommonOrderSongViewModel.a.a(this, r4));
    L20:
        if (r3 == null) goto L24;
        j<com.bytedance.android.live.ktv.common.search.viewmodel.a> r6 = r3.m104getCommonSearchViewModel();
        if (r6 == null) goto L24;
        CommonSearchViewModel.Companion.getClass();
        r6.d(CommonSearchViewModel.a.a(this, r4));
    L24:
        if (r3 == null) goto L28;
        j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r7 = r3.m102getBusinessOrderSongViewModel();
        if (r7 == null) goto L28;
        KtvModeOrderSongViewModel.a r8 = KtvModeOrderSongViewModel.Companion;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r9 = KtvModeOrderSongDataContext.Companion.b();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r10 = KtvModeOrderSongDataContext.Companion.c();
        KtvModeOrderedSongDataContext r11 = KtvModeOrderedSongDataContext.Companion.getContext();
        r8.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r12 = KtvModeOrderSongViewModel.a.a(this, r9, r10, r11);
        r12.initData();
        Unit r13 = Unit.INSTANCE;
        r7.d(r12);
    L28:
        r4.a = KtvModeOrderSongDataContext.Companion.a();
        r4.b = KtvModeOrderSongDataContext.Companion.b();
        if (r3 == null) goto L35;
        j<com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a> r14 = r3.m105getKtvDressViewModel();
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

    public final void zq() {
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

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        com.bytedance.android.live.ktv.common.music.download.m r0 = KtvMusicManager.a;
        KtvMusicManager.j();
        zq();
        xq();
        if (a0.d(((Widget) this).dataCenter, false) == false) goto L15;
        o r1 = o3.h(this, ((Widget) this).dataCenter);
        if (r1 == null) goto L9;
        j r2 = r1.getLiveStream();
        if (r2 == null) goto L9;
        com.bytedance.android.live.pushstream.d r3 = (com.bytedance.android.live.pushstream.d) r2.getValue();
    L10:
        this.i.d = r3;
        KtvContext.Companion.getClass();
        KtvContext r4 = KtvContext.a.g();
        if (r4 == null) goto L15;
        n<d0> r5 = r4.getStreamInfoSender();
        if (r5 == null) goto L15;
        r5.setValue(((Widget) this).dataCenter.get("live_stream_info_sender_manager", null));
    L9:
        r3 = null;
    L15:
        yq(this.i.h(com.bytedance.android.live.ktv.common.util.j.i()));
        hd0.c.f().c((Observer) this.j.getValue());
        if (((Boolean) h.h3.getValue(null, h.a[214(0xd6, float:3.0E-43)])).booleanValue() == false) goto L28;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L28;
        Lazy r6 = KtvSettingHelper.a;
        j1 r7 = this.r;
        if (r7 == null) goto L22;
        cg6.a r8 = (cg6.a) r7.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L23:
        if (r8 == null) goto L28;
        vb6.g r9 = r8.O5();
        if (r9 == null) goto L28;
        r9.X0(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card.b(this), false);
        goto L28
    L22:
        r8 = null;
    L28:
        if (o3.g(this) == null) goto L42;
        Lazy r10 = KtvCommonSettingHelper.a;
        KtvContext.Companion.getClass();
        KtvContext r11 = KtvContext.a.g();
        if (r11 == null) goto L34;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r12 = r11.getKtvCoreViewModel();
        if (r12 == null) goto L34;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r13 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r12.getValue();
    L35:
        this.g = r13;
        KtvContext r14 = KtvContext.a.g();
        if (r14 == null) goto L40;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r15 = r14.getKtvSingerViewModel();
        if (r15 == null) goto L40;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r16 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r15.getValue();
    L41:
        this.h = r16;
        k.n(IKtvService.class).setKtvCoreViewModel(this.g);
    L40:
        r16 = null;
    L34:
        r13 = null;
    L42:
        KtvContext.Companion.getClass();
        Disposable r17 = KtvContext.a.g().getOpenKtvRoomDialogEvent().onEvent().subscribe(new d(this));
        if (r17 == null) goto L45;
        RxUtilKt.c(r17, this.o);
    L45:
        Lazy r18 = KtvCommonSettingHelper.a;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r19 = KtvRoomContext.a.a();
        if (r19 == null) goto L51;
        j<KtvGroupViewModel> r20 = r19.getKtvGroupViewModel();
        if (r20 == null) goto L51;
        r20.e(new KtvRoomCardWidget$initData$1(this));
    L51:
        if (a0.d(((Widget) this).dataCenter, false) == false) goto L53;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.PK.extended());
    L53:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r21 = this.g;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r22 = this.h;
        KtvContext r23 = KtvContext.a.g();
        if (r21 == null) goto L63;
        if (r22 == null) goto L63;
        if (r23 == null) goto L63;
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r24 = KtvModeOrderSongDataContext.Companion.a();
        if (r24 == null) goto L60;
        r24.getOrderedSongList(true);
    L60:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r25 = KtvModeOrderSongDataContext.Companion.b();
        if (r25 == null) goto L63;
        r25.observeSongListDataChange(this, new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card.a(this));
    L63:
        LiveNetworkBroadcastReceiver r26 = this.k;
        Context r27 = ((Widget) this).context;
        TokenCert r28 = s;
        r26.b(r27, r28);
        this.k.a(this.l, r28);
        KtvContext r29 = KtvContext.a.g();
        if (r29 == null) goto L68;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.ktvimpl.base.util.e> r30 = r29.getKtvRoomStrategy();
        if (r30 == null) goto L68;
        r30.setValue(new com.bytedance.android.livesdk.ktvimpl.base.util.b());
    L68:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r31 = this.h;
        if (r31 == null) goto L72;
        r31.onPageCreate();
    L72:
        if (a0.d(((Widget) this).dataCenter, false) == false) goto L74;
        y3.m(((Widget) this).dataCenter).i(ToolbarButton.PK.extended());
    L74:
        u r32 = m.e(this);
        if (r32 == null) goto L83;
        n r33 = r32.C();
        if (r33 == null) goto L83;
        Observable r34 = r33.a();
        if (r34 == null) goto L83;
        ObservableSubscribeProxy r35 = (ObservableSubscribeProxy) r34.as(autoDispose());
        if (r35 == null) goto L83;
        r35.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card.c(this));
    L83:
        u r36 = m.e(this);
        if (r36 == null) goto L97;
        n r37 = r36.C();
        if (r37 == null) goto L97;
        Pair r38 = (Pair) r37.getValue();
        if (r38 == null) goto L97;
        if (TextUtils.isEmpty((CharSequence) r38.getSecond()) == true) goto L97;
        u r39 = m.e(this);
        if (r39 == null) goto L95;
        String r40 = r39.w();
        if (r40 == null) goto L95;
    L96:
        Aq(r40, false, (String) r38.getSecond(), (Integer) r38.getFirst());
    L95:
        r40 = "ktv_convenient";
    L97:
        u r41 = m.e(this);
        if (r41 == null) goto L107;
        com.bytedance.live.datacontext.m r42 = r41.K();
        if (r42 == null) goto L107;
        String r43 = (String) r42.getValue();
        if (r43 == null) goto L107;
        if (TextUtils.isEmpty(r43) == true) goto L107;
        Aq("ktv_convenient", false, null, null);
    L107:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L110;
        k.n(IInteractService.class).addBusinessDegradeStrategy(this.m);
        k.n(IInteractService.class).addBusinessDegradeStrategy(this.n);
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r0 = this.h;
        if (r0 == null) goto L5;
        r0.onPageResume();
    L5:
        zq();
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r0 = this.h;
        if (r0 == null) goto L6;
        r0.onPageStop();
        return;
    }

    public final void yq(com.bytedance.android.live.pushstream.d r3) {
        Pair<? extends DataContext, ? extends Disposable> r0 = this.d;
        if (r0 == null) goto L9;
        Disposable r1 = (Disposable) r0.getSecond();
        if (r1 == null) goto L9;
        if (r1.isDisposed() == true) goto L9;
        r1.dispose();
        this.d = null;
    L9:
        this.d = KSongTuningPanelHelperKt.b(true, r3, new WeakReference(((Widget) this).context));
    }

    public KtvRoomCardWidget(sb0.b r3, j1 r4) {
        Intrinsics.checkNotNullParameter(r3, "dataEntityProxy");
        this.q = r3;
        this.r = r4;
        ALogger.d("KtvRoomCardWidget", "init KtvRoomCardWidget");
        this.i = new l(r4);
        this.j = LazyKt.lazy(new KtvRoomCardWidget$linkPlayerStateObserver$2(this));
        this.k = new LiveNetworkBroadcastReceiver();
        this.l = c.a;
        com.bytedance.android.livesdk.a.h.getClass();
        com.bytedance.android.livesdk.a r5 = com.bytedance.android.livesdk.a.a.b("ktv_linkmic_warning");
        com.bytedance.android.livesdk.a r0 = null;
        if (r5 == null) goto L5;
        KtvRoomCardWidget$linkMicWaringStrategy$1$1 r1 = KtvRoomCardWidget$linkMicWaringStrategy$1$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r1, "cb");
        r5.a = r1;
        Unit r2 = Unit.INSTANCE;
    L6:
        this.m = r5;
        com.bytedance.android.livesdk.a r6 = com.bytedance.android.livesdk.a.a.b("ktv_singing_alert");
        if (r6 == null) goto L9;
        Function2<Integer, Boolean, Unit> r7 = new KtvRoomCardWidget$$special$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r7, "cb");
        r6.a = r7;
        Unit r8 = Unit.INSTANCE;
        r0 = r6;
    L9:
        this.n = r0;
        this.o = new CompositeDisposable();
        this.p = new b(this);
        return;
    L5:
        r5 = null;
        goto L6
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

    public final void Aq(String r16, boolean r17, String r18, Integer r19) {
        if (KtvSettingHelper.n().booleanValue() == true) goto L6;
        f2.b(2131918463, 0);
        return;
    L6:
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L11;
        n<oe2.b> r4 = r3.getKtvRoomProvider();
        if (r4 == null) goto L11;
        oe2.b r5 = (oe2.b) r4.getValue();
    L13:
        if ((r5 instanceof l) == true) goto L15;
        r5 = null;
    L15:
        l r6 = (l) r5;
        if (r6 == null) goto L18;
        r6.a = r16;
    L18:
        String r7 = bb0.b.b();
        ALogger.i(r7, ("showKtvRoomOrAdjustDialog, isAdjust:" + r17) + ", invoke class :KtvRoomCardWidget");
        if (k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L23;
        k.n(IMiddlewareUserService.class).user().login(((Widget) this).context, new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L23:
        if (Intrinsics.areEqual(r16, "control") == false) goto L25;
        String r8 = "room_btn_click";
    L26:
        if (r17 == false) goto L34;
        if (KtvContext.a.g().getKtvCoreController().getValue() != null) goto L32;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r1 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) KtvContext.a.g().getKtvSingerViewModel().getValue();
        if (r1 == null) goto L32;
        r1.lazyInitKtvCoreController();
    L32:
        KSongTuningPanelHelperKt.a(((Widget) this).context, "mv");
        pb0.a.a.b(KtvLoggerHelper.d, "tone_tuning", null, "tone_tuning", null, null, 26);
        return;
    L34:
        if (((Widget) this).isDestroyed == true) goto L59;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = this.g;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r9 = this.h;
        FragmentActivity r10 = ((Widget) this).context;
        if (r2 == null) goto L60;
        if (r9 == null) goto L61;
        if (r10 == null) goto L62;
        xq();
        com.bytedance.android.livesdk.ktvimpl.base.util.q.e();
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r11 = KtvModeOrderSongDataContext.Companion.a();
        if (r11 == null) goto L42;
        r11.updateOrderSongExtraInfo(new td2.b(r16, new WeakReference(r10)));
    L42:
        FragmentManager r12 = r10.getSupportFragmentManager();
        Fragment r13 = r12.findFragmentByTag("KSongOrderSongDialog");
        if ((r13 instanceof KSongOrderSongDialog) == true) goto L45;
        r13 = null;
    L45:
        KSongOrderSongDialog r14 = (KSongOrderSongDialog) r13;
        if (r14 != null) goto L48;
    L56:
        KSongOrderSongUtilKt.b(r10, CloseOrderSongDialogSource.AUTO);
        int r15 = KSongOrderSongDialog.p;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r20 = KtvModeOrderSongDataContext.Companion.a();
        int r21 = KtvModeFirstLevelTabManager.q;
        KtvModeFirstLevelTabManager r22 = new KtvModeFirstLevelTabManager(r19, r18, ((Widget) this).context, KtvModeOrderSongDataContext.Companion.b(), KtvModeOrderSongDataContext.Companion.c(), KtvModeOrderSongDataContext.Companion.a(), KtvModeOrderSongDataContext.Companion.e());
        r22.s();
        KSongOrderSongDialog r23 = KSongOrderSongDialog.a.a(r20, r22, null, 12);
        wq(r23, r12);
        pd2.d.n.getClass();
        pd2.d.G(r8, true);
        Unit r24 = Unit.INSTANCE;
        this.f = r23;
        return;
    L48:
        if (this.f == null) goto L56;
        if (r14.isAdded() == true) goto L52;
        wq(r14, r12);
        pd2.d.n.getClass();
        pd2.d.G(r8, true);
        return;
    L52:
        r14.m.c(r19, r18);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e.a.a(r14.m);
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r25 = KtvModeOrderSongDataContext.Companion.a();
        if (r25 == null) goto L55;
        r25.updateCurrentTabData();
    L55:
        KSongOrderSongDialog.aa0(r14, false, r8, 1);
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L25:
        r8 = "other";
    L11:
        r5 = null;
        goto L13
    }
}
