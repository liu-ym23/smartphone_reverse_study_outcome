package uv3;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r0 = b(r3);
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r0 == true) goto L6;
    L8:
        return false;
    L6:
        if (ContextCompat.checkSelfPermission(r3, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) goto L8;
        return true;
    L10:
        return r0;
    }

    public static boolean b(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (ContextCompat.checkSelfPermission(r1, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L5;
    L7:
        return false;
    L5:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L7;
        return true;
    }
}
