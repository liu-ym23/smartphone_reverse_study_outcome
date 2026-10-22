package xz8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.larus.common.apphost.AppHost;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565543a = 0;

    public static final class a {
        public static int a(Throwable r100) {
            if ((r100 instanceof ConnectTimeoutException) == false) goto L6;
            int r101 = -13;
        L25:
            if (r101 == (-15)) goto L29;
            if (r101 == (-14)) goto L29;
            return r101;
        L29:
            if (b(AppHost.f326268a.getApplication()) == true) goto L32;
            return -12;
        L32:
            return r101;
        L6:
            if ((r100 instanceof SocketTimeoutException) == false) goto L9;
            r101 = -14;
            goto L25
        L9:
            if ((r100 instanceof SocketException) == false) goto L12;
            r100.toString();
        L17:
            r101 = -15;
            goto L25
        L12:
            if ((r100 instanceof SSLPeerUnverifiedException) == false) goto L15;
            r100.toString();
        L20:
            r101 = -21;
            goto L25
        L15:
            if ((r100 instanceof IOException) == false) goto L19;
            r100.toString();
            goto L17
        L19:
            if ((r100 instanceof SSLHandshakeException) == true) goto L20;
            if ((r100 instanceof UnknownHostException) == false) goto L24;
            r101 = -16;
            goto L25
        L24:
            r100.toString();
            r101 = -1;
            goto L25
        }

        public static boolean b(Context r100) {
            if (r100 != null) goto L12;
            return false;
        L12:
            Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L11
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L11
            NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Exception -> L11
            if (r102 == null) goto L14;
            if (r102.isConnected() == false) goto L15;
            return true;
        L15:
            return false;
        L14:
            return false;
        L16:
            return false;
        }
    }

    static {
    }
}
