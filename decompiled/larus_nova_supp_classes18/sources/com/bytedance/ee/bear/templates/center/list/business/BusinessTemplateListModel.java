package com.bytedance.ee.bear.templates.center.list.business;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel;
import com.bytedance.ee.bear.templates.center.list.base.r;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BusinessTemplateListModel extends BaseTemplateListModel {
    public final FragmentActivity e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final String getCacheKey() {
        return (String) this.f.getValue();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final LiveData<e> u7() {
        return h().getBusinessFilterLiveData();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel
    public FragmentActivity getActivity() {
        return this.e;
    }

    public BusinessTemplateListModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.e = r2;
        this.f = LazyKt.lazy(BusinessTemplateListModel$businessTemplateCacheKey$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final NetService.f R3(r r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        NetService.f r0 = new NetService.f("/space/api/platform/template/co_list/");
        int r5 = r4.c;
        if (r5 == (-1)) goto L6;
        r0.b("obj_type", String.valueOf(r5));
    L6:
        if (c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L8;
        r0.b("docx_template", "1");
    L8:
        return r0;
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final NetService.c<TemplateGroupTab> G5(int r2, r r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        return new b(r2, r3.a, r4);
    }
}
