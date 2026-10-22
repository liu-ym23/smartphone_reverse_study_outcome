package com.bytedance.ee.bear.templates.search.base;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.list.loadstateview.h;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.Tab2;
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
import dd5.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class BaseView implements f, TemplateAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f239368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f239369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f239370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f239371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f.a f239372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CategoryIndicatorAdapter f239373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f239374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f239375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CategoryTab f239376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConcatAdapter f239377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f239378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f239379l;

    public static final class a {
    }

    public static final class b implements LoadStateView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseView f239380a;

        public b(BaseView r100) {
            this.f239380a = r100;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
        public final void a() {
            f.a r100 = this.f239380a.f239372e;
            if (r100 == null) goto L6;
            r100.onLoadFailed();
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseView f239381a;

        public c(BaseView r100) {
            this.f239381a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            f.a r102 = this.f239381a.f239372e;
            if (r102 == null) goto L6;
            r102.Z1(r101);
            return;
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void b() {
        int r100 = w0.f468013a;
        this.f239378k = w0.b(this.f239368a);
        RecyclerView.LayoutManager r101 = ((RecyclerView) this.f239370c.findViewById(R.id.templateGroupList)).getLayoutManager();
        if (r101 != null) goto L5;
    L7:
        k().notifyDataSetChanged();
        return;
    L5:
        if ((r101 instanceof GridLayoutManager) == false) goto L7;
        ((GridLayoutManager) r101).setSpanCount(this.f239378k);
        goto L7
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void b0() {
        CategoryTab r100 = this.f239376i;
        if (r100 == null) goto L6;
        w3(r100);
        return;
    }

    public final ConcatAdapter k() {
        ConcatAdapter r100 = this.f239377j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public final h o() {
        h r100 = this.f239374g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        return null;
    }

    public void p() {
        h r100 = new h((LoadStateView) this.f239370c.findViewById(R.id.loadStateView));
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f239374g = r100;
        h r101 = o();
        EmptyCategory r102 = I7();
        LoadingCategory r103 = LoadingCategory.CATEGORY_TEMPLATE;
        r101.f228648b = r102;
        r101.f228649c = r103;
        o().e(new b(this));
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        p();
        this.f239373f = new CategoryIndicatorAdapter();
        RecyclerView r100 = (RecyclerView) this.f239370c.findViewById(R.id.categoryIndicator);
        CategoryIndicatorAdapter r101 = this.f239373f;
        CategoryIndicatorAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
        r101 = null;
    L5:
        r100.setAdapter(r101);
        ((RecyclerView) this.f239370c.findViewById(R.id.categoryIndicator)).setLayoutManager(new LinearLayoutManager(this.f239368a, 0, false));
        CategoryIndicatorAdapter r103 = this.f239373f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
    L9:
        r102.setOnItemClickListener(new com.bytedance.ee.bear.templates.search.base.b(this));
        ((RecyclerView) this.f239370c.findViewById(R.id.categoryIndicator)).setVisibility(8);
        GridLayoutManager r104 = new GridLayoutManager(this.f239368a, this.f239378k);
        r104.setSpanSizeLookup(new BaseView$initTempGroup$1(this));
        ((RecyclerView) this.f239370c.findViewById(R.id.templateGroupList)).setLayoutManager(r104);
        ConcatAdapter r105 = new ConcatAdapter(new ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(), new RecyclerView.Adapter[0]);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f239377j = r105;
        ((RecyclerView) this.f239370c.findViewById(R.id.templateGroupList)).setAdapter(k());
        ((RecyclerView) this.f239370c.findViewById(R.id.templateGroupList)).addOnScrollListener(new BaseView$initTempGroup$2(this));
        ((SmartRefreshLayout) this.f239370c.findViewById(R.id.refreshLayout)).F(new LoadMoreFooter(this.f239368a), -2);
        ((SmartRefreshLayout) this.f239370c.findViewById(R.id.refreshLayout)).i(new d(this));
        j.a.f217090a.a().observe(this.f239369b, new com.bytedance.ee.bear.templates.search.base.c(this));
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void d() {
        o().j();
    }

    public EmptyCategory I7() {
        return EmptyCategory.SEARCH_TEMPLATE;
    }

    public final FragmentActivity getActivity() {
        return this.f239368a;
    }

    public final int getType() {
        return this.f239371d;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final CategoryTab s0() {
        return this.f239376i;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void Q(boolean r100) {
        ((SmartRefreshLayout) this.f239370c.findViewById(R.id.refreshLayout)).g(r100);
        ((SmartRefreshLayout) this.f239370c.findViewById(R.id.refreshLayout)).s();
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void Z(TemplateGroupTab r100) {
        Intrinsics.checkNotNullParameter(r100, "templateGroupTab");
        ArrayList<CategoryTab> r101 = r100.getCategoryTabList();
        boolean r102 = true;
        boolean r103 = false;
        if (r101.isEmpty() == false) goto L17;
        tt5.a.h("BaseView", "showCategoryTab().. isEmpty");
        ((CoordinatorLayout) this.f239370c.findViewById(R.id.content)).setVisibility(8);
        String r104 = ((TemplateCenterViewModel) this.f239379l.getValue()).getSearchContent().getValue();
        if (r104 != null) goto L7;
    L12:
        r102 = false;
    L13:
        if (r102 == false) goto L15;
        o().i();
        return;
    L15:
        o().g();
        return;
    L7:
        if (r104.length() != 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 != true) goto L12;
    L9:
        r105 = false;
        goto L10
    L17:
        ((TemplateCenterViewModel) this.f239379l.getValue()).showFilter(Tab2.SYSTEM);
        if (this.f239375h < r101.size()) goto L20;
        CategoryTab r106 = (CategoryTab) ListProtector.get(r101, 0);
    L21:
        Intrinsics.checkNotNull(r106);
        w3(r106);
        if (r106.getCategoryList().isEmpty() == false) goto L24;
    L25:
        r103 = true;
    L26:
        String r107 = TemplateReport.f238766a;
        boolean r108 = !r103;
        JSONObject r109 = new JSONObject();
        if (r108 == false) goto L29;
        String r110 = BdpAppEventConstant.YES;
    L30:
        r109.put("template_searchresult", r110);
        TemplateReport.a().v("template_search", r109);
        return;
    L29:
        r110 = BdpAppEventConstant.NO;
        goto L30
    L24:
        if (((ao5.a) ListProtector.get(r106.getCategoryList(), 0)).f15786c.isEmpty() == false) goto L26;
    L20:
        r106 = (CategoryTab) ListProtector.get(r101, this.f239375h);
        goto L21
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void d3(boolean r100) {
        if (r100 == false) goto L4;
        ((TemplateCenterViewModel) this.f239379l.getValue()).getSearchContent().removeObservers(this.f239369b);
        ((TemplateCenterViewModel) this.f239379l.getValue()).getSearchContent().observe(this.f239369b, new c(this));
        return;
    L4:
        ((TemplateCenterViewModel) this.f239379l.getValue()).getSearchContent().removeObservers(this.f239369b);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void m(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        o().h(LoadFailCategory.TEMPLATE_FAIL);
        ((RecyclerView) this.f239370c.findViewById(R.id.categoryIndicator)).setVisibility(8);
        this.f239370c.findViewById(R.id.divider).setVisibility(8);
        ((CoordinatorLayout) this.f239370c.findViewById(R.id.content)).setVisibility(8);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f239372e = (f.a) r100;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        f.a r101 = this.f239372e;
        if (r101 == null) goto L6;
        r101.w(r100);
        return;
    }

    public final void w3(CategoryTab r110) {
        Intrinsics.checkNotNullParameter(r110, "categoryTab");
        this.f239376i = r110;
        Iterator<ao5.a> r100 = r110.getCategoryList().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if ((!r100.next().f15786c.isEmpty()) == false) goto L4;
        boolean r101 = false;
    L10:
        if (r101 == true) goto L12;
    L14:
        o().i();
        ((CoordinatorLayout) this.f239370c.findViewById(R.id.content)).setVisibility(0);
        Iterator<T> r102 = r110.getCategoryList().iterator();
    L16:
        if (r102.hasNext() == false) goto L35;
        ao5.a r103 = (ao5.a) r102.next();
        Iterator<T> r104 = k().getAdapters().iterator();
    L18:
        TemplateAdapter r105 = null;
        if (r104.hasNext() == false) goto L28;
        Object r106 = r104.next();
        RecyclerView.Adapter r107 = (RecyclerView.Adapter) r106;
        if ((r107 instanceof TemplateAdapter) == true) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L18;
    L30:
        if ((r106 instanceof TemplateAdapter) == false) goto L32;
        r105 = (TemplateAdapter) r106;
    L32:
        if (r105 != null) goto L33;
        TemplateAdapter r109 = new TemplateAdapter(this.f239369b, LayoutType.TYPE_CENTER2, "ccm_template_search_result_view_click", this.f239371d, r103.f15784a.toString(), -1);
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r109.f238760g = this;
        r109.A2(r103.a());
        k().addAdapter(r109);
        goto L16
    L33:
        r105.A2(r103.a());
        goto L16
    L23:
        if (((TemplateAdapter) r107).f238758e != (-1)) goto L25;
        r108 = true;
        goto L26
    L28:
        r106 = null;
    L35:
        List<ao5.a> r111 = r110.getCategoryList();
        r110.getSource();
        Iterator<ao5.a> r112 = r111.iterator();
    L37:
        if (r112.hasNext() == false) goto L41;
        if (r112.next().f15785b == false) goto L37;
        Q(true);
        return;
    L41:
        Q(false);
        return;
    L12:
        if (r110.getCategoryList().size() > 1) goto L14;
        tt5.a.h("BaseView", "showSingleCategoryTab().. isEmpty");
        ((CoordinatorLayout) this.f239370c.findViewById(R.id.content)).setVisibility(8);
        o().g();
        goto L35
    L8:
        r101 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        f.a r103 = this.f239372e;
        if (r103 == null) goto L6;
        r103.h(r100, r101, r102);
        return;
    }

    public BaseView(FragmentActivity r100, LifecycleOwner r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        this.f239368a = r100;
        this.f239369b = r101;
        this.f239370c = r102;
        this.f239371d = r103;
        int r104 = w0.f468013a;
        this.f239378k = w0.b(eu5.b.f474075a);
        this.f239379l = LazyKt.lazy(new BaseView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r100, TemplateV4 r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        TemplateReportV2.i(r100, r101, sbb.e.f541294e, r102, r103);
    }
}
