package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BÓ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b$\u0010%J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0016J\f\u0010.\u001a\u00020\u000e*\u00020/H\u0016J#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u001c\u00109\u001a\u00020\u0014*\u00020:2\u0006\u00103\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0014H\u0016J\u001c\u0010=\u001a\u00020\u0014*\u00020:2\u0006\u00103\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0014H\u0016J\u001c\u0010?\u001a\u00020\u0014*\u00020:2\u0006\u00103\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0014H\u0016J\u001c\u0010@\u001a\u00020\u0014*\u00020:2\u0006\u00103\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0014H\u0016J\u00ad\u0001\u0010A\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010B\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\bC\u0010DR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "textAnnotatedStringNode", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "update", "color", "update-7NebLg4", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {
    public static final int $stable = 8;
    private Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> onShowTranslation;
    private SelectionController selectionController;
    private final TextAnnotatedStringNode textAnnotatedStringNode;

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, Function1 r4, int r5, boolean r6, int r7, int r8, List r9, Function1 r10, SelectionController r11, ColorProducer r12, TextAutoSize r13, Function1 r14, DefaultConstructorMarker r15) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
    }

    public void draw(ContentDrawScope r2) {
        this.textAnnotatedStringNode.drawNonExtension(r2);
    }

    public void onGloballyPositioned(LayoutCoordinates r2) {
        SelectionController r0 = this.selectionController;
        if (r0 == null) goto L6;
        r0.updateGlobalPosition(r2);
        return;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r2, IntrinsicMeasurable r3, int r4) {
        return this.textAnnotatedStringNode.maxIntrinsicHeightNonExtension(r2, r3, r4);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r2, IntrinsicMeasurable r3, int r4) {
        return this.textAnnotatedStringNode.maxIntrinsicWidthNonExtension(r2, r3, r4);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1803measure3p2s80s(MeasureScope r2, Measurable r3, long r4) {
        return this.textAnnotatedStringNode.m1819measureNonExtension3p2s80s(r2, r3, r4);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r2, IntrinsicMeasurable r3, int r4) {
        return this.textAnnotatedStringNode.minIntrinsicHeightNonExtension(r2, r3, r4);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r2, IntrinsicMeasurable r3, int r4) {
        return this.textAnnotatedStringNode.minIntrinsicWidthNonExtension(r2, r3, r4);
    }

    /* JADX INFO: renamed from: update-7NebLg4, reason: not valid java name */
    public final void m1804update7NebLg4(AnnotatedString r15, TextStyle r16, List<AnnotatedString.Range<Placeholder>> r17, int r18, int r19, boolean r20, FontFamily.Resolver r21, int r22, Function1<? super TextLayoutResult, Unit> r23, Function1<? super List<Rect>, Unit> r24, SelectionController r25, ColorProducer r26, TextAutoSize r27) {
        TextAnnotatedStringNode r2 = this.textAnnotatedStringNode;
        r2.doInvalidations(r2.updateDraw(r26, r16), this.textAnnotatedStringNode.updateText$foundation_release(r15), this.textAnnotatedStringNode.m1820updateLayoutRelatedArgsy0kMQk(r16, r17, r18, r19, r20, r21, r22, r27), this.textAnnotatedStringNode.updateCallbacks(r23, r24, r25, this.onShowTranslation));
        this.selectionController = r25;
        LayoutModifierNodeKt.invalidateMeasurement(this);
    }

    private SelectableTextAnnotatedStringNode(AnnotatedString r19, TextStyle r20, FontFamily.Resolver r21, Function1<? super TextLayoutResult, Unit> r22, int r23, boolean r24, int r25, int r26, List<AnnotatedString.Range<Placeholder>> r27, Function1<? super List<Rect>, Unit> r28, SelectionController r29, ColorProducer r30, TextAutoSize r31, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> r32) {
        this.selectionController = r29;
        this.onShowTranslation = r32;
        this.textAnnotatedStringNode = delegate(new TextAnnotatedStringNode(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, null));
        if (this.selectionController == null) goto L5;
        return;
    L5:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Do not use SelectionCapableStaticTextModifier unless selectionController != null");
        throw new KotlinNothingValueException();
    }

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString r20, TextStyle r21, FontFamily.Resolver r22, Function1 r23, int r24, boolean r25, int r26, int r27, List r28, Function1 r29, SelectionController r30, ColorProducer r31, TextAutoSize r32, Function1 r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 8) == 0) goto L5;
        Function1 r7 = null;
    L7:
        if ((r34 & 16) == 0) goto L9;
        int r8 = TextOverflow.Companion.getClip-gIe3tQ8();
    L11:
        if ((r34 & 32) == 0) goto L13;
        boolean r9 = true;
    L15:
        if ((r34 & 64) == 0) goto L17;
        int r10 = Integer.MAX_VALUE;
    L19:
        if ((r34 & 128) == 0) goto L21;
        int r11 = 1;
    L23:
        if ((r34 & 256) == 0) goto L25;
        List r12 = null;
    L27:
        if ((r34 & 512) == 0) goto L29;
        Function1 r13 = null;
    L31:
        if ((r34 & 1024) == 0) goto L33;
        SelectionController r14 = null;
    L35:
        if ((r34 & 2048) == 0) goto L37;
        ColorProducer r15 = null;
    L39:
        if ((r34 & 4096) == 0) goto L41;
        TextAutoSize r16 = null;
    L43:
        if ((r34 & 8192) == 0) goto L45;
        Function1 r17 = null;
    L46:
        this(r20, r21, r22, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, null);
        return;
    L45:
        r17 = r33;
        goto L46
    L41:
        r16 = r32;
        goto L43
    L37:
        r15 = r31;
        goto L39
    L33:
        r14 = r30;
        goto L35
    L29:
        r13 = r29;
        goto L31
    L25:
        r12 = r28;
        goto L27
    L21:
        r11 = r27;
        goto L23
    L17:
        r10 = r26;
        goto L19
    L13:
        r9 = r25;
        goto L15
    L9:
        r8 = r24;
        goto L11
    L5:
        r7 = r23;
        goto L7
    }
}
