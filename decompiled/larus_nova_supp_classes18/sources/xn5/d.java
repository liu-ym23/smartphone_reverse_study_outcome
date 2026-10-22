package xn5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.banner.BannerDataResult;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements a {
    public d() {
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // xn5.a
    public final Flowable<BannerDataResult> C8() {
        NetService.d r0 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(c.a);
        NetService.f r1 = new NetService.f("/space/api/platform/template/template_banner/");
        r1.b("scene", "tc");
        r1.b("platform", "mobile");
        r1.b("template_collection", "1");
        ((NetService.e) r1).c = 2;
        return r0.a(r1);
    }
}
