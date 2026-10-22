package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UnPinPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String token;
        public int type;

        public String toString() {
            return "Params{token='" + yu5.c.j(this.token) + "'type='" + this.type + "'}";
        }

        public Params(String r1, int r2) {
            this.token = r1;
            this.type = r2;
        }
    }

    public static class Result implements NonProguard {
        public Result() {
        }
    }

    public UnPinPuller(NetService r4) {
        super(r4, "/space/api/explorer/pin/remove/", 1, 3);
    }
}
