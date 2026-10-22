package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ TopNavigationComponentV1 a;

    public u(TopNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r7) {
        com.bytedance.android.shopping.anchorv4.vm.a r8 = (com.bytedance.android.shopping.anchorv4.vm.a) r7;
        List r0 = (List) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.a.O1().d().getData().i.getValue()).a();
        Control r1 = this.a.O1().d().getData().c();
        if (r8 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r1 != null) goto L10;
    L20:
        AnchorV4TabArea r2 = this.a.k2();
        if (r2 == null) goto L29;
        r2.b(r0, r9);
        return;
    L29:
        return;
    L10:
        if (r1.getGulControl() == true) goto L20;
        if (r0 == null) goto L19;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r0.iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        T r5 = r4.next();
        if ((!Intrinsics.areEqual(((ScrollNode) r5).getId(), "id_recommend")) == false) goto L14;
        r3.add(r5);
        goto L14
    L18:
        r0 = r3;
        goto L20
    L19:
        r0 = null;
        goto L20
    L5:
        if (r8.a != true) goto L7;
        r9 = true;
        goto L8
    }
}
