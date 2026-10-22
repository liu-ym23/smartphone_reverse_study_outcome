package fo6;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    public static void a(Intent r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        com.bytedance.locallife.biz.common.utils.c.b("LifeRouterManager", "Slice url params but the url is null!!!");
        Map r102 = Collections.EMPTY_MAP;
    L21:
        if (r102 != null) goto L23;
        return;
    L23:
        if (r102.isEmpty() == true) goto L42;
        Iterator r103 = r102.entrySet().iterator();
    L27:
        if (r103.hasNext() == false) goto L43;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r100.hasExtra((String) r104.getKey()) == true) goto L27;
        r100.putExtra((String) r104.getKey(), (String) r104.getValue());
        goto L27
    L43:
        return;
    L42:
        return;
    L7:
        Uri r105 = UriProtector.parse(r101);
        if (r105.isHierarchical() == true) goto L10;
        r102 = Collections.EMPTY_MAP;
        goto L21
    L10:
        Iterator<String> r106 = UriProtector.getQueryParameterNames(r105).iterator();
        HashMap r107 = new HashMap();
    L12:
        if (r106.hasNext() == false) goto L20;
        String r108 = r106.next();
        if (TextUtils.isEmpty(r108) == true) goto L12;
        String r109 = UriProtector.getQueryParameter(r105, r108);
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        r107.put(r108, r109);
        goto L12
    L20:
        r102 = r107;
        goto L21
    }
}
