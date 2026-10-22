package p60;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends a {
    @Override // p60.a, p60.c
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

    @Override // p60.a, p60.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity"));
        r101.putExtra("pkg_name", r100.getPackageName());
        ApplicationInfo r102 = r100.getApplicationInfo();
        int r103 = r102.labelRes;
        if (r103 == 0) goto L5;
        String r104 = r100.getString(r103);
    L9:
        r101.putExtra("app_name", r104);
        r101.putExtra("class_name", f.class.getSimpleName());
        return r101;
    L5:
        CharSequence r105 = r102.nonLocalizedLabel;
        if (r105 == null) goto L8;
        r104 = r105.toString();
        goto L9
    L8:
        r104 = String.valueOf(r100.getPackageManager().getApplicationLabel(r102));
        goto L9
    }
}
