package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010 \u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b!\u0010\"\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b#\u0010$\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b#\u0010%\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b\u001e\u0010&\u001a\u001e\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002\u001a@\u0010,\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e00H\u0002\u001aÉ\u0001\u00105\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0014\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0018\u00010-2\u001c\u0010;\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010<0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bA\u0010B\u001a·\u0001\u0010C\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00182\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\bE\u0010F¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"BasicText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "BasicText-RWo7tUw", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-CL7eQgs", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "BasicText-VhcvRP8", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "textModifier-CL7eQgs", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;)Landroidx/compose/ui/Modifier;", "LayoutWithLinksAndInlineContent", "hasInlineContent", "LayoutWithLinksAndInlineContent-11Od_4g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "displayedText"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTextKt {
    private static final Unit BasicText_4YKlhWE$lambda$16(AnnotatedString r12, Modifier r13, TextStyle r14, Function1 r15, int r16, boolean r17, int r18, Map r19, int r20, int r21, Composer r22, int r23) {
        m1351BasicText4YKlhWE(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_4YKlhWE$lambda$17(String r12, Modifier r13, TextStyle r14, Function1 r15, int r16, boolean r17, int r18, int r19, int r20, int r21, Composer r22, int r23) {
        m1352BasicText4YKlhWE(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_BpD7jsM$lambda$15(String r11, Modifier r12, TextStyle r13, Function1 r14, int r15, boolean r16, int r17, int r18, int r19, Composer r20, int r21) {
        m1353BasicTextBpD7jsM(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_CL7eQgs$lambda$12(AnnotatedString r16, Modifier r17, TextStyle r18, Function1 r19, int r20, boolean r21, int r22, int r23, Map r24, ColorProducer r25, TextAutoSize r26, int r27, int r28, int r29, Composer r30, int r31) {
        m1354BasicTextCL7eQgs(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_RWo7tUw$lambda$14(AnnotatedString r14, Modifier r15, TextStyle r16, Function1 r17, int r18, boolean r19, int r20, int r21, Map r22, ColorProducer r23, int r24, int r25, Composer r26, int r27) {
        m1355BasicTextRWo7tUw(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_RWo7tUw$lambda$3(String r14, Modifier r15, TextStyle r16, Function1 r17, int r18, boolean r19, int r20, int r21, ColorProducer r22, TextAutoSize r23, int r24, int r25, Composer r26, int r27) {
        m1356BasicTextRWo7tUw(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_VhcvRP8$lambda$13(String r13, Modifier r14, TextStyle r15, Function1 r16, int r17, boolean r18, int r19, int r20, ColorProducer r21, int r22, int r23, Composer r24, int r25) {
        m1358BasicTextVhcvRP8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit BasicText_VhcvRP8$lambda$18(AnnotatedString r13, Modifier r14, TextStyle r15, Function1 r16, int r17, boolean r18, int r19, int r20, Map r21, int r22, int r23, Composer r24, int r25) {
        m1357BasicTextVhcvRP8(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26(AnnotatedString r0) {
        return r0;
    }

    private static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$43(Modifier r19, AnnotatedString r20, Function1 r21, boolean r22, Map r23, TextStyle r24, int r25, boolean r26, int r27, int r28, FontFamily.Resolver r29, SelectionController r30, ColorProducer r31, Function1 r32, TextAutoSize r33, int r34, int r35, int r36, Composer r37, int r38) {
        m1359LayoutWithLinksAndInlineContent11Od_4g(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r37, RecomposeScopeImplKt.updateChangedFlags(r34 | 1), RecomposeScopeImplKt.updateChangedFlags(r35), r36);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(MutableState r0, TextAnnotatedStringNode.TextSubstitutionValue r1) {
        return BasicText_CL7eQgs$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ long b(SelectionRegistrar r2) {
        return BasicText_CL7eQgs$lambda$5$lambda$4(r2);
    }

    public static /* synthetic */ Unit c(MutableState r0, List r1) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29(r0, r1);
    }

    public static /* synthetic */ Unit d(String r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, ColorProducer r8, TextAutoSize r9, int r10, int r11, Composer r12, int r13) {
        return BasicText_RWo7tUw$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit e(AnnotatedString r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, Map r7, int r8, int r9, Composer r10, int r11) {
        return BasicText_4YKlhWE$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ boolean f(TextLinkScope r0) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39(r0);
    }

    public static /* synthetic */ boolean g(TextLinkScope r0) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36(r0);
    }

    public static /* synthetic */ AnnotatedString h(AnnotatedString r0) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$27$lambda$26(r0);
    }

    public static /* synthetic */ Unit i(String r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, int r8, Composer r9, int r10) {
        return BasicText_BpD7jsM$lambda$15(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit j(AnnotatedString r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, Map r8, int r9, int r10, Composer r11, int r12) {
        return BasicText_VhcvRP8$lambda$18(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Long k(SelectionRegistrar r0, SaverScope r1, long r2) {
        return selectionIdSaver$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ Unit l(AnnotatedString r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, Map r8, ColorProducer r9, TextAutoSize r10, int r11, int r12, int r13, Composer r14, int r15) {
        return BasicText_CL7eQgs$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit m(String r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, ColorProducer r8, int r9, int r10, Composer r11, int r12) {
        return BasicText_VhcvRP8$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit n(Modifier r1, AnnotatedString r2, Function1 r3, boolean r4, Map r5, TextStyle r6, int r7, boolean r8, int r9, int r10, FontFamily.Resolver r11, SelectionController r12, ColorProducer r13, Function1 r14, TextAutoSize r15, int r16, int r17, int r18, Composer r19, int r20) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$43(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ long o(SelectionRegistrar r2) {
        return BasicText_RWo7tUw$lambda$1$lambda$0(r2);
    }

    public static /* synthetic */ Long p(long r0) {
        return selectionIdSaver$lambda$20(r0);
    }

    public static /* synthetic */ AnnotatedString q(TextLinkScope r0, AnnotatedString r1) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24(r0, r1);
    }

    public static /* synthetic */ List r(MutableState r0) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41(r0);
    }

    public static /* synthetic */ Unit s(String r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, int r8, int r9, Composer r10, int r11) {
        return BasicText_4YKlhWE$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit t(AnnotatedString r0, Modifier r1, TextStyle r2, Function1 r3, int r4, boolean r5, int r6, int r7, Map r8, ColorProducer r9, int r10, int r11, Composer r12, int r13) {
        return BasicText_RWo7tUw$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit u(TextLinkScope r0, Function1 r1, TextLayoutResult r2) {
        return LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33(r0, r1, r2);
    }

    private static final long BasicText_CL7eQgs$lambda$5$lambda$4(SelectionRegistrar r2) {
        return r2.nextSelectableId();
    }

    private static final AnnotatedString BasicText_CL7eQgs$lambda$8(MutableState<AnnotatedString> r0) {
        return (AnnotatedString) r0.getValue();
    }

    private static final long BasicText_RWo7tUw$lambda$1$lambda$0(SelectionRegistrar r2) {
        return r2.nextSelectableId();
    }

    private static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$37$lambda$36(TextLinkScope r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return ((Boolean) r0.getShouldMeasureLinks().invoke()).booleanValue();
    }

    private static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$40$lambda$39(TextLinkScope r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return ((Boolean) r0.getShouldMeasureLinks().invoke()).booleanValue();
    }

    private static final List LayoutWithLinksAndInlineContent_11Od_4g$lambda$42$lambda$41(MutableState r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return (List) r0.getValue();
    }

    private static final Saver<Long, Long> selectionIdSaver(final SelectionRegistrar r1) {
        return SaverKt.Saver(new s0(r1), new t0());
    }

    private static final Long selectionIdSaver$lambda$20(long r0) {
        return Long.valueOf(r0);
    }

    private static final Unit BasicText_CL7eQgs$lambda$11$lambda$10(MutableState r1, TextAnnotatedStringNode.TextSubstitutionValue r2) {
        if (r2.isShowingSubstitution() == false) goto L5;
        AnnotatedString r3 = r2.getSubstitution();
    L6:
        BasicText_CL7eQgs$lambda$9(r1, r3);
        return Unit.INSTANCE;
    L5:
        r3 = r2.getOriginal();
        goto L6
    }

    private static final void BasicText_CL7eQgs$lambda$9(MutableState<AnnotatedString> r0, AnnotatedString r1) {
        r0.setValue(r1);
    }

    private static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$25$lambda$24(TextLinkScope r0, AnnotatedString r1) {
        if (r0 == null) goto L8;
        AnnotatedString r2 = r0.applyAnnotators$foundation_release();
        if (r2 != null) goto L7;
        return r1;
    L7:
        return r2;
    L8:
        return r1;
    }

    private static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$30$lambda$29(MutableState r0, List r1) {
        if (r0 == null) goto L5;
        r0.setValue(r1);
    L5:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ List access$measureWithTextRangeMeasureConstraints(List r0, Function0 r1) {
        return measureWithTextRangeMeasureConstraints(r0, r1);
    }

    private static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> r10, Function0<Boolean> r11) {
        if (((Boolean) r11.invoke()).booleanValue() == false) goto L7;
        TextRangeLayoutMeasureScope r12 = new TextRangeLayoutMeasureScope();
        ArrayList r0 = new ArrayList(r10.size());
        int r1 = r10.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        Measurable r3 = (Measurable) ListProtector.get(r10, r2);
        Object r4 = r3.getParentData();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
        TextRangeLayoutMeasureResult r5 = ((TextRangeLayoutModifier) r4).getMeasurePolicy().measure(r12);
        r0.add(new Pair(r3.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(r5.getWidth(), r5.getWidth(), r5.getHeight(), r5.getHeight())), r5.getPlace()));
        r2 = r2 + 1;
        goto L5
    L10:
        return r0;
    L7:
        return null;
    }

    private static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$34$lambda$33(TextLinkScope r0, Function1 r1, TextLayoutResult r2) {
        if (r0 == null) goto L4;
        r0.setTextLayoutResult(r2);
    L4:
        if (r1 == null) goto L7;
        r1.invoke(r2);
    L7:
        return Unit.INSTANCE;
    }

    private static final Long selectionIdSaver$lambda$19(SelectionRegistrar r0, SaverScope r1, long r2) {
        if (SelectionRegistrarKt.hasSelection(r0, r2) == true) goto L7;
        return null;
    L7:
        return Long.valueOf(r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-BpD7jsM, reason: not valid java name */
    public static final /* synthetic */ void m1353BasicTextBpD7jsM(final String r22, Modifier r23, TextStyle r24, Function1 r25, int r26, boolean r27, int r28, Composer r29, final int r30, final int r31) {
        Composer r1 = r29.startRestartGroup(1022429478);
        if ((r31 & 1) == 0) goto L6;
        int r3 = r30 | 6;
    L13:
        int r4 = r31 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r23;
    L24:
        int r6 = r31 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        TextStyle r7 = r24;
    L35:
        int r9 = r31 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function1 r10 = r25;
    L46:
        int r11 = r31 & 16;
        if (r11 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r12 = r26;
    L57:
        int r13 = r31 & 32;
        if (r13 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r14 = r27;
    L68:
        int r15 = r31 & 64;
        if (r15 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r3 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r3 & 1) == false) goto L108;
        if (r4 == 0) goto L86;
        Modifier r2 = Modifier.Companion;
    L87:
        if (r6 == 0) goto L89;
        r7 = TextStyle.Companion.getDefault();
    L89:
        if (r9 == 0) goto L91;
        Function1 r8 = null;
    L92:
        if (r11 == 0) goto L94;
        int r16 = TextOverflow.Companion.getClip-gIe3tQ8();
    L95:
        if (r13 == 0) goto L97;
        boolean r17 = true;
    L98:
        if (r15 == 0) goto L100;
        int r18 = Integer.MAX_VALUE;
    L102:
        if (ComposerKt.isTraceInProgress() == false) goto L104;
        ComposerKt.traceEventStart(1022429478, r3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:384)");
    L104:
        int r20 = (((((((r3 & 14) | 12582912) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (r3 & 3670016);
        m1356BasicTextRWo7tUw(r22, r2, r7, r8, r16, r17, r18, 1, null, null, r1, r20, 768);
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventEnd();
    L107:
        final TextStyle r19 = r7;
        final int r21 = r18;
        final boolean r32 = r17;
        final int r33 = r16;
        final Function1 r34 = r8;
        final Modifier r35 = r2;
    L109:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L113;
        r110.updateScope(new z0(r22, r35, r19, r34, r33, r32, r21, r30, r31));
        return;
    L113:
        return;
    L100:
        r18 = r28;
        goto L102
    L97:
        r17 = r14;
        goto L98
    L94:
        r16 = r12;
        goto L95
    L91:
        r8 = r10;
        goto L92
    L86:
        r2 = r5;
        goto L87
    L108:
        r1.skipToGroupEnd();
        r35 = r5;
        r19 = r7;
        r34 = r10;
        r33 = r12;
        r32 = r14;
        r21 = r28;
        goto L109
    L81:
        r0 = false;
        goto L83
    L72:
        if ((r30 & 1572864) != 0) goto L79;
        if (r1.changed(r28) == false) goto L76;
        int r111 = 1048576;
    L77:
        r3 = r3 | r111;
        goto L79
    L76:
        r111 = 524288;
        goto L77
    L61:
        if ((196608 & r30) != 0) goto L67;
        r14 = r27;
        if (r1.changed(r14) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L68
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r30 & 24576) != 0) goto L56;
        r12 = r26;
        if (r1.changed(r12) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L39:
        if ((r30 & 3072) != 0) goto L45;
        r10 = r25;
        if (r1.changedInstance(r10) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
        goto L46
    L43:
        r114 = 1024;
        goto L44
    L28:
        if ((r30 & 384) != 0) goto L34;
        r7 = r24;
        if (r1.changed(r7) == false) goto L32;
        int r36 = 256;
    L33:
        r3 = r3 | r36;
        goto L35
    L32:
        r36 = 128;
        goto L33
    L17:
        if ((r30 & 48) != 0) goto L23;
        r5 = r23;
        if (r1.changed(r5) == false) goto L21;
        int r37 = 32;
    L22:
        r3 = r3 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r3 = r30;
        goto L13
    L8:
        if (r1.changed(r22) == false) goto L10;
        int r38 = 4;
    L11:
        r3 = r38 | r30;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final /* synthetic */ void m1351BasicText4YKlhWE(final AnnotatedString r26, Modifier r27, TextStyle r28, Function1 r29, int r30, boolean r31, int r32, Map r33, Composer r34, final int r35, final int r36) {
        Composer r1 = r34.startRestartGroup(-648605928);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L13:
        int r4 = r36 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r36 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        TextStyle r7 = r28;
    L35:
        int r8 = r36 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function1 r11 = r29;
    L46:
        int r12 = r36 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r13 = r30;
    L57:
        int r14 = r36 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r15 = r31;
    L68:
        int r16 = r36 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r36 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L89:
        if ((r3 & 4793491) == 4793490) goto L91;
        boolean r2 = true;
    L93:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L121;
        if (r4 == 0) goto L96;
        final Modifier r5 = Modifier.Companion;
    L97:
        if (r6 == 0) goto L99;
        r7 = TextStyle.Companion.getDefault();
    L99:
        if (r8 == 0) goto L101;
        final Function1 r9 = null;
    L102:
        if (r12 == 0) goto L104;
        final int r10 = TextOverflow.Companion.getClip-gIe3tQ8();
    L105:
        if (r14 == 0) goto L107;
        final boolean r17 = true;
    L108:
        if (r16 == 0) goto L110;
        int r18 = Integer.MAX_VALUE;
    L111:
        if (r0 == 0) goto L113;
        Map r19 = MapsKt.emptyMap();
    L115:
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(-648605928, r3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:408)");
    L117:
        int r23 = ((((((((r3 & 14) | 12582912) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | ((r3 << 3) & 234881024);
        m1354BasicTextCL7eQgs(r26, r5, r7, r9, r10, r17, r18, 1, r19, null, null, r1, r23, 0, 1536);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final TextStyle r20 = r7;
        final int r21 = r18;
        final Map r22 = r19;
    L122:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L126;
        r110.updateScope(new w0(r26, r5, r20, r9, r10, r17, r21, r22, r35, r36));
        return;
    L126:
        return;
    L113:
        r19 = r33;
        goto L115
    L110:
        r18 = r32;
        goto L111
    L107:
        r17 = r15;
        goto L108
    L104:
        r10 = r13;
        goto L105
    L101:
        r9 = r11;
        goto L102
    L96:
        r5 = r27;
        goto L97
    L121:
        r1.skipToGroupEnd();
        r5 = r27;
        r22 = r33;
        r20 = r7;
        r9 = r11;
        r10 = r13;
        r17 = r15;
        r21 = r32;
        goto L122
    L91:
        r2 = false;
        goto L93
    L82:
        if ((r35 & 12582912) != 0) goto L89;
        if (r1.changedInstance(r33) == false) goto L86;
        int r111 = 8388608;
    L87:
        r3 = r3 | r111;
        goto L89
    L86:
        r111 = 4194304;
        goto L87
    L72:
        if ((r35 & 1572864) != 0) goto L78;
        if (r1.changed(r32) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L78
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r35) != 0) goto L67;
        r15 = r31;
        if (r1.changed(r15) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L68
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r35 & 24576) != 0) goto L56;
        r13 = r30;
        if (r1.changed(r13) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r35 & 3072) != 0) goto L45;
        r11 = r29;
        if (r1.changedInstance(r11) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
        goto L46
    L43:
        r115 = 1024;
        goto L44
    L28:
        if ((r35 & 384) != 0) goto L34;
        r7 = r28;
        if (r1.changed(r7) == false) goto L32;
        int r24 = 256;
    L33:
        r3 = r3 | r24;
        goto L35
    L32:
        r24 = 128;
        goto L33
    L17:
        if ((r35 & 48) != 0) goto L24;
        if (r1.changed(r27) == false) goto L21;
        int r25 = 32;
    L22:
        r3 = r3 | r25;
        goto L24
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r37 = 4;
    L11:
        r3 = r37 | r35;
        goto L13
    L10:
        r37 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* JADX INFO: renamed from: BasicText-4YKlhWE, reason: not valid java name */
    public static final /* synthetic */ void m1352BasicText4YKlhWE(final String r24, Modifier r25, TextStyle r26, Function1 r27, int r28, boolean r29, int r30, int r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(1542716361);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L13:
        int r4 = r34 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r34 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        TextStyle r7 = r26;
    L35:
        int r8 = r34 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function1 r11 = r27;
    L46:
        int r12 = r34 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r13 = r28;
    L57:
        int r14 = r34 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r15 = r29;
    L68:
        int r16 = r34 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r34 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L89:
        if ((r3 & 4793491) == 4793490) goto L91;
        boolean r2 = true;
    L93:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L121;
        if (r4 == 0) goto L96;
        final Modifier r5 = Modifier.Companion;
    L97:
        if (r6 == 0) goto L99;
        r7 = TextStyle.Companion.getDefault();
    L99:
        if (r8 == 0) goto L101;
        final Function1 r9 = null;
    L102:
        if (r12 == 0) goto L104;
        final int r10 = TextOverflow.Companion.getClip-gIe3tQ8();
    L105:
        if (r14 == 0) goto L107;
        final boolean r17 = true;
    L108:
        if (r16 == 0) goto L110;
        int r18 = Integer.MAX_VALUE;
    L111:
        if (r0 == 0) goto L113;
        int r19 = 1;
    L115:
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventStart(1542716361, r3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:433)");
    L117:
        int r22 = (((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (r3 & 29360128);
        m1356BasicTextRWo7tUw(r24, r5, r7, r9, r10, r17, r18, r19, null, null, r1, r22, 768);
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final TextStyle r20 = r7;
        final int r21 = r18;
        final int r23 = r19;
    L122:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L126;
        r110.updateScope(new r0(r24, r5, r20, r9, r10, r17, r21, r23, r33, r34));
        return;
    L126:
        return;
    L113:
        r19 = r31;
        goto L115
    L110:
        r18 = r30;
        goto L111
    L107:
        r17 = r15;
        goto L108
    L104:
        r10 = r13;
        goto L105
    L101:
        r9 = r11;
        goto L102
    L96:
        r5 = r25;
        goto L97
    L121:
        r1.skipToGroupEnd();
        r5 = r25;
        r23 = r31;
        r20 = r7;
        r9 = r11;
        r10 = r13;
        r17 = r15;
        r21 = r30;
        goto L122
    L91:
        r2 = false;
        goto L93
    L82:
        if ((r33 & 12582912) != 0) goto L89;
        if (r1.changed(r31) == false) goto L86;
        int r111 = 8388608;
    L87:
        r3 = r3 | r111;
        goto L89
    L86:
        r111 = 4194304;
        goto L87
    L72:
        if ((r33 & 1572864) != 0) goto L78;
        if (r1.changed(r30) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L78
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r33) != 0) goto L67;
        r15 = r29;
        if (r1.changed(r15) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L68
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r33 & 24576) != 0) goto L56;
        r13 = r28;
        if (r1.changed(r13) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r11 = r27;
        if (r1.changedInstance(r11) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
        goto L46
    L43:
        r115 = 1024;
        goto L44
    L28:
        if ((r33 & 384) != 0) goto L34;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r35 = 256;
    L33:
        r3 = r3 | r35;
        goto L35
    L32:
        r35 = 128;
        goto L33
    L17:
        if ((r33 & 48) != 0) goto L24;
        if (r1.changed(r25) == false) goto L21;
        int r36 = 32;
    L22:
        r3 = r3 | r36;
        goto L24
    L21:
        r36 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L13
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r37 = 4;
    L11:
        r3 = r37 | r33;
        goto L13
    L10:
        r37 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    public static final /* synthetic */ void m1357BasicTextVhcvRP8(final AnnotatedString r27, Modifier r28, TextStyle r29, Function1 r30, int r31, boolean r32, int r33, int r34, Map r35, Composer r36, final int r37, final int r38) {
        Composer r1 = r36.startRestartGroup(851408699);
        if ((r38 & 1) == 0) goto L6;
        int r3 = r37 | 6;
    L13:
        int r4 = r38 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r38 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r38 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function1 r9 = r30;
    L46:
        int r12 = r38 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r13 = r31;
    L57:
        int r14 = r38 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r15 = r32;
    L68:
        int r16 = r38 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r38 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        int r2 = r38 & 256;
        if (r2 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r3 & 38347923) == 38347922) goto L101;
        boolean r5 = true;
    L103:
        if (r1.shouldExecute(r5, r3 & 1) == false) goto L135;
        if (r4 == 0) goto L106;
        Modifier r7 = Modifier.Companion;
    L107:
        if (r6 == 0) goto L109;
        TextStyle r10 = TextStyle.Companion.getDefault();
    L110:
        if (r8 == 0) goto L112;
        Function1 r11 = null;
    L113:
        if (r12 == 0) goto L115;
        int r17 = TextOverflow.Companion.getClip-gIe3tQ8();
    L116:
        if (r14 == 0) goto L118;
        boolean r18 = true;
    L119:
        if (r16 == 0) goto L121;
        int r19 = Integer.MAX_VALUE;
    L122:
        if (r0 == 0) goto L124;
        int r20 = 1;
    L125:
        if (r2 == 0) goto L127;
        Map r21 = MapsKt.emptyMap();
    L129:
        if (ComposerKt.isTraceInProgress() == false) goto L131;
        ComposerKt.traceEventStart(851408699, r3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:448)");
    L131:
        int r24 = ((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (r3 & 234881024);
        m1354BasicTextCL7eQgs(r27, r7, r10, r11, r17, r18, r19, r20, r21, null, null, r1, r24, 0, 1536);
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventEnd();
    L134:
        final TextStyle r22 = r10;
        final int r23 = r17;
        final int r25 = r19;
        final Map r26 = r21;
        final Modifier r39 = r7;
        final Function1 r40 = r11;
        final boolean r41 = r18;
        final int r42 = r20;
    L136:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L140;
        r110.updateScope(new l0(r27, r39, r22, r40, r23, r41, r25, r42, r26, r37, r38));
        return;
    L140:
        return;
    L127:
        r21 = r35;
        goto L129
    L124:
        r20 = r34;
        goto L125
    L121:
        r19 = r33;
        goto L122
    L118:
        r18 = r15;
        goto L119
    L115:
        r17 = r13;
        goto L116
    L112:
        r11 = r9;
        goto L113
    L109:
        r10 = r29;
        goto L110
    L106:
        r7 = r28;
        goto L107
    L135:
        r1.skipToGroupEnd();
        r39 = r28;
        r22 = r29;
        r25 = r33;
        r42 = r34;
        r40 = r9;
        r23 = r13;
        r41 = r15;
        r26 = r35;
        goto L136
    L101:
        r5 = false;
        goto L103
    L92:
        if ((r37 & 100663296) != 0) goto L99;
        if (r1.changedInstance(r35) == false) goto L96;
        int r111 = 67108864;
    L97:
        r3 = r3 | r111;
        goto L99
    L96:
        r111 = 33554432;
        goto L97
    L82:
        if ((r37 & 12582912) != 0) goto L88;
        if (r1.changed(r34) == false) goto L86;
        int r112 = 8388608;
    L87:
        r3 = r3 | r112;
        goto L88
    L86:
        r112 = 4194304;
        goto L87
    L72:
        if ((r37 & 1572864) != 0) goto L78;
        if (r1.changed(r33) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L78
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r37) != 0) goto L67;
        r15 = r32;
        if (r1.changed(r15) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r37 & 24576) != 0) goto L56;
        r13 = r31;
        if (r1.changed(r13) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r37 & 3072) != 0) goto L45;
        r9 = r30;
        if (r1.changedInstance(r9) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L46
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r37 & 384) != 0) goto L35;
        if (r1.changed(r29) == false) goto L32;
        int r43 = 256;
    L33:
        r3 = r3 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r1.changed(r28) == false) goto L21;
        int r44 = 32;
    L22:
        r3 = r3 | r44;
        goto L24
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r3 = r37;
        goto L13
    L8:
        if (r1.changed(r27) == false) goto L10;
        int r45 = 4;
    L11:
        r3 = r45 | r37;
        goto L13
    L10:
        r45 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-VhcvRP8, reason: not valid java name */
    public static final /* synthetic */ void m1358BasicTextVhcvRP8(final String r26, Modifier r27, TextStyle r28, Function1 r29, int r30, boolean r31, int r32, int r33, ColorProducer r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(-1186827822);
        if ((r37 & 1) == 0) goto L6;
        int r3 = r36 | 6;
    L13:
        int r4 = r37 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r37 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r37 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Function1 r9 = r29;
    L46:
        int r12 = r37 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r13 = r30;
    L57:
        int r14 = r37 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r15 = r31;
    L68:
        int r16 = r37 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r37 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        int r2 = r37 & 256;
        if (r2 == 0) goto L92;
        r3 = r3 | 100663296;
    L99:
        if ((r3 & 38347923) == 38347922) goto L101;
        boolean r5 = true;
    L103:
        if (r1.shouldExecute(r5, r3 & 1) == false) goto L135;
        if (r4 == 0) goto L106;
        Modifier r7 = Modifier.Companion;
    L107:
        if (r6 == 0) goto L109;
        TextStyle r10 = TextStyle.Companion.getDefault();
    L110:
        ColorProducer r11 = null;
        if (r8 == 0) goto L113;
        r9 = null;
    L113:
        if (r12 == 0) goto L115;
        int r17 = TextOverflow.Companion.getClip-gIe3tQ8();
    L116:
        if (r14 == 0) goto L118;
        boolean r18 = true;
    L119:
        if (r16 == 0) goto L121;
        int r25 = Integer.MAX_VALUE;
    L122:
        if (r0 == 0) goto L124;
        int r19 = 1;
    L125:
        if (r2 != 0) goto L129;
        r11 = r34;
    L129:
        if (ComposerKt.isTraceInProgress() == false) goto L131;
        ComposerKt.traceEventStart(-1186827822, r3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:317)");
    L131:
        m1356BasicTextRWo7tUw(r26, r7, r10, r9, r17, r18, r25, r19, r11, null, r1, ((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (r3 & 234881024), 512);
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventEnd();
    L134:
        final Modifier r20 = r7;
        final TextStyle r21 = r10;
        final int r22 = r17;
        final Function1 r23 = r9;
        final int r24 = r25;
        final ColorProducer r38 = r11;
        final boolean r39 = r18;
        final int r40 = r19;
    L136:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L140;
        r110.updateScope(new o0(r26, r20, r21, r23, r22, r39, r24, r40, r38, r36, r37));
        return;
    L140:
        return;
    L124:
        r19 = r33;
        goto L125
    L121:
        r25 = r32;
        goto L122
    L118:
        r18 = r15;
        goto L119
    L115:
        r17 = r13;
        goto L116
    L109:
        r10 = r28;
        goto L110
    L106:
        r7 = r27;
        goto L107
    L135:
        r1.skipToGroupEnd();
        r20 = r27;
        r21 = r28;
        r24 = r32;
        r40 = r33;
        r23 = r9;
        r22 = r13;
        r39 = r15;
        r38 = r34;
        goto L136
    L101:
        r5 = false;
        goto L103
    L92:
        if ((r36 & 100663296) != 0) goto L99;
        if (r1.changedInstance(r34) == false) goto L96;
        int r111 = 67108864;
    L97:
        r3 = r3 | r111;
        goto L99
    L96:
        r111 = 33554432;
        goto L97
    L82:
        if ((r36 & 12582912) != 0) goto L88;
        if (r1.changed(r33) == false) goto L86;
        int r112 = 8388608;
    L87:
        r3 = r3 | r112;
        goto L88
    L86:
        r112 = 4194304;
        goto L87
    L72:
        if ((r36 & 1572864) != 0) goto L78;
        if (r1.changed(r32) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L78
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r36) != 0) goto L67;
        r15 = r31;
        if (r1.changed(r15) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L50:
        if ((r36 & 24576) != 0) goto L56;
        r13 = r30;
        if (r1.changed(r13) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r36 & 3072) != 0) goto L45;
        r9 = r29;
        if (r1.changedInstance(r9) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L46
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r36 & 384) != 0) goto L35;
        if (r1.changed(r28) == false) goto L32;
        int r41 = 256;
    L33:
        r3 = r3 | r41;
        goto L35
    L32:
        r41 = 128;
        goto L33
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r1.changed(r27) == false) goto L21;
        int r42 = 32;
    L22:
        r3 = r3 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r3 = r36;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r43 = 4;
    L11:
        r3 = r43 | r36;
        goto L13
    L10:
        r43 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    public static final void m1356BasicTextRWo7tUw(final String r36, Modifier r37, TextStyle r38, Function1<? super TextLayoutResult, Unit> r39, int r40, boolean r41, int r42, int r43, ColorProducer r44, TextAutoSize r45, Composer r46, final int r47, final int r48) {
        Composer r3 = r46.startRestartGroup(-1040751001);
        if ((r48 & 1) == 0) goto L6;
        int r4 = r47 | 6;
    L13:
        int r6 = r48 & 2;
        if (r6 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r48 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r13 = r48 & 8;
        if (r13 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Function1<? super TextLayoutResult, Unit> r14 = r39;
    L46:
        int r15 = r48 & 16;
        if (r15 == 0) goto L50;
        r4 = r4 | 24576;
    L57:
        int r16 = r48 & 32;
        if (r16 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r17 = r48 & 64;
        if (r17 == 0) goto L71;
        r4 = r4 | 1572864;
    L77:
        int r2 = r48 & 128;
        if (r2 == 0) goto L81;
        r4 = r4 | 12582912;
    L87:
        int r5 = r48 & 256;
        if (r5 == 0) goto L91;
        r4 = r4 | 100663296;
    L97:
        int r7 = r48 & 512;
        int r19 = 805306368;
        if (r7 == 0) goto L101;
    L99:
        r4 = r4 | r19;
    L110:
        if ((r4 & 306783379) == 306783378) goto L112;
        boolean r0 = true;
    L114:
        if (r3.shouldExecute(r0, r4 & 1) == false) goto L183;
        if (r6 == 0) goto L117;
        Modifier r1 = Modifier.Companion;
    L118:
        if (r9 == 0) goto L120;
        TextStyle r8 = TextStyle.Companion.getDefault();
    L121:
        if (r13 == 0) goto L123;
        r14 = null;
    L123:
        if (r15 == 0) goto L125;
        int r10 = TextOverflow.Companion.getClip-gIe3tQ8();
    L126:
        if (r16 == 0) goto L128;
        boolean r18 = true;
    L129:
        if (r17 == 0) goto L131;
        int r110 = Integer.MAX_VALUE;
    L132:
        if (r2 == 0) goto L134;
        int r11 = 1;
    L135:
        if (r5 == 0) goto L137;
        ColorProducer r12 = null;
    L138:
        if (r7 == 0) goto L140;
        TextAutoSize r20 = null;
    L142:
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventStart(-1040751001, r4, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:102)");
    L144:
        HeightInLinesModifierKt.validateMinMaxLines(r11, r110);
        final SelectionRegistrar r21 = (SelectionRegistrar) r3.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
        if (r21 == null) goto L159;
        r3.startReplaceGroup(356434979);
        long r111 = ((TextSelectionColors) r3.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m1910getBackgroundColor0d7_KjU();
        Object[] r112 = {r21};
        Saver<Long, Long> r22 = selectionIdSaver(r21);
        boolean r113 = r3.changedInstance(r21);
        Object r23 = r3.rememberedValue();
        if (r113 == true) goto L151;
        int r35 = r11;
        if (r23 == Composer.Companion.getEmpty()) goto L152;
    L153:
        long r114 = ((Number) RememberSaveableKt.rememberSaveable(r112, r22, (Function0) r23, r3, 0)).longValue();
        boolean r24 = (r3.changed(r114) | r3.changed(r21)) | r3.changed(r111);
        Object r25 = r3.rememberedValue();
        if (r24 == false) goto L156;
    L157:
        r25 = new SelectionController(r114, r21, r111, null, 8, null);
        r3.updateRememberedValue(r25);
    L158:
        r3.endReplaceGroup();
        SelectionController r31 = (SelectionController) r25;
    L160:
        FontFamily.Resolver r26 = (FontFamily.Resolver) r3.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        BasicText_androidKt.BackgroundTextMeasurement(r36, r8, r26, r3, ((r4 >> 3) & 112) | (r4 & 14));
        if (r31 != null) goto L166;
        if (r14 != null) goto L166;
        if (r20 != null) goto L166;
        r3.startReplaceGroup(357887763);
        r3.endReplaceGroup();
        TextStringSimpleElement r27 = new TextStringSimpleElement(r36, r8, r26, r10, r18, r110, r35, r12, null);
        Modifier r28 = r1;
        Modifier r29 = r28.then(r27);
    L167:
        EmptyMeasurePolicy r30 = EmptyMeasurePolicy.INSTANCE;
        long r115 = ComposablesKt.getCurrentCompositeKeyHashCode(r3, 0);
        int r32 = (int) (r115 ^ (r115 >>> 32));
        Modifier r33 = ComposedModifierKt.materializeModifier(r3, r29);
        CompositionLocalMap r116 = r3.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion r117 = ComposeUiNode.Companion;
        Function0 r118 = r117.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L170;
        ComposablesKt.invalidApplier();
    L170:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L173;
        r3.createNode(r118);
    L174:
        Composer r119 = Updater.constructor-impl(r3);
        Updater.set-impl(r119, r30, r117.getSetMeasurePolicy());
        Updater.set-impl(r119, r116, r117.getSetResolvedCompositionLocals());
        Updater.set-impl(r119, r33, r117.getSetModifier());
        Function2 r34 = r117.getSetCompositeKeyHash();
        if (r119.getInserting() == false) goto L177;
    L178:
        r119.updateRememberedValue(Integer.valueOf(r32));
        r119.apply(Integer.valueOf(r32), r34);
    L179:
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L182;
        ComposerKt.traceEventEnd();
    L182:
        final TextAutoSize r120 = r20;
        final int r49 = r10;
        final Function1<? super TextLayoutResult, Unit> r50 = r14;
        final ColorProducer r51 = r12;
        final int r52 = r35;
        boolean r53 = r18;
        final Modifier r54 = r28;
    L184:
        ScopeUpdateScope r121 = r3.endRestartGroup();
        if (r121 == null) goto L188;
        final TextStyle r55 = r8;
        final boolean r56 = r53;
        final int r57 = r110;
        r121.updateScope(new q0(r36, r54, r55, r50, r49, r56, r57, r52, r51, r120, r47, r48));
        return;
    L188:
        return;
    L177:
        if (Intrinsics.areEqual(r119.rememberedValue(), Integer.valueOf(r32)) == true) goto L179;
    L173:
        r3.useNode();
    L166:
        r28 = r1;
        r3.startReplaceGroup(357244017);
        r29 = m1360textModifierCL7eQgs(r28, new AnnotatedString(r36, null, 2, null), r8, r14, r10, r18, r110, r35, (FontFamily.Resolver) r3.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), null, null, r31, r12, null, r20);
        r3.endReplaceGroup();
        goto L167
    L156:
        if (r25 != Composer.Companion.getEmpty()) goto L158;
    L152:
        r23 = new p0(r21);
        r3.updateRememberedValue(r23);
        goto L153
    L151:
        r35 = r11;
        goto L152
    L159:
        r35 = r11;
        r3.startReplaceGroup(356926143);
        r3.endReplaceGroup();
        r31 = null;
        goto L160
    L140:
        r20 = r45;
        goto L142
    L137:
        r12 = r44;
        goto L138
    L134:
        r11 = r43;
        goto L135
    L131:
        r110 = r42;
        goto L132
    L128:
        r18 = r41;
        goto L129
    L125:
        r10 = r40;
        goto L126
    L120:
        r8 = r38;
        goto L121
    L117:
        r1 = r37;
        goto L118
    L183:
        r3.skipToGroupEnd();
        r54 = r37;
        r8 = r38;
        r49 = r40;
        r53 = r41;
        r110 = r42;
        r52 = r43;
        r51 = r44;
        r120 = r45;
        r50 = r14;
        goto L184
    L112:
        r0 = false;
        goto L114
    L101:
        if ((r47 & 805306368) != 0) goto L110;
        if ((r47 & 1073741824) != 0) goto L105;
        boolean r122 = r3.changed(r45);
    L106:
        if (r122 == false) goto L108;
        r19 = 536870912;
        goto L99
    L108:
        r19 = 268435456;
        goto L99
    L105:
        r122 = r3.changedInstance(r45);
        goto L106
    L91:
        if ((r47 & 100663296) != 0) goto L97;
        if (r3.changedInstance(r44) == false) goto L95;
        int r123 = 67108864;
    L96:
        r4 = r4 | r123;
        goto L97
    L95:
        r123 = 33554432;
        goto L96
    L81:
        if ((r47 & 12582912) != 0) goto L87;
        if (r3.changed(r43) == false) goto L85;
        int r124 = 8388608;
    L86:
        r4 = r4 | r124;
        goto L87
    L85:
        r124 = 4194304;
        goto L86
    L71:
        if ((r47 & 1572864) != 0) goto L77;
        if (r3.changed(r42) == false) goto L75;
        int r125 = 1048576;
    L76:
        r4 = r4 | r125;
        goto L77
    L75:
        r125 = 524288;
        goto L76
    L61:
        if ((r47 & 196608) != 0) goto L67;
        if (r3.changed(r41) == false) goto L65;
        int r126 = 131072;
    L66:
        r4 = r4 | r126;
        goto L67
    L65:
        r126 = 65536;
        goto L66
    L50:
        if ((r47 & 24576) != 0) goto L57;
        if (r3.changed(r40) == false) goto L54;
        int r127 = 16384;
    L55:
        r4 = r4 | r127;
        goto L57
    L54:
        r127 = 8192;
        goto L55
    L39:
        if ((r47 & 3072) != 0) goto L45;
        r14 = r39;
        if (r3.changedInstance(r14) == false) goto L43;
        int r128 = 2048;
    L44:
        r4 = r4 | r128;
        goto L46
    L43:
        r128 = 1024;
        goto L44
    L28:
        if ((r47 & 384) != 0) goto L35;
        if (r3.changed(r38) == false) goto L32;
        int r129 = 256;
    L33:
        r4 = r4 | r129;
        goto L35
    L32:
        r129 = 128;
        goto L33
    L17:
        if ((r47 & 48) != 0) goto L24;
        if (r3.changed(r37) == false) goto L21;
        int r58 = 32;
    L22:
        r4 = r4 | r58;
        goto L24
    L21:
        r58 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r4 = r47;
        goto L13
    L8:
        if (r3.changed(r36) == false) goto L10;
        int r59 = 4;
    L11:
        r4 = r59 | r47;
        goto L13
    L10:
        r59 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: BasicText-RWo7tUw, reason: not valid java name */
    public static final /* synthetic */ void m1355BasicTextRWo7tUw(final AnnotatedString r29, Modifier r30, TextStyle r31, Function1 r32, int r33, boolean r34, int r35, int r36, Map r37, ColorProducer r38, Composer r39, final int r40, final int r41) {
        Composer r1 = r39.startRestartGroup(-1064305212);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L13:
        int r4 = r41 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r6 = r41 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L35:
        int r8 = r41 & 8;
        if (r8 == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r10 = r41 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r13 = r33;
    L57:
        int r14 = r41 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r15 = r34;
    L68:
        int r16 = r41 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r0 = r41 & 128;
        if (r0 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        int r2 = r41 & 256;
        if (r2 == 0) goto L92;
        r3 = r3 | 100663296;
    L98:
        int r5 = r41 & 512;
        if (r5 == 0) goto L102;
        r3 = r3 | 805306368;
    L109:
        if ((r3 & 306783379) == 306783378) goto L111;
        boolean r7 = true;
    L113:
        if (r1.shouldExecute(r7, r3 & 1) == false) goto L149;
        if (r4 == 0) goto L116;
        Modifier r9 = Modifier.Companion;
    L117:
        if (r6 == 0) goto L119;
        TextStyle r11 = TextStyle.Companion.getDefault();
    L120:
        ColorProducer r12 = null;
        if (r8 == 0) goto L123;
        Function1 r17 = null;
    L124:
        if (r10 == 0) goto L126;
        int r18 = TextOverflow.Companion.getClip-gIe3tQ8();
    L127:
        if (r14 == 0) goto L129;
        boolean r19 = true;
    L130:
        if (r16 == 0) goto L132;
        int r28 = Integer.MAX_VALUE;
    L133:
        if (r0 == 0) goto L135;
        int r20 = 1;
    L136:
        if (r2 == 0) goto L138;
        Map r21 = MapsKt.emptyMap();
    L139:
        if (r5 != 0) goto L143;
        r12 = r38;
    L143:
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventStart(-1064305212, r3, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:359)");
    L145:
        m1354BasicTextCL7eQgs(r29, r9, r11, r17, r18, r19, r28, r20, r21, r12, null, r1, (((((((((r3 & 14) | (r3 & 112)) | (r3 & 896)) | (r3 & 7168)) | (57344 & r3)) | (458752 & r3)) | (3670016 & r3)) | (29360128 & r3)) | (234881024 & r3)) | (r3 & 1879048192), 0, 1024);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        final TextStyle r22 = r11;
        final int r23 = r18;
        final boolean r24 = r19;
        final Map r25 = r21;
        final Modifier r26 = r9;
        final ColorProducer r110 = r12;
        final Function1 r27 = r17;
        final int r42 = r28;
        final int r43 = r20;
    L150:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L154;
        r111.updateScope(new y0(r29, r26, r22, r27, r23, r24, r42, r43, r25, r110, r40, r41));
        return;
    L154:
        return;
    L138:
        r21 = r37;
        goto L139
    L135:
        r20 = r36;
        goto L136
    L132:
        r28 = r35;
        goto L133
    L129:
        r19 = r15;
        goto L130
    L126:
        r18 = r13;
        goto L127
    L123:
        r17 = r32;
        goto L124
    L119:
        r11 = r31;
        goto L120
    L116:
        r9 = r30;
        goto L117
    L149:
        r1.skipToGroupEnd();
        r26 = r30;
        r22 = r31;
        r27 = r32;
        r42 = r35;
        r43 = r36;
        r25 = r37;
        r110 = r38;
        r23 = r13;
        r24 = r15;
        goto L150
    L111:
        r7 = false;
        goto L113
    L102:
        if ((r40 & 805306368) != 0) goto L109;
        if (r1.changedInstance(r38) == false) goto L106;
        int r112 = 536870912;
    L107:
        r3 = r3 | r112;
        goto L109
    L106:
        r112 = 268435456;
        goto L107
    L92:
        if ((r40 & 100663296) != 0) goto L98;
        if (r1.changedInstance(r37) == false) goto L96;
        int r113 = 67108864;
    L97:
        r3 = r3 | r113;
        goto L98
    L96:
        r113 = 33554432;
        goto L97
    L82:
        if ((r40 & 12582912) != 0) goto L88;
        if (r1.changed(r36) == false) goto L86;
        int r114 = 8388608;
    L87:
        r3 = r3 | r114;
        goto L88
    L86:
        r114 = 4194304;
        goto L87
    L72:
        if ((r40 & 1572864) != 0) goto L78;
        if (r1.changed(r35) == false) goto L76;
        int r115 = 1048576;
    L77:
        r3 = r3 | r115;
        goto L78
    L76:
        r115 = 524288;
        goto L77
    L61:
        if ((196608 & r40) != 0) goto L67;
        r15 = r34;
        if (r1.changed(r15) == false) goto L65;
        int r116 = 131072;
    L66:
        r3 = r3 | r116;
        goto L68
    L65:
        r116 = 65536;
        goto L66
    L50:
        if ((r40 & 24576) != 0) goto L56;
        r13 = r33;
        if (r1.changed(r13) == false) goto L54;
        int r117 = 16384;
    L55:
        r3 = r3 | r117;
        goto L57
    L54:
        r117 = 8192;
        goto L55
    L39:
        if ((r40 & 3072) != 0) goto L46;
        if (r1.changedInstance(r32) == false) goto L43;
        int r118 = 2048;
    L44:
        r3 = r3 | r118;
        goto L46
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r40 & 384) != 0) goto L35;
        if (r1.changed(r31) == false) goto L32;
        int r44 = 256;
    L33:
        r3 = r3 | r44;
        goto L35
    L32:
        r44 = 128;
        goto L33
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r1.changed(r30) == false) goto L21;
        int r45 = 32;
    L22:
        r3 = r3 | r45;
        goto L24
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L13
    L8:
        if (r1.changed(r29) == false) goto L10;
        int r46 = 4;
    L11:
        r3 = r46 | r40;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: BasicText-CL7eQgs, reason: not valid java name */
    public static final void m1354BasicTextCL7eQgs(final AnnotatedString r47, Modifier r48, TextStyle r49, Function1<? super TextLayoutResult, Unit> r50, int r51, boolean r52, int r53, int r54, Map<String, InlineTextContent> r55, ColorProducer r56, TextAutoSize r57, Composer r58, final int r59, final int r60, final int r61) {
        Composer r12 = r58.startRestartGroup(-1343466571);
        if ((r61 & 1) == 0) goto L6;
        int r2 = r59 | 6;
    L13:
        int r5 = r61 & 2;
        if (r5 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        int r7 = r61 & 4;
        if (r7 == 0) goto L28;
        r2 = r2 | 384;
    L35:
        int r9 = r61 & 8;
        if (r9 == 0) goto L39;
        r2 = r2 | 3072;
    L46:
        int r11 = r61 & 16;
        if (r11 == 0) goto L50;
        r2 = r2 | 24576;
    L57:
        int r17 = r61 & 32;
        if (r17 == 0) goto L61;
        r2 = r2 | 196608;
    L67:
        int r19 = r61 & 64;
        if (r19 == 0) goto L71;
        r2 = r2 | 1572864;
    L77:
        int r1 = r61 & 128;
        if (r1 == 0) goto L81;
        r2 = r2 | 12582912;
    L87:
        int r3 = r61 & 256;
        if (r3 == 0) goto L91;
        r2 = r2 | 100663296;
    L97:
        int r4 = r61 & 512;
        if (r4 == 0) goto L101;
        r2 = r2 | 805306368;
    L107:
        int r6 = r61 & 1024;
        if (r6 == 0) goto L112;
        int r21 = r60 | 6;
    L110:
        int r0 = r21;
    L122:
        boolean r13 = true;
        if ((r2 & 306783379) == 306783378) goto L125;
    L128:
        boolean r8 = true;
    L130:
        if (r12.shouldExecute(r8, r2 & 1) == false) goto L214;
        if (r5 == 0) goto L133;
        Modifier r35 = Modifier.Companion;
    L134:
        if (r7 == 0) goto L136;
        TextStyle r36 = TextStyle.Companion.getDefault();
    L138:
        if (r9 == 0) goto L140;
        Function1<? super TextLayoutResult, Unit> r37 = null;
    L141:
        if (r11 == 0) goto L143;
        int r38 = TextOverflow.Companion.getClip-gIe3tQ8();
    L144:
        if (r17 == 0) goto L146;
        boolean r39 = true;
    L147:
        if (r19 == 0) goto L149;
        int r14 = Integer.MAX_VALUE;
    L150:
        if (r1 == 0) goto L152;
        int r10 = 1;
    L153:
        if (r3 == 0) goto L155;
        Map<String, InlineTextContent> r40 = MapsKt.emptyMap();
    L156:
        if (r4 == 0) goto L158;
        ColorProducer r41 = null;
    L159:
        if (r6 == 0) goto L161;
        TextAutoSize r42 = null;
    L163:
        if (ComposerKt.isTraceInProgress() == false) goto L165;
        ComposerKt.traceEventStart(-1343466571, r2, r0, "androidx.compose.foundation.text.BasicText (BasicText.kt:200)");
    L165:
        HeightInLinesModifierKt.validateMinMaxLines(r10, r14);
        final SelectionRegistrar r15 = (SelectionRegistrar) r12.consume(SelectionRegistrarKt.getLocalSelectionRegistrar());
        if (r15 == null) goto L178;
        r12.startReplaceGroup(1588280149);
        long r16 = ((TextSelectionColors) r12.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m1910getBackgroundColor0d7_KjU();
        Object[] r18 = {r15};
        Saver<Long, Long> r20 = selectionIdSaver(r15);
        boolean r22 = r12.changedInstance(r15);
        Object r23 = r12.rememberedValue();
        if (r22 == false) goto L170;
    L171:
        r23 = new u0(r15);
        r12.updateRememberedValue(r23);
    L172:
        long r24 = ((Number) RememberSaveableKt.rememberSaveable(r18, r20, (Function0) r23, r12, 0)).longValue();
        boolean r25 = (r12.changed(r24) | r12.changed(r15)) | r12.changed(r16);
        Object r26 = r12.rememberedValue();
        if (r25 == false) goto L175;
    L176:
        r26 = new SelectionController(r24, r15, r16, null, 8, null);
        r12.updateRememberedValue(r26);
    L177:
        r12.endReplaceGroup();
        SelectionController r27 = (SelectionController) r26;
    L179:
        boolean r110 = AnnotatedStringResolveInlineContentKt.hasInlineContent(r47);
        boolean r28 = TextAnnotatedStringNodeKt.hasLinks(r47);
        FontFamily.Resolver r29 = (FontFamily.Resolver) r12.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        if (r110 == true) goto L195;
        if (r28 == true) goto L195;
        r12.startReplaceGroup(1589018166);
        BasicText_androidKt.BackgroundTextMeasurement(r47, r36, r29, null, r12, ((r2 & 14) | 3072) | ((r2 >> 3) & 112));
        int r43 = r10;
        int r44 = r14;
        Modifier r30 = m1360textModifierCL7eQgs(r35, r47, r36, r37, r38, r39, r14, r10, r29, null, null, r27, r41, null, r42);
        EmptyMeasurePolicy r31 = EmptyMeasurePolicy.INSTANCE;
        Composer r32 = r12;
        long r33 = ComposablesKt.getCurrentCompositeKeyHashCode(r32, 0);
        int r34 = (int) (r33 ^ (r33 >>> 32));
        Modifier r45 = ComposedModifierKt.materializeModifier(r32, r30);
        CompositionLocalMap r46 = r32.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion r62 = ComposeUiNode.Companion;
        Function0 r63 = r62.getConstructor();
        if ((r32.getApplier() instanceof Applier) == true) goto L185;
        ComposablesKt.invalidApplier();
    L185:
        r32.startReusableNode();
        if (r32.getInserting() == false) goto L188;
        r32.createNode(r63);
    L189:
        Composer r64 = Updater.constructor-impl(r32);
        Updater.set-impl(r64, r31, r62.getSetMeasurePolicy());
        Updater.set-impl(r64, r46, r62.getSetResolvedCompositionLocals());
        Updater.set-impl(r64, r45, r62.getSetModifier());
        Function2 r65 = r62.getSetCompositeKeyHash();
        if (r64.getInserting() == false) goto L192;
    L193:
        r64.updateRememberedValue(Integer.valueOf(r34));
        r64.apply(Integer.valueOf(r34), r65);
    L194:
        r32.endNode();
        r32.endReplaceGroup();
    L211:
        if (ComposerKt.isTraceInProgress() == false) goto L213;
        ComposerKt.traceEventEnd();
    L213:
        final Modifier r66 = r35;
        final Function1<? super TextLayoutResult, Unit> r67 = r37;
        final int r68 = r38;
        final boolean r69 = r39;
        final Map<String, InlineTextContent> r70 = r40;
        final ColorProducer r111 = r41;
        final TextAutoSize r112 = r42;
        final int r71 = r43;
        final int r72 = r44;
    L215:
        ScopeUpdateScope r113 = r32.endRestartGroup();
        if (r113 == null) goto L219;
        final TextStyle r73 = r36;
        r113.updateScope(new x0(r47, r66, r73, r67, r68, r69, r72, r71, r70, r111, r112, r59, r60, r61));
        return;
    L219:
        return;
    L192:
        if (Intrinsics.areEqual(r64.rememberedValue(), Integer.valueOf(r34)) == true) goto L194;
    L188:
        r32.useNode();
    L195:
        r43 = r10;
        r44 = r14;
        r32 = r12;
        r32.startReplaceGroup(1590033974);
        if ((r2 & 14) == 4) goto L199;
        r13 = false;
    L199:
        Object r74 = r32.rememberedValue();
        if (r13 == false) goto L202;
    L203:
        r74 = SnapshotStateKt.mutableStateOf$default(r47, null, 2, null);
        r32.updateRememberedValue(r74);
    L204:
        final MutableState r75 = (MutableState) r74;
        AnnotatedString r114 = BasicText_CL7eQgs$lambda$8(r75);
        boolean r76 = r32.changed(r75);
        Object r77 = r32.rememberedValue();
        if (r76 == false) goto L207;
    L208:
        r77 = new v0(r75);
        r32.updateRememberedValue(r77);
    L209:
        int r78 = r2 >> 3;
        int r79 = r2 << 6;
        m1359LayoutWithLinksAndInlineContent11Od_4g(r35, r114, r37, r110, r40, r36, r38, r39, r44, r43, r29, r27, r41, (Function1) r77, r42, r32, (((((((r78 & 896) | (r78 & 14)) | ((r2 >> 12) & 57344)) | ((r2 << 9) & 458752)) | (3670016 & r79)) | (29360128 & r79)) | (234881024 & r79)) | (r79 & 1879048192), ((r2 >> 21) & 896) | ((r0 << 12) & 57344), 0);
        r32.endReplaceGroup();
        goto L211
    L207:
        if (r77 != Composer.Companion.getEmpty()) goto L209;
    L202:
        if (r74 != Composer.Companion.getEmpty()) goto L204;
    L175:
        if (r26 != Composer.Companion.getEmpty()) goto L177;
    L170:
        if (r23 != Composer.Companion.getEmpty()) goto L172;
    L178:
        r12.startReplaceGroup(1588771313);
        r12.endReplaceGroup();
        r27 = null;
        goto L179
    L161:
        r42 = r57;
        goto L163
    L158:
        r41 = r56;
        goto L159
    L155:
        r40 = r55;
        goto L156
    L152:
        r10 = r54;
        goto L153
    L149:
        r14 = r53;
        goto L150
    L146:
        r39 = r52;
        goto L147
    L143:
        r38 = r51;
        goto L144
    L140:
        r37 = r50;
        goto L141
    L136:
        r36 = r49;
        goto L138
    L133:
        r35 = r48;
        goto L134
    L214:
        r32 = r12;
        r32.skipToGroupEnd();
        r66 = r48;
        r36 = r49;
        r67 = r50;
        r68 = r51;
        r69 = r52;
        r72 = r53;
        r71 = r54;
        r70 = r55;
        r111 = r56;
        r112 = r57;
        goto L215
    L125:
        if ((r0 & 3) != 2) goto L128;
        r8 = false;
        goto L130
    L112:
        if ((r60 & 6) == 0) goto L114;
        r0 = r60;
        goto L122
    L114:
        if ((r60 & 8) != 0) goto L116;
        boolean r210 = r12.changed(r57);
    L117:
        if (r210 == false) goto L119;
        int r211 = 4;
    L120:
        r21 = r60 | r211;
        goto L110
    L119:
        r211 = 2;
        goto L120
    L116:
        r210 = r12.changedInstance(r57);
        goto L117
    L101:
        if ((r59 & 805306368) != 0) goto L107;
        if (r12.changedInstance(r56) == false) goto L105;
        int r212 = 536870912;
    L106:
        r2 = r2 | r212;
        goto L107
    L105:
        r212 = 268435456;
        goto L106
    L91:
        if ((r59 & 100663296) != 0) goto L97;
        if (r12.changedInstance(r55) == false) goto L95;
        int r213 = 67108864;
    L96:
        r2 = r2 | r213;
        goto L97
    L95:
        r213 = 33554432;
        goto L96
    L81:
        if ((r59 & 12582912) != 0) goto L87;
        if (r12.changed(r54) == false) goto L85;
        int r214 = 8388608;
    L86:
        r2 = r2 | r214;
        goto L87
    L85:
        r214 = 4194304;
        goto L86
    L71:
        if ((r59 & 1572864) != 0) goto L77;
        if (r12.changed(r53) == false) goto L75;
        int r215 = 1048576;
    L76:
        r2 = r2 | r215;
        goto L77
    L75:
        r215 = 524288;
        goto L76
    L61:
        if ((r59 & 196608) != 0) goto L67;
        if (r12.changed(r52) == false) goto L65;
        int r115 = 131072;
    L66:
        r2 = r2 | r115;
        goto L67
    L65:
        r115 = 65536;
        goto L66
    L50:
        if ((r59 & 24576) != 0) goto L57;
        if (r12.changed(r51) == false) goto L54;
        int r116 = 16384;
    L55:
        r2 = r2 | r116;
        goto L57
    L54:
        r116 = 8192;
        goto L55
    L39:
        if ((r59 & 3072) != 0) goto L46;
        if (r12.changedInstance(r50) == false) goto L43;
        int r117 = 2048;
    L44:
        r2 = r2 | r117;
        goto L46
    L43:
        r117 = 1024;
        goto L44
    L28:
        if ((r59 & 384) != 0) goto L35;
        if (r12.changed(r49) == false) goto L32;
        int r80 = 256;
    L33:
        r2 = r2 | r80;
        goto L35
    L32:
        r80 = 128;
        goto L33
    L17:
        if ((r59 & 48) != 0) goto L24;
        if (r12.changed(r48) == false) goto L21;
        int r81 = 32;
    L22:
        r2 = r2 | r81;
        goto L24
    L21:
        r81 = 16;
        goto L22
    L6:
        if ((r59 & 6) == 0) goto L8;
        r2 = r59;
        goto L13
    L8:
        if (r12.changed(r47) == false) goto L10;
        int r82 = 4;
    L11:
        r2 = r82 | r59;
        goto L13
    L10:
        r82 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: textModifier-CL7eQgs, reason: not valid java name */
    private static final Modifier m1360textModifierCL7eQgs(Modifier r19, AnnotatedString r20, TextStyle r21, Function1<? super TextLayoutResult, Unit> r22, int r23, boolean r24, int r25, int r26, FontFamily.Resolver r27, List<AnnotatedString.Range<Placeholder>> r28, Function1<? super List<Rect>, Unit> r29, SelectionController r30, ColorProducer r31, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> r32, TextAutoSize r33) {
        if (r30 != null) goto L6;
        TextAnnotatedStringElement r15 = new TextAnnotatedStringElement(r20, r21, r27, r22, r23, r24, r25, r26, r28, r29, null, r31, r33, r32, null);
        return r19.then(Modifier.Companion).then(r15);
    L6:
        SelectableTextAnnotatedStringElement r16 = new SelectableTextAnnotatedStringElement(r20, r21, r27, r22, r23, r24, r25, r26, r28, r29, r30, r31, r33, null);
        return r19.then(r30.getModifier()).then(r16);
    }

    /* JADX INFO: renamed from: LayoutWithLinksAndInlineContent-11Od_4g, reason: not valid java name */
    private static final void m1359LayoutWithLinksAndInlineContent11Od_4g(final Modifier r31, final AnnotatedString r32, final Function1<? super TextLayoutResult, Unit> r33, final boolean r34, Map<String, InlineTextContent> r35, final TextStyle r36, final int r37, final boolean r38, final int r39, final int r40, final FontFamily.Resolver r41, final SelectionController r42, final ColorProducer r43, final Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> r44, final TextAutoSize r45, Composer r46, final int r47, final int r48, final int r49) {
        Composer r11 = r46.startRestartGroup(-2118572703);
        if ((r49 & 1) == 0) goto L6;
        int r1 = r47 | 6;
    L14:
        if ((r49 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r16 = 128;
        if ((r49 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r17 = 2048;
        if ((r49 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r4 = r49 & 16;
        int r19 = 16384;
        if (r4 == 0) goto L47;
        r1 = r1 | 24576;
    L55:
        if ((r49 & 32) == 0) goto L58;
        r1 = r1 | 196608;
    L65:
        if ((r49 & 64) == 0) goto L68;
        r1 = r1 | 1572864;
    L75:
        if ((r49 & 128) == 0) goto L78;
        r1 = r1 | 12582912;
    L86:
        if ((r49 & 256) == 0) goto L89;
        r1 = r1 | 100663296;
    L97:
        if ((r49 & 512) == 0) goto L100;
        r1 = r1 | 805306368;
    L108:
        if ((r49 & 1024) == 0) goto L111;
        int r21 = r48 | 6;
    L119:
        if ((r49 & 2048) == 0) goto L122;
        r21 = r21 | 48;
    L129:
        int r0 = r21;
        if ((r49 & 4096) == 0) goto L133;
        r0 = r0 | 384;
    L140:
        if ((r49 & 8192) == 0) goto L143;
        r0 = r0 | 3072;
    L151:
        if ((r49 & 16384) == 0) goto L154;
        r0 = r0 | 24576;
    L163:
        boolean r18 = true;
        if ((306783379 & r1) == 306783378) goto L166;
    L169:
        boolean r2 = true;
    L171:
        if (r11.shouldExecute(r2, r1 & 1) == false) goto L285;
        if (r4 == 0) goto L174;
        Map<String, InlineTextContent> r5 = MapsKt.emptyMap();
    L176:
        if (ComposerKt.isTraceInProgress() == false) goto L179;
        ComposerKt.traceEventStart(-2118572703, r1, r0, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:646)");
    L179:
        if (TextAnnotatedStringNodeKt.hasLinks(r32) == false) goto L190;
        r11.startReplaceGroup(145661411);
        if ((r1 & 112) != 32) goto L183;
        boolean r3 = true;
    L184:
        Object r15 = r11.rememberedValue();
        if (r3 == false) goto L187;
    L188:
        r15 = new TextLinkScope(r32);
        r11.updateRememberedValue(r15);
    L189:
        final TextLinkScope r110 = (TextLinkScope) r15;
        r11.endReplaceGroup();
    L192:
        if (TextAnnotatedStringNodeKt.hasLinks(r32) == false) goto L203;
        r11.startReplaceGroup(145925283);
        if ((r1 & 112) != 32) goto L196;
        boolean r6 = true;
    L197:
        boolean r7 = r6 | r11.changed(r110);
        Object r8 = r11.rememberedValue();
        if (r7 == false) goto L200;
    L201:
        r8 = new a1(r110, r32);
        r11.updateRememberedValue(r8);
    L202:
        Function0 r9 = (Function0) r8;
        r11.endReplaceGroup();
    L213:
        Function0 r111 = r9;
        if (r34 == false) goto L216;
        Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> r10 = AnnotatedStringResolveInlineContentKt.resolveInlineContent(r32, r5);
    L217:
        List r112 = (List) r10.component1();
        List r12 = (List) r10.component2();
        if (r34 == false) goto L224;
        r11.startReplaceGroup(146338668);
        Object r13 = r11.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L222;
        Function1 r14 = null;
        r13 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r11.updateRememberedValue(r13);
    L223:
        final MutableState r20 = (MutableState) r13;
        r11.endReplaceGroup();
    L225:
        if (r34 == false) goto L232;
        r11.startReplaceGroup(146519677);
        boolean r22 = r11.changed(r20);
        Object r23 = r11.rememberedValue();
        if (r22 == false) goto L229;
    L230:
        r23 = new c1(r20);
        r11.updateRememberedValue(r23);
    L231:
        r11.endReplaceGroup();
        Function1 r24 = (Function1) r23;
    L233:
        int r25 = (r1 >> 3) & 14;
        int r26 = r1;
        final MutableState r27 = r20;
        Map<String, InlineTextContent> r28 = r5;
        BasicText_androidKt.BackgroundTextMeasurement(r32, r36, r41, r112, r11, (((r1 >> 12) & 112) | r25) | ((r0 << 6) & 896));
        AnnotatedString r29 = (AnnotatedString) r111.invoke();
        boolean r30 = r11.changedInstance(r110);
        if ((r26 & 896) == 256) goto L237;
        r18 = false;
    L237:
        boolean r50 = r30 | r18;
        Object r51 = r11.rememberedValue();
        if (r50 == false) goto L240;
    L241:
        r51 = new d1(r110, r33);
        r11.updateRememberedValue(r51);
    L242:
        Composer r52 = r11;
        final TextLinkScope r53 = r110;
        Modifier r54 = m1360textModifierCL7eQgs(r31, r29, r36, (Function1) r51, r37, r38, r39, r40, r41, r112, r24, r42, r43, r44, r45);
        if (r34 == true) goto L250;
        r52.startReplaceGroup(147770775);
        boolean r55 = r52.changedInstance(r53);
        Object r56 = r52.rememberedValue();
        if (r55 == false) goto L247;
    L248:
        r56 = new e1(r53);
        r52.updateRememberedValue(r56);
    L249:
        Object r57 = new LinksTextMeasurePolicy((Function0) r56);
        r52.endReplaceGroup();
    L261:
        long r58 = ComposablesKt.getCurrentCompositeKeyHashCode(r52, 0);
        int r59 = (int) (r58 ^ (r58 >>> 32));
        CompositionLocalMap r60 = r52.getCurrentCompositionLocalMap();
        Modifier r61 = ComposedModifierKt.materializeModifier(r52, r54);
        ComposeUiNode.Companion r62 = ComposeUiNode.Companion;
        Function0 r113 = r62.getConstructor();
        if ((r52.getApplier() instanceof Applier) == true) goto L264;
        ComposablesKt.invalidApplier();
    L264:
        r52.startReusableNode();
        if (r52.getInserting() == false) goto L267;
        r52.createNode(r113);
    L268:
        Composer r114 = Updater.constructor-impl(r52);
        Updater.set-impl(r114, r57, r62.getSetMeasurePolicy());
        Updater.set-impl(r114, r60, r62.getSetResolvedCompositionLocals());
        Function2 r63 = r62.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L271;
    L272:
        r114.updateRememberedValue(Integer.valueOf(r59));
        r114.apply(Integer.valueOf(r59), r63);
    L273:
        Updater.set-impl(r114, r61, r62.getSetModifier());
        if (r53 != null) goto L276;
        r52.startReplaceGroup(-433557001);
        r52.endReplaceGroup();
    L278:
        if (r12 != null) goto L280;
        r52.startReplaceGroup(-433506223);
        r52.endReplaceGroup();
    L281:
        r52.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L284;
        ComposerKt.traceEventEnd();
    L284:
        final Map<String, InlineTextContent> r64 = r28;
    L286:
        ScopeUpdateScope r115 = r52.endRestartGroup();
        if (r115 == null) goto L290;
        r115.updateScope(new n0(r31, r32, r33, r34, r64, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r47, r48, r49));
        return;
    L290:
        return;
    L280:
        r52.startReplaceGroup(-433506222);
        AnnotatedStringResolveInlineContentKt.InlineChildren(r32, r12, r52, r25);
        Unit r65 = Unit.INSTANCE;
        r52.endReplaceGroup();
        goto L281
    L276:
        r52.startReplaceGroup(-291080374);
        r53.LinksComposables(r52, 0);
        r52.endReplaceGroup();
        Unit r66 = Unit.INSTANCE;
        goto L278
    L271:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r59)) == true) goto L273;
    L267:
        r52.useNode();
        goto L268
    L247:
        if (r56 != Composer.Companion.getEmpty()) goto L249;
    L250:
        r52.startReplaceGroup(147947537);
        boolean r67 = r52.changedInstance(r53);
        Object r68 = r52.rememberedValue();
        if (r67 == false) goto L253;
    L254:
        r68 = new f1(r53);
        r52.updateRememberedValue(r68);
    L255:
        Function0 r69 = (Function0) r68;
        boolean r70 = r52.changed(r27);
        Object r116 = r52.rememberedValue();
        if (r70 == false) goto L258;
    L259:
        r116 = new m0(r27);
        r52.updateRememberedValue(r116);
    L260:
        r57 = new TextMeasurePolicy(r69, (Function0) r116);
        r52.endReplaceGroup();
        goto L261
    L258:
        if (r116 != Composer.Companion.getEmpty()) goto L260;
    L253:
        if (r68 != Composer.Companion.getEmpty()) goto L255;
    L240:
        if (r51 != Composer.Companion.getEmpty()) goto L242;
    L229:
        if (r23 != Composer.Companion.getEmpty()) goto L231;
    L232:
        r11.startReplaceGroup(146591100);
        r11.endReplaceGroup();
        r24 = r14;
        goto L233
    L222:
        r14 = null;
        goto L223
    L224:
        r14 = null;
        r11.startReplaceGroup(146426428);
        r11.endReplaceGroup();
        r20 = null;
        goto L225
    L216:
        r10 = new Pair(null, null);
        goto L217
    L200:
        if (r8 != Composer.Companion.getEmpty()) goto L202;
    L196:
        r6 = false;
        goto L197
    L203:
        r11.startReplaceGroup(146022561);
        if ((r1 & 112) != 32) goto L206;
        boolean r71 = true;
    L207:
        Object r72 = r11.rememberedValue();
        if (r71 == false) goto L210;
    L211:
        r72 = new b1(r32);
        r11.updateRememberedValue(r72);
    L212:
        r9 = (Function0) r72;
        r11.endReplaceGroup();
        goto L213
    L210:
        if (r72 != Composer.Companion.getEmpty()) goto L212;
    L206:
        r71 = false;
        goto L207
    L187:
        if (r15 != Composer.Companion.getEmpty()) goto L189;
    L183:
        r3 = false;
        goto L184
    L190:
        r11.startReplaceGroup(145727068);
        r11.endReplaceGroup();
        r110 = null;
        goto L192
    L174:
        r5 = r35;
        goto L176
    L285:
        r52 = r11;
        r52.skipToGroupEnd();
        r64 = r35;
        goto L286
    L166:
        if ((r0 & 9363) != 9362) goto L169;
        r2 = false;
        goto L171
    L154:
        if ((r48 & 24576) != 0) goto L163;
        if ((32768 & r48) != 0) goto L158;
        boolean r73 = r11.changed(r45);
    L159:
        if (r73 == true) goto L162;
        r19 = 8192;
    L162:
        r0 = r0 | r19;
        goto L163
    L158:
        r73 = r11.changedInstance(r45);
        goto L159
    L143:
        if ((r48 & 3072) != 0) goto L151;
        if (r11.changedInstance(r44) == true) goto L148;
        r17 = 1024;
    L148:
        r0 = r0 | r17;
        goto L151
    L133:
        if ((r48 & 384) != 0) goto L140;
        if (r11.changedInstance(r43) == false) goto L137;
        r16 = 256;
    L137:
        r0 = r0 | r16;
        goto L140
    L122:
        if ((r48 & 48) != 0) goto L129;
        if (r11.changedInstance(r42) == false) goto L126;
        int r210 = 32;
    L127:
        r21 = r21 | r210;
        goto L129
    L126:
        r210 = 16;
        goto L127
    L111:
        if ((r48 & 6) == 0) goto L113;
        r21 = r48;
        goto L119
    L113:
        if (r11.changedInstance(r41) == false) goto L115;
        int r211 = 4;
    L116:
        r21 = r48 | r211;
        goto L119
    L115:
        r211 = 2;
        goto L116
    L100:
        if ((805306368 & r47) != 0) goto L108;
        if (r11.changed(r40) == false) goto L104;
        int r212 = 536870912;
    L105:
        r1 = r1 | r212;
        goto L108
    L104:
        r212 = 268435456;
        goto L105
    L89:
        if ((100663296 & r47) != 0) goto L97;
        if (r11.changed(r39) == false) goto L93;
        int r213 = 67108864;
    L94:
        r1 = r1 | r213;
        goto L97
    L93:
        r213 = 33554432;
        goto L94
    L78:
        if ((12582912 & r47) != 0) goto L86;
        if (r11.changed(r38) == false) goto L82;
        int r214 = 8388608;
    L83:
        r1 = r1 | r214;
        goto L86
    L82:
        r214 = 4194304;
        goto L83
    L68:
        if ((r47 & 1572864) != 0) goto L75;
        if (r11.changed(r37) == false) goto L72;
        int r215 = 1048576;
    L73:
        r1 = r1 | r215;
        goto L75
    L72:
        r215 = 524288;
        goto L73
    L58:
        if ((r47 & 196608) != 0) goto L65;
        if (r11.changed(r36) == false) goto L62;
        int r216 = 131072;
    L63:
        r1 = r1 | r216;
        goto L65
    L62:
        r216 = 65536;
        goto L63
    L47:
        if ((r47 & 24576) != 0) goto L55;
        if (r11.changedInstance(r35) == false) goto L51;
        int r217 = 16384;
    L52:
        r1 = r1 | r217;
        goto L55
    L51:
        r217 = 8192;
        goto L52
    L37:
        if ((r47 & 3072) != 0) goto L43;
        if (r11.changed(r34) == false) goto L41;
        int r74 = 2048;
    L42:
        r1 = r1 | r74;
        goto L43
    L41:
        r74 = 1024;
        goto L42
    L27:
        if ((r47 & 384) != 0) goto L33;
        if (r11.changedInstance(r33) == false) goto L31;
        int r75 = 256;
    L32:
        r1 = r1 | r75;
        goto L33
    L31:
        r75 = 128;
        goto L32
    L17:
        if ((r47 & 48) != 0) goto L23;
        if (r11.changed(r32) == false) goto L21;
        int r76 = 32;
    L22:
        r1 = r1 | r76;
        goto L23
    L21:
        r76 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r1 = r47;
        goto L14
    L8:
        if (r11.changed(r31) == false) goto L10;
        int r77 = 4;
    L11:
        r1 = r77 | r47;
        goto L14
    L10:
        r77 = 2;
        goto L11
    }
}
