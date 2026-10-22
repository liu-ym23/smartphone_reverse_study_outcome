package com.bytedance.ee.bear.templates.scene;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.Result;
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
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.mvp.IView;
import dd5.w0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseSceneView implements d, TemplateAdapter.c {
    public final FragmentActivity a;
    public final LifecycleOwner b;
    public final View c;
    public final String d;
    public d.a e;
    public h f;
    public TemplateAdapter g;
    public int h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public final void d() {
    }

    public void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public final void b() {
        int r0 = w0.a;
        this.h = w0.b(this.a);
        GridLayoutManager r1 = this.c.findViewById(2131388317).getLayoutManager();
        if (r1 != null) goto L5;
    L7:
        TemplateAdapter r2 = this.g;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r2 = null;
    L10:
        r2.notifyDataSetChanged();
        return;
    L5:
        if ((r1 instanceof GridLayoutManager) == false) goto L7;
        r1.setSpanCount(this.h);
        goto L7
    }

    public void create() {
        h r0 = new h((LoadStateView) this.c.findViewById(2131378939));
        this.f = r0;
        EmptyCategory r1 = EmptyCategory.SYSTEM_TEMPLATE;
        LoadingCategory r2 = LoadingCategory.CATEGORY_TEMPLATE;
        r0.b = r1;
        r0.c = r2;
        r0.e(new b(this));
        GridLayoutManager r3 = new GridLayoutManager(this.a, this.h);
        this.c.findViewById(2131388317).setLayoutManager(r3);
        TemplateAdapter r4 = new TemplateAdapter(this.b, LayoutType.TYPE_CENTER2, "ccm_template_banner_view_click", 56);
        this.g = r4;
        Intrinsics.checkNotNullParameter(this, "templateClickListener");
        r4.g = this;
        RecyclerView r5 = this.c.findViewById(2131388317);
        TemplateAdapter r6 = this.g;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
        r6 = null;
    L5:
        r5.setAdapter(r6);
        d.a r7 = this.e;
        if (r7 == null) goto L9;
        r7.v0(this.d);
        return;
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.templates.scene.d
    public void a7(TopicDataResult r9) {
        Intrinsics.checkNotNullParameter(r9, WikiFolderPushPlugin.DATA);
        ArrayList<TemplateV4> r4 = ((TopicData) ((Result) r9).data).getTemplates();
        Intrinsics.checkNotNull(r4);
        ao5.a r0 = new ao5.a(null, false, r4, 0, 123);
        TemplateAdapter r5 = null;
        h r6 = null;
        h r7 = null;
        h r8 = null;
        boolean r10 = false;
        if (r0.c.isEmpty() == false) goto L24;
        tt5.a.h("BaseTopicView", "showCategoryTab().. isEmpty");
        this.c.findViewById(2131388317).setVisibility(8);
        ((TemplateCenterViewModel) this.i.getValue()).hideFilter(Tab2.SYSTEM);
        String r11 = (String) ((TemplateCenterViewModel) this.i.getValue()).getSearchContent().getValue();
        if (r11 != null) goto L7;
    L12:
        if (r10 == false) goto L18;
        h r12 = this.f;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L17:
        r6.i();
        return;
    L16:
        r6 = r12;
        goto L17
    L18:
        h r13 = this.f;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L22:
        r7.g();
        return;
    L21:
        r7 = r13;
        goto L22
    L7:
        if (r11.length() != 0) goto L9;
        boolean r14 = true;
    L10:
        if (r14 != true) goto L12;
        r10 = true;
        goto L12
    L9:
        r14 = false;
        goto L10
    L24:
        ((TemplateCenterViewModel) this.i.getValue()).showFilter(Tab2.SYSTEM);
        List<TemplateV4> r15 = r0.c;
        if (r15.isEmpty() == false) goto L31;
        tt5.a.h("BaseTopicView", "showSingleCategoryTab().. isEmpty");
        this.c.findViewById(2131388317).setVisibility(8);
        h r16 = this.f;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L30:
        r8.g();
        return;
    L29:
        r8 = r16;
        goto L30
    L31:
        h r1 = this.f;
        if (r1 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r1 = null;
    L34:
        r1.i();
        this.c.findViewById(2131388317).setVisibility(0);
        TemplateAdapter r2 = this.g;
        if (r2 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("templateAdapter");
    L38:
        r5.A2(CollectionsKt.toMutableList(r15));
        return;
    L37:
        r5 = r2;
        goto L38
    }

    @Override // com.bytedance.ee.bear.templates.scene.d
    public final void m(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        h r4 = this.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r4 = null;
    L5:
        r4.h(LoadFailCategory.TEMPLATE_FAIL);
        this.c.findViewById(2131369197).setVisibility(8);
        this.c.findViewById(2131388317).setVisibility(8);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (d.a) r1;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
    }

    public void h(int r2, TemplateV4 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        d.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.h(r2, r3, r4);
        return;
    }

    public BaseSceneView(FragmentActivity r2, LifecycleOwner r3, View r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "topicId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        int r6 = w0.a;
        this.h = w0.b(eu5.b.a);
        this.i = LazyKt.lazy(new BaseSceneView$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r2, TemplateV4 r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r0 = TemplateReportV2.a;
        TemplateReportV2.i(r2, r3, sbb.e.e, r4, r5);
    }
}
