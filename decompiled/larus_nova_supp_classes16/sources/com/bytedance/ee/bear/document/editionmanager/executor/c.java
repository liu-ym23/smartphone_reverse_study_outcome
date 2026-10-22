package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final NetService a;

    public static class a implements NetService.c<Result> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r3) throws NetService.ParseException {
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, Result.class);
        }
    }

    public c(NetService r1) {
        this.a = r1;
    }
}
