package jrb;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L14;
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 2];
        int r103 = r100.length;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r104 >= r103) goto L10;
        int r106 = r105 + 1;
        byte r107 = r100[r104];
        r102[r105] = r101[(r107 >>> 4) & 15];
        r105 = r106 + 1;
        r102[r106] = r101[r107 & 15];
        r104 = r104 + 1;
        goto L7
    L10:
        return new String(r102);
    L14:
        return "";
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String r101 = r100 + "42b91e";
        if (TextUtils.isEmpty(r101) == false) goto L20;
    L7:
        String r102 = "";
    L12:
        String r103 = "08a441".concat(r102);
        if (TextUtils.isEmpty(r103) == true) goto L24;
        MessageDigest r104 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L17
        r104.update(r103.getBytes(Charset.forName("UTF-8")));     // Catch: Exception -> L17
        return a(r104.digest());
    L17:
        e = move-exception;
        e.printStackTrace();
        return "";
    L24:
        return "";
    L20:
        r102 = a(MessageDigest.getInstance("MD5").digest(r101.getBytes(Charset.forName("UTF-8"))));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
