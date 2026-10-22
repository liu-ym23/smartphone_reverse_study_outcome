package com.bytedance.locallife.host.share;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/host/share/CollectExtraParams;", "Ljava/io/Serializable;", "isCollected", "", "productId", "", "(ILjava/lang/String;)V", "()I", "setCollected", "(I)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CollectExtraParams implements Serializable {

    @SerializedName("is_collected")
    private int isCollected;

    @SerializedName("product_id")
    private String productId;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectExtraParams() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CollectExtraParams copy$default(CollectExtraParams r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isCollected;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.productId;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.isCollected;
    }

    public final String component2() {
        return this.productId;
    }

    public final CollectExtraParams copy(int r100, String r101) {
        return new CollectExtraParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectExtraParams) == true) goto L8;
        return false;
    L8:
        CollectExtraParams r101 = (CollectExtraParams) r100;
        if (this.isCollected == r101.isCollected) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.isCollected * 31;
        String r101 = this.productId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CollectExtraParams(isCollected=" + this.isCollected + ", productId=" + this.productId + ')';
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int isCollected() {
        return this.isCollected;
    }

    public final void setCollected(int r100) {
        this.isCollected = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public CollectExtraParams(int r100, String r101) {
        this.isCollected = r100;
        this.productId = r101;
    }

    public /* synthetic */ CollectExtraParams(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
