package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.f9;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.PlayFlag;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.utils.d5;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a {
    public static final long y = 0;
    public com.bytedance.android.livesdk.ktvimpl.base.sei.f a;
    public Disposable b;
    public Disposable c;
    public final CompositeDisposable d;
    public final KtvContext e;
    public int f;
    public final String g;
    public final List<MusicPanel> h;
    public long i;
    public boolean j;
    public boolean k;
    public final com.bytedance.android.live.ktv.common.midi.b l;
    public final String m;
    public final long n;
    public final boolean o;
    public boolean p;
    public boolean q;
    public Disposable r;
    public final boolean s;
    public final c t;
    public final oe2.b u;
    public final sb0.b v;
    public StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> w;
    public final Function2<Integer, Long, Unit> x;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k a;
        public final /* synthetic */ int b;

        public b(k r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            ChorusContext.a r5 = ChorusContext.Companion;
            KtvMusic r1 = null;
            if (r5.c() == false) goto L12;
            ChorusContext r6 = r5.getContext();
            if (r6 == null) goto L11;
            com.bytedance.live.datacontext.n<List<MusicPanel>> r7 = r6.getChorusSelectedSongList();
            if (r7 == null) goto L11;
            List r8 = (List) r7.getValue();
            if (r8 == null) goto L11;
            MusicPanel r9 = (MusicPanel) CollectionsKt.firstOrNull(r8);
        L14:
            if (((Boolean) KtvSettingHelper.q0.getValue()).booleanValue() == false) goto L19;
            int r0 = this.b;
            if (r9 == null) goto L18;
            r1 = r9.a;
        L18:
            JSONObject r10 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.c(r0, r1, this.a.m);
        L24:
            if (this.b != 0) goto L34;
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r2 = KtvRoomContext.a.a();
            if (r2 == null) goto L34;
            com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r11 = r2.getPreviewViewModel();
            if (r11 == null) goto L34;
            KtvPreviewSongsViewModel r12 = (KtvPreviewSongsViewModel) r11.getValue();
            if (r12 == null) goto L34;
            if (r12.isShowPreviewCard() != true) goto L34;
            r10.put("play_flag", PlayFlag.PREVIEW_SONG.ordinal());
        L34:
            this.a.p(r10);
            return;
        L19:
            int r13 = this.b;
            MusicPanel r14 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.a.e);
            if (r14 == null) goto L22;
            r1 = r14.a;
        L22:
            r10 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.c(r13, r1, this.a.m);
        L11:
            r9 = null;
            goto L14
        L12:
            r9 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.a.e);
            goto L14
        }
    }

    public static final class c implements com.bytedance.android.livesdk.ktvimpl.base.sei.c {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
        public final boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r4.b;
            if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L5;
        L9:
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r5 = r4.b;
            if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L12;
            this.a.v.b().a();
            ((com.bytedance.android.livesdk.ktvimpl.base.sei.g) r5).getClass();
            return true;
        L12:
            return false;
        L5:
            if ((!Intrinsics.areEqual(r0.a(), this.a.v.f())) == false) goto L8;
            com.bytedance.android.livesdk.ktvimpl.base.sei.i r6 = (com.bytedance.android.livesdk.ktvimpl.base.sei.i) r4.b;
            this.a.v.b().a();
            r6.getClass();
            return true;
        L8:
            if (((Number) this.a.e.getKtvAllState().getValue()).intValue() != 8) goto L9;
            return true;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
        public final void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r15) {
            Intrinsics.checkNotNullParameter(r15, "result");
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r15.b;
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r2 = null;
            if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L5;
            r0 = null;
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.sei.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.sei.i) r0;
            if (r1 == null) goto L24;
            k r3 = this.a;
            JSONObject r4 = new JSONObject(r15.a);
            r3.getClass();
            Intrinsics.checkNotNullParameter(r1, "seiModel");
            Intrinsics.checkNotNullParameter(r4, "sourceSei");
            if (r1.c() != (-1)) goto L20;
            MidiContext.a r5 = MidiContext.Companion;
            r5.getClass();
            if (MidiContext.a.e(null) == false) goto L20;
            com.bytedance.android.live.ktv.common.midi.b r6 = r3.l;
            float r7 = r1.g();
            int r8 = r1.f();
            MidiContext r9 = r5.getContext();
            if (r9 == null) goto L18;
            com.bytedance.live.datacontext.j r10 = r9.getMidiConfig();
            if (r10 == null) goto L18;
            g0 r11 = (g0) r10.getValue();
            if (r11 == null) goto L18;
            Map r12 = r11.b();
        L19:
            int r13 = r6.b(r7, r8, r12);
        L21:
            JSONObject r14 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.a(r1.j(), r1.i(), r1.g(), r1.f(), r1.e(), r1.b(), r13, r1.h(), 1);
            com.bytedance.android.livesdk.ktvimpl.base.sei.f r16 = r3.a;
            if (r16 == null) goto L24;
            r16.a("ktv_midi_sei", r14);
        L18:
            r12 = null;
        L20:
            r13 = r1.c();
        L24:
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r17 = r15.b;
            if ((r17 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L28;
            r2 = r17;
        L28:
            com.bytedance.android.livesdk.ktvimpl.base.sei.g r18 = (com.bytedance.android.livesdk.ktvimpl.base.sei.g) r2;
            if (r18 == null) goto L34;
            k r19 = this.a;
            JSONObject r20 = new JSONObject(r15.a);
            r19.getClass();
            Intrinsics.checkNotNullParameter(r18, "midiSeiModel");
            Intrinsics.checkNotNullParameter(r20, "sourceSei");
            Intrinsics.checkNotNullParameter(r18, "midiSeiModel");
            Intrinsics.checkNotNullParameter(r20, "sourceSei");
            com.bytedance.android.livesdk.ktvimpl.base.sei.f r110 = r19.a;
            if (r110 == null) goto L35;
            r110.a("ktv_score_sei", r20);
            return;
        L35:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ k a;
        public final /* synthetic */ long b;

        public d(k r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r19) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r19;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetSingingHotResult, System.currentTimeMillis() - this.b, ((ExtraResponse) r1).logId);
            com.bytedance.android.live.ktv.common.model.api.e r2 = (com.bytedance.android.live.ktv.common.model.api.e) ((ExtraResponse) r1).data;
            com.bytedance.android.livesdk.ktvimpl.base.sei.n r14 = new com.bytedance.android.livesdk.ktvimpl.base.sei.n(r2.b(), r2.c(), r2.d(), r2.g(), r2.e(), r2.f(), r2.a(), this.a.i / ((long) 1000));
            KtvContext.Companion.getClass();
            KtvContext r0 = KtvContext.a.g();
            if (r0 == null) goto L5;
            r0.updateSingEndedFeedback(r14);
        L5:
            RxUtilKt.h(Observable.create(new p(this, r2)).subscribeOn(Schedulers.computation())).subscribe(new q(this), new r(this));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;

        public e(k r1, long r2) {
            this.a = r2;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            String r0 = "getKtvSingingHotResult exception: " + r8.getStackTrace();
            ALogger.i(bb0.b.b(), r0 + ", invoke class :" + k.class.getSimpleName());
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiGetSingingHotResult, System.currentTimeMillis() - this.a, r8);
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void f(com.bytedance.android.livesdk.ktvimpl.base.sei.k r2) {
        Intrinsics.checkNotNullParameter(r2, "seiModel");
    }

    static {
        y = ((long) ((Number) vm2.h.f4.getValue(null, vm2.h.a[264(0x108, float:3.7E-43)])).intValue()) * 1000;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void i() {
        ALogger.i(bb0.b.b(), "KtvRoomAnchorController reset, invoke class :".concat(k.class.getSimpleName()));
        this.p = true;
        this.b.dispose();
        this.c.dispose();
        this.r.dispose();
        this.f = -1;
        this.k = true;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.e.getSeiProcessor().getValue()).g(this.t);
        ((ArrayList) this.h).clear();
        this.d.clear();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r14) {
        Intrinsics.checkNotNullParameter(r14, "valid");
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r14.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        k(r14);
        return;
    L6:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L9;
        k(r14);
        return;
    L9:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L45;
        KtvRoomLyricsStateMachineConfig.d.f r1 = (KtvRoomLyricsStateMachineConfig.d.f) r0;
        KtvRoomLyricsStateMachineConfig.c r2 = r1.d;
        float r3 = r2.a;
        long r4 = r2.b.a.getMDuration() * 1000;
        if (r3 <= 0) goto L20;
        if (r4 <= 0) goto L20;
        if (this.q == true) goto L20;
        if (r3 < y) goto L20;
        this.q = true;
        MusicPanel r5 = r1.b;
        long r10 = r5.a.getMId();
        String r9 = r5.a.getOrderUserIdString();
        long r6 = System.currentTimeMillis();
        this.r = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).addSongStatusForRebroadcast(this.n, d5.c(r9), r9, r10, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(r6), new o(r6));
    L20:
        if ((r14.a instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L22;
        this.i = System.currentTimeMillis();
        this.j = false;
    L22:
        KtvMusic r15 = r1.b.a;
        String r7 = this.g;
        Lazy r8 = KtvUtilsKt.a;
        Intrinsics.checkNotNullParameter(r15, "$this$isSelf");
        OrderInfo r16 = r15.getOrderInfo();
        if (r16 == null) goto L27;
        InteractiveSongUserInfo r17 = r16.getTopUser();
        if (r17 == null) goto L27;
        String r18 = r17.getIdString();
    L28:
        if (r7 != null) goto L36;
        IMiddlewareUserService r11 = jc1.k.f(IMiddlewareUserService.class);
        if (r11 == null) goto L34;
        com.bytedance.android.livesdk.user.e r12 = r11.user();
        if (r12 == null) goto L34;
        r7 = r12.n();
    L34:
        r7 = null;
    L36:
        if (Intrinsics.areEqual(r18, r7) == false) goto L38;
    L39:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r19 = r1.c;
        if (r19 == null) goto L47;
        q(r19, r1.b);
        return;
    L47:
        return;
    L38:
        if (ChorusContext.Companion.c() == true) goto L39;
        return;
    L27:
        r18 = null;
        goto L28
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "valid");
        KtvRoomLyricsStateMachineConfig.b r5 = (KtvRoomLyricsStateMachineConfig.b) r4.d;
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.b.a) == false) goto L6;
        i();
        return;
    L6:
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.b.C0032b) == false) goto L37;
        this.k = false;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isKtvMode() == false) goto L10;
        OrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
    L11:
        if (r0 == null) goto L15;
        Disposable r6 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b.a.a(r0, false, new l(this), 3);
        if (r6 == null) goto L15;
        RxUtilKt.c(r6, this.d);
    L15:
        ChorusContext.a r7 = ChorusContext.Companion;
        ChorusContext r1 = r7.getContext();
        if (r1 == null) goto L24;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r2 = r1.getChorusSelectedSongList();
        if (r2 == null) goto L24;
        Observable r3 = r2.a();
        if (r3 == null) goto L24;
        Disposable r8 = r3.subscribe(new m(this));
        if (r8 == null) goto L24;
        RxUtilKt.c(r8, this.d);
    L24:
        List<MusicPanel> r9 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(this.e);
        if (r9 == null) goto L29;
        List<MusicPanel> r10 = CollectionsKt.toMutableList(r9);
        if (r10 == null) goto L29;
        m(r10);
    L29:
        ChorusContext r11 = r7.getContext();
        if (r11 == null) goto L41;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r12 = r11.getChorusSelectedSongList();
        if (r12 == null) goto L42;
        List<MusicPanel> r13 = (List) r12.getValue();
        if (r13 == null) goto L43;
        l(r13);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L10:
        r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        goto L11
    L37:
        if ((r5 instanceof KtvRoomLyricsStateMachineConfig.b.e) == false) goto L45;
        j(2);
        return;
    }

    public final void j(int r9) {
        if (this.b.isDisposed() == true) goto L7;
        if (this.f != r9) goto L7;
        return;
    L7:
        if (this.k == false) goto L10;
        return;
    L10:
        if (this.o == true) goto L12;
    L14:
        MusicPanel r0 = ((KtvRoomLyricsStateMachineConfig.d) this.w.b()).b();
        ChorusContext.a r1 = ChorusContext.Companion;
        String r3 = null;
        if (r1.c() == false) goto L24;
        ChorusContext r2 = r1.getContext();
        if (r2 == null) goto L23;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r4 = r2.getChorusSelectedSongList();
        if (r4 == null) goto L23;
        List r5 = (List) r4.getValue();
        if (r5 == null) goto L23;
        MusicPanel r6 = (MusicPanel) CollectionsKt.firstOrNull(r5);
    L25:
        ALogger.i("logKtvMainPath", ("anchor beginPing：" + r9) + ", invoke class :" + k.class.getSimpleName());
        if (this.f == r9) goto L28;
    L63:
        this.b.dispose();
        this.f = r9;
        int r7 = com.bytedance.android.livesdk.ktvimpl.base.c.a;
        this.b = du2.a.b(0, ((Number) vm2.h.Y2.getValue(null, vm2.h.a[205(0xcd, float:2.87E-43)])).longValue() * ((long) 1000.0f), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r9));
        String r10 = "beginPing:state:" + r9;
        if (r6 == null) goto L76;
        JSONObject r8 = new JSONObject();
        r8.put("extra", r10);
        r8.put("fullTrackLocalPath", r6.n);
        r8.put("accompanimentTrackLocalPath", r6.o);
        r8.put("lrcLocalPath", r6.l);
        r8.put("midiLocalPath", r6.q);
        r8.put(BaseCoreViewModel.CORE_TAG_STATE, r6.b);
        r8.put("mId", r6.a.getMId());
        r8.put("mTitle", r6.a.getMTitle());
        OrderInfo r11 = r6.a.getOrderInfo();
        if (r11 == null) goto L71;
        Intrinsics.checkNotNullParameter(r11, "$this$topUserFlex");
        b8 r12 = r11.getTopUser();
        if (r12 == null) goto L71;
        r3 = r12.getNickNameFlex();
    L71:
        r8.put("to_nickName", r3);
        r8.put("source", r6.f);
        ALogger.i(bb0.b.b(), r8.toString());
        return;
    L76:
        return;
    L28:
        if (r9 != 1) goto L63;
        if (r0 == null) goto L33;
        KtvMusic r13 = r0.a;
        if (r13 == null) goto L33;
        Long r14 = Long.valueOf(r13.getMId());
    L34:
        if (r6 == null) goto L38;
        KtvMusic r15 = r6.a;
        if (r15 == null) goto L38;
        Long r16 = Long.valueOf(r15.getMId());
    L40:
        if ((!Intrinsics.areEqual(r14, r16)) == true) goto L63;
        if (r0 == null) goto L49;
        KtvMusic r17 = r0.a;
        if (r17 == null) goto L49;
        OrderInfo r18 = r17.getOrderInfo();
        if (r18 == null) goto L49;
        InteractiveSongUserInfo r19 = r18.getTopUser();
        if (r19 == null) goto L49;
        String r20 = r19.getIdString();
    L50:
        if (r6 == null) goto L58;
        KtvMusic r21 = r6.a;
        if (r21 == null) goto L58;
        OrderInfo r22 = r21.getOrderInfo();
        if (r22 == null) goto L58;
        InteractiveSongUserInfo r23 = r22.getTopUser();
        if (r23 == null) goto L58;
        String r24 = r23.getIdString();
    L60:
        if ((true ^ Intrinsics.areEqual(r20, r24)) == true) goto L63;
        if (r0 != null) goto L74;
        if (r6 == null) goto L63;
        return;
    L74:
        return;
    L58:
        r24 = null;
    L49:
        r20 = null;
    L38:
        r16 = null;
    L33:
        r14 = null;
    L23:
        r6 = null;
        goto L25
    L24:
        r6 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.e);
        goto L25
    L12:
        if (this.p == false) goto L14;
    }

    public final void k(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Object r3 = r2.a;
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L8;
        if (r3 == null) goto L7;
        MusicPanel r4 = ((KtvRoomLyricsStateMachineConfig.d.f) r3).b;
        Intrinsics.checkNotNullParameter(r4, "panel");
        o(r4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    }

    public final void l(List<MusicPanel> r9) {
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == true) goto L6;
        return;
    L6:
        if (r0.d() == true) goto L11;
        ((ArrayList) this.h).clear();
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L62;
        KtvContext.a.g().updateCurrentUserIsSinger(false);
        return;
    L62:
        return;
    L11:
        if (r9 == null) goto L63;
        boolean r1 = n(CollectionsKt.toMutableList(r9));
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a("KtvRoomAnchorController", "isDiffFirst:" + r1);
        Float r2 = null;
        if (r1 == true) goto L16;
        r9 = null;
    L16:
        if (r9 == null) goto L64;
        ArrayList r3 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Object r4 = r10.next();
        if ((true ^ ((MusicPanel) r4).e) == false) goto L19;
        r3.add(r4);
        goto L19
    L23:
        StringBuilder r11 = new StringBuilder("KtvRoomAnchorController-newList:");
        r11.append(r3.size());
        r11.append(".currentSelectedList:");
        List<MusicPanel> r5 = this.h;
        if (r5 == null) goto L26;
        Integer r6 = Integer.valueOf(((ArrayList) r5).size());
    L27:
        r11.append(r6.intValue());
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a("KtvRoomAnchorController", r11.toString());
        MusicPanel r12 = (MusicPanel) CollectionsKt.firstOrNull(this.h);
        ((ArrayList) this.h).clear();
        ((ArrayList) this.h).addAll(r3);
        if (r3.size() > 0) goto L38;
        j(0);
        MusicPanel r7 = ((KtvRoomLyricsStateMachineConfig.d) this.w.b()).b();
        if (r7 == null) goto L34;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L34;
        long r13 = r8.getMId();
    L35:
        this.w.d(KtvRoomLyricsStateMachineConfig.a.h.c, null);
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L44;
        this.x.invoke(2, Long.valueOf(r13));
        KtvContext.a.g().updateCurrentUserIsSinger(false);
    L44:
        KtvContext.Companion.getClass();
        KtvContext r14 = KtvContext.a.g();
        if (r14 == null) goto L51;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r15 = r14.getKtvCoreController();
        if (r15 == null) goto L51;
        com.bytedance.android.livesdk.ktvimpl.base.i r16 = (com.bytedance.android.livesdk.ktvimpl.base.i) r15.getValue();
        if (r16 == null) goto L51;
        r2 = Float.valueOf(r16.c());
    L51:
        if (r2 != null) goto L53;
        return;
    L53:
        if ((!Intrinsics.areEqual(r2, 0.0f)) == false) goto L66;
        if (r12 == null) goto L67;
        pd2.d r17 = pd2.d.n;
        float r18 = r2.floatValue();
        r17.getClass();
        pd2.d.A(r12, r18);
        return;
    L67:
        return;
    L66:
        return;
    L34:
        r13 = 0;
        goto L35
    L38:
        MusicPanel r19 = (MusicPanel) CollectionsKt.getOrNull(r3, 0);
        if (r19 == null) goto L44;
        this.x.invoke(1, Long.valueOf(r19.a.getMId()));
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L43;
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r20 = this.w;
        KtvRoomLyricsStateMachineConfig.a.i r21 = new KtvRoomLyricsStateMachineConfig.a.i(r19);
        StateMachine.a r22 = StateMachine.c;
        r20.d(r21, null);
        goto L44
    L43:
        KtvContext.a.g().updateCurrentUserIsSinger(true);
        goto L44
    L26:
        r6 = null;
        goto L27
    L64:
        return;
    }

    public final void m(List<MusicPanel> r24) {
        if (ChorusContext.Companion.c() == false) goto L5;
        return;
    L5:
        boolean r1 = n(r24);
        String r3 = bb0.b.b();
        ALogger.i(r3, ("isDiffFirst:" + r1) + ", invoke class :" + Boolean.class.getSimpleName());
        Float r4 = null;
        if (r1 == false) goto L8;
        List<MusicPanel> r2 = r24;
    L9:
        if (r2 == null) goto L86;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r2.iterator();
    L12:
        if (r6.hasNext() == false) goto L16;
        Object r7 = r6.next();
        if ((true ^ ((MusicPanel) r7).e) == false) goto L12;
        r5.add(r7);
        goto L12
    L16:
        StringBuilder r8 = new StringBuilder("KtvRoomAnchorController-newList:");
        r8.append(r5.size());
        r8.append(".currentSelectedList:");
        List<MusicPanel> r9 = this.h;
        if (r9 == null) goto L19;
        Integer r10 = Integer.valueOf(((ArrayList) r9).size());
    L20:
        r8.append(r10.intValue());
        String r11 = r8.toString();
        ALogger.i(bb0.b.b(), r11 + ", invoke class :" + k.class.getSimpleName());
        MusicPanel r12 = (MusicPanel) CollectionsKt.firstOrNull(this.h);
        boolean r13 = false;
        if (((Boolean) KtvSettingHelper.S.getValue()).booleanValue() == false) goto L23;
        j(0);
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r14 = this.w;
        KtvRoomLyricsStateMachineConfig.a.h r15 = KtvRoomLyricsStateMachineConfig.a.h.c;
        StateMachine.a r16 = StateMachine.c;
        r14.d(r15, null);
    L23:
        ((ArrayList) this.h).clear();
        ((ArrayList) this.h).addAll(r5);
        if (r5.size() > 0) goto L34;
        j(0);
        MusicPanel r17 = ((KtvRoomLyricsStateMachineConfig.d) this.w.b()).b();
        if (r17 == null) goto L30;
        KtvMusic r18 = r17.a;
        if (r18 == null) goto L30;
        long r19 = r18.getMId();
    L31:
        this.w.d(KtvRoomLyricsStateMachineConfig.a.h.c, null);
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L68;
        this.x.invoke(2, Long.valueOf(r19));
        KtvContext.a.g().updateCurrentUserIsSinger(false);
    L68:
        KtvContext.Companion.getClass();
        KtvContext r20 = KtvContext.a.g();
        if (r20 == null) goto L75;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r21 = r20.getKtvCoreController();
        if (r21 == null) goto L75;
        com.bytedance.android.livesdk.ktvimpl.base.i r22 = (com.bytedance.android.livesdk.ktvimpl.base.i) r21.getValue();
        if (r22 == null) goto L75;
        r4 = Float.valueOf(r22.c());
    L75:
        if (r4 != null) goto L77;
        return;
    L77:
        if ((!Intrinsics.areEqual(r4, 0.0f)) == false) goto L88;
        if (r12 == null) goto L89;
        pd2.d r23 = pd2.d.n;
        float r25 = r4.floatValue();
        r23.getClass();
        pd2.d.A(r12, r25);
        return;
    L89:
        return;
    L88:
        return;
    L30:
        r19 = 0;
        goto L31
    L34:
        int r26 = mb0.f.a;
        MusicPanel r27 = (MusicPanel) CollectionsKt.getOrNull(r5, 0);
        if (r27 == null) goto L37;
        Long r28 = Long.valueOf(r27.c());
    L38:
        JSONObject r110 = new JSONObject();
        if (r28 == null) goto L41;
        r28.longValue();
        r110.put("songId", r28.longValue());
    L41:
        int r29 = rd0.a.a;
        MultiTraceData.TraceBusiness r30 = MultiTraceData.TraceBusiness.KTV;
        MultiTraceData.TraceEvent r111 = MultiTraceData.TraceEvent.MusicPlayFlow;
        rd0.a.b(r30, r111, "anchorSendWaitingStateSei", 0, null, r110, 88);
        j(1);
        MusicPanel r31 = (MusicPanel) CollectionsKt.getOrNull(r5, 0);
        if (r31 == null) goto L68;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a.d(r31.a) == false) goto L58;
        this.x.invoke(1, Long.valueOf(r31.a.getMId()));
        pd2.d r32 = pd2.d.n;
        pd2.d.M(r32, r31, "be_singer");
        pd2.d.M(r32, r31, "singer_comfirm");
        Long r33 = Long.valueOf(r31.c());
        String r34 = r31.e();
        KtvContext.Companion.getClass();
        boolean r112 = KtvContext.a.g().isCurrentUserIsSinger();
        JSONObject r113 = new JSONObject();
        if (r33 == null) goto L48;
        r33.longValue();
        r113.put("songId", r33.longValue());
    L48:
        if (r34 != null) goto L50;
    L51:
        r13 = true;
    L52:
        if (r13 == true) goto L54;
        r113.put("musicName", r34);
    L54:
        r113.put("isSinger", r112);
        rd0.a.b(r30, r111, "anchorBeSinger", 0, null, r113, 88);
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L57;
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r35 = this.w;
        KtvRoomLyricsStateMachineConfig.a.i r36 = new KtvRoomLyricsStateMachineConfig.a.i(r31);
        StateMachine.a r37 = StateMachine.c;
        r35.d(r36, null);
        goto L68
    L57:
        KtvContext.a.g().updateCurrentUserIsSinger(true);
        Unit r38 = Unit.INSTANCE;
        goto L68
    L50:
        if (r34.length() != 0) goto L52;
    L58:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L67;
        KtvContext.a.g().updateCurrentUserIsSinger(false);
        Function2<Integer, Long, Unit> r39 = this.x;
        MusicPanel r40 = ((KtvRoomLyricsStateMachineConfig.d) this.w.b()).b();
        if (r40 == null) goto L65;
        KtvMusic r41 = r40.a;
        if (r41 == null) goto L65;
        long r42 = r41.getMId();
    L66:
        r39.invoke(2, Long.valueOf(r42));
    L65:
        r42 = 0;
        goto L66
    L67:
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r43 = this.w;
        KtvRoomLyricsStateMachineConfig.a.c r44 = new KtvRoomLyricsStateMachineConfig.a.c(r31);
        StateMachine.a r45 = StateMachine.c;
        r43.d(r44, null);
        goto L68
    L37:
        r28 = null;
        goto L38
    L19:
        r10 = null;
        goto L20
    L86:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final boolean n(List<MusicPanel> r6) {
        MusicPanel r0 = (MusicPanel) CollectionsKt.firstOrNull(this.h);
        Boolean r1 = null;
        if (r0 == null) goto L7;
        KtvMusic r2 = r0.a;
        if (r2 == null) goto L7;
        Long r3 = Long.valueOf(r2.getMId());
    L8:
        MusicPanel r4 = (MusicPanel) CollectionsKt.getOrNull(r6, 0);
        if (r4 == null) goto L13;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L13;
        Long r7 = Long.valueOf(r5.getMId());
    L15:
        if (Intrinsics.areEqual(r3, r7) == false) goto L47;
        MusicPanel r8 = (MusicPanel) CollectionsKt.firstOrNull(this.h);
        if (r8 == null) goto L25;
        KtvMusic r9 = r8.a;
        if (r9 == null) goto L25;
        OrderInfo r10 = r9.getOrderInfo();
        if (r10 == null) goto L25;
        InteractiveSongUserInfo r11 = r10.getTopUser();
        if (r11 == null) goto L25;
        String r12 = r11.getIdString();
    L26:
        MusicPanel r13 = (MusicPanel) CollectionsKt.firstOrNull(r6);
        if (r13 == null) goto L35;
        KtvMusic r14 = r13.a;
        if (r14 == null) goto L35;
        OrderInfo r15 = r14.getOrderInfo();
        if (r15 == null) goto L35;
        InteractiveSongUserInfo r16 = r15.getTopUser();
        if (r16 == null) goto L35;
        String r17 = r16.getIdString();
    L37:
        if (Intrinsics.areEqual(r12, r17) == false) goto L47;
        MusicPanel r18 = (MusicPanel) CollectionsKt.firstOrNull(this.h);
        if (r18 == null) goto L41;
        Boolean r19 = Boolean.valueOf(r18.e);
    L42:
        MusicPanel r20 = (MusicPanel) CollectionsKt.firstOrNull(r6);
        if (r20 == null) goto L46;
        r1 = Boolean.valueOf(r20.e);
    L46:
        if (Intrinsics.areEqual(r19, r1) == false) goto L47;
        return false;
    L41:
        r19 = null;
    L35:
        r17 = null;
    L25:
        r12 = null;
    L47:
        return true;
    L13:
        r7 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void o(MusicPanel r16) {
        if (this.j == false) goto L5;
        return;
    L5:
        if (((f9) KtvSettingHelper.o0.getValue()).a() == false) goto L10;
        this.j = true;
        String r8 = r16.a.getOrderUserIdString();
        long r11 = r16.a.getMId();
        long r1 = System.currentTimeMillis();
        this.c = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getKtvSingingHotResult(this.n, d5.c(r8), r8, this.i / ((long) 1000), r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r1), new e(this, r1));
        return;
    }

    public final void p(JSONObject r7) {
        if (this.s == true) goto L5;
    L7:
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == false) goto L13;
        if (r0.d() == true) goto L13;
        return;
    L13:
        if (r7.has("anchor_id") == true) goto L15;
        r7.put("anchor_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(this.m));
    L15:
        r7.put("scene", this.u.k());
        r7.put("mode", this.u.b());
        r7.put("is_in_chorus", r0.c());
        if (r7.has("sender_user_id") == true) goto L18;
        r7.put("sender_user_id", com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(this.m));
    L18:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r1 == null) goto L37;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L37;
        if (r1.f == null) goto L37;
        Long r2 = r1.f();
        if (r2 == null) goto L27;
        Object r3 = Float.valueOf(r2.longValue() / 1000.0f);
    L28:
        r7.put("duration", r3);
        Long r4 = r1.h();
        if (r4 == null) goto L31;
        Object r5 = Float.valueOf(r4.longValue() / 1000.0f);
    L32:
        r7.put("start", r5);
        Long r6 = r1.e();
        if (r6 == null) goto L35;
        Object r8 = Float.valueOf(r6.longValue() / 1000.0f);
    L36:
        r7.put("playTime", r8);
        r7.put("song_type", 1);
        goto L37
    L35:
        r8 = 0;
        goto L36
    L31:
        r5 = 0;
        goto L32
    L27:
        r3 = 0;
    L37:
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r9 = this.a;
        if (r9 == null) goto L41;
        r9.a("ktv_sei", r7);
        return;
    L41:
        return;
    L5:
        if (KtvUtilsKt.v() == false) goto L7;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void g(com.bytedance.android.livesdk.ktvimpl.base.sei.k r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "seiModel");
        Intrinsics.checkNotNullParameter(r6, "sourceSei");
        int r0 = r5.d();
        if (r0 != 0) goto L5;
    L13:
        ChorusContext.a r1 = ChorusContext.Companion;
        if (r1.c() == false) goto L19;
        if (r1.d() == true) goto L19;
        return;
    L19:
        if (r1.c() == false) goto L28;
        ChorusContext r2 = r1.getContext();
        if (r2 == null) goto L27;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r3 = r2.getChorusSelectedSongList();
        if (r3 == null) goto L27;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L27;
        MusicPanel r7 = (MusicPanel) CollectionsKt.firstOrNull(r4);
    L29:
        if (r7 == null) goto L35;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L35;
        if (KtvUtilsKt.s(r8, r5.j(), r5.A()) != true) goto L35;
        j(2);
    L35:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L39;
        p(r6);
    L39:
        if (r5.d() != 0) goto L42;
        q(r5, ((KtvRoomLyricsStateMachineConfig.d) this.w.b()).b());
        return;
    L42:
        return;
    L27:
        r7 = null;
        goto L29
    L28:
        KtvContext.Companion.getClass();
        r7 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        goto L29
    L5:
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        if (r0 == 5) goto L13;
        if (r0 == 6) goto L13;
    }

    public final void q(com.bytedance.android.livesdk.ktvimpl.base.sei.k r3, MusicPanel r4) {
        Intrinsics.checkNotNullParameter(r3, "seiModel");
        if ((r3.h() - (r3.y() - r3.B())) > 5) goto L7;
        if (r4 == null) goto L8;
        o(r4);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(oe2.b r2, sb0.b r3, StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r4, Function2<? super Integer, ? super Long, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        Intrinsics.checkNotNullParameter(r4, "stateMachine");
        Intrinsics.checkNotNullParameter(r5, "singerUpdateAction");
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.b = Disposables.disposed();
        this.c = Disposables.disposed();
        this.d = new CompositeDisposable();
        KtvContext.Companion.getClass();
        KtvContext r6 = KtvContext.a.g();
        this.e = r6;
        this.f = -1;
        this.g = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        this.h = new ArrayList();
        this.l = new com.bytedance.android.live.ktv.common.midi.b();
        this.m = r3.b().a();
        this.n = r3.b().getRoomId();
        ReadOnlyProperty r7 = vm2.h.d4;
        KProperty[] r8 = vm2.h.a;
        this.o = ((Boolean) r7.getValue(null, r8[262(0x106, float:3.67E-43)])).booleanValue();
        this.r = Disposables.disposed();
        this.s = ((Boolean) vm2.h.e4.getValue(null, r8[263(0x107, float:3.69E-43)])).booleanValue();
        c r9 = new c(this);
        this.t = r9;
        j(0);
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) r6.getSeiProcessor().getValue(), r9);
    }
}
