package com.obric.assistant.settings.autogui;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f391941a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f391942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f391943b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f391942a, r101.f391942a) == true) goto L12;
            return false;
        L12:
            if (this.f391943b == r101.f391943b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f391942a.hashCode() * 31;
            if (this.f391943b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "BlockedAppsResult(packages=" + this.f391942a + ", success=" + this.f391943b + ')';
        }

        public a(List<String> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "packages");
            this.f391942a = r100;
            this.f391943b = r101;
        }
    }

    static {
        f391941a = LazyKt.lazy(new n0());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.provider.DeviceConfig");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.provider.DeviceConfig");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.provider.DeviceConfig");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.provider.DeviceConfig");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.provider.DeviceConfig");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.provider.DeviceConfig");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.provider.DeviceConfig");
    }

    public static a b() {
        if (Build.VERSION.SDK_INT < 37) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        String r101 = "";
        Method r102 = (Method) f391941a.getValue();
        if (r102 != null) goto L54;
        FLogger.f375446a.e("ObricComputerControlConfigReader", "getDeviceConfigString skip, DeviceConfig.getString unresolved, namespace: computer_control, name: blocked_automatable_apps");
        String r103 = null;
    L24:
        FLogger r104 = FLogger.f375446a;
        r104.i("ObricComputerControlConfigReader", "getBlockedAutomatableAppPackagesResult, rawValue: " + r103);
        if (r103 != null) goto L29;
        return new a(CollectionsKt.emptyList(), false);
    L29:
        if (StringsKt.isBlank(r103) == false) goto L32;
        List r105 = CollectionsKt.emptyList();
    L53:
        return new a(r105, true);
    L32:
        if (Intrinsics.areEqual(StringsKt.trim(r103).toString(), "*") == false) goto L34;
        r104.i("ObricComputerControlConfigReader", "parseList, INCLUDE_EVERYTHING, return empty package list");
        r105 = CollectionsKt.emptyList();
        goto L53
    L34:
        List r106 = StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L36:
        if (r108.hasNext() == false) goto L51;
        String r109 = StringsKt.trim((String) r108.next()).toString();
        if (r109.length() != 0) goto L40;
        boolean r110 = true;
    L41:
        if (r110 == true) goto L48;
        String r111 = StringsKt.trim(StringsKt.substringBefore$default(r109, ":", null, 2, null)).toString();
        if (r111.length() != 0) goto L46;
        boolean r112 = true;
    L47:
        if (r112 == true) goto L48;
    L49:
        if (r111 == null) goto L36;
        r107.add(r111);
        goto L36
    L46:
        r112 = false;
    L48:
        r111 = null;
        goto L49
    L40:
        r110 = false;
        goto L41
    L51:
        r105 = CollectionsKt.distinct(r107);
        goto L53
    L54:
        Object r113 = r102.invoke(null, new Object[]{"computer_control", "blocked_automatable_apps", ""});     // Catch: Throwable -> L21
        if ((r113 instanceof String) == false) goto L17;
        String r114 = (String) r113;     // Catch: Throwable -> L21
    L18:
        if (r114 == null) goto L23;
        r101 = r114;
    L23:
        r103 = r101;
        goto L24
    L17:
        r114 = null;
    L21:
        th = move-exception;
        FLogger.f375446a.e("ObricComputerControlConfigReader", "getDeviceConfigString failed, namespace: computer_control, name: blocked_automatable_apps", th);
        r101 = null;
        goto L23
    L8:
        return new a(CollectionsKt.emptyList(), true);
    L5:
        r100 = false;
        goto L6
    }
}
