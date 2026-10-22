package com.bytedance.ee.bear.list.move.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements NetService.c<Result<SpaceMoveToWikiPuller$Result>> {

    public class a extends TypeToken<Result<SpaceMoveToWikiPuller$Result>> {
        public a() {
        }
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<SpaceMoveToWikiPuller$Result> parse(String r100) {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new a().getType());
    }
}
