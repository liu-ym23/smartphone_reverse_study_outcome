package fa4;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476021a = 0;

    static {
    }

    public static boolean a(Context r100, String r110) {
        int r101 = b.f476022a;
        if (Intrinsics.areEqual("android.permission.ACCESS_COARSE_LOCATION", r110) == false) goto L7;
        String r111 = "COARSE_LOCATION";
    L10:
        Object r102 = r100.getSystemService("appops");     // Catch: Exception -> L22
        PackageInfo r103 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 1);     // Catch: Exception -> L22
        Field r112 = AppOpsManager.class.getField("OP_" + r111);     // Catch: Exception -> L22
        Class r104 = Integer.TYPE;     // Catch: Exception -> L22
        Method r105 = AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{r104, r104, String.class});     // Catch: Exception -> L22
        r105.setAccessible(true);     // Catch: Exception -> L22
        Object r106 = r105.invoke(r102, new Object[]{Integer.valueOf(r112.getInt(r102)), Integer.valueOf(r103.applicationInfo.uid), r103.packageName});     // Catch: Exception -> L22
        if (r106 == null) goto L20;
        int r107 = ((Integer) r106).intValue();     // Catch: Exception -> L22
        if (r107 == 2) goto L24;
        if (r107 == 1) goto L24;
        if (r107 == 4) goto L24;
        return true;
    L24:
        return false;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L22
    L7:
        if (Intrinsics.areEqual("android.permission.ACCESS_FINE_LOCATION", r110) == false) goto L9;
        r111 = "FINE_LOCATION";
        goto L10
    L9:
        r111 = new Regex("android.permission.").replaceFirst(r110, "");     // Catch: Exception -> L22
        goto L10
    L25:
        return true;
    }

    public static int b(Context r100, String r101) {
        return c(r100, r101, Process.myPid(), Process.myUid());
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return -1;
    L7:
        return 0;
    }

    public static int c(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_bytedance_bdp_bdpplatform_service_permission_PermissionCompat_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
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
        d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
