package com.bytedance.ee.bear.bitable.homepage.recommend;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
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

/* JADX INFO: loaded from: classes15.dex */
public abstract class BaseHomePageDiscoveryTemplateListView implements com.bytedance.ee.bear.templates.center.list.base.q, TemplateAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f212917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f212918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f212919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f212920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.templates.center.list.base.q.a f212921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HomePageDiscoveryCategoryIndicatorAdapter f212922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConcatAdapter f212923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f212924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f212925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.bizwidget.d f212926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CategoryTab f212927k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f212928l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f212929m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SmartRefreshLayout f212930n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f212931o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RecyclerView f212932p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LoadStateView f212933q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f212934r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f212935s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f212936t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f212937u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f212938v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f212939w;

    public static final class a {
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
        this.f212938v = w0.b(this.f212917a);
        RecyclerView r101 = this.f212932p;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("templateGroupList");
        r101 = null;
    L5:
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
        if (r102 != null) goto L8;
    L10:
        o().notifyDataSetChanged();
        return;
    L8:
        if ((r102 instanceof GridLayoutManager) == false) goto L10;
        ((GridLayoutManager) r102).setSpanCount(this.f212938v);
        goto L10
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void b0() {
        CategoryTab r100 = this.f212927k;
        if (r100 == null) goto L6;
        w3(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void c0() {
        tt5.a.h("BaseTemplateListView", "hideCreateLoading()...");
        com.bytedance.ee.bear.bizwidget.d r100 = this.f212926j;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
        this.f212933q = (LoadStateView) this.f212919c.findViewById(R.id.loadStateView);
        this.f212931o = (RecyclerView) this.f212919c.findViewById(R.id.categoryIndicator);
        this.f212932p = (RecyclerView) this.f212919c.findViewById(R.id.templateGroupList);
        this.f212930n = (SmartRefreshLayout) this.f212919c.findViewById(R.id.refreshLayout);
        this.f212934r = this.f212919c.findViewById(R.id.divider);
        this.f212935s = this.f212919c.findViewById(R.id.content);
        LoadStateView r100 = this.f212933q;
        SmartRefreshLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateView");
        r100 = null;
    L5:
        com.bytedance.ee.bear.list.loadstateview.h r102 = new com.bytedance.ee.bear.list.loadstateview.h(r100);
        this.f212924h = r102;
        EmptyCategory r103 = EmptyCategory.SYSTEM_TEMPLATE;
        LoadingCategory r104 = LoadingCategory.CATEGORY_TEMPLATE;
        r102.f228648b = r103;
        r102.f228649c = r104;
        r102.e(new c(this));
        com.bytedance.ee.bear.list.loadstateview.h r105 = this.f212924h;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r105 = null;
    L8:
        r105.d(new com.bytedance.ee.bear.bitable.homepage.recommend.a());
        HomePageDiscoveryCategoryIndicatorAdapter r106 = new HomePageDiscoveryCategoryIndicatorAdapter();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f212922f = r106;
        RecyclerView r107 = this.f212931o;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicator");
        r107 = null;
    L11:
        r107.setAdapter(k());
        RecyclerView r108 = this.f212931o;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicator");
        r108 = null;
    L14:
        r108.setLayoutManager(new LinearLayoutManager(this.f212917a, 0, false));
        k().setOnItemClickListener(new b(this));
        RecyclerView r109 = this.f212931o;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicator");
        r109 = null;
    L17:
        r109.setVisibility(8);
        View r110 = this.f212934r;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
        r110 = null;
    L20:
        r110.setVisibility(8);
        GridLayoutManager r111 = new GridLayoutManager(this.f212917a, this.f212938v);
        r111.setSpanSizeLookup(new BaseHomePageDiscoveryTemplateListView$initTempGroup$1(this));
        RecyclerView r112 = this.f212932p;
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("templateGroupList");
        r112 = null;
    L23:
        r112.setLayoutManager(r111);
        ConcatAdapter r113 = new ConcatAdapter(new ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(), new RecyclerView.Adapter[0]);
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        this.f212923g = r113;
        RecyclerView r114 = this.f212932p;
        if (r114 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("templateGroupList");
        r114 = null;
    L26:
        r114.setAdapter(o());
        SmartRefreshLayout r115 = this.f212930n;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r115 = null;
    L29:
        r115.F(new LoadMoreFooter(this.f212917a), -2);
        SmartRefreshLayout r116 = this.f212930n;
        if (r116 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
    L33:
        r101.i(new d(this));
        return;
    L32:
        r101 = r116;
        goto L33
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void d() {
        com.bytedance.ee.bear.list.loadstateview.h r100 = this.f212924h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r100 = null;
    L5:
        r100.j();
    }

    public final HomePageDiscoveryCategoryIndicatorAdapter k() {
        HomePageDiscoveryCategoryIndicatorAdapter r100 = this.f212922f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
        return null;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void k0() {
        tt5.a.h("BaseTemplateListView", "showCreateLoading()...");
        if (this.f212926j != null) goto L5;
        com.bytedance.ee.bear.bizwidget.d r100 = new com.bytedance.ee.bear.bizwidget.d(this.f212917a);
        this.f212926j = r100;
        r100.f216371e = R.string.Doc_List_TemplateClickLoadingToast;
    L5:
        com.bytedance.ee.bear.bizwidget.d r101 = this.f212926j;
        if (r101 == null) goto L9;
        r101.b();
        return;
    }

    public final ConcatAdapter o() {
        ConcatAdapter r100 = this.f212923g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public final FragmentActivity getActivity() {
        return this.f212917a;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final CategoryTab s0() {
        return this.f212927k;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void H0(int r100) {
        int r101 = this.f212925i;
        if (r101 <= 0) goto L8;
        Object r102 = ListProtector.get(k().getData(), r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.data.CategoryTab");
        CategoryTab r103 = (CategoryTab) r102;
        HomePageDiscoveryCategoryIndicatorAdapter r104 = k();
        r104.f212999a = r101;
        r104.notifyDataSetChanged();
        com.bytedance.ee.bear.templates.center.list.base.q.a r105 = this.f212921e;
        if (r105 == null) goto L20;
        r105.V6(r103);
        return;
    L20:
        return;
    L8:
        if (r100 >= 0) goto L10;
        return;
    L10:
        if (r100 >= k().getItemCount()) goto L22;
        Object r106 = ListProtector.get(k().getData(), r100);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.data.CategoryTab");
        CategoryTab r107 = (CategoryTab) r106;
        HomePageDiscoveryCategoryIndicatorAdapter r108 = k();
        r108.f212999a = r100;
        r108.notifyDataSetChanged();
        RecyclerView r109 = this.f212931o;
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicator");
        r109 = null;
    L15:
        r109.scrollToPosition(r100);
        w3(r107);
        com.bytedance.ee.bear.templates.center.list.base.q.a r110 = this.f212921e;
        if (r110 == null) goto L18;
        r110.V6(r107);
    L18:
        this.f212925i = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Q(boolean r100) {
        SmartRefreshLayout r101 = this.f212930n;
        SmartRefreshLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r101 = null;
    L5:
        r101.g(r100);
        SmartRefreshLayout r103 = this.f212930n;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
    L9:
        r102.s();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public void Y1(TemplateGroupTab r100) {
        Intrinsics.checkNotNullParameter(r100, "templateGroupTab");
        ArrayList<CategoryTab> r101 = r100.getCategoryTabList();
        int r102 = 0;
        this.f212929m = false;
        Iterator<CategoryTab> r103 = r101.iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L12;
        if (r103.next().getCategoryTabName().length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
        this.f212929m = true;
        goto L3
    L8:
        r105 = false;
        goto L9
    L12:
        if (this.f212929m == true) goto L14;
    L16:
        r104 = false;
    L17:
        this.f212929m = r104;
        RecyclerView r106 = this.f212931o;
        View r107 = null;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicator");
        r106 = null;
    L21:
        if (this.f212929m == true) goto L24;
        r102 = 8;
    L24:
        r106.setVisibility(r102);
        View r108 = this.f212934r;
        if (r108 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
    L28:
        r107.setVisibility(8);
        k().setNewData(r101);
        return;
    L27:
        r107 = r108;
        goto L28
    L14:
        if (r100.getHasData() == false) goto L16;
        goto L16
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void Z(TemplateGroupTab r110) {
        Intrinsics.checkNotNullParameter(r110, "templateGroupTab");
        ArrayList<CategoryTab> r100 = r110.getCategoryTabList();
        ((TemplateCenterViewModel) this.f212939w.getValue()).showFilter(Tab2.SYSTEM);
        ws4.b r101 = null;
        com.bytedance.ee.bear.list.loadstateview.h r102 = null;
        r101 = null;
        if (r100.isEmpty() == false) goto L20;
        tt5.a.h("BaseTemplateListView", "showCategoryTab().. isEmpty");
        View r111 = this.f212935s;
        if (r111 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("content");
        r111 = null;
    L7:
        r111.setVisibility(8);
        if (((t) this).H3() == false) goto L10;
        EmptyCategory r112 = EmptyCategory.SYSTEM_TEMPLATE;
    L11:
        com.bytedance.ee.bear.list.loadstateview.h r103 = this.f212924h;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r103 = null;
    L14:
        r103.f(r112);
        com.bytedance.ee.bear.list.loadstateview.h r113 = this.f212924h;
        if (r113 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L18:
        r102.g();
        return;
    L17:
        r102 = r113;
        goto L18
    L10:
        r112 = EmptyCategory.SYSTEM_TEMPLATE;
        goto L11
    L20:
        e r104 = this.f212920d;
        boolean r105 = false;
        if (r104 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L38;
        e r107 = this.f212920d;
        if (r107 != null) goto L30;
    L32:
        boolean r108 = false;
    L33:
        if (r108 == false) goto L38;
        if (this.f212937u == true) goto L38;
        this.f212925i = 1;
        goto L38
    L30:
        if (r107.YG() != true) goto L32;
        r108 = true;
    L38:
        if (this.f212925i < r100.size()) goto L40;
        CategoryTab r109 = (CategoryTab) ListProtector.get(r100, 0);
    L41:
        Intrinsics.checkNotNull(r109);
        w3(r109);
        if (this.f212936t == false) goto L67;
        this.f212936t = false;
        if (r110.getSource() != 1) goto L46;
        String r114 = "cache";
    L47:
        String r115 = r114;
        e r116 = this.f212920d;
        if (r116 == null) goto L52;
        String r117 = r116.W9();
        if (r117 == null) goto L52;
        r101 = new ws4.b(r117, r115, "recommend", "load_recommend", null, 48);
    L52:
        e r118 = this.f212920d;
        if (r118 == null) goto L57;
        String r119 = r118.getTraceId();
        if (r119 == null) goto L57;
        ws4.g.e(r119, System.currentTimeMillis(), r101);
        ws4.g.f(r119, System.currentTimeMillis(), r101);
    L57:
        e r120 = this.f212920d;
        if (r120 != null) goto L60;
    L62:
        if (r105 == false) goto L68;
        e r121 = this.f212920d;
        if (r121 == null) goto L69;
        r121.rt(true, r101);
        return;
    L69:
        return;
    L68:
        return;
    L60:
        if (r120.tc() == true) goto L62;
        r105 = true;
        goto L62
    L46:
        r114 = "network";
        goto L47
    L67:
        return;
    L40:
        r109 = (CategoryTab) ListProtector.get(r100, this.f212925i);
        goto L41
    L23:
        if (r104.tc() != true) goto L25;
        r106 = true;
        goto L26
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final void m(Throwable r110) {
        Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
        e r100 = this.f212920d;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        ws4.b r103 = null;
        if (r102 == false) goto L14;
        com.bytedance.ee.bear.list.loadstateview.h r104 = this.f212924h;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r104 = null;
    L13:
        r104.h(LoadFailCategory.TEMPLATE_FAIL);
    L14:
        RecyclerView r105 = this.f212931o;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicator");
        r105 = null;
    L17:
        r105.setVisibility(8);
        View r106 = this.f212934r;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(ItemStyle.ITEM_STYLE_DIVIDER);
        r106 = null;
    L20:
        r106.setVisibility(8);
        View r107 = this.f212935s;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("content");
        r107 = null;
    L23:
        r107.setVisibility(8);
        e r108 = this.f212920d;
        if (r108 == null) goto L28;
        String r109 = r108.W9();
        if (r109 == null) goto L28;
        r103 = new ws4.b(r109, "timeout", "recommend", "load_recommend", null, r110.getMessage());
    L28:
        e r111 = this.f212920d;
        if (r111 == null) goto L33;
        String r112 = r111.getTraceId();
        if (r112 == null) goto L33;
        ws4.g.e(r112, System.currentTimeMillis(), r103);
        ws4.g.f(r112, System.currentTimeMillis(), r103);
    L33:
        e r113 = this.f212920d;
        if (r113 != null) goto L36;
    L38:
        r101 = false;
    L39:
        if (r101 == false) goto L44;
        e r114 = this.f212920d;
        if (r114 == null) goto L45;
        r114.rt(false, r103);
        return;
    L45:
        return;
    L44:
        return;
    L36:
        if (r113.tc() == true) goto L38;
    L5:
        if (r100.tc() == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f212921e = (com.bytedance.ee.bear.templates.center.list.base.q.a) r100;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        com.bytedance.ee.bear.templates.center.list.base.q.a r101 = this.f212921e;
        if (r101 == null) goto L6;
        r101.w(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public void w3(CategoryTab r110) {
        Intrinsics.checkNotNullParameter(r110, "categoryTab");
        e r100 = this.f212920d;
        if (r100 == null) goto L6;
        r100.xv(r110);
    L6:
        if (r110.getSource() != 99) goto L8;
        return;
    L8:
        CategoryTab r101 = this.f212927k;
        if (r101 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L16;
    L17:
        Iterator<T> r103 = o().getAdapters().iterator();
    L19:
        if (r103.hasNext() == false) goto L21;
        o().removeAdapter((RecyclerView.Adapter) r103.next());
    L21:
        this.f212927k = r110;
        this.f212928l = ((t) this).M4().f541317b;
        Iterator<ao5.a> r104 = r110.getCategoryList().iterator();
    L23:
        if (r104.hasNext() == false) goto L27;
        if ((!r104.next().f15786c.isEmpty()) == false) goto L23;
        boolean r105 = false;
    L28:
        com.bytedance.ee.bear.list.loadstateview.h r106 = null;
        if (r105 == true) goto L31;
    L43:
        com.bytedance.ee.bear.list.loadstateview.h r107 = this.f212924h;
        if (r107 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r107 = null;
    L46:
        r107.i();
        View r108 = this.f212935s;
        if (r108 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("content");
        r108 = null;
    L49:
        r108.setVisibility(0);
        Iterator<T> r109 = r110.getCategoryList().iterator();
    L51:
        if (r109.hasNext() == false) goto L71;
        ao5.a r111 = (ao5.a) r109.next();
        long r112 = r111.f15787d;
        Iterator<T> r113 = o().getAdapters().iterator();
    L54:
        if (r113.hasNext() == false) goto L63;
        Object r114 = r113.next();
        RecyclerView.Adapter r115 = (RecyclerView.Adapter) r114;
        if ((r115 instanceof TemplateAdapter) == true) goto L58;
    L60:
        boolean r116 = false;
    L61:
        if (r116 == false) goto L54;
    L65:
        if ((r114 instanceof TemplateAdapter) == false) goto L67;
        TemplateAdapter r117 = (TemplateAdapter) r114;
    L68:
        if (r117 != null) goto L69;
        HomePageDiscoveryTemplateAdapter r118 = new HomePageDiscoveryTemplateAdapter(this.f212918b, LayoutType.TYPE_CENTER2, getType(), r111.f15784a.toString(), r111.f15787d);
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r118.f238760g = this;
        r118.A2(r111.a());
        o().addAdapter(r118);
        goto L51
    L69:
        r117.A2(r111.a());
        goto L51
    L67:
        r117 = null;
        goto L68
    L58:
        if (((TemplateAdapter) r115).f238758e != r112) goto L60;
        r116 = true;
        goto L61
    L63:
        r114 = null;
        goto L65
    L71:
        o().notifyDataSetChanged();
    L72:
        List<ao5.a> r119 = r110.getCategoryList();
        r110.getSource();
        Iterator<ao5.a> r120 = r119.iterator();
    L74:
        if (r120.hasNext() == false) goto L78;
        if (r120.next().f15785b == false) goto L74;
        Q(true);
        return;
    L78:
        Q(false);
        return;
    L31:
        if (r110.getCategoryList().size() > 1) goto L43;
        tt5.a.h("BaseTemplateListView", "showSingleCategoryTab().. isEmpty");
        View r121 = this.f212935s;
        if (r121 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("content");
        r121 = null;
    L35:
        r121.setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r122 = this.f212924h;
        if (r122 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r122 = null;
    L38:
        r122.f(EmptyCategory.SINGLE_CATEGORY_TEMPLATE);
        com.bytedance.ee.bear.list.loadstateview.h r123 = this.f212924h;
        if (r123 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L42:
        r106.g();
        goto L72
    L41:
        r106 = r123;
        goto L42
    L27:
        r105 = true;
        goto L28
    L16:
        if (this.f212928l == ((t) this).M4().f541317b) goto L21;
    L11:
        if (r110.getCategoryId() != r101.getCategoryId()) goto L13;
        r102 = true;
        goto L14
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        com.bytedance.ee.bear.templates.center.list.base.q.a r103 = this.f212921e;
        if (r103 == null) goto L6;
        r103.h(r100, r101, r102);
        return;
    }

    public BaseHomePageDiscoveryTemplateListView(FragmentActivity r100, LifecycleOwner r101, View r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        Intrinsics.checkNotNullParameter(r103, "discoveryDelegate");
        this.f212917a = r100;
        this.f212918b = r101;
        this.f212919c = r102;
        this.f212920d = r103;
        this.f212928l = -1;
        this.f212936t = true;
        int r104 = w0.f468013a;
        this.f212938v = w0.b(eu5.b.f474075a);
        this.f212939w = LazyKt.lazy(new BaseHomePageDiscoveryTemplateListView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r100, TemplateV4 r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        TemplateReportV2.i(r100, r101, ((t) this).M4(), r102, r103);
    }
}
