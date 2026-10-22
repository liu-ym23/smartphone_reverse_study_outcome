package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.store.status.ECStatusStructView;
import com.bytedance.android.ec.store.status.StructType;
import com.bytedance.android.ec.store.status.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/status/ECStoreProductDoubleLoadingView;", "Lcom/bytedance/android/ec/store/status/ECStatusStructView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreProductDoubleLoadingView extends ECStatusStructView {
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public final e[][] a() {
        StructType r5 = StructType.PRODUCT_DOUBLE_LOADING;
        return new e[][]{new e[]{new e(r5, new com.bytedance.android.ec.store.status.a(this.b, 0, this.c, this.f), 2), new e(r5, new com.bytedance.android.ec.store.status.a(this.b, 0, this.c, this.f), 2), new e(r5, new com.bytedance.android.ec.store.status.a(this.b, 0, this.c, this.f), 2)}, new e[]{new e(r5, new com.bytedance.android.ec.store.status.a(this.d, 0, this.e, this.f), 2), new e(r5, new com.bytedance.android.ec.store.status.a(this.d, 0, this.e, this.f), 2), new e(r5, new com.bytedance.android.ec.store.status.a(this.d, 0, this.e, this.f), 2)}};
    }

    public ECStoreProductDoubleLoadingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.b = com.bytedance.android.shopping.extensions.b.b(12);
        Double r5 = Double.valueOf(4.5d);
        this.c = com.bytedance.android.shopping.extensions.b.b(r5);
        this.d = com.bytedance.android.shopping.extensions.b.b(r5);
        this.e = com.bytedance.android.shopping.extensions.b.b(12);
        this.f = com.bytedance.android.shopping.extensions.b.b(9);
    }
}
