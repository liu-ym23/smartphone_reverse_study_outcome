package oo7;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f524621a = null;

    static {
        f524621a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static int a(String r100, String r110) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L29:
        return 0;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L29;
        String r101 = String.format("%s_%s", new Object[]{r100, r110});
        if (r101 != null) goto L31;
    L23:
        String r102 = null;
    L25:
        if (TextUtils.isEmpty(r102) == false) goto L28;
        return 0;
    L28:
        return r102.hashCode();
    L31:
        if (r101.length() == 0) goto L23;
        MessageDigest r111 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L30
        r111.update(r101.getBytes("UTF-8"));     // Catch: Exception -> L30
        byte[] r103 = r111.digest();     // Catch: Exception -> L30
        if (r103 == null) goto L23;
        int r112 = r103.length;     // Catch: Exception -> L30
        if ((r112 + 0) > r103.length) goto L23;
        int r104 = r112 * 2;     // Catch: Exception -> L30
        char[] r105 = new char[r104];     // Catch: Exception -> L30
        int r106 = 0;
        int r107 = 0;
    L19:
        if (r106 >= r112) goto L21;
        int r108 = r103[r106 + 0] & UByte.MAX_VALUE;     // Catch: Exception -> L30
        int r109 = r107 + 1;     // Catch: Exception -> L30
        char[] r113 = f524621a;     // Catch: Exception -> L30
        r105[r107] = r113[r108 >> 4];     // Catch: Exception -> L30
        r107 = r109 + 1;     // Catch: Exception -> L30
        r105[r109] = r113[r108 & 15];     // Catch: Exception -> L30
        r106 = r106 + 1;     // Catch: Exception -> L30
        goto L19
    L21:
        r102 = new String(r105, 0, r104);     // Catch: Exception -> L30
        goto L25
    }
}
