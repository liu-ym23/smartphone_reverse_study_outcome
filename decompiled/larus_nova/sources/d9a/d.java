package d9a;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f467648a;

    public static Map<String, Boolean> a(Context r210) {
        HashMap r100 = new HashMap();
        String[] r101 = f467648a;
        if (r101 == null) goto L31;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L31;
        String r104 = r101[r103];
        if (TextUtils.isEmpty(r104) == true) goto L29;
        int r105 = Process.myPid();
        int r106 = Process.myUid();
        ArrayList r107 = new ArrayList();
        boolean r110 = true;
        Object[] r108 = {r104, Integer.valueOf(r105), Integer.valueOf(r106)};
        f06.b r111 = new f06.b("auto_cert_com_monitor_cloudmessage_utils_PermissionUtils_android_content_Context_checkPermission");
        g06.a r112 = ApiHookConfig.f245611b.get(102607);
        if (r112 == null) goto L12;
        f06.a[] r113 = r112.f479473i;
    L13:
        f06.a[] r114 = r113;
        int r115 = r114.length;
        int r116 = 0;
    L15:
        if (r116 >= r115) goto L22;
        f06.a r117 = r114[r116];
        int r211 = r116;
        int r212 = r115;
        f06.a[] r213 = r114;
        f06.b r214 = r111;
        f06.d r118 = r117.preInvoke(102607, "android/content/Context", "checkPermission", r210, r108, "int", r214);     // Catch: Exception -> L32
        if (r118.f474982a == true) goto L24;
        r107.add(r117);     // Catch: Exception -> L32
    L24:
        if (r118.f474982a == false) goto L26;
        int r109 = ((Integer) r118.f474983b).intValue();
    L27:
        if (r109 != 0) goto L29;
    L30:
        r100.put(r104, Boolean.valueOf(r110));
        r103 = r103 + 1;
        goto L5
    L26:
        r109 = r210.checkPermission(r104, r105, r106);
    L21:
        r116 = r211 + 1;
        r115 = r212;
        r114 = r213;
        r111 = r214;
        goto L15
    L22:
        r118 = new f06.d(false, null);
        goto L24
    L12:
        r113 = ApiHookConfig.f245613d;
    L29:
        r110 = false;
    L31:
        return r100;
    }
}
