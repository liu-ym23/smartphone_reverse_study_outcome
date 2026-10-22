package com.bytedance.ee.bear.quoto;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 implements w {
    public a0() {
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.quoto.w
    public final Flowable<BusinessInfoRequester$BusinessInfoResult> E1() {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
        tt5.a.h("BusinessInfoRequester", "pullInfo");
        NetService.f r1 = new NetService.f("/space/api/box/business/info/");
        ((NetService.e) r1).c = 2;
        return r0.a(r1).map(new a());
    }
}
