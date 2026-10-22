package com.bytedance.bdp.bdpbase.util;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public static final int a(String r100) {
        int r101 = 0;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        char[] r102 = r100.toCharArray();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r101 >= r103) goto L12;
        if (b(r102[r101]) == false) goto L10;
        int r105 = 2;
    L11:
        r104 = r104 + r105;
        r101 = r101 + 1;
        goto L6
    L10:
        r105 = 1;
        goto L11
    L12:
        return r104;
    }

    public static final boolean b(char r100) {
        Character.UnicodeBlock r101 = Character.UnicodeBlock.of(r100);
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r101 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r101 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r101 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r101 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r101 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static String c(String r100) {
        if (r100 != null) goto L18;
    L16:
        return null;
    L18:
        if (r100.length() == 0) goto L16;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L17
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L17
        byte[] r102 = r101.digest();     // Catch: Exception -> L17
        char[] r103 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};     // Catch: Exception -> L17
        char[] r104 = new char[r102.length * 2];     // Catch: Exception -> L17
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r105 >= r102.length) goto L14;
        int r107 = r102[r105];     // Catch: Exception -> L17
        if (r107 >= 0) goto L13;
        r107 = r107 + 256;     // Catch: Exception -> L17
    L13:
        int r108 = r106 + 1;     // Catch: Exception -> L17
        r104[r106] = r103[r107 >>> 4];     // Catch: Exception -> L17
        r106 = r108 + 1;     // Catch: Exception -> L17
        r104[r108] = r103[r107 & 15];     // Catch: Exception -> L17
        r105 = r105 + 1;     // Catch: Exception -> L17
        goto L9
    L14:
        return new String(r104);
    }
}
