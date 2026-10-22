package ec4;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static void a(Context r100, String r101, Map<String, String> r102) {
        URL r103 = new URL(r101);     // Catch: Exception -> L14
        int r104 = 0;
        if (TextUtils.isEmpty(r103.getPath()) == false) goto L6;
    L8:
        boolean r105 = true;
    L9:
        StringBuilder r106 = new StringBuilder("n=");     // Catch: Exception -> L14
        if (r105 == false) goto L12;
        r104 = 1;
    L12:
        r106.append(r104);     // Catch: Exception -> L14
        r106.append(com.alipay.sdk.m.u.i.f25853b);     // Catch: Exception -> L14
        r102.put(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, r106.toString() + "t=0");     // Catch: Exception -> L14
        return;
    L6:
        if (r103.getPath().contains("vc/setting") == false) goto L8;
        r105 = !r100.getSharedPreferences("bd_turning_settings_init", 0).getBoolean("inited", false);     // Catch: Exception -> L14
    }
}
