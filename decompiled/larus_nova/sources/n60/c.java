package n60;

import android.content.Context;
import androidx.core.content.PermissionChecker;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements d {
    public c() {
    }

    @Override // n60.d
    public final boolean a(Context r100, String r101) {
        if (PermissionChecker.checkSelfPermission(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
