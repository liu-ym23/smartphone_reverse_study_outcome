package com.bytedance.ee.bear.templates.center.list.base;

import android.view.View;
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
import dd5.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseTemplateListView implements q, TemplateAdapter.c {
    public final FragmentActivity a;
    public final LifecycleOwner b;
    public final View c;
    public q.a d;
    public CategoryIndicatorAdapter e;
    public ConcatAdapter f;
    public com.bytedance.ee.bear.list.loadstateview.h g;
    public int h;
    public com.bytedance.ee.bear.bizwidget.d i;
    public CategoryTab j;
    public boolean k;
    public int l;
    public final Lazy m;

    public static final class a {
    }

    public static final class b implements LoadStateView.a {
        public b() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }
    }

    static {
    }

    public void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public abstract /* synthetic */ int getType();

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void b() {
        int r0 = w0.a;
        D(w0.b(this.a));
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void b0() {
        CategoryTab r0 = this.j;
        if (r0 == null) goto L6;
        w3(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void c0() {
        tt5.a.h("BaseTemplateListView", "hideCreateLoading()...");
        com.bytedance.ee.bear.bizwidget.d r0 = this.i;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void create() {
        com.bytedance.ee.bear.list.loadstateview.h r0 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378939));
        this.g = r0;
        EmptyCategory r1 = I7();
        LoadingCategory r2 = LoadingCategory.CATEGORY_TEMPLATE;
        r0.b = r1;
        r0.c = r2;
        com.bytedance.ee.bear.list.loadstateview.h r3 = this.g;
        Fragment r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r3 = null;
    L5:
        r3.e(new n(this));
        com.bytedance.ee.bear.list.loadstateview.h r5 = this.g;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r5 = null;
    L8:
        r5.d(p());
        CategoryIndicatorAdapter r6 = new CategoryIndicatorAdapter();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.e = r6;
        this.c.findViewById(2131365286).setAdapter(k());
        this.c.findViewById(2131365286).setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        k().setOnItemClickListener(new k(this));
        this.c.findViewById(2131365286).setVisibility(8);
        this.c.findViewById(2131369197).setVisibility(8);
        GridLayoutManager r7 = new GridLayoutManager(this.a, this.l);
        r7.setSpanSizeLookup(new BaseTemplateListView$initTempGroup$1(this));
        this.c.findViewById(2131388317).setLayoutManager(r7);
        ConcatAdapter r8 = new ConcatAdapter(new ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(), new RecyclerView.Adapter[0]);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.f = r8;
        this.c.findViewById(2131388317).setAdapter(o());
        this.c.findViewById(2131384136).F(new LoadMoreFooter(this.a), -2);
        this.c.findViewById(2131384136).i(new o(this));
        if (ForsetiHelper.t(this.a) == false) goto L28;
        LifecycleOwner r9 = this.b;
        if ((r9 instanceof Fragment) == false) goto L14;
        r4 = (Fragment) r9;
    L14:
        if (r4 == null) goto L29;
        ForsetiViewModel r10 = ForsetiHelper.j(r4);
        if (r10 == null) goto L21;
        LiveData r11 = r10.getViewMode();
        if (r11 == null) goto L21;
        r11.observe(r4, new l(this));
    L21:
        if (r10 == null) goto L26;
        LiveData r12 = r10.getSecondNodeWidth();
        if (r12 == null) goto L27;
        r12.observe(r4, new m(this));
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
        com.bytedance.ee.bear.list.loadstateview.h r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r0 = null;
    L5:
        r0.j();
    }

    public final CategoryIndicatorAdapter k() {
        CategoryIndicatorAdapter r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
        return null;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void k0() {
        tt5.a.h("BaseTemplateListView", "showCreateLoading()...");
        if (this.i != null) goto L5;
        com.bytedance.ee.bear.bizwidget.d r0 = new com.bytedance.ee.bear.bizwidget.d(this.a);
        this.i = r0;
        r0.e = 2131887993;
    L5:
        com.bytedance.ee.bear.bizwidget.d r1 = this.i;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    public final ConcatAdapter o() {
        ConcatAdapter r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public LoadStateView.a p() {
        return new b();
    }

    public final TemplateCenterViewModel s() {
        return (TemplateCenterViewModel) this.m.getValue();
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final CategoryTab s0() {
        return this.j;
    }

    public final void D(int r2) {
        if (this.l == r2) goto L5;
        boolean r0 = true;
    L6:
        this.l = r2;
        if (r0 == false) goto L15;
        tt5.a.h("BaseTemplateListView", "refreshListLayout");
        GridLayoutManager r3 = this.c.findViewById(2131388317).getLayoutManager();
        if (r3 != null) goto L11;
    L13:
        o().notifyDataSetChanged();
        return;
    L11:
        if ((r3 instanceof GridLayoutManager) == false) goto L13;
        r3.setSpanCount(this.l);
        goto L13
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void H0(int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        if (r4 >= k().getItemCount()) goto L12;
        Object r0 = ListProtector.get(k().getData(), r4);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.data.CategoryTab");
        CategoryTab r1 = (CategoryTab) r0;
        CategoryIndicatorAdapter r2 = k();
        r2.a = r4;
        r2.notifyDataSetChanged();
        this.c.findViewById(2131365286).scrollToPosition(r4);
        w3(r1);
        q.a r3 = this.d;
        if (r3 == null) goto L9;
        r3.V6(r1);
    L9:
        this.h = r4;
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Q(boolean r3) {
        this.c.findViewById(2131384136).g(r3);
        this.c.findViewById(2131384136).s();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Y1(TemplateGroupTab r6) {
        Intrinsics.checkNotNullParameter(r6, "templateGroupTab");
        ArrayList<CategoryTab> r0 = r6.getCategoryTabList();
        int r1 = 0;
        this.k = false;
        Iterator<CategoryTab> r2 = r0.iterator();
    L3:
        boolean r4 = true;
        if (r2.hasNext() == false) goto L12;
        if (r2.next().getCategoryTabName().length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L3;
        this.k = true;
        goto L3
    L8:
        r3 = false;
        goto L9
    L12:
        if (this.k == true) goto L14;
    L16:
        r4 = false;
    L17:
        this.k = r4;
        RecyclerView r7 = this.c.findViewById(2131365286);
        if (this.k == true) goto L21;
        r1 = 8;
    L21:
        r7.setVisibility(r1);
        this.c.findViewById(2131369197).setVisibility(8);
        k().setNewData(r0);
        return;
    L14:
        if (r6.getHasData() == false) goto L16;
        goto L16
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Z(TemplateGroupTab r4) {
        Intrinsics.checkNotNullParameter(r4, "templateGroupTab");
        ArrayList<CategoryTab> r5 = r4.getCategoryTabList();
        s().showFilter(getTab());
        if (r5.isEmpty() == false) goto L18;
        tt5.a.h("BaseTemplateListView", "showCategoryTab().. isEmpty");
        this.c.findViewById(2131367794).setVisibility(8);
        if (H3() == false) goto L7;
        EmptyCategory r6 = I7();
    L8:
        com.bytedance.ee.bear.list.loadstateview.h r0 = this.g;
        com.bytedance.ee.bear.list.loadstateview.h r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r0 = null;
    L11:
        r0.f(r6);
        com.bytedance.ee.bear.list.loadstateview.h r7 = this.g;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L15:
        r1.g();
        return;
    L14:
        r1 = r7;
        goto L15
    L7:
        r6 = EmptyCategory.SYSTEM_TEMPLATE;
        goto L8
    L18:
        if (this.h < r5.size()) goto L20;
        CategoryTab r8 = (CategoryTab) ListProtector.get(r5, 0);
    L21:
        Intrinsics.checkNotNull(r8);
        w3(r8);
        return;
    L20:
        r8 = (CategoryTab) ListProtector.get(r5, this.h);
        goto L21
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void m(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        com.bytedance.ee.bear.list.loadstateview.h r4 = this.g;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r4 = null;
    L5:
        r4.h(LoadFailCategory.TEMPLATE_FAIL);
        this.c.findViewById(2131365286).setVisibility(8);
        this.c.findViewById(2131369197).setVisibility(8);
        this.c.findViewById(2131367794).setVisibility(8);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (q.a) r1;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
        q.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.w(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public void w3(CategoryTab r20) {
        Intrinsics.checkNotNullParameter(r20, "categoryTab");
        Iterator r2 = o().getAdapters().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        o().removeAdapter((RecyclerView.Adapter) r2.next());
        goto L4
    L6:
        this.j = r20;
        M4().getClass();
        Iterator<ao5.a> r3 = r20.getCategoryList().iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        if ((!r3.next().c.isEmpty()) == false) goto L8;
        boolean r4 = false;
    L13:
        com.bytedance.ee.bear.list.loadstateview.h r7 = null;
        if (r4 == true) goto L16;
    L25:
        com.bytedance.ee.bear.list.loadstateview.h r5 = this.g;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r5 = null;
    L28:
        r5.i();
        this.c.findViewById(2131367794).setVisibility(0);
        Iterator<T> r6 = r20.getCategoryList().iterator();
    L30:
        if (r6.hasNext() == false) goto L50;
        ao5.a r8 = (ao5.a) r6.next();
        long r9 = r8.d;
        Iterator r10 = o().getAdapters().iterator();
    L33:
        if (r10.hasNext() == false) goto L42;
        Object r11 = r10.next();
        RecyclerView.Adapter r12 = (RecyclerView.Adapter) r11;
        if ((r12 instanceof TemplateAdapter) == true) goto L37;
    L39:
        boolean r13 = false;
    L40:
        if (r13 == false) goto L33;
    L44:
        if ((r11 instanceof TemplateAdapter) == false) goto L46;
        TemplateAdapter r14 = (TemplateAdapter) r11;
    L47:
        if (r14 != null) goto L48;
        TemplateAdapter r15 = new TemplateAdapter(this.b, LayoutType.TYPE_CENTER2, null, getType(), r8.a.toString(), r8.d);
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r15.g = this;
        r15.A2(r8.a());
        o().addAdapter(r15);
        goto L30
    L48:
        r14.A2(r8.a());
        goto L30
    L46:
        r14 = null;
        goto L47
    L37:
        if (((TemplateAdapter) r12).e != r9) goto L39;
        r13 = true;
        goto L40
    L42:
        r11 = null;
        goto L44
    L50:
        o().notifyDataSetChanged();
    L51:
        List<ao5.a> r16 = r20.getCategoryList();
        r20.getSource();
        Iterator<ao5.a> r1 = r16.iterator();
    L53:
        if (r1.hasNext() == false) goto L57;
        if (r1.next().b == false) goto L53;
        Q(true);
        return;
    L57:
        Q(false);
        return;
    L16:
        if (r20.getCategoryList().size() > 1) goto L25;
        tt5.a.h("BaseTemplateListView", "showSingleCategoryTab().. isEmpty");
        this.c.findViewById(2131367794).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r17 = this.g;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r17 = null;
    L20:
        r17.f(EmptyCategory.SINGLE_CATEGORY_TEMPLATE);
        com.bytedance.ee.bear.list.loadstateview.h r18 = this.g;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L24:
        r7.g();
        goto L51
    L23:
        r7 = r18;
        goto L24
    L12:
        r4 = true;
        goto L13
    }

    public BaseTemplateListView(FragmentActivity r2, LifecycleOwner r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        int r5 = w0.a;
        this.l = w0.b(eu5.b.a);
        this.m = LazyKt.lazy(new BaseTemplateListView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r2, TemplateV4 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        q.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.h(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r2, TemplateV4 r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r0 = TemplateReportV2.a;
        TemplateReportV2.i(r2, r3, M4(), r4, r5);
    }
}
