package xsa;

import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.network.imp.TTNetDepend;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.bridge.BridgeMethodInfo;
import com.bytedance.sdk.bridge.auth.AbsBridgeAuthFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends AbsBridgeAuthFilter<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f565045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f565046b;

    static {
        ArrayList r100 = new ArrayList();
        f565045a = r100;
        r100.add(TTNetDepend.API_HOST_I2);
    }

    public a() {
    }

    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        List<String> r101 = f565045a;
        if (((ArrayList) r101).contains(r100) == true) goto L9;
        ((ArrayList) r101).add(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.sdk.bridge.auth.AbsBridgeAuthFilter
    public final boolean auth(String r100, BridgeMethodInfo r101) {
        String r102 = r100;
        if (TextUtils.isEmpty(r102) == false) goto L35;
    L31:
        return false;
    L35:
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L6:
        if (r102.startsWith("http://") == true) goto L11;
        if (r102.startsWith("https://") == false) goto L31;
    L11:
        String r103 = null;
        if (TextUtils.isEmpty(r102) == true) goto L19;
        r103 = UriProtector.parse(r102).getHost();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L29
    L19:
        if (TextUtils.isEmpty(r103) == true) goto L31;
        Iterator r104 = ((ArrayList) f565045a).iterator();     // Catch: Exception -> L29
    L22:
        if (r104.hasNext() == false) goto L31;
        String r105 = (String) r104.next();     // Catch: Exception -> L29
        if (TextUtils.equals(r105, r103) == true) goto L28;
        if (r103.endsWith("." + r105) == false) goto L22;
    L28:
        return true;
    }
}
