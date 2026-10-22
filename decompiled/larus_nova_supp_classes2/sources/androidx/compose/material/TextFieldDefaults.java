package androidx.compose.material;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%JM\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J5\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u00104J5\u00105\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b6\u00104J5\u00107\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u0005¢\u0006\u0004\b8\u00104Já\u0001\u00109\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007¢\u0006\u0004\bP\u0010QJá\u0001\u0010R\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010S\u001a\u00020;2\b\b\u0002\u0010T\u001a\u00020;2\b\b\u0002\u0010U\u001a\u00020;2\b\b\u0002\u0010V\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007¢\u0006\u0004\bW\u0010QJÌ\u0001\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.H\u0007¢\u0006\u0002\u0010fJá\u0001\u0010g\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.2\u0013\b\u0002\u0010h\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]H\u0007¢\u0006\u0002\u0010iJÂ\u0001\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.H\u0007¢\u0006\u0002\u0010jJ×\u0001\u0010g\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020`2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\u0015\b\u0002\u0010d\u001a\u000f\u0012\u0004\u0012\u00020'\u0018\u00010\\¢\u0006\u0002\b]2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010e\u001a\u00020.2\u0013\b\u0002\u0010h\u001a\r\u0012\u0004\u0012\u00020'0\\¢\u0006\u0002\b]H\u0007¢\u0006\u0002\u0010kR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "<init>", "()V", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "IconOpacity", "", "TextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "OutlinedTextFieldShape", "getOutlinedTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "BackgroundOpacity", "UnfocusedIndicatorLineOpacity", "indicatorLine", "Landroidx/compose/ui/Modifier;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "BorderBox", "", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "textFieldWithLabelPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "end", "top", "bottom", "textFieldWithLabelPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "textFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "textFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-dx8h9Zs", "TextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldDecorationBox", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    private static final float FocusedBorderThickness = 0.0f;
    public static final TextFieldDefaults INSTANCE = null;
    public static final float IconOpacity = 0.54f;
    private static final float MinHeight = 0.0f;
    private static final float MinWidth = 0.0f;
    private static final float UnfocusedBorderThickness = 0.0f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;

    private TextFieldDefaults() {
    }

    private static final Unit BorderBox_nbWgWpA$lambda$1(TextFieldDefaults r12, boolean r13, boolean r14, InteractionSource r15, TextFieldColors r16, Shape r17, float r18, float r19, int r20, int r21, Composer r22, int r23) {
        r12.m2211BorderBoxnbWgWpA(r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextFieldDecorationBox$lambda$3(TextFieldDefaults r20, String r21, Function2 r22, boolean r23, boolean r24, VisualTransformation r25, InteractionSource r26, boolean r27, Function2 r28, Function2 r29, Function2 r30, Function2 r31, Shape r32, TextFieldColors r33, PaddingValues r34, Function2 r35, int r36, int r37, int r38, Composer r39, int r40) {
        r20.OutlinedTextFieldDecorationBox(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r39, RecomposeScopeImplKt.updateChangedFlags(r36 | 1), RecomposeScopeImplKt.updateChangedFlags(r37), r38);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedTextFieldDecorationBox$lambda$5(TextFieldDefaults r19, String r20, Function2 r21, boolean r22, boolean r23, VisualTransformation r24, InteractionSource r25, boolean r26, Function2 r27, Function2 r28, Function2 r29, Function2 r30, TextFieldColors r31, PaddingValues r32, Function2 r33, int r34, int r35, int r36, Composer r37, int r38) {
        r19.OutlinedTextFieldDecorationBox(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldDecorationBox$lambda$2(TextFieldDefaults r19, String r20, Function2 r21, boolean r22, boolean r23, VisualTransformation r24, InteractionSource r25, boolean r26, Function2 r27, Function2 r28, Function2 r29, Function2 r30, Shape r31, TextFieldColors r32, PaddingValues r33, int r34, int r35, int r36, Composer r37, int r38) {
        r19.TextFieldDecorationBox(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    private static final Unit TextFieldDecorationBox$lambda$4(TextFieldDefaults r18, String r19, Function2 r20, boolean r21, boolean r22, VisualTransformation r23, InteractionSource r24, boolean r25, Function2 r26, Function2 r27, Function2 r28, Function2 r29, TextFieldColors r30, PaddingValues r31, int r32, int r33, int r34, Composer r35, int r36) {
        r18.TextFieldDecorationBox(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r35, RecomposeScopeImplKt.updateChangedFlags(r32 | 1), RecomposeScopeImplKt.updateChangedFlags(r33), r34);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextFieldDefaults r1, String r2, Function2 r3, boolean r4, boolean r5, VisualTransformation r6, InteractionSource r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, TextFieldColors r13, PaddingValues r14, int r15, int r16, int r17, Composer r18, int r19) {
        return TextFieldDecorationBox$lambda$4(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ Unit b(TextFieldDefaults r0, boolean r1, boolean r2, InteractionSource r3, TextFieldColors r4, Shape r5, float r6, float r7, int r8, int r9, Composer r10, int r11) {
        return BorderBox_nbWgWpA$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit c(TextFieldDefaults r1, String r2, Function2 r3, boolean r4, boolean r5, VisualTransformation r6, InteractionSource r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, TextFieldColors r13, PaddingValues r14, Function2 r15, int r16, int r17, int r18, Composer r19, int r20) {
        return OutlinedTextFieldDecorationBox$lambda$5(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit d(TextFieldDefaults r1, String r2, Function2 r3, boolean r4, boolean r5, VisualTransformation r6, InteractionSource r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Shape r13, TextFieldColors r14, PaddingValues r15, Function2 r16, int r17, int r18, int r19, Composer r20, int r21) {
        return OutlinedTextFieldDecorationBox$lambda$3(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static /* synthetic */ Unit e(TextFieldDefaults r1, String r2, Function2 r3, boolean r4, boolean r5, VisualTransformation r6, InteractionSource r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Shape r13, TextFieldColors r14, PaddingValues r15, int r16, int r17, int r18, Composer r19, int r20) {
        return TextFieldDecorationBox$lambda$2(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    static {
        INSTANCE = new TextFieldDefaults();
        MinHeight = Dp.constructor-impl(56);
        MinWidth = Dp.constructor-impl(280);
        UnfocusedBorderThickness = Dp.constructor-impl(1);
        FocusedBorderThickness = Dp.constructor-impl(2);
    }

    /* JADX INFO: renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2212getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2213getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2214getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2215getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    public final Shape getOutlinedTextFieldShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1899109048, r5, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:228)");
    L5:
        CornerBasedShape r6 = MaterialTheme.INSTANCE.getShapes(r4, 6).getSmall();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getTextFieldShape(Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1117199624, r9, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:221)");
    L5:
        CornerBasedShape r10 = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(r8, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r10;
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2218outlinedTextFieldPaddinga9UjIt4(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2220textFieldWithLabelPaddinga9UjIt4(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r3, r2, r4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2221textFieldWithoutLabelPaddinga9UjIt4(float r1, float r2, float r3, float r4) {
        return PaddingKt.m956PaddingValuesa9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2208outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
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
        return r0.m2218outlinedTextFieldPaddinga9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2209textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = TextFieldImplKt.getTextFieldPadding();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = TextFieldImplKt.getTextFieldPadding();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = TextFieldKt.getFirstBaselineOffset();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = TextFieldKt.getTextFieldBottomPadding();
    L15:
        return r0.m2220textFieldWithLabelPaddinga9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2210textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
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
        return r0.m2221textFieldWithoutLabelPaddinga9UjIt4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m2216indicatorLinegv0btCI(Modifier r10, final boolean r11, final boolean r12, final InteractionSource r13, final TextFieldColors r14, final float r15, final float r16) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(r11, r12, r13, r14, r15, r16);
    L7:
        return ComposedModifierKt.composed(r10, r0, new TextFieldDefaults$indicatorLine$2(r11, r12, r13, r14, r15, r16));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2207indicatorLinegv0btCI$default(TextFieldDefaults r9, Modifier r10, boolean r11, boolean r12, InteractionSource r13, TextFieldColors r14, float r15, float r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        float r7 = FocusedBorderThickness;
    L7:
        if ((r17 & 32) == 0) goto L9;
        float r8 = UnfocusedBorderThickness;
    L11:
        return r9.m2216indicatorLinegv0btCI(r10, r11, r12, r13, r14, r7, r8);
    L9:
        r8 = r16;
        goto L11
    L5:
        r7 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    public final void m2211BorderBoxnbWgWpA(final boolean r19, final boolean r20, final InteractionSource r21, final TextFieldColors r22, Shape r23, float r24, float r25, Composer r26, final int r27, final int r28) {
        Composer r12 = r26.startRestartGroup(943754022);
        if ((r28 & 1) == 0) goto L6;
        int r1 = r27 | 6;
    L14:
        if ((r28 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r28 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r28 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r27 & 24576) == 0) goto L46;
        Shape r2 = r23;
    L55:
        if ((196608 & r27) == 0) goto L57;
        float r3 = r24;
    L66:
        if ((1572864 & r27) == 0) goto L68;
        float r4 = r25;
    L77:
        if ((r28 & 128) == 0) goto L80;
        r1 = r1 | 12582912;
    L87:
        if ((4793491 & r1) == 4793490) goto L89;
        boolean r5 = true;
    L91:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L123;
        r12.startDefaults();
        if ((r27 & 1) == 0) goto L107;
        if (r12.getDefaultsInvalid() == true) goto L107;
        r12.skipToGroupEnd();
        if ((r28 & 16) == 0) goto L101;
        r1 = r1 & (-57345);
    L101:
        if ((r28 & 32) == 0) goto L104;
        r1 = r1 & (-458753);
    L104:
        if ((r28 & 64) != 0) goto L115;
    L116:
        Shape r6 = r2;
        float r16 = r3;
        float r17 = r4;
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L119;
        ComposerKt.traceEventStart(943754022, r1, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:324)");
    L119:
        int r0 = (((r1 & 14) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168);
        int r7 = r1 >> 3;
        State r8 = TextFieldDefaultsKt.m2222access$animateBorderStrokeAsStateNuRrP5Q(r19, r20, r21, r22, r16, r17, r12, (r0 | (57344 & r7)) | (r7 & 458752));
        BoxKt.Box(BorderKt.border(Modifier.Companion, (BorderStroke) r8.getValue(), r6), r12, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L122;
        ComposerKt.traceEventEnd();
    L122:
        final Shape r9 = r6;
        final float r10 = r16;
        final float r11 = r17;
    L124:
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L128;
        r13.updateScope(new rc(this, r19, r20, r21, r22, r9, r10, r11, r27, r28));
        return;
    L128:
        return;
    L115:
        r1 = r1 & (-3670017);
    L107:
        if ((r28 & 16) == 0) goto L110;
        r2 = getOutlinedTextFieldShape(r12, (r1 >> 21) & 14);
        r1 = r1 & (-57345);
    L110:
        if ((r28 & 32) == 0) goto L113;
        r3 = FocusedBorderThickness;
        r1 = r1 & (-458753);
    L113:
        if ((r28 & 64) == 0) goto L116;
        r4 = UnfocusedBorderThickness;
        goto L115
    L123:
        r12.skipToGroupEnd();
        r9 = r2;
        r10 = r3;
        r11 = r4;
        goto L124
    L89:
        r5 = false;
        goto L91
    L80:
        if ((r27 & 12582912) != 0) goto L87;
        if (r12.changed(this) == false) goto L84;
        int r14 = 8388608;
    L85:
        r1 = r1 | r14;
        goto L87
    L84:
        r14 = 4194304;
        goto L85
    L68:
        if ((r28 & 64) != 0) goto L72;
        r4 = r25;
        if (r12.changed(r4) == false) goto L73;
        int r15 = 1048576;
    L74:
        r1 = r1 | r15;
    L73:
        r15 = 524288;
        goto L74
    L72:
        r4 = r25;
        goto L73
    L57:
        if ((r28 & 32) != 0) goto L61;
        r3 = r24;
        if (r12.changed(r3) == false) goto L62;
        int r18 = 131072;
    L63:
        r1 = r1 | r18;
    L62:
        r18 = 65536;
        goto L63
    L61:
        r3 = r24;
        goto L62
    L46:
        if ((r28 & 16) != 0) goto L50;
        r2 = r23;
        if (r12.changed(r2) == false) goto L51;
        int r29 = 16384;
    L52:
        r1 = r1 | r29;
    L51:
        r29 = 8192;
        goto L52
    L50:
        r2 = r23;
        goto L51
    L37:
        if ((r27 & 3072) != 0) goto L44;
        if (r12.changed(r22) == false) goto L41;
        int r30 = 2048;
    L42:
        r1 = r1 | r30;
        goto L44
    L41:
        r30 = 1024;
        goto L42
    L27:
        if ((r27 & 384) != 0) goto L34;
        if (r12.changed(r21) == false) goto L31;
        int r31 = 256;
    L32:
        r1 = r1 | r31;
        goto L34
    L31:
        r31 = 128;
        goto L32
    L17:
        if ((r27 & 48) != 0) goto L24;
        if (r12.changed(r20) == false) goto L21;
        int r32 = 32;
    L22:
        r1 = r1 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r1 = r27;
        goto L14
    L8:
        if (r12.changed(r19) == false) goto L10;
        int r33 = 4;
    L11:
        r1 = r33 | r27;
        goto L14
    L10:
        r33 = 2;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final /* synthetic */ void TextFieldDecorationBox(final String r58, final Function2 r59, final boolean r60, final boolean r61, final VisualTransformation r62, final InteractionSource r63, boolean r64, Function2 r65, Function2 r66, Function2 r67, Function2 r68, TextFieldColors r69, PaddingValues r70, Composer r71, final int r72, final int r73, final int r74) {
        Composer r12 = r71.startRestartGroup(-380568);
        if ((r74 & 1) == 0) goto L6;
        int r1 = r72 | 6;
    L14:
        if ((r74 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r74 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r17 = 1024;
        if ((r74 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r74 & 16) == 0) goto L49;
        r1 = r1 | 24576;
    L57:
        if ((r74 & 32) == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r20 = r74 & 64;
        if (r20 == 0) goto L70;
        r1 = r1 | 1572864;
    L76:
        int r6 = r74 & 128;
        if (r6 == 0) goto L79;
        r1 = r1 | 12582912;
        Function2 r7 = r65;
    L86:
        int r8 = r74 & 256;
        if (r8 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r2 = r74 & 512;
        if (r2 == 0) goto L100;
        r1 = r1 | 805306368;
    L106:
        int r3 = r74 & 1024;
        if (r3 == 0) goto L110;
        int r16 = r73 | 6;
    L118:
        if ((r73 & 48) != 0) goto L129;
        if ((r74 & 2048) != 0) goto L125;
        if (r12.changed(r69) == false) goto L125;
        int r21 = 32;
    L126:
        r16 = r16 | r21;
    L125:
        r21 = 16;
    L129:
        if ((r73 & 384) != 0) goto L139;
        if ((r74 & 4096) != 0) goto L136;
        if (r12.changed(r70) == false) goto L136;
        int r23 = 256;
    L137:
        r16 = r16 | r23;
    L136:
        r23 = 128;
    L139:
        int r4 = r16;
        if ((r74 & 8192) == 0) goto L143;
        r4 = r4 | 3072;
    L148:
        int r5 = r4;
        if ((306783379 & r1) == 306783378) goto L151;
    L154:
        boolean r0 = true;
    L156:
        if (r12.shouldExecute(r0, r1 & 1) == false) goto L204;
        r12.startDefaults();
        if ((r72 & 1) != 0) goto L160;
    L169:
        if (r20 == 0) goto L171;
        boolean r48 = false;
    L173:
        if (r6 == 0) goto L175;
        Function2 r49 = null;
    L176:
        if (r8 == 0) goto L178;
        Function2 r50 = null;
    L179:
        if (r2 == 0) goto L181;
        Function2 r51 = null;
    L182:
        if (r3 == 0) goto L184;
        Function2 r52 = null;
    L186:
        if ((r74 & 2048) == 0) goto L188;
        Composer r75 = r12;
        int r54 = r1;
        TextFieldColors r9 = m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r75, 0, 0, (r5 >> 6) & 112, 2097151);
        r5 = r5 & (-113);
    L190:
        if ((r74 & 4096) == 0) goto L195;
        if (r49 != null) goto L193;
        PaddingValues r10 = m2210textFieldWithoutLabelPaddinga9UjIt4$default(this, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 15, null);
    L194:
        r5 = r5 & (-897);
        TextFieldColors r19 = r9;
        PaddingValues r22 = r10;
    L196:
        r75.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L199;
        int r11 = r54;
        ComposerKt.traceEventStart(-380568, r11, r5, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:687)");
    L200:
        Composer r13 = r75;
        int r18 = (((((((((r11 & 14) | (r11 & 112)) | (r11 & 896)) | (r11 & 7168)) | (57344 & r11)) | (458752 & r11)) | (3670016 & r11)) | (29360128 & r11)) | (234881024 & r11)) | (r11 & 1879048192);
        int r14 = r5 << 3;
        boolean r15 = r48;
        Function2 r24 = r49;
        Function2 r25 = r50;
        Function2 r110 = r51;
        Function2 r111 = r52;
        Composer r26 = r13;
        TextFieldDecorationBox(r58, r59, r60, r61, r62, r63, r15, r24, r25, r110, r111, getTextFieldShape(r13, (r5 >> 9) & 14), r19, r22, r26, r18, (((r5 & 14) | (r14 & 896)) | (r14 & 7168)) | (r14 & 57344), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L203;
        ComposerKt.traceEventEnd();
    L203:
        final TextFieldColors r112 = r19;
        final PaddingValues r113 = r22;
        final boolean r27 = r48;
        final Function2 r28 = r49;
        final Function2 r114 = r50;
        final Function2 r115 = r51;
        final Function2 r116 = r52;
    L205:
        ScopeUpdateScope r117 = r26.endRestartGroup();
        if (r117 == null) goto L209;
        r117.updateScope(new sc(this, r58, r59, r60, r61, r62, r63, r27, r28, r114, r115, r116, r112, r113, r72, r73, r74));
        return;
    L209:
        return;
    L199:
        r11 = r54;
        goto L200
    L193:
        r10 = m2209textFieldWithLabelPaddinga9UjIt4$default(this, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 15, null);
        goto L194
    L195:
        r22 = r70;
        r19 = r9;
        goto L196
    L188:
        r54 = r1;
        r75 = r12;
        r9 = r69;
        goto L190
    L184:
        r52 = r68;
        goto L186
    L181:
        r51 = r67;
        goto L182
    L178:
        r50 = r66;
        goto L179
    L175:
        r49 = r7;
        goto L176
    L171:
        r48 = r64;
        goto L173
    L160:
        if (r12.getDefaultsInvalid() == true) goto L169;
        r12.skipToGroupEnd();
        if ((r74 & 2048) == 0) goto L166;
        r5 = r5 & (-113);
    L166:
        if ((r74 & 4096) == 0) goto L168;
        r5 = r5 & (-897);
    L168:
        r48 = r64;
        r50 = r66;
        r51 = r67;
        r52 = r68;
        r19 = r69;
        r22 = r70;
        r54 = r1;
        r49 = r7;
        r75 = r12;
        goto L196
    L204:
        r26 = r12;
        r26.skipToGroupEnd();
        r27 = r64;
        r114 = r66;
        r115 = r67;
        r116 = r68;
        r112 = r69;
        r113 = r70;
        r28 = r7;
        goto L205
    L151:
        if ((r5 & 1171) != 1170) goto L154;
        r0 = false;
        goto L156
    L143:
        if ((r73 & 3072) != 0) goto L148;
        if (r12.changed(this) == false) goto L147;
        r17 = 2048;
    L147:
        r4 = r4 | r17;
        goto L148
    L110:
        if ((r73 & 6) == 0) goto L112;
        r16 = r73;
        goto L118
    L112:
        if (r12.changedInstance(r68) == false) goto L114;
        int r118 = 4;
    L115:
        r16 = r73 | r118;
        goto L118
    L114:
        r118 = 2;
        goto L115
    L100:
        if ((r72 & 805306368) != 0) goto L106;
        if (r12.changedInstance(r67) == false) goto L104;
        int r29 = 536870912;
    L105:
        r1 = r1 | r29;
        goto L106
    L104:
        r29 = 268435456;
        goto L105
    L90:
        if ((r72 & 100663296) != 0) goto L96;
        if (r12.changedInstance(r66) == false) goto L94;
        int r210 = 67108864;
    L95:
        r1 = r1 | r210;
        goto L96
    L94:
        r210 = 33554432;
        goto L95
    L79:
        r7 = r65;
        if ((r72 & 12582912) != 0) goto L86;
        if (r12.changedInstance(r7) == false) goto L84;
        int r211 = 8388608;
    L85:
        r1 = r1 | r211;
        goto L86
    L84:
        r211 = 4194304;
        goto L85
    L70:
        if ((r72 & 1572864) != 0) goto L76;
        if (r12.changed(r64) == false) goto L74;
        int r212 = 1048576;
    L75:
        r1 = r1 | r212;
        goto L76
    L74:
        r212 = 524288;
        goto L75
    L60:
        if ((r72 & 196608) != 0) goto L66;
        if (r12.changed(r63) == false) goto L64;
        int r213 = 131072;
    L65:
        r1 = r1 | r213;
        goto L66
    L64:
        r213 = 65536;
        goto L65
    L49:
        if ((r72 & 24576) != 0) goto L57;
        if (r12.changed(r62) == false) goto L53;
        int r119 = 16384;
    L54:
        r1 = r1 | r119;
        goto L57
    L53:
        r119 = 8192;
        goto L54
    L38:
        if ((r72 & 3072) != 0) goto L46;
        if (r12.changed(r61) == false) goto L42;
        int r120 = 2048;
    L43:
        r1 = r1 | r120;
        goto L46
    L42:
        r120 = 1024;
        goto L43
    L27:
        if ((r72 & 384) != 0) goto L34;
        if (r12.changed(r60) == false) goto L31;
        int r121 = 256;
    L32:
        r1 = r1 | r121;
        goto L34
    L31:
        r121 = 128;
        goto L32
    L17:
        if ((r72 & 48) != 0) goto L24;
        if (r12.changedInstance(r59) == false) goto L21;
        int r30 = 32;
    L22:
        r1 = r1 | r30;
        goto L24
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r72 & 6) == 0) goto L8;
        r1 = r72;
        goto L14
    L8:
        if (r12.changed(r58) == false) goto L10;
        int r31 = 4;
    L11:
        r1 = r31 | r72;
        goto L14
    L10:
        r31 = 2;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with `shape` parameter.")
    public final /* synthetic */ void OutlinedTextFieldDecorationBox(final String r59, final Function2 r60, final boolean r61, final boolean r62, final VisualTransformation r63, final InteractionSource r64, boolean r65, Function2 r66, Function2 r67, Function2 r68, Function2 r69, TextFieldColors r70, PaddingValues r71, Function2 r72, Composer r73, final int r74, final int r75, final int r76) {
        Composer r10 = r73.startRestartGroup(-2141154809);
        if ((r76 & 1) == 0) goto L6;
        int r1 = r74 | 6;
    L14:
        if ((r76 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r16 = 256;
        if ((r76 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r18 = 1024;
        if ((r76 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r21 = 16384;
        if ((r76 & 16) == 0) goto L48;
        r1 = r1 | 24576;
    L56:
        if ((r76 & 32) == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r20 = r76 & 64;
        if (r20 == 0) goto L69;
        r1 = r1 | 1572864;
    L75:
        int r5 = r76 & 128;
        if (r5 == 0) goto L79;
        r1 = r1 | 12582912;
    L85:
        int r9 = r76 & 256;
        if (r9 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r2 = r76 & 512;
        if (r2 == 0) goto L99;
        r1 = r1 | 805306368;
    L105:
        int r3 = r76 & 1024;
        if (r3 == 0) goto L109;
        int r23 = r75 | 6;
    L117:
        if ((r75 & 48) != 0) goto L128;
        if ((r76 & 2048) != 0) goto L124;
        if (r10.changed(r70) == false) goto L124;
        int r24 = 32;
    L125:
        r23 = r23 | r24;
    L124:
        r24 = 16;
    L128:
        if ((r75 & 384) != 0) goto L138;
        if ((r76 & 4096) != 0) goto L135;
        if (r10.changed(r71) == false) goto L135;
    L136:
        r23 = r23 | r16;
    L135:
        r16 = 128;
    L138:
        int r4 = r23;
        int r15 = r76 & 8192;
        if (r15 == 0) goto L142;
        r4 = r4 | 3072;
    L149:
        if ((r76 & 16384) == 0) goto L152;
        r4 = r4 | 24576;
    L158:
        int r6 = r4;
        if ((306783379 & r1) == 306783378) goto L161;
    L164:
        boolean r0 = true;
    L166:
        if (r10.shouldExecute(r0, r1 & 1) == false) goto L215;
        r10.startDefaults();
        if ((r74 & 1) != 0) goto L170;
    L179:
        if (r20 == 0) goto L181;
        boolean r7 = false;
    L183:
        if (r5 == 0) goto L185;
        Function2 r48 = null;
    L186:
        if (r9 == 0) goto L188;
        Function2 r49 = null;
    L189:
        if (r2 == 0) goto L191;
        Function2 r50 = null;
    L192:
        if (r3 == 0) goto L194;
        Function2 r51 = null;
    L196:
        if ((r76 & 2048) == 0) goto L198;
        int r53 = r1;
        Composer r77 = r10;
        final TextFieldColors r8 = m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r77, 0, 0, (r6 >> 9) & 112, 2097151);
        r6 = r6 & (-113);
    L200:
        if ((r76 & 4096) == 0) goto L202;
        PaddingValues r11 = m2208outlinedTextFieldPaddinga9UjIt4$default(this, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 15, null);
        r6 = r6 & (-897);
    L203:
        if (r15 == 0) goto L205;
        final boolean r12 = r7;
        Composer r13 = r77;
        Function2 r25 = ComposableLambdaKt.rememberComposableLambda(-1922186815, true, new AnonymousClass3(r61, r12, r64, r8), r13, 54);
    L206:
        boolean r22 = r12;
    L207:
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L210;
        int r14 = r53;
        ComposerKt.traceEventStart(-2141154809, r14, r6, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:726)");
    L211:
        Shape r17 = getOutlinedTextFieldShape(r13, (r6 >> 12) & 14);
        int r19 = (((((((((r14 & 14) | (r14 & 112)) | (r14 & 896)) | (r14 & 7168)) | (57344 & r14)) | (458752 & r14)) | (3670016 & r14)) | (29360128 & r14)) | (234881024 & r14)) | (r14 & 1879048192);
        int r26 = r6 << 3;
        Composer r27 = r13;
        OutlinedTextFieldDecorationBox(r59, r60, r61, r62, r63, r64, r22, r48, r49, r50, r51, r17, r8, r11, r25, r27, r19, ((((r6 & 14) | (r26 & 896)) | (r26 & 7168)) | (57344 & r26)) | (r26 & 458752), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L214;
        ComposerKt.traceEventEnd();
    L214:
        final boolean r28 = r22;
        final TextFieldColors r110 = r8;
        final PaddingValues r111 = r11;
        final Function2 r112 = r25;
        final Function2 r29 = r48;
        final Function2 r113 = r49;
        final Function2 r114 = r50;
        final Function2 r115 = r51;
    L216:
        ScopeUpdateScope r30 = r27.endRestartGroup();
        if (r30 == null) goto L220;
        r30.updateScope(new tc(this, r59, r60, r61, r62, r63, r64, r28, r29, r113, r114, r115, r110, r111, r112, r74, r75, r76));
        return;
    L220:
        return;
    L210:
        r14 = r53;
        goto L211
    L205:
        r13 = r77;
        r12 = r7;
        r25 = r72;
        goto L206
    L202:
        r11 = r71;
        goto L203
    L198:
        r53 = r1;
        r77 = r10;
        r8 = r70;
        goto L200
    L194:
        r51 = r69;
        goto L196
    L191:
        r50 = r68;
        goto L192
    L188:
        r49 = r67;
        goto L189
    L185:
        r48 = r66;
        goto L186
    L181:
        r7 = r65;
        goto L183
    L170:
        if (r10.getDefaultsInvalid() == true) goto L179;
        r10.skipToGroupEnd();
        if ((r76 & 2048) == 0) goto L176;
        r6 = r6 & (-113);
    L176:
        if ((r76 & 4096) == 0) goto L178;
        r6 = r6 & (-897);
    L178:
        r22 = r65;
        r48 = r66;
        r49 = r67;
        r50 = r68;
        r51 = r69;
        r8 = r70;
        r11 = r71;
        r25 = r72;
        r53 = r1;
        r13 = r10;
        goto L207
    L215:
        r27 = r10;
        r27.skipToGroupEnd();
        r28 = r65;
        r29 = r66;
        r113 = r67;
        r114 = r68;
        r115 = r69;
        r110 = r70;
        r111 = r71;
        r112 = r72;
        goto L216
    L161:
        if ((r6 & 9363) != 9362) goto L164;
        r0 = false;
        goto L166
    L152:
        if ((r75 & 24576) != 0) goto L158;
        if (r10.changed(this) == true) goto L157;
        r21 = 8192;
    L157:
        r4 = r4 | r21;
        goto L158
    L142:
        if ((r75 & 3072) != 0) goto L149;
        if (r10.changedInstance(r72) == false) goto L146;
        r18 = 2048;
    L146:
        r4 = r4 | r18;
        goto L149
    L109:
        if ((r75 & 6) == 0) goto L111;
        r23 = r75;
        goto L117
    L111:
        if (r10.changedInstance(r69) == false) goto L113;
        int r210 = 4;
    L114:
        r23 = r75 | r210;
        goto L117
    L113:
        r210 = 2;
        goto L114
    L99:
        if ((r74 & 805306368) != 0) goto L105;
        if (r10.changedInstance(r68) == false) goto L103;
        int r211 = 536870912;
    L104:
        r1 = r1 | r211;
        goto L105
    L103:
        r211 = 268435456;
        goto L104
    L89:
        if ((r74 & 100663296) != 0) goto L95;
        if (r10.changedInstance(r67) == false) goto L93;
        int r212 = 67108864;
    L94:
        r1 = r1 | r212;
        goto L95
    L93:
        r212 = 33554432;
        goto L94
    L79:
        if ((r74 & 12582912) != 0) goto L85;
        if (r10.changedInstance(r66) == false) goto L83;
        int r213 = 8388608;
    L84:
        r1 = r1 | r213;
        goto L85
    L83:
        r213 = 4194304;
        goto L84
    L69:
        if ((r74 & 1572864) != 0) goto L75;
        if (r10.changed(r65) == false) goto L73;
        int r214 = 1048576;
    L74:
        r1 = r1 | r214;
        goto L75
    L73:
        r214 = 524288;
        goto L74
    L59:
        if ((r74 & 196608) != 0) goto L65;
        if (r10.changed(r64) == false) goto L63;
        int r215 = 131072;
    L64:
        r1 = r1 | r215;
        goto L65
    L63:
        r215 = 65536;
        goto L64
    L48:
        if ((r74 & 24576) != 0) goto L56;
        if (r10.changed(r63) == false) goto L52;
        int r216 = 16384;
    L53:
        r1 = r1 | r216;
        goto L56
    L52:
        r216 = 8192;
        goto L53
    L37:
        if ((r74 & 3072) != 0) goto L44;
        if (r10.changed(r62) == false) goto L41;
        int r217 = 2048;
    L42:
        r1 = r1 | r217;
        goto L44
    L41:
        r217 = 1024;
        goto L42
    L27:
        if ((r74 & 384) != 0) goto L33;
        if (r10.changed(r61) == false) goto L31;
        int r31 = 256;
    L32:
        r1 = r1 | r31;
        goto L33
    L31:
        r31 = 128;
        goto L32
    L17:
        if ((r74 & 48) != 0) goto L23;
        if (r10.changedInstance(r60) == false) goto L21;
        int r32 = 32;
    L22:
        r1 = r1 | r32;
        goto L23
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r74 & 6) == 0) goto L8;
        r1 = r74;
        goto L14
    L8:
        if (r10.changed(r59) == false) goto L10;
        int r33 = 4;
    L11:
        r1 = r33 | r74;
        goto L14
    L10:
        r33 = 2;
        goto L11
    }

    public final void TextFieldDecorationBox(final String r61, final Function2<? super Composer, ? super Integer, Unit> r62, final boolean r63, final boolean r64, final VisualTransformation r65, final InteractionSource r66, boolean r67, Function2<? super Composer, ? super Integer, Unit> r68, Function2<? super Composer, ? super Integer, Unit> r69, Function2<? super Composer, ? super Integer, Unit> r70, Function2<? super Composer, ? super Integer, Unit> r71, Shape r72, TextFieldColors r73, PaddingValues r74, Composer r75, final int r76, final int r77, final int r78) {
        Composer r12 = r75.startRestartGroup(2088762355);
        if ((r78 & 1) == 0) goto L6;
        int r1 = r76 | 6;
    L14:
        if ((r78 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r78 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r17 = 1024;
        if ((r78 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r19 = 16384;
        if ((r78 & 16) == 0) goto L49;
        r1 = r1 | 24576;
    L57:
        if ((r78 & 32) == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r22 = r78 & 64;
        if (r22 == 0) goto L70;
        r1 = r1 | 1572864;
    L76:
        int r6 = r78 & 128;
        if (r6 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        int r8 = r78 & 256;
        if (r8 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r2 = r78 & 512;
        if (r2 == 0) goto L100;
        r1 = r1 | 805306368;
    L106:
        int r3 = r78 & 1024;
        if (r3 == 0) goto L110;
        int r16 = r77 | 6;
    L118:
        if ((r77 & 48) != 0) goto L129;
        if ((r78 & 2048) != 0) goto L125;
        if (r12.changed(r72) == false) goto L125;
        int r23 = 32;
    L126:
        r16 = r16 | r23;
    L125:
        r23 = 16;
    L129:
        if ((r77 & 384) != 0) goto L140;
        if ((r78 & 4096) != 0) goto L136;
        if (r12.changed(r73) == false) goto L136;
        int r25 = 256;
    L137:
        r16 = r16 | r25;
    L136:
        r25 = 128;
    L140:
        if ((r77 & 3072) != 0) goto L149;
        if ((r78 & 8192) != 0) goto L147;
        if (r12.changed(r74) == false) goto L147;
        r17 = 2048;
    L147:
        r16 = r16 | r17;
    L149:
        int r4 = r16;
        if ((r78 & 16384) == 0) goto L153;
        r4 = r4 | 24576;
    L160:
        if ((306783379 & r1) == 306783378) goto L162;
    L165:
        boolean r5 = true;
    L167:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L222;
        r12.startDefaults();
        if ((r76 & 1) != 0) goto L171;
    L184:
        if (r22 == 0) goto L186;
        boolean r49 = false;
    L188:
        if (r6 == 0) goto L190;
        Function2<? super Composer, ? super Integer, Unit> r50 = null;
    L191:
        if (r8 == 0) goto L193;
        Function2<? super Composer, ? super Integer, Unit> r51 = null;
    L194:
        if (r2 == 0) goto L196;
        Function2<? super Composer, ? super Integer, Unit> r52 = null;
    L197:
        if (r3 == 0) goto L199;
        Function2<? super Composer, ? super Integer, Unit> r53 = null;
    L201:
        if ((r78 & 2048) == 0) goto L203;
        Shape r7 = getTextFieldShape(r12, (r4 >> 12) & 14);
        r4 = r4 & (-113);
        Shape r54 = r7;
    L204:
        int r9 = r4;
        if ((r78 & 4096) == 0) goto L207;
        int r55 = r1;
        Composer r56 = r12;
        TextFieldColors r0 = m2219textFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r56, 0, 0, (r9 >> 9) & 112, 2097151);
        r4 = r9 & (-897);
    L209:
        if ((r78 & 8192) != 0) goto L210;
    L183:
        PaddingValues r10 = r74;
    L214:
        r56.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L217;
        int r11 = r55;
        ComposerKt.traceEventStart(2088762355, r11, r4, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:547)");
    L218:
        int r13 = r11 << 3;
        int r14 = ((r13 & 896) | ((r13 & 112) | 6)) | ((r11 >> 3) & 7168);
        int r15 = r11 >> 9;
        int r29 = (((((r14 | (57344 & r15)) | (458752 & r15)) | (r15 & 3670016)) | ((r4 << 21) & 29360128)) | ((r11 << 15) & 234881024)) | ((r11 << 21) & 1879048192);
        int r18 = ((((r11 >> 18) & 14) | 196608) | ((r11 >> 12) & 112)) | ((r4 >> 3) & 896);
        int r20 = r4 << 6;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, r61, r62, r65, r50, r51, r52, r53, r64, r63, r49, r66, r10, r54, r0, null, r56, r29, (r18 | (r20 & 7168)) | (r20 & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L221;
        ComposerKt.traceEventEnd();
    L221:
        final TextFieldColors r110 = r0;
        final PaddingValues r111 = r10;
        final boolean r21 = r49;
        final Function2<? super Composer, ? super Integer, Unit> r24 = r50;
        final Function2<? super Composer, ? super Integer, Unit> r112 = r51;
        final Function2<? super Composer, ? super Integer, Unit> r113 = r53;
        final Shape r114 = r54;
    L223:
        ScopeUpdateScope r26 = r56.endRestartGroup();
        if (r26 == null) goto L227;
        final Function2<? super Composer, ? super Integer, Unit> r115 = r52;
        r26.updateScope(new uc(this, r61, r62, r63, r64, r65, r66, r21, r24, r112, r115, r113, r114, r110, r111, r76, r77, r78));
        return;
    L227:
        return;
    L217:
        r11 = r55;
        goto L218
    L210:
        if (r50 != null) goto L212;
        r10 = m2210textFieldWithoutLabelPaddinga9UjIt4$default(this, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 15, null);
    L213:
        r4 = r4 & (-7169);
        goto L214
    L212:
        r10 = m2209textFieldWithLabelPaddinga9UjIt4$default(this, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 15, null);
        goto L213
    L207:
        r55 = r1;
        r4 = r9;
        r56 = r12;
        r0 = r73;
        goto L209
    L203:
        r54 = r72;
        goto L204
    L199:
        r53 = r71;
        goto L201
    L196:
        r52 = r70;
        goto L197
    L193:
        r51 = r69;
        goto L194
    L190:
        r50 = r68;
        goto L191
    L186:
        r49 = r67;
        goto L188
    L171:
        if (r12.getDefaultsInvalid() == true) goto L184;
        r12.skipToGroupEnd();
        if ((r78 & 2048) == 0) goto L177;
        r4 = r4 & (-113);
    L177:
        if ((r78 & 4096) == 0) goto L180;
        r4 = r4 & (-897);
    L180:
        if ((r78 & 8192) == 0) goto L182;
        r4 = r4 & (-7169);
    L182:
        r49 = r67;
        r50 = r68;
        r51 = r69;
        r52 = r70;
        r53 = r71;
        r54 = r72;
        r0 = r73;
        r55 = r1;
        r56 = r12;
        goto L183
    L222:
        r56 = r12;
        r56.skipToGroupEnd();
        r21 = r67;
        r24 = r68;
        r112 = r69;
        r52 = r70;
        r113 = r71;
        r114 = r72;
        r110 = r73;
        r111 = r74;
        goto L223
    L162:
        if ((r4 & 9363) != 9362) goto L165;
        r5 = false;
        goto L167
    L153:
        if ((r77 & 24576) != 0) goto L160;
        if (r12.changed(this) == true) goto L158;
        r19 = 8192;
    L158:
        r4 = r4 | r19;
        goto L160
    L110:
        if ((r77 & 6) == 0) goto L112;
        r16 = r77;
        goto L118
    L112:
        if (r12.changedInstance(r71) == false) goto L114;
        int r116 = 4;
    L115:
        r16 = r77 | r116;
        goto L118
    L114:
        r116 = 2;
        goto L115
    L100:
        if ((r76 & 805306368) != 0) goto L106;
        if (r12.changedInstance(r70) == false) goto L104;
        int r27 = 536870912;
    L105:
        r1 = r1 | r27;
        goto L106
    L104:
        r27 = 268435456;
        goto L105
    L90:
        if ((r76 & 100663296) != 0) goto L96;
        if (r12.changedInstance(r69) == false) goto L94;
        int r28 = 67108864;
    L95:
        r1 = r1 | r28;
        goto L96
    L94:
        r28 = 33554432;
        goto L95
    L80:
        if ((r76 & 12582912) != 0) goto L86;
        if (r12.changedInstance(r68) == false) goto L84;
        int r210 = 8388608;
    L85:
        r1 = r1 | r210;
        goto L86
    L84:
        r210 = 4194304;
        goto L85
    L70:
        if ((r76 & 1572864) != 0) goto L76;
        if (r12.changed(r67) == false) goto L74;
        int r211 = 1048576;
    L75:
        r1 = r1 | r211;
        goto L76
    L74:
        r211 = 524288;
        goto L75
    L60:
        if ((r76 & 196608) != 0) goto L66;
        if (r12.changed(r66) == false) goto L64;
        int r212 = 131072;
    L65:
        r1 = r1 | r212;
        goto L66
    L64:
        r212 = 65536;
        goto L65
    L49:
        if ((r76 & 24576) != 0) goto L57;
        if (r12.changed(r65) == false) goto L53;
        int r213 = 16384;
    L54:
        r1 = r1 | r213;
        goto L57
    L53:
        r213 = 8192;
        goto L54
    L38:
        if ((r76 & 3072) != 0) goto L45;
        if (r12.changed(r64) == false) goto L42;
        int r117 = 2048;
    L43:
        r1 = r1 | r117;
        goto L45
    L42:
        r117 = 1024;
        goto L43
    L27:
        if ((r76 & 384) != 0) goto L34;
        if (r12.changed(r63) == false) goto L31;
        int r118 = 256;
    L32:
        r1 = r1 | r118;
        goto L34
    L31:
        r118 = 128;
        goto L32
    L17:
        if ((r76 & 48) != 0) goto L24;
        if (r12.changedInstance(r62) == false) goto L21;
        int r30 = 32;
    L22:
        r1 = r1 | r30;
        goto L24
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r76 & 6) == 0) goto L8;
        r1 = r76;
        goto L14
    L8:
        if (r12.changed(r61) == false) goto L10;
        int r31 = 4;
    L11:
        r1 = r31 | r76;
        goto L14
    L10:
        r31 = 2;
        goto L11
    }

    public final void OutlinedTextFieldDecorationBox(final String r60, final Function2<? super Composer, ? super Integer, Unit> r61, final boolean r62, final boolean r63, final VisualTransformation r64, final InteractionSource r65, boolean r66, Function2<? super Composer, ? super Integer, Unit> r67, Function2<? super Composer, ? super Integer, Unit> r68, Function2<? super Composer, ? super Integer, Unit> r69, Function2<? super Composer, ? super Integer, Unit> r70, Shape r71, TextFieldColors r72, PaddingValues r73, Function2<? super Composer, ? super Integer, Unit> r74, Composer r75, final int r76, final int r77, final int r78) {
        Composer r12 = r75.startRestartGroup(1154925202);
        if ((r78 & 1) == 0) goto L6;
        int r1 = r76 | 6;
    L14:
        if ((r78 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r78 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r17 = 1024;
        if ((r78 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r19 = 16384;
        if ((r78 & 16) == 0) goto L49;
        r1 = r1 | 24576;
    L57:
        if ((r78 & 32) == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        int r23 = r78 & 64;
        if (r23 == 0) goto L70;
        r1 = r1 | 1572864;
    L76:
        int r6 = r78 & 128;
        if (r6 == 0) goto L80;
        r1 = r1 | 12582912;
    L86:
        int r8 = r78 & 256;
        if (r8 == 0) goto L90;
        r1 = r1 | 100663296;
    L96:
        int r2 = r78 & 512;
        if (r2 == 0) goto L100;
        r1 = r1 | 805306368;
    L106:
        int r3 = r78 & 1024;
        if (r3 == 0) goto L110;
        int r16 = r77 | 6;
    L118:
        if ((r77 & 48) != 0) goto L129;
        if ((r78 & 2048) != 0) goto L125;
        if (r12.changed(r71) == false) goto L125;
        int r24 = 32;
    L126:
        r16 = r16 | r24;
    L125:
        r24 = 16;
    L129:
        if ((r77 & 384) != 0) goto L140;
        if ((r78 & 4096) != 0) goto L136;
        if (r12.changed(r72) == false) goto L136;
        int r26 = 256;
    L137:
        r16 = r16 | r26;
    L136:
        r26 = 128;
    L140:
        if ((r77 & 3072) != 0) goto L149;
        if ((r78 & 8192) != 0) goto L147;
        if (r12.changed(r73) == false) goto L147;
        r17 = 2048;
    L147:
        r16 = r16 | r17;
    L149:
        int r4 = r16;
        int r11 = r78 & 16384;
        if (r11 == 0) goto L153;
        r4 = r4 | 24576;
    L161:
        if ((r78 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L164;
        r4 = r4 | 196608;
    L171:
        if ((r1 & 306783379) == 306783378) goto L173;
    L176:
        boolean r5 = true;
    L178:
        if (r12.shouldExecute(r5, r1 & 1) == false) goto L233;
        r12.startDefaults();
        if ((r76 & 1) != 0) goto L182;
    L194:
        if (r23 == 0) goto L196;
        boolean r48 = false;
    L198:
        if (r6 == 0) goto L200;
        Function2<? super Composer, ? super Integer, Unit> r49 = null;
    L201:
        if (r8 == 0) goto L203;
        Function2<? super Composer, ? super Integer, Unit> r50 = null;
    L204:
        if (r2 == 0) goto L206;
        Function2<? super Composer, ? super Integer, Unit> r51 = null;
    L207:
        if (r3 == 0) goto L209;
        Function2<? super Composer, ? super Integer, Unit> r52 = null;
    L211:
        if ((r78 & 2048) == 0) goto L213;
        Shape r7 = getOutlinedTextFieldShape(r12, (r4 >> 15) & 14);
        r4 = r4 & (-113);
        Shape r53 = r7;
    L214:
        int r9 = r4;
        if ((r78 & 4096) == 0) goto L217;
        Composer r79 = r12;
        int r55 = r1;
        TextFieldColors r0 = m2217outlinedTextFieldColorsdx8h9Zs(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r79, 0, 0, (r9 >> 12) & 112, 2097151);
        r9 = r9 & (-897);
    L219:
        if ((r78 & 8192) == 0) goto L221;
        PaddingValues r10 = m2208outlinedTextFieldPaddinga9UjIt4$default(this, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 15, null);
        r4 = r9 & (-7169);
    L222:
        if (r11 == 0) goto L224;
        final boolean r610 = r48;
        final TextFieldColors r710 = r0;
        final Shape r711 = r53;
        Composer r13 = r79;
        Function2<? super Composer, ? super Integer, Unit> r14 = ComposableLambdaKt.rememberComposableLambda(1212923596, true, new AnonymousClass1(r62, r610, r65, r710, r711), r13, 54);
    L225:
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L228;
        int r15 = r55;
        ComposerKt.traceEventStart(1154925202, r15, r4, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:640)");
    L229:
        int r18 = r15 << 3;
        int r20 = ((r18 & 896) | ((r18 & 112) | 6)) | ((r15 >> 3) & 7168);
        int r21 = r15 >> 9;
        int r29 = (((((r20 | (57344 & r21)) | (458752 & r21)) | (r21 & 3670016)) | ((r4 << 21) & 29360128)) | ((r15 << 15) & 234881024)) | ((r15 << 21) & 1879048192);
        int r22 = (((r15 >> 18) & 14) | ((r15 >> 12) & 112)) | ((r4 >> 3) & 896);
        int r25 = r4 << 6;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, r60, r61, r64, r49, r50, r51, r52, r63, r62, r48, r65, r10, r53, r0, r14, r13, r29, ((r22 | (r25 & 7168)) | (r25 & 57344)) | ((r4 << 3) & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L232;
        ComposerKt.traceEventEnd();
    L232:
        final TextFieldColors r110 = r0;
        final PaddingValues r111 = r10;
        final Function2<? super Composer, ? super Integer, Unit> r112 = r14;
        final boolean r27 = r48;
        final Function2<? super Composer, ? super Integer, Unit> r28 = r49;
        final Function2<? super Composer, ? super Integer, Unit> r113 = r50;
        final Function2<? super Composer, ? super Integer, Unit> r114 = r52;
        final Shape r115 = r53;
    L234:
        ScopeUpdateScope r30 = r13.endRestartGroup();
        if (r30 == null) goto L238;
        final Function2<? super Composer, ? super Integer, Unit> r116 = r51;
        r30.updateScope(new qc(this, r60, r61, r62, r63, r64, r65, r27, r28, r113, r116, r114, r115, r110, r111, r112, r76, r77, r78));
        return;
    L238:
        return;
    L228:
        r15 = r55;
        goto L229
    L224:
        r13 = r79;
        r14 = r74;
        goto L225
    L221:
        r10 = r73;
        r4 = r9;
        goto L222
    L217:
        r55 = r1;
        r79 = r12;
        r0 = r72;
        goto L219
    L213:
        r53 = r71;
        goto L214
    L209:
        r52 = r70;
        goto L211
    L206:
        r51 = r69;
        goto L207
    L203:
        r50 = r68;
        goto L204
    L200:
        r49 = r67;
        goto L201
    L196:
        r48 = r66;
        goto L198
    L182:
        if (r12.getDefaultsInvalid() == true) goto L194;
        r12.skipToGroupEnd();
        if ((r78 & 2048) == 0) goto L188;
        r4 = r4 & (-113);
    L188:
        if ((r78 & 4096) == 0) goto L191;
        r4 = r4 & (-897);
    L191:
        if ((r78 & 8192) == 0) goto L193;
        r4 = r4 & (-7169);
    L193:
        r48 = r66;
        r49 = r67;
        r50 = r68;
        r51 = r69;
        r52 = r70;
        r53 = r71;
        r0 = r72;
        r14 = r74;
        r55 = r1;
        r13 = r12;
        r10 = r73;
        goto L225
    L233:
        r13 = r12;
        r13.skipToGroupEnd();
        r27 = r66;
        r28 = r67;
        r113 = r68;
        r51 = r69;
        r114 = r70;
        r115 = r71;
        r110 = r72;
        r111 = r73;
        r112 = r74;
        goto L234
    L173:
        if ((74899 & r4) != 74898) goto L176;
        r5 = false;
        goto L178
    L164:
        if ((r77 & 196608) != 0) goto L171;
        if (r12.changed(this) == false) goto L168;
        int r117 = 131072;
    L169:
        r4 = r4 | r117;
        goto L171
    L168:
        r117 = 65536;
        goto L169
    L153:
        if ((r77 & 24576) != 0) goto L161;
        if (r12.changedInstance(r74) == true) goto L158;
        r19 = 8192;
    L158:
        r4 = r4 | r19;
        goto L161
    L110:
        if ((r77 & 6) == 0) goto L112;
        r16 = r77;
        goto L118
    L112:
        if (r12.changedInstance(r70) == false) goto L114;
        int r118 = 4;
    L115:
        r16 = r77 | r118;
        goto L118
    L114:
        r118 = 2;
        goto L115
    L100:
        if ((r76 & 805306368) != 0) goto L106;
        if (r12.changedInstance(r69) == false) goto L104;
        int r210 = 536870912;
    L105:
        r1 = r1 | r210;
        goto L106
    L104:
        r210 = 268435456;
        goto L105
    L90:
        if ((r76 & 100663296) != 0) goto L96;
        if (r12.changedInstance(r68) == false) goto L94;
        int r211 = 67108864;
    L95:
        r1 = r1 | r211;
        goto L96
    L94:
        r211 = 33554432;
        goto L95
    L80:
        if ((r76 & 12582912) != 0) goto L86;
        if (r12.changedInstance(r67) == false) goto L84;
        int r212 = 8388608;
    L85:
        r1 = r1 | r212;
        goto L86
    L84:
        r212 = 4194304;
        goto L85
    L70:
        if ((r76 & 1572864) != 0) goto L76;
        if (r12.changed(r66) == false) goto L74;
        int r213 = 1048576;
    L75:
        r1 = r1 | r213;
        goto L76
    L74:
        r213 = 524288;
        goto L75
    L60:
        if ((r76 & 196608) != 0) goto L66;
        if (r12.changed(r65) == false) goto L64;
        int r214 = 131072;
    L65:
        r1 = r1 | r214;
        goto L66
    L64:
        r214 = 65536;
        goto L65
    L49:
        if ((r76 & 24576) != 0) goto L57;
        if (r12.changed(r64) == false) goto L53;
        int r215 = 16384;
    L54:
        r1 = r1 | r215;
        goto L57
    L53:
        r215 = 8192;
        goto L54
    L38:
        if ((r76 & 3072) != 0) goto L45;
        if (r12.changed(r63) == false) goto L42;
        int r119 = 2048;
    L43:
        r1 = r1 | r119;
        goto L45
    L42:
        r119 = 1024;
        goto L43
    L27:
        if ((r76 & 384) != 0) goto L34;
        if (r12.changed(r62) == false) goto L31;
        int r120 = 256;
    L32:
        r1 = r1 | r120;
        goto L34
    L31:
        r120 = 128;
        goto L32
    L17:
        if ((r76 & 48) != 0) goto L24;
        if (r12.changedInstance(r61) == false) goto L21;
        int r31 = 32;
    L22:
        r1 = r1 | r31;
        goto L24
    L21:
        r31 = 16;
        goto L22
    L6:
        if ((r76 & 6) == 0) goto L8;
        r1 = r76;
        goto L14
    L8:
        if (r12.changed(r60) == false) goto L10;
        int r32 = 4;
    L11:
        r1 = r32 | r76;
        goto L14
    L10:
        r32 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m2217outlinedTextFieldColorsdx8h9Zs(long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, Composer r81, int r82, int r83, int r84, int r85) {
        if ((r85 & 1) == 0) goto L5;
        long r2 = Color.copy-wmQWz5c$default(((Color) r81.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r81.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L7:
        if ((r85 & 2) == 0) goto L9;
        float r6 = ContentAlpha.INSTANCE.getDisabled(r81, 6);
        long r4 = Color.copy-wmQWz5c$default(r2, r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r85 & 4) == 0) goto L13;
        long r7 = Color.Companion.getTransparent-0d7_KjU();
    L15:
        if ((r85 & 8) == 0) goto L17;
        long r8 = MaterialTheme.INSTANCE.getColors(r81, 6).m1999getPrimary0d7_KjU();
    L19:
        if ((r85 & 16) == 0) goto L21;
        long r10 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L23:
        if ((r85 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r85 & 64) == 0) goto L29;
        long r9 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if ((r85 & 128) == 0) goto L33;
        long r310 = r9;
        long r15 = Color.copy-wmQWz5c$default(r310, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r85 & 256) == 0) goto L37;
        int r16 = 6;
        long r21 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L39:
        if ((r85 & 512) == 0) goto L41;
        long r17 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, r16).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L43:
        if ((r85 & 1024) == 0) goto L45;
        long r40 = r17;
        long r11 = Color.copy-wmQWz5c$default(r40, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L47:
        if ((r85 & 2048) == 0) goto L49;
        long r23 = r17;
    L51:
        if ((r85 & 4096) == 0) goto L53;
        long r12 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L55:
        if ((r85 & 8192) == 0) goto L57;
        long r42 = r12;
        long r18 = Color.copy-wmQWz5c$default(r42, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r85 & 16384) == 0) goto L61;
        int r19 = 6;
        long r25 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L63:
        if ((32768 & r85) == 0) goto L65;
        long r110 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, r19).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r81, r19), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L67:
        if ((65536 & r85) == 0) goto L69;
        long r111 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r85) == 0) goto L73;
        long r44 = r111;
        long r14 = Color.copy-wmQWz5c$default(r44, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L75:
        if ((262144 & r85) == 0) goto L77;
        int r20 = 6;
        long r31 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L79:
        if ((524288 & r85) == 0) goto L81;
        long r22 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, r20).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r81, r20), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L83:
        if ((r85 & 1048576) == 0) goto L85;
        long r46 = r22;
        long r0 = Color.copy-wmQWz5c$default(r46, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventStart(1762667317, r82, r83, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:451)");
    L90:
        DefaultTextFieldColors r1 = new DefaultTextFieldColors(r2, r4, r8, r10, r13, r9, r21, r15, r17, r11, r23, r12, r18, r25, r7, r110, r111, r14, r31, r22, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
    L93:
        return r1;
    L85:
        r0 = r79;
        goto L87
    L81:
        r22 = r77;
        goto L83
    L77:
        r20 = 6;
        r31 = r75;
        goto L79
    L73:
        r14 = r73;
        goto L75
    L69:
        r111 = r71;
        goto L71
    L65:
        r110 = r69;
        goto L67
    L61:
        r19 = 6;
        r25 = r67;
        goto L63
    L57:
        r18 = r65;
        goto L59
    L53:
        r12 = r63;
        goto L55
    L49:
        r23 = r61;
        goto L51
    L45:
        r11 = r59;
        goto L47
    L41:
        r17 = r57;
        goto L43
    L37:
        r16 = 6;
        r21 = r55;
        goto L39
    L33:
        r15 = r53;
        goto L35
    L29:
        r9 = r51;
        goto L31
    L25:
        r13 = r49;
        goto L27
    L21:
        r10 = r47;
        goto L23
    L17:
        r8 = r45;
        goto L19
    L13:
        r7 = r43;
        goto L15
    L9:
        r4 = r41;
        goto L11
    L5:
        r2 = r39;
        goto L7
    }

    /* JADX INFO: renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m2219textFieldColorsdx8h9Zs(long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, Composer r81, int r82, int r83, int r84, int r85) {
        if ((r85 & 1) == 0) goto L5;
        long r2 = Color.copy-wmQWz5c$default(((Color) r81.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), ((Number) r81.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L7:
        if ((r85 & 2) == 0) goto L9;
        float r6 = ContentAlpha.INSTANCE.getDisabled(r81, 6);
        long r4 = Color.copy-wmQWz5c$default(r2, r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r85 & 4) == 0) goto L13;
        long r7 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r85 & 8) == 0) goto L17;
        long r8 = MaterialTheme.INSTANCE.getColors(r81, 6).m1999getPrimary0d7_KjU();
    L19:
        if ((r85 & 16) == 0) goto L21;
        long r10 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L23:
        if ((r85 & 32) == 0) goto L25;
        long r13 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L27:
        if ((r85 & 64) == 0) goto L29;
        long r15 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), 0.42f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if ((r85 & 128) == 0) goto L33;
        long r310 = r15;
        long r9 = Color.copy-wmQWz5c$default(r310, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r85 & 256) == 0) goto L37;
        int r11 = 6;
        long r21 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L39:
        if ((r85 & 512) == 0) goto L41;
        long r12 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, r11).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L43:
        if ((r85 & 1024) == 0) goto L45;
        long r311 = r12;
        long r16 = Color.copy-wmQWz5c$default(r311, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L47:
        if ((r85 & 2048) == 0) goto L49;
        long r23 = r12;
    L51:
        if ((r85 & 4096) == 0) goto L53;
        long r17 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), 0.54f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L55:
        if ((r85 & 8192) == 0) goto L57;
        long r312 = r17;
        long r14 = Color.copy-wmQWz5c$default(r312, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r85 & 16384) == 0) goto L61;
        int r18 = 6;
        long r25 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L63:
        if ((32768 & r85) == 0) goto L65;
        long r19 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, r18).m1999getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(r81, r18), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L67:
        if ((65536 & r85) == 0) goto L69;
        long r20 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, 6).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r85) == 0) goto L73;
        long r313 = r20;
        long r110 = Color.copy-wmQWz5c$default(r313, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L75:
        if ((262144 & r85) == 0) goto L77;
        int r111 = 6;
        long r31 = MaterialTheme.INSTANCE.getColors(r81, 6).m1993getError0d7_KjU();
    L79:
        if ((524288 & r85) == 0) goto L81;
        long r112 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(r81, r111).m1998getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(r81, r111), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L83:
        if ((r85 & 1048576) == 0) goto L85;
        long r314 = r112;
        long r0 = Color.copy-wmQWz5c$default(r314, ContentAlpha.INSTANCE.getDisabled(r81, 6), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventStart(231892599, r82, r83, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:397)");
    L90:
        DefaultTextFieldColors r1 = new DefaultTextFieldColors(r2, r4, r8, r10, r13, r15, r21, r9, r12, r16, r23, r17, r14, r25, r7, r19, r20, r110, r31, r112, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
    L93:
        return r1;
    L85:
        r0 = r79;
        goto L87
    L81:
        r112 = r77;
        goto L83
    L77:
        r111 = 6;
        r31 = r75;
        goto L79
    L73:
        r110 = r73;
        goto L75
    L69:
        r20 = r71;
        goto L71
    L65:
        r19 = r69;
        goto L67
    L61:
        r18 = 6;
        r25 = r67;
        goto L63
    L57:
        r14 = r65;
        goto L59
    L53:
        r17 = r63;
        goto L55
    L49:
        r23 = r61;
        goto L51
    L45:
        r16 = r59;
        goto L47
    L41:
        r12 = r57;
        goto L43
    L37:
        r11 = 6;
        r21 = r55;
        goto L39
    L33:
        r9 = r53;
        goto L35
    L29:
        r15 = r51;
        goto L31
    L25:
        r13 = r49;
        goto L27
    L21:
        r10 = r47;
        goto L23
    L17:
        r8 = r45;
        goto L19
    L13:
        r7 = r43;
        goto L15
    L9:
        r4 = r41;
        goto L11
    L5:
        r2 = r39;
        goto L7
    }
}
