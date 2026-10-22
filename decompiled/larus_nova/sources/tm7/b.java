package tm7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import um7.e;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static boolean b(Map<String, String> r100) {
        if (r100.size() > 0) goto L6;
        return false;
    L6:
        if (r100.containsKey("luckydog_base") == true) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r100.get("luckydog_base")) == false) goto L11;
        return false;
    L11:
        if (r100.containsKey("luckydog_data") == true) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(r100.get("luckydog_data")) == false) goto L16;
        return false;
    L16:
        if (r100.containsKey("luckydog_token") == true) goto L18;
        return false;
    L18:
        if (TextUtils.isEmpty(r100.get("luckydog_token")) == true) goto L29;
        return true;
    L29:
        return false;
    }

    public static void c(Map<String, String> r100) {
        e.b("putCommonParams called");
        if (rm7.c.a.f538587a.f538578c == true) goto L6;
        e.a("putCommonParams() sdk没有初始化，返回空");
        return;
    L6:
        qm7.c r101 = qm7.c.a.f533904a;
        r100.put("luckydog_base", r101.b());
        r100.put("luckydog_data", r101.c());
        r100.put("luckydog_token", r101.d());
    }

    public static void a(Uri.Builder r100, Map<String, String> r101) {
        HashMap r102 = (HashMap) r101;
        if (r102.size() <= 0) goto L26;
        Set<String> r103 = UriProtector.getQueryParameterNames(r100.build());     // Catch: Throwable -> L14
        Iterator r104 = r102.entrySet().iterator();     // Catch: Throwable -> L14
    L7:
        if (r104.hasNext() == false) goto L27;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L14
        String r106 = (String) r105.getKey();     // Catch: Throwable -> L14
        String r107 = (String) r105.getValue();     // Catch: Throwable -> L14
        if (r103.contains(r106) == true) goto L7;
        if (TextUtils.isEmpty(r107) == true) goto L7;
        r100.appendQueryParameter(r106, r107);     // Catch: Throwable -> L14
        goto L7
    L27:
        return;
    L14:
        th = move-exception;
        e.b(th.getLocalizedMessage());
        return;
    }
}
