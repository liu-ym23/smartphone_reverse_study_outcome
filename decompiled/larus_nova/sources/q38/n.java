package q38;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jk\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/account/base/model/StatusInfo;", "", "canFastCancel", "", "cancelApplyTime", "", "cancelCoolTime", "cancelBufferTime", "isCanceling", "lastOpTime", "unusableMobileLevel", "", "deathState", "isLocked", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IZZ)V", "getCanFastCancel", "()Z", "getCancelApplyTime", "()Ljava/lang/String;", "getCancelCoolTime", "getCancelBufferTime", "getLastOpTime", "getUnusableMobileLevel", "()I", "getDeathState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n {

    @SerializedName("can_fast_cancel")
    private final boolean canFastCancel;

    @SerializedName("cancel_apply_time")
    private final String cancelApplyTime;

    @SerializedName("cancel_buffer_time")
    private final String cancelBufferTime;

    @SerializedName("cancel_cool_time")
    private final String cancelCoolTime;

    @SerializedName("death_state")
    private final boolean deathState;

    @SerializedName("is_canceling")
    private final boolean isCanceling;

    @SerializedName("is_locked")
    private final boolean isLocked;

    @SerializedName("last_op_time")
    private final String lastOpTime;

    @SerializedName("unusable_mobile_level")
    private final int unusableMobileLevel;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.canFastCancel == r101.canFastCancel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cancelApplyTime, r101.cancelApplyTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cancelCoolTime, r101.cancelCoolTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cancelBufferTime, r101.cancelBufferTime) == true) goto L21;
        return false;
    L21:
        if (this.isCanceling == r101.isCanceling) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lastOpTime, r101.lastOpTime) == true) goto L27;
        return false;
    L27:
        if (this.unusableMobileLevel == r101.unusableMobileLevel) goto L30;
        return false;
    L30:
        if (this.deathState == r101.deathState) goto L33;
        return false;
    L33:
        if (this.isLocked == r101.isLocked) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.canFastCancel == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.cancelApplyTime;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.cancelCoolTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cancelBufferTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.isCanceling == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        String r115 = this.lastOpTime;
        if (r115 == null) goto L26;
        r104 = r115.hashCode();
    L26:
        int r116 = (((r114 + r104) * 31) + this.unusableMobileLevel) * 31;
        if (this.deathState == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (r116 + r117) * 31;
        if (this.isLocked == true) goto L35;
        r100 = 1237;
    L35:
        return r118 + r100;
    L29:
        r117 = 1237;
        goto L30
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "StatusInfo(canFastCancel=" + this.canFastCancel + ", cancelApplyTime=" + this.cancelApplyTime + ", cancelCoolTime=" + this.cancelCoolTime + ", cancelBufferTime=" + this.cancelBufferTime + ", isCanceling=" + this.isCanceling + ", lastOpTime=" + this.lastOpTime + ", unusableMobileLevel=" + this.unusableMobileLevel + ", deathState=" + this.deathState + ", isLocked=" + this.isLocked + ')';
    }

    public n() {
        this.canFastCancel = false;
        this.cancelApplyTime = null;
        this.cancelCoolTime = null;
        this.cancelBufferTime = null;
        this.isCanceling = false;
        this.lastOpTime = null;
        this.unusableMobileLevel = 0;
        this.deathState = false;
        this.isLocked = false;
    }
}
