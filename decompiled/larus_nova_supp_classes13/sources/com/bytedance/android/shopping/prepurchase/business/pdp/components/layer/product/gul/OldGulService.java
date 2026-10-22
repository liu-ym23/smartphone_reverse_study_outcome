package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.n;
import j63.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import vg3.d0;
import vg3.j;
import vg3.m;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OldGulService extends b0 implements j {
    public static final /* synthetic */ int i = 0;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{d0.class, m.class, x.class});
    }

    @Override // vg3.j
    public final void u0() {
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "forceInitGULComponent with OldGulService");
        n r0 = (n) O1().d().getData().a.a();
        if (r0 == null) goto L7;
        List<c> r1 = r0.i;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 > 0) goto L11;
        Z1(x.class, new OldGulService$tryLoadGul$1(this, null));
        return;
    L11:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, j.class, this, false, 12);
        Z1(d0.class, new OldGulService$onAttach$1(this, null));
    }

    public OldGulService() {
    }
}
