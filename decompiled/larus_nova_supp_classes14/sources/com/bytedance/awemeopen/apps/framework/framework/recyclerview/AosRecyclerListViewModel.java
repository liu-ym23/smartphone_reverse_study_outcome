package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import h04.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u001e\u0010\u001a\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001a\u00020\fH\u0004J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000eJ\u001e\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH&J\b\u0010!\u001a\u00020\u0005H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J$\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010$\u001a\u00020\u000eH&J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00028\u0000H&¢\u0006\u0004\b'\u0010(J\u0006\u0010)\u001a\u00020\u0005R&\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010/R)\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120+018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0006¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListViewModel;", "Model", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "", "list", "", "success", "fail", "refreshing", "refreshSuccess", "refreshFail", "loadMoreFail", "", "hasMore", "", "dataSize", "tempData2ListForRefresh", "tempData2ListForLoadMore", "", "replacedList", "replaceListData", "retry", "clearData", "startLoad", "initialLoad", "loadMore", "loadMoreSuccess", "position", "disLikeCurrent", "refresh", "Lh04/d;", "callback", "loadData", "initialShowSkeleton", "getMockList", "data", "startIndex", "filterData", "removeData", "onFeedRemoved", "(Ljava/lang/Object;)V", "startRefresh", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState;", "_dataList", "Landroidx/lifecycle/MutableLiveData;", "isRefreshingData", "Z", "isLoadingMoreData", "Landroidx/lifecycle/LiveData;", "dataList", "Landroidx/lifecycle/LiveData;", "getDataList", "()Landroidx/lifecycle/LiveData;", "refreshCallback", "Lh04/d;", "getRefreshCallback", "()Lh04/d;", "loadMoreCallback", "getLoadMoreCallback", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosRecyclerListViewModel<Model> extends AosViewModel {
    private final MutableLiveData<ListState<List<Model>>> _dataList;
    private final LiveData<ListState<List<Model>>> dataList;
    private boolean isLoadingMoreData;
    private boolean isRefreshingData;
    private final d<Model> loadMoreCallback;
    private final d<Model> refreshCallback;

    public static final class a implements d<Model> {
        public final /* synthetic */ AosRecyclerListViewModel<Model> a;

        @Override // h04.d
        public final void onFail() {
            AosRecyclerListViewModel.access$setLoadingMoreData$p(this.a, false);
            AosRecyclerListViewModel.access$loadMoreFail(this.a);
        }

        public a(AosRecyclerListViewModel<Model> r1) {
            this.a = r1;
        }

        @Override // h04.d
        public final void onSuccess(List<? extends Model> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "data");
            AosRecyclerListViewModel.access$setLoadingMoreData$p(this.a, false);
            this.a.loadMoreSuccess(r3, r4);
        }
    }

    public static final class b implements d<Model> {
        public final /* synthetic */ AosRecyclerListViewModel<Model> a;

        @Override // h04.d
        public final void onFail() {
            AosRecyclerListViewModel.access$setRefreshingData$p(this.a, false);
            ListState r0 = (ListState) this.a.getDataList().getValue();
            if (r0 == null) goto L5;
            ListState.State r1 = r0.c;
        L7:
            if (r1 != ListState.State.INITIAL_LOAD) goto L10;
            AosRecyclerListViewModel.access$fail(this.a);
            return;
        L10:
            if (r1 != ListState.State.START_REFRESH) goto L14;
            AosRecyclerListViewModel.access$refreshFail(this.a);
            return;
        L14:
            return;
        L5:
            r1 = null;
            goto L7
        }

        public b(AosRecyclerListViewModel<Model> r1) {
            this.a = r1;
        }

        @Override // h04.d
        public final void onSuccess(List<? extends Model> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "data");
            AosRecyclerListViewModel.access$setRefreshingData$p(this.a, false);
            ListState r0 = (ListState) this.a.getDataList().getValue();
            if (r0 == null) goto L5;
            ListState.State r1 = r0.c;
        L6:
            ListState r2 = (ListState) this.a.getDataList().getValue();
            if (r2 == null) goto L11;
            r2.g = r4;
        L11:
            if (r1 != ListState.State.INITIAL_LOAD) goto L13;
            AosRecyclerListViewModel.access$success(this.a, r3);
            return;
        L13:
            AosRecyclerListViewModel.access$refreshSuccess(this.a, r3);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public abstract List<Model> filterData(List<? extends Model> r1, int r2);

    public abstract void loadData(boolean r1, d<Model> r2);

    public abstract void onFeedRemoved(Model r1);

    private final void fail() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.INITIAL_FAIL);
        this._dataList.setValue(r0);
    }

    private final boolean hasMore() {
        ListState r0 = (ListState) this.dataList.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.g != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void loadMoreFail() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.LOAD_MORE_FAIL);
        this._dataList.setValue(r0);
    }

    private final void refreshFail() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.REFRESH_FAIL);
        this._dataList.setValue(r0);
    }

    private final void refreshing() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.START_REFRESH);
        this._dataList.setValue(r0);
    }

    public final void clearData() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ListState.State r1 = r0.c;
        ListState.State r2 = ListState.State.CLEAR_DATA;
        if (r1 != r2) goto L8;
        return;
    L8:
        r0.a(r2);
        ((List) r0.a).clear();
        r0.e = 0;
        r0.d = 0;
        r0.g = false;
        this._dataList.setValue(r0);
    }

    public final int dataSize() {
        Object r0 = this._dataList.getValue();
        Intrinsics.checkNotNull(r0);
        return ((List) ((ListState) r0).a).size();
    }

    public final void initialLoad() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.INITIAL_LOAD);
        this._dataList.setValue(r0);
    }

    public void initialShowSkeleton() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ((List) r0.a).addAll(getMockList());
        this._dataList.setValue(r0);
    }

    public final void loadMore() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (hasMore() == true) goto L8;
        return;
    L8:
        ListState.State r1 = r0.c;
        ListState.State r2 = ListState.State.START_LOAD_MORE;
        if (r1 != r2) goto L12;
        return;
    L12:
        if (this.isLoadingMoreData == false) goto L14;
        return;
    L14:
        this.isLoadingMoreData = true;
        r0.a(r2);
        this._dataList.setValue(r0);
    }

    public final void retry() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.NEW);
        this._dataList.setValue(r0);
    }

    public final void startLoad() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.NEW);
        this._dataList.setValue(r0);
    }

    public final void startRefresh() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.isRefreshingData == false) goto L8;
        return;
    L8:
        this.isRefreshingData = true;
        r0.a(ListState.State.START_REFRESH);
        this._dataList.setValue(r0);
    }

    public final void tempData2ListForLoadMore() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        r1.addAll((Collection) r0.b);
        ((List) r0.b).clear();
        List<Model> r2 = filterData(r1, ((List) r0.a).size());
        r0.d = ((List) r0.a).size();
        r0.e = r2.size();
        ((List) r0.a).addAll(r2);
    }

    public final void tempData2ListForRefresh() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ((List) r0.a).clear();
        ArrayList r1 = new ArrayList();
        r1.addAll((Collection) r0.b);
        ((List) r0.b).clear();
        ((List) r0.a).addAll(filterData(r1, 0));
    }

    public AosRecyclerListViewModel() {
        MutableLiveData<ListState<List<Model>>> r0 = new MutableLiveData();
        r0.setValue(new ListState(new ArrayList(), new ArrayList()));
        this._dataList = r0;
        this.dataList = r0;
        this.refreshCallback = new b(this);
        this.loadMoreCallback = new a(this);
    }

    public List<Model> getMockList() {
        return CollectionsKt.emptyList();
    }

    public final LiveData<ListState<List<Model>>> getDataList() {
        return this.dataList;
    }

    public final d<Model> getLoadMoreCallback() {
        return this.loadMoreCallback;
    }

    public final d<Model> getRefreshCallback() {
        return this.refreshCallback;
    }

    public static final /* synthetic */ void access$fail(AosRecyclerListViewModel r0) {
        r0.fail();
    }

    public static final /* synthetic */ void access$loadMoreFail(AosRecyclerListViewModel r0) {
        r0.loadMoreFail();
    }

    public static final /* synthetic */ void access$refreshFail(AosRecyclerListViewModel r0) {
        r0.refreshFail();
    }

    private final void refreshSuccess(List<? extends Model> r3) {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.REFRESH_SUCCESS);
        ((List) r0.b).clear();
        ((List) r0.b).addAll(r3);
        this._dataList.setValue(r0);
    }

    private final void success(List<? extends Model> r3) {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.INITIAL_SUCCESS);
        ((List) r0.b).clear();
        ((List) r0.b).addAll(r3);
        this._dataList.setValue(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.util.List] */
    public final void disLikeCurrent(int r3) {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.DISLIKE_CURRENT);
        onFeedRemoved(ListProtector.remove((List) r0.a, r3));
        r0.a = filterData((List) r0.a, 0);
        this._dataList.setValue(r0);
    }

    public final void replaceListData(List<Model> r4) {
        Intrinsics.checkNotNullParameter(r4, "replacedList");
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ((List) r0.a).clear();
        ArrayList r1 = new ArrayList();
        r1.addAll(r4);
        r4.clear();
        ((List) r0.a).addAll(filterData(r1, 0));
    }

    public static final /* synthetic */ void access$refreshSuccess(AosRecyclerListViewModel r0, List r1) {
        r0.refreshSuccess(r1);
    }

    public static final /* synthetic */ void access$setLoadingMoreData$p(AosRecyclerListViewModel r0, boolean r1) {
        r0.isLoadingMoreData = r1;
    }

    public static final /* synthetic */ void access$setRefreshingData$p(AosRecyclerListViewModel r0, boolean r1) {
        r0.isRefreshingData = r1;
    }

    public static final /* synthetic */ void access$success(AosRecyclerListViewModel r0, List r1) {
        r0.success(r1);
    }

    public final void loadMoreSuccess(List<? extends Model> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "list");
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.LOAD_MORE_SUCCESS);
        r0.g = r4;
        ((List) r0.b).addAll(r3);
        this._dataList.setValue(r0);
    }
}
