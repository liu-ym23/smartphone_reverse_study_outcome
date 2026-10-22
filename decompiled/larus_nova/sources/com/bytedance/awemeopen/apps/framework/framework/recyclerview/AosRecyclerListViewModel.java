package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import h04.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\u001e\u0010\u001a\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001a\u00020\fH\u0004J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000eJ\u001e\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH&J\b\u0010!\u001a\u00020\u0005H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J$\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010$\u001a\u00020\u000eH&J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00028\u0000H&¢\u0006\u0004\b'\u0010(J\u0006\u0010)\u001a\u00020\u0005R&\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010/R)\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120+018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0006¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListViewModel;", ExifInterface.TAG_MODEL, "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "", "list", "", "success", "fail", "refreshing", "refreshSuccess", "refreshFail", "loadMoreFail", "", "hasMore", "", "dataSize", "tempData2ListForRefresh", "tempData2ListForLoadMore", "", "replacedList", "replaceListData", EventConstant.Value.RETRY, "clearData", "startLoad", "initialLoad", DitoNode.LOAD_MORE, "loadMoreSuccess", "position", "disLikeCurrent", "refresh", "Lh04/d;", "callback", "loadData", "initialShowSkeleton", "getMockList", "data", "startIndex", "filterData", "removeData", "onFeedRemoved", "(Ljava/lang/Object;)V", "startRefresh", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState;", "_dataList", "Landroidx/lifecycle/MutableLiveData;", "isRefreshingData", "Z", "isLoadingMoreData", "Landroidx/lifecycle/LiveData;", "dataList", "Landroidx/lifecycle/LiveData;", "getDataList", "()Landroidx/lifecycle/LiveData;", "refreshCallback", "Lh04/d;", "getRefreshCallback", "()Lh04/d;", "loadMoreCallback", "getLoadMoreCallback", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosRecyclerListViewModel<Model> extends AosViewModel {
    private final MutableLiveData<ListState<List<Model>>> _dataList;
    private final LiveData<ListState<List<Model>>> dataList;
    private boolean isLoadingMoreData;
    private boolean isRefreshingData;
    private final d<Model> loadMoreCallback;
    private final d<Model> refreshCallback;

    public static final class a implements d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosRecyclerListViewModel<Model> f197016a;

        @Override // h04.d
        public final void onFail() {
            AosRecyclerListViewModel.access$setLoadingMoreData$p(this.f197016a, false);
            AosRecyclerListViewModel.access$loadMoreFail(this.f197016a);
        }

        public a(AosRecyclerListViewModel<Model> r100) {
            this.f197016a = r100;
        }

        @Override // h04.d
        public final void onSuccess(List<? extends Model> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            AosRecyclerListViewModel.access$setLoadingMoreData$p(this.f197016a, false);
            this.f197016a.loadMoreSuccess(r100, r101);
        }
    }

    public static final class b implements d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosRecyclerListViewModel<Model> f197017a;

        @Override // h04.d
        public final void onFail() {
            AosRecyclerListViewModel.access$setRefreshingData$p(this.f197017a, false);
            ListState<List<Model>> r100 = this.f197017a.getDataList().getValue();
            if (r100 == null) goto L5;
            ListState.State r101 = r100.f196929c;
        L7:
            if (r101 != ListState.State.INITIAL_LOAD) goto L10;
            AosRecyclerListViewModel.access$fail(this.f197017a);
            return;
        L10:
            if (r101 != ListState.State.START_REFRESH) goto L14;
            AosRecyclerListViewModel.access$refreshFail(this.f197017a);
            return;
        L14:
            return;
        L5:
            r101 = null;
            goto L7
        }

        public b(AosRecyclerListViewModel<Model> r100) {
            this.f197017a = r100;
        }

        @Override // h04.d
        public final void onSuccess(List<? extends Model> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            AosRecyclerListViewModel.access$setRefreshingData$p(this.f197017a, false);
            ListState<List<Model>> r102 = this.f197017a.getDataList().getValue();
            if (r102 == null) goto L5;
            ListState.State r103 = r102.f196929c;
        L6:
            ListState<List<Model>> r104 = this.f197017a.getDataList().getValue();
            if (r104 == null) goto L11;
            r104.f196933g = r101;
        L11:
            if (r103 != ListState.State.INITIAL_LOAD) goto L13;
            AosRecyclerListViewModel.access$success(this.f197017a, r100);
            return;
        L13:
            AosRecyclerListViewModel.access$refreshSuccess(this.f197017a, r100);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public abstract List<Model> filterData(List<? extends Model> r100, int r101);

    public abstract void loadData(boolean r100, d<Model> r101);

    public abstract void onFeedRemoved(Model r100);

    private final void fail() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.INITIAL_FAIL);
        this._dataList.setValue(r100);
    }

    private final boolean hasMore() {
        ListState<List<Model>> r100 = this.dataList.getValue();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f196933g != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final void loadMoreFail() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.LOAD_MORE_FAIL);
        this._dataList.setValue(r100);
    }

    private final void refreshFail() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.REFRESH_FAIL);
        this._dataList.setValue(r100);
    }

    private final void refreshing() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.START_REFRESH);
        this._dataList.setValue(r100);
    }

    public final void clearData() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ListState.State r101 = r100.f196929c;
        ListState.State r102 = ListState.State.CLEAR_DATA;
        if (r101 != r102) goto L8;
        return;
    L8:
        r100.a(r102);
        r100.f196927a.clear();
        r100.f196931e = 0;
        r100.f196930d = 0;
        r100.f196933g = false;
        this._dataList.setValue(r100);
    }

    public final int dataSize() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.f196927a.size();
    }

    public final void initialLoad() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.INITIAL_LOAD);
        this._dataList.setValue(r100);
    }

    public void initialShowSkeleton() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f196927a.addAll(getMockList());
        this._dataList.setValue(r100);
    }

    public final void loadMore() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L6;
        return;
    L6:
        if (hasMore() == true) goto L8;
        return;
    L8:
        ListState.State r101 = r100.f196929c;
        ListState.State r102 = ListState.State.START_LOAD_MORE;
        if (r101 != r102) goto L12;
        return;
    L12:
        if (this.isLoadingMoreData == false) goto L14;
        return;
    L14:
        this.isLoadingMoreData = true;
        r100.a(r102);
        this._dataList.setValue(r100);
    }

    public final void retry() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.NEW);
        this._dataList.setValue(r100);
    }

    public final void startLoad() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.NEW);
        this._dataList.setValue(r100);
    }

    public final void startRefresh() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.isRefreshingData == false) goto L8;
        return;
    L8:
        this.isRefreshingData = true;
        r100.a(ListState.State.START_REFRESH);
        this._dataList.setValue(r100);
    }

    public final void tempData2ListForLoadMore() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        List<Model> r102 = filterData(r101, r100.f196927a.size());
        r100.f196930d = r100.f196927a.size();
        r100.f196931e = r102.size();
        r100.f196927a.addAll(r102);
    }

    public final void tempData2ListForRefresh() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f196927a.clear();
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        r100.f196927a.addAll(filterData(r101, 0));
    }

    public AosRecyclerListViewModel() {
        MutableLiveData<ListState<List<Model>>> r100 = new MutableLiveData();
        r100.setValue(new ListState(new ArrayList(), new ArrayList()));
        this._dataList = r100;
        this.dataList = r100;
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

    public static final /* synthetic */ void access$fail(AosRecyclerListViewModel r100) {
        r100.fail();
    }

    public static final /* synthetic */ void access$loadMoreFail(AosRecyclerListViewModel r100) {
        r100.loadMoreFail();
    }

    public static final /* synthetic */ void access$refreshFail(AosRecyclerListViewModel r100) {
        r100.refreshFail();
    }

    private final void refreshSuccess(List<? extends Model> r100) {
        ListState<List<Model>> r101 = this._dataList.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(ListState.State.REFRESH_SUCCESS);
        r101.f196928b.clear();
        r101.f196928b.addAll(r100);
        this._dataList.setValue(r101);
    }

    private final void success(List<? extends Model> r100) {
        ListState<List<Model>> r101 = this._dataList.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(ListState.State.INITIAL_SUCCESS);
        r101.f196928b.clear();
        r101.f196928b.addAll(r100);
        this._dataList.setValue(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.util.List] */
    public final void disLikeCurrent(int r100) {
        ListState<List<Model>> r101 = this._dataList.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(ListState.State.DISLIKE_CURRENT);
        onFeedRemoved(ListProtector.remove(r101.f196927a, r100));
        r101.f196927a = filterData(r101.f196927a, 0);
        this._dataList.setValue(r101);
    }

    public final void replaceListData(List<Model> r100) {
        Intrinsics.checkNotNullParameter(r100, "replacedList");
        ListState<List<Model>> r101 = this._dataList.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f196927a.clear();
        ArrayList r102 = new ArrayList();
        r102.addAll(r100);
        r100.clear();
        r101.f196927a.addAll(filterData(r102, 0));
    }

    public static final /* synthetic */ void access$refreshSuccess(AosRecyclerListViewModel r100, List r101) {
        r100.refreshSuccess(r101);
    }

    public static final /* synthetic */ void access$setLoadingMoreData$p(AosRecyclerListViewModel r100, boolean r101) {
        r100.isLoadingMoreData = r101;
    }

    public static final /* synthetic */ void access$setRefreshingData$p(AosRecyclerListViewModel r100, boolean r101) {
        r100.isRefreshingData = r101;
    }

    public static final /* synthetic */ void access$success(AosRecyclerListViewModel r100, List r101) {
        r100.success(r101);
    }

    public final void loadMoreSuccess(List<? extends Model> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ListState<List<Model>> r102 = this._dataList.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.a(ListState.State.LOAD_MORE_SUCCESS);
        r102.f196933g = r101;
        r102.f196928b.addAll(r100);
        this._dataList.setValue(r102);
    }
}
