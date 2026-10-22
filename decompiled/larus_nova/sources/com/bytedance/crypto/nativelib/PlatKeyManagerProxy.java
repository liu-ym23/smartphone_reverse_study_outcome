package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.crypto.platform.PlatKeyManager;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes15.dex */
public class PlatKeyManagerProxy {
    private static final String TAG = "PlatKeyManagerProxy";
    private static volatile PlatKeyManagerProxy platKeyManagerProxy;

    public PlatKeyManagerProxy() {
    }

    public static PlatKeyManagerProxy getInstance() {
        if (platKeyManagerProxy != null) goto L15;
        monitor-enter(PlatKeyManagerProxy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (platKeyManagerProxy != null) goto L9;
        platKeyManagerProxy = new PlatKeyManagerProxy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManagerProxy.class);     // Catch: Throwable -> L11
    L15:
        return platKeyManagerProxy;
    }

    public byte[] decryptModelFile(Context r100, String r101, String r102, String r103) {
        LogUtils.d(TAG, "decryptModelFile enter");
        if (r101 != null) goto L5;
    L36:
        String r104 = "inPath is null or empty";
    L28:
        LogUtils.e(TAG, r104);
        return new byte[0];
    L5:
        if (r101.isEmpty() == true) goto L36;
        if (r102 != null) goto L9;
    L35:
        r104 = "FEKCipher is null or empty";
        goto L28
    L9:
        if (r102.isEmpty() == true) goto L35;
        if (r103 != null) goto L13;
    L34:
        r104 = "secAppId is null or empty";
        goto L28
    L13:
        if (r103.isEmpty() == true) goto L34;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r101);     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
        byte[] r106 = PlatKeyManager.getInstance().decryptModelFileV2(r100, r105, r102, r103);     // Catch: Throwable -> L19
        r105.close();     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
        return r106;
    L19:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
    L32:
        e = move-exception;
        StringBuilder r107 = new StringBuilder("File not exist, exception: ");
        String r108 = e.getMessage();
    L27:
        r107.append(r108);
        r104 = r107.toString();
    L30:
        e = move-exception;
        r107 = new StringBuilder("IOException: ");
        r108 = e.getMessage();
    L25:
        e = move-exception;
        r107 = new StringBuilder("Other exception: ");
        r108 = e.getMessage();
        goto L27
    }

    public int decryptModelFileByStream(Context r110, String r111, String r112, String r113, String r114) {
        LogUtils.d(TAG, "decryptModelFileByStream enter");
        if (r111 != null) goto L5;
    L51:
        String r115 = "inPath is null or empty";
    L47:
        LogUtils.e(TAG, r115);
        return -2;
    L5:
        if (r111.isEmpty() == true) goto L51;
        if (r112 != null) goto L9;
    L50:
        r115 = "outPath is null or empty";
        goto L47
    L9:
        if (r112.isEmpty() == true) goto L50;
        if (r113 != null) goto L13;
    L49:
        r115 = "FEKCipher is null or empty";
        goto L47
    L13:
        if (r113.isEmpty() == true) goto L49;
        if (r114 != null) goto L17;
    L46:
        r115 = "secAppId is null or empty";
        goto L47
    L17:
        if (r114.isEmpty() == true) goto L46;
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper(r111);     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
        PolarisFileOutputStreamWrapper r116 = new PolarisFileOutputStreamWrapper(r112);     // Catch: Throwable -> L31
        int r117 = PlatKeyManager.getInstance().decryptModelFileV2(r110, r100, r116, r113, r114);     // Catch: Throwable -> L25
        r116.close();     // Catch: Throwable -> L31
        r100.close();     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
        return r117;
    L25:
        th = move-exception;
        r116.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
    L43:
        e = move-exception;
        LogUtils.e(TAG, "File not exist, exception: " + e.getMessage());
        return -16;
    L40:
        e = move-exception;
        LogUtils.e(TAG, "IOException: " + e.getMessage());
        return -17;
    L37:
        e = move-exception;
        LogUtils.e(TAG, "Other exception: " + e.getMessage());
        return -1000;
    }

    public String reEncryptFEK(Context r100, String r101, String r102, int r103) {
        LogUtils.d(TAG, "reEncryptFEK enter");
        return PlatKeyManager.getInstance().reEncryptFEKV2(r100, r101, r103, r102);
    }
}
