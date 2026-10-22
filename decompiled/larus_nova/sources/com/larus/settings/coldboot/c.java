package com.larus.settings.coldboot;

import android.content.Context;
import androidx.collection.SieveCacheKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.settings.value.e10;
import com.larus.settings.value.me;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.RandomAccessFile;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import qt9.c2;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f368540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EarlyFileSettingsStore.Key f368541b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EarlyFileSettingsStore.Key f368542c = null;

    public c() {
    }

    static {
        f368540a = new c();
        f368541b = EarlyFileSettingsStore.Key.KEVA_INDEPENDENT_EXECUTOR_OPT;
        f368542c = EarlyFileSettingsStore.Key.KEVA_EXECUTOR_CORE_POOL_SIZE;
    }

    public static void b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r100 = false;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        e10 r102 = e10.f368561a;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((c2) l0.a(new c2(0), new me()));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        FLogger.f375446a.e("KevaExecutorConfigStore", "read settings failed, use disabled config", r104);
    L10:
        c2 r105 = new c2(0);
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = r105;
    L13:
        c2 r106 = (c2) r103;
        boolean r107 = r106.c();
        EarlyFileSettingsStore.Key r108 = f368541b;
        if (EarlyFileSettingsStore.d(r110, r108, r107) == true) goto L16;
        Objects.toString(r108);
    L16:
        if (r107 == false) goto L52;
        int r109 = Runtime.getRuntime().availableProcessors() * 2;
        int r111 = r106.e();
        Integer r112 = Integer.valueOf(r111);
        if (r112 == null) goto L27;
        int r113 = r112.intValue();
        if (1 <= r113) goto L22;
    L24:
        boolean r114 = false;
    L25:
        if (r114 == false) goto L27;
    L29:
        if (r112 == null) goto L49;
        FLogger.f375446a.i("KevaExecutorConfigStore", "persist executor core pool size=" + r112 + ", defaultCorePoolSize=" + r109);
        EarlyFileSettingsStore.Key r115 = f368542c;
        int r116 = r112.intValue();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "key");
        if (r116 > 0) goto L61;
        r100 = EarlyFileSettingsStore.a(r110, r115);
    L50:
        if (r100 == true) goto L55;
        FLogger.f375446a.e("KevaExecutorConfigStore", "setCorePoolSize failed, corePoolSize=" + r111);
    L55:
        FLogger.f375446a.i("KevaExecutorConfigStore", "updateFromSettings settingsConfig=" + r106);
        return;
    L61:
        PolarisFileWrapper r117 = new PolarisFileWrapper(r110.getFilesDir(), "early_settings");     // Catch: Throwable -> L48
        if (r117.exists() == false) goto L36;
    L38:
        RandomAccessFile r118 = new RandomAccessFile(EarlyFileSettingsStore.c(r117, r115), "rw");     // Catch: Throwable -> L48
        r118.setLength(r116);     // Catch: Throwable -> L43
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r118, null);     // Catch: Throwable -> L48
        r115.toString();     // Catch: Throwable -> L48
        r100 = true;
        goto L50
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L36:
        if (r117.mkdirs() == true) goto L38;
        Objects.toString(r115);     // Catch: Throwable -> L48
    L48:
        Objects.toString(r115);
        goto L50
    L49:
        FLogger.f375446a.i("KevaExecutorConfigStore", "delete invalid executor core pool size config=" + r111 + ", defaultCorePoolSize=" + r109);
        r100 = EarlyFileSettingsStore.a(r110, f368542c);
        goto L50
    L22:
        if (r113 > Math.max(16, r109)) goto L24;
        r114 = true;
    L27:
        r112 = null;
        goto L29
    L52:
        EarlyFileSettingsStore.Key r120 = f368542c;
        if (EarlyFileSettingsStore.a(r110, r120) == true) goto L55;
        Objects.toString(r120);
    L5:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Integer a(Context r100, int r101) {
        int r102 = EarlyFileSettingsStore.f368526a;
        EarlyFileSettingsStore.Key r103 = f368542c;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "key");
        long r104 = 0;
        PolarisFileWrapper r105 = EarlyFileSettingsStore.c(new PolarisFileWrapper(r100.getFilesDir(), "early_settings"), r103);     // Catch: Throwable -> L9
        if (r105.exists() == false) goto L6;
        long r106 = r105.length();     // Catch: Throwable -> L9
    L7:
        Objects.toString(r103);     // Catch: Throwable -> L9
        r104 = r106;
    L10:
        Long r107 = Long.valueOf(r104);
        boolean r108 = true;
        if (r107.longValue() > SieveCacheKt.NodeLinkMask) goto L13;
        boolean r109 = true;
    L14:
        Integer r110 = null;
        if (r109 == true) goto L18;
        r107 = null;
    L18:
        if (r107 == null) goto L20;
        Integer r111 = Integer.valueOf((int) r107.longValue());
    L21:
        if (r111 == null) goto L30;
        int r112 = r111.intValue();
        if (1 <= r112) goto L25;
    L27:
        r108 = false;
    L28:
        if (r108 == false) goto L30;
        r110 = r111;
        goto L30
    L25:
        if (r112 > Math.max(16, r101)) goto L27;
    L30:
        if (r110 == null) goto L32;
    L32:
        return r110;
    L20:
        r111 = null;
        goto L21
    L13:
        r109 = false;
        goto L14
    L6:
        r106 = 0;
    L9:
        Objects.toString(r103);
        goto L10
    }
}
