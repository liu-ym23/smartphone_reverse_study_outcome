package i84;

import android.content.Context;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static boolean a(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L7:
        return true;
    L11:
        if (b(r100) == 0) goto L7;
    L8:
        return false;
    }

    public static int b(Context r110) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {"android.permission.READ_PHONE_STATE"};
        f06.b r111 = new f06.b("auto_cert_com_bytedance_bdinstall_util_InstallPmsUtils_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r112 = r106;
        int r113 = r105;
        f06.a[] r114 = r104;
        f06.d r108 = r107.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r111);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return ((Integer) r108.f474983b).intValue();
    L21:
        return r110.checkSelfPermission("android.permission.READ_PHONE_STATE");
    L14:
        r106 = r112 + 1;
        r105 = r113;
        r104 = r114;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
