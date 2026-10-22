package com.ss.ugc.effectplatform.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458043a = 0;

    static {
    }

    public static String a(Map r100, String r101) {
        StringBuilder r102 = new StringBuilder(r101);
        if ((!r100.isEmpty()) == false) goto L17;
        r102.append("?");
        Iterator r103 = r100.entrySet().iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L17;
        Map.Entry r105 = (Map.Entry) r103.next();
        String r106 = (String) r105.getKey();
        String r107 = (String) r105.getValue();
        if (r.b(r106) == true) goto L15;
        if (r.b(r107) == true) goto L15;
        if (r104 != 0) goto L14;
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        goto L15
    L14:
        r102.append("&");
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
    L15:
        r104 = r104 + 1;
    L17:
        return r102.toString();
    }
}
