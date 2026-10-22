package defpackage;

import androidx.lifecycle.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes42.dex */
public final class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle r100, Lifecycle.State r101, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super Unit> r103) {
        if (r101 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L17;
        if (r100.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        Object r105 = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(r100, r101, r102, null), r103);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r105;
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r104 = false;
        goto L6
    }
}
