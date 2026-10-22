package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u000bH\u0014J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0003J\b\u0010&\u001a\u00020\u000bH\u0002J.\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u000bH\u0014J\b\u0010/\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListFragment;", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/LazyFragment;", "<init>", "()V", "spaceListViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;", "getSpaceListViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;", "setSpaceListViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;)V", "clearFromXmlViewCache", "", "onDestroyView", "tab", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/TabEnum;", "parentViewModel", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", "getParentViewModel", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", "parentViewModel$delegate", "Lkotlin/Lazy;", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "bind", "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onAttachData", "initView", "bindView", "bindListener", NotificationCompat.CATEGORY_NAVIGATION, "spaceId", "", WikiFolderPushPlugin.WIKI_TOKEN, "spaceName", "wikiDocument", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiDocument;", "onDetachData", "unBind", "TAG", "getTAG", "()Ljava/lang/String;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListFragment extends LazyFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f240725m = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WikiSpaceListView f240726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TabEnum f240727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f240728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f240729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f240730l;

    public static final class a {
        public static WikiSpaceListFragment a(int r100, Bundle r101) {
            Bundle r102 = new Bundle();
            r102.putInt("space_type", r100);
            if (r101 == null) goto L5;
            r102.putAll(r101);
        L5:
            WikiSpaceListFragment r103 = new WikiSpaceListFragment();
            r103.setArguments(r102);
            return r103;
        }
    }

    static {
    }

    public final WikiSpaceListView W90() {
        View r100 = this.f240726h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.space_list_view);
    L8:
        this.f240726h = (WikiSpaceListView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiSpaceListView) r100;
    }

    public final String getTAG() {
        return "WikiSpaceListFragment_" + this.f240727i.name();
    }

    public WikiSpaceListFragment() {
        this.f240727i = TabEnum.ALL;
        this.f240728j = LazyKt.lazy(new WikiSpaceListFragment$parentViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.LazyFragment
    public final void U90() {
        tt5.a.h(getTAG(), "onAttachData.");
        if (this.f240730l == true) goto L19;
        WikiSpaceListView r100 = W90();
        int r101 = this.f240727i.getSpaceType();
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        r100.f240753e = this;
        WikiSpaceListViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.f240754f = (WikiSpaceListViewModel) new ViewModelProvider(this, new WikiSpaceListViewModel.b(r101)).get(WikiSpaceListViewModel.class);
        r100.getLoadingViewFromXml().setVisibility(0);
        r100.getRecyclerViewFromXml().setEnable(true);
        r100.getRecyclerViewFromXml().setUserComponentAbility(r100.f240756h);
        r100.getContentViewFromXml().i(new k(r100));
        r100.getContentViewFromXml().F(new LoadMoreFooter(r100.getContext()), -2);
        r100.getContentViewFromXml().g(false);
        WikiSpaceListViewModel r102 = r100.f240754f;
        Fragment r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L8:
        MutableLiveData<List<SpaceBean>> r104 = r102.getSpaceList();
        Fragment r105 = r100.f240753e;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        r105 = null;
    L11:
        r104.observe(r105, new f(r100));
        WikiSpaceListViewModel r106 = r100.f240754f;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r106 = null;
    L14:
        MutableLiveData<Throwable> r107 = r106.getFailure();
        Fragment r108 = r100.f240753e;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
    L18:
        r107.observe(r103, new g(r100));
        r100.getRecyclerViewFromXml().setViewDelegate(new e(r100));
        W90().setUserComponentAbility(new ce5.a());
        this.f240730l = true;
        goto L19
    L17:
        r103 = r108;
    L19:
        LiveData<ConnectionService.NetworkState> r109 = com.bytedance.ee.bear.contract.j.a.f217090a.a();
        this.f240729k = r109;
        if (r109 == null) goto L22;
        r109.observe(getViewLifecycleOwner(), new c(this));
    L22:
        W90().setViewDelegate(new b(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.LazyFragment
    public final void V90() {
        tt5.a.h(getTAG(), "onDetachData.");
        ((WikiSpaceTabViewModel) this.f240728j.getValue()).getSearching().removeObservers(getViewLifecycleOwner());
        ((WikiSpaceTabViewModel) this.f240728j.getValue()).getSearchInput().removeObservers(getViewLifecycleOwner());
        LiveData<ConnectionService.NetworkState> r100 = this.f240729k;
        if (r100 == null) goto L5;
        r100.removeObservers(getViewLifecycleOwner());
    L5:
        this.f240729k = null;
        W90().setViewDelegate(null);
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.LazyFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f240726h = null;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L12;
        int r102 = r101.getInt("space_type", -1);
        TabEnum.Companion.getClass();
        TabEnum r103 = TabEnum.TEAM;
        if (r102 == r103.getSpaceType()) goto L11;
        r103 = TabEnum.PERSONAL;
        if (r102 == r103.getSpaceType()) goto L11;
        r103 = TabEnum.ALL;
    L11:
        this.f240727i = r103;
    L12:
        tt5.a.h(getTAG(), "onCreate.");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_space_list_fragment_v2, r101, false);
    }
}
