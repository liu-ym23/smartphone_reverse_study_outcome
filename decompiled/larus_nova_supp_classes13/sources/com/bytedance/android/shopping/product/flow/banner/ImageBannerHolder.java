package com.bytedance.android.shopping.product.flow.banner;

import android.view.View;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/ImageBannerHolder;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageBannerHolder extends BannerHolder {
    public final ECDraweeView a;
    public final View b;
    public final RemoteRoundImageView c;

    public ImageBannerHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131374931);
        this.b = r2.findViewById(2131372752);
        this.c = r2.findViewById(2131363322);
    }
}
