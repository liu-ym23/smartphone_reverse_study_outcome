package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMarketingHelper {
    public String a;
    public boolean b;
    public final ECMarketingHelper$scrollerListener$1 c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.mall.homepage.tools.ECMarketingHelper$scrollerListener$1] */
    public ECMarketingHelper() {
        this.a = "";
        this.c = new ECMarketingHelper$scrollerListener$1(this);
    }

    public static IMarketingServiceV2 a() {
        ServiceManager r0 = ServiceManager.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (IMarketingServiceV2) r0.getService(IMarketingServiceV2.class);
    }
}
