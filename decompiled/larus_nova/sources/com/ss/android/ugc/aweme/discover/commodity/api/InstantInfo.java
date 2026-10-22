package com.ss.android.ugc.aweme.discover.commodity.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;", "Ljava/io/Serializable;", "instantAddress", "", "addressSource", "cartSchema", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressSource", "()Ljava/lang/String;", "getCartSchema", "getInstantAddress", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InstantInfo implements Serializable {

    @SerializedName("address_source")
    private final String addressSource;

    @SerializedName("cart_schema")
    private final String cartSchema;

    @SerializedName("instant_address")
    private final String instantAddress;

    public InstantInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InstantInfo copy$default(InstantInfo r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.instantAddress;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.addressSource;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.cartSchema;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.instantAddress;
    }

    public final String component2() {
        return this.addressSource;
    }

    public final String component3() {
        return this.cartSchema;
    }

    public final InstantInfo copy(String r100, String r101, String r102) {
        return new InstantInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InstantInfo) == false) goto L12;
        InstantInfo r101 = (InstantInfo) r100;
        if (Intrinsics.areEqual(this.instantAddress, r101.instantAddress) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.addressSource, r101.addressSource) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cartSchema, r101.cartSchema) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.instantAddress;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.addressSource;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cartSchema;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InstantInfo(instantAddress=" + this.instantAddress + ", addressSource=" + this.addressSource + ", cartSchema=" + this.cartSchema + ")";
    }

    public final String getAddressSource() {
        return this.addressSource;
    }

    public final String getCartSchema() {
        return this.cartSchema;
    }

    public final String getInstantAddress() {
        return this.instantAddress;
    }

    public InstantInfo(String r100, String r101, String r102) {
        this.instantAddress = r100;
        this.addressSource = r101;
        this.cartSchema = r102;
    }

    public /* synthetic */ InstantInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
