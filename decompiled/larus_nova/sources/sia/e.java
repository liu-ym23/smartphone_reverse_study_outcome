package sia;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542256a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L19
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L19
        ConnectivityManager r102 = (ConnectivityManager) r101;     // Catch: Exception -> L19
        NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L19
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Network r104 = r102.getActiveNetwork();     // Catch: Exception -> L19
        if (r104 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r105 = r102.getNetworkCapabilities(r104);     // Catch: Exception -> L19
        if (r105 != null) goto L11;
        return false;
    L11:
        boolean r106 = r105.hasCapability(16);     // Catch: Exception -> L19
    L13:
        if (r103 == null) goto L22;
        if (r103.isConnected() == false) goto L23;
        if (r106 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L12:
        r106 = true;
    L25:
        return false;
    }
}
