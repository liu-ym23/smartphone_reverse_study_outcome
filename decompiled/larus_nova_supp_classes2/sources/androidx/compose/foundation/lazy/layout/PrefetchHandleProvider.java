package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJH\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\t2\u0019\u0010 \u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c\u0018\u00010!¢\u0006\u0002\b#¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u001c*\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\tJ%\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\u0016\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "isPausableCompositionInPrefetchEnabled", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Z)V", "isStateActive", "shouldPauseBetweenPrecompositionAndPremeasure", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release$annotations", "()V", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release", "()Z", "setShouldPauseBetweenPrecompositionAndPremeasure$foundation_release", "(Z)V", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "isHighPriority", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "onDisposed", "", "schedulePremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "Lkotlin/ExtensionFunctionType;", "schedulePremeasure-m8Kt_7k", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "executeWithPriority", "request", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "createNestedPrefetchRequest", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "HandleAndRequestImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrefetchHandleProvider {
    public static final int $stable = 8;
    private final PrefetchScheduler executor;
    private final boolean isPausableCompositionInPrefetchEnabled;
    private boolean isStateActive;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private boolean shouldPauseBetweenPrecompositionAndPremeasure;
    private final SubcomposeLayoutState subcomposeLayoutState;

    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB<\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u000fBF\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u0012J\u000e\u0010)\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\u0017\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u00108\u001a\u000206H\u0002J\b\u0010>\u001a\u00020\fH\u0002J\f\u0010?\u001a\u00020\u001b*\u00020@H\u0016J\b\u0010A\u001a\u00020\fH\u0002J\f\u0010B\u001a\u00020\u001b*\u00020@H\u0002J&\u0010D\u001a\u00020\f*\u00020@2\u0006\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001f2\u0006\u0010G\u001a\u00020HH\u0002J\u001a\u0010I\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010J\u001a\u00020\fH\u0002J\u0017\u0010K\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0004\bL\u0010MJ\u0012\u0010N\u001a\f\u0018\u00010\"R\u00060\u0000R\u00020#H\u0002J\b\u0010O\u001a\u00020PH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\f\u0018\u00010\"R\u00060\u0000R\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u000e\u00108\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010C\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "index", "", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "priorityPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "onItemPremeasured", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;ILandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "premeasureConstraints", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "pausedPrecomposition", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "isMeasured", "", "isCanceled", "isApplied", "keyUsedForComposition", "", "hasResolvedNestedPrefetches", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "isUrgent", "isComposed", "()Z", "continuation", "Lkotlin/coroutines/Continuation;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "markAsUrgent", "placeablesCount", "getPlaceablesCount", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "shouldExecute", "available", "", "average", "availableTimeNanos", "elapsedTimeNanos", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "J", "resetAvailableTimeTo", "updateElapsedAndAvailableTime", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "cleanUp", "executeRequest", "pauseRequested", "performPausableComposition", "key", "contentType", "averages", "Landroidx/compose/foundation/lazy/layout/Averages;", "performFullComposition", "performApply", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", "", "NestedPrefetchController", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest, LazyLayoutPrefetchState.PrefetchResultScope {
        private long availableTimeNanos;
        private Continuation<? super Unit> continuation;
        private long elapsedTimeNanos;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        private boolean isApplied;
        private boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private Object keyUsedForComposition;
        private NestedPrefetchController nestedPrefetchController;
        private final Function1<LazyLayoutPrefetchState.PrefetchResultScope, Unit> onItemPremeasured;
        private boolean pauseRequested;
        private SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;
        private Constraints premeasureConstraints;
        private final PriorityPrefetchScheduler priorityPrefetchScheduler;
        private long startTime;
        final /* synthetic */ PrefetchHandleProvider this$0;

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0014\u001a\u00020\u000f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "", "states", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;Ljava/util/List;)V", "requestsByState", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "[Ljava/util/List;", "stateIndex", "", "requestIndex", "executedNestedPrefetch", "", "getExecutedNestedPrefetch", "()Z", "setExecutedNestedPrefetch", "(Z)V", "executeNestedPrefetches", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nestedPrefetchCount", "isUrgent", "collectIdealNestedPrefetchCount", "collectNestedPrefetchedItemsCount", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public final class NestedPrefetchController {
            private boolean executedNestedPrefetch;
            private int requestIndex;
            private final List<PrefetchRequest>[] requestsByState;
            private int stateIndex;
            private final List<LazyLayoutPrefetchState> states;
            final /* synthetic */ HandleAndRequestImpl this$0;

            public final int collectIdealNestedPrefetchCount() {
                List<LazyLayoutPrefetchState> r0 = this.states;
                int r1 = r0.size();
                int r4 = 0;
                int r5 = Integer.MAX_VALUE;
            L3:
                if (r4 >= r1) goto L5;
                r5 = Math.min(r5, ((LazyLayoutPrefetchState) ListProtector.get(r0, r4)).getIdealNestedPrefetchCount$foundation_release());
                r4 = r4 + 1;
                goto L3
            L5:
                if (r5 != Integer.MAX_VALUE) goto L8;
                return 0;
            L8:
                return r5;
            }

            public final int collectNestedPrefetchedItemsCount() {
                List<LazyLayoutPrefetchState> r0 = this.states;
                int r1 = r0.size();
                int r4 = 0;
                int r5 = Integer.MAX_VALUE;
            L3:
                if (r4 >= r1) goto L5;
                r5 = Math.min(r5, ((LazyLayoutPrefetchState) ListProtector.get(r0, r4)).getLastNumberOfNestedPrefetchItems$foundation_release());
                r4 = r4 + 1;
                goto L3
            L5:
                if (r5 != Integer.MAX_VALUE) goto L8;
                return 0;
            L8:
                return r5;
            }

            public final boolean getExecutedNestedPrefetch() {
                return this.executedNestedPrefetch;
            }

            public final void setExecutedNestedPrefetch(boolean r1) {
                this.executedNestedPrefetch = r1;
            }

            public NestedPrefetchController(HandleAndRequestImpl r1, List<LazyLayoutPrefetchState> r2) {
                this.this$0 = r1;
                this.states = r2;
                this.requestsByState = new List[r2.size()];
                if ((!r2.isEmpty()) == true) goto L6;
                InlineClassHelperKt.throwIllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
                return;
            }

            public final boolean executeNestedPrefetches(PrefetchRequestScope r8, int r9, boolean r10) {
                if (this.stateIndex < this.states.size()) goto L6;
                return false;
            L6:
                if ((!HandleAndRequestImpl.access$isCanceled$p(this.this$0)) == true) goto L9;
                InlineClassHelperKt.throwIllegalStateException("Should not execute nested prefetch on canceled request");
            L9:
                if (ComposeFoundationFlags.isAutomaticNestedPrefetchEnabled == false) goto L19;
                Trace.beginSection("compose:lazy:prefetch:update_nested_prefetch_count");
                List<LazyLayoutPrefetchState> r0 = this.states;     // Catch: Throwable -> L16
                int r3 = r0.size();     // Catch: Throwable -> L16
                int r4 = 0;
            L12:
                if (r4 >= r3) goto L14;
                r0.get(r4).setRealizedNestedPrefetchCount$foundation_release(r9);     // Catch: Throwable -> L16
                r4 = r4 + 1;     // Catch: Throwable -> L16
                goto L12
            L14:
                Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
                Trace.endSection();
            L16:
                th = move-exception;
                Trace.endSection();
                throw th;
            L19:
                Trace.beginSection("compose:lazy:prefetch:nested");
            L55:
            L50:
                th = move-exception;
                Trace.endSection();
                throw th;
            L21:
                if (this.stateIndex >= this.states.size()) goto L47;
                if (this.requestsByState[this.stateIndex] == null) goto L26;
            L30:
                List<PrefetchRequest> r12 = this.requestsByState[this.stateIndex];     // Catch: Throwable -> L50
                Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L50
            L32:
                if (this.requestIndex >= r12.size()) goto L46;
                PrefetchRequest r1 = r12.get(this.requestIndex);     // Catch: Throwable -> L50
                if (r10 == true) goto L36;
            L41:
                this.executedNestedPrefetch = true;     // Catch: Throwable -> L50
                if (r1.execute(r8) == true) goto L43;
                this.requestIndex++;     // Catch: Throwable -> L50
                goto L32
            L43:
                Trace.endSection();
                return true;
            L36:
                if ((r1 instanceof HandleAndRequestImpl) == false) goto L38;
                HandleAndRequestImpl r5 = (HandleAndRequestImpl) r1;     // Catch: Throwable -> L50
            L39:
                if (r5 == null) goto L41;
                r5.markAsUrgent();     // Catch: Throwable -> L50
                goto L41
            L38:
                r5 = null;
                goto L39
            L46:
                this.requestIndex = 0;     // Catch: Throwable -> L50
                this.stateIndex++;     // Catch: Throwable -> L50
                goto L55
            L26:
                if (r8.availableTimeNanos() <= 0) goto L27;
                List<PrefetchRequest>[] r13 = this.requestsByState;     // Catch: Throwable -> L50
                int r2 = this.stateIndex;     // Catch: Throwable -> L50
                r13[r2] = this.states.get(r2).collectNestedPrefetchRequests$foundation_release();     // Catch: Throwable -> L50
                goto L30
            L27:
                Trace.endSection();
                return true;
            L47:
                Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L50
                Trace.endSection();
                return false;
            }
        }

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider r1, int r2, long r3, PrefetchMetrics r5, PriorityPrefetchScheduler r6, Function1 r7, DefaultConstructorMarker r8) {
            this(r1, r2, r3, r5, r6, r7);
        }

        public static /* synthetic */ TraversableNode.Companion.TraverseDescendantsAction a(Ref.ObjectRef r0, TraversableNode r1) {
            return resolveNestedPrefetchStates$lambda$20(r0, r1);
        }

        public static /* synthetic */ boolean b(HandleAndRequestImpl r0, Averages r1) {
            return performPausableComposition$lambda$11(r0, r1);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void markAsUrgent() {
            this.isUrgent = true;
        }

        private final void cleanUp() {
            SubcomposeLayoutState.PausedPrecomposition r0 = this.pausedPrecomposition;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.pausedPrecomposition = null;
            SubcomposeLayoutState.PrecomposedSlotHandle r1 = this.precomposeHandle;
            if (r1 == null) goto L8;
            r1.dispose();
        L8:
            this.precomposeHandle = null;
            this.nestedPrefetchController = null;
            Continuation<? super Unit> r2 = this.continuation;
            if (r2 == null) goto L11;
            Result.Companion r3 = Result.Companion;
            r2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        L11:
            this.continuation = null;
        }

        private final boolean isComposed() {
            if (this.isApplied == true) goto L14;
            SubcomposeLayoutState.PausedPrecomposition r0 = this.pausedPrecomposition;
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L15;
            return false;
        L15:
            return true;
        L7:
            if (r0.isComplete() != true) goto L9;
            r1 = true;
            goto L10
        L14:
            return true;
        }

        private final void performApply() {
            SubcomposeLayoutState.PausedPrecomposition r0 = this.pausedPrecomposition;
            if (r0 == null) goto L10;
            this.precomposeHandle = r0.apply();
            this.pausedPrecomposition = null;
            this.isApplied = true;
            Continuation<? super Unit> r1 = this.continuation;
            if (r1 == null) goto L7;
            Result.Companion r2 = Result.Companion;
            r1.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        L7:
            this.continuation = null;
            return;
        L10:
            throw new IllegalArgumentException("Nothing to apply!".toString());
        }

        private final NestedPrefetchController resolveNestedPrefetchStates() {
            SubcomposeLayoutState.PrecomposedSlotHandle r0 = this.precomposeHandle;
            if (r0 == null) goto L9;
            final Ref.ObjectRef r1 = new Ref.ObjectRef();
            r0.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new m0(r1));
            List r2 = (List) r1.element;
            if (r2 != null) goto L11;
            return null;
        L11:
            return new NestedPrefetchController(this, r2);
        L9:
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Should precompose before resolving nested prefetch states");
            throw new KotlinNothingValueException();
        }

        private final void updateElapsedAndAvailableTime() {
            long r0 = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
            long r2 = Duration.getInWholeNanoseconds-impl(TimeSource.Monotonic.ValueTimeMark.minus-6eNON_k(r0, this.startTime));
            this.elapsedTimeNanos = r2;
            long r4 = this.availableTimeNanos - r2;
            this.availableTimeNanos = r4;
            this.startTime = r0;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", r4);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void cancel() {
            if (this.isCanceled == true) goto L5;
            this.isCanceled = true;
            cleanUp();
        L5:
            Continuation<? super Unit> r0 = this.continuation;
            if (r0 == null) goto L8;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        L8:
            this.continuation = null;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        public int getPlaceablesCount() {
            SubcomposeLayoutState.PrecomposedSlotHandle r0 = this.precomposeHandle;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPlaceablesCount();
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + getIndex() + ", constraints = " + this.premeasureConstraints + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        public int getIndex() {
            return this.index;
        }

        public static final /* synthetic */ boolean access$isCanceled$p(HandleAndRequestImpl r0) {
            return r0.isCanceled;
        }

        private final boolean executeRequest(PrefetchRequestScope r18) {
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", getIndex());
            LazyLayoutItemProvider r2 = (LazyLayoutItemProvider) PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getItemProvider().invoke();
            if (this.isCanceled == true) goto L11;
            int r3 = r2.getItemCount();
            int r7 = getIndex();
            if (r7 < 0) goto L8;
            if (r7 >= r3) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            boolean r5 = true;
        L12:
            if (r5 == true) goto L15;
            cleanUp();
            return false;
        L15:
            Object r6 = r2.getKey(getIndex());
            Object r8 = this.keyUsedForComposition;
            if (r8 != null) goto L18;
        L21:
            Object r9 = r2.getContentType(getIndex());
            Averages r10 = this.prefetchMetrics.getAverage(r9);
            boolean r11 = isComposed();
            resetAvailableTimeTo(r18.availableTimeNanos());
            if (isComposed() == true) goto L45;
            if (PrefetchHandleProvider.access$isPausableCompositionInPrefetchEnabled$p(this.this$0) == false) goto L34;
            if (shouldExecute(this.availableTimeNanos, r10.getResumeTimeNanos() + r10.getPauseTimeNanos()) == false) goto L42;
            Trace.beginSection("compose:lazy:prefetch:compose");
            performPausableComposition(r18, r6, r9, r10);     // Catch: Throwable -> L30
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L30
            Trace.endSection();
        L30:
            th = move-exception;
            Trace.endSection();
            throw th;
        L42:
            if (isComposed() == true) goto L45;
            return true;
        L34:
            if (shouldExecute(this.availableTimeNanos, r10.getCompositionTimeNanos()) == false) goto L42;
            Trace.beginSection("compose:lazy:prefetch:compose");
            performFullComposition(r6, r9);     // Catch: Throwable -> L38
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L38
            Trace.endSection();
            updateElapsedAndAvailableTime();
            r10.saveCompositionTimeNanos(this.elapsedTimeNanos);
        L38:
            th = move-exception;
            Trace.endSection();
            throw th;
        L45:
            if (this.pausedPrecomposition == null) goto L56;
            if (shouldExecute(this.availableTimeNanos, r10.getApplyTimeNanos()) == false) goto L54;
            Trace.beginSection("compose:lazy:prefetch:apply");
            performApply();     // Catch: Throwable -> L51
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L51
            Trace.endSection();
            updateElapsedAndAvailableTime();
            r10.saveApplyTimeNanos(this.elapsedTimeNanos);
        L51:
            th = move-exception;
            Trace.endSection();
            throw th;
        L54:
            return true;
        L56:
            if (this.hasResolvedNestedPrefetches == false) goto L58;
        L66:
            NestedPrefetchController r15 = this.nestedPrefetchController;
            if (r15 == null) goto L69;
            boolean r0 = r15.executeNestedPrefetches(r18, r10.getNestedPrefetchCount(), this.isUrgent);
        L70:
            if (r0 == false) goto L72;
            return true;
        L72:
            NestedPrefetchController r1 = this.nestedPrefetchController;
            if (r1 != null) goto L75;
        L77:
            boolean r16 = false;
        L78:
            if (r16 == false) goto L82;
            updateElapsedAndAvailableTime();
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", getIndex());
            NestedPrefetchController r17 = this.nestedPrefetchController;
            if (r17 == null) goto L82;
            r17.setExecutedNestedPrefetch(false);
        L82:
            Constraints r19 = this.premeasureConstraints;
            if (this.isMeasured == true) goto L100;
            if (r19 == null) goto L100;
            if (this.this$0.getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release() == false) goto L90;
            if (r11 == true) goto L90;
            return true;
        L90:
            if (shouldExecute(this.availableTimeNanos, r10.getMeasureTimeNanos()) == false) goto L99;
            Trace.beginSection("compose:lazy:prefetch:measure");
            m1196performMeasureBRTryo0(r19.unbox-impl());     // Catch: Throwable -> L96
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L96
            Trace.endSection();
            updateElapsedAndAvailableTime();
            r10.saveMeasureTimeNanos(this.elapsedTimeNanos);
            Function1<LazyLayoutPrefetchState.PrefetchResultScope, Unit> r21 = this.onItemPremeasured;
            if (r21 == null) goto L100;
            r21.invoke(this);
        L96:
            th = move-exception;
            Trace.endSection();
            throw th;
        L99:
            return true;
        L100:
            NestedPrefetchController r22 = this.nestedPrefetchController;
            if (ComposeFoundationFlags.isAutomaticNestedPrefetchEnabled == true) goto L103;
        L110:
            return false;
        L103:
            if (this.isMeasured == false) goto L110;
            if (this.hasResolvedNestedPrefetches == false) goto L110;
            if (r22 == null) goto L110;
            int r23 = r22.collectIdealNestedPrefetchCount();
            r10.saveNestedPrefetchCount(r23);
            if (r22.collectNestedPrefetchedItemsCount() >= r23) goto L110;
            r10.clearMeasureTime();
            goto L110
        L75:
            if (r1.getExecutedNestedPrefetch() != true) goto L77;
            r16 = true;
            goto L78
        L69:
            r0 = false;
            goto L70
        L58:
            if (this.availableTimeNanos <= 0) goto L65;
            Trace.beginSection("compose:lazy:prefetch:resolve-nested");
            this.nestedPrefetchController = resolveNestedPrefetchStates();     // Catch: Throwable -> L62
            this.hasResolvedNestedPrefetches = true;     // Catch: Throwable -> L62
            Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L62
            Trace.endSection();
        L62:
            th = move-exception;
            Trace.endSection();
            throw th;
        L65:
            return true;
        L18:
            if (Intrinsics.areEqual(r6, r8) == true) goto L21;
            cleanUp();
            return false;
        L8:
            r4 = false;
        L11:
            r5 = false;
            goto L12
        }

        /* JADX INFO: renamed from: performMeasure-BRTryo0, reason: not valid java name */
        private final void m1196performMeasureBRTryo0(long r4) {
            if ((!this.isCanceled) == true) goto L6;
            InlineClassHelperKt.throwIllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
        L6:
            if ((!this.isMeasured) == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Request was already measured!");
        L8:
            this.isMeasured = true;
            SubcomposeLayoutState.PrecomposedSlotHandle r0 = this.precomposeHandle;
            if (r0 == null) goto L14;
            int r1 = r0.getPlaceablesCount();
            int r2 = 0;
        L11:
            if (r2 >= r1) goto L13;
            r0.premeasure-0kLqBqw(r2, r4);
            r2 = r2 + 1;
            goto L11
        L13:
            return;
        L14:
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("performComposition() must be called before performMeasure()");
            throw new KotlinNothingValueException();
        }

        private final void resetAvailableTimeTo(long r3) {
            this.availableTimeNanos = r3;
            this.startTime = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
            this.elapsedTimeNanos = 0;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", r3);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public Object await(Continuation<? super Unit> r6) {
            if ((r6 instanceof PrefetchHandleProvider$HandleAndRequestImpl$await$1) == false) goto L7;
            PrefetchHandleProvider$HandleAndRequestImpl$await$1 r0 = (PrefetchHandleProvider$HandleAndRequestImpl$await$1) r6;
            int r1 = r0.label;
            if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
            r0.label = r1 - RtlSpacingHelper.UNDEFINED;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r7);
        L25:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r7);
        L19:
            r0.label = 2;
            SafeContinuation r8 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
            this.continuation = r8;
            Object r9 = r8.getOrThrow();
            if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
            DebugProbesKt.probeCoroutineSuspended(r0);
        L22:
            if (r9 != r2) goto L25;
            return r2;
        L16:
            ResultKt.throwOnFailure(r7);
            r0.label = 1;
            if (LazyLayoutPrefetchState.PrefetchHandle.CC.$default$await(this, r0) != r2) goto L19;
            return r2;
        L7:
            r0 = new PrefetchHandleProvider$HandleAndRequestImpl$await$1(this, r6);
            goto L8
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequest
        public boolean execute(PrefetchRequestScope r4) {
            if (PrefetchHandleProvider.access$isStateActive$p(this.this$0) == true) goto L7;
            return false;
        L7:
            if (this.isUrgent == false) goto L14;
            Trace.beginSection("compose:lazy:prefetch:execute:urgent");
            boolean r5 = executeRequest(r4);     // Catch: Throwable -> L11
            Trace.endSection();
        L15:
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", -1);
            return r5;
        L11:
            th = move-exception;
            Trace.endSection();
            throw th;
        L14:
            r5 = executeRequest(r4);
            goto L15
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        /* JADX INFO: renamed from: getSize-YEO4UFw */
        public long mo1181getSizeYEO4UFw(int r3) {
            SubcomposeLayoutState.PrecomposedSlotHandle r0 = this.precomposeHandle;
            if (r0 == null) goto L6;
            return r0.getSize-YEO4UFw(r3);
        L6:
            return IntSize.Companion.getZero-YbymL2g();
        }

        private final void performFullComposition(Object r4, Object r5) {
            if (this.precomposeHandle != null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Request was already composed!");
        L8:
            Function2<Composer, Integer, Unit> r6 = PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getContent(getIndex(), r4, r5);
            this.keyUsedForComposition = r4;
            this.precomposeHandle = PrefetchHandleProvider.access$getSubcomposeLayoutState$p(this.this$0).precompose(r4, r6);
            this.isApplied = true;
            return;
        L5:
            r0 = false;
            goto L6
        }

        private static final boolean performPausableComposition$lambda$11(HandleAndRequestImpl r6, Averages r7) {
            if (r6.pauseRequested == true) goto L6;
            r6.updateElapsedAndAvailableTime();
            r7.saveResumeTimeNanos(r6.elapsedTimeNanos);
            r6.pauseRequested = !r6.shouldExecute(r6.availableTimeNanos, r7.getResumeTimeNanos() + r7.getPauseTimeNanos());
        L6:
            return r6.pauseRequested;
        }

        private static final TraversableNode.Companion.TraverseDescendantsAction resolveNestedPrefetchStates$lambda$20(Ref.ObjectRef r2, TraversableNode r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
            LazyLayoutPrefetchState r4 = ((TraversablePrefetchStateNode) r3).getPrefetchState();
            List r0 = (List) r2.element;
            if (r0 == null) goto L5;
            r0.add(r4);
        L6:
            r2.element = r0;
            return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
        L5:
            r0 = CollectionsKt.mutableListOf(new LazyLayoutPrefetchState[]{r4});
            goto L6
        }

        private final boolean shouldExecute(long r2, long r4) {
            if (this.isUrgent == false) goto L6;
            r4 = 0;
        L6:
            if (r2 <= r4) goto L8;
            return true;
        L8:
            return false;
        }

        private final void performPausableComposition(PrefetchRequestScope r3, Object r4, Object r5, final Averages r6) {
            SubcomposeLayoutState.PausedPrecomposition r7 = this.pausedPrecomposition;
            if (r7 != null) goto L5;
            PrefetchHandleProvider r8 = this.this$0;
            Function2<Composer, Integer, Unit> r9 = PrefetchHandleProvider.access$getItemContentFactory$p(r8).getContent(getIndex(), r4, r5);
            r7 = PrefetchHandleProvider.access$getSubcomposeLayoutState$p(r8).createPausedPrecomposition(r4, r9);
            this.pausedPrecomposition = r7;
            this.keyUsedForComposition = r4;
        L5:
            this.pauseRequested = false;
        L7:
            if (r7.isComplete() == true) goto L11;
            if (this.pauseRequested == true) goto L11;
            r7.resume(new l0(this, r6));
        L11:
            updateElapsedAndAvailableTime();
            if (this.pauseRequested == false) goto L14;
            r6.savePauseTimeNanos(this.elapsedTimeNanos);
            return;
        L14:
            r6.saveResumeTimeNanos(this.elapsedTimeNanos);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public HandleAndRequestImpl(PrefetchHandleProvider r1, int r2, PrefetchMetrics r3, PriorityPrefetchScheduler r4, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> r5) {
            this.this$0 = r1;
            this.index = r2;
            this.prefetchMetrics = r3;
            this.priorityPrefetchScheduler = r4;
            this.onItemPremeasured = r5;
            this.startTime = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
        }

        private HandleAndRequestImpl(PrefetchHandleProvider r7, int r8, long r9, PrefetchMetrics r11, PriorityPrefetchScheduler r12, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> r13) {
            this(r7, r8, r11, r12, r13);
            this.premeasureConstraints = Constraints.box-impl(r9);
        }
    }

    public static /* synthetic */ void getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release$annotations() {
    }

    public final void onDisposed() {
        this.isStateActive = false;
    }

    public final boolean getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release() {
        return this.shouldPauseBetweenPrecompositionAndPremeasure;
    }

    public static final /* synthetic */ LazyLayoutItemContentFactory access$getItemContentFactory$p(PrefetchHandleProvider r0) {
        return r0.itemContentFactory;
    }

    public static final /* synthetic */ SubcomposeLayoutState access$getSubcomposeLayoutState$p(PrefetchHandleProvider r0) {
        return r0.subcomposeLayoutState;
    }

    public static final /* synthetic */ boolean access$isPausableCompositionInPrefetchEnabled$p(PrefetchHandleProvider r0) {
        return r0.isPausableCompositionInPrefetchEnabled;
    }

    public static final /* synthetic */ boolean access$isStateActive$p(PrefetchHandleProvider r0) {
        return r0.isStateActive;
    }

    public final void setShouldPauseBetweenPrecompositionAndPremeasure$foundation_release(boolean r1) {
        this.shouldPauseBetweenPrecompositionAndPremeasure = r1;
    }

    public final PrefetchRequest createNestedPrefetchRequest(int r8, PrefetchMetrics r9) {
        PrefetchScheduler r0 = this.executor;
        if ((r0 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r1 = (PriorityPrefetchScheduler) r0;
    L7:
        return new HandleAndRequestImpl(this, r8, r9, r1, null);
    L5:
        r1 = null;
        goto L7
    }

    /* JADX INFO: renamed from: createNestedPrefetchRequest-VKLhPVY, reason: not valid java name */
    public final PrefetchRequest m1194createNestedPrefetchRequestVKLhPVY(int r11, long r12, PrefetchMetrics r14) {
        PrefetchScheduler r0 = this.executor;
        if ((r0 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r1 = (PriorityPrefetchScheduler) r0;
    L7:
        return new HandleAndRequestImpl(this, r11, r12, r14, r1, null, null);
    L5:
        r1 = null;
        goto L7
    }

    public final void executeWithPriority(PrefetchScheduler r2, PrefetchRequest r3, boolean r4) {
        if ((r2 instanceof PriorityPrefetchScheduler) == false) goto L7;
        if (r4 == false) goto L6;
        ((PriorityPrefetchScheduler) r2).scheduleHighPriorityPrefetch(r3);
        return;
    L6:
        ((PriorityPrefetchScheduler) r2).scheduleLowPriorityPrefetch(r3);
        return;
    L7:
        r2.schedulePrefetch(r3);
    }

    public final LazyLayoutPrefetchState.PrefetchHandle schedulePrecomposition(int r8, boolean r9, PrefetchMetrics r10) {
        PrefetchScheduler r0 = this.executor;
        if ((r0 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r1 = (PriorityPrefetchScheduler) r0;
    L6:
        HandleAndRequestImpl r6 = new HandleAndRequestImpl(this, r8, r10, r1, null);
        executeWithPriority(this.executor, r6, r9);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", r8);
        return r6;
    L5:
        r1 = null;
        goto L6
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory r1, SubcomposeLayoutState r2, PrefetchScheduler r3, boolean r4) {
        this.itemContentFactory = r1;
        this.subcomposeLayoutState = r2;
        this.executor = r3;
        this.isPausableCompositionInPrefetchEnabled = r4;
        this.isStateActive = true;
    }

    /* JADX INFO: renamed from: schedulePremeasure-m8Kt_7k, reason: not valid java name */
    public final LazyLayoutPrefetchState.PrefetchHandle m1195schedulePremeasurem8Kt_7k(int r12, long r13, PrefetchMetrics r15, boolean r16, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> r17) {
        PrefetchScheduler r0 = this.executor;
        if ((r0 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r1 = (PriorityPrefetchScheduler) r0;
    L6:
        HandleAndRequestImpl r10 = new HandleAndRequestImpl(this, r12, r13, r15, r1, r17, null);
        executeWithPriority(this.executor, r10, r16);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", r12);
        return r10;
    L5:
        r1 = null;
        goto L6
    }
}
