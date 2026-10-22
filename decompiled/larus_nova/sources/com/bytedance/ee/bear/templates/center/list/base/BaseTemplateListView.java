package com.bytedance.ee.bear.templates.center.list.base;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.center.list.CategoryIndicatorAdapter;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import dd5.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseTemplateListView implements q, TemplateAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f238978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f238979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f238980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q.a f238981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CategoryIndicatorAdapter f238982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConcatAdapter f238983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f238984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f238985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.bizwidget.d f238986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CategoryTab f238987j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f238988k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f238989l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f238990m;

    public static final class a {
    }

    public static final class b implements LoadStateView.a {
        public b() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r100) {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public abstract /* synthetic */ int getType();

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void b() {
        int r100 = w0.f468013a;
        D(w0.b(this.f238978a));
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void b0() {
        CategoryTab r100 = this.f238987j;
        if (r100 == null) goto L6;
        w3(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void c0() {
        tt5.a.h("BaseTemplateListView", "hideCreateLoading()...");
        com.bytedance.ee.bear.bizwidget.d r100 = this.f238986i;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
        com.bytedance.ee.bear.list.loadstateview.h r100 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f238980c.findViewById(R.id.loadStateView));
        this.f238984g = r100;
        EmptyCategory r101 = I7();
        LoadingCategory r102 = LoadingCategory.CATEGORY_TEMPLATE;
        r100.f228648b = r101;
        r100.f228649c = r102;
        com.bytedance.ee.bear.list.loadstateview.h r103 = this.f238984g;
        Fragment r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r103 = null;
    L5:
        r103.e(new n(this));
        com.bytedance.ee.bear.list.loadstateview.h r105 = this.f238984g;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r105 = null;
    L8:
        r105.d(p());
        CategoryIndicatorAdapter r106 = new CategoryIndicatorAdapter();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f238982e = r106;
        ((RecyclerView) this.f238980c.findViewById(R.id.categoryIndicator)).setAdapter(k());
        ((RecyclerView) this.f238980c.findViewById(R.id.categoryIndicator)).setLayoutManager(new LinearLayoutManager(this.f238978a, 0, false));
        k().setOnItemClickListener(new k(this));
        ((RecyclerView) this.f238980c.findViewById(R.id.categoryIndicator)).setVisibility(8);
        this.f238980c.findViewById(R.id.divider).setVisibility(8);
        GridLayoutManager r107 = new GridLayoutManager(this.f238978a, this.f238989l);
        r107.setSpanSizeLookup(new BaseTemplateListView$initTempGroup$1(this));
        ((RecyclerView) this.f238980c.findViewById(R.id.templateGroupList)).setLayoutManager(r107);
        ConcatAdapter r108 = new ConcatAdapter(new ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(), new RecyclerView.Adapter[0]);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f238983f = r108;
        ((RecyclerView) this.f238980c.findViewById(R.id.templateGroupList)).setAdapter(o());
        ((SmartRefreshLayout) this.f238980c.findViewById(R.id.refreshLayout)).F(new LoadMoreFooter(this.f238978a), -2);
        ((SmartRefreshLayout) this.f238980c.findViewById(R.id.refreshLayout)).i(new o(this));
        if (ForsetiHelper.t(this.f238978a) == false) goto L28;
        LifecycleOwner r109 = this.f238979b;
        if ((r109 instanceof Fragment) == false) goto L14;
        r104 = (Fragment) r109;
    L14:
        if (r104 == null) goto L29;
        ForsetiViewModel r110 = ForsetiHelper.j(r104);
        if (r110 == null) goto L21;
        LiveData<ForsetiViewMode> r111 = r110.getViewMode();
        if (r111 == null) goto L21;
        r111.observe(r104, new l(this));
    L21:
        if (r110 == null) goto L26;
        LiveData<Integer> r112 = r110.getSecondNodeWidth();
        if (r112 == null) goto L27;
        r112.observe(r104, new m(this));
        return;
    L27:
        return;
    L26:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void d() {
        com.bytedance.ee.bear.list.loadstateview.h r100 = this.f238984g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r100 = null;
    L5:
        r100.j();
    }

    public final CategoryIndicatorAdapter k() {
        CategoryIndicatorAdapter r100 = this.f238982e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
        return null;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void k0() {
        tt5.a.h("BaseTemplateListView", "showCreateLoading()...");
        if (this.f238986i != null) goto L5;
        com.bytedance.ee.bear.bizwidget.d r100 = new com.bytedance.ee.bear.bizwidget.d(this.f238978a);
        this.f238986i = r100;
        r100.f216371e = R.string.Doc_List_TemplateClickLoadingToast;
    L5:
        com.bytedance.ee.bear.bizwidget.d r101 = this.f238986i;
        if (r101 == null) goto L9;
        r101.b();
        return;
    }

    public final ConcatAdapter o() {
        ConcatAdapter r100 = this.f238983f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public LoadStateView.a p() {
        return new b();
    }

    public final TemplateCenterViewModel s() {
        return (TemplateCenterViewModel) this.f238990m.getValue();
    }

    public final FragmentActivity getActivity() {
        return this.f238978a;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final CategoryTab s0() {
        return this.f238987j;
    }

    public final void D(int r100) {
        if (this.f238989l == r100) goto L5;
        boolean r101 = true;
    L6:
        this.f238989l = r100;
        if (r101 == false) goto L15;
        tt5.a.h("BaseTemplateListView", "refreshListLayout");
        RecyclerView.LayoutManager r102 = ((RecyclerView) this.f238980c.findViewById(R.id.templateGroupList)).getLayoutManager();
        if (r102 != null) goto L11;
    L13:
        o().notifyDataSetChanged();
        return;
    L11:
        if ((r102 instanceof GridLayoutManager) == false) goto L13;
        ((GridLayoutManager) r102).setSpanCount(this.f238989l);
        goto L13
    L15:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void H0(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= k().getItemCount()) goto L12;
        Object r101 = ListProtector.get(k().getData(), r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.data.CategoryTab");
        CategoryTab r102 = (CategoryTab) r101;
        CategoryIndicatorAdapter r103 = k();
        r103.f238940a = r100;
        r103.notifyDataSetChanged();
        ((RecyclerView) this.f238980c.findViewById(R.id.categoryIndicator)).scrollToPosition(r100);
        w3(r102);
        q.a r104 = this.f238981d;
        if (r104 == null) goto L9;
        r104.V6(r102);
    L9:
        this.f238985h = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Q(boolean r100) {
        ((SmartRefreshLayout) this.f238980c.findViewById(R.id.refreshLayout)).g(r100);
        ((SmartRefreshLayout) this.f238980c.findViewById(R.id.refreshLayout)).s();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Y1(TemplateGroupTab r100) {
        Intrinsics.checkNotNullParameter(r100, "templateGroupTab");
        ArrayList<CategoryTab> r101 = r100.getCategoryTabList();
        int r102 = 0;
        this.f238988k = false;
        Iterator<CategoryTab> r103 = r101.iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L12;
        if (r103.next().getCategoryTabName().length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
        this.f238988k = true;
        goto L3
    L8:
        r105 = false;
        goto L9
    L12:
        if (this.f238988k == true) goto L14;
    L16:
        r104 = false;
    L17:
        this.f238988k = r104;
        RecyclerView r106 = (RecyclerView) this.f238980c.findViewById(R.id.categoryIndicator);
        if (this.f238988k == true) goto L21;
        r102 = 8;
    L21:
        r106.setVisibility(r102);
        this.f238980c.findViewById(R.id.divider).setVisibility(8);
        k().setNewData(r101);
        return;
    L14:
        if (r100.getHasData() == false) goto L16;
        goto L16
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Z(TemplateGroupTab r100) {
        Intrinsics.checkNotNullParameter(r100, "templateGroupTab");
        ArrayList<CategoryTab> r101 = r100.getCategoryTabList();
        s().showFilter(getTab());
        if (r101.isEmpty() == false) goto L18;
        tt5.a.h("BaseTemplateListView", "showCategoryTab().. isEmpty");
        ((CoordinatorLayout) this.f238980c.findViewById(R.id.content)).setVisibility(8);
        if (H3() == false) goto L7;
        EmptyCategory r102 = I7();
    L8:
        com.bytedance.ee.bear.list.loadstateview.h r103 = this.f238984g;
        com.bytedance.ee.bear.list.loadstateview.h r104 = null;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r103 = null;
    L11:
        r103.f(r102);
        com.bytedance.ee.bear.list.loadstateview.h r105 = this.f238984g;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L15:
        r104.g();
        return;
    L14:
        r104 = r105;
        goto L15
    L7:
        r102 = EmptyCategory.SYSTEM_TEMPLATE;
        goto L8
    L18:
        if (this.f238985h < r101.size()) goto L20;
        CategoryTab r106 = (CategoryTab) ListProtector.get(r101, 0);
    L21:
        Intrinsics.checkNotNull(r106);
        w3(r106);
        return;
    L20:
        r106 = (CategoryTab) ListProtector.get(r101, this.f238985h);
        goto L21
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void m(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.ee.bear.list.loadstateview.h r101 = this.f238984g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r101 = null;
    L5:
        r101.h(LoadFailCategory.TEMPLATE_FAIL);
        ((RecyclerView) this.f238980c.findViewById(R.id.categoryIndicator)).setVisibility(8);
        this.f238980c.findViewById(R.id.divider).setVisibility(8);
        ((CoordinatorLayout) this.f238980c.findViewById(R.id.content)).setVisibility(8);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f238981d = (q.a) r100;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        q.a r101 = this.f238981d;
        if (r101 == null) goto L6;
        r101.w(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public void w3(CategoryTab r210) {
        Intrinsics.checkNotNullParameter(r210, "categoryTab");
        Iterator<T> r100 = o().getAdapters().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        o().removeAdapter((RecyclerView.Adapter) r100.next());
        goto L4
    L6:
        this.f238987j = r210;
        M4().getClass();
        Iterator<ao5.a> r101 = r210.getCategoryList().iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        if ((!r101.next().f15786c.isEmpty()) == false) goto L8;
        boolean r102 = false;
    L13:
        com.bytedance.ee.bear.list.loadstateview.h r103 = null;
        if (r102 == true) goto L16;
    L25:
        com.bytedance.ee.bear.list.loadstateview.h r104 = this.f238984g;
        if (r104 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r104 = null;
    L28:
        r104.i();
        ((CoordinatorLayout) this.f238980c.findViewById(R.id.content)).setVisibility(0);
        Iterator<T> r105 = r210.getCategoryList().iterator();
    L30:
        if (r105.hasNext() == false) goto L50;
        ao5.a r106 = (ao5.a) r105.next();
        long r107 = r106.f15787d;
        Iterator<T> r108 = o().getAdapters().iterator();
    L33:
        if (r108.hasNext() == false) goto L42;
        Object r110 = r108.next();
        RecyclerView.Adapter r111 = (RecyclerView.Adapter) r110;
        if ((r111 instanceof TemplateAdapter) == true) goto L37;
    L39:
        boolean r112 = false;
    L40:
        if (r112 == false) goto L33;
    L44:
        if ((r110 instanceof TemplateAdapter) == false) goto L46;
        TemplateAdapter r113 = (TemplateAdapter) r110;
    L47:
        if (r113 != null) goto L48;
        TemplateAdapter r109 = new TemplateAdapter(this.f238979b, LayoutType.TYPE_CENTER2, null, getType(), r106.f15784a.toString(), r106.f15787d);
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r109.f238760g = this;
        r109.A2(r106.a());
        o().addAdapter(r109);
        goto L30
    L48:
        r113.A2(r106.a());
        goto L30
    L46:
        r113 = null;
        goto L47
    L37:
        if (((TemplateAdapter) r111).f238758e != r107) goto L39;
        r112 = true;
        goto L40
    L42:
        r110 = null;
        goto L44
    L50:
        o().notifyDataSetChanged();
    L51:
        List<ao5.a> r114 = r210.getCategoryList();
        r210.getSource();
        Iterator<ao5.a> r115 = r114.iterator();
    L53:
        if (r115.hasNext() == false) goto L57;
        if (r115.next().f15785b == false) goto L53;
        Q(true);
        return;
    L57:
        Q(false);
        return;
    L16:
        if (r210.getCategoryList().size() > 1) goto L25;
        tt5.a.h("BaseTemplateListView", "showSingleCategoryTab().. isEmpty");
        ((CoordinatorLayout) this.f238980c.findViewById(R.id.content)).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r116 = this.f238984g;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r116 = null;
    L20:
        r116.f(EmptyCategory.SINGLE_CATEGORY_TEMPLATE);
        com.bytedance.ee.bear.list.loadstateview.h r117 = this.f238984g;
        if (r117 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L24:
        r103.g();
        goto L51
    L23:
        r103 = r117;
        goto L24
    L12:
        r102 = true;
        goto L13
    }

    public BaseTemplateListView(FragmentActivity r100, LifecycleOwner r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        this.f238978a = r100;
        this.f238979b = r101;
        this.f238980c = r102;
        int r103 = w0.f468013a;
        this.f238989l = w0.b(eu5.b.f474075a);
        this.f238990m = LazyKt.lazy(new BaseTemplateListView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        q.a r103 = this.f238981d;
        if (r103 == null) goto L6;
        r103.h(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r100, TemplateV4 r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        TemplateReportV2.i(r100, r101, M4(), r102, r103);
    }
}
