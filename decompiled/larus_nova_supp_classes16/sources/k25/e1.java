package k25;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e1 {
    public final String a;
    public final String b;
    public final c c;
    public final boolean d;
    public final boolean e;
    public final ReadWriteLock f;

    public final void a(List<c1> r3) {
        if (com.larksuite.framework.utils.q.a(r3) == false) goto L5;
        return;
    L5:
        Iterator r4 = ((ArrayList) r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        c1 r0 = (c1) r4.next();
        if (r0 == null) goto L7;
        if (TextUtils.isEmpty(r0.a) == true) goto L7;
        b(ay4.d.a().z(r0.a));
        goto L7
    }

    public final void b(VFSPath r3) {
        ((ReentrantReadWriteLock) this.f).writeLock().lock();     // Catch: Throwable -> L4 Exception -> L6
        FileUtils.m(r3);     // Catch: Throwable -> L4 Exception -> L6
    L3:
        ((ReentrantReadWriteLock) this.f).writeLock().unlock();
        return;
    L6:
        e = move-exception;
        tt5.a.l("ResourceDataPackHelper", "deleteFile:", e);     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f).writeLock().unlock();
        throw th;
    }

    public final void c(List<c1> r7) {
        VFSFile r0 = ay4.d.a().i(this.b);
        if (r0.isDirectory() == false) goto L14;
        File[] r1 = r0.listFiles();
        if (r1 == null) goto L14;
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        File r4 = r1[r3];
        if (r4.getName().endsWith(".temp") == false) goto L13;
        b(r4.getVfsPath());
    L13:
        r3 = r3 + 1;
    L14:
        a(r7);
    }

    @Nullable
    public final String e(String r4) {
        VFSPath r5 = ay4.d.a().z(r4);
        ((ReentrantReadWriteLock) this.f).readLock().lock();     // Catch: Exception -> L5 Throwable -> L7
        byte[] r6 = FileUtils.o(r5);     // Catch: Exception -> L5 Throwable -> L7
        ((ReentrantReadWriteLock) this.f).readLock().unlock();
    L11:
        if (r6 != null) goto L13;
        tt5.a.k("ResourceDataPackHelper", "fileToByte failed");
        return null;
    L13:
        if (this.d == false) goto L19;
        c r0 = this.c;
        r0.getClass();
        if (r6.length == 0) goto L28;
        System.currentTimeMillis();
        return du5.a.a(r6, r0.a);
    L28:
        return null;
    L19:
        return new String(r6);
    L7:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f).readLock().unlock();
        throw th;
    L5:
        e = move-exception;
        tt5.a.l("ResourceDataPackHelper", "unPackResourceData:", e);     // Catch: Throwable -> L7
        ((ReentrantReadWriteLock) this.f).readLock().unlock();
        r6 = null;
        goto L11
    }

    public final m0 g(m0 r4) {
        if (r4 != null) goto L5;
        return r4;
    L5:
        if (TextUtils.isEmpty(r4.d) == true) goto L13;
        String r0 = e(r4.d);
        if (r0 == null) goto L10;
        r4.c = r0;
        return r4;
    L10:
        return null;
    L13:
        if (this.d == true) goto L15;
    L20:
        return r4;
    L15:
        if (this.e == false) goto L20;
        c r1 = this.c;
        r1.getClass();
        if (TextUtils.isEmpty(r4.c) == true) goto L20;
        System.currentTimeMillis();
        String r2 = r4.c;
        SecretKey r3 = r1.a;
        r4.c = du5.a.a(Base64.decode(r2, 0), r3);
        goto L20
    }

    public e1(char[] r5, boolean r6) {
        this.f = new ReentrantReadWriteLock();
        if (eu5.g.i() == false) goto L5;
        this.a = "_p0";
    L6:
        Biz r0 = Biz.DOCS;
        int r1 = ay4.c.a;
        VFSFile r2 = ay4.c.a.e(r0, "offlineDocData", false, true).toFile();
        if (r2.isDirectory() == true) goto L10;
        r2.delete();
    L10:
        if (r2.exists() == true) goto L12;
        r2.mkdirs();
    L12:
        this.b = r2.getAbsolutePath();
        this.c = new c(r5);
        this.e = r6;
        this.d = ((Boolean) new ml5.b("debug_config").a("offline_encrypt", Boolean.TRUE)).booleanValue();
        return;
    L5:
        this.a = eu5.g.a("");
        goto L6
    }

    public final void d(String r2, long r3) {
        e0 r0 = e0.m();
        r0.getClass();
        List<c1> r4 = r0.q().e().k(r2, r3);     // Catch: Exception -> L5
    L8:
        if (com.larksuite.framework.utils.q.a(r4) == false) goto L10;
        return;
    L10:
        Iterator<c1> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        c1 r6 = r5.next();
        if (TextUtils.isEmpty(r6.a) == true) goto L12;
        b(ay4.d.a().z(r6.a));
        goto L12
    L16:
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r4 = new ArrayList(1);
        goto L8
    }

    public final m0 f(m0 r11, boolean r12) {
        if (r11 != null) goto L4;
        return r11;
    L4:
        String r0 = r11.c;
        String r1 = r11.d;
        if (TextUtils.isEmpty(r0) == true) goto L45;
        if (r12 == true) goto L8;
    L9:
        tt5.a.b("ResourceDataPackHelper", "over size file ' token:" + r11.k);
        String r13 = r11.b;
        String r5 = r11.k;
        int r6 = r11.p;
        String r7 = r11.t;
        if (TextUtils.isEmpty(r7) == false) goto L12;
        StringBuilder r8 = new StringBuilder();
        r8.append(du5.d.a(r13 + r5 + r6));
        r8.append(this.a);
        String r14 = r8.toString();
    L13:
        VFSPath r9 = ay4.d.a().u(this.b, r14);
        if (this.d == false) goto L22;
        c r10 = this.c;
        r10.getClass();
        if (r0 != null) goto L18;
    L21:
        byte[] r2 = null;
    L56:
        ((ReentrantReadWriteLock) this.f).writeLock().lock();     // Catch: Throwable -> L31 Exception -> L33
        VFSPath r16 = ay4.d.a().u(this.b, r14 + ".temp");     // Catch: Throwable -> L31 Exception -> L33
        boolean r3 = FileUtils.a(r2, r16);     // Catch: Throwable -> L31 Exception -> L33
        if (r3 == true) goto L58;
    L30:
        boolean r17 = false;
    L37:
        ((ReentrantReadWriteLock) this.f).writeLock().unlock();
        if (r17 == false) goto L41;
        r11.d = r9.getRealPath();
        m0 r18 = new m0(r11);
        r18.c = null;
        return r18;
    L41:
        tt5.a.k("ResourceDataPackHelper", "byteToFile failed");
        goto L45
    L58:
        if (r16.toFile().renameTo(r9.toFile()) == false) goto L30;
        r17 = true;
    L28:
        e = e;
    L35:
        tt5.a.l("ResourceDataPackHelper", "packResourceData:", e);     // Catch: Throwable -> L31
        r17 = r3;
    L33:
        e = e;
        r3 = false;
    L31:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f).writeLock().unlock();
        throw th;
    L18:
        if (TextUtils.isEmpty(r0) == true) goto L21;
        System.currentTimeMillis();
        r2 = du5.a.b(r0, r10.a);
        goto L56
    L22:
        r2 = r0.getBytes();
        goto L56
    L12:
        StringBuilder r19 = new StringBuilder();
        r19.append(du5.d.a(r7 + r5 + r6));
        r19.append(OfflineDoc.DASH_DELIMITER);
        r19.append(du5.d.a(r13));
        r19.append(this.a);
        r14 = r19.toString();
        goto L13
    L8:
        if (r0.length() > 1048576) goto L9;
    L45:
        if (TextUtils.isEmpty(r1) == true) goto L47;
        b(ay4.d.a().z(r1));
    L47:
        r11.d = null;
        if (this.d == true) goto L50;
    L55:
        return r11;
    L50:
        if (this.e == false) goto L55;
        c r110 = this.c;
        r110.getClass();
        if (TextUtils.isEmpty(r11.c) == true) goto L55;
        System.currentTimeMillis();
        r11.c = Base64.encodeToString(du5.a.b(r11.c, r110.a), 0);
        goto L55
    }
}
