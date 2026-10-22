package po0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.di.MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory;
import com.bytedance.android.live.openplatform.impl.miniappaudience.di.MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory;
import com.bytedance.android.live.openplatform.impl.minigameanchor.di.MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory;
import com.bytedance.android.live.openplatform.impl.minigameaudience.di.MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory;
import com.bytedance.android.live.openplatform.impl.openapi.di.OpenApiModule_ProvideOpenApiServiceFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: po0.a$a, reason: collision with other inner class name */
    public static final class C7216a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f530019a;

        public C7216a(b r100) {
            this.f530019a = r100;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f530020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Provider<so0.a> f530021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Provider<yo0.b> f530022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Provider<to0.a> f530023d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Provider<vo0.a> f530024e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Provider<wo0.a> f530025f;

        public final C7216a a() {
            return new C7216a(this.f530020a);
        }

        public b(qp0.a r100, jq0.a r101, ar0.a r102, hr0.a r103, or0.a r104) {
            this.f530020a = this;
            this.f530021b = DoubleCheck.provider(MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory.create(r100));
            this.f530022c = DoubleCheck.provider(OpenApiModule_ProvideOpenApiServiceFactory.create(r104));
            this.f530023d = DoubleCheck.provider(MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory.create(r101));
            this.f530024e = DoubleCheck.provider(MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory.create(r102));
            this.f530025f = DoubleCheck.provider(MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory.create(r103));
        }
    }

    public static b a() {
        return new b(new qp0.a(), new jq0.a(), new ar0.a(), new hr0.a(), new or0.a());
    }
}
