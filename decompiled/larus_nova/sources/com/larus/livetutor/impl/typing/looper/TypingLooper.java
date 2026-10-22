package com.larus.livetutor.impl.typing.looper;

import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.typing.rhythm.ITypingRhythmController;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes30.dex */
public final class TypingLooper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f356605h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoroutineScope f356606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITypingRhythmController f356607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f356608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f356609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ITypingRhythmController.Beat f356610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f356611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f356612g;

    public static final class a {
    }

    public interface b {
        TypingStreamStatus a();

        int b();

        int c();

        int d();

        boolean e();
    }

    public interface c {
        Object e(int r100, long r101, Continuation<? super Unit> r102);
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("TypingLooper", "TypingLooper, TypingLooper coroutine launch error ", r101);
        }
    }

    static {
    }

    public static CoroutineScope a() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()).plus(new d(CoroutineExceptionHandler.Key)));
    }

    public final void b() {
        if (this.f356611f == false) goto L5;
        return;
    L5:
        this.f356611f = true;
        if (CoroutineScopeKt.isActive(this.f356606a) == false) goto L8;
        CoroutineScopeKt.cancel$default(this.f356606a, null, 1, null);
    L8:
        CoroutineScope r100 = a();
        this.f356606a = r100;
        UtilsKt.m(r100, null, new TypingLooper$startLoop$1(this, null), 3);
    }

    public TypingLooper() {
        this.f356606a = a();
        this.f356610e = new ITypingRhythmController.Beat(1, 20);
    }
}
