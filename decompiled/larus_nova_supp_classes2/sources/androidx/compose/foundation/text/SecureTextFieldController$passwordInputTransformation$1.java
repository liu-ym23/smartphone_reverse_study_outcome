package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SecureTextFieldController$passwordInputTransformation$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public SecureTextFieldController$passwordInputTransformation$1(Object r8) {
        super(0, r8, SecureTextFieldController.class, "scheduleHide", "scheduleHide()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1438invoke() {
        SecureTextFieldController.access$scheduleHide((SecureTextFieldController) ((CallableReference) this).receiver);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1438invoke();
        return Unit.INSTANCE;
    }
}
