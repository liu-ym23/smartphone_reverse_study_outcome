package com.bytedance.android.shopping.feed.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003JQ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR6\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesComponent;", "Ljava/io/Serializable;", "jumpUrl", "", "skus", "", "Lcom/bytedance/android/shopping/feed/repository/dto/DetailCombinePropertiesSkusStruct;", "products", "Ljava/util/HashMap;", "Lcom/bytedance/android/shopping/feed/repository/dto/ProductFormatGroup;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/HashMap;)V", "getJumpUrl", "()Ljava/lang/String;", "getProducts", "()Ljava/util/HashMap;", "getSkus", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailCombinePropertiesComponent implements Serializable {

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("product_formats")
    private final HashMap<String, ProductFormatGroup> products;

    @SerializedName("skus")
    private final List<DetailCombinePropertiesSkusStruct> skus;

    public DetailCombinePropertiesComponent() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DetailCombinePropertiesComponent copy$default(DetailCombinePropertiesComponent r0, String r1, List r2, HashMap r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.jumpUrl;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.skus;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.products;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.jumpUrl;
    }

    public final List<DetailCombinePropertiesSkusStruct> component2() {
        return this.skus;
    }

    public final HashMap<String, ProductFormatGroup> component3() {
        return this.products;
    }

    public final DetailCombinePropertiesComponent copy(String r2, List<DetailCombinePropertiesSkusStruct> r3, HashMap<String, ProductFormatGroup> r4) {
        return new DetailCombinePropertiesComponent(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DetailCombinePropertiesComponent) == false) goto L12;
        DetailCombinePropertiesComponent r4 = (DetailCombinePropertiesComponent) r3;
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skus, r4.skus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.products, r4.products) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.jumpUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<DetailCombinePropertiesSkusStruct> r4 = this.skus;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        HashMap<String, ProductFormatGroup> r7 = this.products;
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

    public String toString() {
        return "DetailCombinePropertiesComponent(jumpUrl=" + this.jumpUrl + ", skus=" + this.skus + ", products=" + this.products + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final HashMap<String, ProductFormatGroup> getProducts() {
        return this.products;
    }

    public final List<DetailCombinePropertiesSkusStruct> getSkus() {
        return this.skus;
    }

    public DetailCombinePropertiesComponent(String r1, List<DetailCombinePropertiesSkusStruct> r2, HashMap<String, ProductFormatGroup> r3) {
        this.jumpUrl = r1;
        this.skus = r2;
        this.products = r3;
    }

    public /* synthetic */ DetailCombinePropertiesComponent(String r2, List r3, HashMap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
