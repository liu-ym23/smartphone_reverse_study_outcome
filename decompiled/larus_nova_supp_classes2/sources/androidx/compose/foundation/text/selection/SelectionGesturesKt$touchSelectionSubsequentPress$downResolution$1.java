package androidx.compose.foundation.text.selection;

import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/selection/DownResolution;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1", f = "SelectionGestures.kt", i = {0}, l = {284}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
public final class SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super DownResolution>, Object> {
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ long $pointerId;
    private /* synthetic */ Object L$0;
    int label;

    public SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(long r1, Ref.LongRef r3, Continuation<? super SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1> r4) {
        this.$pointerId = r1;
        this.$overSlop = r3;
        super(2, r4);
    }

    public static /* synthetic */ Unit a(Ref.LongRef r0, PointerInputChange r1, Offset r2) {
        return invokeSuspend$lambda$0(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 r0 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(this.$pointerId, this.$overSlop, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(AwaitPointerEventScope r1, Continuation<? super DownResolution> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AwaitPointerEventScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        AwaitPointerEventScope r3 = (AwaitPointerEventScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        if (((PointerInputChange) r8) != null) goto L15;
    L21:
        PointerInputChange r9 = (PointerInputChange) CollectionsKt.first(r3.getCurrentEvent().getChanges());
        if (PointerEventKt.changedToUpIgnoreConsumed(r9) == false) goto L25;
        r9.consume();
        return DownResolution.Up;
    L25:
        return DownResolution.Cancel;
    L15:
        if ((this.$overSlop.element & SieveCacheKt.InvalidMapping) != 9205357640488583168L) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L21;
        return DownResolution.Drag;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        AwaitPointerEventScope r10 = (AwaitPointerEventScope) this.L$0;
        long r4 = this.$pointerId;
        final Ref.LongRef r5 = this.$overSlop;
        Function2 r6 = new i0(r5);
        this.L$0 = r10;
        this.label = 1;
        Object r7 = DragGestureDetectorKt.m578awaitTouchSlopOrCancellationjO51t88(r10, r4, r6, this);
        if (r7 != r0) goto L11;
        return r0;
    L11:
        r3 = r10;
        r8 = r7;
        goto L13
    }

    private static final Unit invokeSuspend$lambda$0(Ref.LongRef r0, PointerInputChange r1, Offset r2) {
        r1.consume();
        r0.element = r2.unbox-impl();
        return Unit.INSTANCE;
    }
}
