package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class PinPuller$Params implements NonProguard {
    public boolean pinToFirst;
    public String token;
    public int type;

    public String toString() {
        return "Params{token='" + yu5.c.j(this.token) + "'type='" + this.type + "'pinToFirst='" + this.pinToFirst + "'}";
    }

    public PinPuller$Params(String r100, int r101) {
        this.token = r100;
        this.type = r101;
        this.pinToFirst = qc5.a.f();
    }
}
