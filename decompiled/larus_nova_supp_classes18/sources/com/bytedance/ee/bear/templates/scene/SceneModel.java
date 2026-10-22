package com.bytedance.ee.bear.templates.scene;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SceneModel implements c {
    public final FragmentActivity a;
    public final Lazy b;

    public static final class a implements TemplateUtils.a {
        public final /* synthetic */ SceneModel a;

        public a(SceneModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r5) {
            Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_URL);
            if (this.a.getActivity().isFinishing() == false) goto L5;
            return;
        L5:
            if (this.a.getActivity().isDestroyed() == true) goto L10;
            RouteBean r0 = new RouteBean();
            r0.c = 1;
            ((h) org.koin.java.a.c(h.class, null, null, 6)).m9(r5, r0);
            return;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "it");
            return new TopicDataResult();
        }
    }

    public final void create() {
    }

    public final void destroy() {
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public SceneModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(SceneModel$netService$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.templates.scene.c
    public final void b4(TemplateV4 r10) {
        Intrinsics.checkNotNullParameter(r10, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateUtils.f(TemplateUtils.a, r10.getObjType(), r10.getObjToken(), r10.getCollectionId(), null, String.valueOf(r10.getTemplateType()), new a(this), 8);
    }

    @Override // com.bytedance.ee.bear.templates.scene.c
    public final Flowable<TopicDataResult> v0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "topicID");
        e r1 = new e();
        NetService.d r2 = ((NetService) this.b.getValue()).Vc(r1);
        Intrinsics.checkNotNullParameter(r5, "topicID");
        NetService.f r0 = new NetService.f("/space/api/platform/template/topic_template_list/");
        r0.b("topic_id", r5);
        r0.b("platform", "mobile");
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L5;
        r0.b("docx_template", "1");
    L5:
        ((NetService.e) r0).c = 2;
        return r2.a(r0).onErrorReturn(b.a);
    }
}
