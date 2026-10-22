package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DelSingleNodePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public int apply;
        public int auto_delete_mode;
        public String space_id;
        public String synergy_uuid;
        public String wiki_token;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "', wiki_token='" + yu5.c.j(this.wiki_token) + "', apply ='" + this.apply + "'}";
        }

        public Params(String r1, String r2, String r3) {
            this.space_id = r1;
            this.wiki_token = r2;
            this.synergy_uuid = r3;
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
            this.auto_delete_mode = 3;
        L6:
            this.apply = 1;
            return;
        L5:
            this.auto_delete_mode = 2;
            goto L6
        }
    }

    public static class Result implements NonProguard {
        public String task_id;

        public Result() {
        }

        public String toString() {
            return "Result{task_id=" + this.task_id + '}';
        }
    }

    public DelSingleNodePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/tree/del_single_node/", 1, 1);
    }
}
