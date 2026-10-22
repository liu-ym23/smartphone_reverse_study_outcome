package dh4;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f468609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f468610b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f468611c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f468612d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f468613e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final char[] f468614f = null;

    static {
        f468609a = new char[]{'C', 'a', 'u', 's', 'e', Directory.UNIX_ID, ' ', BlockDevice.UNIX_ID, 'y', ':', ' '};
        f468610b = new char[]{'S', 'u', NamedPipe.UNIX_ID, NamedPipe.UNIX_ID, Permission.READ, 'e', 's', 's', 'e', Directory.UNIX_ID, ':', ' '};
        f468611c = new char[]{'\t', 'a', OthersPermission.STICKY_E, ' '};
        f468612d = new char[]{'\t', '.', '.', '.', ' '};
        f468613e = new char[]{' ', 'm', 'o', Permission.READ, 'e', '\n'};
        f468614f = new char[]{' ', 's', 'k', 'i', NamedPipe.UNIX_ID, '\n'};
    }

    public static void a(h r100, StackTraceElement[] r101, int r102) {
        char[] r103 = f468611c;
        int r104 = 0;
        if (r102 > 256) goto L5;
    L10:
        if (r104 >= r102) goto L16;
        r100.c(r103);
        r100.b(r101[r104]);
        r100.a('\n');
        r104 = r104 + 1;
        goto L10
    L16:
        return;
    L5:
        if (r104 >= 128) goto L7;
        r100.c(r103);
        r100.b(r101[r104]);
        r100.a('\n');
        r104 = r104 + 1;
        goto L5
    L7:
        r100.c(f468612d);
        r100.f468605a.b(r102 - 256);
        r100.c(f468614f);
        int r105 = r102 + com.alipay.sdk.m.n.a.f25611g;
    L8:
        if (r105 >= r102) goto L12;
        r100.c(r103);
        r100.b(r101[r105]);
        r100.a('\n');
        r105 = r105 + 1;
        goto L8
    }

    public static void b(h r100, char[] r101, int r102, Throwable r103, Throwable r104) {
        StackTraceElement[] r105 = r104.getStackTrace();
        StackTraceElement[] r106 = r103.getStackTrace();
        int r107 = r106.length - 1;
        int r108 = r105.length;
    L3:
        r108 = r108 - 1;
        if (r107 < 0) goto L9;
        if (r108 < 0) goto L9;
        if (r106[r107].equals(r105[r108]) == false) goto L9;
        r107 = r107 - 1;
    L9:
        int r109 = (r106.length - 1) - r107;
        int r110 = 0;
        int r111 = 0;
    L11:
        if (r111 >= r102) goto L13;
        r100.f468605a.a('\t');
        r111 = r111 + 1;
        goto L11
    L13:
        r100.c(r101);
        r100.f468605a.e(r103);
        r100.a('\n');
        a(r100, r106, r106.length - r109);
        if (r109 == 0) goto L19;
        int r112 = 0;
    L16:
        if (r112 >= r102) goto L18;
        r100.f468605a.a('\t');
        r112 = r112 + 1;
        goto L16
    L18:
        r100.c(f468612d);
        r100.f468605a.b(r109);
        r100.c(f468613e);
    L19:
        Throwable[] r113 = r103.getSuppressed();
        int r114 = r113.length;
    L20:
        if (r110 >= r114) goto L22;
        b(r100, f468610b, r102 + 1, r113[r110], r103);
        r110 = r110 + 1;
        goto L20
    L22:
        Throwable r115 = r103.getCause();
        if (r115 == null) goto L32;
        b(r100, f468609a, r102, r115, r103);
        return;
    }
}
