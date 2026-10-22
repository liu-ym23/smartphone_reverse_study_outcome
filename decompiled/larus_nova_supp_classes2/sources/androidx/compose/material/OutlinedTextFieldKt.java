package androidx.compose.material;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
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
@Metadata(d1 = {"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0085\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u0010$\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00101\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00102\u001a\u0093\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u0002032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00104\u001a\u0087\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010%\u001a\u0002032\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00105\u001aÁ\u0001\u00106\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010(¢\u0006\u0002\b\r2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0013\u00109\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010:\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00010(2\u0011\u0010>\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\u0010A\u001aW\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020/2\u0006\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020;2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bK\u0010L\u001aW\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020;2\u0006\u0010?\u001a\u00020@H\u0002¢\u0006\u0004\bS\u0010L\u001a|\u0010T\u001a\u00020\u0001*\u00020U2\u0006\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020/2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020Y2\b\u0010\\\u001a\u0004\u0018\u00010Y2\b\u0010]\u001a\u0004\u0018\u00010Y2\u0006\u0010^\u001a\u00020Y2\u0006\u0010:\u001a\u00020;2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010J\u001a\u00020;2\u0006\u0010_\u001a\u00020`2\u0006\u0010?\u001a\u00020@H\u0002\u001a#\u0010a\u001a\u00020\u0005*\u00020\u00052\u0006\u0010b\u001a\u00020=2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0004\bc\u0010d\"\u0010\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010g\"\u0016\u0010h\u001a\u00020iX\u0080\u0004¢\u0006\n\n\u0002\u0010l\u001a\u0004\bj\u0010k\"\u000e\u0010m\u001a\u00020&X\u0080T¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"OutlinedTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "value", "", "onValueChange", "Lkotlin/Function1;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateWidth-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "calculateHeight-O3s9Psw", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "Landroidx/compose/ui/unit/TextUnit;", "getOutlinedTextFieldTopPadding", "()J", "J", "BorderId", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = 0.0f;
    private static final long OutlinedTextFieldTopPadding = 0;

    /* JADX INFO: renamed from: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextField$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass3 implements TextFieldDecorator {
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

        public AnonymousClass3(OutputTransformation r1, TextFieldState r2, TextFieldLineLimits r3, boolean r4, MutableInteractionSource r5, boolean r6, Function2<? super Composer, ? super Integer, Unit> r7, Function2<? super Composer, ? super Integer, Unit> r8, Function2<? super Composer, ? super Integer, Unit> r9, Function2<? super Composer, ? super Integer, Unit> r10, Shape r11, TextFieldColors r12) {
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

        private static final Unit Decoration$lambda$2(AnonymousClass3 r0, Function2 r1, int r2, Composer r3, int r4) {
            r0.Decoration(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit a(AnonymousClass3 r0, Function2 r1, int r2, Composer r3, int r4) {
            return Decoration$lambda$2(r0, r1, r2, r3, r4);
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
        @Override // androidx.compose.foundation.text.input.TextFieldDecorator
        public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, int r29) {
            Composer r3 = r28.startRestartGroup(1251830469);
            if ((r29 & 6) == 0) goto L5;
            int r5 = r29;
        L11:
            if ((r29 & 48) == 0) goto L13;
        L17:
            int r15 = r5;
            if ((r15 & 19) == 18) goto L20;
            boolean r6 = true;
        L22:
            if (r3.shouldExecute(r6, r15 & 1) == true) goto L24;
            Composer r0 = r3;
            final int r1 = r29;
            r0.skipToGroupEnd();
        L44:
            ScopeUpdateScope r2 = r0.endRestartGroup();
            if (r2 == null) goto L48;
            r2.updateScope(new q7(this, r27, r1));
            return;
        L48:
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L27;
            ComposerKt.traceEventStart(1251830469, r15, -1, "androidx.compose.material.OutlinedTextField.<no name provided>.Decoration (OutlinedTextField.kt:219)");
        L27:
            if (this.$outputTransformation != null) goto L30;
            String r4 = this.$state.getText().toString();
        L29:
            String r18 = r4;
            TextFieldDefaults r7 = TextFieldDefaults.INSTANCE;
            VisualTransformation r8 = VisualTransformation.Companion.getNone();
            boolean r9 = Intrinsics.areEqual(this.$lineLimits, TextFieldLineLimits.SingleLine.INSTANCE);
            final boolean r13 = this.$enabled;
            final MutableInteractionSource r12 = this.$interactionSource;
            final boolean r11 = this.$isError;
            Function2<? super Composer, ? super Integer, Unit> r10 = this.$label;
            Function2<? super Composer, ? super Integer, Unit> r14 = this.$placeholder;
            Function2<? super Composer, ? super Integer, Unit> r16 = this.$leadingIcon;
            Function2<? super Composer, ? super Integer, Unit> r17 = this.$trailingIcon;
            final Shape r19 = this.$shape;
            final TextFieldColors r20 = this.$colors;
            Function2<? super Composer, ? super Integer, Unit> r110 = ComposableLambdaKt.rememberComposableLambda(413830957, true, new OutlinedTextFieldKt$OutlinedTextField$3$Decoration$1(r13, r11, r12, r20, r19), r3, 54);
            int r21 = ((r15 << 3) & 112) | 24576;
            r0 = r3;
            r1 = r29;
            r7.OutlinedTextFieldDecorationBox(r18, r27, r13, r9, r8, r12, r11, r10, r14, r16, r17, r19, r20, null, r110, r0, r21, 221184, 8192);
            if (ComposerKt.isTraceInProgress() == false) goto L44;
            ComposerKt.traceEventEnd();
            goto L44
        L30:
            TextFieldState r22 = this.$state;
            TextFieldBuffer r23 = r22.startEdit();
            r22.commitEdit(r23);     // Catch: Throwable -> L40
            r22.finishEditing();
            OutputTransformation r24 = this.$outputTransformation;
            if (r23 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("buffer");
            TextFieldBuffer r25 = null;
        L36:
            r24.transformOutput(r25);
            r4 = r23.asCharSequence().toString();
            goto L29
        L35:
            r25 = r23;
        L40:
            th = move-exception;
            r22.finishEditing();
            throw th;
        L20:
            r6 = false;
            goto L22
        L13:
            if (r3.changed(this) == false) goto L15;
            int r26 = 32;
        L16:
            r5 = r5 | r26;
            goto L17
        L15:
            r26 = 16;
            goto L16
        L5:
            if (r3.changedInstance(r27) == false) goto L7;
            int r30 = 4;
        L8:
            r5 = r30 | r29;
            goto L11
        L7:
            r30 = 2;
            goto L8
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            r0[LayoutDirection.Rtl.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        OutlinedTextFieldInnerPadding = Dp.constructor-impl(4);
        OutlinedTextFieldTopPadding = TextUnitKt.getSp(8);
    }

    private static final Unit OutlinedTextField$lambda$11(String r24, Function1 r25, Modifier r26, boolean r27, boolean r28, TextStyle r29, Function2 r30, Function2 r31, Function2 r32, Function2 r33, boolean r34, VisualTransformation r35, KeyboardOptions r36, KeyboardActions r37, boolean r38, int r39, int r40, MutableInteractionSource r41, Shape r42, TextFieldColors r43, int r44, int r45, int r46, Composer r47, int r48) {
        OutlinedTextField(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$13(String r23, Function1 r24, Modifier r25, boolean r26, boolean r27, TextStyle r28, Function2 r29, Function2 r30, Function2 r31, Function2 r32, boolean r33, VisualTransformation r34, KeyboardOptions r35, KeyboardActions r36, boolean r37, int r38, MutableInteractionSource r39, Shape r40, TextFieldColors r41, int r42, int r43, int r44, Composer r45, int r46) {
        OutlinedTextField(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$19(TextFieldValue r24, Function1 r25, Modifier r26, boolean r27, boolean r28, TextStyle r29, Function2 r30, Function2 r31, Function2 r32, Function2 r33, boolean r34, VisualTransformation r35, KeyboardOptions r36, KeyboardActions r37, boolean r38, int r39, int r40, MutableInteractionSource r41, Shape r42, TextFieldColors r43, int r44, int r45, int r46, Composer r47, int r48) {
        OutlinedTextField(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$21(TextFieldValue r23, Function1 r24, Modifier r25, boolean r26, boolean r27, TextStyle r28, Function2 r29, Function2 r30, Function2 r31, Function2 r32, boolean r33, VisualTransformation r34, KeyboardOptions r35, KeyboardActions r36, boolean r37, int r38, MutableInteractionSource r39, Shape r40, TextFieldColors r41, int r42, int r43, int r44, Composer r45, int r46) {
        OutlinedTextField(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$5(TextFieldState r23, Modifier r24, boolean r25, boolean r26, TextStyle r27, Function2 r28, Function2 r29, Function2 r30, Function2 r31, boolean r32, InputTransformation r33, OutputTransformation r34, KeyboardOptions r35, KeyboardActionHandler r36, TextFieldLineLimits r37, ScrollState r38, Shape r39, TextFieldColors r40, MutableInteractionSource r41, int r42, int r43, int r44, Composer r45, int r46) {
        OutlinedTextField(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextFieldLayout$lambda$28(Modifier r15, Function2 r16, Function3 r17, Function2 r18, Function2 r19, Function2 r20, boolean r21, float r22, Function1 r23, Function2 r24, PaddingValues r25, int r26, int r27, Composer r28, int r29) {
        OutlinedTextFieldLayout(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), RecomposeScopeImplKt.updateChangedFlags(r27));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, int r17, MutableInteractionSource r18, Shape r19, TextFieldColors r20, int r21, int r22, int r23, Composer r24, int r25) {
        return OutlinedTextField$lambda$11(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
        return OutlinedTextField$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit c(long r0, PaddingValues r2, ContentDrawScope r3) {
        return outlineCutout_12SF9DM$lambda$32(r0, r2, r3);
    }

    public static /* synthetic */ Unit d(String r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, MutableInteractionSource r17, Shape r18, TextFieldColors r19, int r20, int r21, int r22, Composer r23, int r24) {
        return OutlinedTextField$lambda$13(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ Unit e(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, MutableInteractionSource r17, Shape r18, TextFieldColors r19, int r20, int r21, int r22, Composer r23, int r24) {
        return OutlinedTextField$lambda$21(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ Unit f(SemanticsPropertyReceiver r0) {
        return OutlinedTextField$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit g(TextFieldState r1, Modifier r2, boolean r3, boolean r4, TextStyle r5, Function2 r6, Function2 r7, Function2 r8, Function2 r9, boolean r10, InputTransformation r11, OutputTransformation r12, KeyboardOptions r13, KeyboardActionHandler r14, TextFieldLineLimits r15, ScrollState r16, Shape r17, TextFieldColors r18, MutableInteractionSource r19, int r20, int r21, int r22, Composer r23, int r24) {
        return OutlinedTextField$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ Unit h(SemanticsPropertyReceiver r0) {
        return OutlinedTextField$lambda$9$lambda$8(r0);
    }

    public static /* synthetic */ Unit i(TextFieldValue r1, Function1 r2, Modifier r3, boolean r4, boolean r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Function2 r10, boolean r11, VisualTransformation r12, KeyboardOptions r13, KeyboardActions r14, boolean r15, int r16, int r17, MutableInteractionSource r18, Shape r19, TextFieldColors r20, int r21, int r22, int r23, Composer r24, int r25) {
        return OutlinedTextField$lambda$19(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit j(Modifier r0, Function2 r1, Function3 r2, Function2 r3, Function2 r4, Function2 r5, boolean r6, float r7, Function1 r8, Function2 r9, PaddingValues r10, int r11, int r12, Composer r13, int r14) {
        return OutlinedTextFieldLayout$lambda$28(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static final long getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    private static final Unit OutlinedTextField$lambda$17$lambda$16(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$3$lambda$2(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextField$lambda$9$lambda$8(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m2117outlineCutout12SF9DM(Modifier r1, final long r2, final PaddingValues r4) {
        return DrawModifierKt.drawWithContent(r1, new i7(r2, r4));
    }

    private static final Unit outlineCutout_12SF9DM$lambda$32(long r15, PaddingValues r17, ContentDrawScope r18) {
        float r2 = Float.intBitsToFloat((int) (r15 >> 32));
        if (r2 <= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L17;
        float r4 = r18.toPx-0680j_4(OutlinedTextFieldInnerPadding);
        float r5 = r18.toPx-0680j_4(r17.mo899calculateLeftPaddingu2uoSUM(r18.getLayoutDirection())) - r4;
        float r6 = 2;
        float r3 = (r2 + r5) + (r4 * r6);
        LayoutDirection r7 = r18.getLayoutDirection();
        int[] r8 = WhenMappings.$EnumSwitchMapping$0;
        if (r8[r7.ordinal()] != 1) goto L7;
        float r9 = Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() >> 32)) - r3;
    L8:
        float r10 = r9;
        if (r8[r18.getLayoutDirection().ordinal()] != 1) goto L11;
        r3 = Float.intBitsToFloat((int) (r18.getSize-NH-jbRc() >> 32)) - RangesKt.coerceAtLeast(r5, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
    L11:
        float r12 = r3;
        float r1 = Float.intBitsToFloat((int) (4294967295L & r15));
        float r11 = (-r1) / r6;
        float r13 = r1 / r6;
        int r14 = ClipOp.Companion.getDifference-rtfAjoo();
        DrawContext r16 = r18.getDrawContext();
        long r19 = r16.getSize-NH-jbRc();
        r16.getCanvas().save();
        r16.getTransform().clipRect-N_I0leg(r10, r11, r12, r13, r14);     // Catch: Throwable -> L14
        r18.drawContent();     // Catch: Throwable -> L14
        r16.getCanvas().restore();
        r16.setSize-uvyYCjk(r19);
    L19:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        r16.getCanvas().restore();
        r16.setSize-uvyYCjk(r19);
        throw th;
    L7:
        r9 = RangesKt.coerceAtLeast(r5, androidx.compose.material3.MenuKt.ClosedAlphaTarget);
        goto L8
    L17:
        r18.drawContent();
        goto L19
    }

    /* JADX INFO: renamed from: access$calculateHeight-O3s9Psw, reason: not valid java name */
    public static final /* synthetic */ int m2113access$calculateHeightO3s9Psw(int r0, int r1, int r2, int r3, int r4, float r5, long r6, float r8, PaddingValues r9) {
        return m2115calculateHeightO3s9Psw(r0, r1, r2, r3, r4, r5, r6, r8, r9);
    }

    /* JADX INFO: renamed from: access$calculateWidth-O3s9Psw, reason: not valid java name */
    public static final /* synthetic */ int m2114access$calculateWidthO3s9Psw(int r0, int r1, int r2, int r3, int r4, float r5, long r6, float r8, PaddingValues r9) {
        return m2116calculateWidthO3s9Psw(r0, r1, r2, r3, r4, r5, r6, r8, r9);
    }

    /* JADX INFO: renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    private static final int m2115calculateHeightO3s9Psw(int r1, int r2, int r3, int r4, int r5, float r6, long r7, float r9, PaddingValues r10) {
        int r8 = Math.max(r3, Math.max(r5, MathHelpersKt.lerp(r4, 0, r6)));
        float r11 = r10.mo901calculateTopPaddingD9Ej5fM() * r9;
        return ConstraintsKt.constrainHeight-K40F9xA(r7, Math.max(r1, Math.max(r2, MathKt.roundToInt((MathHelpersKt.lerp(r11, Math.max(r11, r4 / 2.0f), r6) + r8) + (r10.mo898calculateBottomPaddingD9Ej5fM() * r9)))));
    }

    /* JADX INFO: renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    private static final int m2116calculateWidthO3s9Psw(int r1, int r2, int r3, int r4, int r5, float r6, long r7, float r9, PaddingValues r10) {
        int r8 = (r1 + Math.max(r3, Math.max(MathHelpersKt.lerp(r4, 0, r6), r5))) + r2;
        LayoutDirection r11 = LayoutDirection.Ltr;
        return ConstraintsKt.constrainWidth-K40F9xA(r7, Math.max(r8, MathKt.roundToInt((r4 + (Dp.constructor-impl(r10.mo899calculateLeftPaddingu2uoSUM(r11) + r10.mo900calculateRightPaddingu2uoSUM(r11)) * r9)) * r6)));
    }

    public static final void OutlinedTextFieldLayout(final Modifier r26, final Function2<? super Composer, ? super Integer, Unit> r27, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> r28, final Function2<? super Composer, ? super Integer, Unit> r29, final Function2<? super Composer, ? super Integer, Unit> r30, final Function2<? super Composer, ? super Integer, Unit> r31, final boolean r32, final float r33, final Function1<? super Size, Unit> r34, final Function2<? super Composer, ? super Integer, Unit> r35, final PaddingValues r36, Composer r37, final int r38, final int r39) {
        Composer r13 = r37.startRestartGroup(36320288);
        if ((r38 & 6) == 0) goto L5;
        int r14 = r38;
    L11:
        if ((r38 & 48) != 0) goto L18;
        if (r13.changedInstance(r27) == false) goto L15;
        int r16 = 32;
    L16:
        r14 = r14 | r16;
        goto L18
    L15:
        r16 = 16;
    L18:
        if ((r38 & 384) != 0) goto L25;
        if (r13.changedInstance(r28) == false) goto L22;
        int r0 = 256;
    L23:
        r14 = r14 | r0;
        goto L25
    L22:
        r0 = 128;
    L25:
        if ((r38 & 3072) != 0) goto L32;
        if (r13.changedInstance(r29) == false) goto L29;
        int r1 = 2048;
    L30:
        r14 = r14 | r1;
        goto L32
    L29:
        r1 = 1024;
    L32:
        if ((r38 & 24576) != 0) goto L39;
        if (r13.changedInstance(r30) == false) goto L36;
        int r2 = 16384;
    L37:
        r14 = r14 | r2;
        goto L39
    L36:
        r2 = 8192;
    L39:
        if ((196608 & r38) != 0) goto L46;
        if (r13.changedInstance(r31) == false) goto L43;
        int r3 = 131072;
    L44:
        r14 = r14 | r3;
        goto L46
    L43:
        r3 = 65536;
    L46:
        if ((1572864 & r38) != 0) goto L53;
        if (r13.changed(r32) == false) goto L50;
        int r4 = 1048576;
    L51:
        r14 = r14 | r4;
        goto L53
    L50:
        r4 = 524288;
    L53:
        if ((12582912 & r38) != 0) goto L60;
        if (r13.changed(r33) == false) goto L57;
        int r5 = 8388608;
    L58:
        r14 = r14 | r5;
        goto L60
    L57:
        r5 = 4194304;
    L60:
        if ((100663296 & r38) != 0) goto L67;
        if (r13.changedInstance(r34) == false) goto L64;
        int r6 = 67108864;
    L65:
        r14 = r14 | r6;
        goto L67
    L64:
        r6 = 33554432;
    L67:
        if ((805306368 & r38) != 0) goto L74;
        if (r13.changedInstance(r35) == false) goto L71;
        int r7 = 536870912;
    L72:
        r14 = r14 | r7;
        goto L74
    L71:
        r7 = 268435456;
    L74:
        if ((r39 & 6) == 0) goto L76;
        int r8 = r39;
    L82:
        if ((r14 & 306783379) == 306783378) goto L84;
    L87:
        boolean r12 = true;
    L89:
        if (r13.shouldExecute(r12, r14 & 1) == true) goto L91;
        r13.skipToGroupEnd();
    L200:
        ScopeUpdateScope r15 = r13.endRestartGroup();
        if (r15 == null) goto L204;
        r15.updateScope(new n7(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r38, r39));
        return;
    L204:
        return;
    L91:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(36320288, r14, r8, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:685)");
    L94:
        if ((234881024 & r14) != 67108864) goto L96;
        boolean r17 = true;
    L98:
        if ((3670016 & r14) != 1048576) goto L100;
        boolean r9 = true;
    L101:
        boolean r10 = r9 | r17;
        if ((29360128 & r14) != 8388608) goto L104;
        boolean r18 = true;
    L105:
        boolean r11 = r10 | r18;
        if ((r8 & 14) != 4) goto L108;
        boolean r19 = true;
    L109:
        boolean r20 = r19 | r11;
        Object r21 = r13.rememberedValue();
        if (r20 == false) goto L112;
    L113:
        r21 = new OutlinedTextFieldMeasurePolicy(r34, r32, r33, r36);
        r13.updateRememberedValue(r21);
    L114:
        OutlinedTextFieldMeasurePolicy r22 = (OutlinedTextFieldMeasurePolicy) r21;
        LayoutDirection r23 = (LayoutDirection) r13.consume(CompositionLocalsKt.getLocalLayoutDirection());
        int r110 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r111 = r13.getCurrentCompositionLocalMap();
        Modifier r24 = ComposedModifierKt.materializeModifier(r13, r26);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r25 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L117;
        ComposablesKt.invalidApplier();
    L117:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L120;
        r13.createNode(r25);
    L121:
        Composer r40 = Updater.constructor-impl(r13);
        Updater.set-impl(r40, r22, r112.getSetMeasurePolicy());
        Updater.set-impl(r40, r111, r112.getSetResolvedCompositionLocals());
        Function2 r41 = r112.getSetCompositeKeyHash();
        if (r40.getInserting() == false) goto L124;
    L125:
        r40.updateRememberedValue(Integer.valueOf(r110));
        r40.apply(Integer.valueOf(r110), r41);
    L126:
        Updater.set-impl(r40, r24, r112.getSetModifier());
        r35.invoke(r13, Integer.valueOf((r14 >> 27) & 14));
        if (r30 == null) goto L141;
        r13.startReplaceGroup(1336978507);
        Modifier r42 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId));
        MeasurePolicy r43 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r44 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r45 = r13.getCurrentCompositionLocalMap();
        Modifier r46 = ComposedModifierKt.materializeModifier(r13, r42);
        Function0 r113 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L131;
        ComposablesKt.invalidApplier();
    L131:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L134;
        r13.createNode(r113);
    L135:
        Composer r114 = Updater.constructor-impl(r13);
        Updater.set-impl(r114, r43, r112.getSetMeasurePolicy());
        Updater.set-impl(r114, r45, r112.getSetResolvedCompositionLocals());
        Function2 r47 = r112.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L138;
    L139:
        r114.updateRememberedValue(Integer.valueOf(r44));
        r114.apply(Integer.valueOf(r44), r47);
    L140:
        Updater.set-impl(r114, r46, r112.getSetModifier());
        BoxScopeInstance r48 = BoxScopeInstance.INSTANCE;
        r30.invoke(r13, Integer.valueOf((r14 >> 12) & 14));
        r13.endNode();
        r13.endReplaceGroup();
    L142:
        if (r31 == null) goto L156;
        r13.startReplaceGroup(1337267241);
        Modifier r49 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId));
        MeasurePolicy r50 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r51 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r52 = r13.getCurrentCompositionLocalMap();
        Modifier r53 = ComposedModifierKt.materializeModifier(r13, r49);
        Function0 r115 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L146;
        ComposablesKt.invalidApplier();
    L146:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L149;
        r13.createNode(r115);
    L150:
        Composer r116 = Updater.constructor-impl(r13);
        Updater.set-impl(r116, r50, r112.getSetMeasurePolicy());
        Updater.set-impl(r116, r52, r112.getSetResolvedCompositionLocals());
        Function2 r54 = r112.getSetCompositeKeyHash();
        if (r116.getInserting() == false) goto L153;
    L154:
        r116.updateRememberedValue(Integer.valueOf(r51));
        r116.apply(Integer.valueOf(r51), r54);
    L155:
        Updater.set-impl(r116, r53, r112.getSetModifier());
        BoxScopeInstance r55 = BoxScopeInstance.INSTANCE;
        r31.invoke(r13, Integer.valueOf((r14 >> 15) & 14));
        r13.endNode();
        r13.endReplaceGroup();
    L157:
        float r56 = PaddingKt.calculateStartPadding(r36, r23);
        float r57 = PaddingKt.calculateEndPadding(r36, r23);
        Modifier.Companion r58 = Modifier.Companion;
        if (r30 == null) goto L160;
        int r59 = 0;
        r56 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(r56 - TextFieldImplKt.getHorizontalIconPadding()), Dp.constructor-impl(0)));
    L161:
        float r210 = r56;
        if (r31 == null) goto L164;
        r57 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(r57 - TextFieldImplKt.getHorizontalIconPadding()), Dp.constructor-impl(r59)));
    L164:
        Modifier r60 = PaddingKt.m964paddingqDBjuR0$default(r58, r210, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r57, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 10, null);
        if (r28 == null) goto L167;
        r13.startReplaceGroup(1338367152);
        r28.invoke(LayoutIdKt.layoutId(r58, TextFieldImplKt.PlaceholderId).then(r60), r13, Integer.valueOf((r14 >> 3) & 112));
        r13.endReplaceGroup();
    L168:
        Modifier r61 = LayoutIdKt.layoutId(r58, TextFieldImplKt.TextFieldId).then(r60);
        Alignment.Companion r62 = Alignment.Companion;
        MeasurePolicy r63 = BoxKt.maybeCachedBoxMeasurePolicy(r62.getTopStart(), true);
        int r117 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r64 = r13.getCurrentCompositionLocalMap();
        Modifier r65 = ComposedModifierKt.materializeModifier(r13, r61);
        Function0 r118 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L171;
        ComposablesKt.invalidApplier();
    L171:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L174;
        r13.createNode(r118);
    L175:
        Composer r66 = Updater.constructor-impl(r13);
        Updater.set-impl(r66, r63, r112.getSetMeasurePolicy());
        Updater.set-impl(r66, r64, r112.getSetResolvedCompositionLocals());
        Function2 r67 = r112.getSetCompositeKeyHash();
        if (r66.getInserting() == false) goto L178;
    L179:
        r66.updateRememberedValue(Integer.valueOf(r117));
        r66.apply(Integer.valueOf(r117), r67);
    L180:
        Updater.set-impl(r66, r65, r112.getSetModifier());
        BoxScopeInstance r68 = BoxScopeInstance.INSTANCE;
        r27.invoke(r13, Integer.valueOf((r14 >> 3) & 14));
        r13.endNode();
        if (r29 == null) goto L195;
        r13.startReplaceGroup(1338685429);
        Modifier r69 = LayoutIdKt.layoutId(r58, TextFieldImplKt.LabelId);
        MeasurePolicy r70 = BoxKt.maybeCachedBoxMeasurePolicy(r62.getTopStart(), false);
        int r71 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r72 = r13.getCurrentCompositionLocalMap();
        Modifier r73 = ComposedModifierKt.materializeModifier(r13, r69);
        Function0 r74 = r112.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L185;
        ComposablesKt.invalidApplier();
    L185:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L188;
        r13.createNode(r74);
    L189:
        Composer r75 = Updater.constructor-impl(r13);
        Updater.set-impl(r75, r70, r112.getSetMeasurePolicy());
        Updater.set-impl(r75, r72, r112.getSetResolvedCompositionLocals());
        Function2 r76 = r112.getSetCompositeKeyHash();
        if (r75.getInserting() == false) goto L192;
    L193:
        r75.updateRememberedValue(Integer.valueOf(r71));
        r75.apply(Integer.valueOf(r71), r76);
    L194:
        Updater.set-impl(r75, r73, r112.getSetModifier());
        r29.invoke(r13, Integer.valueOf((r14 >> 9) & 14));
        r13.endNode();
        r13.endReplaceGroup();
    L196:
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L200;
        ComposerKt.traceEventEnd();
        goto L200
    L192:
        if (Intrinsics.areEqual(r75.rememberedValue(), Integer.valueOf(r71)) == true) goto L194;
    L188:
        r13.useNode();
        goto L189
    L195:
        r13.startReplaceGroup(1338768075);
        r13.endReplaceGroup();
        goto L196
    L178:
        if (Intrinsics.areEqual(r66.rememberedValue(), Integer.valueOf(r117)) == true) goto L180;
    L174:
        r13.useNode();
        goto L175
    L167:
        r13.startReplaceGroup(1338454603);
        r13.endReplaceGroup();
        goto L168
    L160:
        r59 = 0;
        goto L161
    L153:
        if (Intrinsics.areEqual(r116.rememberedValue(), Integer.valueOf(r51)) == true) goto L155;
    L149:
        r13.useNode();
        goto L150
    L156:
        r13.startReplaceGroup(1337515179);
        r13.endReplaceGroup();
        goto L157
    L138:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r44)) == true) goto L140;
    L134:
        r13.useNode();
        goto L135
    L141:
        r13.startReplaceGroup(1337224523);
        r13.endReplaceGroup();
        goto L142
    L124:
        if (Intrinsics.areEqual(r40.rememberedValue(), Integer.valueOf(r110)) == true) goto L126;
    L120:
        r13.useNode();
        goto L121
    L112:
        if (r21 != Composer.Companion.getEmpty()) goto L114;
    L108:
        r19 = false;
        goto L109
    L104:
        r18 = false;
        goto L105
    L100:
        r9 = false;
        goto L101
    L96:
        r17 = false;
        goto L98
    L84:
        if ((r8 & 3) != 2) goto L87;
        r12 = false;
        goto L89
    L76:
        if (r13.changed(r36) == false) goto L78;
        int r77 = 4;
    L79:
        r8 = r39 | r77;
        goto L82
    L78:
        r77 = 2;
        goto L79
    L5:
        if (r13.changed(r26) == false) goto L7;
        int r119 = 4;
    L8:
        r14 = r119 | r38;
        goto L11
    L7:
        r119 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$place(Placeable.PlacementScope r0, int r1, int r2, Placeable r3, Placeable r4, Placeable r5, Placeable r6, Placeable r7, Placeable r8, float r9, boolean r10, float r11, LayoutDirection r12, PaddingValues r13) {
        place(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    private static final void place(Placeable.PlacementScope r19, int r20, int r21, Placeable r22, Placeable r23, Placeable r24, Placeable r25, Placeable r26, Placeable r27, float r28, boolean r29, float r30, LayoutDirection r31, PaddingValues r32) {
        int r9 = MathKt.roundToInt(r32.mo901calculateTopPaddingD9Ej5fM() * r30);
        int r10 = MathKt.roundToInt(PaddingKt.calculateStartPadding(r32, r31) * r30);
        float r11 = TextFieldImplKt.getHorizontalIconPadding() * r30;
        if (r22 == null) goto L5;
        Placeable.PlacementScope.placeRelative$default(r19, r22, 0, Alignment.Companion.getCenterVertically().align(r22.getHeight(), r20), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        if (r23 == null) goto L7;
        Placeable.PlacementScope.placeRelative$default(r19, r23, r21 - r23.getWidth(), Alignment.Companion.getCenterVertically().align(r23.getHeight(), r20), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L7:
        if (r25 == null) goto L16;
        if (r29 == false) goto L10;
        int r1 = Alignment.Companion.getCenterVertically().align(r25.getHeight(), r20);
    L11:
        int r4 = MathHelpersKt.lerp(r1, -(r25.getHeight() / 2), r28);
        if (r22 != null) goto L14;
        float r2 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L15:
        Placeable.PlacementScope.placeRelative$default(r19, r25, MathKt.roundToInt(r2) + r10, r4, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        goto L16
    L14:
        r2 = (TextFieldImplKt.widthOrZero(r22) - r11) * (1 - r28);
        goto L15
    L10:
        r1 = r9;
    L16:
        if (r29 == false) goto L18;
        int r3 = Alignment.Companion.getCenterVertically().align(r24.getHeight(), r20);
    L19:
        Placeable.PlacementScope.placeRelative$default(r19, r24, TextFieldImplKt.widthOrZero(r22), Math.max(r3, TextFieldImplKt.heightOrZero(r25) / 2), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        if (r26 == null) goto L24;
        if (r29 == false) goto L23;
        r9 = Alignment.Companion.getCenterVertically().align(r26.getHeight(), r20);
    L23:
        Placeable.PlacementScope.placeRelative$default(r19, r26, TextFieldImplKt.widthOrZero(r22), Math.max(r9, TextFieldImplKt.heightOrZero(r25) / 2), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
    L24:
        Placeable.PlacementScope.place-70tqf50$default(r19, r27, IntOffset.Companion.getZero-nOcc-ac(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
        return;
    L18:
        r3 = r9;
        goto L19
    }

    public static final void OutlinedTextField(final TextFieldState r69, Modifier r70, boolean r71, boolean r72, TextStyle r73, Function2<? super Composer, ? super Integer, Unit> r74, Function2<? super Composer, ? super Integer, Unit> r75, Function2<? super Composer, ? super Integer, Unit> r76, Function2<? super Composer, ? super Integer, Unit> r77, boolean r78, InputTransformation r79, OutputTransformation r80, KeyboardOptions r81, KeyboardActionHandler r82, TextFieldLineLimits r83, ScrollState r84, Shape r85, TextFieldColors r86, MutableInteractionSource r87, Composer r88, final int r89, final int r90, final int r91) {
        Composer r0 = r88.startRestartGroup(1708163690);
        if ((r91 & 1) == 0) goto L6;
        int r4 = r89 | 6;
    L13:
        int r5 = r91 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r91 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r16 = r91 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r20 = 8192;
        if ((r89 & 24576) != 0) goto L57;
        if ((r91 & 16) != 0) goto L54;
        if (r0.changed(r73) == false) goto L54;
        int r22 = 16384;
    L55:
        r4 = r4 | r22;
    L54:
        r22 = 8192;
    L57:
        int r23 = r91 & 32;
        if (r23 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r27 = r91 & 64;
        if (r27 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r10 = r91 & 128;
        if (r10 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r91 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r91 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r91 & 1024;
        if (r3 == 0) goto L111;
        int r19 = r90 | 6;
    L118:
        int r6 = r91 & 2048;
        if (r6 == 0) goto L122;
        r19 = r19 | 48;
    L128:
        int r7 = r19;
        int r8 = r91 & 4096;
        if (r8 == 0) goto L132;
        r7 = r7 | 384;
    L139:
        int r11 = r91 & 8192;
        if (r11 == 0) goto L143;
        r7 = r7 | 3072;
    L151:
        if ((r90 & 24576) != 0) goto L161;
        if ((r91 & 16384) != 0) goto L158;
        if (r0.changed(r83) == false) goto L158;
        r20 = 16384;
    L158:
        r7 = r7 | r20;
    L161:
        if ((r90 & 196608) != 0) goto L171;
        if ((r91 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L165;
    L167:
        int r18 = 65536;
    L168:
        r7 = r7 | r18;
        goto L171
    L165:
        if (r0.changed(r84) == false) goto L167;
        r18 = 131072;
    L171:
        if ((r90 & 1572864) != 0) goto L181;
        if ((r91 & 65536) == 0) goto L175;
    L177:
        int r110 = 524288;
    L178:
        r7 = r7 | r110;
        goto L181
    L175:
        if (r0.changed(r85) == false) goto L177;
        r110 = 1048576;
    L181:
        if ((r90 & 12582912) != 0) goto L190;
        if ((r91 & 131072) == 0) goto L185;
    L187:
        int r111 = 4194304;
    L188:
        r7 = r7 | r111;
        goto L190
    L185:
        if (r0.changed(r86) == false) goto L187;
        r111 = 8388608;
    L190:
        int r64 = r91 & 262144;
        if (r64 == 0) goto L194;
        r7 = r7 | 100663296;
    L201:
        if ((r4 & 306783379) == 306783378) goto L203;
    L206:
        boolean r12 = true;
    L208:
        if (r0.shouldExecute(r12, r4 & 1) == false) goto L319;
        r0.startDefaults();
        if ((r89 & 1) != 0) goto L212;
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
        if ((r91 & 16) == 0) goto L242;
        TextStyle r112 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-57345);
    L243:
        if (r23 == 0) goto L245;
        Function2<? super Composer, ? super Integer, Unit> r65 = null;
    L246:
        if (r27 == 0) goto L248;
        Function2<? super Composer, ? super Integer, Unit> r66 = null;
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
        KeyboardActionHandler r67 = null;
    L271:
        if ((r91 & 16384) == 0) goto L273;
        TextFieldLineLimits r114 = TextFieldLineLimits.Companion.getDefault();
        r7 = r7 & (-57345);
    L274:
        Function2<? super Composer, ? super Integer, Unit> r710 = r21;
        boolean r711 = r24;
        if ((r91 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L277;
        r7 = r7 & (-458753);
        ScrollState r29 = ScrollKt.rememberScrollState(0, r0, 0, 1);
    L279:
        if ((r91 & 65536) == 0) goto L281;
        Shape r30 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(r0, 6);
        r7 = r7 & (-3670017);
    L283:
        if ((r91 & 131072) == 0) goto L285;
        TextFieldColors r31 = TextFieldDefaults.INSTANCE.m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        r7 = r7 & (-29360129);
    L286:
        ScrollState r32 = r29;
        if (r64 == 0) goto L289;
        MutableInteractionSource r210 = null;
    L290:
        boolean r33 = r711;
        Shape r34 = r30;
        Function2<? super Composer, ? super Integer, Unit> r35 = r710;
    L291:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L295;
        ComposerKt.traceEventStart(1708163690, r4, r7, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:178)");
    L295:
        if (r210 != null) goto L300;
        r0.startReplaceGroup(1133021489);
        Object r36 = r0.rememberedValue();
        if (r36 != Composer.Companion.getEmpty()) goto L299;
        r36 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r36);
    L299:
        MutableInteractionSource r37 = (MutableInteractionSource) r36;
        r0.endReplaceGroup();
    L301:
        r0.startReplaceGroup(867838168);
        long r115 = r112.getColor-0d7_KjU();
        if (r115 == 16) goto L304;
        boolean r38 = true;
    L305:
        if (r38 == true) goto L308;
        r115 = ((Color) r31.textColor(r14, r0, ((r4 >> 6) & 14) | ((r7 >> 18) & 112)).getValue()).unbox-impl();
    L308:
        r0.endReplaceGroup();
        TextStyle r39 = r112.merge(new TextStyle(r115, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        TextStyle r310 = r112;
        Density r116 = (Density) r0.consume(CompositionLocalsKt.getLocalDensity());
        if (r65 == null) goto L314;
        r0.startReplaceGroup(1133492751);
        Modifier.Companion r40 = Modifier.Companion;
        Object r117 = r0.rememberedValue();
        if (r117 != Composer.Companion.getEmpty()) goto L313;
        r117 = new o7();
        r0.updateRememberedValue(r117);
    L313:
        Modifier r41 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r40, true, (Function1) r117), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r116.toDp-GaN1DYA(OutlinedTextFieldTopPadding), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 13, null);
        r0.endReplaceGroup();
    L315:
        Modifier r42 = TextFieldImplKt.defaultErrorSemantics(r13.then(r41), r33, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6));
        TextFieldDefaults r43 = TextFieldDefaults.INSTANCE;
        Modifier r44 = SizeKt.m998defaultMinSizeVpY3zN4(r42, r43.m2214getMinWidthD9Ej5fM(), r43.m2213getMinHeightD9Ej5fM());
        SolidColor r45 = new SolidColor(((Color) r31.cursorColor(r33, r0, ((r4 >> 27) & 14) | ((r7 >> 18) & 112)).getValue()).unbox-impl(), null);
        AnonymousClass3 r118 = new AnonymousClass3(r26, r69, r114, r14, r37, r33, r65, r66, r113, r35, r34, r31);
        int r46 = ((r4 & 14) | (r4 & 896)) | (r4 & 7168);
        int r47 = r7 << 12;
        int r48 = (((r46 | (57344 & r47)) | (3670016 & r47)) | (29360128 & r47)) | (r47 & 234881024);
        int r49 = (r7 << 3) & 896;
        boolean r712 = r14;
        boolean r713 = r15;
        InputTransformation r714 = r25;
        KeyboardOptions r715 = r28;
        KeyboardActionHandler r716 = r67;
        TextFieldLineLimits r717 = r114;
        MutableInteractionSource r810 = r37;
        OutputTransformation r811 = r26;
        ScrollState r812 = r32;
        BasicTextFieldKt.BasicTextField(r69, r44, r712, r713, r714, r39, r715, r716, r717, null, r810, r45, r811, r118, r812, r0, r48, ((r7 >> 3) & 57344) | r49, 512);
        if (ComposerKt.isTraceInProgress() == false) goto L318;
        ComposerKt.traceEventEnd();
    L318:
        final Function2<? super Composer, ? super Integer, Unit> r50 = r35;
        final Function2<? super Composer, ? super Integer, Unit> r51 = r113;
        final boolean r52 = r14;
        final TextFieldColors r119 = r31;
        final TextFieldLineLimits r120 = r114;
        final MutableInteractionSource r121 = r210;
        final ScrollState r122 = r32;
        final KeyboardOptions r123 = r28;
        final InputTransformation r124 = r25;
        final boolean r53 = r15;
        final Shape r125 = r34;
        final Function2<? super Composer, ? super Integer, Unit> r54 = r66;
        final KeyboardActionHandler r126 = r67;
        final boolean r127 = r33;
        final Modifier r55 = r13;
        final OutputTransformation r128 = r26;
        final TextStyle r56 = r310;
        final Function2<? super Composer, ? super Integer, Unit> r57 = r65;
    L320:
        ScopeUpdateScope r58 = r0.endRestartGroup();
        if (r58 == null) goto L324;
        r58.updateScope(new p7(r69, r55, r52, r53, r56, r57, r54, r51, r50, r127, r124, r128, r123, r126, r120, r122, r125, r119, r121, r89, r90, r91));
        return;
    L324:
        return;
    L314:
        r0.startReplaceGroup(1133878112);
        r0.endReplaceGroup();
        r41 = Modifier.Companion;
        goto L315
    L304:
        r38 = false;
        goto L305
    L300:
        r0.startReplaceGroup(867832422);
        r0.endReplaceGroup();
        r37 = r210;
        goto L301
    L289:
        r210 = r87;
        goto L290
    L285:
        r31 = r86;
        goto L286
    L281:
        r30 = r85;
        goto L283
    L277:
        r29 = r84;
        goto L279
    L273:
        r114 = r83;
        goto L274
    L269:
        r67 = r82;
        goto L271
    L266:
        r28 = r81;
        goto L267
    L263:
        r26 = r80;
        goto L264
    L260:
        r25 = r79;
        goto L261
    L257:
        r24 = r78;
        goto L258
    L254:
        r21 = r77;
        goto L255
    L251:
        r113 = r76;
        goto L252
    L248:
        r66 = r75;
        goto L249
    L245:
        r65 = r74;
        goto L246
    L242:
        r112 = r73;
        goto L243
    L238:
        r15 = r72;
        goto L240
    L235:
        r14 = r71;
        goto L236
    L232:
        r13 = r70;
        goto L233
    L212:
        if (r0.getDefaultsInvalid() == true) goto L230;
        r0.skipToGroupEnd();
        if ((r91 & 16) == 0) goto L218;
        r4 = r4 & (-57345);
    L218:
        if ((r91 & 16384) == 0) goto L221;
        r7 = r7 & (-57345);
    L221:
        if ((32768 & r91) == 0) goto L224;
        r7 = r7 & (-458753);
    L224:
        if ((r91 & 65536) == 0) goto L227;
        r7 = r7 & (-3670017);
    L227:
        if ((r91 & 131072) == 0) goto L229;
        r7 = r7 & (-29360129);
    L229:
        r13 = r70;
        r14 = r71;
        r15 = r72;
        r112 = r73;
        r65 = r74;
        r66 = r75;
        r113 = r76;
        r35 = r77;
        r33 = r78;
        r25 = r79;
        r26 = r80;
        r28 = r81;
        r67 = r82;
        r114 = r83;
        r32 = r84;
        r31 = r86;
        r210 = r87;
        r4 = r4;
        r7 = r7;
        r34 = r85;
        goto L291
    L319:
        r0.skipToGroupEnd();
        r55 = r70;
        r52 = r71;
        r53 = r72;
        r56 = r73;
        r57 = r74;
        r54 = r75;
        r51 = r76;
        r50 = r77;
        r127 = r78;
        r124 = r79;
        r128 = r80;
        r123 = r81;
        r126 = r82;
        r120 = r83;
        r122 = r84;
        r125 = r85;
        r119 = r86;
        r121 = r87;
        goto L320
    L203:
        if ((38347923 & r7) != 38347922) goto L206;
        r12 = false;
        goto L208
    L194:
        if ((r90 & 100663296) != 0) goto L201;
        if (r0.changed(r87) == false) goto L198;
        int r129 = 67108864;
    L199:
        r7 = r7 | r129;
        goto L201
    L198:
        r129 = 33554432;
        goto L199
    L143:
        if ((r90 & 3072) != 0) goto L151;
        if (r0.changed(r82) == true) goto L148;
        r17 = 1024;
    L148:
        r7 = r7 | r17;
        goto L151
    L132:
        if ((r90 & 384) != 0) goto L139;
        if (r0.changed(r81) == false) goto L136;
        int r211 = 256;
    L137:
        r7 = r7 | r211;
        goto L139
    L136:
        r211 = 128;
        goto L137
    L122:
        if ((r90 & 48) != 0) goto L128;
        if (r0.changed(r80) == false) goto L126;
        int r212 = 32;
    L127:
        r19 = r19 | r212;
        goto L128
    L126:
        r212 = 16;
        goto L127
    L111:
        if ((r90 & 6) == 0) goto L113;
        r19 = r90;
        goto L118
    L113:
        if (r0.changed(r79) == false) goto L115;
        int r130 = 4;
    L116:
        r19 = r90 | r130;
        goto L118
    L115:
        r130 = 2;
        goto L116
    L101:
        if ((r89 & 805306368) != 0) goto L107;
        if (r0.changed(r78) == false) goto L105;
        int r311 = 536870912;
    L106:
        r4 = r4 | r311;
        goto L107
    L105:
        r311 = 268435456;
        goto L106
    L91:
        if ((r89 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r77) == false) goto L95;
        int r312 = 67108864;
    L96:
        r4 = r4 | r312;
        goto L97
    L95:
        r312 = 33554432;
        goto L96
    L81:
        if ((r89 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r76) == false) goto L85;
        int r313 = 8388608;
    L86:
        r4 = r4 | r313;
        goto L87
    L85:
        r313 = 4194304;
        goto L86
    L71:
        if ((r89 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r75) == false) goto L75;
        int r213 = 1048576;
    L76:
        r4 = r4 | r213;
        goto L77
    L75:
        r213 = 524288;
        goto L76
    L61:
        if ((r89 & 196608) != 0) goto L67;
        if (r0.changedInstance(r74) == false) goto L65;
        int r214 = 131072;
    L66:
        r4 = r4 | r214;
        goto L67
    L65:
        r214 = 65536;
        goto L66
    L39:
        if ((r89 & 3072) != 0) goto L46;
        if (r0.changed(r72) == false) goto L43;
        int r131 = 2048;
    L44:
        r4 = r4 | r131;
        goto L46
    L43:
        r131 = 1024;
        goto L44
    L28:
        if ((r89 & 384) != 0) goto L35;
        if (r0.changed(r71) == false) goto L32;
        int r132 = 256;
    L33:
        r4 = r4 | r132;
        goto L35
    L32:
        r132 = 128;
        goto L33
    L17:
        if ((r89 & 48) != 0) goto L24;
        if (r0.changed(r70) == false) goto L21;
        int r59 = 32;
    L22:
        r4 = r4 | r59;
        goto L24
    L21:
        r59 = 16;
        goto L22
    L6:
        if ((r89 & 6) == 0) goto L8;
        r4 = r89;
        goto L13
    L8:
        if (r0.changed(r69) == false) goto L10;
        int r60 = 4;
    L11:
        r4 = r60 | r89;
        goto L13
    L10:
        r60 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue r70, final Function1 r71, Modifier r72, boolean r73, boolean r74, TextStyle r75, Function2 r76, Function2 r77, Function2 r78, Function2 r79, boolean r80, VisualTransformation r81, KeyboardOptions r82, KeyboardActions r83, boolean r84, int r85, MutableInteractionSource r86, Shape r87, TextFieldColors r88, Composer r89, final int r90, final int r91, final int r92) {
        Composer r0 = r89.startRestartGroup(1710103060);
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
        Shape r32 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(r0, 6);
        r6 = (-29360129) & r6;
    L285:
        if ((262144 & r92) == 0) goto L287;
        TextFieldColors r41 = TextFieldDefaults.INSTANCE.m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        int r115 = r6 & (-234881025);
    L288:
        MutableInteractionSource r33 = r31;
    L289:
        r0.endDefaults();
        Composer r810 = r0;
        if (ComposerKt.isTraceInProgress() == false) goto L293;
        ComposerKt.traceEventStart(1710103060, r4, r115, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:642)");
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
        OutlinedTextField(r70, r71, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r35, r36, 1, r37, r38, r39, r810, (((((((((r4 & 14) | (r4 & 112)) | (r4 & 896)) | (r4 & 7168)) | (57344 & r4)) | (458752 & r4)) | (3670016 & r4)) | (29360128 & r4)) | (234881024 & r4)) | (1879048192 & r4), (((((((((r115 & 14) | 1572864) | (r115 & 112)) | (r115 & 896)) | (r115 & 7168)) | (57344 & r115)) | (458752 & r115)) | (29360128 & r34)) | (234881024 & r34)) | (r34 & 1879048192), 0);
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
        r48.updateScope(new m7(r70, r71, r44, r43, r47, r40, r42, r45, r46, r124, r126, r127, r119, r125, r120, r123, r118, r121, r122, r90, r91, r92));
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
    public static final /* synthetic */ void OutlinedTextField(final String r71, final Function1 r72, Modifier r73, boolean r74, boolean r75, TextStyle r76, Function2 r77, Function2 r78, Function2 r79, Function2 r80, boolean r81, VisualTransformation r82, KeyboardOptions r83, KeyboardActions r84, boolean r85, int r86, MutableInteractionSource r87, Shape r88, TextFieldColors r89, Composer r90, final int r91, final int r92, final int r93) {
        Composer r0 = r90.startRestartGroup(1453565505);
        if ((r93 & 1) == 0) goto L6;
        int r4 = r91 | 6;
    L14:
        if ((r93 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r93 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r12 = r93 & 8;
        int r16 = 2048;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r18 = r93 & 16;
        int r19 = 16384;
        if (r18 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r91 & 196608) != 0) goto L67;
        if ((r93 & 32) == 0) goto L62;
    L64:
        int r26 = 65536;
    L65:
        r4 = r4 | r26;
        goto L67
    L62:
        if (r0.changed(r76) == false) goto L64;
        r26 = 131072;
    L67:
        int r27 = r93 & 64;
        if (r27 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r93 & 128;
        if (r9 == 0) goto L81;
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
        int r21 = r92 | 6;
    L118:
        int r5 = r93 & 2048;
        if (r5 == 0) goto L122;
        r21 = r21 | 48;
    L128:
        int r6 = r21;
        int r7 = r93 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L139:
        int r10 = r93 & 8192;
        if (r10 == 0) goto L143;
        r6 = r6 | 3072;
    L150:
        int r11 = r93 & 16384;
        if (r11 == 0) goto L153;
        r6 = r6 | 24576;
        int r17 = r11;
    L161:
        int r110 = r93 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r110 == 0) goto L165;
        r6 = r6 | 196608;
    L171:
        int r111 = r93 & 65536;
        if (r111 == 0) goto L175;
        r6 = r6 | 1572864;
    L182:
        if ((r92 & 12582912) != 0) goto L192;
        if ((r93 & 131072) == 0) goto L186;
    L188:
        int r20 = 4194304;
    L189:
        r6 = r6 | r20;
        goto L192
    L186:
        if (r0.changed(r88) == false) goto L188;
        r20 = 8388608;
    L192:
        if ((r92 & 100663296) != 0) goto L202;
        if ((r93 & 262144) == 0) goto L196;
    L198:
        int r22 = 33554432;
    L199:
        r6 = r6 | r22;
        goto L202
    L196:
        if (r0.changed(r89) == false) goto L198;
        r22 = 67108864;
    L202:
        if ((r4 & 306783379) == 306783378) goto L204;
    L207:
        boolean r13 = true;
    L209:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L293;
        r0.startDefaults();
        if ((r91 & 1) != 0) goto L213;
    L225:
        if (r8 == 0) goto L227;
        Modifier r14 = Modifier.Companion;
    L228:
        if (r12 == 0) goto L230;
        boolean r15 = true;
    L231:
        if (r18 == 0) goto L233;
        boolean r112 = false;
    L235:
        if ((r93 & 32) == 0) goto L237;
        TextStyle r113 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L239:
        if (r27 == 0) goto L241;
        Function2 r65 = null;
    L242:
        if (r9 == 0) goto L244;
        Function2 r23 = null;
    L245:
        if (r1 == 0) goto L247;
        Function2 r24 = null;
    L248:
        if (r2 == 0) goto L250;
        Function2 r25 = null;
    L251:
        if (r3 == 0) goto L253;
        boolean r28 = false;
    L254:
        if (r5 == 0) goto L256;
        VisualTransformation r29 = VisualTransformation.Companion.getNone();
    L257:
        if (r7 == 0) goto L259;
        KeyboardOptions r30 = KeyboardOptions.Companion.getDefault();
    L260:
        if (r10 == 0) goto L262;
        KeyboardActions r114 = KeyboardActions.Companion.getDefault();
    L263:
        if (r17 == 0) goto L265;
        boolean r66 = false;
    L266:
        if (r110 == 0) goto L268;
        int r67 = Integer.MAX_VALUE;
    L269:
        Function2 r710 = r24;
        if (r111 == 0) goto L275;
        Object r31 = r0.rememberedValue();
        if (r31 != Composer.Companion.getEmpty()) goto L274;
        r31 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r31);
    L274:
        MutableInteractionSource r32 = (MutableInteractionSource) r31;
    L277:
        if ((r93 & 131072) == 0) goto L279;
        Shape r33 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(r0, 6);
        r6 = r6 & (-29360129);
    L281:
        if ((262144 & r93) == 0) goto L283;
        TextFieldColors r40 = TextFieldDefaults.INSTANCE.m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        int r115 = r6 & (-234881025);
    L284:
        MutableInteractionSource r34 = r32;
        Shape r35 = r33;
        Function2 r36 = r710;
    L285:
        r0.endDefaults();
        Composer r94 = r0;
        if (ComposerKt.isTraceInProgress() == false) goto L289;
        ComposerKt.traceEventStart(1453565505, r4, r115, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:435)");
    L289:
        int r37 = r115 << 3;
        Modifier r116 = r14;
        boolean r117 = r15;
        boolean r210 = r112;
        TextStyle r211 = r113;
        Function2 r212 = r65;
        Function2 r213 = r23;
        Function2 r214 = r36;
        Function2 r215 = r25;
        boolean r216 = r28;
        VisualTransformation r217 = r29;
        KeyboardOptions r218 = r30;
        KeyboardActions r219 = r114;
        boolean r38 = r66;
        int r39 = r67;
        MutableInteractionSource r310 = r34;
        Shape r311 = r35;
        TextFieldColors r312 = r40;
        OutlinedTextField(r71, r72, r116, r117, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r38, r39, 1, r310, r311, r312, r94, (((((((((r4 & 14) | (r4 & 112)) | (r4 & 896)) | (r4 & 7168)) | (57344 & r4)) | (458752 & r4)) | (3670016 & r4)) | (29360128 & r4)) | (234881024 & r4)) | (1879048192 & r4), (((((((((r115 & 14) | 1572864) | (r115 & 112)) | (r115 & 896)) | (r115 & 7168)) | (57344 & r115)) | (458752 & r115)) | (29360128 & r37)) | (234881024 & r37)) | (r37 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L292;
        ComposerKt.traceEventEnd();
    L292:
        final Shape r118 = r35;
        final MutableInteractionSource r119 = r34;
        final KeyboardOptions r120 = r30;
        final boolean r41 = r15;
        final TextStyle r42 = r113;
        final TextFieldColors r121 = r40;
        final Function2 r43 = r65;
        final boolean r122 = r66;
        final int r123 = r67;
        final boolean r124 = r28;
        final Modifier r44 = r14;
        final Function2 r45 = r23;
        final KeyboardActions r125 = r114;
        final Function2 r46 = r36;
        final Function2 r126 = r25;
        boolean r70 = r112;
        final VisualTransformation r127 = r29;
        final boolean r47 = r70;
    L294:
        ScopeUpdateScope r48 = r94.endRestartGroup();
        if (r48 == null) goto L298;
        r48.updateScope(new j7(r71, r72, r44, r41, r47, r42, r43, r45, r46, r126, r124, r127, r120, r125, r122, r123, r119, r118, r121, r91, r92, r93));
        return;
    L298:
        return;
    L283:
        r40 = r89;
        r115 = r6;
        goto L284
    L279:
        r33 = r88;
        goto L281
    L275:
        r32 = r87;
        goto L277
    L268:
        r67 = r86;
        goto L269
    L265:
        r66 = r85;
        goto L266
    L262:
        r114 = r84;
        goto L263
    L259:
        r30 = r83;
        goto L260
    L256:
        r29 = r82;
        goto L257
    L253:
        r28 = r81;
        goto L254
    L250:
        r25 = r80;
        goto L251
    L247:
        r24 = r79;
        goto L248
    L244:
        r23 = r78;
        goto L245
    L241:
        r65 = r77;
        goto L242
    L237:
        r113 = r76;
        goto L239
    L233:
        r112 = r75;
        goto L235
    L230:
        r15 = r74;
        goto L231
    L227:
        r14 = r73;
        goto L228
    L213:
        if (r0.getDefaultsInvalid() == true) goto L225;
        r0.skipToGroupEnd();
        if ((r93 & 32) == 0) goto L219;
        r4 = r4 & (-458753);
    L219:
        if ((r93 & 131072) == 0) goto L222;
        r6 = r6 & (-29360129);
    L222:
        if ((262144 & r93) == 0) goto L224;
        r6 = r6 & (-234881025);
    L224:
        r14 = r73;
        r15 = r74;
        r112 = r75;
        r113 = r76;
        r65 = r77;
        r23 = r78;
        r36 = r79;
        r25 = r80;
        r28 = r81;
        r29 = r82;
        r30 = r83;
        r114 = r84;
        r66 = r85;
        r67 = r86;
        r40 = r89;
        r4 = r4;
        r115 = r6;
        r34 = r87;
        r35 = r88;
        goto L285
    L293:
        r94 = r0;
        r94.skipToGroupEnd();
        r44 = r73;
        r41 = r74;
        r47 = r75;
        r42 = r76;
        r43 = r77;
        r45 = r78;
        r46 = r79;
        r126 = r80;
        r124 = r81;
        r127 = r82;
        r120 = r83;
        r125 = r84;
        r122 = r85;
        r123 = r86;
        r119 = r87;
        r118 = r88;
        r121 = r89;
        goto L294
    L204:
        if ((38347923 & r6) != 38347922) goto L207;
        r13 = false;
        goto L209
    L175:
        if ((r92 & 1572864) != 0) goto L182;
        if (r0.changed(r87) == false) goto L179;
        int r220 = 1048576;
    L180:
        r6 = r6 | r220;
        goto L182
    L179:
        r220 = 524288;
        goto L180
    L165:
        if ((r92 & 196608) != 0) goto L171;
        if (r0.changed(r86) == false) goto L169;
        int r128 = 131072;
    L170:
        r6 = r6 | r128;
        goto L171
    L169:
        r128 = 65536;
        goto L170
    L153:
        r17 = r11;
        if ((r92 & 24576) != 0) goto L161;
        if (r0.changed(r85) == true) goto L159;
        r19 = 8192;
    L159:
        r6 = r6 | r19;
        goto L161
    L143:
        if ((r92 & 3072) != 0) goto L150;
        if (r0.changed(r84) == true) goto L148;
        r16 = 1024;
    L148:
        r6 = r6 | r16;
        goto L150
    L132:
        if ((r92 & 384) != 0) goto L139;
        if (r0.changed(r83) == false) goto L136;
        int r221 = 256;
    L137:
        r6 = r6 | r221;
        goto L139
    L136:
        r221 = 128;
        goto L137
    L122:
        if ((r92 & 48) != 0) goto L128;
        if (r0.changed(r82) == false) goto L126;
        int r222 = 32;
    L127:
        r21 = r21 | r222;
        goto L128
    L126:
        r222 = 16;
        goto L127
    L111:
        if ((r92 & 6) == 0) goto L113;
        r21 = r92;
        goto L118
    L113:
        if (r0.changed(r81) == false) goto L115;
        int r223 = 4;
    L116:
        r21 = r92 | r223;
        goto L118
    L115:
        r223 = 2;
        goto L116
    L101:
        if ((r91 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r80) == false) goto L105;
        int r313 = 536870912;
    L106:
        r4 = r4 | r313;
        goto L107
    L105:
        r313 = 268435456;
        goto L106
    L91:
        if ((r91 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r79) == false) goto L95;
        int r314 = 67108864;
    L96:
        r4 = r4 | r314;
        goto L97
    L95:
        r314 = 33554432;
        goto L96
    L81:
        if ((r91 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r78) == false) goto L85;
        int r315 = 8388608;
    L86:
        r4 = r4 | r315;
        goto L87
    L85:
        r315 = 4194304;
        goto L86
    L71:
        if ((r91 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r77) == false) goto L75;
        int r224 = 1048576;
    L76:
        r4 = r4 | r224;
        goto L77
    L75:
        r224 = 524288;
        goto L76
    L50:
        if ((r91 & 24576) != 0) goto L58;
        if (r0.changed(r75) == false) goto L54;
        int r225 = 16384;
    L55:
        r4 = r4 | r225;
        goto L58
    L54:
        r225 = 8192;
        goto L55
    L39:
        if ((r91 & 3072) != 0) goto L46;
        if (r0.changed(r74) == false) goto L43;
        int r129 = 2048;
    L44:
        r4 = r4 | r129;
        goto L46
    L43:
        r129 = 1024;
        goto L44
    L28:
        if ((r91 & 384) != 0) goto L35;
        if (r0.changed(r73) == false) goto L32;
        int r130 = 256;
    L33:
        r4 = r4 | r130;
        goto L35
    L32:
        r130 = 128;
        goto L33
    L17:
        if ((r91 & 48) != 0) goto L24;
        if (r0.changedInstance(r72) == false) goto L21;
        int r49 = 32;
    L22:
        r4 = r4 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r91 & 6) == 0) goto L8;
        r4 = r91;
        goto L14
    L8:
        if (r0.changed(r71) == false) goto L10;
        int r50 = 4;
    L11:
        r4 = r50 | r91;
        goto L14
    L10:
        r50 = 2;
        goto L11
    }

    public static final void OutlinedTextField(final TextFieldValue r71, final Function1<? super TextFieldValue, Unit> r72, Modifier r73, boolean r74, boolean r75, TextStyle r76, Function2<? super Composer, ? super Integer, Unit> r77, Function2<? super Composer, ? super Integer, Unit> r78, Function2<? super Composer, ? super Integer, Unit> r79, Function2<? super Composer, ? super Integer, Unit> r80, boolean r81, VisualTransformation r82, KeyboardOptions r83, KeyboardActions r84, boolean r85, int r86, int r87, MutableInteractionSource r88, Shape r89, TextFieldColors r90, Composer r91, final int r92, final int r93, final int r94) {
        Composer r0 = r91.startRestartGroup(-365650761);
        if ((r94 & 1) == 0) goto L6;
        int r4 = r92 | 6;
    L14:
        if ((r94 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r8 = r94 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r12 = r94 & 8;
        int r16 = 1024;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r17 = r94 & 16;
        int r18 = 8192;
        if (r17 == 0) goto L50;
        r4 = r4 | 24576;
    L58:
        if ((r92 & 196608) != 0) goto L67;
        if ((r94 & 32) == 0) goto L62;
    L64:
        int r21 = 65536;
    L65:
        r4 = r4 | r21;
        goto L67
    L62:
        if (r0.changed(r76) == false) goto L64;
        r21 = 131072;
    L67:
        int r22 = r94 & 64;
        if (r22 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r9 = r94 & 128;
        if (r9 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r1 = r94 & 256;
        if (r1 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r2 = r94 & 512;
        if (r2 == 0) goto L101;
        r4 = r4 | 805306368;
    L107:
        int r3 = r94 & 1024;
        if (r3 == 0) goto L111;
        int r19 = r93 | 6;
    L118:
        int r5 = r94 & 2048;
        if (r5 == 0) goto L122;
        r19 = r19 | 48;
    L128:
        int r6 = r19;
        int r7 = r94 & 4096;
        if (r7 == 0) goto L132;
        r6 = r6 | 384;
    L140:
        if ((r93 & 3072) != 0) goto L149;
        if ((r94 & 8192) != 0) goto L147;
        if (r0.changed(r84) == false) goto L147;
        r16 = 2048;
    L147:
        r6 = r6 | r16;
    L149:
        int r10 = r94 & 16384;
        if (r10 == 0) goto L153;
        r6 = r6 | 24576;
    L160:
        if ((r93 & 196608) != 0) goto L169;
        if ((r94 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L164;
    L166:
        int r110 = 65536;
    L167:
        r6 = r6 | r110;
        goto L169
    L164:
        if (r0.changed(r86) == false) goto L166;
        r110 = 131072;
    L169:
        int r111 = r94 & 65536;
        if (r111 == 0) goto L173;
        r6 = r6 | 1572864;
    L179:
        int r112 = r94 & 131072;
        if (r112 == 0) goto L183;
        r6 = r6 | 12582912;
    L190:
        if ((r93 & 100663296) != 0) goto L200;
        if ((r94 & 262144) == 0) goto L194;
    L196:
        int r113 = 33554432;
    L197:
        r6 = r6 | r113;
        goto L200
    L194:
        if (r0.changed(r89) == false) goto L196;
        r113 = 67108864;
    L200:
        if ((r93 & 805306368) != 0) goto L209;
        if ((r94 & 524288) == 0) goto L204;
    L206:
        int r114 = 268435456;
    L207:
        r6 = r6 | r114;
        goto L209
    L204:
        if (r0.changed(r90) == false) goto L206;
        r114 = 536870912;
    L209:
        boolean r64 = false;
        if ((r4 & 306783379) == 306783378) goto L212;
    L215:
        boolean r11 = true;
    L217:
        if (r0.shouldExecute(r11, r4 & 1) == false) goto L329;
        r0.startDefaults();
        if ((r92 & 1) != 0) goto L221;
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
        if ((r94 & 32) == 0) goto L251;
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
        if ((r94 & 8192) == 0) goto L276;
        KeyboardActions r116 = new KeyboardActions(null, null, null, null, null, null, 63, null);
        r6 = r6 & (-7169);
    L277:
        if (r10 == 0) goto L279;
        boolean r66 = false;
    L281:
        if ((r94 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L286;
        if (r66 == false) goto L284;
        int r117 = -458753;
        int r118 = 1;
    L285:
        int r119 = r6 & r117;
        r86 = r118;
    L287:
        if (r111 == 0) goto L289;
        int r67 = 1;
    L290:
        if (r112 == 0) goto L292;
        MutableInteractionSource r68 = null;
    L293:
        Function2<? super Composer, ? super Integer, Unit> r710 = r23;
        if ((r94 & 262144) == 0) goto L296;
        Shape r28 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(r0, 6);
        int r29 = r119 & (-234881025);
    L298:
        if ((r94 & 524288) == 0) goto L300;
        r29 = r29 & (-1879048193);
        TextFieldColors r120 = TextFieldDefaults.INSTANCE.m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
    L301:
        Shape r30 = r28;
        r6 = r29;
        Function2<? super Composer, ? super Integer, Unit> r31 = r710;
        Function2<? super Composer, ? super Integer, Unit> r32 = r24;
    L302:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L306;
        ComposerKt.traceEventStart(-365650761, r4, r6, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:546)");
    L306:
        if (r68 != null) goto L311;
        r0.startReplaceGroup(-1063693660);
        Object r33 = r0.rememberedValue();
        if (r33 != Composer.Companion.getEmpty()) goto L310;
        r33 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r33);
    L310:
        r0.endReplaceGroup();
        MutableInteractionSource r210 = (MutableInteractionSource) r33;
    L312:
        r0.startReplaceGroup(796976389);
        long r121 = r115.getColor-0d7_KjU();
        if (r121 == 16) goto L315;
        r64 = true;
    L315:
        if (r64 == true) goto L318;
        r121 = ((Color) r120.textColor(r14, r0, ((r4 >> 9) & 14) | ((r6 >> 24) & 112)).getValue()).unbox-impl();
    L318:
        r0.endReplaceGroup();
        TextStyle r211 = r115.merge(new TextStyle(r121, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        Density r34 = (Density) r0.consume(CompositionLocalsKt.getLocalDensity());
        if (r65 == null) goto L324;
        r0.startReplaceGroup(-1063222398);
        Modifier.Companion r122 = Modifier.Companion;
        Object r123 = r0.rememberedValue();
        if (r123 != Composer.Companion.getEmpty()) goto L323;
        r123 = new k7();
        r0.updateRememberedValue(r123);
    L323:
        Modifier r35 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r122, true, (Function1) r123), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r34.toDp-GaN1DYA(OutlinedTextFieldTopPadding), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 13, null);
        r0.endReplaceGroup();
    L325:
        Modifier r36 = TextFieldImplKt.defaultErrorSemantics(r13.then(r35), r25, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6));
        TextFieldDefaults r124 = TextFieldDefaults.INSTANCE;
        Modifier r125 = SizeKt.m998defaultMinSizeVpY3zN4(r36, r124.m2214getMinWidthD9Ej5fM(), r124.m2213getMinHeightD9Ej5fM());
        int r126 = (r6 & 14) | ((r6 >> 24) & 112);
        final TextFieldColors r127 = r120;
        SolidColor r37 = new SolidColor(((Color) r127.cursorColor(r25, r0, r126).getValue()).unbox-impl(), null);
        final boolean r711 = r14;
        final boolean r712 = r66;
        final VisualTransformation r713 = r26;
        final MutableInteractionSource r714 = r210;
        final boolean r715 = r25;
        final Function2<? super Composer, ? super Integer, Unit> r810 = r65;
        final Function2<? super Composer, ? super Integer, Unit> r811 = r20;
        final Function2<? super Composer, ? super Integer, Unit> r812 = r31;
        final Function2<? super Composer, ? super Integer, Unit> r813 = r32;
        final Shape r814 = r30;
        ComposableLambda r38 = ComposableLambdaKt.rememberComposableLambda(-1881867558, true, new AnonymousClass13(r71, r711, r712, r713, r714, r715, r810, r811, r812, r813, r814, r127), r0, 54);
        int r39 = (((r4 & 14) | (r4 & 112)) | (r4 & 7168)) | (57344 & r4);
        int r128 = r6 << 12;
        boolean r129 = r14;
        boolean r212 = r15;
        KeyboardOptions r213 = r27;
        KeyboardActions r214 = r116;
        boolean r215 = r66;
        int r216 = r86;
        int r217 = r67;
        VisualTransformation r218 = r26;
        BasicTextFieldKt.BasicTextField(r71, r72, r125, r129, r212, r211, r213, r214, r215, r216, r217, r218, null, r210, r37, r38, r0, (((r39 | (3670016 & r128)) | (29360128 & r128)) | (234881024 & r128)) | (r128 & 1879048192), (((r6 >> 18) & 14) | 196608) | (r6 & 112), 4096);
        if (ComposerKt.isTraceInProgress() == false) goto L328;
        ComposerKt.traceEventEnd();
    L328:
        final int r130 = r86;
        final KeyboardActions r131 = r116;
        final KeyboardOptions r132 = r27;
        final TextStyle r40 = r115;
        final Function2<? super Composer, ? super Integer, Unit> r133 = r32;
        final Shape r134 = r30;
        final boolean r41 = r14;
        final TextFieldColors r219 = r127;
        final Function2<? super Composer, ? super Integer, Unit> r42 = r65;
        final boolean r135 = r66;
        final int r136 = r67;
        final MutableInteractionSource r137 = r68;
        final boolean r138 = r25;
        final VisualTransformation r139 = r26;
        final Modifier r43 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r44 = r20;
        final boolean r45 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r46 = r31;
    L330:
        ScopeUpdateScope r47 = r0.endRestartGroup();
        if (r47 == null) goto L334;
        r47.updateScope(new l7(r71, r72, r43, r41, r45, r40, r42, r44, r46, r133, r138, r139, r132, r131, r135, r130, r136, r137, r134, r219, r92, r93, r94));
        return;
    L334:
        return;
    L324:
        r0.startReplaceGroup(-1062837037);
        r0.endReplaceGroup();
        r35 = Modifier.Companion;
        goto L325
    L311:
        r0.startReplaceGroup(796970643);
        r0.endReplaceGroup();
        r210 = r68;
        goto L312
    L300:
        r120 = r90;
        goto L301
    L296:
        r28 = r89;
        r29 = r119;
        goto L298
    L292:
        r68 = r88;
        goto L293
    L289:
        r67 = r87;
        goto L290
    L284:
        r118 = Integer.MAX_VALUE;
        r117 = -458753;
        goto L285
    L286:
        r119 = r6;
        r86 = r86;
        goto L287
    L279:
        r66 = r85;
        goto L281
    L276:
        r116 = r84;
        goto L277
    L272:
        r27 = r83;
        goto L274
    L269:
        r26 = r82;
        goto L270
    L266:
        r25 = r81;
        goto L267
    L263:
        r24 = r80;
        goto L264
    L260:
        r23 = r79;
        goto L261
    L257:
        r20 = r78;
        goto L258
    L254:
        r65 = r77;
        goto L255
    L251:
        r115 = r76;
        goto L252
    L247:
        r15 = r75;
        goto L249
    L244:
        r14 = r74;
        goto L245
    L241:
        r13 = r73;
        goto L242
    L221:
        if (r0.getDefaultsInvalid() == true) goto L239;
        r0.skipToGroupEnd();
        if ((r94 & 32) == 0) goto L227;
        r4 = r4 & (-458753);
    L227:
        if ((r94 & 8192) == 0) goto L230;
        r6 = r6 & (-7169);
    L230:
        if ((32768 & r94) == 0) goto L233;
        r6 = r6 & (-458753);
    L233:
        if ((262144 & r94) == 0) goto L236;
        r6 = r6 & (-234881025);
    L236:
        if ((r94 & 524288) == 0) goto L238;
        r6 = r6 & (-1879048193);
    L238:
        r13 = r73;
        r14 = r74;
        r15 = r75;
        r115 = r76;
        r65 = r77;
        r20 = r78;
        r31 = r79;
        r32 = r80;
        r25 = r81;
        r26 = r82;
        r27 = r83;
        r116 = r84;
        r66 = r85;
        r67 = r87;
        r68 = r88;
        r120 = r90;
        r4 = r4;
        r30 = r89;
        goto L302
    L329:
        r0.skipToGroupEnd();
        r43 = r73;
        r41 = r74;
        r45 = r75;
        r40 = r76;
        r42 = r77;
        r44 = r78;
        r46 = r79;
        r133 = r80;
        r138 = r81;
        r139 = r82;
        r132 = r83;
        r131 = r84;
        r135 = r85;
        r130 = r86;
        r136 = r87;
        r137 = r88;
        r134 = r89;
        r219 = r90;
        goto L330
    L212:
        if ((306783379 & r6) != 306783378) goto L215;
        r11 = false;
        goto L217
    L183:
        if ((r93 & 12582912) != 0) goto L190;
        if (r0.changed(r88) == false) goto L187;
        int r140 = 8388608;
    L188:
        r6 = r6 | r140;
        goto L190
    L187:
        r140 = 4194304;
        goto L188
    L173:
        if ((r93 & 1572864) != 0) goto L179;
        if (r0.changed(r87) == false) goto L177;
        int r141 = 1048576;
    L178:
        r6 = r6 | r141;
        goto L179
    L177:
        r141 = 524288;
        goto L178
    L153:
        if ((r93 & 24576) != 0) goto L160;
        if (r0.changed(r85) == false) goto L157;
        r18 = 16384;
    L157:
        r6 = r6 | r18;
        goto L160
    L132:
        if ((r93 & 384) != 0) goto L140;
        if (r0.changed(r83) == false) goto L136;
        int r220 = 256;
    L137:
        r6 = r6 | r220;
        goto L140
    L136:
        r220 = 128;
        goto L137
    L122:
        if ((r93 & 48) != 0) goto L128;
        if (r0.changed(r82) == false) goto L126;
        int r221 = 32;
    L127:
        r19 = r19 | r221;
        goto L128
    L126:
        r221 = 16;
        goto L127
    L111:
        if ((r93 & 6) == 0) goto L113;
        r19 = r93;
        goto L118
    L113:
        if (r0.changed(r81) == false) goto L115;
        int r142 = 4;
    L116:
        r19 = r93 | r142;
        goto L118
    L115:
        r142 = 2;
        goto L116
    L101:
        if ((r92 & 805306368) != 0) goto L107;
        if (r0.changedInstance(r80) == false) goto L105;
        int r222 = 536870912;
    L106:
        r4 = r4 | r222;
        goto L107
    L105:
        r222 = 268435456;
        goto L106
    L91:
        if ((r92 & 100663296) != 0) goto L97;
        if (r0.changedInstance(r79) == false) goto L95;
        int r223 = 67108864;
    L96:
        r4 = r4 | r223;
        goto L97
    L95:
        r223 = 33554432;
        goto L96
    L81:
        if ((r92 & 12582912) != 0) goto L87;
        if (r0.changedInstance(r78) == false) goto L85;
        int r224 = 8388608;
    L86:
        r4 = r4 | r224;
        goto L87
    L85:
        r224 = 4194304;
        goto L86
    L71:
        if ((r92 & 1572864) != 0) goto L77;
        if (r0.changedInstance(r77) == false) goto L75;
        int r225 = 1048576;
    L76:
        r4 = r4 | r225;
        goto L77
    L75:
        r225 = 524288;
        goto L76
    L50:
        if ((r92 & 24576) != 0) goto L58;
        if (r0.changed(r75) == false) goto L54;
        int r226 = 16384;
    L55:
        r4 = r4 | r226;
        goto L58
    L54:
        r226 = 8192;
        goto L55
    L39:
        if ((r92 & 3072) != 0) goto L46;
        if (r0.changed(r74) == false) goto L43;
        int r143 = 2048;
    L44:
        r4 = r4 | r143;
        goto L46
    L43:
        r143 = 1024;
        goto L44
    L28:
        if ((r92 & 384) != 0) goto L35;
        if (r0.changed(r73) == false) goto L32;
        int r144 = 256;
    L33:
        r4 = r4 | r144;
        goto L35
    L32:
        r144 = 128;
        goto L33
    L17:
        if ((r92 & 48) != 0) goto L24;
        if (r0.changedInstance(r72) == false) goto L21;
        int r48 = 32;
    L22:
        r4 = r4 | r48;
        goto L24
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r92 & 6) == 0) goto L8;
        r4 = r92;
        goto L14
    L8:
        if (r0.changed(r71) == false) goto L10;
        int r49 = 4;
    L11:
        r4 = r49 | r92;
        goto L14
    L10:
        r49 = 2;
        goto L11
    }

    public static final void OutlinedTextField(final String r72, final Function1<? super String, Unit> r73, Modifier r74, boolean r75, boolean r76, TextStyle r77, Function2<? super Composer, ? super Integer, Unit> r78, Function2<? super Composer, ? super Integer, Unit> r79, Function2<? super Composer, ? super Integer, Unit> r80, Function2<? super Composer, ? super Integer, Unit> r81, boolean r82, VisualTransformation r83, KeyboardOptions r84, KeyboardActions r85, boolean r86, int r87, int r88, MutableInteractionSource r89, Shape r90, TextFieldColors r91, Composer r92, final int r93, final int r94, final int r95) {
        Composer r0 = r92.startRestartGroup(801000036);
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
        int r16 = 2048;
        if (r12 == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        int r18 = r95 & 16;
        if (r18 == 0) goto L50;
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
    L139:
        int r10 = r95 & 8192;
        if (r10 == 0) goto L143;
        r6 = r6 | 3072;
    L150:
        int r11 = r95 & 16384;
        if (r11 == 0) goto L153;
        r6 = r6 | 24576;
        int r17 = r11;
    L162:
        if ((r94 & 196608) != 0) goto L171;
        if ((r95 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        int r110 = 65536;
    L169:
        r6 = r6 | r110;
        goto L171
    L166:
        if (r0.changed(r87) == false) goto L168;
        r110 = 131072;
    L171:
        int r111 = r95 & 65536;
        if (r111 == 0) goto L175;
        r6 = r6 | 1572864;
    L181:
        int r112 = r95 & 131072;
        if (r112 == 0) goto L185;
        r6 = r6 | 12582912;
    L192:
        if ((r94 & 100663296) != 0) goto L202;
        if ((r95 & 262144) == 0) goto L196;
    L198:
        int r20 = 33554432;
    L199:
        r6 = r6 | r20;
        goto L202
    L196:
        if (r0.changed(r90) == false) goto L198;
        r20 = 67108864;
    L202:
        if ((r94 & 805306368) != 0) goto L211;
        if ((r95 & 524288) == 0) goto L206;
    L208:
        int r23 = 268435456;
    L209:
        r6 = r6 | r23;
        goto L211
    L206:
        if (r0.changed(r91) == false) goto L208;
        r23 = 536870912;
    L211:
        boolean r64 = false;
        if ((r4 & 306783379) == 306783378) goto L214;
    L217:
        boolean r13 = true;
    L219:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L326;
        r0.startDefaults();
        if ((r93 & 1) != 0) goto L223;
    L238:
        if (r8 == 0) goto L240;
        Modifier r14 = Modifier.Companion;
    L241:
        if (r12 == 0) goto L243;
        boolean r15 = true;
    L244:
        if (r18 == 0) goto L246;
        boolean r113 = false;
    L248:
        if ((r95 & 32) == 0) goto L250;
        TextStyle r114 = (TextStyle) r0.consume(TextKt.getLocalTextStyle());
        r4 = r4 & (-458753);
    L251:
        if (r22 == 0) goto L253;
        Function2<? super Composer, ? super Integer, Unit> r65 = null;
    L254:
        if (r9 == 0) goto L256;
        Function2<? super Composer, ? super Integer, Unit> r24 = null;
    L257:
        if (r1 == 0) goto L259;
        Function2<? super Composer, ? super Integer, Unit> r25 = null;
    L260:
        if (r2 == 0) goto L262;
        Function2<? super Composer, ? super Integer, Unit> r26 = null;
    L263:
        if (r3 == 0) goto L265;
        boolean r27 = false;
    L266:
        if (r5 == 0) goto L268;
        VisualTransformation r28 = VisualTransformation.Companion.getNone();
    L269:
        if (r7 == 0) goto L271;
        KeyboardOptions r29 = KeyboardOptions.Companion.getDefault();
    L272:
        if (r10 == 0) goto L274;
        KeyboardActions r66 = KeyboardActions.Companion.getDefault();
    L275:
        if (r17 == 0) goto L277;
        boolean r67 = false;
    L279:
        if ((r95 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L284;
        if (r67 == false) goto L282;
        int r115 = 1;
    L283:
        int r116 = r6 & (-458753);
        int r30 = r115;
    L285:
        if (r111 == 0) goto L287;
        int r68 = 1;
    L288:
        if (r112 == 0) goto L290;
        MutableInteractionSource r69 = null;
    L291:
        Function2<? super Composer, ? super Integer, Unit> r710 = r25;
        if ((r95 & 262144) == 0) goto L294;
        Shape r31 = TextFieldDefaults.INSTANCE.getOutlinedTextFieldShape(r0, 6);
        r116 = (-234881025) & r116;
    L296:
        if ((r95 & 524288) == 0) goto L298;
        int r117 = r4;
        int r118 = r116 & (-1879048193);
        Shape r32 = r31;
        TextFieldColors r119 = TextFieldDefaults.INSTANCE.m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r0, 0, 0, 48, 2097151);
        Function2<? super Composer, ? super Integer, Unit> r33 = r710;
        Function2<? super Composer, ? super Integer, Unit> r34 = r26;
    L299:
        r0.endDefaults();
        int r810 = r30;
        if (ComposerKt.isTraceInProgress() == false) goto L303;
        ComposerKt.traceEventStart(801000036, r117, r118, "androidx.compose.material.OutlinedTextField (OutlinedTextField.kt:339)");
    L303:
        if (r69 != null) goto L308;
        r0.startReplaceGroup(-245169385);
        Object r35 = r0.rememberedValue();
        if (r35 != Composer.Companion.getEmpty()) goto L307;
        r35 = InteractionSourceKt.MutableInteractionSource();
        r0.updateRememberedValue(r35);
    L307:
        r0.endReplaceGroup();
        MutableInteractionSource r210 = (MutableInteractionSource) r35;
    L309:
        r0.startReplaceGroup(961927730);
        long r36 = r114.getColor-0d7_KjU();
        if (r36 == 16) goto L312;
        r64 = true;
    L312:
        if (r64 == true) goto L315;
        r36 = ((Color) r119.textColor(r15, r0, ((r117 >> 9) & 14) | ((r118 >> 24) & 112)).getValue()).unbox-impl();
    L315:
        r0.endReplaceGroup();
        TextStyle r211 = r114.merge(new TextStyle(r36, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        Density r37 = (Density) r0.consume(CompositionLocalsKt.getLocalDensity());
        if (r65 == null) goto L321;
        r0.startReplaceGroup(-244698123);
        Modifier.Companion r38 = Modifier.Companion;
        Object r120 = r0.rememberedValue();
        if (r120 != Composer.Companion.getEmpty()) goto L320;
        r120 = new g7();
        r0.updateRememberedValue(r120);
    L320:
        Modifier r39 = PaddingKt.m964paddingqDBjuR0$default(SemanticsModifierKt.semantics(r38, true, (Function1) r120), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r37.toDp-GaN1DYA(OutlinedTextFieldTopPadding), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 13, null);
        r0.endReplaceGroup();
    L322:
        Modifier r40 = TextFieldImplKt.defaultErrorSemantics(r14.then(r39), r27, Strings_androidKt.m2174getString4foXLRw(Strings.Companion.m2168getDefaultErrorMessageUdPEhr4(), r0, 6));
        TextFieldDefaults r41 = TextFieldDefaults.INSTANCE;
        Modifier r121 = SizeKt.m998defaultMinSizeVpY3zN4(r40, r41.m2214getMinWidthD9Ej5fM(), r41.m2213getMinHeightD9Ej5fM());
        SolidColor r42 = new SolidColor(((Color) r119.cursorColor(r27, r0, (r118 & 14) | ((r118 >> 24) & 112)).getValue()).unbox-impl(), null);
        final boolean r711 = r15;
        final boolean r712 = r67;
        final VisualTransformation r713 = r28;
        final MutableInteractionSource r714 = r210;
        final boolean r811 = r27;
        final Function2<? super Composer, ? super Integer, Unit> r812 = r65;
        final Function2<? super Composer, ? super Integer, Unit> r813 = r24;
        final Function2<? super Composer, ? super Integer, Unit> r814 = r33;
        final Function2<? super Composer, ? super Integer, Unit> r815 = r34;
        final Shape r816 = r32;
        final TextFieldColors r817 = r119;
        ComposableLambda r310 = ComposableLambdaKt.rememberComposableLambda(-591103097, true, new AnonymousClass7(r72, r711, r712, r713, r714, r811, r812, r813, r814, r815, r816, r817), r0, 54);
        int r43 = (((r117 & 14) | (r117 & 112)) | (r117 & 7168)) | (57344 & r117);
        int r44 = r118 << 12;
        boolean r122 = r15;
        boolean r212 = r113;
        KeyboardOptions r213 = r29;
        KeyboardActions r214 = r66;
        boolean r215 = r67;
        int r216 = r68;
        VisualTransformation r217 = r28;
        BasicTextFieldKt.BasicTextField(r72, r73, r121, r122, r212, r211, r213, r214, r215, r810, r216, r217, null, r210, r42, r310, r0, (((r43 | (3670016 & r44)) | (29360128 & r44)) | (234881024 & r44)) | (r44 & 1879048192), (((r118 >> 18) & 14) | 196608) | (r118 & 112), 4096);
        if (ComposerKt.isTraceInProgress() == false) goto L325;
        ComposerKt.traceEventEnd();
    L325:
        final int r123 = r810;
        final KeyboardOptions r124 = r29;
        final TextStyle r45 = r114;
        final Function2<? super Composer, ? super Integer, Unit> r125 = r34;
        final boolean r126 = r27;
        final Shape r127 = r32;
        final Modifier r46 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r47 = r24;
        final boolean r48 = r15;
        final TextFieldColors r218 = r119;
        final Function2<? super Composer, ? super Integer, Unit> r49 = r65;
        final KeyboardActions r128 = r66;
        final boolean r129 = r67;
        final int r130 = r68;
        final MutableInteractionSource r131 = r69;
        final Function2<? super Composer, ? super Integer, Unit> r50 = r33;
        final VisualTransformation r132 = r28;
        final boolean r51 = r113;
    L327:
        ScopeUpdateScope r52 = r0.endRestartGroup();
        if (r52 == null) goto L331;
        r52.updateScope(new h7(r72, r73, r46, r48, r51, r45, r49, r47, r50, r125, r126, r132, r124, r128, r129, r123, r130, r131, r127, r218, r93, r94, r95));
        return;
    L331:
        return;
    L321:
        r0.startReplaceGroup(-244312762);
        r0.endReplaceGroup();
        r39 = Modifier.Companion;
        goto L322
    L308:
        r0.startReplaceGroup(961921984);
        r0.endReplaceGroup();
        r210 = r69;
        goto L309
    L298:
        r34 = r26;
        r117 = r4;
        r118 = r116;
        r119 = r91;
        r32 = r31;
        r33 = r710;
        goto L299
    L294:
        r31 = r90;
        goto L296
    L290:
        r69 = r89;
        goto L291
    L287:
        r68 = r88;
        goto L288
    L282:
        r115 = Integer.MAX_VALUE;
        goto L283
    L284:
        r116 = r6;
        r30 = r87;
        goto L285
    L277:
        r67 = r86;
        goto L279
    L274:
        r66 = r85;
        goto L275
    L271:
        r29 = r84;
        goto L272
    L268:
        r28 = r83;
        goto L269
    L265:
        r27 = r82;
        goto L266
    L262:
        r26 = r81;
        goto L263
    L259:
        r25 = r80;
        goto L260
    L256:
        r24 = r79;
        goto L257
    L253:
        r65 = r78;
        goto L254
    L250:
        r114 = r77;
        goto L251
    L246:
        r113 = r76;
        goto L248
    L243:
        r15 = r75;
        goto L244
    L240:
        r14 = r74;
        goto L241
    L223:
        if (r0.getDefaultsInvalid() == true) goto L238;
        r0.skipToGroupEnd();
        if ((r95 & 32) == 0) goto L229;
        r4 = r4 & (-458753);
    L229:
        if ((32768 & r95) == 0) goto L232;
        r6 = r6 & (-458753);
    L232:
        if ((262144 & r95) == 0) goto L235;
        r6 = r6 & (-234881025);
    L235:
        if ((r95 & 524288) == 0) goto L237;
        r6 = r6 & (-1879048193);
    L237:
        r14 = r74;
        r15 = r75;
        r113 = r76;
        r114 = r77;
        r65 = r78;
        r24 = r79;
        r33 = r80;
        r34 = r81;
        r27 = r82;
        r28 = r83;
        r29 = r84;
        r66 = r85;
        r67 = r86;
        r68 = r88;
        r69 = r89;
        r119 = r91;
        r117 = r4;
        r118 = r6;
        r30 = r87;
        r32 = r90;
        goto L299
    L326:
        r0.skipToGroupEnd();
        r46 = r74;
        r48 = r75;
        r51 = r76;
        r45 = r77;
        r49 = r78;
        r47 = r79;
        r50 = r80;
        r125 = r81;
        r126 = r82;
        r132 = r83;
        r124 = r84;
        r128 = r85;
        r129 = r86;
        r123 = r87;
        r130 = r88;
        r131 = r89;
        r127 = r90;
        r218 = r91;
        goto L327
    L214:
        if ((306783379 & r6) != 306783378) goto L217;
        r13 = false;
        goto L219
    L185:
        if ((r94 & 12582912) != 0) goto L192;
        if (r0.changed(r89) == false) goto L189;
        int r219 = 8388608;
    L190:
        r6 = r6 | r219;
        goto L192
    L189:
        r219 = 4194304;
        goto L190
    L175:
        if ((r94 & 1572864) != 0) goto L181;
        if (r0.changed(r88) == false) goto L179;
        int r133 = 1048576;
    L180:
        r6 = r6 | r133;
        goto L181
    L179:
        r133 = 524288;
        goto L180
    L153:
        r17 = r11;
        if ((r94 & 24576) != 0) goto L162;
        if (r0.changed(r86) == false) goto L158;
        int r134 = 16384;
    L159:
        r6 = r6 | r134;
        goto L162
    L158:
        r134 = 8192;
        goto L159
    L143:
        if ((r94 & 3072) != 0) goto L150;
        if (r0.changed(r85) == true) goto L148;
        r16 = 1024;
    L148:
        r6 = r6 | r16;
        goto L150
    L132:
        if ((r94 & 384) != 0) goto L139;
        if (r0.changed(r84) == false) goto L136;
        int r220 = 256;
    L137:
        r6 = r6 | r220;
        goto L139
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
        int r135 = 4;
    L116:
        r19 = r94 | r135;
        goto L118
    L115:
        r135 = 2;
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
        int r136 = 2048;
    L44:
        r4 = r4 | r136;
        goto L46
    L43:
        r136 = 1024;
        goto L44
    L28:
        if ((r93 & 384) != 0) goto L35;
        if (r0.changed(r74) == false) goto L32;
        int r137 = 256;
    L33:
        r4 = r4 | r137;
        goto L35
    L32:
        r137 = 128;
        goto L33
    L17:
        if ((r93 & 48) != 0) goto L24;
        if (r0.changedInstance(r73) == false) goto L21;
        int r53 = 32;
    L22:
        r4 = r4 | r53;
        goto L24
    L21:
        r53 = 16;
        goto L22
    L6:
        if ((r93 & 6) == 0) goto L8;
        r4 = r93;
        goto L14
    L8:
        if (r0.changed(r72) == false) goto L10;
        int r54 = 4;
    L11:
        r4 = r54 | r93;
        goto L14
    L10:
        r54 = 2;
        goto L11
    }
}
