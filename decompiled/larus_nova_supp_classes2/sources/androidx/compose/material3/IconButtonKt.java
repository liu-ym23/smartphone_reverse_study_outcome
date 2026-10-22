package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.internal.ChildParentSemanticsKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u001aX\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001ab\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0011\u001aX\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u0013\u001af\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0019\u001ap\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001a\u001ap\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010\u001a\u001ab\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001d\u001ap\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001f\u001ab\u0010 \u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001d\u001ap\u0010!\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u001f\u001an\u0010\"\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010%\u001a|\u0010&\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\u00182\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010'\u001ab\u0010(\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010)\u001ap\u0010*\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\rH\u0003¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"IconButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonImpl", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "IconToggleButton", "checked", "onCheckedChange", "Lkotlin/Function1;", "Landroidx/compose/material3/IconToggleButtonColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconToggleButtonImpl", "FilledIconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FilledTonalIconButton", "FilledTonalIconToggleButton", "OutlinedIconButton", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OutlinedIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SurfaceIconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SurfaceIconToggleButton", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconToggleButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconButtonKt {
    private static final Unit FilledIconButton$lambda$10(Function0 r11, Modifier r12, boolean r13, Shape r14, IconButtonColors r15, MutableInteractionSource r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        FilledIconButton(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit FilledIconToggleButton$lambda$13(boolean r12, Function1 r13, Modifier r14, boolean r15, Shape r16, IconToggleButtonColors r17, MutableInteractionSource r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        FilledIconToggleButton(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit FilledTonalIconButton$lambda$14(Function0 r11, Modifier r12, boolean r13, Shape r14, IconButtonColors r15, MutableInteractionSource r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        FilledTonalIconButton(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit FilledTonalIconToggleButton$lambda$17(boolean r12, Function1 r13, Modifier r14, boolean r15, Shape r16, IconToggleButtonColors r17, MutableInteractionSource r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        FilledTonalIconToggleButton(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit IconButton$lambda$0(Function0 r10, Modifier r11, boolean r12, IconButtonColors r13, MutableInteractionSource r14, Function2 r15, int r16, int r17, Composer r18, int r19) {
        IconButton(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    private static final Unit IconButton$lambda$1(Function0 r11, Modifier r12, boolean r13, IconButtonColors r14, MutableInteractionSource r15, Shape r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        IconButton(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit IconButtonImpl$lambda$4(Modifier r10, Function0 r11, boolean r12, Shape r13, IconButtonColors r14, MutableInteractionSource r15, Function2 r16, int r17, Composer r18, int r19) {
        IconButtonImpl(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconToggleButton$lambda$5(boolean r11, Function1 r12, Modifier r13, boolean r14, IconToggleButtonColors r15, MutableInteractionSource r16, Function2 r17, int r18, int r19, Composer r20, int r21) {
        IconToggleButton(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit IconToggleButton$lambda$6(boolean r12, Function1 r13, Modifier r14, boolean r15, IconToggleButtonColors r16, MutableInteractionSource r17, Shape r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        IconToggleButton(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit IconToggleButtonImpl$lambda$9(boolean r12, Function1 r13, Modifier r14, boolean r15, IconToggleButtonColors r16, MutableInteractionSource r17, Shape r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        IconToggleButtonImpl(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedIconButton$lambda$18(Function0 r12, Modifier r13, boolean r14, Shape r15, IconButtonColors r16, BorderStroke r17, MutableInteractionSource r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        OutlinedIconButton(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedIconToggleButton$lambda$21(boolean r13, Function1 r14, Modifier r15, boolean r16, Shape r17, IconToggleButtonColors r18, BorderStroke r19, MutableInteractionSource r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        OutlinedIconToggleButton(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit SurfaceIconButton$lambda$24(Function0 r11, Modifier r12, boolean r13, Shape r14, IconButtonColors r15, BorderStroke r16, MutableInteractionSource r17, Function2 r18, int r19, Composer r20, int r21) {
        SurfaceIconButton(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SurfaceIconToggleButton$lambda$27(boolean r12, Function1 r13, Modifier r14, boolean r15, Shape r16, IconToggleButtonColors r17, BorderStroke r18, MutableInteractionSource r19, Function2 r20, int r21, Composer r22, int r23) {
        SurfaceIconToggleButton(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, Function1 r1, Modifier r2, boolean r3, Shape r4, IconToggleButtonColors r5, BorderStroke r6, MutableInteractionSource r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return OutlinedIconToggleButton$lambda$21(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit b(boolean r0, Function1 r1, Modifier r2, boolean r3, Shape r4, IconToggleButtonColors r5, MutableInteractionSource r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return FilledIconToggleButton$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit c(Function0 r0, Modifier r1, boolean r2, IconButtonColors r3, MutableInteractionSource r4, Shape r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return IconButton$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit d(SemanticsPropertyReceiver r0) {
        return SurfaceIconButton$lambda$23$lambda$22(r0);
    }

    public static /* synthetic */ Unit e(boolean r0, Function1 r1, Modifier r2, boolean r3, IconToggleButtonColors r4, MutableInteractionSource r5, Shape r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return IconToggleButton$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit f(boolean r0, Function1 r1, Modifier r2, boolean r3, Shape r4, IconToggleButtonColors r5, MutableInteractionSource r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return FilledTonalIconToggleButton$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit g(Function0 r0, Modifier r1, boolean r2, Shape r3, IconButtonColors r4, MutableInteractionSource r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return FilledIconButton$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit h(boolean r0, Function1 r1, Modifier r2, boolean r3, Shape r4, IconToggleButtonColors r5, BorderStroke r6, MutableInteractionSource r7, Function2 r8, int r9, Composer r10, int r11) {
        return SurfaceIconToggleButton$lambda$27(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit i(Function0 r0, Modifier r1, boolean r2, Shape r3, IconButtonColors r4, MutableInteractionSource r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return FilledTonalIconButton$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit j(Function0 r0, Modifier r1, boolean r2, Shape r3, IconButtonColors r4, BorderStroke r5, MutableInteractionSource r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return OutlinedIconButton$lambda$18(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit k(boolean r0, Function1 r1, Modifier r2, boolean r3, IconToggleButtonColors r4, MutableInteractionSource r5, Shape r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return IconToggleButtonImpl$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit l(SemanticsPropertyReceiver r0) {
        return FilledTonalIconToggleButton$lambda$16$lambda$15(r0);
    }

    public static /* synthetic */ Unit m(Function0 r0, Modifier r1, boolean r2, Shape r3, IconButtonColors r4, BorderStroke r5, MutableInteractionSource r6, Function2 r7, int r8, Composer r9, int r10) {
        return SurfaceIconButton$lambda$24(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit n(SemanticsPropertyReceiver r0) {
        return FilledIconToggleButton$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ Unit o(Modifier r0, Function0 r1, boolean r2, Shape r3, IconButtonColors r4, MutableInteractionSource r5, Function2 r6, int r7, Composer r8, int r9) {
        return IconButtonImpl$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit p(boolean r0, Function1 r1, Modifier r2, boolean r3, IconToggleButtonColors r4, MutableInteractionSource r5, Function2 r6, int r7, int r8, Composer r9, int r10) {
        return IconToggleButton$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit q(Function0 r0, Modifier r1, boolean r2, IconButtonColors r3, MutableInteractionSource r4, Function2 r5, int r6, int r7, Composer r8, int r9) {
        return IconButton$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit r(SemanticsPropertyReceiver r0) {
        return OutlinedIconToggleButton$lambda$20$lambda$19(r0);
    }

    public static /* synthetic */ Unit s(SemanticsPropertyReceiver r0) {
        return SurfaceIconToggleButton$lambda$26$lambda$25(r0);
    }

    private static final Unit FilledIconToggleButton$lambda$12$lambda$11(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit FilledTonalIconToggleButton$lambda$16$lambda$15(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit OutlinedIconToggleButton$lambda$20$lambda$19(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit SurfaceIconButton$lambda$23$lambda$22(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit SurfaceIconToggleButton$lambda$26$lambda$25(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with `shape`", replaceWith = @ReplaceWith(expression = "IconButton(onClick, modifier, enabled, colors, interactionSource, shape, content)", imports = {}))
    public static final /* synthetic */ void IconButton(final Function0 r19, Modifier r20, boolean r21, IconButtonColors r22, MutableInteractionSource r23, final Function2 r24, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(-2096213317);
        if ((r27 & 1) == 0) goto L6;
        int r3 = r26 | 6;
    L13:
        int r4 = r27 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r20;
    L24:
        int r6 = r27 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r8 = r21;
    L36:
        if ((r26 & 3072) == 0) goto L38;
        IconButtonColors r9 = r22;
    L46:
        int r10 = r27 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        MutableInteractionSource r11 = r23;
    L58:
        if ((r27 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((74899 & r3) == 74898) goto L70;
        boolean r12 = true;
    L72:
        if (r1.shouldExecute(r12, r3 & 1) == false) goto L101;
        r1.startDefaults();
        if ((r26 & 1) != 0) goto L76;
    L84:
        if (r4 == 0) goto L86;
        Modifier r7 = Modifier.Companion;
    L87:
        if (r6 == 0) goto L90;
        r8 = true;
    L90:
        if ((r27 & 8) == 0) goto L92;
        r3 = r3 & (-7169);
        r9 = IconButtonDefaults.INSTANCE.iconButtonColors(r1, 6);
    L92:
        if (r10 != 0) goto L93;
    L82:
        IconButtonColors r13 = r9;
        MutableInteractionSource r14 = r11;
    L83:
        boolean r18 = r8;
        int r15 = r3;
        final boolean r16 = r18;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(-2096213317, r15, -1, "androidx.compose.material3.IconButton (IconButton.kt:93)");
    L97:
        IconButton(r19, r7, r16, r13, r14, IconButtonDefaults.INSTANCE.getStandardShape(r1, 6), r24, r1, (((((r15 & 14) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | ((r15 << 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventEnd();
    L100:
        r9 = r13;
        final MutableInteractionSource r17 = r14;
    L102:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L106;
        final Modifier r2 = r7;
        final IconButtonColors r28 = r9;
        r110.updateScope(new kc(r19, r2, r16, r28, r17, r24, r26, r27));
        return;
    L106:
        return;
    L93:
        r14 = null;
        r13 = r9;
        goto L83
    L86:
        r7 = r5;
        goto L87
    L76:
        if (r1.getDefaultsInvalid() == true) goto L84;
        r1.skipToGroupEnd();
        if ((r27 & 8) == 0) goto L81;
        r3 = r3 & (-7169);
    L81:
        r7 = r5;
        goto L82
    L101:
        r1.skipToGroupEnd();
        r7 = r5;
        r16 = r8;
        r17 = r11;
        goto L102
    L70:
        r12 = false;
        goto L72
    L61:
        if ((r26 & 196608) != 0) goto L68;
        if (r1.changedInstance(r24) == false) goto L65;
        int r111 = 131072;
    L66:
        r3 = r3 | r111;
        goto L68
    L65:
        r111 = 65536;
        goto L66
    L50:
        if ((r26 & 24576) != 0) goto L56;
        r11 = r23;
        if (r1.changed(r11) == false) goto L54;
        int r112 = 16384;
    L55:
        r3 = r3 | r112;
        goto L58
    L54:
        r112 = 8192;
        goto L55
    L38:
        if ((r27 & 8) != 0) goto L42;
        r9 = r22;
        if (r1.changed(r9) == false) goto L43;
        int r113 = 2048;
    L44:
        r3 = r3 | r113;
    L43:
        r113 = 1024;
        goto L44
    L42:
        r9 = r22;
        goto L43
    L28:
        if ((r26 & 384) != 0) goto L34;
        r8 = r21;
        if (r1.changed(r8) == false) goto L32;
        int r29 = 256;
    L33:
        r3 = r3 | r29;
        goto L36
    L32:
        r29 = 128;
        goto L33
    L17:
        if ((r26 & 48) != 0) goto L23;
        r5 = r20;
        if (r1.changed(r5) == false) goto L21;
        int r30 = 32;
    L22:
        r3 = r3 | r30;
        goto L24
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r26 & 6) == 0) goto L8;
        r3 = r26;
        goto L13
    L8:
        if (r1.changedInstance(r19) == false) goto L10;
        int r31 = 4;
    L11:
        r3 = r31 | r26;
        goto L13
    L10:
        r31 = 2;
        goto L11
    }

    private static final void IconButtonImpl(final Modifier r22, final Function0<Unit> r23, final boolean r24, final Shape r25, final IconButtonColors r26, final MutableInteractionSource r27, final Function2<? super Composer, ? super Integer, Unit> r28, Composer r29, final int r30) {
        Composer r15 = r29.startRestartGroup(-1134296466);
        if ((r30 & 6) == 0) goto L5;
        int r1 = r30;
    L11:
        if ((r30 & 48) != 0) goto L18;
        if (r15.changedInstance(r23) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r30 & 384) != 0) goto L25;
        if (r15.changed(r24) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r30 & 3072) != 0) goto L32;
        if (r15.changed(r25) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r30 & 24576) != 0) goto L39;
        if (r15.changed(r26) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r30) != 0) goto L46;
        if (r15.changed(r27) == false) goto L43;
        int r6 = 131072;
    L44:
        r1 = r1 | r6;
        goto L46
    L43:
        r6 = 65536;
    L46:
        if ((1572864 & r30) == 0) goto L48;
    L52:
        int r7 = r1;
        if ((599187 & r7) == 599186) goto L55;
        boolean r8 = true;
    L57:
        if (r15.shouldExecute(r8, r7 & 1) == true) goto L59;
        r15.skipToGroupEnd();
    L83:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L87;
        r16.updateScope(new nc(r22, r23, r24, r25, r26, r27, r28, r30));
        return;
    L87:
        return;
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-1134296466, r7, -1, "androidx.compose.material3.IconButtonImpl (IconButton.kt:171)");
    L61:
        if (r27 != null) goto L66;
        r15.startReplaceGroup(977045485);
        Object r0 = r15.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L65;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r0);
    L65:
        r15.endReplaceGroup();
        MutableInteractionSource r9 = (MutableInteractionSource) r0;
    L67:
        Modifier r10 = BackgroundKt.m341backgroundbw27NRU(ClipKt.clip(SizeKt.m1015size6HolHcs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(r22), IconButtonDefaults.m2745smallContainerSizeNwlBFI$material3$default(IconButtonDefaults.INSTANCE, 0, 1, null)), r25), r26.m2738containerColorvNxB06k$material3(r24), r25);
        int r11 = Role.Companion.getButton-o7Vup1c();
        Modifier r12 = ChildParentSemanticsKt.childSemantics$default(ClickableKt.m375clickableO2vRcR0$default(r10, r9, RippleKt.m3031rippleH2RKhps$default(false, MenuKt.ClosedAlphaTarget, 0, 7, null), r24, null, Role.box-impl(r11), r23, 8, null), null, 1, null);
        MeasurePolicy r13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r14 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r17 = r15.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r15, r12);
        ComposeUiNode.Companion r19 = ComposeUiNode.Companion;
        Function0 r20 = r19.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L70;
        ComposablesKt.invalidApplier();
    L70:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L73;
        r15.createNode(r20);
    L74:
        Composer r21 = Updater.constructor-impl(r15);
        Updater.set-impl(r21, r13, r19.getSetMeasurePolicy());
        Updater.set-impl(r21, r17, r19.getSetResolvedCompositionLocals());
        Function2 r31 = r19.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L77;
    L78:
        r21.updateRememberedValue(Integer.valueOf(r14));
        r21.apply(Integer.valueOf(r14), r31);
    L79:
        Updater.set-impl(r21, r18, r19.getSetModifier());
        BoxScopeInstance r32 = BoxScopeInstance.INSTANCE;
        long r33 = r26.m2739contentColorvNxB06k$material3(r24);
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r33)), r28, r15, ProvidedValue.$stable | ((r7 >> 15) & 112));
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventEnd();
        goto L83
    L77:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r14)) == true) goto L79;
    L73:
        r15.useNode();
        goto L74
    L66:
        r15.startReplaceGroup(862800938);
        r15.endReplaceGroup();
        r9 = r27;
        goto L67
    L55:
        r8 = false;
        goto L57
    L48:
        if (r15.changedInstance(r28) == false) goto L50;
        int r34 = 1048576;
    L51:
        r1 = r1 | r34;
        goto L52
    L50:
        r34 = 524288;
        goto L51
    L5:
        if (r15.changed(r22) == false) goto L7;
        int r35 = 4;
    L8:
        r1 = r35 | r30;
        goto L11
    L7:
        r35 = 2;
        goto L8
    }

    public static final void FilledIconButton(final Function0<Unit> r20, Modifier r21, boolean r22, Shape r23, IconButtonColors r24, MutableInteractionSource r25, final Function2<? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(947208840);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L13:
        int r4 = r29 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r21;
    L24:
        int r6 = r29 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r22;
    L36:
        if ((r28 & 3072) == 0) goto L38;
        Shape r9 = r23;
    L47:
        if ((r28 & 24576) == 0) goto L49;
        IconButtonColors r10 = r24;
    L57:
        int r11 = r29 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        MutableInteractionSource r13 = r25;
    L69:
        if ((r29 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((599187 & r3) == 599186) goto L81;
        boolean r12 = true;
    L83:
        if (r1.shouldExecute(r12, r3 & 1) == false) goto L118;
        r1.startDefaults();
        if ((r28 & 1) != 0) goto L87;
    L98:
        if (r4 == 0) goto L100;
        Modifier r8 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L104;
        r7 = true;
    L104:
        if ((r29 & 8) == 0) goto L107;
        r3 = r3 & (-7169);
        r9 = IconButtonDefaults.INSTANCE.getFilledShape(r1, 6);
    L107:
        if ((r29 & 16) == 0) goto L109;
        r3 = r3 & (-57345);
        r10 = IconButtonDefaults.INSTANCE.filledIconButtonColors(r1, 6);
    L109:
        if (r11 != 0) goto L110;
    L96:
        final IconButtonColors r14 = r10;
        final MutableInteractionSource r15 = r13;
    L97:
        Shape r19 = r9;
        int r16 = r3;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(947208840, r16, -1, "androidx.compose.material3.FilledIconButton (IconButton.kt:385)");
    L114:
        int r0 = (((((r16 & 14) | 196608) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168)) | (57344 & r16);
        int r17 = r16 << 3;
        SurfaceIconButton(r20, r8, r7, r19, r14, null, r15, r26, r1, (r0 | (3670016 & r17)) | (r17 & 29360128));
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        r9 = r19;
        final boolean r18 = r7;
    L119:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L123;
        final Modifier r2 = r8;
        final Shape r30 = r9;
        r110.updateScope(new oc(r20, r2, r18, r30, r14, r15, r26, r28, r29));
        return;
    L123:
        return;
    L110:
        r15 = null;
        r14 = r10;
        goto L97
    L100:
        r8 = r5;
        goto L101
    L87:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r29 & 8) == 0) goto L93;
        r3 = r3 & (-7169);
    L93:
        if ((r29 & 16) == 0) goto L95;
        r3 = r3 & (-57345);
    L95:
        r8 = r5;
        goto L96
    L118:
        r1.skipToGroupEnd();
        r8 = r5;
        r18 = r7;
        r14 = r10;
        r15 = r13;
        goto L119
    L81:
        r12 = false;
        goto L83
    L72:
        if ((r28 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r26) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((r28 & 196608) != 0) goto L67;
        r13 = r25;
        if (r1.changed(r13) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L49:
        if ((r29 & 16) != 0) goto L53;
        r10 = r24;
        if (r1.changed(r10) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r10 = r24;
        goto L54
    L38:
        if ((r29 & 8) != 0) goto L42;
        r9 = r23;
        if (r1.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r23;
        goto L43
    L28:
        if ((r28 & 384) != 0) goto L34;
        r7 = r22;
        if (r1.changed(r7) == false) goto L32;
        int r31 = 256;
    L33:
        r3 = r3 | r31;
        goto L36
    L32:
        r31 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r5 = r21;
        if (r1.changed(r5) == false) goto L21;
        int r32 = 32;
    L22:
        r3 = r3 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L13
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r33 = 4;
    L11:
        r3 = r33 | r28;
        goto L13
    L10:
        r33 = 2;
        goto L11
    }

    public static final void FilledTonalIconButton(final Function0<Unit> r20, Modifier r21, boolean r22, Shape r23, IconButtonColors r24, MutableInteractionSource r25, final Function2<? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-399178234);
        if ((r29 & 1) == 0) goto L6;
        int r3 = r28 | 6;
    L13:
        int r4 = r29 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r21;
    L24:
        int r6 = r29 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r22;
    L36:
        if ((r28 & 3072) == 0) goto L38;
        Shape r9 = r23;
    L47:
        if ((r28 & 24576) == 0) goto L49;
        IconButtonColors r10 = r24;
    L57:
        int r11 = r29 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        MutableInteractionSource r13 = r25;
    L69:
        if ((r29 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((599187 & r3) == 599186) goto L81;
        boolean r12 = true;
    L83:
        if (r1.shouldExecute(r12, r3 & 1) == false) goto L118;
        r1.startDefaults();
        if ((r28 & 1) != 0) goto L87;
    L98:
        if (r4 == 0) goto L100;
        Modifier r8 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L104;
        r7 = true;
    L104:
        if ((r29 & 8) == 0) goto L107;
        r3 = r3 & (-7169);
        r9 = IconButtonDefaults.INSTANCE.getFilledShape(r1, 6);
    L107:
        if ((r29 & 16) == 0) goto L109;
        r3 = r3 & (-57345);
        r10 = IconButtonDefaults.INSTANCE.filledTonalIconButtonColors(r1, 6);
    L109:
        if (r11 != 0) goto L110;
    L96:
        final IconButtonColors r14 = r10;
        final MutableInteractionSource r15 = r13;
    L97:
        Shape r19 = r9;
        int r16 = r3;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(-399178234, r16, -1, "androidx.compose.material3.FilledTonalIconButton (IconButton.kt:495)");
    L114:
        int r0 = (((((r16 & 14) | 196608) | (r16 & 112)) | (r16 & 896)) | (r16 & 7168)) | (57344 & r16);
        int r17 = r16 << 3;
        SurfaceIconButton(r20, r8, r7, r19, r14, null, r15, r26, r1, (r0 | (3670016 & r17)) | (r17 & 29360128));
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        r9 = r19;
        final boolean r18 = r7;
    L119:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L123;
        final Modifier r2 = r8;
        final Shape r30 = r9;
        r110.updateScope(new fc(r20, r2, r18, r30, r14, r15, r26, r28, r29));
        return;
    L123:
        return;
    L110:
        r15 = null;
        r14 = r10;
        goto L97
    L100:
        r8 = r5;
        goto L101
    L87:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r29 & 8) == 0) goto L93;
        r3 = r3 & (-7169);
    L93:
        if ((r29 & 16) == 0) goto L95;
        r3 = r3 & (-57345);
    L95:
        r8 = r5;
        goto L96
    L118:
        r1.skipToGroupEnd();
        r8 = r5;
        r18 = r7;
        r14 = r10;
        r15 = r13;
        goto L119
    L81:
        r12 = false;
        goto L83
    L72:
        if ((r28 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r26) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((r28 & 196608) != 0) goto L67;
        r13 = r25;
        if (r1.changed(r13) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L49:
        if ((r29 & 16) != 0) goto L53;
        r10 = r24;
        if (r1.changed(r10) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r10 = r24;
        goto L54
    L38:
        if ((r29 & 8) != 0) goto L42;
        r9 = r23;
        if (r1.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r23;
        goto L43
    L28:
        if ((r28 & 384) != 0) goto L34;
        r7 = r22;
        if (r1.changed(r7) == false) goto L32;
        int r31 = 256;
    L33:
        r3 = r3 | r31;
        goto L36
    L32:
        r31 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r5 = r21;
        if (r1.changed(r5) == false) goto L21;
        int r32 = 32;
    L22:
        r3 = r3 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r3 = r28;
        goto L13
    L8:
        if (r1.changedInstance(r20) == false) goto L10;
        int r33 = 4;
    L11:
        r3 = r33 | r28;
        goto L13
    L10:
        r33 = 2;
        goto L11
    }

    public static final void IconButton(final Function0<Unit> r19, Modifier r20, boolean r21, IconButtonColors r22, MutableInteractionSource r23, Shape r24, final Function2<? super Composer, ? super Integer, Unit> r25, Composer r26, final int r27, final int r28) {
        Composer r1 = r26.startRestartGroup(1413012038);
        if ((r28 & 1) == 0) goto L6;
        int r3 = r27 | 6;
    L13:
        int r4 = r28 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r20;
    L24:
        int r6 = r28 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r21;
    L36:
        if ((r27 & 3072) == 0) goto L38;
        IconButtonColors r9 = r22;
    L46:
        int r10 = r28 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        MutableInteractionSource r11 = r23;
    L58:
        if ((196608 & r27) == 0) goto L60;
        Shape r12 = r24;
    L69:
        if ((r28 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((599187 & r3) == 599186) goto L81;
        boolean r13 = true;
    L83:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L118;
        r1.startDefaults();
        if ((r27 & 1) != 0) goto L87;
    L98:
        if (r4 == 0) goto L100;
        Modifier r8 = Modifier.Companion;
    L101:
        if (r6 == 0) goto L104;
        r7 = true;
    L104:
        if ((r28 & 8) == 0) goto L106;
        r3 = r3 & (-7169);
        r9 = IconButtonDefaults.INSTANCE.iconButtonColors(r1, 6);
    L106:
        if (r10 == 0) goto L109;
        r11 = null;
    L109:
        if ((r28 & 32) != 0) goto L110;
    L96:
        final MutableInteractionSource r14 = r11;
        final Shape r15 = r12;
    L97:
        IconButtonColors r18 = r9;
        int r16 = r3;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(1413012038, r16, -1, "androidx.compose.material3.IconButton (IconButton.kt:151)");
    L114:
        int r17 = r16 << 3;
        IconButtonImpl(r8, r19, r7, r15, r18, r14, r25, r1, (((((((r16 >> 3) & 14) | (r17 & 112)) | (r16 & 896)) | ((r16 >> 6) & 7168)) | (57344 & r17)) | (r17 & 458752)) | (r16 & 3670016));
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        r9 = r18;
        final boolean r29 = r7;
    L119:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L123;
        final Modifier r2 = r8;
        final IconButtonColors r30 = r9;
        r110.updateScope(new ec(r19, r2, r29, r30, r14, r15, r25, r27, r28));
        return;
    L123:
        return;
    L110:
        r3 = r3 & (-458753);
        r15 = IconButtonDefaults.INSTANCE.getStandardShape(r1, 6);
        r14 = r11;
        goto L97
    L100:
        r8 = r5;
        goto L101
    L87:
        if (r1.getDefaultsInvalid() == true) goto L98;
        r1.skipToGroupEnd();
        if ((r28 & 8) == 0) goto L93;
        r3 = r3 & (-7169);
    L93:
        if ((r28 & 32) == 0) goto L95;
        r3 = r3 & (-458753);
    L95:
        r8 = r5;
        goto L96
    L118:
        r1.skipToGroupEnd();
        r8 = r5;
        r29 = r7;
        r14 = r11;
        r15 = r12;
        goto L119
    L81:
        r13 = false;
        goto L83
    L72:
        if ((r27 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r25) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L60:
        if ((r28 & 32) != 0) goto L64;
        r12 = r24;
        if (r1.changed(r12) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
    L65:
        r112 = 65536;
        goto L66
    L64:
        r12 = r24;
        goto L65
    L50:
        if ((r27 & 24576) != 0) goto L56;
        r11 = r23;
        if (r1.changed(r11) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L58
    L54:
        r113 = 8192;
        goto L55
    L38:
        if ((r28 & 8) != 0) goto L42;
        r9 = r22;
        if (r1.changed(r9) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r9 = r22;
        goto L43
    L28:
        if ((r27 & 384) != 0) goto L34;
        r7 = r21;
        if (r1.changed(r7) == false) goto L32;
        int r31 = 256;
    L33:
        r3 = r3 | r31;
        goto L36
    L32:
        r31 = 128;
        goto L33
    L17:
        if ((r27 & 48) != 0) goto L23;
        r5 = r20;
        if (r1.changed(r5) == false) goto L21;
        int r32 = 32;
    L22:
        r3 = r3 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r27 & 6) == 0) goto L8;
        r3 = r27;
        goto L13
    L8:
        if (r1.changedInstance(r19) == false) goto L10;
        int r33 = 4;
    L11:
        r3 = r33 | r27;
        goto L13
    L10:
        r33 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with `shape`", replaceWith = @ReplaceWith(expression = "IconToggleButton(checked, onCheckedChange, modifier, enabled, colors, interactionSource, shape, content)", imports = {}))
    public static final /* synthetic */ void IconToggleButton(final boolean r21, final Function1 r22, Modifier r23, boolean r24, IconToggleButtonColors r25, MutableInteractionSource r26, final Function2 r27, Composer r28, final int r29, final int r30) {
        Composer r1 = r28.startRestartGroup(-1307193856);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r29 | 6;
    L14:
        if ((r30 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r30 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r23;
    L35:
        int r7 = r30 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r9 = r24;
    L47:
        if ((r29 & 24576) == 0) goto L49;
        IconToggleButtonColors r10 = r25;
    L57:
        int r11 = r30 & 32;
        if (r11 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        MutableInteractionSource r12 = r26;
    L69:
        if ((r30 & 64) == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((599187 & r3) == 599186) goto L81;
        boolean r13 = true;
    L83:
        if (r1.shouldExecute(r13, r3 & 1) == false) goto L110;
        r1.startDefaults();
        if ((r29 & 1) != 0) goto L87;
    L94:
        if (r5 == 0) goto L96;
        r6 = Modifier.Companion;
    L96:
        if (r7 == 0) goto L99;
        r9 = true;
    L99:
        if ((r30 & 16) == 0) goto L101;
        r3 = r3 & (-57345);
        r10 = IconButtonDefaults.INSTANCE.iconToggleButtonColors(r1, 6);
    L101:
        if (r11 != 0) goto L102;
    L92:
        final IconToggleButtonColors r8 = r10;
        MutableInteractionSource r14 = r12;
    L93:
        boolean r20 = r9;
        int r15 = r3;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L106;
        ComposerKt.traceEventStart(-1307193856, r15, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:243)");
    L106:
        IconToggleButton(r21, r22, r6, r20, r8, r14, IconButtonDefaults.INSTANCE.getStandardShape(r1, 6), r27, r1, ((((((r15 & 14) | (r15 & 112)) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (458752 & r15)) | ((r15 << 3) & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventEnd();
    L109:
        r9 = r20;
        final Modifier r4 = r6;
        final MutableInteractionSource r16 = r14;
    L111:
        ScopeUpdateScope r17 = r1.endRestartGroup();
        if (r17 == null) goto L115;
        final boolean r18 = r9;
        r17.updateScope(new pc(r21, r22, r4, r18, r8, r16, r27, r29, r30));
        return;
    L115:
        return;
    L102:
        r14 = null;
        r8 = r10;
        goto L93
    L87:
        if (r1.getDefaultsInvalid() == true) goto L94;
        r1.skipToGroupEnd();
        if ((r30 & 16) == 0) goto L92;
        r3 = r3 & (-57345);
        goto L92
    L110:
        r1.skipToGroupEnd();
        r4 = r6;
        r8 = r10;
        r16 = r12;
        goto L111
    L81:
        r13 = false;
        goto L83
    L72:
        if ((r29 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r27) == false) goto L76;
        int r19 = 1048576;
    L77:
        r3 = r3 | r19;
        goto L79
    L76:
        r19 = 524288;
        goto L77
    L61:
        if ((196608 & r29) != 0) goto L67;
        r12 = r26;
        if (r1.changed(r12) == false) goto L65;
        int r110 = 131072;
    L66:
        r3 = r3 | r110;
        goto L69
    L65:
        r110 = 65536;
        goto L66
    L49:
        if ((r30 & 16) != 0) goto L53;
        r10 = r25;
        if (r1.changed(r10) == false) goto L54;
        int r111 = 16384;
    L55:
        r3 = r3 | r111;
    L54:
        r111 = 8192;
        goto L55
    L53:
        r10 = r25;
        goto L54
    L39:
        if ((r29 & 3072) != 0) goto L45;
        r9 = r24;
        if (r1.changed(r9) == false) goto L43;
        int r112 = 2048;
    L44:
        r3 = r3 | r112;
        goto L47
    L43:
        r112 = 1024;
        goto L44
    L28:
        if ((r29 & 384) != 0) goto L34;
        r6 = r23;
        if (r1.changed(r6) == false) goto L32;
        int r31 = 256;
    L33:
        r3 = r3 | r31;
        goto L35
    L32:
        r31 = 128;
        goto L33
    L17:
        if ((r29 & 48) != 0) goto L24;
        if (r1.changedInstance(r22) == false) goto L21;
        int r32 = 32;
    L22:
        r3 = r3 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r29 & 6) == 0) goto L8;
        r3 = r29;
        goto L14
    L8:
        if (r1.changed(r21) == false) goto L10;
        int r33 = 4;
    L11:
        r3 = r33 | r29;
        goto L14
    L10:
        r33 = 2;
        goto L11
    }

    private static final void SurfaceIconButton(final Function0<Unit> r20, final Modifier r21, final boolean r22, final Shape r23, final IconButtonColors r24, final BorderStroke r25, final MutableInteractionSource r26, final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29) {
        Composer r6 = r28.startRestartGroup(-171935091);
        if ((r29 & 6) == 0) goto L5;
        int r4 = r29;
    L11:
        if ((r29 & 48) != 0) goto L18;
        if (r6.changed(r21) == false) goto L15;
        int r7 = 32;
    L16:
        r4 = r4 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r29 & 384) != 0) goto L25;
        if (r6.changed(r22) == false) goto L22;
        int r8 = 256;
    L23:
        r4 = r4 | r8;
        goto L25
    L22:
        r8 = 128;
    L25:
        if ((r29 & 3072) != 0) goto L32;
        if (r6.changed(r23) == false) goto L29;
        int r9 = 2048;
    L30:
        r4 = r4 | r9;
        goto L32
    L29:
        r9 = 1024;
    L32:
        if ((r29 & 24576) != 0) goto L39;
        if (r6.changed(r24) == false) goto L36;
        int r10 = 16384;
    L37:
        r4 = r4 | r10;
        goto L39
    L36:
        r10 = 8192;
    L39:
        if ((196608 & r29) != 0) goto L46;
        if (r6.changed(r25) == false) goto L43;
        int r11 = 131072;
    L44:
        r4 = r4 | r11;
        goto L46
    L43:
        r11 = 65536;
    L46:
        if ((1572864 & r29) != 0) goto L53;
        if (r6.changed(r26) == false) goto L50;
        int r12 = 1048576;
    L51:
        r4 = r4 | r12;
        goto L53
    L50:
        r12 = 524288;
    L53:
        if ((12582912 & r29) == 0) goto L55;
    L59:
        int r13 = r4;
        if ((4793491 & r13) == 4793490) goto L62;
        boolean r5 = true;
    L64:
        if (r6.shouldExecute(r5, r13 & 1) == true) goto L66;
        Composer r0 = r6;
        r0.skipToGroupEnd();
    L75:
        ScopeUpdateScope r14 = r0.endRestartGroup();
        if (r14 == null) goto L79;
        r14.updateScope(new jc(r20, r21, r22, r23, r24, r25, r26, r27, r29));
        return;
    L79:
        return;
    L66:
        if (ComposerKt.isTraceInProgress() == false) goto L68;
        ComposerKt.traceEventStart(-171935091, r13, -1, "androidx.compose.material3.SurfaceIconButton (IconButton.kt:698)");
    L68:
        Object r3 = r6.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L71;
        r3 = new ic();
        r6.updateRememberedValue(r3);
    L71:
        int r1 = ((r13 & 14) | (r13 & 896)) | (r13 & 7168);
        int r2 = r13 << 9;
        int r17 = (r1 | (234881024 & r2)) | (r2 & 1879048192);
        r0 = r6;
        SurfaceKt.m3216Surfaceo_FOJdg(r20, SemanticsModifierKt.semantics$default(r21, false, (Function1) r3, 1, null), r22, r23, r24.m2738containerColorvNxB06k$material3(r22), r24.m2739contentColorvNxB06k$material3(r22), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r25, r26, ComposableLambdaKt.rememberComposableLambda(669231714, true, new AnonymousClass2(r27), r6, 54), r0, r17, 6, 192);
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventEnd();
        goto L75
    L62:
        r5 = false;
        goto L64
    L55:
        if (r6.changedInstance(r27) == false) goto L57;
        int r15 = 8388608;
    L58:
        r4 = r4 | r15;
        goto L59
    L57:
        r15 = 4194304;
        goto L58
    L5:
        if (r6.changedInstance(r20) == false) goto L7;
        int r16 = 4;
    L8:
        r4 = r16 | r29;
        goto L11
    L7:
        r16 = 2;
        goto L8
    }

    public static final void FilledIconToggleButton(final boolean r23, final Function1<? super Boolean, Unit> r24, Modifier r25, boolean r26, Shape r27, IconToggleButtonColors r28, MutableInteractionSource r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-713829427);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r33 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r25;
    L35:
        int r7 = r33 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r8 = r26;
    L47:
        if ((r32 & 24576) == 0) goto L49;
        Shape r11 = r27;
    L58:
        if ((196608 & r32) == 0) goto L60;
        IconToggleButtonColors r12 = r28;
    L68:
        int r13 = r33 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        MutableInteractionSource r15 = r29;
    L80:
        if ((r33 & 128) == 0) goto L83;
        r3 = r3 | 12582912;
    L91:
        if ((r3 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L130;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L99;
    L108:
        if (r5 == 0) goto L110;
        r6 = Modifier.Companion;
    L110:
        if (r7 == 0) goto L113;
        r8 = true;
    L113:
        if ((r33 & 16) == 0) goto L116;
        r3 = r3 & (-57345);
        r11 = IconButtonDefaults.INSTANCE.getFilledShape(r1, 6);
    L116:
        if ((r33 & 32) == 0) goto L118;
        r3 = r3 & (-458753);
        r12 = IconButtonDefaults.INSTANCE.filledIconToggleButtonColors(r1, 6);
    L118:
        if (r13 != 0) goto L119;
    L107:
        int r9 = r3;
        Shape r2 = r11;
        IconToggleButtonColors r4 = r12;
        MutableInteractionSource r10 = r15;
    L120:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventStart(-713829427, r9, -1, "androidx.compose.material3.FilledIconToggleButton (IconButton.kt:438)");
    L123:
        Object r14 = r1.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L126;
        r14 = new qc();
        r1.updateRememberedValue(r14);
    L126:
        int r16 = r9 << 3;
        boolean r17 = r8;
        Shape r18 = r2;
        IconToggleButtonColors r19 = r4;
        MutableInteractionSource r110 = r10;
        SurfaceIconToggleButton(r23, r24, SemanticsModifierKt.semantics$default(r6, false, (Function1) r14, 1, null), r17, r18, r19, null, r110, r30, r1, (((((((r9 & 14) | 1572864) | (r9 & 112)) | (r9 & 7168)) | (57344 & r9)) | (458752 & r9)) | (29360128 & r16)) | (r16 & 234881024));
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventEnd();
    L129:
        final MutableInteractionSource r20 = r10;
        final boolean r21 = r8;
        final Shape r22 = r2;
        Modifier r210 = r6;
        final IconToggleButtonColors r34 = r4;
        final Modifier r35 = r210;
    L131:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L135;
        r111.updateScope(new rc(r23, r24, r35, r21, r22, r34, r20, r30, r32, r33));
        return;
    L135:
        return;
    L119:
        r10 = null;
        r9 = r3;
        r2 = r11;
        r4 = r12;
        goto L120
    L99:
        if (r1.getDefaultsInvalid() == true) goto L108;
        r1.skipToGroupEnd();
        if ((r33 & 16) == 0) goto L105;
        r3 = r3 & (-57345);
    L105:
        if ((r33 & 32) == 0) goto L107;
        r3 = r3 & (-458753);
        goto L107
    L130:
        r1.skipToGroupEnd();
        r35 = r6;
        r21 = r8;
        r22 = r11;
        r34 = r12;
        r20 = r15;
        goto L131
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r32 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r30) == false) goto L87;
        int r112 = 8388608;
    L88:
        r3 = r3 | r112;
        goto L91
    L87:
        r112 = 4194304;
        goto L88
    L72:
        if ((r32 & 1572864) != 0) goto L78;
        r15 = r29;
        if (r1.changed(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L80
    L76:
        r113 = 524288;
        goto L77
    L60:
        if ((r33 & 32) != 0) goto L64;
        r12 = r28;
        if (r1.changed(r12) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
    L65:
        r114 = 65536;
        goto L66
    L64:
        r12 = r28;
        goto L65
    L49:
        if ((r33 & 16) != 0) goto L53;
        r11 = r27;
        if (r1.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r11 = r27;
        goto L54
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r8 = r26;
        if (r1.changed(r8) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r32 & 384) != 0) goto L34;
        r6 = r25;
        if (r1.changed(r6) == false) goto L32;
        int r36 = 256;
    L33:
        r3 = r3 | r36;
        goto L35
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L24;
        if (r1.changedInstance(r24) == false) goto L21;
        int r37 = 32;
    L22:
        r3 = r3 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L14
    L8:
        if (r1.changed(r23) == false) goto L10;
        int r38 = 4;
    L11:
        r3 = r38 | r32;
        goto L14
    L10:
        r38 = 2;
        goto L11
    }

    public static final void FilledTonalIconToggleButton(final boolean r23, final Function1<? super Boolean, Unit> r24, Modifier r25, boolean r26, Shape r27, IconToggleButtonColors r28, MutableInteractionSource r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-436409269);
        if ((r33 & 1) == 0) goto L6;
        int r3 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r33 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r25;
    L35:
        int r7 = r33 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r8 = r26;
    L47:
        if ((r32 & 24576) == 0) goto L49;
        Shape r11 = r27;
    L58:
        if ((196608 & r32) == 0) goto L60;
        IconToggleButtonColors r12 = r28;
    L68:
        int r13 = r33 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        MutableInteractionSource r15 = r29;
    L80:
        if ((r33 & 128) == 0) goto L83;
        r3 = r3 | 12582912;
    L91:
        if ((r3 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L130;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L99;
    L108:
        if (r5 == 0) goto L110;
        r6 = Modifier.Companion;
    L110:
        if (r7 == 0) goto L113;
        r8 = true;
    L113:
        if ((r33 & 16) == 0) goto L116;
        r3 = r3 & (-57345);
        r11 = IconButtonDefaults.INSTANCE.getFilledShape(r1, 6);
    L116:
        if ((r33 & 32) == 0) goto L118;
        r3 = r3 & (-458753);
        r12 = IconButtonDefaults.INSTANCE.filledTonalIconToggleButtonColors(r1, 6);
    L118:
        if (r13 != 0) goto L119;
    L107:
        int r9 = r3;
        Shape r2 = r11;
        IconToggleButtonColors r4 = r12;
        MutableInteractionSource r10 = r15;
    L120:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventStart(-436409269, r9, -1, "androidx.compose.material3.FilledTonalIconToggleButton (IconButton.kt:554)");
    L123:
        Object r14 = r1.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L126;
        r14 = new bc();
        r1.updateRememberedValue(r14);
    L126:
        int r16 = r9 << 3;
        boolean r17 = r8;
        Shape r18 = r2;
        IconToggleButtonColors r19 = r4;
        MutableInteractionSource r110 = r10;
        SurfaceIconToggleButton(r23, r24, SemanticsModifierKt.semantics$default(r6, false, (Function1) r14, 1, null), r17, r18, r19, null, r110, r30, r1, (((((((r9 & 14) | 1572864) | (r9 & 112)) | (r9 & 7168)) | (57344 & r9)) | (458752 & r9)) | (29360128 & r16)) | (r16 & 234881024));
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventEnd();
    L129:
        final MutableInteractionSource r20 = r10;
        final boolean r21 = r8;
        final Shape r22 = r2;
        Modifier r210 = r6;
        final IconToggleButtonColors r34 = r4;
        final Modifier r35 = r210;
    L131:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L135;
        r111.updateScope(new cc(r23, r24, r35, r21, r22, r34, r20, r30, r32, r33));
        return;
    L135:
        return;
    L119:
        r10 = null;
        r9 = r3;
        r2 = r11;
        r4 = r12;
        goto L120
    L99:
        if (r1.getDefaultsInvalid() == true) goto L108;
        r1.skipToGroupEnd();
        if ((r33 & 16) == 0) goto L105;
        r3 = r3 & (-57345);
    L105:
        if ((r33 & 32) == 0) goto L107;
        r3 = r3 & (-458753);
        goto L107
    L130:
        r1.skipToGroupEnd();
        r35 = r6;
        r21 = r8;
        r22 = r11;
        r34 = r12;
        r20 = r15;
        goto L131
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r32 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r30) == false) goto L87;
        int r112 = 8388608;
    L88:
        r3 = r3 | r112;
        goto L91
    L87:
        r112 = 4194304;
        goto L88
    L72:
        if ((r32 & 1572864) != 0) goto L78;
        r15 = r29;
        if (r1.changed(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L80
    L76:
        r113 = 524288;
        goto L77
    L60:
        if ((r33 & 32) != 0) goto L64;
        r12 = r28;
        if (r1.changed(r12) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
    L65:
        r114 = 65536;
        goto L66
    L64:
        r12 = r28;
        goto L65
    L49:
        if ((r33 & 16) != 0) goto L53;
        r11 = r27;
        if (r1.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r11 = r27;
        goto L54
    L39:
        if ((r32 & 3072) != 0) goto L45;
        r8 = r26;
        if (r1.changed(r8) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r32 & 384) != 0) goto L34;
        r6 = r25;
        if (r1.changed(r6) == false) goto L32;
        int r36 = 256;
    L33:
        r3 = r3 | r36;
        goto L35
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L24;
        if (r1.changedInstance(r24) == false) goto L21;
        int r37 = 32;
    L22:
        r3 = r3 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r3 = r32;
        goto L14
    L8:
        if (r1.changed(r23) == false) goto L10;
        int r38 = 4;
    L11:
        r3 = r38 | r32;
        goto L14
    L10:
        r38 = 2;
        goto L11
    }

    public static final void IconToggleButton(final boolean r22, final Function1<? super Boolean, Unit> r23, Modifier r24, boolean r25, IconToggleButtonColors r26, MutableInteractionSource r27, Shape r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-1031402037);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L14:
        if ((r32 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r5 = r32 & 4;
        if (r5 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r6 = r24;
    L35:
        int r7 = r32 & 8;
        if (r7 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r8 = r25;
    L47:
        if ((r31 & 24576) == 0) goto L49;
        IconToggleButtonColors r11 = r26;
    L57:
        int r12 = r32 & 32;
        if (r12 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        MutableInteractionSource r13 = r27;
    L69:
        if ((1572864 & r31) == 0) goto L71;
        Shape r14 = r28;
    L80:
        if ((r32 & 128) == 0) goto L83;
        r3 = r3 | 12582912;
    L91:
        if ((r3 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L127;
        r1.startDefaults();
        if ((r31 & 1) != 0) goto L99;
    L108:
        if (r5 == 0) goto L110;
        r6 = Modifier.Companion;
    L110:
        if (r7 == 0) goto L113;
        r8 = true;
    L113:
        if ((r32 & 16) == 0) goto L115;
        r3 = r3 & (-57345);
        r11 = IconButtonDefaults.INSTANCE.iconToggleButtonColors(r1, 6);
    L115:
        if (r12 == 0) goto L118;
        r13 = null;
    L118:
        if ((r32 & 64) != 0) goto L119;
    L107:
        int r9 = r3;
        IconToggleButtonColors r2 = r11;
        MutableInteractionSource r4 = r13;
        Shape r10 = r14;
    L120:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventStart(-1031402037, r9, -1, "androidx.compose.material3.IconToggleButton (IconButton.kt:299)");
    L123:
        IconToggleButtonImpl(r22, r23, r6, r8, r2, r4, r10, r29, r1, (((((((r9 & 14) | (r9 & 112)) | (r9 & 896)) | (r9 & 7168)) | (57344 & r9)) | (458752 & r9)) | (3670016 & r9)) | (r9 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        final IconToggleButtonColors r15 = r2;
        final Shape r16 = r10;
        final Modifier r17 = r6;
        final MutableInteractionSource r18 = r4;
    L128:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L132;
        final boolean r20 = r8;
        r19.updateScope(new dc(r22, r23, r17, r20, r15, r18, r16, r29, r31, r32));
        return;
    L132:
        return;
    L119:
        r9 = r3 & (-3670017);
        r4 = r13;
        r10 = IconButtonDefaults.INSTANCE.getStandardShape(r1, 6);
        r2 = r11;
        goto L120
    L99:
        if (r1.getDefaultsInvalid() == true) goto L108;
        r1.skipToGroupEnd();
        if ((r32 & 16) == 0) goto L105;
        r3 = r3 & (-57345);
    L105:
        if ((r32 & 64) == 0) goto L107;
        r3 = r3 & (-3670017);
        goto L107
    L127:
        r1.skipToGroupEnd();
        r17 = r6;
        r15 = r11;
        r18 = r13;
        r16 = r14;
        goto L128
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r31 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r29) == false) goto L87;
        int r110 = 8388608;
    L88:
        r3 = r3 | r110;
        goto L91
    L87:
        r110 = 4194304;
        goto L88
    L71:
        if ((r32 & 64) != 0) goto L75;
        r14 = r28;
        if (r1.changed(r14) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
    L76:
        r111 = 524288;
        goto L77
    L75:
        r14 = r28;
        goto L76
    L61:
        if ((196608 & r31) != 0) goto L67;
        r13 = r27;
        if (r1.changed(r13) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L69
    L65:
        r112 = 65536;
        goto L66
    L49:
        if ((r32 & 16) != 0) goto L53;
        r11 = r26;
        if (r1.changed(r11) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
    L54:
        r113 = 8192;
        goto L55
    L53:
        r11 = r26;
        goto L54
    L39:
        if ((r31 & 3072) != 0) goto L45;
        r8 = r25;
        if (r1.changed(r8) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L47
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r31 & 384) != 0) goto L34;
        r6 = r24;
        if (r1.changed(r6) == false) goto L32;
        int r21 = 256;
    L33:
        r3 = r3 | r21;
        goto L35
    L32:
        r21 = 128;
        goto L33
    L17:
        if ((r31 & 48) != 0) goto L24;
        if (r1.changedInstance(r23) == false) goto L21;
        int r33 = 32;
    L22:
        r3 = r3 | r33;
        goto L24
    L21:
        r33 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L14
    L8:
        if (r1.changed(r22) == false) goto L10;
        int r34 = 4;
    L11:
        r3 = r34 | r31;
        goto L14
    L10:
        r34 = 2;
        goto L11
    }

    private static final void IconToggleButtonImpl(final boolean r25, final Function1<? super Boolean, Unit> r26, Modifier r27, boolean r28, IconToggleButtonColors r29, MutableInteractionSource r30, Shape r31, final Function2<? super Composer, ? super Integer, Unit> r32, Composer r33, final int r34, final int r35) {
        Composer r11 = r33.startRestartGroup(1724745099);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L14:
        if ((r35 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r35 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r35 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r5 = r28;
    L46:
        if ((r34 & 24576) == 0) goto L48;
        IconToggleButtonColors r6 = r29;
    L56:
        int r13 = r35 & 32;
        if (r13 == 0) goto L60;
        r1 = r1 | 196608;
    L66:
        MutableInteractionSource r14 = r30;
    L68:
        if ((1572864 & r34) == 0) goto L70;
        Shape r15 = r31;
    L79:
        if ((r35 & 128) == 0) goto L82;
        r1 = r1 | 12582912;
    L89:
        if ((4793491 & r1) == 4793490) goto L91;
        boolean r0 = true;
    L93:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L146;
        r11.startDefaults();
        if ((r34 & 1) != 0) goto L97;
    L107:
        if (r2 == 0) goto L109;
        Modifier r3 = Modifier.Companion;
    L110:
        if (r4 == 0) goto L113;
        r5 = true;
    L113:
        if ((r35 & 16) == 0) goto L115;
        r1 = r1 & (-57345);
        r6 = IconButtonDefaults.INSTANCE.iconToggleButtonVibrantColors(r11, 6);
    L115:
        if (r13 == 0) goto L118;
        r14 = null;
    L118:
        if ((r35 & 64) == 0) goto L120;
        Modifier r16 = r3;
        IconToggleButtonColors r17 = r6;
        MutableInteractionSource r18 = r14;
        Shape r7 = IconButtonDefaults.INSTANCE.getStandardShape(r11, 6);
        boolean r19 = r5;
        int r8 = r1 & (-3670017);
    L121:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L124;
        ComposerKt.traceEventStart(1724745099, r8, -1, "androidx.compose.material3.IconToggleButtonImpl (IconButton.kt:320)");
    L124:
        if (r18 != null) goto L129;
        r11.startReplaceGroup(1187972528);
        Object r9 = r11.rememberedValue();
        if (r9 != Composer.Companion.getEmpty()) goto L128;
        r9 = InteractionSourceKt.MutableInteractionSource();
        r11.updateRememberedValue(r9);
    L128:
        r11.endReplaceGroup();
        MutableInteractionSource r10 = (MutableInteractionSource) r9;
    L130:
        int r12 = (((r8 >> 9) & 14) | ((r8 << 3) & 112)) | ((r8 >> 6) & 896);
        boolean r20 = r19;
        int r110 = r8;
        Shape r111 = r7;
        Modifier r21 = ToggleableKt.m1297toggleableO2vRcR0(BackgroundKt.m342backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1015size6HolHcs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(r16), IconButtonDefaults.m2745smallContainerSizeNwlBFI$material3$default(IconButtonDefaults.INSTANCE, 0, 1, null)), r7), ((Color) r17.containerColor$material3(r19, r25, r11, r12).getValue()).unbox-impl(), null, 2, null), r25, r10, RippleKt.m3031rippleH2RKhps$default(false, MenuKt.ClosedAlphaTarget, 0, 7, null), r20, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), r26);
        MeasurePolicy r22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r23 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r24 = r11.getCurrentCompositionLocalMap();
        Modifier r36 = ComposedModifierKt.materializeModifier(r11, r21);
        ComposeUiNode.Companion r37 = ComposeUiNode.Companion;
        Function0 r38 = r37.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L133;
        ComposablesKt.invalidApplier();
    L133:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L136;
        r11.createNode(r38);
    L137:
        Composer r39 = Updater.constructor-impl(r11);
        Updater.set-impl(r39, r22, r37.getSetMeasurePolicy());
        Updater.set-impl(r39, r24, r37.getSetResolvedCompositionLocals());
        Function2 r40 = r37.getSetCompositeKeyHash();
        if (r39.getInserting() == false) goto L140;
    L141:
        r39.updateRememberedValue(Integer.valueOf(r23));
        r39.apply(Integer.valueOf(r23), r40);
    L142:
        Updater.set-impl(r39, r36, r37.getSetModifier());
        BoxScopeInstance r41 = BoxScopeInstance.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(((Color) r17.contentColor$material3(r19, r25, r11, r12).getValue()).unbox-impl())), r32, r11, ProvidedValue.$stable | ((r110 >> 18) & 112));
        r11.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventEnd();
    L145:
        final Modifier r42 = r16;
        final boolean r43 = r19;
        final IconToggleButtonColors r44 = r17;
        final MutableInteractionSource r45 = r18;
    L147:
        ScopeUpdateScope r112 = r11.endRestartGroup();
        if (r112 == null) goto L151;
        final Shape r46 = r111;
        r112.updateScope(new sc(r25, r26, r42, r43, r44, r45, r46, r32, r34, r35));
        return;
    L151:
        return;
    L140:
        if (Intrinsics.areEqual(r39.rememberedValue(), Integer.valueOf(r23)) == true) goto L142;
    L136:
        r11.useNode();
        goto L137
    L129:
        r11.startReplaceGroup(-377320953);
        r11.endReplaceGroup();
        r10 = r18;
        goto L130
    L120:
        r16 = r3;
    L106:
        r18 = r14;
        r19 = r5;
        r8 = r1;
        Shape r210 = r15;
        r17 = r6;
        r7 = r210;
        goto L121
    L109:
        r3 = r27;
        goto L110
    L97:
        if (r11.getDefaultsInvalid() == true) goto L107;
        r11.skipToGroupEnd();
        if ((r35 & 16) == 0) goto L103;
        r1 = r1 & (-57345);
    L103:
        if ((r35 & 64) == 0) goto L105;
        r1 = r1 & (-3670017);
    L105:
        r16 = r27;
        goto L106
    L146:
        r11.skipToGroupEnd();
        r42 = r27;
        r43 = r5;
        r44 = r6;
        r45 = r14;
        r111 = r15;
        goto L147
    L91:
        r0 = false;
        goto L93
    L82:
        if ((r34 & 12582912) != 0) goto L89;
        if (r11.changedInstance(r32) == false) goto L86;
        int r47 = 8388608;
    L87:
        r1 = r1 | r47;
        goto L89
    L86:
        r47 = 4194304;
        goto L87
    L70:
        if ((r35 & 64) != 0) goto L74;
        r15 = r31;
        if (r11.changed(r15) == false) goto L75;
        int r113 = 1048576;
    L76:
        r1 = r1 | r113;
    L75:
        r113 = 524288;
        goto L76
    L74:
        r15 = r31;
        goto L75
    L60:
        if ((196608 & r34) != 0) goto L66;
        r14 = r30;
        if (r11.changed(r14) == false) goto L64;
        int r114 = 131072;
    L65:
        r1 = r1 | r114;
        goto L68
    L64:
        r114 = 65536;
        goto L65
    L48:
        if ((r35 & 16) != 0) goto L52;
        r6 = r29;
        if (r11.changed(r6) == false) goto L53;
        int r115 = 16384;
    L54:
        r1 = r1 | r115;
    L53:
        r115 = 8192;
        goto L54
    L52:
        r6 = r29;
        goto L53
    L38:
        if ((r34 & 3072) != 0) goto L44;
        r5 = r28;
        if (r11.changed(r5) == false) goto L42;
        int r48 = 2048;
    L43:
        r1 = r1 | r48;
        goto L46
    L42:
        r48 = 1024;
        goto L43
    L27:
        if ((r34 & 384) != 0) goto L34;
        if (r11.changed(r27) == false) goto L31;
        int r49 = 256;
    L32:
        r1 = r1 | r49;
        goto L34
    L31:
        r49 = 128;
        goto L32
    L17:
        if ((r34 & 48) != 0) goto L23;
        if (r11.changedInstance(r26) == false) goto L21;
        int r50 = 32;
    L22:
        r1 = r1 | r50;
        goto L23
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L14
    L8:
        if (r11.changed(r25) == false) goto L10;
        int r51 = 4;
    L11:
        r1 = r51 | r34;
        goto L14
    L10:
        r51 = 2;
        goto L11
    }

    public static final void OutlinedIconButton(final Function0<Unit> r22, Modifier r23, boolean r24, Shape r25, IconButtonColors r26, BorderStroke r27, MutableInteractionSource r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-1481353380);
        if ((r32 & 1) == 0) goto L6;
        int r3 = r31 | 6;
    L13:
        int r4 = r32 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r23;
    L24:
        int r6 = r32 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r24;
    L36:
        if ((r31 & 3072) == 0) goto L38;
        Shape r8 = r25;
    L47:
        if ((r31 & 24576) == 0) goto L49;
        IconButtonColors r11 = r26;
    L58:
        if ((196608 & r31) == 0) goto L60;
        BorderStroke r12 = r27;
    L68:
        int r13 = r32 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        MutableInteractionSource r14 = r28;
    L80:
        if ((r32 & 128) == 0) goto L83;
        r3 = r3 | 12582912;
    L91:
        if ((r3 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L133;
        r1.startDefaults();
        if ((r31 & 1) != 0) goto L99;
    L111:
        if (r4 == 0) goto L113;
        r5 = Modifier.Companion;
    L113:
        if (r6 == 0) goto L116;
        r7 = true;
    L116:
        if ((r32 & 8) == 0) goto L119;
        r3 = r3 & (-7169);
        r8 = IconButtonDefaults.INSTANCE.getOutlinedShape(r1, 6);
    L119:
        if ((r32 & 16) == 0) goto L122;
        r3 = r3 & (-57345);
        r11 = IconButtonDefaults.INSTANCE.outlinedIconButtonColors(r1, 6);
    L122:
        if ((r32 & 32) == 0) goto L124;
        r12 = IconButtonDefaults.INSTANCE.outlinedIconButtonBorder(r7, r1, ((r3 >> 6) & 14) | 48);
        r3 = (-458753) & r3;
    L124:
        if (r13 != 0) goto L125;
    L110:
        int r9 = r3;
        IconButtonColors r2 = r11;
        BorderStroke r10 = r12;
        MutableInteractionSource r15 = r14;
    L126:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L129;
        ComposerKt.traceEventStart(-1481353380, r9, -1, "androidx.compose.material3.OutlinedIconButton (IconButton.kt:616)");
    L129:
        SurfaceIconButton(r22, r5, r7, r8, r2, r10, r15, r29, r1, (((((((r9 & 14) | (r9 & 112)) | (r9 & 896)) | (r9 & 7168)) | (57344 & r9)) | (458752 & r9)) | (3670016 & r9)) | (r9 & 29360128));
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventEnd();
    L132:
        final BorderStroke r16 = r10;
        final Modifier r17 = r5;
        final Shape r18 = r8;
        final IconButtonColors r19 = r2;
        boolean r21 = r7;
        final MutableInteractionSource r20 = r15;
        final boolean r33 = r21;
    L134:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L138;
        r110.updateScope(new ac(r22, r17, r33, r18, r19, r16, r20, r29, r31, r32));
        return;
    L138:
        return;
    L125:
        r9 = r3;
        r10 = r12;
        r15 = null;
        r2 = r11;
        goto L126
    L99:
        if (r1.getDefaultsInvalid() == true) goto L111;
        r1.skipToGroupEnd();
        if ((r32 & 8) == 0) goto L105;
        r3 = r3 & (-7169);
    L105:
        if ((r32 & 16) == 0) goto L108;
        r3 = r3 & (-57345);
    L108:
        if ((r32 & 32) == 0) goto L110;
        r3 = r3 & (-458753);
        goto L110
    L133:
        r1.skipToGroupEnd();
        r17 = r5;
        r33 = r7;
        r18 = r8;
        r19 = r11;
        r16 = r12;
        r20 = r14;
        goto L134
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r31 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r29) == false) goto L87;
        int r111 = 8388608;
    L88:
        r3 = r3 | r111;
        goto L91
    L87:
        r111 = 4194304;
        goto L88
    L72:
        if ((1572864 & r31) != 0) goto L78;
        r14 = r28;
        if (r1.changed(r14) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L80
    L76:
        r112 = 524288;
        goto L77
    L60:
        if ((r32 & 32) != 0) goto L64;
        r12 = r27;
        if (r1.changed(r12) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
    L65:
        r113 = 65536;
        goto L66
    L64:
        r12 = r27;
        goto L65
    L49:
        if ((r32 & 16) != 0) goto L53;
        r11 = r26;
        if (r1.changed(r11) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
    L54:
        r114 = 8192;
        goto L55
    L53:
        r11 = r26;
        goto L54
    L38:
        if ((r32 & 8) != 0) goto L42;
        r8 = r25;
        if (r1.changed(r8) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
    L43:
        r115 = 1024;
        goto L44
    L42:
        r8 = r25;
        goto L43
    L28:
        if ((r31 & 384) != 0) goto L34;
        r7 = r24;
        if (r1.changed(r7) == false) goto L32;
        int r34 = 256;
    L33:
        r3 = r3 | r34;
        goto L36
    L32:
        r34 = 128;
        goto L33
    L17:
        if ((r31 & 48) != 0) goto L23;
        r5 = r23;
        if (r1.changed(r5) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L24
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r3 = r31;
        goto L13
    L8:
        if (r1.changedInstance(r22) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r31;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    private static final void SurfaceIconToggleButton(final boolean r19, final Function1<? super Boolean, Unit> r20, final Modifier r21, final boolean r22, final Shape r23, final IconToggleButtonColors r24, final BorderStroke r25, final MutableInteractionSource r26, final Function2<? super Composer, ? super Integer, Unit> r27, Composer r28, final int r29) {
        Composer r15 = r28.startRestartGroup(-1118363928);
        if ((r29 & 6) == 0) goto L5;
        int r2 = r29;
    L11:
        if ((r29 & 48) != 0) goto L18;
        if (r15.changedInstance(r20) == false) goto L15;
        int r5 = 32;
    L16:
        r2 = r2 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r29 & 384) != 0) goto L25;
        if (r15.changed(r21) == false) goto L22;
        int r6 = 256;
    L23:
        r2 = r2 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r29 & 3072) != 0) goto L32;
        if (r15.changed(r22) == false) goto L29;
        int r7 = 2048;
    L30:
        r2 = r2 | r7;
        goto L32
    L29:
        r7 = 1024;
    L32:
        if ((r29 & 24576) != 0) goto L39;
        if (r15.changed(r23) == false) goto L36;
        int r8 = 16384;
    L37:
        r2 = r2 | r8;
        goto L39
    L36:
        r8 = 8192;
    L39:
        if ((196608 & r29) != 0) goto L46;
        if (r15.changed(r24) == false) goto L43;
        int r9 = 131072;
    L44:
        r2 = r2 | r9;
        goto L46
    L43:
        r9 = 65536;
    L46:
        if ((1572864 & r29) != 0) goto L53;
        if (r15.changed(r25) == false) goto L50;
        int r10 = 1048576;
    L51:
        r2 = r2 | r10;
        goto L53
    L50:
        r10 = 524288;
    L53:
        if ((12582912 & r29) != 0) goto L60;
        if (r15.changed(r26) == false) goto L57;
        int r11 = 8388608;
    L58:
        r2 = r2 | r11;
        goto L60
    L57:
        r11 = 4194304;
    L60:
        if ((100663296 & r29) == 0) goto L62;
    L66:
        int r12 = r2;
        if ((38347923 & r12) == 38347922) goto L69;
        boolean r3 = true;
    L71:
        if (r15.shouldExecute(r3, r12 & 1) == true) goto L73;
        Composer r18 = r15;
        r18.skipToGroupEnd();
    L82:
        ScopeUpdateScope r13 = r18.endRestartGroup();
        if (r13 == null) goto L86;
        r13.updateScope(new mc(r19, r20, r21, r22, r23, r24, r25, r26, r27, r29));
        return;
    L86:
        return;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(-1118363928, r12, -1, "androidx.compose.material3.SurfaceIconToggleButton (IconButton.kt:728)");
    L75:
        Object r0 = r15.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L78;
        r0 = new lc();
        r15.updateRememberedValue(r0);
    L78:
        Modifier r4 = SemanticsModifierKt.semantics$default(r21, false, (Function1) r0, 1, null);
        int r1 = r12 >> 9;
        int r14 = (r1 & 14) | ((r12 << 3) & 112);
        int r16 = (r1 & 896) | r14;
        r18 = r15;
        SurfaceKt.m3215Surfaced85dljk(r19, r20, r4, r22, r23, ((Color) r24.containerColor$material3(r22, r19, r15, r16).getValue()).unbox-impl(), ((Color) r24.contentColor$material3(r22, r19, r15, r16).getValue()).unbox-impl(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r25, r26, ComposableLambdaKt.rememberComposableLambda(1492028158, true, new C02652(r27), r15, 54), r18, ((((r12 & 14) | (r12 & 112)) | (r12 & 7168)) | (57344 & r12)) | (1879048192 & (r12 << 9)), ((r12 >> 21) & 14) | 48, 384);
        if (ComposerKt.isTraceInProgress() == false) goto L82;
        ComposerKt.traceEventEnd();
        goto L82
    L69:
        r3 = false;
        goto L71
    L62:
        if (r15.changedInstance(r27) == false) goto L64;
        int r17 = 67108864;
    L65:
        r2 = r2 | r17;
        goto L66
    L64:
        r17 = 33554432;
        goto L65
    L5:
        if (r15.changed(r19) == false) goto L7;
        int r30 = 4;
    L8:
        r2 = r30 | r29;
        goto L11
    L7:
        r30 = 2;
        goto L8
    }

    public static final void OutlinedIconToggleButton(final boolean r23, final Function1<? super Boolean, Unit> r24, Modifier r25, boolean r26, Shape r27, IconToggleButtonColors r28, BorderStroke r29, MutableInteractionSource r30, final Function2<? super Composer, ? super Integer, Unit> r31, Composer r32, final int r33, final int r34) {
        Composer r14 = r32.startRestartGroup(-1703707081);
        if ((r34 & 1) == 0) goto L6;
        int r1 = r33 | 6;
    L14:
        if ((r34 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r34 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r34 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r33 & 24576) == 0) goto L48;
        Shape r6 = r27;
    L57:
        if ((196608 & r33) == 0) goto L59;
        IconToggleButtonColors r7 = r28;
    L68:
        if ((1572864 & r33) == 0) goto L70;
        BorderStroke r8 = r29;
    L78:
        int r9 = r34 & 128;
        if (r9 == 0) goto L82;
        r1 = r1 | 12582912;
    L88:
        MutableInteractionSource r10 = r30;
    L90:
        if ((r34 & 256) == 0) goto L93;
        r1 = r1 | 100663296;
    L101:
        if ((r1 & 38347923) == 38347922) goto L103;
        boolean r0 = true;
    L105:
        if (r14.shouldExecute(r0, r1 & 1) == false) goto L150;
        r14.startDefaults();
        if ((r33 & 1) != 0) goto L109;
    L121:
        if (r2 == 0) goto L123;
        Modifier r3 = Modifier.Companion;
    L124:
        if (r4 == 0) goto L126;
        boolean r5 = true;
    L128:
        if ((r34 & 16) == 0) goto L130;
        Shape r11 = IconButtonDefaults.INSTANCE.getOutlinedShape(r14, 6);
        r1 = r1 & (-57345);
    L132:
        if ((r34 & 32) == 0) goto L135;
        r1 = r1 & (-458753);
        r7 = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonColors(r14, 6);
    L135:
        if ((r34 & 64) == 0) goto L137;
        BorderStroke r12 = IconButtonDefaults.INSTANCE.outlinedIconToggleButtonBorder(r5, r23, r14, (((r1 >> 9) & 14) | 384) | ((r1 << 3) & 112));
        r1 = r1 & (-3670017);
        r8 = r12;
    L137:
        if (r9 == 0) goto L139;
        Modifier r13 = r3;
        boolean r17 = r5;
        Shape r18 = r11;
        IconToggleButtonColors r19 = r7;
        BorderStroke r21 = r8;
        MutableInteractionSource r22 = null;
    L140:
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventStart(-1703707081, r1, -1, "androidx.compose.material3.OutlinedIconToggleButton (IconButton.kt:674)");
    L143:
        Object r15 = r14.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L146;
        r15 = new gc();
        r14.updateRememberedValue(r15);
    L146:
        Modifier r16 = SemanticsModifierKt.semantics$default(r13, false, (Function1) r15, 1, null);
        int r110 = (((((((r1 & 14) | (r1 & 112)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | (r1 & 234881024);
        Modifier r20 = r13;
        SurfaceIconToggleButton(r23, r24, r16, r17, r18, r19, r21, r22, r31, r14, r110);
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
    L149:
        final boolean r35 = r17;
        final Shape r36 = r18;
        final IconToggleButtonColors r37 = r19;
        final Modifier r38 = r20;
        final BorderStroke r39 = r21;
        final MutableInteractionSource r40 = r22;
    L151:
        ScopeUpdateScope r111 = r14.endRestartGroup();
        if (r111 == null) goto L155;
        r111.updateScope(new hc(r23, r24, r38, r35, r36, r37, r39, r40, r31, r33, r34));
        return;
    L155:
        return;
    L139:
        r17 = r5;
        r18 = r11;
        r19 = r7;
        r21 = r8;
        r22 = r10;
        r13 = r3;
        goto L140
    L130:
        r11 = r6;
        goto L132
    L126:
        r5 = r26;
        goto L128
    L123:
        r3 = r25;
        goto L124
    L109:
        if (r14.getDefaultsInvalid() == true) goto L121;
        r14.skipToGroupEnd();
        if ((r34 & 16) == 0) goto L115;
        r1 = r1 & (-57345);
    L115:
        if ((r34 & 32) == 0) goto L118;
        r1 = r1 & (-458753);
    L118:
        if ((r34 & 64) == 0) goto L120;
        r1 = r1 & (-3670017);
    L120:
        r17 = r26;
        r18 = r6;
        r19 = r7;
        r21 = r8;
        r22 = r10;
        r13 = r25;
        goto L140
    L150:
        r14.skipToGroupEnd();
        r38 = r25;
        r35 = r26;
        r36 = r6;
        r37 = r7;
        r39 = r8;
        r40 = r10;
        goto L151
    L103:
        r0 = false;
        goto L105
    L93:
        if ((r33 & 100663296) != 0) goto L101;
        if (r14.changedInstance(r31) == false) goto L97;
        int r112 = 67108864;
    L98:
        r1 = r1 | r112;
        goto L101
    L97:
        r112 = 33554432;
        goto L98
    L82:
        if ((12582912 & r33) != 0) goto L88;
        r10 = r30;
        if (r14.changed(r10) == false) goto L86;
        int r113 = 8388608;
    L87:
        r1 = r1 | r113;
        goto L90
    L86:
        r113 = 4194304;
        goto L87
    L70:
        if ((r34 & 64) != 0) goto L74;
        r8 = r29;
        if (r14.changed(r8) == false) goto L75;
        int r41 = 1048576;
    L76:
        r1 = r1 | r41;
    L75:
        r41 = 524288;
        goto L76
    L74:
        r8 = r29;
        goto L75
    L59:
        if ((r34 & 32) != 0) goto L63;
        r7 = r28;
        if (r14.changed(r7) == false) goto L64;
        int r42 = 131072;
    L65:
        r1 = r1 | r42;
    L64:
        r42 = 65536;
        goto L65
    L63:
        r7 = r28;
        goto L64
    L48:
        if ((r34 & 16) != 0) goto L52;
        r6 = r27;
        if (r14.changed(r6) == false) goto L53;
        int r43 = 16384;
    L54:
        r1 = r1 | r43;
    L53:
        r43 = 8192;
        goto L54
    L52:
        r6 = r27;
        goto L53
    L38:
        if ((r33 & 3072) != 0) goto L46;
        if (r14.changed(r26) == false) goto L42;
        int r44 = 2048;
    L43:
        r1 = r1 | r44;
        goto L46
    L42:
        r44 = 1024;
        goto L43
    L27:
        if ((r33 & 384) != 0) goto L34;
        if (r14.changed(r25) == false) goto L31;
        int r45 = 256;
    L32:
        r1 = r1 | r45;
        goto L34
    L31:
        r45 = 128;
        goto L32
    L17:
        if ((r33 & 48) != 0) goto L23;
        if (r14.changedInstance(r24) == false) goto L21;
        int r46 = 32;
    L22:
        r1 = r1 | r46;
        goto L23
    L21:
        r46 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r1 = r33;
        goto L14
    L8:
        if (r14.changed(r23) == false) goto L10;
        int r47 = 4;
    L11:
        r1 = r47 | r33;
        goto L14
    L10:
        r47 = 2;
        goto L11
    }
}
