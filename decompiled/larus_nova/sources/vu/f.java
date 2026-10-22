package vu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.android.gamecp.common.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends a {
    @Override // vu.a, vu.c
    public final boolean b() {
        if (Build.VERSION.SDK_INT == 23) goto L5;
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_ENABLE_BY_CHECKER.getValue().booleanValue() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public f() {
    }

    @Override // vu.a, vu.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity"));
        r101.putExtra("pkg_name", r100.getPackageName());
        ApplicationInfo r102 = r100.getApplicationInfo();
        int r103 = r102.labelRes;
        if (r103 != 0) goto L5;
        String r104 = r102.nonLocalizedLabel.toString();
    L6:
        r101.putExtra("app_name", r104);
        r101.putExtra("class_name", f.class.getSimpleName());
        return r101;
    L5:
        r104 = r100.getString(r103);
        goto L6
    }
}
