package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;", "", "marginLeft", "", "(I)V", "getMarginLeft", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabUIConfig {

    @SerializedName("margin_left")
    private final int marginLeft;

    public TabUIConfig() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ TabUIConfig copy$default(TabUIConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.marginLeft;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.marginLeft;
    }

    public final TabUIConfig copy(int r2) {
        return new TabUIConfig(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof TabUIConfig) == true) goto L6;
        return false;
    L6:
        if (this.marginLeft == ((TabUIConfig) r2).marginLeft) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.marginLeft;
    }

    public String toString() {
        return "TabUIConfig(marginLeft=" + this.marginLeft + ")";
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public TabUIConfig(int r1) {
        this.marginLeft = r1;
    }

    public /* synthetic */ TabUIConfig(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1);
    }
}
