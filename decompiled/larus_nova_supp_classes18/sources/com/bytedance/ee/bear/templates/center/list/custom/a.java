package com.bytedance.ee.bear.templates.center.list.custom;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter;
import com.bytedance.ee.bear.templates.center.list.base.p;
import com.bytedance.ee.bear.templates.center.list.base.q;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseTemplateListPresenter {
    public final Fragment l;
    public final CustomTemplateListModel m;
    public final b n;

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final Fragment M8() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final p N8() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter
    public final q P8() {
        return this.n;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListPresenter, com.bytedance.ee.bear.templates.center.list.base.q.a
    public final void V6(CategoryTab r3) {
        Intrinsics.checkNotNullParameter(r3, "categoryTab");
        super.V6(r3);
        CharSequence r4 = r3.getCategoryTabName();
        if (Intrinsics.areEqual(r4, this.l.getString(2131887936)) == false) goto L6;
        int r5 = 1;
    L9:
        this.m.g = r5;
        return;
    L6:
        if (Intrinsics.areEqual(r4, this.l.getString(2131887980)) == false) goto L8;
        r5 = 2;
        goto L9
    L8:
        r5 = 0;
        goto L9
    }

    public a(Fragment r2, CustomTemplateListModel r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        super(r2, r3, r4, r2.getString(2131887886));
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }
}
