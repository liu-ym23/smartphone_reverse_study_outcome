package com.bytedance.ee.bear.drive.view.preview.wps;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller;

/* JADX INFO: loaded from: classes16.dex */
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

    public WpsGrayStrategyPuller(NetService r100) {
        super(r100, "/api/box/third/gray_strategy");
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.api.BasePuller
    public final NetService.f buildRequest(String r100, BasePuller.Params r101) {
        NetService.f r102 = new NetService.f(r100);
        r102.f216913j = null;
        r102.f216906c = 2;
        r102.b("third_source", String.valueOf(((Params) r101).third_source));
        return r102;
    }
}
