package com.larus.im.service;

import android.os.SystemClock;
import com.larus.im.internal.jni.ktx.OmniTokenServiceKtxKt;
import com.larus.im.internal.jni.service.IRtcEnginePoolServiceCallback;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.bytertc.engine.RTCEngine;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class k implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<m> f350876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f350877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowRTCEnginePoolTracer f350878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f350879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f350880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile g f350881g;

    public static final class a {
    }

    public final class b implements IRtcEnginePoolServiceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f350882a;

        @Override // com.larus.im.internal.jni.service.IRtcEnginePoolServiceCallback
        public final void didOmniObtainEngine() {
            com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "didOmniObtainEngine");
        }

        public b(k r100) {
            this.f350882a = r100;
        }

        @Override // com.larus.im.internal.jni.service.IRtcEnginePoolServiceCallback
        public final void didOmniDestroyEngine(String r100) {
            Intrinsics.checkNotNullParameter(r100, "withBizId");
            com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "didOmniDestroyEngine, withBizId: " + r100);
        }

        @Override // com.larus.im.internal.jni.service.IRtcEnginePoolServiceCallback
        public final void willOmniDestroyEngine(String r100) {
            Intrinsics.checkNotNullParameter(r100, "withBizId");
            com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "willOmniDestroyEngine, withBizId: " + r100);
        }

        @Override // com.larus.im.internal.jni.service.IRtcEnginePoolServiceCallback
        public final int willOmniObtainEngine(String r100) {
            Intrinsics.checkNotNullParameter(r100, "businessId");
            k r101 = this.f350882a;
            Object r102 = r101.f350877c;
            monitor-enter(r102);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (f.a(r100) == true) goto L7;
            com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "willOmniObtainEngine: invalid bizId: " + r100 + ", supported: " + f.b());     // Catch: Throwable -> L23
            int r103 = -1;
        L21:
            monitor-exit(r102);
            return r103;
        L7:
            g r104 = r101.f350881g;     // Catch: Throwable -> L23
            if (r104 != null) goto L10;
        L12:
            boolean r105 = false;
        L13:
            if (r105 == true) goto L15;
        L17:
            k.a(r101, r100);     // Catch: Throwable -> L23
            r101.d(r100, true);     // Catch: Throwable -> L23
            int r106 = OmniTokenServiceKtxKt.getOmniEngineService().createEngine();     // Catch: Throwable -> L23
            if (r106 < 0) goto L20;
            r101.f350881g = new g(r100, null, new l(), true);     // Catch: Throwable -> L23
            r101.f(r100, true);     // Catch: Throwable -> L23
        L20:
            r103 = r106;
            goto L21
        L15:
            if (Intrinsics.areEqual(r104.f350835a, r100) == false) goto L17;
            com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "reuse native Omni engine, bizId: ".concat(r100));     // Catch: Throwable -> L23
            r103 = 0;
            goto L21
        L10:
            if (r104.f350838d != true) goto L12;
            r105 = true;
            goto L13
        }
    }

    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            com.larus.im.internal.delegate.a.f348188b.w("FlowRTCEnginePool", "[engineScope] exception: " + r101.getMessage(), r101);
        }
    }

    static {
    }

    public k() {
        this.f350876b = new CopyOnWriteArraySet();
        this.f350877c = new Object();
        this.f350878d = new FlowRTCEnginePoolTracer();
        ExecutorService r100 = PThreadExecutorsUtils.newSingleThreadExecutor(new i());
        this.f350879e = r100;
        this.f350880f = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r100).plus(new c(CoroutineExceptionHandler.Key)));
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "init: engine pool created");
        OmniTokenServiceKtxKt.getOmniEngineService().setCallback(new b(this));
    }

    public final void b(m r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f350877c;
        monitor-enter(r101);
        this.f350876b.add(r100);     // Catch: Throwable -> L7
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "addListener: " + r100 + ", hashCode: " + r100.hashCode());     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void i(m r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = this.f350877c;
        monitor-enter(r101);
        this.f350876b.remove(r100);     // Catch: Throwable -> L7
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "removeListener: " + r100 + ", hashCode: " + r100.hashCode());     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final void a(k r100, String r101) {
        g r102 = r100.f350881g;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f350838d == false) goto L8;
        r100.c(r102.f350835a, r101);
        return;
    L8:
        r100.f350881g = null;
        r100.e(r102.f350835a, r101, false);
        r102.a();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        RTCEngine.destroyRTCEngine();     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "destroy platform RTC engine before Omni create failed", r105);
    L16:
        r100.g(r102.f350835a, r101, false);
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "release platform RTC engine before Omni create success, oldBizId: " + r102.f350835a);
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void c(final String r110, final String r111) {
        if (f.a(r110) == true) goto L6;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "detachEngine: invalid bizId: " + r110 + ", supported: " + f.b());
        return;
    L6:
        com.larus.im.internal.delegate.a r100 = com.larus.im.internal.delegate.a.f348188b;
        r100.i("FlowRTCEnginePool", "detachEngine: start, request bizId: ".concat(r110));
        Object r101 = this.f350877c;
        monitor-enter(r101);
        final g r102 = this.f350881g;     // Catch: Throwable -> L47
        String r103 = null;
        if (r102 != null) goto L11;
    L41:
        StringBuilder r104 = new StringBuilder("detachEngine: engine not found, request bizId: ");     // Catch: Throwable -> L47
        r104.append(r110);     // Catch: Throwable -> L47
        r104.append(", old bizId: ");     // Catch: Throwable -> L47
        if (r102 == null) goto L44;
        r103 = r102.f350835a;     // Catch: Throwable -> L47
    L44:
        r104.append(r103);     // Catch: Throwable -> L47
        r100.i("FlowRTCEnginePool", r104.toString());     // Catch: Throwable -> L47
        monitor-exit(r101);
        return;
    L11:
        if (Intrinsics.areEqual(r102.f350835a, r110) == false) goto L41;
        this.f350881g = null;     // Catch: Throwable -> L47
        boolean r105 = true;
        if (r102.f350838d == false) goto L19;
        e(r102.f350835a, r111, true);     // Catch: Throwable -> L47
        r102.a();     // Catch: Throwable -> L47
        r100.i("FlowRTCEnginePool", "detachEngine: destroy native engine ret: " + OmniTokenServiceKtxKt.getOmniEngineService().destroyEngineIfNeeded(r111));     // Catch: Throwable -> L47
        g(r102.f350835a, r111, true);     // Catch: Throwable -> L47
        monitor-exit(r101);
        return;
    L19:
        e(r110, r111, false);     // Catch: Throwable -> L47
        r102.a();     // Catch: Throwable -> L47
        boolean r106 = com.flow.kmp.common.thread.a.a();     // Catch: Throwable -> L47
        com.larus.im.internal.delegate.w.c r107 = com.larus.im.internal.delegate.w.j().f348360e;     // Catch: Throwable -> L47
        if (r107 == null) goto L22;
        boolean r108 = r107.f348331c;     // Catch: Throwable -> L47
    L23:
        com.larus.im.internal.delegate.w.c r109 = com.larus.im.internal.delegate.w.j().f348360e;     // Catch: Throwable -> L47
        if (r109 == null) goto L26;
        boolean r112 = r109.f348332d;     // Catch: Throwable -> L47
    L27:
        if (r112 == false) goto L34;
        if (r106 == false) goto L32;
        if (r108 == false) goto L32;
    L33:
        r108 = r105;
    L32:
        r105 = false;
    L34:
        Function1 r113 = new h(this, r110, r111, r102);     // Catch: Throwable -> L47
        if (r108 == false) goto L37;
        BuildersKt.launch$default(this.f350880f, null, null, new FlowRTCEnginePool$execTask$1(r113, null), 3, null);     // Catch: Throwable -> L47
    L38:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L47
        monitor-exit(r101);
        return;
    L37:
        r113.invoke(Boolean.FALSE);     // Catch: Throwable -> L47
        goto L38
    L26:
        r112 = true;
        goto L27
    L22:
        r108 = true;
    L47:
        th = move-exception;
        throw th;
    }

    public final void d(String r100, boolean r101) {
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyBeforeCreateEngine start: bizId: " + r100 + ", fromNative: " + r101);
        Iterator<T> r102 = this.f350876b.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        m r103 = (m) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r103.c(r100);     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L4;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "notifyBeforeCreateEngine error: bizId: " + r100 + ", fromNative: " + r101, r106);
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyBeforeCreateEngine end: bizId: " + r100 + ", fromNative: " + r101);
    }

    public final void f(String r100, boolean r101) {
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyDidCreateEngine start: bizId: " + r100 + ", fromNative: " + r101);
        Iterator<T> r102 = this.f350876b.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        m r103 = (m) r102.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L8
        r103.a(r100);     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L4;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "notifyDidCreateEngine error: bizId: " + r100 + ", fromNative: " + r101, r106);
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyDidCreateEngine end: bizId: " + r100 + ", fromNative: " + r101);
    }

    public final void h(final n r310, final Function2<? super FlowRTCEnginePoolObtainResult, ? super e, Unit> r311) {
        Intrinsics.checkNotNullParameter(r310, "request");
        Intrinsics.checkNotNullParameter(r311, "result");
        final boolean r210 = com.flow.kmp.common.thread.a.a();
        FlowRTCEnginePoolTracer r100 = this.f350878d;
        String r101 = r310.f350883a;
        g r102 = this.f350881g;
        if (r102 == null) goto L5;
        String r110 = r102.f350835a;
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "bizId");
        FlowRTCEnginePoolTracer.b("obtain", r101, r110, null, null, null, null, null, Boolean.valueOf(r210), null, 1784);
        final long r103 = SystemClock.elapsedRealtime();
        int r104 = f.f350834a;
        if (f.a(r310.f350883a) == true) goto L17;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "obtainEngine: invalid bizId: " + r310.f350883a + ", supported: " + f.b());
        FlowRTCEnginePoolTracer r105 = this.f350878d;
        String r111 = r310.f350883a;
        g r106 = this.f350881g;
        if (r106 == null) goto L11;
        String r107 = r106.f350835a;
    L12:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r111, "bizId");
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        FlowRTCEnginePoolTracer.c(r111, r107, 0, -1L, -1, -1, -1, r210, false, FlowRTCEnginePoolTracer.f350613a);
        r311.invoke(FlowRTCEnginePoolObtainResult.FAILED, null);
        return;
    L11:
        r107 = null;
        goto L12
    L17:
        com.larus.im.internal.delegate.a r108 = com.larus.im.internal.delegate.a.f348188b;
        r108.i("FlowRTCEnginePool", "obtainEngine: request: " + r310);
        long r112 = SystemClock.elapsedRealtime();
        Object r113 = this.f350877c;
        monitor-enter(r113);
        final long r114 = SystemClock.elapsedRealtime() - r112;     // Catch: Throwable -> L57
        final g r109 = this.f350881g;     // Catch: Throwable -> L57
        StringBuilder r115 = new StringBuilder("obtainEngine: currentEngine bizId: ");     // Catch: Throwable -> L57
        if (r109 == null) goto L22;
        String r116 = r109.f350835a;     // Catch: Throwable -> L57
    L23:
        r115.append(r116);     // Catch: Throwable -> L57
        r108.i("FlowRTCEnginePool", r115.toString());     // Catch: Throwable -> L57
        final Ref.LongRef r117 = new Ref.LongRef();     // Catch: Throwable -> L57
        r117.element = -1;     // Catch: Throwable -> L57
        if (r109 != null) goto L26;
    L31:
        r108.i("FlowRTCEnginePool", "obtainEngine: create new engine start, bizId: " + r310.f350883a);     // Catch: Throwable -> L57
        final long r118 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L57
        com.larus.im.internal.delegate.w.c r119 = com.larus.im.internal.delegate.w.j().f348360e;     // Catch: Throwable -> L57
        boolean r120 = true;
        if (r119 == null) goto L34;
        boolean r121 = r119.f348331c;     // Catch: Throwable -> L57
    L35:
        com.larus.im.internal.delegate.w.c r122 = com.larus.im.internal.delegate.w.j().f348360e;     // Catch: Throwable -> L57
        if (r122 == null) goto L38;
        boolean r123 = r122.f348332d;     // Catch: Throwable -> L57
    L39:
        if (r123 == true) goto L41;
        boolean r124 = r121;
    L47:
        Object r125 = r113;
        Function1 r126 = new j(r118, this, r310, r109, r103, r117, r114, r210, r311);     // Catch: Throwable -> L55
        if (r124 == false) goto L51;
        BuildersKt.launch$default(this.f350880f, null, null, new FlowRTCEnginePool$execTask$1(r126, null), 3, null);     // Catch: Throwable -> L55
    L52:
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L55
        monitor-exit(r125);
        return;
    L51:
        r126.invoke(Boolean.FALSE);     // Catch: Throwable -> L55
    L55:
        th = th;
    L59:
        monitor-exit(r125);
        throw th;
    L41:
        if (r210 == false) goto L44;
        if (r121 == false) goto L44;
    L45:
        r124 = r120;
    L44:
        r120 = false;
        goto L45
    L38:
        r123 = true;
        goto L39
    L34:
        r121 = true;
        goto L35
    L26:
        if (Intrinsics.areEqual(r109.f350835a, r310.f350883a) == true) goto L28;
        r108.i("FlowRTCEnginePool", "obtainEngine: destroy oldEngine start, bizId: " + r109.f350835a + ", by: " + r310.f350883a);     // Catch: Throwable -> L57
        long r128 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L57
        c(r109.f350835a, r310.f350883a);     // Catch: Throwable -> L57
        r117.element = SystemClock.elapsedRealtime() - r128;     // Catch: Throwable -> L57
        r108.i("FlowRTCEnginePool", "obtainEngine: destroy oldEngine end, bizId: " + r109.f350835a + ", by: " + r310.f350883a);     // Catch: Throwable -> L57
        goto L31
    L28:
        FlowRTCEnginePoolTracer r129 = this.f350878d;     // Catch: Throwable -> L57
        String r130 = r310.f350883a;     // Catch: Throwable -> L57
        String r131 = r109.f350835a;     // Catch: Throwable -> L57
        long r132 = SystemClock.elapsedRealtime() - r103;     // Catch: Throwable -> L57
        r129.getClass();     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r130, "bizId");     // Catch: Throwable -> L57
        FlowRTCEnginePoolTracer.b("obtain_exist", r130, r131, Long.valueOf(r132), null, null, null, null, Boolean.valueOf(r210), Boolean.FALSE, 1264);     // Catch: Throwable -> L57
        r311.invoke(FlowRTCEnginePoolObtainResult.EXISTED, r109);     // Catch: Throwable -> L57
        monitor-exit(r113);
        return;
    L22:
        r116 = null;
    L57:
        th = th;
        r125 = r113;
        goto L59
    L5:
        r110 = null;
        goto L6
    }

    public final void e(String r100, String r110, boolean r111) {
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyBeforeDestroyEngine start: bizId: " + r100 + ", withBizId: " + r110 + ", fromNative: " + r111);
        Iterator<T> r101 = this.f350876b.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        m r102 = (m) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.b(r100, r110);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "notifyBeforeDestroyEngine error: bizId: " + r100 + ", withBizId: " + r110 + ", fromNative: " + r111, r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyBeforeDestroyEngine end: bizId: " + r100 + ", withBizId: " + r110 + ", fromNative: " + r111);
    }

    public final void g(String r100, String r110, boolean r111) {
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyDidDestroyEngine start: bizId: " + r100 + ", withBizId: " + r110 + ", fromNative: " + r111);
        Iterator<T> r101 = this.f350876b.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        m r102 = (m) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.d(r100, r110);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        com.larus.im.internal.delegate.a.f348188b.e("FlowRTCEnginePool", "notifyDidDestroyEngine error: bizId: " + r100 + ", withBizId: " + r110 + ", fromNative: " + r111, r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        com.larus.im.internal.delegate.a.f348188b.i("FlowRTCEnginePool", "notifyDidDestroyEngine end: bizId: " + r100 + ", withBizId: " + r110 + ", fromNative: " + r111);
    }
}
