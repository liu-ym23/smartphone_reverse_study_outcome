package p27;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f527457a = null;

    static {
        f527457a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(byte[] r110) {
        int r100 = r110.length;
        if ((0 + r100) > r110.length) goto L10;
        int r101 = r100 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r100) goto L8;
        int r105 = r110[0 + r103] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = f527457a;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L5
    L8:
        return String.valueOf(r102, 0, r101);
    L10:
        throw new IndexOutOfBoundsException();
    }
}
