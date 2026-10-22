package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.window.base.repository.vo.ECWindowTagListDTO;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/y0;", "", "", "", "Lcom/bytedance/android/ec/window/base/repository/vo/ECWindowTagListDTO;", "tagListMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("tag_info")
    private final Map<String, ECWindowTagListDTO> tagListMap;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof y0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.tagListMap, ((y0) r2).tagListMap) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, ECWindowTagListDTO> r0 = this.tagListMap;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "WindowProductRefreshInfo(tagListMap=" + this.tagListMap + ")";
    }

    public final Map<String, ECWindowTagListDTO> a() {
        return this.tagListMap;
    }
}
