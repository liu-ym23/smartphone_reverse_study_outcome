package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001eBk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002¢\u0006\u0004\bD\u0010?J\u001d\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)¢\u0006\u0004\bI\u0010JJ\u001f\u0010K\u001a\u00020G2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)H\u0002¢\u0006\u0004\bL\u0010MJ'\u00103\u001a\u00020+2\u0006\u0010H\u001a\u00020)2\u0006\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020PH\u0002¢\u0006\u0004\bQ\u0010RJ\u0016\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010H\u001a\u00020)Je\u0010U\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020'2\u0006\u0010H\u001a\u00020)H\u0002J\u001f\u0010Y\u001a\u00020P2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)H\u0002¢\u0006\u0004\bZ\u0010[J%\u0010\\\u001a\u00020\u000b*\u0004\u0018\u00010+2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020)H\u0002¢\u0006\u0004\b]\u0010^J\b\u0010_\u001a\u00020AH\u0002J\b\u0010`\u001a\u00020AH\u0002J\u000e\u0010a\u001a\u00020\r2\u0006\u0010H\u001a\u00020)J\u000e\u0010b\u001a\u00020\r2\u0006\u0010H\u001a\u00020)J\b\u0010c\u001a\u00020dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0018\u00010/R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00100\u001a\u00060/R\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b7\u00105R$\u00108\u001a\u0002098\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "setStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutCache", "Landroidx/compose/ui/text/TextLayoutResult;", "cachedIntrinsicHeightInputWidth", "cachedIntrinsicHeight", "_textAutoSizeLayoutScope", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "fontSizeSearchScope", "getFontSizeSearchScope", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutOrNull", "getLayoutOrNull", "historyFlag", "", "getHistoryFlag$foundation_release$annotations", "()V", "getHistoryFlag$foundation_release", "()J", "setHistoryFlag$foundation_release", "(J)V", "recordHistory", "", "op", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "recordHistory-4ETZmGE", "layoutWithConstraints", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "useMinLinesConstrainer", "useMinLinesConstrainer-Oh53vG4", "(JLandroidx/compose/ui/unit/LayoutDirection;)J", "finalConstraints", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "textLayoutResult-VKLhPVY", "(Landroidx/compose/ui/unit/LayoutDirection;JLandroidx/compose/ui/text/MultiParagraph;)Landroidx/compose/ui/text/TextLayoutResult;", "intrinsicHeight", "width", "update", "update-J2qo7bo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Landroidx/compose/foundation/text/TextAutoSize;)V", "setLayoutDirection", "layoutText", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-VKLhPVY", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "markStyleAffectedDirty", "maxIntrinsicWidth", "minIntrinsicWidth", "toString", "", "TextAutoSizeLayoutScopeImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiParagraphLayoutCache {
    public static final int $stable = 8;
    private TextAutoSizeLayoutScopeImpl _textAutoSizeLayoutScope;
    private TextAutoSize autoSize;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private long historyFlag;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private TextLayoutResult layoutCache;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "<init>", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "lastLayoutResult", "getLastLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "performLayout", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "performLayout-5ZSfY2I", "(JLandroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/TextLayoutResult;", "toPx", "toPx--R2X_6o", "(J)F", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class TextAutoSizeLayoutScopeImpl implements TextAutoSizeLayoutScope {
        private TextLayoutResult lastLayoutResult;
        final /* synthetic */ MultiParagraphLayoutCache this$0;

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public final /* synthetic */ int m1779roundToPxR2X_6o(long r1) {
            return Density.-CC.$default$roundToPx--R2X_6o(this, r1);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public final /* synthetic */ int m1780roundToPx0680j_4(float r1) {
            return Density.-CC.$default$roundToPx-0680j_4(this, r1);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public final /* synthetic */ float m1781toDpGaN1DYA(long r1) {
            return FontScaling.-CC.$default$toDp-GaN1DYA(this, r1);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public final /* synthetic */ float m1782toDpu2uoSUM(float r1) {
            return Density.-CC.$default$toDp-u2uoSUM(this, r1);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public final /* synthetic */ float m1783toDpu2uoSUM(int r1) {
            return Density.-CC.$default$toDp-u2uoSUM(this, r1);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public final /* synthetic */ long m1784toDpSizekrfVVM(long r1) {
            return Density.-CC.$default$toDpSize-k-rfVVM(this, r1);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public final /* synthetic */ float m1786toPx0680j_4(float r1) {
            return Density.-CC.$default$toPx-0680j_4(this, r1);
        }

        public final /* synthetic */ Rect toRect(DpRect r1) {
            return Density.-CC.$default$toRect(this, r1);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public final /* synthetic */ long m1787toSizeXkaWNTQ(long r1) {
            return Density.-CC.$default$toSize-XkaWNTQ(this, r1);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public final /* synthetic */ long m1788toSp0xMU5do(float r3) {
            return FontScaling.-CC.$default$toSp-0xMU5do(this, r3);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public final /* synthetic */ long m1789toSpkPz2Gy4(float r3) {
            return Density.-CC.$default$toSp-kPz2Gy4(this, r3);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public final /* synthetic */ long m1790toSpkPz2Gy4(int r3) {
            return Density.-CC.$default$toSp-kPz2Gy4(this, r3);
        }

        public float getDensity() {
            Density r0 = this.this$0.getDensity$foundation_release();
            Intrinsics.checkNotNull(r0);
            return r0.getDensity();
        }

        public float getFontScale() {
            Density r0 = this.this$0.getDensity$foundation_release();
            Intrinsics.checkNotNull(r0);
            return r0.getFontScale();
        }

        public final TextLayoutResult getLastLayoutResult() {
            return this.lastLayoutResult;
        }

        public TextAutoSizeLayoutScopeImpl(MultiParagraphLayoutCache r1) {
            this.this$0 = r1;
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public float m1785toPxR2X_6o(long r5) {
            if (TextUnit.isEm-impl(r5) == false) goto L15;
            if ((!TextUnit.isEm-impl(MultiParagraphLayoutCache.access$getStyle$p(this.this$0).getFontSize-XSAIIZE())) == false) goto L13;
            if ((!TextUnit.equals-impl0(MultiParagraphLayoutCache.access$getStyle$p(this.this$0).getFontSize-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) == false) goto L11;
            return m1785toPxR2X_6o(MultiParagraphLayoutCache.access$getStyle$p(this.this$0).getFontSize-XSAIIZE()) * TextUnit.getValue-impl(r5);
        L11:
            throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is not set. Please specify a font size.".toString());
        L13:
            throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is Em\nDeclare the composable's style.fontSize with Sp units instead.".toString());
        L15:
            return Density.-CC.$default$toPx-0680j_4(this, FontScaling.-CC.$default$toDp-GaN1DYA(this, r5));
        }

        @Override // androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope
        /* JADX INFO: renamed from: performLayout-5ZSfY2I, reason: not valid java name */
        public TextLayoutResult mo1778performLayout5ZSfY2I(long r37, AnnotatedString r39, long r40) {
            TextStyle r1 = MultiParagraphLayoutCache.access$getStyle$p(this.this$0);
            if (TextUnit.isEm-impl(r40) == false) goto L5;
            long r7 = MultiParagraphLayoutCacheKt.m1791access$timesNB67dxo(MultiParagraphLayoutCache.access$getStyle$p(this.this$0).getFontSize-XSAIIZE(), r40);
        L7:
            if (TextUnit.equals-impl0(r7, MultiParagraphLayoutCache.access$getStyle$p(this.this$0).getFontSize-XSAIIZE()) == true) goto L10;
            MultiParagraphLayoutCache r2 = this.this$0;
            MultiParagraphLayoutCache.access$setStyle(r2, TextStyle.copy-p1EtxEg$default(MultiParagraphLayoutCache.access$getStyle$p(r2), 0, r7, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777213, null));
        L10:
            if (MultiParagraphLayoutCache.access$getMinLines$p(this.this$0) <= 1) goto L12;
            MultiParagraphLayoutCache r3 = this.this$0;
            LayoutDirection r4 = MultiParagraphLayoutCache.access$getIntrinsicsLayoutDirection$p(r3);
            Intrinsics.checkNotNull(r4);
            long r5 = MultiParagraphLayoutCache.m1770access$useMinLinesConstrainerOh53vG4(r3, r37, r4);
        L13:
            MultiParagraphLayoutCache r6 = this.this$0;
            LayoutDirection r8 = MultiParagraphLayoutCache.access$getIntrinsicsLayoutDirection$p(r6);
            Intrinsics.checkNotNull(r8);
            MultiParagraph r9 = MultiParagraphLayoutCache.m1768access$layoutTextK40F9xA(r6, r5, r8);
            MultiParagraphLayoutCache r10 = this.this$0;
            LayoutDirection r11 = MultiParagraphLayoutCache.access$getIntrinsicsLayoutDirection$p(r10);
            Intrinsics.checkNotNull(r11);
            TextLayoutResult r12 = MultiParagraphLayoutCache.m1769access$textLayoutResultVKLhPVY(r10, r11, r5, r9);
            this.lastLayoutResult = r12;
            MultiParagraphLayoutCache.access$setStyle(this.this$0, r1);
            return r12;
        L12:
            r5 = r37;
            goto L13
        L5:
            r7 = r40;
            goto L7
        }
    }

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, List r8, TextAutoSize r9, DefaultConstructorMarker r10) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void getHistoryFlag$foundation_release$annotations() {
    }

    private final void markDirty() {
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
        this._textAutoSizeLayoutScope = null;
    }

    private final TextAutoSizeLayoutScopeImpl getFontSizeSearchScope() {
        if (this._textAutoSizeLayoutScope != null) goto L5;
        this._textAutoSizeLayoutScope = new TextAutoSizeLayoutScopeImpl(this);
    L5:
        TextAutoSizeLayoutScopeImpl r0 = this._textAutoSizeLayoutScope;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    private final void markStyleAffectedDirty() {
        m1773recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1761getMarkDirtyStyleDEKiAbY());
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
    }

    public final TextLayoutResult getTextLayoutResult() {
        TextLayoutResult r0 = this.layoutCache;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Internal Error: MultiParagraphLayoutCache could not provide TextLayoutResult during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: " + this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("MultiParagraphLayoutCache(textLayoutResult=");
        Constraints r2 = "null";
        if (this.layoutCache == null) goto L5;
        String r1 = "<TextLayoutResult>";
    L6:
        r0.append(r1);
        r0.append(", lastDensity=");
        r0.append(InlineDensity.m1748toStringimpl(this.lastDensity));
        r0.append(", history=");
        r0.append(this.historyFlag);
        r0.append(", constraints=");
        TextLayoutResult r3 = this.layoutCache;
        if (r3 == null) goto L11;
        TextLayoutInput r4 = r3.getLayoutInput();
        if (r4 == null) goto L11;
        r2 = Constraints.box-impl(r4.getConstraints-msEJaDk());
    L11:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        r1 = "null";
        goto L6
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final long getHistoryFlag$foundation_release() {
        return this.historyFlag;
    }

    public final TextLayoutResult getLayoutOrNull() {
        return this.layoutCache;
    }

    public static final /* synthetic */ LayoutDirection access$getIntrinsicsLayoutDirection$p(MultiParagraphLayoutCache r0) {
        return r0.intrinsicsLayoutDirection;
    }

    public static final /* synthetic */ int access$getMinLines$p(MultiParagraphLayoutCache r0) {
        return r0.minLines;
    }

    public static final /* synthetic */ TextStyle access$getStyle$p(MultiParagraphLayoutCache r0) {
        return r0.style;
    }

    /* JADX INFO: renamed from: recordHistory-4ETZmGE, reason: not valid java name */
    private final void m1773recordHistory4ETZmGE(long r4) {
        this.historyFlag = r4 | (this.historyFlag << 2);
    }

    private final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection r9) {
        MultiParagraphIntrinsics r0 = this.paragraphIntrinsics;
        if (r0 != null) goto L5;
    L8:
        this.intrinsicsLayoutDirection = r9;
        AnnotatedString r3 = this.text;
        TextStyle r4 = TextStyleKt.resolveDefaults(this.style, r9);
        Density r6 = this.density;
        Intrinsics.checkNotNull(r6);
        FontFamily.Resolver r7 = this.fontFamilyResolver;
        List<AnnotatedString.Range<Placeholder>> r10 = this.placeholders;
        if (r10 != null) goto L11;
        r10 = CollectionsKt.emptyList();
    L11:
        r0 = new MultiParagraphIntrinsics(r3, r4, r10, r6, r7);
    L12:
        this.paragraphIntrinsics = r0;
        return r0;
    L5:
        if (r9 != this.intrinsicsLayoutDirection) goto L8;
        if (r0.getHasStaleResolvedFonts() == false) goto L12;
        goto L8
    }

    private final void setStyle(TextStyle r2) {
        boolean r0 = r2.hasSameLayoutAffectingAttributes(this.style);
        this.style = r2;
        if (r0 == true) goto L6;
        markStyleAffectedDirty();
        return;
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
        m1773recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1759getMarkDirtyDensityDEKiAbY());
        markDirty();
        return;
    L11:
        if (InlineDensity.m1744equalsimpl0(this.lastDensity, r1) == false) goto L12;
        return;
    L5:
        r1 = InlineDensity.Companion.m1750getUnspecifiedL26CHvs();
        goto L6
    }

    public final void setHistoryFlag$foundation_release(long r1) {
        this.historyFlag = r1;
    }

    public static final /* synthetic */ void access$setStyle(MultiParagraphLayoutCache r0, TextStyle r1) {
        r0.setStyle(r1);
    }

    /* JADX INFO: renamed from: layoutText-K40F9xA, reason: not valid java name */
    private final MultiParagraph m1771layoutTextK40F9xA(long r8, LayoutDirection r10) {
        MultiParagraphIntrinsics r1 = setLayoutDirection(r10);
        return new MultiParagraph(r1, LayoutUtilsKt.m1762finalConstraintstfFHcEY(r8, this.softWrap, this.overflow, r1.getMaxIntrinsicWidth()), LayoutUtilsKt.m1763finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), this.overflow, null);
    }

    /* JADX INFO: renamed from: useMinLinesConstrainer-Oh53vG4, reason: not valid java name */
    private final long m1775useMinLinesConstrainerOh53vG4(long r7, LayoutDirection r9) {
        MinLinesConstrainer.Companion r0 = MinLinesConstrainer.Companion;
        MinLinesConstrainer r1 = this.mMinLinesConstrainer;
        TextStyle r3 = this.style;
        Density r4 = this.density;
        Intrinsics.checkNotNull(r4);
        MinLinesConstrainer r10 = r0.from(r1, r9, r3, r4, this.fontFamilyResolver);
        this.mMinLinesConstrainer = r10;
        return r10.m1766coerceMinLinesOh53vG4$foundation_release(r7, this.minLines);
    }

    public final int intrinsicHeight(int r5, LayoutDirection r6) {
        int r0 = this.cachedIntrinsicHeightInputWidth;
        int r1 = this.cachedIntrinsicHeight;
        if (r5 == r0) goto L5;
    L7:
        long r2 = ConstraintsKt.Constraints(0, r5, 0, Integer.MAX_VALUE);
        if (this.minLines <= 1) goto L10;
        r2 = m1775useMinLinesConstrainerOh53vG4(r2, r6);
    L10:
        int r7 = RangesKt.coerceAtLeast(TextDelegateKt.ceilToIntPx(m1771layoutTextK40F9xA(r2, r6).getHeight()), Constraints.getMinHeight-impl(r2));
        this.cachedIntrinsicHeightInputWidth = r5;
        this.cachedIntrinsicHeight = r7;
        return r7;
    L5:
        if (r0 == (-1)) goto L7;
        return r1;
    }

    /* JADX INFO: renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m1776layoutWithConstraintsK40F9xA(long r43, LayoutDirection r45) {
        m1773recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1758getLayoutWithConstraintsDEKiAbY());
        if (this.minLines <= 1) goto L5;
        long r4 = m1775useMinLinesConstrainerOh53vG4(r43, r45);
    L7:
        if (m1772newLayoutWillBeDifferentVKLhPVY(this.layoutCache, r4, r45) == true) goto L15;
        TextLayoutResult r2 = this.layoutCache;
        Intrinsics.checkNotNull(r2);
        if (Constraints.equals-impl0(r4, r2.getLayoutInput().getConstraints-msEJaDk()) == false) goto L12;
        return false;
    L12:
        TextLayoutResult r3 = this.layoutCache;
        Intrinsics.checkNotNull(r3);
        this.layoutCache = m1774textLayoutResultVKLhPVY(r45, r4, r3.getMultiParagraph());
        return true;
    L15:
        if (this.autoSize == null) goto L28;
        this.intrinsicsLayoutDirection = r45;
        long r6 = this.style.getFontSize-XSAIIZE();
        TextAutoSize r5 = this.autoSize;
        Intrinsics.checkNotNull(r5);
        long r8 = r5.mo1339getFontSizeCi0_558(getFontSizeSearchScope(), r43, this.text);
        if (TextUnit.isEm-impl(r8) == false) goto L19;
        r8 = MultiParagraphLayoutCacheKt.m1791access$timesNB67dxo(r6, r8);
    L19:
        long r13 = r8;
        TextLayoutResult r7 = getFontSizeSearchScope().getLastLayoutResult();
        if (r7 != null) goto L22;
    L27:
        setStyle(TextStyle.copy-p1EtxEg$default(this.style, 0, r13, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777213, null));
        goto L28
    L22:
        if (TextUnit.equals-impl0(r13, r7.getLayoutInput().getStyle().getFontSize-XSAIIZE()) == false) goto L27;
        if (TextOverflow.equals-impl0(r7.getLayoutInput().getOverflow-gIe3tQ8(), this.overflow) == false) goto L27;
        this.layoutCache = r7;
        return true;
    L28:
        this.layoutCache = m1774textLayoutResultVKLhPVY(r45, r4, m1771layoutTextK40F9xA(r4, r45));
        return true;
    L5:
        r4 = r43;
        goto L7
    }

    /* JADX INFO: renamed from: access$layoutText-K40F9xA, reason: not valid java name */
    public static final /* synthetic */ MultiParagraph m1768access$layoutTextK40F9xA(MultiParagraphLayoutCache r0, long r1, LayoutDirection r3) {
        return r0.m1771layoutTextK40F9xA(r1, r3);
    }

    /* JADX INFO: renamed from: access$useMinLinesConstrainer-Oh53vG4, reason: not valid java name */
    public static final /* synthetic */ long m1770access$useMinLinesConstrainerOh53vG4(MultiParagraphLayoutCache r0, long r1, LayoutDirection r3) {
        return r0.m1775useMinLinesConstrainerOh53vG4(r1, r3);
    }

    /* JADX INFO: renamed from: newLayoutWillBeDifferent-VKLhPVY, reason: not valid java name */
    private final boolean m1772newLayoutWillBeDifferentVKLhPVY(TextLayoutResult r5, long r6, LayoutDirection r8) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r5.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() == false) goto L9;
        return true;
    L9:
        if (r8 == r5.getLayoutInput().getLayoutDirection()) goto L12;
        return true;
    L12:
        if (Constraints.equals-impl0(r6, r5.getLayoutInput().getConstraints-msEJaDk()) == false) goto L15;
        return false;
    L15:
        if (Constraints.getMaxWidth-impl(r6) == Constraints.getMaxWidth-impl(r5.getLayoutInput().getConstraints-msEJaDk())) goto L18;
        return true;
    L18:
        if (Constraints.getMinWidth-impl(r6) == Constraints.getMinWidth-impl(r5.getLayoutInput().getConstraints-msEJaDk())) goto L21;
        return true;
    L21:
        if (Constraints.getMaxHeight-impl(r6) >= r5.getMultiParagraph().getHeight()) goto L23;
    L26:
        return true;
    L23:
        if (r5.getMultiParagraph().getDidExceedMaxLines() == true) goto L26;
        return false;
    }

    /* JADX INFO: renamed from: textLayoutResult-VKLhPVY, reason: not valid java name */
    private final TextLayoutResult m1774textLayoutResultVKLhPVY(LayoutDirection r23, long r24, MultiParagraph r26) {
        float r1 = Math.min(r26.getIntrinsics().getMaxIntrinsicWidth(), r26.getWidth());
        AnnotatedString r10 = this.text;
        TextStyle r11 = this.style;
        List<AnnotatedString.Range<Placeholder>> r2 = this.placeholders;
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        List<AnnotatedString.Range<Placeholder>> r12 = r2;
        int r13 = this.maxLines;
        boolean r14 = this.softWrap;
        int r15 = this.overflow;
        Density r3 = this.density;
        Intrinsics.checkNotNull(r3);
        TextLayoutInput r4 = new TextLayoutInput(r10, r11, r12, r13, r14, r15, r3, r23, this.fontFamilyResolver, r24, null);
        int r5 = TextDelegateKt.ceilToIntPx(r1);
        long r6 = ((long) r5) << 32;
        return new TextLayoutResult(r4, r26, ConstraintsKt.constrain-4WqzIAM(r24, IntSize.constructor-impl((((long) TextDelegateKt.ceilToIntPx(r26.getHeight())) & 4294967295L) | r6)), null);
    }

    /* JADX INFO: renamed from: access$textLayoutResult-VKLhPVY, reason: not valid java name */
    public static final /* synthetic */ TextLayoutResult m1769access$textLayoutResultVKLhPVY(MultiParagraphLayoutCache r0, LayoutDirection r1, long r2, MultiParagraph r4) {
        return r0.m1774textLayoutResultVKLhPVY(r1, r2, r4);
    }

    private MultiParagraphLayoutCache(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, List<AnnotatedString.Range<Placeholder>> r8, TextAutoSize r9) {
        this.text = r1;
        this.fontFamilyResolver = r3;
        this.overflow = r4;
        this.softWrap = r5;
        this.maxLines = r6;
        this.minLines = r7;
        this.placeholders = r8;
        this.autoSize = r9;
        this.lastDensity = InlineDensity.Companion.m1750getUnspecifiedL26CHvs();
        this.style = r2;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    /* JADX INFO: renamed from: update-J2qo7bo, reason: not valid java name */
    public final void m1777updateJ2qo7bo(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, List<AnnotatedString.Range<Placeholder>> r8, TextAutoSize r9) {
        this.text = r1;
        setStyle(r2);
        this.fontFamilyResolver = r3;
        this.overflow = r4;
        this.softWrap = r5;
        this.maxLines = r6;
        this.minLines = r7;
        this.placeholders = r8;
        this.autoSize = r9;
        m1773recordHistory4ETZmGE(LayoutCacheOperation.Companion.m1760getMarkDirtyNodeDEKiAbY());
        markDirty();
    }

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString r14, TextStyle r15, FontFamily.Resolver r16, int r17, boolean r18, int r19, int r20, List r21, TextAutoSize r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 8) == 0) goto L5;
        int r6 = TextOverflow.Companion.getClip-gIe3tQ8();
    L7:
        if ((r23 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r23 & 32) == 0) goto L13;
        int r8 = Integer.MAX_VALUE;
    L15:
        if ((r23 & 64) == 0) goto L17;
        int r9 = 1;
    L19:
        if ((r23 & 128) == 0) goto L21;
        List r10 = null;
    L23:
        if ((r23 & 256) == 0) goto L25;
        TextAutoSize r11 = null;
    L26:
        this(r14, r15, r16, r6, r7, r8, r9, r10, r11, null);
        return;
    L25:
        r11 = r22;
        goto L26
    L21:
        r10 = r21;
        goto L23
    L17:
        r9 = r20;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }
}
