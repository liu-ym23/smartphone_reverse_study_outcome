package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Flowable a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        NetService.f r4 = new NetService.f("/space/api/sec_label/visible/?token=" + r2 + "&type=" + r3);
        ((NetService.e) r4).c = 2;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new e0()).a(r4);
    }
}
