package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class GetNodePermPuller extends b<Params, WikNodePerm> {

    public static class Params implements NonProguard {
        public String space_id;
        public String wiki_token;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'wiki_token='" + yu5.c.j(this.wiki_token) + "'}";
        }

        public Params(String r100, String r101) {
            this.space_id = r100;
            this.wiki_token = r101;
        }
    }

    public GetNodePermPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/perm/node/", new f());
    }
}
