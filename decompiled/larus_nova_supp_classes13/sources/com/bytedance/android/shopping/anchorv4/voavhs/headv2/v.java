package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v implements q, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n {
    public final AnchorV4VM a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
    public final CommonMeta a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
    public final void b(String r11, Map<String, ? extends Object> r12, boolean r13, boolean r14, String r15, View r16, String r17, PageFinder r18) {
        this.b.b(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n
    public final void d() {
        Intrinsics.checkNotNullParameter("product_detail_capture", "eventName");
        this.b.d();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.q
    public final boolean c() {
        return this.a.pageStatus().h;
    }

    public v(AnchorV4VM r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "eventDependency");
        this.b = r3;
        this.a = r2;
    }
}
