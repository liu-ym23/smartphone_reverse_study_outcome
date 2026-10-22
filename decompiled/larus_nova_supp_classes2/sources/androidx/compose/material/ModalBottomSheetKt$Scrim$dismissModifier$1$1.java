package androidx.compose.material;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt$Scrim$dismissModifier$1$1 implements PointerInputEventHandler {
    final /* synthetic */ Function0<Unit> $onDismiss;

    public ModalBottomSheetKt$Scrim$dismissModifier$1$1(Function0<Unit> r1) {
        this.$onDismiss = r1;
    }

    public static /* synthetic */ Unit a(Function0 r0, Offset r1) {
        return invoke$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$0(Function0 r0, Offset r1) {
        r0.invoke();
        return Unit.INSTANCE;
    }

    public final Object invoke(PointerInputScope r9, Continuation<? super Unit> r10) {
        final Function0<Unit> r0 = this.$onDismiss;
        Object r11 = TapGestureDetectorKt.detectTapGestures$default(r9, null, null, null, new s6(r0), r10, 7, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
