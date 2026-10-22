package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/text/input/internal/Api34PerformHandwritingGestureImpl;", "", "<init>", "()V", "performHandwritingGesture", "", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "intConsumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Api34PerformHandwritingGestureImpl {
    public static final Api34PerformHandwritingGestureImpl INSTANCE = null;

    static {
        INSTANCE = new Api34PerformHandwritingGestureImpl();
    }

    private Api34PerformHandwritingGestureImpl() {
    }

    public static /* synthetic */ void a(IntConsumer r0, int r1) {
        performHandwritingGesture$lambda$0(r0, r1);
    }

    private static final void performHandwritingGesture$lambda$0(IntConsumer r0, int r1) {
        r0.accept(r1);
    }

    public final boolean previewHandwritingGesture(TextInputSession r1, PreviewableHandwritingGesture r2, CancellationSignal r3) {
        return r1.previewHandwritingGesture(r2, r3);
    }

    public final void performHandwritingGesture(TextInputSession r1, HandwritingGesture r2, Executor r3, final IntConsumer r4) {
        final int r5 = r1.performHandwritingGesture(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L7;
        r3.execute(new h(r4, r5));
        return;
    L7:
        r4.accept(r5);
    }
}
