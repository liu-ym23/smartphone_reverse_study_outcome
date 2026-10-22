package com.bytedance.android.shopping.mall.homepage.pagecard;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int c = 0;
    public c a;
    public String b;

    public static final class a {
        public static String a() {
            Lazy r0 = HybridAppInfoService.a;
            if (HybridAppInfoService.j() == false) goto L6;
            return "hybrid://lynxview?surl=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_mall_cards_dylite%2Fcards%2Fpage_card%2Ftemplate.js&enable_js_runtime=true&enable_code_cache=1";
        L6:
            if (HybridAppInfoService.i() == true) goto L11;
            return null;
        L11:
            return "hybrid://lynxview?surl=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2F" + NativeMallGeckoHelper.b() + "%2Fcards%2Fpage_card%2Ftemplate.js&enable_js_runtime=true&enable_code_cache=1";
        }
    }

    static {
    }

    public final synchronized c a() {
        monitor-enter(this);
        c r0 = this.a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public d() {
    }

    public final void b(String r2, Long r3) {
        if (this.a == null) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        r2 = a.a();
    L7:
        this.b = r2;
        if (r3 == null) goto L10;
        r3.longValue();
    L10:
        String r4 = this.b;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        this.a = new c(r4);
        return;
    }
}
