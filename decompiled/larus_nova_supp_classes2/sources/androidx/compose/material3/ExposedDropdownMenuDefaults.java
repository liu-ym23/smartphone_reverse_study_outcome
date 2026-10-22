package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nJ\u0095\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\b6\u00107J\u0095\u0003\u00108\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\b=\u00107J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010BJ\u0081\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\bD\u0010EJ\u0081\u0003\u00108\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000eH\u0007¢\u0006\u0004\bF\u0010EJÿ\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010G\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010H\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007¢\u0006\u0004\bI\u0010JJÿ\u0001\u00108\u001a\u00020\f2\b\b\u0002\u0010G\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010H\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007¢\u0006\u0004\bK\u0010JR\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006L"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "<init>", "()V", "TrailingIcon", "", "expanded", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "textFieldColors", "Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "textFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-FD9MK7s", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "(ZLandroidx/compose/runtime/Composer;I)V", "containerColor", "textFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-tN0la-I", "textColor", "placeholderColor", "textFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-St-qZLY", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = null;
    private static final PaddingValues ItemContentPadding = null;

    private ExposedDropdownMenuDefaults() {
    }

    private static final Unit TrailingIcon$lambda$0(ExposedDropdownMenuDefaults r6, boolean r7, Modifier r8, int r9, int r10, Composer r11, int r12) {
        r6.TrailingIcon(r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit TrailingIcon$lambda$1(ExposedDropdownMenuDefaults r0, boolean r1, int r2, Composer r3, int r4) {
        r0.TrailingIcon(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ExposedDropdownMenuDefaults r0, boolean r1, int r2, Composer r3, int r4) {
        return TrailingIcon$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit b(ExposedDropdownMenuDefaults r0, boolean r1, Modifier r2, int r3, int r4, Composer r5, int r6) {
        return TrailingIcon$lambda$0(r0, r1, r2, r3, r4, r5, r6);
    }

    static {
        INSTANCE = new ExposedDropdownMenuDefaults();
        ItemContentPadding = PaddingKt.m954PaddingValuesYgX7TsA(ExposedDropdownMenuKt.access$getExposedDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl(0));
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public final /* synthetic */ void TrailingIcon(final boolean r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(-1803742020);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r10 & 48) != 0) goto L18;
        if (r11.changed(this) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r11.shouldExecute(r3, r1 & 1) == true) goto L24;
        r11.skipToGroupEnd();
    L30:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L34;
        r12.updateScope(new sa(this, r8, r10));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1803742020, r1, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:849)");
    L26:
        TrailingIcon(r8, Modifier.Companion, r11, ((r1 & 14) | 48) | ((r1 << 3) & 896), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r11.changed(r8) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r10;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    public final void TrailingIcon(final boolean r10, Modifier r11, Composer r12, final int r13, final int r14) {
        Composer r15 = r12.startRestartGroup(-1732824199);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L13:
        int r2 = r14 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r1 & 19) == 18) goto L26;
        boolean r3 = true;
    L28:
        if (r15.shouldExecute(r3, r1 & 1) == false) goto L41;
        if (r2 == 0) goto L32;
        r11 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-1732824199, r1, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:511)");
    L34:
        ImageVector r4 = Icons.Filled.INSTANCE.getArrowDropDown$material3();
        if (r10 == false) goto L37;
        float r0 = 180.0f;
    L38:
        IconKt.m2775Iconww6aTOc(r4, null, RotateKt.rotate(r11, r0), 0, r15, 48, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
    L42:
        final Modifier r5 = r11;
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L46;
        r16.updateScope(new ra(this, r10, r5, r13, r14));
        return;
    L46:
        return;
    L37:
        r0 = MenuKt.ClosedAlphaTarget;
        goto L38
    L41:
        r15.skipToGroupEnd();
        goto L42
    L26:
        r3 = false;
        goto L28
    L17:
        if ((r13 & 48) != 0) goto L24;
        if (r15.changed(r11) == false) goto L21;
        int r6 = 32;
    L22:
        r1 = r1 | r6;
        goto L24
    L21:
        r6 = 16;
        goto L22
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L13
    L8:
        if (r15.changed(r10) == false) goto L10;
        int r7 = 4;
    L11:
        r1 = r7 | r13;
        goto L13
    L10:
        r7 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: outlinedTextFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2684outlinedTextFieldColorsStqZLY(long r86, long r88, long r90, long r92, long r94, TextSelectionColors r96, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, Composer r133, int r134, int r135, int r136, int r137) {
        if ((r137 & 1) == 0) goto L5;
        long r7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), r133, 6);
    L7:
        if ((r137 & 2) == 0) goto L9;
        OutlinedAutocompleteTokens r3 = OutlinedAutocompleteTokens.INSTANCE;
        long r5 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getFieldDisabledInputTextColor(), r133, 6), r3.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r137 & 4) == 0) goto L13;
        long r16 = Color.Companion.getTransparent-0d7_KjU();
    L15:
        if ((r137 & 8) == 0) goto L17;
        long r18 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), r133, 6);
    L19:
        if ((r137 & 16) == 0) goto L21;
        long r20 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), r133, 6);
    L23:
        if ((r137 & 32) == 0) goto L25;
        TextSelectionColors r22 = (TextSelectionColors) r133.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L27:
        if ((r137 & 64) == 0) goto L29;
        long r23 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), r133, 6);
    L31:
        if ((r137 & 128) == 0) goto L33;
        long r25 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), r133, 6);
    L35:
        if ((r137 & 256) == 0) goto L37;
        OutlinedAutocompleteTokens r4 = OutlinedAutocompleteTokens.INSTANCE;
        long r27 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getTextFieldDisabledOutlineColor(), r133, 6), r4.getTextFieldDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L39:
        if ((r137 & 512) == 0) goto L41;
        long r29 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), r133, 6);
    L43:
        if ((r137 & 1024) == 0) goto L45;
        long r31 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), r133, 6);
    L47:
        if ((r137 & 2048) == 0) goto L49;
        long r33 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), r133, 6);
    L51:
        if ((r137 & 4096) == 0) goto L53;
        OutlinedAutocompleteTokens r6 = OutlinedAutocompleteTokens.INSTANCE;
        long r35 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getTextFieldDisabledLeadingIconColor(), r133, 6), r6.getTextFieldDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L55:
        if ((r137 & 8192) == 0) goto L57;
        long r37 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), r133, 6);
    L59:
        if ((r137 & 16384) == 0) goto L61;
        long r39 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), r133, 6);
    L63:
        if ((32768 & r137) == 0) goto L65;
        long r41 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), r133, 6);
    L67:
        if ((65536 & r137) == 0) goto L69;
        OutlinedAutocompleteTokens r8 = OutlinedAutocompleteTokens.INSTANCE;
        long r43 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getTextFieldDisabledTrailingIconColor(), r133, 6), r8.getTextFieldDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r137) == 0) goto L73;
        long r45 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), r133, 6);
    L75:
        if ((262144 & r137) == 0) goto L77;
        long r47 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), r133, 6);
    L79:
        if ((524288 & r137) == 0) goto L81;
        long r49 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), r133, 6);
    L83:
        if ((1048576 & r137) == 0) goto L85;
        OutlinedAutocompleteTokens r9 = OutlinedAutocompleteTokens.INSTANCE;
        long r51 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r9.getFieldDisabledLabelTextColor(), r133, 6), r9.getFieldDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L87:
        if ((2097152 & r137) == 0) goto L89;
        long r53 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), r133, 6);
    L91:
        if ((4194304 & r137) == 0) goto L93;
        long r60 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r133, 6);
    L95:
        if ((r137 & 8388608) == 0) goto L97;
        OutlinedAutocompleteTokens r2 = OutlinedAutocompleteTokens.INSTANCE;
        long r58 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getFieldDisabledInputTextColor(), r133, 6), r2.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L99:
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventStart(-83147315, r134, r135, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:1228)");
    L101:
        OutlinedAutocompleteTokens r10 = OutlinedAutocompleteTokens.INSTANCE;
        long r62 = ColorSchemeKt.getValue(r10.getFieldSupportingTextColor(), r133, 6);
        long r64 = ColorSchemeKt.getValue(r10.getFieldSupportingTextColor(), r133, 6);
        long r66 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getFieldDisabledSupportingTextColor(), r133, 6), r10.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r68 = ColorSchemeKt.getValue(r10.getFieldSupportingTextColor(), r133, 6);
        long r70 = ColorSchemeKt.getValue(r10.getFieldSupportingTextColor(), r133, 6);
        long r72 = ColorSchemeKt.getValue(r10.getFieldSupportingTextColor(), r133, 6);
        long r74 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getFieldDisabledSupportingTextColor(), r133, 6), r10.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r76 = ColorSchemeKt.getValue(r10.getFieldSupportingTextColor(), r133, 6);
        int r11 = r134 << 3;
        int r12 = ((r134 & 14) | (r11 & 112)) | (r11 & 896);
        int r13 = r134 << 9;
        int r14 = (((r12 | (r13 & 7168)) | ((r134 << 6) & 57344)) | (r13 & 458752)) | ((r134 << 12) & 3670016);
        int r15 = r134 << 15;
        int r79 = ((r14 | (r15 & 29360128)) | (r15 & 234881024)) | (r15 & 1879048192);
        int r0 = r134 >> 15;
        int r17 = (((r0 & 14) | (r0 & 112)) | (r0 & 896)) | (r0 & 7168);
        int r1 = (r0 & 57344) | r17;
        int r19 = r135 << 15;
        int r80 = ((((r1 | (r19 & 458752)) | (r19 & 3670016)) | (r19 & 29360128)) | (r19 & 234881024)) | (r19 & 1879048192);
        int r21 = r135 >> 15;
        int r24 = (((r21 & 14) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168);
        int r26 = (r21 & 57344) | r24;
        int r28 = r136 << 15;
        int r30 = ((r26 | (r28 & 458752)) | (r28 & 3670016)) | (r28 & 29360128);
        int r32 = r136 << 18;
        int r81 = (r30 | (r32 & 234881024)) | (r32 & 1879048192);
        int r82 = ((r136 >> 6) & 14) | (r28 & 1879048192);
        TextFieldColors r34 = m2683outlinedTextFieldColorsFD9MK7s(r7, r7, r5, r7, r16, r16, r16, r16, r18, r20, r22, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r60, r60, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r133, r79, r80, r81, r82, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventEnd();
    L104:
        return r34;
    L97:
        r58 = r131;
        goto L99
    L93:
        r60 = r129;
        goto L95
    L89:
        r53 = r127;
        goto L91
    L85:
        r51 = r125;
        goto L87
    L81:
        r49 = r123;
        goto L83
    L77:
        r47 = r121;
        goto L79
    L73:
        r45 = r119;
        goto L75
    L69:
        r43 = r117;
        goto L71
    L65:
        r41 = r115;
        goto L67
    L61:
        r39 = r113;
        goto L63
    L57:
        r37 = r111;
        goto L59
    L53:
        r35 = r109;
        goto L55
    L49:
        r33 = r107;
        goto L51
    L45:
        r31 = r105;
        goto L47
    L41:
        r29 = r103;
        goto L43
    L37:
        r27 = r101;
        goto L39
    L33:
        r25 = r99;
        goto L35
    L29:
        r23 = r97;
        goto L31
    L25:
        r22 = r96;
        goto L27
    L21:
        r20 = r94;
        goto L23
    L17:
        r18 = r92;
        goto L19
    L13:
        r16 = r90;
        goto L15
    L9:
        r5 = r88;
        goto L11
    L5:
        r7 = r86;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: textFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2687textFieldColorsStqZLY(long r86, long r88, long r90, long r92, long r94, TextSelectionColors r96, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, Composer r133, int r134, int r135, int r136, int r137) {
        if ((r137 & 1) == 0) goto L5;
        long r7 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), r133, 6);
    L7:
        if ((r137 & 2) == 0) goto L9;
        FilledAutocompleteTokens r3 = FilledAutocompleteTokens.INSTANCE;
        long r5 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getFieldDisabledInputTextColor(), r133, 6), r3.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r137 & 4) == 0) goto L13;
        long r16 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r133, 6);
    L15:
        if ((r137 & 8) == 0) goto L17;
        long r18 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), r133, 6);
    L19:
        if ((r137 & 16) == 0) goto L21;
        long r20 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), r133, 6);
    L23:
        if ((r137 & 32) == 0) goto L25;
        TextSelectionColors r22 = (TextSelectionColors) r133.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L27:
        if ((r137 & 64) == 0) goto L29;
        long r23 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), r133, 6);
    L31:
        if ((r137 & 128) == 0) goto L33;
        long r25 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), r133, 6);
    L35:
        if ((r137 & 256) == 0) goto L37;
        FilledAutocompleteTokens r4 = FilledAutocompleteTokens.INSTANCE;
        long r27 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getTextFieldDisabledActiveIndicatorColor(), r133, 6), r4.getTextFieldDisabledActiveIndicatorOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L39:
        if ((r137 & 512) == 0) goto L41;
        long r29 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), r133, 6);
    L43:
        if ((r137 & 1024) == 0) goto L45;
        long r31 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), r133, 6);
    L47:
        if ((r137 & 2048) == 0) goto L49;
        long r33 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), r133, 6);
    L51:
        if ((r137 & 4096) == 0) goto L53;
        FilledAutocompleteTokens r6 = FilledAutocompleteTokens.INSTANCE;
        long r35 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getTextFieldDisabledLeadingIconColor(), r133, 6), r6.getTextFieldDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L55:
        if ((r137 & 8192) == 0) goto L57;
        long r37 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), r133, 6);
    L59:
        if ((r137 & 16384) == 0) goto L61;
        long r39 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), r133, 6);
    L63:
        if ((32768 & r137) == 0) goto L65;
        long r41 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), r133, 6);
    L67:
        if ((65536 & r137) == 0) goto L69;
        FilledAutocompleteTokens r8 = FilledAutocompleteTokens.INSTANCE;
        long r43 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getTextFieldDisabledTrailingIconColor(), r133, 6), r8.getTextFieldDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r137) == 0) goto L73;
        long r45 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), r133, 6);
    L75:
        if ((262144 & r137) == 0) goto L77;
        long r47 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), r133, 6);
    L79:
        if ((524288 & r137) == 0) goto L81;
        long r49 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), r133, 6);
    L83:
        if ((1048576 & r137) == 0) goto L85;
        long r51 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), r133, 6);
    L87:
        if ((2097152 & r137) == 0) goto L89;
        long r53 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), r133, 6);
    L91:
        if ((4194304 & r137) == 0) goto L93;
        long r60 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r133, 6);
    L95:
        if ((r137 & 8388608) == 0) goto L97;
        FilledAutocompleteTokens r2 = FilledAutocompleteTokens.INSTANCE;
        long r58 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getFieldDisabledInputTextColor(), r133, 6), r2.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L99:
        if (ComposerKt.isTraceInProgress() == false) goto L101;
        ComposerKt.traceEventStart(-2013303349, r134, r135, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:1128)");
    L101:
        OutlinedAutocompleteTokens r9 = OutlinedAutocompleteTokens.INSTANCE;
        long r62 = ColorSchemeKt.getValue(r9.getFieldSupportingTextColor(), r133, 6);
        long r64 = ColorSchemeKt.getValue(r9.getFieldSupportingTextColor(), r133, 6);
        long r66 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r9.getFieldDisabledSupportingTextColor(), r133, 6), r9.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r68 = ColorSchemeKt.getValue(r9.getFieldSupportingTextColor(), r133, 6);
        long r70 = ColorSchemeKt.getValue(r9.getFieldSupportingTextColor(), r133, 6);
        long r72 = ColorSchemeKt.getValue(r9.getFieldSupportingTextColor(), r133, 6);
        long r74 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r9.getFieldDisabledSupportingTextColor(), r133, 6), r9.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r76 = ColorSchemeKt.getValue(r9.getFieldSupportingTextColor(), r133, 6);
        int r10 = r134 << 3;
        int r11 = ((r134 & 14) | (r10 & 112)) | (r10 & 896);
        int r12 = r134 << 9;
        int r13 = (((r11 | (r12 & 7168)) | ((r134 << 6) & 57344)) | (r12 & 458752)) | ((r134 << 12) & 3670016);
        int r14 = r134 << 15;
        int r79 = ((r13 | (r14 & 29360128)) | (r14 & 234881024)) | (r14 & 1879048192);
        int r0 = r134 >> 15;
        int r15 = (((r0 & 14) | (r0 & 112)) | (r0 & 896)) | (r0 & 7168);
        int r1 = (r0 & 57344) | r15;
        int r17 = r135 << 15;
        int r80 = ((((r1 | (r17 & 458752)) | (r17 & 3670016)) | (r17 & 29360128)) | (r17 & 234881024)) | (r17 & 1879048192);
        int r19 = r135 >> 15;
        int r21 = (((r19 & 14) | (r19 & 112)) | (r19 & 896)) | (r19 & 7168);
        int r24 = (r19 & 57344) | r21;
        int r26 = r136 << 15;
        int r28 = ((r24 | (r26 & 458752)) | (r26 & 3670016)) | (r26 & 29360128);
        int r30 = r136 << 18;
        int r81 = (r28 | (r30 & 234881024)) | (r30 & 1879048192);
        int r82 = ((r136 >> 6) & 14) | (r26 & 1879048192);
        TextFieldColors r32 = m2686textFieldColorsFD9MK7s(r7, r7, r5, r7, r16, r16, r16, r16, r18, r20, r22, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r60, r60, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r133, r79, r80, r81, r82, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventEnd();
    L104:
        return r32;
    L97:
        r58 = r131;
        goto L99
    L93:
        r60 = r129;
        goto L95
    L89:
        r53 = r127;
        goto L91
    L85:
        r51 = r125;
        goto L87
    L81:
        r49 = r123;
        goto L83
    L77:
        r47 = r121;
        goto L79
    L73:
        r45 = r119;
        goto L75
    L69:
        r43 = r117;
        goto L71
    L65:
        r41 = r115;
        goto L67
    L61:
        r39 = r113;
        goto L63
    L57:
        r37 = r111;
        goto L59
    L53:
        r35 = r109;
        goto L55
    L49:
        r33 = r107;
        goto L51
    L45:
        r31 = r105;
        goto L47
    L41:
        r29 = r103;
        goto L43
    L37:
        r27 = r101;
        goto L39
    L33:
        r25 = r99;
        goto L35
    L29:
        r23 = r97;
        goto L31
    L25:
        r22 = r96;
        goto L27
    L21:
        r20 = r94;
        goto L23
    L17:
        r18 = r92;
        goto L19
    L13:
        r16 = r90;
        goto L15
    L9:
        r5 = r88;
        goto L11
    L5:
        r7 = r86;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: outlinedTextFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2685outlinedTextFieldColorstN0laI(long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, TextSelectionColors r103, long r104, long r106, long r108, long r110, long r112, long r114, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, Composer r160, int r161, int r162, int r163, int r164, int r165, int r166) {
        if ((r165 & 1) == 0) goto L5;
        long r5 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), r160, 6);
    L7:
        if ((r165 & 2) == 0) goto L9;
        long r7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), r160, 6);
    L11:
        if ((r165 & 4) == 0) goto L13;
        OutlinedAutocompleteTokens r3 = OutlinedAutocompleteTokens.INSTANCE;
        long r9 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getFieldDisabledInputTextColor(), r160, 6), r3.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r165 & 8) == 0) goto L17;
        long r11 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), r160, 6);
    L19:
        if ((r165 & 16) == 0) goto L21;
        long r13 = Color.Companion.getTransparent-0d7_KjU();
    L23:
        if ((r165 & 32) == 0) goto L25;
        long r16 = Color.Companion.getTransparent-0d7_KjU();
    L27:
        if ((r165 & 64) == 0) goto L29;
        long r18 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), r160, 6);
    L31:
        if ((r165 & 128) == 0) goto L33;
        long r20 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), r160, 6);
    L35:
        if ((r165 & 256) == 0) goto L37;
        TextSelectionColors r22 = (TextSelectionColors) r160.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L39:
        if ((r165 & 512) == 0) goto L41;
        long r23 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), r160, 6);
    L43:
        if ((r165 & 1024) == 0) goto L45;
        long r25 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), r160, 6);
    L47:
        if ((r165 & 2048) == 0) goto L49;
        OutlinedAutocompleteTokens r4 = OutlinedAutocompleteTokens.INSTANCE;
        long r27 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getTextFieldDisabledOutlineColor(), r160, 6), r4.getTextFieldDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L51:
        if ((r165 & 4096) == 0) goto L53;
        long r29 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), r160, 6);
    L55:
        if ((r165 & 8192) == 0) goto L57;
        long r31 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), r160, 6);
    L59:
        if ((r165 & 16384) == 0) goto L61;
        long r33 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), r160, 6);
    L63:
        if ((32768 & r165) == 0) goto L65;
        OutlinedAutocompleteTokens r6 = OutlinedAutocompleteTokens.INSTANCE;
        long r35 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getTextFieldDisabledLeadingIconColor(), r160, 6), r6.getTextFieldDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L67:
        if ((65536 & r165) == 0) goto L69;
        long r37 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), r160, 6);
    L71:
        if ((131072 & r165) == 0) goto L73;
        long r39 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), r160, 6);
    L75:
        if ((262144 & r165) == 0) goto L77;
        long r41 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), r160, 6);
    L79:
        if ((524288 & r165) == 0) goto L81;
        OutlinedAutocompleteTokens r8 = OutlinedAutocompleteTokens.INSTANCE;
        long r43 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getTextFieldDisabledTrailingIconColor(), r160, 6), r8.getTextFieldDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L83:
        if ((1048576 & r165) == 0) goto L85;
        long r45 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), r160, 6);
    L87:
        if ((2097152 & r165) == 0) goto L89;
        long r47 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), r160, 6);
    L91:
        if ((4194304 & r165) == 0) goto L93;
        long r49 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), r160, 6);
    L95:
        if ((8388608 & r165) == 0) goto L97;
        OutlinedAutocompleteTokens r10 = OutlinedAutocompleteTokens.INSTANCE;
        long r51 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getFieldDisabledLabelTextColor(), r160, 6), r10.getFieldDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L99:
        if ((16777216 & r165) == 0) goto L101;
        long r53 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), r160, 6);
    L103:
        if ((33554432 & r165) == 0) goto L105;
        long r55 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L107:
        if ((67108864 & r165) == 0) goto L109;
        long r57 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L111:
        if ((134217728 & r165) == 0) goto L113;
        OutlinedAutocompleteTokens r12 = OutlinedAutocompleteTokens.INSTANCE;
        long r59 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r12.getFieldDisabledSupportingTextColor(), r160, 6), r12.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L115:
        if ((268435456 & r165) == 0) goto L117;
        long r61 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L119:
        if ((536870912 & r165) == 0) goto L121;
        long r63 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L123:
        if ((r165 & 1073741824) == 0) goto L125;
        long r65 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L127:
        if ((r166 & 1) == 0) goto L129;
        OutlinedAutocompleteTokens r2 = OutlinedAutocompleteTokens.INSTANCE;
        long r67 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getFieldDisabledSupportingTextColor(), r160, 6), r2.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L131:
        if ((r166 & 2) == 0) goto L133;
        long r69 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L135:
        if ((r166 & 4) == 0) goto L137;
        long r71 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L139:
        if ((r166 & 8) == 0) goto L141;
        long r73 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L143:
        if ((r166 & 16) == 0) goto L145;
        OutlinedAutocompleteTokens r14 = OutlinedAutocompleteTokens.INSTANCE;
        long r75 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r14.getFieldDisabledSupportingTextColor(), r160, 6), r14.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L147:
        if ((r166 & 32) == 0) goto L149;
        long r77 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L151:
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventStart(-907010558, r161, r162, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:1035)");
    L153:
        int r15 = (((((r161 & 14) | (r161 & 112)) | (r161 & 896)) | (r161 & 7168)) | (r161 & 57344)) | ((r161 << 3) & 458752);
        int r17 = r161 << 6;
        int r79 = (((r15 | (r17 & 3670016)) | (r17 & 29360128)) | (r17 & 234881024)) | (r17 & 1879048192);
        int r0 = r161 >> 24;
        int r19 = r0 & 14;
        int r1 = (r0 & 112) | r19;
        int r21 = r162 << 6;
        int r80 = (((((((r1 | (r21 & 896)) | (r21 & 7168)) | (r21 & 57344)) | (r21 & 458752)) | (r21 & 3670016)) | (r21 & 29360128)) | (r21 & 234881024)) | (r21 & 1879048192);
        int r24 = r162 >> 24;
        int r26 = r24 & 14;
        int r28 = (r24 & 112) | r26;
        int r30 = r163 << 6;
        int r81 = (((((((r28 | (r30 & 896)) | (r30 & 7168)) | (r30 & 57344)) | (r30 & 458752)) | (r30 & 3670016)) | (r30 & 29360128)) | (r30 & 234881024)) | (r30 & 1879048192);
        int r32 = r163 >> 24;
        int r34 = r32 & 14;
        int r36 = (r32 & 112) | r34;
        int r38 = r164 << 6;
        int r82 = (((((((r36 | (r38 & 896)) | (r38 & 7168)) | (r38 & 57344)) | (r38 & 458752)) | (r38 & 3670016)) | (r38 & 29360128)) | (r38 & 234881024)) | (r38 & 1879048192);
        TextFieldColors r40 = m2683outlinedTextFieldColorsFD9MK7s(r5, r7, r9, r11, r13, r13, r13, r16, r18, r20, r22, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r160, r79, r80, r81, r82, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        return r40;
    L149:
        r77 = r158;
        goto L151
    L145:
        r75 = r156;
        goto L147
    L141:
        r73 = r154;
        goto L143
    L137:
        r71 = r152;
        goto L139
    L133:
        r69 = r150;
        goto L135
    L129:
        r67 = r148;
        goto L131
    L125:
        r65 = r146;
        goto L127
    L121:
        r63 = r144;
        goto L123
    L117:
        r61 = r142;
        goto L119
    L113:
        r59 = r140;
        goto L115
    L109:
        r57 = r138;
        goto L111
    L105:
        r55 = r136;
        goto L107
    L101:
        r53 = r134;
        goto L103
    L97:
        r51 = r132;
        goto L99
    L93:
        r49 = r130;
        goto L95
    L89:
        r47 = r128;
        goto L91
    L85:
        r45 = r126;
        goto L87
    L81:
        r43 = r124;
        goto L83
    L77:
        r41 = r122;
        goto L79
    L73:
        r39 = r120;
        goto L75
    L69:
        r37 = r118;
        goto L71
    L65:
        r35 = r116;
        goto L67
    L61:
        r33 = r114;
        goto L63
    L57:
        r31 = r112;
        goto L59
    L53:
        r29 = r110;
        goto L55
    L49:
        r27 = r108;
        goto L51
    L45:
        r25 = r106;
        goto L47
    L41:
        r23 = r104;
        goto L43
    L37:
        r22 = r103;
        goto L39
    L33:
        r20 = r101;
        goto L35
    L29:
        r18 = r99;
        goto L31
    L25:
        r16 = r97;
        goto L27
    L21:
        r13 = r95;
        goto L23
    L17:
        r11 = r93;
        goto L19
    L13:
        r9 = r91;
        goto L15
    L9:
        r7 = r89;
        goto L11
    L5:
        r5 = r87;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: textFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2688textFieldColorstN0laI(long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, TextSelectionColors r103, long r104, long r106, long r108, long r110, long r112, long r114, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, Composer r160, int r161, int r162, int r163, int r164, int r165, int r166) {
        if ((r165 & 1) == 0) goto L5;
        long r5 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), r160, 6);
    L7:
        if ((r165 & 2) == 0) goto L9;
        long r7 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), r160, 6);
    L11:
        if ((r165 & 4) == 0) goto L13;
        FilledAutocompleteTokens r3 = FilledAutocompleteTokens.INSTANCE;
        long r9 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getFieldDisabledInputTextColor(), r160, 6), r3.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r165 & 8) == 0) goto L17;
        long r11 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), r160, 6);
    L19:
        if ((r165 & 16) == 0) goto L21;
        long r13 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r160, 6);
    L23:
        if ((r165 & 32) == 0) goto L25;
        long r16 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r160, 6);
    L27:
        if ((r165 & 64) == 0) goto L29;
        long r18 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), r160, 6);
    L31:
        if ((r165 & 128) == 0) goto L33;
        long r20 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), r160, 6);
    L35:
        if ((r165 & 256) == 0) goto L37;
        TextSelectionColors r22 = (TextSelectionColors) r160.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L39:
        if ((r165 & 512) == 0) goto L41;
        long r23 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), r160, 6);
    L43:
        if ((r165 & 1024) == 0) goto L45;
        long r25 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), r160, 6);
    L47:
        if ((r165 & 2048) == 0) goto L49;
        FilledAutocompleteTokens r4 = FilledAutocompleteTokens.INSTANCE;
        long r27 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getTextFieldDisabledActiveIndicatorColor(), r160, 6), r4.getTextFieldDisabledActiveIndicatorOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L51:
        if ((r165 & 4096) == 0) goto L53;
        long r29 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), r160, 6);
    L55:
        if ((r165 & 8192) == 0) goto L57;
        long r31 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), r160, 6);
    L59:
        if ((r165 & 16384) == 0) goto L61;
        long r33 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), r160, 6);
    L63:
        if ((32768 & r165) == 0) goto L65;
        FilledAutocompleteTokens r6 = FilledAutocompleteTokens.INSTANCE;
        long r35 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getTextFieldDisabledLeadingIconColor(), r160, 6), r6.getTextFieldDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L67:
        if ((65536 & r165) == 0) goto L69;
        long r37 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), r160, 6);
    L71:
        if ((131072 & r165) == 0) goto L73;
        long r39 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), r160, 6);
    L75:
        if ((262144 & r165) == 0) goto L77;
        long r41 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), r160, 6);
    L79:
        if ((524288 & r165) == 0) goto L81;
        FilledAutocompleteTokens r8 = FilledAutocompleteTokens.INSTANCE;
        long r43 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getTextFieldDisabledTrailingIconColor(), r160, 6), r8.getTextFieldDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L83:
        if ((1048576 & r165) == 0) goto L85;
        long r45 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), r160, 6);
    L87:
        if ((2097152 & r165) == 0) goto L89;
        long r47 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), r160, 6);
    L91:
        if ((4194304 & r165) == 0) goto L93;
        long r49 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), r160, 6);
    L95:
        if ((8388608 & r165) == 0) goto L97;
        long r51 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), r160, 6);
    L99:
        if ((16777216 & r165) == 0) goto L101;
        long r53 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), r160, 6);
    L103:
        if ((33554432 & r165) == 0) goto L105;
        long r55 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L107:
        if ((67108864 & r165) == 0) goto L109;
        long r57 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L111:
        if ((134217728 & r165) == 0) goto L113;
        FilledAutocompleteTokens r10 = FilledAutocompleteTokens.INSTANCE;
        long r59 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getFieldDisabledSupportingTextColor(), r160, 6), r10.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L115:
        if ((268435456 & r165) == 0) goto L117;
        long r61 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L119:
        if ((536870912 & r165) == 0) goto L121;
        long r63 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L123:
        if ((r165 & 1073741824) == 0) goto L125;
        long r65 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L127:
        if ((r166 & 1) == 0) goto L129;
        FilledAutocompleteTokens r2 = FilledAutocompleteTokens.INSTANCE;
        long r67 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getFieldDisabledSupportingTextColor(), r160, 6), r2.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L131:
        if ((r166 & 2) == 0) goto L133;
        long r69 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L135:
        if ((r166 & 4) == 0) goto L137;
        long r71 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L139:
        if ((r166 & 8) == 0) goto L141;
        long r73 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L143:
        if ((r166 & 16) == 0) goto L145;
        FilledAutocompleteTokens r12 = FilledAutocompleteTokens.INSTANCE;
        long r75 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r12.getFieldDisabledSupportingTextColor(), r160, 6), r12.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L147:
        if ((r166 & 32) == 0) goto L149;
        long r77 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r160, 6);
    L151:
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventStart(1357676928, r161, r162, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:921)");
    L153:
        int r14 = (((((r161 & 14) | (r161 & 112)) | (r161 & 896)) | (r161 & 7168)) | (r161 & 57344)) | ((r161 << 3) & 458752);
        int r15 = r161 << 6;
        int r79 = (((r14 | (r15 & 3670016)) | (r15 & 29360128)) | (r15 & 234881024)) | (r15 & 1879048192);
        int r0 = r161 >> 24;
        int r17 = r0 & 14;
        int r1 = (r0 & 112) | r17;
        int r19 = r162 << 6;
        int r80 = (((((((r1 | (r19 & 896)) | (r19 & 7168)) | (r19 & 57344)) | (r19 & 458752)) | (r19 & 3670016)) | (r19 & 29360128)) | (r19 & 234881024)) | (r19 & 1879048192);
        int r21 = r162 >> 24;
        int r24 = r21 & 14;
        int r26 = (r21 & 112) | r24;
        int r28 = r163 << 6;
        int r81 = (((((((r26 | (r28 & 896)) | (r28 & 7168)) | (r28 & 57344)) | (r28 & 458752)) | (r28 & 3670016)) | (r28 & 29360128)) | (r28 & 234881024)) | (r28 & 1879048192);
        int r30 = r163 >> 24;
        int r32 = r30 & 14;
        int r34 = (r30 & 112) | r32;
        int r36 = r164 << 6;
        int r82 = (((((((r34 | (r36 & 896)) | (r36 & 7168)) | (r36 & 57344)) | (r36 & 458752)) | (r36 & 3670016)) | (r36 & 29360128)) | (r36 & 234881024)) | (r36 & 1879048192);
        TextFieldColors r38 = m2686textFieldColorsFD9MK7s(r5, r7, r9, r11, r13, r13, r13, r16, r18, r20, r22, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r160, r79, r80, r81, r82, 0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        return r38;
    L149:
        r77 = r158;
        goto L151
    L145:
        r75 = r156;
        goto L147
    L141:
        r73 = r154;
        goto L143
    L137:
        r71 = r152;
        goto L139
    L133:
        r69 = r150;
        goto L135
    L129:
        r67 = r148;
        goto L131
    L125:
        r65 = r146;
        goto L127
    L121:
        r63 = r144;
        goto L123
    L117:
        r61 = r142;
        goto L119
    L113:
        r59 = r140;
        goto L115
    L109:
        r57 = r138;
        goto L111
    L105:
        r55 = r136;
        goto L107
    L101:
        r53 = r134;
        goto L103
    L97:
        r51 = r132;
        goto L99
    L93:
        r49 = r130;
        goto L95
    L89:
        r47 = r128;
        goto L91
    L85:
        r45 = r126;
        goto L87
    L81:
        r43 = r124;
        goto L83
    L77:
        r41 = r122;
        goto L79
    L73:
        r39 = r120;
        goto L75
    L69:
        r37 = r118;
        goto L71
    L65:
        r35 = r116;
        goto L67
    L61:
        r33 = r114;
        goto L63
    L57:
        r31 = r112;
        goto L59
    L53:
        r29 = r110;
        goto L55
    L49:
        r27 = r108;
        goto L51
    L45:
        r25 = r106;
        goto L47
    L41:
        r23 = r104;
        goto L43
    L37:
        r22 = r103;
        goto L39
    L33:
        r20 = r101;
        goto L35
    L29:
        r18 = r99;
        goto L31
    L25:
        r16 = r97;
        goto L27
    L21:
        r13 = r95;
        goto L23
    L17:
        r11 = r93;
        goto L19
    L13:
        r9 = r91;
        goto L15
    L9:
        r7 = r89;
        goto L11
    L5:
        r5 = r87;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m2683outlinedTextFieldColorsFD9MK7s(long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, TextSelectionColors r123, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178, Composer r180, int r181, int r182, int r183, int r184, int r185, int r186) {
        if ((r185 & 1) == 0) goto L5;
        long r7 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), r180, 6);
    L7:
        if ((r185 & 2) == 0) goto L9;
        long r9 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), r180, 6);
    L11:
        if ((r185 & 4) == 0) goto L13;
        OutlinedAutocompleteTokens r5 = OutlinedAutocompleteTokens.INSTANCE;
        long r11 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r5.getFieldDisabledInputTextColor(), r180, 6), r5.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r185 & 8) == 0) goto L17;
        long r13 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), r180, 6);
    L19:
        if ((r185 & 16) == 0) goto L21;
        long r16 = Color.Companion.getTransparent-0d7_KjU();
    L23:
        if ((r185 & 32) == 0) goto L25;
        long r18 = Color.Companion.getTransparent-0d7_KjU();
    L27:
        if ((r185 & 64) == 0) goto L29;
        long r20 = Color.Companion.getTransparent-0d7_KjU();
    L31:
        if ((r185 & 128) == 0) goto L33;
        long r22 = Color.Companion.getTransparent-0d7_KjU();
    L35:
        if ((r185 & 256) == 0) goto L37;
        long r24 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), r180, 6);
    L39:
        if ((r185 & 512) == 0) goto L41;
        long r26 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), r180, 6);
    L43:
        if ((r185 & 1024) == 0) goto L45;
        TextSelectionColors r28 = (TextSelectionColors) r180.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L47:
        if ((r185 & 2048) == 0) goto L49;
        long r29 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), r180, 6);
    L51:
        if ((r185 & 4096) == 0) goto L53;
        long r31 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), r180, 6);
    L55:
        if ((r185 & 8192) == 0) goto L57;
        OutlinedAutocompleteTokens r6 = OutlinedAutocompleteTokens.INSTANCE;
        long r33 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getTextFieldDisabledOutlineColor(), r180, 6), r6.getTextFieldDisabledOutlineOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r185 & 16384) == 0) goto L61;
        long r35 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), r180, 6);
    L63:
        if ((32768 & r185) == 0) goto L65;
        long r37 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), r180, 6);
    L67:
        if ((65536 & r185) == 0) goto L69;
        long r39 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), r180, 6);
    L71:
        if ((131072 & r185) == 0) goto L73;
        OutlinedAutocompleteTokens r8 = OutlinedAutocompleteTokens.INSTANCE;
        long r41 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getTextFieldDisabledLeadingIconColor(), r180, 6), r8.getTextFieldDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L75:
        if ((262144 & r185) == 0) goto L77;
        long r43 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), r180, 6);
    L79:
        if ((524288 & r185) == 0) goto L81;
        long r45 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), r180, 6);
    L83:
        if ((1048576 & r185) == 0) goto L85;
        long r47 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), r180, 6);
    L87:
        if ((2097152 & r185) == 0) goto L89;
        OutlinedAutocompleteTokens r10 = OutlinedAutocompleteTokens.INSTANCE;
        long r49 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getTextFieldDisabledTrailingIconColor(), r180, 6), r10.getTextFieldDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L91:
        if ((4194304 & r185) == 0) goto L93;
        long r51 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), r180, 6);
    L95:
        if ((8388608 & r185) == 0) goto L97;
        long r53 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), r180, 6);
    L99:
        if ((16777216 & r185) == 0) goto L101;
        long r55 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), r180, 6);
    L103:
        if ((33554432 & r185) == 0) goto L105;
        OutlinedAutocompleteTokens r12 = OutlinedAutocompleteTokens.INSTANCE;
        long r57 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r12.getFieldDisabledLabelTextColor(), r180, 6), r12.getFieldDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L107:
        if ((67108864 & r185) == 0) goto L109;
        long r59 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), r180, 6);
    L111:
        if ((134217728 & r185) == 0) goto L113;
        long r70 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L115:
        if ((268435456 & r185) == 0) goto L117;
        long r72 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L119:
        if ((536870912 & r185) == 0) goto L121;
        OutlinedAutocompleteTokens r14 = OutlinedAutocompleteTokens.INSTANCE;
        long r74 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r14.getFieldDisabledSupportingTextColor(), r180, 6), r14.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L123:
        if ((r185 & 1073741824) == 0) goto L125;
        long r76 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L127:
        if ((r186 & 1) == 0) goto L129;
        long r78 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L131:
        if ((r186 & 2) == 0) goto L133;
        long r80 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L135:
        if ((r186 & 4) == 0) goto L137;
        OutlinedAutocompleteTokens r0 = OutlinedAutocompleteTokens.INSTANCE;
        long r82 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r0.getFieldDisabledSupportingTextColor(), r180, 6), r0.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L139:
        if ((r186 & 8) == 0) goto L141;
        long r84 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L143:
        if ((r186 & 16) == 0) goto L145;
        long r94 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L147:
        if ((r186 & 32) == 0) goto L149;
        long r96 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L151:
        if ((r186 & 64) == 0) goto L153;
        OutlinedAutocompleteTokens r1 = OutlinedAutocompleteTokens.INSTANCE;
        long r98 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getFieldDisabledSupportingTextColor(), r180, 6), r1.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L155:
        if ((r186 & 128) == 0) goto L157;
        long r100 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L159:
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventStart(-325161132, r181, r182, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:797)");
    L161:
        int r87 = (((((((((r181 & 14) | (r181 & 112)) | (r181 & 896)) | (r181 & 7168)) | (r181 & 57344)) | (r181 & 458752)) | (r181 & 3670016)) | (r181 & 29360128)) | (r181 & 234881024)) | (r181 & 1879048192);
        int r88 = (((((((((r182 & 14) | (r182 & 112)) | (r182 & 896)) | (r182 & 7168)) | (r182 & 57344)) | (r182 & 458752)) | (r182 & 3670016)) | (r182 & 29360128)) | (r182 & 234881024)) | (r182 & 1879048192);
        int r89 = (((((((((r183 & 14) | (r183 & 112)) | (r183 & 896)) | (r183 & 7168)) | (r183 & 57344)) | (r183 & 458752)) | (r183 & 3670016)) | (r183 & 29360128)) | (r183 & 234881024)) | (r183 & 1879048192);
        int r2 = r184 << 12;
        int r90 = (((((r184 & 14) | (r2 & 458752)) | (r2 & 3670016)) | (r2 & 29360128)) | (r2 & 234881024)) | (r2 & 1879048192);
        int r3 = r184 >> 18;
        int r91 = (((r3 & 14) | 3072) | (r3 & 112)) | (r3 & 896);
        TextFieldColors r4 = OutlinedTextFieldDefaults.INSTANCE.m2971colors0hiis_0(r7, r9, r11, r13, r16, r18, r20, r22, r24, r26, r28, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r70, r72, r74, r76, 0, 0, 0, 0, r78, r80, r82, r84, r94, r96, r98, r100, r180, r87, r88, r89, r90, r91, 0, 15);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        return r4;
    L157:
        r100 = r178;
        goto L159
    L153:
        r98 = r176;
        goto L155
    L149:
        r96 = r174;
        goto L151
    L145:
        r94 = r172;
        goto L147
    L141:
        r84 = r170;
        goto L143
    L137:
        r82 = r168;
        goto L139
    L133:
        r80 = r166;
        goto L135
    L129:
        r78 = r164;
        goto L131
    L125:
        r76 = r162;
        goto L127
    L121:
        r74 = r160;
        goto L123
    L117:
        r72 = r158;
        goto L119
    L113:
        r70 = r156;
        goto L115
    L109:
        r59 = r154;
        goto L111
    L105:
        r57 = r152;
        goto L107
    L101:
        r55 = r150;
        goto L103
    L97:
        r53 = r148;
        goto L99
    L93:
        r51 = r146;
        goto L95
    L89:
        r49 = r144;
        goto L91
    L85:
        r47 = r142;
        goto L87
    L81:
        r45 = r140;
        goto L83
    L77:
        r43 = r138;
        goto L79
    L73:
        r41 = r136;
        goto L75
    L69:
        r39 = r134;
        goto L71
    L65:
        r37 = r132;
        goto L67
    L61:
        r35 = r130;
        goto L63
    L57:
        r33 = r128;
        goto L59
    L53:
        r31 = r126;
        goto L55
    L49:
        r29 = r124;
        goto L51
    L45:
        r28 = r123;
        goto L47
    L41:
        r26 = r121;
        goto L43
    L37:
        r24 = r119;
        goto L39
    L33:
        r22 = r117;
        goto L35
    L29:
        r20 = r115;
        goto L31
    L25:
        r18 = r113;
        goto L27
    L21:
        r16 = r111;
        goto L23
    L17:
        r13 = r109;
        goto L19
    L13:
        r11 = r107;
        goto L15
    L9:
        r9 = r105;
        goto L11
    L5:
        r7 = r103;
        goto L7
    }

    /* JADX INFO: renamed from: textFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m2686textFieldColorsFD9MK7s(long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, TextSelectionColors r123, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178, Composer r180, int r181, int r182, int r183, int r184, int r185, int r186) {
        if ((r185 & 1) == 0) goto L5;
        long r7 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), r180, 6);
    L7:
        if ((r185 & 2) == 0) goto L9;
        long r9 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), r180, 6);
    L11:
        if ((r185 & 4) == 0) goto L13;
        FilledAutocompleteTokens r5 = FilledAutocompleteTokens.INSTANCE;
        long r11 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r5.getFieldDisabledInputTextColor(), r180, 6), r5.getFieldDisabledInputTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r185 & 8) == 0) goto L17;
        long r13 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), r180, 6);
    L19:
        if ((r185 & 16) == 0) goto L21;
        long r16 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r180, 6);
    L23:
        if ((r185 & 32) == 0) goto L25;
        long r18 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r180, 6);
    L27:
        if ((r185 & 64) == 0) goto L29;
        long r20 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r180, 6);
    L31:
        if ((r185 & 128) == 0) goto L33;
        long r22 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), r180, 6);
    L35:
        if ((r185 & 256) == 0) goto L37;
        long r24 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), r180, 6);
    L39:
        if ((r185 & 512) == 0) goto L41;
        long r26 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), r180, 6);
    L43:
        if ((r185 & 1024) == 0) goto L45;
        TextSelectionColors r28 = (TextSelectionColors) r180.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L47:
        if ((r185 & 2048) == 0) goto L49;
        long r29 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), r180, 6);
    L51:
        if ((r185 & 4096) == 0) goto L53;
        long r31 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), r180, 6);
    L55:
        if ((r185 & 8192) == 0) goto L57;
        FilledAutocompleteTokens r6 = FilledAutocompleteTokens.INSTANCE;
        long r33 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getTextFieldDisabledActiveIndicatorColor(), r180, 6), r6.getTextFieldDisabledActiveIndicatorOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r185 & 16384) == 0) goto L61;
        long r35 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), r180, 6);
    L63:
        if ((32768 & r185) == 0) goto L65;
        long r37 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), r180, 6);
    L67:
        if ((65536 & r185) == 0) goto L69;
        long r39 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), r180, 6);
    L71:
        if ((131072 & r185) == 0) goto L73;
        FilledAutocompleteTokens r8 = FilledAutocompleteTokens.INSTANCE;
        long r41 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getTextFieldDisabledLeadingIconColor(), r180, 6), r8.getTextFieldDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L75:
        if ((262144 & r185) == 0) goto L77;
        long r43 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), r180, 6);
    L79:
        if ((524288 & r185) == 0) goto L81;
        long r45 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), r180, 6);
    L83:
        if ((1048576 & r185) == 0) goto L85;
        long r47 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), r180, 6);
    L87:
        if ((2097152 & r185) == 0) goto L89;
        FilledAutocompleteTokens r10 = FilledAutocompleteTokens.INSTANCE;
        long r49 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getTextFieldDisabledTrailingIconColor(), r180, 6), r10.getTextFieldDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L91:
        if ((4194304 & r185) == 0) goto L93;
        long r51 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), r180, 6);
    L95:
        if ((8388608 & r185) == 0) goto L97;
        long r53 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), r180, 6);
    L99:
        if ((16777216 & r185) == 0) goto L101;
        long r55 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), r180, 6);
    L103:
        if ((33554432 & r185) == 0) goto L105;
        long r57 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), r180, 6);
    L107:
        if ((67108864 & r185) == 0) goto L109;
        long r59 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), r180, 6);
    L111:
        if ((134217728 & r185) == 0) goto L113;
        long r70 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L115:
        if ((268435456 & r185) == 0) goto L117;
        long r72 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L119:
        if ((536870912 & r185) == 0) goto L121;
        FilledAutocompleteTokens r12 = FilledAutocompleteTokens.INSTANCE;
        long r74 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r12.getFieldDisabledSupportingTextColor(), r180, 6), r12.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L123:
        if ((r185 & 1073741824) == 0) goto L125;
        long r76 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L127:
        if ((r186 & 1) == 0) goto L129;
        long r78 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L131:
        if ((r186 & 2) == 0) goto L133;
        long r80 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L135:
        if ((r186 & 4) == 0) goto L137;
        FilledAutocompleteTokens r0 = FilledAutocompleteTokens.INSTANCE;
        long r82 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r0.getFieldDisabledSupportingTextColor(), r180, 6), r0.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L139:
        if ((r186 & 8) == 0) goto L141;
        long r84 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L143:
        if ((r186 & 16) == 0) goto L145;
        long r94 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L147:
        if ((r186 & 32) == 0) goto L149;
        long r96 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L151:
        if ((r186 & 64) == 0) goto L153;
        FilledAutocompleteTokens r1 = FilledAutocompleteTokens.INSTANCE;
        long r98 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r1.getFieldDisabledSupportingTextColor(), r180, 6), r1.getFieldDisabledSupportingTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L155:
        if ((r186 & 128) == 0) goto L157;
        long r100 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), r180, 6);
    L159:
        if (ComposerKt.isTraceInProgress() == false) goto L161;
        ComposerKt.traceEventStart(-375683630, r181, r182, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:634)");
    L161:
        int r87 = (((((((((r181 & 14) | (r181 & 112)) | (r181 & 896)) | (r181 & 7168)) | (r181 & 57344)) | (r181 & 458752)) | (r181 & 3670016)) | (r181 & 29360128)) | (r181 & 234881024)) | (r181 & 1879048192);
        int r88 = (((((((((r182 & 14) | (r182 & 112)) | (r182 & 896)) | (r182 & 7168)) | (r182 & 57344)) | (r182 & 458752)) | (r182 & 3670016)) | (r182 & 29360128)) | (r182 & 234881024)) | (r182 & 1879048192);
        int r89 = (((((((((r183 & 14) | (r183 & 112)) | (r183 & 896)) | (r183 & 7168)) | (r183 & 57344)) | (r183 & 458752)) | (r183 & 3670016)) | (r183 & 29360128)) | (r183 & 234881024)) | (r183 & 1879048192);
        int r2 = r184 << 12;
        int r90 = (((((r184 & 14) | (r2 & 458752)) | (r2 & 3670016)) | (r2 & 29360128)) | (r2 & 234881024)) | (r2 & 1879048192);
        int r3 = r184 >> 18;
        int r91 = (((r3 & 14) | 3072) | (r3 & 112)) | (r3 & 896);
        TextFieldColors r4 = TextFieldDefaults.INSTANCE.m3341colors0hiis_0(r7, r9, r11, r13, r16, r18, r20, r22, r24, r26, r28, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r70, r72, r74, r76, 0, 0, 0, 0, r78, r80, r82, r84, r94, r96, r98, r100, r180, r87, r88, r89, r90, r91, 0, 15);
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
    L164:
        return r4;
    L157:
        r100 = r178;
        goto L159
    L153:
        r98 = r176;
        goto L155
    L149:
        r96 = r174;
        goto L151
    L145:
        r94 = r172;
        goto L147
    L141:
        r84 = r170;
        goto L143
    L137:
        r82 = r168;
        goto L139
    L133:
        r80 = r166;
        goto L135
    L129:
        r78 = r164;
        goto L131
    L125:
        r76 = r162;
        goto L127
    L121:
        r74 = r160;
        goto L123
    L117:
        r72 = r158;
        goto L119
    L113:
        r70 = r156;
        goto L115
    L109:
        r59 = r154;
        goto L111
    L105:
        r57 = r152;
        goto L107
    L101:
        r55 = r150;
        goto L103
    L97:
        r53 = r148;
        goto L99
    L93:
        r51 = r146;
        goto L95
    L89:
        r49 = r144;
        goto L91
    L85:
        r47 = r142;
        goto L87
    L81:
        r45 = r140;
        goto L83
    L77:
        r43 = r138;
        goto L79
    L73:
        r41 = r136;
        goto L75
    L69:
        r39 = r134;
        goto L71
    L65:
        r37 = r132;
        goto L67
    L61:
        r35 = r130;
        goto L63
    L57:
        r33 = r128;
        goto L59
    L53:
        r31 = r126;
        goto L55
    L49:
        r29 = r124;
        goto L51
    L45:
        r28 = r123;
        goto L47
    L41:
        r26 = r121;
        goto L43
    L37:
        r24 = r119;
        goto L39
    L33:
        r22 = r117;
        goto L35
    L29:
        r20 = r115;
        goto L31
    L25:
        r18 = r113;
        goto L27
    L21:
        r16 = r111;
        goto L23
    L17:
        r13 = r109;
        goto L19
    L13:
        r11 = r107;
        goto L15
    L9:
        r9 = r105;
        goto L11
    L5:
        r7 = r103;
        goto L7
    }
}
