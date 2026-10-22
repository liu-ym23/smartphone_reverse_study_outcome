package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.hybrid.list.entity.dto.SSRDataDecodingFormat;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/w0;", "", "", "ssrData", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "hydrateData", "a", "hydrateUrl", "b", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ssrDataDecodingFormat", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "d", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("hydrate_data")
    private final String hydrateData;

    @SerializedName("hydrate_url")
    private final String hydrateUrl;

    @SerializedName("ssr_data")
    private final String ssrData;

    @SerializedName("ssr_data_decoding_format")
    private final SSRDataDecodingFormat ssrDataDecodingFormat;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof w0) == false) goto L14;
        w0 r4 = (w0) r3;
        if (Intrinsics.areEqual(this.ssrData, r4.ssrData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hydrateData, r4.hydrateData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hydrateUrl, r4.hydrateUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ssrDataDecodingFormat, r4.ssrDataDecodingFormat) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.ssrData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.hydrateData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.hydrateUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        SSRDataDecodingFormat r10 = this.ssrDataDecodingFormat;
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

    public final String toString() {
        return "WindowLynxSsrDTO(ssrData=" + this.ssrData + ", hydrateData=" + this.hydrateData + ", hydrateUrl=" + this.hydrateUrl + ", ssrDataDecodingFormat=" + this.ssrDataDecodingFormat + ")";
    }

    public w0() {
        this.ssrData = null;
        this.hydrateData = null;
        this.hydrateUrl = null;
        this.ssrDataDecodingFormat = null;
    }

    public final String a() {
        return this.hydrateData;
    }

    public final String b() {
        return this.hydrateUrl;
    }

    public final String c() {
        return this.ssrData;
    }

    public final SSRDataDecodingFormat d() {
        return this.ssrDataDecodingFormat;
    }
}
