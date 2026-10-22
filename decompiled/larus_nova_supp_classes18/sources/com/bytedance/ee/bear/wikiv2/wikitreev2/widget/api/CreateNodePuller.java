package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CreateNodePuller extends b<Params, TreeNode> {

    public static class Params implements NonProguard {
        public boolean expand_shortcut;
        public String ext_info_str;
        public int node_type;
        public String obj_token;
        public int obj_type;
        public String parent_wiki_token;
        public String space_id;
        public String synergy_uuid;
        public String template_token;
        public String time_zone;
        public String title;
        public String wiki_token;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "', parent_wiki_token='" + yu5.c.j(this.parent_wiki_token) + "', title='" + yu5.c.j(this.title) + "', obj_type='" + this.obj_type + "'}";
        }

        public Params(String r1, String r2, String r3, int r4, String r5) {
            this.space_id = r1;
            this.parent_wiki_token = r2;
            this.title = r3;
            this.obj_type = r4;
            this.wiki_token = "";
            this.node_type = 0;
            this.synergy_uuid = r5;
            this.expand_shortcut = true;
            this.time_zone = zu5.b.c();
        }

        public Params(String r1, String r2, String r3, String r4, int r5) {
            this.space_id = r1;
            this.parent_wiki_token = r2;
            this.title = r3;
            this.wiki_token = "";
            this.obj_token = r4;
            this.obj_type = r5;
            this.node_type = 1;
            this.time_zone = zu5.b.c();
        }

        public Params(String r1, String r2, String r3, String r4, String r5) {
            this.space_id = r1;
            this.parent_wiki_token = r2;
            this.title = r3;
            this.wiki_token = r4;
            this.node_type = 1;
            this.synergy_uuid = r5;
        }
    }

    public CreateNodePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/tree/create_node/", 1, 1);
    }
}
