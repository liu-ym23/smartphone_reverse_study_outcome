package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.livedata.CallbackAfterChangedLiveData;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.apps.framework.launchconfig.LaunchConfigManager$checkLaunchConfig$1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0003rux\b&\u0018\u0000 \u0092\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0093\u0001B\t¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u001e\u0010\u000f\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J*\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J*\u0010\u001f\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u0003J\u001c\u0010(\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0015\u001a\u00020\rJ\u0006\u0010)\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0003J$\u00100\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\rH\u0016J\u0006\u00101\u001a\u00020\u0011J\u0006\u00102\u001a\u00020\u0011J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\rJ\u0006\u00104\u001a\u00020\u0011J\b\u00105\u001a\u00020\u0011H\u0016J\u0006\u00107\u001a\u000206J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020:H&J\u001e\u0010?\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<2\u0006\u0010>\u001a\u00020\rH&J\u0016\u0010A\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000@H&J\u0016\u0010C\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000BH&J$\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010E\u001a\u00020\rH\u0016J2\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010H\u001a\u00020\u0011H&J$\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010H\u001a\u00020\u0011H&J,\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&JL\u0010T\u001a\u00020\u00032\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QJ\u001c\u0010U\u001a\u00020\u00032\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010H\u001a\u00020\u0011J(\u0010V\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00112\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020QH\u0016R\"\u0010W\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110]8\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR&\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a0b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR)\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001a0e8\u0006¢\u0006\f\n\u0004\bM\u0010f\u001a\u0004\bg\u0010hR\"\u0010i\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010XR\u0016\u0010p\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010XR\u0016\u0010q\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010XR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00000x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000B8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R \u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110e8\u0006¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010f\u001a\u0005\b\u0084\u0001\u0010hR \u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110e8\u0006¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010f\u001a\u0005\b\u0086\u0001\u0010hR\u0019\u0010\u0087\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u0010\u0089\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0088\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R&\u0010\u008e\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010X\u001a\u0005\b\u008e\u0001\u0010Z\"\u0005\b\u008f\u0001\u0010\\¨\u0006\u0094\u0001"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", ExifInterface.TAG_MODEL, "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "", "requestLaunchConfigSuccess", "requestLaunchConfigFail", "startInitLoad", "", "list", "initLoadSuccess", "initLoadFail", "refreshSuccess", "refreshFail", "", "hasMore", "loadMoreSuccess", "loadMoreFail", "", "index", "preloadLoadMore", "preloadLoadForward", "hasForward", "shouldPreLoad", "dataSize", "tempData2ListForRefresh", "tempData2ListForLoadMore", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState;", "", "listState", "newData", "onBeforeFilterData", "onBeforeTempData2List", "tempData2ListForLocateTargetIndex", "tempData2ListForSegmentUpdate", "tempData2ListForLoadForward", "removeDataAfterIndex", EventConstant.Value.RETRY, "startRequestInitConfig", "startRefresh", "loadForward", "loadForwardSuccess", "loadForwardFail", "isPreloadLoadMore", "startLoadMore", "disLikeCurrent", "discardAfterCurrent", "forceUpdate", "ignorePreload", "updateCurrentIndex", "getLastSelectedIndex", "getCurrentSelectedIndex", "updatePalpableIndex", "getCurrentIndex", "getNextEpisodeIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/datawithstate/ListState$State;", "getCurrentState", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/j;", "getHostCoverParams", "", "sceneId", "Lh04/e;", "callback", "isFirst", "refreshData", "Lh04/d;", "loadMoreData", "Lh04/c;", "loadForwardData", "data", "isRefresh", "insertHostAddIfNeed", "oldData", "startIndex", "filterRefreshData", "filterMoreData", "forwardData", "filterForwardData", "dataList", "targetIndex", "currentForwardPage", "currentLoadMorePage", "", "firstSeriesId", "lastSeriesId", "updateDataList", "updateTargetSegment", "updateCurrentPage", "shouldOpenPreLoad", "Z", "getShouldOpenPreLoad", "()Z", "setShouldOpenPreLoad", "(Z)V", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "commentShowLiveData", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "getCommentShowLiveData", "()Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "Landroidx/lifecycle/MutableLiveData;", "_dataList", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "getDataList", "()Landroidx/lifecycle/LiveData;", "apiType", "Ljava/lang/String;", "getApiType", "()Ljava/lang/String;", "setApiType", "(Ljava/lang/String;)V", "isRefreshingData", "isLoadingMoreData", "isLoadingForwardData", "com/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$e", "refreshCallback", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$e;", "com/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$d", "loadMoreCallback", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$d;", "com/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$b", "launchConfigCallback", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel$b;", "loadForwardCallback", "Lh04/c;", "getLoadForwardCallback", "()Lh04/c;", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/CallbackAfterChangedLiveData;", "_selectedIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/CallbackAfterChangedLiveData;", "_palpableIndex", "selectedIndex", "getSelectedIndex", "palpableIndex", "getPalpableIndex", "lastSelectedIndex", "I", "noActionAccount", "getNoActionAccount", "()I", "setNoActionAccount", "(I)V", "isNoAction", "setNoAction", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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

    public static final class b implements com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC2827a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosPagerListViewModel<Model> f197048a;

        @Override // com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC2827a
        public final void a() {
            AosPagerListViewModel.access$requestLaunchConfigFail(this.f197048a);
        }

        @Override // com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC2827a
        public final void b() {
            AosPagerListViewModel.access$requestLaunchConfigSuccess(this.f197048a);
        }

        public b(AosPagerListViewModel<Model> r100) {
            this.f197048a = r100;
        }
    }

    public static final class c implements h04.c<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosPagerListViewModel<Model> f197049a;

        @Override // h04.c
        public final void onFail() {
            AosPagerListViewModel.access$setLoadingForwardData$p(this.f197049a, false);
            this.f197049a.loadForwardFail();
        }

        public c(AosPagerListViewModel<Model> r100) {
            this.f197049a = r100;
        }

        @Override // h04.c
        public final void onSuccess(List<? extends Model> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            AosPagerListViewModel.access$setLoadingForwardData$p(this.f197049a, false);
            this.f197049a.loadForwardSuccess(r100, r101);
        }
    }

    public static final class d implements h04.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosPagerListViewModel<Model> f197050a;

        @Override // h04.d
        public final void onFail() {
            AosPagerListViewModel.access$setLoadingMoreData$p(this.f197050a, false);
            AosPagerListViewModel.access$loadMoreFail(this.f197050a);
        }

        public d(AosPagerListViewModel<Model> r100) {
            this.f197050a = r100;
        }

        @Override // h04.d
        public final void onSuccess(List<? extends Model> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            AosPagerListViewModel.access$setLoadingMoreData$p(this.f197050a, false);
            AosPagerListViewModel.access$loadMoreSuccess(this.f197050a, r100, r101);
        }
    }

    public static final class e implements h04.e<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AosPagerListViewModel<Model> f197051a;

        public e(AosPagerListViewModel<Model> r100) {
            this.f197051a = r100;
        }

        @Override // h04.e
        public final void a(Exception r100, int r101) {
            AosPagerListViewModel.access$setRefreshingData$p(this.f197051a, false);
            ListState<List<Model>> r102 = this.f197051a.getDataList().getValue();
            String r103 = null;
            if (r102 == null) goto L5;
            ListState.State r104 = r102.f196929c;
        L6:
            ListState<List<Model>> r105 = this.f197051a.getDataList().getValue();
            if (r105 == null) goto L14;
            if (r100 == null) goto L11;
            r103 = r100.getMessage();
        L11:
            if (r103 != null) goto L13;
            r103 = "";
        L13:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r105.f196935i = r103;
        L14:
            ListState<List<Model>> r106 = this.f197051a.getDataList().getValue();
            if (r106 == null) goto L19;
            r106.f196936j = r101;
        L19:
            if (r104 != ListState.State.INITIAL_LOAD) goto L22;
            AosPagerListViewModel.access$initLoadFail(this.f197051a);
            return;
        L22:
            if (r104 != ListState.State.START_REFRESH) goto L26;
            AosPagerListViewModel.access$refreshFail(this.f197051a);
            return;
        L26:
            return;
        L5:
            r104 = null;
            goto L6
        }

        @Override // h04.e
        public final void b(List<? extends Model> r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            AosPagerListViewModel.access$setRefreshingData$p(this.f197051a, false);
            ListState<List<Model>> r103 = this.f197051a.getDataList().getValue();
            if (r103 == null) goto L5;
            ListState.State r104 = r103.f196929c;
        L6:
            ListState<List<Model>> r105 = this.f197051a.getDataList().getValue();
            if (r105 == null) goto L10;
            r105.f196933g = r102;
        L10:
            ListState<List<Model>> r106 = this.f197051a.getDataList().getValue();
            if (r106 == null) goto L15;
            r106.f196934h = r101;
        L15:
            if (r104 != ListState.State.INITIAL_LOAD) goto L17;
            AosPagerListViewModel.access$initLoadSuccess(this.f197051a, r100);
            return;
        L17:
            AosPagerListViewModel.access$refreshSuccess(this.f197051a, r100);
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public abstract List<Model> filterForwardData(List<? extends Model> r100, List<? extends Model> r101);

    public abstract List<Model> filterMoreData(List<? extends Model> r100, int r101);

    public abstract List<Model> filterRefreshData(List<? extends Model> r100, List<? extends Model> r101, int r102);

    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.j getHostCoverParams() {
        return null;
    }

    public abstract void loadForwardData(h04.c<Model> r100);

    public abstract void loadMoreData(h04.d<Model> r100);

    public void onBeforeFilterData(ListState<List<Model>> r100, List<Model> r101) {
        Intrinsics.checkNotNullParameter(r100, "listState");
        Intrinsics.checkNotNullParameter(r101, "newData");
    }

    public void onBeforeTempData2List(ListState<List<Model>> r100, List<Model> r101) {
        Intrinsics.checkNotNullParameter(r100, "listState");
        Intrinsics.checkNotNullParameter(r101, "newData");
    }

    public abstract void refreshData(h04.e<Model> r100, boolean r101);

    public abstract String sceneId();

    public void updateCurrentPage(int r100, int r101, long r102, long r103) {
    }

    private final boolean hasForward() {
        ListState<List<Model>> r100 = this.dataList.getValue();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f196934h != true) goto L9;
        return true;
    L9:
        return false;
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

    private final void initLoadFail() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.INITIAL_FAIL);
        this._dataList.setValue(r100);
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

    private final void requestLaunchConfigFail() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.REQUEST_LAUNCH_CONFIG_FAIL);
        this._dataList.setValue(r100);
    }

    private final void requestLaunchConfigSuccess() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.REQUEST_LAUNCH_CONFIG_SUCCESS);
        this._dataList.setValue(r100);
        startInitLoad();
    }

    private final void startInitLoad() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.isRefreshingData == false) goto L8;
        return;
    L8:
        this.isRefreshingData = true;
        r100.a(ListState.State.INITIAL_LOAD);
        this._dataList.setValue(r100);
        refreshData(this.refreshCallback, true);
    }

    public final int dataSize() {
        ListState<List<Model>> r100 = this.dataList.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.f196927a.size();
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.util.List] */
    public final void disLikeCurrent() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = this.selectedIndex.getValue();
        Intrinsics.checkNotNull(r101);
        int r102 = r101.intValue();
        ListState<List<Model>> r103 = this.dataList.getValue();
        Intrinsics.checkNotNull(r103);
        if (r102 >= r103.f196927a.size()) goto L20;
        r100.a(ListState.State.DISLIKE_CURRENT);
        Object r104 = ListProtector.get(r100.f196927a, r102);
        List<Model> r105 = r100.f196927a;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        Object r108 = r107.next();
        if ((!Intrinsics.areEqual(r108, r104)) == false) goto L9;
        r106.add(r108);
        goto L9
    L13:
        ?? r109 = CollectionsKt.toMutableList(r106);
        r100.f196927a = r109;
        filterMoreData((List) r109, 0);
        this._dataList.setValue(r100);
        preloadLoadMore(r102);
        return;
    }

    public final void discardAfterCurrent() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = this.selectedIndex.getValue();
        Intrinsics.checkNotNull(r101);
        int r102 = r101.intValue();
        if (r102 != (-1)) goto L8;
        return;
    L8:
        if (r102 >= (r100.f196927a.size() - 1)) goto L13;
        r100.a(ListState.State.DISCARD_AFTER_CURRENT);
        r100.f196932f = r102;
        this._dataList.setValue(r100);
        Integer r103 = this.selectedIndex.getValue();
        Intrinsics.checkNotNull(r103);
        preloadLoadMore(r103.intValue());
        return;
    }

    public final int getCurrentIndex() {
        Integer r100 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.intValue();
    }

    public final int getCurrentSelectedIndex() {
        Integer r100 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.intValue();
    }

    public final ListState.State getCurrentState() {
        ListState<List<Model>> r100 = this.dataList.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.f196929c;
    }

    public int getNextEpisodeIndex() {
        Integer r100 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.intValue();
    }

    public final void loadForward() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L6;
        return;
    L6:
        if (hasForward() == true) goto L9;
        return;
    L9:
        if (this.isLoadingForwardData == false) goto L11;
        return;
    L11:
        this.isLoadingForwardData = true;
        r100.a(ListState.State.START_LOAD_FORWARD);
        this._dataList.setValue(r100);
    }

    public final void loadForwardFail() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.LOAD_FORWARD_FAIL);
        this._dataList.setValue(r100);
    }

    public final void removeDataAfterIndex() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        List<Model> r101 = r100.f196927a;
        r101.subList(r100.f196932f + 1, r101.size()).clear();
    }

    public final void retry() {
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
        refreshData(this.refreshCallback, false);
    }

    public final void startRequestInitConfig() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.REQUEST_LAUNCH_CONFIG);
        this._dataList.setValue(r100);
        h54.a r101 = com.bytedance.awemeopen.apps.framework.launchconfig.a.f197224a;
        com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC2827a r102 = (com.bytedance.awemeopen.apps.framework.launchconfig.a.InterfaceC2827a) c04.h.a(this.launchConfigCallback);
        int r103 = com.bytedance.awemeopen.apps.framework.launchconfig.a.f197225b;
        if (r103 != 2) goto L10;
        if (r102 == null) goto L20;
        r102.b();
        return;
    L20:
        return;
    L10:
        if (r103 != 3) goto L13;
        if (r102 == null) goto L22;
        r102.a();
        return;
    L22:
        return;
    L13:
        if (r102 == null) goto L16;
        ((ArrayList) com.bytedance.awemeopen.apps.framework.launchconfig.a.f197226c).add(r102);
    L16:
        if (com.bytedance.awemeopen.apps.framework.launchconfig.a.f197225b == 1) goto L24;
        com.bytedance.awemeopen.apps.framework.launchconfig.a.f197225b = 1;
        AosExtConfig.f193138b.P0(new LaunchConfigManager$checkLaunchConfig$1());
        return;
    }

    public final void tempData2ListForLoadForward() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        List<Model> r102 = filterForwardData(r101, r100.f196927a);
        if (r102 == null) goto L9;
        r100.f196927a.clear();
        r100.f196927a.addAll(r102);
        return;
    }

    public final void tempData2ListForLoadMore() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        List<Model> r102 = insertHostAddIfNeed(r101, false);
        onBeforeFilterData(r100, r102);
        List<Model> r103 = filterMoreData(r102, r100.f196927a.size());
        onBeforeTempData2List(r100, r103);
        r100.f196927a.addAll(r103);
    }

    public final void tempData2ListForLocateTargetIndex() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        r100.f196927a.clear();
        r100.f196927a.addAll(r101);
    }

    public final void tempData2ListForRefresh() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        List r102 = insertHostAddIfNeed(r101, true);
        onBeforeFilterData(r100, r102);
        List<Model> r103 = filterRefreshData(r102, r100.f196927a, 0);
        onBeforeTempData2List(r100, r103);
        r100.f196927a.clear();
        r100.f196927a.addAll(r103);
    }

    public final void tempData2ListForSegmentUpdate() {
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = new ArrayList();
        r101.addAll(r100.f196928b);
        r100.f196928b.clear();
        List<Model> r102 = r100.f196927a;
        r102.subList(r100.f196932f, r102.size()).clear();
        r100.f196927a.addAll(r101);
    }

    public AosPagerListViewModel() {
        this.shouldOpenPreLoad = true;
        DiscardFirstValueLiveData<Integer> r100 = new DiscardFirstValueLiveData();
        r100.setValue(0);
        this.commentShowLiveData = r100;
        MutableLiveData<ListState<List<Model>>> r101 = new MutableLiveData();
        r101.setValue(new ListState(new ArrayList(), new ArrayList()));
        this._dataList = r101;
        this.dataList = r101;
        this.apiType = "";
        this.refreshCallback = new e(this);
        this.loadMoreCallback = new d(this);
        this.launchConfigCallback = new b(this);
        this.loadForwardCallback = new c(this);
        CallbackAfterChangedLiveData<Integer> r102 = new CallbackAfterChangedLiveData(-1);
        this._selectedIndex = r102;
        CallbackAfterChangedLiveData<Integer> r103 = new CallbackAfterChangedLiveData(-1);
        this._palpableIndex = r103;
        this.selectedIndex = r102;
        this.palpableIndex = r103;
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

    public static final /* synthetic */ void access$initLoadFail(AosPagerListViewModel r100) {
        r100.initLoadFail();
    }

    public static final /* synthetic */ void access$loadMoreFail(AosPagerListViewModel r100) {
        r100.loadMoreFail();
    }

    public static final /* synthetic */ void access$refreshFail(AosPagerListViewModel r100) {
        r100.refreshFail();
    }

    public static final /* synthetic */ void access$requestLaunchConfigFail(AosPagerListViewModel r100) {
        r100.requestLaunchConfigFail();
    }

    public static final /* synthetic */ void access$requestLaunchConfigSuccess(AosPagerListViewModel r100) {
        r100.requestLaunchConfigSuccess();
    }

    private final void initLoadSuccess(List<? extends Model> r100) {
        ListState<List<Model>> r101 = this._dataList.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.a(ListState.State.INITIAL_SUCCESS);
        r101.f196928b.clear();
        r101.f196928b.addAll(r100);
        this._dataList.setValue(r101);
        j04.a r102 = j04.b.f496807a;
        long r103 = System.currentTimeMillis();
        j04.a r104 = j04.b.f496807a;
        if (r104 == null) goto L9;
        r104.f496795d = r103;
        return;
    }

    private final boolean preloadLoadForward(int r100) {
        if (hasForward() == true) goto L5;
        return false;
    L5:
        if (r100 != 1) goto L10;
        loadForward();
        return true;
    L10:
        return false;
    }

    private final boolean preloadLoadMore(int r100) {
        ListState<List<Model>> r101 = this.dataList.getValue();
        Intrinsics.checkNotNull(r101);
        int r102 = r101.f196927a.size() - (r100 + 1);
        int r103 = AosExtConfig.f193138b.z0().f536307h;
        if (r103 <= 12) goto L6;
        r103 = 12;
    L8:
        if (r102 >= r103) goto L11;
        startLoadMore(true);
        return true;
    L11:
        return false;
    L6:
        if (r103 >= 3) goto L8;
        r103 = 3;
        goto L8
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

    public final void setApiType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.apiType = r100;
    }

    public final void setNoAction(boolean r100) {
        this.isNoAction = r100;
    }

    public final void setNoActionAccount(int r100) {
        this.noActionAccount = r100;
    }

    public final void setShouldOpenPreLoad(boolean r100) {
        this.shouldOpenPreLoad = r100;
    }

    public final void startLoadMore(boolean r100) {
        ListState<List<Model>> r101 = this._dataList.getValue();
        if (r101 != null) goto L6;
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
        r101.a(ListState.State.START_LOAD_MORE);
        this._dataList.setValue(r101);
        loadMoreData(this.loadMoreCallback);
    }

    public static final /* synthetic */ void access$initLoadSuccess(AosPagerListViewModel r100, List r101) {
        r100.initLoadSuccess(r101);
    }

    public static final /* synthetic */ void access$refreshSuccess(AosPagerListViewModel r100, List r101) {
        r100.refreshSuccess(r101);
    }

    public static final /* synthetic */ void access$setLoadingForwardData$p(AosPagerListViewModel r100, boolean r101) {
        r100.isLoadingForwardData = r101;
    }

    public static final /* synthetic */ void access$setLoadingMoreData$p(AosPagerListViewModel r100, boolean r101) {
        r100.isLoadingMoreData = r101;
    }

    public static final /* synthetic */ void access$setRefreshingData$p(AosPagerListViewModel r100, boolean r101) {
        r100.isRefreshingData = r101;
    }

    private final void loadMoreSuccess(List<? extends Model> r100, boolean r101) {
        ListState<List<Model>> r102 = this._dataList.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.a(ListState.State.LOAD_MORE_SUCCESS);
        r102.f196933g = r101;
        r102.f196928b.addAll(r100);
        this._dataList.setValue(r102);
    }

    public List<Model> insertHostAddIfNeed(List<? extends Model> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return CollectionsKt.toMutableList(r100);
    }

    public final void loadForwardSuccess(List<? extends Model> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ListState<List<Model>> r102 = this._dataList.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.a(ListState.State.LOAD_FORWARD_SUCCESS);
        r102.f196934h = r101;
        r102.f196928b.addAll(r100);
        this._dataList.setValue(r102);
    }

    public final void updatePalpableIndex(int r100, boolean r101) {
        if (r101 == false) goto L4;
        this._palpableIndex.a(Integer.valueOf(r100));
        return;
    L4:
        this._palpableIndex.setValue(Integer.valueOf(r100));
    }

    public final void updateTargetSegment(List<? extends Model> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        ListState<List<Model>> r102 = this._dataList.getValue();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.a(ListState.State.SERIES_SEGMENT_UPDATE);
        r102.f196928b.addAll(r100);
        r102.f196932f = r101;
        this._dataList.setValue(r102);
    }

    public static final /* synthetic */ void access$loadMoreSuccess(AosPagerListViewModel r100, List r101, boolean r102) {
        r100.loadMoreSuccess(r101, r102);
    }

    public void updateCurrentIndex(int r100, boolean r101, boolean r102) {
        Integer r103 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r103);
        this.lastSelectedIndex = r103.intValue();
        if (r101 == false) goto L5;
        this._selectedIndex.a(Integer.valueOf(r100));
        this._palpableIndex.a(Integer.valueOf(r100));
    L7:
        if (shouldPreLoad() == false) goto L13;
        if (r102 == false) goto L10;
        return;
    L10:
        if (preloadLoadMore(r100) == true) goto L15;
        preloadLoadForward(r100);
        return;
    L15:
        return;
    L13:
        return;
    L5:
        this._selectedIndex.setValue(Integer.valueOf(r100));
        this._palpableIndex.setValue(Integer.valueOf(r100));
        goto L7
    }

    public static /* synthetic */ void updatePalpableIndex$default(AosPagerListViewModel r100, int r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        r100.updatePalpableIndex(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePalpableIndex");
    }

    public static /* synthetic */ void updateCurrentIndex$default(AosPagerListViewModel r100, int r101, boolean r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = false;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = false;
    L9:
        r100.updateCurrentIndex(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentIndex");
    }

    public final void updateDataList(List<? extends Model> r110, int r111, int r112, int r113, boolean r114, boolean r115, long r116, long r117) {
        Intrinsics.checkNotNullParameter(r110, "dataList");
        updateCurrentPage(r112, r113, r116, r117);
        ListState<List<Model>> r100 = this._dataList.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.a(ListState.State.SERIES_CHOOSE_TARGET_EPISODE);
        r100.f196927a.clear();
        r100.f196928b.addAll(r110);
        r100.f196934h = r114;
        r100.f196933g = r115;
        this._dataList.setValue(r100);
    }
}
