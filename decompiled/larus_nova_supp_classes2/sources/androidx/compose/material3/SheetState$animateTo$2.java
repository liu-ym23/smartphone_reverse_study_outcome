package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.AnchoredDragScope;
import androidx.compose.material3.internal.DraggableAnchors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SheetState$animateTo$2", f = "SheetDefaults.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
public final class SheetState$animateTo$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<SheetValue>, SheetValue, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ SheetState this$0;

    public SheetState$animateTo$2(SheetState r1, float r2, FiniteAnimationSpec<Float> r3, Continuation<? super SheetState$animateTo$2> r4) {
        this.this$0 = r1;
        this.$velocity = r2;
        this.$animationSpec = r3;
        super(4, r4);
    }

    public static /* synthetic */ Unit a(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
        return invokeSuspend$lambda$0(r0, r1, r2, r3);
    }

    public final Object invoke(AnchoredDragScope r5, DraggableAnchors<SheetValue> r6, SheetValue r7, Continuation<? super Unit> r8) {
        SheetState$animateTo$2 r0 = new SheetState$animateTo$2(this.this$0, this.$velocity, this.$animationSpec, r8);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.L$2 = r7;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, (SheetValue) r3, (Continuation) r4);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        final AnchoredDragScope r12 = (AnchoredDragScope) this.L$0;
        float r5 = ((DraggableAnchors) this.L$1).positionOf((SheetValue) this.L$2);
        if (Float.isNaN(r5) == true) goto L18;
        final Ref.FloatRef r2 = new Ref.FloatRef();
        if (Float.isNaN(this.this$0.getOffset$material3()) == false) goto L13;
        float r4 = MenuKt.ClosedAlphaTarget;
    L14:
        r2.element = r4;
        float r6 = this.$velocity;
        FiniteAnimationSpec<Float> r7 = this.$animationSpec;
        Function2 r8 = new jo(r12, r2);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 1;
        if (SuspendAnimationKt.animate(r4, r5, r6, r7, r8, this) != r0) goto L18;
        return r0;
    L13:
        r4 = this.this$0.getOffset$material3();
        goto L14
    }

    private static final Unit invokeSuspend$lambda$0(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
        r0.dragTo(r2, r3);
        r1.element = r2;
        return Unit.INSTANCE;
    }
}
