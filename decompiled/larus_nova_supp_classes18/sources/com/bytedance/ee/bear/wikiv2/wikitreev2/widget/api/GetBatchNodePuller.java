package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class GetBatchNodePuller extends b<Params, ArrayList<TreeNode>> {

    public static class Params implements NonProguard {
        public List<String> wiki_tokens;

        public String toString() {
            return "Params{wiki_tokens='" + yu5.c.j(this.wiki_tokens.toString()) + "'}";
        }

        public Params(List<String> r1) {
            this.wiki_tokens = r1;
        }
    }

    public GetBatchNodePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/tree/m_get_node_info/", new e());
    }
}
