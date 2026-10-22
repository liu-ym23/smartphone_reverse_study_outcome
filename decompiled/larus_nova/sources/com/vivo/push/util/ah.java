package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f462550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String[] f462551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String[] f462552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String[] f462553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f462554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, Bundle> f462555f;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f462550a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
        f462552c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
        f462553d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        f462554e = new String[0];
        f462555f = new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vivo_push_util_ah_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static long a(Context r100) {
        String r101 = aa.a(r100);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        t.a("Utility", "systemPushPkgName is null");
        return -1;
    L7:
        return a(r100, r101);
    }

    public static void b(Context r110) throws VivoPushException {
        t.d("Utility", "check PushService AndroidManifest declearation !");
        String r100 = aa.a(r110);
        boolean r101 = aa.d(r110, r110.getPackageName());
        boolean r102 = aa.c(r110, r110.getPackageName());
        if (r102 == true) goto L8;
        if (r101 == true) goto L8;
        throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
    L8:
        if (r102 == false) goto L10;
        f462552c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
    L11:
        int r103 = 0;
        f462553d = new String[0];
        f462550a = new String[0];
        if (r101 == false) goto L14;
        f462551b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
    L16:
        if (r101 == false) goto L30;
        long r104 = a(r110, r110.getPackageName());
        if (r110.getPackageName().equals(r100) == false) goto L20;
        long r105 = 1356;
    L22:
        if (r104 == (-1)) goto L29;
        if (r104 == r105) goto L30;
        throw new VivoPushException("AndroidManifest.xml中sdk_version配置项错误，请配置当前sdk_version版本为:".concat(String.valueOf(r105)));
    L29:
        throw new VivoPushException("AndroidManifest.xml中未配置sdk_version");
    L20:
        r105 = 356;
    L30:
        String[] r106 = f462551b;
        if (r106 != null) goto L33;
    L56:
        t.c("Utility", "checkPermissions sPermissions is empty");
    L143:
    L136:
        e = move-exception;
        throw new VivoPushException(e.getMessage());
    L58:
        if (r110.getPackageManager() == null) goto L135;
        ActivityInfo[] r107 = r110.getPackageManager().getPackageInfo(r110.getPackageName(), 2).receivers;     // Catch: Exception -> L136
        if (r107 == null) goto L133;
        String[] r108 = f462553d;     // Catch: Exception -> L136
        int r109 = r108.length;     // Catch: Exception -> L136
        int r111 = 0;
    L62:
        if (r111 >= r109) goto L144;
        a(r108[r111], r107, r100);     // Catch: Exception -> L136
        r111 = r111 + 1;
        goto L62
    L144:
    L129:
        e = move-exception;
        throw new VivoPushException("error " + e.getMessage());
    L66:
        if (r110.getPackageManager() == null) goto L128;
        ServiceInfo[] r112 = r110.getPackageManager().getPackageInfo(r110.getPackageName(), 4).services;     // Catch: Exception -> L129
        if (r112 == null) goto L126;
        String[] r113 = f462552c;     // Catch: Exception -> L129
        int r114 = r113.length;     // Catch: Exception -> L129
        int r115 = 0;
    L70:
        if (r115 >= r114) goto L74;
        a(r113[r115], r112, r100);     // Catch: Exception -> L129
        r115 = r115 + 1;
        goto L70
    L74:
        if (f462554e.length <= 0) goto L139;
    L86:
        e = move-exception;
        throw new VivoPushException("error " + e.getMessage());
    L76:
        if (r110.getPackageManager() == null) goto L85;
        ActivityInfo[] r116 = r110.getPackageManager().getPackageInfo(r110.getPackageName(), 1).activities;     // Catch: Exception -> L86
        if (r116 == null) goto L83;
        String[] r117 = f462554e;     // Catch: Exception -> L86
        int r118 = r117.length;     // Catch: Exception -> L86
    L80:
        if (r103 >= r118) goto L139;
        a(r117[r103], r116, r100);     // Catch: Exception -> L86
        r103 = r103 + 1;     // Catch: Exception -> L86
        goto L80
    L83:
        throw new VivoPushException("activityInfos is null");     // Catch: Exception -> L86
    L85:
        throw new VivoPushException("localPackageManager is null");     // Catch: Exception -> L86
    L139:
        if (a(r110, r110.getPackageName(), "local_iv") == null) goto L121;
        String r119 = r110.getPackageName();
        Object r120 = a(r110, r119, "com.vivo.push.api_key");
        String r121 = "";
        if (r120 == null) goto L95;
        String r122 = r120.toString();
    L100:
        if (TextUtils.isEmpty(r122) == true) goto L119;
        String r123 = r110.getPackageName();
        Object r124 = a(r110, r123, "com.vivo.push.app_id");
        if (r124 == null) goto L104;
        r121 = r124.toString();
    L108:
        if (TextUtils.isEmpty(r121) == true) goto L117;
        if (r101 == true) goto L111;
        return;
    L111:
        if (a(r110, r110.getPackageName()) == (-1)) goto L114;
        return;
    L114:
        throw new VivoPushException("sdkversion is null");
    L117:
        throw new VivoPushException("com.vivo.push.app_id is null");
    L104:
        Object r125 = a(r110, r123, "app_id");
        if (r125 == null) goto L108;
        r121 = r125.toString();
        goto L108
    L119:
        throw new VivoPushException("com.vivo.push.api_key is null");
    L95:
        Object r126 = a(r110, r119, "api_key");
        if (r126 == null) goto L98;
        r122 = r126.toString();
        goto L100
    L98:
        r122 = "";
        goto L100
    L121:
        throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
    L122:
        e = move-exception;
        throw new VivoPushException("getMetaValue error " + e.getMessage());
    L126:
        throw new VivoPushException("serviceInfos is null");     // Catch: Exception -> L129
    L128:
        throw new VivoPushException("localPackageManager is null");     // Catch: Exception -> L129
    L133:
        throw new VivoPushException("receivers is null");     // Catch: Exception -> L136
    L135:
        throw new VivoPushException("localPackageManager is null");     // Catch: Exception -> L136
    L33:
        if (r106.length <= 0) goto L56;
        PackageManager r127 = r110.getPackageManager();     // Catch: Exception -> L53
        if (r127 == null) goto L52;
        String[] r128 = r127.getPackageInfo(r110.getPackageName(), 4096).requestedPermissions;     // Catch: Exception -> L53
        if (r128 == null) goto L50;
        int r129 = r106.length;     // Catch: Exception -> L53
        int r130 = 0;
    L40:
        if (r130 >= r129) goto L143;
        String r131 = r106[r130];     // Catch: Exception -> L53
        int r132 = r128.length;     // Catch: Exception -> L53
        int r133 = 0;
    L42:
        if (r133 >= r132) goto L48;
        if (r131.equals(r128[r133]) == true) goto L46;
        r133 = r133 + 1;     // Catch: Exception -> L53
        goto L42
    L46:
        r130 = r130 + 1;     // Catch: Exception -> L53
        goto L40
    L48:
        throw new VivoPushException("permission : " + r131 + "  check fail : " + Arrays.toString(r128));     // Catch: Exception -> L53
    L50:
        throw new VivoPushException("Permissions is null!");     // Catch: Exception -> L53
    L52:
        throw new VivoPushException("localPackageManager is null");     // Catch: Exception -> L53
    L53:
        e = move-exception;
        throw new VivoPushException(e.getMessage());
    L14:
        f462551b = new String[]{"android.permission.INTERNET"};
        goto L16
    L10:
        f462552c = new String[]{"com.vivo.push.sdk.service.CommandService"};
        goto L11
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:16777398), block:B:58:0x00b6 */
    public static PublicKey c(Context r110) {
        Cursor r100 = null;
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L45 Exception -> L47
        if (r101 < 24) goto L15;
        ContentResolver r102 = r110.getContentResolver();     // Catch: Throwable -> L45 Exception -> L47
        Uri r103 = com.vivo.push.x.f462613a;     // Catch: Throwable -> L45 Exception -> L47
        ContentProviderClient r104 = com_vivo_push_util_ah_android_content_ContentResolver_acquireUnstableContentProviderClient(r102, r103);     // Catch: Throwable -> L45 Exception -> L47
        if (r104 != null) goto L81;
        Cursor r105 = null;
    L16:
        if (r105 == null) goto L79;
    L21:
        if (r105 != null) goto L29;
        if (r105 != null) goto L77;
    L24:
        if (r104 == null) goto L27;
        if (r101 < 24) goto L27;
        r104.close();     // Catch: Exception -> L66
    L27:
        return null;
    L77:
        r105.close();     // Catch: Exception -> L66
    L29:
        if (r105.moveToNext() == false) goto L39;
        if ("pushkey".equals(r105.getString(r105.getColumnIndex("name"))) == false) goto L29;
        String r111 = r105.getString(r105.getColumnIndex("value"));     // Catch: Exception -> L19 Throwable -> L57
        t.d("Utility", "result key : ".concat(String.valueOf(r111)));     // Catch: Exception -> L19 Throwable -> L57
        PublicKey r112 = ab.a(r111);     // Catch: Exception -> L19 Throwable -> L57
        r105.close();     // Catch: Exception -> L67
        if (r104 == null) goto L38;
        if (Build.VERSION.SDK_INT < 24) goto L38;
        r104.close();     // Catch: Exception -> L67
    L38:
        return r112;
    L19:
        e = e;
    L49:
        e.printStackTrace();     // Catch: Throwable -> L57
        if (r105 == null) goto L52;
        r105.close();     // Catch: Exception -> L68
    L52:
        if (r104 == null) goto L56;
        if (Build.VERSION.SDK_INT < 24) goto L56;
    L43:
        r104.close();     // Catch: Exception -> L68
        goto L56
    L39:
        r105.close();     // Catch: Exception -> L68
        if (r104 == null) goto L56;
        if (Build.VERSION.SDK_INT < 24) goto L56;
    L79:
        r105 = com_vivo_push_util_ah_android_content_ContentResolver_query(r110.getContentResolver(), com.vivo.push.x.f462613a, null, null, null, null);     // Catch: Exception -> L19 Throwable -> L57
        goto L21
    L81:
        t.a("Utility", "client is null");     // Catch: Throwable -> L10 Exception -> L12
        r105 = r104.query(r103, null, null, null, null);     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = e;
        r105 = null;
    L10:
        th = th;
    L59:
        if (r100 != null) goto L71;
    L61:
        if (r104 != null) goto L63;
    L65:
        throw th;
    L63:
        if (Build.VERSION.SDK_INT < 24) goto L65;
        r104.close();     // Catch: Exception -> L69
        goto L65
    L71:
        r100.close();     // Catch: Exception -> L69
        goto L61
    L15:
        r104 = null;
        r105 = null;
    L57:
        th = th;
        r100 = r5;
    L47:
        e = e;
        r104 = null;
        r105 = null;
    L45:
        th = th;
        r104 = null;
    L56:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static boolean d(Context r110) {
        ?? r100 = 0;
        r100 = 0;
        if (r110 != null) goto L6;
        t.a("Utility", "context is null");     // Catch: Throwable -> L47 Exception -> L49
        return false;
    L6:
        String r101 = r110.getPackageName();     // Catch: Throwable -> L47 Exception -> L49
        int r102 = r110.getPackageManager().getPackageInfo(r101, 0).versionCode;     // Catch: Throwable -> L47 Exception -> L49
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L47 Exception -> L49
        if (r103 < 24) goto L12;
        ContentResolver r111 = r110.getContentResolver();     // Catch: Throwable -> L47 Exception -> L49
        Uri r112 = com.vivo.push.x.f462614b;     // Catch: Throwable -> L47 Exception -> L49
        ContentProviderClient r113 = com_vivo_push_util_ah_android_content_ContentResolver_acquireUnstableContentProviderClient(r111, r112);     // Catch: Throwable -> L47 Exception -> L49
        if (r113 != null) goto L81;
    L13:
        if (r100 != 0) goto L17;
        r100 = com_vivo_push_util_ah_android_content_ContentResolver_query(r110.getContentResolver(), com.vivo.push.x.f462614b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"356", r101, String.valueOf(r102)}, null);     // Catch: Exception -> L15 Throwable -> L63
    L17:
        if (r100 != 0) goto L30;
        t.a("Utility", "cursor is null");     // Catch: Exception -> L15 Throwable -> L63
        if (r100 != 0) goto L82;
    L23:
        if (r113 == null) goto L28;
        if (r103 < 24) goto L28;
        r113.close();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        t.a("Utility", "close", e);
    L28:
        return false;
    L82:
        r100.close();     // Catch: Exception -> L21
        goto L23
    L30:
        if (r100.moveToFirst() == true) goto L33;
    L42:
        r100.close();     // Catch: Exception -> L54
        if (r113 == null) goto L62;
        if (r103 < 24) goto L62;
        r113.close();     // Catch: Exception -> L54
    L62:
        return false;
    L33:
        if ((r100.getInt(r100.getColumnIndex("permission")) & 1) == 0) goto L42;
        r100.close();     // Catch: Exception -> L39
        if (r113 == null) goto L41;
        if (r103 < 24) goto L41;
        r113.close();     // Catch: Exception -> L39
    L41:
        return true;
    L39:
        e = move-exception;
        t.a("Utility", "close", e);
        goto L41
    L81:
        t.a("Utility", "client is null");     // Catch: Exception -> L15 Throwable -> L63
        r100 = r113.query(r112, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"356", r101, String.valueOf(r102)}, null);     // Catch: Exception -> L15 Throwable -> L63
    L15:
        e = e;
    L51:
        t.a("Utility", "isSupport", e);     // Catch: Throwable -> L63
        if (0 == 0) goto L56;
        r100.close();     // Catch: Exception -> L54
    L56:
        if (r113 == null) goto L62;
        if (Build.VERSION.SDK_INT < 24) goto L62;
        r113.close();     // Catch: Exception -> L54
        goto L62
    L12:
        r113 = null;
    L54:
        e = move-exception;
        t.a("Utility", "close", e);
    L63:
        th = move-exception;
        Throwable r104 = th;
    L65:
        if (0 != 0) goto L79;
    L69:
        if (0 != 0) goto L71;
        throw r104;
    L71:
        if (Build.VERSION.SDK_INT < 24) goto L85;
        r100.close();     // Catch: Exception -> L67
        throw r104;
    L67:
        e = move-exception;
        t.a("Utility", "close", e);
        throw r104;
    L85:
        throw r104;
    L79:
        r100.close();     // Catch: Exception -> L67
    L49:
        e = e;
        r113 = null;
    L47:
        th = move-exception;
        r104 = th;
        goto L65
    }

    public static boolean a(Collection<?> r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    private static void a(ComponentInfo r100, String r101) throws VivoPushException {
        if (r100.applicationInfo.packageName.equals(r101) == false) goto L5;
        return;
    L5:
        String[] r102 = f462550a;
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L15;
        if (r102[r104].equals(r100.name) == false) goto L14;
        if (r100.processName.contains(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX) == true) goto L14;
        throw new VivoPushException("module : " + r100.name + " process :" + r100.processName + "  check process fail");
    L14:
        r104 = r104 + 1;
        goto L6
    }

    public static String b(String r100, String r101) {
        String r102 = (String) INVOKESTATIC_com_vivo_push_util_ah_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L4
    L6:
        if (r102 != null) goto L8;
        return r101;
    L8:
        if (r102.length() != 0) goto L11;
        return r101;
    L11:
        return r102;
    L4:
        e = move-exception;
        e.printStackTrace();
        r102 = r101;
        goto L6
    }

    public static int c(Context r100, String r101) {
        if (r100 != null) goto L4;
    L10:
        t.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L10;
        int r102 = (int) a(r100, r101);
        if (r102 <= 0) goto L9;
        return r102;
    L9:
        return d(r100, r101);
    }

    private static ContentProviderClient com_vivo_push_util_ah_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static int d(Context r100, String r101) {
        if (r100 != null) goto L5;
    L23:
        t.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
        return 0;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        Object r102 = a(r100, r101, "sdk_version_vivo");
        if ((r102 instanceof String) == false) goto L12;
        String r103 = (String) r102;
    L10:
        String r104 = r103;
        int r105 = 0;
    L16:
        if (r105 <= 0) goto L25;
        return r105;
    L25:
        return CastIntegerProtector.parseInt(r104);
    L20:
        e = move-exception;
        t.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e)));
        return 0;
    L12:
        if ((r102 instanceof Integer) == false) goto L14;
        r105 = ((Integer) r102).intValue();
        r104 = "";
        goto L16
    L14:
        if (r102 == null) goto L27;
        r103 = r102.toString();
        goto L10
    L27:
        return 0;
    }

    public static long a(Context r100, String r101) {
        Object r102 = a(r100, r101, "com.vivo.push.sdk_version");
        if (r102 != null) goto L6;
        r102 = a(r100, r101, "sdk_version");
    L6:
        if (r102 != null) goto L14;
        t.a("Utility", "getSdkVersionCode sdk version is null");
        return -1;
    L14:
        return CastLongProtector.parseLong(r102.toString());
    L9:
        e = move-exception;
        e.printStackTrace();
        t.a("Utility", "getSdkVersionCode error ", e);
        return -1;
    }

    public static String b(Context r100, String r101) {
        Object r102 = a(r100, r101, "verification_status");
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.toString();
    }

    public static Object a(String r100, String r101) throws Exception {
        Class r102 = INVOKESTATIC_com_vivo_push_util_ah_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
        return r102.getField(r101).get(r102);
    }

    public static boolean a(Context r100, String r101, boolean r102) {
        Cursor r103 = null;
        Uri r104 = com.vivo.push.x.f462617e;     // Catch: Throwable -> L26 Exception -> L28
        String[] r105 = new String[2];     // Catch: Throwable -> L26 Exception -> L28
        r105[0] = r101;     // Catch: Throwable -> L26 Exception -> L28
        if (r102 == false) goto L6;
        String r106 = "1";
    L7:
        r105[1] = r106;     // Catch: Throwable -> L26 Exception -> L28
        Cursor r107 = a(r104, "appPkgName = ? and agreePrivacyStatement = ? ", r105, r100);     // Catch: Throwable -> L26 Exception -> L28
        if (r107 != null) goto L17;
        t.a("Utility", "cursor is null");     // Catch: Throwable -> L26 Exception -> L28
        if (r107 != null) goto L46;
    L15:
        return false;
    L46:
        r107.close();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        t.a("Utility", "close", e);
        goto L15
    L17:
        if (r107.moveToFirst() == false) goto L24;
        boolean r108 = Boolean.parseBoolean(r107.getString(r107.getColumnIndex("agreePrivacyStatement")));     // Catch: Throwable -> L26 Exception -> L28
        r107.close();     // Catch: Exception -> L21
    L23:
        return r108;
    L21:
        e = move-exception;
        t.a("Utility", "close", e);
        goto L23
    L24:
        r107.close();     // Catch: Exception -> L33
    L43:
    L35:
        return false;
    L6:
        r106 = "0";
    L26:
        th = move-exception;
        if (0 != 0) goto L48;
    L41:
        throw th;
    L48:
        r103.close();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        t.a("Utility", "close", e);
    L28:
        e = move-exception;
        t.a("Utility", "syncAgreePrivacyStatement", e);     // Catch: Throwable -> L26
        if (0 == 0) goto L35;
        r103.close();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        t.a("Utility", "close", e);
        goto L35
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static Object a(Context r100, String r101, String r102) {
        Object r103 = null;
        Bundle r104 = null;
        if (r100 == null) goto L37;
        if (r102 == null) goto L37;
        if (TextUtils.isEmpty(r101) == true) goto L37;
        Map<String, Bundle> r105 = f462555f;     // Catch: Exception -> L34
        if (r105 != null) goto L11;
    L16:
        Object r106 = null;
    L17:
        if (r106 == null) goto L42;
        return r106;
    L42:
        ApplicationInfo r107 = r100.getPackageManager().getApplicationInfo(r101, 128);     // Catch: Exception -> L32
        if (r107 == null) goto L22;
        r104 = r107.metaData;     // Catch: Exception -> L32
    L22:
        if (r104 == null) goto L25;
        Object r108 = r104.get(r102);     // Catch: Exception -> L32
    L38:
    L30:
        e = move-exception;
        r103 = r108;
        e = e;
    L35:
        t.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
        return r103;
    L27:
        if (f462555f.size() > 300) goto L44;
        f462555f.put(r101, r104);     // Catch: Exception -> L30
        return r108;
    L44:
        return r108;
    L25:
        r108 = r106;
    L32:
        e = e;
        r103 = r106;
        goto L35
    L11:
        if (r105.size() <= 0) goto L16;
        Bundle r109 = f462555f.get(r101);     // Catch: Exception -> L34
        if (r109 == null) goto L16;
        r106 = r109.get(r102);     // Catch: Exception -> L34
    L34:
        e = e;
    L37:
        return null;
    }

    private static void a(String r100, ComponentInfo[] r101, String r102) throws VivoPushException {
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        ComponentInfo r105 = r101[r104];
        if (r100.equals(r105.name) == true) goto L7;
        r104 = r104 + 1;
        goto L3
    L7:
        if (r105.enabled == false) goto L11;
        a(r105, r102);
        return;
    L11:
        throw new VivoPushException(r105.name + " module Push-SDK need is illegitmacy !");
    L14:
        throw new VivoPushException(r100 + " module Push-SDK need is not exist");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static boolean a(Context r110, String r111, String r112, long r113) {
        Cursor r100 = 0;
        r100 = 0;
        if (r110 != null) goto L6;
        t.a("Utility", "context is null");     // Catch: Throwable -> L44 Exception -> L46
        return false;
    L6:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L44 Exception -> L46
        if (r101 < 24) goto L11;
        ContentResolver r102 = r110.getContentResolver();     // Catch: Throwable -> L44 Exception -> L46
        Uri r114 = com.vivo.push.x.f462615c;     // Catch: Throwable -> L44 Exception -> L46
        ContentProviderClient r103 = com_vivo_push_util_ah_android_content_ContentResolver_acquireUnstableContentProviderClient(r102, r114);     // Catch: Throwable -> L44 Exception -> L46
        if (r103 != null) goto L73;
    L12:
        if (r100 != 0) goto L16;
        r100 = com_vivo_push_util_ah_android_content_ContentResolver_query(r110.getContentResolver(), com.vivo.push.x.f462615c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{r111, r112, String.valueOf(r113)}, null);     // Catch: Exception -> L14 Throwable -> L60
    L16:
        if (r100 != 0) goto L29;
        t.a("Utility", "cursor is null");     // Catch: Exception -> L14 Throwable -> L60
        if (r100 != 0) goto L74;
    L22:
        if (r103 == null) goto L27;
        if (r101 < 24) goto L27;
        r103.close();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        t.a("Utility", "close", e);
    L27:
        return false;
    L74:
        r100.close();     // Catch: Exception -> L20
        goto L22
    L29:
        if (r100.moveToFirst() == false) goto L39;
        boolean r104 = Boolean.parseBoolean(r100.getString(r100.getColumnIndex("clientState")));     // Catch: Exception -> L14 Throwable -> L60
        r100.close();     // Catch: Exception -> L36
        if (r103 == null) goto L38;
        if (r101 < 24) goto L38;
        r103.close();     // Catch: Exception -> L36
    L38:
        return r104;
    L36:
        e = move-exception;
        t.a("Utility", "close", e);
        goto L38
    L39:
        r100.close();     // Catch: Exception -> L51
        if (r103 == null) goto L59;
        if (r101 < 24) goto L59;
        r103.close();     // Catch: Exception -> L51
    L59:
        return false;
    L73:
        t.a("Utility", "client is null");     // Catch: Exception -> L14 Throwable -> L60
        r100 = r103.query(r114, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{r111, r112, String.valueOf(r113)}, null);     // Catch: Exception -> L14 Throwable -> L60
    L14:
        e = e;
    L48:
        t.a("Utility", "isOverdue", e);     // Catch: Throwable -> L60
        if (0 == 0) goto L53;
        r100.close();     // Catch: Exception -> L51
    L53:
        if (r103 == null) goto L59;
        if (Build.VERSION.SDK_INT < 24) goto L59;
        r103.close();     // Catch: Exception -> L51
        goto L59
    L11:
        r103 = null;
    L51:
        e = move-exception;
        t.a("Utility", "close", e);
    L60:
        th = move-exception;
        Throwable r105 = th;
    L62:
        if (0 != 0) goto L79;
    L66:
        if (0 != 0) goto L68;
        throw r105;
    L68:
        if (Build.VERSION.SDK_INT < 24) goto L82;
        r100.close();     // Catch: Exception -> L64
        throw r105;
    L64:
        e = move-exception;
        t.a("Utility", "close", e);
        throw r105;
    L82:
        throw r105;
    L79:
        r100.close();     // Catch: Exception -> L64
    L46:
        e = e;
        r103 = null;
    L44:
        th = move-exception;
        r105 = th;
        goto L62
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0082: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:67174530), block:B:47:0x0082 */
    private static Cursor a(Uri r110, String r111, String[] r112, Context r113) {
        ContentProviderClient r100 = null;
        if (r113 != null) goto L6;
        t.a("Utility", "context is null");     // Catch: Throwable -> L33 Exception -> L35
        return null;
    L6:
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L33 Exception -> L35
        if (r101 < 24) goto L12;
        ContentProviderClient r102 = com_vivo_push_util_ah_android_content_ContentResolver_acquireUnstableContentProviderClient(r113.getContentResolver(), r110);     // Catch: Throwable -> L33 Exception -> L35
        if (r102 != null) goto L63;
        Cursor r103 = null;
    L13:
        if (r103 != null) goto L17;
        r103 = com_vivo_push_util_ah_android_content_ContentResolver_query(r113.getContentResolver(), r110, null, r111, r112, null);     // Catch: Exception -> L15 Throwable -> L46
    L17:
        if (r103 != null) goto L26;
        t.a("Utility", "cursor is null");     // Catch: Exception -> L15 Throwable -> L46
        if (r102 == null) goto L25;
        if (r101 < 24) goto L25;
        r102.close();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        t.a("Utility", "close", e);
    L25:
        return null;
    L15:
        e = e;
    L37:
        t.a("Utility", "queryContentResolver", e);     // Catch: Throwable -> L46
        if (r102 != null) goto L59;
    L45:
        return null;
    L59:
    L43:
        e = move-exception;
        t.a("Utility", "close", e);
        goto L45
    L40:
        if (Build.VERSION.SDK_INT < 24) goto L45;
        r102.close();     // Catch: Exception -> L43
        goto L45
    L26:
        if (r102 == null) goto L32;
        if (r101 < 24) goto L32;
        r102.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        t.a("Utility", "close", e);
    L32:
        return r103;
    L63:
        t.a("Utility", "client is null");     // Catch: Exception -> L15 Throwable -> L46
        r103 = r102.query(r110, null, r111, r112, null);     // Catch: Exception -> L15 Throwable -> L46
        goto L13
    L12:
        r102 = null;
        r103 = null;
    L46:
        th = th;
        r100 = r5;
    L34:
        Throwable r104 = th;
        if (r100 == null) goto L67;
    L53:
        e = move-exception;
        t.a("Utility", "close", e);
        throw r104;
    L50:
        if (Build.VERSION.SDK_INT < 24) goto L68;
        r100.close();     // Catch: Exception -> L53
        throw r104;
    L68:
        throw r104;
    L67:
        throw r104;
    L35:
        e = e;
        r102 = null;
    L33:
        th = th;
        goto L34
    }

    private static Cursor com_vivo_push_util_ah_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
