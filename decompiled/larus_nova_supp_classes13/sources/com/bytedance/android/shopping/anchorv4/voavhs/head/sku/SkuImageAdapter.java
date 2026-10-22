package com.bytedance.android.shopping.anchorv4.voavhs.head.sku;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.d;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.i;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.c;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/sku/SkuImageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuImageAdapter extends PagerAdapter {
    public final List<ECUrlModel> a;
    public final i b;
    public final d c;
    public final ScrollMoreText d;
    public final boolean e;
    public final Function1<c, Unit> f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SkuImageAdapter a;
        public final /* synthetic */ int b;

        public a(SkuImageAdapter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            i r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.b(this.b);
            return;
        }
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object instantiateItem(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "container");
        RecyclerView r0 = View.inflate(r7.getContext(), 2131560508, null);
        SimpleDraweeView r1 = r0.findViewById(2131386847);
        ECUrlModel r2 = (ECUrlModel) CollectionsKt.getOrNull(this.a, r8);
        if (r2 == null) goto L5;
        ImageExtensionsKt.D(r1, new r("ec_detail", "ec_product_header_image"));
    L5:
        y.a(r1, r2);
        r0.setOnClickListener(new a(this, r8));
        if (this.d != null) goto L8;
    L10:
        r7.addView(r0);
        return r0;
    L8:
        if (r8 != (this.a.size() - 1)) goto L10;
        c r9 = new c(r0, this.c);
        this.f.invoke(r9);
        r0 = r9.a(this.d, this.e);
        goto L10
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "object");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "object");
        r1.removeView((View) r3);
    }

    public SkuImageAdapter(List r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.c r3, d r4, ScrollMoreText r5, boolean r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r2, "imageList");
        Intrinsics.checkNotNullParameter(r7, "loadMoreUtilSetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
