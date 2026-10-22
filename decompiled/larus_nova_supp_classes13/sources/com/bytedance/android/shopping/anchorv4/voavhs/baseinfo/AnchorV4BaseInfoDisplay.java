package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoDisplay;", "Ljava/io/Serializable;", "baseInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;", "activityInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;)V", "getActivityInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "getBaseInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BaseInfoDisplay implements Serializable {

    @SerializedName("activity_info")
    private final ActivityVO activityInfo;

    @SerializedName("base_info")
    private final BaseInfoVO baseInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4BaseInfoDisplay() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4BaseInfoDisplay copy$default(AnchorV4BaseInfoDisplay r0, BaseInfoVO r1, ActivityVO r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.baseInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.activityInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public final BaseInfoVO component1() {
        return this.baseInfo;
    }

    public final ActivityVO component2() {
        return this.activityInfo;
    }

    public final AnchorV4BaseInfoDisplay copy(BaseInfoVO r2, ActivityVO r3) {
        return new AnchorV4BaseInfoDisplay(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4BaseInfoDisplay) == false) goto L10;
        AnchorV4BaseInfoDisplay r4 = (AnchorV4BaseInfoDisplay) r3;
        if (Intrinsics.areEqual(this.baseInfo, r4.baseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.activityInfo, r4.activityInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        BaseInfoVO r0 = this.baseInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ActivityVO r4 = this.activityInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4BaseInfoDisplay(baseInfo=" + this.baseInfo + ", activityInfo=" + this.activityInfo + ")";
    }

    public final ActivityVO getActivityInfo() {
        return this.activityInfo;
    }

    public final BaseInfoVO getBaseInfo() {
        return this.baseInfo;
    }

    public AnchorV4BaseInfoDisplay(BaseInfoVO r1, ActivityVO r2) {
        this.baseInfo = r1;
        this.activityInfo = r2;
    }

    public /* synthetic */ AnchorV4BaseInfoDisplay(BaseInfoVO r2, ActivityVO r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
