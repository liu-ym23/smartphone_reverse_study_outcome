package n46;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Intent> f517059a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f517060b = null;

    public a() {
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    static {
        f517060b = new a();
        f517059a = new ArrayList();
    }

    public static boolean a(Activity r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_bytedance_ies_ezpermission_util_EzPermissionUtil_android_app_Activity_shouldShowRequestPermissionRationale");
        g06.a r102 = ApiHookConfig.f245611b.get(102609);
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
        d r107 = r106.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Boolean) r107.f474983b).booleanValue();
    L21:
        return r110.shouldShowRequestPermissionRationale(r111);
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

    public static boolean b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
