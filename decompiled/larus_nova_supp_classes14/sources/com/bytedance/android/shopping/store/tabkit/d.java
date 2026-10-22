package com.bytedance.android.shopping.store.tabkit;

import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchMethod;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ pd.f a;
    public final /* synthetic */ ECBaseBridgeMethod b;

    public d(pd.f r1, NativePrefetchMethod r2) {
        this.a = r1;
        this.b = r2;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return this.a.d(this.b);
    }
}
