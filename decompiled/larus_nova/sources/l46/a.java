package l46;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends b {
    public a() {
        super("android.permission.ACTIVITY_RECOGNITION");
    }

    @Override // l46.b, com.bytedance.ies.ezpermission.core.permissions.a
    public final boolean a(Activity r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return false;
    L6:
        if (c(r210) == true) goto L34;
        String r110 = this.f507349a;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r110};
        f06.b r113 = new f06.b("auto_cert_com_bytedance_ies_ezpermission_core_permissions_common_ActivityRecognitionPermission_android_app_Activity_shouldShowRequestPermissionRationale");
        g06.a r100 = ApiHookConfig.f245611b.get(102609);
        if (r100 == null) goto L10;
        f06.a[] r101 = r100.f479473i;
    L11:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L20;
        f06.a r105 = r102[r104];
        int r114 = r104;
        int r211 = r103;
        f06.a[] r212 = r102;
        d r106 = r105.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r210, r112, "boolean", r113);     // Catch: Exception -> L28
        if (r106.f474982a == true) goto L22;
        r111.add(r105);     // Catch: Exception -> L28
    L22:
        if (r106.f474982a == false) goto L24;
        boolean r107 = ((Boolean) r106.f474983b).booleanValue();
    L25:
        if (r107 == true) goto L35;
        return true;
    L35:
        return false;
    L24:
        r107 = r210.shouldShowRequestPermissionRationale(r110);
    L19:
        r104 = r114 + 1;
        r103 = r211;
        r102 = r212;
        goto L13
    L20:
        r106 = new d(false, null);
        goto L22
    L10:
        r101 = ApiHookConfig.f245613d;
        goto L11
    L34:
        return false;
    }

    @Override // l46.b, com.bytedance.ies.ezpermission.core.permissions.a
    public final boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 29) goto L7;
        n46.a.f517060b.getClass();
        return n46.a.b(r100, "android.permission.BODY_SENSORS");
    L7:
        return super.c(r100);
    }
}
