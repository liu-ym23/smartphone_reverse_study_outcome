package com.bytedance.lark.policy.decision;

import com.bytedance.lark.policy.model.ValidateRequest;
import com.bytedance.lark.policy.model.b0;
import com.bytedance.lark.policy.utils.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f253798a = null;

    static {
        f253798a = new d();
    }

    public d() {
    }

    public static Map a(Map r110, String r111) {
        Logger.c("RemoteDecisionService", "generateErrorResponse");
        LinkedHashMap r100 = new LinkedHashMap(MapsKt.mapCapacity(r110.size()));
        Iterator r112 = r110.entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L6;
        Map.Entry r101 = (Map.Entry) r112.next();
        r100.put(r101.getKey(), new b0("PERMIT", ((ValidateRequest) r101.getValue()).c(), null, false, null, r111, null, 92));
        goto L4
    L6:
        return r100;
    }
}
