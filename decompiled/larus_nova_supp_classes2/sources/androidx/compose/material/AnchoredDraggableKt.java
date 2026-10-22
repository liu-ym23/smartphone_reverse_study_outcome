package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0001\u001aR\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0010H\u0001\u001a&\u0010\u0015\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0016\u001a\u0002H\u0002H\u0081@¢\u0006\u0002\u0010\u0017\u001a0\u0010\u0018\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0081@¢\u0006\u0002\u0010\u001b\u001aF\u0010\u001c\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001f2\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\"\u0012\u0006\u0012\u0004\u0018\u00010\u00030!H\u0082@¢\u0006\u0002\u0010#\u001a\u0014\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002H\u0002\u001ar\u0010&\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2H\u0010'\u001aD\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110,¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u0002H\u00020.0!H\u0001¨\u0006/"}, d2 = {"DraggableAnchors", "Landroidx/compose/material/DraggableAnchors;", "T", "", "builder", "Lkotlin/Function1;", "Landroidx/compose/material/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "snapTo", "targetValue", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restartable", "I", "inputs", "Lkotlin/Function0;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/material/MapDraggableAnchors;", "draggableAnchors", "anchors", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableKt {

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1$1", f = "AnchoredDraggable.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AnchoredDraggableState<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            public C00481(AnchoredDraggableState<T> r1, float r2, Continuation<? super C00481> r3) {
                this.$state = r1;
                this.$velocity = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00481(this.$state, this.$velocity, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                AnchoredDraggableState<T> r5 = this.$state;
                float r2 = this.$velocity;
                this.label = 1;
                if (r5.settle(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(AnchoredDraggableState<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.$state = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((CoroutineScope) r1, ((Number) r2).floatValue(), (Continuation) r3);
        }

        public final Object invoke(CoroutineScope r3, float r4, Continuation<? super Unit> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$state, r5);
            r0.L$0 = r3;
            r0.F$0 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            float r8 = this.F$0;
            BuildersKt.launch$default(r0, null, null, new C00481(this.$state, r8, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$animateTo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material/AnchoredDragScope;", "anchors", "Landroidx/compose/material/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", i = {}, l = {691}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass2(AnchoredDraggableState<T> r1, float r2, Continuation<? super AnonymousClass2> r3) {
            this.$this_animateTo = r1;
            this.$velocity = r2;
            super(4, r3);
        }

        public static /* synthetic */ Unit a(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        public final Object invoke(AnchoredDragScope r4, DraggableAnchors<T> r5, T r6, Continuation<? super Unit> r7) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$this_animateTo, this.$velocity, r7);
            r0.L$0 = r4;
            r0.L$1 = r5;
            r0.L$2 = r6;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, r3, (Continuation) r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
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
            float r5 = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (Float.isNaN(r5) == true) goto L18;
            final Ref.FloatRef r2 = new Ref.FloatRef();
            if (Float.isNaN(this.$this_animateTo.getOffset()) == false) goto L13;
            float r4 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        L14:
            r2.element = r4;
            float r6 = this.$velocity;
            AnimationSpec<Float> r7 = this.$this_animateTo.getAnimationSpec();
            Function2 r8 = new f(r12, r2);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (SuspendAnimationKt.animate(r4, r5, r6, r7, r8, this) != r0) goto L18;
            return r0;
        L13:
            r4 = this.$this_animateTo.getOffset();
            goto L14
        }

        private static final Unit invokeSuspend$lambda$0(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
            r0.dragTo(r2, r3);
            r1.element = r2;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {}, l = {716}, m = "restartable", n = {}, s = {})
    public static final class C02381<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C02381(Continuation<? super C02381> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AnchoredDraggableKt.access$restartable(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {718}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02392 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {725}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C00492(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r1, I r2, CoroutineScope r3, Continuation<? super C00492> r4) {
                    this.$block = r1;
                    this.$latestInputs = r2;
                    this.$$this$coroutineScope = r3;
                    super(2, r4);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    return new C00492(this.$block, this.$latestInputs, this.$$this$coroutineScope, r5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r4) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    ResultKt.throwOnFailure(r4);
                L11:
                    CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r4);
                    Function2<I, Continuation<? super Unit>, Object> r5 = this.$block;
                    I r2 = this.$latestInputs;
                    this.label = 1;
                    if (r5.invoke(r2, this) != r0) goto L11;
                    return r0;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Ref.ObjectRef<Job> r1, CoroutineScope r2, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r3) {
                this.$previousDrag = r1;
                this.$$this$coroutineScope = r2;
                this.$block = r3;
            }

            public final Object emit(I r7, Continuation<? super Unit> r8) {
                if ((r8 instanceof AnchoredDraggableKt$restartable$2$1$emit$1) == false) goto L7;
                AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (AnchoredDraggableKt$restartable$2$1$emit$1) r8;
                int r1 = r0.label;
                if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
                r0.label = r1 - RtlSpacingHelper.UNDEFINED;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                Job r10 = (Job) r0.L$1;
                Object r11 = r0.L$0;
                ResultKt.throwOnFailure(r9);
                Object r12 = r11;
            L19:
                Ref.ObjectRef<Job> r13 = this.$previousDrag;
                CoroutineScope r4 = this.$$this$coroutineScope;
                r13.element = BuildersKt.launch$default(r4, null, CoroutineStart.UNDISPATCHED, new C00492(this.$block, r12, r4, null), 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                Job r14 = (Job) this.$previousDrag.element;
                r12 = r7;
                if (r14 == null) goto L19;
                r14.cancel(new AnchoredDragFinishedSignal());
                r0.L$0 = r7;
                r0.L$1 = r14;
                r0.label = 1;
                r12 = r7;
                if (r14.join(r0) != r2) goto L19;
                return r2;
            L7:
                r0 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, r8);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C02392(Function0<? extends I> r1, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super C02392> r3) {
            this.$inputs = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02392 r0 = new C02392(this.$inputs, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            Ref.ObjectRef r2 = new Ref.ObjectRef();
            Flow r3 = SnapshotStateKt.snapshotFlow(this.$inputs);
            AnonymousClass1 r4 = new AnonymousClass1(r2, r8, this.$block);
            this.label = 1;
            if (r3.collect(r4, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material/AnchoredDragScope;", "anchors", "Landroidx/compose/material/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02402<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public C02402(Continuation<? super C02402> r2) {
            super(4, r2);
        }

        public final Object invoke(AnchoredDragScope r2, DraggableAnchors<T> r3, T r4, Continuation<? super Unit> r5) {
            C02402 r0 = new C02402(r5);
            r0.L$0 = r2;
            r0.L$1 = r3;
            r0.L$2 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, r3, (Continuation) r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            AnchoredDragScope r6 = (AnchoredDragScope) this.L$0;
            float r0 = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (Float.isNaN(r0) == true) goto L8;
            AnchoredDragScope.CC.dragTo$default(r6, r0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors(MapsKt.emptyMap());
    }

    public static final /* synthetic */ MapDraggableAnchors access$emptyDraggableAnchors() {
        return emptyDraggableAnchors();
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> r2) {
        DraggableAnchorsConfig r1 = new DraggableAnchorsConfig();
        r2.invoke(r1);
        return new MapDraggableAnchors(r1.getAnchors$material());
    }

    public static final /* synthetic */ Object access$restartable(Function0 r0, Function2 r1, Continuation r2) {
        return restartable(r0, r1, r2);
    }

    private static final <I> Object restartable(Function0<? extends I> r4, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof C02381) == false) goto L7;
        C02381 r0 = (C02381) r6;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: AnchoredDragFinishedSignal -> L21
    L22:
        goto L20
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        C02392 r8 = new C02392(r4, r5, null);     // Catch: AnchoredDragFinishedSignal -> L21
        r0.label = 1;     // Catch: AnchoredDragFinishedSignal -> L21
        if (CoroutineScopeKt.coroutineScope(r8, r0) != r2) goto L22;
        return r2;
    L20:
        return Unit.INSTANCE;
    L7:
        r0 = new C02381(r6);
        goto L8
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> r7, T r8, Continuation<? super Unit> r9) {
        Object r10 = AnchoredDraggableState.anchoredDrag$default(r7, r8, null, new C02402(null), r9, 2, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> r7, T r8, float r9, Continuation<? super Unit> r10) {
        Object r11 = AnchoredDraggableState.anchoredDrag$default(r7, r8, null, new AnonymousClass2(r7, r9, null), r10, 2, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> Modifier draggableAnchors(Modifier r1, AnchoredDraggableState<T> r2, Orientation r3, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> r4) {
        return r1.then(new DraggableAnchorsElement(r2, r4, r3));
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState r0, Object r1, float r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.getLastVelocity();
    L6:
        return animateTo(r0, r1, r2, r3);
    }

    public static final <T> Modifier anchoredDraggable(Modifier r11, AnchoredDraggableState<T> r12, Orientation r13, boolean r14, boolean r15, MutableInteractionSource r16, boolean r17) {
        return DraggableKt.draggable$default(r11, r12.getDraggableState$material(), r13, r14, r16, r17, null, new AnonymousClass1(r12, null), r15, 32, null);
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r7, AnchoredDraggableState r8, Orientation r9, boolean r10, boolean r11, MutableInteractionSource r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r14 & 8) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r14 & 16) == 0) goto L13;
        r12 = null;
    L13:
        MutableInteractionSource r5 = r12;
        if ((r14 & 32) == 0) goto L17;
        r13 = r8.isAnimationRunning();
    L17:
        return anchoredDraggable(r7, r8, r9, r3, r4, r5, r13);
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
