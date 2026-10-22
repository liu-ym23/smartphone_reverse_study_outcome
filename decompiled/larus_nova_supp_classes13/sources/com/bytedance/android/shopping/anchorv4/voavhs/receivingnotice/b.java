package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements a {
    public final /* synthetic */ AnchorV4ReceivingNoticeVH a;

    public final void b() {
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(this.a.q, "dutyfree_logistics_info_show", null, false, null, null, null, null, 246);
    }

    public b(AnchorV4ReceivingNoticeVH r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.a
    public final void a(String r11) {
        Intrinsics.checkNotNullParameter(r11, "receiveType");
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(this.a.q, "dutyfree_logistics_info_click", MapsKt.mapOf(TuplesKt.to("logistic_type", r11)), false, null, null, null, null, 252);
    }
}
