package com.bytedance.android.shopping.store.tabkit.ssr.interfaces;

import android.os.Handler;
import com.bytedance.android.shopping.store.tabkit.ssr.SSRModel;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SSRFetchCallbackDelegate implements ISSRFetchCallback {
    public final AtomicBoolean a;
    public final ISSRFetchCallback b;
    public final Map<String, Long> c;

    @Override // com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback
    public final void onFailed(final SSRModel r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (this.a.getAndSet(true) == false) goto L5;
        return;
    L5:
        Handler r0 = CommonUtils.a;
        CommonUtils.e(false, new AnonymousClass1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback
    public final void onSSRHydrate(final SSRModel r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (this.a.getAndSet(true) == false) goto L5;
        return;
    L5:
        Handler r0 = CommonUtils.a;
        CommonUtils.e(false, new C02001(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback
    public final void onSSRRender(final SSRModel r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Handler r0 = CommonUtils.a;
        CommonUtils.e(false, new C02011(this, r2));
    }

    public SSRFetchCallbackDelegate(ISSRFetchCallback r2, Map<String, Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        Intrinsics.checkNotNullParameter(r3, "timing");
        this.b = r2;
        this.c = r3;
        this.a = new AtomicBoolean(false);
    }
}
