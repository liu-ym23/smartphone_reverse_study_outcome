package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ClickableTextKt$ClickableText$pressIndicator$1$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<Integer, Unit> $onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public ClickableTextKt$ClickableText$pressIndicator$1$1(MutableState<TextLayoutResult> r1, Function1<? super Integer, Unit> r2) {
        this.$layoutResult = r1;
        this.$onClick = r2;
    }

    public static /* synthetic */ Unit a(MutableState r0, Function1 r1, Offset r2) {
        return invoke$lambda$1(r0, r1, r2);
    }

    public final Object invoke(PointerInputScope r9, Continuation<? super Unit> r10) {
        final MutableState<TextLayoutResult> r0 = this.$layoutResult;
        final Function1<Integer, Unit> r4 = this.$onClick;
        Object r11 = TapGestureDetectorKt.detectTapGestures$default(r9, null, null, null, new m1(r0, r4), r10, 7, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit invoke$lambda$1(MutableState r2, Function1 r3, Offset r4) {
        TextLayoutResult r5 = (TextLayoutResult) r2.getValue();
        if (r5 == null) goto L6;
        r3.invoke(Integer.valueOf(r5.getOffsetForPosition-k-4lQ0M(r4.unbox-impl())));
    L6:
        return Unit.INSTANCE;
    }
}
