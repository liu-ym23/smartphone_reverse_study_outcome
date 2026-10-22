package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ª\u00012\u00020\u0001:\u0002ª\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\fJ\u0015\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u000eH\u0000¢\u0006\u0002\bSJC\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2*\u0010}\u001a&\b\u0001\u0012\u0004\u0012\u00020\u007f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020z0\u0080\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010~¢\u0006\u0003\b\u0082\u0001H\u0096@¢\u0006\u0003\u0010\u0083\u0001J\u0012\u0010\u0085\u0001\u001a\u00020Q2\u0007\u0010\u0086\u0001\u001a\u00020QH\u0002J$\u0010\u0087\u0001\u001a\u00020z2\u0007\u0010\u0088\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\nH\u0086@¢\u0006\u0003\u0010\u008a\u0001J$\u0010\u008b\u0001\u001a\u00020z2\u0007\u0010\u0088\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\nH\u0086@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u008e\u0001\u001a\u00020z2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\nJ*\u0010\u008f\u0001\u001a\u00020z2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b\u0091\u0001J\"\u0010\u0092\u0001\u001a\u00020\u00032\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020Q2\u0007\u0010\u0098\u0001\u001a\u00020QH\u0016J\u001d\u0010\u0099\u0001\u001a\u00020z2\u0007\u0010\u0098\u0001\u001a\u00020Q2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u0012H\u0002J\u0019\u0010\u009b\u0001\u001a\u00020z2\u000e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u009d\u0001H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020z2\u0007\u0010\u009a\u0001\u001a\u00020 H\u0002J+\u0010\u009f\u0001\u001a\u00020z2\u0007\u0010 \u0001\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u000e2\t\b\u0002\u0010¡\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b¢\u0001J\u001a\u0010¨\u0001\u001a\u00020\u00032\u0007\u0010©\u0001\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0002R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0012@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R+\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010-R+\u00100\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010-R\u0014\u00104\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0011R\"\u00109\u001a\u0004\u0018\u0001082\b\u0010\r\u001a\u0004\u0018\u000108@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020EX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010-R\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0018\"\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[0ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u0018R\u0011\u0010^\u001a\u00020_8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020l0kX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u001b\u0010o\u001a\u00020p8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bs\u0010t*\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020vX\u0080\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\bw\u0010xR\u0016\u0010\u0084\u0001\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0011R\u0018\u0010\u008c\u0001\u001a\u00020vX\u0080\u0004¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u008d\u0001\u0010xR\u0017\u0010£\u0001\u001a\u00020Q8@X\u0080\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "([I[ILandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "()Z", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "(Z)V", "canScrollForward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "scrollableState", "scrollToBeConsumed", "", "isLookingAhead", "scrollToBeConsumed$foundation_release", "measurePassCount", "getMeasurePassCount$foundation_release", "setMeasurePassCount$foundation_release", "(I)V", "prefetchBaseIndex", "currentItemPrefetchHandles", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "laneCount", "getLaneCount$foundation_release", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isScrollInProgress", "onScroll", "distance", "scrollToItem", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToItem", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "requestScrollToItem", "snapToItemInternal", "forceRemeasure", "snapToItemInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "dispatchRawDelta", "delta", "notifyPrefetch", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "", "cancelPrefetchIfVisibleItemsChanged", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation_release", "()F", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "fillNearestIndices", "itemIndex", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<LazyStaggeredGridState, Object> Saver = null;
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private LazyStaggeredGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final Map<Integer, LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private boolean hasLookaheadOccurred;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> itemAnimator;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final MutableState<LazyStaggeredGridMeasureResult> layoutInfoState;
    private int measurePassCount;
    private final MutableState<Unit> measurementScopeInvalidator;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.access$getSaver$cp();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ LazyStaggeredGridMeasureResult $layoutInfo;
        final /* synthetic */ int $numOfItemsToTeleport;
        final /* synthetic */ int $scrollOffset;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public AnonymousClass2(LazyStaggeredGridState r1, int r2, int r3, int r4, LazyStaggeredGridMeasureResult r5, Continuation<? super AnonymousClass2> r6) {
            this.this$0 = r1;
            this.$index = r2;
            this.$scrollOffset = r3;
            this.$numOfItemsToTeleport = r4;
            this.$layoutInfo = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass2 r7 = new AnonymousClass2(this.this$0, this.$index, this.$scrollOffset, this.$numOfItemsToTeleport, this.$layoutInfo, r10);
            r7.L$0 = r9;
            return r7;
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            ScrollScope r11 = (ScrollScope) this.L$0;
            LazyLayoutScrollScope r3 = LazyStaggeredGridScrollScopeKt.LazyLayoutScrollScope(this.this$0, r11);
            int r4 = this.$index;
            int r5 = this.$scrollOffset;
            int r6 = this.$numOfItemsToTeleport;
            Density r7 = this.$layoutInfo.getDensity();
            this.label = 1;
            if (LazyLayoutScrollScopeKt.animateScrollToItem(r3, r4, r5, r6, r7, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$requestScrollToItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$requestScrollToItem$1", f = "LazyStaggeredGridState.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public AnonymousClass1(LazyStaggeredGridState r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            LazyStaggeredGridState r5 = this.this$0;
            this.label = 1;
            if (ScrollExtensionsKt.stopScroll$default(r5, null, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState", f = "LazyStaggeredGridState.kt", i = {0, 0}, l = {253, 254}, m = "scroll", n = {"scrollPriority", "block"}, s = {"L$0", "L$1"})
    public static final class C02051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public C02051(LazyStaggeredGridState r1, Continuation<? super C02051> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.scroll(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02062 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public C02062(LazyStaggeredGridState r1, int r2, int r3, Continuation<? super C02062> r4) {
            this.this$0 = r1;
            this.$index = r2;
            this.$scrollOffset = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02062(this.this$0, this.$index, this.$scrollOffset, r5);
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            this.this$0.snapToItemInternal$foundation_release(this.$index, this.$scrollOffset, true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ LazyStaggeredGridState a(List r0) {
        return Saver$lambda$5(r0);
    }

    public static /* synthetic */ List b(SaverScope r0, LazyStaggeredGridState r1) {
        return Saver$lambda$4(r0, r1);
    }

    public static /* synthetic */ float c(LazyStaggeredGridState r0, float r1) {
        return scrollableState$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new s(), new t());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final int getLaneCount$foundation_release() {
        return ((LazyStaggeredGridMeasureResult) this.layoutInfoState.getValue()).getSlots().getSizes().length;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return (LazyStaggeredGridLayoutInfo) this.layoutInfoState.getValue();
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation_release();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final LazyStaggeredGridMeasureResult getApproachLayoutInfo$foundation_release() {
        return this.approachLayoutInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final boolean getHasLookaheadOccurred$foundation_release() {
        return this.hasLookaheadOccurred;
    }

    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    public final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo$foundation_release() {
        return this.laneInfo;
    }

    public final int getMeasurePassCount$foundation_release() {
        return this.measurePassCount;
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1233getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final MutableInteractionSource getMutableInteractionSource$foundation_release() {
        return this.mutableInteractionSource;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1234getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return this.remeasurement;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final LazyStaggeredGridScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
    }

    private static final LazyStaggeredGridState Saver$lambda$5(List r3) {
        return new LazyStaggeredGridState((int[]) ListProtector.get(r3, 0), (int[]) ListProtector.get(r3, 1), null);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo r6) {
        List<LazyStaggeredGridItemInfo> r7 = r6.getVisibleItemsInfo();
        if (this.prefetchBaseIndex == (-1)) goto L19;
        boolean r2 = true;
        if ((!r7.isEmpty()) == false) goto L20;
        int r0 = ((LazyStaggeredGridItemInfo) CollectionsKt.first(r7)).getIndex();
        int r8 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(r7)).getIndex();
        int r3 = this.prefetchBaseIndex;
        if (r0 > r3) goto L10;
        if (r3 > r8) goto L10;
    L11:
        if (r2 == true) goto L21;
        this.prefetchBaseIndex = -1;
        Iterator<T> r9 = this.currentItemPrefetchHandles.values().iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        ((LazyLayoutPrefetchState.PrefetchHandle) r9.next()).cancel();
        goto L14
    L16:
        this.currentItemPrefetchHandles.clear();
        return;
    L21:
        return;
    L10:
        r2 = false;
        goto L11
    L20:
        return;
    }

    private final void clearLeftoverPrefetchHandles(Set<Integer> r4) {
        Iterator<Map.Entry<Integer, LazyLayoutPrefetchState.PrefetchHandle>> r0 = this.currentItemPrefetchHandles.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Integer, LazyLayoutPrefetchState.PrefetchHandle> r1 = r0.next();
        if (r4.contains(r1.getKey()) == true) goto L4;
        r1.getValue().cancel();
        r0.remove();
        goto L4
    }

    private static Object getNearestRange$foundation_release$delegate(LazyStaggeredGridState r0) {
        return r0.scrollPosition.getNearestRangeState();
    }

    private final float onScroll(float r9) {
        if (r9 >= MenuKt.ClosedAlphaTarget) goto L7;
        if (getCanScrollForward() == true) goto L7;
    L10:
        return MenuKt.ClosedAlphaTarget;
    L7:
        if (r9 <= MenuKt.ClosedAlphaTarget) goto L12;
        if (getCanScrollBackward() == false) goto L10;
    L12:
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L17;
        InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
    L17:
        float r2 = this.scrollToBeConsumed + r9;
        this.scrollToBeConsumed = r2;
        if (Math.abs(r2) <= 0.5f) goto L36;
        float r3 = this.scrollToBeConsumed;
        int r4 = MathKt.roundToInt(r3);
        LazyStaggeredGridMeasureResult r5 = ((LazyStaggeredGridMeasureResult) this.layoutInfoState.getValue()).copyWithScrollDeltaWithoutRemeasure(r4, !this.hasLookaheadOccurred);
        if (r5 == null) goto L29;
        LazyStaggeredGridMeasureResult r7 = this.approachLayoutInfo;
        if (r7 == null) goto L29;
        if (r7 == null) goto L25;
        LazyStaggeredGridMeasureResult r6 = r7.copyWithScrollDeltaWithoutRemeasure(r4, true);
    L26:
        if (r6 == null) goto L28;
        this.approachLayoutInfo = r6;
        goto L29
    L28:
        r5 = null;
        goto L29
    L25:
        r6 = null;
    L29:
        if (r5 == null) goto L31;
        applyMeasureResult$foundation_release(r5, this.hasLookaheadOccurred, true);
        ObservableScopeInvalidator.m1191invalidateScopeimpl(this.placementScopeInvalidator);
        notifyPrefetch(r3 - this.scrollToBeConsumed, r5);
        goto L36
    L31:
        Remeasurement r8 = this.remeasurement;
        if (r8 == null) goto L34;
        r8.forceRemeasure();
    L34:
        notifyPrefetch$default(this, r3 - this.scrollToBeConsumed, null, 2, null);
    L36:
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) goto L38;
        return r9;
    L38:
        float r10 = r9 - this.scrollToBeConsumed;
        this.scrollToBeConsumed = MenuKt.ClosedAlphaTarget;
        return r10;
    L14:
        r1 = false;
        goto L15
    }

    private void setCanScrollBackward(boolean r2) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(r2));
    }

    private void setCanScrollForward(boolean r2) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(r2));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float r2) {
        return this.scrollableState.dispatchRawDelta(r2);
    }

    public final float scrollToBeConsumed$foundation_release(boolean r1) {
        if (r1 == true) goto L8;
        if (this.hasLookaheadOccurred == false) goto L8;
        return getScrollDeltaBetweenPasses$foundation_release();
    L8:
        return this.scrollToBeConsumed;
    }

    public final void setMeasurePassCount$foundation_release(int r1) {
        this.measurePassCount = r1;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean r1) {
        this.prefetchingEnabled = r1;
    }

    public LazyStaggeredGridState(int r4, int r5) {
        this(new int[]{r4}, new int[]{r5}, null);
    }

    private static final List Saver$lambda$4(SaverScope r2, LazyStaggeredGridState r3) {
        return CollectionsKt.listOf(new int[][]{r3.scrollPosition.getIndices(), r3.scrollPosition.getScrollOffsets()});
    }

    public static final /* synthetic */ void access$setRemeasurement$p(LazyStaggeredGridState r0, Remeasurement r1) {
        r0.remeasurement = r1;
    }

    private final int[] fillNearestIndices(int r11, int r12) {
        int[] r6 = new int[r12];
        if (((LazyStaggeredGridMeasureResult) this.layoutInfoState.getValue()).getSpanProvider().isFullSpan(r11) == false) goto L6;
        ArraysKt.fill$default(r6, r11, 0, 0, 6, null);
        return r6;
    L6:
        this.laneInfo.ensureValidIndex(r11 + r12);
        int r0 = this.laneInfo.getLane(r11);
        boolean r2 = false;
        if (r0 == (-2)) goto L14;
        if (r0 == (-1)) goto L14;
        if (r0 < 0) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("Expected positive lane number, got " + r0 + " instead.");
    L13:
        int r8 = Math.min(r0, r12);
    L15:
        int r4 = r8 - 1;
        int r1 = r11;
    L16:
        if ((-1) >= r4) goto L21;
        r1 = this.laneInfo.findPreviousItemIndex(r1, r4);
        r6[r4] = r1;
        if (r1 == (-1)) goto L19;
        r4 = r4 - 1;
        goto L16
    L19:
        ArraysKt.fill$default(r6, -1, 0, r4, 2, null);
    L21:
        r6[r8] = r11;
        int r9 = r8 + 1;
    L22:
        if (r9 >= r12) goto L24;
        r11 = this.laneInfo.findNextItemIndex(r11, r9);
        r6[r9] = r11;
        r9 = r9 + 1;
        goto L22
    L24:
        return r6;
    L14:
        r8 = 0;
        goto L15
    }

    private final void notifyPrefetch(float r19, LazyStaggeredGridMeasureResult r20) {
        if (this.prefetchingEnabled == false) goto L56;
        int r2 = 1;
        if ((!r20.getVisibleItemsInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (r19 >= MenuKt.ClosedAlphaTarget) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        int r4 = ((LazyStaggeredGridMeasuredItem) CollectionsKt.last(r20.getVisibleItemsInfo())).getIndex();
    L14:
        if (r4 != this.prefetchBaseIndex) goto L16;
        return;
    L16:
        this.prefetchBaseIndex = r4;
        LinkedHashSet r5 = new LinkedHashSet();
        LazyStaggeredGridSlots r6 = r20.getSlots();
        int r7 = r6.getSizes().length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L49;
        if (r1 == false) goto L20;
        r4 = this.laneInfo.findNextItemIndex(r4, r8);
    L21:
        if (r4 >= 0) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L49;
        if (r5.contains(Integer.valueOf(r4)) == true) goto L49;
        r5.add(Integer.valueOf(r4));
        if (this.currentItemPrefetchHandles.containsKey(Integer.valueOf(r4)) == true) goto L48;
        boolean r10 = r20.getSpanProvider().isFullSpan(r4);
        if (r10 == false) goto L36;
        int r11 = 0;
    L37:
        if (r10 == false) goto L39;
        int r12 = r7;
    L40:
        if (r12 != r2) goto L42;
        int r13 = r6.getSizes()[r11];
    L44:
        if (r20.getOrientation() != Orientation.Vertical) goto L46;
        long r14 = Constraints.Companion.fixedWidth-OenEA2s(r13);
    L47:
        Integer r15 = Integer.valueOf(r4);
        this.currentItemPrefetchHandles.put(r15, LazyLayoutPrefetchState.m1175schedulePrecompositionAndPremeasureVKLhPVY$default(this.prefetchState, r4, r14, null, 4, null));
        goto L48
    L46:
        r14 = Constraints.Companion.fixedHeight-OenEA2s(r13);
        goto L47
    L42:
        int r16 = r6.getPositions()[r11];
        int r17 = (r11 + r12) - r2;
        r13 = (r6.getPositions()[r17] + r6.getSizes()[r17]) - r16;
        goto L44
    L39:
        r12 = 1;
        goto L40
    L36:
        r11 = r8;
    L48:
        r8 = r8 + 1;
        r2 = 1;
        goto L17
    L23:
        if (r4 >= r20.getTotalItemsCount()) goto L25;
        r9 = true;
        goto L26
    L20:
        r4 = this.laneInfo.findPreviousItemIndex(r4, r8);
    L49:
        clearLeftoverPrefetchHandles(r5);
        return;
    L12:
        r4 = ((LazyStaggeredGridMeasuredItem) CollectionsKt.first(r20.getVisibleItemsInfo())).getIndex();
        goto L14
    L9:
        r1 = false;
        goto L10
    }

    private static final float scrollableState$lambda$0(LazyStaggeredGridState r0, float r1) {
        return -r0.onScroll(-r1);
    }

    public final void requestScrollToItem(int r8, int r9) {
        if (isScrollInProgress() == false) goto L5;
        BuildersKt.launch$default(((LazyStaggeredGridMeasureResult) this.layoutInfoState.getValue()).getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
    L5:
        snapToItemInternal$foundation_release(r8, r9, false);
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyLayoutItemProvider r2, int[] r3) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(r2, r3);
    }

    public LazyStaggeredGridState(int[] r4, int[] r5, PrefetchScheduler r6) {
        LazyStaggeredGridScrollPosition r0 = new LazyStaggeredGridScrollPosition(r4, r5, new LazyStaggeredGridState$scrollPosition$1(this));
        this.scrollPosition = r0;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.laneInfo = new LazyStaggeredGridLaneInfo();
        Boolean r7 = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.remeasurementModifier = new LazyStaggeredGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState(r6, null, 2, null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new r(this));
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new LinkedHashMap();
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.itemAnimator = new LazyLayoutItemAnimator();
        r0.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1187constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m1187constructorimpl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public static final /* synthetic */ int[] access$fillNearestIndices(LazyStaggeredGridState r0, int r1, int r2) {
        return r0.fillNearestIndices(r1, r2);
    }

    public final Object animateScrollToItem(int r10, int r11, Continuation<? super Unit> r12) {
        LazyStaggeredGridMeasureResult r5 = (LazyStaggeredGridMeasureResult) this.layoutInfoState.getValue();
        Object r0 = ScrollableState.CC.scroll$default(this, null, new AnonymousClass2(this, r10, r11, r5.getSlots().getSizes().length * 100, r5, null), r12, 1, null);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(LazyStaggeredGridMeasureResult r4, boolean r5, boolean r6) {
        if (r5 == true) goto L7;
        if (this.hasLookaheadOccurred == false) goto L7;
        this.approachLayoutInfo = r4;
        return;
    L7:
        if (r5 == false) goto L9;
        this.hasLookaheadOccurred = true;
    L9:
        this.scrollToBeConsumed -= r4.getConsumedScroll();
        this.layoutInfoState.setValue(r4);
        if (r6 == false) goto L12;
        this.scrollPosition.updateScrollOffset(r4.getFirstVisibleItemScrollOffsets());
    L13:
        setCanScrollBackward(r4.getCanScrollBackward());
        setCanScrollForward(r4.getCanScrollForward());
        if (r5 == false) goto L16;
        this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation_release(r4.getScrollBackAmount(), r4.getDensity(), r4.getCoroutineScope());
    L16:
        this.measurePassCount++;
        return;
    L12:
        this.scrollPosition.updateFromMeasureResult(r4);
        cancelPrefetchIfVisibleItemsChanged(r4);
        goto L13
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority r6, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C02051) == false) goto L7;
        C02051 r0 = (C02051) r8;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (Function2) r0.L$1;
        r6 = (MutatePriority) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        ScrollableState r10 = this.scrollableState;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r10.scroll(r6, r7, r0) != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        AwaitFirstLayoutModifier r11 = this.awaitLayoutModifier;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.label = 1;
        if (r11.waitForFirstLayout(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new C02051(this, r8);
        goto L8
    }

    public final Object scrollToItem(int r7, int r8, Continuation<? super Unit> r9) {
        Object r10 = ScrollableState.CC.scroll$default(this, null, new C02062(this, r7, r8, null), r9, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void snapToItemInternal$foundation_release(int r6, int r7, boolean r8) {
        int r1 = 0;
        if (this.scrollPosition.getIndex() == r6) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        this.itemAnimator.reset();
    L11:
        LazyStaggeredGridMeasureResult r2 = (LazyStaggeredGridMeasureResult) this.layoutInfoState.getValue();
        LazyStaggeredGridItemInfo r3 = LazyStaggeredGridMeasureResultKt.findVisibleItem(r2, r6);
        if (r3 == null) goto L22;
        if (r0 == false) goto L22;
        if (r2.getOrientation() != Orientation.Vertical) goto L17;
        int r9 = IntOffset.getY-impl(r3.mo1213getOffsetnOccac());
    L18:
        int r10 = r9 + r7;
        int r11 = r2.getFirstVisibleItemScrollOffsets().length;
        int[] r4 = new int[r11];
    L19:
        if (r1 >= r11) goto L21;
        r4[r1] = r2.getFirstVisibleItemScrollOffsets()[r1] + r10;
        r1 = r1 + 1;
        goto L19
    L21:
        this.scrollPosition.updateScrollOffset(r4);
    L23:
        if (r8 == false) goto L27;
        Remeasurement r12 = this.remeasurement;
        if (r12 == null) goto L30;
        r12.forceRemeasure();
        return;
    L30:
        return;
    L27:
        ObservableScopeInvalidator.m1191invalidateScopeimpl(this.measurementScopeInvalidator);
        return;
    L17:
        r9 = IntOffset.getX-impl(r3.mo1213getOffsetnOccac());
    L22:
        this.scrollPosition.requestPositionAndForgetLastKnownKey(r6, r7);
        goto L23
    L5:
        if (this.scrollPosition.getScrollOffset() != r7) goto L8;
        r0 = false;
        goto L9
    }

    public /* synthetic */ LazyStaggeredGridState(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ void notifyPrefetch$default(LazyStaggeredGridState r0, float r1, LazyStaggeredGridMeasureResult r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = (LazyStaggeredGridMeasureResult) r0.layoutInfoState.getValue();
    L5:
        r0.notifyPrefetch(r1, r2);
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyStaggeredGridState r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.requestScrollToItem(r1, r2);
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState r0, int r1, int r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.animateScrollToItem(r1, r2, r3);
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyStaggeredGridState r0, LazyStaggeredGridMeasureResult r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.applyMeasureResult$foundation_release(r1, r2, r3);
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState r0, int r1, int r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.scrollToItem(r1, r2, r3);
    }
}
