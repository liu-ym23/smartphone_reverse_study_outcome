package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.VideoEventLoggerV2;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public class TTVideoEngineUtils {
    public static final int SENSITIVE_SCENE_GUEST_MODE = 3;
    public static final int SENSITIVE_SCENE_NONE = 0;
    public static final int SENSITIVE_SCENE_TEEN_MODE = 2;
    public static final int SENSITIVE_SCENE_USER_DISAGREE = 1;
    private static final String TAG = "TTVideoEngineUtils";
    public static int sEnableHTTPSForFetch = 1;
    public static int sSensitiveScene;

    public TTVideoEngineUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isFlagOn(long r100, long r101) {
        if ((r100 & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getSensitiveScene() {
        if (VideoEventLoggerV2.sIsColdStart != 1) goto L33;
        int r100 = sSensitiveScene;
        if (r100 <= 0) goto L33;
        return r100;
    L33:
        boolean r101 = ((Boolean) INVOKESTATIC_com_ss_ttvideoengine_utils_TTVideoEngineUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.utils.PrivacyPolicyAgreementUtils").getMethod("isUserAgreePrivacyPolicy", new Class[0]).invoke(null, new Object[0])).booleanValue();     // Catch: Throwable -> L11
        TTVideoEngineLog.d(TAG, "isUserAgreePrivacyPolicy:" + r101);     // Catch: Throwable -> L11
        if (r101 == true) goto L35;
        return 1;
    L35:
        Class r102 = INVOKESTATIC_com_ss_ttvideoengine_utils_TTVideoEngineUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.compliance.api.ComplianceServiceProvider");     // Catch: Throwable -> L30
        if (r102 != null) goto L37;
        return -1;
    L37:
        Class r103 = INVOKESTATIC_com_ss_ttvideoengine_utils_TTVideoEngineUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.compliance.api.services.teenmode.ITeenModeService");     // Catch: Throwable -> L21
        boolean r104 = ((Boolean) r103.getMethod("isTeenModeON", new Class[0]).invoke(r102.getMethod("teenModeService", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();     // Catch: Throwable -> L21
        TTVideoEngineLog.d(TAG, "isTeenModeOn:" + r104);     // Catch: Throwable -> L21
        if (r104 == false) goto L39;
        return 2;
    L39:
        Class r105 = INVOKESTATIC_com_ss_ttvideoengine_utils_TTVideoEngineUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.compliance.api.services.businesses.IComplianceBusinessService");     // Catch: Throwable -> L27
        boolean r106 = ((Boolean) r105.getMethod("isGuestMode", new Class[0]).invoke(r102.getMethod("businessService", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();     // Catch: Throwable -> L27
        TTVideoEngineLog.d(TAG, "isGuestMode:" + r106);     // Catch: Throwable -> L27
        if (r106 == false) goto L29;
        return 3;
    L29:
        return -1;
    L27:
        th = move-exception;
        TTVideoEngineLog.e(TAG, "get businessService failed:" + th.toString());
    L21:
        th = move-exception;
        TTVideoEngineLog.e(TAG, "get teenModeService failed:" + th.toString());
    L30:
        th = move-exception;
        TTVideoEngineLog.e(TAG, "get ComplianceServiceProvider failed:" + th.toString());
        return -1;
    L11:
        th = move-exception;
        TTVideoEngineLog.e(TAG, "get PrivacyPolicy failed:" + th.toString());
        goto L35
    }

    public static String BuildHttpsApi(String r100) {
        if (sEnableHTTPSForFetch == 1) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return r100;
    L7:
        if (r100.startsWith("http://") == false) goto L12;
        TTVideoEngineLog.i(TAG, "fetch api need replace https");
        return r100.replaceFirst("http://", "https://");
    L12:
        return r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_utils_TTVideoEngineUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void setSensitiveScene(int r100) {
        if (r100 != 0) goto L4;
    L10:
        sSensitiveScene = r100;
        return;
    L4:
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        if (r100 == 3) goto L10;
    }

    public static <T> void addToList(ArrayList<T> r100, T r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TTVideoEngine.sBuryDataOptimize == true) goto L7;
    L9:
        r100.add(r101);
        return;
    L7:
        if (r100.size() >= 100) goto L9;
        r100.add(r101);
    }

    public static <T> void addToList(ArrayList<T> r100, T r101, int r102) {
        if (r100 == null) goto L12;
        if (r102 >= 0) goto L6;
        return;
    L6:
        if (TTVideoEngine.sBuryDataOptimize == true) goto L8;
    L10:
        r100.add(r101);
        return;
    L8:
        if (r100.size() >= r102) goto L10;
        r100.add(r101);
        return;
    }
}
