package dh4;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;

/* JADX INFO: loaded from: classes15.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f468606b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f468607c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f468608a;

    static {
        f468606b = new char[]{OthersPermission.STICKY_E, Permission.READ, 'u', 'e'};
        f468607c = new char[]{'f', 'a', Symlink.UNIX_ID, 's', 'e'};
    }

    public final void g() {
        this.f468608a.f();
    }

    public i(String r100) {
        a r101 = new b(r100);     // Catch: Throwable -> L5
    L6:
        this.f468608a = r101;
        return;
    L5:
        r101 = new c(r100);
        goto L6
    }

    public final void a(char r100) {
        this.f468608a.a(r100);
    }

    public final void b(int r100) {
        this.f468608a.b(r100);
    }

    public final void c(long r100) {
        this.f468608a.c(r100);
    }

    public final void d(String r100) {
        if (r100 == null) goto L5;
        this.f468608a.d(r100);
        return;
    }

    public final void e(Throwable r100) {
        d(r100.getClass().getName());
        String r101 = r100.getLocalizedMessage();
        if (r101 == null) goto L6;
        this.f468608a.a(':');
        this.f468608a.a(' ');
        d(r101);
        return;
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L4;
        this.f468608a.e(f468606b);
        return;
    L4:
        this.f468608a.e(f468607c);
    }
}
