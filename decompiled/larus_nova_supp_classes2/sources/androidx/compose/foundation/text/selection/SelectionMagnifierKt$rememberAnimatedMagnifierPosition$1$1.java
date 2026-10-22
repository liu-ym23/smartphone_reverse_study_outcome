package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1", f = "SelectionMagnifier.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
public final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Offset, AnimationVector2D> $animatable;
    final /* synthetic */ State<Offset> $targetValue$delegate;
    private /* synthetic */ Object L$0;
    int label;

    public SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(State<Offset> r1, Animatable<Offset, AnimationVector2D> r2, Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1> r3) {
        this.$targetValue$delegate = r1;
        this.$animatable = r2;
        super(2, r3);
    }

    public static /* synthetic */ Offset a(State r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 r0 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(this.$targetValue$delegate, this.$animatable, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final Offset invokeSuspend$lambda$0(State r2) {
        return Offset.box-impl(SelectionMagnifierKt.access$rememberAnimatedMagnifierPosition$lambda$3(r2));
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final CoroutineScope r7 = (CoroutineScope) this.L$0;
        final State<Offset> r2 = this.$targetValue$delegate;
        Flow r3 = SnapshotStateKt.snapshotFlow(new n0(r2));
        final Animatable<Offset, AnimationVector2D> r4 = this.$animatable;
        FlowCollector r5 = new AnonymousClass2(r4, r7);
        this.label = 1;
        if (r3.collect(r5, this) != r0) goto L12;
        return r0;
    }
}
