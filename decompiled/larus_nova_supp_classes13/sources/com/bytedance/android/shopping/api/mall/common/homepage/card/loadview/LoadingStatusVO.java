package com.bytedance.android.shopping.api.mall.common.homepage.card.loadview;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/loadview/LoadingStatusVO;", "", "loadingStatus", "", "(Ljava/lang/Integer;)V", "getLoadingStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/loadview/LoadingStatusVO;", "equals", "", "other", "hashCode", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadingStatusVO {

    @SerializedName("loading_status")
    private final Integer loadingStatus;

    public LoadingStatusVO() {
        Integer r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ LoadingStatusVO copy$default(LoadingStatusVO r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.loadingStatus;
    L6:
        return r0.copy(r1);
    }

    public final Integer component1() {
        return this.loadingStatus;
    }

    public final LoadingStatusVO copy(Integer r2) {
        return new LoadingStatusVO(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof LoadingStatusVO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.loadingStatus, ((LoadingStatusVO) r2).loadingStatus) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.loadingStatus;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "LoadingStatusVO(loadingStatus=" + this.loadingStatus + ")";
    }

    public final Integer getLoadingStatus() {
        return this.loadingStatus;
    }

    public LoadingStatusVO(Integer r1) {
        this.loadingStatus = r1;
    }

    public /* synthetic */ LoadingStatusVO(Integer r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
