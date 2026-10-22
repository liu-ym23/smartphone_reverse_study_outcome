package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
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

        public Params setThumbnailMode(Integer r100) {
            this.thumbnail_mode = r100;
            return this;
        }

        public Params(String r100, String r101) {
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r100;
            this.wiki_token = r101;
        }

        public Params(String r100, String r101, boolean r102) {
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r100;
            this.wiki_token = r101;
            this.need_star = r102;
            this.expand_shortcut = true;
            this.with_deleted = true;
        }
    }

    public GetNodePuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/get_node/", 2, 1);
    }
}
