package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a£\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#28\b\u0002\u0010$\u001a2\u0012\u0004\u0012\u00020&\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010'0\u0013¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0001\u0018\u00010%¢\u0006\u0002\b\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0007¢\u0006\u0002\u00105\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010A\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u00020B2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010C\u001a\u0088\u0002\u0010D\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010E\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0019\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u00102\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010G\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010=\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00010\u000e2\u0011\u0010L\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010M\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010N\u001a\u000202H\u0001¢\u0006\u0002\u0010O\u001a*\u0010P\u001a\u00020\u0005*\u00020\u00052\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020K0\u00132\u0006\u0010R\u001a\u00020S2\u0006\u0010N\u001a\u000202H\u0000\"\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V¨\u0006W"}, d2 = {"OutlinedTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "value", "", "onValueChange", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "outlineCutout", "labelSize", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InputTransformation $inputTransformation;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ Function3<TextFieldLabelScope, Composer, Integer, Unit> $label;
        final /* synthetic */ TextFieldLabelPosition $labelPosition;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ TextStyle $mergedTextStyle;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ KeyboardActionHandler $onKeyboardAction;
        final /* synthetic */ Function2<Density, Function0<TextLayoutResult>, Unit> $onTextLayout;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ ScrollState $scrollState;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Modifier r3, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r4, TextFieldLabelPosition r5, boolean r6, TextFieldColors r7, TextFieldState r8, boolean r9, TextFieldLineLimits r10, OutputTransformation r11, MutableInteractionSource r12, Function2<? super Composer, ? super Integer, Unit> r13, Function2<? super Composer, ? super Integer, Unit> r14, Function2<? super Composer, ? super Integer, Unit> r15, Function2<? super Composer, ? super Integer, Unit> r16, Function2<? super Composer, ? super Integer, Unit> r17, Function2<? super Composer, ? super Integer, Unit> r18, PaddingValues r19, boolean r20, InputTransformation r21, TextStyle r22, KeyboardOptions r23, KeyboardActionHandler r24, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r25, ScrollState r26, Shape r27) {
            this.$modifier = r3;
            this.$label = r4;
            this.$labelPosition = r5;
            this.$isError = r6;
            this.$colors = r7;
            this.$state = r8;
            this.$enabled = r9;
            this.$lineLimits = r10;
            this.$outputTransformation = r11;
            this.$interactionSource = r12;
            this.$placeholder = r13;
            this.$leadingIcon = r14;
            this.$trailingIcon = r15;
            this.$prefix = r16;
            this.$suffix = r17;
            this.$supportingText = r18;
            this.$contentPadding = r19;
            this.$readOnly = r20;
            this.$inputTransformation = r21;
            this.$mergedTextStyle = r22;
            this.$keyboardOptions = r23;
            this.$onKeyboardAction = r24;
            this.$onTextLayout = r25;
            this.$scrollState = r26;
            this.$shape = r27;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
            return Unit.INSTANCE;
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
        public final void invoke(Composer r43, int r44) {
            if ((r44 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r43.shouldExecute(r2, r44 & 1) == true) goto L9;
            r43.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-416142558, r44, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:240)");
        L11:
            Modifier r1 = this.$modifier;
            if (this.$label != null) goto L14;
        L19:
            r43.startReplaceGroup(-2026714080);
            r43.endReplaceGroup();
            Modifier r3 = Modifier.Companion;
        L20:
            Modifier r4 = TextFieldImplKt.defaultErrorSemantics(r1.then(r3), this.$isError, Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131896082), r43, 0));
            OutlinedTextFieldDefaults r5 = OutlinedTextFieldDefaults.INSTANCE;
            Modifier r24 = SizeKt.m998defaultMinSizeVpY3zN4(r4, r5.m2975getMinWidthD9Ej5fM(), r5.m2974getMinHeightD9Ej5fM());
            SolidColor r6 = new SolidColor(this.$colors.m3278cursorColorvNxB06k$material3(this.$isError), null);
            TextFieldState r7 = this.$state;
            final boolean r13 = this.$enabled;
            TextFieldLineLimits r8 = this.$lineLimits;
            OutputTransformation r9 = this.$outputTransformation;
            final MutableInteractionSource r12 = this.$interactionSource;
            TextFieldLabelPosition r10 = this.$labelPosition;
            Function3<TextFieldLabelScope, Composer, Integer, Unit> r11 = this.$label;
            Function2<? super Composer, ? super Integer, Unit> r14 = this.$placeholder;
            Function2<? super Composer, ? super Integer, Unit> r15 = this.$leadingIcon;
            Function2<? super Composer, ? super Integer, Unit> r16 = this.$trailingIcon;
            Function2<? super Composer, ? super Integer, Unit> r17 = this.$prefix;
            Function2<? super Composer, ? super Integer, Unit> r18 = this.$suffix;
            Function2<? super Composer, ? super Integer, Unit> r19 = this.$supportingText;
            final boolean r20 = this.$isError;
            final TextFieldColors r21 = this.$colors;
            PaddingValues r22 = this.$contentPadding;
            final Shape r23 = this.$shape;
            TextFieldDecorator r36 = r5.decorator(r7, r13, r8, r9, r12, r10, r11, r14, r15, r16, r17, r18, r19, r20, r21, r22, ComposableLambdaKt.rememberComposableLambda(-98391231, true, new AnonymousClass2(r13, r20, r12, r21, r23), r43, 54), r43, 0, 14155776, 0);
            BasicTextFieldKt.BasicTextField(this.$state, r24, this.$enabled, this.$readOnly, this.$inputTransformation, this.$mergedTextStyle, this.$keyboardOptions, this.$onKeyboardAction, this.$lineLimits, this.$onTextLayout, this.$interactionSource, r6, this.$outputTransformation, r36, this.$scrollState, r43, 0, 0, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L25;
            ComposerKt.traceEventEnd();
            return;
        L25:
            return;
        L14:
            if ((this.$labelPosition instanceof TextFieldLabelPosition.Above) == true) goto L19;
            r43.startReplaceGroup(-2027097767);
            Modifier.Companion r25 = Modifier.Companion;
            Object r26 = r43.rememberedValue();
            if (r26 != Composer.Companion.getEmpty()) goto L18;
            r26 = new cj();
            r43.updateRememberedValue(r26);
        L18:
            r3 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r25, true, (Function1) r26), MenuKt.ClosedAlphaTarget, TextFieldImplKt.minimizedLabelHalfHeight(r43, 0), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 13, null);
            r43.endReplaceGroup();
            goto L20
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ TextStyle $mergedTextStyle;
        final /* synthetic */ int $minLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<String, Unit> $onValueChange;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Modifier r3, Function2<? super Composer, ? super Integer, Unit> r4, boolean r5, TextFieldColors r6, String r7, Function1<? super String, Unit> r8, boolean r9, boolean r10, TextStyle r11, KeyboardOptions r12, KeyboardActions r13, boolean r14, int r15, int r16, VisualTransformation r17, MutableInteractionSource r18, Function2<? super Composer, ? super Integer, Unit> r19, Function2<? super Composer, ? super Integer, Unit> r20, Function2<? super Composer, ? super Integer, Unit> r21, Function2<? super Composer, ? super Integer, Unit> r22, Function2<? super Composer, ? super Integer, Unit> r23, Function2<? super Composer, ? super Integer, Unit> r24, Shape r25) {
            this.$modifier = r3;
            this.$label = r4;
            this.$isError = r5;
            this.$colors = r6;
            this.$value = r7;
            this.$onValueChange = r8;
            this.$enabled = r9;
            this.$readOnly = r10;
            this.$mergedTextStyle = r11;
            this.$keyboardOptions = r12;
            this.$keyboardActions = r13;
            this.$singleLine = r14;
            this.$maxLines = r15;
            this.$minLines = r16;
            this.$visualTransformation = r17;
            this.$interactionSource = r18;
            this.$placeholder = r19;
            this.$leadingIcon = r20;
            this.$trailingIcon = r21;
            this.$prefix = r22;
            this.$suffix = r23;
            this.$supportingText = r24;
            this.$shape = r25;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r44, int r45) {
            if ((r45 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r44.shouldExecute(r2, r45 & 1) == true) goto L9;
            r44.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1874034984, r45, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:405)");
        L11:
            Modifier r1 = this.$modifier;
            if (this.$label == null) goto L17;
            r44.startReplaceGroup(-903490605);
            Modifier.Companion r3 = Modifier.Companion;
            Object r4 = r44.rememberedValue();
            if (r4 != Composer.Companion.getEmpty()) goto L16;
            r4 = new dj();
            r44.updateRememberedValue(r4);
        L16:
            Modifier r5 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r3, true, (Function1) r4), MenuKt.ClosedAlphaTarget, TextFieldImplKt.minimizedLabelHalfHeight(r44, 0), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 13, null);
            r44.endReplaceGroup();
        L18:
            Modifier r6 = TextFieldImplKt.defaultErrorSemantics(r1.then(r5), this.$isError, Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131896082), r44, 0));
            OutlinedTextFieldDefaults r7 = OutlinedTextFieldDefaults.INSTANCE;
            Modifier r8 = SizeKt.m998defaultMinSizeVpY3zN4(r6, r7.m2975getMinWidthD9Ej5fM(), r7.m2974getMinHeightD9Ej5fM());
            SolidColor r9 = new SolidColor(this.$colors.m3278cursorColorvNxB06k$material3(this.$isError), null);
            final String r12 = this.$value;
            Function1<String, Unit> r10 = this.$onValueChange;
            final boolean r11 = this.$enabled;
            boolean r13 = this.$readOnly;
            TextStyle r14 = this.$mergedTextStyle;
            KeyboardOptions r15 = this.$keyboardOptions;
            KeyboardActions r16 = this.$keyboardActions;
            final boolean r17 = this.$singleLine;
            int r18 = this.$maxLines;
            int r19 = this.$minLines;
            final VisualTransformation r110 = this.$visualTransformation;
            final MutableInteractionSource r111 = this.$interactionSource;
            final boolean r20 = this.$isError;
            final Function2<Composer, Integer, Unit> r21 = this.$label;
            final Function2<Composer, Integer, Unit> r22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> r23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> r24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> r25 = this.$prefix;
            final Function2<Composer, Integer, Unit> r26 = this.$suffix;
            final Function2<Composer, Integer, Unit> r112 = this.$supportingText;
            final TextFieldColors r113 = this.$colors;
            final Shape r114 = this.$shape;
            BasicTextFieldKt.BasicTextField(r12, r10, r8, r11, r13, r14, r15, r16, r17, r18, r19, r110, null, r111, r9, ComposableLambdaKt.rememberComposableLambda(-1189274459, true, new AnonymousClass2(r12, r11, r17, r110, r111, r20, r21, r22, r23, r24, r25, r26, r112, r113, r114), r44, 54), r44, 0, 196608, 4096);
            if (ComposerKt.isTraceInProgress() == false) goto L23;
            ComposerKt.traceEventEnd();
            return;
        L23:
            return;
        L17:
            r44.startReplaceGroup(-903106918);
            r44.endReplaceGroup();
            r5 = Modifier.Companion;
            goto L18
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass5 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ KeyboardOptions $keyboardOptions;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ TextStyle $mergedTextStyle;
        final /* synthetic */ int $minLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Function2<Composer, Integer, Unit> $prefix;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ Function2<Composer, Integer, Unit> $suffix;
        final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        public AnonymousClass5(Modifier r3, Function2<? super Composer, ? super Integer, Unit> r4, boolean r5, TextFieldColors r6, TextFieldValue r7, Function1<? super TextFieldValue, Unit> r8, boolean r9, boolean r10, TextStyle r11, KeyboardOptions r12, KeyboardActions r13, boolean r14, int r15, int r16, VisualTransformation r17, MutableInteractionSource r18, Function2<? super Composer, ? super Integer, Unit> r19, Function2<? super Composer, ? super Integer, Unit> r20, Function2<? super Composer, ? super Integer, Unit> r21, Function2<? super Composer, ? super Integer, Unit> r22, Function2<? super Composer, ? super Integer, Unit> r23, Function2<? super Composer, ? super Integer, Unit> r24, Shape r25) {
            this.$modifier = r3;
            this.$label = r4;
            this.$isError = r5;
            this.$colors = r6;
            this.$value = r7;
            this.$onValueChange = r8;
            this.$enabled = r9;
            this.$readOnly = r10;
            this.$mergedTextStyle = r11;
            this.$keyboardOptions = r12;
            this.$keyboardActions = r13;
            this.$singleLine = r14;
            this.$maxLines = r15;
            this.$minLines = r16;
            this.$visualTransformation = r17;
            this.$interactionSource = r18;
            this.$placeholder = r19;
            this.$leadingIcon = r20;
            this.$trailingIcon = r21;
            this.$prefix = r22;
            this.$suffix = r23;
            this.$supportingText = r24;
            this.$shape = r25;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r44, int r45) {
            if ((r45 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r44.shouldExecute(r2, r45 & 1) == true) goto L9;
            r44.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-2094276683, r45, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:572)");
        L11:
            Modifier r1 = this.$modifier;
            if (this.$label == null) goto L17;
            r44.startReplaceGroup(-1901539802);
            Modifier.Companion r3 = Modifier.Companion;
            Object r4 = r44.rememberedValue();
            if (r4 != Composer.Companion.getEmpty()) goto L16;
            r4 = new ej();
            r44.updateRememberedValue(r4);
        L16:
            Modifier r5 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r3, true, (Function1) r4), MenuKt.ClosedAlphaTarget, TextFieldImplKt.minimizedLabelHalfHeight(r44, 0), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 13, null);
            r44.endReplaceGroup();
        L18:
            Modifier r6 = TextFieldImplKt.defaultErrorSemantics(r1.then(r5), this.$isError, Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131896082), r44, 0));
            OutlinedTextFieldDefaults r7 = OutlinedTextFieldDefaults.INSTANCE;
            Modifier r8 = SizeKt.m998defaultMinSizeVpY3zN4(r6, r7.m2975getMinWidthD9Ej5fM(), r7.m2974getMinHeightD9Ej5fM());
            SolidColor r9 = new SolidColor(this.$colors.m3278cursorColorvNxB06k$material3(this.$isError), null);
            final TextFieldValue r12 = this.$value;
            Function1<TextFieldValue, Unit> r10 = this.$onValueChange;
            final boolean r11 = this.$enabled;
            boolean r13 = this.$readOnly;
            TextStyle r14 = this.$mergedTextStyle;
            KeyboardOptions r15 = this.$keyboardOptions;
            KeyboardActions r16 = this.$keyboardActions;
            final boolean r17 = this.$singleLine;
            int r18 = this.$maxLines;
            int r19 = this.$minLines;
            final VisualTransformation r110 = this.$visualTransformation;
            final MutableInteractionSource r111 = this.$interactionSource;
            final boolean r20 = this.$isError;
            final Function2<Composer, Integer, Unit> r21 = this.$label;
            final Function2<Composer, Integer, Unit> r22 = this.$placeholder;
            final Function2<Composer, Integer, Unit> r23 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> r24 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> r25 = this.$prefix;
            final Function2<Composer, Integer, Unit> r26 = this.$suffix;
            final Function2<Composer, Integer, Unit> r112 = this.$supportingText;
            final TextFieldColors r113 = this.$colors;
            final Shape r114 = this.$shape;
            BasicTextFieldKt.BasicTextField(r12, r10, r8, r11, r13, r14, r15, r16, r17, r18, r19, r110, null, r111, r9, ComposableLambdaKt.rememberComposableLambda(674541106, true, new AnonymousClass2(r12, r11, r17, r110, r111, r20, r21, r22, r23, r24, r25, r26, r112, r113, r114), r44, 54), r44, 0, 196608, 4096);
            if (ComposerKt.isTraceInProgress() == false) goto L23;
            ComposerKt.traceEventEnd();
            return;
        L23:
            return;
        L17:
            r44.startReplaceGroup(-1901156115);
            r44.endReplaceGroup();
            r5 = Modifier.Companion;
            goto L18
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
        OutlinedTextFieldInnerPadding = Dp.constructor-impl(4);
    }

    private static final Unit OutlinedTextField$lambda$2(TextFieldState r30, Modifier r31, boolean r32, boolean r33, TextStyle r34, TextFieldLabelPosition r35, Function3 r36, Function2 r37, Function2 r38, Function2 r39, Function2 r40, Function2 r41, Function2 r42, boolean r43, InputTransformation r44, OutputTransformation r45, KeyboardOptions r46, KeyboardActionHandler r47, TextFieldLineLimits r48, Function2 r49, ScrollState r50, Shape r51, TextFieldColors r52, PaddingValues r53, MutableInteractionSource r54, int r55, int r56, int r57, int r58, Composer r59, int r60) {
        OutlinedTextField(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r59, RecomposeScopeImplKt.updateChangedFlags(r55 | 1), RecomposeScopeImplKt.updateChangedFlags(r56), RecomposeScopeImplKt.updateChangedFlags(r57), r58);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$5(String r28, Function1 r29, Modifier r30, boolean r31, boolean r32, TextStyle r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Function2 r38, Function2 r39, Function2 r40, boolean r41, VisualTransformation r42, KeyboardOptions r43, KeyboardActions r44, boolean r45, int r46, int r47, MutableInteractionSource r48, Shape r49, TextFieldColors r50, int r51, int r52, int r53, int r54, Composer r55, int r56) {
        OutlinedTextField(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r55, RecomposeScopeImplKt.updateChangedFlags(r51 | 1), RecomposeScopeImplKt.updateChangedFlags(r52), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$8(TextFieldValue r28, Function1 r29, Modifier r30, boolean r31, boolean r32, TextStyle r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Function2 r38, Function2 r39, Function2 r40, boolean r41, VisualTransformation r42, KeyboardOptions r43, KeyboardActions r44, boolean r45, int r46, int r47, MutableInteractionSource r48, Shape r49, TextFieldColors r50, int r51, int r52, int r53, int r54, Composer r55, int r56) {
        OutlinedTextField(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r55, RecomposeScopeImplKt.updateChangedFlags(r51 | 1), RecomposeScopeImplKt.updateChangedFlags(r52), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextFieldLayout$lambda$20(Modifier r18, Function2 r19, Function3 r20, Function2 r21, Function2 r22, Function2 r23, Function2 r24, Function2 r25, boolean r26, TextFieldLabelPosition r27, FloatProducer r28, Function1 r29, Function2 r30, Function2 r31, PaddingValues r32, int r33, int r34, Composer r35, int r36) {
        OutlinedTextFieldLayout(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r35, RecomposeScopeImplKt.updateChangedFlags(r33 | 1), RecomposeScopeImplKt.updateChangedFlags(r34));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r1, Function2 r2, Function3 r3, Function2 r4, Function2 r5, Function2 r6, Function2 r7, Function2 r8, boolean r9, TextFieldLabelPosition r10, FloatProducer r11, Function1 r12, Function2 r13, Function2 r14, PaddingValues r15, int r16, int r17, Composer r18, int r19) {
        return OutlinedTextFieldLayout$lambda$20(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Dp b(FloatProducer r0) {
        return OutlinedTextFieldLayout$lambda$19$lambda$16$lambda$15(r0);
    }

    public static /* synthetic */ Unit c(Function0 r0, PaddingValues r1, Alignment.Horizontal r2, ContentDrawScope r3) {
        return outlineCutout$lambda$22(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit d(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, VisualTransformation r15, KeyboardOptions r16, KeyboardActions r17, boolean r18, int r19, int r20, MutableInteractionSource r21, Shape r22, TextFieldColors r23, int r24, int r25, int r26, int r27, Composer r28, int r29) {
        return OutlinedTextField$lambda$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    public static /* synthetic */ Unit e(TextFieldState r1, Modifier r2, boolean r3, boolean r4, TextStyle r5, TextFieldLabelPosition r6, Function3 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, InputTransformation r15, OutputTransformation r16, KeyboardOptions r17, KeyboardActionHandler r18, TextFieldLineLimits r19, Function2 r20, ScrollState r21, Shape r22, TextFieldColors r23, PaddingValues r24, MutableInteractionSource r25, int r26, int r27, int r28, int r29, Composer r30, int r31) {
        return OutlinedTextField$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
    }

    public static /* synthetic */ Unit f(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, VisualTransformation r15, KeyboardOptions r16, KeyboardActions r17, boolean r18, int r19, int r20, MutableInteractionSource r21, Shape r22, TextFieldColors r23, int r24, int r25, int r26, int r27, Composer r28, int r29) {
        return OutlinedTextField$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    private static final Dp OutlinedTextFieldLayout$lambda$19$lambda$16$lambda$15(FloatProducer r2) {
        return Dp.box-impl(DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), r2.invoke()));
    }

    public static final Modifier outlineCutout(Modifier r1, final Function0<Size> r2, final Alignment.Horizontal r3, final PaddingValues r4) {
        return DrawModifierKt.drawWithContent(r1, new xi(r2, r4, r3));
    }

    private static final Unit outlineCutout$lambda$22(Function0 r12, PaddingValues r13, Alignment.Horizontal r14, ContentDrawScope r15) {
        long r0 = ((Size) r12.invoke()).unbox-impl();
        float r2 = Float.intBitsToFloat((int) (r0 >> 32));
        if (r2 <= MenuKt.ClosedAlphaTarget) goto L10;
        float r4 = r15.toPx-0680j_4(OutlinedTextFieldInnerPadding);
        float r5 = r15.toPx-0680j_4(r13.mo899calculateLeftPaddingu2uoSUM(r15.getLayoutDirection()));
        float r16 = r14.align(MathKt.roundToInt(r2), MathKt.roundToInt((Float.intBitsToFloat((int) (r15.getSize-NH-jbRc() >> 32)) - r5) - r15.toPx-0680j_4(r13.mo900calculateRightPaddingu2uoSUM(r15.getLayoutDirection()))), r15.getLayoutDirection()) + r5;
        float r17 = 2;
        float r3 = r2 / r17;
        float r18 = r16 + r3;
        float r7 = RangesKt.coerceAtLeast((r18 - r3) - r4, MenuKt.ClosedAlphaTarget);
        float r9 = RangesKt.coerceAtMost((r18 + r3) + r4, Float.intBitsToFloat((int) (r15.getSize-NH-jbRc() >> 32)));
        float r19 = Float.intBitsToFloat((int) (4294967295L & r0));
        float r8 = (-r19) / r17;
        float r10 = r19 / r17;
        int r11 = ClipOp.Companion.getDifference-rtfAjoo();
        DrawContext r110 = r15.getDrawContext();
        long r111 = r110.getSize-NH-jbRc();
        r110.getCanvas().save();
        r110.getTransform().clipRect-N_I0leg(r7, r8, r9, r10, r11);     // Catch: Throwable -> L7
        r15.drawContent();     // Catch: Throwable -> L7
        r110.getCanvas().restore();
        r110.setSize-uvyYCjk(r111);
    L12:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        r110.getCanvas().restore();
        r110.setSize-uvyYCjk(r111);
        throw th;
    L10:
        r15.drawContent();
        goto L12
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v11 ??, still in use, count: 1, list:
          (r2v11 ?? I:java.lang.Object) from 0x01ff: INVOKE (r8v2 ?? I:androidx.compose.runtime.Composer), (r2v11 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:301990399)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public static final void OutlinedTextFieldLayout(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v11 ??, still in use, count: 1, list:
          (r2v11 ?? I:java.lang.Object) from 0x01ff: INVOKE (r8v2 ?? I:androidx.compose.runtime.Composer), (r2v11 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:301990399)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r37v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    public static final void OutlinedTextField(final TextFieldValue r82, final Function1<? super TextFieldValue, Unit> r83, Modifier r84, boolean r85, boolean r86, TextStyle r87, Function2<? super Composer, ? super Integer, Unit> r88, Function2<? super Composer, ? super Integer, Unit> r89, Function2<? super Composer, ? super Integer, Unit> r90, Function2<? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, boolean r95, VisualTransformation r96, KeyboardOptions r97, KeyboardActions r98, boolean r99, int r100, int r101, MutableInteractionSource r102, Shape r103, TextFieldColors r104, Composer r105, final int r106, final int r107, final int r108, final int r109) {
        Composer r0 = r105.startRestartGroup(2057288437);
        if ((r109 & 1) == 0) goto L6;
        int r4 = r106 | 6;
    L14:
        if ((r109 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r109 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = r109 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r19 = r109 & 16;
        int r20 = 8192;
        if (r19 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r106 & 196608) != 0) goto L67;
        if ((r109 & 32) == 0) goto L62;
    L64:
        int r24 = 65536;
    L65:
        r4 = r4 | r24;
        goto L67
    L62:
        if (r0.changed(r87) == false) goto L64;
        r24 = 131072;
    L67:
        int r25 = r109 & 64;
        if (r25 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r109 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r109 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r109 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r109 & 1024;
        if (r3 == 0) goto L111;
        int r32 = r107 | 6;
    L118:
        int r5 = r109 & 2048;
        if (r5 == 0) goto L122;
        r32 = r32 | 48;
    L128:
        int r6 = r32;
        int r7 = r109 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r10 = r109 & 8192;
        if (r10 == 0) goto L143;
        r6 = r6 | 3072;
    L150:
        int r11 = r109 & 16384;
        if (r11 == 0) goto L153;
        r6 = r6 | 24576;
        int r18 = r11;
    L160:
        int r110 = r109 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r110 == 0) goto L164;
        r6 = r6 | 196608;
    L170:
        int r21 = r109 & 65536;
        if (r21 == 0) goto L174;
        r6 = r6 | 1572864;
    L180:
        int r22 = r109 & 131072;
        if (r22 == 0) goto L184;
        r6 = r6 | 12582912;
    L191:
        if ((r107 & 100663296) != 0) goto L200;
        if ((r109 & 262144) == 0) goto L195;
    L197:
        int r26 = 33554432;
    L198:
        r6 = r6 | r26;
        goto L200
    L195:
        if (r0.changed(r100) == false) goto L197;
        r26 = 67108864;
    L200:
        int r27 = r109 & 524288;
        if (r27 == 0) goto L204;
        r6 = r6 | 805306368;
    L210:
        int r29 = r109 & 1048576;
        if (r29 == 0) goto L214;
        int r23 = r108 | 6;
    L222:
        if ((r108 & 48) != 0) goto L232;
        if ((r109 & 2097152) == 0) goto L226;
    L228:
        int r28 = 16;
    L229:
        r23 = r23 | r28;
        goto L232
    L226:
        if (r0.changed(r103) == false) goto L228;
        r28 = 32;
    L232:
        if ((r108 & 384) != 0) goto L242;
        if ((r109 & 4194304) != 0) goto L239;
        if (r0.changed(r104) == false) goto L239;
        int r210 = 256;
    L240:
        r23 = r23 | r210;
    L239:
        r210 = 128;
    L242:
        int r12 = r23;
        if ((r4 & 306783379) == 306783378) goto L245;
    L250:
        boolean r13 = true;
    L252:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L358;
        r0.startDefaults();
        if ((r106 & 1) != 0) goto L256;
    L265:
        if (r8 == 0) goto L267;
        Modifier r14 = Modifier.Companion;
    L268:
        if (r16 == 0) goto L270;
        boolean r15 = true;
    L271:
        if (r19 == 0) goto L273;
        boolean r111 = false;
    L275:
        if ((r109 & 32) == 0) goto L277;
        TextStyle r112 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L278:
        MutableInteractionSource r113 = null;
        if (r25 == 0) goto L281;
        Function2<? super Composer, ? super Integer, Unit> r114 = null;
    L282:
        if (r9 == 0) goto L284;
        Function2<? super Composer, ? super Integer, Unit> r30 = null;
    L285:
        if (r1 == 0) goto L287;
        Function2<? super Composer, ? super Integer, Unit> r31 = null;
    L288:
        if (r2 == 0) goto L290;
        Function2<? super Composer, ? super Integer, Unit> r33 = null;
    L291:
        if (r3 == 0) goto L293;
        Function2<? super Composer, ? super Integer, Unit> r34 = null;
    L294:
        if (r5 == 0) goto L296;
        Function2<? super Composer, ? super Integer, Unit> r35 = null;
    L297:
        if (r7 == 0) goto L299;
        Function2<? super Composer, ? super Integer, Unit> r36 = null;
    L300:
        if (r10 == 0) goto L302;
        boolean r211 = false;
    L303:
        if (r18 == 0) goto L305;
        VisualTransformation r115 = VisualTransformation.Companion.getNone();
    L306:
        if (r110 == 0) goto L308;
        KeyboardOptions r116 = KeyboardOptions.Companion.getDefault();
    L309:
        if (r21 == 0) goto L311;
        KeyboardActions r212 = KeyboardActions.Companion.getDefault();
    L312:
        if (r22 == 0) goto L314;
        boolean r213 = false;
    L316:
        if ((r109 & 262144) == 0) goto L321;
        if (r213 == false) goto L319;
        int r214 = 1;
    L320:
        r6 = r6 & (-234881025);
    L322:
        if (r27 == 0) goto L324;
        int r215 = 1;
    L325:
        if (r29 != 0) goto L328;
        r113 = r102;
    L328:
        Function2<? super Composer, ? super Integer, Unit> r810 = r31;
        if ((r109 & 2097152) == 0) goto L331;
        Shape r37 = OutlinedTextFieldDefaults.INSTANCE.getShape(r0, 6);
    L332:
        Shape r811 = r37;
        if ((r109 & 4194304) == 0) goto L335;
        TextFieldColors r117 = OutlinedTextFieldDefaults.INSTANCE.colors(r0, 6);
    L336:
        int r118 = r4;
        MutableInteractionSource r45 = r113;
        VisualTransformation r119 = r115;
        KeyboardOptions r40 = r116;
        Function2<? super Composer, ? super Integer, Unit> r38 = r114;
        KeyboardActions r41 = r212;
        boolean r42 = r213;
        int r43 = r214;
        int r44 = r215;
        Function2<? super Composer, ? super Integer, Unit> r39 = r34;
        Function2<? super Composer, ? super Integer, Unit> r46 = r33;
        Function2<? super Composer, ? super Integer, Unit> r47 = r810;
        Function2<? super Composer, ? super Integer, Unit> r812 = r36;
        int r48 = r6;
        boolean r49 = r211;
    L337:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L341;
        ComposerKt.traceEventStart(2057288437, r118, r48, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:560)");
    L341:
        if (r45 != null) goto L346;
        r0.startReplaceGroup(-502250010);
        Object r50 = r0.rememberedValue();
        if (r50 != Composer.Companion.getEmpty()) goto L345;
        r50 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r50);
    L345:
        MutableInteractionSource r51 = (MutableInteractionSource) r50;
        r0.endReplaceGroup();
    L347:
        r0.startReplaceGroup(1369277167);
        long r120 = r112.getColor-0d7_KjU();
        if (r120 == 16) goto L350;
        boolean r52 = true;
    L351:
        if (r52 == true) goto L354;
        r120 = r117.m3328textColorXeAY9LY$material3(r15, r49, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r51, r0, 0).getValue()).booleanValue());
    L354:
        r0.endReplaceGroup();
        Function2<? super Composer, ? super Integer, Unit> r813 = r38;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r117.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-2094276683, true, new AnonymousClass5(r14, r38, r49, r117, r82, r83, r15, r111, r112.merge(new TextStyle(r120, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null)), r40, r41, r42, r43, r44, r119, r51, r30, r47, r46, r39, r35, r812, r811), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L357;
        ComposerKt.traceEventEnd();
    L357:
        final Function2<? super Composer, ? super Integer, Unit> r53 = r813;
        final VisualTransformation r121 = r119;
        final boolean r54 = r15;
        final TextFieldColors r216 = r117;
        final boolean r55 = r111;
        final KeyboardOptions r122 = r40;
        final KeyboardActions r123 = r41;
        final boolean r124 = r42;
        final int r125 = r43;
        final int r217 = r44;
        final MutableInteractionSource r218 = r45;
        final Shape r219 = r811;
        final Function2<? super Composer, ? super Integer, Unit> r126 = r812;
        final Function2<? super Composer, ? super Integer, Unit> r127 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r128 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r129 = r46;
        final Modifier r56 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r57 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r58 = r47;
        TextStyle r81 = r112;
        final boolean r130 = r49;
        final TextStyle r59 = r81;
    L359:
        ScopeUpdateScope r60 = r0.endRestartGroup();
        if (r60 == null) goto L363;
        r60.updateScope(new bj(r82, r83, r56, r54, r55, r59, r53, r57, r58, r129, r128, r127, r126, r130, r121, r122, r123, r124, r125, r217, r218, r219, r216, r106, r107, r108, r109));
        return;
    L363:
        return;
    L350:
        r52 = false;
        goto L351
    L346:
        r0.startReplaceGroup(1369271057);
        r0.endReplaceGroup();
        r51 = r45;
        goto L347
    L335:
        r117 = r104;
        goto L336
    L331:
        r37 = r103;
        goto L332
    L324:
        r215 = r101;
        goto L325
    L319:
        r214 = Integer.MAX_VALUE;
        goto L320
    L321:
        r214 = r100;
        goto L322
    L314:
        r213 = r99;
        goto L316
    L311:
        r212 = r98;
        goto L312
    L308:
        r116 = r97;
        goto L309
    L305:
        r115 = r96;
        goto L306
    L302:
        r211 = r95;
        goto L303
    L299:
        r36 = r94;
        goto L300
    L296:
        r35 = r93;
        goto L297
    L293:
        r34 = r92;
        goto L294
    L290:
        r33 = r91;
        goto L291
    L287:
        r31 = r90;
        goto L288
    L284:
        r30 = r89;
        goto L285
    L281:
        r114 = r88;
        goto L282
    L277:
        r112 = r87;
        goto L278
    L273:
        r111 = r86;
        goto L275
    L270:
        r15 = r85;
        goto L271
    L267:
        r14 = r84;
        goto L268
    L256:
        if (r0.getDefaultsInvalid() == true) goto L265;
        r0.skipToGroupEnd();
        if ((r109 & 32) == 0) goto L262;
        r4 = r4 & (-458753);
    L262:
        if ((262144 & r109) == 0) goto L264;
        r6 = r6 & (-234881025);
    L264:
        r14 = r84;
        r15 = r85;
        r111 = r86;
        r112 = r87;
        r38 = r88;
        r30 = r89;
        r47 = r90;
        r46 = r91;
        r35 = r93;
        r812 = r94;
        r119 = r96;
        r40 = r97;
        r41 = r98;
        r42 = r99;
        r43 = r100;
        r44 = r101;
        r45 = r102;
        r811 = r103;
        r117 = r104;
        r118 = r4;
        r48 = r6;
        r39 = r92;
        r49 = r95;
        goto L337
    L358:
        r0.skipToGroupEnd();
        r56 = r84;
        r54 = r85;
        r55 = r86;
        r59 = r87;
        r53 = r88;
        r57 = r89;
        r58 = r90;
        r129 = r91;
        r128 = r92;
        r127 = r93;
        r126 = r94;
        r130 = r95;
        r121 = r96;
        r122 = r97;
        r123 = r98;
        r124 = r99;
        r125 = r100;
        r217 = r101;
        r218 = r102;
        r219 = r103;
        r216 = r104;
        goto L359
    L245:
        if ((306783379 & r6) != 306783378) goto L250;
        if ((r12 & 147) != 146) goto L250;
        r13 = false;
        goto L252
    L214:
        if ((r108 & 6) == 0) goto L216;
        r23 = r108;
        goto L222
    L216:
        if (r0.changed(r102) == false) goto L218;
        int r220 = 4;
    L219:
        r23 = r108 | r220;
        goto L222
    L218:
        r220 = 2;
        goto L219
    L204:
        if ((r107 & 805306368) != 0) goto L210;
        if (r0.changed(r101) == false) goto L208;
        int r221 = 536870912;
    L209:
        r6 = r6 | r221;
        goto L210
    L208:
        r221 = 268435456;
        goto L209
    L184:
        if ((r107 & 12582912) != 0) goto L191;
        if (r0.changed(r99) == false) goto L188;
        int r222 = 8388608;
    L189:
        r6 = r6 | r222;
        goto L191
    L188:
        r222 = 4194304;
        goto L189
    L174:
        if ((r107 & 1572864) != 0) goto L180;
        if (r0.changed(r98) == false) goto L178;
        int r223 = 1048576;
    L179:
        r6 = r6 | r223;
        goto L180
    L178:
        r223 = 524288;
        goto L179
    L164:
        if ((r107 & 196608) != 0) goto L170;
        if (r0.changed(r97) == false) goto L168;
        int r224 = 131072;
    L169:
        r6 = r6 | r224;
        goto L170
    L168:
        r224 = 65536;
        goto L169
    L153:
        r18 = r11;
        if ((r107 & 24576) != 0) goto L160;
        if (r0.changed(r96) == false) goto L158;
        r20 = 16384;
    L158:
        r6 = r6 | r20;
        goto L160
    L143:
        if ((r107 & 3072) != 0) goto L150;
        if (r0.changed(r95) == true) goto L148;
        r17 = 1024;
    L148:
        r6 = r6 | r17;
        goto L150
    L132:
        if ((r107 & 384) != 0) goto L139;
        if (r0.changedInstance(r94) == false) goto L136;
        int r310 = 256;
    L137:
        r6 = r6 | r310;
        goto L139
    L136:
        r310 = 128;
        goto L137
    L122:
        if ((r107 & 48) != 0) goto L128;
        if (r0.changedInstance(r93) == false) goto L126;
        int r311 = 32;
    L127:
        r32 = r32 | r311;
        goto L128
    L126:
        r311 = 16;
        goto L127
    L111:
        if ((r107 & 6) == 0) goto L113;
        r32 = r107;
        goto L118
    L113:
        if (r0.changedInstance(r92) == false) goto L115;
        int r312 = 4;
    L116:
        r32 = r107 | r312;
        goto L118
    L115:
        r312 = 2;
        goto L116
    L101:
        if ((r106 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r91) == false) goto L105;
        int r313 = 536870912;
    L106:
        r4 = r4 | r313;
        goto L107
    L105:
        r313 = 268435456;
        goto L106
    L91:
        if ((r106 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r90) == false) goto L95;
        int r314 = 67108864;
    L96:
        r4 = r4 | r314;
        goto L97
    L95:
        r314 = 33554432;
        goto L96
    L81:
        if ((r106 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r89) == false) goto L85;
        int r315 = 8388608;
    L86:
        r4 = r4 | r315;
        goto L87
    L85:
        r315 = 4194304;
        goto L86
    L71:
        if ((r106 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r88) == false) goto L75;
        int r225 = 1048576;
    L76:
        r4 = r4 | r225;
        goto L77
    L75:
        r225 = 524288;
        goto L76
    L50:
        if ((r106 & 24576) != 0) goto L58;
        if (r0.changed(r86) == false) goto L54;
        int r226 = 16384;
    L55:
        r4 = r4 | r226;
        goto L58
    L54:
        r226 = 8192;
        goto L55
    L39:
        if ((r106 & 3072) != 0) goto L46;
        if (r0.changed(r85) == false) goto L43;
        int r131 = 2048;
    L44:
        r4 = r4 | r131;
        goto L46
    L43:
        r131 = 1024;
        goto L44
    L28:
        if ((r106 & 384) != 0) goto L35;
        if (r0.changed(r84) == false) goto L32;
        int r132 = 256;
    L33:
        r4 = r4 | r132;
        goto L35
    L32:
        r132 = 128;
        goto L33
    L17:
        if ((r106 & 48) != 0) goto L24;
        if (r0.changedInstance(r83) == false) goto L21;
        int r61 = 32;
    L22:
        r4 = r4 | r61;
        goto L24
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r106 & 6) == 0) goto L8;
        r4 = r106;
        goto L14
    L8:
        if (r0.changed(r82) == false) goto L10;
        int r62 = 4;
    L11:
        r4 = r62 | r106;
        goto L14
    L10:
        r62 = 2;
        goto L11
    }

    public static final void OutlinedTextField(final String r82, final Function1<? super String, Unit> r83, Modifier r84, boolean r85, boolean r86, TextStyle r87, Function2<? super Composer, ? super Integer, Unit> r88, Function2<? super Composer, ? super Integer, Unit> r89, Function2<? super Composer, ? super Integer, Unit> r90, Function2<? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, boolean r95, VisualTransformation r96, KeyboardOptions r97, KeyboardActions r98, boolean r99, int r100, int r101, MutableInteractionSource r102, Shape r103, TextFieldColors r104, Composer r105, final int r106, final int r107, final int r108, final int r109) {
        Composer r0 = r105.startRestartGroup(1901501544);
        if ((r109 & 1) == 0) goto L6;
        int r4 = r106 | 6;
    L14:
        if ((r109 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r109 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = r109 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r19 = r109 & 16;
        int r20 = 8192;
        if (r19 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r106 & 196608) != 0) goto L67;
        if ((r109 & 32) == 0) goto L62;
    L64:
        int r24 = 65536;
    L65:
        r4 = r4 | r24;
        goto L67
    L62:
        if (r0.changed(r87) == false) goto L64;
        r24 = 131072;
    L67:
        int r25 = r109 & 64;
        if (r25 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r109 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r109 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r109 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r109 & 1024;
        if (r3 == 0) goto L111;
        int r32 = r107 | 6;
    L118:
        int r5 = r109 & 2048;
        if (r5 == 0) goto L122;
        r32 = r32 | 48;
    L128:
        int r6 = r32;
        int r7 = r109 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r10 = r109 & 8192;
        if (r10 == 0) goto L143;
        r6 = r6 | 3072;
    L150:
        int r11 = r109 & 16384;
        if (r11 == 0) goto L153;
        r6 = r6 | 24576;
        int r18 = r11;
    L160:
        int r110 = r109 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r110 == 0) goto L164;
        r6 = r6 | 196608;
    L170:
        int r21 = r109 & 65536;
        if (r21 == 0) goto L174;
        r6 = r6 | 1572864;
    L180:
        int r22 = r109 & 131072;
        if (r22 == 0) goto L184;
        r6 = r6 | 12582912;
    L191:
        if ((r107 & 100663296) != 0) goto L200;
        if ((r109 & 262144) == 0) goto L195;
    L197:
        int r26 = 33554432;
    L198:
        r6 = r6 | r26;
        goto L200
    L195:
        if (r0.changed(r100) == false) goto L197;
        r26 = 67108864;
    L200:
        int r27 = r109 & 524288;
        if (r27 == 0) goto L204;
        r6 = r6 | 805306368;
    L210:
        int r29 = r109 & 1048576;
        if (r29 == 0) goto L214;
        int r23 = r108 | 6;
    L222:
        if ((r108 & 48) != 0) goto L232;
        if ((r109 & 2097152) == 0) goto L226;
    L228:
        int r28 = 16;
    L229:
        r23 = r23 | r28;
        goto L232
    L226:
        if (r0.changed(r103) == false) goto L228;
        r28 = 32;
    L232:
        if ((r108 & 384) != 0) goto L242;
        if ((r109 & 4194304) != 0) goto L239;
        if (r0.changed(r104) == false) goto L239;
        int r210 = 256;
    L240:
        r23 = r23 | r210;
    L239:
        r210 = 128;
    L242:
        int r12 = r23;
        if ((r4 & 306783379) == 306783378) goto L245;
    L250:
        boolean r13 = true;
    L252:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L358;
        r0.startDefaults();
        if ((r106 & 1) != 0) goto L256;
    L265:
        if (r8 == 0) goto L267;
        Modifier r14 = Modifier.Companion;
    L268:
        if (r16 == 0) goto L270;
        boolean r15 = true;
    L271:
        if (r19 == 0) goto L273;
        boolean r111 = false;
    L275:
        if ((r109 & 32) == 0) goto L277;
        TextStyle r112 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L278:
        MutableInteractionSource r113 = null;
        if (r25 == 0) goto L281;
        Function2<? super Composer, ? super Integer, Unit> r114 = null;
    L282:
        if (r9 == 0) goto L284;
        Function2<? super Composer, ? super Integer, Unit> r30 = null;
    L285:
        if (r1 == 0) goto L287;
        Function2<? super Composer, ? super Integer, Unit> r31 = null;
    L288:
        if (r2 == 0) goto L290;
        Function2<? super Composer, ? super Integer, Unit> r33 = null;
    L291:
        if (r3 == 0) goto L293;
        Function2<? super Composer, ? super Integer, Unit> r34 = null;
    L294:
        if (r5 == 0) goto L296;
        Function2<? super Composer, ? super Integer, Unit> r35 = null;
    L297:
        if (r7 == 0) goto L299;
        Function2<? super Composer, ? super Integer, Unit> r36 = null;
    L300:
        if (r10 == 0) goto L302;
        boolean r211 = false;
    L303:
        if (r18 == 0) goto L305;
        VisualTransformation r115 = VisualTransformation.Companion.getNone();
    L306:
        if (r110 == 0) goto L308;
        KeyboardOptions r116 = KeyboardOptions.Companion.getDefault();
    L309:
        if (r21 == 0) goto L311;
        KeyboardActions r212 = KeyboardActions.Companion.getDefault();
    L312:
        if (r22 == 0) goto L314;
        boolean r213 = false;
    L316:
        if ((r109 & 262144) == 0) goto L321;
        if (r213 == false) goto L319;
        int r214 = 1;
    L320:
        r6 = r6 & (-234881025);
    L322:
        if (r27 == 0) goto L324;
        int r215 = 1;
    L325:
        if (r29 != 0) goto L328;
        r113 = r102;
    L328:
        Function2<? super Composer, ? super Integer, Unit> r810 = r31;
        if ((r109 & 2097152) == 0) goto L331;
        Shape r37 = OutlinedTextFieldDefaults.INSTANCE.getShape(r0, 6);
    L332:
        Shape r811 = r37;
        if ((r109 & 4194304) == 0) goto L335;
        TextFieldColors r117 = OutlinedTextFieldDefaults.INSTANCE.colors(r0, 6);
    L336:
        int r118 = r4;
        MutableInteractionSource r45 = r113;
        VisualTransformation r119 = r115;
        KeyboardOptions r40 = r116;
        Function2<? super Composer, ? super Integer, Unit> r38 = r114;
        KeyboardActions r41 = r212;
        boolean r42 = r213;
        int r43 = r214;
        int r44 = r215;
        Function2<? super Composer, ? super Integer, Unit> r39 = r34;
        Function2<? super Composer, ? super Integer, Unit> r46 = r33;
        Function2<? super Composer, ? super Integer, Unit> r47 = r810;
        Function2<? super Composer, ? super Integer, Unit> r812 = r36;
        int r48 = r6;
        boolean r49 = r211;
    L337:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L341;
        ComposerKt.traceEventStart(1901501544, r118, r48, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:393)");
    L341:
        if (r45 != null) goto L346;
        r0.startReplaceGroup(1310051731);
        Object r50 = r0.rememberedValue();
        if (r50 != Composer.Companion.getEmpty()) goto L345;
        r50 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r50);
    L345:
        MutableInteractionSource r51 = (MutableInteractionSource) r50;
        r0.endReplaceGroup();
    L347:
        r0.startReplaceGroup(1981927842);
        long r120 = r112.getColor-0d7_KjU();
        if (r120 == 16) goto L350;
        boolean r52 = true;
    L351:
        if (r52 == true) goto L354;
        r120 = r117.m3328textColorXeAY9LY$material3(r15, r49, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r51, r0, 0).getValue()).booleanValue());
    L354:
        r0.endReplaceGroup();
        Function2<? super Composer, ? super Integer, Unit> r813 = r38;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r117.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1874034984, true, new AnonymousClass3(r14, r38, r49, r117, r82, r83, r15, r111, r112.merge(new TextStyle(r120, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null)), r40, r41, r42, r43, r44, r119, r51, r30, r47, r46, r39, r35, r812, r811), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L357;
        ComposerKt.traceEventEnd();
    L357:
        final Function2<? super Composer, ? super Integer, Unit> r53 = r813;
        final VisualTransformation r121 = r119;
        final boolean r54 = r15;
        final TextFieldColors r216 = r117;
        final boolean r55 = r111;
        final KeyboardOptions r122 = r40;
        final KeyboardActions r123 = r41;
        final boolean r124 = r42;
        final int r125 = r43;
        final int r217 = r44;
        final MutableInteractionSource r218 = r45;
        final Shape r219 = r811;
        final Function2<? super Composer, ? super Integer, Unit> r126 = r812;
        final Function2<? super Composer, ? super Integer, Unit> r127 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r128 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r129 = r46;
        final Modifier r56 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r57 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r58 = r47;
        TextStyle r81 = r112;
        final boolean r130 = r49;
        final TextStyle r59 = r81;
    L359:
        ScopeUpdateScope r60 = r0.endRestartGroup();
        if (r60 == null) goto L363;
        r60.updateScope(new aj(r82, r83, r56, r54, r55, r59, r53, r57, r58, r129, r128, r127, r126, r130, r121, r122, r123, r124, r125, r217, r218, r219, r216, r106, r107, r108, r109));
        return;
    L363:
        return;
    L350:
        r52 = false;
        goto L351
    L346:
        r0.startReplaceGroup(1981921732);
        r0.endReplaceGroup();
        r51 = r45;
        goto L347
    L335:
        r117 = r104;
        goto L336
    L331:
        r37 = r103;
        goto L332
    L324:
        r215 = r101;
        goto L325
    L319:
        r214 = Integer.MAX_VALUE;
        goto L320
    L321:
        r214 = r100;
        goto L322
    L314:
        r213 = r99;
        goto L316
    L311:
        r212 = r98;
        goto L312
    L308:
        r116 = r97;
        goto L309
    L305:
        r115 = r96;
        goto L306
    L302:
        r211 = r95;
        goto L303
    L299:
        r36 = r94;
        goto L300
    L296:
        r35 = r93;
        goto L297
    L293:
        r34 = r92;
        goto L294
    L290:
        r33 = r91;
        goto L291
    L287:
        r31 = r90;
        goto L288
    L284:
        r30 = r89;
        goto L285
    L281:
        r114 = r88;
        goto L282
    L277:
        r112 = r87;
        goto L278
    L273:
        r111 = r86;
        goto L275
    L270:
        r15 = r85;
        goto L271
    L267:
        r14 = r84;
        goto L268
    L256:
        if (r0.getDefaultsInvalid() == true) goto L265;
        r0.skipToGroupEnd();
        if ((r109 & 32) == 0) goto L262;
        r4 = r4 & (-458753);
    L262:
        if ((262144 & r109) == 0) goto L264;
        r6 = r6 & (-234881025);
    L264:
        r14 = r84;
        r15 = r85;
        r111 = r86;
        r112 = r87;
        r38 = r88;
        r30 = r89;
        r47 = r90;
        r46 = r91;
        r35 = r93;
        r812 = r94;
        r119 = r96;
        r40 = r97;
        r41 = r98;
        r42 = r99;
        r43 = r100;
        r44 = r101;
        r45 = r102;
        r811 = r103;
        r117 = r104;
        r118 = r4;
        r48 = r6;
        r39 = r92;
        r49 = r95;
        goto L337
    L358:
        r0.skipToGroupEnd();
        r56 = r84;
        r54 = r85;
        r55 = r86;
        r59 = r87;
        r53 = r88;
        r57 = r89;
        r58 = r90;
        r129 = r91;
        r128 = r92;
        r127 = r93;
        r126 = r94;
        r130 = r95;
        r121 = r96;
        r122 = r97;
        r123 = r98;
        r124 = r99;
        r125 = r100;
        r217 = r101;
        r218 = r102;
        r219 = r103;
        r216 = r104;
        goto L359
    L245:
        if ((306783379 & r6) != 306783378) goto L250;
        if ((r12 & 147) != 146) goto L250;
        r13 = false;
        goto L252
    L214:
        if ((r108 & 6) == 0) goto L216;
        r23 = r108;
        goto L222
    L216:
        if (r0.changed(r102) == false) goto L218;
        int r220 = 4;
    L219:
        r23 = r108 | r220;
        goto L222
    L218:
        r220 = 2;
        goto L219
    L204:
        if ((r107 & 805306368) != 0) goto L210;
        if (r0.changed(r101) == false) goto L208;
        int r221 = 536870912;
    L209:
        r6 = r6 | r221;
        goto L210
    L208:
        r221 = 268435456;
        goto L209
    L184:
        if ((r107 & 12582912) != 0) goto L191;
        if (r0.changed(r99) == false) goto L188;
        int r222 = 8388608;
    L189:
        r6 = r6 | r222;
        goto L191
    L188:
        r222 = 4194304;
        goto L189
    L174:
        if ((r107 & 1572864) != 0) goto L180;
        if (r0.changed(r98) == false) goto L178;
        int r223 = 1048576;
    L179:
        r6 = r6 | r223;
        goto L180
    L178:
        r223 = 524288;
        goto L179
    L164:
        if ((r107 & 196608) != 0) goto L170;
        if (r0.changed(r97) == false) goto L168;
        int r224 = 131072;
    L169:
        r6 = r6 | r224;
        goto L170
    L168:
        r224 = 65536;
        goto L169
    L153:
        r18 = r11;
        if ((r107 & 24576) != 0) goto L160;
        if (r0.changed(r96) == false) goto L158;
        r20 = 16384;
    L158:
        r6 = r6 | r20;
        goto L160
    L143:
        if ((r107 & 3072) != 0) goto L150;
        if (r0.changed(r95) == true) goto L148;
        r17 = 1024;
    L148:
        r6 = r6 | r17;
        goto L150
    L132:
        if ((r107 & 384) != 0) goto L139;
        if (r0.changedInstance(r94) == false) goto L136;
        int r310 = 256;
    L137:
        r6 = r6 | r310;
        goto L139
    L136:
        r310 = 128;
        goto L137
    L122:
        if ((r107 & 48) != 0) goto L128;
        if (r0.changedInstance(r93) == false) goto L126;
        int r311 = 32;
    L127:
        r32 = r32 | r311;
        goto L128
    L126:
        r311 = 16;
        goto L127
    L111:
        if ((r107 & 6) == 0) goto L113;
        r32 = r107;
        goto L118
    L113:
        if (r0.changedInstance(r92) == false) goto L115;
        int r312 = 4;
    L116:
        r32 = r107 | r312;
        goto L118
    L115:
        r312 = 2;
        goto L116
    L101:
        if ((r106 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r91) == false) goto L105;
        int r313 = 536870912;
    L106:
        r4 = r4 | r313;
        goto L107
    L105:
        r313 = 268435456;
        goto L106
    L91:
        if ((r106 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r90) == false) goto L95;
        int r314 = 67108864;
    L96:
        r4 = r4 | r314;
        goto L97
    L95:
        r314 = 33554432;
        goto L96
    L81:
        if ((r106 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r89) == false) goto L85;
        int r315 = 8388608;
    L86:
        r4 = r4 | r315;
        goto L87
    L85:
        r315 = 4194304;
        goto L86
    L71:
        if ((r106 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r88) == false) goto L75;
        int r225 = 1048576;
    L76:
        r4 = r4 | r225;
        goto L77
    L75:
        r225 = 524288;
        goto L76
    L50:
        if ((r106 & 24576) != 0) goto L58;
        if (r0.changed(r86) == false) goto L54;
        int r226 = 16384;
    L55:
        r4 = r4 | r226;
        goto L58
    L54:
        r226 = 8192;
        goto L55
    L39:
        if ((r106 & 3072) != 0) goto L46;
        if (r0.changed(r85) == false) goto L43;
        int r131 = 2048;
    L44:
        r4 = r4 | r131;
        goto L46
    L43:
        r131 = 1024;
        goto L44
    L28:
        if ((r106 & 384) != 0) goto L35;
        if (r0.changed(r84) == false) goto L32;
        int r132 = 256;
    L33:
        r4 = r4 | r132;
        goto L35
    L32:
        r132 = 128;
        goto L33
    L17:
        if ((r106 & 48) != 0) goto L24;
        if (r0.changedInstance(r83) == false) goto L21;
        int r61 = 32;
    L22:
        r4 = r4 | r61;
        goto L24
    L21:
        r61 = 16;
        goto L22
    L6:
        if ((r106 & 6) == 0) goto L8;
        r4 = r106;
        goto L14
    L8:
        if (r0.changed(r82) == false) goto L10;
        int r62 = 4;
    L11:
        r4 = r62 | r106;
        goto L14
    L10:
        r62 = 2;
        goto L11
    }

    public static final void OutlinedTextField(final TextFieldState r85, Modifier r86, boolean r87, boolean r88, TextStyle r89, TextFieldLabelPosition r90, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, Function2<? super Composer, ? super Integer, Unit> r95, Function2<? super Composer, ? super Integer, Unit> r96, Function2<? super Composer, ? super Integer, Unit> r97, boolean r98, InputTransformation r99, OutputTransformation r100, KeyboardOptions r101, KeyboardActionHandler r102, TextFieldLineLimits r103, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r104, ScrollState r105, Shape r106, TextFieldColors r107, PaddingValues r108, MutableInteractionSource r109, Composer r110, final int r111, final int r112, final int r113, final int r114) {
        Composer r0 = r110.startRestartGroup(-2007078942);
        if ((r114 & 1) == 0) goto L6;
        int r4 = r111 | 6;
    L13:
        int r5 = r114 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r114 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = r114 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r21 = 16384;
        if ((r111 & 24576) != 0) goto L58;
        if ((r114 & 16) != 0) goto L54;
        if (r0.changed(r89) == false) goto L54;
        int r23 = 16384;
    L55:
        r4 = r4 | r23;
    L54:
        r23 = 8192;
    L58:
        if ((r111 & 196608) != 0) goto L67;
        if ((r114 & 32) == 0) goto L62;
    L64:
        int r24 = 65536;
    L65:
        r4 = r4 | r24;
        goto L67
    L62:
        if (r0.changed(r90) == false) goto L64;
        r24 = 131072;
    L67:
        int r25 = r114 & 64;
        if (r25 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r11 = r114 & 128;
        if (r11 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r114 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r114 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r114 & 1024;
        if (r3 == 0) goto L111;
        int r31 = r112 | 6;
    L118:
        int r6 = r114 & 2048;
        if (r6 == 0) goto L122;
        r31 = r31 | 48;
    L128:
        int r7 = r31;
        int r8 = r114 & 4096;
        if (r8 == 0) goto L132;
        r7 = r7 | 384;
    L139:
        int r10 = r114 & 8192;
        if (r10 == 0) goto L142;
        r7 = r7 | 3072;
        int r32 = r10;
    L150:
        int r12 = r114 & 16384;
        if (r12 == 0) goto L153;
        r7 = r7 | 24576;
        int r33 = r12;
    L161:
        int r34 = r114 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r34 == 0) goto L165;
        r7 = r7 | 196608;
    L171:
        int r35 = r114 & 65536;
        if (r35 == 0) goto L175;
        r7 = r7 | 1572864;
    L181:
        int r26 = r114 & 131072;
        if (r26 == 0) goto L185;
        r7 = r7 | 12582912;
    L192:
        if ((r112 & 100663296) != 0) goto L201;
        if ((r114 & 262144) == 0) goto L196;
    L198:
        int r30 = 33554432;
    L199:
        r7 = r7 | r30;
        goto L201
    L196:
        if (r0.changed(r103) == false) goto L198;
        r30 = 67108864;
    L201:
        int r36 = r114 & 524288;
        if (r36 == 0) goto L205;
        r7 = r7 | 805306368;
    L212:
        if ((r113 & 6) == 0) goto L214;
        int r19 = r113;
    L222:
        if ((r113 & 48) != 0) goto L232;
        if ((r114 & 2097152) == 0) goto L226;
    L228:
        int r20 = 16;
    L229:
        r19 = r19 | r20;
        goto L232
    L226:
        if (r0.changed(r106) == false) goto L228;
        r20 = 32;
    L232:
        if ((r113 & 384) != 0) goto L243;
        if ((r114 & 4194304) != 0) goto L239;
        if (r0.changed(r107) == false) goto L239;
        int r27 = 256;
    L240:
        r19 = r19 | r27;
    L239:
        r27 = 128;
    L243:
        if ((r113 & 3072) != 0) goto L253;
        if ((8388608 & r114) != 0) goto L250;
        if (r0.changed(r108) == false) goto L250;
    L251:
        r19 = r19 | r17;
    L250:
        r17 = 1024;
    L253:
        int r13 = r19;
        int r18 = r114 & 16777216;
        if (r18 == 0) goto L257;
        r13 = r13 | 24576;
    L265:
        if ((r4 & 306783379) == 306783378) goto L267;
    L272:
        boolean r14 = true;
    L274:
        if (r0.shouldExecute(r14, r4 & 1) == false) goto L393;
        r0.startDefaults();
        if ((r111 & 1) != 0) goto L278;
    L290:
        if (r5 == 0) goto L292;
        Modifier r15 = Modifier.Companion;
    L293:
        if (r9 == 0) goto L295;
        boolean r22 = true;
    L296:
        if (r16 == 0) goto L298;
        boolean r115 = false;
    L300:
        if ((r114 & 16) == 0) goto L302;
        TextStyle r116 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-57345);
    L304:
        if ((r114 & 32) == 0) goto L306;
        TextFieldLabelPosition r117 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
        r4 = r4 & (-458753);
    L308:
        if (r25 == 0) goto L310;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r118 = null;
    L311:
        if (r11 == 0) goto L313;
        Function2<? super Composer, ? super Integer, Unit> r119 = null;
    L314:
        if (r1 == 0) goto L316;
        Function2<? super Composer, ? super Integer, Unit> r28 = null;
    L317:
        if (r2 == 0) goto L319;
        Function2<? super Composer, ? super Integer, Unit> r29 = null;
    L320:
        if (r3 == 0) goto L322;
        Function2<? super Composer, ? super Integer, Unit> r37 = null;
    L323:
        if (r6 == 0) goto L325;
        Function2<? super Composer, ? super Integer, Unit> r38 = null;
    L326:
        if (r8 == 0) goto L328;
        Function2<? super Composer, ? super Integer, Unit> r120 = null;
    L329:
        if (r32 == 0) goto L331;
        boolean r210 = false;
    L332:
        if (r33 == 0) goto L334;
        InputTransformation r211 = null;
    L335:
        if (r34 == 0) goto L337;
        OutputTransformation r212 = null;
    L338:
        if (r35 == 0) goto L340;
        KeyboardOptions r213 = KeyboardOptions.Companion.getDefault();
    L341:
        if (r26 == 0) goto L343;
        KeyboardActionHandler r214 = null;
    L345:
        if ((r114 & 262144) == 0) goto L347;
        TextFieldLineLimits r215 = TextFieldLineLimits.Companion.getDefault();
        r7 = r7 & (-234881025);
    L348:
        if (r36 == 0) goto L350;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r216 = null;
    L351:
        Function2<? super Composer, ? super Integer, Unit> r810 = r28;
        if ((r114 & 1048576) == 0) goto L354;
        ScrollState r217 = ScrollKt.rememberScrollState(0, r0, 0, 1);
    L356:
        if ((2097152 & r114) == 0) goto L358;
        Shape r39 = OutlinedTextFieldDefaults.INSTANCE.getShape(r0, 6);
    L359:
        Shape r811 = r39;
        if ((r114 & 4194304) == 0) goto L362;
        TextFieldColors r40 = OutlinedTextFieldDefaults.INSTANCE.colors(r0, 6);
    L364:
        if ((8388608 & r114) == 0) goto L366;
        PaddingValues r41 = OutlinedTextFieldDefaults.m2968contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L367:
        Shape r49 = r811;
        if (r18 == 0) goto L370;
        MutableInteractionSource r51 = null;
    L371:
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r42 = r118;
        boolean r43 = r210;
        InputTransformation r44 = r211;
        OutputTransformation r45 = r212;
        KeyboardOptions r46 = r213;
        KeyboardActionHandler r47 = r214;
        ScrollState r48 = r217;
        TextFieldLineLimits r410 = r215;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r411 = r216;
        Function2<? super Composer, ? super Integer, Unit> r50 = r37;
        Function2<? super Composer, ? super Integer, Unit> r52 = r29;
        Function2<? super Composer, ? super Integer, Unit> r53 = r810;
        boolean r812 = r115;
        int r121 = r7;
        Function2<? super Composer, ? super Integer, Unit> r54 = r120;
    L372:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L376;
        ComposerKt.traceEventStart(-2007078942, r4, r121, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:228)");
    L376:
        if (r51 != null) goto L381;
        r0.startReplaceGroup(1647415065);
        Object r55 = r0.rememberedValue();
        if (r55 != Composer.Companion.getEmpty()) goto L380;
        r55 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r55);
    L380:
        MutableInteractionSource r56 = (MutableInteractionSource) r55;
        r0.endReplaceGroup();
    L382:
        r0.startReplaceGroup(-362494116);
        long r122 = r116.getColor-0d7_KjU();
        if (r122 == 16) goto L385;
        boolean r57 = true;
    L386:
        if (r57 == true) goto L389;
        r122 = r40.m3328textColorXeAY9LY$material3(r22, r43, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r56, r0, 0).getValue()).booleanValue());
    L389:
        r0.endReplaceGroup();
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r813 = r42;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r40.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-416142558, true, new AnonymousClass1(r15, r42, r117, r43, r40, r85, r22, r410, r45, r56, r119, r53, r52, r50, r38, r54, r41, r812, r44, r116.merge(new TextStyle(r122, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null)), r46, r47, r411, r48, r49), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L392;
        ComposerKt.traceEventEnd();
    L392:
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r58 = r813;
        final Function2<? super Composer, ? super Integer, Unit> r123 = r52;
        final boolean r59 = r22;
        final TextFieldColors r218 = r40;
        final TextFieldLabelPosition r60 = r117;
        final InputTransformation r124 = r44;
        final OutputTransformation r125 = r45;
        final KeyboardOptions r126 = r46;
        final KeyboardActionHandler r127 = r47;
        final TextFieldLineLimits r128 = r410;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r219 = r411;
        final ScrollState r220 = r48;
        final Shape r221 = r49;
        final PaddingValues r222 = r41;
        final MutableInteractionSource r223 = r51;
        final Function2<? super Composer, ? super Integer, Unit> r129 = r38;
        final Function2<? super Composer, ? super Integer, Unit> r61 = r53;
        final Modifier r62 = r15;
        final boolean r130 = r43;
        final Function2<? super Composer, ? super Integer, Unit> r63 = r119;
        final TextStyle r64 = r116;
        final Function2<? super Composer, ? super Integer, Unit> r131 = r54;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r50;
        final boolean r65 = r812;
    L394:
        ScopeUpdateScope r66 = r0.endRestartGroup();
        if (r66 == null) goto L398;
        r66.updateScope(new wi(r85, r62, r59, r65, r64, r60, r58, r63, r61, r123, r132, r129, r131, r130, r124, r125, r126, r127, r128, r219, r220, r221, r218, r222, r223, r111, r112, r113, r114));
        return;
    L398:
        return;
    L385:
        r57 = false;
        goto L386
    L381:
        r0.startReplaceGroup(-362500226);
        r0.endReplaceGroup();
        r56 = r51;
        goto L382
    L370:
        r51 = r109;
        goto L371
    L366:
        r41 = r108;
        goto L367
    L362:
        r40 = r107;
        goto L364
    L358:
        r39 = r106;
        goto L359
    L354:
        r217 = r105;
        goto L356
    L350:
        r216 = r104;
        goto L351
    L347:
        r215 = r103;
        goto L348
    L343:
        r214 = r102;
        goto L345
    L340:
        r213 = r101;
        goto L341
    L337:
        r212 = r100;
        goto L338
    L334:
        r211 = r99;
        goto L335
    L331:
        r210 = r98;
        goto L332
    L328:
        r120 = r97;
        goto L329
    L325:
        r38 = r96;
        goto L326
    L322:
        r37 = r95;
        goto L323
    L319:
        r29 = r94;
        goto L320
    L316:
        r28 = r93;
        goto L317
    L313:
        r119 = r92;
        goto L314
    L310:
        r118 = r91;
        goto L311
    L306:
        r117 = r90;
        goto L308
    L302:
        r116 = r89;
        goto L304
    L298:
        r115 = r88;
        goto L300
    L295:
        r22 = r87;
        goto L296
    L292:
        r15 = r86;
        goto L293
    L278:
        if (r0.getDefaultsInvalid() == true) goto L290;
        r0.skipToGroupEnd();
        if ((r114 & 16) == 0) goto L284;
        r4 = r4 & (-57345);
    L284:
        if ((r114 & 32) == 0) goto L287;
        r4 = r4 & (-458753);
    L287:
        if ((262144 & r114) == 0) goto L289;
        r7 = r7 & (-234881025);
    L289:
        r15 = r86;
        r22 = r87;
        r812 = r88;
        r116 = r89;
        r117 = r90;
        r42 = r91;
        r119 = r92;
        r53 = r93;
        r52 = r94;
        r38 = r96;
        r43 = r98;
        r44 = r99;
        r45 = r100;
        r46 = r101;
        r47 = r102;
        r410 = r103;
        r411 = r104;
        r48 = r105;
        r49 = r106;
        r40 = r107;
        r41 = r108;
        r51 = r109;
        r4 = r4;
        r121 = r7;
        r50 = r95;
        r54 = r97;
        goto L372
    L393:
        r0.skipToGroupEnd();
        r62 = r86;
        r59 = r87;
        r65 = r88;
        r64 = r89;
        r60 = r90;
        r58 = r91;
        r63 = r92;
        r61 = r93;
        r123 = r94;
        r132 = r95;
        r129 = r96;
        r131 = r97;
        r130 = r98;
        r124 = r99;
        r125 = r100;
        r126 = r101;
        r127 = r102;
        r128 = r103;
        r219 = r104;
        r220 = r105;
        r221 = r106;
        r218 = r107;
        r222 = r108;
        r223 = r109;
        goto L394
    L267:
        if ((306783379 & r7) != 306783378) goto L272;
        if ((r13 & 9363) != 9362) goto L272;
        r14 = false;
        goto L274
    L257:
        if ((r113 & 24576) != 0) goto L265;
        if (r0.changed(r109) == true) goto L262;
        r21 = 8192;
    L262:
        r13 = r13 | r21;
        goto L265
    L214:
        if ((r114 & 1048576) == 0) goto L216;
    L218:
        int r133 = 2;
    L219:
        r19 = r113 | r133;
        goto L222
    L216:
        if (r0.changed(r105) == false) goto L218;
        r133 = 4;
        goto L219
    L205:
        if ((r112 & 805306368) != 0) goto L212;
        if (r0.changedInstance(r104) == false) goto L209;
        int r310 = 536870912;
    L210:
        r7 = r7 | r310;
        goto L212
    L209:
        r310 = 268435456;
        goto L210
    L185:
        if ((r112 & 12582912) != 0) goto L192;
        if (r0.changed(r102) == false) goto L189;
        int r311 = 8388608;
    L190:
        r7 = r7 | r311;
        goto L192
    L189:
        r311 = 4194304;
        goto L190
    L175:
        if ((r112 & 1572864) != 0) goto L181;
        if (r0.changed(r101) == false) goto L179;
        int r224 = 1048576;
    L180:
        r7 = r7 | r224;
        goto L181
    L179:
        r224 = 524288;
        goto L180
    L165:
        if ((r112 & 196608) != 0) goto L171;
        if (r0.changed(r100) == false) goto L169;
        int r312 = 131072;
    L170:
        r7 = r7 | r312;
        goto L171
    L169:
        r312 = 65536;
        goto L170
    L153:
        r33 = r12;
        if ((r112 & 24576) != 0) goto L161;
        if (r0.changed(r99) == false) goto L158;
        int r313 = 16384;
    L159:
        r7 = r7 | r313;
        goto L161
    L158:
        r313 = 8192;
        goto L159
    L142:
        r32 = r10;
        if ((r112 & 3072) != 0) goto L150;
        if (r0.changed(r98) == false) goto L147;
        int r314 = 2048;
    L148:
        r7 = r7 | r314;
        goto L150
    L147:
        r314 = 1024;
        goto L148
    L132:
        if ((r112 & 384) != 0) goto L139;
        if (r0.changedInstance(r97) == false) goto L136;
        int r315 = 256;
    L137:
        r7 = r7 | r315;
        goto L139
    L136:
        r315 = 128;
        goto L137
    L122:
        if ((r112 & 48) != 0) goto L128;
        if (r0.changedInstance(r96) == false) goto L126;
        int r316 = 32;
    L127:
        r31 = r31 | r316;
        goto L128
    L126:
        r316 = 16;
        goto L127
    L111:
        if ((r112 & 6) == 0) goto L113;
        r31 = r112;
        goto L118
    L113:
        if (r0.changedInstance(r95) == false) goto L115;
        int r317 = 4;
    L116:
        r31 = r112 | r317;
        goto L118
    L115:
        r317 = 2;
        goto L116
    L101:
        if ((r111 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r94) == false) goto L105;
        int r318 = 536870912;
    L106:
        r4 = r4 | r318;
        goto L107
    L105:
        r318 = 268435456;
        goto L106
    L91:
        if ((r111 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r93) == false) goto L95;
        int r319 = 67108864;
    L96:
        r4 = r4 | r319;
        goto L97
    L95:
        r319 = 33554432;
        goto L96
    L81:
        if ((r111 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r92) == false) goto L85;
        int r320 = 8388608;
    L86:
        r4 = r4 | r320;
        goto L87
    L85:
        r320 = 4194304;
        goto L86
    L71:
        if ((r111 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r91) == false) goto L75;
        int r225 = 1048576;
    L76:
        r4 = r4 | r225;
        goto L77
    L75:
        r225 = 524288;
        goto L76
    L39:
        if ((r111 & 3072) != 0) goto L46;
        if (r0.changed(r88) == false) goto L43;
        int r226 = 2048;
    L44:
        r4 = r4 | r226;
        goto L46
    L43:
        r226 = 1024;
        goto L44
    L28:
        if ((r111 & 384) != 0) goto L35;
        if (r0.changed(r87) == false) goto L32;
        int r134 = 256;
    L33:
        r4 = r4 | r134;
        goto L35
    L32:
        r134 = 128;
        goto L33
    L17:
        if ((r111 & 48) != 0) goto L24;
        if (r0.changed(r86) == false) goto L21;
        int r67 = 32;
    L22:
        r4 = r4 | r67;
        goto L24
    L21:
        r67 = 16;
        goto L22
    L6:
        if ((r111 & 6) == 0) goto L8;
        r4 = r111;
        goto L13
    L8:
        if (r0.changed(r85) == false) goto L10;
        int r68 = 4;
    L11:
        r4 = r68 | r111;
        goto L13
    L10:
        r68 = 2;
        goto L11
    }
}
