package gqc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Object f482290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile IBinder f482291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f482292c = null;

    static {
        f482292c = new int[]{-1};
    }

    public c() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.content.pm.IPackageManager$Stub");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.content.pm.IPackageManager$Stub");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.content.pm.IPackageManager$Stub");
    }

    public static void c(Context r100) {
        ZeusLogger.d(ZeusLogger.TAG_DEX2OAT, "execDex2oatByTransactionCode start");
        int[] r101 = f482292c;
        monitor-enter(r101);
    L42:
        th = move-exception;
        throw th;
    L6:
        Parcel r102 = null;
        if (r101[0] == (-1)) goto L49;
    L13:
        int r103 = r101[0];     // Catch: Throwable -> L42
        monitor-exit(r101);     // Catch: Throwable -> L42
        Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L32
        Parcel r105 = Parcel.obtain();     // Catch: Throwable -> L30
        r104.writeInterfaceToken(f482291b.getInterfaceDescriptor());     // Catch: Throwable -> L28
        r104.writeString(r100.getPackageName());     // Catch: Throwable -> L28
        r104.writeString("speed-profile");     // Catch: Throwable -> L28
        r104.writeInt(1);     // Catch: Throwable -> L28
        if (a(f482291b, r103, r104, r105) == false) goto L27;
        r105.readException();     // Catch: Throwable -> L28
        if (r105.readInt() == 0) goto L25;
        ZeusLogger.d(ZeusLogger.TAG_DEX2OAT, "execDex2oatByTransactionCode end");     // Catch: Throwable -> L28
        r105.recycle();
        r104.recycle();
        return;
    L25:
        throw new IllegalStateException("performDexOptSecondary returned false");     // Catch: Throwable -> L28
    L27:
        throw new IllegalStateException("Binder transact returned false");     // Catch: Throwable -> L28
    L28:
        th = th;
        r102 = r105;
    L52:
    L36:
        th = move-exception;
        if (r102 == null) goto L39;
        r102.recycle();
    L39:
        if (r104 == null) goto L41;
        r104.recycle();
    L41:
        throw th;
    L35:
        throw new IllegalStateException("performDexOptSecondaryByTransactionCode failed", th);     // Catch: Throwable -> L36
    L30:
        th = th;
    L32:
        th = th;
        r104 = null;
        goto L52
    L49:
        Method r106 = MethodUtils.findMethod(Class.class, "getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L10
        r106.setAccessible(true);     // Catch: Throwable -> L10
        Field r107 = (Field) r106.invoke(b(), new Object[]{"TRANSACTION_performDexOptSecondary"});     // Catch: Throwable -> L10
        r107.setAccessible(true);     // Catch: Throwable -> L10
        r101[0] = ((Integer) r107.get(null)).intValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw new IllegalStateException("Cannot resolve TRANSACTION_performDexOptSecondary", th);     // Catch: Throwable -> L42
    }

    public static synchronized IBinder d(Context r100) throws IllegalStateException {
        monitor-enter(c.class);
        PackageManager r101 = r100.getPackageManager();     // Catch: Throwable -> L22
        Field r102 = FieldUtils.getField(r101.getClass(), "mPM");     // Catch: Throwable -> L22
        if (r102 != null) goto L25;
        monitor-exit(c.class);
        return null;
    L25:
    L14:
        Object r103 = null;
    L15:
        f482290a = r103;     // Catch: Throwable -> L22
        if ((f482290a instanceof IInterface) == true) goto L19;
        monitor-exit(c.class);
        return null;
    L19:
        IBinder r104 = ((IInterface) f482290a).asBinder();     // Catch: Throwable -> L22
        monitor-exit(c.class);
        return r104;
    L10:
        if (r102.isAccessible() == true) goto L12;
        r102.setAccessible(true);     // Catch: Exception -> L14 Throwable -> L22
    L12:
        r103 = r102.get(r101);     // Catch: Exception -> L14 Throwable -> L22
        r102.setAccessible(false);     // Catch: Exception -> L14 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void e(Context r100) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return;
    L5:
        monitor-enter(c.class);
        f482291b = d(r100);     // Catch: Throwable -> L14
        if (f482291b != null) goto L9;
    L11:
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat getPmBinder failed, sPmBinder:" + f482291b + " liveState:" + f482291b.isBinderAlive());     // Catch: Throwable -> L14
    L12:
        monitor-exit(c.class);     // Catch: Throwable -> L14
        return;
    L9:
        if (f482291b.isBinderAlive() == false) goto L11;
        c(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void f(String r100) {
        if (r100 != null) goto L5;
    L26:
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat reportToBaseDexClassLoaderReporter failed, pluginPath:" + r100);
        return;
    L5:
        if (r100.isEmpty() == true) goto L26;
        Field r101 = FieldUtils.getField(BaseDexClassLoader.class, "reporter");
        if (r101 != null) goto L11;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat getReporterFiled failed");
        return;
    L11:
        Object r102 = null;
        if (r101.isAccessible() == true) goto L15;
        r101.setAccessible(true);     // Catch: Exception -> L28
    L15:
        Object r103 = r101.get(null);     // Catch: Exception -> L28
        r101.setAccessible(false);     // Catch: Exception -> L28
        r102 = r103;
    L17:
        if (r102 != null) goto L31;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat getReporter failed");
        return;
    L31:
        MethodUtils.invokeMethod(r102, "report", new Object[]{Collections.singletonMap(r100, "PCL[]")}, new Class[]{Map.class});     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat invokeReport failed", th);
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean a(IBinder r110, int r111, Parcel r112, Parcel r113) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, 0);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, 0, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        String r105 = r104;
        BinderPerformanceReporter.report(r103, r105, r111, 0, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, 0);
    }
}
