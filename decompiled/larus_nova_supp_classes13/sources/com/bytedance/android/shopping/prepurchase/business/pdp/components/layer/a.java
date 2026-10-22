package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import kotlin.jvm.internal.Intrinsics;
import vg3.k0;
import vg3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements BackComponent.OnClickListener {
    public final /* synthetic */ LoadingComponent a;

    public a(LoadingComponent r1) {
        this.a = r1;
    }

    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        u r6 = (u) this.a.N1(u.class);
        if (r6 == null) goto L6;
        r6.v0(new k0(true, false, 6));
        return;
    }
}
