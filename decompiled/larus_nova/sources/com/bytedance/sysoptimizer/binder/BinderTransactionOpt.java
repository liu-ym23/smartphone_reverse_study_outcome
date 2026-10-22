package com.bytedance.sysoptimizer.binder;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.alipay.sdk.m.u.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.suppress.JniExceptionCallback;
import com.bytedance.sysoptimizer.suppress.JniExceptionSuppression;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class BinderTransactionOpt {
    private static final String TAG = "BinderTransactionOpt";
    private static final AtomicBoolean binderErrorCatchAll = null;
    private static final Set<String> binderErrorCatchSet = null;
    private static final AtomicBoolean mInitFlag = null;
    private static final JniExceptionCallback sBinderTransactErrorCallback = null;
    private static final JniExceptionCallback sUnlinkToDeathErrorCallback = null;

    public BinderTransactionOpt() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        mInitFlag = new AtomicBoolean(false);
        binderErrorCatchSet = Collections.synchronizedSet(new HashSet());
        binderErrorCatchAll = new AtomicBoolean(false);
        sBinderTransactErrorCallback = new AnonymousClass1();
        sUnlinkToDeathErrorCallback = new AnonymousClass2();
    }

    private static boolean matchBinderErrorCatchList() {
        if (binderErrorCatchAll.get() == false) goto L5;
        return true;
    L5:
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        int r101 = 0;
    L7:
        if (r101 >= r100.length) goto L14;
        String r102 = r100[r101].getClassName() + "." + r100[r101].getMethodName();
        if (r102 == null) goto L13;
        if (binderErrorCatchSet.contains(r102) == false) goto L13;
        return true;
    L13:
        r101 = r101 + 1;
        goto L7
    L14:
        return false;
    }

    public static /* synthetic */ boolean access$000() {
        return matchBinderErrorCatchList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_binder_BinderTransactionOpt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static boolean parseBinderCatchList(String r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.trim().length() == 0) goto L18;
        if (r100.equals("all") == false) goto L10;
        binderErrorCatchAll.set(true);
    L10:
        String[] r102 = r100.split(i.f25853b);
    L12:
        if (r101 >= r102.length) goto L17;
        String r103 = r102[r101];
        if (r103 == null) goto L16;
        binderErrorCatchSet.add(r103);
    L16:
        r101 = r101 + 1;
        goto L12
    L17:
        return true;
    }

    public static synchronized boolean apply(Context r100, String r101) {
        monitor-enter(BinderTransactionOpt.class);
    L51:
        th = move-exception;
        throw th;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        monitor-exit(BinderTransactionOpt.class);
        return false;
    L10:
        if (Process.is64Bit() == true) goto L15;
        monitor-exit(BinderTransactionOpt.class);
        return false;
    L15:
        if (mInitFlag.get() == false) goto L19;
        monitor-exit(BinderTransactionOpt.class);
        return true;
    L19:
        if (parseBinderCatchList(r101) == true) goto L54;
        monitor-exit(BinderTransactionOpt.class);
        return false;
    L54:
        Method[] r102 = INVOKESTATIC_com_bytedance_sysoptimizer_binder_BinderTransactionOpt_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.BinderProxy").getDeclaredMethods();     // Catch: Throwable -> L49
        Method r103 = null;
        Method r104 = null;
        int r105 = 0;
    L25:
        if (r105 >= r102.length) goto L39;
        if (Modifier.isNative(r102[r105].getModifiers()) == false) goto L37;
        if (r102[r105].getName().equals("unlinkToDeathNative") == false) goto L31;
    L36:
        r103 = r102[r105];     // Catch: Throwable -> L49
        goto L37
    L31:
        if (r102[r105].getName().equals("unlinkToDeath") == true) goto L36;
        if (r102[r105].getName().equals("transactNative") == false) goto L37;
        r104 = r102[r105];     // Catch: Throwable -> L49
    L37:
        r105 = r105 + 1;     // Catch: Throwable -> L49
        goto L25
    L39:
        if (JniExceptionSuppression.apply(r100, r103, sUnlinkToDeathErrorCallback) == true) goto L43;
        monitor-exit(BinderTransactionOpt.class);
        return false;
    L43:
        if (JniExceptionSuppression.apply(r100, r104, sBinderTransactErrorCallback) == true) goto L46;
        monitor-exit(BinderTransactionOpt.class);
        return false;
    L46:
        AtomicBoolean r106 = mInitFlag;     // Catch: Throwable -> L49
        r106.set(true);     // Catch: Throwable -> L49
        boolean r107 = r106.get();     // Catch: Throwable -> L49
        monitor-exit(BinderTransactionOpt.class);
        return r107;
    L50:
        return false;
    }
}
