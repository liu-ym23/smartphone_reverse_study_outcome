package m46;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends c {
    @Override // m46.c
    public final void f() {
    }

    public a() {
        super("android.permission.ACCESS_NOTIFICATION_POLICY");
    }

    @Override // l46.b, com.bytedance.ies.ezpermission.core.permissions.a
    public final boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return NotificationManagerCompat.from(r100).areNotificationsEnabled();
    }

    @Override // m46.c
    public final Intent e(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Intent r101 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        r101.putExtra("android.provider.extra.APP_PACKAGE", r100.getPackageName());
        return r101;
    L5:
        Intent r102 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r102.setData(Uri.fromParts("package", r100.getPackageName(), null));
        return r102;
    }
}
