package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/h0;", "", "", "Lcom/bytedance/android/window/shop/repository/dto/r0;", "impressionWords", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "windowDetailUrl", "Ljava/lang/String;", "getWindowDetailUrl", "()Ljava/lang/String;", "Lcom/bytedance/android/window/shop/repository/dto/x;", "fansInfo", "Lcom/bytedance/android/window/shop/repository/dto/x;", "a", "()Lcom/bytedance/android/window/shop/repository/dto/x;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("fans_info")
    private final x fansInfo;

    @SerializedName("impression_words")
    private final List<r0> impressionWords;

    @SerializedName("detail_url")
    private final String windowDetailUrl;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h0) == false) goto L12;
        h0 r4 = (h0) r3;
        if (Intrinsics.areEqual(this.impressionWords, r4.impressionWords) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowDetailUrl, r4.windowDetailUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fansInfo, r4.fansInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<r0> r0 = this.impressionWords;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.windowDetailUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        x r7 = this.fansInfo;
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
        return "WindowHeaderEveryoneTalkDTO(impressionWords=" + this.impressionWords + ", windowDetailUrl=" + this.windowDetailUrl + ", fansInfo=" + this.fansInfo + ")";
    }

    public h0() {
        this.impressionWords = null;
        this.windowDetailUrl = null;
        this.fansInfo = null;
    }

    public final x a() {
        return this.fansInfo;
    }

    public final List<r0> b() {
        return this.impressionWords;
    }
}
