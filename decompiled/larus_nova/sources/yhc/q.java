package yhc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.facebook.net.NetUtils;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes40.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f567726a = 0;

    static {
    }

    public static int a(Context r100, Throwable r101) {
        if ((r101 instanceof ConnectTimeoutException) == false) goto L6;
        int r102 = 13;
    L26:
        if (r100 == null) goto L42;
        if (r102 == 15) goto L40;
        if (r102 == 14) goto L40;
        return r102;
    L40:
        NetworkInfo r103 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L34
        if (r103 == null) goto L36;
        if (r103.isAvailable() == false) goto L36;
        boolean r104 = true;
    L37:
        if (r104 == true) goto L44;
        return 12;
    L44:
        return r102;
    L36:
        r104 = false;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L42:
        return r102;
    L6:
        if ((r101 instanceof SocketTimeoutException) == false) goto L9;
        r102 = 14;
        goto L26
    L9:
        if ((r101 instanceof SocketException) == false) goto L12;
        Logger.v(NetUtils.TAG, "api socket exception: " + r101);
    L24:
        r102 = 15;
        goto L26
    L12:
        if ((r101 instanceof SSLPeerUnverifiedException) == false) goto L15;
        Logger.v(NetUtils.TAG, "api ssl exception: " + r101);
        r102 = 21;
        goto L26
    L15:
        if ((r101 instanceof HttpResponseException) == false) goto L22;
        if (((HttpResponseException) r101).getStatusCode() != 503) goto L19;
        int r105 = 19;
    L20:
        Logger.w(NetUtils.TAG, "server error: " + r101);
        r102 = r105;
        goto L26
    L19:
        r105 = 16;
        goto L20
    L22:
        if ((r101 instanceof IOException) == false) goto L25;
        Logger.v(NetUtils.TAG, "api io exception: " + r101);
        goto L24
    L25:
        Logger.w(NetUtils.TAG, "api exception: " + r101);
        r102 = 18;
        goto L26
    }
}
