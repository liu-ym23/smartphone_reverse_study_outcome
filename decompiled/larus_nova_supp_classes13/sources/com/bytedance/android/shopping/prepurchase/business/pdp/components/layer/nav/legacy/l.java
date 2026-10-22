package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface l {
    CommonMeta a();

    void d(Function1<? super vg3.z, Unit> r1);

    long getDuration();

    String getSessionId();

    void u(String r1);
}
