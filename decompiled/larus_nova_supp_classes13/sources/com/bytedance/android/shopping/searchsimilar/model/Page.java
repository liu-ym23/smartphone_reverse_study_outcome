package com.bytedance.android.shopping.searchsimilar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/model/Page;", "Ljava/io/Serializable;", "()V", "cursor", "", "getCursor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "more", "", "getMore", "()Z", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Page implements Serializable {

    @SerializedName("cursor")
    private final Integer cursor;

    @SerializedName("more")
    private final boolean more;

    public Page() {
    }

    public final Integer getCursor() {
        return this.cursor;
    }

    public final boolean getMore() {
        return this.more;
    }
}
