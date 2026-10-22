package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/v;", "", "", "hasExtensionCard", "Z", "b", "()Z", "", "extensionCardParam", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("extension_card_param")
    private final String extensionCardParam;

    @SerializedName("get_Extension_card")
    private final boolean hasExtensionCard;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v) == false) goto L10;
        v r4 = (v) r3;
        if (this.hasExtensionCard == r4.hasExtensionCard) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extensionCardParam, r4.extensionCardParam) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.hasExtensionCard;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.extensionCardParam;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "WindowExtensionCardControlDTO(hasExtensionCard=" + this.hasExtensionCard + ", extensionCardParam=" + this.extensionCardParam + ")";
    }

    public v() {
        this.hasExtensionCard = false;
        this.extensionCardParam = null;
    }

    public final String a() {
        return this.extensionCardParam;
    }

    public final boolean b() {
        return this.hasExtensionCard;
    }
}
