package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a£\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#28\b\u0002\u0010$\u001a2\u0012\u0004\u0012\u00020&\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010'0\u0013¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0001\u0018\u00010%¢\u0006\u0002\b\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0007¢\u0006\u0002\u00105\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010A\u001aØ\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00106\u001a\u00020B2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010C\u001aô\u0001\u0010D\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010E\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0019\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\u0002\b\u00102\u0013\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010G\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010=\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010K\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010L\u001a\u000202H\u0001¢\u0006\u0002\u0010M\"\u0016\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010Q¨\u0006S"}, d2 = {TextFieldImplKt.TextFieldId, "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "value", "", "onValueChange", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "container", "supporting", "paddingValues", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = 0.0f;

    private static final Unit TextField$lambda$2(TextFieldState r30, Modifier r31, boolean r32, boolean r33, TextStyle r34, TextFieldLabelPosition r35, Function3 r36, Function2 r37, Function2 r38, Function2 r39, Function2 r40, Function2 r41, Function2 r42, boolean r43, InputTransformation r44, OutputTransformation r45, KeyboardOptions r46, KeyboardActionHandler r47, TextFieldLineLimits r48, Function2 r49, ScrollState r50, Shape r51, TextFieldColors r52, PaddingValues r53, MutableInteractionSource r54, int r55, int r56, int r57, int r58, Composer r59, int r60) {
        TextField(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r59, RecomposeScopeImplKt.updateChangedFlags(r55 | 1), RecomposeScopeImplKt.updateChangedFlags(r56), RecomposeScopeImplKt.updateChangedFlags(r57), r58);
        return Unit.INSTANCE;
    }

    private static final Unit TextField$lambda$5(String r28, Function1 r29, Modifier r30, boolean r31, boolean r32, TextStyle r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Function2 r38, Function2 r39, Function2 r40, boolean r41, VisualTransformation r42, KeyboardOptions r43, KeyboardActions r44, boolean r45, int r46, int r47, MutableInteractionSource r48, Shape r49, TextFieldColors r50, int r51, int r52, int r53, int r54, Composer r55, int r56) {
        TextField(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r55, RecomposeScopeImplKt.updateChangedFlags(r51 | 1), RecomposeScopeImplKt.updateChangedFlags(r52), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    private static final Unit TextField$lambda$8(TextFieldValue r28, Function1 r29, Modifier r30, boolean r31, boolean r32, TextStyle r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Function2 r38, Function2 r39, Function2 r40, boolean r41, VisualTransformation r42, KeyboardOptions r43, KeyboardActions r44, boolean r45, int r46, int r47, MutableInteractionSource r48, Shape r49, TextFieldColors r50, int r51, int r52, int r53, int r54, Composer r55, int r56) {
        TextField(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r55, RecomposeScopeImplKt.updateChangedFlags(r51 | 1), RecomposeScopeImplKt.updateChangedFlags(r52), RecomposeScopeImplKt.updateChangedFlags(r53), r54);
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldLayout$lambda$20(Modifier r17, Function2 r18, Function2 r19, Function3 r20, Function2 r21, Function2 r22, Function2 r23, Function2 r24, boolean r25, TextFieldLabelPosition r26, FloatProducer r27, Function2 r28, Function2 r29, PaddingValues r30, int r31, int r32, Composer r33, int r34) {
        TextFieldLayout(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r33, RecomposeScopeImplKt.updateChangedFlags(r31 | 1), RecomposeScopeImplKt.updateChangedFlags(r32));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Dp a(FloatProducer r0) {
        return TextFieldLayout$lambda$19$lambda$15$lambda$14(r0);
    }

    public static /* synthetic */ Unit b(Modifier r1, Function2 r2, Function2 r3, Function3 r4, Function2 r5, Function2 r6, Function2 r7, Function2 r8, boolean r9, TextFieldLabelPosition r10, FloatProducer r11, Function2 r12, Function2 r13, PaddingValues r14, int r15, int r16, Composer r17, int r18) {
        return TextFieldLayout$lambda$20(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit c(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, VisualTransformation r15, KeyboardOptions r16, KeyboardActions r17, boolean r18, int r19, int r20, MutableInteractionSource r21, Shape r22, TextFieldColors r23, int r24, int r25, int r26, int r27, Composer r28, int r29) {
        return TextField$lambda$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    public static /* synthetic */ Unit d(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, VisualTransformation r15, KeyboardOptions r16, KeyboardActions r17, boolean r18, int r19, int r20, MutableInteractionSource r21, Shape r22, TextFieldColors r23, int r24, int r25, int r26, int r27, Composer r28, int r29) {
        return TextField$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    public static /* synthetic */ Unit e(TextFieldState r1, Modifier r2, boolean r3, boolean r4, TextStyle r5, TextFieldLabelPosition r6, Function3 r7, Function2 r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, boolean r14, InputTransformation r15, OutputTransformation r16, KeyboardOptions r17, KeyboardActionHandler r18, TextFieldLineLimits r19, Function2 r20, ScrollState r21, Shape r22, TextFieldColors r23, PaddingValues r24, MutableInteractionSource r25, int r26, int r27, int r28, int r29, Composer r30, int r31) {
        return TextField$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
    }

    static {
        TextFieldWithLabelVerticalPadding = Dp.constructor-impl(8);
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }

    private static final Dp TextFieldLayout$lambda$19$lambda$15$lambda$14(FloatProducer r2) {
        return Dp.box-impl(DpKt.lerp-Md-fbLM(androidx.compose.material3.internal.TextFieldImplKt.getMinTextLineHeight(), androidx.compose.material3.internal.TextFieldImplKt.getMinFocusedLabelLineHeight(), r2.invoke()));
    }

    public static final void TextFieldLayout(final Modifier r35, final Function2<? super Composer, ? super Integer, Unit> r36, final Function2<? super Composer, ? super Integer, Unit> r37, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> r38, final Function2<? super Composer, ? super Integer, Unit> r39, final Function2<? super Composer, ? super Integer, Unit> r40, final Function2<? super Composer, ? super Integer, Unit> r41, final Function2<? super Composer, ? super Integer, Unit> r42, final boolean r43, final TextFieldLabelPosition r44, final FloatProducer r45, final Function2<? super Composer, ? super Integer, Unit> r46, final Function2<? super Composer, ? super Integer, Unit> r47, final PaddingValues r48, Composer r49, final int r50, final int r51) {
        Composer r12 = r49.startRestartGroup(-1086465551);
        if ((r50 & 6) == 0) goto L5;
        int r16 = r50;
    L10:
        int r18 = 32;
        if ((r50 & 48) == 0) goto L13;
    L17:
        int r20 = 256;
        if ((r50 & 384) == 0) goto L20;
    L24:
        int r22 = 1024;
        if ((r50 & 3072) != 0) goto L32;
        if (r12.changedInstance(r38) == false) goto L29;
        int r9 = 2048;
    L30:
        r16 = r16 | r9;
        goto L32
    L29:
        r9 = 1024;
    L32:
        if ((r50 & 24576) != 0) goto L39;
        if (r12.changedInstance(r39) == false) goto L36;
        int r10 = 16384;
    L37:
        r16 = r16 | r10;
        goto L39
    L36:
        r10 = 8192;
    L39:
        if ((196608 & r50) != 0) goto L46;
        if (r12.changedInstance(r40) == false) goto L43;
        int r11 = 131072;
    L44:
        r16 = r16 | r11;
        goto L46
    L43:
        r11 = 65536;
    L46:
        if ((1572864 & r50) != 0) goto L53;
        if (r12.changedInstance(r41) == false) goto L50;
        int r13 = 1048576;
    L51:
        r16 = r16 | r13;
        goto L53
    L50:
        r13 = 524288;
    L53:
        if ((12582912 & r50) != 0) goto L60;
        if (r12.changedInstance(r42) == false) goto L57;
        int r14 = 8388608;
    L58:
        r16 = r16 | r14;
        goto L60
    L57:
        r14 = 4194304;
    L60:
        if ((100663296 & r50) != 0) goto L68;
        if (r12.changed(r43) == false) goto L64;
        int r24 = 67108864;
    L65:
        r16 = r16 | r24;
        goto L68
    L64:
        r24 = 33554432;
    L68:
        if ((r50 & 805306368) == 0) goto L70;
    L74:
        int r2 = r16;
        if ((r51 & 6) == 0) goto L77;
        int r17 = r51;
    L86:
        if ((r51 & 48) != 0) goto L93;
        if (r12.changedInstance(r46) == true) goto L91;
        r18 = 16;
    L91:
        r17 = r17 | r18;
    L93:
        if ((r51 & 384) != 0) goto L100;
        if (r12.changedInstance(r47) == true) goto L98;
        r20 = 128;
    L98:
        r17 = r17 | r20;
    L100:
        if ((r51 & 3072) != 0) goto L106;
        if (r12.changed(r48) == false) goto L104;
        r22 = 2048;
    L104:
        r17 = r17 | r22;
    L106:
        int r4 = r17;
        if ((r2 & 306783379) == 306783378) goto L109;
    L112:
        boolean r15 = true;
    L114:
        if (r12.shouldExecute(r15, r2 & 1) == true) goto L116;
        Composer r19 = r12;
        r19.skipToGroupEnd();
    L304:
        ScopeUpdateScope r110 = r19.endRestartGroup();
        if (r110 == null) goto L308;
        r110.updateScope(new ot(r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r50, r51));
        return;
    L308:
        return;
    L116:
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventStart(-1086465551, r2, r4, "androidx.compose.material3.TextFieldLayout (TextField.kt:671)");
    L118:
        float r111 = androidx.compose.material3.internal.TextFieldImplKt.minimizedLabelHalfHeight(r12, 0);
        if ((234881024 & r2) != 67108864) goto L121;
        boolean r3 = true;
    L123:
        if ((1879048192 & r2) != 536870912) goto L125;
        boolean r21 = true;
    L126:
        boolean r5 = r3 | r21;
        int r112 = r4 & 14;
        if (r112 != 4) goto L129;
    L134:
        boolean r113 = true;
    L135:
        boolean r6 = r5 | r113;
        if ((r4 & 7168) != 2048) goto L138;
        boolean r23 = true;
    L139:
        boolean r7 = (r6 | r23) | r12.changed(r111);
        Object r25 = r12.rememberedValue();
        if (r7 == false) goto L142;
    L145:
        Object r8 = new TextFieldMeasurePolicy(r43, r44, r45, r48, r111, null);
        r19 = r12;
        r19.updateRememberedValue(r8);
    L146:
        TextFieldMeasurePolicy r26 = (TextFieldMeasurePolicy) r8;
        LayoutDirection r114 = (LayoutDirection) r19.consume(CompositionLocalsKt.getLocalLayoutDirection());
        int r115 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r116 = r19.getCurrentCompositionLocalMap();
        Modifier r117 = ComposedModifierKt.materializeModifier(r19, r35);
        ComposeUiNode.Companion r118 = ComposeUiNode.Companion;
        Function0 r119 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L149;
        ComposablesKt.invalidApplier();
    L149:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L152;
        r19.createNode(r119);
    L153:
        Composer r1 = Updater.constructor-impl(r19);
        Updater.set-impl(r1, r26, r118.getSetMeasurePolicy());
        Updater.set-impl(r1, r116, r118.getSetResolvedCompositionLocals());
        Function2 r27 = r118.getSetCompositeKeyHash();
        if (r1.getInserting() == false) goto L156;
    L157:
        r1.updateRememberedValue(Integer.valueOf(r115));
        r1.apply(Integer.valueOf(r115), r27);
    L158:
        Updater.set-impl(r1, r117, r118.getSetModifier());
        r46.invoke(r19, Integer.valueOf((r4 >> 3) & 14));
        if (r39 == null) goto L173;
        r19.startReplaceGroup(-1445181094);
        Modifier r28 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId));
        MeasurePolicy r29 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r120 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r121 = r19.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r19, r28);
        Function0 r122 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L163;
        ComposablesKt.invalidApplier();
    L163:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L166;
        r19.createNode(r122);
    L167:
        Composer r123 = Updater.constructor-impl(r19);
        Updater.set-impl(r123, r29, r118.getSetMeasurePolicy());
        Updater.set-impl(r123, r121, r118.getSetResolvedCompositionLocals());
        Function2 r31 = r118.getSetCompositeKeyHash();
        if (r123.getInserting() == false) goto L170;
    L171:
        r123.updateRememberedValue(Integer.valueOf(r120));
        r123.apply(Integer.valueOf(r120), r31);
    L172:
        Updater.set-impl(r123, r30, r118.getSetModifier());
        BoxScopeInstance r32 = BoxScopeInstance.INSTANCE;
        r39.invoke(r19, Integer.valueOf((r2 >> 12) & 14));
        r19.endNode();
        r19.endReplaceGroup();
    L174:
        if (r40 == null) goto L188;
        r19.startReplaceGroup(-1444892360);
        Modifier r33 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId));
        MeasurePolicy r34 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r124 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r125 = r19.getCurrentCompositionLocalMap();
        Modifier r52 = ComposedModifierKt.materializeModifier(r19, r33);
        Function0 r126 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L178;
        ComposablesKt.invalidApplier();
    L178:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L181;
        r19.createNode(r126);
    L182:
        Composer r127 = Updater.constructor-impl(r19);
        Updater.set-impl(r127, r34, r118.getSetMeasurePolicy());
        Updater.set-impl(r127, r125, r118.getSetResolvedCompositionLocals());
        Function2 r53 = r118.getSetCompositeKeyHash();
        if (r127.getInserting() == false) goto L185;
    L186:
        r127.updateRememberedValue(Integer.valueOf(r124));
        r127.apply(Integer.valueOf(r124), r53);
    L187:
        Updater.set-impl(r127, r52, r118.getSetModifier());
        BoxScopeInstance r54 = BoxScopeInstance.INSTANCE;
        r40.invoke(r19, Integer.valueOf((r2 >> 15) & 14));
        r19.endNode();
        r19.endReplaceGroup();
    L189:
        float r55 = PaddingKt.calculateStartPadding(r48, r114);
        float r56 = PaddingKt.calculateEndPadding(r48, r114);
        float r128 = androidx.compose.material3.internal.TextFieldImplKt.textFieldHorizontalIconPadding(r19, 0);
        if (r39 == null) goto L192;
        r55 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(r55 - r128), Dp.constructor-impl(0)));
    L192:
        if (r40 == null) goto L195;
        r56 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(r56 - r128), Dp.constructor-impl(0)));
    L195:
        if (r41 == null) goto L209;
        r19.startReplaceGroup(-1443868027);
        Modifier r0 = PaddingKt.m964paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m1002heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "Prefix"), androidx.compose.material3.internal.TextFieldImplKt.getMinTextLineHeight(), MenuKt.ClosedAlphaTarget, 2, null), null, false, 3, null), r55, MenuKt.ClosedAlphaTarget, androidx.compose.material3.internal.TextFieldImplKt.getPrefixSuffixTextPadding(), MenuKt.ClosedAlphaTarget, 10, null);
        MeasurePolicy r129 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r130 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r131 = r19.getCurrentCompositionLocalMap();
        Modifier r57 = ComposedModifierKt.materializeModifier(r19, r0);
        Function0 r132 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L199;
        ComposablesKt.invalidApplier();
    L199:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L202;
        r19.createNode(r132);
    L203:
        Composer r133 = Updater.constructor-impl(r19);
        Updater.set-impl(r133, r129, r118.getSetMeasurePolicy());
        Updater.set-impl(r133, r131, r118.getSetResolvedCompositionLocals());
        Function2 r134 = r118.getSetCompositeKeyHash();
        if (r133.getInserting() == false) goto L206;
    L207:
        r133.updateRememberedValue(Integer.valueOf(r130));
        r133.apply(Integer.valueOf(r130), r134);
    L208:
        Updater.set-impl(r133, r57, r118.getSetModifier());
        BoxScopeInstance r58 = BoxScopeInstance.INSTANCE;
        r41.invoke(r19, Integer.valueOf((r2 >> 18) & 14));
        r19.endNode();
        r19.endReplaceGroup();
    L210:
        if (r42 == null) goto L224;
        r19.startReplaceGroup(-1443497081);
        Modifier r59 = PaddingKt.m964paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m1002heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "Suffix"), androidx.compose.material3.internal.TextFieldImplKt.getMinTextLineHeight(), MenuKt.ClosedAlphaTarget, 2, null), null, false, 3, null), androidx.compose.material3.internal.TextFieldImplKt.getPrefixSuffixTextPadding(), MenuKt.ClosedAlphaTarget, r56, MenuKt.ClosedAlphaTarget, 10, null);
        MeasurePolicy r135 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r136 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r137 = r19.getCurrentCompositionLocalMap();
        Modifier r60 = ComposedModifierKt.materializeModifier(r19, r59);
        Function0 r138 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L214;
        ComposablesKt.invalidApplier();
    L214:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L217;
        r19.createNode(r138);
    L218:
        Composer r61 = Updater.constructor-impl(r19);
        Updater.set-impl(r61, r135, r118.getSetMeasurePolicy());
        Updater.set-impl(r61, r137, r118.getSetResolvedCompositionLocals());
        Function2 r139 = r118.getSetCompositeKeyHash();
        if (r61.getInserting() == false) goto L221;
    L222:
        r61.updateRememberedValue(Integer.valueOf(r136));
        r61.apply(Integer.valueOf(r136), r139);
    L223:
        Updater.set-impl(r61, r60, r118.getSetModifier());
        BoxScopeInstance r62 = BoxScopeInstance.INSTANCE;
        r42.invoke(r19, Integer.valueOf((r2 >> 21) & 14));
        r19.endNode();
        r19.endReplaceGroup();
    L226:
        if ((r44 instanceof TextFieldLabelPosition.Above) == false) goto L228;
        Modifier r63 = PaddingKt.m964paddingqDBjuR0$default(Modifier.Companion, androidx.compose.material3.internal.TextFieldImplKt.getAboveLabelHorizontalPadding(), MenuKt.ClosedAlphaTarget, androidx.compose.material3.internal.TextFieldImplKt.getAboveLabelHorizontalPadding(), androidx.compose.material3.internal.TextFieldImplKt.getAboveLabelBottomPadding(), 2, null);
    L229:
        Modifier r140 = r63;
        if (r37 == null) goto L259;
        r19.startReplaceGroup(-1442671489);
        Modifier r141 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId);
        if (r112 == 4) goto L239;
        final FloatProducer r142 = r45;
        if ((r4 & 8) != 0) goto L236;
    L238:
        boolean r64 = false;
    L241:
        Object r65 = r19.rememberedValue();
        if (r64 == false) goto L244;
    L245:
        r65 = new nt(r142);
        r19.updateRememberedValue(r65);
    L246:
        Modifier r66 = SizeKt.wrapContentHeight$default(androidx.compose.material3.internal.TextFieldImplKt.textFieldLabelMinHeight(r141, (Function0) r65), null, false, 3, null).then(r140);
        MeasurePolicy r67 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r143 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r68 = r19.getCurrentCompositionLocalMap();
        Modifier r69 = ComposedModifierKt.materializeModifier(r19, r66);
        Function0 r144 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L249;
        ComposablesKt.invalidApplier();
    L249:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L252;
        r19.createNode(r144);
    L253:
        Composer r70 = Updater.constructor-impl(r19);
        Updater.set-impl(r70, r67, r118.getSetMeasurePolicy());
        Updater.set-impl(r70, r68, r118.getSetResolvedCompositionLocals());
        Function2 r71 = r118.getSetCompositeKeyHash();
        if (r70.getInserting() == false) goto L256;
    L257:
        r70.updateRememberedValue(Integer.valueOf(r143));
        r70.apply(Integer.valueOf(r143), r71);
    L258:
        Updater.set-impl(r70, r69, r118.getSetModifier());
        BoxScopeInstance r72 = BoxScopeInstance.INSTANCE;
        r37.invoke(r19, Integer.valueOf((r2 >> 6) & 14));
        r19.endNode();
        r19.endReplaceGroup();
    L260:
        Modifier.Companion r73 = Modifier.Companion;
        Modifier r210 = SizeKt.wrapContentHeight$default(SizeKt.m1002heightInVpY3zN4$default(r73, androidx.compose.material3.internal.TextFieldImplKt.getMinTextLineHeight(), MenuKt.ClosedAlphaTarget, 2, null), null, false, 3, null);
        if (r41 != null) goto L263;
        float r211 = r55;
    L265:
        if (r42 != null) goto L267;
        float r212 = r56;
    L268:
        Modifier r74 = PaddingKt.m964paddingqDBjuR0$default(r210, r211, MenuKt.ClosedAlphaTarget, r212, MenuKt.ClosedAlphaTarget, 10, null);
        if (r38 == null) goto L271;
        r19.startReplaceGroup(-1441906533);
        r38.invoke(LayoutIdKt.layoutId(r73, TextFieldImplKt.PlaceholderId).then(r74), r19, Integer.valueOf((r2 >> 6) & 112));
        r19.endReplaceGroup();
    L272:
        Modifier r75 = LayoutIdKt.layoutId(r73, TextFieldImplKt.TextFieldId).then(r74);
        Alignment.Companion r76 = Alignment.Companion;
        MeasurePolicy r145 = BoxKt.maybeCachedBoxMeasurePolicy(r76.getTopStart(), true);
        int r146 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r147 = r19.getCurrentCompositionLocalMap();
        Modifier r77 = ComposedModifierKt.materializeModifier(r19, r75);
        Function0 r78 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L275;
        ComposablesKt.invalidApplier();
    L275:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L278;
        r19.createNode(r78);
    L279:
        Composer r79 = Updater.constructor-impl(r19);
        Updater.set-impl(r79, r145, r118.getSetMeasurePolicy());
        Updater.set-impl(r79, r147, r118.getSetResolvedCompositionLocals());
        Function2 r80 = r118.getSetCompositeKeyHash();
        if (r79.getInserting() == false) goto L282;
    L283:
        r79.updateRememberedValue(Integer.valueOf(r146));
        r79.apply(Integer.valueOf(r146), r80);
    L284:
        Updater.set-impl(r79, r77, r118.getSetModifier());
        BoxScopeInstance r81 = BoxScopeInstance.INSTANCE;
        r36.invoke(r19, Integer.valueOf((r2 >> 3) & 14));
        r19.endNode();
        if (r47 == null) goto L299;
        r19.startReplaceGroup(-1441566587);
        Modifier r82 = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m1002heightInVpY3zN4$default(LayoutIdKt.layoutId(r73, "Supporting"), androidx.compose.material3.internal.TextFieldImplKt.getMinSupportingTextLineHeight(), MenuKt.ClosedAlphaTarget, 2, null), null, false, 3, null), TextFieldDefaults.m3337supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null));
        MeasurePolicy r83 = BoxKt.maybeCachedBoxMeasurePolicy(r76.getTopStart(), false);
        int r84 = ComposablesKt.getCurrentCompositeKeyHash(r19, 0);
        CompositionLocalMap r85 = r19.getCurrentCompositionLocalMap();
        Modifier r86 = ComposedModifierKt.materializeModifier(r19, r82);
        Function0 r87 = r118.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L289;
        ComposablesKt.invalidApplier();
    L289:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L292;
        r19.createNode(r87);
    L293:
        Composer r88 = Updater.constructor-impl(r19);
        Updater.set-impl(r88, r83, r118.getSetMeasurePolicy());
        Updater.set-impl(r88, r85, r118.getSetResolvedCompositionLocals());
        Function2 r89 = r118.getSetCompositeKeyHash();
        if (r88.getInserting() == false) goto L296;
    L297:
        r88.updateRememberedValue(Integer.valueOf(r84));
        r88.apply(Integer.valueOf(r84), r89);
    L298:
        Updater.set-impl(r88, r86, r118.getSetModifier());
        r47.invoke(r19, Integer.valueOf((r4 >> 6) & 14));
        r19.endNode();
        r19.endReplaceGroup();
    L300:
        r19.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L304;
        ComposerKt.traceEventEnd();
        goto L304
    L296:
        if (Intrinsics.areEqual(r88.rememberedValue(), Integer.valueOf(r84)) == true) goto L298;
    L292:
        r19.useNode();
        goto L293
    L299:
        r19.startReplaceGroup(-1441177382);
        r19.endReplaceGroup();
        goto L300
    L282:
        if (Intrinsics.areEqual(r79.rememberedValue(), Integer.valueOf(r146)) == true) goto L284;
    L278:
        r19.useNode();
        goto L279
    L271:
        r19.startReplaceGroup(-1441815238);
        r19.endReplaceGroup();
        goto L272
    L267:
        r212 = Dp.constructor-impl(0);
        goto L268
    L263:
        r211 = Dp.constructor-impl(0);
        goto L265
    L256:
        if (Intrinsics.areEqual(r70.rememberedValue(), Integer.valueOf(r143)) == true) goto L258;
    L252:
        r19.useNode();
        goto L253
    L244:
        if (r65 != Composer.Companion.getEmpty()) goto L246;
    L236:
        if (r19.changedInstance(r142) == false) goto L238;
    L240:
        r64 = true;
        goto L241
    L239:
        r142 = r45;
        goto L240
    L259:
        r19.startReplaceGroup(-1442276518);
        r19.endReplaceGroup();
        goto L260
    L228:
        r63 = PaddingKt.m964paddingqDBjuR0$default(Modifier.Companion, r55, MenuKt.ClosedAlphaTarget, r56, MenuKt.ClosedAlphaTarget, 10, null);
        goto L229
    L221:
        if (Intrinsics.areEqual(r61.rememberedValue(), Integer.valueOf(r136)) == true) goto L223;
    L217:
        r19.useNode();
        goto L218
    L224:
        r19.startReplaceGroup(-1443171302);
        r19.endReplaceGroup();
        goto L226
    L206:
        if (Intrinsics.areEqual(r133.rememberedValue(), Integer.valueOf(r130)) == true) goto L208;
    L202:
        r19.useNode();
        goto L203
    L209:
        r19.startReplaceGroup(-1443540326);
        r19.endReplaceGroup();
        goto L210
    L185:
        if (Intrinsics.areEqual(r127.rememberedValue(), Integer.valueOf(r124)) == true) goto L187;
    L181:
        r19.useNode();
        goto L182
    L188:
        r19.startReplaceGroup(-1444644422);
        r19.endReplaceGroup();
        goto L189
    L170:
        if (Intrinsics.areEqual(r123.rememberedValue(), Integer.valueOf(r120)) == true) goto L172;
    L166:
        r19.useNode();
        goto L167
    L173:
        r19.startReplaceGroup(-1444935078);
        r19.endReplaceGroup();
        goto L174
    L156:
        if (Intrinsics.areEqual(r1.rememberedValue(), Integer.valueOf(r115)) == true) goto L158;
    L152:
        r19.useNode();
        goto L153
    L142:
        if (r25 == Composer.Companion.getEmpty()) goto L145;
        r8 = r25;
        r19 = r12;
        goto L146
    L138:
        r23 = false;
        goto L139
    L129:
        if ((r4 & 8) != 0) goto L131;
    L133:
        r113 = false;
        goto L135
    L131:
        if (r12.changed(r45) == false) goto L133;
    L125:
        r21 = false;
        goto L126
    L121:
        r3 = false;
        goto L123
    L109:
        if ((r4 & 1171) != 1170) goto L112;
        r15 = false;
        goto L114
    L77:
        if ((r51 & 8) != 0) goto L79;
        boolean r148 = r12.changed(r45);
    L80:
        if (r148 == false) goto L82;
        int r149 = 4;
    L83:
        r17 = r51 | r149;
        goto L86
    L82:
        r149 = 2;
        goto L83
    L79:
        r148 = r12.changedInstance(r45);
        goto L80
    L70:
        if (r12.changed(r44) == false) goto L72;
        int r213 = 536870912;
    L73:
        r16 = r16 | r213;
        goto L74
    L72:
        r213 = 268435456;
        goto L73
    L20:
        if (r12.changedInstance(r37) == false) goto L22;
        int r90 = 256;
    L23:
        r16 = r16 | r90;
        goto L24
    L22:
        r90 = 128;
        goto L23
    L13:
        if (r12.changedInstance(r36) == false) goto L15;
        int r150 = 32;
    L16:
        r16 = r16 | r150;
        goto L17
    L15:
        r150 = 16;
        goto L16
    L5:
        if (r12.changed(r35) == false) goto L7;
        int r151 = 4;
    L8:
        r16 = r50 | r151;
        goto L10
    L7:
        r151 = 2;
        goto L8
    }

    public static final void TextField(final TextFieldValue r82, final Function1<? super TextFieldValue, Unit> r83, Modifier r84, boolean r85, boolean r86, TextStyle r87, Function2<? super Composer, ? super Integer, Unit> r88, Function2<? super Composer, ? super Integer, Unit> r89, Function2<? super Composer, ? super Integer, Unit> r90, Function2<? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, boolean r95, VisualTransformation r96, KeyboardOptions r97, KeyboardActions r98, boolean r99, int r100, int r101, MutableInteractionSource r102, Shape r103, TextFieldColors r104, Composer r105, final int r106, final int r107, final int r108, final int r109) {
        Composer r0 = r105.startRestartGroup(-1126989771);
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
        Shape r37 = TextFieldDefaults.INSTANCE.getShape(r0, 6);
    L332:
        Shape r811 = r37;
        if ((r109 & 4194304) == 0) goto L335;
        TextFieldColors r117 = TextFieldDefaults.INSTANCE.colors(r0, 6);
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
        ComposerKt.traceEventStart(-1126989771, r118, r48, "androidx.compose.material3.TextField (TextField.kt:592)");
    L341:
        if (r45 != null) goto L346;
        r0.startReplaceGroup(-391701594);
        Object r50 = r0.rememberedValue();
        if (r50 != Composer.Companion.getEmpty()) goto L345;
        r50 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r50);
    L345:
        MutableInteractionSource r51 = (MutableInteractionSource) r50;
        r0.endReplaceGroup();
    L347:
        r0.startReplaceGroup(-705366737);
        long r120 = r112.getColor-0d7_KjU();
        if (r120 == 16) goto L350;
        boolean r52 = true;
    L351:
        if (r52 == true) goto L354;
        r120 = r117.m3328textColorXeAY9LY$material3(r15, r49, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r51, r0, 0).getValue()).booleanValue());
    L354:
        r0.endReplaceGroup();
        final TextStyle r216 = r112.merge(new TextStyle(r120, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        final Modifier r121 = r14;
        final boolean r122 = r49;
        final TextFieldColors r123 = r117;
        final boolean r217 = r15;
        final boolean r218 = r111;
        final KeyboardOptions r219 = r40;
        final KeyboardActions r220 = r41;
        final boolean r221 = r42;
        final int r222 = r43;
        final int r223 = r44;
        final VisualTransformation r310 = r119;
        final MutableInteractionSource r311 = r51;
        final Function2<? super Composer, ? super Integer, Unit> r312 = r38;
        final Function2<? super Composer, ? super Integer, Unit> r313 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r314 = r47;
        final Function2<? super Composer, ? super Integer, Unit> r315 = r46;
        final Function2 r316 = r39;
        final Function2 r317 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r318 = r812;
        final Shape r319 = r811;
        Function2<? super Composer, ? super Integer, Unit> r813 = r38;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r117.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-306109195, true, new AnonymousClass5(r121, r122, r123, r82, r83, r217, r218, r216, r219, r220, r221, r222, r223, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L357;
        ComposerKt.traceEventEnd();
    L357:
        final Function2<? super Composer, ? super Integer, Unit> r53 = r813;
        final VisualTransformation r124 = r119;
        final boolean r54 = r15;
        final TextFieldColors r224 = r117;
        final boolean r55 = r111;
        final KeyboardOptions r125 = r40;
        final KeyboardActions r126 = r41;
        final boolean r127 = r42;
        final int r128 = r43;
        final int r225 = r44;
        final MutableInteractionSource r226 = r45;
        final Shape r227 = r811;
        final Function2<? super Composer, ? super Integer, Unit> r129 = r812;
        final Function2<? super Composer, ? super Integer, Unit> r130 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r131 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r46;
        final Modifier r56 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r57 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r58 = r47;
        TextStyle r81 = r112;
        final boolean r133 = r49;
        final TextStyle r59 = r81;
    L359:
        ScopeUpdateScope r60 = r0.endRestartGroup();
        if (r60 == null) goto L363;
        r60.updateScope(new kt(r82, r83, r56, r54, r55, r59, r53, r57, r58, r132, r131, r130, r129, r133, r124, r125, r126, r127, r128, r225, r226, r227, r224, r106, r107, r108, r109));
        return;
    L363:
        return;
    L350:
        r52 = false;
        goto L351
    L346:
        r0.startReplaceGroup(-705372847);
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
        r132 = r91;
        r131 = r92;
        r130 = r93;
        r129 = r94;
        r133 = r95;
        r124 = r96;
        r125 = r97;
        r126 = r98;
        r127 = r99;
        r128 = r100;
        r225 = r101;
        r226 = r102;
        r227 = r103;
        r224 = r104;
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
        int r228 = 4;
    L219:
        r23 = r108 | r228;
        goto L222
    L218:
        r228 = 2;
        goto L219
    L204:
        if ((r107 & 805306368) != 0) goto L210;
        if (r0.changed(r101) == false) goto L208;
        int r229 = 536870912;
    L209:
        r6 = r6 | r229;
        goto L210
    L208:
        r229 = 268435456;
        goto L209
    L184:
        if ((r107 & 12582912) != 0) goto L191;
        if (r0.changed(r99) == false) goto L188;
        int r230 = 8388608;
    L189:
        r6 = r6 | r230;
        goto L191
    L188:
        r230 = 4194304;
        goto L189
    L174:
        if ((r107 & 1572864) != 0) goto L180;
        if (r0.changed(r98) == false) goto L178;
        int r231 = 1048576;
    L179:
        r6 = r6 | r231;
        goto L180
    L178:
        r231 = 524288;
        goto L179
    L164:
        if ((r107 & 196608) != 0) goto L170;
        if (r0.changed(r97) == false) goto L168;
        int r232 = 131072;
    L169:
        r6 = r6 | r232;
        goto L170
    L168:
        r232 = 65536;
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
        int r320 = 256;
    L137:
        r6 = r6 | r320;
        goto L139
    L136:
        r320 = 128;
        goto L137
    L122:
        if ((r107 & 48) != 0) goto L128;
        if (r0.changedInstance(r93) == false) goto L126;
        int r321 = 32;
    L127:
        r32 = r32 | r321;
        goto L128
    L126:
        r321 = 16;
        goto L127
    L111:
        if ((r107 & 6) == 0) goto L113;
        r32 = r107;
        goto L118
    L113:
        if (r0.changedInstance(r92) == false) goto L115;
        int r322 = 4;
    L116:
        r32 = r107 | r322;
        goto L118
    L115:
        r322 = 2;
        goto L116
    L101:
        if ((r106 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r91) == false) goto L105;
        int r323 = 536870912;
    L106:
        r4 = r4 | r323;
        goto L107
    L105:
        r323 = 268435456;
        goto L106
    L91:
        if ((r106 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r90) == false) goto L95;
        int r324 = 67108864;
    L96:
        r4 = r4 | r324;
        goto L97
    L95:
        r324 = 33554432;
        goto L96
    L81:
        if ((r106 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r89) == false) goto L85;
        int r325 = 8388608;
    L86:
        r4 = r4 | r325;
        goto L87
    L85:
        r325 = 4194304;
        goto L86
    L71:
        if ((r106 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r88) == false) goto L75;
        int r233 = 1048576;
    L76:
        r4 = r4 | r233;
        goto L77
    L75:
        r233 = 524288;
        goto L76
    L50:
        if ((r106 & 24576) != 0) goto L58;
        if (r0.changed(r86) == false) goto L54;
        int r234 = 16384;
    L55:
        r4 = r4 | r234;
        goto L58
    L54:
        r234 = 8192;
        goto L55
    L39:
        if ((r106 & 3072) != 0) goto L46;
        if (r0.changed(r85) == false) goto L43;
        int r134 = 2048;
    L44:
        r4 = r4 | r134;
        goto L46
    L43:
        r134 = 1024;
        goto L44
    L28:
        if ((r106 & 384) != 0) goto L35;
        if (r0.changed(r84) == false) goto L32;
        int r135 = 256;
    L33:
        r4 = r4 | r135;
        goto L35
    L32:
        r135 = 128;
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

    public static final void TextField(final String r82, final Function1<? super String, Unit> r83, Modifier r84, boolean r85, boolean r86, TextStyle r87, Function2<? super Composer, ? super Integer, Unit> r88, Function2<? super Composer, ? super Integer, Unit> r89, Function2<? super Composer, ? super Integer, Unit> r90, Function2<? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, boolean r95, VisualTransformation r96, KeyboardOptions r97, KeyboardActions r98, boolean r99, int r100, int r101, MutableInteractionSource r102, Shape r103, TextFieldColors r104, Composer r105, final int r106, final int r107, final int r108, final int r109) {
        Composer r0 = r105.startRestartGroup(-154966360);
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
        Shape r37 = TextFieldDefaults.INSTANCE.getShape(r0, 6);
    L332:
        Shape r811 = r37;
        if ((r109 & 4194304) == 0) goto L335;
        TextFieldColors r117 = TextFieldDefaults.INSTANCE.colors(r0, 6);
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
        ComposerKt.traceEventStart(-154966360, r118, r48, "androidx.compose.material3.TextField (TextField.kt:442)");
    L341:
        if (r45 != null) goto L346;
        r0.startReplaceGroup(488210003);
        Object r50 = r0.rememberedValue();
        if (r50 != Composer.Companion.getEmpty()) goto L345;
        r50 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r50);
    L345:
        MutableInteractionSource r51 = (MutableInteractionSource) r50;
        r0.endReplaceGroup();
    L347:
        r0.startReplaceGroup(1401227490);
        long r120 = r112.getColor-0d7_KjU();
        if (r120 == 16) goto L350;
        boolean r52 = true;
    L351:
        if (r52 == true) goto L354;
        r120 = r117.m3328textColorXeAY9LY$material3(r15, r49, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r51, r0, 0).getValue()).booleanValue());
    L354:
        r0.endReplaceGroup();
        final TextStyle r216 = r112.merge(new TextStyle(r120, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        final Modifier r121 = r14;
        final boolean r122 = r49;
        final TextFieldColors r123 = r117;
        final boolean r217 = r15;
        final boolean r218 = r111;
        final KeyboardOptions r219 = r40;
        final KeyboardActions r220 = r41;
        final boolean r221 = r42;
        final int r222 = r43;
        final int r223 = r44;
        final VisualTransformation r310 = r119;
        final MutableInteractionSource r311 = r51;
        final Function2<? super Composer, ? super Integer, Unit> r312 = r38;
        final Function2<? super Composer, ? super Integer, Unit> r313 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r314 = r47;
        final Function2<? super Composer, ? super Integer, Unit> r315 = r46;
        final Function2 r316 = r39;
        final Function2 r317 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r318 = r812;
        final Shape r319 = r811;
        Function2<? super Composer, ? super Integer, Unit> r813 = r38;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r117.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1459735400, true, new AnonymousClass3(r121, r122, r123, r82, r83, r217, r218, r216, r219, r220, r221, r222, r223, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L357;
        ComposerKt.traceEventEnd();
    L357:
        final Function2<? super Composer, ? super Integer, Unit> r53 = r813;
        final VisualTransformation r124 = r119;
        final boolean r54 = r15;
        final TextFieldColors r224 = r117;
        final boolean r55 = r111;
        final KeyboardOptions r125 = r40;
        final KeyboardActions r126 = r41;
        final boolean r127 = r42;
        final int r128 = r43;
        final int r225 = r44;
        final MutableInteractionSource r226 = r45;
        final Shape r227 = r811;
        final Function2<? super Composer, ? super Integer, Unit> r129 = r812;
        final Function2<? super Composer, ? super Integer, Unit> r130 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r131 = r39;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r46;
        final Modifier r56 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r57 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r58 = r47;
        TextStyle r81 = r112;
        final boolean r133 = r49;
        final TextStyle r59 = r81;
    L359:
        ScopeUpdateScope r60 = r0.endRestartGroup();
        if (r60 == null) goto L363;
        r60.updateScope(new lt(r82, r83, r56, r54, r55, r59, r53, r57, r58, r132, r131, r130, r129, r133, r124, r125, r126, r127, r128, r225, r226, r227, r224, r106, r107, r108, r109));
        return;
    L363:
        return;
    L350:
        r52 = false;
        goto L351
    L346:
        r0.startReplaceGroup(1401221380);
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
        r132 = r91;
        r131 = r92;
        r130 = r93;
        r129 = r94;
        r133 = r95;
        r124 = r96;
        r125 = r97;
        r126 = r98;
        r127 = r99;
        r128 = r100;
        r225 = r101;
        r226 = r102;
        r227 = r103;
        r224 = r104;
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
        int r228 = 4;
    L219:
        r23 = r108 | r228;
        goto L222
    L218:
        r228 = 2;
        goto L219
    L204:
        if ((r107 & 805306368) != 0) goto L210;
        if (r0.changed(r101) == false) goto L208;
        int r229 = 536870912;
    L209:
        r6 = r6 | r229;
        goto L210
    L208:
        r229 = 268435456;
        goto L209
    L184:
        if ((r107 & 12582912) != 0) goto L191;
        if (r0.changed(r99) == false) goto L188;
        int r230 = 8388608;
    L189:
        r6 = r6 | r230;
        goto L191
    L188:
        r230 = 4194304;
        goto L189
    L174:
        if ((r107 & 1572864) != 0) goto L180;
        if (r0.changed(r98) == false) goto L178;
        int r231 = 1048576;
    L179:
        r6 = r6 | r231;
        goto L180
    L178:
        r231 = 524288;
        goto L179
    L164:
        if ((r107 & 196608) != 0) goto L170;
        if (r0.changed(r97) == false) goto L168;
        int r232 = 131072;
    L169:
        r6 = r6 | r232;
        goto L170
    L168:
        r232 = 65536;
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
        int r320 = 256;
    L137:
        r6 = r6 | r320;
        goto L139
    L136:
        r320 = 128;
        goto L137
    L122:
        if ((r107 & 48) != 0) goto L128;
        if (r0.changedInstance(r93) == false) goto L126;
        int r321 = 32;
    L127:
        r32 = r32 | r321;
        goto L128
    L126:
        r321 = 16;
        goto L127
    L111:
        if ((r107 & 6) == 0) goto L113;
        r32 = r107;
        goto L118
    L113:
        if (r0.changedInstance(r92) == false) goto L115;
        int r322 = 4;
    L116:
        r32 = r107 | r322;
        goto L118
    L115:
        r322 = 2;
        goto L116
    L101:
        if ((r106 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r91) == false) goto L105;
        int r323 = 536870912;
    L106:
        r4 = r4 | r323;
        goto L107
    L105:
        r323 = 268435456;
        goto L106
    L91:
        if ((r106 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r90) == false) goto L95;
        int r324 = 67108864;
    L96:
        r4 = r4 | r324;
        goto L97
    L95:
        r324 = 33554432;
        goto L96
    L81:
        if ((r106 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r89) == false) goto L85;
        int r325 = 8388608;
    L86:
        r4 = r4 | r325;
        goto L87
    L85:
        r325 = 4194304;
        goto L86
    L71:
        if ((r106 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r88) == false) goto L75;
        int r233 = 1048576;
    L76:
        r4 = r4 | r233;
        goto L77
    L75:
        r233 = 524288;
        goto L76
    L50:
        if ((r106 & 24576) != 0) goto L58;
        if (r0.changed(r86) == false) goto L54;
        int r234 = 16384;
    L55:
        r4 = r4 | r234;
        goto L58
    L54:
        r234 = 8192;
        goto L55
    L39:
        if ((r106 & 3072) != 0) goto L46;
        if (r0.changed(r85) == false) goto L43;
        int r134 = 2048;
    L44:
        r4 = r4 | r134;
        goto L46
    L43:
        r134 = 1024;
        goto L44
    L28:
        if ((r106 & 384) != 0) goto L35;
        if (r0.changed(r84) == false) goto L32;
        int r135 = 256;
    L33:
        r4 = r4 | r135;
        goto L35
    L32:
        r135 = 128;
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

    public static final void TextField(final TextFieldState r85, Modifier r86, boolean r87, boolean r88, TextStyle r89, TextFieldLabelPosition r90, Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r91, Function2<? super Composer, ? super Integer, Unit> r92, Function2<? super Composer, ? super Integer, Unit> r93, Function2<? super Composer, ? super Integer, Unit> r94, Function2<? super Composer, ? super Integer, Unit> r95, Function2<? super Composer, ? super Integer, Unit> r96, Function2<? super Composer, ? super Integer, Unit> r97, boolean r98, InputTransformation r99, OutputTransformation r100, KeyboardOptions r101, KeyboardActionHandler r102, TextFieldLineLimits r103, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r104, ScrollState r105, Shape r106, TextFieldColors r107, PaddingValues r108, MutableInteractionSource r109, Composer r110, final int r111, final int r112, final int r113, final int r114) {
        Composer r0 = r110.startRestartGroup(-1717599650);
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
        if (r0.shouldExecute(r14, r4 & 1) == false) goto L398;
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
        Shape r39 = TextFieldDefaults.INSTANCE.getShape(r0, 6);
    L359:
        Shape r811 = r39;
        if ((r114 & 4194304) == 0) goto L362;
        TextFieldColors r40 = TextFieldDefaults.INSTANCE.colors(r0, 6);
    L364:
        if ((8388608 & r114) == 0) goto L371;
        if (r118 != null) goto L367;
    L370:
        PaddingValues r41 = TextFieldDefaults.m3331contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L372:
        Shape r49 = r811;
        if (r18 == 0) goto L375;
        MutableInteractionSource r51 = null;
    L376:
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
    L377:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L381;
        ComposerKt.traceEventStart(-1717599650, r4, r121, "androidx.compose.material3.TextField (TextField.kt:287)");
    L381:
        if (r51 != null) goto L386;
        r0.startReplaceGroup(1230824445);
        Object r55 = r0.rememberedValue();
        if (r55 != Composer.Companion.getEmpty()) goto L385;
        r55 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r55);
    L385:
        MutableInteractionSource r56 = (MutableInteractionSource) r55;
        r0.endReplaceGroup();
    L387:
        r0.startReplaceGroup(-1345763848);
        long r122 = r116.getColor-0d7_KjU();
        if (r122 == 16) goto L390;
        boolean r57 = true;
    L391:
        if (r57 == true) goto L394;
        r122 = r40.m3328textColorXeAY9LY$material3(r22, r43, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r56, r0, 0).getValue()).booleanValue());
    L394:
        r0.endReplaceGroup();
        final TextStyle r310 = r116.merge(new TextStyle(r122, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        final Modifier r123 = r15;
        final boolean r124 = r43;
        final TextFieldColors r125 = r40;
        final boolean r218 = r22;
        final TextFieldLineLimits r219 = r410;
        final OutputTransformation r220 = r45;
        final MutableInteractionSource r221 = r56;
        final TextFieldLabelPosition r222 = r117;
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r223 = r42;
        final Function2<? super Composer, ? super Integer, Unit> r224 = r119;
        final Function2<? super Composer, ? super Integer, Unit> r225 = r53;
        final Function2<? super Composer, ? super Integer, Unit> r226 = r52;
        final Function2<? super Composer, ? super Integer, Unit> r311 = r50;
        final Function2 r312 = r38;
        final Function2 r313 = r54;
        final PaddingValues r314 = r41;
        final boolean r315 = r812;
        final InputTransformation r316 = r44;
        final KeyboardOptions r317 = r46;
        final KeyboardActionHandler r318 = r47;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r319 = r411;
        final ScrollState r412 = r48;
        final Shape r413 = r49;
        Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r813 = r42;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(r40.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(484558238, true, new AnonymousClass1(r123, r124, r125, r85, r218, r219, r220, r221, r222, r223, r224, r225, r226, r311, r312, r313, r314, r315, r316, r310, r317, r318, r319, r412, r413), r0, 54), r0, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L397;
        ComposerKt.traceEventEnd();
    L397:
        final Function3<? super TextFieldLabelScope, ? super Composer, ? super Integer, Unit> r58 = r813;
        final Function2<? super Composer, ? super Integer, Unit> r126 = r52;
        final boolean r59 = r22;
        final TextFieldColors r227 = r40;
        final TextFieldLabelPosition r60 = r117;
        final InputTransformation r127 = r44;
        final OutputTransformation r128 = r45;
        final KeyboardOptions r129 = r46;
        final KeyboardActionHandler r130 = r47;
        final TextFieldLineLimits r131 = r410;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> r228 = r411;
        final ScrollState r229 = r48;
        final Shape r230 = r49;
        final PaddingValues r231 = r41;
        final MutableInteractionSource r232 = r51;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r38;
        final Function2<? super Composer, ? super Integer, Unit> r61 = r53;
        final Modifier r62 = r15;
        final boolean r133 = r43;
        final Function2<? super Composer, ? super Integer, Unit> r63 = r119;
        final TextStyle r64 = r116;
        final Function2<? super Composer, ? super Integer, Unit> r134 = r54;
        final Function2<? super Composer, ? super Integer, Unit> r135 = r50;
        final boolean r65 = r812;
    L399:
        ScopeUpdateScope r66 = r0.endRestartGroup();
        if (r66 == null) goto L403;
        r66.updateScope(new mt(r85, r62, r59, r65, r64, r60, r58, r63, r61, r126, r135, r132, r134, r133, r127, r128, r129, r130, r131, r228, r229, r230, r227, r231, r232, r111, r112, r113, r114));
        return;
    L403:
        return;
    L390:
        r57 = false;
        goto L391
    L386:
        r0.startReplaceGroup(-1345769958);
        r0.endReplaceGroup();
        r56 = r51;
        goto L387
    L375:
        r51 = r109;
        goto L376
    L367:
        if ((r117 instanceof TextFieldLabelPosition.Above) == true) goto L370;
        r41 = TextFieldDefaults.m3330contentPaddingWithLabela9UjIt4$default(TextFieldDefaults.INSTANCE, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        goto L372
    L371:
        r41 = r108;
        goto L372
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
        goto L377
    L398:
        r0.skipToGroupEnd();
        r62 = r86;
        r59 = r87;
        r65 = r88;
        r64 = r89;
        r60 = r90;
        r58 = r91;
        r63 = r92;
        r61 = r93;
        r126 = r94;
        r135 = r95;
        r132 = r96;
        r134 = r97;
        r133 = r98;
        r127 = r99;
        r128 = r100;
        r129 = r101;
        r130 = r102;
        r131 = r103;
        r228 = r104;
        r229 = r105;
        r230 = r106;
        r227 = r107;
        r231 = r108;
        r232 = r109;
        goto L399
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
        int r136 = 2;
    L219:
        r19 = r113 | r136;
        goto L222
    L216:
        if (r0.changed(r105) == false) goto L218;
        r136 = 4;
        goto L219
    L205:
        if ((r112 & 805306368) != 0) goto L212;
        if (r0.changedInstance(r104) == false) goto L209;
        int r320 = 536870912;
    L210:
        r7 = r7 | r320;
        goto L212
    L209:
        r320 = 268435456;
        goto L210
    L185:
        if ((r112 & 12582912) != 0) goto L192;
        if (r0.changed(r102) == false) goto L189;
        int r321 = 8388608;
    L190:
        r7 = r7 | r321;
        goto L192
    L189:
        r321 = 4194304;
        goto L190
    L175:
        if ((r112 & 1572864) != 0) goto L181;
        if (r0.changed(r101) == false) goto L179;
        int r233 = 1048576;
    L180:
        r7 = r7 | r233;
        goto L181
    L179:
        r233 = 524288;
        goto L180
    L165:
        if ((r112 & 196608) != 0) goto L171;
        if (r0.changed(r100) == false) goto L169;
        int r322 = 131072;
    L170:
        r7 = r7 | r322;
        goto L171
    L169:
        r322 = 65536;
        goto L170
    L153:
        r33 = r12;
        if ((r112 & 24576) != 0) goto L161;
        if (r0.changed(r99) == false) goto L158;
        int r323 = 16384;
    L159:
        r7 = r7 | r323;
        goto L161
    L158:
        r323 = 8192;
        goto L159
    L142:
        r32 = r10;
        if ((r112 & 3072) != 0) goto L150;
        if (r0.changed(r98) == false) goto L147;
        int r324 = 2048;
    L148:
        r7 = r7 | r324;
        goto L150
    L147:
        r324 = 1024;
        goto L148
    L132:
        if ((r112 & 384) != 0) goto L139;
        if (r0.changedInstance(r97) == false) goto L136;
        int r325 = 256;
    L137:
        r7 = r7 | r325;
        goto L139
    L136:
        r325 = 128;
        goto L137
    L122:
        if ((r112 & 48) != 0) goto L128;
        if (r0.changedInstance(r96) == false) goto L126;
        int r326 = 32;
    L127:
        r31 = r31 | r326;
        goto L128
    L126:
        r326 = 16;
        goto L127
    L111:
        if ((r112 & 6) == 0) goto L113;
        r31 = r112;
        goto L118
    L113:
        if (r0.changedInstance(r95) == false) goto L115;
        int r327 = 4;
    L116:
        r31 = r112 | r327;
        goto L118
    L115:
        r327 = 2;
        goto L116
    L101:
        if ((r111 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r94) == false) goto L105;
        int r328 = 536870912;
    L106:
        r4 = r4 | r328;
        goto L107
    L105:
        r328 = 268435456;
        goto L106
    L91:
        if ((r111 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r93) == false) goto L95;
        int r329 = 67108864;
    L96:
        r4 = r4 | r329;
        goto L97
    L95:
        r329 = 33554432;
        goto L96
    L81:
        if ((r111 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r92) == false) goto L85;
        int r330 = 8388608;
    L86:
        r4 = r4 | r330;
        goto L87
    L85:
        r330 = 4194304;
        goto L86
    L71:
        if ((r111 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r91) == false) goto L75;
        int r234 = 1048576;
    L76:
        r4 = r4 | r234;
        goto L77
    L75:
        r234 = 524288;
        goto L76
    L39:
        if ((r111 & 3072) != 0) goto L46;
        if (r0.changed(r88) == false) goto L43;
        int r235 = 2048;
    L44:
        r4 = r4 | r235;
        goto L46
    L43:
        r235 = 1024;
        goto L44
    L28:
        if ((r111 & 384) != 0) goto L35;
        if (r0.changed(r87) == false) goto L32;
        int r137 = 256;
    L33:
        r4 = r4 | r137;
        goto L35
    L32:
        r137 = 128;
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
