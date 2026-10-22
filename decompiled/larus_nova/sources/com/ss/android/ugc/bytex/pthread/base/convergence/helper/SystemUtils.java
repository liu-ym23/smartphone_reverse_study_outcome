package com.ss.android.ugc.bytex.pthread.base.convergence.helper;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.serval.svg.SVGRenderEngine;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class SystemUtils {
    private static final String TAG = "SystemUtils";
    private static Constructor<Looper> looperCst;
    private static Method looperPrepareMethod;
    private static Field looperQueueField;
    private static Field looperThreadField;
    private static Method messageNextMethod;
    private static Method messageRecycleMethod;
    private static Field messageWorkSourceUidField;
    private static Constructor publicMessageQueueConstructor;
    private static Object sThreadLocal;
    private static Method threadLocalWorkSourceRestoreMethod;
    private static Method threadLocalWorkSourceSetUidMethod;
    private static Field threadLocalsField;

    public SystemUtils() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static MessageQueue getLooperMessageQueue(Looper r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Field r101 = looperQueueField;     // Catch: Exception -> L11
        if (r101 != null) goto L9;
        r101 = Looper.class.getDeclaredField("mQueue");     // Catch: Exception -> L11
        r101.setAccessible(true);     // Catch: Exception -> L11
        looperQueueField = r101;     // Catch: Exception -> L11
    L9:
        return (MessageQueue) r101.get(r100);
    L11:
        return null;
    L5:
        return r100.getQueue();
    }

    public static ThreadLocal<Looper> getLooperThreadLocal() {
        Object r100 = sThreadLocal;
        if (r100 != null) goto L5;
        Field r101 = Looper.class.getDeclaredField("sThreadLocal");     // Catch: Exception -> L9
        r101.setAccessible(true);     // Catch: Exception -> L9
        r100 = r101.get(null);     // Catch: Exception -> L9
        sThreadLocal = r100;     // Catch: Exception -> L9
    L8:
        return (ThreadLocal) r100;
    L5:
        return (ThreadLocal) r100;
    }

    public static int getMessageWorkSourceUid(Message r100) {
        Field r101 = messageWorkSourceUidField;
        if (r101 == null) goto L9;
    L5:
        return ((Integer) r101.get(r100)).intValue();
    L7:
        return -1;
    L9:
        r101 = Message.class.getDeclaredField("workSourceUid");     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        messageWorkSourceUidField = r101;     // Catch: Throwable -> L7
        goto L5
    }

    public static Object getThreadLocals(Thread r100) {
        Field r101 = threadLocalsField;
        if (r101 == null) goto L9;
    L5:
        return r101.get(r100);
    L7:
        return null;
    L9:
        r101 = Thread.class.getDeclaredField("threadLocals");     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
        threadLocalsField = r101;     // Catch: Exception -> L7
        goto L5
    }

    public static void messageRecycleUnchecked(Message r100) {
        Method r101 = messageRecycleMethod;
        if (r101 == null) goto L8;
    L5:
        r101.invoke(r100, new Object[0]);     // Catch: Exception -> L7
        return;
    L10:
        return;
    L8:
        r101 = Message.class.getDeclaredMethod("recycleUnchecked", new Class[0]);     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
        messageRecycleMethod = r101;     // Catch: Exception -> L7
        goto L5
    }

    public static Looper newLooper() {
        Constructor<Looper> r100 = looperCst;     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        r100 = Looper.class.getDeclaredConstructor(new Class[]{Boolean.TYPE});     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
        looperCst = r100;     // Catch: Exception -> L7
    L5:
        return r100.newInstance(new Object[]{Boolean.TRUE});
    L7:
        return null;
    }

    public static MessageQueue newPublicMessageQueue() {
        Constructor r100 = publicMessageQueueConstructor;
        if (r100 == null) goto L9;
    L5:
        return (MessageQueue) r100.newInstance(new Object[]{Boolean.FALSE});
    L7:
        return null;
    L9:
        r100 = INVOKESTATIC_com_ss_android_ugc_bytex_pthread_base_convergence_helper_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.PublicMessageQueue", true, SystemUtils.class.getClassLoader()).getDeclaredConstructor(new Class[]{Boolean.TYPE});     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
        publicMessageQueueConstructor = r100;     // Catch: Exception -> L7
        goto L5
    }

    public static Message nextMessage(MessageQueue r100) {
        Method r101 = messageNextMethod;
        if (r101 == null) goto L9;
    L5:
        return (Message) r101.invoke(r100, new Object[0]);
    L7:
        return null;
    L9:
        r101 = MessageQueue.class.getDeclaredMethod(TeaEventTrack.ACTION_DRAMA_NEXT, new Class[0]);     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
        messageNextMethod = r101;     // Catch: Exception -> L7
        goto L5
    }

    public static void prepareUnquitAllowedLooper() {
        Method r100 = looperPrepareMethod;     // Catch: Exception -> L9 RuntimeException -> L7
        if (r100 != null) goto L5;
        r100 = Looper.class.getDeclaredMethod("prepare", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9 RuntimeException -> L7
        r100.setAccessible(true);     // Catch: Exception -> L9 RuntimeException -> L7
        looperPrepareMethod = r100;     // Catch: Exception -> L9 RuntimeException -> L7
    L5:
        r100.invoke(Looper.class, new Object[]{Boolean.FALSE});     // Catch: Exception -> L9 RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        throw e;
    }

    public static void setThreadLocals(Thread r100, Object r101) {
        Field r102 = threadLocalsField;
        if (r102 == null) goto L8;
    L5:
        r102.set(r100, r101);     // Catch: Exception -> L7
        return;
    L10:
        return;
    L8:
        r102 = Thread.class.getDeclaredField("threadLocals");     // Catch: Exception -> L7
        r102.setAccessible(true);     // Catch: Exception -> L7
        threadLocalsField = r102;     // Catch: Exception -> L7
        goto L5
    }

    public static boolean setupLooper(Looper r100, MessageQueue r101, Thread r102) {
        if (r100 != null) goto L14;
        return false;
    L14:
        Field r103 = looperQueueField;     // Catch: Exception -> L13
        if (r103 != null) goto L8;
        r103 = Looper.class.getDeclaredField("mQueue");     // Catch: Exception -> L13
        r103.setAccessible(true);     // Catch: Exception -> L13
        looperQueueField = r103;     // Catch: Exception -> L13
    L8:
        r103.set(r100, r101);     // Catch: Exception -> L13
        Field r104 = looperThreadField;     // Catch: Exception -> L13
        if (r104 != null) goto L11;
        r104 = Looper.class.getDeclaredField("mThread");     // Catch: Exception -> L13
        r104.setAccessible(true);     // Catch: Exception -> L13
        looperThreadField = r104;     // Catch: Exception -> L13
    L11:
        r104.set(r100, r102);     // Catch: Exception -> L13
        return true;
    L13:
        return false;
    }

    public static boolean setupLooperV2(Looper r100, Thread r101) {
        if (r100 != null) goto L11;
        return false;
    L11:
        Field r102 = looperThreadField;     // Catch: Exception -> L10
        if (r102 != null) goto L8;
        r102 = Looper.class.getDeclaredField("mThread");     // Catch: Exception -> L10
        r102.setAccessible(true);     // Catch: Exception -> L10
        looperThreadField = r102;     // Catch: Exception -> L10
    L8:
        r102.set(r100, r101);     // Catch: Exception -> L10
        return true;
    L10:
        return false;
    }

    public static void threadLocalWorkSourceRestore(long r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        Method r101 = threadLocalWorkSourceRestoreMethod;
        if (r101 == null) goto L11;
    L8:
        r101.invoke(null, new Object[]{Long.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L13:
        return;
    L11:
        r101 = INVOKESTATIC_com_ss_android_ugc_bytex_pthread_base_convergence_helper_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ThreadLocalWorkSource").getDeclaredMethod(SVGRenderEngine.RESTORE, new Class[]{Long.TYPE});     // Catch: Exception -> L10
        r101.setAccessible(true);     // Catch: Exception -> L10
        threadLocalWorkSourceRestoreMethod = r101;     // Catch: Exception -> L10
        goto L8
    }

    public static long threadLocalWorkSourceSetUid(int r100) {
        Method r101 = threadLocalWorkSourceSetUidMethod;
        if (r101 == null) goto L9;
    L5:
        ((Long) r101.invoke(null, new Object[]{Integer.valueOf(r100)})).longValue();     // Catch: Exception -> L8
        return -1;
    L11:
        return -1;
    L9:
        r101 = INVOKESTATIC_com_ss_android_ugc_bytex_pthread_base_convergence_helper_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ThreadLocalWorkSource").getDeclaredMethod("setUid", new Class[]{Integer.TYPE});     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        threadLocalWorkSourceSetUidMethod = r101;     // Catch: Exception -> L8
        goto L5
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ugc_bytex_pthread_base_convergence_helper_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ugc_bytex_pthread_base_convergence_helper_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
