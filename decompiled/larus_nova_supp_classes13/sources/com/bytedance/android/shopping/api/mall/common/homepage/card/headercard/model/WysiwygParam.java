package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;", "", "items", "", "extraInfo", "", "blockWysiwygItems", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getBlockWysiwygItems", "()Ljava/lang/String;", "getExtraInfo", "()Ljava/util/Map;", "getItems", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WysiwygParam {

    @SerializedName("block_wysiwyg_items")
    private final String blockWysiwygItems;

    @SerializedName("extra_info")
    private final Map<String, String> extraInfo;

    @SerializedName("items")
    private final String items;

    public WysiwygParam() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WysiwygParam copy$default(WysiwygParam r0, String r1, Map r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.items;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.extraInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.blockWysiwygItems;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.items;
    }

    public final Map<String, String> component2() {
        return this.extraInfo;
    }

    public final String component3() {
        return this.blockWysiwygItems;
    }

    public final WysiwygParam copy(String r2, Map<String, String> r3, String r4) {
        return new WysiwygParam(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WysiwygParam) == false) goto L12;
        WysiwygParam r4 = (WysiwygParam) r3;
        if (Intrinsics.areEqual(this.items, r4.items) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extraInfo, r4.extraInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.blockWysiwygItems, r4.blockWysiwygItems) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.items;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.extraInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.blockWysiwygItems;
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
        return "WysiwygParam(items=" + this.items + ", extraInfo=" + this.extraInfo + ", blockWysiwygItems=" + this.blockWysiwygItems + ")";
    }

    public final String getBlockWysiwygItems() {
        return this.blockWysiwygItems;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final String getItems() {
        return this.items;
    }

    public WysiwygParam(String r1, Map<String, String> r2, String r3) {
        this.items = r1;
        this.extraInfo = r2;
        this.blockWysiwygItems = r3;
    }

    public /* synthetic */ WysiwygParam(String r2, Map r3, String r4, int r5, DefaultConstructorMarker r6) {
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
