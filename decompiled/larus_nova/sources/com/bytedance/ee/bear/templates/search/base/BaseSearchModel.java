package com.bytedance.ee.bear.templates.search.base;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseSearchModel implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f239363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f239364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f239365c;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f239366a = null;

        static {
            f239366a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            Throwable r100 = (Throwable) r110;
            Intrinsics.checkNotNullParameter(r100, "it");
            return new TemplateGroupTab(2, new ArrayList(), false, false, null, r100, null, 0, false, 476, null);
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public final FragmentActivity getActivity() {
        return this.f239363a;
    }

    public BaseSearchModel(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f239363a = r100;
        this.f239364b = LazyKt.lazy(BaseSearchModel$netService$2.INSTANCE);
        this.f239365c = LazyKt.lazy(new BaseSearchModel$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final Flowable<TemplateGroupTab> H5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "searchKey");
        Intrinsics.checkNotNullParameter(r100, "searchKey");
        BaseSearchParser r101 = new BaseSearchParser(r100);
        return ((NetService) this.f239364b.getValue()).Vc(r101).a(S5(0, r100, "")).onErrorReturn(a.f239366a);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public final Flowable<TemplateGroupTab> D7(int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "searchKey");
        Intrinsics.checkNotNullParameter(r112, "buffer");
        if (r110 != 0) goto L5;
    L9:
        tt5.a.d("BaseSearchModel", "loadMore()...but offset is 0, return directly");
        return Flowable.just(new TemplateGroupTab(2, null, false, false, null, null, null, 0, false, TTVideoEngineInterface.PLAYER_OPTION_LAZY_SEEK, null));
    L5:
        if (StringsKt.isBlank(r111) == true) goto L9;
        Intrinsics.checkNotNullParameter(r111, "searchKey");
        BaseSearchParser r100 = new BaseSearchParser(r111);
        return ((NetService) this.f239364b.getValue()).Vc(r100).a(S5(r110, r111, r112)).onErrorReturn(com.bytedance.ee.bear.templates.search.base.a.f239384a);
    }

    @Override // com.bytedance.ee.bear.templates.search.base.e
    public NetService.f S5(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "searchKey");
        Intrinsics.checkNotNullParameter(r102, "buffer");
        NetService.f r103 = new NetService.f("/space/api/platform/template/search/");
        r103.b("offset", String.valueOf(r100));
        r103.b("page_count", BDLocationException.ERROR_SDK_NO_PERMISSION);
        r103.b("keyword", r101);
        r103.b("buffer", r102);
        r103.b("ecology", "true");
        if (((TemplateCenterViewModel) this.f239365c.getValue()).isOnlyNewLarkForm() == false) goto L5;
        r103.b("version", "5");
    L5:
        String r104 = ((TemplateCenterViewModel) this.f239365c.getValue()).getSearchFilterType();
        if (r104 == null) goto L9;
        r103.b("obj_type", r104);
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.template_docx", false) == false) goto L11;
        r103.b("docx_template", "1");
    L11:
        r103.f216906c = 2;
        return r103;
    }
}
