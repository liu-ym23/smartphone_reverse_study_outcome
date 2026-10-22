package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.c;
import com.bytedance.android.shopping.prepurchase.arch.container.state.f;
import com.bytedance.android.shopping.prepurchase.business.pdp.e;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.anchorv4.log.b {
    public final c<e, PdpDataStore> a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e b;

    public final CommonMeta a() {
        return this.a.d().getData().a().a();
    }

    public final LifecycleOwner getLifecycleOwner() {
        return f.a(this.b);
    }

    public final String getSessionId() {
        return this.a.f().a.b;
    }

    public a(c<e, PdpDataStore> r2, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.a = r2;
        this.b = r3;
    }
}
