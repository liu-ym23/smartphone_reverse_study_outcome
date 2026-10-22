package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/GroupInfoResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "groupInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "(Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;)V", "getGroupInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/GroupInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupInfoResponse extends CommerceBaseResponse {

    @SerializedName("group_info")
    private final GroupInfo groupInfo;

    public GroupInfoResponse() {
        GroupInfo r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ GroupInfoResponse copy$default(GroupInfoResponse r0, GroupInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.groupInfo;
    L6:
        return r0.copy(r1);
    }

    public final GroupInfo component1() {
        return this.groupInfo;
    }

    public final GroupInfoResponse copy(GroupInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "groupInfo");
        return new GroupInfoResponse(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof GroupInfoResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.groupInfo, ((GroupInfoResponse) r2).groupInfo) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        GroupInfo r0 = this.groupInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "GroupInfoResponse(groupInfo=" + this.groupInfo + ")";
    }

    public final GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public GroupInfoResponse(GroupInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "groupInfo");
        this.groupInfo = r2;
    }

    public /* synthetic */ GroupInfoResponse(GroupInfo r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        GroupInfo r0 = new GroupInfo(0, null, 0, 0, 0, 0, 0, 0, null, null, 1023, null);
    L6:
        this(r0);
        return;
    L5:
        r0 = r19;
        goto L6
    }
}
