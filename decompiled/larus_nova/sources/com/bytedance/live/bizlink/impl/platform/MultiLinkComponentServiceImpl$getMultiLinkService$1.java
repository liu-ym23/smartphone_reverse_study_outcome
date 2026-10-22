package com.bytedance.live.bizlink.impl.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import vb6.g;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkComponentServiceImpl$getMultiLinkService$1 extends MutablePropertyReference0Impl {
    public MultiLinkComponentServiceImpl$getMultiLinkService$1(a r100) {
        super(r100, a.class, "mLinkService", "getMLinkService()Lcom/bytedance/kmp/live/livelink/api/multilink/IMultiLinkService;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        g r100 = ((a) this.receiver).f254868a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLinkService");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        g r101 = (g) r100;
        ((a) this.receiver).f254868a = r101;
    }
}
