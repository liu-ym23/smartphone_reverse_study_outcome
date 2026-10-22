package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.shopping.api.mall.ILegouMallService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public boolean a;
    public String b;

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        ILegouMallService r4 = (ILegouMallService) ServiceManager.get().getService(ILegouMallService.class);
        if ((!Intrinsics.areEqual(r2, null)) == true) goto L6;
        r4.g(r2);
        return;
    }
}
