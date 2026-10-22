package com.bytedance.android.shopping.mall.homepage;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$pageStateHelper$1 extends com.bytedance.android.shopping.api.mall.b {
    public final Lazy b;
    public final /* synthetic */ ECMallFragment c;

    @Override // com.bytedance.android.shopping.api.mall.b
    public final boolean a() {
        if (this.c.v3 == true) goto L5;
    L8:
        return false;
    L5:
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L7;
        this.c.getClass();
        goto L8
    L7:
        return true;
    }

    public ECMallFragment$pageStateHelper$1(ECMallFragment r1) {
        this.c = r1;
        this.b = LazyKt.lazy(ECMallFragment$pageStateHelper$1$visibilityStrictCheckEnable$2.INSTANCE);
    }
}
