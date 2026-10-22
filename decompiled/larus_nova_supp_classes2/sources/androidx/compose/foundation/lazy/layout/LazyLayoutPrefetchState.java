package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003;<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B2\b\u0017\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\u000bB&\b\u0017\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u001dJ\u001d\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J<\u0010.\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u001b\b\u0002\u00101\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b3\u00104JD\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020,2\u001b\b\u0002\u00101\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0000¢\u0006\u0002\b:R\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R'\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "<init>", "()V", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function1;)V", "getPrefetchScheduler$foundation_release$annotations", "getPrefetchScheduler$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "setPrefetchScheduler$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "getOnNestedPrefetch$annotations", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release$annotations", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "realizedNestedPrefetchCount", "", "getRealizedNestedPrefetchCount$foundation_release", "()I", "setRealizedNestedPrefetchCount$foundation_release", "(I)V", "idealNestedPrefetchCount", "getIdealNestedPrefetchCount$foundation_release", "setIdealNestedPrefetchCount$foundation_release", "lastNumberOfNestedPrefetchItems", "getLastNumberOfNestedPrefetchItems$foundation_release", "setLastNumberOfNestedPrefetchItems$foundation_release", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "isHighPriority", "", "schedulePrecomposition$foundation_release", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "schedulePrecompositionAndPremeasure-VKLhPVY", "(IJLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release", "(IJZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "collectNestedPrefetchRequests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation_release", "PrefetchHandle", "PrefetchResultScope", "NestedPrefetchScopeImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;
    private int idealNestedPrefetchCount;
    private int lastNumberOfNestedPrefetchItems;
    private Function1<? super NestedPrefetchScope, Unit> onNestedPrefetch;
    private PrefetchHandleProvider prefetchHandleProvider;
    private final PrefetchMetrics prefetchMetrics;
    private PrefetchScheduler prefetchScheduler;
    private int realizedNestedPrefetchCount;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "nestedPrefetchItemCount", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;I)V", "getNestedPrefetchItemCount", "()I", "requests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "getRequests", "()Ljava/util/List;", "_requests", "", "schedulePrecomposition", "", "index", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrecompositionAndPremeasure-0kLqBqw", "(IJ)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class NestedPrefetchScopeImpl implements NestedPrefetchScope {
        private final List<PrefetchRequest> _requests;
        private final int nestedPrefetchItemCount;
        final /* synthetic */ LazyLayoutPrefetchState this$0;

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public final /* synthetic */ void schedulePrefetch(int r1) {
            NestedPrefetchScope.CC.$default$schedulePrefetch(this, r1);
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        public final /* synthetic */ void mo1180schedulePrefetch0kLqBqw(int r1, long r2) {
            NestedPrefetchScope.CC.m1183$default$schedulePrefetch0kLqBqw(this, r1, r2);
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public int getNestedPrefetchItemCount() {
            return this.nestedPrefetchItemCount;
        }

        public final List<PrefetchRequest> getRequests() {
            return this._requests;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrecomposition(int r4) {
            PrefetchHandleProvider r0 = this.this$0.getPrefetchHandleProvider$foundation_release();
            if (r0 != null) goto L5;
            return;
        L5:
            this._requests.add(r0.createNestedPrefetchRequest(r4, LazyLayoutPrefetchState.access$getPrefetchMetrics$p(this.this$0)));
        }

        public NestedPrefetchScopeImpl(LazyLayoutPrefetchState r1, int r2) {
            this.this$0 = r1;
            this.nestedPrefetchItemCount = r2;
            this._requests = new ArrayList();
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-0kLqBqw, reason: not valid java name */
        public void mo1179schedulePrecompositionAndPremeasure0kLqBqw(int r4, long r5) {
            PrefetchHandleProvider r0 = this.this$0.getPrefetchHandleProvider$foundation_release();
            if (r0 != null) goto L5;
            return;
        L5:
            this._requests.add(r0.m1194createNestedPrefetchRequestVKLhPVY(r4, r5, LazyLayoutPrefetchState.access$getPrefetchMetrics$p(this.this$0)));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0006\u0082\u0001\u0002\u0007\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", "cancel", "", "markAsUrgent", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PrefetchHandle {

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Object $default$await(PrefetchHandle r0, Continuation r1) {
                return await$suspendImpl(r0, r1);
            }

            public static /* synthetic */ Object await$suspendImpl(PrefetchHandle r0, Continuation<? super Unit> r1) {
                return Unit.INSTANCE;
            }
        }

        Object await(Continuation<? super Unit> r1);

        void cancel();

        void markAsUrgent();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0019\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0001\u0001\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "", "placeablesCount", "", "getPlaceablesCount", "()I", "index", "getIndex", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PrefetchResultScope {
        int getIndex();

        int getPlaceablesCount();

        /* JADX INFO: renamed from: getSize-YEO4UFw, reason: not valid java name */
        long mo1181getSizeYEO4UFw(int r1);
    }

    private static /* synthetic */ void getOnNestedPrefetch$annotations() {
    }

    public static /* synthetic */ void getPrefetchHandleProvider$foundation_release$annotations() {
    }

    public static /* synthetic */ void getPrefetchScheduler$foundation_release$annotations() {
    }

    public final List<PrefetchRequest> collectNestedPrefetchRequests$foundation_release() {
        Function1<? super NestedPrefetchScope, Unit> r0 = this.onNestedPrefetch;
        if (r0 == null) goto L5;
        NestedPrefetchScopeImpl r1 = new NestedPrefetchScopeImpl(this, this.realizedNestedPrefetchCount);
        r0.invoke(r1);
        List<PrefetchRequest> r2 = r1.getRequests();
        this.lastNumberOfNestedPrefetchItems = r2.size();
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    public LazyLayoutPrefetchState() {
        this.prefetchMetrics = new PrefetchMetrics();
        this.realizedNestedPrefetchCount = -1;
        this.idealNestedPrefetchCount = -1;
    }

    public final int getIdealNestedPrefetchCount$foundation_release() {
        return this.idealNestedPrefetchCount;
    }

    public final int getLastNumberOfNestedPrefetchItems$foundation_release() {
        return this.lastNumberOfNestedPrefetchItems;
    }

    public final PrefetchHandleProvider getPrefetchHandleProvider$foundation_release() {
        return this.prefetchHandleProvider;
    }

    public final PrefetchScheduler getPrefetchScheduler$foundation_release() {
        return this.prefetchScheduler;
    }

    public final int getRealizedNestedPrefetchCount$foundation_release() {
        return this.realizedNestedPrefetchCount;
    }

    public LazyLayoutPrefetchState(Function1<? super NestedPrefetchScope, Unit> r1) {
        this();
        this.onNestedPrefetch = r1;
    }

    public static final /* synthetic */ PrefetchMetrics access$getPrefetchMetrics$p(LazyLayoutPrefetchState r0) {
        return r0.prefetchMetrics;
    }

    public final PrefetchHandle schedulePrecomposition(int r2) {
        return schedulePrecomposition$foundation_release(r2, true);
    }

    public final void setIdealNestedPrefetchCount$foundation_release(int r1) {
        this.idealNestedPrefetchCount = r1;
    }

    public final void setLastNumberOfNestedPrefetchItems$foundation_release(int r1) {
        this.lastNumberOfNestedPrefetchItems = r1;
    }

    public final void setPrefetchHandleProvider$foundation_release(PrefetchHandleProvider r1) {
        this.prefetchHandleProvider = r1;
    }

    public final void setPrefetchScheduler$foundation_release(PrefetchScheduler r1) {
        this.prefetchScheduler = r1;
    }

    public final void setRealizedNestedPrefetchCount$foundation_release(int r1) {
        this.realizedNestedPrefetchCount = r1;
    }

    @Deprecated(message = "Please use overload without Prefetch Scheduler.")
    public LazyLayoutPrefetchState(PrefetchScheduler r1, Function1<? super NestedPrefetchScope, Unit> r2) {
        this();
        this.prefetchScheduler = r1;
        this.onNestedPrefetch = r2;
    }

    public final PrefetchHandle schedulePrecomposition$foundation_release(int r3, boolean r4) {
        PrefetchHandleProvider r0 = this.prefetchHandleProvider;
        if (r0 == null) goto L7;
        PrefetchHandle r5 = r0.schedulePrecomposition(r3, r4, this.prefetchMetrics);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return DummyHandle.INSTANCE;
    }

    public /* synthetic */ LazyLayoutPrefetchState(Function1 r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-VKLhPVY, reason: not valid java name */
    public final PrefetchHandle m1177schedulePrecompositionAndPremeasureVKLhPVY(int r7, long r8, Function1<? super PrefetchResultScope, Unit> r10) {
        return m1178schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(r7, r8, true, r10);
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchScheduler r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release, reason: not valid java name */
    public final PrefetchHandle m1178schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(int r8, long r9, boolean r11, Function1<? super PrefetchResultScope, Unit> r12) {
        PrefetchHandleProvider r0 = this.prefetchHandleProvider;
        if (r0 == null) goto L7;
        PrefetchHandle r10 = r0.m1195schedulePremeasurem8Kt_7k(r8, r9, this.prefetchMetrics, r11, r12);
        if (r10 == null) goto L7;
        return r10;
    L7:
        return DummyHandle.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-VKLhPVY$default, reason: not valid java name */
    public static /* synthetic */ PrefetchHandle m1175schedulePrecompositionAndPremeasureVKLhPVY$default(LazyLayoutPrefetchState r0, int r1, long r2, Function1 r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r0.m1177schedulePrecompositionAndPremeasureVKLhPVY(r1, r2, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ PrefetchHandle m1176xe6b2911(LazyLayoutPrefetchState r6, int r7, long r8, boolean r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L6;
        r11 = null;
    L6:
        return r6.m1178schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(r7, r8, r10, r11);
    }
}
