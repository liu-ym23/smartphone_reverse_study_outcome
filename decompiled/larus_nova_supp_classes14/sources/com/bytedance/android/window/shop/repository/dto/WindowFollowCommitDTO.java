package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowFollowCommitDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "component1", "Lcom/bytedance/android/ec/window/base/repository/dto/s;", "component2", "followSuccessMsg", "hybridComponentDTO", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getFollowSuccessMsg", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/window/base/repository/dto/s;", "getHybridComponentDTO", "()Lcom/bytedance/android/ec/window/base/repository/dto/s;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ec/window/base/repository/dto/s;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFollowCommitDTO extends CommerceBaseResponse {

    @SerializedName("follow_success_msg")
    private final String followSuccessMsg;

    @SerializedName("display_module")
    private final com.bytedance.android.ec.window.base.repository.dto.s hybridComponentDTO;

    public WindowFollowCommitDTO() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ WindowFollowCommitDTO copy$default(WindowFollowCommitDTO r0, String r1, com.bytedance.android.ec.window.base.repository.dto.s r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.followSuccessMsg;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hybridComponentDTO;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.followSuccessMsg;
    }

    public final com.bytedance.android.ec.window.base.repository.dto.s component2() {
        return this.hybridComponentDTO;
    }

    public final WindowFollowCommitDTO copy(String r2, com.bytedance.android.ec.window.base.repository.dto.s r3) {
        return new WindowFollowCommitDTO(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WindowFollowCommitDTO) == false) goto L10;
        WindowFollowCommitDTO r4 = (WindowFollowCommitDTO) r3;
        if (Intrinsics.areEqual(this.followSuccessMsg, r4.followSuccessMsg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hybridComponentDTO, r4.hybridComponentDTO) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.followSuccessMsg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.ec.window.base.repository.dto.s r4 = this.hybridComponentDTO;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "WindowFollowCommitDTO(followSuccessMsg=" + this.followSuccessMsg + ", hybridComponentDTO=" + this.hybridComponentDTO + ")";
    }

    public final String getFollowSuccessMsg() {
        return this.followSuccessMsg;
    }

    public final com.bytedance.android.ec.window.base.repository.dto.s getHybridComponentDTO() {
        return this.hybridComponentDTO;
    }

    public WindowFollowCommitDTO(String r1, com.bytedance.android.ec.window.base.repository.dto.s r2) {
        this.followSuccessMsg = r1;
        this.hybridComponentDTO = r2;
    }

    public /* synthetic */ WindowFollowCommitDTO(String r2, com.bytedance.android.ec.window.base.repository.dto.s r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
