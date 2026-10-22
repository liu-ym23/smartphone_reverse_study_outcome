package n4a;

import android.net.wifi.WifiInfo;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class p3 {
    public static String a(WifiInfo r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101100);
        if (r101 == null) goto L8;
        f06.a[] r102 = r101.f479473i;
    L9:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L18;
        f06.a r106 = r103[r105];
        int r113 = r105;
        int r114 = r104;
        f06.a[] r115 = r103;
        f06.d r107 = r106.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L24
        if (r107.f474982a == true) goto L20;
        r100.add(r106);     // Catch: Exception -> L24
    L20:
        if (r107.f474982a == false) goto L23;
        return (String) r107.f474983b;
    L23:
        return r110.getBSSID();
    L17:
        r105 = r113 + 1;
        r104 = r114;
        r103 = r115;
        goto L11
    L18:
        r107 = new f06.d(false, null);
        goto L20
    L8:
        r102 = ApiHookConfig.f245613d;
        goto L9
    }
}
