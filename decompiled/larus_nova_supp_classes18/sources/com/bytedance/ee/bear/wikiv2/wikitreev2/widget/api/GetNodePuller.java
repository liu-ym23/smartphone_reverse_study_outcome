package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class GetNodePuller extends b<Params, TreeNode> {

    public static class Params implements NonProguard {
        public boolean expand_shortcut;
        public boolean need_star;
        public String space_id;
        public Integer thumbnail_mode;
        public String wiki_token;
        public boolean with_deleted;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'wiki_token='" + yu5.c.j(this.wiki_token) + "'need_star='" + this.need_star + "'}";
        }

        public Params setThumbnailMode(Integer r1) {
            this.thumbnail_mode = r1;
            return this;
        }

        public Params(String r2, String r3) {
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r2;
            this.wiki_token = r3;
        }

        public Params(String r2, String r3, boolean r4) {
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r2;
            this.wiki_token = r3;
            this.need_star = r4;
            this.expand_shortcut = true;
            this.with_deleted = true;
        }
    }

    public GetNodePuller(NetService r4) {
        super(r4, "/space/api/wiki/v2/tree/get_node/", 2, 1);
    }
}
