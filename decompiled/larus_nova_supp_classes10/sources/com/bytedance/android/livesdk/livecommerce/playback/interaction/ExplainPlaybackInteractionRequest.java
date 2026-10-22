package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/ExplainPlaybackInteractionRequest;", "Ljava/io/Serializable;", "", "promotionId", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "productId", "getProductId", "roomId", "getRoomId", "authorId", "getAuthorId", "shopId", "getShopId", "sourcePage", "getSourcePage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackInteractionRequest implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final String authorId;
    private final String productId;
    private final String promotionId;
    private final String roomId;
    private final String shopId;
    private final String sourcePage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public ExplainPlaybackInteractionRequest(String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        Intrinsics.checkNotNullParameter(r3, "productId");
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "authorId");
        Intrinsics.checkNotNullParameter(r6, "shopId");
        Intrinsics.checkNotNullParameter(r7, "sourcePage");
        this.promotionId = r2;
        this.productId = r3;
        this.roomId = r4;
        this.authorId = r5;
        this.shopId = r6;
        this.sourcePage = r7;
    }
}
