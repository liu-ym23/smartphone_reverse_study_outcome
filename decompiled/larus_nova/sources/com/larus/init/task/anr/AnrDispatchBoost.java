package com.larus.init.task.anr;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class AnrDispatchBoost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f351148a;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class DelegateInternalHandler extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Object f351149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Method f351150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static Field f351151d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f351152e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static Class<?> f351153f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f351154a;

        public static void c() {
            if (f351149b != null) goto L9;
            Method r100 = a("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]);     // Catch: Throwable -> L6
            r100.setAccessible(true);     // Catch: Throwable -> L6
            f351149b = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L6
            return;
        L9:
            return;
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

        public static void b(Object r100) {
            if (f351153f != null) goto L6;
            Class<?> r101 = r100.getClass();
            f351153f = r101;
            d(r101.getSuperclass());
        L6:
            if (f351149b != null) goto L8;
            return;
        L8:
            if (f351151d == null) goto L12;
            e(r100);
            return;
        }

        public static void d(Class<?> r110) {
            if (f351150c != null) goto L27;
            c();
            Class r100 = a("android.app.IActivityManager");     // Catch: Throwable -> L12
            if (Build.VERSION.SDK_INT >= 23) goto L9;
            Method r101 = r100.getDeclaredMethod("finishReceiver", new Class[]{IBinder.class, Integer.TYPE, String.class, Bundle.class, Boolean.TYPE});     // Catch: Throwable -> L12
        L10:
            r101.setAccessible(true);     // Catch: Throwable -> L12
        L13:
            f351150c = r101;
            if (r110 == null) goto L28;
            Field r102 = r110.getDeclaredField("mToken");     // Catch: Throwable -> L22
            f351151d = r102;     // Catch: Throwable -> L22
            if (r102 == null) goto L18;
            r102.setAccessible(true);     // Catch: Throwable -> L22
        L18:
            Field r111 = r110.getDeclaredField("mFlags");     // Catch: Throwable -> L22
            f351152e = r111;     // Catch: Throwable -> L22
            if (r111 == null) goto L29;
            r111.setAccessible(true);     // Catch: Throwable -> L22
            return;
        L29:
            return;
        L30:
            return;
        L28:
            return;
        L9:
            Class<?> r103 = Integer.TYPE;     // Catch: Throwable -> L12
            r101 = r100.getDeclaredMethod("finishReceiver", new Class[]{IBinder.class, r103, String.class, Bundle.class, Boolean.TYPE, r103});     // Catch: Throwable -> L12
        L12:
            r101 = null;
            goto L13
        }

        public static void e(Object r110) {
            Field r100 = f351151d;     // Catch: Throwable -> L14
            if (r100 != null) goto L5;
            return;
        L5:
            IBinder r101 = (IBinder) r100.get(r110);     // Catch: Throwable -> L14
            Field r102 = f351152e;     // Catch: Throwable -> L14
            if (r102 == null) goto L8;
            int r111 = ((Integer) r102.get(r110)).intValue();     // Catch: Throwable -> L14
        L10:
            if (Build.VERSION.SDK_INT >= 23) goto L12;
            f351150c.invoke(f351149b, new Object[]{r101, 0, null, null, Boolean.FALSE});     // Catch: Throwable -> L14
            return;
        L12:
            f351150c.invoke(f351149b, new Object[]{r101, 0, null, null, Boolean.FALSE, Integer.valueOf(r111)});     // Catch: Throwable -> L14
            return;
        L8:
            r111 = 0;
            goto L10
        }

        public static void f(Message r100) {
            Runnable r101 = r100.getCallback();     // Catch: Throwable -> L20
            if (r101 == null) goto L22;
            String r102 = r101.getClass().getName();     // Catch: Throwable -> L20
            if (AnrDispatchBoost.f351148a == true) goto L7;
        L7:
            boolean r103 = r102.contains("ReceiverDispatcher$Args");     // Catch: Throwable -> L20
            if (r103 == true) goto L10;
        L17:
            if (r103 == false) goto L25;
            boolean r104 = AnrDispatchBoost.f351148a;     // Catch: Throwable -> L20
            b(r101);     // Catch: Throwable -> L20
            return;
        L25:
            return;
        L10:
            if (r102.contains("Lambda") == false) goto L17;
            boolean r105 = AnrDispatchBoost.f351148a;     // Catch: Throwable -> L20
            Field[] r106 = r101.getClass().getDeclaredFields();     // Catch: Throwable -> L20
            if (r106.length != 1) goto L23;
            Field r107 = r106[0];     // Catch: Throwable -> L20
            r107.setAccessible(true);     // Catch: Throwable -> L20
            Object r108 = r107.get(r101);     // Catch: Throwable -> L20
            if (r108 != null) goto L16;
            return;
        L16:
            b(r108);     // Catch: Throwable -> L20
            return;
        L23:
            return;
        L22:
            return;
        }

        public String codeToString(int r100) {
            return "code:" + r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r110, long r111) {
            Object r100 = r110.obj;
            int r101 = 0;
            if (r100 == null) goto L7;
            String r102 = r100.getClass().getSimpleName();
            if (AnrDispatchBoost.f351148a == false) goto L9;
            codeToString(0);
            toString();
        L9:
            if ("CreateServiceData".equals(r102) == false) goto L11;
        L28:
            int r103 = r110.what;
            if (this.f351154a != null) goto L35;
            c();     // Catch: Throwable -> L48
            Object r104 = f351149b;     // Catch: Throwable -> L48
            if (r104 == null) goto L35;
            Class<?> r105 = r104.getClass();     // Catch: Throwable -> L48
            Class<?> r112 = Integer.TYPE;     // Catch: Throwable -> L48
            Method r106 = r105.getDeclaredMethod("serviceDoneExecuting", new Class[]{IBinder.class, r112, r112, r112});     // Catch: Throwable -> L48
            r106.setAccessible(true);     // Catch: Throwable -> L48
            this.f351154a = r106;     // Catch: Throwable -> L48
        L35:
            if (this.f351154a == null) goto L49;
            Object r107 = r110.obj;     // Catch: Throwable -> L48
            if (r103 == 116) goto L40;
            Field r108 = r107.getClass().getDeclaredField("token");     // Catch: Throwable -> L48
            r108.setAccessible(true);     // Catch: Throwable -> L48
            r107 = r108.get(r107);     // Catch: Throwable -> L48
        L40:
            Method r109 = this.f351154a;     // Catch: Throwable -> L48
            Object r113 = f351149b;     // Catch: Throwable -> L48
            Object[] r114 = new Object[4];     // Catch: Throwable -> L48
            r114[0] = r107;     // Catch: Throwable -> L48
            int r115 = r110.what;     // Catch: Throwable -> L48
            if (r115 == 115) goto L45;
            if (r115 != 116) goto L46;
            r101 = 2;
        L46:
            r114[1] = Integer.valueOf(r101);     // Catch: Throwable -> L48
            r114[2] = 0;     // Catch: Throwable -> L48
            r114[3] = 0;     // Catch: Throwable -> L48
            r109.invoke(r113, r114);     // Catch: Throwable -> L48
            goto L49
        L45:
            r101 = 1;
        L49:
            f(r110);
            return super.sendMessageAtTime(r110, r111);
        L11:
            if ("BindServiceData".equals(r102) == true) goto L28;
            if ("ServiceArgsData".equals(r102) == true) goto L28;
            if ("ReceiverData".equals(r102) == false) goto L49;
            Object r116 = r110.obj;
            if (r116 == null) goto L49;
            d(r116.getClass().getSuperclass());     // Catch: Throwable -> L51
            if (r110.obj == null) goto L49;
            if (f351149b == null) goto L49;
            if (f351151d == null) goto L49;
            e(r116);     // Catch: Throwable -> L51
            goto L49
        L7:
            r102 = "";
            goto L9
        }
    }
}
