package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ExtendedFabLargeTokens;
import androidx.compose.material3.tokens.ExtendedFabMediumTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.ExtendedFabSmallTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001an\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u0012\u001an\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u0012\u001ay\u0010\u001e\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001f¢\u0006\u0002\b\u0010¢\u0006\u0002\b!H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u008b\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b(\u0010)\u001a»\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003¢\u0006\u0004\b-\u0010.\u001a\r\u0010G\u001a\u00020HH\u0003¢\u0006\u0002\u0010I\u001a\r\u0010J\u001a\u00020KH\u0003¢\u0006\u0002\u0010L\"\u0010\u0010/\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00107\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00108\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00109\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010:\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010;\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u0010<\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010=\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010>\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010?\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010@\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010A\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000e\u0010B\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010C\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010D\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010E\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010F\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006M"}, d2 = {"FloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "FloatingActionButton-lF-WlFE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "ExtendedFloatingActionButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "startPadding", "endPadding", "iconPadding", "ExtendedFloatingActionButton-qtIzBjc", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFFFFLandroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SmallExtendedFabMinimumWidth", "F", "SmallExtendedFabMinimumHeight", "SmallExtendedFabPaddingStart", "SmallExtendedFabPaddingEnd", "SmallExtendedFabIconPadding", "SmallExtendedFabTextStyle", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "MediumExtendedFabMinimumWidth", "MediumExtendedFabMinimumHeight", "MediumExtendedFabPaddingStart", "MediumExtendedFabPaddingEnd", "MediumExtendedFabIconPadding", "MediumExtendedFabTextStyle", "LargeExtendedFabMinimumWidth", "LargeExtendedFabMinimumHeight", "LargeExtendedFabPaddingStart", "LargeExtendedFabPaddingEnd", "LargeExtendedFabIconPadding", "LargeExtendedFabTextStyle", "ExtendedFabStartIconPadding", "ExtendedFabEndIconPadding", "ExtendedFabTextPadding", "ExtendedFabMinimumWidth", "extendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "extendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float ExtendedFabEndIconPadding = 0.0f;
    private static final float ExtendedFabMinimumWidth = 0.0f;
    private static final float ExtendedFabStartIconPadding = 0.0f;
    private static final float ExtendedFabTextPadding = 0.0f;
    private static final float LargeExtendedFabIconPadding = 0.0f;
    private static final float LargeExtendedFabMinimumHeight = 0.0f;
    private static final float LargeExtendedFabMinimumWidth = 0.0f;
    private static final float LargeExtendedFabPaddingEnd = 0.0f;
    private static final float LargeExtendedFabPaddingStart = 0.0f;
    private static final TypographyKeyTokens LargeExtendedFabTextStyle = null;
    private static final float MediumExtendedFabIconPadding = 0.0f;
    private static final float MediumExtendedFabMinimumHeight = 0.0f;
    private static final float MediumExtendedFabMinimumWidth = 0.0f;
    private static final float MediumExtendedFabPaddingEnd = 0.0f;
    private static final float MediumExtendedFabPaddingStart = 0.0f;
    private static final TypographyKeyTokens MediumExtendedFabTextStyle = null;
    private static final float SmallExtendedFabIconPadding = 0.0f;
    private static final float SmallExtendedFabMinimumHeight = 0.0f;
    private static final float SmallExtendedFabMinimumWidth = 0.0f;
    private static final float SmallExtendedFabPaddingEnd = 0.0f;
    private static final float SmallExtendedFabPaddingStart = 0.0f;
    private static final TypographyKeyTokens SmallExtendedFabTextStyle = null;

    private static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$8(Function2 r16, Function2 r17, Function0 r18, Modifier r19, boolean r20, Shape r21, long r22, long r24, FloatingActionButtonElevation r26, MutableInteractionSource r27, int r28, int r29, Composer r30, int r31) {
        m2726ExtendedFloatingActionButtonElI57k(r16, r17, r18, r19, r20, r21, r22, r24, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit ExtendedFloatingActionButton_X_z6DiA$lambda$7(Function0 r14, Modifier r15, Shape r16, long r17, long r19, FloatingActionButtonElevation r21, MutableInteractionSource r22, Function3 r23, int r24, int r25, Composer r26, int r27) {
        m2727ExtendedFloatingActionButtonXz6DiA(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$9(Function2 r22, Function2 r23, Function0 r24, TextStyle r25, float r26, float r27, float r28, float r29, float r30, Modifier r31, boolean r32, Shape r33, long r34, long r36, FloatingActionButtonElevation r38, MutableInteractionSource r39, int r40, int r41, int r42, Composer r43, int r44) {
        m2728ExtendedFloatingActionButtonqtIzBjc(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r36, r38, r39, r43, RecomposeScopeImplKt.updateChangedFlags(r40 | 1), RecomposeScopeImplKt.updateChangedFlags(r41), r42);
        return Unit.INSTANCE;
    }

    private static final Unit FloatingActionButton_X_z6DiA$lambda$0(Function0 r14, Modifier r15, Shape r16, long r17, long r19, FloatingActionButtonElevation r21, MutableInteractionSource r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m2729FloatingActionButtonXz6DiA(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit FloatingActionButton_lF_WlFE$lambda$4(Function0 r17, TextStyle r18, float r19, float r20, Modifier r21, Shape r22, long r23, long r25, FloatingActionButtonElevation r27, MutableInteractionSource r28, Function2 r29, int r30, int r31, int r32, Composer r33, int r34) {
        m2730FloatingActionButtonlFWlFE(r17, r18, r19, r20, r21, r22, r23, r25, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit LargeFloatingActionButton_X_z6DiA$lambda$6(Function0 r14, Modifier r15, Shape r16, long r17, long r19, FloatingActionButtonElevation r21, MutableInteractionSource r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m2731LargeFloatingActionButtonXz6DiA(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit SmallFloatingActionButton_X_z6DiA$lambda$5(Function0 r14, Modifier r15, Shape r16, long r17, long r19, FloatingActionButtonElevation r21, MutableInteractionSource r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m2732SmallFloatingActionButtonXz6DiA(r14, r15, r16, r17, r19, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, Shape r2, long r3, long r5, FloatingActionButtonElevation r7, MutableInteractionSource r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return FloatingActionButton_X_z6DiA$lambda$0(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit b(Function0 r0, Modifier r1, Shape r2, long r3, long r5, FloatingActionButtonElevation r7, MutableInteractionSource r8, Function3 r9, int r10, int r11, Composer r12, int r13) {
        return ExtendedFloatingActionButton_X_z6DiA$lambda$7(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(Function0 r1, TextStyle r2, float r3, float r4, Modifier r5, Shape r6, long r7, long r9, FloatingActionButtonElevation r11, MutableInteractionSource r12, Function2 r13, int r14, int r15, int r16, Composer r17, int r18) {
        return FloatingActionButton_lF_WlFE$lambda$4(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit d(Function2 r0, Function2 r1, Function0 r2, Modifier r3, boolean r4, Shape r5, long r6, long r8, FloatingActionButtonElevation r10, MutableInteractionSource r11, int r12, int r13, Composer r14, int r15) {
        return ExtendedFloatingActionButton_ElI5_7k$lambda$8(r0, r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit e(Function2 r1, Function2 r2, Function0 r3, TextStyle r4, float r5, float r6, float r7, float r8, float r9, Modifier r10, boolean r11, Shape r12, long r13, long r15, FloatingActionButtonElevation r17, MutableInteractionSource r18, int r19, int r20, int r21, Composer r22, int r23) {
        return ExtendedFloatingActionButton_qtIzBjc$lambda$9(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23);
    }

    public static /* synthetic */ Unit f(Function0 r0, Modifier r1, Shape r2, long r3, long r5, FloatingActionButtonElevation r7, MutableInteractionSource r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return SmallFloatingActionButton_X_z6DiA$lambda$5(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit g(Function0 r0, Modifier r1, Shape r2, long r3, long r5, FloatingActionButtonElevation r7, MutableInteractionSource r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return LargeFloatingActionButton_X_z6DiA$lambda$6(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit h(SemanticsPropertyReceiver r0) {
        return FloatingActionButton_lF_WlFE$lambda$3$lambda$2(r0);
    }

    static {
        ExtendedFabSmallTokens r0 = ExtendedFabSmallTokens.INSTANCE;
        SmallExtendedFabMinimumWidth = r0.getContainerHeight-D9Ej5fM();
        SmallExtendedFabMinimumHeight = r0.getContainerHeight-D9Ej5fM();
        SmallExtendedFabPaddingStart = r0.getLeadingSpace-D9Ej5fM();
        SmallExtendedFabPaddingEnd = r0.getTrailingSpace-D9Ej5fM();
        SmallExtendedFabIconPadding = r0.getIconLabelSpace-D9Ej5fM();
        SmallExtendedFabTextStyle = TypographyKeyTokens.TitleMedium;
        ExtendedFabMediumTokens r1 = ExtendedFabMediumTokens.INSTANCE;
        MediumExtendedFabMinimumWidth = r1.getContainerHeight-D9Ej5fM();
        MediumExtendedFabMinimumHeight = r1.getContainerHeight-D9Ej5fM();
        MediumExtendedFabPaddingStart = r1.getLeadingSpace-D9Ej5fM();
        MediumExtendedFabPaddingEnd = r1.getTrailingSpace-D9Ej5fM();
        float r2 = 12;
        MediumExtendedFabIconPadding = Dp.constructor-impl(r2);
        MediumExtendedFabTextStyle = TypographyKeyTokens.TitleLarge;
        ExtendedFabLargeTokens r3 = ExtendedFabLargeTokens.INSTANCE;
        LargeExtendedFabMinimumWidth = r3.getContainerHeight-D9Ej5fM();
        LargeExtendedFabMinimumHeight = r3.getContainerHeight-D9Ej5fM();
        LargeExtendedFabPaddingStart = r3.getLeadingSpace-D9Ej5fM();
        LargeExtendedFabPaddingEnd = r3.getTrailingSpace-D9Ej5fM();
        float r4 = 16;
        LargeExtendedFabIconPadding = Dp.constructor-impl(r4);
        LargeExtendedFabTextStyle = TypographyKeyTokens.HeadlineSmall;
        ExtendedFabStartIconPadding = Dp.constructor-impl(r4);
        ExtendedFabEndIconPadding = Dp.constructor-impl(r2);
        ExtendedFabTextPadding = Dp.constructor-impl(20);
        ExtendedFabMinimumWidth = Dp.constructor-impl(80);
    }

    public static final /* synthetic */ float access$getExtendedFabEndIconPadding$p() {
        return ExtendedFabEndIconPadding;
    }

    public static final /* synthetic */ float access$getExtendedFabMinimumWidth$p() {
        return ExtendedFabMinimumWidth;
    }

    public static final /* synthetic */ float access$getExtendedFabStartIconPadding$p() {
        return ExtendedFabStartIconPadding;
    }

    public static final /* synthetic */ float access$getExtendedFabTextPadding$p() {
        return ExtendedFabTextPadding;
    }

    private static final Unit FloatingActionButton_lF_WlFE$lambda$3$lambda$2(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ ExitTransition access$extendedFabCollapseAnimation(Composer r0, int r1) {
        return extendedFabCollapseAnimation(r0, r1);
    }

    public static final /* synthetic */ EnterTransition access$extendedFabExpandAnimation(Composer r0, int r1) {
        return extendedFabExpandAnimation(r0, r1);
    }

    private static final ExitTransition extendedFabCollapseAnimation(Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-56172201, r9, -1, "androidx.compose.material3.extendedFabCollapseAnimation (FloatingActionButton.kt:795)");
    L5:
        ExitTransition r10 = EnterExitTransitionKt.fadeOut$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r8, 6), MenuKt.ClosedAlphaTarget, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r8, 6), Alignment.Companion.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r10;
    }

    private static final EnterTransition extendedFabExpandAnimation(Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-719787506, r9, -1, "androidx.compose.material3.extendedFabExpandAnimation (FloatingActionButton.kt:806)");
    L5:
        EnterTransition r10 = EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r8, 6), MenuKt.ClosedAlphaTarget, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r8, 6), Alignment.Companion.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r10;
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2727ExtendedFloatingActionButtonXz6DiA(final Function0<Unit> r28, Modifier r29, Shape r30, long r31, long r33, FloatingActionButtonElevation r35, MutableInteractionSource r36, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Composer r9 = r38.startRestartGroup(1039585610);
        if ((r40 & 1) == 0) goto L6;
        int r1 = r39 | 6;
    L13:
        int r2 = r40 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r39 & 384) == 0) goto L27;
        Shape r4 = r30;
    L36:
        if ((r39 & 3072) == 0) goto L38;
        long r5 = r31;
    L47:
        if ((r39 & 24576) != 0) goto L58;
        if ((r40 & 16) != 0) goto L54;
        if (r9.changed(r33) == false) goto L54;
        int r13 = 16384;
    L55:
        r1 = r1 | r13;
    L54:
        r13 = 8192;
    L58:
        if ((196608 & r39) == 0) goto L60;
        FloatingActionButtonElevation r14 = r35;
    L68:
        int r15 = r40 & 64;
        if (r15 == 0) goto L72;
        r1 = r1 | 1572864;
    L79:
        if ((r40 & 128) == 0) goto L82;
        r1 = r1 | 12582912;
    L89:
        if ((4793491 & r1) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r9.shouldExecute(r0, r1 & 1) == false) goto L143;
        r9.startDefaults();
        if ((r39 & 1) != 0) goto L97;
    L112:
        if (r2 == 0) goto L114;
        Modifier r3 = Modifier.Companion;
    L116:
        if ((r40 & 4) == 0) goto L118;
        r1 = r1 & (-897);
        Shape r19 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(r9, 6);
    L120:
        if ((r40 & 8) == 0) goto L122;
        r1 = r1 & (-7169);
        long r6 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r9, 6);
    L124:
        if ((r40 & 16) == 0) goto L126;
        int r22 = r1 & (-57345);
        long r20 = ColorSchemeKt.m2496contentColorForek8zF_U(r6, r9, (r1 >> 9) & 14);
    L128:
        if ((r40 & 32) == 0) goto L132;
        r14 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r9, 24576, 15);
        r22 = r22 & (-458753);
    L132:
        if (r15 == 0) goto L134;
        MutableInteractionSource r8 = null;
    L135:
        FloatingActionButtonElevation r7 = r14;
        r4 = r19;
        long r10 = r20;
        int r16 = r22;
        r5 = r6;
    L136:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventStart(1039585610, r16, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:320)");
    L139:
        m2729FloatingActionButtonXz6DiA(r28, r3, r4, r5, r10, r7, r8, ComposableLambdaKt.rememberComposableLambda(-1233936436, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$1(r37), r9, 54), r9, (((((((r16 & 14) | 12582912) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168)) | (57344 & r16)) | (458752 & r16)) | (3670016 & r16), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventEnd();
    L142:
        MutableInteractionSource r11 = r8;
        final FloatingActionButtonElevation r12 = r7;
        long r26 = r10;
        final Modifier r17 = r3;
        final Shape r18 = r4;
        final long r21 = r5;
        final long r23 = r26;
    L144:
        ScopeUpdateScope r110 = r9.endRestartGroup();
        if (r110 == null) goto L148;
        final MutableInteractionSource r24 = r11;
        r110.updateScope(new ib(r28, r17, r18, r21, r23, r12, r24, r37, r39, r40));
        return;
    L148:
        return;
    L134:
        r8 = r36;
        goto L135
    L126:
        r20 = r33;
        r22 = r1;
        goto L128
    L122:
        r6 = r5;
        goto L124
    L118:
        r19 = r4;
        goto L120
    L114:
        r3 = r29;
        goto L116
    L97:
        if (r9.getDefaultsInvalid() == true) goto L112;
        r9.skipToGroupEnd();
        if ((r40 & 4) == 0) goto L103;
        r1 = r1 & (-897);
    L103:
        if ((r40 & 8) == 0) goto L106;
        r1 = r1 & (-7169);
    L106:
        if ((r40 & 16) == 0) goto L109;
        r1 = r1 & (-57345);
    L109:
        if ((r40 & 32) == 0) goto L111;
        r1 = r1 & (-458753);
    L111:
        r3 = r29;
        r10 = r33;
        r8 = r36;
        r7 = r14;
        r16 = r1;
        goto L136
    L143:
        r9.skipToGroupEnd();
        r17 = r29;
        r11 = r36;
        r18 = r4;
        r21 = r5;
        r12 = r14;
        r23 = r33;
        goto L144
    L91:
        r0 = false;
        goto L93
    L82:
        if ((r39 & 12582912) != 0) goto L89;
        if (r9.changedInstance(r37) == false) goto L86;
        int r25 = 8388608;
    L87:
        r1 = r1 | r25;
        goto L89
    L86:
        r25 = 4194304;
        goto L87
    L72:
        if ((r39 & 1572864) != 0) goto L79;
        if (r9.changed(r36) == false) goto L76;
        int r111 = 1048576;
    L77:
        r1 = r1 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L60:
        if ((r40 & 32) != 0) goto L64;
        r14 = r35;
        if (r9.changed(r14) == false) goto L65;
        int r112 = 131072;
    L66:
        r1 = r1 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r14 = r35;
        goto L65
    L38:
        if ((r40 & 8) != 0) goto L42;
        r5 = r31;
        if (r9.changed(r5) == false) goto L43;
        int r27 = 2048;
    L44:
        r1 = r1 | r27;
    L43:
        r27 = 1024;
        goto L44
    L42:
        r5 = r31;
        goto L43
    L27:
        if ((r40 & 4) != 0) goto L31;
        r4 = r30;
        if (r9.changed(r4) == false) goto L32;
        int r32 = 256;
    L33:
        r1 = r1 | r32;
    L32:
        r32 = 128;
        goto L33
    L31:
        r4 = r30;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L25;
        if (r9.changed(r29) == false) goto L21;
        int r34 = 32;
    L22:
        r1 = r1 | r34;
        goto L25
    L21:
        r34 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L13
    L8:
        if (r9.changedInstance(r28) == false) goto L10;
        int r41 = 4;
    L11:
        r1 = r41 | r39;
        goto L13
    L10:
        r41 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2729FloatingActionButtonXz6DiA(final Function0<Unit> r32, Modifier r33, Shape r34, long r35, long r37, FloatingActionButtonElevation r39, MutableInteractionSource r40, final Function2<? super Composer, ? super Integer, Unit> r41, Composer r42, final int r43, final int r44) {
        Composer r9 = r42.startRestartGroup(748201188);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L13:
        int r2 = r44 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r43 & 384) == 0) goto L27;
        Shape r4 = r34;
    L36:
        if ((r43 & 3072) == 0) goto L38;
        long r5 = r35;
    L47:
        if ((r43 & 24576) != 0) goto L58;
        if ((r44 & 16) != 0) goto L54;
        if (r9.changed(r37) == false) goto L54;
        int r13 = 16384;
    L55:
        r1 = r1 | r13;
    L54:
        r13 = 8192;
    L58:
        if ((196608 & r43) == 0) goto L60;
        FloatingActionButtonElevation r14 = r39;
    L68:
        int r15 = r44 & 64;
        if (r15 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        MutableInteractionSource r16 = r40;
    L80:
        if ((r44 & 128) == 0) goto L83;
        r1 = r1 | 12582912;
    L91:
        if ((r1 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r9.shouldExecute(r0, r1 & 1) == false) goto L145;
        r9.startDefaults();
        if ((r43 & 1) != 0) goto L99;
    L114:
        if (r2 == 0) goto L116;
        Modifier r3 = Modifier.Companion;
    L118:
        if ((r44 & 4) == 0) goto L120;
        r1 = r1 & (-897);
        Shape r18 = FloatingActionButtonDefaults.INSTANCE.getShape(r9, 6);
    L122:
        if ((r44 & 8) == 0) goto L124;
        r1 = r1 & (-7169);
        long r6 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r9, 6);
    L126:
        if ((r44 & 16) == 0) goto L128;
        int r21 = r1 & (-57345);
        long r19 = ColorSchemeKt.m2496contentColorForek8zF_U(r6, r9, (r1 >> 9) & 14);
    L130:
        if ((r44 & 32) == 0) goto L134;
        r14 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r9, 24576, 15);
        r21 = r21 & (-458753);
    L134:
        if (r15 == 0) goto L136;
        MutableInteractionSource r8 = null;
    L137:
        r4 = r18;
        long r7 = r19;
        int r17 = r21;
        r5 = r6;
    L138:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventStart(748201188, r17, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:118)");
    L141:
        TextStyle r110 = TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), r9, 6);
        FabBaselineTokens r10 = FabBaselineTokens.INSTANCE;
        int r111 = r17 << 9;
        m2730FloatingActionButtonlFWlFE(r32, r110, r10.getContainerWidth-D9Ej5fM(), r10.getContainerHeight-D9Ej5fM(), r3, r4, r5, r7, r14, r8, r41, r9, (((((((r17 & 14) | 3456) | (r111 & 57344)) | (r111 & 458752)) | (r111 & 3670016)) | (r111 & 29360128)) | (r111 & 234881024)) | (r111 & 1879048192), (r17 >> 21) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventEnd();
    L144:
        r16 = r8;
        final FloatingActionButtonElevation r11 = r14;
        long r30 = r7;
        final Modifier r12 = r3;
        final Shape r20 = r4;
        final long r22 = r5;
        final long r23 = r30;
    L146:
        ScopeUpdateScope r112 = r9.endRestartGroup();
        if (r112 == null) goto L150;
        final MutableInteractionSource r24 = r16;
        r112.updateScope(new ob(r32, r12, r20, r22, r23, r11, r24, r41, r43, r44));
        return;
    L150:
        return;
    L136:
        r8 = r16;
        goto L137
    L128:
        r19 = r37;
        r21 = r1;
        goto L130
    L124:
        r6 = r5;
        goto L126
    L120:
        r18 = r4;
        goto L122
    L116:
        r3 = r33;
        goto L118
    L99:
        if (r9.getDefaultsInvalid() == true) goto L114;
        r9.skipToGroupEnd();
        if ((r44 & 4) == 0) goto L105;
        r1 = r1 & (-897);
    L105:
        if ((r44 & 8) == 0) goto L108;
        r1 = r1 & (-7169);
    L108:
        if ((r44 & 16) == 0) goto L111;
        r1 = r1 & (-57345);
    L111:
        if ((r44 & 32) == 0) goto L113;
        r1 = r1 & (-458753);
    L113:
        r3 = r33;
        r7 = r37;
        r14 = r14;
        r8 = r16;
        r17 = r1;
        goto L138
    L145:
        r9.skipToGroupEnd();
        r12 = r33;
        r20 = r4;
        r22 = r5;
        r11 = r14;
        r23 = r37;
        goto L146
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r43 & 12582912) != 0) goto L91;
        if (r9.changedInstance(r41) == false) goto L87;
        int r113 = 8388608;
    L88:
        r1 = r1 | r113;
        goto L91
    L87:
        r113 = 4194304;
        goto L88
    L72:
        if ((1572864 & r43) != 0) goto L78;
        r16 = r40;
        if (r9.changed(r16) == false) goto L76;
        int r114 = 1048576;
    L77:
        r1 = r1 | r114;
        goto L80
    L76:
        r114 = 524288;
        goto L77
    L60:
        if ((r44 & 32) != 0) goto L64;
        r14 = r39;
        if (r9.changed(r14) == false) goto L65;
        int r115 = 131072;
    L66:
        r1 = r1 | r115;
    L65:
        r115 = 65536;
        goto L66
    L64:
        r14 = r39;
        goto L65
    L38:
        if ((r44 & 8) != 0) goto L42;
        r5 = r35;
        if (r9.changed(r5) == false) goto L43;
        int r25 = 2048;
    L44:
        r1 = r1 | r25;
    L43:
        r25 = 1024;
        goto L44
    L42:
        r5 = r35;
        goto L43
    L27:
        if ((r44 & 4) != 0) goto L31;
        r4 = r34;
        if (r9.changed(r4) == false) goto L32;
        int r26 = 256;
    L33:
        r1 = r1 | r26;
    L32:
        r26 = 128;
        goto L33
    L31:
        r4 = r34;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L25;
        if (r9.changed(r33) == false) goto L21;
        int r27 = 32;
    L22:
        r1 = r1 | r27;
        goto L25
    L21:
        r27 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L13
    L8:
        if (r9.changedInstance(r32) == false) goto L10;
        int r28 = 4;
    L11:
        r1 = r28 | r43;
        goto L13
    L10:
        r28 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2731LargeFloatingActionButtonXz6DiA(final Function0<Unit> r26, Modifier r27, Shape r28, long r29, long r31, FloatingActionButtonElevation r33, MutableInteractionSource r34, final Function2<? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r9 = r36.startRestartGroup(1274576261);
        if ((r38 & 1) == 0) goto L6;
        int r1 = r37 | 6;
    L13:
        int r2 = r38 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r37 & 384) == 0) goto L27;
        Shape r4 = r28;
    L36:
        if ((r37 & 3072) == 0) goto L38;
        long r5 = r29;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        long r7 = r31;
    L58:
        if ((196608 & r37) == 0) goto L60;
        FloatingActionButtonElevation r13 = r33;
    L68:
        int r14 = r38 & 64;
        if (r14 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        MutableInteractionSource r15 = r34;
    L80:
        if ((r38 & 128) == 0) goto L83;
        r1 = r1 | 12582912;
    L91:
        if ((r1 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r9.shouldExecute(r0, r1 & 1) == false) goto L143;
        r9.startDefaults();
        if ((r37 & 1) != 0) goto L99;
    L114:
        if (r2 == 0) goto L116;
        Modifier r3 = Modifier.Companion;
    L118:
        if ((r38 & 4) == 0) goto L120;
        r1 = r1 & (-897);
        Shape r18 = FloatingActionButtonDefaults.INSTANCE.getLargeShape(r9, 6);
    L122:
        if ((r38 & 8) == 0) goto L125;
        r1 = r1 & (-7169);
        r5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r9, 6);
    L125:
        if ((r38 & 16) == 0) goto L127;
        long r6 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r9, (r1 >> 9) & 14);
        int r21 = r1 & (-57345);
        long r19 = r6;
    L129:
        if ((r38 & 32) == 0) goto L131;
        r13 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r9, 24576, 15);
        int r8 = r21 & (-458753);
    L132:
        if (r14 == 0) goto L134;
        MutableInteractionSource r10 = null;
    L135:
        r4 = r18;
        r7 = r19;
        r5 = r5;
    L136:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventStart(1274576261, r8, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:262)");
    L139:
        FabLargeTokens r16 = FabLargeTokens.INSTANCE;
        Modifier r210 = r3;
        Modifier r17 = SizeKt.m1018sizeInqDBjuR0$default(r210, r16.getContainerWidth-D9Ej5fM(), r16.getContainerHeight-D9Ej5fM(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null);
        int r24 = ((((((r8 & 14) | (r8 & 896)) | (r8 & 7168)) | (57344 & r8)) | (458752 & r8)) | (3670016 & r8)) | (r8 & 29360128);
        m2729FloatingActionButtonXz6DiA(r26, r17, r4, r5, r7, r13, r10, r35, r9, r24, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventEnd();
    L142:
        r15 = r10;
        final Shape r11 = r4;
        final long r12 = r5;
        final long r20 = r7;
        final Modifier r22 = r3;
        final FloatingActionButtonElevation r23 = r13;
    L144:
        ScopeUpdateScope r110 = r9.endRestartGroup();
        if (r110 == null) goto L148;
        final MutableInteractionSource r25 = r15;
        r110.updateScope(new pb(r26, r22, r11, r12, r20, r23, r25, r35, r37, r38));
        return;
    L148:
        return;
    L134:
        r10 = r15;
        goto L135
    L131:
        r8 = r21;
        goto L132
    L127:
        r21 = r1;
        r19 = r7;
        goto L129
    L120:
        r18 = r4;
        goto L122
    L116:
        r3 = r27;
        goto L118
    L99:
        if (r9.getDefaultsInvalid() == true) goto L114;
        r9.skipToGroupEnd();
        if ((r38 & 4) == 0) goto L105;
        r1 = r1 & (-897);
    L105:
        if ((r38 & 8) == 0) goto L108;
        r1 = r1 & (-7169);
    L108:
        if ((r38 & 16) == 0) goto L111;
        r1 = r1 & (-57345);
    L111:
        if ((r38 & 32) == 0) goto L113;
        r1 = r1 & (-458753);
    L113:
        r3 = r27;
        r8 = r1;
        r13 = r13;
        r10 = r15;
        goto L136
    L143:
        r9.skipToGroupEnd();
        r22 = r27;
        r11 = r4;
        r12 = r5;
        r20 = r7;
        r23 = r13;
        goto L144
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r37 & 12582912) != 0) goto L91;
        if (r9.changedInstance(r35) == false) goto L87;
        int r111 = 8388608;
    L88:
        r1 = r1 | r111;
        goto L91
    L87:
        r111 = 4194304;
        goto L88
    L72:
        if ((1572864 & r37) != 0) goto L78;
        r15 = r34;
        if (r9.changed(r15) == false) goto L76;
        int r112 = 1048576;
    L77:
        r1 = r1 | r112;
        goto L80
    L76:
        r112 = 524288;
        goto L77
    L60:
        if ((r38 & 32) != 0) goto L64;
        r13 = r33;
        if (r9.changed(r13) == false) goto L65;
        int r113 = 131072;
    L66:
        r1 = r1 | r113;
    L65:
        r113 = 65536;
        goto L66
    L64:
        r13 = r33;
        goto L65
    L49:
        if ((r38 & 16) != 0) goto L53;
        r7 = r31;
        if (r9.changed(r7) == false) goto L54;
        int r114 = 16384;
    L55:
        r1 = r1 | r114;
    L54:
        r114 = 8192;
        goto L55
    L53:
        r7 = r31;
        goto L54
    L38:
        if ((r38 & 8) != 0) goto L42;
        r5 = r29;
        if (r9.changed(r5) == false) goto L43;
        int r30 = 2048;
    L44:
        r1 = r1 | r30;
    L43:
        r30 = 1024;
        goto L44
    L42:
        r5 = r29;
        goto L43
    L27:
        if ((r38 & 4) != 0) goto L31;
        r4 = r28;
        if (r9.changed(r4) == false) goto L32;
        int r32 = 256;
    L33:
        r1 = r1 | r32;
    L32:
        r32 = 128;
        goto L33
    L31:
        r4 = r28;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L25;
        if (r9.changed(r27) == false) goto L21;
        int r39 = 32;
    L22:
        r1 = r1 | r39;
        goto L25
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r1 = r37;
        goto L13
    L8:
        if (r9.changedInstance(r26) == false) goto L10;
        int r40 = 4;
    L11:
        r1 = r40 | r37;
        goto L13
    L10:
        r40 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m2732SmallFloatingActionButtonXz6DiA(final Function0<Unit> r26, Modifier r27, Shape r28, long r29, long r31, FloatingActionButtonElevation r33, MutableInteractionSource r34, final Function2<? super Composer, ? super Integer, Unit> r35, Composer r36, final int r37, final int r38) {
        Composer r9 = r36.startRestartGroup(26608441);
        if ((r38 & 1) == 0) goto L6;
        int r1 = r37 | 6;
    L13:
        int r2 = r38 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L25:
        if ((r37 & 384) == 0) goto L27;
        Shape r4 = r28;
    L36:
        if ((r37 & 3072) == 0) goto L38;
        long r5 = r29;
    L47:
        if ((r37 & 24576) == 0) goto L49;
        long r7 = r31;
    L58:
        if ((196608 & r37) == 0) goto L60;
        FloatingActionButtonElevation r13 = r33;
    L68:
        int r14 = r38 & 64;
        if (r14 == 0) goto L72;
        r1 = r1 | 1572864;
    L78:
        MutableInteractionSource r15 = r34;
    L80:
        if ((r38 & 128) == 0) goto L83;
        r1 = r1 | 12582912;
    L91:
        if ((r1 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r9.shouldExecute(r0, r1 & 1) == false) goto L143;
        r9.startDefaults();
        if ((r37 & 1) != 0) goto L99;
    L114:
        if (r2 == 0) goto L116;
        Modifier r3 = Modifier.Companion;
    L118:
        if ((r38 & 4) == 0) goto L120;
        r1 = r1 & (-897);
        Shape r18 = FloatingActionButtonDefaults.INSTANCE.getSmallShape(r9, 6);
    L122:
        if ((r38 & 8) == 0) goto L125;
        r1 = r1 & (-7169);
        r5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r9, 6);
    L125:
        if ((r38 & 16) == 0) goto L127;
        long r6 = ColorSchemeKt.m2496contentColorForek8zF_U(r5, r9, (r1 >> 9) & 14);
        int r21 = r1 & (-57345);
        long r19 = r6;
    L129:
        if ((r38 & 32) == 0) goto L131;
        r13 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r9, 24576, 15);
        int r8 = r21 & (-458753);
    L132:
        if (r14 == 0) goto L134;
        MutableInteractionSource r10 = null;
    L135:
        r4 = r18;
        r7 = r19;
        r5 = r5;
    L136:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L139;
        ComposerKt.traceEventStart(26608441, r8, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:207)");
    L139:
        FabSmallTokens r16 = FabSmallTokens.INSTANCE;
        Modifier r210 = r3;
        Modifier r17 = SizeKt.m1018sizeInqDBjuR0$default(r210, r16.getContainerWidth-D9Ej5fM(), r16.getContainerHeight-D9Ej5fM(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null);
        int r24 = ((((((r8 & 14) | (r8 & 896)) | (r8 & 7168)) | (57344 & r8)) | (458752 & r8)) | (3670016 & r8)) | (r8 & 29360128);
        m2729FloatingActionButtonXz6DiA(r26, r17, r4, r5, r7, r13, r10, r35, r9, r24, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventEnd();
    L142:
        r15 = r10;
        final Shape r11 = r4;
        final long r12 = r5;
        final long r20 = r7;
        final Modifier r22 = r3;
        final FloatingActionButtonElevation r23 = r13;
    L144:
        ScopeUpdateScope r110 = r9.endRestartGroup();
        if (r110 == null) goto L148;
        final MutableInteractionSource r25 = r15;
        r110.updateScope(new nb(r26, r22, r11, r12, r20, r23, r25, r35, r37, r38));
        return;
    L148:
        return;
    L134:
        r10 = r15;
        goto L135
    L131:
        r8 = r21;
        goto L132
    L127:
        r21 = r1;
        r19 = r7;
        goto L129
    L120:
        r18 = r4;
        goto L122
    L116:
        r3 = r27;
        goto L118
    L99:
        if (r9.getDefaultsInvalid() == true) goto L114;
        r9.skipToGroupEnd();
        if ((r38 & 4) == 0) goto L105;
        r1 = r1 & (-897);
    L105:
        if ((r38 & 8) == 0) goto L108;
        r1 = r1 & (-7169);
    L108:
        if ((r38 & 16) == 0) goto L111;
        r1 = r1 & (-57345);
    L111:
        if ((r38 & 32) == 0) goto L113;
        r1 = r1 & (-458753);
    L113:
        r3 = r27;
        r8 = r1;
        r13 = r13;
        r10 = r15;
        goto L136
    L143:
        r9.skipToGroupEnd();
        r22 = r27;
        r11 = r4;
        r12 = r5;
        r20 = r7;
        r23 = r13;
        goto L144
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r37 & 12582912) != 0) goto L91;
        if (r9.changedInstance(r35) == false) goto L87;
        int r111 = 8388608;
    L88:
        r1 = r1 | r111;
        goto L91
    L87:
        r111 = 4194304;
        goto L88
    L72:
        if ((1572864 & r37) != 0) goto L78;
        r15 = r34;
        if (r9.changed(r15) == false) goto L76;
        int r112 = 1048576;
    L77:
        r1 = r1 | r112;
        goto L80
    L76:
        r112 = 524288;
        goto L77
    L60:
        if ((r38 & 32) != 0) goto L64;
        r13 = r33;
        if (r9.changed(r13) == false) goto L65;
        int r113 = 131072;
    L66:
        r1 = r1 | r113;
    L65:
        r113 = 65536;
        goto L66
    L64:
        r13 = r33;
        goto L65
    L49:
        if ((r38 & 16) != 0) goto L53;
        r7 = r31;
        if (r9.changed(r7) == false) goto L54;
        int r114 = 16384;
    L55:
        r1 = r1 | r114;
    L54:
        r114 = 8192;
        goto L55
    L53:
        r7 = r31;
        goto L54
    L38:
        if ((r38 & 8) != 0) goto L42;
        r5 = r29;
        if (r9.changed(r5) == false) goto L43;
        int r30 = 2048;
    L44:
        r1 = r1 | r30;
    L43:
        r30 = 1024;
        goto L44
    L42:
        r5 = r29;
        goto L43
    L27:
        if ((r38 & 4) != 0) goto L31;
        r4 = r28;
        if (r9.changed(r4) == false) goto L32;
        int r32 = 256;
    L33:
        r1 = r1 | r32;
    L32:
        r32 = 128;
        goto L33
    L31:
        r4 = r28;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L25;
        if (r9.changed(r27) == false) goto L21;
        int r39 = 32;
    L22:
        r1 = r1 | r39;
        goto L25
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r1 = r37;
        goto L13
    L8:
        if (r9.changedInstance(r26) == false) goto L10;
        int r40 = 4;
    L11:
        r1 = r40 | r37;
        goto L13
    L10:
        r40 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m2726ExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> r33, final Function2<? super Composer, ? super Integer, Unit> r34, final Function0<Unit> r35, Modifier r36, boolean r37, Shape r38, long r39, long r41, FloatingActionButtonElevation r43, MutableInteractionSource r44, Composer r45, final int r46, final int r47) {
        Composer r3 = r45.startRestartGroup(-1161000600);
        if ((r47 & 1) == 0) goto L6;
        int r4 = r46 | 6;
    L14:
        if ((r47 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r47 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L34:
        int r6 = r47 & 8;
        if (r6 == 0) goto L38;
        r4 = r4 | 3072;
    L45:
        int r8 = r47 & 16;
        if (r8 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        final boolean r9 = r37;
    L57:
        if ((196608 & r46) == 0) goto L59;
        Shape r10 = r38;
    L68:
        if ((1572864 & r46) == 0) goto L70;
        long r11 = r39;
    L79:
        if ((r46 & 12582912) != 0) goto L89;
        if ((r47 & 128) == 0) goto L83;
    L85:
        int r16 = 4194304;
    L86:
        r4 = r4 | r16;
        goto L89
    L83:
        if (r3.changed(r41) == false) goto L85;
        r16 = 8388608;
    L89:
        if ((r46 & 100663296) == 0) goto L91;
        FloatingActionButtonElevation r15 = r43;
    L99:
        int r0 = r47 & 512;
        if (r0 == 0) goto L103;
        r4 = r4 | 805306368;
    L111:
        if ((r4 & 306783379) == 306783378) goto L113;
        boolean r1 = true;
    L115:
        if (r3.shouldExecute(r1, r4 & 1) == false) goto L166;
        r3.startDefaults();
        if ((r46 & 1) != 0) goto L119;
    L134:
        if (r6 == 0) goto L136;
        Modifier r2 = Modifier.Companion;
    L137:
        if (r8 == 0) goto L140;
        r9 = true;
    L140:
        if ((r47 & 32) == 0) goto L142;
        final Shape r7 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(r3, 6);
        r4 = r4 & (-458753);
    L144:
        if ((r47 & 64) == 0) goto L146;
        long r12 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r3, 6);
        r4 = r4 & (-3670017);
    L148:
        if ((r47 & 128) == 0) goto L150;
        long r18 = ColorSchemeKt.m2496contentColorForek8zF_U(r12, r3, (r4 >> 18) & 14);
        r4 = r4 & (-29360129);
    L152:
        if ((r47 & 256) == 0) goto L154;
        FloatingActionButtonElevation r13 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r3, 24576, 15);
        r4 = r4 & (-234881025);
    L155:
        if (r0 == 0) goto L157;
        MutableInteractionSource r5 = null;
    L158:
        int r14 = r4;
        long r17 = r18;
    L159:
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L162;
        ComposerKt.traceEventStart(-1161000600, r14, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:391)");
    L162:
        boolean r310 = r9;
        ComposableLambda r24 = ComposableLambdaKt.rememberComposableLambda(632971498, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$3(r9, r34, r33), r3, 54);
        int r19 = r14 >> 6;
        int r20 = (r19 & 14) | 12582912;
        int r21 = (r19 & 112) | r20;
        int r22 = r14 >> 9;
        Modifier r110 = r2;
        Shape r111 = r7;
        long r112 = r12;
        long r23 = r17;
        FloatingActionButtonElevation r25 = r13;
        MutableInteractionSource r26 = r5;
        m2729FloatingActionButtonXz6DiA(r35, r110, r111, r112, r23, r25, r26, r24, r3, ((((r21 | (r22 & 896)) | (r22 & 7168)) | (57344 & r22)) | (458752 & r22)) | (r22 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventEnd();
    L165:
        final MutableInteractionSource r113 = r5;
        long r29 = r17;
        final boolean r27 = r310;
        final Modifier r28 = r2;
        final FloatingActionButtonElevation r114 = r13;
        final long r30 = r29;
        final long r31 = r12;
    L167:
        ScopeUpdateScope r115 = r3.endRestartGroup();
        if (r115 == null) goto L171;
        r115.updateScope(new kb(r33, r34, r35, r28, r27, r7, r31, r30, r114, r113, r46, r47));
        return;
    L171:
        return;
    L157:
        r5 = r44;
        goto L158
    L154:
        r13 = r15;
        goto L155
    L150:
        r18 = r41;
        goto L152
    L146:
        r12 = r11;
        goto L148
    L142:
        r7 = r10;
        goto L144
    L136:
        r2 = r36;
        goto L137
    L119:
        if (r3.getDefaultsInvalid() == true) goto L134;
        r3.skipToGroupEnd();
        if ((r47 & 32) == 0) goto L125;
        r4 = r4 & (-458753);
    L125:
        if ((r47 & 64) == 0) goto L128;
        r4 = r4 & (-3670017);
    L128:
        if ((r47 & 128) == 0) goto L131;
        r4 = r4 & (-29360129);
    L131:
        if ((r47 & 256) == 0) goto L133;
        r4 = r4 & (-234881025);
    L133:
        r2 = r36;
        r5 = r44;
        r7 = r10;
        r12 = r11;
        r13 = r15;
        r14 = r4;
        r17 = r41;
        goto L159
    L166:
        r3.skipToGroupEnd();
        r28 = r36;
        r27 = r9;
        r7 = r10;
        r31 = r11;
        r114 = r15;
        r30 = r41;
        r113 = r44;
        goto L167
    L113:
        r1 = false;
        goto L115
    L103:
        if ((805306368 & r46) != 0) goto L111;
        if (r3.changed(r44) == false) goto L107;
        int r116 = 536870912;
    L108:
        r4 = r4 | r116;
        goto L111
    L107:
        r116 = 268435456;
        goto L108
    L91:
        if ((r47 & 256) != 0) goto L95;
        r15 = r43;
        if (r3.changed(r15) == false) goto L96;
        int r117 = 67108864;
    L97:
        r4 = r4 | r117;
    L96:
        r117 = 33554432;
        goto L97
    L95:
        r15 = r43;
        goto L96
    L70:
        if ((r47 & 64) != 0) goto L74;
        r11 = r39;
        if (r3.changed(r11) == false) goto L75;
        int r118 = 1048576;
    L76:
        r4 = r4 | r118;
    L75:
        r118 = 524288;
        goto L76
    L74:
        r11 = r39;
        goto L75
    L59:
        if ((r47 & 32) != 0) goto L63;
        r10 = r38;
        if (r3.changed(r10) == false) goto L64;
        int r119 = 131072;
    L65:
        r4 = r4 | r119;
    L64:
        r119 = 65536;
        goto L65
    L63:
        r10 = r38;
        goto L64
    L49:
        if ((r46 & 24576) != 0) goto L55;
        r9 = r37;
        if (r3.changed(r9) == false) goto L53;
        int r120 = 16384;
    L54:
        r4 = r4 | r120;
        goto L57
    L53:
        r120 = 8192;
        goto L54
    L38:
        if ((r46 & 3072) != 0) goto L45;
        if (r3.changed(r36) == false) goto L42;
        int r32 = 2048;
    L43:
        r4 = r4 | r32;
        goto L45
    L42:
        r32 = 1024;
        goto L43
    L27:
        if ((r46 & 384) != 0) goto L34;
        if (r3.changedInstance(r35) == false) goto L31;
        int r40 = 256;
    L32:
        r4 = r4 | r40;
        goto L34
    L31:
        r40 = 128;
        goto L32
    L17:
        if ((r46 & 48) != 0) goto L24;
        if (r3.changedInstance(r34) == false) goto L21;
        int r42 = 32;
    L22:
        r4 = r4 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r46 & 6) == 0) goto L8;
        r4 = r46;
        goto L14
    L8:
        if (r3.changedInstance(r33) == false) goto L10;
        int r48 = 4;
    L11:
        r4 = r48 | r46;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: FloatingActionButton-lF-WlFE, reason: not valid java name */
    private static final void m2730FloatingActionButtonlFWlFE(final Function0<Unit> r35, final TextStyle r36, final float r37, final float r38, Modifier r39, Shape r40, long r41, long r43, FloatingActionButtonElevation r45, MutableInteractionSource r46, final Function2<? super Composer, ? super Integer, Unit> r47, Composer r48, final int r49, final int r50, final int r51) {
        Composer r9 = r48.startRestartGroup(121669932);
        if ((r51 & 1) == 0) goto L6;
        int r1 = r49 | 6;
    L14:
        if ((r51 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r51 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r51 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r4 = r51 & 16;
        if (r4 == 0) goto L47;
        r1 = r1 | 24576;
    L53:
        final Modifier r5 = r39;
    L55:
        if ((196608 & r49) == 0) goto L57;
        final Shape r6 = r40;
    L66:
        if ((1572864 & r49) != 0) goto L77;
        if ((r51 & 64) != 0) goto L73;
        if (r9.changed(r41) == false) goto L73;
        int r16 = 1048576;
    L74:
        r1 = r1 | r16;
    L73:
        r16 = 524288;
    L77:
        if ((r49 & 12582912) != 0) goto L87;
        if ((r51 & 128) == 0) goto L81;
    L83:
        int r17 = 4194304;
    L84:
        r1 = r1 | r17;
        goto L87
    L81:
        if (r9.changed(r43) == false) goto L83;
        r17 = 8388608;
    L87:
        if ((r49 & 100663296) != 0) goto L97;
        if ((r51 & 256) != 0) goto L94;
        if (r9.changed(r45) == false) goto L94;
        int r18 = 67108864;
    L95:
        r1 = r1 | r18;
    L94:
        r18 = 33554432;
    L97:
        int r0 = r51 & 512;
        if (r0 == 0) goto L101;
        r1 = r1 | 805306368;
    L108:
        if ((r51 & 1024) == 0) goto L111;
        int r8 = r50 | 6;
    L119:
        if ((r1 & 306783379) == 306783378) goto L121;
    L124:
        boolean r2 = true;
    L126:
        if (r9.shouldExecute(r2, r1 & 1) == false) goto L184;
        r9.startDefaults();
        int r410 = r8;
        if ((r49 & 1) != 0) goto L130;
    L145:
        if (r4 == 0) goto L147;
        Modifier r19 = Modifier.Companion;
    L149:
        if ((r51 & 32) == 0) goto L151;
        r1 = r1 & (-458753);
        Shape r20 = FloatingActionButtonDefaults.INSTANCE.getShape(r9, 6);
    L153:
        if ((r51 & 64) == 0) goto L155;
        long r7 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r9, 6);
        r1 = r1 & (-3670017);
    L157:
        if ((r51 & 128) == 0) goto L159;
        long r21 = ColorSchemeKt.m2496contentColorForek8zF_U(r7, r9, (r1 >> 18) & 14);
        r1 = r1 & (-29360129);
    L160:
        int r110 = r1;
        if ((r51 & 256) == 0) goto L163;
        FloatingActionButtonElevation r3 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r9, 24576, 15);
        int r10 = r110 & (-234881025);
    L164:
        if (r0 == 0) goto L166;
        MutableInteractionSource r11 = null;
    L167:
        FloatingActionButtonElevation r12 = r3;
        int r13 = r10;
        r5 = r19;
        r6 = r20;
        long r14 = r21;
        long r15 = r7;
    L168:
        r9.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventStart(121669932, r13, r410, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:145)");
    L171:
        if (r11 != null) goto L176;
        r9.startReplaceGroup(-282833393);
        Object r111 = r9.rememberedValue();
        if (r111 != Composer.Companion.getEmpty()) goto L175;
        r111 = InteractionSourceKt.MutableInteractionSource();
        r9.updateRememberedValue(r111);
    L175:
        MutableInteractionSource r112 = (MutableInteractionSource) r111;
        r9.endReplaceGroup();
    L177:
        Object r113 = r9.rememberedValue();
        if (r113 != Composer.Companion.getEmpty()) goto L180;
        r113 = new lb();
        r9.updateRememberedValue(r113);
    L180:
        MutableInteractionSource r411 = r11;
        final long r42 = r14;
        int r22 = r13 & 14;
        int r23 = r13 >> 6;
        Shape r114 = r6;
        long r24 = r15;
        long r25 = r14;
        MutableInteractionSource r27 = r112;
        SurfaceKt.m3216Surfaceo_FOJdg(r35, SemanticsModifierKt.semantics$default(r5, false, (Function1) r113, 1, null), false, r114, r24, r25, r12.m2723tonalElevationD9Ej5fM$material3(), ((Dp) r12.shadowElevation$material3(r112, r9, (r13 >> 21) & 112).getValue()).unbox-impl(), null, r27, ComposableLambdaKt.rememberComposableLambda(-1779603465, true, new FloatingActionButtonKt$FloatingActionButton$3(r42, r36, r37, r38, r47), r9, 54), r9, ((r22 | (r23 & 7168)) | (57344 & r23)) | (r23 & 458752), 6, 260);
        if (ComposerKt.isTraceInProgress() == false) goto L183;
        ComposerKt.traceEventEnd();
    L183:
        MutableInteractionSource r115 = r411;
        final long r26 = r15;
        long r116 = r14;
        FloatingActionButtonElevation r117 = r12;
    L185:
        ScopeUpdateScope r28 = r9.endRestartGroup();
        if (r28 == null) goto L189;
        final long r29 = r116;
        final FloatingActionButtonElevation r118 = r117;
        final MutableInteractionSource r119 = r115;
        r28.updateScope(new mb(r35, r36, r37, r38, r5, r6, r26, r29, r118, r119, r47, r49, r50, r51));
        return;
    L189:
        return;
    L176:
        r9.startReplaceGroup(960707016);
        r9.endReplaceGroup();
        r112 = r11;
        goto L177
    L166:
        r11 = r46;
        goto L167
    L163:
        r3 = r45;
        r10 = r110;
        goto L164
    L159:
        r21 = r43;
        goto L160
    L155:
        r7 = r41;
        goto L157
    L151:
        r20 = r6;
        goto L153
    L147:
        r19 = r5;
        goto L149
    L130:
        if (r9.getDefaultsInvalid() == true) goto L145;
        r9.skipToGroupEnd();
        if ((r51 & 32) == 0) goto L136;
        r1 = r1 & (-458753);
    L136:
        if ((r51 & 64) == 0) goto L139;
        r1 = r1 & (-3670017);
    L139:
        if ((r51 & 128) == 0) goto L142;
        r1 = r1 & (-29360129);
    L142:
        if ((r51 & 256) == 0) goto L144;
        r1 = r1 & (-234881025);
    L144:
        r14 = r43;
        r12 = r45;
        r11 = r46;
        r410 = r410;
        r13 = r1;
        r15 = r41;
        goto L168
    L184:
        r9.skipToGroupEnd();
        r26 = r41;
        r116 = r43;
        r117 = r45;
        r115 = r46;
        goto L185
    L121:
        if ((r8 & 3) != 2) goto L124;
        r2 = false;
        goto L126
    L111:
        if ((r50 & 6) == 0) goto L113;
        r8 = r50;
        goto L119
    L113:
        if (r9.changedInstance(r47) == false) goto L115;
        int r120 = 4;
    L116:
        r8 = r50 | r120;
        goto L119
    L115:
        r120 = 2;
        goto L116
    L101:
        if ((r49 & 805306368) != 0) goto L108;
        if (r9.changed(r46) == false) goto L105;
        int r30 = 536870912;
    L106:
        r1 = r1 | r30;
        goto L108
    L105:
        r30 = 268435456;
        goto L106
    L57:
        if ((r51 & 32) != 0) goto L61;
        r6 = r40;
        if (r9.changed(r6) == false) goto L62;
        int r31 = 131072;
    L63:
        r1 = r1 | r31;
    L62:
        r31 = 65536;
        goto L63
    L61:
        r6 = r40;
        goto L62
    L47:
        if ((r49 & 24576) != 0) goto L53;
        r5 = r39;
        if (r9.changed(r5) == false) goto L51;
        int r32 = 16384;
    L52:
        r1 = r1 | r32;
        goto L55
    L51:
        r32 = 8192;
        goto L52
    L37:
        if ((r49 & 3072) != 0) goto L43;
        if (r9.changed(r38) == false) goto L41;
        int r33 = 2048;
    L42:
        r1 = r1 | r33;
        goto L43
    L41:
        r33 = 1024;
        goto L42
    L27:
        if ((r49 & 384) != 0) goto L34;
        if (r9.changed(r37) == false) goto L31;
        int r34 = 256;
    L32:
        r1 = r1 | r34;
        goto L34
    L31:
        r34 = 128;
        goto L32
    L17:
        if ((r49 & 48) != 0) goto L24;
        if (r9.changed(r36) == false) goto L21;
        int r44 = 32;
    L22:
        r1 = r1 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r49 & 6) == 0) goto L8;
        r1 = r49;
        goto L14
    L8:
        if (r9.changedInstance(r35) == false) goto L10;
        int r52 = 4;
    L11:
        r1 = r52 | r49;
        goto L14
    L10:
        r52 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-qtIzBjc, reason: not valid java name */
    private static final void m2728ExtendedFloatingActionButtonqtIzBjc(final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Function0<Unit> r39, final TextStyle r40, final float r41, final float r42, final float r43, final float r44, final float r45, Modifier r46, boolean r47, Shape r48, long r49, long r51, FloatingActionButtonElevation r53, MutableInteractionSource r54, Composer r55, final int r56, final int r57, final int r58) {
        Composer r1 = r55.startRestartGroup(193103278);
        if ((r58 & 1) == 0) goto L6;
        int r5 = r56 | 6;
    L14:
        if ((r58 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L25:
        if ((r58 & 4) == 0) goto L28;
        r5 = r5 | 384;
    L35:
        int r16 = 1024;
        if ((r58 & 8) == 0) goto L39;
        r5 = r5 | 3072;
    L46:
        int r19 = 16384;
        if ((r58 & 16) == 0) goto L50;
        r5 = r5 | 24576;
    L57:
        int r21 = 131072;
        if ((r58 & 32) == 0) goto L61;
        r5 = r5 | 196608;
    L68:
        if ((r58 & 64) == 0) goto L71;
        r5 = r5 | 1572864;
    L78:
        if ((r58 & 128) == 0) goto L81;
        r5 = r5 | 12582912;
    L89:
        if ((r58 & 256) == 0) goto L92;
        r5 = r5 | 100663296;
    L99:
        int r11 = r58 & 512;
        if (r11 == 0) goto L103;
        r5 = r5 | 805306368;
    L109:
        int r0 = r58 & 1024;
        if (r0 == 0) goto L113;
        int r25 = r57 | 6;
    L121:
        if ((r57 & 48) != 0) goto L132;
        if ((r58 & 2048) != 0) goto L128;
        if (r1.changed(r48) == false) goto L128;
        int r18 = 32;
    L129:
        r25 = r25 | r18;
    L128:
        r18 = 16;
    L132:
        if ((r57 & 384) != 0) goto L143;
        if ((r58 & 4096) != 0) goto L139;
        if (r1.changed(r49) == false) goto L139;
        int r26 = 256;
    L140:
        r25 = r25 | r26;
    L139:
        r26 = 128;
    L143:
        if ((r57 & 3072) != 0) goto L153;
        if ((r58 & 8192) != 0) goto L150;
        if (r1.changed(r51) == false) goto L150;
        r16 = 2048;
    L150:
        r25 = r25 | r16;
    L153:
        if ((r57 & 24576) != 0) goto L163;
        if ((r58 & 16384) != 0) goto L160;
        if (r1.changed(r53) == false) goto L160;
    L161:
        r25 = r25 | r19;
    L160:
        r19 = 8192;
    L163:
        int r3 = 32768 & r58;
        if (r3 == 0) goto L167;
        r25 = r25 | 196608;
    L174:
        if ((r5 & 306783379) == 306783378) goto L176;
    L179:
        boolean r2 = true;
    L181:
        if (r1.shouldExecute(r2, r5 & 1) == false) goto L233;
        r1.startDefaults();
        if ((r56 & 1) != 0) goto L185;
    L200:
        if (r11 == 0) goto L202;
        Modifier r4 = Modifier.Companion;
    L203:
        if (r0 == 0) goto L205;
        boolean r6 = true;
    L207:
        if ((r58 & 2048) == 0) goto L209;
        Shape r7 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(r1, 6);
        r25 = r25 & (-113);
    L210:
        int r8 = r25;
        if ((r58 & 4096) == 0) goto L213;
        int r9 = r8 & (-897);
        long r10 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(r1, 6);
    L215:
        if ((r58 & 8192) == 0) goto L217;
        long r17 = ColorSchemeKt.m2496contentColorForek8zF_U(r10, r1, (r9 >> 6) & 14);
        r9 = r9 & (-7169);
    L219:
        if ((r58 & 16384) == 0) goto L221;
        FloatingActionButtonElevation r12 = FloatingActionButtonDefaults.INSTANCE.m2720elevationxZ9QkE(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r1, 24576, 15);
        r9 = r9 & (-57345);
    L222:
        if (r3 == 0) goto L224;
        MutableInteractionSource r13 = null;
    L225:
        int r14 = r9;
        boolean r15 = r6;
        long r33 = r17;
    L226:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L229;
        ComposerKt.traceEventStart(193103278, r5, r14, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:451)");
    L229:
        Dp.Companion r20 = Dp.Companion;
        float r110 = r20.getUnspecified-D9Ej5fM();
        float r111 = r20.getUnspecified-D9Ej5fM();
        boolean r410 = r15;
        ComposableLambda r28 = ComposableLambdaKt.rememberComposableLambda(-827388388, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(r15, r41, r42, r43, r44, r38, r45, r37), r1, 54);
        int r22 = r5 >> 6;
        int r23 = (r22 & 14) | 3456;
        int r24 = ((r22 & 112) | r23) | ((r5 >> 15) & 57344);
        int r27 = r14 << 12;
        Modifier r29 = r4;
        Shape r210 = r7;
        long r211 = r10;
        long r212 = r33;
        FloatingActionButtonElevation r213 = r12;
        MutableInteractionSource r214 = r13;
        m2730FloatingActionButtonlFWlFE(r39, r40, r110, r111, r29, r210, r211, r212, r213, r214, r28, r1, ((((r24 | (458752 & r27)) | (3670016 & r27)) | (29360128 & r27)) | (234881024 & r27)) | (r27 & 1879048192), 6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L232;
        ComposerKt.traceEventEnd();
    L232:
        final Modifier r112 = r4;
        MutableInteractionSource r113 = r13;
        final Shape r114 = r7;
        long r115 = r10;
        FloatingActionButtonElevation r116 = r12;
        final boolean r117 = r410;
    L234:
        ScopeUpdateScope r30 = r1.endRestartGroup();
        if (r30 == null) goto L238;
        final long r118 = r115;
        final long r119 = r33;
        final FloatingActionButtonElevation r120 = r116;
        final MutableInteractionSource r121 = r113;
        r30.updateScope(new jb(r37, r38, r39, r40, r41, r42, r43, r44, r45, r112, r117, r114, r118, r119, r120, r121, r56, r57, r58));
        return;
    L238:
        return;
    L224:
        r13 = r54;
        goto L225
    L221:
        r12 = r53;
        goto L222
    L217:
        r17 = r51;
        goto L219
    L213:
        r9 = r8;
        r10 = r49;
        goto L215
    L209:
        r7 = r48;
        goto L210
    L205:
        r6 = r47;
        goto L207
    L202:
        r4 = r46;
        goto L203
    L185:
        if (r1.getDefaultsInvalid() == true) goto L200;
        r1.skipToGroupEnd();
        if ((r58 & 2048) == 0) goto L190;
        r25 = r25 & (-113);
    L190:
        int r31 = r25;
        if ((r58 & 4096) == 0) goto L194;
        r31 = r31 & (-897);
    L194:
        if ((r58 & 8192) == 0) goto L197;
        r31 = r31 & (-7169);
    L197:
        if ((r58 & 16384) == 0) goto L199;
        r31 = r31 & (-57345);
    L199:
        r4 = r46;
        r7 = r48;
        r10 = r49;
        r33 = r51;
        r12 = r53;
        r13 = r54;
        r14 = r31;
        r15 = r47;
        goto L226
    L233:
        r1.skipToGroupEnd();
        r112 = r46;
        r117 = r47;
        r114 = r48;
        r115 = r49;
        r33 = r51;
        r116 = r53;
        r113 = r54;
        goto L234
    L176:
        if ((r25 & 74899) != 74898) goto L179;
        r2 = false;
        goto L181
    L167:
        if ((r57 & 196608) != 0) goto L174;
        if (r1.changed(r54) == true) goto L172;
        r21 = 65536;
    L172:
        r25 = r25 | r21;
        goto L174
    L113:
        if ((r57 & 6) == 0) goto L115;
        r25 = r57;
        goto L121
    L115:
        if (r1.changed(r47) == false) goto L117;
        int r215 = 4;
    L118:
        r25 = r57 | r215;
        goto L121
    L117:
        r215 = 2;
        goto L118
    L103:
        if ((r56 & 805306368) != 0) goto L109;
        if (r1.changed(r46) == false) goto L107;
        int r216 = 536870912;
    L108:
        r5 = r5 | r216;
        goto L109
    L107:
        r216 = 268435456;
        goto L108
    L92:
        if ((100663296 & r56) != 0) goto L99;
        if (r1.changed(r45) == false) goto L96;
        int r217 = 67108864;
    L97:
        r5 = r5 | r217;
        goto L99
    L96:
        r217 = 33554432;
        goto L97
    L81:
        if ((12582912 & r56) != 0) goto L89;
        if (r1.changed(r44) == false) goto L85;
        int r218 = 8388608;
    L86:
        r5 = r5 | r218;
        goto L89
    L85:
        r218 = 4194304;
        goto L86
    L71:
        if ((r56 & 1572864) != 0) goto L78;
        if (r1.changed(r43) == false) goto L75;
        int r219 = 1048576;
    L76:
        r5 = r5 | r219;
        goto L78
    L75:
        r219 = 524288;
        goto L76
    L61:
        if ((r56 & 196608) != 0) goto L68;
        if (r1.changed(r42) == false) goto L65;
        int r220 = 131072;
    L66:
        r5 = r5 | r220;
        goto L68
    L65:
        r220 = 65536;
        goto L66
    L50:
        if ((r56 & 24576) != 0) goto L57;
        if (r1.changed(r41) == false) goto L54;
        int r122 = 16384;
    L55:
        r5 = r5 | r122;
        goto L57
    L54:
        r122 = 8192;
        goto L55
    L39:
        if ((r56 & 3072) != 0) goto L46;
        if (r1.changed(r40) == false) goto L43;
        int r123 = 2048;
    L44:
        r5 = r5 | r123;
        goto L46
    L43:
        r123 = 1024;
        goto L44
    L28:
        if ((r56 & 384) != 0) goto L35;
        if (r1.changedInstance(r39) == false) goto L32;
        int r124 = 256;
    L33:
        r5 = r5 | r124;
        goto L35
    L32:
        r124 = 128;
        goto L33
    L17:
        if ((r56 & 48) != 0) goto L25;
        if (r1.changedInstance(r38) == false) goto L21;
        int r32 = 32;
    L22:
        r5 = r5 | r32;
        goto L25
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r56 & 6) == 0) goto L8;
        r5 = r56;
        goto L14
    L8:
        if (r1.changedInstance(r37) == false) goto L10;
        int r34 = 4;
    L11:
        r5 = r34 | r56;
        goto L14
    L10:
        r34 = 2;
        goto L11
    }
}
