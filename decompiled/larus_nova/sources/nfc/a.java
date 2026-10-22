package nfc;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static boolean a(Context r100, Intent r101) {
        if (r100 == null) goto L13;
        PackageManager r102 = r100.getPackageManager();
        if (r102 != null) goto L7;
        return false;
    L7:
        List<ResolveInfo> r103 = r102.queryBroadcastReceivers(r101, 0);
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.size() <= 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }
}
