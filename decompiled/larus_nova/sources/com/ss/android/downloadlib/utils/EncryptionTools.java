package com.ss.android.downloadlib.utils;

import android.os.SystemClock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes34.dex */
public class EncryptionTools {
    private static final String TAG = "FFFEI:EncryptionTools";

    public EncryptionTools() {
    }

    public static long getBootTime() {
        return (System.currentTimeMillis() - (SystemClock.elapsedRealtimeNanos() / 1000000)) / 1000;
    }

    private static String bytesToHex(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append(String.format("%02x", new Object[]{Byte.valueOf(r100[r103])}));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static String encryptionAction(String r100) {
        return hash("bd_com.bytedance.ads.convert_" + r100 + "_" + getBootTime());
    }

    private static String hash(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
        r101.update(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L4
        return bytesToHex(r101.digest());
    L7:
        return r100;
    }
}
