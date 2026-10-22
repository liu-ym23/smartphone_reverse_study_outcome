package vma;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("connectivity");
        if (r101 == null) goto L21;
        ConnectivityManager r102 = (ConnectivityManager) r101;
        Network r103 = r102.getActiveNetwork();
        if (r103 != null) goto L7;
        return false;
    L7:
        NetworkCapabilities r104 = r102.getNetworkCapabilities(r103);
        if (r104 != null) goto L11;
        return false;
    L11:
        if (r104.hasTransport(1) == false) goto L14;
    L12:
        return true;
    L14:
        if (r104.hasTransport(0) == true) goto L12;
        if (r104.hasTransport(3) == true) goto L12;
        return false;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
