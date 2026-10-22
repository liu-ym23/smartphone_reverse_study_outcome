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
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f239285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f239286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f239287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f239288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.a f239289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TemplateAdapter f239290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f239291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.bizwidget.d f239292h;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void c0() {
        tt5.a.h("NewRecommendTemplateView", "hideCreateLoading()...");
        com.bytedance.ee.bear.bizwidget.d r100 = this.f239292h;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ((TextView) this.f239287c.findViewById(R.id.innerTitle)).setOnClickListener(j.f239293a);
        if (this.f239288d == false) goto L5;
        ((TextView) this.f239287c.findViewById(R.id.innerTitle)).setBackgroundColor(this.f239285a.getResources().getColor(R.color.bg_body_overlay));
    L6:
        ((TextView) this.f239287c.findViewById(R.id.allTemplates)).setOnClickListener(new k(this));
        ((RecyclerView) this.f239287c.findViewById(R.id.templates)).setLayoutManager(new LinearLayoutManager(this.f239285a, 0, false));
        TemplateAdapter r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        TemplateAdapter r102 = new TemplateAdapter(this.f239286b, LayoutType.TYPE_RECOMMEND2, r101, 60);
        this.f239290f = r102;
        l r103 = new l(this);
        Intrinsics.checkNotNullParameter(r103, "templateClickListener");
        r102.f238760g = r103;
        RecyclerView r104 = (RecyclerView) this.f239287c.findViewById(R.id.templates);
        TemplateAdapter r105 = this.f239290f;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L10:
        r104.setAdapter(r100);
        com.bytedance.ee.bear.list.loadstateview.h r106 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f239287c.findViewById(R.id.loadStateView));
        this.f239291g = r106;
        EmptyCategory r107 = EmptyCategory.TEMPLATE;
        LoadingCategory r108 = LoadingCategory.CATEGORY_TEMPLATE;
        r106.f228648b = r107;
        r106.f228649c = r108;
        return;
    L9:
        r100 = r105;
        goto L10
    L5:
        ((TextView) this.f239287c.findViewById(R.id.innerTitle)).setBackgroundColor(this.f239285a.getResources().getColor(R.color.bg_body));
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void d() {
        tt5.a.h("NewRecommendTemplateView", "showDataLoading()...");
        ((RecyclerView) this.f239287c.findViewById(R.id.templates)).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r100 = this.f239291g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r100 = null;
    L5:
        r100.j();
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void k0() {
        tt5.a.h("NewRecommendTemplateView", "showCreateLoading()...");
        if (this.f239292h != null) goto L5;
        com.bytedance.ee.bear.bizwidget.d r100 = new com.bytedance.ee.bear.bizwidget.d(this.f239285a);
        this.f239292h = r100;
        r100.f216371e = R.string.Doc_List_TemplateClickLoadingToast;
    L5:
        com.bytedance.ee.bear.bizwidget.d r101 = this.f239292h;
        if (r101 == null) goto L9;
        r101.b();
        return;
    }

    public final Context getContext() {
        return this.f239285a;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void E(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        tt5.a.d("NewRecommendTemplateView", "showLoadFailed()...throwable = " + r100);
        ((RecyclerView) this.f239287c.findViewById(R.id.templates)).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r101 = this.f239291g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r101 = null;
    L5:
        r101.h(LoadFailCategory.TEMPLATE_FAIL);
    }

    @Override // com.bytedance.ee.bear.templates.recommend.b
    public final void T7(List<TemplateV4> r100) {
        Intrinsics.checkNotNullParameter(r100, "templates");
        tt5.a.h("NewRecommendTemplateView", "showTemplates()...");
        ((RecyclerView) this.f239287c.findViewById(R.id.templates)).setVisibility(0);
        TemplateAdapter r101 = this.f239290f;
        com.bytedance.ee.bear.list.loadstateview.h r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L5:
        r101.A2(CollectionsKt.toMutableList(r100));
        boolean r103 = r100.isEmpty();
        tt5.a.h("NewRecommendTemplateView", "hideDataLoading()...");
        if (r103 == false) goto L12;
        com.bytedance.ee.bear.list.loadstateview.h r104 = this.f239291g;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L11:
        r102.g();
        return;
    L10:
        r102 = r104;
        goto L11
    L12:
        com.bytedance.ee.bear.list.loadstateview.h r105 = this.f239291g;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L16:
        r102.i();
        return;
    L15:
        r102 = r105;
        goto L16
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f239289e = (b.a) r100;
    }

    public i(Context r100, LifecycleOwner r101, View r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        this.f239285a = r100;
        this.f239286b = r101;
        this.f239287c = r102;
        this.f239288d = r103;
    }
}
