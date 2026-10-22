package com.ss.android.ugc.aweme.search.vision.result.panel.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchGoodsNotBuyViewConfig;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchGoodsNotBuyViewConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f453757b;

    public PhotoSearchGoodsNotBuyViewConfig() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PhotoSearchGoodsNotBuyViewConfig) == false) goto L10;
        PhotoSearchGoodsNotBuyViewConfig r101 = (PhotoSearchGoodsNotBuyViewConfig) r100;
        if (Intrinsics.areEqual(this.f453756a, r101.f453756a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f453757b, r101.f453757b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f453756a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f453757b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PhotoSearchGoodsNotBuyViewConfig(schema=" + this.f453756a + ", extra=" + this.f453757b + ")";
    }

    public PhotoSearchGoodsNotBuyViewConfig(int r100) {
        Intrinsics.checkNotNullParameter("sslocal://lynxview/?bundle=photo_search_top_goods_card%2Ftemplate.js&channel=fe_lynx_ecom_normal_search&dynamic=1&surl=https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fecom%2Fsearch%2Flynx%2Ffe_lynx_ecom_normal_search%2Fphoto_search_top_goods_card%2Ftemplate.js", "schema");
        this.f453756a = "sslocal://lynxview/?bundle=photo_search_top_goods_card%2Ftemplate.js&channel=fe_lynx_ecom_normal_search&dynamic=1&surl=https%3A%2F%2Flf-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fecom%2Fsearch%2Flynx%2Ffe_lynx_ecom_normal_search%2Fphoto_search_top_goods_card%2Ftemplate.js";
        this.f453757b = null;
    }
}
