package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/o0;", "", "Lcom/bytedance/android/window/shop/repository/dto/g;", "replayStruct", "Lcom/bytedance/android/window/shop/repository/dto/g;", "a", "()Lcom/bytedance/android/window/shop/repository/dto/g;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SubDTO
    public final transient WindowV2ProductItemDTO a;

    @SerializedName("replay_struct")
    private final g replayStruct;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o0) == false) goto L10;
        o0 r4 = (o0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.replayStruct, r4.replayStruct) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        WindowV2ProductItemDTO r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        g r4 = this.replayStruct;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowHotLiveSamePriceProductDTO(productDTO=" + this.a + ", replayStruct=" + this.replayStruct + ")";
    }

    public o0() {
        this.a = null;
        this.replayStruct = null;
    }

    public final g a() {
        return this.replayStruct;
    }
}
