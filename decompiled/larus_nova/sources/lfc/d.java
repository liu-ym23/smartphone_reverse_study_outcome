package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements kfc.a {
    public d() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return new ArrayList(0);
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L16;
        if (r101 == null) goto L19;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        Intent r103 = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        r103.putExtra("badge_count", r102);
        r103.putExtra("badge_count_package_name", r101.getPackageName());
        r103.putExtra("badge_count_class_name", r101.getClassName());
        if (nfc.a.a(r100, r103) == false) goto L15;
        r100.sendBroadcast(r103);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L15:
        throw new RedBadgerException("unable to resolve intent: " + r103.toString());
    L19:
        return;
    }
}
