package com.huawei.hms.stats;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.support.log.HMSLog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class HianalyticsExist {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f277682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f277683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f277684c;

    public HianalyticsExist() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f277682a = new Object();
    }

    public static boolean isHianalyticsExist() {
        Object r100 = f277682a;
        monitor-enter(r100);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f277683b == true) goto L18;
        boolean r101 = false;
        INVOKESTATIC_com_huawei_hms_stats_HianalyticsExist_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.hianalytics.process.HiAnalyticsInstance");     // Catch: ClassNotFoundException -> L9 Throwable -> L21
        boolean r102 = true;
    L28:
        INVOKESTATIC_com_huawei_hms_stats_HianalyticsExist_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");     // Catch: ClassNotFoundException -> L13 Throwable -> L21
        r101 = true;
    L14:
        if (r102 == false) goto L17;
        if (r101 == true) goto L17;
        f277684c = true;     // Catch: Throwable -> L21
    L17:
        f277683b = true;     // Catch: Throwable -> L21
        HMSLog.i("HianalyticsExist", "hianalytics exist: " + f277684c);     // Catch: Throwable -> L21
        goto L18
    L13:
        HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");     // Catch: Throwable -> L21
        goto L14
    L9:
        HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");     // Catch: Throwable -> L21
        r102 = false;
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L21
        return f277684c;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_stats_HianalyticsExist_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
