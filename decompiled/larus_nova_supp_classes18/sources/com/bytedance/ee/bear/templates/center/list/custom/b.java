package com.bytedance.ee.bear.templates.center.list.custom;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView;
import kotlin.jvm.internal.Intrinsics;
import s45.g;
import s45.h;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends BaseTemplateListView {

    public static final class a implements LoadStateView.a {
        public a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
            h r0 = g.a;
            String r1 = g.a.a("template_center_help_center", "360049067736", "352554751443", null);
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r1);
        }
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView, com.bytedance.ee.bear.templates.center.list.base.q
    public int getType() {
        return 2;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final EmptyCategory I7() {
        if (this.k == false) goto L6;
        return EmptyCategory.CUSTOM_TEMPLATE;
    L6:
        return EmptyCategory.CUSTOM_TEMPLATE_V2;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView
    public final LoadStateView.a p() {
        return new a();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final boolean H3() {
        return Intrinsics.areEqual((e) s().getCustomFilterLiveData().getValue(), e.e);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final e M4() {
        e r0 = (e) s().getCustomFilterLiveData().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e.e;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final Tab2 getTab() {
        return Tab2.CUSTOM;
    }

    public b(FragmentActivity r2, LifecycleOwner r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(r2, r3, r4);
    }
}
