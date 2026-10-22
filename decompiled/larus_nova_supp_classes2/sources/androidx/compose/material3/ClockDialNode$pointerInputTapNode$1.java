package androidx.compose.material3;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ClockDialNode$pointerInputTapNode$1 implements PointerInputEventHandler {
    final /* synthetic */ ClockDialNode this$0;

    /* JADX INFO: renamed from: androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputTapNode$1$1", f = "TimePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ ClockDialNode this$0;

        public AnonymousClass1(ClockDialNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
            return m2437invoked4ec7I((PressGestureScope) r3, ((Offset) r4).unbox-impl(), (Continuation) r5);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m2437invoked4ec7I(PressGestureScope r2, long r3, Continuation<? super Unit> r5) {
            AnonymousClass1 r4 = new AnonymousClass1(this.this$0, r5);
            r4.J$0 = r3;
            return r4.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            long r0 = this.J$0;
            ClockDialNode.access$setOffsetX$p(this.this$0, Float.intBitsToFloat((int) (r0 >> 32)));
            ClockDialNode.access$setOffsetY$p(this.this$0, Float.intBitsToFloat((int) (r0 & 4294967295L)));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ClockDialNode$pointerInputTapNode$1(ClockDialNode r1) {
        this.this$0 = r1;
    }

    public static /* synthetic */ Unit a(ClockDialNode r0, Offset r1) {
        return invoke$lambda$0(r0, r1);
    }

    private static final Unit invoke$lambda$0(ClockDialNode r6, Offset r7) {
        BuildersKt.launch$default(r6.getCoroutineScope(), null, null, new ClockDialNode$pointerInputTapNode$1$2$1(r6, r7, null), 3, null);
        return Unit.INSTANCE;
    }

    public final Object invoke(PointerInputScope r9, Continuation<? super Unit> r10) {
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        final ClockDialNode r0 = this.this$0;
        Object r11 = TapGestureDetectorKt.detectTapGestures$default(r9, null, null, r3, new e4(r0), r10, 3, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
