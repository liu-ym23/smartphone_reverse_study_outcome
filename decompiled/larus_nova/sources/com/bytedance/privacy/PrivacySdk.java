package com.bytedance.privacy;

import android.content.Context;
import c67.a;
import c67.b;
import com.bytedance.privacy.attestation.IdAttestationManager;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.pcc.PccManager;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;

/* JADX INFO: loaded from: classes3.dex */
public class PrivacySdk {
    private static volatile boolean initialized;

    public PrivacySdk() {
    }

    public static void initEventReporter(a r100) {
    }

    private static void checkInitialized() {
        if (initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Privacy SDK not initialized. Please call PrivacySdk.init(...) during app startup.");
    }

    public static IdAttestationManager getIdAttestationManager() {
        checkInitialized();
        return IdAttestationManager.getInstance();
    }

    public static PseudoManager getPseudoManager() {
        checkInitialized();
        return PseudoManager.getInstance();
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static PccManager getPccManager(Context r100) {
        checkInitialized();
        return PccManager.getInstance(r100);
    }

    public static void initLogger(b r100) {
        k67.b.f501968a = r100;
    }

    public static void init(IAccountBridge r100, IEnvBridge r101) throws BdPrivacyException {
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(PrivacySdk.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (initialized == true) goto L15;
        if (r100 == null) goto L14;
        if (r101 == null) goto L12;
        AccountApi.init(r100);     // Catch: Throwable -> L17
        e67.b.a().f471148a = r101;     // Catch: Throwable -> L17
        initialized = true;     // Catch: Throwable -> L17
        goto L15
    L12:
        throw new BdPrivacyException("IEnvBridge cannot be null");     // Catch: Throwable -> L17
    L14:
        throw new BdPrivacyException("IAccountBridge cannot be null");     // Catch: Throwable -> L17
    L15:
        monitor-exit(PrivacySdk.class);     // Catch: Throwable -> L17
    }
}
