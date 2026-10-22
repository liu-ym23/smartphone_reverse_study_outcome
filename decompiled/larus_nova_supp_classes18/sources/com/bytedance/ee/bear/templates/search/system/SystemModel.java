package com.bytedance.ee.bear.templates.search.system;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.search.base.BaseSearchModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SystemModel extends BaseSearchModel {
    public final Lazy d;

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final String getTemplateType() {
        return "pgc";
    }

    public SystemModel(final FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.d = LazyKt.lazy(new SystemModel$templateCenViewModel$2(r2));
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BaseSearchModel, com.bytedance.ee.bear.templates.search.base.e
    public final NetService.f S5(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "searchKey");
        Intrinsics.checkNotNullParameter(r4, "buffer");
        NetService.f r5 = super.S5(r2, r3, r4);
        r5.b("source", "1");
        r5.b("template_collection", "1");
        if (((TemplateCenterViewModel) this.d.getValue()).entryFormCreateNew() == false) goto L5;
        r5.b("user_recommend", "1");
    L5:
        return r5;
    }
}
