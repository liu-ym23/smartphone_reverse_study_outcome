package com.bytedance.android.shopping.feed.repository.dto;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/ProductDetailRequestParam;", "Ljava/io/Serializable;", "promotionId", "", "enterFrom", "metaParam", "imageConstraintsMap", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getEnterFrom", "()Ljava/lang/String;", "getImageConstraintsMap", "()Ljava/util/Map;", "getMetaParam", "getPromotionId", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductDetailRequestParam implements Serializable {
    private final String enterFrom;
    private final Map<String, String> imageConstraintsMap;
    private final String metaParam;
    private final String promotionId;

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final Map<String, String> getImageConstraintsMap() {
        return this.imageConstraintsMap;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public ProductDetailRequestParam(String r2, String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        this.promotionId = r2;
        this.enterFrom = r3;
        this.metaParam = r4;
        this.imageConstraintsMap = r5;
    }

    public /* synthetic */ ProductDetailRequestParam(String r2, String r3, String r4, Map r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
