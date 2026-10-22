package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.livesdk.ktvapi.WidgetViewModelProviders;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvMvLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.DragLinearLayout;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvOpusOrderSongButton;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvOpusMicLabelAnim;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.mv.SmoothEnterSurfaceView;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.message.KtvDressSyncData;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvInteractElementWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Ltb0/a;", "Lfd2/k;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "a", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvInteractElementWidget extends HolderRoomWidget implements tb0.a, fd2.k, com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    public final sb0.b A;
    public KtvRoomInteractViewModel d;
    public TextureView e;
    public DragLinearLayout f;
    public l g;
    public FrameLayout h;
    public final int i;
    public KtvOpusMidiWidget j;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b k;
    public final CompositeDisposable l;
    public final BaseCoreViewModel m;
    public MvLyricWidget n;
    public KtvDressSyncData o;
    public Integer p;
    public KtvOpusOrderSongButton q;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r;
    public final com.bytedance.android.live.ktv.common.util.e s;
    public View t;
    public boolean u;
    public final c v;
    public Float w;
    public KtvOpusMicLabelAnim x;
    public boolean y;
    public final KtvContext z;

    public static final class a {
    }

    public static final class b implements Function1<Float, Unit> {
        public final WeakReference<KtvInteractElementWidget> a;

        public b(WeakReference<KtvInteractElementWidget> r2) {
            Intrinsics.checkNotNullParameter(r2, "widgetRef");
            this.a = r2;
        }

        public final Object invoke(Object r2) {
            float r3 = ((Number) r2).floatValue();
            KtvInteractElementWidget r0 = this.a.get();
            if (r0 == null) goto L6;
            KtvInteractElementWidget.wq(r0, r3);
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class c implements com.bytedance.android.live.ktv.common.util.c {
        public Function2<? super Boolean, ? super Long, Unit> a;

        public final String getTypeName() {
            return "midi";
        }

        public c() {
        }

        public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
            return this.a;
        }

        public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvInteractElementWidget a;

        public d(KtvInteractElementWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Boolean r6 = (Boolean) r5;
            MidiSkinDressInfo r3 = null;
            KtvInteractElementWidget.zq(this.a, r6.booleanValue(), null, 4);
            com.bytedance.live.datacontext.n<MidiSkinDressInfo> r0 = this.a.z.getMidiSkinContext();
            if (r0 == null) goto L6;
            r3 = (MidiSkinDressInfo) r0.getValue();
        L6:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L14;
            if (r3 == null) goto L15;
            KtvOpusMidiWidget r7 = this.a.j;
            if (r7 == null) goto L16;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r8 = r7.c;
            if (r8 == null) goto L17;
            r8.y(r3);
            return;
        L17:
            return;
        L16:
            return;
        L15:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvInteractElementWidget$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02521 extends PropertyReference0Impl {
        public C02521(KtvInteractElementWidget r7) {
            super(r7, KtvInteractElementWidget.class, "vm", "getVm()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomInteractViewModel;", 0);
        }

        public Object get() {
            return ((KtvInteractElementWidget) ((CallableReference) this).receiver).xq();
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131563348;
    }

    public final Widget getWidget() {
        return this;
    }

    public final void onBizHide() {
        this.u = false;
    }

    public final void onBizShow() {
    }

    public final void Aq() {
        KtvOpusMidiWidget r0 = this.j;
        if (r0 == null) goto L11;
        WidgetManager r1 = ((Widget) this).subWidgetManager;
        if (r1 == null) goto L12;
        r1.unload(r0);
        this.j = null;
        KtvRoomInteractViewModel r2 = this.d;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L9:
        r2.isMidiVisible().setValue(Boolean.FALSE);
        return;
    L12:
        return;
    }

    public final void Bq() {
        com.bytedance.live.datacontext.n<Integer> r0 = this.z.getKtvCardViewSizeChanged();
        if (PadConfigUtils.c() == false) goto L5;
    L10:
        int r1 = (int) (com.bytedance.android.live.core.utils.s1.y() * 0.35f);
    L11:
        r0.setValue(Integer.valueOf(r1));
        RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).post(new o42.c(true, false, "ktv room"));
        return;
    L5:
        if (FoldScreenUtils.e() == true) goto L10;
        if (com.bytedance.android.live.core.utils.s1.y() > com.bytedance.android.live.core.utils.s1.w()) goto L10;
        r1 = com.bytedance.android.live.core.utils.s1.j(2131168834);
        goto L11
    }

    public final void onBizDestory() {
        KtvOpusOrderSongButton r0 = this.q;
        if (r0 == null) goto L6;
        r0.e.dispose();
    L6:
        if (KtvSettingHelper.r().booleanValue() == false) goto L11;
        MvLyricWidget r1 = this.n;
        if (r1 == null) goto L12;
        r1.i();
        return;
    L12:
        return;
    }

    public final void onBizEnterRoom() {
        if (((Widget) this).widgetCallback == null) goto L5;
        enableSubWidgetManager();
    L5:
        boolean r0 = true;
        this.u = true;
        KtvOpusOrderSongButton r1 = this.q;
        if (r1 != null) goto L8;
    L24:
        l r2 = this.g;
        if (r2 != null) goto L27;
    L56:
        WidgetManager r3 = ((Widget) this).subWidgetManager;
        if (r3 == null) goto L59;
        r3.dataCenter = this.A.getDataCenter();
    L59:
        Bq();
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r4 = KtvRoomContext.a.a();
        if (r4 == null) goto L68;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.isMidiOpened();
        if (r5 == null) goto L68;
        Observable r6 = r5.a();
        if (r6 == null) goto L68;
        ObservableSubscribeProxy r7 = (ObservableSubscribeProxy) r6.as(autoDispose());
        if (r7 == null) goto L68;
        r7.subscribe(new d(this));
    L68:
        Long r8 = (Long) com.bytedance.android.livesdk.sharedpref.c.K.getValue();
        if (r8 != null) goto L72;
    L73:
        Lazy r9 = KtvMusicControlManager.d;
        KtvMusicControlManager r10 = KtvMusicControlManager.a.a();
        r10.c = new KtvInteractElementWidget$initObserver$1(this);
    L74:
        ConstraintLayout r11 = this.q;
        if (r11 == null) goto L77;
        r11.setVisibility(0);
    L77:
        this.y = false;
        return;
    L72:
        if (r8.longValue() == (-1)) goto L74;
    L27:
        if (KtvRoomContext.Companion == null) goto L37;
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L37;
        com.bytedance.live.datacontext.k<Boolean> r13 = r12.getOriginSwitch();
        if (r13 == null) goto L37;
        PublishSubject r14 = r13.onEvent();
        if (r14 == null) goto L37;
        Disposable r15 = r14.subscribe(new h(r2));
        if (r15 == null) goto L37;
        RxUtilKt.c(r15, r2.c);
    L37:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r16 = r2.w;
        if (r16 == null) goto L40;
        r16.g(r2.b, r2.h, null, new KtvControlArea$onRoomContextInit$2(r2));
    L40:
        sb0.b r17 = (sb0.b) r2.t.getDataEntity().getValue();
        if (r17 != null) goto L43;
    L45:
        r0 = false;
    L46:
        if (r0 == true) goto L56;
        IMiddlewareUserService r18 = jc1.k.f(IMiddlewareUserService.class);
        if (r18 == null) goto L56;
        com.bytedance.android.livesdk.user.e r19 = r18.user();
        if (r19 == null) goto L56;
        Observable r20 = r19.u();
        if (r20 == null) goto L56;
        Disposable r21 = r20.subscribe(new i(r2));
        if (r21 == null) goto L56;
        RxUtilKt.c(r21, r2.c);
        goto L56
    L43:
        if (r17.isAnchor() != true) goto L45;
    L8:
        if (r1.e.isDisposed() == false) goto L10;
        r1.e = new CompositeDisposable();
    L10:
        KtvModeOrderedSongDataContext r22 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r22 == null) goto L15;
        Disposable r23 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r22, null, new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.y(r1), 3);
        if (r23 == null) goto L15;
        RxUtilKt.c(r23, r1.e);
    L15:
        KtvContext r24 = r1.d;
        if (r24 == null) goto L24;
        com.bytedance.live.datacontext.n<Long> r25 = r24.getKtvAddDressVersion();
        if (r25 == null) goto L24;
        Observable r26 = r25.a();
        if (r26 == null) goto L24;
        Disposable r27 = r26.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.z(r1));
        if (r27 == null) goto L24;
        RxUtilKt.c(r27, r1.e);
        goto L24
    }

    public final void onBizLeaveRoom() {
        KtvOpusOrderSongButton r0 = this.q;
        if (r0 == null) goto L5;
        r0.e.dispose();
    L5:
        Lazy r1 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().c = null;
        if (vm2.h.p() == false) goto L10;
        ConstraintLayout r2 = this.q;
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        this.y = false;
    }

    public final void onDestroy() {
        l r0 = this.g;
        if (r0 == null) goto L7;
        r0.c.dispose();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r1 = r0.w;
        if (r1 == null) goto L7;
        r1.onDestroy();
    L7:
        this.l.dispose();
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.z.getSeiProcessor().getValue()).g(this);
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.put("ktv_mv_style_flag", Boolean.FALSE);
    L10:
        xs2.b.a().post(new id2.b(null, "KtvMvStageWidget"));
        this.z.getCurrentMvVid().setValue(null);
        Aq();
        this.z.getBizLcMager().c(this);
        this.z.isPushingExternalVideo().setValue(Boolean.FALSE);
        Lazy r3 = KtvMusicControlManager.d;
        KtvMusicControlManager.a.a().c = null;
        super.onDestroy();
    }

    public final KtvRoomInteractViewModel xq() {
        KtvRoomInteractViewModel r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L5:
        return r0;
    }

    public final void onCreate() {
        super/*com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget*/.onCreate();
        WidgetViewModelProviders r0 = WidgetViewModelProviders.a;
        ViewModelProvider.Factory r1 = new AnonymousClass1(this);
        r0.getClass();
        KtvRoomInteractViewModel r2 = (KtvRoomInteractViewModel) WidgetViewModelProviders.a(this, r1).get(KtvRoomInteractViewModel.class);
        this.d = r2;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L5:
        Context r3 = ((Widget) this).context;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L147;
        r2.initOpusManager(r3, (ViewGroup) r4);
        KtvRoomInteractViewModel r5 = this.d;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L10:
        this.e = r5.getOpusMvManager().a;
        KtvRoomInteractViewModel r6 = this.d;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L13:
        SmoothEnterSurfaceView r7 = r6.getOpusMvManager().b;
        KtvRoomInteractViewModel r8 = this.d;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L16:
        r8.init(this);
        DragLinearLayout r9 = (DragLinearLayout) ((Widget) this).contentView.findViewById(2131375508);
        this.f = r9;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L20:
        if (KtvSettingHelper.r().booleanValue() == false) goto L22;
        Function1<? super Float, Unit> r10 = new b(new WeakReference(this));
    L23:
        r9.setRegionConfirmListener(r10);
        DragLinearLayout r11 = this.f;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L26:
        r11.setDraggable(this.z.isCurrentUserIsSinger());
        ViewGroup r12 = (ViewGroup) ((Widget) this).contentView.findViewById(2131392032);
        this.t = ((Widget) this).contentView.findViewById(2131376994);
        KtvOpusMicLabelAnim r13 = (KtvOpusMicLabelAnim) r12.findViewById(2131376980);
        this.x = r13;
        if (r13 == null) goto L29;
        r13.b();
    L29:
        KtvRoomInteractViewModel r14 = this.d;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L32:
        com.bytedance.android.livesdk.ktvapi.util.d.a(r14.getStageUiState(), this, KtvInteractElementWidget$initView$2.INSTANCE, new r(this));
        if (KtvSettingHelper.n().booleanValue() == true) goto L37;
        ConstraintLayout r15 = this.q;
        if (r15 == null) goto L52;
        r15.setVisibility(8);
    L52:
        View r16 = ((Widget) this).contentView;
        if (r16 == null) goto L57;
        ViewStub r17 = (ViewStub) r16.findViewById(2131377080);
        if (r17 == null) goto L57;
        KeyEvent.Callback r18 = r17.inflate();
    L59:
        if ((r18 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) == true) goto L61;
        r18 = null;
    L61:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r19 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) r18;
        if (r19 == null) goto L74;
        KtvRoomInteractViewModel r20 = this.d;
        if (r20 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L66:
        r19.setKtvRoomViewModel(r20);
        if ((r19 instanceof View) == true) goto L69;
        Object r21 = null;
    L70:
        View r22 = (View) r21;
        if (r22 == null) goto L73;
        r22.setVisibility(8);
    L73:
        Unit r23 = Unit.INSTANCE;
    L75:
        this.r = r19;
        RxUtilKt.c(this.z.observeSingEndedFeedbackSei(new o(this)), this.l);
        KtvRoomInteractViewModel r24 = this.d;
        if (r24 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L78:
        com.bytedance.android.livesdk.ktvapi.util.d.a(r24.getStageUiState(), this, KtvInteractElementWidget$initSongEndFeedBack$3.INSTANCE, new p(this));
        KtvRoomInteractViewModel r25 = this.d;
        if (r25 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L81:
        r25.getSingerFollowState().observe(this, new q(this));
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) this.z.getSeiProcessor().getValue(), this);
        Context r26 = ((Widget) this).context;
        KtvContext r27 = this.z;
        KtvRoomInteractViewModel r28 = this.d;
        if (r28 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L84:
        Context r29 = ((Widget) this).context;
        KtvRoomInteractViewModel r110 = this.d;
        if (r110 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L87:
        l r30 = new l(r26, r27, r28, this, new KtvRoomChallengeViewWrapper(r29, r110));
        r12.addView(r30, 0);
        Unit r31 = Unit.INSTANCE;
        this.g = r30;
        if (this.h != null) goto L97;
        this.h = new FrameLayout(((Widget) this).context);
        if (KtvSettingHelper.z() == false) goto L92;
        int r32 = com.bytedance.android.live.core.utils.s1.k(2131168818);
    L93:
        DragLinearLayout r33 = this.f;
        if (r33 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L96:
        r33.addView(this.h, new ViewGroup.LayoutParams(-1, r32));
        goto L97
    L92:
        r32 = -2;
    L97:
        DragLinearLayout r34 = this.f;
        if (r34 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L101:
        if ((r34 instanceof ViewGroup) == true) goto L103;
        r34 = null;
    L103:
        if (r34 != null) goto L105;
    L129:
        KtvContext.observerCurrentUserIsSinger$default(this.z, this, false, new s(this), 2, null);
        KtvRoomInteractViewModel r35 = this.d;
        if (r35 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L132:
        r35.isMidiVisible().observeForever(new u(this));
        KtvRoomInteractViewModel r36 = this.d;
        if (r36 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L135:
        r36.getStateChangeEvent().observe(this, new v(this));
        KtvRoomInteractViewModel r37 = this.d;
        if (r37 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L138:
        r37.getKtvMicLabelEvent().observe(this, new w(this));
        if (vm2.h.p() == true) goto L141;
        return;
    L141:
        if ((this.z.getBizLcMager().a instanceof tb0.c.b) == true) goto L149;
        ConstraintLayout r38 = this.q;
        if (r38 == null) goto L150;
        r38.setVisibility(8);
        return;
    L150:
        return;
    L149:
        return;
    L105:
        if (KtvSettingHelper.r().booleanValue() == false) goto L118;
        MvLyricWidget r39 = this.n;
        if (r39 == null) goto L114;
        ViewGroup r40 = r39.c;
        if (r40 == null) goto L114;
        DragLinearLayout r41 = this.f;
        if (r41 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L113:
        r41.removeView(r40);
    L114:
        MvLyricWidget r42 = this.n;
        if (r42 == null) goto L117;
        r42.i();
    L117:
        this.n = null;
    L118:
        DragLinearLayout r43 = this.f;
        if (r43 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L121:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a r44 = new KtvInteractElementWidget$initLyricWidget$$inlined$let$lambda$1(this);
        KtvRoomInteractViewModel r45 = this.d;
        if (r45 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L124:
        MvLyricWidget r46 = new MvLyricWidget(this, r43, r44, r45);
        this.n = r46;
        r46.v = this.u;
        r46.g(new ViewGroup.MarginLayoutParams(-1, com.bytedance.android.live.core.utils.s1.f(65.0f)));
        MvLyricWidget r47 = this.n;
        if (r47 == null) goto L129;
        ViewGroup r48 = r47.c;
        if (r48 == null) goto L129;
        r48.setPadding(com.bytedance.android.live.core.utils.s1.f(10.0f), 0, com.bytedance.android.live.core.utils.s1.f(10.0f), 0);
        goto L129
    L69:
        r21 = r19;
        goto L70
    L74:
        r19 = null;
    L57:
        r18 = null;
        goto L59
    L37:
        ViewGroup r49 = ((Widget) this).containerView;
        if (r49 == null) goto L40;
        ViewParent r50 = r49.getParent();
    L42:
        if ((r50 instanceof ViewGroup) == true) goto L44;
        r50 = null;
    L44:
        ViewGroup r51 = (ViewGroup) r50;
        if (r51 == null) goto L52;
        KtvOpusOrderSongButton r52 = (KtvOpusOrderSongButton) r51.findViewById(2131381650);
        if (r52 == null) goto L52;
        KtvContext r53 = this.z;
        KtvRoomInteractViewModel r54 = this.d;
        if (r54 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L51:
        r52.T5(r53, r54);
        this.q = r52;
        goto L52
    L40:
        r50 = null;
        goto L42
    L22:
        r10 = new KtvInteractElementWidget$initView$1(this);
        goto L23
    L147:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        MvLyricWidget r0 = this.n;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        KtvOpusMidiWidget r1 = this.j;
        if (r1 == null) goto L8;
        r1.onResume();
    L8:
        KtvRoomInteractViewModel r2 = this.d;
        if (r2 == null) goto L14;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L12:
        r2.onResume();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r1);
        Bq();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        boolean r1 = true;
        if (this.y == true) goto L7;
        this.y = true;
        this.z.getStatisticHelper().b(this.v);
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L7;
        r0.postDelayed(new y(this), vm2.h.A());
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r2 = this.k;
        if (r2 == null) goto L10;
        r2.onSeiResult(r10);
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r10.b;
        String r4 = null;
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L13;
        r3 = null;
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3;
        if (r5 == null) goto L43;
        if (r5.d() != 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L22;
        r5 = null;
    L22:
        if (r5 == null) goto L43;
        Float r7 = Float.valueOf(r5.c());
        if (r7.floatValue() < 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L30;
        r7 = null;
    L30:
        if (r7 == null) goto L43;
        float r9 = r7.floatValue();
        if ((!Intrinsics.areEqual(r9, this.w)) == false) goto L43;
        Float r11 = Float.valueOf(r9);
        this.w = r11;
        if (r11 == null) goto L43;
        float r12 = r11.floatValue();
        DragLinearLayout r13 = this.f;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L38:
        r13.setPosPercent(r12);
        StringBuilder r14 = new StringBuilder("update pos ");
        r14.append(r12);
        r14.append("---");
        DragLinearLayout r15 = this.f;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L41:
        r14.append(r15.getTranslationY());
        ALogger.i("updateSeiInteractRegion", r14.toString());
        goto L43
    L26:
        r8 = false;
        goto L27
    L18:
        r6 = false;
    L43:
        if (ne2.a.a() == true) goto L89;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r16 = r10.b;
        if ((r16 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L48;
    L67:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r17 = r10.b;
        if ((r17 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L74;
        if (ne2.a.d() == false) goto L72;
        com.bytedance.android.livesdk.ktvimpl.base.util.j r18 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r19 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b;
        r18.getClass();
        zq(this, false, Boolean.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.c(r19)), 2);
    L72:
        this.p = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).s();
        goto L89
    L74:
        if ((r17 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == false) goto L89;
        if (this.p != null) goto L89;
        String r20 = r17.a();
        KtvRoomInteractViewModel r21 = this.d;
        if (r21 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L81:
        if (r21 == null) goto L84;
        Object r22 = r21.getCurrentSingerUserId();
        if (r22 == null) goto L84;
    L86:
        if (Intrinsics.areEqual(r20, r22) == false) goto L89;
        zq(this, true, null, 6);
    L84:
        r22 = 0;
        goto L86
    L48:
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r16).s() == null) goto L67;
        String r23 = r10.b.a();
        Integer r24 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).s();
        KtvRoomInteractViewModel r25 = this.d;
        if (r25 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L52:
        if (r25 == null) goto L54;
        String r26 = r25.getCurrentSingerUserId();
    L56:
        if (Intrinsics.areEqual(r23, r26) == true) goto L58;
    L66:
        this.p = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).s();
        goto L89
    L58:
        if (ne2.a.d() == true) goto L66;
        if (r24 != null) goto L62;
    L64:
        boolean r27 = false;
    L65:
        com.bytedance.android.livesdk.ktvimpl.base.util.j r28 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r29 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b;
        r28.getClass();
        zq(this, r27, Boolean.valueOf(com.bytedance.android.livesdk.ktvimpl.base.util.j.c(r29)), 2);
        goto L66
    L62:
        if (r24.intValue() != 1) goto L64;
        r27 = true;
        goto L65
    L54:
        r26 = null;
    L89:
        if (this.j == null) goto L91;
        return;
    L91:
        if ((r10.b instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L93;
        return;
    L93:
        if (this.z.isCurrentUserIsSinger() == true) goto L198;
        KtvRoomInteractViewModel r30 = this.d;
        if (r30 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L98:
        if (r30 == null) goto L100;
        KtvDressSyncData r31 = r30.getKtvMidiSkinDress();
    L101:
        String r32 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).r();
        if (r31 == null) goto L106;
        MidiSkinDressInfo r33 = r31.getDressInfo();
        if (r33 == null) goto L106;
        String r34 = r33.getDressId();
    L108:
        if (Intrinsics.areEqual(r32, r34) == false) goto L158;
        long r35 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).j();
        if (r31 == null) goto L112;
        Long r36 = r31.getSongId();
    L113:
        if (r36 == null) goto L158;
        if (r35 != r36.longValue()) goto L158;
        String r37 = r10.b.a();
        if (r31 == null) goto L120;
        String r38 = r31.getSingerIdString();
    L122:
        if (Intrinsics.areEqual(r37, r38) == false) goto L158;
        KtvDressSyncData r39 = this.o;
        if (r39 == null) goto L128;
        MidiSkinDressInfo r40 = r39.getDressInfo();
        if (r40 == null) goto L128;
        String r41 = r40.getDressId();
    L129:
        if (r31 == null) goto L133;
        MidiSkinDressInfo r42 = r31.getDressInfo();
        if (r42 == null) goto L133;
        String r43 = r42.getDressId();
    L135:
        if ((!Intrinsics.areEqual(r41, r43)) == true) goto L145;
        KtvDressSyncData r44 = this.o;
        if (r44 == null) goto L139;
        Long r45 = r44.getSongId();
    L140:
        long r46 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).j();
        if (r45 == null) goto L145;
        if (r45.longValue() == r46) goto L158;
    L139:
        r45 = null;
    L145:
        MvLyricWidget r110 = this.n;
        if (r110 == null) goto L156;
        if (r31 == null) goto L153;
        MidiSkinDressInfo r47 = r31.getDressInfo();
        if (r47 == null) goto L153;
        MidiSkinMaterial r48 = r47.getMaterial();
        if (r48 == null) goto L153;
        r4 = r48.getLyricColorValue();
    L153:
        KtvMvLyricPresenter r111 = r110.k;
        if (r111 == null) goto L156;
        r111.h(r4);
    L156:
        this.o = r31;
        return;
    L133:
        r43 = null;
    L128:
        r41 = null;
        goto L129
    L120:
        r38 = null;
        goto L122
    L112:
        r36 = null;
    L158:
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).r(), BDLocationException.ERROR_TIMEOUT) == true) goto L162;
        if (((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b).r() == null) goto L162;
        return;
    L162:
        if (this.o == null) goto L196;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r112 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r10.b;
        com.bytedance.android.livesdk.ktvimpl.base.sei.q r49 = r112.w();
        if (r49 == null) goto L167;
        String r50 = r49.h();
        if (r50 == null) goto L167;
    L168:
        long r51 = r112.j();
        KtvDressSyncData r113 = this.o;
        if (r113 == null) goto L171;
        Long r114 = r113.getSongId();
    L172:
        if (r114 != null) goto L175;
    L183:
        r1 = false;
    L184:
        if (r1 == true) goto L197;
        MvLyricWidget r115 = this.n;
        if (r115 == null) goto L190;
        KtvMvLyricPresenter r116 = r115.k;
        if (r116 == null) goto L190;
        r116.h(null);
    L190:
        this.o = null;
        return;
    L197:
        return;
    L175:
        if (r51 != r114.longValue()) goto L183;
        KtvDressSyncData r117 = this.o;
        if (r117 == null) goto L179;
        String r118 = r117.getSingerIdString();
    L181:
        if (Intrinsics.areEqual(r50, r118) == false) goto L183;
    L179:
        r118 = null;
        goto L181
    L171:
        r114 = null;
    L167:
        r50 = r112.a();
        goto L168
    L196:
        return;
    L106:
        r34 = null;
        goto L108
    L100:
        r31 = null;
        goto L101
    }

    public final void yq(String r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        KtvContext r9 = this.z;
        KtvMusic r0 = null;
        if (r9 == null) goto L7;
        MutableLiveData<Boolean> r10 = r9.getRealOpenStateData();
        if (r10 == null) goto L7;
        Boolean r11 = (Boolean) r10.getValue();
    L8:
        boolean r1 = false;
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L11;
    L14:
        boolean r12 = true;
    L15:
        KtvRoomInteractViewModel r3 = this.d;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L18:
        if (r3 == null) goto L24;
        KtvRoomLyricsStateMachineConfig.d r4 = r3.getCurState();
        if (r4 == null) goto L24;
        MusicPanel r5 = r4.b();
        if (r5 == null) goto L24;
        String r6 = r5.q;
    L25:
        boolean r7 = !TextUtils.isEmpty(r6);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r13 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvRoomInteractViewModel r14 = this.d;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L28:
        KtvRoomLyricsStateMachineConfig.d r15 = r14.getCurState();
        if (r15 == null) goto L33;
        MusicPanel r16 = r15.b();
        if (r16 == null) goto L33;
        r0 = r16.a;
    L33:
        r13.getClass();
        boolean r2 = com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r0);
        if (r7 == false) goto L45;
        if (r12 == true) goto L45;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r17 = KtvRoomContext.a.a();
        if (r17 == null) goto L43;
        com.bytedance.live.datacontext.m<Boolean> r18 = r17.isMidiOpened();
        if (r18 == null) goto L43;
        if (((Boolean) r18.getValue()).booleanValue() != true) goto L43;
    L44:
        r1 = true;
    L43:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue()).booleanValue() == true) goto L44;
    L45:
        zq(this, r1, Boolean.valueOf(r2), 2);
        return;
    L24:
        r6 = null;
        goto L25
    L11:
        if (ne2.a.d() == true) goto L14;
        r12 = false;
    L7:
        r11 = null;
        goto L8
    }

    public KtvInteractElementWidget(KtvContext r2, sb0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        this.z = r2;
        this.A = r3;
        this.i = com.bytedance.android.live.core.utils.s1.f(5.0f);
        this.l = new CompositeDisposable();
        Object r4 = r2.getKtvCoreViewModel().getValue();
        if ((r4 instanceof BaseCoreViewModel) == true) goto L5;
        r4 = null;
    L5:
        this.m = (BaseCoreViewModel) r4;
        this.s = r2.getBizLcMager();
        this.v = new c();
        com.bytedance.android.live.core.utils.s1.h(2131107714);
        r2.getBizLcMager().a(this);
    }

    public static final void wq(KtvInteractElementWidget r2, float r3) {
        r2.getClass();
        ALogger.i("updateSeiInteractRegion", "fl：" + r3 + "---");
        r2.z.setKtvInteractRegionOffset(r3);
    }

    public static void zq(final KtvInteractElementWidget r6, boolean r7, Boolean r8, int r9) {
        boolean r1 = false;
        if ((r9 & 2) == 0) goto L5;
        final boolean r0 = true;
    L6:
        MvLyricWidget r3 = null;
        if ((r9 & 4) == 0) goto L9;
        r8 = null;
    L9:
        l r10 = r6.g;
        if (r10 == null) goto L15;
        if (r7 == false) goto L13;
        r10.setBackgroundResource(2131249307);
        goto L15
    L13:
        r10.setBackgroundResource(2131249308);
    L15:
        if (((Widget) r6).widgetCallback == null) goto L62;
        r6.enableSubWidgetManager();
        if (r7 == false) goto L57;
        if (r8 == null) goto L21;
        r1 = r8.booleanValue();
    L24:
        if (r1 == false) goto L57;
        if (r6.j == null) goto L28;
    L43:
        KtvRoomInteractViewModel r11 = r6.d;
        if (r11 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L46:
        Boolean r12 = (Boolean) r11.isMidiVisible().getValue();
        Boolean r13 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r12, r13)) == false) goto L59;
        KtvRoomInteractViewModel r14 = r6.d;
        if (r14 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L51:
        r14.isMidiVisible().setValue(r13);
        if (vm2.h.b() == false) goto L60;
        DragLinearLayout r15 = r6.f;
        if (r15 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L56:
        r15.a();
        return;
    L60:
        return;
    L59:
        return;
    L28:
        if (r6.h == null) goto L43;
        KtvContext r16 = r6.z;
        KtvRoomInteractViewModel r2 = r6.d;
        if (r2 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L32:
        Intrinsics.checkNotNull(r2);
        MvLyricWidget r4 = r6.n;
        if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyrics.b) == false) goto L36;
        r3 = r4;
    L36:
        KtvOpusMidiWidget r17 = new KtvOpusMidiWidget(r16, r2, r3, r6.t);
        r17.g = true;
        WidgetManager r18 = ((Widget) r6).subWidgetManager;
        if (r18 == null) goto L39;
        r18.load(r6.h, r17, r0);
    L39:
        MidiContext.Companion.c(r6.A.b().getAnchorAbMap());
        if (vm2.h.b() == false) goto L42;
        r17.h = new KtvInteractElementWidget$loadMvMidiWidget$$inlined$apply$lambda$1(r6, r0);
    L42:
        Unit r19 = Unit.INSTANCE;
        r6.j = r17;
        r17.j = r6.u;
        goto L43
    L21:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.a() == true) goto L24;
        r1 = true;
    L57:
        r6.Aq();
        return;
    L62:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
