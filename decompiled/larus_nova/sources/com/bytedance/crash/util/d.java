package com.bytedance.crash.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static String a(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L11
        r101.update(r100.getBytes());     // Catch: Throwable -> L11
        byte[] r102 = r101.digest();     // Catch: Throwable -> L11
        if (r102.length <= 0) goto L9;
        int r103 = 0;
        char[] r104 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};     // Catch: Throwable -> L11
        char[] r105 = new char[r102.length * 2];     // Catch: Throwable -> L11
        int r106 = r102.length;     // Catch: Throwable -> L11
        int r107 = 0;
    L5:
        if (r103 >= r106) goto L7;
        byte r108 = r102[r103];     // Catch: Throwable -> L11
        int r109 = r107 + 1;     // Catch: Throwable -> L11
        r105[r107] = r104[(r108 >>> 4) & 15];     // Catch: Throwable -> L11
        r107 = r109 + 1;     // Catch: Throwable -> L11
        r105[r109] = r104[r108 & 15];     // Catch: Throwable -> L11
        r103 = r103 + 1;     // Catch: Throwable -> L11
        goto L5
    L7:
        return new String(r105);
    L9:
        return null;
    L15:
        return null;
    }
}
