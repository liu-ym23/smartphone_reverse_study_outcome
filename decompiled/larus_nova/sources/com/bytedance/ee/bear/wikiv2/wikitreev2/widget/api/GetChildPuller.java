package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.alibaba.fastjson.TypeReference;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class GetChildPuller extends b<Params, HashMap<String, List<TreeNode>>> {

    public static class Params implements NonProguard {
        public boolean expand_shortcut;
        public String space_id;
        public String wiki_token;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "', wiki_token='" + yu5.c.j(this.wiki_token) + "'}";
        }

        public Params(String r100, String r101) {
            this.space_id = r100;
            this.wiki_token = r101;
            this.expand_shortcut = true;
        }
    }

    public class a extends TypeReference<Result<HashMap<String, List<TreeNode>>>> {
        public a() {
        }
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b
    public final Type b() throws IllegalStateException {
        return new a().getType();
    }

    public GetChildPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/get_node_child/", 2, 1);
    }
}
