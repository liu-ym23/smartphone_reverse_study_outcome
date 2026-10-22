package ug3;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.car.f;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import com.bytedance.android.shopping.prepurchase.arch.container.component.j;
import com.bytedance.android.shopping.prepurchase.business.pdp.e;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements f {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<e, PdpDataStore> a;
    public final j b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final CommonMeta a() {
        return this.a.d().getData().a().a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final LinkedTreeMap<String, Object> b() {
        PageMeta r0 = (PageMeta) this.a.d().getData().b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTrackMeta();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final String f() {
        return this.a.d().getData().d();
    }

    public b(com.bytedance.android.shopping.prepurchase.arch.container.c<e, PdpDataStore> r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "serviceRegistry");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.car.f
    public final void g(String r12, Map<String, ? extends Object> r13, boolean r14, boolean r15, String r16, PageFinder r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        w r3 = (w) this.b.getService(w.class);
        if (r3 == null) goto L20;
        ProductDetailEventService.b r4 = r3.m();
        if (r4 == null) goto L20;
        m r5 = r4.d(r13);
        if (r5 == null) goto L20;
        if (r16 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L16;
        Intrinsics.checkNotNull(r16);
        m.a.a(r5, r16, false, null, r17, 6);
    L16:
        if (r19 == null) goto L18;
        r5 = r5.b(r19);
    L18:
        if (r5 == null) goto L20;
        Boolean r2 = Boolean.valueOf(r5.a(r12, r15, r18, r17));
    L21:
        if (r14 == true) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L29;
        w r7 = (w) this.b.getService(w.class);
        if (r7 == null) goto L30;
        w.a.a(r7, r12, null, 6);
        return;
    L30:
        return;
    L29:
        return;
    L10:
        if (r16.length() == 0) goto L13;
        r6 = false;
    L20:
        r2 = null;
        goto L21
    }
}
