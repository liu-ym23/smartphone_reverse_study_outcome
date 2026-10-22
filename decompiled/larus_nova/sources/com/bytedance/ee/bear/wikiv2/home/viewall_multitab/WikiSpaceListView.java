package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.Functions;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002IJB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0002J\u000e\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u0002022\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u000202H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010;\u001a\u00020<H\u0003J\b\u0010F\u001a\u000202H\u0002J\b\u0010G\u001a\u000202H\u0002J\u0006\u0010H\u001a\u000205R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/wiki/IWikiSpaceListView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadingViewFromXml", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getLoadingViewFromXml", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "setLoadingViewFromXml", "(Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;)V", "recyclerViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;", "getRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;", "setRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;)V", "contentViewFromXml", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getContentViewFromXml", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setContentViewFromXml", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "emptyViewFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getEmptyViewFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setEmptyViewFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "lifecycleOwner", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListViewModel;", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView$ViewDelegate;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "init", "", WidgetService.PARAM_FRAGMENT, "spaceType", "", "getRealView", "Landroid/view/View;", "initView", "bindView", "setNetworkChange", "networkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "showContent", "spaceList", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "showFailure", "err", "", "hideLoading", "checkRecyclerEnabled", "checkLoadmoreEnable", "bindListener", "count", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f240748i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BearLottieView f240749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WikiSpaceListRvView f240750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SmartRefreshLayout f240751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpaceEmptyState f240752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Fragment f240753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WikiSpaceListViewModel f240754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f240755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ce5.a f240756h;

    public static final class a {
    }

    public interface b {
        void a(SpaceBean r100, int r101);
    }

    static {
    }

    public View getRealView() {
        return this;
    }

    public final void a() {
        boolean r100 = com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a();
        WikiSpaceListViewModel r101 = this.f240754f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        boolean r102 = r101.getHasmore();
        SmartRefreshLayout r103 = getContentViewFromXml();
        if (r100 == false) goto L9;
        if (r102 == false) goto L9;
        boolean r104 = true;
    L10:
        r103.g(r104);
        return;
    L9:
        r104 = false;
        goto L10
    }

    public final SmartRefreshLayout getContentViewFromXml() {
        KeyEvent.Callback r100 = this.f240751c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.content_view);
        this.f240751c = (SmartRefreshLayout) r100;
    L6:
        return (SmartRefreshLayout) r100;
    }

    public final SpaceEmptyState getEmptyViewFromXml() {
        KeyEvent.Callback r100 = this.f240752d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.empty_view);
        this.f240752d = (SpaceEmptyState) r100;
    L6:
        return (SpaceEmptyState) r100;
    }

    public final BearLottieView getLoadingViewFromXml() {
        KeyEvent.Callback r100 = this.f240749a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.loading_view);
        this.f240749a = (BearLottieView) r100;
    L6:
        return (BearLottieView) r100;
    }

    public final WikiSpaceListRvView getRecyclerViewFromXml() {
        KeyEvent.Callback r100 = this.f240750b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.recycler_view);
        this.f240750b = (WikiSpaceListRvView) r100;
    L6:
        return (WikiSpaceListRvView) r100;
    }

    public final ce5.a getUserComponentAbility() {
        return this.f240756h;
    }

    public final b getViewDelegate() {
        return this.f240755g;
    }

    public final void setContentViewFromXml(SmartRefreshLayout r100) {
        this.f240751c = r100;
    }

    public final void setEmptyViewFromXml(SpaceEmptyState r100) {
        this.f240752d = r100;
    }

    public final void setLoadingViewFromXml(BearLottieView r100) {
        this.f240749a = r100;
    }

    public final void setNetworkChange(ConnectionService.NetworkState r100) {
        Intrinsics.checkNotNullParameter(r100, "networkState");
        a();
        WikiSpaceListViewModel r101 = this.f240754f;
        WikiSpaceListViewModel r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L6:
        if (r101.hasData() == true) goto L9;
        return;
    L9:
        if (r100.a() == false) goto L20;
        WikiSpaceListViewModel r103 = this.f240754f;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L14:
        if (r103.getFromDb() == false) goto L20;
        WikiSpaceListViewModel r104 = this.f240754f;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r102.load();
        goto L20
    L18:
        r102 = r104;
    L20:
        int r105 = zp5.f.f573192a;
        if (r100.a() == false) goto L23;
        Flowable r106 = Flowable.just(new ArrayList());
        Intrinsics.checkNotNull(r106);
    L24:
        r106.observeOn(fo5.d.d()).doOnNext(new h(this)).doFinally(new i(this, r100)).subscribe(Functions.emptyConsumer(), j.f240788a);
        return;
    L23:
        r106 = Flowable.just("").subscribeOn(fo5.d.b()).map(zp5.b.f573187a).map(zp5.c.f573188a);
        Intrinsics.checkNotNull(r106);
        goto L24
    }

    public final void setRecyclerViewFromXml(WikiSpaceListRvView r100) {
        this.f240750b = r100;
    }

    public final void setUserComponentAbility(ce5.a r100) {
        this.f240756h = r100;
    }

    public final void setViewDelegate(b r100) {
        this.f240755g = r100;
    }

    public WikiSpaceListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.wiki_space_list_view, this);
    }
}
