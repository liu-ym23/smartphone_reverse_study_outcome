package com.bytedance.ee.bear.drive.loader.download.platform.api.imfile;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;
import com.bytedance.ee.bear.quoto.t;
import org.koin.java.a;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SaveToSpaceV2Puller extends BasePuller<Params, Result> {
    private static final String REQUEST_URL = "/api/box/stream/sdk/file/save/";

    public static class Params extends BasePuller.Params {
        public String app_file_id;
        public String app_id;
        public String auth_extra;
        public boolean size_checker;

        public String toString() {
            return "Params{app_id='" + c.j(this.app_id) + "', app_file_id='" + c.j(this.app_file_id) + "', auth_extra='" + c.j(this.auth_extra) + "', size_checker='" + this.size_checker + "'}";
        }

        public Params(String r1, String r2, String r3) {
            this.app_id = r1;
            this.app_file_id = r2;
            this.auth_extra = r3;
            this.size_checker = ((t) a.a(t.class)).e();
        }
    }

    public static class Result extends BasePuller.Result {
        public String file_token;

        public Result() {
        }
    }

    public SaveToSpaceV2Puller(NetService r2) {
        super(r2, REQUEST_URL);
    }
}
