package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiBrowseReportPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String token;

        public String toString() {
            return "Params{token='" + yu5.c.j(this.token) + "'}";
        }

        public Params(String r1) {
            this.token = r1;
        }
    }

    public static class Result implements NonProguard {
        public boolean is_success;

        public Result() {
        }
    }

    public WikiBrowseReportPuller(NetService r3) {
        super(r3, "/space/api/wiki/v2/search/wiki_browse_report/", 1, 1);
    }
}
