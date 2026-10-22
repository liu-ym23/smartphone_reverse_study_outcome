package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements e, com.bytedance.android.shopping.anchorv4.voavhs.car.f {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.car.f b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        return this.b.b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final String f() {
        return this.b.f();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final void g(String r11, Map<String, ? extends Object> r12, boolean r13, boolean r14, String r15, PageFinder r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        this.b.g(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.e
    public final boolean d() {
        return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a)).b.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.e
    public final boolean j() {
        Boolean r0 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a)).b.d.a();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public g(ug3.b r2, com.bytedance.android.shopping.prepurchase.arch.container.c r3) {
        Intrinsics.checkNotNullParameter(r2, "tracker");
        Intrinsics.checkNotNullParameter(r3, "pageContext");
        this.b = r2;
        this.a = r3;
    }
}
