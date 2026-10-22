package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CopyToSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public boolean async;
        public String parent_token;
        public String space_id;
        public String time_zone;
        public String title;
        public String wiki_token;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'wiki_token='" + yu5.c.j(this.wiki_token) + "'parent_token='" + yu5.c.j(this.parent_token) + "'title='" + yu5.c.j(this.title) + "'async='" + this.async + "'}";
        }

        public Params(String r1, String r2, String r3, String r4, boolean r5) {
            this.space_id = r1;
            this.wiki_token = r2;
            this.parent_token = r3;
            this.title = r4;
            this.time_zone = zu5.b.c();
            if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.sheet.async_make_copy", false) == false) goto L6;
            this.async = r5;
            return;
        }
    }

    public static class Result implements NonProguard {
        public String obj_token;
        public String token;
        public String url;

        public Result() {
        }
    }

    public CopyToSpacePuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/tree/node/copy_to_space/", 1, 1);
    }
}
