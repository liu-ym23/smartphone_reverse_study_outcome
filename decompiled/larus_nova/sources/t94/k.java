package t94;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.bdp.appbase.locate.map.BdpMapActivity;

/* JADX INFO: loaded from: classes11.dex */
public final class k {
    public static boolean a(BdpMapActivity r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r102 == null) goto L12;
        return true;
    L12:
        return false;
    L5:
        e = move-exception;
        g94.b.c().Y1(e);
        r102 = null;
        goto L7
    }
}
