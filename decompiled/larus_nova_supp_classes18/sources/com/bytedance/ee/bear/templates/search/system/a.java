package com.bytedance.ee.bear.templates.search.system;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.templates.search.base.BaseView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseView {
    @Override // com.bytedance.ee.bear.templates.search.base.BaseView
    public final EmptyCategory I7() {
        return EmptyCategory.SEARCH_TEMPLATE_FOR_SYSTEM;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseView
    public final void p() {
        super.p();
    }

    public a(FragmentActivity r2, LifecycleOwner r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        super(r2, r3, r4, 4);
    }
}
