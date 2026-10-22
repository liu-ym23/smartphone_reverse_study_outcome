package com.bytedance.ee.bear.wikiv2.home.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b;
import com.bytedance.ee.util.io.NonProguard;
import hu5.a;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class GetSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String last_label;
        public int size;
        public String space_class_id;
        public Integer type;

        public Params() {
        }

        public String toString() {
            return "Params{type='" + this.type + "', size=" + this.size + ", last_label='" + this.last_label + "', space_class_id='" + this.space_class_id + "'}";
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

    public GetSpacePuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/space/get/", 2, 1);
    }
}
