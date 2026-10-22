package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;J\u009c\u0002\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020>2\u0011\u0010?\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010CJ5\u00101\u001a\u0002022\b\b\u0002\u0010D\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020\t2\b\b\u0002\u0010F\u001a\u00020\t2\b\b\u0002\u0010G\u001a\u00020\t¢\u0006\u0004\bH\u0010IJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010JJ¿\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020L2\b\b\u0002\u0010N\u001a\u00020L2\b\b\u0002\u0010O\u001a\u00020L2\b\b\u0002\u0010P\u001a\u00020L2\b\b\u0002\u0010Q\u001a\u00020L2\b\b\u0002\u0010R\u001a\u00020L2\b\b\u0002\u0010S\u001a\u00020L2\b\b\u0002\u0010T\u001a\u00020L2\b\b\u0002\u0010U\u001a\u00020L2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001a\u00020L2\b\b\u0002\u0010Y\u001a\u00020L2\b\b\u0002\u0010Z\u001a\u00020L2\b\b\u0002\u0010[\u001a\u00020L2\b\b\u0002\u0010\\\u001a\u00020L2\b\b\u0002\u0010]\u001a\u00020L2\b\b\u0002\u0010^\u001a\u00020L2\b\b\u0002\u0010_\u001a\u00020L2\b\b\u0002\u0010`\u001a\u00020L2\b\b\u0002\u0010a\u001a\u00020L2\b\b\u0002\u0010b\u001a\u00020L2\b\b\u0002\u0010c\u001a\u00020L2\b\b\u0002\u0010d\u001a\u00020L2\b\b\u0002\u0010e\u001a\u00020L2\b\b\u0002\u0010f\u001a\u00020L2\b\b\u0002\u0010g\u001a\u00020L2\b\b\u0002\u0010h\u001a\u00020L2\b\b\u0002\u0010i\u001a\u00020L2\b\b\u0002\u0010j\u001a\u00020L2\b\b\u0002\u0010k\u001a\u00020L2\b\b\u0002\u0010l\u001a\u00020L2\b\b\u0002\u0010m\u001a\u00020L2\b\b\u0002\u0010n\u001a\u00020L2\b\b\u0002\u0010o\u001a\u00020L2\b\b\u0002\u0010p\u001a\u00020L2\b\b\u0002\u0010q\u001a\u00020L2\b\b\u0002\u0010r\u001a\u00020L2\b\b\u0002\u0010s\u001a\u00020L2\b\b\u0002\u0010t\u001a\u00020L2\b\b\u0002\u0010u\u001a\u00020L2\b\b\u0002\u0010v\u001a\u00020L2\b\b\u0002\u0010w\u001a\u00020LH\u0007¢\u0006\u0004\bx\u0010yJP\u0010~\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0018\u0010z\u001a\u000200*\u00020{8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", "Container", "modifier", "Landroidx/compose/ui/Modifier;", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness = 0.0f;
    public static final OutlinedTextFieldDefaults INSTANCE = null;
    private static final float MinHeight = 0.0f;
    private static final float MinWidth = 0.0f;
    private static final float UnfocusedBorderThickness = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldDefaults$decorator$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements TextFieldDecorator {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ Function2<Composer, Integer, Unit> $container;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
        final /* synthetic */ TextFieldLabelPosition $labelPosition;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(OutputTransformation r3, TextFieldState r4, TextFieldLineLimits r5, TextFieldLabelPosition r6, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r7, Function2<? super Composer, ? super Integer, Unit> r8, Function2<? super Composer, ? super Integer, Unit> r9, Function2<? super Composer, ? super Integer, Unit> r10, Function2<? super Composer, ? super Integer, Unit> r11, Function2<? super Composer, ? super Integer, Unit> r12, Function2<? super Composer, ? super Integer, Unit> r13, boolean r14, boolean r15, InteractionSource r16, PaddingValues r17, TextFieldColors r18, Function2<? super Composer, ? super Integer, Unit> r19) {
            this.$outputTransformation = r3;
            this.$state = r4;
            this.$lineLimits = r5;
            this.$labelPosition = r6;
            this.$label = r7;
            this.$placeholder = r8;
            this.$leadingIcon = r9;
            this.$trailingIcon = r10;
            this.$prefix = r11;
            this.$suffix = r12;
            this.$supportingText = r13;
            this.$enabled = r14;
            this.$isError = r15;
            this.$interactionSource = r16;
            this.$contentPadding = r17;
            this.$colors = r18;
            this.$container = r19;
        }

        private static final Unit Decoration$lambda$2(AnonymousClass2 r0, Function2 r1, int r2, Composer r3, int r4) {
            r0.Decoration(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit a(AnonymousClass2 r0, Function2 r1, int r2, Composer r3, int r4) {
            return Decoration$lambda$2(r0, r1, r2, r3, r4);
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r25, Composer r26, final int r27) {
            Composer r3 = r26.startRestartGroup(794272399);
            if ((r27 & 6) == 0) goto L5;
            int r5 = r27;
        L11:
            if ((r27 & 48) == 0) goto L13;
        L17:
            int r15 = r5;
            if ((r15 & 19) == 18) goto L20;
            boolean r6 = true;
        L22:
            if (r3.shouldExecute(r6, r15 & 1) == true) goto L24;
            Composer r23 = r3;
            r23.skipToGroupEnd();
        L44:
            ScopeUpdateScope r2 = r23.endRestartGroup();
            if (r2 == null) goto L50;
            r2.updateScope(new vi(this, r25, r27));
            return;
        L50:
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L27;
            ComposerKt.traceEventStart(794272399, r15, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator.<no name provided>.Decoration (TextFieldDefaults.kt:994)");
        L27:
            if (this.$outputTransformation != null) goto L30;
            CharSequence r4 = this.$state.getText();
        L29:
            CharSequence r20 = r4;
            TextFieldType r7 = TextFieldType.Outlined;
            boolean r13 = Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE);
            r23 = r3;
            TextFieldImplKt.CommonDecorationBox(r7, r20, r25, this.$labelPosition, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$prefix, this.$suffix, this.$supportingText, r13, this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$container, r23, ((r15 << 6) & 896) | 6, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L44;
            ComposerKt.traceEventEnd();
            goto L44
        L30:
            TextFieldState r8 = this.$state;
            TextFieldBuffer r9 = r8.startEdit();
            r8.commitEdit(r9);     // Catch: Throwable -> L40
            r8.finishEditing();
            OutputTransformation r10 = this.$outputTransformation;
            if (r9 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("buffer");
            TextFieldBuffer r11 = null;
        L36:
            r10.transformOutput(r11);
            r4 = r9.asCharSequence();
            goto L29
        L35:
            r11 = r9;
        L40:
            th = move-exception;
            r8.finishEditing();
            throw th;
        L20:
            r6 = false;
            goto L22
        L13:
            if (r3.changed(this) == false) goto L15;
            int r12 = 32;
        L16:
            r5 = r5 | r12;
            goto L17
        L15:
            r12 = 16;
            goto L16
        L5:
            if (r3.changedInstance(r25) == false) goto L7;
            int r14 = 4;
        L8:
            r5 = r14 | r27;
            goto L11
        L7:
            r14 = 2;
            goto L8
        }
    }

    private OutlinedTextFieldDefaults() {
    }

    private static final Unit ContainerBox_nbWgWpA$lambda$7(OutlinedTextFieldDefaults r12, boolean r13, boolean r14, InteractionSource r15, TextFieldColors r16, Shape r17, float r18, float r19, int r20, int r21, Composer r22, int r23) {
        r12.m2970ContainerBoxnbWgWpA(r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit Container_4EFweAY$lambda$0(OutlinedTextFieldDefaults r13, boolean r14, boolean r15, InteractionSource r16, Modifier r17, TextFieldColors r18, Shape r19, float r20, float r21, int r22, int r23, Composer r24, int r25) {
        r13.m2969Container4EFweAY(r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit DecorationBox$lambda$3(OutlinedTextFieldDefaults r22, String r23, Function2 r24, boolean r25, boolean r26, VisualTransformation r27, InteractionSource r28, boolean r29, Function2 r30, Function2 r31, Function2 r32, Function2 r33, Function2 r34, Function2 r35, Function2 r36, TextFieldColors r37, PaddingValues r38, Function2 r39, int r40, int r41, int r42, Composer r43, int r44) {
        r22.DecorationBox(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r43, RecomposeScopeImplKt.updateChangedFlags(r40 | 1), RecomposeScopeImplKt.updateChangedFlags(r41), r42);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(OutlinedTextFieldDefaults r0, boolean r1, boolean r2, InteractionSource r3, TextFieldColors r4, Shape r5, float r6, float r7, int r8, int r9, Composer r10, int r11) {
        return ContainerBox_nbWgWpA$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(OutlinedTextFieldDefaults r0, boolean r1, boolean r2, InteractionSource r3, Modifier r4, TextFieldColors r5, Shape r6, float r7, float r8, int r9, int r10, Composer r11, int r12) {
        return Container_4EFweAY$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit c(OutlinedTextFieldDefaults r1, String r2, Function2 r3, boolean r4, boolean r5, VisualTransformation r6, InteractionSource r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, Function2 r14, Function2 r15, TextFieldColors r16, PaddingValues r17, Function2 r18, int r19, int r20, int r21, Composer r22, int r23) {
        return DecorationBox$lambda$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    static {
        INSTANCE = new OutlinedTextFieldDefaults();
        MinHeight = Dp.constructor-impl(56);
        MinWidth = Dp.constructor-impl(280);
        UnfocusedBorderThickness = Dp.constructor-impl(1);
        FocusedBorderThickness = Dp.constructor-impl(2);
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2973getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2974getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2975getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2976getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    public final TextFieldColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-471651810, r5, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1215)");
    L5:
        TextFieldColors r6 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(r4, 6), r4, (r5 << 3) & 112);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1066756961, r5, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:887)");
    L5:
        Shape r6 = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme r97, Composer r98, int r99) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-292363577, r99, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1365)");
    L5:
        TextFieldColors r5 = r97.getDefaultOutlinedTextFieldColorsCached$material3();
        if (r5 != null) goto L8;
        r98.startReplaceGroup(390452338);
        r98.endReplaceGroup();
        TextFieldColors r2 = null;
    L13:
        if (r2 != null) goto L15;
        r98.startReplaceGroup(-1788321191);
        OutlinedTextFieldTokens r87 = OutlinedTextFieldTokens.INSTANCE;
        long r4 = ColorSchemeKt.fromToken(r97, r87.getFocusInputColor());
        long r6 = ColorSchemeKt.fromToken(r97, r87.getInputColor());
        long r8 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledInputColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r10 = ColorSchemeKt.fromToken(r97, r87.getErrorInputColor());
        Color.Companion r18 = Color.Companion;
        r2 = new TextFieldColors(r4, r6, r8, r10, r18.getTransparent-0d7_KjU(), r18.getTransparent-0d7_KjU(), r18.getTransparent-0d7_KjU(), r18.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r97, r87.getCaretColor()), ColorSchemeKt.fromToken(r97, r87.getErrorFocusCaretColor()), (TextSelectionColors) r98.consume(TextSelectionColorsKt.getLocalTextSelectionColors()), ColorSchemeKt.fromToken(r97, r87.getFocusOutlineColor()), ColorSchemeKt.fromToken(r97, r87.getOutlineColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledOutlineColor()), 0.12f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getErrorOutlineColor()), ColorSchemeKt.fromToken(r97, r87.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(r97, r87.getLeadingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledLeadingIconColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(r97, r87.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(r97, r87.getTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledTrailingIconColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(r97, r87.getFocusLabelColor()), ColorSchemeKt.fromToken(r97, r87.getLabelColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledLabelColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getErrorLabelColor()), ColorSchemeKt.fromToken(r97, r87.getInputPlaceholderColor()), ColorSchemeKt.fromToken(r97, r87.getInputPlaceholderColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledInputColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getInputPlaceholderColor()), ColorSchemeKt.fromToken(r97, r87.getFocusSupportingColor()), ColorSchemeKt.fromToken(r97, r87.getSupportingColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getDisabledSupportingColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getErrorSupportingColor()), ColorSchemeKt.fromToken(r97, r87.getInputPrefixColor()), ColorSchemeKt.fromToken(r97, r87.getInputPrefixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getInputPrefixColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getInputPrefixColor()), ColorSchemeKt.fromToken(r97, r87.getInputSuffixColor()), ColorSchemeKt.fromToken(r97, r87.getInputSuffixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r97, r87.getInputSuffixColor()), 0.38f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r97, r87.getInputSuffixColor()), null);
        r97.setDefaultOutlinedTextFieldColorsCached$material3(r2);
        r98.endReplaceGroup();
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventEnd();
    L19:
        return r2;
    L15:
        r98.startReplaceGroup(-1788515437);
        r98.endReplaceGroup();
        goto L17
    L8:
        r98.startReplaceGroup(390452339);
        TextSelectionColors r3 = (TextSelectionColors) r98.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
        if (Intrinsics.areEqual(r5.getTextSelectionColors(), r3) == true) goto L12;
        r5 = TextFieldColors.m3275copyejIjP34$default(r5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1025, 2047, null);
        r97.setDefaultOutlinedTextFieldColorsCached$material3(r5);
    L12:
        r98.endReplaceGroup();
        r2 = r5;
        goto L13
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2972contentPaddinga9UjIt4(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2968contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = TextFieldImplKt.getTextFieldPadding();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = TextFieldImplKt.getTextFieldPadding();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = TextFieldImplKt.getTextFieldPadding();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = TextFieldImplKt.getTextFieldPadding();
    L15:
        return r0.m2972contentPaddinga9UjIt4(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to OutlinedTextFieldDefaults.Container", replaceWith = @ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n    focusedBorderThickness = focusedBorderThickness,\n    unfocusedBorderThickness = unfocusedBorderThickness,\n)", imports = {}))
    /* JADX INFO: renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    public final void m2970ContainerBoxnbWgWpA(final boolean r23, final boolean r24, final InteractionSource r25, TextFieldColors r26, Shape r27, float r28, float r29, Composer r30, final int r31, final int r32) {
        Composer r15 = r30.startRestartGroup(1461761386);
        if ((r32 & 1) == 0) goto L6;
        int r1 = r31 | 6;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r32 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r31 & 3072) == 0) goto L36;
        TextFieldColors r2 = r26;
    L45:
        if ((r31 & 24576) == 0) goto L47;
        Shape r3 = r27;
    L56:
        if ((196608 & r31) == 0) goto L58;
        float r4 = r28;
    L67:
        if ((1572864 & r31) == 0) goto L69;
        float r5 = r29;
    L78:
        if ((r32 & 128) == 0) goto L81;
        r1 = r1 | 12582912;
    L88:
        if ((4793491 & r1) == 4793490) goto L90;
        boolean r6 = true;
    L92:
        if (r15.shouldExecute(r6, r1 & 1) == false) goto L130;
        r15.startDefaults();
        if ((r31 & 1) == 0) goto L111;
        if (r15.getDefaultsInvalid() == true) goto L111;
        r15.skipToGroupEnd();
        if ((r32 & 8) == 0) goto L102;
        r1 = r1 & (-7169);
    L102:
        if ((r32 & 16) == 0) goto L105;
        r1 = r1 & (-57345);
    L105:
        if ((r32 & 32) == 0) goto L108;
        r1 = r1 & (-458753);
    L108:
        if ((r32 & 64) != 0) goto L122;
    L123:
        TextFieldColors r16 = r2;
        Shape r17 = r3;
        float r18 = r4;
        float r19 = r5;
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventStart(1461761386, r1, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1482)");
    L126:
        int r0 = (((r1 & 14) | 3072) | (r1 & 112)) | (r1 & 896);
        int r7 = r1 << 3;
        m2969Container4EFweAY(r23, r24, r25, Modifier.Companion, r16, r17, r18, r19, r15, ((((r0 | (57344 & r7)) | (458752 & r7)) | (3670016 & r7)) | (29360128 & r7)) | (r7 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventEnd();
    L129:
        final TextFieldColors r8 = r16;
        final Shape r9 = r17;
        final float r10 = r18;
        final float r11 = r19;
    L131:
        ScopeUpdateScope r12 = r15.endRestartGroup();
        if (r12 == null) goto L135;
        r12.updateScope(new si(this, r23, r24, r25, r8, r9, r10, r11, r31, r32));
        return;
    L135:
        return;
    L122:
        r1 = r1 & (-3670017);
    L111:
        if ((r32 & 8) == 0) goto L114;
        r2 = colors(r15, (r1 >> 21) & 14);
        r1 = r1 & (-7169);
    L114:
        if ((r32 & 16) == 0) goto L117;
        r3 = INSTANCE.getShape(r15, 6);
        r1 = r1 & (-57345);
    L117:
        if ((r32 & 32) == 0) goto L120;
        r4 = FocusedBorderThickness;
        r1 = r1 & (-458753);
    L120:
        if ((r32 & 64) == 0) goto L123;
        r5 = UnfocusedBorderThickness;
        goto L122
    L130:
        r15.skipToGroupEnd();
        r9 = r3;
        r10 = r4;
        r11 = r5;
        r8 = r2;
        goto L131
    L90:
        r6 = false;
        goto L92
    L81:
        if ((r31 & 12582912) != 0) goto L88;
        if (r15.changed(this) == false) goto L85;
        int r13 = 8388608;
    L86:
        r1 = r1 | r13;
        goto L88
    L85:
        r13 = 4194304;
        goto L86
    L69:
        if ((r32 & 64) != 0) goto L73;
        r5 = r29;
        if (r15.changed(r5) == false) goto L74;
        int r14 = 1048576;
    L75:
        r1 = r1 | r14;
    L74:
        r14 = 524288;
        goto L75
    L73:
        r5 = r29;
        goto L74
    L58:
        if ((r32 & 32) != 0) goto L62;
        r4 = r28;
        if (r15.changed(r4) == false) goto L63;
        int r20 = 131072;
    L64:
        r1 = r1 | r20;
    L63:
        r20 = 65536;
        goto L64
    L62:
        r4 = r28;
        goto L63
    L47:
        if ((r32 & 16) != 0) goto L51;
        r3 = r27;
        if (r15.changed(r3) == false) goto L52;
        int r21 = 16384;
    L53:
        r1 = r1 | r21;
    L52:
        r21 = 8192;
        goto L53
    L51:
        r3 = r27;
        goto L52
    L36:
        if ((r32 & 8) != 0) goto L40;
        r2 = r26;
        if (r15.changed(r2) == false) goto L41;
        int r22 = 2048;
    L42:
        r1 = r1 | r22;
    L41:
        r22 = 1024;
        goto L42
    L40:
        r2 = r26;
        goto L41
    L27:
        if ((r31 & 384) != 0) goto L34;
        if (r15.changed(r25) == false) goto L31;
        int r33 = 256;
    L32:
        r1 = r1 | r33;
        goto L34
    L31:
        r33 = 128;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L24;
        if (r15.changed(r24) == false) goto L21;
        int r34 = 32;
    L22:
        r1 = r1 | r34;
        goto L24
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r1 = r31;
        goto L14
    L8:
        if (r15.changed(r23) == false) goto L10;
        int r35 = 4;
    L11:
        r1 = r35 | r31;
        goto L14
    L10:
        r35 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    public final void m2969Container4EFweAY(final boolean r25, final boolean r26, final InteractionSource r27, Modifier r28, TextFieldColors r29, Shape r30, float r31, float r32, Composer r33, final int r34, final int r35) {
        Composer r14 = r33.startRestartGroup(1035477640);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r35 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r35 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r3 = r28;
    L45:
        if ((r34 & 24576) == 0) goto L47;
        TextFieldColors r4 = r29;
    L56:
        if ((196608 & r34) == 0) goto L58;
        Shape r5 = r30;
    L67:
        if ((1572864 & r34) == 0) goto L69;
        float r6 = r31;
    L78:
        if ((12582912 & r34) == 0) goto L80;
        float r7 = r32;
    L89:
        if ((r35 & 256) == 0) goto L92;
        r1 = r1 | 100663296;
    L99:
        if ((38347923 & r1) == 38347922) goto L101;
        boolean r0 = true;
    L103:
        if (r14.shouldExecute(r0, r1 & 1) == false) goto L146;
        r14.startDefaults();
        if ((r34 & 1) != 0) goto L107;
    L122:
        if (r2 == 0) goto L124;
        Modifier r8 = Modifier.Companion;
    L126:
        if ((r35 & 16) == 0) goto L129;
        TextFieldColors r9 = colors(r14, (r1 >> 24) & 14);
        r1 = r1 & (-57345);
        r4 = r9;
    L129:
        if ((r35 & 32) == 0) goto L132;
        r1 = r1 & (-458753);
        r5 = INSTANCE.getShape(r14, 6);
    L132:
        if ((r35 & 64) == 0) goto L135;
        r1 = r1 & (-3670017);
        r6 = FocusedBorderThickness;
    L135:
        if ((r35 & 128) == 0) goto L137;
        r1 = r1 & (-29360129);
        Modifier r15 = r8;
        float r23 = UnfocusedBorderThickness;
        TextFieldColors r10 = r4;
        float r22 = r6;
    L139:
        Shape r11 = r5;
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventStart(1035477640, r1, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1054)");
    L142:
        int r12 = r1 >> 6;
        boolean r13 = ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r27, r14, r12 & 14).getValue()).booleanValue();
        int r16 = (r1 & 14) | (r1 & 112);
        TextFieldColors r17 = r10;
        float r18 = r22;
        float r19 = r23;
        TextFieldColors r110 = r10;
        State r20 = TextFieldImplKt.animateBorderStrokeAsState-NuRrP5Q(r25, r26, r13, r17, r18, r19, r14, ((((r1 >> 3) & 7168) | r16) | (57344 & r12)) | (r12 & 458752));
        long r21 = r110.m3276containerColorXeAY9LY$material3(r25, r26, r13);
        FiniteAnimationSpec r111 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r14, 6);
        Composer r24 = r14;
        final Modifier r36 = r15;
        final State<Color> r37 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r21, r111, null, null, r24, 0, 12);
        BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(r36, (BorderStroke) r20.getValue(), r11), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new OutlinedTextFieldDefaults$Container$1(r37)), r11), r24, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventEnd();
    L145:
        final Shape r38 = r11;
        final TextFieldColors r39 = r110;
    L147:
        ScopeUpdateScope r112 = r24.endRestartGroup();
        if (r112 == null) goto L151;
        final float r40 = r22;
        final float r41 = r23;
        r112.updateScope(new ui(this, r25, r26, r27, r36, r39, r38, r40, r41, r34, r35));
        return;
    L151:
        return;
    L137:
        r15 = r8;
    L138:
        r22 = r6;
        r23 = r7;
        r10 = r4;
        goto L139
    L124:
        r8 = r3;
        goto L126
    L107:
        if (r14.getDefaultsInvalid() == true) goto L122;
        r14.skipToGroupEnd();
        if ((r35 & 16) == 0) goto L113;
        r1 = r1 & (-57345);
    L113:
        if ((r35 & 32) == 0) goto L116;
        r1 = r1 & (-458753);
    L116:
        if ((r35 & 64) == 0) goto L119;
        r1 = r1 & (-3670017);
    L119:
        if ((r35 & 128) == 0) goto L121;
        r1 = r1 & (-29360129);
    L121:
        r15 = r3;
        goto L138
    L146:
        r24 = r14;
        r24.skipToGroupEnd();
        r22 = r6;
        r23 = r7;
        r39 = r4;
        r38 = r5;
        r36 = r3;
        goto L147
    L101:
        r0 = false;
        goto L103
    L92:
        if ((r34 & 100663296) != 0) goto L99;
        if (r14.changed(this) == false) goto L96;
        int r113 = 67108864;
    L97:
        r1 = r1 | r113;
        goto L99
    L96:
        r113 = 33554432;
        goto L97
    L80:
        if ((r35 & 128) != 0) goto L84;
        r7 = r32;
        if (r14.changed(r7) == false) goto L85;
        int r114 = 8388608;
    L86:
        r1 = r1 | r114;
    L85:
        r114 = 4194304;
        goto L86
    L84:
        r7 = r32;
        goto L85
    L69:
        if ((r35 & 64) != 0) goto L73;
        r6 = r31;
        if (r14.changed(r6) == false) goto L74;
        int r42 = 1048576;
    L75:
        r1 = r1 | r42;
    L74:
        r42 = 524288;
        goto L75
    L73:
        r6 = r31;
        goto L74
    L58:
        if ((r35 & 32) != 0) goto L62;
        r5 = r30;
        if (r14.changed(r5) == false) goto L63;
        int r43 = 131072;
    L64:
        r1 = r1 | r43;
    L63:
        r43 = 65536;
        goto L64
    L62:
        r5 = r30;
        goto L63
    L47:
        if ((r35 & 16) != 0) goto L51;
        r4 = r29;
        if (r14.changed(r4) == false) goto L52;
        int r44 = 16384;
    L53:
        r1 = r1 | r44;
    L52:
        r44 = 8192;
        goto L53
    L51:
        r4 = r29;
        goto L52
    L37:
        if ((r34 & 3072) != 0) goto L43;
        r3 = r28;
        if (r14.changed(r3) == false) goto L41;
        int r45 = 2048;
    L42:
        r1 = r1 | r45;
        goto L45
    L41:
        r45 = 1024;
        goto L42
    L27:
        if ((r34 & 384) != 0) goto L33;
        if (r14.changed(r27) == false) goto L31;
        int r46 = 256;
    L32:
        r1 = r1 | r46;
        goto L33
    L31:
        r46 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r14.changed(r26) == false) goto L21;
        int r47 = 32;
    L22:
        r1 = r1 | r47;
        goto L24
    L21:
        r47 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r14.changed(r25) == false) goto L10;
        int r48 = 4;
    L11:
        r1 = r48 | r34;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    public final void DecorationBox(final String r41, final Function2<? super Composer, ? super Integer, Unit> r42, final boolean r43, final boolean r44, final VisualTransformation r45, final InteractionSource r46, boolean r47, Function2<? super Composer, ? super Integer, Unit> r48, Function2<? super Composer, ? super Integer, Unit> r49, Function2<? super Composer, ? super Integer, Unit> r50, Function2<? super Composer, ? super Integer, Unit> r51, Function2<? super Composer, ? super Integer, Unit> r52, Function2<? super Composer, ? super Integer, Unit> r53, Function2<? super Composer, ? super Integer, Unit> r54, TextFieldColors r55, PaddingValues r56, Function2<? super Composer, ? super Integer, Unit> r57, Composer r58, final int r59, final int r60, final int r61) {
        Composer r0 = r58.startRestartGroup(-1732281618);
        if ((r61 & 1) == 0) goto L6;
        int r1 = r59 | 6;
    L14:
        if ((r61 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r16 = 256;
        if ((r61 & 4) == 0) goto L28;
        r1 = r1 | 384;
    L34:
        int r18 = 2048;
        if ((r61 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r21 = 8192;
        if ((r61 & 16) == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        if ((r61 & 32) == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r10 = r61 & 64;
        if (r10 == 0) goto L69;
        r1 = r1 | 1572864;
    L75:
        int r9 = r61 & 128;
        if (r9 == 0) goto L79;
        r1 = r1 | 12582912;
    L85:
        int r3 = r61 & 256;
        if (r3 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r5 = r61 & 512;
        if (r5 == 0) goto L99;
        r1 = r1 | 805306368;
    L105:
        int r8 = r61 & 1024;
        if (r8 == 0) goto L109;
        int r29 = r60 | 6;
    L116:
        int r11 = r61 & 2048;
        if (r11 == 0) goto L120;
        r29 = r29 | 48;
    L126:
        int r6 = r29;
        int r2 = r61 & 4096;
        if (r2 == 0) goto L130;
        r6 = r6 | 384;
    L137:
        int r4 = r61 & 8192;
        if (r4 == 0) goto L141;
        r6 = r6 | 3072;
    L149:
        if ((r60 & 24576) != 0) goto L159;
        if ((r61 & 16384) != 0) goto L156;
        if (r0.changed(r55) == false) goto L156;
        r21 = 16384;
    L156:
        r6 = r6 | r21;
    L159:
        if ((r60 & 196608) != 0) goto L168;
        if ((r61 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L163;
    L165:
        int r17 = 65536;
    L166:
        r6 = r6 | r17;
        goto L168
    L163:
        if (r0.changed(r56) == false) goto L165;
        r17 = 131072;
    L168:
        int r19 = r61 & 65536;
        if (r19 == 0) goto L172;
        r6 = r6 | 1572864;
    L179:
        if ((r61 & 131072) == 0) goto L182;
        r6 = r6 | 12582912;
    L188:
        boolean r110 = false;
        if ((r1 & 306783379) == 306783378) goto L191;
    L194:
        boolean r7 = true;
    L196:
        if (r0.shouldExecute(r7, r1 & 1) == false) goto L270;
        r0.startDefaults();
        if ((r59 & 1) != 0) goto L200;
    L209:
        if (r10 == 0) goto L211;
        final boolean r12 = false;
    L212:
        if (r9 == 0) goto L214;
        final Function2<? super Composer, ? super Integer, Unit> r13 = null;
    L215:
        if (r3 == 0) goto L217;
        Function2<? super Composer, ? super Integer, Unit> r14 = null;
    L218:
        if (r5 == 0) goto L220;
        Function2<? super Composer, ? super Integer, Unit> r15 = null;
    L221:
        if (r8 == 0) goto L223;
        Function2<? super Composer, ? super Integer, Unit> r20 = null;
    L224:
        if (r11 == 0) goto L226;
        Function2<? super Composer, ? super Integer, Unit> r111 = null;
    L227:
        if (r2 == 0) goto L229;
        Function2<? super Composer, ? super Integer, Unit> r22 = null;
    L230:
        if (r4 == 0) goto L232;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L234:
        if ((r61 & 16384) == 0) goto L236;
        final TextFieldColors r112 = colors(r0, (r6 >> 21) & 14);
        r6 = r6 & (-57345);
    L238:
        if ((r61 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L240;
        PaddingValues r113 = m2968contentPaddinga9UjIt4$default(this, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        r6 = r6 & (-458753);
    L241:
        if (r19 == 0) goto L243;
        Function2<? super Composer, ? super Integer, Unit> r410 = r22;
        Function2<? super Composer, ? super Integer, Unit> r24 = r20;
        Function2<? super Composer, ? super Integer, Unit> r25 = r410;
        Function2<? super Composer, ? super Integer, Unit> r37 = ComposableLambdaKt.rememberComposableLambda(-896270173, true, new AnonymousClass1(r43, r12, r46, r112), r0, 54);
    L244:
        int r26 = r6;
        PaddingValues r114 = r113;
        Function2<? super Composer, ? super Integer, Unit> r27 = r14;
        Function2<? super Composer, ? super Integer, Unit> r28 = r23;
    L245:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L249;
        ComposerKt.traceEventStart(-1732281618, r1, r26, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1168)");
    L249:
        if ((r1 & 14) != 4) goto L251;
        boolean r115 = true;
    L253:
        if ((57344 & r1) != 16384) goto L255;
        r110 = true;
    L255:
        boolean r116 = r115 | r110;
        Object r117 = r0.rememberedValue();
        if (r116 == false) goto L258;
    L261:
        Object r118 = r45.filter(new AnnotatedString(r41, null, 2, null));
        r0.updateRememberedValue(r118);
    L262:
        String r119 = ((TransformedText) r118).getText().getText();
        TextFieldType r120 = TextFieldType.Outlined;
        TextFieldLabelPosition.Attached r121 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
        if (r13 != null) goto L265;
        r0.startReplaceGroup(1927058812);
        r0.endReplaceGroup();
        Function3 r210 = null;
    L266:
        int r122 = r1 >> 9;
        int r30 = ((((r1 << 3) & 896) | 6) | (458752 & r122)) | (3670016 & r122);
        int r123 = r26 << 21;
        int r35 = ((r30 | (29360128 & r123)) | (234881024 & r123)) | (r123 & 1879048192);
        int r31 = ((((r26 >> 9) & 14) | ((r1 >> 6) & 112)) | (r1 & 896)) | (r122 & 7168);
        Function2<? super Composer, ? super Integer, Unit> r211 = r27;
        Function2<? super Composer, ? super Integer, Unit> r212 = r15;
        Function2<? super Composer, ? super Integer, Unit> r213 = r24;
        Function2<? super Composer, ? super Integer, Unit> r214 = r111;
        Function2<? super Composer, ? super Integer, Unit> r215 = r25;
        Function2<? super Composer, ? super Integer, Unit> r216 = r28;
        boolean r217 = r12;
        PaddingValues r32 = r114;
        TextFieldColors r33 = r112;
        Function2<? super Composer, ? super Integer, Unit> r34 = r37;
        TextFieldImplKt.CommonDecorationBox(r120, r119, r42, r121, r210, r211, r212, r213, r214, r215, r216, r44, r43, r217, r46, r32, r33, r34, r0, r35, (((((r1 >> 3) & 57344) | r31) | (458752 & r26)) | ((r26 << 6) & 3670016)) | ((r26 << 3) & 29360128));
        if (ComposerKt.isTraceInProgress() == false) goto L269;
        ComposerKt.traceEventEnd();
    L269:
        final TextFieldColors r124 = r112;
        final Function2<? super Composer, ? super Integer, Unit> r36 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r125 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r126 = r25;
        final Function2<? super Composer, ? super Integer, Unit> r127 = r15;
        final boolean r38 = r12;
        final Function2<? super Composer, ? super Integer, Unit> r128 = r111;
        final PaddingValues r129 = r114;
        final Function2<? super Composer, ? super Integer, Unit> r130 = r37;
        final Function2<? super Composer, ? super Integer, Unit> r131 = r27;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r28;
    L271:
        ScopeUpdateScope r39 = r0.endRestartGroup();
        if (r39 == null) goto L275;
        r39.updateScope(new ti(this, r41, r42, r43, r44, r45, r46, r38, r36, r131, r127, r125, r128, r126, r132, r124, r129, r130, r59, r60, r61));
        return;
    L275:
        return;
    L265:
        r0.startReplaceGroup(1927058813);
        Function3 r40 = ComposableLambdaKt.rememberComposableLambda(-1459717586, true, new OutlinedTextFieldDefaults$DecorationBox$2$1(r13), r0, 54);
        r0.endReplaceGroup();
        r210 = r40;
        goto L266
    L258:
        if (r117 == Composer.Companion.getEmpty()) goto L261;
        r118 = r117;
        goto L262
    L251:
        r115 = false;
        goto L253
    L243:
        r24 = r20;
        r25 = r22;
        r37 = r57;
        goto L244
    L240:
        r113 = r56;
        goto L241
    L236:
        r112 = r55;
        goto L238
    L232:
        r23 = r54;
        goto L234
    L229:
        r22 = r53;
        goto L230
    L226:
        r111 = r52;
        goto L227
    L223:
        r20 = r51;
        goto L224
    L220:
        r15 = r50;
        goto L221
    L217:
        r14 = r49;
        goto L218
    L214:
        r13 = r48;
        goto L215
    L211:
        r12 = r47;
        goto L212
    L200:
        if (r0.getDefaultsInvalid() == true) goto L209;
        r0.skipToGroupEnd();
        if ((r61 & 16384) == 0) goto L206;
        r6 = r6 & (-57345);
    L206:
        if ((32768 & r61) == 0) goto L208;
        r6 = r6 & (-458753);
    L208:
        r12 = r47;
        r13 = r48;
        r27 = r49;
        r15 = r50;
        r24 = r51;
        r111 = r52;
        r25 = r53;
        r112 = r55;
        r114 = r56;
        r37 = r57;
        r26 = r6;
        r28 = r54;
        goto L245
    L270:
        r0.skipToGroupEnd();
        r38 = r47;
        r36 = r48;
        r131 = r49;
        r127 = r50;
        r125 = r51;
        r128 = r52;
        r126 = r53;
        r132 = r54;
        r124 = r55;
        r129 = r56;
        r130 = r57;
        goto L271
    L191:
        if ((4793491 & r6) != 4793490) goto L194;
        r7 = false;
        goto L196
    L182:
        if ((r60 & 12582912) != 0) goto L188;
        if (r0.changed(this) == false) goto L186;
        int r133 = 8388608;
    L187:
        r6 = r6 | r133;
        goto L188
    L186:
        r133 = 4194304;
        goto L187
    L172:
        if ((r60 & 1572864) != 0) goto L179;
        if (r0.changedInstance(r57) == false) goto L176;
        int r134 = 1048576;
    L177:
        r6 = r6 | r134;
        goto L179
    L176:
        r134 = 524288;
        goto L177
    L141:
        if ((r60 & 3072) != 0) goto L149;
        if (r0.changedInstance(r54) == true) goto L146;
        r18 = 1024;
    L146:
        r6 = r6 | r18;
        goto L149
    L130:
        if ((r60 & 384) != 0) goto L137;
        if (r0.changedInstance(r53) == true) goto L135;
        r16 = 128;
    L135:
        r6 = r6 | r16;
        goto L137
    L120:
        if ((r60 & 48) != 0) goto L126;
        if (r0.changedInstance(r52) == false) goto L124;
        int r218 = 32;
    L125:
        r29 = r29 | r218;
        goto L126
    L124:
        r218 = 16;
        goto L125
    L109:
        if ((r60 & 6) == 0) goto L111;
        r29 = r60;
        goto L116
    L111:
        if (r0.changedInstance(r51) == false) goto L113;
        int r219 = 4;
    L114:
        r29 = r60 | r219;
        goto L116
    L113:
        r219 = 2;
        goto L114
    L99:
        if ((r59 & 805306368) != 0) goto L105;
        if (r0.changedInstance(r50) == false) goto L103;
        int r220 = 536870912;
    L104:
        r1 = r1 | r220;
        goto L105
    L103:
        r220 = 268435456;
        goto L104
    L89:
        if ((r59 & 100663296) != 0) goto L95;
        if (r0.changedInstance(r49) == false) goto L93;
        int r221 = 67108864;
    L94:
        r1 = r1 | r221;
        goto L95
    L93:
        r221 = 33554432;
        goto L94
    L79:
        if ((r59 & 12582912) != 0) goto L85;
        if (r0.changedInstance(r48) == false) goto L83;
        int r222 = 8388608;
    L84:
        r1 = r1 | r222;
        goto L85
    L83:
        r222 = 4194304;
        goto L84
    L69:
        if ((r59 & 1572864) != 0) goto L75;
        if (r0.changed(r47) == false) goto L73;
        int r223 = 1048576;
    L74:
        r1 = r1 | r223;
        goto L75
    L73:
        r223 = 524288;
        goto L74
    L59:
        if ((r59 & 196608) != 0) goto L65;
        if (r0.changed(r46) == false) goto L63;
        int r135 = 131072;
    L64:
        r1 = r1 | r135;
        goto L65
    L63:
        r135 = 65536;
        goto L64
    L49:
        if ((r59 & 24576) != 0) goto L56;
        if (r0.changed(r45) == false) goto L53;
        int r136 = 16384;
    L54:
        r1 = r1 | r136;
        goto L56
    L53:
        r136 = 8192;
        goto L54
    L38:
        if ((r59 & 3072) != 0) goto L45;
        if (r0.changed(r44) == false) goto L42;
        int r224 = 2048;
    L43:
        r1 = r1 | r224;
        goto L45
    L42:
        r224 = 1024;
        goto L43
    L28:
        if ((r59 & 384) != 0) goto L34;
        if (r0.changed(r43) == false) goto L32;
        int r137 = 256;
    L33:
        r1 = r1 | r137;
        goto L34
    L32:
        r137 = 128;
        goto L33
    L17:
        if ((r59 & 48) != 0) goto L24;
        if (r0.changedInstance(r42) == false) goto L21;
        int r138 = 32;
    L22:
        r1 = r1 | r138;
        goto L24
    L21:
        r138 = 16;
        goto L22
    L6:
        if ((r59 & 6) == 0) goto L8;
        r1 = r59;
        goto L14
    L8:
        if (r0.changed(r41) == false) goto L10;
        int r62 = 4;
    L11:
        r1 = r62 | r59;
        goto L14
    L10:
        r62 = 2;
        goto L11
    }

    public final TextFieldDecorator decorator(TextFieldState r29, final boolean r30, TextFieldLineLimits r31, OutputTransformation r32, final InteractionSource r33, TextFieldLabelPosition r34, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r35, Function2<? super Composer, ? super Integer, Unit> r36, Function2<? super Composer, ? super Integer, Unit> r37, Function2<? super Composer, ? super Integer, Unit> r38, Function2<? super Composer, ? super Integer, Unit> r39, Function2<? super Composer, ? super Integer, Unit> r40, Function2<? super Composer, ? super Integer, Unit> r41, boolean r42, TextFieldColors r43, PaddingValues r44, Function2<? super Composer, ? super Integer, Unit> r45, Composer r46, int r47, int r48, int r49) {
        if ((r49 & 32) == 0) goto L5;
        TextFieldLabelPosition r14 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
    L7:
        if ((r49 & 64) == 0) goto L9;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r15 = null;
    L11:
        if ((r49 & 128) == 0) goto L13;
        Function2<? super Composer, ? super Integer, Unit> r16 = null;
    L15:
        if ((r49 & 256) == 0) goto L17;
        Function2<? super Composer, ? super Integer, Unit> r17 = null;
    L19:
        if ((r49 & 512) == 0) goto L21;
        Function2<? super Composer, ? super Integer, Unit> r18 = null;
    L23:
        if ((r49 & 1024) == 0) goto L25;
        Function2<? super Composer, ? super Integer, Unit> r19 = null;
    L27:
        if ((r49 & 2048) == 0) goto L29;
        Function2<? super Composer, ? super Integer, Unit> r20 = null;
    L31:
        if ((r49 & 4096) == 0) goto L33;
        Function2<? super Composer, ? super Integer, Unit> r21 = null;
    L35:
        if ((r49 & 8192) == 0) goto L37;
        final boolean r3 = false;
    L39:
        if ((r49 & 16384) == 0) goto L41;
        final TextFieldColors r4 = colors(r46, (r48 >> 21) & 14);
    L43:
        if ((32768 & r49) == 0) goto L45;
        PaddingValues r25 = m2968contentPaddinga9UjIt4$default(this, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L47:
        if ((r49 & 65536) == 0) goto L49;
        Function2<? super Composer, ? super Integer, Unit> r27 = ComposableLambdaKt.rememberComposableLambda(-163468598, true, new C02711(r30, r3, r33, r4), r46, 54);
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventStart(-449059361, r47, r48, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator (TextFieldDefaults.kt:993)");
    L53:
        AnonymousClass2 r0 = new AnonymousClass2(r32, r29, r31, r14, r15, r16, r17, r18, r19, r20, r21, r30, r3, r33, r25, r4, r27);
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventEnd();
    L56:
        return r0;
    L49:
        r27 = r45;
        goto L51
    L45:
        r25 = r44;
        goto L47
    L41:
        r4 = r43;
        goto L43
    L37:
        r3 = r42;
        goto L39
    L33:
        r21 = r41;
        goto L35
    L29:
        r20 = r40;
        goto L31
    L25:
        r19 = r39;
        goto L27
    L21:
        r18 = r38;
        goto L23
    L17:
        r17 = r37;
        goto L19
    L13:
        r16 = r36;
        goto L15
    L9:
        r15 = r35;
        goto L11
    L5:
        r14 = r34;
        goto L7
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m2971colors0hiis_0(long r88, long r90, long r92, long r94, long r96, long r98, long r100, long r102, long r104, long r106, TextSelectionColors r108, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, Composer r173, int r174, int r175, int r176, int r177, int r178, int r179, int r180) {
        if ((r179 & 1) == 0) goto L5;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r179 & 2) == 0) goto L9;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r179 & 4) == 0) goto L13;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r179 & 8) == 0) goto L17;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r179 & 16) == 0) goto L21;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r179 & 32) == 0) goto L25;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r179 & 64) == 0) goto L29;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L30:
        long r1710 = r15;
        if ((r179 & 128) == 0) goto L33;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r16;
        if ((r179 & 256) == 0) goto L37;
        long r18 = Color.Companion.getUnspecified-0d7_KjU();
    L38:
        long r19 = r18;
        if ((r179 & 512) == 0) goto L41;
        long r110 = Color.Companion.getUnspecified-0d7_KjU();
    L42:
        long r21 = r110;
        if ((r179 & 1024) == 0) goto L45;
        TextSelectionColors r112 = null;
    L46:
        TextSelectionColors r114 = r112;
        if ((r179 & 2048) == 0) goto L49;
        long r23 = Color.Companion.getUnspecified-0d7_KjU();
    L51:
        if ((r179 & 4096) == 0) goto L53;
        long r25 = Color.Companion.getUnspecified-0d7_KjU();
    L55:
        if ((r179 & 8192) == 0) goto L57;
        long r27 = Color.Companion.getUnspecified-0d7_KjU();
    L59:
        if ((r179 & 16384) == 0) goto L61;
        long r29 = Color.Companion.getUnspecified-0d7_KjU();
    L63:
        if ((32768 & r179) == 0) goto L65;
        long r31 = Color.Companion.getUnspecified-0d7_KjU();
    L67:
        if ((65536 & r179) == 0) goto L69;
        long r33 = Color.Companion.getUnspecified-0d7_KjU();
    L71:
        if ((131072 & r179) == 0) goto L73;
        long r35 = Color.Companion.getUnspecified-0d7_KjU();
    L75:
        if ((262144 & r179) == 0) goto L77;
        long r37 = Color.Companion.getUnspecified-0d7_KjU();
    L79:
        if ((524288 & r179) == 0) goto L81;
        long r39 = Color.Companion.getUnspecified-0d7_KjU();
    L83:
        if ((1048576 & r179) == 0) goto L85;
        long r41 = Color.Companion.getUnspecified-0d7_KjU();
    L87:
        if ((2097152 & r179) == 0) goto L89;
        long r43 = Color.Companion.getUnspecified-0d7_KjU();
    L91:
        if ((4194304 & r179) == 0) goto L93;
        long r45 = Color.Companion.getUnspecified-0d7_KjU();
    L95:
        if ((8388608 & r179) == 0) goto L97;
        long r47 = Color.Companion.getUnspecified-0d7_KjU();
    L99:
        if ((16777216 & r179) == 0) goto L101;
        long r49 = Color.Companion.getUnspecified-0d7_KjU();
    L103:
        if ((33554432 & r179) == 0) goto L105;
        long r51 = Color.Companion.getUnspecified-0d7_KjU();
    L107:
        if ((67108864 & r179) == 0) goto L109;
        long r53 = Color.Companion.getUnspecified-0d7_KjU();
    L111:
        if ((134217728 & r179) == 0) goto L113;
        long r55 = Color.Companion.getUnspecified-0d7_KjU();
    L115:
        if ((268435456 & r179) == 0) goto L117;
        long r57 = Color.Companion.getUnspecified-0d7_KjU();
    L119:
        if ((536870912 & r179) == 0) goto L121;
        long r59 = Color.Companion.getUnspecified-0d7_KjU();
    L123:
        if ((r179 & 1073741824) == 0) goto L125;
        long r61 = Color.Companion.getUnspecified-0d7_KjU();
    L127:
        if ((r180 & 1) == 0) goto L129;
        long r63 = Color.Companion.getUnspecified-0d7_KjU();
    L131:
        if ((r180 & 2) == 0) goto L133;
        long r65 = Color.Companion.getUnspecified-0d7_KjU();
    L135:
        if ((r180 & 4) == 0) goto L137;
        long r67 = Color.Companion.getUnspecified-0d7_KjU();
    L139:
        if ((r180 & 8) == 0) goto L141;
        long r69 = Color.Companion.getUnspecified-0d7_KjU();
    L143:
        if ((r180 & 16) == 0) goto L145;
        long r71 = Color.Companion.getUnspecified-0d7_KjU();
    L147:
        if ((r180 & 32) == 0) goto L149;
        long r73 = Color.Companion.getUnspecified-0d7_KjU();
    L151:
        if ((r180 & 64) == 0) goto L153;
        long r75 = Color.Companion.getUnspecified-0d7_KjU();
    L155:
        if ((r180 & 128) == 0) goto L157;
        long r77 = Color.Companion.getUnspecified-0d7_KjU();
    L159:
        if ((r180 & 256) == 0) goto L161;
        long r79 = Color.Companion.getUnspecified-0d7_KjU();
    L163:
        if ((r180 & 512) == 0) goto L165;
        long r81 = Color.Companion.getUnspecified-0d7_KjU();
    L167:
        if ((r180 & 1024) == 0) goto L169;
        long r83 = Color.Companion.getUnspecified-0d7_KjU();
    L171:
        if ((r180 & 2048) == 0) goto L173;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L175:
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventStart(1767617725, r174, r175, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1317)");
    L178:
        TextFieldColors r0 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(r173, 6), r173, (r178 >> 6) & 112).m3277copyejIjP34(r3, r5, r7, r9, r11, r13, r1710, r17, r19, r21, r114, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r1);
        if (ComposerKt.isTraceInProgress() == false) goto L181;
        ComposerKt.traceEventEnd();
    L181:
        return r0;
    L173:
        r1 = r171;
        goto L175
    L169:
        r83 = r169;
        goto L171
    L165:
        r81 = r167;
        goto L167
    L161:
        r79 = r165;
        goto L163
    L157:
        r77 = r163;
        goto L159
    L153:
        r75 = r161;
        goto L155
    L149:
        r73 = r159;
        goto L151
    L145:
        r71 = r157;
        goto L147
    L141:
        r69 = r155;
        goto L143
    L137:
        r67 = r153;
        goto L139
    L133:
        r65 = r151;
        goto L135
    L129:
        r63 = r149;
        goto L131
    L125:
        r61 = r147;
        goto L127
    L121:
        r59 = r145;
        goto L123
    L117:
        r57 = r143;
        goto L119
    L113:
        r55 = r141;
        goto L115
    L109:
        r53 = r139;
        goto L111
    L105:
        r51 = r137;
        goto L107
    L101:
        r49 = r135;
        goto L103
    L97:
        r47 = r133;
        goto L99
    L93:
        r45 = r131;
        goto L95
    L89:
        r43 = r129;
        goto L91
    L85:
        r41 = r127;
        goto L87
    L81:
        r39 = r125;
        goto L83
    L77:
        r37 = r123;
        goto L79
    L73:
        r35 = r121;
        goto L75
    L69:
        r33 = r119;
        goto L71
    L65:
        r31 = r117;
        goto L67
    L61:
        r29 = r115;
        goto L63
    L57:
        r27 = r113;
        goto L59
    L53:
        r25 = r111;
        goto L55
    L49:
        r23 = r109;
        goto L51
    L45:
        r112 = r108;
        goto L46
    L41:
        r110 = r106;
        goto L42
    L37:
        r18 = r104;
        goto L38
    L33:
        r16 = r102;
        goto L34
    L29:
        r15 = r100;
        goto L30
    L25:
        r13 = r98;
        goto L27
    L21:
        r11 = r96;
        goto L23
    L17:
        r9 = r94;
        goto L19
    L13:
        r7 = r92;
        goto L15
    L9:
        r5 = r90;
        goto L11
    L5:
        r3 = r88;
        goto L7
    }
}
