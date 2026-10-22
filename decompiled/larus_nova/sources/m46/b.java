package m46;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends c {
    @Override // m46.c
    public final void f() {
    }

    public b() {
        super("android.permission.REQUEST_INSTALL_PACKAGES");
    }

    @Override // l46.b, com.bytedance.ies.ezpermission.core.permissions.a
    public final boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return true;
    L7:
        return r100.getPackageManager().canRequestPackageInstalls();
    }

    @Override // m46.c
    public final Intent e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intent r101 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        r101.setData(UriProtector.parse("package:" + r100.getPackageName()));
        return r101;
    }
}
