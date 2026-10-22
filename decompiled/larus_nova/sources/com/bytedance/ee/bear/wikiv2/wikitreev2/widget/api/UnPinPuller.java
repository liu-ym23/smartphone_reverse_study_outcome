package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class UnPinPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String token;
        public int type;

        public String toString() {
            return "Params{token='" + yu5.c.j(this.token) + "'type='" + this.type + "'}";
        }

        public Params(String r100, int r101) {
            this.token = r100;
            this.type = r101;
        }
    }

    public static class Result implements NonProguard {
        public Result() {
        }
    }

    public UnPinPuller(NetService r100) {
        super(r100, "/space/api/explorer/pin/remove/", 1, 3);
    }
}
