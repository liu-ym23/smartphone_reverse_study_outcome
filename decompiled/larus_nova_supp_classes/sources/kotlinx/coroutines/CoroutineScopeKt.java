package kotlinx.coroutines;

import android.util.EventsUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.f;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\u0002\u001aJ\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u00020\bH\u0086H¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001b\u001a\n\u0010\u001c\u001a\u00020\u0015*\u00020\u0002\u001a\u0015\u0010\u001d\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005¨\u0006\u001e"}, d2 = {"isActive", XmlPullParser.NO_NAMESPACE, "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", XmlPullParser.NO_NAMESPACE, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentCoroutineContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", XmlPullParser.NO_NAMESPACE, "message", XmlPullParser.NO_NAMESPACE, "cause", XmlPullParser.NO_NAMESPACE, "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class CoroutineScopeKt {
    public static /* synthetic */ void isActive$annotations(CoroutineScope r0) {
    }

    public static final CoroutineScope MainScope() {
        return new f(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    public static final CoroutineScope CoroutineScope(CoroutineContext r3) {
        if (r3.get(Job.Key) != null) goto L7;
        r3 = r3.plus(JobKt.Job$default(null, 1, null));
    L7:
        return new f(r3);
    }

    public static final Object currentCoroutineContext(Continuation<? super CoroutineContext> r0) {
        return r0.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation<? super CoroutineContext> r0) {
        InlineMarker.mark(3);
        throw null;
    }

    public static final void ensureActive(CoroutineScope r0) {
        JobKt.ensureActive(r0.getCoroutineContext());
    }

    public static final boolean isActive(CoroutineScope r1) {
        Job r2 = (Job) r1.getCoroutineContext().get(Job.Key);
        if (r2 != null) goto L7;
        return true;
    L7:
        return r2.isActive();
    }

    public static final void cancel(CoroutineScope r2, CancellationException r3) {
        Job r0 = (Job) r2.getCoroutineContext().get(Job.Key);
        if (r0 == null) goto L7;
        r0.cancel(r3);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r2).toString());
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> r2, Continuation<? super R> r3) {
        kotlinx.coroutines.internal.x r0 = new kotlinx.coroutines.internal.x(r3.getContext(), r3);
        Object r4 = cuc.b.a(r0, r0, r2);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L5:
        return r4;
    }

    public static final CoroutineScope plus(CoroutineScope r1, CoroutineContext r2) {
        return new f(r1.getCoroutineContext().plus(r2));
    }

    public static final void cancel(CoroutineScope r0, String r1, Throwable r2) {
        cancel(r0, u0.a(r1, r2));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        cancel(r0, r1);
    }

    public static /* synthetic */ void cancel$default(CoroutineScope r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        cancel(r0, r1, r2);
    }
}
