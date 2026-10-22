package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p {
    public final NetService a;

    public p(NetService r1) {
        this.a = r1;
    }

    public final Flowable<Boolean> a(String r4, String r5) {
        NetService.f r0 = new NetService.f("/space/api/wiki/v2/tree/update_title/");
        ((NetService.e) r0).c = 1;
        HashMap r1 = new HashMap();
        r1.put("wiki_token", r4);
        r1.put("name", r5);
        r0.d(r1);
        return this.a.Vc(new ax4.f()).a(r0).map(new l());
    }
}
