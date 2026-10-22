package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes41.dex */
public final class ae implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f462540a = "SpCache";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f462541b = "com.vivo.push.cache";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f462542c;

    public ae() {
    }

    public final void a() {
        SharedPreferences.Editor r100 = this.f462542c.edit();
        if (r100 == null) goto L5;
        r100.clear();
        c.a(r100);
    L5:
        t.d(f462540a, "system cache is cleared");
    }

    @Override // com.vivo.push.util.e
    public final boolean a(Context r100) {
        if (this.f462542c != null) goto L7;
        this.f462542c = r100.getSharedPreferences(f462541b, 0);
        return true;
    L7:
        return true;
    }

    @Override // com.vivo.push.util.e
    public final String a(String r100, String r101) {
        String r102 = this.f462542c.getString(r100, r101);
        t.d(f462540a, "getString " + r100 + " is " + r102);
        return r102;
    }
}
