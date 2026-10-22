package com.bytedance.ee.bear.templates.center.list.base;

import android.view.View;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.list.CategoryIndicatorAdapter;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements BaseQuickAdapter.OnItemClickListener {
    public final /* synthetic */ BaseTemplateListView a;

    public k(BaseTemplateListView r1) {
        this.a = r1;
    }

    public final void onItemClick(BaseQuickAdapter r2, View r3, int r4) {
        this.a.s().getCategoryIndex().setValue(Integer.valueOf(r4));
        Object r5 = ListProtector.get(r2.getData(), r4);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.templates.data.CategoryTab");
        CategoryTab r6 = (CategoryTab) r5;
        CategoryIndicatorAdapter r7 = this.a.k();
        r7.a = r4;
        r7.notifyDataSetChanged();
        this.a.w3(r6);
        q.a r8 = this.a.d;
        if (r8 == null) goto L5;
        r8.V6(r6);
    L5:
        BaseTemplateListView r9 = this.a;
        r9.h = r4;
        r9.c.findViewById(2131388317).scrollToPosition(0);
        TemplateReportV2 r10 = TemplateReportV2.a;
        String r11 = r6.getCategoryTabName().toString();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        TemplateReportV2.f = r11;
        TemplateReportV2.e(r11, this.a.M4());
    }
}
