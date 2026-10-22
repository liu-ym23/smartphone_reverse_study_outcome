package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¯\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2e\u0010\u0010\u001aa\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u0015\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "<init>", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[InputPhase.values().length];
            r0[InputPhase.Focused.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[InputPhase.UnfocusedEmpty.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new TextFieldTransitionScope();
    }

    private TextFieldTransitionScope() {
    }

    private static final Unit Transition_DTcfvLk$lambda$7(TextFieldTransitionScope r12, InputPhase r13, long r14, long r16, Function3 r18, boolean r19, Function6 r20, int r21, Composer r22, int r23) {
        r12.m2232TransitionDTcfvLk(r13, r14, r16, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextFieldTransitionScope r0, InputPhase r1, long r2, long r4, Function3 r6, boolean r7, Function6 r8, int r9, Composer r10, int r11) {
        return Transition_DTcfvLk$lambda$7(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11);
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> r0) {
        return ((Number) r0.getValue()).floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> r2) {
        return ((Color) r2.getValue()).unbox-impl();
    }

    /* JADX INFO: renamed from: Transition-DTcfvLk, reason: not valid java name */
    public final void m2232TransitionDTcfvLk(final InputPhase r25, final long r26, final long r28, final Function3<? super InputPhase, ? super Composer, ? super Integer, Color> r30, final boolean r31, final Function6<? super Float, ? super Color, ? super Color, ? super Float, ? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34) {
        Composer r1 = r33.startRestartGroup(509439888);
        if ((r34 & 6) == 0) goto L5;
        int r2 = r34;
    L11:
        if ((r34 & 48) != 0) goto L19;
        if (r1.changed(r26) == false) goto L15;
        int r6 = 32;
    L16:
        r2 = r2 | r6;
        goto L19
    L15:
        r6 = 16;
    L19:
        if ((r34 & 384) != 0) goto L26;
        if (r1.changed(r28) == false) goto L23;
        int r7 = 256;
    L24:
        r2 = r2 | r7;
        goto L26
    L23:
        r7 = 128;
    L26:
        if ((r34 & 3072) != 0) goto L33;
        if (r1.changedInstance(r30) == false) goto L30;
        int r8 = 2048;
    L31:
        r2 = r2 | r8;
        goto L33
    L30:
        r8 = 1024;
    L33:
        if ((r34 & 24576) != 0) goto L40;
        if (r1.changed(r31) == false) goto L37;
        int r9 = 16384;
    L38:
        r2 = r2 | r9;
        goto L40
    L37:
        r9 = 8192;
    L40:
        if ((196608 & r34) != 0) goto L47;
        if (r1.changedInstance(r32) == false) goto L44;
        int r10 = 131072;
    L45:
        r2 = r2 | r10;
        goto L47
    L44:
        r10 = 65536;
    L47:
        if ((74899 & r2) == 74898) goto L49;
        boolean r11 = true;
    L51:
        if (r1.shouldExecute(r11, r2 & 1) == true) goto L53;
        r1.skipToGroupEnd();
    L172:
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L176;
        r12.updateScope(new md(this, r25, r26, r28, r30, r31, r32, r34));
        return;
    L176:
        return;
    L53:
        if (ComposerKt.isTraceInProgress() == false) goto L55;
        ComposerKt.traceEventStart(509439888, r2, -1, "androidx.compose.material.TextFieldTransitionScope.Transition (TextFieldImpl.kt:283)");
    L55:
        Transition r0 = TransitionKt.updateTransition(r25, "TextFieldInputState", r1, (r2 & 14) | 48, 0);
        TextFieldTransitionScope$Transition$labelProgress$2 r13 = TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE;
        FloatCompanionObject r19 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r17 = VectorConvertersKt.getVectorConverter(r19);
        InputPhase r18 = (InputPhase) r0.getCurrentState();
        r1.startReplaceGroup(389927550);
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventStart(389927550, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:294)");
    L58:
        int[] r20 = WhenMappings.$EnumSwitchMapping$0;
        int r14 = r20[r18.ordinal()];
        float r21 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        if (r14 != 1) goto L61;
    L67:
        float r15 = 1.0f;
    L69:
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventEnd();
    L71:
        r1.endReplaceGroup();
        Float r16 = Float.valueOf(r15);
        InputPhase r110 = (InputPhase) r0.getTargetState();
        r1.startReplaceGroup(389927550);
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        int r5 = -1;
        ComposerKt.traceEventStart(389927550, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:294)");
    L75:
        int r3 = r20[r110.ordinal()];
        if (r3 == 1) goto L86;
        if (r3 != 2) goto L80;
        float r4 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L88:
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventEnd();
    L90:
        r1.endReplaceGroup();
        State r22 = TransitionKt.createTransitionAnimation(r0, r16, Float.valueOf(r4), (FiniteAnimationSpec) r13.invoke(r0.getSegment(), r1, 0), r17, "LabelProgress", r1, 196608);
        TextFieldTransitionScope$Transition$placeholderOpacity$2 r23 = TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> r111 = VectorConvertersKt.getVectorConverter(r19);
        InputPhase r112 = (InputPhase) r0.getCurrentState();
        r1.startReplaceGroup(1246942589);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        int r113 = 0;
        ComposerKt.traceEventStart(1246942589, 0, r5, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:324)");
    L94:
        int r114 = r20[r112.ordinal()];
        if (r114 != 1) goto L97;
        int r24 = 3;
    L107:
        float r115 = 1.0f;
    L109:
        if (ComposerKt.isTraceInProgress() == false) goto L111;
        ComposerKt.traceEventEnd();
    L111:
        r1.endReplaceGroup();
        Float r116 = Float.valueOf(r115);
        InputPhase r117 = (InputPhase) r0.getTargetState();
        r1.startReplaceGroup(1246942589);
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(1246942589, r113, r5, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:324)");
    L114:
        int r118 = r20[r117.ordinal()];
        if (r118 != 1) goto L117;
    L124:
        r21 = 1.0f;
    L126:
        if (ComposerKt.isTraceInProgress() == false) goto L128;
        ComposerKt.traceEventEnd();
    L128:
        r1.endReplaceGroup();
        State r27 = TransitionKt.createTransitionAnimation(r0, r116, Float.valueOf(r21), (FiniteAnimationSpec) r23.invoke(r0.getSegment(), r1, Integer.valueOf(r113)), r111, "PlaceholderOpacity", r1, 196608);
        TextFieldTransitionScope$Transition$labelTextStyleColor$2 r119 = TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE;
        InputPhase r120 = (InputPhase) r0.getTargetState();
        r1.startReplaceGroup(-2001931362);
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventStart(-2001931362, 0, r5, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:336)");
    L132:
        if (r20[r120.ordinal()] != 1) goto L134;
        long r121 = r26;
    L136:
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventEnd();
    L138:
        r1.endReplaceGroup();
        ColorSpace r122 = Color.getColorSpace-impl(r121);
        boolean r123 = r1.changed(r122);
        Object r29 = r1.rememberedValue();
        if (r123 == false) goto L141;
    L142:
        r29 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r122);
        r1.updateRememberedValue(r29);
    L143:
        TwoWayConverter r35 = (TwoWayConverter) r29;
        InputPhase r124 = (InputPhase) r0.getCurrentState();
        r1.startReplaceGroup(-2001931362);
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventStart(-2001931362, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:336)");
    L147:
        if (r20[r124.ordinal()] != 1) goto L149;
        long r125 = r26;
    L151:
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventEnd();
    L153:
        r1.endReplaceGroup();
        Color r126 = Color.box-impl(r125);
        InputPhase r127 = (InputPhase) r0.getTargetState();
        r1.startReplaceGroup(-2001931362);
        if (ComposerKt.isTraceInProgress() == false) goto L157;
        ComposerKt.traceEventStart(-2001931362, 0, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:336)");
    L157:
        if (r20[r127.ordinal()] != 1) goto L159;
        long r128 = r26;
    L161:
        if (ComposerKt.isTraceInProgress() == false) goto L163;
        ComposerKt.traceEventEnd();
    L163:
        r1.endReplaceGroup();
        State r36 = TransitionKt.createTransitionAnimation(r0, r126, Color.box-impl(r128), (FiniteAnimationSpec) r119.invoke(r0.getSegment(), r1, 0), r35, "LabelTextStyleColor", r1, 196608);
        TextFieldTransitionScope$Transition$labelContentColor$2 r37 = TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE;
        int r38 = (r2 & 7168) | 384;
        ColorSpace r129 = Color.getColorSpace-impl(((Color) r30.invoke(r0.getTargetState(), r1, Integer.valueOf((r38 >> 6) & 112))).unbox-impl());
        boolean r130 = r1.changed(r129);
        Object r131 = r1.rememberedValue();
        if (r130 == false) goto L166;
    L167:
        r131 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(r129);
        r1.updateRememberedValue(r131);
    L168:
        TwoWayConverter r132 = (TwoWayConverter) r131;
        int r133 = r38 & 14;
        int r39 = r38 << 3;
        int r134 = (r133 | (r39 & 896)) | (r39 & 7168);
        int r40 = (r39 & 57344) | r134;
        int r135 = (r40 >> 9) & 112;
        State r41 = TransitionKt.createTransitionAnimation(r0, r30.invoke(r0.getCurrentState(), r1, Integer.valueOf(r135)), r30.invoke(r0.getTargetState(), r1, Integer.valueOf(r135)), (FiniteAnimationSpec) r37.invoke(r0.getSegment(), r1, Integer.valueOf((r40 >> 3) & 112)), r132, "LabelContentColor", r1, ((r40 & 14) | ((r40 << 9) & 57344)) | ((r40 << 6) & 458752));
        r32.invoke(Float.valueOf(Transition_DTcfvLk$lambda$1(r22)), Color.box-impl(Transition_DTcfvLk$lambda$5(r36)), Color.box-impl(Transition_DTcfvLk$lambda$6(r41)), Float.valueOf(Transition_DTcfvLk$lambda$3(r27)), r1, Integer.valueOf((r2 >> 3) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L172;
        ComposerKt.traceEventEnd();
        goto L172
    L166:
        if (r131 != Composer.Companion.getEmpty()) goto L168;
    L159:
        r128 = r28;
        goto L161
    L149:
        r125 = r28;
        goto L151
    L141:
        if (r29 != Composer.Companion.getEmpty()) goto L143;
    L134:
        r121 = r28;
        goto L136
    L117:
        if (r118 == 2) goto L122;
        if (r118 == r24) goto L126;
        throw new NoWhenBranchMatchedException();
    L122:
        if (r31 == false) goto L124;
    L97:
        if (r114 == 2) goto L103;
        r24 = 3;
        if (r114 != 3) goto L102;
    L100:
        r115 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L109
    L102:
        throw new NoWhenBranchMatchedException();
    L103:
        r24 = 3;
        if (r31 == false) goto L107;
    L93:
        r113 = 0;
        goto L94
    L80:
        if (r3 == 3) goto L86;
        throw new NoWhenBranchMatchedException();
    L86:
        r4 = 1.0f;
        goto L88
    L74:
        r5 = -1;
        goto L75
    L61:
        if (r14 == 2) goto L66;
        if (r14 == 3) goto L67;
        throw new NoWhenBranchMatchedException();
    L66:
        r15 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        goto L69
    L49:
        r11 = false;
        goto L51
    L5:
        if (r1.changed(r25.ordinal()) == false) goto L7;
        int r42 = 4;
    L8:
        r2 = r42 | r34;
        goto L11
    L7:
        r42 = 2;
        goto L8
    }
}
