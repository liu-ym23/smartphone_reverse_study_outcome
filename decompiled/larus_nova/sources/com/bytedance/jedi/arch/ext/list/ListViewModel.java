package com.bytedance.jedi.arch.ext.list;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.NestedState;
import com.bytedance.jedi.arch.ext.list.IListState;
import com.bytedance.jedi.arch.ext.list.Payload;
import com.bytedance.jedi.arch.ext.list.differ.JediListPrefetcher;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0019\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u0003*\u0014\b\u0002\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00040\u00062\u00020\u0007B\u0005¢\u0006\u0002\u0010\bJ\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001b\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\rJæ\u0001\u0010'\u001a\u00020\u001d\"\b\b\u0003\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H(\u0018\u00010/2\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H(\u0018\u00010/2!\b\u0002\u00101\u001a\u001b\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013¢\u0006\u0002\b32!\b\u0002\u00104\u001a\u001b\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013¢\u0006\u0002\b32\u001b\b\u0002\u00105\u001a\u0015\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\u001d\u0018\u00010\n¢\u0006\u0002\b32!\b\u0002\u00106\u001a\u001b\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0013¢\u0006\u0002\b3J\u0006\u00107\u001a\u00020\u001dJn\u00108\u001a\u00020\u001d26\b\u0002\u0010\u0012\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u00142,\u00109\u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f0\u000b0\nH\u0004Jn\u0010:\u001a\u00020\u001d26\b\u0002\u0010\u001a\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u00142,\u0010;\u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f0\u000b0\nH\u0004J\u001b\u0010<\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0002\u0010%J'\u0010<\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\b3J/\u0010>\u001a\u00020\u001d2'\u0010?\u001a#\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0013J'\u0010C\u001a\u00020\u001d2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002020\n2\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0002\u0010EJ3\u0010C\u001a\u00020\u001d2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002020\n2\u0017\u0010=\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\b3J \u0010F\u001a\u00020\u001d2\u0018\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00028\u00000\f0\rJ\u0006\u0010H\u001a\u00020\u001dJ\u000e\u0010I\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001fJ\u001a\u0010J\u001a\u00020\u001d2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002020\nJ\u001a\u0010K\u001a\u00020\u001d2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002020\nJ\u0016\u0010L\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001fJ\u000e\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001fJ\u0014\u0010P\u001a\u00020\u001d2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ+\u0010P\u001a\u00020\u001d2#\u0010=\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\n¢\u0006\u0002\b3J0\u0010R\u001a\u00020\u001d2%\b\u0004\u0010=\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\n¢\u0006\u0002\b3H\u0082\bJ&\u0010S\u001a\u00020T*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010U2\f\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002R<\u0010\t\u001a*\u0012\u0004\u0012\u00028\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f0\u000b\u0018\u00010\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR8\u0010\u0010\u001a(\u0012\u0004\u0012\u00028\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f0\u000b0\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fRB\u0010\u0012\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u0014X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u001a\u001a0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0013j\b\u0012\u0004\u0012\u00028\u0000`\u0014X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u0006W"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/ListViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "P", "Lcom/bytedance/jedi/arch/ext/list/Payload;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/ext/list/IListState;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "()V", "actualLoadMore", "Lkotlin/Function1;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "getActualLoadMore", "()Lkotlin/jvm/functions/Function1;", "actualRefresh", "getActualRefresh", "loadMoreStrategy", "Lkotlin/Function2;", "Lcom/bytedance/jedi/arch/ext/list/LoadStrategy;", "getLoadMoreStrategy", "()Lkotlin/jvm/functions/Function2;", "prefetcher", "Lkotlin/Lazy;", "com/bytedance/jedi/arch/ext/list/ListViewModel$prefetcher$1$1", "refreshStrategy", "getRefreshStrategy", "doOnLoadNextResult", "", "loadedSize", "", "error", "", "insert", "position", "data", "(ILjava/lang/Object;)V", "insertMultiple", "listSubscribe", "RECEIVER", "Lcom/bytedance/jedi/arch/IReceiver;", "subscriber", "Lcom/bytedance/jedi/arch/ISubscriber;", "adapter", "Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", "refreshListener", "Lcom/bytedance/jedi/arch/ext/list/ListListener;", "loadMoreListener", "onHasMore", "", "Lkotlin/ExtensionFunctionType;", "onEmpty", "onSubmitFinish", "onPayloadChange", DitoNode.LOAD_MORE, "manualLoadMore", "loadMoreCall", "manualRefresh", "refreshCall", PriorityModule.OPERATOR_MODIFY, "reducer", "modifyAll", "mapper", "Lkotlin/ParameterName;", "name", "index", "modifyFirst", "predicate", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "modifyMultiple", "pairs", "refresh", "remove", "removeAll", "removeFirst", "removeMultiple", "count", "tryPrefetch", "indexToPrefetch", "updateList", "list", "updateListInternal", "createEmpty", "Lcom/bytedance/jedi/arch/ext/list/DistinctBoolean;", "Lcom/bytedance/jedi/arch/ext/list/ListState;", "newList", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public abstract class ListViewModel<T, P extends Payload, S extends IListState<T, P>> extends JediViewModel<S> implements JediListPrefetcher.Fetcher {
    private final Function1<S, Observable<Pair<List<T>, P>>> actualLoadMore;
    private final Function2<List<? extends T>, List<? extends T>, List<T>> loadMoreStrategy;
    private final Lazy<ListViewModel$prefetcher$1.AnonymousClass1> prefetcher;
    private final Function2<List<? extends T>, List<? extends T>, List<T>> refreshStrategy;

    /* JADX INFO: renamed from: com.bytedance.jedi.arch.ext.list.ListViewModel$updateListInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\u0014\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005*\u0002H\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "P", "Lcom/bytedance/jedi/arch/ext/list/Payload;", "Lcom/bytedance/jedi/arch/ext/list/IListState;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/arch/ext/list/IListState;)Lcom/bytedance/jedi/arch/ext/list/IListState;"}, k = 3, mv = {1, 1, 16})
    public static final class C106161 extends Lambda implements Function1<S, S> {
        final /* synthetic */ Function1 $reducer;
        final /* synthetic */ ListViewModel this$0;

        public C106161(ListViewModel r100, Function1 r101) {
            this.this$0 = r100;
            this.$reducer = r101;
            super(1);
        }

        public final S invoke(S r110) {
            List r100 = (List) this.$reducer.invoke(((ListState) r110.getSubstate()).getList());
            NestedState r111 = r110.newSubstate(ListState.copy$default((ListState) r110.getSubstate(), null, r100, null, null, ListViewModel.access$createEmpty(this.this$0, (ListState) r110.getSubstate(), r100), 13, null));
            if (r111 == null) goto L7;
            return (S) r111;
        L7:
            throw new TypeCastException("null cannot be cast to non-null type S");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r100) {
            return invoke((IListState) r100);
        }
    }

    public abstract Function1<S, Observable<Pair<List<T>, P>>> getActualRefresh();

    public ListViewModel() {
        this.refreshStrategy = LoadStrategyKt.Replace();
        this.loadMoreStrategy = LoadStrategyKt.Append();
        this.prefetcher = LazyKt.lazy(new ListViewModel$prefetcher$1(this));
    }

    public final void loadMore() {
        Function1<S, Observable<Pair<List<T>, P>>> r100 = getActualLoadMore();
        if (r100 == null) goto L6;
        manualLoadMore(getLoadMoreStrategy(), r100);
        return;
    }

    public final void refresh() {
        manualRefresh(getRefreshStrategy(), getActualRefresh());
    }

    public Function1<S, Observable<Pair<List<T>, P>>> getActualLoadMore() {
        return this.actualLoadMore;
    }

    public Function2<List<? extends T>, List<? extends T>, List<T>> getLoadMoreStrategy() {
        return this.loadMoreStrategy;
    }

    public Function2<List<? extends T>, List<? extends T>, List<T>> getRefreshStrategy() {
        return this.refreshStrategy;
    }

    private final void updateListInternal(Function1<? super List<? extends T>, ? extends List<? extends T>> r100) {
        access$setState(this, new C106161(this, r100));
    }

    public final void modifyAll(final Function2<? super Integer, ? super T, ? extends T> r100) {
        access$setState(this, new ListViewModel$modifyAll$$inlined$updateListInternal$1(this, r100));
    }

    public final void modifyMultiple(final List<? extends Pair<Integer, ? extends T>> r100) {
        access$setState(this, new ListViewModel$modifyMultiple$$inlined$updateListInternal$1(this, r100));
    }

    public final void remove(final int r100) {
        access$setState(this, new ListViewModel$remove$$inlined$updateListInternal$1(this, r100));
    }

    public final void removeAll(final Function1<? super T, Boolean> r100) {
        access$setState(this, new ListViewModel$removeAll$$inlined$updateListInternal$1(this, r100));
    }

    public final void removeFirst(final Function1<? super T, Boolean> r100) {
        withState(new C106151(this, r100));
    }

    @Override // com.bytedance.jedi.arch.ext.list.differ.JediListPrefetcher.Fetcher
    public final void tryPrefetch(int r100) {
        this.prefetcher.getValue().tryPrefetch(r100);
    }

    public final void updateList(final List<? extends T> r100) {
        access$setState(this, new ListViewModel$updateList$$inlined$updateListInternal$1(this, r100));
    }

    public final void updateList(Function1<? super List<? extends T>, ? extends List<? extends T>> r100) {
        access$setState(this, new C106161(this, r100));
    }

    public static final /* synthetic */ void access$setState(ListViewModel r100, Function1 r101) {
        r100.setState(r101);
    }

    public static final /* synthetic */ void access$withState(ListViewModel r100, Function1 r101) {
        r100.withState(r101);
    }

    private final DistinctBoolean createEmpty(ListState<T, P> r100, List<? extends T> r101) {
        boolean r102 = r101.isEmpty();
        if (r102 != r100.isEmpty().getValue()) goto L6;
        return r100.isEmpty();
    L6:
        return new DistinctBoolean(r102);
    }

    private final void doOnLoadNextResult(int r100, Throwable r101) {
        Lazy<ListViewModel$prefetcher$1.AnonymousClass1> r102 = this.prefetcher;
        if (r102.isInitialized() == false) goto L6;
        r102.getValue().onLoaded(r100, r101);
        return;
    }

    public final void insert(final int r100, final T r101) {
        access$setState(this, new ListViewModel$insert$$inlined$updateListInternal$1(this, r100, r101));
    }

    public final void insertMultiple(final int r100, final List<? extends T> r101) {
        access$setState(this, new ListViewModel$insertMultiple$$inlined$updateListInternal$1(this, r100, r101));
    }

    public final void manualLoadMore(final Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r100, final Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101) {
        withState(new AnonymousClass1(this, r101, r100));
    }

    public final void manualRefresh(final Function2<? super List<? extends T>, ? super List<? extends T>, ? extends List<? extends T>> r100, final Function1<? super S, ? extends Observable<Pair<List<T>, P>>> r101) {
        withState(new C106131(this, r101, r100));
    }

    public final void modify(final int r100, final T r101) {
        access$setState(this, new ListViewModel$modify$$inlined$updateListInternal$1(this, r100, r101));
    }

    public final void modifyFirst(final Function1<? super T, Boolean> r100, final T r101) {
        withState(new C106141(this, r100, r101));
    }

    public final void removeMultiple(final int r100, final int r101) {
        access$setState(this, new ListViewModel$removeMultiple$$inlined$updateListInternal$1(this, r101, r100));
    }

    public final void modify(final int r100, final Function1<? super T, ? extends T> r101) {
        access$setState(this, new ListViewModel$modify$$inlined$updateListInternal$2(this, r100, r101));
    }

    public final void modifyFirst(final Function1<? super T, Boolean> r100, final Function1<? super T, ? extends T> r101) {
        withState(new AnonymousClass2(this, r100, r101));
    }

    public static final /* synthetic */ DistinctBoolean access$createEmpty(ListViewModel r100, ListState r101, List r102) {
        return r100.createEmpty(r101, r102);
    }

    public static final /* synthetic */ void access$doOnLoadNextResult(ListViewModel r100, int r101, Throwable r102) {
        r100.doOnLoadNextResult(r101, r102);
    }

    public static final /* synthetic */ Disposable access$execute(ListViewModel r100, Observable r101, Function2 r102) {
        return r100.execute(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void manualLoadMore$default(ListViewModel r100, Function2 r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.getLoadMoreStrategy();
    L6:
        r100.manualLoadMore(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: manualLoadMore");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void manualRefresh$default(ListViewModel r100, Function2 r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.getRefreshStrategy();
    L6:
        r100.manualRefresh(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: manualRefresh");
    }

    public final <RECEIVER extends IReceiver> void listSubscribe(ISubscriber<? extends RECEIVER> r110, DiffableAdapter<T> r111, ListListener<T, RECEIVER> r112, ListListener<T, RECEIVER> r113, Function2<? super RECEIVER, ? super Boolean, Unit> r114, Function2<? super RECEIVER, ? super Boolean, Unit> r115, Function1<? super RECEIVER, Unit> r116, Function2<? super RECEIVER, ? super P, Unit> r117) {
        ListViewModelKt.access$doListSubscribe(r110, this, r111, r112, r113, r114, r115, r116, r117);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void listSubscribe$default(ListViewModel r100, ISubscriber r101, DiffableAdapter r110, ListListener r111, ListListener r112, Function2 r113, Function2 r114, Function1 r115, Function2 r116, int r117, Object r118) {
        if (r118 != null) goto L35;
        Function2 r102 = null;
        if ((r117 & 2) == 0) goto L7;
        DiffableAdapter r103 = null;
    L9:
        if ((r117 & 4) == 0) goto L11;
        ListListener r104 = null;
    L13:
        if ((r117 & 8) == 0) goto L15;
        ListListener r105 = null;
    L17:
        if ((r117 & 16) == 0) goto L19;
        Function2 r106 = null;
    L21:
        if ((r117 & 32) == 0) goto L23;
        Function2 r107 = null;
    L25:
        if ((r117 & 64) == 0) goto L27;
        Function1 r108 = null;
    L29:
        if ((r117 & 128) != 0) goto L32;
        r102 = r116;
    L32:
        r100.listSubscribe(r101, r103, r104, r105, r106, r107, r108, r102);
        return;
    L27:
        r108 = r115;
        goto L29
    L23:
        r107 = r114;
        goto L25
    L19:
        r106 = r113;
        goto L21
    L15:
        r105 = r112;
        goto L17
    L11:
        r104 = r111;
        goto L13
    L7:
        r103 = r110;
        goto L9
    L35:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listSubscribe");
    }
}
