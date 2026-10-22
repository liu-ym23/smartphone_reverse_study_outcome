package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CopyNodePuller extends b<Params, TreeNode> {

    public static class Params implements NonProguard {
        public boolean async;
        public String space_id;
        public String target_space_id;
        public String target_wiki_token;
        public String time_zone;
        public String title;
        public String wiki_token;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "', wiki_token='" + yu5.c.j(this.wiki_token) + "', target_space_id='" + yu5.c.j(this.target_space_id) + "', target_wiki_token='" + yu5.c.j(this.target_wiki_token) + "', title='" + yu5.c.j(this.title) + "', time_zone='" + this.time_zone + "', async='" + this.async + "'}";
        }

        public Params(String r1, String r2, String r3, String r4, String r5, boolean r6) {
            this.space_id = r1;
            this.wiki_token = r2;
            this.target_space_id = r3;
            this.target_wiki_token = r4;
            this.title = r5;
            this.time_zone = zu5.b.c();
            if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.sheet.async_make_copy", false) == false) goto L6;
            this.async = r6;
            return;
        }
    }

    public CopyNodePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/tree/node/copy/", 1, 1);
    }
}
