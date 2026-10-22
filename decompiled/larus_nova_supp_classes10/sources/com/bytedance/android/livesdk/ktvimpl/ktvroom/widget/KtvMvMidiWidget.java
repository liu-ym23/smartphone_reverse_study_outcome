package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvStageViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvMvMidiWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Ltb0/a;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvMidiWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat, tb0.a {
    public final CompositeDisposable a;
    public KtvMidiStageViewModel b;
    public AbsKtvMidiView c;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a d;
    public final ViewModelStore e;
    public final CompositeDisposable f;
    public final KtvContext g;
    public final KtvRoomViewModel h;
    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.b i;
    public final View j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvMvMidiWidget a;

        public a(KtvMvMidiWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvMvMidiWidget r0 = this.a;
            MidiSkinDressInfo r3 = (MidiSkinDressInfo) sh6.c.b((sh6.b) r2);
            AbsKtvMidiView r1 = r0.c;
            if (r1 == null) goto L6;
            r1.y(r3);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvMvMidiWidget$onBizEnterRoom$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(KtvMvMidiWidget r8) {
            super(1, r8, KtvMvMidiWidget.class, "onPreviewCardShown", "onPreviewCardShown(Z)V", 0);
        }

        public final void invoke(boolean r2) {
            KtvMvMidiWidget r0 = (KtvMvMidiWidget) ((CallableReference) this).receiver;
            if (r2 == false) goto L7;
            AbsKtvMidiView r3 = r0.c;
            if (r3 == null) goto L9;
            r3.setVisibility(8);
            return;
        L9:
            return;
        L7:
            r0.getClass();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvMvMidiWidget$onCreate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C02531 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public C02531(KtvMvMidiWidget r8) {
            super(1, r8, KtvMvMidiWidget.class, "onListenerLyricPlayTimeCallback", "onListenerLyricPlayTimeCallback(Ljava/lang/Long;)V", 0);
        }

        public final void invoke(Long r9) {
            KtvMvMidiWidget r0 = (KtvMvMidiWidget) ((CallableReference) this).receiver;
            r0.getClass();
            if (r9 == null) goto L36;
            long r1 = r9.longValue();
            KtvRoomViewModel r3 = r0.h;
            KtvMidiStageViewModel r4 = null;
            if (r3 == null) goto L9;
            KtvRoomLyricsStateMachineConfig.d r5 = r3.getCurState();
            if (r5 == null) goto L9;
            MusicPanel r6 = r5.b();
        L10:
            KtvMidiStageViewModel r7 = r0.b;
            if ((r7 instanceof KtvMidiStageViewModel) == false) goto L14;
            r4 = r7;
        L14:
            if (r4 == null) goto L24;
            MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r8 = r4.m420getScoreInfo();
            if (r8 == null) goto L24;
            Pair r10 = (Pair) r8.getValue();
            if (r10 == null) goto L24;
            com.bytedance.android.live.ktv.common.midi.k r11 = (com.bytedance.android.live.ktv.common.midi.k) r10.getSecond();
            if (r11 == null) goto L24;
            AbsKtvMidiView r12 = r0.c;
            if (r12 == null) goto L24;
            r12.S5(r11, r9);
        L24:
            AbsKtvMidiView r13 = r0.c;
            if (r13 == null) goto L27;
            r13.R2(r1);
        L27:
            if (r6 == null) goto L37;
            KtvMusic r14 = r6.a;
            if (r14 == null) goto L38;
            KtvMusic.Companion.getClass();
            long r15 = KtvMusic.a.a(r14);
            if (r15 <= 0) goto L39;
            AbsKtvMidiView r2 = r0.c;
            if (r2 == null) goto L40;
            r2.U5(r15 * 1000, KtvMusic.a.b(r14, r1));
            return;
        L40:
            return;
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L9:
            r6 = null;
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Long) r1);
            return Unit.INSTANCE;
        }
    }

    public final int getLayoutId() {
        return 2131566511;
    }

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public final void onBizDestory() {
    }

    public final void onBizHide() {
    }

    public final void onBizLeaveRoom() {
    }

    public final void onBizShow() {
    }

    public final void onBizEnterRoom() {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r1 = r0.getPreviewViewModel();
        if (r1 == null) goto L15;
        KtvPreviewSongsViewModel r2 = (KtvPreviewSongsViewModel) r1.getValue();
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.getShowPreviewCard();
        if (r3 == null) goto L15;
        Observable r4 = r3.a();
        if (r4 == null) goto L15;
        ObservableSubscribeProxy r5 = (ObservableSubscribeProxy) r4.as(autoDispose());
        if (r5 == null) goto L15;
        final AnonymousClass1 r6 = new AnonymousClass1(this);
        r5.subscribe(new b(r6));
    L15:
        KtvMidiStageViewModel r7 = this.b;
        if (r7 == null) goto L21;
        AbsKtvMidiView r8 = this.c;
        if (r8 == null) goto L22;
        r8.T5(r7);
        return;
    L22:
        return;
    }

    public final void onDestroy() {
        this.a.clear();
        AbsKtvMidiView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        AbsKtvMidiView r1 = this.c;
        if (r1 == null) goto L8;
        r1.onDetach();
    L8:
        this.e.clear();
        if (this.f.isDisposed() == true) goto L11;
        this.f.dispose();
    L11:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
    }

    public final void wq() {
        KtvMidiStageViewModel r0 = this.b;
        Object r1 = null;
        if (r0 == null) goto L9;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r2 = r0.getCurState();
        if (r2 == null) goto L9;
        StateMachine.c.b r3 = (StateMachine.c.b) r2.getValue();
        if (r3 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r4 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
    L11:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L15;
        AbsKtvMidiView r5 = this.c;
        if (r5 == null) goto L15;
        r5.setVisibility(0);
    L15:
        ALogger.i("midi-check", "onSongFeedbackHide");
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r6 = KtvRoomContext.a.a();
        if (r6 == null) goto L24;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r7 = r6.getPreviewViewModel();
        if (r7 == null) goto L24;
        KtvPreviewSongsViewModel r8 = (KtvPreviewSongsViewModel) r7.getValue();
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r9 = r8.getNeedDelayToShow();
        if (r9 == null) goto L24;
        r9.setValue(Boolean.FALSE);
    L24:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r10 = this.d;
        if ((r10 instanceof View) == false) goto L28;
        r1 = r10;
    L28:
        View r11 = (View) r1;
        if (r11 == null) goto L31;
        r11.setVisibility(8);
    L31:
        View r12 = this.j;
        if (r12 == null) goto L34;
        r12.setBackgroundColor(0);
    L34:
        View r13 = this.j;
        if (r13 == null) goto L38;
        r13.setVisibility(8);
        return;
    L38:
        return;
    L9:
        r4 = null;
        goto L11
    }

    public final void onCreate() {
        super.onCreate();
        MidiContext.a r0 = MidiContext.Companion;
        sb0.b r1 = (sb0.b) this.g.getDataEntity().getValue();
        MusicPanel r2 = null;
        if (r1 == null) goto L7;
        sb0.e r3 = r1.b();
        if (r3 == null) goto L7;
        Map r4 = r3.getAnchorAbMap();
    L8:
        r0.getClass();
        if (MidiContext.a.e(r4) == false) goto L11;
        AbsKtvMidiView r5 = ((Widget) this).contentView.findViewById(2131376997);
    L12:
        this.c = r5;
        if ((r5 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L19;
        this.g.getStatisticHelper().b(r5);
        ViewGroup r6 = ((Widget) this).containerView;
        if (r6 == null) goto L19;
        r6.postDelayed(new l0(r5), vm2.h.A());
    L19:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L24;
        ViewStub r8 = (ViewStub) r7.findViewById(2131377081);
        if (r8 == null) goto L24;
        KeyEvent.Callback r9 = r8.inflate();
    L26:
        if ((r9 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) == true) goto L28;
        r9 = null;
    L28:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r10 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) r9;
        this.d = r10;
        if (r10 == null) goto L31;
        r10.setKtvRoomViewModel(this.h);
    L31:
        Pair r11 = com.bytedance.live.datacontext.d.a(KtvMvMidiWidget$initStageViewModel$pair$1.INSTANCE);
        MidiContext r12 = (MidiContext) r11.getFirst();
        this.f.add((Disposable) r11.getSecond());
        com.bytedance.live.datacontext.b.a(r12, MidiContext.class);
        KtvMidiStageViewModel r13 = (KtvMidiStageViewModel) new ViewModelProvider(this, new KtvStageViewModelFactory(this.g, this.h)).get(KtvMidiStageViewModel.class);
        this.b = r13;
        if (r13 == null) goto L34;
        r13.onCreate(this);
    L34:
        KtvMidiStageViewModel r14 = this.b;
        if (r14 == null) goto L39;
        MutableLiveData<List<cb0.c>> r15 = r14.getMidiData();
        if (r15 == null) goto L39;
        r15.observe(this, new g0(this));
    L39:
        KtvMidiStageViewModel r16 = this.b;
        if (r16 == null) goto L44;
        MutableLiveData<com.bytedance.android.live.ktv.common.model.api.g0> r17 = r16.getMidiConfig();
        if (r17 == null) goto L44;
        r17.observe(this, new h0(this));
    L44:
        KtvMidiStageViewModel r18 = this.b;
        if (r18 == null) goto L49;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r19 = r18.m420getScoreInfo();
        if (r19 == null) goto L49;
        r19.observe(this, new i0(this));
    L49:
        KtvMidiStageViewModel r20 = this.b;
        if (r20 == null) goto L54;
        MutableLiveData<Boolean> r21 = r20.getHideFeedback();
        if (r21 == null) goto L54;
        r21.observe(this, new j0(this));
    L54:
        KtvMidiStageViewModel r22 = this.b;
        if (r22 == null) goto L59;
        AbsKtvMidiView r23 = this.c;
        if (r23 == null) goto L59;
        r23.T5(r22);
    L59:
        KtvMidiStageViewModel r24 = this.b;
        if (r24 == null) goto L64;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r25 = r24.getCurState();
        if (r25 == null) goto L64;
        r25.observe(this, new k0(this));
    L64:
        KtvMidiStageViewModel r26 = this.b;
        if (r26 == null) goto L69;
        NextLiveData<Long> r27 = r26.getLyricProgress();
        if (r27 == null) goto L69;
        final KtvMvMidiWidget$initStageViewModel$7 r28 = new KtvMvMidiWidget$initStageViewModel$7(this);
        r27.observe(this, new m0(r28));
    L69:
        RxUtilKt.c(this.g.observeSingEndedFeedbackSei(new d0(this)), this.a);
        KtvRoomViewModel r29 = this.h;
        if (r29 == null) goto L74;
        MutableLiveData<oe2.f> r30 = r29.getStageUiState();
        if (r30 == null) goto L74;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r30, this, KtvMvMidiWidget$initStageViewModel$9.INSTANCE, new e0(this));
    L74:
        this.h.getSingerFollowState().observe(this, new f0(this));
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r31 = this.g.getKtvCoreViewModel();
        if (r31 == null) goto L81;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r32 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r31.getValue();
        if (r32 == null) goto L81;
        KtvRoomLyricsStateMachineConfig.d r33 = r32.getCurState();
        if (r33 == null) goto L81;
        r2 = r33.b();
    L81:
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> r34 = this.h.getFeedSeiModel();
        if (r2 == null) goto L84;
    L89:
        ALogger.i(bb0.b.b(), "handleEnterStage in singing, invoke class :KtvMvMidiWidget");
        AbsKtvMidiView r35 = this.c;
        if (r35 == null) goto L92;
        r35.setVisibility(0);
    L92:
        AbsKtvMidiView r36 = this.c;
        if (r36 == null) goto L95;
        r36.setVisibility(0);
    L95:
        AbsKtvMidiView r37 = this.c;
        if (r37 == null) goto L99;
        r37.R5();
    L99:
        if (r34.getValue() == null) goto L106;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r38 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r34.getValue();
        if (r38 == null) goto L106;
        KtvMidiStageViewModel r39 = this.b;
        if (r39 == null) goto L106;
        r39.initAudienceMidi(r38);
    L106:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.b r40 = this.i;
        if (r40 == null) goto L109;
        r40.a(new C02531(this));
    L109:
        com.bytedance.live.datacontext.n<MidiSkinDressInfo> r41 = this.g.getMidiSkinContext();
        if (r41 == null) goto L117;
        Observable r42 = r41.a();
        if (r42 == null) goto L118;
        Disposable r43 = r42.subscribe(new a(this));
        if (r43 == null) goto L119;
        RxUtilKt.c(r43, this.f);
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L84:
        if (r34.getValue() != null) goto L89;
        AbsKtvMidiView r44 = this.c;
        if (r44 == null) goto L106;
        r44.setVisibility(8);
    L24:
        r9 = null;
        goto L26
    L11:
        r5 = ((Widget) this).contentView.findViewById(2131376996);
    L7:
        r4 = null;
        goto L8
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        AbsKtvMidiView r0 = this.c;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final ViewModelStore tf() {
        return this.e;
    }

    public KtvMvMidiWidget(KtvContext r2, KtvRoomViewModel r3, MvLyricWidget r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "mRoomViewModel");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = new CompositeDisposable();
        this.e = new ViewModelStore();
        this.f = new CompositeDisposable();
    }
}
