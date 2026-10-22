package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "Ljava/io/Serializable;", "skuTabs", "", "", "defaultPosition", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getDefaultPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSkuTabs", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPreviewMeta;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPreviewMeta implements Serializable {

    @SerializedName("default_position")
    private final Integer defaultPosition;

    @SerializedName("sku_tabs")
    private final List<String> skuTabs;

    /* JADX WARN: Multi-variable type inference failed */
    public HeaderPreviewMeta() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderPreviewMeta copy$default(HeaderPreviewMeta r0, List r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.skuTabs;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.defaultPosition;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.skuTabs;
    }

    public final Integer component2() {
        return this.defaultPosition;
    }

    public final HeaderPreviewMeta copy(List<String> r2, Integer r3) {
        return new HeaderPreviewMeta(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderPreviewMeta) == false) goto L10;
        HeaderPreviewMeta r4 = (HeaderPreviewMeta) r3;
        if (Intrinsics.areEqual(this.skuTabs, r4.skuTabs) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultPosition, r4.defaultPosition) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.skuTabs;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.defaultPosition;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderPreviewMeta(skuTabs=" + this.skuTabs + ", defaultPosition=" + this.defaultPosition + ")";
    }

    public final Integer getDefaultPosition() {
        return this.defaultPosition;
    }

    public final List<String> getSkuTabs() {
        return this.skuTabs;
    }

    public HeaderPreviewMeta(List<String> r1, Integer r2) {
        this.skuTabs = r1;
        this.defaultPosition = r2;
    }

    public /* synthetic */ HeaderPreviewMeta(List r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
