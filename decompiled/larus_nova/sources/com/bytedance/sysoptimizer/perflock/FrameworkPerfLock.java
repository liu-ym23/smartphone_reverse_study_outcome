package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class FrameworkPerfLock {
    private static final String TAG = "FrameworkPerfLock";
    private static final int[] sMTKPowerHalExtendParas = null;
    private static final int[] sMTKPowerHalParas = null;
    private static final int[] sQualcommPerfLockExtendGPU = null;
    private static final int[] sQualcommPerfLockParas = null;

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.perflock.FrameworkPerfLock$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class HuaweiAwarePerfLock extends PerfLockImpl {
        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private HuaweiAwarePerfLock() {
        }

        public /* synthetic */ HuaweiAwarePerfLock(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$HuaweiAwarePerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKESTATIC_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$HuaweiAwarePerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.rms.iaware.IAwareSdk");
            this.mPerfClazz = r101;
            if (r101 == null) goto L6;
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(r101, "asyncSendData", new Class[]{String.class, Integer.TYPE});
            return true;
        L6:
            return false;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            if (r100 != null) goto L5;
        L7:
            int r102 = 4099;
        L8:
            Method r103 = this.mPerfBoostMethod;
            if (r103 == null) goto L12;
            r103.invoke(null, new Object[]{"UniperfClient", Integer.valueOf(r102)});
            return true;
        L12:
            return false;
        L5:
            if (r100.length <= 0) goto L7;
            r102 = r100[0];
            goto L8
        }
    }

    public static class HuaweiUniperfPerfLock extends PerfLockImpl {
        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private HuaweiUniperfPerfLock() {
        }

        public /* synthetic */ HuaweiUniperfPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$HuaweiUniperfPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKESTATIC_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$HuaweiUniperfPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.iawareperf.UniPerf");
            this.mPerfClazz = r101;
            Method r102 = DoubleReflectUtils.getMethodInner(r101, "getInstance", new Class[0]);
            if (r102 == null) goto L6;
            this.mPerfClazzObj = r102.invoke(null, new Object[0]);
        L6:
            if (this.mPerfClazzObj == null) goto L9;
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "uniPerfEvent", new Class[]{Integer.TYPE, String.class, int[].class});
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            if (r100 != null) goto L5;
        L7:
            int r102 = 4099;
        L8:
            Method r103 = this.mPerfBoostMethod;
            if (r103 == null) goto L12;
            r103.invoke(this.mPerfClazzObj, new Object[]{Integer.valueOf(r102), "", new int[]{r101}});
            return true;
        L12:
            return false;
        L5:
            if (r100.length <= 0) goto L7;
            r102 = r100[0];
            goto L8
        }
    }

    public static class MTCommonPerfLock extends PerfLockImpl {
        private MTCommonPerfLock() {
        }

        public /* synthetic */ MTCommonPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$MTCommonPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader.getSystemClassLoader(), "com.mediatek.boostframework.Performance");
            this.mPerfClazz = r101;
            this.mPerfClazzObj = r101.newInstance();
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", new Class[]{Integer.TYPE, int[].class});
            return true;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$MTCommonPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            if (r100 != null) goto L4;
            r100 = new int[]{8388608, 4, 8388864, 4, 4194304, 16777215, 4194560, 16777215};
        L4:
            Method r102 = this.mPerfBoostMethod;
            if (r102 == null) goto L8;
            r102.invoke(this.mPerfClazzObj, new Object[]{Integer.valueOf(r101), r100});
            return true;
        L8:
            return false;
        }
    }

    public static class MTPowerHALPerfLock extends PerfLockImpl {
        private MTPowerHALPerfLock() {
        }

        public /* synthetic */ MTPowerHALPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$MTPowerHALPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader.getSystemClassLoader(), "com.mediatek.powerhalmgr.PowerHalMgrImpl");
            this.mPerfClazz = r101;
            this.mPerfClazzObj = r101.newInstance();
            Class<?> r102 = this.mPerfClazz;
            Class r103 = Integer.TYPE;
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(r102, "perfLockAcquire", new Class[]{r103, r103, int[].class});
            return true;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$MTPowerHALPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            if ((this.mExtendBoostEnableLevel & 1) == 0) goto L6;
            if (r100 != null) goto L8;
            r100 = FrameworkPerfLock.access$1000();
        L8:
            Method r102 = this.mPerfBoostMethod;
            if (r102 == null) goto L12;
            r102.invoke(this.mPerfClazzObj, new Object[]{0, Integer.valueOf(r101), r100});
            return true;
        L12:
            return false;
        L6:
            if (r100 != null) goto L8;
            r100 = FrameworkPerfLock.access$1100();
            goto L8
        }
    }

    public static class OppoPerfLock extends PerfLockImpl {
        private OppoPerfLock() {
        }

        public /* synthetic */ OppoPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$OppoPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader.getSystemClassLoader(), "android.os.PerformanceManager");
            this.mPerfClazz = r101;
            if (r101 == null) goto L6;
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(r101, "enableMultiThreadOptimize", new Class[0]);
            return true;
        L6:
            return false;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$OppoPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            Method r102 = this.mPerfBoostMethod;
            if (r102 == null) goto L6;
            r102.invoke(null, new Object[0]);
            return true;
        L6:
            return false;
        }
    }

    public static abstract class PerfLockImpl {
        int mExtendBoostEnableLevel;
        Method mPerfBoostMethod;
        Class<?> mPerfClazz;
        Object mPerfClazzObj;

        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            return false;
        }

        public boolean preparePerfParasImpl(Context r100) throws Exception {
            return false;
        }

        public PerfLockImpl() {
            this.mExtendBoostEnableLevel = 0;
        }

        public final boolean preparePerfParas(Context r100) {
            return preparePerfParasImpl(r100);
        L4:
            e = move-exception;
            e.toString();
            return false;
        }

        public final void setExtendBoostEnable(int r100) {
            this.mExtendBoostEnableLevel = r100;
        }

        public final boolean invokePerfBoost(int[] r100, int r101) {
            return invokePerfBoostImpl(r100, r101);
        L4:
            e = move-exception;
            e.toString();
            return false;
        }
    }

    public static class QualCommPerfLock extends PerfLockImpl {
        private AtomicBoolean mHasFixed;
        private Class<?> mQPerformanceClazz;
        private Field mRestrictUnTrustedAppAccessField;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private void fixQualcommUnTrustedAppAccessIssue() {
            if (PerfLockBooster.sFixQualUnTrustedAppAccessIssue == true) goto L5;
            return;
        L5:
            if (this.mHasFixed.compareAndSet(false, true) == false) goto L16;
            Class<?> r100 = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$QualCommPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader.getSystemClassLoader(), "com.qualcomm.qti.Performance");     // Catch: Throwable -> L10
            this.mQPerformanceClazz = r100;     // Catch: Throwable -> L10
            Field r101 = DoubleReflectUtils.getFieldInner(r100, "RestrictUnTrustedAppAccess");     // Catch: Throwable -> L10
            this.mRestrictUnTrustedAppAccessField = r101;     // Catch: Throwable -> L10
            if (r101 == null) goto L17;
            Objects.toString(r101.get(null));     // Catch: Throwable -> L10
            this.mRestrictUnTrustedAppAccessField.setBoolean(null, false);     // Catch: Throwable -> L10
            Objects.toString(this.mRestrictUnTrustedAppAccessField.get(null));     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        }

        private QualCommPerfLock() {
            this.mHasFixed = new AtomicBoolean(false);
        }

        public /* synthetic */ QualCommPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$QualCommPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKESTATIC_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$QualCommPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.util.BoostFramework");
            this.mPerfClazz = r101;
            this.mPerfClazzObj = DoubleReflectUtils.getConstructor(r101, new Class[]{Context.class}).newInstance(new Object[]{r100});     // Catch: Throwable -> L5
        L6:
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", new Class[]{Integer.TYPE, int[].class});
            return true;
        L5:
            this.mPerfClazzObj = DoubleReflectUtils.getConstructor(this.mPerfClazz, new Class[0]).newInstance(new Object[0]);
            goto L6
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$QualCommPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            fixQualcommUnTrustedAppAccessIssue();
            if (this.mPerfBoostMethod != null) goto L5;
            return false;
        L5:
            if ((this.mExtendBoostEnableLevel & 1) == 0) goto L8;
            if (r100 != null) goto L10;
            r100 = FrameworkPerfLock.access$800();
        L10:
            Object r102 = this.mPerfBoostMethod.invoke(this.mPerfClazzObj, new Object[]{Integer.valueOf(r101), r100});
            if (r102 == null) goto L17;
            r102.toString();
            if (((Integer) r102).intValue() <= 0) goto L18;
            return true;
        L18:
            return false;
        L17:
            return false;
        L8:
            if (r100 != null) goto L10;
            r100 = FrameworkPerfLock.access$900();
            goto L10
        }
    }

    public static class QualcommOriginPerfLock extends PerfLockImpl {
        private AtomicBoolean mHasFixed;
        private Field mRestrictUnTrustedAppAccessField;

        private void fixQualcommUnTrustedAppAccessIssue() {
            if (PerfLockBooster.sFixQualUnTrustedAppAccessIssue == true) goto L5;
            return;
        L5:
            if (this.mHasFixed.compareAndSet(false, true) == false) goto L16;
            Field r100 = DoubleReflectUtils.getFieldInner(this.mPerfClazz, "RestrictUnTrustedAppAccess");     // Catch: Throwable -> L10
            this.mRestrictUnTrustedAppAccessField = r100;     // Catch: Throwable -> L10
            if (r100 == null) goto L17;
            Objects.toString(r100.get(null));     // Catch: Throwable -> L10
            this.mRestrictUnTrustedAppAccessField.setBoolean(null, false);     // Catch: Throwable -> L10
            Objects.toString(this.mRestrictUnTrustedAppAccessField.get(null));     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        }

        private QualcommOriginPerfLock() {
            this.mHasFixed = new AtomicBoolean(false);
        }

        public /* synthetic */ QualcommOriginPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            Class<?> r101 = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$QualcommOriginPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader.getSystemClassLoader(), "com.qualcomm.qti.Performance");
            this.mPerfClazz = r101;
            this.mPerfClazzObj = DoubleReflectUtils.getConstructor(r101, new Class[]{Context.class}).newInstance(new Object[]{r100});
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(this.mPerfClazz, "perfLockAcquire", new Class[]{Integer.TYPE, int[].class});
            return true;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$QualcommOriginPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            fixQualcommUnTrustedAppAccessIssue();
            if (this.mPerfBoostMethod == null) goto L12;
            if (r100 != null) goto L6;
            r100 = FrameworkPerfLock.access$900();
        L6:
            Object r102 = this.mPerfBoostMethod.invoke(this.mPerfClazzObj, new Object[]{Integer.valueOf(r101), r100});
            if (r102 == null) goto L13;
            r102.toString();
            if (((Integer) r102).intValue() <= 0) goto L14;
            return true;
        L14:
            return false;
        L13:
            return false;
        L12:
            return false;
        }
    }

    public static class VivoPerfLock extends PerfLockImpl {
        private VivoPerfLock() {
        }

        public /* synthetic */ VivoPerfLock(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean preparePerfParasImpl(Context r100) throws Exception {
            ClassLoader r101 = ClassLoader.getSystemClassLoader();
            Class r102 = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$VivoPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, "vivo.app.VivoFrameworkFactory");
            this.mPerfClazz = INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$VivoPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, "vivo.app.vperf.AbsVivoPerfManager");
            Method r103 = DoubleReflectUtils.getMethodInner(r102, "getFrameworkFactoryImpl", new Class[0]);
            Object r104 = null;
            if (r103 == null) goto L5;
            r104 = r103.invoke(null, new Object[0]);
        L5:
            Method r105 = DoubleReflectUtils.getMethodInner(r102, "getVivoPerfManager", new Class[]{Context.class});
            if (r105 == null) goto L9;
            if (r104 == null) goto L9;
            this.mPerfClazzObj = r105.invoke(r104, new Object[]{r100});
        L9:
            Class<?> r106 = this.mPerfClazz;
            if (r106 != null) goto L12;
        L15:
            return false;
        L12:
            if (this.mPerfClazzObj == null) goto L15;
            this.mPerfBoostMethod = DoubleReflectUtils.getMethodInner(r106, "perfLockAcquire", new Class[]{Integer.TYPE, int[].class});
            return true;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKEVIRTUAL_com_bytedance_sysoptimizer_perflock_FrameworkPerfLock$VivoPerfLock_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        L7:
            return r104;
        L8:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r101);
        L12:
            throw th;
        L34:
            Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        L16:
            return r105;
        L17:
            th = move-exception;
            if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r101);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.loadClass(r101);
        }

        @Override // com.bytedance.sysoptimizer.perflock.FrameworkPerfLock.PerfLockImpl
        public boolean invokePerfBoostImpl(int[] r100, int r101) throws Exception {
            if (this.mPerfBoostMethod != null) goto L5;
            return false;
        L5:
            if ((this.mExtendBoostEnableLevel & 1) == 0) goto L8;
            if (r100 != null) goto L10;
            r100 = FrameworkPerfLock.access$800();
        L10:
            Object r102 = this.mPerfBoostMethod.invoke(this.mPerfClazzObj, new Object[]{Integer.valueOf(r101), r100});
            if (r102 == null) goto L17;
            r102.toString();
            if (((Integer) r102).intValue() <= 0) goto L18;
            return true;
        L18:
            return false;
        L17:
            return false;
        L8:
            if (r100 != null) goto L10;
            r100 = FrameworkPerfLock.access$900();
            goto L10
        }
    }

    static {
        sQualcommPerfLockParas = new int[]{1077936128, 1, 1086324736, 1, 1082146816, UnixStat.PERM_MASK, 1082147072, UnixStat.PERM_MASK, 1082147328, UnixStat.PERM_MASK, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1082130944, UnixStat.PERM_MASK, 1099005952, 255, 1098907648, 255, 1086455808, 20, 1086439424, 30};
        sQualcommPerfLockExtendGPU = new int[]{1077936128, 1, 1086324736, 1, 1082146816, UnixStat.PERM_MASK, 1082147072, UnixStat.PERM_MASK, 1082147328, UnixStat.PERM_MASK, 1082130432, UnixStat.PERM_MASK, 1082130688, UnixStat.PERM_MASK, 1082130944, UnixStat.PERM_MASK, 1099005952, 255, 1098907648, 255, 1086455808, 20, 1086439424, 30, 1124073472, 255, 1119944704, 1, 1128267776, 65535, 1115734016, UnixStat.PERM_MASK, 1115750400, UnixStat.PERM_MASK};
        sMTKPowerHalParas = new int[]{8388608, 4, 8388864, 4, 21037056, 1, 4194304, 16777215, 4194560, 16777215, 4194816, 16777215};
        sMTKPowerHalExtendParas = new int[]{8388608, 4, 8388864, 4, 21037056, 1, 4194304, 16777215, 4194560, 16777215, 4194816, 16777215, 12582912, 16777215, 12599296, 16777215};
    }

    private FrameworkPerfLock() {
    }

    public static /* synthetic */ int[] access$1000() {
        return sMTKPowerHalExtendParas;
    }

    public static /* synthetic */ int[] access$1100() {
        return sMTKPowerHalParas;
    }

    public static /* synthetic */ int[] access$800() {
        return sQualcommPerfLockExtendGPU;
    }

    public static /* synthetic */ int[] access$900() {
        return sQualcommPerfLockParas;
    }

    public static PerfLockImpl getPerfLockImplByType(int r100) {
        AnonymousClass1 r101 = null;
        switch(r100) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L15;
        };
    L5:
        PerfLockImpl r102 = new MTPowerHALPerfLock(r101);
    L14:
        return r102;
    L6:
        r102 = new VivoPerfLock(r101);
        goto L14
    L7:
        r102 = new OppoPerfLock(r101);
        goto L14
    L8:
        r102 = new HuaweiUniperfPerfLock(r101);
        goto L14
    L9:
        r102 = new HuaweiAwarePerfLock(r101);
        goto L14
    L10:
        r102 = new MTCommonPerfLock(r101);
        goto L14
    L11:
        r102 = new QualcommOriginPerfLock(r101);
        goto L14
    L12:
        r102 = new QualCommPerfLock(r101);
        goto L14
    L15:
        return null;
    }
}
