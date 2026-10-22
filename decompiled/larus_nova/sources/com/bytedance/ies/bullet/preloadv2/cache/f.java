package com.bytedance.ies.bullet.preloadv2.cache;

import android.os.Handler;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f247704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f247706c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f247707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f247708b;

        public a(f r100, String r101) {
            this.f247707a = r100;
            this.f247708b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f247707a.h(this.f247708b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f247709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PreloadItem f247710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f247711c;

        public b(boolean r100, PreloadItem r101, f r102) {
            this.f247709a = r100;
            this.f247710b = r101;
            this.f247711c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        L18:
            return;
        L3:
            if (this.f247709a == false) goto L7;
            String r100 = this.f247710b.f247688n;     // Catch: Throwable -> L11
            if (r100 == null) goto L7;
        L8:
            if (r100 == null) goto L14;
            this.f247711c.h(r100);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L7:
            r100 = this.f247710b.d();     // Catch: Throwable -> L11
            goto L8
        }
    }

    public g b(int r100) {
        throw null;
    }

    public f(int r100) {
        g r101 = b(r100);
        this.f247704a = r101;
        this.f247705b = r101.f247712a;
        this.f247706c = true;
    }

    public final boolean a(long r100) {
        if ((((long) this.f247704a.size()) + r100) > this.f247704a.maxSize()) goto L5;
        return true;
    L5:
        return false;
    }

    public final synchronized PreloadItem c(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L29
        PreloadItem r101 = null;
        if (this.f247706c == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        int r102 = m26.f.f511670a;     // Catch: Throwable -> L29
        m26.f.a("获取缓存 " + this.f247705b + ", " + r100);     // Catch: Throwable -> L29
        PreloadItem r103 = this.f247704a.get(r100);     // Catch: Throwable -> L29
        if (r103 != null) goto L12;
    L27:
        monitor-exit(this);
        return r101;
    L12:
        if (r103.a() == false) goto L26;
        d1 r104 = r103.f247686l;     // Catch: Throwable -> L29
        if (r104 != null) goto L16;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == false) goto L26;
        int r106 = m26.f.f511670a;     // Catch: Throwable -> L29
        m26.f.c("获取成功 " + this.f247705b + ", " + r100);     // Catch: Throwable -> L29
        r101 = r103;
        goto L27
    L16:
        if (r103.f247687m == null) goto L23;
        if (r104.getType() == ResourceType.DISK) goto L34;
        r105 = true;
        goto L24
    L34:
        r105 = new PolarisFileWrapper(r103.f247687m).exists();     // Catch: Throwable -> L32
    L26:
        h(r100);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(int r110) {
        monitor-enter(this);
        this.f247704a.evictAll();     // Catch: Throwable -> L5
    L9:
        if (r110 > 0) goto L11;
        this.f247706c = false;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        this.f247704a = b(r110);     // Catch: Throwable -> L14
        goto L12
    L5:
        th = move-exception;
        ExecutorService r100 = BulletLogger.f247763a;     // Catch: Throwable -> L14
        BulletLogger.l(th, "PreloadCache reSize", "PreloadV2");     // Catch: Throwable -> L14
        s26.d r101 = s26.d.f540305c;     // Catch: Throwable -> L14
        r r102 = (r) s26.d.f540305c.c(r.class);     // Catch: Throwable -> L14
        if (r102 == null) goto L9;
        c1 r103 = new c1("bdx_preload_cache_fail", null, null, null, null, 254);     // Catch: Throwable -> L14
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L14
        r104.put("cacheName", this.f247704a.f247712a);     // Catch: Throwable -> L14
        r104.put("updateSize", r110);     // Catch: Throwable -> L14
        r104.put("lruCacheSize", this.f247704a.size());     // Catch: Throwable -> L14
        r104.put("lruMapSize", this.f247704a.snapshot().size());     // Catch: Throwable -> L14
        r103.f247794d = r104;     // Catch: Throwable -> L14
        r102.S(r103);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L10
        if (this.f247706c == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f247704a.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void d(PreloadItem r100, boolean r101) {
        if (r100.f247679e == true) goto L5;
    L7:
        boolean r102 = true;
        if (com.bytedance.ies.bullet.base.settings.c.a().g() != 1) goto L22;
        if (r101 == false) goto L13;
        String r103 = r100.f247688n;
        if (r103 == null) goto L13;
    L14:
        if (r103 != null) goto L16;
    L19:
        if (r102 == false) goto L21;
        return;
    L21:
        long r104 = r100.f247680f;
        ((Handler) PreloadCacheKt.f247673a.getValue()).postDelayed(new a(this, r103), r104);
        return;
    L16:
        if (r103.length() == 0) goto L19;
        r102 = false;
    L13:
        r103 = r100.d();
        goto L14
    L22:
        ((Handler) PreloadCacheKt.f247673a.getValue()).postDelayed(new b(r101, r100, this), r100.f247680f);
        return;
    L5:
        if (r100.f247680f != 600001) goto L7;
    }

    public final synchronized boolean e(PreloadItem r100, boolean r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "cache");     // Catch: Throwable -> L23
        if (this.f247706c == true) goto L8;
        r100.b();     // Catch: Throwable -> L23
        monitor-exit(this);
        return false;
    L8:
        if (r101 == false) goto L12;
        String r102 = r100.f247688n;     // Catch: Throwable -> L23
        if (r102 == null) goto L12;
    L13:
        if (r102 != null) goto L15;
    L19:
        d(r100, r101);     // Catch: Throwable -> L23
        monitor-exit(this);
        return true;
    L15:
        if (f(r102, r100) == true) goto L19;
        r100.b();     // Catch: Throwable -> L23
        monitor-exit(this);
        return false;
    L12:
        r102 = r100.d();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean f(String r100, PreloadItem r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r101, "cache");     // Catch: Throwable -> L20
        if (this.f247706c == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        PreloadItem r102 = this.f247704a.get(r100);     // Catch: Throwable -> L20
        if (r102 != null) goto L12;
    L16:
        int r103 = m26.f.f511670a;     // Catch: Throwable -> L20
        m26.f.c("放入缓存 " + this.f247705b + ", size " + this.f247704a.size() + ", maxSize " + this.f247704a.maxSize() + ", " + r101.getType().getTag() + ' ' + r100);     // Catch: Throwable -> L20
        this.f247704a.put(r100, r101);     // Catch: Throwable -> L20
        monitor-exit(this);
        return true;
    L12:
        if (r102.a() == false) goto L16;
        int r104 = m26.f.f511670a;     // Catch: Throwable -> L20
        m26.f.c("已有缓存 " + this.f247705b + ", size " + this.f247704a.size() + ", maxSize " + this.f247704a.maxSize() + ", " + r101.getType().getTag() + ' ' + r100);     // Catch: Throwable -> L20
        monitor-exit(this);
        return false;
    L20:
        th = move-exception;
        throw th;
    }
}
