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
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static volatile Object a;
    public static volatile IBinder b;
    public static final int[] c = null;

    static {
        c = new int[]{-1};
    }

    public c() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.content.pm.IPackageManager$Stub");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.content.pm.IPackageManager$Stub");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static void c(Context r8) {
        ZeusLogger.d(ZeusLogger.TAG_DEX2OAT, "execDex2oatByTransactionCode start");
        int[] r0 = c;
        monitor-enter(r0);
    L42:
        th = move-exception;
        throw th;
    L6:
        Parcel r4 = null;
        if (r0[0] == (-1)) goto L49;
    L13:
        int r1 = r0[0];     // Catch: Throwable -> L42
        monitor-exit(r0);     // Catch: Throwable -> L42
        Parcel r2 = Parcel.obtain();     // Catch: Throwable -> L32
        Parcel r3 = Parcel.obtain();     // Catch: Throwable -> L30
        r2.writeInterfaceToken(b.getInterfaceDescriptor());     // Catch: Throwable -> L28
        r2.writeString(r8.getPackageName());     // Catch: Throwable -> L28
        r2.writeString("speed-profile");     // Catch: Throwable -> L28
        r2.writeInt(1);     // Catch: Throwable -> L28
        if (a(b, r1, r2, r3) == false) goto L27;
        r3.readException();     // Catch: Throwable -> L28
        if (r3.readInt() == 0) goto L25;
        ZeusLogger.d(ZeusLogger.TAG_DEX2OAT, "execDex2oatByTransactionCode end");     // Catch: Throwable -> L28
        r3.recycle();
        r2.recycle();
        return;
    L25:
        throw new IllegalStateException("performDexOptSecondary returned false");     // Catch: Throwable -> L28
    L27:
        throw new IllegalStateException("Binder transact returned false");     // Catch: Throwable -> L28
    L28:
        th = th;
        r4 = r3;
    L52:
    L36:
        th = move-exception;
        if (r4 == null) goto L39;
        r4.recycle();
    L39:
        if (r2 == null) goto L41;
        r2.recycle();
    L41:
        throw th;
    L35:
        throw new IllegalStateException("performDexOptSecondaryByTransactionCode failed", th);     // Catch: Throwable -> L36
    L30:
        th = th;
    L32:
        th = th;
        r2 = null;
        goto L52
    L49:
        Method r5 = MethodUtils.findMethod(Class.class, "getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L10
        r5.setAccessible(true);     // Catch: Throwable -> L10
        Field r6 = (Field) r5.invoke(b(), new Object[]{"TRANSACTION_performDexOptSecondary"});     // Catch: Throwable -> L10
        r6.setAccessible(true);     // Catch: Throwable -> L10
        r0[0] = ((Integer) r6.get(null)).intValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw new IllegalStateException("Cannot resolve TRANSACTION_performDexOptSecondary", th);     // Catch: Throwable -> L42
    }

    public static synchronized IBinder d(Context r4) throws IllegalStateException {
        monitor-enter(c.class);
        PackageManager r5 = r4.getPackageManager();     // Catch: Throwable -> L22
        Field r1 = FieldUtils.getField(r5.getClass(), "mPM");     // Catch: Throwable -> L22
        if (r1 != null) goto L25;
        monitor-exit(c.class);
        return null;
    L25:
    L14:
        Object r6 = null;
    L15:
        a = r6;     // Catch: Throwable -> L22
        if ((a instanceof IInterface) == true) goto L19;
        monitor-exit(c.class);
        return null;
    L19:
        IBinder r7 = ((IInterface) a).asBinder();     // Catch: Throwable -> L22
        monitor-exit(c.class);
        return r7;
    L10:
        if (r1.isAccessible() == true) goto L12;
        r1.setAccessible(true);     // Catch: Exception -> L14 Throwable -> L22
    L12:
        r6 = r1.get(r5);     // Catch: Exception -> L14 Throwable -> L22
        r1.setAccessible(false);     // Catch: Exception -> L14 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void e(Context r3) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return;
    L5:
        monitor-enter(c.class);
        b = d(r3);     // Catch: Throwable -> L14
        if (b != null) goto L9;
    L11:
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat getPmBinder failed, sPmBinder:" + b + " liveState:" + b.isBinderAlive());     // Catch: Throwable -> L14
    L12:
        monitor-exit(c.class);     // Catch: Throwable -> L14
        return;
    L9:
        if (b.isBinderAlive() == false) goto L11;
        c(r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void f(String r6) {
        if (r6 != null) goto L5;
    L26:
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat reportToBaseDexClassLoaderReporter failed, pluginPath:" + r6);
        return;
    L5:
        if (r6.isEmpty() == true) goto L26;
        Field r1 = FieldUtils.getField(BaseDexClassLoader.class, "reporter");
        if (r1 != null) goto L11;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat getReporterFiled failed");
        return;
    L11:
        Object r4 = null;
        if (r1.isAccessible() == true) goto L15;
        r1.setAccessible(true);     // Catch: Exception -> L28
    L15:
        Object r5 = r1.get(null);     // Catch: Exception -> L28
        r1.setAccessible(false);     // Catch: Exception -> L28
        r4 = r5;
    L17:
        if (r4 != null) goto L31;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat getReporter failed");
        return;
    L31:
        MethodUtils.invokeMethod(r4, "report", new Object[]{Collections.singletonMap(r6, "PCL[]")}, new Class[]{Map.class});     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "dex2oat invokeReport failed", th);
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean a(IBinder r12, int r13, Parcel r14, Parcel r15) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r5 = SystemClock.uptimeMillis();
        boolean r0 = r12.transact(r13, r14, r15, 0);     // Catch: Throwable -> L12
        long r6 = SystemClock.uptimeMillis() - r5;
        if (r6 < 100) goto L11;
        BinderPerformanceReporter.report(r6, r12.getClass().getName(), r13, 0, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r0;
    L12:
        th = move-exception;
        long r7 = SystemClock.uptimeMillis() - r5;
        if (r7 < 100) goto L22;
        if (r12 != null) goto L17;
        String r1 = XmlPullParser.NO_NAMESPACE;
    L18:
        String r3 = r1;
        BinderPerformanceReporter.report(r7, r3, r13, 0, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r1 = r12.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r12.transact(r13, r14, r15, 0);
    }
}
