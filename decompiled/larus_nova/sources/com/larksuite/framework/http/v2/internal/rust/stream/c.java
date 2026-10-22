package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.lynx.tasm.LynxError;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f285621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileOutputStreamWrapper f285622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f285623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<Throwable> f285624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f285625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FileInputStream f285626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f285627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f285628h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set<String> f285629b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f285630a;

        public static final class a {
        }

        static {
            f285629b = Collections.synchronizedSet(new LinkedHashSet());
        }

        public b() {
            String r100 = System.getProperty("java.io.tmpdir");
            if (r100 != null) goto L5;
            r100 = ".";
        L5:
            this.f285630a = new PolarisFileWrapper(r100);
        }

        public final c a(h r110) {
            Intrinsics.checkNotNullParameter(r110, "key");
            if (this.f285630a.exists() == true) goto L5;
            this.f285630a.mkdirs();
        L5:
            File r100 = this.f285630a;
            Set<String> r101 = f285629b;
            String r102 = r100.getCanonicalPath();     // Catch: IOException -> L8
            Intrinsics.checkNotNull(r102);     // Catch: IOException -> L8
        L10:
            if (r101.add(r102) == false) goto L21;
            File[] r103 = r100.listFiles();
            if (r103 == null) goto L21;
            int r104 = r103.length;
            int r105 = 0;
        L14:
            if (r105 >= r104) goto L21;
            File r106 = r103[r105];
            if (r106.isFile() == false) goto L20;
            if (StringsKt.startsWith$default(r106.getName(), "okhttp-request-body-cache-", false, 2, null) == false) goto L20;
            r106.delete();
        L20:
            r105 = r105 + 1;
        L21:
            File r107 = this.f285630a;
            StringBuilder r108 = new StringBuilder("okhttp-request-body-cache-");
            byte[] r109 = MessageDigest.getInstance("SHA-256").digest((r110.f285654a + '\n' + r110.f285655b).getBytes(Charsets.UTF_8));
            Intrinsics.checkNotNull(r109);
            r108.append(ArraysKt.joinToString$default(r109, "", null, null, 0, null, FileRequestBodyCache$Factory$hash$1.INSTANCE, 30, null));
            r108.append(DefaultDiskStorage.FileType.TEMP);
            return new c(new PolarisFileWrapper(r107, r108.toString()));
        L8:
            r102 = r100.getAbsolutePath();
            Intrinsics.checkNotNull(r102);
            goto L10
        }
    }

    static {
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final void clean() {
        FileInputStream r100 = this.f285626f;     // Catch: Throwable -> L7 IOException -> L12
        if (r100 == null) goto L10;
        r100.close();     // Catch: Throwable -> L7 IOException -> L12
    L7:
        th = move-exception;
        this.f285626f = null;
        throw th;
    L10:
        this.f285626f = null;
        this.f285621a.delete();
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final d a() {
        return this.f285627g;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final e source() {
        return this.f285628h;
    }

    public c(PolarisFileWrapper r100) {
        this.f285621a = r100;
        this.f285622b = new PolarisFileOutputStreamWrapper(r100);
        this.f285623c = new CountDownLatch(1);
        this.f285624d = new AtomicReference();
        this.f285625e = new AtomicBoolean(false);
        this.f285627g = new d(this);
        this.f285628h = new e(this);
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final void b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        AtomicReference<Throwable> r101 = this.f285624d;
    L4:
        if (r101.compareAndSet(null, r100) == true) goto L9;
        if (r101.get() == null) goto L4;
    L9:
        if (this.f285625e.compareAndSet(false, true) == false) goto L30;
        PolarisFileOutputStreamWrapper r102 = this.f285622b;     // Catch: Throwable -> L18 IOException -> L23
        monitor-enter(r102);     // Catch: Throwable -> L18 IOException -> L23
        this.f285622b.close();     // Catch: Throwable -> L15
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L18 IOException -> L23
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18 IOException -> L23
    L18:
        th = move-exception;
        this.f285623c.countDown();
        throw th;
    L21:
        this.f285623c.countDown();
        return;
    }
}
