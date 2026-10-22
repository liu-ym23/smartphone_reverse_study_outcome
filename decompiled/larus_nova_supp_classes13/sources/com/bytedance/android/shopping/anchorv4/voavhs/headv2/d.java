package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n {
    public final AnchorV4VM a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
    public final CommonMeta a() {
        return this.a.commonMeta();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
    public final void d() {
        Intrinsics.checkNotNullParameter("product_detail_capture", "eventName");
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.a);
        if (r1 == null) goto L6;
        AnchorV4TrackerImpl.b(r1, "product_detail_capture", false, null, false, null, 30);
        return;
    }

    public d(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
    public final void b(String r11, Map<String, ? extends Object> r12, boolean r13, boolean r14, String r15, View r16, String r17, PageFinder r18) {
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        com.bytedance.android.shopping.anchorv4.tracker.a.a(this.a, r11, r12, r13, true, r15, r17, r18, 64);
    }
}
