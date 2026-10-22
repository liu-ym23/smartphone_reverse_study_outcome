package com.bytedance.ee.bear.wikiv2.home.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceClassification;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.b;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class GetSpaceClassificationPuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public boolean need_filter;

        public Params(boolean r100) {
            this.need_filter = r100;
        }
    }

    public static class Result implements NonProguard {
        public List<WikiSpaceClassification> class_list;

        public Result() {
        }
    }

    public GetSpaceClassificationPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/space/class/get/", 2, 1);
    }
}
