package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvStageViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.MvLyricWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvMidiSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage.KtvMidiStageViewModel;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvOpusMidiWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Ltb0/a;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvOpusMidiWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat, tb0.a {
    public final CompositeDisposable a;
    public KtvMidiStageViewModel b;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b c;
    public com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a d;
    public final ViewModelStore e;
    public final CompositeDisposable f;
    public boolean g;
    public Function0<Unit> h;
    public final boolean i;
    public boolean j;
    public final x0 k;
    public final KtvContext l;
    public final KtvRoomViewModel m;
    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.b n;
    public final View o;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvOpusMidiWidget a;

        public a(KtvOpusMidiWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvOpusMidiWidget r0 = this.a;
            MidiSkinDressInfo r3 = (MidiSkinDressInfo) sh6.c.b((sh6.b) r2);
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r1 = r0.c;
            if (r1 == null) goto L6;
            r1.y(r3);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvOpusMidiWidget$onBizEnterRoom$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(KtvOpusMidiWidget r8) {
            super(1, r8, KtvOpusMidiWidget.class, "onPreviewCardShown", "onPreviewCardShown(Z)V", 0);
        }

        public final void invoke(boolean r3) {
            KtvOpusMidiWidget r0 = (KtvOpusMidiWidget) ((CallableReference) this).receiver;
            if (r3 == false) goto L15;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r4 = r0.c;
            if (r4 == null) goto L9;
            View r5 = r4.asView();
            if (r5 == null) goto L9;
            r5.setVisibility(8);
        L9:
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r6 = r0.c;
            if ((r6 instanceof KtvMidiSurfaceView) == true) goto L12;
            r6 = null;
        L12:
            KtvMidiSurfaceView r7 = (KtvMidiSurfaceView) r6;
            if (r7 == null) goto L17;
            r7.setBusinessVisible(8);
            return;
        L17:
            return;
        L15:
            r0.getClass();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvOpusMidiWidget$onCreate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C02541 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public C02541(KtvOpusMidiWidget r8) {
            super(1, r8, KtvOpusMidiWidget.class, "onListenerLyricPlayTimeCallback", "onListenerLyricPlayTimeCallback(Ljava/lang/Long;)V", 0);
        }

        public final void invoke(Long r7) {
            KtvOpusMidiWidget r0 = (KtvOpusMidiWidget) ((CallableReference) this).receiver;
            r0.getClass();
            if (r7 == null) goto L26;
            long r1 = r7.longValue();
            KtvRoomViewModel r3 = r0.m;
            if (r3 == null) goto L9;
            KtvRoomLyricsStateMachineConfig.d r4 = r3.getCurState();
            if (r4 == null) goto L9;
            r4.b();
        L9:
            KtvMidiStageViewModel r5 = r0.b;
            if ((r5 instanceof KtvMidiStageViewModel) == true) goto L12;
            r5 = null;
        L12:
            if (r5 == null) goto L22;
            MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r6 = r5.m420getScoreInfo();
            if (r6 == null) goto L22;
            Pair r8 = (Pair) r6.getValue();
            if (r8 == null) goto L22;
            com.bytedance.android.live.ktv.common.midi.k r9 = (com.bytedance.android.live.ktv.common.midi.k) r8.getSecond();
            if (r9 == null) goto L22;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r10 = r0.c;
            if (r10 == null) goto L22;
            r10.F9(r9, r7, false);
        L22:
            com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r11 = r0.c;
            if (r11 == null) goto L27;
            r11.R2(r1);
            return;
        L27:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Long) r1);
            return Unit.INSTANCE;
        }
    }

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public final void onBizDestory() {
    }

    public final void onBizLeaveRoom() {
    }

    public final int getLayoutId() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 2131566518;
    L5:
        if (KtvSettingHelper.z() == true) goto L7;
        return 2131566518;
    L7:
        if (((Boolean) KtvSettingHelper.N0.getValue()).booleanValue() == false) goto L13;
        return 2131566519;
    L13:
        return 2131566518;
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
        MidiContext r7 = MidiContext.Companion.getContext();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r8 = null;
        if (r7 == null) goto L24;
        sb0.b r9 = (sb0.b) this.l.getDataEntity().getValue();
        if (r9 == null) goto L22;
        sb0.e r10 = r9.b();
        if (r10 == null) goto L22;
        Map r11 = r10.getAnchorAbMap();
    L23:
        r7.setAnchorAbMap(r11);
    L22:
        r11 = null;
    L24:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r12 = this.c;
        boolean r13 = r12 instanceof KtvMidiSurfaceView;
        if (r13 == true) goto L27;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r14 = null;
    L28:
        KtvMidiSurfaceView r15 = (KtvMidiSurfaceView) r14;
        if (r15 == null) goto L31;
        ((ContinuousSurfaceAdapterView) r15).a = true;
    L31:
        if (r13 == true) goto L33;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r16 = null;
    L34:
        KtvMidiSurfaceView r17 = (KtvMidiSurfaceView) r16;
        if (r17 == null) goto L37;
        ((ContinuousSurfaceAdapterView) r17).b = false;
    L37:
        if (r13 == false) goto L40;
        r8 = r12;
    L40:
        KtvMidiSurfaceView r18 = (KtvMidiSurfaceView) r8;
        if (r18 == null) goto L44;
        r18.attachFromWindow("onBizEnterKtvRoom");
        return;
    L44:
        return;
    L33:
        r16 = r12;
        goto L34
    L27:
        r14 = r12;
        goto L28
    }

    public final void onBizHide() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r0 = this.c;
        if ((r0 instanceof KtvMidiSurfaceView) == true) goto L5;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r1 = null;
    L6:
        KtvMidiSurfaceView r2 = (KtvMidiSurfaceView) r1;
        if (r2 == null) goto L10;
        ((ContinuousSurfaceAdapterView) r2).a = false;
    L10:
        if ((r0 instanceof KtvMidiSurfaceView) == true) goto L12;
        r0 = null;
    L12:
        KtvMidiSurfaceView r3 = (KtvMidiSurfaceView) r0;
        if (r3 == null) goto L16;
        r3.detachFromWindow("onBizHide");
        return;
    L16:
        return;
    L5:
        r1 = r0;
        goto L6
    }

    public final void onBizShow() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r0 = this.c;
        if ((r0 instanceof KtvMidiSurfaceView) == true) goto L5;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r1 = null;
    L6:
        KtvMidiSurfaceView r2 = (KtvMidiSurfaceView) r1;
        if (r2 == null) goto L10;
        ((ContinuousSurfaceAdapterView) r2).a = true;
    L10:
        if ((r0 instanceof KtvMidiSurfaceView) == true) goto L12;
        r0 = null;
    L12:
        KtvMidiSurfaceView r3 = (KtvMidiSurfaceView) r0;
        if (r3 == null) goto L16;
        r3.attachFromWindow("onBizShow");
        return;
    L16:
        return;
    L5:
        r1 = r0;
        goto L6
    }

    public final void onDestroy() {
        this.a.clear();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r0 = this.c;
        if (r0 == null) goto L7;
        View r1 = r0.asView();
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r2 = this.c;
        if ((r2 instanceof KtvMidiSurfaceView) == true) goto L10;
        r2 = null;
    L10:
        KtvMidiSurfaceView r3 = (KtvMidiSurfaceView) r2;
        if (r3 == null) goto L13;
        r3.setBusinessVisible(8);
    L13:
        View r4 = this.o;
        if ((r4 instanceof ViewGroup) == true) goto L16;
        r4 = null;
    L16:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L19;
        r5.removeAllViews();
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.b r6 = this.n;
        if (r6 == null) goto L22;
        r6.a(null);
    L22:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r7 = this.c;
        if (r7 == null) goto L25;
        r7.onDetach();
    L25:
        this.e.clear();
        if (this.f.isDisposed() == true) goto L28;
        this.f.dispose();
    L28:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
    }

    public final void wq() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r0 = this.c;
        if (r0 == null) goto L7;
        View r1 = r0.asView();
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r2 = this.c;
        if ((r2 instanceof KtvMidiSurfaceView) == true) goto L10;
        r2 = null;
    L10:
        KtvMidiSurfaceView r3 = (KtvMidiSurfaceView) r2;
        if (r3 == null) goto L14;
        r3.setBusinessVisible(0);
        return;
    }

    public final void xq() {
        KtvMidiStageViewModel r0 = this.b;
        Object r1 = null;
        if (r0 == null) goto L9;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r2 = r0.getCurState();
        if (r2 == null) goto L9;
        StateMachine.c.b r3 = (StateMachine.c.b) r2.getValue();
        if (r3 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r4 = (KtvRoomLyricsStateMachineConfig.d) r3.c;
    L11:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L23;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r5 = this.c;
        if (r5 == null) goto L17;
        View r6 = r5.asView();
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r7 = this.c;
        if ((r7 instanceof KtvMidiSurfaceView) == true) goto L20;
        r7 = null;
    L20:
        KtvMidiSurfaceView r8 = (KtvMidiSurfaceView) r7;
        if (r8 == null) goto L23;
        r8.setBusinessVisible(0);
    L23:
        ALogger.i("midi-check", "onSongFeedbackHide");
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r9 = KtvRoomContext.a.a();
        if (r9 == null) goto L32;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r10 = r9.getPreviewViewModel();
        if (r10 == null) goto L32;
        KtvPreviewSongsViewModel r11 = (KtvPreviewSongsViewModel) r10.getValue();
        if (r11 == null) goto L32;
        com.bytedance.live.datacontext.m<Boolean> r12 = r11.getNeedDelayToShow();
        if (r12 == null) goto L32;
        r12.setValue(Boolean.FALSE);
    L32:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r13 = this.d;
        if ((r13 instanceof View) == false) goto L36;
        r1 = r13;
    L36:
        View r14 = (View) r1;
        if (r14 == null) goto L39;
        r14.setVisibility(8);
    L39:
        View r15 = this.o;
        if (r15 == null) goto L42;
        r15.setBackgroundColor(0);
    L42:
        View r16 = this.o;
        if (r16 == null) goto L45;
        r16.setVisibility(8);
    L45:
        Function0<Unit> r17 = this.h;
        if (r17 == null) goto L49;
        Unit r18 = (Unit) r17.invoke();
        return;
    L49:
        return;
    L9:
        r4 = null;
        goto L11
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r0 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b) ((Widget) this).contentView.findViewById(2131376996);
        this.c = r0;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r2 = null;
        if ((r0 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L9;
        this.l.getStatisticHelper().b(r0);
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L9;
        r1.postDelayed(new v0(r0), vm2.h.A());
    L9:
        ReadOnlyProperty r3 = vm2.h.W3;
        KProperty[] r4 = vm2.h.a;
        if (((Boolean) r3.getValue(null, r4[255(0xff, float:3.57E-43)])).booleanValue() == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r5 = this.c;
        if (r5 == null) goto L14;
        r5.setPerformStrategy(new w0());
    L14:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r6 = this.c;
        if ((r6 instanceof KtvMidiSurfaceView) == true) goto L17;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r7 = null;
    L18:
        KtvMidiSurfaceView r8 = (KtvMidiSurfaceView) r7;
        if (r8 != null) goto L21;
    L24:
        if (r6 == null) goto L27;
        r6.qc(this.k);
    L27:
        if (this.g == false) goto L40;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r9 = this.c;
        if (r9 == null) goto L33;
        View r10 = r9.asView();
        if (r10 == null) goto L33;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L35:
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        r11 = null;
    L37:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12 == null) goto L40;
        r12.bottomMargin = 0;
    L33:
        r11 = null;
    L40:
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L45;
        ViewStub r14 = (ViewStub) r13.findViewById(2131377081);
        if (r14 == null) goto L45;
        KeyEvent.Callback r15 = r14.inflate();
    L47:
        if ((r15 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) == true) goto L49;
        r15 = null;
    L49:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r16 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a) r15;
        this.d = r16;
        if (r16 == null) goto L53;
        r16.setKtvRoomViewModel(this.m);
    L53:
        if (((Boolean) vm2.h.V3.getValue(null, r4[254(0xfe, float:3.56E-43)])).booleanValue() == false) goto L70;
        Object r17 = this.d;
        if ((r17 instanceof ViewGroup) == true) goto L57;
        r17 = null;
    L57:
        ViewGroup r18 = (ViewGroup) r17;
        if (r18 == null) goto L70;
        View r19 = this.o;
        if ((r19 instanceof ViewGroup) == true) goto L62;
        r19 = null;
    L62:
        ViewGroup r20 = (ViewGroup) r19;
        if (r20 == null) goto L70;
        ViewGroup.LayoutParams r21 = r18.getLayoutParams();
        ViewParent r22 = r18.getParent();
        if ((r22 instanceof ViewGroup) == true) goto L67;
        r22 = null;
    L67:
        ViewGroup r23 = (ViewGroup) r22;
        if (r23 == null) goto L70;
        r23.removeView(r18);
        r20.addView(r18, r21);
    L70:
        ((Widget) this).contentView.setBackgroundColor(com.bytedance.android.live.core.utils.s1.h(2131107714));
        Pair r24 = com.bytedance.live.datacontext.d.a(KtvOpusMidiWidget$initStageViewModel$pair$1.INSTANCE);
        MidiContext r25 = (MidiContext) r24.getFirst();
        this.f.add((Disposable) r24.getSecond());
        com.bytedance.live.datacontext.b.a(r25, MidiContext.class);
        sb0.b r26 = (sb0.b) this.l.getDataEntity().getValue();
        if (r26 == null) goto L75;
        sb0.e r27 = r26.b();
        if (r27 == null) goto L75;
        Map r28 = r27.getAnchorAbMap();
    L76:
        r25.setAnchorAbMap(r28);
        int r29 = ke2.c.a;
        int r30 = com.bytedance.android.live.liveinteract.plantform.permission.checker.r.d;
        if (com.bytedance.android.live.liveinteract.plantform.permission.checker.r.a.a() == false) goto L79;
        boolean r31 = false;
    L80:
        if (r31 == true) goto L82;
        ke2.c.b(null);
        KtvMidiStageViewModel r32 = null;
    L83:
        this.b = r32;
        if (r32 == null) goto L86;
        r32.onCreate(this);
    L86:
        KtvMidiStageViewModel r33 = this.b;
        if (r33 == null) goto L91;
        MutableLiveData<List<cb0.c>> r34 = r33.getMidiData();
        if (r34 == null) goto L91;
        r34.observe(this, new q0(this));
    L91:
        KtvMidiStageViewModel r35 = this.b;
        if (r35 == null) goto L96;
        MutableLiveData<com.bytedance.android.live.ktv.common.model.api.g0> r36 = r35.getMidiConfig();
        if (r36 == null) goto L96;
        r36.observe(this, new r0(this));
    L96:
        KtvMidiStageViewModel r37 = this.b;
        if (r37 == null) goto L101;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r38 = r37.m420getScoreInfo();
        if (r38 == null) goto L101;
        r38.observe(this, new s0(this));
    L101:
        KtvMidiStageViewModel r39 = this.b;
        if (r39 == null) goto L106;
        MutableLiveData<Boolean> r40 = r39.getHideFeedback();
        if (r40 == null) goto L106;
        r40.observe(this, new t0(this));
    L106:
        KtvMidiStageViewModel r41 = this.b;
        if (r41 == null) goto L111;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r42 = this.c;
        if (r42 == null) goto L111;
        r42.Gk(r41, null);
    L111:
        KtvMidiStageViewModel r43 = this.b;
        if (r43 == null) goto L116;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r44 = r43.getCurState();
        if (r44 == null) goto L116;
        r44.observe(this, new u0(this));
    L116:
        KtvMidiStageViewModel r45 = this.b;
        if (r45 == null) goto L121;
        NextLiveData<Long> r46 = r45.getLyricProgress();
        if (r46 == null) goto L121;
        final KtvOpusMidiWidget$initStageViewModel$7 r47 = new KtvOpusMidiWidget$initStageViewModel$7(this);
        r46.observe(this, new z0(r47));
    L121:
        RxUtilKt.c(this.l.observeSingEndedFeedbackSei(new n0(this)), this.a);
        KtvRoomViewModel r48 = this.m;
        if (r48 == null) goto L126;
        MutableLiveData<oe2.f> r49 = r48.getStageUiState();
        if (r49 == null) goto L126;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r49, this, KtvOpusMidiWidget$initStageViewModel$9.INSTANCE, new o0(this));
    L126:
        this.m.getSingerFollowState().observe(this, new p0(this));
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r50 = this.l.getKtvCoreViewModel();
        if (r50 == null) goto L133;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r51 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r50.getValue();
        if (r51 == null) goto L133;
        KtvRoomLyricsStateMachineConfig.d r52 = r51.getCurState();
        if (r52 == null) goto L133;
        MusicPanel r53 = r52.b();
    L134:
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> r54 = this.m.getFeedSeiModel();
        if (r53 == null) goto L137;
    L151:
        ALogger.i(bb0.b.b(), "handleEnterStage in singing, invoke class :KtvOpusMidiWidget");
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r55 = this.c;
        if (r55 == null) goto L156;
        View r56 = r55.asView();
        if (r56 == null) goto L156;
        r56.setVisibility(0);
    L156:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r57 = this.c;
        if ((r57 instanceof KtvMidiSurfaceView) == false) goto L160;
        r2 = r57;
    L160:
        KtvMidiSurfaceView r58 = (KtvMidiSurfaceView) r2;
        if (r58 == null) goto L163;
        r58.setBusinessVisible(0);
    L163:
        wq();
        if (r54.getValue() == null) goto L171;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r59 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r54.getValue();
        if (r59 == null) goto L171;
        KtvMidiStageViewModel r60 = this.b;
        if (r60 == null) goto L171;
        r60.initAudienceMidi(r59);
    L171:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.b r61 = this.n;
        if (r61 == null) goto L174;
        r61.a(new C02541(this));
    L174:
        com.bytedance.live.datacontext.n<MidiSkinDressInfo> r62 = this.l.getMidiSkinContext();
        if (r62 == null) goto L181;
        Observable r63 = r62.a();
        if (r63 == null) goto L181;
        Disposable r64 = r63.subscribe(new a(this));
        if (r64 == null) goto L181;
        RxUtilKt.c(r64, this.f);
    L181:
        Function0<Unit> r65 = this.h;
        if (r65 == null) goto L184;
        Unit r66 = (Unit) r65.invoke();
    L184:
        com.bytedance.android.live.ktv.common.util.e r67 = this.l.getBizLcMager();
        if (r67 == null) goto L188;
        r67.a(this);
        return;
    L188:
        return;
    L137:
        if (r54.getValue() != null) goto L151;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r68 = this.c;
        if (r68 == null) goto L144;
        View r69 = r68.asView();
        if (r69 == null) goto L144;
        r69.setVisibility(8);
    L144:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r70 = this.c;
        if ((r70 instanceof KtvMidiSurfaceView) == false) goto L148;
        r2 = r70;
    L148:
        KtvMidiSurfaceView r71 = (KtvMidiSurfaceView) r2;
        if (r71 == null) goto L171;
        r71.setBusinessVisible(8);
    L133:
        r53 = null;
        goto L134
    L82:
        r32 = (KtvMidiStageViewModel) new ViewModelProvider(this, new KtvStageViewModelFactory(this.l, this.m)).get(KtvMidiStageViewModel.class);
        goto L83
    L79:
        r31 = NewPluginType.LiveResource.isInstalled();
    L75:
        r28 = null;
    L45:
        r15 = null;
        goto L47
    L21:
        if (this.j == false) goto L23;
        ((ContinuousSurfaceAdapterView) r8).a = true;
        goto L24
    L23:
        ((ContinuousSurfaceAdapterView) r8).a = false;
        goto L24
    L17:
        r7 = r6;
        goto L18
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r0 = this.c;
        if ((r0 instanceof KtvMidiSurfaceView) == true) goto L5;
        r0 = null;
    L5:
        KtvMidiSurfaceView r1 = (KtvMidiSurfaceView) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        if (((ContinuousSurfaceAdapterView) r1).a == true) goto L10;
        return;
    L10:
        if (((Boolean) KtvSettingHelper.E0.getValue()).booleanValue() == true) goto L12;
    L13:
        r1.attachFromWindow("widget resume");
        return;
    L12:
        if (((ContinuousSurfaceAdapterView) r1).b == false) goto L13;
    }

    public final ViewModelStore tf() {
        return this.e;
    }

    public KtvOpusMidiWidget(KtvContext r2, KtvRoomInteractViewModel r3, MvLyricWidget r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "mRoomViewModel");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.a = new CompositeDisposable();
        this.e = new ViewModelStore();
        this.f = new CompositeDisposable();
        this.i = Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.j(this).isAnchor(), Boolean.TRUE);
        this.k = new x0();
    }
}
