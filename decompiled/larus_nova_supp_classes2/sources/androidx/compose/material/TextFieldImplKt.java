package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001a\u00020\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\u001c\u001aQ\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2 \u0010$\u001a\u001c\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0000H\u0001¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020**\u00020*2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0005H\u0000\u001a\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0000\u001a\u0012\u00100\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0000\"\u001a\u00101\u001a\u0004\u0018\u000102*\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\"\u000e\u00106\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020-X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020-X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020-X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010>\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010A\"\u0016\u0010C\u001a\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010B\u001a\u0004\bD\u0010A¨\u0006E"}, d2 = {"CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "widthOrZero", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "heightOrZero", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "AnimationDuration", "PlaceholderAnimationDuration", "PlaceholderAnimationDelayOrDuration", "TextFieldPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldPadding", "()F", "F", "HorizontalIconPadding", "getHorizontalIconPadding", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final float HorizontalIconPadding = 0.0f;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = 0.0f;
    public static final String TrailingId = "Trailing";

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass3 implements Function6<Float, Color, Color, Float, Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $shouldOverrideTextStyleColor;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
        final /* synthetic */ String $transformedText;
        final /* synthetic */ TextFieldType $type;

        /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[TextFieldType.values().length];
                r0[TextFieldType.Filled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TextFieldType.Outlined.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public AnonymousClass3(Function2<? super Composer, ? super Integer, Unit> r3, Function2<? super Composer, ? super Integer, Unit> r4, String r5, TextFieldColors r6, boolean r7, boolean r8, InteractionSource r9, Function2<? super Composer, ? super Integer, Unit> r10, Function2<? super Composer, ? super Integer, Unit> r11, Shape r12, TextFieldType r13, Function2<? super Composer, ? super Integer, Unit> r14, boolean r15, PaddingValues r16, boolean r17, Function2<? super Composer, ? super Integer, Unit> r18) {
            this.$label = r3;
            this.$placeholder = r4;
            this.$transformedText = r5;
            this.$colors = r6;
            this.$enabled = r7;
            this.$isError = r8;
            this.$interactionSource = r9;
            this.$leadingIcon = r10;
            this.$trailingIcon = r11;
            this.$shape = r12;
            this.$type = r13;
            this.$innerTextField = r14;
            this.$singleLine = r15;
            this.$contentPadding = r16;
            this.$shouldOverrideTextStyleColor = r17;
            this.$border = r18;
        }

        public static /* synthetic */ Unit a(float r0, MutableState r1, Size r2) {
            return invoke_RIQooxk$lambda$5$lambda$4(r0, r1, r2);
        }

        private static final Unit invoke_RIQooxk$lambda$5$lambda$4(float r9, MutableState r10, Size r11) {
            float r0 = Float.intBitsToFloat((int) (r11.unbox-impl() >> 32)) * r9;
            float r12 = Float.intBitsToFloat((int) (r11.unbox-impl() & 4294967295L)) * r9;
            boolean r1 = true;
            if (Float.intBitsToFloat((int) (((Size) r10.getValue()).unbox-impl() >> 32)) != r0) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == true) goto L8;
        L12:
            r10.setValue(Size.box-impl(Size.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r12)) & 4294967295L))));
        L14:
            return Unit.INSTANCE;
        L8:
            if (Float.intBitsToFloat((int) (((Size) r10.getValue()).unbox-impl() & 4294967295L)) == r12) goto L11;
            r1 = false;
        L11:
            if (r1 == true) goto L14;
        L5:
            r13 = false;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
            m2225invokeRIQooxk(((Number) r10).floatValue(), ((Color) r11).unbox-impl(), ((Color) r12).unbox-impl(), ((Number) r13).floatValue(), (Composer) r14, ((Number) r15).intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
        public final void m2225invokeRIQooxk(final float r21, final long r22, final long r24, final float r26, Composer r27, int r28) {
            if ((r28 & 6) == 0) goto L5;
            int r2 = r28;
        L11:
            if ((r28 & 48) != 0) goto L18;
            if (r27.changed(r22) == false) goto L15;
            int r3 = 32;
        L16:
            r2 = r2 | r3;
            goto L18
        L15:
            r3 = 16;
        L18:
            if ((r28 & 384) != 0) goto L26;
            if (r27.changed(r24) == false) goto L22;
            int r5 = 256;
        L23:
            r2 = r2 | r5;
            goto L26
        L22:
            r5 = 128;
        L26:
            if ((r28 & 3072) == 0) goto L28;
        L32:
            int r13 = r2;
            if ((r13 & 9363) == 9362) goto L35;
            boolean r1 = true;
        L37:
            if (r27.shouldExecute(r1, r13 & 1) == true) goto L39;
            r27.skipToGroupEnd();
            return;
        L39:
            if (ComposerKt.isTraceInProgress() == false) goto L41;
            ComposerKt.traceEventStart(33336375, r13, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:128)");
        L41:
            final Function2<Composer, Integer, Unit> r6 = this.$label;
            if (r6 != null) goto L44;
            r27.startReplaceGroup(986681709);
            r27.endReplaceGroup();
            Function2 r7 = null;
            int r12 = 54;
            boolean r14 = true;
        L46:
            if (this.$placeholder != null) goto L48;
        L55:
            r27.startReplaceGroup(988093542);
            r27.endReplaceGroup();
            ComposableLambda r8 = null;
        L56:
            final long r4 = ((Color) this.$colors.leadingIconColor(this.$enabled, this.$isError, this.$interactionSource, r27, 0).getValue()).unbox-impl();
            final Function2<Composer, Integer, Unit> r9 = this.$leadingIcon;
            if (r9 != null) goto L59;
            r27.startReplaceGroup(988282301);
            r27.endReplaceGroup();
            Function2 r10 = null;
        L60:
            final long r11 = ((Color) this.$colors.trailingIconColor(this.$enabled, this.$isError, this.$interactionSource, r27, 0).getValue()).unbox-impl();
            final Function2<Composer, Integer, Unit> r15 = this.$trailingIcon;
            if (r15 != null) goto L63;
            r27.startReplaceGroup(988575964);
            r27.endReplaceGroup();
            Function2 r16 = null;
        L64:
            Modifier r17 = BackgroundKt.m341backgroundbw27NRU(Modifier.Companion, ((Color) this.$colors.backgroundColor(this.$enabled, r27, 0).getValue()).unbox-impl(), this.$shape);
            TextFieldType r18 = this.$type;
            int r19 = WhenMappings.$EnumSwitchMapping$0[r18.ordinal()];
            if (r19 != r14) goto L67;
            r27.startReplaceGroup(988856360);
            int r110 = (r13 << 21) & 29360128;
            Function2 r20 = r7;
            ComposableLambda r23 = r8;
            Function2 r25 = r10;
            TextFieldKt.TextFieldLayout(r17, this.$innerTextField, r20, r23, r25, r16, this.$singleLine, r21, this.$contentPadding, r27, r110);
            r27.endReplaceGroup();
        L85:
            if (ComposerKt.isTraceInProgress() == false) goto L89;
            ComposerKt.traceEventEnd();
            return;
        L89:
            return;
        L67:
            if (r19 != 2) goto L81;
            r27.startReplaceGroup(989436742);
            Object r29 = r27.rememberedValue();
            Composer.Companion r111 = Composer.Companion;
            if (r29 != r111.getEmpty()) goto L71;
            r29 = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), null, 2, null);
            r27.updateRememberedValue(r29);
        L71:
            final MutableState r30 = (MutableState) r29;
            final PaddingValues r31 = this.$contentPadding;
            final Function2<Composer, Integer, Unit> r32 = this.$border;
            ComposableLambda r112 = ComposableLambdaKt.rememberComposableLambda(-1107746014, r14, new TextFieldImplKt$CommonDecorationBox$3$drawBorder$1(r30, r31, r32), r27, r12);
            Function2<Composer, Integer, Unit> r33 = this.$innerTextField;
            boolean r34 = this.$singleLine;
            if ((r13 & 14) != 4) goto L74;
            boolean r113 = true;
        L75:
            Object r35 = r27.rememberedValue();
            if (r113 == false) goto L78;
        L79:
            r35 = new yc(r21, r30);
            r27.updateRememberedValue(r35);
        L80:
            ComposableLambda r36 = r8;
            Function2 r37 = r7;
            Function2 r38 = r10;
            OutlinedTextFieldKt.OutlinedTextFieldLayout(r17, r33, r36, r37, r38, r16, r34, r21, (Function1) r35, r112, this.$contentPadding, r27, ((r13 << 21) & 29360128) | 805306368, 0);
            r27.endReplaceGroup();
            goto L85
        L78:
            if (r35 != r111.getEmpty()) goto L80;
        L74:
            r113 = false;
            goto L75
        L81:
            r27.startReplaceGroup(1971561250);
            r27.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        L63:
            r27.startReplaceGroup(988575965);
            Function2 r39 = ComposableLambdaKt.rememberComposableLambda(262889693, r14, new TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1(r11, r15), r27, r12);
            r27.endReplaceGroup();
            r16 = r39;
            goto L64
        L59:
            r27.startReplaceGroup(988282302);
            Function2 r40 = ComposableLambdaKt.rememberComposableLambda(-317090443, r14, new TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1(r4, r9), r27, r12);
            r27.endReplaceGroup();
            r10 = r40;
            goto L60
        L48:
            if (this.$transformedText.length() != 0) goto L50;
            boolean r41 = true;
        L51:
            if (r41 == false) goto L55;
            if (r26 <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L55;
            r27.startReplaceGroup(987666549);
            final TextFieldColors r42 = this.$colors;
            final boolean r43 = this.$enabled;
            final Function2<Composer, Integer, Unit> r44 = this.$placeholder;
            ComposableLambda r45 = ComposableLambdaKt.rememberComposableLambda(-426706263, r14, new TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(r26, r42, r43, r44), r27, r12);
            r27.endReplaceGroup();
            r8 = r45;
            goto L56
        L50:
            r41 = false;
            goto L51
        L44:
            r27.startReplaceGroup(986681710);
            final boolean r46 = this.$shouldOverrideTextStyleColor;
            r12 = 54;
            r14 = true;
            Function2 r47 = ComposableLambdaKt.rememberComposableLambda(723429411, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(r21, r24, r6, r46, r22), r27, 54);
            r27.endReplaceGroup();
            r7 = r47;
            goto L46
        L35:
            r1 = false;
            goto L37
        L28:
            if (r27.changed(r26) == false) goto L30;
            int r48 = 2048;
        L31:
            r2 = r2 | r48;
            goto L32
        L30:
            r48 = 1024;
            goto L31
        L5:
            if (r27.changed(r21) == false) goto L7;
            int r49 = 4;
        L8:
            r2 = r49 | r28;
            goto L11
        L7:
            r49 = 2;
            goto L8
        }
    }

    private static final Unit CommonDecorationBox$lambda$5(TextFieldType r19, String r20, Function2 r21, VisualTransformation r22, Function2 r23, Function2 r24, Function2 r25, Function2 r26, boolean r27, boolean r28, boolean r29, InteractionSource r30, PaddingValues r31, Shape r32, TextFieldColors r33, Function2 r34, int r35, int r36, Composer r37, int r38) {
        CommonDecorationBox(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r37, RecomposeScopeImplKt.updateChangedFlags(r35 | 1), RecomposeScopeImplKt.updateChangedFlags(r36));
        return Unit.INSTANCE;
    }

    private static final Unit Decoration_euL9pac$lambda$6(long r9, TextStyle r11, Float r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        m2224DecorationeuL9pac(r9, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
        return defaultErrorSemantics$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit b(long r0, TextStyle r2, Float r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return Decoration_euL9pac$lambda$6(r0, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(TextFieldType r1, String r2, Function2 r3, VisualTransformation r4, Function2 r5, Function2 r6, Function2 r7, Function2 r8, boolean r9, boolean r10, boolean r11, InteractionSource r12, PaddingValues r13, Shape r14, TextFieldColors r15, Function2 r16, int r17, int r18, Composer r19, int r20) {
        return CommonDecorationBox$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    static {
        TextFieldPadding = Dp.constructor-impl(16);
        HorizontalIconPadding = Dp.constructor-impl(12);
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final Object getLayoutId(IntrinsicMeasurable r2) {
        Object r3 = r2.getParentData();
        if ((r3 instanceof LayoutIdParentData) == false) goto L5;
        LayoutIdParentData r4 = (LayoutIdParentData) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getLayoutId();
    L5:
        r4 = null;
        goto L6
    }

    public static final int heightOrZero(Placeable r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getHeight();
    }

    public static final int widthOrZero(Placeable r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getWidth();
    }

    private static final Unit defaultErrorSemantics$lambda$7(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.error(r1, r0);
        return Unit.INSTANCE;
    }

    public static final Modifier defaultErrorSemantics(Modifier r2, boolean r3, final String r4) {
        if (r3 == true) goto L4;
        return r2;
    L4:
        return SemanticsModifierKt.semantics$default(r2, false, new wc(r4), 1, null);
    }

    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m2224DecorationeuL9pac(final long r14, TextStyle r16, Float r17, final Function2<? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20, final int r21) {
        Composer r3 = r19.startRestartGroup(2064632657);
        if ((r21 & 1) == 0) goto L6;
        int r4 = r20 | 6;
    L13:
        int r7 = r21 & 2;
        if (r7 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        TextStyle r8 = r16;
    L24:
        int r9 = r21 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        final Float r10 = r17;
    L36:
        if ((r21 & 8) == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        if ((r4 & 1171) == 1170) goto L48;
        boolean r11 = true;
    L50:
        if (r3.shouldExecute(r11, r4 & 1) == true) goto L52;
        r3.skipToGroupEnd();
    L67:
        final Float r5 = r10;
        ScopeUpdateScope r12 = r3.endRestartGroup();
        if (r12 == null) goto L71;
        final TextStyle r6 = r8;
        r12.updateScope(new xc(r14, r6, r5, r18, r20, r21));
        return;
    L71:
        return;
    L52:
        if (r7 == 0) goto L54;
        r8 = null;
    L54:
        if (r9 == 0) goto L57;
        r10 = null;
    L57:
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventStart(2064632657, r4, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:236)");
    L59:
        ComposableLambda r0 = ComposableLambdaKt.rememberComposableLambda(-650790565, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(r14, r10, r18), r3, 54);
        if (r8 == null) goto L62;
        r3.startReplaceGroup(-162878945);
        TextKt.ProvideTextStyle(r8, r0, r3, ((r4 >> 3) & 14) | 48);
    L63:
        r3.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L67;
        ComposerKt.traceEventEnd();
        goto L67
    L62:
        r3.startReplaceGroup(-162877309);
        r0.invoke(r3, 6);
        goto L63
    L48:
        r11 = false;
        goto L50
    L39:
        if ((r20 & 3072) != 0) goto L46;
        if (r3.changedInstance(r18) == false) goto L43;
        int r13 = 2048;
    L44:
        r4 = r4 | r13;
        goto L46
    L43:
        r13 = 1024;
        goto L44
    L28:
        if ((r20 & 384) != 0) goto L34;
        r10 = r17;
        if (r3.changed(r10) == false) goto L32;
        int r15 = 256;
    L33:
        r4 = r4 | r15;
        goto L36
    L32:
        r15 = 128;
        goto L33
    L17:
        if ((r20 & 48) != 0) goto L23;
        r8 = r16;
        if (r3.changed(r8) == false) goto L21;
        int r22 = 32;
    L22:
        r4 = r4 | r22;
        goto L24
    L21:
        r22 = 16;
        goto L22
    L6:
        if ((r20 & 6) == 0) goto L8;
        r4 = r20;
        goto L13
    L8:
        if (r3.changed(r14) == false) goto L10;
        int r23 = 4;
    L11:
        r4 = r23 | r20;
        goto L13
    L10:
        r23 = 2;
        goto L11
    }

    public static final void CommonDecorationBox(final TextFieldType r33, final String r34, final Function2<? super Composer, ? super Integer, Unit> r35, final VisualTransformation r36, final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Function2<? super Composer, ? super Integer, Unit> r39, final Function2<? super Composer, ? super Integer, Unit> r40, final boolean r41, final boolean r42, final boolean r43, final InteractionSource r44, final PaddingValues r45, final Shape r46, final TextFieldColors r47, final Function2<? super Composer, ? super Integer, Unit> r48, Composer r49, final int r50, final int r51) {
        Composer r11 = r49.startRestartGroup(418608794);
        if ((r50 & 6) == 0) goto L5;
        int r6 = r50;
    L11:
        if ((r50 & 48) == 0) goto L13;
    L17:
        int r16 = 256;
        if ((r50 & 384) != 0) goto L25;
        if (r11.changedInstance(r35) == false) goto L22;
        int r18 = 256;
    L23:
        r6 = r6 | r18;
        goto L25
    L22:
        r18 = 128;
    L25:
        int r19 = 1024;
        if ((r50 & 3072) == 0) goto L28;
    L32:
        int r21 = 16384;
        if ((r50 & 24576) == 0) goto L35;
    L39:
        int r24 = 131072;
        if ((r50 & 196608) != 0) goto L47;
        if (r11.changedInstance(r38) == false) goto L44;
        int r26 = 131072;
    L45:
        r6 = r6 | r26;
        goto L47
    L44:
        r26 = 65536;
    L47:
        if ((r50 & 1572864) != 0) goto L54;
        if (r11.changedInstance(r39) == false) goto L51;
        int r27 = 1048576;
    L52:
        r6 = r6 | r27;
        goto L54
    L51:
        r27 = 524288;
    L54:
        if ((r50 & 12582912) != 0) goto L61;
        if (r11.changedInstance(r40) == false) goto L58;
        int r28 = 8388608;
    L59:
        r6 = r6 | r28;
        goto L61
    L58:
        r28 = 4194304;
    L61:
        if ((r50 & 100663296) != 0) goto L68;
        if (r11.changed(r41) == false) goto L65;
        int r29 = 67108864;
    L66:
        r6 = r6 | r29;
        goto L68
    L65:
        r29 = 33554432;
    L68:
        if ((r50 & 805306368) != 0) goto L75;
        if (r11.changed(r42) == false) goto L72;
        int r210 = 536870912;
    L73:
        r6 = r6 | r210;
        goto L75
    L72:
        r210 = 268435456;
    L75:
        if ((r51 & 6) == 0) goto L77;
        int r211 = r51;
    L83:
        if ((r51 & 48) != 0) goto L90;
        if (r11.changed(r44) == false) goto L87;
        int r110 = 32;
    L88:
        r211 = r211 | r110;
        goto L90
    L87:
        r110 = 16;
    L90:
        if ((r51 & 384) != 0) goto L98;
        if (r11.changed(r45) == true) goto L95;
        r16 = 128;
    L95:
        r211 = r211 | r16;
    L98:
        if ((r51 & 3072) != 0) goto L105;
        if (r11.changed(r46) == false) goto L102;
        r19 = 2048;
    L102:
        r211 = r211 | r19;
    L105:
        if ((r51 & 24576) != 0) goto L112;
        if (r11.changed(r47) == true) goto L110;
        r21 = 8192;
    L110:
        r211 = r211 | r21;
    L112:
        if ((196608 & r51) != 0) goto L119;
        if (r11.changedInstance(r48) == true) goto L117;
        r24 = 65536;
    L117:
        r211 = r211 | r24;
    L119:
        int r5 = r211;
        if ((r6 & 306783379) == 306783378) goto L122;
    L125:
        boolean r7 = true;
    L127:
        if (r11.shouldExecute(r7, r6 & 1) == true) goto L129;
        Composer r2 = r11;
        r2.skipToGroupEnd();
    L195:
        ScopeUpdateScope r15 = r2.endRestartGroup();
        if (r15 == null) goto L199;
        r15.updateScope(new vc(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r50, r51));
        return;
    L199:
        return;
    L129:
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventStart(418608794, r6, r5, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:78)");
    L132:
        if ((r6 & 112) != 32) goto L134;
        boolean r8 = true;
    L136:
        if ((r6 & 7168) != 2048) goto L138;
        boolean r9 = true;
    L139:
        boolean r10 = r9 | r8;
        Object r12 = r11.rememberedValue();
        if (r10 == false) goto L142;
    L143:
        r12 = r36.filter(new AnnotatedString(r34, null, 2, null));
        r11.updateRememberedValue(r12);
    L144:
        String r13 = ((TransformedText) r12).getText().getText();
        if (((Boolean) FocusInteractionKt.collectIsFocusedAsState(r44, r11, (r5 >> 3) & 14).getValue()).booleanValue() == false) goto L149;
        InputPhase r14 = InputPhase.Focused;
    L147:
        InputPhase r17 = r14;
        Function3<InputPhase, Composer, Integer, Color> r20 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(r47, r42, r43, r44);
        MaterialTheme r22 = MaterialTheme.INSTANCE;
        Typography r111 = r22.getTypography(r11, 6);
        TextStyle r112 = r111.getSubtitle1();
        TextStyle r113 = r111.getCaption();
        long r114 = r112.getColor-0d7_KjU();
        Color.Companion r23 = Color.Companion;
        if (Color.equals-impl0(r114, r23.getUnspecified-0d7_KjU()) == false) goto L160;
        if (Color.equals-impl0(r113.getColor-0d7_KjU(), r23.getUnspecified-0d7_KjU()) == true) goto L160;
    L163:
        boolean r25 = true;
    L165:
        TextFieldTransitionScope r0 = TextFieldTransitionScope.INSTANCE;
        r11.startReplaceGroup(-1443811635);
        long r115 = r22.getTypography(r11, 6).getCaption().getColor-0d7_KjU();
        if (r25 == false) goto L175;
        r11.startReplaceGroup(-887928539);
        if (r115 == 16) goto L170;
        boolean r1 = true;
    L171:
        if (r1 == true) goto L174;
        r115 = ((Color) r20.invoke(r17, r11, 0)).unbox-impl();
    L174:
        r11.endReplaceGroup();
    L176:
        long r212 = r115;
        r11.endReplaceGroup();
        r11.startReplaceGroup(-1443804369);
        long r116 = r22.getTypography(r11, 6).getSubtitle1().getColor-0d7_KjU();
        if (r25 == false) goto L186;
        r11.startReplaceGroup(-1026713946);
        if (r116 == 16) goto L181;
        boolean r3 = true;
    L182:
        if (r3 == true) goto L185;
        r116 = ((Color) r20.invoke(r17, r11, 0)).unbox-impl();
    L185:
        r11.endReplaceGroup();
    L187:
        long r213 = r116;
        r11.endReplaceGroup();
        if (r37 == null) goto L190;
        boolean r4 = true;
    L191:
        r2 = r11;
        boolean r117 = r4;
        r0.m2232TransitionDTcfvLk(r17, r212, r213, r20, r117, ComposableLambdaKt.rememberComposableLambda(33336375, true, new AnonymousClass3(r37, r38, r13, r47, r42, r43, r44, r39, r40, r46, r33, r35, r41, r45, r25, r48), r2, 54), r2, 1769472);
        if (ComposerKt.isTraceInProgress() == false) goto L195;
        ComposerKt.traceEventEnd();
        goto L195
    L190:
        r4 = false;
        goto L191
    L181:
        r3 = false;
        goto L182
    L186:
        r11.startReplaceGroup(798166043);
        r11.endReplaceGroup();
        goto L187
    L170:
        r1 = false;
        goto L171
    L175:
        r11.startReplaceGroup(1218284988);
        r11.endReplaceGroup();
    L160:
        if (Color.equals-impl0(r112.getColor-0d7_KjU(), r23.getUnspecified-0d7_KjU()) == false) goto L162;
    L164:
        r25 = false;
        goto L165
    L162:
        if (Color.equals-impl0(r113.getColor-0d7_KjU(), r23.getUnspecified-0d7_KjU()) == false) goto L164;
    L149:
        if (r13.length() != 0) goto L151;
        boolean r30 = true;
    L152:
        if (r30 == false) goto L154;
        r14 = InputPhase.UnfocusedEmpty;
        goto L147
    L154:
        r14 = InputPhase.UnfocusedNotEmpty;
        goto L147
    L151:
        r30 = false;
        goto L152
    L142:
        if (r12 != Composer.Companion.getEmpty()) goto L144;
    L138:
        r9 = false;
        goto L139
    L134:
        r8 = false;
        goto L136
    L122:
        if ((74899 & r5) != 74898) goto L125;
        r7 = false;
        goto L127
    L77:
        if (r11.changed(r43) == false) goto L79;
        int r214 = 4;
    L80:
        r211 = r51 | r214;
        goto L83
    L79:
        r214 = 2;
        goto L80
    L35:
        if (r11.changedInstance(r37) == false) goto L37;
        int r118 = 16384;
    L38:
        r6 = r6 | r118;
        goto L39
    L37:
        r118 = 8192;
        goto L38
    L28:
        if (r11.changed(r36) == false) goto L30;
        int r119 = 2048;
    L31:
        r6 = r6 | r119;
        goto L32
    L30:
        r119 = 1024;
        goto L31
    L13:
        if (r11.changed(r34) == false) goto L15;
        int r31 = 32;
    L16:
        r6 = r6 | r31;
        goto L17
    L15:
        r31 = 16;
        goto L16
    L5:
        if (r11.changed(r33.ordinal()) == false) goto L7;
        int r32 = 4;
    L8:
        r6 = r32 | r50;
        goto L11
    L7:
        r32 = 2;
        goto L8
    }
}
