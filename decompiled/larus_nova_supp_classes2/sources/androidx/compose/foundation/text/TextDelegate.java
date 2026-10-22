package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 H2\u00020\u0001:\u0001HBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020/J\u001f\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010<\u001a\u00020/H\u0002¢\u0006\u0004\bA\u0010BJ)\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u00020@2\u0006\u0010<\u001a\u00020/2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bF\u0010GR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b \u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010+R\u0011\u00106\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010\u001cR\u0011\u00108\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b9\u0010\u001c¨\u0006I"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "maxLines", "", "minLines", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IIZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getMaxLines", "()I", "getMinLines", "getSoftWrap", "()Z", "getOverflow-gIe3tQ8", "I", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getPlaceholders", "()Ljava/util/List;", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getParagraphIntrinsics$foundation_release", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "setParagraphIntrinsics$foundation_release", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "nonNullIntrinsics", "getNonNullIntrinsics", "minIntrinsicWidth", "getMinIntrinsicWidth", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "layoutIntrinsics", "", "layoutDirection", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate$Companion;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void paint(Canvas r2, TextLayoutResult r3) {
            TextPainter.INSTANCE.paint(r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TextDelegate(AnnotatedString r1, TextStyle r2, int r3, int r4, boolean r5, int r6, Density r7, FontFamily.Resolver r8, List r9, DefaultConstructorMarker r10) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics r0 = this.paragraphIntrinsics;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    public final int getMaxIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final int getMinIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMinIntrinsicWidth());
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getIntrinsicsLayoutDirection$foundation_release() {
        return this.intrinsicsLayoutDirection;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinLines() {
        return this.minLines;
    }

    /* JADX INFO: renamed from: getOverflow-gIe3tQ8, reason: not valid java name */
    public final int m1445getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final MultiParagraphIntrinsics getParagraphIntrinsics$foundation_release() {
        return this.paragraphIntrinsics;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final void layoutIntrinsics(LayoutDirection r9) {
        MultiParagraphIntrinsics r0 = this.paragraphIntrinsics;
        if (r0 != null) goto L5;
    L8:
        this.intrinsicsLayoutDirection = r9;
        AnnotatedString r3 = this.text;
        TextStyle r4 = TextStyleKt.resolveDefaults(this.style, r9);
        Density r6 = this.density;
        FontFamily.Resolver r7 = this.fontFamilyResolver;
        r0 = new MultiParagraphIntrinsics(r3, r4, this.placeholders, r6, r7);
    L9:
        this.paragraphIntrinsics = r0;
        return;
    L5:
        if (r9 != this.intrinsicsLayoutDirection) goto L8;
        if (r0.getHasStaleResolvedFonts() == false) goto L9;
        goto L8
    }

    public final void setIntrinsicsLayoutDirection$foundation_release(LayoutDirection r1) {
        this.intrinsicsLayoutDirection = r1;
    }

    public final void setParagraphIntrinsics$foundation_release(MultiParagraphIntrinsics r1) {
        this.paragraphIntrinsics = r1;
    }

    /* JADX INFO: renamed from: layoutText-K40F9xA, reason: not valid java name */
    private final MultiParagraph m1444layoutTextK40F9xA(long r11, LayoutDirection r13) {
        layoutIntrinsics(r13);
        int r14 = Constraints.getMinWidth-impl(r11);
        if (this.softWrap == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L13:
        int r1 = Integer.MAX_VALUE;
    L15:
        if (this.softWrap == false) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L22;
        int r7 = 1;
    L23:
        if (r14 == r1) goto L27;
        r1 = RangesKt.coerceIn(getMaxIntrinsicWidth(), r14, r1);
    L27:
        return new MultiParagraph(getNonNullIntrinsics(), Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(0, r1, 0, Constraints.getMaxHeight-impl(r11)), r7, this.overflow, null);
    L22:
        r7 = this.maxLines;
        goto L23
    L17:
        if (TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()) == false) goto L19;
        r3 = true;
        goto L20
    L11:
        if (Constraints.getHasBoundedWidth-impl(r11) == false) goto L13;
        r1 = Constraints.getMaxWidth-impl(r11);
        goto L15
    L5:
        if (TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()) == true) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX INFO: renamed from: layout-NN6Ew-U, reason: not valid java name */
    public final TextLayoutResult m1446layoutNN6EwU(long r22, LayoutDirection r24, TextLayoutResult r25) {
        if (r25 != null) goto L5;
    L8:
        MultiParagraph r0 = m1444layoutTextK40F9xA(r22, r24);
        int r1 = TextDelegateKt.ceilToIntPx(r0.getWidth());
        long r3 = ((long) r1) << 32;
        long r16 = ConstraintsKt.constrain-4WqzIAM(r22, IntSize.constructor-impl((((long) TextDelegateKt.ceilToIntPx(r0.getHeight())) & 4294967295L) | r3));
        return new TextLayoutResult(new TextLayoutInput(this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, r24, this.fontFamilyResolver, r22, null), r0, r16, null);
    L5:
        if (TextLayoutHelperKt.m1477canReuse7_7YC6M(r25, this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, r24, this.fontFamilyResolver, r22) == false) goto L8;
        TextLayoutInput r11 = new TextLayoutInput(r25.getLayoutInput().getText(), this.style, r25.getLayoutInput().getPlaceholders(), r25.getLayoutInput().getMaxLines(), r25.getLayoutInput().getSoftWrap(), r25.getLayoutInput().getOverflow-gIe3tQ8(), r25.getLayoutInput().getDensity(), r25.getLayoutInput().getLayoutDirection(), r25.getLayoutInput().getFontFamilyResolver(), r22, null);
        int r2 = TextDelegateKt.ceilToIntPx(r25.getMultiParagraph().getWidth());
        long r4 = ((long) r2) << 32;
        return r25.copy-O0kMr_c(r11, ConstraintsKt.constrain-4WqzIAM(r22, IntSize.constructor-impl((((long) TextDelegateKt.ceilToIntPx(r25.getMultiParagraph().getHeight())) & 4294967295L) | r4)));
    }

    /* JADX INFO: renamed from: layout-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m1443layoutNN6EwU$default(TextDelegate r0, long r1, LayoutDirection r3, TextLayoutResult r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r0.m1446layoutNN6EwU(r1, r3, r4);
    }

    private TextDelegate(AnnotatedString r1, TextStyle r2, int r3, int r4, boolean r5, int r6, Density r7, FontFamily.Resolver r8, List<AnnotatedString.Range<Placeholder>> r9) {
        this.text = r1;
        this.style = r2;
        this.maxLines = r3;
        this.minLines = r4;
        this.softWrap = r5;
        this.overflow = r6;
        this.density = r7;
        this.fontFamilyResolver = r8;
        this.placeholders = r9;
        boolean r10 = true;
        if (r3 <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("no maxLines");
    L8:
        if (r4 <= 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("no minLines");
    L13:
        if (r4 <= r3) goto L16;
        r10 = false;
    L16:
        if (r10 == true) goto L19;
        InlineClassHelperKt.throwIllegalArgumentException("minLines greater than maxLines");
        return;
    L19:
        return;
    L10:
        r12 = false;
        goto L11
    L5:
        r11 = false;
        goto L6
    }

    public /* synthetic */ TextDelegate(AnnotatedString r14, TextStyle r15, int r16, int r17, boolean r18, int r19, Density r20, FontFamily.Resolver r21, List r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 4) == 0) goto L5;
        int r5 = Integer.MAX_VALUE;
    L7:
        if ((r23 & 8) == 0) goto L9;
        int r6 = 1;
    L11:
        if ((r23 & 16) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((r23 & 32) == 0) goto L17;
        int r8 = TextOverflow.Companion.getClip-gIe3tQ8();
    L19:
        if ((r23 & 256) == 0) goto L21;
        List r11 = CollectionsKt.emptyList();
    L22:
        this(r14, r15, r5, r6, r7, r8, r20, r21, r11, null);
        return;
    L21:
        r11 = r22;
        goto L22
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }
}
