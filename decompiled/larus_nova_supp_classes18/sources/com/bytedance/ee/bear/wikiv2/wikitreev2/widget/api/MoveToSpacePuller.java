package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class MoveToSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public boolean move_to_owner_space;
        public String space_folder_token;
        public String synergy_uuid;
        public String wiki_token;

        public String toString() {
            return "Params{wiki_token='" + yu5.c.j(this.wiki_token) + "'space_folder_token='" + yu5.c.j(this.space_folder_token) + "'synergy_uuid='" + this.synergy_uuid + "'move_to_owner_space='" + this.move_to_owner_space + "'}";
        }

        public Params(String r2, String r3) {
            this.move_to_owner_space = true;
            this.wiki_token = r2;
            this.synergy_uuid = r3;
        }

        public Params(String r1, String r2, boolean r3) {
            this.wiki_token = r1;
            this.space_folder_token = r2;
            this.move_to_owner_space = r3;
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

    public MoveToSpacePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/tree/move_to_space/", 1, 1);
    }
}
