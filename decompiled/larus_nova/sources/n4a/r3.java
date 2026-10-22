package n4a;

import android.net.wifi.WifiInfo;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiInfo f517649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f517650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f517651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f517652d;

    public r3(WifiInfo r100) {
        this.f517652d = -1;
        this.f517649a = r100;
    }

    public final String a() {
        if (this.f517650b != null) goto L28;
        WifiInfo r100 = this.f517649a;
        if (r100 != null) goto L7;
        String r110 = null;
    L26:
        this.f517650b = r110;
        goto L28
    L7:
        ArrayList r111 = new ArrayList();
        Object[] r112 = new Object[0];
        f06.b r113 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101000);
        if (r101 == null) goto L10;
        f06.a[] r102 = r101.f479473i;
    L11:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L20;
        f06.a r106 = r103[r105];
        int r114 = r105;
        int r115 = r104;
        f06.a[] r210 = r103;
        f06.d r107 = r106.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r100, r112, "java.lang.String", r113);     // Catch: Exception -> L29
        if (r107.f474982a == true) goto L22;
        r111.add(r106);     // Catch: Exception -> L29
    L22:
        if (r107.f474982a == false) goto L24;
        String r108 = (String) r107.f474983b;
    L25:
        r110 = r108;
        goto L26
    L24:
        r108 = r100.getSSID();
    L19:
        r105 = r114 + 1;
        r104 = r115;
        r103 = r210;
        goto L13
    L20:
        r107 = new f06.d(false, null);
        goto L22
    L10:
        r102 = ApiHookConfig.f245613d;
    L28:
        return this.f517650b;
    }
}
