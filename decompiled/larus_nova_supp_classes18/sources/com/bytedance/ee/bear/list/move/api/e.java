package com.bytedance.ee.bear.list.move.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements NetService.c<Result<SpaceMoveToWikiStatusPuller$Result>> {

    public class a extends TypeToken<Result<SpaceMoveToWikiStatusPuller$Result>> {
        public a() {
        }
    }

    public e() {
    }

    public final Result<SpaceMoveToWikiStatusPuller$Result> parse(String r3) {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new a().getType());
    }
}
