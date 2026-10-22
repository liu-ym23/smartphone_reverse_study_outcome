package u7a;

import com.larus.platform.model.upload.ResourceUploadError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static int b(int r100) {
        if (r100 < 1000) goto L7;
        if (r100 >= 1100) goto L7;
        return 30103;
    L7:
        if (r100 < 1100) goto L10;
        if (r100 >= 1200) goto L10;
    L14:
        return 30196;
    L10:
        if (r100 < 1200) goto L14;
        if (r100 >= 1300) goto L14;
        return 30102;
    }

    public static int a(Throwable r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if ((r100 instanceof ConnectTimeoutException) == false) goto L9;
        return 1101;
    L9:
        if ((r100 instanceof SocketTimeoutException) == false) goto L12;
        return 1102;
    L12:
        if ((r100 instanceof ConnectException) == false) goto L15;
        return 1103;
    L15:
        if ((r100 instanceof BindException) == false) goto L18;
        return 1104;
    L18:
        if ((r100 instanceof NoRouteToHostException) == false) goto L21;
        return 1105;
    L21:
        if ((r100 instanceof PortUnreachableException) == false) goto L24;
        return 1106;
    L24:
        if ((r100 instanceof UnknownHostException) == false) goto L27;
        return 1107;
    L27:
        if ((r100 instanceof SocketException) == false) goto L30;
        return 1108;
    L30:
        if ((r100 instanceof IllegalArgumentException) == false) goto L33;
        return 1201;
    L33:
        if ((r100 instanceof IllegalStateException) == false) goto L36;
        return 1202;
    L36:
        if ((r100 instanceof RuntimeException) == false) goto L39;
        return 1203;
    L39:
        if ((r100 instanceof InterruptedException) == false) goto L42;
        return 1204;
    L42:
        if ((r100 instanceof FileNotFoundException) == false) goto L45;
        return 1205;
    L45:
        if ((r100 instanceof IOException) == false) goto L76;
        String r101 = r100.getMessage();
        if (r101 != null) goto L49;
    L61:
        return 1206;
    L49:
        if (r101.length() == 0) goto L61;
        if (r101.contains(ResourceUploadError.CANCELED) == false) goto L53;
        return 1001;
    L53:
        if (r101.contains("Canceled") == false) goto L56;
        return 1001;
    L56:
        if (r101.contains("network not available") == false) goto L61;
        return 1002;
    L76:
        return -1;
    }
}
