package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\b\u0010,\u001a\u00020&H\u0016J\u000e\u0010-\u001a\u00020&H\u0082@¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Landroidx/compose/material3/IndicatorLineNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "textFieldShape", "Landroidx/compose/ui/graphics/Shape;", "focusedIndicatorWidth", "Landroidx/compose/ui/unit/Dp;", "unfocusedIndicatorWidth", "<init>", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "focused", "trackFocusStateJob", "Lkotlinx/coroutines/Job;", "_colors", "getColors", "()Landroidx/compose/material3/TextFieldColors;", "colorAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "value", "_shape", "set_shape", "(Landroidx/compose/ui/graphics/Shape;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "widthAnimatable", "Landroidx/compose/animation/core/AnimationVector1D;", "update", "", "update-gv0btCI", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "onAttach", "trackFocusState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateIndicator", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IndicatorLineNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private TextFieldColors _colors;
    private Shape _shape;
    private Animatable<Color, AnimationVector4D> colorAnimatable;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private boolean enabled;
    private boolean focused;
    private float focusedIndicatorWidth;
    private InteractionSource interactionSource;
    private boolean isError;
    private Job trackFocusStateJob;
    private float unfocusedIndicatorWidth;
    private final Animatable<Dp, AnimationVector1D> widthAnimatable;

    /* JADX INFO: renamed from: androidx.compose.material3.IndicatorLineNode$invalidateIndicator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.IndicatorLineNode$invalidateIndicator$1", f = "TextField.kt", i = {}, l = {1599}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IndicatorLineNode this$0;

        public AnonymousClass1(IndicatorLineNode r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L17:
            AnimationResult r13 = (AnimationResult) r12;
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            Animatable r3 = IndicatorLineNode.access$getColorAnimatable$p(this.this$0);
            if (r3 == null) goto L19;
            Color r4 = Color.box-impl(IndicatorLineNode.access$getColors(this.this$0).m3321indicatorColorXeAY9LY$material3(IndicatorLineNode.access$getEnabled$p(this.this$0), IndicatorLineNode.access$isError$p(this.this$0), IndicatorLineNode.access$getFocused$p(this.this$0)));
            if (IndicatorLineNode.access$getEnabled$p(this.this$0) == false) goto L13;
            AnimationSpec r14 = MotionSchemeKt.fromToken((MotionScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, MaterialTheme.INSTANCE.getLocalMotionScheme$material3()), MotionSchemeKeyTokens.FastEffects);
        L14:
            this.label = 1;
            r12 = Animatable.animateTo$default(r3, r4, r14, null, null, this, 12, null);
            if (r12 != r0) goto L17;
            return r0;
        L13:
            r14 = AnimationSpecKt.snap$default(0, 1, null);
            goto L14
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.IndicatorLineNode$invalidateIndicator$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.IndicatorLineNode$invalidateIndicator$2", f = "TextField.kt", i = {}, l = {1611}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IndicatorLineNode this$0;

        public AnonymousClass2(IndicatorLineNode r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            Animatable r3 = IndicatorLineNode.access$getWidthAnimatable$p(this.this$0);
            if (IndicatorLineNode.access$getFocused$p(this.this$0) == true) goto L11;
        L13:
            float r13 = IndicatorLineNode.access$getUnfocusedIndicatorWidth$p(this.this$0);
        L14:
            Dp r4 = Dp.box-impl(r13);
            if (IndicatorLineNode.access$getEnabled$p(this.this$0) == false) goto L17;
            AnimationSpec r14 = MotionSchemeKt.fromToken((MotionScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, MaterialTheme.INSTANCE.getLocalMotionScheme$material3()), MotionSchemeKeyTokens.FastSpatial);
        L18:
            this.label = 1;
            if (Animatable.animateTo$default(r3, r4, r14, null, null, this, 12, null) != r0) goto L22;
            return r0;
        L17:
            r14 = AnimationSpecKt.snap$default(0, 1, null);
            goto L18
        L11:
            if (IndicatorLineNode.access$getEnabled$p(this.this$0) == false) goto L13;
            r13 = IndicatorLineNode.access$getFocusedIndicatorWidth$p(this.this$0);
            goto L14
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.IndicatorLineNode$onAttach$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.IndicatorLineNode$onAttach$1", f = "TextField.kt", i = {}, l = {1569}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IndicatorLineNode this$0;

        public C02661(IndicatorLineNode r1, Continuation<? super C02661> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02661(this.this$0, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IndicatorLineNode r5 = this.this$0;
            this.label = 1;
            if (IndicatorLineNode.access$trackFocusState(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public /* synthetic */ IndicatorLineNode(boolean r1, boolean r2, InteractionSource r3, TextFieldColors r4, Shape r5, float r6, float r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ DrawResult a(IndicatorLineNode r0, CacheDrawScope r1) {
        return drawWithCacheModifierNode$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit b(Path r0, IndicatorLineNode r1, ContentDrawScope r2) {
        return drawWithCacheModifierNode$lambda$3$lambda$2(r0, r1, r2);
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    private final TextFieldColors getColors() {
        TextFieldColors r0 = this._colors;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return TextFieldDefaults.INSTANCE.defaultTextFieldColors$material3((ColorScheme) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, ColorSchemeKt.getLocalColorScheme()), (TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors()));
    }

    private final Shape getShape() {
        Shape r0 = this._shape;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ShapesKt.fromToken((Shapes) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, ShapesKt.getLocalShapes()), FilledTextFieldTokens.INSTANCE.getContainerShape());
    }

    private final void invalidateIndicator() {
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public void onAttach() {
        this.trackFocusStateJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new C02661(this, null), 3, null);
        if (this.colorAnimatable != null) goto L6;
        long r0 = getColors().m3321indicatorColorXeAY9LY$material3(this.enabled, this.isError, this.focused);
        this.colorAnimatable = new Animatable(Color.box-impl(r0), (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(r0)), null, null, 12, null);
        return;
    }

    public static final /* synthetic */ Animatable access$getColorAnimatable$p(IndicatorLineNode r0) {
        return r0.colorAnimatable;
    }

    public static final /* synthetic */ TextFieldColors access$getColors(IndicatorLineNode r0) {
        return r0.getColors();
    }

    public static final /* synthetic */ boolean access$getEnabled$p(IndicatorLineNode r0) {
        return r0.enabled;
    }

    public static final /* synthetic */ boolean access$getFocused$p(IndicatorLineNode r0) {
        return r0.focused;
    }

    public static final /* synthetic */ float access$getFocusedIndicatorWidth$p(IndicatorLineNode r0) {
        return r0.focusedIndicatorWidth;
    }

    public static final /* synthetic */ float access$getUnfocusedIndicatorWidth$p(IndicatorLineNode r0) {
        return r0.unfocusedIndicatorWidth;
    }

    public static final /* synthetic */ Animatable access$getWidthAnimatable$p(IndicatorLineNode r0) {
        return r0.widthAnimatable;
    }

    public static final /* synthetic */ void access$invalidateIndicator(IndicatorLineNode r0) {
        r0.invalidateIndicator();
    }

    public static final /* synthetic */ boolean access$isError$p(IndicatorLineNode r0) {
        return r0.isError;
    }

    private final void set_shape(Shape r2) {
        if (Intrinsics.areEqual(this._shape, r2) == true) goto L6;
        this._shape = r2;
        this.drawWithCacheModifierNode.invalidateDrawCache();
        return;
    }

    private final Object trackFocusState(Continuation<? super Unit> r4) {
        this.focused = false;
        final ArrayList r0 = new ArrayList();
        Object r5 = this.interactionSource.getInteractions().collect(new C02672(r0, this), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$setFocused$p(IndicatorLineNode r0, boolean r1) {
        r0.focused = r1;
    }

    public static final /* synthetic */ Object access$trackFocusState(IndicatorLineNode r0, Continuation r1) {
        return r0.trackFocusState(r1);
    }

    private static final DrawResult drawWithCacheModifierNode$lambda$3(final IndicatorLineNode r10, CacheDrawScope r11) {
        float r0 = r10.widthAnimatable.getValue().unbox-impl();
        r11.getClass();
        float r1 = Density.-CC.$default$toPx-0680j_4(r11, r0);
        Path r2 = AndroidPath_androidKt.Path();
        OutlineKt.addOutline(r2, r10.getShape().createOutline-Pq9zytI(r11.getSize-NH-jbRc(), r11.getLayoutDirection(), r11));
        Path r3 = AndroidPath_androidKt.Path();
        Path.-CC.addRect$default(r3, new Rect(MenuKt.ClosedAlphaTarget, Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() & 4294967295L)) - r1, Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() >> 32)), Float.intBitsToFloat((int) (r11.getSize-NH-jbRc() & 4294967295L))), null, 2, null);
        final Path r4 = r3.and(r2);
        return r11.onDrawWithContent(new cd(r4, r10));
    }

    private static final Unit drawWithCacheModifierNode$lambda$3$lambda$2(Path r9, IndicatorLineNode r10, ContentDrawScope r11) {
        r11.drawContent();
        Animatable<Color, AnimationVector4D> r12 = r10.colorAnimatable;
        Intrinsics.checkNotNull(r12);
        DrawScope.-CC.drawPath-GBMwjPU$default(r11, r9, new SolidColor(r12.getValue().unbox-impl(), null), MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    private IndicatorLineNode(boolean r2, boolean r3, InteractionSource r4, TextFieldColors r5, Shape r6, float r7, float r8) {
        this.enabled = r2;
        this.isError = r3;
        this.interactionSource = r4;
        this.focusedIndicatorWidth = r7;
        this.unfocusedIndicatorWidth = r8;
        this._colors = r5;
        this._shape = r6;
        if (this.focused == false) goto L6;
        if (r2 == false) goto L6;
    L7:
        this.widthAnimatable = new Animatable(Dp.box-impl(r7), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
        this.drawWithCacheModifierNode = delegate(DrawModifierKt.CacheDrawModifierNode(new bd(this)));
        return;
    L6:
        r7 = r8;
        goto L7
    }

    /* JADX INFO: renamed from: update-gv0btCI, reason: not valid java name */
    public final void m2792updategv0btCI(boolean r9, boolean r10, InteractionSource r11, TextFieldColors r12, Shape r13, float r14, float r15) {
        boolean r1 = true;
        if (this.enabled == r9) goto L5;
        this.enabled = r9;
        boolean r16 = true;
    L7:
        if (this.isError == r10) goto L10;
        this.isError = r10;
        r16 = true;
    L10:
        if (this.interactionSource == r11) goto L16;
        this.interactionSource = r11;
        Job r17 = this.trackFocusStateJob;
        if (r17 == null) goto L14;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
    L14:
        this.trackFocusStateJob = BuildersKt.launch$default(getCoroutineScope(), null, null, new IndicatorLineNode$update$1(this, null), 3, null);
    L16:
        if (Intrinsics.areEqual(this._colors, r12) == true) goto L19;
        this._colors = r12;
        r16 = true;
    L19:
        if (Intrinsics.areEqual(this._shape, r13) == true) goto L22;
        set_shape(r13);
        r16 = true;
    L22:
        if (Dp.equals-impl0(this.focusedIndicatorWidth, r14) == true) goto L25;
        this.focusedIndicatorWidth = r14;
        r16 = true;
    L25:
        if (Dp.equals-impl0(this.unfocusedIndicatorWidth, r15) == true) goto L27;
        this.unfocusedIndicatorWidth = r15;
    L28:
        if (r1 == false) goto L31;
        invalidateIndicator();
        return;
    L31:
        return;
    L27:
        r1 = r16;
        goto L28
    L5:
        r16 = false;
        goto L7
    }
}
