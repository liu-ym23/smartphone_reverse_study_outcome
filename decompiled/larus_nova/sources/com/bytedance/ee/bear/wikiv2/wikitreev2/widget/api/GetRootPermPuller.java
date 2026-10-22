package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class GetRootPermPuller extends b<Params, HashMap<String, SpacePerm>> {

    public static class Params implements NonProguard {
        public String space_id;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'}";
        }

        public Params(String r100) {
            this.space_id = r100;
        }
    }

    public GetRootPermPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/perm/space/", 2, 1);
    }
}
