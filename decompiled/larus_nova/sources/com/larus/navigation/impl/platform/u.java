package com.larus.navigation.impl.platform;

import com.larus.applog.api.IApplog;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class u implements e37.i {
    public u() {
    }

    @Override // e37.i
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSONObject r102 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L6:
        IApplog.f287053a.reportEvent(r100, r102);
    }
}
