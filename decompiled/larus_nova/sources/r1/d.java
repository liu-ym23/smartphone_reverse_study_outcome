package r1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.apm.lite.ICommonParams;
import com.apm.lite.k.u;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f535554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICommonParams f535555b;

    public final Map<String, Object> c() {
        HashMap r100 = new HashMap();     // Catch: Throwable -> L8
        r100.putAll(this.f535555b.getCommonParams());     // Catch: Throwable -> L6
        th = null;
    L10:
        if (r100 != null) goto L15;
        r100 = new HashMap(4);
        if (th == null) goto L15;
        r100.put("err_info", u.b(th));     // Catch: Throwable -> L70
    L15:
        if (r100.isEmpty() == false) goto L17;
    L26:
        boolean r101 = true;
    L28:
        if (r101 == false) goto L88;
        PackageInfo r102 = this.f535554a.getPackageManager().getPackageInfo(this.f535554a.getPackageName(), 128);     // Catch: Throwable -> L39
        r100.put("version_name", r102.versionName);     // Catch: Throwable -> L39
        r100.put("version_code", Integer.valueOf(r102.versionCode));     // Catch: Throwable -> L39
        if (r100.get("update_version_code") != null) goto L69;
        Bundle r103 = r102.applicationInfo.metaData;     // Catch: Throwable -> L39
        if (r103 == null) goto L34;
        Object r104 = r103.get("UPDATE_VERSION_CODE");     // Catch: Throwable -> L39
    L35:
        if (r104 != null) goto L37;
        r104 = r100.get("version_code");     // Catch: Throwable -> L39
    L37:
        r100.put("update_version_code", r104);     // Catch: Throwable -> L39
        goto L69
    L34:
        r104 = null;
    L69:
        return r100;
    L39:
        Class<?> r105 = com.apm.lite.k.a.j(this.f535554a);
        if (com.apm.lite.k.a.f29989c != null) goto L45;
        if (r105 == null) goto L45;
        com.apm.lite.k.a.f29989c = r105.getDeclaredField("VERSION_NAME");     // Catch: NoSuchFieldException -> L44
    L45:
        Field r106 = com.apm.lite.k.a.f29989c;
        if (r106 != null) goto L86;
    L49:
        String r107 = "";
    L50:
        r100.put("version_name", r107);
        Class<?> r108 = com.apm.lite.k.a.j(this.f535554a);
        if (com.apm.lite.k.a.f29990d != null) goto L56;
        if (r108 == null) goto L56;
        com.apm.lite.k.a.f29990d = r108.getDeclaredField("VERSION_CODE");     // Catch: NoSuchFieldException -> L55
    L56:
        Field r109 = com.apm.lite.k.a.f29990d;
        if (r109 != null) goto L76;
    L60:
        int r110 = -1;
    L61:
        r100.put("version_code", Integer.valueOf(r110));
        if (r100.get("update_version_code") != null) goto L69;
        r100.put("update_version_code", r100.get("version_code"));
        goto L69
    L76:
        r110 = ((Integer) r109.get(null)).intValue();     // Catch: Throwable -> L71
    L86:
        r107 = String.valueOf(r106.get(null));     // Catch: Throwable -> L72
    L88:
        String r111 = this.f535554a.getPackageManager().getPackageInfo(this.f535554a.getPackageName(), 128).versionName;     // Catch: Throwable -> L73
        String r112 = (String) a(this.f535554a.getPackageName() + ".BuildConfig").getDeclaredField("VERSION_NAME").get(null);     // Catch: Throwable -> L73
        if (r111 == null) goto L69;
        if (r111.equals(r112) == true) goto L69;
        r100.put("manifest_version", r111);     // Catch: Throwable -> L73
        goto L69
    L17:
        if (r100.containsKey("app_version") == true) goto L21;
        if (r100.containsKey("version_name") == false) goto L26;
    L21:
        if (r100.containsKey("version_code") == false) goto L26;
        if (r100.containsKey("update_version_code") == false) goto L26;
        r101 = false;
    L6:
        th = th;
    L8:
        th = th;
        r100 = null;
        goto L10
    }

    public final Map<String, Object> b() {
        Map<String, Object> r100 = c();
        Object r101 = r100.get("aid");
        if (r101 == null) goto L5;
        String r102 = String.valueOf(r101);
    L6:
        if (r102 != null) goto L8;
        r100.put("aid", 4444);
    L8:
        return r100;
    L5:
        r102 = null;
        goto L6
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

    public d(Context r100, ICommonParams r101) {
        this.f535554a = r100;
        this.f535555b = r101;
    }
}
