package com.bytedance.android.shopping.anchorv4.voavhs;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/AnchorV4Differ;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4Differ extends DiffUtil.ItemCallback<com.bytedance.android.ecom.arch.slice.adapter.b> {
    public AnchorV4Differ() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        com.bytedance.android.ecom.arch.slice.adapter.b r4 = (com.bytedance.android.ecom.arch.slice.adapter.b) r2;
        com.bytedance.android.ecom.arch.slice.adapter.b r5 = (com.bytedance.android.ecom.arch.slice.adapter.b) r3;
        Intrinsics.checkNotNullParameter(r4, "pre");
        Intrinsics.checkNotNullParameter(r5, "post");
        return r4.areContentsTheSame(r5);
    }

    public final boolean areItemsTheSame(Object r2, Object r3) {
        com.bytedance.android.ecom.arch.slice.adapter.b r4 = (com.bytedance.android.ecom.arch.slice.adapter.b) r2;
        com.bytedance.android.ecom.arch.slice.adapter.b r5 = (com.bytedance.android.ecom.arch.slice.adapter.b) r3;
        Intrinsics.checkNotNullParameter(r4, "pre");
        Intrinsics.checkNotNullParameter(r5, "post");
        return r4.areItemsTheSame(r5);
    }
}
