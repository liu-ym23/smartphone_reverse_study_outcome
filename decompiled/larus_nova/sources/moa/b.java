package moa;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static boolean a(Context r100, String r101) {
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
