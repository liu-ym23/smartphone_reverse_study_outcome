package com.bytedance.android.shopping.yata.biz.popup;

import hl3.e;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PopupLayer$create$1 extends MutablePropertyReference0Impl {
    public PopupLayer$create$1(PopupLayer r7) {
        super(r7, PopupLayer.class, "host", "getHost()Lcom/bytedance/android/shopping/yata/biz/popup/api/IPopupLayer$IPopupHost;", 0);
    }

    public Object get() {
        e.a r0 = ((PopupLayer) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("host");
    L5:
        return r0;
    }

    public void set(Object r2) {
        e.a r3 = (e.a) r2;
        ((PopupLayer) ((CallableReference) this).receiver).c = r3;
    }
}
