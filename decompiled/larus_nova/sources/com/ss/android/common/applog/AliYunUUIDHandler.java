package com.ss.android.common.applog;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class AliYunUUIDHandler {
    private static AliYunUUIDHandler sAliYunUUIDHandler;
    private String mCloudUUID;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static AliYunUUIDHandler inst() {
        if (sAliYunUUIDHandler != null) goto L15;
        monitor-enter(AliYunUUIDHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sAliYunUUIDHandler != null) goto L9;
        sAliYunUUIDHandler = new AliYunUUIDHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AliYunUUIDHandler.class);     // Catch: Throwable -> L11
    L15:
        return sAliYunUUIDHandler;
    }

    private static boolean isAliYunOs() {
        if (System.getProperty("java.vm.name") != null) goto L6;
    L7:
        if (System.getProperty("ro.yunos.version") != null) goto L16;
        return false;
    L16:
        return true;
    L6:
        if (System.getProperty("java.vm.name").toLowerCase().contains("lemur") == false) goto L7;
        return true;
    L17:
        return false;
    }

    private AliYunUUIDHandler() {
        if (isAliYunOs() == false) goto L8;
        String r100 = getCommonCloudUUID();
        this.mCloudUUID = r100;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        this.mCloudUUID = getMeiZuCloudUUID();
        return;
    L9:
        return;
    }

    private static String getCommonCloudUUID() {
        return getSystemProperty("ro.aliyun.clouduuid", "false");
    }

    private static String getMeiZuCloudUUID() {
        return getSystemProperty("ro.sys.aliyun.clouduuid", "false");
    }

    public String getCloudUUID() {
        return this.mCloudUUID;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_common_applog_AliYunUUIDHandler_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String getSystemProperty(String r100, String r101) {
        return (String) INVOKESTATIC_com_ss_android_common_applog_AliYunUUIDHandler_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r100, r101});
    L4:
        return r101;
    }
}
