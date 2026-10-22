package androidx.compose.foundation.lazy;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ¢\u00012\u00020\u0001:\u0002¢\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB%\b\u0017\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u000bB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\fJ\"\u0010b\u001a\u00020c2\b\b\u0001\u0010d\u001a\u00020\u00032\b\b\u0002\u0010e\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010fJ\u001a\u0010l\u001a\u00020c2\b\b\u0001\u0010d\u001a\u00020\u00032\b\b\u0002\u0010e\u001a\u00020\u0003J%\u0010m\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u00032\u0006\u0010n\u001a\u00020\u0010H\u0000¢\u0006\u0002\boJ?\u0010p\u001a\u00020c2\u0006\u0010q\u001a\u00020r2'\u0010s\u001a#\b\u0001\u0012\u0004\u0012\u00020u\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0v\u0012\u0006\u0012\u0004\u0018\u00010w0t¢\u0006\u0002\bxH\u0096@¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020,2\u0006\u0010{\u001a\u00020,H\u0016J\u0018\u0010\u008c\u0001\u001a\u00020,2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0000¢\u0006\u0003\b\u008e\u0001J\u0019\u0010\u008f\u0001\u001a\u00020c2\u0006\u0010{\u001a\u00020,2\u0006\u0010 \u001a\u00020!H\u0002J#\u0010\u0090\u0001\u001a\u00020c2\b\b\u0001\u0010d\u001a\u00020\u00032\b\b\u0002\u0010e\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010fJ,\u0010\u0091\u0001\u001a\u00020c2\u0007\u0010\u0092\u0001\u001a\u00020\u00142\u0007\u0010\u0093\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b\u0095\u0001J\u0012\u0010\u0096\u0001\u001a\u00020c2\u0007\u0010\u0097\u0001\u001a\u00020\u0014H\u0002J\"\u0010\u009c\u0001\u001a\u00020\u00032\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b \u0001J\u0007\u0010¡\u0001\u001a\u00020cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0014@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020,@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u0002018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u001a\u00107\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010:R\"\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\u000f\u001a\u0004\u0018\u00010;@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020MX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u00020YX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001b\u0010\\\u001a\u00020]8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\b`\u0010a*\u0004\b^\u0010_R\u0016\u0010g\u001a\u00020hX\u0080\u0004¢\u0006\n\n\u0002\u0010k\u001a\u0004\bi\u0010jR\u0014\u0010|\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b|\u0010\u0013R-\u0010~\u001a\u00020\u00102\u0006\u0010}\u001a\u00020\u00108V@RX\u0096\u008e\u0002¢\u0006\u0014\n\u0005\b\u0081\u0001\u0010k\u001a\u0004\b\u007f\u0010\u0013\"\u0005\b\u0080\u0001\u0010:R/\u0010\u0082\u0001\u001a\u00020\u00102\u0006\u0010}\u001a\u00020\u00108V@RX\u0096\u008e\u0002¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010k\u001a\u0005\b\u0083\u0001\u0010\u0013\"\u0005\b\u0084\u0001\u0010:R\u0016\u0010\u0086\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u0013R\u0016\u0010\u0088\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u0010\u0013R\u0018\u0010\u008a\u0001\u001a\u00020hX\u0080\u0004¢\u0006\u000b\n\u0002\u0010k\u001a\u0005\b\u008b\u0001\u0010jR\u0016\u0010\u0098\u0001\u001a\u00020,8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010/R\u0010\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "<init>", "(IILandroidx/compose/foundation/lazy/LazyListPrefetchStrategy;)V", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;II)V", "(II)V", "getPrefetchStrategy$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "()Z", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "executeRequestsInHighPriorityMode", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "scrollableState", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release$annotations", "()V", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/LazyListState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "scrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measurementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/MutableState;", "requestScrollToItem", "snapToItemIndexInternal", "forceRemeasure", "snapToItemIndexInternal$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "isScrollInProgress", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "onScroll", "distance", "onScroll$foundation_release", "notifyPrefetchOnScroll", "animateScrollToItem", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "traceVisibleItems", "measureResult", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation_release", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "resetCacheWindowLogicStrategy", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<LazyListState, ?> Saver = null;
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private LazyListMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private boolean executeRequestsInHighPriorityMode;
    private boolean hasLookaheadOccurred;
    private final MutableInteractionSource internalInteractionSource;
    private final LazyLayoutItemAnimator<LazyListMeasuredItem> itemAnimator;
    private final MutableState<LazyListMeasureResult> layoutInfoState;
    private final MutableState<Unit> measurementScopeInvalidator;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyListPrefetchScope prefetchScope;
    private final LazyLayoutPrefetchState prefetchState;
    private final LazyListPrefetchStrategy prefetchStrategy;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\fR\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "saver", "prefetchStrategy", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "saver$foundation_release", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ List a(SaverScope r0, LazyListState r1) {
            return saver$lambda$2(r0, r1);
        }

        public static /* synthetic */ LazyListState b(LazyLayoutCacheWindow r0, List r1) {
            return saver$lambda$3(r0, r1);
        }

        public static /* synthetic */ LazyListState c(LazyListPrefetchStrategy r0, List r1) {
            return saver$lambda$1(r0, r1);
        }

        public static /* synthetic */ List d(SaverScope r0, LazyListState r1) {
            return saver$lambda$0(r0, r1);
        }

        public final Saver<LazyListState, ?> getSaver() {
            return LazyListState.access$getSaver$cp();
        }

        public final Saver<LazyListState, ?> saver$foundation_release(final LazyListPrefetchStrategy r3) {
            return ListSaverKt.listSaver(new x(), new y(r3));
        }

        public final Saver<LazyListState, ?> saver$foundation_release(final LazyLayoutCacheWindow r3) {
            return ListSaverKt.listSaver(new z(), new a0(r3));
        }

        private static final List saver$lambda$0(SaverScope r2, LazyListState r3) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(r3.getFirstVisibleItemIndex()), Integer.valueOf(r3.getFirstVisibleItemScrollOffset())});
        }

        private static final LazyListState saver$lambda$1(LazyListPrefetchStrategy r3, List r4) {
            return new LazyListState(((Number) ListProtector.get(r4, 0)).intValue(), ((Number) ListProtector.get(r4, 1)).intValue(), r3);
        }

        private static final List saver$lambda$2(SaverScope r2, LazyListState r3) {
            return CollectionsKt.listOf(new Integer[]{Integer.valueOf(r3.getFirstVisibleItemIndex()), Integer.valueOf(r3.getFirstVisibleItemScrollOffset())});
        }

        private static final LazyListState saver$lambda$3(LazyLayoutCacheWindow r2, List r3) {
            return new LazyListState(r2, ((Number) ListProtector.get(r3, 0)).intValue(), ((Number) ListProtector.get(r3, 1)).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$animateScrollToItem$2", f = "LazyListState.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LazyListState this$0;

        public AnonymousClass2(LazyListState r1, int r2, int r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$index = r2;
            this.$scrollOffset = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$index, this.$scrollOffset, r6);
            r0.L$0 = r5;
            return r0;
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
            LazyLayoutScrollScope r3 = LazyListScrollScopeKt.LazyLayoutScrollScope(this.this$0, r11);
            int r4 = this.$index;
            int r5 = this.$scrollOffset;
            Density r7 = this.this$0.getDensity$foundation_release();
            this.label = 1;
            if (LazyLayoutScrollScopeKt.animateScrollToItem(r3, r4, r5, 100, r7, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1", f = "LazyListState.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyListState this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1$1", f = "LazyListState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00261 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
            int label;

            public C00261(Continuation<? super C00261> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new C00261(r2);
            }

            public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((ScrollScope) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(LazyListState r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LazyListState r2 = this.this$0;
            C00261 r3 = new C00261(null);
            this.label = 1;
            if (ScrollableState.CC.scroll$default(r2, null, r3, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$scroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState", f = "LazyListState.kt", i = {0, 0}, l = {443, 444}, m = "scroll", n = {"scrollPriority", "block"}, s = {"L$0", "L$1"})
    public static final class C01811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LazyListState this$0;

        public C01811(LazyListState r1, Continuation<? super C01811> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.scroll(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListState$scrollToItem$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$scrollToItem$2", f = "LazyListState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01822 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;
        final /* synthetic */ LazyListState this$0;

        public C01822(LazyListState r1, int r2, int r3, Continuation<? super C01822> r4) {
            this.this$0 = r1;
            this.$index = r2;
            this.$scrollOffset = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01822(this.this$0, this.$index, this.$scrollOffset, r5);
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
            this.this$0.snapToItemIndexInternal$foundation_release(this.$index, this.$scrollOffset, true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LazyListState() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ float a(LazyListState r0, float r1) {
        return scrollableState$lambda$0(r0, r1);
    }

    public static /* synthetic */ LazyListState b(List r0) {
        return Saver$lambda$9(r0);
    }

    public static /* synthetic */ Unit c(LazyListState r0, int r1, NestedPrefetchScope r2) {
        return prefetchState$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ List d(SaverScope r0, LazyListState r1) {
        return Saver$lambda$8(r0, r1);
    }

    public static /* synthetic */ void getPrefetchState$foundation_release$annotations() {
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new v(), new w());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final Density getDensity$foundation_release() {
        return ((LazyListMeasureResult) this.layoutInfoState.getValue()).getDensity();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        return (LazyListLayoutInfo) this.layoutInfoState.getValue();
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

    public final void resetCacheWindowLogicStrategy() {
        Object r0 = this.prefetchStrategy;
        if ((r0 instanceof CacheWindowLogic) == false) goto L5;
        CacheWindowLogic r1 = (CacheWindowLogic) r0;
    L6:
        if (r1 == null) goto L9;
        r1.resetStrategy();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final LazyListMeasureResult getApproachLayoutInfo$foundation_release() {
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
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final LazyLayoutItemAnimator<LazyListMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1098getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1099getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final LazyListPrefetchStrategy getPrefetchStrategy$foundation_release() {
        return this.prefetchStrategy;
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

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    private static final LazyListState Saver$lambda$9(List r3) {
        return new LazyListState(((Number) ListProtector.get(r3, 0)).intValue(), ((Number) ListProtector.get(r3, 1)).intValue());
    }

    public static final /* synthetic */ boolean access$getExecuteRequestsInHighPriorityMode$p(LazyListState r0) {
        return r0.executeRequestsInHighPriorityMode;
    }

    public static final /* synthetic */ MutableState access$getLayoutInfoState$p(LazyListState r0) {
        return r0.layoutInfoState;
    }

    private static Object getNearestRange$foundation_release$delegate(LazyListState r0) {
        return r0.scrollPosition.getNearestRangeState();
    }

    private void setCanScrollBackward(boolean r2) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(r2));
    }

    private void setCanScrollForward(boolean r2) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void traceVisibleItems(LazyListMeasureResult r6) {
        LazyListMeasuredItem r0 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(r6.getVisibleItemsInfo());
        LazyListMeasuredItem r7 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(r6.getVisibleItemsInfo());
        long r1 = -1;
        if (r0 == null) goto L5;
        long r3 = r0.getIndex();
    L6:
        AndroidTrace_androidKt.traceValue("firstVisibleItem:index", r3);
        if (r7 == null) goto L9;
        r1 = r7.getIndex();
    L9:
        AndroidTrace_androidKt.traceValue("lastVisibleItem:index", r1);
        return;
    L5:
        r3 = -1;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float r2) {
        return this.scrollableState.dispatchRawDelta(r2);
    }

    public final float onScroll$foundation_release(float r9) {
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
        this.executeRequestsInHighPriorityMode = true;
        float r2 = this.scrollToBeConsumed + r9;
        this.scrollToBeConsumed = r2;
        if (Math.abs(r2) <= 0.5f) goto L37;
        float r3 = this.scrollToBeConsumed;
        int r4 = Math.round(r3);
        LazyListMeasureResult r5 = ((LazyListMeasureResult) this.layoutInfoState.getValue()).copyWithScrollDeltaWithoutRemeasure(r4, !this.hasLookaheadOccurred);
        if (r5 == null) goto L30;
        LazyListMeasureResult r6 = this.approachLayoutInfo;
        if (r6 == null) goto L30;
        if (r6 == null) goto L26;
        LazyListMeasureResult r7 = r6.copyWithScrollDeltaWithoutRemeasure(r4, true);
    L27:
        if (r7 == null) goto L29;
        this.approachLayoutInfo = r7;
        goto L30
    L29:
        r5 = null;
        goto L30
    L26:
        r7 = null;
    L30:
        if (r5 == null) goto L32;
        applyMeasureResult$foundation_release(r5, this.hasLookaheadOccurred, true);
        ObservableScopeInvalidator.m1191invalidateScopeimpl(this.placementScopeInvalidator);
        notifyPrefetchOnScroll(r3 - this.scrollToBeConsumed, r5);
        goto L37
    L32:
        Remeasurement r8 = this.remeasurement;
        if (r8 == null) goto L35;
        r8.forceRemeasure();
    L35:
        notifyPrefetchOnScroll(r3 - this.scrollToBeConsumed, getLayoutInfo());
    L37:
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) goto L39;
        return r9;
    L39:
        float r10 = r9 - this.scrollToBeConsumed;
        this.scrollToBeConsumed = MenuKt.ClosedAlphaTarget;
        return r10;
    L14:
        r1 = false;
        goto L15
    }

    public final void setPrefetchingEnabled$foundation_release(boolean r1) {
        this.prefetchingEnabled = r1;
    }

    public LazyListState(int r4, int r5) {
        this(r4, r5, LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null));
    }

    private static final List Saver$lambda$8(SaverScope r2, LazyListState r3) {
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(r3.getFirstVisibleItemIndex()), Integer.valueOf(r3.getFirstVisibleItemScrollOffset())});
    }

    public static final /* synthetic */ void access$setRemeasurement$p(LazyListState r0, Remeasurement r1) {
        r0.remeasurement = r1;
    }

    private final void notifyPrefetchOnScroll(float r3, LazyListLayoutInfo r4) {
        if (this.prefetchingEnabled == false) goto L6;
        this.prefetchStrategy.onScroll(this.prefetchScope, r3, r4);
        return;
    }

    private static final float scrollableState$lambda$0(LazyListState r0, float r1) {
        return -r0.onScroll$foundation_release(-r1);
    }

    public final void requestScrollToItem(int r8, int r9) {
        if (isScrollInProgress() == false) goto L5;
        BuildersKt.launch$default(((LazyListMeasureResult) this.layoutInfoState.getValue()).getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
    L5:
        snapToItemIndexInternal$foundation_release(r8, r9, false);
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyListItemProvider r2, int r3) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(r2, r3);
    }

    public LazyListState(final int r4, int r5, LazyListPrefetchStrategy r6) {
        this.prefetchStrategy = r6;
        LazyListScrollPosition r0 = new LazyListScrollPosition(r4, r5);
        this.scrollPosition = r0;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyListStateKt.access$getEmptyLazyListMeasureResult$p(), SnapshotStateKt.neverEqualPolicy());
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.scrollableState = ScrollableStateKt.ScrollableState(new t(this));
        this.prefetchingEnabled = true;
        this.remeasurementModifier = new LazyListState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.itemAnimator = new LazyLayoutItemAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchState = new LazyLayoutPrefetchState(r6.getPrefetchScheduler(), new u(this, r4));
        this.prefetchScope = new LazyListState$prefetchScope$1(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        r0.getNearestRangeState();
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m1187constructorimpl$default(null, 1, null);
        Boolean r7 = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1187constructorimpl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    private static final Unit prefetchState$lambda$3(LazyListState r4, int r5, NestedPrefetchScope r6) {
        LazyListPrefetchStrategy r7 = r4.prefetchStrategy;
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        r0.restoreNonObservable(r1, r0.makeCurrentNonObservable(r1), r2);
        r7.onNestedPrefetch(r6, r5);
        return Unit.INSTANCE;
    L5:
        r2 = null;
        goto L6
    }

    public final Object animateScrollToItem(int r7, int r8, Continuation<? super Unit> r9) {
        Object r10 = ScrollableState.CC.scroll$default(this, null, new AnonymousClass2(this, r7, r8, null), r9, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(LazyListMeasureResult r7, boolean r8, boolean r9) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation_release(r7.getVisibleItemsInfo().size());
        boolean r0 = true;
        if (r8 == false) goto L5;
    L28:
        if (r8 == false) goto L30;
        this.hasLookaheadOccurred = true;
    L30:
        setCanScrollBackward(r7.getCanScrollBackward());
        setCanScrollForward(r7.getCanScrollForward());
        this.scrollToBeConsumed -= r7.getConsumedScroll();
        this.layoutInfoState.setValue(r7);
        if (r9 == false) goto L33;
        this.scrollPosition.updateScrollOffset(r7.getFirstVisibleItemScrollOffset());
    L36:
        if (r8 == false) goto L38;
        this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation_release(r7.getScrollBackAmount(), r7.getDensity(), r7.getCoroutineScope());
    L38:
        this.numMeasurePasses++;
        return;
    L33:
        traceVisibleItems(r7);
        this.scrollPosition.updateFromMeasureResult(r7);
        if (this.prefetchingEnabled == false) goto L36;
        this.prefetchStrategy.onVisibleItemsUpdated(this.prefetchScope, r7);
        goto L36
    L5:
        if (this.hasLookaheadOccurred == false) goto L28;
        this.approachLayoutInfo = r7;
        Snapshot.Companion r10 = Snapshot.Companion;
        Snapshot r11 = r10.getCurrentThreadSnapshot();
        if (r11 == null) goto L9;
        Function1 r1 = r11.getReadObserver();
    L10:
        Snapshot r2 = r10.makeCurrentNonObservable(r11);
    L25:
        th = move-exception;
        r10.restoreNonObservable(r11, r2, r1);
        throw th;
    L12:
        if (this._lazyLayoutScrollDeltaBetweenPasses.isActive$foundation_release() == false) goto L23;
        LazyListMeasuredItem r3 = r7.getFirstVisibleItem();     // Catch: Throwable -> L25
        if (r3 != null) goto L16;
    L18:
        r0 = false;
    L19:
        if (r0 == false) goto L23;
        if (r7.getFirstVisibleItemScrollOffset() != this.scrollPosition.getScrollOffset()) goto L23;
        this._lazyLayoutScrollDeltaBetweenPasses.stop$foundation_release();     // Catch: Throwable -> L25
        goto L23
    L16:
        if (r3.getIndex() != this.scrollPosition.getIndex()) goto L18;
    L23:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r10.restoreNonObservable(r11, r2, r1);
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority r6, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C01811) == false) goto L7;
        C01811 r0 = (C01811) r8;
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
        r0 = new C01811(this, r8);
        goto L8
    }

    public final Object scrollToItem(int r7, int r8, Continuation<? super Unit> r9) {
        Object r10 = ScrollableState.CC.scroll$default(this, null, new C01822(this, r7, r8, null), r9, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int r3, int r4, boolean r5) {
        if (this.scrollPosition.getIndex() == r3) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        this.itemAnimator.reset();
        Object r1 = this.prefetchStrategy;
        if ((r1 instanceof CacheWindowLogic) == false) goto L13;
        CacheWindowLogic r2 = (CacheWindowLogic) r1;
    L14:
        if (r2 == null) goto L16;
        r2.resetStrategy();
        goto L16
    L13:
        r2 = null;
    L16:
        this.scrollPosition.requestPositionAndForgetLastKnownKey(r3, r4);
        if (r5 == false) goto L21;
        Remeasurement r6 = this.remeasurement;
        if (r6 == null) goto L23;
        r6.forceRemeasure();
        return;
    L23:
        return;
    L21:
        ObservableScopeInvalidator.m1191invalidateScopeimpl(this.measurementScopeInvalidator);
        return;
    L5:
        if (this.scrollPosition.getScrollOffset() != r4) goto L8;
        r0 = false;
        goto L9
    }

    public LazyListState(LazyLayoutCacheWindow r2, int r3, int r4) {
        this(r3, r4, new LazyListCacheWindowStrategy(r2));
    }

    public /* synthetic */ LazyListState(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }

    public /* synthetic */ LazyListState(int r2, int r3, LazyListPrefetchStrategy r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = LazyListPrefetchStrategyKt.LazyListPrefetchStrategy$default(0, 1, null);
    L11:
        this(r2, r3, r4);
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyListState r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.requestScrollToItem(r1, r2);
    }

    public /* synthetic */ LazyListState(LazyLayoutCacheWindow r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r2, r3, r4);
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyListState r0, int r1, int r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.animateScrollToItem(r1, r2, r3);
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyListState r0, LazyListMeasureResult r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.applyMeasureResult$foundation_release(r1, r2, r3);
    }

    public static /* synthetic */ Object scrollToItem$default(LazyListState r0, int r1, int r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.scrollToItem(r1, r2, r3);
    }
}
