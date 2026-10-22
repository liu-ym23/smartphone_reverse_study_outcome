package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class GetFavoriteRelationPuller extends b<Params, Result> {

    public static class Data implements NonProguard {
        public HashMap<String, TreeNode> nodes;
        public List<String> root_list;

        public Data() {
        }
    }

    public static class Params implements NonProguard {
        public boolean expand_shortcut;
        public String space_id;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'}";
        }

        public Params(String r100) {
            this.space_id = r100;
            this.expand_shortcut = true;
        }
    }

    public static class Result implements NonProguard {
        public Data favorite_node_list;

        public Result() {
        }

        public String toString() {
            Data r100 = this.favorite_node_list;
            if (r100 == null) goto L5;
            int r101 = hu5.a.c(r100.root_list);
        L7:
            return "Result{root_list=" + r101 + '}';
        L5:
            r101 = 0;
            goto L7
        }
    }

    public GetFavoriteRelationPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/star/get_favorite_info/", 2, 1);
    }
}
