package com.bytedance.ee.bear.templates.preview.announce;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AnnounceTemplateAnalytic {
    public static final Lazy a = null;
    public static final JSONObject b = null;

    static {
        Lazy r0 = LazyKt.lazy(AnnounceTemplateAnalytic$analyticService$2.INSTANCE);
        a = r0;
        b = new JSONObject();
        HashMap r1 = ((com.bytedance.ee.bear.contract.d) r0.getValue()).m("docCommonParams");
        if ((!r1.isEmpty()) == false) goto L8;
        Iterator r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) r2.next();
        b.put((String) r3.getKey(), r3.getValue());
        goto L6
    L10:
        return;
    }
}
