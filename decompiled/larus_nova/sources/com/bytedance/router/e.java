package com.bytedance.router;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f267544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f267545b;

    public e() {
        this.f267544a = null;
        this.f267545b = new Object();
        this.f267544a = new HashMap();
    }

    public final String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        Map<String, String> r101 = this.f267544a;
        HashMap r102 = (HashMap) r101;
        String r103 = (String) r102.get(u97.b.a(r100));
        if (TextUtils.isEmpty(r103) == false) goto L10;
        Map<String, String> r104 = this.f267544a;
        HashMap r105 = (HashMap) r104;
        r103 = (String) r105.get(u97.b.b(r100));
    L10:
        return r103;
    }
}
