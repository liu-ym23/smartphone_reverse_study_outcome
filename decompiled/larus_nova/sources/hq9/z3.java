package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/larus/platform/model/RealtimeOptConfig;", "", "realtimeDialogEntranceEnable", "", "forceEnterVideoCallEnable", "callTypeRememberEnable", "adjustVolumeTargetScaleAtStart", "", "checkoutToCallModeWhenScreenShareStart", "realtimeSkipBtConnPermission", "<init>", "(ZZZIZZ)V", "getRealtimeDialogEntranceEnable", "()Z", "getForceEnterVideoCallEnable", "getCallTypeRememberEnable", "getAdjustVolumeTargetScaleAtStart", "()I", "getCheckoutToCallModeWhenScreenShareStart", "getRealtimeSkipBtConnPermission", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z3 {

    @SerializedName("adjust_volume_target_when_start")
    private final int adjustVolumeTargetScaleAtStart;

    @SerializedName("call_type_remember_enable")
    private final boolean callTypeRememberEnable;

    @SerializedName("checkout_to_call_mode_when_screen_share")
    private final boolean checkoutToCallModeWhenScreenShareStart;

    @SerializedName("force_enter_video_call_enable")
    private final boolean forceEnterVideoCallEnable;

    @SerializedName("realtime_dialog_entrance_enable")
    private final boolean realtimeDialogEntranceEnable;

    @SerializedName("realtime_skip_bt_conn_permission")
    private final boolean realtimeSkipBtConnPermission;

    public z3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z3) == true) goto L8;
        return false;
    L8:
        z3 r101 = (z3) r100;
        if (this.realtimeDialogEntranceEnable == r101.realtimeDialogEntranceEnable) goto L12;
        return false;
    L12:
        if (this.forceEnterVideoCallEnable == r101.forceEnterVideoCallEnable) goto L15;
        return false;
    L15:
        if (this.callTypeRememberEnable == r101.callTypeRememberEnable) goto L18;
        return false;
    L18:
        if (this.adjustVolumeTargetScaleAtStart == r101.adjustVolumeTargetScaleAtStart) goto L21;
        return false;
    L21:
        if (this.checkoutToCallModeWhenScreenShareStart == r101.checkoutToCallModeWhenScreenShareStart) goto L24;
        return false;
    L24:
        if (this.realtimeSkipBtConnPermission == r101.realtimeSkipBtConnPermission) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.realtimeDialogEntranceEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.forceEnterVideoCallEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.callTypeRememberEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((r104 + r105) * 31) + this.adjustVolumeTargetScaleAtStart) * 31;
        if (this.checkoutToCallModeWhenScreenShareStart == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.realtimeSkipBtConnPermission == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RealtimeOptConfig(realtimeDialogEntranceEnable=" + this.realtimeDialogEntranceEnable + ", forceEnterVideoCallEnable=" + this.forceEnterVideoCallEnable + ", callTypeRememberEnable=" + this.callTypeRememberEnable + ", adjustVolumeTargetScaleAtStart=" + this.adjustVolumeTargetScaleAtStart + ", checkoutToCallModeWhenScreenShareStart=" + this.checkoutToCallModeWhenScreenShareStart + ", realtimeSkipBtConnPermission=" + this.realtimeSkipBtConnPermission + ')';
    }

    public final int a() {
        return this.adjustVolumeTargetScaleAtStart;
    }

    public final boolean b() {
        return this.callTypeRememberEnable;
    }

    public final boolean c() {
        return this.checkoutToCallModeWhenScreenShareStart;
    }

    public final boolean d() {
        return this.forceEnterVideoCallEnable;
    }

    public final boolean e() {
        return this.realtimeDialogEntranceEnable;
    }

    public final boolean f() {
        return this.realtimeSkipBtConnPermission;
    }

    public z3(int r100) {
        this.realtimeDialogEntranceEnable = false;
        this.forceEnterVideoCallEnable = false;
        this.callTypeRememberEnable = true;
        this.adjustVolumeTargetScaleAtStart = -1;
        this.checkoutToCallModeWhenScreenShareStart = true;
        this.realtimeSkipBtConnPermission = true;
    }
}
