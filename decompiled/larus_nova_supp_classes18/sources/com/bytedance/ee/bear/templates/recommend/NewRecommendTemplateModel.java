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
import io.reactivex.Flowable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class NewRecommendTemplateModel implements com.bytedance.ee.bear.templates.recommend.a {
    public final Fragment a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public NewRecommendTemplateViewModel e;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.templates.recommend.a
    public final Flowable<RecommendTemplates> K() {
        Flowable r0 = Flowable.just((String) this.d.getValue()).observeOn(fo5.d.b()).flatMap(new c(this)).onErrorReturn(d.a);
        NetService.f r1 = new NetService.f("/space/api/obj_template/recommend/");
        r1.b("platform", "mobile");
        r1.b("scene", "new_entry");
        r1.b("version", "4");
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L5;
        r1.b("docx_template", "1");
    L5:
        ((NetService.e) r1).c = 2;
        return Flowable.concat(r0, ((NetService) this.c.getValue()).Vc(new e(this)).a(r1).onErrorReturn(f.a)).observeOn(fo5.d.d());
    }

    public final void create() {
        FragmentActivity r0 = this.a.getActivity();
        Intrinsics.checkNotNull(r0);
        this.e = (NewRecommendTemplateViewModel) ViewModelProviders.of(r0).get(NewRecommendTemplateViewModel.class);
    }

    public NewRecommendTemplateModel(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = LazyKt.lazy(NewRecommendTemplateModel$cacheService$2.INSTANCE);
        this.c = LazyKt.lazy(NewRecommendTemplateModel$netService$2.INSTANCE);
        this.d = LazyKt.lazy(NewRecommendTemplateModel$cacheKey$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.templates.recommend.a
    public final void n7(TemplateV4 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
        NewRecommendTemplateViewModel r0 = this.e;
        if (r0 == null) goto L6;
        r0.setSelectedTemplate(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.recommend.a
    public final Flowable<DocumentCreateInfo> x6(TemplateV4 r14, String r15, String r16, String r17, CreateSelectResult r18) {
        Intrinsics.checkNotNullParameter(r14, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r15, "parentToken");
        Intrinsics.checkNotNullParameter(r16, "module");
        Intrinsics.checkNotNullParameter(r17, "spaceId");
        Intrinsics.checkNotNullParameter(r18, "createSelectResult");
        g0 r0 = new g0();
        String r2 = r14.getObjToken();
        String r3 = r14.getName();
        int r4 = r14.getObjType();
        boolean r7 = true;
        if (r14.getSource() == 1) goto L7;
        r7 = false;
    L7:
        return r0.b(new com.bytedance.ee.bear.list.create.l(r2, r3, r4, true, r16, r7, null, null, r18, r17));
    }
}
