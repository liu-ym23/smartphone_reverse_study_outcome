package com.bytedance.ee.bear.templates.topic;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.contract.Result;
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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import dd5.w0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BaseTopicView implements e, TemplateAdapter.c {
    public final FragmentActivity a;
    public final LifecycleOwner b;
    public final View c;
    public final String d;
    public final boolean e;
    public e.a f;
    public com.bytedance.ee.bear.list.loadstateview.h g;
    public CompatDrawableTextView h;
    public final j i;
    public TemplateAdapter j;
    public List<TemplateV4> k;
    public int l;
    public final Lazy m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void b() {
        int r0 = w0.a;
        this.l = w0.b(this.a);
        GridLayoutManager r1 = this.c.findViewById(2131388317).getLayoutManager();
        if (r1 != null) goto L5;
    L7:
        TemplateAdapter r2 = this.j;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r2 = null;
    L10:
        r2.notifyDataSetChanged();
        return;
    L5:
        if ((r1 instanceof GridLayoutManager) == false) goto L7;
        r1.setSpanCount(this.l);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.widget.TextView, com.bytedance.ee.bear.list.homepage.widget.CompatDrawableTextView] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.widget.TextView] */
    public final void create() {
        com.bytedance.ee.bear.list.loadstateview.h r0 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378939));
        this.g = r0;
        EmptyCategory r1 = EmptyCategory.SYSTEM_TEMPLATE;
        LoadingCategory r2 = LoadingCategory.CATEGORY_TEMPLATE;
        r0.b = r1;
        r0.c = r2;
        r0.e(new c(this));
        this.c.findViewById(2131388317).setLayoutManager(new GridLayoutManager(this.a, this.l));
        TemplateAdapter r3 = new TemplateAdapter(this.b, LayoutType.TYPE_CENTER2, "ccm_template_banner_view_click", 56);
        this.j = r3;
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r3.g = this;
        RecyclerView r4 = this.c.findViewById(2131388317);
        TemplateAdapter r5 = this.j;
        ?? r6 = 0;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r5 = null;
    L5:
        r4.setAdapter(r5);
        ?? r7 = new CompatDrawableTextView(this.a);
        this.h = r7;
        r7.setTextSize(12.0f);
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(n.d(24), n.d(24));
        r8.rightMargin = n.d(16);
        r8.height = n.d(24);
        r8.width = -2;
        CompatDrawableTextView r9 = this.h;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r9 = null;
    L8:
        r9.setBackgroundResource(2131254759);
        AppCompatTextView r10 = this.h;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r10 = null;
    L11:
        r10.setPadding(n.d(8), 0, n.d(8), 0);
        AppCompatTextView r11 = this.h;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r11 = null;
    L14:
        r11.setTextColor(this.a.getResources().getColor(2131105548));
        AppCompatTextView r12 = this.h;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r12 = null;
    L17:
        r12.setGravity(16);
        AppCompatTextView r13 = this.h;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r13 = null;
    L20:
        r13.setOnClickListener(new com.bytedance.ee.bear.templates.topic.a(this));
        BaseTitleBar r14 = (BaseTitleBar) this.c.findViewById(2131388775);
        AppCompatTextView r15 = this.h;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r15 = null;
    L23:
        r14.f.addView(r15, -1, r8);
        sbb.e r16 = (sbb.e) k().getSystemFilterLiveData().getValue();
        if (r16 != null) goto L27;
        r16 = sbb.e.e;
    L27:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L32;
        int r17 = r16.b;
        sbb.e r18 = sbb.e.o;
        if (r17 != r18.b) goto L32;
        r16 = r18;
    L32:
        if (this.e == false) goto L38;
        CompatDrawableTextView r19 = this.h;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
    L37:
        r6.setVisibility(8);
    L39:
        e.a r20 = this.f;
        if (r20 == null) goto L42;
        r20.P2(this.d, r16.b);
    L42:
        ((SortAndFilterViewModel) ViewModelProviders.of(this.a).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this.b, new b(this));
        return;
    L36:
        r6 = r19;
        goto L37
    L38:
        Intrinsics.checkNotNull(r16);
        o(r16);
        goto L39
    }

    public final void destroy() {
        FolderSortStrategy r0 = new FolderSortStrategy();
        r0.a = "";
        ((SortAndFilterViewModel) ViewModelProviders.of(this.a).get(SortAndFilterViewModel.class)).setSortStrategy(r0);
    }

    public final TemplateCenterViewModel k() {
        return (TemplateCenterViewModel) this.m.getValue();
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final List<TemplateV4> getCurrentList() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void m(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        com.bytedance.ee.bear.list.loadstateview.h r4 = this.g;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r4 = null;
    L5:
        r4.h(LoadFailCategory.TEMPLATE_FAIL);
        this.c.findViewById(2131369197).setVisibility(8);
        this.c.findViewById(2131388317).setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r6v10, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16 */
    public final void o(sbb.e r6) {
        k().saveCurrentTabFilterForTopic(r6);
        ?? r1 = 0;
        ?? r2 = 0;
        if (Intrinsics.areEqual(r6, sbb.e.e) == false) goto L18;
        CompatDrawableTextView r7 = this.h;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r7 = null;
    L7:
        r7.setBackgroundResource(2131254759);
        CompatDrawableTextView r8 = this.h;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r8 = null;
    L10:
        r8.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        CompatDrawableTextView r9 = this.h;
        ?? r10 = r9;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r10 = null;
    L13:
        r10.setText("");
        CompatDrawableTextView r11 = this.h;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
    L17:
        l.b(r2, 2131101926);
        return;
    L16:
        r2 = r11;
        goto L17
    L18:
        String r12 = t0.p(this.a, r6.b);
        CompatDrawableTextView r0 = this.h;
        if (r0 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r0 = null;
    L21:
        r0.setBackgroundResource(2131243707);
        CompatDrawableTextView r3 = this.h;
        ?? r4 = r3;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r4 = null;
    L24:
        r4.setCompoundDrawablePadding(y9c.d.a(3));
        Drawable r5 = l.a(this.a, 2131243706, 2131105548);
        CompatDrawableTextView r13 = this.h;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r13 = null;
    L27:
        r13.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, null, null, null);
        CompatDrawableTextView r14 = this.h;
        ?? r15 = r14;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
        r15 = null;
    L30:
        r15.setText(r12);
        CompatDrawableTextView r16 = this.h;
        if (r16 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("filterView");
    L34:
        l.b(r1, 2131105553);
        return;
    L33:
        r1 = r16;
        goto L34
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.f = (e.a) r1;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.templates.topic.e
    public final void y3(TopicDataResult r13) {
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.DATA);
        f r0 = ((TopicData) ((Result) r13).data).getBanner();
        TemplateAdapter r1 = null;
        com.bytedance.ee.bear.list.loadstateview.h r2 = null;
        com.bytedance.ee.bear.list.loadstateview.h r3 = null;
        com.bytedance.ee.bear.list.loadstateview.h r4 = null;
        boolean r5 = false;
        if (r0 == null) goto L16;
        String r6 = r0.a;
        if (r6 == null) goto L16;
        if (r6.length() != 0) goto L9;
        boolean r7 = true;
    L11:
        if ((!r7) == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L16;
        Glide.with(this.c.getContext()).asDrawable().load(new BearGlideUrl(r6)).addListener(new d(this)).override(cu5.c.d() - cu5.c.b(24), cu5.c.b(128)).into((ImageView) this.c.findViewById(2131363914));
        goto L16
    L9:
        r7 = false;
    L16:
        List<TemplateV4> r8 = ((TopicData) ((Result) r13).data).getTemplates();
        Intrinsics.checkNotNull(r8);
        ao5.a r9 = new ao5.a(null, false, r8, 0, 123);
        if (r9.c.isEmpty() == false) goto L38;
        tt5.a.h("BaseTopicView", "showCategoryTab().. isEmpty");
        this.c.findViewById(2131388317).setVisibility(8);
        k().hideFilter(Tab2.SYSTEM);
        String r14 = (String) k().getSearchContent().getValue();
        if (r14 != null) goto L21;
    L26:
        if (r5 == false) goto L32;
        com.bytedance.ee.bear.list.loadstateview.h r15 = this.g;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L31:
        r2.i();
        return;
    L30:
        r2 = r15;
        goto L31
    L32:
        com.bytedance.ee.bear.list.loadstateview.h r16 = this.g;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L36:
        r3.g();
        return;
    L35:
        r3 = r16;
        goto L36
    L21:
        if (r14.length() != 0) goto L23;
        boolean r17 = true;
    L24:
        if (r17 != true) goto L26;
        r5 = true;
        goto L26
    L23:
        r17 = false;
        goto L24
    L38:
        k().showFilter(Tab2.SYSTEM);
        List<TemplateV4> r18 = r9.c;
        this.k = r18;
        if (r18.isEmpty() == false) goto L45;
        tt5.a.h("BaseTopicView", "showSingleCategoryTab().. isEmpty");
        this.c.findViewById(2131388317).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r19 = this.g;
        if (r19 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L44:
        r4.g();
        return;
    L43:
        r4 = r19;
        goto L44
    L45:
        com.bytedance.ee.bear.list.loadstateview.h r10 = this.g;
        if (r10 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r10 = null;
    L48:
        r10.i();
        this.c.findViewById(2131388317).setVisibility(0);
        TemplateAdapter r11 = this.j;
        if (r11 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
    L52:
        r1.A2(CollectionsKt.toMutableList(r18));
        return;
    L51:
        r1 = r11;
        goto L52
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r2, TemplateV4 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        e.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.h(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r2, TemplateV4 r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r0 = TemplateReportV2.a;
        TemplateReportV2.i(r2, r3, sbb.e.e, r4, r5);
    }

    public BaseTopicView(FragmentActivity r2, LifecycleOwner r3, View r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "topicId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.i = j.a.a;
        int r7 = w0.a;
        this.l = w0.b(eu5.b.a);
        this.m = LazyKt.lazy(new BaseTopicView$templateCenViewModel$2(this));
    }
}
