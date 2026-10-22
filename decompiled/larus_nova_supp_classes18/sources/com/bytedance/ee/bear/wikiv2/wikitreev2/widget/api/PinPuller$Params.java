package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PinPuller$Params implements NonProguard {
    public boolean pinToFirst;
    public String token;
    public int type;

    public String toString() {
        return "Params{token='" + yu5.c.j(this.token) + "'type='" + this.type + "'pinToFirst='" + this.pinToFirst + "'}";
    }

    public PinPuller$Params(String r1, int r2) {
        this.token = r1;
        this.type = r2;
        this.pinToFirst = qc5.a.f();
    }
}
