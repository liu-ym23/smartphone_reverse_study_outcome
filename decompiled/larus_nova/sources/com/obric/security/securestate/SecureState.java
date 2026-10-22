package com.obric.security.securestate;

/* JADX INFO: loaded from: classes34.dex */
public class SecureState {
    public static SecureState getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public boolean avbIsVerified() {
        throw new RuntimeException("Stub!!");
    }

    public boolean buildIsUserDebug() {
        throw new RuntimeException("Stub!!");
    }

    public boolean deviceIsLocked() {
        throw new RuntimeException("Stub!!");
    }

    public boolean deviceIsSecure() {
        throw new RuntimeException("Stub!!");
    }

    public DeviceSecureState getDeviceSecureState() {
        throw new RuntimeException("Stub!!");
    }

    public boolean kernelIsSecure() {
        throw new RuntimeException("Stub!!");
    }

    public boolean securebootIsEnabled() {
        throw new RuntimeException("Stub!!");
    }

    public boolean selinuxIsEnforcing() {
        throw new RuntimeException("Stub!!");
    }

    private SecureState() {
    }

    public boolean registerCallback(SecureStateCallback r100) {
        throw new RuntimeException("Stub!!");
    }

    public boolean unregisterCallback(SecureStateCallback r100) {
        throw new RuntimeException("Stub!!");
    }
}
