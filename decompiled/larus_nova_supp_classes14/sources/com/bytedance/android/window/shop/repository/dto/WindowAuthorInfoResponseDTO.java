package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowAuthorInfoResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lcom/bytedance/android/window/shop/repository/dto/l;", "component1", "Lcom/bytedance/android/window/shop/repository/dto/o;", "component2", "windowAuthorInfo", "windowCartEntryInfo", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/window/shop/repository/dto/l;", "getWindowAuthorInfo", "()Lcom/bytedance/android/window/shop/repository/dto/l;", "Lcom/bytedance/android/window/shop/repository/dto/o;", "getWindowCartEntryInfo", "()Lcom/bytedance/android/window/shop/repository/dto/o;", "<init>", "(Lcom/bytedance/android/window/shop/repository/dto/l;Lcom/bytedance/android/window/shop/repository/dto/o;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAuthorInfoResponseDTO extends CommerceBaseResponse {

    @SerializedName("window_author_info")
    private final l windowAuthorInfo;

    @SerializedName("cart_entry_info")
    private final o windowCartEntryInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowAuthorInfoResponseDTO() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowAuthorInfoResponseDTO copy$default(WindowAuthorInfoResponseDTO r0, l r1, o r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.windowAuthorInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.windowCartEntryInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final l component1() {
        return this.windowAuthorInfo;
    }

    public final o component2() {
        return this.windowCartEntryInfo;
    }

    public final WindowAuthorInfoResponseDTO copy(l r2, o r3) {
        return new WindowAuthorInfoResponseDTO(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WindowAuthorInfoResponseDTO) == false) goto L10;
        WindowAuthorInfoResponseDTO r4 = (WindowAuthorInfoResponseDTO) r3;
        if (Intrinsics.areEqual(this.windowAuthorInfo, r4.windowAuthorInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowCartEntryInfo, r4.windowCartEntryInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        l r0 = this.windowAuthorInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        o r4 = this.windowCartEntryInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "WindowAuthorInfoResponseDTO(windowAuthorInfo=" + this.windowAuthorInfo + ", windowCartEntryInfo=" + this.windowCartEntryInfo + ")";
    }

    public final l getWindowAuthorInfo() {
        return this.windowAuthorInfo;
    }

    public final o getWindowCartEntryInfo() {
        return this.windowCartEntryInfo;
    }

    public WindowAuthorInfoResponseDTO(l r1, o r2) {
        this.windowAuthorInfo = r1;
        this.windowCartEntryInfo = r2;
    }

    public /* synthetic */ WindowAuthorInfoResponseDTO(l r2, o r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
