package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0080@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"detectPressDownGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;", "onUp", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PressDownGestureKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2", f = "PressDownGesture.kt", i = {0, 1, 1}, l = {31, 37}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapOnPosition $onDown;
        final /* synthetic */ Function0<Unit> $onUp;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(TapOnPosition r1, Function0<Unit> r2, Continuation<? super AnonymousClass2> r3) {
            this.$onDown = r1;
            this.$onUp = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$onDown, this.$onUp, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0068 -> B:19:0x006b). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r17) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            PointerInputChange r1 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope r2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r17);
            Object r3 = r17;
            AnonymousClass2 r4 = this;
        L19:
            List r5 = ((PointerEvent) r3).getChanges();
            int r6 = r5.size();
            boolean r8 = false;
            int r10 = 0;
        L20:
            if (r10 >= r6) goto L30;
            PointerInputChange r11 = (PointerInputChange) ListProtector.get(r5, r10);
            if (PointerId.equals-impl0(r11.getId-J3iCeTQ(), r1.getId-J3iCeTQ()) == true) goto L24;
        L26:
            boolean r12 = false;
        L27:
            if (r12 == true) goto L28;
            r10 = r10 + 1;
            goto L20
        L28:
            r8 = true;
            goto L30
        L24:
            if (r11.getPressed() == false) goto L26;
            r12 = true;
        L30:
            if (r8 == false) goto L31;
        L16:
            r4.L$0 = r2;
            r4.L$1 = r1;
            r4.label = 2;
            r3 = AwaitPointerEventScope.-CC.awaitPointerEvent$default(r2, null, r4, 1, null);
            if (r3 != r7) goto L19;
            return r7;
        L31:
            r4.$onUp.invoke();
        L33:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            AwaitPointerEventScope r9 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(r17);
            AwaitPointerEventScope r13 = r9;
            Object r14 = r17;
        L13:
            r1 = (PointerInputChange) r14;
            this.$onDown.mo1701onEventk4lQ0M(r1.getPosition-F1C5BW0());
            if (this.$onUp == null) goto L33;
            r4 = this;
            r2 = r13;
            goto L16
        L10:
            ResultKt.throwOnFailure(r17);
            r13 = (AwaitPointerEventScope) this.L$0;
            this.L$0 = r13;
            this.label = 1;
            r14 = TapGestureDetectorKt.awaitFirstDown$default(r13, false, null, this, 2, null);
            if (r14 != r7) goto L13;
            return r7;
        }
    }

    public static final Object detectPressDownGesture(PointerInputScope r2, TapOnPosition r3, Function0<Unit> r4, Continuation<? super Unit> r5) {
        Object r6 = ForEachGestureKt.awaitEachGesture(r2, new AnonymousClass2(r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectPressDownGesture$default(PointerInputScope r0, TapOnPosition r1, Function0 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return detectPressDownGesture(r0, r1, r2, r3);
    }
}
