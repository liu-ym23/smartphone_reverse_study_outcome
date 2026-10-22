package com.larus.account.saas.security.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286506a = 0;

    static {
    }

    public static void a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "extras");
        JSONObject r102 = new JSONObject();
        r102.put("result", r100);
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
        goto L4
    L6:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("account_security_event", r102.toString());
    }
}
