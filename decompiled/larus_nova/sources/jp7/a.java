package jp7;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f499990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final jf7.b f499991b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f499992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f499993d;

    static {
        f499991b = if7.b.a();
        f499992c = null;
        f499993d = null;
    }

    public static boolean a() {
        ApplicationInfo r100 = getContext().getApplicationInfo();
        int r101 = r100.uid;
        String r102 = r100.packageName;
        if (f499990a == false) goto L24;
    L22:
        if (c.a().b() == false) goto L16;
        Object r103 = f499992c;     // Catch: Exception -> L15
        if (r103 == null) goto L16;
        Method r104 = f499993d;     // Catch: Exception -> L15
        if (r104 == null) goto L16;
        int r105 = ((Integer) r104.invoke(r103, new Object[]{29, Integer.valueOf(r101), r102})).intValue();     // Catch: Exception -> L15
    L17:
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L19;
        return true;
    L19:
        return false;
    L16:
        r105 = 0;
        goto L17
    L24:
        jf7.b r106 = f499991b;     // Catch: Exception -> L21
        Field r107 = r106.c(AppOpsManager.class);     // Catch: Exception -> L21
        r107.setAccessible(true);     // Catch: Exception -> L21
        f499992c = r107.get((AppOpsManager) getContext().getSystemService("appops"));     // Catch: Exception -> L21
        Class<?> r108 = r106.b("com.android.internal.app.IAppOpsService$Stub$Proxy");     // Catch: Exception -> L21
        Class<?> r110 = Integer.TYPE;     // Catch: Exception -> L21
        f499993d = r106.a(r108, "checkOperation", new Class[]{r110, r110, String.class});     // Catch: Exception -> L21
    L6:
        f499990a = true;
        goto L22
    }

    private static Context getContext() {
        return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
    }
}
