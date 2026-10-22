package com.larus.shortcuts.impl.pin;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f369252a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f369253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f369254b;

        public final String a() {
            String r100 = this.f369253a;
            if (Intrinsics.areEqual(r100, "miui") == false) goto L15;
            String[] r101 = f.f369252a;
            String r102 = this.f369254b;
            Matcher r103 = PatternProtector.compile("V\\d+(.\\d+)*").matcher(r102);     // Catch: Exception -> L29
            if (r103.find() == false) goto L9;
            String r104 = r103.group(0);     // Catch: Exception -> L29
        L11:
            if (TextUtils.isEmpty(r104) == false) goto L35;
            return "";
        L35:
            return r104.substring(1);
        L9:
            r104 = "";
            goto L11
        L15:
            if (Intrinsics.areEqual(r100, "emui") == false) goto L36;
            String[] r105 = f.f369252a;
            String r106 = this.f369254b;
            Matcher r107 = PatternProtector.compile("EmotionUI_\\d+(.\\d+)*").matcher(r106);     // Catch: Exception -> L30
            if (r107.find() == false) goto L21;
            String r108 = r107.group(0);     // Catch: Exception -> L30
        L23:
            if (TextUtils.isEmpty(r108) == false) goto L25;
            return "";
        L25:
            if (r108.length() > 10) goto L28;
            return "";
        L28:
            return r108.substring(10);
        L21:
            r108 = "";
            goto L23
        L36:
            return "";
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "romType");
            Intrinsics.checkNotNullParameter(r101, "romInfo");
            this.f369253a = r100;
            this.f369254b = r101;
        }
    }

    public f() {
    }

    static {
        f369252a = new String[]{SmEditTextLeakOpt.SAMSUNG, "nexus", "pixel"};
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("miui.os.Build");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public static boolean b() {
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == true) goto L8;
        Intrinsics.checkNotNull(r100);
        if (StringsKt.contains$default(r100.toLowerCase(Locale.US), AppConstants.CHANNEL_OPPO, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public static boolean c() {
        String r100 = Build.DISPLAY;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (StringsKt.contains$default(r100.toLowerCase(Locale.US), "flyme", false, 2, null) == false) goto L7;
    L10:
        return true;
    L7:
        if (TextUtils.isEmpty(Build.USER) == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(Build.USER.toLowerCase(Locale.US), "flyme") == true) goto L10;
        return false;
    }

    public static boolean d() {
        String r100 = DeviceUtils.getSystemProperty("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r100.toLowerCase(Locale.US), "funtouch", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
