package pj7;

import android.util.Pair;
import cn7.e;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.sdk.bridge.Logger;
import com.bytedance.ug.sdk.luckycat.api.depend.j;
import com.bytedance.ug.sdk.luckycat.base.network.CommonApi;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import ik7.g;
import java.util.ArrayList;
import wi7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static boolean a() {
        int r100 = m.a.f271349a.g();
        if (r100 != 1128) goto L5;
        return true;
    L5:
        if (r100 != 2329) goto L7;
        return true;
    L7:
        if (r100 != 8663) goto L9;
        return true;
    L9:
        if (r100 == 482431) goto L17;
        return false;
    L17:
        return true;
    }

    static {
    }

    public static SsResponse b(String r100) {
        Logger.f269563c.getClass();
        Logger.a();
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L13
        m r102 = m.a.f271349a;     // Catch: Throwable -> L13
        j r103 = r102.f271336d;     // Catch: Throwable -> L13
        if (r103 == null) goto L8;
        g r104 = ((e) r103).f24557b;     // Catch: Throwable -> L13
        if (r104 == null) goto L8;
        Pair r105 = r104.getRequestTagHeader();     // Catch: Throwable -> L13
    L9:
        if (r105 == null) goto L11;
        r101.add(new Header((String) r105.first, (String) r105.second));     // Catch: Throwable -> L13
    L11:
        c.a();     // Catch: Throwable -> L13
        return c.b(((CommonApi) wi7.a.a(CommonApi.class)).getDataForGet(r102.b(r100), r101, true), r100);
    L8:
        r105 = null;
    L13:
        th = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("NetworkColorManager", "requestWithColor error: " + th);
        return null;
    }
}
