package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowHeaderResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/repository/dto/d0;", "component1", "Lcom/bytedance/android/window/shop/repository/dto/g0;", "component2", "Lcom/bytedance/android/window/shop/repository/dto/c;", "component3", "Lcom/bytedance/android/window/shop/repository/dto/e0;", "component4", "shopHeaderBaseInfo", "shopHeaderControl", "productListInfo", "windowHeaderBffDataData", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/window/shop/repository/dto/d0;", "getShopHeaderBaseInfo", "()Lcom/bytedance/android/window/shop/repository/dto/d0;", "Lcom/bytedance/android/window/shop/repository/dto/g0;", "getShopHeaderControl", "()Lcom/bytedance/android/window/shop/repository/dto/g0;", "Lcom/bytedance/android/window/shop/repository/dto/c;", "getProductListInfo", "()Lcom/bytedance/android/window/shop/repository/dto/c;", "Lcom/bytedance/android/window/shop/repository/dto/e0;", "getWindowHeaderBffDataData", "()Lcom/bytedance/android/window/shop/repository/dto/e0;", "<init>", "(Lcom/bytedance/android/window/shop/repository/dto/d0;Lcom/bytedance/android/window/shop/repository/dto/g0;Lcom/bytedance/android/window/shop/repository/dto/c;Lcom/bytedance/android/window/shop/repository/dto/e0;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderResponseDTO extends CommerceBaseResponse {

    @SerializedName("inventories")
    private final c productListInfo;

    @SerializedName("window_header_basic_info")
    private final d0 shopHeaderBaseInfo;

    @SerializedName("window_header_control_info")
    private final g0 shopHeaderControl;

    @SerializedName("window_header_bff")
    private final e0 windowHeaderBffDataData;

    public WindowHeaderResponseDTO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ WindowHeaderResponseDTO copy$default(WindowHeaderResponseDTO r0, d0 r1, g0 r2, c r3, e0 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.shopHeaderBaseInfo;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.shopHeaderControl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.productListInfo;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.windowHeaderBffDataData;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final d0 component1() {
        return this.shopHeaderBaseInfo;
    }

    public final g0 component2() {
        return this.shopHeaderControl;
    }

    public final c component3() {
        return this.productListInfo;
    }

    public final e0 component4() {
        return this.windowHeaderBffDataData;
    }

    public final WindowHeaderResponseDTO copy(d0 r2, g0 r3, c r4, e0 r5) {
        return new WindowHeaderResponseDTO(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WindowHeaderResponseDTO) == false) goto L14;
        WindowHeaderResponseDTO r4 = (WindowHeaderResponseDTO) r3;
        if (Intrinsics.areEqual(this.shopHeaderBaseInfo, r4.shopHeaderBaseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopHeaderControl, r4.shopHeaderControl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productListInfo, r4.productListInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowHeaderBffDataData, r4.windowHeaderBffDataData) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        d0 r0 = this.shopHeaderBaseInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        g0 r4 = this.shopHeaderControl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        c r7 = this.productListInfo;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        e0 r10 = this.windowHeaderBffDataData;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "WindowHeaderResponseDTO(shopHeaderBaseInfo=" + this.shopHeaderBaseInfo + ", shopHeaderControl=" + this.shopHeaderControl + ", productListInfo=" + this.productListInfo + ", windowHeaderBffDataData=" + this.windowHeaderBffDataData + ")";
    }

    public final c getProductListInfo() {
        return this.productListInfo;
    }

    public final d0 getShopHeaderBaseInfo() {
        return this.shopHeaderBaseInfo;
    }

    public final g0 getShopHeaderControl() {
        return this.shopHeaderControl;
    }

    public final e0 getWindowHeaderBffDataData() {
        return this.windowHeaderBffDataData;
    }

    public WindowHeaderResponseDTO(d0 r1, g0 r2, c r3, e0 r4) {
        this.shopHeaderBaseInfo = r1;
        this.shopHeaderControl = r2;
        this.productListInfo = r3;
        this.windowHeaderBffDataData = r4;
    }

    public /* synthetic */ WindowHeaderResponseDTO(d0 r2, g0 r3, c r4, e0 r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
