package com.bytedance.android.shopping.ligo.container.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/ligo/container/event/LiveLigoListJumpToOtherPageEventData;", "Ljava/io/Serializable;", "jumpPage", "", "productId", "(Ljava/lang/String;Ljava/lang/String;)V", "getJumpPage", "()Ljava/lang/String;", "getProductId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLigoListJumpToOtherPageEventData implements Serializable {

    @SerializedName("jump_page")
    private final String jumpPage;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    public LiveLigoListJumpToOtherPageEventData() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ LiveLigoListJumpToOtherPageEventData copy$default(LiveLigoListJumpToOtherPageEventData r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.jumpPage;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.productId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.jumpPage;
    }

    public final String component2() {
        return this.productId;
    }

    public final LiveLigoListJumpToOtherPageEventData copy(String r2, String r3) {
        return new LiveLigoListJumpToOtherPageEventData(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveLigoListJumpToOtherPageEventData) == false) goto L10;
        LiveLigoListJumpToOtherPageEventData r4 = (LiveLigoListJumpToOtherPageEventData) r3;
        if (Intrinsics.areEqual(this.jumpPage, r4.jumpPage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.jumpPage;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.productId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LiveLigoListJumpToOtherPageEventData(jumpPage=" + this.jumpPage + ", productId=" + this.productId + ")";
    }

    public final String getJumpPage() {
        return this.jumpPage;
    }

    public final String getProductId() {
        return this.productId;
    }

    public LiveLigoListJumpToOtherPageEventData(String r1, String r2) {
        this.jumpPage = r1;
        this.productId = r2;
    }

    public /* synthetic */ LiveLigoListJumpToOtherPageEventData(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
