package com.xiaomi.push;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes41.dex */
public class be extends JSONArray implements bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463186a;

    @Override // com.xiaomi.push.bd
    public int a() {
        return this.f463186a + (length() - 1);
    }

    public be() {
        this.f463186a = 2;
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object r100) {
        if ((r100 instanceof bd) == false) goto L6;
        this.f463186a += ((bd) r100).a();
    L6:
        return super.put(r100);
    }
}
