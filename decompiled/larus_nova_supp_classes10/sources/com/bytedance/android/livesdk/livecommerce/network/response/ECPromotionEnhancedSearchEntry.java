package com.bytedance.android.livesdk.livecommerce.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEnhancedSearchEntry;", "Ljava/io/Serializable;", "()V", "hint", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSearchHint;", "getHint", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSearchHint;", "schema", "", "getSchema", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionEnhancedSearchEntry implements Serializable {

    @SerializedName("hint")
    private final ECPromotionSearchHint hint;

    @SerializedName("schema")
    private final String schema;

    public ECPromotionEnhancedSearchEntry() {
    }

    public final ECPromotionSearchHint getHint() {
        return this.hint;
    }

    public final String getSchema() {
        return this.schema;
    }
}
