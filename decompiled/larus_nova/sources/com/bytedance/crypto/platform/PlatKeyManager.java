package com.bytedance.crypto.platform;

import android.content.Context;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.g;
import com.bytedance.crypto.utils.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes15.dex */
public class PlatKeyManager {
    private static final String TAG = "PlatKeyManager";
    private static volatile PlatKeyManager platKeyManager;

    private PlatKeyManager() {
    }

    public static PlatKeyManager getInstance() {
        if (platKeyManager != null) goto L15;
        monitor-enter(PlatKeyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (platKeyManager != null) goto L9;
        platKeyManager = new PlatKeyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManager.class);     // Catch: Throwable -> L11
    L15:
        return platKeyManager;
    }

    public String reEncryptFEK(Context r100, String r101, int r102) {
        return g.a().a(r100, r101, r102, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    }

    public String reEncryptFEKV2(Context r100, String r101, int r102, String r103) {
        return g.a().a(r100, r101, r102, r103 + "-externalDevModelKeyEncryptKey");
    }

    public byte[] decryptModelFile(Context r100, InputStream r101, String r102) {
        g.a().getClass();
        c.a().getClass();
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        if (r102 == null) goto L10;
        if (r102.isEmpty() == true) goto L10;
        return b.a(r100, r101, r102, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
    L10:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new byte[0];
    }

    public int decryptModelFile(Context r100, InputStream r101, OutputStream r102, String r103) {
        g.a().getClass();
        return c.a().a(r100, r101, r102, r103);
    }

    public byte[] decryptModelFileV2(Context r100, InputStream r101, String r102, String r103) {
        String r104 = r103 + "-externalDevModelKeyEncryptKey";
        g.a().getClass();
        c.a().getClass();
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        if (r104 == null) goto L13;
        if (r104.isEmpty() == true) goto L13;
        return b.a(r100, r101, r102, r104);
    L13:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new byte[0];
    }

    public int decryptModelFileV2(Context r100, InputStream r101, OutputStream r102, String r103, String r104) {
        String r105 = r104 + "-externalDevModelKeyEncryptKey";
        g.a().getClass();
        c.a().getClass();
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if (r102 == null) goto L14;
        if (r103 == null) goto L14;
        if (r103.isEmpty() == true) goto L14;
        if (r105 == null) goto L14;
        if (r105.isEmpty() == true) goto L14;
        return b.a(r100, r101, r102, r103, r105);
    L14:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    }
}
