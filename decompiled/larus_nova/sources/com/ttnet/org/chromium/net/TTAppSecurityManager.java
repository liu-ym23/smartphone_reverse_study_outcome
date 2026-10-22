package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public final class TTAppSecurityManager {
    private static final String TAG = null;
    private static volatile TTAppSecurityManager sInstance;
    private ITTSystemApiSandbox mSystemApiSandbox;

    public interface ITTSystemApiSandbox {
        String getNetworkOperator();

        String getSimOperator();

        int getWifiFrequency();

        int getWifiRssi();
    }

    public interface Natives {
        boolean isTTPRestrictionEnabled();

        boolean isUserPrivacyRestrictionEnabled();
    }

    public TTAppSecurityManager() {
    }

    static {
        TAG = "TTAppSecurityManager";
    }

    public static TTAppSecurityManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TTAppSecurityManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTAppSecurityManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTAppSecurityManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public String getNetworkOperator() {
        ITTSystemApiSandbox r100 = this.mSystemApiSandbox;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getNetworkOperator();
    }

    public String getSimOperator() {
        ITTSystemApiSandbox r100 = this.mSystemApiSandbox;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getSimOperator();
    }

    public int getWifiFrequency() {
        ITTSystemApiSandbox r100 = this.mSystemApiSandbox;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWifiFrequency();
    }

    public int getWifiRssi() {
        ITTSystemApiSandbox r100 = this.mSystemApiSandbox;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getWifiRssi();
    }

    public boolean isTTPRestrictionEnabled() {
        return TTAppSecurityManagerJni.get().isTTPRestrictionEnabled();
    }

    public boolean isUserPrivacyRestrictionEnabled() {
        return TTAppSecurityManagerJni.get().isUserPrivacyRestrictionEnabled();
    }

    public void setSystemApiSandbox(ITTSystemApiSandbox r100) {
        this.mSystemApiSandbox = r100;
    }
}
