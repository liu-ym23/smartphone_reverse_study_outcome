package com.bytedance.ee.bear.templates.scene;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.list.loadstateview.h;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import dd5.w0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class BaseSceneView implements d, TemplateAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f239297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f239298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f239299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f239300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d.a f239301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f239302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TemplateAdapter f239303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f239304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f239305i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public final void d() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public final void b() {
        int r100 = w0.f468013a;
        this.f239304h = w0.b(this.f239297a);
        RecyclerView.LayoutManager r101 = ((RecyclerView) this.f239299c.findViewById(R.id.templateGroupList)).getLayoutManager();
        if (r101 != null) goto L5;
    L7:
        TemplateAdapter r102 = this.f239303g;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r102 = null;
    L10:
        r102.notifyDataSetChanged();
        return;
    L5:
        if ((r101 instanceof GridLayoutManager) == false) goto L7;
        ((GridLayoutManager) r101).setSpanCount(this.f239304h);
        goto L7
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
        h r100 = new h((LoadStateView) this.f239299c.findViewById(R.id.loadStateView));
        this.f239302f = r100;
        EmptyCategory r101 = EmptyCategory.SYSTEM_TEMPLATE;
        LoadingCategory r102 = LoadingCategory.CATEGORY_TEMPLATE;
        r100.f228648b = r101;
        r100.f228649c = r102;
        r100.e(new b(this));
        GridLayoutManager r103 = new GridLayoutManager(this.f239297a, this.f239304h);
        ((RecyclerView) this.f239299c.findViewById(R.id.templateGroupList)).setLayoutManager(r103);
        TemplateAdapter r104 = new TemplateAdapter(this.f239298b, LayoutType.TYPE_CENTER2, "ccm_template_banner_view_click", 56);
        this.f239303g = r104;
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r104.f238760g = this;
        RecyclerView r105 = (RecyclerView) this.f239299c.findViewById(R.id.templateGroupList);
        TemplateAdapter r106 = this.f239303g;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r106 = null;
    L5:
        r105.setAdapter(r106);
        d.a r107 = this.f239301e;
        if (r107 == null) goto L9;
        r107.v0(this.f239300d);
        return;
    }

    public final FragmentActivity getActivity() {
        return this.f239297a;
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public void a7(TopicDataResult r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ArrayList<TemplateV4> r101 = ((TopicData) r100.data).getTemplates();
        Intrinsics.checkNotNull(r101);
        ao5.a r102 = new ao5.a(null, false, r101, 0, 123);
        TemplateAdapter r103 = null;
        h r104 = null;
        h r105 = null;
        h r106 = null;
        boolean r107 = false;
        if (r102.f15786c.isEmpty() == false) goto L24;
        tt5.a.h("BaseTopicView", "showCategoryTab().. isEmpty");
        ((RecyclerView) this.f239299c.findViewById(R.id.templateGroupList)).setVisibility(8);
        ((TemplateCenterViewModel) this.f239305i.getValue()).hideFilter(Tab2.SYSTEM);
        String r108 = ((TemplateCenterViewModel) this.f239305i.getValue()).getSearchContent().getValue();
        if (r108 != null) goto L7;
    L12:
        if (r107 == false) goto L18;
        h r109 = this.f239302f;
        if (r109 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L17:
        r104.i();
        return;
    L16:
        r104 = r109;
        goto L17
    L18:
        h r110 = this.f239302f;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L22:
        r105.g();
        return;
    L21:
        r105 = r110;
        goto L22
    L7:
        if (r108.length() != 0) goto L9;
        boolean r111 = true;
    L10:
        if (r111 != true) goto L12;
        r107 = true;
        goto L12
    L9:
        r111 = false;
        goto L10
    L24:
        ((TemplateCenterViewModel) this.f239305i.getValue()).showFilter(Tab2.SYSTEM);
        List<TemplateV4> r112 = r102.f15786c;
        if (r112.isEmpty() == false) goto L31;
        tt5.a.h("BaseTopicView", "showSingleCategoryTab().. isEmpty");
        ((RecyclerView) this.f239299c.findViewById(R.id.templateGroupList)).setVisibility(8);
        h r113 = this.f239302f;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L30:
        r106.g();
        return;
    L29:
        r106 = r113;
        goto L30
    L31:
        h r114 = this.f239302f;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r114 = null;
    L34:
        r114.i();
        ((RecyclerView) this.f239299c.findViewById(R.id.templateGroupList)).setVisibility(0);
        TemplateAdapter r115 = this.f239303g;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
    L38:
        r103.A2(CollectionsKt.toMutableList(r112));
        return;
    L37:
        r103 = r115;
        goto L38
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public final void m(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        h r101 = this.f239302f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r101 = null;
    L5:
        r101.h(LoadFailCategory.TEMPLATE_FAIL);
        this.f239299c.findViewById(R.id.divider).setVisibility(8);
        ((RecyclerView) this.f239299c.findViewById(R.id.templateGroupList)).setVisibility(8);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f239301e = (d.a) r100;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
    }

    public void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        d.a r103 = this.f239301e;
        if (r103 == null) goto L6;
        r103.h(r100, r101, r102);
        return;
    }

    public BaseSceneView(FragmentActivity r100, LifecycleOwner r101, View r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        Intrinsics.checkNotNullParameter(r103, "topicId");
        this.f239297a = r100;
        this.f239298b = r101;
        this.f239299c = r102;
        this.f239300d = r103;
        int r104 = w0.f468013a;
        this.f239304h = w0.b(eu5.b.f474075a);
        this.f239305i = LazyKt.lazy(new BaseSceneView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r100, TemplateV4 r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        TemplateReportV2.i(r100, r101, sbb.e.f541294e, r102, r103);
    }
}
