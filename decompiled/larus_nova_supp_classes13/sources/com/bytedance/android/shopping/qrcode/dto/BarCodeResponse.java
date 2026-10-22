package com.bytedance.android.shopping.qrcode.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/qrcode/dto/BarCodeResponse;", "Ljava/io/Serializable;", "barCode", "", "Lcom/bytedance/android/shopping/qrcode/dto/CodeStruct;", "detailUrl", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBarCode", "()Ljava/util/List;", "getDetailUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarCodeResponse implements Serializable {

    @SerializedName("bar_code")
    private final List<CodeStruct> barCode;

    @SerializedName("detail_url")
    private final String detailUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public BarCodeResponse() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BarCodeResponse copy$default(BarCodeResponse r0, List r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.barCode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.detailUrl;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<CodeStruct> component1() {
        return this.barCode;
    }

    public final String component2() {
        return this.detailUrl;
    }

    public final BarCodeResponse copy(List<CodeStruct> r2, String r3) {
        return new BarCodeResponse(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BarCodeResponse) == false) goto L10;
        BarCodeResponse r4 = (BarCodeResponse) r3;
        if (Intrinsics.areEqual(this.barCode, r4.barCode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.detailUrl, r4.detailUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<CodeStruct> r0 = this.barCode;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.detailUrl;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "BarCodeResponse(barCode=" + this.barCode + ", detailUrl=" + this.detailUrl + ")";
    }

    public final List<CodeStruct> getBarCode() {
        return this.barCode;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public BarCodeResponse(List<CodeStruct> r1, String r2) {
        this.barCode = r1;
        this.detailUrl = r2;
    }

    public /* synthetic */ BarCodeResponse(List r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
