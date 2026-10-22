package com.bytedance.ee.bear.templates.search.base;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseSearchModel implements e {
    public final FragmentActivity a;
    public final Lazy b;
    public final Lazy c;

    public static final class a<T, R> implements Function {
        public static final a<T, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r13) {
            Throwable r6 = (Throwable) r13;
            Intrinsics.checkNotNullParameter(r6, "it");
            return new TemplateGroupTab(2, new ArrayList(), false, false, null, r6, null, 0, false, 476, null);
        }
    }

    public final void create() {
    }

    public final void destroy() {
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public BaseSearchModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(BaseSearchModel$netService$2.INSTANCE);
        this.c = LazyKt.lazy(new BaseSearchModel$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final Flowable<TemplateGroupTab> H5(String r4) {
        Intrinsics.checkNotNullParameter(r4, "searchKey");
        Intrinsics.checkNotNullParameter(r4, "searchKey");
        BaseSearchParser r0 = new BaseSearchParser(r4);
        return ((NetService) this.b.getValue()).Vc(r0).a(S5(0, r4, "")).onErrorReturn(a.a);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final Flowable<TemplateGroupTab> D7(int r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "searchKey");
        Intrinsics.checkNotNullParameter(r15, "buffer");
        if (r13 != 0) goto L5;
    L9:
        tt5.a.d("BaseSearchModel", "loadMore()...but offset is 0, return directly");
        return Flowable.just(new TemplateGroupTab(2, null, false, false, null, null, null, 0, false, 498, null));
    L5:
        if (StringsKt.isBlank(r14) == true) goto L9;
        Intrinsics.checkNotNullParameter(r14, "searchKey");
        BaseSearchParser r0 = new BaseSearchParser(r14);
        return ((NetService) this.b.getValue()).Vc(r0).a(S5(r13, r14, r15)).onErrorReturn(com.bytedance.ee.bear.templates.search.base.a.a);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public NetService.f S5(int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "searchKey");
        Intrinsics.checkNotNullParameter(r6, "buffer");
        NetService.f r1 = new NetService.f("/space/api/platform/template/search/");
        r1.b("offset", String.valueOf(r4));
        r1.b("page_count", "30");
        r1.b("keyword", r5);
        r1.b("buffer", r6);
        r1.b("ecology", "true");
        if (((TemplateCenterViewModel) this.c.getValue()).isOnlyNewLarkForm() == false) goto L5;
        r1.b("version", "5");
    L5:
        String r7 = ((TemplateCenterViewModel) this.c.getValue()).getSearchFilterType();
        if (r7 == null) goto L9;
        r1.b("obj_type", r7);
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L11;
        r1.b("docx_template", "1");
    L11:
        ((NetService.e) r1).c = 2;
        return r1;
    }
}
