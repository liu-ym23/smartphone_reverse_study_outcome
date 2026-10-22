package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0013H\u0002J\u0013\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "didOverflow", "", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public /* synthetic */ AutoSizeStepBased(long r1, long r3, long r5, DefaultConstructorMarker r7) {
        this(r1, r3, r5);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.hashCode-impl(this.minFontSize) * 31) + TextUnit.hashCode-impl(this.maxFontSize)) * 31) + TextUnit.hashCode-impl(this.stepSize);
    }

    private final boolean didOverflow(TextLayoutResult r4) {
        int r0 = r4.getLayoutInput().getOverflow-gIe3tQ8();
        TextOverflow.Companion r1 = TextOverflow.Companion;
        if (TextOverflow.equals-impl0(r0, r1.getClip-gIe3tQ8()) == true) goto L18;
        if (TextOverflow.equals-impl0(r0, r1.getVisible-gIe3tQ8()) == true) goto L18;
        if (TextOverflow.equals-impl0(r0, r1.getStartEllipsis-gIe3tQ8()) == true) goto L19;
        if (TextOverflow.equals-impl0(r0, r1.getMiddleEllipsis-gIe3tQ8()) == true) goto L19;
        if (TextOverflow.equals-impl0(r0, r1.getEllipsis-gIe3tQ8()) == true) goto L19;
        throw new IllegalArgumentException("TextOverflow type " + TextOverflow.toString-impl(r4.getLayoutInput().getOverflow-gIe3tQ8()) + " is not supported.");
    L19:
        return didOverflowByEllipsize(r4);
    L18:
        return didOverflowBounds(r4);
    }

    private final boolean didOverflowBounds(TextLayoutResult r2) {
        if (r2.getDidOverflowWidth() == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.getDidOverflowHeight() == true) goto L8;
        return false;
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult r6) {
        int r0 = r6.getLineCount();
        if (r0 != 0) goto L5;
        return false;
    L5:
        if (r0 == 1) goto L16;
        int r1 = r6.getLayoutInput().getOverflow-gIe3tQ8();
        TextOverflow.Companion r3 = TextOverflow.Companion;
        if (TextOverflow.equals-impl0(r1, r3.getStartEllipsis-gIe3tQ8()) == true) goto L20;
        if (TextOverflow.equals-impl0(r1, r3.getMiddleEllipsis-gIe3tQ8()) == true) goto L20;
        if (TextOverflow.equals-impl0(r1, r3.getEllipsis-gIe3tQ8()) == true) goto L19;
        return false;
    L19:
        return r6.isLineEllipsized(r6.getLineCount() - 1);
    L20:
        return didOverflowBounds(r6);
    L16:
        return r6.isLineEllipsized(0);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (r7 != null) goto L9;
        return false;
    L9:
        if ((r7 instanceof AutoSizeStepBased) == true) goto L11;
        return false;
    L11:
        AutoSizeStepBased r8 = (AutoSizeStepBased) r7;
        if (TextUnit.equals-impl0(r8.minFontSize, this.minFontSize) == true) goto L15;
        return false;
    L15:
        if (TextUnit.equals-impl0(r8.maxFontSize, this.maxFontSize) == true) goto L18;
        return false;
    L18:
        if (TextUnit.equals-impl0(r8.stepSize, this.stepSize) == true) goto L20;
        return false;
    L20:
        return true;
    }

    private AutoSizeStepBased(long r4, long r6, long r8) {
        this.minFontSize = r4;
        this.maxFontSize = r6;
        this.stepSize = r8;
        TextUnit.Companion r0 = TextUnit.Companion;
        if (TextUnit.equals-impl0(r4, r0.getUnspecified-XSAIIZE()) == true) goto L34;
        if (TextUnit.equals-impl0(r6, r0.getUnspecified-XSAIIZE()) == true) goto L32;
        if (TextUnit.equals-impl0(r8, r0.getUnspecified-XSAIIZE()) == true) goto L30;
        if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(this.minFontSize), TextUnit.getType-UIouoOA(r6)) == false) goto L14;
        long r5 = this.minFontSize;
        TextUnitKt.checkArithmetic-NB67dxo(r5, r6);
        if (Float.compare(TextUnit.getValue-impl(r5), TextUnit.getValue-impl(r6)) <= 0) goto L14;
        this.minFontSize = r6;
    L14:
        if (TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(r8), TextUnitType.Companion.getSp-UIouoOA()) == false) goto L21;
        long r7 = TextUnitKt.getSp(1.0E-4f);
        TextUnitKt.checkArithmetic-NB67dxo(r8, r7);
        if (Float.compare(TextUnit.getValue-impl(r8), TextUnit.getValue-impl(r7)) >= 0) goto L21;
        throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
    L21:
        if (TextUnit.getValue-impl(this.minFontSize) < MenuKt.ClosedAlphaTarget) goto L28;
        if (TextUnit.getValue-impl(r6) < MenuKt.ClosedAlphaTarget) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
    L28:
        throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
    L30:
        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
    L32:
        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
    L34:
        throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* JADX INFO: renamed from: getFontSize-Ci0_558, reason: not valid java name */
    public long mo1339getFontSizeCi0_558(TextAutoSizeLayoutScope r16, long r17, AnnotatedString r19) {
        float r8 = r16.toPx--R2X_6o(this.stepSize);
        float r9 = r16.toPx--R2X_6o(this.minFontSize);
        float r10 = r16.toPx--R2X_6o(this.maxFontSize);
        float r11 = 2;
        float r12 = (r9 + r10) / r11;
        float r14 = r9;
        float r13 = r10;
    L4:
        if ((r13 - r14) < r8) goto L10;
        if (didOverflow(r16.mo1778performLayout5ZSfY2I(r17, r19, r16.toSp-kPz2Gy4(r12))) == false) goto L8;
        r13 = r12;
    L9:
        r12 = (r14 + r13) / r11;
        goto L4
    L8:
        r14 = r12;
        goto L9
    L10:
        float r15 = r9 + (((float) Math.floor((r14 - r9) / r8)) * r8);
        float r18 = r8 + r15;
        if (r18 > r10) goto L16;
        if (didOverflow(r16.mo1778performLayout5ZSfY2I(r17, r19, r16.toSp-kPz2Gy4(r18))) == true) goto L16;
        r15 = r18;
    L16:
        return r16.toSp-kPz2Gy4(r15);
    }
}
