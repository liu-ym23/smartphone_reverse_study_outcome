package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.Middleware;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.ext.list.Payload;
import com.bytedance.jedi.arch.ext.list.differ.JediListPrefetcher;
import com.bytedance.jedi.codegen.anno.OutService;
import com.bytedance.locallife.dito.data.DitoNode;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "use ListViewModel instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0016\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u0003*\b\b\u0002\u0010\u0004*\u00020\u00052\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00070\u00062\u00020\bBÕ\u0001\u0012,\u0010\t\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b0\n\u00120\b\u0002\u0010\u000e\u001a*\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b\u0018\u00010\n\u00126\b\u0002\u0010\u000f\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u0011\u00126\b\u0002\u0010\u0012\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u0011¢\u0006\u0002\u0010\u0013Jl\u0010\u0017\u001a\u00020\u001824\u0010\u0012\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u00112,\u0010\u000e\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b0\nH\u0002J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002Jl\u0010\u001e\u001a\u00020\u001824\u0010\u000f\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u00112,\u0010\t\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b0\nH\u0002J\u001b\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00028\u0001¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\rJ\b\u0010$\u001a\u00020\u0018H\u0007Jl\u0010%\u001a\u00020\u001826\b\u0002\u0010\u0012\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u00112,\u0010%\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b0\nJl\u0010&\u001a\u00020\u001826\b\u0002\u0010\u000f\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u00112,\u0010&\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b0\nJ\u001d\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00028\u0001H\u0007¢\u0006\u0002\u0010\"J'\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001b2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\b)J/\u0010*\u001a\u00020\u00182'\u0010+\u001a#\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u0010J)\u0010/\u001a\u00020\u00182\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002010\n2\u0006\u0010!\u001a\u00028\u0001H\u0007¢\u0006\u0002\u00102J3\u0010/\u001a\u00020\u00182\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002010\n2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\b)J \u00103\u001a\u00020\u00182\u0018\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u00010\f0\rJ\b\u00105\u001a\u00020\u0018H\u0007J\u000e\u00106\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001bJ\u001a\u00107\u001a\u00020\u00182\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002010\nJ\u001a\u00108\u001a\u00020\u00182\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002010\nJ\u0016\u00109\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u001bJ\u0084\u0001\u0010;\u001a\u00020\u00182\u001c\b\u0002\u0010<\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020\u0018\u0018\u00010\n2\u0016\b\u0002\u0010=\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0016\b\u0002\u0010A\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0018\u0018\u00010\n2\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0018\u0018\u00010\nJü\u0001\u0010;\u001a\u00020\u0018\"\b\b\u0003\u0010C*\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HC0F2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010H2\b\b\u0002\u0010I\u001a\u0002012\b\b\u0002\u0010J\u001a\u0002012\u0016\b\u0002\u0010=\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002HC\u0018\u00010>2\u0016\b\u0002\u0010@\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002HC\u0018\u00010>2!\b\u0002\u0010A\u001a\u001b\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010¢\u0006\u0002\b)2!\b\u0002\u0010B\u001a\u001b\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010¢\u0006\u0002\b)2\u001b\b\u0002\u0010K\u001a\u0015\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00020\u0018\u0018\u00010\n¢\u0006\u0002\b)2!\b\u0002\u0010L\u001a\u001b\u0012\u0004\u0012\u0002HC\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010¢\u0006\u0002\b)H\u0007J\u0010\u0010M\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u001bH\u0016J\u0014\u0010O\u001a\u00020\u00182\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010\rJ&\u0010Q\u001a\u00020R*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0002R6\u0010\u000e\u001a*\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\t\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0006\u0012\u0004\u0018\u00018\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R<\u0010\u0012\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R<\u0010\u000f\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0010j\b\u0012\u0004\u0012\u00028\u0001`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/ListMiddleware;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", ExifInterface.GPS_DIRECTION_TRUE, "P", "Lcom/bytedance/jedi/arch/ext/list/Payload;", "Lcom/bytedance/jedi/arch/Middleware;", "Lcom/bytedance/jedi/arch/ext/list/ListState;", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "actualRefresh", "Lkotlin/Function1;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "actualLoadMore", "refreshStrategy", "Lkotlin/Function2;", "Lcom/bytedance/jedi/arch/ext/list/LoadStrategy;", "loadMoreStrategy", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "prefetcher", "Lkotlin/Lazy;", "com/bytedance/jedi/arch/ext/list/ListMiddleware$prefetcher$1$1", "doLoadMore", "", "doOnLoadNextResult", "loadedSize", "", "error", "", "doRefresh", "insert", "position", "data", "(ILjava/lang/Object;)V", "insertMultiple", DitoNode.LOAD_MORE, "manualLoadMore", "manualRefresh", PriorityModule.OPERATOR_MODIFY, "reducer", "Lkotlin/ExtensionFunctionType;", "modifyAll", "mapper", "Lkotlin/ParameterName;", "name", "index", "modifyFirst", "predicate", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "modifyMultiple", "pairs", "refresh", "remove", "removeAll", "removeFirst", "removeMultiple", "count", "subscribe", "onData", "refreshListener", "Lcom/bytedance/jedi/arch/ext/list/ListListener;", "Lcom/bytedance/jedi/arch/ext/list/EmptyReceiver;", "loadMoreListener", "onHasMore", "onEmpty", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", "subscriber", "Lcom/bytedance/jedi/arch/ISubscriber;", "adapter", "Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", "force", "uniqueOnly", "onSubmitFinish", "onPayloadChange", "tryPrefetch", "indexToPrefetch", "updateList", "newList", "createEmpty", "Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class ListMiddleware<S extends State, T, P extends Payload> extends Middleware<S, ListState<T, P>> implements JediListPrefetcher.Fetcher {
    private final Function1<S, Observable<Pair<List<T>, P>>> actualLoadMore;
    private final Function1<S, Observable<Pair<List<T>, P>>> actualRefresh;
    private final Function2<List<? extends T>, List<? extends T>, List<T>> loadMoreStrategy;
    private final Lazy<ListMiddleware$prefetcher$1.AnonymousClass1> prefetcher;
    private final Function2<List<? extends T>, List<? extends T>, List<T>> refreshStrategy;

    @OutService
    public final void loadMore() {
        Function1<S, Observable<Pair<List<T>, P>>> r100 = this.actualLoadMore;
        if (r100 == null) goto L6;
        doLoadMore(this.loadMoreStrategy, r100);
        return;
    }

    @OutService
    public final void refresh() {
        doRefresh(this.refreshStrategy, this.actualRefresh);
    }

    public final void modifyAll(final Function2<? super Integer, ? super T, ? extends T> r100) {
        withSubstate(new C106011(this, r100));
    }

    public final void modifyMultiple(final List<? extends Pair<Integer, ? extends T>> r100) {
        withSubstate(new C106041(this, r100));
    }

    public final void remove(final int r100) {
        withSubstate(new C106051(this, r100));
    }

    public final void removeAll(final Function1<? super T, Boolean> r100) {
        withSubstate(new C106061(this, r100));
    }

    public final void removeFirst(final Function1<? super T, Boolean> r100) {
        withSubstate(new C106071(this, r100));
    }

    @Override // com.bytedance.jedi.arch.ext.list.differ.JediListPrefetcher.Fetcher
    public void tryPrefetch(int r100) {
        this.prefetcher.getValue().tryPrefetch(r100);
    }

    public final void updateList(final List<? extends T> r100) {
        setSubstate(new C106091(this, r100));
    }

    public static final /* synthetic */ void access$withSubstate(ListMiddleware r100, Function1 r101) {
        r100.withSubstate(r101);
    }

    private final DistinctBoolean createEmpty(ListState<T, P> r100, List<? extends T> r101) {
        boolean r102 = r101.isEmpty();
        if (r102 != r100.isEmpty().getValue()) goto L6;
        return r100.isEmpty();
    L6:
        return new DistinctBoolean(r102);
    }

    private final void doLoadMore(final Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r100, final Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101) {
        withState(new AnonymousClass1(this, r101, r100));
    }

    private final void doOnLoadNextResult(int r100, Throwable r101) {
        Lazy<ListMiddleware$prefetcher$1.AnonymousClass1> r102 = this.prefetcher;
        if (r102.isInitialized() == false) goto L6;
        r102.getValue().onLoaded(r100, r101);
        return;
    }

    private final void doRefresh(final Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r100, final Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101) {
        withState(new C105971(this, r101, r100));
    }

    public final void insert(final int r100, final T r101) {
        withSubstate(new C105981(this, r100, r101));
    }

    public final void insertMultiple(final int r100, final List<? extends T> r101) {
        withSubstate(new C105991(this, r100, r101));
    }

    public final void manualLoadMore(Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r100, Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101) {
        doLoadMore(r100, r101);
    }

    public final void manualRefresh(Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r100, Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101) {
        doRefresh(r100, r101);
    }

    @Deprecated(message = "call modify with reducer")
    public final void modify(final int r100, final T r101) {
        withSubstate(new C106001(this, r100, r101));
    }

    @Deprecated(message = "call modifyFirst with reducer")
    public final void modifyFirst(final Function1<? super T, Boolean> r100, final T r101) {
        withSubstate(new C106021(this, r100, r101));
    }

    public final void removeMultiple(final int r100, final int r101) {
        withSubstate(new C106081(this, r101, r100));
    }

    public final void modify(final int r100, final Function1<? super T, ? extends T> r101) {
        withSubstate(new AnonymousClass2(this, r100, r101));
    }

    public final void modifyFirst(final Function1<? super T, Boolean> r100, final Function1<? super T, ? extends T> r101) {
        withSubstate(new C106032(this, r100, r101));
    }

    public static final /* synthetic */ DistinctBoolean access$createEmpty(ListMiddleware r100, ListState r101, List r102) {
        return r100.createEmpty(r101, r102);
    }

    public static final /* synthetic */ void access$doOnLoadNextResult(ListMiddleware r100, int r101, Throwable r102) {
        r100.doOnLoadNextResult(r101, r102);
    }

    public static final /* synthetic */ Disposable access$execute(ListMiddleware r100, Observable r101, Function2 r102) {
        return r100.execute(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListMiddleware(Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r100, Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101, Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r102, Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r103) {
        this.actualRefresh = r100;
        this.actualLoadMore = r101;
        this.refreshStrategy = r102;
        this.loadMoreStrategy = r103;
        this.prefetcher = LazyKt.lazy(new ListMiddleware$prefetcher$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void manualLoadMore$default(ListMiddleware r100, Function2 r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = r100.loadMoreStrategy;
    L5:
        r100.manualLoadMore(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void manualRefresh$default(ListMiddleware r100, Function2 r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = r100.refreshStrategy;
    L5:
        r100.manualRefresh(r101, r102);
    }

    public final void subscribe(final Function1<? super List<? extends T>, Unit> r100, final ListListener<T, EmptyReceiver> r101, final ListListener<T, EmptyReceiver> r102, final Function1<? super Boolean, Unit> r103, final Function1<? super Boolean, Unit> r104) {
        if (r103 == null) goto L4;
        selectSubscribe(ListMiddleware$subscribe$7$1.INSTANCE, new ListMiddleware$subscribe$7$2(r103));
    L4:
        if (r104 == null) goto L6;
        selectSubscribe(ListMiddleware$subscribe$8$1.INSTANCE, new ListMiddleware$subscribe$8$2(r104));
    L6:
        if (r101 == null) goto L8;
        asyncSubscribe(ListMiddleware$subscribe$9$1.INSTANCE, new ListMiddleware$subscribe$9$2(r101), new ListMiddleware$subscribe$9$3(r101), new ListMiddleware$subscribe$9$4(r101));
    L8:
        if (r102 == null) goto L10;
        asyncSubscribe(ListMiddleware$subscribe$10$1.INSTANCE, new ListMiddleware$subscribe$10$2(r102), new ListMiddleware$subscribe$10$3(r102), new ListMiddleware$subscribe$10$4(r102));
    L10:
        if (r100 == null) goto L13;
        selectSubscribe(ListMiddleware$subscribe$11$1.INSTANCE, new ListMiddleware$subscribe$11$2(r100));
        return;
    }

    public /* synthetic */ ListMiddleware(Function1 r100, Function1 r101, Function2 r102, Function2 r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = LoadStrategyKt.Replace();
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = LoadStrategyKt.Append();
    L11:
        this(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void subscribe$default(ListMiddleware r100, Function1 r101, ListListener r102, ListListener r103, Function1 r104, Function1 r105, int r106, Object r107) {
        if ((r106 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r104 = null;
    L15:
        if ((r106 & 16) == 0) goto L17;
        r105 = null;
    L17:
        r100.subscribe(r101, r102, r103, r104, r105);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OutService
    public final <RECEIVER extends IReceiver> void subscribe(final ISubscriber<? extends RECEIVER> r110, final DiffableAdapter<T> r111, final boolean r112, final boolean r210, final ListListener<T, RECEIVER> r211, final ListListener<T, RECEIVER> r212, final Function2<? super RECEIVER, ? super Boolean, Unit> r213, final Function2<? super RECEIVER, ? super Boolean, Unit> r214, final Function1<? super RECEIVER, Unit> r215, final Function2<? super RECEIVER, ? super P, Unit> r216) {
        if (r216 == null) goto L5;
        selectSubscribe(r110, ListMiddleware$subscribe$1$1.INSTANCE, r210, r112, new ListMiddleware$subscribe$1$2(r216));
    L5:
        if (r213 == null) goto L7;
        selectSubscribe(r110, ListMiddleware$subscribe$2$1.INSTANCE, r210, r112, new ListMiddleware$subscribe$2$2(r213));
    L7:
        if (r214 == null) goto L9;
        selectSubscribe(r110, ListMiddleware$subscribe$3$1.INSTANCE, r210, r112, new ListMiddleware$subscribe$3$2(r214));
    L9:
        if (r211 == null) goto L11;
        asyncSubscribe(r110, ListMiddleware$subscribe$4$1.INSTANCE, r210, r112, new ListMiddleware$subscribe$4$2(r211), new ListMiddleware$subscribe$4$3(r211), new ListMiddleware$subscribe$4$4(r211));
    L11:
        if (r212 == null) goto L13;
        asyncSubscribe(r110, ListMiddleware$subscribe$5$1.INSTANCE, r210, r112, new ListMiddleware$subscribe$5$2(r212), new ListMiddleware$subscribe$5$3(r212), new ListMiddleware$subscribe$5$4(r212));
    L13:
        if (r111 == null) goto L16;
        selectSubscribe(r110, ListMiddleware$subscribe$6$1.INSTANCE, r210, r112, new ListMiddleware$subscribe$$inlined$also$lambda$1(r111, this, r110, r210, r112, r215));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void subscribe$default(ListMiddleware r110, ISubscriber r111, DiffableAdapter r112, boolean r113, boolean r114, ListListener r115, ListListener r116, Function2 r117, Function2 r118, Function1 r119, Function2 r210, int r211, Object r212) {
        Function2 r100 = null;
        if ((r211 & 2) == 0) goto L5;
        DiffableAdapter r101 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r211 & 8) == 0) goto L13;
        boolean r103 = r111.getUniqueOnlyGlobal();
    L15:
        if ((r211 & 16) == 0) goto L17;
        ListListener r104 = null;
    L19:
        if ((r211 & 32) == 0) goto L21;
        ListListener r105 = null;
    L23:
        if ((r211 & 64) == 0) goto L25;
        Function2 r106 = null;
    L27:
        if ((r211 & 128) == 0) goto L29;
        Function2 r107 = null;
    L31:
        if ((r211 & 256) == 0) goto L33;
        Function1 r108 = null;
    L35:
        if ((r211 & 512) != 0) goto L38;
        r100 = r210;
    L38:
        r110.subscribe(r111, r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r119;
        goto L35
    L29:
        r107 = r118;
        goto L31
    L25:
        r106 = r117;
        goto L27
    L21:
        r105 = r116;
        goto L23
    L17:
        r104 = r115;
        goto L19
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }
}
