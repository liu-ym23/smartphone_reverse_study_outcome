package h30;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.browser.jsbridge.permissions.JSBOpenSettingFragment;
import com.bytedance.android.live.browser.jsbridge.permissions.JSBPermissionFragment;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f483660a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f483661b = true;

    public static void a(final Activity r100, final a r101, final String[] r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L31;
        JSBOpenSettingFragment r103 = null;
        if (r100.isFinishing() == true) goto L16;
        FragmentManager r104 = r100.getFragmentManager();     // Catch: Exception -> L19
        if (r104 == null) goto L16;
        r103 = (JSBOpenSettingFragment) r104.findFragmentByTag("JSBOpenSettingFragment");     // Catch: Exception -> L19
        if (r103 != null) goto L16;
        r103 = new JSBOpenSettingFragment();     // Catch: Exception -> L19
        r104.beginTransaction().add(r103, "JSBOpenSettingFragment").commitAllowingStateLoss();     // Catch: Exception -> L19
        r104.executePendingTransactions();     // Catch: Exception -> L19
    L16:
        if (r103 == null) goto L30;
        r103.d(r101, r102);     // Catch: Exception -> L19
        return;
    L30:
        return;
    L19:
        e = move-exception;
        if ((e instanceof IllegalStateException) == true) goto L23;
    L25:
        ALogger.e("JSBOpenSettingFragment", e.toString());
        return;
    L23:
        if (f483661b == false) goto L25;
        new Handler(Looper.getMainLooper()).post(new c(r100, r101, r102));
        f483661b = false;
        ALogger.e("JSBOpenSettingFragment", "try request in handler post");
        goto L25
    }

    public static void b(final Activity r100, final a r101, final String[] r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L31;
        JSBPermissionFragment r103 = null;
        if (r100.isFinishing() == true) goto L16;
        FragmentManager r104 = r100.getFragmentManager();     // Catch: Exception -> L19
        if (r104 == null) goto L16;
        r103 = (JSBPermissionFragment) r104.findFragmentByTag("JSBPermissionsRequestFragment");     // Catch: Exception -> L19
        if (r103 != null) goto L16;
        r103 = new JSBPermissionFragment();     // Catch: Exception -> L19
        r104.beginTransaction().add(r103, "JSBPermissionsRequestFragment").commitAllowingStateLoss();     // Catch: Exception -> L19
        r104.executePendingTransactions();     // Catch: Exception -> L19
    L16:
        if (r103 == null) goto L30;
        r103.requestPermissions(r101, r102);     // Catch: Exception -> L19
        return;
    L30:
        return;
    L19:
        e = move-exception;
        if ((e instanceof IllegalStateException) == true) goto L23;
    L25:
        ALogger.e("JSBPermissionsRequestFragment", e.toString());
        return;
    L23:
        if (f483660a == false) goto L25;
        new Handler(Looper.getMainLooper()).post(new b(r100, r101, r102));
        f483660a = false;
        ALogger.e("JSBPermissionsRequestFragment", "try request in handler post");
        goto L25
    }
}
