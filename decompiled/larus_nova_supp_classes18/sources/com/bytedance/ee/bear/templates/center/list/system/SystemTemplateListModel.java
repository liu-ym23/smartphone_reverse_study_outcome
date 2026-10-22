package com.bytedance.ee.bear.templates.center.list.system;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel;
import com.bytedance.ee.bear.templates.center.list.base.r;
import com.bytedance.ee.bear.templates.data.CategoryTab;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SystemTemplateListModel extends BaseTemplateListModel {
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
        return h().getSystemFilterLiveData();
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel
    public FragmentActivity getActivity() {
        return this.e;
    }

    public SystemTemplateListModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.e = r2;
        this.f = LazyKt.lazy(new SystemTemplateListModel$systemTemplateCacheKey$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel, com.bytedance.ee.bear.templates.center.list.base.p
    public final boolean L5(int r3) {
        if (r3 == 2) goto L6;
        return false;
    L6:
        if (h().entryFormCreateNew() == false) goto L11;
        if (h().getInitFilterType() != 2) goto L11;
        return false;
    L11:
        return com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final NetService.f R3(r r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r5.d == false) goto L5;
        int r0 = r5.c;
        long r1 = r5.e;
        int r6 = r5.f;
        NetService.f r2 = p("space/api/platform/template/category/template_list", r0);
        r2.b("category_id", String.valueOf(r1));
        r2.b("page_size", "30");
        r2.b("page_number", String.valueOf(r6));
        return r2;
    L5:
        NetService.f r3 = p("space/api/platform/template/sys_list_v2", r5.c);
        if (h().entryFormCreateNew() == false) goto L10;
        r3.b("user_recommend", "1");
        return r3;
    L10:
        return r3;
    }

    public final NetService.f p(String r5, int r6) {
        NetService.f r0 = new NetService.f(r5);
        r0.b("template_collection", "1");
        r0.b("platform", "mobile");
        if (h().isOnlyNewLarkForm() == false) goto L5;
        String r7 = "5";
    L6:
        r0.b("version", r7);
        r0.b("ecology", "true");
        if (r6 == (-1)) goto L9;
        r0.b("obj_type", String.valueOf(r6));
    L9:
        boolean r8 = false;
        if (h().entryFormCreateNew() == true) goto L12;
    L18:
        r8 = com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false);
    L19:
        if (r8 == false) goto L21;
        r0.b("docx_template", "1");
    L21:
        return r0;
    L12:
        if (h().getInitFilterType() == 2) goto L16;
        if (h().getInitFilterType() != 22) goto L18;
    L16:
        if (h().getInitFilterType() != 22) goto L19;
        r8 = true;
        goto L19
    L5:
        r7 = "4";
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final NetService.c<TemplateGroupTab> G5(int r17, r r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "params");
        if (r18.d == false) goto L6;
        return new c(r17, r18.a, r19, r18.e);
    L6:
        return new d(getActivity(), r17, r18.c, r18.a, r19, h().getEnterSource(), this);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel, com.bytedance.ee.bear.templates.center.list.base.p
    public final TemplateGroupTab S7(int r54, int r55, Throwable r56) {
        if (h().isOnlyNewLarkForm() == false) goto L13;
        ArrayList r8 = new ArrayList();
        String r0 = com.bytedance.ee.bear.templates.a.a();
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        String r10 = r0;
        if (r10 == null) goto L13;
        r8.add(new TemplateV4(r10, null, r54, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, true, h().getTemplateSource(), 0, 0, null, 1073741818, 7, null));
        String r6 = getActivity().getString(2131887921);
        String r1 = getActivity().getString(2131887879);
        ao5.a r2 = new ao5.a(r6, false, r8, 0, 120);
        return new TemplateGroupTab(r55, CollectionsKt.arrayListOf(new CategoryTab[]{new CategoryTab(r1, CollectionsKt.arrayListOf(new ao5.a[]{r2}), r2.d, 1, r55)}), false, true, null, null, null, 0, true, 244, null);
    L13:
        if (Intrinsics.areEqual("create_new", h().getEnterSource()) == true) goto L21;
        if (Intrinsics.areEqual("create_new_recent", h().getEnterSource()) == true) goto L21;
        if (Intrinsics.areEqual("create_new_folder_block", h().getEnterSource()) == true) goto L21;
    L25:
        return super.S7(r54, r55, r56);
    L21:
        if (r54 == (-1)) goto L25;
        ArrayList r3 = new ArrayList();
        r3.add(new TemplateV4(null, null, r54, null, null, null, 0, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, 0, null, null, null, false, 0, null, null, true, null, 0, 0, null, -1073741829, 7, null));
        String r7 = getActivity().getString(2131887921);
        String r4 = getActivity().getString(2131887879);
        ao5.a r5 = new ao5.a(r7, false, r3, 0, 120);
        return new TemplateGroupTab(r55, CollectionsKt.arrayListOf(new CategoryTab[]{new CategoryTab(r4, CollectionsKt.arrayListOf(new ao5.a[]{r5}), r5.d, 1, r55)}), false, true, null, null, null, 0, true, 244, null);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.BaseTemplateListModel, com.bytedance.ee.bear.templates.center.list.base.p
    public final Flowable<TemplateGroupTab> N7(String r15, int r16, long r17, int r19) {
        Intrinsics.checkNotNullParameter(r15, "lastIndex");
        if (r17 != (-1)) goto L6;
        tt5.a.d("SystemTemplateListModel", "loadMore()...but The categoryId is DEFAULT_CATEGORY_ID, return directly");
        return Flowable.just(new TemplateGroupTab(2, null, false, false, null, null, null, 0, false, 498, null));
    L6:
        String r11 = getCacheKey() + '-' + r17 + '-' + r16 + '-' + r19;
        return Flowable.concat(k(r11, r16, r17, true), o(new r(r11, r15, r16, true, r17, r19))).observeOn(fo5.d.d());
    }
}
