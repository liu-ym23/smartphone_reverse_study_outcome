package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class StarSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String space_id;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'}";
        }

        public Params(String r1) {
            this.space_id = r1;
        }
    }

    public static class Result implements NonProguard {
        public boolean is_success;

        public Result() {
        }
    }

    public StarSpacePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/space/star/add/", 1, 1);
    }
}
