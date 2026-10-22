package com.larus.livetutor.impl.typing.service;

import com.larus.livetutor.impl.typing.datasource.StreamData;
import com.larus.livetutor.impl.typing.enumeration.TypingMode;
import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.typing.looper.TypingLooper;
import com.larus.livetutor.impl.typing.rhythm.ITypingRhythmController;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import lw8.l;

/* JADX INFO: loaded from: classes30.dex */
public final class TypingService implements com.larus.livetutor.impl.typing.service.a, com.larus.livetutor.impl.typing.datasource.a.b, TypingLooper.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoroutineScope f356613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f356614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypingMode f356615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ITypingRhythmController f356616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f356617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.larus.livetutor.impl.typing.service.b> f356618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qj9.b f356619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f356620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f356621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile int f356622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile int f356623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f356624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f356625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile StringBuffer f356626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile CharSequence f356627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile l f356628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile TypingStreamStatus f356629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f356630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile long f356631t;

    public static final class a {
    }

    public interface b {
        void a(TextContent r100, TypingStreamStatus r101, TypingMode r102);

        void b(TextContent r100, int r101, TypingMode r102);

        void c(int r100, TypingMode r101);
    }

    static {
    }

    @Override // com.larus.livetutor.impl.typing.datasource.a.b
    public final void f() {
        FLogger.f375446a.i("TypingService", "TypingService, " + this.f356614c + ", onStreamDataReceiveStart, thread: " + ThreadMethodProxy.currentThread().getName() + '.');
        if (CoroutineScopeKt.isActive(this.f356613b) == false) goto L5;
        CoroutineScopeKt.cancel$default(this.f356613b, null, 1, null);
    L5:
        this.f356613b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new e(CoroutineExceptionHandler.Key)));
        this.f356625n = 0;
        this.f356631t = 0;
        this.f356630s = false;
        TypingStreamStatus r100 = TypingStreamStatus.Streaming;
        this.f356629r = r100;
        UtilsKt.m(this.f356613b, Dispatchers.getMain(), new TypingService$dispatchTypingStreamStatus$1(this, r100, null), 2);
        this.f356626o = new StringBuffer();
        this.f356627p = "";
        this.f356622k = 0;
        this.f356623l = 0;
    }

    @Override // com.larus.livetutor.impl.typing.datasource.a.b
    public final void h() {
        UtilsKt.m(this.f356613b, null, new TypingService$onStreamDataReceiveFinish$1(this, null), 3);
    }

    public final void m() {
        UtilsKt.m(this.f356613b, null, new TypingService$updateTextNow$1(this, null), 3);
    }

    public TypingService() {
        this.f356613b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new e(CoroutineExceptionHandler.Key)));
        this.f356614c = "NormalTypingService";
        this.f356615d = TypingMode.CharByCharTypingMode;
        this.f356618g = new CopyOnWriteArrayList();
        this.f356620i = LazyKt.lazy(new c());
        this.f356621j = LazyKt.lazy(new d(this));
        UUID.randomUUID().toString();
        this.f356626o = new StringBuffer(0);
        this.f356627p = "";
        this.f356629r = TypingStreamStatus.Initial;
    }

    @Override // com.larus.livetutor.impl.typing.service.a
    public final TypingStreamStatus a() {
        return this.f356629r;
    }

    @Override // com.larus.livetutor.impl.typing.datasource.a.b
    public final String i() {
        return this.f356614c;
    }

    public static final boolean j(TypingService r100) {
        TypingMode r101 = r100.f356615d;
        if (r101 != TypingMode.CharByCharTypingMode) goto L5;
    L8:
        return true;
    L5:
        if (r101 == TypingMode.MaskErasureTypingMode) goto L8;
        return false;
    }

    public static final void l(TypingService r100) {
        if (r100.f356629r != TypingStreamStatus.Streaming) goto L5;
    L6:
        ((TypingLooper) r100.f356620i.getValue()).b();
        FLogger.f375446a.i("TypingService", "startTypingLooper");
        return;
    L5:
        if (r100.f356629r == TypingStreamStatus.Pause) goto L6;
    }

    @Override // com.larus.livetutor.impl.typing.datasource.a.b
    public final void b(StreamData r100) {
        Intrinsics.checkNotNullParameter(r100, "streamData");
        this.f356626o = new StringBuffer(r100.getText());
        UtilsKt.m(this.f356613b, null, new TypingService$onStreamDataOverwrite$1(this, r100, null), 3);
    }

    @Override // com.larus.livetutor.impl.typing.datasource.a.b
    public final void c(StreamData r100) {
        Intrinsics.checkNotNullParameter(r100, "streamData");
        this.f356626o.append(r100.getText());
        this.f356622k++;
        if (RangesKt.coerceAtLeast((this.f356627p.length() - this.f356625n) - 1, 0) > 0) goto L5;
        this.f356623l++;
    L5:
        UtilsKt.m(this.f356613b, null, new TypingService$onStreamDataAppend$1(this, r100, null), 3);
    }

    @Override // com.larus.livetutor.impl.typing.datasource.a.b
    public final void d(StreamData r100) {
        Intrinsics.checkNotNullParameter(r100, "streamData");
        this.f356626o = new StringBuffer(r100.getText());
        if (this.f356629r != TypingStreamStatus.Pause) goto L5;
        boolean r101 = true;
    L6:
        UtilsKt.m(this.f356613b, null, new TypingService$onFinalStreamDataFlush$1(this, r100, r101, null), 3);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.livetutor.impl.typing.service.a
    public final void g(qj9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        this.f356619h = r100;
        UtilsKt.m(this.f356613b, null, new TypingService$setMarkdownParser$1(this, null), 3);
    }

    public final Object n(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        if (this.f356629r == TypingStreamStatus.Pause) goto L12;
        if (this.f356629r == TypingStreamStatus.Stop) goto L12;
        Object r102 = BuildersKt.withContext(Dispatchers.getMain(), new TypingService$updateTextWithCheck$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r102;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    }

    @Override // com.larus.livetutor.impl.typing.looper.TypingLooper.c
    public final Object e(int r110, long r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof TypingService$onTyping$1) == false) goto L7;
        TypingService$onTyping$1 r100 = (TypingService$onTyping$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        TypingService$onTyping$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L19;
        if (r105 == 1) goto L18;
        if (r105 != 2) goto L17;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
    L43:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L47:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
    L39:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r103);
        if (this.f356627p.length() != 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == true) goto L49;
        if (this.f356629r == TypingStreamStatus.Finish) goto L49;
        if (this.f356629r == TypingStreamStatus.Stop) goto L49;
        int r107 = RangesKt.coerceAtMost(this.f356625n + r110, this.f356627p.length() - 1);
        if (r107 == this.f356625n) goto L32;
        this.f356625n = r107;
        if (this.f356615d != TypingMode.MaskErasureTypingMode) goto L40;
        Function1<? super Continuation<? super Unit>, ? extends Object> r113 = new TypingService$onTyping$2(this, r110, r111, null);
        r102.label = 1;
        if (n(r113, r102) != r104) goto L39;
        return r104;
    L40:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L14
        Function1<? super Continuation<? super Unit>, ? extends Object> r114 = new TypingService$onTyping$3$1(this, this.f356627p.subSequence(0, this.f356625n + 1), r110, r111, null);     // Catch: Throwable -> L14
        r102.label = 2;     // Catch: Throwable -> L14
        if (n(r114, r102) != r104) goto L43;
        return r104;
    L32:
        return Unit.INSTANCE;
    L49:
        return Unit.INSTANCE;
    L22:
        r106 = false;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new TypingService$onTyping$1(this, r112);
        goto L8
    }

    public static final Object k(TypingService r100, CharSequence r101, long r102, Continuation r110) {
        r100.getClass();
        return CoroutineScopeKt.coroutineScope(new TypingService$parseMarkdown$2(r100, r101, r102, null), r110);
    }
}
