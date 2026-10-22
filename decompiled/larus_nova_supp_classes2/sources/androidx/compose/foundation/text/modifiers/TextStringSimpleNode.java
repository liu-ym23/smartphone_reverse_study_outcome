package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001PBS\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\f\u0010$\u001a\u00020 *\u00020%H\u0002J\r\u0010\"\u001a\u00020 H\u0003¢\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J=\u0010*\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b+\u0010,J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000eJ\u0010\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u0006H\u0002J\b\u0010:\u001a\u00020.H\u0002J\f\u0010;\u001a\u00020.*\u00020<H\u0016J\b\u0010=\u001a\u00020.H\u0002J#\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u001c\u0010G\u001a\u00020\u0010*\u00020%2\u0006\u0010A\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0010H\u0016J\u001c\u0010J\u001a\u00020\u0010*\u00020%2\u0006\u0010A\u001a\u00020H2\u0006\u0010K\u001a\u00020\u0010H\u0016J\u001c\u0010L\u001a\u00020\u0010*\u00020%2\u0006\u0010A\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0010H\u0016J\u001c\u0010M\u001a\u00020\u0010*\u00020%2\u0006\u0010A\u001a\u00020H2\u0006\u0010K\u001a\u00020\u0010H\u0016J\f\u0010N\u001a\u00020.*\u00020OH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\"\u00102\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020504\u0012\u0004\u0012\u00020\u000e\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "getLayoutCacheForMeasure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "getLayoutCacheOrSubstitute", "updateDraw", "color", "updateText", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-HuAbxIM", "(Landroidx/compose/ui/text/TextStyle;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "doInvalidations", "", "drawChanged", "textChanged", "layoutChanged", "semanticsTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "textSubstitution", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "setSubstitution", "updatedText", "clearSubstitution", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invalidateForTranslate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private ParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    private ColorProducer overrideColor;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private String text;
    private TextSubstitutionValue textSubstitution;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0017\u001a\u00020\u0003H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode$TextSubstitutionValue;", "", "original", "", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "getOriginal", "()Ljava/lang/String;", "getSubstitution", "setSubstitution", "(Ljava/lang/String;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private ParagraphLayoutCache layoutCache;
        private final String original;
        private String substitution;

        public static /* synthetic */ TextSubstitutionValue copy$default(TextSubstitutionValue r0, String r1, String r2, boolean r3, ParagraphLayoutCache r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.original;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.substitution;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.isShowingSubstitution;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.layoutCache;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.original;
        }

        public final String component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final ParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(String r2, String r3, boolean r4, ParagraphLayoutCache r5) {
            return new TextSubstitutionValue(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TextSubstitutionValue) == true) goto L8;
            return false;
        L8:
            TextSubstitutionValue r6 = (TextSubstitutionValue) r5;
            if (Intrinsics.areEqual(this.original, r6.original) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.substitution, r6.substitution) == true) goto L15;
            return false;
        L15:
            if (this.isShowingSubstitution == r6.isShowingSubstitution) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.layoutCache, r6.layoutCache) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.original.hashCode() * 31) + this.substitution.hashCode()) * 31;
            if (this.isShowingSubstitution == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            ParagraphLayoutCache r3 = this.layoutCache;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            return "TextSubstitution(layoutCache=" + this.layoutCache + ", isShowingSubstitution=" + this.isShowingSubstitution + ')';
        }

        public final ParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final String getOriginal() {
            return this.original;
        }

        public final String getSubstitution() {
            return this.substitution;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(ParagraphLayoutCache r1) {
            this.layoutCache = r1;
        }

        public final void setShowingSubstitution(boolean r1) {
            this.isShowingSubstitution = r1;
        }

        public final void setSubstitution(String r1) {
            this.substitution = r1;
        }

        public TextSubstitutionValue(String r1, String r2, boolean r3, ParagraphLayoutCache r4) {
            this.original = r1;
            this.substitution = r2;
            this.isShowingSubstitution = r3;
            this.layoutCache = r4;
        }

        public /* synthetic */ TextSubstitutionValue(String r1, String r2, boolean r3, ParagraphLayoutCache r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = null;
        L8:
            this(r1, r2, r3, r4);
        }
    }

    public /* synthetic */ TextStringSimpleNode(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, ColorProducer r8, DefaultConstructorMarker r9) {
        this(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ boolean a(TextStringSimpleNode r0, AnnotatedString r1) {
        return applySemantics$lambda$3(r0, r1);
    }

    public static /* synthetic */ boolean b(TextStringSimpleNode r0) {
        return applySemantics$lambda$5(r0);
    }

    public static /* synthetic */ Unit c(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$7$lambda$6(r0, r1);
    }

    private final void clearSubstitution() {
        this.textSubstitution = null;
    }

    public static /* synthetic */ boolean d(TextStringSimpleNode r0, boolean r1) {
        return applySemantics$lambda$4(r0, r1);
    }

    public static /* synthetic */ boolean e(TextStringSimpleNode r0, List r1) {
        return applySemantics$lambda$2(r0, r1);
    }

    private static /* synthetic */ void getBaselineCache$annotations() {
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldClearDescendantSemantics(this);
    }

    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.-CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public final /* synthetic */ boolean isImportantForBounds() {
        return SemanticsModifierNode.-CC.$default$isImportantForBounds(this);
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    private final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache != null) goto L5;
        this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
    L5:
        ParagraphLayoutCache r0 = this._layoutCache;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    private final ParagraphLayoutCache getLayoutCacheOrSubstitute() {
        TextSubstitutionValue r0 = this.textSubstitution;
        if (r0 == null) goto L12;
        if (r0.isShowingSubstitution() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        ParagraphLayoutCache r1 = r0.getLayoutCache();
        if (r1 == null) goto L12;
        return r1;
    L12:
        return getLayoutCache();
    }

    private final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private static final boolean applySemantics$lambda$5(TextStringSimpleNode r0) {
        r0.clearSubstitution();
        r0.invalidateForTranslate();
        return true;
    }

    private final ParagraphLayoutCache getLayoutCacheForMeasure(IntrinsicMeasureScope r2) {
        ParagraphLayoutCache r0 = getLayoutCacheOrSubstitute();
        r0.setDensity$foundation_release(r2);
        return r0;
    }

    private final boolean setSubstitution(String r13) {
        TextSubstitutionValue r0 = this.textSubstitution;
        if (r0 != null) goto L5;
        TextSubstitutionValue r9 = new TextSubstitutionValue(this.text, r13, false, null, 12, null);
        ParagraphLayoutCache r10 = new ParagraphLayoutCache(r13, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
        r10.setDensity$foundation_release(getLayoutCache().getDensity$foundation_release());
        r9.setLayoutCache(r10);
        this.textSubstitution = r9;
        return true;
    L5:
        if (Intrinsics.areEqual(r13, r0.getSubstitution()) == false) goto L7;
        return false;
    L7:
        r0.setSubstitution(r13);
        ParagraphLayoutCache r1 = r0.getLayoutCache();
        if (r1 == null) goto L10;
        r1.m1801updateL6sJoHM(r13, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        return true;
    L10:
        return false;
    }

    public void applySemantics(SemanticsPropertyReceiver r6) {
        Function1<? super List<TextLayoutResult>, Boolean> r0 = this.semanticsTextLayoutResult;
        if (r0 != null) goto L5;
        r0 = new j(this);
        this.semanticsTextLayoutResult = r0;
    L5:
        SemanticsPropertiesKt.setText(r6, new AnnotatedString(this.text, null, 2, null));
        TextSubstitutionValue r1 = this.textSubstitution;
        if (r1 == null) goto L8;
        SemanticsPropertiesKt.setShowingTextSubstitution(r6, r1.isShowingSubstitution());
        SemanticsPropertiesKt.setTextSubstitution(r6, new AnnotatedString(r1.getSubstitution(), null, 2, null));
    L8:
        SemanticsPropertiesKt.setTextSubstitution$default(r6, null, new k(this), 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default(r6, null, new l(this), 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default(r6, null, new m(this), 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(r6, null, r0, 1, null);
    }

    public void draw(ContentDrawScope r13) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        ParagraphLayoutCache r0 = getLayoutCacheOrSubstitute();
        Paragraph r1 = r0.getParagraph$foundation_release();
        if (r1 == null) goto L47;
        Canvas r14 = r13.getDrawContext().getCanvas();
        boolean r11 = r0.getDidOverflow$foundation_release();
        if (r11 == false) goto L49;
        float r5 = (int) (r0.m1797getLayoutSizeYbymL2g$foundation_release() >> 32);
        float r6 = (int) (r0.m1797getLayoutSizeYbymL2g$foundation_release() & 4294967295L);
        r14.save();
        Canvas.-CC.clipRect-N_I0leg$default(r14, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r5, r6, 0, 16, null);
    L49:
        TextDecoration r2 = this.style.getTextDecoration();     // Catch: Throwable -> L43
        if (r2 != null) goto L13;
        r2 = TextDecoration.Companion.getNone();     // Catch: Throwable -> L43
    L13:
        TextDecoration r7 = r2;
        Shadow r3 = this.style.getShadow();     // Catch: Throwable -> L43
        if (r3 != null) goto L16;
        r3 = Shadow.Companion.getNone();     // Catch: Throwable -> L43
    L16:
        Shadow r8 = r3;
        Fill r4 = this.style.getDrawStyle();     // Catch: Throwable -> L43
        if (r4 != null) goto L19;
        r4 = Fill.INSTANCE;     // Catch: Throwable -> L43
    L19:
        Fill r9 = r4;
        Brush r10 = this.style.getBrush();     // Catch: Throwable -> L43
        if (r10 == null) goto L22;
        Paragraph.-CC.paint-hn5TExg$default(r1, r14, r10, this.style.getAlpha(), r8, r7, r9, 0, 64, null);     // Catch: Throwable -> L43
    L40:
        if (r11 == false) goto L50;
        r14.restore();
        return;
    L50:
        return;
    L22:
        ColorProducer r12 = this.overrideColor;     // Catch: Throwable -> L43
        if (r12 == null) goto L25;
        long r15 = r12.invoke-0d7_KjU();     // Catch: Throwable -> L43
    L26:
        boolean r16 = true;
        if (r15 == 16) goto L29;
        boolean r17 = true;
    L30:
        if (r17 == false) goto L33;
    L39:
        Paragraph.-CC.paint-LG529CI$default(r1, r14, r15, r8, r7, r9, 0, 32, null);     // Catch: Throwable -> L43
        goto L40
    L33:
        if (this.style.getColor-0d7_KjU() != 16) goto L36;
        r16 = false;
    L36:
        if (r16 == false) goto L38;
        r15 = this.style.getColor-0d7_KjU();     // Catch: Throwable -> L43
        goto L39
    L38:
        r15 = Color.Companion.getBlack-0d7_KjU();     // Catch: Throwable -> L43
        goto L39
    L29:
        r17 = false;
        goto L30
    L25:
        r15 = Color.Companion.getUnspecified-0d7_KjU();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r11 == false) goto L46;
        r14.restore();
    L46:
        throw th;
    L47:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Internal Error: ParagraphLayoutCache could not provide a Paragraph during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: (layoutCache=" + this._layoutCache + ", textSubstitution=" + this.textSubstitution + ')');
        throw new KotlinNothingValueException();
    }

    public final boolean updateText(String r2) {
        if (Intrinsics.areEqual(this.text, r2) == false) goto L6;
        return false;
    L6:
        this.text = r2;
        clearSubstitution();
        return true;
    }

    private static final boolean applySemantics$lambda$2(TextStringSimpleNode r34, List r35) {
        ParagraphLayoutCache r1 = r34.getLayoutCache();
        TextStyle r2 = r34.style;
        ColorProducer r0 = r34.overrideColor;
        if (r0 == null) goto L5;
        long r3 = r0.invoke-0d7_KjU();
    L6:
        TextLayoutResult r4 = r1.slowCreateTextLayoutResultOrNull(TextStyle.merge-dA7vx0o$default(r2, r3, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, 0, 0, null, null, 16777214, null));
        if (r4 == null) goto L9;
        r35.add(r4);
    L10:
        if (r4 == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = Color.Companion.getUnspecified-0d7_KjU();
        goto L6
    }

    private static final boolean applySemantics$lambda$3(TextStringSimpleNode r0, AnnotatedString r1) {
        r0.setSubstitution(r1.getText());
        r0.invalidateForTranslate();
        return true;
    }

    private static final boolean applySemantics$lambda$4(TextStringSimpleNode r1, boolean r2) {
        TextSubstitutionValue r0 = r1.textSubstitution;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0 == null) goto L8;
        r0.setShowingSubstitution(r2);
    L8:
        r1.invalidateForTranslate();
        return true;
    }

    private static final Unit measure_3p2s80s$lambda$7$lambda$6(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public final boolean updateDraw(ColorProducer r3, TextStyle r4) {
        boolean r0 = !Intrinsics.areEqual(r3, this.overrideColor);
        this.overrideColor = r3;
        if (r0 == false) goto L5;
        return true;
    L5:
        if (r4.hasSameDrawAffectingAttributes(this.style) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public final void doInvalidations(boolean r9, boolean r10, boolean r11) {
        if (r10 == true) goto L4;
        if (r11 == true) goto L4;
    L6:
        if (isAttached() == true) goto L8;
        return;
    L8:
        if (r10 == true) goto L12;
        if (r9 == true) goto L11;
    L13:
        if (r10 == true) goto L15;
        if (r11 == true) goto L15;
    L16:
        if (r9 == false) goto L19;
        DrawModifierNodeKt.invalidateDraw(this);
        return;
    L19:
        return;
    L15:
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
        goto L16
    L11:
        if (this.semanticsTextLayoutResult == null) goto L13;
    L12:
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L4:
        getLayoutCache().m1801updateL6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
        goto L6
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCacheForMeasure(r1).intrinsicHeight(r3, r1.getLayoutDirection());
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCacheForMeasure(r1).maxIntrinsicWidth(r1.getLayoutDirection());
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1822measure3p2s80s(MeasureScope r5, Measurable r6, long r7) {
        Trace.beginSection("TextStringSimpleNode::measure");
        ParagraphLayoutCache r0 = getLayoutCacheForMeasure(r5);     // Catch: Throwable -> L12
        boolean r8 = r0.m1799layoutWithConstraintsK40F9xA(r7, r5.getLayoutDirection());     // Catch: Throwable -> L12
        r0.getObserveFontChanges$foundation_release();     // Catch: Throwable -> L12
        Paragraph r9 = r0.getParagraph$foundation_release();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L12
        long r1 = r0.m1797getLayoutSizeYbymL2g$foundation_release();     // Catch: Throwable -> L12
        if (r8 == false) goto L9;
        LayoutModifierNodeKt.invalidateLayer(this);     // Catch: Throwable -> L12
        Map r10 = this.baselineCache;     // Catch: Throwable -> L12
        if (r10 != null) goto L8;
        r10 = new HashMap(2);     // Catch: Throwable -> L12
        this.baselineCache = r10;     // Catch: Throwable -> L12
    L8:
        r10.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(r9.getFirstBaseline())));     // Catch: Throwable -> L12
        r10.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(r9.getLastBaseline())));     // Catch: Throwable -> L12
    L9:
        int r11 = (int) (r1 >> 32);     // Catch: Throwable -> L12
        int r2 = (int) (r1 & 4294967295L);     // Catch: Throwable -> L12
        final Placeable r12 = r6.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(r11, r11, r2, r2));     // Catch: Throwable -> L12
        Map<AlignmentLine, Integer> r13 = this.baselineCache;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L12
        MeasureResult r14 = r5.layout(r11, r2, r13, new i(r12));     // Catch: Throwable -> L12
        Trace.endSection();
        return r14;
    L12:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCacheForMeasure(r1).intrinsicHeight(r3, r1.getLayoutDirection());
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCacheForMeasure(r1).minIntrinsicWidth(r1.getLayoutDirection());
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-HuAbxIM, reason: not valid java name */
    public final boolean m1823updateLayoutRelatedArgsHuAbxIM(TextStyle r3, int r4, int r5, boolean r6, FontFamily.Resolver r7, int r8) {
        boolean r0 = !this.style.hasSameLayoutAffectingAttributes(r3);
        this.style = r3;
        if (this.minLines == r4) goto L6;
        this.minLines = r4;
        r0 = true;
    L6:
        if (this.maxLines == r5) goto L9;
        this.maxLines = r5;
        r0 = true;
    L9:
        if (this.softWrap == r6) goto L12;
        this.softWrap = r6;
        r0 = true;
    L12:
        if (Intrinsics.areEqual(this.fontFamilyResolver, r7) == true) goto L15;
        this.fontFamilyResolver = r7;
        r0 = true;
    L15:
        if (TextOverflow.equals-impl0(this.overflow, r8) == true) goto L18;
        this.overflow = r8;
        return true;
    L18:
        return r0;
    }

    private TextStringSimpleNode(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, ColorProducer r8) {
        this.text = r1;
        this.style = r2;
        this.fontFamilyResolver = r3;
        this.overflow = r4;
        this.softWrap = r5;
        this.maxLines = r6;
        this.minLines = r7;
        this.overrideColor = r8;
    }

    public /* synthetic */ TextStringSimpleNode(String r13, TextStyle r14, FontFamily.Resolver r15, int r16, boolean r17, int r18, int r19, ColorProducer r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 8) == 0) goto L5;
        int r6 = TextOverflow.Companion.getClip-gIe3tQ8();
    L7:
        if ((r21 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r21 & 32) == 0) goto L13;
        int r8 = Integer.MAX_VALUE;
    L15:
        if ((r21 & 64) == 0) goto L17;
        int r9 = 1;
    L19:
        if ((r21 & 128) == 0) goto L21;
        ColorProducer r10 = null;
    L22:
        this(r13, r14, r15, r6, r7, r8, r9, r10, null);
        return;
    L21:
        r10 = r20;
        goto L22
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
