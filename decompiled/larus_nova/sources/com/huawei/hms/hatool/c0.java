package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class c0 {
    public static boolean a(Context r100) {
        long r101 = d.a(r100, "Privacy_MY", "flashKeyTime", -1);
        if ((System.currentTimeMillis() - r101) <= com.heytap.mcssdk.constant.a.f276320g) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Context r100, String r101) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        if (r100.getPackageManager().checkPermission(r101, r100.getPackageName()) == 0) goto L15;
        v.f("hmsSdk", "not have read phone permission!");
        return true;
    L15:
        return false;
    L12:
        if (com_huawei_hms_hatool_c0_android_content_Context_checkSelfPermission(r100, r101) == 0) goto L17;
        v.f("hmsSdk", "not have read phone permission!");
        return true;
    L17:
        return false;
    }

    public static boolean a(Context r100, String r101, int r102) {
        String r103 = d.c(r100, r101) + ".xml";
        File r104 = new File(r100.getFilesDir(), "../shared_prefs/" + r103);
        if (r104.exists() == true) goto L5;
        String r105 = r100.getPackageName() + "_" + r103;
        r104 = new File(r100.getFilesDir(), "../../shared_prefs/" + r105);
    L5:
        long r106 = r104.length();
        if (r106 <= r102) goto L9;
        v.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", new Object[]{Long.valueOf(r106), Integer.valueOf(r102)}));
        return true;
    L9:
        return false;
    }

    public static boolean a(String r100, long r101, long r102) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return true;
    L13:
        if ((r101 - CastLongProtector.parseLong(r100)) > r102) goto L15;
        return false;
    L15:
        return true;
    L11:
        v.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
        return true;
    }

    private static int com_huawei_hms_hatool_c0_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_huawei_hms_hatool_c0_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
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
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
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
}
