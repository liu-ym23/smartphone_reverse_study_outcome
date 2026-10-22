package com.bytedance.ee.bear.templates.center.list.custom;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel;
import com.bytedance.ee.bear.templates.center.list.base.r;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import io.reactivex.Flowable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CustomTemplateListModel extends BaseTemplateListModel {
    public final FragmentActivity e;
    public final Lazy f;
    public int g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel
    public final void create() {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final String getCacheKey() {
        return (String) this.f.getValue();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final LiveData<e> u7() {
        return h().getCustomFilterLiveData();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel
    public FragmentActivity getActivity() {
        return this.e;
    }

    public CustomTemplateListModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.e = r2;
        this.f = LazyKt.lazy(CustomTemplateListModel$customTemplateCacheKey$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final NetService.f R3(r r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        NetService.f r0 = new NetService.f("/space/api/platform/template/custom_list/");
        int r1 = r5.c;
        if (r1 == (-1)) goto L5;
        r0.b("obj_type", String.valueOf(r1));
    L5:
        r0.b("page_count", "24");
        String r2 = r5.b;
        if (r2.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r2 = "0";
    L11:
        r0.b("share_index", r2);
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L14;
        r0.b("docx_template", "1");
    L14:
        int r4 = this.g;
        if (r4 != 0) goto L17;
    L19:
        return r0;
    L17:
        if (r5.d == false) goto L19;
        r0.b("data_type", String.valueOf(r4));
        goto L19
    L8:
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final NetService.c<TemplateGroupTab> G5(int r9, r r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        return new c(getActivity(), r9, r10.a, r11, r10.d, !Intrinsics.areEqual(u7().getValue(), e.e));
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel, com.bytedance.ee.bear.templates.center.list.base.p
    public final Flowable<TemplateGroupTab> N7(String r16, int r17, long r18, int r20) {
        Intrinsics.checkNotNullParameter(r16, "lastIndex");
        boolean r1 = false;
        if (r16.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L18;
        String r2 = "0";
        if (Intrinsics.areEqual(r16, "0") == true) goto L18;
        if (r16.length() != 0) goto L13;
        r1 = true;
    L13:
        if (r1 == true) goto L17;
        r2 = r16;
    L17:
        return o(new r(getCacheKey() + '_' + r2 + '_' + r17, r16, r17, true, 0, 48, 0));
    L18:
        tt5.a.d("CustomTemplateListModel", "loadMore()...but index is empty or is 0, return directly");
        return Flowable.just(new TemplateGroupTab(2, null, false, false, null, null, null, 0, false, 498, null));
    L5:
        r0 = false;
        goto L6
    }
}
