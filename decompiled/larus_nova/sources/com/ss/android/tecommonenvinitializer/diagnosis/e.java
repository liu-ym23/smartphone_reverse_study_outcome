package com.ss.android.tecommonenvinitializer.diagnosis;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f449603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f449604b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f449605c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f449606d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f449607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f449608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f449609g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f449610h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<String> f449611i = null;

    public static final class a {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.ss.android.VEHook");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.ss.android.VEHook");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.ss.android.VEHook");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.ss.android.VEHook");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.ss.android.VEHook");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.ss.android.VEHook");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.ss.android.VEHook");
        }

        public a() {
        }
    }

    static {
        new a();
        boolean r100 = true;
        f449603a = true;
        ArrayList r101 = new ArrayList();
        f449604b = r101;
        f449605c = new ArrayList();
        new ArrayList();
        f449606d = new ArrayList();
        f449610h = CollectionsKt.listOf(new String[]{"c++_shared", "ttboringssl", "ttcrypto"});
        List<String> r102 = CollectionsKt.listOf(new String[]{"NLEPresetJni", "NLEMediaPublicJni", "NLEMediaJni", "NLETemplateModelJni", "nlepresetJni", "ttvesdk", "effect", "gaia_lib", "AGFX"});
        f449611i = r102;
        r101.addAll(r102);
        PolarisFileWrapper r103 = new PolarisFileWrapper("/data/local/tmp/ve/vehook_conf.json");
        boolean r104 = false;
        if (r103.exists() == false) goto L54;
        JSONObject r105 = new JSONObject(FilesKt.readText$default(r103, null, 1, null));
        if (r105.has("enable") == true) goto L7;
    L9:
        f449603a = false;
        if (r105.has("exclude_libs") == false) goto L25;
        JSONArray r106 = JSONObjectProtectorUtils.getJSONArray(r105, "exclude_libs");
        int r107 = r106.length();
        int r110 = 0;
    L12:
        if (r110 >= r107) goto L25;
        int r111 = r110 + 1;
        String r112 = JSONArrayProtectorUtils.getString(r106, r110);
        if (r112.length() <= 0) goto L16;
        boolean r113 = true;
    L17:
        if (r113 == false) goto L23;
        if (StringsKt.startsWith$default(r112, "lib", false, 2, null) == false) goto L23;
        if (StringsKt.endsWith$default(r112, ".so", false, 2, null) == false) goto L23;
        ((ArrayList) f449605c).add(r112.substring(3, r112.length() - 3));
    L23:
        r110 = r111;
        goto L12
    L16:
        r113 = false;
    L25:
        if (r105.has("extra_libs") == false) goto L39;
        JSONArray r108 = JSONObjectProtectorUtils.getJSONArray(r105, "extra_libs");
        int r109 = r108.length();
        int r114 = 0;
    L27:
        if (r114 >= r109) goto L39;
        int r115 = r114 + 1;
        String r116 = JSONArrayProtectorUtils.getString(r108, r114);
        if (r116.length() <= 0) goto L31;
        boolean r117 = true;
    L32:
        if (r117 == false) goto L38;
        if (StringsKt.startsWith$default(r116, "lib", false, 2, null) == false) goto L38;
        if (StringsKt.endsWith$default(r116, ".so", false, 2, null) == false) goto L38;
        ((ArrayList) f449604b).add(r116.substring(3, r116.length() - 3));
    L38:
        r114 = r115;
        goto L27
    L31:
        r117 = false;
    L39:
        ((ArrayList) f449605c).addAll(f449610h);
        goto L54
    L7:
        if (JSONObjectProtectorUtils.getBoolean(r105, "enable") == true) goto L9;
    L54:
        Class<?> r118 = a.a();     // Catch: Exception -> L45
        f449607e = r118;     // Catch: Exception -> L45
        if (r118 == null) goto L52;
        f449608f = r118.getMethod(DownloadSettingKeys.KEY_HOOK, new Class[]{String[].class, Integer.TYPE});     // Catch: Exception -> L45
    L48:
        if (f449608f != null) goto L51;
        r100 = false;
    L51:
        r104 = r100;
    L52:
        f449609g = r104;
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L48
    }

    @JvmStatic
    public static final void a(String[] r110) {
        Intrinsics.checkNotNullParameter(r110, "libs");
        if (f449603a == true) goto L64;
        ArrayList r100 = new ArrayList();
        int r101 = r110.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L19;
        String r103 = r110[r102];
        r102 = r102 + 1;
        if (StringsKt.startsWith$default(r103, "lib", false, 2, null) == false) goto L14;
        if (StringsKt.endsWith$default(r103, ".so", false, 2, null) == false) goto L14;
        r103 = r103.substring(3, r103.length() - 3);
    L14:
        if (((ArrayList) f449605c).contains(r103) == true) goto L7;
        if (((ArrayList) f449604b).contains(r103) == false) goto L7;
        r100.add("lib" + r103 + ".so");
        goto L7
    L19:
        Object[] r111 = r100.toArray(new String[0]);
        if (r111 == null) goto L47;
        String[] r112 = (String[]) r111;
        Intrinsics.checkNotNullParameter(r112, "libs");
        List r113 = ArraysKt.toMutableList(r112);     // Catch: Exception -> L43
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L43
        Iterator r114 = r113.iterator();     // Catch: Exception -> L43
    L24:
        if (r114.hasNext() == false) goto L29;
        Object r105 = r114.next();     // Catch: Exception -> L43
        if ((true ^ ((ArrayList) f449606d).contains((String) r105)) == false) goto L24;
        r104.add(r105);     // Catch: Exception -> L43
        goto L24
    L29:
        if (r104.isEmpty() == false) goto L32;
        return;
    L32:
        if (f449609g == false) goto L62;
        Intrinsics.stringPlus("VEHook hook libs: ", CollectionsKt.joinToString$default(r104, ",", null, null, 0, null, null, 62, null));     // Catch: Exception -> L43
        Method r115 = f449608f;     // Catch: Exception -> L43
        if (r115 == null) goto L40;
        Class<?> r106 = f449607e;     // Catch: Exception -> L43
        Object[] r107 = new Object[2];     // Catch: Exception -> L43
        Object[] r108 = r104.toArray(new String[0]);     // Catch: Exception -> L43
        if (r108 == null) goto L42;
        r107[0] = r108;     // Catch: Exception -> L43
        r107[1] = 0;     // Catch: Exception -> L43
        r115.invoke(r106, r107);     // Catch: Exception -> L43
        goto L40
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Exception -> L43
    L40:
        ((ArrayList) f449606d).addAll(r104);     // Catch: Exception -> L43
        return;
    L62:
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        return;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
