package com.bytedance.ee.bear.wikiv2.home.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b;
import com.bytedance.ee.util.io.NonProguard;
import hu5.a;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class GetStarSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String last_label;
        public int size;

        public Params() {
        }
    }

    public static class Result implements NonProguard {
        public boolean has_more;
        public String last_label;
        public List<SpaceBean> spaces;

        public Result() {
        }

        public String toString() {
            return "Result{spaces=" + a.c(this.spaces) + ", last_label='" + this.last_label + "', has_more=" + this.has_more + '}';
        }
    }

    public GetStarSpacePuller(NetService r4) {
        super(r4, "/space/api/wiki/v2/space/star/get/", 2, 1);
    }
}
