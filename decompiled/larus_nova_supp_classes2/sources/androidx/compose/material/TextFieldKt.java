package androidx.compose.material;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0085\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u0010$\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00101\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00102\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u0002032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00104\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u0002032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00105\u001a\u009a\u0001\u00106\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010(¢\u0006\u0002\b\r2\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u00109\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\u0010>\u001a?\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0002¢\u0006\u0004\bG\u0010H\u001aW\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020/2\u0006\u0010E\u001a\u00020F2\u0006\u0010P\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002¢\u0006\u0004\bQ\u0010R\u001at\u0010S\u001a\u00020\u0001*\u00020T2\u0006\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010Z\u001a\u0004\u0018\u00010X2\b\u0010[\u001a\u0004\u0018\u00010X2\b\u0010\\\u001a\u0004\u0018\u00010X2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010]\u001a\u00020/2\u0006\u0010^\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010P\u001a\u00020;H\u0002\u001aZ\u0010_\u001a\u00020\u0001*\u00020T2\u0006\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020/2\u0006\u0010`\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u00010X2\b\u0010[\u001a\u0004\u0018\u00010X2\b\u0010\\\u001a\u0004\u0018\u00010X2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010P\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002\u001a\u0014\u0010a\u001a\u00020\u0005*\u00020\u00052\u0006\u0010b\u001a\u00020cH\u0000\"\u0016\u0010d\u001a\u00020eX\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0016\u0010i\u001a\u00020eX\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010g\"\u0016\u0010k\u001a\u00020eX\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bl\u0010g¨\u0006m"}, d2 = {TextFieldImplKt.TextFieldId, "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldKt {
    private static final float FirstBaselineOffset = 0.0f;
    private static final float TextFieldBottomPadding = 0.0f;
    private static final float TextFieldTopPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldKt$TextField$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements TextFieldDecorator {
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ Function2<Composer, Integer, Unit> $label;
        final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
        final /* synthetic */ TextFieldLineLimits $lineLimits;
        final /* synthetic */ OutputTransformation $outputTransformation;
        final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

        public AnonymousClass1(OutputTransformation r1, TextFieldState r2, TextFieldLineLimits r3, boolean r4, MutableInteractionSource r5, boolean r6, Function2<? super Composer, ? super Integer, Unit> r7, Function2<? super Composer, ? super Integer, Unit> r8, Function2<? super Composer, ? super Integer, Unit> r9, Function2<? super Composer, ? super Integer, Unit> r10, Shape r11, TextFieldColors r12) {
            this.$outputTransformation = r1;
            this.$state = r2;
            this.$lineLimits = r3;
            this.$enabled = r4;
            this.$interactionSource = r5;
            this.$isError = r6;
            this.$label = r7;
            this.$placeholder = r8;
            this.$leadingIcon = r9;
            this.$trailingIcon = r10;
            this.$shape = r11;
            this.$colors = r12;
        }

        private static final Unit Decoration$lambda$2(AnonymousClass1 r0, Function2 r1, int r2, Composer r3, int r4) {
            r0.Decoration(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit a(AnonymousClass1 r0, Function2 r1, int r2, Composer r3, int r4) {
            return Decoration$lambda$2(r0, r1, r2, r3, r4);
        }

        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25) {
            Composer r3 = r24.startRestartGroup(-1516988351);
            if ((r25 & 6) == 0) goto L5;
            int r5 = r25;
        L11:
            if ((r25 & 48) == 0) goto L13;
        L17:
            int r15 = r5;
            if ((r15 & 19) == 18) goto L20;
            boolean r6 = true;
        L22:
            if (r3.shouldExecute(r6, r15 & 1) == true) goto L24;
            Composer r21 = r3;
            r21.skipToGroupEnd();
        L44:
            ScopeUpdateScope r2 = r21.endRestartGroup();
            if (r2 == null) goto L50;
            r2.updateScope(new gd(this, r23, r25));
            return;
        L50:
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L27;
            ComposerKt.traceEventStart(-1516988351, r15, -1, "androidx.compose.material.TextField.<no name provided>.Decoration (TextField.kt:226)");
        L27:
            if (this.$outputTransformation != null) goto L30;
            String r4 = this.$state.getText().toString();
        L29:
            String r17 = r4;
            TextFieldDefaults r7 = TextFieldDefaults.INSTANCE;
            VisualTransformation r8 = VisualTransformation.Companion.getNone();
            boolean r9 = Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE);
            r21 = r3;
            r7.TextFieldDecorationBox(r17, r23, this.$enabled, r9, r8, this.$interactionSource, this.$isError, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$shape, this.$colors, null, r21, ((r15 << 3) & 112) | 24576, 24576, 8192);
            if (ComposerKt.isTraceInProgress() == false) goto L44;
            ComposerKt.traceEventEnd();
            goto L44
        L30:
            TextFieldState r10 = this.$state;
            TextFieldBuffer r11 = r10.startEdit();
            r10.commitEdit(r11);     // Catch: Throwable -> L40
            r10.finishEditing();
            OutputTransformation r12 = this.$outputTransformation;
            if (r11 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("buffer");
            TextFieldBuffer r13 = null;
        L36:
            r12.transformOutput(r13);
            r4 = r11.asCharSequence().toString();
            goto L29
        L35:
            r13 = r11;
        L40:
            th = move-exception;
            r10.finishEditing();
            throw th;
        L20:
            r6 = false;
            goto L22
        L13:
            if (r3.changed(this) == false) goto L15;
            int r14 = 32;
        L16:
            r5 = r5 | r14;
            goto L17
        L15:
            r14 = 16;
            goto L16
        L5:
            if (r3.changedInstance(r23) == false) goto L7;
            int r16 = 4;
        L8:
            r5 = r16 | r25;
            goto L11
        L7:
            r16 = 2;
            goto L8
        }
    }

    private static final Unit TextField$lambda$10(TextFieldValue r24, Function1 r25, Modifier r26, boolean r27, boolean r28, TextStyle r29, Function2 r30, Function2 r31, Function2 r32, Function2 r33, boolean r34, VisualTransformation r35, KeyboardOptions r36, KeyboardActions r37, boolean r38, int r39, int r40, MutableInteractionSource r41, Shape r42, TextFieldColors r43, int r44, int r45, int r46, Composer r47, int r48) {
        TextField(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    private static final Unit TextField$lambda$12(TextFieldValue r23, Function1 r24, Modifier r25, boolean r26, boolean r27, TextStyle r28, Function2 r29, Function2 r30, Function2 r31, Function2 r32, boolean r33, VisualTransformation r34, KeyboardOptions r35, KeyboardActions r36, boolean r37, int r38, MutableInteractionSource r39, Shape r40, TextFieldColors r41, int r42, int r43, int r44, Composer r45, int r46) {
        TextField(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit TextField$lambda$2(TextFieldState r23, Modifier r24, boolean r25, boolean r26, TextStyle r27, Function2 r28, Function2 r29, Function2 r30, Function2 r31, boolean r32, InputTransformation r33, OutputTransformation r34, KeyboardOptions r35, KeyboardActionHandler r36, TextFieldLineLimits r37, ScrollState r38, Shape r39, TextFieldColors r40, MutableInteractionSource r41, int r42, int r43, int r44, Composer r45, int r46) {
        TextField(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit TextField$lambda$5(String r24, Function1 r25, Modifier r26, boolean r27, boolean r28, TextStyle r29, Function2 r30, Function2 r31, Function2 r32, Function2 r33, boolean r34, VisualTransformation r35, KeyboardOptions r36, KeyboardActions r37, boolean r38, int r39, int r40, MutableInteractionSource r41, Shape r42, TextFieldColors r43, int r44, int r45, int r46, Composer r47, int r48) {
        TextField(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    private static final Unit TextField$lambda$7(String r23, Function1 r24, Modifier r25, boolean r26, boolean r27, TextStyle r28, Function2 r29, Function2 r30, Function2 r31, Function2 r32, boolean r33, VisualTransformation r34, KeyboardOptions r35, KeyboardActions r36, boolean r37, int r38, MutableInteractionSource r39, Shape r40, TextFieldColors r41, int r42, int r43, int r44, Composer r45, int r46) {
        TextField(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldLayout$lambda$19(Modifier r12, Function2 r13, Function2 r14, Function3 r15, Function2 r16, Function2 r17, boolean r18, float r19, PaddingValues r20, int r21, Composer r22, int r23) {
        TextFieldLayout(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, int r17, MutableInteractionSource r18, Shape r19, TextFieldColors r20, int r21, int r22, int r23, Composer r24, int r25) {
        return TextField$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit b(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, MutableInteractionSource r17, Shape r18, TextFieldColors r19, int r20, int r21, int r22, Composer r23, int r24) {
        return TextField$lambda$7(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ Unit c(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, int r17, MutableInteractionSource r18, Shape r19, TextFieldColors r20, int r21, int r22, int r23, Composer r24, int r25) {
        return TextField$lambda$10(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit d(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, MutableInteractionSource r17, Shape r18, TextFieldColors r19, int r20, int r21, int r22, Composer r23, int r24) {
        return TextField$lambda$12(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ Unit e(Modifier r0, Function2 r1, Function2 r2, Function3 r3, Function2 r4, Function2 r5, boolean r6, float r7, PaddingValues r8, int r9, Composer r10, int r11) {
        return TextFieldLayout$lambda$19(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit f(float r0, BorderStroke r1, ContentDrawScope r2) {
        return drawIndicatorLine$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ Unit g(TextFieldState r1, Modifier r2, boolean r3, boolean r4, TextStyle r5, Function2 r6, Function2 r7, Function2 r8, Function2 r9, boolean r10, InputTransformation r11, OutputTransformation r12, KeyboardOptions r13, KeyboardActionHandler r14, TextFieldLineLimits r15, ScrollState r16, Shape r17, TextFieldColors r18, MutableInteractionSource r19, int r20, int r21, int r22, Composer r23, int r24) {
        return TextField$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    static {
        FirstBaselineOffset = Dp.constructor-impl(20);
        TextFieldBottomPadding = Dp.constructor-impl(10);
        TextFieldTopPadding = Dp.constructor-impl(2);
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }

    public static final Modifier drawIndicatorLine(Modifier r2, final BorderStroke r3) {
        final float r0 = r3.m368getWidthD9Ej5fM();
        return DrawModifierKt.drawWithContent(r2, new cd(r0, r3));
    }

    private static final Unit drawIndicatorLine$lambda$22(float r16, BorderStroke r17, ContentDrawScope r18) {
        r18.drawContent();
        if (Dp.equals-impl0(r16, Dp.Companion.getHairline-D9Ej5fM()) == true) goto L5;
        float r8 = r16 * r18.getDensity();
        float r0 = Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() & 4294967295L)) - (r8 / 2);
        Brush r1 = r17.getBrush();
        long r4 = Offset.constructor-impl((Float.floatToRawIntBits(androidx.compose.material3.MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r0)) & 4294967295L));
        long r6 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() >> 32)));
        DrawScope.-CC.drawLine-1RTmtNc$default(r18, r1, r4, Offset.constructor-impl((4294967295L & ((long) Float.floatToRawIntBits(r0))) | (r6 << 32)), r8, 0, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 496, null);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final /* synthetic */ int m2228access$calculateWidthVsPV1Ek(int r0, int r1, int r2, int r3, int r4, long r5) {
        return m2230calculateWidthVsPV1Ek(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    private static final int m2230calculateWidthVsPV1Ek(int r0, int r1, int r2, int r3, int r4, long r5) {
        return ConstraintsKt.constrainWidth-K40F9xA(r5, (r0 + Math.max(r2, Math.max(r3, r4))) + r1);
    }

    /* JADX INFO: renamed from: access$calculateHeight-O3s9Psw, reason: not valid java name */
    public static final /* synthetic */ int m2227access$calculateHeightO3s9Psw(int r0, boolean r1, int r2, int r3, int r4, int r5, long r6, float r8, PaddingValues r9) {
        return m2229calculateHeightO3s9Psw(r0, r1, r2, r3, r4, r5, r6, r8, r9);
    }

    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    private static final int m2229calculateHeightO3s9Psw(int r2, boolean r3, int r4, int r5, int r6, int r7, long r8, float r10, PaddingValues r11) {
        float r0 = TextFieldTopPadding * r10;
        float r1 = r11.mo901calculateTopPaddingD9Ej5fM() * r10;
        float r12 = r11.mo898calculateBottomPaddingD9Ej5fM() * r10;
        int r9 = Math.max(r2, r7);
        if (r3 == false) goto L5;
        float r13 = ((r4 + r0) + r9) + r12;
    L7:
        return ConstraintsKt.constrainHeight-K40F9xA(r8, Math.max(MathKt.roundToInt(r13), Math.max(r5, r6)));
    L5:
        r13 = (r1 + r9) + r12;
        goto L7
    }

    public static final /* synthetic */ void access$placeWithoutLabel(Placeable.PlacementScope r0, int r1, int r2, Placeable r3, Placeable r4, Placeable r5, Placeable r6, boolean r7, float r8, PaddingValues r9) {
        placeWithoutLabel(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private static final void placeWithoutLabel(Placeable.PlacementScope r17, int r18, int r19, Placeable r20, Placeable r21, Placeable r22, Placeable r23, boolean r24, float r25, PaddingValues r26) {
        int r1 = MathKt.roundToInt(r26.mo901calculateTopPaddingD9Ej5fM() * r25);
        if (r22 == null) goto L5;
        Placeable.PlacementScope.placeRelative$default(r17, r22, 0, Alignment.Companion.getCenterVertically().align(r22.getHeight(), r19), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        if (r23 == null) goto L7;
        Placeable.PlacementScope.placeRelative$default(r17, r23, r18 - r23.getWidth(), Alignment.Companion.getCenterVertically().align(r23.getHeight(), r19), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L7:
        if (r24 == false) goto L9;
        int r6 = Alignment.Companion.getCenterVertically().align(r20.getHeight(), r19);
    L10:
        Placeable.PlacementScope.placeRelative$default(r17, r20, TextFieldImplKt.widthOrZero(r22), r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        if (r21 == null) goto L16;
        if (r24 == false) goto L14;
        r1 = Alignment.Companion.getCenterVertically().align(r21.getHeight(), r19);
    L14:
        int r12 = TextFieldImplKt.widthOrZero(r22);
        Placeable.PlacementScope.placeRelative$default(r17, r21, r12, r1, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return;
    L16:
        return;
    L9:
        r6 = r1;
        goto L10
    }

    public static final void TextFieldLayout(final Modifier r24, final Function2<? super Composer, ? super Integer, Unit> r25, final Function2<? super Composer, ? super Integer, Unit> r26, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> r27, final Function2<? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, final boolean r30, final float r31, final PaddingValues r32, Composer r33, final int r34) {
        Composer r11 = r33.startRestartGroup(-1595074580);
        if ((r34 & 6) == 0) goto L5;
        int r12 = r34;
    L11:
        if ((r34 & 48) != 0) goto L18;
        if (r11.changedInstance(r25) == false) goto L15;
        int r13 = 32;
    L16:
        r12 = r12 | r13;
        goto L18
    L15:
        r13 = 16;
    L18:
        if ((r34 & 384) != 0) goto L25;
        if (r11.changedInstance(r26) == false) goto L22;
        int r14 = 256;
    L23:
        r12 = r12 | r14;
        goto L25
    L22:
        r14 = 128;
    L25:
        if ((r34 & 3072) != 0) goto L32;
        if (r11.changedInstance(r27) == false) goto L29;
        int r15 = 2048;
    L30:
        r12 = r12 | r15;
        goto L32
    L29:
        r15 = 1024;
    L32:
        if ((r34 & 24576) != 0) goto L39;
        if (r11.changedInstance(r28) == false) goto L36;
        int r16 = 16384;
    L37:
        r12 = r12 | r16;
        goto L39
    L36:
        r16 = 8192;
    L39:
        if ((196608 & r34) != 0) goto L46;
        if (r11.changedInstance(r29) == false) goto L43;
        int r17 = 131072;
    L44:
        r12 = r12 | r17;
        goto L46
    L43:
        r17 = 65536;
    L46:
        if ((1572864 & r34) != 0) goto L53;
        if (r11.changed(r30) == false) goto L50;
        int r18 = 1048576;
    L51:
        r12 = r12 | r18;
        goto L53
    L50:
        r18 = 524288;
    L53:
        if ((12582912 & r34) != 0) goto L60;
        if (r11.changed(r31) == false) goto L57;
        int r19 = 8388608;
    L58:
        r12 = r12 | r19;
        goto L60
    L57:
        r19 = 4194304;
    L60:
        if ((100663296 & r34) != 0) goto L67;
        if (r11.changed(r32) == false) goto L64;
        int r110 = 67108864;
    L65:
        r12 = r12 | r110;
        goto L67
    L64:
        r110 = 33554432;
    L67:
        if ((38347923 & r12) == 38347922) goto L69;
        boolean r111 = true;
    L71:
        if (r11.shouldExecute(r111, r12 & 1) == true) goto L73;
        r11.skipToGroupEnd();
    L177:
        ScopeUpdateScope r112 = r11.endRestartGroup();
        if (r112 == null) goto L181;
        r112.updateScope(new ad(r24, r25, r26, r27, r28, r29, r30, r31, r32, r34));
        return;
    L181:
        return;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(-1595074580, r12, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:650)");
    L76:
        if ((3670016 & r12) != 1048576) goto L78;
        boolean r0 = true;
    L80:
        if ((29360128 & r12) != 8388608) goto L82;
        boolean r113 = true;
    L83:
        boolean r1 = r0 | r113;
        if ((234881024 & r12) != 67108864) goto L86;
        boolean r114 = true;
    L87:
        boolean r2 = r1 | r114;
        Object r115 = r11.rememberedValue();
        if (r2 == false) goto L90;
    L91:
        r115 = new TextFieldMeasurePolicy(r30, r31, r32);
        r11.updateRememberedValue(r115);
    L92:
        TextFieldMeasurePolicy r116 = (TextFieldMeasurePolicy) r115;
        LayoutDirection r3 = (LayoutDirection) r11.consume(CompositionLocalsKt.getLocalLayoutDirection());
        int r117 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r118 = r11.getCurrentCompositionLocalMap();
        Modifier r7 = ComposedModifierKt.materializeModifier(r11, r24);
        ComposeUiNode.Companion r119 = ComposeUiNode.Companion;
        Function0 r4 = r119.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L95;
        ComposablesKt.invalidApplier();
    L95:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L98;
        r11.createNode(r4);
    L99:
        Composer r5 = Updater.constructor-impl(r11);
        Updater.set-impl(r5, r116, r119.getSetMeasurePolicy());
        Updater.set-impl(r5, r118, r119.getSetResolvedCompositionLocals());
        Function2 r8 = r119.getSetCompositeKeyHash();
        if (r5.getInserting() == false) goto L102;
    L103:
        r5.updateRememberedValue(Integer.valueOf(r117));
        r5.apply(Integer.valueOf(r117), r8);
    L104:
        Updater.set-impl(r5, r7, r119.getSetModifier());
        if (r28 == null) goto L119;
        r11.startReplaceGroup(-1444611617);
        Modifier r6 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId));
        MeasurePolicy r9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r120 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r10 = r11.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r11, r6);
        Function0 r121 = r119.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L109;
        ComposablesKt.invalidApplier();
    L109:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L112;
        r11.createNode(r121);
    L113:
        Composer r122 = Updater.constructor-impl(r11);
        Updater.set-impl(r122, r9, r119.getSetMeasurePolicy());
        Updater.set-impl(r122, r10, r119.getSetResolvedCompositionLocals());
        Function2 r21 = r119.getSetCompositeKeyHash();
        if (r122.getInserting() == false) goto L116;
    L117:
        r122.updateRememberedValue(Integer.valueOf(r120));
        r122.apply(Integer.valueOf(r120), r21);
    L118:
        Updater.set-impl(r122, r20, r119.getSetModifier());
        BoxScopeInstance r22 = BoxScopeInstance.INSTANCE;
        r28.invoke(r11, Integer.valueOf((r12 >> 12) & 14));
        r11.endNode();
        r11.endReplaceGroup();
    L120:
        if (r29 == null) goto L134;
        r11.startReplaceGroup(-1444322883);
        Modifier r23 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId));
        MeasurePolicy r35 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r123 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r36 = r11.getCurrentCompositionLocalMap();
        Modifier r37 = ComposedModifierKt.materializeModifier(r11, r23);
        Function0 r124 = r119.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L124;
        ComposablesKt.invalidApplier();
    L124:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L127;
        r11.createNode(r124);
    L128:
        Composer r125 = Updater.constructor-impl(r11);
        Updater.set-impl(r125, r35, r119.getSetMeasurePolicy());
        Updater.set-impl(r125, r36, r119.getSetResolvedCompositionLocals());
        Function2 r38 = r119.getSetCompositeKeyHash();
        if (r125.getInserting() == false) goto L131;
    L132:
        r125.updateRememberedValue(Integer.valueOf(r123));
        r125.apply(Integer.valueOf(r123), r38);
    L133:
        Updater.set-impl(r125, r37, r119.getSetModifier());
        BoxScopeInstance r39 = BoxScopeInstance.INSTANCE;
        r29.invoke(r11, Integer.valueOf((r12 >> 15) & 14));
        r11.endNode();
        r11.endReplaceGroup();
    L135:
        float r40 = PaddingKt.calculateStartPadding(r32, r3);
        float r41 = PaddingKt.calculateEndPadding(r32, r3);
        Modifier.Companion r42 = Modifier.Companion;
        if (r28 == null) goto L138;
        int r43 = 0;
        r40 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(r40 - TextFieldImplKt.getHorizontalIconPadding()), Dp.constructor-impl(0)));
    L139:
        float r126 = r40;
        if (r29 == null) goto L142;
        r41 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(r41 - TextFieldImplKt.getHorizontalIconPadding()), Dp.constructor-impl(r43)));
    L142:
        Modifier r44 = PaddingKt.m964paddingqDBjuR0$default(r42, r126, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r41, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null);
        if (r27 == null) goto L145;
        r11.startReplaceGroup(-1443222972);
        r27.invoke(LayoutIdKt.layoutId(r42, TextFieldImplKt.PlaceholderId).then(r44), r11, Integer.valueOf((r12 >> 6) & 112));
        r11.endReplaceGroup();
    L146:
        if (r26 == null) goto L160;
        r11.startReplaceGroup(-1443101018);
        Modifier r45 = LayoutIdKt.layoutId(r42, TextFieldImplKt.LabelId).then(r44);
        MeasurePolicy r46 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r127 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r128 = r11.getCurrentCompositionLocalMap();
        Modifier r47 = ComposedModifierKt.materializeModifier(r11, r45);
        Function0 r129 = r119.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L150;
        ComposablesKt.invalidApplier();
    L150:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L153;
        r11.createNode(r129);
    L154:
        Composer r48 = Updater.constructor-impl(r11);
        Updater.set-impl(r48, r46, r119.getSetMeasurePolicy());
        Updater.set-impl(r48, r128, r119.getSetResolvedCompositionLocals());
        Function2 r49 = r119.getSetCompositeKeyHash();
        if (r48.getInserting() == false) goto L157;
    L158:
        r48.updateRememberedValue(Integer.valueOf(r127));
        r48.apply(Integer.valueOf(r127), r49);
    L159:
        Updater.set-impl(r48, r47, r119.getSetModifier());
        BoxScopeInstance r50 = BoxScopeInstance.INSTANCE;
        r26.invoke(r11, Integer.valueOf((r12 >> 6) & 14));
        r11.endNode();
        r11.endReplaceGroup();
    L161:
        Modifier r51 = LayoutIdKt.layoutId(r42, TextFieldImplKt.TextFieldId).then(r44);
        MeasurePolicy r52 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
        int r53 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r54 = r11.getCurrentCompositionLocalMap();
        Modifier r55 = ComposedModifierKt.materializeModifier(r11, r51);
        Function0 r56 = r119.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L164;
        ComposablesKt.invalidApplier();
    L164:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L167;
        r11.createNode(r56);
    L168:
        Composer r57 = Updater.constructor-impl(r11);
        Updater.set-impl(r57, r52, r119.getSetMeasurePolicy());
        Updater.set-impl(r57, r54, r119.getSetResolvedCompositionLocals());
        Function2 r58 = r119.getSetCompositeKeyHash();
        if (r57.getInserting() == false) goto L171;
    L172:
        r57.updateRememberedValue(Integer.valueOf(r53));
        r57.apply(Integer.valueOf(r53), r58);
    L173:
        Updater.set-impl(r57, r55, r119.getSetModifier());
        BoxScopeInstance r59 = BoxScopeInstance.INSTANCE;
        r25.invoke(r11, Integer.valueOf((r12 >> 3) & 14));
        r11.endNode();
        r11.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L177;
        ComposerKt.traceEventEnd();
        goto L177
    L171:
        if (Intrinsics.areEqual(r57.rememberedValue(), Integer.valueOf(r53)) == true) goto L173;
    L167:
        r11.useNode();
        goto L168
    L157:
        if (Intrinsics.areEqual(r48.rememberedValue(), Integer.valueOf(r127)) == true) goto L159;
    L153:
        r11.useNode();
        goto L154
    L160:
        r11.startReplaceGroup(-1443015489);
        r11.endReplaceGroup();
        goto L161
    L145:
        r11.startReplaceGroup(-1443135521);
        r11.endReplaceGroup();
        goto L146
    L138:
        r43 = 0;
        goto L139
    L131:
        if (Intrinsics.areEqual(r125.rememberedValue(), Integer.valueOf(r123)) == true) goto L133;
    L127:
        r11.useNode();
        goto L128
    L134:
        r11.startReplaceGroup(-1444074945);
        r11.endReplaceGroup();
        goto L135
    L116:
        if (Intrinsics.areEqual(r122.rememberedValue(), Integer.valueOf(r120)) == true) goto L118;
    L112:
        r11.useNode();
        goto L113
    L119:
        r11.startReplaceGroup(-1444365601);
        r11.endReplaceGroup();
        goto L120
    L102:
        if (Intrinsics.areEqual(r5.rememberedValue(), Integer.valueOf(r117)) == true) goto L104;
    L98:
        r11.useNode();
        goto L99
    L90:
        if (r115 != Composer.Companion.getEmpty()) goto L92;
    L86:
        r114 = false;
        goto L87
    L82:
        r113 = false;
        goto L83
    L78:
        r0 = false;
        goto L80
    L69:
        r111 = false;
        goto L71
    L5:
        if (r11.changed(r24) == false) goto L7;
        int r130 = 4;
    L8:
        r12 = r130 | r34;
        goto L11
    L7:
        r130 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$placeWithLabel(Placeable.PlacementScope r0, int r1, int r2, Placeable r3, Placeable r4, Placeable r5, Placeable r6, Placeable r7, boolean r8, int r9, int r10, float r11, float r12) {
        placeWithLabel(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    private static final void placeWithLabel(Placeable.PlacementScope r15, int r16, int r17, Placeable r18, Placeable r19, Placeable r20, Placeable r21, Placeable r22, boolean r23, int r24, int r25, float r26, float r27) {
        if (r21 == null) goto L5;
        Placeable.PlacementScope.placeRelative$default(r15, r21, 0, Alignment.Companion.getCenterVertically().align(r21.getHeight(), r17), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        if (r22 == null) goto L7;
        Placeable.PlacementScope.placeRelative$default(r15, r22, r16 - r22.getWidth(), Alignment.Companion.getCenterVertically().align(r22.getHeight(), r17), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L7:
        if (r19 == null) goto L12;
        if (r23 == false) goto L10;
        int r0 = Alignment.Companion.getCenterVertically().align(r19.getHeight(), r17);
    L11:
        Placeable.PlacementScope.placeRelative$default(r15, r19, TextFieldImplKt.widthOrZero(r21), r0 - MathKt.roundToInt((r0 - r24) * r26), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        goto L12
    L10:
        r0 = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * r27);
    L12:
        Placeable.PlacementScope.placeRelative$default(r15, r18, TextFieldImplKt.widthOrZero(r21), r25, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        if (r20 == null) goto L16;
        Placeable.PlacementScope.placeRelative$default(r15, r20, TextFieldImplKt.widthOrZero(r21), r25, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return;
    }

    public static final void TextField(final TextFieldState r71, Modifier r72, boolean r73, boolean r74, TextStyle r75, Function2<? super Composer, ? super Integer, Unit> r76, Function2<? super Composer, ? super Integer, Unit> r77, Function2<? super Composer, ? super Integer, Unit> r78, Function2<? super Composer, ? super Integer, Unit> r79, boolean r80, InputTransformation r81, OutputTransformation r82, KeyboardOptions r83, KeyboardActionHandler r84, TextFieldLineLimits r85, ScrollState r86, Shape r87, TextFieldColors r88, MutableInteractionSource r89, Composer r90, final int r91, final int r92, final int r93) {
        Composer r0 = r90.startRestartGroup(-345138714);
        if ((r93 & 1) == 0) goto L6;
        int r4 = r91 | 6;
    L13:
        int r5 = r93 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r93 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = r93 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r20 = 8192;
        if ((r91 & 24576) != 0) goto L57;
        if ((r93 & 16) != 0) goto L54;
        if (r0.changed(r75) == false) goto L54;
        int r22 = 16384;
    L55:
        r4 = r4 | r22;
    L54:
        r22 = 8192;
    L57:
        int r23 = r93 & 32;
        if (r23 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r27 = r93 & 64;
        if (r27 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r10 = r93 & 128;
        if (r10 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r93 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r93 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r93 & 1024;
        if (r3 == 0) goto L111;
        int r19 = r92 | 6;
    L118:
        int r6 = r93 & 2048;
        if (r6 == 0) goto L122;
        r19 = r19 | 48;
    L128:
        int r7 = r19;
        int r8 = r93 & 4096;
        if (r8 == 0) goto L132;
        r7 = r7 | 384;
    L139:
        int r11 = r93 & 8192;
        if (r11 == 0) goto L143;
        r7 = r7 | 3072;
    L151:
        if ((r92 & 24576) != 0) goto L161;
        if ((r93 & 16384) != 0) goto L158;
        if (r0.changed(r85) == false) goto L158;
        r20 = 16384;
    L158:
        r7 = r7 | r20;
    L161:
        if ((r92 & 196608) != 0) goto L171;
        if ((r93 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L165;
    L167:
        int r18 = 65536;
    L168:
        r7 = r7 | r18;
        goto L171
    L165:
        if (r0.changed(r86) == false) goto L167;
        r18 = 131072;
    L171:
        if ((r92 & 1572864) != 0) goto L181;
        if ((r93 & 65536) == 0) goto L175;
    L177:
        int r110 = 524288;
    L178:
        r7 = r7 | r110;
        goto L181
    L175:
        if (r0.changed(r87) == false) goto L177;
        r110 = 1048576;
    L181:
        if ((r92 & 12582912) != 0) goto L190;
        if ((r93 & 131072) == 0) goto L185;
    L187:
        int r111 = 4194304;
    L188:
        r7 = r7 | r111;
        goto L190
    L185:
        if (r0.changed(r88) == false) goto L187;
        r111 = 8388608;
    L190:
        int r64 = r93 & 262144;
        if (r64 == 0) goto L194;
        r7 = r7 | 100663296;
    L201:
        if ((r4 & 306783379) == 306783378) goto L203;
    L206:
        boolean r12 = true;
    L208:
        if (r0.shouldExecute(r12, r4 & 1) == false) goto L311;
        r0.startDefaults();
        if ((r91 & 1) != 0) goto L212;
    L230:
        if (r5 == 0) goto L232;
        Modifier r13 = Modifier.Companion;
    L233:
        if (r9 == 0) goto L235;
        boolean r14 = true;
    L236:
        if (r16 == 0) goto L238;
        boolean r15 = false;
    L240:
        if ((r93 & 16) == 0) goto L242;
        TextStyle r112 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-57345);
    L243:
        if (r23 == 0) goto L245;
        Function2<? super Composer, ? super Integer, Unit> r66 = null;
    L246:
        if (r27 == 0) goto L248;
        Function2<? super Composer, ? super Integer, Unit> r67 = null;
    L249:
        if (r10 == 0) goto L251;
        Function2<? super Composer, ? super Integer, Unit> r113 = null;
    L252:
        if (r1 == 0) goto L254;
        Function2<? super Composer, ? super Integer, Unit> r21 = null;
    L255:
        if (r2 == 0) goto L257;
        boolean r24 = false;
    L258:
        if (r3 == 0) goto L260;
        InputTransformation r25 = null;
    L261:
        if (r6 == 0) goto L263;
        OutputTransformation r26 = null;
    L264:
        if (r8 == 0) goto L266;
        KeyboardOptions r28 = KeyboardOptions.Companion.getDefault();
    L267:
        if (r11 == 0) goto L269;
        KeyboardActionHandler r68 = null;
    L271:
        if ((r93 & 16384) == 0) goto L273;
        TextFieldLineLimits r114 = TextFieldLineLimits.Companion.getDefault();
        r7 = r7 & (-57345);
    L274:
        Function2<? super Composer, ? super Integer, Unit> r710 = r21;
        boolean r711 = r24;
        if ((r93 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L277;
        int r115 = r7 & (-458753);
        ScrollState r29 = ScrollKt.rememberScrollState(0, r0, 0, 1);
    L279:
        if ((r93 & 65536) == 0) goto L281;
        Shape r30 = TextFieldDefaults.INSTANCE.getTextFieldShape(r0, 6);
        r115 = r115 & (-3670017);
    L282:
        int r31 = r115;
        if ((r93 & 131072) == 0) goto L285;
        TextFieldColors r116 = TextFieldDefaults.INSTANCE.m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        r31 = r31 & (-29360129);
    L286:
        if (r64 == 0) goto L288;
        MutableInteractionSource r210 = null;
    L289:
        Shape r32 = r30;
        r7 = r31;
        Function2<? super Composer, ? super Integer, Unit> r33 = r710;
        boolean r34 = r711;
    L290:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L294;
        ComposerKt.traceEventStart(-345138714, r4, r7, "androidx.compose.material.TextField (TextField.kt:197)");
    L294:
        if (r210 != null) goto L299;
        r0.startReplaceGroup(125309749);
        Object r35 = r0.rememberedValue();
        if (r35 != Composer.Companion.getEmpty()) goto L298;
        r35 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r35);
    L298:
        MutableInteractionSource r36 = (MutableInteractionSource) r35;
        r0.endReplaceGroup();
    L300:
        r0.startReplaceGroup(-965783980);
        long r117 = r112.getColor-0d7_KjU();
        if (r117 == 16) goto L303;
        boolean r65 = true;
    L304:
        if (r65 == true) goto L307;
        r117 = ((Color) r116.textColor(r14, r0, ((r4 >> 6) & 14) | ((r7 >> 18) & 112)).getValue()).unbox-impl();
    L307:
        r0.endReplaceGroup();
        TextStyle r37 = r112.merge(new TextStyle(r117, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        TextFieldDefaults r38 = TextFieldDefaults.INSTANCE;
        MutableInteractionSource r810 = r36;
        Modifier r39 = r13;
        TextStyle r310 = r112;
        boolean r311 = r15;
        int r40 = ((r4 & 14) | (r4 & 896)) | (r4 & 7168);
        int r41 = r7 << 12;
        boolean r712 = r14;
        InputTransformation r713 = r25;
        KeyboardOptions r714 = r28;
        KeyboardActionHandler r715 = r68;
        TextFieldLineLimits r811 = r114;
        OutputTransformation r812 = r26;
        ScrollState r813 = r29;
        BasicTextFieldKt.BasicTextField(r71, SizeKt.m998defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m2207indicatorLinegv0btCI$default(r38, r13, r14, r34, r810, r116, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 48, null), r34, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6)), r38.m2214getMinWidthD9Ej5fM(), r38.m2213getMinHeightD9Ej5fM()), r712, r311, r713, r37, r714, r715, r811, null, r810, new SolidColor(((Color) r116.cursorColor(r34, r0, ((r4 >> 27) & 14) | ((r7 >> 18) & 112)).getValue()).unbox-impl(), null), r812, new AnonymousClass1(r26, r71, r114, r14, r36, r34, r66, r67, r113, r33, r32, r116), r813, r0, (((r40 | (57344 & r41)) | (3670016 & r41)) | (29360128 & r41)) | (r41 & 234881024), ((r7 << 3) & 896) | ((r7 >> 3) & 57344), 512);
        if (ComposerKt.isTraceInProgress() == false) goto L310;
        ComposerKt.traceEventEnd();
    L310:
        final Shape r118 = r32;
        final OutputTransformation r119 = r26;
        final boolean r42 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r113;
        final TextFieldColors r120 = r116;
        final TextFieldLineLimits r121 = r114;
        final MutableInteractionSource r122 = r210;
        final ScrollState r123 = r29;
        final KeyboardOptions r124 = r28;
        final InputTransformation r125 = r25;
        final TextStyle r44 = r310;
        final boolean r45 = r311;
        final Function2<? super Composer, ? super Integer, Unit> r46 = r66;
        final Function2<? super Composer, ? super Integer, Unit> r47 = r67;
        final KeyboardActionHandler r126 = r68;
        final Function2<? super Composer, ? super Integer, Unit> r48 = r33;
        final boolean r127 = r34;
        final Modifier r49 = r39;
    L312:
        ScopeUpdateScope r50 = r0.endRestartGroup();
        if (r50 == null) goto L316;
        r50.updateScope(new ed(r71, r49, r42, r45, r44, r46, r47, r43, r48, r127, r125, r119, r124, r126, r121, r123, r118, r120, r122, r91, r92, r93));
        return;
    L316:
        return;
    L303:
        r65 = false;
        goto L304
    L299:
        r0.startReplaceGroup(-965789726);
        r0.endReplaceGroup();
        r36 = r210;
        goto L300
    L288:
        r210 = r89;
        goto L289
    L285:
        r116 = r88;
        goto L286
    L281:
        r30 = r87;
        goto L282
    L277:
        r115 = r7;
        r29 = r86;
        goto L279
    L273:
        r114 = r85;
        goto L274
    L269:
        r68 = r84;
        goto L271
    L266:
        r28 = r83;
        goto L267
    L263:
        r26 = r82;
        goto L264
    L260:
        r25 = r81;
        goto L261
    L257:
        r24 = r80;
        goto L258
    L254:
        r21 = r79;
        goto L255
    L251:
        r113 = r78;
        goto L252
    L248:
        r67 = r77;
        goto L249
    L245:
        r66 = r76;
        goto L246
    L242:
        r112 = r75;
        goto L243
    L238:
        r15 = r74;
        goto L240
    L235:
        r14 = r73;
        goto L236
    L232:
        r13 = r72;
        goto L233
    L212:
        if (r0.getDefaultsInvalid() == true) goto L230;
        r0.skipToGroupEnd();
        if ((r93 & 16) == 0) goto L218;
        r4 = r4 & (-57345);
    L218:
        if ((r93 & 16384) == 0) goto L221;
        r7 = r7 & (-57345);
    L221:
        if ((32768 & r93) == 0) goto L224;
        r7 = r7 & (-458753);
    L224:
        if ((r93 & 65536) == 0) goto L227;
        r7 = r7 & (-3670017);
    L227:
        if ((r93 & 131072) == 0) goto L229;
        r7 = r7 & (-29360129);
    L229:
        r13 = r72;
        r14 = r73;
        r15 = r74;
        r112 = r75;
        r66 = r76;
        r67 = r77;
        r113 = r78;
        r33 = r79;
        r34 = r80;
        r25 = r81;
        r26 = r82;
        r28 = r83;
        r68 = r84;
        r114 = r85;
        r29 = r86;
        r116 = r88;
        r210 = r89;
        r4 = r4;
        r32 = r87;
        goto L290
    L311:
        r0.skipToGroupEnd();
        r49 = r72;
        r42 = r73;
        r45 = r74;
        r44 = r75;
        r46 = r76;
        r47 = r77;
        r43 = r78;
        r48 = r79;
        r127 = r80;
        r125 = r81;
        r119 = r82;
        r124 = r83;
        r126 = r84;
        r121 = r85;
        r123 = r86;
        r118 = r87;
        r120 = r88;
        r122 = r89;
        goto L312
    L203:
        if ((38347923 & r7) != 38347922) goto L206;
        r12 = false;
        goto L208
    L194:
        if ((r92 & 100663296) != 0) goto L201;
        if (r0.changed(r89) == false) goto L198;
        int r128 = 67108864;
    L199:
        r7 = r7 | r128;
        goto L201
    L198:
        r128 = 33554432;
        goto L199
    L143:
        if ((r92 & 3072) != 0) goto L151;
        if (r0.changed(r84) == true) goto L148;
        r17 = 1024;
    L148:
        r7 = r7 | r17;
        goto L151
    L132:
        if ((r92 & 384) != 0) goto L139;
        if (r0.changed(r83) == false) goto L136;
        int r211 = 256;
    L137:
        r7 = r7 | r211;
        goto L139
    L136:
        r211 = 128;
        goto L137
    L122:
        if ((r92 & 48) != 0) goto L128;
        if (r0.changed(r82) == false) goto L126;
        int r212 = 32;
    L127:
        r19 = r19 | r212;
        goto L128
    L126:
        r212 = 16;
        goto L127
    L111:
        if ((r92 & 6) == 0) goto L113;
        r19 = r92;
        goto L118
    L113:
        if (r0.changed(r81) == false) goto L115;
        int r129 = 4;
    L116:
        r19 = r92 | r129;
        goto L118
    L115:
        r129 = 2;
        goto L116
    L101:
        if ((r91 & 805306368) != 0) goto L107;
        if (r0.changed(r80) == false) goto L105;
        int r312 = 536870912;
    L106:
        r4 = r4 | r312;
        goto L107
    L105:
        r312 = 268435456;
        goto L106
    L91:
        if ((r91 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r79) == false) goto L95;
        int r313 = 67108864;
    L96:
        r4 = r4 | r313;
        goto L97
    L95:
        r313 = 33554432;
        goto L96
    L81:
        if ((r91 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r78) == false) goto L85;
        int r314 = 8388608;
    L86:
        r4 = r4 | r314;
        goto L87
    L85:
        r314 = 4194304;
        goto L86
    L71:
        if ((r91 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r77) == false) goto L75;
        int r213 = 1048576;
    L76:
        r4 = r4 | r213;
        goto L77
    L75:
        r213 = 524288;
        goto L76
    L61:
        if ((r91 & 196608) != 0) goto L67;
        if (r0.changedInstance(r76) == false) goto L65;
        int r214 = 131072;
    L66:
        r4 = r4 | r214;
        goto L67
    L65:
        r214 = 65536;
        goto L66
    L39:
        if ((r91 & 3072) != 0) goto L46;
        if (r0.changed(r74) == false) goto L43;
        int r130 = 2048;
    L44:
        r4 = r4 | r130;
        goto L46
    L43:
        r130 = 1024;
        goto L44
    L28:
        if ((r91 & 384) != 0) goto L35;
        if (r0.changed(r73) == false) goto L32;
        int r131 = 256;
    L33:
        r4 = r4 | r131;
        goto L35
    L32:
        r131 = 128;
        goto L33
    L17:
        if ((r91 & 48) != 0) goto L24;
        if (r0.changed(r72) == false) goto L21;
        int r51 = 32;
    L22:
        r4 = r4 | r51;
        goto L24
    L21:
        r51 = 16;
        goto L22
    L6:
        if ((r91 & 6) == 0) goto L8;
        r4 = r91;
        goto L13
    L8:
        if (r0.changed(r71) == false) goto L10;
        int r52 = 4;
    L11:
        r4 = r52 | r91;
        goto L13
    L10:
        r52 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void TextField(final String r70, final Function1 r71, Modifier r72, boolean r73, boolean r74, TextStyle r75, Function2 r76, Function2 r77, Function2 r78, Function2 r79, boolean r80, VisualTransformation r81, KeyboardOptions r82, KeyboardActions r83, boolean r84, int r85, MutableInteractionSource r86, Shape r87, TextFieldColors r88, Composer r89, final int r90, final int r91, final int r92) {
        Composer r0 = r89.startRestartGroup(378210749);
        if ((r92 & 1) == 0) goto L6;
        int r4 = r90 | 6;
    L14:
        if ((r92 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r92 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r12 = r92 & 8;
        int r16 = 2048;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r18 = r92 & 16;
        int r19 = 16384;
        if (r18 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r90 & 196608) != 0) goto L67;
        if ((r92 & 32) == 0) goto L62;
    L64:
        int r26 = 65536;
    L65:
        r4 = r4 | r26;
        goto L67
    L62:
        if (r0.changed(r75) == false) goto L64;
        r26 = 131072;
    L67:
        int r27 = r92 & 64;
        if (r27 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r92 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r92 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r92 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r92 & 1024;
        if (r3 == 0) goto L111;
        int r21 = r91 | 6;
    L118:
        int r5 = r92 & 2048;
        if (r5 == 0) goto L122;
        r21 = r21 | 48;
    L128:
        int r6 = r21;
        int r7 = r92 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L140:
        if ((r91 & 3072) != 0) goto L150;
        if ((r92 & 8192) != 0) goto L147;
        if (r0.changed(r83) == false) goto L147;
    L148:
        r6 = r6 | r16;
    L147:
        r16 = 1024;
    L150:
        int r10 = r92 & 16384;
        if (r10 == 0) goto L154;
        r6 = r6 | 24576;
    L161:
        int r17 = r92 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r17 == 0) goto L165;
        r6 = r6 | 196608;
    L171:
        int r110 = r92 & 65536;
        if (r110 == 0) goto L175;
        r6 = r6 | 1572864;
    L182:
        if ((r91 & 12582912) != 0) goto L192;
        if ((r92 & 131072) == 0) goto L186;
    L188:
        int r111 = 4194304;
    L189:
        r6 = r6 | r111;
        goto L192
    L186:
        if (r0.changed(r87) == false) goto L188;
        r111 = 8388608;
    L192:
        if ((r91 & 100663296) != 0) goto L202;
        if ((r92 & 262144) == 0) goto L196;
    L198:
        int r112 = 33554432;
    L199:
        r6 = r6 | r112;
        goto L202
    L196:
        if (r0.changed(r88) == false) goto L198;
        r112 = 67108864;
    L202:
        if ((r4 & 306783379) == 306783378) goto L204;
    L207:
        boolean r11 = true;
    L209:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L297;
        r0.startDefaults();
        if ((r90 & 1) != 0) goto L213;
    L228:
        if (r8 == 0) goto L230;
        Modifier r13 = Modifier.Companion;
    L231:
        if (r12 == 0) goto L233;
        boolean r14 = true;
    L234:
        if (r18 == 0) goto L236;
        boolean r15 = false;
    L238:
        if ((r92 & 32) == 0) goto L240;
        TextStyle r113 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L242:
        if (r27 == 0) goto L244;
        Function2 r65 = null;
    L245:
        if (r9 == 0) goto L247;
        Function2 r20 = null;
    L248:
        if (r1 == 0) goto L250;
        Function2 r22 = null;
    L251:
        if (r2 == 0) goto L253;
        Function2 r23 = null;
    L254:
        if (r3 == 0) goto L256;
        boolean r24 = false;
    L257:
        if (r5 == 0) goto L259;
        VisualTransformation r25 = VisualTransformation.Companion.getNone();
    L260:
        if (r7 == 0) goto L262;
        KeyboardOptions r28 = KeyboardOptions.Companion.getDefault();
    L263:
        Function2 r710 = r22;
        if ((r92 & 8192) == 0) goto L266;
        KeyboardActions r29 = new KeyboardActions(null, null, null, null, null, null, 63, null);
        r6 = r6 & (-7169);
    L267:
        if (r10 == 0) goto L269;
        boolean r114 = false;
    L270:
        if (r17 == 0) goto L272;
        int r66 = Integer.MAX_VALUE;
    L273:
        KeyboardActions r711 = r29;
        if (r110 == 0) goto L279;
        Object r30 = r0.rememberedValue();
        if (r30 != Composer.Companion.getEmpty()) goto L278;
        r30 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r30);
    L278:
        MutableInteractionSource r31 = (MutableInteractionSource) r30;
    L281:
        if ((r92 & 131072) == 0) goto L283;
        Shape r32 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(r0, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        r6 = (-29360129) & r6;
    L285:
        if ((262144 & r92) == 0) goto L287;
        TextFieldColors r41 = TextFieldDefaults.INSTANCE.m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        int r115 = r6 & (-234881025);
    L288:
        MutableInteractionSource r33 = r31;
    L289:
        r0.endDefaults();
        Composer r810 = r0;
        if (ComposerKt.isTraceInProgress() == false) goto L293;
        ComposerKt.traceEventStart(378210749, r4, r115, "androidx.compose.material.TextField (TextField.kt:421)");
    L293:
        int r34 = r115 << 3;
        Modifier r116 = r13;
        boolean r117 = r14;
        boolean r210 = r15;
        TextStyle r211 = r113;
        Function2 r212 = r65;
        Function2 r213 = r20;
        Function2 r214 = r710;
        Function2 r215 = r23;
        boolean r216 = r24;
        VisualTransformation r217 = r25;
        KeyboardOptions r218 = r28;
        KeyboardActions r219 = r711;
        boolean r35 = r114;
        int r36 = r66;
        MutableInteractionSource r37 = r33;
        Shape r38 = r32;
        TextFieldColors r39 = r41;
        TextField(r70, r71, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r35, r36, 1, r37, r38, r39, r810, (((((((((r4 & 14) | (r4 & 112)) | (r4 & 896)) | (r4 & 7168)) | (57344 & r4)) | (458752 & r4)) | (3670016 & r4)) | (29360128 & r4)) | (234881024 & r4)) | (1879048192 & r4), (((((((((r115 & 14) | 1572864) | (r115 & 112)) | (r115 & 896)) | (r115 & 7168)) | (57344 & r115)) | (458752 & r115)) | (29360128 & r34)) | (234881024 & r34)) | (r34 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L296;
        ComposerKt.traceEventEnd();
    L296:
        final MutableInteractionSource r118 = r33;
        final KeyboardOptions r119 = r28;
        final boolean r120 = r114;
        final TextStyle r40 = r113;
        final Shape r121 = r32;
        final TextFieldColors r122 = r41;
        final Function2 r42 = r65;
        final int r123 = r66;
        final Function2 r124 = r23;
        final KeyboardActions r125 = r711;
        final boolean r43 = r14;
        final boolean r126 = r24;
        final Modifier r44 = r13;
        final Function2 r45 = r20;
        final Function2 r46 = r710;
        boolean r69 = r15;
        final VisualTransformation r127 = r25;
        final boolean r47 = r69;
    L298:
        ScopeUpdateScope r48 = r810.endRestartGroup();
        if (r48 == null) goto L302;
        r48.updateScope(new fd(r70, r71, r44, r43, r47, r40, r42, r45, r46, r124, r126, r127, r119, r125, r120, r123, r118, r121, r122, r90, r91, r92));
        return;
    L302:
        return;
    L287:
        r41 = r88;
        r115 = r6;
        goto L288
    L283:
        r32 = r87;
        goto L285
    L279:
        r31 = r86;
        goto L281
    L272:
        r66 = r85;
        goto L273
    L269:
        r114 = r84;
        goto L270
    L266:
        r29 = r83;
        goto L267
    L262:
        r28 = r82;
        goto L263
    L259:
        r25 = r81;
        goto L260
    L256:
        r24 = r80;
        goto L257
    L253:
        r23 = r79;
        goto L254
    L250:
        r22 = r78;
        goto L251
    L247:
        r20 = r77;
        goto L248
    L244:
        r65 = r76;
        goto L245
    L240:
        r113 = r75;
        goto L242
    L236:
        r15 = r74;
        goto L238
    L233:
        r14 = r73;
        goto L234
    L230:
        r13 = r72;
        goto L231
    L213:
        if (r0.getDefaultsInvalid() == true) goto L228;
        r0.skipToGroupEnd();
        if ((r92 & 32) == 0) goto L219;
        r4 = r4 & (-458753);
    L219:
        if ((r92 & 8192) == 0) goto L222;
        r6 = r6 & (-7169);
    L222:
        if ((r92 & 131072) == 0) goto L225;
        r6 = r6 & (-29360129);
    L225:
        if ((262144 & r92) == 0) goto L227;
        r6 = r6 & (-234881025);
    L227:
        r13 = r72;
        r14 = r73;
        r15 = r74;
        r113 = r75;
        r65 = r76;
        r20 = r77;
        r710 = r78;
        r23 = r79;
        r24 = r80;
        r25 = r81;
        r28 = r82;
        r114 = r84;
        r66 = r85;
        r32 = r87;
        r41 = r88;
        r4 = r4;
        r115 = r6;
        r711 = r83;
        r33 = r86;
        goto L289
    L297:
        r810 = r0;
        r810.skipToGroupEnd();
        r44 = r72;
        r43 = r73;
        r47 = r74;
        r40 = r75;
        r42 = r76;
        r45 = r77;
        r46 = r78;
        r124 = r79;
        r126 = r80;
        r127 = r81;
        r119 = r82;
        r125 = r83;
        r120 = r84;
        r123 = r85;
        r118 = r86;
        r121 = r87;
        r122 = r88;
        goto L298
    L204:
        if ((38347923 & r6) != 38347922) goto L207;
        r11 = false;
        goto L209
    L175:
        if ((r91 & 1572864) != 0) goto L182;
        if (r0.changed(r86) == false) goto L179;
        int r128 = 1048576;
    L180:
        r6 = r6 | r128;
        goto L182
    L179:
        r128 = 524288;
        goto L180
    L165:
        if ((r91 & 196608) != 0) goto L171;
        if (r0.changed(r85) == false) goto L169;
        int r129 = 131072;
    L170:
        r6 = r6 | r129;
        goto L171
    L169:
        r129 = 65536;
        goto L170
    L154:
        if ((r91 & 24576) != 0) goto L161;
        if (r0.changed(r84) == true) goto L159;
        r19 = 8192;
    L159:
        r6 = r6 | r19;
        goto L161
    L132:
        if ((r91 & 384) != 0) goto L140;
        if (r0.changed(r82) == false) goto L136;
        int r220 = 256;
    L137:
        r6 = r6 | r220;
        goto L140
    L136:
        r220 = 128;
        goto L137
    L122:
        if ((r91 & 48) != 0) goto L128;
        if (r0.changed(r81) == false) goto L126;
        int r221 = 32;
    L127:
        r21 = r21 | r221;
        goto L128
    L126:
        r221 = 16;
        goto L127
    L111:
        if ((r91 & 6) == 0) goto L113;
        r21 = r91;
        goto L118
    L113:
        if (r0.changed(r80) == false) goto L115;
        int r222 = 4;
    L116:
        r21 = r91 | r222;
        goto L118
    L115:
        r222 = 2;
        goto L116
    L101:
        if ((r90 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r79) == false) goto L105;
        int r310 = 536870912;
    L106:
        r4 = r4 | r310;
        goto L107
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r90 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r78) == false) goto L95;
        int r311 = 67108864;
    L96:
        r4 = r4 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L81:
        if ((r90 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r77) == false) goto L85;
        int r312 = 8388608;
    L86:
        r4 = r4 | r312;
        goto L87
    L85:
        r312 = 4194304;
        goto L86
    L71:
        if ((r90 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r76) == false) goto L75;
        int r223 = 1048576;
    L76:
        r4 = r4 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L50:
        if ((r90 & 24576) != 0) goto L58;
        if (r0.changed(r74) == false) goto L54;
        int r224 = 16384;
    L55:
        r4 = r4 | r224;
        goto L58
    L54:
        r224 = 8192;
        goto L55
    L39:
        if ((r90 & 3072) != 0) goto L46;
        if (r0.changed(r73) == false) goto L43;
        int r130 = 2048;
    L44:
        r4 = r4 | r130;
        goto L46
    L43:
        r130 = 1024;
        goto L44
    L28:
        if ((r90 & 384) != 0) goto L35;
        if (r0.changed(r72) == false) goto L32;
        int r131 = 256;
    L33:
        r4 = r4 | r131;
        goto L35
    L32:
        r131 = 128;
        goto L33
    L17:
        if ((r90 & 48) != 0) goto L24;
        if (r0.changedInstance(r71) == false) goto L21;
        int r49 = 32;
    L22:
        r4 = r4 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r90 & 6) == 0) goto L8;
        r4 = r90;
        goto L14
    L8:
        if (r0.changed(r70) == false) goto L10;
        int r50 = 4;
    L11:
        r4 = r50 | r90;
        goto L14
    L10:
        r50 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void TextField(final TextFieldValue r70, final Function1 r71, Modifier r72, boolean r73, boolean r74, TextStyle r75, Function2 r76, Function2 r77, Function2 r78, Function2 r79, boolean r80, VisualTransformation r81, KeyboardOptions r82, KeyboardActions r83, boolean r84, int r85, MutableInteractionSource r86, Shape r87, TextFieldColors r88, Composer r89, final int r90, final int r91, final int r92) {
        Composer r0 = r89.startRestartGroup(1181426320);
        if ((r92 & 1) == 0) goto L6;
        int r4 = r90 | 6;
    L14:
        if ((r92 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r92 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r12 = r92 & 8;
        int r16 = 2048;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r18 = r92 & 16;
        int r19 = 16384;
        if (r18 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r90 & 196608) != 0) goto L67;
        if ((r92 & 32) == 0) goto L62;
    L64:
        int r26 = 65536;
    L65:
        r4 = r4 | r26;
        goto L67
    L62:
        if (r0.changed(r75) == false) goto L64;
        r26 = 131072;
    L67:
        int r27 = r92 & 64;
        if (r27 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r92 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r92 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r92 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r92 & 1024;
        if (r3 == 0) goto L111;
        int r21 = r91 | 6;
    L118:
        int r5 = r92 & 2048;
        if (r5 == 0) goto L122;
        r21 = r21 | 48;
    L128:
        int r6 = r21;
        int r7 = r92 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L140:
        if ((r91 & 3072) != 0) goto L150;
        if ((r92 & 8192) != 0) goto L147;
        if (r0.changed(r83) == false) goto L147;
    L148:
        r6 = r6 | r16;
    L147:
        r16 = 1024;
    L150:
        int r10 = r92 & 16384;
        if (r10 == 0) goto L154;
        r6 = r6 | 24576;
    L161:
        int r17 = r92 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r17 == 0) goto L165;
        r6 = r6 | 196608;
    L171:
        int r110 = r92 & 65536;
        if (r110 == 0) goto L175;
        r6 = r6 | 1572864;
    L182:
        if ((r91 & 12582912) != 0) goto L192;
        if ((r92 & 131072) == 0) goto L186;
    L188:
        int r111 = 4194304;
    L189:
        r6 = r6 | r111;
        goto L192
    L186:
        if (r0.changed(r87) == false) goto L188;
        r111 = 8388608;
    L192:
        if ((r91 & 100663296) != 0) goto L202;
        if ((r92 & 262144) == 0) goto L196;
    L198:
        int r112 = 33554432;
    L199:
        r6 = r6 | r112;
        goto L202
    L196:
        if (r0.changed(r88) == false) goto L198;
        r112 = 67108864;
    L202:
        if ((r4 & 306783379) == 306783378) goto L204;
    L207:
        boolean r11 = true;
    L209:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L297;
        r0.startDefaults();
        if ((r90 & 1) != 0) goto L213;
    L228:
        if (r8 == 0) goto L230;
        Modifier r13 = Modifier.Companion;
    L231:
        if (r12 == 0) goto L233;
        boolean r14 = true;
    L234:
        if (r18 == 0) goto L236;
        boolean r15 = false;
    L238:
        if ((r92 & 32) == 0) goto L240;
        TextStyle r113 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L242:
        if (r27 == 0) goto L244;
        Function2 r65 = null;
    L245:
        if (r9 == 0) goto L247;
        Function2 r20 = null;
    L248:
        if (r1 == 0) goto L250;
        Function2 r22 = null;
    L251:
        if (r2 == 0) goto L253;
        Function2 r23 = null;
    L254:
        if (r3 == 0) goto L256;
        boolean r24 = false;
    L257:
        if (r5 == 0) goto L259;
        VisualTransformation r25 = VisualTransformation.Companion.getNone();
    L260:
        if (r7 == 0) goto L262;
        KeyboardOptions r28 = KeyboardOptions.Companion.getDefault();
    L263:
        Function2 r710 = r22;
        if ((r92 & 8192) == 0) goto L266;
        KeyboardActions r29 = new KeyboardActions(null, null, null, null, null, null, 63, null);
        r6 = r6 & (-7169);
    L267:
        if (r10 == 0) goto L269;
        boolean r114 = false;
    L270:
        if (r17 == 0) goto L272;
        int r66 = Integer.MAX_VALUE;
    L273:
        KeyboardActions r711 = r29;
        if (r110 == 0) goto L279;
        Object r30 = r0.rememberedValue();
        if (r30 != Composer.Companion.getEmpty()) goto L278;
        r30 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r30);
    L278:
        MutableInteractionSource r31 = (MutableInteractionSource) r30;
    L281:
        if ((r92 & 131072) == 0) goto L283;
        Shape r32 = TextFieldDefaults.INSTANCE.getTextFieldShape(r0, 6);
        r6 = (-29360129) & r6;
    L285:
        if ((262144 & r92) == 0) goto L287;
        TextFieldColors r41 = TextFieldDefaults.INSTANCE.m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        int r115 = r6 & (-234881025);
    L288:
        MutableInteractionSource r33 = r31;
    L289:
        r0.endDefaults();
        Composer r810 = r0;
        if (ComposerKt.isTraceInProgress() == false) goto L293;
        ComposerKt.traceEventStart(1181426320, r4, r115, "androidx.compose.material.TextField (TextField.kt:610)");
    L293:
        int r34 = r115 << 3;
        Modifier r116 = r13;
        boolean r117 = r14;
        boolean r210 = r15;
        TextStyle r211 = r113;
        Function2 r212 = r65;
        Function2 r213 = r20;
        Function2 r214 = r710;
        Function2 r215 = r23;
        boolean r216 = r24;
        VisualTransformation r217 = r25;
        KeyboardOptions r218 = r28;
        KeyboardActions r219 = r711;
        boolean r35 = r114;
        int r36 = r66;
        MutableInteractionSource r37 = r33;
        Shape r38 = r32;
        TextFieldColors r39 = r41;
        TextField(r70, r71, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r35, r36, 1, r37, r38, r39, r810, (((((((((r4 & 14) | (r4 & 112)) | (r4 & 896)) | (r4 & 7168)) | (57344 & r4)) | (458752 & r4)) | (3670016 & r4)) | (29360128 & r4)) | (234881024 & r4)) | (1879048192 & r4), (((((((((r115 & 14) | 1572864) | (r115 & 112)) | (r115 & 896)) | (r115 & 7168)) | (57344 & r115)) | (458752 & r115)) | (29360128 & r34)) | (234881024 & r34)) | (r34 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L296;
        ComposerKt.traceEventEnd();
    L296:
        final MutableInteractionSource r118 = r33;
        final KeyboardOptions r119 = r28;
        final boolean r120 = r114;
        final TextStyle r40 = r113;
        final Shape r121 = r32;
        final TextFieldColors r122 = r41;
        final Function2 r42 = r65;
        final int r123 = r66;
        final Function2 r124 = r23;
        final KeyboardActions r125 = r711;
        final boolean r43 = r14;
        final boolean r126 = r24;
        final Modifier r44 = r13;
        final Function2 r45 = r20;
        final Function2 r46 = r710;
        boolean r69 = r15;
        final VisualTransformation r127 = r25;
        final boolean r47 = r69;
    L298:
        ScopeUpdateScope r48 = r810.endRestartGroup();
        if (r48 == null) goto L302;
        r48.updateScope(new bd(r70, r71, r44, r43, r47, r40, r42, r45, r46, r124, r126, r127, r119, r125, r120, r123, r118, r121, r122, r90, r91, r92));
        return;
    L302:
        return;
    L287:
        r41 = r88;
        r115 = r6;
        goto L288
    L283:
        r32 = r87;
        goto L285
    L279:
        r31 = r86;
        goto L281
    L272:
        r66 = r85;
        goto L273
    L269:
        r114 = r84;
        goto L270
    L266:
        r29 = r83;
        goto L267
    L262:
        r28 = r82;
        goto L263
    L259:
        r25 = r81;
        goto L260
    L256:
        r24 = r80;
        goto L257
    L253:
        r23 = r79;
        goto L254
    L250:
        r22 = r78;
        goto L251
    L247:
        r20 = r77;
        goto L248
    L244:
        r65 = r76;
        goto L245
    L240:
        r113 = r75;
        goto L242
    L236:
        r15 = r74;
        goto L238
    L233:
        r14 = r73;
        goto L234
    L230:
        r13 = r72;
        goto L231
    L213:
        if (r0.getDefaultsInvalid() == true) goto L228;
        r0.skipToGroupEnd();
        if ((r92 & 32) == 0) goto L219;
        r4 = r4 & (-458753);
    L219:
        if ((r92 & 8192) == 0) goto L222;
        r6 = r6 & (-7169);
    L222:
        if ((r92 & 131072) == 0) goto L225;
        r6 = r6 & (-29360129);
    L225:
        if ((262144 & r92) == 0) goto L227;
        r6 = r6 & (-234881025);
    L227:
        r13 = r72;
        r14 = r73;
        r15 = r74;
        r113 = r75;
        r65 = r76;
        r20 = r77;
        r710 = r78;
        r23 = r79;
        r24 = r80;
        r25 = r81;
        r28 = r82;
        r114 = r84;
        r66 = r85;
        r32 = r87;
        r41 = r88;
        r4 = r4;
        r115 = r6;
        r711 = r83;
        r33 = r86;
        goto L289
    L297:
        r810 = r0;
        r810.skipToGroupEnd();
        r44 = r72;
        r43 = r73;
        r47 = r74;
        r40 = r75;
        r42 = r76;
        r45 = r77;
        r46 = r78;
        r124 = r79;
        r126 = r80;
        r127 = r81;
        r119 = r82;
        r125 = r83;
        r120 = r84;
        r123 = r85;
        r118 = r86;
        r121 = r87;
        r122 = r88;
        goto L298
    L204:
        if ((38347923 & r6) != 38347922) goto L207;
        r11 = false;
        goto L209
    L175:
        if ((r91 & 1572864) != 0) goto L182;
        if (r0.changed(r86) == false) goto L179;
        int r128 = 1048576;
    L180:
        r6 = r6 | r128;
        goto L182
    L179:
        r128 = 524288;
        goto L180
    L165:
        if ((r91 & 196608) != 0) goto L171;
        if (r0.changed(r85) == false) goto L169;
        int r129 = 131072;
    L170:
        r6 = r6 | r129;
        goto L171
    L169:
        r129 = 65536;
        goto L170
    L154:
        if ((r91 & 24576) != 0) goto L161;
        if (r0.changed(r84) == true) goto L159;
        r19 = 8192;
    L159:
        r6 = r6 | r19;
        goto L161
    L132:
        if ((r91 & 384) != 0) goto L140;
        if (r0.changed(r82) == false) goto L136;
        int r220 = 256;
    L137:
        r6 = r6 | r220;
        goto L140
    L136:
        r220 = 128;
        goto L137
    L122:
        if ((r91 & 48) != 0) goto L128;
        if (r0.changed(r81) == false) goto L126;
        int r221 = 32;
    L127:
        r21 = r21 | r221;
        goto L128
    L126:
        r221 = 16;
        goto L127
    L111:
        if ((r91 & 6) == 0) goto L113;
        r21 = r91;
        goto L118
    L113:
        if (r0.changed(r80) == false) goto L115;
        int r222 = 4;
    L116:
        r21 = r91 | r222;
        goto L118
    L115:
        r222 = 2;
        goto L116
    L101:
        if ((r90 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r79) == false) goto L105;
        int r310 = 536870912;
    L106:
        r4 = r4 | r310;
        goto L107
    L105:
        r310 = 268435456;
        goto L106
    L91:
        if ((r90 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r78) == false) goto L95;
        int r311 = 67108864;
    L96:
        r4 = r4 | r311;
        goto L97
    L95:
        r311 = 33554432;
        goto L96
    L81:
        if ((r90 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r77) == false) goto L85;
        int r312 = 8388608;
    L86:
        r4 = r4 | r312;
        goto L87
    L85:
        r312 = 4194304;
        goto L86
    L71:
        if ((r90 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r76) == false) goto L75;
        int r223 = 1048576;
    L76:
        r4 = r4 | r223;
        goto L77
    L75:
        r223 = 524288;
        goto L76
    L50:
        if ((r90 & 24576) != 0) goto L58;
        if (r0.changed(r74) == false) goto L54;
        int r224 = 16384;
    L55:
        r4 = r4 | r224;
        goto L58
    L54:
        r224 = 8192;
        goto L55
    L39:
        if ((r90 & 3072) != 0) goto L46;
        if (r0.changed(r73) == false) goto L43;
        int r130 = 2048;
    L44:
        r4 = r4 | r130;
        goto L46
    L43:
        r130 = 1024;
        goto L44
    L28:
        if ((r90 & 384) != 0) goto L35;
        if (r0.changed(r72) == false) goto L32;
        int r131 = 256;
    L33:
        r4 = r4 | r131;
        goto L35
    L32:
        r131 = 128;
        goto L33
    L17:
        if ((r90 & 48) != 0) goto L24;
        if (r0.changedInstance(r71) == false) goto L21;
        int r49 = 32;
    L22:
        r4 = r4 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r90 & 6) == 0) goto L8;
        r4 = r90;
        goto L14
    L8:
        if (r0.changed(r70) == false) goto L10;
        int r50 = 4;
    L11:
        r4 = r50 | r90;
        goto L14
    L10:
        r50 = 2;
        goto L11
    }

    public static final void TextField(final TextFieldValue r72, final Function1<? super TextFieldValue, Unit> r73, Modifier r74, boolean r75, boolean r76, TextStyle r77, Function2<? super Composer, ? super Integer, Unit> r78, Function2<? super Composer, ? super Integer, Unit> r79, Function2<? super Composer, ? super Integer, Unit> r80, Function2<? super Composer, ? super Integer, Unit> r81, boolean r82, VisualTransformation r83, KeyboardOptions r84, KeyboardActions r85, boolean r86, int r87, int r88, MutableInteractionSource r89, Shape r90, TextFieldColors r91, Composer r92, final int r93, final int r94, final int r95) {
        Composer r0 = r92.startRestartGroup(-1470183117);
        if ((r95 & 1) == 0) goto L6;
        int r4 = r93 | 6;
    L14:
        if ((r95 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r95 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r12 = r95 & 8;
        int r16 = 1024;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r17 = r95 & 16;
        int r18 = 8192;
        if (r17 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r93 & 196608) != 0) goto L67;
        if ((r95 & 32) == 0) goto L62;
    L64:
        int r21 = 65536;
    L65:
        r4 = r4 | r21;
        goto L67
    L62:
        if (r0.changed(r77) == false) goto L64;
        r21 = 131072;
    L67:
        int r22 = r95 & 64;
        if (r22 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r95 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r95 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r95 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r95 & 1024;
        if (r3 == 0) goto L111;
        int r19 = r94 | 6;
    L118:
        int r5 = r95 & 2048;
        if (r5 == 0) goto L122;
        r19 = r19 | 48;
    L128:
        int r6 = r19;
        int r7 = r95 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L140:
        if ((r94 & 3072) != 0) goto L149;
        if ((r95 & 8192) != 0) goto L147;
        if (r0.changed(r85) == false) goto L147;
        r16 = 2048;
    L147:
        r6 = r6 | r16;
    L149:
        int r10 = r95 & 16384;
        if (r10 == 0) goto L153;
        r6 = r6 | 24576;
    L160:
        if ((r94 & 196608) != 0) goto L169;
        if ((r95 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L164;
    L166:
        int r110 = 65536;
    L167:
        r6 = r6 | r110;
        goto L169
    L164:
        if (r0.changed(r87) == false) goto L166;
        r110 = 131072;
    L169:
        int r111 = r95 & 65536;
        if (r111 == 0) goto L173;
        r6 = r6 | 1572864;
    L179:
        int r112 = r95 & 131072;
        if (r112 == 0) goto L183;
        r6 = r6 | 12582912;
    L190:
        if ((r94 & 100663296) != 0) goto L200;
        if ((r95 & 262144) == 0) goto L194;
    L196:
        int r113 = 33554432;
    L197:
        r6 = r6 | r113;
        goto L200
    L194:
        if (r0.changed(r90) == false) goto L196;
        r113 = 67108864;
    L200:
        if ((r94 & 805306368) != 0) goto L209;
        if ((r95 & 524288) == 0) goto L204;
    L206:
        int r114 = 268435456;
    L207:
        r6 = r6 | r114;
        goto L209
    L204:
        if (r0.changed(r91) == false) goto L206;
        r114 = 536870912;
    L209:
        boolean r64 = false;
        if ((r4 & 306783379) == 306783378) goto L212;
    L215:
        boolean r11 = true;
    L217:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L322;
        r0.startDefaults();
        if ((r93 & 1) != 0) goto L221;
    L239:
        if (r8 == 0) goto L241;
        Modifier r13 = Modifier.Companion;
    L242:
        if (r12 == 0) goto L244;
        boolean r14 = true;
    L245:
        if (r17 == 0) goto L247;
        boolean r15 = false;
    L249:
        if ((r95 & 32) == 0) goto L251;
        TextStyle r115 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L252:
        if (r22 == 0) goto L254;
        Function2<? super Composer, ? super Integer, Unit> r65 = null;
    L255:
        if (r9 == 0) goto L257;
        Function2<? super Composer, ? super Integer, Unit> r20 = null;
    L258:
        if (r1 == 0) goto L260;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L261:
        if (r2 == 0) goto L263;
        Function2<? super Composer, ? super Integer, Unit> r24 = null;
    L264:
        if (r3 == 0) goto L266;
        boolean r25 = false;
    L267:
        if (r5 == 0) goto L269;
        VisualTransformation r26 = VisualTransformation.Companion.getNone();
    L270:
        if (r7 == 0) goto L272;
        KeyboardOptions r27 = KeyboardOptions.Companion.getDefault();
    L274:
        if ((r95 & 8192) == 0) goto L276;
        KeyboardActions r116 = new KeyboardActions(null, null, null, null, null, null, 63, null);
        r6 = r6 & (-7169);
    L277:
        if (r10 == 0) goto L279;
        boolean r66 = false;
    L281:
        if ((r95 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L286;
        if (r66 == false) goto L284;
        int r117 = -458753;
        int r118 = 1;
    L285:
        int r119 = r6 & r117;
        r87 = r118;
    L287:
        if (r111 == 0) goto L289;
        int r67 = 1;
    L290:
        if (r112 == 0) goto L292;
        MutableInteractionSource r68 = null;
    L293:
        Function2<? super Composer, ? super Integer, Unit> r710 = r23;
        if ((r95 & 262144) == 0) goto L296;
        Shape r28 = TextFieldDefaults.INSTANCE.getTextFieldShape(r0, 6);
        int r29 = r119 & (-234881025);
    L298:
        if ((r95 & 524288) == 0) goto L300;
        r29 = r29 & (-1879048193);
        TextFieldColors r120 = TextFieldDefaults.INSTANCE.m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
    L301:
        Shape r30 = r28;
        r6 = r29;
        Function2<? super Composer, ? super Integer, Unit> r31 = r710;
        Function2<? super Composer, ? super Integer, Unit> r32 = r24;
    L302:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L306;
        ComposerKt.traceEventStart(-1470183117, r4, r6, "androidx.compose.material.TextField (TextField.kt:534)");
    L306:
        if (r68 != null) goto L311;
        r0.startReplaceGroup(1852286888);
        Object r33 = r0.rememberedValue();
        if (r33 != Composer.Companion.getEmpty()) goto L310;
        r33 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r33);
    L310:
        r0.endReplaceGroup();
        MutableInteractionSource r210 = (MutableInteractionSource) r33;
    L312:
        r0.startReplaceGroup(198303617);
        long r121 = r115.getColor-0d7_KjU();
        if (r121 == 16) goto L315;
        r64 = true;
    L315:
        if (r64 == true) goto L318;
        r121 = ((Color) r120.textColor(r14, r0, ((r4 >> 9) & 14) | ((r6 >> 24) & 112)).getValue()).unbox-impl();
    L318:
        r0.endReplaceGroup();
        TextStyle r211 = r115.merge(new TextStyle(r121, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        TextFieldDefaults r34 = TextFieldDefaults.INSTANCE;
        Modifier r96 = r13;
        TextStyle r97 = r115;
        Modifier r122 = SizeKt.m998defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m2207indicatorLinegv0btCI$default(r34, r13, r14, r25, r210, r120, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 48, null), r25, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6)), r34.m2214getMinWidthD9Ej5fM(), r34.m2213getMinHeightD9Ej5fM());
        Color r35 = (Color) r120.cursorColor(r25, r0, (r6 & 14) | ((r6 >> 24) & 112)).getValue();
        int r123 = r4;
        SolidColor r36 = new SolidColor(r35.unbox-impl(), null);
        final boolean r711 = r14;
        final boolean r712 = r66;
        final VisualTransformation r713 = r26;
        final MutableInteractionSource r714 = r210;
        final boolean r810 = r25;
        final Function2<? super Composer, ? super Integer, Unit> r811 = r65;
        final Function2<? super Composer, ? super Integer, Unit> r812 = r20;
        final Function2<? super Composer, ? super Integer, Unit> r813 = r31;
        final Function2<? super Composer, ? super Integer, Unit> r814 = r32;
        final Shape r815 = r30;
        final TextFieldColors r816 = r120;
        ComposableLambda r37 = ComposableLambdaKt.rememberComposableLambda(1565379926, true, new AnonymousClass7(r72, r711, r712, r713, r714, r810, r811, r812, r813, r814, r815, r816), r0, 54);
        int r38 = (((r123 & 14) | (r123 & 112)) | (r123 & 7168)) | (r123 & 57344);
        int r39 = r6 << 12;
        boolean r124 = r14;
        boolean r212 = r15;
        KeyboardOptions r213 = r27;
        KeyboardActions r214 = r116;
        boolean r215 = r66;
        int r216 = r87;
        int r217 = r67;
        VisualTransformation r218 = r26;
        BasicTextFieldKt.BasicTextField(r72, r73, r122, r124, r212, r211, r213, r214, r215, r216, r217, r218, null, r210, r36, r37, r0, (((r38 | (3670016 & r39)) | (29360128 & r39)) | (234881024 & r39)) | (r39 & 1879048192), (((r6 >> 18) & 14) | 196608) | (r6 & 112), 4096);
        if (ComposerKt.isTraceInProgress() == false) goto L321;
        ComposerKt.traceEventEnd();
    L321:
        final int r125 = r87;
        final KeyboardActions r126 = r116;
        final TextStyle r40 = r97;
        final Function2<? super Composer, ? super Integer, Unit> r127 = r32;
        final Shape r128 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r41 = r20;
        final boolean r42 = r14;
        final TextFieldColors r219 = r120;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r65;
        final boolean r129 = r66;
        final int r130 = r67;
        final MutableInteractionSource r131 = r68;
        final KeyboardOptions r132 = r27;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r31;
        final boolean r133 = r25;
        final Modifier r45 = r96;
        boolean r71 = r15;
        final VisualTransformation r134 = r26;
        final boolean r46 = r71;
    L323:
        ScopeUpdateScope r47 = r0.endRestartGroup();
        if (r47 == null) goto L327;
        r47.updateScope(new zc(r72, r73, r45, r42, r46, r40, r43, r41, r44, r127, r133, r134, r132, r126, r129, r125, r130, r131, r128, r219, r93, r94, r95));
        return;
    L327:
        return;
    L311:
        r0.startReplaceGroup(198297871);
        r0.endReplaceGroup();
        r210 = r68;
        goto L312
    L300:
        r120 = r91;
        goto L301
    L296:
        r28 = r90;
        r29 = r119;
        goto L298
    L292:
        r68 = r89;
        goto L293
    L289:
        r67 = r88;
        goto L290
    L284:
        r118 = Integer.MAX_VALUE;
        r117 = -458753;
        goto L285
    L286:
        r119 = r6;
        r87 = r87;
        goto L287
    L279:
        r66 = r86;
        goto L281
    L276:
        r116 = r85;
        goto L277
    L272:
        r27 = r84;
        goto L274
    L269:
        r26 = r83;
        goto L270
    L266:
        r25 = r82;
        goto L267
    L263:
        r24 = r81;
        goto L264
    L260:
        r23 = r80;
        goto L261
    L257:
        r20 = r79;
        goto L258
    L254:
        r65 = r78;
        goto L255
    L251:
        r115 = r77;
        goto L252
    L247:
        r15 = r76;
        goto L249
    L244:
        r14 = r75;
        goto L245
    L241:
        r13 = r74;
        goto L242
    L221:
        if (r0.getDefaultsInvalid() == true) goto L239;
        r0.skipToGroupEnd();
        if ((r95 & 32) == 0) goto L227;
        r4 = r4 & (-458753);
    L227:
        if ((r95 & 8192) == 0) goto L230;
        r6 = r6 & (-7169);
    L230:
        if ((32768 & r95) == 0) goto L233;
        r6 = r6 & (-458753);
    L233:
        if ((262144 & r95) == 0) goto L236;
        r6 = r6 & (-234881025);
    L236:
        if ((r95 & 524288) == 0) goto L238;
        r6 = r6 & (-1879048193);
    L238:
        r13 = r74;
        r14 = r75;
        r15 = r76;
        r115 = r77;
        r65 = r78;
        r20 = r79;
        r31 = r80;
        r32 = r81;
        r25 = r82;
        r26 = r83;
        r27 = r84;
        r116 = r85;
        r66 = r86;
        r67 = r88;
        r68 = r89;
        r120 = r91;
        r4 = r4;
        r30 = r90;
        goto L302
    L322:
        r0.skipToGroupEnd();
        r45 = r74;
        r42 = r75;
        r46 = r76;
        r40 = r77;
        r43 = r78;
        r41 = r79;
        r44 = r80;
        r127 = r81;
        r133 = r82;
        r134 = r83;
        r132 = r84;
        r126 = r85;
        r129 = r86;
        r125 = r87;
        r130 = r88;
        r131 = r89;
        r128 = r90;
        r219 = r91;
        goto L323
    L212:
        if ((306783379 & r6) != 306783378) goto L215;
        r11 = false;
        goto L217
    L183:
        if ((r94 & 12582912) != 0) goto L190;
        if (r0.changed(r89) == false) goto L187;
        int r135 = 8388608;
    L188:
        r6 = r6 | r135;
        goto L190
    L187:
        r135 = 4194304;
        goto L188
    L173:
        if ((r94 & 1572864) != 0) goto L179;
        if (r0.changed(r88) == false) goto L177;
        int r136 = 1048576;
    L178:
        r6 = r6 | r136;
        goto L179
    L177:
        r136 = 524288;
        goto L178
    L153:
        if ((r94 & 24576) != 0) goto L160;
        if (r0.changed(r86) == false) goto L157;
        r18 = 16384;
    L157:
        r6 = r6 | r18;
        goto L160
    L132:
        if ((r94 & 384) != 0) goto L140;
        if (r0.changed(r84) == false) goto L136;
        int r220 = 256;
    L137:
        r6 = r6 | r220;
        goto L140
    L136:
        r220 = 128;
        goto L137
    L122:
        if ((r94 & 48) != 0) goto L128;
        if (r0.changed(r83) == false) goto L126;
        int r221 = 32;
    L127:
        r19 = r19 | r221;
        goto L128
    L126:
        r221 = 16;
        goto L127
    L111:
        if ((r94 & 6) == 0) goto L113;
        r19 = r94;
        goto L118
    L113:
        if (r0.changed(r82) == false) goto L115;
        int r137 = 4;
    L116:
        r19 = r94 | r137;
        goto L118
    L115:
        r137 = 2;
        goto L116
    L101:
        if ((r93 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r81) == false) goto L105;
        int r222 = 536870912;
    L106:
        r4 = r4 | r222;
        goto L107
    L105:
        r222 = 268435456;
        goto L106
    L91:
        if ((r93 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r80) == false) goto L95;
        int r223 = 67108864;
    L96:
        r4 = r4 | r223;
        goto L97
    L95:
        r223 = 33554432;
        goto L96
    L81:
        if ((r93 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r79) == false) goto L85;
        int r224 = 8388608;
    L86:
        r4 = r4 | r224;
        goto L87
    L85:
        r224 = 4194304;
        goto L86
    L71:
        if ((r93 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r78) == false) goto L75;
        int r225 = 1048576;
    L76:
        r4 = r4 | r225;
        goto L77
    L75:
        r225 = 524288;
        goto L76
    L50:
        if ((r93 & 24576) != 0) goto L58;
        if (r0.changed(r76) == false) goto L54;
        int r226 = 16384;
    L55:
        r4 = r4 | r226;
        goto L58
    L54:
        r226 = 8192;
        goto L55
    L39:
        if ((r93 & 3072) != 0) goto L46;
        if (r0.changed(r75) == false) goto L43;
        int r138 = 2048;
    L44:
        r4 = r4 | r138;
        goto L46
    L43:
        r138 = 1024;
        goto L44
    L28:
        if ((r93 & 384) != 0) goto L35;
        if (r0.changed(r74) == false) goto L32;
        int r139 = 256;
    L33:
        r4 = r4 | r139;
        goto L35
    L32:
        r139 = 128;
        goto L33
    L17:
        if ((r93 & 48) != 0) goto L24;
        if (r0.changedInstance(r73) == false) goto L21;
        int r48 = 32;
    L22:
        r4 = r4 | r48;
        goto L24
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r93 & 6) == 0) goto L8;
        r4 = r93;
        goto L14
    L8:
        if (r0.changed(r72) == false) goto L10;
        int r49 = 4;
    L11:
        r4 = r49 | r93;
        goto L14
    L10:
        r49 = 2;
        goto L11
    }

    public static final void TextField(final String r72, final Function1<? super String, Unit> r73, Modifier r74, boolean r75, boolean r76, TextStyle r77, Function2<? super Composer, ? super Integer, Unit> r78, Function2<? super Composer, ? super Integer, Unit> r79, Function2<? super Composer, ? super Integer, Unit> r80, Function2<? super Composer, ? super Integer, Unit> r81, boolean r82, VisualTransformation r83, KeyboardOptions r84, KeyboardActions r85, boolean r86, int r87, int r88, MutableInteractionSource r89, Shape r90, TextFieldColors r91, Composer r92, final int r93, final int r94, final int r95) {
        Composer r0 = r92.startRestartGroup(179130848);
        if ((r95 & 1) == 0) goto L6;
        int r4 = r93 | 6;
    L14:
        if ((r95 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r95 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r12 = r95 & 8;
        int r16 = 1024;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r17 = r95 & 16;
        int r18 = 8192;
        if (r17 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r93 & 196608) != 0) goto L67;
        if ((r95 & 32) == 0) goto L62;
    L64:
        int r21 = 65536;
    L65:
        r4 = r4 | r21;
        goto L67
    L62:
        if (r0.changed(r77) == false) goto L64;
        r21 = 131072;
    L67:
        int r22 = r95 & 64;
        if (r22 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r95 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r95 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r95 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r95 & 1024;
        if (r3 == 0) goto L111;
        int r19 = r94 | 6;
    L118:
        int r5 = r95 & 2048;
        if (r5 == 0) goto L122;
        r19 = r19 | 48;
    L128:
        int r6 = r19;
        int r7 = r95 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L140:
        if ((r94 & 3072) != 0) goto L149;
        if ((r95 & 8192) != 0) goto L147;
        if (r0.changed(r85) == false) goto L147;
        r16 = 2048;
    L147:
        r6 = r6 | r16;
    L149:
        int r10 = r95 & 16384;
        if (r10 == 0) goto L153;
        r6 = r6 | 24576;
    L160:
        if ((r94 & 196608) != 0) goto L169;
        if ((r95 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L164;
    L166:
        int r110 = 65536;
    L167:
        r6 = r6 | r110;
        goto L169
    L164:
        if (r0.changed(r87) == false) goto L166;
        r110 = 131072;
    L169:
        int r111 = r95 & 65536;
        if (r111 == 0) goto L173;
        r6 = r6 | 1572864;
    L179:
        int r112 = r95 & 131072;
        if (r112 == 0) goto L183;
        r6 = r6 | 12582912;
    L190:
        if ((r94 & 100663296) != 0) goto L200;
        if ((r95 & 262144) == 0) goto L194;
    L196:
        int r113 = 33554432;
    L197:
        r6 = r6 | r113;
        goto L200
    L194:
        if (r0.changed(r90) == false) goto L196;
        r113 = 67108864;
    L200:
        if ((r94 & 805306368) != 0) goto L209;
        if ((r95 & 524288) == 0) goto L204;
    L206:
        int r114 = 268435456;
    L207:
        r6 = r6 | r114;
        goto L209
    L204:
        if (r0.changed(r91) == false) goto L206;
        r114 = 536870912;
    L209:
        boolean r64 = false;
        if ((r4 & 306783379) == 306783378) goto L212;
    L215:
        boolean r11 = true;
    L217:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L322;
        r0.startDefaults();
        if ((r93 & 1) != 0) goto L221;
    L239:
        if (r8 == 0) goto L241;
        Modifier r13 = Modifier.Companion;
    L242:
        if (r12 == 0) goto L244;
        boolean r14 = true;
    L245:
        if (r17 == 0) goto L247;
        boolean r15 = false;
    L249:
        if ((r95 & 32) == 0) goto L251;
        TextStyle r115 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L252:
        if (r22 == 0) goto L254;
        Function2<? super Composer, ? super Integer, Unit> r65 = null;
    L255:
        if (r9 == 0) goto L257;
        Function2<? super Composer, ? super Integer, Unit> r20 = null;
    L258:
        if (r1 == 0) goto L260;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L261:
        if (r2 == 0) goto L263;
        Function2<? super Composer, ? super Integer, Unit> r24 = null;
    L264:
        if (r3 == 0) goto L266;
        boolean r25 = false;
    L267:
        if (r5 == 0) goto L269;
        VisualTransformation r26 = VisualTransformation.Companion.getNone();
    L270:
        if (r7 == 0) goto L272;
        KeyboardOptions r27 = KeyboardOptions.Companion.getDefault();
    L274:
        if ((r95 & 8192) == 0) goto L276;
        KeyboardActions r116 = new KeyboardActions(null, null, null, null, null, null, 63, null);
        r6 = r6 & (-7169);
    L277:
        if (r10 == 0) goto L279;
        boolean r66 = false;
    L281:
        if ((r95 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L286;
        if (r66 == false) goto L284;
        int r117 = -458753;
        int r118 = 1;
    L285:
        int r119 = r6 & r117;
        r87 = r118;
    L287:
        if (r111 == 0) goto L289;
        int r67 = 1;
    L290:
        if (r112 == 0) goto L292;
        MutableInteractionSource r68 = null;
    L293:
        Function2<? super Composer, ? super Integer, Unit> r710 = r23;
        if ((r95 & 262144) == 0) goto L296;
        Shape r28 = TextFieldDefaults.INSTANCE.getTextFieldShape(r0, 6);
        int r29 = r119 & (-234881025);
    L298:
        if ((r95 & 524288) == 0) goto L300;
        r29 = r29 & (-1879048193);
        TextFieldColors r120 = TextFieldDefaults.INSTANCE.m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
    L301:
        Shape r30 = r28;
        r6 = r29;
        Function2<? super Composer, ? super Integer, Unit> r31 = r710;
        Function2<? super Composer, ? super Integer, Unit> r32 = r24;
    L302:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L306;
        ComposerKt.traceEventStart(179130848, r4, r6, "androidx.compose.material.TextField (TextField.kt:344)");
    L306:
        if (r68 != null) goto L311;
        r0.startReplaceGroup(2138736091);
        Object r33 = r0.rememberedValue();
        if (r33 != Composer.Companion.getEmpty()) goto L310;
        r33 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r33);
    L310:
        r0.endReplaceGroup();
        MutableInteractionSource r210 = (MutableInteractionSource) r33;
    L312:
        r0.startReplaceGroup(346091246);
        long r121 = r115.getColor-0d7_KjU();
        if (r121 == 16) goto L315;
        r64 = true;
    L315:
        if (r64 == true) goto L318;
        r121 = ((Color) r120.textColor(r14, r0, ((r4 >> 9) & 14) | ((r6 >> 24) & 112)).getValue()).unbox-impl();
    L318:
        r0.endReplaceGroup();
        TextStyle r211 = r115.merge(new TextStyle(r121, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        TextFieldDefaults r34 = TextFieldDefaults.INSTANCE;
        Modifier r96 = r13;
        TextStyle r97 = r115;
        Modifier r122 = SizeKt.m998defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(TextFieldDefaults.m2207indicatorLinegv0btCI$default(r34, r13, r14, r25, r210, r120, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 48, null), r25, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6)), r34.m2214getMinWidthD9Ej5fM(), r34.m2213getMinHeightD9Ej5fM());
        Color r35 = (Color) r120.cursorColor(r25, r0, (r6 & 14) | ((r6 >> 24) & 112)).getValue();
        int r123 = r4;
        SolidColor r36 = new SolidColor(r35.unbox-impl(), null);
        final boolean r711 = r14;
        final boolean r712 = r66;
        final VisualTransformation r713 = r26;
        final MutableInteractionSource r714 = r210;
        final boolean r810 = r25;
        final Function2<? super Composer, ? super Integer, Unit> r811 = r65;
        final Function2<? super Composer, ? super Integer, Unit> r812 = r20;
        final Function2<? super Composer, ? super Integer, Unit> r813 = r31;
        final Function2<? super Composer, ? super Integer, Unit> r814 = r32;
        final Shape r815 = r30;
        final TextFieldColors r816 = r120;
        ComposableLambda r37 = ComposableLambdaKt.rememberComposableLambda(-83351293, true, new AnonymousClass3(r72, r711, r712, r713, r714, r810, r811, r812, r813, r814, r815, r816), r0, 54);
        int r38 = (((r123 & 14) | (r123 & 112)) | (r123 & 7168)) | (r123 & 57344);
        int r39 = r6 << 12;
        boolean r124 = r14;
        boolean r212 = r15;
        KeyboardOptions r213 = r27;
        KeyboardActions r214 = r116;
        boolean r215 = r66;
        int r216 = r87;
        int r217 = r67;
        VisualTransformation r218 = r26;
        BasicTextFieldKt.BasicTextField(r72, r73, r122, r124, r212, r211, r213, r214, r215, r216, r217, r218, null, r210, r36, r37, r0, (((r38 | (3670016 & r39)) | (29360128 & r39)) | (234881024 & r39)) | (r39 & 1879048192), (((r6 >> 18) & 14) | 196608) | (r6 & 112), 4096);
        if (ComposerKt.isTraceInProgress() == false) goto L321;
        ComposerKt.traceEventEnd();
    L321:
        final int r125 = r87;
        final KeyboardActions r126 = r116;
        final TextStyle r40 = r97;
        final Function2<? super Composer, ? super Integer, Unit> r127 = r32;
        final Shape r128 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r41 = r20;
        final boolean r42 = r14;
        final TextFieldColors r219 = r120;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r65;
        final boolean r129 = r66;
        final int r130 = r67;
        final MutableInteractionSource r131 = r68;
        final KeyboardOptions r132 = r27;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r31;
        final boolean r133 = r25;
        final Modifier r45 = r96;
        boolean r71 = r15;
        final VisualTransformation r134 = r26;
        final boolean r46 = r71;
    L323:
        ScopeUpdateScope r47 = r0.endRestartGroup();
        if (r47 == null) goto L327;
        r47.updateScope(new dd(r72, r73, r45, r42, r46, r40, r43, r41, r44, r127, r133, r134, r132, r126, r129, r125, r130, r131, r128, r219, r93, r94, r95));
        return;
    L327:
        return;
    L311:
        r0.startReplaceGroup(346085500);
        r0.endReplaceGroup();
        r210 = r68;
        goto L312
    L300:
        r120 = r91;
        goto L301
    L296:
        r28 = r90;
        r29 = r119;
        goto L298
    L292:
        r68 = r89;
        goto L293
    L289:
        r67 = r88;
        goto L290
    L284:
        r118 = Integer.MAX_VALUE;
        r117 = -458753;
        goto L285
    L286:
        r119 = r6;
        r87 = r87;
        goto L287
    L279:
        r66 = r86;
        goto L281
    L276:
        r116 = r85;
        goto L277
    L272:
        r27 = r84;
        goto L274
    L269:
        r26 = r83;
        goto L270
    L266:
        r25 = r82;
        goto L267
    L263:
        r24 = r81;
        goto L264
    L260:
        r23 = r80;
        goto L261
    L257:
        r20 = r79;
        goto L258
    L254:
        r65 = r78;
        goto L255
    L251:
        r115 = r77;
        goto L252
    L247:
        r15 = r76;
        goto L249
    L244:
        r14 = r75;
        goto L245
    L241:
        r13 = r74;
        goto L242
    L221:
        if (r0.getDefaultsInvalid() == true) goto L239;
        r0.skipToGroupEnd();
        if ((r95 & 32) == 0) goto L227;
        r4 = r4 & (-458753);
    L227:
        if ((r95 & 8192) == 0) goto L230;
        r6 = r6 & (-7169);
    L230:
        if ((32768 & r95) == 0) goto L233;
        r6 = r6 & (-458753);
    L233:
        if ((262144 & r95) == 0) goto L236;
        r6 = r6 & (-234881025);
    L236:
        if ((r95 & 524288) == 0) goto L238;
        r6 = r6 & (-1879048193);
    L238:
        r13 = r74;
        r14 = r75;
        r15 = r76;
        r115 = r77;
        r65 = r78;
        r20 = r79;
        r31 = r80;
        r32 = r81;
        r25 = r82;
        r26 = r83;
        r27 = r84;
        r116 = r85;
        r66 = r86;
        r67 = r88;
        r68 = r89;
        r120 = r91;
        r4 = r4;
        r30 = r90;
        goto L302
    L322:
        r0.skipToGroupEnd();
        r45 = r74;
        r42 = r75;
        r46 = r76;
        r40 = r77;
        r43 = r78;
        r41 = r79;
        r44 = r80;
        r127 = r81;
        r133 = r82;
        r134 = r83;
        r132 = r84;
        r126 = r85;
        r129 = r86;
        r125 = r87;
        r130 = r88;
        r131 = r89;
        r128 = r90;
        r219 = r91;
        goto L323
    L212:
        if ((306783379 & r6) != 306783378) goto L215;
        r11 = false;
        goto L217
    L183:
        if ((r94 & 12582912) != 0) goto L190;
        if (r0.changed(r89) == false) goto L187;
        int r135 = 8388608;
    L188:
        r6 = r6 | r135;
        goto L190
    L187:
        r135 = 4194304;
        goto L188
    L173:
        if ((r94 & 1572864) != 0) goto L179;
        if (r0.changed(r88) == false) goto L177;
        int r136 = 1048576;
    L178:
        r6 = r6 | r136;
        goto L179
    L177:
        r136 = 524288;
        goto L178
    L153:
        if ((r94 & 24576) != 0) goto L160;
        if (r0.changed(r86) == false) goto L157;
        r18 = 16384;
    L157:
        r6 = r6 | r18;
        goto L160
    L132:
        if ((r94 & 384) != 0) goto L140;
        if (r0.changed(r84) == false) goto L136;
        int r220 = 256;
    L137:
        r6 = r6 | r220;
        goto L140
    L136:
        r220 = 128;
        goto L137
    L122:
        if ((r94 & 48) != 0) goto L128;
        if (r0.changed(r83) == false) goto L126;
        int r221 = 32;
    L127:
        r19 = r19 | r221;
        goto L128
    L126:
        r221 = 16;
        goto L127
    L111:
        if ((r94 & 6) == 0) goto L113;
        r19 = r94;
        goto L118
    L113:
        if (r0.changed(r82) == false) goto L115;
        int r137 = 4;
    L116:
        r19 = r94 | r137;
        goto L118
    L115:
        r137 = 2;
        goto L116
    L101:
        if ((r93 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r81) == false) goto L105;
        int r222 = 536870912;
    L106:
        r4 = r4 | r222;
        goto L107
    L105:
        r222 = 268435456;
        goto L106
    L91:
        if ((r93 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r80) == false) goto L95;
        int r223 = 67108864;
    L96:
        r4 = r4 | r223;
        goto L97
    L95:
        r223 = 33554432;
        goto L96
    L81:
        if ((r93 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r79) == false) goto L85;
        int r224 = 8388608;
    L86:
        r4 = r4 | r224;
        goto L87
    L85:
        r224 = 4194304;
        goto L86
    L71:
        if ((r93 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r78) == false) goto L75;
        int r225 = 1048576;
    L76:
        r4 = r4 | r225;
        goto L77
    L75:
        r225 = 524288;
        goto L76
    L50:
        if ((r93 & 24576) != 0) goto L58;
        if (r0.changed(r76) == false) goto L54;
        int r226 = 16384;
    L55:
        r4 = r4 | r226;
        goto L58
    L54:
        r226 = 8192;
        goto L55
    L39:
        if ((r93 & 3072) != 0) goto L46;
        if (r0.changed(r75) == false) goto L43;
        int r138 = 2048;
    L44:
        r4 = r4 | r138;
        goto L46
    L43:
        r138 = 1024;
        goto L44
    L28:
        if ((r93 & 384) != 0) goto L35;
        if (r0.changed(r74) == false) goto L32;
        int r139 = 256;
    L33:
        r4 = r4 | r139;
        goto L35
    L32:
        r139 = 128;
        goto L33
    L17:
        if ((r93 & 48) != 0) goto L24;
        if (r0.changedInstance(r73) == false) goto L21;
        int r48 = 32;
    L22:
        r4 = r4 | r48;
        goto L24
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r93 & 6) == 0) goto L8;
        r4 = r93;
        goto L14
    L8:
        if (r0.changed(r72) == false) goto L10;
        int r49 = 4;
    L11:
        r4 = r49 | r93;
        goto L14
    L10:
        r49 = 2;
        goto L11
    }
}
