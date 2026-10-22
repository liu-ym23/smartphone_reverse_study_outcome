package m46;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends c {
    @Override // m46.c
    public final void f() {
    }

    public e() {
        super("android.permission.WRITE_SETTINGS");
    }

    @Override // l46.b, com.bytedance.ies.ezpermission.core.permissions.a
    public final boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return true;
    L7:
        return Settings.System.canWrite(r100);
    }

    @Override // m46.c
    public final Intent e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intent r101 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        r101.setData(UriProtector.parse("package:" + r100.getPackageName()));
        return r101;
    }
}
