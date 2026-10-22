package com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.universalwidget.MultiLinkUniversalAnimWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.d;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.util.FragmentManagerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.card.KtvRoomCardWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import hh1.w0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;
import vlc.l;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/subwidget/KtvRoomContainerWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/subwidget/KtvRoomContainerBaseWidget;", "Ltb0/a;", "Lcom/bytedance/android/live/ktv/common/util/c;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lvlc/l;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomContainerWidget extends KtvRoomContainerBaseWidget implements tb0.a, com.bytedance.android.live.ktv.common.util.c, com.bytedance.android.livesdk.ktvimpl.base.sei.c, l {
    public static final /* synthetic */ int R = 0;
    public MessageHub I;
    public boolean J;
    public Pair<? extends OrderedSongDataContext, ? extends Disposable> K;
    public Disposable L;
    public Function2<? super Boolean, ? super Long, Unit> M;
    public final String N;
    public KtvPreviewSongsWidget O;
    public Pair<KtvPreviewSongsViewModel, ? extends Disposable> P;
    public KtvPreviewSongsViewModel Q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvRoomContainerWidget a;

        public b(KtvRoomContainerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            KtvModeOrderedSongDataContext.a r4 = KtvModeOrderedSongDataContext.Companion;
            if (r4.getContext() != null) goto L5;
        L6:
            OrderedSongDataContext r5 = (OrderedSongDataContext) this.a.K.getFirst();
            if (r5 == null) goto L9;
            com.bytedance.live.datacontext.b.a(r5, KtvModeOrderedSongDataContext.class);
        L9:
            ALogger.i("KtvRoomContainerWidget", "share KtvModeOrderedSongDataContext");
            return;
        L5:
            if ((!Intrinsics.areEqual((OrderedSongDataContext) this.a.K.getFirst(), r4.getContext())) == true) goto L6;
        }
    }

    public static final class c<T> implements h80.a {
        public final /* synthetic */ KtvRoomContainerWidget a;

        public c(KtvRoomContainerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            IRoom r10 = (IRoom) r9;
            ALogger.i("logKtvMainPath", "onBizEnterKtvRoom, invoke class :KtvRoomContainerWidget");
            this.a.Qq("onBizEnterKtvRoom");
            KtvRoomContainerWidget r11 = this.a;
            qe2.c r0 = r11.z;
            tb0.a r1 = null;
            if (r0 == null) goto L5;
            r0.h = false;
            r0.f = r11.C;
            r0.e = r11.getMRoom();
            r0.g = null;
            r0.g();
            r0.f();
        L5:
            KtvRoomContainerWidget r12 = this.a;
            qe2.c r2 = r12.z;
            if (r2 == null) goto L14;
            BehaviorSubject<List<e>> r3 = r2.b;
            if (r3 == null) goto L14;
            Observable r4 = RxUtilKt.h(r3);
            if (r4 == null) goto L14;
            Disposable r5 = r4.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.a(r12));
            if (r5 == null) goto L14;
            RxUtilKt.c(r5, r12.m);
        L14:
            d r6 = r12.C;
            if (r6 == null) goto L23;
            BehaviorSubject r7 = r6.P0();
            if (r7 == null) goto L23;
            Observable r8 = RxUtilKt.h(r7);
            if (r8 == null) goto L23;
            Disposable r13 = r8.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.b(r12));
            if (r13 == null) goto L23;
            RxUtilKt.c(r13, r12.m);
        L23:
            int r14 = 2;
            o r15 = m.n(((Widget) this.a).dataCenter, null, 2);
            if (r15 == null) goto L28;
            j r16 = r15.getLiveStream();
            if (r16 == null) goto L28;
            com.bytedance.android.live.pushstream.d r17 = (com.bytedance.android.live.pushstream.d) r16.getValue();
        L29:
            KtvRoomContainerWidget r18 = this.a;
            r18.s.d = r17;
            DataCenter r19 = r18.q.getDataCenter();
            if (r19 == null) goto L45;
            Widget.WidgetCallback r20 = ((Widget) r18).widgetCallback;
            if (r20 != null) goto L35;
        L37:
            RecyclableWidgetManager r21 = r18.xq();
            if (r21 == null) goto L40;
            DataCenter r22 = ((WidgetManager) r21).dataCenter;
        L41:
            if (r22 != null) goto L45;
            RecyclableWidgetManager r23 = r18.xq();
            if (r23 == null) goto L45;
            ((WidgetManager) r23).dataCenter = r19;
            goto L45
        L40:
            r22 = null;
            goto L41
        L35:
            if (r20.getWidgetManager().dataCenter != null) goto L37;
            ((Widget) r18).widgetCallback.getWidgetManager().dataCenter = r19;
        L45:
            this.a.p.getKtvRoomProvider().setValue(this.a.s);
            if (KtvSettingHelper.m() == false) goto L48;
            this.a.Gq();
        L48:
            KtvRoomContainerWidget r24 = this.a;
            KtvCoreViewModel r25 = r24.u;
            if (r25 == null) goto L51;
            r24.y = new KtvSingerViewModel(r24.s, r24.q, r25);
        L51:
            this.a.p.getKtvSingerViewModel().setValue(this.a.y);
            this.a.Kq(true);
            KtvRoomContainerWidget.Cq(this.a);
            com.bytedance.android.live.ktv.common.util.e r26 = this.a.t;
            if (r26 == null) goto L54;
            r26.d(new tb0.b.a());
        L54:
            KtvRoomContainerWidget r27 = this.a;
            r27.getClass();
            if (KtvSettingHelper.r().booleanValue() == false) goto L79;
            View r28 = ((Widget) r27).contentView;
            if ((r28 instanceof ViewGroup) == true) goto L59;
            r28 = null;
        L59:
            ViewGroup r29 = (ViewGroup) r28;
            if (r29 == null) goto L105;
            Iterator r30 = UtilityKotlinExtentionsKt.g(r29).iterator();
        L64:
            if (r30.hasNext() == false) goto L68;
            Object r31 = r30.next();
            if ((((View) r31) instanceof GLSurfaceView) == false) goto L64;
        L70:
            if ((r31 instanceof GLSurfaceView) == true) goto L72;
            r31 = null;
        L72:
            GLSurfaceView r32 = (GLSurfaceView) r31;
            r27.o = r32;
            if (r32 != null) goto L83;
            GLSurfaceView r33 = new GLSurfaceView(((Widget) r27).context);
            r33.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r33.setVisibility(8);
            Unit r34 = Unit.INSTANCE;
            r27.o = r33;
            if (r29.getChildCount() >= 2) goto L78;
            r14 = -1;
        L78:
            r29.addView(r27.o, r14);
        L83:
            GLSurfaceView r35 = r27.o;
            if (r35 == null) goto L86;
            n50.a r36 = k50.e.a(r35);
        L87:
            if (r36 == null) goto L89;
            r36.b();
            goto L105
        L89:
            j50.a r37 = new j50.a();
            r27.h = r37;
            GLSurfaceView r38 = r27.o;
            Intrinsics.checkNotNull(r38);
            r37.e = new j50.b(r38);
            GLSurfaceView r39 = r27.o;
            if (r39 == null) goto L92;
            UtilityKotlinExtentionsKt.w(r39);
        L92:
            GLSurfaceView r40 = r27.o;
            if (r40 == null) goto L95;
            Context r41 = ((Widget) r27).context;
            j50.a r42 = r27.h;
            Intrinsics.checkNotNull(r42);
            v50.a.b(r40, r41, r42);
        L95:
            GLSurfaceView r43 = r27.o;
            Intrinsics.checkNotNull(r43);
            k50.c r44 = new k50.c(r43);
            r27.n = r44;
            r44.a();
            j50.a r45 = r27.h;
            if (r45 == null) goto L100;
            GLSurfaceView r46 = r27.o;
            if (r46 == null) goto L100;
            k50.e.c(r46, r45);
        L100:
            k50.c r47 = r27.n;
            if (r47 == null) goto L105;
            GLSurfaceView r48 = r27.o;
            if (r48 == null) goto L105;
            k50.e.b(r48, r47);
            goto L105
        L86:
            r36 = null;
            goto L87
        L68:
            r31 = null;
        L105:
            KtvRoomContainerWidget r49 = this.a;
            if (r49.g != null) goto L112;
            xh0.d r50 = k.n(IInteractService.class).getPlayModeService();
            if (r50 == null) goto L110;
            MultiLinkUniversalAnimWidget r51 = r50.e(r49, SceneType.SCENE_KTV, ((Widget) r49).containerView);
        L111:
            r49.g = r51;
            goto L112
        L110:
            r51 = null;
        L112:
            UtilityKotlinExtentionsKt.s(0, false, true, new KtvRoomContainerWidget$onBizEnterRoom$1$3(this), 3);
            tb0.a r52 = this.a.e;
            if ((r52 instanceof tb0.a) == false) goto L116;
            r1 = r52;
        L116:
            tb0.a r53 = r1;
            if (r53 == null) goto L119;
            r53.onBizEnterRoom();
        L119:
            this.a.Eq();
            return;
        L79:
            GLSurfaceView r54 = (GLSurfaceView) r27.findViewById(2131375524);
            if (r54 == null) goto L105;
            r27.o = r54;
        L28:
            r17 = null;
            goto L29
        }
    }

    static {
    }

    public final void Fq() {
        Disposable r0 = (Disposable) this.K.getSecond();
        if (r0 != null) goto L5;
    L7:
        Disposable r1 = this.L;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isDisposed() == true) goto L14;
        r1.dispose();
        this.L = null;
        return;
    L14:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        this.K = new Pair(null, null);
        goto L7
    }

    public final void Gq() {
        if (this.K.getFirst() != null) goto L11;
        Pair<? extends OrderedSongDataContext, ? extends Disposable> r0 = com.bytedance.live.datacontext.d.a(KtvRoomContainerWidget$initKtvRoomOrderedSongDataContextIfNeed$1.INSTANCE);
        this.K = r0;
        OrderedSongDataContext r1 = (OrderedSongDataContext) r0.getFirst();
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.b.a(r1, KtvModeOrderedSongDataContext.class);
    L8:
        if (v.a() == false) goto L12;
        this.L = du2.a.b(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L12:
        return;
    }

    public final boolean Iq() {
        w r0 = this.d;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r2 = r0.b;
    L7:
        if ((r2 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L10;
        r1 = r2;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r3 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r1;
        if (r3 != null) goto L24;
        Jq("lastSeiResult == null");
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r4 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r4 == null) goto L17;
        if (r4.isEngineOn() != true) goto L17;
    L19:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.p) != null) goto L22;
        Jq("singer show preview song");
        return true;
    L22:
        return false;
    L17:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L22;
    L24:
        if (r3.d() != 1) goto L30;
        if (r3.C() != 0) goto L30;
        Jq("received anchor stop music sei ;; " + r3);
        return true;
    L30:
        if (r3.d() != 2) goto L32;
    L47:
        Jq("received singer stop music sei ;; " + r3);
        return true;
    L32:
        if (r3.d() == 6) goto L47;
        if (((Boolean) KtvSettingHelper.o1.getValue()).booleanValue() == false) goto L46;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r5 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r5 == null) goto L41;
        if (r5.isEngineOn() != true) goto L41;
    L43:
        if (com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.p) != null) goto L46;
        Jq("singer show preview song ignore sei");
        return true;
    L41:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L43;
    L46:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public final void Nq() {
        ALogger.i("KtvRoomContainerWidget", "releaseRoomResource");
        if (KtvSettingHelper.r().booleanValue() == false) goto L18;
        View r0 = ((Widget) this).contentView;
        if ((r0 instanceof ViewGroup) == true) goto L7;
        r0 = null;
    L7:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L11;
        r1.removeView(this.o);
    L11:
        if (((Boolean) KtvSettingHelper.l1.getValue()).booleanValue() == false) goto L13;
        this.o = null;
    L13:
        this.h = null;
        k50.c r2 = this.n;
        if (r2 == null) goto L16;
        r2.b = true;
    L16:
        this.n = null;
    L18:
        if (KtvSettingHelper.m() == false) goto L20;
        Fq();
    L20:
        Fq();
        this.A = null;
        this.C = null;
        this.D = null;
        this.E = null;
        if (((Boolean) KtvSettingHelper.a.getValue()).booleanValue() == false) goto L25;
        KtvSingerViewModel r3 = this.y;
        if (r3 == null) goto L25;
        r3.clearData();
    L25:
        this.F = null;
        if (((Boolean) KtvSettingHelper.l1.getValue()).booleanValue() == false) goto L29;
        this.o = null;
    L29:
        if (KtvSettingHelper.r().booleanValue() == false) goto L35;
        WidgetManager r4 = ((Widget) this).subWidgetManager;
        if (r4 == null) goto L33;
        r4.unload(this.g);
    L33:
        this.g = null;
        return;
    }

    public final void Pq() {
        Widget r0 = this.f;
        if (r0 == null) goto L18;
        if (r0 != null) goto L16;
    L9:
        WidgetManager r1 = this.B;     // Catch: Exception -> L13
    L10:
        if (r1 == null) goto L14;
        r1.unload(this.f);     // Catch: Exception -> L13
    L13:
        ALogger.e("KtvRoomContainerWidget", "unloadKtvRoomCardWidget exception");
    L14:
        this.f = null;
        return;
    L16:
        Widget.WidgetCallback r2 = r0.widgetCallback;     // Catch: Exception -> L13
        if (r2 == null) goto L9;
        r1 = r2.getWidgetManager();     // Catch: Exception -> L13
        if (r1 != null) goto L10;
    }

    public final void onBizDestory() {
        if (((Boolean) KtvSettingHelper.a.getValue()).booleanValue() == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.put("ktv_scene_widget", null);
    L8:
        if (this.J == true) goto L62;
        this.J = true;
        ALogger.i("KtvRoomContainerWidget", "onBizDestory");
        com.bytedance.android.live.ktv.common.util.e r3 = this.t;
        if (r3 == null) goto L12;
        r3.d(new tb0.b.e());
    L12:
        KtvPreviewSongsWidget r4 = this.O;
        if (r4 == null) goto L18;
        RecyclableWidgetManager r5 = xq();
        if (r5 == null) goto L17;
        r5.unload(r4);
    L17:
        this.O = null;
        this.Q = null;
    L18:
        Disposable r6 = (Disposable) this.P.getSecond();
        if (r6 != null) goto L21;
    L23:
        ALogger.i("KtvRoomContainerWidget", "releaseAllResource");
        if (KtvSettingHelper.m() == true) goto L26;
        Fq();
    L26:
        qe2.a r2 = this.e;
        if (r2 == null) goto L29;
        r2.p();
    L29:
        Pq();
        Kq(false);
        IKtvService r7 = k.f(IKtvService.class);
        if (r7 == null) goto L32;
        r7.setKtvContext(null);
    L32:
        this.p.clearKtvCoreAndSingerViewModel();
        if (KtvSettingHelper.w() == false) goto L37;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.p.getSeiProcessor().getValue()).g(this);
        qe2.a r8 = this.e;
        if (r8 == null) goto L37;
        r8.clear();
    L37:
        KtvCoreViewModel r9 = this.u;
        if (r9 == null) goto L40;
        r9.unregisterKtvCoreListener(this.x);
    L40:
        KtvCoreViewModel r10 = this.u;
        if (r10 == null) goto L43;
        r10.clearData();
    L43:
        this.u = null;
        qe2.a r11 = this.e;
        if (r11 == null) goto L47;
        r11.end();
    L47:
        if (((Boolean) KtvSettingHelper.l1.getValue()).booleanValue() == false) goto L49;
        this.o = null;
    L49:
        this.h = null;
        k50.c r12 = this.n;
        if (r12 == null) goto L52;
        r12.b = true;
    L52:
        this.n = null;
        com.bytedance.android.live.ktv.common.util.k r1 = this.p.getStatisticHelper();
        r1.b.clear();
        r1.a = null;
        Nq();
        Qq("releaseAllResource");
        this.I = null;
        this.B = null;
        qe2.c r13 = this.z;
        if (r13 == null) goto L56;
        r13.g();
    L56:
        if (KtvSettingHelper.r().booleanValue() == false) goto L63;
        RecyclableWidgetManager r14 = this.v;
        if (r14 == null) goto L60;
        ((WidgetManager) r14).contentView = null;
    L60:
        this.v = null;
        ((Widget) this).contentView = null;
        return;
    L63:
        return;
    L21:
        if (r6.isDisposed() == true) goto L23;
        r6.dispose();
        this.P = new Pair(null, null);
        goto L23
    }

    public final void onBizEnterRoom() {
        if (this.a == 9) goto L6;
        ALogger.i("KtvRoomContainerWidget", "onBizEnterKtvRoom but scene is not ktv");
        return;
    L6:
        this.p.getStatisticHelper().a();
        runWithRoomEntered(new c(this));
    }

    public final void onBizHide() {
        com.bytedance.android.live.ktv.common.util.e r0 = this.t;
        if (r0 == null) goto L5;
        r0.d(new tb0.b.c());
    L5:
        qe2.a r1 = this.e;
        if ((r1 instanceof tb0.a) == true) goto L8;
        r1 = null;
    L8:
        tb0.a r2 = (tb0.a) r1;
        if (r2 == null) goto L12;
        r2.onBizHide();
        return;
    }

    public final void onBizLeaveRoom() {
        ALogger.i("KtvRoomContainerWidget", "onBizLeaveRoom");
        sb0.b r0 = this.q;
        if (r0 == null) goto L5;
        sb0.e r1 = r0.b();
    L7:
        if (r1 != null) goto L9;
    L13:
        Mq("onBizLeaveRoom");
        this.t.d(new tb0.b.b());
        this.p.getKtvSingerViewModel().setValue(null);
        this.y = null;
        KtvCoreViewModel r2 = this.u;
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.k r3 = r2.getAnchorController();
        if (r3 == null) goto L18;
        r3.i();
    L18:
        KtvCoreViewModel r4 = this.u;
        if (r4 == null) goto L21;
        r4.setAnchorController(null);
    L21:
        Pq();
        WidgetManager r5 = ((Widget) this).subWidgetManager;
        if (r5 == null) goto L24;
        r5.unload(this.g);
    L24:
        this.g = null;
        Kq(false);
        qe2.a r6 = this.e;
        if ((r6 instanceof tb0.a) == true) goto L27;
        r6 = null;
    L27:
        tb0.a r7 = (tb0.a) r6;
        if (r7 == null) goto L30;
        r7.onBizLeaveRoom();
    L30:
        Widget.WidgetCallback r8 = ((Widget) this).widgetCallback;
        if (r8 == null) goto L35;
        WidgetManager r9 = r8.getWidgetManager();
        if (r9 == null) goto L35;
        r9.dataCenter = null;
    L35:
        RecyclableWidgetManager r10 = this.v;
        if (r10 == null) goto L38;
        ((WidgetManager) r10).dataCenter = null;
    L38:
        Nq();
        return;
    L9:
        if (this.q.isAnchor() == true) goto L13;
        if (this.p.isCurrentUserIsSinger() == false) goto L13;
        this.p.updateCurrentUserIsSinger(false);
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void onBizShow() {
        this.t.d(new tb0.b.d());
        qe2.a r0 = this.e;
        if ((r0 instanceof tb0.a) == true) goto L5;
        r0 = null;
    L5:
        tb0.a r1 = (tb0.a) r0;
        if (r1 == null) goto L9;
        r1.onBizShow();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerBaseWidget
    public final void onDestroy() {
        Jq("onDestroy");
        super.onDestroy();
        Lazy r0 = KtvCommonSettingHelper.a;
    }

    public final void Eq() {
        if (FoldScreenUtils.e() == false) goto L5;
    L18:
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L22;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L22;
    L23:
        r1.height = s1.w();
        r1.width = (int) (s1.w() * 0.5625f);
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L26;
        r2.setTranslationX((s1.y() - r1.width) / 2.0f);
    L26:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L29;
        r3.setLayoutParams(r1);
    L29:
        qe2.a r4 = this.e;
        if (r4 == null) goto L33;
        r4.m();
        return;
    L33:
        return;
    L22:
        r1 = new FrameLayout.LayoutParams(-1, -1);
        goto L23
    L5:
        if (PadConfigUtils.c() == true) goto L18;
        ViewGroup r5 = ((Widget) this).containerView;
        if (r5 == null) goto L11;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L11;
    L12:
        r6.height = -1;
        r6.width = -1;
        ViewGroup r7 = ((Widget) this).containerView;
        if (r7 == null) goto L15;
        r7.setTranslationX(0.0f);
    L15:
        ViewGroup r8 = ((Widget) this).containerView;
        if (r8 == null) goto L29;
        r8.setLayoutParams(r6);
    L11:
        r6 = new FrameLayout.LayoutParams(-1, -1);
        goto L12
    }

    public final void onClear() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onClear();
        if (KtvSettingHelper.w() == true) goto L8;
        qe2.a r0 = this.e;
        if (r0 == null) goto L9;
        r0.clear();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        qe2.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.M;
    }

    public final String getTypeName() {
        return this.N;
    }

    public static final void Cq(KtvRoomContainerWidget r3) {
        r3.getClass();
        KtvRoomCardWidget r0 = new KtvRoomCardWidget(r3.q, r3.G);
        r3.f = r0;
        WidgetManager r4 = r3.B;
        if (r4 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "$this$recycleLoad");
        Intrinsics.checkNotNullParameter(r0, "widget");
        if (((Widget) r0).contentView != null) goto L7;
        r4.load(2131377042, r0, false);
        return;
    L7:
        ViewGroup r1 = (ViewGroup) r4.contentView.findViewById(2131377042);
        r0.setWidgetCallback(r4.widgetCallback);
        ((Widget) r0).context = r4.context;
        ((Widget) r0).dataCenter = r4.dataCenter;
        ((Widget) r0).containerView = r1;
        r4.widgetViewGroupHashMap.put(r0, r1);
        WidgetManager.IWidgetConfigHandler r2 = r4.widgetConfigHandler;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNull(r2);
        r2.onLoad(r0);
    L10:
        r4.continueLoad(r0, r1, ((Widget) r0).contentView);
        return;
    }

    public static void Jq(String r2) {
        Intrinsics.checkNotNullParameter("KtvRoomContainerWidget", LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i("ttlive_ktv_KtvRoomContainerWidget", r2);
    }

    public final void Kq(boolean r2) {
        if (r2 == false) goto L4;
        this.w = com.bytedance.live.datacontext.d.a(KtvRoomContainerWidget$loadKtvRoomContext$1.INSTANCE);
        this.p.isKtvRoomContextInit().setValue(Boolean.TRUE);
        return;
    L4:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r3 = KtvRoomContext.a.a();
        if (r3 == null) goto L9;
        n<KtvPreviewSongsViewModel> r4 = r3.getPreviewViewModel();
        if (r4 == null) goto L9;
        r4.setValue(null);
    L9:
        Pair<KtvRoomContext, ? extends Disposable> r5 = this.w;
        if (r5 == null) goto L14;
        Disposable r6 = (Disposable) r5.getSecond();
        if (r6 == null) goto L14;
        r6.dispose();
    L14:
        this.p.isKtvRoomContextInit().setValue(Boolean.FALSE);
    }

    public final void Mq(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ALogger.i("KtvRoomContainerWidget", "registerMethods ;; messageHub: " + this.I + ", source: " + r3);
        MessageHub r4 = this.I;
        if (r4 == null) goto L5;
        r4.addMessageListener(MessageType.KTV_USER_SINGING_HOT_MESSAGE.getIntType(), this);
    L5:
        MessageHub r5 = this.I;
        if (r5 == null) goto L9;
        r5.addMessageListener(MessageType.KTV_WEEKLY_SINGING_HOT_RANK_POS_MESSAGE.getIntType(), this);
        return;
    }

    public final void Qq(String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ALogger.i("KtvRoomContainerWidget", "unregisterMethods ;; messageHub: " + this.I + ", source: " + r3);
        MessageHub r4 = this.I;
        if (r4 == null) goto L5;
        r4.removeMessageListener(MessageType.KTV_USER_SINGING_HOT_MESSAGE.getIntType(), this);
    L5:
        MessageHub r5 = this.I;
        if (r5 == null) goto L9;
        r5.removeMessageListener(MessageType.KTV_WEEKLY_SINGING_HOT_RANK_POS_MESSAGE.getIntType(), this);
        return;
    }

    public final void Rq(sb0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        ALogger.i("logKtvMainPath", ("updateDataEntity:" + r4) + ", invoke class :KtvRoomContainerWidget");
        sb0.a r0 = this.r;
        r0.getClass();
        ALogger.i("DataEntityInvocationHandler", "dataEntity change:" + r4);
        r0.a = r4;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r1);
        Eq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerBaseWidget, com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvRoomSceneBaseWidget
    public final void onLoad(Object[] r5) {
        Function2<? super Boolean, ? super Long, Unit> r0 = this.M;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
    L5:
        super.onLoad(r5);
        RecyclableWidgetManager r6 = this.v;
        Fragment r2 = null;
        if (r6 == null) goto L12;
        if (r6.isDetached() == true) goto L12;
        if (((Boolean) h.S3.getValue(null, h.a[251(0xfb, float:3.52E-43)])).booleanValue() == true) goto L12;
    L64:
        Lazy r7 = KtvCommonSettingHelper.a;
        return;
    L12:
        if (KtvSettingHelper.i() == false) goto L52;
        Context r8 = ((Widget) this).context;
        if ((r8 instanceof FragmentActivity) == true) goto L16;
        r8 = null;
    L16:
        Activity r9 = (FragmentActivity) r8;
        if (r9 != null) goto L21;
        r9 = com.bytedance.android.live.core.utils.a.d();
    L21:
        if ((r9 instanceof FragmentActivity) == true) goto L23;
        r9 = null;
    L23:
        FragmentActivity r10 = (FragmentActivity) r9;
        Fragment r3 = com.bytedance.android.livesdk.ktvimpl.base.util.d.a(r10);
        if (r3 != null) goto L26;
    L28:
        if (r10 != null) goto L30;
    L32:
        if (r3 == null) goto L45;
        FragmentManager r11 = r3.getChildFragmentManager();
        if (r11 == null) goto L45;
        List r12 = r11.getFragments();
        if (r12 == null) goto L45;
        Iterator r13 = r12.iterator();
    L39:
        if (r13.hasNext() == false) goto L43;
        Object r4 = r13.next();
        if ((((Fragment) r4) instanceof RecyclableWidgetManager) == false) goto L39;
    L44:
        Fragment r14 = (Fragment) r4;
    L47:
        if ((r14 instanceof RecyclableWidgetManager) == false) goto L50;
        r2 = r14;
    L50:
        RecyclableWidgetManager r15 = (RecyclableWidgetManager) r2;
    L51:
        this.v = r15;
        goto L64
    L43:
        r4 = null;
    L45:
        r14 = null;
        goto L47
    L30:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r10.getSupportFragmentManager()) == true) goto L32;
        r15 = RecyclableWidgetManager.ha0(r10, ((Widget) this).contentView);
        goto L51
    L26:
        if (FragmentManagerHelper.INSTANCE.isExecutingActions(r3.getChildFragmentManager()) == true) goto L28;
        r15 = RecyclableWidgetManager.ga0(r3, ((Widget) this).contentView);
        goto L51
    L52:
        Fragment r16 = ((Widget) this).context;
        if ((r16 instanceof FragmentActivity) == true) goto L55;
        r16 = null;
    L55:
        Fragment r17 = (FragmentActivity) r16;
        if (r17 != null) goto L60;
        r17 = com.bytedance.android.live.core.utils.a.d();
    L60:
        if ((r17 instanceof FragmentActivity) == false) goto L63;
        r2 = r17;
    L63:
        this.v = RecyclableWidgetManager.ha0((FragmentActivity) r2, ((Widget) this).contentView);
        goto L64
    }

    public final void onMessage(tlc.d r2) {
        qe2.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.d = r2;
        if (KtvSettingHelper.w() == true) goto L5;
        return;
    L5:
        if (Iq() == false) goto L15;
        KtvCoreViewModel r3 = this.u;
        if (r3 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r4 = r3.getCurState();
    L11:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L16;
        Sq(true, "onSeiResult state is idle");
        return;
    L16:
        return;
    L9:
        r4 = null;
        goto L11
    }

    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.M = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerBaseWidget
    public final void yq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "valid");
        KtvRoomLyricsStateMachineConfig.d r4 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        Sq(false, "onPreparing");
        return;
    L6:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L9;
        Sq(false, "onSinging");
        return;
    L9:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L12;
        Sq(false, "onPaused");
        return;
    L12:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L20;
        if (KtvSettingHelper.w() == true) goto L16;
    L18:
        Sq(true, "onIdle");
        return;
    L16:
        if (Iq() == true) goto L18;
        return;
    L20:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L22;
        return;
    L22:
        if (KtvSettingHelper.w() == false) goto L27;
        if (Iq() == true) goto L27;
        return;
    L27:
        if (KtvSettingHelper.w() == false) goto L35;
        Sq(true, "onClosed");
        return;
    }

    public final void Lq(i r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "switchSceneEvent");
        boolean r2 = true;
        if (r14.a == this.a) goto L5;
        boolean r0 = true;
    L6:
        List r4 = CollectionsKt.listOf(new Integer[]{61, 0});
        int r5 = r14.b;
        if (r5 != this.b) goto L9;
    L13:
        boolean r6 = false;
    L14:
        ALogger.i("coreVm排查", "onSceneChange:" + this.u + "--- ;;  sceneChange: " + r0 + "---" + this.a + "--" + r14.a + " ;; uiLayoutChange: " + r6 + "---" + this.b + "--" + r14.b);
        int r7 = r14.a;
        this.a = r7;
        int r16 = r14.b;
        this.b = r16;
        Lazy r8 = KtvCommonSettingHelper.a;
        this.p.updateKtvAllStateValue(KtvUtilsKt.I(r7, r16));
        if (KtvUtilsKt.I(this.a, this.b) == true) goto L18;
        clearAfterDestroyed();
        return;
    L18:
        if (KtvSettingHelper.w() == false) goto L21;
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) this.p.getSeiProcessor().getValue(), this);
    L21:
        if (KtvSettingHelper.m() == false) goto L25;
        if (r15 == false) goto L30;
    L29:
        boolean r17 = false;
    L31:
        if (r17 == false) goto L33;
        Gq();
    L33:
        if (r15 == false) goto L35;
        Mq("feed init");
    L35:
        com.bytedance.android.live.pushstream.d r18 = null;
        if (this.O == null) goto L38;
    L61:
        IKtvService r19 = k.f(IKtvService.class);
        if (r19 == null) goto L65;
        r19.setKtvContext(this.p);
    L65:
        if (this.q.isAnchor() == false) goto L73;
        o r110 = m.n(((Widget) this).dataCenter, null, 2);
        if (r110 == null) goto L71;
        j r111 = r110.getLiveStream();
        if (r111 == null) goto L71;
        r18 = (com.bytedance.android.live.pushstream.d) r111.getValue();
    L71:
        this.s.d = r18;
    L73:
        if (this.u == null) goto L76;
        if (r0 == true) goto L76;
        if (r6 == true) goto L76;
    L78:
        if (this.z != null) goto L81;
        this.z = new qe2.c(getMRoom(), this.C);
    L81:
        if (this.e == null) goto L83;
    L94:
        Intrinsics.checkNotNullParameter(new KtvRoomContainerWidget$onSceneChange$2(this), "cb");
        qe2.a r112 = this.e;
        if (r112 == null) goto L97;
        r112.f();
    L97:
        qe2.a r113 = this.e;
        if (r113 == null) goto L100;
        r113.h(false);
    L100:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r114 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r114 == null) goto L113;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r115 = r114.getLinkUserInfoCenter();
        if (r115 == null) goto L113;
        ILinkPlayerInfoBridge r116 = r115.getGuestInfo(this.q.e().toString(), "");
        if (r116 == null) goto L113;
        if (r116.getSilenceStatus() != 0) goto L110;
        r2 = false;
    L110:
        qe2.a r117 = this.e;
        if (r117 == null) goto L113;
        r117.i(r2);
    L113:
        com.bytedance.android.live.liveinteract.animation.e r118 = this.e;
        if ((r118 instanceof com.bytedance.android.live.liveinteract.animation.e) == false) goto L121;
        InteractAnimationController r119 = this.F;
        if (r119 == null) goto L121;
        if (r118 == null) goto L120;
        r119.g(r118);
        goto L121
    L120:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.animation.BaseSeatInfoProvider");
    L121:
        Eq();
        return;
    L83:
        if (((Widget) this).context == null) goto L94;
        if ((((Widget) this).contentView instanceof ViewGroup) == false) goto L94;
        Context r9 = ((Widget) this).context;
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L93;
        ViewGroup r10 = (ViewGroup) r1;
        sb0.b r11 = this.q;
        Function0<WidgetManager> r12 = new KtvRoomContainerWidget$onSceneChange$1(this);
        com.bytedance.android.live.pushstream.d r3 = this.A;
        if (r3 != null) goto L91;
        r3 = this.q.b().getLiveStream();
    L91:
        KtvContext r13 = this.p;
        GLSurfaceView r120 = this.o;
        qe2.c r121 = this.z;
        Intrinsics.checkNotNull(r121);
        this.e = new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a(r9, r10, r11, r12, r3, r13, r120, r121);
        goto L94
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L76:
        Function0<Unit> r122 = new KtvRoomContainerWidget$initCoreViewModel$1(this);
        Intrinsics.checkNotNullParameter(r122, "cb");
        r122.invoke();
        goto L78
    L38:
        if (xq() == null) goto L61;
        if (this.P.getFirst() == null) goto L42;
    L50:
        ViewGroup r123 = ((Widget) this).containerView;
        if (r123 == null) goto L61;
        ViewGroup r124 = (ViewGroup) r123.findViewById(2131376999);
        if (r124 == null) goto L61;
        boolean r20 = KtvCommonSettingHelper.a(this.q.b().getAnchorAbMap());
        KtvPreviewSongsViewModel r21 = (KtvPreviewSongsViewModel) this.P.getFirst();
        if (r21 == null) goto L57;
        KtvPreviewSongsWidget r22 = new KtvPreviewSongsWidget(r21, this.p, false, r20);
    L58:
        this.O = r22;
        RecyclableWidgetManager r23 = xq();
        if (r23 == null) goto L61;
        r23.load(r124, this.O, false);
        goto L61
    L57:
        r22 = null;
        goto L58
    L42:
        if (KtvCommonSettingHelper.a(this.q.b().getAnchorAbMap()) == false) goto L44;
        final int r125 = 5;
    L45:
        Pair<KtvPreviewSongsViewModel, ? extends Disposable> r126 = com.bytedance.live.datacontext.d.a(new KtvRoomContainerWidget$initPreviewSongDataContext$1(this, r125));
        this.P = r126;
        this.Q = (KtvPreviewSongsViewModel) r126.getFirst();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r127 = KtvRoomContext.a.a();
        if (r127 == null) goto L50;
        n<KtvPreviewSongsViewModel> r128 = r127.getPreviewViewModel();
        if (r128 == null) goto L50;
        r128.setValue(this.P.getFirst());
        goto L50
    L44:
        r125 = 4;
    L30:
        r17 = true;
        goto L31
    L25:
        if (this.K.getFirst() == null) goto L30;
        if (r0 == true) goto L30;
        if (r6 == false) goto L29;
    L9:
        if (r4.contains(Integer.valueOf(r5)) == false) goto L13;
        if (r4.contains(Integer.valueOf(this.b)) == false) goto L13;
        r6 = true;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public final void Sq(boolean r2, String r3) {
        if (r2 == false) goto L11;
        KtvPreviewSongsViewModel r4 = this.Q;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.isShowPreviewCard() == true) goto L20;
        KtvPreviewSongsViewModel r5 = this.Q;
        if (r5 == null) goto L21;
        r5.setShowPreviewCard(true, r3);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        KtvPreviewSongsViewModel r6 = this.Q;
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.isShowPreviewCard() != true) goto L24;
        KtvPreviewSongsViewModel r7 = this.Q;
        if (r7 == null) goto L25;
        r7.setShowPreviewCard(false, r3);
        return;
    L25:
        return;
    }

    public KtvRoomContainerWidget(com.bytedance.android.live.pushstream.d r1, WidgetManager r2, d r3, KtvContext r4, w0 r5, y r6, InteractAnimationController r7, j1 r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
        this.K = new Pair(null, null);
        this.N = "main_widget";
        this.P = new Pair(null, null);
    }
}
