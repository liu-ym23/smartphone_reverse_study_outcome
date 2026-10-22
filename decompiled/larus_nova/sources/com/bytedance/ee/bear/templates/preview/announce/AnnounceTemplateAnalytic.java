package com.bytedance.ee.bear.templates.preview.announce;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes18.dex */
public final class AnnounceTemplateAnalytic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f239132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f239133b = null;

    static {
        Lazy r100 = LazyKt.lazy(AnnounceTemplateAnalytic$analyticService$2.INSTANCE);
        f239132a = r100;
        f239133b = new JSONObject();
        HashMap<String, Object> r101 = ((com.bytedance.ee.bear.contract.d) r100.getValue()).m("docCommonParams");
        if ((!r101.isEmpty()) == false) goto L8;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, Object> r103 = r102.next();
        f239133b.put(r103.getKey(), r103.getValue());
        goto L6
    L10:
        return;
    }
}
