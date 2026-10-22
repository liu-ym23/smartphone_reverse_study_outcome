package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.log.HMSLog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class PushPreferences {
    public static final String TAG = "PushPreferences";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SharedPreferences f276834a;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public boolean clear() {
        SharedPreferences r100 = this.f276834a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.edit().clear().commit();
    }

    public Map<String, ?> getAll() {
        SharedPreferences r100 = this.f276834a;
        if (r100 == null) goto L7;
        return r100.getAll();
    L7:
        return new HashMap();
    }

    public ContentValues read() {
        SharedPreferences r100 = this.f276834a;
        if (r100 != null) goto L5;
        return null;
    L5:
        Map<String, ?> r101 = r100.getAll();
        if (r101 != null) goto L8;
        return null;
    L8:
        ContentValues r102 = new ContentValues();
        Iterator<Map.Entry<String, ?>> r103 = r101.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L34;
        Map.Entry<String, ?> r104 = r103.next();
        String r105 = r104.getKey();
        Object r106 = r104.getValue();
        if ((r106 instanceof String) == true) goto L13;
        if ((r106 instanceof Integer) == true) goto L33;
        if ((r106 instanceof Short) == true) goto L33;
        if ((r106 instanceof Byte) == true) goto L33;
        if ((r106 instanceof Long) == true) goto L23;
        if ((r106 instanceof Float) == true) goto L26;
        if ((r106 instanceof Double) == true) goto L29;
        if ((r106 instanceof Boolean) == false) goto L10;
        r102.put(r105, (Boolean) r106);
        goto L10
    L29:
        r102.put(r105, Float.valueOf((float) ((Double) r106).doubleValue()));
        goto L10
    L26:
        r102.put(r105, (Float) r106);
        goto L10
    L23:
        r102.put(r105, (Long) r106);
    L33:
        r102.put(r105, (Integer) r106);
        goto L10
    L13:
        r102.put(r105, String.valueOf(r106));
        goto L10
    L34:
        return r102;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_aaid_utils_PushPreferences_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public boolean containsKey(String r100) {
        SharedPreferences r101 = this.f276834a;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100) == false) goto L7;
        return true;
    }

    public boolean getBoolean(String r100) {
        SharedPreferences r101 = this.f276834a;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getBoolean(r100, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int getInt(String r100) {
        SharedPreferences r101 = this.f276834a;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.getInt(r100, 0);
    }

    public long getLong(String r100) {
        SharedPreferences r101 = this.f276834a;
        if (r101 != null) goto L5;
        return 0;
    L5:
        return r101.getLong(r100, 0);
    }

    public String getString(String r100) {
        SharedPreferences r101 = this.f276834a;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getString(r100, "");
    }

    public boolean removeKey(String[] r100) {
        int r101 = 0;
        if (this.f276834a != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
    L6:
        if (r101 >= r102) goto L11;
        String r103 = r100[r101];
        if (this.f276834a.contains(r103) == false) goto L10;
        this.f276834a.edit().remove(r103);
    L10:
        r101 = r101 + 1;
        goto L6
    L11:
        this.f276834a.edit().commit();
        return true;
    }

    public void saveMap(Map<String, Object> r100) {
        Iterator<Map.Entry<String, Object>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, Object> r102 = r101.next();
        save(r102.getKey(), r102.getValue());
        goto L4
    }

    public boolean write(ContentValues r100) {
        if (this.f276834a == null) goto L13;
        if (r100 == null) goto L13;
        Iterator<Map.Entry<String, Object>> r101 = r100.valueSet().iterator();
        boolean r102 = true;
    L8:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<String, Object> r103 = r101.next();
        if (save(r103.getKey(), r103.getValue()) == true) goto L8;
        r102 = false;
        goto L8
    L12:
        return r102;
    L13:
        return false;
    }

    public boolean removeKey(String r100) {
        SharedPreferences r101 = this.f276834a;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.contains(r100) == false) goto L12;
        SharedPreferences.Editor r102 = this.f276834a.edit();
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.remove(r100).commit();
    L12:
        return false;
    }

    public PushPreferences(Context r100, String r101) {
        if (r100 == null) goto L18;
        if (Build.VERSION.SDK_INT < 24) goto L13;
        Context r102 = r100.createDeviceProtectedStorageContext();
        SharedPreferences r103 = r102.getSharedPreferences("move_to_de_records", 0);
        if (r103.getBoolean(r101, false) == false) goto L9;
    L12:
        r100 = r102;
        goto L13
    L9:
        if (r102.moveSharedPreferencesFrom(r100, r101) == false) goto L13;
        SharedPreferences.Editor r104 = r103.edit();
        r104.putBoolean(r101, true);
        r104.apply();
    L13:
        SharedPreferences r105 = b(r100, r101);
        this.f276834a = r105;
        if (r105 != null) goto L19;
        HMSLog.w(TAG, "get new sharedPreferences failed,start to get from context. ");
        this.f276834a = r100.getSharedPreferences(r101, 0);
        return;
    L19:
        return;
    L18:
        throw new NullPointerException("context is null!");
    }

    private File a(Context r100, String r101) {
    L12:
        e = move-exception;
        HMSLog.e(TAG, "get failed error." + e.getMessage());
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L7;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getDataDir() + "/shared_prefs", r101 + ".xml");     // Catch: Exception -> L12
    L8:
        if (r102.exists() == true) goto L11;
        return null;
    L11:
        return r102;
    L7:
        r102 = new PolarisFileWrapper(r100.getFilesDir().getParent() + "/shared_prefs", r101 + ".xml");     // Catch: Exception -> L12
        goto L8
    }

    private SharedPreferences b(Context r100, String r101) {
        File r102 = a(r100, r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        Constructor r103 = INVOKESTATIC_com_huawei_hms_aaid_utils_PushPreferences_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(new Class[]{File.class, Integer.TYPE});     // Catch: Exception -> L7
        r103.setAccessible(true);     // Catch: Exception -> L7
        return (SharedPreferences) r103.newInstance(new Object[]{r102, 0});
    L7:
        e = move-exception;
        HMSLog.e(TAG, "get SharedPreferences error." + e.getMessage());
        return null;
    }

    public boolean save(String r100, Object r101) {
        SharedPreferences r102 = this.f276834a;
        if (r102 != null) goto L6;
        return false;
    L6:
        SharedPreferences.Editor r103 = r102.edit();
        if ((r101 instanceof String) == false) goto L10;
        r103.putString(r100, String.valueOf(r101));
    L31:
        return r103.commit();
    L10:
        if ((r101 instanceof Integer) == false) goto L13;
        r103.putInt(r100, ((Integer) r101).intValue());
        goto L31
    L13:
        if ((r101 instanceof Short) == false) goto L16;
        r103.putInt(r100, ((Short) r101).shortValue());
        goto L31
    L16:
        if ((r101 instanceof Byte) == false) goto L19;
        r103.putInt(r100, ((Byte) r101).byteValue());
        goto L31
    L19:
        if ((r101 instanceof Long) == false) goto L22;
        r103.putLong(r100, ((Long) r101).longValue());
        goto L31
    L22:
        if ((r101 instanceof Float) == false) goto L25;
        r103.putFloat(r100, ((Float) r101).floatValue());
        goto L31
    L25:
        if ((r101 instanceof Double) == false) goto L28;
        r103.putFloat(r100, (float) ((Double) r101).doubleValue());
        goto L31
    L28:
        if ((r101 instanceof Boolean) == false) goto L31;
        r103.putBoolean(r100, ((Boolean) r101).booleanValue());
        goto L31
    }

    public void saveBoolean(String r100, boolean r101) {
        SharedPreferences r102 = this.f276834a;
        if (r102 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L9;
        r103.putBoolean(r100, r101).commit();
        return;
    }

    public void saveInt(String r100, Integer r101) {
        SharedPreferences r102 = this.f276834a;
        if (r102 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L9;
        r103.putInt(r100, r101.intValue()).commit();
        return;
    }

    public void saveLong(String r100, Long r101) {
        SharedPreferences r102 = this.f276834a;
        if (r102 != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L9;
        r103.putLong(r100, r101.longValue()).commit();
        return;
    }

    public boolean saveString(String r100, String r101) {
        SharedPreferences r102 = this.f276834a;
        if (r102 != null) goto L5;
        return false;
    L5:
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 != null) goto L8;
        return false;
    L8:
        return r103.putString(r100, r101).commit();
    }
}
