package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.livedata.CallbackAfterChangedLiveData;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.launchconfig.LaunchConfigManager$checkLaunchConfig$1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0003rux\b&\u0018\u0000 \u0092\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0093\u0001B\t¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u001e\u0010\u000f\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J*\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J*\u0010\u001f\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0003J\u001c\u0010(\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0003J$\u00100\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\rH\u0016J\u0006\u00101\u001a\u00020\u0011J\u0006\u00102\u001a\u00020\u0011J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\rJ\u0006\u00104\u001a\u00020\u0011J\b\u00105\u001a\u00020\u0011H\u0016J\u0006\u00107\u001a\u000206J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020:H&J\u001e\u0010?\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<2\u0006\u0010>\u001a\u00020\rH&J\u0016\u0010A\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000@H&J\u0016\u0010C\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000BH&J$\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010E\u001a\u00020\rH\u0016J2\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010H\u001a\u00020\u0011H&J$\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010H\u001a\u00020\u0011H&J,\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&JL\u0010T\u001a\u00020\u00032\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QJ\u001c\u0010U\u001a\u00020\u00032\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010H\u001a\u00020\u0011J(\u0010V\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00112\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QH\u0016R\"\u0010W\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110]8\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR&\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a0b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR)\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a0e8\u0006¢\u0006\f\n\u0004\bM\u0010f\u001a\u0004\bg\u0010hR\"\u0010i\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010XR\u0016\u0010p\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010XR\u0016\u0010q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010XR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00000x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000B8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R \u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110e8\u0006¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010f\u001a\u0005\b\u0084\u0001\u0010hR \u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110e8\u0006¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010f\u001a\u0005\b\u0086\u0001\u0010hR\u0019\u0010\u0087\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u0010\u0089\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0088\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R&\u0010\u008e\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010X\u001a\u0005\b\u008e\u0001\u0010Z\"\u0005\b\u008f\u0001\u0010\\¨\u0006\u0094\u0001"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", "Model", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "", "requestLaunchConfigSuccess", "requestLaunchConfigFail", "startInitLoad", "", "list", "initLoadSuccess", "initLoadFail", "refreshSuccess", "refreshFail", "", "hasMore", "loadMoreSuccess", "loadMoreFail", "", "index", "preloadLoadMore", "preloadLoadForward", "hasForward", "shouldPreLoad", "dataSize", "tempData2ListForRefresh", "tempData2ListForLoadMore", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState;", "", "listState", "newData", "onBeforeFilterData", "onBeforeTempData2List", "tempData2ListForLocateTargetIndex", "tempData2ListForSegmentUpdate", "tempData2ListForLoadForward", "removeDataAfterIndex", "retry", "startRequestInitConfig", "startRefresh", "loadForward", "loadForwardSuccess", "loadForwardFail", "isPreloadLoadMore", "startLoadMore", "disLikeCurrent", "discardAfterCurrent", "forceUpdate", "ignorePreload", "updateCurrentIndex", "getLastSelectedIndex", "getCurrentSelectedIndex", "updatePalpableIndex", "getCurrentIndex", "getNextEpisodeIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState$State;", "getCurrentState", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/j;", "getHostCoverParams", "", "sceneId", "Lh04/e;", "callback", "isFirst", "refreshData", "Lh04/d;", "loadMoreData", "Lh04/c;", "loadForwardData", "data", "isRefresh", "insertHostAddIfNeed", "oldData", "startIndex", "filterRefreshData", "filterMoreData", "forwardData", "filterForwardData", "dataList", "targetIndex", "currentForwardPage", "currentLoadMorePage", "", "firstSeriesId", "lastSeriesId", "updateDataList", "updateTargetSegment", "updateCurrentPage", "shouldOpenPreLoad", "Z", "getShouldOpenPreLoad", "()Z", "setShouldOpenPreLoad", "(Z)V", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "commentShowLiveData", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "getCommentShowLiveData", "()Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_dataList", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "getDataList", "()Landroidx/lifecycle/LiveData;", "apiType", "Ljava/lang/String;", "getApiType", "()Ljava/lang/String;", "setApiType", "(Ljava/lang/String;)V", "isRefreshingData", "isLoadingMoreData", "isLoadingForwardData", "com/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$e", "refreshCallback", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$e;", "com/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$d", "loadMoreCallback", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$d;", "com/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$b", "launchConfigCallback", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$b;", "loadForwardCallback", "Lh04/c;", "getLoadForwardCallback", "()Lh04/c;", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/CallbackAfterChangedLiveData;", "_selectedIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/CallbackAfterChangedLiveData;", "_palpableIndex", "selectedIndex", "getSelectedIndex", "palpableIndex", "getPalpableIndex", "lastSelectedIndex", "I", "noActionAccount", "getNoActionAccount", "()I", "setNoActionAccount", "(I)V", "isNoAction", "setNoAction", "<init>", "()V", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosPagerListViewModel<Model> extends AosViewModel {
    public static final String API_TYPE_FEED = "feed";
    public static final String API_TYPE_SPECIFIED = "specified";
    public static final a Companion = null;
    public static final int NONE_INDEX = -1;
    private final MutableLiveData<ListState<List<Model>>> _dataList;
    private final CallbackAfterChangedLiveData<Integer> _palpableIndex;
    private final CallbackAfterChangedLiveData<Integer> _selectedIndex;
    private String apiType;
    private final DiscardFirstValueLiveData<Integer> commentShowLiveData;
    private final LiveData<ListState<List<Model>>> dataList;
    private boolean isLoadingForwardData;
    private boolean isLoadingMoreData;
    private boolean isNoAction;
    private boolean isRefreshingData;
    private int lastSelectedIndex;
    private final b launchConfigCallback;
    private final h04.c<Model> loadForwardCallback;
    private final d loadMoreCallback;
    private int noActionAccount;
    private final LiveData<Integer> palpableIndex;
    private final e refreshCallback;
    private final LiveData<Integer> selectedIndex;
    private boolean shouldOpenPreLoad;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC0100a {
        public final /* synthetic */ AosPagerListViewModel<Model> a;

        @Override // com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC0100a
        public final void a() {
            AosPagerListViewModel.access$requestLaunchConfigFail(this.a);
        }

        @Override // com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC0100a
        public final void b() {
            AosPagerListViewModel.access$requestLaunchConfigSuccess(this.a);
        }

        public b(AosPagerListViewModel<Model> r1) {
            this.a = r1;
        }
    }

    public static final class c implements h04.c<Model> {
        public final /* synthetic */ AosPagerListViewModel<Model> a;

        @Override // h04.c
        public final void onFail() {
            AosPagerListViewModel.access$setLoadingForwardData$p(this.a, false);
            this.a.loadForwardFail();
        }

        public c(AosPagerListViewModel<Model> r1) {
            this.a = r1;
        }

        @Override // h04.c
        public final void onSuccess(List<? extends Model> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "data");
            AosPagerListViewModel.access$setLoadingForwardData$p(this.a, false);
            this.a.loadForwardSuccess(r3, r4);
        }
    }

    public static final class d implements h04.d<Model> {
        public final /* synthetic */ AosPagerListViewModel<Model> a;

        @Override // h04.d
        public final void onFail() {
            AosPagerListViewModel.access$setLoadingMoreData$p(this.a, false);
            AosPagerListViewModel.access$loadMoreFail(this.a);
        }

        public d(AosPagerListViewModel<Model> r1) {
            this.a = r1;
        }

        @Override // h04.d
        public final void onSuccess(List<? extends Model> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "data");
            AosPagerListViewModel.access$setLoadingMoreData$p(this.a, false);
            AosPagerListViewModel.access$loadMoreSuccess(this.a, r3, r4);
        }
    }

    public static final class e implements h04.e<Model> {
        public final /* synthetic */ AosPagerListViewModel<Model> a;

        public e(AosPagerListViewModel<Model> r1) {
            this.a = r1;
        }

        @Override // h04.e
        public final void a(Exception r4, int r5) {
            AosPagerListViewModel.access$setRefreshingData$p(this.a, false);
            ListState r0 = (ListState) this.a.getDataList().getValue();
            String r1 = null;
            if (r0 == null) goto L5;
            ListState.State r2 = r0.c;
        L6:
            ListState r3 = (ListState) this.a.getDataList().getValue();
            if (r3 == null) goto L14;
            if (r4 == null) goto L11;
            r1 = r4.getMessage();
        L11:
            if (r1 != null) goto L13;
            r1 = "";
        L13:
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r3.i = r1;
        L14:
            ListState r6 = (ListState) this.a.getDataList().getValue();
            if (r6 == null) goto L19;
            r6.j = r5;
        L19:
            if (r2 != ListState.State.INITIAL_LOAD) goto L22;
            AosPagerListViewModel.access$initLoadFail(this.a);
            return;
        L22:
            if (r2 != ListState.State.START_REFRESH) goto L26;
            AosPagerListViewModel.access$refreshFail(this.a);
            return;
        L26:
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // h04.e
        public final void b(List<? extends Model> r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "data");
            AosPagerListViewModel.access$setRefreshingData$p(this.a, false);
            ListState r0 = (ListState) this.a.getDataList().getValue();
            if (r0 == null) goto L5;
            ListState.State r1 = r0.c;
        L6:
            ListState r2 = (ListState) this.a.getDataList().getValue();
            if (r2 == null) goto L10;
            r2.g = r5;
        L10:
            ListState r6 = (ListState) this.a.getDataList().getValue();
            if (r6 == null) goto L15;
            r6.h = r4;
        L15:
            if (r1 != ListState.State.INITIAL_LOAD) goto L17;
            AosPagerListViewModel.access$initLoadSuccess(this.a, r3);
            return;
        L17:
            AosPagerListViewModel.access$refreshSuccess(this.a, r3);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public abstract List<Model> filterForwardData(List<? extends Model> r1, List<? extends Model> r2);

    public abstract List<Model> filterMoreData(List<? extends Model> r1, int r2);

    public abstract List<Model> filterRefreshData(List<? extends Model> r1, List<? extends Model> r2, int r3);

    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.j getHostCoverParams() {
        return null;
    }

    public abstract void loadForwardData(h04.c<Model> r1);

    public abstract void loadMoreData(h04.d<Model> r1);

    public void onBeforeFilterData(ListState<List<Model>> r2, List<Model> r3) {
        Intrinsics.checkNotNullParameter(r2, "listState");
        Intrinsics.checkNotNullParameter(r3, "newData");
    }

    public void onBeforeTempData2List(ListState<List<Model>> r2, List<Model> r3) {
        Intrinsics.checkNotNullParameter(r2, "listState");
        Intrinsics.checkNotNullParameter(r3, "newData");
    }

    public abstract void refreshData(h04.e<Model> r1, boolean r2);

    public abstract String sceneId();

    public void updateCurrentPage(int r1, int r2, long r3, long r5) {
    }

    private final boolean hasForward() {
        ListState r0 = (ListState) this.dataList.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.h != true) goto L9;
        return true;
    L9:
        return false;
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

    private final void initLoadFail() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.INITIAL_FAIL);
        this._dataList.setValue(r0);
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

    private final void requestLaunchConfigFail() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.REQUEST_LAUNCH_CONFIG_FAIL);
        this._dataList.setValue(r0);
    }

    private final void requestLaunchConfigSuccess() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.REQUEST_LAUNCH_CONFIG_SUCCESS);
        this._dataList.setValue(r0);
        startInitLoad();
    }

    private final void startInitLoad() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.isRefreshingData == false) goto L8;
        return;
    L8:
        this.isRefreshingData = true;
        r0.a(ListState.State.INITIAL_LOAD);
        this._dataList.setValue(r0);
        refreshData(this.refreshCallback, true);
    }

    public final int dataSize() {
        Object r0 = this.dataList.getValue();
        Intrinsics.checkNotNull(r0);
        return ((List) ((ListState) r0).a).size();
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.util.List] */
    public final void disLikeCurrent() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = this.selectedIndex.getValue();
        Intrinsics.checkNotNull(r1);
        int r2 = ((Number) r1).intValue();
        Object r3 = this.dataList.getValue();
        Intrinsics.checkNotNull(r3);
        if (r2 >= ((List) ((ListState) r3).a).size()) goto L20;
        r0.a(ListState.State.DISLIKE_CURRENT);
        Object r4 = ListProtector.get((List) r0.a, r2);
        Iterable r5 = (Iterable) r0.a;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r8 = r7.next();
        if ((!Intrinsics.areEqual(r8, r4)) == false) goto L9;
        r6.add(r8);
        goto L9
    L13:
        ?? r9 = CollectionsKt.toMutableList(r6);
        r0.a = r9;
        filterMoreData((List) r9, 0);
        this._dataList.setValue(r0);
        preloadLoadMore(r2);
        return;
    }

    public final void discardAfterCurrent() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = this.selectedIndex.getValue();
        Intrinsics.checkNotNull(r1);
        int r2 = ((Number) r1).intValue();
        if (r2 != (-1)) goto L8;
        return;
    L8:
        if (r2 >= (((List) r0.a).size() - 1)) goto L13;
        r0.a(ListState.State.DISCARD_AFTER_CURRENT);
        r0.f = r2;
        this._dataList.setValue(r0);
        Object r3 = this.selectedIndex.getValue();
        Intrinsics.checkNotNull(r3);
        preloadLoadMore(((Number) r3).intValue());
        return;
    }

    public final int getCurrentIndex() {
        Object r0 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r0);
        return ((Number) r0).intValue();
    }

    public final int getCurrentSelectedIndex() {
        Object r0 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r0);
        return ((Number) r0).intValue();
    }

    public final ListState.State getCurrentState() {
        Object r0 = this.dataList.getValue();
        Intrinsics.checkNotNull(r0);
        return ((ListState) r0).c;
    }

    public int getNextEpisodeIndex() {
        Object r0 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r0);
        return ((Number) r0).intValue();
    }

    public final void loadForward() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (hasForward() == true) goto L9;
        return;
    L9:
        if (this.isLoadingForwardData == false) goto L11;
        return;
    L11:
        this.isLoadingForwardData = true;
        r0.a(ListState.State.START_LOAD_FORWARD);
        this._dataList.setValue(r0);
    }

    public final void loadForwardFail() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.LOAD_FORWARD_FAIL);
        this._dataList.setValue(r0);
    }

    public final void removeDataAfterIndex() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        T r1 = r0.a;
        ((List) r1).subList(r0.f + 1, ((List) r1).size()).clear();
    }

    public final void retry() {
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
        refreshData(this.refreshCallback, false);
    }

    public final void startRequestInitConfig() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.REQUEST_LAUNCH_CONFIG);
        this._dataList.setValue(r0);
        h54.a r1 = com.bytedance.awemeopen.apps.framework.launchconfig.a.a;
        com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC0100a r2 = (com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC0100a) c04.h.a(this.launchConfigCallback);
        int r3 = com.bytedance.awemeopen.apps.framework.launchconfig.a.b;
        if (r3 != 2) goto L10;
        if (r2 == null) goto L20;
        r2.b();
        return;
    L20:
        return;
    L10:
        if (r3 != 3) goto L13;
        if (r2 == null) goto L22;
        r2.a();
        return;
    L22:
        return;
    L13:
        if (r2 == null) goto L16;
        ((ArrayList) com.bytedance.awemeopen.apps.framework.launchconfig.a.c).add(r2);
    L16:
        if (com.bytedance.awemeopen.apps.framework.launchconfig.a.b == 1) goto L24;
        com.bytedance.awemeopen.apps.framework.launchconfig.a.b = 1;
        AosExtConfig.b.P0(new LaunchConfigManager$checkLaunchConfig$1());
        return;
    }

    public final void tempData2ListForLoadForward() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        r1.addAll((Collection) r0.b);
        ((List) r0.b).clear();
        List<Model> r2 = filterForwardData(r1, (List) r0.a);
        if (r2 == null) goto L9;
        ((List) r0.a).clear();
        ((List) r0.a).addAll(r2);
        return;
    }

    public final void tempData2ListForLoadMore() {
        ListState<List<Model>> r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        r1.addAll(r0.b);
        r0.b.clear();
        List<Model> r2 = insertHostAddIfNeed(r1, false);
        onBeforeFilterData(r0, r2);
        List<Model> r3 = filterMoreData(r2, r0.a.size());
        onBeforeTempData2List(r0, r3);
        r0.a.addAll(r3);
    }

    public final void tempData2ListForLocateTargetIndex() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        r1.addAll((Collection) r0.b);
        ((List) r0.b).clear();
        ((List) r0.a).clear();
        ((List) r0.a).addAll(r1);
    }

    public final void tempData2ListForRefresh() {
        ListState<List<Model>> r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        r1.addAll(r0.b);
        r0.b.clear();
        List r2 = insertHostAddIfNeed(r1, true);
        onBeforeFilterData(r0, r2);
        List<Model> r3 = filterRefreshData(r2, r0.a, 0);
        onBeforeTempData2List(r0, r3);
        r0.a.clear();
        r0.a.addAll(r3);
    }

    public final void tempData2ListForSegmentUpdate() {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        r1.addAll((Collection) r0.b);
        ((List) r0.b).clear();
        T r2 = r0.a;
        ((List) r2).subList(r0.f, ((List) r2).size()).clear();
        ((List) r0.a).addAll(r1);
    }

    public AosPagerListViewModel() {
        this.shouldOpenPreLoad = true;
        DiscardFirstValueLiveData<Integer> r1 = new DiscardFirstValueLiveData();
        r1.setValue(0);
        this.commentShowLiveData = r1;
        MutableLiveData<ListState<List<Model>>> r2 = new MutableLiveData();
        r2.setValue(new ListState(new ArrayList(), new ArrayList()));
        this._dataList = r2;
        this.dataList = r2;
        this.apiType = "";
        this.refreshCallback = new e(this);
        this.loadMoreCallback = new d(this);
        this.launchConfigCallback = new b(this);
        this.loadForwardCallback = new c(this);
        CallbackAfterChangedLiveData<Integer> r3 = new CallbackAfterChangedLiveData(-1);
        this._selectedIndex = r3;
        CallbackAfterChangedLiveData<Integer> r4 = new CallbackAfterChangedLiveData(-1);
        this._palpableIndex = r4;
        this.selectedIndex = r3;
        this.palpableIndex = r4;
        this.lastSelectedIndex = -1;
        this.isNoAction = true;
    }

    public final String getApiType() {
        return this.apiType;
    }

    public final DiscardFirstValueLiveData<Integer> getCommentShowLiveData() {
        return this.commentShowLiveData;
    }

    public final LiveData<ListState<List<Model>>> getDataList() {
        return this.dataList;
    }

    public final int getLastSelectedIndex() {
        return this.lastSelectedIndex;
    }

    public final h04.c<Model> getLoadForwardCallback() {
        return this.loadForwardCallback;
    }

    public final int getNoActionAccount() {
        return this.noActionAccount;
    }

    public final LiveData<Integer> getPalpableIndex() {
        return this.palpableIndex;
    }

    public final LiveData<Integer> getSelectedIndex() {
        return this.selectedIndex;
    }

    public final boolean getShouldOpenPreLoad() {
        return this.shouldOpenPreLoad;
    }

    public final boolean isNoAction() {
        return this.isNoAction;
    }

    public boolean shouldPreLoad() {
        return this.shouldOpenPreLoad;
    }

    public static final /* synthetic */ void access$initLoadFail(AosPagerListViewModel r0) {
        r0.initLoadFail();
    }

    public static final /* synthetic */ void access$loadMoreFail(AosPagerListViewModel r0) {
        r0.loadMoreFail();
    }

    public static final /* synthetic */ void access$refreshFail(AosPagerListViewModel r0) {
        r0.refreshFail();
    }

    public static final /* synthetic */ void access$requestLaunchConfigFail(AosPagerListViewModel r0) {
        r0.requestLaunchConfigFail();
    }

    public static final /* synthetic */ void access$requestLaunchConfigSuccess(AosPagerListViewModel r0) {
        r0.requestLaunchConfigSuccess();
    }

    private final void initLoadSuccess(List<? extends Model> r3) {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.INITIAL_SUCCESS);
        ((List) r0.b).clear();
        ((List) r0.b).addAll(r3);
        this._dataList.setValue(r0);
        j04.a r4 = j04.b.a;
        long r1 = System.currentTimeMillis();
        j04.a r5 = j04.b.a;
        if (r5 == null) goto L9;
        r5.d = r1;
        return;
    }

    private final boolean preloadLoadForward(int r2) {
        if (hasForward() == true) goto L5;
        return false;
    L5:
        if (r2 != 1) goto L10;
        loadForward();
        return true;
    L10:
        return false;
    }

    private final boolean preloadLoadMore(int r4) {
        Object r0 = this.dataList.getValue();
        Intrinsics.checkNotNull(r0);
        int r1 = ((List) ((ListState) r0).a).size() - (r4 + 1);
        int r5 = AosExtConfig.b.z0().h;
        if (r5 <= 12) goto L6;
        r5 = 12;
    L8:
        if (r1 >= r5) goto L11;
        startLoadMore(true);
        return true;
    L11:
        return false;
    L6:
        if (r5 >= 3) goto L8;
        r5 = 3;
        goto L8
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

    public final void setApiType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.apiType = r2;
    }

    public final void setNoAction(boolean r1) {
        this.isNoAction = r1;
    }

    public final void setNoActionAccount(int r1) {
        this.noActionAccount = r1;
    }

    public final void setShouldOpenPreLoad(boolean r1) {
        this.shouldOpenPreLoad = r1;
    }

    public final void startLoadMore(boolean r2) {
        ListState r3 = (ListState) this._dataList.getValue();
        if (r3 != null) goto L6;
        return;
    L6:
        if (hasMore() == true) goto L8;
        return;
    L8:
        if (this.isRefreshingData == false) goto L11;
        return;
    L11:
        if (this.isLoadingMoreData == false) goto L13;
        return;
    L13:
        this.isLoadingMoreData = true;
        r3.a(ListState.State.START_LOAD_MORE);
        this._dataList.setValue(r3);
        loadMoreData(this.loadMoreCallback);
    }

    public static final /* synthetic */ void access$initLoadSuccess(AosPagerListViewModel r0, List r1) {
        r0.initLoadSuccess(r1);
    }

    public static final /* synthetic */ void access$refreshSuccess(AosPagerListViewModel r0, List r1) {
        r0.refreshSuccess(r1);
    }

    public static final /* synthetic */ void access$setLoadingForwardData$p(AosPagerListViewModel r0, boolean r1) {
        r0.isLoadingForwardData = r1;
    }

    public static final /* synthetic */ void access$setLoadingMoreData$p(AosPagerListViewModel r0, boolean r1) {
        r0.isLoadingMoreData = r1;
    }

    public static final /* synthetic */ void access$setRefreshingData$p(AosPagerListViewModel r0, boolean r1) {
        r0.isRefreshingData = r1;
    }

    private final void loadMoreSuccess(List<? extends Model> r3, boolean r4) {
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.LOAD_MORE_SUCCESS);
        r0.g = r4;
        ((List) r0.b).addAll(r3);
        this._dataList.setValue(r0);
    }

    public List<Model> insertHostAddIfNeed(List<? extends Model> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        return CollectionsKt.toMutableList(r1);
    }

    public final void loadForwardSuccess(List<? extends Model> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "list");
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.LOAD_FORWARD_SUCCESS);
        r0.h = r4;
        ((List) r0.b).addAll(r3);
        this._dataList.setValue(r0);
    }

    public final void updatePalpableIndex(int r1, boolean r2) {
        if (r2 == false) goto L4;
        this._palpableIndex.a(Integer.valueOf(r1));
        return;
    L4:
        this._palpableIndex.setValue(Integer.valueOf(r1));
    }

    public final void updateTargetSegment(List<? extends Model> r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dataList");
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.SERIES_SEGMENT_UPDATE);
        ((List) r0.b).addAll(r3);
        r0.f = r4;
        this._dataList.setValue(r0);
    }

    public static final /* synthetic */ void access$loadMoreSuccess(AosPagerListViewModel r0, List r1, boolean r2) {
        r0.loadMoreSuccess(r1, r2);
    }

    public void updateCurrentIndex(int r2, boolean r3, boolean r4) {
        Object r0 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r0);
        this.lastSelectedIndex = ((Number) r0).intValue();
        if (r3 == false) goto L5;
        this._selectedIndex.a(Integer.valueOf(r2));
        this._palpableIndex.a(Integer.valueOf(r2));
    L7:
        if (shouldPreLoad() == false) goto L13;
        if (r4 == false) goto L10;
        return;
    L10:
        if (preloadLoadMore(r2) == true) goto L15;
        preloadLoadForward(r2);
        return;
    L15:
        return;
    L13:
        return;
    L5:
        this._selectedIndex.setValue(Integer.valueOf(r2));
        this._palpableIndex.setValue(Integer.valueOf(r2));
        goto L7
    }

    public static /* synthetic */ void updatePalpableIndex$default(AosPagerListViewModel r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.updatePalpableIndex(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePalpableIndex");
    }

    public static /* synthetic */ void updateCurrentIndex$default(AosPagerListViewModel r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = false;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = false;
    L9:
        r1.updateCurrentIndex(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentIndex");
    }

    public final void updateDataList(List<? extends Model> r10, int r11, int r12, int r13, boolean r14, boolean r15, long r16, long r18) {
        Intrinsics.checkNotNullParameter(r10, "dataList");
        updateCurrentPage(r12, r13, r16, r18);
        ListState r0 = (ListState) this._dataList.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(ListState.State.SERIES_CHOOSE_TARGET_EPISODE);
        ((List) r0.a).clear();
        ((List) r0.b).addAll(r10);
        r0.h = r14;
        r0.g = r15;
        this._dataList.setValue(r0);
    }
}
