package com.bytedance.ee.bear.templates.horizontal;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadFailCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.LoadingCategory;
import com.bytedance.ee.bear.templates.LayoutType;
import com.bytedance.ee.bear.templates.TemplateShowCardType;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements com.bytedance.ee.bear.templates.horizontal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f239111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f239112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f239113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.templates.horizontal.b.a f239114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HorizontalTemplateAdapter f239115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.list.loadstateview.h f239116f;

    public static final class a {
    }

    public static final class b extends ao5.e {
        @Override // ao5.e
        public final int getTemplateShowType() {
            return TemplateShowCardType.SHOW_CARD_TYPE_MORE_TEMPLATE.ordinal();
        }

        public b() {
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ((RecyclerView) this.f239113c.findViewById(R.id.templates)).setLayoutManager(new LinearLayoutManager(this.f239111a, 0, false));
        HorizontalTemplateAdapter r100 = new HorizontalTemplateAdapter(this.f239112b, LayoutType.TYPE_RECOMMEND2);
        this.f239115e = r100;
        h r101 = new h(this);
        Intrinsics.checkNotNullParameter(r101, "templateClickListener");
        r100.f239078k = r101;
        HorizontalTemplateAdapter r102 = this.f239115e;
        HorizontalTemplateAdapter r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r102 = null;
    L5:
        i r104 = new i(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "templateClickListener");
        r102.f238760g = r104;
        RecyclerView r105 = (RecyclerView) this.f239113c.findViewById(R.id.templates);
        HorizontalTemplateAdapter r106 = this.f239115e;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r105.setAdapter(r103);
        ((RecyclerView) this.f239113c.findViewById(R.id.templates)).addOnScrollListener(new HorizontalTemplateView$initView$3(this));
        com.bytedance.ee.bear.list.loadstateview.h r107 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.f239113c.findViewById(R.id.loadStateView));
        this.f239116f = r107;
        EmptyCategory r108 = EmptyCategory.TEMPLATE;
        LoadingCategory r109 = LoadingCategory.CATEGORY_TEMPLATE;
        r107.f228648b = r108;
        r107.f228649c = r109;
        return;
    L8:
        r103 = r106;
        goto L9
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b
    public final void d() {
        tt5.a.h("HorizontalTemplateView", "showDataLoading()...");
        ((RecyclerView) this.f239113c.findViewById(R.id.templates)).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r100 = this.f239116f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r100 = null;
    L5:
        r100.j();
    }

    public final Context getContext() {
        return this.f239111a;
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b
    public final void E(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        tt5.a.d("HorizontalTemplateView", "showLoadFailed()...throwable = " + r100);
        ((RecyclerView) this.f239113c.findViewById(R.id.templates)).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r101 = this.f239116f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r101 = null;
    L5:
        r101.h(LoadFailCategory.TEMPLATE_FAIL);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f239114d = (com.bytedance.ee.bear.templates.horizontal.b.a) r100;
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b
    public final void F5(List<TemplateV4> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "templates");
        tt5.a.h("HorizontalTemplateView", "showTemplates()...");
        ((RecyclerView) this.f239113c.findViewById(R.id.templates)).setVisibility(0);
        ArrayList r102 = new ArrayList();
        r102.addAll(r100);
        if (r101 == false) goto L5;
        r102.add(new b());
    L5:
        HorizontalTemplateAdapter r103 = this.f239115e;
        com.bytedance.ee.bear.list.loadstateview.h r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r103 = null;
    L8:
        r103.A2(r102);
        boolean r105 = r100.isEmpty();
        tt5.a.h("HorizontalTemplateView", "hideDataLoading()...");
        if (r105 == false) goto L15;
        com.bytedance.ee.bear.list.loadstateview.h r106 = this.f239116f;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L14:
        r104.g();
        return;
    L13:
        r104 = r106;
        goto L14
    L15:
        com.bytedance.ee.bear.list.loadstateview.h r107 = this.f239116f;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L19:
        r104.i();
        return;
    L18:
        r104 = r107;
        goto L19
    }

    public g(Context r100, LifecycleOwner r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        this.f239111a = r100;
        this.f239112b = r101;
        this.f239113c = r102;
    }
}
