package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CenterLayoutManager extends LinearLayoutManager {
    public final Context getContext() {
        return null;
    }

    public final void scrollToPosition(int r2) {
        super.scrollToPositionWithOffset(r2, 300);
    }
}
