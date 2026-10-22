package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.EditCommand;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013J,\u0010\u0015\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/Api34LegacyPerformHandwritingGestureImpl;", "", "<init>", "()V", "performHandwritingGesture", "", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Api34LegacyPerformHandwritingGestureImpl {
    public static final Api34LegacyPerformHandwritingGestureImpl INSTANCE = null;

    static {
        INSTANCE = new Api34LegacyPerformHandwritingGestureImpl();
    }

    private Api34LegacyPerformHandwritingGestureImpl() {
    }

    public static /* synthetic */ void a(IntConsumer r0, int r1) {
        performHandwritingGesture$lambda$0(r0, r1);
    }

    private static final void performHandwritingGesture$lambda$0(IntConsumer r0, int r1) {
        r0.accept(r1);
    }

    public final boolean previewHandwritingGesture(LegacyTextFieldState r2, TextFieldSelectionManager r3, PreviewableHandwritingGesture r4, CancellationSignal r5) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return HandwritingGestureApi34.INSTANCE.previewHandwritingGesture$foundation_release(r2, r4, r3, r5);
    }

    public final void performHandwritingGesture(LegacyTextFieldState r7, TextFieldSelectionManager r8, HandwritingGesture r9, ViewConfiguration r10, Executor r11, final IntConsumer r12, Function1<? super EditCommand, Unit> r13) {
        if (r7 == null) goto L4;
        final int r14 = HandwritingGestureApi34.INSTANCE.performHandwritingGesture$foundation_release(r7, r9, r8, r10, r13);
    L5:
        if (r12 != null) goto L7;
        return;
    L7:
        if (r11 == null) goto L9;
        r11.execute(new g(r12, r14));
        return;
    L9:
        r12.accept(r14);
        return;
    L4:
        r14 = 3;
        goto L5
    }
}
