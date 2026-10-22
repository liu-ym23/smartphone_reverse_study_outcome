package uy5;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import ez5.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile PolarisFileWrapper f552129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Long f552130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile b f552131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f552132g;

    public final void c() throws Throwable {
        if (this.f552131f == null) goto L5;
        this.f552131f.getClass();
    L5:
        AppSettingsManager.IGeckoAppSettings r100 = AppSettingsManager.b.f245071a.b();
        if (r100 == null) goto L12;
        if (r100.ignoreLock() == false) goto L12;
        x86.a.e(this.f552127b + File.separator + this.f552128c, null);
        return;
    L12:
        if (this.f552132g.compareAndSet(true, false) == false) goto L15;
        String r101 = this.f552127b + File.separator + this.f552128c;
        vy5.b.d(r101);
        x86.a.e(r101, null);
        return;
    }

    public final void finalize() throws Throwable {
        super.finalize();
        GeckoLogger.d("channel loader finalize lock");
        c();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        GeckoLogger.w("finalize:", th);
    }

    public final synchronized File a(String r100) throws Throwable {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.f552129d == null) goto L9;
        PolarisFileWrapper r101 = this.f552129d;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r101;
    L9:
        if (this.f552130e != null) goto L13;
        this.f552130e = f.c(new PolarisFileWrapper(this.f552127b, r100));     // Catch: Throwable -> L30
    L13:
        if (this.f552130e != null) goto L16;
        monitor-exit(this);
        return null;
    L16:
        String r102 = this.f552127b + File.separator + this.f552128c;     // Catch: Throwable -> L30
        AppSettingsManager.IGeckoAppSettings r103 = AppSettingsManager.b.f245071a.b();     // Catch: Throwable -> L30
        if (r103 != null) goto L19;
    L23:
        this.f552132g.set(vy5.b.c(r102));     // Catch: Throwable -> L30
        if (this.f552132g.get() == false) goto L28;
        this.f552129d = new PolarisFileWrapper(r102, String.valueOf(this.f552130e));     // Catch: Throwable -> L30
        PolarisFileWrapper r104 = this.f552129d;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r104;
    L28:
        monitor-exit(this);
        return null;
    L19:
        if (r103.ignoreLock() == false) goto L23;
        this.f552129d = new PolarisFileWrapper(r102, String.valueOf(this.f552130e));     // Catch: Throwable -> L30
        PolarisFileWrapper r105 = this.f552129d;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r105;
    }

    public final synchronized b b(boolean r100, String r101) throws Throwable {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.f552131f == null) goto L9;
        b r102 = this.f552131f;     // Catch: Throwable -> L27
        monitor-exit(this);
        return r102;
    L9:
        File r103 = a(r101);     // Catch: Throwable -> L27
        if (r103 != null) goto L15;
        if (r100 == false) goto L14;
        com.bytedance.iesgurd.loader.a r104 = com.bytedance.iesgurd.loader.a.f250751a;     // Catch: Throwable -> L27
        String r105 = this.f552126a;     // Catch: Throwable -> L27
        r104.getClass();     // Catch: Throwable -> L27
        com.bytedance.iesgurd.loader.a.b(r105, r101, null, "1");     // Catch: Throwable -> L27
    L14:
        throw new FileNotFoundException("channel no exist，channel:" + r101);     // Catch: Throwable -> L27
    L15:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r103, "res");     // Catch: Throwable -> L27
        if (r106.exists() == false) goto L26;
        if (r106.isDirectory() == false) goto L26;
        this.f552131f = new b(r103);     // Catch: Throwable -> L27
        this.f552131f.f552134b = this.f552126a;     // Catch: Throwable -> L27
        this.f552131f.f552135c = r101;     // Catch: Throwable -> L27
        if (r100 == false) goto L22;
        String r107 = r103.getName();     // Catch: Throwable -> L27
        com.bytedance.iesgurd.loader.a r108 = com.bytedance.iesgurd.loader.a.f250751a;     // Catch: Throwable -> L27
        String r109 = this.f552126a;     // Catch: Throwable -> L27
        Long r110 = Long.valueOf(CastLongProtector.parseLong(r107));     // Catch: Throwable -> L27
        r108.getClass();     // Catch: Throwable -> L27
        com.bytedance.iesgurd.loader.a.b(r109, r101, r110, "1");     // Catch: Throwable -> L27
    L22:
        b r111 = this.f552131f;     // Catch: Throwable -> L27
        monitor-exit(this);
        return r111;
    L26:
        throw new RuntimeException("can not find res, dir:" + r103.getAbsolutePath());     // Catch: Throwable -> L27
    }

    public a(String r100, String r101, String r102) {
        this.f552132g = new AtomicBoolean(false);
        this.f552126a = r100;
        this.f552127b = r101;
        this.f552128c = r102;
    }
}
