package com.bytedance.android.livesdk.livecommerce.view.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewAddCouponLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewBaseCouponLayout;", "Lcom/bytedance/android/livesdk/livecommerce/view/coupon/ECNewAddCouponLayout$a;", "handler", "", "setHandler", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewAddCouponLayout extends ECNewBaseCouponLayout {
    public Map<Integer, View> b;
    public final TextView c;
    public a d;

    public interface a {
    }

    public ECNewAddCouponLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECNewAddCouponLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewBaseCouponLayout
    public final View a(int r3) {
        if (this.b != null) goto L5;
        this.b = new LinkedHashMap();
    L5:
        View r0 = this.b.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.b.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewBaseCouponLayout
    public final void b(final p r5) {
        Intrinsics.checkNotNullParameter(r5, "ecuiCoupon");
        super.b(r5);
        FrameLayout r0 = (FrameLayout) a(2131370706);
        r0.removeAllViews();
        r0.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        final TextView r1 = this.c;
        r1.setTextColor(r1.getContext().getResources().getColor(2131101703));
        r1.setText(r1.getContext().getString(2131896298));
        r1.setTextSize(1, 12.0f);
        r1.setBackgroundResource(2131234484);
        r1.setGravity(17);
        r1.setOnClickListener(new ECNewAddCouponLayout$updateInfo$$inlined$apply$lambda$1(r1, this, r5));
    }

    public final void setHandler(a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.d = r2;
    }

    public ECNewAddCouponLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new LinkedHashMap();
        this.c = new TextView(r2);
    }

    public /* synthetic */ ECNewAddCouponLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
