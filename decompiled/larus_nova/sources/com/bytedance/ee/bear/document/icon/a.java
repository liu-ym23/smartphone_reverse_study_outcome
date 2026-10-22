package com.bytedance.ee.bear.document.icon;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f219986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f219987b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.icon.a$a, reason: collision with other inner class name */
    public static final class C3133a {
    }

    static {
    }

    public final Map<String, String> a(String r100) {
        HashMap r101 = new HashMap();
        r101.put("action", r100);
        r101.put("file_id", du5.b.g(d25.d.f466517d));
        String r102 = this.f219987b;
        if (r102 != null) goto L5;
        r102 = sbb.e.f541294e.getType();
    L5:
        r101.put("file_type", r102);
        r101.put(EventConstant.Key.MODULE, "doc");
        return r101;
    }

    public a(com.bytedance.ee.bear.contract.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "analyticService");
        this.f219986a = r100;
        this.f219987b = r101;
    }
}
