package p60;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends a {
    @Override // p60.a, p60.c
    public final boolean b() {
        return false;
    }

    public b() {
    }

    @Override // p60.a, p60.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent();
        r101.putExtra("packageName", r100.getPackageName());
        r101.setComponent(new ComponentName(RomUtils.PACKAGE_INSTALLER_ANDROID, "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        return r101;
    }
}
