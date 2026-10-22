package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f277913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f277914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277915c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f277916d;

    public Util() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f277915c = new Object();
    }

    public static String getProductCountry() {
        String r100 = getSystemProperties("ro.product.locale.region", "");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        String r101 = getSystemProperties("ro.product.locale", "");
        if (TextUtils.isEmpty(r101) == true) goto L11;
        int r102 = r101.lastIndexOf("-");
        if (r102 == (-1)) goto L11;
        return r101.substring(r102 + 1);
    L11:
        String r103 = SystemUtils.getLocalCountry();
        if (TextUtils.isEmpty(r103) == false) goto L14;
        return "";
    L14:
        return r103;
    }

    public static boolean isChinaROM() {
        return SystemUtils.isChinaROM();
    }

    public static boolean isEMUI() {
        return SystemUtils.isEMUI();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_utils_Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String getAppId(Context r100) {
        return AGCUtils.getAppId(r100);
    }

    public static String getCpId(Context r100) {
        return AGCUtils.getCpId(r100);
    }

    public static int getHmsVersion(Context r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L26;
        HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
        return 0;
    L26:
        ApplicationInfo r102 = r101.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L21 AndroidException -> L24
        if (r102 == null) goto L19;
        Bundle r103 = r102.metaData;     // Catch: RuntimeException -> L21 AndroidException -> L24
        if (r103 == null) goto L19;
        Object r104 = r103.get("com.huawei.hms.version");     // Catch: RuntimeException -> L21 AndroidException -> L24
        if (r104 == null) goto L19;
        String r105 = String.valueOf(r104);     // Catch: RuntimeException -> L21 AndroidException -> L24
        if (TextUtils.isEmpty(r105) == true) goto L19;
        return StringUtil.convertVersion2Integer(r105);
    L19:
        HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");     // Catch: RuntimeException -> L21 AndroidException -> L24
        return 0;
    L24:
        HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
        return 0;
    L21:
        e = move-exception;
        HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.", e);
        return 0;
    }

    public static String getNetType(Context r100) {
        return SystemUtils.getNetType(r100);
    }

    public static String getServiceActionMetadata(Context r100) {
        String r101 = f277916d;
        if (r101 == null) goto L14;
        return r101;
    L14:
        Intent r102 = new Intent(PackageConstants.INTERNAL_SERVICES_ACTION);     // Catch: Exception -> L7
        r102.setPackage(r100.getPackageName());     // Catch: Exception -> L7
        ResolveInfo r103 = r100.getPackageManager().resolveService(r102, 128);     // Catch: Exception -> L7
    L9:
        if (r103 == null) goto L12;
        f277916d = PackageConstants.INTERNAL_SERVICES_ACTION;
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    L12:
        f277916d = "";
        return "";
    L7:
        e = move-exception;
        HMSLog.e("Util", "Exception when getServiceActionMetadata. " + e.getMessage());
        r103 = null;
        goto L9
    }

    public static boolean isAvailableLibExist(Context r100) {
        if (r100 == null) goto L4;
        Object r101 = f277915c;
        monitor-enter(r101);
    L34:
        th = move-exception;
        throw th;
    L8:
        if (f277913a == true) goto L31;
        PackageManager r102 = r100.getPackageManager();     // Catch: Throwable -> L34
        if (r102 != null) goto L41;
        HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");     // Catch: Throwable -> L34
        INVOKESTATIC_com_huawei_hms_utils_Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.hms.adapter.AvailableAdapter");     // Catch: ClassNotFoundException -> L14 Throwable -> L34
    L13:
        boolean r103 = true;
    L30:
        f277914b = r103;     // Catch: Throwable -> L34
        f277913a = true;     // Catch: Throwable -> L34
        goto L31
    L14:
        HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");     // Catch: Throwable -> L34
    L29:
        r103 = false;
        goto L30
    L41:
        ApplicationInfo r104 = r102.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L26 AndroidException -> L28 Throwable -> L34
        if (r104 == null) goto L29;
        Bundle r105 = r104.metaData;     // Catch: RuntimeException -> L26 AndroidException -> L28 Throwable -> L34
        if (r105 == null) goto L29;
        Object r106 = r105.get("availableLoaded");     // Catch: RuntimeException -> L26 AndroidException -> L28 Throwable -> L34
        if (r106 == null) goto L29;
        if (String.valueOf(r106).equalsIgnoreCase(BdpAppEventConstant.YES) == false) goto L29;
        HMSLog.i("Util", "available exist: true");     // Catch: RuntimeException -> L26 AndroidException -> L28 Throwable -> L34
    L28:
        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");     // Catch: Throwable -> L34
    L26:
        e = move-exception;
        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.", e);     // Catch: Throwable -> L34
    L31:
        monitor-exit(r101);     // Catch: Throwable -> L34
        HMSLog.i("Util", "available exist: " + f277914b);
        return f277914b;
    L4:
        return f277914b;
    }

    public static int compareHmsVersion(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return -1;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return 1;
    L9:
        if (StringUtil.checkVersion(r100) == true) goto L11;
    L34:
        return 0;
    L11:
        if (StringUtil.checkVersion(r101) == false) goto L34;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (2 >= r102.length) goto L34;
        if (2 >= r103.length) goto L34;
        if (CastIntegerProtector.parseInt(r102[0]) <= CastIntegerProtector.parseInt(r103[0])) goto L20;
        return 1;
    L20:
        if (CastIntegerProtector.parseInt(r102[0]) >= CastIntegerProtector.parseInt(r103[0])) goto L23;
        return -1;
    L23:
        if (CastIntegerProtector.parseInt(r102[1]) <= CastIntegerProtector.parseInt(r103[1])) goto L26;
        return 1;
    L26:
        if (CastIntegerProtector.parseInt(r102[1]) >= CastIntegerProtector.parseInt(r103[1])) goto L29;
        return -1;
    L29:
        if (CastIntegerProtector.parseInt(r102[2]) <= CastIntegerProtector.parseInt(r103[2])) goto L32;
        return 1;
    L32:
        if (CastIntegerProtector.parseInt(r102[2]) >= CastIntegerProtector.parseInt(r103[2])) goto L34;
        return -1;
    }

    public static Activity getActiveActivity(Activity r100, Context r101) {
        return UIUtil.getActiveActivity(r100, r101);
    }

    public static String getAppName(Context r100, String r101) {
        if (r100 != null) goto L6;
        HMSLog.e("Util", "In getAppName, context is null.");
        return "";
    L6:
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L20;
        HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
        return "";
    L20:
    L18:
        HMSLog.e("Util", "In getAppName, Failed to get app name.");
        return "";
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        r101 = r100.getPackageName();     // Catch: Throwable -> L18
    L13:
        CharSequence r103 = r102.getApplicationLabel(r102.getApplicationInfo(r101, 128));     // Catch: Throwable -> L18
        if (r103 == null) goto L22;
        return r103.toString();
    L22:
        return "";
    }

    public static String getProcessName(Context r100, int r101) {
        return UIUtil.getProcessName(r100, r101);
    }

    public static String getSystemProperties(String r100, String r101) {
        return SystemUtils.getSystemProperties(r100, r101);
    }

    public static Activity getValidActivity(Activity r100, Activity r101) {
        if (r100 != null) goto L4;
    L5:
        if (r101 != null) goto L7;
    L10:
        return null;
    L7:
        if (r101.isFinishing() == true) goto L10;
        return r101;
    L4:
        if (r100.isFinishing() == true) goto L5;
        return r100;
    }

    public static void unBindServiceCatchException(Context r100, ServiceConnection r101) {
        HMSLog.i("Util", "Trying to unbind service from " + r101);     // Catch: Exception -> L5
        r100.unbindService(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        HMSLog.e("Util", "On unBindServiceException:" + e.getMessage());
    }
}
