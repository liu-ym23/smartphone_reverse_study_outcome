package w28;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f558042a = null;

    static {
        f558042a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static char[] a(byte[] r100) {
        char[] r101 = f558042a;
        int r102 = r100.length;
        char[] r103 = new char[r102 << 1];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L5;
        int r106 = r105 + 1;
        byte r107 = r100[r104];
        r103[r105] = r101[(r107 & 240) >>> 4];
        r105 = r106 + 1;
        r103[r106] = r101[r107 & 15];
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }
}
