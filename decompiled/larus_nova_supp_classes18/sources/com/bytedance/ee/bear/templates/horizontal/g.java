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
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements com.bytedance.ee.bear.templates.horizontal.b {
    public final Context a;
    public final LifecycleOwner b;
    public final View c;
    public com.bytedance.ee.bear.templates.horizontal.b.a d;
    public HorizontalTemplateAdapter e;
    public com.bytedance.ee.bear.list.loadstateview.h f;

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

    public final void destroy() {
    }

    public final void create() {
        this.c.findViewById(2131388357).setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        HorizontalTemplateAdapter r0 = new HorizontalTemplateAdapter(this.b, LayoutType.TYPE_RECOMMEND2);
        this.e = r0;
        h r2 = new h(this);
        Intrinsics.checkNotNullParameter(r2, "templateClickListener");
        r0.k = r2;
        HorizontalTemplateAdapter r1 = this.e;
        HorizontalTemplateAdapter r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L5:
        i r5 = new i(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "templateClickListener");
        r1.g = r5;
        RecyclerView r4 = this.c.findViewById(2131388357);
        HorizontalTemplateAdapter r6 = this.e;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r4.setAdapter(r3);
        this.c.findViewById(2131388357).addOnScrollListener(new HorizontalTemplateView$initView$3(this));
        com.bytedance.ee.bear.list.loadstateview.h r7 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378939));
        this.f = r7;
        EmptyCategory r8 = EmptyCategory.TEMPLATE;
        LoadingCategory r9 = LoadingCategory.CATEGORY_TEMPLATE;
        r7.b = r8;
        r7.c = r9;
        return;
    L8:
        r3 = r6;
        goto L9
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b
    public final void d() {
        tt5.a.h("HorizontalTemplateView", "showDataLoading()...");
        this.c.findViewById(2131388357).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r0 = null;
    L5:
        r0.j();
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b
    public final void E(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        tt5.a.d("HorizontalTemplateView", "showLoadFailed()...throwable = " + r3);
        this.c.findViewById(2131388357).setVisibility(8);
        com.bytedance.ee.bear.list.loadstateview.h r4 = this.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
        r4 = null;
    L5:
        r4.h(LoadFailCategory.TEMPLATE_FAIL);
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (com.bytedance.ee.bear.templates.horizontal.b.a) r1;
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b
    public final void F5(List<TemplateV4> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "templates");
        tt5.a.h("HorizontalTemplateView", "showTemplates()...");
        this.c.findViewById(2131388357).setVisibility(0);
        ArrayList r1 = new ArrayList();
        r1.addAll(r4);
        if (r5 == false) goto L5;
        r1.add(new b());
    L5:
        HorizontalTemplateAdapter r6 = this.e;
        com.bytedance.ee.bear.list.loadstateview.h r2 = null;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r6 = null;
    L8:
        r6.A2(r1);
        boolean r7 = r4.isEmpty();
        tt5.a.h("HorizontalTemplateView", "hideDataLoading()...");
        if (r7 == false) goto L15;
        com.bytedance.ee.bear.list.loadstateview.h r8 = this.f;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L14:
        r2.g();
        return;
    L13:
        r2 = r8;
        goto L14
    L15:
        com.bytedance.ee.bear.list.loadstateview.h r9 = this.f;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("loadStateViewWrapper");
    L19:
        r2.i();
        return;
    L18:
        r2 = r9;
        goto L19
    }

    public g(Context r2, LifecycleOwner r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
