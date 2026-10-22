package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010 J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010 J+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0017¢\u0006\u0002\u0010#J+\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0017¢\u0006\u0002\u0010#J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010%J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010%J+\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0017¢\u0006\u0002\u0010#J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010%J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017¢\u0006\u0002\u0010%J\u0013\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0013\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0016\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0017\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006-²\u0006\n\u0010.\u001a\u00020\u001eX\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020\u001eX\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/DefaultTextFieldForExposedDropdownMenusColors;", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "backgroundColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "isError", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "indicatorColor", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "error", "equals", "other", "", "hashCode", "", "material", "focused"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultTextFieldForExposedDropdownMenusColors implements TextFieldColors {
    private final long backgroundColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedTrailingIconColor;
    private final long leadingIconColor;
    private final long placeholderColor;
    private final long textColor;
    private final long trailingIconColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;

    public /* synthetic */ DefaultTextFieldForExposedDropdownMenusColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, DefaultConstructorMarker r45) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43);
    }

    @Override // androidx.compose.material.TextFieldColors
    public final /* synthetic */ State leadingIconColor(boolean r1, boolean r2, InteractionSource r3, Composer r4, int r5) {
        return TextFieldColors.CC.$default$leadingIconColor(this, r1, r2, r3, r4, r5);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((Color.hashCode-impl(this.textColor) * 31) + Color.hashCode-impl(this.disabledTextColor)) * 31) + Color.hashCode-impl(this.cursorColor)) * 31) + Color.hashCode-impl(this.errorCursorColor)) * 31) + Color.hashCode-impl(this.focusedIndicatorColor)) * 31) + Color.hashCode-impl(this.unfocusedIndicatorColor)) * 31) + Color.hashCode-impl(this.errorIndicatorColor)) * 31) + Color.hashCode-impl(this.disabledIndicatorColor)) * 31) + Color.hashCode-impl(this.leadingIconColor)) * 31) + Color.hashCode-impl(this.disabledLeadingIconColor)) * 31) + Color.hashCode-impl(this.errorLeadingIconColor)) * 31) + Color.hashCode-impl(this.trailingIconColor)) * 31) + Color.hashCode-impl(this.focusedTrailingIconColor)) * 31) + Color.hashCode-impl(this.disabledTrailingIconColor)) * 31) + Color.hashCode-impl(this.errorTrailingIconColor)) * 31) + Color.hashCode-impl(this.backgroundColor)) * 31) + Color.hashCode-impl(this.focusedLabelColor)) * 31) + Color.hashCode-impl(this.unfocusedLabelColor)) * 31) + Color.hashCode-impl(this.disabledLabelColor)) * 31) + Color.hashCode-impl(this.errorLabelColor)) * 31) + Color.hashCode-impl(this.placeholderColor)) * 31) + Color.hashCode-impl(this.disabledPlaceholderColor);
    }

    private static final boolean indicatorColor$lambda$1(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean labelColor$lambda$2(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final boolean trailingIconColor$lambda$0(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L77:
        return false;
    L8:
        if (DefaultTextFieldForExposedDropdownMenusColors.class != r7.getClass()) goto L77;
        DefaultTextFieldForExposedDropdownMenusColors r8 = (DefaultTextFieldForExposedDropdownMenusColors) r7;
        if (Color.equals-impl0(this.textColor, r8.textColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.disabledTextColor, r8.disabledTextColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.cursorColor, r8.cursorColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.errorCursorColor, r8.errorCursorColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.focusedIndicatorColor, r8.focusedIndicatorColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.unfocusedIndicatorColor, r8.unfocusedIndicatorColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.errorIndicatorColor, r8.errorIndicatorColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.disabledIndicatorColor, r8.disabledIndicatorColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.leadingIconColor, r8.leadingIconColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.disabledLeadingIconColor, r8.disabledLeadingIconColor) == true) goto L41;
        return false;
    L41:
        if (Color.equals-impl0(this.errorLeadingIconColor, r8.errorLeadingIconColor) == true) goto L44;
        return false;
    L44:
        if (Color.equals-impl0(this.trailingIconColor, r8.trailingIconColor) == true) goto L47;
        return false;
    L47:
        if (Color.equals-impl0(this.focusedTrailingIconColor, r8.focusedTrailingIconColor) == true) goto L50;
        return false;
    L50:
        if (Color.equals-impl0(this.disabledTrailingIconColor, r8.disabledTrailingIconColor) == true) goto L53;
        return false;
    L53:
        if (Color.equals-impl0(this.errorTrailingIconColor, r8.errorTrailingIconColor) == true) goto L56;
        return false;
    L56:
        if (Color.equals-impl0(this.backgroundColor, r8.backgroundColor) == true) goto L59;
        return false;
    L59:
        if (Color.equals-impl0(this.focusedLabelColor, r8.focusedLabelColor) == true) goto L62;
        return false;
    L62:
        if (Color.equals-impl0(this.unfocusedLabelColor, r8.unfocusedLabelColor) == true) goto L65;
        return false;
    L65:
        if (Color.equals-impl0(this.disabledLabelColor, r8.disabledLabelColor) == true) goto L68;
        return false;
    L68:
        if (Color.equals-impl0(this.errorLabelColor, r8.errorLabelColor) == true) goto L71;
        return false;
    L71:
        if (Color.equals-impl0(this.placeholderColor, r8.placeholderColor) == true) goto L74;
        return false;
    L74:
        if (Color.equals-impl0(this.disabledPlaceholderColor, r8.disabledPlaceholderColor) == true) goto L76;
        return false;
    L76:
        return true;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> backgroundColor(boolean r3, Composer r4, int r5) {
        r4.startReplaceGroup(-28962788);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-28962788, r5, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.backgroundColor (ExposedDropdownMenu.kt:567)");
    L5:
        State<Color> r6 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(this.backgroundColor), r4, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r4.endReplaceGroup();
        return r6;
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> cursorColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(-930693132);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-930693132, r6, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.cursorColor (ExposedDropdownMenu.kt:600)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.errorCursorColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.cursorColor;
        goto L8
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> placeholderColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(1742462291);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1742462291, r6, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.placeholderColor (ExposedDropdownMenu.kt:572)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.placeholderColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.disabledPlaceholderColor;
        goto L8
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> textColor(boolean r4, Composer r5, int r6) {
        r5.startReplaceGroup(394526077);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(394526077, r6, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.textColor (ExposedDropdownMenu.kt:595)");
    L5:
        if (r4 == false) goto L7;
        long r0 = this.textColor;
    L8:
        State<Color> r7 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r0), r5, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r5.endReplaceGroup();
        return r7;
    L7:
        r0 = this.disabledTextColor;
        goto L8
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> leadingIconColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(-776179197);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-776179197, r7, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.leadingIconColor (ExposedDropdownMenu.kt:504)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledLeadingIconColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r6.endReplaceGroup();
        return r9;
    L7:
        if (r5 == false) goto L9;
        r8 = this.errorLeadingIconColor;
        goto L10
    L9:
        r8 = this.leadingIconColor;
        goto L10
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> trailingIconColor(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(1665901393);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1665901393, r7, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.trailingIconColor (ExposedDropdownMenu.kt:516)");
    L5:
        if (r4 == true) goto L7;
        long r8 = this.disabledTrailingIconColor;
    L10:
        State<Color> r9 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r8), r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r6.endReplaceGroup();
        return r9;
    L7:
        if (r5 == false) goto L9;
        r8 = this.errorTrailingIconColor;
        goto L10
    L9:
        r8 = this.trailingIconColor;
        goto L10
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> indicatorColor(boolean r10, boolean r11, InteractionSource r12, Composer r13, int r14) {
        r13.startReplaceGroup(476110356);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(476110356, r14, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.indicatorColor (ExposedDropdownMenu.kt:549)");
    L5:
        State<Boolean> r15 = FocusInteractionKt.collectIsFocusedAsState(r12, r13, (r14 >> 6) & 14);
        if (r10 == true) goto L9;
        long r16 = this.disabledIndicatorColor;
    L8:
        long r1 = r16;
        if (r10 == false) goto L18;
        r13.startReplaceGroup(1822118155);
        State<Color> r17 = SingleValueAnimationKt.m212animateColorAsStateeuL9pac(r1, AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, null, 6, null), null, null, r13, 48, 12);
        r13.endReplaceGroup();
    L20:
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventEnd();
    L22:
        r13.endReplaceGroup();
        return r17;
    L18:
        r13.startReplaceGroup(1822221013);
        r17 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r1), r13, 0);
        r13.endReplaceGroup();
        goto L20
    L9:
        if (r11 == false) goto L12;
        r16 = this.errorIndicatorColor;
        goto L8
    L12:
        if (indicatorColor$lambda$1(r15) == false) goto L14;
        r16 = this.focusedIndicatorColor;
        goto L8
    L14:
        r16 = this.unfocusedIndicatorColor;
        goto L8
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> labelColor(boolean r4, boolean r5, InteractionSource r6, Composer r7, int r8) {
        r7.startReplaceGroup(-1749156593);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1749156593, r8, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.labelColor (ExposedDropdownMenu.kt:581)");
    L5:
        State<Boolean> r9 = FocusInteractionKt.collectIsFocusedAsState(r6, r7, (r8 >> 6) & 14);
        if (r4 == true) goto L8;
        long r10 = this.disabledLabelColor;
    L14:
        State<Color> r11 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r10), r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        r7.endReplaceGroup();
        return r11;
    L8:
        if (r5 == false) goto L11;
        r10 = this.errorLabelColor;
        goto L14
    L11:
        if (labelColor$lambda$2(r9) == false) goto L13;
        r10 = this.focusedLabelColor;
        goto L14
    L13:
        r10 = this.unfocusedLabelColor;
        goto L14
    }

    @Override // androidx.compose.material.TextFieldColors
    public State<Color> trailingIconColor(boolean r4, boolean r5, InteractionSource r6, Composer r7, int r8) {
        r7.startReplaceGroup(79259602);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(79259602, r8, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.trailingIconColor (ExposedDropdownMenu.kt:531)");
    L5:
        State<Boolean> r9 = FocusInteractionKt.collectIsFocusedAsState(r6, r7, (r8 >> 6) & 14);
        if (r4 == true) goto L8;
        long r10 = this.disabledTrailingIconColor;
    L14:
        State<Color> r11 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(r10), r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        r7.endReplaceGroup();
        return r11;
    L8:
        if (r5 == false) goto L11;
        r10 = this.errorTrailingIconColor;
        goto L14
    L11:
        if (trailingIconColor$lambda$0(r9) == false) goto L13;
        r10 = this.focusedTrailingIconColor;
        goto L14
    L13:
        r10 = this.trailingIconColor;
        goto L14
    }

    private DefaultTextFieldForExposedDropdownMenusColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46) {
        this.textColor = r4;
        this.disabledTextColor = r6;
        this.cursorColor = r8;
        this.errorCursorColor = r10;
        this.focusedIndicatorColor = r12;
        this.unfocusedIndicatorColor = r14;
        this.errorIndicatorColor = r16;
        this.disabledIndicatorColor = r18;
        this.leadingIconColor = r20;
        this.disabledLeadingIconColor = r22;
        this.errorLeadingIconColor = r24;
        this.trailingIconColor = r26;
        this.focusedTrailingIconColor = r28;
        this.disabledTrailingIconColor = r30;
        this.errorTrailingIconColor = r32;
        this.backgroundColor = r34;
        this.focusedLabelColor = r36;
        this.unfocusedLabelColor = r38;
        this.disabledLabelColor = r40;
        this.errorLabelColor = r42;
        this.placeholderColor = r44;
        this.disabledPlaceholderColor = r46;
    }
}
