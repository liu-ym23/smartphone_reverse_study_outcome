package rk7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ug.sdk.luckydog.api.callback.ILuckyCleanCacheService;
import com.bytedance.ug.sdk.luckydog.api.window.CleanCacheSPInfo;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f538343a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f538344b = null;

    public j() {
    }

    static {
        f538344b = new j();
        ArrayList<String> r100 = new ArrayList();
        f538343a = r100;
        r100.add("com.bytedance.ug.sdk.luckydog.window.keep.LuckyDialogCleanCacheImpl");
        r100.add("com.bytedance.ug.sdk.luckydog.window.keep.LuckyNotificationCleanCacheImpl");
        r100.add("com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.LuckyPollingSettingsCleanCacheImpl");
        r100.add("com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.LuckyDynamicSettingsCleanCacheImpl");
        r100.add("com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.LuckyStaticSettingsCleanCacheImpl");
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

    public static void c(ArrayList r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L31;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() models不为空，执行清除model操作");
        Iterator<String> r101 = f538343a.iterator();
    L8:
        if (r101.hasNext() == false) goto L32;
        Object r102 = a(r101.next()).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L17
        if (r102 != null) goto L12;
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ug.sdk.luckydog.api.callback.ILuckyCleanCacheService");     // Catch: Throwable -> L17
    L12:
        ILuckyCleanCacheService r103 = (ILuckyCleanCacheService) r102;     // Catch: Throwable -> L17
        if (r100.contains(r103.modelName()) == false) goto L8;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() 找到service,执行清除 name = " + r103.modelName());     // Catch: Throwable -> L17
        r103.onClean();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyCleanCacheManager", th.getMessage());
        goto L8
    L32:
        return;
    }

    public static void d(ArrayList r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L72;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() 执行清除SP的某个KEY操作");
        Iterator r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L73;
        CleanCacheSPInfo r102 = (CleanCacheSPInfo) r101.next();
        Context r103 = m.f538361o.e();
        if (r103 == null) goto L8;
        if (r102 != null) goto L14;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L8;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() spName = " + r102.getSpName());
        SharedPreferences r105 = r103.getSharedPreferences(r102.getSpName(), 0);     // Catch: Throwable -> L53
        if (r105 == null) goto L26;
        SharedPreferences.Editor r106 = r105.edit();     // Catch: Throwable -> L53
    L27:
        if (r106 == null) goto L8;
        SharedPreferences.Editor r107 = r105.edit();     // Catch: Throwable -> L53
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() 参数校验通过, keyName = " + r102.getKeyName() + ", keyType = " + r102.getKeyType());     // Catch: Throwable -> L53
        String r108 = r102.getKeyType();     // Catch: Throwable -> L50
    L30:
        switch(r108.hashCode()) {
            case -891985903: goto L45;
            case 104431: goto L42;
            case 3327612: goto L39;
            case 64711720: goto L36;
            case 97526364: goto L33;
            default: goto L47;
        };     // Catch: Throwable -> L50
    L47:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "keyType类型错误");     // Catch: Throwable -> L50
    L48:
        r107.apply();     // Catch: Throwable -> L50
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "sp写入值更新成功");     // Catch: Throwable -> L50
        goto L8
    L33:
        if (r108.equals("float") == false) goto L47;
        r107.putFloat(r102.getKeyName(), CastFloatProtector.parseFloat(r102.getKeyValue()));     // Catch: Throwable -> L50
        goto L48
    L36:
        if (r108.equals("boolean") == false) goto L47;
        r107.putBoolean(r102.getKeyName(), Boolean.parseBoolean(r102.getKeyValue()));     // Catch: Throwable -> L50
        goto L48
    L39:
        if (r108.equals("long") == false) goto L47;
        r107.putLong(r102.getKeyName(), CastLongProtector.parseLong(r102.getKeyValue()));     // Catch: Throwable -> L50
        goto L48
    L42:
        if (r108.equals("int") == false) goto L47;
        r107.putInt(r102.getKeyName(), CastIntegerProtector.parseInt(r102.getKeyValue()));     // Catch: Throwable -> L50
        goto L48
    L45:
        if (r108.equals("string") == false) goto L47;
        r107.putString(r102.getKeyName(), r102.getKeyValue());     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "sp写入值是异常: " + th.getLocalizedMessage());     // Catch: Throwable -> L53
        goto L8
    L26:
        r106 = null;
    L53:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "清除sp异常了：" + th.getLocalizedMessage());
        goto L8
    L14:
        if (TextUtils.isEmpty(r102.getSpName()) == true) goto L20;
        if (TextUtils.isEmpty(r102.getKeyName()) == true) goto L20;
        if (TextUtils.isEmpty(r102.getKeyType()) == true) goto L20;
        r104 = true;
        goto L21
    L73:
        return;
    }

    public static void e(ArrayList r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L37;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() 执行清除SP操作");
        Iterator r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L38;
        String r102 = (String) r101.next();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() spName = " + r102);
        Context r103 = m.f538361o.e();
        if (r103 == null) goto L8;
        if (TextUtils.isEmpty(r102) == true) goto L8;
        SharedPreferences r104 = r103.getSharedPreferences(r102, 0);     // Catch: Throwable -> L21
        if (r104 == null) goto L17;
        SharedPreferences.Editor r105 = r104.edit();     // Catch: Throwable -> L21
    L18:
        if (r105 == null) goto L8;
        SharedPreferences.Editor r106 = r104.edit();     // Catch: Throwable -> L21
        r106.clear();     // Catch: Throwable -> L21
        r106.apply();     // Catch: Throwable -> L21
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() 清除成功： spName = " + r102);     // Catch: Throwable -> L21
        goto L8
    L17:
        r105 = null;
    L21:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "清除sp异常了：" + th.getLocalizedMessage());
        goto L8
    L38:
        return;
    }

    public final void b(xk7.e r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() called;");
        Object r101 = r100.j("data.common_info.extra");
        if (r101 == null) goto L17;
        String r102 = r101.toString();
        if (TextUtils.isEmpty(r102) == true) goto L18;
        String r103 = new JSONObject(r102).optString("clear_cache", "");     // Catch: Throwable -> L12
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache() clearCache = " + r103);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r103) == true) goto L19;
        ll7.a r104 = (ll7.a) new Gson().fromJson(r103, ll7.a.class);     // Catch: Throwable -> L12
        if (r104 == null) goto L20;
        f(r104);     // Catch: Throwable -> L12
        return;
    L20:
        return;
    L19:
        return;
    L12:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", th.getLocalizedMessage());
        return;
    L18:
        return;
    }

    public final synchronized void f(ll7.a r100) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "doCleanCache() called; ");     // Catch: Throwable -> L15
        String r101 = il7.m.a().e("key_clean_cache_version", "");     // Catch: Throwable -> L15
        String r102 = r100.a();     // Catch: Throwable -> L15
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "cleanCache(): curCleanId = " + r101 + ", clearId = " + r102);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyCleanCacheManager", "清除id校验不通过，return");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L7:
        if (r101.equals(r102) == true) goto L12;
        c(r100.b());     // Catch: Throwable -> L15
        e(r100.c());     // Catch: Throwable -> L15
        d(r100.d());     // Catch: Throwable -> L15
        il7.m.a().k("key_clean_cache_version", r102);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
