package com.bytedance.security.secure_state;

/* JADX INFO: loaded from: classes22.dex */
public class DeviceSecureState {
    public boolean avbVerified;
    public boolean deviceLocked;
    public boolean kernelSecure;
    public String osBuildType;
    public boolean securebootEnabled;
    public boolean selinuxEnforcing;

    public String toString() {
        return super.toString();
    }

    public DeviceSecureState() {
    }

    public DeviceSecureState(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
    }
}
