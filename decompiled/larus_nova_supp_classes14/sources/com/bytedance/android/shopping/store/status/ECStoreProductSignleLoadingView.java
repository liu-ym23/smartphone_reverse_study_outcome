package com.bytedance.android.shopping.store.status;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.store.status.ECStatusStructView;
import com.bytedance.android.ec.store.status.StructType;
import com.bytedance.android.ec.store.status.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/status/ECStoreProductSignleLoadingView;", "Lcom/bytedance/android/ec/store/status/ECStatusStructView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreProductSignleLoadingView extends ECStatusStructView {
    public final int b;
    public final int c;

    public final e[][] a() {
        StructType r4 = StructType.PRODUCT_SIGNLE_LOADING;
        int r6 = this.b;
        int r7 = this.b;
        int r5 = this.b;
        int r8 = this.b;
        return new e[][]{new e[]{new e(r4, new com.bytedance.android.ec.store.status.a(r6, 0, r6, this.c), 2), new e(r4, new com.bytedance.android.ec.store.status.a(r7, 0, r7, this.c), 2), new e(r4, new com.bytedance.android.ec.store.status.a(r5, 0, r5, this.c), 2), new e(r4, new com.bytedance.android.ec.store.status.a(r8, 0, r8, this.c), 2)}};
    }

    public ECStoreProductSignleLoadingView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = com.bytedance.android.shopping.extensions.b.b(12);
        this.c = com.bytedance.android.shopping.extensions.b.b(12);
    }
}
