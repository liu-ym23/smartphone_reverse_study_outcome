package com.bytedance.ee.bear.templates.center.list.business;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseTemplateListView {
    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListView, com.bytedance.ee.bear.templates.center.list.base.q
    public int getType() {
        return 3;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final boolean H3() {
        return Intrinsics.areEqual((e) s().getBusinessFilterLiveData().getValue(), e.e);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final e M4() {
        e r0 = (e) s().getBusinessFilterLiveData().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return e.e;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final EmptyCategory I7() {
        return EmptyCategory.BUSINESS_TEMPLATE;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.q
    public final Tab2 getTab() {
        return Tab2.BUSNISS;
    }

    public a(FragmentActivity r2, LifecycleOwner r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(r2, r3, r4);
    }
}
