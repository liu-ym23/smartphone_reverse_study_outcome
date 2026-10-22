package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class MoveToSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public boolean move_to_owner_space;
        public String space_folder_token;
        public String synergy_uuid;
        public String wiki_token;

        public String toString() {
            return "Params{wiki_token='" + yu5.c.j(this.wiki_token) + "'space_folder_token='" + yu5.c.j(this.space_folder_token) + "'synergy_uuid='" + this.synergy_uuid + "'move_to_owner_space='" + this.move_to_owner_space + "'}";
        }

        public Params(String r100, String r101) {
            this.move_to_owner_space = true;
            this.wiki_token = r100;
            this.synergy_uuid = r101;
        }

        public Params(String r100, String r101, boolean r102) {
            this.wiki_token = r100;
            this.space_folder_token = r101;
            this.move_to_owner_space = r102;
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

    public MoveToSpacePuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/move_to_space/", 1, 1);
    }
}
