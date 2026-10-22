package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a,\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\f\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"animateScrollBy", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "value", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "animateScrollBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/Scrollable2DState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy", "(Landroidx/compose/foundation/gestures/ScrollableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/Scrollable2DState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopScroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScrollExtensionsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {40}, m = "animateScrollBy", n = {"previousValue"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ScrollExtensionsKt.animateScrollBy(null, MenuKt.ClosedAlphaTarget, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2", f = "ScrollExtensions.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ Ref.FloatRef $previousValue;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(float r1, AnimationSpec<Float> r2, Ref.FloatRef r3, Continuation<? super AnonymousClass2> r4) {
            this.$value = r1;
            this.$animationSpec = r2;
            this.$previousValue = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(Ref.FloatRef r0, ScrollScope r1, float r2, float r3) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$value, this.$animationSpec, this.$previousValue, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            final ScrollScope r13 = (ScrollScope) this.L$0;
            float r4 = this.$value;
            AnimationSpec<Float> r6 = this.$animationSpec;
            final Ref.FloatRef r2 = this.$previousValue;
            Function2 r7 = new w1(r2, r13);
            this.label = 1;
            if (SuspendAnimationKt.animate$default(MenuKt.ClosedAlphaTarget, r4, MenuKt.ClosedAlphaTarget, r6, r7, this, 4, null) != r0) goto L12;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(Ref.FloatRef r0, ScrollScope r1, float r2, float r3) {
            float r4 = r0.element;
            r0.element = r4 + r1.scrollBy(r2 - r4);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {62}, m = "animateScrollBy-ubNVwUQ", n = {"previousValue"}, s = {"L$0"})
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ScrollExtensionsKt.m653animateScrollByubNVwUQ(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$4", f = "ScrollExtensions.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Offset> $animationSpec;
        final /* synthetic */ Ref.LongRef $previousValue;
        final /* synthetic */ long $value;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(long r1, AnimationSpec<Offset> r3, Ref.LongRef r4, Continuation<? super AnonymousClass4> r5) {
            this.$value = r1;
            this.$animationSpec = r3;
            this.$previousValue = r4;
            super(2, r5);
        }

        public static /* synthetic */ Unit a(Ref.LongRef r0, Scroll2DScope r1, Offset r2, Offset r3) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass4 r6 = new AnonymousClass4(this.$value, this.$animationSpec, this.$previousValue, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(Scroll2DScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Scroll2DScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            final Scroll2DScope r14 = (Scroll2DScope) this.L$0;
            Offset.Companion r2 = Offset.Companion;
            TwoWayConverter<Offset, AnimationVector2D> r3 = VectorConvertersKt.getVectorConverter(r2);
            Offset r4 = Offset.box-impl(r2.getZero-F1C5BW0());
            Offset r5 = Offset.box-impl(this.$value);
            AnimationSpec<Offset> r7 = this.$animationSpec;
            final Ref.LongRef r6 = this.$previousValue;
            Function2 r8 = new x1(r6, r14);
            this.label = 1;
            if (SuspendAnimationKt.animate$default(r3, r4, r5, null, r7, r8, this, 8, null) != r0) goto L12;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(Ref.LongRef r4, Scroll2DScope r5, Offset r6, Offset r7) {
            r4.element = Offset.plus-MK-Hz9U(r4.element, r5.mo563scrollByMKHz9U(Offset.minus-MK-Hz9U(r6.unbox-impl(), r4.element)));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {83}, m = "scrollBy", n = {"consumed"}, s = {"L$0"})
    public static final class C01481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01481(Continuation<? super C01481> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ScrollExtensionsKt.scrollBy(null, MenuKt.ClosedAlphaTarget, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2", f = "ScrollExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01492 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $consumed;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        public C01492(Ref.FloatRef r1, float r2, Continuation<? super C01492> r3) {
            this.$consumed = r1;
            this.$value = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C01492 r0 = new C01492(this.$consumed, this.$value, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ScrollScope r4 = (ScrollScope) this.L$0;
            Ref.FloatRef r0 = this.$consumed;
            r0.element = r4.scrollBy(this.$value);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {98}, m = "scrollBy-d-4ec7I", n = {"consumed"}, s = {"L$0"})
    public static final class C01503 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01503(Continuation<? super C01503> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return ScrollExtensionsKt.m655scrollByd4ec7I(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$4", f = "ScrollExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01514 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $consumed;
        final /* synthetic */ long $value;
        private /* synthetic */ Object L$0;
        int label;

        public C01514(Ref.LongRef r1, long r2, Continuation<? super C01514> r4) {
            this.$consumed = r1;
            this.$value = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C01514 r0 = new C01514(this.$consumed, this.$value, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(Scroll2DScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Scroll2DScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            Scroll2DScope r5 = (Scroll2DScope) this.L$0;
            Ref.LongRef r0 = this.$consumed;
            r0.element = r5.mo563scrollByMKHz9U(this.$value);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2", f = "ScrollExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01522 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        int label;

        public C01522(Continuation<? super C01522> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01522(r2);
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$4", f = "ScrollExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01534 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
        int label;

        public C01534(Continuation<? super C01534> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01534(r2);
        }

        public final Object invoke(Scroll2DScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Scroll2DScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final Object scrollBy(ScrollableState r7, float r8, Continuation<? super Float> r9) {
        if ((r9 instanceof C01481) == false) goto L7;
        C01481 r0 = (C01481) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        C01481 r4 = r0;
        Object r10 = r4.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r4.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.FloatRef r11 = (Ref.FloatRef) r4.L$0;
        ResultKt.throwOnFailure(r10);
    L19:
        return Boxing.boxFloat(r11.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.FloatRef r12 = new Ref.FloatRef();
        C01492 r5 = new C01492(r12, r8, null);
        r4.L$0 = r12;
        r4.label = 1;
        if (ScrollableState.CC.scroll$default(r7, null, r5, r4, 1, null) != r2) goto L17;
        return r2;
    L17:
        r11 = r12;
    L7:
        r0 = new C01481(r9);
        goto L8
    }

    /* JADX INFO: renamed from: scrollBy-d-4ec7I, reason: not valid java name */
    public static final Object m655scrollByd4ec7I(Scrollable2DState r7, long r8, Continuation<? super Offset> r10) {
        if ((r10 instanceof C01503) == false) goto L7;
        C01503 r0 = (C01503) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        C01503 r4 = r0;
        Object r11 = r4.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r4.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.LongRef r9 = (Ref.LongRef) r4.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        return Offset.box-impl(r9.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Ref.LongRef r12 = new Ref.LongRef();
        r12.element = Offset.Companion.getZero-F1C5BW0();
        C01514 r5 = new C01514(r12, r8, null);
        r4.L$0 = r12;
        r4.label = 1;
        if (Scrollable2DState.CC.scroll$default(r7, null, r5, r4, 1, null) != r2) goto L17;
        return r2;
    L17:
        r9 = r12;
    L7:
        r0 = new C01503(r10);
        goto L8
    }

    public static final Object stopScroll(Scrollable2DState r2, MutatePriority r3, Continuation<? super Unit> r4) {
        Object r5 = r2.scroll(r3, new C01534(null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object stopScroll(ScrollableState r2, MutatePriority r3, Continuation<? super Unit> r4) {
        Object r5 = r2.scroll(r3, new C01522(null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object animateScrollBy(ScrollableState r7, float r8, AnimationSpec<Float> r9, Continuation<? super Float> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass1 r4 = r0;
        Object r11 = r4.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r4.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.FloatRef r12 = (Ref.FloatRef) r4.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        return Boxing.boxFloat(r12.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        Ref.FloatRef r13 = new Ref.FloatRef();
        AnonymousClass2 r5 = new AnonymousClass2(r8, r9, r13, null);
        r4.L$0 = r13;
        r4.label = 1;
        if (ScrollableState.CC.scroll$default(r7, null, r5, r4, 1, null) != r2) goto L17;
        return r2;
    L17:
        r12 = r13;
    L7:
        r0 = new AnonymousClass1(r10);
        goto L8
    }

    /* JADX INFO: renamed from: animateScrollBy-ubNVwUQ, reason: not valid java name */
    public static final Object m653animateScrollByubNVwUQ(Scrollable2DState r13, long r14, AnimationSpec<Offset> r16, Continuation<? super Offset> r17) {
        if ((r17 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r1 = (AnonymousClass3) r17;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass3 r5 = r1;
        Object r0 = r5.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r5.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Ref.LongRef r6 = (Ref.LongRef) r5.L$0;
        ResultKt.throwOnFailure(r0);
    L19:
        return Offset.box-impl(r6.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Ref.LongRef r7 = new Ref.LongRef();
        r7.element = Offset.Companion.getZero-F1C5BW0();
        AnonymousClass4 r12 = new AnonymousClass4(r14, r16, r7, null);
        r5.L$0 = r7;
        r5.label = 1;
        if (Scrollable2DState.CC.scroll$default(r13, null, r12, r5, 1, null) != r3) goto L17;
        return r3;
    L17:
        r6 = r7;
    L7:
        r1 = new AnonymousClass3(r17);
        goto L8
    }

    public static /* synthetic */ Object stopScroll$default(Scrollable2DState r0, MutatePriority r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return stopScroll(r0, r1, r2);
    }

    public static /* synthetic */ Object stopScroll$default(ScrollableState r0, MutatePriority r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return stopScroll(r0, r1, r2);
    }

    public static /* synthetic */ Object animateScrollBy$default(ScrollableState r0, float r1, AnimationSpec r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L6:
        return animateScrollBy(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: animateScrollBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m654animateScrollByubNVwUQ$default(Scrollable2DState r0, long r1, AnimationSpec r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L6:
        return m653animateScrollByubNVwUQ(r0, r1, r3, r4);
    }
}
