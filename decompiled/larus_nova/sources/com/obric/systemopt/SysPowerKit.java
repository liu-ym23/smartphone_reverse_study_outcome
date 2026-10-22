package com.obric.systemopt;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class SysPowerKit {
    private static final String CLASS_POWER_ADVISOR = "android.os.PowerAdvisorManager";
    private static final String CLASS_POWER_LISTENER = "android.os.PowerAdvisorManager$PowerListener";
    public static final int POWER_OVER_USING = 1;
    public static final String PWR_OVERUSE_ACTION_NAME = "ActionName";
    public static final int PWR_OVERUSE_ALARM = 7;
    public static final int PWR_OVERUSE_ANINATION_LEAK = 11;
    public static final int PWR_OVERUSE_AP_SUSPEND_BLOCK = 14;
    public static final int PWR_OVERUSE_BLE_SCAN = 9;
    public static final int PWR_OVERUSE_CAMERA = 3;
    public static final String PWR_OVERUSE_COLLECT_APPLOG = "CollectAppLog";
    public static final int PWR_OVERUSE_CPU_LOAD = 1;
    public static final int PWR_OVERUSE_FLASH_LIGHT = 4;
    public static final int PWR_OVERUSE_GPS = 2;
    public static final int PWR_OVERUSE_KERNEL_WAKELOCK = 13;
    public static final int PWR_OVERUSE_KERNEL_WAKEUP = 12;
    public static final int PWR_OVERUSE_NET_PACKETS = 6;
    public static final String PWR_OVERUSE_PACKAGE_NAME = "PkgName";
    public static final int PWR_OVERUSE_PARTIAL_WAKELOCK = 5;
    public static final String PWR_OVERUSE_PID = "Pid";
    public static final int PWR_OVERUSE_SENSOR = 10;
    public static final String PWR_OVERUSE_STAT_TIME = "StatTime";
    public static final int PWR_OVERUSE_SUB_SYSTEM = 15;
    public static final String PWR_OVERUSE_THRESHOLD = "Threshold";
    public static final String PWR_OVERUSE_UID = "Uid";
    public static final int PWR_OVERUSE_WIFI_SCAN = 8;
    private static final String TAG = "SysPowerKit";
    private Method mAddPowerListenerMethod;
    private Method mApplyResourceUseMethod;
    private volatile c mExternalListener;
    private Method mGetInstanceMethod;
    private Object mListenerProxy;
    private Class<?> mPowerAdvisorClass;
    private Object mPowerAdvisorInstance;
    private Class<?> mPowerListenerInterface;
    private Method mRemovePowerListenerMethod;
    private Method mUnApplyResourceUseMethod;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SysPowerKit f404028a;

        public a(SysPowerKit r100) {
            this.f404028a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            String r103 = r101.getName();
            boolean r104 = true;
            int r105 = 0;
            if ("onPowerStateChanged".equals(r103) == false) goto L34;
            if (r102 != null) goto L6;
        L30:
            Bundle r106 = null;
            int r107 = 0;
        L31:
            SysPowerKit.access$200(this.f404028a, r105, r107, r106);
            return null;
        L6:
            if (r102.length < 3) goto L30;
            Object r108 = r102[0];     // Catch: Throwable -> L27
            if ((r108 instanceof Integer) == false) goto L11;
            int r109 = ((Integer) r108).intValue();     // Catch: Throwable -> L27
        L59:
            Object r110 = r102[1];     // Catch: Throwable -> L25
            if ((r110 instanceof Integer) == false) goto L63;
            r105 = ((Integer) r110).intValue();     // Catch: Throwable -> L25
        L63:
            Object r111 = r102[2];     // Catch: Throwable -> L23
            if ((r111 instanceof Bundle) == false) goto L21;
            r106 = (Bundle) r111;     // Catch: Throwable -> L23
        L22:
            int r112 = r105;
            r105 = r109;
            r107 = r112;
            goto L31
        L21:
            r106 = null;
        L23:
            th = move-exception;
            int r113 = r105;
            r105 = r109;
            th = th;
            int r114 = r113;
        L29:
            FLogger.f375446a.w(SysPowerKit.TAG, "listener proxy: failed to parse onPowerStateChanged args", th);
            r107 = r114;
            r106 = null;
        L25:
            th = move-exception;
            r105 = r109;
            th = th;
        L28:
            r114 = 0;
            goto L29
        L11:
            r109 = 0;
        L27:
            th = th;
            goto L28
        L34:
            if ("equals".equals(r103) == false) goto L45;
            if (r102 == null) goto L45;
            if (r102.length != 1) goto L45;
            if (r100 == r102[0]) goto L43;
            r104 = false;
        L43:
            return Boolean.valueOf(r104);
        L45:
            if ("hashCode".equals(r103) == false) goto L52;
            if (r102 == null) goto L50;
            if (r102.length != 0) goto L52;
        L50:
            return Integer.valueOf(System.identityHashCode(r100));
        L52:
            if ("toString".equals(r103) == false) goto L58;
            if (r102 != null) goto L55;
            return "SysPowerKit.SysPowerListenerProxy";
        L55:
            if (r102.length != 0) goto L58;
            return "SysPowerKit.SysPowerListenerProxy";
        L58:
            return null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SysPowerKit f404029a = null;

        static {
            f404029a = new SysPowerKit(null);
        }
    }

    public interface c {
        void a(int r100, int r101, Bundle r102);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public synchronized void removePowerListener() {
        monitor-enter(this);
        Object r100 = this.mPowerAdvisorInstance;     // Catch: Throwable -> L25
        if (r100 != null) goto L8;
        FLogger.f375446a.i(TAG, "removePowerListener: PowerAdvisor not available, no-op");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        Object r101 = this.mListenerProxy;     // Catch: Throwable -> L25
        if (r101 != null) goto L30;
        FLogger.f375446a.i(TAG, "removePowerListener: no listener registered");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L30:
        this.mRemovePowerListenerMethod.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L17
        FLogger.f375446a.i(TAG, "removePowerListener: listener removed");     // Catch: Throwable -> L17
    L15:
        this.mExternalListener = null;     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.w(TAG, "removePowerListener : failed to remove PowerListener", th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.mExternalListener = null;     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private Object createListenerProxy() {
        Class<?> r100 = this.mPowerListenerInterface;
        if (r100 == null) goto L7;
        a r101 = new a(this);
        return Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{this.mPowerListenerInterface}, r101);
    L7:
        throw new IllegalStateException("PowerListener interface not initialized");
    }

    private void ensureInitialized() {
        this.mPowerAdvisorClass = INVOKESTATIC_com_obric_systemopt_SysPowerKit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CLASS_POWER_ADVISOR);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mPowerListenerInterface = INVOKESTATIC_com_obric_systemopt_SysPowerKit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CLASS_POWER_LISTENER);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mGetInstanceMethod = this.mPowerAdvisorClass.getMethod("getInstance", new Class[0]);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mAddPowerListenerMethod = this.mPowerAdvisorClass.getMethod("addPowerListener", new Class[]{Context.class, this.mPowerListenerInterface, Integer.TYPE});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mRemovePowerListenerMethod = this.mPowerAdvisorClass.getMethod("removePowerListener", new Class[]{this.mPowerListenerInterface});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mApplyResourceUseMethod = this.mPowerAdvisorClass.getMethod("applyResourceUse", new Class[]{Context.class, String.class, Long.TYPE, String.class});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mUnApplyResourceUseMethod = this.mPowerAdvisorClass.getMethod("unApplyResourceUse", new Class[]{Context.class, String.class});     // Catch: Throwable -> L5 ClassNotFoundException -> L7
        this.mPowerAdvisorInstance = this.mGetInstanceMethod.invoke(null, new Object[0]);     // Catch: Throwable -> L5 ClassNotFoundException -> L7
    L12:
        return;
    L7:
        FLogger.f375446a.i(TAG, "ensureInitialized: PowerAdvisor not found, SDK will be no-op");
        return;
    L5:
        th = move-exception;
        FLogger.f375446a.w(TAG, "ensureInitialized: unexpected error during reflection init", th);
    }

    private SysPowerKit() {
        ensureInitialized();
    }

    public static SysPowerKit getInstance() {
        return b.f404029a;
    }

    public /* synthetic */ SysPowerKit(a r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_systemopt_SysPowerKit_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public boolean unApplyResourceUse(Context r100, String r101) {
        if (this.mPowerAdvisorInstance != null) goto L6;
        FLogger.f375446a.i(TAG, "unApplyResourceUse: PowerAdvisor not available, no-op");
        return false;
    L6:
        if (r100 != null) goto L10;
        FLogger.f375446a.w(TAG, "unApplyResourceUse: context is null");
        return false;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L24;
        FLogger.f375446a.w(TAG, "unApplyResourceUse: targetPackageName is empty");
        return false;
    L24:
        boolean r102 = true;
        Object r103 = this.mUnApplyResourceUseMethod.invoke(this.mPowerAdvisorInstance, new Object[]{r100, r101});     // Catch: Throwable -> L21
        if ((r103 instanceof Boolean) == true) goto L16;
    L18:
        r102 = false;
    L19:
        FLogger.f375446a.i(TAG, "unApplyResourceUse: target=" + r101 + ", result=" + r102);     // Catch: Throwable -> L21
        return r102;
    L16:
        if (((Boolean) r103).booleanValue() == false) goto L18;
    L21:
        th = move-exception;
        FLogger.f375446a.w(TAG, "failed to call unApplyResourceUse", th);
        return false;
    }

    private void handlePowerReport(int r100, int r101, Bundle r102) {
        c r103 = this.mExternalListener;
        if (r103 != null) goto L6;
        FLogger.f375446a.i(TAG, "handlePowerReport: no external listener, type=" + r100);
        return;
    L6:
        if (r102 != null) goto L14;
        FLogger.f375446a.w(TAG, "handlePowerReport: extra is null, type=" + r100);
        return;
    L14:
        r103.a(r100, r101, r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        FLogger.f375446a.w(TAG, "handlePowerReport: failed to dispatch to external listener", th);
    }

    public void addPowerListener(Context r100, int r101, c r102) {
        if (this.mPowerAdvisorInstance != null) goto L6;
        FLogger.f375446a.i(TAG, "addPowerListener: PowerAdvisor not available, no-op");
        return;
    L6:
        if (r100 != null) goto L9;
        FLogger.f375446a.w(TAG, "addPowerListener: context is null");
        return;
    L9:
        if (r102 != null) goto L12;
        FLogger.f375446a.w(TAG, "addPowerListener: listener is null");
        return;
    L12:
        if (r101 != 0) goto L16;
        FLogger.f375446a.i(TAG, "addPowerListener: no type selected, ignore");
        return;
    L16:
        if (this.mExternalListener == null) goto L20;
        FLogger.f375446a.w(TAG, "addPowerListener: has already done");
        return;
    L20:
        if (this.mListenerProxy != null) goto L34;
        this.mListenerProxy = createListenerProxy();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        FLogger.f375446a.w(TAG, "addPowerListener: failed to create listener proxy", th);
        return;
    L34:
        this.mAddPowerListenerMethod.invoke(this.mPowerAdvisorInstance, new Object[]{r100, this.mListenerProxy, Integer.valueOf(r101)});     // Catch: Throwable -> L29
        FLogger.f375446a.i(TAG, "addPowerListener: typeMask=" + r101);     // Catch: Throwable -> L29
        this.mExternalListener = r102;
        return;
    L29:
        th = move-exception;
        FLogger.f375446a.w(TAG, "addPowerListener: failed to add PowerListener", th);
    }

    public static /* synthetic */ void access$200(SysPowerKit r100, int r101, int r102, Bundle r103) {
        r100.handlePowerReport(r101, r102, r103);
    }

    public boolean applyResourceUse(Context r100, String r101, long r102, String r110) {
        if (this.mPowerAdvisorInstance != null) goto L6;
        FLogger.f375446a.i(TAG, "applyResourceUse: PowerAdvisor not available, no-op");
        return false;
    L6:
        if (r100 != null) goto L10;
        FLogger.f375446a.w(TAG, "applyResourceUse: context is null");
        return false;
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L14;
        FLogger.f375446a.w(TAG, "applyResourceUse: targetPackageName is empty");
        return false;
    L14:
        if (TextUtils.isEmpty(r110) == false) goto L28;
        FLogger.f375446a.w(TAG, "applyResourceUse: reason is empty");
        return false;
    L28:
        boolean r103 = true;
        Object r104 = this.mApplyResourceUseMethod.invoke(this.mPowerAdvisorInstance, new Object[]{r100, r101, Long.valueOf(r102), r110});     // Catch: Throwable -> L25
        if ((r104 instanceof Boolean) == true) goto L20;
    L22:
        r103 = false;
    L23:
        FLogger.f375446a.i(TAG, "applyResourceUse: target=" + r101 + ", result=" + r103);     // Catch: Throwable -> L25
        return r103;
    L20:
        if (((Boolean) r104).booleanValue() == false) goto L22;
    L25:
        th = move-exception;
        FLogger.f375446a.w(TAG, "failed to call applyResourceUse", th);
        return false;
    }
}
