package androidx.compose.foundation.pager;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
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
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
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
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B)\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002J%\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u0005H\u0086@¢\u0006\u0003\u0010\u009d\u0001J!\u0010\u009e\u0001\u001a\u00030\u009a\u0001*\u00030\u009f\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u0005J\u0015\u0010 \u0001\u001a\u00030\u009a\u0001*\u00030\u009f\u00012\u0006\u0010k\u001a\u00020\u0003J+\u0010¡\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\u0007\u0010¢\u0001\u001a\u00020\u00052\u0007\u0010£\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b¤\u0001J\u001e\u0010§\u0001\u001a\u00030\u009a\u00012\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u0005J7\u0010¨\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u00052\u0010\b\u0002\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050ª\u0001H\u0086@¢\u0006\u0003\u0010«\u0001J\u0011\u0010¬\u0001\u001a\u00030\u009a\u0001H\u0082@¢\u0006\u0003\u0010\u00ad\u0001JK\u0010®\u0001\u001a\u00030\u009a\u00012\b\u0010¯\u0001\u001a\u00030°\u00012.\u0010±\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030\u009f\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009a\u00010³\u0001\u0012\u0007\u0012\u0005\u0018\u00010´\u00010²\u0001¢\u0006\u0003\bµ\u0001H\u0096@¢\u0006\u0003\u0010¶\u0001J\u0011\u0010·\u0001\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0016J-\u0010Ç\u0001\u001a\u00030\u009a\u00012\u0007\u0010È\u0001\u001a\u00020\u00102\u0007\u0010É\u0001\u001a\u00020\f2\t\b\u0002\u0010Ê\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bË\u0001J\u0013\u0010Ì\u0001\u001a\u00030\u009a\u00012\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J\r\u0010Í\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002J\u0012\u0010Î\u0001\u001a\u00020\f2\u0007\u0010Ï\u0001\u001a\u00020\u0005H\u0002J\u000f\u0010Ð\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bÑ\u0001J\u001b\u0010Ò\u0001\u001a\u00030\u009a\u00012\u0006\u00101\u001a\u00020\u00052\u0007\u0010Ó\u0001\u001a\u00020BH\u0002J\u0013\u0010Ô\u0001\u001a\u00030\u009a\u00012\u0007\u0010Ó\u0001\u001a\u00020BH\u0002J\u001b\u0010Õ\u0001\u001a\u00020\u00032\u0007\u0010Ö\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020BH\u0002J\u0010\u0010×\u0001\u001a\u00020\u00052\u0007\u0010\u009b\u0001\u001a\u00020\u0003J#\u0010Ø\u0001\u001a\u00020\u00032\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0003\bÛ\u0001R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u001e\u0010$\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001a\u0010*\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u000e\u0010-\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0016R\u001e\u00104\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0016R\u000e\u00106\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010A\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0016R\u0014\u0010G\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0016R\u001a\u0010I\u001a\u00020JX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0016R\u0014\u0010Q\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0016R+\u0010]\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\b^\u0010\u0016\"\u0004\b_\u0010`R+\u0010c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010b\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010`R\u001b\u0010g\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bh\u0010\u0016R\u001b\u0010k\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010j\u001a\u0004\bl\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bn\u0010SR\u0014\u0010o\u001a\u00020pX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020xX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR1\u0010|\u001a\u0004\u0018\u00010{2\b\u0010\u0017\u001a\u0004\u0018\u00010{8@@BX\u0080\u008e\u0002¢\u0006\u0014\n\u0005\b\u0081\u0001\u0010\u001f\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R!\u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0080\u000e¢\u0006\u0013\n\u0003\u0010\u008a\u0001\u001a\u0005\b\u0088\u0001\u0010\u001b\"\u0005\b\u0089\u0001\u0010\u001dR\u0018\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R!\u0010\u008f\u0001\u001a\u00030\u0090\u00018@X\u0080\u0084\u0002¢\u0006\u0010\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001*\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0080\u0004¢\u0006\f\n\u0002\u0010\u001f\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010¥\u0001\u001a\u00030\u0096\u0001X\u0080\u0004¢\u0006\f\n\u0002\u0010\u001f\u001a\u0006\b¦\u0001\u0010\u0098\u0001R\u0016\u0010¸\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010\u000fR/\u0010¹\u0001\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¼\u0001\u0010\u001f\u001a\u0005\bº\u0001\u0010\u000f\"\u0005\b»\u0001\u0010:R/\u0010½\u0001\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bÀ\u0001\u0010\u001f\u001a\u0005\b¾\u0001\u0010\u000f\"\u0005\b¿\u0001\u0010:R\u0015\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\f0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\f0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ã\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010\u000fR\u0016\u0010Å\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0001\u0010\u000f¨\u0006Ü\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "currentPageOffsetFraction", "", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "(IF)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "()Z", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "getPageCount", "()I", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation_release", "()J", "setUpDownDifference-k-4lQ0M$foundation_release", "(J)V", "upDownDifference$delegate", "Landroidx/compose/runtime/MutableState;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "maxScrollOffset", "", "getMaxScrollOffset$foundation_release", "setMaxScrollOffset$foundation_release", "minScrollOffset", "getMinScrollOffset$foundation_release", "setMinScrollOffset$foundation_release", "accumulator", "previousPassDelta", "scrollableState", "performScroll", "delta", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation_release", "layoutWithoutMeasurement", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "indexToPrefetch", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasPrefetchingForward", "pagerLayoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "pageSpacing", "getPageSpacing$foundation_release", "pageSize", "getPageSize$foundation_release", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "pageSizeWithSpacing", "getPageSizeWithSpacing$foundation_release", "positionThresholdFraction", "getPositionThresholdFraction$foundation_release", "()F", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getCurrentPage", "programmaticScrollTargetPage", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "settledPage", "getSettledPage", "settledPage$delegate", "Landroidx/compose/runtime/State;", "targetPage", "getTargetPage", "targetPage$delegate", "getCurrentPageOffsetFraction", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "setPremeasureConstraints-BRTryo0$foundation_release", "J", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollToPage", "", "page", "pageOffsetFraction", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCurrentPage", "Landroidx/compose/foundation/gestures/ScrollScope;", "updateTargetPage", "snapToItem", "offsetFraction", "forceRemeasure", "snapToItem$foundation_release", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "requestScrollToPage", "animateScrollToPage", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "isScrollInProgress", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "isLastScrollForwardState", "isLastScrollBackwardState", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "tryRunPrefetch", "coerceInPageRange", "isGestureActionMatchesScroll", "scrollDelta", "isNotGestureAction", "isNotGestureAction$foundation_release", "notifyPrefetch", "info", "cancelPrefetchIfVisibleItemsChanged", "calculatePrefetchIndex", "forward", "getOffsetDistanceInPages", "matchScrollPositionWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "matchScrollPositionWithKey$foundation_release", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private float accumulator;
    private PagerMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private boolean hasLookaheadOccurred;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState<Unit> measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState<PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;
    private final MutableIntState programmaticScrollTargetPage$delegate;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasPrefetchingForward;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0}, l = {612, 619}, m = "animateScrollToPage", n = {"animationSpec", "page", "pageOffsetFraction"}, s = {"L$0", "I$0", "F$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagerState this$0;

        public AnonymousClass1(PagerState r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.animateScrollToPage(0, MenuKt.ClosedAlphaTarget, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$animateScrollToPage$3", f = "PagerState.kt", i = {}, l = {621}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ int $targetPage;
        final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PagerState this$0;

        public AnonymousClass3(PagerState r1, int r2, float r3, AnimationSpec<Float> r4, Continuation<? super AnonymousClass3> r5) {
            this.this$0 = r1;
            this.$targetPage = r2;
            this.$targetPageOffsetToSnappedPosition = r3;
            this.$animationSpec = r4;
            super(2, r5);
        }

        public static /* synthetic */ Unit a(PagerState r0, ScrollScope r1, int r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass3 r6 = new AnonymousClass3(this.this$0, this.$targetPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, r9);
            r6.L$0 = r8;
            return r6;
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
            LazyLayoutScrollScope r3 = PagerScrollScopeKt.LazyLayoutScrollScope(this.this$0, r11);
            int r4 = this.$targetPage;
            float r5 = this.$targetPageOffsetToSnappedPosition;
            AnimationSpec<Float> r6 = this.$animationSpec;
            final PagerState r12 = this.this$0;
            Function2 r7 = new e0(r12);
            this.label = 1;
            if (PagerStateKt.access$animateScrollToPage(r3, r4, r5, r6, r7, this) != r0) goto L12;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(PagerState r0, ScrollScope r1, int r2) {
            r0.updateTargetPage(r1, r2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$requestScrollToPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$requestScrollToPage$1", f = "PagerState.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PagerState this$0;

        public C02071(PagerState r1, Continuation<? super C02071> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02071(this.this$0, r3);
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
            PagerState r5 = this.this$0;
            this.label = 1;
            if (ScrollExtensionsKt.stopScroll$default(r5, null, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0, 1}, l = {638, 643}, m = "scroll$suspendImpl", n = {"$this", "scrollPriority", "block", "$this"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class C02081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagerState this$0;

        public C02081(PagerState r1, Continuation<? super C02081> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return PagerState.scroll$suspendImpl(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scrollToPage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $page;
        final /* synthetic */ float $pageOffsetFraction;
        int label;
        final /* synthetic */ PagerState this$0;

        public AnonymousClass2(PagerState r1, float r2, int r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$pageOffsetFraction = r2;
            this.$page = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$pageOffsetFraction, this.$page, r5);
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            float r9 = this.$pageOffsetFraction;
            double r2 = r9;
            boolean r5 = false;
            if ((-0.5d) <= r2) goto L14;
        L16:
            if (r5 == true) goto L18;
            InlineClassHelperKt.throwIllegalArgumentException("pageOffsetFraction " + r9 + " is not within the range -0.5 to 0.5");
        L18:
            this.this$0.snapToItem$foundation_release(PagerState.access$coerceInPageRange(this.this$0, this.$page), this.$pageOffsetFraction, true);
            return Unit.INSTANCE;
        L14:
            if (r2 > 0.5d) goto L16;
            r5 = true;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            PagerState r10 = this.this$0;
            this.label = 1;
            if (PagerState.access$awaitScrollDependencies(r10, this) != r0) goto L11;
            return r0;
        }
    }

    public PagerState() {
        this(0, MenuKt.ClosedAlphaTarget, null, 7, null);
    }

    public static /* synthetic */ int a(PagerState r0) {
        return settledPage_delegate$lambda$6(r0);
    }

    public static /* synthetic */ Unit b(PagerState r0, NestedPrefetchScope r1) {
        return prefetchState$lambda$9(r0, r1);
    }

    public static /* synthetic */ int c(PagerState r0) {
        return targetPage_delegate$lambda$7(r0);
    }

    public static /* synthetic */ float d(PagerState r0, float r1) {
        return scrollableState$lambda$1(r0, r1);
    }

    public abstract int getPageCount();

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority r1, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super Unit> r3) {
        return scroll$suspendImpl(this, r1, r2, r3);
    }

    private final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage$delegate.getIntValue();
    }

    private final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return ((Boolean) this.isLastScrollBackwardState.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return ((Boolean) this.isLastScrollForwardState.getValue()).booleanValue();
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return (PagerLayoutInfo) this.pagerLayoutInfoState.getValue();
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.layoutWithMeasurement + this.layoutWithoutMeasurement;
    }

    public final int getPageSize$foundation_release() {
        return ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).getPageSize();
    }

    public final int getPageSpacing$foundation_release() {
        return ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).getPageSpacing();
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.toPx-0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    /* JADX INFO: renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1268getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference$delegate.getValue()).unbox-impl();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    public final boolean isNotGestureAction$foundation_release() {
        if (((int) Float.intBitsToFloat((int) (m1268getUpDownDifferenceF1C5BW0$foundation_release() >> 32))) == 0) goto L5;
    L7:
        return false;
    L5:
        if (((int) Float.intBitsToFloat((int) (m1268getUpDownDifferenceF1C5BW0$foundation_release() & 4294967295L))) != 0) goto L7;
        return true;
    }

    public final PagerMeasureResult getApproachLayoutInfo$foundation_release() {
        return this.approachLayoutInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.firstVisiblePageOffset;
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

    public final int getLayoutWithMeasurement$foundation_release() {
        return this.layoutWithMeasurement;
    }

    public final long getMaxScrollOffset$foundation_release() {
        return this.maxScrollOffset;
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1265getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final long getMinScrollOffset$foundation_release() {
        return this.minScrollOffset;
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m1266getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    /* JADX INFO: renamed from: getPremeasureConstraints-msEJaDk$foundation_release, reason: not valid java name */
    public final long m1267getPremeasureConstraintsmsEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    private final Object awaitScrollDependencies(Continuation<? super Unit> r2) {
        Object r3 = this.awaitLayoutModifier.waitForFirstLayout(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo r3) {
        if (this.indexToPrefetch != (-1)) goto L5;
        return;
    L5:
        if ((!r3.getVisiblePagesInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (this.indexToPrefetch == calculatePrefetchIndex(this.wasPrefetchingForward, r3)) goto L15;
        this.indexToPrefetch = -1;
        LazyLayoutPrefetchState.PrefetchHandle r4 = this.currentPrefetchHandle;
        if (r4 == null) goto L11;
        r4.cancel();
    L11:
        this.currentPrefetchHandle = null;
        return;
    }

    private final int coerceInPageRange(int r3) {
        if (getPageCount() > 0) goto L5;
        return 0;
    L5:
        return RangesKt.coerceIn(r3, 0, getPageCount() - 1);
    }

    private static Object getNearestRange$foundation_release$delegate(PagerState r0) {
        return r0.scrollPosition.getNearestRangeState();
    }

    private final boolean isGestureActionMatchesScroll(float r7) {
        if (getLayoutInfo().getOrientation() != Orientation.Vertical) goto L8;
        if (Math.signum(r7) == Math.signum(-Float.intBitsToFloat((int) (m1268getUpDownDifferenceF1C5BW0$foundation_release() & 4294967295L)))) goto L9;
    L10:
        boolean r8 = false;
    L11:
        if (r8 == false) goto L13;
        return true;
    L13:
        if (isNotGestureAction$foundation_release() == true) goto L18;
        return false;
    L18:
        return true;
    L9:
        r8 = true;
        goto L11
    L8:
        if (Math.signum(r7) != Math.signum(-Float.intBitsToFloat((int) (m1268getUpDownDifferenceF1C5BW0$foundation_release() >> 32)))) goto L10;
        goto L9
    }

    private final float performScroll(float r13) {
        long r0 = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float r2 = this.accumulator + r13;
        long r3 = MathKt.roundToLong(r2);
        this.accumulator = r2 - r3;
        if (Math.abs(r13) >= 1.0E-4f) goto L5;
        return r13;
    L5:
        long r4 = r3 + r0;
        long r5 = RangesKt.coerceIn(r4, this.minScrollOffset, this.maxScrollOffset);
        boolean r6 = false;
        if (r4 == r5) goto L8;
        boolean r7 = true;
    L9:
        long r8 = r5 - r0;
        float r1 = r8;
        this.previousPassDelta = r1;
        if (Math.abs(r8) == 0) goto L19;
        MutableState<Boolean> r9 = this.isLastScrollForwardState;
        if (r1 <= MenuKt.ClosedAlphaTarget) goto L14;
        boolean r10 = true;
    L15:
        r9.setValue(Boolean.valueOf(r10));
        MutableState<Boolean> r11 = this.isLastScrollBackwardState;
        if (r1 >= MenuKt.ClosedAlphaTarget) goto L18;
        r6 = true;
    L18:
        r11.setValue(Boolean.valueOf(r6));
        goto L19
    L14:
        r10 = false;
    L19:
        int r12 = (int) r8;
        int r14 = -r12;
        PagerMeasureResult r15 = ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).copyWithScrollDeltaWithoutRemeasure(r14);
        if (r15 == null) goto L30;
        PagerMeasureResult r16 = this.approachLayoutInfo;
        if (r16 == null) goto L30;
        if (r16 == null) goto L26;
        PagerMeasureResult r17 = r16.copyWithScrollDeltaWithoutRemeasure(r14);
    L27:
        if (r17 == null) goto L29;
        this.approachLayoutInfo = r17;
        goto L30
    L29:
        r15 = null;
        goto L30
    L26:
        r17 = null;
    L30:
        if (r15 == null) goto L32;
        applyMeasureResult$foundation_release(r15, this.hasLookaheadOccurred, true);
        ObservableScopeInvalidator.m1191invalidateScopeimpl(this.placementScopeInvalidator);
        this.layoutWithoutMeasurement++;
    L36:
        if (r7 == false) goto L38;
        Number r18 = Long.valueOf(r8);
    L40:
        return r18.floatValue();
    L38:
        r18 = Float.valueOf(r13);
        goto L40
    L32:
        this.scrollPosition.applyScrollDelta(r12);
        Remeasurement r19 = getRemeasurement$foundation_release();
        if (r19 == null) goto L35;
        r19.forceRemeasure();
    L35:
        this.layoutWithMeasurement++;
        goto L36
    L8:
        r7 = false;
        goto L9
    }

    private final void setCanScrollBackward(boolean r2) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setCanScrollForward(boolean r2) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setProgrammaticScrollTargetPage(int r2) {
        this.programmaticScrollTargetPage$delegate.setIntValue(r2);
    }

    private final void setRemeasurement(Remeasurement r2) {
        this.remeasurement$delegate.setValue(r2);
    }

    private final void setSettledPageState(int r2) {
        this.settledPageState$delegate.setIntValue(r2);
    }

    private static final int settledPage_delegate$lambda$6(PagerState r1) {
        if (r1.isScrollInProgress() == false) goto L6;
        return r1.getSettledPageState();
    L6:
        return r1.getCurrentPage();
    }

    private static final int targetPage_delegate$lambda$7(PagerState r2) {
        if (r2.isScrollInProgress() == true) goto L6;
        int r0 = r2.getCurrentPage();
    L16:
        return r2.coerceInPageRange(r0);
    L6:
        if (r2.getProgrammaticScrollTargetPage() == (-1)) goto L9;
        r0 = r2.getProgrammaticScrollTargetPage();
        goto L16
    L9:
        if (Math.abs(r2.getCurrentPageOffsetFraction()) >= Math.abs(r2.getPositionThresholdFraction$foundation_release())) goto L11;
        r0 = r2.getCurrentPage();
        goto L16
    L11:
        if (r2.getLastScrolledForward() == false) goto L13;
        r0 = r2.firstVisiblePage + 1;
        goto L16
    L13:
        r0 = r2.firstVisiblePage;
        goto L16
    }

    private final void tryRunPrefetch(PagerMeasureResult r7) {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
    L27:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L8:
        if (this.prefetchingEnabled == true) goto L12;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L12:
        if (r7.getBeyondViewportPageCount() < getPageCount()) goto L17;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L17:
        if (Math.abs(this.previousPassDelta) > 0.5f) goto L21;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L21:
        if (isGestureActionMatchesScroll(this.previousPassDelta) == true) goto L24;
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L24:
        notifyPrefetch(this.previousPassDelta, r7);     // Catch: Throwable -> L27
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float r2) {
        return this.scrollableState.dispatchRawDelta(r2);
    }

    public final float getOffsetDistanceInPages(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("page " + r3 + " is not within the range 0 to " + getPageCount());
    L10:
        return (r3 - getCurrentPage()) - getCurrentPageOffsetFraction();
    L5:
        if (r3 > getPageCount()) goto L7;
        r0 = true;
        goto L7
    }

    public final void setDensity$foundation_release(Density r1) {
        this.density = r1;
    }

    public final void setMaxScrollOffset$foundation_release(long r1) {
        this.maxScrollOffset = r1;
    }

    public final void setMinScrollOffset$foundation_release(long r1) {
        this.minScrollOffset = r1;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean r1) {
        this.prefetchingEnabled = r1;
    }

    /* JADX INFO: renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m1269setPremeasureConstraintsBRTryo0$foundation_release(long r1) {
        this.premeasureConstraints = r1;
    }

    /* JADX INFO: renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m1270setUpDownDifferencek4lQ0M$foundation_release(long r2) {
        this.upDownDifference$delegate.setValue(Offset.box-impl(r2));
    }

    public PagerState(int r2, float r3) {
        this(r2, r3, null);
    }

    public static final /* synthetic */ Object access$awaitScrollDependencies(PagerState r0, Continuation r1) {
        return r0.awaitScrollDependencies(r1);
    }

    public static final /* synthetic */ int access$coerceInPageRange(PagerState r0, int r1) {
        return r0.coerceInPageRange(r1);
    }

    public static final /* synthetic */ void access$setRemeasurement(PagerState r0, Remeasurement r1) {
        r0.setRemeasurement(r1);
    }

    private final int calculatePrefetchIndex(boolean r1, PagerLayoutInfo r2) {
        if (r1 == false) goto L8;
        int r3 = r2.getBeyondViewportPageCount() + 1;
        if (r3 >= 0) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return r3 + ((PageInfo) CollectionsKt.last(r2.getVisiblePagesInfo())).getIndex();
    L8:
        return (((PageInfo) CollectionsKt.first(r2.getVisiblePagesInfo())).getIndex() - r2.getBeyondViewportPageCount()) - 1;
    }

    private final void notifyPrefetch(float r11, PagerLayoutInfo r12) {
        if (this.prefetchingEnabled == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        if ((!r12.getVisiblePagesInfo().isEmpty()) == true) goto L8;
        return;
    L8:
        if (r11 <= MenuKt.ClosedAlphaTarget) goto L10;
        boolean r0 = true;
    L11:
        int r4 = calculatePrefetchIndex(r0, r12);
        if (r4 >= 0) goto L14;
    L16:
        r1 = false;
    L17:
        if (r1 == true) goto L19;
        return;
    L19:
        if (r4 != this.indexToPrefetch) goto L21;
    L26:
        if (r0 == false) goto L33;
        PageInfo r2 = (PageInfo) CollectionsKt.last(r12.getVisiblePagesInfo());
        if (((r2.getOffset() + (r12.getPageSize() + r12.getPageSpacing())) - r12.getViewportEndOffset()) >= r11) goto L40;
        LazyLayoutPrefetchState.PrefetchHandle r13 = this.currentPrefetchHandle;
        if (r13 == null) goto L41;
        r13.markAsUrgent();
        return;
    L41:
        return;
    L40:
        return;
    L33:
        if ((r12.getViewportStartOffset() - ((PageInfo) CollectionsKt.first(r12.getVisiblePagesInfo())).getOffset()) >= (-r11)) goto L43;
        LazyLayoutPrefetchState.PrefetchHandle r14 = this.currentPrefetchHandle;
        if (r14 == null) goto L44;
        r14.markAsUrgent();
        return;
    L44:
        return;
    L43:
        return;
    L21:
        if (this.wasPrefetchingForward == r0) goto L25;
        LazyLayoutPrefetchState.PrefetchHandle r3 = this.currentPrefetchHandle;
        if (r3 == null) goto L25;
        r3.cancel();
    L25:
        this.wasPrefetchingForward = r0;
        this.indexToPrefetch = r4;
        this.currentPrefetchHandle = LazyLayoutPrefetchState.m1175schedulePrecompositionAndPremeasureVKLhPVY$default(this.prefetchState, r4, this.premeasureConstraints, null, 4, null);
        goto L26
    L14:
        if (r4 >= getPageCount()) goto L16;
    L10:
        r0 = false;
        goto L11
    }

    private static final Unit prefetchState$lambda$9(PagerState r4, NestedPrefetchScope r5) {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
        r5.schedulePrecomposition(r4.firstVisiblePage);     // Catch: Throwable -> L10
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.restoreNonObservable(r1, r3, r2);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    private static final float scrollableState$lambda$1(PagerState r0, float r1) {
        return r0.performScroll(r1);
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider r2, int r3) {
        return this.scrollPosition.matchPageWithKey(r2, r3);
    }

    public final void requestScrollToPage(int r8, float r9) {
        if (isScrollInProgress() == false) goto L5;
        BuildersKt.launch$default(((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).getCoroutineScope(), null, null, new C02071(this, null), 3, null);
    L5:
        snapToItem$foundation_release(r8, r9, false);
    }

    public final void updateTargetPage(ScrollScope r1, int r2) {
        setProgrammaticScrollTargetPage(coerceInPageRange(r2));
    }

    public PagerState(int r13, float r14, PrefetchScheduler r15) {
        double r0 = r14;
        boolean r4 = false;
        if ((-0.5d) <= r0) goto L5;
    L7:
        if (r4 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("currentPageOffsetFraction " + r14 + " is not within the range -0.5 to 0.5");
    L9:
        this.upDownDifference$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), null, 2, null);
        PagerScrollPosition r1 = new PagerScrollPosition(r13, r14, this);
        this.scrollPosition = r1;
        this.firstVisiblePage = r13;
        this.maxScrollOffset = Long.MAX_VALUE;
        this.scrollableState = ScrollableStateKt.ScrollableState(new a0(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.density = PagerStateKt.access$getUnitDensity$p();
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.programmaticScrollTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(r13);
        this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new b0(this));
        this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new c0(this));
        this.prefetchState = new LazyLayoutPrefetchState(r15, new d0(this));
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this);
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        r1.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m1187constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m1187constructorimpl$default(null, 1, null);
        Boolean r16 = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(r16, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(r16, null, 2, null);
        this.isLastScrollForwardState = SnapshotStateKt.mutableStateOf$default(r16, null, 2, null);
        this.isLastScrollBackwardState = SnapshotStateKt.mutableStateOf$default(r16, null, 2, null);
        return;
    L5:
        if (r0 > 0.5d) goto L7;
        r4 = true;
        goto L7
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult r3, boolean r4, boolean r5) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation_release(r3.getVisiblePagesInfo().size());
        if (r4 == false) goto L5;
    L7:
        if (r4 == false) goto L9;
        this.hasLookaheadOccurred = true;
    L9:
        if (r5 == false) goto L11;
        this.scrollPosition.updateCurrentPageOffsetFraction(r3.getCurrentPageOffsetFraction());
    L12:
        this.pagerLayoutInfoState.setValue(r3);
        setCanScrollForward(r3.getCanScrollForward());
        setCanScrollBackward(r3.getCanScrollBackward());
        MeasuredPage r6 = r3.getFirstVisiblePage();
        if (r6 == null) goto L15;
        this.firstVisiblePage = r6.getIndex();
    L15:
        this.firstVisiblePageOffset = r3.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(r3);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(r3, getPageCount());
        this.minScrollOffset = PagerStateKt.access$calculateNewMinScrollOffset(r3, getPageCount());
        return;
    L11:
        this.scrollPosition.updateFromMeasureResult(r3);
        cancelPrefetchIfVisibleItemsChanged(r3);
        goto L12
    L5:
        if (this.hasLookaheadOccurred == false) goto L7;
        this.approachLayoutInfo = r3;
    }

    public final Object scrollToPage(int r7, float r8, Continuation<? super Unit> r9) {
        Object r10 = ScrollableState.CC.scroll$default(this, null, new AnonymousClass2(this, r8, r7, null), r9, 1, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void snapToItem$foundation_release(int r2, float r3, boolean r4) {
        this.scrollPosition.requestPositionAndForgetLastKnownKey(r2, r3);
        if (r4 == false) goto L7;
        Remeasurement r5 = getRemeasurement$foundation_release();
        if (r5 == null) goto L9;
        r5.forceRemeasure();
        return;
    L9:
        return;
    L7:
        ObservableScopeInvalidator.m1191invalidateScopeimpl(this.measurementScopeInvalidator);
    }

    public final void updateCurrentPage(ScrollScope r1, int r2, float r3) {
        snapToItem$foundation_release(r2, r3, true);
    }

    public /* synthetic */ PagerState(int r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = MenuKt.ClosedAlphaTarget;
    L8:
        this(r1, r2);
    }

    public static /* synthetic */ Object scroll$suspendImpl(PagerState r5, MutatePriority r6, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C02081) == false) goto L7;
        C02081 r0 = (C02081) r8;
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
        r5 = (PagerState) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L25:
        r5.setProgrammaticScrollTargetPage(-1);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (Function2) r0.L$2;
        r6 = (MutatePriority) r0.L$1;
        r5 = (PagerState) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L20:
        if (r5.isScrollInProgress() == true) goto L22;
        r5.setSettledPageState(r5.getCurrentPage());
    L22:
        ScrollableState r10 = r5.scrollableState;
        r0.L$0 = r5;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (r10.scroll(r6, r7, r0) != r2) goto L25;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.L$2 = r7;
        r0.label = 1;
        if (r5.awaitScrollDependencies(r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new C02081(r5, r8);
        goto L8
    }

    public final Object animateScrollToPage(int r16, float r17, AnimationSpec<Float> r18, Continuation<? super Unit> r19) {
        int r0 = r16;
        float r1 = r17;
        if ((r19 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r19;
        int r4 = r3.label;
        if ((r4 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r3.label = r4 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass1 r7 = r3;
        Object r2 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        boolean r6 = false;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L42:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r9 = r7.F$0;
        int r10 = r7.I$0;
        AnimationSpec<Float> r11 = (AnimationSpec) r7.L$0;
        ResultKt.throwOnFailure(r2);
        AnimationSpec<Float> r12 = r11;
        r1 = r9;
        r0 = r10;
    L31:
        double r13 = r1;
        if ((-0.5d) <= r13) goto L34;
    L36:
        if (r6 == true) goto L38;
        InlineClassHelperKt.throwIllegalArgumentException("pageOffsetFraction " + r1 + " is not within the range -0.5 to 0.5");
    L38:
        AnonymousClass3 r14 = new AnonymousClass3(this, coerceInPageRange(r0), r1 * getPageSizeWithSpacing$foundation_release(), r12, null);
        r7.L$0 = null;
        r7.label = 2;
        if (ScrollableState.CC.scroll$default(this, null, r14, r7, 1, null) != r8) goto L42;
        return r8;
    L34:
        if (r13 > 0.5d) goto L36;
        r6 = true;
        goto L36
    L16:
        ResultKt.throwOnFailure(r2);
        if (r0 != getCurrentPage()) goto L24;
        if (getCurrentPageOffsetFraction() != r1) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L24;
    L26:
        return Unit.INSTANCE;
    L21:
        r15 = false;
    L24:
        if (getPageCount() == 0) goto L26;
        r7.L$0 = r18;
        r7.I$0 = r0;
        r7.F$0 = r1;
        r7.label = 1;
        if (awaitScrollDependencies(r7) != r8) goto L30;
        return r8;
    L30:
        r12 = r18;
    L7:
        r3 = new AnonymousClass1(this, r19);
        goto L8
    }

    public /* synthetic */ PagerState(int r1, float r2, PrefetchScheduler r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = MenuKt.ClosedAlphaTarget;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }

    public static /* synthetic */ int matchScrollPositionWithKey$foundation_release$default(PagerState r2, PagerLazyLayoutItemProvider r3, int r4, int r5, Object r6) {
        if (r6 != null) goto L18;
        if ((r5 & 2) == 0) goto L16;
        Snapshot.Companion r7 = Snapshot.Companion;
        Snapshot r8 = r7.getCurrentThreadSnapshot();
        if (r8 == null) goto L8;
        Function1 r9 = r8.getReadObserver();
    L9:
        Snapshot r0 = r7.makeCurrentNonObservable(r8);
        int r1 = r2.scrollPosition.getCurrentPage();     // Catch: Throwable -> L12
        r7.restoreNonObservable(r8, r0, r9);
        r4 = r1;
    L12:
        th = move-exception;
        r7.restoreNonObservable(r8, r0, r9);
        throw th;
    L8:
        r9 = null;
    L16:
        return r2.matchScrollPositionWithKey$foundation_release(r3, r4);
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
    }

    public static /* synthetic */ void requestScrollToPage$default(PagerState r0, int r1, float r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = MenuKt.ClosedAlphaTarget;
    L6:
        r0.requestScrollToPage(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState r0, PagerMeasureResult r1, boolean r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.applyMeasureResult$foundation_release(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState r0, int r1, float r2, Continuation r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L7;
        r2 = MenuKt.ClosedAlphaTarget;
    L7:
        return r0.scrollToPage(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
    }

    public static /* synthetic */ void updateCurrentPage$default(PagerState r0, ScrollScope r1, int r2, float r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L6;
        r3 = MenuKt.ClosedAlphaTarget;
    L6:
        r0.updateCurrentPage(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState r1, int r2, float r3, AnimationSpec r4, Continuation r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 2) == 0) goto L7;
        r3 = MenuKt.ClosedAlphaTarget;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
    L10:
        return r1.animateScrollToPage(r2, r3, r4, r5);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
    }
}
