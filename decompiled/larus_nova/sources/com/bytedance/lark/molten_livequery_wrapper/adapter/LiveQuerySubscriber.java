package com.bytedance.lark.molten_livequery_wrapper.adapter;

import com.bytedance.lark.molten_livequery.LiveQueryError;
import com.bytedance.lark.molten_livequery.MoltenFfiLibMoltenLivequery;
import com.bytedance.lark.molten_livequery.UnhandledException;
import com.bytedance.lark.molten_livequery.h;
import com.bytedance.lark.molten_livequery.j;
import com.bytedance.lark.molten_livequery_wrapper.g;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import molten_livequery.proto_kmp.FuncErrorX6fd51799fa8096ca;
import molten_livequery.proto_kmp.FuncParamsX0cc1ce23af9c04e3;
import molten_livequery.proto_kmp.FuncResultX04d2f37cd60cd2f3;
import molten_livequery.proto_kmp.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: classes19.dex */
public final class LiveQuerySubscriber<T> implements com.bytedance.lark.molten_livequery.d, g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f253363p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.molten_livequery_wrapper.f.a<T> f253364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<com.bytedance.lark.molten_livequery.c> f253366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super com.bytedance.lark.molten_livequery_wrapper.a, Object, Unit> f253367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveQuerySubscriber$listCacheUpdateCallback$1 f253368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f253369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final buc.e<h> f253370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f253371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f253372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f253373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final buc.a f253374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<Long, List<T>> f253375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<Long> f253376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final buc.a f253377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final buc.e<com.bytedance.lark.molten_livequery.d> f253378o;

    public static final class a {
    }

    public static final class b implements com.bytedance.lark.molten_livequery.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveQuerySubscriber<T> f253379a;

        @Override // com.bytedance.lark.molten_livequery.d
        public final void a() {
            com.bytedance.lark.molten_livequery.d r100 = this.f253379a.f253378o.c();
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        public b(LiveQuerySubscriber<T> r100) {
            this.f253379a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.lark.molten_livequery.d
    public final void a() {
        ((com.bytedance.lark.molten_livequery_wrapper.c) this.f253371h.getValue()).a(new LiveQuerySubscriber$onLiveQueryUpdate$1(this));
    }

    public final com.bytedance.lark.molten_livequery_wrapper.d b() {
        return (com.bytedance.lark.molten_livequery_wrapper.d) this.f253373j.getValue();
    }

    public final com.bytedance.lark.molten_livequery.c c() {
        if (this.f253374k.c() == false) goto L6;
        return null;
    L6:
        return (com.bytedance.lark.molten_livequery.c) this.f253369f.getValue();
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void pause() {
        this.f253378o.a(this, null);
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void release() {
        if (this.f253374k.a(false, true) == false) goto L6;
        ((com.bytedance.lark.molten_livequery_wrapper.c) this.f253371h.getValue()).a(new AnonymousClass1(this));
        return;
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void resume() {
        this.f253378o.a(null, this);
        if (this.f253377n.a(false, true) == false) goto L38;
        com.bytedance.lark.molten_livequery.c r100 = c();
        if (r100 == null) goto L45;
        b r101 = new b(this);
        Intrinsics.checkNotNullParameter(r101, "callback");
    L7:
        long r102 = r100.f253349c.get();
        if (r102 == 0) goto L37;
        if (r102 == Long.MAX_VALUE) goto L35;
        if (r100.f253349c.compareAndSet(r102, 1 + r102) == false) goto L7;
        long r103 = r100.f253347a;     // Catch: Throwable -> L29
        MoltenFfiLibMoltenLivequery r104 = MoltenFfiLibMoltenLivequery.f253320a;     // Catch: Throwable -> L29
        com.bytedance.lark.molten_livequery.b r105 = new com.bytedance.lark.molten_livequery.b(Long.valueOf(r103), "set_callback");     // Catch: Throwable -> L29
        r104.getClass();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r105, "info");     // Catch: Throwable -> L29
        MoltenFfiInstanceMsg r110 = j.e(r101);     // Catch: Throwable -> L29
        byte[] r111 = new FuncParamsX0cc1ce23af9c04e3(r110, null, null, 4, null).encode();     // Catch: Throwable -> L29
        byte[] r106 = MoltenFfiLibMoltenLivequery.molten_ffi_molten_livequery_call(MoltenFfiLibMoltenLivequery.a(), r103, -2170736975808770304L, r111);     // Catch: RuntimeException -> L23 Throwable -> L29
        FuncResultX04d2f37cd60cd2f3 r107 = FuncResultX04d2f37cd60cd2f3.ADAPTER.e(r106);     // Catch: Throwable -> L29
        if (r107.getErr() != null) goto L21;
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L29
        if (r100.f253349c.decrementAndGet() != 0) goto L46;
        r100.a();
        return;
    L46:
        return;
    L21:
        LiveQueryError.a r109 = LiveQueryError.Companion;     // Catch: Throwable -> L29
        FuncErrorX6fd51799fa8096ca r112 = r107.getErr();     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L29
        throw j.b(r109, r112.getErr());     // Catch: Throwable -> L29
    L23:
        e = move-exception;
        String r113 = e.getMessage();     // Catch: Throwable -> L29
        if (r113 != null) goto L28;
        r113 = "Rust panic";
    L28:
        throw new UnhandledException(r113);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r100.f253349c.decrementAndGet() != 0) goto L33;
        r100.a();
    L33:
        throw th;
    L35:
        throw new IllegalStateException(com.bytedance.lark.molten_livequery.c.class.getSimpleName().concat(" call counter would overflow"));
    L37:
        throw new IllegalStateException(com.bytedance.lark.molten_livequery.c.class.getSimpleName().concat(" object has already been destroyed"));
    L45:
        return;
    }

    public LiveQuerySubscriber(com.bytedance.lark.molten_livequery_wrapper.f.a<T> r100, long r101, Function0<com.bytedance.lark.molten_livequery.c> r102, final Function0<? extends com.bytedance.lark.molten_livequery_wrapper.d> r103, final Function0<? extends com.bytedance.lark.molten_livequery_wrapper.c> r104, final Function0<? extends com.bytedance.lark.molten_livequery_wrapper.c> r105) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r102, "liveQueryProvider");
        Intrinsics.checkNotNullParameter(r103, "loggerProvider");
        Intrinsics.checkNotNullParameter(r104, "backgroundExecutorProvider");
        Intrinsics.checkNotNullParameter(r105, "mainExecutorProvider");
        this.f253364a = r100;
        this.f253365b = r101;
        this.f253366c = r102;
        this.f253368e = new LiveQuerySubscriber$listCacheUpdateCallback$1(this);
        this.f253369f = LazyKt.lazy(new LiveQuerySubscriber$query$2(this));
        this.f253370g = buc.b.d(null);
        this.f253371h = LazyKt.lazy(new LiveQuerySubscriber$backgroundExecutor$2(r104));
        this.f253372i = LazyKt.lazy(new LiveQuerySubscriber$mainExecutor$2(r105));
        this.f253373j = LazyKt.lazy(new LiveQuerySubscriber$logger$2(r103));
        this.f253374k = buc.b.a(false);
        this.f253375l = new LinkedHashMap();
        this.f253376m = CollectionsKt.emptyList();
        this.f253377n = buc.b.a(false);
        this.f253378o = buc.b.d(null);
    }
}
