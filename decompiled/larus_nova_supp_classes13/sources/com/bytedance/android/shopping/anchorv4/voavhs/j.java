package com.bytedance.android.shopping.anchorv4.voavhs;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements com.bytedance.android.ecom.arch.slice.e {
    public final HashMap<String, SlcElement> a;

    public j() {
        this.a = new HashMap();
    }

    public final void b(Map<String, SlcElement> r2) {
        Intrinsics.checkNotNullParameter(r2, "templateMap");
        com.bytedance.android.ecom.arch.slice.e.a.a(this, r2);
    }

    public final SlcElement getTemplate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.get(r2);
    }

    public final void a(String r2, SlcElement r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "element");
        this.a.put(r2, r3);
    }
}
