package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class GetMyLibraryPuller extends b<Params, SpaceInfo> {

    public static class Params implements NonProguard {
        public Params() {
        }
    }

    public GetMyLibraryPuller(NetService r4) {
        super(r4, "/space/api/wiki/v2/space/my_library/get/", 2, 1);
    }
}
