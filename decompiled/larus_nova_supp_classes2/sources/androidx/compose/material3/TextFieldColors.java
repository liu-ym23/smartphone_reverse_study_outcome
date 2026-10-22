package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bU\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bß\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J½\u0003\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u0003¢\u0006\u0004\b`\u0010aJ!\u0010b\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000e0dH\u0000¢\u0006\u0002\beJ'\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bk\u0010lJ'\u0010m\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bn\u0010lJ'\u0010o\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bp\u0010lJ'\u0010q\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\br\u0010lJ'\u0010s\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bt\u0010lJ'\u0010u\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bv\u0010lJ'\u0010w\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bx\u0010lJ'\u0010y\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\bz\u0010lJ'\u0010{\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\b|\u0010lJ'\u0010}\u001a\u00020\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020hH\u0001¢\u0006\u0004\b~\u0010lJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010i\u001a\u00020hH\u0001¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0015\u0010\u0081\u0001\u001a\u00020h2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b5\u00102R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00102R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b7\u00102R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b8\u00102R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b9\u00102R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b:\u00102R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b;\u00102R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b<\u00102R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b?\u00102R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b@\u00102R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bA\u00102R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bB\u00102R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bC\u00102R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bE\u00102R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bF\u00102R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bG\u00102R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bH\u00102R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bI\u00102R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bJ\u00102R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bK\u00102R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bL\u00102R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bM\u00102R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bN\u00102R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bO\u00102R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bP\u00102R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bQ\u00102R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bR\u00102R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bS\u00102R\u0013\u0010$\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bT\u00102R\u0013\u0010%\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bU\u00102R\u0013\u0010&\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bV\u00102R\u0013\u0010'\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bW\u00102R\u0013\u0010(\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bX\u00102R\u0013\u0010)\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bY\u00102R\u0013\u0010*\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\bZ\u00102R\u0013\u0010+\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b[\u00102R\u0013\u0010,\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b\\\u00102R\u0013\u0010-\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b]\u00102R\u0013\u0010.\u001a\u00020\u0003¢\u0006\n\n\u0002\u00103\u001a\u0004\b^\u00102¨\u0006\u0085\u0001"}, d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "<init>", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFocusedTextColor-0d7_KjU", "()J", "J", "getUnfocusedTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getUnfocusedContainerColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getCursorColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getFocusedIndicatorColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3", "leadingIconColor", "enabled", "", "isError", "focused", "leadingIconColor-XeAY9LY$material3", "(ZZZ)J", "trailingIconColor", "trailingIconColor-XeAY9LY$material3", "indicatorColor", "indicatorColor-XeAY9LY$material3", "containerColor", "containerColor-XeAY9LY$material3", "placeholderColor", "placeholderColor-XeAY9LY$material3", "labelColor", "labelColor-XeAY9LY$material3", "textColor", "textColor-XeAY9LY$material3", "supportingTextColor", "supportingTextColor-XeAY9LY$material3", "prefixColor", "prefixColor-XeAY9LY$material3", "suffixColor", "suffixColor-XeAY9LY$material3", "cursorColor-vNxB06k$material3", "(Z)J", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldColors {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;

    public /* synthetic */ TextFieldColors(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, TextSelectionColors r21, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, long r84, DefaultConstructorMarker r86) {
        this(r1, r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r22, r24, r26, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r80, r82, r84);
    }

    public static /* synthetic */ TextSelectionColors a(TextFieldColors r0) {
        return copy_ejIjP34$lambda$10(r0);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.hashCode-impl(this.focusedTextColor) * 31) + Color.hashCode-impl(this.unfocusedTextColor)) * 31) + Color.hashCode-impl(this.disabledTextColor)) * 31) + Color.hashCode-impl(this.errorTextColor)) * 31) + Color.hashCode-impl(this.focusedContainerColor)) * 31) + Color.hashCode-impl(this.unfocusedContainerColor)) * 31) + Color.hashCode-impl(this.disabledContainerColor)) * 31) + Color.hashCode-impl(this.errorContainerColor)) * 31) + Color.hashCode-impl(this.cursorColor)) * 31) + Color.hashCode-impl(this.errorCursorColor)) * 31) + this.textSelectionColors.hashCode()) * 31) + Color.hashCode-impl(this.focusedIndicatorColor)) * 31) + Color.hashCode-impl(this.unfocusedIndicatorColor)) * 31) + Color.hashCode-impl(this.disabledIndicatorColor)) * 31) + Color.hashCode-impl(this.errorIndicatorColor)) * 31) + Color.hashCode-impl(this.focusedLeadingIconColor)) * 31) + Color.hashCode-impl(this.unfocusedLeadingIconColor)) * 31) + Color.hashCode-impl(this.disabledLeadingIconColor)) * 31) + Color.hashCode-impl(this.errorLeadingIconColor)) * 31) + Color.hashCode-impl(this.focusedTrailingIconColor)) * 31) + Color.hashCode-impl(this.unfocusedTrailingIconColor)) * 31) + Color.hashCode-impl(this.disabledTrailingIconColor)) * 31) + Color.hashCode-impl(this.errorTrailingIconColor)) * 31) + Color.hashCode-impl(this.focusedLabelColor)) * 31) + Color.hashCode-impl(this.unfocusedLabelColor)) * 31) + Color.hashCode-impl(this.disabledLabelColor)) * 31) + Color.hashCode-impl(this.errorLabelColor)) * 31) + Color.hashCode-impl(this.focusedPlaceholderColor)) * 31) + Color.hashCode-impl(this.unfocusedPlaceholderColor)) * 31) + Color.hashCode-impl(this.disabledPlaceholderColor)) * 31) + Color.hashCode-impl(this.errorPlaceholderColor)) * 31) + Color.hashCode-impl(this.focusedSupportingTextColor)) * 31) + Color.hashCode-impl(this.unfocusedSupportingTextColor)) * 31) + Color.hashCode-impl(this.disabledSupportingTextColor)) * 31) + Color.hashCode-impl(this.errorSupportingTextColor)) * 31) + Color.hashCode-impl(this.focusedPrefixColor)) * 31) + Color.hashCode-impl(this.unfocusedPrefixColor)) * 31) + Color.hashCode-impl(this.disabledPrefixColor)) * 31) + Color.hashCode-impl(this.errorPrefixColor)) * 31) + Color.hashCode-impl(this.focusedSuffixColor)) * 31) + Color.hashCode-impl(this.unfocusedSuffixColor)) * 31) + Color.hashCode-impl(this.disabledSuffixColor)) * 31) + Color.hashCode-impl(this.errorSuffixColor);
    }

    /* JADX INFO: renamed from: getCursorColor-0d7_KjU, reason: not valid java name */
    public final long m3279getCursorColor0d7_KjU() {
        return this.cursorColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3280getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m3281getDisabledIndicatorColor0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    /* JADX INFO: renamed from: getDisabledLabelColor-0d7_KjU, reason: not valid java name */
    public final long m3282getDisabledLabelColor0d7_KjU() {
        return this.disabledLabelColor;
    }

    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3283getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: getDisabledPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m3284getDisabledPlaceholderColor0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    /* JADX INFO: renamed from: getDisabledPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m3285getDisabledPrefixColor0d7_KjU() {
        return this.disabledPrefixColor;
    }

    /* JADX INFO: renamed from: getDisabledSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m3286getDisabledSuffixColor0d7_KjU() {
        return this.disabledSuffixColor;
    }

    /* JADX INFO: renamed from: getDisabledSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m3287getDisabledSupportingTextColor0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m3288getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3289getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    /* JADX INFO: renamed from: getErrorContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3290getErrorContainerColor0d7_KjU() {
        return this.errorContainerColor;
    }

    /* JADX INFO: renamed from: getErrorCursorColor-0d7_KjU, reason: not valid java name */
    public final long m3291getErrorCursorColor0d7_KjU() {
        return this.errorCursorColor;
    }

    /* JADX INFO: renamed from: getErrorIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m3292getErrorIndicatorColor0d7_KjU() {
        return this.errorIndicatorColor;
    }

    /* JADX INFO: renamed from: getErrorLabelColor-0d7_KjU, reason: not valid java name */
    public final long m3293getErrorLabelColor0d7_KjU() {
        return this.errorLabelColor;
    }

    /* JADX INFO: renamed from: getErrorLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3294getErrorLeadingIconColor0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    /* JADX INFO: renamed from: getErrorPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m3295getErrorPlaceholderColor0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    /* JADX INFO: renamed from: getErrorPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m3296getErrorPrefixColor0d7_KjU() {
        return this.errorPrefixColor;
    }

    /* JADX INFO: renamed from: getErrorSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m3297getErrorSuffixColor0d7_KjU() {
        return this.errorSuffixColor;
    }

    /* JADX INFO: renamed from: getErrorSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m3298getErrorSupportingTextColor0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    /* JADX INFO: renamed from: getErrorTextColor-0d7_KjU, reason: not valid java name */
    public final long m3299getErrorTextColor0d7_KjU() {
        return this.errorTextColor;
    }

    /* JADX INFO: renamed from: getErrorTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3300getErrorTrailingIconColor0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    /* JADX INFO: renamed from: getFocusedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3301getFocusedContainerColor0d7_KjU() {
        return this.focusedContainerColor;
    }

    /* JADX INFO: renamed from: getFocusedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m3302getFocusedIndicatorColor0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    /* JADX INFO: renamed from: getFocusedLabelColor-0d7_KjU, reason: not valid java name */
    public final long m3303getFocusedLabelColor0d7_KjU() {
        return this.focusedLabelColor;
    }

    /* JADX INFO: renamed from: getFocusedLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3304getFocusedLeadingIconColor0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    /* JADX INFO: renamed from: getFocusedPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m3305getFocusedPlaceholderColor0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    /* JADX INFO: renamed from: getFocusedPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m3306getFocusedPrefixColor0d7_KjU() {
        return this.focusedPrefixColor;
    }

    /* JADX INFO: renamed from: getFocusedSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m3307getFocusedSuffixColor0d7_KjU() {
        return this.focusedSuffixColor;
    }

    /* JADX INFO: renamed from: getFocusedSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m3308getFocusedSupportingTextColor0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    /* JADX INFO: renamed from: getFocusedTextColor-0d7_KjU, reason: not valid java name */
    public final long m3309getFocusedTextColor0d7_KjU() {
        return this.focusedTextColor;
    }

    /* JADX INFO: renamed from: getFocusedTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3310getFocusedTrailingIconColor0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    /* JADX INFO: renamed from: getUnfocusedContainerColor-0d7_KjU, reason: not valid java name */
    public final long m3311getUnfocusedContainerColor0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    /* JADX INFO: renamed from: getUnfocusedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m3312getUnfocusedIndicatorColor0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    /* JADX INFO: renamed from: getUnfocusedLabelColor-0d7_KjU, reason: not valid java name */
    public final long m3313getUnfocusedLabelColor0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    /* JADX INFO: renamed from: getUnfocusedLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3314getUnfocusedLeadingIconColor0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    /* JADX INFO: renamed from: getUnfocusedPlaceholderColor-0d7_KjU, reason: not valid java name */
    public final long m3315getUnfocusedPlaceholderColor0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    /* JADX INFO: renamed from: getUnfocusedPrefixColor-0d7_KjU, reason: not valid java name */
    public final long m3316getUnfocusedPrefixColor0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    /* JADX INFO: renamed from: getUnfocusedSuffixColor-0d7_KjU, reason: not valid java name */
    public final long m3317getUnfocusedSuffixColor0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    /* JADX INFO: renamed from: getUnfocusedSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m3318getUnfocusedSupportingTextColor0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    /* JADX INFO: renamed from: getUnfocusedTextColor-0d7_KjU, reason: not valid java name */
    public final long m3319getUnfocusedTextColor0d7_KjU() {
        return this.unfocusedTextColor;
    }

    /* JADX INFO: renamed from: getUnfocusedTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3320getUnfocusedTrailingIconColor0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    private static final TextSelectionColors copy_ejIjP34$lambda$10(TextFieldColors r0) {
        return r0.textSelectionColors;
    }

    /* JADX INFO: renamed from: cursorColor-vNxB06k$material3, reason: not valid java name */
    public final long m3278cursorColorvNxB06k$material3(boolean r3) {
        if (r3 == false) goto L5;
        return this.errorCursorColor;
    L5:
        return this.cursorColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L140:
        return false;
    L8:
        if ((r7 instanceof TextFieldColors) == false) goto L140;
        TextFieldColors r8 = (TextFieldColors) r7;
        if (Color.equals-impl0(this.focusedTextColor, r8.focusedTextColor) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.unfocusedTextColor, r8.unfocusedTextColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.disabledTextColor, r8.disabledTextColor) == true) goto L20;
        return false;
    L20:
        if (Color.equals-impl0(this.errorTextColor, r8.errorTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.equals-impl0(this.focusedContainerColor, r8.focusedContainerColor) == true) goto L26;
        return false;
    L26:
        if (Color.equals-impl0(this.unfocusedContainerColor, r8.unfocusedContainerColor) == true) goto L29;
        return false;
    L29:
        if (Color.equals-impl0(this.disabledContainerColor, r8.disabledContainerColor) == true) goto L32;
        return false;
    L32:
        if (Color.equals-impl0(this.errorContainerColor, r8.errorContainerColor) == true) goto L35;
        return false;
    L35:
        if (Color.equals-impl0(this.cursorColor, r8.cursorColor) == true) goto L38;
        return false;
    L38:
        if (Color.equals-impl0(this.errorCursorColor, r8.errorCursorColor) == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.textSelectionColors, r8.textSelectionColors) == true) goto L44;
        return false;
    L44:
        if (Color.equals-impl0(this.focusedIndicatorColor, r8.focusedIndicatorColor) == true) goto L47;
        return false;
    L47:
        if (Color.equals-impl0(this.unfocusedIndicatorColor, r8.unfocusedIndicatorColor) == true) goto L50;
        return false;
    L50:
        if (Color.equals-impl0(this.disabledIndicatorColor, r8.disabledIndicatorColor) == true) goto L53;
        return false;
    L53:
        if (Color.equals-impl0(this.errorIndicatorColor, r8.errorIndicatorColor) == true) goto L56;
        return false;
    L56:
        if (Color.equals-impl0(this.focusedLeadingIconColor, r8.focusedLeadingIconColor) == true) goto L59;
        return false;
    L59:
        if (Color.equals-impl0(this.unfocusedLeadingIconColor, r8.unfocusedLeadingIconColor) == true) goto L62;
        return false;
    L62:
        if (Color.equals-impl0(this.disabledLeadingIconColor, r8.disabledLeadingIconColor) == true) goto L65;
        return false;
    L65:
        if (Color.equals-impl0(this.errorLeadingIconColor, r8.errorLeadingIconColor) == true) goto L68;
        return false;
    L68:
        if (Color.equals-impl0(this.focusedTrailingIconColor, r8.focusedTrailingIconColor) == true) goto L71;
        return false;
    L71:
        if (Color.equals-impl0(this.unfocusedTrailingIconColor, r8.unfocusedTrailingIconColor) == true) goto L74;
        return false;
    L74:
        if (Color.equals-impl0(this.disabledTrailingIconColor, r8.disabledTrailingIconColor) == true) goto L77;
        return false;
    L77:
        if (Color.equals-impl0(this.errorTrailingIconColor, r8.errorTrailingIconColor) == true) goto L80;
        return false;
    L80:
        if (Color.equals-impl0(this.focusedLabelColor, r8.focusedLabelColor) == true) goto L83;
        return false;
    L83:
        if (Color.equals-impl0(this.unfocusedLabelColor, r8.unfocusedLabelColor) == true) goto L86;
        return false;
    L86:
        if (Color.equals-impl0(this.disabledLabelColor, r8.disabledLabelColor) == true) goto L89;
        return false;
    L89:
        if (Color.equals-impl0(this.errorLabelColor, r8.errorLabelColor) == true) goto L92;
        return false;
    L92:
        if (Color.equals-impl0(this.focusedPlaceholderColor, r8.focusedPlaceholderColor) == true) goto L95;
        return false;
    L95:
        if (Color.equals-impl0(this.unfocusedPlaceholderColor, r8.unfocusedPlaceholderColor) == true) goto L98;
        return false;
    L98:
        if (Color.equals-impl0(this.disabledPlaceholderColor, r8.disabledPlaceholderColor) == true) goto L101;
        return false;
    L101:
        if (Color.equals-impl0(this.errorPlaceholderColor, r8.errorPlaceholderColor) == true) goto L104;
        return false;
    L104:
        if (Color.equals-impl0(this.focusedSupportingTextColor, r8.focusedSupportingTextColor) == true) goto L107;
        return false;
    L107:
        if (Color.equals-impl0(this.unfocusedSupportingTextColor, r8.unfocusedSupportingTextColor) == true) goto L110;
        return false;
    L110:
        if (Color.equals-impl0(this.disabledSupportingTextColor, r8.disabledSupportingTextColor) == true) goto L113;
        return false;
    L113:
        if (Color.equals-impl0(this.errorSupportingTextColor, r8.errorSupportingTextColor) == true) goto L116;
        return false;
    L116:
        if (Color.equals-impl0(this.focusedPrefixColor, r8.focusedPrefixColor) == true) goto L119;
        return false;
    L119:
        if (Color.equals-impl0(this.unfocusedPrefixColor, r8.unfocusedPrefixColor) == true) goto L122;
        return false;
    L122:
        if (Color.equals-impl0(this.disabledPrefixColor, r8.disabledPrefixColor) == true) goto L125;
        return false;
    L125:
        if (Color.equals-impl0(this.errorPrefixColor, r8.errorPrefixColor) == true) goto L128;
        return false;
    L128:
        if (Color.equals-impl0(this.focusedSuffixColor, r8.focusedSuffixColor) == true) goto L131;
        return false;
    L131:
        if (Color.equals-impl0(this.unfocusedSuffixColor, r8.unfocusedSuffixColor) == true) goto L134;
        return false;
    L134:
        if (Color.equals-impl0(this.disabledSuffixColor, r8.disabledSuffixColor) == true) goto L137;
        return false;
    L137:
        if (Color.equals-impl0(this.errorSuffixColor, r8.errorSuffixColor) == true) goto L139;
        return false;
    L139:
        return true;
    }

    public final TextSelectionColors takeOrElse$material3(TextSelectionColors r1, Function0<TextSelectionColors> r2) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return (TextSelectionColors) r2.invoke();
    }

    /* JADX INFO: renamed from: containerColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3276containerColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedContainerColor;
    L9:
        return this.unfocusedContainerColor;
    L11:
        return this.errorContainerColor;
    L10:
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: indicatorColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3321indicatorColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedIndicatorColor;
    L9:
        return this.unfocusedIndicatorColor;
    L11:
        return this.errorIndicatorColor;
    L10:
        return this.disabledIndicatorColor;
    }

    /* JADX INFO: renamed from: labelColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3322labelColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedLabelColor;
    L9:
        return this.unfocusedLabelColor;
    L11:
        return this.errorLabelColor;
    L10:
        return this.disabledLabelColor;
    }

    /* JADX INFO: renamed from: leadingIconColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3323leadingIconColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedLeadingIconColor;
    L9:
        return this.unfocusedLeadingIconColor;
    L11:
        return this.errorLeadingIconColor;
    L10:
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: placeholderColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3324placeholderColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedPlaceholderColor;
    L9:
        return this.unfocusedPlaceholderColor;
    L11:
        return this.errorPlaceholderColor;
    L10:
        return this.disabledPlaceholderColor;
    }

    /* JADX INFO: renamed from: prefixColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3325prefixColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedPrefixColor;
    L9:
        return this.unfocusedPrefixColor;
    L11:
        return this.errorPrefixColor;
    L10:
        return this.disabledPrefixColor;
    }

    /* JADX INFO: renamed from: suffixColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3326suffixColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedSuffixColor;
    L9:
        return this.unfocusedSuffixColor;
    L11:
        return this.errorSuffixColor;
    L10:
        return this.disabledSuffixColor;
    }

    /* JADX INFO: renamed from: supportingTextColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3327supportingTextColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedSupportingTextColor;
    L9:
        return this.unfocusedSupportingTextColor;
    L11:
        return this.errorSupportingTextColor;
    L10:
        return this.disabledSupportingTextColor;
    }

    /* JADX INFO: renamed from: textColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3328textColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedTextColor;
    L9:
        return this.unfocusedTextColor;
    L11:
        return this.errorTextColor;
    L10:
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: trailingIconColor-XeAY9LY$material3, reason: not valid java name */
    public final long m3329trailingIconColorXeAY9LY$material3(boolean r1, boolean r2, boolean r3) {
        if (r1 == false) goto L10;
        if (r2 == true) goto L11;
        if (r3 == false) goto L9;
        return this.focusedTrailingIconColor;
    L9:
        return this.unfocusedTrailingIconColor;
    L11:
        return this.errorTrailingIconColor;
    L10:
        return this.disabledTrailingIconColor;
    }

    private TextFieldColors(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, TextSelectionColors r24, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87) {
        this.focusedTextColor = r4;
        this.unfocusedTextColor = r6;
        this.disabledTextColor = r8;
        this.errorTextColor = r10;
        this.focusedContainerColor = r12;
        this.unfocusedContainerColor = r14;
        this.disabledContainerColor = r16;
        this.errorContainerColor = r18;
        this.cursorColor = r20;
        this.errorCursorColor = r22;
        this.textSelectionColors = r24;
        this.focusedIndicatorColor = r25;
        this.unfocusedIndicatorColor = r27;
        this.disabledIndicatorColor = r29;
        this.errorIndicatorColor = r31;
        this.focusedLeadingIconColor = r33;
        this.unfocusedLeadingIconColor = r35;
        this.disabledLeadingIconColor = r37;
        this.errorLeadingIconColor = r39;
        this.focusedTrailingIconColor = r41;
        this.unfocusedTrailingIconColor = r43;
        this.disabledTrailingIconColor = r45;
        this.errorTrailingIconColor = r47;
        this.focusedLabelColor = r49;
        this.unfocusedLabelColor = r51;
        this.disabledLabelColor = r53;
        this.errorLabelColor = r55;
        this.focusedPlaceholderColor = r57;
        this.unfocusedPlaceholderColor = r59;
        this.disabledPlaceholderColor = r61;
        this.errorPlaceholderColor = r63;
        this.focusedSupportingTextColor = r65;
        this.unfocusedSupportingTextColor = r67;
        this.disabledSupportingTextColor = r69;
        this.errorSupportingTextColor = r71;
        this.focusedPrefixColor = r73;
        this.unfocusedPrefixColor = r75;
        this.disabledPrefixColor = r77;
        this.errorPrefixColor = r79;
        this.focusedSuffixColor = r81;
        this.unfocusedSuffixColor = r83;
        this.disabledSuffixColor = r85;
        this.errorSuffixColor = r87;
    }

    /* JADX INFO: renamed from: copy-ejIjP34, reason: not valid java name */
    public final TextFieldColors m3277copyejIjP34(long r95, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, TextSelectionColors r115, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, long r146, long r148, long r150, long r152, long r154, long r156, long r158, long r160, long r162, long r164, long r166, long r168, long r170, long r172, long r174, long r176, long r178) {
        boolean r1 = true;
        if (r95 == 16) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        long r8 = r95;
    L10:
        if (r97 == 16) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        long r10 = r97;
    L17:
        if (r99 == 16) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        long r12 = r99;
    L24:
        if (r101 == 16) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        long r14 = r101;
    L31:
        if (r103 == 16) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L36;
        long r16 = r103;
    L38:
        if (r105 == 16) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        long r18 = r105;
    L45:
        if (r107 == 16) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L50;
        long r20 = r107;
    L52:
        if (r109 == 16) goto L54;
        boolean r17 = true;
    L55:
        if (r17 == false) goto L57;
        long r22 = r109;
    L59:
        if (r111 == 16) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == false) goto L64;
        long r24 = r111;
    L66:
        if (r113 == 16) goto L68;
        boolean r21 = true;
    L69:
        if (r21 == false) goto L71;
        long r26 = r113;
    L72:
        TextSelectionColors r28 = takeOrElse$material3(r115, new et(this));
        if (r116 == 16) goto L75;
        boolean r23 = true;
    L76:
        if (r23 == false) goto L78;
        long r29 = r116;
    L80:
        if (r118 == 16) goto L82;
        boolean r25 = true;
    L83:
        if (r25 == false) goto L85;
        long r31 = r118;
    L87:
        if (r120 == 16) goto L89;
        boolean r27 = true;
    L90:
        if (r27 == false) goto L92;
        long r33 = r120;
    L94:
        if (r122 == 16) goto L96;
        boolean r30 = true;
    L97:
        if (r30 == false) goto L99;
        long r35 = r122;
    L101:
        if (r124 == 16) goto L103;
        boolean r32 = true;
    L104:
        if (r32 == false) goto L106;
        long r37 = r124;
    L108:
        if (r126 == 16) goto L110;
        boolean r34 = true;
    L111:
        if (r34 == false) goto L113;
        long r39 = r126;
    L115:
        if (r128 == 16) goto L117;
        boolean r36 = true;
    L118:
        if (r36 == false) goto L120;
        long r41 = r128;
    L122:
        if (r130 == 16) goto L124;
        boolean r38 = true;
    L125:
        if (r38 == false) goto L127;
        long r43 = r130;
    L129:
        if (r132 == 16) goto L131;
        boolean r40 = true;
    L132:
        if (r40 == false) goto L134;
        long r45 = r132;
    L136:
        if (r134 == 16) goto L138;
        boolean r42 = true;
    L139:
        if (r42 == false) goto L141;
        long r47 = r134;
    L143:
        if (r136 == 16) goto L145;
        boolean r44 = true;
    L146:
        if (r44 == false) goto L148;
        long r49 = r136;
    L150:
        if (r138 == 16) goto L152;
        boolean r46 = true;
    L153:
        if (r46 == false) goto L155;
        long r51 = r138;
    L157:
        if (r140 == 16) goto L159;
        boolean r48 = true;
    L160:
        if (r48 == false) goto L162;
        long r53 = r140;
    L164:
        if (r142 == 16) goto L166;
        boolean r50 = true;
    L167:
        if (r50 == false) goto L169;
        long r55 = r142;
    L171:
        if (r144 == 16) goto L173;
        boolean r52 = true;
    L174:
        if (r52 == false) goto L176;
        long r57 = r144;
    L178:
        if (r146 == 16) goto L180;
        boolean r54 = true;
    L181:
        if (r54 == false) goto L183;
        long r59 = r146;
    L185:
        if (r148 == 16) goto L187;
        boolean r56 = true;
    L188:
        if (r56 == false) goto L190;
        long r61 = r148;
    L192:
        if (r150 == 16) goto L194;
        boolean r58 = true;
    L195:
        if (r58 == false) goto L197;
        long r63 = r150;
    L199:
        if (r152 == 16) goto L201;
        boolean r60 = true;
    L202:
        if (r60 == false) goto L204;
        long r65 = r152;
    L206:
        if (r154 == 16) goto L208;
        boolean r62 = true;
    L209:
        if (r62 == false) goto L211;
        long r67 = r154;
    L213:
        if (r156 == 16) goto L215;
        boolean r64 = true;
    L216:
        if (r64 == false) goto L218;
        long r69 = r156;
    L220:
        if (r158 == 16) goto L222;
        boolean r66 = true;
    L223:
        if (r66 == false) goto L225;
        long r71 = r158;
    L227:
        if (r160 == 16) goto L229;
        boolean r68 = true;
    L230:
        if (r68 == false) goto L232;
        long r73 = r160;
    L234:
        if (r162 == 16) goto L236;
        boolean r70 = true;
    L237:
        if (r70 == false) goto L239;
        long r75 = r162;
    L241:
        if (r164 == 16) goto L243;
        boolean r72 = true;
    L244:
        if (r72 == false) goto L246;
        long r77 = r164;
    L248:
        if (r166 == 16) goto L250;
        boolean r74 = true;
    L251:
        if (r74 == false) goto L253;
        long r79 = r166;
    L255:
        if (r168 == 16) goto L257;
        boolean r76 = true;
    L258:
        if (r76 == false) goto L260;
        long r81 = r168;
    L262:
        if (r170 == 16) goto L264;
        boolean r78 = true;
    L265:
        if (r78 == false) goto L267;
        long r83 = r170;
    L269:
        if (r172 == 16) goto L271;
        boolean r80 = true;
    L272:
        if (r80 == false) goto L274;
        long r85 = r172;
    L276:
        if (r174 == 16) goto L278;
        boolean r82 = true;
    L279:
        if (r82 == false) goto L281;
        long r87 = r174;
    L283:
        if (r176 == 16) goto L285;
        boolean r84 = true;
    L286:
        if (r84 == false) goto L288;
        long r89 = r176;
    L290:
        if (r178 != 16) goto L293;
        r1 = false;
    L293:
        if (r1 == false) goto L295;
        long r91 = r178;
    L297:
        return new TextFieldColors(r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, null);
    L295:
        r91 = this.errorSuffixColor;
        goto L297
    L288:
        r89 = this.disabledSuffixColor;
        goto L290
    L285:
        r84 = false;
        goto L286
    L281:
        r87 = this.unfocusedSuffixColor;
        goto L283
    L278:
        r82 = false;
        goto L279
    L274:
        r85 = this.focusedSuffixColor;
        goto L276
    L271:
        r80 = false;
        goto L272
    L267:
        r83 = this.errorPrefixColor;
        goto L269
    L264:
        r78 = false;
        goto L265
    L260:
        r81 = this.disabledPrefixColor;
        goto L262
    L257:
        r76 = false;
        goto L258
    L253:
        r79 = this.unfocusedPrefixColor;
        goto L255
    L250:
        r74 = false;
        goto L251
    L246:
        r77 = this.focusedPrefixColor;
        goto L248
    L243:
        r72 = false;
        goto L244
    L239:
        r75 = this.errorSupportingTextColor;
        goto L241
    L236:
        r70 = false;
        goto L237
    L232:
        r73 = this.disabledSupportingTextColor;
        goto L234
    L229:
        r68 = false;
        goto L230
    L225:
        r71 = this.unfocusedSupportingTextColor;
        goto L227
    L222:
        r66 = false;
        goto L223
    L218:
        r69 = this.focusedSupportingTextColor;
        goto L220
    L215:
        r64 = false;
        goto L216
    L211:
        r67 = this.errorPlaceholderColor;
        goto L213
    L208:
        r62 = false;
        goto L209
    L204:
        r65 = this.disabledPlaceholderColor;
        goto L206
    L201:
        r60 = false;
        goto L202
    L197:
        r63 = this.unfocusedPlaceholderColor;
        goto L199
    L194:
        r58 = false;
        goto L195
    L190:
        r61 = this.focusedPlaceholderColor;
        goto L192
    L187:
        r56 = false;
        goto L188
    L183:
        r59 = this.errorLabelColor;
        goto L185
    L180:
        r54 = false;
        goto L181
    L176:
        r57 = this.disabledLabelColor;
        goto L178
    L173:
        r52 = false;
        goto L174
    L169:
        r55 = this.unfocusedLabelColor;
        goto L171
    L166:
        r50 = false;
        goto L167
    L162:
        r53 = this.focusedLabelColor;
        goto L164
    L159:
        r48 = false;
        goto L160
    L155:
        r51 = this.errorTrailingIconColor;
        goto L157
    L152:
        r46 = false;
        goto L153
    L148:
        r49 = this.disabledTrailingIconColor;
        goto L150
    L145:
        r44 = false;
        goto L146
    L141:
        r47 = this.unfocusedTrailingIconColor;
        goto L143
    L138:
        r42 = false;
        goto L139
    L134:
        r45 = this.focusedTrailingIconColor;
        goto L136
    L131:
        r40 = false;
        goto L132
    L127:
        r43 = this.errorLeadingIconColor;
        goto L129
    L124:
        r38 = false;
        goto L125
    L120:
        r41 = this.disabledLeadingIconColor;
        goto L122
    L117:
        r36 = false;
        goto L118
    L113:
        r39 = this.unfocusedLeadingIconColor;
        goto L115
    L110:
        r34 = false;
        goto L111
    L106:
        r37 = this.focusedLeadingIconColor;
        goto L108
    L103:
        r32 = false;
        goto L104
    L99:
        r35 = this.errorIndicatorColor;
        goto L101
    L96:
        r30 = false;
        goto L97
    L92:
        r33 = this.disabledIndicatorColor;
        goto L94
    L89:
        r27 = false;
        goto L90
    L85:
        r31 = this.unfocusedIndicatorColor;
        goto L87
    L82:
        r25 = false;
        goto L83
    L78:
        r29 = this.focusedIndicatorColor;
        goto L80
    L75:
        r23 = false;
        goto L76
    L71:
        r26 = this.errorCursorColor;
        goto L72
    L68:
        r21 = false;
        goto L69
    L64:
        r24 = this.cursorColor;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r22 = this.errorContainerColor;
        goto L59
    L54:
        r17 = false;
        goto L55
    L50:
        r20 = this.disabledContainerColor;
        goto L52
    L47:
        r15 = false;
        goto L48
    L43:
        r18 = this.unfocusedContainerColor;
        goto L45
    L40:
        r13 = false;
        goto L41
    L36:
        r16 = this.focusedContainerColor;
        goto L38
    L33:
        r11 = false;
        goto L34
    L29:
        r14 = this.errorTextColor;
        goto L31
    L26:
        r9 = false;
        goto L27
    L22:
        r12 = this.disabledTextColor;
        goto L24
    L19:
        r7 = false;
        goto L20
    L15:
        r10 = this.unfocusedTextColor;
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        r8 = this.focusedTextColor;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: copy-ejIjP34$default, reason: not valid java name */
    public static /* synthetic */ TextFieldColors m3275copyejIjP34$default(TextFieldColors r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35, TextSelectionColors r37, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, long r78, long r80, long r82, long r84, long r86, long r88, long r90, long r92, long r94, long r96, long r98, long r100, int r102, int r103, Object r104) {
        if ((r102 & 1) == 0) goto L5;
        long r3 = r16.focusedTextColor;
    L7:
        if ((r102 & 2) == 0) goto L9;
        long r5 = r16.unfocusedTextColor;
    L11:
        if ((r102 & 4) == 0) goto L13;
        long r7 = r16.disabledTextColor;
    L15:
        if ((r102 & 8) == 0) goto L17;
        long r9 = r16.errorTextColor;
    L19:
        if ((r102 & 16) == 0) goto L21;
        long r11 = r16.focusedContainerColor;
    L23:
        if ((r102 & 32) == 0) goto L25;
        long r13 = r16.unfocusedContainerColor;
    L26:
        long r28 = r13;
        if ((r102 & 64) == 0) goto L29;
        long r14 = r16.disabledContainerColor;
    L30:
        long r210 = r14;
        if ((r102 & 128) == 0) goto L33;
        long r15 = r16.errorContainerColor;
    L34:
        long r32 = r15;
        if ((r102 & 256) == 0) goto L37;
        long r18 = r16.cursorColor;
    L38:
        long r34 = r18;
        if ((r102 & 512) == 0) goto L41;
        long r110 = r16.errorCursorColor;
    L43:
        if ((r102 & 1024) == 0) goto L45;
        TextSelectionColors r111 = r16.textSelectionColors;
    L46:
        TextSelectionColors r39 = r111;
        long r36 = r110;
        if ((r102 & 2048) == 0) goto L49;
        long r112 = r16.focusedIndicatorColor;
    L50:
        long r310 = r112;
        if ((r102 & 4096) == 0) goto L53;
        long r113 = r16.unfocusedIndicatorColor;
    L54:
        long r41 = r113;
        if ((r102 & 8192) == 0) goto L57;
        long r114 = r16.disabledIndicatorColor;
    L58:
        long r43 = r114;
        if ((r102 & 16384) == 0) goto L61;
        long r115 = r16.errorIndicatorColor;
    L62:
        long r45 = r115;
        if ((32768 & r102) == 0) goto L65;
        long r116 = r16.focusedLeadingIconColor;
    L66:
        long r47 = r116;
        if ((65536 & r102) == 0) goto L69;
        long r117 = r16.unfocusedLeadingIconColor;
    L70:
        long r49 = r117;
        if ((131072 & r102) == 0) goto L73;
        long r118 = r16.disabledLeadingIconColor;
    L74:
        long r51 = r118;
        if ((262144 & r102) == 0) goto L77;
        long r119 = r16.errorLeadingIconColor;
    L78:
        long r53 = r119;
        if ((524288 & r102) == 0) goto L81;
        long r120 = r16.focusedTrailingIconColor;
    L82:
        long r55 = r120;
        if ((1048576 & r102) == 0) goto L85;
        long r121 = r16.unfocusedTrailingIconColor;
    L86:
        long r57 = r121;
        if ((2097152 & r102) == 0) goto L89;
        long r122 = r16.disabledTrailingIconColor;
    L90:
        long r59 = r122;
        if ((4194304 & r102) == 0) goto L93;
        long r123 = r16.errorTrailingIconColor;
    L94:
        long r61 = r123;
        if ((8388608 & r102) == 0) goto L97;
        long r124 = r16.focusedLabelColor;
    L98:
        long r63 = r124;
        if ((16777216 & r102) == 0) goto L101;
        long r125 = r16.unfocusedLabelColor;
    L102:
        long r65 = r125;
        if ((33554432 & r102) == 0) goto L105;
        long r126 = r16.disabledLabelColor;
    L106:
        long r67 = r126;
        if ((67108864 & r102) == 0) goto L109;
        long r127 = r16.errorLabelColor;
    L110:
        long r69 = r127;
        if ((134217728 & r102) == 0) goto L113;
        long r128 = r16.focusedPlaceholderColor;
    L114:
        long r71 = r128;
        if ((268435456 & r102) == 0) goto L117;
        long r129 = r16.unfocusedPlaceholderColor;
    L118:
        long r73 = r129;
        if ((536870912 & r102) == 0) goto L121;
        long r130 = r16.disabledPlaceholderColor;
    L122:
        long r75 = r130;
        if ((1073741824 & r102) == 0) goto L125;
        long r131 = r16.errorPlaceholderColor;
    L126:
        long r77 = r131;
        if ((r102 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r132 = r16.focusedSupportingTextColor;
    L130:
        long r79 = r132;
        if ((r103 & 1) == 0) goto L133;
        long r133 = r16.unfocusedSupportingTextColor;
    L134:
        long r81 = r133;
        if ((r103 & 2) == 0) goto L137;
        long r134 = r16.disabledSupportingTextColor;
    L138:
        long r83 = r134;
        if ((r103 & 4) == 0) goto L141;
        long r135 = r16.errorSupportingTextColor;
    L142:
        long r85 = r135;
        if ((r103 & 8) == 0) goto L145;
        long r136 = r16.focusedPrefixColor;
    L146:
        long r87 = r136;
        if ((r103 & 16) == 0) goto L149;
        long r137 = r16.unfocusedPrefixColor;
    L150:
        long r89 = r137;
        if ((r103 & 32) == 0) goto L153;
        long r138 = r16.disabledPrefixColor;
    L154:
        long r91 = r138;
        if ((r103 & 64) == 0) goto L157;
        long r139 = r16.errorPrefixColor;
    L158:
        long r93 = r139;
        if ((r103 & 128) == 0) goto L161;
        long r140 = r16.focusedSuffixColor;
    L162:
        long r95 = r140;
        if ((r103 & 256) == 0) goto L165;
        long r141 = r16.unfocusedSuffixColor;
    L166:
        long r97 = r141;
        if ((r103 & 512) == 0) goto L169;
        long r142 = r16.disabledSuffixColor;
    L171:
        if ((r103 & 1024) == 0) goto L173;
        long r1 = r16.errorSuffixColor;
    L175:
        return r16.m3277copyejIjP34(r3, r5, r7, r9, r11, r28, r210, r32, r34, r36, r39, r310, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r81, r83, r85, r87, r89, r91, r93, r95, r97, r142, r1);
    L173:
        r1 = r100;
        goto L175
    L169:
        r142 = r98;
        goto L171
    L165:
        r141 = r96;
        goto L166
    L161:
        r140 = r94;
        goto L162
    L157:
        r139 = r92;
        goto L158
    L153:
        r138 = r90;
        goto L154
    L149:
        r137 = r88;
        goto L150
    L145:
        r136 = r86;
        goto L146
    L141:
        r135 = r84;
        goto L142
    L137:
        r134 = r82;
        goto L138
    L133:
        r133 = r80;
        goto L134
    L129:
        r132 = r78;
        goto L130
    L125:
        r131 = r76;
        goto L126
    L121:
        r130 = r74;
        goto L122
    L117:
        r129 = r72;
        goto L118
    L113:
        r128 = r70;
        goto L114
    L109:
        r127 = r68;
        goto L110
    L105:
        r126 = r66;
        goto L106
    L101:
        r125 = r64;
        goto L102
    L97:
        r124 = r62;
        goto L98
    L93:
        r123 = r60;
        goto L94
    L89:
        r122 = r58;
        goto L90
    L85:
        r121 = r56;
        goto L86
    L81:
        r120 = r54;
        goto L82
    L77:
        r119 = r52;
        goto L78
    L73:
        r118 = r50;
        goto L74
    L69:
        r117 = r48;
        goto L70
    L65:
        r116 = r46;
        goto L66
    L61:
        r115 = r44;
        goto L62
    L57:
        r114 = r42;
        goto L58
    L53:
        r113 = r40;
        goto L54
    L49:
        r112 = r38;
        goto L50
    L45:
        r111 = r37;
        goto L46
    L41:
        r110 = r35;
        goto L43
    L37:
        r18 = r33;
        goto L38
    L33:
        r15 = r31;
        goto L34
    L29:
        r14 = r29;
        goto L30
    L25:
        r13 = r27;
        goto L26
    L21:
        r11 = r25;
        goto L23
    L17:
        r9 = r23;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }
}
