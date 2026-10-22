package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
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

        public Params(String r100, String r101, String r102, String r103, String r104, boolean r105) {
            this.space_id = r100;
            this.wiki_token = r101;
            this.target_space_id = r102;
            this.target_wiki_token = r103;
            this.title = r104;
            this.time_zone = zu5.b.c();
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.sheet.async_make_copy", false) == false) goto L6;
            this.async = r105;
            return;
        }
    }

    public CopyNodePuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/node/copy/", 1, 1);
    }
}
