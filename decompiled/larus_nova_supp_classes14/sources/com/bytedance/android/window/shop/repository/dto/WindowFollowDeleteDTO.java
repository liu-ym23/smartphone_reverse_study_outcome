package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowFollowDeleteDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "deleteFollowSuccessMsg", "", "(Ljava/lang/String;)V", "getDeleteFollowSuccessMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFollowDeleteDTO extends CommerceBaseResponse {

    @SerializedName("delete_follow_success_msg")
    private final String deleteFollowSuccessMsg;

    public WindowFollowDeleteDTO() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ WindowFollowDeleteDTO copy$default(WindowFollowDeleteDTO r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.deleteFollowSuccessMsg;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.deleteFollowSuccessMsg;
    }

    public final WindowFollowDeleteDTO copy(String r2) {
        return new WindowFollowDeleteDTO(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof WindowFollowDeleteDTO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.deleteFollowSuccessMsg, ((WindowFollowDeleteDTO) r2).deleteFollowSuccessMsg) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = this.deleteFollowSuccessMsg;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "WindowFollowDeleteDTO(deleteFollowSuccessMsg=" + this.deleteFollowSuccessMsg + ")";
    }

    public final String getDeleteFollowSuccessMsg() {
        return this.deleteFollowSuccessMsg;
    }

    public WindowFollowDeleteDTO(String r1) {
        this.deleteFollowSuccessMsg = r1;
    }

    public /* synthetic */ WindowFollowDeleteDTO(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
