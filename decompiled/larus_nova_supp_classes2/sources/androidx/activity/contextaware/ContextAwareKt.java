package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u0007H\u0001¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0001*\u00020\u00032\u001e\b\u0004\u0010\u0004\u001a\u0018\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u0002\u0012\t\u0012\u0007H\u0001¢\u0006\u0002\b\u00020\u0005H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"withContextAvailable", "R", "Lkotlin/jvm/JvmSuppressWildcards;", "Landroidx/activity/contextaware/ContextAware;", "onContextAvailable", "Lkotlin/Function1;", "Landroid/content/Context;", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware r3, Function1<Context, R> r4, Continuation<R> r5) {
        Context r0 = r3.peekAvailableContext();
        if (r0 != null) goto L5;
        j r1 = new j(IntrinsicsKt.intercepted(r5), 1);
        r1.C();
        ContextAwareKt$withContextAvailable$2$listener$1 r2 = new ContextAwareKt$withContextAvailable$2$listener$1(r1, r4);
        r3.addOnContextAvailableListener(r2);
        r1.i(new ContextAwareKt$withContextAvailable$2$1(r3, r2));
        Object r6 = r1.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L9:
        return r6;
    L5:
        return r4.invoke(r0);
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware r3, Function1<Context, R> r4, Continuation<R> r5) {
        Context r0 = r3.peekAvailableContext();
        if (r0 != null) goto L5;
        InlineMarker.mark(0);
        j r1 = new j(IntrinsicsKt.intercepted(r5), 1);
        r1.C();
        ContextAwareKt$withContextAvailable$2$listener$1 r2 = new ContextAwareKt$withContextAvailable$2$listener$1(r1, r4);
        r3.addOnContextAvailableListener(r2);
        r1.i(new ContextAwareKt$withContextAvailable$2$1(r3, r2));
        Unit r6 = Unit.INSTANCE;
        Object r7 = r1.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L9:
        InlineMarker.mark(1);
        return r7;
    L5:
        return r4.invoke(r0);
    }
}
