package com.bytedance.android.shopping.jedi;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/jedi/EqualsItemCallback;", "T", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EqualsItemCallback<T> extends DiffUtil.ItemCallback<T> {
    public EqualsItemCallback() {
    }

    public final boolean areContentsTheSame(T r1, T r2) {
        return Intrinsics.areEqual(r1, r2);
    }

    public final boolean areItemsTheSame(T r1, T r2) {
        return Intrinsics.areEqual(r1, r2);
    }
}
