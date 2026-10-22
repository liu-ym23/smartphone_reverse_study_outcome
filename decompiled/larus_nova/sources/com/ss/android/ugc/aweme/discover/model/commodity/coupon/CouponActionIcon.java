package com.ss.android.ugc.aweme.discover.model.commodity.coupon;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponActionIcon;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "icons", "", "", "getIcons", "()Ljava/util/List;", "width", "getWidth", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponActionIcon implements Serializable {

    @SerializedName("height")
    private final Integer height;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> icons;

    @SerializedName("width")
    private final Integer width;

    public CouponActionIcon() {
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final List<String> getIcons() {
        return this.icons;
    }

    public final Integer getWidth() {
        return this.width;
    }
}
