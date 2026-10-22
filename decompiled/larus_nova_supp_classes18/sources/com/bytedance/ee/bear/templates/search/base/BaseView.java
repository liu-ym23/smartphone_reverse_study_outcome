package com.bytedance.ee.bear.templates.search.base;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
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
import dd5.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseView implements f, TemplateAdapter.c {
    public final FragmentActivity a;
    public final LifecycleOwner b;
    public final View c;
    public final int d;
    public f.a e;
    public CategoryIndicatorAdapter f;
    public h g;
    public int h;
    public CategoryTab i;
    public ConcatAdapter j;
    public int k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements LoadStateView.c {
        public final /* synthetic */ BaseView a;

        public b(BaseView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
        public final void a() {
            f.a r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.onLoadFailed();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BaseView a;

        public c(BaseView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            String r3 = (String) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            f.a r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.Z1(r3);
            return;
        }
    }

    static {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void b() {
        int r0 = w0.a;
        this.k = w0.b(this.a);
        GridLayoutManager r1 = this.c.findViewById(2131388317).getLayoutManager();
        if (r1 != null) goto L5;
    L7:
        k().notifyDataSetChanged();
        return;
    L5:
        if ((r1 instanceof GridLayoutManager) == false) goto L7;
        r1.setSpanCount(this.k);
        goto L7
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void b0() {
        CategoryTab r0 = this.i;
        if (r0 == null) goto L6;
        w3(r0);
        return;
    }

    public final ConcatAdapter k() {
        ConcatAdapter r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public final h o() {
        h r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        return null;
    }

    public void p() {
        h r0 = new h((LoadStateView) this.c.findViewById(2131378939));
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.g = r0;
        h r1 = o();
        EmptyCategory r2 = I7();
        LoadingCategory r3 = LoadingCategory.CATEGORY_TEMPLATE;
        r1.b = r2;
        r1.c = r3;
        o().e(new b(this));
    }

    public final void create() {
        p();
        this.f = new CategoryIndicatorAdapter();
        RecyclerView r0 = this.c.findViewById(2131365286);
        RecyclerView.Adapter r2 = this.f;
        CategoryIndicatorAdapter r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
        r2 = null;
    L5:
        r0.setAdapter(r2);
        this.c.findViewById(2131365286).setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        CategoryIndicatorAdapter r1 = this.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
    L9:
        r3.setOnItemClickListener(new com.bytedance.ee.bear.templates.search.base.b(this));
        this.c.findViewById(2131365286).setVisibility(8);
        GridLayoutManager r4 = new GridLayoutManager(this.a, this.k);
        r4.setSpanSizeLookup(new BaseView$initTempGroup$1(this));
        this.c.findViewById(2131388317).setLayoutManager(r4);
        ConcatAdapter r5 = new ConcatAdapter(new ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(), new RecyclerView.Adapter[0]);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.j = r5;
        this.c.findViewById(2131388317).setAdapter(k());
        this.c.findViewById(2131388317).addOnScrollListener(new BaseView$initTempGroup$2(this));
        this.c.findViewById(2131384136).F(new LoadMoreFooter(this.a), -2);
        this.c.findViewById(2131384136).i(new d(this));
        j.a.a.a().observe(this.b, new com.bytedance.ee.bear.templates.search.base.c(this));
        return;
    L8:
        r3 = r1;
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
        return this.a;
    }

    public final int getType() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final CategoryTab s0() {
        return this.i;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void Q(boolean r3) {
        this.c.findViewById(2131384136).g(r3);
        this.c.findViewById(2131384136).s();
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void Z(TemplateGroupTab r5) {
        Intrinsics.checkNotNullParameter(r5, "templateGroupTab");
        ArrayList<CategoryTab> r6 = r5.getCategoryTabList();
        boolean r1 = true;
        boolean r2 = false;
        if (r6.isEmpty() == false) goto L17;
        tt5.a.h("BaseView", "showCategoryTab().. isEmpty");
        this.c.findViewById(2131367794).setVisibility(8);
        String r7 = (String) ((TemplateCenterViewModel) this.l.getValue()).getSearchContent().getValue();
        if (r7 != null) goto L7;
    L12:
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        o().i();
        return;
    L15:
        o().g();
        return;
    L7:
        if (r7.length() != 0) goto L9;
        boolean r8 = true;
    L10:
        if (r8 != true) goto L12;
    L9:
        r8 = false;
        goto L10
    L17:
        ((TemplateCenterViewModel) this.l.getValue()).showFilter(Tab2.SYSTEM);
        if (this.h < r6.size()) goto L20;
        CategoryTab r9 = (CategoryTab) ListProtector.get(r6, 0);
    L21:
        Intrinsics.checkNotNull(r9);
        w3(r9);
        if (r9.getCategoryList().isEmpty() == false) goto L24;
    L25:
        r2 = true;
    L26:
        String r10 = TemplateReport.a;
        boolean r11 = !r2;
        JSONObject r0 = new JSONObject();
        if (r11 == false) goto L29;
        String r12 = "yes";
    L30:
        r0.put("template_searchresult", r12);
        TemplateReport.a().v("template_search", r0);
        return;
    L29:
        r12 = "no";
        goto L30
    L24:
        if (((ao5.a) ListProtector.get(r9.getCategoryList(), 0)).c.isEmpty() == false) goto L26;
    L20:
        r9 = (CategoryTab) ListProtector.get(r6, this.h);
        goto L21
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void d3(boolean r3) {
        if (r3 == false) goto L4;
        ((TemplateCenterViewModel) this.l.getValue()).getSearchContent().removeObservers(this.b);
        ((TemplateCenterViewModel) this.l.getValue()).getSearchContent().observe(this.b, new c(this));
        return;
    L4:
        ((TemplateCenterViewModel) this.l.getValue()).getSearchContent().removeObservers(this.b);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.f
    public final void m(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        o().h(LoadFailCategory.TEMPLATE_FAIL);
        this.c.findViewById(2131365286).setVisibility(8);
        this.c.findViewById(2131369197).setVisibility(8);
        this.c.findViewById(2131367794).setVisibility(8);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (f.a) r1;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
        f.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.w(r2);
        return;
    }

    public final void w3(CategoryTab r18) {
        Intrinsics.checkNotNullParameter(r18, "categoryTab");
        this.i = r18;
        Iterator<ao5.a> r2 = r18.getCategoryList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if ((!r2.next().c.isEmpty()) == false) goto L4;
        boolean r3 = false;
    L10:
        if (r3 == true) goto L12;
    L14:
        o().i();
        this.c.findViewById(2131367794).setVisibility(0);
        Iterator<T> r4 = r18.getCategoryList().iterator();
    L16:
        if (r4.hasNext() == false) goto L35;
        ao5.a r5 = (ao5.a) r4.next();
        Iterator r6 = k().getAdapters().iterator();
    L18:
        TemplateAdapter r8 = null;
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();
        RecyclerView.Adapter r9 = (RecyclerView.Adapter) r7;
        if ((r9 instanceof TemplateAdapter) == true) goto L23;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == false) goto L18;
    L30:
        if ((r7 instanceof TemplateAdapter) == false) goto L32;
        r8 = (TemplateAdapter) r7;
    L32:
        if (r8 != null) goto L33;
        TemplateAdapter r11 = new TemplateAdapter(this.b, LayoutType.TYPE_CENTER2, "ccm_template_search_result_view_click", this.d, r5.a.toString(), -1);
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r11.g = this;
        r11.A2(r5.a());
        k().addAdapter(r11);
        goto L16
    L33:
        r8.A2(r5.a());
        goto L16
    L23:
        if (((TemplateAdapter) r9).e != (-1)) goto L25;
        r10 = true;
        goto L26
    L28:
        r7 = null;
    L35:
        List<ao5.a> r12 = r18.getCategoryList();
        r18.getSource();
        Iterator<ao5.a> r1 = r12.iterator();
    L37:
        if (r1.hasNext() == false) goto L41;
        if (r1.next().b == false) goto L37;
        Q(true);
        return;
    L41:
        Q(false);
        return;
    L12:
        if (r18.getCategoryList().size() > 1) goto L14;
        tt5.a.h("BaseView", "showSingleCategoryTab().. isEmpty");
        this.c.findViewById(2131367794).setVisibility(8);
        o().g();
        goto L35
    L8:
        r3 = true;
        goto L10
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r2, TemplateV4 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        f.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.h(r2, r3, r4);
        return;
    }

    public BaseView(FragmentActivity r2, LifecycleOwner r3, View r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        int r6 = w0.a;
        this.k = w0.b(eu5.b.a);
        this.l = LazyKt.lazy(new BaseView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r2, TemplateV4 r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r0 = TemplateReportV2.a;
        TemplateReportV2.i(r2, r3, sbb.e.e, r4, r5);
    }
}
