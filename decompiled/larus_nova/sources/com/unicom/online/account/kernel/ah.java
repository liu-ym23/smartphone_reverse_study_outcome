package com.unicom.online.account.kernel;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class ah {
    public static String a(String r100, String r101) {
        StringBuffer r102 = new StringBuffer();
        Iterator<Map.Entry<?, ?>> r103 = a(new JSONObject(r100).toString()).entrySet().iterator();     // Catch: Exception -> L16
        boolean r104 = true;
    L4:
        if (r103.hasNext() == false) goto L19;
        Map.Entry<?, ?> r105 = r103.next();     // Catch: Exception -> L16
        Object r106 = "";
        if (r104 == false) goto L10;
        String r107 = "";
    L11:
        r102.append(r107);     // Catch: Exception -> L16
        r102.append((String) r105.getKey());     // Catch: Exception -> L16
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L16
        if (r105.getValue() == null) goto L14;
        r106 = r105.getValue();     // Catch: Exception -> L16
    L14:
        r102.append(r106);     // Catch: Exception -> L16
        r104 = false;
        goto L4
    L10:
        r107 = r101;
    L19:
        return r102.toString();
    L16:
        e = move-exception;
        aj.a(e);
        goto L19
    }

    private static TreeMap<?, ?> a(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L8
        TreeMap<?, ?> r102 = new TreeMap();     // Catch: Exception -> L8
        Iterator<String> r103 = r101.keys();     // Catch: Exception -> L8
    L4:
        if (r103.hasNext() == false) goto L7;
        String r104 = r103.next();     // Catch: Exception -> L8
        r102.put(r104, JSONObjectProtectorUtils.getString(r101, r104));     // Catch: Exception -> L8
        goto L4
    L7:
        return r102;
    L8:
        e = move-exception;
        aj.a(e);
        return null;
    }
}
