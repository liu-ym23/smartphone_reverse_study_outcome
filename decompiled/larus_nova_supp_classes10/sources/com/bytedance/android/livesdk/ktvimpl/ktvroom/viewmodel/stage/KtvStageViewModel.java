package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.stage;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.i;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.o;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u00018\b\u0016\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001HB\u0017\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J*\u0010\u000b\u001a\u00020\u00032 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J*\u0010\u0017\u001a\u00020\u00032 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tH\u0014J\u001a\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\rH\u0014J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\rH\u0014J*\u0010\"\u001a\u00020\u00032 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\tH\u0014J\b\u0010#\u001a\u00020\u0003H\u0014J\b\u0010$\u001a\u00020\u0003H\u0014J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0003H\u0014R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R)\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0,0'8\u0006¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010+R3\u0010/\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0'8\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010+R$\u00102\u001a\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0017\u0010<\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010A\u001a\u00020@8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006I"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvStageViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "observeCoreViewModel", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "valid", "handleState", "curstate", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "data", "handleStateCoreData", "", "progress", "handleSingProgress", "(Ljava/lang/Long;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "onCreate", "onIdle", "", "isSinger", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "onSingFinish", "from", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$f;", "to", "onSinging", "ktvCoreDataModel", "onPreparing", "onPaused", "onClosed", "onDetach", "onCleared", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "lyricProgress", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getLyricProgress", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lkotlin/Pair;", "coreData", "getCoreData", "curState", "getCurState", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "coreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "getCoreViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "setCoreViewModel", "(Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;)V", "com/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvStageViewModel$b", "mCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/stage/KtvStageViewModel$b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "vm", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "getVm", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvStageViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "KtvStageViewModel";
    private final NextLiveData<Pair<KtvRoomLyricsStateMachineConfig.d, d>> coreData;
    private BaseCoreViewModel coreViewModel;
    private final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> curState;
    private final KtvContext ktvContext;
    private final NextLiveData<Long> lyricProgress;
    private final b mCoreListener;
    private final KtvRoomViewModel vm;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvStageViewModel a;

        public b(KtvStageViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "valid");
            KtvStageViewModel.access$handleState(this.a, r2);
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void e(long r2) {
            KtvStageViewModel.access$handleSingProgress(this.a, Long.valueOf(r2));
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void d(KtvRoomLyricsStateMachineConfig.d r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "curstate");
            Intrinsics.checkNotNullParameter(r3, "ktvCoreDataModel");
            KtvStageViewModel.access$handleStateCoreData(this.a, r2, r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvStageViewModel a;
        public final /* synthetic */ LifecycleOwner b;

        public c(KtvStageViewModel r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            this.a.setCoreViewModel((BaseCoreViewModel) sh6.c.b((sh6.b) r2));
            KtvStageViewModel.access$observeCoreViewModel(this.a);
        }
    }

    static {
        Companion = new a();
    }

    public void onClosed() {
    }

    public void onDetach() {
    }

    public void onPaused() {
    }

    public void onPreparing(d r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvCoreDataModel");
    }

    public void onSinging(KtvRoomLyricsStateMachineConfig.d r2, KtvRoomLyricsStateMachineConfig.d.f r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
    }

    public void onSinging(d r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvCoreDataModel");
    }

    private final void observeCoreViewModel() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L6;
        r0.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_DATA_MODEL, BaseCoreViewModel.CORE_TAG_PROGRESS}), this.mCoreListener, false);
        return;
    }

    public void onCleared() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L6;
        r0.unregisterKtvCoreListener(this.mCoreListener);
        return;
    }

    public final NextLiveData<Pair<KtvRoomLyricsStateMachineConfig.d, d>> getCoreData() {
        return this.coreData;
    }

    public final BaseCoreViewModel getCoreViewModel() {
        return this.coreViewModel;
    }

    public final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> getCurState() {
        return this.curState;
    }

    public final KtvContext getKtvContext() {
        return this.ktvContext;
    }

    public final NextLiveData<Long> getLyricProgress() {
        return this.lyricProgress;
    }

    public final KtvRoomViewModel getVm() {
        return this.vm;
    }

    public static final /* synthetic */ void access$observeCoreViewModel(KtvStageViewModel r0) {
        r0.observeCoreViewModel();
    }

    private final void handleSingProgress(Long r2) {
        if (this.ktvContext.isCurrentUserIsSinger() == false) goto L6;
        this.lyricProgress.setValue(r2);
        return;
    }

    private final void handleState(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r5.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L8;
        this.curState.setValue(r5);
        onIdle(r5);
        return;
    L8:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L11;
        this.curState.setValue(r5);
        onPreparing(r5);
        return;
    L11:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L14;
        this.curState.setValue(r5);
        onPaused();
        return;
    L14:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L40;
        Object r1 = r5.a;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L34;
        if (r1 == null) goto L33;
        OrderInfo r2 = ((KtvRoomLyricsStateMachineConfig.d.f) r1).b.a.getOrderInfo();
        String r3 = null;
        if (r2 == null) goto L23;
        InteractiveSongUserInfo r4 = r2.getTopUser();
        if (r4 == null) goto L23;
        String r6 = r4.getIdString();
    L24:
        OrderInfo r7 = ((KtvRoomLyricsStateMachineConfig.d.f) r0).b.a.getOrderInfo();
        if (r7 == null) goto L30;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L30;
        r3 = r8.getIdString();
    L30:
        if ((!Intrinsics.areEqual(r6, r3)) == true) goto L34;
        return;
    L23:
        r6 = null;
        goto L24
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L34:
        this.curState.setValue(r5);
        KtvRoomLyricsStateMachineConfig.d r9 = (KtvRoomLyricsStateMachineConfig.d) r5.a;
        Object r10 = r5.c;
        if (r10 == null) goto L38;
        onSinging(r9, (KtvRoomLyricsStateMachineConfig.d.f) r10);
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L40:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L48;
        this.curState.setValue(r5);
        onClosed();
        return;
    }

    public void onCreate(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        KtvContext r0 = this.ktvContext;
        if (r0 == null) goto L7;
        n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
    L8:
        this.coreViewModel = (BaseCoreViewModel) r2;
        observeCoreViewModel();
        ((ObservableSubscribeProxy) this.ktvContext.getKtvCoreViewModel().a().as(AutoDispose.bind(r3))).subscribe(new c(this, r3));
        BaseCoreViewModel r4 = this.coreViewModel;
        if (r4 == null) goto L12;
        r4.setStateMachineFinishCB(new AnonymousClass2(this));
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public void onIdle(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r8 = (KtvRoomLyricsStateMachineConfig.d) r7.a;
    L6:
        StringBuilder r1 = new StringBuilder("onIdle: from is singing? : ");
        boolean r2 = r8 instanceof KtvRoomLyricsStateMachineConfig.d.f;
        r1.append(r2);
        String r3 = r1.toString();
        ALogger.i(bb0.b.b(), "KtvStageViewModel :" + r3 + ", invoke class :KtvStageViewModel");
        if (j.i() == false) goto L13;
        pd2.d r4 = pd2.d.n;
        if (r8 == null) goto L11;
        MusicPanel r5 = r8.b();
    L12:
        r4.getClass();
        pd2.d.I(r5, "Ktv  onIdle: from is singing? : " + r2);
        goto L13
    L11:
        r5 = null;
    L13:
        if (r2 == false) goto L36;
        MusicPanel r6 = o.c((KtvRoomLyricsStateMachineConfig.d.f) r8);
        if (j.i() == false) goto L34;
        pd2.d r9 = pd2.d.n;
        StringBuilder r10 = new StringBuilder("Ktv  onIdle: cur musicPanel singerId: ");
        MusicPanel r11 = r8.b();
        if (r11 == null) goto L23;
        OrderInfo r12 = r11.d();
        if (r12 == null) goto L23;
        InteractiveSongUserInfo r13 = r12.getTopUser();
        if (r13 == null) goto L23;
        String r14 = r13.getIdString();
    L24:
        r10.append(r14);
        r10.append("   sei senderId: ");
        k r15 = ((KtvRoomLyricsStateMachineConfig.d.f) r8).c;
        if (r15 == null) goto L27;
        String r16 = r15.A();
    L28:
        r10.append(r16);
        r10.append("    getMidiScoreSeiRealMusicPanel musicSingerid: ");
        OrderInfo r17 = r6.d();
        if (r17 == null) goto L33;
        InteractiveSongUserInfo r18 = r17.getTopUser();
        if (r18 == null) goto L33;
        r0 = r18.getIdString();
    L33:
        r10.append(r0);
        String r19 = r10.toString();
        r9.getClass();
        pd2.d.I(r6, r19);
        goto L34
    L27:
        r16 = null;
    L23:
        r14 = null;
    L34:
        onSingFinish(KtvUtilsKt.w(r6.a), r6);
        return;
    L36:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public void onPreparing(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r7 = (KtvRoomLyricsStateMachineConfig.d) r6.a;
    L7:
        if (j.i() == false) goto L14;
        pd2.d r1 = pd2.d.n;
        if (r7 == null) goto L11;
        MusicPanel r2 = r7.b();
    L12:
        r1.getClass();
        pd2.d.I(r2, "Ktv onPreparing: from is singing? : " + (r7 instanceof KtvRoomLyricsStateMachineConfig.d.f));
        goto L14
    L11:
        r2 = null;
    L14:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L37;
        MusicPanel r3 = o.c((KtvRoomLyricsStateMachineConfig.d.f) r7);
        if (j.i() == false) goto L35;
        pd2.d r4 = pd2.d.n;
        StringBuilder r5 = new StringBuilder("Ktv onPreparing: cur musicPancel singerId: ");
        MusicPanel r8 = r7.b();
        if (r8 == null) goto L24;
        OrderInfo r9 = r8.d();
        if (r9 == null) goto L24;
        InteractiveSongUserInfo r10 = r9.getTopUser();
        if (r10 == null) goto L24;
        String r11 = r10.getIdString();
    L25:
        r5.append(r11);
        r5.append("   sei senderId: ");
        k r12 = ((KtvRoomLyricsStateMachineConfig.d.f) r7).c;
        if (r12 == null) goto L28;
        String r13 = r12.A();
    L29:
        r5.append(r13);
        r5.append("   getMidiScoreSeiRealMusicPanel musicSingerid: ");
        OrderInfo r14 = r3.d();
        if (r14 == null) goto L34;
        InteractiveSongUserInfo r15 = r14.getTopUser();
        if (r15 == null) goto L34;
        r0 = r15.getIdString();
    L34:
        r5.append(r0);
        String r16 = r5.toString();
        r4.getClass();
        pd2.d.I(r3, r16);
        goto L35
    L28:
        r13 = null;
    L24:
        r11 = null;
    L35:
        onSingFinish(KtvUtilsKt.w(r3.a), r3);
        return;
    L37:
        return;
    L5:
        r7 = null;
        goto L7
    }

    public final void setCoreViewModel(BaseCoreViewModel r1) {
        this.coreViewModel = r1;
    }

    public KtvStageViewModel(KtvContext r2, KtvRoomViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "vm");
        this.ktvContext = r2;
        this.vm = r3;
        this.lyricProgress = new NextLiveData();
        this.coreData = new NextLiveData();
        this.curState = new NextLiveData();
        this.mCoreListener = new b(this);
    }

    public static final /* synthetic */ void access$handleSingProgress(KtvStageViewModel r0, Long r1) {
        r0.handleSingProgress(r1);
    }

    public static final /* synthetic */ void access$handleState(KtvStageViewModel r0, StateMachine.c.b r1) {
        r0.handleState(r1);
    }

    private final void handleStateCoreData(KtvRoomLyricsStateMachineConfig.d r3, d r4) {
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        onPreparing(r4);
    L8:
        this.coreData.setValue(new Pair(r3, r4));
        return;
    L6:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L8;
        onSinging(r4);
        goto L8
    }

    public void onSingFinish(boolean r4, MusicPanel r5) {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r6 = KSongTuningPanelHelperKt.d();
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r0 = null;
        if ((r6 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L5;
        r6 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r7 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r6;
        if (r7 == null) goto L8;
        long r8 = r7.z();
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r1 = KSongTuningPanelHelperKt.d();
        if ((r1 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == false) goto L13;
        r0 = r1;
    L13:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r2 = r0;
        if (r2 == null) goto L17;
        String r3 = r2.T();
        if (r3 == null) goto L17;
    L18:
        KtvContext r9 = this.ktvContext;
        if (r9 == null) goto L26;
        n<i> r10 = r9.getKtvCoreController();
        if (r10 != null) goto L23;
        return;
    L23:
        if (((i) r10.getValue()) == null) goto L28;
        Long r11 = KtvLoggerHelper.a;
        KtvLoggerHelper.i0(System.currentTimeMillis() - r8, r3, "ktv");
        return;
    L28:
        return;
    L26:
        return;
    L17:
        r3 = "";
        goto L18
    L8:
        r8 = 0;
        goto L9
    }

    public static final /* synthetic */ void access$handleStateCoreData(KtvStageViewModel r0, KtvRoomLyricsStateMachineConfig.d r1, d r2) {
        r0.handleStateCoreData(r1, r2);
    }
}
