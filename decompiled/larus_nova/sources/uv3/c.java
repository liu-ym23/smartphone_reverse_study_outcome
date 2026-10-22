package uv3;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551810a = 0;

    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = b(r100);
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r101 == true) goto L6;
    L8:
        return false;
    L6:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) goto L8;
        return true;
    L10:
        return r101;
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L5;
    L7:
        return false;
    L5:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L7;
        return true;
    }
}
