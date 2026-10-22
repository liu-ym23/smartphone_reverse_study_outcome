package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.window.base.SyncType;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/z0;", "", "", "title", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "products", "Ljava/util/List;", "a", "()Ljava/util/List;", "Lcom/bytedance/android/ec/window/base/SyncType;", "syncType", "Lcom/bytedance/android/ec/window/base/SyncType;", "b", "()Lcom/bytedance/android/ec/window/base/SyncType;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("products")
    private final List<WindowV2ProductItemDTO> products;

    @SerializedName("type")
    private final SyncType syncType;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z0) == false) goto L12;
        z0 r4 = (z0) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.products, r4.products) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.syncType, r4.syncType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<WindowV2ProductItemDTO> r4 = this.products;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        SyncType r7 = this.syncType;
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
        return "WindowProductSyncDTO(title=" + this.title + ", products=" + this.products + ", syncType=" + this.syncType + ")";
    }

    public z0() {
        this.title = null;
        this.products = null;
        this.syncType = null;
    }

    public final List<WindowV2ProductItemDTO> a() {
        return this.products;
    }

    public final SyncType b() {
        return this.syncType;
    }

    public final String c() {
        return this.title;
    }
}
