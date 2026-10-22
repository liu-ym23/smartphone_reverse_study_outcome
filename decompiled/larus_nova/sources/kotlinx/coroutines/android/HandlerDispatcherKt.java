package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\b\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\t\u001a\u000e\u0010\n\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\t\u001a\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u001d\u0010\u0010\u001a\u00020\u0003*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\b\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 4611686018427387903L;
    public static final HandlerDispatcher Main = null;
    private static volatile Choreographer choreographer;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f504626a;

        public a(j r100) {
            this.f504626a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback(this.f504626a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ void a(i r100, long r101) {
        postFrameCallback$lambda$6(r100, r101);
    }

    public static final HandlerDispatcher from(Handler r100) {
        return from$default(r100, null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void getMain$annotations() {
    }

    static {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true)));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        Main = (HandlerDispatcher) r101;
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ Object access$awaitFrameSlowPath(Continuation r100) {
        return awaitFrameSlowPath(r100);
    }

    public static final /* synthetic */ void access$updateChoreographerAndPostFrameCallback(i r100) {
        updateChoreographerAndPostFrameCallback(r100);
    }

    public static final Object awaitFrame(Continuation<? super Long> r100) {
        Choreographer r101 = choreographer;
        if (r101 == null) goto L9;
        j r102 = new j(IntrinsicsKt.intercepted(r100), 1);
        r102.C();
        access$postFrameCallback(r101, r102);
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L7:
        return r103;
    L9:
        return awaitFrameSlowPath(r100);
    }

    private static final Object awaitFrameSlowPath(Continuation<? super Long> r100) {
        j r101 = new j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        access$updateChoreographerAndPostFrameCallback(r101);
    L6:
        Object r102 = r101.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L9:
        return r102;
    L5:
        Dispatchers.getMain().dispatch(r101.getContext(), new a(r101));
        goto L6
    }

    private static final void updateChoreographerAndPostFrameCallback(i<? super Long> r100) {
        Choreographer r101 = choreographer;
        if (r101 != null) goto L5;
        r101 = Choreographer.getInstance();
        Intrinsics.checkNotNull(r101);
        choreographer = r101;
    L5:
        postFrameCallback(r101, r100);
    }

    public static final /* synthetic */ void access$postFrameCallback(Choreographer r100, i r101) {
        postFrameCallback(r100, r101);
    }

    public static final Handler asHandler(Looper r100, boolean r101) {
        if (r101 == false) goto L13;
        if (Build.VERSION.SDK_INT < 28) goto L14;
        Object r102 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r100});
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) r102;
    L14:
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r100, null, Boolean.TRUE});
    L11:
        return new Handler(r100);
    L13:
        return new Handler(r100);
    }

    public static final HandlerDispatcher from(Handler r100, String r101) {
        return new HandlerContext(r100, r101, false);
    }

    private static final void postFrameCallback(Choreographer r100, final i<? super Long> r101) {
        r100.postFrameCallback(new d(r101));
    }

    private static final void postFrameCallback$lambda$6(i r100, long r101) {
        r100.f(Dispatchers.getMain(), Long.valueOf(r101));
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return from(r100, r101);
    }
}
