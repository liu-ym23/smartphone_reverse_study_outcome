package com.bytedance.ee.bear.templates.center.list.system;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.banner.bean.BannerScene;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView;
import com.bytedance.ee.bear.templates.center.list.base.q;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends BaseTemplateListView {
    public com.bytedance.ee.bear.banner.d n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView, com.bytedance.ee.bear.templates.center.list.base.q
    public int getType() {
        return 1;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView
    public final void destroy() {
        com.bytedance.ee.bear.banner.d r0 = this.n;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final boolean H3() {
        return Intrinsics.areEqual((e) s().getSystemFilterLiveData().getValue(), e.e);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final e M4() {
        e r0 = (e) s().getSystemFilterLiveData().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e.e;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView
    public final void create() {
        super.create();
        com.bytedance.ee.bear.banner.d r0 = (com.bytedance.ee.bear.banner.d) org.koin.java.a.c(com.bytedance.ee.bear.banner.d.class, mwc.b.a(ThumbGlideUrl.SOURCE_TEMPLATE), null, 4);
        this.n = r0;
        if (r0 == null) goto L5;
        r0.b(BannerScene.TEMPLATE);
    L5:
        com.bytedance.ee.bear.banner.d r1 = this.n;
        if (r1 == null) goto L8;
        r1.c((ViewGroup) this.c.findViewById(2131389096), getActivity());
    L8:
        com.bytedance.ee.bear.banner.d r2 = this.n;
        if (r2 == null) goto L12;
        r2.d();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final EmptyCategory I7() {
        return EmptyCategory.SYSTEM_TEMPLATE;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final Tab2 getTab() {
        return Tab2.SYSTEM;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView, com.bytedance.ee.bear.templates.center.list.base.q
    public final void w3(CategoryTab r3) {
        Intrinsics.checkNotNullParameter(r3, "categoryTab");
        super.w3(r3);
        if (r3.getCategoryList().size() == 1) goto L5;
        return;
    L5:
        if (((ao5.a) ListProtector.get(r3.getCategoryList(), 0)).e == true) goto L11;
        q.a r4 = this.d;
        if (r4 == null) goto L12;
        r4.N3();
        return;
    L12:
        return;
    }

    public b(FragmentActivity r2, Fragment r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(r2, r3, r4);
    }
}
