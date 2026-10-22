package cta;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.caijing.cjpay.env.permission.PermissionHandlerActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<cta.a> f465373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f465374b;

    /* JADX INFO: loaded from: classes34.dex */
    public interface a {
        void onPermissionCheckCallback(String[] r100, int[] r101, boolean r102);
    }

    /* JADX INFO: renamed from: cta.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes34.dex */
    public static class C5585b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f465375a = null;

        static {
            f465375a = new b();
        }
    }

    public b() {
        this.f465373a = new ArrayList();
    }

    public static boolean c(Context r100) {
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (r100 == null) goto L8;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L8;
        return true;
    L8:
        return false;
    }

    public static cta.a a(Context r110, cta.a r111) {
        if (r111 != null) goto L5;
        return null;
    L5:
        String[] r100 = r111.f465369b;
        int r101 = r100.length;
        if (r101 == 1) goto L8;
        ArrayList r102 = new ArrayList(r101);
        ArrayList r103 = new ArrayList(r101);
        int r104 = 0;
    L13:
        if (r104 >= r101) goto L22;
        String r105 = r100[r104];
        if (b(r110, r105) == false) goto L19;
        Map<String, Integer> r106 = r111.f465371d;
        if (r106 == null) goto L20;
        ((HashMap) r106).put(r105, 0);
    L20:
        r104 = r104 + 1;
        goto L13
    L19:
        r102.add(r105);
        r103.add(r111.f465370c[r104]);
        goto L20
    L22:
        if (r102.size() != 0) goto L25;
        r111.b();
        return null;
    L25:
        r111.f465369b = (String[]) r102.toArray(new String[r102.size()]);
        r111.f465370c = (String[]) r103.toArray(new String[r103.size()]);
        return r111;
    L8:
        if (b(r110, r100[0]) == false) goto L11;
        r111.b();
        return null;
    L11:
        return r111;
    }

    public static boolean b(Context r100, String r110) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r110) == true) goto L33;
        if (r100 == null) goto L33;
        int r102 = ContextCompat.checkSelfPermission(r100, r110);     // Catch: Exception -> L9
    L14:
        CJLogger.d("PermissionCheckHelper", r110 + " " + r102);
        boolean r103 = true;
        if (r102 != 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
    L31:
        CJLogger.d("PermissionCheckHelper", "final:" + r110 + " " + r104);
        return r104;
    L20:
        if (Build.VERSION.SDK_INT >= 23) goto L35;
    L30:
        r104 = r103;
        goto L31
    L35:
        AppOpsManager r105 = (AppOpsManager) r100.getSystemService("appops");     // Catch: Exception -> L28
        String r106 = AppOpsManager.permissionToOp(r110);     // Catch: Exception -> L28
        if (r106 == null) goto L30;
        int r107 = r105.checkOpNoThrow(r106, Process.myUid(), r100.getPackageName());     // Catch: Exception -> L28
        CJLogger.d("PermissionCheckHelper", "checkOps:" + r106 + " " + r110 + " " + r107);     // Catch: Exception -> L28
        if (r107 != 0) goto L27;
        r101 = true;
    L27:
        r103 = r101;
    L28:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionCheckHelper#checkOps", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PermissionCheckHelper#checkOps", e);
        goto L30
    L17:
        r104 = false;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionCheckHelper#isGranted", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PermissionCheckHelper#isGranted", e);
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r102 = -1;
        goto L14
    L13:
        r102 = 0;
    L33:
        CJLogger.a("PermissionCheckHelper", "runtime permission check params error");
        return false;
    }

    public void requestPermissions(Context r100, cta.a r101, boolean r102) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        cta.a r103 = a(r100, r101);
        if (r103 == null) goto L19;
        monitor-enter(this);
        ((ArrayList) this.f465373a).add(r103);     // Catch: Throwable -> L16
        if (this.f465374b == false) goto L22;
    L14:
        monitor-exit(this);
        return;
    L22:
        CJPayRouterAPI.getInstance().build(PermissionHandlerActivity.class).withSerializable("is_immersive", Boolean.valueOf(r102)).addFlags(603979776).setPackage(r100.getPackageName()).navigation(r100);     // Catch: Exception -> L12 Throwable -> L16
        this.f465374b = true;     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionCheckHelper#enqueueRequestPermission", e);     // Catch: Throwable -> L16
        CJLogger.a("PermissionCheckHelper", "permission handle activity start failed!");     // Catch: Throwable -> L16
        this.f465374b = false;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        return;
    L20:
        CJLogger.a("PermissionCheckHelper", "runtime permission request params error");
    }

    public void requestPermissions(Context r100, String[] r101, a r102) {
        requestPermissions(r100, r101, r102, false);
    }

    public void requestPermissions(Context r100, String[] r110, a r111, boolean r112) {
        if (r100 == null) goto L9;
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.length == 0) goto L11;
        String[] r101 = new String[r110.length];
        Arrays.fill(r101, "");
        requestPermissions(r100, 1, r110, r101, r111, r112);
        return;
    L11:
        return;
    }

    public void requestPermissions(Context r100, int r101, String[] r110, String[] r111, a r112) {
        requestPermissions(r100, r101, r110, r111, r112, false);
    }

    public void requestPermissions(Context r100, int r101, String[] r102, String[] r103, a r104, boolean r105) {
        if (r104 == null) goto L28;
        if (r102 == null) goto L28;
        if (r102.length == 0) goto L28;
        if (r103 == null) goto L28;
        if (r102.length != r103.length) goto L28;
        cta.a r106 = new cta.a(r104, r102, r103);
        if (r102.length == 0) goto L18;
        int r107 = r102.length;
        boolean r108 = false;
        int r109 = 0;
    L13:
        if (r109 >= r107) goto L18;
        if (b(r100, r102[r109]) == false) goto L19;
        r109 = r109 + 1;
    L19:
        if (r108 == false) goto L21;
    L25:
        r106.b();
        return;
    L21:
        if (Build.VERSION.SDK_INT < 23) goto L25;
        requestPermissions(r100, r106, r105);
        return;
    L18:
        r108 = true;
    L28:
        throw new IllegalArgumentException("permission request build failed: params error");
    }
}
