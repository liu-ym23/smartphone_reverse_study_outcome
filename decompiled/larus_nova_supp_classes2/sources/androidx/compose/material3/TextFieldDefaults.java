package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.SingleValueAnimationKt;
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
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0019\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2 \b\u0002\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0004\b:\u0010;JU\u0010<\u001a\u000207*\u0002072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t¢\u0006\u0004\b>\u0010?J¦\u0002\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020B2\u0011\u0010C\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020F2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u00182\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\u0013\b\u0002\u00103\u001a\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010GJ5\u0010H\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\t¢\u0006\u0004\bM\u0010NJ5\u0010O\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\t¢\u0006\u0004\bP\u0010NJ7\u0010Q\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0000¢\u0006\u0004\bR\u0010NJ\r\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u0010SJÂ\u0003\u0010/\u001a\u0002002\b\b\u0002\u0010T\u001a\u00020U2\b\b\u0002\u0010V\u001a\u00020U2\b\b\u0002\u0010W\u001a\u00020U2\b\b\u0002\u0010X\u001a\u00020U2\b\b\u0002\u0010Y\u001a\u00020U2\b\b\u0002\u0010Z\u001a\u00020U2\b\b\u0002\u0010[\u001a\u00020U2\b\b\u0002\u0010\\\u001a\u00020U2\b\b\u0002\u0010]\u001a\u00020U2\b\b\u0002\u0010^\u001a\u00020U2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010`2\b\b\u0002\u0010a\u001a\u00020U2\b\b\u0002\u0010b\u001a\u00020U2\b\b\u0002\u0010c\u001a\u00020U2\b\b\u0002\u0010d\u001a\u00020U2\b\b\u0002\u0010e\u001a\u00020U2\b\b\u0002\u0010f\u001a\u00020U2\b\b\u0002\u0010g\u001a\u00020U2\b\b\u0002\u0010h\u001a\u00020U2\b\b\u0002\u0010i\u001a\u00020U2\b\b\u0002\u0010j\u001a\u00020U2\b\b\u0002\u0010k\u001a\u00020U2\b\b\u0002\u0010l\u001a\u00020U2\b\b\u0002\u0010m\u001a\u00020U2\b\b\u0002\u0010n\u001a\u00020U2\b\b\u0002\u0010o\u001a\u00020U2\b\b\u0002\u0010p\u001a\u00020U2\b\b\u0002\u0010q\u001a\u00020U2\b\b\u0002\u0010r\u001a\u00020U2\b\b\u0002\u0010s\u001a\u00020U2\b\b\u0002\u0010t\u001a\u00020U2\b\b\u0002\u0010u\u001a\u00020U2\b\b\u0002\u0010v\u001a\u00020U2\b\b\u0002\u0010w\u001a\u00020U2\b\b\u0002\u0010x\u001a\u00020U2\b\b\u0002\u0010y\u001a\u00020U2\b\b\u0002\u0010z\u001a\u00020U2\b\b\u0002\u0010{\u001a\u00020U2\b\b\u0002\u0010|\u001a\u00020U2\b\b\u0002\u0010}\u001a\u00020U2\b\b\u0002\u0010~\u001a\u00020U2\b\b\u0002\u0010\u007f\u001a\u00020U2\t\b\u0002\u0010\u0080\u0001\u001a\u00020UH\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001d\u0010\u0083\u0001\u001a\u000200*\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020`H\u0000¢\u0006\u0003\b\u0086\u0001JI\u0010<\u001a\u000207*\u0002072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\tH\u0007¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J9\u0010\u0089\u0001\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010\u008a\u0001J9\u0010\u0097\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u0098\u0001\u0010NJ9\u0010\u0099\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u009a\u0001\u0010NJ9\u0010\u009b\u0001\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010K\u001a\u00020\t2\b\b\u0002\u0010J\u001a\u00020\t2\b\b\u0002\u0010L\u001a\u00020\tH\u0007¢\u0006\u0005\b\u009c\u0001\u0010NR\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u001d\u0010\u008b\u0001\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008c\u0001\u0010\u0003\u001a\u0005\b\u008d\u0001\u0010\u0007R\u001d\u0010\u008e\u0001\u001a\u00020\u00058GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008f\u0001\u0010\u0003\u001a\u0005\b\u0090\u0001\u0010\u0007R!\u0010\u0091\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0092\u0001\u0010\u0003\u001a\u0005\b\u0093\u0001\u0010\u000bR!\u0010\u0094\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0095\u0001\u0010\u0003\u001a\u0005\b\u0096\u0001\u0010\u000b¨\u0006\u009d\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", "Container", "modifier", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "indicatorLine", "textFieldShape", "indicatorLine-AWlRVLg", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)Landroidx/compose/ui/Modifier;", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "localTextSelectionColors", "defaultTextFieldColors$material3", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "filledShape", "getFilledShape$annotations", "getFilledShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    private static final float FocusedBorderThickness = 0.0f;
    private static final float FocusedIndicatorThickness = 0.0f;
    public static final TextFieldDefaults INSTANCE = null;
    private static final float MinHeight = 0.0f;
    private static final float MinWidth = 0.0f;
    private static final float UnfocusedBorderThickness = 0.0f;
    private static final float UnfocusedIndicatorThickness = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.TextFieldDefaults$decorator$2, reason: invalid class name */
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
            Composer r3 = r26.startRestartGroup(-94654579);
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
            r2.updateScope(new jt(this, r25, r27));
            return;
        L50:
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L27;
            ComposerKt.traceEventStart(-94654579, r15, -1, "androidx.compose.material3.TextFieldDefaults.decorator.<no name provided>.Decoration (TextFieldDefaults.kt:179)");
        L27:
            if (this.$outputTransformation != null) goto L30;
            CharSequence r4 = this.$state.getText();
        L29:
            CharSequence r20 = r4;
            TextFieldType r7 = TextFieldType.Filled;
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

    private TextFieldDefaults() {
    }

    private static final Unit ContainerBox$lambda$7(TextFieldDefaults r10, boolean r11, boolean r12, InteractionSource r13, TextFieldColors r14, Shape r15, int r16, int r17, Composer r18, int r19) {
        r10.ContainerBox(r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit Container_4EFweAY$lambda$0(TextFieldDefaults r13, boolean r14, boolean r15, InteractionSource r16, Modifier r17, TextFieldColors r18, Shape r19, float r20, float r21, int r22, int r23, Composer r24, int r25) {
        r13.m3340Container4EFweAY(r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit DecorationBox$lambda$3(TextFieldDefaults r23, String r24, Function2 r25, boolean r26, boolean r27, VisualTransformation r28, InteractionSource r29, boolean r30, Function2 r31, Function2 r32, Function2 r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, Shape r38, TextFieldColors r39, PaddingValues r40, Function2 r41, int r42, int r43, int r44, Composer r45, int r46) {
        r23.DecorationBox(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextFieldDefaults r1, String r2, Function2 r3, boolean r4, boolean r5, VisualTransformation r6, InteractionSource r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, Function2 r14, Function2 r15, Shape r16, TextFieldColors r17, PaddingValues r18, Function2 r19, int r20, int r21, int r22, Composer r23, int r24) {
        return DecorationBox$lambda$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ Unit b(TextFieldDefaults r0, boolean r1, boolean r2, InteractionSource r3, Modifier r4, TextFieldColors r5, Shape r6, float r7, float r8, int r9, int r10, Composer r11, int r12) {
        return Container_4EFweAY$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit c(TextFieldDefaults r0, boolean r1, boolean r2, InteractionSource r3, TextFieldColors r4, Shape r5, int r6, int r7, Composer r8, int r9) {
        return ContainerBox$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.shape", imports = {}))
    public static /* synthetic */ void getFilledShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.FocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3332getFocusedBorderThicknessD9Ej5fM$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.shape", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    public static /* synthetic */ void getOutlinedShape$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.UnfocusedIndicatorThickness", imports = {}))
    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3333getUnfocusedBorderThicknessD9Ej5fM$annotations() {
    }

    static {
        INSTANCE = new TextFieldDefaults();
        MinHeight = Dp.constructor-impl(56);
        MinWidth = Dp.constructor-impl(280);
        float r0 = Dp.constructor-impl(1);
        UnfocusedIndicatorThickness = r0;
        float r1 = Dp.constructor-impl(2);
        FocusedIndicatorThickness = r1;
        UnfocusedBorderThickness = r0;
        FocusedBorderThickness = r1;
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3344getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m3345getFocusedIndicatorThicknessD9Ej5fM() {
        return FocusedIndicatorThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m3346getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m3347getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m3348getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorThickness-D9Ej5fM, reason: not valid java name */
    public final float m3349getUnfocusedIndicatorThicknessD9Ej5fM() {
        return UnfocusedIndicatorThickness;
    }

    public final TextFieldColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(831731228, r5, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:478)");
    L5:
        TextFieldColors r6 = defaultTextFieldColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6), (TextSelectionColors) r4.consume(TextSelectionColorsKt.getLocalTextSelectionColors()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final TextFieldColors defaultTextFieldColors$material3(ColorScheme r100, TextSelectionColors r101) {
        TextFieldColors r1 = r100.getDefaultTextFieldColorsCached$material3();
        if (r1 != null) goto L5;
    L9:
        FilledTextFieldTokens r2 = FilledTextFieldTokens.INSTANCE;
        TextFieldColors r3 = new TextFieldColors(ColorSchemeKt.fromToken(r100, r2.getFocusInputColor()), ColorSchemeKt.fromToken(r100, r2.getInputColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledInputColor()), r2.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getErrorInputColor()), ColorSchemeKt.fromToken(r100, r2.getContainerColor()), ColorSchemeKt.fromToken(r100, r2.getContainerColor()), ColorSchemeKt.fromToken(r100, r2.getContainerColor()), ColorSchemeKt.fromToken(r100, r2.getContainerColor()), ColorSchemeKt.fromToken(r100, r2.getCaretColor()), ColorSchemeKt.fromToken(r100, r2.getErrorFocusCaretColor()), r101, ColorSchemeKt.fromToken(r100, r2.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(r100, r2.getActiveIndicatorColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledActiveIndicatorColor()), r2.getDisabledActiveIndicatorOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(r100, r2.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(r100, r2.getLeadingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledLeadingIconColor()), r2.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(r100, r2.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(r100, r2.getTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledTrailingIconColor()), r2.getDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(r100, r2.getFocusLabelColor()), ColorSchemeKt.fromToken(r100, r2.getLabelColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledLabelColor()), r2.getDisabledLabelOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getErrorLabelColor()), ColorSchemeKt.fromToken(r100, r2.getInputPlaceholderColor()), ColorSchemeKt.fromToken(r100, r2.getInputPlaceholderColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledInputColor()), r2.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getInputPlaceholderColor()), ColorSchemeKt.fromToken(r100, r2.getFocusSupportingColor()), ColorSchemeKt.fromToken(r100, r2.getSupportingColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getDisabledSupportingColor()), r2.getDisabledSupportingOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getErrorSupportingColor()), ColorSchemeKt.fromToken(r100, r2.getInputPrefixColor()), ColorSchemeKt.fromToken(r100, r2.getInputPrefixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getInputPrefixColor()), r2.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getInputPrefixColor()), ColorSchemeKt.fromToken(r100, r2.getInputSuffixColor()), ColorSchemeKt.fromToken(r100, r2.getInputSuffixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r100, r2.getInputSuffixColor()), r2.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r100, r2.getInputSuffixColor()), null);
        r100.setDefaultTextFieldColorsCached$material3(r3);
        return r3;
    L5:
        if (Intrinsics.areEqual(r1.getTextSelectionColors(), r101) == true) goto L8;
        r1 = TextFieldColors.m3275copyejIjP34$default(r1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1025, 2047, null);
        r100.setDefaultTextFieldColorsCached$material3(r1);
    L8:
        if (r1 == null) goto L9;
        return r1;
    }

    public final Shape getFilledShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(611926497, r5, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:790)");
    L5:
        Shape r6 = getShape(r4, r5 & 14);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getOutlinedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-584749279, r5, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:782)");
    L5:
        Shape r6 = OutlinedTextFieldDefaults.INSTANCE.getShape(r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1941327459, r5, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:68)");
    L5:
        Shape r6 = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3342contentPaddingWithLabela9UjIt4(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r3, r2, r4);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3343contentPaddingWithoutLabela9UjIt4(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith = @ReplaceWith(expression = "OutlinedTextFieldDefaults.contentPadding(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {"androidx.compose.material.OutlinedTextFieldDefaults"}))
    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3352outlinedTextFieldPaddinga9UjIt4(float r2, float r3, float r4, float r5) {
        return OutlinedTextFieldDefaults.INSTANCE.m2972contentPaddinga9UjIt4(r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3, reason: not valid java name */
    public final PaddingValues m3353supportingTextPaddinga9UjIt4$material3(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3354textFieldWithLabelPaddinga9UjIt4(float r1, float r2, float r3, float r4) {
        return m3342contentPaddingWithLabela9UjIt4(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith = @ReplaceWith(expression = "TextFieldDefaults.contentPaddingWithoutLabel(\n        start = start,\n        top = top,\n        end = end,\n        bottom = bottom,\n    )", imports = {}))
    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m3355textFieldWithoutLabelPaddinga9UjIt4(float r1, float r2, float r3, float r4) {
        return m3343contentPaddingWithoutLabela9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: contentPaddingWithLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3330contentPaddingWithLabela9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = TextFieldImplKt.getTextFieldPadding();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = TextFieldImplKt.getTextFieldPadding();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
    L15:
        return r0.m3342contentPaddingWithLabela9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: contentPaddingWithoutLabel-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3331contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
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
        return r0.m3343contentPaddingWithoutLabela9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3336outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
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
        return r0.m3352outlinedTextFieldPaddinga9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3337supportingTextPaddinga9UjIt4$material3$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = TextFieldImplKt.getTextFieldPadding();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = TextFieldImplKt.getSupportingTopPadding();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = TextFieldImplKt.getTextFieldPadding();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = Dp.constructor-impl(0);
    L15:
        return r0.m3353supportingTextPaddinga9UjIt4$material3(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3338textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = TextFieldImplKt.getTextFieldPadding();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = TextFieldImplKt.getTextFieldPadding();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
    L15:
        return r0.m3354textFieldWithLabelPaddinga9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m3339textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
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
        return r0.m3355textFieldWithoutLabelPaddinga9UjIt4(r1, r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `textFieldShape`.")
    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final /* synthetic */ Modifier m3351indicatorLinegv0btCI(Modifier r10, boolean r11, boolean r12, InteractionSource r13, TextFieldColors r14, float r15, float r16) {
        return m3350indicatorLineAWlRVLg(r10, r11, r12, r13, r14, null, r15, r16);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TextFieldDefaults.Container", replaceWith = @ReplaceWith(expression = "Container(\n    enabled = enabled,\n    isError = isError,\n    interactionSource = interactionSource,\n    colors = colors,\n    shape = shape,\n)", imports = {}))
    public final void ContainerBox(final boolean r22, final boolean r23, final InteractionSource r24, final TextFieldColors r25, Shape r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(918564008);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r29 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r29 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L47:
        if ((r28 & 24576) == 0) goto L49;
        Shape r8 = r26;
    L58:
        if ((r29 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r9 = true;
    L72:
        if (r1.shouldExecute(r9, r3 & 1) == false) goto L92;
        r1.startDefaults();
        if ((r28 & 1) == 0) goto L82;
        if (r1.getDefaultsInvalid() == true) goto L82;
        r1.skipToGroupEnd();
        if ((r29 & 16) != 0) goto L84;
    L85:
        Shape r20 = r8;
        int r10 = r3;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventStart(918564008, r10, -1, "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:761)");
    L88:
        int r11 = (((r10 & 14) | 3072) | (r10 & 112)) | (r10 & 896);
        int r12 = r10 << 3;
        m3340Container4EFweAY(r22, r23, r24, Modifier.Companion, r25, r20, FocusedIndicatorThickness, UnfocusedIndicatorThickness, r1, ((r11 | (57344 & r12)) | (r12 & 458752)) | ((r10 << 9) & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
    L91:
        r8 = r20;
    L93:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L97;
        final Shape r6 = r8;
        r13.updateScope(new gt(this, r22, r23, r24, r25, r6, r28, r29));
        return;
    L97:
        return;
    L84:
        r3 = r3 & (-57345);
    L82:
        if ((r29 & 16) == 0) goto L85;
        r8 = INSTANCE.getShape(r1, 6);
        goto L84
    L92:
        r1.skipToGroupEnd();
        goto L93
    L70:
        r9 = false;
        goto L72
    L61:
        if ((r28 & 196608) != 0) goto L68;
        if (r1.changed(this) == false) goto L65;
        int r14 = 131072;
    L66:
        r3 = r3 | r14;
        goto L68
    L65:
        r14 = 65536;
        goto L66
    L49:
        if ((r29 & 16) != 0) goto L53;
        r8 = r26;
        if (r1.changed(r8) == false) goto L54;
        int r15 = 16384;
    L55:
        r3 = r3 | r15;
    L54:
        r15 = 8192;
        goto L55
    L53:
        r8 = r26;
        goto L54
    L39:
        if ((r28 & 3072) != 0) goto L47;
        if (r1.changed(r25) == false) goto L43;
        int r16 = 2048;
    L44:
        r3 = r3 | r16;
        goto L47
    L43:
        r16 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L36;
        if (r1.changed(r24) == false) goto L32;
        int r7 = 256;
    L33:
        r3 = r3 | r7;
        goto L36
    L32:
        r7 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L25;
        if (r1.changed(r23) == false) goto L21;
        int r5 = 32;
    L22:
        r3 = r3 | r5;
        goto L25
    L21:
        r5 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L14
    L8:
        if (r1.changed(r22) == false) goto L10;
        int r4 = 4;
    L11:
        r3 = r4 | r28;
        goto L14
    L10:
        r4 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: indicatorLine-AWlRVLg, reason: not valid java name */
    public final Modifier m3350indicatorLineAWlRVLg(Modifier r11, boolean r12, boolean r13, InteractionSource r14, TextFieldColors r15, Shape r16, float r17, float r18) {
        return r11.then(new IndicatorLineElement(r12, r13, r14, r15, r16, r17, r18, null));
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3335indicatorLinegv0btCI$default(TextFieldDefaults r9, Modifier r10, boolean r11, boolean r12, InteractionSource r13, TextFieldColors r14, float r15, float r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        float r7 = FocusedIndicatorThickness;
    L7:
        if ((r17 & 32) == 0) goto L9;
        float r8 = UnfocusedIndicatorThickness;
    L11:
        return r9.m3351indicatorLinegv0btCI(r10, r11, r12, r13, r14, r7, r8);
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: indicatorLine-AWlRVLg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3334indicatorLineAWlRVLg$default(TextFieldDefaults r11, Modifier r12, boolean r13, boolean r14, InteractionSource r15, TextFieldColors r16, Shape r17, float r18, float r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        TextFieldColors r7 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        Shape r8 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        float r9 = FocusedIndicatorThickness;
    L15:
        if ((r20 & 64) == 0) goto L17;
        float r10 = UnfocusedIndicatorThickness;
    L19:
        return r11.m3350indicatorLineAWlRVLg(r12, r13, r14, r15, r7, r8, r9, r10);
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    public final void m3340Container4EFweAY(final boolean r22, final boolean r23, final InteractionSource r24, Modifier r25, TextFieldColors r26, Shape r27, float r28, float r29, Composer r30, final int r31, final int r32) {
        Composer r15 = r30.startRestartGroup(-818661242);
        if ((r32 & 1) == 0) goto L6;
        int r1 = r31 | 6;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r32 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r32 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r3 = r25;
    L45:
        if ((r31 & 24576) == 0) goto L47;
        TextFieldColors r4 = r26;
    L56:
        if ((196608 & r31) == 0) goto L58;
        Shape r5 = r27;
    L67:
        if ((1572864 & r31) == 0) goto L69;
        float r6 = r28;
    L78:
        if ((12582912 & r31) != 0) goto L89;
        if ((r32 & 128) != 0) goto L85;
        if (r15.changed(r29) == false) goto L85;
        int r8 = 8388608;
    L86:
        r1 = r1 | r8;
    L85:
        r8 = 4194304;
    L89:
        if ((r32 & 256) == 0) goto L92;
        r1 = r1 | 100663296;
    L99:
        if ((38347923 & r1) == 38347922) goto L101;
        boolean r0 = true;
    L103:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L145;
        r15.startDefaults();
        if ((r31 & 1) != 0) goto L107;
    L122:
        if (r2 == 0) goto L124;
        Modifier r7 = Modifier.Companion;
    L126:
        if ((r32 & 16) == 0) goto L129;
        TextFieldColors r9 = colors(r15, (r1 >> 24) & 14);
        r1 = r1 & (-57345);
        r4 = r9;
    L129:
        if ((r32 & 32) == 0) goto L132;
        r1 = r1 & (-458753);
        r5 = INSTANCE.getShape(r15, 6);
    L132:
        if ((r32 & 64) == 0) goto L135;
        r1 = r1 & (-3670017);
        r6 = FocusedIndicatorThickness;
    L135:
        if ((r32 & 128) == 0) goto L137;
        r1 = r1 & (-29360129);
        float r18 = UnfocusedIndicatorThickness;
    L138:
        TextFieldColors r10 = r4;
        float r17 = r6;
        Shape r11 = r5;
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventStart(-818661242, r1, -1, "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:241)");
    L141:
        final State<Color> r12 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r10.m3276containerColorXeAY9LY$material3(r22, r23, ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r24, r15, (r1 >> 6) & 14).getValue()).booleanValue()), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r15, 6), null, null, r15, 0, 12);
        Modifier r16 = r7;
        BoxKt.Box(m3350indicatorLineAWlRVLg(TextFieldImplKt.textFieldBackground(r7, new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new TextFieldDefaults$Container$1(r12)), r11), r22, r23, r24, r10, r11, r17, r18), r15, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventEnd();
    L144:
        final Modifier r13 = r16;
        final float r14 = r17;
        final TextFieldColors r19 = r10;
        final Shape r20 = r11;
    L146:
        ScopeUpdateScope r110 = r15.endRestartGroup();
        if (r110 == null) goto L150;
        final float r21 = r18;
        r110.updateScope(new ht(this, r22, r23, r24, r13, r19, r20, r14, r21, r31, r32));
        return;
    L150:
        return;
    L137:
        r18 = r29;
        goto L138
    L124:
        r7 = r3;
        goto L126
    L107:
        if (r15.getDefaultsInvalid() == true) goto L122;
        r15.skipToGroupEnd();
        if ((r32 & 16) == 0) goto L113;
        r1 = r1 & (-57345);
    L113:
        if ((r32 & 32) == 0) goto L116;
        r1 = r1 & (-458753);
    L116:
        if ((r32 & 64) == 0) goto L119;
        r1 = r1 & (-3670017);
    L119:
        if ((r32 & 128) == 0) goto L121;
        r1 = r1 & (-29360129);
    L121:
        r18 = r29;
        r7 = r3;
        goto L138
    L145:
        r15.skipToGroupEnd();
        r18 = r29;
        r20 = r5;
        r14 = r6;
        r13 = r3;
        r19 = r4;
        goto L146
    L101:
        r0 = false;
        goto L103
    L92:
        if ((r31 & 100663296) != 0) goto L99;
        if (r15.changed(this) == false) goto L96;
        int r33 = 67108864;
    L97:
        r1 = r1 | r33;
        goto L99
    L96:
        r33 = 33554432;
        goto L97
    L69:
        if ((r32 & 64) != 0) goto L73;
        r6 = r28;
        if (r15.changed(r6) == false) goto L74;
        int r34 = 1048576;
    L75:
        r1 = r1 | r34;
    L74:
        r34 = 524288;
        goto L75
    L73:
        r6 = r28;
        goto L74
    L58:
        if ((r32 & 32) != 0) goto L62;
        r5 = r27;
        if (r15.changed(r5) == false) goto L63;
        int r35 = 131072;
    L64:
        r1 = r1 | r35;
    L63:
        r35 = 65536;
        goto L64
    L62:
        r5 = r27;
        goto L63
    L47:
        if ((r32 & 16) != 0) goto L51;
        r4 = r26;
        if (r15.changed(r4) == false) goto L52;
        int r36 = 16384;
    L53:
        r1 = r1 | r36;
    L52:
        r36 = 8192;
        goto L53
    L51:
        r4 = r26;
        goto L52
    L37:
        if ((r31 & 3072) != 0) goto L43;
        r3 = r25;
        if (r15.changed(r3) == false) goto L41;
        int r37 = 2048;
    L42:
        r1 = r1 | r37;
        goto L45
    L41:
        r37 = 1024;
        goto L42
    L27:
        if ((r31 & 384) != 0) goto L33;
        if (r15.changed(r24) == false) goto L31;
        int r38 = 256;
    L32:
        r1 = r1 | r38;
        goto L33
    L31:
        r38 = 128;
        goto L32
    L17:
        if ((r31 & 48) != 0) goto L24;
        if (r15.changed(r23) == false) goto L21;
        int r39 = 32;
    L22:
        r1 = r1 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r1 = r31;
        goto L14
    L8:
        if (r15.changed(r22) == false) goto L10;
        int r40 = 4;
    L11:
        r1 = r40 | r31;
        goto L14
    L10:
        r40 = 2;
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
        if ((32768 & r49) == 0) goto L51;
        if (r15 != null) goto L46;
    L49:
        PaddingValues r6 = m3331contentPaddingWithoutLabela9UjIt4$default(this, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L50:
        PaddingValues r25 = r6;
    L53:
        if ((r49 & 65536) == 0) goto L55;
        Function2<? super Composer, ? super Integer, Unit> r27 = ComposableLambdaKt.rememberComposableLambda(245572296, true, new C02801(r30, r3, r33, r4), r46, 54);
    L57:
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventStart(320881373, r47, r48, "androidx.compose.material3.TextFieldDefaults.decorator (TextFieldDefaults.kt:178)");
    L59:
        AnonymousClass2 r0 = new AnonymousClass2(r32, r29, r31, r14, r15, r16, r17, r18, r19, r20, r21, r30, r3, r33, r25, r4, r27);
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
    L62:
        return r0;
    L55:
        r27 = r45;
        goto L57
    L46:
        if ((r14 instanceof TextFieldLabelPosition.Above) == true) goto L49;
        r6 = m3330contentPaddingWithLabela9UjIt4$default(this, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        goto L50
    L51:
        r25 = r44;
        goto L53
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

    public final void DecorationBox(final String r42, final Function2<? super Composer, ? super Integer, Unit> r43, final boolean r44, final boolean r45, final VisualTransformation r46, final InteractionSource r47, boolean r48, Function2<? super Composer, ? super Integer, Unit> r49, Function2<? super Composer, ? super Integer, Unit> r50, Function2<? super Composer, ? super Integer, Unit> r51, Function2<? super Composer, ? super Integer, Unit> r52, Function2<? super Composer, ? super Integer, Unit> r53, Function2<? super Composer, ? super Integer, Unit> r54, Function2<? super Composer, ? super Integer, Unit> r55, Shape r56, TextFieldColors r57, PaddingValues r58, Function2<? super Composer, ? super Integer, Unit> r59, Composer r60, final int r61, final int r62, final int r63) {
        Composer r0 = r60.startRestartGroup(1806980801);
        if ((r63 & 1) == 0) goto L6;
        int r1 = r61 | 6;
    L14:
        if ((r63 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r63 & 4) == 0) goto L28;
        r1 = r1 | 384;
    L35:
        int r17 = 2048;
        if ((r63 & 8) == 0) goto L39;
        r1 = r1 | 3072;
    L47:
        if ((r63 & 16) == 0) goto L50;
        r1 = r1 | 24576;
    L57:
        if ((r63 & 32) == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        int r22 = r63 & 64;
        if (r22 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        int r4 = r63 & 128;
        if (r4 == 0) goto L81;
        r1 = r1 | 12582912;
    L87:
        int r3 = r63 & 256;
        if (r3 == 0) goto L91;
        r1 = r1 | 100663296;
    L97:
        int r5 = r63 & 512;
        if (r5 == 0) goto L101;
        r1 = r1 | 805306368;
    L107:
        int r7 = r63 & 1024;
        if (r7 == 0) goto L111;
        int r29 = r62 | 6;
    L118:
        int r8 = r63 & 2048;
        if (r8 == 0) goto L122;
        r29 = r29 | 48;
    L128:
        int r9 = r29;
        int r10 = r63 & 4096;
        if (r10 == 0) goto L132;
        r9 = r9 | 384;
    L139:
        int r11 = r63 & 8192;
        if (r11 == 0) goto L143;
        r9 = r9 | 3072;
    L151:
        if ((r62 & 24576) != 0) goto L162;
        if ((r63 & 16384) != 0) goto L158;
        if (r0.changed(r56) == false) goto L158;
        int r16 = 16384;
    L159:
        r9 = r9 | r16;
    L158:
        r16 = 8192;
    L162:
        if ((r62 & 196608) != 0) goto L172;
        if ((r63 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        int r18 = 65536;
    L169:
        r9 = r9 | r18;
        goto L172
    L166:
        if (r0.changed(r57) == false) goto L168;
        r18 = 131072;
    L172:
        if ((r62 & 1572864) != 0) goto L181;
        if ((r63 & 65536) == 0) goto L176;
    L178:
        int r19 = 524288;
    L179:
        r9 = r9 | r19;
        goto L181
    L176:
        if (r0.changed(r58) == false) goto L178;
        r19 = 1048576;
    L181:
        int r110 = r63 & 131072;
        if (r110 == 0) goto L185;
        r9 = r9 | 12582912;
    L192:
        if ((r63 & 262144) == 0) goto L195;
        r9 = r9 | 100663296;
    L201:
        boolean r111 = false;
        if ((r1 & 306783379) == 306783378) goto L204;
    L207:
        boolean r6 = true;
    L209:
        if (r0.shouldExecute(r6, r1 & 1) == false) goto L292;
        r0.startDefaults();
        if ((r61 & 1) != 0) goto L213;
    L225:
        if (r22 == 0) goto L227;
        boolean r12 = false;
    L228:
        if (r4 == 0) goto L230;
        Function2<? super Composer, ? super Integer, Unit> r13 = null;
    L231:
        if (r3 == 0) goto L233;
        Function2<? super Composer, ? super Integer, Unit> r14 = null;
    L234:
        if (r5 == 0) goto L236;
        Function2<? super Composer, ? super Integer, Unit> r15 = null;
    L237:
        if (r7 == 0) goto L239;
        Function2<? super Composer, ? super Integer, Unit> r20 = null;
    L240:
        if (r8 == 0) goto L242;
        Function2<? super Composer, ? super Integer, Unit> r21 = null;
    L243:
        if (r10 == 0) goto L245;
        Function2<? super Composer, ? super Integer, Unit> r112 = null;
    L246:
        if (r11 == 0) goto L248;
        Function2<? super Composer, ? super Integer, Unit> r113 = null;
    L250:
        if ((r63 & 16384) == 0) goto L252;
        Shape r2 = INSTANCE.getShape(r0, 6);
        r9 = r9 & (-57345);
    L254:
        if ((r63 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L256;
        TextFieldColors r114 = colors(r0, (r9 >> 24) & 14);
        r9 = r9 & (-458753);
    L258:
        if ((r63 & 65536) == 0) goto L263;
        if (r13 != null) goto L261;
        PaddingValues r115 = m3331contentPaddingWithoutLabela9UjIt4$default(this, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
    L262:
        r9 = r9 & (-3670017);
    L264:
        if (r110 == 0) goto L266;
        Function2<? super Composer, ? super Integer, Unit> r116 = r14;
        final boolean r510 = r12;
        final TextFieldColors r511 = r114;
        final Shape r512 = r2;
        Function2<Composer, Integer, Unit> r23 = new AnonymousClass1(r44, r510, r47, r511, r512);
        Shape r410 = r2;
        Function2<? super Composer, ? super Integer, Unit> r411 = r13;
        Function2<? super Composer, ? super Integer, Unit> r24 = r15;
        Function2<? super Composer, ? super Integer, Unit> r38 = ComposableLambdaKt.rememberComposableLambda(417908150, true, r23, r0, 54);
        int r25 = r9;
        r14 = r116;
        PaddingValues r37 = r115;
        Shape r26 = r410;
        final Function2<? super Composer, ? super Integer, Unit> r27 = r411;
    L267:
        r0.endDefaults();
        Shape r412 = r26;
        if (ComposerKt.isTraceInProgress() == false) goto L271;
        ComposerKt.traceEventStart(1806980801, r1, r25, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:401)");
    L271:
        if ((r1 & 14) != 4) goto L273;
        boolean r28 = true;
    L275:
        if ((57344 & r1) != 16384) goto L277;
        r111 = true;
    L277:
        boolean r30 = r28 | r111;
        Object r117 = r0.rememberedValue();
        if (r30 == false) goto L280;
    L283:
        boolean r118 = true;
        Function3 r119 = null;
        Object r31 = r46.filter(new AnnotatedString(r42, null, 2, null));
        r0.updateRememberedValue(r31);
    L284:
        String r120 = ((TransformedText) r31).getText().getText();
        TextFieldType r121 = TextFieldType.Filled;
        TextFieldLabelPosition.Attached r122 = new TextFieldLabelPosition.Attached(false, null, null, 7, null);
        if (r27 != null) goto L287;
        r0.startReplaceGroup(-1353131191);
        r0.endReplaceGroup();
    L288:
        int r32 = r1 >> 9;
        int r33 = ((((r1 << 3) & 896) | 6) | (458752 & r32)) | (3670016 & r32);
        int r123 = r25 << 21;
        int r35 = ((r33 | (r123 & 29360128)) | (r123 & 234881024)) | (r123 & 1879048192);
        int r34 = ((((r25 >> 9) & 14) | ((r1 >> 6) & 112)) | (r1 & 896)) | (r32 & 7168);
        Function3 r210 = r119;
        Function2<? super Composer, ? super Integer, Unit> r211 = r14;
        Function2<? super Composer, ? super Integer, Unit> r212 = r24;
        Function2<? super Composer, ? super Integer, Unit> r213 = r20;
        Function2<? super Composer, ? super Integer, Unit> r214 = r21;
        Function2<? super Composer, ? super Integer, Unit> r215 = r112;
        Function2<? super Composer, ? super Integer, Unit> r216 = r113;
        boolean r217 = r12;
        PaddingValues r36 = r37;
        TextFieldColors r39 = r114;
        Function2<? super Composer, ? super Integer, Unit> r310 = r38;
        TextFieldImplKt.CommonDecorationBox(r121, r120, r43, r122, r210, r211, r212, r213, r214, r215, r216, r45, r44, r217, r47, r36, r39, r310, r0, r35, (((((r1 >> 3) & 57344) | r34) | ((r25 >> 3) & 458752)) | ((r25 << 3) & 3670016)) | (29360128 & r25));
        if (ComposerKt.isTraceInProgress() == false) goto L291;
        ComposerKt.traceEventEnd();
    L291:
        Shape r124 = r412;
        TextFieldColors r125 = r114;
        final Function2<? super Composer, ? super Integer, Unit> r40 = r27;
        Function2<? super Composer, ? super Integer, Unit> r126 = r20;
        Function2<? super Composer, ? super Integer, Unit> r127 = r21;
        Function2<? super Composer, ? super Integer, Unit> r128 = r112;
        Function2<? super Composer, ? super Integer, Unit> r129 = r113;
        final Function2<? super Composer, ? super Integer, Unit> r130 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r131 = r24;
        final boolean r41 = r12;
    L293:
        ScopeUpdateScope r64 = r0.endRestartGroup();
        if (r64 == null) goto L297;
        final Function2<? super Composer, ? super Integer, Unit> r132 = r126;
        final Function2<? super Composer, ? super Integer, Unit> r133 = r127;
        final Function2<? super Composer, ? super Integer, Unit> r134 = r128;
        final Function2<? super Composer, ? super Integer, Unit> r135 = r129;
        final Shape r136 = r124;
        final TextFieldColors r137 = r125;
        final PaddingValues r138 = r37;
        final Function2<? super Composer, ? super Integer, Unit> r139 = r38;
        r64.updateScope(new ft(this, r42, r43, r44, r45, r46, r47, r41, r40, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r61, r62, r63));
        return;
    L297:
        return;
    L287:
        r0.startReplaceGroup(-1353131190);
        Function3 r65 = ComposableLambdaKt.rememberComposableLambda(1110058497, r118, new TextFieldDefaults$DecorationBox$2$1(r27), r0, 54);
        r0.endReplaceGroup();
        r119 = r65;
        goto L288
    L280:
        if (r117 == Composer.Companion.getEmpty()) goto L283;
        r31 = r117;
        r118 = true;
        r119 = null;
        goto L284
    L273:
        r28 = false;
        goto L275
    L266:
        Shape r413 = r2;
        r27 = r13;
        r24 = r15;
        r38 = r59;
        r25 = r9;
        r37 = r115;
        r26 = r413;
        goto L267
    L261:
        r115 = m3330contentPaddingWithLabela9UjIt4$default(this, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        goto L262
    L263:
        r115 = r58;
        goto L264
    L256:
        r114 = r57;
        goto L258
    L252:
        r2 = r56;
        goto L254
    L248:
        r113 = r55;
        goto L250
    L245:
        r112 = r54;
        goto L246
    L242:
        r21 = r53;
        goto L243
    L239:
        r20 = r52;
        goto L240
    L236:
        r15 = r51;
        goto L237
    L233:
        r14 = r50;
        goto L234
    L230:
        r13 = r49;
        goto L231
    L227:
        r12 = r48;
        goto L228
    L213:
        if (r0.getDefaultsInvalid() == true) goto L225;
        r0.skipToGroupEnd();
        if ((r63 & 16384) == 0) goto L219;
        r9 = r9 & (-57345);
    L219:
        if ((32768 & r63) == 0) goto L222;
        r9 = r9 & (-458753);
    L222:
        if ((r63 & 65536) == 0) goto L224;
        r9 = r9 & (-3670017);
    L224:
        r12 = r48;
        r27 = r49;
        r14 = r50;
        r24 = r51;
        r20 = r52;
        r21 = r53;
        r112 = r54;
        r113 = r55;
        r114 = r57;
        r37 = r58;
        r38 = r59;
        r25 = r9;
        r26 = r56;
        goto L267
    L292:
        r0.skipToGroupEnd();
        r41 = r48;
        r40 = r49;
        r130 = r50;
        r131 = r51;
        r126 = r52;
        r127 = r53;
        r128 = r54;
        r129 = r55;
        r124 = r56;
        r125 = r57;
        r37 = r58;
        r38 = r59;
        goto L293
    L204:
        if ((38347923 & r9) != 38347922) goto L207;
        r6 = false;
        goto L209
    L195:
        if ((r62 & 100663296) != 0) goto L201;
        if (r0.changed(this) == false) goto L199;
        int r140 = 67108864;
    L200:
        r9 = r9 | r140;
        goto L201
    L199:
        r140 = 33554432;
        goto L200
    L185:
        if ((r62 & 12582912) != 0) goto L192;
        if (r0.changedInstance(r59) == false) goto L189;
        int r141 = 8388608;
    L190:
        r9 = r9 | r141;
        goto L192
    L189:
        r141 = 4194304;
        goto L190
    L143:
        if ((r62 & 3072) != 0) goto L151;
        if (r0.changedInstance(r55) == true) goto L148;
        r17 = 1024;
    L148:
        r9 = r9 | r17;
        goto L151
    L132:
        if ((r62 & 384) != 0) goto L139;
        if (r0.changedInstance(r54) == false) goto L136;
        int r142 = 256;
    L137:
        r9 = r9 | r142;
        goto L139
    L136:
        r142 = 128;
        goto L137
    L122:
        if ((r62 & 48) != 0) goto L128;
        if (r0.changedInstance(r53) == false) goto L126;
        int r143 = 32;
    L127:
        r29 = r29 | r143;
        goto L128
    L126:
        r143 = 16;
        goto L127
    L111:
        if ((r62 & 6) == 0) goto L113;
        r29 = r62;
        goto L118
    L113:
        if (r0.changedInstance(r52) == false) goto L115;
        int r218 = 4;
    L116:
        r29 = r62 | r218;
        goto L118
    L115:
        r218 = 2;
        goto L116
    L101:
        if ((r61 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r51) == false) goto L105;
        int r219 = 536870912;
    L106:
        r1 = r1 | r219;
        goto L107
    L105:
        r219 = 268435456;
        goto L106
    L91:
        if ((r61 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r50) == false) goto L95;
        int r220 = 67108864;
    L96:
        r1 = r1 | r220;
        goto L97
    L95:
        r220 = 33554432;
        goto L96
    L81:
        if ((r61 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r49) == false) goto L85;
        int r221 = 8388608;
    L86:
        r1 = r1 | r221;
        goto L87
    L85:
        r221 = 4194304;
        goto L86
    L71:
        if ((r61 & 1572864) != 0) goto L77;
        if (r0.changed(r48) == false) goto L75;
        int r222 = 1048576;
    L76:
        r1 = r1 | r222;
        goto L77
    L75:
        r222 = 524288;
        goto L76
    L60:
        if ((r61 & 196608) != 0) goto L67;
        if (r0.changed(r47) == false) goto L64;
        int r223 = 131072;
    L65:
        r1 = r1 | r223;
        goto L67
    L64:
        r223 = 65536;
        goto L65
    L50:
        if ((r61 & 24576) != 0) goto L57;
        if (r0.changed(r46) == false) goto L54;
        int r144 = 16384;
    L55:
        r1 = r1 | r144;
        goto L57
    L54:
        r144 = 8192;
        goto L55
    L39:
        if ((r61 & 3072) != 0) goto L47;
        if (r0.changed(r45) == false) goto L43;
        int r145 = 2048;
    L44:
        r1 = r1 | r145;
        goto L47
    L43:
        r145 = 1024;
        goto L44
    L28:
        if ((r61 & 384) != 0) goto L35;
        if (r0.changed(r44) == false) goto L32;
        int r146 = 256;
    L33:
        r1 = r1 | r146;
        goto L35
    L32:
        r146 = 128;
        goto L33
    L17:
        if ((r61 & 48) != 0) goto L25;
        if (r0.changedInstance(r43) == false) goto L21;
        int r66 = 32;
    L22:
        r1 = r1 | r66;
        goto L25
    L21:
        r66 = 16;
        goto L22
    L6:
        if ((r61 & 6) == 0) goto L8;
        r1 = r61;
        goto L14
    L8:
        if (r0.changed(r42) == false) goto L10;
        int r67 = 4;
    L11:
        r1 = r67 | r61;
        goto L14
    L10:
        r67 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m3341colors0hiis_0(long r88, long r90, long r92, long r94, long r96, long r98, long r100, long r102, long r104, long r106, TextSelectionColors r108, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, Composer r173, int r174, int r175, int r176, int r177, int r178, int r179, int r180) {
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
        TextSelectionColors r1711 = r112;
        if ((r179 & 2048) == 0) goto L49;
        long r114 = Color.Companion.getUnspecified-0d7_KjU();
    L50:
        long r23 = r114;
        if ((r179 & 4096) == 0) goto L53;
        long r116 = Color.Companion.getUnspecified-0d7_KjU();
    L54:
        long r25 = r116;
        if ((r179 & 8192) == 0) goto L57;
        long r118 = Color.Companion.getUnspecified-0d7_KjU();
    L58:
        long r27 = r118;
        if ((r179 & 16384) == 0) goto L61;
        long r120 = Color.Companion.getUnspecified-0d7_KjU();
    L63:
        if ((r179 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r29 = Color.Companion.getUnspecified-0d7_KjU();
    L67:
        if ((r179 & 65536) == 0) goto L69;
        long r31 = Color.Companion.getUnspecified-0d7_KjU();
    L71:
        if ((r179 & 131072) == 0) goto L73;
        long r33 = Color.Companion.getUnspecified-0d7_KjU();
    L75:
        if ((r179 & 262144) == 0) goto L77;
        long r35 = Color.Companion.getUnspecified-0d7_KjU();
    L79:
        if ((r179 & 524288) == 0) goto L81;
        long r37 = Color.Companion.getUnspecified-0d7_KjU();
    L83:
        if ((r179 & 1048576) == 0) goto L85;
        long r39 = Color.Companion.getUnspecified-0d7_KjU();
    L87:
        if ((r179 & 2097152) == 0) goto L89;
        long r41 = Color.Companion.getUnspecified-0d7_KjU();
    L91:
        if ((r179 & 4194304) == 0) goto L93;
        long r43 = Color.Companion.getUnspecified-0d7_KjU();
    L95:
        if ((r179 & 8388608) == 0) goto L97;
        long r45 = Color.Companion.getUnspecified-0d7_KjU();
    L99:
        if ((r179 & 16777216) == 0) goto L101;
        long r47 = Color.Companion.getUnspecified-0d7_KjU();
    L103:
        if ((r179 & 33554432) == 0) goto L105;
        long r49 = Color.Companion.getUnspecified-0d7_KjU();
    L107:
        if ((r179 & 67108864) == 0) goto L109;
        long r51 = Color.Companion.getUnspecified-0d7_KjU();
    L111:
        if ((r179 & 134217728) == 0) goto L113;
        long r53 = Color.Companion.getUnspecified-0d7_KjU();
    L115:
        if ((r179 & 268435456) == 0) goto L117;
        long r55 = Color.Companion.getUnspecified-0d7_KjU();
    L119:
        if ((r179 & 536870912) == 0) goto L121;
        long r57 = Color.Companion.getUnspecified-0d7_KjU();
    L123:
        if ((r179 & 1073741824) == 0) goto L125;
        long r59 = Color.Companion.getUnspecified-0d7_KjU();
    L127:
        if ((r180 & 1) == 0) goto L129;
        long r61 = Color.Companion.getUnspecified-0d7_KjU();
    L131:
        if ((r180 & 2) == 0) goto L133;
        long r63 = Color.Companion.getUnspecified-0d7_KjU();
    L135:
        if ((r180 & 4) == 0) goto L137;
        long r65 = Color.Companion.getUnspecified-0d7_KjU();
    L139:
        if ((r180 & 8) == 0) goto L141;
        long r67 = Color.Companion.getUnspecified-0d7_KjU();
    L143:
        if ((r180 & 16) == 0) goto L145;
        long r69 = Color.Companion.getUnspecified-0d7_KjU();
    L147:
        if ((r180 & 32) == 0) goto L149;
        long r71 = Color.Companion.getUnspecified-0d7_KjU();
    L151:
        if ((r180 & 64) == 0) goto L153;
        long r73 = Color.Companion.getUnspecified-0d7_KjU();
    L155:
        if ((r180 & 128) == 0) goto L157;
        long r75 = Color.Companion.getUnspecified-0d7_KjU();
    L159:
        if ((r180 & 256) == 0) goto L161;
        long r77 = Color.Companion.getUnspecified-0d7_KjU();
    L163:
        if ((r180 & 512) == 0) goto L165;
        long r79 = Color.Companion.getUnspecified-0d7_KjU();
    L167:
        if ((r180 & 1024) == 0) goto L169;
        long r81 = Color.Companion.getUnspecified-0d7_KjU();
    L171:
        if ((r180 & 2048) == 0) goto L173;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L174:
        long r1712 = r1;
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventStart(1513344955, r174, r175, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:580)");
    L178:
        TextFieldColors r0 = defaultTextFieldColors$material3(MaterialTheme.INSTANCE.getColorScheme(r173, 6), (TextSelectionColors) r173.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m3277copyejIjP34(r3, r5, r7, r9, r11, r13, r1710, r17, r19, r21, r1711, r23, r25, r27, r120, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r1712);
        if (ComposerKt.isTraceInProgress() == false) goto L181;
        ComposerKt.traceEventEnd();
    L181:
        return r0;
    L173:
        r1 = r171;
        goto L174
    L169:
        r81 = r169;
        goto L171
    L165:
        r79 = r167;
        goto L167
    L161:
        r77 = r165;
        goto L163
    L157:
        r75 = r163;
        goto L159
    L153:
        r73 = r161;
        goto L155
    L149:
        r71 = r159;
        goto L151
    L145:
        r69 = r157;
        goto L147
    L141:
        r67 = r155;
        goto L143
    L137:
        r65 = r153;
        goto L139
    L133:
        r63 = r151;
        goto L135
    L129:
        r61 = r149;
        goto L131
    L125:
        r59 = r147;
        goto L127
    L121:
        r57 = r145;
        goto L123
    L117:
        r55 = r143;
        goto L119
    L113:
        r53 = r141;
        goto L115
    L109:
        r51 = r139;
        goto L111
    L105:
        r49 = r137;
        goto L107
    L101:
        r47 = r135;
        goto L103
    L97:
        r45 = r133;
        goto L99
    L93:
        r43 = r131;
        goto L95
    L89:
        r41 = r129;
        goto L91
    L85:
        r39 = r127;
        goto L87
    L81:
        r37 = r125;
        goto L83
    L77:
        r35 = r123;
        goto L79
    L73:
        r33 = r121;
        goto L75
    L69:
        r31 = r119;
        goto L71
    L65:
        r29 = r117;
        goto L67
    L61:
        r120 = r115;
        goto L63
    L57:
        r118 = r113;
        goto L58
    L53:
        r116 = r111;
        goto L54
    L49:
        r114 = r109;
        goto L50
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
