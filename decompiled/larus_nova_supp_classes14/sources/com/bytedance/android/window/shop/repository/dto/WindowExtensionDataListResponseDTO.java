package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J'\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowExtensionDataListResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/window/shop/repository/dto/c;", "component1", "Lcom/bytedance/android/window/shop/repository/dto/w;", "component2", "mixFullCards", "controlInfo", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getMixFullCards", "()Ljava/util/List;", "Lcom/bytedance/android/window/shop/repository/dto/w;", "getControlInfo", "()Lcom/bytedance/android/window/shop/repository/dto/w;", "<init>", "(Ljava/util/List;Lcom/bytedance/android/window/shop/repository/dto/w;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowExtensionDataListResponseDTO extends CommerceBaseResponse {

    @SerializedName("control_info")
    private final w controlInfo;

    @SerializedName("mix_full_cards")
    private final List<c> mixFullCards;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowExtensionDataListResponseDTO() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowExtensionDataListResponseDTO copy$default(WindowExtensionDataListResponseDTO r0, List r1, w r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.mixFullCards;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.controlInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<c> component1() {
        return this.mixFullCards;
    }

    public final w component2() {
        return this.controlInfo;
    }

    public final WindowExtensionDataListResponseDTO copy(List<c> r2, w r3) {
        return new WindowExtensionDataListResponseDTO(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WindowExtensionDataListResponseDTO) == false) goto L10;
        WindowExtensionDataListResponseDTO r4 = (WindowExtensionDataListResponseDTO) r3;
        if (Intrinsics.areEqual(this.mixFullCards, r4.mixFullCards) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.controlInfo, r4.controlInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<c> r0 = this.mixFullCards;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        w r4 = this.controlInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "WindowExtensionDataListResponseDTO(mixFullCards=" + this.mixFullCards + ", controlInfo=" + this.controlInfo + ")";
    }

    public final w getControlInfo() {
        return this.controlInfo;
    }

    public final List<c> getMixFullCards() {
        return this.mixFullCards;
    }

    public WindowExtensionDataListResponseDTO(List<c> r1, w r2) {
        this.mixFullCards = r1;
        this.controlInfo = r2;
    }

    public /* synthetic */ WindowExtensionDataListResponseDTO(List r2, w r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
