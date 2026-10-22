package com.cmic.ida.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public abstract class i0 {
    public abstract String a();

    public abstract String a(String r100);

    public abstract JSONObject b();

    public i0() {
    }

    public String b(String r100) {
        return v.a(a(r100)).toLowerCase();
    }
}
