package com.bytedance.lynx.webview.cloudservice;

import com.bytedance.lynx.webview.internal.EventStatistics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements p07.a {
    public e() {
    }

    @Override // p07.a
    public final void a(String r100, Map<String, String> r101) {
        HashMap r102 = new HashMap();
        Iterator r103 = ((HashMap) r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), (String) r104.getValue());
        goto L4
    L6:
        EventStatistics.d(r100, r102, r102);
    }
}
