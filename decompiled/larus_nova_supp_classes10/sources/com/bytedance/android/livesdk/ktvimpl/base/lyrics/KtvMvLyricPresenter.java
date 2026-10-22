package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinMaterial;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMvLyricPresenter extends KtvBaseLyricPresenter {
    public long b;
    public ub0.a c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public Disposable h;
    public final CompositeDisposable i;
    public final long j;
    public final boolean k;
    public wd2.a l;
    public Function1<? super Integer, Unit> m;
    public com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.a n;
    public KtvRoomLyricsStateMachineConfig.d o;
    public ub0.a p;
    public final HashSet<Integer> q;
    public final com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a r;
    public final Function1<? super Long, Unit> s;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvMvLyricPresenter a;

        public a(KtvMvLyricPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            KtvMvLyricPresenter r0 = this.a;
            MidiSkinDressInfo r3 = (MidiSkinDressInfo) sh6.c.b((sh6.b) r2);
            if (r3 == null) goto L7;
            MidiSkinMaterial r4 = r3.getMaterial();
            if (r4 == null) goto L7;
            String r5 = r4.getLyricColorValue();
        L8:
            r0.h(r5);
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvMvLyricPresenter a;

        public c(KtvMvLyricPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            KtvMvLyricPresenter r7 = this.a;
            long r0 = r7.f + ((long) 33);
            r7.f = r0;
            r7.i(r0);
        }
    }

    static {
    }

    public final void b() {
        if (this.k == false) goto L6;
        final wd2.a r0 = new wd2.a();
        Intrinsics.checkNotNullParameter("KtvMvLyricPresenter", LocationMonitorConst.TAG);
        r0.g = "KtvMvLyricPresenter";
        r0.b = new KtvMvLyricPresenter$enableTimer$$inlined$apply$lambda$1(r0, this);
        Unit r1 = Unit.INSTANCE;
        this.l = r0;
        return;
    }

    public final void e() {
        this.q.clear();
        this.e = false;
        this.a.release();
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Function1<? super Integer, Unit> r1 = this.m;
        if (r1 == null) goto L8;
        Unit r2 = (Unit) r1.invoke(null);
    L8:
        this.h = null;
        this.f = 0;
        wd2.a r3 = this.l;
        if (r3 == null) goto L11;
        r3.e();
    L11:
        this.p = null;
        f(null);
    }

    public final void g() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        ALogger.i(bb0.b.b().concat("-lyric-updateLyricProgress"), "--start, invoke class :".concat(KtvMvLyricPresenter.class.getSimpleName()));
        this.h = du2.a.b(0, 33, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
    }

    public final void c(final ub0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "lyricsChangeEvent");
        String r0 = "onNewLyricEventChange:添加歌词" + r10.a + ",currentState:" + this.o + " ;; " + r10;
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric"), r0 + ", invoke class :" + KtvMvLyricPresenter.class.getSimpleName());
        if (KtvSettingHelper.w() == false) goto L12;
        if (this.o != null) goto L12;
        List r1 = r10.a();
        if (r1 == null) goto L12;
        if ((!r1.isEmpty()) != true) goto L12;
        this.c = r10;
    L12:
        if (KtvSettingHelper.w() == false) goto L22;
        if ((!this.a.getCurrentLyrics().isEmpty()) == false) goto L22;
        ub0.a r2 = this.p;
        if (r2 == null) goto L22;
        if (r2.b(r10) != true) goto L22;
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric"), "onNewLyricEventChange: has add lyric, invoke class :".concat(KtvMvLyricPresenter.class.getSimpleName()));
        return;
    L22:
        if (KtvSettingHelper.z() == true) goto L24;
    L27:
        KtvRoomLyricsStateMachineConfig.d r3 = this.o;
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L30;
        r3 = null;
    L30:
        final KtvRoomLyricsStateMachineConfig.d.f r4 = (KtvRoomLyricsStateMachineConfig.d.f) r3;
        if (r4 == null) goto L39;
        long r5 = r4.b.a.getMId();
        if (r5 <= 0) goto L39;
        if (r5 == r10.a) goto L39;
        String r6 = bb0.b.b().concat("-lyric-mv_lyric");
        ALogger.i(r6, ("mid no match, cur:" + r5 + ",parse result is :lyricsChangeEvent.mId") + ", invoke class :" + KtvMvLyricPresenter.class.getSimpleName());
        return;
    L39:
        if (KtvSettingHelper.w() == false) goto L46;
        ub0.a r7 = this.p;
        if (r7 == null) goto L46;
        if (r7.b(r10) != true) goto L46;
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric"), "onNewLyricEventChange:  isSameParseSucceedEvent, invoke class :".concat(KtvMvLyricPresenter.class.getSimpleName()));
        return;
    L46:
        this.p = r10;
        UtilityKotlinExtentionsKt.s(0, false, true, new KtvMvLyricPresenter$onNewLyricEventChange$1(this, r10, r4), 3);
        return;
    L24:
        if (this.o != null) goto L27;
        ALogger.i(bb0.b.b().concat("-lyric-mv_lyric"), "onNewLyricEventChange: currentState is null, invoke class :".concat(KtvMvLyricPresenter.class.getSimpleName()));
    }

    public final void d(int r7) {
        String r1 = bb0.b.b().concat("-lyric");
        ALogger.i(r1, ("sendCommand:" + r7) + ", invoke class :" + KtvMvLyricPresenter.class.getSimpleName());
        wd2.a r0 = this.l;
        if (r0 == null) goto L16;
        if (r7 == 4) goto L14;
        if (r7 == 5) goto L11;
        if (r7 != 6) goto L38;
        e();
        wd2.a r8 = this.l;
        if (r8 == null) goto L34;
        r8.e();
        return;
    L34:
        return;
    L38:
        return;
    L11:
        this.d = false;
        if (r0 == null) goto L36;
        wd2.a.c(r0);
        return;
    L36:
        return;
    L14:
        this.d = true;
        wd2.a.b(r0);
        return;
    L16:
        if (r7 == 0) goto L31;
        if (r7 == 3) goto L29;
        if (r7 == 4) goto L25;
        if (r7 == 5) goto L24;
        if (r7 != 6) goto L44;
        e();
        return;
    L44:
        return;
    L24:
        this.d = false;
        g();
        return;
    L25:
        this.d = true;
        Disposable r9 = this.h;
        if (r9 == null) goto L28;
        r9.dispose();
    L28:
        this.h = null;
        return;
    L29:
        this.d = false;
        g();
        return;
    L31:
        if (this.d == true) goto L43;
        g();
        return;
    }

    public final void f(KtvRoomLyricsStateMachineConfig.d r2) {
        this.o = r2;
        if (KtvSettingHelper.w() == false) goto L10;
        ub0.a r0 = this.c;
        if (r0 == null) goto L8;
        if (r2 == null) goto L8;
        c(r0);
        this.c = null;
    L8:
        this.a.updateCurrentState(r2);
        return;
    }

    public final void h(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r1 = this.a;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r2 = null;
        if ((r1 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyrics.a) == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L17;
        LyricsDisplayConfig r3 = r1.getDisplayConfig();
        if (r3 == null) goto L17;
        r3.h(r4, "");
    L17:
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r5 = this.a;
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.lyrics.a) == false) goto L21;
        r2 = r5;
    L21:
        if (r2 == null) goto L24;
        r2.updateDynamicPaintColor();
        return;
    L24:
        return;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void i(long r6) {
        if ((r6 - this.f) >= ((Number) KtvSettingHelper.r.getValue()).intValue()) goto L5;
        return;
    L5:
        long r0 = this.f;
        if (r6 < r0) goto L8;
    L10:
        this.f = r6;
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget.a r1 = this.n;
        if (r1 == null) goto L13;
        r1.a(r6);
    L13:
        this.a.renderLyricsByPlayTime(r6);
        return;
    L8:
        if ((r0 - r6) >= this.j) goto L10;
    }

    public KtvMvLyricPresenter(com.bytedance.android.livesdk.ktvimpl.base.lyrics.a r4, com.bytedance.android.livesdk.ktvimpl.base.lyrics.viewModel.a r5, Function1<? super Long, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "lyricView");
        super(r4);
        this.r = r5;
        this.s = r6;
        this.b = -1;
        CompositeDisposable r7 = new CompositeDisposable();
        this.i = r7;
        this.j = h.u();
        this.k = ((Boolean) h.m3.getValue(null, h.a[219(0xdb, float:3.07E-43)])).booleanValue();
        Function1<LyricsDisplayConfig, Unit> r0 = new KtvMvLyricPresenter$configDisplay$1(this);
        LyricsDisplayConfig r1 = r4.getDisplayConfig();
        if (r1 == null) goto L5;
        r0.invoke(r1);
        r4.onConfigComplete();
    L5:
        KtvContext r8 = r5.b();
        if (r8 == null) goto L14;
        n<MidiSkinDressInfo> r9 = r8.getMidiSkinContext();
        if (r9 == null) goto L14;
        Observable r10 = r9.a();
        if (r10 == null) goto L14;
        Disposable r11 = r10.subscribe(new a(this));
        if (r11 == null) goto L14;
        RxUtilKt.c(r11, r7);
    L14:
        this.q = new HashSet();
    }
}
