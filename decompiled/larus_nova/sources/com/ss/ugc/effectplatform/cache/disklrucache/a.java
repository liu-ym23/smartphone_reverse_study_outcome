package com.ss.ugc.effectplatform.cache.disklrucache;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.io.file.ContentEncoding;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.FileType;
import bytekn.foundation.io.file.IOException;
import bytekn.foundation.io.file.g;
import bytekn.foundation.io.file.h;
import bytekn.foundation.io.file.i;
import bytekn.foundation.logger.Logger;
import com.android.ttcjpaysdk.bdpay.counter.outer.preload.DyOuterPayPreloadManager;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Regex f457282v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final C5470a f457283w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bytekn.foundation.io.file.f f457284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bytekn.foundation.io.file.f f457285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bytekn.foundation.io.file.f f457286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0.b<Long> f457287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0.b<Integer> f457288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0.b<i> f457289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0.e f457290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a0.b<Boolean> f457291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a0.b<Boolean> f457292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a0.b<Long> f457293j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final z.b<String, c> f457294k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AsyncExecutor f457295l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f457296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f457297n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f457298o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f457299p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f457300q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.cache.disklrucache.e f457301r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f457302s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f457303t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f457304u;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.cache.disklrucache.a$a, reason: collision with other inner class name */
    public static final class C5470a {
        public C5470a() {
        }

        public static String c(String r100) {
            char[] r101 = new char[r100.length()];
            int r102 = r100.length();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L19;
            char r104 = r100.charAt(r103);
            r101[r103] = r104;
            if (r104 == '_') goto L17;
            if (r104 == '-') goto L17;
            if (r104 < 'a') goto L13;
            if (r104 <= 'z') goto L17;
        L13:
            if (r104 >= '0') goto L15;
        L16:
            r101[r103] = '_';
            goto L17
        L15:
            if (r104 > '9') goto L16;
        L17:
            r103 = r103 + 1;
            goto L3
        L19:
            return new String(r101);
        }

        public static void b(bytekn.foundation.io.file.f r100, bytekn.foundation.io.file.f r101, boolean r102) {
            if (r102 == false) goto L10;
            String r103 = FileManager.f21782a;
            if (FileManager.c(r101) == false) goto L10;
            if (FileManager.n(r101) == true) goto L10;
            throw new IOException("delete file exception occur,file = " + r101);
        L10:
            String r104 = FileManager.f21782a;
            if (FileManager.p(r100, r101) == false) goto L14;
            return;
        L14:
            throw new IOException("rename file exception occur, from = " + r100 + ",to = " + r101);
        }

        /* JADX WARN: Type inference failed for: r1v9, types: [V, java.lang.Boolean] */
        public static a a(String r110, int r111, int r112, long r113, com.ss.ugc.effectplatform.cache.disklrucache.e r114, boolean r115, boolean r210, boolean r211) {
            if (r113 <= 0) goto L44;
            if (r112 <= 0) goto L42;
            String r100 = FileManager.f21782a;
            if (FileManager.d(r110) == true) goto L10;
            FileManager.i(r110);
            if (FileManager.d(r110) == true) goto L10;
            Logger.e$default(Logger.INSTANCE, "DiskLruCache", ErrorConstants.LOG_CACHE_DIR_NOT_SET + r110, null, 4, null);
        L10:
            bytekn.foundation.io.file.f r101 = null;
            if (r110 == null) goto L13;
            File r102 = new PolarisFileWrapper(r110).getAbsoluteFile();
        L14:
            if (r102 != null) goto L16;
            bytekn.foundation.io.file.f r103 = null;
        L17:
            if (r103 != null) goto L19;
        L33:
            a r116 = new a(r110, r111, r112, r113, r114, r115, r210, r211);
            if (FileManager.c(r116.f457284a) == true) goto L45;
        L39:
            String r104 = FileManager.f21782a;
            FileManager.i(r110);
            a r105 = new a(r110, r111, r112, r113, r114, r115, r210, r211);
            r105.p();
            return r105;
        L45:
            r116.n();     // Catch: Exception -> L37
            r116.l();     // Catch: Exception -> L37
            r116.f457291h.f1239a = Boolean.TRUE;     // Catch: Exception -> L37
            return r116;
        L37:
            e = move-exception;
            Logger.e$default(Logger.INSTANCE, "DiskLruCache", "DiskLruCache " + r110 + " is corrupt: " + e.getMessage() + ", removing", null, 4, null);
            r116.delete();
            goto L39
        L19:
            if (FileManager.c(r103) == false) goto L33;
            if (r110 == null) goto L22;
            File r106 = new PolarisFileWrapper(r110).getAbsoluteFile();
        L23:
            if (r106 == null) goto L26;
            r101 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r106.getAbsolutePath(), "journal").getAbsoluteFile().getAbsolutePath());
        L26:
            if (r101 == null) goto L33;
            if (FileManager.c(r101) == false) goto L33;
            if (FileManager.c(r101) == false) goto L32;
            FileManager.n(r103);
            goto L33
        L32:
            a.f457283w.getClass();
            b(r103, r101, false);
            goto L33
        L22:
            r106 = null;
            goto L23
        L16:
            r103 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r102.getAbsolutePath(), "journal.bkp").getAbsoluteFile().getAbsolutePath());
            goto L17
        L13:
            r102 = null;
            goto L14
        L42:
            throw new IllegalArgumentException("valueCount <= 0");
        L44:
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0.b<boolean[]> f457305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0.b<Boolean> f457306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a0.b<Boolean> f457307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f457308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f457309e;

        public final void a() {
            a.a(this.f457309e, this, false);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [V, java.lang.Boolean] */
        public final void b() {
            if (this.f457306b.f1239a.booleanValue() == false) goto L5;
            a.a(this.f457309e, this, false);
            this.f457309e.q(this.f457308d.f457315f);
        L6:
            a0.b<Boolean> r100 = this.f457307c;
            r100.f1239a = Boolean.TRUE;
            return;
        L5:
            a.a(this.f457309e, this, true);
            goto L6
        }

        public final bytekn.foundation.io.file.e c() {
            a r100 = this.f457309e;
            final int r101 = 0;
            if (r100.f457299p <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L33;
            c0.e r103 = r100.f457290g;
            r103.a();
        L29:
            th = move-exception;
            r103.b();
            throw th;
        L9:
            if (Intrinsics.areEqual(this.f457308d.f457312c.f1239a, this) == false) goto L28;
            if (this.f457308d.f457311b.f1239a.booleanValue() == true) goto L13;
            boolean[] r104 = new boolean[this.f457309e.f457299p];     // Catch: Throwable -> L29
            r104[0] = true;     // Catch: Throwable -> L29
            this.f457305a.f1239a = r104;     // Catch: Throwable -> L29
        L13:
            bytekn.foundation.io.file.f r105 = this.f457308d.b(0);     // Catch: Throwable -> L29
            String r106 = FileManager.f21782a;     // Catch: Exception -> L16 Throwable -> L29
            bytekn.foundation.io.file.e r107 = FileManager.k(r105, false);     // Catch: Exception -> L16 Throwable -> L29
        L19:
            if (r107 != null) goto L21;
            Intrinsics.throwNpe();     // Catch: Throwable -> L29
        L21:
            com.ss.ugc.effectplatform.cache.disklrucache.d r108 = new com.ss.ugc.effectplatform.cache.disklrucache.d(r107, new DiskLruCache$Editor$newOutputStream$$inlined$synchronized$lambda$1(this, r101));     // Catch: Throwable -> L29
            r103.b();
            return r108;
        L16:
            String r109 = FileManager.f21782a;     // Catch: Throwable -> L29
            FileManager.i(this.f457309e.f457297n);     // Catch: Throwable -> L29
            r107 = FileManager.k(r105, false);     // Catch: Exception -> L24 Throwable -> L29
        L24:
            com.ss.ugc.effectplatform.cache.disklrucache.c r110 = new com.ss.ugc.effectplatform.cache.disklrucache.c();     // Catch: Throwable -> L29
            r103.b();
            return r110;
        L28:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L29
        L33:
            throw new IllegalArgumentException(("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f457309e.f457299p).toString());
        L5:
            r102 = false;
            goto L6
        }

        public b(a r100, c r101) {
            this.f457309e = r100;
            this.f457308d = r101;
            this.f457305a = new a0.b(new boolean[r100.f457299p]);
            Boolean r102 = Boolean.FALSE;
            this.f457306b = new a0.b(r102);
            this.f457307c = new a0.b(r102);
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z.a<Long> f457310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0.b<Boolean> f457311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a0.b<b> f457312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a0.b<Long> f457313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final z.a<Long> f457314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f457315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a f457316g;

        public final String c() {
            StringBuilder r100 = new StringBuilder();
            Iterator<Long> r101 = this.f457310a.iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            long r102 = r101.next().longValue();
            r100.append(' ');
            r100.append(r102);
            goto L4
        L7:
            return r100.toString();
        }

        public final String d() {
            StringBuilder r100 = new StringBuilder();
            Iterator<Long> r101 = this.f457314e.iterator();
        L4:
            if (r101.hasNext() == false) goto L7;
            long r102 = r101.next().longValue();
            r100.append(' ');
            r100.append(r102);
            goto L4
        L7:
            return r100.toString();
        }

        public static void e(String[] r100) {
            throw new Exception("unexpected journal line: " + r100);
        }

        public final bytekn.foundation.io.file.f a(int r100) {
            if (r100 != 0) goto L12;
            String r101 = this.f457316g.f457297n;
            if (r101 == null) goto L7;
            File r102 = new PolarisFileWrapper(r101).getAbsoluteFile();
        L8:
            String r103 = this.f457315f;
            if (r102 != null) goto L21;
            return null;
        L21:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r102.getAbsolutePath(), r103).getAbsoluteFile().getAbsolutePath());
        L7:
            r102 = null;
            goto L8
        L12:
            String r104 = this.f457316g.f457297n;
            if (r104 == null) goto L15;
            File r105 = new PolarisFileWrapper(r104).getAbsoluteFile();
        L16:
            String r106 = this.f457315f + '.' + r100;
            if (r105 != null) goto L20;
            return null;
        L20:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r105.getAbsolutePath(), r106).getAbsoluteFile().getAbsolutePath());
        L15:
            r105 = null;
            goto L16
        }

        public final bytekn.foundation.io.file.f b(int r100) {
            if (r100 != 0) goto L12;
            String r101 = this.f457316g.f457297n;
            if (r101 == null) goto L7;
            File r102 = new PolarisFileWrapper(r101).getAbsoluteFile();
        L8:
            String r103 = this.f457315f + DefaultDiskStorage.FileType.TEMP;
            if (r102 != null) goto L21;
            return null;
        L21:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r102.getAbsolutePath(), r103).getAbsoluteFile().getAbsolutePath());
        L7:
            r102 = null;
            goto L8
        L12:
            String r104 = this.f457316g.f457297n;
            if (r104 == null) goto L15;
            File r105 = new PolarisFileWrapper(r104).getAbsoluteFile();
        L16:
            String r106 = this.f457315f + '.' + r100 + DefaultDiskStorage.FileType.TEMP;
            if (r105 != null) goto L20;
            return null;
        L20:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r105.getAbsolutePath(), r106).getAbsoluteFile().getAbsolutePath());
        L15:
            r105 = null;
            goto L16
        }

        public c(a r100, String r101) {
            this.f457316g = r100;
            this.f457315f = r101;
            int r102 = 0;
            this.f457310a = new z.a(false);
            this.f457311b = new a0.b(Boolean.FALSE);
            this.f457312c = new a0.b(null);
            this.f457313d = new a0.b(0L);
            this.f457314e = new z.a(false);
            int r103 = r100.f457299p;
        L3:
            if (r102 >= r103) goto L5;
            this.f457310a.add(0L);
            this.f457314e.add(0L);
            r102 = r102 + 1;
            goto L3
        }
    }

    public final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bytekn.foundation.io.file.f[] f457317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bytekn.foundation.io.file.b[] f457318b;

        @Override // bytekn.foundation.io.file.g
        public final void close() {
            bytekn.foundation.io.file.b[] r100 = this.f457318b;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            bytekn.foundation.io.file.b r103 = r100[r102];
            if (r103 == null) goto L7;
            String r104 = FileManager.f21782a;
            FileManager.b(r103);
        L7:
            r102 = r102 + 1;
            goto L3
        }

        public d(bytekn.foundation.io.file.f[] r100, bytekn.foundation.io.file.b[] r101) {
            this.f457317a = r100;
            this.f457318b = r101;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f457319a;

        /* JADX WARN: Type inference failed for: r2v1, types: [V, java.lang.Integer] */
        public final void a() {
            c0.e r100 = this.f457319a.f457290g;
            r100.a();
        L18:
            th = move-exception;
            r100.b();
            throw th;
        L4:
            if (this.f457319a.f457291h.f1239a.booleanValue() == true) goto L6;
            boolean r101 = true;
        L9:
            if ((r101 | this.f457319a.f457292i.f1239a.booleanValue()) == false) goto L12;
            r100.b();
            return;
        L12:
            this.f457319a.r();     // Catch: Throwable -> L18
            if (this.f457319a.h() == false) goto L15;
            this.f457319a.p();     // Catch: Throwable -> L18
            this.f457319a.f457288e.f1239a = 0;     // Catch: Throwable -> L18
        L15:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L18
            r100.b();
            return;
        L6:
            r101 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(a r100) {
            this.f457319a = r100;
        }
    }

    static {
        f457283w = new C5470a();
        f457282v = new Regex("[a-z0-9_-]{1,120}");
    }

    public final void c() {
        if (this.f457292i.f1239a.booleanValue() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [V, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v5, types: [V, java.lang.Boolean] */
    public final void delete() {
        c0.e r100 = this.f457290g;
        r100.a();
    L23:
        th = move-exception;
        r100.b();
        throw th;
    L4:
        if (this.f457291h.f1239a.booleanValue() == true) goto L6;
    L18:
        a0.b<Boolean> r101 = this.f457292i;     // Catch: Throwable -> L23
        r101.f1239a = Boolean.TRUE;     // Catch: Throwable -> L23
    L19:
        r100.b();
        if (com.ss.ugc.effectplatform.util.i.f458038a.delete(this.f457297n) == false) goto L32;
        String r102 = FileManager.f21782a;
        FileManager.i(this.f457297n);
        return;
    L32:
        return;
    L6:
        if (this.f457292i.f1239a.booleanValue() == true) goto L18;
        Iterator r103 = new ArrayList(this.f457294k.values()).iterator();     // Catch: Throwable -> L23
    L10:
        if (r103.hasNext() == false) goto L14;
        b r104 = ((c) r103.next()).f457312c.f1239a;     // Catch: Throwable -> L23
        if (r104 == null) goto L10;
        r104.a();     // Catch: Throwable -> L23
        goto L10
    L14:
        r();     // Catch: Throwable -> L23
        i r105 = this.f457289f.f1239a;     // Catch: Throwable -> L23
        if (r105 == null) goto L17;
        r105.close();     // Catch: Throwable -> L23
    L17:
        this.f457289f.f1239a = null;     // Catch: Throwable -> L23
        a0.b<Boolean> r106 = this.f457292i;     // Catch: Throwable -> L23
        r106.f1239a = Boolean.TRUE;     // Catch: Throwable -> L23
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L23
        goto L19
    }

    public final Set<String> f() {
        c0.e r100 = this.f457290g;
        r100.a();
        Set<String> r101 = CollectionsKt.toSet(new LinkedHashSet(this.f457294k.keySet()));     // Catch: Throwable -> L6
        r100.b();
        return r101;
    L6:
        th = move-exception;
        r100.b();
        throw th;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [V, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v5, types: [V, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v4, types: [V, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v5, types: [V, java.lang.Boolean] */
    public final void g() {
        if (this.f457291h.f1239a.booleanValue() == false) goto L5;
        return;
    L5:
        c0.e r100 = this.f457290g;
        r100.a();
        String r101 = FileManager.f21782a;     // Catch: Throwable -> L33
        if (FileManager.c(this.f457286c) == false) goto L19;
        if (FileManager.c(this.f457284a) == true) goto L11;
        C5470a r102 = f457283w;     // Catch: Throwable -> L33
        bytekn.foundation.io.file.f r103 = this.f457286c;     // Catch: Throwable -> L33
        bytekn.foundation.io.file.f r104 = this.f457284a;     // Catch: Throwable -> L33
        r102.getClass();     // Catch: Throwable -> L33
        C5470a.b(r103, r104, false);     // Catch: Throwable -> L33
        goto L19
    L11:
        if (FileManager.n(this.f457286c) == false) goto L19;
        if (FileManager.c(this.f457286c) == false) goto L19;
        throw new IOException("failed to delete " + this.f457286c);     // Catch: Throwable -> L33
    L19:
        if (FileManager.c(this.f457284a) == true) goto L36;
    L30:
        p();     // Catch: Throwable -> L33
        this.f457291h.f1239a = Boolean.TRUE;     // Catch: Throwable -> L33
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r100.b();
        return;
    L36:
        n();     // Catch: IOException -> L23 Throwable -> L33
        l();     // Catch: IOException -> L23 Throwable -> L33
        this.f457291h.f1239a = Boolean.TRUE;     // Catch: IOException -> L23 Throwable -> L33
        r100.b();     // Catch: IOException -> L23
        return;
    L23:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "DiskLruCache", "DiskLruCache " + this.f457297n + " is corrupt: " + e.getMessage() + ", removing", null, 4, null);     // Catch: Throwable -> L33
        delete();     // Catch: Throwable -> L27
        this.f457292i.f1239a = Boolean.FALSE;     // Catch: Throwable -> L33
        goto L30
    L27:
        th = move-exception;
        this.f457292i.f1239a = Boolean.FALSE;     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r100.b();
        throw th;
    }

    public final boolean h() {
        Logger.INSTANCE.d("DiskLruCache", "journalRebuildRequired, redundantOpCount:" + this.f457288e.f1239a.intValue() + ", lruEntries.size:" + this.f457294k.size());
        if (this.f457288e.f1239a.intValue() >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (this.f457288e.f1239a.intValue() < this.f457294k.size()) goto L7;
        return true;
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [V, java.lang.Long] */
    public final void l() {
        String r100 = FileManager.f21782a;
        FileManager.n(this.f457285b);
        Iterator<c> r101 = this.f457294k.values().iterator();
    L3:
        int r102 = 0;
        if (r101.hasNext() == false) goto L15;
        c r103 = r101.next();
        a0.b<b> r104 = r103.f457312c;
        if (r104.f1239a == null) goto L7;
        r104.f1239a = null;
        int r105 = this.f457299p;
    L11:
        if (r102 >= r105) goto L13;
        com.ss.ugc.effectplatform.util.i r106 = com.ss.ugc.effectplatform.util.i.f458038a;
        r106.delete(r103.a(r102));
        r106.delete(r103.b(r102));
        r102 = r102 + 1;
        goto L11
    L13:
        r101.remove();
        goto L3
    L7:
        int r107 = this.f457299p;
    L8:
        if (r102 >= r107) goto L3;
        a0.b<Long> r108 = this.f457287d;
        r108.f1239a = Long.valueOf(r108.f1239a.longValue() + r103.f457310a.get(r102).longValue());
        r102 = r102 + 1;
        goto L8
    L15:
        if (this.f457303t == false) goto L17;
        return;
    L17:
        Iterator<T> r109 = this.f457294k.entrySet().iterator();
    L19:
        if (r109.hasNext() == false) goto L37;
        Map.Entry r110 = (Map.Entry) r109.next();
        if (((c) r110.getValue()).f457314e.size() <= 0) goto L19;
        long r111 = 0;
        if (((c) r110.getValue()).f457314e.get(0).longValue() > 0) goto L19;
        String r112 = FileManager.f21782a;
        if (FileManager.c(((c) r110.getValue()).a(0)) == false) goto L19;
        bytekn.foundation.io.file.f r113 = ((c) r110.getValue()).a(0);
        if (r113 == null) goto L31;
        String r114 = r113.f21799b;
        if (r114 == null) goto L31;
        bytekn.foundation.io.file.d r115 = FileManager.a(new PolarisFileWrapper(r114));
    L32:
        if (r115 == null) goto L36;
        Double r116 = r115.f21794e;
        if (r116 == null) goto L36;
        r111 = (long) r116.doubleValue();
    L36:
        Logger.INSTANCE.d("DiskLruCache", ((String) r110.getKey()) + ":modifiedAt:" + r111);
        ((c) r110.getValue()).f457314e.set(0, Long.valueOf(r111));
    L31:
        r115 = null;
        goto L32
    }

    public final void m() {
        c0.e r100 = this.f457290g;
        r100.a();
        String r101 = FileManager.f21782a;     // Catch: Throwable -> L26
        if (FileManager.c(this.f457286c) == false) goto L10;
        if (FileManager.c(this.f457284a) == false) goto L8;
        FileManager.n(this.f457286c);     // Catch: Throwable -> L26
        goto L10
    L8:
        C5470a r102 = f457283w;     // Catch: Throwable -> L26
        bytekn.foundation.io.file.f r103 = this.f457286c;     // Catch: Throwable -> L26
        bytekn.foundation.io.file.f r104 = this.f457284a;     // Catch: Throwable -> L26
        r102.getClass();     // Catch: Throwable -> L26
        C5470a.b(r103, r104, false);     // Catch: Throwable -> L26
    L10:
        if (FileManager.c(this.f457284a) == true) goto L29;
    L20:
        String r105 = FileManager.f21782a;     // Catch: Throwable -> L26
        if (FileManager.d(this.f457297n) == true) goto L23;
        FileManager.i(this.f457297n);     // Catch: Throwable -> L26
    L23:
        p();     // Catch: Throwable -> L26
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r100.b();
        return;
    L29:
        n();     // Catch: Exception -> L14 Throwable -> L26
        l();     // Catch: Exception -> L14 Throwable -> L26
        r100.b();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "DiskLruCache", "DiskLruCache " + this.f457297n + " is corrupt: " + e.getMessage() + ", removing", null, 4, null);     // Catch: Throwable -> L26
        delete();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r100.b();
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [V, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v8, types: [V, bytekn.foundation.io.file.h] */
    public final void n() {
        bytekn.foundation.io.file.f r100 = this.f457284a;
        String r101 = FileManager.f21782a;
        if (r100 == null) goto L7;
        String r102 = r100.f21799b;
        if (r102 == null) goto L7;
        bytekn.foundation.io.file.b r103 = FileManager.j(r102);
    L8:
        if (r103 == null) goto L69;
        f r104 = new f(r103, ContentEncoding.Ascii);
        String r105 = r104.b();     // Catch: Throwable -> L60 Exception -> L62
        String r106 = r104.b();     // Catch: Throwable -> L60 Exception -> L62
        String r107 = r104.b();     // Catch: Throwable -> L60 Exception -> L62
        String r108 = r104.b();     // Catch: Throwable -> L60 Exception -> L62
        String r109 = r104.b();     // Catch: Throwable -> L60 Exception -> L62
        boolean r110 = false;
        if (this.f457304u == false) goto L13;
        boolean r111 = false;
    L15:
        if ((!Intrinsics.areEqual("libcore.io.DiskLruCache", r105)) == true) goto L65;
        if ((!Intrinsics.areEqual("1", r106)) == true) goto L65;
        if (r111 == true) goto L65;
        if ((!Intrinsics.areEqual(String.valueOf(this.f457299p), r108)) == true) goto L65;
        if ((!Intrinsics.areEqual(r109, "")) == true) goto L65;
        int r112 = 0;
    L71:
        String r113 = r104.b();     // Catch: Exception -> L70 Throwable -> L60
        if (r113 == null) goto L31;
        if (o(r113) == false) goto L31;
        r112 = r112 + 1;
    L31:
        Collection<c> r114 = this.f457294k.values();     // Catch: Throwable -> L60 Exception -> L62
        if ((r114 instanceof Collection) == true) goto L34;
    L36:
        Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L60 Exception -> L62
        int r116 = 0;
    L38:
        if (r115.hasNext() == false) goto L49;
        c r117 = (c) r115.next();     // Catch: Throwable -> L60 Exception -> L62
        if (r117.f457314e.size() > 0) goto L42;
    L44:
        boolean r118 = false;
    L45:
        if (r118 == false) goto L38;
        r116 = r116 + 1;     // Catch: Throwable -> L60 Exception -> L62
        if (r116 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L60 Exception -> L62
        goto L38
    L42:
        if (r117.f457314e.get(0).longValue() <= 0) goto L44;
        r118 = true;
    L49:
        this.f457288e.f1239a = Integer.valueOf((r112 - this.f457294k.size()) - r116);     // Catch: Throwable -> L60 Exception -> L62
        if (r104.f457328c != (-1)) goto L52;
        r110 = true;
    L52:
        if (r110 == false) goto L54;
        p();     // Catch: Throwable -> L60 Exception -> L62
    L58:
        String r119 = FileManager.f21782a;
        FileManager.b(r104);
        return;
    L54:
        a0.b<i> r120 = this.f457289f;     // Catch: Throwable -> L60 Exception -> L62
        String r121 = FileManager.f21782a;     // Catch: Throwable -> L60 Exception -> L62
        bytekn.foundation.io.file.e r122 = FileManager.k(this.f457284a, true);     // Catch: Throwable -> L60 Exception -> L62
        if (r122 != null) goto L57;
        Intrinsics.throwNpe();     // Catch: Throwable -> L60 Exception -> L62
    L57:
        ContentEncoding r123 = ContentEncoding.Utf8;     // Catch: Throwable -> L60 Exception -> L62
        r120.f1239a = new h(r122);     // Catch: Throwable -> L60 Exception -> L62
        goto L58
    L34:
        if (r114.isEmpty() == false) goto L36;
        r116 = 0;
    L65:
        throw new IOException("unexpected journal header: [" + r105 + ", " + r106 + ", " + r108 + ", " + r109 + "]");     // Catch: Throwable -> L60 Exception -> L62
    L13:
        r111 = !Intrinsics.areEqual(String.valueOf(this.f457298o), r107);     // Catch: Throwable -> L60 Exception -> L62
    L62:
        e = move-exception;
        throw e;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        String r124 = FileManager.f21782a;
        FileManager.b(r104);
        throw th;
    L69:
        return;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [V, bytekn.foundation.io.file.h] */
    public final void p() {
        Logger.INSTANCE.d("DiskLruCache", "rebuildJournal");
        c0.e r100 = this.f457290g;
        r100.a();
        i r101 = this.f457289f.f1239a;     // Catch: Throwable -> L49
        if (r101 == null) goto L54;
        r101.close();     // Catch: Throwable -> L49
    L54:
        String r102 = FileManager.f21782a;     // Catch: Exception -> L9 Throwable -> L49
        bytekn.foundation.io.file.e r103 = FileManager.k(this.f457285b, false);     // Catch: Exception -> L9 Throwable -> L49
    L13:
        if (r103 == null) goto L47;
        ContentEncoding r104 = ContentEncoding.Utf8;     // Catch: Throwable -> L49
        FileOutputStream r105 = r103.f21797a;     // Catch: Throwable -> L49
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");     // Catch: Throwable -> L49
    L17:
        OutputStreamWriter r106 = new OutputStreamWriter(r105);     // Catch: Throwable -> L49
        r106.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L44
        r106.write("\n");     // Catch: Throwable -> L44
        r106.write("1");     // Catch: Throwable -> L44
        r106.write("\n");     // Catch: Throwable -> L44
        if (this.f457304u == false) goto L21;
        r106.write(String.valueOf(0));     // Catch: Throwable -> L44
    L22:
        r106.write("\n");     // Catch: Throwable -> L44
        r106.write(String.valueOf(this.f457299p));     // Catch: Throwable -> L44
        r106.write("\n");     // Catch: Throwable -> L44
        r106.write("\n");     // Catch: Throwable -> L44
        Iterator<c> r107 = this.f457294k.values().iterator();     // Catch: Throwable -> L44
    L23:
        if (r107.hasNext() == false) goto L35;
        c r108 = r107.next();     // Catch: Throwable -> L44
        if (r108.f457312c.f1239a == null) goto L28;
        r106.write("DIRTY " + r108.f457315f + '\n');     // Catch: Throwable -> L44
    L30:
        if (r108.f457314e.size() <= 0) goto L23;
        if (r108.f457314e.get(0).longValue() <= 0) goto L23;
        r106.write("USE " + r108.f457315f + r108.d() + '\n');     // Catch: Throwable -> L44
        goto L23
    L28:
        r106.write("CLEAN " + r108.f457315f + r108.c() + '\n');     // Catch: Throwable -> L44
        goto L30
    L35:
        r106.close();     // Catch: Throwable -> L49
        String r109 = FileManager.f21782a;     // Catch: Throwable -> L49
        if (FileManager.c(this.f457284a) == false) goto L38;
        C5470a r110 = f457283w;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r111 = this.f457284a;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r112 = this.f457286c;     // Catch: Throwable -> L49
        r110.getClass();     // Catch: Throwable -> L49
        C5470a.b(r111, r112, true);     // Catch: Throwable -> L49
    L38:
        C5470a r113 = f457283w;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r114 = this.f457285b;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r115 = this.f457284a;     // Catch: Throwable -> L49
        r113.getClass();     // Catch: Throwable -> L49
        C5470a.b(r114, r115, false);     // Catch: Throwable -> L49
        FileManager.n(this.f457286c);     // Catch: Throwable -> L49
        a0.b<i> r116 = this.f457289f;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.e r117 = FileManager.k(this.f457284a, true);     // Catch: Throwable -> L49
        if (r117 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L41:
        ContentEncoding r118 = ContentEncoding.Utf8;     // Catch: Throwable -> L49
        r116.f1239a = new h(r117);     // Catch: Throwable -> L49
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L49
        r100.b();
        return;
    L21:
        r106.write(String.valueOf(this.f457298o));     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L49
        throw th;     // Catch: Throwable -> L49
    L47:
        r100.b();
        return;
    L9:
        String r120 = FileManager.f21782a;     // Catch: Throwable -> L49
        String r121 = this.f457285b.f21799b;     // Catch: Throwable -> L49
        if (r121 == null) goto L12;
        new PolarisFileWrapper(r121).getAbsoluteFile().createNewFile();     // Catch: Throwable -> L49
    L12:
        r103 = FileManager.k(this.f457285b, false);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r100.b();
        throw th;
    }

    public final void r() {
    L3:
        if (this.f457287d.f1239a.longValue() <= this.f457300q) goto L29;
        int r100 = this.f457294k.size();
        Iterator<Map.Entry<String, c>> r101 = this.f457294k.entrySet().iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L3;
        Map.Entry<String, c> r103 = r101.next();
        com.ss.ugc.effectplatform.cache.disklrucache.e r104 = this.f457301r;
        if (r104 == null) goto L13;
        if (r104.isAllowed(r103.getKey()) == false) goto L13;
        r102 = r102 + 1;
    L13:
        if ((r100 - r102) >= 10) goto L28;
        c0.e r105 = this.f457290g;
        r105.a();
        long r106 = this.f457300q;     // Catch: Throwable -> L25
        r105.b();
        long r107 = r106 * ((long) 2);
        c0.e r108 = this.f457290g;
        r108.a();
        this.f457300q = r107;     // Catch: Throwable -> L22
        if (this.f457291h.f1239a.booleanValue() == false) goto L20;
        this.f457295l.execute(this.f457296m);     // Catch: Throwable -> L22
    L20:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r108.b();
    L22:
        th = move-exception;
        r108.b();
        throw th;
    L25:
        th = move-exception;
        r105.b();
        throw th;
    L28:
        Logger.INSTANCE.d("DiskLruCache", "remove " + r103.getKey() + " because exceed to maxSize(" + this.f457300q + ')');
        q(r103.getKey());
        goto L3
    }

    public static boolean s(String r100) {
        return f457282v.matches(r100);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [V] */
    /* JADX WARN: Type inference failed for: r0v9, types: [V, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v7, types: [V, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v13, types: [V, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v8, types: [V, java.lang.Long] */
    public final void b(String r110) {
        c0.e r100 = this.f457290g;
        r100.a();
        c();     // Catch: Throwable -> L52
        if (s(r110) == false) goto L51;
        c r101 = this.f457294k.get(r110);     // Catch: Throwable -> L52
        if (r101 != null) goto L9;
        r101 = new c(this, r110);     // Catch: Throwable -> L52
        this.f457294k.put(r110, r101);     // Catch: Throwable -> L52
    L13:
        bytekn.foundation.io.file.f r102 = r101.a(0);     // Catch: Throwable -> L52
        String r103 = FileManager.f21782a;     // Catch: Throwable -> L52
        if (FileManager.c(r102) == false) goto L45;
        long r104 = r101.f457310a.get(0).longValue();     // Catch: Throwable -> L52
        if (r102 == null) goto L20;
        String r105 = r102.f21799b;     // Catch: Throwable -> L52
        if (r105 == null) goto L20;
        bytekn.foundation.io.file.d r106 = FileManager.a(new PolarisFileWrapper(r105));     // Catch: Throwable -> L52
    L21:
        if (r106 == null) goto L25;
        Long r107 = r106.f21795f;     // Catch: Throwable -> L52
        if (r107 == null) goto L25;
        long r108 = r107.longValue();     // Catch: Throwable -> L52
    L26:
        if (r106 != null) goto L28;
    L34:
        r101.f457310a.set(0, Long.valueOf(r108));     // Catch: Throwable -> L52
        a0.b<Long> r111 = this.f457287d;     // Catch: Throwable -> L52
        r111.f1239a = Long.valueOf((r111.f1239a.longValue() - r104) + r108);     // Catch: Throwable -> L52
        a0.b<Integer> r112 = this.f457288e;     // Catch: Throwable -> L52
        r112.f1239a = Integer.valueOf(r112.f1239a.intValue() + 1);     // Catch: Throwable -> L52
        r101.f457312c.f1239a = null;     // Catch: Throwable -> L52
        r101.f457311b.f1239a = Boolean.TRUE;     // Catch: Throwable -> L52
        i r113 = this.f457289f.f1239a;     // Catch: Throwable -> L52
        if (r113 == null) goto L37;
        r113.b("CLEAN " + r101.f457315f + r101.c() + '\n');     // Catch: Throwable -> L52
    L37:
        a0.b<Long> r114 = this.f457293j;     // Catch: Throwable -> L52
        r114.f1239a = Long.valueOf(r114.f1239a.longValue() + 1);     // Catch: Throwable -> L52
        r101.f457313d.f1239a = this.f457293j.f1239a;     // Catch: Throwable -> L52
        i r115 = this.f457289f.f1239a;     // Catch: Throwable -> L52
        if (r115 == null) goto L41;
        r115.a();     // Catch: Throwable -> L52
    L41:
        if (this.f457287d.f1239a.longValue() <= this.f457300q) goto L43;
    L44:
        this.f457295l.execute(this.f457296m);     // Catch: Throwable -> L52
    L48:
        r100.b();
        return;
    L43:
        if (h() == false) goto L48;
    L28:
        if (r106.getType() != FileType.Directory) goto L34;
        com.ss.ugc.effectplatform.util.i r109 = com.ss.ugc.effectplatform.util.i.f458038a;     // Catch: Throwable -> L52
        if (r102 == null) goto L32;
        String r116 = r102.f21799b;     // Catch: Throwable -> L52
    L33:
        r108 = com.ss.ugc.effectplatform.util.i.f(r116);     // Catch: Throwable -> L52
        goto L34
    L32:
        r116 = null;
    L25:
        r108 = 0;
    L20:
        r106 = null;
        goto L21
    L45:
        this.f457294k.remove(r101.f457315f);     // Catch: Throwable -> L52
        i r117 = this.f457289f.f1239a;     // Catch: Throwable -> L52
        if (r117 == null) goto L48;
        r117.b("REMOVE " + r101.f457315f + '\n');     // Catch: Throwable -> L52
        goto L48
    L9:
        if (r101.f457312c.f1239a == null) goto L13;
        r100.b();
        return;
    L51:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r110 + "\"");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r100.b();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [V, com.ss.ugc.effectplatform.cache.disklrucache.a$b] */
    public final b d(String r100) {
        c0.e r101 = this.f457290g;
        r101.a();
        g();     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
        if (s(r100) == false) goto L21;
        c r102 = this.f457294k.get(r100);     // Catch: Throwable -> L22
        if (r102 != null) goto L9;
        r102 = new c(this, r100);     // Catch: Throwable -> L22
        this.f457294k.put(r100, r102);     // Catch: Throwable -> L22
    L11:
        ?? r103 = new b(this, r102);     // Catch: Throwable -> L22
        r102.f457312c.f1239a = r103;     // Catch: Throwable -> L22
        i r104 = this.f457289f.f1239a;     // Catch: Throwable -> L22
        if (r104 == null) goto L14;
        r104.b("DIRTY " + r100 + '\n');     // Catch: Throwable -> L22
    L14:
        i r105 = this.f457289f.f1239a;     // Catch: Throwable -> L22
        if (r105 == null) goto L17;
        r105.a();     // Catch: Throwable -> L22
    L17:
        b r106 = r103;
    L18:
        r101.b();
        return r106;
    L9:
        if (r102.f457312c.f1239a == null) goto L11;
        Logger.INSTANCE.d("DiskLruCache", "key: " + r100 + " is now in editing, return null!");     // Catch: Throwable -> L22
        r106 = 0;
        goto L18
    L21:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r101.b();
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [V, java.lang.Integer] */
    public final d e(String r110) {
        if (r110 == null) goto L48;
        c0.e r100 = this.f457290g;
        r100.a();
        g();     // Catch: Throwable -> L45
        c();     // Catch: Throwable -> L45
        if (s(r110) == false) goto L43;
        c r101 = this.f457294k.get(r110);     // Catch: Throwable -> L45
        if (r101 != null) goto L10;
        r100.b();
        return null;
    L10:
        if (r101.f457311b.f1239a.booleanValue() == true) goto L13;
        r100.b();
        return null;
    L13:
        int r102 = this.f457299p;     // Catch: Throwable -> L45
        bytekn.foundation.io.file.b[] r103 = new bytekn.foundation.io.file.b[r102];     // Catch: Throwable -> L45
        bytekn.foundation.io.file.f[] r104 = new bytekn.foundation.io.file.f[r102];     // Catch: Throwable -> L45
        int r105 = 0;
        int r106 = 0;
    L15:
        if (r106 >= r102) goto L32;
        bytekn.foundation.io.file.f r107 = r101.a(r106);     // Catch: Exception -> L49 Throwable -> L45
        r104[r106] = r107;     // Catch: Exception -> L49 Throwable -> L45
        if (r107 == null) goto L23;
        String r108 = FileManager.f21782a;     // Catch: Exception -> L49 Throwable -> L45
        String r109 = r107.f21799b;     // Catch: Exception -> L49 Throwable -> L45
        if (r109 == null) goto L21;
        bytekn.foundation.io.file.b r111 = FileManager.j(r109);     // Catch: Exception -> L49 Throwable -> L45
    L22:
        r103[r106] = r111;     // Catch: Exception -> L49 Throwable -> L45
        goto L23
    L21:
        r111 = null;
    L23:
        r106 = r106 + 1;
    L25:
        if (r105 >= this.f457299p) goto L30;
        bytekn.foundation.io.file.b r112 = r103[r105];     // Catch: Throwable -> L45
        if (r112 == null) goto L30;
        String r113 = FileManager.f21782a;     // Catch: Throwable -> L45
        FileManager.b(r112);     // Catch: Throwable -> L45
        r105 = r105 + 1;
    L30:
        r100.b();
        return null;
    L32:
        a0.b<Integer> r114 = this.f457288e;     // Catch: Throwable -> L45
        r114.f1239a = Integer.valueOf(r114.f1239a.intValue() + 1);     // Catch: Throwable -> L45
        i r115 = this.f457289f.f1239a;     // Catch: Throwable -> L45
        if (r115 == null) goto L35;
        r115.f21800a.append("READ " + r110 + '\n');     // Catch: Throwable -> L45
    L35:
        i(r101);     // Catch: Throwable -> L45
        if (h() == false) goto L38;
        this.f457295l.execute(this.f457296m);     // Catch: Throwable -> L45
    L38:
        r101.f457313d.f1239a.longValue();     // Catch: Throwable -> L45
        CollectionsKt.toLongArray(r101.f457310a);     // Catch: Throwable -> L45
        d r116 = new d(r104, r103);     // Catch: Throwable -> L45
        r100.b();
        return r116;
    L43:
        q(r110);     // Catch: Throwable -> L45
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r110 + "\"");     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r100.b();
        throw th;
    L48:
        return null;
    }

    public final void i(c r100) {
        if (this.f457302s == true) goto L5;
        j(r100);
        return;
    L5:
        if (a0.a.a() == true) goto L7;
        j(r100);
        return;
    L7:
        this.f457295l.execute(new com.ss.ugc.effectplatform.cache.disklrucache.b(this, r100));
    }

    public final void j(c r100) {
        c0.e r101 = this.f457290g;     // Catch: Exception -> L15
        r101.a();     // Catch: Exception -> L15
        z.a<Long> r102 = r100.f457314e;     // Catch: Throwable -> L7
        int r103 = b0.a.f16820a;     // Catch: Throwable -> L7
        r102.set(0, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L7
        i r104 = this.f457289f.f1239a;     // Catch: Throwable -> L7
        if (r104 == null) goto L9;
        r104.b("USE " + r100.f457315f + r100.d() + '\n');     // Catch: Throwable -> L7
    L9:
        i r105 = this.f457289f.f1239a;     // Catch: Throwable -> L7
        if (r105 == null) goto L12;
        r105.a();     // Catch: Throwable -> L7
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L7
    L12:
        r101.b();     // Catch: Exception -> L15
        return;
    L7:
        th = move-exception;
        r101.b();     // Catch: Exception -> L15
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Logger.INSTANCE.e("DiskLruCache", "markEntryUsedSync ", e);
    }

    public final void k(String r100) {
        c0.e r101 = this.f457290g;
        r101.a();
        g();     // Catch: Throwable -> L13
        c();     // Catch: Throwable -> L13
        if (s(r100) == false) goto L12;
        c r102 = this.f457294k.get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L8;
        r102 = new c(this, r100);     // Catch: Throwable -> L13
        this.f457294k.put(r100, r102);     // Catch: Throwable -> L13
    L8:
        i(r102);     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r101.b();
        return;
    L12:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r101.b();
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [V, com.ss.ugc.effectplatform.cache.disklrucache.a$b] */
    /* JADX WARN: Type inference failed for: r5v10, types: [V, java.lang.Boolean] */
    public final boolean o(String r110) {
        int r100 = StringsKt.indexOf$default(r110, ' ', 0, false, 6, null);
        int r101 = 0;
        if (r100 != (-1)) goto L5;
        return false;
    L5:
        int r111 = r100 + 1;
        int r102 = StringsKt.indexOf$default(r110, ' ', r111, false, 4, null);
        if (r102 != (-1)) goto L13;
        String r103 = r110.substring(r111);
        if (r100 == 6) goto L10;
    L14:
        c r104 = this.f457294k.get(r103);
        if (r104 != null) goto L18;
        r104 = new c(this, r103);
        this.f457294k.put(r103, r104);
    L18:
        if (r102 == (-1)) goto L36;
        if (r100 != 5) goto L36;
        if (StringsKt.startsWith$default(r110, "CLEAN", false, 2, null) == false) goto L36;
        Object[] r105 = StringsKt.split$default(r110.substring(r102 + 1), new String[]{" "}, false, 0, 6, null).toArray(new String[0]);
        if (r105 == null) goto L35;
        String[] r106 = (String[]) r105;
        a0.b<Boolean> r107 = r104.f457311b;
        r107.f1239a = Boolean.TRUE;
        r104.f457312c.f1239a = null;
        if (r106.length == r104.f457316g.f457299p) goto L70;
        c.e(r106);
        throw null;
    L70:
        int r108 = r106.length;     // Catch: NumberFormatException -> L30
    L27:
        if (r101 >= r108) goto L66;
        r104.f457310a.set(r101, Long.valueOf(CastLongProtector.parseLong(r106[r101])));     // Catch: NumberFormatException -> L30
        r101 = r101 + 1;
    L66:
        return true;
    L30:
        c.e(r106);
        throw null;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L36:
        if (r102 != (-1)) goto L38;
    L55:
        if (r102 != (-1)) goto L60;
        if (r100 != 5) goto L60;
        if (StringsKt.startsWith$default(r110, "DIRTY", false, 2, null) == false) goto L60;
        a0.b<b> r109 = r104.f457312c;
        r109.f1239a = new b(this, r104);
    L60:
        if (r102 == (-1)) goto L62;
    L67:
        return false;
    L62:
        if (r100 != 4) goto L67;
        if (StringsKt.startsWith$default(r110, "READ", false, 2, null) == true) goto L66;
    L38:
        if (r100 != 3) goto L55;
        if (StringsKt.startsWith$default(r110, DyOuterPayPreloadManager.VIEW_TAG, false, 2, null) == false) goto L55;
        Object[] r112 = StringsKt.split$default(r110.substring(r102 + 1), new String[]{" "}, false, 0, 6, null).toArray(new String[0]);
        if (r112 == null) goto L54;
        String[] r113 = (String[]) r112;
        if (r113.length == r104.f457316g.f457299p) goto L68;
        c.e(r113);
        throw null;
    L68:
        int r114 = r113.length;     // Catch: NumberFormatException -> L49
    L46:
        if (r101 >= r114) goto L66;
        r104.f457314e.set(r101, Long.valueOf(CastLongProtector.parseLong(r113[r101])));     // Catch: NumberFormatException -> L49
        r101 = r101 + 1;
    L49:
        c.e(r113);
        throw null;
    L54:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        if (StringsKt.startsWith$default(r110, "REMOVE", false, 2, null) == false) goto L14;
        this.f457294k.remove(r103);
        return true;
    L13:
        r103 = r110.substring(r111, r102);
        goto L14
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [V, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r5v4, types: [V, java.lang.Integer] */
    public final boolean q(String r110) {
        int r100 = 0;
        if (r110 == null) goto L37;
        c0.e r101 = this.f457290g;
        r101.a();
        g();     // Catch: Throwable -> L34
        c();     // Catch: Throwable -> L34
        if (s(r110) == false) goto L33;
        c r102 = this.f457294k.get(r110);     // Catch: Throwable -> L34
        if (r102 != null) goto L10;
    L30:
        r101.b();
        return false;
    L10:
        if (r102.f457312c.f1239a != null) goto L30;
        a0.b<Integer> r103 = this.f457288e;     // Catch: Throwable -> L34
        r103.f1239a = Integer.valueOf(r103.f1239a.intValue() + 1);     // Catch: Throwable -> L34
        i r104 = this.f457289f.f1239a;     // Catch: Throwable -> L34
        if (r104 == null) goto L15;
        r104.f21800a.append("REMOVE " + r110 + '\n');     // Catch: Throwable -> L34
    L15:
        i r105 = this.f457289f.f1239a;     // Catch: Throwable -> L34
        if (r105 == null) goto L18;
        r105.a();     // Catch: Throwable -> L34
    L18:
        this.f457294k.remove(r110);     // Catch: Throwable -> L34
        int r111 = this.f457299p;     // Catch: Throwable -> L34
    L19:
        if (r100 >= r111) goto L26;
        bytekn.foundation.io.file.f r106 = r102.a(r100);     // Catch: Throwable -> L34
        com.ss.ugc.effectplatform.util.i.f458038a.delete(r106);     // Catch: Exception -> L23 Throwable -> L34
        a0.b<Long> r107 = this.f457287d;     // Catch: Throwable -> L34
        r107.f1239a = Long.valueOf(r107.f1239a.longValue() - r102.f457310a.get(r100).longValue());     // Catch: Throwable -> L34
        r102.f457310a.set(r100, 0L);     // Catch: Throwable -> L34
        r100 = r100 + 1;     // Catch: Throwable -> L34
        goto L19
    L24:
        throw new Exception("failed to delete " + r106);     // Catch: Throwable -> L34
    L26:
        if (h() == false) goto L28;
        this.f457295l.execute(this.f457296m);     // Catch: Throwable -> L34
    L28:
        r101.b();
        return true;
    L33:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r110 + "\"");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r101.b();
        throw th;
    L37:
        return false;
    }

    /* JADX WARN: Type inference failed for: r12v6, types: [V, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r12v8, types: [V] */
    /* JADX WARN: Type inference failed for: r2v11, types: [V, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v3, types: [V, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v9, types: [V, java.lang.Long] */
    public static final void a(a r110, b r111, boolean r112) {
        c0.e r100 = r110.f457290g;
        r100.a();
        c r101 = r111.f457308d;     // Catch: Throwable -> L65
        if ((!Intrinsics.areEqual(r101.f457312c.f1239a, r111)) == true) goto L64;
        int r102 = 0;
        if (r112 == true) goto L8;
    L21:
        int r113 = r110.f457299p;     // Catch: Throwable -> L65
    L22:
        bytekn.foundation.io.file.d r103 = null;
        if (r102 >= r113) goto L42;
        bytekn.foundation.io.file.f r104 = r101.b(r102);     // Catch: Throwable -> L65
        if (r104 == null) goto L41;
        if (r112 == false) goto L40;
        String r105 = FileManager.f21782a;     // Catch: Throwable -> L65
        if (FileManager.c(r104) == false) goto L41;
        bytekn.foundation.io.file.f r106 = r101.a(r102);     // Catch: Throwable -> L65
        FileManager.p(r104, r106);     // Catch: Throwable -> L65
        long r107 = r101.f457310a.get(r102).longValue();     // Catch: Throwable -> L65
        if (r106 == null) goto L34;
        String r108 = r106.f21799b;     // Catch: Throwable -> L65
        if (r108 == null) goto L34;
        r103 = FileManager.a(new PolarisFileWrapper(r108));     // Catch: Throwable -> L65
    L34:
        if (r103 == null) goto L38;
        Long r109 = r103.f21795f;     // Catch: Throwable -> L65
        if (r109 == null) goto L38;
        long r114 = r109.longValue();     // Catch: Throwable -> L65
    L39:
        r101.f457310a.set(r102, Long.valueOf(r114));     // Catch: Throwable -> L65
        a0.b<Long> r115 = r110.f457287d;     // Catch: Throwable -> L65
        r115.f1239a = Long.valueOf((r115.f1239a.longValue() - r107) + r114);     // Catch: Throwable -> L65
    L38:
        r114 = 0;
        goto L39
    L40:
        com.ss.ugc.effectplatform.util.i.f458038a.delete(r104);     // Catch: Throwable -> L65
    L41:
        r102 = r102 + 1;     // Catch: Throwable -> L65
        goto L22
    L42:
        a0.b<Integer> r116 = r110.f457288e;     // Catch: Throwable -> L65
        r116.f1239a = Integer.valueOf(r116.f1239a.intValue() + 1);     // Catch: Throwable -> L65
        r101.f457312c.f1239a = null;     // Catch: Throwable -> L65
        if ((r101.f457311b.f1239a.booleanValue() | r112) == false) goto L49;
        r101.f457311b.f1239a = Boolean.TRUE;     // Catch: Throwable -> L65
        i r117 = r110.f457289f.f1239a;     // Catch: Throwable -> L65
        if (r117 == null) goto L47;
        r117.b("CLEAN " + r101.f457315f + r101.c() + '\n');     // Catch: Throwable -> L65
    L47:
        if (r112 == false) goto L52;
        a0.b<Long> r118 = r110.f457293j;     // Catch: Throwable -> L65
        r118.f1239a = Long.valueOf(r118.f1239a.longValue() + 1);     // Catch: Throwable -> L65
        r101.f457313d.f1239a = r110.f457293j.f1239a;     // Catch: Throwable -> L65
    L52:
        i r119 = r110.f457289f.f1239a;     // Catch: Throwable -> L65
        if (r119 == null) goto L56;
        r119.a();     // Catch: Throwable -> L65
    L56:
        if (r110.f457287d.f1239a.longValue() <= r110.f457300q) goto L58;
    L59:
        r110.f457295l.execute(r110.f457296m);     // Catch: Throwable -> L65
    L60:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L61:
        r100.b();
        return;
    L58:
        if (r110.h() == false) goto L60;
    L49:
        r110.f457294k.remove(r101.f457315f);     // Catch: Throwable -> L65
        i r121 = r110.f457289f.f1239a;     // Catch: Throwable -> L65
        if (r121 == null) goto L52;
        r121.b("REMOVE " + r101.f457315f + '\n');     // Catch: Throwable -> L65
        goto L52
    L8:
        if (r101.f457311b.f1239a.booleanValue() == true) goto L21;
        int r122 = r110.f457299p;     // Catch: Throwable -> L65
        int r123 = 0;
    L10:
        if (r123 >= r122) goto L21;
        if (r111.f457305a.f1239a[r123] == false) goto L19;
        if (r101.b(r123) == null) goto L18;
        String r124 = FileManager.f21782a;     // Catch: Throwable -> L65
        if (FileManager.c(r101.b(r123)) == true) goto L18;
        r111.a();     // Catch: Throwable -> L65
    L18:
        r123 = r123 + 1;     // Catch: Throwable -> L65
        goto L10
    L19:
        r111.a();     // Catch: Throwable -> L65
        throw new IllegalStateException("Newly created entry didn't create value for index " + r123);     // Catch: Throwable -> L65
    L64:
        throw new IllegalStateException();     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        r100.b();
        throw th;
    }

    public a(String r100, int r101, int r102, long r103, com.ss.ugc.effectplatform.cache.disklrucache.e r104, boolean r105, boolean r106, boolean r107) {
        this.f457297n = r100;
        this.f457298o = r101;
        this.f457299p = r102;
        this.f457300q = r103;
        this.f457301r = r104;
        this.f457302s = r105;
        this.f457303t = r106;
        this.f457304u = r107;
        this.f457287d = new a0.b(0L);
        this.f457288e = new a0.b(0);
        bytekn.foundation.io.file.f r108 = null;
        this.f457289f = new a0.b(null);
        this.f457290g = new c0.e();
        Boolean r109 = Boolean.FALSE;
        this.f457291h = new a0.b(r109);
        this.f457292i = new a0.b(r109);
        this.f457293j = new a0.b(0L);
        this.f457294k = new z.b(false);
        this.f457295l = new AsyncExecutor();
        this.f457296m = new e(this);
        if (r100 == null) goto L5;
        File r110 = new PolarisFileWrapper(r100).getAbsoluteFile();
    L6:
        if (r110 != null) goto L8;
        bytekn.foundation.io.file.f r111 = null;
    L9:
        if (r111 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        this.f457284a = r111;
        if (r100 == null) goto L14;
        File r112 = new PolarisFileWrapper(r100).getAbsoluteFile();
    L15:
        if (r112 != null) goto L17;
        bytekn.foundation.io.file.f r113 = null;
    L18:
        if (r113 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        this.f457285b = r113;
        if (r100 == null) goto L23;
        File r114 = new PolarisFileWrapper(r100).getAbsoluteFile();
    L24:
        if (r114 == null) goto L27;
        r108 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r114.getAbsolutePath(), "journal.bkp").getAbsoluteFile().getAbsolutePath());
    L27:
        if (r108 != null) goto L29;
        Intrinsics.throwNpe();
    L29:
        this.f457286c = r108;
        return;
    L23:
        r114 = null;
        goto L24
    L17:
        r113 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r112.getAbsolutePath(), "journal.tmp").getAbsoluteFile().getAbsolutePath());
        goto L18
    L14:
        r112 = null;
        goto L15
    L8:
        r111 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r110.getAbsolutePath(), "journal").getAbsoluteFile().getAbsolutePath());
        goto L9
    L5:
        r110 = null;
        goto L6
    }
}
