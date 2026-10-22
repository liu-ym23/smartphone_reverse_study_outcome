package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class GetSpaceInfoPuller extends b<Params, HashMap<String, SpaceInfo>> {

    public static class Params implements NonProguard {
        public String space_id;
        public Integer thumbnail_mode;

        public String toString() {
            return "Params{space_id='" + yu5.c.j(this.space_id) + "'}";
        }

        public Params(String r100) {
            this.thumbnail_mode = Integer.valueOf(AppInfoUtils.f().booleanValue() ? 1 : 0);
            this.space_id = r100;
        }

        public Params setThumbnailMode(Integer r100) {
            this.thumbnail_mode = r100;
            return this;
        }
    }

    public GetSpaceInfoPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/space/get_space_info/", 2, 1);
    }
}
