package com.bytedance.android.shopping.sku.inner.controller;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final a a;
    public final com.bytedance.android.shopping.sku.inner.container.b b;

    public final class a implements j {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.b.close(2);
        }
    }

    public b(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.b = r2;
        this.a = new a(this);
    }
}
