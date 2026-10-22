package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WpsGrayStrategyPuller extends BasePuller<Params, Result> {

    public static class Params extends BasePuller.Params {
        public int third_source;

        public Params() {
            this.third_source = 1;
        }
    }

    public static class Result extends BasePuller.Result {
        public String env;

        public String toString() {
            return "Result{env='" + this.env + "'}";
        }

        public Result() {
        }
    }

    public WpsGrayStrategyPuller(NetService r2) {
        super(r2, "/api/box/third/gray_strategy");
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller
    public final NetService.f buildRequest(String r2, BasePuller.Params r3) {
        NetService.f r0 = new NetService.f(r2);
        r0.j = null;
        r0.c = 2;
        r0.b("third_source", String.valueOf(((Params) r3).third_source));
        return r0;
    }
}
