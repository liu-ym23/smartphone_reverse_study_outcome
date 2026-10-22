package yta;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.ss.android.lark.log.Log;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static void a(Application r100) {
        Intent r101 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        r101.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        r101.putExtra("packageName", r100.getPackageName());
        r101.setFlags(268435456);
        PackageManager r102 = r100.getPackageManager();
        boolean r103 = false;
        if (r102 == null) goto L10;
        List<ResolveInfo> r104 = r102.queryIntentActivities(r101, 65536);
        if (r104 == null) goto L10;
        if (r104.size() <= 0) goto L10;
        r103 = true;
    L10:
        if (r103 == false) goto L12;
        r100.startActivity(r101);
        return;
    L12:
        Log.e("MeizuFloatPermission", "permission setting page not found");
        Intent r105 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r105.setData(Uri.fromParts("package", r100.getPackageName(), null));
        r105.setFlags(268435456);
        r100.startActivity(r105);
    }
}
