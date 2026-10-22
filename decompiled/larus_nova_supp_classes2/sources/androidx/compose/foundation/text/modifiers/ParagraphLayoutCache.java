package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020CH\u0002¢\u0006\u0004\bD\u00100J\u001d\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u0002082\u0006\u0010G\u001a\u000206¢\u0006\u0004\bH\u0010IJ)\u0010J\u001a\u0002082\u0006\u0010F\u001a\u0002082\u0006\u0010G\u001a\u0002062\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0004\bK\u0010LJ\u0016\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\r2\u0006\u0010G\u001a\u000206JE\u0010O\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u0002042\u0006\u0010G\u001a\u000206H\u0002J\u001f\u0010S\u001a\u00020!2\u0006\u0010F\u001a\u0002082\u0006\u0010G\u001a\u000206H\u0000¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020\u000b2\u0006\u0010F\u001a\u0002082\u0006\u0010G\u001a\u000206H\u0002¢\u0006\u0004\bW\u0010IJ\b\u0010X\u001a\u00020\u001dH\u0002J\u0010\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010[\u001a\u00020\r2\u0006\u0010G\u001a\u000206J\u000e\u0010\\\u001a\u00020\r2\u0006\u0010G\u001a\u000206J\b\u0010]\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u00020,X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020<8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010.\"\u0004\b@\u00100¨\u0006^"}, d2 = {"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "observeFontChanges", "", "getObserveFontChanges$foundation_release", "()Lkotlin/Unit;", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation_release", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation_release", "(Landroidx/compose/ui/text/Paragraph;)V", "didOverflow", "getDidOverflow$foundation_release", "()Z", "setDidOverflow$foundation_release", "(Z)V", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "getLayoutSize-YbymL2g$foundation_release", "()J", "setLayoutSize-ozmzZPI$foundation_release", "(J)V", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevConstraints", "Landroidx/compose/ui/unit/Constraints;", "cachedIntrinsicHeightInputWidth", "cachedIntrinsicHeight", "historyFlag", "", "getHistoryFlag$foundation_release$annotations", "()V", "getHistoryFlag$foundation_release", "setHistoryFlag$foundation_release", "recordHistory", "op", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "recordHistory-4ETZmGE", "layoutWithConstraints", "constraints", "layoutDirection", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "useMinLinesConstrainer", "useMinLinesConstrainer-euUD3Qg", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;)J", "intrinsicHeight", "width", "update", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "setLayoutDirection", "layoutText", "layoutText-K40F9xA$foundation_release", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-K40F9xA", "markDirty", "slowCreateTextLayoutResultOrNull", "Landroidx/compose/ui/text/TextLayoutResult;", "minIntrinsicWidth", "maxIntrinsicWidth", "toString", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParagraphLayoutCache {
    public static final int $stable = 8;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private long historyFlag;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ ParagraphLayoutCache(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, DefaultConstructorMarker r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void getHistoryFlag$foundation_release$annotations() {
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.Companion.fixed-JhjzzOo(0, 0);
        long r2 = 0;
        this.layoutSize = IntSize.constructor-impl((r2 & 4294967295L) | (r2 << 32));
        this.didOverflow = false;
    }

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics r0 = this.paragraphIntrinsics;
        if (r0 == null) goto L6;
        r0.getHasStaleResolvedFonts();
    L6:
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ParagraphLayoutCache(paragraph=");
        if (this.paragraph == null) goto L5;
        String r1 = "<paragraph>";
    L6:
        r0.append(r1);
        r0.append(", lastDensity=");
        r0.append(InlineDensity.m1748toStringimpl(this.lastDensity));
        r0.append(", history=");
        r0.append(this.historyFlag);
        r0.append(", constraints=$)");
        return r0.toString();
    L5:
        r1 = "null";
        goto L6
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final boolean getDidOverflow$foundation_release() {
        return this.didOverflow;
    }

    public final long getHistoryFlag$foundation_release() {
        return this.historyFlag;
    }

    /* JADX INFO: renamed from: getLayoutSize-YbymL2g$foundation_release, reason: not valid java name */
    public final long m1797getLayoutSizeYbymL2g$foundation_release() {
        return this.layoutSize;
    }

    public final Paragraph getParagraph$foundation_release() {
        return this.paragraph;
    }

    /* JADX INFO: renamed from: recordHistory-4ETZmGE, reason: not valid java name */
    private final void m1794recordHistory4ETZmGE(long r4) {
        this.historyFlag = r4 | (this.historyFlag << 2);
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection r9) {
        ParagraphIntrinsics r0 = this.paragraphIntrinsics;
        if (r0 != null) goto L5;
    L8:
        this.intrinsicsLayoutDirection = r9;
        String r2 = this.text;
        TextStyle r3 = TextStyleKt.resolveDefaults(this.style, r9);
        List r4 = CollectionsKt.emptyList();
        Density r5 = this.density;
        Intrinsics.checkNotNull(r5);
        r0 = ParagraphIntrinsicsKt.ParagraphIntrinsics(r2, r3, r4, r5, this.fontFamilyResolver, CollectionsKt.emptyList());
    L9:
        this.paragraphIntrinsics = r0;
        return r0;
    L5:
        if (r9 != this.intrinsicsLayoutDirection) goto L8;
        if (r0.getHasStaleResolvedFonts() == false) goto L9;
        goto L8
    }

    public final int maxIntrinsicWidth(LayoutDirection r1) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(r1).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection r1) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(r1).getMinIntrinsicWidth());
    }

    public final void setDensity$foundation_release(Density r6) {
        Density r0 = this.density;
        if (r6 == null) goto L5;
        long r1 = InlineDensity.m1742constructorimpl(r6);
    L6:
        if (r0 != null) goto L9;
        this.density = r6;
        this.lastDensity = r1;
        return;
    L9:
        if (r6 != null) goto L11;
    L12:
        this.density = r6;
        this.lastDensity = r1;
        m1794recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1759getMarkDirtyDensityDEKiAbY());
        markDirty();
        return;
    L11:
        if (InlineDensity.m1744equalsimpl0(this.lastDensity, r1) == false) goto L12;
        return;
    L5:
        r1 = InlineDensity.Companion.m1750getUnspecifiedL26CHvs();
        goto L6
    }

    public final void setDidOverflow$foundation_release(boolean r1) {
        this.didOverflow = r1;
    }

    public final void setHistoryFlag$foundation_release(long r1) {
        this.historyFlag = r1;
    }

    /* JADX INFO: renamed from: setLayoutSize-ozmzZPI$foundation_release, reason: not valid java name */
    public final void m1800setLayoutSizeozmzZPI$foundation_release(long r1) {
        this.layoutSize = r1;
    }

    public final void setParagraph$foundation_release(Paragraph r1) {
        this.paragraph = r1;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull(TextStyle r26) {
        LayoutDirection r9 = this.intrinsicsLayoutDirection;
        if (r9 != null) goto L5;
        return null;
    L5:
        Density r14 = this.density;
        if (r14 != null) goto L8;
        return null;
    L8:
        AnnotatedString r15 = new AnnotatedString(this.text, null, 2, null);
        if (this.paragraph != null) goto L12;
        return null;
    L12:
        if (this.paragraphIntrinsics != null) goto L14;
        return null;
    L14:
        long r18 = Constraints.constructor-impl(this.prevConstraints & (-8589934589L));
        return new TextLayoutResult(new TextLayoutInput(r15, r26, CollectionsKt.emptyList(), this.maxLines, this.softWrap, this.overflow, r14, r9, this.fontFamilyResolver, r18, null), new MultiParagraph(new MultiParagraphIntrinsics(r15, r26, CollectionsKt.emptyList(), r14, this.fontFamilyResolver), r18, this.maxLines, this.overflow, null), this.layoutSize, null);
    }

    /* JADX INFO: renamed from: newLayoutWillBeDifferent-K40F9xA, reason: not valid java name */
    private final boolean m1793newLayoutWillBeDifferentK40F9xA(long r6, LayoutDirection r8) {
        Paragraph r0 = this.paragraph;
        if (r0 != null) goto L5;
        return true;
    L5:
        ParagraphIntrinsics r2 = this.paragraphIntrinsics;
        if (r2 != null) goto L9;
        return true;
    L9:
        if (r2.getHasStaleResolvedFonts() == false) goto L12;
        return true;
    L12:
        if (r8 == this.intrinsicsLayoutDirection) goto L15;
        return true;
    L15:
        if (Constraints.equals-impl0(r6, this.prevConstraints) == false) goto L18;
        return false;
    L18:
        if (Constraints.getMaxWidth-impl(r6) == Constraints.getMaxWidth-impl(this.prevConstraints)) goto L21;
        return true;
    L21:
        if (Constraints.getMinWidth-impl(r6) == Constraints.getMinWidth-impl(this.prevConstraints)) goto L24;
        return true;
    L24:
        if (Constraints.getMaxHeight-impl(r6) >= r0.getHeight()) goto L26;
    L29:
        return true;
    L26:
        if (r0.getDidExceedMaxLines() == true) goto L29;
        return false;
    }

    public final int intrinsicHeight(int r10, LayoutDirection r11) {
        int r0 = this.cachedIntrinsicHeightInputWidth;
        int r1 = this.cachedIntrinsicHeight;
        if (r10 == r0) goto L5;
    L7:
        long r3 = ConstraintsKt.Constraints(0, r10, 0, Integer.MAX_VALUE);
        if (this.minLines <= 1) goto L10;
        r3 = m1796useMinLinesConstrainereuUD3Qg$default(this, r3, r11, null, 4, null);
    L10:
        int r12 = RangesKt.coerceAtLeast(TextDelegateKt.ceilToIntPx(m1798layoutTextK40F9xA$foundation_release(r3, r11).getHeight()), Constraints.getMinHeight-impl(r3));
        this.cachedIntrinsicHeightInputWidth = r10;
        this.cachedIntrinsicHeight = r12;
        return r12;
    L5:
        if (r0 == (-1)) goto L7;
        return r1;
    }

    /* JADX INFO: renamed from: layoutText-K40F9xA$foundation_release, reason: not valid java name */
    public final Paragraph m1798layoutTextK40F9xA$foundation_release(long r4, LayoutDirection r6) {
        ParagraphIntrinsics r7 = setLayoutDirection(r6);
        return ParagraphKt.Paragraph-czeN-Hc(r7, LayoutUtilsKt.m1762finalConstraintstfFHcEY(r4, this.softWrap, this.overflow, r7.getMaxIntrinsicWidth()), LayoutUtilsKt.m1763finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), this.overflow);
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m1799layoutWithConstraintsK40F9xA(long r12, LayoutDirection r14) {
        m1794recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1758getLayoutWithConstraintsDEKiAbY());
        boolean r1 = true;
        if (this.minLines <= 1) goto L5;
        r12 = m1796useMinLinesConstrainereuUD3Qg$default(this, r12, r14, null, 4, null);
    L5:
        boolean r2 = false;
        if (m1793newLayoutWillBeDifferentK40F9xA(r12, r14) == false) goto L8;
        Paragraph r15 = m1798layoutTextK40F9xA$foundation_release(r12, r14);
        this.prevConstraints = r12;
        long r13 = ConstraintsKt.constrain-4WqzIAM(r12, IntSize.constructor-impl((((long) TextDelegateKt.ceilToIntPx(r15.getWidth())) << 32) | (((long) TextDelegateKt.ceilToIntPx(r15.getHeight())) & 4294967295L)));
        this.layoutSize = r13;
        if (TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getVisible-gIe3tQ8()) == false) goto L22;
    L26:
        this.didOverflow = r2;
        this.paragraph = r15;
        return true;
    L22:
        if (((int) (r13 >> 32)) >= r15.getWidth()) goto L24;
    L25:
        r2 = true;
        goto L26
    L24:
        if (((int) (r13 & 4294967295L)) >= r15.getHeight()) goto L26;
    L8:
        if (Constraints.equals-impl0(r12, this.prevConstraints) == true) goto L18;
        Paragraph r16 = this.paragraph;
        Intrinsics.checkNotNull(r16);
        long r6 = ConstraintsKt.constrain-4WqzIAM(r12, IntSize.constructor-impl((((long) TextDelegateKt.ceilToIntPx(Math.min(r16.getMaxIntrinsicWidth(), r16.getWidth()))) << 32) | (((long) TextDelegateKt.ceilToIntPx(r16.getHeight())) & 4294967295L)));
        this.layoutSize = r6;
        if (TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getVisible-gIe3tQ8()) == false) goto L12;
    L16:
        r1 = false;
    L17:
        this.didOverflow = r1;
        this.prevConstraints = r12;
        goto L18
    L12:
        if (((int) (r6 >> 32)) < r16.getWidth()) goto L17;
        if (((int) (4294967295L & r6)) >= r16.getHeight()) goto L16;
    L18:
        return false;
    }

    /* JADX INFO: renamed from: useMinLinesConstrainer-euUD3Qg, reason: not valid java name */
    private final long m1795useMinLinesConstrainereuUD3Qg(long r7, LayoutDirection r9, TextStyle r10) {
        MinLinesConstrainer.Companion r0 = MinLinesConstrainer.Companion;
        MinLinesConstrainer r1 = this.mMinLinesConstrainer;
        Density r4 = this.density;
        Intrinsics.checkNotNull(r4);
        MinLinesConstrainer r11 = r0.from(r1, r9, r10, r4, this.fontFamilyResolver);
        this.mMinLinesConstrainer = r11;
        return r11.m1766coerceMinLinesOh53vG4$foundation_release(r7, this.minLines);
    }

    /* JADX INFO: renamed from: useMinLinesConstrainer-euUD3Qg$default, reason: not valid java name */
    public static /* synthetic */ long m1796useMinLinesConstrainereuUD3Qg$default(ParagraphLayoutCache r0, long r1, LayoutDirection r3, TextStyle r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = r0.style;
    L6:
        return r0.m1795useMinLinesConstrainereuUD3Qg(r1, r3, r4);
    }

    private ParagraphLayoutCache(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7) {
        this.text = r1;
        this.style = r2;
        this.fontFamilyResolver = r3;
        this.overflow = r4;
        this.softWrap = r5;
        this.maxLines = r6;
        this.minLines = r7;
        this.lastDensity = InlineDensity.Companion.m1750getUnspecifiedL26CHvs();
        long r8 = 0;
        this.layoutSize = IntSize.constructor-impl((r8 & 4294967295L) | (r8 << 32));
        this.prevConstraints = Constraints.Companion.fixed-JhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    /* JADX INFO: renamed from: update-L6sJoHM, reason: not valid java name */
    public final void m1801updateL6sJoHM(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7) {
        this.text = r1;
        this.style = r2;
        this.fontFamilyResolver = r3;
        this.overflow = r4;
        this.softWrap = r5;
        this.maxLines = r6;
        this.minLines = r7;
        m1794recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1760getMarkDirtyNodeDEKiAbY());
        markDirty();
    }

    public /* synthetic */ ParagraphLayoutCache(String r11, TextStyle r12, FontFamily.Resolver r13, int r14, boolean r15, int r16, int r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 8) == 0) goto L5;
        int r5 = TextOverflow.Companion.getClip-gIe3tQ8();
    L7:
        if ((r18 & 16) == 0) goto L9;
        boolean r6 = true;
    L11:
        if ((r18 & 32) == 0) goto L13;
        int r7 = Integer.MAX_VALUE;
    L15:
        if ((r18 & 64) == 0) goto L17;
        int r8 = 1;
    L18:
        this(r11, r12, r13, r5, r6, r7, r8, null);
        return;
    L17:
        r8 = r17;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
