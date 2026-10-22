package androidx.compose.material3;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt$Scrim$dismissModalRail$1$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<Boolean> $dismiss$delegate;

    public WideNavigationRailKt$Scrim$dismissModalRail$1$1(MutableState<Boolean> r1) {
        this.$dismiss$delegate = r1;
    }

    public static /* synthetic */ Unit a(MutableState r0, Offset r1) {
        return invoke$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$0(MutableState r0, Offset r1) {
        WideNavigationRailKt.access$Scrim_3J_VO9M$lambda$29(r0, true);
        return Unit.INSTANCE;
    }

    public final Object invoke(PointerInputScope r9, Continuation<? super Unit> r10) {
        final MutableState<Boolean> r0 = this.$dismiss$delegate;
        Object r11 = TapGestureDetectorKt.detectTapGestures$default(r9, null, null, null, new ly(r0), r10, 7, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
