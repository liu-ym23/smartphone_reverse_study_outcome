package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableKt$swipeable$3$3$1", f = "Swipeable.kt", i = {}, l = {602}, m = "invokeSuspend", n = {}, s = {})
public final class SwipeableKt$swipeable$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<Float, T> $anchors;
    final /* synthetic */ Density $density;
    final /* synthetic */ ResistanceConfig $resistance;
    final /* synthetic */ SwipeableState<T> $state;
    final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;
    final /* synthetic */ float $velocityThreshold;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableKt$swipeable$3$3$1(SwipeableState<T> r1, Map<Float, ? extends T> r2, ResistanceConfig r3, Density r4, Function2<? super T, ? super T, ? extends ThresholdConfig> r5, float r6, Continuation<? super SwipeableKt$swipeable$3$3$1> r7) {
        this.$state = r1;
        this.$anchors = r2;
        this.$resistance = r3;
        this.$density = r4;
        this.$thresholds = r5;
        this.$velocityThreshold = r6;
        super(2, r7);
    }

    public static /* synthetic */ float a(Map r0, Function2 r1, Density r2, float r3, float r4) {
        return invokeSuspend$lambda$1(r0, r1, r2, r3, r4);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SwipeableKt$swipeable$3$3$1(this.$state, this.$anchors, this.$resistance, this.$density, this.$thresholds, this.$velocityThreshold, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        Map r9 = this.$state.getAnchors$material();
        this.$state.setAnchors$material(this.$anchors);
        this.$state.setResistance$material(this.$resistance);
        SwipeableState<T> r2 = this.$state;
        final Map<Float, T> r3 = this.$anchors;
        final Function2<T, T, ThresholdConfig> r4 = this.$thresholds;
        final Density r5 = this.$density;
        r2.setThresholds$material(new kb(r3, r4, r5));
        Density r6 = this.$density;
        this.$state.setVelocityThreshold$material(r6.toPx-0680j_4(this.$velocityThreshold));
        SwipeableState<T> r7 = this.$state;
        Object r10 = this.$anchors;
        this.label = 1;
        if (r7.processNewAnchors$material(r9, r10, this) != r0) goto L12;
        return r0;
    }

    private static final float invokeSuspend$lambda$1(Map r2, Function2 r3, Density r4, float r5, float r6) {
        return ((ThresholdConfig) r3.invoke(MapsKt.getValue(r2, Float.valueOf(r5)), MapsKt.getValue(r2, Float.valueOf(r6)))).computeThreshold(r4, r5, r6);
    }
}
