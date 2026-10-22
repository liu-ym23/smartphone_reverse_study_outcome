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
import kotlinx.coroutines.sync.b;
import mqc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class PreInstallTask {
    public static final MutexImpl e = null;
    public static Job f;
    public static final AtomicBoolean g = null;
    public static final Lazy h = null;
    public static final Companion i = null;
    public final CoroutineScope a;
    public final String b;
    public final long c;
    public final a d;

    public static final class Companion {
        public Companion() {
        }

        public static void a() {
            ZeusLogger.i("ZeusPreInstallTask", "clearAllPreInstallData");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
            List r3 = b();     // Catch: Throwable -> L12
            ZeusLogger.i("ZeusPreInstallTask", "preInstallDirSize = " + r3.size());     // Catch: Throwable -> L12
            Iterator r0 = r3.iterator();     // Catch: Throwable -> L12
            int r4 = 0;
        L5:
            if (r0.hasNext() == false) goto L10;
            Object r5 = r0.next();     // Catch: Throwable -> L12
            int r6 = r4 + 1;     // Catch: Throwable -> L12
            if (r4 >= 0) goto L9;
            CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L12
        L9:
            File r7 = (File) r5;     // Catch: Throwable -> L12
            ZeusLogger.d("ZeusPreInstallTask", "delete index: " + r4 + " path: " + r7.getAbsolutePath());     // Catch: Throwable -> L12
            i.e(r7);     // Catch: Throwable -> L12
            r4 = r6;
            goto L5
        L10:
            Lazy r1 = ZeusPreInstallSpUtil.a;     // Catch: Throwable -> L12
            ZeusLogger.i("ZeusPreInstallSpUtil", "clearAll");     // Catch: Throwable -> L12
            ZeusPreInstallSpUtil.a().edit().clear().apply();     // Catch: Throwable -> L12
            Object r8 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r9 = Result.m52exceptionOrNullimpl(r8);
            if (r9 == null) goto L23;
            ZeusLogger.w("ZeusPreInstallTask", "clearAllPreInstallData failed: " + r9.getMessage(), r9);
            return;
        L23:
            return;
        L12:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.m49constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        public static List b() {
            c.k();
            PolarisFileWrapper r0 = new PolarisFileWrapper(c.a.getPath());
            Regex r1 = new Regex("^preversion-(\\d+)$");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
            File[] r3 = r0.listFiles();     // Catch: Throwable -> L29
            if (r3 == null) goto L23;
            List r4 = ArraysKt.toList(r3);     // Catch: Throwable -> L29
            if (r4 == null) goto L23;
            ArrayList r5 = new ArrayList();     // Catch: Throwable -> L29
            Iterator r6 = r4.iterator();     // Catch: Throwable -> L29
        L9:
            if (r6.hasNext() == false) goto L17;
            File[] r7 = ((File) r6.next()).listFiles();     // Catch: Throwable -> L29
            if (r7 == null) goto L15;
            List r8 = ArraysKt.toList(r7);     // Catch: Throwable -> L29
            if (r8 == null) goto L15;
        L16:
            CollectionsKt.addAll(r5, r8);     // Catch: Throwable -> L29
        L15:
            r8 = CollectionsKt.emptyList();     // Catch: Throwable -> L29
            goto L16
        L17:
            ArrayList r9 = new ArrayList();     // Catch: Throwable -> L29
            Iterator r10 = r5.iterator();     // Catch: Throwable -> L29
        L19:
            if (r10.hasNext() == false) goto L24;
            Object r11 = r10.next();     // Catch: Throwable -> L29
            if (r1.matches(((File) r11).getName()) == false) goto L19;
            r9.add(r11);     // Catch: Throwable -> L29
        L24:
            if (r9 == null) goto L26;
            List r12 = r9;
        L27:
            Object r13 = Result.m49constructorimpl(r12);     // Catch: Throwable -> L29
        L31:
            Throwable r14 = Result.m52exceptionOrNullimpl(r13);
            if (r14 == null) goto L34;
            ZeusLogger.w("ZeusPreInstallTask", "getPreInstalledDirs failed: " + r14.getMessage(), r14);
        L34:
            List r15 = CollectionsKt.emptyList();
            if (Result.m55isFailureimpl(r13) == false) goto L38;
            r13 = r15;
        L38:
            return (List) r13;
        L26:
            r12 = CollectionsKt.emptyList();     // Catch: Throwable -> L29
        L23:
            r9 = null;
        L29:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r13 = Result.m49constructorimpl(ResultKt.createFailure(th));
            goto L31
        }

        public static void c() {
            if (d.d(Zeus.getAppApplication()) == true) goto L6;
            ZeusLogger.i("ZeusPreInstallTask", "scheduledExpiredDataCleanup: is not main process, return");
            return;
        L6:
            Job r0 = PreInstallTask.f;
            if (r0 == null) goto L9;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L9:
            Job r1 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new scheduledExpiredDataCleanup.1(null), 3, null);
            r1.invokeOnCompletion(new scheduledExpiredDataCleanup.2.1(r1));
            PreInstallTask.f = r1;
        }
    }

    static {
        i = new Companion();
        e = b.a();
        g = new AtomicBoolean(false);
        h = LazyKt.lazy(PreInstallTask$Companion$curVersionCode$2.INSTANCE);
    }

    public final Object a(Continuation<? super Unit> r9) {
        ZeusLogger.i("ZeusPreInstallTask", "preInstall: hostApkPath: " + this.b + ", timeoutMS: " + this.c);
        Object r10 = BuildersKt.async$default(this.a, null, null, new preInstall.2(this, null), 3, null).await(r9);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public PreInstallTask(String r2, long r3, a r5) {
        Intrinsics.checkNotNullParameter(r2, "hostApkPath");
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        ZeusLogger.i("ZeusPreInstallTask", "create PreInstallTask, hostApkPath: " + r2 + ", timeoutMS: " + r3);
    }
}
