package com.bytedance.ee.bear.quoto;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements u {
    public k() {
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.quoto.u
    public final Flowable<QuotaInfoResult> e2(String r3, String r4) {
        NetService.f r0 = new NetService.f("/space/api/box/quota/info/");
        if (TextUtils.isEmpty(r3) == true) goto L8;
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r0.b("mount_node_token", r3);
        r0.b("mount_point", r4);
    L8:
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new j()).a(r0);
    }
}
