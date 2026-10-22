package com.ss.android.ugc.aweme.shortvideo.net;

import android.net.NetworkInfo;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class NetUtils {

    public @interface NetType {
    }

    public static String a(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102026);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }
}
