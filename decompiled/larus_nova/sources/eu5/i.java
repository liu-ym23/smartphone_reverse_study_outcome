package eu5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static boolean a() {
        Enumeration<NetworkInterface> r100 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L19
        if (r100 == null) goto L21;
        Iterator r101 = Collections.list(r100).iterator();     // Catch: Throwable -> L19
    L7:
        if (r101.hasNext() == false) goto L21;
        NetworkInterface r102 = (NetworkInterface) r101.next();     // Catch: Throwable -> L19
        if (r102.isUp() == false) goto L7;
        if (r102.getInterfaceAddresses().size() == 0) goto L7;
        if ("tun0".equals(r102.getName()) == true) goto L34;
        if ("ppp0".equals(r102.getName()) == false) goto L7;
        return true;
    L34:
        return true;
    L21:
        return false;
    L19:
        th = move-exception;
        tt5.a.f("WifiUtils", th, false);
        goto L21
    }

    public static boolean b() {
        String r100 = System.getProperty("http.proxyHost");
        String r101 = System.getProperty("http.proxyPort");
        if (r101 != null) goto L6;
        r101 = "-1";
    L6:
        int r102 = CastIntegerProtector.parseInt(r101);
        tt5.a.b("WifiUtils", "proxyAddress :" + r100 + "proxyPort :" + r102);
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L11:
        return false;
    L9:
        if (r102 == (-1)) goto L11;
        return true;
    }
}
