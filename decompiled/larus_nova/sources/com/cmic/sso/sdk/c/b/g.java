package com.cmic.sso.sdk.c.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class g {
    public g() {
    }

    public abstract String a();

    public abstract String a_(String r100);

    public abstract JSONObject b();

    public String w(String r100) {
        return com.cmic.sso.sdk.e.d.a(a_(r100)).toLowerCase();
    }
}
