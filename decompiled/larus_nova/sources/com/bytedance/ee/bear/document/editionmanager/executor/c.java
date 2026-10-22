package com.bytedance.ee.bear.document.editionmanager.executor;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f219617a;

    public static class a implements NetService.c<Result> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r100) throws NetService.ParseException {
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, Result.class);
        }
    }

    public c(NetService r100) {
        this.f219617a = r100;
    }
}
