package znc;

import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.io.NoSuchFileException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final znc.e f573055a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PolarisFileWrapper f573056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PolarisFileWrapper f573057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f573058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f573059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f573060e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public znc.b f573061f;

        public a() {
            this.f573058c = 1;
            this.f573059d = 1;
            this.f573060e = 52428800;
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "directory");
            this.f573056a = new PolarisFileWrapper(r100);
        }
    }

    public interface b {
        OutputStream newOutputStream() throws IOException;
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final znc.e.c f573062a;

        public final OutputStream a() {
            return this.f573062a.c();
        }

        @Override // znc.m.b
        public final OutputStream newOutputStream() throws IOException {
            return a();
        }

        public c(znc.e.c r100) {
            Intrinsics.checkNotNullParameter(r100, "editor");
            this.f573062a = r100;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final znc.e.C8478e f573063a;

        public final InputStream b() {
            znc.e.C8478e r100 = this.f573063a;
            return r100.f573044b.f573021f.j(r100.f573043a[0]);
        }

        public d(znc.e.C8478e r100) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            this.f573063a = r100;
        }

        public final File a(int r100) {
            znc.e.C8478e r101 = this.f573063a;
            File r102 = r101.f573044b.f573021f.b(r101.f573043a[r100]);
            this.f573063a.getClass();
            Intrinsics.checkNotNull(r102);
            return r102;
        }
    }

    public static final class e {
    }

    static {
    }

    @Override // znc.h
    public final String b() {
        return this.f573055a.f573016a.getAbsolutePath();
    }

    @Override // znc.h
    public void delete() {
        this.f573055a.delete();
        Log.i("UniDiskLruCache", "cache: " + f() + " deleted");
    }

    public final String f() {
        znc.e r100 = this.f573055a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.f573016a.getAbsolutePath();
    }

    @Override // znc.h
    public final void flush() {
        znc.e r100 = this.f573055a;
        monitor-enter(r100);
        r100.b();     // Catch: Throwable -> L7
        r100.n();     // Catch: Throwable -> L7
        r100.f573025j.flush();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // znc.h
    public final long size() {
        znc.e r100 = this.f573055a;
        monitor-enter(r100);
        long r101 = r100.f573024i;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public m(a r110) {
        PolarisFileWrapper r100 = r110.f573057b;
        PolarisFileWrapper r101 = r110.f573056a;
        Intrinsics.checkNotNull(r101);
        if (r100 != null) goto L6;
    L40:
        PolarisFileWrapper r102 = r110.f573056a;
        Intrinsics.checkNotNull(r102);
        this.f573055a = znc.e.g(r102, r110.f573058c, r110.f573059d, r110.f573060e, r110.f573061f);
        return;
    L6:
        if (r100.exists() == false) goto L40;
        if (r100.isDirectory() == false) goto L40;
        File[] r103 = r100.listFiles();
        boolean r104 = true;
        if (r103 != null) goto L12;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == true) goto L40;
        if (r101.exists() == true) goto L24;
    L42:
        long r106 = SystemClock.elapsedRealtime();     // Catch: IOException -> L38
        r101.deleteOnExit();     // Catch: IOException -> L38
        n.c(r100, r101);     // Catch: IOException -> L38
        Log.i("UniDiskLruCache", "diskcache migration to " + r101 + " cost: " + (SystemClock.elapsedRealtime() - r106));     // Catch: IOException -> L38
    L38:
        e = move-exception;
        Log.e("UniDiskLruCache", "migration failed, " + e.getMessage());
        goto L40
    L24:
        if (r101.isDirectory() == false) goto L40;
        File[] r107 = r101.listFiles();
        if (r107 != null) goto L28;
    L34:
        if (r104 == true) goto L42;
    L28:
        if (r107.length != 0) goto L30;
        boolean r108 = true;
    L31:
        if (r108 == true) goto L34;
        r104 = false;
        goto L34
    L30:
        r108 = false;
        goto L31
    L12:
        if (r103.length != 0) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == true) goto L18;
        r105 = false;
        goto L19
    L14:
        r109 = false;
        goto L15
    }

    @Override // znc.h
    public final File a(String r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "key");
        return e(r100);
    }

    public final File e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (File) c(r100, new f());
    }

    @Override // znc.h
    public final boolean remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Log.i("UniDiskLruCache", "cache: " + f() + " remove: " + r100);
        return this.f573055a.l(r100);
    }

    @Override // znc.h
    public final <T, R extends znc.c<? extends T>> T c(String r100, R r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "reader");
        znc.e.C8478e r102 = this.f573055a.e(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (T) r101.a(new d(r102));
    }

    @Override // znc.h
    public final void d(String r100, znc.d r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "writer");
        znc.e.c r102 = this.f573055a.d(r100);
        if (r102 != null) goto L18;
        Log.e("UniDiskLruCache", "cache: " + f() + " get editor failed: " + r100);
        return;
    L18:
        if (r101.a(new c(r102)) == false) goto L7;
        r102.b();
        return;
    L7:
        r102.a();
        Log.e("UniDiskLruCache", "cache: " + f() + ", write failed: " + r100);
        return;
    L8:
        th = move-exception;
        r102.a();
        if ((th instanceof FileNotFoundException) == false) goto L12;
    L15:
        Log.e("UniDiskLruCache", "cache: " + f() + ", write failed: " + r100, th);
        return;
    L12:
        if ((th instanceof NoSuchFileException) == true) goto L15;
        Log.e("UniDiskLruCache", "cache: " + f() + ", write failed: " + r100, th, true);
    }
}
