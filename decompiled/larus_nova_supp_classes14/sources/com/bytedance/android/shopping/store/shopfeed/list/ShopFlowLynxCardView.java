package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFlowLynxCardView;", "Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedLynxCardView;", "", "g", "D", "getShowPercent", "()D", "setShowPercent", "(D)V", "showPercent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFlowLynxCardView extends AbsShopFeedLynxCardView {
    public double g;

    public static final class a {
    }

    static {
    }

    public final double getShowPercent() {
        return this.g;
    }

    public final void setShowPercent(double r1) {
        this.g = r1;
    }

    public ShopFlowLynxCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        int r5 = (k1.j(r2) * 9) / 10;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560854, this, true);
        setLoadingImageView((ImageView) findViewById(2131386233));
        setLynxContainer((FrameLayout) findViewById(2131386234));
        ImageView r6 = getLoadingImageView();
        if (r6 == null) goto L6;
        r6.setLayoutParams(new FrameLayout.LayoutParams(-1, r5));
        return;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedLynxCardView
    public final Map b(ShopFeedItemCard r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "card");
        Intrinsics.checkNotNullParameter(r3, "passThroughParams");
        if (k1.k() >= 790) goto L5;
        int r5 = 3;
    L6:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("product_num", String.valueOf(r5));
        r6.put("is_top", Integer.valueOf(r4 ? 1 : 0));
        return r6;
    L5:
        r5 = 4;
        goto L6
    }
}
