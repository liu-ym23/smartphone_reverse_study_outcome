package du5;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f470056a = null;

    static {
        f470056a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(String r100) {
        if (r100 != null) goto L15;
        return null;
    L15:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L9
        r101.update(r100.getBytes());     // Catch: Exception -> L9
        byte[] r102 = r101.digest();     // Catch: Exception -> L9
        int r103 = r102.length;     // Catch: Exception -> L9
        StringBuilder r104 = new StringBuilder(r103 * 2);     // Catch: Exception -> L9
        int r105 = r103 + 0;     // Catch: Exception -> L9
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L11;
        byte r107 = r102[r106];     // Catch: Exception -> L9
        char[] r108 = f470056a;     // Catch: Exception -> L9
        char r109 = r108[(r107 & 240) >> 4];     // Catch: Exception -> L9
        char r110 = r108[r107 & 15];     // Catch: Exception -> L9
        r104.append(r109);     // Catch: Exception -> L9
        r104.append(r110);     // Catch: Exception -> L9
        r106 = r106 + 1;     // Catch: Exception -> L9
        goto L7
    L11:
        return r104.toString();
    L9:
        e = move-exception;
        tt5.a.f("MD5Utils", e, false);
        return "";
    }
}
