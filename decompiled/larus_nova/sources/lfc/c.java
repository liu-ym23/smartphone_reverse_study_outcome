package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class c implements kfc.a {
    public c() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.asus.launcher", "com.lge.launcher", "com.lge.launcher2", "com.lge.launcher3"});
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L17;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r102 >= 0) goto L8;
        r102 = 0;
    L8:
        Intent r103 = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        r103.putExtra("badge_count", r102);
        r103.putExtra("badge_count_package_name", r101.getPackageName());
        r103.putExtra("badge_count_class_name", r101.getClassName());
        r103.putExtra("badge_vip_count", 0);
        if (nfc.a.a(r100, r103) == false) goto L16;
        r100.sendBroadcast(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L16:
        throw new RedBadgerException("unable to resolve intent: " + r103.toString());
    }
}
