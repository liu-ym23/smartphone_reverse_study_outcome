package dh4;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f468602b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f468603c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f468604d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f468605a;

    static {
        f468602b = new char[]{'(', 'N', 'a', OthersPermission.STICKY_E, 'i', 'v', 'e', ' ', 'M', 'e', OthersPermission.STICKY_E, 'h', 'o', Directory.UNIX_ID, ')'};
        f468603c = new char[]{'(', Matrix.MATRIX_TYPE_RANDOM_UT, 'n', 'k', 'n', 'o', Permission.WRITE, 'n', ' ', 'S', 'o', 'u', Permission.READ, CharacterDevice.UNIX_ID, 'e', ')'};
        f468604d = new char[]{'(', Matrix.MATRIX_TYPE_RANDOM_UT, 'n', 'k', 'n', 'o', Permission.WRITE, 'n', ' ', 'S', 'o', 'u', Permission.READ, CharacterDevice.UNIX_ID, 'e', ':'};
    }

    public h(i r100) {
        this.f468605a = r100;
    }

    public final void a(char r100) {
        this.f468605a.a(r100);
    }

    public final void b(StackTraceElement r100) {
        String r101 = r100.getClassName();
        String r102 = r100.getMethodName();
        String r103 = r100.getFileName();
        int r104 = r100.getLineNumber();
        boolean r105 = r100.isNativeMethod();
        if (r101.length() == 0) goto L5;
        this.f468605a.d(r101);
    L5:
        this.f468605a.a('.');
        if (r102.length() == 0) goto L8;
        this.f468605a.d(r102);
    L8:
        if (r105 == false) goto L11;
        c(f468602b);
        return;
    L11:
        if (r103 != null) goto L13;
        if (r104 < 0) goto L24;
        c(f468604d);
        this.f468605a.b(r104);
        a(')');
        return;
    L24:
        c(f468603c);
        return;
    L13:
        if (r100.getLineNumber() < 0) goto L18;
        this.f468605a.a('(');
        if (r103.length() == 0) goto L17;
        this.f468605a.d(r103);
    L17:
        this.f468605a.a(':');
        this.f468605a.b(r104);
        a(')');
        return;
    L18:
        this.f468605a.a('(');
        if (r103.length() == 0) goto L21;
        this.f468605a.d(r103);
    L21:
        a(')');
    }

    public final void c(char[] r100) {
        if (r100.length == 0) goto L6;
        this.f468605a.f468608a.e(r100);
        return;
    }
}
