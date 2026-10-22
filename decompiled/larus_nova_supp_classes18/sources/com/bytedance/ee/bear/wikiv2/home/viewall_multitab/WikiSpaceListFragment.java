package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u000bH\u0014J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0003J\b\u0010&\u001a\u00020\u000bH\u0002J.\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u0010.\u001a\u00020\u000bH\u0014J\b\u0010/\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListFragment;", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/LazyFragment;", "<init>", "()V", "spaceListViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;", "getSpaceListViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;", "setSpaceListViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;)V", "clearFromXmlViewCache", "", "onDestroyView", "tab", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/TabEnum;", "parentViewModel", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", "getParentViewModel", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", "parentViewModel$delegate", "Lkotlin/Lazy;", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "bind", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onAttachData", "initView", "bindView", "bindListener", "navigation", "spaceId", "", WikiFolderPushPlugin.WIKI_TOKEN, "spaceName", "wikiDocument", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikiDocument;", "onDetachData", "unBind", "TAG", "getTAG", "()Ljava/lang/String;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListFragment extends LazyFragment {
    public static final /* synthetic */ int m = 0;
    public WikiSpaceListView h;
    public TabEnum i;
    public final Lazy j;
    public LiveData<ConnectionService.NetworkState> k;
    public boolean l;

    public static final class a {
        public static WikiSpaceListFragment a(int r2, Bundle r3) {
            Bundle r0 = new Bundle();
            r0.putInt("space_type", r2);
            if (r3 == null) goto L5;
            r0.putAll(r3);
        L5:
            WikiSpaceListFragment r4 = new WikiSpaceListFragment();
            r4.setArguments(r0);
            return r4;
        }
    }

    static {
    }

    public final WikiSpaceListView W90() {
        View r0 = this.h;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131387037);
    L8:
        this.h = (WikiSpaceListView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (WikiSpaceListView) r0;
    }

    public final String getTAG() {
        return "WikiSpaceListFragment_" + this.i.name();
    }

    public WikiSpaceListFragment() {
        this.i = TabEnum.ALL;
        this.j = LazyKt.lazy(new WikiSpaceListFragment$parentViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.LazyFragment
    public final void U90() {
        tt5.a.h(getTAG(), "onAttachData.");
        if (this.l == true) goto L19;
        WikiSpaceListView r0 = W90();
        int r1 = this.i.getSpaceType();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "fragment");
        r0.e = this;
        WikiSpaceListViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "context");
        r0.f = (WikiSpaceListViewModel) new ViewModelProvider(this, new WikiSpaceListViewModel.b(r1)).get(WikiSpaceListViewModel.class);
        r0.getLoadingViewFromXml().setVisibility(0);
        r0.getRecyclerViewFromXml().setEnable(true);
        r0.getRecyclerViewFromXml().setUserComponentAbility(r0.h);
        r0.getContentViewFromXml().i(new k(r0));
        r0.getContentViewFromXml().F(new LoadMoreFooter(r0.getContext()), -2);
        r0.getContentViewFromXml().g(false);
        WikiSpaceListViewModel r2 = r0.f;
        LifecycleOwner r4 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L8:
        MutableLiveData<List<SpaceBean>> r3 = r2.getSpaceList();
        LifecycleOwner r5 = r0.e;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        r5 = null;
    L11:
        r3.observe(r5, new f(r0));
        WikiSpaceListViewModel r6 = r0.f;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L14:
        MutableLiveData<Throwable> r7 = r6.getFailure();
        LifecycleOwner r8 = r0.e;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
    L18:
        r7.observe(r4, new g(r0));
        r0.getRecyclerViewFromXml().setViewDelegate(new e(r0));
        W90().setUserComponentAbility(new ce5.a());
        this.l = true;
        goto L19
    L17:
        r4 = r8;
    L19:
        LiveData<ConnectionService.NetworkState> r9 = com.bytedance.ee.bear.contract.j.a.a.a();
        this.k = r9;
        if (r9 == null) goto L22;
        r9.observe(getViewLifecycleOwner(), new c(this));
    L22:
        W90().setViewDelegate(new b(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.LazyFragment
    public final void V90() {
        tt5.a.h(getTAG(), "onDetachData.");
        ((WikiSpaceTabViewModel) this.j.getValue()).getSearching().removeObservers(getViewLifecycleOwner());
        ((WikiSpaceTabViewModel) this.j.getValue()).getSearchInput().removeObservers(getViewLifecycleOwner());
        LiveData<ConnectionService.NetworkState> r0 = this.k;
        if (r0 == null) goto L5;
        r0.removeObservers(getViewLifecycleOwner());
    L5:
        this.k = null;
        W90().setViewDelegate(null);
    }

    @Override // com.bytedance.ee.bear.wikiv2.home.viewall_multitab.LazyFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.h = null;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L12;
        int r5 = r4.getInt("space_type", -1);
        TabEnum.Companion.getClass();
        TabEnum r0 = TabEnum.TEAM;
        if (r5 == r0.getSpaceType()) goto L11;
        r0 = TabEnum.PERSONAL;
        if (r5 == r0.getSpaceType()) goto L11;
        r0 = TabEnum.ALL;
    L11:
        this.i = r0;
    L12:
        tt5.a.h(getTAG(), "onCreate.");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568258, r3, false);
    }
}
