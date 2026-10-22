package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.RealTimeChorusMidiViewModelFactory;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.l1;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/midi/RealTimeChorusMidiWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusMidiWidget extends MiddlewareRoomWidget implements ViewModelStoreOwnerCompat {
    public static final /* synthetic */ int p = 0;
    public final CompositeDisposable a;
    public RealTimeChorusMidiViewModel b;
    public KtvComponentMidiView c;
    public final ViewModelStore d;
    public final CompositeDisposable e;
    public Function0<Unit> f;
    public float g;
    public int h;
    public int i;
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a j;
    public final m k;
    public final n l;
    public final KtvContext m;
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.b n;
    public final l1 o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RealTimeChorusMidiWidget a;

        public b(RealTimeChorusMidiWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            RealTimeChorusMidiWidget r0 = this.a;
            MidiSkinDressInfo r3 = (MidiSkinDressInfo) sh6.c.b((sh6.b) r2);
            KtvComponentMidiView r1 = r0.c;
            if (r1 == null) goto L6;
            r1.y(r3);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565310;
    }

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public final void onDestroy() {
        this.a.clear();
        KtvComponentMidiView r0 = this.c;
        if (r0 == null) goto L5;
        r0.onDetach();
    L5:
        this.d.clear();
        if (this.e.isDisposed() == true) goto L8;
        this.e.dispose();
    L8:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
    }

    public final double wq() {
        RealTimeChorusMidiViewModel r0 = this.b;
        if (r0 == null) goto L11;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r1 = r0.m493getScoreInfo();
        if (r1 == null) goto L11;
        Pair r2 = (Pair) r1.getValue();
        if (r2 == null) goto L11;
        com.bytedance.android.live.ktv.common.midi.k r3 = (com.bytedance.android.live.ktv.common.midi.k) r2.getSecond();
        if (r3 == null) goto L11;
        return r3.d;
    L11:
        return 0.0d;
    }

    public final void onCreate() {
        super.onCreate();
        KtvComponentMidiView r0 = (KtvComponentMidiView) ((Widget) this).contentView.findViewById(2131365695);
        this.c = r0;
        if (r0 == null) goto L5;
        r0.setPerformStrategy(this.l);
    L5:
        KtvComponentMidiView r1 = this.c;
        if (r1 == null) goto L8;
        r1.qc(this.k);
    L8:
        KtvComponentMidiView r2 = this.c;
        if ((r2 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L15;
        this.m.getStatisticHelper().b(r2);
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L15;
        r3.postDelayed(new l(r2), vm2.h.A());
    L15:
        RealTimeChorusMidiViewModel r4 = (RealTimeChorusMidiViewModel) new ViewModelProvider(this, new RealTimeChorusMidiViewModelFactory(this.m)).get(RealTimeChorusMidiViewModel.class);
        this.b = r4;
        if (r4 == null) goto L18;
        r4.onCreate(this);
    L18:
        RealTimeChorusMidiViewModel r5 = this.b;
        if (r5 == null) goto L23;
        MutableLiveData<List<cb0.c>> r6 = r5.getMidiData();
        if (r6 == null) goto L23;
        r6.observe(this, new h(this));
    L23:
        RealTimeChorusMidiViewModel r7 = this.b;
        if (r7 == null) goto L28;
        MutableLiveData<g0> r8 = r7.getMidiConfig();
        if (r8 == null) goto L28;
        r8.observe(this, new i(this));
    L28:
        RealTimeChorusMidiViewModel r9 = this.b;
        if (r9 == null) goto L33;
        MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> r10 = r9.m493getScoreInfo();
        if (r10 == null) goto L33;
        r10.observe(this, new j(this));
    L33:
        RealTimeChorusMidiViewModel r11 = this.b;
        if (r11 == null) goto L38;
        KtvComponentMidiView r12 = this.c;
        if (r12 == null) goto L38;
        r12.Gk(r11, this.l);
    L38:
        RealTimeChorusMidiViewModel r13 = this.b;
        if (r13 == null) goto L43;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r14 = r13.getCurState();
        if (r14 == null) goto L43;
        r14.observe(this, new k(this));
    L43:
        RealTimeChorusMidiViewModel r15 = this.b;
        if (r15 == null) goto L48;
        NextLiveData<Long> r16 = r15.getLyricProgress();
        if (r16 == null) goto L48;
        final RealTimeChorusMidiWidget$initStageViewModel$6 r17 = new RealTimeChorusMidiWidget$initStageViewModel$6(this);
        r16.observe(this, new o(r17));
    L48:
        MidiSkinDressInfo r18 = (MidiSkinDressInfo) this.m.getMidiSkinContext().getValue();
        KtvComponentMidiView r19 = this.c;
        if (r19 == null) goto L51;
        r19.y(r18);
    L51:
        RxUtilKt.c(this.m.getMidiSkinContext().a().subscribe(new b(this)), this.e);
        Function0<Unit> r20 = this.f;
        if (r20 == null) goto L55;
        Unit r21 = (Unit) r20.invoke();
        return;
    }

    public final ViewModelStore tf() {
        return this.d;
    }

    public final void xq(Long r2) {
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r0 = this.m.getKtvCoreViewModel();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r0.getValue();
        if (r1 == null) goto L9;
        KtvRoomLyricsStateMachineConfig.d r3 = r1.getCurState();
        if (r3 == null) goto L9;
        MusicPanel r4 = r3.b();
    L10:
        if (r4 == null) goto L19;
        com.bytedance.android.live.ktv.common.util.c r5 = this.c;
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.getVisibility() != 0) goto L21;
        RealTimeChorusMidiViewModel r6 = this.b;
        if (r6 == null) goto L22;
        r6.tryStartGetScoreInfoTimer(r2);
        return;
    L22:
        return;
    L21:
        return;
    L19:
        return;
    L9:
        r4 = null;
        goto L10
    }

    public RealTimeChorusMidiWidget(KtvContext r2, c r3, l1 r4) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r4, "singInfoProvider");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.a = new CompositeDisposable();
        this.d = new ViewModelStore();
        this.e = new CompositeDisposable();
        this.i = -1;
        this.j = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi.a();
        this.k = new m();
        this.l = new n();
    }
}
