package okio.internal;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f524038a = null;

    static {
        f524038a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static final int a(char r100) {
        boolean r101 = false;
        if ('0' <= r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L28;
        char r103 = 'a';
        if ('a' <= r100) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L25;
        r103 = 'A';
        if ('A' <= r100) goto L21;
    L23:
        if (r101 == true) goto L25;
        throw new IllegalArgumentException("Unexpected hex digit: " + r100);
    L21:
        if (r100 >= 'G') goto L23;
        r101 = true;
    L25:
        return (r100 - r103) + 10;
    L13:
        if (r100 >= 'g') goto L15;
        r104 = true;
        goto L16
    L28:
        return r100 - '0';
    L5:
        if (r100 >= ':') goto L7;
        r102 = true;
        goto L8
    }
}
