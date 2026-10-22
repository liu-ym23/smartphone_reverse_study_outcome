package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public e73.a a;
    public boolean b;
    public boolean c;
    public final Context d;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e e;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j f;
    public final com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f g;

    public final void a(e73.a r9) {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        if (r9.b() == null) goto L9;
        long r0 = System.currentTimeMillis();
        b(r9.b());
        Set r10 = ECProcessMonitor.a;
        ECProcessMonitor.k("pdp_before_render", System.currentTimeMillis() - r0, null, null, 24);
        return;
    }

    public final boolean b(IAction r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.d != null) goto L8;
        return false;
    L8:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f.a.b(this.g, null, r5, new View(this.d), 9);
        return true;
    }

    public c(FragmentActivity r2, PdpDynamicFeatureService r3, com.bytedance.android.shopping.prepurchase.arch.container.component.j r4, o r5) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r5, "sliceAbility");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
    }
}
