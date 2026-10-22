package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1", f = "AppBar.kt", i = {}, l = {1344}, m = "invokeSuspend", n = {}, s = {})
public final class AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomAppBarScrollBehavior $activeScrollBehavior;
    /* synthetic */ float F$0;
    int label;

    public AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1(BottomAppBarScrollBehavior r1, Continuation<? super AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1> r2) {
        this.$activeScrollBehavior = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((CoroutineScope) r1, ((Number) r2).floatValue(), (Continuation) r3);
    }

    public final Object invoke(CoroutineScope r2, float r3, Continuation<? super Unit> r4) {
        AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1 r5 = new AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1(this.$activeScrollBehavior, r4);
        r5.F$0 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
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
        float r7 = this.F$0;
        BottomAppBarState r2 = this.$activeScrollBehavior.getState();
        DecayAnimationSpec<Float> r3 = this.$activeScrollBehavior.getFlingAnimationSpec();
        AnimationSpec<Float> r4 = this.$activeScrollBehavior.getSnapAnimationSpec();
        this.label = 1;
        if (AppBarKt.access$settleAppBarBottom(r2, r7, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
