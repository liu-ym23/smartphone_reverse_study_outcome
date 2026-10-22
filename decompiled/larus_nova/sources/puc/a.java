package puc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public class a {
    private static final int FLAGS_GET_ONLY_FROM_ANDROID = 16777216;
    public static final int FLAG_LOC_GPS = 1;
    public static final int FLAG_LOC_NETWORK = 2;
    public static final int FLAG_LOC_PASSIVE = 4;
    public static final String NODEX_PROCESS_SUFFIX = ":nodex";
    public static boolean sIsInited;
    public static boolean sIsMiui;

    public a() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isOnePlusDevice() {
        String r100 = Build.MODEL;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith("oneplus") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().contains("oneplus") == true) goto L12;
    L19:
        return false;
    }

    public static boolean isOppoDevice() {
        String r100 = Build.BRAND;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith(AppConstants.CHANNEL_OPPO) == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().startsWith(AppConstants.CHANNEL_OPPO) == true) goto L12;
    L19:
        return false;
    }

    public static boolean isRealMeDevice() {
        String r100 = Build.MODEL;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith("realme") == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().contains("realme") == true) goto L12;
    L19:
        return false;
    }

    public static boolean isVivoDevice() {
        String r100 = Build.BRAND;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L8:
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L14
        if (StringUtils.isEmpty(r101) == true) goto L17;
        if (r101.toLowerCase().startsWith(DimLocationCheckUtil.VIVO) == false) goto L18;
    L12:
        return true;
    L18:
        return false;
    L17:
        return false;
    L7:
        if (r100.toLowerCase().startsWith(DimLocationCheckUtil.VIVO) == true) goto L12;
    L19:
        return false;
    }

    public static boolean isFlyme() {
        String r100 = Build.DISPLAY;
        if (StringUtils.isEmpty(r100) == true) goto L7;
        if (r100.indexOf("Flyme") < 0) goto L7;
        return true;
    L7:
        if (StringUtils.isEmpty(Build.USER) == false) goto L9;
        return false;
    L9:
        if (Build.USER.equals("flyme") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isMiui() {
        if (sIsInited == true) goto L11;
        if (INVOKESTATIC_live_ss_android_common_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("miui.os.Build") == null) goto L9;
        sIsMiui = true;     // Catch: Exception -> L12
        sIsInited = true;     // Catch: Exception -> L12
        return true;
    L9:
        sIsInited = true;
    L11:
        return sIsMiui;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_live_ss_android_common_util_ToolUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String getApplicationName(Context r100) {
        ApplicationInfo r101 = null;
        PackageManager r102 = r100.getApplicationContext().getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L6
        r101 = r102.getApplicationInfo(r100.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L9
    L8:
        return (String) r102.getApplicationLabel(r101);
    L6:
        r102 = null;
        goto L8
    }

    public static Intent getLaunchIntentForPackage(Context r100, String r101) {
        Intent r102 = r100.getPackageManager().getLaunchIntentForPackage(r101);
        if (r102 != null) goto L6;
        return r102;
    L6:
        if (r102.hasCategory("android.intent.category.LAUNCHER") == true) goto L8;
        r102.addCategory("android.intent.category.LAUNCHER");
        Logger.d("ToolUtils", "add category LAUNCHER in launch intent");
    L8:
        r102.setPackage(null);
        r102.addFlags(2097152);
        r102.addFlags(268435456);
        return r102;
    }

    public static boolean isInstalledApp(Context r100, Intent r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentActivities(r101, 65536);
        if (r102 != null) goto L8;
    L11:
        return false;
    L8:
        if (r102.size() <= 0) goto L11;
        return true;
    }

    public static void openInstalledApp(Context r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (StringUtils.isEmpty(r101) == true) goto L12;
        Intent r102 = r100.getPackageManager().getLaunchIntentForPackage(r101);     // Catch: Exception -> L8
        r102.addFlags(268435456);     // Catch: Exception -> L8
        r100.startActivity(r102);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    public static boolean isInstalledApp(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == false) goto L12;
        return false;
    L12:
        if (r100.getPackageManager().getPackageInfo(r101, 16777216) != null) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    }

    public static void runApplication(Context r100, String r101, String r102) {
        if (StringUtils.isEmpty(r101) == true) goto L5;
        boolean r103 = isInstalledApp(r100, r101);
    L6:
        if (r103 == false) goto L12;
        Intent r104 = getLaunchIntentForPackage(r100, r101);
        if (r104 == null) goto L12;
        r100.startActivity(r104);
        return;
    L12:
        if (StringUtils.isEmpty(r102) == true) goto L17;
        r100.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r102)));     // Catch: Exception -> L15
        return;
    L17:
        if (StringUtils.isEmpty(r101) == true) goto L26;
        Intent r105 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(BaseConstants.MARKET_PREFIX + r101));
        r105.addFlags(268435456);
        r100.startActivity(r105);     // Catch: Exception -> L21
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
