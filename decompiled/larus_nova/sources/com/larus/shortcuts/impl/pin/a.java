package com.larus.shortcuts.impl.pin;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f369249a = null;

    static {
        f369249a = Build.MANUFACTURER.toLowerCase(Locale.US);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.huawei.hsm.permission.PermissionManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.huawei.hsm.permission.PermissionManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.huawei.hsm.permission.PermissionManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.huawei.hsm.permission.PermissionManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v1 */
    public static int d(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String[] r100 = f.f369252a;
        ?? r101 = 0;
        r101 = 0;
        r101 = 0;
        r101 = 0;
        boolean r102 = !TextUtils.isEmpty(DeviceUtils.getSystemProperty("ro.miui.ui.version.name"));
    L6:
        if (r102 == false) goto L194;
    L9:
        Cursor r103 = null;
        String r111 = "";
        if (r102 == true) goto L198;
        String r104 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r104) == true) goto L30;
        Intrinsics.checkNotNull(r104);
        if (StringsKt.contains$default(r104, SystemUtils.PRODUCT_HUAWEI, false, 2, null) == false) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == false) goto L46;
        if (TextUtils.isEmpty(r104) == true) goto L37;
        Intrinsics.checkNotNull(r104);
        if (StringsKt.contains$default(r104, SystemUtils.PRODUCT_HUAWEI, false, 2, null) == false) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == false) goto L44;
        String r107 = DeviceUtils.getSystemProperty(com.alipay.sdk.m.c.a.f25238a);
        if (TextUtils.isEmpty(r107) == true) goto L44;
        r111 = r107 + "__" + Build.DISPLAY;
    L44:
        f.a r108 = new f.a("emui", r111);
    L81:
        String r109 = r108.f369253a;
        switch(r109.hashCode()) {
            case -314765822: goto L183;
            case 3117372: goto L167;
            case 3351856: goto L149;
            case 97536331: goto L143;
            case 949547143: goto L117;
            case 1396500768: goto L85;
            default: goto L184;
        };
    L184:
        return 2;
    L85:
        if (r109.equals("funtouch") == false) goto L184;
        Cursor r112 = b(r110.getContentResolver(), Uri.parse("content://com.bbk.launcher2.settings/favorites"), null, null);     // Catch: Throwable -> L109 Exception -> L113
        if (r112 == null) goto L184;
    L200:
    L108:
        r103 = r112;
    L106:
        th = th;
        r103 = r112;
    L110:
        if (r103 == null) goto L112;
        r103.close();
    L112:
        throw th;
    L92:
        if (r112.moveToNext() == false) goto L105;
        String r113 = r112.getString(r112.getColumnIndex("intent"));     // Catch: Throwable -> L106 Exception -> L108
        if (TextUtils.isEmpty(r113) == true) goto L200;
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L106 Exception -> L108
        if (StringsKt.contains$default(r113, r110.getApplicationContext().getPackageName(), false, 2, null) == false) goto L200;
        int r114 = r112.getInt(r112.getColumnIndex("shortcutPermission"));     // Catch: Throwable -> L106 Exception -> L108
    L99:
        if (r114 != 16) goto L101;
    L103:
        r101 = 1;
    L104:
        r112.close();
    L221:
        return r101 == true ? 1 : 0;
    L101:
        if (r114 == 18) goto L103;
    L105:
        r112.close();
        goto L184
    L109:
        th = th;
    L114:
        if (r103 == null) goto L184;
        r103.close();
        goto L184
    L117:
        if (r109.equals("coloros") == false) goto L184;
        Cursor r115 = b(r110.getContentResolver(), Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), null, null);     // Catch: Throwable -> L135 Exception -> L139
        if (r115 == null) goto L184;
    L202:
    L134:
        r103 = r115;
    L132:
        th = th;
        r103 = r115;
    L136:
        if (r103 == null) goto L138;
        r103.close();
    L138:
        throw th;
    L124:
        if (r115.moveToNext() == false) goto L131;
        String r116 = r115.getString(r115.getColumnIndex("value"));     // Catch: Throwable -> L132 Exception -> L134
        if (TextUtils.isEmpty(r116) == true) goto L202;
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L132 Exception -> L134
        if (StringsKt.contains$default(r116, r110.getApplicationContext().getPackageName(), false, 2, null) == false) goto L202;
        boolean r117 = StringsKt.contains$default(r116, r110.getApplicationContext().getPackageName() + ", 1", false, 2, null);     // Catch: Throwable -> L132 Exception -> L134
        r115.close();
        return r117 ? 1 : 0;
    L131:
        r115.close();
        goto L184
    L135:
        th = th;
    L140:
        if (r103 == null) goto L184;
        r103.close();
        goto L184
    L143:
        if (r109.equals("flyme") == false) goto L184;
        if (Build.VERSION.SDK_INT < 26) goto L184;
        return 1;
    L149:
        if (r109.equals("miui") == false) goto L184;
        String r118 = r108.a();
        if (TextUtils.isEmpty(r118) == true) goto L221;
        if (c("11.0.6", r118) < 0) goto L180;
        Object r119 = r110.getSystemService("appops");     // Catch: Exception -> L188
        if ((r119 instanceof AppOpsManager) == false) goto L180;
        AppOpsManager r120 = (AppOpsManager) r119;     // Catch: Exception -> L188
        Class<?> r121 = r120.getClass();     // Catch: Exception -> L188
        Class<?> r122 = Integer.TYPE;     // Catch: Exception -> L188
        Object r123 = r121.getMethod("checkOpNoThrow", new Class[]{r122, r122, String.class}).invoke(r120, new Object[]{10017, Integer.valueOf(r110.getApplicationInfo().uid), r110.getApplicationContext().getPackageName()});     // Catch: Exception -> L188
        if ((r123 instanceof Integer) == false) goto L180;
        int r124 = ((Number) r123).intValue();     // Catch: Exception -> L188
        if (r124 == 0) goto L165;
        if (r124 != 1) goto L180;
    L189:
    L165:
        r101 = 1;
        goto L189
    L167:
        if (r109.equals("emui") == false) goto L184;
        String r125 = r108.a();
        if (TextUtils.isEmpty(r125) == true) goto L221;
        if (c("10.1.0", r125) <= 0) goto L180;
        Object r126 = a().getMethod("canSendBroadcast", new Class[]{Context.class, Intent.class}).invoke(null, new Object[]{r110, new Intent("com.android.launcher.action.INSTALL_SHORTCUT")});     // Catch: Exception -> L188
        if ((r126 instanceof Boolean) == false) goto L180;
        r101 = ((Boolean) r126).booleanValue();     // Catch: Exception -> L188
        goto L189
    L183:
        if (r109.equals("primary") == false) goto L184;
        return 1;
    L180:
        r101 = 2;
    L37:
        r106 = false;
        goto L38
    L46:
        if (f.b() == false) goto L56;
        if (f.b() == false) goto L54;
        String r127 = DeviceUtils.getSystemProperty("ro.build.version.opporom");
        if (TextUtils.isEmpty(r127) == true) goto L54;
        r111 = "coloros__" + r127 + "__" + Build.DISPLAY;
    L54:
        r108 = new f.a("coloros", r111);
        goto L81
    L56:
        if (f.d() == false) goto L66;
        if (f.d() == false) goto L64;
        String r128 = DeviceUtils.getSystemProperty("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r128) == true) goto L64;
        r111 = "funtouch__" + r128 + "__" + DeviceUtils.getSystemProperty("ro.vivo.product.version");
    L64:
        r108 = new f.a("funtouch", r111);
        goto L81
    L66:
        if (f.c() == false) goto L77;
        if (f.c() == false) goto L75;
        String r129 = Build.DISPLAY;
        if (TextUtils.isEmpty(r129) == true) goto L75;
        Intrinsics.checkNotNull(r129);
        if (StringsKt.contains$default(r129.toLowerCase(Locale.US), "flyme", false, 2, null) == false) goto L75;
        r111 = r129;
    L75:
        r108 = new f.a("flyme", r111);
        goto L81
    L77:
        if (ArraysKt.contains(f.f369252a, Build.BRAND.toLowerCase(Locale.US)) == false) goto L79;
        f.a r130 = new f.a("primary", Build.VERSION.RELEASE);
    L80:
        r108 = r130;
        goto L81
    L79:
        r130 = new f.a("other", Build.DISPLAY);
    L30:
        r105 = false;
        goto L31
    L198:
        boolean r131 = !TextUtils.isEmpty(DeviceUtils.getSystemProperty("ro.miui.ui.version.name"));
    L15:
        if (r131 == false) goto L192;
    L18:
        if (r131 == false) goto L24;
        String r132 = DeviceUtils.getSystemProperty("ro.miui.ui.version.name");
        if (TextUtils.isEmpty(r132) == true) goto L24;
        r111 = "miui" + r132 + "__" + Build.VERSION.INCREMENTAL;
    L24:
        r108 = new f.a("miui", r111);
        goto L81
    L192:
        f.a();     // Catch: ClassNotFoundException -> L187
        r131 = true;
    L14:
        r131 = false;
        goto L15
    L194:
        f.a();     // Catch: ClassNotFoundException -> L186
        r102 = true;
    L5:
        r102 = false;
        goto L6
    }

    public static Intent e(FragmentActivity r100) {
        Intent r101 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r101.setData(Uri.fromParts("package", r100.getPackageName(), null));
        return r101;
    }

    public static int c(String r100, String r101) {
        if (r101 == null) goto L14;
        int r102 = 0;
        String[] r103 = (String[]) new Regex(EasyGoConstant.VERSION_SEPARATIVE_SIGN).split(r100, 0).toArray(new String[0]);
        String[] r104 = (String[]) new Regex(EasyGoConstant.VERSION_SEPARATIVE_SIGN).split(r101, 0).toArray(new String[0]);
        int r105 = Math.min(r103.length, r104.length);
        int r106 = 0;
    L4:
        if (r102 >= r105) goto L9;
        int r107 = CastIntegerProtector.parseInt(r103[r102]);
        int r108 = CastIntegerProtector.parseInt(r104[r102]);
        Unit r109 = Unit.INSTANCE;
        if ((r107 - r108) != 0) goto L8;
        r102 = r102 + 1;
        r106 = r108;
        goto L4
    L8:
        r106 = r108;
    L9:
        if (r106 == 0) goto L12;
        return r106;
    L12:
        return r103.length - r104.length;
    L14:
        throw new RuntimeException("version name can not be null");
    }

    public static boolean f(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intent r102 = new Intent("android.intent.action.MAIN");
        r102.addCategory("android.intent.category.HOME");
        PackageManager r103 = r100.getPackageManager();
        ResolveInfo r104 = r103.resolveActivity(r102, 0);
        if (r104 == null) goto L17;
        ActivityInfo r105 = r104.activityInfo;
        List<ProviderInfo> r106 = r103.queryContentProviders(r105.packageName, r105.applicationInfo.uid, 8);
        if (r106 == null) goto L17;
        Iterator<ProviderInfo> r107 = r106.iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        ProviderInfo r108 = r107.next();
        if (TextUtils.isEmpty(r108.readPermission) == true) goto L10;
        if (Pattern.matches(".*launcher.*READ_SETTINGS", r108.readPermission) == false) goto L10;
        String r109 = r108.authority;
    L19:
        if (r109 != null) goto L21;
    L28:
        r109 = "com.android.launcher3.settings";
    L29:
        StringBuffer r110 = new StringBuffer("content://");
        r110.append(r109);
        r110.append("/favorites?notify=true");
        Cursor r111 = b(r100.getContentResolver(), UriProtector.parse(r110.toString()), "id=? ", new String[]{r101});     // Catch: Exception -> L46
        if (r111 == null) goto L45;
        Cursor r112 = r111;     // Catch: Exception -> L46
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r112, th);     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L34:
        if (r112.moveToNext() == false) goto L37;
        CloseableKt.closeFinally(r112, null);     // Catch: Exception -> L46
        return true;
    L37:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r112, null);     // Catch: Exception -> L46
        goto L45
    L45:
        return false;
    L21:
        if (r109.length() <= 0) goto L23;
        boolean r114 = true;
    L24:
        if (r114 == true) goto L27;
        r109 = null;
    L27:
        if (r109 != null) goto L29;
    L23:
        r114 = false;
    L17:
        r109 = "";
        goto L19
    }

    public static Cursor b(ContentResolver r110, Uri r111, String r112, String[] r113) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, r112, r113, null};
        f06.b r114 = new f06.b();
        f06.d r115 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r114);
        if (r115.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r114, false);
        return (Cursor) r115.f474983b;
    L6:
        Cursor r116 = r110.query(r111, null, r112, r113, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r116, r114, true);
        return r116;
    }
}
