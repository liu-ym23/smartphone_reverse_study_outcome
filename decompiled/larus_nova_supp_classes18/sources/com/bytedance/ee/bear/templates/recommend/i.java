package com.bytedance.ee.bear.templates.recommend;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements b {
    public final Context a;
    public final LifecycleOwner b;
    public final View c;
    public final boolean d;
    public b.a e;
    public TemplateAdapter f;
    public com.bytedance.ee.bear.list.loadstateview.h g;
    public com.bytedance.ee.bear.bizwidget.d h;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void c0() {
        tt5.a.h("NewRecommendTemplateView", "hideCreateLoading()...");
        com.bytedance.ee.bear.bizwidget.d r0 = this.h;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void create() {
        ((TextView) this.c.findViewById(2131375308)).setOnClickListener(j.a);
        if (this.d == false) goto L5;
        ((TextView) this.c.findViewById(2131375308)).setBackgroundColor(this.a.getResources().getColor(2131100549));
    L6:
        ((TextView) this.c.findViewById(2131362509)).setOnClickListener(new k(this));
        this.c.findViewById(2131388357).setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        RecyclerView.Adapter r5 = null;
        TemplateAdapter r0 = new TemplateAdapter(this.b, LayoutType.TYPE_RECOMMEND2, r5, 60);
        this.f = r0;
        l r2 = new l(this);
        Intrinsics.checkNotNullParameter(r2, "templateClickListener");
        r0.g = r2;
        RecyclerView r1 = this.c.findViewById(2131388357);
        TemplateAdapter r3 = this.f;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L10:
        r1.setAdapter(r5);
        com.bytedance.ee.bear.list.loadstateview.h r4 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378939));
        this.g = r4;
        EmptyCategory r6 = EmptyCategory.TEMPLATE;
        LoadingCategory r7 = LoadingCategory.CATEGORY_TEMPLATE;
        r4.b = r6;
        r4.c = r7;
        return;
    L9:
        r5 = r3;
        goto L10
    L5:
        ((TextView) this.c.findViewById(2131375308)).setBackgroundColor(this.a.getResources().getColor(2131100548));
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void d() {
        tt5.a.h("NewRecommendTemplateView", "showDataLoading()...");
        this.c.findViewById(2131388357).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r0 = null;
    L5:
        r0.j();
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void k0() {
        tt5.a.h("NewRecommendTemplateView", "showCreateLoading()...");
        if (this.h != null) goto L5;
        com.bytedance.ee.bear.bizwidget.d r0 = new com.bytedance.ee.bear.bizwidget.d(this.a);
        this.h = r0;
        r0.e = 2131887993;
    L5:
        com.bytedance.ee.bear.bizwidget.d r1 = this.h;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void E(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        tt5.a.d("NewRecommendTemplateView", "showLoadFailed()...throwable = " + r3);
        this.c.findViewById(2131388357).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r4 = this.g;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r4 = null;
    L5:
        r4.h(LoadFailCategory.TEMPLATE_FAIL);
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void T7(List<TemplateV4> r5) {
        Intrinsics.checkNotNullParameter(r5, "templates");
        tt5.a.h("NewRecommendTemplateView", "showTemplates()...");
        this.c.findViewById(2131388357).setVisibility(0);
        TemplateAdapter r1 = this.f;
        com.bytedance.ee.bear.list.loadstateview.h r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L5:
        r1.A2(CollectionsKt.toMutableList(r5));
        boolean r6 = r5.isEmpty();
        tt5.a.h("NewRecommendTemplateView", "hideDataLoading()...");
        if (r6 == false) goto L12;
        com.bytedance.ee.bear.list.loadstateview.h r7 = this.g;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L11:
        r2.g();
        return;
    L10:
        r2 = r7;
        goto L11
    L12:
        com.bytedance.ee.bear.list.loadstateview.h r8 = this.g;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L16:
        r2.i();
        return;
    L15:
        r2 = r8;
        goto L16
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (b.a) r1;
    }

    public i(Context r2, LifecycleOwner r3, View r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
