package vu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends a {
    @Override // vu.a, vu.c
    public final boolean b() {
        return false;
    }

    public b() {
    }

    @Override // vu.a, vu.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent();
        r101.putExtra("packageName", r100.getPackageName());
        r101.setComponent(new ComponentName(RomUtils.PACKAGE_INSTALLER_ANDROID, "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        return r101;
    }
}
