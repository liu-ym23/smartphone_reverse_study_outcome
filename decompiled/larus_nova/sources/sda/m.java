package sda;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f541479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f541480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f541481c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f541482d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f541483e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f541484f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f541485g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f541486h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f541487i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f541488j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f541489k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f541490l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile Object f541491m;

    public m() {
    }

    static {
        f541479a = new m();
        f541480b = new Class[0].getClass();
        f541481c = LazyKt.lazy(new c());
        f541482d = LazyKt.lazy(new d());
        f541483e = LazyKt.lazy(new e());
        f541484f = LazyKt.lazy(new f());
        f541485g = LazyKt.lazy(new g());
        f541486h = LazyKt.lazy(new h());
        f541487i = LazyKt.lazy(new i());
        f541488j = LazyKt.lazy(new j());
        f541489k = LazyKt.lazy(new k());
        f541490l = LazyKt.lazy(new l());
    }

    public static Class b() {
        return (Class) f541481c.getValue();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static Class c(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Method r103 = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L9
        r103.setAccessible(true);     // Catch: Throwable -> L9
        Object r104 = r103.invoke(null, new Object[]{r100});     // Catch: Throwable -> L9
        if ((r104 instanceof Class) == false) goto L6;
        Class r105 = (Class) r104;     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L12:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L24;
        Object r107 = Result.m9449constructorimpl(a(r100));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r107) == true) goto L22;
        r101 = r107;
    L22:
        r106 = (Class) r101;
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        return (Class) r106;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static Constructor d(Class r100, Class... r101) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Method r104 = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{f541480b});     // Catch: Throwable -> L12
        r104.setAccessible(true);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L12
        Object r105 = r104.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L12
        if ((r105 instanceof Constructor) == false) goto L6;
        Constructor r106 = (Constructor) r105;     // Catch: Throwable -> L12
    L7:
        if (r106 == null) goto L9;
        r106.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L27;
        Constructor r108 = r100.getDeclaredConstructor((Class[]) Arrays.copyOf(r101, r101.length));     // Catch: Throwable -> L19
        r108.setAccessible(true);     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r109) == true) goto L25;
        r102 = r109;
    L25:
        r107 = (Constructor) r102;
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        return (Constructor) r107;
    L9:
        r106 = null;
        goto L10
    L6:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static Field e(Class r100, String r101) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Method r104 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L12
        r104.setAccessible(true);     // Catch: Throwable -> L12
        Object r105 = r104.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L12
        if ((r105 instanceof Field) == false) goto L6;
        Field r106 = (Field) r105;     // Catch: Throwable -> L12
    L7:
        if (r106 == null) goto L9;
        r106.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L27;
        Field r108 = r100.getDeclaredField(r101);     // Catch: Throwable -> L19
        r108.setAccessible(true);     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r109) == true) goto L25;
        r102 = r109;
    L25:
        r107 = (Field) r102;
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        return (Field) r107;
    L9:
        r106 = null;
        goto L10
    L6:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static Method f(Class r100, String r101, Class... r110) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Method r104 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, f541480b});     // Catch: Throwable -> L12
        r104.setAccessible(true);     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L12
        Object r105 = r104.invoke(r100, new Object[]{r101, r110});     // Catch: Throwable -> L12
        if ((r105 instanceof Method) == false) goto L6;
        Method r106 = (Method) r105;     // Catch: Throwable -> L12
    L7:
        if (r106 == null) goto L9;
        r106.setAccessible(true);     // Catch: Throwable -> L12
    L10:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L27;
        Method r108 = r100.getDeclaredMethod(r101, (Class[]) Arrays.copyOf(r110, r110.length));     // Catch: Throwable -> L19
        r108.setAccessible(true);     // Catch: Throwable -> L19
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r109) == true) goto L25;
        r102 = r109;
    L25:
        r107 = (Method) r102;
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        return (Method) r107;
    L9:
        r106 = null;
        goto L10
    L6:
        r106 = null;
    L12:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void g(Object r210, Context r211, String r212, String r213, Integer r214, Integer r215) {
        if (r214 == null) goto L50;
        int r100 = r214.intValue();
        if (r215 == null) goto L7;
        int r101 = r215.intValue();
    L8:
        Method r110 = (Method) f541483e.getValue();
        if (r110 != null) goto L54;
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestLaunchHint fallback, scene=" + r213 + ", source=" + r212 + ", perfHintAcqRelMethod is null");
        boolean r102 = false;
    L29:
        if (r102 == true) goto L56;
        Method r111 = (Method) f541484f.getValue();
        if (r111 != null) goto L52;
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestPerfHint skipped, scene=" + r213 + ", source=" + r212 + ", perfHintMethod is null");
        return;
    L52:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L44
        Object r103 = r111.invoke(r210, new Object[]{Integer.valueOf(r100), r211.getPackageName(), 500, Integer.valueOf(r101)});     // Catch: Throwable -> L44
        if ((r103 instanceof Integer) == false) goto L36;
        Integer r104 = (Integer) r103;     // Catch: Throwable -> L44
    L37:
        if (r104 != null) goto L39;
    L41:
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestPerfHint rejected, scene=" + r213 + ", source=" + r212 + ", handle=" + r104 + ", hint=0x" + Integer.toString(r100, CharsKt.checkRadix(16)) + ", launchType=" + r101 + ", durationMs=500");     // Catch: Throwable -> L44
    L42:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L58;
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestPerfHint failed, scene=" + r213 + ", source=" + r212, r106);
        return;
    L58:
        return;
    L39:
        if (r104.intValue() <= 0) goto L41;
        FLogger.f375446a.i("VendorLaunchBoostHelper", "requestPerfHint success, scene=" + r213 + ", source=" + r212 + ", handle=" + r104 + ", hint=0x" + Integer.toString(r100, CharsKt.checkRadix(16)) + ", launchType=" + r101 + ", durationMs=500");     // Catch: Throwable -> L44
        goto L42
    L36:
        r104 = null;
    L44:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L56:
        return;
    L54:
        Result.Companion r216 = Result.Companion;     // Catch: Throwable -> L22
        Object r108 = r110.invoke(r210, new Object[]{-1, Integer.valueOf(r100), r211.getPackageName(), 500, Integer.valueOf(r101), 0, new int[0]});     // Catch: Throwable -> L22
        if ((r108 instanceof Integer) == false) goto L14;
        Integer r109 = (Integer) r108;     // Catch: Throwable -> L22
    L15:
        if (r109 != null) goto L17;
    L19:
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestLaunchHint rejected, scene=" + r213 + ", source=" + r212 + ", handle=" + r109 + ", hint=0x" + Integer.toString(r100, CharsKt.checkRadix(16)) + ", launchType=" + r101 + ", durationMs=500");     // Catch: Throwable -> L22
        boolean r113 = false;
    L20:
        Object r114 = Result.m9449constructorimpl(Boolean.valueOf(r113));     // Catch: Throwable -> L22
    L24:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L28;
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestLaunchHint failed, scene=" + r213 + ", source=" + r212, r115);
        r114 = Boolean.FALSE;
    L28:
        r102 = ((Boolean) r114).booleanValue();
        goto L29
    L17:
        if (r109.intValue() <= 0) goto L19;
        FLogger.f375446a.i("VendorLaunchBoostHelper", "requestLaunchHint success, scene=" + r213 + ", source=" + r212 + ", handle=" + r109 + ", hint=0x" + Integer.toString(r100, CharsKt.checkRadix(16)) + ", launchType=" + r101 + ", durationMs=500");     // Catch: Throwable -> L22
        r113 = true;
        goto L20
    L14:
        r109 = null;
    L22:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L7:
        r101 = 0;
        goto L8
    L50:
        FLogger.f375446a.w("VendorLaunchBoostHelper", "requestLaunchHint skipped, scene=" + r213 + ", source=" + r212 + ", vendor hint is null");
    }
}
