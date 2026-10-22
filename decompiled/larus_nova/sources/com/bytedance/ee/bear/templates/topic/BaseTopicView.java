package com.bytedance.ee.bear.templates.topic;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.widget.CompatDrawableTextView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import dd5.w0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class BaseTopicView implements e, TemplateAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f239411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f239412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f239413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f239414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f239415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e.a f239416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f239417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CompatDrawableTextView f239418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f239419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TemplateAdapter f239420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<TemplateV4> f239421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f239422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f239423m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void b() {
        int r100 = w0.f468013a;
        this.f239422l = w0.b(this.f239411a);
        RecyclerView.LayoutManager r101 = ((RecyclerView) this.f239413c.findViewById(R.id.templateGroupList)).getLayoutManager();
        if (r101 != null) goto L5;
    L7:
        TemplateAdapter r102 = this.f239420j;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r102 = null;
    L10:
        r102.notifyDataSetChanged();
        return;
    L5:
        if ((r101 instanceof GridLayoutManager) == false) goto L7;
        ((GridLayoutManager) r101).setSpanCount(this.f239422l);
        goto L7
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        com.bytedance.ee.bear.list.loadstateview.h r100 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f239413c.findViewById(R.id.loadStateView));
        this.f239417g = r100;
        EmptyCategory r101 = EmptyCategory.SYSTEM_TEMPLATE;
        LoadingCategory r102 = LoadingCategory.CATEGORY_TEMPLATE;
        r100.f228648b = r101;
        r100.f228649c = r102;
        r100.e(new c(this));
        ((RecyclerView) this.f239413c.findViewById(R.id.templateGroupList)).setLayoutManager(new GridLayoutManager(this.f239411a, this.f239422l));
        TemplateAdapter r103 = new TemplateAdapter(this.f239412b, LayoutType.TYPE_CENTER2, "ccm_template_banner_view_click", 56);
        this.f239420j = r103;
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r103.f238760g = this;
        RecyclerView r104 = (RecyclerView) this.f239413c.findViewById(R.id.templateGroupList);
        TemplateAdapter r105 = this.f239420j;
        CompatDrawableTextView r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r105 = null;
    L5:
        r104.setAdapter(r105);
        CompatDrawableTextView r107 = new CompatDrawableTextView(this.f239411a);
        this.f239418h = r107;
        r107.setTextSize(12.0f);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(n.d(24), n.d(24));
        r108.rightMargin = n.d(16);
        r108.height = n.d(24);
        r108.width = -2;
        CompatDrawableTextView r109 = this.f239418h;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r109 = null;
    L8:
        r109.setBackgroundResource(R.drawable.ud_icon_filter_outlined);
        CompatDrawableTextView r110 = this.f239418h;
        if (r110 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r110 = null;
    L11:
        r110.setPadding(n.d(8), 0, n.d(8), 0);
        CompatDrawableTextView r111 = this.f239418h;
        if (r111 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r111 = null;
    L14:
        r111.setTextColor(this.f239411a.getResources().getColor(R.color.primary_fill_default));
        CompatDrawableTextView r112 = this.f239418h;
        if (r112 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r112 = null;
    L17:
        r112.setGravity(16);
        CompatDrawableTextView r113 = this.f239418h;
        if (r113 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r113 = null;
    L20:
        r113.setOnClickListener(new com.bytedance.ee.bear.templates.topic.a(this));
        BaseTitleBar r114 = (BaseTitleBar) this.f239413c.findViewById(R.id.titleBar);
        CompatDrawableTextView r115 = this.f239418h;
        if (r115 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r115 = null;
    L23:
        r114.f240031f.addView(r115, -1, r108);
        sbb.e r116 = k().getSystemFilterLiveData().getValue();
        if (r116 != null) goto L27;
        r116 = sbb.e.f541294e;
    L27:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.template_docx", false) == false) goto L32;
        int r117 = r116.f541317b;
        sbb.e r118 = sbb.e.f541304o;
        if (r117 != r118.f541317b) goto L32;
        r116 = r118;
    L32:
        if (this.f239415e == false) goto L38;
        CompatDrawableTextView r119 = this.f239418h;
        if (r119 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
    L37:
        r106.setVisibility(8);
    L39:
        e.a r120 = this.f239416f;
        if (r120 == null) goto L42;
        r120.P2(this.f239414d, r116.f541317b);
    L42:
        ((SortAndFilterViewModel) ViewModelProviders.of(this.f239411a).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this.f239412b, new b(this));
        return;
    L36:
        r106 = r119;
        goto L37
    L38:
        Intrinsics.checkNotNull(r116);
        o(r116);
        goto L39
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        FolderSortStrategy r100 = new FolderSortStrategy();
        r100.f227680a = "";
        ((SortAndFilterViewModel) ViewModelProviders.of(this.f239411a).get(SortAndFilterViewModel.class)).setSortStrategy(r100);
    }

    public final TemplateCenterViewModel k() {
        return (TemplateCenterViewModel) this.f239423m.getValue();
    }

    public final FragmentActivity getActivity() {
        return this.f239411a;
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final List<TemplateV4> getCurrentList() {
        return this.f239421k;
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void m(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.ee.bear.list.loadstateview.h r101 = this.f239417g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r101 = null;
    L5:
        r101.h(LoadFailCategory.TEMPLATE_FAIL);
        this.f239413c.findViewById(R.id.divider).setVisibility(8);
        ((RecyclerView) this.f239413c.findViewById(R.id.templateGroupList)).setVisibility(8);
    }

    public final void o(sbb.e r100) {
        k().saveCurrentTabFilterForTopic(r100);
        CompatDrawableTextView r101 = null;
        if (Intrinsics.areEqual(r100, sbb.e.f541294e) == false) goto L18;
        CompatDrawableTextView r102 = this.f239418h;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r102 = null;
    L7:
        r102.setBackgroundResource(R.drawable.ud_icon_filter_outlined);
        CompatDrawableTextView r103 = this.f239418h;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r103 = null;
    L10:
        r103.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        CompatDrawableTextView r104 = this.f239418h;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r104 = null;
    L13:
        r104.setText("");
        CompatDrawableTextView r105 = this.f239418h;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
    L17:
        l.b(r101, R.color.facade_selector_icon_n1);
        return;
    L16:
        r101 = r105;
        goto L17
    L18:
        String r106 = t0.p(this.f239411a, r100.f541317b);
        CompatDrawableTextView r107 = this.f239418h;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r107 = null;
    L21:
        r107.setBackgroundResource(R.drawable.list_filter_menu_bg_blue);
        CompatDrawableTextView r108 = this.f239418h;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r108 = null;
    L24:
        r108.setCompoundDrawablePadding(y9c.d.a(3));
        Drawable r109 = l.a(this.f239411a, R.drawable.list_filter_icon_white, R.color.primary_fill_default);
        CompatDrawableTextView r110 = this.f239418h;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r110 = null;
    L27:
        r110.setCompoundDrawablesRelativeWithIntrinsicBounds(r109, null, null, null);
        CompatDrawableTextView r111 = this.f239418h;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r111 = null;
    L30:
        r111.setText(r106);
        CompatDrawableTextView r112 = this.f239418h;
        if (r112 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
    L34:
        l.b(r101, R.color.primary_fill_solid_02);
        return;
    L33:
        r101 = r112;
        goto L34
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f239416f = (e.a) r100;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void y3(TopicDataResult r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        f r100 = ((TopicData) r110.data).getBanner();
        TemplateAdapter r101 = null;
        com.bytedance.ee.bear.list.loadstateview.h r102 = null;
        com.bytedance.ee.bear.list.loadstateview.h r103 = null;
        com.bytedance.ee.bear.list.loadstateview.h r104 = null;
        boolean r105 = false;
        if (r100 == null) goto L16;
        String r106 = r100.f239435a;
        if (r106 == null) goto L16;
        if (r106.length() != 0) goto L9;
        boolean r107 = true;
    L11:
        if ((!r107) == true) goto L14;
        r106 = null;
    L14:
        if (r106 == null) goto L16;
        Glide.with(this.f239413c.getContext()).asDrawable().load(new BearGlideUrl(r106)).addListener(new d(this)).override(cu5.c.d() - cu5.c.b(24), cu5.c.b(128)).into((ImageView) this.f239413c.findViewById(R.id.bannerIv));
        goto L16
    L9:
        r107 = false;
    L16:
        List<TemplateV4> r108 = ((TopicData) r110.data).getTemplates();
        Intrinsics.checkNotNull(r108);
        ao5.a r109 = new ao5.a(null, false, r108, 0, 123);
        if (r109.f15786c.isEmpty() == false) goto L38;
        tt5.a.h("BaseTopicView", "showCategoryTab().. isEmpty");
        ((RecyclerView) this.f239413c.findViewById(R.id.templateGroupList)).setVisibility(8);
        k().hideFilter(Tab2.SYSTEM);
        String r111 = k().getSearchContent().getValue();
        if (r111 != null) goto L21;
    L26:
        if (r105 == false) goto L32;
        com.bytedance.ee.bear.list.loadstateview.h r112 = this.f239417g;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L31:
        r102.i();
        return;
    L30:
        r102 = r112;
        goto L31
    L32:
        com.bytedance.ee.bear.list.loadstateview.h r113 = this.f239417g;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L36:
        r103.g();
        return;
    L35:
        r103 = r113;
        goto L36
    L21:
        if (r111.length() != 0) goto L23;
        boolean r114 = true;
    L24:
        if (r114 != true) goto L26;
        r105 = true;
        goto L26
    L23:
        r114 = false;
        goto L24
    L38:
        k().showFilter(Tab2.SYSTEM);
        List<TemplateV4> r115 = r109.f15786c;
        this.f239421k = r115;
        if (r115.isEmpty() == false) goto L45;
        tt5.a.h("BaseTopicView", "showSingleCategoryTab().. isEmpty");
        ((RecyclerView) this.f239413c.findViewById(R.id.templateGroupList)).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r116 = this.f239417g;
        if (r116 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L44:
        r104.g();
        return;
    L43:
        r104 = r116;
        goto L44
    L45:
        com.bytedance.ee.bear.list.loadstateview.h r117 = this.f239417g;
        if (r117 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r117 = null;
    L48:
        r117.i();
        ((RecyclerView) this.f239413c.findViewById(R.id.templateGroupList)).setVisibility(0);
        TemplateAdapter r118 = this.f239420j;
        if (r118 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
    L52:
        r101.A2(CollectionsKt.toMutableList(r115));
        return;
    L51:
        r101 = r118;
        goto L52
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        e.a r103 = this.f239416f;
        if (r103 == null) goto L6;
        r103.h(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r100, TemplateV4 r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        TemplateReportV2.i(r100, r101, sbb.e.f541294e, r102, r103);
    }

    public BaseTopicView(FragmentActivity r100, LifecycleOwner r101, View r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        Intrinsics.checkNotNullParameter(r103, "topicId");
        this.f239411a = r100;
        this.f239412b = r101;
        this.f239413c = r102;
        this.f239414d = r103;
        this.f239415e = r104;
        this.f239419i = j.a.f217090a;
        int r105 = w0.f468013a;
        this.f239422l = w0.b(eu5.b.f474075a);
        this.f239423m = LazyKt.lazy(new BaseTopicView$templateCenViewModel$2(this));
    }
}
