package lq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/audio/AsrInputEntranceConfig;", "", "newUserSwitchDuration", "", "newUserSwitchTimes", "oldUserShouldSwitch", "", "forceSwitchEachLaunch", "<init>", "(IIZZ)V", "getNewUserSwitchDuration", "()I", "getNewUserSwitchTimes", "getOldUserShouldSwitch", "()Z", "getForceSwitchEachLaunch", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("force_switch_each_launch")
    private final boolean forceSwitchEachLaunch;

    @SerializedName("new_user_switch_duration")
    private final int newUserSwitchDuration;

    @SerializedName("new_user_switch_times")
    private final int newUserSwitchTimes;

    @SerializedName("old_user_should_switch")
    private final boolean oldUserShouldSwitch;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.newUserSwitchDuration == r101.newUserSwitchDuration) goto L12;
        return false;
    L12:
        if (this.newUserSwitchTimes == r101.newUserSwitchTimes) goto L15;
        return false;
    L15:
        if (this.oldUserShouldSwitch == r101.oldUserShouldSwitch) goto L18;
        return false;
    L18:
        if (this.forceSwitchEachLaunch == r101.forceSwitchEachLaunch) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.newUserSwitchDuration * 31) + this.newUserSwitchTimes) * 31;
        int r101 = 1231;
        if (this.oldUserShouldSwitch == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.forceSwitchEachLaunch == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrInputEntranceConfig(newUserSwitchDuration=" + this.newUserSwitchDuration + ", newUserSwitchTimes=" + this.newUserSwitchTimes + ", oldUserShouldSwitch=" + this.oldUserShouldSwitch + ", forceSwitchEachLaunch=" + this.forceSwitchEachLaunch + ')';
    }

    public final boolean a() {
        return this.forceSwitchEachLaunch;
    }

    public final int b() {
        return this.newUserSwitchDuration;
    }

    public final int c() {
        return this.newUserSwitchTimes;
    }

    public final boolean d() {
        return this.oldUserShouldSwitch;
    }

    public b(int r100) {
        this.newUserSwitchDuration = 0;
        this.newUserSwitchTimes = 0;
        this.oldUserShouldSwitch = false;
        this.forceSwitchEachLaunch = false;
    }
}
