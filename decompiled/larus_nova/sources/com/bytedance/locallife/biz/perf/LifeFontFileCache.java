package com.bytedance.locallife.biz.perf;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class LifeFontFileCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LifeFontFileCache f256819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f256820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, List<Function1<String, Unit>>> f256821c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorService f256822d = null;

    public LifeFontFileCache() {
    }

    static {
        f256819a = new LifeFontFileCache();
        f256820b = new Object();
        f256821c = new LinkedHashMap();
        f256822d = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("LifeFontFileCache"));
    }

    public static List b(String r100) {
        Object r101 = f256820b;
        monitor-enter(r101);
        List<Function1<String, Unit>> r102 = f256821c.remove(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public final void a(Context r100, String r110, String r111, Function1<? super String, Unit> r112, Function2<? super Function1<? super InputStream, Unit>, ? super Function1<? super Throwable, Unit>, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "resName");
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "request");
        com.bytedance.locallife.biz.experiment.e r101 = com.bytedance.locallife.biz.experiment.f.a();
        boolean r102 = true;
        if (r101.f256650a == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == true) goto L15;
        return;
    L15:
        if (StringsKt.isBlank(r110) == false) goto L17;
        return;
    L17:
        if (StringsKt.isBlank(r111) == true) goto L72;
        final PolarisFileWrapper r105 = new PolarisFileWrapper(r100.getCacheDir(), "life_saas_fonts");
        final PolarisFileWrapper r106 = new PolarisFileWrapper(r105, r110);
        if (r106.isFile() == true) goto L22;
    L28:
        final String r114 = r110 + '@' + r111;
        Object r115 = f256820b;
        monitor-enter(r115);
    L57:
        th = move-exception;
        throw th;
    L31:
        if (r106.isFile() == true) goto L33;
    L35:
        Map<String, List<Function1<String, Unit>>> r107 = f256821c;     // Catch: Throwable -> L57
        List r108 = (List) ((LinkedHashMap) r107).get(r114);     // Catch: Throwable -> L57
        String r109 = null;
        if (r108 == null) goto L39;
        r108.add(r112);     // Catch: Throwable -> L57
        String r116 = null;
    L38:
        r109 = r116;
        r102 = false;
    L40:
        monitor-exit(r115);
        if (r109 != null) goto L64;
        if (r102 == true) goto L66;
        return;
    L66:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L51
        r113.invoke(new LifeFontFileCache$download$3$1(this, r105, r106, r114), new LifeFontFileCache$download$3$2(this, r114));     // Catch: Throwable -> L51
        Object r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        if (Result.m9452exceptionOrNullimpl(r118) == null) goto L70;
        f256819a.getClass();
        b(r114);
        return;
    L70:
        return;
    L51:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    L64:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L44
        r112.invoke(r109);     // Catch: Throwable -> L44
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L39:
        r107.put(r114, CollectionsKt.mutableListOf(new Function1[]{r112}));     // Catch: Throwable -> L57
        goto L40
    L33:
        if (r106.length() <= 0) goto L35;
        r116 = r106.getAbsolutePath();     // Catch: Throwable -> L57
        goto L38
    L22:
        if (r106.length() <= 0) goto L28;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L25
        r112.invoke(r106.getAbsolutePath());     // Catch: Throwable -> L25
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L72:
        return;
    L10:
        if (r101.f256664o == false) goto L12;
        r104 = true;
        goto L13
    L5:
        if (r101.f256661l == false) goto L7;
        r103 = true;
        goto L8
    }
}
