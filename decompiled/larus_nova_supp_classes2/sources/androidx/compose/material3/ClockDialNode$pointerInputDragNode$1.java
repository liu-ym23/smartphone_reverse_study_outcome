package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ClockDialNode$pointerInputDragNode$1 implements PointerInputEventHandler {
    final /* synthetic */ ClockDialNode this$0;

    public ClockDialNode$pointerInputDragNode$1(ClockDialNode r1) {
        this.this$0 = r1;
    }

    public static /* synthetic */ Unit a(ClockDialNode r0) {
        return invoke$lambda$0(r0);
    }

    public static /* synthetic */ Unit b(ClockDialNode r0, PointerInputChange r1, Offset r2) {
        return invoke$lambda$1(r0, r1, r2);
    }

    private static final Unit invoke$lambda$0(ClockDialNode r6) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new ClockDialNode$pointerInputDragNode$1$1$1(r6, null), 3, null);
        return Unit.INSTANCE;
    }

    public final Object invoke(PointerInputScope r9, Continuation<? super Unit> r10) {
        final ClockDialNode r0 = this.this$0;
        Object r11 = DragGestureDetectorKt.detectDragGestures$default(r9, null, new c4(r0), null, new d4(r0), r10, 5, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$1(ClockDialNode r6, PointerInputChange r7, Offset r8) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new ClockDialNode$pointerInputDragNode$1$2$1(r6, r8, null), 3, null);
        return Unit.INSTANCE;
    }
}
