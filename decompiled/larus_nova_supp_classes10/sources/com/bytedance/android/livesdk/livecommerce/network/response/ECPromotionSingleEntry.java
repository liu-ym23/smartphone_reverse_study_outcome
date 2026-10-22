package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.live.b;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSingleEntry;", "Ljava/io/Serializable;", "", "singleEntryType", "I", "getSingleEntryType", "()I", "Lcom/bytedance/android/ec/model/live/b;", "elementBlock", "Lcom/bytedance/android/ec/model/live/b;", "getElementBlock", "()Lcom/bytedance/android/ec/model/live/b;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionSingleEntry implements Serializable {

    @SerializedName("element_block")
    private final b elementBlock;

    @SerializedName("single_entry_type")
    private final int singleEntryType;

    public ECPromotionSingleEntry() {
    }

    public final b getElementBlock() {
        return this.elementBlock;
    }

    public final int getSingleEntryType() {
        return this.singleEntryType;
    }
}
