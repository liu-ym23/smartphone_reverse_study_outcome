package mqc;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.volcengine.zeus.activity.IPluginActivity;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static int[] c(Activity r100) {
        Resources.Theme r101 = r100.getTheme();
        if (r101 != null) goto L51;
        return null;
    L51:
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L25
        boolean r103 = true;
        int r104 = 0;
        if (r102 <= 23) goto L9;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L28;
        Object r106 = FieldUtils.readField(r101, "mThemeImpl");     // Catch: Throwable -> L25
        if (r106 != null) goto L49;
        return null;
    L49:
        Object r107 = MethodUtils.invokeMethod(r106, "getKey", new Object[0]);     // Catch: Exception -> L48 Throwable -> L25
        if (r107 == null) goto L19;
        return (int[]) FieldUtils.readField(r107, "mResId");
    L19:
        Object r108 = aqc.a.b(r106.getClass(), new Class[0]).invoke(r106, new Object[0]);     // Catch: Throwable -> L25
        if (r108 != null) goto L23;
        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");     // Catch: Throwable -> L25
        return null;
    L23:
        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");     // Catch: Throwable -> L25
        return (int[]) aqc.a.a(r108.getClass(), "mResId").get(r108);
    L28:
        if (r102 > 22) goto L31;
        r103 = false;
    L31:
        if (r103 == false) goto L37;
        Object r109 = MethodUtils.invokeMethod(r101, "getKey", new Object[0]);     // Catch: Throwable -> L25
        if (r109 != null) goto L36;
        return null;
    L36:
        return (int[]) FieldUtils.readField(r109, "mResId");
    L37:
        String r110 = (String) MethodUtils.invokeMethod(r101, "getKey", new Object[0]);     // Catch: Throwable -> L25
        if (r110 != null) goto L40;
        return null;
    L40:
        String[] r111 = r110.trim().replace("!", "").split(" ");     // Catch: Throwable -> L25
        int[] r112 = new int[r111.length];     // Catch: Throwable -> L25
    L42:
        if (r104 >= r111.length) goto L45;
        r112[r104] = CastIntegerProtector.parseInt(r111[r104], 16);     // Catch: Throwable -> L25
        r104 = r104 + 1;
        goto L42
    L45:
        return r112;
    L9:
        r105 = false;
    L25:
        th = move-exception;
        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
        return null;
    }

    public static void a(com.volcengine.zeus.wrapper.a r100, Activity r101) {
        FieldUtils.writeField(r100, "mTheme", null);     // Catch: Exception -> L11
        int r102 = 0;
        FieldUtils.writeField(r100, "mThemeResource", 0);     // Catch: Exception -> L11
        int[] r103 = c(r101);     // Catch: Exception -> L11
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = r103.length;     // Catch: Exception -> L11
    L6:
        if (r102 >= r104) goto L19;
        int r105 = r103[r102];     // Catch: Exception -> L11
        if (r105 == 0) goto L10;
        r100.setWrapperActivityTheme(r105);     // Catch: Exception -> L11
    L10:
        r102 = r102 + 1;
        goto L6
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(IPluginActivity r100, Activity r101) {
        FieldUtils.writeField(r100, "mTheme", null);     // Catch: Exception -> L11
        int r102 = 0;
        FieldUtils.writeField(r100, "mThemeResource", 0);     // Catch: Exception -> L11
        int[] r103 = c(r101);     // Catch: Exception -> L11
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = r103.length;     // Catch: Exception -> L11
    L6:
        if (r102 >= r104) goto L19;
        int r105 = r103[r102];     // Catch: Exception -> L11
        if (r105 == 0) goto L10;
        r100.setProxyTheme2Plugin(r105);     // Catch: Exception -> L11
    L10:
        r102 = r102 + 1;
        goto L6
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
