package pk4;

import android.app.Application;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Application f529657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f529658b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f529659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f529660d = null;

    public static int o() {
        PowerManager r100 = (PowerManager) f529659c.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L10
        if (Build.VERSION.SDK_INT < 23) goto L13;
        if (r100.isIgnoringBatteryOptimizations(f529659c.getPackageName()) == false) goto L8;
        return 1;
    L8:
        return 2;
    L13:
        return 0;
    L15:
        return 0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static boolean h() {
        Application r100 = f529659c;
        if (r100 != null) goto L6;
        r100 = f529657a;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        LocationManager r101 = (LocationManager) r100.getSystemService("location");
        if (Build.VERSION.SDK_INT < 28) goto L15;
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r101.isLocationEnabled() == false) goto L24;
        return true;
    L24:
        return false;
    L15:
        if (r101 != null) goto L17;
    L18:
        if (r101 != null) goto L20;
        return false;
    L20:
        if (r101.isProviderEnabled("network") == false) goto L26;
    L21:
        return true;
    L26:
        return false;
    L17:
        if (r101.isProviderEnabled(GeocodeSearch.GPS) == true) goto L21;
        goto L18
    }

    public static String n() {
        StringBuilder r100 = new StringBuilder("DIRECT-G");
        Random r101 = new Random();
        StringBuilder r102 = new StringBuilder(8);
        int r103 = 0;
    L3:
        if (r103 >= 8) goto L5;
        r102.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(r101.nextInt(62)));
        r103 = r103 + 1;
        goto L3
    L5:
        r100.append(r102.toString());
        return r100.toString();
    }

    static {
        Class r100 = a();     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        Object r101 = r100.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        f529657a = (Application) r100.getMethod("getApplication", new Class[0]).invoke(r101, new Object[0]);     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        Field r102 = r100.getDeclaredField("sCurrentActivityThread");     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r102.setAccessible(true);     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        Object r103 = r102.get(null);     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        Field r104 = r100.getDeclaredField("mH");     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        r104.setAccessible(true);     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        Handler r105 = (Handler) r104.get(r103);     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        f529658b = r105;     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
        if (r105 != null) goto L18;
        f529658b = new Handler(Looper.getMainLooper());     // Catch: ClassNotFoundException -> L6 Throwable -> L8 InvocationTargetException -> L10 IllegalAccessException -> L12 NoSuchMethodException -> L14
    L18:
        f529659c = f529657a;
        f529660d = f529658b;
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        if (f529658b != null) goto L18;
        f529658b = new Handler(Looper.getMainLooper());
        goto L18
    }

    public static String e(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L14;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L10;
        r101.append(String.format("0x%02X ", new Object[]{Integer.valueOf(r100[r103] & UByte.MAX_VALUE)}));
        r103 = r103 + 1;
        goto L7
    L10:
        return r101.toString();
    L14:
        return null;
    }

    public static String f(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L14;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L10;
        r101.append(String.format("%02X", new Object[]{Integer.valueOf(r100[r103] & UByte.MAX_VALUE)}));
        r103 = r103 + 1;
        goto L7
    L10:
        return r101.toString();
    L14:
        return "";
    }

    public static String g(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length != 0) goto L7;
        return null;
    L7:
        return new String(r100).replace("\u0000", "");
    }

    public static byte[] j(float r100) {
        int r101 = Float.floatToIntBits(r100);
        return new byte[]{(byte) (r101 >> 24), (byte) (r101 >> 16), (byte) (r101 >> 8), (byte) r101};
    }

    public static byte[] k(int r100) {
        if (r100 < 0) goto L10;
        if (r100 > 65355) goto L8;
        return new byte[]{(byte) ((r100 >>> 8) & 255), (byte) (r100 & 255)};
    L8:
        throw new IllegalArgumentException("Must be less than 2^32");
    L10:
        throw new IllegalArgumentException("Must be less greater than 0");
    }

    public static byte[] l(long r100) {
        if (r100 > BodyPartID.bodyIdMax) goto L11;
        if (r100 < 0) goto L9;
        return new byte[]{(byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    L9:
        throw new IllegalArgumentException("Must be greater than 0");
    L11:
        throw new IllegalArgumentException("Must be less than 2^32");
    }

    public static byte[] m(long r100) {
        if (r100 < 0) goto L7;
        return new byte[]{(byte) ((r100 >> 56) & 255), (byte) ((r100 >> 48) & 255), (byte) ((r100 >> 40) & 255), (byte) ((r100 >> 32) & 255), (byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)};
    L7:
        throw new IllegalArgumentException("Must be greater than 0");
    }

    public static String q(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L11
        r101.update(r100);     // Catch: NoSuchAlgorithmException -> L11
        byte[] r102 = r101.digest();     // Catch: NoSuchAlgorithmException -> L11
        if (r102.length != 0) goto L6;
        return null;
    L6:
        StringBuilder r103 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L11
        int r104 = r102.length;     // Catch: NoSuchAlgorithmException -> L11
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r103.append(String.format("%02x", new Object[]{Byte.valueOf(r102[r105])}));     // Catch: NoSuchAlgorithmException -> L11
        r105 = r105 + 1;     // Catch: NoSuchAlgorithmException -> L11
        goto L7
    L9:
        return r103.toString();
    L11:
        return null;
    }

    public static Map<String, Object> r(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.opt(r103));
        goto L4
    L6:
        return r101;
    }

    public static byte[] s(int r100) {
        if (r100 < 0) goto L13;
        if (r100 > 65355) goto L11;
        if (r100 < 128) goto L9;
        return new byte[]{(byte) (((r100 / 128) % 128) | 128), (byte) (r100 % 128)};
    L9:
        return new byte[]{(byte) (r100 & 255)};
    L11:
        throw new IllegalArgumentException("Must be less than 2^32");
    L13:
        throw new IllegalArgumentException("Must be less greater than 0");
    }

    public static byte[] t(long[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101 * 8];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        long r104 = r100[r103];
        int r105 = r103 * 8;
        r102[r105] = (byte) (r104 >> 56);
        r102[r105 + 1] = (byte) (r104 >> 48);
        r102[r105 + 2] = (byte) (r104 >> 40);
        r102[r105 + 3] = (byte) (r104 >> 32);
        r102[r105 + 4] = (byte) (r104 >> 24);
        r102[r105 + 5] = (byte) (r104 >> 16);
        r102[r105 + 6] = (byte) (r104 >> 8);
        r102[r105 + 7] = (byte) r104;
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static byte[] v(byte[]... r100) {
        if (r100.length == 0) goto L5;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r102 >= r101) goto L12;
        byte[] r104 = r100[r102];
        if (r104 == null) goto L11;
        r103 = r103 + r104.length;
    L11:
        r102 = r102 + 1;
        goto L7
    L12:
        byte[] r105 = new byte[r103];
        int r106 = r100.length;
        int r107 = 0;
        int r108 = 0;
    L13:
        if (r107 >= r106) goto L20;
        byte[] r109 = r100[r107];
        if (r109 == null) goto L19;
        if (r109.length <= 0) goto L19;
        System.arraycopy(r109, 0, r105, r108, r109.length);
        r108 = r108 + r109.length;
    L19:
        r107 = r107 + 1;
        goto L13
    L20:
        return r105;
    L5:
        return new byte[0];
    }

    public static byte[] w(List<Byte> r100) {
        int r101 = r100.size();
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = ((Byte) ListProtector.get(r100, r103)).byteValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static void d(List<Byte> r100, byte[]... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        byte[] r104 = r101[r103];
        int r105 = r104.length;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        ArrayList r107 = (ArrayList) r100;
        r107.add(Byte.valueOf(r104[r106]));
        r106 = r106 + 1;
        goto L5
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static boolean i(String r100, String r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        String r102 = r101.trim();
        if (r102.isEmpty() == false) goto L9;
        return false;
    L9:
        String r103 = r100.trim();
    L11:
        if (r103.startsWith("[") == false) goto L14;
        r103 = r103.substring(1).trim();
    L14:
        if (r103.endsWith("]") == false) goto L16;
        r103 = r103.substring(0, r103.length() - 1).trim();
        goto L14
    L16:
        String[] r104 = r103.split(",");
        int r105 = r104.length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L25;
        String r107 = r104[r106];
        if (r107 == null) goto L24;
        if (r102.equals(r107.trim()) == false) goto L24;
        return true;
    L24:
        r106 = r106 + 1;
    L25:
        return false;
    }

    public static byte[] u(byte[] r100, byte[] r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L6;
        return r100;
    L6:
        byte[] r102 = Arrays.copyOf(r100, r100.length + r101.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static int b(int r100, int r101, int r102) {
        return b.a(new byte[]{(byte) r100, (byte) r101, (byte) r102});
    }

    public static int c(int r100, int r101, byte[] r102) {
        return b.a(u(new byte[]{(byte) r100, (byte) r101}, r102));
    }

    public static <K, V, T> T p(Map<K, V> r100, K r101, Class<T> r102, T r103) {
        HashMap r104 = (HashMap) r100;
        if (r104.isEmpty() == true) goto L12;
        Object r105 = r104.get(r101);
        if (r105 != null) goto L9;
        return r103;
    L9:
        if (r102.isInstance(r105) == false) goto L12;
        return r102.cast(r105);
    L12:
        return r103;
    }
}
