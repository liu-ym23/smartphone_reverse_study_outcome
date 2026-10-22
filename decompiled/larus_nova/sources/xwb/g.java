package xwb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class g {
    public g() {
    }

    public static void a(Object r100, String r101) {
        if ((r100 instanceof HashMap) == false) goto L22;
        Iterator r102 = ((HashMap) r100).keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L32;
        Object r103 = r102.next();
        Object r104 = ((Map) r100).get(r103);
        StringBuilder r105 = new StringBuilder();
        r105.append(r101);
        r105.append("key: ");
        r105.append(r103);
        r105.append("--value length: ");
        if (r104 != null) goto L10;
        int r106 = 0;
    L20:
        r105.append(r106);
        com.ss.android.lark.officesdk.utils.di.j.e("BridgeInfoPrinter", r105.toString());
        goto L6
    L10:
        if ((r104 instanceof String) == false) goto L13;
        r106 = ((String) r104).length();
        goto L20
    L13:
        if ((r104 instanceof JSONObject) == false) goto L16;
        r106 = ((JSONObject) r104).toString().length();
        goto L20
    L16:
        if ((r104 instanceof com.alibaba.fastjson.JSONObject) == false) goto L18;
        r106 = ((com.alibaba.fastjson.JSONObject) r104).toJSONString().length();
        goto L20
    L18:
        r106 = r104.toString().length();
        goto L20
    L32:
        return;
    L22:
        if ((r100 instanceof String) == false) goto L31;
        com.ss.android.lark.officesdk.utils.di.j.e("BridgeInfoPrinter", r101 + ((String) r100).length());
        return;
    }
}
