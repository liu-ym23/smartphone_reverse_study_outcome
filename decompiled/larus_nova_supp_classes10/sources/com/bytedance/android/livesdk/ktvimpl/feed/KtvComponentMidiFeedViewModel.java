package com.bytedance.android.livesdk.ktvimpl.feed;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvComponentMidiFeedViewModel implements com.bytedance.android.livesdk.ktvimpl.base.sei.c, db0.a {
    public static final /* synthetic */ int q = 0;
    public boolean a;
    public final Lazy b;
    public long c;
    public ScheduledFuture<?> d;
    public final MutableLiveData<List<cb0.c>> e;
    public final MutableLiveData<Boolean> f;
    public final MutableLiveData<Boolean> g;
    public final MutableLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.h> h;
    public final MutableLiveData<com.bytedance.android.live.ktv.common.midi.k> i;
    public final CompositeDisposable j;
    public Disposable k;
    public boolean l;
    public long m;
    public final k n;
    public final AtomicBoolean o;
    public final KtvComponentFeedViewModel p;

    public static final class a {
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class d<T> implements Predicate {
        public final /* synthetic */ long a;

        public d(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            long r0 = r8.a;
            long r2 = this.a;
            if (r0 < r2) goto L5;
        L7:
            return false;
        L5:
            if (r8.b < r2) goto L7;
            return true;
        }
    }

    public static final class e<T> implements Predicate {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class g<T> implements Predicate {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public g(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            if (r8.a < this.a) goto L5;
        L7:
            return false;
        L5:
            if (r8.b <= this.b) goto L7;
            return true;
        }
    }

    public static final class h<T> implements SingleOnSubscribe {
        public h(String r1) {
        }

        public final void subscribe(SingleEmitter<List<cb0.c>> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            if (vm2.h.d() == false) goto L7;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
            if (r0 == null) goto L10;
            r0.getLiveCoreKaraokFilter();
        L10:
            r3.onError(new Exception("getMidiDrawingData error"));
            return;
        L7:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
            if (r1 == null) goto L10;
            r1.getLiveCoreKaraokFilter();
            goto L10
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiFeedViewModel a;

        public i(KtvComponentMidiFeedViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiFeedViewModel", "initMidiRes success");
            MutableLiveData<List<cb0.c>> r0 = this.a.e;
            r0.setValue((List) r3);
            this.a.f.setValue(Boolean.FALSE);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiFeedViewModel a;
        public final /* synthetic */ long b;

        public j(KtvComponentMidiFeedViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiFeedViewModel", "initMidiRes failed");
            ((Throwable) r3).printStackTrace();
            pd2.d.n.F(this.b);
            this.a.f.setValue(Boolean.TRUE);
        }
    }

    public static final class k implements com.bytedance.android.live.ktv.common.music.download.k.b {
        public final /* synthetic */ KtvComponentMidiFeedViewModel a;

        public final void onFailed(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "errorMsg");
        }

        public k(KtvComponentMidiFeedViewModel r1) {
            this.a = r1;
        }

        public final void a(long r4, String r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "midiSavePath");
            KtvComponentMidiFeedViewModel r8 = this.a;
            if (r8.c != r4) goto L6;
            r8.a(r4, r6);
            return;
        }
    }

    static {
    }

    public final cb0.c findMidiSegmentOpt(long r1) {
        return null;
    }

    public final List<cb0.c> findMidiSegmentsOpt(long r1, long r3) {
        return null;
    }

    public KtvComponentMidiFeedViewModel(KtvComponentFeedViewModel r2) {
        this.p = r2;
        this.b = LazyKt.lazy(new KtvComponentMidiFeedViewModel$loadMidiSoRunnable$2(this));
        this.e = new MutableLiveData();
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        this.h = new MutableLiveData();
        this.i = new MutableLiveData();
        this.j = new CompositeDisposable();
        this.n = new k(this);
        this.o = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    public final void b(com.bytedance.android.livesdk.ktvimpl.base.sei.k r8) {
        if (KtvSettingHelper.f() == true) goto L5;
        return;
    L5:
        boolean r4 = false;
        if (r8.j() > 0) goto L8;
    L17:
        boolean r0 = false;
    L18:
        if (r0 == true) goto L20;
        return;
    L20:
        if (r8.j() != this.c) goto L27;
        Collection r1 = (Collection) this.e.getValue();
        if (r1 != null) goto L24;
    L25:
        r4 = true;
    L26:
        if (r4 == true) goto L27;
        return;
    L24:
        if (r1.isEmpty() == false) goto L26;
    L27:
        this.c = r8.j();
        com.bytedance.android.live.ktv.common.music.download.h r2 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r3 = com.bytedance.android.live.ktv.common.music.download.h.e(r8.t(), this.c);
        if (new PolarisFileWrapper(r3).exists() == false) goto L30;
        a(this.c, r3);
        return;
    L30:
        com.bytedance.android.live.ktv.common.music.download.k.a r5 = com.bytedance.android.live.ktv.common.music.download.k.a;
        long r6 = this.c;
        String r9 = r8.t();
        if (r9 != null) goto L33;
        r9 = "";
    L33:
        com.bytedance.android.live.ktv.common.music.download.k.c r7 = new com.bytedance.android.live.ktv.common.music.download.k.c(r6, r9, r3);
        WeakReference r10 = new WeakReference(this.n);
        r5.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r7, r10);
        return;
    L8:
        if (r8.n() == 2) goto L17;
        String r11 = r8.t();
        if (r11 == null) goto L17;
        if (r11.length() <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 != true) goto L17;
        r0 = true;
        goto L18
    L14:
        r12 = false;
        goto L15
    }

    public final Observable<cb0.c> findMidiSegment(long r3) {
        Collection r0 = (Collection) this.e.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return Observable.empty();
    L13:
        return Observable.just(this.e.getValue()).filter(b.a).flatMap(c.a).filter(new d(r3));
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r13) {
        Intrinsics.checkNotNullParameter(r13, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r14 = r13.b;
        boolean r1 = false;
        if ((r14 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L52;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r15 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r14;
        int r0 = r15.d();
        if (r0 == 0) goto L32;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L32;
        if (r0 != 5) goto L87;
        b(r15);
        return;
    L87:
        return;
    L15:
        if (r15.j() <= 0) goto L74;
        List<v> r2 = r15.l();
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == false) goto L75;
        String r16 = r15.t();
        if (r16 != null) goto L27;
    L28:
        r1 = true;
    L29:
        if (r1 == false) goto L76;
        this.f.setValue(Boolean.TRUE);
        return;
    L76:
        return;
    L27:
        if (r16.length() != 0) goto L29;
    L75:
        return;
    L19:
        if (r2.isEmpty() == true) goto L22;
        r3 = false;
        goto L23
    L74:
        return;
    L32:
        if (KtvSettingHelper.f() == false) goto L35;
        b(r15);
        return;
    L35:
        if (r15.j() > 0) goto L37;
        return;
    L37:
        if (r15.j() != this.c) goto L39;
        return;
    L39:
        if (r15.n() == 2) goto L81;
        String r4 = r15.t();
        if (r4 != null) goto L43;
    L44:
        r1 = true;
    L45:
        if (r1 == true) goto L50;
        long r5 = r15.j();
        this.c = r5;
        com.bytedance.android.live.ktv.common.music.download.h r17 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r18 = com.bytedance.android.live.ktv.common.music.download.h.e(r4, r5);
        if (new PolarisFileWrapper(r18).exists() == false) goto L49;
        a(this.c, r18);
        return;
    L49:
        com.bytedance.android.live.ktv.common.music.download.k.a r6 = com.bytedance.android.live.ktv.common.music.download.k.a;
        com.bytedance.android.live.ktv.common.music.download.k.c r7 = new com.bytedance.android.live.ktv.common.music.download.k.c(this.c, r4, r18);
        WeakReference r19 = new WeakReference(this.n);
        r6.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r7, r19);
        return;
    L50:
        this.f.setValue(Boolean.TRUE);
        return;
    L43:
        if (r4.length() != 0) goto L45;
    L81:
        return;
    L52:
        if ((r14 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == false) goto L70;
        if (this.a == true) goto L56;
        this.a = true;
        this.d = TTExecutors.getScheduledThreadPool().schedule((Runnable) this.b.getValue(), 0, TimeUnit.SECONDS);
    L56:
        com.bytedance.android.livesdk.ktvimpl.base.sei.i r110 = (com.bytedance.android.livesdk.ktvimpl.base.sei.i) r14;
        Collection r8 = (Collection) this.e.getValue();
        if (r8 != null) goto L59;
    L60:
        r1 = true;
    L61:
        if (r1 == false) goto L64;
        return;
    L64:
        if ((System.currentTimeMillis() - this.m) < ((Number) KtvSettingHelper.G0.getValue()).longValue()) goto L66;
    L68:
        this.m = System.currentTimeMillis();
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentMidiFeedViewModel", String.valueOf(r110));
        this.i.setValue(new com.bytedance.android.live.ktv.common.midi.k(r110.j(), r110.i(), 0.0f, r110.g(), r110.f(), Integer.valueOf(r110.e()), r110.c(), false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE));
        return;
    L66:
        if (this.m == 0) goto L68;
        return;
    L59:
        if (r8.isEmpty() == false) goto L61;
    L70:
        if ((r14 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.h) == false) goto L86;
        this.h.setValue((com.bytedance.android.livesdk.ktvimpl.base.sei.h) r14);
        return;
    }

    public final void a(long r3, String r5) {
        if (this.a == true) goto L5;
        return;
    L5:
        if (this.o.get() == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r5) == false) goto L11;
        this.f.setValue(Boolean.TRUE);
        return;
    L11:
        RxUtilKt.c(Single.create(new h(r5)).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this), new j(this, r3)), this.j);
    }

    public final Single<List<cb0.c>> findMidiSegments(long r3, long r5) {
        Collection r0 = (Collection) this.e.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return null;
    L13:
        return Observable.just(this.e.getValue()).filter(e.a).flatMap(f.a).filter(new g(r5, r3)).toList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
