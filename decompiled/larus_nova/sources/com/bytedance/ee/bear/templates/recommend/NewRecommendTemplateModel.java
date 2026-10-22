package com.bytedance.ee.bear.templates.recommend;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.Flowable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class NewRecommendTemplateModel implements com.bytedance.ee.bear.templates.recommend.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f239259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f239260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f239261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f239262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NewRecommendTemplateViewModel f239263e;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.recommend.a
    public final Flowable<RecommendTemplates> K() {
        Flowable r100 = Flowable.just((String) this.f239262d.getValue()).observeOn(fo5.d.b()).flatMap(new c(this)).onErrorReturn(d.f239265a);
        NetService.f r101 = new NetService.f("/space/api/obj_template/recommend/");
        r101.b("platform", "mobile");
        r101.b("scene", "new_entry");
        r101.b("version", "4");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.template_docx", false) == false) goto L5;
        r101.b("docx_template", "1");
    L5:
        r101.f216906c = 2;
        return Flowable.concat(r100, ((NetService) this.f239261c.getValue()).Vc(new e(this)).a(r101).onErrorReturn(f.f239267a)).observeOn(fo5.d.d());
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        FragmentActivity r100 = this.f239259a.getActivity();
        Intrinsics.checkNotNull(r100);
        this.f239263e = (NewRecommendTemplateViewModel) ViewModelProviders.of(r100).get(NewRecommendTemplateViewModel.class);
    }

    public NewRecommendTemplateModel(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f239259a = r100;
        this.f239260b = LazyKt.lazy(NewRecommendTemplateModel$cacheService$2.INSTANCE);
        this.f239261c = LazyKt.lazy(NewRecommendTemplateModel$netService$2.INSTANCE);
        this.f239262d = LazyKt.lazy(NewRecommendTemplateModel$cacheKey$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.templates.recommend.a
    public final void n7(TemplateV4 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        NewRecommendTemplateViewModel r102 = this.f239263e;
        if (r102 == null) goto L6;
        r102.setSelectedTemplate(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.a
    public final Flowable<DocumentCreateInfo> x6(TemplateV4 r110, String r111, String r112, String r113, CreateSelectResult r114) {
        Intrinsics.checkNotNullParameter(r110, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r111, "parentToken");
        Intrinsics.checkNotNullParameter(r112, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r113, "spaceId");
        Intrinsics.checkNotNullParameter(r114, "createSelectResult");
        g0 r100 = new g0();
        String r101 = r110.getObjToken();
        String r102 = r110.getName();
        int r103 = r110.getObjType();
        boolean r104 = true;
        if (r110.getSource() == 1) goto L7;
        r104 = false;
    L7:
        return r100.b(new com.bytedance.ee.bear.list.create.l(r101, r102, r103, true, r112, r104, null, null, r114, r113));
    }
}
