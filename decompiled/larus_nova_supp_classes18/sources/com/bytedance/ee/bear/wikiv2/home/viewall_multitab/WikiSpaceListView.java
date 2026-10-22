package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.Functions;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002IJB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0002J\u000e\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u0002022\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u000202H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010;\u001a\u00020<H\u0003J\b\u0010F\u001a\u000202H\u0002J\b\u0010G\u001a\u000202H\u0002J\u0006\u0010H\u001a\u000205R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/wiki/IWikiSpaceListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadingViewFromXml", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getLoadingViewFromXml", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "setLoadingViewFromXml", "(Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;)V", "recyclerViewFromXml", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;", "getRecyclerViewFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;", "setRecyclerViewFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListRvView;)V", "contentViewFromXml", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getContentViewFromXml", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setContentViewFromXml", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "emptyViewFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getEmptyViewFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setEmptyViewFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "lifecycleOwner", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListViewModel;", "viewDelegate", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView$ViewDelegate;", "getViewDelegate", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView$ViewDelegate;", "setViewDelegate", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListView$ViewDelegate;)V", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;)V", "init", "", "fragment", "spaceType", "", "getRealView", "Landroid/view/View;", "initView", "bindView", "setNetworkChange", "networkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "showContent", "spaceList", "", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "showFailure", "err", "", "hideLoading", "checkRecyclerEnabled", "checkLoadmoreEnable", "bindListener", "count", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceListView extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public BearLottieView a;
    public WikiSpaceListRvView b;
    public SmartRefreshLayout c;
    public SpaceEmptyState d;
    public Fragment e;
    public WikiSpaceListViewModel f;
    public b g;
    public ce5.a h;

    public static final class a {
    }

    public interface b {
        void a(SpaceBean r1, int r2);
    }

    static {
    }

    public View getRealView() {
        return this;
    }

    public final void a() {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        WikiSpaceListViewModel r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        boolean r2 = r1.getHasmore();
        SmartRefreshLayout r3 = getContentViewFromXml();
        if (r0 == false) goto L9;
        if (r2 == false) goto L9;
        boolean r4 = true;
    L10:
        r3.g(r4);
        return;
    L9:
        r4 = false;
        goto L10
    }

    public final SmartRefreshLayout getContentViewFromXml() {
        SmartRefreshLayout r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131367862);
        this.c = r0;
    L6:
        return r0;
    }

    public final SpaceEmptyState getEmptyViewFromXml() {
        UDEmptyState r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131371607);
        this.d = (SpaceEmptyState) r0;
    L6:
        return (SpaceEmptyState) r0;
    }

    public final BearLottieView getLoadingViewFromXml() {
        BearLottieView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379091);
        this.a = r0;
    L6:
        return r0;
    }

    public final WikiSpaceListRvView getRecyclerViewFromXml() {
        RecyclerView r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384076);
        this.b = (WikiSpaceListRvView) r0;
    L6:
        return (WikiSpaceListRvView) r0;
    }

    public final ce5.a getUserComponentAbility() {
        return this.h;
    }

    public final b getViewDelegate() {
        return this.g;
    }

    public final void setContentViewFromXml(SmartRefreshLayout r1) {
        this.c = r1;
    }

    public final void setEmptyViewFromXml(SpaceEmptyState r1) {
        this.d = r1;
    }

    public final void setLoadingViewFromXml(BearLottieView r1) {
        this.a = r1;
    }

    public final void setNetworkChange(ConnectionService.NetworkState r4) {
        Intrinsics.checkNotNullParameter(r4, "networkState");
        a();
        WikiSpaceListViewModel r0 = this.f;
        WikiSpaceListViewModel r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (r0.hasData() == true) goto L9;
        return;
    L9:
        if (r4.a() == false) goto L20;
        WikiSpaceListViewModel r2 = this.f;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L14:
        if (r2.getFromDb() == false) goto L20;
        WikiSpaceListViewModel r3 = this.f;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r1.load();
        goto L20
    L18:
        r1 = r3;
    L20:
        int r5 = zp5.f.a;
        if (r4.a() == false) goto L23;
        Flowable r6 = Flowable.just(new ArrayList());
        Intrinsics.checkNotNull(r6);
    L24:
        r6.observeOn(fo5.d.d()).doOnNext(new h(this)).doFinally(new i(this, r4)).subscribe(Functions.emptyConsumer(), j.a);
        return;
    L23:
        r6 = Flowable.just("").subscribeOn(fo5.d.b()).map(zp5.b.a).map(zp5.c.a);
        Intrinsics.checkNotNull(r6);
        goto L24
    }

    public final void setRecyclerViewFromXml(WikiSpaceListRvView r1) {
        this.b = r1;
    }

    public final void setUserComponentAbility(ce5.a r1) {
        this.h = r1;
    }

    public final void setViewDelegate(b r1) {
        this.g = r1;
    }

    public WikiSpaceListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131568261, this);
    }
}
