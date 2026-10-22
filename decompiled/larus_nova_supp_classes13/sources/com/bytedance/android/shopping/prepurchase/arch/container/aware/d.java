package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements c {
    public final xi.b a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.f<?, ?> b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        this.a.d("PageShowLog", "onPageCreateFinish " + this.b.a.b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        this.a.d("PageShowLog", "onPageCreateStart " + this.b.a.b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
        this.a.d("PageShowLog", "onFirstScreen " + this.b.a.b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
        this.a.d("PageShowLog", "onRenderStart " + this.b.a.b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        this.a.d("PageShowLog", "onQueryStart " + this.b.a.b);
    }

    public d(com.bytedance.android.shopping.prepurchase.arch.container.f<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "pageParam");
        this.b = r2;
        this.a = r2.b;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(k.a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        this.a.d("PageShowLog", "onQueryFailed " + r4 + ' ' + this.b.a.b);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(k.d r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        this.a.d("PageShowLog", "onQuerySuccess " + r4 + ' ' + this.b.a.b);
    }
}
