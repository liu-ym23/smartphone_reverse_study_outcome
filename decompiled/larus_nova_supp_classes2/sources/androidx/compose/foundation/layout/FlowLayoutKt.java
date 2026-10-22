package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001aq\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u001a2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010!\u001a=\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010(\u001a=\u0010)\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010*\u001aT\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0082\b\u001a\u0091\u0001\u00103\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b\u001a[\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0002¢\u0006\u0002\u0010<\u001a\u0096\u0001\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b¢\u0006\u0002\u0010=\u001aY\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0000¢\u0006\u0004\bK\u0010L\u001a\u001e\u0010M\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002\u001a\u001c\u0010P\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u00104\u001a\u00020\u000bH\u0000\u001a\u001c\u0010S\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u0010/\u001a\u00020\u000bH\u0000\u001a9\u0010Z\u001a\u000207*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020[2\u0014\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0004\b^\u0010_\u001aQ\u0010`\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002092\f\u0010c\u001a\b\u0012\u0004\u0012\u00020?0d2\u0006\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u000209H\u0000¢\u0006\u0004\bg\u0010h\"\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W\"\u0014\u0010X\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010W¨\u0006i"}, d2 = {"FlowRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "maxIntrinsicMainAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisAvailable", "mainAxisSpacing", "minIntrinsicMainAxisSize", "crossAxisSize", "crossAxisSpacing", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "mainAxisSizes", "", "crossAxisSizes", "mainAxisAvailable", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "mainAxisMin", "isHorizontal", "", "crossAxisMin", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = null;
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = null;

    private static final Unit FlowColumn$lambda$6(Modifier r12, Arrangement.Vertical r13, Arrangement.Horizontal r14, Alignment.Horizontal r15, int r16, int r17, FlowColumnOverflow r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        FlowColumn(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit FlowColumn$lambda$7(Modifier r11, Arrangement.Vertical r12, Arrangement.Horizontal r13, Alignment.Horizontal r14, int r15, int r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        FlowColumn(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit FlowRow$lambda$2(Modifier r12, Arrangement.Horizontal r13, Arrangement.Vertical r14, Alignment.Vertical r15, int r16, int r17, FlowRowOverflow r18, Function3 r19, int r20, int r21, Composer r22, int r23) {
        FlowRow(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit FlowRow$lambda$3(Modifier r11, Arrangement.Horizontal r12, Arrangement.Vertical r13, Alignment.Vertical r14, int r15, int r16, Function3 r17, int r18, int r19, Composer r20, int r21) {
        FlowRow(r11, r12, r13, r14, r15, r16, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, Arrangement.Horizontal r1, Arrangement.Vertical r2, Alignment.Vertical r3, int r4, int r5, FlowRowOverflow r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return FlowRow$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(Ref.ObjectRef r0, Placeable r1) {
        return breakDownItems_di9J0FM$lambda$20$lambda$19(r0, r1);
    }

    public static /* synthetic */ Unit c(MutableVector r0, Placeable.PlacementScope r1) {
        return placeHelper_BmaY500$lambda$30(r0, r1);
    }

    public static /* synthetic */ Unit d(Modifier r0, Arrangement.Horizontal r1, Arrangement.Vertical r2, Alignment.Vertical r3, int r4, int r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return FlowRow$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit e(Ref.ObjectRef r0, Placeable r1) {
        return breakDownItems_di9J0FM$lambda$23$lambda$22(r0, r1);
    }

    public static /* synthetic */ Unit f(Modifier r0, Arrangement.Vertical r1, Arrangement.Horizontal r2, Alignment.Horizontal r3, int r4, int r5, FlowColumnOverflow r6, Function3 r7, int r8, int r9, Composer r10, int r11) {
        return FlowColumn$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit g(Modifier r0, Arrangement.Vertical r1, Arrangement.Horizontal r2, Alignment.Horizontal r3, int r4, int r5, Function3 r6, int r7, int r8, Composer r9, int r10) {
        return FlowColumn$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        CrossAxisAlignment.Companion r0 = CrossAxisAlignment.Companion;
        Alignment.Companion r1 = Alignment.Companion;
        CROSS_AXIS_ALIGNMENT_TOP = r0.vertical$foundation_layout(r1.getTop());
        CROSS_AXIS_ALIGNMENT_START = r0.horizontal$foundation_layout(r1.getStart());
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    private static final Unit breakDownItems_di9J0FM$lambda$20$lambda$19(Ref.ObjectRef r0, Placeable r1) {
        r0.element = r1;
        return Unit.INSTANCE;
    }

    private static final Unit breakDownItems_di9J0FM$lambda$23$lambda$22(Ref.ObjectRef r0, Placeable r1) {
        r0.element = r1;
        return Unit.INSTANCE;
    }

    private static final Unit placeHelper_BmaY500$lambda$30(MutableVector r2, Placeable.PlacementScope r3) {
        Object[] r4 = r2.content;
        int r5 = r2.getSize();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L6;
        ((MeasureResult) r4[r0]).placeChildren();
        r0 = r0 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> r1, FlowLineInfo r2) {
    L7:
        return null;
    L3:
        if ((r1 instanceof ContextualFlowItemIterator) == false) goto L5;
        Intrinsics.checkNotNull(r2);     // Catch: IndexOutOfBoundsException -> L7
        Measurable r3 = ((ContextualFlowItemIterator) r1).getNext$foundation_layout(r2);     // Catch: IndexOutOfBoundsException -> L7
    L9:
        return r3;
    L5:
        r3 = r1.next();     // Catch: IndexOutOfBoundsException -> L7
        goto L9
    }

    public static final int crossAxisMin(IntrinsicMeasurable r0, boolean r1, int r2) {
        if (r1 == false) goto L5;
        return r0.minIntrinsicHeight(r2);
    L5:
        return r0.minIntrinsicWidth(r2);
    }

    public static final int mainAxisMin(IntrinsicMeasurable r0, boolean r1, int r2) {
        if (r1 == false) goto L5;
        return r0.minIntrinsicWidth(r2);
    L5:
        return r0.minIntrinsicHeight(r2);
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m868measureAndCacherqJ1uqs(Measurable r2, FlowLineMeasurePolicy r3, long r4, Function1<? super Placeable, Unit> r6) {
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(r2)) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        RowColumnParentData r1 = RowColumnImplKt.getRowColumnParentData(r2);
        if (r1 == null) goto L12;
        FlowLayoutData r5 = r1.getFlowLayoutData();
        if (r5 == null) goto L12;
        Float r7 = Float.valueOf(r5.getFillCrossAxisFraction());
    L13:
        if (r7 != null) goto L15;
        Placeable r8 = r2.measure-BRTryo0(r4);
        r6.invoke(r8);
        return IntIntPair.m96constructorimpl(r3.mainAxisSize(r8), r3.crossAxisSize(r8));
    L12:
        r7 = null;
    L15:
        int r9 = mainAxisMin(r2, r3.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m96constructorimpl(r9, crossAxisMin(r2, r3.isHorizontal(), r9));
    L5:
        r0 = false;
        goto L6
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical r17, Arrangement.Horizontal r18, int r19, Composer r20, int r21) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2013098357, r21, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:500)");
    L5:
        boolean r4 = false;
        if (((r21 & 14) ^ 6) <= 4) goto L12;
        if (r20.changed(r17) == false) goto L12;
    L13:
        boolean r3 = true;
    L16:
        if (((r21 & 112) ^ 48) <= 32) goto L20;
        if (r20.changed(r18) == false) goto L20;
    L21:
        boolean r6 = true;
    L23:
        boolean r5 = r3 | r6;
        if (((r21 & 896) ^ 384) <= 256) goto L28;
        if (r20.changed(r19) == false) goto L28;
    L29:
        r4 = true;
    L30:
        boolean r1 = r5 | r4;
        Object r7 = r20.rememberedValue();
        if (r1 == false) goto L33;
    L34:
        boolean r8 = false;
        int r14 = Integer.MAX_VALUE;
        final FlowMeasurePolicy r2 = new FlowMeasurePolicy(r8, r18, r17, r17.mo812getSpacingD9Ej5fM(), CROSS_AXIS_ALIGNMENT_START, r18.mo812getSpacingD9Ej5fM(), r19, r14, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout(), null);
        r7 = new FlowLayoutKt$columnMeasurementHelper$1$1(r2);
        r20.updateRememberedValue(r7);
    L35:
        MeasurePolicy r9 = (MeasurePolicy) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r9;
    L33:
        if (r7 != Composer.Companion.getEmpty()) goto L35;
    L28:
        if ((r21 & 384) != 256) goto L30;
    L20:
        if ((r21 & 48) == 32) goto L21;
        r6 = false;
    L12:
        if ((r21 & 6) == 4) goto L13;
        r3 = false;
        goto L16
    }

    private static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> r9, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> r10, int r11, int r12, int r13) {
        int r0 = r9.size();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int r6 = ((Number) r10.invoke((IntrinsicMeasurable) ListProtector.get(r9, r2), Integer.valueOf(r2), Integer.valueOf(r11))).intValue() + r12;
        int r7 = r2 + 1;
        if ((r7 - r4) != r13) goto L7;
    L10:
        r3 = Math.max(r3, (r5 + r6) - r12);
        r4 = r2;
        r5 = 0;
    L11:
        r2 = r7;
        goto L3
    L7:
        if (r7 == r9.size()) goto L10;
        r5 = r5 + r6;
        goto L11
    L12:
        return r3;
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal r17, Arrangement.Vertical r18, int r19, Composer r20, int r21) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1479255111, r21, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:439)");
    L5:
        boolean r4 = false;
        if (((r21 & 14) ^ 6) <= 4) goto L12;
        if (r20.changed(r17) == false) goto L12;
    L13:
        boolean r3 = true;
    L16:
        if (((r21 & 112) ^ 48) <= 32) goto L20;
        if (r20.changed(r18) == false) goto L20;
    L21:
        boolean r6 = true;
    L23:
        boolean r5 = r3 | r6;
        if (((r21 & 896) ^ 384) <= 256) goto L28;
        if (r20.changed(r19) == false) goto L28;
    L29:
        r4 = true;
    L30:
        boolean r1 = r5 | r4;
        Object r7 = r20.rememberedValue();
        if (r1 == false) goto L33;
    L34:
        boolean r8 = true;
        int r14 = Integer.MAX_VALUE;
        final FlowMeasurePolicy r2 = new FlowMeasurePolicy(r8, r17, r18, r17.mo812getSpacingD9Ej5fM(), CROSS_AXIS_ALIGNMENT_TOP, r18.mo812getSpacingD9Ej5fM(), r19, r14, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout(), null);
        r7 = new FlowLayoutKt$rowMeasurementHelper$1$1(r2);
        r20.updateRememberedValue(r7);
    L35:
        MeasurePolicy r9 = (MeasurePolicy) r7;
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r9;
    L33:
        if (r7 != Composer.Companion.getEmpty()) goto L35;
    L28:
        if ((r21 & 384) != 256) goto L30;
    L20:
        if ((r21 & 48) == 32) goto L21;
        r6 = false;
    L12:
        if ((r21 & 6) == 4) goto L13;
        r3 = false;
        goto L16
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical r18, Arrangement.Horizontal r19, Alignment.Horizontal r20, int r21, int r22, FlowLayoutOverflowState r23, Composer r24, int r25) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-308635847, r25, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:528)");
    L5:
        boolean r5 = false;
        if (((r25 & 14) ^ 6) <= 4) goto L12;
        if (r24.changed(r18) == false) goto L12;
    L13:
        boolean r4 = true;
    L16:
        if (((r25 & 112) ^ 48) <= 32) goto L20;
        if (r24.changed(r19) == false) goto L20;
    L21:
        boolean r7 = true;
    L23:
        boolean r6 = r4 | r7;
        if (((r25 & 896) ^ 384) <= 256) goto L28;
        if (r24.changed(r20) == false) goto L28;
    L29:
        boolean r8 = true;
    L31:
        boolean r9 = r6 | r8;
        if (((r25 & 7168) ^ 3072) <= 2048) goto L36;
        if (r24.changed(r21) == false) goto L36;
    L37:
        boolean r10 = true;
    L39:
        boolean r11 = r9 | r10;
        if (((57344 & r25) ^ 24576) <= 16384) goto L44;
        if (r24.changed(r22) == false) goto L44;
    L45:
        r5 = true;
    L46:
        boolean r2 = (r11 | r5) | r24.changed(r23);
        Object r12 = r24.rememberedValue();
        if (r2 == false) goto L49;
    L50:
        boolean r13 = false;
        r12 = new FlowMeasurePolicy(r13, r19, r18, r18.mo812getSpacingD9Ej5fM(), CrossAxisAlignment.Companion.horizontal$foundation_layout(r20), r19.mo812getSpacingD9Ej5fM(), r21, r22, r23, null);
        r24.updateRememberedValue(r12);
    L51:
        FlowMeasurePolicy r14 = (FlowMeasurePolicy) r12;
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventEnd();
    L54:
        return r14;
    L49:
        if (r12 != Composer.Companion.getEmpty()) goto L51;
    L44:
        if ((r25 & 24576) != 16384) goto L46;
    L36:
        if ((r25 & 3072) == 2048) goto L37;
        r10 = false;
    L28:
        if ((r25 & 384) == 256) goto L29;
        r8 = false;
    L20:
        if ((r25 & 48) == 32) goto L21;
        r7 = false;
    L12:
        if ((r25 & 6) == 4) goto L13;
        r4 = false;
        goto L16
    }

    /* JADX INFO: renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m869placeHelperBmaY500(MeasureScope r11, long r12, int r14, int r15, int[] r16, final MutableVector<MeasureResult> r17, FlowLineMeasurePolicy r18, int[] r19) {
        boolean r7 = r18.isHorizontal();
        Arrangement.Vertical r0 = r18.getVerticalArrangement();
        Arrangement.Horizontal r1 = r18.getHorizontalArrangement();
        if (r7 == false) goto L12;
        int r2 = (r11.roundToPx-0680j_4(r0.mo812getSpacingD9Ej5fM()) * (r17.getSize() - 1)) + r15;
        int r3 = Constraints.getMinHeight-impl(r12);
        int r4 = Constraints.getMaxHeight-impl(r12);
        if (r2 >= r3) goto L8;
        r2 = r3;
    L8:
        if (r2 > r4) goto L11;
        r4 = r2;
    L11:
        r0.arrange(r11, r4, r16, r19);
    L19:
        int r5 = Constraints.getMinWidth-impl(r12);
        int r6 = Constraints.getMaxWidth-impl(r12);
        if (r14 < r5) goto L23;
        r5 = r14;
    L23:
        if (r5 > r6) goto L26;
        r6 = r5;
    L26:
        if (r7 == true) goto L30;
        int r10 = r4;
        r4 = r6;
        r6 = r10;
    L30:
        return MeasureScope.-CC.layout$default(r11, r6, r4, null, new p0(r17), 4, null);
    L12:
        int r8 = (r11.roundToPx-0680j_4(r1.mo812getSpacingD9Ej5fM()) * (r17.getSize() - 1)) + r15;
        int r9 = Constraints.getMinHeight-impl(r12);
        int r13 = Constraints.getMaxHeight-impl(r12);
        if (r8 >= r9) goto L15;
        r8 = r9;
    L15:
        if (r8 <= r13) goto L17;
        int r20 = r13;
    L18:
        r1.arrange(r11, r20, r16, r11.getLayoutDirection(), r19);
        r4 = r20;
        goto L19
    L17:
        r20 = r8;
        goto L18
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal r18, Arrangement.Vertical r19, Alignment.Vertical r20, int r21, int r22, FlowLayoutOverflowState r23, Composer r24, int r25) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2010142641, r25, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:470)");
    L5:
        boolean r5 = false;
        if (((r25 & 14) ^ 6) <= 4) goto L12;
        if (r24.changed(r18) == false) goto L12;
    L13:
        boolean r4 = true;
    L16:
        if (((r25 & 112) ^ 48) <= 32) goto L20;
        if (r24.changed(r19) == false) goto L20;
    L21:
        boolean r7 = true;
    L23:
        boolean r6 = r4 | r7;
        if (((r25 & 896) ^ 384) <= 256) goto L28;
        if (r24.changed(r20) == false) goto L28;
    L29:
        boolean r8 = true;
    L31:
        boolean r9 = r6 | r8;
        if (((r25 & 7168) ^ 3072) <= 2048) goto L36;
        if (r24.changed(r21) == false) goto L36;
    L37:
        boolean r10 = true;
    L39:
        boolean r11 = r9 | r10;
        if (((57344 & r25) ^ 24576) <= 16384) goto L44;
        if (r24.changed(r22) == false) goto L44;
    L45:
        r5 = true;
    L46:
        boolean r2 = (r11 | r5) | r24.changed(r23);
        Object r12 = r24.rememberedValue();
        if (r2 == false) goto L49;
    L50:
        boolean r13 = true;
        r12 = new FlowMeasurePolicy(r13, r18, r19, r18.mo812getSpacingD9Ej5fM(), CrossAxisAlignment.Companion.vertical$foundation_layout(r20), r19.mo812getSpacingD9Ej5fM(), r21, r22, r23, null);
        r24.updateRememberedValue(r12);
    L51:
        FlowMeasurePolicy r14 = (FlowMeasurePolicy) r12;
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventEnd();
    L54:
        return r14;
    L49:
        if (r12 != Composer.Companion.getEmpty()) goto L51;
    L44:
        if ((r25 & 24576) != 16384) goto L46;
    L36:
        if ((r25 & 3072) == 2048) goto L37;
        r10 = false;
    L28:
        if ((r25 & 384) == 256) goto L29;
        r8 = false;
    L20:
        if ((r25 & 48) == 32) goto L21;
        r7 = false;
    L12:
        if ((r25 & 6) == 4) goto L13;
        r4 = false;
        goto L16
    }

    public static final /* synthetic */ long access$intrinsicCrossAxisSize(List r0, int[] r1, int[] r2, int r3, int r4, int r5, int r6, int r7, FlowLayoutOverflowState r8) {
        return intrinsicCrossAxisSize(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m867breakDownItemsdi9J0FM(MeasureScope r54, FlowLineMeasurePolicy r55, Iterator<? extends Measurable> r56, float r57, float r58, long r59, int r61, int r62, FlowLayoutOverflowState r63) {
        Iterator<? extends Measurable> r0 = r56;
        MutableVector r15 = new MutableVector(new MeasureResult[16], 0);
        int r1 = Constraints.getMaxWidth-impl(r59);
        int r9 = Constraints.getMinWidth-impl(r59);
        int r10 = Constraints.getMaxHeight-impl(r59);
        MutableIntObjectMap r11 = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList r8 = new ArrayList();
        int r7 = (int) Math.ceil(r54.toPx-0680j_4(r57));
        int r6 = (int) Math.ceil(r54.toPx-0680j_4(r58));
        long r25 = OrientationIndependentConstraints.m926constructorimpl(0, r1, 0, r10);
        long r2 = OrientationIndependentConstraints.m930copyyUG9Ft0$default(r25, 0, 0, 0, 0, 14, null);
        if (r55.isHorizontal() == false) goto L5;
        LayoutOrientation r4 = LayoutOrientation.Horizontal;
    L6:
        long r5 = OrientationIndependentConstraints.m941toBoxConstraintsOenEA2s(r2, r4);
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        ArrayList r28 = r8;
        if ((r0 instanceof ContextualFlowItemIterator) == false) goto L9;
        FlowLineInfo r12 = new FlowLineInfo(0, 0, r54.toDp-u2uoSUM(r1), r54.toDp-u2uoSUM(r10), null);
    L11:
        if (r56.hasNext() == true) goto L13;
        Measurable r13 = null;
    L14:
        if (r13 == null) goto L16;
        IntIntPair r14 = IntIntPair.m93boximpl(m868measureAndCacherqJ1uqs(r13, r55, r5, new m0(r3)));
    L17:
        if (r14 == null) goto L19;
        Integer r41 = Integer.valueOf(IntIntPair.m100getFirstimpl(r14.m104unboximpl()));
    L20:
        if (r14 == null) goto L22;
        Integer r42 = Integer.valueOf(IntIntPair.m101getSecondimpl(r14.m104unboximpl()));
    L23:
        long r43 = r5;
        MutableIntList r510 = new MutableIntList(0, 1, null);
        MutableIntList r16 = new MutableIntList(0, 1, null);
        MutableIntSet r17 = IntSetKt.mutableIntSetOf();
        FlowLayoutBuildingBlocks r45 = new FlowLayoutBuildingBlocks(r61, r63, r59, r62, r7, r6, null);
        FlowLayoutBuildingBlocks.WrapInfo r18 = r45.m865getWrapInfoOpUlnko(r56.hasNext(), 0, IntIntPair.m96constructorimpl(r1, r10), r14, 0, 0, 0, false, false);
        if (r18.isLastItemInContainer() == false) goto L29;
        if (r14 == null) goto L27;
        boolean r19 = true;
    L28:
        FlowLayoutBuildingBlocks.WrapEllipsisInfo r20 = r45.getWrapEllipsisInfo(r18, r19, -1, 0, r1, 0);
    L30:
        FlowLayoutBuildingBlocks.WrapEllipsisInfo r64 = r20;
        Measurable r21 = r13;
        int r22 = r9;
        int r23 = r10;
        boolean r511 = false;
        int r24 = 0;
        int r26 = 0;
        int r27 = 0;
        int r29 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = r1;
    L32:
        if (r18.isLastItemInContainer() == true) goto L107;
        if (r21 == null) goto L107;
        Intrinsics.checkNotNull(r41);
        int r113 = r41.intValue();
        Intrinsics.checkNotNull(r42);
        MutableIntSet r210 = r17;
        int r30 = r27 + r113;
        int r31 = Math.max(r29, r42.intValue());
        int r114 = r112 - r113;
        MutableIntList r44 = r16;
        int r115 = r26 + 1;
        int r46 = r1;
        r63.setItemShown$foundation_layout(r115);
        r28.add(r21);
        ArrayList r47 = r28;
        final Ref.ObjectRef r32 = r3;
        r11.set(r26, r32.element);
        Object r33 = r21.getParentData();
        if ((r33 instanceof RowColumnParentData) == false) goto L37;
        RowColumnParentData r34 = (RowColumnParentData) r33;
    L38:
        if (r34 == null) goto L42;
        FlowLayoutData r35 = r34.getFlowLayoutData();
        if (r35 == null) goto L42;
        Float r36 = Float.valueOf(r35.getFillCrossAxisFraction());
    L43:
        if (r36 == null) goto L45;
        boolean r37 = true;
    L46:
        int r38 = r115 - r110;
        if (r38 >= r61) goto L49;
        boolean r116 = true;
    L50:
        if (r12 == 0) goto L72;
        if (r116 == false) goto L53;
        int r117 = r24;
    L55:
        if (r116 == false) goto L57;
        int r118 = r38;
    L58:
        if (r116 == false) goto L63;
        int r119 = r114 - r7;
        boolean r48 = r37;
        if (r119 >= 0) goto L62;
        int r39 = 0;
    L64:
        float r40 = r54.toDp-u2uoSUM(r39);
        if (r116 == false) goto L67;
        int r49 = r6;
        int r120 = r23;
    L71:
        r12.m880update4j6BHR0$foundation_layout(r117, r118, r40, r54.toDp-u2uoSUM(r120));
        Unit r50 = Unit.INSTANCE;
    L74:
        if (r56.hasNext() == true) goto L76;
        Measurable r51 = null;
    L77:
        r32.element = null;
        if (r51 == null) goto L80;
        long r52 = r43;
        IntIntPair r121 = IntIntPair.m93boximpl(m868measureAndCacherqJ1uqs(r51, r55, r52, new n0(r32)));
    L81:
        if (r121 == null) goto L83;
        Integer r410 = Integer.valueOf(IntIntPair.m100getFirstimpl(r121.m104unboximpl()) + r7);
    L84:
        if (r121 == null) goto L86;
        Integer r411 = Integer.valueOf(IntIntPair.m101getSecondimpl(r121.m104unboximpl()));
    L87:
        boolean r310 = r56.hasNext();
        long r311 = IntIntPair.m96constructorimpl(r114, r23);
        if (r121 != null) goto L90;
        IntIntPair r312 = null;
    L91:
        FlowLayoutBuildingBlocks.WrapInfo r53 = r45.m865getWrapInfoOpUlnko(r310, r38, r311, r312, r24, r111, r31, false, false);
        if (r53.isLastItemInLine() == false) goto L105;
        int r122 = r46;
        int r60 = Math.min(Math.max(r22, r30), r122);
        int r65 = r111 + r31;
        if (r121 == null) goto L96;
        boolean r123 = true;
    L97:
        FlowLayoutBuildingBlocks.WrapEllipsisInfo r66 = r45.getWrapEllipsisInfo(r53, r123, r24, r65, r114, r38);
        MutableIntList r124 = r44;
        r124.add(r31);
        MutableIntSet r67 = r210;
        if (r48 == false) goto L100;
        r67.plusAssign(r24);
    L100:
        int r68 = (r10 - r65) - r49;
        MutableIntList r69 = r510;
        r69.add(r115);
        if (r410 == null) goto L103;
        Integer r125 = Integer.valueOf(r410.intValue() - r7);
    L104:
        r111 = r65 + r49;
        r23 = r68;
        r112 = r122;
        r110 = r115;
        r41 = r125;
        r48 = false;
        int r70 = r24 + 1;
        int r126 = r110;
        int r127 = 0;
        int r71 = r60;
        MutableIntList r72 = r69;
        int r73 = 0;
    L106:
        r510 = r72;
        r64 = r66;
        r22 = r71;
        r24 = r70;
        r27 = r73;
        r1 = r122;
        r16 = r124;
        r29 = r127;
        r11 = r11;
        r511 = r48;
        r42 = r411;
        r43 = r52;
        r17 = r67;
        r12 = r12;
        r28 = r47;
        r21 = r51;
        r26 = r126;
        r18 = r53;
        r0 = r56;
        int r512 = r49;
        r3 = r32;
        r6 = r512;
        goto L32
    L103:
        r125 = null;
        goto L104
    L96:
        r123 = false;
        goto L97
    L105:
        r126 = r115;
        r67 = r210;
        r124 = r44;
        r122 = r46;
        r72 = r510;
        r112 = r114;
        r41 = r410;
        r127 = r31;
        r73 = r30;
        r70 = r24;
        r71 = r22;
        r66 = r64;
        goto L106
    L90:
        Intrinsics.checkNotNull(r410);
        int r128 = r410.intValue();
        Intrinsics.checkNotNull(r411);
        r312 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r128, r411.intValue()));
        goto L91
    L86:
        r411 = null;
        goto L87
    L83:
        r410 = null;
        goto L84
    L80:
        r52 = r43;
        r121 = null;
        goto L81
    L76:
        r51 = safeNext(r0, r12);
        goto L77
    L67:
        int r129 = (r23 - r31) - r6;
        r49 = r6;
        if (r129 >= 0) goto L70;
        r120 = 0;
        goto L71
    L70:
        r120 = r129;
        goto L71
    L62:
        r39 = r119;
        goto L64
    L63:
        r48 = r37;
        r39 = r46;
        goto L64
    L57:
        r118 = 0;
        goto L58
    L53:
        r117 = r24 + 1;
        goto L55
    L72:
        r48 = r37;
        r11 = r11;
        r49 = r6;
        goto L74
    L49:
        r116 = false;
        goto L50
    L45:
        r37 = r511;
    L42:
        r36 = null;
        goto L43
    L37:
        r34 = null;
    L107:
        ArrayList r412 = r28;
        MutableIntObjectMap r413 = r11;
        MutableIntSet r74 = r17;
        MutableIntList r75 = r510;
        MutableIntList r130 = r16;
        if (r64 == null) goto L113;
        ArrayList r76 = r412;
        r76.add(r64.getEllipsis());
        MutableIntObjectMap r77 = r413;
        r77.set(r76.size() - 1, r64.getPlaceable());
        int r78 = r75._size - 1;
        if (r64.getPlaceEllipsisOnLastContentLine() == false) goto L112;
        int r79 = r75._size - 1;
        r130.set(r78, Math.max(r130.get(r78), IntIntPair.m101getSecondimpl(r64.m866getEllipsisSizeOO21N7I())));
        r75.set(r79, r75.last() + 1);
        Unit r80 = Unit.INSTANCE;
    L114:
        int r81 = r76.size();
        Placeable[] r131 = new Placeable[r81];
        int r82 = 0;
    L115:
        if (r82 >= r81) goto L117;
        r131[r82] = r77.get(r82);
        r82 = r82 + 1;
        goto L115
    L117:
        int r132 = r75._size;
        int[] r133 = new int[r132];
        int[] r83 = new int[r132];
        int[] r84 = r75.content;
        int r85 = r22;
        int r86 = 0;
        int r134 = 0;
        int r135 = 0;
    L118:
        if (r86 >= r132) goto L131;
        int r136 = r84[r86];
        int r87 = r130.get(r86);
        if (r74.contains(r86) == false) goto L123;
    L121:
        int r137 = r87;
    L126:
        int r211 = r86;
        int r88 = r137;
        int r138 = r85;
        int[] r139 = r84;
        int[] r212 = r83;
        ArrayList r89 = r76;
        MutableIntSet r213 = r74;
        ArrayList r214 = r76;
        int r90 = r134;
        int[] r215 = r133;
        MutableIntList r140 = r130;
        int r313 = r132;
        MeasureResult r91 = RowColumnMeasurePolicyKt.measure(r55, r85, Constraints.getMinHeight-impl(r25), Constraints.getMaxWidth-impl(r25), r88, r7, r54, r89, r131, r90, r136, r215, r211);
        if (r55.isHorizontal() == false) goto L129;
        int r92 = r91.getWidth();
        int r93 = r91.getHeight();
    L130:
        r212[r211] = r93;
        r135 = r135 + r93;
        r85 = Math.max(r138, r92);
        r15.add(r91);
        r86 = r211 + 1;
        r130 = r140;
        r134 = r136;
        r84 = r139;
        r83 = r212;
        r74 = r213;
        r76 = r214;
        r133 = r215;
        r132 = r313;
        goto L118
    L129:
        r92 = r91.getHeight();
        r93 = r91.getWidth();
        goto L130
    L123:
        if (Constraints.getMaxHeight-impl(r25) != Integer.MAX_VALUE) goto L125;
        r137 = Integer.MAX_VALUE;
        goto L126
    L125:
        r87 = Constraints.getMaxHeight-impl(r25) - r135;
        goto L121
    L131:
        int r141 = r85;
        int[] r216 = r83;
        int[] r217 = r133;
        if (r15.getSize() != 0) goto L134;
        boolean r142 = true;
    L135:
        if (r142 == false) goto L137;
        int r94 = 0;
        int r95 = 0;
    L139:
        return m869placeHelperBmaY500(r54, r59, r94, r95, r216, r15, r55, r217);
    L137:
        r94 = r141;
        r95 = r135;
        goto L139
    L134:
        r142 = false;
        goto L135
    L112:
        r130.add(IntIntPair.m101getSecondimpl(r64.m866getEllipsisSizeOO21N7I()));
        r75.add(r75.last() + 1);
        goto L114
    L113:
        r76 = r412;
        r77 = r413;
        goto L114
    L27:
        r19 = false;
        goto L28
    L29:
        r20 = null;
        goto L30
    L22:
        r42 = null;
        goto L23
    L19:
        r41 = null;
        goto L20
    L16:
        r14 = null;
        goto L17
    L13:
        r13 = safeNext(r0, r12);
        goto L14
    L9:
        r12 = null;
        goto L11
    L5:
        r4 = LayoutOrientation.Vertical;
        goto L6
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> r29, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> r30, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> r31, int r32, int r33, int r34, int r35, int r36, FlowLayoutOverflowState r37) {
        if (r29.isEmpty() == true) goto L5;
        FlowLayoutBuildingBlocks r27 = new FlowLayoutBuildingBlocks(r35, r37, OrientationIndependentConstraints.m926constructorimpl(0, r32, 0, Integer.MAX_VALUE), r36, r33, r34, null);
        IntrinsicMeasurable r4 = (IntrinsicMeasurable) CollectionsKt.getOrNull(r29, 0);
        if (r4 == null) goto L9;
        int r5 = ((Number) r31.invoke(r4, 0, Integer.valueOf(r32))).intValue();
    L10:
        if (r4 == null) goto L12;
        int r6 = ((Number) r30.invoke(r4, 0, Integer.valueOf(r5))).intValue();
    L13:
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        boolean r11 = true;
        if (r29.size() <= 1) goto L16;
        boolean r17 = true;
    L17:
        long r19 = IntIntPair.m96constructorimpl(r32, Integer.MAX_VALUE);
        if (r4 != null) goto L20;
        IntIntPair r21 = null;
    L22:
        if (r27.m865getWrapInfoOpUlnko(r17, 0, r19, r21, 0, 0, 0, false, false).isLastItemInContainer() == true) goto L24;
        int r10 = r29.size();
        int r14 = r32;
        int r12 = 0;
        int r16 = 0;
        int r28 = 0;
    L34:
        if (r12 >= r10) goto L65;
        int r13 = r14 - r6;
        int r15 = r12 + 1;
        int r18 = Math.max(r7, r5);
        IntrinsicMeasurable r20 = (IntrinsicMeasurable) CollectionsKt.getOrNull(r29, r15);
        if (r20 == null) goto L38;
        int r110 = ((Number) r31.invoke(r20, Integer.valueOf(r15), Integer.valueOf(r32))).intValue();
    L39:
        if (r20 == null) goto L41;
        int r111 = ((Number) r30.invoke(r20, Integer.valueOf(r15), Integer.valueOf(r110))).intValue() + r33;
    L43:
        if ((r12 + 2) >= r29.size()) goto L45;
        boolean r112 = true;
    L46:
        int r113 = r15 - r28;
        long r114 = IntIntPair.m96constructorimpl(r13, Integer.MAX_VALUE);
        if (r20 != null) goto L49;
        IntIntPair r22 = null;
    L50:
        FlowLayoutBuildingBlocks.WrapInfo r115 = r27.m865getWrapInfoOpUlnko(r112, r113, r114, r22, r9, r8, r18, false, false);
        if (r115.isLastItemInLine() == false) goto L63;
        r8 = r8 + (r18 + r34);
        if (r20 == null) goto L55;
        boolean r116 = true;
    L56:
        FlowLayoutBuildingBlocks.WrapEllipsisInfo r23 = r27.getWrapEllipsisInfo(r115, r116, r9, r8, r13, r113);
        int r117 = r111 - r33;
        r9 = r9 + 1;
        if (r115.isLastItemInContainer() == true) goto L58;
        int r24 = r32;
        r6 = r117;
        r28 = r15;
        r7 = 0;
    L64:
        r12 = r15;
        r16 = r12;
        r14 = r24;
        r5 = r110;
        goto L34
    L58:
        if (r23 == null) goto L67;
        long r0 = r23.m866getEllipsisSizeOO21N7I();
        if (r23.getPlaceEllipsisOnLastContentLine() == true) goto L67;
        r8 = r8 + (IntIntPair.m101getSecondimpl(r0) + r34);
    L67:
        return IntIntPair.m96constructorimpl(r8 - r34, r15);
    L55:
        r116 = false;
        goto L56
    L63:
        r7 = r18;
        r24 = r13;
        r6 = r111;
        goto L64
    L49:
        r22 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r111, r110));
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = 0;
        goto L43
    L38:
        r110 = 0;
        goto L39
    L65:
        r15 = r16;
        goto L67
    L24:
        if (r4 != null) goto L27;
        r11 = false;
    L27:
        IntIntPair r1 = r37.m872ellipsisSizeF35zmw$foundation_layout(r11, 0, 0);
        if (r1 == null) goto L30;
        int r2 = IntIntPair.m101getSecondimpl(r1.m104unboximpl());
    L32:
        return IntIntPair.m96constructorimpl(r2, 0);
    L30:
        r2 = 0;
        goto L32
    L20:
        r21 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r6, r5));
        goto L22
    L16:
        r17 = false;
        goto L17
    L12:
        r6 = 0;
        goto L13
    L9:
        r5 = 0;
        goto L10
    L5:
        return IntIntPair.m96constructorimpl(0, 0);
    }

    private static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> r18, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> r19, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> r20, int r21, int r22, int r23, int r24, int r25, FlowLayoutOverflowState r26) {
        if (r18.isEmpty() == false) goto L5;
        return 0;
    L5:
        int r0 = r18.size();
        int[] r13 = new int[r0];
        int r2 = r18.size();
        int[] r14 = new int[r2];
        int r3 = r18.size();
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        IntrinsicMeasurable r5 = (IntrinsicMeasurable) ListProtector.get(r18, r4);
        int r6 = ((Number) r19.invoke(r5, Integer.valueOf(r4), Integer.valueOf(r21))).intValue();
        r13[r4] = r6;
        r14[r4] = ((Number) r20.invoke(r5, Integer.valueOf(r4), Integer.valueOf(r6))).intValue();
        r4 = r4 + 1;
        goto L6
    L8:
        int r7 = Integer.MAX_VALUE;
        if (r25 == Integer.MAX_VALUE) goto L12;
        if (r24 == Integer.MAX_VALUE) goto L12;
        r7 = r24 * r25;
    L12:
        int r8 = 1;
        if (r7 >= r18.size()) goto L20;
        if (r26.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandIndicator) goto L17;
    L18:
        int r9 = 1;
    L27:
        int r15 = Math.min(r7 - r9, r18.size());
        int r10 = ArraysKt.sum(r13) + ((r18.size() - 1) * r22);
        if (r2 != 0) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == true) goto L70;
        int r12 = r14[0];
        int r16 = ArraysKt.getLastIndex(r14);
        if (1 > r16) goto L40;
        int r17 = 1;
    L35:
        int r27 = r14[r17];
        if (r12 >= r27) goto L38;
        r12 = r27;
    L38:
        if (r17 == r16) goto L40;
        r17 = r17 + 1;
    L40:
        if (r0 != 0) goto L42;
        boolean r1 = true;
    L43:
        if (r1 == true) goto L68;
        int r28 = r13[0];
        int r29 = ArraysKt.getLastIndex(r13);
        if (1 > r29) goto L51;
    L46:
        int r30 = r13[r8];
        if (r28 >= r30) goto L49;
        r28 = r30;
    L49:
        if (r8 == r29) goto L51;
        r8 = r8 + 1;
    L51:
        int r31 = r28;
        int r32 = r10;
    L52:
        if (r31 > r32) goto L66;
        if (r12 == r21) goto L54;
        r10 = (r31 + r32) / 2;
        int r33 = r32;
        int r110 = r31;
        long r34 = access$intrinsicCrossAxisSize(r18, r13, r14, r10, r22, r23, r24, r25, r26);
        r12 = IntIntPair.m100getFirstimpl(r34);
        int r35 = IntIntPair.m101getSecondimpl(r34);
        if (r12 > r21) goto L62;
        if (r35 < r15) goto L62;
        if (r12 >= r21) goto L61;
        r32 = r10 - 1;
        r31 = r110;
        goto L52
    L61:
        return r10;
    L62:
        r31 = r10 + 1;
        if (r31 > r33) goto L64;
        r32 = r33;
        goto L52
    L64:
        return r31;
    L54:
        return r10;
    L66:
        return r10;
    L68:
        throw new NoSuchElementException();
    L42:
        r1 = false;
        goto L43
    L70:
        throw new NoSuchElementException();
    L30:
        r11 = false;
        goto L31
    L17:
        if (r26.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator) goto L18;
    L20:
        if (r7 >= r18.size()) goto L22;
    L26:
        r9 = 0;
        goto L27
    L22:
        if (r25 < r26.getMinLinesToShowCollapse$foundation_layout()) goto L26;
        if (r26.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator) goto L26;
        goto L26
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> r28, int[] r29, int[] r30, int r31, int r32, int r33, int r34, int r35, FlowLayoutOverflowState r36) {
        if (r28.isEmpty() == true) goto L70;
        FlowLayoutBuildingBlocks r24 = new FlowLayoutBuildingBlocks(r34, r36, OrientationIndependentConstraints.m926constructorimpl(0, r31, 0, Integer.MAX_VALUE), r35, r32, r33, null);
        IntrinsicMeasurable r2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(r28, 0);
        if (r2 == null) goto L8;
        int r3 = r30[0];
    L9:
        if (r2 == null) goto L11;
        int r4 = r29[0];
    L12:
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        boolean r9 = true;
        if (r28.size() <= 1) goto L15;
        boolean r14 = true;
    L16:
        long r16 = IntIntPair.m96constructorimpl(r31, Integer.MAX_VALUE);
        if (r2 != null) goto L19;
        IntIntPair r18 = null;
    L21:
        if (r24.m865getWrapInfoOpUlnko(r14, 0, r16, r18, 0, 0, 0, false, false).isLastItemInContainer() == true) goto L23;
        int r8 = r28.size();
        int r13 = r31;
        int r10 = 0;
        int r15 = 0;
        int r25 = 0;
    L32:
        if (r10 >= r8) goto L65;
        int r11 = r13 - r4;
        int r17 = r10 + 1;
        int r12 = Math.max(r5, r3);
        IntrinsicMeasurable r19 = (IntrinsicMeasurable) CollectionsKt.getOrNull(r28, r17);
        if (r19 == null) goto L36;
        int r110 = r30[r17];
    L37:
        if (r19 == null) goto L39;
        int r111 = r29[r17] + r32;
    L41:
        if ((r10 + 2) >= r28.size()) goto L43;
        boolean r20 = true;
    L44:
        int r112 = r17 - r25;
        long r113 = IntIntPair.m96constructorimpl(r11, Integer.MAX_VALUE);
        if (r19 != null) goto L47;
        IntIntPair r114 = null;
    L48:
        int r26 = r111;
        int r27 = r110;
        FlowLayoutBuildingBlocks.WrapInfo r21 = r24.m865getWrapInfoOpUlnko(r20, r112, r113, r114, r7, r6, r12, false, false);
        if (r21.isLastItemInLine() == false) goto L62;
        r6 = r6 + (r12 + r33);
        if (r19 == null) goto L53;
        boolean r115 = true;
    L54:
        FlowLayoutBuildingBlocks.WrapEllipsisInfo r22 = r24.getWrapEllipsisInfo(r21, r115, r7, r6, r11, r112);
        int r116 = r26 - r32;
        r7 = r7 + 1;
        if (r21.isLastItemInContainer() == true) goto L56;
        r25 = r17;
        r4 = r116;
        r5 = 0;
        r13 = r31;
    L63:
        r10 = r17;
        r15 = r10;
        r3 = r27;
        goto L32
    L56:
        if (r22 == null) goto L60;
        long r0 = r22.m866getEllipsisSizeOO21N7I();
        if (r22.getPlaceEllipsisOnLastContentLine() == true) goto L60;
        r6 = r6 + (IntIntPair.m101getSecondimpl(r0) + r33);
    L60:
        r15 = r17;
        goto L65
    L53:
        r115 = false;
        goto L54
    L62:
        r5 = r12;
        r13 = r11;
        r4 = r26;
        goto L63
    L47:
        r114 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r111, r110));
        goto L48
    L43:
        r20 = false;
        goto L44
    L39:
        r111 = 0;
        goto L41
    L36:
        r110 = 0;
    L65:
        return IntIntPair.m96constructorimpl(r6 - r33, r15);
    L23:
        if (r2 != null) goto L26;
        r9 = false;
    L26:
        IntIntPair r1 = r36.m872ellipsisSizeF35zmw$foundation_layout(r9, 0, 0);
        if (r1 == null) goto L29;
        int r23 = IntIntPair.m101getSecondimpl(r1.m104unboximpl());
    L71:
        return IntIntPair.m96constructorimpl(r23, 0);
    L29:
        r23 = 0;
        goto L71
    L19:
        r18 = IntIntPair.m93boximpl(IntIntPair.m96constructorimpl(r4, r3));
        goto L21
    L15:
        r14 = false;
        goto L16
    L11:
        r4 = 0;
        goto L12
    L8:
        r3 = 0;
        goto L9
    L70:
        return IntIntPair.m96constructorimpl(0, 0);
    }

    public static final void FlowColumn(Modifier r20, Arrangement.Vertical r21, Arrangement.Horizontal r22, Alignment.Horizontal r23, int r24, int r25, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(1371845627);
        int r2 = r29 & 1;
        if (r2 == 0) goto L6;
        int r4 = r28 | 6;
    L13:
        int r5 = r29 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Arrangement.Vertical r6 = r21;
    L24:
        int r7 = r29 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Arrangement.Horizontal r9 = r22;
    L35:
        int r10 = r29 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Alignment.Horizontal r11 = r23;
    L46:
        int r12 = r29 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        int r13 = r24;
    L57:
        int r14 = r29 & 32;
        if (r14 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r15 = r25;
    L69:
        if ((r29 & 64) == 0) goto L72;
        r4 = r4 | 1572864;
    L79:
        if ((r4 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L109;
        if (r2 == 0) goto L86;
        Modifier r3 = Modifier.Companion;
    L87:
        if (r5 == 0) goto L89;
        r6 = Arrangement.INSTANCE.getTop();
    L89:
        if (r7 == 0) goto L91;
        Arrangement.Horizontal r8 = Arrangement.INSTANCE.getStart();
    L92:
        if (r10 == 0) goto L94;
        Alignment.Horizontal r16 = Alignment.Companion.getStart();
    L95:
        int r17 = Integer.MAX_VALUE;
        if (r12 == 0) goto L98;
        int r18 = Integer.MAX_VALUE;
    L99:
        if (r14 != 0) goto L103;
        r17 = r15;
    L103:
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventStart(1371845627, r4, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
    L105:
        FlowColumnOverflow r19 = FlowColumnOverflow.Companion.getClip();
        int r110 = (((((((r4 & 14) | 1572864) | (r4 & 112)) | (r4 & 896)) | (r4 & 7168)) | (57344 & r4)) | (458752 & r4)) | ((r4 << 3) & 29360128);
        FlowColumn(r3, r6, r8, r16, r18, r17, r19, r26, r1, r110, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L108;
        ComposerKt.traceEventEnd();
    L108:
        final Alignment.Horizontal r30 = r16;
        r15 = r17;
        final int r31 = r18;
        final Arrangement.Horizontal r32 = r8;
        Modifier r33 = r3;
    L110:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L114;
        final Modifier r34 = r33;
        final Arrangement.Vertical r35 = r6;
        final int r36 = r15;
        r111.updateScope(new k0(r34, r35, r32, r30, r31, r36, r26, r28, r29));
        return;
    L114:
        return;
    L98:
        r18 = r13;
        goto L99
    L94:
        r16 = r11;
        goto L95
    L91:
        r8 = r9;
        goto L92
    L86:
        r3 = r20;
        goto L87
    L109:
        r1.skipToGroupEnd();
        r33 = r20;
        r32 = r9;
        r30 = r11;
        r31 = r13;
        goto L110
    L81:
        r0 = false;
        goto L83
    L72:
        if ((r28 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r26) == false) goto L76;
        int r112 = 1048576;
    L77:
        r4 = r4 | r112;
        goto L79
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r28) != 0) goto L67;
        r15 = r25;
        if (r1.changed(r15) == false) goto L65;
        int r113 = 131072;
    L66:
        r4 = r4 | r113;
        goto L69
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r28 & 24576) != 0) goto L56;
        r13 = r24;
        if (r1.changed(r13) == false) goto L54;
        int r114 = 16384;
    L55:
        r4 = r4 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r11 = r23;
        if (r1.changed(r11) == false) goto L43;
        int r115 = 2048;
    L44:
        r4 = r4 | r115;
        goto L46
    L43:
        r115 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L34;
        r9 = r22;
        if (r1.changed(r9) == false) goto L32;
        int r116 = 256;
    L33:
        r4 = r4 | r116;
        goto L35
    L32:
        r116 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r6 = r21;
        if (r1.changed(r6) == false) goto L21;
        int r37 = 32;
    L22:
        r4 = r4 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r4 = r28;
        goto L13
    L8:
        if (r1.changed(r20) == false) goto L10;
        int r38 = 4;
    L11:
        r4 = r38 | r28;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    public static final void FlowRow(Modifier r20, Arrangement.Horizontal r21, Arrangement.Vertical r22, Alignment.Vertical r23, int r24, int r25, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-1303174015);
        int r2 = r29 & 1;
        if (r2 == 0) goto L6;
        int r4 = r28 | 6;
    L13:
        int r5 = r29 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Arrangement.Horizontal r6 = r21;
    L24:
        int r7 = r29 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Arrangement.Vertical r9 = r22;
    L35:
        int r10 = r29 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Alignment.Vertical r11 = r23;
    L46:
        int r12 = r29 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        int r13 = r24;
    L57:
        int r14 = r29 & 32;
        if (r14 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r15 = r25;
    L69:
        if ((r29 & 64) == 0) goto L72;
        r4 = r4 | 1572864;
    L79:
        if ((r4 & 599187) == 599186) goto L81;
        boolean r0 = true;
    L83:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L109;
        if (r2 == 0) goto L86;
        Modifier r3 = Modifier.Companion;
    L87:
        if (r5 == 0) goto L89;
        r6 = Arrangement.INSTANCE.getStart();
    L89:
        if (r7 == 0) goto L91;
        Arrangement.Vertical r8 = Arrangement.INSTANCE.getTop();
    L92:
        if (r10 == 0) goto L94;
        Alignment.Vertical r16 = Alignment.Companion.getTop();
    L95:
        int r17 = Integer.MAX_VALUE;
        if (r12 == 0) goto L98;
        int r18 = Integer.MAX_VALUE;
    L99:
        if (r14 != 0) goto L103;
        r17 = r15;
    L103:
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventStart(-1303174015, r4, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
    L105:
        FlowRowOverflow r19 = FlowRowOverflow.Companion.getClip();
        int r110 = (((((((r4 & 14) | 1572864) | (r4 & 112)) | (r4 & 896)) | (r4 & 7168)) | (57344 & r4)) | (458752 & r4)) | ((r4 << 3) & 29360128);
        FlowRow(r3, r6, r8, r16, r18, r17, r19, r26, r1, r110, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L108;
        ComposerKt.traceEventEnd();
    L108:
        final Alignment.Vertical r30 = r16;
        r15 = r17;
        final int r31 = r18;
        final Arrangement.Vertical r32 = r8;
        Modifier r33 = r3;
    L110:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L114;
        final Modifier r34 = r33;
        final Arrangement.Horizontal r35 = r6;
        final int r36 = r15;
        r111.updateScope(new o0(r34, r35, r32, r30, r31, r36, r26, r28, r29));
        return;
    L114:
        return;
    L98:
        r18 = r13;
        goto L99
    L94:
        r16 = r11;
        goto L95
    L91:
        r8 = r9;
        goto L92
    L86:
        r3 = r20;
        goto L87
    L109:
        r1.skipToGroupEnd();
        r33 = r20;
        r32 = r9;
        r30 = r11;
        r31 = r13;
        goto L110
    L81:
        r0 = false;
        goto L83
    L72:
        if ((r28 & 1572864) != 0) goto L79;
        if (r1.changedInstance(r26) == false) goto L76;
        int r112 = 1048576;
    L77:
        r4 = r4 | r112;
        goto L79
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r28) != 0) goto L67;
        r15 = r25;
        if (r1.changed(r15) == false) goto L65;
        int r113 = 131072;
    L66:
        r4 = r4 | r113;
        goto L69
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r28 & 24576) != 0) goto L56;
        r13 = r24;
        if (r1.changed(r13) == false) goto L54;
        int r114 = 16384;
    L55:
        r4 = r4 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L39:
        if ((r28 & 3072) != 0) goto L45;
        r11 = r23;
        if (r1.changed(r11) == false) goto L43;
        int r115 = 2048;
    L44:
        r4 = r4 | r115;
        goto L46
    L43:
        r115 = 1024;
        goto L44
    L28:
        if ((r28 & 384) != 0) goto L34;
        r9 = r22;
        if (r1.changed(r9) == false) goto L32;
        int r116 = 256;
    L33:
        r4 = r4 | r116;
        goto L35
    L32:
        r116 = 128;
        goto L33
    L17:
        if ((r28 & 48) != 0) goto L23;
        r6 = r21;
        if (r1.changed(r6) == false) goto L21;
        int r37 = 32;
    L22:
        r4 = r4 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r4 = r28;
        goto L13
    L8:
        if (r1.changed(r20) == false) goto L10;
        int r38 = 4;
    L11:
        r4 = r38 | r28;
        goto L13
    L10:
        r38 = 2;
        goto L11
    }

    @Deprecated(message = "The overflow parameter has been deprecated")
    public static final void FlowColumn(Modifier r22, Arrangement.Vertical r23, Arrangement.Horizontal r24, Alignment.Horizontal r25, int r26, int r27, FlowColumnOverflow r28, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-1944405121);
        int r2 = r32 & 1;
        if (r2 == 0) goto L6;
        int r4 = r31 | 6;
    L13:
        int r5 = r32 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Arrangement.Vertical r7 = r23;
    L24:
        int r11 = r32 & 4;
        if (r11 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Arrangement.Horizontal r12 = r24;
    L35:
        int r13 = r32 & 8;
        if (r13 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Alignment.Horizontal r14 = r25;
    L46:
        int r16 = r32 & 16;
        if (r16 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        int r15 = r26;
    L57:
        int r17 = r32 & 32;
        if (r17 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r18 = r32 & 64;
        if (r18 == 0) goto L71;
        r4 = r4 | 1572864;
    L78:
        if ((r32 & 128) == 0) goto L81;
        r4 = r4 | 12582912;
    L88:
        if ((4793491 & r4) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L173;
        if (r2 == 0) goto L95;
        Modifier r3 = Modifier.Companion;
    L96:
        if (r5 == 0) goto L98;
        r7 = Arrangement.INSTANCE.getTop();
    L98:
        if (r11 == 0) goto L100;
        Arrangement.Horizontal r6 = Arrangement.INSTANCE.getStart();
    L101:
        if (r13 == 0) goto L103;
        Alignment.Horizontal r8 = Alignment.Companion.getStart();
    L104:
        if (r16 == 0) goto L106;
        int r9 = Integer.MAX_VALUE;
    L107:
        if (r17 == 0) goto L109;
        int r21 = Integer.MAX_VALUE;
    L110:
        if (r18 == 0) goto L112;
        FlowColumnOverflow r19 = FlowColumnOverflow.Companion.getClip();
    L114:
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventStart(-1944405121, r4, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
    L116:
        int r110 = r4 & 3670016;
        if (r110 != 1048576) goto L119;
        boolean r111 = true;
    L120:
        Object r112 = r1.rememberedValue();
        if (r111 == false) goto L123;
    L124:
        r112 = r19.createOverflowState$foundation_layout();
        r1.updateRememberedValue(r112);
    L125:
        FlowLayoutOverflowState r113 = (FlowLayoutOverflowState) r112;
        int r114 = r4 >> 3;
        int r10 = r114 & 896;
        int r115 = ((r10 | ((r114 & 14) | (r114 & 112))) | (r114 & 7168)) | (r114 & 57344);
        Arrangement.Horizontal r210 = r6;
        Alignment.Horizontal r211 = r8;
        int r212 = r9;
        FlowColumnOverflow r20 = r19;
        MultiContentMeasurePolicy r116 = columnMeasurementMultiContentHelper(r7, r6, r8, r9, r21, r113, r1, r115);
        if (r110 != 1048576) goto L128;
        boolean r33 = true;
    L130:
        if ((29360128 & r4) != 8388608) goto L132;
        boolean r117 = true;
    L133:
        boolean r34 = r33 | r117;
        if ((458752 & r4) != 131072) goto L136;
        boolean r118 = true;
    L137:
        boolean r35 = r34 | r118;
        Object r119 = r1.rememberedValue();
        if (r35 == false) goto L140;
    L143:
        ArrayList r120 = new ArrayList();
        r120.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new FlowLayoutKt$FlowColumn$list$1$1(r29)));
        r20.addOverflowComposables$foundation_layout(r113, r120);
        r1.updateRememberedValue(r120);
        Object r121 = r120;
    L144:
        int r36 = (r4 << 3) & 112;
        Function2 r37 = LayoutKt.combineAsVirtualLayouts((List) r121);
        if (((r36 & 896) ^ 384) <= 256) goto L149;
        if (r1.changed(r116) == false) goto L149;
    L150:
        boolean r38 = true;
    L152:
        Object r39 = r1.rememberedValue();
        if (r38 == false) goto L155;
    L156:
        r39 = MultiContentMeasurePolicyKt.createMeasurePolicy(r116);
        r1.updateRememberedValue(r39);
    L157:
        MeasurePolicy r40 = (MeasurePolicy) r39;
        long r122 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r41 = (int) (r122 ^ (r122 >>> 32));
        CompositionLocalMap r123 = r1.getCurrentCompositionLocalMap();
        Modifier r124 = ComposedModifierKt.materializeModifier(r1, r3);
        ComposeUiNode.Companion r125 = ComposeUiNode.Companion;
        Function0 r126 = r125.getConstructor();
        int r42 = (((r36 & 112) << 6) & 896) | 6;
        if ((r1.getApplier() instanceof Applier) == true) goto L160;
        ComposablesKt.invalidApplier();
    L160:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L163;
        r1.createNode(r126);
    L164:
        Composer r127 = Updater.constructor-impl(r1);
        Updater.set-impl(r127, r40, r125.getSetMeasurePolicy());
        Updater.set-impl(r127, r123, r125.getSetResolvedCompositionLocals());
        Function2 r43 = r125.getSetCompositeKeyHash();
        if (r127.getInserting() == false) goto L167;
    L168:
        r127.updateRememberedValue(Integer.valueOf(r41));
        r127.apply(Integer.valueOf(r41), r43);
    L169:
        Updater.set-impl(r127, r124, r125.getSetModifier());
        r37.invoke(r1, Integer.valueOf((r42 >> 6) & 14));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L172;
        ComposerKt.traceEventEnd();
    L172:
        final Alignment.Horizontal r44 = r211;
        final int r45 = r212;
        Modifier r46 = r3;
        FlowColumnOverflow r128 = r20;
        final int r47 = r21;
        final Arrangement.Horizontal r48 = r210;
    L174:
        ScopeUpdateScope r129 = r1.endRestartGroup();
        if (r129 == null) goto L178;
        final Modifier r49 = r46;
        final Arrangement.Vertical r50 = r7;
        final FlowColumnOverflow r51 = r128;
        r129.updateScope(new q0(r49, r50, r48, r44, r45, r47, r51, r29, r31, r32));
        return;
    L178:
        return;
    L167:
        if (Intrinsics.areEqual(r127.rememberedValue(), Integer.valueOf(r41)) == true) goto L169;
    L163:
        r1.useNode();
        goto L164
    L155:
        if (r39 != Composer.Companion.getEmpty()) goto L157;
    L149:
        if ((r36 & 384) == 256) goto L150;
        r38 = false;
        goto L152
    L140:
        if (r119 == Composer.Companion.getEmpty()) goto L143;
        r121 = r119;
        goto L144
    L136:
        r118 = false;
        goto L137
    L132:
        r117 = false;
        goto L133
    L128:
        r33 = false;
        goto L130
    L123:
        if (r112 != Composer.Companion.getEmpty()) goto L125;
    L119:
        r111 = false;
        goto L120
    L112:
        r19 = r28;
        goto L114
    L109:
        r21 = r27;
        goto L110
    L106:
        r9 = r15;
        goto L107
    L103:
        r8 = r14;
        goto L104
    L100:
        r6 = r12;
        goto L101
    L95:
        r3 = r22;
        goto L96
    L173:
        r1.skipToGroupEnd();
        r46 = r22;
        r47 = r27;
        r128 = r28;
        r48 = r12;
        r44 = r14;
        r45 = r15;
        goto L174
    L90:
        r0 = false;
        goto L92
    L81:
        if ((r31 & 12582912) != 0) goto L88;
        if (r1.changedInstance(r29) == false) goto L85;
        int r52 = 8388608;
    L86:
        r4 = r4 | r52;
        goto L88
    L85:
        r52 = 4194304;
        goto L86
    L71:
        if ((r31 & 1572864) != 0) goto L78;
        if (r1.changed(r28) == false) goto L75;
        int r213 = 1048576;
    L76:
        r4 = r4 | r213;
        goto L78
    L75:
        r213 = 524288;
        goto L76
    L61:
        if ((r31 & 196608) != 0) goto L67;
        if (r1.changed(r27) == false) goto L65;
        int r130 = 131072;
    L66:
        r4 = r4 | r130;
        goto L67
    L65:
        r130 = 65536;
        goto L66
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r15 = r26;
        if (r1.changed(r15) == false) goto L54;
        int r131 = 16384;
    L55:
        r4 = r4 | r131;
        goto L57
    L54:
        r131 = 8192;
        goto L55
    L39:
        if ((r31 & 3072) != 0) goto L45;
        r14 = r25;
        if (r1.changed(r14) == false) goto L43;
        int r132 = 2048;
    L44:
        r4 = r4 | r132;
        goto L46
    L43:
        r132 = 1024;
        goto L44
    L28:
        if ((r31 & 384) != 0) goto L34;
        r12 = r24;
        if (r1.changed(r12) == false) goto L32;
        int r133 = 256;
    L33:
        r4 = r4 | r133;
        goto L35
    L32:
        r133 = 128;
        goto L33
    L17:
        if ((r31 & 48) != 0) goto L23;
        r7 = r23;
        if (r1.changed(r7) == false) goto L21;
        int r134 = 32;
    L22:
        r4 = r4 | r134;
        goto L24
    L21:
        r134 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r4 = r31;
        goto L13
    L8:
        if (r1.changed(r22) == false) goto L10;
        int r53 = 4;
    L11:
        r4 = r53 | r31;
        goto L13
    L10:
        r53 = 2;
        goto L11
    }

    @Deprecated(message = "The overflow parameter has been deprecated")
    public static final void FlowRow(Modifier r22, Arrangement.Horizontal r23, Arrangement.Vertical r24, Alignment.Vertical r25, int r26, int r27, FlowRowOverflow r28, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31, final int r32) {
        Composer r1 = r30.startRestartGroup(-1956591841);
        int r2 = r32 & 1;
        if (r2 == 0) goto L6;
        int r4 = r31 | 6;
    L13:
        int r5 = r32 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Arrangement.Horizontal r7 = r23;
    L24:
        int r11 = r32 & 4;
        if (r11 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Arrangement.Vertical r12 = r24;
    L35:
        int r13 = r32 & 8;
        if (r13 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Alignment.Vertical r14 = r25;
    L46:
        int r16 = r32 & 16;
        if (r16 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        int r15 = r26;
    L57:
        int r17 = r32 & 32;
        if (r17 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        int r18 = r32 & 64;
        if (r18 == 0) goto L71;
        r4 = r4 | 1572864;
    L78:
        if ((r32 & 128) == 0) goto L81;
        r4 = r4 | 12582912;
    L88:
        if ((4793491 & r4) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L173;
        if (r2 == 0) goto L95;
        Modifier r3 = Modifier.Companion;
    L96:
        if (r5 == 0) goto L98;
        r7 = Arrangement.INSTANCE.getStart();
    L98:
        if (r11 == 0) goto L100;
        Arrangement.Vertical r6 = Arrangement.INSTANCE.getTop();
    L101:
        if (r13 == 0) goto L103;
        Alignment.Vertical r8 = Alignment.Companion.getTop();
    L104:
        if (r16 == 0) goto L106;
        int r9 = Integer.MAX_VALUE;
    L107:
        if (r17 == 0) goto L109;
        int r21 = Integer.MAX_VALUE;
    L110:
        if (r18 == 0) goto L112;
        FlowRowOverflow r19 = FlowRowOverflow.Companion.getClip();
    L114:
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventStart(-1956591841, r4, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
    L116:
        int r110 = r4 & 3670016;
        if (r110 != 1048576) goto L119;
        boolean r111 = true;
    L120:
        Object r112 = r1.rememberedValue();
        if (r111 == false) goto L123;
    L124:
        r112 = r19.createOverflowState$foundation_layout();
        r1.updateRememberedValue(r112);
    L125:
        FlowLayoutOverflowState r113 = (FlowLayoutOverflowState) r112;
        int r114 = r4 >> 3;
        int r10 = r114 & 896;
        int r115 = ((r10 | ((r114 & 14) | (r114 & 112))) | (r114 & 7168)) | (r114 & 57344);
        Arrangement.Vertical r210 = r6;
        Alignment.Vertical r211 = r8;
        int r212 = r9;
        FlowRowOverflow r20 = r19;
        MultiContentMeasurePolicy r116 = rowMeasurementMultiContentHelper(r7, r6, r8, r9, r21, r113, r1, r115);
        if (r110 != 1048576) goto L128;
        boolean r33 = true;
    L130:
        if ((29360128 & r4) != 8388608) goto L132;
        boolean r117 = true;
    L133:
        boolean r34 = r33 | r117;
        if ((458752 & r4) != 131072) goto L136;
        boolean r118 = true;
    L137:
        boolean r35 = r34 | r118;
        Object r119 = r1.rememberedValue();
        if (r35 == false) goto L140;
    L143:
        ArrayList r120 = new ArrayList();
        r120.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new FlowLayoutKt$FlowRow$list$1$1(r29)));
        r20.addOverflowComposables$foundation_layout(r113, r120);
        r1.updateRememberedValue(r120);
        Object r121 = r120;
    L144:
        int r36 = (r4 << 3) & 112;
        Function2 r37 = LayoutKt.combineAsVirtualLayouts((List) r121);
        if (((r36 & 896) ^ 384) <= 256) goto L149;
        if (r1.changed(r116) == false) goto L149;
    L150:
        boolean r38 = true;
    L152:
        Object r39 = r1.rememberedValue();
        if (r38 == false) goto L155;
    L156:
        r39 = MultiContentMeasurePolicyKt.createMeasurePolicy(r116);
        r1.updateRememberedValue(r39);
    L157:
        MeasurePolicy r40 = (MeasurePolicy) r39;
        long r122 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r41 = (int) (r122 ^ (r122 >>> 32));
        CompositionLocalMap r123 = r1.getCurrentCompositionLocalMap();
        Modifier r124 = ComposedModifierKt.materializeModifier(r1, r3);
        ComposeUiNode.Companion r125 = ComposeUiNode.Companion;
        Function0 r126 = r125.getConstructor();
        int r42 = (((r36 & 112) << 6) & 896) | 6;
        if ((r1.getApplier() instanceof Applier) == true) goto L160;
        ComposablesKt.invalidApplier();
    L160:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L163;
        r1.createNode(r126);
    L164:
        Composer r127 = Updater.constructor-impl(r1);
        Updater.set-impl(r127, r40, r125.getSetMeasurePolicy());
        Updater.set-impl(r127, r123, r125.getSetResolvedCompositionLocals());
        Function2 r43 = r125.getSetCompositeKeyHash();
        if (r127.getInserting() == false) goto L167;
    L168:
        r127.updateRememberedValue(Integer.valueOf(r41));
        r127.apply(Integer.valueOf(r41), r43);
    L169:
        Updater.set-impl(r127, r124, r125.getSetModifier());
        r37.invoke(r1, Integer.valueOf((r42 >> 6) & 14));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L172;
        ComposerKt.traceEventEnd();
    L172:
        final Alignment.Vertical r44 = r211;
        final int r45 = r212;
        Modifier r46 = r3;
        FlowRowOverflow r128 = r20;
        final int r47 = r21;
        final Arrangement.Vertical r48 = r210;
    L174:
        ScopeUpdateScope r129 = r1.endRestartGroup();
        if (r129 == null) goto L178;
        final Modifier r49 = r46;
        final Arrangement.Horizontal r50 = r7;
        final FlowRowOverflow r51 = r128;
        r129.updateScope(new l0(r49, r50, r48, r44, r45, r47, r51, r29, r31, r32));
        return;
    L178:
        return;
    L167:
        if (Intrinsics.areEqual(r127.rememberedValue(), Integer.valueOf(r41)) == true) goto L169;
    L163:
        r1.useNode();
        goto L164
    L155:
        if (r39 != Composer.Companion.getEmpty()) goto L157;
    L149:
        if ((r36 & 384) == 256) goto L150;
        r38 = false;
        goto L152
    L140:
        if (r119 == Composer.Companion.getEmpty()) goto L143;
        r121 = r119;
        goto L144
    L136:
        r118 = false;
        goto L137
    L132:
        r117 = false;
        goto L133
    L128:
        r33 = false;
        goto L130
    L123:
        if (r112 != Composer.Companion.getEmpty()) goto L125;
    L119:
        r111 = false;
        goto L120
    L112:
        r19 = r28;
        goto L114
    L109:
        r21 = r27;
        goto L110
    L106:
        r9 = r15;
        goto L107
    L103:
        r8 = r14;
        goto L104
    L100:
        r6 = r12;
        goto L101
    L95:
        r3 = r22;
        goto L96
    L173:
        r1.skipToGroupEnd();
        r46 = r22;
        r47 = r27;
        r128 = r28;
        r48 = r12;
        r44 = r14;
        r45 = r15;
        goto L174
    L90:
        r0 = false;
        goto L92
    L81:
        if ((r31 & 12582912) != 0) goto L88;
        if (r1.changedInstance(r29) == false) goto L85;
        int r52 = 8388608;
    L86:
        r4 = r4 | r52;
        goto L88
    L85:
        r52 = 4194304;
        goto L86
    L71:
        if ((r31 & 1572864) != 0) goto L78;
        if (r1.changed(r28) == false) goto L75;
        int r213 = 1048576;
    L76:
        r4 = r4 | r213;
        goto L78
    L75:
        r213 = 524288;
        goto L76
    L61:
        if ((r31 & 196608) != 0) goto L67;
        if (r1.changed(r27) == false) goto L65;
        int r130 = 131072;
    L66:
        r4 = r4 | r130;
        goto L67
    L65:
        r130 = 65536;
        goto L66
    L50:
        if ((r31 & 24576) != 0) goto L56;
        r15 = r26;
        if (r1.changed(r15) == false) goto L54;
        int r131 = 16384;
    L55:
        r4 = r4 | r131;
        goto L57
    L54:
        r131 = 8192;
        goto L55
    L39:
        if ((r31 & 3072) != 0) goto L45;
        r14 = r25;
        if (r1.changed(r14) == false) goto L43;
        int r132 = 2048;
    L44:
        r4 = r4 | r132;
        goto L46
    L43:
        r132 = 1024;
        goto L44
    L28:
        if ((r31 & 384) != 0) goto L34;
        r12 = r24;
        if (r1.changed(r12) == false) goto L32;
        int r133 = 256;
    L33:
        r4 = r4 | r133;
        goto L35
    L32:
        r133 = 128;
        goto L33
    L17:
        if ((r31 & 48) != 0) goto L23;
        r7 = r23;
        if (r1.changed(r7) == false) goto L21;
        int r134 = 32;
    L22:
        r4 = r4 | r134;
        goto L24
    L21:
        r134 = 16;
        goto L22
    L6:
        if ((r31 & 6) == 0) goto L8;
        r4 = r31;
        goto L13
    L8:
        if (r1.changed(r22) == false) goto L10;
        int r53 = 4;
    L11:
        r4 = r53 | r31;
        goto L13
    L10:
        r53 = 2;
        goto L11
    }
}
