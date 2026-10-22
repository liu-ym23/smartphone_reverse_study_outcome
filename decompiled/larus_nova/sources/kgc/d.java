package kgc;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.ttapkdiffpatch.SoLoadUtils;
import com.ss.android.ttapkdiffpatch.applier.ApplyPatchFailException;
import com.ss.android.ttapkdiffpatch.hdiffpatch.HPatch;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.Iterator;
import java.util.List;
import jgc.e;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements igc.b, gv7.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f503404d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoLoadUtils f503405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f503406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f503407c;

    public d(SoLoadUtils r100, long r101) {
        this.f503405a = r100;
        this.f503406b = 67108864;
        this.f503407c = r101;
    }

    public static void e(List r100, File r101) throws IOException {
        BufferedOutputStream r102 = null;
        InputStream r103 = null;
        BufferedOutputStream r104 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));     // Catch: Throwable -> L24
        Iterator r105 = r100.iterator();     // Catch: Throwable -> L22
    L6:
        if (r105.hasNext() == false) goto L20;
        jv7.b r106 = (jv7.b) r105.next();     // Catch: Throwable -> L22
        if (r106 != null) goto L30;
        InputStream r107 = null;
    L18:
        iv7.b.a(r107);     // Catch: Throwable -> L22
        goto L6
    L30:
        r107 = r106.c();     // Catch: Throwable -> L14
        ev7.a.a(r107, r104);     // Catch: Throwable -> L12
    L12:
        th = th;
        r103 = r107;
    L15:
        iv7.b.a(r103);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L14:
        th = th;
        goto L15
    L20:
        r104.flush();
        iv7.b.a(r104);
        return;
    L22:
        th = th;
        r102 = r104;
    L25:
        if (r102 == null) goto L27;
        r102.flush();
        iv7.b.a(r102);
    L27:
        throw th;
    L24:
        th = th;
        goto L25
    }

    public final File d(List<jv7.b> r100, InputStream r101) throws IOException {
        this.f503405a.a(SoLoadUtils.SharedObject.hpatchz);     // Catch: ApplyPatchFailException -> L4
    L6:
        kv7.a r102 = kv7.a.b();
        File r103 = null;
        File r104 = null;
        BufferedOutputStream r105 = null;
        File r106 = jgc.d.a("hdiffPatchFile");     // Catch: Throwable -> L34
        BufferedOutputStream r107 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r106));     // Catch: Throwable -> L28
        byte[] r108 = new byte[32768];     // Catch: Throwable -> L26
    L11:
        int r109 = r101.read(r108);     // Catch: Throwable -> L26
        if (r109 == (-1)) goto L15;
        r107.write(r108, 0, r109);     // Catch: Throwable -> L26
        goto L11
    L15:
        r107.flush();     // Catch: Throwable -> L32
        e.a(r107);     // Catch: Throwable -> L32
        r104 = c(r100, r106, r102);     // Catch: Throwable -> L18
    L20:
        if (r104 != null) goto L22;
    L23:
        r104 = b(r100, r106, r102);     // Catch: Throwable -> L32
    L24:
        r106.delete();
        return r104;
    L22:
        if (r104.exists() == true) goto L24;
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L32
    L26:
        th = th;
        r105 = r107;
    L29:
        if (r105 == null) goto L31;
        r105.flush();     // Catch: Throwable -> L32
        e.a(r105);     // Catch: Throwable -> L32
    L31:
        throw th;     // Catch: Throwable -> L32
    L28:
        th = th;
    L34:
        th = th;
    L35:
        if (r103 == null) goto L37;
        r103.delete();
    L37:
        throw th;
    L32:
        th = th;
        r103 = r106;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public final File b(List<jv7.b> r100, File r101, kv7.a r102) throws IOException {
        File r103 = null;
        r103 = jgc.d.a("hdiffOldFile");     // Catch: Throwable -> L9
        File r104 = jgc.d.a("hdiffNewFile");     // Catch: Throwable -> L9
        e(r100, r103);     // Catch: Throwable -> L9
        int r105 = HPatch.hpatch(r103.getPath(), r101.getPath(), r104.getPath(), this.f503406b);     // Catch: Throwable -> L9
        if (r105 != 0) goto L8;
        r103.delete();
        r101.delete();
        return r104;
    L8:
        throw new RuntimeException("hpatch return non zero " + r105);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r103 == null) goto L12;
        r103.delete();
    L12:
        r101.delete();
        throw th;
    }

    public final File c(List<jv7.b> r100, File r101, kv7.a r110) throws IOException {
        ByteBuffer[] r111 = null;
        long r102 = 0;
        if (this.f503407c <= 0) goto L13;
        Iterator<jv7.b> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        jv7.b r104 = r103.next();
        if (r104 == null) goto L6;
        r102 = r102 + r104.b();
        goto L6
    L11:
        if (this.f503407c >= r102) goto L13;
        return null;
    L13:
        File r105 = jgc.d.a("hdiffNewFile");
        int r106 = 0;
        int r107 = r100.size();     // Catch: Throwable -> L47
        ByteBuffer[] r108 = new ByteBuffer[r107];     // Catch: Throwable -> L47
        int r109 = r100.size();     // Catch: Throwable -> L45
        int r112 = 0;
    L16:
        if (r112 >= r109) goto L31;
        ByteBuffer r113 = r100.get(r112).a();     // Catch: Throwable -> L45
        if (r113 == null) goto L22;
        r108[r112] = r113;     // Catch: Throwable -> L45
        r112 = r112 + 1;
        goto L16
    L22:
        if (jv7.e.f500563a == false) goto L30;
    L23:
        if (r106 >= r107) goto L30;
        ByteBuffer r114 = r108[r106];
        if ((r114 instanceof MappedByteBuffer) == false) goto L29;
        if (jv7.e.b() == false) goto L29;
        jv7.e.c((MappedByteBuffer) r114);     // Catch: Throwable -> L60
    L29:
        r106 = r106 + 1;
    L30:
        return null;
    L31:
        int r115 = HPatch.hpatch(r108, r101.getPath(), r105.getPath(), this.f503406b);     // Catch: Throwable -> L45
        if (r115 != 0) goto L44;
        if (jv7.e.f500563a == false) goto L42;
    L35:
        if (r106 >= r107) goto L42;
        ByteBuffer r116 = r108[r106];
        if ((r116 instanceof MappedByteBuffer) == false) goto L41;
        if (jv7.e.b() == false) goto L41;
        jv7.e.c((MappedByteBuffer) r116);     // Catch: Throwable -> L61
    L41:
        r106 = r106 + 1;
    L42:
        return r105;
    L44:
        throw new RuntimeException("hpatch return non zero" + r115);     // Catch: Throwable -> L45
    L45:
        th = th;
        r111 = r108;
    L49:
        if (jv7.e.f500563a == false) goto L59;
        if (r111 == null) goto L59;
        int r117 = r111.length;
    L52:
        if (r106 >= r117) goto L59;
        ByteBuffer r118 = r111[r106];
        if ((r118 instanceof MappedByteBuffer) == false) goto L58;
        if (jv7.e.b() == false) goto L58;
        jv7.e.c((MappedByteBuffer) r118);     // Catch: Throwable -> L62
    L58:
        r106 = r106 + 1;
    L59:
        throw th;
    L47:
        th = th;
        goto L49
    }

    @Override // igc.b
    public final int a(String r100, String r101, String r102, ggc.b r103) throws ApplyPatchFailException {
        if (f503404d == true) goto L5;
        this.f503405a.a(SoLoadUtils.SharedObject.hpatchz);
        f503404d = true;
    L5:
        r103.getClass();
        return HPatch.hpatch(r100, r101, r102, this.f503406b);
    }
}
