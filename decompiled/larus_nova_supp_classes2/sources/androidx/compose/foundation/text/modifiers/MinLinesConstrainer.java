package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "inputTextStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "<init>", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getInputTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolvedStyle", "lineHeightCache", "", "oneLineHeightCache", "coerceMinLines", "Landroidx/compose/ui/unit/Constraints;", "inConstraints", "minLines", "", "coerceMinLines-Oh53vG4$foundation_release", "(JI)J", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MinLinesConstrainer {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static MinLinesConstrainer last;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final TextStyle inputTextStyle;
    private final LayoutDirection layoutDirection;
    private float lineHeightCache;
    private float oneLineHeightCache;
    private final TextStyle resolvedStyle;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer$Companion;", "", "<init>", "()V", "last", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "from", "minMaxUtil", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "paramStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final MinLinesConstrainer from(MinLinesConstrainer r5, LayoutDirection r6, TextStyle r7, Density r8, FontFamily.Resolver r9) {
            boolean r0 = true;
            if (r5 != null) goto L5;
        L16:
            MinLinesConstrainer r10 = MinLinesConstrainer.access$getLast$cp();
            if (r10 != null) goto L19;
        L30:
            MinLinesConstrainer r11 = new MinLinesConstrainer(r6, TextStyleKt.resolveDefaults(r7, r6), DensityKt.Density(r8.getDensity(), r8.getFontScale()), r9);
            MinLinesConstrainer.access$setLast$cp(r11);
            return r11;
        L19:
            if (r6 != r10.getLayoutDirection()) goto L30;
            if (Intrinsics.areEqual(TextStyleKt.resolveDefaults(r7, r6), r10.getInputTextStyle()) == false) goto L30;
            if (r8.getDensity() == r10.getDensity().getDensity()) goto L26;
            r0 = false;
        L26:
            if (r0 == false) goto L30;
            if (r9 != r10.getFontFamilyResolver()) goto L30;
            return r10;
        L5:
            if (r6 != r5.getLayoutDirection()) goto L16;
            if (Intrinsics.areEqual(TextStyleKt.resolveDefaults(r7, r6), r5.getInputTextStyle()) == false) goto L16;
            if (r8.getDensity() != r5.getDensity().getDensity()) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L16;
            if (r9 != r5.getFontFamilyResolver()) goto L16;
            return r5;
        L11:
            r2 = false;
            goto L12
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static final /* synthetic */ MinLinesConstrainer access$getLast$cp() {
        return last;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final TextStyle getInputTextStyle() {
        return this.inputTextStyle;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public static final /* synthetic */ void access$setLast$cp(MinLinesConstrainer r0) {
        last = r0;
    }

    /* JADX INFO: renamed from: coerceMinLines-Oh53vG4$foundation_release, reason: not valid java name */
    public final long m1766coerceMinLinesOh53vG4$foundation_release(long r19, int r21) {
        float r2 = this.oneLineHeightCache;
        float r3 = this.lineHeightCache;
        if (Float.isNaN(r2) == false) goto L5;
    L6:
        String r5 = MinLinesConstrainerKt.access$getEmptyTextReplacement$p();
        TextStyle r6 = this.resolvedStyle;
        long r7 = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        Density r9 = this.density;
        FontFamily.Resolver r10 = this.fontFamilyResolver;
        TextOverflow.Companion r4 = TextOverflow.Companion;
        float r8 = ParagraphKt.Paragraph-Ul8oQg4$default(r5, r6, r7, r9, r10, null, null, 1, r4.getClip-gIe3tQ8(), 96, null).getHeight();
        float r11 = ParagraphKt.Paragraph-Ul8oQg4$default(MinLinesConstrainerKt.access$getTwoLineTextReplacement$p(), this.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.density, this.fontFamilyResolver, null, null, 2, r4.getClip-gIe3tQ8(), 96, null).getHeight() - r8;
        this.oneLineHeightCache = r8;
        this.lineHeightCache = r11;
        r3 = r11;
        r2 = r8;
    L8:
        if (r21 == 1) goto L10;
        int r1 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Math.round(r2 + (r3 * (r21 - 1))), 0), Constraints.getMaxHeight-impl(r19));
    L12:
        return ConstraintsKt.Constraints(Constraints.getMinWidth-impl(r19), Constraints.getMaxWidth-impl(r19), r1, Constraints.getMaxHeight-impl(r19));
    L10:
        r1 = Constraints.getMinHeight-impl(r19);
        goto L12
    L5:
        if (Float.isNaN(r3) == false) goto L8;
        goto L6
    }

    public MinLinesConstrainer(LayoutDirection r1, TextStyle r2, Density r3, FontFamily.Resolver r4) {
        this.layoutDirection = r1;
        this.inputTextStyle = r2;
        this.density = r3;
        this.fontFamilyResolver = r4;
        this.resolvedStyle = TextStyleKt.resolveDefaults(r2, r1);
        this.lineHeightCache = Float.NaN;
        this.oneLineHeightCache = Float.NaN;
    }
}
