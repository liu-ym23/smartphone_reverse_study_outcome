package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public OnBackPressedDispatcher$addCancellableCallback$1(Object r8) {
        super(0, r8, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m49invoke() {
        OnBackPressedDispatcher.access$updateEnabledCallbacks((OnBackPressedDispatcher) ((CallableReference) this).receiver);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m49invoke();
        return Unit.INSTANCE;
    }
}
