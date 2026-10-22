package com.bytedance.ee.bear.drive.services;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.CipherManager;
import h85.g1;
import io.reactivex.Flowable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class i implements c {
    public final com.ss.android.lark.passportc.api.m a;

    public final UserSession c() {
        return this.a.getSession();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean h1() {
        tt5.a.h("DRIVE_CACHE_FLOW", "removeCleanableCache. ");
        UserSession r1 = c();
        d5(0);
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.j(), r1));     // Catch: Exception -> L22
        VFSPath r3 = z75.b.h(com.bytedance.ee.bear.drive.cache.t.f(), r1);     // Catch: Exception -> L22
        if (r3 == null) goto L19;
        VFSFile r4 = r3.toFile();     // Catch: Exception -> L22
        if (r4 == null) goto L19;
        if (r4.exists() == false) goto L19;
        if (r4.isDirectory() == false) goto L19;
        File[] r5 = r4.listFiles();     // Catch: Exception -> L22
        int r6 = r5.length;     // Catch: Exception -> L22
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L19;
        File r8 = r5[r7];     // Catch: Exception -> L22
        if (r8.getPath().endsWith(".drivedownload") == false) goto L18;
        r8.delete();     // Catch: Exception -> L22
    L18:
        r7 = r7 + 1;     // Catch: Exception -> L22
    L19:
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.k(), r1));     // Catch: Exception -> L22
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.g(), r1));     // Catch: Exception -> L22
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.h(), r1));     // Catch: Exception -> L22
        return true;
    L22:
        e = move-exception;
        tt5.a.i("DRIVE_CACHE_FLOW", "removeCleanableCache fail. ", e);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long l2() {
        long r2 = b().b0();     // Catch: Exception -> L5
        long r4 = i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.j(), c()));     // Catch: Exception -> L5
        long r6 = i75.l.a(z75.b.h(com.bytedance.ee.bear.drive.cache.t.f(), c()));     // Catch: Exception -> L5
        long r8 = i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.k(), c()));     // Catch: Exception -> L5
        long r3 = ((((r2 + r4) + r6) + r8) + i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.g(), c()))) + i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.h(), c()));     // Catch: Exception -> L5
        tt5.a.h("DRIVE_CACHE_FLOW", "getCleanableCacheSize. total = " + r3);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "getCleanableCacheSize failed!", e, false);
        return 0;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean removeAll() {
        tt5.a.h("DRIVE_CACHE_FLOW", "removeAll start");     // Catch: Exception -> L10
        UserSession r1 = c();     // Catch: Exception -> L10
        Application r2 = eu5.b.a;     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.f(), r1));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.j(), r1));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.k(), r1));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.g(), r1));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.h(), r1));     // Catch: Exception -> L10
        List<DriveCache> r3 = X2(r1);     // Catch: Exception -> L10
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L10
        Iterator r5 = ((ArrayList) r3).iterator();     // Catch: Exception -> L10
    L5:
        if (r5.hasNext() == false) goto L7;
        r4.add(((DriveCache) r5.next()).k);     // Catch: Exception -> L10
        goto L5
    L7:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).i6(r4);     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);
        return false;
    }

    public static com.bytedance.ee.bear.drive.dao.a b() {
        return com.bytedance.ee.bear.drive.dao.c.c().a();
    }

    @Inject
    public i(com.ss.android.lark.passportc.api.m r8) {
        this.a = null;
        this.a = r8;
        long r0 = SystemClock.uptimeMillis();
        Application r2 = eu5.b.a;
        int r3 = ay4.c.a;
        VFSPath r4 = ay4.d.a().B(LarkContext.getApplication().getFilesDir()).getVfsPath();
        if (r4 == null) goto L8;
        VFSFile r5 = r4.toFile();
        if (r5 == null) goto L8;
        tt5.a.h("DRIVE_CACHE_FLOW", "init() formatDeviceTotalSpace=" + com.bytedance.ee.util.io.a.e(r5.getTotalSpace()));
    L15:
        UserSession r9 = r8.getSession();     // Catch: Exception -> L11
        DriveFilePath r6 = com.bytedance.ee.bear.drive.cache.t.j();     // Catch: Exception -> L11
        int r7 = a.a;     // Catch: Exception -> L11
        a.C0168a.a(z75.b.g(r6, r9));     // Catch: Exception -> L11
        a.C0168a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.f(), r9));     // Catch: Exception -> L11
        a.C0168a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.k(), r9));     // Catch: Exception -> L11
        a.C0168a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.g(), r9));     // Catch: Exception -> L11
        a.C0168a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.h(), r9));     // Catch: Exception -> L11
    L13:
        Flowable.just("").observeOn(fo5.d.b()).map(new d(this)).map(new e(this)).map(new f()).map(new g(this)).subscribe(new g1(), new h());
        tt5.a.h("DRIVE_CACHE_FLOW", "lazyInit timeCost=" + (SystemClock.uptimeMillis() - r0));
        return;
    L11:
        e = move-exception;
        tt5.a.d("DRIVE_CACHE_FLOW", "initCipher fail. " + e);
    L8:
        tt5.a.d("DRIVE_CACHE_FLOW", "init() internalFile null");
        goto L15
    }

    public static DriveCache a(y75.a r5) {
        DriveCache r0 = new DriveCache();
        r0.e = r5.e;
        r0.d = r5.d;
        r0.a = r5.a;
        r0.f = r5.f;
        r0.g = r5.g;
        r0.h = r5.c;
        r0.b = r5.a();
        DriveFilePath.a r1 = DriveFilePath.Companion;
        String r2 = r5.j;
        r1.getClass();
        r0.c = DriveFilePath.a.b(r2);
        r0.j = r5.o;
        r0.k = r5.b;
        r0.i = r5.getType();
        r0.l = r5.n;
        r0.m = r5.r;
        r0.n = r5.t;
        r0.o = r5.v;
        r0.p = r5.u;
        r0.q = r5.x;
        int r3 = r5.w;
        boolean r4 = true;
        if ((r3 & 2) == 0) goto L5;
        boolean r6 = true;
    L6:
        r0.r = r6;
        if ((r3 & 4) != 0) goto L10;
        r4 = false;
    L10:
        r0.s = r4;
        r0.t = r5.y;
        return r0;
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean B9(List<String> r3) {
        tt5.a.h("DRIVE_CACHE_FLOW", "removeList");
        List<y75.a> r4 = b().d0(r3);
        if (hu5.a.d(r4) == false) goto L6;
        return false;
    L6:
        Iterator<y75.a> r5 = r4.iterator();
        boolean r0 = true;
    L8:
        if (r5.hasNext() == false) goto L10;
        r0 = r0 & e(r5.next());
        goto L8
    L10:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean S(String r5) {
        tt5.a.h("DRIVE_CACHE_FLOW", "deleteCacheByToken " + du5.b.g(r5));
        List<y75.a> r0 = b().Y(r5);
        int r6 = b().S(r5);
        boolean r2 = true;
        if (r0 != null) goto L5;
        return true;
    L5:
        Iterator<y75.a> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r2 = r2 & e(r1.next());
        goto L7
    L9:
        tt5.a.h("DRIVE_CACHE_FLOW", "deleteCacheByToken ret: " + r6 + "  result: " + r2);
        return r2;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Va(long r6) {
        List r0 = b().U(r6);
        if (r0 == null) goto L18;
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        y75.a r3 = (y75.a) r2.next();
        if (e(r3) == false) goto L7;
        long r4 = r3.k;
        goto L7
    L11:
        tt5.a.h("DRIVE_CACHE_FLOW", "cleanCacheByTypeAndTime, type=0, beforeTimeInMills = " + r6 + ", size=" + r0.size());
    L18:
        tt5.a.h("DRIVE_CACHE_FLOW", "clean all drive cache by time start.. beforeTimeInMills = " + r6);     // Catch: Exception -> L15
        UserSession r1 = c();     // Catch: Exception -> L15
        i75.l.g(r6, z75.b.h(com.bytedance.ee.bear.drive.cache.t.j(), r1));     // Catch: Exception -> L15
        i75.l.d(r6, z75.b.h(com.bytedance.ee.bear.drive.cache.t.f(), r1));     // Catch: Exception -> L15
        i75.l.g(r6, z75.b.h(com.bytedance.ee.bear.drive.cache.t.k(), r1));     // Catch: Exception -> L15
        i75.l.g(r6, z75.b.h(com.bytedance.ee.bear.drive.cache.t.g(), r1));     // Catch: Exception -> L15
        i75.l.g(r6, z75.b.h(com.bytedance.ee.bear.drive.cache.t.h(), r1));     // Catch: Exception -> L15
        tt5.a.h("DRIVE_CACHE_FLOW", "clean all drive cache by time finish");     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "clean all drive cache by time. ", e, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> X2(UserSession r6) {
        tt5.a.h("DRIVE_CACHE_FLOW", "getAll");
        ArrayList r0 = new ArrayList();
        List<y75.a> r1 = b().g0();
        if (r1 == null) goto L11;
        Iterator<y75.a> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        y75.a r3 = r2.next();
        DriveCache r4 = a(r3);
        if (d(r4, r3, r6) == true) goto L9;
        r0.add(r4);
        goto L6
    L9:
        e(r3);
    L11:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long d5(int r7) {
        List<y75.a> r0 = b().c0(r7);
        long r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Iterator<y75.a> r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        y75.a r4 = r3.next();
        if (e(r4) == false) goto L7;
        r1 = r1 + r4.k;
        goto L7
    L11:
        tt5.a.h("DRIVE_CACHE_FLOW", "cleanCacheByType, type=" + r7 + ", size=" + r0.size());
        return r1;
    }

    public final boolean e(y75.a r7) {
        if (r7 != null) goto L19;
        return false;
    L19:
        UserSession r1 = c();     // Catch: Exception -> L11
        i75.l.f(z75.b.e(r7.a(), r1));     // Catch: Exception -> L11
        b().deleteCache(r7.a);     // Catch: Exception -> L11
        DriveFilePath.a r2 = DriveFilePath.Companion;     // Catch: Exception -> L11
        String r3 = r7.j;     // Catch: Exception -> L11
        r2.getClass();     // Catch: Exception -> L11
        i75.l.f(z75.b.e(DriveFilePath.a.b(r3), r1));     // Catch: Exception -> L11
        com.bytedance.ee.bear.drive.dao.d r4 = com.bytedance.ee.bear.drive.dao.c.c().b();     // Catch: Exception -> L11
        com.bytedance.ee.bear.drive.dao.e r5 = (com.bytedance.ee.bear.drive.dao.e) r4;     // Catch: Exception -> L11
        ArrayList r6 = (ArrayList) r5.b(r7.u, r7.b, r7.e);     // Catch: Exception -> L11
        if (r6.size() <= 0) goto L14;
        Iterator r8 = r6.iterator();     // Catch: Exception -> L11
    L9:
        if (r8.hasNext() == false) goto L13;
        y75.b r9 = (y75.b) r8.next();     // Catch: Exception -> L11
        r9.getClass();     // Catch: Exception -> L11
        DriveFilePath.a r10 = DriveFilePath.Companion;     // Catch: Exception -> L11
        String r11 = r9.e;     // Catch: Exception -> L11
        r10.getClass();     // Catch: Exception -> L11
        i75.l.f(z75.b.e(DriveFilePath.a.b(r11), r1));     // Catch: Exception -> L11
        goto L9
    L13:
        com.bytedance.ee.bear.drive.dao.d r12 = com.bytedance.ee.bear.drive.dao.c.c().b();     // Catch: Exception -> L11
        com.bytedance.ee.bear.drive.dao.e r13 = (com.bytedance.ee.bear.drive.dao.e) r12;     // Catch: Exception -> L11
        r13.a(r7.u, r7.b, r7.e);     // Catch: Exception -> L11
    L14:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).F8("DriveDataService-remove", r7.b);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "remove cache -> delete file failed, ", e, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List o2(int r6) {
        tt5.a.h("DRIVE_CACHE_FLOW", "getCacheByTypeAndCacheHost, cacheHost = " + r6 + ", type = 0");
        ArrayList r0 = new ArrayList();
        List r7 = b().W(r6);
        if (hu5.a.d(r7) == false) goto L5;
        return r0;
    L5:
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L17;
        y75.a r1 = (y75.a) r8.next();
        DriveCache r2 = a(r1);
        if (z75.b.d(r2.b, c()) == true) goto L16;
        boolean r4 = true;
        if ((r1.w & 1) == 1) goto L14;
        r4 = false;
    L14:
        if (r4 == true) goto L16;
        e(r1);
    L16:
        r0.add(r2);
        goto L7
    L17:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean remove(String r2) {
        return e(b().e0(r2));
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean y9(String r10) {
        List<y75.a> r0 = b().Y(r10);
        if (r0 != null) goto L5;
        return false;
    L5:
        UserSession r2 = c();
        Iterator<y75.a> r1 = r0.iterator();
        boolean r3 = false;
    L7:
        if (r1.hasNext() == false) goto L37;
        y75.a r4 = r1.next();
        VFSFile r5 = z75.b.e(r4.a(), r2);
        if (r5.exists() == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L15;
        DriveFilePath.a r7 = DriveFilePath.Companion;
        String r8 = r4.j;
        r7.getClass();
        VFSFile r9 = z75.b.e(DriveFilePath.a.b(r8), r2);
        if (r9.exists() == true) goto L19;
    L21:
        r6 = false;
    L22:
        if (r6 == true) goto L15;
        ArrayList r11 = (ArrayList) ((com.bytedance.ee.bear.drive.dao.e) com.bytedance.ee.bear.drive.dao.c.c().b()).b(r4.u, r4.b, r4.e);
        if (r11.size() <= 0) goto L36;
        Iterator r12 = r11.iterator();
    L28:
        if (r12.hasNext() == false) goto L36;
        y75.b r13 = (y75.b) r12.next();
        r13.getClass();
        DriveFilePath.a r14 = DriveFilePath.Companion;
        String r16 = r13.e;
        r14.getClass();
        VFSFile r17 = z75.b.e(DriveFilePath.a.b(r16), r2);
        if (r17.exists() == true) goto L32;
    L34:
        r6 = false;
    L35:
        if (r6 == false) goto L28;
    L32:
        if (r17.isFile() == false) goto L34;
        r6 = true;
    L36:
        r3 = r6;
        goto L7
    L19:
        if (r9.isFile() == false) goto L21;
        r6 = true;
    L15:
        r3 = r6;
        goto L37
    L11:
        if (r5.isFile() == false) goto L13;
        r6 = true;
    L37:
        tt5.a.h("DRIVE_CACHE_FLOW", "hasCacheByToken " + du5.b.g(r10) + "  result : " + r3);
        return r3;
    }

    public static DriveFilePath f(DriveFilePath r3, UserSession r4) {
        if (z75.b.d(r3, r4) == true) goto L6;
        tt5.a.b("DRIVE_CACHE_FLOW", "tryDecryptFile... invalid filepath : " + r3);
        return r3;
    L6:
        com.ss.android.lark.vfs.h r0 = ay4.d.a();
        File r5 = r0.r(z75.b.b(r3, r4), true);     // Catch: IOException -> L15
        if (r5 != null) goto L10;
    L17:
        return r3;
    L10:
        if (TextUtils.isEmpty(r5.getAbsolutePath()) == true) goto L17;
        if (r5.exists() == false) goto L17;
        r3.setDecryptPath(r0.t(r5));     // Catch: IOException -> L15
    L15:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "tryDecryptFile... err happens : ", e, false);
        r3.setDecryptPath(null);
        goto L17
    }

    public static DriveFilePath g(DriveFilePath r3, UserSession r4) {
        if (CipherManager.d() == 1) goto L5;
    L12:
        return r3;
    L5:
        if (z75.b.d(r3, r4) == false) goto L12;
        tt5.a.h("DRIVE_CACHE_FLOW", "tryEncryptFile... need encrypt file when it goes to cache");
        tt5.a.b("DRIVE_CACHE_FLOW", "tryEncryptFile... need encrypt file path : " + r3.getRelativePath());
        z75.b.e(r3, r4).afterWriteCompat();     // Catch: Exception -> L10
        tt5.a.h("DRIVE_CACHE_FLOW", "tryEncryptFile... suc encrypt target file ");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        tt5.a.h("DRIVE_CACHE_FLOW", "tryEncryptFile... can not encrypt target file : " + e);
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean H(String r2, String r3) {
        if (b().H(r2, r3) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Re(long r11, long r13) {
        boolean r0 = Va(r11);
        long r1 = b().b0();
        monitor-enter(this);
        tt5.a.h("DRIVE_CACHE_FLOW", "start trim size to max");     // Catch: Throwable -> L24
        int r4 = 0;
    L6:
        if (r1 <= r13) goto L28;
        if (r4 > 100) goto L28;
        r4 = r4 + 1;     // Catch: Throwable -> L24
        List r5 = b().a0();     // Catch: Throwable -> L24
        if (hu5.a.d(r5) == true) goto L11;
        tt5.a.h("DRIVE_CACHE_FLOW", "cacheModels size=" + r5.size());     // Catch: Throwable -> L24
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L24
    L14:
        if (r6.hasNext() == false) goto L6;
        y75.a r7 = (y75.a) r6.next();     // Catch: Throwable -> L24
        if (r1 <= r13) goto L6;
        UserSession r8 = c();     // Catch: Throwable -> L24 Exception -> L26
        i75.l.f(z75.b.e(r7.a(), r8));     // Catch: Throwable -> L24 Exception -> L26
        DriveFilePath.a r9 = DriveFilePath.Companion;     // Catch: Throwable -> L24 Exception -> L26
        String r10 = r7.j;     // Catch: Throwable -> L24 Exception -> L26
        r9.getClass();     // Catch: Throwable -> L24 Exception -> L26
        i75.l.f(z75.b.e(DriveFilePath.a.b(r10), r8));     // Catch: Throwable -> L24 Exception -> L26
    L20:
        if (b().deleteCache(r7.a) > 0) goto L21;
        tt5.a.k("DRIVE_CACHE_FLOW", "trim size deleted file failed");     // Catch: Throwable -> L24 Exception -> L26
        goto L14
    L21:
        r1 = r1 - r7.k;     // Catch: Throwable -> L24 Exception -> L26
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).F8("DriveDataService-cleanCacheToSizeInternal", r7.b);     // Catch: Throwable -> L24 Exception -> L26
    L26:
        e = move-exception;
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);     // Catch: Throwable -> L24
        goto L14
    L11:
        tt5.a.h("DRIVE_CACHE_FLOW", "trim file loop get cache is empty, stop trim");     // Catch: Throwable -> L24
    L28:
        tt5.a.h("DRIVE_CACHE_FLOW", "trim cache finish, target size = " + r13 + ", current size = " + r1);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        tt5.a.h("DRIVE_CACHE_FLOW", "clearUpTimeMills, upTimeMills: " + r11 + ", maxSizeBytes: " + r13 + ", cleanCacheByTimeRes: " + r0 + ", cleanCacheToSizeRes: true");
        return r0;
    L24:
        th = move-exception;
        throw th;
    }

    public static boolean d(DriveCache r1, y75.a r2, UserSession r3) {
        if (r1.s == true) goto L5;
        DriveFilePath r4 = r1.b;
    L7:
        if (z75.b.d(r4, r3) == true) goto L20;
        int r5 = r2.w;
        if ((r5 & 1) != 1) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        return false;
    L14:
        if ((r5 & 2) == 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L22;
        return true;
    L22:
        return false;
    L16:
        r7 = false;
        goto L17
    L11:
        r6 = false;
        goto L12
    L20:
        return false;
    L5:
        r4 = r1.c;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean M9(DriveCache r5, String r6, UserSession r7) {
        if (r5 != null) goto L11;
        return false;
    L11:
        i75.l.f(z75.b.e(r5.b, r7));     // Catch: Exception -> L8
        tt5.a.k("DRIVE_CACHE_FLOW", "updateCacheSourceFromAndFilePath, result=" + b().T(r5.a, r6));     // Catch: Exception -> L8
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).F8("DriveDataService-clearUploadCache", r5.k);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        tt5.a.d("DRIVE_CACHE_FLOW", "clearUploadCache fail: " + e);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final DriveCache Zc(String r6, boolean r7, UserSession r8) {
        y75.a r0 = b().e0(r6);
        if (r0 == null) goto L11;
        DriveCache r2 = a(r0);
        DriveFilePath r3 = r0.a();
        f(r3, r8);
        r2.b = r3;
        DriveFilePath.a r4 = DriveFilePath.Companion;
        String r5 = r0.j;
        r4.getClass();
        DriveFilePath r9 = DriveFilePath.a.b(r5);
        f(r9, r8);
        r2.c = r9;
        if (d(r2, r0, r8) == false) goto L8;
        tt5.a.k("DRIVE_CACHE_FLOW", "get drive cache from db success, but file not exists, remove it");
        e(r0);
        return null;
    L8:
        if (r7 == false) goto L10;
        b().f0(r6, System.currentTimeMillis());
    L10:
        return r2;
    L11:
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> K4(long r3, String r5, String r6, UserSession r7) {
        tt5.a.h("DRIVE_CACHE_FLOW", "getSpaceFileManualCacheByTypeBeforeModTime beforeTime=" + r3 + ", uid = " + r5 + ", tenantId = " + r6);
        ArrayList r0 = new ArrayList();
        List r4 = b().Z(r3, r5, r6);
        if (hu5.a.d(r4) == false) goto L5;
        return r0;
    L5:
        Iterator r8 = r4.iterator();
    L7:
        if (r8.hasNext() == false) goto L17;
        y75.a r9 = (y75.a) r8.next();
        DriveCache r10 = a(r9);
        if (z75.b.d(r10.b, r7) == true) goto L16;
        boolean r1 = true;
        if ((r9.w & 1) == 1) goto L14;
        r1 = false;
    L14:
        if (r1 == true) goto L16;
        e(r9);
    L16:
        r0.add(r10);
        goto L7
    L17:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean T5(String r7, int r8, int r9, UserSession r10) {
        tt5.a.h("DRIVE_CACHE_FLOW", "convertCacheType() st=" + r8 + " tt=" + r9);
        if (r8 != r9) goto L5;
        return true;
    L5:
        DriveFilePath r11 = i75.f.a(r8);
        VFSFile r2 = z75.b.e(r11.cacheName(r7), r10);
        VFSPath r12 = z75.b.b(r11, r10);
        DriveFilePath r3 = i75.f.a(r9);
        VFSFile r4 = z75.b.e(r3.cacheName(r7), r10);
        VFSPath r13 = z75.b.b(r3, r10);
        if (r2.exists() == true) goto L23;
        tt5.a.k("DRIVE_CACHE_FLOW", "convertCacheType, but source file not exists");
    L23:
    L15:
        e = move-exception;
        FileUtils.m(r13);     // Catch: Exception -> L18
    L19:
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);
    L20:
        return false;
    L18:
        tt5.a.e("DRIVE_CACHE_FLOW", "convertCacheType() delete target file", e, false);
        goto L19
    L10:
        if (r2.getParent().equals(r4.getParent()) == true) goto L12;
        FileUtils.j(r12, r13);     // Catch: Exception -> L15
        FileUtils.m(r12);     // Catch: Exception -> L15
    L12:
        com.bytedance.ee.bear.drive.dao.a r14 = b();     // Catch: Exception -> L15
        DriveFilePath.Companion.getClass();     // Catch: Exception -> L15
        if (r14.V(r7, r9, DriveFilePath.a.c(r3)) <= 0) goto L20;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v6 */
    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean p1(v85.a r11, String r12, String r13, UserSession r14) {
        DriveFilePath r0 = r11.f;
        DriveFilePath r1 = r11.g;
        y75.a r2 = new y75.a();
        boolean r3 = z75.b.d(r0, r14);
        boolean r4 = z75.b.d(r1, r14);
        if (r3 == true) goto L12;
        if (r4 == true) goto L12;
        if (r11.q == false) goto L9;
    L23:
        r2.t = r11.a;
        r2.a = r11.c;
        r2.b = r11.d;
        r2.l = r11.b;
        r2.c = r11.j;
        r2.d = r11.k;
        r2.f = r11.m;
        r2.g = r11.n;
        r2.e = r11.i;
        r2.r = r11.l;
        long r5 = System.currentTimeMillis();
        r2.m = r5;
        r2.n = r5;
        r2.o = r11.e;
        r2.p = r12;
        r2.q = r13;
        r2.u = r11.s;
        r2.v = r11.t;
        r2.x = r11.h;
        r2.y = r11.r;
        boolean r16 = r11.q;
        ?? r17 = r16;
        if (r11.o == false) goto L26;
        r17 = (r16 ? 1 : 0) | 2;
    L26:
        int r18 = r17;
        if (r11.p == false) goto L29;
        r18 = (r17 == true ? 1 : 0) | 4;
    L29:
        r2.w = r18;
        if (b().X(r2) <= 0) goto L32;
        boolean r19 = true;
    L34:
        if (r11.o == false) goto L38;
        if (r3 == true) goto L38;
        tt5.a.h("DRIVE_CACHE_FLOW", "addDriveCache done, current is weboffice, ignore check. result=" + r19);
        return r19;
    L38:
        if (r19 == false) goto L43;
        String r110 = r11.d;
        if (r110 != null) goto L42;
        tt5.a.d("DRIVE_CACHE_FLOW", "put, cacheEntity.fileId is null.");
    L50:
        return r19;
    L42:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).J6(r110);
        goto L50
    L43:
        tt5.a.d("DRIVE_CACHE_FLOW", "add cache record to db failed");
        DriveFilePath r111 = r2.a();     // Catch: Exception -> L48
        if (r111.isEmpty() == true) goto L50;
        i75.l.f(z75.b.e(r111, r14));     // Catch: Exception -> L48
    L48:
        e = move-exception;
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);
        goto L50
    L32:
        r19 = false;
        goto L34
    L9:
        if (r11.o == true) goto L23;
        tt5.a.d("DRIVE_CACHE_FLOW", "put cache but file not exists.");
        return false;
    L12:
        VFSFile r7 = z75.b.f(i75.f.a(r11.b), r14);
        if (r7.exists() == true) goto L15;
        tt5.a.h("DRIVE_CACHE_FLOW", "cache dir not exists, create it, " + r7.mkdirs());
    L15:
        if (r3 == false) goto L17;
        g(r0, r14);
    L17:
        if (r4 == false) goto L19;
        g(r1, r14);
    L19:
        if (r3 == false) goto L21;
        VFSFile r6 = z75.b.e(r0, r14);
    L22:
        r2.k = r6.length();
        DriveFilePath.Companion.getClass();
        r2.h = DriveFilePath.a.c(r0);
        r2.j = DriveFilePath.a.c(r1);
        goto L23
    L21:
        r6 = z75.b.e(r1, r14);
        goto L22
    }
}
