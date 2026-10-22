package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.EventsUtils;
import android.view.Choreographer;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\b\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\t\u001a\u000e\u0010\n\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\t\u001a\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u001d\u0010\u0010\u001a\u00020\u0003*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\b\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"MAX_DELAY", XmlPullParser.NO_NAMESPACE, "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFrameSlowPath", "postFrameCallback", XmlPullParser.NO_NAMESPACE, "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", XmlPullParser.NO_NAMESPACE, "from", "asHandler", "Landroid/os/Looper;", "async", XmlPullParser.NO_NAMESPACE, "kotlinx-coroutines-android"}, k = 2, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 4611686018427387903L;
    public static final HandlerDispatcher Main = null;
    private static volatile Choreographer choreographer;

    public static /* synthetic */ void a(i r0, long r1) {
        postFrameCallback$lambda$6(r0, r1);
    }

    public static final HandlerDispatcher from(Handler r2) {
        return from$default(r2, null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void getMain$annotations() {
    }

    static {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true)));     // Catch: Throwable -> L4
    L7:
        if (Result.m55isFailureimpl(r1) == false) goto L9;
        r1 = null;
    L9:
        Main = (HandlerDispatcher) r1;
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ Object access$awaitFrameSlowPath(Continuation r0) {
        return awaitFrameSlowPath(r0);
    }

    public static final /* synthetic */ void access$updateChoreographerAndPostFrameCallback(i r0) {
        updateChoreographerAndPostFrameCallback(r0);
    }

    public static final Object awaitFrame(Continuation<? super Long> r4) {
        Choreographer r0 = choreographer;
        if (r0 == null) goto L9;
        j r1 = new j(IntrinsicsKt.intercepted(r4), 1);
        r1.C();
        access$postFrameCallback(r0, r1);
        Object r2 = r1.B();
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L7:
        return r2;
    L9:
        return awaitFrameSlowPath(r4);
    }

    private static final Object awaitFrameSlowPath(Continuation<? super Long> r4) {
        j r0 = new j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        access$updateChoreographerAndPostFrameCallback(r0);
    L6:
        Object r1 = r0.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L9:
        return r1;
    L5:
        Dispatchers.getMain().dispatch(r0.getContext(), new a(r0));
        goto L6
    }

    private static final void updateChoreographerAndPostFrameCallback(i<? super Long> r1) {
        Choreographer r0 = choreographer;
        if (r0 != null) goto L5;
        r0 = Choreographer.getInstance();
        Intrinsics.checkNotNull(r0);
        choreographer = r0;
    L5:
        postFrameCallback(r0, r1);
    }

    public static final /* synthetic */ void access$postFrameCallback(Choreographer r0, i r1) {
        postFrameCallback(r0, r1);
    }

    public static final Handler asHandler(Looper r7, boolean r8) {
        if (r8 == false) goto L13;
        if (Build.VERSION.SDK_INT < 28) goto L14;
        Object r9 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r7});
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) r9;
    L14:
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r7, null, Boolean.TRUE});
    L11:
        return new Handler(r7);
    L13:
        return new Handler(r7);
    }

    public static final HandlerDispatcher from(Handler r2, String r3) {
        return new HandlerContext(r2, r3, false);
    }

    private static final void postFrameCallback(Choreographer r1, i<? super Long> r2) {
        r1.postFrameCallback(new d(r2));
    }

    private static final void postFrameCallback$lambda$6(i r1, long r2) {
        r1.f(Dispatchers.getMain(), Long.valueOf(r2));
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return from(r0, r1);
    }
}
