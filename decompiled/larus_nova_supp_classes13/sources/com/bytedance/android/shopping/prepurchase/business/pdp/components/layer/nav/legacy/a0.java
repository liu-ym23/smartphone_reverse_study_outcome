package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface a0 extends l {
    LinkedTreeMap<String, Object> b();

    V4NativeParams c();

    CompositeDisposable compositeDisposable();

    boolean e();

    boolean isExpanded();

    boolean n();

    void o(String r1);

    void openSchema(String r1);

    long p();

    void q(com.bytedance.android.shopping.anchorv4.log.d r1, Object r2, int r3);

    void s(boolean r1);

    void t(com.bytedance.android.shopping.prepurchase.arch.container.ability.b r1);
}
