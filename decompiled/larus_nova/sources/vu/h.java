package vu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes44.dex */
public final class h extends a {
    @Override // vu.a, vu.c
    public final boolean b() {
        return false;
    }

    public h() {
    }

    @Override // vu.a, vu.c
    public final Intent a(Context r100) {
        Intent r101 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r101.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        r101.putExtra("extra_pkgname", r100.getPackageName());
        return r101;
    }
}
