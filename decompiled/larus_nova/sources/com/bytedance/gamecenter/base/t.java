package com.bytedance.gamecenter.base;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes19.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f245059a = null;

    static {
        f245059a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        byte[] r101 = r100.getBytes();
        byte[] r102 = MessageDigest.getInstance("MD5").digest(r101);     // Catch: NoSuchAlgorithmException -> L12
        StringBuffer r103 = new StringBuffer();     // Catch: NoSuchAlgorithmException -> L12
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L10;
        byte r105 = r102[r104];     // Catch: NoSuchAlgorithmException -> L12
        char[] r106 = f245059a;     // Catch: NoSuchAlgorithmException -> L12
        r103.append(r106[(r105 & 240) >> 4]);     // Catch: NoSuchAlgorithmException -> L12
        r103.append(r106[r105 & 15]);     // Catch: NoSuchAlgorithmException -> L12
        r104 = r104 + 1;     // Catch: NoSuchAlgorithmException -> L12
        goto L8
    L10:
        return r103.toString();
    L12:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
