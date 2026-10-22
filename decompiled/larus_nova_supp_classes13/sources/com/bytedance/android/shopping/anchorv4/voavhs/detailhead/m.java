package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements w {
    public final /* synthetic */ AnchorV4DetailHeadView a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w
    public final void c() {
    }

    public m(AnchorV4DetailHeadView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w
    public final void b(String r11, String r12, String r13) {
        int r0 = b.a;
        t r1 = this.a.n;
        if (r1 == null) goto L6;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r1, "info_explanation_entrance_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("label_name", r12), TuplesKt.to("shop_id", r11), TuplesKt.to("character_type", r13)}), false, null, null, null, null, 252);
        return;
    }
}
