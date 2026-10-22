package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class j implements kfc.a {
    public j() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L19;
        if (r101 == null) goto L22;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        Intent r103 = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        r103.putExtra("com.htc.launcher.extra.COMPONENT", r101.flattenToShortString());
        r103.putExtra("com.htc.launcher.extra.COUNT", r102);
        Intent r104 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        r104.putExtra("packagename", r101.getPackageName());
        r104.putExtra("count", r102);
        if (nfc.a.a(r100, r103) == false) goto L10;
    L20:
        r100.sendBroadcast(r103);     // Catch: Throwable -> L16
        r100.sendBroadcast(r104);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L10:
        if (nfc.a.a(r100, r104) == true) goto L20;
        throw new RedBadgerException("unable to resolve intent: " + r104.toString());
    L22:
        return;
    }
}
