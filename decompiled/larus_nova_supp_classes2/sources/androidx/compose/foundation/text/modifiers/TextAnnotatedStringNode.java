package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001nBÓ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001e\b\u0002\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b$\u0010%J\u0010\u00102\u001a\u0002002\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u00108\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b9J]\u0010:\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b;\u0010<JZ\u0010=\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\u001c\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fJ&\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u0012J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\u0006H\u0002J\b\u0010L\u001a\u00020\u000eH\u0002J\r\u0010M\u001a\u00020\u000eH\u0000¢\u0006\u0002\bNJ\f\u0010O\u001a\u00020\u000e*\u00020PH\u0016J%\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X¢\u0006\u0004\bY\u0010ZJ#\u0010[\u001a\u00020R*\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0016¢\u0006\u0004\b\\\u0010ZJ\u001e\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0014J\u001c\u0010b\u001a\u00020\u0014*\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0014H\u0016J\u001e\u0010c\u001a\u00020\u00142\u0006\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010d\u001a\u00020\u0014J\u001c\u0010e\u001a\u00020\u0014*\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010d\u001a\u00020\u0014H\u0016J\u001e\u0010f\u001a\u00020\u00142\u0006\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0014J\u001c\u0010g\u001a\u00020\u0014*\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0014H\u0016J\u001e\u0010h\u001a\u00020\u00142\u0006\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010d\u001a\u00020\u0014J\u001c\u0010i\u001a\u00020\u0014*\u00020_2\u0006\u0010U\u001a\u00020`2\u0006\u0010d\u001a\u00020\u0014H\u0016J\u000e\u0010j\u001a\u00020\u000e2\u0006\u0010k\u001a\u00020lJ\f\u0010m\u001a\u00020\u000e*\u00020lH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\"\u0010*\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0014\u0018\u00010+X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\"\u0010C\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0D\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006o"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "density", "Landroidx/compose/ui/unit/Density;", "updateDraw", "color", "updateText", "updateText$foundation_release", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-y0k-MQk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILandroidx/compose/foundation/text/TextAutoSize;)Z", "updateCallbacks", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "semanticsTextLayoutResult", "", "textSubstitution", "getTextSubstitution$foundation_release", "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "setTextSubstitution$foundation_release", "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;)V", "setSubstitution", "updatedText", "invalidateForTranslate", "clearSubstitution", "clearSubstitution$foundation_release", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "measureNonExtension", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "measure-3p2s80s", "minIntrinsicWidthNonExtension", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "minIntrinsicHeightNonExtension", "width", "minIntrinsicHeight", "maxIntrinsicWidthNonExtension", "maxIntrinsicWidth", "maxIntrinsicHeightNonExtension", "maxIntrinsicHeight", "drawNonExtension", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private MultiParagraphLayoutCache _layoutCache;
    private TextAutoSize autoSize;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    private Function1<? super TextSubstitutionValue, Unit> onShowTranslation;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;
    private TextSubstitutionValue textSubstitution;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "", "original", "Landroidx/compose/ui/text/AnnotatedString;", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;ZLandroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "getOriginal", "()Landroidx/compose/ui/text/AnnotatedString;", "getSubstitution", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private MultiParagraphLayoutCache layoutCache;
        private final AnnotatedString original;
        private AnnotatedString substitution;

        public static /* synthetic */ TextSubstitutionValue copy$default(TextSubstitutionValue r0, AnnotatedString r1, AnnotatedString r2, boolean r3, MultiParagraphLayoutCache r4, int r5, Object r6) {
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

        public final AnnotatedString component1() {
            return this.original;
        }

        public final AnnotatedString component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final MultiParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(AnnotatedString r2, AnnotatedString r3, boolean r4, MultiParagraphLayoutCache r5) {
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
            MultiParagraphLayoutCache r3 = this.layoutCache;
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
            return "TextSubstitutionValue(original=" + this.original + ", substitution=" + this.substitution + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }

        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final AnnotatedString getOriginal() {
            return this.original;
        }

        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(MultiParagraphLayoutCache r1) {
            this.layoutCache = r1;
        }

        public final void setShowingSubstitution(boolean r1) {
            this.isShowingSubstitution = r1;
        }

        public final void setSubstitution(AnnotatedString r1) {
            this.substitution = r1;
        }

        public TextSubstitutionValue(AnnotatedString r1, AnnotatedString r2, boolean r3, MultiParagraphLayoutCache r4) {
            this.original = r1;
            this.substitution = r2;
            this.isShowingSubstitution = r3;
            this.layoutCache = r4;
        }

        public /* synthetic */ TextSubstitutionValue(AnnotatedString r1, AnnotatedString r2, boolean r3, MultiParagraphLayoutCache r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = null;
        L8:
            this(r1, r2, r3, r4);
        }
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, Function1 r4, int r5, boolean r6, int r7, int r8, List r9, Function1 r10, SelectionController r11, ColorProducer r12, TextAutoSize r13, Function1 r14, DefaultConstructorMarker r15) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$10$lambda$9(r0, r1);
    }

    public static /* synthetic */ boolean b(TextAnnotatedStringNode r0, boolean r1) {
        return applySemantics$lambda$7(r0, r1);
    }

    public static /* synthetic */ boolean c(TextAnnotatedStringNode r0, AnnotatedString r1) {
        return applySemantics$lambda$6(r0, r1);
    }

    public static /* synthetic */ boolean d(TextAnnotatedStringNode r0) {
        return applySemantics$lambda$8(r0);
    }

    public static /* synthetic */ boolean e(TextAnnotatedStringNode r0, List r1) {
        return applySemantics$lambda$5(r0, r1);
    }

    private static /* synthetic */ void getBaselineCache$annotations() {
    }

    public final void clearSubstitution$foundation_release() {
        this.textSubstitution = null;
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

    private final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache != null) goto L5;
        this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.autoSize, null);
    L5:
        MultiParagraphLayoutCache r0 = this._layoutCache;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    private final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public final TextSubstitutionValue getTextSubstitution$foundation_release() {
        return this.textSubstitution;
    }

    private static final boolean applySemantics$lambda$8(TextAnnotatedStringNode r0) {
        r0.clearSubstitution$foundation_release();
        r0.invalidateForTranslate();
        return true;
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density r3) {
        TextSubstitutionValue r0 = this.textSubstitution;
        if (r0 != null) goto L5;
    L10:
        MultiParagraphLayoutCache r1 = getLayoutCache();
        r1.setDensity$foundation_release(r3);
        return r1;
    L5:
        if (r0.isShowingSubstitution() == false) goto L10;
        MultiParagraphLayoutCache r2 = r0.getLayoutCache();
        if (r2 == null) goto L10;
        r2.setDensity$foundation_release(r3);
        return r2;
    }

    private final boolean setSubstitution(AnnotatedString r16) {
        TextSubstitutionValue r1 = this.textSubstitution;
        if (r1 != null) goto L5;
        TextSubstitutionValue r12 = new TextSubstitutionValue(this.text, r16, false, null, 12, null);
        MultiParagraphLayoutCache r13 = new MultiParagraphLayoutCache(r16, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, CollectionsKt.emptyList(), this.autoSize, null);
        r13.setDensity$foundation_release(getLayoutCache().getDensity$foundation_release());
        r12.setLayoutCache(r13);
        this.textSubstitution = r12;
        return true;
    L5:
        if (Intrinsics.areEqual(r16, r1.getSubstitution()) == false) goto L7;
        return false;
    L7:
        r1.setSubstitution(r16);
        MultiParagraphLayoutCache r2 = r1.getLayoutCache();
        if (r2 == null) goto L10;
        r2.m1777updateJ2qo7bo(r16, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, CollectionsKt.emptyList(), this.autoSize);
        return true;
    L10:
        return false;
    }

    public void applySemantics(SemanticsPropertyReceiver r5) {
        Function1<? super List<TextLayoutResult>, Boolean> r0 = this.semanticsTextLayoutResult;
        if (r0 != null) goto L5;
        r0 = new e(this);
        this.semanticsTextLayoutResult = r0;
    L5:
        SemanticsPropertiesKt.setText(r5, this.text);
        TextSubstitutionValue r1 = this.textSubstitution;
        if (r1 == null) goto L8;
        SemanticsPropertiesKt.setTextSubstitution(r5, r1.getSubstitution());
        SemanticsPropertiesKt.setShowingTextSubstitution(r5, r1.isShowingSubstitution());
    L8:
        SemanticsPropertiesKt.setTextSubstitution$default(r5, null, new f(this), 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default(r5, null, new g(this), 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default(r5, null, new h(this), 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(r5, null, r0, 1, null);
    }

    public void draw(ContentDrawScope r18) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        SelectionController r0 = this.selectionController;
        if (r0 == null) goto L8;
        r0.draw(r18);
    L8:
        Canvas r13 = r18.getDrawContext().getCanvas();
        TextLayoutResult r1 = getLayoutCache(r18).getTextLayoutResult();
        MultiParagraph r3 = r1.getMultiParagraph();
        boolean r14 = true;
        if (r1.getHasVisualOverflow() == true) goto L11;
    L13:
        boolean r16 = false;
    L14:
        if (r16 == false) goto L71;
        float r4 = (int) (r1.getSize-YbymL2g() >> 32);
        float r2 = (int) (r1.getSize-YbymL2g() & 4294967295L);
        Rect r5 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((Float.floatToRawIntBits(r4) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(r2)))));
        r13.save();
        Canvas.-CC.clipRect-mtrdD-E$default(r13, r5, 0, 2, null);
    L71:
        TextDecoration r6 = this.style.getTextDecoration();     // Catch: Throwable -> L67
        if (r6 != null) goto L19;
        r6 = TextDecoration.Companion.getNone();     // Catch: Throwable -> L67
    L19:
        TextDecoration r8 = r6;
        Shadow r7 = this.style.getShadow();     // Catch: Throwable -> L67
        if (r7 != null) goto L22;
        r7 = Shadow.Companion.getNone();     // Catch: Throwable -> L67
    L22:
        Shadow r9 = r7;
        Fill r10 = this.style.getDrawStyle();     // Catch: Throwable -> L67
        if (r10 != null) goto L25;
        r10 = Fill.INSTANCE;     // Catch: Throwable -> L67
    L25:
        Fill r11 = r10;
        Brush r12 = this.style.getBrush();     // Catch: Throwable -> L67
        if (r12 == null) goto L28;
        MultiParagraph.paint-hn5TExg$default(r3, r13, r12, this.style.getAlpha(), r9, r8, r11, 0, 64, null);     // Catch: Throwable -> L67
    L46:
        if (r16 == false) goto L48;
        r13.restore();
    L48:
        TextSubstitutionValue r15 = this.textSubstitution;
        if (r15 != null) goto L51;
    L53:
        boolean r17 = false;
    L54:
        if (r17 == false) goto L56;
        boolean r19 = false;
    L57:
        if (r19 == true) goto L65;
        List<AnnotatedString.Range<Placeholder>> r20 = this.placeholders;
        if (r20 != null) goto L61;
    L64:
        if (r14 == false) goto L65;
        return;
    L61:
        if (r20.isEmpty() == true) goto L64;
        r14 = false;
    L65:
        r18.drawContent();
        return;
    L56:
        r19 = TextAnnotatedStringNodeKt.hasLinks(this.text);
        goto L57
    L51:
        if (r15.isShowingSubstitution() != true) goto L53;
        r17 = true;
        goto L54
    L28:
        ColorProducer r21 = this.overrideColor;     // Catch: Throwable -> L67
        if (r21 == null) goto L31;
        long r22 = r21.invoke-0d7_KjU();     // Catch: Throwable -> L67
    L33:
        if (r22 == 16) goto L35;
        boolean r23 = true;
    L36:
        if (r23 == false) goto L39;
    L45:
        MultiParagraph.paint-LG529CI$default(r3, r13, r22, r9, r8, r11, 0, 32, null);     // Catch: Throwable -> L67
        goto L46
    L39:
        if (this.style.getColor-0d7_KjU() == 16) goto L41;
        boolean r24 = true;
    L42:
        if (r24 == false) goto L44;
        r22 = this.style.getColor-0d7_KjU();     // Catch: Throwable -> L67
        goto L45
    L44:
        r22 = Color.Companion.getBlack-0d7_KjU();     // Catch: Throwable -> L67
        goto L45
    L41:
        r24 = false;
        goto L42
    L35:
        r23 = false;
        goto L36
    L31:
        r22 = Color.Companion.getUnspecified-0d7_KjU();     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        if (r16 == false) goto L70;
        r13.restore();
    L70:
        throw th;
    L11:
        if (TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getVisible-gIe3tQ8()) == true) goto L13;
        r16 = true;
        goto L14
    }

    public final void drawNonExtension(ContentDrawScope r1) {
        draw(r1);
    }

    public final void setTextSubstitution$foundation_release(TextSubstitutionValue r1) {
        this.textSubstitution = r1;
    }

    public final boolean updateText$foundation_release(AnnotatedString r4) {
        boolean r1 = true;
        boolean r0 = !Intrinsics.areEqual(this.text.getText(), r4.getText());
        boolean r2 = !this.text.hasEqualAnnotations(r4);
        if (r0 == true) goto L7;
        if (r2 == true) goto L7;
        r1 = false;
    L7:
        if (r1 == false) goto L9;
        this.text = r4;
    L9:
        if (r0 == false) goto L11;
        clearSubstitution$foundation_release();
    L11:
        return r1;
    }

    private static final boolean applySemantics$lambda$5(TextAnnotatedStringNode r37, List r38) {
        TextLayoutResult r2 = r37.getLayoutCache().getLayoutOrNull();
        if (r2 == null) goto L11;
        AnnotatedString r4 = r2.getLayoutInput().getText();
        TextStyle r5 = r37.style;
        ColorProducer r0 = r37.overrideColor;
        if (r0 == null) goto L7;
        long r6 = r0.invoke-0d7_KjU();
    L8:
        TextLayoutResult r1 = TextLayoutResult.copy-O0kMr_c$default(r2, new TextLayoutInput(r4, TextStyle.merge-dA7vx0o$default(r5, r6, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, 0, 0, null, null, 16777214, null), r2.getLayoutInput().getPlaceholders(), r2.getLayoutInput().getMaxLines(), r2.getLayoutInput().getSoftWrap(), r2.getLayoutInput().getOverflow-gIe3tQ8(), r2.getLayoutInput().getDensity(), r2.getLayoutInput().getLayoutDirection(), r2.getLayoutInput().getFontFamilyResolver(), r2.getLayoutInput().getConstraints-msEJaDk(), null), 0, 2, null);
        if (r1 == null) goto L11;
        r38.add(r1);
    L12:
        if (r1 == null) goto L14;
        return true;
    L14:
        return false;
    L7:
        r6 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        r1 = null;
        goto L12
    }

    private static final boolean applySemantics$lambda$6(TextAnnotatedStringNode r0, AnnotatedString r1) {
        r0.setSubstitution(r1);
        r0.invalidateForTranslate();
        return true;
    }

    private static final boolean applySemantics$lambda$7(TextAnnotatedStringNode r2, boolean r3) {
        TextSubstitutionValue r0 = r2.textSubstitution;
        if (r0 != null) goto L6;
        return false;
    L6:
        Function1<? super TextSubstitutionValue, Unit> r1 = r2.onShowTranslation;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        r1.invoke(r0);
    L9:
        TextSubstitutionValue r4 = r2.textSubstitution;
        if (r4 == null) goto L12;
        r4.setShowingSubstitution(r3);
    L12:
        r2.invalidateForTranslate();
        return true;
    }

    private static final Unit measure_3p2s80s$lambda$10$lambda$9(Placeable r7, Placeable.PlacementScope r8) {
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

    public int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCache(r1).intrinsicHeight(r3, r1.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return maxIntrinsicHeight(r1, r2, r3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCache(r1).maxIntrinsicWidth(r1.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return maxIntrinsicWidth(r1, r2, r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1818measure3p2s80s(MeasureScope r10, Measurable r11, long r12) {
        Trace.beginSection("TextAnnotatedStringNode:measure");
        MultiParagraphLayoutCache r0 = getLayoutCache(r10);     // Catch: Throwable -> L21
        boolean r13 = r0.m1776layoutWithConstraintsK40F9xA(r12, r10.getLayoutDirection());     // Catch: Throwable -> L21
        TextLayoutResult r14 = r0.getTextLayoutResult();     // Catch: Throwable -> L21
        r14.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();     // Catch: Throwable -> L21
        if (r13 == false) goto L15;
        LayoutModifierNodeKt.invalidateLayer(this);     // Catch: Throwable -> L21
        Function1<? super TextLayoutResult, Unit> r15 = this.onTextLayout;     // Catch: Throwable -> L21
        if (r15 == null) goto L8;
        r15.invoke(r14);     // Catch: Throwable -> L21
    L8:
        SelectionController r16 = this.selectionController;     // Catch: Throwable -> L21
        if (r16 == null) goto L11;
        r16.updateTextLayout(r14);     // Catch: Throwable -> L21
    L11:
        Map<AlignmentLine, Integer> r17 = this.baselineCache;     // Catch: Throwable -> L21
        if (r17 != null) goto L14;
        r17 = new LinkedHashMap(2);     // Catch: Throwable -> L21
    L14:
        r17.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(r14.getFirstBaseline())));     // Catch: Throwable -> L21
        r17.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(r14.getLastBaseline())));     // Catch: Throwable -> L21
        this.baselineCache = r17;     // Catch: Throwable -> L21
    L15:
        Function1<? super List<Rect>, Unit> r18 = this.onPlaceholderLayout;     // Catch: Throwable -> L21
        if (r18 == null) goto L18;
        r18.invoke(r14.getPlaceholderRects());     // Catch: Throwable -> L21
    L18:
        final Placeable r19 = r11.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA((int) (r14.getSize-YbymL2g() >> 32), (int) (r14.getSize-YbymL2g() >> 32), (int) (r14.getSize-YbymL2g() & 4294967295L), (int) (r14.getSize-YbymL2g() & 4294967295L)));     // Catch: Throwable -> L21
        int r110 = (int) (r14.getSize-YbymL2g() >> 32);     // Catch: Throwable -> L21
        int r111 = (int) (r14.getSize-YbymL2g() & 4294967295L);     // Catch: Throwable -> L21
        Map<AlignmentLine, Integer> r1 = this.baselineCache;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L21
        MeasureResult r112 = r10.layout(r110, r111, r1, new d(r19));     // Catch: Throwable -> L21
        Trace.endSection();
        return r112;
    L21:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    /* JADX INFO: renamed from: measureNonExtension-3p2s80s, reason: not valid java name */
    public final MeasureResult m1819measureNonExtension3p2s80s(MeasureScope r1, Measurable r2, long r3) {
        return m1818measure3p2s80s(r1, r2, r3);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCache(r1).intrinsicHeight(r3, r1.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return minIntrinsicHeight(r1, r2, r3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return getLayoutCache(r1).minIntrinsicWidth(r1.getLayoutDirection());
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return minIntrinsicWidth(r1, r2, r3);
    }

    public final void doInvalidations(boolean r11, boolean r12, boolean r13, boolean r14) {
        if (r12 == true) goto L5;
        if (r13 == true) goto L5;
        if (r14 == true) goto L5;
    L7:
        if (isAttached() == true) goto L9;
        return;
    L9:
        if (r12 == true) goto L13;
        if (r11 == true) goto L12;
    L14:
        if (r12 == true) goto L17;
        if (r13 == true) goto L17;
        if (r14 == true) goto L17;
    L18:
        if (r11 == false) goto L21;
        DrawModifierNodeKt.invalidateDraw(this);
        return;
    L21:
        return;
    L17:
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
        goto L18
    L12:
        if (this.semanticsTextLayoutResult == null) goto L14;
    L13:
        SemanticsModifierNodeKt.invalidateSemantics(this);
    L5:
        getLayoutCache().m1777updateJ2qo7bo(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.autoSize);
        goto L7
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> r3, Function1<? super List<Rect>, Unit> r4, SelectionController r5, Function1<? super TextSubstitutionValue, Unit> r6) {
        if (this.onTextLayout == r3) goto L5;
        this.onTextLayout = r3;
        boolean r7 = true;
    L7:
        if (this.onPlaceholderLayout == r4) goto L10;
        this.onPlaceholderLayout = r4;
        r7 = true;
    L10:
        if (Intrinsics.areEqual(this.selectionController, r5) == true) goto L13;
        this.selectionController = r5;
        r7 = true;
    L13:
        if (this.onShowTranslation == r6) goto L16;
        this.onShowTranslation = r6;
        return true;
    L16:
        return r7;
    L5:
        r7 = false;
        goto L7
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-y0k-MQk, reason: not valid java name */
    public final boolean m1820updateLayoutRelatedArgsy0kMQk(TextStyle r3, List<AnnotatedString.Range<Placeholder>> r4, int r5, int r6, boolean r7, FontFamily.Resolver r8, int r9, TextAutoSize r10) {
        boolean r0 = !this.style.hasSameLayoutAffectingAttributes(r3);
        this.style = r3;
        if (Intrinsics.areEqual(this.placeholders, r4) == true) goto L6;
        this.placeholders = r4;
        r0 = true;
    L6:
        if (this.minLines == r5) goto L9;
        this.minLines = r5;
        r0 = true;
    L9:
        if (this.maxLines == r6) goto L12;
        this.maxLines = r6;
        r0 = true;
    L12:
        if (this.softWrap == r7) goto L15;
        this.softWrap = r7;
        r0 = true;
    L15:
        if (Intrinsics.areEqual(this.fontFamilyResolver, r8) == true) goto L18;
        this.fontFamilyResolver = r8;
        r0 = true;
    L18:
        if (TextOverflow.equals-impl0(this.overflow, r9) == true) goto L21;
        this.overflow = r9;
        r0 = true;
    L21:
        if (Intrinsics.areEqual(this.autoSize, r10) == true) goto L24;
        this.autoSize = r10;
        return true;
    L24:
        return r0;
    }

    private TextAnnotatedStringNode(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, Function1<? super TextLayoutResult, Unit> r4, int r5, boolean r6, int r7, int r8, List<AnnotatedString.Range<Placeholder>> r9, Function1<? super List<Rect>, Unit> r10, SelectionController r11, ColorProducer r12, TextAutoSize r13, Function1<? super TextSubstitutionValue, Unit> r14) {
        this.text = r1;
        this.style = r2;
        this.fontFamilyResolver = r3;
        this.onTextLayout = r4;
        this.overflow = r5;
        this.softWrap = r6;
        this.maxLines = r7;
        this.minLines = r8;
        this.placeholders = r9;
        this.onPlaceholderLayout = r10;
        this.selectionController = r11;
        this.overrideColor = r12;
        this.autoSize = r13;
        this.onShowTranslation = r14;
    }

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString r20, TextStyle r21, FontFamily.Resolver r22, Function1 r23, int r24, boolean r25, int r26, int r27, List r28, Function1 r29, SelectionController r30, ColorProducer r31, TextAutoSize r32, Function1 r33, int r34, DefaultConstructorMarker r35) {
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
