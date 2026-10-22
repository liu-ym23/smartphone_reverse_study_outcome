package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SearchBarKt$SearchBar$3$1", f = "SearchBar.kt", i = {}, l = {559}, m = "invokeSuspend", n = {}, s = {})
public final class SearchBarKt$SearchBar$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    int label;

    public SearchBarKt$SearchBar$3$1(Animatable<Float, AnimationVector1D> r1, boolean r2, MutableFloatState r3, MutableState<BackEventCompat> r4, MutableState<BackEventCompat> r5, Continuation<? super SearchBarKt$SearchBar$3$1> r6) {
        this.$animationProgress = r1;
        this.$expanded = r2;
        this.$finalBackProgress = r3;
        this.$firstBackEvent = r4;
        this.$currentBackEvent = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SearchBarKt$SearchBar$3$1(this.$animationProgress, this.$expanded, this.$finalBackProgress, this.$firstBackEvent, this.$currentBackEvent, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L33:
        if (this.$expanded == true) goto L36;
        this.$finalBackProgress.setFloatValue(Float.NaN);
        this.$firstBackEvent.setValue(null);
        this.$currentBackEvent.setValue(null);
    L36:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        float r2 = 1.0f;
        boolean r3 = false;
        if (this.$animationProgress.getValue().floatValue() > MenuKt.ClosedAlphaTarget) goto L11;
    L13:
        boolean r15 = false;
    L14:
        if (r15 == false) goto L18;
        FiniteAnimationSpec r16 = SearchBarKt.access$getAnimationPredictiveBackExitFloatSpec$p();
    L16:
        FiniteAnimationSpec r7 = r16;
        if (this.$expanded == true) goto L26;
        r2 = MenuKt.ClosedAlphaTarget;
    L26:
        if (this.$animationProgress.getValue().floatValue() != r2) goto L28;
        r3 = true;
    L28:
        if (r3 == true) goto L33;
        Animatable<Float, AnimationVector1D> r5 = this.$animationProgress;
        Float r6 = Boxing.boxFloat(r2);
        this.label = 1;
        if (Animatable.animateTo$default(r5, r6, r7, null, null, this, 12, null) != r0) goto L33;
        return r0;
    L18:
        if (this.$expanded == false) goto L20;
        r16 = SearchBarKt.access$getAnimationEnterFloatSpec$p();
        goto L16
    L20:
        r16 = SearchBarKt.access$getAnimationExitFloatSpec$p();
        goto L16
    L11:
        if (this.$animationProgress.getValue().floatValue() >= 1.0f) goto L13;
        r15 = true;
        goto L14
    }
}
