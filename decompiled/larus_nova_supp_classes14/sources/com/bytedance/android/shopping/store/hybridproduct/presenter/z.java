package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z<T> implements Observer {
    public final /* synthetic */ ShopSliceProductFilterPresenter a;

    public z(ShopSliceProductFilterPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r3, r0) == false) goto L9;
        com.bytedance.android.ec.store.repository.vo.k r4 = this.a.i;
        if (r4 == null) goto L14;
        Map<String, Object> r5 = r4.d;
        if (r5 == null) goto L14;
        r5.put("select_panel_has_select", r0);
    L14:
        this.a.d0();
        return;
    L9:
        com.bytedance.android.ec.store.repository.vo.k r6 = this.a.i;
        if (r6 == null) goto L14;
        Map<String, Object> r7 = r6.d;
        if (r7 == null) goto L14;
        r7.put("select_panel_has_select", Boolean.FALSE);
        goto L14
    }
}
