package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class LeanModeInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<LeanModeInfo> CREATOR = null;

    @JSONField(name = "all_devices_in_lean_mode")
    public boolean allDevicesInLeanMode;

    @JSONField(name = "can_use_lean_mode")
    public boolean canUseLeanMode;

    @JSONField(name = "device_have_authority")
    public boolean deviceHaveAuthority;

    @JSONField(name = "is_lock_screen_enabled")
    public boolean isLockScreenEnabled;

    @JSONField(name = "lean_mode_cfg_update_time")
    public long leanModeCfgUpdateTime;

    @JSONField(name = "lock_screen_cfg_update_time")
    public long lockScreenCfgUpdateTime;

    @JSONField(name = "lock_screen_pwd")
    public String lockScreenPwd;

    public class a implements Parcelable.Creator<LeanModeInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LeanModeInfo createFromParcel(Parcel r100) {
            return new LeanModeInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final LeanModeInfo[] newArray(int r100) {
            return new LeanModeInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "LeanModeInfo{deviceHaveAuthority=" + this.deviceHaveAuthority + ", isLockScreenEnabled=" + this.isLockScreenEnabled + ", allDevicesInLeanMode=" + this.allDevicesInLeanMode + ", canUseLeanMode=" + this.canUseLeanMode + ", lockScreenCfgUpdateTime=" + this.lockScreenCfgUpdateTime + ", leanModeCfgUpdateTime=" + this.leanModeCfgUpdateTime + '}';
    }

    public LeanModeInfo() {
    }

    public LeanModeInfo(Parcel r100) {
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.deviceHaveAuthority = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.isLockScreenEnabled = r103;
        this.lockScreenPwd = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.allDevicesInLeanMode = r104;
        if (r100.readByte() != 0) goto L18;
        r101 = false;
    L18:
        this.canUseLeanMode = r101;
        this.lockScreenCfgUpdateTime = r100.readLong();
        this.leanModeCfgUpdateTime = r100.readLong();
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.deviceHaveAuthority ? 1 : 0);
        r100.writeByte(this.isLockScreenEnabled ? 1 : 0);
        r100.writeString(this.lockScreenPwd);
        r100.writeByte(this.allDevicesInLeanMode ? 1 : 0);
        r100.writeByte(this.canUseLeanMode ? 1 : 0);
        r100.writeLong(this.lockScreenCfgUpdateTime);
        r100.writeLong(this.leanModeCfgUpdateTime);
    }
}
