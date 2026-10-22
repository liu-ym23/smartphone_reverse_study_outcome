package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FunctorView;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.textra.TTText;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f380719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f380720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f380721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.lynx.clay.embedding.engine.loader.b f380722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlutterJNI f380723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Future<b> f380724f;

    public interface a {
        void a() throws UnsatisfiedLinkError;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f380725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f380726b;

        public b(String r100) {
            this.f380725a = "";
            this.f380726b = r100;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f380727a;

        public c() {
        }
    }

    public FlutterLoader() {
        FlutterJNI r100 = new FlutterJNI();
        this.f380719a = false;
        this.f380723e = r100;
    }

    public final JSONObject b() {
        String r100 = this.f380720b.f380727a;
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return null;
    L12:
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L9
        if (r101.has("clay") == false) goto L14;
        return JSONObjectProtectorUtils.getJSONObject(r101, "clay");
    L14:
        return null;
    L9:
        e = move-exception;
        c5a.c.b("FlutterLoader", "getClaySettings error", e);
        return null;
    }

    public FlutterJNI getFlutterJNI() {
        FlutterJNI r100 = this.f380723e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        FlutterJNI r101 = new FlutterJNI();
        this.f380723e = r101;
        return r101;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
    }

    public final synchronized void f(Context r100) {
        monitor-enter(this);
        Flipped.invokeHiddenApiRestrictions();     // Catch: Throwable -> L12
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L12
        JSONObject r102 = b();     // Catch: Throwable -> L12
        this.f380721c = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.f380722d = com.lynx.clay.embedding.engine.loader.a.a(r101);     // Catch: Throwable -> L12
        FlutterJNI.setAsyncWaitForVsyncDelegate(w5a.a.a((DisplayManager) r101.getSystemService("display"), this.f380723e).f558370c);     // Catch: Throwable -> L12
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        com.lynx.clay.embedding.engine.loader.c r104 = new com.lynx.clay.embedding.engine.loader.c(this, r100, r102);     // Catch: Throwable -> L12
        this.f380724f = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("FlutterLoader")).submit(r104);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L9:
        this.f380724f = CompletableFuture.completedFuture(d(r100, this.f380723e, r102));     // Catch: Throwable -> L12
        goto L10
    L6:
        r103 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(Context r210, String[] r211) {
        monitor-enter(this);
        TraceEvent.beginSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
    L49:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L6:
        if (this.f380719a == false) goto L11;
        TraceEvent.endSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L48;
        if (this.f380720b == null) goto L46;
    L42:
        e = move-exception;
        c5a.c.b("FlutterLoader", "Flutter initialization failed.", e);     // Catch: Throwable -> L49
        throw new RuntimeException(e);     // Catch: Throwable -> L49
    L15:
        if (this.f380724f != null) goto L17;
        c5a.c.d(6, "FlutterLoader", "FlutterLoader#startInitialization has not finished yet");     // Catch: Exception -> L42 Throwable -> L49
        f(r210);     // Catch: Exception -> L42 Throwable -> L49
    L17:
        b r100 = this.f380724f.get();     // Catch: Exception -> L42 Throwable -> L49
        w5a.a.b r101 = w5a.a.f558367g;     // Catch: Exception -> L42 Throwable -> L49
        if (r101 == null) goto L20;
        r101.a();     // Catch: Exception -> L42 Throwable -> L49
    L20:
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L42 Throwable -> L49
        r102.add("--icu-symbol-prefix=_binary_icudtl_dat");     // Catch: Exception -> L42 Throwable -> L49
        r102.add("--icu-native-lib-path=" + this.f380722d.f380745c + File.separator + "libclay.so");     // Catch: Exception -> L42 Throwable -> L49
        if (r211 == null) goto L23;
        Collections.addAll(r102, r211);     // Catch: Exception -> L42 Throwable -> L49
    L23:
        int r103 = r210.getResources().getConfiguration().uiMode & 15;     // Catch: Exception -> L42 Throwable -> L49
        if (r103 != 1) goto L26;
        r102.add("--enable-stencil-buffer");     // Catch: Exception -> L42 Throwable -> L49
        r102.add("--gpu-cache-multiplier=12");     // Catch: Exception -> L42 Throwable -> L49
    L30:
        r102.add("--cache-dir-path=" + r100.f380726b);     // Catch: Exception -> L42 Throwable -> L49
        if (this.f380722d.f380744b == null) goto L33;
        r102.add("--domain-network-policy=" + this.f380722d.f380744b);     // Catch: Exception -> L42 Throwable -> L49
    L33:
        Bundle r104 = r210.getPackageManager().getApplicationInfo(r210.getPackageName(), 128).metaData;     // Catch: Exception -> L42 Throwable -> L49
        if (r104 != null) goto L36;
    L38:
        this.f380723e.init(r210, (String[]) r102.toArray(new String[0]), null, r100.f380725a, r100.f380726b, SystemClock.uptimeMillis() - this.f380721c);     // Catch: Exception -> L42 Throwable -> L49
        this.f380719a = true;     // Catch: Exception -> L42 Throwable -> L49
        TraceEvent.endSection("clay", "FlutterLoader.EnsureInitializationComplete");     // Catch: Throwable -> L52
        monitor-exit(this);
        return;
    L36:
        if (r104.getBoolean("com.lynx.clay.embedding.android.EnableSkParagraph") == false) goto L38;
        r102.add("--enable-skparagraph");     // Catch: Exception -> L42 Throwable -> L49
        goto L38
    L26:
        if (r103 == 4) goto L28;
        c5a.c.d(6, "FlutterLoader", "Unknow ui mode? mode=" + r103);     // Catch: Exception -> L42 Throwable -> L49
        goto L30
    L28:
        r102.add("--gpu-cache-multiplier=1");     // Catch: Exception -> L42 Throwable -> L49
        goto L30
    L46:
        throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");     // Catch: Throwable -> L49
    L48:
        throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");     // Catch: Throwable -> L49
    L52:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(Context r100, c r101) {
        monitor-enter(this);
        TraceEvent.beginSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L5:
        if (this.f380720b == null) goto L10;
        TraceEvent.instant("clay", "FlutterLoader.StartInitializationSkipped");     // Catch: Throwable -> L14
        TraceEvent.endSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        this.f380720b = r101;     // Catch: Throwable -> L14
        f(r100);     // Catch: Throwable -> L14
        TraceEvent.endSection("clay", "FlutterLoader.StartInitialization");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static b d(Context r100, FlutterJNI r101, JSONObject r102) {
        TraceEvent.beginSection("clay", "FlutterLoader.PerformInnerInitializationTasks");
        TraceEvent.beginSection("clay", "FlutterLoader.LoadLibrary");     // Catch: Throwable -> L41
        r101.loadLibrary(null);     // Catch: Throwable -> L38
        TraceEvent.endSection("clay", "FlutterLoader.LoadLibrary");     // Catch: Throwable -> L41
        boolean r103 = false;
        c("kryptoni18n");     // Catch: RuntimeException -> L12 UnsatisfiedLinkError -> L14 Throwable -> L41
        c("tttext_lite");     // Catch: RuntimeException -> L12 UnsatisfiedLinkError -> L14 Throwable -> L41
        if (TTText.PreloadSelfRendering(false) == true) goto L16;
        c5a.c.d(6, "FlutterLoader", "TTText self-rendering preload failed.");     // Catch: RuntimeException -> L12 UnsatisfiedLinkError -> L14 Throwable -> L41
    L16:
        r101.updateRefreshRate();     // Catch: Throwable -> L41
        FunctorView.f();     // Catch: Throwable -> L41
        if (r102 == null) goto L24;
        String r104 = r102.optString("disablePrefetchDefaultFontManager", "");     // Catch: Throwable -> L41
        if ("1".equals(r104) == false) goto L22;
    L23:
        r103 = true;
        goto L24
    L22:
        if ("true".equalsIgnoreCase(r104) == true) goto L23;
    L24:
        if (r103 == true) goto L44;
        TraceEvent.beginSection("clay", "FlutterLoader.PrefetchDefaultFontManager");     // Catch: Throwable -> L41
        r101.prefetchDefaultFontManager();     // Catch: Throwable -> L28
        TraceEvent.endSection("clay", "FlutterLoader.PrefetchDefaultFontManager");     // Catch: Throwable -> L41
        goto L44
    L28:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.PrefetchDefaultFontManager");     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L44:
        String r105 = r100.getCodeCacheDir().getPath();     // Catch: Exception -> L34 Throwable -> L41
    L35:
        b r106 = new b(r105);     // Catch: Throwable -> L41
        TraceEvent.endSection("clay", "FlutterLoader.PerformInnerInitializationTasks");
        return r106;
    L34:
        r105 = r100.getCacheDir().getPath();     // Catch: Throwable -> L41
    L12:
        e = move-exception;
        c5a.c.b("FlutterLoader", "Skip TTText self-rendering preload because native library load failed.", e);     // Catch: Throwable -> L41
    L14:
        e = move-exception;
        c5a.c.b("FlutterLoader", "Skip TTText self-rendering preload because native libraries are unavailable.", e);     // Catch: Throwable -> L41
        goto L16
    L38:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.LoadLibrary");     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        TraceEvent.endSection("clay", "FlutterLoader.PerformInnerInitializationTasks");
        throw th;
    }
}
