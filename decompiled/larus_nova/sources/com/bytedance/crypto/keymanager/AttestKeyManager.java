package com.bytedance.crypto.keymanager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class AttestKeyManager {
    private static final HashMap<String, String> APP_ID_LIST = null;
    public static final String TAG = "AttestKeyManager";
    private static volatile AttestKeyManager keyManager;

    static {
        APP_ID_LIST = new AnonymousClass1();
    }

    public AttestKeyManager() {
    }

    private List<Certificate> attestKey(Context r100, String r101, String r102, String r103, boolean r104) {
        Bundle r105 = new Bundle();
        if (r104 == false) goto L11;
        r105.putBoolean(FrameworkSecurityCompat.KeyManagerConst.DEVICE_HEALTH_STATUS_REQUIRED(), true);
        if (r102 != null) goto L7;
    L10:
        String r106 = FrameworkSecurityCompat.KeyManagerConst.CHALLENGE();
        r103 = r103 + "::" + APP_ID_LIST.getOrDefault(r100.getPackageName(), "");
    L12:
        r105.putString(r106, r103);
    L13:
        FrameworkSecurityCompat.KmResult r107 = FrameworkSecurityCompat.keyAttestation(r100, r101, r105);
        if (r107.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L17;
        LogUtils.e(TAG, "Attest key failed! ret:" + r107.getResultCode());
        return new ArrayList();
    L17:
        List<Certificate> r108 = r107.getCertChain();
        LogUtils.d(TAG, "Attest key succeed! cert chain size:" + r108.size());
        return r108;
    L7:
        if (r102.isEmpty() == true) goto L10;
        r105.putString(FrameworkSecurityCompat.KeyManagerConst.CHALLENGE(), r103 + "::" + r102);
        goto L13
    L11:
        r106 = FrameworkSecurityCompat.KeyManagerConst.CHALLENGE();
        goto L12
    }

    private int generateKeyPair(Context r100, String r101, Bundle r102) {
        int r103 = FrameworkSecurityCompat.generateKeyPair(r100, r101, r102);
        if (r103 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        LogUtils.e(TAG, "Generate key pair failed! ret:" + r103);
        return r103;
    L7:
        return FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS();
    }

    public static AttestKeyManager getInstance() {
        if (keyManager != null) goto L15;
        monitor-enter(AttestKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (keyManager != null) goto L9;
        keyManager = new AttestKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AttestKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return keyManager;
    }

    public void deleteAttestKey(Context r100, String r101) {
        int r102 = FrameworkSecurityCompat.deleteKey(r100, r101, new Bundle());
        LogUtils.i(TAG, "Delete attest key! keyAlias:" + r101 + " ret:" + r102);
    }

    public List<Certificate> getAttestCertChain(Context r100, String r101, String r102, boolean r110, Bundle r111) {
        String r103 = ChallengeManager.requestChallenge();
        if (TextUtils.isEmpty(r103) == false) goto L6;
        LogUtils.e(TAG, "Request challenge failed!!");
        return new ArrayList();
    L6:
        String r104 = TAG;
        LogUtils.d(r104, "Request challenge succeed! challenge:" + r103);
        int r112 = generateKeyPair(r100, r101, r111);
        if (r112 == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L11;
        LogUtils.e(r104, "Generate attestation key pair failed! ret:" + r112);
        return new ArrayList();
    L11:
        return attestKey(r100, r101, r102, r103, r110);
    }
}
