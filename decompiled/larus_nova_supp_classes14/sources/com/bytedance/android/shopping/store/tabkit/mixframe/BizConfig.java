package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/BizConfig;", "Ljava/io/Serializable;", "canRefresh", "", "NoMoreText", "", "(ZLjava/lang/String;)V", "getNoMoreText", "()Ljava/lang/String;", "setNoMoreText", "(Ljava/lang/String;)V", "getCanRefresh", "()Z", "setCanRefresh", "(Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BizConfig implements Serializable {

    @SerializedName("no_more_text")
    private String NoMoreText;

    @SerializedName("can_refresh")
    private boolean canRefresh;

    public BizConfig() {
        String r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public static /* synthetic */ BizConfig copy$default(BizConfig r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.canRefresh;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.NoMoreText;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.canRefresh;
    }

    public final String component2() {
        return this.NoMoreText;
    }

    public final BizConfig copy(boolean r2, String r3) {
        return new BizConfig(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BizConfig) == false) goto L10;
        BizConfig r4 = (BizConfig) r3;
        if (this.canRefresh == r4.canRefresh) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.NoMoreText, r4.NoMoreText) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r0 = this.canRefresh;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        String r3 = this.NoMoreText;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public String toString() {
        return "BizConfig(canRefresh=" + this.canRefresh + ", NoMoreText=" + this.NoMoreText + ")";
    }

    public final boolean getCanRefresh() {
        return this.canRefresh;
    }

    public final String getNoMoreText() {
        return this.NoMoreText;
    }

    public final void setCanRefresh(boolean r1) {
        this.canRefresh = r1;
    }

    public final void setNoMoreText(String r1) {
        this.NoMoreText = r1;
    }

    public BizConfig(boolean r1, String r2) {
        this.canRefresh = r1;
        this.NoMoreText = r2;
    }

    public /* synthetic */ BizConfig(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "没有更多了～";
    L8:
        this(r1, r2);
    }
}
