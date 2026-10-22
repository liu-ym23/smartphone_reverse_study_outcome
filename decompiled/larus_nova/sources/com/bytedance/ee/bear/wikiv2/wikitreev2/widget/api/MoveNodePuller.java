package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class MoveNodePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String new_parent_wiki_token;
        public String new_space_id;
        public String old_parent_wiki_token;
        public String old_space_id;
        public String previous_token;
        public String synergy_uuid;
        public boolean to_Last;
        public String wiki_token;

        public String toString() {
            return "Params{old_space_id='" + yu5.c.j(this.old_space_id) + "'new_space_id='" + yu5.c.j(this.new_space_id) + "', old_parent_wiki_token='" + yu5.c.j(this.old_parent_wiki_token) + "', new_parent_wiki_token='" + yu5.c.j(this.new_parent_wiki_token) + "', wiki_token='" + yu5.c.j(this.wiki_token) + "', previous_token='" + yu5.c.j(this.previous_token) + "', to_Last='" + this.to_Last + "'}";
        }

        public Params(String r100, String r101, String r102, String r103, String r104, String r105) {
            this.previous_token = "";
            this.to_Last = true;
            this.old_space_id = r100;
            this.new_space_id = r102;
            this.old_parent_wiki_token = r101;
            this.new_parent_wiki_token = r103;
            this.wiki_token = r104;
            this.synergy_uuid = r105;
        }
    }

    public static class Result implements NonProguard {
        public double sort_id;

        public Result() {
        }

        public String toString() {
            return "Result{sort_id=" + this.sort_id + '}';
        }
    }

    public MoveNodePuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/move_node/", 1, 1);
    }
}
