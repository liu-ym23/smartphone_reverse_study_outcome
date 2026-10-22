package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/s0;", "", "", "level", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "categoryName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "levelImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getLevelImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("category_name")
    private final String categoryName;

    @SerializedName("level")
    private final Integer level;

    @SerializedName("level_image")
    private final ECUrlModel levelImage;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s0) == false) goto L12;
        s0 r4 = (s0) r3;
        if (Intrinsics.areEqual(this.level, r4.level) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.categoryName, r4.categoryName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.levelImage, r4.levelImage) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.level;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.categoryName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.levelImage;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowLevelInfoDTO(level=" + this.level + ", categoryName=" + this.categoryName + ", levelImage=" + this.levelImage + ")";
    }

    public s0() {
        this.level = null;
        this.categoryName = null;
        this.levelImage = null;
    }

    public final String a() {
        return this.categoryName;
    }

    public final Integer b() {
        return this.level;
    }
}
