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

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f224620a;

    public final UserSession c() {
        return this.f224620a.getSession();
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean h1() {
        tt5.a.h("DRIVE_CACHE_FLOW", "removeCleanableCache. ");
        UserSession r100 = c();
        d5(0);
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.j(), r100));     // Catch: Exception -> L22
        VFSPath r101 = z75.b.h(com.bytedance.ee.bear.drive.cache.t.f(), r100);     // Catch: Exception -> L22
        if (r101 == null) goto L19;
        VFSFile r102 = r101.toFile();     // Catch: Exception -> L22
        if (r102 == null) goto L19;
        if (r102.exists() == false) goto L19;
        if (r102.isDirectory() == false) goto L19;
        VFSFile[] r103 = r102.listFiles();     // Catch: Exception -> L22
        int r104 = r103.length;     // Catch: Exception -> L22
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L19;
        VFSFile r106 = r103[r105];     // Catch: Exception -> L22
        if (r106.getPath().endsWith(".drivedownload") == false) goto L18;
        r106.delete();     // Catch: Exception -> L22
    L18:
        r105 = r105 + 1;     // Catch: Exception -> L22
    L19:
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.k(), r100));     // Catch: Exception -> L22
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.g(), r100));     // Catch: Exception -> L22
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.h(), r100));     // Catch: Exception -> L22
        return true;
    L22:
        e = move-exception;
        tt5.a.i("DRIVE_CACHE_FLOW", "removeCleanableCache fail. ", e);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long l2() {
        long r100 = b().b0();     // Catch: Exception -> L5
        long r101 = i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.j(), c()));     // Catch: Exception -> L5
        long r102 = i75.l.a(z75.b.h(com.bytedance.ee.bear.drive.cache.t.f(), c()));     // Catch: Exception -> L5
        long r103 = i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.k(), c()));     // Catch: Exception -> L5
        long r104 = ((((r100 + r101) + r102) + r103) + i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.g(), c()))) + i75.l.b(z75.b.h(com.bytedance.ee.bear.drive.cache.t.h(), c()));     // Catch: Exception -> L5
        tt5.a.h("DRIVE_CACHE_FLOW", "getCleanableCacheSize. total = " + r104);     // Catch: Exception -> L5
        return r104;
    L5:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "getCleanableCacheSize failed!", e, false);
        return 0;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean removeAll() {
        tt5.a.h("DRIVE_CACHE_FLOW", "removeAll start");     // Catch: Exception -> L10
        UserSession r100 = c();     // Catch: Exception -> L10
        Application r101 = eu5.b.f474075a;     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.f(), r100));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.j(), r100));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.k(), r100));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.g(), r100));     // Catch: Exception -> L10
        i75.l.e(z75.b.f(com.bytedance.ee.bear.drive.cache.t.h(), r100));     // Catch: Exception -> L10
        List<DriveCache> r102 = X2(r100);     // Catch: Exception -> L10
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L10
        Iterator r104 = ((ArrayList) r102).iterator();     // Catch: Exception -> L10
    L5:
        if (r104.hasNext() == false) goto L7;
        r103.add(((DriveCache) r104.next()).f216977k);     // Catch: Exception -> L10
        goto L5
    L7:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).i6(r103);     // Catch: Exception -> L10
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
    public i(com.ss.android.lark.passportc.api.m r100) {
        this.f224620a = null;
        this.f224620a = r100;
        long r101 = SystemClock.uptimeMillis();
        Application r102 = eu5.b.f474075a;
        int r103 = ay4.c.f16749a;
        VFSPath r104 = ay4.d.a().B(LarkContext.getApplication().getFilesDir()).getVfsPath();
        if (r104 == null) goto L8;
        VFSFile r105 = r104.toFile();
        if (r105 == null) goto L8;
        tt5.a.h("DRIVE_CACHE_FLOW", "init() formatDeviceTotalSpace=" + com.bytedance.ee.util.io.a.e(r105.getTotalSpace()));
    L15:
        UserSession r106 = r100.getSession();     // Catch: Exception -> L11
        DriveFilePath r107 = com.bytedance.ee.bear.drive.cache.t.j();     // Catch: Exception -> L11
        int r108 = a.f224601a;     // Catch: Exception -> L11
        a.C3224a.a(z75.b.g(r107, r106));     // Catch: Exception -> L11
        a.C3224a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.f(), r106));     // Catch: Exception -> L11
        a.C3224a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.k(), r106));     // Catch: Exception -> L11
        a.C3224a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.g(), r106));     // Catch: Exception -> L11
        a.C3224a.a(z75.b.g(com.bytedance.ee.bear.drive.cache.t.h(), r106));     // Catch: Exception -> L11
    L13:
        Flowable.just("").observeOn(fo5.d.b()).map(new d(this)).map(new e(this)).map(new f()).map(new g(this)).subscribe(new g1(), new h());
        tt5.a.h("DRIVE_CACHE_FLOW", "lazyInit timeCost=" + (SystemClock.uptimeMillis() - r101));
        return;
    L11:
        e = move-exception;
        tt5.a.d("DRIVE_CACHE_FLOW", "initCipher fail. " + e);
    L8:
        tt5.a.d("DRIVE_CACHE_FLOW", "init() internalFile null");
        goto L15
    }

    public static DriveCache a(y75.a r100) {
        DriveCache r101 = new DriveCache();
        r101.f216971e = r100.f566598e;
        r101.f216970d = r100.f566597d;
        r101.f216967a = r100.f566594a;
        r101.f216972f = r100.f566599f;
        r101.f216973g = r100.f566600g;
        r101.f216974h = r100.f566596c;
        r101.f216968b = r100.a();
        DriveFilePath.a r102 = DriveFilePath.Companion;
        String r103 = r100.f566603j;
        r102.getClass();
        r101.f216969c = DriveFilePath.a.b(r103);
        r101.f216976j = r100.f566608o;
        r101.f216977k = r100.f566595b;
        r101.f216975i = r100.getType();
        r101.f216978l = r100.f566607n;
        r101.f216979m = r100.f566611r;
        r101.f216980n = r100.f566613t;
        r101.f216981o = r100.f566615v;
        r101.f216982p = r100.f566614u;
        r101.f216983q = r100.f566617x;
        int r104 = r100.f566616w;
        boolean r105 = true;
        if ((r104 & 2) == 0) goto L5;
        boolean r106 = true;
    L6:
        r101.f216984r = r106;
        if ((r104 & 4) != 0) goto L10;
        r105 = false;
    L10:
        r101.f216985s = r105;
        r101.f216986t = r100.f566618y;
        return r101;
    L5:
        r106 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean B9(List<String> r100) {
        tt5.a.h("DRIVE_CACHE_FLOW", "removeList");
        List<y75.a> r101 = b().d0(r100);
        if (hu5.a.d(r101) == false) goto L6;
        return false;
    L6:
        Iterator<y75.a> r102 = r101.iterator();
        boolean r103 = true;
    L8:
        if (r102.hasNext() == false) goto L10;
        r103 = r103 & e(r102.next());
        goto L8
    L10:
        return r103;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean S(String r100) {
        tt5.a.h("DRIVE_CACHE_FLOW", "deleteCacheByToken " + du5.b.g(r100));
        List<y75.a> r101 = b().Y(r100);
        int r102 = b().S(r100);
        boolean r103 = true;
        if (r101 != null) goto L5;
        return true;
    L5:
        Iterator<y75.a> r104 = r101.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        r103 = r103 & e(r104.next());
        goto L7
    L9:
        tt5.a.h("DRIVE_CACHE_FLOW", "deleteCacheByToken ret: " + r102 + "  result: " + r103);
        return r103;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Va(long r100) {
        List r101 = b().U(r100);
        if (r101 == null) goto L18;
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        y75.a r103 = (y75.a) r102.next();
        if (e(r103) == false) goto L7;
        long r104 = r103.f566604k;
        goto L7
    L11:
        tt5.a.h("DRIVE_CACHE_FLOW", "cleanCacheByTypeAndTime, type=0, beforeTimeInMills = " + r100 + ", size=" + r101.size());
    L18:
        tt5.a.h("DRIVE_CACHE_FLOW", "clean all drive cache by time start.. beforeTimeInMills = " + r100);     // Catch: Exception -> L15
        UserSession r105 = c();     // Catch: Exception -> L15
        i75.l.g(r100, z75.b.h(com.bytedance.ee.bear.drive.cache.t.j(), r105));     // Catch: Exception -> L15
        i75.l.d(r100, z75.b.h(com.bytedance.ee.bear.drive.cache.t.f(), r105));     // Catch: Exception -> L15
        i75.l.g(r100, z75.b.h(com.bytedance.ee.bear.drive.cache.t.k(), r105));     // Catch: Exception -> L15
        i75.l.g(r100, z75.b.h(com.bytedance.ee.bear.drive.cache.t.g(), r105));     // Catch: Exception -> L15
        i75.l.g(r100, z75.b.h(com.bytedance.ee.bear.drive.cache.t.h(), r105));     // Catch: Exception -> L15
        tt5.a.h("DRIVE_CACHE_FLOW", "clean all drive cache by time finish");     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "clean all drive cache by time. ", e, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> X2(UserSession r100) {
        tt5.a.h("DRIVE_CACHE_FLOW", "getAll");
        ArrayList r101 = new ArrayList();
        List<y75.a> r102 = b().g0();
        if (r102 == null) goto L11;
        Iterator<y75.a> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        y75.a r104 = r103.next();
        DriveCache r105 = a(r104);
        if (d(r105, r104, r100) == true) goto L9;
        r101.add(r105);
        goto L6
    L9:
        e(r104);
    L11:
        return r101;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final long d5(int r100) {
        List<y75.a> r101 = b().c0(r100);
        long r102 = 0;
        if (r101 != null) goto L5;
        return 0;
    L5:
        Iterator<y75.a> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        y75.a r104 = r103.next();
        if (e(r104) == false) goto L7;
        r102 = r102 + r104.f566604k;
        goto L7
    L11:
        tt5.a.h("DRIVE_CACHE_FLOW", "cleanCacheByType, type=" + r100 + ", size=" + r101.size());
        return r102;
    }

    public final boolean e(y75.a r100) {
        if (r100 != null) goto L19;
        return false;
    L19:
        UserSession r101 = c();     // Catch: Exception -> L11
        i75.l.f(z75.b.e(r100.a(), r101));     // Catch: Exception -> L11
        b().deleteCache(r100.f566594a);     // Catch: Exception -> L11
        DriveFilePath.a r102 = DriveFilePath.Companion;     // Catch: Exception -> L11
        String r103 = r100.f566603j;     // Catch: Exception -> L11
        r102.getClass();     // Catch: Exception -> L11
        i75.l.f(z75.b.e(DriveFilePath.a.b(r103), r101));     // Catch: Exception -> L11
        com.bytedance.ee.bear.drive.dao.d r104 = com.bytedance.ee.bear.drive.dao.c.c().b();     // Catch: Exception -> L11
        com.bytedance.ee.bear.drive.dao.e r105 = (com.bytedance.ee.bear.drive.dao.e) r104;     // Catch: Exception -> L11
        ArrayList r106 = (ArrayList) r105.b(r100.f566614u, r100.f566595b, r100.f566598e);     // Catch: Exception -> L11
        if (r106.size() <= 0) goto L14;
        Iterator r107 = r106.iterator();     // Catch: Exception -> L11
    L9:
        if (r107.hasNext() == false) goto L13;
        y75.b r108 = (y75.b) r107.next();     // Catch: Exception -> L11
        r108.getClass();     // Catch: Exception -> L11
        DriveFilePath.a r109 = DriveFilePath.Companion;     // Catch: Exception -> L11
        String r110 = r108.f566623e;     // Catch: Exception -> L11
        r109.getClass();     // Catch: Exception -> L11
        i75.l.f(z75.b.e(DriveFilePath.a.b(r110), r101));     // Catch: Exception -> L11
        goto L9
    L13:
        com.bytedance.ee.bear.drive.dao.d r111 = com.bytedance.ee.bear.drive.dao.c.c().b();     // Catch: Exception -> L11
        com.bytedance.ee.bear.drive.dao.e r112 = (com.bytedance.ee.bear.drive.dao.e) r111;     // Catch: Exception -> L11
        r112.a(r100.f566614u, r100.f566595b, r100.f566598e);     // Catch: Exception -> L11
    L14:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).F8("DriveDataService-remove", r100.f566595b);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "remove cache -> delete file failed, ", e, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List o2(int r100) {
        tt5.a.h("DRIVE_CACHE_FLOW", "getCacheByTypeAndCacheHost, cacheHost = " + r100 + ", type = 0");
        ArrayList r101 = new ArrayList();
        List r102 = b().W(r100);
        if (hu5.a.d(r102) == false) goto L5;
        return r101;
    L5:
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L17;
        y75.a r104 = (y75.a) r103.next();
        DriveCache r105 = a(r104);
        if (z75.b.d(r105.f216968b, c()) == true) goto L16;
        boolean r106 = true;
        if ((r104.f566616w & 1) == 1) goto L14;
        r106 = false;
    L14:
        if (r106 == true) goto L16;
        e(r104);
    L16:
        r101.add(r105);
        goto L7
    L17:
        return r101;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean remove(String r100) {
        return e(b().e0(r100));
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean y9(String r110) {
        List<y75.a> r100 = b().Y(r110);
        if (r100 != null) goto L5;
        return false;
    L5:
        UserSession r101 = c();
        Iterator<y75.a> r102 = r100.iterator();
        boolean r103 = false;
    L7:
        if (r102.hasNext() == false) goto L37;
        y75.a r104 = r102.next();
        VFSFile r105 = z75.b.e(r104.a(), r101);
        if (r105.exists() == true) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L15;
        DriveFilePath.a r107 = DriveFilePath.Companion;
        String r108 = r104.f566603j;
        r107.getClass();
        VFSFile r109 = z75.b.e(DriveFilePath.a.b(r108), r101);
        if (r109.exists() == true) goto L19;
    L21:
        r106 = false;
    L22:
        if (r106 == true) goto L15;
        ArrayList r111 = (ArrayList) ((com.bytedance.ee.bear.drive.dao.e) com.bytedance.ee.bear.drive.dao.c.c().b()).b(r104.f566614u, r104.f566595b, r104.f566598e);
        if (r111.size() <= 0) goto L36;
        Iterator r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L36;
        y75.b r113 = (y75.b) r112.next();
        r113.getClass();
        DriveFilePath.a r114 = DriveFilePath.Companion;
        String r115 = r113.f566623e;
        r114.getClass();
        VFSFile r116 = z75.b.e(DriveFilePath.a.b(r115), r101);
        if (r116.exists() == true) goto L32;
    L34:
        r106 = false;
    L35:
        if (r106 == false) goto L28;
    L32:
        if (r116.isFile() == false) goto L34;
        r106 = true;
    L36:
        r103 = r106;
        goto L7
    L19:
        if (r109.isFile() == false) goto L21;
        r106 = true;
    L15:
        r103 = r106;
        goto L37
    L11:
        if (r105.isFile() == false) goto L13;
        r106 = true;
    L37:
        tt5.a.h("DRIVE_CACHE_FLOW", "hasCacheByToken " + du5.b.g(r110) + "  result : " + r103);
        return r103;
    }

    public static DriveFilePath f(DriveFilePath r100, UserSession r101) {
        if (z75.b.d(r100, r101) == true) goto L6;
        tt5.a.b("DRIVE_CACHE_FLOW", "tryDecryptFile... invalid filepath : " + r100);
        return r100;
    L6:
        com.ss.android.lark.vfs.h r102 = ay4.d.a();
        File r103 = r102.r(z75.b.b(r100, r101), true);     // Catch: IOException -> L15
        if (r103 != null) goto L10;
    L17:
        return r100;
    L10:
        if (TextUtils.isEmpty(r103.getAbsolutePath()) == true) goto L17;
        if (r103.exists() == false) goto L17;
        r100.setDecryptPath(r102.t(r103));     // Catch: IOException -> L15
    L15:
        e = move-exception;
        tt5.a.e("DRIVE_CACHE_FLOW", "tryDecryptFile... err happens : ", e, false);
        r100.setDecryptPath(null);
        goto L17
    }

    public static DriveFilePath g(DriveFilePath r100, UserSession r101) {
        if (CipherManager.d() == 1) goto L5;
    L12:
        return r100;
    L5:
        if (z75.b.d(r100, r101) == false) goto L12;
        tt5.a.h("DRIVE_CACHE_FLOW", "tryEncryptFile... need encrypt file when it goes to cache");
        tt5.a.b("DRIVE_CACHE_FLOW", "tryEncryptFile... need encrypt file path : " + r100.getRelativePath());
        z75.b.e(r100, r101).afterWriteCompat();     // Catch: Exception -> L10
        tt5.a.h("DRIVE_CACHE_FLOW", "tryEncryptFile... suc encrypt target file ");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        tt5.a.h("DRIVE_CACHE_FLOW", "tryEncryptFile... can not encrypt target file : " + e);
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean H(String r100, String r101) {
        if (b().H(r100, r101) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean Re(long r110, long r111) {
        boolean r100 = Va(r110);
        long r101 = b().b0();
        monitor-enter(this);
        tt5.a.h("DRIVE_CACHE_FLOW", "start trim size to max");     // Catch: Throwable -> L24
        int r102 = 0;
    L6:
        if (r101 <= r111) goto L28;
        if (r102 > 100) goto L28;
        r102 = r102 + 1;     // Catch: Throwable -> L24
        List r103 = b().a0();     // Catch: Throwable -> L24
        if (hu5.a.d(r103) == true) goto L11;
        tt5.a.h("DRIVE_CACHE_FLOW", "cacheModels size=" + r103.size());     // Catch: Throwable -> L24
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L24
    L14:
        if (r104.hasNext() == false) goto L6;
        y75.a r105 = (y75.a) r104.next();     // Catch: Throwable -> L24
        if (r101 <= r111) goto L6;
        UserSession r106 = c();     // Catch: Throwable -> L24 Exception -> L26
        i75.l.f(z75.b.e(r105.a(), r106));     // Catch: Throwable -> L24 Exception -> L26
        DriveFilePath.a r107 = DriveFilePath.Companion;     // Catch: Throwable -> L24 Exception -> L26
        String r108 = r105.f566603j;     // Catch: Throwable -> L24 Exception -> L26
        r107.getClass();     // Catch: Throwable -> L24 Exception -> L26
        i75.l.f(z75.b.e(DriveFilePath.a.b(r108), r106));     // Catch: Throwable -> L24 Exception -> L26
    L20:
        if (b().deleteCache(r105.f566594a) > 0) goto L21;
        tt5.a.k("DRIVE_CACHE_FLOW", "trim size deleted file failed");     // Catch: Throwable -> L24 Exception -> L26
        goto L14
    L21:
        r101 = r101 - r105.f566604k;     // Catch: Throwable -> L24 Exception -> L26
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).F8("DriveDataService-cleanCacheToSizeInternal", r105.f566595b);     // Catch: Throwable -> L24 Exception -> L26
    L26:
        e = move-exception;
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);     // Catch: Throwable -> L24
        goto L14
    L11:
        tt5.a.h("DRIVE_CACHE_FLOW", "trim file loop get cache is empty, stop trim");     // Catch: Throwable -> L24
    L28:
        tt5.a.h("DRIVE_CACHE_FLOW", "trim cache finish, target size = " + r111 + ", current size = " + r101);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        tt5.a.h("DRIVE_CACHE_FLOW", "clearUpTimeMills, upTimeMills: " + r110 + ", maxSizeBytes: " + r111 + ", cleanCacheByTimeRes: " + r100 + ", cleanCacheToSizeRes: true");
        return r100;
    L24:
        th = move-exception;
        throw th;
    }

    public static boolean d(DriveCache r100, y75.a r101, UserSession r102) {
        if (r100.f216985s == true) goto L5;
        DriveFilePath r103 = r100.f216968b;
    L7:
        if (z75.b.d(r103, r102) == true) goto L20;
        int r104 = r101.f566616w;
        if ((r104 & 1) != 1) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        return false;
    L14:
        if ((r104 & 2) == 0) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == true) goto L22;
        return true;
    L22:
        return false;
    L16:
        r106 = false;
        goto L17
    L11:
        r105 = false;
        goto L12
    L20:
        return false;
    L5:
        r103 = r100.f216969c;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean M9(DriveCache r100, String r101, UserSession r102) {
        if (r100 != null) goto L11;
        return false;
    L11:
        i75.l.f(z75.b.e(r100.f216968b, r102));     // Catch: Exception -> L8
        tt5.a.k("DRIVE_CACHE_FLOW", "updateCacheSourceFromAndFilePath, result=" + b().T(r100.f216967a, r101));     // Catch: Exception -> L8
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).F8("DriveDataService-clearUploadCache", r100.f216977k);     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        tt5.a.d("DRIVE_CACHE_FLOW", "clearUploadCache fail: " + e);
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final DriveCache Zc(String r100, boolean r101, UserSession r102) {
        y75.a r103 = b().e0(r100);
        if (r103 == null) goto L11;
        DriveCache r104 = a(r103);
        DriveFilePath r105 = r103.a();
        f(r105, r102);
        r104.f216968b = r105;
        DriveFilePath.a r106 = DriveFilePath.Companion;
        String r107 = r103.f566603j;
        r106.getClass();
        DriveFilePath r108 = DriveFilePath.a.b(r107);
        f(r108, r102);
        r104.f216969c = r108;
        if (d(r104, r103, r102) == false) goto L8;
        tt5.a.k("DRIVE_CACHE_FLOW", "get drive cache from db success, but file not exists, remove it");
        e(r103);
        return null;
    L8:
        if (r101 == false) goto L10;
        b().f0(r100, System.currentTimeMillis());
    L10:
        return r104;
    L11:
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final List<DriveCache> K4(long r100, String r101, String r102, UserSession r103) {
        tt5.a.h("DRIVE_CACHE_FLOW", "getSpaceFileManualCacheByTypeBeforeModTime beforeTime=" + r100 + ", uid = " + r101 + ", tenantId = " + r102);
        ArrayList r104 = new ArrayList();
        List r105 = b().Z(r100, r101, r102);
        if (hu5.a.d(r105) == false) goto L5;
        return r104;
    L5:
        Iterator r106 = r105.iterator();
    L7:
        if (r106.hasNext() == false) goto L17;
        y75.a r107 = (y75.a) r106.next();
        DriveCache r108 = a(r107);
        if (z75.b.d(r108.f216968b, r103) == true) goto L16;
        boolean r109 = true;
        if ((r107.f566616w & 1) == 1) goto L14;
        r109 = false;
    L14:
        if (r109 == true) goto L16;
        e(r107);
    L16:
        r104.add(r108);
        goto L7
    L17:
        return r104;
    }

    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean T5(String r100, int r101, int r102, UserSession r110) {
        tt5.a.h("DRIVE_CACHE_FLOW", "convertCacheType() st=" + r101 + " tt=" + r102);
        if (r101 != r102) goto L5;
        return true;
    L5:
        DriveFilePath r103 = i75.f.a(r101);
        VFSFile r104 = z75.b.e(r103.cacheName(r100), r110);
        VFSPath r105 = z75.b.b(r103, r110);
        DriveFilePath r106 = i75.f.a(r102);
        VFSFile r107 = z75.b.e(r106.cacheName(r100), r110);
        VFSPath r111 = z75.b.b(r106, r110);
        if (r104.exists() == true) goto L23;
        tt5.a.k("DRIVE_CACHE_FLOW", "convertCacheType, but source file not exists");
    L23:
    L15:
        e = move-exception;
        FileUtils.m(r111);     // Catch: Exception -> L18
    L19:
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);
    L20:
        return false;
    L18:
        tt5.a.e("DRIVE_CACHE_FLOW", "convertCacheType() delete target file", e, false);
        goto L19
    L10:
        if (r104.getParent().equals(r107.getParent()) == true) goto L12;
        FileUtils.j(r105, r111);     // Catch: Exception -> L15
        FileUtils.m(r105);     // Catch: Exception -> L15
    L12:
        com.bytedance.ee.bear.drive.dao.a r108 = b();     // Catch: Exception -> L15
        DriveFilePath.Companion.getClass();     // Catch: Exception -> L15
        if (r108.V(r100, r102, DriveFilePath.a.c(r106)) <= 0) goto L20;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v6 */
    @Override // com.bytedance.ee.bear.drive.services.c
    public final boolean p1(v85.a r110, String r111, String r112, UserSession r113) {
        DriveFilePath r100 = r110.f553679f;
        DriveFilePath r101 = r110.f553680g;
        y75.a r102 = new y75.a();
        boolean r103 = z75.b.d(r100, r113);
        boolean r104 = z75.b.d(r101, r113);
        if (r103 == true) goto L12;
        if (r104 == true) goto L12;
        if (r110.f553690q == false) goto L9;
    L23:
        r102.f566613t = r110.f553674a;
        r102.f566594a = r110.f553676c;
        r102.f566595b = r110.f553677d;
        r102.f566605l = r110.f553675b;
        r102.f566596c = r110.f553683j;
        r102.f566597d = r110.f553684k;
        r102.f566599f = r110.f553686m;
        r102.f566600g = r110.f553687n;
        r102.f566598e = r110.f553682i;
        r102.f566611r = r110.f553685l;
        long r105 = System.currentTimeMillis();
        r102.f566606m = r105;
        r102.f566607n = r105;
        r102.f566608o = r110.f553678e;
        r102.f566609p = r111;
        r102.f566610q = r112;
        r102.f566614u = r110.f553692s;
        r102.f566615v = r110.f553693t;
        r102.f566617x = r110.f553681h;
        r102.f566618y = r110.f553691r;
        boolean r114 = r110.f553690q;
        ?? r115 = r114;
        if (r110.f553688o == false) goto L26;
        r115 = (r114 ? 1 : 0) | 2;
    L26:
        int r116 = r115;
        if (r110.f553689p == false) goto L29;
        r116 = (r115 == true ? 1 : 0) | 4;
    L29:
        r102.f566616w = r116;
        if (b().X(r102) <= 0) goto L32;
        boolean r117 = true;
    L34:
        if (r110.f553688o == false) goto L38;
        if (r103 == true) goto L38;
        tt5.a.h("DRIVE_CACHE_FLOW", "addDriveCache done, current is weboffice, ignore check. result=" + r117);
        return r117;
    L38:
        if (r117 == false) goto L43;
        String r118 = r110.f553677d;
        if (r118 != null) goto L42;
        tt5.a.d("DRIVE_CACHE_FLOW", "put, cacheEntity.fileId is null.");
    L50:
        return r117;
    L42:
        ((com.bytedance.ee.bear.drive.cache.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.cache.w.class)).J6(r118);
        goto L50
    L43:
        tt5.a.d("DRIVE_CACHE_FLOW", "add cache record to db failed");
        DriveFilePath r119 = r102.a();     // Catch: Exception -> L48
        if (r119.isEmpty() == true) goto L50;
        i75.l.f(z75.b.e(r119, r113));     // Catch: Exception -> L48
    L48:
        e = move-exception;
        tt5.a.f("DRIVE_CACHE_FLOW", e, false);
        goto L50
    L32:
        r117 = false;
        goto L34
    L9:
        if (r110.f553688o == true) goto L23;
        tt5.a.d("DRIVE_CACHE_FLOW", "put cache but file not exists.");
        return false;
    L12:
        VFSFile r106 = z75.b.f(i75.f.a(r110.f553675b), r113);
        if (r106.exists() == true) goto L15;
        tt5.a.h("DRIVE_CACHE_FLOW", "cache dir not exists, create it, " + r106.mkdirs());
    L15:
        if (r103 == false) goto L17;
        g(r100, r113);
    L17:
        if (r104 == false) goto L19;
        g(r101, r113);
    L19:
        if (r103 == false) goto L21;
        VFSFile r107 = z75.b.e(r100, r113);
    L22:
        r102.f566604k = r107.length();
        DriveFilePath.Companion.getClass();
        r102.f566601h = DriveFilePath.a.c(r100);
        r102.f566603j = DriveFilePath.a.c(r101);
        goto L23
    L21:
        r107 = z75.b.e(r101, r113);
        goto L22
    }
}
