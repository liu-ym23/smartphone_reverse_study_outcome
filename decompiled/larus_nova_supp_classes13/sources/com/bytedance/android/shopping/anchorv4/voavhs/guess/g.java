package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.n;
import com.google.gson.internal.LinkedTreeMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements h, com.bytedance.android.shopping.anchorv4.voavhs.car.f {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> a;
    public final j b;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.car.f c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.c.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        return this.c.b();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final String f() {
        return this.c.f();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final void g(String r11, Map<String, ? extends Object> r12, boolean r13, boolean r14, String r15, PageFinder r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        this.c.g(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.h
    public final int C() {
        n r0 = (n) this.a.d().getData().a.a();
        if (r0 == null) goto L7;
        List<j63.c> r1 = r0.i;
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.h
    public final void B(int r3) {
        x r0 = (x) this.b.getService(x.class);
        if (r0 == null) goto L6;
        r0.B(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.h
    public final void p(GULFeedbackDislikeReq r3) {
        Intrinsics.checkNotNullParameter(r3, "req");
        x r0 = (x) this.b.getService(x.class);
        if (r0 == null) goto L6;
        r0.p(r3);
        return;
    }

    public g(com.bytedance.android.shopping.prepurchase.arch.container.c r2, j r3, ug3.b r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Intrinsics.checkNotNullParameter(r4, "eventService");
        this.c = r4;
        this.a = r2;
        this.b = r3;
    }
}
