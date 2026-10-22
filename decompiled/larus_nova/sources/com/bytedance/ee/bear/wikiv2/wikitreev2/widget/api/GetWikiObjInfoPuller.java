package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class GetWikiObjInfoPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String wiki_token;

        public String toString() {
            return "Params{wiki_token='" + yu5.c.j(this.wiki_token) + "'}";
        }

        public Params(String r100) {
            this.wiki_token = r100;
        }
    }

    public static class Result implements NonProguard {
        public boolean is_wiki;
        public String obj_token;
        public int obj_type;
        public String space_id;
        public String wiki_token;

        public String toString() {
            return "Result{obj_token='" + yu5.c.j(this.obj_token) + "', obj_type=" + this.obj_type + ", space_id='" + yu5.c.j(this.space_id) + "', wiki_token='" + yu5.c.j(this.wiki_token) + "', is_wiki=" + this.is_wiki + '}';
        }

        public Result() {
            this.obj_type = -1;
        }
    }

    public GetWikiObjInfoPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/obj/info/", 2, 1);
    }
}
