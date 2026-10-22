package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/v0;", "", "", "lynxConfig", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setLynxConfig", "(Ljava/lang/String;)V", "lynxData", "b", "setLynxData", "Lcom/bytedance/android/window/shop/repository/dto/w0;", "lynxSsr", "Lcom/bytedance/android/window/shop/repository/dto/w0;", "d", "()Lcom/bytedance/android/window/shop/repository/dto/w0;", "setLynxSsr", "(Lcom/bytedance/android/window/shop/repository/dto/w0;)V", "", "lynxItemType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setLynxItemType", "(Ljava/lang/Integer;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("lynx_config")
    private String lynxConfig;

    @SerializedName("lynx_data")
    private String lynxData;

    @SerializedName("lynx_item_type")
    private Integer lynxItemType;

    @SerializedName("lynx_ssr")
    private w0 lynxSsr;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v0) == false) goto L14;
        v0 r4 = (v0) r3;
        if (Intrinsics.areEqual(this.lynxConfig, r4.lynxConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxData, r4.lynxData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxSsr, r4.lynxSsr) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxItemType, r4.lynxItemType) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.lynxConfig;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.lynxData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        w0 r7 = this.lynxSsr;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.lynxItemType;
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
        return "WindowLynxItemDTO(lynxConfig=" + this.lynxConfig + ", lynxData=" + this.lynxData + ", lynxSsr=" + this.lynxSsr + ", lynxItemType=" + this.lynxItemType + ")";
    }

    public final boolean e() {
        String r0 = this.lynxConfig;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(r0)) != true) goto L7;
        return true;
    }

    public v0() {
        this.lynxConfig = null;
        this.lynxData = null;
        this.lynxSsr = null;
        this.lynxItemType = null;
    }

    public final String a() {
        return this.lynxConfig;
    }

    public final String b() {
        return this.lynxData;
    }

    public final Integer c() {
        return this.lynxItemType;
    }

    public final w0 d() {
        return this.lynxSsr;
    }
}
