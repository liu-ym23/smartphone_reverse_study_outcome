package com.bytedance.geckox;

import android.content.Context;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.GkFSExecutor;
import com.bytedance.gkfs.UtilsKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class GkFSUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Function0<Unit>> f245072a = null;

    static {
        f245072a = new ArrayList();
    }

    public static boolean e() {
        AppSettingsManager r100 = AppSettingsManager.b.f245071a;
        AppSettingsManager.IGeckoAppSettings r101 = r100.b();
        if (r101 == null) goto L6;
        r100.f245067h = r101.isGkFSDeleteOriginFile();
        GeckoLogger.d("getGkFSDeleteOriginFile: " + r100.f245067h);
    L6:
        return r100.f245067h;
    }

    public static boolean f() {
        AppSettingsManager r100 = AppSettingsManager.b.f245071a;
        AppSettingsManager.IGeckoAppSettings r101 = r100.b();
        if (r101 == null) goto L6;
        r100.f245063d = r101.isGkFSEnable();
    L6:
        return r100.f245063d;
    }

    public static boolean h() {
        AppSettingsManager r100 = AppSettingsManager.b.f245071a;
        AppSettingsManager.IGeckoAppSettings r101 = r100.b();
        if (r101 == null) goto L6;
        r100.f245068i = r101.isGkFSTraversalFileNative();
        GeckoLogger.d("gkfsTraversalFileNative: " + r100.f245068i);
    L6:
        return r100.f245068i;
    }

    public static long a(Context r100) {
        String r101 = new PolarisFileWrapper(r100.getFilesDir(), "offlineX").getAbsolutePath();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        InputStream r104 = c(Runtime.getRuntime(), "du -s " + r101).getInputStream();     // Catch: Throwable -> L12
        long r105 = Long.parseLong((String) StringsKt.split$default(TextStreamsKt.readLines(new InputStreamReader(r104, Charsets.UTF_8)).get(0), new String[]{"\t"}, false, 0, 6, null).get(0));     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(Long.valueOf(r105));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L18;
        r102 = r106;
    L18:
        Long r107 = (Long) r102;
        if (r107 != null) goto L28;
        return 0;
    L28:
        return r107.longValue();
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static boolean g(String r100) {
        return StringsKt.endsWith$default(r100, ".gkfsf", false, 2, null);
    }

    public static void b(final Context r100, final Function0 r101) {
        if (UtilsKt.e() == true) goto L6;
        r101.invoke();
        return;
    L6:
        GkFSExecutor.a(new GkFSUtils$cleanOldExperiments$1(r101, r100));
    }

    public static Process c(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static Pair i(String r100, String r101) {
        if (f() == false) goto L5;
        AppSettingsManager r102 = AppSettingsManager.b.f245071a;
        AppSettingsManager.IGeckoAppSettings r103 = r102.b();
        if (r103 == null) goto L10;
        r102.f245065f = r103.getGkFSDisallowAks();
    L10:
        if (r102.f245065f != null) goto L12;
        GeckoLogger.d("gkfsDisallowAks: null");
    L12:
        List<String> r104 = r102.f245065f;
        if (r104 != null) goto L15;
    L18:
        AppSettingsManager.IGeckoAppSettings r105 = r102.b();
        if (r105 == null) goto L22;
        r102.f245064e = r105.getGkFSDisallowChannels();
    L22:
        if (r102.f245064e != null) goto L24;
        GeckoLogger.d("getGkFSDisallowChannels: null");
    L24:
        Map<String, List<String>> r106 = r102.f245064e;
        if (r106 == null) goto L35;
        Iterator<Map.Entry<String, List<String>>> r107 = r106.entrySet().iterator();
    L28:
        if (r107.hasNext() == false) goto L35;
        Map.Entry<String, List<String>> r108 = r107.next();
        if (Intrinsics.areEqual(r108.getKey(), r100) == false) goto L28;
        if (r108.getValue().contains(r101) == false) goto L28;
        return TuplesKt.to(Boolean.FALSE, CollectionsKt.emptyList());
    L35:
        Boolean r109 = Boolean.TRUE;
        AppSettingsManager r110 = AppSettingsManager.b.f245071a;
        AppSettingsManager.IGeckoAppSettings r111 = r110.b();
        if (r111 == null) goto L39;
        r110.f245066g = r111.getGkFSAllowExt();
    L39:
        if (r110.f245066g != null) goto L41;
        GeckoLogger.d("getGkFSAllowExt: null");
    L41:
        List<String> r112 = r110.f245066g;
        if (r112 != null) goto L46;
        r112 = CollectionsKt.emptyList();
    L46:
        return TuplesKt.to(r109, r112);
    L15:
        if (r104.contains(r100) == false) goto L18;
        return TuplesKt.to(Boolean.FALSE, CollectionsKt.emptyList());
    L5:
        return TuplesKt.to(Boolean.FALSE, CollectionsKt.emptyList());
    }

    public static String d(String r110, String r111, String r112) {
        boolean r100 = false;
        if (StringsKt.endsWith$default(r112, ".gkfsf", false, 2, null) == false) goto L5;
        return r112;
    L5:
        Pair r113 = i(r110, r111);
        boolean r114 = ((Boolean) r113.component1()).booleanValue();
        List r115 = (List) r113.component2();
        if (r114 == true) goto L9;
        return null;
    L9:
        if ((!r115.isEmpty()) == false) goto L32;
        Integer r116 = Integer.valueOf(StringsKt.lastIndexOf$default(r112, ".", 0, false, 6, null));
        if (r116.intValue() == (-1)) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == true) goto L17;
        r116 = null;
    L17:
        if (r116 == null) goto L30;
        String r117 = r112.substring(r116.intValue());
        if (r117 == null) goto L30;
        if (r117.length() <= 0) goto L23;
        r100 = true;
    L23:
        if (r100 == true) goto L26;
        r117 = null;
    L26:
        if (r117 == null) goto L30;
        if (r115.contains(r117) == true) goto L32;
        return null;
    L30:
        return r112;
    L13:
        r101 = false;
    L32:
        return r112 + ".gkfsf";
    }
}
