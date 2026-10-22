package com.bytedance.android.shopping.inflow.cardui.product.header.vh;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/vh/BannerImageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerImageVH extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int d = 0;
    public final SimpleDraweeView a;
    public final SimpleDraweeView b;
    public final r c;

    public static final class a {
    }

    static {
    }

    public BannerImageVH(View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.c = null;
        this.a = r3.findViewById(2131385270);
        this.b = r3.findViewById(2131385265);
        AccessibilityDelegateCompatImpl r0 = new AccessibilityDelegateCompatImpl(r3);
        r0.b = "商品大图";
        ViewCompat.setAccessibilityDelegate(r3, r0);
    }
}
