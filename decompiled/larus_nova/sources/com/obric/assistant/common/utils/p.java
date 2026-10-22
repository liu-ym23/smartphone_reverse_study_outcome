package com.obric.assistant.common.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f387885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f387886b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f387887c = null;

    static {
        f387885a = SetsKt.setOf(new String[]{"com.obric.camera2", "com.android.camera", "com.android.camera2"});
        f387886b = LazyKt.lazy(new n());
        f387887c = LazyKt.lazy(new o());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.media.AudioRecordingConfiguration");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.media.AudioRecordingConfiguration");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.media.AudioRecordingConfiguration");
    }

    public static boolean c() {
        ArrayList r100 = (ArrayList) b(AppHost.f326268a.getApplication());
        if (r100.isEmpty() == true) goto L11;
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        String r102 = (String) r101.next();
        if (f387885a.contains(r102) == false) goto L7;
        return true;
    L11:
        return false;
    }

    public static boolean g() {
        AppHost.Companion r100 = AppHost.f326268a;
        List r101 = b(r100.getApplication());
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains("com.obric.screenrecorder") == false) goto L8;
        if (Intrinsics.areEqual(r100.getBuildChannel(), "auto_test") == false) goto L8;
        return false;
    L8:
        if ((!r102.isEmpty()) == true) goto L10;
        return false;
    L10:
        if (r102.size() == 1) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        return false;
    L17:
        if (d(r101) == true) goto L22;
        return true;
    L22:
        return false;
    L12:
        if (Intrinsics.areEqual(ListProtector.get(r101, 0), r100.getApplication().getPackageName()) == false) goto L14;
        r103 = true;
        goto L15
    }

    public static List b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FLogger.f375446a.i("OrionMicUtils", "getCurrentMicInUsePkgName checking...");
        ArrayList r101 = new ArrayList();
        if (Build.VERSION.SDK_INT < 29) goto L17;
        Object r102 = r100.getSystemService("audio");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.media.AudioManager");
        Iterator<AudioRecordingConfiguration> r103 = ((AudioManager) r102).getActiveRecordingConfigurations().iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        AudioRecordingConfiguration r104 = r103.next();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
        Method r106 = a().getMethod("getClientPackageName", new Class[0]);     // Catch: Throwable -> L15
        r106.setAccessible(true);     // Catch: Throwable -> L15
        Object r107 = r106.invoke(r104, new Object[0]);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L15
        String r108 = (String) r107;     // Catch: Throwable -> L15
        FLogger.f375446a.i("OrionMicUtils", "getCurrentMicInUsePkgName end with packageName is " + r108);     // Catch: Throwable -> L15
        if (o0.d(r108) == true) goto L11;
    L13:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        goto L6
    L11:
        if (Intrinsics.areEqual(r108, r100.getPackageName()) == true) goto L13;
        r101.add(r108);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        FLogger.f375446a.i("OrionMicUtils", "getCurrentMicInUsePkgName end with the package list " + r101.size());
        Iterator r110 = r101.iterator();
    L19:
        if (r110.hasNext() == false) goto L21;
        String r111 = (String) r110.next();
        FLogger.f375446a.i("OrionMicUtils", "getCurrentMicInUsePkgName end with the package " + r111);
        goto L19
    L21:
        return r101;
    }

    public static boolean d(List r100) {
        if (((ArrayList) r100).isEmpty() == false) goto L6;
        return false;
    L6:
        if (h(r100, ((Map) f387887c.getValue()).keySet()) == false) goto L9;
        return false;
    L9:
        return h(r100, ((Map) f387886b.getValue()).keySet());
    }

    public static boolean e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        List r101 = b(r100);
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains("com.obric.screenrecorder") == false) goto L8;
        if (Intrinsics.areEqual(AppHost.f326268a.getBuildChannel(), "auto_test") == false) goto L8;
        return false;
    L8:
        if ((!r102.isEmpty()) == true) goto L10;
        return false;
    L10:
        if (r102.isEmpty() == true) goto L18;
        Iterator r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        if (Intrinsics.areEqual((String) r103.next(), r100.getPackageName()) == false) goto L14;
        boolean r104 = true;
    L19:
        if (r104 == false) goto L21;
        return false;
    L21:
        if (d(r101) == true) goto L29;
        return true;
    L29:
        return false;
    L18:
        r104 = false;
        goto L19
    }

    public static boolean f(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((!r101.isEmpty()) != true) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L21:
        return false;
    L8:
        if (r101.isEmpty() == true) goto L16;
        Iterator r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        if (Intrinsics.areEqual((String) r103.next(), r100.getPackageName()) == false) goto L12;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L21;
        if (d(r101) == true) goto L21;
        return true;
    L16:
        r104 = false;
        goto L17
    L5:
        r102 = false;
        goto L6
    }

    public static boolean h(List r100, Collection r101) {
        if (r100.isEmpty() == true) goto L11;
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (r101.contains((String) r102.next()) == false) goto L7;
        return true;
    L11:
        return false;
    }
}
