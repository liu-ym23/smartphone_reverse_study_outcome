package com.huawei.hms.framework.common;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: classes23.dex */
public class SecurityRandomHelper {
    public static volatile SecurityRandomHelper instance;

    public static SecurityRandomHelper getInstance() {
        if (instance != null) goto L15;
        monitor-enter(SecurityRandomHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        EncryptUtil.setBouncycastleFlag(true);     // Catch: Throwable -> L11
        instance = new SecurityRandomHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecurityRandomHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private SecurityRandomHelper() {
    }

    public byte[] generateSecureRandom(int r100) {
        return EncryptUtil.generateSecureRandom(r100);
    }

    public String generateSecureRandomStr(int r100) {
        return EncryptUtil.generateSecureRandomStr(r100);
    }
}
