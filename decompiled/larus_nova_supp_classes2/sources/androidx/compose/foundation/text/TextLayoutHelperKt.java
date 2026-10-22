package androidx.compose.foundation.text;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\"*\u00020\u00022\u0006\u0010#\u001a\u00020\fH\u0000¨\u0006$"}, d2 = {"canReuse", "", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "canReuse-7_7YC6M", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Z", "isPositionInsideSelection", "position", "Landroidx/compose/ui/geometry/Offset;", "selectionRange", "Landroidx/compose/ui/text/TextRange;", "isPositionInsideSelection-uaM50fQ", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/text/TextRange;)Z", "getLineHeight", "", "offset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutHelperKt {
    public static final float getLineHeight(TextLayoutResult r6, int r7) {
        if (r7 >= 0) goto L5;
    L15:
        return MenuKt.ClosedAlphaTarget;
    L5:
        if (r6.getLayoutInput().getText().length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L15;
        int r2 = Math.min(r6.getMultiParagraph().getLineForOffset(r7), Math.min(r6.getMultiParagraph().getMaxLines() - 1, r6.getMultiParagraph().getLineCount() - 1));
        if (r7 <= MultiParagraph.getLineEnd$default(r6.getMultiParagraph(), r2, false, 2, null)) goto L14;
        return MenuKt.ClosedAlphaTarget;
    L14:
        return r6.getMultiParagraph().getLineHeight(r2);
    L7:
        r1 = false;
        goto L8
    }

    /* JADX INFO: renamed from: isPositionInsideSelection-uaM50fQ, reason: not valid java name */
    public static final boolean m1478isPositionInsideSelectionuaM50fQ(TextLayoutResult r4, long r5, TextRange r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        if (TextRange.getCollapsed-impl(r7.unbox-impl()) == true) goto L15;
        int r1 = r4.getOffsetForPosition-k-4lQ0M(r5);
        if (isPositionInsideSelection_uaM50fQ$isOffsetSelectedAndContainsPosition(r7, r4, r5, r1) == false) goto L10;
    L11:
        return true;
    L10:
        if (isPositionInsideSelection_uaM50fQ$isOffsetSelectedAndContainsPosition(r7, r4, r5, r1 - 1) == true) goto L11;
        return false;
    L15:
        return false;
    }

    private static final boolean isPositionInsideSelection_uaM50fQ$isOffsetSelectedAndContainsPosition(TextRange r2, TextLayoutResult r3, long r4, int r6) {
        if (TextRange.contains-impl(r2.unbox-impl(), r6) == true) goto L5;
    L7:
        return false;
    L5:
        if (r3.getBoundingBox(r6).contains-k-4lQ0M(r4) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: canReuse-7_7YC6M, reason: not valid java name */
    public static final boolean m1477canReuse7_7YC6M(TextLayoutResult r2, AnnotatedString r3, TextStyle r4, List<AnnotatedString.Range<Placeholder>> r5, int r6, boolean r7, int r8, Density r9, LayoutDirection r10, FontFamily.Resolver r11, long r12) {
        TextLayoutInput r0 = r2.getLayoutInput();
        if (r2.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r0.getText(), r3) == true) goto L8;
        return false;
    L8:
        if (r0.getStyle().hasSameLayoutAffectingAttributes(r4) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r0.getPlaceholders(), r5) == true) goto L12;
        return false;
    L12:
        if (r0.getMaxLines() == r6) goto L14;
        return false;
    L14:
        if (r0.getSoftWrap() == r7) goto L16;
        return false;
    L16:
        if (TextOverflow.equals-impl0(r0.getOverflow-gIe3tQ8(), r8) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r0.getDensity(), r9) == true) goto L20;
        return false;
    L20:
        if (r0.getLayoutDirection() == r10) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r0.getFontFamilyResolver(), r11) == true) goto L25;
        return false;
    L25:
        if (Constraints.getMinWidth-impl(r12) == Constraints.getMinWidth-impl(r0.getConstraints-msEJaDk())) goto L28;
        return false;
    L28:
        if (r7 == true) goto L33;
        if (TextOverflow.equals-impl0(r8, TextOverflow.Companion.getEllipsis-gIe3tQ8()) == true) goto L33;
        return true;
    L33:
        if (Constraints.getMaxWidth-impl(r12) == Constraints.getMaxWidth-impl(r0.getConstraints-msEJaDk())) goto L35;
        return false;
    L35:
        if (Constraints.getMaxHeight-impl(r12) != Constraints.getMaxHeight-impl(r0.getConstraints-msEJaDk())) goto L47;
        return true;
    L47:
        return false;
    }
}
