package com.bytedance.ee.bear.templates.search.base;

import android.view.View;
import com.bytedance.ee.bear.templates.center.list.CategoryIndicatorAdapter;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements BaseQuickAdapter.OnItemClickListener {
    public final /* synthetic */ BaseView a;

    public b(BaseView r1) {
        this.a = r1;
    }

    public final void onItemClick(BaseQuickAdapter r1, View r2, int r3) {
        Object r4 = ListProtector.get(r1.getData(), r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.data.CategoryTab");
        CategoryTab r5 = (CategoryTab) r4;
        CategoryIndicatorAdapter r6 = this.a.f;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("categoryIndicatorAdapter");
        r6 = null;
    L5:
        r6.a = r3;
        r6.notifyDataSetChanged();
        this.a.w3(r5);
        BaseView r7 = this.a;
        r7.h = r3;
        r7.c.findViewById(2131388317).scrollToPosition(0);
    }
}
