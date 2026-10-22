package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/z;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "iconUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "clickSchema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("click_scheme")
    private final String clickSchema;

    @SerializedName("icon_url")
    private final ECUrlModel iconUrl;

    public final ECUrlModel a() {
        return this.iconUrl;
    }

    public final String b() {
        return this.clickSchema;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z) == false) goto L10;
        z r4 = (z) r3;
        if (Intrinsics.areEqual(this.iconUrl, r4.iconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clickSchema, r4.clickSchema) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.iconUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.clickSchema;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowGoodAuthorImgDTO(iconUrl=" + this.iconUrl + ", clickSchema=" + this.clickSchema + ")";
    }

    public z() {
        this.iconUrl = null;
        this.clickSchema = null;
    }

    public final String c() {
        return this.clickSchema;
    }

    public final ECUrlModel d() {
        return this.iconUrl;
    }
}
