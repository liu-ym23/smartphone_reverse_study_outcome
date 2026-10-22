package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements kfc.a {
    public a() {
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher", "org.adw.launcher.one"});
    }

    @Override // kfc.a
    public final void a(Context r100, ComponentName r101, int r102) throws RedBadgerException {
        if (r100 == null) goto L16;
        if (r101 == null) goto L19;
        if (r102 >= 0) goto L7;
        r102 = 0;
    L7:
        Intent r103 = new Intent("org.adw.launcher.counter.SEND");
        r103.putExtra("PNAME", r101.getPackageName());
        r103.putExtra("CNAME", r101.getClassName());
        r103.putExtra("COUNT", r102);
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
