package com.volcengine.zeus.plugin.preinstall;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import dqc.c;
import dqc.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import mqc.i;

/* JADX INFO: loaded from: classes.dex */
public final class PreInstallTask {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MutexImpl f462811e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f462812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f462813g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f462814h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f462815i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f462816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f462817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f462818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f462819d;

    public static final class Companion {
        public Companion() {
        }

        public static void a() {
            ZeusLogger.i("ZeusPreInstallTask", "clearAllPreInstallData");
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
            List r101 = b();     // Catch: Throwable -> L12
            ZeusLogger.i("ZeusPreInstallTask", "preInstallDirSize = " + r101.size());     // Catch: Throwable -> L12
            Iterator r102 = r101.iterator();     // Catch: Throwable -> L12
            int r103 = 0;
        L5:
            if (r102.hasNext() == false) goto L10;
            Object r104 = r102.next();     // Catch: Throwable -> L12
            int r105 = r103 + 1;     // Catch: Throwable -> L12
            if (r103 >= 0) goto L9;
            CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L12
        L9:
            File r106 = (File) r104;     // Catch: Throwable -> L12
            ZeusLogger.d("ZeusPreInstallTask", "delete index: " + r103 + " path: " + r106.getAbsolutePath());     // Catch: Throwable -> L12
            i.e(r106);     // Catch: Throwable -> L12
            r103 = r105;
            goto L5
        L10:
            Lazy r107 = ZeusPreInstallSpUtil.f462821a;     // Catch: Throwable -> L12
            ZeusLogger.i("ZeusPreInstallSpUtil", "clearAll");     // Catch: Throwable -> L12
            ZeusPreInstallSpUtil.a().edit().clear().apply();     // Catch: Throwable -> L12
            Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
            if (r109 == null) goto L23;
            ZeusLogger.w("ZeusPreInstallTask", "clearAllPreInstallData failed: " + r109.getMessage(), r109);
            return;
        L23:
            return;
        L12:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        public static List b() {
            c.k();
            PolarisFileWrapper r100 = new PolarisFileWrapper(c.f469730a.getPath());
            Regex r101 = new Regex("^preversion-(\\d+)$");
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L29
            File[] r103 = r100.listFiles();     // Catch: Throwable -> L29
            if (r103 == null) goto L23;
            List r104 = ArraysKt.toList(r103);     // Catch: Throwable -> L29
            if (r104 == null) goto L23;
            ArrayList r105 = new ArrayList();     // Catch: Throwable -> L29
            Iterator r106 = r104.iterator();     // Catch: Throwable -> L29
        L9:
            if (r106.hasNext() == false) goto L17;
            File[] r107 = ((File) r106.next()).listFiles();     // Catch: Throwable -> L29
            if (r107 == null) goto L15;
            List r108 = ArraysKt.toList(r107);     // Catch: Throwable -> L29
            if (r108 == null) goto L15;
        L16:
            CollectionsKt.addAll(r105, r108);     // Catch: Throwable -> L29
        L15:
            r108 = CollectionsKt.emptyList();     // Catch: Throwable -> L29
            goto L16
        L17:
            ArrayList r109 = new ArrayList();     // Catch: Throwable -> L29
            Iterator r110 = r105.iterator();     // Catch: Throwable -> L29
        L19:
            if (r110.hasNext() == false) goto L24;
            Object r111 = r110.next();     // Catch: Throwable -> L29
            if (r101.matches(((File) r111).getName()) == false) goto L19;
            r109.add(r111);     // Catch: Throwable -> L29
        L24:
            if (r109 == null) goto L26;
            List r112 = r109;
        L27:
            Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L29
        L31:
            Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
            if (r114 == null) goto L34;
            ZeusLogger.w("ZeusPreInstallTask", "getPreInstalledDirs failed: " + r114.getMessage(), r114);
        L34:
            List r115 = CollectionsKt.emptyList();
            if (Result.m9455isFailureimpl(r113) == false) goto L38;
            r113 = r115;
        L38:
            return (List) r113;
        L26:
            r112 = CollectionsKt.emptyList();     // Catch: Throwable -> L29
        L23:
            r109 = null;
        L29:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L31
        }

        public static void c() {
            if (d.d(Zeus.getAppApplication()) == true) goto L6;
            ZeusLogger.i("ZeusPreInstallTask", "scheduledExpiredDataCleanup: is not main process, return");
            return;
        L6:
            Job r100 = PreInstallTask.f462812f;
            if (r100 == null) goto L9;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L9:
            final Job r101 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PreInstallTask$Companion$scheduledExpiredDataCleanup$1(null), 3, null);
            r101.invokeOnCompletion(new PreInstallTask$Companion$scheduledExpiredDataCleanup$2$1(r101));
            PreInstallTask.f462812f = r101;
        }
    }

    static {
        f462815i = new Companion();
        f462811e = kotlinx.coroutines.sync.b.a();
        f462813g = new AtomicBoolean(false);
        f462814h = LazyKt.lazy(PreInstallTask$Companion$curVersionCode$2.INSTANCE);
    }

    public final Object a(Continuation<? super Unit> r100) {
        ZeusLogger.i("ZeusPreInstallTask", "preInstall: hostApkPath: " + this.f462817b + ", timeoutMS: " + this.f462818c);
        Object r101 = BuildersKt.async$default(this.f462816a, null, null, new PreInstallTask$preInstall$2(this, null), 3, null).await(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public PreInstallTask(String r100, long r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "hostApkPath");
        this.f462817b = r100;
        this.f462818c = r101;
        this.f462819d = r102;
        this.f462816a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        ZeusLogger.i("ZeusPreInstallTask", "create PreInstallTask, hostApkPath: " + r100 + ", timeoutMS: " + r101);
    }
}
