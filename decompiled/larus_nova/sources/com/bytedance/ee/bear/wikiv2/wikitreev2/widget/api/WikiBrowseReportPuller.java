package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiBrowseReportPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String token;

        public String toString() {
            return "Params{token='" + yu5.c.j(this.token) + "'}";
        }

        public Params(String r100) {
            this.token = r100;
        }
    }

    public static class Result implements NonProguard {
        public boolean is_success;

        public Result() {
        }
    }

    public WikiBrowseReportPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/search/wiki_browse_report/", 1, 1);
    }
}
