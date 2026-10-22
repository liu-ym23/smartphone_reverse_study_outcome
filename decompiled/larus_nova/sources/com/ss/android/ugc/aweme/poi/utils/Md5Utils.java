package com.ss.android.ugc.aweme.poi.utils;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes40.dex */
public class Md5Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f451365a = null;

    static {
        f451365a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(String r100) {
        byte[] r101 = r100.getBytes();     // Catch: Exception -> L13
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r102.update(r101);     // Catch: Exception -> L10
        byte[] r103 = r102.digest();     // Catch: Exception -> L10
        char[] r104 = new char[32];     // Catch: Exception -> L10
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= 16) goto L8;
        byte r107 = r103[r105];     // Catch: Exception -> L10
        int r108 = r106 + 1;     // Catch: Exception -> L10
        char[] r109 = f451365a;     // Catch: Exception -> L10
        r104[r106] = r109[(r107 >>> 4) & 15];     // Catch: Exception -> L10
        r106 = r108 + 1;     // Catch: Exception -> L10
        r104[r108] = r109[r107 & 15];     // Catch: Exception -> L10
        r105 = r105 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
    L21:
        return new String(r104);
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
